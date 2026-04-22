package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DateTimeFormat.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001R-\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR-\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR-\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\nR-\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\n\u0082\u0001\u0001\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkntr/base/localization/IMDateTimeFormat;", "", "today", "Lkotlin/Function1;", "Lkotlinx/datetime/LocalTime;", "Lkotlin/ParameterName;", "name", "time", "", "getToday", "()Lkotlin/jvm/functions/Function1;", "yesterday", "getYesterday", "thisWeek", "Lkotlinx/datetime/LocalDateTime;", "getThisWeek", "past", "getPast", "Lkntr/base/localization/DefaultIMDateTimeFormat;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IMDateTimeFormat {
    Function1<LocalDateTime, String> getPast();

    Function1<LocalDateTime, String> getThisWeek();

    Function1<LocalTime, String> getToday();

    Function1<LocalTime, String> getYesterday();
}