import GetPut.getContent
import bean.CacheFaceFeature
import bean.CacheHumanFeature
import org.apache.ignite.Ignition
import org.junit.Test
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.*

class PutGet {
    @Test
    fun test() {
        run({
            val igniteName = "Netposa"
            val feature1 = getContent("feature1")
            val feature2 = getContent("feature2")
            val featureFloat1 = FloatArray(256)
            val featureFloat2 = FloatArray(256)

            val days = 1

            for (i in 0 .. 255) {
                featureFloat1[i] = byte2float(feature1, i * 4)
                featureFloat2[i] = byte2float(feature2, i * 4)
            }

            val inputStream: InputStream = javaClass.classLoader.getResourceAsStream("default-config.xml")
            Ignition.setClientMode(true)
            val ignite = Ignition.start(inputStream)

            val caches = Ignition.ignite().cacheNames()
            caches.forEach { cache ->
                println(cache + " " + Ignition.ignite().cache<String, com.netposa.bean.CacheHumanFeature>(cache).size())
            }

            if (Ignition.ignite().cacheNames().contains("Netposa_HUMAN_20180105")) {
                Ignition.ignite().cache<String, com.netposa.bean.CacheHumanFeature>("Netposa_HUMAN_20180105").destroy()
                println("destroy")
            }

            val sdf = SimpleDateFormat("yyyyMMdd")
            for (j in 0 until days) {
                val cache = Ignition.ignite().getOrCreateCache<String, com.netposa.bean.CacheHumanFeature>("Netposa_HUMAN_" + (sdf.format(System.currentTimeMillis() - j * 86400000)))
                val t1 = System.currentTimeMillis()
                println(cache.name)
                for (i in 1..100000) {
                    val bean = com.netposa.bean.CacheHumanFeature()
                    bean.gatherTime = ("" + System.currentTimeMillis()).toByteArray()
                    bean.cameraId = UUID.randomUUID().toString().toByteArray()
                    val key = UUID.randomUUID().toString()
                    if (i % 2 == 0) {
                        bean.feature = featureFloat1
//                    println(key + " " + String(bean.cameraId))
                    } else {
                        bean.feature = featureFloat2
                    }
                    cache.put(key, bean)
                    if (i % 10000 == 0) {
                        val t2 = System.currentTimeMillis()
                        println("$i  ${t2 - t1} ms")
                    }
                }
            }
            val cache = Ignition.ignite().getOrCreateCache<String, com.netposa.bean.CacheHumanFeature>()
            for (entry in cache) {
                println(entry.key + " " +  String(entry.value.cameraId) + " " + String(entry.value.gatherTime))
                val b = entry.value.feature
                for (c in b) {
                    print("$c ")
                }
            }
            ignite.close()
        })
    }

    @Throws(IOException::class)
    private fun getContent(filePath: String): ByteArray {
        val file = File(filePath)
        val fileSize = file.length()
        val fi = FileInputStream(file)
        val buffer = ByteArray(fileSize.toInt())
        var offset = 0
        var numRead = 0
        while (offset < buffer.size && numRead >= 0) {
            numRead = fi.read(buffer, offset, buffer.size - offset)
            offset += numRead
        }
        // 确保所有数据均被读取
        if (offset != buffer.size) {
            throw IOException("Could not completely read file " + file.name)
        }
        fi.close()
        return buffer
    }

    fun byte2float(b: ByteArray, index: Int): Float {
        var l: Int
        l = b[index].toInt()
        l = l and 0xff
        l = l or (b[index + 1].toLong() shl 8).toInt()
        l = l and 0xffff
        l = l or (b[index + 2].toLong() shl 16).toInt()
        l = l and 0xffffff
        l = l or (b[index + 3].toLong() shl 24).toInt()
        return java.lang.Float.intBitsToFloat(l)
    }
}