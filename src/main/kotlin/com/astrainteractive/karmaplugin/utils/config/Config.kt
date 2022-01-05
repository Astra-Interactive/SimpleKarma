package com.astrainteractive.karmaplugin.utils.config

import com.astrainteractive.karmaplugin.KarmaPlugin

class Config(val logging: Boolean) {
    companion object{
        lateinit var instance:Config
        fun get(): Config {
            val c = KarmaPlugin.files.configFile.getConfig()
            val logging = c.getBoolean("logging", true)
            return Config(logging)
        }
    }
    init {
        instance = this
    }
}