package im.base.loading;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: __8b45085db97f0ceb7444b53cf357ee09.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$__8b45085db97f0ceb7444b53cf357ee09Kt {
    public static final ComposableSingletons$__8b45085db97f0ceb7444b53cf357ee09Kt INSTANCE = new ComposableSingletons$__8b45085db97f0ceb7444b53cf357ee09Kt();

    /* renamed from: lambda$-985780536  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f1038lambda$985780536 = ComposableLambdaKt.composableLambdaInstance(-985780536, false, new Function2() { // from class: im.base.loading.ComposableSingletons$__8b45085db97f0ceb7444b53cf357ee09Kt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__985780536$lambda$0;
            lambda__985780536$lambda$0 = ComposableSingletons$__8b45085db97f0ceb7444b53cf357ee09Kt.lambda__985780536$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__985780536$lambda$0;
        }
    });

    /* renamed from: getLambda$-985780536$base_ui_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3112getLambda$985780536$base_ui_debug() {
        return f1038lambda$985780536;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__985780536$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C10@367L21:__8b45085db97f0ceb7444b53cf357ee09.kt#fuuht5");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-985780536, $changed, -1, "im.base.loading.ComposableSingletons$__8b45085db97f0ceb7444b53cf357ee09Kt.lambda$-985780536.<anonymous> (__8b45085db97f0ceb7444b53cf357ee09.kt:10)");
            }
            LoadingPainterPreviewKt.LoadingPreview($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}