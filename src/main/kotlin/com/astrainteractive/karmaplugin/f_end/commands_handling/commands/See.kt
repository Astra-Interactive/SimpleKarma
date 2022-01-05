package com.astrainteractive.karmaplugin.f_end.commands_handling.commands

import com.astrainteractive.karmaplugin.b_end.services.KarmaService
import com.astrainteractive.karmaplugin.f_end.plugin.KarmaPlugin
import com.astrainteractive.karmaplugin.f_end.utils.Permissions
import org.bukkit.command.CommandSender

object See {
    fun command(sender: CommandSender, args: Array<out String>){
        if (!sender.hasPermission(Permissions.SET))
            return
        val player     = args[1]
        val karma = KarmaService.getKarma(player)
        sender.sendMessage(KarmaPlugin.translations.SUCCESS_COMMAND)
        sender.sendMessage("Значение кармы игрока $player равно $karma")
    }
}