package scala.xml

import java.io.InputStream

import org.apache.commons.lang.StringUtils


/**
  * Created by Nukil on 2017/5/17.
  */
class ControlBean(val inStream: InputStream) {
    //数据库连接信息
    var dbClass: String = _
    var dbUrl: String = _
    var dbUser: String = _
    var dbPwd: String = _
    //表名称定义
    var tableName: String = _
    //表字段定义
    var first: String = _
    var second: String = _
    var third: String = _

    initControl()

    def initControl(): Unit = {
        try {
            val conf = XML.load(inStream)
            //解析XML数据库连接信息
            (conf \ "connection" \\ "_").foreach(e => {
                e.label match {
                    case "driverClass" => dbClass = StringUtils.trimToNull(e.text)
                    case "url" => dbUrl = StringUtils.trimToNull(e.text)
                    case "user" => dbUser = StringUtils.trimToNull(e.text)
                    case "password" => dbPwd = {
                        val tmp = StringUtils.trimToNull(e.text)
                        if ("null".equalsIgnoreCase(tmp)) null else tmp
                    }
                    case _ =>
                }
            })
            if (null == dbClass || null == dbUrl || null == dbUser) {
                throw new Exception(s"Error: driverClass || url || user is null, $dbClass, $dbUrl, $dbUser")
            }
            //解析表名称
            tableName = StringUtils.trimToNull((conf \ "table" \ "name").text)
            if (null == tableName) {
                throw new Exception(s"Error: table name is null, $tableName")
            }
            //解析表字段名称
            (conf \ "fields" \\ "_").foreach(e => {
                e.label match {
                    case "fields_1" => first = StringUtils.trimToNull((e \ "field").text)
                    case "fields_2" => second = StringUtils.trimToNull((e \ "field").text)
                    case "fields_3" => third = StringUtils.trimToNull((e \ "field").text)
                    case _ =>
                }
            })
            if (null == first || null == second || null == third) {
                throw new Exception("table fields is null")
            }
        } finally {
            try {
                inStream.close()
            } catch {
                case _: Throwable =>
            }
        }
    }

    override def toString: String = {
        s"connections:{db_class=$dbClass,db_url=$dbUrl,db_user=$dbUser,db_pwd=$dbPwd}," +
          s"table:{$tableName},fields:{first=$first,second=$second,third=$third}"
    }
}
