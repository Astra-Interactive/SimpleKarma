package com.astrainteractive.karmaplugin.f_end.plugin

import com.astrainteractive.astralibs.AstraLibs
import com.astrainteractive.astralibs.Logger
import com.astrainteractive.karmaplugin.b_end.database.Database
import com.astrainteractive.karmaplugin.b_end.services.KarmaService
import com.astrainteractive.karmaplugin.f_end.commands_handling.CommandManager
import com.astrainteractive.karmaplugin.f_end.event_handling.EventHandler
import com.astrainteractive.karmaplugin.f_end.utils.config.Config
import com.astrainteractive.karmaplugin.f_end.utils.Files
import com.astrainteractive.karmaplugin.f_end.utils.Translation
import org.bukkit.event.HandlerList
import org.bukkit.plugin.java.JavaPlugin

class KarmaPlugin : JavaPlugin() {
    companion object {
        lateinit var instance: KarmaPlugin
            private set
        lateinit var translations: Translation
            private set
        lateinit var files: Files
            private set
        lateinit var config: Config
            private set
    }

    private lateinit var eventHandler: EventHandler
    private lateinit var commandManager: CommandManager

    private fun liteEnable(){
        AstraLibs.create(this)
        Logger.init("KarmaPlugin")
        instance = this
        translations = Translation()
        files = Files()
        KarmaPlugin.config = Config.get()
        eventHandler = EventHandler()
        commandManager = CommandManager()
        Logger.log("Plugin was launched, config:${KarmaPlugin.config.logging}")
    }
    private fun liteDisable(){
        eventHandler.onDisable()
        KarmaService.onDisable()
        HandlerList.unregisterAll(this)
    }

    override fun onEnable(){
        liteEnable()
        Database.onEnable()
    }
    override fun onDisable() {
        liteDisable()
        Database.onDisable()
    }

    fun liteReload(){
        liteDisable()
        liteEnable()
    }
    fun reload(){
        onDisable()
        onEnable()
    }

}