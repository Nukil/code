
import kafka.bean.RowMessage;
import kafka.common.TopicAndPartition;
import kafka.consumer.DirectKafkaConsumer;
import kafka.util.LoadPropers;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class DirectKafkaConsumerTest {
    @Test
    public void test() {
        Properties properties = LoadPropers.getSingleInstance().getProperties("kafka-consumer");
        int totalSize = 0;
        boolean stopped = false;
        try {
            DirectKafkaConsumer consumer = new DirectKafkaConsumer(properties);
            new Thread(consumer).start();
            while (!stopped) {
                List<RowMessage> list = consumer.fetchMessages();
                System.out.println(String.format("fetch message size is %d, total : %d", list.size(), totalSize+=list.size()));
                consumer.commitOffsets(new HashMap<TopicAndPartition, Long>());
                if (list.size() < 1000) {
                    Thread.sleep(1000);
                }
            }
            consumer.shutDown();
        } catch (Exception e) {
            System.out.println(e.getMessage() + e);
        }
    }

}
