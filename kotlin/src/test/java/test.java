import com.netposa.poseidon.kafka.consumer.DirectKafkaConsumer;

import java.util.Properties;

public class test {
    public static void main(String[] args) {
        try {
            new DirectKafkaConsumer(new Properties()).fetchMessages();
        } catch (Exception e) {

        }
    }

}
