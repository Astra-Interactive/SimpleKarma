package com.astrainteractive.astratemplate.commands

import com.astrainteractive.astralibs.AstraLibs
import com.astrainteractive.astralibs.registerCommand
import com.astrainteractive.astratemplate.AstraTemplate

/**
 * Reload command handler
 */
class Reload {

    /**
     * This function called only when etempreload beign called
     *
     * Here you should also check for permission
     */
    private val onCommand = AstraLibs.registerCommand("reload"){sender,args->
        AstraTemplate.instance.reloadPlugin()
    }

}