package kntr.app.upcomingEpisode.calendar.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: BiliMonthCalendar.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$BiliMonthCalendarKt {
    public static final ComposableSingletons$BiliMonthCalendarKt INSTANCE = new ComposableSingletons$BiliMonthCalendarKt();

    /* renamed from: lambda$-1005698352  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f32lambda$1005698352 = ComposableLambdaKt.composableLambdaInstance(-1005698352, false, new Function2() { // from class: kntr.app.upcomingEpisode.calendar.ui.ComposableSingletons$BiliMonthCalendarKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1005698352$lambda$0;
            lambda__1005698352$lambda$0 = ComposableSingletons$BiliMonthCalendarKt.lambda__1005698352$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1005698352$lambda$0;
        }
    });

    /* renamed from: lambda$-740732547  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f33lambda$740732547 = ComposableLambdaKt.composableLambdaInstance(-740732547, false, new Function2() { // from class: kntr.app.upcomingEpisode.calendar.ui.ComposableSingletons$BiliMonthCalendarKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__740732547$lambda$0;
            lambda__740732547$lambda$0 = ComposableSingletons$BiliMonthCalendarKt.lambda__740732547$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__740732547$lambda$0;
        }
    });

    /* renamed from: getLambda$-1005698352$main_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1215getLambda$1005698352$main_debug() {
        return f32lambda$1005698352;
    }

    /* renamed from: getLambda$-740732547$main_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1216getLambda$740732547$main_debug() {
        return f33lambda$740732547;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1005698352$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:BiliMonthCalendar.kt#4t4v7p");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1005698352, $changed, -1, "kntr.app.upcomingEpisode.calendar.ui.ComposableSingletons$BiliMonthCalendarKt.lambda$-1005698352.<anonymous> (BiliMonthCalendar.kt:38)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__740732547$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:BiliMonthCalendar.kt#4t4v7p");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-740732547, $changed, -1, "kntr.app.upcomingEpisode.calendar.ui.ComposableSingletons$BiliMonthCalendarKt.lambda$-740732547.<anonymous> (BiliMonthCalendar.kt:39)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}