package template.dataBase

import java.sql.*

object Test{
    @JvmStatic
    fun connection(){
       try {
           val c = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/kotlinbot",
               "root",
               "admin"
           )
           println("OK! DATABASE IS CONNECTED!");
       }catch(e: SQLException){
            e.printStackTrace()
       }
    }
}