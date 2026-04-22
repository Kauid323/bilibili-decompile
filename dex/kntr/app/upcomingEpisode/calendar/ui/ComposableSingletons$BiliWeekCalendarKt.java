package kntr.app.upcomingEpisode.calendar.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: BiliWeekCalendar.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$BiliWeekCalendarKt {
    public static final ComposableSingletons$BiliWeekCalendarKt INSTANCE = new ComposableSingletons$BiliWeekCalendarKt();
    private static Function2<Composer, Integer, Unit> lambda$549351033 = ComposableLambdaKt.composableLambdaInstance(549351033, false, new Function2() { // from class: kntr.app.upcomingEpisode.calendar.ui.ComposableSingletons$BiliWeekCalendarKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_549351033$lambda$0;
            lambda_549351033$lambda$0 = ComposableSingletons$BiliWeekCalendarKt.lambda_549351033$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_549351033$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1327286502 = ComposableLambdaKt.composableLambdaInstance(1327286502, false, new Function2() { // from class: kntr.app.upcomingEpisode.calendar.ui.ComposableSingletons$BiliWeekCalendarKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1327286502$lambda$0;
            lambda_1327286502$lambda$0 = ComposableSingletons$BiliWeekCalendarKt.lambda_1327286502$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1327286502$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1327286502$main_debug() {
        return lambda$1327286502;
    }

    public final Function2<Composer, Integer, Unit> getLambda$549351033$main_debug() {
        return lambda$549351033;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_549351033$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:BiliWeekCalendar.kt#4t4v7p");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(549351033, $changed, -1, "kntr.app.upcomingEpisode.calendar.ui.ComposableSingletons$BiliWeekCalendarKt.lambda$549351033.<anonymous> (BiliWeekCalendar.kt:41)");
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
    public static final Unit lambda_1327286502$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:BiliWeekCalendar.kt#4t4v7p");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1327286502, $changed, -1, "kntr.app.upcomingEpisode.calendar.ui.ComposableSingletons$BiliWeekCalendarKt.lambda$1327286502.<anonymous> (BiliWeekCalendar.kt:42)");
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