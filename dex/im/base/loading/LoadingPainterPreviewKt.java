package im.base.loading;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: LoadingPainterPreview.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"LoadingPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LoadingPainterPreviewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingPreview$lambda$0(int i2, Composer composer, int i3) {
        LoadingPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void LoadingPreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(203980344);
        ComposerKt.sourceInformation($composer2, "C(LoadingPreview)21@616L180:LoadingPainterPreview.kt#fuuht5");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(203980344, $changed, -1, "im.base.loading.LoadingPreview (LoadingPainterPreview.kt:20)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableSingletons$LoadingPainterPreviewKt.INSTANCE.m3111getLambda$487192704$base_ui_debug(), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.base.loading.LoadingPainterPreviewKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoadingPreview$lambda$0;
                    LoadingPreview$lambda$0 = LoadingPainterPreviewKt.LoadingPreview$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return LoadingPreview$lambda$0;
                }
            });
        }
    }
}