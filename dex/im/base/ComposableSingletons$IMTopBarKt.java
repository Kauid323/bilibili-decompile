package im.base;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: IMTopBar.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$IMTopBarKt {
    public static final ComposableSingletons$IMTopBarKt INSTANCE = new ComposableSingletons$IMTopBarKt();

    /* renamed from: lambda$-1949318061  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f1036lambda$1949318061 = ComposableLambdaKt.composableLambdaInstance(-1949318061, false, new Function2() { // from class: im.base.ComposableSingletons$IMTopBarKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1949318061$lambda$0;
            lambda__1949318061$lambda$0 = ComposableSingletons$IMTopBarKt.lambda__1949318061$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1949318061$lambda$0;
        }
    });

    /* renamed from: getLambda$-1949318061$base_ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3066getLambda$1949318061$base_ui_debug() {
        return f1036lambda$1949318061;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1949318061$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:IMTopBar.kt#uu6lp7");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1949318061, $changed, -1, "im.base.ComposableSingletons$IMTopBarKt.lambda$-1949318061.<anonymous> (IMTopBar.kt:53)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}