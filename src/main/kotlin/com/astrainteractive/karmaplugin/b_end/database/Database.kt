package com.astrainteractive.karmaplugin.b_end.database

import com.astrainteractive.astralibs.Logger
import com.astrainteractive.astralibs.catching
import com.astrainteractive.karmaplugin.f_end.plugin.KarmaPlugin
import java.io.File
import java.sql.Connection
import java.sql.DriverManager

object Database {

    private val _dbPath = "${KarmaPlugin.instance.dataFolder}${File.separator}data.db"
    lateinit var connection: Connection
    val isInitialized: Boolean
        get() = this::connection.isInitialized && !connection.isClosed

    private fun connectDatabase() =
        catching {
            connection = DriverManager.getConnection("jdbc:sqlite:${_dbPath}")
            return@catching true
        }
    public fun onEnable(){
        connectDatabase()
        if(isInitialized){
            Repository.createKarmaTable()
            if(KarmaPlugin.config.logging)
                Logger.log("DB Initialization was completed")
        }
        //Repository.createUserTable()
        //val user = User("id${Random.nextInt(20000)}", "mine${Random.nextInt(5000)}")
        //Repository.insertUser(user)
        //Repository.getAllUsers()
    }

    public fun onDisable() {
        connection.close()
    }
}