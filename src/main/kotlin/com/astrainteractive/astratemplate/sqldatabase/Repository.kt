package com.astrainteractive.astratemplate.sqldatabase

import com.astrainteractive.astralibs.catching
import com.astrainteractive.astratemplate.sqldatabase.entities.User
import com.astrainteractive.karmaplugin.b_end.database.InsertQuery
import java.sql.ResultSet
import javax.xml.crypto.Data

/**
 * Repository with all SQL commands
 */
object Repository {
    /**
     * Return boolean of null if exception happened
     */
    fun createUserTable() =
        catching {
            Database.connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS ${User.table} " +
                        "(${User.discordId.name} ${User.discordId.type} NOT NULL, " +
                        "${User.minecraftUuid.name} ${User.minecraftUuid.type} NOT NULL, " +
                        "PRIMARY KEY (${User.primaryKey}));"
            ).execute()
        }

    fun insertUser(user: User) =
        catching {
            val command = InsertQuery.Builder()
                .table(User.table)
                .columns(User.discordId.name, User.minecraftUuid.name)
                .values(user.discordId, user.minecraftUuid)
                .build()
            println(command)
            Database.connection.createStatement().executeUpdate(command)
        }

    fun getAllUsers() = catching {
        val rs = Database.connection.createStatement().executeQuery("SELECT * FROM ${User.table}")
        val list = mutableListOf<User>()
        rs.forEach {
            val user = User.fromResultSet(rs) ?: return@forEach
            list.add(user)
            println("User = ${user}")
        }
        return@catching list
    }
}

/**
 * For loop for ResultSet
 */
inline fun ResultSet.forEach(rs: (ResultSet) -> Unit) {
    while (this.next()) {
        rs(this)
    }
}

fun <T> ResultSet.asSequence(extract: () -> T): Sequence<T> = generateSequence {
    if (this.next()) extract() else null
}
