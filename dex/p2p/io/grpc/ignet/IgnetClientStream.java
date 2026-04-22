package p2p.io.grpc.ignet;

import com.bilibili.rpc.ignet.RpcEngine;
import com.bilibili.rpc.ignet.RpcStreamObserver;
import com.bilibili.rpc.ignet.RpcStreamProvider;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.AbstractStream;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.Framer;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InsightBuilder;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.StreamListener;
import io.grpc.internal.TransportFrameUtil;
import io.grpc.internal.TransportTracer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import tv.danmaku.android.log.BLog;

public class IgnetClientStream extends AbstractStream implements ClientStream {
    private static final String LOG_TAG = "IgnetClientStream";
    private final Collection<Object> mAnnotations;
    private IgnetFramer mFramer;
    private MethodDescriptor<?, ?> mMethod;
    private RpcStreamObserver mOb = new RpcStreamObserver();
    private RpcStreamProvider mPd = new RpcStreamProvider();
    private long mRpcHandle;
    IgnetClientTransport mTransport;
    private TransportState mTransportState;

    /* JADX INFO: Access modifiers changed from: protected */
    public IgnetClientStream(long rpcHandle, MethodDescriptor<?, ?> method, Metadata headers, IgnetClientTransport transport, CallOptions callOptions, StatsTraceContext statsTraceCtx, TransportTracer transportTracer) {
        this.mRpcHandle = rpcHandle;
        this.mMethod = method;
        if (method.getType() != MethodDescriptor.MethodType.UNARY && method.getType() != MethodDescriptor.MethodType.BIDI_STREAMING) {
            throw new UnsupportedOperationException();
        }
        headers.discardAll(GrpcUtil.MESSAGE_ENCODING_KEY);
        headers.discardAll(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        headers.discardAll(GrpcUtil.CONTENT_ENCODING_KEY);
        headers.discardAll(GrpcUtil.CONTENT_ACCEPT_ENCODING_KEY);
        this.mTransport = transport;
        this.mAnnotations = (Collection) callOptions.getOption(InternalIgnetCallOptions.IGNET_ANNOTATIONS_KEY);
        this.mFramer = new IgnetFramer(headers, statsTraceCtx);
        this.mTransportState = new TransportState(4194304, statsTraceCtx, transportTracer);
        this.mOb.setCallback(new RpcStreamObserver.Callback() { // from class: p2p.io.grpc.ignet.IgnetClientStream.1
            public void onHeaderReceived(HashMap<String, byte[]> headers2) {
                if (IgnetClientStream.this.transportState().isListenerClosed()) {
                    return;
                }
                BLog.i(IgnetClientStream.LOG_TAG, "onHeaderReceived " + headers2.size());
                int i = 0;
                byte[][] headerValues = new byte[headers2.size() * 2];
                for (Map.Entry<String, byte[]> entry : headers2.entrySet()) {
                    BLog.i(IgnetClientStream.LOG_TAG, "onHeaderReceived " + entry.getKey() + ":" + new String(entry.getValue()));
                    int i2 = i + 1;
                    headerValues[i] = entry.getKey().getBytes(Charset.forName("UTF-8"));
                    i = i2 + 1;
                    headerValues[i2] = entry.getValue();
                }
                Metadata metadata = InternalMetadata.newMetadata(headerValues);
                BLog.i(IgnetClientStream.LOG_TAG, "metadata: " + metadata);
                IgnetClientStream.this.transportState().m1884listener().headersRead(metadata);
            }

            public void onTrailingHeaderReceived(HashMap<String, byte[]> headers2) {
                if (IgnetClientStream.this.transportState().isListenerClosed()) {
                    return;
                }
                BLog.i(IgnetClientStream.LOG_TAG, "onTrailingHeaderReceived size:" + headers2.size());
                int i = 0;
                byte[][] headerValues = new byte[headers2.size() * 2];
                for (Map.Entry<String, byte[]> entry : headers2.entrySet()) {
                    int i2 = i + 1;
                    headerValues[i] = entry.getKey().getBytes(Charset.forName("UTF-8"));
                    i = i2 + 1;
                    headerValues[i2] = entry.getValue();
                }
                Metadata metadata = InternalMetadata.newMetadata(headerValues);
                BLog.i(IgnetClientStream.LOG_TAG, "metadata: " + metadata);
                IgnetClientStream.this.transportState().setTrailingMetadata(metadata);
            }

            public void onNext(byte[] data, int len) {
                if (IgnetClientStream.this.transportState().isListenerClosed()) {
                    return;
                }
                BLog.i(IgnetClientStream.LOG_TAG, "onNext data len :" + len);
                InputStream stream = new ByteArrayInputStream(data, 0, len);
                IgnetClientStream.this.mTransportState.messagesAvailable(new SingleMessageProducer(stream));
            }

            public void onError(int errCode, String errMsg) {
                if (IgnetClientStream.this.transportState().isListenerClosed()) {
                    return;
                }
                BLog.i(IgnetClientStream.LOG_TAG, "onError errCode:" + errCode + " errMsg:" + errMsg);
                Status status = Status.fromCodeValue(errCode);
                IgnetClientStream.this.transportState().closed(status, ClientStreamListener.RpcProgress.PROCESSED);
                IgnetClientStream.this.mTransport.shutdown(status);
            }

            public void onComplete() {
                BLog.i(IgnetClientStream.LOG_TAG, "onComplete");
                IgnetClientStream.this.mOb.release();
                IgnetClientStream.this.mPd.release();
                if (IgnetClientStream.this.transportState().isListenerClosed()) {
                    return;
                }
                IgnetClientStream.this.transportState().closed(Status.OK, ClientStreamListener.RpcProgress.PROCESSED);
            }
        });
    }

    protected Framer framer() {
        return this.mFramer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TransportState transportState() {
        return this.mTransportState;
    }

    public void cancel(Status reason) {
        BLog.i(LOG_TAG, "cancel not support, reason " + reason);
    }

    public void halfClose() {
        BLog.i(LOG_TAG, "halfClose");
        endOfMessages();
    }

    public void setAuthority(String authority) {
        BLog.i(LOG_TAG, "setAuthority " + authority);
        throw new UnsupportedOperationException("ignet does not support overriding authority");
    }

    public void setFullStreamDecompression(boolean fullStreamDecompression) {
        BLog.i(LOG_TAG, "setFullStreamDecompression:" + fullStreamDecompression);
    }

    public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
        BLog.i(LOG_TAG, "setDecompressorRegistry:" + decompressorRegistry);
    }

    public void start(ClientStreamListener listener) {
        BLog.i(LOG_TAG, "start " + listener);
        transportState().setListener(listener);
        if (this.mMethod.getType() == MethodDescriptor.MethodType.BIDI_STREAMING) {
            this.mFramer.writeHeader();
        }
    }

    public void setMaxInboundMessageSize(int maxSize) {
        BLog.i(LOG_TAG, "setMaxInboundMessageSize " + maxSize);
    }

    public void setMaxOutboundMessageSize(int maxSize) {
        BLog.i(LOG_TAG, "setMaxOutboundMessageSize " + maxSize);
    }

    public void setDeadline(Deadline deadline) {
        this.mFramer.setDeadline(deadline);
    }

    public Attributes getAttributes() {
        return Attributes.EMPTY;
    }

    public void appendTimeoutInsight(InsightBuilder insight) {
        BLog.i(LOG_TAG, "appendTimeoutInsight " + insight);
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private class IgnetFramer implements Framer {
        private boolean closed;
        private Deadline deadline;
        private Metadata headers;
        private byte[] payload;
        private final StatsTraceContext statsTraceCtx;

        public IgnetFramer(Metadata headers, StatsTraceContext statsTraceCtx) {
            this.headers = (Metadata) Preconditions.checkNotNull(headers, "headers");
            this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceCtx, "statsTraceCtx");
        }

        public void writeHeader() {
            BLog.i(IgnetClientStream.LOG_TAG, "writeHeaders metadata:" + this.headers + " payload:" + this.payload);
            String method = "/" + IgnetClientStream.this.mMethod.getFullMethodName();
            Map<String, String> rpcMetadata = new HashMap<>();
            byte[][] serializedHeaders = TransportFrameUtil.toHttp2Headers(this.headers);
            for (int i = 0; i < serializedHeaders.length; i += 2) {
                String key = new String(serializedHeaders[i], Charset.forName("UTF-8"));
                String value = new String(serializedHeaders[i + 1], Charset.forName("UTF-8"));
                rpcMetadata.put(key, value);
            }
            boolean ret = true;
            if (IgnetClientStream.this.mMethod.getType() == MethodDescriptor.MethodType.UNARY) {
                HashMap<String, String> config = new HashMap<>();
                if (this.deadline != null) {
                    long remainingMs = this.deadline.timeRemaining(TimeUnit.MILLISECONDS);
                    config.put("timeout", String.valueOf(remainingMs));
                }
                ret = RpcEngine.getInstance().asyncUnaryCall(IgnetClientStream.this.mRpcHandle, method, rpcMetadata, this.payload, this.payload.length, IgnetClientStream.this.mOb, config, IgnetClientStream.this.mAnnotations);
            } else if (IgnetClientStream.this.mMethod.getType() == MethodDescriptor.MethodType.BIDI_STREAMING) {
                ret = RpcEngine.getInstance().asyncBidiStreamCall(IgnetClientStream.this.mRpcHandle, method, rpcMetadata, IgnetClientStream.this.mPd, IgnetClientStream.this.mOb, IgnetClientStream.this.mAnnotations);
            }
            if (!ret) {
                BLog.w(IgnetClientStream.LOG_TAG, "writeHeaders failed !!!, rpc handle" + IgnetClientStream.this.mRpcHandle + " is released");
                IgnetClientStream.this.transportState().closed(Status.UNAVAILABLE.withDescription("rpc handle is released"), ClientStreamListener.RpcProgress.DROPPED);
                return;
            }
            IgnetClientStream.this.transportState().onStreamAllocated();
        }

        public void writePayload(InputStream message) {
            Preconditions.checkState(this.payload == null, "writePayload should not be called multiple times");
            BLog.i(IgnetClientStream.LOG_TAG, "writePayload message:" + message);
            try {
                this.payload = ByteStreams.toByteArray(message);
                this.statsTraceCtx.outboundMessage(0);
                this.statsTraceCtx.outboundMessageSent(0, this.payload.length, this.payload.length);
                this.statsTraceCtx.outboundUncompressedSize(this.payload.length);
                this.statsTraceCtx.outboundWireSize(this.payload.length);
                if (IgnetClientStream.this.mMethod.getType() == MethodDescriptor.MethodType.BIDI_STREAMING) {
                    IgnetClientStream.this.mPd.asyncSend(this.payload, this.payload.length);
                    this.payload = null;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void flush() {
            BLog.i(IgnetClientStream.LOG_TAG, "flush");
        }

        public boolean isClosed() {
            return this.closed;
        }

        public void close() {
            BLog.i(IgnetClientStream.LOG_TAG, "close");
            this.closed = true;
            if (IgnetClientStream.this.mMethod.getType() == MethodDescriptor.MethodType.UNARY) {
                Preconditions.checkState(this.payload != null, "Lack of request message. GET request is only supported for unary requests");
                writeHeader();
            }
            this.payload = null;
            this.headers = null;
        }

        public void dispose() {
            BLog.i(IgnetClientStream.LOG_TAG, "dispose");
            this.closed = true;
            this.payload = null;
            this.headers = null;
        }

        public Framer setMessageCompression(boolean enable) {
            BLog.i(IgnetClientStream.LOG_TAG, "setMessageCompression " + enable);
            return this;
        }

        public Framer setCompressor(Compressor compressor) {
            BLog.i(IgnetClientStream.LOG_TAG, "setCompressor " + compressor);
            return this;
        }

        public void setMaxOutboundMessageSize(int maxSize) {
        }

        public void setDeadline(Deadline deadline) {
            BLog.i(IgnetClientStream.LOG_TAG, "setDeadline " + deadline);
            this.deadline = deadline;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public class TransportState extends AbstractStream.TransportState {
        private ClientStreamListener listener;
        private boolean listenerClosed;
        private final StatsTraceContext statsTraceCtx;
        private Metadata trailingMetadata;

        public TransportState(int maxMessageSize, StatsTraceContext statsTraceCtx, TransportTracer transportTracer) {
            super(maxMessageSize, statsTraceCtx, transportTracer);
            this.statsTraceCtx = statsTraceCtx;
            this.listenerClosed = false;
        }

        public final void setListener(ClientStreamListener listener) {
            Preconditions.checkState(this.listener == null, "Already called setListener");
            this.listener = (ClientStreamListener) Preconditions.checkNotNull(listener, "listener");
        }

        public void setTrailingMetadata(Metadata metadata) {
            this.trailingMetadata = metadata;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: listener */
        public ClientStreamListener m1884listener() {
            return this.listener;
        }

        protected void onStreamAllocated() {
            super.onStreamAllocated();
        }

        public void runOnTransportThread(Runnable r) {
        }

        public void bytesRead(int numBytes) {
        }

        public void deframerClosed(boolean hasPartialMessage) {
        }

        public void deframeFailed(Throwable cause) {
        }

        public final void closed(Status status, ClientStreamListener.RpcProgress progress) {
            if (!this.listenerClosed) {
                this.listenerClosed = true;
                this.statsTraceCtx.streamClosed(status);
                if (this.trailingMetadata == null) {
                    this.trailingMetadata = new Metadata();
                }
                m1884listener().closed(status, progress, this.trailingMetadata);
                if (getTransportTracer() != null) {
                    getTransportTracer().reportStreamClosed(status.isOk());
                }
            }
        }

        public boolean isListenerClosed() {
            return this.listenerClosed;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    class SingleMessageProducer implements StreamListener.MessageProducer {
        private InputStream mStream;

        SingleMessageProducer(InputStream stream) {
            this.mStream = stream;
        }

        public InputStream next() {
            InputStream next = this.mStream;
            this.mStream = null;
            return next;
        }
    }
}