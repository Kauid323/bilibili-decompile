package video.biz.offline.list.ui.widget;

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
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflinePageFooter.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$OfflinePageFooterKt {
    public static final ComposableSingletons$OfflinePageFooterKt INSTANCE = new ComposableSingletons$OfflinePageFooterKt();
    private static Function2<Composer, Integer, Unit> lambda$1326090094 = ComposableLambdaKt.composableLambdaInstance(1326090094, false, new Function2() { // from class: video.biz.offline.list.ui.widget.ComposableSingletons$OfflinePageFooterKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1326090094$lambda$0;
            lambda_1326090094$lambda$0 = ComposableSingletons$OfflinePageFooterKt.lambda_1326090094$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1326090094$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1326090094$ui_debug() {
        return lambda$1326090094;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1326090094$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C54@2232L9,55@2281L6,52@2083L223:OfflinePageFooter.kt#uys4uf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1326090094, $changed, -1, "video.biz.offline.list.ui.widget.ComposableSingletons$OfflinePageFooterKt.lambda$1326090094.<anonymous> (OfflinePageFooter.kt:52)");
            }
            TextKt.Text-Nvy7gAk(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2176(PlayerbaseresRes.INSTANCE.getString())), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa8-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}