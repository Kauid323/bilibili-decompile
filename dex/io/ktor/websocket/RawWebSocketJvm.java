package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.pool.ObjectPool;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketSession;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: RawWebSocketJvm.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0017¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001a0$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001e\u0010,\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00068V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R+\u0010\t\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010/\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010:\u001a\u0002098\u0000X\u0080\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001a\u0010?\u001a\u00020>8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lio/ktor/websocket/RawWebSocketJvm;", "Lio/ktor/websocket/WebSocketSession;", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", Column.INVAL_VALUE, "maxFrameSize", Column.INVAL_VALUE, "masking", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/CoroutineContext;Lio/ktor/utils/io/pool/ObjectPool;)V", Column.INVAL_VALUE, "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "terminate", "()V", "Lkotlinx/coroutines/CompletableJob;", "socketJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", "filtered", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", Column.INVAL_VALUE, "Lio/ktor/websocket/WebSocketExtension;", "getExtensions", "()Ljava/util/List;", "extensions", "<set-?>", "maxFrameSize$delegate", "Lkotlin/properties/ReadWriteProperty;", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "masking$delegate", "getMasking", "()Z", "setMasking", "(Z)V", "Lio/ktor/websocket/WebSocketWriter;", "writer", "Lio/ktor/websocket/WebSocketWriter;", "getWriter$ktor_websockets", "()Lio/ktor/websocket/WebSocketWriter;", "Lio/ktor/websocket/WebSocketReader;", "reader", "Lio/ktor/websocket/WebSocketReader;", "getReader$ktor_websockets", "()Lio/ktor/websocket/WebSocketReader;", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RawWebSocketJvm implements WebSocketSession {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(RawWebSocketJvm.class, "maxFrameSize", "getMaxFrameSize()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(RawWebSocketJvm.class, "masking", "getMasking()Z", 0))};
    private final CoroutineContext coroutineContext;
    private final Channel<Frame> filtered;
    private final ReadWriteProperty masking$delegate;
    private final ReadWriteProperty maxFrameSize$delegate;
    private final WebSocketReader reader;
    private final CompletableJob socketJob;
    private final WebSocketWriter writer;

    public RawWebSocketJvm(ByteReadChannel input, ByteWriteChannel output, long maxFrameSize, boolean masking, CoroutineContext coroutineContext, ObjectPool<ByteBuffer> objectPool) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        this.socketJob = JobKt.Job(coroutineContext.get(Job.Key));
        this.filtered = ChannelKt.Channel$default(0, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.coroutineContext = coroutineContext.plus(this.socketJob).plus(new CoroutineName("raw-ws"));
        Delegates delegates = Delegates.INSTANCE;
        final Object initialValue$iv = Long.valueOf(maxFrameSize);
        this.maxFrameSize$delegate = new ObservableProperty<Long>(initialValue$iv) { // from class: io.ktor.websocket.RawWebSocketJvm$special$$inlined$observable$1
            protected void afterChange(KProperty<?> kProperty, Long l, Long l2) {
                Intrinsics.checkNotNullParameter(kProperty, "property");
                long newValue = l2.longValue();
                l.longValue();
                this.getReader$ktor_websockets().setMaxFrameSize(newValue);
            }
        };
        Delegates delegates2 = Delegates.INSTANCE;
        final Object initialValue$iv2 = Boolean.valueOf(masking);
        this.masking$delegate = new ObservableProperty<Boolean>(initialValue$iv2) { // from class: io.ktor.websocket.RawWebSocketJvm$special$$inlined$observable$2
            protected void afterChange(KProperty<?> kProperty, Boolean bool, Boolean bool2) {
                Intrinsics.checkNotNullParameter(kProperty, "property");
                boolean newValue = bool2.booleanValue();
                bool.booleanValue();
                this.getWriter$ktor_websockets().setMasking(newValue);
            }
        };
        this.writer = new WebSocketWriter(output, getCoroutineContext(), masking, objectPool);
        this.reader = new WebSocketReader(input, getCoroutineContext(), maxFrameSize, objectPool);
        BuildersKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
        this.socketJob.complete();
    }

    public /* synthetic */ RawWebSocketJvm(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext, ObjectPool objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteReadChannel, byteWriteChannel, (i & 4) != 0 ? 2147483647L : j, (i & 8) != 0 ? false : z, coroutineContext, (i & 32) != 0 ? ByteBufferPoolKt.getKtorDefaultPool() : objectPool);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object send(Frame frame, Continuation<? super Unit> continuation) {
        return WebSocketSession.DefaultImpls.send(this, frame, continuation);
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public ReceiveChannel<Frame> getIncoming() {
        return this.filtered;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public SendChannel<Frame> getOutgoing() {
        return this.writer.getOutgoing();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return CollectionsKt.emptyList();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return ((Number) this.maxFrameSize$delegate.getValue(this, $$delegatedProperties[0])).longValue();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j) {
        this.maxFrameSize$delegate.setValue(this, $$delegatedProperties[0], Long.valueOf(j));
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return ((Boolean) this.masking$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z) {
        this.masking$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z));
    }

    public final WebSocketWriter getWriter$ktor_websockets() {
        return this.writer;
    }

    public final WebSocketReader getReader$ktor_websockets() {
        return this.reader;
    }

    /* compiled from: RawWebSocketJvm.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", Column.INVAL_VALUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.RawWebSocketJvm$1", f = "RawWebSocketJvm.kt", i = {2, 3}, l = {67, 68, 71, 74}, m = "invokeSuspend", n = {"cause", "cause"}, s = {"L$0", "L$0"})
    /* renamed from: io.ktor.websocket.RawWebSocketJvm$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0071 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0080 A[Catch: all -> 0x00ad, CancellationException -> 0x00b3, ProtocolViolationException -> 0x00b9, FrameTooBigException -> 0x00c0, TRY_LEAVE, TryCatch #8 {FrameTooBigException -> 0x00c0, ProtocolViolationException -> 0x00b9, CancellationException -> 0x00b3, all -> 0x00ad, blocks: (B:35:0x0078, B:37:0x0080), top: B:95:0x0078 }] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0121 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0122  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0158 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0159  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x009b -> B:91:0x0064). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            AnonymousClass1 anonymousClass1;
            AnonymousClass1 anonymousClass12;
            ProtocolViolationException cause;
            AnonymousClass1 anonymousClass13;
            FrameTooBigException cause2;
            ChannelIterator it;
            AnonymousClass1 anonymousClass14;
            ChannelIterator channelIterator;
            Object obj;
            Object $result2;
            Object hasNext;
            Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                try {
                    try {
                        try {
                        } catch (Throwable th) {
                            cause = th;
                            anonymousClass12 = this;
                            SendChannel.DefaultImpls.close$default(RawWebSocketJvm.this.filtered, (Throwable) null, 1, (Object) null);
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        cause = th2;
                        anonymousClass12 = anonymousClass13;
                        SendChannel.DefaultImpls.close$default(RawWebSocketJvm.this.filtered, (Throwable) null, 1, (Object) null);
                        throw cause;
                    }
                } catch (Throwable th3) {
                    cause = th3;
                    SendChannel.DefaultImpls.close$default(RawWebSocketJvm.this.filtered, (Throwable) null, 1, (Object) null);
                    throw cause;
                }
            } catch (FrameTooBigException e) {
                cause = e;
                anonymousClass1 = this;
            } catch (ProtocolViolationException e2) {
                cause = e2;
                anonymousClass1 = this;
            } catch (CancellationException e3) {
                cause = e3;
                anonymousClass1 = this;
            } catch (Throwable th4) {
                cause = th4;
                anonymousClass1 = this;
            }
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        it = RawWebSocketJvm.this.getReader$ktor_websockets().getIncoming().iterator();
                        anonymousClass1 = this;
                        try {
                            anonymousClass1.L$0 = it;
                            anonymousClass1.label = 1;
                            hasNext = it.hasNext((Continuation) anonymousClass1);
                        } catch (FrameTooBigException e4) {
                            cause = e4;
                            anonymousClass1.L$0 = cause;
                            anonymousClass1.label = 3;
                            if (RawWebSocketJvm.this.getOutgoing().send(new Frame.Close(new CloseReason(CloseReason.Codes.TOO_BIG, cause.getMessage())), (Continuation) anonymousClass1) == $result3) {
                                return $result3;
                            }
                            cause2 = cause;
                            anonymousClass13 = anonymousClass1;
                            RawWebSocketJvm.this.filtered.close(cause2);
                            SendChannel.DefaultImpls.close$default(RawWebSocketJvm.this.filtered, (Throwable) null, 1, (Object) null);
                            return Unit.INSTANCE;
                        } catch (ProtocolViolationException e5) {
                            cause = e5;
                            anonymousClass1.L$0 = cause;
                            anonymousClass1.label = 4;
                            if (RawWebSocketJvm.this.getOutgoing().send(new Frame.Close(new CloseReason(CloseReason.Codes.PROTOCOL_ERROR, cause.getMessage())), (Continuation) anonymousClass1) == $result3) {
                                return $result3;
                            }
                            cause = cause;
                            anonymousClass13 = anonymousClass1;
                            RawWebSocketJvm.this.filtered.close(cause);
                            SendChannel.DefaultImpls.close$default(RawWebSocketJvm.this.filtered, (Throwable) null, 1, (Object) null);
                            return Unit.INSTANCE;
                        } catch (CancellationException e6) {
                            cause = e6;
                            RawWebSocketJvm.this.getReader$ktor_websockets().getIncoming().cancel(cause);
                            SendChannel.DefaultImpls.close$default(RawWebSocketJvm.this.filtered, (Throwable) null, 1, (Object) null);
                            return Unit.INSTANCE;
                        } catch (Throwable th5) {
                            cause = th5;
                            RawWebSocketJvm.this.filtered.close(cause);
                            SendChannel.DefaultImpls.close$default(RawWebSocketJvm.this.filtered, (Throwable) null, 1, (Object) null);
                            return Unit.INSTANCE;
                        }
                    } catch (FrameTooBigException e7) {
                        cause = e7;
                        anonymousClass1 = this;
                        anonymousClass1.L$0 = cause;
                        anonymousClass1.label = 3;
                        if (RawWebSocketJvm.this.getOutgoing().send(new Frame.Close(new CloseReason(CloseReason.Codes.TOO_BIG, cause.getMessage())), (Continuation) anonymousClass1) == $result3) {
                        }
                    } catch (ProtocolViolationException e8) {
                        cause = e8;
                        anonymousClass1 = this;
                        anonymousClass1.L$0 = cause;
                        anonymousClass1.label = 4;
                        if (RawWebSocketJvm.this.getOutgoing().send(new Frame.Close(new CloseReason(CloseReason.Codes.PROTOCOL_ERROR, cause.getMessage())), (Continuation) anonymousClass1) == $result3) {
                        }
                    } catch (CancellationException e9) {
                        cause = e9;
                        anonymousClass1 = this;
                        RawWebSocketJvm.this.getReader$ktor_websockets().getIncoming().cancel(cause);
                        SendChannel.DefaultImpls.close$default(RawWebSocketJvm.this.filtered, (Throwable) null, 1, (Object) null);
                        return Unit.INSTANCE;
                    } catch (Throwable th6) {
                        cause = th6;
                        anonymousClass1 = this;
                        RawWebSocketJvm.this.filtered.close(cause);
                        SendChannel.DefaultImpls.close$default(RawWebSocketJvm.this.filtered, (Throwable) null, 1, (Object) null);
                        return Unit.INSTANCE;
                    }
                    if (hasNext == $result3) {
                        return $result3;
                    }
                    Object obj2 = $result3;
                    $result2 = $result;
                    $result = hasNext;
                    anonymousClass14 = anonymousClass1;
                    channelIterator = it;
                    obj = obj2;
                    try {
                    } catch (FrameTooBigException e10) {
                        anonymousClass1 = anonymousClass14;
                        Object obj3 = obj;
                        cause = e10;
                        $result = $result2;
                        $result3 = obj3;
                        anonymousClass1.L$0 = cause;
                        anonymousClass1.label = 3;
                        if (RawWebSocketJvm.this.getOutgoing().send(new Frame.Close(new CloseReason(CloseReason.Codes.TOO_BIG, cause.getMessage())), (Continuation) anonymousClass1) == $result3) {
                        }
                    } catch (ProtocolViolationException e11) {
                        anonymousClass1 = anonymousClass14;
                        Object obj4 = obj;
                        cause = e11;
                        $result = $result2;
                        $result3 = obj4;
                        anonymousClass1.L$0 = cause;
                        anonymousClass1.label = 4;
                        if (RawWebSocketJvm.this.getOutgoing().send(new Frame.Close(new CloseReason(CloseReason.Codes.PROTOCOL_ERROR, cause.getMessage())), (Continuation) anonymousClass1) == $result3) {
                        }
                    } catch (CancellationException e12) {
                        anonymousClass1 = anonymousClass14;
                        Object obj5 = $result2;
                        cause = e12;
                        $result = obj5;
                        RawWebSocketJvm.this.getReader$ktor_websockets().getIncoming().cancel(cause);
                        SendChannel.DefaultImpls.close$default(RawWebSocketJvm.this.filtered, (Throwable) null, 1, (Object) null);
                        return Unit.INSTANCE;
                    } catch (Throwable th7) {
                        anonymousClass1 = anonymousClass14;
                        Object obj6 = $result2;
                        cause = th7;
                        $result = obj6;
                        RawWebSocketJvm.this.filtered.close(cause);
                        SendChannel.DefaultImpls.close$default(RawWebSocketJvm.this.filtered, (Throwable) null, 1, (Object) null);
                        return Unit.INSTANCE;
                    }
                    if (((Boolean) $result).booleanValue()) {
                        SendChannel.DefaultImpls.close$default(RawWebSocketJvm.this.filtered, (Throwable) null, 1, (Object) null);
                        return Unit.INSTANCE;
                    }
                    Frame frame = (Frame) channelIterator.next();
                    anonymousClass14.L$0 = channelIterator;
                    anonymousClass14.label = 2;
                    if (RawWebSocketJvm.this.filtered.send(frame, (Continuation) anonymousClass14) == obj) {
                        return obj;
                    }
                    $result = $result2;
                    $result3 = obj;
                    it = channelIterator;
                    anonymousClass1 = anonymousClass14;
                    anonymousClass1.L$0 = it;
                    anonymousClass1.label = 1;
                    hasNext = it.hasNext((Continuation) anonymousClass1);
                    if (hasNext == $result3) {
                    }
                case 1:
                    ChannelIterator channelIterator2 = (ChannelIterator) this.L$0;
                    ResultKt.throwOnFailure($result);
                    anonymousClass14 = this;
                    channelIterator = channelIterator2;
                    obj = $result3;
                    $result2 = $result;
                    if (((Boolean) $result).booleanValue()) {
                    }
                    break;
                case 2:
                    it = (ChannelIterator) this.L$0;
                    ResultKt.throwOnFailure($result);
                    anonymousClass1 = this;
                    anonymousClass1.L$0 = it;
                    anonymousClass1.label = 1;
                    hasNext = it.hasNext((Continuation) anonymousClass1);
                    if (hasNext == $result3) {
                    }
                    break;
                case 3:
                    cause2 = (FrameTooBigException) this.L$0;
                    ResultKt.throwOnFailure($result);
                    anonymousClass13 = this;
                    RawWebSocketJvm.this.filtered.close(cause2);
                    SendChannel.DefaultImpls.close$default(RawWebSocketJvm.this.filtered, (Throwable) null, 1, (Object) null);
                    return Unit.INSTANCE;
                case 4:
                    cause = (ProtocolViolationException) this.L$0;
                    ResultKt.throwOnFailure($result);
                    anonymousClass13 = this;
                    RawWebSocketJvm.this.filtered.close(cause);
                    SendChannel.DefaultImpls.close$default(RawWebSocketJvm.this.filtered, (Throwable) null, 1, (Object) null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object flush(Continuation<? super Unit> continuation) {
        Object flush = this.writer.flush(continuation);
        return flush == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flush : Unit.INSTANCE;
    }

    @Override // io.ktor.websocket.WebSocketSession
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use cancel() instead.", replaceWith = @ReplaceWith(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    public void terminate() {
        SendChannel.DefaultImpls.close$default(getOutgoing(), (Throwable) null, 1, (Object) null);
        this.socketJob.complete();
    }
}