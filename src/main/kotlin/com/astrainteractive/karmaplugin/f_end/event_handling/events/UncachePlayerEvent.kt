package com.astrainteractive.karmaplugin.f_end.event_handling.events

import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerQuitEvent
import com.astrainteractive.astralibs.IAstraListener

class UncachePlayerEvent : IAstraListener{
    
    @EventHandler
    public fun playerQuitEvent(e: PlayerQuitEvent){
        //TODO: implement appellation to karma cache events
        return
    }

    public override fun onDisable() {
        PlayerQuitEvent.getHandlerList().unregister(this)
    }
}