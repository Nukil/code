package scala.properties

import java.util.Properties

import scala.collection.JavaConversions.asScalaSet

import org.apache.commons.lang.StringUtils
import org.apache.log4j.Logger

/**
  * Created by Nukil on 2017/4/20.
  */

class LoadPropers {
    val LOGGER: Logger = Logger.getLogger(this.getClass)

    def load(filename: String): Properties = {
        val classLoader = this.getClass.getClassLoader
        val properties: Properties = new Properties()
        val serverConfigStream = classLoader.getResourceAsStream(filename + ".properties")
        try {
            properties.load(serverConfigStream)
            val tmp = properties.keySet().map(key => {
                val value = StringUtils.trimToNull(properties.getProperty(key.toString))
                LOGGER.info("config server properties key is %s value is %s".format(key.toString, value))
                (key.toString, value)
            }).toMap

            val server_props = new Properties()
            tmp.foreach(row => {
                if (row._1 != null && row._2 != null) {
                    server_props.put(row._1, row._2)
                }
            })

            server_props
        } finally {
            try {
                serverConfigStream.close()
            } catch {
                case _: Throwable =>
            }
        }
    }
}

object LoadPropers {
    var properties: Properties = _

    def getProperties(filename: String): Properties = {
        if (null == properties) {
            properties = new LoadPropers().load(filename)
        }
        properties
    }
}

