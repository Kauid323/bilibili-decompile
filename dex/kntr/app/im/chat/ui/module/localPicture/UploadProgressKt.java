package kntr.app.im.chat.ui.module.localPicture;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UploadProgress.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aA\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a+\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"UploadProgress", RoomRecommendViewModel.EMPTY_CURSOR, "progress", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "trackColor", "thickness", "Landroidx/compose/ui/unit/Dp;", "UploadProgress-pc5RIQQ", "(FLandroidx/compose/ui/Modifier;JJFLandroidx/compose/runtime/Composer;II)V", "drawNode", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawNode-jG9AyaU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UploadProgressKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UploadProgress_pc5RIQQ$lambda$1(float f, Modifier modifier, long j2, long j3, float f2, int i, int i2, Composer composer, int i3) {
        m1787UploadProgresspc5RIQQ(f, modifier, j2, j3, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: UploadProgress-pc5RIQQ  reason: not valid java name */
    public static final void m1787UploadProgresspc5RIQQ(final float progress, Modifier modifier, long j2, long j3, float f, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j4;
        long j5;
        float f2;
        Modifier modifier3;
        float f3;
        long j6;
        long j7;
        Modifier modifier4;
        int i2;
        int i3;
        Composer $composer2 = $composer.startRestartGroup(879574048);
        ComposerKt.sourceInformation($composer2, "C(UploadProgress)N(progress,modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,thickness:c#ui.unit.Dp)29@950L408,27@891L467:UploadProgress.kt#k8mqxt");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(progress) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                j4 = j2;
                if ($composer2.changed(j4)) {
                    i3 = 256;
                    $dirty |= i3;
                }
            } else {
                j4 = j2;
            }
            i3 = 128;
            $dirty |= i3;
        } else {
            j4 = j2;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                j5 = j3;
                if ($composer2.changed(j5)) {
                    i2 = 2048;
                    $dirty |= i2;
                }
            } else {
                j5 = j3;
            }
            i2 = 1024;
            $dirty |= i2;
        } else {
            j5 = j3;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            f2 = f;
        } else if (($changed & 24576) == 0) {
            f2 = f;
            $dirty |= $composer2.changed(f2) ? 16384 : 8192;
        } else {
            f2 = f;
        }
        boolean z = true;
        if (!$composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            f3 = f2;
            j6 = j5;
            j7 = j4;
        } else {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "23@795L6");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                modifier4 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    j4 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getWh0-0d7_KjU();
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    j5 = Color.copy-wmQWz5c$default(j4, 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                if (i5 != 0) {
                    f2 = Dp.constructor-impl(2);
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(879574048, $dirty, -1, "kntr.app.im.chat.ui.module.localPicture.UploadProgress (UploadProgress.kt:26)");
            }
            Modifier aspectRatio$default = AspectRatioKt.aspectRatio$default(modifier4, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -837887624, "CC(remember):UploadProgress.kt#9igjgp");
            boolean z2 = (($dirty & 14) == 4) | (((($dirty & 7168) ^ 3072) > 2048 && $composer2.changed(j5)) || ($dirty & 3072) == 2048) | ((57344 & $dirty) == 16384);
            if (((($dirty & 896) ^ 384) <= 256 || !$composer2.changed(j4)) && ($dirty & 384) != 256) {
                z = false;
            }
            boolean invalid$iv = z2 | z;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                final long j8 = j5;
                final float f4 = f2;
                final long j9 = j4;
                Object value$iv = new Function1() { // from class: kntr.app.im.chat.ui.module.localPicture.UploadProgressKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit UploadProgress_pc5RIQQ$lambda$0$0;
                        UploadProgress_pc5RIQQ$lambda$0$0 = UploadProgressKt.UploadProgress_pc5RIQQ$lambda$0$0(progress, j8, f4, j9, (DrawScope) obj);
                        return UploadProgress_pc5RIQQ$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(aspectRatio$default, (Function1) it$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            f3 = f2;
            j6 = j5;
            j7 = j4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j10 = j7;
            final long j11 = j6;
            final float f5 = f3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.localPicture.UploadProgressKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit UploadProgress_pc5RIQQ$lambda$1;
                    UploadProgress_pc5RIQQ$lambda$1 = UploadProgressKt.UploadProgress_pc5RIQQ$lambda$1(progress, modifier5, j10, j11, f5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UploadProgress_pc5RIQQ$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UploadProgress_pc5RIQQ$lambda$0$0(float $progress, long j2, float f, long j3, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        float angle = $progress * 360.0f;
        DrawScope.-CC.drawOval-n-J9OG0$default($this$Canvas, j2, 0L, 0L, 0.0f, new Stroke($this$Canvas.toPx-0680j_4(f), 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 110, (Object) null);
        m1788drawNodejG9AyaU($this$Canvas, j3, f, $progress);
        m1788drawNodejG9AyaU($this$Canvas, j3, f, 0.0f);
        DrawScope.-CC.drawArc-yD3GUKo$default($this$Canvas, j3, -90.0f, angle, false, 0L, 0L, 0.0f, new Stroke($this$Canvas.toPx-0680j_4(f), 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 880, (Object) null);
        return Unit.INSTANCE;
    }

    /* renamed from: drawNode-jG9AyaU  reason: not valid java name */
    private static final void m1788drawNodejG9AyaU(DrawScope $this$drawNode_u2djG9AyaU, long j2, float f, float progress) {
        int bits$iv$iv$iv = (int) ($this$drawNode_u2djG9AyaU.getCenter-F1C5BW0() >> 32);
        float left$iv = Float.intBitsToFloat(bits$iv$iv$iv);
        int bits$iv$iv$iv2 = (int) ($this$drawNode_u2djG9AyaU.getCenter-F1C5BW0() & 4294967295L);
        float top$iv = Float.intBitsToFloat(bits$iv$iv$iv2);
        $this$drawNode_u2djG9AyaU.getDrawContext().getTransform().translate(left$iv, top$iv);
        try {
            float radius = Size.getMinDimension-impl($this$drawNode_u2djG9AyaU.getSize-NH-jbRc()) / 2.0f;
            float f2 = 2;
            float x = radius * ((float) Math.sin(progress * f2 * 3.141592653589793d));
            float y = radius * ((float) Math.cos(f2 * progress * 3.141592653589793d));
            float f3 = $this$drawNode_u2djG9AyaU.toPx-0680j_4(f) / 2.0f;
            float y$iv = -y;
            long v1$iv$iv = Float.floatToRawIntBits(x);
            long v2$iv$iv = Float.floatToRawIntBits(y$iv);
            try {
                DrawScope.-CC.drawCircle-VaOC9Bg$default($this$drawNode_u2djG9AyaU, j2, f3, Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
                $this$drawNode_u2djG9AyaU.getDrawContext().getTransform().translate(-left$iv, -top$iv);
            } catch (Throwable th) {
                th = th;
                $this$drawNode_u2djG9AyaU.getDrawContext().getTransform().translate(-left$iv, -top$iv);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}