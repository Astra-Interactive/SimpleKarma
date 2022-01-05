package com.astrainteractive.karmaplugin.commands.commands

import com.astrainteractive.astralibs.AstraLibs
import com.astrainteractive.astralibs.registerCommand
import com.astrainteractive.karmaplugin.KarmaPlugin
import org.bukkit.command.CommandSender

object KarmaCommand {
    fun command(sender: CommandSender, args: Array<out String>){
        if(args.isEmpty()) {
            sender.sendMessage(KarmaPlugin.translations.pluginInfo)
            return
        }
        when(args[0]){
            "add"->Add.command(sender,args)
            "see"->See.command(sender,args)
            "reload"->Reload.command(sender,args)
            else->sender.sendMessage(KarmaPlugin.translations.commandFail)
        }
    }

    fun reg(){
        AstraLibs.registerCommand("karma"){sender,args->
            command(sender, args)
        }
    }
}