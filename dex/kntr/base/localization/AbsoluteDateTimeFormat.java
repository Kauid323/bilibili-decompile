package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.datetime.LocalDateTime;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DateTimeFormat.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0001\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/base/localization/AbsoluteDateTimeFormat;", "", "yearMonthDayHourMinute", "Lkotlin/Function1;", "Lkotlinx/datetime/LocalDateTime;", "", "getYearMonthDayHourMinute", "()Lkotlin/jvm/functions/Function1;", "Lkntr/base/localization/DefaultAbsoluteDateTimeFormat;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AbsoluteDateTimeFormat {
    Function1<LocalDateTime, String> getYearMonthDayHourMinute();
}