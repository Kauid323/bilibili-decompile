package video.biz.offline.list.ui.page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: __a0c71807c26e7f387cd80fae76699731.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$__a0c71807c26e7f387cd80fae76699731Kt {
    public static final ComposableSingletons$__a0c71807c26e7f387cd80fae76699731Kt INSTANCE = new ComposableSingletons$__a0c71807c26e7f387cd80fae76699731Kt();

    /* renamed from: lambda$-1344871097  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f14lambda$1344871097 = ComposableLambdaKt.composableLambdaInstance(-1344871097, false, new Function2() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$__a0c71807c26e7f387cd80fae76699731Kt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1344871097$lambda$0;
            lambda__1344871097$lambda$0 = ComposableSingletons$__a0c71807c26e7f387cd80fae76699731Kt.lambda__1344871097$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1344871097$lambda$0;
        }
    });

    /* renamed from: getLambda$-1344871097$ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2856getLambda$1344871097$ui_debug() {
        return f14lambda$1344871097;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1344871097$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C10@382L23:__a0c71807c26e7f387cd80fae76699731.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1344871097, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$__a0c71807c26e7f387cd80fae76699731Kt.lambda$-1344871097.<anonymous> (__a0c71807c26e7f387cd80fae76699731.kt:10)");
            }
            OfflineHomePageKt.OfflineCacheHome($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}