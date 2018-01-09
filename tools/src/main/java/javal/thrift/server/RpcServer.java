package javal.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.*;
import javal.thrift.rpc.ThriftTestServcice;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class RpcServer implements Runnable {

    private TProtocolFactory getTProtocolFactory(boolean isCompact) {
        if (isCompact) {
            return new TCompactProtocol.Factory();
        } else {
            return new TBinaryProtocol.Factory();
        }
    }

    private TTransportFactory getTTransportFactory(boolean framed, int frameSize) {
        if (framed) {
            return new TFramedTransport.Factory(frameSize);
        } else {
            return new TTransportFactory();
        }
    }

    private InetSocketAddress bindToPort(String bindValue, int listenPort) throws UnknownHostException {
        try {
            if (bindValue == null) {
                return new InetSocketAddress(listenPort);
            } else {
                return new InetSocketAddress(InetAddress.getByName(bindValue), listenPort);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException("Could not bind to provided ip address", e);
        }
    }
    private TServer getTThreadPoolServer(TProtocolFactory protocolFactory, TProcessor processor, TTransportFactory transportFactory, InetSocketAddress inetSocketAddress) throws TTransportException {
        TServerTransport serverTransport = new TServerSocket(inetSocketAddress);
        TSimpleServer.Args serverArgs = new TSimpleServer.Args(serverTransport);
        serverArgs.processor(processor);
        serverArgs.transportFactory(transportFactory);
        serverArgs.protocolFactory(protocolFactory);
        return new TSimpleServer(serverArgs);
    }

    @Override
    public void run() {
        final RpcServerHandler handler = new RpcServerHandler();
        final ThriftTestServcice.Processor<RpcServerHandler> p = new ThriftTestServcice.Processor<RpcServerHandler>(handler);
        TProcessor processor = p;
        TServer server = null;
        String bindAddress = "0.0.0.0";
        try {
            System.out.println("--------------设置压缩协议-------------");
            TProtocolFactory protocolFactory = getTProtocolFactory(true);
            System.out.println("--------------设置字节流大小-------------");
            TTransportFactory transportFactory = getTTransportFactory(true, 2 * 1024 * 1024);
            System.out.println("--------------绑定端口-------------");
            InetSocketAddress inetSocketAddress = bindToPort(bindAddress, 30055);
            server = getTThreadPoolServer(protocolFactory, processor, transportFactory, inetSocketAddress);
            System.out.println("--------------服务启动-------------");
            server.serve();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
