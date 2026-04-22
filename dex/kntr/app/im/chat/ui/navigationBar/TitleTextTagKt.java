package kntr.app.im.chat.ui.navigationBar;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TitleTextTag.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"TitleTextTag", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "color", "Landroidx/compose/ui/graphics/Color;", "TitleTextTag-RPmYEkk", "(Ljava/lang/String;JLandroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TitleTextTagKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TitleTextTag_RPmYEkk$lambda$0(String str, long j2, int i, Composer composer, int i2) {
        m1881TitleTextTagRPmYEkk(str, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* renamed from: TitleTextTag-RPmYEkk  reason: not valid java name */
    public static final void m1881TitleTextTagRPmYEkk(final String text, final long j2, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(-666835131);
        ComposerKt.sourceInformation($composer3, "C(TitleTextTag)N(text,color:c#ui.graphics.Color)28@895L9,18@566L349:TitleTextTag.kt#idrobv");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(text) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(j2) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-666835131, $dirty2, -1, "kntr.app.im.chat.ui.navigationBar.TitleTextTag (TitleTextTag.kt:17)");
            }
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(text, PaddingKt.padding-VpY3zN4(BorderKt.border-xT4_qwU(Modifier.Companion, Dp.constructor-impl((float) 0.5d), j2, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(4), Dp.constructor-impl(2)), j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT10(), $composer2, ($dirty2 & 14) | (($dirty2 << 3) & 896), 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.navigationBar.TitleTextTagKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit TitleTextTag_RPmYEkk$lambda$0;
                    TitleTextTag_RPmYEkk$lambda$0 = TitleTextTagKt.TitleTextTag_RPmYEkk$lambda$0(text, j2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return TitleTextTag_RPmYEkk$lambda$0;
                }
            });
        }
    }
}