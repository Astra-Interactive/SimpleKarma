package com.astrainteractive.karmaplugin.commands

import com.astrainteractive.astralibs.AstraLibs
import com.astrainteractive.astralibs.Logger
import com.astrainteractive.astralibs.registerTabCompleter
import com.astrainteractive.astralibs.withEntry
import com.astrainteractive.karmaplugin.commands.commands.KarmaCommand
import com.astrainteractive.karmaplugin.KarmaPlugin

class CommandManager {
    init{
        AstraLibs.registerTabCompleter("atemp"){ sender, args ->
            if(KarmaPlugin.pluginConfig.logging)
                Logger.log("CommandManager tab completer args", args.joinToString(",","[","]"))
            if (args.isEmpty())
                return@registerTabCompleter listOf("karma")
            if (args.size == 1)
                return@registerTabCompleter listOf("karma").withEntry(args.last())
            return@registerTabCompleter listOf<String>()
        }
        KarmaCommand.reg()
    }
}