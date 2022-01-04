package com.astrainteractive.karmaplugin.f_end.event_handling

import com.astrainteractive.astralibs.IAstraListener
import com.astrainteractive.astralibs.IAstraManager

class EventHandler : IAstraManager {
    override val handlers: MutableList<IAstraListener> = mutableListOf()
    init {

    }
}