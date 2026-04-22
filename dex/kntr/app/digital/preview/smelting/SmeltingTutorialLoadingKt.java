package kntr.app.digital.preview.smelting;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SmeltingTutorialLoading.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"SmeltingTutorialLoading", RoomRecommendViewModel.EMPTY_CURSOR, "onDismiss", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SmeltingTutorialLoadingKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmeltingTutorialLoading$lambda$0(Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SmeltingTutorialLoading(function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SmeltingTutorialLoading(final Function0<Unit> function0, final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer $composer2 = $composer.startRestartGroup(-396405030);
        ComposerKt.sourceInformation($composer2, "C(SmeltingTutorialLoading)N(onDismiss,modifier)13@387L169:SmeltingTutorialLoading.kt#smaoud");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-396405030, $dirty, -1, "kntr.app.digital.preview.smelting.SmeltingTutorialLoading (SmeltingTutorialLoading.kt:12)");
            }
            SmeltingTutorialUIKt.SmeltingTutorialTopBar(function0, SizeKt.height-3ABfNKs(WindowInsetsPadding_androidKt.statusBarsPadding(modifier), Dp.constructor-impl(44)), $composer2, $dirty & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.digital.preview.smelting.SmeltingTutorialLoadingKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit SmeltingTutorialLoading$lambda$0;
                    SmeltingTutorialLoading$lambda$0 = SmeltingTutorialLoadingKt.SmeltingTutorialLoading$lambda$0(function0, modifier, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SmeltingTutorialLoading$lambda$0;
                }
            });
        }
    }
}