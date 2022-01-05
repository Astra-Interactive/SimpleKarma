package com.astrainteractive.karmaplugin.database

import com.astrainteractive.astralibs.Logger
import com.astrainteractive.karmaplugin.database.entities.Karma
import com.astrainteractive.karmaplugin.KarmaPlugin
import com.astrainteractive.karmaplugin.utils.callbackCatching
import com.astrainteractive.karmaplugin.utils.forEach
import java.util.*

object Repository {
    suspend fun createKarmaTable() =
        callbackCatching {

            val query = "CREATE TABLE IF NOT EXISTS ${Karma.table} " +
                    "(" +
                    Karma.Companion.Entity.values().joinToString(", ") { it.info.nameTypeExtra } +
                    ");"
            if (KarmaPlugin.pluginConfig.logging)
                Logger.log(query, "Repository")
            return@callbackCatching Database.connection.prepareStatement(query).execute()
        }

    suspend fun insertKarma(karma: Karma) = callbackCatching {
        val query = "INSERT INTO ${Karma.table} " +
                "(" + Karma.Companion.Entity.values().copyOfRange(1,Karma.Companion.Entity.values().size).joinToString(", ") { it.info.name } + ") " +
                "VALUES(" + "${karma.getInsertValues()}" + ")"
        if (KarmaPlugin.pluginConfig.logging)
            Logger.log("Command", query)
        return@callbackCatching Database.connection.createStatement().executeUpdate(query)
    }

    suspend fun getTotalKarma(uuid: String): Int? = callbackCatching {
        val command =
            "SELECT SUM(${Karma.Companion.Entity.amount.info.name}) " +
                    "FROM ${Karma.table} " +
                    "WHERE ${Karma.Companion.Entity.minecraftViolatorUUID.info.name} = '${uuid}'" +
                    ";"
        if (KarmaPlugin.pluginConfig.logging)
            Logger.log("Command", command)
        val rs = Database.connection.createStatement().executeQuery(command)
        rs.forEach { return@callbackCatching it.getInt(1) }
        return@callbackCatching null
    }
}