package io.ktor.utils.io.core;

import com.lynx.tasm.behavior.PropertyIDConstants;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.Sink;
import kotlinx.io.SinksJvmKt;
import kotlinx.io.Source;
import kotlinx.io.SourcesJvmKt;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* compiled from: ByteReadPacketExtensions.jvm.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\u000e\u001a\u00020\t*\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ljava/nio/ByteBuffer;", "byteBuffer", "Lkotlinx/io/Source;", "ByteReadPacket", "(Ljava/nio/ByteBuffer;)Lkotlinx/io/Source;", "buffer", "", "readAvailable", "(Lkotlinx/io/Source;Ljava/nio/ByteBuffer;)I", "", "readFully", "(Lkotlinx/io/Source;Ljava/nio/ByteBuffer;)V", "Lkotlin/Function1;", "block", "read", "(Lkotlinx/io/Source;Lkotlin/jvm/functions/Function1;)V", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class ByteReadPacketExtensions_jvmKt {
    public static final Source ByteReadPacket(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
        Source buffer = new Buffer();
        SinksJvmKt.write((Sink) buffer, byteBuffer);
        return buffer;
    }

    public static final int readAvailable(Source $this$readAvailable, ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter($this$readAvailable, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int result = buffer.remaining();
        SourcesJvmKt.readAtMostTo($this$readAvailable, buffer);
        return result - buffer.remaining();
    }

    public static final void readFully(Source $this$readFully, ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter($this$readFully, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        while (!$this$readFully.exhausted() && buffer.hasRemaining()) {
            SourcesJvmKt.readAtMostTo($this$readFully, buffer);
        }
    }

    public static final void read(Source $this$read, Function1<? super ByteBuffer, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$read, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        Buffer buffer$iv = $this$read.getBuffer();
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