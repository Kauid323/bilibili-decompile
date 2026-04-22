package kntr.app.tribee.publish.ui.v2;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
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

/* compiled from: TribeePublishConfigWinidow.android.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"TribeePublishConfigWindow", "", "block", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "setSupportImmersiveStatusBar", "window", "Landroid/view/Window;", "isNight", "", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishConfigWinidow_androidKt {
    public static final void TribeePublishConfigWindow(Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(function2, "block");
        ComposerKt.sourceInformationMarkerStart($composer, -1903608649, "CC(TribeePublishConfigWindow)N(block)20@740L7:TribeePublishConfigWinidow.android.kt#oim1ra");
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Activity activity = ContextUtilKt.findActivityOrNull((Context) consume);
        if (Build.VERSION.SDK_INT < 30 && activity != null) {
            $composer.startReplaceGroup(343108707);
            ComposerKt.sourceInformation($composer, "22@864L13,23@933L251,23@909L275");
            boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night;
            Boolean valueOf = Boolean.valueOf(isNight);
            ComposerKt.sourceInformationMarkerStart($composer, 288165874, "CC(remember):TribeePublishConfigWinidow.android.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(activity) | $composer.changed(isNight);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new TribeePublishConfigWinidow_androidKt$TribeePublishConfigWindow$1$1(activity, isNight, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer, 0);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(343461332);
            ComposerKt.sourceInformation($composer, "29@1206L7");
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