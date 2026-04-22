package kntr.app.upcomingEpisode.calendar.model;

import j$.time.DayOfWeek;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.utils.BiliCalendarExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;

/* compiled from: WeekData.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0000\u001a(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0000¨\u0006\u0013"}, d2 = {"getWeekCalendarAdjustedRange", "Lkntr/app/upcomingEpisode/calendar/model/WeekDateRange;", "startDate", "Lkotlinx/datetime/LocalDate;", "endDate", "firstDayOfWeek", "Ljava/time/DayOfWeek;", "Lkotlinx/datetime/DayOfWeek;", "getWeekCalendarData", "Lkntr/app/upcomingEpisode/calendar/model/WeekData;", "startDateAdjusted", "offset", "", "desiredStartDate", "desiredEndDate", "getWeekCalendarWeekCounts", "date", "getWeekCalendarTotalWeekCounts", "endDateAdjusted", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WeekDataKt {
    public static final WeekDateRange getWeekCalendarAdjustedRange(LocalDate startDate, LocalDate endDate, DayOfWeek firstDayOfWeek) {
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        Intrinsics.checkNotNullParameter(firstDayOfWeek, "firstDayOfWeek");
        int inDays = BiliCalendarExtensionsKt.daysUntil(firstDayOfWeek, startDate.getDayOfWeek());
        LocalDate startDateAdjusted = BiliCalendarExtensionsKt.minusDays(startDate, inDays);
        int weeksBetween = BiliCalendarExtensionsKt.weeksUntil(startDateAdjusted, endDate);
        LocalDate endDateAdjusted = BiliCalendarExtensionsKt.plusDays(BiliCalendarExtensionsKt.plusWeeks(startDateAdjusted, weeksBetween), 6);
        return new WeekDateRange(startDateAdjusted, endDateAdjusted);
    }

    public static final WeekData getWeekCalendarData(LocalDate startDateAdjusted, int offset, LocalDate desiredStartDate, LocalDate desiredEndDate) {
        Intrinsics.checkNotNullParameter(startDateAdjusted, "startDateAdjusted");
        Intrinsics.checkNotNullParameter(desiredStartDate, "desiredStartDate");
        Intrinsics.checkNotNullParameter(desiredEndDate, "desiredEndDate");
        LocalDate firstDayInWeek = BiliCalendarExtensionsKt.plusWeeks(startDateAdjusted, offset);
        return new WeekData(firstDayInWeek, desiredStartDate, desiredEndDate);
    }

    public static final int getWeekCalendarWeekCounts(LocalDate startDateAdjusted, LocalDate date) {
        Intrinsics.checkNotNullParameter(startDateAdjusted, "startDateAdjusted");
        Intrinsics.checkNotNullParameter(date, "date");
        return BiliCalendarExtensionsKt.weeksUntil(startDateAdjusted, date);
    }

    public static final int getWeekCalendarTotalWeekCounts(LocalDate startDateAdjusted, LocalDate endDateAdjusted) {
        Intrinsics.checkNotNullParameter(startDateAdjusted, "startDateAdjusted");
        Intrinsics.checkNotNullParameter(endDateAdjusted, "endDateAdjusted");
        return getWeekCalendarWeekCounts(startDateAdjusted, endDateAdjusted) + 1;
    }
}