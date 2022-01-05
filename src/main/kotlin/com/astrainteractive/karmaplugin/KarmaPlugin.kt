package com.astrainteractive.karmaplugin

import com.astrainteractive.astralibs.AstraLibs
import com.astrainteractive.astralibs.Logger
import com.astrainteractive.karmaplugin.database.Database
import com.astrainteractive.karmaplugin.services.KarmaService
import com.astrainteractive.karmaplugin.commands.CommandManager
import com.astrainteractive.karmaplugin.events.EventHandler
import com.astrainteractive.karmaplugin.utils.config.Config
import com.astrainteractive.karmaplugin.utils.Files
import com.astrainteractive.karmaplugin.utils.Translation
import org.bukkit.event.HandlerList
import org.bukkit.plugin.java.JavaPlugin
import javax.xml.crypto.Data

class KarmaPlugin : JavaPlugin() {
    companion object {
        lateinit var instance: KarmaPlugin
            private set
        lateinit var translations: Translation
            private set
        lateinit var files: Files
            private set
        lateinit var pluginConfig: Config
            private set
        lateinit var database: Database
            private set
    }

    private lateinit var eventHandler: EventHandler
    private lateinit var commandManager: CommandManager

    private fun liteEnable() {
        AstraLibs.create(this)
        Logger.init("KarmaPlugin")
        instance = this
        translations = Translation()
        files = Files()
        pluginConfig = Config.get()
        eventHandler = EventHandler()
        commandManager = CommandManager()
        Logger.log("Plugin was launched, logging:${Config.instance.logging}")
    }

    private fun liteDisable() {
        eventHandler.onDisable()
        KarmaService.onDisable()
        HandlerList.unregisterAll(this)
    }

    override fun onEnable() {
        liteEnable()
        database = Database().apply { onEnable() }
    }

    override fun onDisable() {
        liteDisable()
        database.onDisable()
    }

    fun liteReload() {
        liteDisable()
        liteEnable()
    }

    fun reload() {
        onDisable()
        onEnable()
    }

}