package scala.properties;

import org.junit.Test;

import scala.properties.LoadPropers;
import java.util.Properties;

public class LoadPropersTest {
    @Test
    public void test() {
        Properties properties = LoadPropers.getProperties("server");
        for (Object obj : properties.keySet()) {
            System.out.println(obj.toString() + " " + properties.get(obj));
        }
    }
}
