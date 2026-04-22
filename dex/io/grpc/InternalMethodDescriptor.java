package io.grpc;

import com.google.common.base.Preconditions;

public final class InternalMethodDescriptor {
    private final InternalKnownTransport transport;

    public InternalMethodDescriptor(InternalKnownTransport transport) {
        this.transport = (InternalKnownTransport) Preconditions.checkNotNull(transport, "transport");
    }

    public Object geRawMethodName(MethodDescriptor<?, ?> descriptor) {
        return descriptor.getRawMethodName(this.transport.ordinal());
    }

    public void setRawMethodName(MethodDescriptor<?, ?> descriptor, Object o) {
        descriptor.setRawMethodName(this.transport.ordinal(), o);
    }
}