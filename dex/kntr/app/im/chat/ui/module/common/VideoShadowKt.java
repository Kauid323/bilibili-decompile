package kntr.app.im.chat.ui.module.common;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;

/* compiled from: VideoShadow.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"VideoShadow", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VideoShadowKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoShadow$lambda$0(Modifier modifier, int i, int i2, Composer composer, int i3) {
        VideoShadow(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void VideoShadow(Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(-519032318);
        ComposerKt.sourceInformation($composer2, "C(VideoShadow)N(modifier)12@416L403:VideoShadow.kt#i6gipz");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-519032318, $dirty, -1, "kntr.app.im.chat.ui.module.common.VideoShadow (VideoShadow.kt:11)");
            }
            BoxKt.Box(BackgroundKt.background$default(modifier3, Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null))}), 0L, Offset.copy-dBAh8RU$default(Offset.Companion.getInfinite-F1C5BW0(), 0.0f, 0.0f, 2, (Object) null), 0, 10, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.common.VideoShadowKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit VideoShadow$lambda$0;
                    VideoShadow$lambda$0 = VideoShadowKt.VideoShadow$lambda$0(modifier3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return VideoShadow$lambda$0;
                }
            });
        }
    }
}