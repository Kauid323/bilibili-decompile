package facadeverify;

import com.dtf.face.network.mpass.biz.rpc.exception.RpcException;

public class j extends RpcException {
    public j(RpcException rpcException) {
        super(Integer.valueOf(rpcException.getCode()), rpcException.getMsg());
        ((RpcException) this).sourceException = rpcException;
    }
}