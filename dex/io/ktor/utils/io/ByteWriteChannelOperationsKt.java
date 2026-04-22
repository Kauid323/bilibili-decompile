package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.io.Buffer;
import kotlinx.io.RawSource;
import kotlinx.io.Segment;
import kotlinx.io.SegmentKt;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* compiled from: ByteWriteChannelOperations.kt */
@Metadata(d1 = {"\u0000Á\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004*\u0001T\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\tH\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\fH\u0086@¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0011\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0015\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001c\u0010\u0018\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0017H\u0086@¢\u0006\u0004\b\u0018\u0010\u0019\u001a0\u0010\u001c\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u001f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001eH\u0086@¢\u0006\u0004\b\u001f\u0010 \u001a\u001c\u0010!\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0017H\u0086@¢\u0006\u0004\b!\u0010\u0019\u001a\u001c\u0010$\u001a\u00020\u0003*\u00020\u00002\u0006\u0010#\u001a\u00020\"H\u0086@¢\u0006\u0004\b$\u0010%\u001a\u001c\u0010$\u001a\u00020\u0003*\u00020\u00002\u0006\u0010#\u001a\u00020\u0013H\u0086@¢\u0006\u0004\b$\u0010\u0016\u001a\u001b\u0010(\u001a\u00020\u0003*\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b(\u0010)\u001a\u0014\u0010+\u001a\u00020\u0003*\u00020*H\u0086@¢\u0006\u0004\b+\u0010,\u001a\u0015\u0010/\u001a\u00060-j\u0002`.*\u00020*¢\u0006\u0004\b/\u00100\u001a\u001f\u00103\u001a\u00020\u0003*\u00020*2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000301¢\u0006\u0004\b3\u00104\u001a\u0011\u00105\u001a\u00020\u0003*\u00020*¢\u0006\u0004\b5\u00106\u001aN\u0010B\u001a\u00020A*\u0002072\b\b\u0002\u00109\u001a\u0002082\b\b\u0002\u0010;\u001a\u00020:2'\u00102\u001a#\b\u0001\u0012\u0004\u0012\u00020=\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030>\u0012\u0006\u0012\u0004\u0018\u00010?0<¢\u0006\u0002\b@¢\u0006\u0004\bB\u0010C\u001aL\u0010B\u001a\u00020A*\u0002072\b\b\u0002\u00109\u001a\u0002082\u0006\u0010E\u001a\u00020D2'\u00102\u001a#\b\u0001\u0012\u0004\u0012\u00020=\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030>\u0012\u0006\u0012\u0004\u0018\u00010?0<¢\u0006\u0002\b@¢\u0006\u0004\bB\u0010F\u001a>\u0010I\u001a\u00020\t*\u00020\u00002\b\b\u0002\u0010G\u001a\u00020\t2\u001e\u00102\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0HH\u0086@¢\u0006\u0004\bI\u0010J\u001a\u0014\u0010K\u001a\u00020\u0003*\u00020\u0000H\u0086@¢\u0006\u0004\bK\u0010L\u001a/\u0010O\u001a\u00020\u0003\"\u0004\b\u0000\u0010M*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000>\u0012\u0006\u0012\u0004\u0018\u00010?0NH\u0000¢\u0006\u0004\bO\u0010P\"\u0015\u0010Q\u001a\u00020:*\u00020*8F¢\u0006\u0006\u001a\u0004\bQ\u0010R\"\u0015\u0010S\u001a\u00020:*\u00020*8F¢\u0006\u0006\u001a\u0004\bS\u0010R\"\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006W"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "", "value", "", "writeByte", "(Lio/ktor/utils/io/ByteWriteChannel;BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeShort", "(Lio/ktor/utils/io/ByteWriteChannel;SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeInt", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeLong", "(Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "array", "writeByteArray", "(Lio/ktor/utils/io/ByteWriteChannel;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/Source;", "source", "writeSource", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlinx/io/Source;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeString", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startIndex", "endIndex", "writeFully", "(Lio/ktor/utils/io/ByteWriteChannel;[BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/RawSource;", "writeBuffer", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlinx/io/RawSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeStringUtf8", "Lkotlinx/io/Buffer;", "copy", "writePacket", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlinx/io/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "close", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/Throwable;)V", "Lio/ktor/utils/io/ChannelJob;", "join", "(Lio/ktor/utils/io/ChannelJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lio/ktor/utils/io/CancellationException;", "getCancellationException", "(Lio/ktor/utils/io/ChannelJob;)Ljava/util/concurrent/CancellationException;", "Lkotlin/Function0;", "block", "invokeOnCompletion", "(Lio/ktor/utils/io/ChannelJob;Lkotlin/jvm/functions/Function0;)V", "cancel", "(Lio/ktor/utils/io/ChannelJob;)V", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "", "autoFlush", "Lkotlin/Function2;", "Lio/ktor/utils/io/WriterScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "Lio/ktor/utils/io/WriterJob;", "writer", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ZLkotlin/jvm/functions/Function2;)Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ByteChannel;", "channel", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lio/ktor/utils/io/ByteChannel;Lkotlin/jvm/functions/Function2;)Lio/ktor/utils/io/WriterJob;", "desiredSpace", "Lkotlin/Function3;", "write", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFreeSpace", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "Lkotlin/Function1;", "fireAndForget", "(Lkotlin/jvm/functions/Function1;)V", "isCompleted", "(Lio/ktor/utils/io/ChannelJob;)Z", "isCancelled", "io/ktor/utils/io/ByteWriteChannelOperationsKt$NO_CALLBACK$1", "NO_CALLBACK", "Lio/ktor/utils/io/ByteWriteChannelOperationsKt$NO_CALLBACK$1;", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ByteWriteChannelOperationsKt {
    private static final ByteWriteChannelOperationsKt$NO_CALLBACK$1 NO_CALLBACK = new Continuation<Object>() { // from class: io.ktor.utils.io.ByteWriteChannelOperationsKt$NO_CALLBACK$1
        private final CoroutineContext context = EmptyCoroutineContext.INSTANCE;

        public CoroutineContext getContext() {
            return this.context;
        }

        public void resumeWith(Object result) {
        }
    };

    public static final Object writeByte(ByteWriteChannel $this$writeByte, byte value, Continuation<? super Unit> continuation) {
        $this$writeByte.getWriteBuffer().writeByte(value);
        Object flushIfNeeded = ByteWriteChannelKt.flushIfNeeded($this$writeByte, continuation);
        return flushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeShort(ByteWriteChannel $this$writeShort, short value, Continuation<? super Unit> continuation) {
        $this$writeShort.getWriteBuffer().writeShort(value);
        Object flushIfNeeded = ByteWriteChannelKt.flushIfNeeded($this$writeShort, continuation);
        return flushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeInt(ByteWriteChannel $this$writeInt, int value, Continuation<? super Unit> continuation) {
        $this$writeInt.getWriteBuffer().writeInt(value);
        Object flushIfNeeded = ByteWriteChannelKt.flushIfNeeded($this$writeInt, continuation);
        return flushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeLong(ByteWriteChannel $this$writeLong, long value, Continuation<? super Unit> continuation) {
        $this$writeLong.getWriteBuffer().writeLong(value);
        Object flushIfNeeded = ByteWriteChannelKt.flushIfNeeded($this$writeLong, continuation);
        return flushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeByteArray(ByteWriteChannel $this$writeByteArray, byte[] array, Continuation<? super Unit> continuation) {
        Sink.-CC.write$default($this$writeByteArray.getWriteBuffer(), array, 0, 0, 6, (Object) null);
        Object flushIfNeeded = ByteWriteChannelKt.flushIfNeeded($this$writeByteArray, continuation);
        return flushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeSource(ByteWriteChannel $this$writeSource, Source source, Continuation<? super Unit> continuation) {
        $this$writeSource.getWriteBuffer().transferFrom((RawSource) source);
        Object flushIfNeeded = ByteWriteChannelKt.flushIfNeeded($this$writeSource, continuation);
        return flushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeString(ByteWriteChannel $this$writeString, String value, Continuation<? super Unit> continuation) {
        StringsKt.writeText$default($this$writeString.getWriteBuffer(), value, 0, 0, (Charset) null, 14, (Object) null);
        Object flushIfNeeded = ByteWriteChannelKt.flushIfNeeded($this$writeString, continuation);
        return flushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flushIfNeeded : Unit.INSTANCE;
    }

    public static /* synthetic */ Object writeFully$default(ByteWriteChannel byteWriteChannel, byte[] bArr, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return writeFully(byteWriteChannel, bArr, i, i2, continuation);
    }

    public static final Object writeFully(ByteWriteChannel $this$writeFully, byte[] value, int startIndex, int endIndex, Continuation<? super Unit> continuation) {
        $this$writeFully.getWriteBuffer().write(value, startIndex, endIndex);
        Object flushIfNeeded = ByteWriteChannelKt.flushIfNeeded($this$writeFully, continuation);
        return flushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeBuffer(ByteWriteChannel $this$writeBuffer, RawSource value, Continuation<? super Unit> continuation) {
        $this$writeBuffer.getWriteBuffer().transferFrom(value);
        Object flushIfNeeded = ByteWriteChannelKt.flushIfNeeded($this$writeBuffer, continuation);
        return flushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeStringUtf8(ByteWriteChannel $this$writeStringUtf8, String value, Continuation<? super Unit> continuation) {
        StringsKt.writeText$default($this$writeStringUtf8.getWriteBuffer(), value, 0, 0, (Charset) null, 14, (Object) null);
        Object flushIfNeeded = ByteWriteChannelKt.flushIfNeeded($this$writeStringUtf8, continuation);
        return flushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writePacket(ByteWriteChannel $this$writePacket, Buffer copy, Continuation<? super Unit> continuation) {
        $this$writePacket.getWriteBuffer().transferFrom((RawSource) copy);
        Object flushIfNeeded = ByteWriteChannelKt.flushIfNeeded($this$writePacket, continuation);
        return flushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writePacket(ByteWriteChannel $this$writePacket, Source copy, Continuation<? super Unit> continuation) {
        $this$writePacket.getWriteBuffer().transferFrom((RawSource) copy);
        Object flushIfNeeded = ByteWriteChannelKt.flushIfNeeded($this$writePacket, continuation);
        return flushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flushIfNeeded : Unit.INSTANCE;
    }

    public static final void close(ByteWriteChannel $this$close, Throwable cause) {
        Intrinsics.checkNotNullParameter($this$close, "<this>");
        if (cause == null) {
            fireAndForget(new ByteWriteChannelOperationsKt$close$1($this$close));
        } else {
            $this$close.cancel(cause);
        }
    }

    public static final Object join(ChannelJob $this$join, Continuation<? super Unit> continuation) {
        Object join = $this$join.getJob().join(continuation);
        return join == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? join : Unit.INSTANCE;
    }

    public static final boolean isCompleted(ChannelJob $this$isCompleted) {
        Intrinsics.checkNotNullParameter($this$isCompleted, "<this>");
        return $this$isCompleted.getJob().isCompleted();
    }

    public static final boolean isCancelled(ChannelJob $this$isCancelled) {
        Intrinsics.checkNotNullParameter($this$isCancelled, "<this>");
        return $this$isCancelled.getJob().isCancelled();
    }

    public static final CancellationException getCancellationException(ChannelJob $this$getCancellationException) {
        Intrinsics.checkNotNullParameter($this$getCancellationException, "<this>");
        return $this$getCancellationException.getJob().getCancellationException();
    }

    public static final void invokeOnCompletion(ChannelJob $this$invokeOnCompletion, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter($this$invokeOnCompletion, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        $this$invokeOnCompletion.getJob().invokeOnCompletion(new Function1() { // from class: io.ktor.utils.io.ByteWriteChannelOperationsKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeOnCompletion$lambda$0;
                invokeOnCompletion$lambda$0 = ByteWriteChannelOperationsKt.invokeOnCompletion$lambda$0(function0, (Throwable) obj);
                return invokeOnCompletion$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeOnCompletion$lambda$0(Function0 $block, Throwable it) {
        $block.invoke();
        return Unit.INSTANCE;
    }

    public static final void cancel(ChannelJob $this$cancel) {
        Intrinsics.checkNotNullParameter($this$cancel, "<this>");
        Job.DefaultImpls.cancel$default($this$cancel.getJob(), (CancellationException) null, 1, (Object) null);
    }

    public static /* synthetic */ WriterJob writer$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = (CoroutineContext) EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return writer(coroutineScope, coroutineContext, z, function2);
    }

    public static final WriterJob writer(CoroutineScope $this$writer, CoroutineContext coroutineContext, boolean autoFlush, Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter($this$writer, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(function2, "block");
        return writer($this$writer, coroutineContext, new ByteChannel(false, 1, null), function2);
    }

    public static /* synthetic */ WriterJob writer$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, ByteChannel byteChannel, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = (CoroutineContext) EmptyCoroutineContext.INSTANCE;
        }
        return writer(coroutineScope, coroutineContext, byteChannel, function2);
    }

    public static final WriterJob writer(CoroutineScope $this$writer, CoroutineContext coroutineContext, final ByteChannel channel, Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter($this$writer, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(function2, "block");
        Job $this$writer_u24lambda_u242 = BuildersKt.launch$default($this$writer, coroutineContext, (CoroutineStart) null, new ByteWriteChannelOperationsKt$writer$job$1(function2, channel, null), 2, (Object) null);
        $this$writer_u24lambda_u242.invokeOnCompletion(new Function1() { // from class: io.ktor.utils.io.ByteWriteChannelOperationsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit writer$lambda$2$lambda$1;
                writer$lambda$2$lambda$1 = ByteWriteChannelOperationsKt.writer$lambda$2$lambda$1(ByteChannel.this, (Throwable) obj);
                return writer$lambda$2$lambda$1;
            }
        });
        return new WriterJob(channel, $this$writer_u24lambda_u242);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writer$lambda$2$lambda$1(ByteChannel $channel, Throwable it) {
        if (it != null && !$channel.isClosedForWrite()) {
            $channel.cancel(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object write(ByteWriteChannel $this$write, int desiredSpace, Function3<? super byte[], ? super Integer, ? super Integer, Integer> function3, Continuation<? super Integer> continuation) {
        ByteWriteChannelOperationsKt$write$1 byteWriteChannelOperationsKt$write$1;
        int written;
        if (continuation instanceof ByteWriteChannelOperationsKt$write$1) {
            byteWriteChannelOperationsKt$write$1 = (ByteWriteChannelOperationsKt$write$1) continuation;
            if ((byteWriteChannelOperationsKt$write$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteWriteChannelOperationsKt$write$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteWriteChannelOperationsKt$write$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteWriteChannelOperationsKt$write$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        int before = BytePacketBuilderKt.getSize($this$write.getWriteBuffer());
                        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
                        Buffer buffer$iv = $this$write.getWriteBuffer().getBuffer();
                        Segment tail$iv = buffer$iv.writableSegment(desiredSpace);
                        boolean z = false;
                        byte[] data$iv = tail$iv.dataAsByteArray(false);
                        int bytesWritten$iv = ((Number) function3.invoke(data$iv, Boxing.boxInt(tail$iv.getLimit()), Boxing.boxInt(data$iv.length))).intValue();
                        if (bytesWritten$iv == desiredSpace) {
                            tail$iv.writeBackData(data$iv, bytesWritten$iv);
                            tail$iv.setLimit(tail$iv.getLimit() + bytesWritten$iv);
                            buffer$iv.setSizeMut(buffer$iv.getSizeMut() + bytesWritten$iv);
                        } else {
                            if (bytesWritten$iv >= 0 && bytesWritten$iv <= tail$iv.getRemainingCapacity()) {
                                z = true;
                            }
                            if (!z) {
                                throw new IllegalStateException(("Invalid number of bytes written: " + bytesWritten$iv + ". Should be in 0.." + tail$iv.getRemainingCapacity()).toString());
                            }
                            if (bytesWritten$iv != 0) {
                                tail$iv.writeBackData(data$iv, bytesWritten$iv);
                                tail$iv.setLimit(tail$iv.getLimit() + bytesWritten$iv);
                                buffer$iv.setSizeMut(buffer$iv.getSizeMut() + bytesWritten$iv);
                            } else if (SegmentKt.isEmpty(tail$iv)) {
                                buffer$iv.recycleTail();
                            }
                        }
                        int after = BytePacketBuilderKt.getSize($this$write.getWriteBuffer());
                        int written2 = after - before;
                        byteWriteChannelOperationsKt$write$1.I$0 = written2;
                        byteWriteChannelOperationsKt$write$1.label = 1;
                        if (ByteWriteChannelKt.flushIfNeeded($this$write, byteWriteChannelOperationsKt$write$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        written = written2;
                        break;
                        break;
                    case 1:
                        written = byteWriteChannelOperationsKt$write$1.I$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxInt(written);
            }
        }
        byteWriteChannelOperationsKt$write$1 = new ByteWriteChannelOperationsKt$write$1(continuation);
        Object $result2 = byteWriteChannelOperationsKt$write$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteWriteChannelOperationsKt$write$1.label) {
        }
        return Boxing.boxInt(written);
    }

    public static /* synthetic */ Object write$default(ByteWriteChannel byteWriteChannel, int i, Function3 function3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return write(byteWriteChannel, i, function3, continuation);
    }

    public static final Object awaitFreeSpace(ByteWriteChannel $this$awaitFreeSpace, Continuation<? super Unit> continuation) {
        Object flush = $this$awaitFreeSpace.flush(continuation);
        return flush == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flush : Unit.INSTANCE;
    }

    public static final <R> void fireAndForget(Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        CancellableKt.startCoroutineCancellable(function1, NO_CALLBACK);
    }
}