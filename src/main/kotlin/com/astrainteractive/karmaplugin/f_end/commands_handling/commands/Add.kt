package com.astrainteractive.karmaplugin.f_end.commands_handling.commands

import com.astrainteractive.karmaplugin.b_end.services.KarmaService
import com.astrainteractive.karmaplugin.f_end.plugin.KarmaPlugin
import com.astrainteractive.karmaplugin.f_end.utils.Permissions
import org.bukkit.command.CommandSender

object Add {
    fun command(sender: CommandSender, args: Array<out String>){
        if (!sender.hasPermission(Permissions.SET))
            return
        val player     = args[1]
        val karmaValue = args[2].toInt()
        KarmaService.addKarma(player, karmaValue)
        sender.sendMessage(KarmaPlugin.translations.SUCCESS_COMMAND)
    }
}