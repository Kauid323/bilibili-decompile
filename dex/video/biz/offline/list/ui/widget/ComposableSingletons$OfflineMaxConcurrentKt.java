package video.biz.offline.list.ui.widget;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.playerbaseres.Res;
import bili.resource.playerbaseres.String0_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineMaxConcurrent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ComposableSingletons$OfflineMaxConcurrentKt {
    public static final ComposableSingletons$OfflineMaxConcurrentKt INSTANCE = new ComposableSingletons$OfflineMaxConcurrentKt();

    /* renamed from: lambda$-1158002462  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f17lambda$1158002462 = ComposableLambdaKt.composableLambdaInstance(-1158002462, false, new Function3() { // from class: video.biz.offline.list.ui.widget.ComposableSingletons$OfflineMaxConcurrentKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1158002462$lambda$0;
            lambda__1158002462$lambda$0 = ComposableSingletons$OfflineMaxConcurrentKt.lambda__1158002462$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1158002462$lambda$0;
        }
    });

    /* renamed from: getLambda$-1158002462$ui_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m2902getLambda$1158002462$ui_debug() {
        return f17lambda$1158002462;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1158002462$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C139@5598L87,141@5763L6,138@5565L279:OfflineMaxConcurrent.kt#uys4uf");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1158002462, $changed, -1, "video.biz.offline.list.ui.widget.ComposableSingletons$OfflineMaxConcurrentKt.lambda$-1158002462.<anonymous> (OfflineMaxConcurrent.kt:138)");
            }
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getPlayerbaseres_global_string_1569(Res.string.INSTANCE), $composer, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa8-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(15), (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 1597440, 0, 262058);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}