package com.astrainteractive.karmaplugin.f_end.commands_handling.commands

import com.astrainteractive.karmaplugin.f_end.plugin.KarmaPlugin
import com.astrainteractive.karmaplugin.f_end.utils.Permissions
import org.bukkit.command.CommandSender

object Reload {
    private fun reload(sender: CommandSender){
        if (!sender.hasPermission(Permissions.RELOAD))
            return
        sender.sendMessage(KarmaPlugin.translations.RELOAD)
        KarmaPlugin.instance.liteReload()
        sender.sendMessage(KarmaPlugin.translations.RELOAD_SUCCESS)
    }
    private fun reloadDB(sender: CommandSender){
        if (!sender.hasPermission(Permissions.RELOAD))
            return
        sender.sendMessage(KarmaPlugin.translations.RELOAD)
        KarmaPlugin.instance.reload()
        sender.sendMessage(KarmaPlugin.translations.RELOAD_SUCCESS)
    }

    fun command(sender: CommandSender, args: Array<out String>){
        if(args.size == 1)
            reload(sender)
        else if(args[1] == "database")
            reloadDB(sender)
        else sender.sendMessage(KarmaPlugin.translations.FAILED_COMMAND)
    }
}