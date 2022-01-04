package com.astrainteractive.karmaplugin.b_end.database.entities

import java.util.*


class KarmaEntity(val id: Int,
                  val minecraftUuid: String,
                  val minecraftUsername: String,
                  val discordId: String,
                  val karma: Int,
                  val date: Date,
                  val reason: String){
    companion object {
        public fun getTableCreationCommand(): String {
            var command = "CREATE TABLE IF NOT EXISTS ${table} ("
            for (field in fields)
                command += "${field.line}, "
            command += primaryKeyConstraint
            command += ");"
            return command
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