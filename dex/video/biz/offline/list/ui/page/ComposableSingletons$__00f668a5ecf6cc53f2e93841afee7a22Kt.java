package video.biz.offline.list.ui.page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: __00f668a5ecf6cc53f2e93841afee7a22.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$__00f668a5ecf6cc53f2e93841afee7a22Kt {
    public static final ComposableSingletons$__00f668a5ecf6cc53f2e93841afee7a22Kt INSTANCE = new ComposableSingletons$__00f668a5ecf6cc53f2e93841afee7a22Kt();

    /* renamed from: lambda$-218947513  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f12lambda$218947513 = ComposableLambdaKt.composableLambdaInstance(-218947513, false, new Function2() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$__00f668a5ecf6cc53f2e93841afee7a22Kt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__218947513$lambda$0;
            lambda__218947513$lambda$0 = ComposableSingletons$__00f668a5ecf6cc53f2e93841afee7a22Kt.lambda__218947513$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__218947513$lambda$0;
        }
    });

    /* renamed from: getLambda$-218947513$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2851getLambda$218947513$ui_debug() {
        return f12lambda$218947513;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__218947513$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C10@382L30:__00f668a5ecf6cc53f2e93841afee7a22.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-218947513, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$__00f668a5ecf6cc53f2e93841afee7a22Kt.lambda$-218947513.<anonymous> (__00f668a5ecf6cc53f2e93841afee7a22.kt:10)");
            }
            OfflineDataDiagnosePageKt.OfflineDataDiagnosePage($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}