package p2p.io.grpc.ignet;

import com.bilibili.rpc.ignet.RpcEngine;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.Status;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import tv.danmaku.android.log.BLog;

public class IgnetClientTransport implements ConnectionClientTransport {
    private static final String LOG_TAG = "IgnetClientTransport";
    private final Attributes attrs;
    private ManagedClientTransport.Listener listener;
    private final InternalLogId logId;
    private long mRpcHandle;
    private final TransportTracer transportTracer;
    private final String userAgent;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IgnetClientTransport(InetSocketAddress address, String userAgent, Attributes eagAttrs, TransportTracer transportTracer, String proxy2) {
        this.logId = InternalLogId.allocate(getClass(), address.toString());
        this.userAgent = GrpcUtil.getGrpcUserAgent("ignet", userAgent);
        this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer, "transportTracer");
        this.attrs = Attributes.newBuilder().set(GrpcAttributes.ATTR_SECURITY_LEVEL, SecurityLevel.PRIVACY_AND_INTEGRITY).set(GrpcAttributes.ATTR_CLIENT_EAG_ATTRS, eagAttrs).build();
        BLog.i(LOG_TAG, "IgnetClientTransport createRpc host:" + address.getHostName() + " port:" + address.getPort() + " proxy:" + proxy2);
        this.mRpcHandle = RpcEngine.getInstance().createRpc(address.getHostName(), address.getPort(), proxy2, this.userAgent);
    }

    public Attributes getAttributes() {
        return this.attrs;
    }

    public Runnable start(ManagedClientTransport.Listener listener) {
        BLog.i(LOG_TAG, "start listener " + listener);
        this.listener = (ManagedClientTransport.Listener) Preconditions.checkNotNull(listener, "listener");
        return new Runnable() { // from class: p2p.io.grpc.ignet.IgnetClientTransport.1
            @Override // java.lang.Runnable
            public void run() {
                IgnetClientTransport.this.listener.transportReady();
            }
        };
    }

    public void shutdown(Status reason) {
        BLog.i(LOG_TAG, "shutdown reason" + reason);
        this.listener.transportShutdown(reason);
        RpcEngine.getInstance().releaseRpc(this.mRpcHandle);
    }

    public void shutdownNow(Status reason) {
        shutdown(reason);
    }

    public ClientStream newStream(MethodDescriptor<?, ?> method, Metadata headers, CallOptions callOptions) {
        Preconditions.checkNotNull(method, "method");
        Preconditions.checkNotNull(headers, "headers");
        BLog.i(LOG_TAG, "newStream type:" + method.getType() + " method:" + method.getFullMethodName() + " headers:" + headers.toString() + " callOptions:" + callOptions);
        StatsTraceContext statsTraceCtx = StatsTraceContext.newClientContext(callOptions, this.attrs, headers);
        IgnetClientStream clientStream = new IgnetClientStream(this.mRpcHandle, method, headers, this, callOptions, statsTraceCtx, this.transportTracer);
        return clientStream;
    }

    public void ping(ClientTransport.PingCallback callback, Executor executor) {
        throw new UnsupportedOperationException();
    }

    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        SettableFuture<InternalChannelz.SocketStats> f = SettableFuture.create();
        f.set((Object) null);
        return f;
    }

    public InternalLogId getLogId() {
        return this.logId;
    }
}