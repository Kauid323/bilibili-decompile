package kntr.app.ad.ui.inspector.ui.main.request;

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

/* compiled from: RequestDetailScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$RequestDetailScreenKt {
    public static final ComposableSingletons$RequestDetailScreenKt INSTANCE = new ComposableSingletons$RequestDetailScreenKt();

    /* renamed from: lambda$-699926464  reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f9lambda$699926464 = ComposableLambdaKt.composableLambdaInstance(-699926464, false, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.main.request.ComposableSingletons$RequestDetailScreenKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__699926464$lambda$0;
            lambda__699926464$lambda$0 = ComposableSingletons$RequestDetailScreenKt.lambda__699926464$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__699926464$lambda$0;
        }
    });

    /* renamed from: getLambda$-699926464$ad_inspector_debug  reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m461getLambda$699926464$ad_inspector_debug() {
        return f9lambda$699926464;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__699926464$lambda$0(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C590@26027L41:RequestDetailScreen.kt#wtdq44");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-699926464, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.request.ComposableSingletons$RequestDetailScreenKt.lambda$-699926464.<anonymous> (RequestDetailScreen.kt:590)");
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}