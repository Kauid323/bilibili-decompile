package kntr.app.im.chat.sticker.widget;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: PopupBubbleSticker.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ'\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/im/chat/sticker/widget/PopupBubbleStickerShape;", "Landroidx/compose/ui/graphics/Shape;", "isAlignToTop", RoomRecommendViewModel.EMPTY_CURSOR, "arrowWidth", "Landroidx/compose/ui/unit/Dp;", "arrowHeight", "cornerRadius", "arrowOffsetX", "<init>", "(ZFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PopupBubbleStickerShape implements Shape {
    public static final int $stable = 0;
    private final float arrowHeight;
    private final float arrowOffsetX;
    private final float arrowWidth;
    private final float cornerRadius;
    private final boolean isAlignToTop;

    public /* synthetic */ PopupBubbleStickerShape(boolean z, float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, f2, f3, f4);
    }

    private PopupBubbleStickerShape(boolean isAlignToTop, float arrowWidth, float arrowHeight, float cornerRadius, float arrowOffsetX) {
        this.isAlignToTop = isAlignToTop;
        this.arrowWidth = arrowWidth;
        this.arrowHeight = arrowHeight;
        this.cornerRadius = cornerRadius;
        this.arrowOffsetX = arrowOffsetX;
    }

    public /* synthetic */ PopupBubbleStickerShape(boolean z, float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? Dp.constructor-impl(14) : f, (i & 4) != 0 ? Dp.constructor-impl(6) : f2, (i & 8) != 0 ? Dp.constructor-impl(8) : f3, (i & 16) != 0 ? Dp.Companion.getUnspecified-D9Ej5fM() : f4, null);
    }

    /* renamed from: createOutline-Pq9zytI  reason: not valid java name */
    public Outline m1713createOutlinePq9zytI(long j2, LayoutDirection layoutDirection, Density density) {
        float intBitsToFloat;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Path path = AndroidPath_androidKt.Path();
        float radius = density.toPx-0680j_4(this.cornerRadius);
        float arrowW = density.toPx-0680j_4(this.arrowWidth);
        float arrowH = density.toPx-0680j_4(this.arrowHeight);
        int bits$iv$iv$iv = (int) (j2 >> 32);
        if (arrowW < Float.intBitsToFloat(bits$iv$iv$iv)) {
            if (!Dp.equals-impl0(this.arrowOffsetX, Dp.Companion.getUnspecified-D9Ej5fM())) {
                float f = 2;
                int bits$iv$iv$iv2 = (int) (j2 >> 32);
                intBitsToFloat = RangesKt.coerceIn(density.toPx-0680j_4(this.arrowOffsetX), arrowW / f, Float.intBitsToFloat(bits$iv$iv$iv2) - (arrowW / f));
            } else {
                int bits$iv$iv$iv3 = (int) (j2 >> 32);
                intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv3) / 2.0f;
            }
        } else {
            int bits$iv$iv$iv4 = (int) (j2 >> 32);
            intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv4) / 2.0f;
        }
        float arrowCenterX = intBitsToFloat;
        if (!this.isAlignToTop) {
            path.moveTo(radius, arrowH);
            path.lineTo(arrowCenterX - (arrowW / 2.0f), arrowH);
            path.lineTo(arrowCenterX, 0.0f);
            path.lineTo((arrowW / 2.0f) + arrowCenterX, arrowH);
            int bits$iv$iv$iv5 = (int) (j2 >> 32);
            path.lineTo(Float.intBitsToFloat(bits$iv$iv$iv5) - radius, arrowH);
            int bits$iv$iv$iv6 = (int) (j2 >> 32);
            float f2 = 2;
            int bits$iv$iv$iv7 = (int) (j2 >> 32);
            path.arcTo(new Rect(Float.intBitsToFloat(bits$iv$iv$iv6) - (f2 * radius), arrowH, Float.intBitsToFloat(bits$iv$iv$iv7), (f2 * radius) + arrowH), -90.0f, 90.0f, false);
            int bits$iv$iv$iv8 = (int) (j2 >> 32);
            int bits$iv$iv$iv9 = (int) (j2 & 4294967295L);
            path.lineTo(Float.intBitsToFloat(bits$iv$iv$iv8), Float.intBitsToFloat(bits$iv$iv$iv9) - radius);
            int bits$iv$iv$iv10 = (int) (j2 >> 32);
            int bits$iv$iv$iv11 = (int) (j2 & 4294967295L);
            int bits$iv$iv$iv12 = (int) (j2 >> 32);
            int bits$iv$iv$iv13 = (int) (j2 & 4294967295L);
            path.arcTo(new Rect(Float.intBitsToFloat(bits$iv$iv$iv10) - (f2 * radius), Float.intBitsToFloat(bits$iv$iv$iv11) - (f2 * radius), Float.intBitsToFloat(bits$iv$iv$iv12), Float.intBitsToFloat(bits$iv$iv$iv13)), 0.0f, 90.0f, false);
            int bits$iv$iv$iv14 = (int) (j2 & 4294967295L);
            path.lineTo(radius, Float.intBitsToFloat(bits$iv$iv$iv14));
            int bits$iv$iv$iv15 = (int) (j2 & 4294967295L);
            int bits$iv$iv$iv16 = (int) (j2 & 4294967295L);
            path.arcTo(new Rect(0.0f, Float.intBitsToFloat(bits$iv$iv$iv15) - (f2 * radius), f2 * radius, Float.intBitsToFloat(bits$iv$iv$iv16)), 90.0f, 90.0f, false);
            path.lineTo(0.0f, arrowH + radius);
            path.arcTo(new Rect(0.0f, arrowH, f2 * radius, (f2 * radius) + arrowH), 180.0f, 90.0f, false);
        } else {
            path.moveTo(radius, 0.0f);
            int bits$iv$iv$iv17 = (int) (j2 >> 32);
            path.lineTo(Float.intBitsToFloat(bits$iv$iv$iv17) - radius, 0.0f);
            int bits$iv$iv$iv18 = (int) (j2 >> 32);
            float f3 = 2;
            int bits$iv$iv$iv19 = (int) (j2 >> 32);
            path.arcTo(new Rect(Float.intBitsToFloat(bits$iv$iv$iv18) - (f3 * radius), 0.0f, Float.intBitsToFloat(bits$iv$iv$iv19), f3 * radius), -90.0f, 90.0f, false);
            int bits$iv$iv$iv20 = (int) (j2 >> 32);
            int bits$iv$iv$iv21 = (int) (j2 & 4294967295L);
            path.lineTo(Float.intBitsToFloat(bits$iv$iv$iv20), (Float.intBitsToFloat(bits$iv$iv$iv21) - arrowH) - radius);
            int bits$iv$iv$iv22 = (int) (j2 >> 32);
            int bits$iv$iv$iv23 = (int) (j2 & 4294967295L);
            int bits$iv$iv$iv24 = (int) (j2 >> 32);
            int bits$iv$iv$iv25 = (int) (j2 & 4294967295L);
            path.arcTo(new Rect(Float.intBitsToFloat(bits$iv$iv$iv22) - (f3 * radius), (Float.intBitsToFloat(bits$iv$iv$iv23) - arrowH) - (f3 * radius), Float.intBitsToFloat(bits$iv$iv$iv24), Float.intBitsToFloat(bits$iv$iv$iv25) - arrowH), 0.0f, 90.0f, false);
            int bits$iv$iv$iv26 = (int) (j2 & 4294967295L);
            path.lineTo((arrowW / 2.0f) + arrowCenterX, Float.intBitsToFloat(bits$iv$iv$iv26) - arrowH);
            int bits$iv$iv$iv27 = (int) (j2 & 4294967295L);
            path.lineTo(arrowCenterX, Float.intBitsToFloat(bits$iv$iv$iv27));
            float f4 = arrowCenterX - (arrowW / 2.0f);
            int bits$iv$iv$iv28 = (int) (j2 & 4294967295L);
            path.lineTo(f4, Float.intBitsToFloat(bits$iv$iv$iv28) - arrowH);
            int bits$iv$iv$iv29 = (int) (j2 & 4294967295L);
            path.lineTo(radius, Float.intBitsToFloat(bits$iv$iv$iv29) - arrowH);
            int bits$iv$iv$iv30 = (int) (j2 & 4294967295L);
            int bits$iv$iv$iv31 = (int) (j2 & 4294967295L);
            path.arcTo(new Rect(0.0f, (Float.intBitsToFloat(bits$iv$iv$iv30) - arrowH) - (f3 * radius), f3 * radius, Float.intBitsToFloat(bits$iv$iv$iv31) - arrowH), 90.0f, 90.0f, false);
            path.lineTo(0.0f, radius);
            path.arcTo(new Rect(0.0f, 0.0f, f3 * radius, f3 * radius), 180.0f, 90.0f, false);
        }
        path.close();
        return new Outline.Generic(path);
    }
}