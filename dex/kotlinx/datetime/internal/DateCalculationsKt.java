package kotlinx.datetime.internal;

import kotlin.Metadata;

/* compiled from: dateCalculations.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"HOURS_PER_DAY", "", "MILLIS_PER_DAY", "MILLIS_PER_ONE", "MINUTES_PER_HOUR", "NANOS_PER_DAY", "", "NANOS_PER_HOUR", "NANOS_PER_MILLI", "NANOS_PER_MINUTE", "NANOS_PER_ONE", "SECONDS_PER_10000_YEARS", "SECONDS_PER_DAY", "SECONDS_PER_HOUR", "SECONDS_PER_MINUTE", "isLeapYear", "", "year", "monthLength", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DateCalculationsKt {
    public static final int HOURS_PER_DAY = 24;
    public static final int MILLIS_PER_DAY = 86400000;
    public static final int MILLIS_PER_ONE = 1000;
    public static final int MINUTES_PER_HOUR = 60;
    public static final long NANOS_PER_DAY = 86400000000000L;
    public static final long NANOS_PER_HOUR = 3600000000000L;
    public static final int NANOS_PER_MILLI = 1000000;
    public static final long NANOS_PER_MINUTE = 60000000000L;
    public static final int NANOS_PER_ONE = 1000000000;
    public static final long SECONDS_PER_10000_YEARS = 315569520000L;
    public static final int SECONDS_PER_DAY = 86400;
    public static final int SECONDS_PER_HOUR = 3600;
    public static final int SECONDS_PER_MINUTE = 60;

    public static final boolean isLeapYear(int year) {
        long prolepticYear = year;
        return (3 & prolepticYear) == 0 && (prolepticYear % ((long) 100) != 0 || prolepticYear % ((long) 400) == 0);
    }

    public static final int monthLength(int $this$monthLength, boolean isLeapYear) {
        switch ($this$monthLength) {
            case 2:
                return isLeapYear ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
}