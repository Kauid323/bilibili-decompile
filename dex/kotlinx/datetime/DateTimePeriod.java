package kotlinx.datetime;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.DateCalculationsKt;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.serializers.DateTimePeriodIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.apache.commons.io.FilenameUtils;

/* compiled from: DateTimePeriod.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000  2\u00020\u0001:\u0001 B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0012\u0010\u0011\u001a\u00020\u0004X \u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006R\u0012\u0010\u0013\u001a\u00020\u0014X \u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0006\u0082\u0001\u0002!\"¨\u0006#"}, d2 = {"Lkotlinx/datetime/DateTimePeriod;", "", "()V", "days", "", "getDays", "()I", "hours", "getHours", "minutes", "getMinutes", "months", "getMonths", "nanoseconds", "getNanoseconds", "seconds", "getSeconds", "totalMonths", "getTotalMonths$kotlinx_datetime", "totalNanoseconds", "", "getTotalNanoseconds$kotlinx_datetime", "()J", "years", "getYears", "allNonpositive", "", "equals", "other", "hashCode", "toString", "", "Companion", "Lkotlinx/datetime/DatePeriod;", "Lkotlinx/datetime/DateTimePeriodImpl;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable(with = DateTimePeriodIso8601Serializer.class)
public abstract class DateTimePeriod {
    public static final Companion Companion = new Companion(null);

    public /* synthetic */ DateTimePeriod(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getDays();

    public abstract int getTotalMonths$kotlinx_datetime();

    public abstract long getTotalNanoseconds$kotlinx_datetime();

    private DateTimePeriod() {
    }

    public final int getYears() {
        return getTotalMonths$kotlinx_datetime() / 12;
    }

    public final int getMonths() {
        return getTotalMonths$kotlinx_datetime() % 12;
    }

    public int getHours() {
        return (int) (getTotalNanoseconds$kotlinx_datetime() / DateCalculationsKt.NANOS_PER_HOUR);
    }

    public int getMinutes() {
        return (int) ((getTotalNanoseconds$kotlinx_datetime() % DateCalculationsKt.NANOS_PER_HOUR) / DateCalculationsKt.NANOS_PER_MINUTE);
    }

    public int getSeconds() {
        return (int) ((getTotalNanoseconds$kotlinx_datetime() % DateCalculationsKt.NANOS_PER_MINUTE) / 1000000000);
    }

    public int getNanoseconds() {
        return (int) (getTotalNanoseconds$kotlinx_datetime() % 1000000000);
    }

    private final boolean allNonpositive() {
        return getTotalMonths$kotlinx_datetime() <= 0 && getDays() <= 0 && getTotalNanoseconds$kotlinx_datetime() <= 0 && !((getTotalMonths$kotlinx_datetime() | getDays()) == 0 && getTotalNanoseconds$kotlinx_datetime() == 0);
    }

    public String toString() {
        int sign;
        String str;
        StringBuilder $this$toString_u24lambda_u242 = new StringBuilder();
        if (allNonpositive()) {
            $this$toString_u24lambda_u242.append('-');
            sign = -1;
        } else {
            sign = 1;
        }
        $this$toString_u24lambda_u242.append('P');
        if (getYears() != 0) {
            $this$toString_u24lambda_u242.append(getYears() * sign).append('Y');
        }
        if (getMonths() != 0) {
            $this$toString_u24lambda_u242.append(getMonths() * sign).append('M');
        }
        if (getDays() != 0) {
            $this$toString_u24lambda_u242.append(getDays() * sign).append('D');
        }
        String str2 = "T";
        if (getHours() != 0) {
            $this$toString_u24lambda_u242.append("T").append(getHours() * sign).append('H');
            str2 = "";
        }
        if (getMinutes() != 0) {
            $this$toString_u24lambda_u242.append(str2).append(getMinutes() * sign).append('M');
            str2 = "";
        }
        if ((getSeconds() | getNanoseconds()) != 0) {
            $this$toString_u24lambda_u242.append(str2);
            if (getSeconds() != 0) {
                str = Integer.valueOf(getSeconds() * sign);
            } else {
                str = getNanoseconds() * sign < 0 ? "-0" : "0";
            }
            $this$toString_u24lambda_u242.append(str);
            if (getNanoseconds() != 0) {
                $this$toString_u24lambda_u242.append(FilenameUtils.EXTENSION_SEPARATOR).append(StringsKt.padStart(String.valueOf(Math.abs(getNanoseconds())), 9, '0'));
            }
            $this$toString_u24lambda_u242.append('S');
        }
        if ($this$toString_u24lambda_u242.length() == 1) {
            $this$toString_u24lambda_u242.append("0D");
        }
        String sb = $this$toString_u24lambda_u242.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DateTimePeriod) && getTotalMonths$kotlinx_datetime() == ((DateTimePeriod) other).getTotalMonths$kotlinx_datetime() && getDays() == ((DateTimePeriod) other).getDays() && getTotalNanoseconds$kotlinx_datetime() == ((DateTimePeriod) other).getTotalNanoseconds$kotlinx_datetime();
    }

    public int hashCode() {
        int result = getTotalMonths$kotlinx_datetime();
        return (((result * 31) + getDays()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(getTotalNanoseconds$kotlinx_datetime());
    }

    /* compiled from: DateTimePeriod.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0001¨\u0006\t"}, d2 = {"Lkotlinx/datetime/DateTimePeriod$Companion;", "", "()V", "parse", "Lkotlinx/datetime/DateTimePeriod;", "text", "", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DateTimePeriod> serializer() {
            return DateTimePeriodIso8601Serializer.INSTANCE;
        }

        private static final Void parse$parseException(String message, int position) {
            throw new DateTimeFormatException("Parse error at char " + position + ": " + message);
        }

        /* JADX WARN: Code restructure failed: missing block: B:151:0x0322, code lost:
            parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:152:0x032a, code lost:
            throw new kotlin.KotlinNothingValueException();
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x0345, code lost:
            parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x034d, code lost:
            throw new kotlin.KotlinNothingValueException();
         */
        /* JADX WARN: Code restructure failed: missing block: B:192:0x03f2, code lost:
            parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:193:0x03fa, code lost:
            throw new kotlin.KotlinNothingValueException();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00d1, code lost:
            parse$parseException("Unexpected end of string; 'P' designator is required", r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00db, code lost:
            throw new kotlin.KotlinNothingValueException();
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0193, code lost:
            parse$parseException("A number expected after '" + r38.charAt(r0) + '\'', r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x01b8, code lost:
            throw new kotlin.KotlinNothingValueException();
         */
        /* JADX WARN: Incorrect condition in loop: B:91:0x01ef */
        /* JADX WARN: Removed duplicated region for block: B:182:0x0383 A[LOOP:2: B:172:0x0369->B:182:0x0383, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:244:0x0386 A[EDGE_INSN: B:244:0x0386->B:183:0x0386 ?: BREAK  , SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final DateTimePeriod parse(String text) {
            int AFTER_MONTH;
            int AFTER_YEAR;
            int AFTER_MONTH2;
            int AFTER_SECOND_AND_NANO;
            int state;
            boolean z;
            Intrinsics.checkNotNullParameter(text, "text");
            int START = 0;
            int i = 1;
            int AFTER_YEAR2 = 2;
            int AFTER_MONTH3 = 3;
            int AFTER_WEEK = 4;
            int AFTER_DAY = 5;
            int AFTER_HOUR = 7;
            int AFTER_MINUTE = 8;
            int AFTER_SECOND_AND_NANO2 = 9;
            int sign = 1;
            int years = 0;
            int months = 0;
            int weeks = 0;
            int iStart = 0;
            int hours = 0;
            int minutes = 0;
            int seconds = 0;
            int localSign = 0;
            int i2 = false;
            int state2 = 0;
            while (true) {
                int START2 = START;
                int START3 = text.length();
                int AFTER_SECOND_AND_NANO3 = AFTER_SECOND_AND_NANO2;
                boolean z2 = true;
                if (state2 >= START3) {
                    if (i2 == 0) {
                        parse$parseException("Unexpected end of input; 'P' designator is required", state2);
                        throw new KotlinNothingValueException();
                    } else if (i2 == 6) {
                        parse$parseException("Unexpected end of input; at least one time component is required after 'T'", state2);
                        throw new KotlinNothingValueException();
                    } else {
                        long n = iStart + (weeks * 7);
                        if ((-2147483648L > n || n > 2147483647L) ? false : false) {
                            int daysTotal = (int) n;
                            return DateTimePeriodKt.DateTimePeriod(years, months, daysTotal, hours, minutes, seconds, localSign);
                        }
                        parse$parseException("The total number of days under 'D' and 'W' designators should fit into an Int", 0);
                        throw new KotlinNothingValueException();
                    }
                }
                int AFTER_WEEK2 = AFTER_WEEK;
                int AFTER_DAY2 = AFTER_DAY;
                int state3 = i2;
                int nanoseconds = localSign;
                int days = iStart;
                if (state3 == 0) {
                    if (state2 + 1 < text.length() || (text.charAt(state2) != '+' && text.charAt(state2) != '-')) {
                        char charAt = text.charAt(state2);
                        if (charAt == '+' || charAt == '-') {
                            if (text.charAt(state2) == '-') {
                                sign = -1;
                            }
                            if (text.charAt(state2 + 1) == 'P') {
                                state2 += 2;
                            } else {
                                parse$parseException("Expected 'P', got '" + text.charAt(state2 + 1) + '\'', state2 + 1);
                                throw new KotlinNothingValueException();
                            }
                        } else if (charAt != 'P') {
                            parse$parseException("Expected '+', '-', 'P', got '" + text.charAt(state2) + '\'', state2);
                            throw new KotlinNothingValueException();
                        } else {
                            state2++;
                        }
                        i2 = i;
                        START = START2;
                        AFTER_SECOND_AND_NANO2 = AFTER_SECOND_AND_NANO3;
                        AFTER_WEEK = AFTER_WEEK2;
                        AFTER_DAY = AFTER_DAY2;
                        localSign = nanoseconds;
                        iStart = days;
                    }
                } else {
                    int localSign2 = sign;
                    int iStart2 = state2;
                    char charAt2 = text.charAt(state2);
                    char c = '0';
                    if (charAt2 == '+' || charAt2 == '-') {
                        if (text.charAt(state2) == '-') {
                            localSign2 *= -1;
                        }
                        state2++;
                        if (state2 < text.length()) {
                            char charAt3 = text.charAt(state2);
                            if (!('0' <= charAt3 && charAt3 < ':')) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        if (!('0' <= charAt2 && charAt2 < ':') && charAt2 == 'T') {
                            if (state3 >= 6) {
                                parse$parseException("Only one 'T' designator is allowed", state2);
                                throw new KotlinNothingValueException();
                            }
                            i2 = 6;
                            state2++;
                            START = START2;
                            AFTER_SECOND_AND_NANO2 = AFTER_SECOND_AND_NANO3;
                            AFTER_WEEK = AFTER_WEEK2;
                            AFTER_DAY = AFTER_DAY2;
                            localSign = nanoseconds;
                            iStart = days;
                        }
                    }
                    long number = 0;
                    int i3 = state2;
                    while (i3 < i) {
                        char charAt4 = text.charAt(i3);
                        if (!(c <= charAt4 && charAt4 < ':')) {
                            break;
                        }
                        int AFTER_MONTH4 = AFTER_MONTH3;
                        try {
                            int AFTER_HOUR2 = AFTER_HOUR;
                            int AFTER_MINUTE2 = AFTER_MINUTE;
                            try {
                                number = MathJvmKt.safeAdd(MathJvmKt.safeMultiply(number, 10L), text.charAt(i3) - '0');
                                i3++;
                                AFTER_MONTH3 = AFTER_MONTH4;
                                AFTER_HOUR = AFTER_HOUR2;
                                AFTER_MINUTE = AFTER_MINUTE2;
                                c = '0';
                            } catch (ArithmeticException e) {
                                parse$parseException("The number is too large", iStart2);
                                throw new KotlinNothingValueException();
                            }
                        } catch (ArithmeticException e2) {
                        }
                    }
                    int AFTER_MONTH5 = AFTER_MONTH3;
                    int AFTER_HOUR3 = AFTER_HOUR;
                    int AFTER_MINUTE3 = AFTER_MINUTE;
                    long number2 = number * localSign2;
                    if (i3 == text.length()) {
                        parse$parseException("Expected a designator after the numerical value", i3);
                        throw new KotlinNothingValueException();
                    }
                    char upperCase = Character.toUpperCase(text.charAt(i3));
                    if (upperCase == 'Y') {
                        if (state3 >= AFTER_YEAR2) {
                            parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i3);
                            throw new KotlinNothingValueException();
                        }
                        state = AFTER_YEAR2;
                        AFTER_YEAR = AFTER_YEAR2;
                        years = parse$toIntThrowing(number2, iStart2, 'Y');
                        AFTER_MONTH2 = AFTER_MONTH5;
                        AFTER_SECOND_AND_NANO = AFTER_SECOND_AND_NANO3;
                        AFTER_MINUTE = AFTER_MINUTE3;
                        AFTER_MONTH = i;
                    } else if (upperCase != 'M') {
                        AFTER_MINUTE = AFTER_MINUTE3;
                        AFTER_MONTH = i;
                        if (upperCase == 'W') {
                            if (state3 >= AFTER_WEEK2) {
                                parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i3);
                                throw new KotlinNothingValueException();
                            }
                            state = AFTER_WEEK2;
                            weeks = parse$toIntThrowing(number2, iStart2, 'W');
                            AFTER_YEAR = AFTER_YEAR2;
                            AFTER_WEEK2 = AFTER_WEEK2;
                            AFTER_MONTH2 = AFTER_MONTH5;
                            AFTER_SECOND_AND_NANO = AFTER_SECOND_AND_NANO3;
                        } else if (upperCase == 'D') {
                            if (state3 >= AFTER_DAY2) {
                                parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i3);
                                throw new KotlinNothingValueException();
                            }
                            state = AFTER_DAY2;
                            days = parse$toIntThrowing(number2, iStart2, 'D');
                            AFTER_YEAR = AFTER_YEAR2;
                            AFTER_DAY2 = AFTER_DAY2;
                            AFTER_MONTH2 = AFTER_MONTH5;
                            AFTER_SECOND_AND_NANO = AFTER_SECOND_AND_NANO3;
                        } else if (upperCase == 'H') {
                            if (state3 >= AFTER_HOUR3 || state3 < 6) {
                                break;
                            }
                            state = AFTER_HOUR3;
                            hours = parse$toIntThrowing(number2, iStart2, 'H');
                            AFTER_YEAR = AFTER_YEAR2;
                            AFTER_HOUR3 = AFTER_HOUR3;
                            AFTER_MONTH2 = AFTER_MONTH5;
                            AFTER_SECOND_AND_NANO = AFTER_SECOND_AND_NANO3;
                        } else if (upperCase != 'S') {
                            if (upperCase == '.' || upperCase == ',') {
                                i3++;
                                if (i3 >= text.length()) {
                                    parse$parseException("Expected designator 'S' after " + text.charAt(i3 - 1), i3);
                                    throw new KotlinNothingValueException();
                                }
                                while (i3 < text.length()) {
                                    char charAt5 = text.charAt(i3);
                                    if ('0' <= charAt5 && charAt5 < ':') {
                                        z = true;
                                        if (z) {
                                            break;
                                        }
                                        i3++;
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                }
                                int fractionLength = i3 - i3;
                                if (fractionLength > 9) {
                                    parse$parseException("Only the nanosecond fractions of a second are supported", i3);
                                    throw new KotlinNothingValueException();
                                }
                                StringBuilder sb = new StringBuilder();
                                AFTER_YEAR = AFTER_YEAR2;
                                String substring = text.substring(i3, i3);
                                AFTER_MONTH2 = AFTER_MONTH5;
                                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                String fractionalPart = sb.append(substring).append(StringsKt.repeat("0", 9 - fractionLength)).toString();
                                int nanoseconds2 = Integer.parseInt(fractionalPart, CharsKt.checkRadix(10)) * localSign2;
                                if (text.charAt(i3) != 'S') {
                                    parse$parseException("Expected the 'S' designator after a fraction", i3);
                                    throw new KotlinNothingValueException();
                                }
                                AFTER_SECOND_AND_NANO = AFTER_SECOND_AND_NANO3;
                                if (state3 >= AFTER_SECOND_AND_NANO || state3 < 6) {
                                    break;
                                }
                                state = AFTER_SECOND_AND_NANO;
                                int iStartFraction = parse$toIntThrowing(number2, iStart2, 'S');
                                seconds = iStartFraction;
                                nanoseconds = nanoseconds2;
                            } else {
                                parse$parseException("Expected a designator after the numerical value", i3);
                                throw new KotlinNothingValueException();
                            }
                        } else if (state3 >= AFTER_SECOND_AND_NANO3 || state3 < 6) {
                            break;
                        } else {
                            state = AFTER_SECOND_AND_NANO3;
                            seconds = parse$toIntThrowing(number2, iStart2, 'S');
                            AFTER_YEAR = AFTER_YEAR2;
                            AFTER_MONTH2 = AFTER_MONTH5;
                            AFTER_SECOND_AND_NANO = AFTER_SECOND_AND_NANO3;
                        }
                    } else if (state3 >= 6) {
                        AFTER_MINUTE = AFTER_MINUTE3;
                        if (state3 >= AFTER_MINUTE) {
                            parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i3);
                            throw new KotlinNothingValueException();
                        }
                        state = AFTER_MINUTE;
                        AFTER_YEAR = AFTER_YEAR2;
                        minutes = parse$toIntThrowing(number2, iStart2, 'M');
                        AFTER_MONTH2 = AFTER_MONTH5;
                        AFTER_SECOND_AND_NANO = AFTER_SECOND_AND_NANO3;
                        AFTER_MONTH = i;
                    } else {
                        AFTER_MINUTE = AFTER_MINUTE3;
                        if (state3 >= AFTER_MONTH5) {
                            parse$parseException("Wrong component order: should be 'Y', 'M', 'W', 'D', then designator 'T', then 'H', 'M', 'S'", i3);
                            throw new KotlinNothingValueException();
                        }
                        state = AFTER_MONTH5;
                        AFTER_MONTH = i;
                        AFTER_YEAR = AFTER_YEAR2;
                        AFTER_MONTH2 = AFTER_MONTH5;
                        months = parse$toIntThrowing(number2, iStart2, 'M');
                        AFTER_SECOND_AND_NANO = AFTER_SECOND_AND_NANO3;
                    }
                    int iStartFraction2 = i3 + 1;
                    i2 = state;
                    state2 = iStartFraction2;
                    AFTER_SECOND_AND_NANO2 = AFTER_SECOND_AND_NANO;
                    AFTER_YEAR2 = AFTER_YEAR;
                    AFTER_MONTH3 = AFTER_MONTH2;
                    i = AFTER_MONTH;
                    AFTER_HOUR = AFTER_HOUR3;
                    START = START2;
                    AFTER_WEEK = AFTER_WEEK2;
                    AFTER_DAY = AFTER_DAY2;
                    localSign = nanoseconds;
                    iStart = days;
                }
            }
        }

        private static final int parse$toIntThrowing(long $this$parse_u24toIntThrowing, int iStart, char component) {
            if ($this$parse_u24toIntThrowing < -2147483648L || $this$parse_u24toIntThrowing > 2147483647L) {
                parse$parseException("Value " + $this$parse_u24toIntThrowing + " does not fit into an Int, which is required for component '" + component + '\'', iStart);
                throw new KotlinNothingValueException();
            }
            return (int) $this$parse_u24toIntThrowing;
        }
    }
}