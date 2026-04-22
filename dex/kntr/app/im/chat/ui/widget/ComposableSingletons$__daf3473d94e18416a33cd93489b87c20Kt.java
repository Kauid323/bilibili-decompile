package kntr.app.im.chat.ui.widget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: __daf3473d94e18416a33cd93489b87c20.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$__daf3473d94e18416a33cd93489b87c20Kt {
    public static final ComposableSingletons$__daf3473d94e18416a33cd93489b87c20Kt INSTANCE = new ComposableSingletons$__daf3473d94e18416a33cd93489b87c20Kt();
    private static Function2<Composer, Integer, Unit> lambda$1213819105 = ComposableLambdaKt.composableLambdaInstance(1213819105, false, new Function2() { // from class: kntr.app.im.chat.ui.widget.ComposableSingletons$__daf3473d94e18416a33cd93489b87c20Kt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1213819105$lambda$0;
            lambda_1213819105$lambda$0 = ComposableSingletons$__daf3473d94e18416a33cd93489b87c20Kt.lambda_1213819105$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1213819105$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1213819105$ui_debug() {
        return lambda$1213819105;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1213819105$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C10@378L29:__daf3473d94e18416a33cd93489b87c20.kt#92mklk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1213819105, $changed, -1, "kntr.app.im.chat.ui.widget.ComposableSingletons$__daf3473d94e18416a33cd93489b87c20Kt.lambda$1213819105.<anonymous> (__daf3473d94e18416a33cd93489b87c20.kt:10)");
            }
            PopupBubbleMenuKt.PopUpBubbleMenuPreview($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}