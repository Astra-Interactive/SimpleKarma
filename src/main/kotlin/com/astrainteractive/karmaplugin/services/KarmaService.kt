package com.astrainteractive.karmaplugin.services

import com.astrainteractive.karmaplugin.database.Repository
import com.astrainteractive.karmaplugin.database.entities.Karma
import com.astrainteractive.karmaplugin.utils.AsyncTask
import com.astrainteractive.karmaplugin.utils.uuid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.bukkit.OfflinePlayer

object KarmaService : AsyncTask {
    private val cache = HashMap<String, Int>()

    private fun setCache(player: OfflinePlayer, amount: Int) = synchronized(this) {
        cache[player.uuid] = amount
    }

    private fun getCachedKarma(player: OfflinePlayer) = synchronized(this) {
        return@synchronized cache[player.uuid]
    }

    private fun cachePlayer(player: OfflinePlayer) {
        launch(Dispatchers.IO) {
            val amount: Int = Repository.getTotalKarma(player.uuid) ?: 0
            setCache(player, amount)
        }
    }

    fun getKarma(violator: OfflinePlayer): Int? {
        if (getCachedKarma(violator) == null)
            cachePlayer(violator)
        return getCachedKarma(violator)
    }

    fun addKarma(violator: OfflinePlayer, executor:OfflinePlayer, amount: Int,message:String) {
        launch {
            Repository.insertKarma(Karma(violator,executor, amount,message))
            if (getCachedKarma(violator) == null)
                cachePlayer(violator)
            val prev = getCachedKarma(violator) ?: 0
            setCache(violator, prev + amount)
        }
    }

    fun onPlayerJoin(player: OfflinePlayer) {
        if (getCachedKarma(player) == null)
            cachePlayer(player)
    }

    fun onDisable() {
        cache.clear()
    }
}