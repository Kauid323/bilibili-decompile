package kntr.app.digital.backpack.tab;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: TabsService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$TabsServiceKt {
    public static final ComposableSingletons$TabsServiceKt INSTANCE = new ComposableSingletons$TabsServiceKt();
    private static Function2<Composer, Integer, Unit> lambda$856032371 = ComposableLambdaKt.composableLambdaInstance(856032371, false, new Function2() { // from class: kntr.app.digital.backpack.tab.ComposableSingletons$TabsServiceKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_856032371$lambda$0;
            lambda_856032371$lambda$0 = ComposableSingletons$TabsServiceKt.lambda_856032371$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_856032371$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$856032371$backpack_debug() {
        return lambda$856032371;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_856032371$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:TabsService.kt#i31ka1");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(856032371, $changed, -1, "kntr.app.digital.backpack.tab.ComposableSingletons$TabsServiceKt.lambda$856032371.<anonymous> (TabsService.kt:67)");
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