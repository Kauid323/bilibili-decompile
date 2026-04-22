package video.biz.offline.list.ui.widget;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BottomDivider.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"drawBottomDivider", "Landroidx/compose/ui/Modifier;", "drawDivider", "", "color", "Landroidx/compose/ui/graphics/Color;", "drawBottomDivider-mxwnekA", "(Landroidx/compose/ui/Modifier;ZJ)Landroidx/compose/ui/Modifier;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BottomDividerKt {
    /* renamed from: drawBottomDivider-mxwnekA$default */
    public static /* synthetic */ Modifier m2901drawBottomDividermxwnekA$default(Modifier modifier, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return m2900drawBottomDividermxwnekA(modifier, z, j);
    }

    /* renamed from: drawBottomDivider-mxwnekA */
    public static final Modifier m2900drawBottomDividermxwnekA(Modifier $this$drawBottomDivider_u2dmxwnekA, final boolean drawDivider, final long j) {
        Intrinsics.checkNotNullParameter($this$drawBottomDivider_u2dmxwnekA, "$this$drawBottomDivider");
        return DrawModifierKt.drawWithContent($this$drawBottomDivider_u2dmxwnekA, new Function1() { // from class: video.biz.offline.list.ui.widget.BottomDividerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit drawBottomDivider_mxwnekA$lambda$0;
                drawBottomDivider_mxwnekA$lambda$0 = BottomDividerKt.drawBottomDivider_mxwnekA$lambda$0(drawDivider, j, (ContentDrawScope) obj);
                return drawBottomDivider_mxwnekA$lambda$0;
            }
        });
    }

    public static final Unit drawBottomDivider_mxwnekA$lambda$0(boolean $drawDivider, long j, ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        $this$drawWithContent.drawContent();
        if ($drawDivider) {
            float x$iv = $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(0));
            int bits$iv$iv$iv = (int) ($this$drawWithContent.getSize-NH-jbRc() & 4294967295L);
            float y$iv = Float.intBitsToFloat(bits$iv$iv$iv);
            long v1$iv$iv = Float.floatToRawIntBits(x$iv);
            long v2$iv$iv = Float.floatToRawIntBits(y$iv);
            long j2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
            int bits$iv$iv$iv2 = (int) ($this$drawWithContent.getSize-NH-jbRc() >> 32);
            float x$iv2 = Float.intBitsToFloat(bits$iv$iv$iv2);
            int bits$iv$iv$iv3 = (int) ($this$drawWithContent.getSize-NH-jbRc() & 4294967295L);
            float y$iv2 = Float.intBitsToFloat(bits$iv$iv$iv3);
            long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
            long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
            DrawScope.-CC.drawLine-NGM6Ib0$default((DrawScope) $this$drawWithContent, j, j2, Offset.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2)), $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl((float) 0.5d)), 0, (PathEffect) null, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (ColorFilter) null, 0, 496, (Object) null);
        }
        return Unit.INSTANCE;
    }
}