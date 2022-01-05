package com.astrainteractive.karmaplugin.utils

import com.astrainteractive.astralibs.FileManager
import com.astrainteractive.astralibs.HEX
import com.astrainteractive.astralibs.getHEXString

class Translation {
    val _translationFile: FileManager = FileManager("translations.yml")
    private val translation = _translationFile.getConfig()!!

    companion object {
        lateinit var instance: Translation
    }

    init {
        instance = this
    }

    private fun getHEXString(path: String, default: String): String {
        if (!translation.contains(path)) {
            translation.set(path, default)
            _translationFile.saveConfig()
        }
        return translation.getHEXString(path) ?: default.HEX()
    }

    val pluginInfo = getHEXString("general.pluginInfo", "%%%Информация о плагине%%%")
    val reload = getHEXString("general.reload", "Начало перезапуска...")
    val reloadedSuccess = getHEXString("general.reload_success", "Перезапуск завершён успешно")
    val commandSuccess = getHEXString("general.command_success", "Команда выполнена успешно")
    val commandFail = getHEXString("general.command_fail", "Команда не была выполнена")
}