package kntr.app.ad.ui.inspector.core.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.view.WindowInsetsControllerCompat;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SystemStatusBarColor.android.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"SystemStatusBarColor", RoomRecommendViewModel.EMPTY_CURSOR, "color", "Landroidx/compose/ui/graphics/Color;", "SystemStatusBarColor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)V", "ad-inspector_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SystemStatusBarColor_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SystemStatusBarColor_ek8zF_U$lambda$1(long j2, int i, Composer composer, int i2) {
        m352SystemStatusBarColorek8zF_U(j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* renamed from: SystemStatusBarColor-ek8zF_U  reason: not valid java name */
    public static final void m352SystemStatusBarColorek8zF_U(final long j2, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(107706069);
        ComposerKt.sourceInformation($composer2, "C(SystemStatusBarColor)N(color:c#ui.graphics.Color)12@439L7:SystemStatusBarColor.android.kt#5qtqsx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(j2) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(107706069, $dirty, -1, "kntr.app.ad.ui.inspector.core.util.SystemStatusBarColor (SystemStatusBarColor.android.kt:11)");
            }
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final View view = (View) consume;
            if (view.isInEditMode()) {
                $composer2.startReplaceGroup(330560461);
            } else {
                $composer2.startReplaceGroup(331045115);
                ComposerKt.sourceInformation($composer2, "14@496L375,14@485L386");
                ComposerKt.sourceInformationMarkerStart($composer2, 426321516, "CC(remember):SystemStatusBarColor.android.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(view) | (($dirty & 14) == 4);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.core.util.SystemStatusBarColor_androidKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit SystemStatusBarColor_ek8zF_U$lambda$0$0;
                            SystemStatusBarColor_ek8zF_U$lambda$0$0 = SystemStatusBarColor_androidKt.SystemStatusBarColor_ek8zF_U$lambda$0$0(view, j2);
                            return SystemStatusBarColor_ek8zF_U$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.SideEffect((Function0) it$iv, $composer2, 0);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.core.util.SystemStatusBarColor_androidKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit SystemStatusBarColor_ek8zF_U$lambda$1;
                    SystemStatusBarColor_ek8zF_U$lambda$1 = SystemStatusBarColor_androidKt.SystemStatusBarColor_ek8zF_U$lambda$1(j2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SystemStatusBarColor_ek8zF_U$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SystemStatusBarColor_ek8zF_U$lambda$0$0(View $view, long j2) {
        Context context = $view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Window window = ((Activity) context).getWindow();
        window.setStatusBarColor(ColorKt.toArgb-8_81llA(j2));
        double brightness = (Color.getRed-impl(j2) * 0.299d) + (Color.getGreen-impl(j2) * 0.587d) + (Color.getBlue-impl(j2) * 0.114d);
        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightStatusBars(brightness > 0.5d);
        return Unit.INSTANCE;
    }
}