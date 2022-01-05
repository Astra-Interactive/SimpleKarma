package com.astrainteractive.karmaplugin.events

import com.astrainteractive.astralibs.IAstraListener
import com.astrainteractive.astralibs.IAstraManager
import com.astrainteractive.karmaplugin.events.events.CachePlayerEvent

class EventHandler : IAstraManager {
    override val handlers: MutableList<IAstraListener> = mutableListOf()
    val cacheEvent = CachePlayerEvent().onEnable(this)

}