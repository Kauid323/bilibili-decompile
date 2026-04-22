package im.contact;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: __5ed7e5cfed49b4add8d6510e28ff0227.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$__5ed7e5cfed49b4add8d6510e28ff0227Kt {
    public static final ComposableSingletons$__5ed7e5cfed49b4add8d6510e28ff0227Kt INSTANCE = new ComposableSingletons$__5ed7e5cfed49b4add8d6510e28ff0227Kt();

    /* renamed from: lambda$-1266692422  reason: not valid java name */
    private static Function3<Modifier, Composer, Integer, Unit> f1039lambda$1266692422 = ComposableLambdaKt.composableLambdaInstance(-1266692422, false, new Function3() { // from class: im.contact.ComposableSingletons$__5ed7e5cfed49b4add8d6510e28ff0227Kt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1266692422$lambda$0;
            lambda__1266692422$lambda$0 = ComposableSingletons$__5ed7e5cfed49b4add8d6510e28ff0227Kt.lambda__1266692422$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1266692422$lambda$0;
        }
    });

    /* renamed from: getLambda$-1266692422$contact_ui_debug  reason: not valid java name */
    public final Function3<Modifier, Composer, Integer, Unit> m3123getLambda$1266692422$contact_ui_debug() {
        return f1039lambda$1266692422;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1266692422$lambda$0(Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(modifier)11@420L47:__5ed7e5cfed49b4add8d6510e28ff0227.kt#f3r7fa");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(modifier) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1266692422, $dirty, -1, "im.contact.ComposableSingletons$__5ed7e5cfed49b4add8d6510e28ff0227Kt.lambda$-1266692422.<anonymous> (__5ed7e5cfed49b4add8d6510e28ff0227.kt:11)");
            }
            IMContactPageKt.IMContactPage(modifier, $composer, $dirty & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}