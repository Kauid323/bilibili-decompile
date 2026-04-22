package j$.time.chrono;

import j$.time.Clock$OffsetClock$$ExternalSyntheticBackport0;
import j$.time.DateTimeException;
import j$.time.Duration$$ExternalSyntheticBackport1;
import j$.time.Month;
import j$.time.ZoneOffset;
import j$.time.temporal.ChronoField;
import j$.util.DesugarCalendar;
import j$.util.Objects;

public final class DesugarIsoChronology {
    private static final long DAYS_0000_TO_1970 = 719528;

    public static long epochSecond(IsoChronology receiver, int prolepticYear, int month, int dayOfMonth, int hour, int minute, int second, ZoneOffset zoneOffset) {
        ChronoField.YEAR.checkValidValue(prolepticYear);
        ChronoField.MONTH_OF_YEAR.checkValidValue(month);
        ChronoField.DAY_OF_MONTH.checkValidValue(dayOfMonth);
        ChronoField.HOUR_OF_DAY.checkValidValue(hour);
        ChronoField.MINUTE_OF_HOUR.checkValidValue(minute);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(second);
        Objects.requireNonNull(zoneOffset, "zoneOffset");
        if (dayOfMonth > 28) {
            int dom = numberOfDaysOfMonth(prolepticYear, month);
            if (dayOfMonth > dom) {
                if (dayOfMonth == 29) {
                    throw new DateTimeException("Invalid date 'February 29' as '" + prolepticYear + "' is not a leap year");
                }
                throw new DateTimeException("Invalid date '" + Month.of(month).name() + " " + dayOfMonth + "'");
            }
        }
        long totalDays = 0 + (prolepticYear * 365);
        long totalDays2 = (prolepticYear >= 0 ? totalDays + (((prolepticYear + 3) / 4) - ((prolepticYear + 99) / 100)) + ((prolepticYear + 399) / 400) : totalDays - (((prolepticYear / (-4)) - (prolepticYear / (-100))) + (prolepticYear / (-400)))) + (((month * 367) - 362) / 12) + (dayOfMonth - 1);
        if (month > 2) {
            totalDays2--;
            if (!IsoChronology.INSTANCE.isLeapYear(prolepticYear)) {
                totalDays2--;
            }
        }
        int timeinSec = (((hour * 60) + minute) * 60) + second;
        return Clock$OffsetClock$$ExternalSyntheticBackport0.m(Duration$$ExternalSyntheticBackport1.m(totalDays2 - DAYS_0000_TO_1970, 86400L), timeinSec - zoneOffset.getTotalSeconds());
    }

    private static int numberOfDaysOfMonth(int year, int month) {
        switch (month) {
            case DesugarCalendar.LONG_FORMAT /* 2 */:
                return IsoChronology.INSTANCE.isLeapYear((long) year) ? 29 : 28;
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