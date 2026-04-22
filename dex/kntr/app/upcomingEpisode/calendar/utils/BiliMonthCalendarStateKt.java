package kntr.app.upcomingEpisode.calendar.utils;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import j$.time.DayOfWeek;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.model.YearMonth;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: BiliMonthCalendarState.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a9\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\f\b\u0002\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"rememberBiliMonthCalendarState", "Lkntr/app/upcomingEpisode/calendar/utils/BiliMonthCalendarState;", "startMonth", "Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "endMonth", "firstVisibleMonth", "firstDayOfWeek", "Ljava/time/DayOfWeek;", "Lkotlinx/datetime/DayOfWeek;", "(Lkntr/app/upcomingEpisode/calendar/model/YearMonth;Lkntr/app/upcomingEpisode/calendar/model/YearMonth;Lkntr/app/upcomingEpisode/calendar/model/YearMonth;Ljava/time/DayOfWeek;Landroidx/compose/runtime/Composer;II)Lkntr/app/upcomingEpisode/calendar/utils/BiliMonthCalendarState;", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BiliMonthCalendarStateKt {
    public static final BiliMonthCalendarState rememberBiliMonthCalendarState(final YearMonth startMonth, final YearMonth endMonth, final YearMonth firstVisibleMonth, final DayOfWeek firstDayOfWeek, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1255589094, "C(rememberBiliMonthCalendarState)N(startMonth,endMonth,firstVisibleMonth,firstDayOfWeek)51@2066L252,42@1822L496:BiliMonthCalendarState.kt#4u6as6");
        if ((i & 1) != 0) {
            startMonth = YearMonth.Companion.now$default(YearMonth.Companion, null, null, 3, null);
        }
        if ((i & 2) != 0) {
            endMonth = startMonth;
        }
        if ((i & 4) != 0) {
            firstVisibleMonth = startMonth;
        }
        boolean z = true;
        if ((i & 8) != 0) {
            firstDayOfWeek = BiliCalendarUtilsKt.firstDayOfWeekFromLocale$default(null, 1, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1255589094, $changed, -1, "kntr.app.upcomingEpisode.calendar.utils.rememberBiliMonthCalendarState (BiliMonthCalendarState.kt:42)");
        }
        Object[] objArr = {startMonth, endMonth, firstVisibleMonth, firstDayOfWeek};
        Saver<BiliMonthCalendarState, Object> saver$main_debug = BiliMonthCalendarState.Companion.getSaver$main_debug();
        ComposerKt.sourceInformationMarkerStart($composer, 264707158, "CC(remember):BiliMonthCalendarState.kt#9igjgp");
        boolean z2 = (((($changed & 14) ^ 6) > 4 && $composer.changed(startMonth)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(endMonth)) || ($changed & 48) == 32) | (((($changed & 7168) ^ 3072) > 2048 && $composer.changed(((Enum) firstDayOfWeek).ordinal())) || ($changed & 3072) == 2048);
        if (((($changed & 896) ^ 384) <= 256 || !$composer.changed(firstVisibleMonth)) && ($changed & 384) != 256) {
            z = false;
        }
        boolean invalid$iv = z2 | z;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.app.upcomingEpisode.calendar.utils.BiliMonthCalendarStateKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    BiliMonthCalendarState rememberBiliMonthCalendarState$lambda$0$0;
                    rememberBiliMonthCalendarState$lambda$0$0 = BiliMonthCalendarStateKt.rememberBiliMonthCalendarState$lambda$0$0(YearMonth.this, endMonth, firstDayOfWeek, firstVisibleMonth);
                    return rememberBiliMonthCalendarState$lambda$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        BiliMonthCalendarState biliMonthCalendarState = (BiliMonthCalendarState) RememberSaveableKt.rememberSaveable(objArr, saver$main_debug, (Function0) it$iv, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return biliMonthCalendarState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BiliMonthCalendarState rememberBiliMonthCalendarState$lambda$0$0(YearMonth $startMonth, YearMonth $endMonth, DayOfWeek $firstDayOfWeek, YearMonth $firstVisibleMonth) {
        return new BiliMonthCalendarState($startMonth, $endMonth, $firstDayOfWeek, $firstVisibleMonth, null);
    }
}