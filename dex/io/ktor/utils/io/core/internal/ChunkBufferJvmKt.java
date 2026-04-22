package io.ktor.utils.io.core.internal;

import com.lynx.tasm.behavior.PropertyIDConstants;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.SegmentKt;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* compiled from: ChunkBufferJvm.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a-\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\t\u001a\u00020\u0005*\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlinx/io/Buffer;", "", "min", "Lkotlin/Function1;", "Ljava/nio/ByteBuffer;", "", "block", "writeDirect", "(Lkotlinx/io/Buffer;ILkotlin/jvm/functions/Function1;)V", "readDirect", "(Lkotlinx/io/Buffer;Lkotlin/jvm/functions/Function1;)V", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ChunkBufferJvmKt {
    public static final void writeDirect(Buffer $this$writeDirect, int min, Function1<? super ByteBuffer, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$writeDirect, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        Buffer buffer$iv = $this$writeDirect.getBuffer();
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
            return;
        }
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
        } else if (!SegmentKt.isEmpty(tail$iv)) {
        } else {
            buffer$iv.recycleTail();
        }
    }

    public static final void readDirect(Buffer $this$readDirect, Function1<? super ByteBuffer, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$readDirect, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        Buffer buffer$iv = $this$readDirect.getBuffer();
        if (buffer$iv.exhausted()) {
            throw new IllegalArgumentException("Buffer is empty".toString());
        }
        Segment head$iv = buffer$iv.getHead();
        Intrinsics.checkNotNull(head$iv);
        byte[] array = head$iv.dataAsByteArray(true);
        int start = head$iv.getPos();
        int endExclusive = head$iv.getLimit();
        ByteBuffer wrap = ByteBuffer.wrap(array, start, endExclusive - start);
        Intrinsics.checkNotNull(wrap);
        function1.invoke(wrap);
        int consumed = wrap.position() - start;
        if (consumed == 0) {
            return;
        }
        if (consumed >= 0) {
            if (consumed > head$iv.getSize()) {
                throw new IllegalStateException("Returned too many bytes");
            }
            buffer$iv.skip(consumed);
            return;
        }
        throw new IllegalStateException("Returned negative read bytes count");
    }
}