package template.dataBase

import java.sql.*

@Throws(SQLException::class)
fun GetTasks(id: Int): ResultSet{
    val resSet: ResultSet
    val select: String = "SELECT * FROM tasks WHERE idTasks = " + id;
    val prSt: PreparedStatement = Test.connection().prepareStatement(select)
    resSet = prSt.executeQuery()
    resSet.next()
    return resSet
}

fun GetQuestion(resSet: ResultSet):String{
    val result:String = resSet.getString("Question")
    return result.replace(';','\n',true)
}

fun GetVarCount(resSet: ResultSet):Int{
    val result:String = resSet.getString("VarCount")
    return result.toInt()
}

fun GetRightVar(resSet: ResultSet):Int{
    val result:String = resSet.getString("RightVar")
    return result.toInt()
}