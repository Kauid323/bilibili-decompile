package tv.danmaku.bili.fullscreen;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import tv.danmaku.bili.BR;

/* compiled from: Preview.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"PreviewPasswordLogin", "", "(Landroidx/compose/runtime/Composer;I)V", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PreviewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewPasswordLogin$lambda$1(int i, Composer composer, int i2) {
        PreviewPasswordLogin(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PreviewPasswordLogin(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1014474270);
        ComposerKt.sourceInformation($composer2, "C(PreviewPasswordLogin)38@1434L7,39@1496L113,39@1475L134,44@1614L1579:Preview.kt#8ty1lm");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1014474270, $changed, -1, "tv.danmaku.bili.fullscreen.PreviewPasswordLogin (Preview.kt:37)");
            }
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Activity findActivityOrNull = ContextUtilKt.findActivityOrNull((Context) consume);
            Window window = findActivityOrNull != null ? findActivityOrNull.getWindow() : null;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 47806707, "CC(remember):Preview.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(window);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new PreviewKt$PreviewPasswordLogin$1$1(window, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer2, 6);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableSingletons$PreviewKt.INSTANCE.m1029getLambda$1677530214$accountui_apinkDebug(), $composer2, (int) BR.negativeBtnVisible, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.PreviewKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit PreviewPasswordLogin$lambda$1;
                    PreviewPasswordLogin$lambda$1 = PreviewKt.PreviewPasswordLogin$lambda$1($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return PreviewPasswordLogin$lambda$1;
                }
            });
        }
    }
}