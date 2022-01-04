package com.astrainteractive.karmaplugin.f_end.event_handling.events

import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent
import com.astrainteractive.astralibs.IAstraListener

class CachePlayerEvent : IAstraListener {

    @EventHandler
    public fun playerJoinEvent(e: PlayerJoinEvent){
        //TODO: implement appellation to karma cache events
        return
    }

    public override fun onDisable() {
        PlayerJoinEvent.getHandlerList().unregister(this)
    }
}