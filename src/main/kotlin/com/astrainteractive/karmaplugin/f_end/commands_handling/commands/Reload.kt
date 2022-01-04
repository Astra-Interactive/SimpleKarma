package com.astrainteractive.karmaplugin.f_end.commands_handling.commands

import com.astrainteractive.astralibs.AstraLibs
import com.astrainteractive.astralibs.registerCommand
import com.astrainteractive.karmaplugin.f_end.plugin.KarmaPlugin
import com.astrainteractive.karmaplugin.f_end.utils.Permissions

object Reload {
    fun reg(){
        AstraLibs.registerCommand("reload"){ sender, args->
            if (!sender.hasPermission(Permissions.RELOAD))
                return@registerCommand
            sender.sendMessage(KarmaPlugin.translations.RELOAD)
            KarmaPlugin.instance.liteReload()
            sender.sendMessage(KarmaPlugin.translations.RELOAD_SUCCESS)
        }
    }
}