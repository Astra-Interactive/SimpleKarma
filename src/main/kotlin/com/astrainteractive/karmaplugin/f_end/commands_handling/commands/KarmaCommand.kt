package com.astrainteractive.karmaplugin.f_end.commands_handling.commands

import com.astrainteractive.astralibs.AstraLibs
import com.astrainteractive.astralibs.registerCommand
import com.astrainteractive.karmaplugin.f_end.plugin.KarmaPlugin
import org.bukkit.command.CommandSender

object KarmaCommand {
    fun command(sender: CommandSender, args: Array<out String>){
        if(args.isEmpty()) {
            sender.sendMessage(KarmaPlugin.translations.PLUGIN_INFO)
            return
        }
        when(args[0]){
            "add"->Add.command(sender,args)
            "set"->Set.command(sender,args)
            "see"->See.command(sender,args)
            "reload"->Reload.command(sender,args)
            else->sender.sendMessage(KarmaPlugin.translations.FAILED_COMMAND)
        }
    }

    fun reg(){
        AstraLibs.registerCommand("karma"){sender,args->
            command(sender, args)
        }
    }
}