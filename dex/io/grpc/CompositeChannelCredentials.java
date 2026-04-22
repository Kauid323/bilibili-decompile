package io.grpc;

import com.google.common.base.Preconditions;

public final class CompositeChannelCredentials extends ChannelCredentials {
    private final CallCredentials callCredentials;
    private final ChannelCredentials channelCredentials;

    public static ChannelCredentials create(ChannelCredentials channelCreds, CallCredentials callCreds) {
        return new CompositeChannelCredentials(channelCreds, callCreds);
    }

    private CompositeChannelCredentials(ChannelCredentials channelCreds, CallCredentials callCreds) {
        this.channelCredentials = (ChannelCredentials) Preconditions.checkNotNull(channelCreds, "channelCreds");
        this.callCredentials = (CallCredentials) Preconditions.checkNotNull(callCreds, "callCreds");
    }

    public ChannelCredentials getChannelCredentials() {
        return this.channelCredentials;
    }

    public CallCredentials getCallCredentials() {
        return this.callCredentials;
    }

    @Override // io.grpc.ChannelCredentials
    public ChannelCredentials withoutBearerTokens() {
        return this.channelCredentials.withoutBearerTokens();
    }
}