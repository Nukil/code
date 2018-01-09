package scala.redis;

import org.apache.log4j.Logger;
import org.junit.Test;
import scala.properties.LoadPropers;
import scala.redis.RedisClient;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nukil on 2017/4/20
 */
public class RedisClientTest {
    @Test
    public void test() {
        Logger logger = Logger.getLogger(RedisClientTest.class);
        int redisIndex = Integer.parseInt(LoadPropers.getProperties("redis").getProperty("redis.index"));

        Jedis jedis = RedisClient.getJedis();
        while (null == jedis || !jedis.isConnected()) {
            jedis = RedisClient.getJedis();
            if (null == jedis || !jedis.isConnected()) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        jedis.select(redisIndex);
        Map<String, String> infoMap = new HashMap<String, String>();
        infoMap.put("startTime", "20170420");
        infoMap.put("endTime", "20170421");
        System.out.println(jedis.hmset("key", infoMap));
        System.out.println(jedis.hmget("key").toString());
    }
}
