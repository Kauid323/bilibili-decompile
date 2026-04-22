package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.BytePacketBuilderExtensions_jvmKt;
import io.ktor.utils.io.core.ByteReadPacketExtensions_jvmKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.SourcesJvmKt;
import kotlinx.io.bytestring.ByteString;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* compiled from: ByteReadChannelOperations.jvm.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a&\u0010\u0010\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0014\u0010\b\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0016\u0010\b\u001a%\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0017¢\u0006\u0004\b\u0007\u0010\u0019\u001a4\u0010\u001c\u001a\u00020\u0013*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00062\u0014\b\b\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00130\u0017H\u0086H¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Ljava/nio/ByteBuffer;", "content", "Lio/ktor/utils/io/ByteReadChannel;", "ByteReadChannel", "(Ljava/nio/ByteBuffer;)Lio/ktor/utils/io/ByteReadChannel;", "buffer", "", "readAvailable", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/bytestring/ByteString;", "ByteString", "(Ljava/nio/ByteBuffer;)Lkotlinx/io/bytestring/ByteString;", "Ljava/nio/channels/WritableByteChannel;", "channel", "", "limit", "copyTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/channels/WritableByteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delimiter", "", "skipDelimiter", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/bytestring/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFully", "Lkotlin/Function1;", "block", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/jvm/functions/Function1;)I", "min", "consumer", "read", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ByteReadChannelOperations_jvmKt {
    public static final ByteReadChannel ByteReadChannel(ByteBuffer content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Source buffer = new Buffer();
        Sink $this$ByteReadChannel_u24lambda_u240 = (Sink) buffer;
        BytePacketBuilderExtensions_jvmKt.writeFully($this$ByteReadChannel_u24lambda_u240, content);
        Source packet = buffer;
        return ByteChannelCtorKt.ByteReadChannel(packet);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readAvailable(ByteReadChannel $this$readAvailable, ByteBuffer buffer, Continuation<? super Integer> continuation) {
        ByteReadChannelOperations_jvmKt$readAvailable$1 byteReadChannelOperations_jvmKt$readAvailable$1;
        ByteReadChannel $this$readAvailable2;
        ByteBuffer buffer2;
        if (continuation instanceof ByteReadChannelOperations_jvmKt$readAvailable$1) {
            byteReadChannelOperations_jvmKt$readAvailable$1 = (ByteReadChannelOperations_jvmKt$readAvailable$1) continuation;
            if ((byteReadChannelOperations_jvmKt$readAvailable$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperations_jvmKt$readAvailable$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperations_jvmKt$readAvailable$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperations_jvmKt$readAvailable$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!$this$readAvailable.isClosedForRead()) {
                            if ($this$readAvailable.mo1388getReadBuffer().exhausted()) {
                                byteReadChannelOperations_jvmKt$readAvailable$1.L$0 = $this$readAvailable;
                                byteReadChannelOperations_jvmKt$readAvailable$1.L$1 = buffer;
                                byteReadChannelOperations_jvmKt$readAvailable$1.label = 1;
                                if (ByteReadChannel.DefaultImpls.awaitContent$default($this$readAvailable, 0, byteReadChannelOperations_jvmKt$readAvailable$1, 1, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $this$readAvailable2 = $this$readAvailable;
                                buffer2 = buffer;
                                ByteReadChannel byteReadChannel = $this$readAvailable2;
                                buffer = buffer2;
                                $this$readAvailable = byteReadChannel;
                                break;
                            }
                        } else {
                            return Boxing.boxInt(-1);
                        }
                        break;
                    case 1:
                        buffer2 = (ByteBuffer) byteReadChannelOperations_jvmKt$readAvailable$1.L$1;
                        $this$readAvailable2 = (ByteReadChannel) byteReadChannelOperations_jvmKt$readAvailable$1.L$0;
                        ResultKt.throwOnFailure($result);
                        ByteReadChannel byteReadChannel2 = $this$readAvailable2;
                        buffer = buffer2;
                        $this$readAvailable = byteReadChannel2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return !$this$readAvailable.isClosedForRead() ? Boxing.boxInt(-1) : Boxing.boxInt(SourcesJvmKt.readAtMostTo($this$readAvailable.mo1388getReadBuffer(), buffer));
            }
        }
        byteReadChannelOperations_jvmKt$readAvailable$1 = new ByteReadChannelOperations_jvmKt$readAvailable$1(continuation);
        Object $result2 = byteReadChannelOperations_jvmKt$readAvailable$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperations_jvmKt$readAvailable$1.label) {
        }
        if (!$this$readAvailable.isClosedForRead()) {
        }
    }

    public static final ByteString ByteString(ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        byte[] array = new byte[buffer.remaining()];
        buffer.mark();
        buffer.get(array);
        buffer.reset();
        return new ByteString(array, 0, 0, 6, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0107, code lost:
        if (r8.isClosedForRead() != false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fb  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00a1 -> B:54:0x0103). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00bc -> B:44:0x00bf). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyTo(ByteReadChannel $this$copyTo, final WritableByteChannel channel, final long limit, Continuation<? super Long> continuation) {
        ByteReadChannelOperations_jvmKt$copyTo$1 byteReadChannelOperations_jvmKt$copyTo$1;
        Function1 copy;
        ByteReadChannel $this$copyTo2;
        Ref.LongRef copied;
        int min$iv;
        ByteReadChannel $this$read$iv;
        int min$iv2;
        if (continuation instanceof ByteReadChannelOperations_jvmKt$copyTo$1) {
            byteReadChannelOperations_jvmKt$copyTo$1 = (ByteReadChannelOperations_jvmKt$copyTo$1) continuation;
            if ((byteReadChannelOperations_jvmKt$copyTo$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperations_jvmKt$copyTo$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperations_jvmKt$copyTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperations_jvmKt$copyTo$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!(limit >= 0)) {
                            throw new IllegalArgumentException(("Limit shouldn't be negative: " + limit).toString());
                        }
                        if ((channel instanceof SelectableChannel) && !((SelectableChannel) channel).isBlocking()) {
                            throw new IllegalArgumentException("Non-blocking channels are not supported");
                        }
                        if ($this$copyTo.isClosedForRead()) {
                            Throwable it = $this$copyTo.getClosedCause();
                            if (it != null) {
                                throw it;
                            }
                            return Boxing.boxLong(0L);
                        }
                        final Ref.LongRef copied2 = new Ref.LongRef();
                        copy = new Function1() { // from class: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                Unit copyTo$lambda$3;
                                copyTo$lambda$3 = ByteReadChannelOperations_jvmKt.copyTo$lambda$3(limit, copied2, channel, (ByteBuffer) obj);
                                return copyTo$lambda$3;
                            }
                        };
                        $this$copyTo2 = $this$copyTo;
                        copied = copied2;
                        if (copied.element < limit) {
                            min$iv = 0;
                            $this$read$iv = $this$copyTo2;
                            if (ByteReadChannelOperationsKt.getAvailableForRead($this$read$iv) > 0 && ByteReadChannelOperationsKt.getAvailableForRead($this$read$iv) >= 0) {
                                ByteReadPacketExtensions_jvmKt.read($this$read$iv.mo1388getReadBuffer(), copy);
                            } else {
                                byteReadChannelOperations_jvmKt$copyTo$1.L$0 = $this$copyTo2;
                                byteReadChannelOperations_jvmKt$copyTo$1.L$1 = copied;
                                byteReadChannelOperations_jvmKt$copyTo$1.L$2 = copy;
                                byteReadChannelOperations_jvmKt$copyTo$1.L$3 = $this$read$iv;
                                byteReadChannelOperations_jvmKt$copyTo$1.J$0 = limit;
                                byteReadChannelOperations_jvmKt$copyTo$1.I$0 = 0;
                                byteReadChannelOperations_jvmKt$copyTo$1.label = 1;
                                if (ByteReadChannel.DefaultImpls.awaitContent$default($this$read$iv, 0, byteReadChannelOperations_jvmKt$copyTo$1, 1, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                if (!$this$read$iv.isClosedForRead() && min$iv > 0) {
                                    throw new EOFException("Not enough bytes available: required " + min$iv + " but " + ByteReadChannelOperationsKt.getAvailableForRead($this$read$iv) + " available");
                                }
                                min$iv2 = ByteReadChannelOperationsKt.getAvailableForRead($this$read$iv);
                                if (min$iv2 > 0) {
                                    ByteReadPacketExtensions_jvmKt.read($this$read$iv.mo1388getReadBuffer(), copy);
                                }
                                break;
                            }
                        }
                        Throwable it2 = $this$copyTo2.getClosedCause();
                        if (it2 != null) {
                            throw it2;
                        }
                        return Boxing.boxLong(copied.element);
                    case 1:
                        min$iv = byteReadChannelOperations_jvmKt$copyTo$1.I$0;
                        limit = byteReadChannelOperations_jvmKt$copyTo$1.J$0;
                        $this$read$iv = (ByteReadChannel) byteReadChannelOperations_jvmKt$copyTo$1.L$3;
                        copy = (Function1) byteReadChannelOperations_jvmKt$copyTo$1.L$2;
                        copied = (Ref.LongRef) byteReadChannelOperations_jvmKt$copyTo$1.L$1;
                        $this$copyTo2 = (ByteReadChannel) byteReadChannelOperations_jvmKt$copyTo$1.L$0;
                        ResultKt.throwOnFailure($result);
                        if (!$this$read$iv.isClosedForRead()) {
                        }
                        min$iv2 = ByteReadChannelOperationsKt.getAvailableForRead($this$read$iv);
                        if (min$iv2 > 0) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        byteReadChannelOperations_jvmKt$copyTo$1 = new ByteReadChannelOperations_jvmKt$copyTo$1(continuation);
        Object $result2 = byteReadChannelOperations_jvmKt$copyTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperations_jvmKt$copyTo$1.label) {
        }
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, WritableByteChannel writableByteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(byteReadChannel, writableByteChannel, j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyTo$lambda$3(long $limit, Ref.LongRef $copied, WritableByteChannel $channel, ByteBuffer bb) {
        Intrinsics.checkNotNullParameter(bb, "bb");
        long rem = $limit - $copied.element;
        if (rem < bb.remaining()) {
            int l = bb.limit();
            bb.limit(bb.position() + ((int) rem));
            while (bb.hasRemaining()) {
                $channel.write(bb);
            }
            bb.limit(l);
            $copied.element += rem;
        } else {
            long written = 0;
            while (bb.hasRemaining()) {
                written += $channel.write(bb);
            }
            $copied.element += written;
        }
        return Unit.INSTANCE;
    }

    public static final Object skipDelimiter(ByteReadChannel $this$skipDelimiter, ByteBuffer delimiter, Continuation<? super Unit> continuation) {
        Object skipDelimiter = skipDelimiter($this$skipDelimiter, ByteString(delimiter), continuation);
        return skipDelimiter == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? skipDelimiter : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0062 -> B:19:0x0068). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object skipDelimiter(ByteReadChannel $this$skipDelimiter, ByteString delimiter, Continuation<? super Unit> continuation) {
        ByteReadChannelOperations_jvmKt$skipDelimiter$2 byteReadChannelOperations_jvmKt$skipDelimiter$2;
        int size;
        int i;
        Object $result;
        ByteReadChannel $this$skipDelimiter2;
        ByteString delimiter2;
        Object obj;
        if (continuation instanceof ByteReadChannelOperations_jvmKt$skipDelimiter$2) {
            byteReadChannelOperations_jvmKt$skipDelimiter$2 = (ByteReadChannelOperations_jvmKt$skipDelimiter$2) continuation;
            if ((byteReadChannelOperations_jvmKt$skipDelimiter$2.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperations_jvmKt$skipDelimiter$2.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result2 = byteReadChannelOperations_jvmKt$skipDelimiter$2.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperations_jvmKt$skipDelimiter$2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        ByteReadChannel $this$skipDelimiter3 = $this$skipDelimiter;
                        size = delimiter.getSize();
                        ByteString delimiter3 = delimiter;
                        i = 0;
                        if (i >= size) {
                            byteReadChannelOperations_jvmKt$skipDelimiter$2.L$0 = $this$skipDelimiter3;
                            byteReadChannelOperations_jvmKt$skipDelimiter$2.L$1 = delimiter3;
                            byteReadChannelOperations_jvmKt$skipDelimiter$2.I$0 = i;
                            byteReadChannelOperations_jvmKt$skipDelimiter$2.I$1 = size;
                            byteReadChannelOperations_jvmKt$skipDelimiter$2.label = 1;
                            Object readByte = ByteReadChannelOperationsKt.readByte($this$skipDelimiter3, byteReadChannelOperations_jvmKt$skipDelimiter$2);
                            if (readByte == $result3) {
                                return $result3;
                            }
                            Object obj2 = $result3;
                            $result = $result2;
                            $result2 = readByte;
                            $this$skipDelimiter2 = $this$skipDelimiter3;
                            delimiter2 = delimiter3;
                            obj = obj2;
                            if (((Number) $result2).byteValue() != delimiter2.get(i)) {
                                i++;
                                $result2 = $result;
                                $result3 = obj;
                                delimiter3 = delimiter2;
                                $this$skipDelimiter3 = $this$skipDelimiter2;
                                if (i >= size) {
                                    return Unit.INSTANCE;
                                }
                            } else {
                                throw new IllegalStateException("Delimiter is not found");
                            }
                        }
                    case 1:
                        size = byteReadChannelOperations_jvmKt$skipDelimiter$2.I$1;
                        i = byteReadChannelOperations_jvmKt$skipDelimiter$2.I$0;
                        ByteReadChannel $this$skipDelimiter4 = (ByteReadChannel) byteReadChannelOperations_jvmKt$skipDelimiter$2.L$0;
                        ResultKt.throwOnFailure($result2);
                        $this$skipDelimiter2 = $this$skipDelimiter4;
                        delimiter2 = (ByteString) byteReadChannelOperations_jvmKt$skipDelimiter$2.L$1;
                        obj = $result3;
                        $result = $result2;
                        if (((Number) $result2).byteValue() != delimiter2.get(i)) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        byteReadChannelOperations_jvmKt$skipDelimiter$2 = new ByteReadChannelOperations_jvmKt$skipDelimiter$2(continuation);
        Object $result22 = byteReadChannelOperations_jvmKt$skipDelimiter$2.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperations_jvmKt$skipDelimiter$2.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0048 -> B:22:0x005b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0057 -> B:22:0x005b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readFully(ByteReadChannel $this$readFully, ByteBuffer byteBuffer, Continuation<? super Unit> continuation) {
        ByteReadChannelOperations_jvmKt$readFully$1 byteReadChannelOperations_jvmKt$readFully$1;
        ByteReadChannel $this$readFully2;
        ByteBuffer buffer;
        if (continuation instanceof ByteReadChannelOperations_jvmKt$readFully$1) {
            byteReadChannelOperations_jvmKt$readFully$1 = (ByteReadChannelOperations_jvmKt$readFully$1) continuation;
            if ((byteReadChannelOperations_jvmKt$readFully$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperations_jvmKt$readFully$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperations_jvmKt$readFully$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperations_jvmKt$readFully$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$readFully2 = $this$readFully;
                        buffer = byteBuffer;
                        break;
                    case 1:
                        buffer = (ByteBuffer) byteReadChannelOperations_jvmKt$readFully$1.L$1;
                        $this$readFully2 = (ByteReadChannel) byteReadChannelOperations_jvmKt$readFully$1.L$0;
                        ResultKt.throwOnFailure($result);
                        SourcesJvmKt.readAtMostTo($this$readFully2.mo1388getReadBuffer(), buffer);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (buffer.hasRemaining()) {
                    if (ByteReadChannelOperationsKt.getAvailableForRead($this$readFully2) == 0) {
                        byteReadChannelOperations_jvmKt$readFully$1.L$0 = $this$readFully2;
                        byteReadChannelOperations_jvmKt$readFully$1.L$1 = buffer;
                        byteReadChannelOperations_jvmKt$readFully$1.label = 1;
                        if (ByteReadChannel.DefaultImpls.awaitContent$default($this$readFully2, 0, byteReadChannelOperations_jvmKt$readFully$1, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    SourcesJvmKt.readAtMostTo($this$readFully2.mo1388getReadBuffer(), buffer);
                    if (buffer.hasRemaining()) {
                    }
                } else {
                    return Unit.INSTANCE;
                }
            }
        }
        byteReadChannelOperations_jvmKt$readFully$1 = new ByteReadChannelOperations_jvmKt$readFully$1(continuation);
        Object $result2 = byteReadChannelOperations_jvmKt$readFully$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperations_jvmKt$readFully$1.label) {
        }
        if (buffer.hasRemaining()) {
        }
    }

    public static final int readAvailable(ByteReadChannel $this$readAvailable, Function1<? super ByteBuffer, Integer> function1) {
        Intrinsics.checkNotNullParameter($this$readAvailable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if ($this$readAvailable.isClosedForRead() || $this$readAvailable.mo1388getReadBuffer().exhausted()) {
            return -1;
        }
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        Buffer buffer$iv = $this$readAvailable.mo1388getReadBuffer().getBuffer();
        if (buffer$iv.exhausted()) {
            throw new IllegalArgumentException("Buffer is empty".toString());
        }
        Segment head$iv = buffer$iv.getHead();
        Intrinsics.checkNotNull(head$iv);
        byte[] array = head$iv.dataAsByteArray(true);
        int start = head$iv.getPos();
        int endExclusive = head$iv.getLimit();
        ByteBuffer buffer = ByteBuffer.wrap(array, start, endExclusive - start);
        Intrinsics.checkNotNull(buffer);
        int result = ((Number) function1.invoke(buffer)).intValue();
        if (result != 0) {
            if (result >= 0) {
                if (result > head$iv.getSize()) {
                    throw new IllegalStateException("Returned too many bytes");
                }
                buffer$iv.skip(result);
            } else {
                throw new IllegalStateException("Returned negative read bytes count");
            }
        }
        return result;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object read(ByteReadChannel $this$read, int min, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        ByteReadChannelOperations_jvmKt$read$1 byteReadChannelOperations_jvmKt$read$1;
        ByteReadChannel $this$read2;
        if (continuation instanceof ByteReadChannelOperations_jvmKt$read$1) {
            byteReadChannelOperations_jvmKt$read$1 = (ByteReadChannelOperations_jvmKt$read$1) continuation;
            if ((byteReadChannelOperations_jvmKt$read$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperations_jvmKt$read$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperations_jvmKt$read$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperations_jvmKt$read$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (min >= 0) {
                            if (ByteReadChannelOperationsKt.getAvailableForRead($this$read) > 0 && ByteReadChannelOperationsKt.getAvailableForRead($this$read) >= min) {
                                ByteReadPacketExtensions_jvmKt.read($this$read.mo1388getReadBuffer(), function1);
                                return Unit.INSTANCE;
                            }
                            byteReadChannelOperations_jvmKt$read$1.L$0 = $this$read;
                            byteReadChannelOperations_jvmKt$read$1.L$1 = function1;
                            byteReadChannelOperations_jvmKt$read$1.I$0 = min;
                            byteReadChannelOperations_jvmKt$read$1.label = 1;
                            if (ByteReadChannel.DefaultImpls.awaitContent$default($this$read, 0, byteReadChannelOperations_jvmKt$read$1, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$read2 = $this$read;
                            break;
                        } else {
                            throw new IllegalArgumentException("min should be positive or zero".toString());
                        }
                        break;
                    case 1:
                        min = byteReadChannelOperations_jvmKt$read$1.I$0;
                        function1 = (Function1) byteReadChannelOperations_jvmKt$read$1.L$1;
                        $this$read2 = (ByteReadChannel) byteReadChannelOperations_jvmKt$read$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!$this$read2.isClosedForRead() && min > 0) {
                    throw new EOFException("Not enough bytes available: required " + min + " but " + ByteReadChannelOperationsKt.getAvailableForRead($this$read2) + " available");
                }
                if (ByteReadChannelOperationsKt.getAvailableForRead($this$read2) > 0) {
                    ByteReadPacketExtensions_jvmKt.read($this$read2.mo1388getReadBuffer(), function1);
                }
                return Unit.INSTANCE;
            }
        }
        byteReadChannelOperations_jvmKt$read$1 = new ByteReadChannelOperations_jvmKt$read$1(continuation);
        Object $result2 = byteReadChannelOperations_jvmKt$read$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperations_jvmKt$read$1.label) {
        }
        if (!$this$read2.isClosedForRead()) {
        }
        if (ByteReadChannelOperationsKt.getAvailableForRead($this$read2) > 0) {
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object read$default(ByteReadChannel $this$read_u24default, int min, Function1 consumer, Continuation $completion, int i, Object obj) {
        boolean z;
        if ((i & 1) != 0) {
            min = 1;
        }
        if (min >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (ByteReadChannelOperationsKt.getAvailableForRead($this$read_u24default) > 0 && ByteReadChannelOperationsKt.getAvailableForRead($this$read_u24default) >= min) {
                ByteReadPacketExtensions_jvmKt.read($this$read_u24default.mo1388getReadBuffer(), consumer);
                return Unit.INSTANCE;
            }
            InlineMarker.mark(0);
            ByteReadChannel.DefaultImpls.awaitContent$default($this$read_u24default, 0, $completion, 1, null);
            InlineMarker.mark(1);
            if ($this$read_u24default.isClosedForRead() && min > 0) {
                throw new EOFException("Not enough bytes available: required " + min + " but " + ByteReadChannelOperationsKt.getAvailableForRead($this$read_u24default) + " available");
            }
            if (ByteReadChannelOperationsKt.getAvailableForRead($this$read_u24default) > 0) {
                ByteReadPacketExtensions_jvmKt.read($this$read_u24default.mo1388getReadBuffer(), consumer);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalArgumentException("min should be positive or zero".toString());
    }

    private static final Object read$$forInline(ByteReadChannel $this$read, int min, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        if (min >= 0) {
            if (ByteReadChannelOperationsKt.getAvailableForRead($this$read) > 0 && ByteReadChannelOperationsKt.getAvailableForRead($this$read) >= min) {
                ByteReadPacketExtensions_jvmKt.read($this$read.mo1388getReadBuffer(), function1);
                return Unit.INSTANCE;
            }
            InlineMarker.mark(0);
            ByteReadChannel.DefaultImpls.awaitContent$default($this$read, 0, continuation, 1, null);
            InlineMarker.mark(1);
            if ($this$read.isClosedForRead() && min > 0) {
                throw new EOFException("Not enough bytes available: required " + min + " but " + ByteReadChannelOperationsKt.getAvailableForRead($this$read) + " available");
            }
            if (ByteReadChannelOperationsKt.getAvailableForRead($this$read) > 0) {
                ByteReadPacketExtensions_jvmKt.read($this$read.mo1388getReadBuffer(), function1);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalArgumentException("min should be positive or zero".toString());
    }
}