package tv.danmaku.bili.ui.watchlater.compose;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.studio.videoeditor.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterPageCompose.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$WatchLaterPageComposeKt {
    public static final ComposableSingletons$WatchLaterPageComposeKt INSTANCE = new ComposableSingletons$WatchLaterPageComposeKt();
    private static Function2<Composer, Integer, Unit> lambda$622589982 = ComposableLambdaKt.composableLambdaInstance(622589982, false, new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.ComposableSingletons$WatchLaterPageComposeKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_622589982$lambda$0;
            lambda_622589982$lambda$0 = ComposableSingletons$WatchLaterPageComposeKt.lambda_622589982$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_622589982$lambda$0;
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1092728423 = ComposableLambdaKt.composableLambdaInstance(1092728423, false, new Function3() { // from class: tv.danmaku.bili.ui.watchlater.compose.ComposableSingletons$WatchLaterPageComposeKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_1092728423$lambda$0;
            lambda_1092728423$lambda$0 = ComposableSingletons$WatchLaterPageComposeKt.lambda_1092728423$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_1092728423$lambda$0;
        }
    });

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1092728423$core_apinkDebug() {
        return lambda$1092728423;
    }

    public final Function2<Composer, Integer, Unit> getLambda$622589982$core_apinkDebug() {
        return lambda$622589982;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_622589982$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C173@7099L83,178@7394L11,172@7063L371:WatchLaterPageCompose.kt#ooxe70");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(622589982, $changed, -1, "tv.danmaku.bili.ui.watchlater.compose.ComposableSingletons$WatchLaterPageComposeKt.lambda$622589982.<anonymous> (WatchLaterPageCompose.kt:172)");
            }
            IconKt.Icon-ww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_arrow_back_left, $composer, 0), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 14, (Object) null), Dp.constructor-impl(24)), BiliTheme.INSTANCE.getThemeColors($composer, BiliTheme.$stable).getActionIcon-0d7_KjU(), $composer, Painter.$stable | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1092728423$lambda$0(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C471@18424L41:WatchLaterPageCompose.kt#ooxe70");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1092728423, $changed, -1, "tv.danmaku.bili.ui.watchlater.compose.ComposableSingletons$WatchLaterPageComposeKt.lambda$1092728423.<anonymous> (WatchLaterPageCompose.kt:471)");
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}