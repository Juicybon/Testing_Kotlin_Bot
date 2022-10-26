package template.dataBase

import java.sql.*

object Test{
    @Throws(SQLException::class)
    fun connection(): Connection{
           var dbConnection = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/kotlinbot",
               "root",
               "admin"
           )
        return dbConnection
    }
}