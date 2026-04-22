package io.grpc;

import io.grpc.Context;

public class InternalServer {
    public static final Context.Key<Server> SERVER_CONTEXT_KEY = Server.SERVER_CONTEXT_KEY;

    private InternalServer() {
    }
}