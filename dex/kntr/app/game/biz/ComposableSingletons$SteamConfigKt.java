package kntr.app.game.biz;

import androidx.compose.foundation.layout.RowScope;
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
import com.bilibili.compose.theme.BiliTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SteamConfig.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SteamConfigKt {
    public static final ComposableSingletons$SteamConfigKt INSTANCE = new ComposableSingletons$SteamConfigKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$55220472 = ComposableLambdaKt.composableLambdaInstance(55220472, false, new Function3() { // from class: kntr.app.game.biz.ComposableSingletons$SteamConfigKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_55220472$lambda$0;
            lambda_55220472$lambda$0 = ComposableSingletons$SteamConfigKt.lambda_55220472$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_55220472$lambda$0;
        }
    });

    /* renamed from: lambda$-598085535  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f24lambda$598085535 = ComposableLambdaKt.composableLambdaInstance(-598085535, false, new Function3() { // from class: kntr.app.game.biz.ComposableSingletons$SteamConfigKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__598085535$lambda$0;
            lambda__598085535$lambda$0 = ComposableSingletons$SteamConfigKt.lambda__598085535$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__598085535$lambda$0;
        }
    });

    /* renamed from: getLambda$-598085535$gamebiz_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1180getLambda$598085535$gamebiz_debug() {
        return f24lambda$598085535;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$55220472$gamebiz_debug() {
        return lambda$55220472;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_55220472$lambda$0(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C375@13573L9,376@13630L6,373@13488L232:SteamConfig.kt#351edr");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(55220472, $changed, -1, "kntr.app.game.biz.ComposableSingletons$SteamConfigKt.lambda$55220472.<anonymous> (SteamConfig.kt:373)");
            }
            TextKt.Text-Nvy7gAk("取消", (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $composer, 1572870, 0, 131002);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__598085535$lambda$0(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C399@14431L9,400@14488L6,397@14346L238:SteamConfig.kt#351edr");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-598085535, $changed, -1, "kntr.app.game.biz.ComposableSingletons$SteamConfigKt.lambda$-598085535.<anonymous> (SteamConfig.kt:397)");
            }
            TextKt.Text-Nvy7gAk("解绑", (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $composer, 1572870, 0, 131002);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}