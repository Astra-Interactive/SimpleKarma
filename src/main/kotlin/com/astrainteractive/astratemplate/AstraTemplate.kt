package com.astrainteractive.astratemplate

//import com.makeevrserg.empiretemplate.database.EmpireDatabase
import CommandManager
import com.astrainteractive.astralibs.AstraLibs
import com.astrainteractive.astralibs.Logger
import org.bukkit.event.HandlerList
import org.bukkit.plugin.java.JavaPlugin

/**
 * Initial class for your plugin
 */
class AstraTemplate : JavaPlugin() {

    /**
     * Static objects of this class
     */
    companion object {
        lateinit var instance: AstraTemplate
            private set
    }

    /**
     * Command manager for your commands.
     *
     * You can create multiple managers.
     *
     * Should be private
     */
    private lateinit var commandManager: CommandManager



    /**
     * This method called when server starts.
     *
     * When server starts or PlugMan load plugin.
     */
    override fun onEnable() {
        AstraLibs.create(this)
        Logger.init("AstraTemplate")
        instance = this
        commandManager = CommandManager()
        Logger.log("onEnable","1","2",logInFile = true)
    }

    /**
     * This method called when server is shutting down.
     *
     * Or when PlugMan disable plugin.
     */
    override fun onDisable() {
        HandlerList.unregisterAll(this)
    }

    /**
     * As it says, function for plugin reload
     */
    fun reloadPlugin() {
        onDisable()
        onEnable()
    }

}


