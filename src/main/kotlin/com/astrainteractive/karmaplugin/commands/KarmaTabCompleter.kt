package com.astrainteractive.karmaplugin.commands

import com.astrainteractive.astralibs.Logger
import com.astrainteractive.astralibs.withEntry
import com.astrainteractive.karmaplugin.KarmaPlugin
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class KarmaTabCompleter: TabCompleter{
    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): List<String>? {
        if(KarmaPlugin.pluginConfig.logging)
            Logger.log("Tab completer args",args.joinToString(",","[","]"))
        if (args.isEmpty())
            return listOf("karma")
        if (args.size == 1)
            return listOf("karma").withEntry(args.last())
        return null
    }
}