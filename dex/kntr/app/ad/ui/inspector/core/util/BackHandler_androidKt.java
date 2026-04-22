package kntr.app.ad.ui.inspector.core.util;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackHandler.android.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"BackHandler", RoomRecommendViewModel.EMPTY_CURSOR, "enabled", RoomRecommendViewModel.EMPTY_CURSOR, "onBack", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ad-inspector_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BackHandler_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackHandler$lambda$0(boolean z, Function0 function0, int i, Composer composer, int i2) {
        BackHandler(z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BackHandler(final boolean enabled, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(function0, "onBack");
        Composer $composer2 = $composer.startRestartGroup(-478410390);
        ComposerKt.sourceInformation($composer2, "C(BackHandler)N(enabled,onBack)10@254L54:BackHandler.android.kt#5qtqsx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(enabled) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-478410390, $dirty, -1, "kntr.app.ad.ui.inspector.core.util.BackHandler (BackHandler.android.kt:9)");
            }
            BackHandlerKt.BackHandler(enabled, function0, $composer2, ($dirty & 14) | ($dirty & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.core.util.BackHandler_androidKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit BackHandler$lambda$0;
                    BackHandler$lambda$0 = BackHandler_androidKt.BackHandler$lambda$0(enabled, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return BackHandler$lambda$0;
                }
            });
        }
    }
}