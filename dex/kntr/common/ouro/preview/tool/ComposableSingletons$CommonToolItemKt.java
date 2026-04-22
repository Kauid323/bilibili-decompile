package kntr.common.ouro.preview.tool;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonToolItem.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$CommonToolItemKt {
    public static final ComposableSingletons$CommonToolItemKt INSTANCE = new ComposableSingletons$CommonToolItemKt();

    /* renamed from: lambda$-1672299161  reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f53lambda$1672299161 = ComposableLambdaKt.composableLambdaInstance(-1672299161, false, new Function3() { // from class: kntr.common.ouro.preview.tool.ComposableSingletons$CommonToolItemKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__1672299161$lambda$0;
            lambda__1672299161$lambda$0 = ComposableSingletons$CommonToolItemKt.lambda__1672299161$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__1672299161$lambda$0;
        }
    });

    /* renamed from: getLambda$-1672299161$ui_debug  reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m2079getLambda$1672299161$ui_debug() {
        return f53lambda$1672299161;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1672299161$lambda$0(RowScope rowScope, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(rowScope, "<this>");
        ComposerKt.sourceInformation($composer, "C:CommonToolItem.kt#gd7kur");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1672299161, $changed, -1, "kntr.common.ouro.preview.tool.ComposableSingletons$CommonToolItemKt.lambda$-1672299161.<anonymous> (CommonToolItem.kt:86)");
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