import com.meoos.rpc.protocol.RpcProtocol;
import com.meoos.rpc.protocol.header.RpcHeader;
import com.meoos.rpc.protocol.header.RpcHeaderFactory;
import com.meoos.rpc.protocol.request.RpcRequest;

/**
 * @Author Meoos
 * @Version 1.0.0
 * @description
 */
public class Test {

    public static RpcProtocol<RpcRequest> getRpcProtocol(){
        RpcHeader header = RpcHeaderFactory.getRequestHeader("jdk");
        RpcRequest body = new RpcRequest();
        body.setOneway(false);
        body.setAsync(false);
        body.setClassName("com.meoos.rpc.protocol");
        body.setMethodName("hello");
        body.setGroup("meoos");
        body.setParameters(new Object[]{"meoos"});
        body.setParameterTypes(new Class[]{String.class});
        body.setVersion("1.0.0");
        RpcProtocol<RpcRequest> protocol = new RpcProtocol<>();
        protocol.setBody(body);
        protocol.setHeader(header);
        return protocol;
    }

}
