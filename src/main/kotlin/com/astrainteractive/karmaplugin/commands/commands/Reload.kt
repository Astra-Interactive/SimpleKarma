package com.astrainteractive.karmaplugin.commands.commands

import com.astrainteractive.karmaplugin.KarmaPlugin
import com.astrainteractive.karmaplugin.utils.Permissions
import org.bukkit.command.CommandSender

object Reload {
    private fun reload(sender: CommandSender){
        if (!sender.hasPermission(Permissions.RELOAD))
            return
        sender.sendMessage(KarmaPlugin.translations.reload)
        KarmaPlugin.instance.liteReload()
        sender.sendMessage(KarmaPlugin.translations.reloadedSuccess)
    }
    private fun reloadDB(sender: CommandSender){
        if (!sender.hasPermission(Permissions.RELOAD))
            return
        sender.sendMessage(KarmaPlugin.translations.reload)
        KarmaPlugin.instance.reload()
        sender.sendMessage(KarmaPlugin.translations.reloadedSuccess)
    }

    fun command(sender: CommandSender, args: Array<out String>){
        if(args.size == 1)
            reload(sender)
        else if(args[1] == "database")
            reloadDB(sender)
        else sender.sendMessage(KarmaPlugin.translations.commandFail)
    }
}