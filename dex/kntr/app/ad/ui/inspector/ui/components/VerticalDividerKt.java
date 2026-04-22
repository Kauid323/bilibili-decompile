package kntr.app.ad.ui.inspector.ui.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: VerticalDivider.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"VerticalDivider", RoomRecommendViewModel.EMPTY_CURSOR, "(Landroidx/compose/runtime/Composer;I)V", "ad-inspector_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VerticalDividerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDivider$lambda$0(int i, Composer composer, int i2) {
        VerticalDivider(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void VerticalDivider(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-562646596);
        ComposerKt.sourceInformation($composer2, "C(VerticalDivider)16@460L158:VerticalDivider.kt#pigpjk");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-562646596, $changed, -1, "kntr.app.ad.ui.inspector.ui.components.VerticalDivider (VerticalDivider.kt:15)");
            }
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), Dp.constructor-impl(1)), ColorKt.Color(4293257195L), (Shape) null, 2, (Object) null), $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.VerticalDividerKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit VerticalDivider$lambda$0;
                    VerticalDivider$lambda$0 = VerticalDividerKt.VerticalDivider$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return VerticalDivider$lambda$0;
                }
            });
        }
    }
}