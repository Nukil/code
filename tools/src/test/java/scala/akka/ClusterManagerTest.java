package scala.akka;

import org.junit.Test;
import scala.akka.ClusterManager;
import scala.properties.LoadPropers;

import java.lang.Boolean;

/**
 * Created by Nukil on 2017/5/11
 */
public class ClusterManagerTest {
    @Test
    public void test() {
        String isMaster = LoadPropers.getProperties("akka").getProperty("akka.isMaster", "true");
        ClusterManager.clusterStart(Boolean.parseBoolean(isMaster));
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
