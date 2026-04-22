package io.ktor.utils.io.streams;

import com.lynx.tasm.behavior.PropertyIDConstants;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.BuffersJvmKt;
import kotlinx.io.CoreKt;
import kotlinx.io.JvmCoreKt;
import kotlinx.io.Segment;
import kotlinx.io.SegmentKt;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.SourcesJvmKt;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* compiled from: Streams.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\n\u001a\u00020\t*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a*\u0010\n\u001a\u00020\t*\u00020\u00072\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\u000e¢\u0006\u0004\b\n\u0010\u0010\u001a\u001b\u0010\u0013\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Ljava/io/InputStream;", "Lkotlinx/io/Source;", "Lio/ktor/utils/io/core/Input;", "asInput", "(Ljava/io/InputStream;)Lkotlinx/io/Source;", "inputStream", "(Lkotlinx/io/Source;)Ljava/io/InputStream;", "Ljava/io/OutputStream;", "packet", "", "writePacket", "(Ljava/io/OutputStream;Lkotlinx/io/Source;)V", "Lkotlin/Function1;", "Lkotlinx/io/Sink;", "Lkotlin/ExtensionFunctionType;", "block", "(Ljava/io/OutputStream;Lkotlin/jvm/functions/Function1;)V", "", "min", "readPacketAtLeast", "(Ljava/io/InputStream;I)Lkotlinx/io/Source;", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
public final class StreamsKt {
    public static final Source asInput(InputStream $this$asInput) {
        Intrinsics.checkNotNullParameter($this$asInput, "<this>");
        return CoreKt.buffered(JvmCoreKt.asSource($this$asInput));
    }

    public static final InputStream inputStream(Source $this$inputStream) {
        Intrinsics.checkNotNullParameter($this$inputStream, "<this>");
        return SourcesJvmKt.asInputStream($this$inputStream);
    }

    public static final void writePacket(OutputStream $this$writePacket, Source packet) {
        Intrinsics.checkNotNullParameter($this$writePacket, "<this>");
        Intrinsics.checkNotNullParameter(packet, "packet");
        BuffersJvmKt.copyTo$default(packet.getBuffer(), $this$writePacket, 0L, 0L, 6, (Object) null);
    }

    public static final void writePacket(OutputStream $this$writePacket, Function1<? super Sink, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$writePacket, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        Source buffer = new Buffer();
        function1.invoke(buffer);
        writePacket($this$writePacket, buffer);
    }

    public static /* synthetic */ Source readPacketAtLeast$default(InputStream inputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return readPacketAtLeast(inputStream, i);
    }

    public static final Source readPacketAtLeast(InputStream $this$readPacketAtLeast, int min) {
        Intrinsics.checkNotNullParameter($this$readPacketAtLeast, "<this>");
        Source buffer = new Buffer();
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        Segment tail$iv = buffer.writableSegment(min);
        boolean z = false;
        byte[] data$iv = tail$iv.dataAsByteArray(false);
        int start = tail$iv.getLimit();
        int end = data$iv.length;
        int read = $this$readPacketAtLeast.read(data$iv, start, end - start);
        if (read < 0) {
            read = 0;
        }
        int start2 = read;
        if (start2 == min) {
            tail$iv.writeBackData(data$iv, start2);
            tail$iv.setLimit(tail$iv.getLimit() + start2);
            buffer.setSizeMut(buffer.getSizeMut() + start2);
        } else {
            if (start2 >= 0 && start2 <= tail$iv.getRemainingCapacity()) {
                z = true;
            }
            if (!z) {
                throw new IllegalStateException(("Invalid number of bytes written: " + start2 + ". Should be in 0.." + tail$iv.getRemainingCapacity()).toString());
            }
            if (start2 != 0) {
                tail$iv.writeBackData(data$iv, start2);
                tail$iv.setLimit(tail$iv.getLimit() + start2);
                buffer.setSizeMut(buffer.getSizeMut() + start2);
            } else if (SegmentKt.isEmpty(tail$iv)) {
                buffer.recycleTail();
            }
        }
        return buffer;
    }
}