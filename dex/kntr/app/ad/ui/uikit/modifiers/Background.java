package kntr.app.ad.ui.uikit.modifiers;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackgroundModifier.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lkntr/app/ad/ui/uikit/modifiers/Background;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Fill", "Stroke", "FillAndStroke", "NoBackground", "Lkntr/app/ad/ui/uikit/modifiers/Background$Fill;", "Lkntr/app/ad/ui/uikit/modifiers/Background$FillAndStroke;", "Lkntr/app/ad/ui/uikit/modifiers/Background$NoBackground;", "Lkntr/app/ad/ui/uikit/modifiers/Background$Stroke;", "uikit_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class Background {
    public static final int $stable = 0;

    public /* synthetic */ Background(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Background() {
    }

    /* compiled from: BackgroundModifier.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\tJ\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lkntr/app/ad/ui/uikit/modifiers/Background$Fill;", "Lkntr/app/ad/ui/uikit/modifiers/Background;", "color", "Landroidx/compose/ui/graphics/Color;", "shape", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(JLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "component1", "component1-0d7_KjU", "component2", "copy", "copy-DxMtmZc", "(JLandroidx/compose/ui/graphics/Shape;)Lkntr/app/ad/ui/uikit/modifiers/Background$Fill;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "uikit_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Fill extends Background {
        public static final int $stable = 0;
        private final long color;
        private final Shape shape;

        public /* synthetic */ Fill(long j2, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
            this(j2, shape);
        }

        /* renamed from: copy-DxMtmZc$default  reason: not valid java name */
        public static /* synthetic */ Fill m514copyDxMtmZc$default(Fill fill, long j2, Shape shape, int i, Object obj) {
            if ((i & 1) != 0) {
                j2 = fill.color;
            }
            if ((i & 2) != 0) {
                shape = fill.shape;
            }
            return fill.m516copyDxMtmZc(j2, shape);
        }

        /* renamed from: component1-0d7_KjU  reason: not valid java name */
        public final long m515component10d7_KjU() {
            return this.color;
        }

        public final Shape component2() {
            return this.shape;
        }

        /* renamed from: copy-DxMtmZc  reason: not valid java name */
        public final Fill m516copyDxMtmZc(long j2, Shape shape) {
            Intrinsics.checkNotNullParameter(shape, "shape");
            return new Fill(j2, shape, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Fill) {
                Fill fill = (Fill) obj;
                return Color.equals-impl0(this.color, fill.color) && Intrinsics.areEqual(this.shape, fill.shape);
            }
            return false;
        }

        public int hashCode() {
            return (Color.hashCode-impl(this.color) * 31) + this.shape.hashCode();
        }

        public String toString() {
            String str = Color.toString-impl(this.color);
            return "Fill(color=" + str + ", shape=" + this.shape + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Fill(long color, Shape shape) {
            super(null);
            Intrinsics.checkNotNullParameter(shape, "shape");
            this.color = color;
            this.shape = shape;
        }

        public /* synthetic */ Fill(long j2, Shape shape, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j2, (i & 2) != 0 ? (Shape) RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2)) : shape, null);
        }

        /* renamed from: getColor-0d7_KjU  reason: not valid java name */
        public final long m517getColor0d7_KjU() {
            return this.color;
        }

        public final Shape getShape() {
            return this.shape;
        }
    }

    /* compiled from: BackgroundModifier.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J.\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lkntr/app/ad/ui/uikit/modifiers/Background$Stroke;", "Lkntr/app/ad/ui/uikit/modifiers/Background;", "color", "Landroidx/compose/ui/graphics/Color;", "width", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(JFLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getWidth-D9Ej5fM", "()F", "F", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "component1", "component1-0d7_KjU", "component2", "component2-D9Ej5fM", "component3", "copy", "copy-5DgIosw", "(JFLandroidx/compose/ui/graphics/Shape;)Lkntr/app/ad/ui/uikit/modifiers/Background$Stroke;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "uikit_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Stroke extends Background {
        public static final int $stable = 0;
        private final long color;
        private final Shape shape;
        private final float width;

        public /* synthetic */ Stroke(long j2, float f, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
            this(j2, f, shape);
        }

        /* renamed from: copy-5DgIosw$default  reason: not valid java name */
        public static /* synthetic */ Stroke m526copy5DgIosw$default(Stroke stroke, long j2, float f, Shape shape, int i, Object obj) {
            if ((i & 1) != 0) {
                j2 = stroke.color;
            }
            if ((i & 2) != 0) {
                f = stroke.width;
            }
            if ((i & 4) != 0) {
                shape = stroke.shape;
            }
            return stroke.m529copy5DgIosw(j2, f, shape);
        }

        /* renamed from: component1-0d7_KjU  reason: not valid java name */
        public final long m527component10d7_KjU() {
            return this.color;
        }

        /* renamed from: component2-D9Ej5fM  reason: not valid java name */
        public final float m528component2D9Ej5fM() {
            return this.width;
        }

        public final Shape component3() {
            return this.shape;
        }

        /* renamed from: copy-5DgIosw  reason: not valid java name */
        public final Stroke m529copy5DgIosw(long j2, float f, Shape shape) {
            Intrinsics.checkNotNullParameter(shape, "shape");
            return new Stroke(j2, f, shape, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Stroke) {
                Stroke stroke = (Stroke) obj;
                return Color.equals-impl0(this.color, stroke.color) && Dp.equals-impl0(this.width, stroke.width) && Intrinsics.areEqual(this.shape, stroke.shape);
            }
            return false;
        }

        public int hashCode() {
            return (((Color.hashCode-impl(this.color) * 31) + Dp.hashCode-impl(this.width)) * 31) + this.shape.hashCode();
        }

        public String toString() {
            String str = Color.toString-impl(this.color);
            String str2 = Dp.toString-impl(this.width);
            return "Stroke(color=" + str + ", width=" + str2 + ", shape=" + this.shape + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Stroke(long color, float width, Shape shape) {
            super(null);
            Intrinsics.checkNotNullParameter(shape, "shape");
            this.color = color;
            this.width = width;
            this.shape = shape;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ Stroke(long j2, float f, Shape shape, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j2, r3, r4, null);
            float f2;
            Shape shape2;
            if ((i & 2) == 0) {
                f2 = f;
            } else {
                f2 = Dp.constructor-impl(1);
            }
            if ((i & 4) == 0) {
                shape2 = shape;
            } else {
                shape2 = (Shape) RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2));
            }
        }

        /* renamed from: getColor-0d7_KjU  reason: not valid java name */
        public final long m530getColor0d7_KjU() {
            return this.color;
        }

        /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
        public final float m531getWidthD9Ej5fM() {
            return this.width;
        }

        public final Shape getShape() {
            return this.shape;
        }
    }

    /* compiled from: BackgroundModifier.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0015\u0010\fJ\u0010\u0010\u0016\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0017\u0010\fJ\u0010\u0010\u0018\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0010J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J8\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Lkntr/app/ad/ui/uikit/modifiers/Background$FillAndStroke;", "Lkntr/app/ad/ui/uikit/modifiers/Background;", "fillColor", "Landroidx/compose/ui/graphics/Color;", "strokeColor", "strokeWidth", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(JJFLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFillColor-0d7_KjU", "()J", "J", "getStrokeColor-0d7_KjU", "getStrokeWidth-D9Ej5fM", "()F", "F", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component3-D9Ej5fM", "component4", "copy", "copy-gs-jSAA", "(JJFLandroidx/compose/ui/graphics/Shape;)Lkntr/app/ad/ui/uikit/modifiers/Background$FillAndStroke;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "uikit_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class FillAndStroke extends Background {
        public static final int $stable = 0;
        private final long fillColor;
        private final Shape shape;
        private final long strokeColor;
        private final float strokeWidth;

        public /* synthetic */ FillAndStroke(long j2, long j3, float f, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
            this(j2, j3, f, shape);
        }

        /* renamed from: copy-gs-jSAA$default  reason: not valid java name */
        public static /* synthetic */ FillAndStroke m518copygsjSAA$default(FillAndStroke fillAndStroke, long j2, long j3, float f, Shape shape, int i, Object obj) {
            if ((i & 1) != 0) {
                j2 = fillAndStroke.fillColor;
            }
            long j4 = j2;
            if ((i & 2) != 0) {
                j3 = fillAndStroke.strokeColor;
            }
            long j5 = j3;
            if ((i & 4) != 0) {
                f = fillAndStroke.strokeWidth;
            }
            float f2 = f;
            if ((i & 8) != 0) {
                shape = fillAndStroke.shape;
            }
            return fillAndStroke.m522copygsjSAA(j4, j5, f2, shape);
        }

        /* renamed from: component1-0d7_KjU  reason: not valid java name */
        public final long m519component10d7_KjU() {
            return this.fillColor;
        }

        /* renamed from: component2-0d7_KjU  reason: not valid java name */
        public final long m520component20d7_KjU() {
            return this.strokeColor;
        }

        /* renamed from: component3-D9Ej5fM  reason: not valid java name */
        public final float m521component3D9Ej5fM() {
            return this.strokeWidth;
        }

        public final Shape component4() {
            return this.shape;
        }

        /* renamed from: copy-gs-jSAA  reason: not valid java name */
        public final FillAndStroke m522copygsjSAA(long j2, long j3, float f, Shape shape) {
            Intrinsics.checkNotNullParameter(shape, "shape");
            return new FillAndStroke(j2, j3, f, shape, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FillAndStroke) {
                FillAndStroke fillAndStroke = (FillAndStroke) obj;
                return Color.equals-impl0(this.fillColor, fillAndStroke.fillColor) && Color.equals-impl0(this.strokeColor, fillAndStroke.strokeColor) && Dp.equals-impl0(this.strokeWidth, fillAndStroke.strokeWidth) && Intrinsics.areEqual(this.shape, fillAndStroke.shape);
            }
            return false;
        }

        public int hashCode() {
            return (((((Color.hashCode-impl(this.fillColor) * 31) + Color.hashCode-impl(this.strokeColor)) * 31) + Dp.hashCode-impl(this.strokeWidth)) * 31) + this.shape.hashCode();
        }

        public String toString() {
            String str = Color.toString-impl(this.fillColor);
            String str2 = Color.toString-impl(this.strokeColor);
            String str3 = Dp.toString-impl(this.strokeWidth);
            return "FillAndStroke(fillColor=" + str + ", strokeColor=" + str2 + ", strokeWidth=" + str3 + ", shape=" + this.shape + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private FillAndStroke(long fillColor, long strokeColor, float strokeWidth, Shape shape) {
            super(null);
            Intrinsics.checkNotNullParameter(shape, "shape");
            this.fillColor = fillColor;
            this.strokeColor = strokeColor;
            this.strokeWidth = strokeWidth;
            this.shape = shape;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ FillAndStroke(long j2, long j3, float f, Shape shape, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j2, j3, r6, r7, null);
            float f2;
            Shape shape2;
            if ((i & 4) == 0) {
                f2 = f;
            } else {
                f2 = Dp.constructor-impl(1);
            }
            if ((i & 8) == 0) {
                shape2 = shape;
            } else {
                shape2 = (Shape) RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2));
            }
        }

        /* renamed from: getFillColor-0d7_KjU  reason: not valid java name */
        public final long m523getFillColor0d7_KjU() {
            return this.fillColor;
        }

        /* renamed from: getStrokeColor-0d7_KjU  reason: not valid java name */
        public final long m524getStrokeColor0d7_KjU() {
            return this.strokeColor;
        }

        /* renamed from: getStrokeWidth-D9Ej5fM  reason: not valid java name */
        public final float m525getStrokeWidthD9Ej5fM() {
            return this.strokeWidth;
        }

        public final Shape getShape() {
            return this.shape;
        }
    }

    /* compiled from: BackgroundModifier.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/ad/ui/uikit/modifiers/Background$NoBackground;", "Lkntr/app/ad/ui/uikit/modifiers/Background;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "uikit_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class NoBackground extends Background {
        public static final int $stable = 0;
        public static final NoBackground INSTANCE = new NoBackground();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NoBackground) {
                NoBackground noBackground = (NoBackground) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -406658392;
        }

        public String toString() {
            return "NoBackground";
        }

        private NoBackground() {
            super(null);
        }
    }
}