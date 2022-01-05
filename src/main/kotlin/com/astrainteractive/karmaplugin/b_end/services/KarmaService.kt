package com.astrainteractive.karmaplugin.b_end.services

import com.astrainteractive.karmaplugin.b_end.database.Repository

object KarmaService {
    val cache = HashMap<String, Int>()


    fun cachePlayer(player: String){
        val karma: Int = Repository.getSumKarma(player)?:0
        cache[player] = karma
    }

    fun getKarma(player: String):Int?{
        if(!cache.containsKey(player))
            cachePlayer(player)
        return cache[player]
    }
    fun addKarma(player: String, value: Int){
        Repository.insertKarma(Karma())
    }
    fun setKarma(player: String, value: Int){
        val prev: Int = getKarma(player)?:0
        val toBeAdded = value-prev
        addKarma(player,toBeAdded)
    }


    fun onPlayerJoin(player: String){
        cachePlayer(player)
    }
}