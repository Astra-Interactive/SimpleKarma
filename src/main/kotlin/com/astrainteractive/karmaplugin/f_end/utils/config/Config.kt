package com.astrainteractive.karmaplugin.f_end.utils.config

import com.astrainteractive.karmaplugin.f_end.plugin.KarmaPlugin

class Config(val logging: Boolean) {
    companion object{
        fun get(): Config {
            val c = KarmaPlugin.files.configFile.getConfig()
            val logging = c.getBoolean("logging", true)
            return Config(logging)
        }
    }
}