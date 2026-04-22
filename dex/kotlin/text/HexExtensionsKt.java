package kotlin.text;

import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.HexFormat;

/* compiled from: HexExtensions.kt */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0019\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0001\n\u0000\u001a\u0016\u0010\u000b\u001a\u00020\u0001*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010\u000b\u001a\u00020\u0001*\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a,\u0010\u0012\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002\u001a,\u0010\u0016\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002\u001a,\u0010\u0017\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002\u001a,\u0010\u0018\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002\u001a<\u0010\u0019\u001a\u00020\u0010*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002\u001a,\u0010\u0019\u001a\u00020\u0010*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002\u001a(\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0010H\u0002\u001a@\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0010H\u0000\u001a\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*H\u0002\u001a\u0016\u0010+\u001a\u00020\f*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010+\u001a\u00020\f*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002\u001a&\u0010,\u001a\u0004\u0018\u00010\f*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a&\u0010-\u001a\u0004\u0018\u00010\f*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a&\u0010.\u001a\u0004\u0018\u00010\f*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a$\u0010/\u001a\u00020\f*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0014\u00100\u001a\u000201*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0002\u001a@\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0010H\u0000\u001a \u00104\u001a\u00020*2\u0006\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0010H\u0002\u001a \u00108\u001a\u00020*2\u0006\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020*2\u0006\u00107\u001a\u00020\u0010H\u0002\u001a\u001c\u00109\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u001a\u0016\u0010\u000b\u001a\u00020\u0001*\u0002012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0016\u0010:\u001a\u000201*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010:\u001a\u000201*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0016\u0010\u000b\u001a\u00020\u0001*\u00020;2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0016\u0010<\u001a\u00020;*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010<\u001a\u00020;*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0016\u0010\u000b\u001a\u00020\u0001*\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0016\u0010=\u001a\u00020\u0010*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010=\u001a\u00020\u0010*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0016\u0010\u000b\u001a\u00020\u0001*\u00020*2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0016\u0010>\u001a\u00020**\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010>\u001a\u00020**\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0000\u001a$\u0010?\u001a\u00020\u0001*\u00020*2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u0010H\u0002\u001a\u001c\u0010D\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002\u001a,\u0010E\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\u0010H\u0002\u001a,\u0010G\u001a\u00020**\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\u0010H\u0002\u001a<\u0010H\u001a\u00020I*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u00012\u0006\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020M2\u0006\u0010F\u001a\u00020\u0010H\u0002\u001a$\u0010N\u001a\u00020I*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u0010H\u0002\u001a\u001c\u0010O\u001a\u00020I*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u001a\u001c\u0010P\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u001a\u001c\u0010Q\u001a\u00020**\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u001a5\u0010R\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\u00012\u0006\u0010L\u001a\u00020M2\u0006\u0010T\u001a\u00020\u0001H\u0082\b\u001a\u0015\u0010U\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0082\b\u001a\u0015\u0010V\u001a\u00020**\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0082\b\u001a,\u0010W\u001a\u00020I*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010X\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0010H\u0002\u001a,\u0010Z\u001a\u00020I*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\u00012\u0006\u0010T\u001a\u00020\u0001H\u0002\u001a,\u0010[\u001a\u00020I*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u00012\u0006\u0010K\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\\\u001a\u00020]*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"LOWER_CASE_HEX_DIGITS", "", "UPPER_CASE_HEX_DIGITS", "BYTE_TO_LOWER_CASE_HEX_DIGITS", "", "getBYTE_TO_LOWER_CASE_HEX_DIGITS", "()[I", "BYTE_TO_UPPER_CASE_HEX_DIGITS", "HEX_DIGITS_TO_DECIMAL", "HEX_DIGITS_TO_LONG_DECIMAL", "", "toHexString", "", "format", "Lkotlin/text/HexFormat;", "startIndex", "", "endIndex", "toHexStringNoLineAndGroupSeparator", "bytesFormat", "Lkotlin/text/HexFormat$BytesHexFormat;", "byteToDigits", "toHexStringShortByteSeparatorNoPrefixAndSuffix", "toHexStringNoLineAndGroupSeparatorSlowPath", "toHexStringSlowPath", "formatByteAt", "index", "bytePrefix", "byteSuffix", "destination", "", "destinationOffset", "formattedStringLength", "numberOfBytes", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "checkFormatLength", "formatLength", "", "hexToByteArray", "hexToByteArrayNoLineAndGroupSeparator", "hexToByteArrayShortByteSeparatorNoPrefixAndSuffix", "hexToByteArrayNoLineAndGroupSeparatorSlowPath", "hexToByteArraySlowPath", "parseByteAt", "", "parsedByteArrayMaxSize", "stringLength", "charsPerSet", "charsPerElement", "elementsPerSet", "elementSeparatorLength", "wholeElementsPerSet", "checkNewLineAt", "hexToByte", "", "hexToShort", "hexToInt", "hexToLong", "toHexStringImpl", "numberFormat", "Lkotlin/text/HexFormat$NumberHexFormat;", "digits", "bits", "toCharArrayIfNotEmpty", "hexToIntImpl", "typeHexLength", "hexToLongImpl", "checkPrefixSuffixNumberOfDigits", "", "prefix", "suffix", "ignoreCase", "", "checkNumberOfDigits", "checkZeroDigits", "parseInt", "parseLong", "checkContainsAt", "part", "partName", "decimalFromHexDigitAt", "longDecimalFromHexDigitAt", "throwInvalidNumberOfDigits", "specifier", "expected", "throwNotContainedAt", "throwInvalidPrefixSuffix", "throwInvalidDigitAt", "", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HexExtensionsKt {
    private static final int[] BYTE_TO_LOWER_CASE_HEX_DIGITS;
    private static final int[] BYTE_TO_UPPER_CASE_HEX_DIGITS;
    private static final int[] HEX_DIGITS_TO_DECIMAL;
    private static final long[] HEX_DIGITS_TO_LONG_DECIMAL;
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";

    static {
        int[] iArr = new int[256];
        int i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = LOWER_CASE_HEX_DIGITS.charAt(i2 & 15) | (LOWER_CASE_HEX_DIGITS.charAt(i2 >> 4) << '\b');
        }
        BYTE_TO_LOWER_CASE_HEX_DIGITS = iArr;
        int[] iArr2 = new int[256];
        for (int i3 = 0; i3 < 256; i3++) {
            iArr2[i3] = UPPER_CASE_HEX_DIGITS.charAt(i3 & 15) | (UPPER_CASE_HEX_DIGITS.charAt(i3 >> 4) << '\b');
        }
        BYTE_TO_UPPER_CASE_HEX_DIGITS = iArr2;
        int[] $this$HEX_DIGITS_TO_DECIMAL_u24lambda_u240 = new int[256];
        for (int i4 = 0; i4 < 256; i4++) {
            $this$HEX_DIGITS_TO_DECIMAL_u24lambda_u240[i4] = -1;
        }
        int index$iv = 0;
        int i5 = 0;
        while (i5 < $this$forEachIndexed$iv.length()) {
            char item$iv = $this$forEachIndexed$iv.charAt(i5);
            $this$HEX_DIGITS_TO_DECIMAL_u24lambda_u240[item$iv] = index$iv;
            i5++;
            index$iv++;
        }
        int index$iv2 = 0;
        int i6 = 0;
        while (i6 < $this$forEachIndexed$iv.length()) {
            char item$iv2 = $this$forEachIndexed$iv.charAt(i6);
            $this$HEX_DIGITS_TO_DECIMAL_u24lambda_u240[item$iv2] = index$iv2;
            i6++;
            index$iv2++;
        }
        HEX_DIGITS_TO_DECIMAL = $this$HEX_DIGITS_TO_DECIMAL_u24lambda_u240;
        long[] $this$HEX_DIGITS_TO_LONG_DECIMAL_u24lambda_u240 = new long[256];
        for (int i7 = 0; i7 < 256; i7++) {
            $this$HEX_DIGITS_TO_LONG_DECIMAL_u24lambda_u240[i7] = -1;
        }
        int index$iv3 = 0;
        int i8 = 0;
        while (i8 < $this$forEachIndexed$iv.length()) {
            char item$iv3 = $this$forEachIndexed$iv.charAt(i8);
            $this$HEX_DIGITS_TO_LONG_DECIMAL_u24lambda_u240[item$iv3] = index$iv3;
            i8++;
            index$iv3++;
        }
        int index$iv4 = 0;
        while (i < $this$forEachIndexed$iv.length()) {
            char item$iv4 = $this$forEachIndexed$iv.charAt(i);
            $this$HEX_DIGITS_TO_LONG_DECIMAL_u24lambda_u240[item$iv4] = index$iv4;
            i++;
            index$iv4++;
        }
        HEX_DIGITS_TO_LONG_DECIMAL = $this$HEX_DIGITS_TO_LONG_DECIMAL_u24lambda_u240;
    }

    public static final int[] getBYTE_TO_LOWER_CASE_HEX_DIGITS() {
        return BYTE_TO_LOWER_CASE_HEX_DIGITS;
    }

    public static final String toHexString(byte[] $this$toHexString, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$toHexString, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexString($this$toHexString, 0, $this$toHexString.length, format);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return toHexString(bArr, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return toHexString(bArr, i, i2, hexFormat);
    }

    public static final String toHexString(byte[] $this$toHexString, int startIndex, int endIndex, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$toHexString, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$toHexString.length);
        if (startIndex == endIndex) {
            return "";
        }
        int[] byteToDigits = format.getUpperCase() ? BYTE_TO_UPPER_CASE_HEX_DIGITS : BYTE_TO_LOWER_CASE_HEX_DIGITS;
        HexFormat.BytesHexFormat bytesFormat = format.getBytes();
        if (bytesFormat.getNoLineAndGroupSeparator$kotlin_stdlib()) {
            return toHexStringNoLineAndGroupSeparator($this$toHexString, startIndex, endIndex, bytesFormat, byteToDigits);
        }
        return toHexStringSlowPath($this$toHexString, startIndex, endIndex, bytesFormat, byteToDigits);
    }

    private static final String toHexStringNoLineAndGroupSeparator(byte[] $this$toHexStringNoLineAndGroupSeparator, int startIndex, int endIndex, HexFormat.BytesHexFormat bytesFormat, int[] byteToDigits) {
        if (bytesFormat.getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib()) {
            return toHexStringShortByteSeparatorNoPrefixAndSuffix($this$toHexStringNoLineAndGroupSeparator, startIndex, endIndex, bytesFormat, byteToDigits);
        }
        return toHexStringNoLineAndGroupSeparatorSlowPath($this$toHexStringNoLineAndGroupSeparator, startIndex, endIndex, bytesFormat, byteToDigits);
    }

    private static final String toHexStringShortByteSeparatorNoPrefixAndSuffix(byte[] $this$toHexStringShortByteSeparatorNoPrefixAndSuffix, int startIndex, int endIndex, HexFormat.BytesHexFormat bytesFormat, int[] byteToDigits) {
        int byteSeparatorLength = bytesFormat.getByteSeparator().length();
        if (!(byteSeparatorLength <= 1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int numberOfBytes = endIndex - startIndex;
        int charIndex = 0;
        if (byteSeparatorLength == 0) {
            char[] charArray = new char[checkFormatLength(numberOfBytes * 2)];
            for (int byteIndex = startIndex; byteIndex < endIndex; byteIndex++) {
                charIndex = formatByteAt($this$toHexStringShortByteSeparatorNoPrefixAndSuffix, byteIndex, byteToDigits, charArray, charIndex);
            }
            return StringsKt.concatToString(charArray);
        }
        char[] charArray2 = new char[checkFormatLength((numberOfBytes * 3) - 1)];
        char byteSeparatorChar = bytesFormat.getByteSeparator().charAt(0);
        int charIndex2 = formatByteAt($this$toHexStringShortByteSeparatorNoPrefixAndSuffix, startIndex, byteToDigits, charArray2, 0);
        for (int byteIndex2 = startIndex + 1; byteIndex2 < endIndex; byteIndex2++) {
            charArray2[charIndex2] = byteSeparatorChar;
            charIndex2 = formatByteAt($this$toHexStringShortByteSeparatorNoPrefixAndSuffix, byteIndex2, byteToDigits, charArray2, charIndex2 + 1);
        }
        return StringsKt.concatToString(charArray2);
    }

    private static final String toHexStringNoLineAndGroupSeparatorSlowPath(byte[] $this$toHexStringNoLineAndGroupSeparatorSlowPath, int startIndex, int endIndex, HexFormat.BytesHexFormat bytesFormat, int[] byteToDigits) {
        String bytePrefix = bytesFormat.getBytePrefix();
        String byteSuffix = bytesFormat.getByteSuffix();
        String byteSeparator = bytesFormat.getByteSeparator();
        int formatLength = formattedStringLength(endIndex - startIndex, byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        char[] charArray = new char[formatLength];
        int charIndex = formatByteAt($this$toHexStringNoLineAndGroupSeparatorSlowPath, startIndex, bytePrefix, byteSuffix, byteToDigits, charArray, 0);
        for (int byteIndex = startIndex + 1; byteIndex < endIndex; byteIndex++) {
            charIndex = formatByteAt($this$toHexStringNoLineAndGroupSeparatorSlowPath, byteIndex, bytePrefix, byteSuffix, byteToDigits, charArray, toCharArrayIfNotEmpty(byteSeparator, charArray, charIndex));
        }
        return StringsKt.concatToString(charArray);
    }

    private static final String toHexStringSlowPath(byte[] $this$toHexStringSlowPath, int startIndex, int endIndex, HexFormat.BytesHexFormat bytesFormat, int[] byteToDigits) {
        int indexInLine;
        int indexInGroup;
        int bytesPerLine = bytesFormat.getBytesPerLine();
        int bytesPerGroup = bytesFormat.getBytesPerGroup();
        String bytePrefix = bytesFormat.getBytePrefix();
        String byteSuffix = bytesFormat.getByteSuffix();
        String byteSeparator = bytesFormat.getByteSeparator();
        String groupSeparator = bytesFormat.getGroupSeparator();
        int formatLength = formattedStringLength(endIndex - startIndex, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        char[] charArray = new char[formatLength];
        int charIndex = 0;
        int indexInLine2 = 0;
        int indexInGroup2 = 0;
        int byteIndex = startIndex;
        while (true) {
            if (byteIndex >= endIndex) {
                break;
            }
            if (indexInLine2 == bytesPerLine) {
                charArray[charIndex] = '\n';
                indexInLine = 0;
                indexInGroup = 0;
                charIndex++;
            } else if (indexInGroup2 != bytesPerGroup) {
                indexInLine = indexInLine2;
                indexInGroup = indexInGroup2;
            } else {
                charIndex = toCharArrayIfNotEmpty(groupSeparator, charArray, charIndex);
                indexInLine = indexInLine2;
                indexInGroup = 0;
            }
            if (indexInGroup != 0) {
                charIndex = toCharArrayIfNotEmpty(byteSeparator, charArray, charIndex);
            }
            charIndex = formatByteAt($this$toHexStringSlowPath, byteIndex, bytePrefix, byteSuffix, byteToDigits, charArray, charIndex);
            indexInGroup2 = indexInGroup + 1;
            indexInLine2 = indexInLine + 1;
            byteIndex++;
        }
        if (!(charIndex == formatLength)) {
            throw new IllegalStateException("Check failed.");
        }
        return StringsKt.concatToString(charArray);
    }

    private static final int formatByteAt(byte[] $this$formatByteAt, int index, String bytePrefix, String byteSuffix, int[] byteToDigits, char[] destination, int destinationOffset) {
        int offset = toCharArrayIfNotEmpty(bytePrefix, destination, destinationOffset);
        return toCharArrayIfNotEmpty(byteSuffix, destination, formatByteAt($this$formatByteAt, index, byteToDigits, destination, offset));
    }

    private static final int formatByteAt(byte[] $this$formatByteAt, int index, int[] byteToDigits, char[] destination, int destinationOffset) {
        int byteDigits = byteToDigits[$this$formatByteAt[index] & 255];
        destination[destinationOffset] = (char) (byteDigits >> 8);
        destination[destinationOffset + 1] = (char) (byteDigits & 255);
        return destinationOffset + 2;
    }

    private static final int formattedStringLength(int numberOfBytes, int byteSeparatorLength, int bytePrefixLength, int byteSuffixLength) {
        if (!(numberOfBytes > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        long charsPerByte = bytePrefixLength + 2 + byteSuffixLength + byteSeparatorLength;
        long formatLength = (numberOfBytes * charsPerByte) - byteSeparatorLength;
        return checkFormatLength(formatLength);
    }

    public static final int formattedStringLength(int numberOfBytes, int bytesPerLine, int bytesPerGroup, int groupSeparatorLength, int byteSeparatorLength, int bytePrefixLength, int byteSuffixLength) {
        if (numberOfBytes > 0) {
            int lineSeparators = (numberOfBytes - 1) / bytesPerLine;
            int groupSeparatorsPerLine = (bytesPerLine - 1) / bytesPerGroup;
            int it = numberOfBytes % bytesPerLine;
            if (it == 0) {
                it = bytesPerLine;
            }
            int groupSeparatorsInLastLine = (it - 1) / bytesPerGroup;
            int groupSeparators = (lineSeparators * groupSeparatorsPerLine) + groupSeparatorsInLastLine;
            int byteSeparators = ((numberOfBytes - 1) - lineSeparators) - groupSeparators;
            long formatLength = lineSeparators + (groupSeparators * groupSeparatorLength) + (byteSeparators * byteSeparatorLength) + (numberOfBytes * (bytePrefixLength + 2 + byteSuffixLength));
            return checkFormatLength(formatLength);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final int checkFormatLength(long formatLength) {
        boolean z = false;
        if (0 <= formatLength && formatLength <= 2147483647L) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException("The resulting string length is too big: " + ((Object) ULong.toString-impl(ULong.constructor-impl(formatLength))));
        }
        return (int) formatLength;
    }

    public static final byte[] hexToByteArray(String $this$hexToByteArray, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToByteArray, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToByteArray($this$hexToByteArray, 0, $this$hexToByteArray.length(), format);
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToByteArray(str, hexFormat);
    }

    static /* synthetic */ byte[] hexToByteArray$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToByteArray(str, i, i2, hexFormat);
    }

    private static final byte[] hexToByteArray(String $this$hexToByteArray, int startIndex, int endIndex, HexFormat format) {
        byte[] it;
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$hexToByteArray.length());
        if (startIndex == endIndex) {
            return new byte[0];
        }
        HexFormat.BytesHexFormat bytesFormat = format.getBytes();
        if (bytesFormat.getNoLineAndGroupSeparator$kotlin_stdlib() && (it = hexToByteArrayNoLineAndGroupSeparator($this$hexToByteArray, startIndex, endIndex, bytesFormat)) != null) {
            return it;
        }
        return hexToByteArraySlowPath($this$hexToByteArray, startIndex, endIndex, bytesFormat);
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparator(String $this$hexToByteArrayNoLineAndGroupSeparator, int startIndex, int endIndex, HexFormat.BytesHexFormat bytesFormat) {
        if (bytesFormat.getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib()) {
            return hexToByteArrayShortByteSeparatorNoPrefixAndSuffix($this$hexToByteArrayNoLineAndGroupSeparator, startIndex, endIndex, bytesFormat);
        }
        return hexToByteArrayNoLineAndGroupSeparatorSlowPath($this$hexToByteArrayNoLineAndGroupSeparator, startIndex, endIndex, bytesFormat);
    }

    private static final byte[] hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(String $this$hexToByteArrayShortByteSeparatorNoPrefixAndSuffix, int startIndex, int endIndex, HexFormat.BytesHexFormat bytesFormat) {
        int byteSeparatorLength;
        int byteSeparatorLength2 = bytesFormat.getByteSeparator().length();
        boolean z = false;
        boolean z2 = true;
        if (byteSeparatorLength2 <= 1) {
            int numberOfChars = endIndex - startIndex;
            int charIndex = 0;
            if (byteSeparatorLength2 == 0) {
                if ((numberOfChars & 1) != 0) {
                    return null;
                }
                int numberOfBytes = numberOfChars >> 1;
                byte[] byteArray = new byte[numberOfBytes];
                for (int byteIndex = 0; byteIndex < numberOfBytes; byteIndex++) {
                    byteArray[byteIndex] = parseByteAt($this$hexToByteArrayShortByteSeparatorNoPrefixAndSuffix, charIndex);
                    charIndex += 2;
                }
                return byteArray;
            } else if (numberOfChars % 3 != 2) {
                return null;
            } else {
                int numberOfBytes2 = (numberOfChars / 3) + 1;
                byte[] byteArray2 = new byte[numberOfBytes2];
                char byteSeparatorChar = bytesFormat.getByteSeparator().charAt(0);
                byteArray2[0] = parseByteAt($this$hexToByteArrayShortByteSeparatorNoPrefixAndSuffix, 0);
                int charIndex2 = 0 + 2;
                int byteIndex2 = 1;
                while (byteIndex2 < numberOfBytes2) {
                    if ($this$hexToByteArrayShortByteSeparatorNoPrefixAndSuffix.charAt(charIndex2) == byteSeparatorChar) {
                        byteSeparatorLength = byteSeparatorLength2;
                    } else {
                        String part$iv = bytesFormat.getByteSeparator();
                        boolean ignoreCase$iv = bytesFormat.getIgnoreCase$kotlin_stdlib();
                        int index$iv = charIndex2;
                        if (part$iv.length() == 0 ? z2 : z) {
                            byteSeparatorLength = byteSeparatorLength2;
                        } else {
                            int length = part$iv.length();
                            int i$iv = 0;
                            while (i$iv < length) {
                                int byteSeparatorLength3 = byteSeparatorLength2;
                                int i = length;
                                if (!CharsKt.equals(part$iv.charAt(i$iv), $this$hexToByteArrayShortByteSeparatorNoPrefixAndSuffix.charAt(index$iv + i$iv), ignoreCase$iv)) {
                                    throwNotContainedAt($this$hexToByteArrayShortByteSeparatorNoPrefixAndSuffix, index$iv, endIndex, part$iv, "byte separator");
                                }
                                i$iv++;
                                byteSeparatorLength2 = byteSeparatorLength3;
                                length = i;
                            }
                            byteSeparatorLength = byteSeparatorLength2;
                            part$iv.length();
                        }
                    }
                    byteArray2[byteIndex2] = parseByteAt($this$hexToByteArrayShortByteSeparatorNoPrefixAndSuffix, charIndex2 + 1);
                    charIndex2 += 3;
                    byteIndex2++;
                    byteSeparatorLength2 = byteSeparatorLength;
                    z = false;
                    z2 = true;
                }
                return byteArray2;
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparatorSlowPath(String $this$hexToByteArrayNoLineAndGroupSeparatorSlowPath, int startIndex, int endIndex, HexFormat.BytesHexFormat bytesFormat) {
        int endIndex$iv;
        String bytePrefix;
        String byteSeparator;
        String between;
        int endIndex$iv2;
        String bytePrefix2 = bytesFormat.getBytePrefix();
        String byteSuffix = bytesFormat.getByteSuffix();
        String byteSeparator2 = bytesFormat.getByteSeparator();
        int byteSeparatorLength = byteSeparator2.length();
        long charsPerByte = bytePrefix2.length() + 2 + byteSuffix.length() + byteSeparatorLength;
        long numberOfChars = endIndex - startIndex;
        int numberOfBytes = (int) ((byteSeparatorLength + numberOfChars) / charsPerByte);
        if ((numberOfBytes * charsPerByte) - byteSeparatorLength != numberOfChars) {
            return null;
        }
        boolean ignoreCase = bytesFormat.getIgnoreCase$kotlin_stdlib();
        byte[] byteArray = new byte[numberOfBytes];
        int index$iv = startIndex;
        int endIndex$iv3 = endIndex;
        boolean ignoreCase$iv = ignoreCase;
        if (!(bytePrefix2.length() == 0)) {
            int endIndex$iv4 = bytePrefix2.length();
            int i$iv = 0;
            while (i$iv < endIndex$iv4) {
                int i = endIndex$iv4;
                long numberOfChars2 = numberOfChars;
                boolean ignoreCase$iv2 = ignoreCase$iv;
                if (CharsKt.equals(bytePrefix2.charAt(i$iv), $this$hexToByteArrayNoLineAndGroupSeparatorSlowPath.charAt(index$iv + i$iv), ignoreCase$iv2)) {
                    endIndex$iv = endIndex$iv3;
                } else {
                    endIndex$iv = endIndex$iv3;
                    throwNotContainedAt($this$hexToByteArrayNoLineAndGroupSeparatorSlowPath, index$iv, endIndex$iv, bytePrefix2, "byte prefix");
                }
                i$iv++;
                endIndex$iv3 = endIndex$iv;
                ignoreCase$iv = ignoreCase$iv2;
                endIndex$iv4 = i;
                numberOfChars = numberOfChars2;
            }
            int i$iv2 = bytePrefix2.length();
            index$iv = i$iv2 + index$iv;
        }
        int charIndex = index$iv;
        String between2 = byteSuffix + byteSeparator2 + bytePrefix2;
        int byteIndex = 0;
        int i2 = numberOfBytes - 1;
        while (byteIndex < i2) {
            byteArray[byteIndex] = parseByteAt($this$hexToByteArrayNoLineAndGroupSeparatorSlowPath, charIndex);
            int index$iv2 = charIndex + 2;
            String part$iv = between2;
            int endIndex$iv5 = endIndex;
            if (part$iv.length() == 0) {
                bytePrefix = bytePrefix2;
                byteSeparator = byteSeparator2;
                between = between2;
            } else {
                bytePrefix = bytePrefix2;
                int endIndex$iv6 = part$iv.length();
                byteSeparator = byteSeparator2;
                int i$iv3 = 0;
                while (i$iv3 < endIndex$iv6) {
                    int i3 = endIndex$iv6;
                    String between3 = between2;
                    if (CharsKt.equals(part$iv.charAt(i$iv3), $this$hexToByteArrayNoLineAndGroupSeparatorSlowPath.charAt(index$iv2 + i$iv3), ignoreCase)) {
                        endIndex$iv2 = endIndex$iv5;
                    } else {
                        endIndex$iv2 = endIndex$iv5;
                        throwNotContainedAt($this$hexToByteArrayNoLineAndGroupSeparatorSlowPath, index$iv2, endIndex$iv2, part$iv, "byte suffix + byte separator + byte prefix");
                    }
                    i$iv3++;
                    endIndex$iv5 = endIndex$iv2;
                    endIndex$iv6 = i3;
                    between2 = between3;
                }
                between = between2;
                int i$iv4 = part$iv.length();
                index$iv2 = i$iv4 + index$iv2;
            }
            charIndex = index$iv2;
            byteIndex++;
            byteSeparator2 = byteSeparator;
            bytePrefix2 = bytePrefix;
            between2 = between;
        }
        byteArray[numberOfBytes - 1] = parseByteAt($this$hexToByteArrayNoLineAndGroupSeparatorSlowPath, charIndex);
        int index$iv3 = charIndex + 2;
        if (!(byteSuffix.length() == 0)) {
            int length = byteSuffix.length();
            for (int i$iv5 = 0; i$iv5 < length; i$iv5++) {
                if (!CharsKt.equals(byteSuffix.charAt(i$iv5), $this$hexToByteArrayNoLineAndGroupSeparatorSlowPath.charAt(index$iv3 + i$iv5), ignoreCase)) {
                    throwNotContainedAt($this$hexToByteArrayNoLineAndGroupSeparatorSlowPath, index$iv3, endIndex, byteSuffix, "byte suffix");
                }
            }
            byteSuffix.length();
        }
        return byteArray;
    }

    private static final byte[] hexToByteArraySlowPath(String $this$hexToByteArraySlowPath, int startIndex, int endIndex, HexFormat.BytesHexFormat bytesFormat) {
        int parseMaxSize;
        int bytesPerLine;
        int bytesPerGroup;
        String byteSuffix;
        String groupSeparator;
        String byteSeparator;
        int indexInLine;
        int indexInGroup;
        int indexInLine2;
        int indexInLine3;
        int endIndex$iv;
        String partName$iv;
        int indexInLine4;
        int indexInGroup2;
        String str = $this$hexToByteArraySlowPath;
        int i = endIndex;
        int bytesPerLine2 = bytesFormat.getBytesPerLine();
        int bytesPerGroup2 = bytesFormat.getBytesPerGroup();
        String bytePrefix = bytesFormat.getBytePrefix();
        String byteSuffix2 = bytesFormat.getByteSuffix();
        String byteSeparator2 = bytesFormat.getByteSeparator();
        String groupSeparator2 = bytesFormat.getGroupSeparator();
        boolean ignoreCase = bytesFormat.getIgnoreCase$kotlin_stdlib();
        int charIndex = parsedByteArrayMaxSize(i - startIndex, bytesPerLine2, bytesPerGroup2, groupSeparator2.length(), byteSeparator2.length(), bytePrefix.length(), byteSuffix2.length());
        byte[] byteArray = new byte[charIndex];
        int charIndex2 = startIndex;
        int byteIndex = 0;
        int indexInLine5 = 0;
        int indexInGroup3 = 0;
        while (charIndex2 < i) {
            if (indexInLine5 == bytesPerLine2) {
                charIndex2 = checkNewLineAt(str, charIndex2, i);
                indexInLine = 0;
                indexInGroup3 = 0;
                parseMaxSize = charIndex;
                bytesPerLine = bytesPerLine2;
                bytesPerGroup = bytesPerGroup2;
                byteSuffix = byteSuffix2;
                byteSeparator = byteSeparator2;
                groupSeparator = groupSeparator2;
            } else if (indexInGroup3 == bytesPerGroup2) {
                String byteSuffix3 = $this$hexToByteArraySlowPath;
                int endIndex$iv2 = endIndex;
                int bytesPerGroup3 = charIndex2;
                String partName$iv2 = "group separator";
                boolean ignoreCase$iv = ignoreCase;
                String part$iv = groupSeparator2;
                if (part$iv.length() == 0) {
                    parseMaxSize = charIndex;
                    indexInLine2 = indexInLine5;
                    bytesPerLine = bytesPerLine2;
                    byteSuffix = byteSuffix2;
                    groupSeparator = groupSeparator2;
                    indexInLine3 = bytesPerGroup3;
                    bytesPerGroup = bytesPerGroup2;
                } else {
                    parseMaxSize = charIndex;
                    int endIndex$iv3 = part$iv.length();
                    indexInLine2 = indexInLine5;
                    int indexInLine6 = 0;
                    while (indexInLine6 < endIndex$iv3) {
                        int i2 = endIndex$iv3;
                        int bytesPerLine3 = bytesPerLine2;
                        int bytesPerLine4 = bytesPerGroup3;
                        int index$iv = bytesPerGroup2;
                        String groupSeparator3 = groupSeparator2;
                        String groupSeparator4 = byteSuffix3;
                        String byteSuffix4 = byteSuffix2;
                        boolean ignoreCase$iv2 = ignoreCase$iv;
                        if (CharsKt.equals(part$iv.charAt(indexInLine6), groupSeparator4.charAt(bytesPerLine4 + indexInLine6), ignoreCase$iv2)) {
                            endIndex$iv = endIndex$iv2;
                            partName$iv = partName$iv2;
                        } else {
                            endIndex$iv = endIndex$iv2;
                            partName$iv = partName$iv2;
                            throwNotContainedAt(groupSeparator4, bytesPerLine4, endIndex$iv, part$iv, partName$iv);
                        }
                        indexInLine6++;
                        endIndex$iv2 = endIndex$iv;
                        partName$iv2 = partName$iv;
                        ignoreCase$iv = ignoreCase$iv2;
                        byteSuffix2 = byteSuffix4;
                        bytesPerGroup2 = index$iv;
                        endIndex$iv3 = i2;
                        bytesPerGroup3 = bytesPerLine4;
                        byteSuffix3 = groupSeparator4;
                        bytesPerLine2 = bytesPerLine3;
                        groupSeparator2 = groupSeparator3;
                    }
                    bytesPerLine = bytesPerLine2;
                    groupSeparator = groupSeparator2;
                    int bytesPerLine5 = bytesPerGroup3;
                    bytesPerGroup = bytesPerGroup2;
                    byteSuffix = byteSuffix2;
                    int i$iv = part$iv.length();
                    indexInLine3 = i$iv + bytesPerLine5;
                }
                charIndex2 = indexInLine3;
                indexInGroup3 = 0;
                byteSeparator = byteSeparator2;
                indexInLine = indexInLine2;
            } else {
                parseMaxSize = charIndex;
                int indexInLine7 = indexInLine5;
                bytesPerLine = bytesPerLine2;
                bytesPerGroup = bytesPerGroup2;
                byteSuffix = byteSuffix2;
                groupSeparator = groupSeparator2;
                if (indexInGroup3 != 0) {
                    int index$iv2 = charIndex2;
                    String part$iv2 = byteSeparator2;
                    if (part$iv2.length() == 0) {
                        indexInGroup = indexInGroup3;
                        byteSeparator = byteSeparator2;
                    } else {
                        int charIndex3 = part$iv2.length();
                        indexInGroup = indexInGroup3;
                        int indexInGroup4 = 0;
                        while (indexInGroup4 < charIndex3) {
                            int i3 = charIndex3;
                            String byteSeparator3 = byteSeparator2;
                            if (!CharsKt.equals(part$iv2.charAt(indexInGroup4), $this$hexToByteArraySlowPath.charAt(index$iv2 + indexInGroup4), ignoreCase)) {
                                throwNotContainedAt($this$hexToByteArraySlowPath, index$iv2, endIndex, part$iv2, "byte separator");
                            }
                            indexInGroup4++;
                            charIndex3 = i3;
                            byteSeparator2 = byteSeparator3;
                        }
                        byteSeparator = byteSeparator2;
                        index$iv2 = part$iv2.length() + index$iv2;
                    }
                    charIndex2 = index$iv2;
                    indexInGroup3 = indexInGroup;
                    indexInLine = indexInLine7;
                } else {
                    byteSeparator = byteSeparator2;
                    indexInLine = indexInLine7;
                }
            }
            int indexInLine8 = indexInLine + 1;
            int indexInGroup5 = indexInGroup3 + 1;
            int index$iv3 = charIndex2;
            if (bytePrefix.length() == 0) {
                indexInLine4 = indexInLine8;
                indexInGroup2 = indexInGroup5;
            } else {
                int charIndex4 = bytePrefix.length();
                indexInLine4 = indexInLine8;
                int indexInLine9 = 0;
                while (indexInLine9 < charIndex4) {
                    int i4 = charIndex4;
                    int indexInGroup6 = indexInGroup5;
                    int indexInGroup7 = index$iv3 + indexInLine9;
                    if (!CharsKt.equals(bytePrefix.charAt(indexInLine9), $this$hexToByteArraySlowPath.charAt(indexInGroup7), ignoreCase)) {
                        throwNotContainedAt($this$hexToByteArraySlowPath, index$iv3, endIndex, bytePrefix, "byte prefix");
                    }
                    indexInLine9++;
                    charIndex4 = i4;
                    indexInGroup5 = indexInGroup6;
                }
                indexInGroup2 = indexInGroup5;
                index$iv3 = bytePrefix.length() + index$iv3;
            }
            int charIndex5 = index$iv3;
            if (i - 2 < charIndex5) {
                throwInvalidNumberOfDigits(str, charIndex5, i, "exactly", 2);
            }
            int byteIndex2 = byteIndex + 1;
            byteArray[byteIndex] = parseByteAt(str, charIndex5);
            int index$iv4 = charIndex5 + 2;
            String part$iv3 = byteSuffix;
            if (!(part$iv3.length() == 0)) {
                int length = part$iv3.length();
                for (int i$iv2 = 0; i$iv2 < length; i$iv2++) {
                    if (!CharsKt.equals(part$iv3.charAt(i$iv2), $this$hexToByteArraySlowPath.charAt(index$iv4 + i$iv2), ignoreCase)) {
                        throwNotContainedAt($this$hexToByteArraySlowPath, index$iv4, endIndex, part$iv3, "byte suffix");
                    }
                }
                index$iv4 = part$iv3.length() + index$iv4;
            }
            int i5 = index$iv4;
            i = endIndex;
            byteIndex = byteIndex2;
            byteSuffix2 = byteSuffix;
            indexInLine5 = indexInLine4;
            bytesPerGroup2 = bytesPerGroup;
            byteSeparator2 = byteSeparator;
            indexInGroup3 = indexInGroup2;
            charIndex = parseMaxSize;
            bytesPerLine2 = bytesPerLine;
            groupSeparator2 = groupSeparator;
            charIndex2 = i5;
            str = $this$hexToByteArraySlowPath;
        }
        if (byteIndex == byteArray.length) {
            return byteArray;
        }
        byte[] copyOf = Arrays.copyOf(byteArray, byteIndex);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return copyOf;
    }

    private static final byte parseByteAt(String $this$parseByteAt, int index) {
        int code$iv = $this$parseByteAt.charAt(index);
        if ((code$iv >>> 8) == 0 && HEX_DIGITS_TO_DECIMAL[code$iv] >= 0) {
            int high = HEX_DIGITS_TO_DECIMAL[code$iv];
            int index$iv = index + 1;
            int code$iv2 = $this$parseByteAt.charAt(index$iv);
            if ((code$iv2 >>> 8) == 0 && HEX_DIGITS_TO_DECIMAL[code$iv2] >= 0) {
                int low = HEX_DIGITS_TO_DECIMAL[code$iv2];
                return (byte) ((high << 4) | low);
            }
            throwInvalidDigitAt($this$parseByteAt, index$iv);
            throw new KotlinNothingValueException();
        }
        throwInvalidDigitAt($this$parseByteAt, index);
        throw new KotlinNothingValueException();
    }

    public static final int parsedByteArrayMaxSize(int stringLength, int bytesPerLine, int bytesPerGroup, int groupSeparatorLength, int byteSeparatorLength, int bytePrefixLength, int byteSuffixLength) {
        long j;
        if (!(stringLength > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        long charsPerByte = bytePrefixLength + 2 + byteSuffixLength;
        long charsPerGroup = charsPerSet(charsPerByte, bytesPerGroup, byteSeparatorLength);
        if (bytesPerLine <= bytesPerGroup) {
            j = charsPerSet(charsPerByte, bytesPerLine, byteSeparatorLength);
        } else {
            int groupsPerLine = bytesPerLine / bytesPerGroup;
            long result = charsPerSet(charsPerGroup, groupsPerLine, groupSeparatorLength);
            int bytesPerLastGroupInLine = bytesPerLine % bytesPerGroup;
            if (bytesPerLastGroupInLine != 0) {
                result = result + groupSeparatorLength + charsPerSet(charsPerByte, bytesPerLastGroupInLine, byteSeparatorLength);
            }
            j = result;
        }
        long charsPerLine = j;
        long numberOfChars = stringLength;
        long wholeLines = wholeElementsPerSet(numberOfChars, charsPerLine, 1);
        long numberOfChars2 = numberOfChars - ((charsPerLine + 1) * wholeLines);
        long wholeGroupsInLastLine = wholeElementsPerSet(numberOfChars2, charsPerGroup, groupSeparatorLength);
        long numberOfChars3 = numberOfChars2 - ((groupSeparatorLength + charsPerGroup) * wholeGroupsInLastLine);
        long wholeBytesInLastGroup = wholeElementsPerSet(numberOfChars3, charsPerByte, byteSeparatorLength);
        int spare = numberOfChars3 - ((((long) byteSeparatorLength) + charsPerByte) * wholeBytesInLastGroup) > 0 ? 1 : 0;
        return (int) ((bytesPerLine * wholeLines) + (bytesPerGroup * wholeGroupsInLastLine) + wholeBytesInLastGroup + spare);
    }

    private static final long charsPerSet(long charsPerElement, int elementsPerSet, int elementSeparatorLength) {
        if (!(elementsPerSet > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return (elementsPerSet * charsPerElement) + (elementSeparatorLength * (elementsPerSet - 1));
    }

    private static final long wholeElementsPerSet(long charsPerSet, long charsPerElement, int elementSeparatorLength) {
        if (charsPerSet <= 0 || charsPerElement <= 0) {
            return 0L;
        }
        return (elementSeparatorLength + charsPerSet) / (elementSeparatorLength + charsPerElement);
    }

    private static final int checkNewLineAt(String $this$checkNewLineAt, int index, int endIndex) {
        if ($this$checkNewLineAt.charAt(index) == '\r') {
            return (index + 1 >= endIndex || $this$checkNewLineAt.charAt(index + 1) != '\n') ? index + 1 : index + 2;
        } else if ($this$checkNewLineAt.charAt(index) == '\n') {
            return index + 1;
        } else {
            throw new NumberFormatException("Expected a new line at index " + index + ", but was " + $this$checkNewLineAt.charAt(index));
        }
    }

    public static /* synthetic */ String toHexString$default(byte b, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return toHexString(b, hexFormat);
    }

    public static final String toHexString(byte $this$toHexString, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String digits = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat numberFormat = format.getNumber();
        if (numberFormat.isDigitsOnlyAndNoPadding$kotlin_stdlib()) {
            char[] charArray = {digits.charAt(($this$toHexString >> 4) & 15), digits.charAt($this$toHexString & 15)};
            if (numberFormat.getRemoveLeadingZeros()) {
                return StringsKt.concatToString$default(charArray, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros($this$toHexString & 255) - 24) >> 2, 1), 0, 2, null);
            }
            return StringsKt.concatToString(charArray);
        }
        return toHexStringImpl($this$toHexString, numberFormat, digits, 8);
    }

    public static final byte hexToByte(String $this$hexToByte, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToByte, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToByte($this$hexToByte, 0, $this$hexToByte.length(), format);
    }

    public static /* synthetic */ byte hexToByte$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToByte(str, hexFormat);
    }

    static /* synthetic */ byte hexToByte$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToByte(str, i, i2, hexFormat);
    }

    private static final byte hexToByte(String $this$hexToByte, int startIndex, int endIndex, HexFormat format) {
        return (byte) hexToIntImpl($this$hexToByte, startIndex, endIndex, format, 2);
    }

    public static /* synthetic */ String toHexString$default(short s, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return toHexString(s, hexFormat);
    }

    public static final String toHexString(short $this$toHexString, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String digits = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat numberFormat = format.getNumber();
        if (numberFormat.isDigitsOnlyAndNoPadding$kotlin_stdlib()) {
            char[] charArray = {digits.charAt(($this$toHexString >> 12) & 15), digits.charAt(($this$toHexString >> 8) & 15), digits.charAt(($this$toHexString >> 4) & 15), digits.charAt($this$toHexString & 15)};
            if (numberFormat.getRemoveLeadingZeros()) {
                return StringsKt.concatToString$default(charArray, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(65535 & $this$toHexString) - 16) >> 2, 3), 0, 2, null);
            }
            return StringsKt.concatToString(charArray);
        }
        return toHexStringImpl($this$toHexString, numberFormat, digits, 16);
    }

    public static final short hexToShort(String $this$hexToShort, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToShort, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToShort($this$hexToShort, 0, $this$hexToShort.length(), format);
    }

    public static /* synthetic */ short hexToShort$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToShort(str, hexFormat);
    }

    static /* synthetic */ short hexToShort$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToShort(str, i, i2, hexFormat);
    }

    private static final short hexToShort(String $this$hexToShort, int startIndex, int endIndex, HexFormat format) {
        return (short) hexToIntImpl($this$hexToShort, startIndex, endIndex, format, 4);
    }

    public static /* synthetic */ String toHexString$default(int i, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return toHexString(i, hexFormat);
    }

    public static final String toHexString(int $this$toHexString, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String digits = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat numberFormat = format.getNumber();
        if (numberFormat.isDigitsOnlyAndNoPadding$kotlin_stdlib()) {
            char[] charArray = {digits.charAt(($this$toHexString >> 28) & 15), digits.charAt(($this$toHexString >> 24) & 15), digits.charAt(($this$toHexString >> 20) & 15), digits.charAt(($this$toHexString >> 16) & 15), digits.charAt(($this$toHexString >> 12) & 15), digits.charAt(($this$toHexString >> 8) & 15), digits.charAt(($this$toHexString >> 4) & 15), digits.charAt($this$toHexString & 15)};
            if (numberFormat.getRemoveLeadingZeros()) {
                return StringsKt.concatToString$default(charArray, RangesKt.coerceAtMost(Integer.numberOfLeadingZeros($this$toHexString) >> 2, 7), 0, 2, null);
            }
            return StringsKt.concatToString(charArray);
        }
        return toHexStringImpl($this$toHexString, numberFormat, digits, 32);
    }

    public static final int hexToInt(String $this$hexToInt, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToInt, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToInt($this$hexToInt, 0, $this$hexToInt.length(), format);
    }

    public static /* synthetic */ int hexToInt$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToInt(str, hexFormat);
    }

    public static /* synthetic */ int hexToInt$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToInt(str, i, i2, hexFormat);
    }

    public static final int hexToInt(String $this$hexToInt, int startIndex, int endIndex, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToInt, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToIntImpl($this$hexToInt, startIndex, endIndex, format, 8);
    }

    public static /* synthetic */ String toHexString$default(long j, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return toHexString(j, hexFormat);
    }

    public static final String toHexString(long $this$toHexString, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String digits = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat numberFormat = format.getNumber();
        if (numberFormat.isDigitsOnlyAndNoPadding$kotlin_stdlib()) {
            char[] charArray = {digits.charAt((int) (($this$toHexString >> 60) & 15)), digits.charAt((int) (($this$toHexString >> 56) & 15)), digits.charAt((int) (($this$toHexString >> 52) & 15)), digits.charAt((int) (($this$toHexString >> 48) & 15)), digits.charAt((int) (($this$toHexString >> 44) & 15)), digits.charAt((int) (($this$toHexString >> 40) & 15)), digits.charAt((int) (($this$toHexString >> 36) & 15)), digits.charAt((int) (($this$toHexString >> 32) & 15)), digits.charAt((int) (($this$toHexString >> 28) & 15)), digits.charAt((int) (($this$toHexString >> 24) & 15)), digits.charAt((int) (($this$toHexString >> 20) & 15)), digits.charAt((int) (($this$toHexString >> 16) & 15)), digits.charAt((int) (($this$toHexString >> 12) & 15)), digits.charAt((int) (($this$toHexString >> 8) & 15)), digits.charAt((int) (($this$toHexString >> 4) & 15)), digits.charAt((int) (15 & $this$toHexString))};
            if (numberFormat.getRemoveLeadingZeros()) {
                return StringsKt.concatToString$default(charArray, RangesKt.coerceAtMost(Long.numberOfLeadingZeros($this$toHexString) >> 2, 15), 0, 2, null);
            }
            return StringsKt.concatToString(charArray);
        }
        return toHexStringImpl($this$toHexString, numberFormat, digits, 64);
    }

    public static final long hexToLong(String $this$hexToLong, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToLong, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToLong($this$hexToLong, 0, $this$hexToLong.length(), format);
    }

    public static /* synthetic */ long hexToLong$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToLong(str, hexFormat);
    }

    public static /* synthetic */ long hexToLong$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return hexToLong(str, i, i2, hexFormat);
    }

    public static final long hexToLong(String $this$hexToLong, int startIndex, int endIndex, HexFormat format) {
        Intrinsics.checkNotNullParameter($this$hexToLong, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToLongImpl($this$hexToLong, startIndex, endIndex, format, 16);
    }

    private static final String toHexStringImpl(long $this$toHexStringImpl, HexFormat.NumberHexFormat numberFormat, String digits, int bits) {
        if (!((bits & 3) == 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        long value = $this$toHexStringImpl;
        int typeHexLength = bits >> 2;
        int minLength = numberFormat.getMinLength();
        int pads = RangesKt.coerceAtLeast(minLength - typeHexLength, 0);
        String prefix = numberFormat.getPrefix();
        String suffix = numberFormat.getSuffix();
        boolean removeZeros = numberFormat.getRemoveLeadingZeros();
        long formatLength = prefix.length() + pads + typeHexLength + suffix.length();
        char[] charArray = new char[checkFormatLength(formatLength)];
        int charIndex = toCharArrayIfNotEmpty(prefix, charArray, 0);
        if (pads > 0) {
            ArraysKt.fill(charArray, digits.charAt(0), charIndex, charIndex + pads);
            charIndex += pads;
        }
        int shift = bits;
        int i = 0;
        while (i < typeHexLength) {
            shift -= 4;
            long value2 = value;
            int decimal = (int) ((value >> shift) & 15);
            removeZeros = removeZeros && decimal == 0 && (shift >> 2) >= minLength;
            if (!removeZeros) {
                charArray[charIndex] = digits.charAt(decimal);
                charIndex++;
            }
            i++;
            value = value2;
        }
        int charIndex2 = toCharArrayIfNotEmpty(suffix, charArray, charIndex);
        return charIndex2 == charArray.length ? StringsKt.concatToString(charArray) : StringsKt.concatToString$default(charArray, 0, charIndex2, 1, null);
    }

    private static final int toCharArrayIfNotEmpty(String $this$toCharArrayIfNotEmpty, char[] destination, int destinationOffset) {
        switch ($this$toCharArrayIfNotEmpty.length()) {
            case 0:
                break;
            case 1:
                destination[destinationOffset] = $this$toCharArrayIfNotEmpty.charAt(0);
                break;
            default:
                int length = $this$toCharArrayIfNotEmpty.length();
                Intrinsics.checkNotNull($this$toCharArrayIfNotEmpty, "null cannot be cast to non-null type java.lang.String");
                $this$toCharArrayIfNotEmpty.getChars(0, length, destination, destinationOffset);
                break;
        }
        return $this$toCharArrayIfNotEmpty.length() + destinationOffset;
    }

    private static final int hexToIntImpl(String $this$hexToIntImpl, int startIndex, int endIndex, HexFormat format, int typeHexLength) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$hexToIntImpl.length());
        HexFormat.NumberHexFormat numberFormat = format.getNumber();
        if (numberFormat.isDigitsOnly$kotlin_stdlib()) {
            checkNumberOfDigits($this$hexToIntImpl, startIndex, endIndex, typeHexLength);
            return parseInt($this$hexToIntImpl, startIndex, endIndex);
        }
        String prefix = numberFormat.getPrefix();
        String suffix = numberFormat.getSuffix();
        checkPrefixSuffixNumberOfDigits($this$hexToIntImpl, startIndex, endIndex, prefix, suffix, numberFormat.getIgnoreCase$kotlin_stdlib(), typeHexLength);
        return parseInt($this$hexToIntImpl, prefix.length() + startIndex, endIndex - suffix.length());
    }

    private static final long hexToLongImpl(String $this$hexToLongImpl, int startIndex, int endIndex, HexFormat format, int typeHexLength) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, $this$hexToLongImpl.length());
        HexFormat.NumberHexFormat numberFormat = format.getNumber();
        if (numberFormat.isDigitsOnly$kotlin_stdlib()) {
            checkNumberOfDigits($this$hexToLongImpl, startIndex, endIndex, typeHexLength);
            return parseLong($this$hexToLongImpl, startIndex, endIndex);
        }
        String prefix = numberFormat.getPrefix();
        String suffix = numberFormat.getSuffix();
        checkPrefixSuffixNumberOfDigits($this$hexToLongImpl, startIndex, endIndex, prefix, suffix, numberFormat.getIgnoreCase$kotlin_stdlib(), typeHexLength);
        return parseLong($this$hexToLongImpl, prefix.length() + startIndex, endIndex - suffix.length());
    }

    private static final void checkPrefixSuffixNumberOfDigits(String $this$checkPrefixSuffixNumberOfDigits, int startIndex, int endIndex, String prefix, String suffix, boolean ignoreCase, int typeHexLength) {
        if ((endIndex - startIndex) - prefix.length() <= suffix.length()) {
            throwInvalidPrefixSuffix($this$checkPrefixSuffixNumberOfDigits, startIndex, endIndex, prefix, suffix);
        }
        int index$iv = startIndex;
        if (!(prefix.length() == 0)) {
            int length = prefix.length();
            for (int i$iv = 0; i$iv < length; i$iv++) {
                if (!CharsKt.equals(prefix.charAt(i$iv), $this$checkPrefixSuffixNumberOfDigits.charAt(index$iv + i$iv), ignoreCase)) {
                    throwNotContainedAt($this$checkPrefixSuffixNumberOfDigits, index$iv, endIndex, prefix, "prefix");
                }
            }
            int i$iv2 = prefix.length();
            index$iv = i$iv2 + index$iv;
        }
        int digitsStartIndex = index$iv;
        int digitsEndIndex = endIndex - suffix.length();
        if (!(suffix.length() == 0)) {
            int length2 = suffix.length();
            for (int i$iv3 = 0; i$iv3 < length2; i$iv3++) {
                if (!CharsKt.equals(suffix.charAt(i$iv3), $this$checkPrefixSuffixNumberOfDigits.charAt(digitsEndIndex + i$iv3), ignoreCase)) {
                    throwNotContainedAt($this$checkPrefixSuffixNumberOfDigits, digitsEndIndex, endIndex, suffix, "suffix");
                }
            }
            suffix.length();
        }
        checkNumberOfDigits($this$checkPrefixSuffixNumberOfDigits, digitsStartIndex, digitsEndIndex, typeHexLength);
    }

    private static final void checkNumberOfDigits(String $this$checkNumberOfDigits, int startIndex, int endIndex, int typeHexLength) {
        int digits = endIndex - startIndex;
        if (digits < 1) {
            throwInvalidNumberOfDigits($this$checkNumberOfDigits, startIndex, endIndex, "at least", 1);
        } else if (digits > typeHexLength) {
            checkZeroDigits($this$checkNumberOfDigits, startIndex, (startIndex + digits) - typeHexLength);
        }
    }

    private static final void checkZeroDigits(String $this$checkZeroDigits, int startIndex, int endIndex) {
        for (int index = startIndex; index < endIndex; index++) {
            if ($this$checkZeroDigits.charAt(index) != '0') {
                throw new NumberFormatException("Expected the hexadecimal digit '0' at index " + index + ", but was '" + $this$checkZeroDigits.charAt(index) + "'.\nThe result won't fit the type being parsed.");
            }
        }
    }

    private static final int parseInt(String $this$parseInt, int startIndex, int endIndex) {
        int result = 0;
        for (int i = startIndex; i < endIndex; i++) {
            int i2 = result << 4;
            int index$iv = i;
            int code$iv = $this$parseInt.charAt(index$iv);
            if ((code$iv >>> 8) == 0 && HEX_DIGITS_TO_DECIMAL[code$iv] >= 0) {
                result = i2 | HEX_DIGITS_TO_DECIMAL[code$iv];
            } else {
                throwInvalidDigitAt($this$parseInt, index$iv);
                throw new KotlinNothingValueException();
            }
        }
        return result;
    }

    private static final long parseLong(String $this$parseLong, int startIndex, int endIndex) {
        long result = 0;
        for (int i = startIndex; i < endIndex; i++) {
            long j = result << 4;
            int index$iv = i;
            int code$iv = $this$parseLong.charAt(index$iv);
            if ((code$iv >>> 8) == 0 && HEX_DIGITS_TO_LONG_DECIMAL[code$iv] >= 0) {
                result = j | HEX_DIGITS_TO_LONG_DECIMAL[code$iv];
            } else {
                throwInvalidDigitAt($this$parseLong, index$iv);
                throw new KotlinNothingValueException();
            }
        }
        return result;
    }

    private static final int checkContainsAt(String $this$checkContainsAt, int index, int endIndex, String part, boolean ignoreCase, String partName) {
        if (part.length() == 0) {
            return index;
        }
        int length = part.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt.equals(part.charAt(i), $this$checkContainsAt.charAt(index + i), ignoreCase)) {
                throwNotContainedAt($this$checkContainsAt, index, endIndex, part, partName);
            }
        }
        int i2 = part.length();
        return i2 + index;
    }

    private static final int decimalFromHexDigitAt(String $this$decimalFromHexDigitAt, int index) {
        int code = $this$decimalFromHexDigitAt.charAt(index);
        if ((code >>> 8) == 0 && HEX_DIGITS_TO_DECIMAL[code] >= 0) {
            return HEX_DIGITS_TO_DECIMAL[code];
        }
        throwInvalidDigitAt($this$decimalFromHexDigitAt, index);
        throw new KotlinNothingValueException();
    }

    private static final long longDecimalFromHexDigitAt(String $this$longDecimalFromHexDigitAt, int index) {
        int code = $this$longDecimalFromHexDigitAt.charAt(index);
        if ((code >>> 8) == 0 && HEX_DIGITS_TO_LONG_DECIMAL[code] >= 0) {
            return HEX_DIGITS_TO_LONG_DECIMAL[code];
        }
        throwInvalidDigitAt($this$longDecimalFromHexDigitAt, index);
        throw new KotlinNothingValueException();
    }

    private static final void throwInvalidNumberOfDigits(String $this$throwInvalidNumberOfDigits, int startIndex, int endIndex, String specifier, int expected) {
        Intrinsics.checkNotNull($this$throwInvalidNumberOfDigits, "null cannot be cast to non-null type java.lang.String");
        String substring = $this$throwInvalidNumberOfDigits.substring(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        throw new NumberFormatException("Expected " + specifier + ' ' + expected + " hexadecimal digits at index " + startIndex + ", but was \"" + substring + "\" of length " + (endIndex - startIndex));
    }

    private static final void throwNotContainedAt(String $this$throwNotContainedAt, int index, int endIndex, String part, String partName) {
        int coerceAtMost = RangesKt.coerceAtMost(part.length() + index, endIndex);
        Intrinsics.checkNotNull($this$throwNotContainedAt, "null cannot be cast to non-null type java.lang.String");
        String substring = $this$throwNotContainedAt.substring(index, coerceAtMost);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        throw new NumberFormatException("Expected " + partName + " \"" + part + "\" at index " + index + ", but was " + substring);
    }

    private static final void throwInvalidPrefixSuffix(String $this$throwInvalidPrefixSuffix, int startIndex, int endIndex, String prefix, String suffix) {
        Intrinsics.checkNotNull($this$throwInvalidPrefixSuffix, "null cannot be cast to non-null type java.lang.String");
        String substring = $this$throwInvalidPrefixSuffix.substring(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        throw new NumberFormatException("Expected a hexadecimal number with prefix \"" + prefix + "\" and suffix \"" + suffix + "\", but was " + substring);
    }

    private static final Void throwInvalidDigitAt(String $this$throwInvalidDigitAt, int index) {
        throw new NumberFormatException("Expected a hexadecimal digit at index " + index + ", but was " + $this$throwInvalidDigitAt.charAt(index));
    }
}