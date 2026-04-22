package kotlinx.io.bytestring.unsafe;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.bytestring.ByteString;

/* compiled from: UnsafeByteStringOperations.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J5\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\fH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lkotlinx/io/bytestring/unsafe/UnsafeByteStringOperations;", "", "<init>", "()V", "wrapUnsafe", "Lkotlinx/io/bytestring/ByteString;", "array", "", "withByteArrayUnsafe", "", "byteString", "block", "Lkotlin/Function1;", "kotlinx-io-bytestring"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnsafeByteStringOperations {
    public static final UnsafeByteStringOperations INSTANCE = new UnsafeByteStringOperations();

    private UnsafeByteStringOperations() {
    }

    public final ByteString wrapUnsafe(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return ByteString.Companion.wrap$kotlinx_io_bytestring(array);
    }

    public final void withByteArrayUnsafe(ByteString byteString, Function1<? super byte[], Unit> block) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(byteString.getBackingArrayReference());
    }
}