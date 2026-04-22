package kntr.base.dd.preview;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: __1e400856e658df27b5cf04a3efd9fba2.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$__1e400856e658df27b5cf04a3efd9fba2Kt {
    public static final ComposableSingletons$__1e400856e658df27b5cf04a3efd9fba2Kt INSTANCE = new ComposableSingletons$__1e400856e658df27b5cf04a3efd9fba2Kt();
    private static Function2<Composer, Integer, Unit> lambda$1058200015 = ComposableLambdaKt.composableLambdaInstance(1058200015, false, new Function2() { // from class: kntr.base.dd.preview.ComposableSingletons$__1e400856e658df27b5cf04a3efd9fba2Kt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1058200015$lambda$0;
            lambda_1058200015$lambda$0 = ComposableSingletons$__1e400856e658df27b5cf04a3efd9fba2Kt.lambda_1058200015$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1058200015$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1058200015$preview_debug() {
        return lambda$1058200015;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1058200015$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C10@372L24:__1e400856e658df27b5cf04a3efd9fba2.kt#veq8ty");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1058200015, $changed, -1, "kntr.base.dd.preview.ComposableSingletons$__1e400856e658df27b5cf04a3efd9fba2Kt.lambda$1058200015.<anonymous> (__1e400856e658df27b5cf04a3efd9fba2.kt:10)");
            }
            DDDebuggerPreviewKt.DDDebuggerPreview($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}