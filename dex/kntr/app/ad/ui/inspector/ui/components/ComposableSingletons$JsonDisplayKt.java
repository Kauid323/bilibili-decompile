package kntr.app.ad.ui.inspector.ui.components;

import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: JsonDisplay.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$JsonDisplayKt {
    public static final ComposableSingletons$JsonDisplayKt INSTANCE = new ComposableSingletons$JsonDisplayKt();
    private static Function2<Composer, Integer, Unit> lambda$1851363493 = ComposableLambdaKt.composableLambdaInstance(1851363493, false, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.ComposableSingletons$JsonDisplayKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1851363493$lambda$0;
            lambda_1851363493$lambda$0 = ComposableSingletons$JsonDisplayKt.lambda_1851363493$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1851363493$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1851363493$ad_inspector_debug() {
        return lambda$1851363493;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1851363493$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C121@4937L198:JsonDisplay.kt#pigpjk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1851363493, $changed, -1, "kntr.app.ad.ui.inspector.ui.components.ComposableSingletons$JsonDisplayKt.lambda$1851363493.<anonymous> (JsonDisplay.kt:121)");
            }
            IconKt.Icon-ww6aTOc(AppIcons.INSTANCE.getClose(), "清除", (Modifier) null, ColorKt.Color(4284773515L), $composer, 3126, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}