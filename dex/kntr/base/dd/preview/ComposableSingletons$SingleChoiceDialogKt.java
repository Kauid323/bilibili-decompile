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

/* compiled from: SingleChoiceDialog.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$SingleChoiceDialogKt {
    public static final ComposableSingletons$SingleChoiceDialogKt INSTANCE = new ComposableSingletons$SingleChoiceDialogKt();

    /* renamed from: lambda$-1421669516  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f41lambda$1421669516 = ComposableLambdaKt.composableLambdaInstance(-1421669516, false, new Function3() { // from class: kntr.base.dd.preview.ComposableSingletons$SingleChoiceDialogKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1421669516$lambda$0;
            lambda__1421669516$lambda$0 = ComposableSingletons$SingleChoiceDialogKt.lambda__1421669516$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1421669516$lambda$0;
        }
    });

    /* renamed from: lambda$-1962099022  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f42lambda$1962099022 = ComposableLambdaKt.composableLambdaInstance(-1962099022, false, new Function3() { // from class: kntr.base.dd.preview.ComposableSingletons$SingleChoiceDialogKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1962099022$lambda$0;
            lambda__1962099022$lambda$0 = ComposableSingletons$SingleChoiceDialogKt.lambda__1962099022$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1962099022$lambda$0;
        }
    });

    /* renamed from: getLambda$-1421669516$preview_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1379getLambda$1421669516$preview_debug() {
        return f41lambda$1421669516;
    }

    /* renamed from: getLambda$-1962099022$preview_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1380getLambda$1962099022$preview_debug() {
        return f42lambda$1962099022;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1421669516$lambda$0(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C62@2331L10:SingleChoiceDialog.kt#veq8ty");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1421669516, $changed, -1, "kntr.base.dd.preview.ComposableSingletons$SingleChoiceDialogKt.lambda$-1421669516.<anonymous> (SingleChoiceDialog.kt:62)");
            }
            TextKt.Text-Nvy7gAk("确定", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1962099022$lambda$0(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C67@2455L10:SingleChoiceDialog.kt#veq8ty");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1962099022, $changed, -1, "kntr.base.dd.preview.ComposableSingletons$SingleChoiceDialogKt.lambda$-1962099022.<anonymous> (SingleChoiceDialog.kt:67)");
            }
            TextKt.Text-Nvy7gAk("取消", (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}