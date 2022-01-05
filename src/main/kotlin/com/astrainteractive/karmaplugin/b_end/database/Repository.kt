package com.astrainteractive.karmaplugin.b_end.database

import com.astrainteractive.astralibs.Logger
import com.astrainteractive.astralibs.catching
import com.astrainteractive.karmaplugin.b_end.database.entities.Karma
import com.astrainteractive.karmaplugin.f_end.plugin.KarmaPlugin
import java.sql.ResultSet

object Repository {
    fun createKarmaTable() =
        catching {
            val command = Karma.getTableCreationCommand()
            if(KarmaPlugin.config.logging)
                Logger.log("Command",command)
            Database.connection.prepareStatement(command).execute()
        }
    fun insertKarma(karma: Karma) = catching {
        val command = karma.getInsertQuery()
        if(KarmaPlugin.config.logging)
            Logger.log("Command",command?:"NULL INSERTION")
        Database.connection.createStatement().executeUpdate(command)
    }
    fun getSumKarma(player: String):Int? = catching {
        val command =
            "SELECT SUM(${Karma.karma.name}) " +
            "FROM ${Karma.table} " +
            "WHERE ${Karma.minecraftUsername.name} = '$player'" +
            ";"
        if(KarmaPlugin.config.logging)
            Logger.log("Command",command)
        val rs = Database.connection.createStatement().executeQuery(command)
        var res:Int? = null
        rs.forEach {
            res = rs.getInt("SUM(${Karma.karma.name})")
        }
        return res
    }

    private inline fun ResultSet.forEach(rs: (ResultSet) -> Unit) {
        while (this.next()) {
            rs(this)
        }
    }
    fun <T> ResultSet.asSequence(extract: () -> T): Sequence<T> = generateSequence {
        if (this.next()) extract() else null
    }
}