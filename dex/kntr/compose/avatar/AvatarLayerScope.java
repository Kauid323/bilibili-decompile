package kntr.compose.avatar;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.internal.mask.MaskPainter;
import kntr.compose.avatar.model.common.Coordinate;
import kntr.compose.avatar.model.common.LayerGeneralSpec;
import kntr.compose.avatar.model.common.PositionSpec;
import kntr.compose.avatar.model.common.SizeSpec;
import kntr.compose.avatar.model.layers.Layer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvatarScope.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u0004H'¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u0007*\u00020\u0004H'¢\u0006\u0002\u0010\bJ\u001b\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\n*\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u001d*\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001e\u0010\u001bJ#\u0010\u0018\u001a\u00020\u001f*\u00020 2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\"\u0010#R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006$À\u0006\u0003"}, d2 = {"Lkntr/compose/avatar/AvatarLayerScope;", "Landroidx/compose/ui/unit/Density;", "contentPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "Lkntr/compose/avatar/model/layers/Layer;", "(Lkntr/compose/avatar/model/layers/Layer;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "maskPainter", "Lkntr/compose/avatar/internal/mask/MaskPainter;", "(Lkntr/compose/avatar/model/layers/Layer;Landroidx/compose/runtime/Composer;I)Lkntr/compose/avatar/internal/mask/MaskPainter;", "layerSize", "Landroidx/compose/ui/geometry/Size;", "getLayerSize-NH-jbRc", "()J", "themeDayNight", "Lcom/bilibili/compose/theme/ThemeDayNight;", "getThemeDayNight", "()Lcom/bilibili/compose/theme/ThemeDayNight;", "normalizedRect", "Landroidx/compose/ui/geometry/Rect;", "Lkntr/compose/avatar/model/common/LayerGeneralSpec;", "normalSize", "Landroidx/compose/ui/unit/Dp;", "normalizedRect-3ABfNKs", "(Lkntr/compose/avatar/model/common/LayerGeneralSpec;F)Landroidx/compose/ui/geometry/Rect;", "normalized", "Lkntr/compose/avatar/model/common/SizeSpec;", "normalized-AqgpIyE", "(Lkntr/compose/avatar/model/common/SizeSpec;F)J", "normalizedDp", "Landroidx/compose/ui/unit/DpSize;", "normalizedDp-ISypg3U", "Landroidx/compose/ui/geometry/Offset;", "Lkntr/compose/avatar/model/common/PositionSpec;", "size", "normalized-OJVLdM4", "(Lkntr/compose/avatar/model/common/PositionSpec;FLkntr/compose/avatar/model/common/SizeSpec;)J", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AvatarLayerScope extends Density {

    /* compiled from: AvatarScope.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Coordinate.values().length];
            try {
                iArr[Coordinate.Central.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    Painter contentPainter(Layer layer, Composer composer, int i);

    /* renamed from: getLayerSize-NH-jbRc  reason: not valid java name */
    long mo2456getLayerSizeNHjbRc();

    ThemeDayNight getThemeDayNight();

    MaskPainter maskPainter(Layer layer, Composer composer, int i);

    /* renamed from: normalized-AqgpIyE  reason: not valid java name */
    long mo2457normalizedAqgpIyE(SizeSpec sizeSpec, float f);

    /* renamed from: normalized-OJVLdM4  reason: not valid java name */
    long mo2458normalizedOJVLdM4(PositionSpec positionSpec, float f, SizeSpec sizeSpec);

    /* renamed from: normalizedDp-ISypg3U  reason: not valid java name */
    long mo2459normalizedDpISypg3U(SizeSpec sizeSpec, float f);

    /* renamed from: normalizedRect-3ABfNKs  reason: not valid java name */
    Rect mo2460normalizedRect3ABfNKs(LayerGeneralSpec layerGeneralSpec, float f);

    /* compiled from: AvatarScope.kt */
    /* renamed from: kntr.compose.avatar.AvatarLayerScope$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        /* renamed from: $default$normalizedRect-3ABfNKs  reason: not valid java name */
        public static Rect m2464$default$normalizedRect3ABfNKs(AvatarLayerScope _this, LayerGeneralSpec $this$normalizedRect_u2d3ABfNKs, float f) {
            Intrinsics.checkNotNullParameter($this$normalizedRect_u2d3ABfNKs, "$this$normalizedRect");
            return RectKt.Rect-tz77jQw(_this.mo2458normalizedOJVLdM4($this$normalizedRect_u2d3ABfNKs.getPosition(), f, $this$normalizedRect_u2d3ABfNKs.getSize()), _this.mo2457normalizedAqgpIyE($this$normalizedRect_u2d3ABfNKs.getSize(), f));
        }

        /* renamed from: $default$normalized-AqgpIyE  reason: not valid java name */
        public static long m2461$default$normalizedAqgpIyE(AvatarLayerScope _this, SizeSpec $this$normalized_u2dAqgpIyE, float f) {
            Intrinsics.checkNotNullParameter($this$normalized_u2dAqgpIyE, "$this$normalized");
            float other$iv = $this$normalized_u2dAqgpIyE.getWidth();
            float width$iv = _this.toPx-0680j_4(Dp.constructor-impl(f * other$iv));
            float other$iv2 = $this$normalized_u2dAqgpIyE.getHeight();
            float height$iv = _this.toPx-0680j_4(Dp.constructor-impl(f * other$iv2));
            long v1$iv$iv = Float.floatToRawIntBits(width$iv);
            long v2$iv$iv = Float.floatToRawIntBits(height$iv);
            return Size.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
        }

        /* renamed from: $default$normalizedDp-ISypg3U  reason: not valid java name */
        public static long m2463$default$normalizedDpISypg3U(AvatarLayerScope _this, SizeSpec $this$normalizedDp_u2dISypg3U, float f) {
            Intrinsics.checkNotNullParameter($this$normalizedDp_u2dISypg3U, "$this$normalizedDp");
            float other$iv = $this$normalizedDp_u2dISypg3U.getWidth();
            float other$iv2 = Dp.constructor-impl(f * other$iv);
            float other$iv3 = $this$normalizedDp_u2dISypg3U.getHeight();
            return DpKt.DpSize-YgX7TsA(other$iv2, Dp.constructor-impl(f * other$iv3));
        }

        /* renamed from: $default$normalized-OJVLdM4  reason: not valid java name */
        public static long m2462$default$normalizedOJVLdM4(AvatarLayerScope _this, PositionSpec $this$normalized_u2dOJVLdM4, float f, SizeSpec size) {
            PositionSpec uniformed;
            Intrinsics.checkNotNullParameter($this$normalized_u2dOJVLdM4, "$this$normalized");
            Intrinsics.checkNotNullParameter(size, "size");
            if (WhenMappings.$EnumSwitchMapping$0[$this$normalized_u2dOJVLdM4.getPosition().ordinal()] == 1) {
                float f2 = 2;
                uniformed = $this$normalized_u2dOJVLdM4.copy($this$normalized_u2dOJVLdM4.getX() - (size.getWidth() / f2), $this$normalized_u2dOJVLdM4.getY() - (size.getHeight() / f2), Coordinate.Default);
            } else {
                uniformed = $this$normalized_u2dOJVLdM4;
            }
            float other$iv = uniformed.getX();
            float x$iv = _this.toPx-0680j_4(Dp.constructor-impl(f * other$iv));
            float other$iv2 = uniformed.getY();
            float y$iv = _this.toPx-0680j_4(Dp.constructor-impl(f * other$iv2));
            long v1$iv$iv = Float.floatToRawIntBits(x$iv);
            long v2$iv$iv = Float.floatToRawIntBits(y$iv);
            return Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        }
    }

    /* compiled from: AvatarScope.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m2485roundToPxR2X_6o(AvatarLayerScope $this, long $receiver) {
            return Density.-CC.$default$roundToPx--R2X_6o($this, $receiver);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m2486roundToPx0680j_4(AvatarLayerScope $this, float $receiver) {
            return Density.-CC.$default$roundToPx-0680j_4($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m2487toDpGaN1DYA(AvatarLayerScope $this, long $receiver) {
            return FontScaling.-CC.$default$toDp-GaN1DYA($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m2488toDpu2uoSUM(AvatarLayerScope $this, float $receiver) {
            return Density.-CC.$default$toDp-u2uoSUM($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m2489toDpu2uoSUM(AvatarLayerScope $this, int $receiver) {
            return Density.-CC.$default$toDp-u2uoSUM($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m2490toDpSizekrfVVM(AvatarLayerScope $this, long $receiver) {
            return Density.-CC.$default$toDpSize-k-rfVVM($this, $receiver);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m2491toPxR2X_6o(AvatarLayerScope $this, long $receiver) {
            return Density.-CC.$default$toPx--R2X_6o($this, $receiver);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m2492toPx0680j_4(AvatarLayerScope $this, float $receiver) {
            return Density.-CC.$default$toPx-0680j_4($this, $receiver);
        }

        @Deprecated
        public static Rect toRect(AvatarLayerScope $this, DpRect $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return Density.-CC.$default$toRect($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m2493toSizeXkaWNTQ(AvatarLayerScope $this, long $receiver) {
            return Density.-CC.$default$toSize-XkaWNTQ($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m2494toSp0xMU5do(AvatarLayerScope $this, float $receiver) {
            return FontScaling.-CC.$default$toSp-0xMU5do($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m2495toSpkPz2Gy4(AvatarLayerScope $this, float $receiver) {
            return Density.-CC.$default$toSp-kPz2Gy4($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m2496toSpkPz2Gy4(AvatarLayerScope $this, int $receiver) {
            return Density.-CC.$default$toSp-kPz2Gy4($this, $receiver);
        }

        @Deprecated
        /* renamed from: normalizedRect-3ABfNKs  reason: not valid java name */
        public static Rect m2484normalizedRect3ABfNKs(AvatarLayerScope $this, LayerGeneralSpec $receiver, float f) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return CC.m2464$default$normalizedRect3ABfNKs($this, $receiver, f);
        }

        @Deprecated
        /* renamed from: normalized-AqgpIyE  reason: not valid java name */
        public static long m2481normalizedAqgpIyE(AvatarLayerScope $this, SizeSpec $receiver, float f) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return CC.m2461$default$normalizedAqgpIyE($this, $receiver, f);
        }

        @Deprecated
        /* renamed from: normalizedDp-ISypg3U  reason: not valid java name */
        public static long m2483normalizedDpISypg3U(AvatarLayerScope $this, SizeSpec $receiver, float f) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return CC.m2463$default$normalizedDpISypg3U($this, $receiver, f);
        }

        @Deprecated
        /* renamed from: normalized-OJVLdM4  reason: not valid java name */
        public static long m2482normalizedOJVLdM4(AvatarLayerScope $this, PositionSpec $receiver, float f, SizeSpec size) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            Intrinsics.checkNotNullParameter(size, "size");
            return CC.m2462$default$normalizedOJVLdM4($this, $receiver, f, size);
        }
    }
}