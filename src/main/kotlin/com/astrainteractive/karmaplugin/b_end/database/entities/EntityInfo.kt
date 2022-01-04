package com.astrainteractive.karmaplugin.b_end.database.entities

data class EntityInfo(val name: String, val type: String, val nullable: String){
    public val line: String
        get() = "$name $type $nullable"
}