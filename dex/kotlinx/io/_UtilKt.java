package kotlinx.io;

import kotlin.Metadata;
import kotlin.text.StringsKt;

/* compiled from: -Util.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000\u001a!\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0080\b\u001a \u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0000\u001a\u0011\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0080\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0010H\u0080\b\u001a\r\u0010\u000f\u001a\u00020\u000b*\u00020\u000bH\u0080\b\u001a\r\u0010\u000f\u001a\u00020\u0007*\u00020\u0007H\u0080\b\u001a\u0015\u0010\u0011\u001a\u00020\u000b*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0080\f\u001a\u0015\u0010\u0014\u001a\u00020\u000b*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0080\f\u001a\u0015\u0010\u0015\u001a\u00020\u000b*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0080\f\u001a\u0015\u0010\u0015\u001a\u00020\u0007*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0080\f\u001a\u0015\u0010\u0016\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0080\f\u001a\u0015\u0010\u0015\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0007H\u0080\f\u001a\u0019\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000bH\u0080\b\u001a\u0019\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0007H\u0080\b\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u0012H\u0000\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u000bH\u0000\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u0007H\u0000\u001a\u0011\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0007H\u0080\b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u001e"}, d2 = {"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS", "()[C", "checkOffsetAndCount", "", "size", "", "offset", "byteCount", "checkBounds", "", "startIndex", "endIndex", "checkByteCount", "reverseBytesCommon", "", "shr", "", "other", "shl", "and", "xor", "minOf", "a", "b", "toHexString", "", "hexNumberLength", "v", "kotlinx-io-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class _UtilKt {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final void checkOffsetAndCount(long size, long offset, long byteCount) {
        if (offset < 0 || offset > size || size - offset < byteCount || byteCount < 0) {
            throw new IllegalArgumentException("offset (" + offset + ") and byteCount (" + byteCount + ") are not within the range [0..size(" + size + "))");
        }
    }

    public static final void checkBounds(int size, int startIndex, int endIndex) {
        checkBounds(size, startIndex, endIndex);
    }

    public static final void checkBounds(long size, long startIndex, long endIndex) {
        if (startIndex < 0 || endIndex > size) {
            throw new IndexOutOfBoundsException("startIndex (" + startIndex + ") and endIndex (" + endIndex + ") are not within the range [0..size(" + size + "))");
        }
        if (startIndex > endIndex) {
            throw new IllegalArgumentException("startIndex (" + startIndex + ") > endIndex (" + endIndex + ')');
        }
    }

    public static final void checkByteCount(long byteCount) {
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount (" + byteCount + ") < 0").toString());
        }
    }

    public static final short reverseBytesCommon(short $this$reverseBytesCommon) {
        int i = 65535 & $this$reverseBytesCommon;
        int reversed = ((65280 & i) >>> 8) | ((i & 255) << 8);
        return (short) reversed;
    }

    public static final int reverseBytesCommon(int $this$reverseBytesCommon) {
        return (((-16777216) & $this$reverseBytesCommon) >>> 24) | ((16711680 & $this$reverseBytesCommon) >>> 8) | ((65280 & $this$reverseBytesCommon) << 8) | (($this$reverseBytesCommon & 255) << 24);
    }

    public static final long reverseBytesCommon(long $this$reverseBytesCommon) {
        return (((-72057594037927936L) & $this$reverseBytesCommon) >>> 56) | ((71776119061217280L & $this$reverseBytesCommon) >>> 40) | ((280375465082880L & $this$reverseBytesCommon) >>> 24) | ((1095216660480L & $this$reverseBytesCommon) >>> 8) | ((4278190080L & $this$reverseBytesCommon) << 8) | ((16711680 & $this$reverseBytesCommon) << 24) | ((65280 & $this$reverseBytesCommon) << 40) | ((255 & $this$reverseBytesCommon) << 56);
    }

    public static final int shr(byte $this$shr, int other) {
        return $this$shr >> other;
    }

    public static final int shl(byte $this$shl, int other) {
        return $this$shl << other;
    }

    public static final int and(byte $this$and, int other) {
        return $this$and & other;
    }

    public static final long and(byte $this$and, long other) {
        return $this$and & other;
    }

    public static final byte xor(byte $this$xor, byte other) {
        return (byte) ($this$xor ^ other);
    }

    public static final long and(int $this$and, long other) {
        return $this$and & other;
    }

    public static final long minOf(long a, int b) {
        return Math.min(a, b);
    }

    public static final long minOf(int a, long b) {
        return Math.min(a, b);
    }

    public static final String toHexString(byte $this$toHexString) {
        int other$iv = $this$toHexString >> 4;
        int other$iv2 = 15 & $this$toHexString;
        char[] result = {HEX_DIGIT_CHARS[other$iv & 15], HEX_DIGIT_CHARS[other$iv2]};
        return StringsKt.concatToString(result);
    }

    public static final String toHexString(int $this$toHexString) {
        if ($this$toHexString == 0) {
            return "0";
        }
        char[] result = {HEX_DIGIT_CHARS[($this$toHexString >> 28) & 15], HEX_DIGIT_CHARS[($this$toHexString >> 24) & 15], HEX_DIGIT_CHARS[($this$toHexString >> 20) & 15], HEX_DIGIT_CHARS[($this$toHexString >> 16) & 15], HEX_DIGIT_CHARS[($this$toHexString >> 12) & 15], HEX_DIGIT_CHARS[($this$toHexString >> 8) & 15], HEX_DIGIT_CHARS[($this$toHexString >> 4) & 15], HEX_DIGIT_CHARS[$this$toHexString & 15]};
        int i = 0;
        while (i < result.length && result[i] == '0') {
            i++;
        }
        return StringsKt.concatToString(result, i, result.length);
    }

    public static final String toHexString(long $this$toHexString) {
        if ($this$toHexString == 0) {
            return "0";
        }
        char[] result = {HEX_DIGIT_CHARS[(int) (($this$toHexString >> 60) & 15)], HEX_DIGIT_CHARS[(int) (($this$toHexString >> 56) & 15)], HEX_DIGIT_CHARS[(int) (($this$toHexString >> 52) & 15)], HEX_DIGIT_CHARS[(int) (($this$toHexString >> 48) & 15)], HEX_DIGIT_CHARS[(int) (($this$toHexString >> 44) & 15)], HEX_DIGIT_CHARS[(int) (($this$toHexString >> 40) & 15)], HEX_DIGIT_CHARS[(int) (($this$toHexString >> 36) & 15)], HEX_DIGIT_CHARS[(int) (($this$toHexString >> 32) & 15)], HEX_DIGIT_CHARS[(int) (($this$toHexString >> 28) & 15)], HEX_DIGIT_CHARS[(int) (($this$toHexString >> 24) & 15)], HEX_DIGIT_CHARS[(int) (($this$toHexString >> 20) & 15)], HEX_DIGIT_CHARS[(int) (($this$toHexString >> 16) & 15)], HEX_DIGIT_CHARS[(int) (($this$toHexString >> 12) & 15)], HEX_DIGIT_CHARS[(int) (($this$toHexString >> 8) & 15)], HEX_DIGIT_CHARS[(int) (($this$toHexString >> 4) & 15)], HEX_DIGIT_CHARS[(int) ($this$toHexString & 15)]};
        int i = 0;
        while (i < result.length && result[i] == '0') {
            i++;
        }
        return StringsKt.concatToString(result, i, result.length);
    }

    public static final int hexNumberLength(long v) {
        if (v == 0) {
            return 1;
        }
        int exactWidth = 64 - Long.numberOfLeadingZeros(v);
        return (exactWidth + 3) / 4;
    }
}