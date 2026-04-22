package im.keywordBlocking;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bili.resource.im.Res;
import bili.resource.im.String1_commonMainKt;
import im.base.IMTopBarKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: BlockingItemPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BlockingItemPageKt {
    public static final ComposableSingletons$BlockingItemPageKt INSTANCE = new ComposableSingletons$BlockingItemPageKt();
    private static Function2<Composer, Integer, Unit> lambda$1351735810 = ComposableLambdaKt.composableLambdaInstance(1351735810, false, new Function2() { // from class: im.keywordBlocking.ComposableSingletons$BlockingItemPageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1351735810$lambda$0;
            lambda_1351735810$lambda$0 = ComposableSingletons$BlockingItemPageKt.lambda_1351735810$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1351735810$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1351735810$keyword_blocking_ui_debug() {
        return lambda$1351735810;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1351735810$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C118@4264L49,118@4254L60:BlockingItemPage.kt#sbjqfg");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1351735810, $changed, -1, "im.keywordBlocking.ComposableSingletons$BlockingItemPageKt.lambda$1351735810.<anonymous> (BlockingItemPage.kt:118)");
            }
            IMTopBarKt.TextTitle(StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_866(Res.string.INSTANCE), $composer, 0), null, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}