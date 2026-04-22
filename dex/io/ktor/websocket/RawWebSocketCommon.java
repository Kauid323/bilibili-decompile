package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.websocket.WebSocketSession;
import java.util.List;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: RawWebSocketCommon.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001?B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\"\u0010\u0007\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010+\u001a\u0004\b,\u0010-R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020#0.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020#028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001e\u0010:\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000307068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010=¨\u0006@"}, d2 = {"Lio/ktor/websocket/RawWebSocketCommon;", "Lio/ktor/websocket/WebSocketSession;", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", Column.INVAL_VALUE, "maxFrameSize", Column.INVAL_VALUE, "masking", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/CoroutineContext;)V", Column.INVAL_VALUE, "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "terminate", "()V", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "J", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "Z", "getMasking", "()Z", "setMasking", "(Z)V", "Lkotlinx/coroutines/CompletableJob;", "socketJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", "_incoming", "Lkotlinx/coroutines/channels/Channel;", Column.INVAL_VALUE, "_outgoing", Column.INVAL_VALUE, "lastOpcode", "I", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", Column.INVAL_VALUE, "Lio/ktor/websocket/WebSocketExtension;", "getExtensions", "()Ljava/util/List;", "extensions", "Lkotlinx/coroutines/Job;", "writerJob", "Lkotlinx/coroutines/Job;", "readerJob", "FlushRequest", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RawWebSocketCommon implements WebSocketSession {
    private final Channel<Frame> _incoming;
    private final Channel<Object> _outgoing;
    private final CoroutineContext coroutineContext;
    private final ByteReadChannel input;
    private int lastOpcode;
    private boolean masking;
    private long maxFrameSize;
    private final ByteWriteChannel output;
    private final Job readerJob;
    private final CompletableJob socketJob;
    private final Job writerJob;

    @Override // io.ktor.websocket.WebSocketSession
    public Object send(Frame frame, Continuation<? super Unit> continuation) {
        return WebSocketSession.DefaultImpls.send(this, frame, continuation);
    }

    public RawWebSocketCommon(ByteReadChannel input, ByteWriteChannel output, long maxFrameSize, boolean masking, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.input = input;
        this.output = output;
        this.maxFrameSize = maxFrameSize;
        this.masking = masking;
        this.socketJob = JobKt.Job(coroutineContext.get(Job.Key));
        this._incoming = ChannelKt.Channel$default(8, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this._outgoing = ChannelKt.Channel$default(8, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.coroutineContext = coroutineContext.plus(this.socketJob).plus(new CoroutineName("raw-ws"));
        this.writerJob = BuildersKt.launch(this, new CoroutineName("ws-writer"), CoroutineStart.ATOMIC, new RawWebSocketCommon$writerJob$1(this, null));
        this.readerJob = BuildersKt.launch(this, new CoroutineName("ws-reader"), CoroutineStart.ATOMIC, new RawWebSocketCommon$readerJob$1(this, null));
        this.socketJob.complete();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RawWebSocketCommon(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteReadChannel, byteWriteChannel, r3, r5, coroutineContext);
        long j2;
        boolean z2;
        if ((i & 4) == 0) {
            j2 = j;
        } else {
            j2 = 2147483647L;
        }
        if ((i & 8) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return this.maxFrameSize;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j) {
        this.maxFrameSize = j;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return this.masking;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z) {
        this.masking = z;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public ReceiveChannel<Frame> getIncoming() {
        return this._incoming;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public SendChannel<Frame> getOutgoing() {
        return this._outgoing;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|36|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007a, code lost:
        r5.complete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007d, code lost:
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007f, code lost:
        r5.complete();
        r5 = r7.writerJob;
        r0.L$0 = r6;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0091, code lost:
        if (r5.join(r0) == r2) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0093, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0094, code lost:
        r5 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a7 A[RETURN] */
    @Override // io.ktor.websocket.WebSocketSession
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object flush(Continuation<? super Unit> continuation) {
        RawWebSocketCommon$flush$1 rawWebSocketCommon$flush$1;
        FlushRequest flushRequest;
        RawWebSocketCommon rawWebSocketCommon;
        FlushRequest it;
        if (continuation instanceof RawWebSocketCommon$flush$1) {
            rawWebSocketCommon$flush$1 = (RawWebSocketCommon$flush$1) continuation;
            if ((rawWebSocketCommon$flush$1.label & Integer.MIN_VALUE) != 0) {
                rawWebSocketCommon$flush$1.label -= Integer.MIN_VALUE;
                Object $result = rawWebSocketCommon$flush$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rawWebSocketCommon$flush$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        rawWebSocketCommon = this;
                        flushRequest = new FlushRequest(rawWebSocketCommon.getCoroutineContext().get(Job.Key));
                        it = flushRequest;
                        Channel<Object> channel = rawWebSocketCommon._outgoing;
                        rawWebSocketCommon$flush$1.L$0 = rawWebSocketCommon;
                        rawWebSocketCommon$flush$1.L$1 = flushRequest;
                        rawWebSocketCommon$flush$1.L$2 = it;
                        rawWebSocketCommon$flush$1.label = 1;
                        if (channel.send(it, rawWebSocketCommon$flush$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        rawWebSocketCommon$flush$1.L$0 = null;
                        rawWebSocketCommon$flush$1.L$1 = null;
                        rawWebSocketCommon$flush$1.L$2 = null;
                        rawWebSocketCommon$flush$1.label = 3;
                        if (flushRequest.await(rawWebSocketCommon$flush$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        it = (FlushRequest) rawWebSocketCommon$flush$1.L$2;
                        flushRequest = (FlushRequest) rawWebSocketCommon$flush$1.L$1;
                        rawWebSocketCommon = (RawWebSocketCommon) rawWebSocketCommon$flush$1.L$0;
                        ResultKt.throwOnFailure($result);
                        rawWebSocketCommon$flush$1.L$0 = null;
                        rawWebSocketCommon$flush$1.L$1 = null;
                        rawWebSocketCommon$flush$1.L$2 = null;
                        rawWebSocketCommon$flush$1.label = 3;
                        if (flushRequest.await(rawWebSocketCommon$flush$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        FlushRequest flushRequest2 = (FlushRequest) rawWebSocketCommon$flush$1.L$0;
                        ResultKt.throwOnFailure($result);
                        flushRequest = flushRequest2;
                        rawWebSocketCommon$flush$1.L$0 = null;
                        rawWebSocketCommon$flush$1.L$1 = null;
                        rawWebSocketCommon$flush$1.L$2 = null;
                        rawWebSocketCommon$flush$1.label = 3;
                        if (flushRequest.await(rawWebSocketCommon$flush$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        rawWebSocketCommon$flush$1 = new RawWebSocketCommon$flush$1(this, continuation);
        Object $result2 = rawWebSocketCommon$flush$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rawWebSocketCommon$flush$1.label) {
        }
    }

    @Override // io.ktor.websocket.WebSocketSession
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use cancel() instead.", replaceWith = @ReplaceWith(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    public void terminate() {
        SendChannel.DefaultImpls.close$default(getOutgoing(), (Throwable) null, 1, (Object) null);
        this.socketJob.complete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RawWebSocketCommon.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/RawWebSocketCommon$FlushRequest;", Column.INVAL_VALUE, "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", Column.INVAL_VALUE, "complete", "()Z", Column.INVAL_VALUE, "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CompletableJob;", "done", "Lkotlinx/coroutines/CompletableJob;", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86.dex */
    public static final class FlushRequest {
        private final CompletableJob done;

        public FlushRequest(Job parent) {
            this.done = JobKt.Job(parent);
        }

        public final boolean complete() {
            return this.done.complete();
        }

        public final Object await(Continuation<? super Unit> continuation) {
            Object join = this.done.join(continuation);
            return join == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? join : Unit.INSTANCE;
        }
    }
}