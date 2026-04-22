package io.ktor.utils.io.jvm.nio;

import com.lynx.tasm.behavior.PropertyIDConstants;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.RawSource;
import kotlinx.io.Segment;
import kotlinx.io.SegmentKt;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* compiled from: Reading.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0012\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/utils/io/jvm/nio/ReadableByteChannelSource;", "Lkotlinx/io/RawSource;", "Ljava/nio/channels/ReadableByteChannel;", "channel", "<init>", "(Ljava/nio/channels/ReadableByteChannel;)V", "Lkotlinx/io/Buffer;", "sink", "", "byteCount", "readAtMostTo", "(Lkotlinx/io/Buffer;J)J", "", "close", "()V", "", "toString", "()Ljava/lang/String;", "Ljava/nio/channels/ReadableByteChannel;", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
class ReadableByteChannelSource implements RawSource {
    private final ReadableByteChannel channel;

    public ReadableByteChannelSource(ReadableByteChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
    }

    public long readAtMostTo(Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount <= 0) {
            return 0L;
        }
        int actualByteCount = (int) Math.min(byteCount, 2147483647L);
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        Segment tail$iv = sink.writableSegment(1);
        byte[] data$iv = tail$iv.dataAsByteArray(false);
        int pos = tail$iv.getLimit();
        int limit = data$iv.length;
        int maxToCopy = Math.min(actualByteCount, limit - pos);
        ByteBuffer buffer = ByteBuffer.wrap(data$iv, pos, maxToCopy);
        int readTotal = this.channel.read(buffer);
        int readTotal2 = 0;
        int bytesWritten$iv = Math.max(readTotal, 0);
        if (bytesWritten$iv == 1) {
            tail$iv.writeBackData(data$iv, bytesWritten$iv);
            tail$iv.setLimit(tail$iv.getLimit() + bytesWritten$iv);
            sink.setSizeMut(sink.getSizeMut() + bytesWritten$iv);
        } else {
            if (bytesWritten$iv >= 0 && bytesWritten$iv <= tail$iv.getRemainingCapacity()) {
                readTotal2 = 1;
            }
            if (readTotal2 == 0) {
                throw new IllegalStateException(("Invalid number of bytes written: " + bytesWritten$iv + ". Should be in 0.." + tail$iv.getRemainingCapacity()).toString());
            }
            if (bytesWritten$iv != 0) {
                tail$iv.writeBackData(data$iv, bytesWritten$iv);
                tail$iv.setLimit(tail$iv.getLimit() + bytesWritten$iv);
                sink.setSizeMut(sink.getSizeMut() + bytesWritten$iv);
            } else if (SegmentKt.isEmpty(tail$iv)) {
                sink.recycleTail();
            }
        }
        return readTotal;
    }

    public void close() {
        this.channel.close();
    }

    public String toString() {
        return "ReadableByteChannelSource(" + this.channel + ')';
    }
}