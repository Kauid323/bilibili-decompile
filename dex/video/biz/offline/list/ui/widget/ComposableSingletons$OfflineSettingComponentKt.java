package video.biz.offline.list.ui.widget;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineSettingComponent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$OfflineSettingComponentKt {
    public static final ComposableSingletons$OfflineSettingComponentKt INSTANCE = new ComposableSingletons$OfflineSettingComponentKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$902260533 = ComposableLambdaKt.composableLambdaInstance(902260533, false, new Function3() { // from class: video.biz.offline.list.ui.widget.ComposableSingletons$OfflineSettingComponentKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_902260533$lambda$0;
            lambda_902260533$lambda$0 = ComposableSingletons$OfflineSettingComponentKt.lambda_902260533$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_902260533$lambda$0;
        }
    });

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$902260533$ui_debug() {
        return lambda$902260533;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_902260533$lambda$0(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C89@3925L41:OfflineSettingComponent.kt#uys4uf");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(902260533, $changed, -1, "video.biz.offline.list.ui.widget.ComposableSingletons$OfflineSettingComponentKt.lambda$902260533.<anonymous> (OfflineSettingComponent.kt:89)");
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(15)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}