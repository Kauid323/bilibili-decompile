package video.biz.offline.list.ui.page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: __55d77e3b899c2fac15d496720aaa1d55.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$__55d77e3b899c2fac15d496720aaa1d55Kt {
    public static final ComposableSingletons$__55d77e3b899c2fac15d496720aaa1d55Kt INSTANCE = new ComposableSingletons$__55d77e3b899c2fac15d496720aaa1d55Kt();

    /* renamed from: lambda$-844544377  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f13lambda$844544377 = ComposableLambdaKt.composableLambdaInstance(-844544377, false, new Function2() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$__55d77e3b899c2fac15d496720aaa1d55Kt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__844544377$lambda$0;
            lambda__844544377$lambda$0 = ComposableSingletons$__55d77e3b899c2fac15d496720aaa1d55Kt.lambda__844544377$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__844544377$lambda$0;
        }
    });

    /* renamed from: getLambda$-844544377$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2854getLambda$844544377$ui_debug() {
        return f13lambda$844544377;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__844544377$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C10@382L24:__55d77e3b899c2fac15d496720aaa1d55.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-844544377, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$__55d77e3b899c2fac15d496720aaa1d55Kt.lambda$-844544377.<anonymous> (__55d77e3b899c2fac15d496720aaa1d55.kt:10)");
            }
            OfflineHDHomePageKt.OfflineHDHomePage($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}