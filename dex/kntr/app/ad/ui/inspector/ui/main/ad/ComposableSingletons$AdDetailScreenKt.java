package kntr.app.ad.ui.inspector.ui.main.ad;

import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import kntr.app.ad.ui.inspector.ui.components.AppIcons;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: AdDetailScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$AdDetailScreenKt {
    public static final ComposableSingletons$AdDetailScreenKt INSTANCE = new ComposableSingletons$AdDetailScreenKt();

    /* renamed from: lambda$-1651744529  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f8lambda$1651744529 = ComposableLambdaKt.composableLambdaInstance(-1651744529, false, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.ComposableSingletons$AdDetailScreenKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1651744529$lambda$0;
            lambda__1651744529$lambda$0 = ComposableSingletons$AdDetailScreenKt.lambda__1651744529$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1651744529$lambda$0;
        }
    });

    /* renamed from: getLambda$-1651744529$ad_inspector_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m443getLambda$1651744529$ad_inspector_debug() {
        return f8lambda$1651744529;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1651744529$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C689@25929L209:AdDetailScreen.kt#rz1uci");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1651744529, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.ComposableSingletons$AdDetailScreenKt.lambda$-1651744529.<anonymous> (AdDetailScreen.kt:689)");
            }
            IconKt.Icon-ww6aTOc(AppIcons.INSTANCE.getArrowCircleRight(), "跳转", (Modifier) null, ColorKt.Color(4285231744L), $composer, 3126, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}