package kntr.app.mall.mallDynamicPage.parser;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.shape.CutCornerShapeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliColors;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Locale;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.app.mall.mallDynamicPage.bean.Corner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MappingHelper.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u0017\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0000\u001a\u0017\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\u0019\u001a\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u0017\u0010 \u001a\u00020!2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\u0019\u001a\u0017\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\u0019¨\u0006%"}, d2 = {"mappingAlignHorizontal", "Landroidx/compose/ui/Alignment$Horizontal;", "align", RoomRecommendViewModel.EMPTY_CURSOR, "mappingArrangeHorizontal", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "arrange", "mappingAlignVertical", "Landroidx/compose/ui/Alignment$Vertical;", "mappingArrangeVertical", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "mappingAlign", "Landroidx/compose/ui/Alignment;", "mappingColor", "Landroidx/compose/ui/graphics/Color;", "colorName", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)J", "mappingShape", "Landroidx/compose/ui/graphics/Shape;", "shape", "shapeRadius", "Lkntr/app/mall/mallDynamicPage/bean/Corner;", "mappingFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "style", "(Ljava/lang/String;)I", "mappingFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "family", "mappingTextDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "decoration", "mappingTextAlign", "Landroidx/compose/ui/text/style/TextAlign;", "mappingOverflow", "Landroidx/compose/ui/text/style/TextOverflow;", "overflow", "mallDynamicPage_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MappingHelperKt {
    public static final Alignment.Horizontal mappingAlignHorizontal(String align) {
        if (align != null) {
            switch (align.hashCode()) {
                case 100571:
                    if (align.equals("end")) {
                        return Alignment.Companion.getEnd();
                    }
                    break;
                case 109757538:
                    if (align.equals("start")) {
                        return Alignment.Companion.getStart();
                    }
                    break;
                case 1404070310:
                    if (align.equals("centerHorizontally")) {
                        return Alignment.Companion.getCenterHorizontally();
                    }
                    break;
            }
        }
        return Alignment.Companion.getStart();
    }

    public static final Arrangement.Horizontal mappingArrangeHorizontal(String arrange) {
        if (arrange != null) {
            switch (arrange.hashCode()) {
                case -1364013995:
                    if (arrange.equals("center")) {
                        return Arrangement.INSTANCE.getCenter();
                    }
                    break;
                case -783548382:
                    if (arrange.equals("spaceBetween")) {
                        return Arrangement.INSTANCE.getSpaceBetween();
                    }
                    break;
                case 100571:
                    if (arrange.equals("end")) {
                        return Arrangement.INSTANCE.getEnd();
                    }
                    break;
                case 109757538:
                    if (arrange.equals("start")) {
                        return Arrangement.INSTANCE.getStart();
                    }
                    break;
                case 1897612915:
                    if (arrange.equals("spaceAround")) {
                        return Arrangement.INSTANCE.getSpaceAround();
                    }
                    break;
                case 2015518925:
                    if (arrange.equals("spaceEvenly")) {
                        return Arrangement.INSTANCE.getSpaceEvenly();
                    }
                    break;
            }
        }
        return Arrangement.INSTANCE.getStart();
    }

    public static final Alignment.Vertical mappingAlignVertical(String align) {
        if (align != null) {
            switch (align.hashCode()) {
                case -1448775240:
                    if (align.equals("centerVertically")) {
                        return Alignment.Companion.getCenterVertically();
                    }
                    break;
                case -1383228885:
                    if (align.equals("bottom")) {
                        return Alignment.Companion.getBottom();
                    }
                    break;
                case 115029:
                    if (align.equals("top")) {
                        return Alignment.Companion.getTop();
                    }
                    break;
            }
        }
        return Alignment.Companion.getTop();
    }

    public static final Arrangement.Vertical mappingArrangeVertical(String arrange) {
        if (arrange != null) {
            switch (arrange.hashCode()) {
                case -1383228885:
                    if (arrange.equals("bottom")) {
                        return Arrangement.INSTANCE.getBottom();
                    }
                    break;
                case -1364013995:
                    if (arrange.equals("center")) {
                        return Arrangement.INSTANCE.getCenter();
                    }
                    break;
                case -783548382:
                    if (arrange.equals("spaceBetween")) {
                        return Arrangement.INSTANCE.getSpaceBetween();
                    }
                    break;
                case 115029:
                    if (arrange.equals("top")) {
                        return Arrangement.INSTANCE.getTop();
                    }
                    break;
                case 1897612915:
                    if (arrange.equals("spaceAround")) {
                        return Arrangement.INSTANCE.getSpaceAround();
                    }
                    break;
                case 2015518925:
                    if (arrange.equals("spaceEvenly")) {
                        return Arrangement.INSTANCE.getSpaceEvenly();
                    }
                    break;
            }
        }
        return Arrangement.INSTANCE.getTop();
    }

    public static final Alignment mappingAlign(String align) {
        if (align != null) {
            switch (align.hashCode()) {
                case -1855405392:
                    if (align.equals("bottomEnd")) {
                        return Alignment.Companion.getBottomEnd();
                    }
                    break;
                case -1364013995:
                    if (align.equals("center")) {
                        return Alignment.Companion.getCenter();
                    }
                    break;
                case -977100787:
                    if (align.equals("topStart")) {
                        return Alignment.Companion.getTopStart();
                    }
                    break;
                case -868068538:
                    if (align.equals("topEnd")) {
                        return Alignment.Companion.getTopEnd();
                    }
                    break;
                case -696883702:
                    if (align.equals("topCenter")) {
                        return Alignment.Companion.getTopCenter();
                    }
                    break;
                case -655267770:
                    if (align.equals("centerEnd")) {
                        return Alignment.Companion.getCenterEnd();
                    }
                    break;
                case -620045065:
                    if (align.equals("bottomStart")) {
                        return Alignment.Companion.getBottomStart();
                    }
                    break;
                case 1660974349:
                    if (align.equals("centerStart")) {
                        return Alignment.Companion.getCenterStart();
                    }
                    break;
                case 1781909088:
                    if (align.equals("bottomCenter")) {
                        return Alignment.Companion.getBottomCenter();
                    }
                    break;
            }
        }
        return Alignment.Companion.getTopStart();
    }

    public static final long mappingColor(String colorName, Composer $composer, int $changed) {
        String str;
        $composer.startReplaceGroup(1624499120);
        ComposerKt.sourceInformation($composer, "C(mappingColor)N(colorName)76@2780L6:MappingHelper.kt#7p8zsd");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1624499120, $changed, -1, "kntr.app.mall.mallDynamicPage.parser.mappingColor (MappingHelper.kt:72)");
        }
        if (colorName == null) {
            long j2 = Color.Companion.getUnspecified-0d7_KjU();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return j2;
        }
        BiliColors colors = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable);
        if (colorName.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char it = colorName.charAt(0);
            String valueOf = String.valueOf(it);
            Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = valueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            StringBuilder append = sb.append((Object) upperCase);
            String substring = colorName.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            str = append.append(substring).toString();
        } else {
            str = colorName;
        }
        long j3 = colors.getColorByName-vNxB06k(str);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return j3;
    }

    public static final Shape mappingShape(String shape, Corner shapeRadius) {
        if (shapeRadius == null) {
            return RectangleShapeKt.getRectangleShape();
        }
        if (Intrinsics.areEqual(shape, "roundedCorner")) {
            int $this$dp$iv = shapeRadius.getTopLeft();
            float f = Dp.constructor-impl($this$dp$iv);
            int $this$dp$iv2 = shapeRadius.getTopRight();
            float f2 = Dp.constructor-impl($this$dp$iv2);
            int $this$dp$iv3 = shapeRadius.getBottomRight();
            float f3 = Dp.constructor-impl($this$dp$iv3);
            int $this$dp$iv4 = shapeRadius.getBottomLeft();
            return RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(f, f2, f3, Dp.constructor-impl($this$dp$iv4));
        } else if (Intrinsics.areEqual(shape, "cutCorner")) {
            int $this$dp$iv5 = shapeRadius.getTopLeft();
            float f4 = Dp.constructor-impl($this$dp$iv5);
            int $this$dp$iv6 = shapeRadius.getTopRight();
            float f5 = Dp.constructor-impl($this$dp$iv6);
            int $this$dp$iv7 = shapeRadius.getBottomRight();
            float f6 = Dp.constructor-impl($this$dp$iv7);
            int $this$dp$iv8 = shapeRadius.getBottomLeft();
            return CutCornerShapeKt.CutCornerShape-a9UjIt4(f4, f5, f6, Dp.constructor-impl($this$dp$iv8));
        } else {
            return RectangleShapeKt.getRectangleShape();
        }
    }

    public static final int mappingFontStyle(String style) {
        return Intrinsics.areEqual(style, "italic") ? FontStyle.Companion.getItalic-_-LCdwA() : FontStyle.Companion.getNormal-_-LCdwA();
    }

    public static final FontFamily mappingFontFamily(String family) {
        if (family != null) {
            switch (family.hashCode()) {
                case -1536685117:
                    if (family.equals("sans-serif")) {
                        return FontFamily.Companion.getSansSerif();
                    }
                    break;
                case -1431958525:
                    if (family.equals("monospace")) {
                        return FontFamily.Companion.getMonospace();
                    }
                    break;
                case 109326717:
                    if (family.equals("serif")) {
                        return FontFamily.Companion.getSerif();
                    }
                    break;
                case 1126973893:
                    if (family.equals("cursive")) {
                        return FontFamily.Companion.getCursive();
                    }
                    break;
            }
        }
        return FontFamily.Companion.getDefault();
    }

    public static final TextDecoration mappingTextDecoration(String decoration) {
        return Intrinsics.areEqual(decoration, "underline") ? TextDecoration.Companion.getUnderline() : Intrinsics.areEqual(decoration, "lineThrough") ? TextDecoration.Companion.getLineThrough() : TextDecoration.Companion.getNone();
    }

    public static final int mappingTextAlign(String align) {
        if (align != null) {
            switch (align.hashCode()) {
                case -1364013995:
                    if (align.equals("center")) {
                        return TextAlign.Companion.getCenter-e0LSkKk();
                    }
                    break;
                case -1249482096:
                    if (align.equals("justify")) {
                        return TextAlign.Companion.getJustify-e0LSkKk();
                    }
                    break;
                case 100571:
                    if (align.equals("end")) {
                        return TextAlign.Companion.getEnd-e0LSkKk();
                    }
                    break;
                case 3317767:
                    if (align.equals("left")) {
                        return TextAlign.Companion.getLeft-e0LSkKk();
                    }
                    break;
                case 108511772:
                    if (align.equals("right")) {
                        return TextAlign.Companion.getRight-e0LSkKk();
                    }
                    break;
                case 109757538:
                    if (align.equals("start")) {
                        return TextAlign.Companion.getStart-e0LSkKk();
                    }
                    break;
            }
        }
        return TextAlign.Companion.getStart-e0LSkKk();
    }

    public static final int mappingOverflow(String overflow) {
        if (overflow != null) {
            switch (overflow.hashCode()) {
                case 3056464:
                    if (overflow.equals("clip")) {
                        return TextOverflow.Companion.getClip-gIe3tQ8();
                    }
                    break;
                case 188702929:
                    if (overflow.equals("ellipsis")) {
                        return TextOverflow.Companion.getEllipsis-gIe3tQ8();
                    }
                    break;
                case 466743410:
                    if (overflow.equals("visible")) {
                        return TextOverflow.Companion.getVisible-gIe3tQ8();
                    }
                    break;
            }
        }
        return TextOverflow.Companion.getClip-gIe3tQ8();
    }
}