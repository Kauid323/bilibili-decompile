package kntr.app.mall.mallDynamicPage.parser;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.draw.BlurredEdgeTreatment;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.app.mall.mallDynamicPage.bean.Background;
import kntr.app.mall.mallDynamicPage.bean.Border;
import kntr.app.mall.mallDynamicPage.bean.Clip;
import kntr.app.mall.mallDynamicPage.bean.Position;
import kntr.app.mall.mallDynamicPage.bean.Range;
import kntr.app.mall.mallDynamicPage.bean.Rect;
import kntr.app.mall.mallDynamicPage.bean.Shadow;
import kntr.app.mall.mallDynamicPage.bean.Style;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ModifierCreator.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"createModifier", "Landroidx/compose/ui/Modifier;", "style", "Lkntr/app/mall/mallDynamicPage/bean/Style;", "(Landroidx/compose/ui/Modifier;Lkntr/app/mall/mallDynamicPage/bean/Style;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "mallDynamicPage_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ModifierCreatorKt {
    public static final Modifier createModifier(Modifier $this$createModifier, Style style, Composer $composer, int $changed) {
        Modifier modifier;
        Modifier modifier2;
        float f;
        float f2;
        long defaultShadowColor;
        long defaultShadowColor2;
        Rect it;
        Integer blur;
        Boolean clipToBounds;
        Clip it2;
        Range it3;
        float f3;
        float f4;
        Range it4;
        float f5;
        float f6;
        String it5;
        Modifier fillMaxHeight$default;
        String it6;
        Modifier fillMaxWidth$default;
        Position it7;
        float f7;
        float f8;
        Rect it8;
        Intrinsics.checkNotNullParameter($this$createModifier, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, 1346573708, "C(createModifier)N(style):ModifierCreator.kt#7p8zsd");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1346573708, $changed, -1, "kntr.app.mall.mallDynamicPage.parser.createModifier (ModifierCreator.kt:32)");
        }
        Modifier modifier3 = $this$createModifier;
        if (style != null && (it8 = style.getMargin()) != null) {
            int $this$dp$iv = it8.getLeft();
            float f9 = Dp.constructor-impl($this$dp$iv);
            int $this$dp$iv2 = it8.getTop();
            float f10 = Dp.constructor-impl($this$dp$iv2);
            int $this$dp$iv3 = it8.getRight();
            float f11 = Dp.constructor-impl($this$dp$iv3);
            int $this$dp$iv4 = it8.getBottom();
            modifier3 = PaddingKt.padding-qDBjuR0(modifier3, f9, f10, f11, Dp.constructor-impl($this$dp$iv4));
        }
        if (style != null && (it7 = style.getOffset()) != null) {
            Integer x = it7.getX();
            if (x != null) {
                int $this$dp$iv5 = x.intValue();
                f7 = Dp.constructor-impl($this$dp$iv5);
            } else {
                f7 = Dp.constructor-impl(0);
            }
            Integer y = it7.getY();
            if (y != null) {
                int $this$dp$iv6 = y.intValue();
                f8 = Dp.constructor-impl($this$dp$iv6);
            } else {
                f8 = Dp.constructor-impl(0);
            }
            modifier3 = OffsetKt.offset-VpY3zN4(modifier3, f7, f8);
        }
        Background it9 = style != null ? style.getBackground() : null;
        if (it9 == null) {
            $composer.startReplaceGroup(783135636);
        } else {
            $composer.startReplaceGroup(783135637);
            ComposerKt.sourceInformation($composer, RoomRecommendViewModel.EMPTY_CURSOR);
            if (it9.getBrush() != null) {
                $composer.startReplaceGroup(489541955);
                ComposerKt.sourceInformation($composer, "46@1889L30,46@1921L30");
                Brush.Companion companion = Brush.Companion;
                Color[] colorArr = new Color[2];
                List<String> brush = it9.getBrush();
                colorArr[0] = Color.box-impl(MappingHelperKt.mappingColor(brush != null ? brush.get(0) : null, $composer, 0));
                List<String> brush2 = it9.getBrush();
                colorArr[1] = Color.box-impl(MappingHelperKt.mappingColor(brush2 != null ? brush2.get(1) : null, $composer, 0));
                modifier = BackgroundKt.background$default(modifier3, Brush.Companion.linearGradient-mHitzGk$default(companion, CollectionsKt.listOf(colorArr), 0L, 0L, 0, 14, (Object) null), MappingHelperKt.mappingShape(it9.getShape(), it9.getShapeRadius()), 0.0f, 4, (Object) null);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(489888225);
                ComposerKt.sourceInformation($composer, "52@2153L22");
                modifier = BackgroundKt.background-bw27NRU(modifier3, MappingHelperKt.mappingColor(it9.getColor(), $composer, 0), MappingHelperKt.mappingShape(it9.getShape(), it9.getShapeRadius()));
                $composer.endReplaceGroup();
            }
            modifier3 = modifier;
        }
        $composer.endReplaceGroup();
        Border it10 = style != null ? style.getBorder() : null;
        if (it10 == null) {
            $composer.startReplaceGroup(783761898);
        } else {
            $composer.startReplaceGroup(783761899);
            ComposerKt.sourceInformation($composer, RoomRecommendViewModel.EMPTY_CURSOR);
            if (it10.getBrush() != null) {
                $composer.startReplaceGroup(-1366835361);
                ComposerKt.sourceInformation($composer, "64@2555L30,64@2587L30");
                int $this$dp$iv7 = it10.getWidth();
                float f12 = Dp.constructor-impl($this$dp$iv7);
                Brush.Companion companion2 = Brush.Companion;
                Color[] colorArr2 = new Color[2];
                List<String> brush3 = it10.getBrush();
                colorArr2[0] = Color.box-impl(MappingHelperKt.mappingColor(brush3 != null ? brush3.get(0) : null, $composer, 0));
                List<String> brush4 = it10.getBrush();
                colorArr2[1] = Color.box-impl(MappingHelperKt.mappingColor(brush4 != null ? brush4.get(1) : null, $composer, 0));
                modifier2 = BorderKt.border-ziNgDLE(modifier3, f12, Brush.Companion.linearGradient-mHitzGk$default(companion2, CollectionsKt.listOf(colorArr2), 0L, 0L, 0, 14, (Object) null), MappingHelperKt.mappingShape(it10.getShape(), it10.getShapeRadius()));
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-1366452387);
                ComposerKt.sourceInformation($composer, "71@2856L22");
                int $this$dp$iv8 = it10.getWidth();
                modifier2 = BorderKt.border-xT4_qwU(modifier3, Dp.constructor-impl($this$dp$iv8), MappingHelperKt.mappingColor(it10.getColor(), $composer, 0), MappingHelperKt.mappingShape(it10.getShape(), it10.getShapeRadius()));
                $composer.endReplaceGroup();
            }
            modifier3 = modifier2;
        }
        $composer.endReplaceGroup();
        if (style != null && (it6 = style.getWidth()) != null) {
            if (StringsKt.toIntOrNull(it6) != null) {
                int $this$dp$iv9 = Integer.parseInt(it6);
                fillMaxWidth$default = SizeKt.width-3ABfNKs(modifier3, Dp.constructor-impl($this$dp$iv9));
            } else {
                fillMaxWidth$default = Intrinsics.areEqual(it6, "fillMaxWidth") ? SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null) : SizeKt.wrapContentWidth$default(modifier3, (Alignment.Horizontal) null, false, 3, (Object) null);
            }
            modifier3 = fillMaxWidth$default;
        }
        if (style != null && (it5 = style.getHeight()) != null) {
            if (StringsKt.toIntOrNull(it5) != null) {
                int $this$dp$iv10 = Integer.parseInt(it5);
                fillMaxHeight$default = SizeKt.height-3ABfNKs(modifier3, Dp.constructor-impl($this$dp$iv10));
            } else {
                fillMaxHeight$default = Intrinsics.areEqual(it5, "fillMaxHeight") ? SizeKt.fillMaxHeight$default(modifier3, 0.0f, 1, (Object) null) : SizeKt.wrapContentHeight$default(modifier3, (Alignment.Vertical) null, false, 3, (Object) null);
            }
            modifier3 = fillMaxHeight$default;
        }
        if (style != null && (it4 = style.getWidthIn()) != null) {
            Integer min = it4.getMin();
            if (min != null) {
                int $this$dp$iv11 = min.intValue();
                f5 = Dp.constructor-impl($this$dp$iv11);
            } else {
                f5 = Dp.Companion.getUnspecified-D9Ej5fM();
            }
            Integer max = it4.getMax();
            if (max != null) {
                int $this$dp$iv12 = max.intValue();
                f6 = Dp.constructor-impl($this$dp$iv12);
            } else {
                f6 = Dp.Companion.getUnspecified-D9Ej5fM();
            }
            modifier3 = SizeKt.widthIn-VpY3zN4(modifier3, f5, f6);
        }
        if (style != null && (it3 = style.getHeightIn()) != null) {
            Integer min2 = it3.getMin();
            if (min2 != null) {
                int $this$dp$iv13 = min2.intValue();
                f3 = Dp.constructor-impl($this$dp$iv13);
            } else {
                f3 = Dp.Companion.getUnspecified-D9Ej5fM();
            }
            Integer max2 = it3.getMax();
            if (max2 != null) {
                int $this$dp$iv14 = max2.intValue();
                f4 = Dp.constructor-impl($this$dp$iv14);
            } else {
                f4 = Dp.Companion.getUnspecified-D9Ej5fM();
            }
            modifier3 = SizeKt.heightIn-VpY3zN4(modifier3, f3, f4);
        }
        if (style != null) {
            modifier3 = AlphaKt.alpha(modifier3, style.getAlpha());
        }
        if (style != null) {
            modifier3 = ZIndexModifierKt.zIndex(modifier3, style.getZIndex());
        }
        Shadow it11 = style != null ? style.getShadow() : null;
        if (it11 == null) {
            $composer.startReplaceGroup(785483111);
        } else {
            $composer.startReplaceGroup(785483112);
            ComposerKt.sourceInformation($composer, RoomRecommendViewModel.EMPTY_CURSOR);
            Integer elevation = it11.getElevation();
            if (elevation != null) {
                int $this$dp$iv15 = elevation.intValue();
                f = Dp.constructor-impl($this$dp$iv15);
            } else {
                f = Dp.constructor-impl(0);
            }
            Integer radius = it11.getRadius();
            if (radius != null) {
                int $this$dp$iv16 = radius.intValue();
                f2 = Dp.constructor-impl($this$dp$iv16);
            } else {
                f2 = Dp.constructor-impl(0);
            }
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(f2);
            if (it11.getColor() != null) {
                $composer.startReplaceGroup(-450050516);
                ComposerKt.sourceInformation($composer, "115@4302L22");
                defaultShadowColor = MappingHelperKt.mappingColor(it11.getColor(), $composer, 0);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-450049624);
                $composer.endReplaceGroup();
                defaultShadowColor = GraphicsLayerScopeKt.getDefaultShadowColor();
            }
            long j2 = defaultShadowColor;
            if (it11.getColor() != null) {
                $composer.startReplaceGroup(-450047252);
                ComposerKt.sourceInformation($composer, "116@4404L22");
                defaultShadowColor2 = MappingHelperKt.mappingColor(it11.getColor(), $composer, 0);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-450046360);
                $composer.endReplaceGroup();
                defaultShadowColor2 = GraphicsLayerScopeKt.getDefaultShadowColor();
            }
            modifier3 = ShadowKt.shadow-s4CzXII$default(modifier3, f, shape, false, j2, defaultShadowColor2, 4, (Object) null);
        }
        $composer.endReplaceGroup();
        if (style != null && (it2 = style.getClip()) != null) {
            modifier3 = ClipKt.clip(modifier3, MappingHelperKt.mappingShape(it2.getShape(), it2.getShapeRadius()));
        }
        if (style != null && (clipToBounds = style.getClipToBounds()) != null) {
            clipToBounds.booleanValue();
            modifier3 = ClipKt.clipToBounds(modifier3);
        }
        if (style != null) {
            modifier3 = RotateKt.rotate(modifier3, style.getRotate());
        }
        if (style != null) {
            modifier3 = ScaleKt.scale(modifier3, style.getScale());
        }
        if (style != null && (blur = style.getBlur()) != null) {
            modifier3 = BlurKt.blur-F8QBwvs$default(modifier3, Dp.constructor-impl(blur.intValue()), (BlurredEdgeTreatment) null, 2, (Object) null);
        }
        if (style != null && (it = style.getPadding()) != null) {
            int $this$dp$iv17 = it.getLeft();
            float f13 = Dp.constructor-impl($this$dp$iv17);
            int $this$dp$iv18 = it.getTop();
            float f14 = Dp.constructor-impl($this$dp$iv18);
            int $this$dp$iv19 = it.getRight();
            float f15 = Dp.constructor-impl($this$dp$iv19);
            int $this$dp$iv20 = it.getBottom();
            modifier3 = PaddingKt.padding-qDBjuR0(modifier3, f13, f14, f15, Dp.constructor-impl($this$dp$iv20));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return modifier3;
    }
}