package kntr.app.ad.ui.inspector.ui.components;

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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportList.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ReportListKt {
    public static final ComposableSingletons$ReportListKt INSTANCE = new ComposableSingletons$ReportListKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$150880998 = ComposableLambdaKt.composableLambdaInstance(150880998, false, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.components.ComposableSingletons$ReportListKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_150880998$lambda$0;
            lambda_150880998$lambda$0 = ComposableSingletons$ReportListKt.lambda_150880998$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_150880998$lambda$0;
        }
    });

    /* renamed from: lambda$-811093809  reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f7lambda$811093809 = ComposableLambdaKt.composableLambdaInstance(-811093809, false, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.components.ComposableSingletons$ReportListKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__811093809$lambda$0;
            lambda__811093809$lambda$0 = ComposableSingletons$ReportListKt.lambda__811093809$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__811093809$lambda$0;
        }
    });

    /* renamed from: getLambda$-811093809$ad_inspector_debug  reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m394getLambda$811093809$ad_inspector_debug() {
        return f7lambda$811093809;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$150880998$ad_inspector_debug() {
        return lambda$150880998;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_150880998$lambda$0(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C81@3091L41:ReportList.kt#pigpjk");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(150880998, $changed, -1, "kntr.app.ad.ui.inspector.ui.components.ComposableSingletons$ReportListKt.lambda$150880998.<anonymous> (ReportList.kt:81)");
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__811093809$lambda$0(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C115@4209L41:ReportList.kt#pigpjk");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-811093809, $changed, -1, "kntr.app.ad.ui.inspector.ui.components.ComposableSingletons$ReportListKt.lambda$-811093809.<anonymous> (ReportList.kt:115)");
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}