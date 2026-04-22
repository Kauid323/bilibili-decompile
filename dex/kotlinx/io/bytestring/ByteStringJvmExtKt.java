package kotlinx.io.bytestring;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.io.bytestring.ByteString;
import kotlinx.io.bytestring.unsafe.UnsafeByteStringOperations;

/* compiled from: ByteStringJvmExt.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0002\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n\u001a\u001a\u0010\b\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\f\u001a\u00020\r*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0002\u001a\u001a\u0010\f\u001a\u00020\r*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0002\u001a\u001c\u0010\u000f\u001a\u00020\r*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u0011"}, d2 = {"decodeToString", "", "Lkotlinx/io/bytestring/ByteString;", "charset", "Ljava/nio/charset/Charset;", "encodeToByteString", "asReadOnlyByteBuffer", "Ljava/nio/ByteBuffer;", "getByteString", "length", "", "at", "putByteString", "", "string", "checkIndexAndCapacity", "idx", "kotlinx-io-bytestring"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ByteStringJvmExtKt {
    public static final String decodeToString(ByteString $this$decodeToString, Charset charset) {
        Intrinsics.checkNotNullParameter($this$decodeToString, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String($this$decodeToString.getBackingArrayReference(), charset);
    }

    public static final ByteString encodeToByteString(String $this$encodeToByteString, Charset charset) {
        Intrinsics.checkNotNullParameter($this$encodeToByteString, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        ByteString.Companion companion = ByteString.Companion;
        byte[] bytes = $this$encodeToByteString.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return companion.wrap$kotlinx_io_bytestring(bytes);
    }

    public static final ByteBuffer asReadOnlyByteBuffer(ByteString $this$asReadOnlyByteBuffer) {
        Intrinsics.checkNotNullParameter($this$asReadOnlyByteBuffer, "<this>");
        UnsafeByteStringOperations unsafeByteStringOperations = UnsafeByteStringOperations.INSTANCE;
        byte[] it = $this$asReadOnlyByteBuffer.getBackingArrayReference();
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(it).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(asReadOnlyBuffer, "asReadOnlyBuffer(...)");
        return asReadOnlyBuffer;
    }

    public static /* synthetic */ ByteString getByteString$default(ByteBuffer byteBuffer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = byteBuffer.remaining();
        }
        return getByteString(byteBuffer, i);
    }

    public static final ByteString getByteString(ByteBuffer $this$getByteString, int length) {
        Intrinsics.checkNotNullParameter($this$getByteString, "<this>");
        if (length < 0) {
            throw new IndexOutOfBoundsException("length should be non-negative (was " + length + ')');
        }
        if ($this$getByteString.remaining() < length) {
            throw new IndexOutOfBoundsException("length (" + length + ") exceeds remaining bytes count ({" + $this$getByteString.remaining() + "})");
        }
        byte[] bytes = new byte[length];
        $this$getByteString.get(bytes);
        return UnsafeByteStringOperations.INSTANCE.wrapUnsafe(bytes);
    }

    public static final ByteString getByteString(ByteBuffer $this$getByteString, int at, int length) {
        Intrinsics.checkNotNullParameter($this$getByteString, "<this>");
        checkIndexAndCapacity($this$getByteString, at, length);
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = $this$getByteString.get(at + i);
        }
        return UnsafeByteStringOperations.INSTANCE.wrapUnsafe(bytes);
    }

    public static final void putByteString(ByteBuffer $this$putByteString, ByteString string) {
        Intrinsics.checkNotNullParameter($this$putByteString, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        UnsafeByteStringOperations unsafeByteStringOperations = UnsafeByteStringOperations.INSTANCE;
        byte[] it = string.getBackingArrayReference();
        $this$putByteString.put(it);
    }

    public static final void putByteString(ByteBuffer $this$putByteString, int at, ByteString string) {
        Intrinsics.checkNotNullParameter($this$putByteString, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        checkIndexAndCapacity($this$putByteString, at, string.getSize());
        IntRange indices = ByteStringKt.getIndices(string);
        int idx = indices.getFirst();
        int last = indices.getLast();
        if (idx > last) {
            return;
        }
        while (true) {
            $this$putByteString.put(at + idx, string.get(idx));
            if (idx == last) {
                return;
            }
            idx++;
        }
    }

    private static final void checkIndexAndCapacity(ByteBuffer $this$checkIndexAndCapacity, int idx, int length) {
        if (idx < 0 || idx >= $this$checkIndexAndCapacity.limit()) {
            throw new IndexOutOfBoundsException("Index " + idx + " is out of this ByteBuffer's bounds: [0, " + $this$checkIndexAndCapacity.limit() + ')');
        }
        if (length < 0) {
            throw new IndexOutOfBoundsException("length should be non-negative (was " + length + ')');
        }
        if (idx + length > $this$checkIndexAndCapacity.limit()) {
            throw new IndexOutOfBoundsException("There's not enough space to put ByteString of length " + length + " starting from index " + idx);
        }
    }
}