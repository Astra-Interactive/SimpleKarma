package com.astrainteractive.karmaplugin.commands.commands

import com.astrainteractive.karmaplugin.services.KarmaService
import com.astrainteractive.karmaplugin.KarmaPlugin
import com.astrainteractive.karmaplugin.utils.Permissions
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object Add {
    fun command(sender: CommandSender, args: Array<out String>) {
        if (!sender.hasPermission(Permissions.ADD))
            return
        val player = Bukkit.getPlayer(args[1]) ?: Bukkit.getOfflinePlayer(args[1])
        if (player == null) {
            sender.sendMessage("Такого игрока нет")
            return
        }
        val karmaValue = args[2].toIntOrNull()
        if (karmaValue == null || karmaValue == 0) {
            sender.sendMessage("Неверное значение кармы")
            return
        }
        val message = args.filterIndexed { i, _ -> i > 2 }.joinToString(" ")
        if (message.isNullOrEmpty()) {
            sender.sendMessage("Вы не ввели причину")
            return
        }
        if (sender !is Player) {
            sender.sendMessage("Вы не игрок")
        }
        sender as Player
        KarmaService.addKarma(player, sender, karmaValue, message)
        sender.sendMessage(KarmaPlugin.translations.commandSuccess)
    }
}