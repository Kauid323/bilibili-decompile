package kntr.app.deepsearch.ui.list;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentBody.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ContentBodyKt {
    public static final ComposableSingletons$ContentBodyKt INSTANCE = new ComposableSingletons$ContentBodyKt();
    private static Function4<LazyItemScope, Integer, Composer, Integer, Unit> lambda$929561101 = ComposableLambdaKt.composableLambdaInstance(929561101, false, new Function4() { // from class: kntr.app.deepsearch.ui.list.ComposableSingletons$ContentBodyKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_929561101$lambda$0;
            lambda_929561101$lambda$0 = ComposableSingletons$ContentBodyKt.lambda_929561101$lambda$0((LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_929561101$lambda$0;
        }
    });

    public final Function4<LazyItemScope, Integer, Composer, Integer, Unit> getLambda$929561101$compose_debug() {
        return lambda$929561101;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_929561101$lambda$0(LazyItemScope $this$item, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "CN(it)37@1489L41:ContentBody.kt#4jzcco");
        if (!$composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(929561101, $changed, -1, "kntr.app.deepsearch.ui.list.ComposableSingletons$ContentBodyKt.lambda$929561101.<anonymous> (ContentBody.kt:37)");
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}