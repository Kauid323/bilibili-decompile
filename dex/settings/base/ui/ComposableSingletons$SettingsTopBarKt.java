package settings.base.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: SettingsTopBar.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$SettingsTopBarKt {
    public static final ComposableSingletons$SettingsTopBarKt INSTANCE = new ComposableSingletons$SettingsTopBarKt();
    private static Function2<Composer, Integer, Unit> lambda$51232450 = ComposableLambdaKt.composableLambdaInstance(51232450, false, new Function2() { // from class: settings.base.ui.ComposableSingletons$SettingsTopBarKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_51232450$lambda$0;
            lambda_51232450$lambda$0 = ComposableSingletons$SettingsTopBarKt.lambda_51232450$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_51232450$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$51232450$base_debug() {
        return lambda$51232450;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_51232450$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:SettingsTopBar.kt#d1bdve");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(51232450, $changed, -1, "settings.base.ui.ComposableSingletons$SettingsTopBarKt.lambda$51232450.<anonymous> (SettingsTopBar.kt:38)");
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