package io.ktor.websocket.internals;

import com.bilibili.doraemonkit.widget.tableview.bean.Column;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.core.BytePacketBuilderExtensions_jvmKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;

/* compiled from: DeflaterUtils.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a+\u0010\u000f\u001a\u00020\u000e*\u00020\b2\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\"\u0014\u0010\u0011\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Ljava/util/zip/Deflater;", Column.INVAL_VALUE, "data", "deflateFully", "(Ljava/util/zip/Deflater;[B)[B", "Ljava/util/zip/Inflater;", "inflateFully", "(Ljava/util/zip/Inflater;[B)[B", "Lkotlinx/io/Sink;", "deflater", "Ljava/nio/ByteBuffer;", "buffer", Column.INVAL_VALUE, "flush", Column.INVAL_VALUE, "deflateTo", "(Lkotlinx/io/Sink;Ljava/util/zip/Deflater;Ljava/nio/ByteBuffer;Z)I", "PADDED_EMPTY_CHUNK", "[B", "EMPTY_CHUNK", "ktor-websockets"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DeflaterUtilsKt {
    private static final byte[] PADDED_EMPTY_CHUNK = {0, 0, 0, -1, -1};
    private static final byte[] EMPTY_CHUNK = {0, 0, -1, -1};

    public static final byte[] deflateFully(Deflater $this$deflateFully, byte[] data) {
        Intrinsics.checkNotNullParameter($this$deflateFully, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        $this$deflateFully.setInput(data);
        Source buffer = new Buffer();
        Sink $this$deflateFully_u24lambda_u241 = (Sink) buffer;
        ObjectPool $this$useInstance$iv = ByteBufferPoolKt.getKtorDefaultPool();
        Object instance$iv = $this$useInstance$iv.borrow();
        try {
            ByteBuffer buffer2 = (ByteBuffer) instance$iv;
            while (!$this$deflateFully.needsInput()) {
                deflateTo($this$deflateFully_u24lambda_u241, $this$deflateFully, buffer2, false);
            }
            do {
            } while (deflateTo($this$deflateFully_u24lambda_u241, $this$deflateFully, buffer2, true) != 0);
            Unit unit = Unit.INSTANCE;
            $this$useInstance$iv.recycle(instance$iv);
            Source deflatedBytes = buffer;
            if (BytePacketUtilsKt.endsWith(deflatedBytes, PADDED_EMPTY_CHUNK)) {
                byte[] readByteArray = SourcesKt.readByteArray(deflatedBytes, ((int) ByteReadPacketKt.getRemaining(deflatedBytes)) - EMPTY_CHUNK.length);
                deflatedBytes.close();
                return readByteArray;
            }
            Source buffer3 = new Buffer();
            Sink $this$deflateFully_u24lambda_u243 = (Sink) buffer3;
            BytePacketBuilderKt.writePacket($this$deflateFully_u24lambda_u243, deflatedBytes);
            $this$deflateFully_u24lambda_u243.writeByte((byte) 0);
            return SourcesKt.readByteArray(buffer3);
        } catch (Throwable th) {
            $this$useInstance$iv.recycle(instance$iv);
            throw th;
        }
    }

    public static final byte[] inflateFully(Inflater $this$inflateFully, byte[] data) {
        Intrinsics.checkNotNullParameter($this$inflateFully, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] dataToInflate = ArraysKt.plus(data, EMPTY_CHUNK);
        $this$inflateFully.setInput(dataToInflate);
        Source buffer = new Buffer();
        Sink $this$inflateFully_u24lambda_u245 = (Sink) buffer;
        ObjectPool $this$useInstance$iv = ByteBufferPoolKt.getKtorDefaultPool();
        Object instance$iv = $this$useInstance$iv.borrow();
        try {
            ByteBuffer buffer2 = (ByteBuffer) instance$iv;
            long limit = dataToInflate.length + $this$inflateFully.getBytesRead();
            while ($this$inflateFully.getBytesRead() < limit) {
                buffer2.clear();
                int inflated = $this$inflateFully.inflate(buffer2.array(), buffer2.position(), buffer2.limit());
                buffer2.position(buffer2.position() + inflated);
                buffer2.flip();
                BytePacketBuilderExtensions_jvmKt.writeFully($this$inflateFully_u24lambda_u245, buffer2);
            }
            Unit unit = Unit.INSTANCE;
            $this$useInstance$iv.recycle(instance$iv);
            Source packet = buffer;
            return SourcesKt.readByteArray(packet);
        } catch (Throwable th) {
            $this$useInstance$iv.recycle(instance$iv);
            throw th;
        }
    }

    private static final int deflateTo(Sink $this$deflateTo, Deflater deflater, ByteBuffer buffer, boolean flush) {
        int deflated;
        buffer.clear();
        if (flush) {
            deflated = deflater.deflate(buffer.array(), buffer.position(), buffer.limit(), 2);
        } else {
            deflated = deflater.deflate(buffer.array(), buffer.position(), buffer.limit());
        }
        if (deflated == 0) {
            return 0;
        }
        buffer.position(buffer.position() + deflated);
        buffer.flip();
        BytePacketBuilderExtensions_jvmKt.writeFully($this$deflateTo, buffer);
        return deflated;
    }
}