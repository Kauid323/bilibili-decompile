package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import com.bilibili.droid.thread.BCoreThreadPoolKt;
import io.ktor.util.NIOKt;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperations_jvmKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* compiled from: WebSocketReader.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00013B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b+\u0010,\u0012\u0004\b-\u0010.R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020'0/8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00064"}, d2 = {"Lio/ktor/websocket/WebSocketReader;", "Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/utils/io/ByteReadChannel;", "byteChannel", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", Column.INVAL_VALUE, "maxFrameSize", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/CoroutineContext;JLio/ktor/utils/io/pool/ObjectPool;)V", "buffer", Column.INVAL_VALUE, "readLoop", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseLoop", "handleFrameIfProduced", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "J", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "Lio/ktor/websocket/WebSocketReader$State;", "state", "Lio/ktor/websocket/WebSocketReader$State;", "Lio/ktor/websocket/FrameParser;", "frameParser", "Lio/ktor/websocket/FrameParser;", "Lio/ktor/websocket/SimpleFrameCollector;", "collector", "Lio/ktor/websocket/SimpleFrameCollector;", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", BCoreThreadPoolKt.REPORT_WHEN_QUEUE, "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/Job;", "readerJob", "Lkotlinx/coroutines/Job;", "getReaderJob$annotations", "()V", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "State", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WebSocketReader implements CoroutineScope {
    private final ByteReadChannel byteChannel;
    private final SimpleFrameCollector collector;
    private final CoroutineContext coroutineContext;
    private final FrameParser frameParser;
    private long maxFrameSize;
    private final Channel<Frame> queue;
    private final Job readerJob;
    private State state;

    /* compiled from: WebSocketReader.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[State.BODY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[State.CLOSED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static /* synthetic */ void getReaderJob$annotations() {
    }

    public WebSocketReader(ByteReadChannel byteChannel, CoroutineContext coroutineContext, long maxFrameSize, ObjectPool<ByteBuffer> objectPool) {
        Intrinsics.checkNotNullParameter(byteChannel, "byteChannel");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        this.byteChannel = byteChannel;
        this.coroutineContext = coroutineContext;
        this.maxFrameSize = maxFrameSize;
        this.state = State.HEADER;
        this.frameParser = new FrameParser();
        this.collector = new SimpleFrameCollector();
        this.queue = ChannelKt.Channel$default(8, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.readerJob = BuildersKt.launch(this, new CoroutineName("ws-reader"), CoroutineStart.ATOMIC, new WebSocketReader$readerJob$1(objectPool, this, null));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ WebSocketReader(ByteReadChannel byteReadChannel, CoroutineContext coroutineContext, long j, ObjectPool objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteReadChannel, coroutineContext, j, r5);
        ObjectPool objectPool2;
        if ((i & 8) == 0) {
            objectPool2 = objectPool;
        } else {
            objectPool2 = ByteBufferPoolKt.getKtorDefaultPool();
        }
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final long getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public final void setMaxFrameSize(long j) {
        this.maxFrameSize = j;
    }

    public final ReceiveChannel<Frame> getIncoming() {
        return this.queue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0089 -> B:28:0x008c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readLoop(ByteBuffer buffer, Continuation<? super Unit> continuation) {
        WebSocketReader$readLoop$1 webSocketReader$readLoop$1;
        WebSocketReader webSocketReader;
        WebSocketReader webSocketReader2;
        Object obj;
        Object $result;
        if (continuation instanceof WebSocketReader$readLoop$1) {
            webSocketReader$readLoop$1 = (WebSocketReader$readLoop$1) continuation;
            if ((webSocketReader$readLoop$1.label & Integer.MIN_VALUE) != 0) {
                webSocketReader$readLoop$1.label -= Integer.MIN_VALUE;
                Object $result2 = webSocketReader$readLoop$1.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (webSocketReader$readLoop$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        webSocketReader = this;
                        buffer.clear();
                        if (webSocketReader.state != State.CLOSED) {
                            ByteReadChannel byteReadChannel = webSocketReader.byteChannel;
                            webSocketReader$readLoop$1.L$0 = webSocketReader;
                            webSocketReader$readLoop$1.L$1 = buffer;
                            webSocketReader$readLoop$1.label = 1;
                            Object readAvailable = ByteReadChannelOperations_jvmKt.readAvailable(byteReadChannel, buffer, webSocketReader$readLoop$1);
                            if (readAvailable == $result3) {
                                return $result3;
                            }
                            Object obj2 = $result3;
                            $result = $result2;
                            $result2 = readAvailable;
                            webSocketReader2 = webSocketReader;
                            obj = obj2;
                            if (((Number) $result2).intValue() != -1) {
                                webSocketReader2.state = State.CLOSED;
                            } else {
                                buffer.flip();
                                webSocketReader$readLoop$1.L$0 = webSocketReader2;
                                webSocketReader$readLoop$1.L$1 = buffer;
                                webSocketReader$readLoop$1.label = 2;
                                if (webSocketReader2.parseLoop(buffer, webSocketReader$readLoop$1) == obj) {
                                    return obj;
                                }
                                $result2 = $result;
                                $result3 = obj;
                                webSocketReader = webSocketReader2;
                                buffer.compact();
                                if (webSocketReader.state != State.CLOSED) {
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        buffer = (ByteBuffer) webSocketReader$readLoop$1.L$1;
                        ResultKt.throwOnFailure($result2);
                        webSocketReader2 = (WebSocketReader) webSocketReader$readLoop$1.L$0;
                        obj = $result3;
                        $result = $result2;
                        if (((Number) $result2).intValue() != -1) {
                        }
                        break;
                    case 2:
                        buffer = (ByteBuffer) webSocketReader$readLoop$1.L$1;
                        webSocketReader = (WebSocketReader) webSocketReader$readLoop$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        buffer.compact();
                        if (webSocketReader.state != State.CLOSED) {
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        webSocketReader$readLoop$1 = new WebSocketReader$readLoop$1(this, continuation);
        Object $result22 = webSocketReader$readLoop$1.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (webSocketReader$readLoop$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object parseLoop(ByteBuffer buffer, Continuation<? super Unit> continuation) {
        WebSocketReader$parseLoop$1 webSocketReader$parseLoop$1;
        WebSocketReader webSocketReader;
        if (continuation instanceof WebSocketReader$parseLoop$1) {
            webSocketReader$parseLoop$1 = (WebSocketReader$parseLoop$1) continuation;
            if ((webSocketReader$parseLoop$1.label & Integer.MIN_VALUE) != 0) {
                webSocketReader$parseLoop$1.label -= Integer.MIN_VALUE;
                Object $result = webSocketReader$parseLoop$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (webSocketReader$parseLoop$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        webSocketReader = this;
                        break;
                    case 1:
                        buffer = (ByteBuffer) webSocketReader$parseLoop$1.L$1;
                        webSocketReader = (WebSocketReader) webSocketReader$parseLoop$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    case 2:
                        buffer = (ByteBuffer) webSocketReader$parseLoop$1.L$1;
                        webSocketReader = (WebSocketReader) webSocketReader$parseLoop$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (buffer.hasRemaining()) {
                    switch (WhenMappings.$EnumSwitchMapping$0[webSocketReader.state.ordinal()]) {
                        case 1:
                            webSocketReader.frameParser.frame(buffer);
                            if (webSocketReader.frameParser.getBodyReady()) {
                                webSocketReader.state = State.BODY;
                                if (webSocketReader.frameParser.getLength() > 2147483647L || webSocketReader.frameParser.getLength() > webSocketReader.maxFrameSize) {
                                    throw new FrameTooBigException(webSocketReader.frameParser.getLength());
                                }
                                webSocketReader.collector.start((int) webSocketReader.frameParser.getLength(), buffer);
                                webSocketReader$parseLoop$1.L$0 = webSocketReader;
                                webSocketReader$parseLoop$1.L$1 = buffer;
                                webSocketReader$parseLoop$1.label = 1;
                                if (webSocketReader.handleFrameIfProduced(webSocketReader$parseLoop$1) != coroutine_suspended) {
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            } else {
                                return Unit.INSTANCE;
                            }
                        case 2:
                            webSocketReader.collector.handle(buffer);
                            webSocketReader$parseLoop$1.L$0 = webSocketReader;
                            webSocketReader$parseLoop$1.L$1 = buffer;
                            webSocketReader$parseLoop$1.label = 2;
                            if (webSocketReader.handleFrameIfProduced(webSocketReader$parseLoop$1) != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 3:
                            return Unit.INSTANCE;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
                return Unit.INSTANCE;
            }
        }
        webSocketReader$parseLoop$1 = new WebSocketReader$parseLoop$1(this, continuation);
        Object $result2 = webSocketReader$parseLoop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (webSocketReader$parseLoop$1.label) {
        }
        while (buffer.hasRemaining()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleFrameIfProduced(Continuation<? super Unit> continuation) {
        WebSocketReader$handleFrameIfProduced$1 webSocketReader$handleFrameIfProduced$1;
        WebSocketReader webSocketReader;
        if (continuation instanceof WebSocketReader$handleFrameIfProduced$1) {
            webSocketReader$handleFrameIfProduced$1 = (WebSocketReader$handleFrameIfProduced$1) continuation;
            if ((webSocketReader$handleFrameIfProduced$1.label & Integer.MIN_VALUE) != 0) {
                webSocketReader$handleFrameIfProduced$1.label -= Integer.MIN_VALUE;
                Object $result = webSocketReader$handleFrameIfProduced$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (webSocketReader$handleFrameIfProduced$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!this.collector.getHasRemaining()) {
                            this.state = this.frameParser.getFrameType() == FrameType.CLOSE ? State.CLOSED : State.HEADER;
                            FrameParser $this$handleFrameIfProduced_u24lambda_u240 = this.frameParser;
                            Frame frame = Frame.Companion.byType($this$handleFrameIfProduced_u24lambda_u240.getFin(), $this$handleFrameIfProduced_u24lambda_u240.getFrameType(), NIOKt.moveToByteArray(this.collector.take($this$handleFrameIfProduced_u24lambda_u240.getMaskKey())), $this$handleFrameIfProduced_u24lambda_u240.getRsv1(), $this$handleFrameIfProduced_u24lambda_u240.getRsv2(), $this$handleFrameIfProduced_u24lambda_u240.getRsv3());
                            Channel<Frame> channel = this.queue;
                            webSocketReader$handleFrameIfProduced$1.L$0 = this;
                            webSocketReader$handleFrameIfProduced$1.label = 1;
                            if (channel.send(frame, webSocketReader$handleFrameIfProduced$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            webSocketReader = this;
                            webSocketReader.frameParser.bodyComplete();
                            break;
                        }
                        break;
                    case 1:
                        webSocketReader = (WebSocketReader) webSocketReader$handleFrameIfProduced$1.L$0;
                        ResultKt.throwOnFailure($result);
                        webSocketReader.frameParser.bodyComplete();
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        webSocketReader$handleFrameIfProduced$1 = new WebSocketReader$handleFrameIfProduced$1(this, continuation);
        Object $result2 = webSocketReader$handleFrameIfProduced$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (webSocketReader$handleFrameIfProduced$1.label) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WebSocketReader.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/websocket/WebSocketReader$State;", Column.INVAL_VALUE, "<init>", "(Ljava/lang/String;I)V", "HEADER", "BODY", "CLOSED", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86/202602230606352175db5d-4dcb-42b5-ae97-9aefdbbfec86.dex */
    public enum State {
        HEADER,
        BODY,
        CLOSED;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }
    }
}