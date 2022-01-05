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
class AstraTemplate{

    companion object {
        lateinit var instance: AstraTemplate
            private set
    }

    private lateinit var commandManager: CommandManager

    fun onEnable() {
        //AstraLibs.create(this)
        Logger.init("AstraTemplate")
        instance = this
        commandManager = CommandManager()
        Logger.log("onEnable","1","2",logInFile = true)
    }

    fun onDisable() {
    }

    fun reloadPlugin() {
        onDisable()
        onEnable()
    }

}


