package com.astrainteractive.karmaplugin.commands.commands

import com.astrainteractive.karmaplugin.services.KarmaService
import com.astrainteractive.karmaplugin.KarmaPlugin
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender

object See {
    fun command(sender: CommandSender, args: Array<out String>){
        val player = Bukkit.getPlayer(args[1]) ?: Bukkit.getOfflinePlayer(args[1])
        if (player == null) {
            sender.sendMessage("Такого игрока нет")
            return
        }
        val karma = KarmaService.getKarma(player)
        sender.sendMessage(KarmaPlugin.translations.commandSuccess)
        sender.sendMessage("Значение кармы игрока $player равно $karma")
    }
}