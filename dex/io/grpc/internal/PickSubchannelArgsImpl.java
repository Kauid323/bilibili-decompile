package io.grpc.internal;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;

public final class PickSubchannelArgsImpl extends LoadBalancer.PickSubchannelArgs {
    private final CallOptions callOptions;
    private final Metadata headers;
    private final MethodDescriptor<?, ?> method;

    public PickSubchannelArgsImpl(MethodDescriptor<?, ?> method, Metadata headers, CallOptions callOptions) {
        this.method = (MethodDescriptor) Preconditions.checkNotNull(method, "method");
        this.headers = (Metadata) Preconditions.checkNotNull(headers, "headers");
        this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions, "callOptions");
    }

    @Override // io.grpc.LoadBalancer.PickSubchannelArgs
    public Metadata getHeaders() {
        return this.headers;
    }

    @Override // io.grpc.LoadBalancer.PickSubchannelArgs
    public CallOptions getCallOptions() {
        return this.callOptions;
    }

    @Override // io.grpc.LoadBalancer.PickSubchannelArgs
    public MethodDescriptor<?, ?> getMethodDescriptor() {
        return this.method;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PickSubchannelArgsImpl that = (PickSubchannelArgsImpl) o;
        if (Objects.equal(this.callOptions, that.callOptions) && Objects.equal(this.headers, that.headers) && Objects.equal(this.method, that.method)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.callOptions, this.headers, this.method});
    }

    public final String toString() {
        return "[method=" + this.method + " headers=" + this.headers + " callOptions=" + this.callOptions + "]";
    }
}