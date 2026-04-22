package video.biz.offline.list.ui.page;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.lazy.LazyItemScope;
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

/* compiled from: OfflineHomePage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$OfflineHomePageKt {
    public static final ComposableSingletons$OfflineHomePageKt INSTANCE = new ComposableSingletons$OfflineHomePageKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$931481774 = ComposableLambdaKt.composableLambdaInstance(931481774, false, new Function3() { // from class: video.biz.offline.list.ui.page.ComposableSingletons$OfflineHomePageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_931481774$lambda$0;
            lambda_931481774$lambda$0 = ComposableSingletons$OfflineHomePageKt.lambda_931481774$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_931481774$lambda$0;
        }
    });

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$931481774$ui_debug() {
        return lambda$931481774;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_931481774$lambda$0(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C309@13278L9,310@13336L6,297@12726L645:OfflineHomePage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(931481774, $changed, -1, "video.biz.offline.list.ui.page.ComposableSingletons$OfflineHomePageKt.lambda$931481774.<anonymous> (OfflineHomePage.kt:297)");
            }
            TextKt.Text-Nvy7gAk(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2190(PlayerbaseresRes.INSTANCE.getString())), PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(10), Dp.constructor-impl(12), Dp.constructor-impl(10), Dp.constructor-impl(2)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16b(), $composer, 0, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}