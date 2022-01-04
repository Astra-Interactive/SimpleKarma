package com.astrainteractive.karmaplugin.f_end.plugin

import com.astrainteractive.astratemplate.AstraTemplate
import com.astrainteractive.astratemplate.sqldatabase.Database
import com.astrainteractive.karmaplugin.f_end.utils.Config
import com.astrainteractive.karmaplugin.f_end.utils.Files
import com.astrainteractive.karmaplugin.f_end.utils.Translation
import org.bukkit.plugin.java.JavaPlugin

class KarmaPlugin : JavaPlugin() {
    companion object {
        lateinit var instance: AstraTemplate
            private set
        lateinit var translations: Translation
            private set
        lateinit var empireFiles: Files
            private set
        lateinit var pluginConfig: Config
            private set
        public lateinit var database: Database
            private set
    }
}