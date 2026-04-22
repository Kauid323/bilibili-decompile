package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;

/* compiled from: NumberFormat.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001ad\u0010\r\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\"\b\u0002\u0010\u0014\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015H\u0002\u001a$\u0010\u0016\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0015\u0010\u0017\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000fH\u0082\u0002\u001a\u0015\u0010\u0019\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000fH\u0082\u0002\u001a\u0015\u0010\u001a\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000fH\u0082\u0002\u001a\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0013H\u0002\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"formatNumber", "", WatchLaterReporterKt.KEY_NUM, "", "digits", "", "trimEnd", "", "NUMBER_FORMAT_RULE_DD_KEY", "DefaultNumberFormatRule", "Lkntr/base/localization/NumberFormatRule;", "getDefaultNumberFormatRule", "()Lkntr/base/localization/NumberFormatRule;", "formatWithUnit", "units", "Lkntr/base/localization/Units;", "suffix", "rounding", "Lkotlin/Function1;", "", "carry", "Lkotlin/Function3;", "format", "times", "other", "div", "rem", "realRound", "localization_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NumberFormatKt {
    private static final String NUMBER_FORMAT_RULE_DD_KEY = "localization.number_format_rule";

    public static final String formatNumber(long num, int digits, boolean trimEnd) {
        return format(getDefaultNumberFormatRule(), num, digits, trimEnd);
    }

    public static final String formatNumber(int num, int digits, boolean trimEnd) {
        return format(getDefaultNumberFormatRule(), num, digits, trimEnd);
    }

    private static final NumberFormatRule getDefaultNumberFormatRule() {
        return NumberFormatRuleLoader.INSTANCE.ruleFromConfig();
    }

    static /* synthetic */ String formatWithUnit$default(long j, Units units, String str, Function1 function1, int i, boolean z, Function3 function3, int i2, Object obj) {
        Function3 function32;
        if ((i2 & 32) == 0) {
            function32 = function3;
        } else {
            function32 = null;
        }
        return formatWithUnit(j, units, str, function1, i, z, function32);
    }

    private static final String formatWithUnit(long $this$formatWithUnit, Units units, String suffix, Function1<? super Double, Double> function1, int digits, boolean trimEnd, Function3<? super Long, ? super Integer, ? super Boolean, String> function3) {
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
        return (isNegative ? "-" : "") + it + suffix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String format(final NumberFormatRule $this$format, long num, int digits, boolean trimEnd) {
        long abs = Math.abs(num);
        Threshold threshold = $this$format.getThreshold().thresholdFor(abs);
        Function1 roundingFun = $this$format.getRounding().roundingFor(num);
        CarryRule carry = $this$format.getCarry();
        if (carry != null) {
            Boolean.valueOf(carry.carryFor(threshold.getUnits()));
        }
        Function3 carryFun = new Function3() { // from class: kntr.base.localization.NumberFormatKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                String format;
                format = NumberFormatKt.format(NumberFormatRule.this, ((Long) obj).longValue(), ((Integer) obj2).intValue(), ((Boolean) obj3).booleanValue());
                return format;
            }
        };
        return formatWithUnit(num, threshold.getUnits(), threshold.getSuffix(), roundingFun, digits, trimEnd, carryFun);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final double realRound(double num) {
        double floor = Math.floor(num);
        double ceil = Math.ceil(num);
        if (ceil - num == num - floor) {
            return ceil;
        }
        return Math.rint(num);
    }
}