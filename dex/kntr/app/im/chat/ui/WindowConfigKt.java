package kntr.app.im.chat.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WindowConfig.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"WindowConfig", RoomRecommendViewModel.EMPTY_CURSOR, "isNight", RoomRecommendViewModel.EMPTY_CURSOR, "(ZLandroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class WindowConfigKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WindowConfig$lambda$1(boolean z, int i, Composer composer, int i2) {
        WindowConfig(z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x011e, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void WindowConfig(final boolean isNight, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1055756340);
        ComposerKt.sourceInformation($composer2, "C(WindowConfig)N(isNight)8@233L169:WindowConfig.kt#f7dpja");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(isNight) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1055756340, $dirty, -1, "kntr.app.im.chat.ui.WindowConfig (WindowConfig.kt:7)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 726984459, "CC(ConfigWindow)N(block)16@580L7:IMAssistantChatPage.android.kt#f7dpja");
            CompositionLocal this_$iv$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Activity activity$iv = ContextUtilKt.findActivityOrNull((Context) consume);
            if (Build.VERSION.SDK_INT >= 30 || activity$iv == null) {
                $composer2.startReplaceGroup(-1925587712);
                ComposerKt.sourceInformation($composer2, "24@979L7");
                boolean z = false & true;
                ComposerKt.sourceInformationMarkerStart($composer2, 1566636426, "C9@273L28,10@334L62,10@310L86:WindowConfig.kt#f7dpja");
                SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer2, 0);
                Boolean valueOf = Boolean.valueOf(isNight);
                ComposerKt.sourceInformationMarkerStart($composer2, -1889123573, "CC(remember):WindowConfig.kt#9igjgp");
                boolean invalid$iv = $composer2.changed(controller) | (($dirty & 14) == 4);
                WindowConfigKt$WindowConfig$1$1$1 value$iv = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                value$iv = new WindowConfigKt$WindowConfig$1$1$1(controller, isNight, null);
                $composer2.updateRememberedValue(value$iv);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(valueOf, (Function2) value$iv, $composer2, $dirty & 14);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1925875950);
                ComposerKt.sourceInformation($composer2, "18@704L13,19@773L184,19@749L208");
                boolean isNight$iv = BiliTheme.INSTANCE.getDayNightTheme($composer2, BiliTheme.$stable) == ThemeDayNight.Night;
                Boolean valueOf2 = Boolean.valueOf(isNight$iv);
                ComposerKt.sourceInformationMarkerStart($composer2, -1447595165, "CC(remember):IMAssistantChatPage.android.kt#9igjgp");
                boolean invalid$iv$iv = $composer2.changedInstance(activity$iv);
                Object it$iv$iv = $composer2.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                    Object value$iv$iv = (Function2) new IMAssistantChatPage_androidKt$ConfigWindow$1$1(activity$iv, null);
                    $composer2.updateRememberedValue(value$iv$iv);
                    it$iv$iv = value$iv$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv$iv, $composer2, 0);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.WindowConfigKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit WindowConfig$lambda$1;
                    WindowConfig$lambda$1 = WindowConfigKt.WindowConfig$lambda$1(isNight, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return WindowConfig$lambda$1;
                }
            });
        }
    }
}