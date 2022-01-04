package com.astrainteractive.karmaplugin.b_end.database.entities


object KarmaEntity {

    public fun getTableCreationCommand(): String{
        var command = "CREATE TABLE IF NOT EXISTS ${table} ("
        for(field in fields)
            command += "${field.line}, "
            command += primaryKeyConstraint
            command += ");"
        return command
    }

    val table: String = "karma"

    val id: EntityInfo =
        EntityInfo("id", "INTEGER", "NOT NULL")
    val minecraft_uuid: EntityInfo =
        EntityInfo("minecraft_uuid", "VARCHAR(16)", "NOT NULL")
    val minecraft_username: EntityInfo =
        EntityInfo("minecraft_username", "VARCHAR(16)", "NOT NULL")
    val discord_id: EntityInfo =
        EntityInfo("discord_id", "VARCHAR(32)", "NULL")
    val karma: EntityInfo =
        EntityInfo("karma", "SMALLINT", "NOT NULL")
    val date: EntityInfo =
        EntityInfo("date", "DATE", "NOT NULL")
    val reason: EntityInfo =
        EntityInfo("reason", "TEXT", "NOT NULL")

    val fields: List<EntityInfo> =
        listOf(id, minecraft_uuid, minecraft_username, discord_id,karma, date, reason)

    val primaryKeyConstraint: String = "PRIMARY KEY (${id.name})"

}