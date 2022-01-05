package com.astrainteractive.karmaplugin.database.entities

import com.astrainteractive.karmaplugin.utils.uuid
import org.bukkit.OfflinePlayer
import java.util.*


class Karma(
    val id: Int = -1,
    val minecraftViolatorUUID: String,
    val minecraftViolatorName: String?,
    val discordViolatorId: String?,
    val minecraftModerUUID: String,
    val minecraftModerName: String,
    val discordModerId: String?,
    val amount: Int,
    val date: Long,
    val reason: String
) {

    public fun getInsertValues(): String {
        return "\'$minecraftViolatorUUID\', " +
                "\'$minecraftViolatorName\', " +
                "\'$discordViolatorId\', " +
                "\'$minecraftModerUUID\', " +
                "\'$minecraftModerName\', " +
                "\'$discordModerId\', " +
                "$amount, " +
                "$date, " +
                "\'$reason\'"
    }
    constructor(player:OfflinePlayer,executed:OfflinePlayer,amount: Int,reason: String):this(
        id=-1,
        minecraftViolatorUUID=player.uuid,
        minecraftViolatorName=player.name,
        discordViolatorId=null,
        minecraftModerUUID=executed.uuid,
        minecraftModerName=executed.name?:"No name",
        discordModerId=null,
        amount=amount,
        date=System.currentTimeMillis(),
        reason=reason
    )

    companion object {
        val table: String
            get() = "karma"
        enum class Entity(val info: EntityInfo) {
            id(EntityInfo("id", "INTEGER", "PRIMARY KEY AUTOINCREMENT")),
            minecraftViolatorUUID(EntityInfo("minecraft_violator_uuid", "VARCHAR(16)", "NOT NULL")),
            minecraftViolatorName(EntityInfo("minecraft_violator_username", "VARCHAR(16)", "NOT NULL")),
            discordViolatorId(EntityInfo("discord_violator_id", "VARCHAR(16)", "NULL")),
            minecraftModerUUID(EntityInfo("minecraft_moder_uuid", "VARCHAR(16)", "NOT NULL")),
            minecraftModerName(EntityInfo("minecraft_moder_username", "VARCHAR(16)", "NOT NULL")),
            discordModerId(EntityInfo("discord_moder_id", "VARCHAR(16)", "NULL")),
            amount(EntityInfo("karma", "SMALLINT", "NOT NULL")),
            date(EntityInfo("date", "LONG", "NOT NULL")),
            reason(EntityInfo("reason", "TEXT", "NOT NULL"))
        }
    }
}