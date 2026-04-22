package kntr.common.compose.pulltorefresh;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PullToRefresh.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$PullToRefreshKt {
    public static final ComposableSingletons$PullToRefreshKt INSTANCE = new ComposableSingletons$PullToRefreshKt();
    private static Function3<PullToRefreshState, Composer, Integer, Unit> lambda$1306555779 = ComposableLambdaKt.composableLambdaInstance(1306555779, false, new Function3() { // from class: kntr.common.compose.pulltorefresh.ComposableSingletons$PullToRefreshKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_1306555779$lambda$0;
            lambda_1306555779$lambda$0 = ComposableSingletons$PullToRefreshKt.lambda_1306555779$lambda$0((PullToRefreshState) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_1306555779$lambda$0;
        }
    });

    public final Function3<PullToRefreshState, Composer, Integer, Unit> getLambda$1306555779$compose_pulltorefresh_debug() {
        return lambda$1306555779;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1306555779$lambda$0(PullToRefreshState s, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(s, "s");
        ComposerKt.sourceInformation($composer, "CN(s)27@1056L25:PullToRefresh.kt#8f2f3d");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(s) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1306555779, $dirty, -1, "kntr.common.compose.pulltorefresh.ComposableSingletons$PullToRefreshKt.lambda$1306555779.<anonymous> (PullToRefresh.kt:27)");
            }
            PullToRefreshIndicatorKt.PullToRefreshIndicator(s, null, $composer, $dirty & 14, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}