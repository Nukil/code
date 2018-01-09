

import kafka.bean.SourceMessage;
import kafka.producer.DirectKafkaProducer;
import kafka.util.LoadPropers;
import org.junit.Test;

import java.util.List;
import java.util.Properties;

public class DirectKafkaProducerTest {
    @Test
    public void test() {
        Properties properties = LoadPropers.getSingleInstance().getProperties("kafka-producer");
        DirectKafkaProducer producer = new DirectKafkaProducer(properties);
        for (int i = 1; i <= 10000000; ++i) {
            if (i % 1000 == 0) {
                System.out.println(i);
            }
            List<SourceMessage> list = producer.sendMessage(new SourceMessage("kafka_1000W_8", "" + i, "hello".getBytes()), true);
            if (list.size() > 0) {
                System.out.println("=======================error=======================");
            }
        }
    }
}