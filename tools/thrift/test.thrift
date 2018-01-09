namespace java thrift.rpc
enum StatusCode {
    OK = 0,
    PARAM_ERROR = -1,
    UNKNOWN_ERROR = -2
}

struct Request {
    1: string request
}

struct MessageBody {
    1: string request,
    2: string response
}

struct Response {
    1: StatusCode rCode,
    2: string message,
    3: MessageBody result
}

service ThriftTestServcice {
    Response getResult(1: Request request)
}
