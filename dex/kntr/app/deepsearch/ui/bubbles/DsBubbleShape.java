package kntr.app.deepsearch.ui.bubbles;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Bubble.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/app/deepsearch/ui/bubbles/DsBubbleShape;", "Landroidx/compose/ui/graphics/Shape;", "arrowDirection", "Lkntr/app/deepsearch/ui/bubbles/ArrowDirection;", "arrowOffsetX", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/deepsearch/ui/bubbles/ArrowDirection;I)V", "createOutline", "Landroidx/compose/ui/graphics/Outline$Generic;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline$Generic;", "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DsBubbleShape implements Shape {
    public static final int $stable = 0;
    private final ArrowDirection arrowDirection;
    private final int arrowOffsetX;

    /* compiled from: Bubble.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArrowDirection.values().length];
            try {
                iArr[ArrowDirection.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ArrowDirection.UP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DsBubbleShape(ArrowDirection arrowDirection, int arrowOffsetX) {
        Intrinsics.checkNotNullParameter(arrowDirection, "arrowDirection");
        this.arrowDirection = arrowDirection;
        this.arrowOffsetX = arrowOffsetX;
    }

    public /* synthetic */ DsBubbleShape(ArrowDirection arrowDirection, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrowDirection, (i2 & 2) != 0 ? 0 : i);
    }

    /* renamed from: createOutline-Pq9zytI  reason: not valid java name */
    public Outline.Generic m705createOutlinePq9zytI(long j2, LayoutDirection layoutDirection, Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Path $this$createOutline_Pq9zytI_u24lambda_u240 = AndroidPath_androidKt.Path();
        float densityValue = density.getDensity();
        float cornerRadius = Dp.constructor-impl(8) * densityValue;
        float triangleHeight = Dp.constructor-impl(10) * densityValue;
        float triangleWidth = Dp.constructor-impl((float) 13.5d) * densityValue;
        switch (WhenMappings.$EnumSwitchMapping$0[this.arrowDirection.ordinal()]) {
            case 1:
                int bits$iv$iv$iv = (int) (j2 >> 32);
                int bits$iv$iv$iv2 = (int) (j2 & 4294967295L);
                Rect rect = new Rect(0.0f, 0.0f, Float.intBitsToFloat(bits$iv$iv$iv), Float.intBitsToFloat(bits$iv$iv$iv2) - triangleHeight);
                long v1$iv$iv = Float.floatToRawIntBits(cornerRadius);
                long v2$iv$iv = Float.floatToRawIntBits(cornerRadius);
                Path.-CC.addRoundRect$default($this$createOutline_Pq9zytI_u24lambda_u240, RoundRectKt.RoundRect-sniSvfs(rect, CornerRadius.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L))), (Path.Direction) null, 2, (Object) null);
                int bits$iv$iv$iv3 = (int) (j2 >> 32);
                float f = 2;
                int bits$iv$iv$iv4 = (int) (j2 & 4294967295L);
                $this$createOutline_Pq9zytI_u24lambda_u240.moveTo(((Float.intBitsToFloat(bits$iv$iv$iv3) / f) - (triangleWidth / f)) + this.arrowOffsetX, Float.intBitsToFloat(bits$iv$iv$iv4) - triangleHeight);
                int bits$iv$iv$iv5 = (int) (j2 >> 32);
                int bits$iv$iv$iv6 = (int) (j2 & 4294967295L);
                $this$createOutline_Pq9zytI_u24lambda_u240.lineTo((Float.intBitsToFloat(bits$iv$iv$iv5) / f) + (triangleWidth / f) + this.arrowOffsetX, Float.intBitsToFloat(bits$iv$iv$iv6) - triangleHeight);
                int bits$iv$iv$iv7 = (int) (j2 >> 32);
                float intBitsToFloat = (Float.intBitsToFloat(bits$iv$iv$iv7) / f) + this.arrowOffsetX;
                int bits$iv$iv$iv8 = (int) (j2 & 4294967295L);
                $this$createOutline_Pq9zytI_u24lambda_u240.lineTo(intBitsToFloat, Float.intBitsToFloat(bits$iv$iv$iv8));
                break;
            case 2:
                int bits$iv$iv$iv9 = (int) (j2 >> 32);
                int bits$iv$iv$iv10 = (int) (j2 & 4294967295L);
                Rect rect2 = new Rect(0.0f, triangleHeight, Float.intBitsToFloat(bits$iv$iv$iv9), Float.intBitsToFloat(bits$iv$iv$iv10));
                long v1$iv$iv2 = Float.floatToRawIntBits(cornerRadius);
                long v2$iv$iv2 = Float.floatToRawIntBits(cornerRadius);
                Path.-CC.addRoundRect$default($this$createOutline_Pq9zytI_u24lambda_u240, RoundRectKt.RoundRect-sniSvfs(rect2, CornerRadius.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L))), (Path.Direction) null, 2, (Object) null);
                int bits$iv$iv$iv11 = (int) (j2 >> 32);
                float f2 = 2;
                $this$createOutline_Pq9zytI_u24lambda_u240.moveTo(((Float.intBitsToFloat(bits$iv$iv$iv11) / f2) - (triangleWidth / f2)) + this.arrowOffsetX, triangleHeight);
                int bits$iv$iv$iv12 = (int) (j2 >> 32);
                $this$createOutline_Pq9zytI_u24lambda_u240.lineTo((Float.intBitsToFloat(bits$iv$iv$iv12) / f2) + (triangleWidth / f2) + this.arrowOffsetX, triangleHeight);
                int bits$iv$iv$iv13 = (int) (j2 >> 32);
                $this$createOutline_Pq9zytI_u24lambda_u240.lineTo((Float.intBitsToFloat(bits$iv$iv$iv13) / f2) + this.arrowOffsetX, 0.0f);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        $this$createOutline_Pq9zytI_u24lambda_u240.close();
        return new Outline.Generic($this$createOutline_Pq9zytI_u24lambda_u240);
    }
}