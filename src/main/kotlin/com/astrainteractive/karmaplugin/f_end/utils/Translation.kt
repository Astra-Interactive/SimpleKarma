package com.astrainteractive.karmaplugin.f_end.utils

import com.astrainteractive.astralibs.FileManager
import com.astrainteractive.astralibs.getHEXString

class Translation {
    val _translationFile: FileManager = FileManager("translations.yml")
    private val translation = _translationFile.getConfig()!!

    public val SUCCESS_COMMAND = translation.getHEXString("SUCCESS_COMMAND")?:"Команда выполнена успешно"
    public val FAILED_COMMAND = translation.getHEXString("FAILED_COMMAND")?:"Команда не была выполнена"

}