package tv.danmaku.bili.core.test;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.TextKt;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: CommonTestPage.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ComposableSingletons$CommonTestPageKt {
    public static final ComposableSingletons$CommonTestPageKt INSTANCE = new ComposableSingletons$CommonTestPageKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$753842377 = ComposableLambdaKt.composableLambdaInstance(753842377, false, new Function3() { // from class: tv.danmaku.bili.core.test.ComposableSingletons$CommonTestPageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_753842377$lambda$0;
            lambda_753842377$lambda$0 = ComposableSingletons$CommonTestPageKt.lambda_753842377$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_753842377$lambda$0;
        }
    });

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$753842377$core_apinkDebug() {
        return lambda$753842377;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_753842377$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C150@5320L58:CommonTestPage.kt#pxmn5u");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(753842377, $changed, -1, "tv.danmaku.bili.core.test.ComposableSingletons$CommonTestPageKt.lambda$753842377.<anonymous> (CommonTestPage.kt:150)");
            }
            TextKt.Text--4IGK_g("开始测试", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}