package com.astrainteractive.karmaplugin.f_end.event_handling.events

import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent
import com.astrainteractive.astralibs.IAstraListener
import com.astrainteractive.karmaplugin.b_end.services.KarmaService

class CachePlayerEvent : IAstraListener {

    @EventHandler
    public fun playerJoinEvent(e: PlayerJoinEvent){
        KarmaService.onPlayerJoin(e.player.name)
    }

    public override fun onDisable() {
        PlayerJoinEvent.getHandlerList().unregister(this)
    }
}