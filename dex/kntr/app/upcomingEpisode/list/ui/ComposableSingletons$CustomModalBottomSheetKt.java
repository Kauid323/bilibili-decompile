package kntr.app.upcomingEpisode.list.ui;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomModalBottomSheet.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$CustomModalBottomSheetKt {
    public static final ComposableSingletons$CustomModalBottomSheetKt INSTANCE = new ComposableSingletons$CustomModalBottomSheetKt();
    private static Function3<ColumnScope, Composer, Integer, Unit> lambda$1366023213 = ComposableLambdaKt.composableLambdaInstance(1366023213, false, new Function3() { // from class: kntr.app.upcomingEpisode.list.ui.ComposableSingletons$CustomModalBottomSheetKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_1366023213$lambda$0;
            lambda_1366023213$lambda$0 = ComposableSingletons$CustomModalBottomSheetKt.lambda_1366023213$lambda$0((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_1366023213$lambda$0;
        }
    });

    public final Function3<ColumnScope, Composer, Integer, Unit> getLambda$1366023213$main_debug() {
        return lambda$1366023213;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1366023213$lambda$0(ColumnScope columnScope, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        ComposerKt.sourceInformation($composer, "C:CustomModalBottomSheet.kt#kr57tx");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1366023213, $changed, -1, "kntr.app.upcomingEpisode.list.ui.ComposableSingletons$CustomModalBottomSheetKt.lambda$1366023213.<anonymous> (CustomModalBottomSheet.kt:26)");
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