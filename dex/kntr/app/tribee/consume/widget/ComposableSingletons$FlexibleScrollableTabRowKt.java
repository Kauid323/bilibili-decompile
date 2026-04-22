package kntr.app.tribee.consume.widget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: FlexibleScrollableTabRow.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$FlexibleScrollableTabRowKt {
    public static final ComposableSingletons$FlexibleScrollableTabRowKt INSTANCE = new ComposableSingletons$FlexibleScrollableTabRowKt();
    private static Function2<Composer, Integer, Unit> lambda$851289432 = ComposableLambdaKt.composableLambdaInstance(851289432, false, new Function2() { // from class: kntr.app.tribee.consume.widget.ComposableSingletons$FlexibleScrollableTabRowKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_851289432$lambda$0;
            lambda_851289432$lambda$0 = ComposableSingletons$FlexibleScrollableTabRowKt.lambda_851289432$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_851289432$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$851289432$consume_debug() {
        return lambda$851289432;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_851289432$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:FlexibleScrollableTabRow.kt#vkdvar");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(851289432, $changed, -1, "kntr.app.tribee.consume.widget.ComposableSingletons$FlexibleScrollableTabRowKt.lambda$851289432.<anonymous> (FlexibleScrollableTabRow.kt:94)");
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