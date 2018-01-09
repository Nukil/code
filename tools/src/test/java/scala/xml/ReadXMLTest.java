package scala.xml;

import org.junit.Test;

import java.io.InputStream;

/**
 * Created by Nukil on 2017/5/17
 */
public class ReadXMLTest {
    @Test
    public void test() {
        ClassLoader classLoader = ReadXMLTest.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("control.xml");
        ControlBean controlConf = new ControlBean(inputStream);
        System.out.println(controlConf.toString());
    }
}
