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

/* compiled from: InputDialog.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$InputDialogKt {
    public static final ComposableSingletons$InputDialogKt INSTANCE = new ComposableSingletons$InputDialogKt();

    /* renamed from: lambda$-1791372376  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f39lambda$1791372376 = ComposableLambdaKt.composableLambdaInstance(-1791372376, false, new Function3() { // from class: kntr.base.dd.preview.ComposableSingletons$InputDialogKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1791372376$lambda$0;
            lambda__1791372376$lambda$0 = ComposableSingletons$InputDialogKt.lambda__1791372376$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1791372376$lambda$0;
        }
    });

    /* renamed from: lambda$-929538774  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f40lambda$929538774 = ComposableLambdaKt.composableLambdaInstance(-929538774, false, new Function3() { // from class: kntr.base.dd.preview.ComposableSingletons$InputDialogKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__929538774$lambda$0;
            lambda__929538774$lambda$0 = ComposableSingletons$InputDialogKt.lambda__929538774$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__929538774$lambda$0;
        }
    });

    /* renamed from: getLambda$-1791372376$preview_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1376getLambda$1791372376$preview_debug() {
        return f39lambda$1791372376;
    }

    /* renamed from: getLambda$-929538774$preview_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1377getLambda$929538774$preview_debug() {
        return f40lambda$929538774;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1791372376$lambda$0(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C64@2213L10:InputDialog.kt#veq8ty");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1791372376, $changed, -1, "kntr.base.dd.preview.ComposableSingletons$InputDialogKt.lambda$-1791372376.<anonymous> (InputDialog.kt:64)");
            }
            TextKt.Text-Nvy7gAk("确定", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__929538774$lambda$0(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C69@2337L10:InputDialog.kt#veq8ty");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-929538774, $changed, -1, "kntr.base.dd.preview.ComposableSingletons$InputDialogKt.lambda$-929538774.<anonymous> (InputDialog.kt:69)");
            }
            TextKt.Text-Nvy7gAk("取消", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}