package com.astrainteractive.karmaplugin.f_end.event_handling

import com.astrainteractive.astralibs.IAstraListener
import com.astrainteractive.astralibs.IAstraManager
import com.astrainteractive.karmaplugin.f_end.event_handling.events.CachePlayerEvent
import com.astrainteractive.karmaplugin.f_end.event_handling.events.UncachePlayerEvent

class EventHandler : IAstraManager {
    override val handlers: MutableList<IAstraListener> = mutableListOf()
    init {
        CachePlayerEvent().onEnable(this)
        UncachePlayerEvent().onEnable(this)
    }
}