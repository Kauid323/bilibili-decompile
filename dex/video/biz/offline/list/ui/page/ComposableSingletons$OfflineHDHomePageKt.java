package video.biz.offline.list.ui.page;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineHDHomePage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$OfflineHDHomePageKt {
    public static final ComposableSingletons$OfflineHDHomePageKt INSTANCE = new ComposableSingletons$OfflineHDHomePageKt();
    private static Function3<LazyGridItemScope, Composer, Integer, Unit> lambda$1904004513 = ComposableLambdaKt.composableLambdaInstance(1904004513, false, new Function3() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$OfflineHDHomePageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_1904004513$lambda$0;
            lambda_1904004513$lambda$0 = ComposableSingletons$OfflineHDHomePageKt.lambda_1904004513$lambda$0((LazyGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_1904004513$lambda$0;
        }
    });

    public final Function3<LazyGridItemScope, Composer, Integer, Unit> getLambda$1904004513$ui_debug() {
        return lambda$1904004513;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1904004513$lambda$0(LazyGridItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C272@11474L9,273@11527L6,263@11049L508:OfflineHDHomePage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1904004513, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$OfflineHDHomePageKt.lambda$1904004513.<anonymous> (OfflineHDHomePage.kt:263)");
            }
            TextKt.Text-Nvy7gAk(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2190(PlayerbaseresRes.INSTANCE.getString())), PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(10), Dp.constructor-impl(12), Dp.constructor-impl(10), Dp.constructor-impl(2)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $composer, 0, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}