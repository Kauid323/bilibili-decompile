package im.session.common;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import bili.resource.im.Res;
import bili.resource.im.String0_commonMainKt;
import bili.resource.im.String1_commonMainKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: AntiHarassmentDialog.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"AntiHarassmentDialog", "", "onCancel", "Lkotlin/Function0;", "onConfirm", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AntiHarassmentDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AntiHarassmentDialog$lambda$0(Function0 function0, Function0 function02, int i2, Composer composer, int i3) {
        AntiHarassmentDialog(function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void AntiHarassmentDialog(final Function0<Unit> function0, final Function0<Unit> function02, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(function0, "onCancel");
        Intrinsics.checkNotNullParameter(function02, "onConfirm");
        Composer $composer2 = $composer.startRestartGroup(-369833835);
        ComposerKt.sourceInformation($composer2, "C(AntiHarassmentDialog)N(onCancel,onConfirm)19@438L47,20@505L47,18@407L212:AntiHarassmentDialog.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function02) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-369833835, $dirty2, -1, "im.session.common.AntiHarassmentDialog (AntiHarassmentDialog.kt:17)");
            }
            IMAlertDialogKt.IMAlertDialog(StringResourcesKt.stringResource(String0_commonMainKt.getIm_global_string_136(Res.string.INSTANCE), $composer2, 0), StringResourcesKt.stringResource(String1_commonMainKt.getIm_global_string_869(Res.string.INSTANCE), $composer2, 0), function0, function02, null, null, $composer2, (($dirty2 << 6) & 896) | (($dirty2 << 6) & 7168), 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.AntiHarassmentDialogKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit AntiHarassmentDialog$lambda$0;
                    AntiHarassmentDialog$lambda$0 = AntiHarassmentDialogKt.AntiHarassmentDialog$lambda$0(function0, function02, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return AntiHarassmentDialog$lambda$0;
                }
            });
        }
    }
}