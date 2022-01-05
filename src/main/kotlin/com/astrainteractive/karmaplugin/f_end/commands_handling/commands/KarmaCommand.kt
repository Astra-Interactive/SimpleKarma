package com.astrainteractive.karmaplugin.f_end.commands_handling.commands

import com.astrainteractive.astralibs.AstraLibs
import com.astrainteractive.astralibs.registerCommand
import com.astrainteractive.karmaplugin.f_end.plugin.KarmaPlugin

object KarmaCommand {
    fun reg(){
        AstraLibs.registerCommand("karma"){ sender, args->
            sender.sendMessage(KarmaPlugin.translations.PLUGIN_INFO)
        }
    }
}