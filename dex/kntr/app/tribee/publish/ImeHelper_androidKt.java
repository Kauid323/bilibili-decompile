package kntr.app.tribee.publish;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImeHelper.android.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a$\u0010\u0003\u001a\u00020\u00042\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"isImeVisible", "", "(Landroidx/compose/runtime/Composer;I)Z", "ConfigWindow", "", "block", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "setSupportImmersiveStatusBar", "window", "Landroid/view/Window;", "isNight", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImeHelper_androidKt {
    public static final boolean isImeVisible(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1456368489, "C(isImeVisible)22@861L12:ImeHelper.android.kt#ufloxe");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1456368489, $changed, -1, "kntr.app.tribee.publish.isImeVisible (ImeHelper.android.kt:22)");
        }
        boolean isImeVisible = WindowInsets_androidKt.isImeVisible(WindowInsets.Companion, $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return isImeVisible;
    }

    public static final void ConfigWindow(Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(function2, "block");
        ComposerKt.sourceInformationMarkerStart($composer, -824530859, "CC(ConfigWindow)N(block)27@1008L7:ImeHelper.android.kt#ufloxe");
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Activity activity = ContextUtilKt.findActivityOrNull((Context) consume);
        if (Build.VERSION.SDK_INT < 30 && activity != null) {
            $composer.startReplaceGroup(-680672859);
            ComposerKt.sourceInformation($composer, "29@1132L13,30@1201L251,30@1177L275");
            boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night;
            Boolean valueOf = Boolean.valueOf(isNight);
            ComposerKt.sourceInformationMarkerStart($composer, -2100163984, "CC(remember):ImeHelper.android.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(activity) | $composer.changed(isNight);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new ImeHelper_androidKt$ConfigWindow$1$1(activity, isNight, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer, 0);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-680320234);
            ComposerKt.sourceInformation($composer, "36@1474L7");
            function2.invoke($composer, Integer.valueOf($changed & 14));
            $composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void setSupportImmersiveStatusBar(Window window, boolean isNight) {
        Intrinsics.checkNotNullParameter(window, "window");
        if (Build.VERSION.SDK_INT > 28) {
            window.addFlags(67108864);
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            int flags = decorView.getSystemUiVisibility();
            if (!isNight) {
                decorView.setSystemUiVisibility(flags | 8192);
                return;
            } else {
                decorView.setSystemUiVisibility(flags & (-8193));
                return;
            }
        }
        window.setStatusBarColor(ColorKt.toArgb-8_81llA(Color.Companion.getTransparent-0d7_KjU()));
    }
}