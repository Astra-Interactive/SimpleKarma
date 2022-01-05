package com.astrainteractive.karmaplugin.database.entities

data class EntityInfo(val name: String, val type: String, val extra: String) {

    val nameTypeExtra: String
        get() = "$name  $type $extra"
    val nameType: String
        get() = "$name $type"
}