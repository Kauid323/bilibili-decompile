package io.ktor.util;

import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.InputKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;

/* compiled from: Base64.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0003\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0003¢\u0006\u0004\b\u0001\u0010\u0004\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0005¢\u0006\u0004\b\u0001\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0002\u001a\u0011\u0010\b\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0015\u0010\b\u001a\u00060\u0005j\u0002`\n*\u00020\u0005¢\u0006\u0004\b\b\u0010\u000b\u001a\u0014\u0010\u000e\u001a\u00020\r*\u00020\fH\u0080\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0011\u001a\u00020\u0010*\u00020\u0010H\u0080\b¢\u0006\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0017\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u0019\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\"\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"", "encodeBase64", "(Ljava/lang/String;)Ljava/lang/String;", "", "([B)Ljava/lang/String;", "Lkotlinx/io/Source;", "(Lkotlinx/io/Source;)Ljava/lang/String;", "decodeBase64String", "decodeBase64Bytes", "(Ljava/lang/String;)[B", "Lio/ktor/utils/io/core/Input;", "(Lkotlinx/io/Source;)Lkotlinx/io/Source;", "", "", "toBase64", "(I)C", "", "fromBase64", "(B)B", "BASE64_ALPHABET", "Ljava/lang/String;", "BASE64_MASK", "B", "BASE64_MASK_INT", "I", "BASE64_PAD", "C", "", "BASE64_INVERSE_ALPHABET", "[I", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Base64Kt {
    private static final String BASE64_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    private static final int[] BASE64_INVERSE_ALPHABET;
    private static final byte BASE64_MASK = 63;
    private static final int BASE64_MASK_INT = 63;
    private static final char BASE64_PAD = '=';

    static {
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            iArr[i] = StringsKt.indexOf$default(BASE64_ALPHABET, (char) i, 0, false, 6, (Object) null);
        }
        BASE64_INVERSE_ALPHABET = iArr;
    }

    public static final String encodeBase64(String $this$encodeBase64) {
        Intrinsics.checkNotNullParameter($this$encodeBase64, "<this>");
        Source buffer = new Buffer();
        Sink $this$encodeBase64_u24lambda_u240 = (Sink) buffer;
        io.ktor.utils.io.core.StringsKt.writeText$default($this$encodeBase64_u24lambda_u240, $this$encodeBase64, 0, 0, (Charset) null, 14, (Object) null);
        return encodeBase64(buffer);
    }

    public static final String encodeBase64(byte[] $this$encodeBase64) {
        int writeOffset;
        Intrinsics.checkNotNullParameter($this$encodeBase64, "<this>");
        int position = 0;
        int writeOffset2 = 0;
        char[] charArray = new char[(($this$encodeBase64.length * 8) / 6) + 3];
        while (position + 3 <= $this$encodeBase64.length) {
            int first = $this$encodeBase64[position];
            int second = $this$encodeBase64[position + 1];
            int third = $this$encodeBase64[position + 2];
            position += 3;
            int chunk = ((first & 255) << 16) | ((second & 255) << 8) | (third & 255);
            int index = 3;
            while (-1 < index) {
                charArray[writeOffset2] = BASE64_ALPHABET.charAt((chunk >> (index * 6)) & 63);
                index--;
                writeOffset2++;
            }
        }
        int first2 = $this$encodeBase64.length;
        int remaining = first2 - position;
        if (remaining == 0) {
            return StringsKt.concatToString(charArray, 0, writeOffset2);
        }
        int chunk2 = remaining == 1 ? (($this$encodeBase64[position] & 255) << 16) | 0 | 0 : (($this$encodeBase64[position] & 255) << 16) | (($this$encodeBase64[position + 1] & 255) << 8) | 0;
        int padSize = ((3 - remaining) * 8) / 6;
        int index2 = 3;
        if (padSize <= 3) {
            while (true) {
                writeOffset = writeOffset2 + 1;
                charArray[writeOffset2] = BASE64_ALPHABET.charAt((chunk2 >> (index2 * 6)) & 63);
                if (index2 == padSize) {
                    break;
                }
                index2--;
                writeOffset2 = writeOffset;
            }
            writeOffset2 = writeOffset;
        }
        int i = 0;
        while (i < padSize) {
            charArray[writeOffset2] = BASE64_PAD;
            i++;
            writeOffset2++;
        }
        return StringsKt.concatToString(charArray, 0, writeOffset2);
    }

    public static final String encodeBase64(Source $this$encodeBase64) {
        Intrinsics.checkNotNullParameter($this$encodeBase64, "<this>");
        return encodeBase64(SourcesKt.readByteArray($this$encodeBase64));
    }

    public static final String decodeBase64String(String $this$decodeBase64String) {
        Intrinsics.checkNotNullParameter($this$decodeBase64String, "<this>");
        byte[] bytes = decodeBase64Bytes($this$decodeBase64String);
        return StringsKt.decodeToString$default(bytes, 0, bytes.length + 0, false, 4, (Object) null);
    }

    public static final byte[] decodeBase64Bytes(String $this$decodeBase64Bytes) {
        String str;
        Intrinsics.checkNotNullParameter($this$decodeBase64Bytes, "<this>");
        Source buffer = new Buffer();
        Sink $this$decodeBase64Bytes_u24lambda_u243 = (Sink) buffer;
        int index$iv = StringsKt.getLastIndex($this$decodeBase64Bytes);
        while (true) {
            if (-1 < index$iv) {
                char it = $this$decodeBase64Bytes.charAt(index$iv);
                if (!(it == '=')) {
                    str = $this$decodeBase64Bytes.substring(0, index$iv + 1);
                    Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                    break;
                }
                index$iv--;
            } else {
                str = "";
                break;
            }
        }
        io.ktor.utils.io.core.StringsKt.writeText$default($this$decodeBase64Bytes_u24lambda_u243, str, 0, 0, (Charset) null, 14, (Object) null);
        return SourcesKt.readByteArray(decodeBase64Bytes(buffer));
    }

    public static final Source decodeBase64Bytes(Source $this$decodeBase64Bytes) {
        Intrinsics.checkNotNullParameter($this$decodeBase64Bytes, "<this>");
        boolean z = false;
        Source buffer = new Buffer();
        Sink $this$decodeBase64Bytes_u24lambda_u245 = (Sink) buffer;
        byte[] data = new byte[4];
        while (ByteReadPacketKt.getRemaining($this$decodeBase64Bytes) > 0) {
            int read = InputKt.readAvailable$default($this$decodeBase64Bytes, data, 0, 0, 6, (Object) null);
            boolean z2 = false;
            int index$iv = 0;
            int accumulator$iv = 0;
            int length = data.length;
            int i = 0;
            while (i < length) {
                byte element$iv = data[i];
                int result = accumulator$iv;
                boolean z3 = z2;
                int initial$iv = element$iv & 255;
                accumulator$iv = result | (((byte) (((byte) BASE64_INVERSE_ALPHABET[initial$iv]) & BASE64_MASK)) << ((3 - index$iv) * 6));
                i++;
                index$iv++;
                z2 = z3;
                z = z;
            }
            boolean z4 = z;
            int $i$f$buildPacket = accumulator$iv;
            int index = data.length - 2;
            int length2 = data.length - read;
            if (length2 <= index) {
                while (true) {
                    int origin = ($i$f$buildPacket >> (index * 8)) & 255;
                    $this$decodeBase64Bytes_u24lambda_u245.writeByte((byte) origin);
                    if (index != length2) {
                        index--;
                    }
                }
            }
            z = z4;
        }
        return buffer;
    }

    public static final char toBase64(int $this$toBase64) {
        return BASE64_ALPHABET.charAt($this$toBase64);
    }

    public static final byte fromBase64(byte $this$fromBase64) {
        return (byte) (((byte) BASE64_INVERSE_ALPHABET[$this$fromBase64 & 255]) & BASE64_MASK);
    }
}