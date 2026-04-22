package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversionsJVM.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\u0010\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u000e\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u000f\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\u0001H\u0087\b\u001a\r\u0010\t\u001a\u00020\u0002*\u00020\u0001H\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0005*\u00020\u0001H\u0087\b\u001a\u0015\u0010\n\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\u0004*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\f\u001a\u00020\u0006*\u00020\u0001H\u0087\b\u001a\u0015\u0010\f\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u0001H\u0087\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0001H\u0087\b\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0010*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0016*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0015\u001a\u00020\u0016*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u00020\u0001H\u0007\u001a\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\r\u0010\u0018\u001a\u00020\u0019*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bH\u0087\b\u001a\u000e\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u00020\u0001H\u0007\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bH\u0007\u001a4\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u001f\u001a\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u001e0!H\u0082\b¢\u0006\u0004\b\"\u0010#\u001a\u0015\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0001H\u0002¢\u0006\u0002\b&\u001a \u0010'\u001a\u0004\u0018\u00010\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0083\b¢\u0006\u0002\b*\u001a\u0012\u0010+\u001a\u00020\b*\u00020,H\u0083\b¢\u0006\u0002\b-\u001a\u0012\u0010.\u001a\u00020\b*\u00020,H\u0083\b¢\u0006\u0002\b/\u001a\u0012\u00100\u001a\u00020\u0004*\u00020,H\u0083\b¢\u0006\u0002\b1\u001a6\u00102\u001a\u00020\u0004*\u00020\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b0!H\u0083\b¢\u0006\u0002\b4\u001a6\u00105\u001a\u00020\u0004*\u00020\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b0!H\u0083\b¢\u0006\u0002\b6\u001a>\u00107\u001a\u00020\u0004*\u00020\u00012\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u00108\u001a\u00020\b2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b0!H\u0083\b¢\u0006\u0002\b9¨\u0006:"}, d2 = {"toString", "", "", "radix", "", "", "", "toBoolean", "", "toByte", "toShort", "toInt", "toLong", "toFloat", "", "toDouble", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toBigInteger", "Ljava/math/BigInteger;", "toBigIntegerOrNull", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "screenFloatValue", "T", "str", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "isValidFloat", "s", "isValidFloat$StringsKt__StringNumberConversionsJVMKt", "guessNamedFloatConstant", "start", "endInclusive", "guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt", "isAsciiDigit", "", "isAsciiDigit$StringsKt__StringNumberConversionsJVMKt", "isHexLetter", "isHexLetter$StringsKt__StringNumberConversionsJVMKt", "asciiLetterToLowerCaseCode", "asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt", "advanceWhile", "predicate", "advanceWhile$StringsKt__StringNumberConversionsJVMKt", "backtrackWhile", "backtrackWhile$StringsKt__StringNumberConversionsJVMKt", "advanceAndValidateMantissa", "hexFormat", "advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/text/StringsKt")
public class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    private static final String toString(byte $this$toString, int radix) {
        String num = Integer.toString($this$toString, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return num;
    }

    private static final String toString(short $this$toString, int radix) {
        String num = Integer.toString($this$toString, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return num;
    }

    private static final String toString(int $this$toString, int radix) {
        String num = Integer.toString($this$toString, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return num;
    }

    private static final String toString(long $this$toString, int radix) {
        String l = Long.toString($this$toString, CharsKt.checkRadix(radix));
        Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
        return l;
    }

    private static final boolean toBoolean(String $this$toBoolean) {
        return Boolean.parseBoolean($this$toBoolean);
    }

    private static final byte toByte(String $this$toByte) {
        Intrinsics.checkNotNullParameter($this$toByte, "<this>");
        return Byte.parseByte($this$toByte);
    }

    private static final byte toByte(String $this$toByte, int radix) {
        Intrinsics.checkNotNullParameter($this$toByte, "<this>");
        return Byte.parseByte($this$toByte, CharsKt.checkRadix(radix));
    }

    private static final short toShort(String $this$toShort) {
        Intrinsics.checkNotNullParameter($this$toShort, "<this>");
        return Short.parseShort($this$toShort);
    }

    private static final short toShort(String $this$toShort, int radix) {
        Intrinsics.checkNotNullParameter($this$toShort, "<this>");
        return Short.parseShort($this$toShort, CharsKt.checkRadix(radix));
    }

    private static final int toInt(String $this$toInt) {
        Intrinsics.checkNotNullParameter($this$toInt, "<this>");
        return Integer.parseInt($this$toInt);
    }

    private static final int toInt(String $this$toInt, int radix) {
        Intrinsics.checkNotNullParameter($this$toInt, "<this>");
        return Integer.parseInt($this$toInt, CharsKt.checkRadix(radix));
    }

    private static final long toLong(String $this$toLong) {
        Intrinsics.checkNotNullParameter($this$toLong, "<this>");
        return Long.parseLong($this$toLong);
    }

    private static final long toLong(String $this$toLong, int radix) {
        Intrinsics.checkNotNullParameter($this$toLong, "<this>");
        return Long.parseLong($this$toLong, CharsKt.checkRadix(radix));
    }

    private static final float toFloat(String $this$toFloat) {
        Intrinsics.checkNotNullParameter($this$toFloat, "<this>");
        return Float.parseFloat($this$toFloat);
    }

    private static final double toDouble(String $this$toDouble) {
        Intrinsics.checkNotNullParameter($this$toDouble, "<this>");
        return Double.parseDouble($this$toDouble);
    }

    public static final Float toFloatOrNull(String $this$toFloatOrNull) {
        Intrinsics.checkNotNullParameter($this$toFloatOrNull, "<this>");
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt($this$toFloatOrNull)) {
                return Float.valueOf(Float.parseFloat($this$toFloatOrNull));
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static final Double toDoubleOrNull(String $this$toDoubleOrNull) {
        Intrinsics.checkNotNullParameter($this$toDoubleOrNull, "<this>");
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt($this$toDoubleOrNull)) {
                return Double.valueOf(Double.parseDouble($this$toDoubleOrNull));
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static final BigInteger toBigInteger(String $this$toBigInteger) {
        Intrinsics.checkNotNullParameter($this$toBigInteger, "<this>");
        return new BigInteger($this$toBigInteger);
    }

    private static final BigInteger toBigInteger(String $this$toBigInteger, int radix) {
        Intrinsics.checkNotNullParameter($this$toBigInteger, "<this>");
        return new BigInteger($this$toBigInteger, CharsKt.checkRadix(radix));
    }

    public static final BigInteger toBigIntegerOrNull(String $this$toBigIntegerOrNull) {
        Intrinsics.checkNotNullParameter($this$toBigIntegerOrNull, "<this>");
        return StringsKt.toBigIntegerOrNull($this$toBigIntegerOrNull, 10);
    }

    public static final BigInteger toBigIntegerOrNull(String $this$toBigIntegerOrNull, int radix) {
        Intrinsics.checkNotNullParameter($this$toBigIntegerOrNull, "<this>");
        CharsKt.checkRadix(radix);
        int length = $this$toBigIntegerOrNull.length();
        switch (length) {
            case 0:
                return null;
            case 1:
                if (CharsKt.digitOf($this$toBigIntegerOrNull.charAt(0), radix) < 0) {
                    return null;
                }
                break;
            default:
                int start = $this$toBigIntegerOrNull.charAt(0) == '-' ? 1 : 0;
                for (int index = start; index < length; index++) {
                    if (CharsKt.digitOf($this$toBigIntegerOrNull.charAt(index), radix) < 0) {
                        return null;
                    }
                }
                break;
        }
        return new BigInteger($this$toBigIntegerOrNull, CharsKt.checkRadix(radix));
    }

    private static final BigDecimal toBigDecimal(String $this$toBigDecimal) {
        Intrinsics.checkNotNullParameter($this$toBigDecimal, "<this>");
        return new BigDecimal($this$toBigDecimal);
    }

    private static final BigDecimal toBigDecimal(String $this$toBigDecimal, MathContext mathContext) {
        Intrinsics.checkNotNullParameter($this$toBigDecimal, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal($this$toBigDecimal, mathContext);
    }

    public static final BigDecimal toBigDecimalOrNull(String $this$toBigDecimalOrNull) {
        Intrinsics.checkNotNullParameter($this$toBigDecimalOrNull, "<this>");
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt($this$toBigDecimalOrNull)) {
                return new BigDecimal($this$toBigDecimalOrNull);
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static final BigDecimal toBigDecimalOrNull(String $this$toBigDecimalOrNull, MathContext mathContext) {
        Intrinsics.checkNotNullParameter($this$toBigDecimalOrNull, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        try {
            if (isValidFloat$StringsKt__StringNumberConversionsJVMKt($this$toBigDecimalOrNull)) {
                return new BigDecimal($this$toBigDecimalOrNull, mathContext);
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (!isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return null;
            }
            return function1.invoke(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x00dc, code lost:
        if (r8 == false) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0096 A[EDGE_INSN: B:187:0x0096->B:54:0x0096 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x00d2 A[EDGE_INSN: B:189:0x00d2->B:78:0x00d2 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0091 A[LOOP:2: B:37:0x006b->B:53:0x0091, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00cd A[LOOP:3: B:62:0x00a8->B:77:0x00cd, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final boolean isValidFloat$StringsKt__StringNumberConversionsJVMKt(String s) {
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int endInclusive = s.length() - 1;
        int i2 = 0;
        while (i2 <= endInclusive) {
            char it = s.charAt(i2);
            char it2 = it <= ' ' ? (char) 1 : (char) 0;
            if (it2 == 0) {
                break;
            }
            i2++;
        }
        int start = i2;
        if (start > endInclusive) {
            return false;
        }
        int i3 = endInclusive;
        while (i3 > start) {
            char it3 = s.charAt(i3);
            char it4 = it3 <= ' ' ? (char) 1 : (char) 0;
            if (it4 == 0) {
                break;
            }
            i3--;
        }
        int endInclusive2 = i3;
        if (s.charAt(start) == '+' || s.charAt(start) == '-') {
            start++;
        }
        if (start > endInclusive2) {
            return false;
        }
        boolean isHex = false;
        if (s.charAt(start) == '0') {
            int start2 = start + 1;
            if (start2 > endInclusive2) {
                return true;
            }
            if ((s.charAt(start2) | ' ') == 120) {
                int start3 = start2 + 1;
                int i4 = start3;
                while (i4 <= endInclusive2) {
                    char it5 = s.charAt(i4);
                    if (!(((it5 + 65488) & 65535) < 10)) {
                        if (!((((it5 | ' ') + (-97)) & 65535) < 6)) {
                            z4 = false;
                            if (z4) {
                                break;
                            }
                            i4++;
                        }
                    }
                    z4 = true;
                    if (z4) {
                    }
                }
                boolean z5 = start3 != i4;
                if (i4 <= endInclusive2) {
                    if (s.charAt(i4) == '.') {
                        int i5 = i4 + 1;
                        int i6 = i5;
                        while (i6 <= endInclusive2) {
                            char it6 = s.charAt(i6);
                            if (!(((it6 + 65488) & 65535) < 10)) {
                                if (!((((it6 | ' ') + (-97)) & 65535) < 6)) {
                                    z3 = false;
                                    if (z3) {
                                        break;
                                    }
                                    i6++;
                                }
                            }
                            z3 = true;
                            if (z3) {
                            }
                        }
                        z2 = i5 != i6;
                        i4 = i6;
                    } else {
                        z2 = false;
                    }
                    if (!z5) {
                    }
                    start = i4;
                    if (start != -1 || start > endInclusive2) {
                        return false;
                    }
                    isHex = true;
                }
                i4 = -1;
                start = i4;
                if (start != -1) {
                }
                return false;
            }
            start = start2 - 1;
        }
        if (!isHex) {
            int i7 = start;
            while (i7 <= endInclusive2) {
                char it7 = s.charAt(i7);
                if (!(((it7 + 65488) & 65535) < 10)) {
                    break;
                }
                i7++;
            }
            boolean z6 = start != i7;
            if (i7 <= endInclusive2) {
                if (s.charAt(i7) == '.') {
                    int i8 = i7 + 1;
                    i = i8;
                    while (i <= endInclusive2) {
                        char it8 = s.charAt(i);
                        if (!(((it8 + 65488) & 65535) < 10)) {
                            break;
                        }
                        i++;
                    }
                    z = i8 != i;
                } else {
                    i = i7;
                    z = false;
                }
                if (z6 || z) {
                    i7 = i;
                } else {
                    String str = endInclusive2 == (i + 3) - 1 ? "NaN" : endInclusive2 == (i + 8) - 1 ? "Infinity" : null;
                    i7 = (str != null && StringsKt.indexOf((CharSequence) s, str, i, false) == i) ? endInclusive2 + 1 : -1;
                }
            }
            start = i7;
            if (start == -1) {
                return false;
            }
            if (start > endInclusive2) {
                return true;
            }
        }
        int start4 = start + 1;
        int l = s.charAt(start) | 32;
        if (l != (isHex ? 112 : 101)) {
            return !isHex && (l == 102 || l == 100) && start4 > endInclusive2;
        } else if (start4 > endInclusive2) {
            return false;
        } else {
            if ((s.charAt(start4) == '+' || s.charAt(start4) == '-') && (start4 = start4 + 1) > endInclusive2) {
                return false;
            }
            int i9 = start4;
            while (i9 <= endInclusive2) {
                char it9 = s.charAt(i9);
                if (!(((it9 + 65488) & 65535) < 10)) {
                    break;
                }
                i9++;
            }
            int start5 = i9;
            if (start5 > endInclusive2) {
                return true;
            }
            if (start5 == endInclusive2) {
                int l2 = s.charAt(start5) | ' ';
                return l2 == 102 || l2 == 100;
            }
            return false;
        }
    }

    private static final String guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt(int start, int endInclusive) {
        if (endInclusive == (start + 3) - 1) {
            return "NaN";
        }
        if (endInclusive == (start + 8) - 1) {
            return "Infinity";
        }
        return null;
    }

    private static final boolean isAsciiDigit$StringsKt__StringNumberConversionsJVMKt(char $this$isAsciiDigit) {
        return (($this$isAsciiDigit + 65488) & 65535) < 10;
    }

    private static final boolean isHexLetter$StringsKt__StringNumberConversionsJVMKt(char $this$isHexLetter) {
        return ((($this$isHexLetter | ' ') + (-97)) & 65535) < 6;
    }

    private static final int asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt(char $this$asciiLetterToLowerCaseCode) {
        return $this$asciiLetterToLowerCaseCode | ' ';
    }

    private static final int advanceWhile$StringsKt__StringNumberConversionsJVMKt(String $this$advanceWhile, int start, int endInclusive, Function1<? super Character, Boolean> function1) {
        int start2 = start;
        while (start2 <= endInclusive && function1.invoke(Character.valueOf($this$advanceWhile.charAt(start2))).booleanValue()) {
            start2++;
        }
        return start2;
    }

    private static final int backtrackWhile$StringsKt__StringNumberConversionsJVMKt(String $this$backtrackWhile, int start, int endInclusive, Function1<? super Character, Boolean> function1) {
        int endInclusive2 = endInclusive;
        while (endInclusive2 > start && function1.invoke(Character.valueOf($this$backtrackWhile.charAt(endInclusive2))).booleanValue()) {
            endInclusive2--;
        }
        return endInclusive2;
    }

    private static final int advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt(String $this$advanceAndValidateMantissa, int start, int endInclusive, boolean hexFormat, Function1<? super Character, Boolean> function1) {
        int i = start;
        while (i <= endInclusive && function1.invoke(Character.valueOf($this$advanceAndValidateMantissa.charAt(i))).booleanValue()) {
            i++;
        }
        int start2 = i;
        boolean hasIntegerPart = start != start2;
        if (start2 > endInclusive) {
            if (hexFormat) {
                return -1;
            }
            return start2;
        }
        boolean hasFractionalPart = false;
        if ($this$advanceAndValidateMantissa.charAt(start2) == '.') {
            int start3 = start2 + 1;
            int i2 = start3;
            while (i2 <= endInclusive && function1.invoke(Character.valueOf($this$advanceAndValidateMantissa.charAt(i2))).booleanValue()) {
                i2++;
            }
            start2 = i2;
            hasFractionalPart = start3 != start2;
        }
        if (!hasIntegerPart && !hasFractionalPart) {
            if (hexFormat) {
                return -1;
            }
            String constant = endInclusive == (start2 + 3) - 1 ? "NaN" : endInclusive == (start2 + 8) - 1 ? "Infinity" : null;
            if (constant != null && StringsKt.indexOf((CharSequence) $this$advanceAndValidateMantissa, constant, start2, false) == start2) {
                return endInclusive + 1;
            }
            return -1;
        }
        return start2;
    }
}