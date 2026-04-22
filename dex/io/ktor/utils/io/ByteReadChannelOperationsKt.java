package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.charsets.TooLongLineException;
import io.ktor.utils.io.core.BuffersKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.InputKt;
import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.YieldKt;
import kotlinx.io.Buffer;
import kotlinx.io.ByteStringsKt;
import kotlinx.io.RawSink;
import kotlinx.io.Segment;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;
import kotlinx.io.Utf8Kt;
import kotlinx.io.bytestring.ByteString;
import kotlinx.io.bytestring.ByteStringKt;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* compiled from: ByteReadChannelOperations.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0010\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u0000H\u0086@¢\u0006\u0004\b\t\u0010\u0003\u001a\u0014\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u0014\u0010\r\u001a\u00020\f*\u00020\u0000H\u0086@¢\u0006\u0004\b\r\u0010\u0003\u001a\u001c\u0010\u0010\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0014\u0010\u0013\u001a\u00020\u0012*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0013\u0010\u0003\u001a\u001c\u0010\u0013\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0013\u0010\u0011\u001a\u001c\u0010\u0017\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018\u001a \u0010\u001a\u001a\u0004\u0018\u00010\u0019*\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u001a\u0010\u0011\u001a\u001c\u0010\u001b\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0086@¢\u0006\u0004\b\u001b\u0010\u0018\u001a$\u0010\u001b\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\fH\u0086@¢\u0006\u0004\b\u001b\u0010\u001d\u001a\u001c\u0010\u001f\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u001f\u0010\u0011\u001a\u0014\u0010!\u001a\u00020 *\u00020\u0000H\u0086@¢\u0006\u0004\b!\u0010\u0003\u001a\u001c\u0010!\u001a\u00020 *\u00020\u00002\u0006\u0010\u0014\u001a\u00020\fH\u0086@¢\u0006\u0004\b!\u0010\"\u001a0\u0010&\u001a\u00020\n*\u00020\u00002\u0006\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\n2\b\b\u0002\u0010%\u001a\u00020\nH\u0086@¢\u0006\u0004\b&\u0010'\u001a-\u0010&\u001a\u00020\n*\u00020\u00002\u0006\u0010(\u001a\u00020\n2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0)¢\u0006\u0004\b&\u0010+\u001aN\u00106\u001a\u000205*\u00020,2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020\u00012'\u0010*\u001a#\b\u0001\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02\u0012\u0006\u0012\u0004\u0018\u00010300¢\u0006\u0002\b4¢\u0006\u0004\b6\u00107\u001aJ\u00106\u001a\u000205*\u00020,2\u0006\u0010.\u001a\u00020-2\u0006\u0010\u0016\u001a\u0002082'\u0010*\u001a#\b\u0001\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f02\u0012\u0006\u0012\u0004\u0018\u00010300¢\u0006\u0002\b4¢\u0006\u0004\b6\u00109\u001a\u001c\u0010;\u001a\u00020 *\u00020\u00002\u0006\u0010:\u001a\u00020\nH\u0086@¢\u0006\u0004\b;\u0010\u0011\u001a\u001c\u0010=\u001a\u00020\u000f*\u00020\u00002\u0006\u0010<\u001a\u00020\fH\u0086@¢\u0006\u0004\b=\u0010\"\u001a\u001e\u0010>\u001a\u00020\f*\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\fH\u0086@¢\u0006\u0004\b>\u0010\"\u001a*\u0010B\u001a\u00020\u0001*\u00020\u00002\n\u0010A\u001a\u00060?j\u0002`@2\b\b\u0002\u0010\u0014\u001a\u00020\nH\u0086@¢\u0006\u0004\bB\u0010C\u001aF\u0010E\u001a\u00020\n*\u00020\u000020\b\u0004\u0010*\u001a*\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n02\u0012\u0006\u0012\u0004\u0018\u0001030DH\u0086H¢\u0006\u0004\bE\u0010F\u001a0\u0010I\u001a\u00020\u000f*\u00020\u00002\u0006\u0010A\u001a\u00020\u00042\b\b\u0002\u0010G\u001a\u00020\n2\b\b\u0002\u0010H\u001a\u00020\nH\u0086@¢\u0006\u0004\bI\u0010'\u001a\u0013\u0010J\u001a\u00020\u000f*\u00020\u0000H\u0007¢\u0006\u0004\bJ\u0010K\u001a\u0013\u0010J\u001a\u00020\u000f*\u00020\u0015H\u0007¢\u0006\u0004\bJ\u0010L\u001a\u0013\u0010J\u001a\u00020\u000f*\u000208H\u0007¢\u0006\u0004\bJ\u0010M\u001a8\u0010R\u001a\u00020\f*\u00020\u00002\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020\u00152\b\b\u0002\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010Q\u001a\u00020\u0001H\u0086@¢\u0006\u0004\bR\u0010S\u001a\u0017\u0010V\u001a\u00020U2\u0006\u0010T\u001a\u00020NH\u0002¢\u0006\u0004\bV\u0010W\u001a\u0013\u0010X\u001a\u00020\u0019*\u00020NH\u0002¢\u0006\u0004\bX\u0010Y\u001a\u001c\u0010Z\u001a\u00020\u0001*\u00020\u00002\u0006\u0010T\u001a\u00020NH\u0086@¢\u0006\u0004\bZ\u0010[\u001a\u001e\u0010\\\u001a\u0004\u0018\u00010N*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\nH\u0086@¢\u0006\u0004\b\\\u0010\u0011\"\u001b\u0010`\u001a\u00020\n*\u00020\u00158F¢\u0006\f\u0012\u0004\b_\u0010L\u001a\u0004\b]\u0010^\"\u001b\u0010d\u001a\u00020\n*\u00020\u00008F¢\u0006\f\u0012\u0004\bc\u0010K\u001a\u0004\ba\u0010b¨\u0006e"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "", "exhausted", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "toByteArray", "", "readByte", "", "readShort", "", "readInt", "", "readLong", "numberOfBytes", "", "awaitUntilReadable", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/Buffer;", "readBuffer", "max", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "copyAndClose", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "readUTF8Line", "copyTo", "limit", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "count", "readByteArray", "Lkotlinx/io/Source;", "readRemaining", "(Lio/ktor/utils/io/ByteReadChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buffer", "offset", "length", "readAvailable", "(Lio/ktor/utils/io/ByteReadChannel;[BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "min", "Lkotlin/Function1;", "block", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/jvm/functions/Function1;)I", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "autoFlush", "Lkotlin/Function2;", "Lio/ktor/utils/io/ReaderScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "Lio/ktor/utils/io/ReaderJob;", "reader", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ZLkotlin/jvm/functions/Function2;)Lio/ktor/utils/io/ReaderJob;", "Lio/ktor/utils/io/ByteChannel;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lio/ktor/utils/io/ByteChannel;Lkotlin/jvm/functions/Function2;)Lio/ktor/utils/io/ReaderJob;", "packet", "readPacket", "value", "discardExact", "discard", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "readUTF8LineTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function4;", "read", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "end", "readFully", "rethrowCloseCauseIfNeeded", "(Lio/ktor/utils/io/ByteReadChannel;)V", "(Lio/ktor/utils/io/ByteWriteChannel;)V", "(Lio/ktor/utils/io/ByteChannel;)V", "Lkotlinx/io/bytestring/ByteString;", "matchString", "writeChannel", "ignoreMissing", "readUntil", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/bytestring/ByteString;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "byteString", "", "buildPartialMatchTable", "(Lkotlinx/io/bytestring/ByteString;)[I", "toSingleLineString", "(Lkotlinx/io/bytestring/ByteString;)Ljava/lang/String;", "skipIfFound", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/bytestring/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peek", "getAvailableForWrite", "(Lio/ktor/utils/io/ByteWriteChannel;)I", "getAvailableForWrite$annotations", "availableForWrite", "getAvailableForRead", "(Lio/ktor/utils/io/ByteReadChannel;)I", "getAvailableForRead$annotations", "availableForRead", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ByteReadChannelOperationsKt {
    public static /* synthetic */ void getAvailableForRead$annotations(ByteReadChannel byteReadChannel) {
    }

    public static /* synthetic */ void getAvailableForWrite$annotations(ByteWriteChannel byteWriteChannel) {
    }

    public static final int getAvailableForWrite(ByteWriteChannel $this$availableForWrite) {
        Intrinsics.checkNotNullParameter($this$availableForWrite, "<this>");
        return ByteChannelKt.CHANNEL_MAX_SIZE - BytePacketBuilderKt.getSize($this$availableForWrite.getWriteBuffer());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object exhausted(ByteReadChannel $this$exhausted, Continuation<? super Boolean> continuation) {
        ByteReadChannelOperationsKt$exhausted$1 byteReadChannelOperationsKt$exhausted$1;
        if (continuation instanceof ByteReadChannelOperationsKt$exhausted$1) {
            byteReadChannelOperationsKt$exhausted$1 = (ByteReadChannelOperationsKt$exhausted$1) continuation;
            if ((byteReadChannelOperationsKt$exhausted$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$exhausted$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$exhausted$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$exhausted$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if ($this$exhausted.mo1388getReadBuffer().exhausted()) {
                            byteReadChannelOperationsKt$exhausted$1.L$0 = $this$exhausted;
                            byteReadChannelOperationsKt$exhausted$1.label = 1;
                            if (ByteReadChannel.DefaultImpls.awaitContent$default($this$exhausted, 0, byteReadChannelOperationsKt$exhausted$1, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        break;
                    case 1:
                        $this$exhausted = (ByteReadChannel) byteReadChannelOperationsKt$exhausted$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxBoolean($this$exhausted.mo1388getReadBuffer().exhausted());
            }
        }
        byteReadChannelOperationsKt$exhausted$1 = new ByteReadChannelOperationsKt$exhausted$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$exhausted$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$exhausted$1.label) {
        }
        return Boxing.boxBoolean($this$exhausted.mo1388getReadBuffer().exhausted());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object toByteArray(ByteReadChannel $this$toByteArray, Continuation<? super byte[]> continuation) {
        ByteReadChannelOperationsKt$toByteArray$1 byteReadChannelOperationsKt$toByteArray$1;
        Object readBuffer;
        if (continuation instanceof ByteReadChannelOperationsKt$toByteArray$1) {
            byteReadChannelOperationsKt$toByteArray$1 = (ByteReadChannelOperationsKt$toByteArray$1) continuation;
            if ((byteReadChannelOperationsKt$toByteArray$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$toByteArray$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$toByteArray$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$toByteArray$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        byteReadChannelOperationsKt$toByteArray$1.label = 1;
                        readBuffer = readBuffer($this$toByteArray, byteReadChannelOperationsKt$toByteArray$1);
                        if (readBuffer == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        readBuffer = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return BuffersKt.readBytes$default((Buffer) readBuffer, 0, 1, null);
            }
        }
        byteReadChannelOperationsKt$toByteArray$1 = new ByteReadChannelOperationsKt$toByteArray$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$toByteArray$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$toByteArray$1.label) {
        }
        return BuffersKt.readBytes$default((Buffer) readBuffer, 0, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readByte(ByteReadChannel $this$readByte, Continuation<? super Byte> continuation) {
        ByteReadChannelOperationsKt$readByte$1 byteReadChannelOperationsKt$readByte$1;
        if (continuation instanceof ByteReadChannelOperationsKt$readByte$1) {
            byteReadChannelOperationsKt$readByte$1 = (ByteReadChannelOperationsKt$readByte$1) continuation;
            if ((byteReadChannelOperationsKt$readByte$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$readByte$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$readByte$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$readByte$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if ($this$readByte.mo1388getReadBuffer().exhausted()) {
                            byteReadChannelOperationsKt$readByte$1.L$0 = $this$readByte;
                            byteReadChannelOperationsKt$readByte$1.label = 1;
                            if (ByteReadChannel.DefaultImpls.awaitContent$default($this$readByte, 0, byteReadChannelOperationsKt$readByte$1, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        break;
                    case 1:
                        $this$readByte = (ByteReadChannel) byteReadChannelOperationsKt$readByte$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!$this$readByte.mo1388getReadBuffer().exhausted()) {
                    throw new EOFException("Not enough data available");
                }
                return Boxing.boxByte($this$readByte.mo1388getReadBuffer().readByte());
            }
        }
        byteReadChannelOperationsKt$readByte$1 = new ByteReadChannelOperationsKt$readByte$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$readByte$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$readByte$1.label) {
        }
        if (!$this$readByte.mo1388getReadBuffer().exhausted()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readShort(ByteReadChannel $this$readShort, Continuation<? super Short> continuation) {
        ByteReadChannelOperationsKt$readShort$1 byteReadChannelOperationsKt$readShort$1;
        if (continuation instanceof ByteReadChannelOperationsKt$readShort$1) {
            byteReadChannelOperationsKt$readShort$1 = (ByteReadChannelOperationsKt$readShort$1) continuation;
            if ((byteReadChannelOperationsKt$readShort$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$readShort$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$readShort$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$readShort$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        byteReadChannelOperationsKt$readShort$1.L$0 = $this$readShort;
                        byteReadChannelOperationsKt$readShort$1.label = 1;
                        if (awaitUntilReadable($this$readShort, 2, byteReadChannelOperationsKt$readShort$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        $this$readShort = (ByteReadChannel) byteReadChannelOperationsKt$readShort$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxShort($this$readShort.mo1388getReadBuffer().readShort());
            }
        }
        byteReadChannelOperationsKt$readShort$1 = new ByteReadChannelOperationsKt$readShort$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$readShort$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$readShort$1.label) {
        }
        return Boxing.boxShort($this$readShort.mo1388getReadBuffer().readShort());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readInt(ByteReadChannel $this$readInt, Continuation<? super Integer> continuation) {
        ByteReadChannelOperationsKt$readInt$1 byteReadChannelOperationsKt$readInt$1;
        if (continuation instanceof ByteReadChannelOperationsKt$readInt$1) {
            byteReadChannelOperationsKt$readInt$1 = (ByteReadChannelOperationsKt$readInt$1) continuation;
            if ((byteReadChannelOperationsKt$readInt$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$readInt$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$readInt$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$readInt$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        byteReadChannelOperationsKt$readInt$1.L$0 = $this$readInt;
                        byteReadChannelOperationsKt$readInt$1.label = 1;
                        if (awaitUntilReadable($this$readInt, 4, byteReadChannelOperationsKt$readInt$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        $this$readInt = (ByteReadChannel) byteReadChannelOperationsKt$readInt$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxInt($this$readInt.mo1388getReadBuffer().readInt());
            }
        }
        byteReadChannelOperationsKt$readInt$1 = new ByteReadChannelOperationsKt$readInt$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$readInt$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$readInt$1.label) {
        }
        return Boxing.boxInt($this$readInt.mo1388getReadBuffer().readInt());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readLong(ByteReadChannel $this$readLong, Continuation<? super Long> continuation) {
        ByteReadChannelOperationsKt$readLong$1 byteReadChannelOperationsKt$readLong$1;
        if (continuation instanceof ByteReadChannelOperationsKt$readLong$1) {
            byteReadChannelOperationsKt$readLong$1 = (ByteReadChannelOperationsKt$readLong$1) continuation;
            if ((byteReadChannelOperationsKt$readLong$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$readLong$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$readLong$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$readLong$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        byteReadChannelOperationsKt$readLong$1.L$0 = $this$readLong;
                        byteReadChannelOperationsKt$readLong$1.label = 1;
                        if (awaitUntilReadable($this$readLong, 8, byteReadChannelOperationsKt$readLong$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        $this$readLong = (ByteReadChannel) byteReadChannelOperationsKt$readLong$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxLong($this$readLong.mo1388getReadBuffer().readLong());
            }
        }
        byteReadChannelOperationsKt$readLong$1 = new ByteReadChannelOperationsKt$readLong$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$readLong$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$readLong$1.label) {
        }
        return Boxing.boxLong($this$readLong.mo1388getReadBuffer().readLong());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0079 -> B:15:0x0048). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitUntilReadable(ByteReadChannel $this$awaitUntilReadable, int numberOfBytes, Continuation<? super Unit> continuation) {
        ByteReadChannelOperationsKt$awaitUntilReadable$1 byteReadChannelOperationsKt$awaitUntilReadable$1;
        int numberOfBytes2;
        ByteReadChannel $this$awaitUntilReadable2;
        Object obj;
        Object $result;
        if (continuation instanceof ByteReadChannelOperationsKt$awaitUntilReadable$1) {
            byteReadChannelOperationsKt$awaitUntilReadable$1 = (ByteReadChannelOperationsKt$awaitUntilReadable$1) continuation;
            if ((byteReadChannelOperationsKt$awaitUntilReadable$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$awaitUntilReadable$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result2 = byteReadChannelOperationsKt$awaitUntilReadable$1.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$awaitUntilReadable$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        if (getAvailableForRead($this$awaitUntilReadable) < numberOfBytes) {
                            byteReadChannelOperationsKt$awaitUntilReadable$1.L$0 = $this$awaitUntilReadable;
                            byteReadChannelOperationsKt$awaitUntilReadable$1.I$0 = numberOfBytes;
                            byteReadChannelOperationsKt$awaitUntilReadable$1.label = 1;
                            Object awaitContent = $this$awaitUntilReadable.awaitContent(numberOfBytes, byteReadChannelOperationsKt$awaitUntilReadable$1);
                            if (awaitContent == $result3) {
                                return $result3;
                            }
                            int i = numberOfBytes;
                            $this$awaitUntilReadable2 = $this$awaitUntilReadable;
                            numberOfBytes2 = i;
                            Object obj2 = $result3;
                            $result = $result2;
                            $result2 = awaitContent;
                            obj = obj2;
                            if (((Boolean) $result2).booleanValue()) {
                                ByteReadChannel byteReadChannel = $this$awaitUntilReadable2;
                                numberOfBytes = numberOfBytes2;
                                $this$awaitUntilReadable = byteReadChannel;
                            } else {
                                byteReadChannelOperationsKt$awaitUntilReadable$1.L$0 = $this$awaitUntilReadable2;
                                byteReadChannelOperationsKt$awaitUntilReadable$1.I$0 = numberOfBytes2;
                                byteReadChannelOperationsKt$awaitUntilReadable$1.label = 2;
                                if (YieldKt.yield(byteReadChannelOperationsKt$awaitUntilReadable$1) == obj) {
                                    return obj;
                                }
                                $result2 = $result;
                                $result3 = obj;
                                ByteReadChannel byteReadChannel2 = $this$awaitUntilReadable2;
                                numberOfBytes = numberOfBytes2;
                                $this$awaitUntilReadable = byteReadChannel2;
                                if (getAvailableForRead($this$awaitUntilReadable) < numberOfBytes) {
                                }
                            }
                        }
                        if (getAvailableForRead($this$awaitUntilReadable) >= numberOfBytes) {
                            throw new EOFException("Not enough data available");
                        }
                        return Unit.INSTANCE;
                    case 1:
                        numberOfBytes2 = byteReadChannelOperationsKt$awaitUntilReadable$1.I$0;
                        $this$awaitUntilReadable2 = (ByteReadChannel) byteReadChannelOperationsKt$awaitUntilReadable$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        obj = $result3;
                        $result = $result2;
                        if (((Boolean) $result2).booleanValue()) {
                        }
                        break;
                    case 2:
                        int numberOfBytes3 = byteReadChannelOperationsKt$awaitUntilReadable$1.I$0;
                        ByteReadChannel $this$awaitUntilReadable3 = (ByteReadChannel) byteReadChannelOperationsKt$awaitUntilReadable$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        numberOfBytes = numberOfBytes3;
                        $this$awaitUntilReadable = $this$awaitUntilReadable3;
                        if (getAvailableForRead($this$awaitUntilReadable) < numberOfBytes) {
                        }
                        if (getAvailableForRead($this$awaitUntilReadable) >= numberOfBytes) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        byteReadChannelOperationsKt$awaitUntilReadable$1 = new ByteReadChannelOperationsKt$awaitUntilReadable$1(continuation);
        Object $result22 = byteReadChannelOperationsKt$awaitUntilReadable$1.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$awaitUntilReadable$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readBuffer(ByteReadChannel $this$readBuffer, Continuation<? super Buffer> continuation) {
        ByteReadChannelOperationsKt$readBuffer$1 byteReadChannelOperationsKt$readBuffer$1;
        ByteReadChannel $this$readBuffer2;
        Buffer result;
        Throwable it;
        if (continuation instanceof ByteReadChannelOperationsKt$readBuffer$1) {
            byteReadChannelOperationsKt$readBuffer$1 = (ByteReadChannelOperationsKt$readBuffer$1) continuation;
            if ((byteReadChannelOperationsKt$readBuffer$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$readBuffer$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$readBuffer$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$readBuffer$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$readBuffer2 = $this$readBuffer;
                        result = new Buffer();
                        break;
                    case 1:
                        result = (Buffer) byteReadChannelOperationsKt$readBuffer$1.L$1;
                        $this$readBuffer2 = (ByteReadChannel) byteReadChannelOperationsKt$readBuffer$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (!$this$readBuffer2.isClosedForRead()) {
                    result.transferFrom($this$readBuffer2.mo1388getReadBuffer());
                    byteReadChannelOperationsKt$readBuffer$1.L$0 = $this$readBuffer2;
                    byteReadChannelOperationsKt$readBuffer$1.L$1 = result;
                    byteReadChannelOperationsKt$readBuffer$1.label = 1;
                    if (ByteReadChannel.DefaultImpls.awaitContent$default($this$readBuffer2, 0, byteReadChannelOperationsKt$readBuffer$1, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                it = $this$readBuffer2.getClosedCause();
                if (it == null) {
                    throw it;
                }
                return result;
            }
        }
        byteReadChannelOperationsKt$readBuffer$1 = new ByteReadChannelOperationsKt$readBuffer$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$readBuffer$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$readBuffer$1.label) {
        }
        while (!$this$readBuffer2.isClosedForRead()) {
        }
        it = $this$readBuffer2.getClosedCause();
        if (it == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0056 -> B:23:0x006b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0067 -> B:23:0x006b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readBuffer(ByteReadChannel $this$readBuffer, int max, Continuation<? super Buffer> continuation) {
        ByteReadChannelOperationsKt$readBuffer$3 byteReadChannelOperationsKt$readBuffer$3;
        RawSink result;
        ByteReadChannel $this$readBuffer2;
        int remaining;
        if (continuation instanceof ByteReadChannelOperationsKt$readBuffer$3) {
            byteReadChannelOperationsKt$readBuffer$3 = (ByteReadChannelOperationsKt$readBuffer$3) continuation;
            if ((byteReadChannelOperationsKt$readBuffer$3.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$readBuffer$3.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$readBuffer$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$readBuffer$3.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        result = new Buffer();
                        $this$readBuffer2 = $this$readBuffer;
                        remaining = max;
                        break;
                    case 1:
                        remaining = byteReadChannelOperationsKt$readBuffer$3.I$0;
                        result = (Buffer) byteReadChannelOperationsKt$readBuffer$3.L$1;
                        $this$readBuffer2 = (ByteReadChannel) byteReadChannelOperationsKt$readBuffer$3.L$0;
                        ResultKt.throwOnFailure($result);
                        long size = Math.min(remaining, ByteReadPacketKt.getRemaining($this$readBuffer2.mo1388getReadBuffer()));
                        $this$readBuffer2.mo1388getReadBuffer().readTo(result, size);
                        remaining -= (int) size;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (remaining <= 0 && !$this$readBuffer2.isClosedForRead()) {
                    if ($this$readBuffer2.mo1388getReadBuffer().exhausted()) {
                        byteReadChannelOperationsKt$readBuffer$3.L$0 = $this$readBuffer2;
                        byteReadChannelOperationsKt$readBuffer$3.L$1 = result;
                        byteReadChannelOperationsKt$readBuffer$3.I$0 = remaining;
                        byteReadChannelOperationsKt$readBuffer$3.label = 1;
                        if (ByteReadChannel.DefaultImpls.awaitContent$default($this$readBuffer2, 0, byteReadChannelOperationsKt$readBuffer$3, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    long size2 = Math.min(remaining, ByteReadPacketKt.getRemaining($this$readBuffer2.mo1388getReadBuffer()));
                    $this$readBuffer2.mo1388getReadBuffer().readTo(result, size2);
                    remaining -= (int) size2;
                    if (remaining <= 0) {
                    }
                    return result;
                }
                return result;
            }
        }
        byteReadChannelOperationsKt$readBuffer$3 = new ByteReadChannelOperationsKt$readBuffer$3(continuation);
        Object $result2 = byteReadChannelOperationsKt$readBuffer$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$readBuffer$3.label) {
        }
        if (remaining <= 0) {
        }
        return result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b A[Catch: all -> 0x005a, TryCatch #1 {all -> 0x005a, blocks: (B:15:0x0048, B:23:0x0065, B:25:0x006b, B:28:0x0089, B:32:0x009b, B:40:0x00ba, B:18:0x0056), top: B:50:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009b A[Catch: all -> 0x005a, TRY_LEAVE, TryCatch #1 {all -> 0x005a, blocks: (B:15:0x0048, B:23:0x0065, B:25:0x006b, B:28:0x0089, B:32:0x009b, B:40:0x00ba, B:18:0x0056), top: B:50:0x0023 }] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0097 -> B:31:0x009a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyAndClose(ByteReadChannel $this$copyAndClose, ByteWriteChannel channel, Continuation<? super Long> continuation) {
        ByteReadChannelOperationsKt$copyAndClose$1 byteReadChannelOperationsKt$copyAndClose$1;
        Object coroutine_suspended;
        ByteWriteChannel channel2;
        ByteReadChannel $this$copyAndClose2;
        long result;
        ByteWriteChannel channel3;
        ByteWriteChannel channel4;
        try {
            if (continuation instanceof ByteReadChannelOperationsKt$copyAndClose$1) {
                byteReadChannelOperationsKt$copyAndClose$1 = (ByteReadChannelOperationsKt$copyAndClose$1) continuation;
                if ((byteReadChannelOperationsKt$copyAndClose$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                    byteReadChannelOperationsKt$copyAndClose$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                    Object $result = byteReadChannelOperationsKt$copyAndClose$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    channel2 = byteReadChannelOperationsKt$copyAndClose$1.label;
                    switch (channel2) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            channel2 = channel;
                            $this$copyAndClose2 = $this$copyAndClose;
                            result = 0;
                            if ($this$copyAndClose2.isClosedForRead()) {
                                result += $this$copyAndClose2.mo1388getReadBuffer().transferTo(channel2.getWriteBuffer());
                                byteReadChannelOperationsKt$copyAndClose$1.L$0 = $this$copyAndClose2;
                                byteReadChannelOperationsKt$copyAndClose$1.L$1 = channel2;
                                byteReadChannelOperationsKt$copyAndClose$1.J$0 = result;
                                byteReadChannelOperationsKt$copyAndClose$1.label = 1;
                                Object flush = channel2.flush(byteReadChannelOperationsKt$copyAndClose$1);
                                channel3 = channel2;
                                if (flush == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                byteReadChannelOperationsKt$copyAndClose$1.L$0 = $this$copyAndClose2;
                                byteReadChannelOperationsKt$copyAndClose$1.L$1 = channel3;
                                byteReadChannelOperationsKt$copyAndClose$1.J$0 = result;
                                byteReadChannelOperationsKt$copyAndClose$1.label = 2;
                                channel4 = channel3;
                                if (ByteReadChannel.DefaultImpls.awaitContent$default($this$copyAndClose2, 0, byteReadChannelOperationsKt$copyAndClose$1, 1, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                channel2 = channel4;
                                if ($this$copyAndClose2.isClosedForRead()) {
                                    Throwable it = $this$copyAndClose2.getClosedCause();
                                    if (it != null) {
                                        throw it;
                                    }
                                    byteReadChannelOperationsKt$copyAndClose$1.L$0 = null;
                                    byteReadChannelOperationsKt$copyAndClose$1.L$1 = null;
                                    byteReadChannelOperationsKt$copyAndClose$1.J$0 = result;
                                    byteReadChannelOperationsKt$copyAndClose$1.label = 3;
                                    if (channel2.flushAndClose(byteReadChannelOperationsKt$copyAndClose$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Boxing.boxLong(result);
                                }
                            }
                        case 1:
                            result = byteReadChannelOperationsKt$copyAndClose$1.J$0;
                            ByteWriteChannel byteWriteChannel = (ByteWriteChannel) byteReadChannelOperationsKt$copyAndClose$1.L$1;
                            $this$copyAndClose2 = (ByteReadChannel) byteReadChannelOperationsKt$copyAndClose$1.L$0;
                            ResultKt.throwOnFailure($result);
                            channel3 = byteWriteChannel;
                            byteReadChannelOperationsKt$copyAndClose$1.L$0 = $this$copyAndClose2;
                            byteReadChannelOperationsKt$copyAndClose$1.L$1 = channel3;
                            byteReadChannelOperationsKt$copyAndClose$1.J$0 = result;
                            byteReadChannelOperationsKt$copyAndClose$1.label = 2;
                            channel4 = channel3;
                            if (ByteReadChannel.DefaultImpls.awaitContent$default($this$copyAndClose2, 0, byteReadChannelOperationsKt$copyAndClose$1, 1, null) == coroutine_suspended) {
                            }
                            channel2 = channel4;
                            if ($this$copyAndClose2.isClosedForRead()) {
                            }
                            break;
                        case 2:
                            result = byteReadChannelOperationsKt$copyAndClose$1.J$0;
                            ByteWriteChannel byteWriteChannel2 = (ByteWriteChannel) byteReadChannelOperationsKt$copyAndClose$1.L$1;
                            $this$copyAndClose2 = (ByteReadChannel) byteReadChannelOperationsKt$copyAndClose$1.L$0;
                            ResultKt.throwOnFailure($result);
                            channel4 = byteWriteChannel2;
                            channel2 = channel4;
                            if ($this$copyAndClose2.isClosedForRead()) {
                            }
                            break;
                        case 3:
                            result = byteReadChannelOperationsKt$copyAndClose$1.J$0;
                            ResultKt.throwOnFailure($result);
                            return Boxing.boxLong(result);
                        case 4:
                            Throwable th = (Throwable) byteReadChannelOperationsKt$copyAndClose$1.L$0;
                            ResultKt.throwOnFailure($result);
                            throw th;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (channel2) {
            }
        } catch (Throwable cause) {
            try {
                $this$copyAndClose2.cancel(cause);
                ByteWriteChannelOperationsKt.close(channel2, cause);
                throw cause;
            } catch (Throwable cause2) {
                byteReadChannelOperationsKt$copyAndClose$1.L$0 = cause2;
                byteReadChannelOperationsKt$copyAndClose$1.L$1 = null;
                byteReadChannelOperationsKt$copyAndClose$1.label = 4;
                if (channel2.flushAndClose(byteReadChannelOperationsKt$copyAndClose$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                throw cause2;
            }
        }
        byteReadChannelOperationsKt$copyAndClose$1 = new ByteReadChannelOperationsKt$copyAndClose$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$copyAndClose$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        channel2 = byteReadChannelOperationsKt$copyAndClose$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readUTF8Line(ByteReadChannel $this$readUTF8Line, int max, Continuation<? super String> continuation) {
        ByteReadChannelOperationsKt$readUTF8Line$1 byteReadChannelOperationsKt$readUTF8Line$1;
        StringBuilder result;
        Object readUTF8LineTo;
        boolean completed;
        if (continuation instanceof ByteReadChannelOperationsKt$readUTF8Line$1) {
            byteReadChannelOperationsKt$readUTF8Line$1 = (ByteReadChannelOperationsKt$readUTF8Line$1) continuation;
            if ((byteReadChannelOperationsKt$readUTF8Line$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$readUTF8Line$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$readUTF8Line$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$readUTF8Line$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        result = new StringBuilder();
                        byteReadChannelOperationsKt$readUTF8Line$1.L$0 = result;
                        byteReadChannelOperationsKt$readUTF8Line$1.label = 1;
                        readUTF8LineTo = readUTF8LineTo($this$readUTF8Line, result, max, byteReadChannelOperationsKt$readUTF8Line$1);
                        if (readUTF8LineTo == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        result = (StringBuilder) byteReadChannelOperationsKt$readUTF8Line$1.L$0;
                        readUTF8LineTo = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                completed = ((Boolean) readUTF8LineTo).booleanValue();
                if (completed) {
                    return null;
                }
                return result.toString();
            }
        }
        byteReadChannelOperationsKt$readUTF8Line$1 = new ByteReadChannelOperationsKt$readUTF8Line$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$readUTF8Line$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$readUTF8Line$1.label) {
        }
        completed = ((Boolean) readUTF8LineTo).booleanValue();
        if (completed) {
        }
    }

    public static /* synthetic */ Object readUTF8Line$default(ByteReadChannel byteReadChannel, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8Line(byteReadChannel, i, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b A[Catch: all -> 0x005a, TryCatch #1 {all -> 0x005a, blocks: (B:15:0x0048, B:23:0x0065, B:25:0x006b, B:28:0x0089, B:18:0x0056), top: B:46:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009b  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0097 -> B:23:0x0065). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyTo(ByteReadChannel $this$copyTo, ByteWriteChannel channel, Continuation<? super Long> continuation) {
        ByteReadChannelOperationsKt$copyTo$1 byteReadChannelOperationsKt$copyTo$1;
        Object coroutine_suspended;
        ByteWriteChannel channel2;
        ByteReadChannel $this$copyTo2;
        long result;
        ByteWriteChannel channel3;
        try {
            if (continuation instanceof ByteReadChannelOperationsKt$copyTo$1) {
                byteReadChannelOperationsKt$copyTo$1 = (ByteReadChannelOperationsKt$copyTo$1) continuation;
                if ((byteReadChannelOperationsKt$copyTo$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                    byteReadChannelOperationsKt$copyTo$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                    Object $result = byteReadChannelOperationsKt$copyTo$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    channel2 = byteReadChannelOperationsKt$copyTo$1.label;
                    switch (channel2) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            channel2 = channel;
                            $this$copyTo2 = $this$copyTo;
                            result = 0;
                            if ($this$copyTo2.isClosedForRead()) {
                                result += $this$copyTo2.mo1388getReadBuffer().transferTo(channel2.getWriteBuffer());
                                byteReadChannelOperationsKt$copyTo$1.L$0 = $this$copyTo2;
                                byteReadChannelOperationsKt$copyTo$1.L$1 = channel2;
                                byteReadChannelOperationsKt$copyTo$1.J$0 = result;
                                byteReadChannelOperationsKt$copyTo$1.label = 1;
                                Object flush = channel2.flush(byteReadChannelOperationsKt$copyTo$1);
                                channel3 = channel2;
                                if (flush == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                byteReadChannelOperationsKt$copyTo$1.L$0 = $this$copyTo2;
                                byteReadChannelOperationsKt$copyTo$1.L$1 = channel3;
                                byteReadChannelOperationsKt$copyTo$1.J$0 = result;
                                byteReadChannelOperationsKt$copyTo$1.label = 2;
                                channel2 = channel3;
                                if (ByteReadChannel.DefaultImpls.awaitContent$default($this$copyTo2, 0, byteReadChannelOperationsKt$copyTo$1, 1, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                if ($this$copyTo2.isClosedForRead()) {
                                    byteReadChannelOperationsKt$copyTo$1.L$0 = null;
                                    byteReadChannelOperationsKt$copyTo$1.L$1 = null;
                                    byteReadChannelOperationsKt$copyTo$1.J$0 = result;
                                    byteReadChannelOperationsKt$copyTo$1.label = 3;
                                    if (channel2.flush(byteReadChannelOperationsKt$copyTo$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Boxing.boxLong(result);
                                }
                            }
                        case 1:
                            result = byteReadChannelOperationsKt$copyTo$1.J$0;
                            ByteWriteChannel byteWriteChannel = (ByteWriteChannel) byteReadChannelOperationsKt$copyTo$1.L$1;
                            $this$copyTo2 = (ByteReadChannel) byteReadChannelOperationsKt$copyTo$1.L$0;
                            ResultKt.throwOnFailure($result);
                            channel3 = byteWriteChannel;
                            byteReadChannelOperationsKt$copyTo$1.L$0 = $this$copyTo2;
                            byteReadChannelOperationsKt$copyTo$1.L$1 = channel3;
                            byteReadChannelOperationsKt$copyTo$1.J$0 = result;
                            byteReadChannelOperationsKt$copyTo$1.label = 2;
                            channel2 = channel3;
                            if (ByteReadChannel.DefaultImpls.awaitContent$default($this$copyTo2, 0, byteReadChannelOperationsKt$copyTo$1, 1, null) == coroutine_suspended) {
                            }
                            if ($this$copyTo2.isClosedForRead()) {
                            }
                            break;
                        case 2:
                            result = byteReadChannelOperationsKt$copyTo$1.J$0;
                            ByteWriteChannel byteWriteChannel2 = (ByteWriteChannel) byteReadChannelOperationsKt$copyTo$1.L$1;
                            $this$copyTo2 = (ByteReadChannel) byteReadChannelOperationsKt$copyTo$1.L$0;
                            ResultKt.throwOnFailure($result);
                            channel2 = byteWriteChannel2;
                            if ($this$copyTo2.isClosedForRead()) {
                            }
                            break;
                        case 3:
                            result = byteReadChannelOperationsKt$copyTo$1.J$0;
                            ResultKt.throwOnFailure($result);
                            return Boxing.boxLong(result);
                        case 4:
                            Throwable th = (Throwable) byteReadChannelOperationsKt$copyTo$1.L$0;
                            ResultKt.throwOnFailure($result);
                            throw th;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (channel2) {
            }
        } catch (Throwable cause) {
            try {
                $this$copyTo2.cancel(cause);
                ByteWriteChannelOperationsKt.close(channel2, cause);
                throw cause;
            } catch (Throwable cause2) {
                byteReadChannelOperationsKt$copyTo$1.L$0 = cause2;
                byteReadChannelOperationsKt$copyTo$1.L$1 = null;
                byteReadChannelOperationsKt$copyTo$1.label = 4;
                if (channel2.flush(byteReadChannelOperationsKt$copyTo$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                throw cause2;
            }
        }
        byteReadChannelOperationsKt$copyTo$1 = new ByteReadChannelOperationsKt$copyTo$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$copyTo$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        channel2 = byteReadChannelOperationsKt$copyTo$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ef A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00d7 -> B:59:0x0079). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyTo(ByteReadChannel $this$copyTo, ByteWriteChannel byteWriteChannel, long j, Continuation<? super Long> continuation) {
        ByteReadChannelOperationsKt$copyTo$2 byteReadChannelOperationsKt$copyTo$2;
        ByteReadChannelOperationsKt$copyTo$2 byteReadChannelOperationsKt$copyTo$22;
        ByteReadChannel $this$copyTo2;
        ByteWriteChannel channel;
        long limit;
        ByteWriteChannel channel2;
        long remaining;
        long limit2;
        long limit3;
        long remaining2;
        try {
            if (continuation instanceof ByteReadChannelOperationsKt$copyTo$2) {
                byteReadChannelOperationsKt$copyTo$2 = (ByteReadChannelOperationsKt$copyTo$2) continuation;
                if ((byteReadChannelOperationsKt$copyTo$2.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                    byteReadChannelOperationsKt$copyTo$2.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                    byteReadChannelOperationsKt$copyTo$22 = byteReadChannelOperationsKt$copyTo$2;
                    Object $result = byteReadChannelOperationsKt$copyTo$22.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (byteReadChannelOperationsKt$copyTo$22.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            limit = j;
                            channel2 = byteWriteChannel;
                            remaining = limit;
                            $this$copyTo2 = $this$copyTo;
                            try {
                                if (!$this$copyTo2.isClosedForRead() || remaining <= 0) {
                                    byteReadChannelOperationsKt$copyTo$22.L$0 = null;
                                    byteReadChannelOperationsKt$copyTo$22.L$1 = null;
                                    byteReadChannelOperationsKt$copyTo$22.J$0 = limit;
                                    byteReadChannelOperationsKt$copyTo$22.J$1 = remaining;
                                    byteReadChannelOperationsKt$copyTo$22.label = 3;
                                    if (channel2.flush(byteReadChannelOperationsKt$copyTo$22) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    remaining2 = remaining;
                                    return Boxing.boxLong(limit - remaining2);
                                }
                                try {
                                    if ($this$copyTo2.mo1388getReadBuffer().exhausted()) {
                                        byteReadChannelOperationsKt$copyTo$22.L$0 = $this$copyTo2;
                                        byteReadChannelOperationsKt$copyTo$22.L$1 = channel2;
                                        byteReadChannelOperationsKt$copyTo$22.J$0 = limit;
                                        byteReadChannelOperationsKt$copyTo$22.J$1 = remaining;
                                        byteReadChannelOperationsKt$copyTo$22.label = 1;
                                        if (ByteReadChannel.DefaultImpls.awaitContent$default($this$copyTo2, 0, byteReadChannelOperationsKt$copyTo$22, 1, null) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        channel = channel2;
                                        limit3 = limit;
                                        limit2 = remaining;
                                    } else {
                                        channel = channel2;
                                        limit3 = limit;
                                        limit2 = remaining;
                                    }
                                    long count = Math.min(limit2, ByteReadPacketKt.getRemaining($this$copyTo2.mo1388getReadBuffer()));
                                    $this$copyTo2.mo1388getReadBuffer().readTo(channel.getWriteBuffer(), count);
                                    long remaining3 = limit2 - count;
                                    byteReadChannelOperationsKt$copyTo$22.L$0 = $this$copyTo2;
                                    byteReadChannelOperationsKt$copyTo$22.L$1 = channel;
                                    byteReadChannelOperationsKt$copyTo$22.J$0 = limit3;
                                    byteReadChannelOperationsKt$copyTo$22.J$1 = remaining3;
                                    byteReadChannelOperationsKt$copyTo$22.label = 2;
                                    if (channel.flush(byteReadChannelOperationsKt$copyTo$22) != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    long j2 = limit3;
                                    channel2 = channel;
                                    remaining = remaining3;
                                    limit = j2;
                                    if ($this$copyTo2.isClosedForRead()) {
                                    }
                                    byteReadChannelOperationsKt$copyTo$22.L$0 = null;
                                    byteReadChannelOperationsKt$copyTo$22.L$1 = null;
                                    byteReadChannelOperationsKt$copyTo$22.J$0 = limit;
                                    byteReadChannelOperationsKt$copyTo$22.J$1 = remaining;
                                    byteReadChannelOperationsKt$copyTo$22.label = 3;
                                    if (channel2.flush(byteReadChannelOperationsKt$copyTo$22) == coroutine_suspended) {
                                    }
                                } catch (Throwable th) {
                                    cause = th;
                                    try {
                                        $this$copyTo2.cancel(cause);
                                        ByteWriteChannelOperationsKt.close(channel, cause);
                                        throw cause;
                                    } catch (Throwable cause) {
                                        byteReadChannelOperationsKt$copyTo$22.L$0 = cause;
                                        byteReadChannelOperationsKt$copyTo$22.L$1 = null;
                                        byteReadChannelOperationsKt$copyTo$22.label = 4;
                                        if (channel.flush(byteReadChannelOperationsKt$copyTo$22) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        throw cause;
                                    }
                                }
                            } catch (Throwable th2) {
                                cause = th2;
                                channel = channel2;
                                $this$copyTo2.cancel(cause);
                                ByteWriteChannelOperationsKt.close(channel, cause);
                                throw cause;
                            }
                        case 1:
                            limit2 = byteReadChannelOperationsKt$copyTo$22.J$1;
                            limit3 = byteReadChannelOperationsKt$copyTo$22.J$0;
                            channel = (ByteWriteChannel) byteReadChannelOperationsKt$copyTo$22.L$1;
                            $this$copyTo2 = (ByteReadChannel) byteReadChannelOperationsKt$copyTo$22.L$0;
                            ResultKt.throwOnFailure($result);
                            long count2 = Math.min(limit2, ByteReadPacketKt.getRemaining($this$copyTo2.mo1388getReadBuffer()));
                            $this$copyTo2.mo1388getReadBuffer().readTo(channel.getWriteBuffer(), count2);
                            long remaining32 = limit2 - count2;
                            byteReadChannelOperationsKt$copyTo$22.L$0 = $this$copyTo2;
                            byteReadChannelOperationsKt$copyTo$22.L$1 = channel;
                            byteReadChannelOperationsKt$copyTo$22.J$0 = limit3;
                            byteReadChannelOperationsKt$copyTo$22.J$1 = remaining32;
                            byteReadChannelOperationsKt$copyTo$22.label = 2;
                            if (channel.flush(byteReadChannelOperationsKt$copyTo$22) != coroutine_suspended) {
                            }
                            break;
                        case 2:
                            long limit4 = byteReadChannelOperationsKt$copyTo$22.J$1;
                            long limit5 = byteReadChannelOperationsKt$copyTo$22.J$0;
                            ByteWriteChannel channel3 = (ByteWriteChannel) byteReadChannelOperationsKt$copyTo$22.L$1;
                            $this$copyTo2 = (ByteReadChannel) byteReadChannelOperationsKt$copyTo$22.L$0;
                            ResultKt.throwOnFailure($result);
                            channel2 = channel3;
                            remaining = limit4;
                            limit = limit5;
                            if ($this$copyTo2.isClosedForRead()) {
                            }
                            byteReadChannelOperationsKt$copyTo$22.L$0 = null;
                            byteReadChannelOperationsKt$copyTo$22.L$1 = null;
                            byteReadChannelOperationsKt$copyTo$22.J$0 = limit;
                            byteReadChannelOperationsKt$copyTo$22.J$1 = remaining;
                            byteReadChannelOperationsKt$copyTo$22.label = 3;
                            if (channel2.flush(byteReadChannelOperationsKt$copyTo$22) == coroutine_suspended) {
                            }
                            break;
                        case 3:
                            remaining2 = byteReadChannelOperationsKt$copyTo$22.J$1;
                            limit = byteReadChannelOperationsKt$copyTo$22.J$0;
                            ResultKt.throwOnFailure($result);
                            return Boxing.boxLong(limit - remaining2);
                        case 4:
                            Throwable th3 = (Throwable) byteReadChannelOperationsKt$copyTo$22.L$0;
                            ResultKt.throwOnFailure($result);
                            throw th3;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (byteReadChannelOperationsKt$copyTo$22.label) {
            }
        } catch (Throwable th4) {
            cause = th4;
        }
        byteReadChannelOperationsKt$copyTo$2 = new ByteReadChannelOperationsKt$copyTo$2(continuation);
        byteReadChannelOperationsKt$copyTo$22 = byteReadChannelOperationsKt$copyTo$2;
        Object $result2 = byteReadChannelOperationsKt$copyTo$22.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0079 -> B:20:0x0081). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readByteArray(ByteReadChannel $this$readByteArray, int count, Continuation<? super byte[]> continuation) {
        ByteReadChannelOperationsKt$readByteArray$1 byteReadChannelOperationsKt$readByteArray$1;
        ByteReadChannel $this$readByteArray2;
        int $i$f$buildPacket;
        Sink $this$readByteArray_u24lambda_u242;
        Sink $this$readByteArray_u24lambda_u2422;
        Object $result;
        ByteReadChannel $this$readByteArray3;
        Sink sink;
        Sink $this$readByteArray_u24lambda_u2423;
        int count2;
        Object obj;
        if (continuation instanceof ByteReadChannelOperationsKt$readByteArray$1) {
            byteReadChannelOperationsKt$readByteArray$1 = (ByteReadChannelOperationsKt$readByteArray$1) continuation;
            if ((byteReadChannelOperationsKt$readByteArray$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$readByteArray$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result2 = byteReadChannelOperationsKt$readByteArray$1.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$readByteArray$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        Source buffer = new Buffer();
                        Sink $this$readByteArray_u24lambda_u2424 = (Sink) buffer;
                        $this$readByteArray2 = $this$readByteArray;
                        $i$f$buildPacket = count;
                        $this$readByteArray_u24lambda_u242 = buffer;
                        $this$readByteArray_u24lambda_u2422 = $this$readByteArray_u24lambda_u2424;
                        break;
                    case 1:
                        int count3 = byteReadChannelOperationsKt$readByteArray$1.I$0;
                        Sink $this$readByteArray_u24lambda_u2425 = (Sink) byteReadChannelOperationsKt$readByteArray$1.L$2;
                        Buffer builder$iv = (Buffer) byteReadChannelOperationsKt$readByteArray$1.L$1;
                        ByteReadChannel $this$readByteArray4 = (ByteReadChannel) byteReadChannelOperationsKt$readByteArray$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        $this$readByteArray3 = $this$readByteArray4;
                        sink = builder$iv;
                        $this$readByteArray_u24lambda_u2423 = $this$readByteArray_u24lambda_u2425;
                        count2 = count3;
                        obj = $result3;
                        $result = $result2;
                        Source packet = (Source) $result2;
                        BytePacketBuilderKt.writePacket($this$readByteArray_u24lambda_u2423, packet);
                        $result2 = $result;
                        $result3 = obj;
                        $i$f$buildPacket = count2;
                        $this$readByteArray_u24lambda_u2422 = $this$readByteArray_u24lambda_u2423;
                        $this$readByteArray_u24lambda_u242 = sink;
                        $this$readByteArray2 = $this$readByteArray3;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (BytePacketBuilderKt.getSize($this$readByteArray_u24lambda_u2422) < $i$f$buildPacket) {
                    byteReadChannelOperationsKt$readByteArray$1.L$0 = $this$readByteArray2;
                    byteReadChannelOperationsKt$readByteArray$1.L$1 = $this$readByteArray_u24lambda_u242;
                    byteReadChannelOperationsKt$readByteArray$1.L$2 = $this$readByteArray_u24lambda_u2422;
                    byteReadChannelOperationsKt$readByteArray$1.I$0 = $i$f$buildPacket;
                    byteReadChannelOperationsKt$readByteArray$1.label = 1;
                    Object readPacket = readPacket($this$readByteArray2, $i$f$buildPacket - BytePacketBuilderKt.getSize($this$readByteArray_u24lambda_u2422), byteReadChannelOperationsKt$readByteArray$1);
                    if (readPacket == $result3) {
                        return $result3;
                    }
                    Object obj2 = $result3;
                    $result = $result2;
                    $result2 = readPacket;
                    $this$readByteArray3 = $this$readByteArray2;
                    sink = $this$readByteArray_u24lambda_u242;
                    $this$readByteArray_u24lambda_u2423 = $this$readByteArray_u24lambda_u2422;
                    count2 = $i$f$buildPacket;
                    obj = obj2;
                    Source packet2 = (Source) $result2;
                    BytePacketBuilderKt.writePacket($this$readByteArray_u24lambda_u2423, packet2);
                    $result2 = $result;
                    $result3 = obj;
                    $i$f$buildPacket = count2;
                    $this$readByteArray_u24lambda_u2422 = $this$readByteArray_u24lambda_u2423;
                    $this$readByteArray_u24lambda_u242 = sink;
                    $this$readByteArray2 = $this$readByteArray3;
                    if (BytePacketBuilderKt.getSize($this$readByteArray_u24lambda_u2422) < $i$f$buildPacket) {
                        return SourcesKt.readByteArray($this$readByteArray_u24lambda_u242);
                    }
                }
            }
        }
        byteReadChannelOperationsKt$readByteArray$1 = new ByteReadChannelOperationsKt$readByteArray$1(continuation);
        Object $result22 = byteReadChannelOperationsKt$readByteArray$1.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$readByteArray$1.label) {
        }
        if (BytePacketBuilderKt.getSize($this$readByteArray_u24lambda_u2422) < $i$f$buildPacket) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readRemaining(ByteReadChannel $this$readRemaining, Continuation<? super Source> continuation) {
        ByteReadChannelOperationsKt$readRemaining$1 byteReadChannelOperationsKt$readRemaining$1;
        ByteReadChannel $this$readRemaining2;
        Sink result;
        if (continuation instanceof ByteReadChannelOperationsKt$readRemaining$1) {
            byteReadChannelOperationsKt$readRemaining$1 = (ByteReadChannelOperationsKt$readRemaining$1) continuation;
            if ((byteReadChannelOperationsKt$readRemaining$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$readRemaining$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$readRemaining$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$readRemaining$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$readRemaining2 = $this$readRemaining;
                        result = BytePacketBuilderKt.BytePacketBuilder();
                        break;
                    case 1:
                        result = (Sink) byteReadChannelOperationsKt$readRemaining$1.L$1;
                        $this$readRemaining2 = (ByteReadChannel) byteReadChannelOperationsKt$readRemaining$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (!$this$readRemaining2.isClosedForRead()) {
                    result.transferFrom($this$readRemaining2.mo1388getReadBuffer());
                    byteReadChannelOperationsKt$readRemaining$1.L$0 = $this$readRemaining2;
                    byteReadChannelOperationsKt$readRemaining$1.L$1 = result;
                    byteReadChannelOperationsKt$readRemaining$1.label = 1;
                    if (ByteReadChannel.DefaultImpls.awaitContent$default($this$readRemaining2, 0, byteReadChannelOperationsKt$readRemaining$1, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                rethrowCloseCauseIfNeeded($this$readRemaining2);
                return result.getBuffer();
            }
        }
        byteReadChannelOperationsKt$readRemaining$1 = new ByteReadChannelOperationsKt$readRemaining$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$readRemaining$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$readRemaining$1.label) {
        }
        while (!$this$readRemaining2.isClosedForRead()) {
        }
        rethrowCloseCauseIfNeeded($this$readRemaining2);
        return result.getBuffer();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0094 A[LOOP:0: B:14:0x0045->B:25:0x0094, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0093 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readRemaining(ByteReadChannel $this$readRemaining, long max, Continuation<? super Source> continuation) {
        ByteReadChannelOperationsKt$readRemaining$2 byteReadChannelOperationsKt$readRemaining$2;
        Object coroutine_suspended;
        long remaining;
        RawSink result;
        ByteReadChannel $this$readRemaining2;
        long remaining2;
        if (continuation instanceof ByteReadChannelOperationsKt$readRemaining$2) {
            byteReadChannelOperationsKt$readRemaining$2 = (ByteReadChannelOperationsKt$readRemaining$2) continuation;
            if ((byteReadChannelOperationsKt$readRemaining$2.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$readRemaining$2.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$readRemaining$2.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$readRemaining$2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        remaining = max;
                        result = BytePacketBuilderKt.BytePacketBuilder();
                        $this$readRemaining2 = $this$readRemaining;
                        break;
                    case 1:
                        long remaining3 = byteReadChannelOperationsKt$readRemaining$2.J$0;
                        result = (Sink) byteReadChannelOperationsKt$readRemaining$2.L$1;
                        $this$readRemaining2 = (ByteReadChannel) byteReadChannelOperationsKt$readRemaining$2.L$0;
                        ResultKt.throwOnFailure($result);
                        remaining = remaining3;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (!$this$readRemaining2.isClosedForRead() && remaining > 0) {
                    if (remaining < ByteReadPacketKt.getRemaining($this$readRemaining2.mo1388getReadBuffer())) {
                        long remaining4 = remaining - ByteReadPacketKt.getRemaining($this$readRemaining2.mo1388getReadBuffer());
                        Boxing.boxLong($this$readRemaining2.mo1388getReadBuffer().transferTo(result));
                        remaining2 = remaining4;
                    } else {
                        $this$readRemaining2.mo1388getReadBuffer().readTo(result, remaining);
                        remaining2 = 0;
                    }
                    byteReadChannelOperationsKt$readRemaining$2.L$0 = $this$readRemaining2;
                    byteReadChannelOperationsKt$readRemaining$2.L$1 = result;
                    byteReadChannelOperationsKt$readRemaining$2.J$0 = remaining2;
                    byteReadChannelOperationsKt$readRemaining$2.label = 1;
                    if (ByteReadChannel.DefaultImpls.awaitContent$default($this$readRemaining2, 0, byteReadChannelOperationsKt$readRemaining$2, 1, null) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    remaining = remaining2;
                }
                return result.getBuffer();
            }
        }
        byteReadChannelOperationsKt$readRemaining$2 = new ByteReadChannelOperationsKt$readRemaining$2(continuation);
        Object $result2 = byteReadChannelOperationsKt$readRemaining$2.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$readRemaining$2.label) {
        }
        while (!$this$readRemaining2.isClosedForRead()) {
            if (remaining < ByteReadPacketKt.getRemaining($this$readRemaining2.mo1388getReadBuffer())) {
            }
            byteReadChannelOperationsKt$readRemaining$2.L$0 = $this$readRemaining2;
            byteReadChannelOperationsKt$readRemaining$2.L$1 = result;
            byteReadChannelOperationsKt$readRemaining$2.J$0 = remaining2;
            byteReadChannelOperationsKt$readRemaining$2.label = 1;
            if (ByteReadChannel.DefaultImpls.awaitContent$default($this$readRemaining2, 0, byteReadChannelOperationsKt$readRemaining$2, 1, null) != coroutine_suspended) {
            }
        }
        return result.getBuffer();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readAvailable(ByteReadChannel $this$readAvailable, byte[] buffer, int offset, int length, Continuation<? super Integer> continuation) {
        ByteReadChannelOperationsKt$readAvailable$1 byteReadChannelOperationsKt$readAvailable$1;
        ByteReadChannel $this$readAvailable2;
        int length2;
        byte[] buffer2;
        int offset2;
        if (continuation instanceof ByteReadChannelOperationsKt$readAvailable$1) {
            byteReadChannelOperationsKt$readAvailable$1 = (ByteReadChannelOperationsKt$readAvailable$1) continuation;
            if ((byteReadChannelOperationsKt$readAvailable$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$readAvailable$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$readAvailable$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$readAvailable$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!$this$readAvailable.isClosedForRead()) {
                            if ($this$readAvailable.mo1388getReadBuffer().exhausted()) {
                                byteReadChannelOperationsKt$readAvailable$1.L$0 = $this$readAvailable;
                                byteReadChannelOperationsKt$readAvailable$1.L$1 = buffer;
                                byteReadChannelOperationsKt$readAvailable$1.I$0 = offset;
                                byteReadChannelOperationsKt$readAvailable$1.I$1 = length;
                                byteReadChannelOperationsKt$readAvailable$1.label = 1;
                                if (ByteReadChannel.DefaultImpls.awaitContent$default($this$readAvailable, 0, byteReadChannelOperationsKt$readAvailable$1, 1, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $this$readAvailable2 = $this$readAvailable;
                                length2 = length;
                                buffer2 = buffer;
                                offset2 = offset;
                                ByteReadChannel byteReadChannel = $this$readAvailable2;
                                length = length2;
                                $this$readAvailable = byteReadChannel;
                                byte[] bArr = buffer2;
                                offset = offset2;
                                buffer = bArr;
                                break;
                            }
                        } else {
                            return Boxing.boxInt(-1);
                        }
                        break;
                    case 1:
                        length2 = byteReadChannelOperationsKt$readAvailable$1.I$1;
                        offset2 = byteReadChannelOperationsKt$readAvailable$1.I$0;
                        buffer2 = (byte[]) byteReadChannelOperationsKt$readAvailable$1.L$1;
                        $this$readAvailable2 = (ByteReadChannel) byteReadChannelOperationsKt$readAvailable$1.L$0;
                        ResultKt.throwOnFailure($result);
                        ByteReadChannel byteReadChannel2 = $this$readAvailable2;
                        length = length2;
                        $this$readAvailable = byteReadChannel2;
                        byte[] bArr2 = buffer2;
                        offset = offset2;
                        buffer = bArr2;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return !$this$readAvailable.isClosedForRead() ? Boxing.boxInt(-1) : Boxing.boxInt(InputKt.readAvailable($this$readAvailable.mo1388getReadBuffer(), buffer, offset, length));
            }
        }
        byteReadChannelOperationsKt$readAvailable$1 = new ByteReadChannelOperationsKt$readAvailable$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$readAvailable$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$readAvailable$1.label) {
        }
        if (!$this$readAvailable.isClosedForRead()) {
        }
    }

    public static /* synthetic */ Object readAvailable$default(ByteReadChannel byteReadChannel, byte[] bArr, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        return readAvailable(byteReadChannel, bArr, i, i2, continuation);
    }

    public static final int readAvailable(ByteReadChannel $this$readAvailable, int min, Function1<? super Buffer, Integer> function1) {
        Intrinsics.checkNotNullParameter($this$readAvailable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (min > 0) {
            if (!(min <= 1048576)) {
                throw new IllegalArgumentException(("Min(" + min + ") shouldn't be greater than 1048576").toString());
            }
            if (getAvailableForRead($this$readAvailable) < min) {
                return -1;
            }
            return ((Number) function1.invoke($this$readAvailable.mo1388getReadBuffer().getBuffer())).intValue();
        }
        throw new IllegalArgumentException("min should be positive".toString());
    }

    public static /* synthetic */ ReaderJob reader$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = (CoroutineContext) EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return reader(coroutineScope, coroutineContext, z, function2);
    }

    public static final ReaderJob reader(CoroutineScope $this$reader, CoroutineContext coroutineContext, boolean autoFlush, Function2<? super ReaderScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter($this$reader, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(function2, "block");
        return reader($this$reader, coroutineContext, new ByteChannel(false, 1, null), function2);
    }

    public static final ReaderJob reader(CoroutineScope $this$reader, CoroutineContext coroutineContext, final ByteChannel channel, Function2<? super ReaderScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter($this$reader, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(function2, "block");
        Job $this$reader_u24lambda_u246 = BuildersKt.launch$default($this$reader, coroutineContext, (CoroutineStart) null, new ByteReadChannelOperationsKt$reader$job$1(function2, channel, null), 2, (Object) null);
        $this$reader_u24lambda_u246.invokeOnCompletion(new Function1() { // from class: io.ktor.utils.io.ByteReadChannelOperationsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit reader$lambda$6$lambda$5;
                reader$lambda$6$lambda$5 = ByteReadChannelOperationsKt.reader$lambda$6$lambda$5(ByteChannel.this, (Throwable) obj);
                return reader$lambda$6$lambda$5;
            }
        });
        return new ReaderJob(channel, $this$reader_u24lambda_u246);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reader$lambda$6$lambda$5(ByteChannel $channel, Throwable it) {
        if (it != null && !$channel.isClosedForRead()) {
            $channel.cancel(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0057 -> B:22:0x006c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0068 -> B:22:0x006c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readPacket(ByteReadChannel $this$readPacket, int packet, Continuation<? super Source> continuation) {
        ByteReadChannelOperationsKt$readPacket$1 byteReadChannelOperationsKt$readPacket$1;
        ByteReadChannel $this$readPacket2;
        int packet2;
        RawSink result;
        if (continuation instanceof ByteReadChannelOperationsKt$readPacket$1) {
            byteReadChannelOperationsKt$readPacket$1 = (ByteReadChannelOperationsKt$readPacket$1) continuation;
            if ((byteReadChannelOperationsKt$readPacket$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$readPacket$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$readPacket$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$readPacket$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$readPacket2 = $this$readPacket;
                        packet2 = packet;
                        result = new Buffer();
                        break;
                    case 1:
                        packet2 = byteReadChannelOperationsKt$readPacket$1.I$0;
                        result = (Buffer) byteReadChannelOperationsKt$readPacket$1.L$1;
                        $this$readPacket2 = (ByteReadChannel) byteReadChannelOperationsKt$readPacket$1.L$0;
                        ResultKt.throwOnFailure($result);
                        if (!$this$readPacket2.isClosedForRead()) {
                            if (ByteReadPacketKt.getRemaining($this$readPacket2.mo1388getReadBuffer()) > packet2 - result.getSize()) {
                                $this$readPacket2.mo1388getReadBuffer().readTo(result, packet2 - result.getSize());
                                break;
                            } else {
                                Boxing.boxLong($this$readPacket2.mo1388getReadBuffer().transferTo(result));
                                break;
                            }
                        }
                        if (result.getSize() < packet2) {
                            throw new EOFException("Not enough data available, required " + packet2 + " bytes but only " + result.getSize() + " available");
                        }
                        return result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (result.getSize() < packet2) {
                    if ($this$readPacket2.mo1388getReadBuffer().exhausted()) {
                        byteReadChannelOperationsKt$readPacket$1.L$0 = $this$readPacket2;
                        byteReadChannelOperationsKt$readPacket$1.L$1 = result;
                        byteReadChannelOperationsKt$readPacket$1.I$0 = packet2;
                        byteReadChannelOperationsKt$readPacket$1.label = 1;
                        if (ByteReadChannel.DefaultImpls.awaitContent$default($this$readPacket2, 0, byteReadChannelOperationsKt$readPacket$1, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    if (!$this$readPacket2.isClosedForRead()) {
                    }
                }
                if (result.getSize() < packet2) {
                }
            }
        }
        byteReadChannelOperationsKt$readPacket$1 = new ByteReadChannelOperationsKt$readPacket$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$readPacket$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$readPacket$1.label) {
        }
        if (result.getSize() < packet2) {
        }
        if (result.getSize() < packet2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object discardExact(ByteReadChannel $this$discardExact, long value, Continuation<? super Unit> continuation) {
        ByteReadChannelOperationsKt$discardExact$1 byteReadChannelOperationsKt$discardExact$1;
        Object discard;
        if (continuation instanceof ByteReadChannelOperationsKt$discardExact$1) {
            byteReadChannelOperationsKt$discardExact$1 = (ByteReadChannelOperationsKt$discardExact$1) continuation;
            if ((byteReadChannelOperationsKt$discardExact$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$discardExact$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$discardExact$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$discardExact$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        byteReadChannelOperationsKt$discardExact$1.J$0 = value;
                        byteReadChannelOperationsKt$discardExact$1.label = 1;
                        discard = discard($this$discardExact, value, byteReadChannelOperationsKt$discardExact$1);
                        if (discard == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        long value2 = byteReadChannelOperationsKt$discardExact$1.J$0;
                        ResultKt.throwOnFailure($result);
                        value = value2;
                        discard = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Number) discard).longValue() >= value) {
                    throw new EOFException("Unable to discard " + value + " bytes");
                }
                return Unit.INSTANCE;
            }
        }
        byteReadChannelOperationsKt$discardExact$1 = new ByteReadChannelOperationsKt$discardExact$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$discardExact$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$discardExact$1.label) {
        }
        if (((Number) discard).longValue() >= value) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0050 -> B:24:0x0065). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0061 -> B:24:0x0065). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object discard(ByteReadChannel $this$discard, long max, Continuation<? super Long> continuation) {
        ByteReadChannelOperationsKt$discard$1 byteReadChannelOperationsKt$discard$1;
        ByteReadChannel $this$discard2;
        long remaining;
        long max2;
        if (continuation instanceof ByteReadChannelOperationsKt$discard$1) {
            byteReadChannelOperationsKt$discard$1 = (ByteReadChannelOperationsKt$discard$1) continuation;
            if ((byteReadChannelOperationsKt$discard$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$discard$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$discard$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$discard$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$discard2 = $this$discard;
                        remaining = max;
                        max2 = max;
                        break;
                    case 1:
                        remaining = byteReadChannelOperationsKt$discard$1.J$1;
                        max2 = byteReadChannelOperationsKt$discard$1.J$0;
                        $this$discard2 = (ByteReadChannel) byteReadChannelOperationsKt$discard$1.L$0;
                        ResultKt.throwOnFailure($result);
                        long count = Math.min(remaining, ByteReadPacketKt.getRemaining($this$discard2.mo1388getReadBuffer()));
                        ByteReadPacketKt.discard($this$discard2.mo1388getReadBuffer(), count);
                        remaining -= count;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (remaining <= 0 && !$this$discard2.isClosedForRead()) {
                    if (getAvailableForRead($this$discard2) == 0) {
                        byteReadChannelOperationsKt$discard$1.L$0 = $this$discard2;
                        byteReadChannelOperationsKt$discard$1.J$0 = max2;
                        byteReadChannelOperationsKt$discard$1.J$1 = remaining;
                        byteReadChannelOperationsKt$discard$1.label = 1;
                        if (ByteReadChannel.DefaultImpls.awaitContent$default($this$discard2, 0, byteReadChannelOperationsKt$discard$1, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    long count2 = Math.min(remaining, ByteReadPacketKt.getRemaining($this$discard2.mo1388getReadBuffer()));
                    ByteReadPacketKt.discard($this$discard2.mo1388getReadBuffer(), count2);
                    remaining -= count2;
                    if (remaining <= 0) {
                    }
                    return Boxing.boxLong(max2 - remaining);
                }
                return Boxing.boxLong(max2 - remaining);
            }
        }
        byteReadChannelOperationsKt$discard$1 = new ByteReadChannelOperationsKt$discard$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$discard$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$discard$1.label) {
        }
        if (remaining <= 0) {
        }
        return Boxing.boxLong(max2 - remaining);
    }

    public static /* synthetic */ Object discard$default(ByteReadChannel byteReadChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        return discard(byteReadChannel, j, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x020f  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a9 -> B:31:0x00ac). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readUTF8LineTo(ByteReadChannel byteReadChannel, Appendable appendable, int i, Continuation<? super Boolean> continuation) {
        ByteReadChannelOperationsKt$readUTF8LineTo$1 byteReadChannelOperationsKt$readUTF8LineTo$1;
        ByteReadChannel $this$readUTF8LineTo;
        int consumed;
        Appendable out;
        int max;
        int consumed2;
        Appendable out2;
        long cr;
        long lf;
        Object obj;
        int i2;
        ByteReadChannel $this$readUTF8LineTo2;
        if (continuation instanceof ByteReadChannelOperationsKt$readUTF8LineTo$1) {
            byteReadChannelOperationsKt$readUTF8LineTo$1 = (ByteReadChannelOperationsKt$readUTF8LineTo$1) continuation;
            if ((byteReadChannelOperationsKt$readUTF8LineTo$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$readUTF8LineTo$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$readUTF8LineTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                Object obj2 = null;
                int i3 = 0;
                ?? r11 = 1;
                switch (byteReadChannelOperationsKt$readUTF8LineTo$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$readUTF8LineTo = byteReadChannel;
                        consumed = i;
                        out = appendable;
                        if ($this$readUTF8LineTo.mo1388getReadBuffer().exhausted()) {
                            byteReadChannelOperationsKt$readUTF8LineTo$1.L$0 = $this$readUTF8LineTo;
                            byteReadChannelOperationsKt$readUTF8LineTo$1.L$1 = out;
                            byteReadChannelOperationsKt$readUTF8LineTo$1.I$0 = consumed;
                            byteReadChannelOperationsKt$readUTF8LineTo$1.label = 1;
                            if (ByteReadChannel.DefaultImpls.awaitContent$default($this$readUTF8LineTo, 0, byteReadChannelOperationsKt$readUTF8LineTo$1, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        if (!$this$readUTF8LineTo.isClosedForRead()) {
                            return Boxing.boxBoolean(false);
                        }
                        Appendable appendable2 = out;
                        max = consumed;
                        consumed2 = 0;
                        out2 = appendable2;
                        if ($this$readUTF8LineTo.isClosedForRead()) {
                            byteReadChannelOperationsKt$readUTF8LineTo$1.L$0 = $this$readUTF8LineTo;
                            byteReadChannelOperationsKt$readUTF8LineTo$1.L$1 = out2;
                            byteReadChannelOperationsKt$readUTF8LineTo$1.I$0 = max;
                            byteReadChannelOperationsKt$readUTF8LineTo$1.I$1 = consumed2;
                            byteReadChannelOperationsKt$readUTF8LineTo$1.label = 2;
                            if (ByteReadChannel.DefaultImpls.awaitContent$default($this$readUTF8LineTo, i3, byteReadChannelOperationsKt$readUTF8LineTo$1, r11, obj2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            cr = SourcesKt.indexOf$default($this$readUTF8LineTo.mo1388getReadBuffer(), (byte) 13, 0L, 0L, 6, (Object) null);
                            lf = SourcesKt.indexOf$default($this$readUTF8LineTo.mo1388getReadBuffer(), (byte) 10, 0L, 0L, 6, (Object) null);
                            if (cr != -1 && lf == -1) {
                                if (max == Integer.MAX_VALUE) {
                                    String value = Utf8Kt.readString($this$readUTF8LineTo.mo1388getReadBuffer());
                                    out2.append(value);
                                } else {
                                    int count = Math.min(max - consumed2, (int) ByteReadPacketKt.getRemaining($this$readUTF8LineTo.mo1388getReadBuffer()));
                                    consumed2 += count;
                                    out2.append(Utf8Kt.readString($this$readUTF8LineTo.mo1388getReadBuffer(), count));
                                    if (consumed2 == max) {
                                        throw new TooLongLineException("Line exceeds limit of " + max + " characters");
                                    }
                                }
                                obj2 = null;
                                i3 = 0;
                                r11 = 1;
                            } else if (cr < 0 && lf == cr + 1) {
                                long count2 = max != Integer.MAX_VALUE ? cr : Math.min(max - consumed2, (int) cr);
                                out2.append(Utf8Kt.readString($this$readUTF8LineTo.mo1388getReadBuffer(), count2));
                                if (count2 == cr) {
                                    ByteReadPacketKt.discard($this$readUTF8LineTo.mo1388getReadBuffer(), 2L);
                                }
                                return Boxing.boxBoolean(true);
                            } else {
                                if (cr < 0) {
                                    obj = null;
                                    i2 = 0;
                                } else if (lf == -1 || cr < lf) {
                                    long count3 = max != Integer.MAX_VALUE ? cr : Math.min(max - consumed2, (int) cr);
                                    out2.append(Utf8Kt.readString($this$readUTF8LineTo.mo1388getReadBuffer(), count3));
                                    if (count3 == cr) {
                                        ByteReadPacketKt.discard($this$readUTF8LineTo.mo1388getReadBuffer(), 1L);
                                    }
                                    if ($this$readUTF8LineTo.mo1388getReadBuffer().exhausted()) {
                                        byteReadChannelOperationsKt$readUTF8LineTo$1.L$0 = $this$readUTF8LineTo;
                                        byteReadChannelOperationsKt$readUTF8LineTo$1.L$1 = null;
                                        byteReadChannelOperationsKt$readUTF8LineTo$1.label = 3;
                                        if (ByteReadChannel.DefaultImpls.awaitContent$default($this$readUTF8LineTo, 0, byteReadChannelOperationsKt$readUTF8LineTo$1, 1, null) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        $this$readUTF8LineTo2 = $this$readUTF8LineTo;
                                        $this$readUTF8LineTo = $this$readUTF8LineTo2;
                                    }
                                    if ($this$readUTF8LineTo.mo1388getReadBuffer().getBuffer().get(0L) == 10) {
                                        ByteReadPacketKt.discard($this$readUTF8LineTo.mo1388getReadBuffer(), 1L);
                                    }
                                    return Boxing.boxBoolean(true);
                                } else {
                                    obj = null;
                                    i2 = 0;
                                }
                                if (lf < 0) {
                                    long count4 = max != Integer.MAX_VALUE ? lf : Math.min(max - consumed2, (int) lf);
                                    out2.append(Utf8Kt.readString($this$readUTF8LineTo.mo1388getReadBuffer(), count4));
                                    if (count4 == lf) {
                                        ByteReadPacketKt.discard($this$readUTF8LineTo.mo1388getReadBuffer(), 1L);
                                    }
                                    return Boxing.boxBoolean(true);
                                }
                                r11 = 1;
                                obj2 = obj;
                                i3 = i2;
                            }
                            if ($this$readUTF8LineTo.isClosedForRead()) {
                                return Boxing.boxBoolean((boolean) r11);
                            }
                        }
                        break;
                    case 1:
                        consumed = byteReadChannelOperationsKt$readUTF8LineTo$1.I$0;
                        out = (Appendable) byteReadChannelOperationsKt$readUTF8LineTo$1.L$1;
                        $this$readUTF8LineTo = (ByteReadChannel) byteReadChannelOperationsKt$readUTF8LineTo$1.L$0;
                        ResultKt.throwOnFailure($result);
                        if (!$this$readUTF8LineTo.isClosedForRead()) {
                        }
                        break;
                    case 2:
                        consumed2 = byteReadChannelOperationsKt$readUTF8LineTo$1.I$1;
                        max = byteReadChannelOperationsKt$readUTF8LineTo$1.I$0;
                        ByteReadChannel $this$readUTF8LineTo3 = (ByteReadChannel) byteReadChannelOperationsKt$readUTF8LineTo$1.L$0;
                        ResultKt.throwOnFailure($result);
                        out2 = (Appendable) byteReadChannelOperationsKt$readUTF8LineTo$1.L$1;
                        $this$readUTF8LineTo = $this$readUTF8LineTo3;
                        cr = SourcesKt.indexOf$default($this$readUTF8LineTo.mo1388getReadBuffer(), (byte) 13, 0L, 0L, 6, (Object) null);
                        lf = SourcesKt.indexOf$default($this$readUTF8LineTo.mo1388getReadBuffer(), (byte) 10, 0L, 0L, 6, (Object) null);
                        if (cr != -1) {
                            break;
                        }
                        if (cr < 0) {
                            break;
                        }
                        if (cr < 0) {
                        }
                        if (lf < 0) {
                        }
                        break;
                    case 3:
                        $this$readUTF8LineTo2 = (ByteReadChannel) byteReadChannelOperationsKt$readUTF8LineTo$1.L$0;
                        ResultKt.throwOnFailure($result);
                        $this$readUTF8LineTo = $this$readUTF8LineTo2;
                        if ($this$readUTF8LineTo.mo1388getReadBuffer().getBuffer().get(0L) == 10) {
                        }
                        return Boxing.boxBoolean(true);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        byteReadChannelOperationsKt$readUTF8LineTo$1 = new ByteReadChannelOperationsKt$readUTF8LineTo$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$readUTF8LineTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Object obj22 = null;
        int i32 = 0;
        ?? r112 = 1;
        switch (byteReadChannelOperationsKt$readUTF8LineTo$1.label) {
        }
    }

    public static /* synthetic */ Object readUTF8LineTo$default(ByteReadChannel byteReadChannel, Appendable appendable, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8LineTo(byteReadChannel, appendable, i, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object read(ByteReadChannel byteReadChannel, Function4<? super byte[], ? super Integer, ? super Integer, ? super Continuation<? super Integer>, ? extends Object> function4, Continuation<? super Integer> continuation) {
        ByteReadChannelOperationsKt$read$1 byteReadChannelOperationsKt$read$1;
        ByteReadChannel $this$read;
        Function4 block;
        boolean z;
        Buffer buffer$iv;
        Object invoke;
        Ref.IntRef intRef;
        Segment head$iv;
        Ref.IntRef result;
        int bytesRead$iv;
        if (continuation instanceof ByteReadChannelOperationsKt$read$1) {
            byteReadChannelOperationsKt$read$1 = (ByteReadChannelOperationsKt$read$1) continuation;
            if ((byteReadChannelOperationsKt$read$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$read$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$read$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$read$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$read = byteReadChannel;
                        block = function4;
                        z = false;
                        if ($this$read.isClosedForRead()) {
                            return Boxing.boxInt(-1);
                        }
                        if ($this$read.mo1388getReadBuffer().exhausted()) {
                            byteReadChannelOperationsKt$read$1.L$0 = $this$read;
                            byteReadChannelOperationsKt$read$1.L$1 = block;
                            byteReadChannelOperationsKt$read$1.label = 1;
                            if (ByteReadChannel.DefaultImpls.awaitContent$default($this$read, 0, byteReadChannelOperationsKt$read$1, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        if ($this$read.isClosedForRead()) {
                            Ref.IntRef result2 = new Ref.IntRef();
                            UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
                            buffer$iv = $this$read.mo1388getReadBuffer().getBuffer();
                            if (buffer$iv.exhausted()) {
                                throw new IllegalArgumentException("Buffer is empty".toString());
                            }
                            Segment head$iv2 = buffer$iv.getHead();
                            Intrinsics.checkNotNull(head$iv2);
                            byte[] array = head$iv2.dataAsByteArray(true);
                            int start = head$iv2.getPos();
                            int endExclusive = head$iv2.getLimit();
                            Integer boxInt = Boxing.boxInt(start);
                            Integer boxInt2 = Boxing.boxInt(endExclusive);
                            byteReadChannelOperationsKt$read$1.L$0 = result2;
                            byteReadChannelOperationsKt$read$1.L$1 = buffer$iv;
                            byteReadChannelOperationsKt$read$1.L$2 = head$iv2;
                            byteReadChannelOperationsKt$read$1.L$3 = result2;
                            byteReadChannelOperationsKt$read$1.label = 2;
                            invoke = block.invoke(array, boxInt, boxInt2, byteReadChannelOperationsKt$read$1);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            intRef = result2;
                            head$iv = head$iv2;
                            result = intRef;
                            intRef.element = ((Number) invoke).intValue();
                            bytesRead$iv = result.element;
                            if (bytesRead$iv != 0) {
                                if (bytesRead$iv < 0) {
                                    throw new IllegalStateException("Returned negative read bytes count");
                                }
                                if (bytesRead$iv > head$iv.getSize()) {
                                    throw new IllegalStateException("Returned too many bytes");
                                }
                                buffer$iv.skip(bytesRead$iv);
                            }
                            return Boxing.boxInt(result.element);
                        }
                        return Boxing.boxInt(-1);
                    case 1:
                        z = false;
                        block = (Function4) byteReadChannelOperationsKt$read$1.L$1;
                        $this$read = (ByteReadChannel) byteReadChannelOperationsKt$read$1.L$0;
                        ResultKt.throwOnFailure($result);
                        if ($this$read.isClosedForRead()) {
                        }
                        break;
                    case 2:
                        intRef = (Ref.IntRef) byteReadChannelOperationsKt$read$1.L$3;
                        head$iv = (Segment) byteReadChannelOperationsKt$read$1.L$2;
                        buffer$iv = (Buffer) byteReadChannelOperationsKt$read$1.L$1;
                        result = (Ref.IntRef) byteReadChannelOperationsKt$read$1.L$0;
                        ResultKt.throwOnFailure($result);
                        invoke = $result;
                        intRef.element = ((Number) invoke).intValue();
                        bytesRead$iv = result.element;
                        if (bytesRead$iv != 0) {
                        }
                        return Boxing.boxInt(result.element);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        byteReadChannelOperationsKt$read$1 = new ByteReadChannelOperationsKt$read$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$read$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$read$1.label) {
        }
    }

    private static final Object read$$forInline(ByteReadChannel $this$read, Function4<? super byte[], ? super Integer, ? super Integer, ? super Continuation<? super Integer>, ? extends Object> function4, Continuation<? super Integer> continuation) {
        if ($this$read.isClosedForRead()) {
            return -1;
        }
        if ($this$read.mo1388getReadBuffer().exhausted()) {
            InlineMarker.mark(0);
            ByteReadChannel.DefaultImpls.awaitContent$default($this$read, 0, continuation, 1, null);
            InlineMarker.mark(1);
        }
        if ($this$read.isClosedForRead()) {
            return -1;
        }
        Ref.IntRef result = new Ref.IntRef();
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        Buffer buffer$iv = $this$read.mo1388getReadBuffer().getBuffer();
        if (buffer$iv.exhausted()) {
            throw new IllegalArgumentException("Buffer is empty".toString());
        }
        Segment head$iv = buffer$iv.getHead();
        Intrinsics.checkNotNull(head$iv);
        byte[] dataAsByteArray = head$iv.dataAsByteArray(true);
        Integer valueOf = Integer.valueOf(head$iv.getPos());
        int endExclusive = Integer.valueOf(head$iv.getLimit()).intValue();
        int start = valueOf.intValue();
        byte[] array = dataAsByteArray;
        Integer valueOf2 = Integer.valueOf(start);
        Integer valueOf3 = Integer.valueOf(endExclusive);
        InlineMarker.mark(3);
        result.element = ((Number) function4.invoke(array, valueOf2, valueOf3, (Object) null)).intValue();
        int bytesRead$iv = Integer.valueOf(result.element).intValue();
        if (bytesRead$iv != 0) {
            if (bytesRead$iv < 0) {
                throw new IllegalStateException("Returned negative read bytes count");
            }
            if (bytesRead$iv > head$iv.getSize()) {
                throw new IllegalStateException("Returned too many bytes");
            }
            buffer$iv.skip(bytesRead$iv);
        }
        return Integer.valueOf(result.element);
    }

    public static final int getAvailableForRead(ByteReadChannel $this$availableForRead) {
        Intrinsics.checkNotNullParameter($this$availableForRead, "<this>");
        return (int) $this$availableForRead.mo1388getReadBuffer().getBuffer().getSize();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0093  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0056 -> B:23:0x006d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0069 -> B:23:0x006d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readFully(ByteReadChannel $this$readFully, byte[] out, int start, int end, Continuation<? super Unit> continuation) {
        ByteReadChannelOperationsKt$readFully$1 byteReadChannelOperationsKt$readFully$1;
        byte[] out2;
        int end2;
        ByteReadChannel $this$readFully2;
        int offset;
        if (continuation instanceof ByteReadChannelOperationsKt$readFully$1) {
            byteReadChannelOperationsKt$readFully$1 = (ByteReadChannelOperationsKt$readFully$1) continuation;
            if ((byteReadChannelOperationsKt$readFully$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$readFully$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$readFully$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$readFully$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if ($this$readFully.isClosedForRead()) {
                            throw new EOFException("Channel is already closed");
                        }
                        out2 = out;
                        end2 = end;
                        $this$readFully2 = $this$readFully;
                        offset = start;
                        if (offset < end2) {
                            if ($this$readFully2.mo1388getReadBuffer().exhausted()) {
                                byteReadChannelOperationsKt$readFully$1.L$0 = $this$readFully2;
                                byteReadChannelOperationsKt$readFully$1.L$1 = out2;
                                byteReadChannelOperationsKt$readFully$1.I$0 = end2;
                                byteReadChannelOperationsKt$readFully$1.I$1 = offset;
                                byteReadChannelOperationsKt$readFully$1.label = 1;
                                if (ByteReadChannel.DefaultImpls.awaitContent$default($this$readFully2, 0, byteReadChannelOperationsKt$readFully$1, 1, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            if (!$this$readFully2.isClosedForRead()) {
                                throw new EOFException("Channel is already closed");
                            }
                            int count = Math.min(end2 - offset, (int) ByteReadPacketKt.getRemaining($this$readFully2.mo1388getReadBuffer()));
                            SourcesKt.readTo($this$readFully2.mo1388getReadBuffer(), out2, offset, offset + count);
                            offset += count;
                            if (offset < end2) {
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    case 1:
                        offset = byteReadChannelOperationsKt$readFully$1.I$1;
                        end2 = byteReadChannelOperationsKt$readFully$1.I$0;
                        out2 = (byte[]) byteReadChannelOperationsKt$readFully$1.L$1;
                        $this$readFully2 = (ByteReadChannel) byteReadChannelOperationsKt$readFully$1.L$0;
                        ResultKt.throwOnFailure($result);
                        if (!$this$readFully2.isClosedForRead()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        byteReadChannelOperationsKt$readFully$1 = new ByteReadChannelOperationsKt$readFully$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$readFully$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$readFully$1.label) {
        }
    }

    public static /* synthetic */ Object readFully$default(ByteReadChannel byteReadChannel, byte[] bArr, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return readFully(byteReadChannel, bArr, i, i2, continuation);
    }

    @InternalAPI
    public static final void rethrowCloseCauseIfNeeded(ByteReadChannel $this$rethrowCloseCauseIfNeeded) {
        Intrinsics.checkNotNullParameter($this$rethrowCloseCauseIfNeeded, "<this>");
        Throwable it = $this$rethrowCloseCauseIfNeeded.getClosedCause();
        if (it != null) {
            throw it;
        }
    }

    @InternalAPI
    public static final void rethrowCloseCauseIfNeeded(ByteWriteChannel $this$rethrowCloseCauseIfNeeded) {
        Intrinsics.checkNotNullParameter($this$rethrowCloseCauseIfNeeded, "<this>");
        Throwable it = $this$rethrowCloseCauseIfNeeded.getClosedCause();
        if (it != null) {
            throw it;
        }
    }

    @InternalAPI
    public static final void rethrowCloseCauseIfNeeded(ByteChannel $this$rethrowCloseCauseIfNeeded) {
        Intrinsics.checkNotNullParameter($this$rethrowCloseCauseIfNeeded, "<this>");
        Throwable it = $this$rethrowCloseCauseIfNeeded.getClosedCause();
        if (it != null) {
            throw it;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x015a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0256 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x018f -> B:50:0x01ee). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x01bf -> B:49:0x01cc). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readUntil(ByteReadChannel byteReadChannel, ByteString byteString, ByteWriteChannel byteWriteChannel, long j, boolean z, Continuation<? super Long> continuation) {
        ByteReadChannelOperationsKt$readUntil$1 byteReadChannelOperationsKt$readUntil$1;
        ByteReadChannel $this$readUntil;
        ByteWriteChannel writeChannel;
        ByteString matchString;
        long limit;
        boolean ignoreMissing;
        int[] partialMatchTable;
        Ref.IntRef matchIndex;
        byte[] matchBuffer;
        Ref.LongRef rc;
        ByteString matchString2;
        int[] partialMatchTable2;
        byte[] matchBuffer2;
        Object $result;
        Object obj;
        boolean ignoreMissing2;
        ByteReadChannel $this$readUntil2;
        ByteWriteChannel writeChannel2;
        Ref.LongRef rc2;
        byte b;
        byte b2;
        boolean ignoreMissing3;
        long limit2;
        Ref.LongRef rc3;
        byte[] matchBuffer3;
        Ref.IntRef matchIndex2;
        int[] partialMatchTable3;
        ByteWriteChannel writeChannel3;
        ByteString matchString3;
        ByteReadChannel $this$readUntil3;
        Continuation $completion;
        Ref.LongRef rc4;
        Object obj2;
        Ref.LongRef rc5;
        Continuation $completion2 = continuation;
        if ($completion2 instanceof ByteReadChannelOperationsKt$readUntil$1) {
            byteReadChannelOperationsKt$readUntil$1 = (ByteReadChannelOperationsKt$readUntil$1) $completion2;
            if ((byteReadChannelOperationsKt$readUntil$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$readUntil$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result2 = byteReadChannelOperationsKt$readUntil$1.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = 1;
                switch (byteReadChannelOperationsKt$readUntil$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        $this$readUntil = byteReadChannel;
                        writeChannel = byteWriteChannel;
                        matchString = byteString;
                        limit = j;
                        ignoreMissing = z;
                        if (!(matchString.getSize() > 0)) {
                            throw new IllegalStateException("Empty match string not permitted for readUntil".toString());
                        }
                        partialMatchTable = buildPartialMatchTable(matchString);
                        matchIndex = new Ref.IntRef();
                        matchBuffer = new byte[matchString.getSize()];
                        rc = new Ref.LongRef();
                        if ($this$readUntil.isClosedForRead()) {
                            byteReadChannelOperationsKt$readUntil$1.L$0 = $this$readUntil;
                            byteReadChannelOperationsKt$readUntil$1.L$1 = matchString;
                            byteReadChannelOperationsKt$readUntil$1.L$2 = writeChannel;
                            byteReadChannelOperationsKt$readUntil$1.L$3 = partialMatchTable;
                            byteReadChannelOperationsKt$readUntil$1.L$4 = matchIndex;
                            byteReadChannelOperationsKt$readUntil$1.L$5 = matchBuffer;
                            byteReadChannelOperationsKt$readUntil$1.L$6 = rc;
                            byteReadChannelOperationsKt$readUntil$1.J$0 = limit;
                            byteReadChannelOperationsKt$readUntil$1.Z$0 = ignoreMissing;
                            byteReadChannelOperationsKt$readUntil$1.label = i;
                            Object readByte = readByte($this$readUntil, byteReadChannelOperationsKt$readUntil$1);
                            if (readByte == $result3) {
                                return $result3;
                            }
                            Object obj3 = $result3;
                            $result = $result2;
                            $result2 = readByte;
                            matchString2 = matchString;
                            ignoreMissing2 = ignoreMissing;
                            rc2 = rc;
                            writeChannel2 = writeChannel;
                            $this$readUntil2 = $this$readUntil;
                            obj = obj3;
                            byte[] bArr = matchBuffer;
                            partialMatchTable2 = partialMatchTable;
                            matchBuffer2 = bArr;
                            b2 = ((Number) $result2).byteValue();
                            if (matchIndex.element > 0 && b2 != matchString2.get(matchIndex.element)) {
                                byteReadChannelOperationsKt$readUntil$1.L$0 = $this$readUntil2;
                                byteReadChannelOperationsKt$readUntil$1.L$1 = matchString2;
                                byteReadChannelOperationsKt$readUntil$1.L$2 = writeChannel2;
                                byteReadChannelOperationsKt$readUntil$1.L$3 = partialMatchTable2;
                                byteReadChannelOperationsKt$readUntil$1.L$4 = matchIndex;
                                byteReadChannelOperationsKt$readUntil$1.L$5 = matchBuffer2;
                                byteReadChannelOperationsKt$readUntil$1.L$6 = rc2;
                                byteReadChannelOperationsKt$readUntil$1.J$0 = limit;
                                byteReadChannelOperationsKt$readUntil$1.Z$0 = ignoreMissing2;
                                byteReadChannelOperationsKt$readUntil$1.B$0 = b2;
                                byteReadChannelOperationsKt$readUntil$1.label = 2;
                                if (readUntil$appendPartialMatch(writeChannel2, matchBuffer2, matchIndex, rc2, byteReadChannelOperationsKt$readUntil$1) != obj) {
                                    return obj;
                                }
                                Object obj4 = obj;
                                b = b2;
                                $result2 = $result;
                                $result3 = obj4;
                                readUntil$resetPartialMatch(matchIndex, matchString2, partialMatchTable2, b);
                                Object obj5 = $result3;
                                $result = $result2;
                                b2 = b;
                                obj = obj5;
                            }
                            if (b2 == matchString2.get(matchIndex.element)) {
                                Continuation $completion3 = $completion2;
                                matchBuffer2[matchIndex.element] = b2;
                                matchIndex.element++;
                                if (matchIndex.element == matchString2.getSize()) {
                                    return Boxing.boxLong(rc2.element);
                                }
                                $completion = $completion3;
                                $result2 = $result;
                                $result3 = obj;
                                $this$readUntil = $this$readUntil2;
                                writeChannel = writeChannel2;
                                rc = rc2;
                                ignoreMissing = ignoreMissing2;
                                matchString = matchString2;
                                int[] iArr = partialMatchTable2;
                                matchBuffer = matchBuffer2;
                                partialMatchTable = iArr;
                                Continuation $completion4 = $completion;
                                ByteReadChannelOperationsKt$readUntil$1 byteReadChannelOperationsKt$readUntil$12 = byteReadChannelOperationsKt$readUntil$1;
                                if (rc.element > limit) {
                                    throw new IOException("Limit of " + limit + " bytes exceeded while scanning for \"" + ByteStringKt.decodeToString(matchString) + '\"');
                                }
                                $completion2 = $completion4;
                                byteReadChannelOperationsKt$readUntil$1 = byteReadChannelOperationsKt$readUntil$12;
                                i = 1;
                                if ($this$readUntil.isClosedForRead()) {
                                    if (ignoreMissing) {
                                        byteReadChannelOperationsKt$readUntil$1.L$0 = writeChannel;
                                        byteReadChannelOperationsKt$readUntil$1.L$1 = rc;
                                        rc4 = null;
                                        byteReadChannelOperationsKt$readUntil$1.L$2 = null;
                                        byteReadChannelOperationsKt$readUntil$1.L$3 = null;
                                        byteReadChannelOperationsKt$readUntil$1.L$4 = null;
                                        byteReadChannelOperationsKt$readUntil$1.L$5 = null;
                                        byteReadChannelOperationsKt$readUntil$1.L$6 = null;
                                        byteReadChannelOperationsKt$readUntil$1.label = 4;
                                        if (readUntil$appendPartialMatch(writeChannel, matchBuffer, matchIndex, rc, byteReadChannelOperationsKt$readUntil$1) == $result3) {
                                            return $result3;
                                        }
                                        obj2 = $result3;
                                        rc5 = rc;
                                        byteReadChannelOperationsKt$readUntil$1.L$0 = rc5;
                                        byteReadChannelOperationsKt$readUntil$1.L$1 = rc4;
                                        byteReadChannelOperationsKt$readUntil$1.label = 5;
                                        if (writeChannel.flush(byteReadChannelOperationsKt$readUntil$1) == obj2) {
                                            return obj2;
                                        }
                                        return Boxing.boxLong(rc5.element);
                                    }
                                    throw new IOException("Expected \"" + toSingleLineString(matchString) + "\" but encountered end of input");
                                }
                            } else {
                                Continuation $completion5 = $completion2;
                                byteReadChannelOperationsKt$readUntil$1.L$0 = $this$readUntil2;
                                byteReadChannelOperationsKt$readUntil$1.L$1 = matchString2;
                                byteReadChannelOperationsKt$readUntil$1.L$2 = writeChannel2;
                                byteReadChannelOperationsKt$readUntil$1.L$3 = partialMatchTable2;
                                byteReadChannelOperationsKt$readUntil$1.L$4 = matchIndex;
                                byteReadChannelOperationsKt$readUntil$1.L$5 = matchBuffer2;
                                byteReadChannelOperationsKt$readUntil$1.L$6 = rc2;
                                byteReadChannelOperationsKt$readUntil$1.J$0 = limit;
                                byteReadChannelOperationsKt$readUntil$1.Z$0 = ignoreMissing2;
                                byteReadChannelOperationsKt$readUntil$1.label = 3;
                                if (ByteWriteChannelOperationsKt.writeByte(writeChannel2, b2, byteReadChannelOperationsKt$readUntil$1) == obj) {
                                    return obj;
                                }
                                $completion2 = $completion5;
                                $result2 = $result;
                                $result3 = obj;
                                ignoreMissing3 = ignoreMissing2;
                                limit2 = limit;
                                rc3 = rc2;
                                matchBuffer3 = matchBuffer2;
                                matchIndex2 = matchIndex;
                                partialMatchTable3 = partialMatchTable2;
                                writeChannel3 = writeChannel2;
                                matchString3 = matchString2;
                                $this$readUntil3 = $this$readUntil2;
                                long j2 = rc3.element;
                                rc3.element = j2 + 1;
                                Boxing.boxLong(j2);
                                $completion = $completion2;
                                byteReadChannelOperationsKt$readUntil$1 = byteReadChannelOperationsKt$readUntil$1;
                                writeChannel = writeChannel3;
                                matchBuffer = matchBuffer3;
                                ignoreMissing = ignoreMissing3;
                                $this$readUntil = $this$readUntil3;
                                ByteString byteString2 = matchString3;
                                rc = rc3;
                                limit = limit2;
                                matchString = byteString2;
                                int[] iArr2 = partialMatchTable3;
                                matchIndex = matchIndex2;
                                partialMatchTable = iArr2;
                                Continuation $completion42 = $completion;
                                ByteReadChannelOperationsKt$readUntil$1 byteReadChannelOperationsKt$readUntil$122 = byteReadChannelOperationsKt$readUntil$1;
                                if (rc.element > limit) {
                                }
                            }
                        }
                        break;
                    case 1:
                        boolean ignoreMissing4 = byteReadChannelOperationsKt$readUntil$1.Z$0;
                        long limit3 = byteReadChannelOperationsKt$readUntil$1.J$0;
                        Ref.LongRef rc6 = (Ref.LongRef) byteReadChannelOperationsKt$readUntil$1.L$6;
                        byte[] matchBuffer4 = (byte[]) byteReadChannelOperationsKt$readUntil$1.L$5;
                        Ref.IntRef matchIndex3 = (Ref.IntRef) byteReadChannelOperationsKt$readUntil$1.L$4;
                        int[] partialMatchTable4 = (int[]) byteReadChannelOperationsKt$readUntil$1.L$3;
                        ByteWriteChannel writeChannel4 = (ByteWriteChannel) byteReadChannelOperationsKt$readUntil$1.L$2;
                        ByteReadChannel $this$readUntil4 = (ByteReadChannel) byteReadChannelOperationsKt$readUntil$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        matchString2 = (ByteString) byteReadChannelOperationsKt$readUntil$1.L$1;
                        partialMatchTable2 = partialMatchTable4;
                        matchBuffer2 = matchBuffer4;
                        $result = $result2;
                        obj = $result3;
                        ignoreMissing2 = ignoreMissing4;
                        $this$readUntil2 = $this$readUntil4;
                        writeChannel2 = writeChannel4;
                        matchIndex = matchIndex3;
                        rc2 = rc6;
                        limit = limit3;
                        b2 = ((Number) $result2).byteValue();
                        if (matchIndex.element > 0) {
                            byteReadChannelOperationsKt$readUntil$1.L$0 = $this$readUntil2;
                            byteReadChannelOperationsKt$readUntil$1.L$1 = matchString2;
                            byteReadChannelOperationsKt$readUntil$1.L$2 = writeChannel2;
                            byteReadChannelOperationsKt$readUntil$1.L$3 = partialMatchTable2;
                            byteReadChannelOperationsKt$readUntil$1.L$4 = matchIndex;
                            byteReadChannelOperationsKt$readUntil$1.L$5 = matchBuffer2;
                            byteReadChannelOperationsKt$readUntil$1.L$6 = rc2;
                            byteReadChannelOperationsKt$readUntil$1.J$0 = limit;
                            byteReadChannelOperationsKt$readUntil$1.Z$0 = ignoreMissing2;
                            byteReadChannelOperationsKt$readUntil$1.B$0 = b2;
                            byteReadChannelOperationsKt$readUntil$1.label = 2;
                            if (readUntil$appendPartialMatch(writeChannel2, matchBuffer2, matchIndex, rc2, byteReadChannelOperationsKt$readUntil$1) != obj) {
                            }
                            break;
                        }
                        if (b2 == matchString2.get(matchIndex.element)) {
                        }
                        break;
                    case 2:
                        b = byteReadChannelOperationsKt$readUntil$1.B$0;
                        ignoreMissing2 = byteReadChannelOperationsKt$readUntil$1.Z$0;
                        limit = byteReadChannelOperationsKt$readUntil$1.J$0;
                        rc2 = (Ref.LongRef) byteReadChannelOperationsKt$readUntil$1.L$6;
                        matchBuffer2 = (byte[]) byteReadChannelOperationsKt$readUntil$1.L$5;
                        matchIndex = (Ref.IntRef) byteReadChannelOperationsKt$readUntil$1.L$4;
                        partialMatchTable2 = (int[]) byteReadChannelOperationsKt$readUntil$1.L$3;
                        writeChannel2 = (ByteWriteChannel) byteReadChannelOperationsKt$readUntil$1.L$2;
                        matchString2 = (ByteString) byteReadChannelOperationsKt$readUntil$1.L$1;
                        $this$readUntil2 = (ByteReadChannel) byteReadChannelOperationsKt$readUntil$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        readUntil$resetPartialMatch(matchIndex, matchString2, partialMatchTable2, b);
                        Object obj52 = $result3;
                        $result = $result2;
                        b2 = b;
                        obj = obj52;
                        if (b2 == matchString2.get(matchIndex.element)) {
                        }
                        break;
                    case 3:
                        ignoreMissing3 = byteReadChannelOperationsKt$readUntil$1.Z$0;
                        limit2 = byteReadChannelOperationsKt$readUntil$1.J$0;
                        rc3 = (Ref.LongRef) byteReadChannelOperationsKt$readUntil$1.L$6;
                        matchBuffer3 = (byte[]) byteReadChannelOperationsKt$readUntil$1.L$5;
                        matchIndex2 = (Ref.IntRef) byteReadChannelOperationsKt$readUntil$1.L$4;
                        partialMatchTable3 = (int[]) byteReadChannelOperationsKt$readUntil$1.L$3;
                        writeChannel3 = (ByteWriteChannel) byteReadChannelOperationsKt$readUntil$1.L$2;
                        matchString3 = (ByteString) byteReadChannelOperationsKt$readUntil$1.L$1;
                        $this$readUntil3 = (ByteReadChannel) byteReadChannelOperationsKt$readUntil$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        long j22 = rc3.element;
                        rc3.element = j22 + 1;
                        Boxing.boxLong(j22);
                        $completion = $completion2;
                        byteReadChannelOperationsKt$readUntil$1 = byteReadChannelOperationsKt$readUntil$1;
                        writeChannel = writeChannel3;
                        matchBuffer = matchBuffer3;
                        ignoreMissing = ignoreMissing3;
                        $this$readUntil = $this$readUntil3;
                        ByteString byteString22 = matchString3;
                        rc = rc3;
                        limit = limit2;
                        matchString = byteString22;
                        int[] iArr22 = partialMatchTable3;
                        matchIndex = matchIndex2;
                        partialMatchTable = iArr22;
                        Continuation $completion422 = $completion;
                        ByteReadChannelOperationsKt$readUntil$1 byteReadChannelOperationsKt$readUntil$1222 = byteReadChannelOperationsKt$readUntil$1;
                        if (rc.element > limit) {
                        }
                        break;
                    case 4:
                        Ref.LongRef rc7 = (Ref.LongRef) byteReadChannelOperationsKt$readUntil$1.L$1;
                        ByteWriteChannel writeChannel5 = (ByteWriteChannel) byteReadChannelOperationsKt$readUntil$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        writeChannel = writeChannel5;
                        obj2 = $result3;
                        rc5 = rc7;
                        rc4 = null;
                        byteReadChannelOperationsKt$readUntil$1.L$0 = rc5;
                        byteReadChannelOperationsKt$readUntil$1.L$1 = rc4;
                        byteReadChannelOperationsKt$readUntil$1.label = 5;
                        if (writeChannel.flush(byteReadChannelOperationsKt$readUntil$1) == obj2) {
                        }
                        return Boxing.boxLong(rc5.element);
                    case 5:
                        rc5 = (Ref.LongRef) byteReadChannelOperationsKt$readUntil$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        return Boxing.boxLong(rc5.element);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        byteReadChannelOperationsKt$readUntil$1 = new ByteReadChannelOperationsKt$readUntil$1($completion2);
        Object $result22 = byteReadChannelOperationsKt$readUntil$1.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = 1;
        switch (byteReadChannelOperationsKt$readUntil$1.label) {
        }
    }

    public static /* synthetic */ Object readUntil$default(ByteReadChannel byteReadChannel, ByteString byteString, ByteWriteChannel byteWriteChannel, long j, boolean z, Continuation continuation, int i, Object obj) {
        long j2;
        boolean z2;
        if ((i & 4) == 0) {
            j2 = j;
        } else {
            j2 = Long.MAX_VALUE;
        }
        if ((i & 8) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        return readUntil(byteReadChannel, byteString, byteWriteChannel, j2, z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readUntil$appendPartialMatch(ByteWriteChannel $writeChannel, byte[] matchBuffer, Ref.IntRef matchIndex, Ref.LongRef rc, Continuation<? super Unit> continuation) {
        ByteReadChannelOperationsKt$readUntil$appendPartialMatch$1 byteReadChannelOperationsKt$readUntil$appendPartialMatch$1;
        Ref.IntRef matchIndex2;
        Ref.LongRef rc2;
        if (continuation instanceof ByteReadChannelOperationsKt$readUntil$appendPartialMatch$1) {
            byteReadChannelOperationsKt$readUntil$appendPartialMatch$1 = (ByteReadChannelOperationsKt$readUntil$appendPartialMatch$1) continuation;
            if ((byteReadChannelOperationsKt$readUntil$appendPartialMatch$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$readUntil$appendPartialMatch$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$readUntil$appendPartialMatch$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$readUntil$appendPartialMatch$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        int i = matchIndex.element;
                        byteReadChannelOperationsKt$readUntil$appendPartialMatch$1.L$0 = matchIndex;
                        byteReadChannelOperationsKt$readUntil$appendPartialMatch$1.L$1 = rc;
                        byteReadChannelOperationsKt$readUntil$appendPartialMatch$1.label = 1;
                        if (ByteWriteChannelOperationsKt.writeFully($writeChannel, matchBuffer, 0, i, byteReadChannelOperationsKt$readUntil$appendPartialMatch$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        matchIndex2 = matchIndex;
                        rc2 = rc;
                        break;
                    case 1:
                        rc2 = (Ref.LongRef) byteReadChannelOperationsKt$readUntil$appendPartialMatch$1.L$1;
                        matchIndex2 = (Ref.IntRef) byteReadChannelOperationsKt$readUntil$appendPartialMatch$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                rc2.element += matchIndex2.element;
                matchIndex2.element = 0;
                return Unit.INSTANCE;
            }
        }
        byteReadChannelOperationsKt$readUntil$appendPartialMatch$1 = new ByteReadChannelOperationsKt$readUntil$appendPartialMatch$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$readUntil$appendPartialMatch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$readUntil$appendPartialMatch$1.label) {
        }
        rc2.element += matchIndex2.element;
        matchIndex2.element = 0;
        return Unit.INSTANCE;
    }

    private static final void readUntil$resetPartialMatch(Ref.IntRef matchIndex, ByteString $matchString, int[] partialMatchTable, byte b) {
        while (matchIndex.element > 0 && b != $matchString.get(matchIndex.element)) {
            matchIndex.element = partialMatchTable[matchIndex.element - 1];
        }
    }

    private static final int[] buildPartialMatchTable(ByteString byteString) {
        int[] table = new int[byteString.getSize()];
        int j = 0;
        int size = byteString.getSize();
        for (int i = 1; i < size; i++) {
            while (j > 0 && byteString.get(i) != byteString.get(j)) {
                j = table[j - 1];
            }
            if (byteString.get(i) == byteString.get(j)) {
                j++;
            }
            table[i] = j;
        }
        return table;
    }

    private static final String toSingleLineString(ByteString $this$toSingleLineString) {
        return StringsKt.replace$default(ByteStringKt.decodeToString($this$toSingleLineString), "\n", "\\n", false, 4, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object skipIfFound(ByteReadChannel $this$skipIfFound, ByteString byteString, Continuation<? super Boolean> continuation) {
        ByteReadChannelOperationsKt$skipIfFound$1 byteReadChannelOperationsKt$skipIfFound$1;
        Object peek;
        ByteReadChannel $this$skipIfFound2;
        ByteString byteString2;
        if (continuation instanceof ByteReadChannelOperationsKt$skipIfFound$1) {
            byteReadChannelOperationsKt$skipIfFound$1 = (ByteReadChannelOperationsKt$skipIfFound$1) continuation;
            if ((byteReadChannelOperationsKt$skipIfFound$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$skipIfFound$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$skipIfFound$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$skipIfFound$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        int size = byteString.getSize();
                        byteReadChannelOperationsKt$skipIfFound$1.L$0 = $this$skipIfFound;
                        byteReadChannelOperationsKt$skipIfFound$1.L$1 = byteString;
                        byteReadChannelOperationsKt$skipIfFound$1.label = 1;
                        peek = peek($this$skipIfFound, size, byteReadChannelOperationsKt$skipIfFound$1);
                        if (peek == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$skipIfFound2 = $this$skipIfFound;
                        byteString2 = byteString;
                        if (!Intrinsics.areEqual(peek, byteString2)) {
                            byteReadChannelOperationsKt$skipIfFound$1.L$0 = null;
                            byteReadChannelOperationsKt$skipIfFound$1.L$1 = null;
                            byteReadChannelOperationsKt$skipIfFound$1.label = 2;
                            if (discard($this$skipIfFound2, byteString2.getSize(), byteReadChannelOperationsKt$skipIfFound$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Boxing.boxBoolean(true);
                        }
                        return Boxing.boxBoolean(false);
                    case 1:
                        byteString2 = (ByteString) byteReadChannelOperationsKt$skipIfFound$1.L$1;
                        $this$skipIfFound2 = (ByteReadChannel) byteReadChannelOperationsKt$skipIfFound$1.L$0;
                        ResultKt.throwOnFailure($result);
                        peek = $result;
                        if (!Intrinsics.areEqual(peek, byteString2)) {
                        }
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return Boxing.boxBoolean(true);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        byteReadChannelOperationsKt$skipIfFound$1 = new ByteReadChannelOperationsKt$skipIfFound$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$skipIfFound$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$skipIfFound$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object peek(ByteReadChannel $this$peek, int count, Continuation<? super ByteString> continuation) {
        ByteReadChannelOperationsKt$peek$1 byteReadChannelOperationsKt$peek$1;
        Object awaitContent;
        ByteReadChannel $this$peek2;
        int count2;
        if (continuation instanceof ByteReadChannelOperationsKt$peek$1) {
            byteReadChannelOperationsKt$peek$1 = (ByteReadChannelOperationsKt$peek$1) continuation;
            if ((byteReadChannelOperationsKt$peek$1.label & LynxAccessibilityDelegate.INVALID_NODE_ID) != 0) {
                byteReadChannelOperationsKt$peek$1.label -= LynxAccessibilityDelegate.INVALID_NODE_ID;
                Object $result = byteReadChannelOperationsKt$peek$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (byteReadChannelOperationsKt$peek$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!$this$peek.isClosedForRead()) {
                            byteReadChannelOperationsKt$peek$1.L$0 = $this$peek;
                            byteReadChannelOperationsKt$peek$1.I$0 = count;
                            byteReadChannelOperationsKt$peek$1.label = 1;
                            awaitContent = $this$peek.awaitContent(count, byteReadChannelOperationsKt$peek$1);
                            if (awaitContent == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$peek2 = $this$peek;
                            count2 = count;
                            break;
                        } else {
                            return null;
                        }
                    case 1:
                        count2 = byteReadChannelOperationsKt$peek$1.I$0;
                        $this$peek2 = (ByteReadChannel) byteReadChannelOperationsKt$peek$1.L$0;
                        ResultKt.throwOnFailure($result);
                        awaitContent = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((Boolean) awaitContent).booleanValue()) {
                    return null;
                }
                return ByteStringsKt.readByteString($this$peek2.mo1388getReadBuffer().peek(), count2);
            }
        }
        byteReadChannelOperationsKt$peek$1 = new ByteReadChannelOperationsKt$peek$1(continuation);
        Object $result2 = byteReadChannelOperationsKt$peek$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (byteReadChannelOperationsKt$peek$1.label) {
        }
        if (((Boolean) awaitContent).booleanValue()) {
        }
    }
}