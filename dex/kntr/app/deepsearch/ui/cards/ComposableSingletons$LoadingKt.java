package kntr.app.deepsearch.ui.cards;

import androidx.compose.foundation.layout.PaddingKt;
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

/* compiled from: Loading.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$LoadingKt {
    public static final ComposableSingletons$LoadingKt INSTANCE = new ComposableSingletons$LoadingKt();
    private static Function4<LazyItemScope, Integer, Composer, Integer, Unit> lambda$1266484395 = ComposableLambdaKt.composableLambdaInstance(1266484395, false, new Function4() { // from class: kntr.app.deepsearch.ui.cards.ComposableSingletons$LoadingKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_1266484395$lambda$0;
            lambda_1266484395$lambda$0 = ComposableSingletons$LoadingKt.lambda_1266484395$lambda$0((LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_1266484395$lambda$0;
        }
    });

    public final Function4<LazyItemScope, Integer, Composer, Integer, Unit> getLambda$1266484395$compose_debug() {
        return lambda$1266484395;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1266484395$lambda$0(LazyItemScope $this$item, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "CN(it)31@1313L100:Loading.kt#pp6rt");
        if (!$composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1266484395, $changed, -1, "kntr.app.deepsearch.ui.cards.ComposableSingletons$LoadingKt.lambda$1266484395.<anonymous> (Loading.kt:31)");
            }
            LoadingKt.Loading(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null), $composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}