package com.astrainteractive.karmaplugin.f_end.utils

import com.astrainteractive.astralibs.FileManager
import com.astrainteractive.astralibs.getHEXString

class Translation {
    val _translationFile: FileManager = FileManager("translations.yml")
    private val translation = _translationFile.getConfig()!!

    val PLUGIN_INFO     = translation.getHEXString("PLUGIN_INFO")?:"%%%Информация о плагине%%%"

    val RELOAD          = translation.getHEXString("RELOAD")?:"Начало перезапуска..."
    val RELOAD_SUCCESS  = translation.getHEXString("RELOAD_SUCCESS")?:"Перезапуск завершён успешно"

    val SUCCESS_COMMAND = translation.getHEXString("SUCCESS_COMMAND")?:"Команда выполнена успешно"
    val FAILED_COMMAND  = translation.getHEXString("FAILED_COMMAND")?:"Команда не была выполнена"
}