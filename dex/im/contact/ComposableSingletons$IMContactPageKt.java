package im.contact;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bili.resource.im.Res;
import bili.resource.im.String0_commonMainKt;
import im.base.IMTopBarKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: IMContactPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$IMContactPageKt {
    public static final ComposableSingletons$IMContactPageKt INSTANCE = new ComposableSingletons$IMContactPageKt();
    private static Function2<Composer, Integer, Unit> lambda$1851973866 = ComposableLambdaKt.composableLambdaInstance(1851973866, false, new Function2() { // from class: im.contact.ComposableSingletons$IMContactPageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_1851973866$lambda$0;
            lambda_1851973866$lambda$0 = ComposableSingletons$IMContactPageKt.lambda_1851973866$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_1851973866$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1851973866$contact_ui_debug() {
        return lambda$1851973866;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1851973866$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C84@3114L47,84@3096L66:IMContactPage.kt#f3r7fa");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1851973866, $changed, -1, "im.contact.ComposableSingletons$IMContactPageKt.lambda$1851973866.<anonymous> (IMContactPage.kt:84)");
            }
            IMTopBarKt.TextTitle(StringResourcesKt.stringResource(String0_commonMainKt.getIm_global_string_142(Res.string.INSTANCE), $composer, 0), null, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}