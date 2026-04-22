package io.grpc.internal;

import com.google.common.base.Objects;
import io.grpc.Attributes;
import io.grpc.MethodDescriptor;
import io.grpc.ServerStreamTracer;
import javax.annotation.Nullable;

final class ServerCallInfoImpl<ReqT, RespT> extends ServerStreamTracer.ServerCallInfo<ReqT, RespT> {
    private final Attributes attributes;
    private final String authority;
    private final MethodDescriptor<ReqT, RespT> methodDescriptor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerCallInfoImpl(MethodDescriptor<ReqT, RespT> methodDescriptor, Attributes attributes, @Nullable String authority) {
        this.methodDescriptor = methodDescriptor;
        this.attributes = attributes;
        this.authority = authority;
    }

    @Override // io.grpc.ServerStreamTracer.ServerCallInfo
    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
        return this.methodDescriptor;
    }

    @Override // io.grpc.ServerStreamTracer.ServerCallInfo
    public Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.grpc.ServerStreamTracer.ServerCallInfo
    @Nullable
    public String getAuthority() {
        return this.authority;
    }

    public boolean equals(Object other) {
        if (other instanceof ServerCallInfoImpl) {
            ServerCallInfoImpl<?, ?> that = (ServerCallInfoImpl) other;
            return Objects.equal(this.methodDescriptor, that.methodDescriptor) && Objects.equal(this.attributes, that.attributes) && Objects.equal(this.authority, that.authority);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.methodDescriptor, this.attributes, this.authority});
    }
}