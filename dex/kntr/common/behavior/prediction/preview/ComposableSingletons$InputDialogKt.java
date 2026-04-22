package kntr.common.behavior.prediction.preview;

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

    /* renamed from: lambda$-76038017  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f51lambda$76038017 = ComposableLambdaKt.composableLambdaInstance(-76038017, false, new Function3() { // from class: kntr.common.behavior.prediction.preview.ComposableSingletons$InputDialogKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__76038017$lambda$0;
            lambda__76038017$lambda$0 = ComposableSingletons$InputDialogKt.lambda__76038017$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__76038017$lambda$0;
        }
    });

    /* renamed from: lambda$-616467523  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f50lambda$616467523 = ComposableLambdaKt.composableLambdaInstance(-616467523, false, new Function3() { // from class: kntr.common.behavior.prediction.preview.ComposableSingletons$InputDialogKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__616467523$lambda$0;
            lambda__616467523$lambda$0 = ComposableSingletons$InputDialogKt.lambda__616467523$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__616467523$lambda$0;
        }
    });

    /* renamed from: getLambda$-616467523$preview_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1822getLambda$616467523$preview_debug() {
        return f50lambda$616467523;
    }

    /* renamed from: getLambda$-76038017$preview_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1823getLambda$76038017$preview_debug() {
        return f51lambda$76038017;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__76038017$lambda$0(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C58@2074L10:InputDialog.kt#9vm0wh");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-76038017, $changed, -1, "kntr.common.behavior.prediction.preview.ComposableSingletons$InputDialogKt.lambda$-76038017.<anonymous> (InputDialog.kt:58)");
            }
            TextKt.Text-Nvy7gAk("确定", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__616467523$lambda$0(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C63@2198L10:InputDialog.kt#9vm0wh");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-616467523, $changed, -1, "kntr.common.behavior.prediction.preview.ComposableSingletons$InputDialogKt.lambda$-616467523.<anonymous> (InputDialog.kt:63)");
            }
            TextKt.Text-Nvy7gAk("取消", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}