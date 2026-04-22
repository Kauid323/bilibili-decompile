package kntr.base.localization.preview;

import java.util.List;
import java.util.ListIterator;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.localization.Locale;
import kntr.base.localization.Localization;
import kntr.base.localization.preview.Units;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LegacyNumberFormat.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a&\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u0010*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0003H\u0002\u001a$\u0010 \u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0015\u0010!\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\"\u001a\u00020\u000eH\u0082\u0002\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\"\u001a\u00020\u000eH\u0082\u0002\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\"\u001a\u00020\u000eH\u0082\u0002\u001aj\u0010%\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\"\b\u0002\u0010(\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001fH\u0002\u001a\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u001bH\u0002\"\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"(\u0010\u000f\u001a\u00020\u0003*\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"(\u0010\u0013\u001a\u00020\u000e*\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015*$\b\u0002\u0010\f\"\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\r2\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\r*(\b\u0002\u0010\u0017\"\b\u0012\u0004\u0012\u0002`\u00100\u00182\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u00100\u0018*<\b\u0002\u0010\u0019\"\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001a0\u001a2\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001a0\u001a*0\b\u0002\u0010\u001c\"\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001d0\u001a2\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001d0\u001a*X\b\u0002\u0010\u001e\"(\u0012\u0004\u0012\u00020\u000e\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f0\u001a2(\u0012\u0004\u0012\u00020\u000e\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f0\u001a¨\u0006*"}, d2 = {"formatNumber", "", WatchLaterReporterKt.KEY_NUM, "", "digits", "", "trimEnd", "", "DefaultNumberFormat", "Lkntr/base/localization/preview/NumberFormat;", "getDefaultNumberFormat", "()Lkntr/base/localization/preview/NumberFormat;", "Threshold", "Lkotlin/Pair;", "Lkntr/base/localization/preview/Units;", "limit", "Lkntr/base/localization/preview/Threshold;", "getLimit", "(Lkotlin/Pair;)J", "units", "getUnits", "(Lkotlin/Pair;)Lkntr/base/localization/preview/Units;", "toThreshold", "Thresholds", "", "Rounding", "Lkotlin/Function1;", "", "Suffix", "Lkotlin/Function0;", "Carry", "Lkotlin/Function3;", "format", "times", "other", "div", "rem", "formatWithUnit", "rounding", "suffix", "carry", "realRound", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LegacyNumberFormatKt {
    public static final /* synthetic */ double access$realRound(double num) {
        return realRound(num);
    }

    public static final String formatNumber(long num, int digits, boolean trimEnd) {
        return format(getDefaultNumberFormat(), num, digits, trimEnd);
    }

    public static final String formatNumber(int num, int digits, boolean trimEnd) {
        return format(getDefaultNumberFormat(), num, digits, trimEnd);
    }

    private static final NumberFormat getDefaultNumberFormat() {
        Locale current = Localization.INSTANCE.getCurrent();
        return Intrinsics.areEqual(current, Locale.Companion.getTRADITIONAL_CHINESE()) ? TraditionalChineseNumberFormat.INSTANCE : Intrinsics.areEqual(current, Locale.Companion.getENGLISH()) ? EnglishNumberFormat.INSTANCE : Intrinsics.areEqual(current, Locale.Companion.getJAPANESE()) ? JapaneseNumberFormat.INSTANCE : Intrinsics.areEqual(current, Locale.Companion.getTHAI()) ? ThaiNumberFormat.INSTANCE : Intrinsics.areEqual(current, Locale.Companion.getARABIC()) ? ArabicNumberFormat.INSTANCE : SimplifiedChineseNumberFormat.INSTANCE;
    }

    private static final long getLimit(Pair<Long, ? extends Units> pair) {
        return pair.getFirst().longValue();
    }

    private static final Units getUnits(Pair<Long, ? extends Units> pair) {
        return pair.getSecond();
    }

    public static final Pair<Long, Units> toThreshold(Units $this$toThreshold, long limit) {
        return TuplesKt.to(Long.valueOf(limit), $this$toThreshold);
    }

    public static /* synthetic */ Pair toThreshold$default(Units units, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = units.getValue();
        }
        return toThreshold(units, j);
    }

    public static final String format(NumberFormat $this$format, long num, int digits, boolean trimEnd) {
        Object element$iv;
        Units.Ones units;
        boolean z;
        long abs = Math.abs(num);
        List $this$lastOrNull$iv = $this$format.getThresholds();
        ListIterator iterator$iv = $this$lastOrNull$iv.listIterator($this$lastOrNull$iv.size());
        while (true) {
            if (iterator$iv.hasPrevious()) {
                element$iv = iterator$iv.previous();
                Pair it = (Pair) element$iv;
                if (abs >= getLimit(it)) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        Pair<Long, Units> pair = (Pair) element$iv;
        if (pair == null || (units = getUnits(pair)) == null) {
            units = Units.Ones.INSTANCE;
        }
        Function1 function1 = (Function1) $this$format.getRounding().invoke(Long.valueOf(num));
        Function0 function0 = (Function0) $this$format.getSuffix().invoke(units);
        Function1<Units, Function3<Long, Integer, Boolean, String>> mo1632getCarry = $this$format.mo1632getCarry();
        return formatWithUnit(num, units, digits, trimEnd, function1, function0, mo1632getCarry != null ? (Function3) mo1632getCarry.invoke(units) : null);
    }

    private static final long times(long $this$times, Units other) {
        return other.getValue() * $this$times;
    }

    private static final long div(long $this$div, Units other) {
        return $this$div / other.getValue();
    }

    private static final long rem(long $this$rem, Units other) {
        return $this$rem % other.getValue();
    }

    static /* synthetic */ String formatWithUnit$default(long j, Units units, int i, boolean z, Function1 function1, Function0 function0, Function3 function3, int i2, Object obj) {
        Function3 function32;
        if ((i2 & 32) == 0) {
            function32 = function3;
        } else {
            function32 = null;
        }
        return formatWithUnit(j, units, i, z, function1, function0, function32);
    }

    private static final String formatWithUnit(long $this$formatWithUnit, Units units, int digits, boolean trimEnd, Function1<? super Double, Double> function1, Function0<String> function0, Function3<? super Long, ? super Integer, ? super Boolean, String> function3) {
        String it;
        boolean isNegative = $this$formatWithUnit < 0;
        long abs = Math.abs($this$formatWithUnit);
        int fixedDigits = Math.max(digits, 0);
        long div = div(abs, units);
        long rem = rem(abs, units);
        if (rem == 0) {
            it = (trimEnd || fixedDigits == 0) ? String.valueOf(div) : div + "." + StringsKt.repeat("0", fixedDigits);
        } else {
            if (fixedDigits >= 0 && fixedDigits < units.getExponent()) {
                double scaleFactor = Math.pow(10.0d, fixedDigits);
                double scaledRem = (rem * scaleFactor) / units.getValue();
                double roundedRem = ((Number) function1.invoke(Double.valueOf(scaledRem))).doubleValue();
                if (roundedRem >= scaleFactor) {
                    if (function3 != null) {
                        return (String) function3.invoke(Long.valueOf(times(div + 1, units) * (isNegative ? -1 : 1)), Integer.valueOf(fixedDigits), Boolean.valueOf(trimEnd));
                    } else if (trimEnd || fixedDigits == 0) {
                        it = String.valueOf(div + 1);
                    } else {
                        it = (div + 1) + "." + StringsKt.repeat("0", fixedDigits);
                    }
                } else if (fixedDigits == 0) {
                    it = String.valueOf(div);
                } else {
                    it = trimEnd ? StringsKt.trimEnd(StringsKt.trimEnd(div + "." + StringsKt.padStart(String.valueOf((long) roundedRem), fixedDigits, '0'), new char[]{'0'}), new char[]{'.'}) : div + "." + StringsKt.padStart(String.valueOf((long) roundedRem), fixedDigits, '0');
                }
            } else if (fixedDigits == 0) {
                it = String.valueOf(div);
            } else {
                it = trimEnd ? StringsKt.trimEnd(StringsKt.trimEnd(div + "." + StringsKt.padStart(String.valueOf(rem), units.getExponent(), '0'), new char[]{'0'}), new char[]{'.'}) : div + "." + StringsKt.padEnd(StringsKt.padStart(String.valueOf(rem), units.getExponent(), '0'), fixedDigits, '0');
            }
        }
        return (isNegative ? "-" : "") + it + function0.invoke();
    }

    public static final double realRound(double num) {
        double floor = Math.floor(num);
        double ceil = Math.ceil(num);
        if (ceil - num == num - floor) {
            return ceil;
        }
        return Math.rint(num);
    }
}