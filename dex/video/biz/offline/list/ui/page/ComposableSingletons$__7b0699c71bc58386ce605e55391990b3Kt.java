package video.biz.offline.list.ui.page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: __7b0699c71bc58386ce605e55391990b3.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$__7b0699c71bc58386ce605e55391990b3Kt {
    public static final ComposableSingletons$__7b0699c71bc58386ce605e55391990b3Kt INSTANCE = new ComposableSingletons$__7b0699c71bc58386ce605e55391990b3Kt();
    private static Function2<Composer, Integer, Unit> lambda$943269959 = ComposableLambdaKt.composableLambdaInstance(943269959, false, new Function2() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$__7b0699c71bc58386ce605e55391990b3Kt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_943269959$lambda$0;
            lambda_943269959$lambda$0 = ComposableSingletons$__7b0699c71bc58386ce605e55391990b3Kt.lambda_943269959$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_943269959$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$943269959$ui_debug() {
        return lambda$943269959;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_943269959$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C10@382L33:__7b0699c71bc58386ce605e55391990b3.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(943269959, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$__7b0699c71bc58386ce605e55391990b3Kt.lambda$943269959.<anonymous> (__7b0699c71bc58386ce605e55391990b3.kt:10)");
            }
            OfflineStorageDiagnosePageKt.OfflineStorageDiagnosePage($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}