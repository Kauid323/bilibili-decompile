package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.time.Duration;
import kotlinx.datetime.DatePeriod;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DateTimeFormat.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R-\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR-\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR-\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR-\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000eR\u001e\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000eR\u001e\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000eR-\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000eR-\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000eR\u001e\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u000eR\u001e\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u000e\u0082\u0001\u0001&¨\u0006'À\u0006\u0003"}, d2 = {"Lkntr/base/localization/RelativeDateTimeFormat;", "", "justNow", "Lkotlin/Function0;", "", "getJustNow", "()Lkotlin/jvm/functions/Function0;", "minutesAgo", "Lkotlin/Function1;", "Lkotlin/time/Duration;", "Lkotlin/ParameterName;", "name", "duration", "getMinutesAgo", "()Lkotlin/jvm/functions/Function1;", "hoursAgo", "getHoursAgo", "yesterday", "Lkotlinx/datetime/LocalTime;", "time", "getYesterday", "daysAgo", "Lkotlinx/datetime/DatePeriod;", "period", "getDaysAgo", "pastThisYear", "Lkotlinx/datetime/LocalDateTime;", "getPastThisYear", "past", "getPast", "today", "getToday", "tomorrow", "getTomorrow", "futureThisYear", "getFutureThisYear", "future", "getFuture", "Lkntr/base/localization/DefaultRelativeDateTimeFormat;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface RelativeDateTimeFormat {
    Function1<DatePeriod, String> getDaysAgo();

    Function1<LocalDateTime, String> getFuture();

    Function1<LocalDateTime, String> getFutureThisYear();

    Function1<Duration, String> getHoursAgo();

    Function0<String> getJustNow();

    Function1<Duration, String> getMinutesAgo();

    Function1<LocalDateTime, String> getPast();

    Function1<LocalDateTime, String> getPastThisYear();

    Function1<LocalTime, String> getToday();

    Function1<LocalTime, String> getTomorrow();

    Function1<LocalTime, String> getYesterday();
}