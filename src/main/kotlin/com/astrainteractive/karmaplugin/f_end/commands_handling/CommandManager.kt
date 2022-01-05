package com.astrainteractive.karmaplugin.f_end.commands_handling

import com.astrainteractive.astralibs.AstraLibs
import com.astrainteractive.astralibs.Logger
import com.astrainteractive.astralibs.registerTabCompleter
import com.astrainteractive.astralibs.withEntry
import com.astrainteractive.karmaplugin.f_end.commands_handling.commands.KarmaCommand
import com.astrainteractive.karmaplugin.f_end.plugin.KarmaPlugin

class CommandManager {
    init{
        AstraLibs.registerTabCompleter("atemp"){ sender, args ->
            if(KarmaPlugin.config.logging)
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