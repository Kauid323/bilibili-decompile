package kntr.app.mall.product.details.page.ui.container;

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
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomContainer.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$BottomContainerKt {
    public static final ComposableSingletons$BottomContainerKt INSTANCE = new ComposableSingletons$BottomContainerKt();

    /* renamed from: lambda$-1613668596  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f4lambda$1613668596 = ComposableLambdaKt.composableLambdaInstance(-1613668596, false, new Function3() { // from class: kntr.app.mall.product.details.page.ui.container.ComposableSingletons$BottomContainerKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1613668596$lambda$0;
            lambda__1613668596$lambda$0 = ComposableSingletons$BottomContainerKt.lambda__1613668596$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1613668596$lambda$0;
        }
    });

    /* renamed from: getLambda$-1613668596$product_details_page_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m572getLambda$1613668596$product_details_page_debug() {
        return f4lambda$1613668596;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1613668596$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C256@12130L10:BottomContainer.kt#u9475x");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1613668596, $changed, -1, "kntr.app.mall.product.details.page.ui.container.ComposableSingletons$BottomContainerKt.lambda$-1613668596.<anonymous> (BottomContainer.kt:256)");
            }
            TextKt.Text-Nvy7gAk("关闭", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}