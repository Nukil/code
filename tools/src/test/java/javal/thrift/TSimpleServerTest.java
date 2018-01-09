package javal.thrift;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import javal.thrift.rpc.Request;
import javal.thrift.rpc.Response;
import javal.thrift.rpc.ThriftTestServcice;
import org.junit.Test;

public class TSimpleServerTest {
    @Test
    public void test() {
        TTransport transport = new TSocket("0.0.0.0", 30055, 60000);
        transport = new TFramedTransport(transport);
        TProtocol protocol = new TCompactProtocol(transport);
        try {
            transport.open();
            ThriftTestServcice.Client client = new ThriftTestServcice.Client(protocol);
            Request request = new Request();
            request.setRequest("hello");
            int flag = 0;
            ThriftTestServcice.Client client1 = new ThriftTestServcice.Client(protocol);
            while (flag++ < 10) {
                client1.getResult(request);
                Response response = client.getResult(request);
                System.out.println(response.getResult().toString());
                Thread.sleep(1000);
            }
            transport.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
