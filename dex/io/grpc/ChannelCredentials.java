package io.grpc;

public abstract class ChannelCredentials {
    public abstract ChannelCredentials withoutBearerTokens();
}