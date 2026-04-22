package kntr.app.upcomingEpisode.calendar.model;

import j$.time.DayOfWeek;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.utils.BiliCalendarExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;

/* compiled from: MonthData.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0000\u001a\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0000¨\u0006\r"}, d2 = {"getCalendarMonthData", "Lkntr/app/upcomingEpisode/calendar/model/MonthData;", "startMonth", "Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "offset", "", "firstDayOfWeek", "Ljava/time/DayOfWeek;", "Lkotlinx/datetime/DayOfWeek;", "getMonthIndex", "targetMonth", "getMonthIndicesCount", "endMonth", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MonthDataKt {
    public static final MonthData getCalendarMonthData(YearMonth startMonth, int offset, DayOfWeek firstDayOfWeek) {
        Intrinsics.checkNotNullParameter(startMonth, "startMonth");
        Intrinsics.checkNotNullParameter(firstDayOfWeek, "firstDayOfWeek");
        YearMonth month = YearMonthKt.plusMonths(startMonth, offset);
        LocalDate firstDay = YearMonthKt.atStartOfMonth(month);
        int inDays = BiliCalendarExtensionsKt.daysUntil(firstDayOfWeek, firstDay.getDayOfWeek());
        int inAndMonthDays = YearMonthKt.lengthOfMonth(month) + inDays;
        int endOfRowDays = inAndMonthDays % 7 != 0 ? 7 - (inAndMonthDays % 7) : 0;
        int weeksInMonth = (inAndMonthDays + endOfRowDays) / 7;
        int endOfGridDays = (6 - weeksInMonth) * 7;
        int outDays = endOfRowDays + endOfGridDays;
        return new MonthData(month, inDays, outDays);
    }

    public static final int getMonthIndex(YearMonth startMonth, YearMonth targetMonth) {
        Intrinsics.checkNotNullParameter(startMonth, "startMonth");
        Intrinsics.checkNotNullParameter(targetMonth, "targetMonth");
        return YearMonthKt.monthsUntil(startMonth, targetMonth);
    }

    public static final int getMonthIndicesCount(YearMonth startMonth, YearMonth endMonth) {
        Intrinsics.checkNotNullParameter(startMonth, "startMonth");
        Intrinsics.checkNotNullParameter(endMonth, "endMonth");
        return getMonthIndex(startMonth, endMonth) + 1;
    }
}