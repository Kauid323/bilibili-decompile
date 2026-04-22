package kntr.app.ad.ui.inspector.ui.components;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetailScaffold.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$DetailScaffoldKt {
    public static final ComposableSingletons$DetailScaffoldKt INSTANCE = new ComposableSingletons$DetailScaffoldKt();

    /* renamed from: lambda$-698047502  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f6lambda$698047502 = ComposableLambdaKt.composableLambdaInstance(-698047502, false, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.components.ComposableSingletons$DetailScaffoldKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__698047502$lambda$0;
            lambda__698047502$lambda$0 = ComposableSingletons$DetailScaffoldKt.lambda__698047502$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__698047502$lambda$0;
        }
    });

    /* renamed from: lambda$-2095145208  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f5lambda$2095145208 = ComposableLambdaKt.composableLambdaInstance(-2095145208, false, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.ComposableSingletons$DetailScaffoldKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__2095145208$lambda$0;
            lambda__2095145208$lambda$0 = ComposableSingletons$DetailScaffoldKt.lambda__2095145208$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__2095145208$lambda$0;
        }
    });

    /* renamed from: getLambda$-2095145208$ad_inspector_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m391getLambda$2095145208$ad_inspector_debug() {
        return f5lambda$2095145208;
    }

    /* renamed from: getLambda$-698047502$ad_inspector_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m392getLambda$698047502$ad_inspector_debug() {
        return f6lambda$698047502;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__698047502$lambda$0(RowScope rowScope, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(rowScope, "<this>");
        ComposerKt.sourceInformation($composer, "C:DetailScaffold.kt#pigpjk");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-698047502, $changed, -1, "kntr.app.ad.ui.inspector.ui.components.ComposableSingletons$DetailScaffoldKt.lambda$-698047502.<anonymous> (DetailScaffold.kt:23)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2095145208$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C36@1313L53:DetailScaffold.kt#pigpjk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2095145208, $changed, -1, "kntr.app.ad.ui.inspector.ui.components.ComposableSingletons$DetailScaffoldKt.lambda$-2095145208.<anonymous> (DetailScaffold.kt:36)");
            }
            IconKt.Icon-ww6aTOc(AppIcons.INSTANCE.getArrowBack(), "Back", (Modifier) null, 0L, $composer, 54, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}