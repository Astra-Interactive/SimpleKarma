package com.astrainteractive.karmaplugin.utils

import com.astrainteractive.karmaplugin.database.Database
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import java.sql.ResultSet


/**
 * For loop for ResultSet
 */
inline fun ResultSet.forEach(rs: (ResultSet) -> Unit) {
    while (this.next()) {
        rs(this)
    }
}


public inline fun <R : Any> ResultSet.mapNotNull(rs: (ResultSet) -> R?): List<R> {
    return mapNotNullTo(ArrayList<R>(), rs)
}

public inline fun <R : Any, C : MutableCollection<in R>> ResultSet.mapNotNullTo(
    destination: C,
    rs: (ResultSet) -> R?
): C {
    forEach { element -> rs(element)?.let { destination.add(it) } }
    return destination
}


public inline fun <T> callbackCatching(block: () -> T?): T? = try {
    if (!Database.isInitialized)
        throw Exception("Database not initialized")
    block.invoke()
} catch (e: Exception) {
    com.astrainteractive.astralibs.Logger.error(e.stackTraceToString(), "Database")
    null
}

val Player.uuid: String
    get() = this.uniqueId.toString()
val OfflinePlayer.uuid: String
    get() = this.uniqueId.toString()