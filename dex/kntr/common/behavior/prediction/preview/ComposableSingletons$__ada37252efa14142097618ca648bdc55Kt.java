package kntr.common.behavior.prediction.preview;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: __ada37252efa14142097618ca648bdc55.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$__ada37252efa14142097618ca648bdc55Kt {
    public static final ComposableSingletons$__ada37252efa14142097618ca648bdc55Kt INSTANCE = new ComposableSingletons$__ada37252efa14142097618ca648bdc55Kt();
    private static Function2<Composer, Integer, Unit> lambda$1185962824 = ComposableLambdaKt.composableLambdaInstance(1185962824, false, new Function2() { // from class: kntr.common.behavior.prediction.preview.ComposableSingletons$__ada37252efa14142097618ca648bdc55Kt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1185962824$lambda$0;
            lambda_1185962824$lambda$0 = ComposableSingletons$__ada37252efa14142097618ca648bdc55Kt.lambda_1185962824$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1185962824$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1185962824$preview_debug() {
        return lambda$1185962824;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1185962824$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C10@391L28:__ada37252efa14142097618ca648bdc55.kt#9vm0wh");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1185962824, $changed, -1, "kntr.common.behavior.prediction.preview.ComposableSingletons$__ada37252efa14142097618ca648bdc55Kt.lambda$1185962824.<anonymous> (__ada37252efa14142097618ca648bdc55.kt:10)");
            }
            BPVideoQualityPreviewKt.BPVideoQualityPreview($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}