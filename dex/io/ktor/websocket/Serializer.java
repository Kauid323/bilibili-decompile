package io.ktor.websocket;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.util.NIOKt;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: Serializer.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\t*\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u001cR\u0011\u0010,\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b+\u0010)R\u0011\u0010/\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"Lio/ktor/websocket/Serializer;", Column.INVAL_VALUE, "<init>", "()V", "Lio/ktor/websocket/Frame;", "f", Column.INVAL_VALUE, "enqueue", "(Lio/ktor/websocket/Frame;)V", "Ljava/nio/ByteBuffer;", "buffer", "serialize", "(Ljava/nio/ByteBuffer;)V", "frame", Column.INVAL_VALUE, "mask", "serializeHeader", "(Lio/ktor/websocket/Frame;Ljava/nio/ByteBuffer;Z)V", Column.INVAL_VALUE, "estimateFrameHeaderSize", "(Lio/ktor/websocket/Frame;Z)I", "writeCurrentPayload", "(Ljava/nio/ByteBuffer;)Z", "maskSize", "(Z)I", "maskedIfNeeded", "(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;", "setMaskBuffer", "(Z)V", "Ljava/util/concurrent/ArrayBlockingQueue;", "messages", "Ljava/util/concurrent/ArrayBlockingQueue;", "frameBody", "Ljava/nio/ByteBuffer;", "maskBuffer", "Lio/ktor/websocket/FrameType;", "lastDataFrameType", "Lio/ktor/websocket/FrameType;", "masking", "Z", "getMasking", "()Z", "setMasking", "getHasOutstandingBytes", "hasOutstandingBytes", "getRemainingCapacity", "()I", "remainingCapacity", "ktor-websockets"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Serializer {
    private ByteBuffer frameBody;
    private FrameType lastDataFrameType;
    private ByteBuffer maskBuffer;
    private boolean masking;
    private final ArrayBlockingQueue<Frame> messages = new ArrayBlockingQueue<>(1024);

    public final boolean getMasking() {
        return this.masking;
    }

    public final void setMasking(boolean z) {
        this.masking = z;
    }

    public final boolean getHasOutstandingBytes() {
        return (this.messages.isEmpty() && this.frameBody == null) ? false : true;
    }

    public final int getRemainingCapacity() {
        return this.messages.remainingCapacity();
    }

    public final void enqueue(Frame f) {
        Intrinsics.checkNotNullParameter(f, "f");
        this.messages.put(f);
    }

    public final void serialize(ByteBuffer buffer) {
        Frame frame;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        while (writeCurrentPayload(buffer) && (frame = this.messages.peek()) != null) {
            boolean mask = this.masking;
            setMaskBuffer(mask);
            int headerSize = estimateFrameHeaderSize(frame, mask);
            if (buffer.remaining() >= headerSize) {
                serializeHeader(frame, buffer, mask);
                this.messages.remove();
                this.frameBody = maskedIfNeeded(frame.getBuffer());
            } else {
                return;
            }
        }
    }

    private final void serializeHeader(Frame frame, ByteBuffer buffer, boolean mask) {
        int continuationOpcode;
        ByteBuffer duplicate;
        int size = frame.getBuffer().remaining();
        int formattedLength = 126;
        if (size < 126) {
            formattedLength = size;
        } else if (size > 65535) {
            formattedLength = 127;
        }
        FrameType frameType = this.lastDataFrameType;
        if (frameType == null) {
            if (!frame.getFin()) {
                this.lastDataFrameType = frame.getFrameType();
            }
            continuationOpcode = frame.getFrameType().getOpcode();
        } else if (frameType == frame.getFrameType()) {
            if (frame.getFin()) {
                this.lastDataFrameType = null;
            }
            continuationOpcode = 0;
        } else if (!frame.getFrameType().getControlFrame()) {
            throw new IllegalStateException("Can't continue with different data frame opcode");
        } else {
            continuationOpcode = frame.getFrameType().getOpcode();
        }
        boolean $this$flagAt$iv = frame.getFin();
        int i = $this$flagAt$iv ? 1 << 7 : 0;
        boolean $this$flagAt$iv2 = frame.getRsv1();
        int i2 = i | ($this$flagAt$iv2 ? 1 << 6 : 0);
        boolean $this$flagAt$iv3 = frame.getRsv2();
        int i3 = i2 | ($this$flagAt$iv3 ? 1 << 5 : 0);
        boolean $this$flagAt$iv4 = frame.getRsv3();
        int header = i3 | ($this$flagAt$iv4 ? 1 << 4 : 0) | continuationOpcode;
        buffer.put((byte) header);
        int at$iv = (mask ? 1 << 7 : 0) | formattedLength;
        buffer.put((byte) at$iv);
        switch (formattedLength) {
            case 126:
                buffer.putShort((short) frame.getBuffer().remaining());
                break;
            case 127:
                buffer.putLong(frame.getBuffer().remaining());
                break;
        }
        ByteBuffer byteBuffer = this.maskBuffer;
        if (byteBuffer == null || (duplicate = byteBuffer.duplicate()) == null) {
            return;
        }
        NIOKt.moveTo$default(duplicate, buffer, 0, 2, (Object) null);
    }

    private final int estimateFrameHeaderSize(Frame f, boolean mask) {
        int i;
        int size = f.getBuffer().remaining();
        if (size < 126) {
            i = 2;
        } else {
            i = size <= 32767 ? 4 : 10;
        }
        return i + maskSize(mask);
    }

    private final boolean writeCurrentPayload(ByteBuffer buffer) {
        ByteBuffer frame = this.frameBody;
        if (frame == null) {
            return true;
        }
        NIOKt.moveTo$default(frame, buffer, 0, 2, (Object) null);
        if (frame.hasRemaining()) {
            return false;
        }
        this.frameBody = null;
        return true;
    }

    private final int maskSize(boolean mask) {
        return mask ? 4 : 0;
    }

    private final ByteBuffer maskedIfNeeded(ByteBuffer $this$maskedIfNeeded) {
        ByteBuffer mask = this.maskBuffer;
        if (mask != null) {
            ByteBuffer $this$maskedIfNeeded_u24lambda_u241_u24lambda_u240 = NIOKt.copy$default($this$maskedIfNeeded, 0, 1, (Object) null);
            UtilsKt.xor($this$maskedIfNeeded_u24lambda_u241_u24lambda_u240, mask);
            if ($this$maskedIfNeeded_u24lambda_u241_u24lambda_u240 != null) {
                return $this$maskedIfNeeded_u24lambda_u241_u24lambda_u240;
            }
        }
        return $this$maskedIfNeeded;
    }

    private final void setMaskBuffer(boolean mask) {
        ByteBuffer $this$setMaskBuffer_u24lambda_u242;
        if (mask) {
            $this$setMaskBuffer_u24lambda_u242 = ByteBuffer.allocate(4);
            $this$setMaskBuffer_u24lambda_u242.putInt(Random.Default.nextInt());
            $this$setMaskBuffer_u24lambda_u242.clear();
        } else {
            $this$setMaskBuffer_u24lambda_u242 = null;
        }
        this.maskBuffer = $this$setMaskBuffer_u24lambda_u242;
    }
}