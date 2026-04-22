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
import androidx.compose.ui.text.style.TextOverflow;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.ui.utils.ColorUtilsKt;

/* compiled from: OfflinePageHeader.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$OfflinePageHeaderKt {
    public static final ComposableSingletons$OfflinePageHeaderKt INSTANCE = new ComposableSingletons$OfflinePageHeaderKt();
    private static Function2<Composer, Integer, Unit> lambda$1367181901 = ComposableLambdaKt.composableLambdaInstance(1367181901, false, new Function2() { // from class: video.biz.offline.list.ui.widget.ComposableSingletons$OfflinePageHeaderKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1367181901$lambda$0;
            lambda_1367181901$lambda$0 = ComposableSingletons$OfflinePageHeaderKt.lambda_1367181901$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1367181901$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1367181901$ui_debug() {
        return lambda$1367181901;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1367181901$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C143@5549L9,144@5584L19,141@5408L278:OfflinePageHeader.kt#uys4uf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1367181901, $changed, -1, "video.biz.offline.list.ui.widget.ComposableSingletons$OfflinePageHeaderKt.lambda$1367181901.<anonymous> (OfflinePageHeader.kt:141)");
            }
            TextKt.Text-Nvy7gAk(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2219(PlayerbaseresRes.INSTANCE.getString())), (Modifier) null, ColorUtilsKt.getHeaderTintTextColor($composer, 0), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 24960, 110586);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}