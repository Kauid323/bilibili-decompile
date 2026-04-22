package video.biz.offline.list.ui.page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: __51bb57ab0f8faedca66fc096b014bea6.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$__51bb57ab0f8faedca66fc096b014bea6Kt {
    public static final ComposableSingletons$__51bb57ab0f8faedca66fc096b014bea6Kt INSTANCE = new ComposableSingletons$__51bb57ab0f8faedca66fc096b014bea6Kt();
    private static Function2<Composer, Integer, Unit> lambda$2108200935 = ComposableLambdaKt.composableLambdaInstance(2108200935, false, new Function2() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$__51bb57ab0f8faedca66fc096b014bea6Kt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_2108200935$lambda$0;
            lambda_2108200935$lambda$0 = ComposableSingletons$__51bb57ab0f8faedca66fc096b014bea6Kt.lambda_2108200935$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_2108200935$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$2108200935$ui_debug() {
        return lambda$2108200935;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2108200935$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C10@382L24:__51bb57ab0f8faedca66fc096b014bea6.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2108200935, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$__51bb57ab0f8faedca66fc096b014bea6Kt.lambda$2108200935.<anonymous> (__51bb57ab0f8faedca66fc096b014bea6.kt:10)");
            }
            OfflineSearchPageKt.OfflineSearchPage($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}