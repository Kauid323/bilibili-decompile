package im.session.home;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: __f0e1517fc0b0c0049a6d8dc182051933.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$__f0e1517fc0b0c0049a6d8dc182051933Kt {
    public static final ComposableSingletons$__f0e1517fc0b0c0049a6d8dc182051933Kt INSTANCE = new ComposableSingletons$__f0e1517fc0b0c0049a6d8dc182051933Kt();
    private static Function2<Composer, Integer, Unit> lambda$263879560 = ComposableLambdaKt.composableLambdaInstance(263879560, false, new Function2() { // from class: im.session.home.ComposableSingletons$__f0e1517fc0b0c0049a6d8dc182051933Kt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_263879560$lambda$0;
            lambda_263879560$lambda$0 = ComposableSingletons$__f0e1517fc0b0c0049a6d8dc182051933Kt.lambda_263879560$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_263879560$lambda$0;
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$263879560$session_ui_debug() {
        return lambda$263879560;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_263879560$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C10@367L24:__f0e1517fc0b0c0049a6d8dc182051933.kt#kfobb3");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(263879560, $changed, -1, "im.session.home.ComposableSingletons$__f0e1517fc0b0c0049a6d8dc182051933Kt.lambda$263879560.<anonymous> (__f0e1517fc0b0c0049a6d8dc182051933.kt:10)");
            }
            IMSessionHomePageKt.IMSessionHomePage($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}