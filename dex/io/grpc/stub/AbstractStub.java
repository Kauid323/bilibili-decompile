package io.grpc.stub;

import com.google.common.base.Preconditions;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.Deadline;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public abstract class AbstractStub<S extends AbstractStub<S>> {
    private final CallOptions callOptions;
    private final Channel channel;

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface StubFactory<T extends AbstractStub<T>> {
        T newStub(Channel channel, CallOptions callOptions);
    }

    protected abstract S build(Channel channel, CallOptions callOptions);

    protected AbstractStub(Channel channel) {
        this(channel, CallOptions.DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractStub(Channel channel, CallOptions callOptions) {
        this.channel = (Channel) Preconditions.checkNotNull(channel, "channel");
        this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions, "callOptions");
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final CallOptions getCallOptions() {
        return this.callOptions;
    }

    public static <T extends AbstractStub<T>> T newStub(StubFactory<T> factory, Channel channel) {
        return (T) newStub(factory, channel, CallOptions.DEFAULT);
    }

    public static <T extends AbstractStub<T>> T newStub(StubFactory<T> factory, Channel channel, CallOptions callOptions) {
        return factory.newStub(channel, callOptions);
    }

    public final S withDeadline(@Nullable Deadline deadline) {
        return build(this.channel, this.callOptions.withDeadline(deadline));
    }

    public final S withDeadlineAfter(long duration, TimeUnit unit) {
        return build(this.channel, this.callOptions.withDeadlineAfter(duration, unit));
    }

    public final S withExecutor(Executor executor) {
        return build(this.channel, this.callOptions.withExecutor(executor));
    }

    public final S withCompression(String compressorName) {
        return build(this.channel, this.callOptions.withCompression(compressorName));
    }

    @Deprecated
    public final S withChannel(Channel newChannel) {
        return build(newChannel, this.callOptions);
    }

    public final <T> S withOption(CallOptions.Key<T> key, T value) {
        return build(this.channel, this.callOptions.withOption(key, value));
    }

    public final S withInterceptors(ClientInterceptor... interceptors) {
        return build(ClientInterceptors.intercept(this.channel, interceptors), this.callOptions);
    }

    public final S withCallCredentials(CallCredentials credentials) {
        return build(this.channel, this.callOptions.withCallCredentials(credentials));
    }

    public final S withWaitForReady() {
        return build(this.channel, this.callOptions.withWaitForReady());
    }

    public final S withMaxInboundMessageSize(int maxSize) {
        return build(this.channel, this.callOptions.withMaxInboundMessageSize(maxSize));
    }

    public final S withMaxOutboundMessageSize(int maxSize) {
        return build(this.channel, this.callOptions.withMaxOutboundMessageSize(maxSize));
    }
}