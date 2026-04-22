package kntr.common.trio.systemui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SystemUI.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"setStatusBarByGarb", "", "Lkntr/common/trio/systemui/SystemUiController;", "(Lkntr/common/trio/systemui/SystemUiController;Landroidx/compose/runtime/Composer;I)V", "trio_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SystemUIKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setStatusBarByGarb$lambda$1(SystemUiController systemUiController, int i, Composer composer, int i2) {
        setStatusBarByGarb(systemUiController, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void setStatusBarByGarb(final SystemUiController $this$setStatusBarByGarb, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter($this$setStatusBarByGarb, "<this>");
        Composer $composer2 = $composer.startRestartGroup(-795372251);
        ComposerKt.sourceInformation($composer2, "C(setStatusBarByGarb)17@455L5,18@509L41,18@481L69:SystemUI.kt#kklx1l");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$setStatusBarByGarb) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-795372251, $dirty, -1, "kntr.common.trio.systemui.setStatusBarByGarb (SystemUI.kt:16)");
            }
            boolean darkContent = BiliTheme.INSTANCE.getTheme($composer2, BiliTheme.$stable).getShowDarkContent();
            Boolean valueOf = Boolean.valueOf(darkContent);
            ComposerKt.sourceInformationMarkerStart($composer2, 151449742, "CC(remember):SystemUI.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(darkContent) | (($dirty & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new SystemUIKt$setStatusBarByGarb$1$1($this$setStatusBarByGarb, darkContent, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.trio.systemui.SystemUIKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit statusBarByGarb$lambda$1;
                    statusBarByGarb$lambda$1 = SystemUIKt.setStatusBarByGarb$lambda$1(SystemUiController.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return statusBarByGarb$lambda$1;
                }
            });
        }
    }
}