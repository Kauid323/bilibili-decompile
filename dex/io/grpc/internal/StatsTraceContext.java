package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.grpc.StreamTracer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class StatsTraceContext {
    public static final StatsTraceContext NOOP = new StatsTraceContext(new StreamTracer[0]);
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final StreamTracer[] tracers;

    public static StatsTraceContext newClientContext(CallOptions callOptions, Attributes transportAttrs, Metadata headers) {
        List<ClientStreamTracer.Factory> factories = callOptions.getStreamTracerFactories();
        if (factories.isEmpty()) {
            return NOOP;
        }
        ClientStreamTracer.StreamInfo info = ClientStreamTracer.StreamInfo.newBuilder().setTransportAttrs(transportAttrs).setCallOptions(callOptions).build();
        StreamTracer[] tracers = new StreamTracer[factories.size()];
        for (int i2 = 0; i2 < tracers.length; i2++) {
            tracers[i2] = factories.get(i2).newClientStreamTracer(info, headers);
        }
        return new StatsTraceContext(tracers);
    }

    public static StatsTraceContext newServerContext(List<? extends ServerStreamTracer.Factory> factories, String fullMethodName, Metadata headers) {
        if (factories.isEmpty()) {
            return NOOP;
        }
        StreamTracer[] tracers = new StreamTracer[factories.size()];
        for (int i2 = 0; i2 < tracers.length; i2++) {
            tracers[i2] = factories.get(i2).newServerStreamTracer(fullMethodName, headers);
        }
        return new StatsTraceContext(tracers);
    }

    StatsTraceContext(StreamTracer[] tracers) {
        this.tracers = tracers;
    }

    public List<StreamTracer> getTracersForTest() {
        return new ArrayList(Arrays.asList(this.tracers));
    }

    public void clientOutboundHeaders() {
        StreamTracer[] streamTracerArr;
        for (StreamTracer tracer : this.tracers) {
            ((ClientStreamTracer) tracer).outboundHeaders();
        }
    }

    public void clientInboundHeaders() {
        StreamTracer[] streamTracerArr;
        for (StreamTracer tracer : this.tracers) {
            ((ClientStreamTracer) tracer).inboundHeaders();
        }
    }

    public void clientInboundTrailers(Metadata trailers) {
        StreamTracer[] streamTracerArr;
        for (StreamTracer tracer : this.tracers) {
            ((ClientStreamTracer) tracer).inboundTrailers(trailers);
        }
    }

    public <ReqT, RespT> Context serverFilterContext(Context context) {
        StreamTracer[] streamTracerArr;
        Context ctx = (Context) Preconditions.checkNotNull(context, "context");
        for (StreamTracer tracer : this.tracers) {
            ctx = ((ServerStreamTracer) tracer).filterContext(ctx);
            Preconditions.checkNotNull(ctx, "%s returns null context", tracer);
        }
        return ctx;
    }

    public void serverCallStarted(ServerStreamTracer.ServerCallInfo<?, ?> callInfo) {
        StreamTracer[] streamTracerArr;
        for (StreamTracer tracer : this.tracers) {
            ((ServerStreamTracer) tracer).serverCallStarted(callInfo);
        }
    }

    public void streamClosed(Status status) {
        StreamTracer[] streamTracerArr;
        if (this.closed.compareAndSet(false, true)) {
            for (StreamTracer tracer : this.tracers) {
                tracer.streamClosed(status);
            }
        }
    }

    public void outboundMessage(int seqNo) {
        StreamTracer[] streamTracerArr;
        for (StreamTracer tracer : this.tracers) {
            tracer.outboundMessage(seqNo);
        }
    }

    public void inboundMessage(int seqNo) {
        StreamTracer[] streamTracerArr;
        for (StreamTracer tracer : this.tracers) {
            tracer.inboundMessage(seqNo);
        }
    }

    public void outboundMessageSent(int seqNo, long optionalWireSize, long optionalUncompressedSize) {
        StreamTracer[] streamTracerArr;
        for (StreamTracer tracer : this.tracers) {
            tracer.outboundMessageSent(seqNo, optionalWireSize, optionalUncompressedSize);
        }
    }

    public void inboundMessageRead(int seqNo, long optionalWireSize, long optionalUncompressedSize) {
        StreamTracer[] streamTracerArr;
        for (StreamTracer tracer : this.tracers) {
            tracer.inboundMessageRead(seqNo, optionalWireSize, optionalUncompressedSize);
        }
    }

    public void outboundUncompressedSize(long bytes) {
        StreamTracer[] streamTracerArr;
        for (StreamTracer tracer : this.tracers) {
            tracer.outboundUncompressedSize(bytes);
        }
    }

    public void outboundWireSize(long bytes) {
        StreamTracer[] streamTracerArr;
        for (StreamTracer tracer : this.tracers) {
            tracer.outboundWireSize(bytes);
        }
    }

    public void inboundUncompressedSize(long bytes) {
        StreamTracer[] streamTracerArr;
        for (StreamTracer tracer : this.tracers) {
            tracer.inboundUncompressedSize(bytes);
        }
    }

    public void inboundWireSize(long bytes) {
        StreamTracer[] streamTracerArr;
        for (StreamTracer tracer : this.tracers) {
            tracer.inboundWireSize(bytes);
        }
    }
}