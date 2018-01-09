package javal.hbase;

import org.apache.hadoop.hbase.client.Result;
import org.junit.Test;
import sun.misc.BASE64Encoder;

/**
 * Created by Nukil on 2017/4/27
 */
public class HbaseUtilTest {
    @Test
    public void test() {
        HBaseUtil instance = HBaseUtil.getInstance();
        instance.init();
        Result result = instance.getOneRow("human_feature_test", "001500557279741194ea155b6fd4542991aa836d60dbfcf1500557279741194ea155b6fd4542991aa836d60dbfcf");
        byte[] tmp = result.getValue("cf".getBytes(), "feature".getBytes());
        System.out.println(new BASE64Encoder().encode(tmp));

    }
}
