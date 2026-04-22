package io.grpc.stub;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.stub.AbstractAsyncStub;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ClientCalls;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
public abstract class AbstractAsyncStub<S extends AbstractAsyncStub<S>> extends AbstractStub<S> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    protected AbstractAsyncStub(Channel channel, CallOptions callOptions) {
        super(channel, callOptions);
    }

    public static <T extends AbstractStub<T>> T newStub(AbstractStub.StubFactory<T> factory, Channel channel) {
        return (T) newStub(factory, channel, CallOptions.DEFAULT);
    }

    public static <T extends AbstractStub<T>> T newStub(AbstractStub.StubFactory<T> factory, Channel channel, CallOptions callOptions) {
        T stub = factory.newStub(channel, callOptions.withOption(ClientCalls.STUB_TYPE_OPTION, ClientCalls.StubType.ASYNC));
        if (!(stub instanceof AbstractAsyncStub)) {
            throw new AssertionError(String.format("Expected AbstractAsyncStub, but got %s.", stub.getClass()));
        }
        return stub;
    }
}