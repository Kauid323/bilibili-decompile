package kntr.base.localization.preview;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: __92a0c5f045eb5e410a349b60f8d87866.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$__92a0c5f045eb5e410a349b60f8d87866Kt {
    public static final ComposableSingletons$__92a0c5f045eb5e410a349b60f8d87866Kt INSTANCE = new ComposableSingletons$__92a0c5f045eb5e410a349b60f8d87866Kt();
    private static Function2<Composer, Integer, Unit> lambda$544705878 = ComposableLambdaKt.composableLambdaInstance(544705878, false, new Function2() { // from class: kntr.base.localization.preview.ComposableSingletons$__92a0c5f045eb5e410a349b60f8d87866Kt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_544705878$lambda$0;
            lambda_544705878$lambda$0 = ComposableSingletons$__92a0c5f045eb5e410a349b60f8d87866Kt.lambda_544705878$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_544705878$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$544705878$preview_debug() {
        return lambda$544705878;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_544705878$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C10@382L26:__92a0c5f045eb5e410a349b60f8d87866.kt#3k1zvn");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(544705878, $changed, -1, "kntr.base.localization.preview.ComposableSingletons$__92a0c5f045eb5e410a349b60f8d87866Kt.lambda$544705878.<anonymous> (__92a0c5f045eb5e410a349b60f8d87866.kt:10)");
            }
            LocalizationPreviewPageKt.LocalizationPreview($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}