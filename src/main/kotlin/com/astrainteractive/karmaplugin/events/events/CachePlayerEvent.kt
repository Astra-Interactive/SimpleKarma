package com.astrainteractive.karmaplugin.events.events

import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent
import com.astrainteractive.astralibs.IAstraListener
import com.astrainteractive.karmaplugin.services.KarmaService

class CachePlayerEvent : IAstraListener {

    @EventHandler
    public fun playerJoinEvent(e: PlayerJoinEvent){
        KarmaService.onPlayerJoin(e.player)
    }

    public override fun onDisable() {
        PlayerJoinEvent.getHandlerList().unregister(this)
    }
}