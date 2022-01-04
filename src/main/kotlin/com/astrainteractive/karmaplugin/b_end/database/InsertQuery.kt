package com.astrainteractive.karmaplugin.b_end.database

class InsertQuery private constructor() {

    data class Builder(
        private var table: String? = null,
        private var columns: String? = null,
        private var values: String? = null
    ) {
        fun table(table: String) = apply { this.table = table }
        fun columns(vararg columns: String) = apply { this.columns = "(${columns.joinToString(", ")})" }
        private fun Array<out Any>.parseSQLValues(): String {
            val list = mutableListOf<Any>()
            this.forEach {
                if (it is String)
                    list.add("\'$it\'")
                else list.add("$it")
            }
            return "(${list.joinToString(",")})"
        }
        fun values(vararg values: Any) = apply { this.values = values.parseSQLValues() }

        fun build(): String? {
            return "INSERT INTO ${table ?: return null} " +
                    "${columns ?: ""} " +
                    "VALUES ${values ?: return null};"
        }
    }
}