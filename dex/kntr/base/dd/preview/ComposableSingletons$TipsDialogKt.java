package kntr.base.dd.preview;

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

/* compiled from: TipsDialog.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$TipsDialogKt {
    public static final ComposableSingletons$TipsDialogKt INSTANCE = new ComposableSingletons$TipsDialogKt();

    /* renamed from: lambda$-472547643  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f43lambda$472547643 = ComposableLambdaKt.composableLambdaInstance(-472547643, false, new Function3() { // from class: kntr.base.dd.preview.ComposableSingletons$TipsDialogKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__472547643$lambda$0;
            lambda__472547643$lambda$0 = ComposableSingletons$TipsDialogKt.lambda__472547643$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__472547643$lambda$0;
        }
    });

    /* renamed from: getLambda$-472547643$preview_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1381getLambda$472547643$preview_debug() {
        return f43lambda$472547643;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__472547643$lambda$0(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C37@1165L17:TipsDialog.kt#veq8ty");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-472547643, $changed, -1, "kntr.base.dd.preview.ComposableSingletons$TipsDialogKt.lambda$-472547643.<anonymous> (TipsDialog.kt:37)");
            }
            TextKt.Text-Nvy7gAk("确认", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}