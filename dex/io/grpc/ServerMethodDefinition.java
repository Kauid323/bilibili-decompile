package io.grpc;

public final class ServerMethodDefinition<ReqT, RespT> {
    private final ServerCallHandler<ReqT, RespT> handler;
    private final MethodDescriptor<ReqT, RespT> method;

    private ServerMethodDefinition(MethodDescriptor<ReqT, RespT> method, ServerCallHandler<ReqT, RespT> handler) {
        this.method = method;
        this.handler = handler;
    }

    public static <ReqT, RespT> ServerMethodDefinition<ReqT, RespT> create(MethodDescriptor<ReqT, RespT> method, ServerCallHandler<ReqT, RespT> handler) {
        return new ServerMethodDefinition<>(method, handler);
    }

    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
        return this.method;
    }

    public ServerCallHandler<ReqT, RespT> getServerCallHandler() {
        return this.handler;
    }

    public ServerMethodDefinition<ReqT, RespT> withServerCallHandler(ServerCallHandler<ReqT, RespT> handler) {
        return new ServerMethodDefinition<>(this.method, handler);
    }
}