package kotlinx.io.bytestring;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: ByteString.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00020\u0003\"\u00020\u0004\u001a\u0019\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00020\u0005\"\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u001c\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u001a\u001c\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u001a\u001c\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u001a\u001c\u0010\u0013\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u001a\u001c\u0010\u0013\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u001a\u001c\u0010\u0013\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u001a\u0012\u0010\u0014\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0003\u001a\u0012\u0010\u0014\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0012\u0010\u0016\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0003\u001a\u0012\u0010\u0016\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001\u001a0\u0010\u0017\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000eH\u0002\u001a0\u0010\u0017\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000eH\u0002\u001a\n\u0010\u001c\u001a\u00020\u0015*\u00020\u0001\u001a\n\u0010\u001d\u001a\u00020\u0015*\u00020\u0001\u001a\n\u0010\u001e\u001a\u00020\u001f*\u00020\u0001\u001a\n\u0010 \u001a\u00020\u0001*\u00020\u001f\u001a\u0012\u0010!\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\"\u001a\u00020\u0003\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006#"}, d2 = {"ByteString", "Lkotlinx/io/bytestring/ByteString;", "bytes", "", "", "Lkotlin/UByteArray;", "Lkotlin/UByte;", "ByteString-GBYM_sE", "([B)Lkotlinx/io/bytestring/ByteString;", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "(Lkotlinx/io/bytestring/ByteString;)Lkotlin/ranges/IntRange;", "indexOf", "", "byte", "startIndex", "byteString", "byteArray", "lastIndexOf", "startsWith", "", "endsWith", "rangeEquals", "offset", "other", "otherOffset", "byteCount", "isEmpty", "isNotEmpty", "decodeToString", "", "encodeToByteString", "contentEquals", "array", "kotlinx-io-bytestring"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ByteStringKt {
    public static final ByteString ByteString(byte... bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (bytes.length == 0) {
            return ByteString.Companion.getEMPTY$kotlinx_io_bytestring();
        }
        return ByteString.Companion.wrap$kotlinx_io_bytestring(bytes);
    }

    /* renamed from: ByteString-GBYM_sE  reason: not valid java name */
    public static final ByteString m1524ByteStringGBYM_sE(byte... bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (UByteArray.isEmpty-impl(bytes)) {
            return ByteString.Companion.getEMPTY$kotlinx_io_bytestring();
        }
        return ByteString.Companion.wrap$kotlinx_io_bytestring(bytes);
    }

    public static final ByteString ByteString() {
        return ByteString.Companion.getEMPTY$kotlinx_io_bytestring();
    }

    public static final IntRange getIndices(ByteString $this$indices) {
        Intrinsics.checkNotNullParameter($this$indices, "<this>");
        return RangesKt.until(0, $this$indices.getSize());
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte b, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return indexOf(byteString, b, i);
    }

    public static final int indexOf(ByteString $this$indexOf, byte b, int startIndex) {
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        byte[] localData = $this$indexOf.getBackingArrayReference();
        int size = $this$indexOf.getSize();
        for (int i = Math.max(startIndex, 0); i < size; i++) {
            if (localData[i] == b) {
                return i;
            }
        }
        return -1;
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return indexOf(byteString, byteString2, i);
    }

    public static final int indexOf(ByteString $this$indexOf, ByteString byteString, int startIndex) {
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (isEmpty(byteString)) {
            return Math.max(Math.min(startIndex, $this$indexOf.getSize()), 0);
        }
        byte[] localData = $this$indexOf.getBackingArrayReference();
        byte firstByte = byteString.get(0);
        int i = Math.max(startIndex, 0);
        int size = $this$indexOf.getSize() - byteString.getSize();
        if (i > size) {
            return -1;
        }
        while (true) {
            if (localData[i] != firstByte || !rangeEquals$default($this$indexOf, i, byteString, 0, 0, 12, (Object) null)) {
                if (i == size) {
                    return -1;
                }
                i++;
            } else {
                return i;
            }
        }
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return indexOf(byteString, bArr, i);
    }

    public static final int indexOf(ByteString $this$indexOf, byte[] byteArray, int startIndex) {
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        if (byteArray.length == 0) {
            return Math.max(Math.min(startIndex, $this$indexOf.getSize()), 0);
        }
        byte[] localData = $this$indexOf.getBackingArrayReference();
        byte firstByte = byteArray[0];
        int i = Math.max(0, startIndex);
        int size = $this$indexOf.getSize() - byteArray.length;
        if (i > size) {
            return -1;
        }
        while (true) {
            if (localData[i] != firstByte || !rangeEquals$default($this$indexOf, i, byteArray, 0, 0, 12, (Object) null)) {
                if (i == size) {
                    return -1;
                }
                i++;
            } else {
                return i;
            }
        }
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte b, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return lastIndexOf(byteString, b, i);
    }

    public static final int lastIndexOf(ByteString $this$lastIndexOf, byte b, int startIndex) {
        Intrinsics.checkNotNullParameter($this$lastIndexOf, "<this>");
        byte[] localData = $this$lastIndexOf.getBackingArrayReference();
        int i = $this$lastIndexOf.getSize() - 1;
        int max = Math.max(0, startIndex);
        if (max <= i) {
            while (localData[i] != b) {
                if (i == max) {
                    return -1;
                }
                i--;
            }
            return i;
        }
        return -1;
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return lastIndexOf(byteString, byteString2, i);
    }

    public static final int lastIndexOf(ByteString $this$lastIndexOf, ByteString byteString, int startIndex) {
        Intrinsics.checkNotNullParameter($this$lastIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (isEmpty(byteString)) {
            return $this$lastIndexOf.getSize();
        }
        int idx = $this$lastIndexOf.getSize() - byteString.getSize();
        int max = Math.max(0, startIndex);
        if (max <= idx) {
            while (!rangeEquals$default($this$lastIndexOf, idx, byteString, 0, 0, 8, (Object) null)) {
                if (idx == max) {
                    return -1;
                }
                idx--;
            }
            return idx;
        }
        return -1;
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return lastIndexOf(byteString, bArr, i);
    }

    public static final int lastIndexOf(ByteString $this$lastIndexOf, byte[] byteArray, int startIndex) {
        Intrinsics.checkNotNullParameter($this$lastIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        if (byteArray.length == 0) {
            return $this$lastIndexOf.getSize();
        }
        int idx = $this$lastIndexOf.getSize() - byteArray.length;
        int max = Math.max(0, startIndex);
        if (max <= idx) {
            while (!rangeEquals$default($this$lastIndexOf, idx, byteArray, 0, 0, 8, (Object) null)) {
                if (idx == max) {
                    return -1;
                }
                idx--;
            }
            return idx;
        }
        return -1;
    }

    public static final boolean startsWith(ByteString $this$startsWith, byte[] byteArray) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        if (byteArray.length > $this$startsWith.getSize()) {
            return false;
        }
        return rangeEquals$default($this$startsWith, 0, byteArray, 0, 0, 12, (Object) null);
    }

    public static final boolean startsWith(ByteString $this$startsWith, ByteString byteString) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (byteString.getSize() > $this$startsWith.getSize()) {
            return false;
        }
        return byteString.getSize() == $this$startsWith.getSize() ? $this$startsWith.equals(byteString) : rangeEquals$default($this$startsWith, 0, byteString, 0, 0, 12, (Object) null);
    }

    public static final boolean endsWith(ByteString $this$endsWith, byte[] byteArray) {
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        if (byteArray.length > $this$endsWith.getSize()) {
            return false;
        }
        return rangeEquals$default($this$endsWith, $this$endsWith.getSize() - byteArray.length, byteArray, 0, 0, 12, (Object) null);
    }

    public static final boolean endsWith(ByteString $this$endsWith, ByteString byteString) {
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (byteString.getSize() > $this$endsWith.getSize()) {
            return false;
        }
        return byteString.getSize() == $this$endsWith.getSize() ? $this$endsWith.equals(byteString) : rangeEquals$default($this$endsWith, $this$endsWith.getSize() - byteString.getSize(), byteString, 0, 0, 12, (Object) null);
    }

    static /* synthetic */ boolean rangeEquals$default(ByteString byteString, int i, ByteString byteString2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = byteString2.getSize() - i2;
        }
        return rangeEquals(byteString, i, byteString2, i2, i3);
    }

    private static final boolean rangeEquals(ByteString $this$rangeEquals, int offset, ByteString other, int otherOffset, int byteCount) {
        byte[] localData = $this$rangeEquals.getBackingArrayReference();
        byte[] otherData = other.getBackingArrayReference();
        for (int i = 0; i < byteCount; i++) {
            if (localData[offset + i] != otherData[otherOffset + i]) {
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ boolean rangeEquals$default(ByteString byteString, int i, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length - i2;
        }
        return rangeEquals(byteString, i, bArr, i2, i3);
    }

    private static final boolean rangeEquals(ByteString $this$rangeEquals, int offset, byte[] other, int otherOffset, int byteCount) {
        byte[] localData = $this$rangeEquals.getBackingArrayReference();
        for (int i = 0; i < byteCount; i++) {
            if (localData[offset + i] != other[otherOffset + i]) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isEmpty(ByteString $this$isEmpty) {
        Intrinsics.checkNotNullParameter($this$isEmpty, "<this>");
        return $this$isEmpty.getSize() == 0;
    }

    public static final boolean isNotEmpty(ByteString $this$isNotEmpty) {
        Intrinsics.checkNotNullParameter($this$isNotEmpty, "<this>");
        return !isEmpty($this$isNotEmpty);
    }

    public static final String decodeToString(ByteString $this$decodeToString) {
        Intrinsics.checkNotNullParameter($this$decodeToString, "<this>");
        return StringsKt.decodeToString($this$decodeToString.getBackingArrayReference());
    }

    public static final ByteString encodeToByteString(String $this$encodeToByteString) {
        Intrinsics.checkNotNullParameter($this$encodeToByteString, "<this>");
        return ByteString.Companion.wrap$kotlinx_io_bytestring(StringsKt.encodeToByteArray($this$encodeToByteString));
    }

    public static final boolean contentEquals(ByteString $this$contentEquals, byte[] array) {
        Intrinsics.checkNotNullParameter($this$contentEquals, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        return Arrays.equals($this$contentEquals.getBackingArrayReference(), array);
    }
}