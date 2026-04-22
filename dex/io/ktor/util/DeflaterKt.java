package io.ktor.util;

import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteReadChannelOperations_jvmKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperations_jvmKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* compiled from: Deflater.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001b\u0010\t\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0014\u0010\f\u001a\u00020\u0003*\u00020\u000bH\u0082@¢\u0006\u0004\b\f\u0010\r\u001a$\u0010\u0010\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0000H\u0082@¢\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0015\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016\u001a6\u0010\u0004\u001a\u00020\u0003*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u00132\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001aH\u0082@¢\u0006\u0004\b\u0004\u0010\u001c\u001a5\u0010\u001f\u001a\u00020\u0017*\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00132\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 \u001a5\u0010\u001f\u001a\u00020\u000b*\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u00132\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010!\"\u0014\u0010#\u001a\u00020\"8\u0000X\u0080T¢\u0006\u0006\n\u0004\b#\u0010$\"\u001a\u0010&\u001a\u00020%8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Ljava/util/zip/Deflater;", "Ljava/nio/ByteBuffer;", "outBuffer", "", "deflateTo", "(Ljava/util/zip/Deflater;Ljava/nio/ByteBuffer;)V", "buffer", "setInputBuffer", "Ljava/util/zip/Checksum;", "updateKeepPosition", "(Ljava/util/zip/Checksum;Ljava/nio/ByteBuffer;)V", "Lio/ktor/utils/io/ByteWriteChannel;", "putGzipHeader", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "crc", "deflater", "putGzipTrailer", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/util/zip/Checksum;Ljava/util/zip/Deflater;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function0;", "", "predicate", "deflateWhile", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/util/zip/Deflater;Ljava/nio/ByteBuffer;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "destination", "gzip", "Lio/ktor/utils/io/pool/ObjectPool;", "pool", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;ZLio/ktor/utils/io/pool/ObjectPool;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "deflated", "(Lio/ktor/utils/io/ByteReadChannel;ZLio/ktor/utils/io/pool/ObjectPool;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteReadChannel;", "(Lio/ktor/utils/io/ByteWriteChannel;ZLio/ktor/utils/io/pool/ObjectPool;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteWriteChannel;", "", "GZIP_MAGIC", "S", "", "GZIP_HEADER_PADDING", "[B", "getGZIP_HEADER_PADDING", "()[B", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DeflaterKt {
    private static final byte[] GZIP_HEADER_PADDING = new byte[7];
    public static final short GZIP_MAGIC = -29921;

    public static final byte[] getGZIP_HEADER_PADDING() {
        return GZIP_HEADER_PADDING;
    }

    private static final void deflateTo(Deflater $this$deflateTo, ByteBuffer outBuffer) {
        if (outBuffer.hasRemaining()) {
            int written = $this$deflateTo.deflate(outBuffer.array(), outBuffer.arrayOffset() + outBuffer.position(), outBuffer.remaining());
            outBuffer.position(outBuffer.position() + written);
        }
    }

    private static final void setInputBuffer(Deflater $this$setInputBuffer, ByteBuffer buffer) {
        if (!buffer.hasArray()) {
            throw new IllegalArgumentException("buffer need to be array-backed".toString());
        }
        $this$setInputBuffer.setInput(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());
    }

    public static final void updateKeepPosition(Checksum $this$updateKeepPosition, ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter($this$updateKeepPosition, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (!buffer.hasArray()) {
            throw new IllegalArgumentException("buffer need to be array-backed".toString());
        }
        $this$updateKeepPosition.update(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object putGzipHeader(ByteWriteChannel $this$putGzipHeader, Continuation<? super Unit> continuation) {
        DeflaterKt$putGzipHeader$1 deflaterKt$putGzipHeader$1;
        byte[] bArr;
        if (continuation instanceof DeflaterKt$putGzipHeader$1) {
            deflaterKt$putGzipHeader$1 = (DeflaterKt$putGzipHeader$1) continuation;
            if ((deflaterKt$putGzipHeader$1.label & Integer.MIN_VALUE) != 0) {
                deflaterKt$putGzipHeader$1.label -= Integer.MIN_VALUE;
                Object $result = deflaterKt$putGzipHeader$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (deflaterKt$putGzipHeader$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        short $this$reverseByteOrder$iv = Short.reverseBytes((short) (-29921));
                        deflaterKt$putGzipHeader$1.L$0 = $this$putGzipHeader;
                        deflaterKt$putGzipHeader$1.label = 1;
                        if (ByteWriteChannelOperationsKt.writeShort($this$putGzipHeader, $this$reverseByteOrder$iv, deflaterKt$putGzipHeader$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        deflaterKt$putGzipHeader$1.L$0 = $this$putGzipHeader;
                        deflaterKt$putGzipHeader$1.label = 2;
                        if (ByteWriteChannelOperationsKt.writeByte($this$putGzipHeader, (byte) 8, deflaterKt$putGzipHeader$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        bArr = GZIP_HEADER_PADDING;
                        deflaterKt$putGzipHeader$1.L$0 = null;
                        deflaterKt$putGzipHeader$1.label = 3;
                        if (ByteWriteChannelOperationsKt.writeFully$default($this$putGzipHeader, bArr, 0, 0, deflaterKt$putGzipHeader$1, 6, (Object) null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        $this$putGzipHeader = (ByteWriteChannel) deflaterKt$putGzipHeader$1.L$0;
                        ResultKt.throwOnFailure($result);
                        deflaterKt$putGzipHeader$1.L$0 = $this$putGzipHeader;
                        deflaterKt$putGzipHeader$1.label = 2;
                        if (ByteWriteChannelOperationsKt.writeByte($this$putGzipHeader, (byte) 8, deflaterKt$putGzipHeader$1) == coroutine_suspended) {
                        }
                        bArr = GZIP_HEADER_PADDING;
                        deflaterKt$putGzipHeader$1.L$0 = null;
                        deflaterKt$putGzipHeader$1.label = 3;
                        if (ByteWriteChannelOperationsKt.writeFully$default($this$putGzipHeader, bArr, 0, 0, deflaterKt$putGzipHeader$1, 6, (Object) null) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        $this$putGzipHeader = (ByteWriteChannel) deflaterKt$putGzipHeader$1.L$0;
                        ResultKt.throwOnFailure($result);
                        bArr = GZIP_HEADER_PADDING;
                        deflaterKt$putGzipHeader$1.L$0 = null;
                        deflaterKt$putGzipHeader$1.label = 3;
                        if (ByteWriteChannelOperationsKt.writeFully$default($this$putGzipHeader, bArr, 0, 0, deflaterKt$putGzipHeader$1, 6, (Object) null) == coroutine_suspended) {
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
        deflaterKt$putGzipHeader$1 = new DeflaterKt$putGzipHeader$1(continuation);
        Object $result2 = deflaterKt$putGzipHeader$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (deflaterKt$putGzipHeader$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object putGzipTrailer(ByteWriteChannel $this$putGzipTrailer, Checksum crc, Deflater deflater, Continuation<? super Unit> continuation) {
        DeflaterKt$putGzipTrailer$1 deflaterKt$putGzipTrailer$1;
        ByteWriteChannel $this$putGzipTrailer2;
        Deflater deflater2;
        int $this$reverseByteOrder$iv;
        if (continuation instanceof DeflaterKt$putGzipTrailer$1) {
            deflaterKt$putGzipTrailer$1 = (DeflaterKt$putGzipTrailer$1) continuation;
            if ((deflaterKt$putGzipTrailer$1.label & Integer.MIN_VALUE) != 0) {
                deflaterKt$putGzipTrailer$1.label -= Integer.MIN_VALUE;
                Object $result = deflaterKt$putGzipTrailer$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (deflaterKt$putGzipTrailer$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        int $this$reverseByteOrder$iv2 = (int) crc.getValue();
                        int $this$reverseByteOrder$iv3 = Integer.reverseBytes($this$reverseByteOrder$iv2);
                        deflaterKt$putGzipTrailer$1.L$0 = $this$putGzipTrailer;
                        deflaterKt$putGzipTrailer$1.L$1 = deflater;
                        deflaterKt$putGzipTrailer$1.label = 1;
                        if (ByteWriteChannelOperationsKt.writeInt($this$putGzipTrailer, $this$reverseByteOrder$iv3, deflaterKt$putGzipTrailer$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$putGzipTrailer2 = $this$putGzipTrailer;
                        deflater2 = deflater;
                        int $this$reverseByteOrder$iv4 = deflater2.getTotalIn();
                        $this$reverseByteOrder$iv = Integer.reverseBytes($this$reverseByteOrder$iv4);
                        deflaterKt$putGzipTrailer$1.L$0 = null;
                        deflaterKt$putGzipTrailer$1.L$1 = null;
                        deflaterKt$putGzipTrailer$1.label = 2;
                        if (ByteWriteChannelOperationsKt.writeInt($this$putGzipTrailer2, $this$reverseByteOrder$iv, deflaterKt$putGzipTrailer$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        deflater2 = (Deflater) deflaterKt$putGzipTrailer$1.L$1;
                        $this$putGzipTrailer2 = (ByteWriteChannel) deflaterKt$putGzipTrailer$1.L$0;
                        ResultKt.throwOnFailure($result);
                        int $this$reverseByteOrder$iv42 = deflater2.getTotalIn();
                        $this$reverseByteOrder$iv = Integer.reverseBytes($this$reverseByteOrder$iv42);
                        deflaterKt$putGzipTrailer$1.L$0 = null;
                        deflaterKt$putGzipTrailer$1.L$1 = null;
                        deflaterKt$putGzipTrailer$1.label = 2;
                        if (ByteWriteChannelOperationsKt.writeInt($this$putGzipTrailer2, $this$reverseByteOrder$iv, deflaterKt$putGzipTrailer$1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        deflaterKt$putGzipTrailer$1 = new DeflaterKt$putGzipTrailer$1(continuation);
        Object $result2 = deflaterKt$putGzipTrailer$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (deflaterKt$putGzipTrailer$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object deflateWhile(ByteWriteChannel $this$deflateWhile, Deflater deflater, ByteBuffer buffer, Function0<Boolean> function0, Continuation<? super Unit> continuation) {
        DeflaterKt$deflateWhile$1 deflaterKt$deflateWhile$1;
        ByteWriteChannel $this$deflateWhile2;
        Function0 predicate;
        Deflater deflater2;
        ByteBuffer buffer2;
        if (continuation instanceof DeflaterKt$deflateWhile$1) {
            deflaterKt$deflateWhile$1 = (DeflaterKt$deflateWhile$1) continuation;
            if ((deflaterKt$deflateWhile$1.label & Integer.MIN_VALUE) != 0) {
                deflaterKt$deflateWhile$1.label -= Integer.MIN_VALUE;
                Object $result = deflaterKt$deflateWhile$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (deflaterKt$deflateWhile$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$deflateWhile2 = $this$deflateWhile;
                        predicate = function0;
                        deflater2 = deflater;
                        buffer2 = buffer;
                        break;
                    case 1:
                        predicate = (Function0) deflaterKt$deflateWhile$1.L$3;
                        buffer2 = (ByteBuffer) deflaterKt$deflateWhile$1.L$2;
                        deflater2 = (Deflater) deflaterKt$deflateWhile$1.L$1;
                        $this$deflateWhile2 = (ByteWriteChannel) deflaterKt$deflateWhile$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (((Boolean) predicate.invoke()).booleanValue()) {
                    buffer2.clear();
                    deflateTo(deflater2, buffer2);
                    buffer2.flip();
                    deflaterKt$deflateWhile$1.L$0 = $this$deflateWhile2;
                    deflaterKt$deflateWhile$1.L$1 = deflater2;
                    deflaterKt$deflateWhile$1.L$2 = buffer2;
                    deflaterKt$deflateWhile$1.L$3 = predicate;
                    deflaterKt$deflateWhile$1.label = 1;
                    if (ByteWriteChannelOperations_jvmKt.writeFully($this$deflateWhile2, buffer2, deflaterKt$deflateWhile$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        deflaterKt$deflateWhile$1 = new DeflaterKt$deflateWhile$1(continuation);
        Object $result2 = deflaterKt$deflateWhile$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (deflaterKt$deflateWhile$1.label) {
        }
        while (((Boolean) predicate.invoke()).booleanValue()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00d6: MOVE  (r14 I:??[OBJECT, ARRAY] A[D('deflater' java.util.zip.Deflater)]) = (r5 I:??[OBJECT, ARRAY] A[D('pool' io.ktor.utils.io.pool.ObjectPool)]), block:B:30:0x00d3 */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0128 A[Catch: all -> 0x00d2, TRY_LEAVE, TryCatch #0 {all -> 0x00d2, blocks: (B:18:0x005f, B:63:0x01c0, B:21:0x0082, B:41:0x0122, B:43:0x0128, B:57:0x0196, B:59:0x019c, B:71:0x01f2, B:24:0x00a5, B:27:0x00ce), top: B:74:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0155 A[Catch: all -> 0x018e, TRY_LEAVE, TryCatch #3 {all -> 0x018e, blocks: (B:47:0x014d, B:49:0x0155), top: B:79:0x014d }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0196 A[Catch: all -> 0x00d2, TRY_ENTER, TryCatch #0 {all -> 0x00d2, blocks: (B:18:0x005f, B:63:0x01c0, B:21:0x0082, B:41:0x0122, B:43:0x0128, B:57:0x0196, B:59:0x019c, B:71:0x01f2, B:24:0x00a5, B:27:0x00ce), top: B:74:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c0 A[Catch: all -> 0x00d2, TRY_LEAVE, TryCatch #0 {all -> 0x00d2, blocks: (B:18:0x005f, B:63:0x01c0, B:21:0x0082, B:41:0x0122, B:43:0x0128, B:57:0x0196, B:59:0x019c, B:71:0x01f2, B:24:0x00a5, B:27:0x00ce), top: B:74:0x0022 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0180 -> B:41:0x0122). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0187 -> B:41:0x0122). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object deflateTo(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, boolean z, ObjectPool<ByteBuffer> objectPool, Continuation<? super Unit> continuation) {
        DeflaterKt$deflateTo$1 deflaterKt$deflateTo$1;
        ByteWriteChannel byteWriteChannel2;
        ByteBuffer input;
        ObjectPool<ByteBuffer> objectPool2;
        ObjectPool<ByteBuffer> objectPool3;
        ByteReadChannel $this$deflateTo;
        boolean gzip;
        ByteWriteChannel destination;
        CRC32 crc;
        ObjectPool<ByteBuffer> objectPool4;
        final ObjectPool<ByteBuffer> objectPool5;
        ByteBuffer input2;
        ByteWriteChannel byteWriteChannel3;
        ByteReadChannel $this$deflateTo2;
        ByteWriteChannel destination2;
        ObjectPool<ByteBuffer> objectPool6;
        CRC32 crc2;
        Object obj;
        Object $result;
        try {
            if (continuation instanceof DeflaterKt$deflateTo$1) {
                deflaterKt$deflateTo$1 = (DeflaterKt$deflateTo$1) continuation;
                if ((deflaterKt$deflateTo$1.label & Integer.MIN_VALUE) != 0) {
                    deflaterKt$deflateTo$1.label -= Integer.MIN_VALUE;
                    Object $result2 = deflaterKt$deflateTo$1.result;
                    Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (deflaterKt$deflateTo$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result2);
                            $this$deflateTo = byteReadChannel;
                            gzip = z;
                            destination = byteWriteChannel;
                            crc = new CRC32();
                            objectPool2 = new Deflater<>(-1, true);
                            input = (ByteBuffer) objectPool.borrow();
                            ByteWriteChannel byteWriteChannel4 = (ByteBuffer) objectPool.borrow();
                            if (gzip) {
                                try {
                                    deflaterKt$deflateTo$1.L$0 = $this$deflateTo;
                                    deflaterKt$deflateTo$1.L$1 = destination;
                                    deflaterKt$deflateTo$1.L$2 = objectPool;
                                    deflaterKt$deflateTo$1.L$3 = crc;
                                    deflaterKt$deflateTo$1.L$4 = objectPool2;
                                    deflaterKt$deflateTo$1.L$5 = input;
                                    deflaterKt$deflateTo$1.L$6 = byteWriteChannel4;
                                    deflaterKt$deflateTo$1.Z$0 = gzip;
                                    deflaterKt$deflateTo$1.label = 1;
                                    if (putGzipHeader(destination, deflaterKt$deflateTo$1) == $result3) {
                                        return $result3;
                                    }
                                    objectPool4 = objectPool;
                                    objectPool5 = objectPool2;
                                    input2 = input;
                                    byteWriteChannel3 = byteWriteChannel4;
                                } catch (Throwable th) {
                                    it = th;
                                    byteWriteChannel2 = byteWriteChannel4;
                                    objectPool2.end();
                                    objectPool.recycle(input);
                                    objectPool.recycle(byteWriteChannel2);
                                    throw it;
                                }
                            } else {
                                objectPool4 = objectPool;
                                objectPool5 = objectPool2;
                                input2 = input;
                                byteWriteChannel3 = byteWriteChannel4;
                            }
                            if (!$this$deflateTo.isClosedForRead()) {
                                input2.clear();
                                deflaterKt$deflateTo$1.L$0 = $this$deflateTo;
                                deflaterKt$deflateTo$1.L$1 = destination;
                                deflaterKt$deflateTo$1.L$2 = objectPool4;
                                deflaterKt$deflateTo$1.L$3 = crc;
                                deflaterKt$deflateTo$1.L$4 = objectPool5;
                                deflaterKt$deflateTo$1.L$5 = input2;
                                deflaterKt$deflateTo$1.L$6 = byteWriteChannel3;
                                deflaterKt$deflateTo$1.Z$0 = gzip;
                                deflaterKt$deflateTo$1.label = 2;
                                Object readAvailable = ByteReadChannelOperations_jvmKt.readAvailable($this$deflateTo, input2, deflaterKt$deflateTo$1);
                                if (readAvailable == $result3) {
                                    return $result3;
                                }
                                Object obj2 = $result3;
                                $result = $result2;
                                $result2 = readAvailable;
                                $this$deflateTo2 = $this$deflateTo;
                                destination2 = destination;
                                objectPool6 = objectPool4;
                                crc2 = crc;
                                obj = obj2;
                                try {
                                    if (((Number) $result2).intValue() <= 0) {
                                        input2.flip();
                                        updateKeepPosition(crc2, input2);
                                        setInputBuffer(objectPool5, input2);
                                        Function0 function0 = new Function0() { // from class: io.ktor.util.DeflaterKt$$ExternalSyntheticLambda0
                                            public final Object invoke() {
                                                boolean deflateTo$lambda$2;
                                                deflateTo$lambda$2 = DeflaterKt.deflateTo$lambda$2(objectPool5);
                                                return Boolean.valueOf(deflateTo$lambda$2);
                                            }
                                        };
                                        deflaterKt$deflateTo$1.L$0 = $this$deflateTo2;
                                        deflaterKt$deflateTo$1.L$1 = destination2;
                                        deflaterKt$deflateTo$1.L$2 = objectPool6;
                                        deflaterKt$deflateTo$1.L$3 = crc2;
                                        deflaterKt$deflateTo$1.L$4 = objectPool5;
                                        deflaterKt$deflateTo$1.L$5 = input2;
                                        deflaterKt$deflateTo$1.L$6 = byteWriteChannel3;
                                        deflaterKt$deflateTo$1.Z$0 = gzip;
                                        deflaterKt$deflateTo$1.label = 3;
                                        if (deflateWhile(destination2, objectPool5, byteWriteChannel3, function0, deflaterKt$deflateTo$1) == obj) {
                                            return obj;
                                        }
                                        $result2 = $result;
                                        $result3 = obj;
                                        crc = crc2;
                                        objectPool4 = objectPool6;
                                        destination = destination2;
                                        $this$deflateTo = $this$deflateTo2;
                                    } else {
                                        $result2 = $result;
                                        $result3 = obj;
                                        crc = crc2;
                                        objectPool4 = objectPool6;
                                        destination = destination2;
                                        $this$deflateTo = $this$deflateTo2;
                                    }
                                    if (!$this$deflateTo.isClosedForRead()) {
                                        Throwable it = $this$deflateTo.getClosedCause();
                                        if (it == null) {
                                            objectPool5.finish();
                                            Function0 function02 = new Function0() { // from class: io.ktor.util.DeflaterKt$$ExternalSyntheticLambda1
                                                public final Object invoke() {
                                                    boolean deflateTo$lambda$4;
                                                    deflateTo$lambda$4 = DeflaterKt.deflateTo$lambda$4(objectPool5);
                                                    return Boolean.valueOf(deflateTo$lambda$4);
                                                }
                                            };
                                            deflaterKt$deflateTo$1.L$0 = destination;
                                            deflaterKt$deflateTo$1.L$1 = objectPool4;
                                            deflaterKt$deflateTo$1.L$2 = crc;
                                            deflaterKt$deflateTo$1.L$3 = objectPool5;
                                            deflaterKt$deflateTo$1.L$4 = input2;
                                            deflaterKt$deflateTo$1.L$5 = byteWriteChannel3;
                                            deflaterKt$deflateTo$1.L$6 = null;
                                            deflaterKt$deflateTo$1.Z$0 = gzip;
                                            deflaterKt$deflateTo$1.label = 4;
                                            if (deflateWhile(destination, objectPool5, byteWriteChannel3, function02, deflaterKt$deflateTo$1) == $result3) {
                                                return $result3;
                                            }
                                            if (gzip) {
                                                deflaterKt$deflateTo$1.L$0 = objectPool4;
                                                deflaterKt$deflateTo$1.L$1 = objectPool5;
                                                deflaterKt$deflateTo$1.L$2 = input2;
                                                deflaterKt$deflateTo$1.L$3 = byteWriteChannel3;
                                                deflaterKt$deflateTo$1.L$4 = null;
                                                deflaterKt$deflateTo$1.L$5 = null;
                                                deflaterKt$deflateTo$1.label = 5;
                                                if (putGzipTrailer(destination, crc, objectPool5, deflaterKt$deflateTo$1) == $result3) {
                                                    return $result3;
                                                }
                                                byteWriteChannel2 = byteWriteChannel3;
                                                input = input2;
                                                objectPool2 = objectPool5;
                                                objectPool = objectPool4;
                                                objectPool4 = objectPool;
                                                objectPool5 = objectPool2;
                                                input2 = input;
                                                byteWriteChannel3 = byteWriteChannel2;
                                            }
                                            objectPool5.end();
                                            objectPool4.recycle(input2);
                                            objectPool4.recycle(byteWriteChannel3);
                                            return Unit.INSTANCE;
                                        }
                                        throw it;
                                    }
                                } catch (Throwable th2) {
                                    it = th2;
                                    byteWriteChannel2 = byteWriteChannel3;
                                    input = input2;
                                    objectPool2 = objectPool5;
                                    objectPool = objectPool6;
                                    objectPool2.end();
                                    objectPool.recycle(input);
                                    objectPool.recycle(byteWriteChannel2);
                                    throw it;
                                }
                            }
                        case 1:
                            gzip = deflaterKt$deflateTo$1.Z$0;
                            byteWriteChannel3 = (ByteBuffer) deflaterKt$deflateTo$1.L$6;
                            input2 = (ByteBuffer) deflaterKt$deflateTo$1.L$5;
                            objectPool5 = (Deflater) deflaterKt$deflateTo$1.L$4;
                            crc = (CRC32) deflaterKt$deflateTo$1.L$3;
                            objectPool4 = (ObjectPool) deflaterKt$deflateTo$1.L$2;
                            destination = (ByteWriteChannel) deflaterKt$deflateTo$1.L$1;
                            $this$deflateTo = (ByteReadChannel) deflaterKt$deflateTo$1.L$0;
                            ResultKt.throwOnFailure($result2);
                            if (!$this$deflateTo.isClosedForRead()) {
                            }
                            break;
                        case 2:
                            gzip = deflaterKt$deflateTo$1.Z$0;
                            byteWriteChannel3 = (ByteBuffer) deflaterKt$deflateTo$1.L$6;
                            input2 = (ByteBuffer) deflaterKt$deflateTo$1.L$5;
                            objectPool5 = (Deflater) deflaterKt$deflateTo$1.L$4;
                            CRC32 crc3 = (CRC32) deflaterKt$deflateTo$1.L$3;
                            ObjectPool<ByteBuffer> objectPool7 = (ObjectPool) deflaterKt$deflateTo$1.L$2;
                            ByteWriteChannel destination3 = (ByteWriteChannel) deflaterKt$deflateTo$1.L$1;
                            ByteReadChannel $this$deflateTo3 = (ByteReadChannel) deflaterKt$deflateTo$1.L$0;
                            ResultKt.throwOnFailure($result2);
                            $this$deflateTo2 = $this$deflateTo3;
                            destination2 = destination3;
                            objectPool6 = objectPool7;
                            crc2 = crc3;
                            obj = $result3;
                            $result = $result2;
                            if (((Number) $result2).intValue() <= 0) {
                            }
                            if (!$this$deflateTo.isClosedForRead()) {
                            }
                            break;
                        case 3:
                            gzip = deflaterKt$deflateTo$1.Z$0;
                            byteWriteChannel3 = (ByteBuffer) deflaterKt$deflateTo$1.L$6;
                            input2 = (ByteBuffer) deflaterKt$deflateTo$1.L$5;
                            objectPool5 = (Deflater) deflaterKt$deflateTo$1.L$4;
                            crc = (CRC32) deflaterKt$deflateTo$1.L$3;
                            objectPool4 = (ObjectPool) deflaterKt$deflateTo$1.L$2;
                            destination = (ByteWriteChannel) deflaterKt$deflateTo$1.L$1;
                            $this$deflateTo = (ByteReadChannel) deflaterKt$deflateTo$1.L$0;
                            ResultKt.throwOnFailure($result2);
                            if (!$this$deflateTo.isClosedForRead()) {
                            }
                            break;
                        case 4:
                            gzip = deflaterKt$deflateTo$1.Z$0;
                            byteWriteChannel3 = (ByteBuffer) deflaterKt$deflateTo$1.L$5;
                            input2 = (ByteBuffer) deflaterKt$deflateTo$1.L$4;
                            objectPool5 = (Deflater) deflaterKt$deflateTo$1.L$3;
                            crc = (CRC32) deflaterKt$deflateTo$1.L$2;
                            objectPool4 = (ObjectPool) deflaterKt$deflateTo$1.L$1;
                            destination = (ByteWriteChannel) deflaterKt$deflateTo$1.L$0;
                            ResultKt.throwOnFailure($result2);
                            if (gzip) {
                            }
                            objectPool5.end();
                            objectPool4.recycle(input2);
                            objectPool4.recycle(byteWriteChannel3);
                            return Unit.INSTANCE;
                        case 5:
                            byteWriteChannel2 = (ByteBuffer) deflaterKt$deflateTo$1.L$3;
                            input = (ByteBuffer) deflaterKt$deflateTo$1.L$2;
                            objectPool2 = (Deflater) deflaterKt$deflateTo$1.L$1;
                            objectPool = (ObjectPool) deflaterKt$deflateTo$1.L$0;
                            try {
                                ResultKt.throwOnFailure($result2);
                                objectPool4 = objectPool;
                                objectPool5 = objectPool2;
                                input2 = input;
                                byteWriteChannel3 = byteWriteChannel2;
                                objectPool5.end();
                                objectPool4.recycle(input2);
                                objectPool4.recycle(byteWriteChannel3);
                                return Unit.INSTANCE;
                            } catch (Throwable th3) {
                                it = th3;
                                objectPool2.end();
                                objectPool.recycle(input);
                                objectPool.recycle(byteWriteChannel2);
                                throw it;
                            }
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (deflaterKt$deflateTo$1.label) {
            }
        } catch (Throwable th4) {
            it = th4;
            byteWriteChannel2 = byteWriteChannel;
            input = z;
            objectPool2 = objectPool;
            objectPool = objectPool3;
        }
        deflaterKt$deflateTo$1 = new DeflaterKt$deflateTo$1(continuation);
        Object $result22 = deflaterKt$deflateTo$1.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    static /* synthetic */ Object deflateTo$default(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, boolean z, ObjectPool objectPool, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            objectPool = ByteBufferPoolKt.getKtorDefaultPool();
        }
        return deflateTo(byteReadChannel, byteWriteChannel, z, objectPool, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deflateTo$lambda$2(Deflater $deflater) {
        return !$deflater.needsInput();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deflateTo$lambda$4(Deflater $deflater) {
        return !$deflater.finished();
    }

    public static /* synthetic */ ByteReadChannel deflated$default(ByteReadChannel byteReadChannel, boolean z, ObjectPool objectPool, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            objectPool = ByteBufferPoolKt.getKtorDefaultPool();
        }
        if ((i & 4) != 0) {
            coroutineContext = (CoroutineContext) Dispatchers.getUnconfined();
        }
        return deflated(byteReadChannel, z, objectPool, coroutineContext);
    }

    public static final ByteReadChannel deflated(ByteReadChannel $this$deflated, boolean gzip, ObjectPool<ByteBuffer> objectPool, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter($this$deflated, "<this>");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return ByteWriteChannelOperationsKt.writer(GlobalScope.INSTANCE, coroutineContext, true, new DeflaterKt$deflated$1($this$deflated, gzip, objectPool, null)).getChannel();
    }

    public static /* synthetic */ ByteWriteChannel deflated$default(ByteWriteChannel byteWriteChannel, boolean z, ObjectPool objectPool, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            objectPool = ByteBufferPoolKt.getKtorDefaultPool();
        }
        if ((i & 4) != 0) {
            coroutineContext = (CoroutineContext) Dispatchers.getUnconfined();
        }
        return deflated(byteWriteChannel, z, objectPool, coroutineContext);
    }

    public static final ByteWriteChannel deflated(ByteWriteChannel $this$deflated, boolean gzip, ObjectPool<ByteBuffer> objectPool, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter($this$deflated, "<this>");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return ByteReadChannelOperationsKt.reader(GlobalScope.INSTANCE, coroutineContext, true, new DeflaterKt$deflated$2($this$deflated, gzip, objectPool, null)).getChannel();
    }
}