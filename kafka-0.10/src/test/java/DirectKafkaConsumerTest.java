import kafka.bean.RowMessage;
import kafka.common.TopicAndPartition;
import kafka.consumer.DirectKafkaConsumer;
import kafka.util.LoadPropers;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DirectKafkaConsumerTest {
    @Test
    public void test() {
        Properties propers = LoadPropers.getSingleInstance().getProperties("kafka-consumer");
        DirectKafkaConsumer consumer = new DirectKafkaConsumer(propers);
        Map<TopicAndPartition, Long> offsets = new HashMap<>();
        int total = 0;
        boolean stopped = false;
        while (!stopped) {
            List<RowMessage> messages = consumer.fetchMessages();
            for(RowMessage message : messages) {
                if (offsets.containsKey(message.topicAndPartition())) {
                    if (offsets.get(message.topicAndPartition()) < message.offset()) {
                        offsets.put(message.topicAndPartition(), message.offset());
                    }
                } else {
                    offsets.put(message.topicAndPartition(), message.offset());
                }
            }
            System.out.println(String.format("fetch message size is %d, total size is %d", messages.size(), total+=messages.size()));
            consumer.commitOffsets(offsets);
            if (messages.size() < 1000) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {

                }
            }
        }
    }
}
