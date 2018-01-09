package javal.thrift.server;

import org.apache.thrift.TException;
import javal.thrift.rpc.*;

public class RpcServerHandler implements ThriftTestServcice.Iface {
    @Override
    public Response getResult(Request request) throws TException {
        System.out.println("接收到请求" + request.toString());
        Response response = new Response();
        MessageBody messageBody = new MessageBody();
        messageBody.setRequest(request.getRequest());
        messageBody.setResponse("hello world");
        response.setRCode(StatusCode.OK);
        response.setMessage("调用成功");
        response.setResult(messageBody);
        return response;
    }
}
