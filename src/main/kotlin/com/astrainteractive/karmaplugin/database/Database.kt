package com.astrainteractive.karmaplugin.database

import com.astrainteractive.astralibs.Logger
import com.astrainteractive.astralibs.catching
import com.astrainteractive.karmaplugin.KarmaPlugin
import com.astrainteractive.karmaplugin.utils.AsyncTask
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.sql.Connection
import java.sql.DriverManager

class Database : AsyncTask {
    val TAG = "Database"

    private val _dbPath = "${KarmaPlugin.instance.dataFolder}${File.separator}data.db"
    companion object {
        lateinit var connection: Connection
        val isInitialized: Boolean
            get() = this::connection.isInitialized && !connection.isClosed
    }
    private fun connectDatabase() =
        catching {
            connection = DriverManager.getConnection("jdbc:sqlite:${_dbPath}")
            return@catching true
        }

    public fun onEnable() {
        launch(Dispatchers.IO) {
            connectDatabase()
            if (isInitialized) {
                Logger.log("DB Initialization was completed", TAG)
                Repository.createKarmaTable()
            } else
                Logger.error("Could not initialize database", TAG)
        }

    }

    public fun onDisable() {
        connection.close()
    }
}