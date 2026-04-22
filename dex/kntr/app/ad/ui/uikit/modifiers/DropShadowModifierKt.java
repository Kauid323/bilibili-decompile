package kntr.app.ad.ui.uikit.modifiers;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import kntr.app.ad.ui.uikit.utils.BlurMaskFilter_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DropShadowModifier.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aA\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"dropShadow", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "blur", "Landroidx/compose/ui/unit/Dp;", "spread", "dropShadow-DPi4msk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFF)Landroidx/compose/ui/Modifier;", "uikit_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DropShadowModifierKt {
    /* renamed from: dropShadow-DPi4msk  reason: not valid java name */
    public static final Modifier m533dropShadowDPi4msk(Modifier $this$dropShadow_u2dDPi4msk, final Shape shape, final long j2, final long j3, final float f, final float f2) {
        Intrinsics.checkNotNullParameter($this$dropShadow_u2dDPi4msk, "$this$dropShadow");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return DrawModifierKt.drawBehind($this$dropShadow_u2dDPi4msk, new Function1() { // from class: kntr.app.ad.ui.uikit.modifiers.DropShadowModifierKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit dropShadow_DPi4msk$lambda$0;
                dropShadow_DPi4msk$lambda$0 = DropShadowModifierKt.dropShadow_DPi4msk$lambda$0(f2, shape, f, j2, j3, (DrawScope) obj);
                return dropShadow_DPi4msk$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dropShadow_DPi4msk$lambda$0(float f, Shape $shape, float f2, long j2, long j3, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        int bits$iv$iv$iv = (int) ($this$drawBehind.getSize-NH-jbRc() >> 32);
        float width$iv = Float.intBitsToFloat(bits$iv$iv$iv) + $this$drawBehind.toPx-0680j_4(f);
        int bits$iv$iv$iv2 = (int) ($this$drawBehind.getSize-NH-jbRc() & 4294967295L);
        float height$iv = Float.intBitsToFloat(bits$iv$iv$iv2) + $this$drawBehind.toPx-0680j_4(f);
        long v1$iv$iv = Float.floatToRawIntBits(width$iv);
        long v2$iv$iv = Float.floatToRawIntBits(height$iv);
        long shadowSize = Size.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
        Outline shadowOutline = $shape.createOutline-Pq9zytI(shadowSize, $this$drawBehind.getLayoutDirection(), (Density) $this$drawBehind);
        Paint paint = AndroidPaint_androidKt.Paint();
        paint.setColor-8_81llA(j2);
        Float valueOf = Float.valueOf($this$drawBehind.toPx-0680j_4(f2));
        float it = valueOf.floatValue();
        if (!(it > 0.0f)) {
            valueOf = null;
        }
        if (valueOf != null) {
            float it2 = valueOf.floatValue();
            android.graphics.Paint $this$dropShadow_DPi4msk_u24lambda_u240_u242_u240 = paint.asFrameworkPaint();
            BlurMaskFilter_androidKt.applyBlurMaskFilter($this$dropShadow_DPi4msk_u24lambda_u240_u242_u240, it2);
        }
        Canvas canvas = $this$drawBehind.getDrawContext().getCanvas();
        canvas.save();
        canvas.translate($this$drawBehind.toPx-0680j_4(DpOffset.getX-D9Ej5fM(j3)), $this$drawBehind.toPx-0680j_4(DpOffset.getY-D9Ej5fM(j3)));
        OutlineKt.drawOutline(canvas, shadowOutline, paint);
        canvas.restore();
        return Unit.INSTANCE;
    }
}