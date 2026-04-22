package io.grpc.internal;

import io.grpc.CallOptions;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.util.concurrent.Executor;

public interface ClientTransport extends InternalInstrumented<InternalChannelz.SocketStats> {

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface PingCallback {
        void onFailure(Throwable th);

        void onSuccess(long j);
    }

    ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions);

    void ping(PingCallback pingCallback, Executor executor);
}