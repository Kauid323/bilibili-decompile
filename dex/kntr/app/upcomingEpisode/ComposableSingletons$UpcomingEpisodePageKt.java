package kntr.app.upcomingEpisode;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.calendar.ui.BiliCalendarHeaderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: UpcomingEpisodePage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$UpcomingEpisodePageKt {
    public static final ComposableSingletons$UpcomingEpisodePageKt INSTANCE = new ComposableSingletons$UpcomingEpisodePageKt();

    /* renamed from: lambda$-494461469  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f31lambda$494461469 = ComposableLambdaKt.composableLambdaInstance(-494461469, false, new Function2() { // from class: kntr.app.upcomingEpisode.ComposableSingletons$UpcomingEpisodePageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__494461469$lambda$0;
            lambda__494461469$lambda$0 = ComposableSingletons$UpcomingEpisodePageKt.lambda__494461469$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__494461469$lambda$0;
        }
    });

    /* renamed from: lambda$-458029371  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f30lambda$458029371 = ComposableLambdaKt.composableLambdaInstance(-458029371, false, new Function2() { // from class: kntr.app.upcomingEpisode.ComposableSingletons$UpcomingEpisodePageKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__458029371$lambda$0;
            lambda__458029371$lambda$0 = ComposableSingletons$UpcomingEpisodePageKt.lambda__458029371$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__458029371$lambda$0;
        }
    });

    /* renamed from: getLambda$-458029371$main_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1184getLambda$458029371$main_debug() {
        return f30lambda$458029371;
    }

    /* renamed from: getLambda$-494461469$main_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1185getLambda$494461469$main_debug() {
        return f31lambda$494461469;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__494461469$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C237@10600L23:UpcomingEpisodePage.kt#jbu1nf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-494461469, $changed, -1, "kntr.app.upcomingEpisode.ComposableSingletons$UpcomingEpisodePageKt.lambda$-494461469.<anonymous> (UpcomingEpisodePage.kt:237)");
            }
            BiliCalendarHeaderKt.BiliCalendarSubHeader(null, null, $composer, 0, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__458029371$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C290@13208L23:UpcomingEpisodePage.kt#jbu1nf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-458029371, $changed, -1, "kntr.app.upcomingEpisode.ComposableSingletons$UpcomingEpisodePageKt.lambda$-458029371.<anonymous> (UpcomingEpisodePage.kt:290)");
            }
            BiliCalendarHeaderKt.BiliCalendarSubHeader(null, null, $composer, 0, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}