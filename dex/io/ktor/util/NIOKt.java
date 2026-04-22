package io.ktor.util;

import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: NIO.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a)\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u00112\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0013¨\u0006\u0014"}, d2 = {"Ljava/nio/ByteBuffer;", "destination", "", "limit", "moveTo", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;I)I", "", "moveToByteArray", "(Ljava/nio/ByteBuffer;)[B", "Ljava/nio/charset/Charset;", "charset", "", "decodeString", "(Ljava/nio/ByteBuffer;Ljava/nio/charset/Charset;)Ljava/lang/String;", "size", "copy", "(Ljava/nio/ByteBuffer;I)Ljava/nio/ByteBuffer;", "Lio/ktor/utils/io/pool/ObjectPool;", "pool", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/pool/ObjectPool;I)Ljava/nio/ByteBuffer;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NIOKt {
    public static /* synthetic */ int moveTo$default(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return moveTo(byteBuffer, byteBuffer2, i);
    }

    public static final int moveTo(ByteBuffer $this$moveTo, ByteBuffer destination, int limit) {
        Intrinsics.checkNotNullParameter($this$moveTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int size = Math.min(limit, Math.min($this$moveTo.remaining(), destination.remaining()));
        if (size == $this$moveTo.remaining()) {
            destination.put($this$moveTo);
        } else {
            int l = $this$moveTo.limit();
            $this$moveTo.limit($this$moveTo.position() + size);
            destination.put($this$moveTo);
            $this$moveTo.limit(l);
        }
        return size;
    }

    public static final byte[] moveToByteArray(ByteBuffer $this$moveToByteArray) {
        Intrinsics.checkNotNullParameter($this$moveToByteArray, "<this>");
        byte[] array = new byte[$this$moveToByteArray.remaining()];
        $this$moveToByteArray.get(array);
        return array;
    }

    public static /* synthetic */ String decodeString$default(ByteBuffer byteBuffer, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return decodeString(byteBuffer, charset);
    }

    public static final String decodeString(ByteBuffer $this$decodeString, Charset charset) {
        Intrinsics.checkNotNullParameter($this$decodeString, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String charBuffer = charset.decode($this$decodeString).toString();
        Intrinsics.checkNotNullExpressionValue(charBuffer, "toString(...)");
        return charBuffer;
    }

    public static /* synthetic */ ByteBuffer copy$default(ByteBuffer byteBuffer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = byteBuffer.remaining();
        }
        return copy(byteBuffer, i);
    }

    public static final ByteBuffer copy(ByteBuffer $this$copy, int size) {
        Intrinsics.checkNotNullParameter($this$copy, "<this>");
        ByteBuffer $this$copy_u24lambda_u240 = ByteBuffer.allocate(size);
        ByteBuffer slice = $this$copy.slice();
        Intrinsics.checkNotNullExpressionValue(slice, "slice(...)");
        Intrinsics.checkNotNull($this$copy_u24lambda_u240);
        moveTo$default(slice, $this$copy_u24lambda_u240, 0, 2, null);
        $this$copy_u24lambda_u240.clear();
        Intrinsics.checkNotNullExpressionValue($this$copy_u24lambda_u240, "apply(...)");
        return $this$copy_u24lambda_u240;
    }

    public static final ByteBuffer copy(ByteBuffer $this$copy, ObjectPool<ByteBuffer> objectPool, int size) {
        Intrinsics.checkNotNullParameter($this$copy, "<this>");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        Object borrow = objectPool.borrow();
        ByteBuffer $this$copy_u24lambda_u241 = (ByteBuffer) borrow;
        $this$copy_u24lambda_u241.limit(size);
        ByteBuffer slice = $this$copy.slice();
        Intrinsics.checkNotNullExpressionValue(slice, "slice(...)");
        moveTo$default(slice, $this$copy_u24lambda_u241, 0, 2, null);
        $this$copy_u24lambda_u241.flip();
        return (ByteBuffer) borrow;
    }

    public static /* synthetic */ ByteBuffer copy$default(ByteBuffer byteBuffer, ObjectPool objectPool, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer.remaining();
        }
        return copy(byteBuffer, objectPool, i);
    }
}