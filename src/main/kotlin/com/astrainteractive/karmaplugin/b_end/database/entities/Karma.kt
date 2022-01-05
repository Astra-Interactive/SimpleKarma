package com.astrainteractive.karmaplugin.b_end.database.entities

import com.astrainteractive.astralibs.Logger
import com.astrainteractive.karmaplugin.b_end.database.InsertQuery
import java.util.*


class Karma(val id: Int = -1,
            val minecraftUuid: String,
            val minecraftUsername: String,
            val discordId: String,
            val karma: Int,
            val date: Date,
            val reason: String){

    public fun getInsertQuery(): String?{
        val command = InsertQuery.Builder()
            .table(Karma.table)
            .columns(Karma.minecraftUuid.name, Karma.minecraftUsername.name,
                     Karma.discordId.name, Karma.karma.name,
                     Karma.date.name, Karma.reason.name)
            .values(minecraftUuid,minecraftUsername,
                    discordId,karma,date,reason)
            .build()
        return command
    }

    companion object {
        public fun getTableCreationCommand(): String {
            var command = "CREATE TABLE IF NOT EXISTS ${table} ("
            for (field in fields)
                command += "${field.line}, "
            command += primaryKeyConstraint
            command += ");"
            return command
        }

        private fun getMinecraftUuid(minecraftUsername: String): String{
            //TODO: implement appellation to users table
        }
        private fun getMinecraftDiscordId(minecraftUsername: String): String{
            //TODO: implement appellation to users table
        }

        public fun getByFields(player: String, value: Int, reason: String): Karma{
            return Karma(
                minecraftUuid = getMinecraftUuid(player),
                minecraftUsername = player,
                discordId = getMinecraftDiscordId(player),
                karma = value,
                date = Calendar.getInstance().time,
                reason = reason
            )
        }

        public fun getByPlayerAndValue(player: String, value: Int): Karma{
            return getByFields(player,value,"")
        }

        val table: String = "karma"

        val id: EntityInfo =
            EntityInfo("id", "INTEGER", "NOT NULL")
        val minecraftUuid: EntityInfo =
            EntityInfo("minecraft_uuid", "VARCHAR(16)", "NOT NULL")
        val minecraftUsername: EntityInfo =
            EntityInfo("minecraft_username", "VARCHAR(16)", "NOT NULL")
        val discordId: EntityInfo =
            EntityInfo("discord_id", "VARCHAR(32)", "NULL")
        val karma: EntityInfo =
            EntityInfo("karma", "SMALLINT", "NOT NULL")
        val date: EntityInfo =
            EntityInfo("date", "DATE", "NOT NULL")
        val reason: EntityInfo =
            EntityInfo("reason", "TEXT", "NOT NULL")

        val fields: List<EntityInfo> =
            listOf(id, minecraftUuid, minecraftUsername, discordId, karma, date, reason)

        val primaryKeyConstraint: String = "PRIMARY KEY (${id.name})"

    }
}