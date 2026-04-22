package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.PropsConstants;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.SegmentKt;
import kotlinx.io.SinksJvmKt;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* compiled from: ByteWriteChannelOperations.jvm.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0006\u0010\u0005\u001aA\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00030\tH\u0086@¢\u0006\u0004\b\u000e\u0010\u000f\u001a/\u0010\u0010\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0019\u0010\u0010\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "Ljava/nio/ByteBuffer;", "value", "", "writeByteBuffer", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFully", "", "min", "Lkotlin/Function1;", "Lkotlin/ParameterName;", PropsConstants.NAME, "buffer", "block", "write", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeAvailable", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/jvm/functions/Function1;)I", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/ByteBuffer;)V", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ByteWriteChannelOperations_jvmKt {
    public static final Object writeByteBuffer(ByteWriteChannel $this$writeByteBuffer, ByteBuffer value, Continuation<? super Unit> continuation) {
        OutputArraysJVMKt.writeByteBuffer($this$writeByteBuffer.getWriteBuffer(), value);
        Object flush = $this$writeByteBuffer.flush(continuation);
        return flush == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flush : Unit.INSTANCE;
    }

    public static final Object writeFully(ByteWriteChannel $this$writeFully, ByteBuffer value, Continuation<? super Unit> continuation) {
        OutputArraysJVMKt.writeByteBuffer($this$writeFully.getWriteBuffer(), value);
        Object flush = $this$writeFully.flush(continuation);
        return flush == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flush : Unit.INSTANCE;
    }

    public static /* synthetic */ Object write$default(ByteWriteChannel byteWriteChannel, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return write(byteWriteChannel, i, function1, continuation);
    }

    public static final Object write(ByteWriteChannel $this$write, int min, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        Buffer buffer$iv = $this$write.getWriteBuffer().getBuffer();
        Segment tail$iv = buffer$iv.writableSegment(min);
        boolean z = false;
        byte[] data$iv = tail$iv.dataAsByteArray(false);
        int startIndex = tail$iv.getLimit();
        int endIndex = data$iv.length;
        ByteBuffer buffer = ByteBuffer.wrap(data$iv, startIndex, endIndex - startIndex);
        Intrinsics.checkNotNull(buffer);
        function1.invoke(buffer);
        int bytesWritten$iv = buffer.position() - startIndex;
        if (bytesWritten$iv == min) {
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
        Object flush = $this$write.flush(continuation);
        return flush == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flush : Unit.INSTANCE;
    }

    public static /* synthetic */ int writeAvailable$default(ByteWriteChannel byteWriteChannel, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return writeAvailable(byteWriteChannel, i, function1);
    }

    public static final int writeAvailable(ByteWriteChannel $this$writeAvailable, int min, Function1<? super ByteBuffer, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$writeAvailable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        boolean z = true;
        if (min > 0) {
            if (!(min <= 1048576)) {
                throw new IllegalArgumentException(("Min(" + min + ") shouldn't be greater than 1048576").toString());
            }
            if ($this$writeAvailable.isClosedForWrite()) {
                return -1;
            }
            UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
            Buffer buffer$iv = $this$writeAvailable.getWriteBuffer().getBuffer();
            Segment tail$iv = buffer$iv.writableSegment(min);
            byte[] data$iv = tail$iv.dataAsByteArray(false);
            int startIndex = tail$iv.getLimit();
            int endIndex = data$iv.length;
            ByteBuffer buffer = ByteBuffer.wrap(data$iv, startIndex, endIndex - startIndex);
            Intrinsics.checkNotNull(buffer);
            function1.invoke(buffer);
            int result = buffer.position() - startIndex;
            int result2 = buffer.position();
            int bytesWritten$iv = result2 - startIndex;
            if (bytesWritten$iv == min) {
                tail$iv.writeBackData(data$iv, bytesWritten$iv);
                tail$iv.setLimit(tail$iv.getLimit() + bytesWritten$iv);
                buffer$iv.setSizeMut(buffer$iv.getSizeMut() + bytesWritten$iv);
            } else {
                if (bytesWritten$iv < 0 || bytesWritten$iv > tail$iv.getRemainingCapacity()) {
                    z = false;
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
            return result;
        }
        throw new IllegalArgumentException("min should be positive".toString());
    }

    public static final void writeAvailable(ByteWriteChannel $this$writeAvailable, ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter($this$writeAvailable, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        SinksJvmKt.write($this$writeAvailable.getWriteBuffer(), buffer);
    }
}