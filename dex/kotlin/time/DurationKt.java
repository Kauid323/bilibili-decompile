package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Marker;

/* compiled from: Duration.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0015\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001d\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0015\u001a\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a)\u0010\u0017\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001aH\u0082\b\u001a)\u0010\u001c\u001a\u00020\u0002*\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001aH\u0082\b\u001a\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002\u001a\u0010\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002\u001a\u0015\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u0015\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u001d\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010-\u001a\u0015\u0010.\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\u001a\u0015\u0010/\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'\"\u000e\u0010\u001d\u001a\u00020\u0002X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"toDuration", "Lkotlin/time/Duration;", "", "unit", "Lkotlin/time/DurationUnit;", "(ILkotlin/time/DurationUnit;)J", "", "(JLkotlin/time/DurationUnit;)J", "", "(DLkotlin/time/DurationUnit;)J", "times", "duration", "times-mvk6XK0", "(IJ)J", "times-kIfJnKk", "(DJ)J", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "substringWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "skipWhile", "NANOS_IN_MILLIS", "MAX_NANOS", "MAX_MILLIS", "MAX_NANOS_IN_MILLIS", "nanosToMillis", "nanos", "millisToNanos", "millis", "durationOfNanos", "normalNanos", "(J)J", "durationOfMillis", "normalMillis", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfNanosNormalized", "durationOfMillisNormalized", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    public static final long toDuration(int $this$toDuration, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit.compareTo(DurationUnit.SECONDS) <= 0) {
            return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow($this$toDuration, unit, DurationUnit.NANOSECONDS));
        }
        return toDuration($this$toDuration, unit);
    }

    public static final long toDuration(long $this$toDuration, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long maxNsInUnit = DurationUnitKt.convertDurationUnitOverflow(MAX_NANOS, DurationUnit.NANOSECONDS, unit);
        boolean z = false;
        if ((-maxNsInUnit) <= $this$toDuration && $this$toDuration <= maxNsInUnit) {
            z = true;
        }
        if (z) {
            return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow($this$toDuration, unit, DurationUnit.NANOSECONDS));
        }
        long millis = DurationUnitKt.convertDurationUnit($this$toDuration, unit, DurationUnit.MILLISECONDS);
        return durationOfMillis(RangesKt.coerceIn(millis, -4611686018427387903L, (long) MAX_MILLIS));
    }

    public static final long toDuration(double $this$toDuration, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        double valueInNs = DurationUnitKt.convertDurationUnit($this$toDuration, unit, DurationUnit.NANOSECONDS);
        if (Double.isNaN(valueInNs)) {
            throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
        }
        long nanos = MathKt.roundToLong(valueInNs);
        boolean z = false;
        if (-4611686018426999999L <= nanos && nanos < 4611686018427000000L) {
            z = true;
        }
        if (z) {
            long millis = durationOfNanos(nanos);
            return millis;
        }
        long millis2 = MathKt.roundToLong(DurationUnitKt.convertDurationUnit($this$toDuration, unit, DurationUnit.MILLISECONDS));
        return durationOfMillisNormalized(millis2);
    }

    /* renamed from: times-mvk6XK0 */
    private static final long m1342timesmvk6XK0(int $this$times_u2dmvk6XK0, long j) {
        return Duration.m1276timesUwyO8pc(j, $this$times_u2dmvk6XK0);
    }

    /* renamed from: times-kIfJnKk */
    private static final long m1341timeskIfJnKk(double $this$times_u2dkIfJnKk, long j) {
        return Duration.m1275timesUwyO8pc(j, $this$times_u2dkIfJnKk);
    }

    /* JADX WARN: Removed duplicated region for block: B:268:0x00c2 A[LOOP:1: B:252:0x0081->B:268:0x00c2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x029e A[LOOP:4: B:338:0x0273->B:354:0x029e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:415:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:430:0x02a7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long parseDuration(String value, boolean strictIso) {
        int index;
        boolean isNegative;
        int length;
        boolean allowSpaces;
        boolean z;
        boolean isNegative2;
        String nonDigitSymbols;
        int length2;
        String infinityString;
        boolean hasSign;
        int length3;
        int length4 = value.length();
        if (length4 == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        long result = Duration.Companion.m1336getZEROUwyO8pc();
        String infinityString2 = "Infinity";
        switch (value.charAt(0)) {
            case '+':
            case '-':
                int index2 = 0 + 1;
                index = index2;
                break;
            case ',':
            default:
                index = 0;
                break;
        }
        boolean hasSign2 = index > 0;
        boolean isNegative3 = hasSign2 && StringsKt.startsWith$default((CharSequence) value, '-', false, 2, (Object) null);
        if (length4 <= index) {
            throw new IllegalArgumentException("No components");
        }
        if (value.charAt(index) == 'P') {
            int index3 = index + 1;
            if (index3 == length4) {
                throw new IllegalArgumentException();
            }
            String nonDigitSymbols2 = "+-.";
            boolean isTimeComponent = false;
            DurationUnit prevUnit = null;
            while (index3 < length4) {
                if (value.charAt(index3) == 'T') {
                    if (isTimeComponent || (index3 = index3 + 1) == length4) {
                        throw new IllegalArgumentException();
                    }
                    isTimeComponent = true;
                } else {
                    int startIndex$iv = index3;
                    String $this$skipWhile$iv$iv = value;
                    int i$iv$iv = startIndex$iv;
                    while (true) {
                        isNegative2 = isNegative3;
                        if (i$iv$iv < $this$skipWhile$iv$iv.length()) {
                            String $this$skipWhile$iv$iv2 = $this$skipWhile$iv$iv;
                            hasSign = hasSign2;
                            char it = $this$skipWhile$iv$iv2.charAt(i$iv$iv);
                            if ('0' <= it && it < ':') {
                                nonDigitSymbols = nonDigitSymbols2;
                                length2 = length4;
                                infinityString = infinityString2;
                            } else {
                                nonDigitSymbols = nonDigitSymbols2;
                                length2 = length4;
                                infinityString = infinityString2;
                                if (!StringsKt.contains$default((CharSequence) nonDigitSymbols2, it, false, 2, (Object) null)) {
                                    length3 = 0;
                                    if (length3 == 0) {
                                        i$iv$iv++;
                                        infinityString2 = infinityString;
                                        length4 = length2;
                                        hasSign2 = hasSign;
                                        isNegative3 = isNegative2;
                                        $this$skipWhile$iv$iv = $this$skipWhile$iv$iv2;
                                        nonDigitSymbols2 = nonDigitSymbols;
                                    }
                                }
                            }
                            length3 = 1;
                            if (length3 == 0) {
                            }
                        } else {
                            nonDigitSymbols = nonDigitSymbols2;
                            length2 = length4;
                            infinityString = infinityString2;
                            hasSign = hasSign2;
                        }
                    }
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type java.lang.String");
                    String component = value.substring(startIndex$iv, i$iv$iv);
                    Intrinsics.checkNotNullExpressionValue(component, "substring(...)");
                    if (component.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int index4 = index3 + component.length();
                    String str = value;
                    if (!(index4 >= 0 && index4 < str.length())) {
                        throw new IllegalArgumentException("Missing unit for value " + component);
                    }
                    char unitChar = str.charAt(index4);
                    index3 = index4 + 1;
                    DurationUnit unit = DurationUnitKt.durationUnitByIsoChar(unitChar, isTimeComponent);
                    DurationUnit prevUnit2 = prevUnit;
                    if (prevUnit2 != null && prevUnit2.compareTo(unit) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    prevUnit = unit;
                    int dotIndex = StringsKt.indexOf$default((CharSequence) component, (char) FilenameUtils.EXTENSION_SEPARATOR, 0, false, 6, (Object) null);
                    if (unit == DurationUnit.SECONDS && dotIndex > 0) {
                        Intrinsics.checkNotNull(component, "null cannot be cast to non-null type java.lang.String");
                        String whole = component.substring(0, dotIndex);
                        Intrinsics.checkNotNullExpressionValue(whole, "substring(...)");
                        long result2 = Duration.m1274plusLRDsOJo(result, toDuration(parseOverLongIsoComponent(whole), unit));
                        Intrinsics.checkNotNull(component, "null cannot be cast to non-null type java.lang.String");
                        String substring = component.substring(dotIndex);
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        result = Duration.m1274plusLRDsOJo(result2, toDuration(Double.parseDouble(substring), unit));
                        isTimeComponent = isTimeComponent;
                        infinityString2 = infinityString;
                        length4 = length2;
                        hasSign2 = hasSign;
                        isNegative3 = isNegative2;
                        nonDigitSymbols2 = nonDigitSymbols;
                    } else {
                        result = Duration.m1274plusLRDsOJo(result, toDuration(parseOverLongIsoComponent(component), unit));
                        isTimeComponent = isTimeComponent;
                        infinityString2 = infinityString;
                        length4 = length2;
                        hasSign2 = hasSign;
                        isNegative3 = isNegative2;
                        nonDigitSymbols2 = nonDigitSymbols;
                    }
                }
            }
            isNegative = isNegative3;
        } else {
            isNegative = isNegative3;
            if (!strictIso) {
                if (StringsKt.regionMatches(value, index, "Infinity", 0, Math.max(length4 - index, "Infinity".length()), true)) {
                    result = Duration.Companion.m1334getINFINITEUwyO8pc();
                } else {
                    DurationUnit prevUnit3 = null;
                    boolean afterFirst = false;
                    boolean allowSpaces2 = !hasSign2;
                    if (hasSign2 && value.charAt(index) == '(' && StringsKt.last(value) == ')') {
                        allowSpaces2 = true;
                        index++;
                        length = length4 - 1;
                        if (index == length) {
                            throw new IllegalArgumentException("No components");
                        }
                    } else {
                        length = length4;
                    }
                    while (index < length) {
                        if (afterFirst && allowSpaces2) {
                            int i$iv = index;
                            while (i$iv < value.length()) {
                                boolean afterFirst2 = afterFirst;
                                if (value.charAt(i$iv) == ' ') {
                                    i$iv++;
                                    afterFirst = afterFirst2;
                                } else {
                                    index = i$iv;
                                }
                            }
                            index = i$iv;
                        }
                        int startIndex$iv2 = index;
                        boolean z2 = false;
                        int i$iv$iv2 = startIndex$iv2;
                        while (true) {
                            allowSpaces = allowSpaces2;
                            if (i$iv$iv2 < value.length()) {
                                char it2 = value.charAt(i$iv$iv2);
                                boolean z3 = z2;
                                if ('0' <= it2 && it2 < ':') {
                                    z = true;
                                    if (((!z || it2 == '.') ? (char) 1 : (char) 0) == 0) {
                                        i$iv$iv2++;
                                        allowSpaces2 = allowSpaces;
                                        z2 = z3;
                                    }
                                }
                                z = false;
                                if (((!z || it2 == '.') ? (char) 1 : (char) 0) == 0) {
                                }
                            }
                        }
                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type java.lang.String");
                        String component2 = value.substring(startIndex$iv2, i$iv$iv2);
                        Intrinsics.checkNotNullExpressionValue(component2, "substring(...)");
                        if (component2.length() == 0) {
                            throw new IllegalArgumentException();
                        }
                        int index5 = index + component2.length();
                        int startIndex$iv$iv = index5;
                        int $i$f$substringWhile = startIndex$iv$iv;
                        while (true) {
                            int startIndex$iv$iv2 = startIndex$iv$iv;
                            if ($i$f$substringWhile < value.length()) {
                                char it3 = value.charAt($i$f$substringWhile);
                                if ((('a' > it3 || it3 >= '{') ? (char) 0 : (char) 1) != 0) {
                                    $i$f$substringWhile++;
                                    startIndex$iv$iv = startIndex$iv$iv2;
                                }
                            }
                        }
                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type java.lang.String");
                        String unitName = value.substring(index5, $i$f$substringWhile);
                        Intrinsics.checkNotNullExpressionValue(unitName, "substring(...)");
                        index = index5 + unitName.length();
                        DurationUnit unit2 = DurationUnitKt.durationUnitByShortName(unitName);
                        if (prevUnit3 != null && prevUnit3.compareTo(unit2) <= 0) {
                            throw new IllegalArgumentException("Unexpected order of duration components");
                        }
                        prevUnit3 = unit2;
                        int dotIndex2 = StringsKt.indexOf$default((CharSequence) component2, (char) FilenameUtils.EXTENSION_SEPARATOR, 0, false, 6, (Object) null);
                        if (dotIndex2 <= 0) {
                            result = Duration.m1274plusLRDsOJo(result, toDuration(Long.parseLong(component2), unit2));
                            afterFirst = true;
                            allowSpaces2 = allowSpaces;
                        } else {
                            Intrinsics.checkNotNull(component2, "null cannot be cast to non-null type java.lang.String");
                            String whole2 = component2.substring(0, dotIndex2);
                            Intrinsics.checkNotNullExpressionValue(whole2, "substring(...)");
                            long result3 = Duration.m1274plusLRDsOJo(result, toDuration(Long.parseLong(whole2), unit2));
                            Intrinsics.checkNotNull(component2, "null cannot be cast to non-null type java.lang.String");
                            String substring2 = component2.substring(dotIndex2);
                            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                            result = Duration.m1274plusLRDsOJo(result3, toDuration(Double.parseDouble(substring2), unit2));
                            if (index < length) {
                                throw new IllegalArgumentException("Fractional component must be last");
                            }
                            afterFirst = true;
                            allowSpaces2 = allowSpaces;
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        return isNegative ? Duration.m1289unaryMinusUwyO8pc(result) : result;
    }

    private static final long parseOverLongIsoComponent(String value) {
        int length = value.length();
        int startIndex = 0;
        boolean z = false;
        if (length > 0 && StringsKt.contains$default((CharSequence) "+-", value.charAt(0), false, 2, (Object) null)) {
            startIndex = 0 + 1;
        }
        if (length - startIndex > 16) {
            int firstNonZero = startIndex;
            int index = startIndex;
            while (true) {
                if (index < length) {
                    char charAt = value.charAt(index);
                    if (charAt != '0') {
                        if (!('1' <= charAt && charAt < ':')) {
                            break;
                        }
                    } else if (firstNonZero == index) {
                        firstNonZero++;
                    }
                    index++;
                } else {
                    int index2 = length - firstNonZero;
                    if (index2 > 16) {
                        if (value.charAt(0) == '-') {
                            return Long.MIN_VALUE;
                        }
                        return LongCompanionObject.MAX_VALUE;
                    }
                }
            }
        }
        if (StringsKt.startsWith$default(value, Marker.ANY_NON_NULL_MARKER, false, 2, (Object) null) && length > 1) {
            char charAt2 = value.charAt(1);
            if ('0' <= charAt2 && charAt2 < ':') {
                z = true;
            }
            if (z) {
                return Long.parseLong(StringsKt.drop(value, 1));
            }
        }
        return Long.parseLong(value);
    }

    private static final String substringWhile(String $this$substringWhile, int startIndex, Function1<? super Character, Boolean> function1) {
        int i$iv = startIndex;
        while (i$iv < $this$substringWhile.length() && function1.invoke(Character.valueOf($this$substringWhile.charAt(i$iv))).booleanValue()) {
            i$iv++;
        }
        Intrinsics.checkNotNull($this$substringWhile, "null cannot be cast to non-null type java.lang.String");
        String substring = $this$substringWhile.substring(startIndex, i$iv);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    private static final int skipWhile(String $this$skipWhile, int startIndex, Function1<? super Character, Boolean> function1) {
        int i = startIndex;
        while (i < $this$skipWhile.length() && function1.invoke(Character.valueOf($this$skipWhile.charAt(i))).booleanValue()) {
            i++;
        }
        return i;
    }

    public static final long nanosToMillis(long nanos) {
        return nanos / 1000000;
    }

    public static final long millisToNanos(long millis) {
        return 1000000 * millis;
    }

    public static final long durationOfNanos(long normalNanos) {
        return Duration.m1245constructorimpl(normalNanos << 1);
    }

    public static final long durationOfMillis(long normalMillis) {
        return Duration.m1245constructorimpl((normalMillis << 1) + 1);
    }

    public static final long durationOf(long normalValue, int unitDiscriminator) {
        return Duration.m1245constructorimpl((normalValue << 1) + unitDiscriminator);
    }

    public static final long durationOfNanosNormalized(long nanos) {
        boolean z = false;
        if (-4611686018426999999L <= nanos && nanos < 4611686018427000000L) {
            z = true;
        }
        if (z) {
            return durationOfNanos(nanos);
        }
        return durationOfMillis(nanosToMillis(nanos));
    }

    public static final long durationOfMillisNormalized(long millis) {
        boolean z = false;
        if (-4611686018426L <= millis && millis < 4611686018427L) {
            z = true;
        }
        if (z) {
            return durationOfNanos(millisToNanos(millis));
        }
        return durationOfMillis(RangesKt.coerceIn(millis, -4611686018427387903L, (long) MAX_MILLIS));
    }
}