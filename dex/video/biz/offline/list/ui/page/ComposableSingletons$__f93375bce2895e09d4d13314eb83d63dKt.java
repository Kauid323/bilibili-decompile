package video.biz.offline.list.ui.page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: __f93375bce2895e09d4d13314eb83d63d.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$__f93375bce2895e09d4d13314eb83d63dKt {
    public static final ComposableSingletons$__f93375bce2895e09d4d13314eb83d63dKt INSTANCE = new ComposableSingletons$__f93375bce2895e09d4d13314eb83d63dKt();

    /* renamed from: lambda$-116046041  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f16lambda$116046041 = ComposableLambdaKt.composableLambdaInstance(-116046041, false, new Function2() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$__f93375bce2895e09d4d13314eb83d63dKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__116046041$lambda$0;
            lambda__116046041$lambda$0 = ComposableSingletons$__f93375bce2895e09d4d13314eb83d63dKt.lambda__116046041$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__116046041$lambda$0;
        }
    });

    /* renamed from: getLambda$-116046041$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2858getLambda$116046041$ui_debug() {
        return f16lambda$116046041;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__116046041$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C10@382L29:__f93375bce2895e09d4d13314eb83d63d.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-116046041, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$__f93375bce2895e09d4d13314eb83d63dKt.lambda$-116046041.<anonymous> (__f93375bce2895e09d4d13314eb83d63d.kt:10)");
            }
            OfflineDownloadingPageKt.OfflineDownloadingPage($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}