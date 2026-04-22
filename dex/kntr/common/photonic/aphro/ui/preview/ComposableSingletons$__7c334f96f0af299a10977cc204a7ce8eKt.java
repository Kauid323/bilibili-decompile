package kntr.common.photonic.aphro.ui.preview;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: __7c334f96f0af299a10977cc204a7ce8e.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$__7c334f96f0af299a10977cc204a7ce8eKt {
    public static final ComposableSingletons$__7c334f96f0af299a10977cc204a7ce8eKt INSTANCE = new ComposableSingletons$__7c334f96f0af299a10977cc204a7ce8eKt();
    private static Function2<Composer, Integer, Unit> lambda$290328373 = ComposableLambdaKt.composableLambdaInstance(290328373, false, new Function2() { // from class: kntr.common.photonic.aphro.ui.preview.ComposableSingletons$__7c334f96f0af299a10977cc204a7ce8eKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_290328373$lambda$0;
            lambda_290328373$lambda$0 = ComposableSingletons$__7c334f96f0af299a10977cc204a7ce8eKt.lambda_290328373$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_290328373$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$290328373$ui_debug() {
        return lambda$290328373;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_290328373$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C10@389L18:__7c334f96f0af299a10977cc204a7ce8e.kt#n54g3c");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(290328373, $changed, -1, "kntr.common.photonic.aphro.ui.preview.ComposableSingletons$__7c334f96f0af299a10977cc204a7ce8eKt.lambda$290328373.<anonymous> (__7c334f96f0af299a10977cc204a7ce8e.kt:10)");
            }
            PreviewStubKt.PreviewStub($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}