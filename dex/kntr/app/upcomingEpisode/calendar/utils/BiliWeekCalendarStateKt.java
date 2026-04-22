package kntr.app.upcomingEpisode.calendar.utils;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import j$.time.DayOfWeek;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.model.YearMonth;
import kntr.app.upcomingEpisode.calendar.model.YearMonthKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.datetime.LocalDate;

/* compiled from: BiliWeekCalendarState.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a9\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\f\b\u0002\u0010\b\u001a\u00060\tj\u0002`\nH\u0007¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"TAG", "", "rememberBiliWeekCalendarState", "Lkntr/app/upcomingEpisode/calendar/utils/BiliWeekCalendarState;", "startDate", "Lkotlinx/datetime/LocalDate;", "endDate", "firstVisibleWeekDate", "firstDayOfWeek", "Ljava/time/DayOfWeek;", "Lkotlinx/datetime/DayOfWeek;", "(Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalDate;Ljava/time/DayOfWeek;Landroidx/compose/runtime/Composer;II)Lkntr/app/upcomingEpisode/calendar/utils/BiliWeekCalendarState;", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BiliWeekCalendarStateKt {
    private static final String TAG = "BiliWeekCalendarState";

    public static final BiliWeekCalendarState rememberBiliWeekCalendarState(final LocalDate startDate, final LocalDate endDate, final LocalDate firstVisibleWeekDate, final DayOfWeek firstDayOfWeek, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 134680304, "C(rememberBiliWeekCalendarState)N(startDate,endDate,firstVisibleWeekDate,firstDayOfWeek)60@2433L253,50@2150L536:BiliWeekCalendarState.kt#4u6as6");
        if ((i & 1) != 0) {
            startDate = YearMonthKt.atStartOfMonth(YearMonth.Companion.now$default(YearMonth.Companion, null, null, 3, null));
        }
        if ((i & 2) != 0) {
            endDate = YearMonthKt.atEndOfMonth(YearMonth.Companion.now$default(YearMonth.Companion, null, null, 3, null));
        }
        if ((i & 4) != 0) {
            firstVisibleWeekDate = BiliCalendarExtensionsKt.now$default(LocalDate.Companion, null, null, 3, null);
        }
        boolean z = true;
        if ((i & 8) != 0) {
            firstDayOfWeek = BiliCalendarUtilsKt.firstDayOfWeekFromLocale$default(null, 1, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(134680304, $changed, -1, "kntr.app.upcomingEpisode.calendar.utils.rememberBiliWeekCalendarState (BiliWeekCalendarState.kt:50)");
        }
        Object[] objArr = {startDate, endDate, firstVisibleWeekDate, firstDayOfWeek};
        Saver<BiliWeekCalendarState, Object> saver$main_debug = BiliWeekCalendarState.Companion.getSaver$main_debug();
        ComposerKt.sourceInformationMarkerStart($composer, 578772141, "CC(remember):BiliWeekCalendarState.kt#9igjgp");
        boolean changedInstance = $composer.changedInstance(startDate) | $composer.changedInstance(endDate) | $composer.changedInstance(firstVisibleWeekDate);
        if (((($changed & 7168) ^ 3072) <= 2048 || !$composer.changed(((Enum) firstDayOfWeek).ordinal())) && ($changed & 3072) != 2048) {
            z = false;
        }
        boolean invalid$iv = z | changedInstance;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.app.upcomingEpisode.calendar.utils.BiliWeekCalendarStateKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    BiliWeekCalendarState rememberBiliWeekCalendarState$lambda$0$0;
                    rememberBiliWeekCalendarState$lambda$0$0 = BiliWeekCalendarStateKt.rememberBiliWeekCalendarState$lambda$0$0(startDate, endDate, firstVisibleWeekDate, firstDayOfWeek);
                    return rememberBiliWeekCalendarState$lambda$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        BiliWeekCalendarState biliWeekCalendarState = (BiliWeekCalendarState) RememberSaveableKt.rememberSaveable(objArr, saver$main_debug, (Function0) it$iv, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return biliWeekCalendarState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BiliWeekCalendarState rememberBiliWeekCalendarState$lambda$0$0(LocalDate $startDate, LocalDate $endDate, LocalDate $firstVisibleWeekDate, DayOfWeek $firstDayOfWeek) {
        return new BiliWeekCalendarState($startDate, $endDate, $firstVisibleWeekDate, $firstDayOfWeek, null);
    }
}