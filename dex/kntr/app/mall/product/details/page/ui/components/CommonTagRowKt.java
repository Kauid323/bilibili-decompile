package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.color.ThemeColorsKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.GarbInfo;
import com.bilibili.compose.theme.ThemeStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.CommonGoodsTagBean;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CommonTagRow.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aI\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a3\u0010\u0010\u001a\u00020\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a5\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"CommonTagRow", "", "frontTags", "", "Lkntr/app/mall/product/details/page/api/model/CommonGoodsTagBean;", "title", "", "maxWidth", "Landroidx/compose/ui/unit/Dp;", "scale", "", "tagHeight", "modifier", "Landroidx/compose/ui/Modifier;", "CommonTagRow-vVAugoc", "(Ljava/util/List;Ljava/lang/String;FFFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "HomeOldTextTag", "tag", "HomeOldTextTag-942rkJo", "(Lkntr/app/mall/product/details/page/api/model/CommonGoodsTagBean;FFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "buildColor", "Landroidx/compose/ui/graphics/Brush;", "dayColor1", "dayColor2", "nightColor1", "nightColor2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Brush;", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CommonTagRowKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonTagRow_vVAugoc$lambda$5(List list, String str, float f, float f2, float f3, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m430CommonTagRowvVAugoc(list, str, f, f2, f3, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeOldTextTag_942rkJo$lambda$1(CommonGoodsTagBean commonGoodsTagBean, float f, float f2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m431HomeOldTextTag942rkJo(commonGoodsTagBean, f, f2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0340 A[EDGE_INSN: B:157:0x0340->B:133:0x0340 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0201 A[SYNTHETIC] */
    /* renamed from: CommonTagRow-vVAugoc  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m430CommonTagRowvVAugoc(final List<CommonGoodsTagBean> list, final String title, final float f, final float scale, final float f2, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Modifier modifier3;
        String str;
        List allTags;
        float spacing;
        String result;
        boolean z;
        boolean isImage;
        float imageWidth;
        int tagWidth;
        Intrinsics.checkNotNullParameter(list, "frontTags");
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer2 = $composer.startRestartGroup(1352664872);
        ComposerKt.sourceInformation($composer2, "C(CommonTagRow)N(frontTags,title,maxWidth:c#ui.unit.Dp,scale,tagHeight:c#ui.unit.Dp,modifier)51@1941L7,66@2341L22,68@2390L69,76@2580L2884,145@5533L3538,145@5523L3548:CommonTagRow.kt#o90vz8");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(title) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(f) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(scale) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changed(f2) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty2 |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        int $dirty3 = $dirty2;
        if (!$composer2.shouldExecute((74899 & $dirty3) != 74898, $dirty3 & 1)) {
            $dirty = $dirty3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1352664872, $dirty3, -1, "kntr.app.mall.product.details.page.ui.components.CommonTagRow (CommonTagRow.kt:50)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume;
            float spacing2 = ProvideUiScaleKt.dpScaled(4, scale);
            int spacingPx = density.roundToPx-0680j_4(spacing2);
            final TextStyle textStyle = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(13), FontWeight.Companion.getW600(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (DefaultConstructorMarker) null), scale);
            TextStyle oldTextStyle = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(10), FontWeight.Companion.getW400(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (DefaultConstructorMarker) null), scale);
            TextMeasurer textMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer2, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer2, -1464127731, "CC(remember):CommonTagRow.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(list);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = CollectionsKt.filterNotNull(list);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            List allTags2 = (List) it$iv;
            int maxWidthPx = density.roundToPx-0680j_4(f);
            ComposerKt.sourceInformationMarkerStart($composer2, -1464118836, "CC(remember):CommonTagRow.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(allTags2) | (($dirty3 & 112) == 32) | $composer2.changed(maxWidthPx);
            CommonGoodsTagBean tag = null;
            Object it$iv2 = $composer2.rememberedValue();
            boolean z2 = false;
            if (!invalid$iv2 && it$iv2 != Composer.Companion.getEmpty()) {
                allTags = allTags2;
                spacing = spacing2;
                $dirty = $dirty3;
                Triple fittingTags = (Triple) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final List tagsToShow = (List) fittingTags.component1();
                final String clippedTitle = (String) fittingTags.component2();
                final Modifier modifier4 = modifier3;
                final float f3 = spacing;
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-1392194960, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CommonTagRowKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        Unit CommonTagRow_vVAugoc$lambda$4;
                        CommonTagRow_vVAugoc$lambda$4 = CommonTagRowKt.CommonTagRow_vVAugoc$lambda$4(modifier4, tagsToShow, clippedTitle, f3, textStyle, f2, scale, (Composer) obj, ((Integer) obj2).intValue());
                        return CommonTagRow_vVAugoc$lambda$4;
                    }
                }, $composer2, 54), $composer2, 384, 3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            List tagsToShow2 = new ArrayList();
            Iterator it = allTags2.iterator();
            int totalWidth = 0;
            while (true) {
                str = "";
                CommonGoodsTagBean $i$f$cache = tag;
                if (!it.hasNext()) {
                    allTags = allTags2;
                    spacing = spacing2;
                    $dirty = $dirty3;
                    break;
                }
                CommonGoodsTagBean tag2 = (CommonGoodsTagBean) it.next();
                Integer tagType = tag2.getTagType();
                Object it$iv3 = it$iv2;
                if (tagType != null) {
                    z = z2;
                    if (tagType.intValue() == 2) {
                        isImage = true;
                        if (!isImage) {
                            Integer tagVersion = tag2.getTagVersion();
                            if (tagVersion == null) {
                                allTags = allTags2;
                                $dirty = $dirty3;
                            } else {
                                allTags = allTags2;
                                if (tagVersion.intValue() != 2) {
                                    $dirty = $dirty3;
                                } else {
                                    $dirty = $dirty3;
                                    double targetHeight = f2;
                                    Double backImgHeight = tag2.getBackImgHeight();
                                    double originalHeight = backImgHeight != null ? backImgHeight.doubleValue() : targetHeight;
                                    Double backImgWidth = tag2.getBackImgWidth();
                                    double originalWidth = backImgWidth != null ? backImgWidth.doubleValue() : 0.0d;
                                    imageWidth = ProvideUiScaleKt.dpScaled((targetHeight / originalHeight) * originalWidth, scale);
                                    tagWidth = density.roundToPx-0680j_4(imageWidth);
                                    spacing = spacing2;
                                }
                            }
                            Double backImgWidth2 = tag2.getBackImgWidth();
                            imageWidth = ProvideUiScaleKt.dpScaled(backImgWidth2 != null ? backImgWidth2.doubleValue() : 0.0d, scale);
                            tagWidth = density.roundToPx-0680j_4(imageWidth);
                            spacing = spacing2;
                        } else {
                            allTags = allTags2;
                            $dirty = $dirty3;
                            Integer tagType2 = tag2.getTagType();
                            if (tagType2 == null) {
                                spacing = spacing2;
                            } else if (tagType2.intValue() != 1) {
                                spacing = spacing2;
                            } else {
                                String title2 = tag2.getTitle();
                                if (title2 == null) {
                                    title2 = "";
                                }
                                spacing = spacing2;
                                tagWidth = (int) (TextMeasurer.measure-xDpz5zY$default(textMeasurer, new AnnotatedString(title2, (List) null, 2, (DefaultConstructorMarker) null), textStyle, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 2044, (Object) null).getSize-YbymL2g() >> 32);
                            }
                            Integer tagType3 = tag2.getTagType();
                            if (tagType3 != null && tagType3.intValue() == 3) {
                                String title3 = tag2.getTitle();
                                if (title3 == null) {
                                    title3 = "";
                                }
                                tagWidth = ((int) (TextMeasurer.measure-xDpz5zY$default(textMeasurer, new AnnotatedString(title3, (List) null, 2, (DefaultConstructorMarker) null), oldTextStyle, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 2044, (Object) null).getSize-YbymL2g() >> 32)) + (spacingPx * 2);
                            } else {
                                spacing2 = spacing;
                                tag = $i$f$cache;
                                it$iv2 = it$iv3;
                                z2 = z;
                                allTags2 = allTags;
                                $dirty3 = $dirty;
                            }
                        }
                        if (totalWidth + spacingPx + tagWidth <= maxWidthPx) {
                            break;
                        }
                        totalWidth += spacingPx + tagWidth;
                        tagsToShow2.add(tag2);
                        spacing2 = spacing;
                        tag = $i$f$cache;
                        it$iv2 = it$iv3;
                        z2 = z;
                        allTags2 = allTags;
                        $dirty3 = $dirty;
                    }
                } else {
                    z = z2;
                }
                isImage = false;
                if (!isImage) {
                }
                if (totalWidth + spacingPx + tagWidth <= maxWidthPx) {
                }
            }
            int remainingWidth = (maxWidthPx - totalWidth) - (!tagsToShow2.isEmpty() ? spacingPx : 0);
            if (remainingWidth > 0) {
                String result2 = "";
                int i3 = 0;
                int length = title.length();
                while (true) {
                    if (i3 >= length) {
                        result = result2;
                        break;
                    }
                    String result3 = title.substring(0, i3 + 1);
                    Intrinsics.checkNotNullExpressionValue(result3, "substring(...)");
                    result = result2;
                    TextLayoutResult measured = TextMeasurer.measure-xDpz5zY$default(textMeasurer, new AnnotatedString(result3, (List) null, 2, (DefaultConstructorMarker) null), textStyle, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 2044, (Object) null);
                    if (((int) (measured.getSize-YbymL2g() >> 32)) > remainingWidth) {
                        break;
                    }
                    i3++;
                    result2 = result3;
                }
                str = result;
            }
            String clippedTitle2 = str;
            Object value$iv2 = new Triple(tagsToShow2, clippedTitle2, Integer.valueOf(totalWidth));
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            Triple fittingTags2 = (Triple) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final List tagsToShow3 = (List) fittingTags2.component1();
            final String clippedTitle3 = (String) fittingTags2.component2();
            final Modifier modifier42 = modifier3;
            final float f32 = spacing;
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-1392194960, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CommonTagRowKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit CommonTagRow_vVAugoc$lambda$4;
                    CommonTagRow_vVAugoc$lambda$4 = CommonTagRowKt.CommonTagRow_vVAugoc$lambda$4(modifier42, tagsToShow3, clippedTitle3, f32, textStyle, f2, scale, (Composer) obj, ((Integer) obj2).intValue());
                    return CommonTagRow_vVAugoc$lambda$4;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CommonTagRowKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit CommonTagRow_vVAugoc$lambda$5;
                    CommonTagRow_vVAugoc$lambda$5 = CommonTagRowKt.CommonTagRow_vVAugoc$lambda$5(list, title, f, scale, f2, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CommonTagRow_vVAugoc$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0375  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit CommonTagRow_vVAugoc$lambda$4(Modifier $modifier, List $tagsToShow, String $clippedTitle, float $spacing, TextStyle $textStyle, float f, float $scale, Composer $composer, int $changed) {
        String str;
        Modifier modifier$iv$iv;
        RowScope $this$CommonTagRow_vVAugoc_u24lambda_u244_u240;
        Modifier materialized$iv$iv;
        Composer $composer$iv$iv;
        CompositionLocalMap localMap$iv$iv;
        Composer $composer$iv$iv2;
        MeasurePolicy measurePolicy$iv$iv;
        String str2;
        Modifier modifier$iv$iv2;
        Arrangement.Horizontal horizontalArrangement$iv;
        Composer $composer$iv$iv$iv;
        Arrangement.Horizontal horizontalArrangement$iv2;
        Composer $composer$iv$iv$iv2;
        Arrangement.Horizontal horizontalArrangement$iv3;
        String imageUrl;
        Integer tagVersion;
        float imgWidth;
        Integer tagVersion2;
        float imgHeight;
        Composer $composer$iv$iv$iv3;
        boolean z;
        Composer $composer2;
        float f2 = $scale;
        ComposerKt.sourceInformation($composer, "C146@5543L3522:CommonTagRow.kt#o90vz8");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1392194960, $changed, -1, "kntr.app.mall.product.details.page.ui.components.CommonTagRow.<anonymous> (CommonTagRow.kt:146)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            Modifier modifier$iv$iv3 = $modifier;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv$iv3);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Composer $composer$iv$iv$iv4 = $composer;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv$iv4.startReusableNode();
            if ($composer$iv$iv$iv4.getInserting()) {
                $composer$iv$iv$iv4.createNode(factory$iv$iv$iv);
            } else {
                $composer$iv$iv$iv4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv$iv4);
            Composer $composer$iv = $composer;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            CompositionLocalMap localMap$iv$iv3 = localMap$iv$iv2;
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            Modifier materialized$iv$iv3 = materialized$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i2 = ((384 >> 6) & 112) | 6;
            RowScope $this$CommonTagRow_vVAugoc_u24lambda_u244_u2402 = RowScopeInstance.INSTANCE;
            RowScope $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u2402;
            Composer $composer3 = $composer$iv$iv$iv4;
            Composer $composer$iv2 = $composer$iv$iv$iv4;
            MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -360927631, "C:CommonTagRow.kt#o90vz8");
            $composer3.startReplaceGroup(958188357);
            String str3 = "";
            ComposerKt.sourceInformation($composer3, "");
            List $this$forEachIndexed$iv = $tagsToShow;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                CommonGoodsTagBean tag = (CommonGoodsTagBean) item$iv;
                int index = index$iv;
                if (index > 0) {
                    $composer3.startReplaceGroup(-2086308266);
                    ComposerKt.sourceInformation($composer3, "151@5738L42");
                    str = str3;
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, $spacing), $composer3, 0);
                } else {
                    str = str3;
                    $composer3.startReplaceGroup(-256741194);
                }
                $composer3.endReplaceGroup();
                Integer tagType = tag.getTagType();
                if (tagType == null) {
                    modifier$iv$iv = modifier$iv$iv3;
                } else {
                    modifier$iv$iv = modifier$iv$iv3;
                    if (tagType.intValue() == 1) {
                        $composer3.startReplaceGroup(-250921130);
                        ComposerKt.sourceInformation($composer3, "155@5914L253,161@6192L365");
                        Brush titleColor = buildColor(tag.getTitleDayColor1(), tag.getTitleDayColor2(), tag.getTitleNightColor1(), tag.getTitleNightColor2(), $composer3, 0);
                        String title = tag.getTitle();
                        TextKt.Text-Nvy7gAk(title == null ? str : title, $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403.align(Modifier.Companion, Alignment.Companion.getCenterVertically()), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, $textStyle.merge(new TextStyle(titleColor, 0.0f, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 33554430, (DefaultConstructorMarker) null)), $composer3, 0, 24576, 114684);
                        $composer3.endReplaceGroup();
                        $this$CommonTagRow_vVAugoc_u24lambda_u244_u240 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403;
                        materialized$iv$iv = materialized$iv$iv3;
                        $composer$iv$iv = $composer$iv;
                        localMap$iv$iv = localMap$iv$iv3;
                        $composer$iv$iv2 = $composer$iv2;
                        measurePolicy$iv$iv = measurePolicy$iv$iv2;
                        str2 = str;
                        modifier$iv$iv2 = modifier$iv$iv;
                        horizontalArrangement$iv = horizontalArrangement$iv4;
                        $composer$iv$iv$iv = $composer$iv$iv$iv4;
                        $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u240;
                        localMap$iv$iv3 = localMap$iv$iv;
                        str3 = str2;
                        modifier$iv$iv3 = modifier$iv$iv2;
                        index$iv = index$iv2;
                        horizontalArrangement$iv4 = horizontalArrangement$iv;
                        $composer$iv$iv$iv4 = $composer$iv$iv$iv;
                        measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                        $composer$iv2 = $composer$iv$iv2;
                        $composer$iv = $composer$iv$iv;
                        materialized$iv$iv3 = materialized$iv$iv;
                        f2 = $scale;
                    }
                }
                if (tagType == null) {
                    horizontalArrangement$iv2 = horizontalArrangement$iv4;
                    $composer$iv$iv$iv2 = $composer$iv$iv$iv4;
                } else if (tagType.intValue() == 2) {
                    $composer3.startReplaceGroup(-250137357);
                    ComposerKt.sourceInformation($composer3, "190@7813L374");
                    Integer tagVersion3 = tag.getTagVersion();
                    if (tagVersion3 == null) {
                        horizontalArrangement$iv3 = horizontalArrangement$iv4;
                    } else if (tagVersion3.intValue() == 2) {
                        $composer3.startReplaceGroup(-250089369);
                        ComposerKt.sourceInformation($composer3, "174@6749L7");
                        CompositionLocal this_$iv = BiliThemeKt.getLocalTheme();
                        Composer $composer$iv3 = $composer3;
                        horizontalArrangement$iv3 = horizontalArrangement$iv4;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object consume = $composer$iv3.consume(this_$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        imageUrl = ThemeColorsKt.isNightTheme((GarbInfo) consume) ? tag.getBackImgUrlNight() : tag.getBackImgUrlDay();
                        $composer3.endReplaceGroup();
                        tagVersion = tag.getTagVersion();
                        if (tagVersion != null && tagVersion.intValue() == 2) {
                            double targetHeight = f;
                            Double backImgHeight = tag.getBackImgHeight();
                            double originalHeight = backImgHeight == null ? backImgHeight.doubleValue() : targetHeight;
                            Double backImgWidth = tag.getBackImgWidth();
                            double originalWidth = backImgWidth == null ? backImgWidth.doubleValue() : 0.0d;
                            imgWidth = ProvideUiScaleKt.dpScaled((targetHeight / originalHeight) * originalWidth, f2);
                            tagVersion2 = tag.getTagVersion();
                            if (tagVersion2 != null && tagVersion2.intValue() == 2) {
                                imgHeight = f;
                            } else {
                                Double backImgHeight2 = tag.getBackImgHeight();
                                imgHeight = ProvideUiScaleKt.dpScaled(backImgHeight2 == null ? backImgHeight2.doubleValue() : 0.0d, f2);
                            }
                            if (imageUrl != null) {
                                $composer$iv$iv$iv3 = $composer$iv$iv$iv4;
                                if (StringsKt.startsWith$default(imageUrl, "//", false, 2, (Object) null)) {
                                    z = true;
                                    String imgUrl = !z ? "https:" + imageUrl : imageUrl;
                                    BiliImageKt.BiliImage(new ImageRequest(imgUrl != null ? str : imgUrl).build(), $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403.align(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, imgHeight), imgWidth), Alignment.Companion.getCenterVertically()), null, null, null, null, null, null, null, $composer3, 0, 508);
                                    $composer3.endReplaceGroup();
                                    $this$CommonTagRow_vVAugoc_u24lambda_u244_u240 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403;
                                    materialized$iv$iv = materialized$iv$iv3;
                                    $composer$iv$iv = $composer$iv;
                                    localMap$iv$iv = localMap$iv$iv3;
                                    $composer$iv$iv2 = $composer$iv2;
                                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                                    str2 = str;
                                    modifier$iv$iv2 = modifier$iv$iv;
                                    horizontalArrangement$iv = horizontalArrangement$iv3;
                                    $composer$iv$iv$iv = $composer$iv$iv$iv3;
                                    $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u240;
                                    localMap$iv$iv3 = localMap$iv$iv;
                                    str3 = str2;
                                    modifier$iv$iv3 = modifier$iv$iv2;
                                    index$iv = index$iv2;
                                    horizontalArrangement$iv4 = horizontalArrangement$iv;
                                    $composer$iv$iv$iv4 = $composer$iv$iv$iv;
                                    measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                                    $composer$iv2 = $composer$iv$iv2;
                                    $composer$iv = $composer$iv$iv;
                                    materialized$iv$iv3 = materialized$iv$iv;
                                    f2 = $scale;
                                }
                            } else {
                                $composer$iv$iv$iv3 = $composer$iv$iv$iv4;
                            }
                            z = false;
                            if (!z) {
                            }
                            BiliImageKt.BiliImage(new ImageRequest(imgUrl != null ? str : imgUrl).build(), $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403.align(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, imgHeight), imgWidth), Alignment.Companion.getCenterVertically()), null, null, null, null, null, null, null, $composer3, 0, 508);
                            $composer3.endReplaceGroup();
                            $this$CommonTagRow_vVAugoc_u24lambda_u244_u240 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403;
                            materialized$iv$iv = materialized$iv$iv3;
                            $composer$iv$iv = $composer$iv;
                            localMap$iv$iv = localMap$iv$iv3;
                            $composer$iv$iv2 = $composer$iv2;
                            measurePolicy$iv$iv = measurePolicy$iv$iv2;
                            str2 = str;
                            modifier$iv$iv2 = modifier$iv$iv;
                            horizontalArrangement$iv = horizontalArrangement$iv3;
                            $composer$iv$iv$iv = $composer$iv$iv$iv3;
                            $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u240;
                            localMap$iv$iv3 = localMap$iv$iv;
                            str3 = str2;
                            modifier$iv$iv3 = modifier$iv$iv2;
                            index$iv = index$iv2;
                            horizontalArrangement$iv4 = horizontalArrangement$iv;
                            $composer$iv$iv$iv4 = $composer$iv$iv$iv;
                            measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                            $composer$iv2 = $composer$iv$iv2;
                            $composer$iv = $composer$iv$iv;
                            materialized$iv$iv3 = materialized$iv$iv;
                            f2 = $scale;
                        }
                        Double backImgWidth2 = tag.getBackImgWidth();
                        imgWidth = ProvideUiScaleKt.dpScaled(backImgWidth2 == null ? backImgWidth2.doubleValue() : 0.0d, f2);
                        tagVersion2 = tag.getTagVersion();
                        if (tagVersion2 != null) {
                            imgHeight = f;
                            if (imageUrl != null) {
                            }
                            z = false;
                            if (!z) {
                            }
                            BiliImageKt.BiliImage(new ImageRequest(imgUrl != null ? str : imgUrl).build(), $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403.align(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, imgHeight), imgWidth), Alignment.Companion.getCenterVertically()), null, null, null, null, null, null, null, $composer3, 0, 508);
                            $composer3.endReplaceGroup();
                            $this$CommonTagRow_vVAugoc_u24lambda_u244_u240 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403;
                            materialized$iv$iv = materialized$iv$iv3;
                            $composer$iv$iv = $composer$iv;
                            localMap$iv$iv = localMap$iv$iv3;
                            $composer$iv$iv2 = $composer$iv2;
                            measurePolicy$iv$iv = measurePolicy$iv$iv2;
                            str2 = str;
                            modifier$iv$iv2 = modifier$iv$iv;
                            horizontalArrangement$iv = horizontalArrangement$iv3;
                            $composer$iv$iv$iv = $composer$iv$iv$iv3;
                            $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u240;
                            localMap$iv$iv3 = localMap$iv$iv;
                            str3 = str2;
                            modifier$iv$iv3 = modifier$iv$iv2;
                            index$iv = index$iv2;
                            horizontalArrangement$iv4 = horizontalArrangement$iv;
                            $composer$iv$iv$iv4 = $composer$iv$iv$iv;
                            measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                            $composer$iv2 = $composer$iv$iv2;
                            $composer$iv = $composer$iv$iv;
                            materialized$iv$iv3 = materialized$iv$iv;
                            f2 = $scale;
                        }
                        Double backImgHeight22 = tag.getBackImgHeight();
                        imgHeight = ProvideUiScaleKt.dpScaled(backImgHeight22 == null ? backImgHeight22.doubleValue() : 0.0d, f2);
                        if (imageUrl != null) {
                        }
                        z = false;
                        if (!z) {
                        }
                        BiliImageKt.BiliImage(new ImageRequest(imgUrl != null ? str : imgUrl).build(), $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403.align(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, imgHeight), imgWidth), Alignment.Companion.getCenterVertically()), null, null, null, null, null, null, null, $composer3, 0, 508);
                        $composer3.endReplaceGroup();
                        $this$CommonTagRow_vVAugoc_u24lambda_u244_u240 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403;
                        materialized$iv$iv = materialized$iv$iv3;
                        $composer$iv$iv = $composer$iv;
                        localMap$iv$iv = localMap$iv$iv3;
                        $composer$iv$iv2 = $composer$iv2;
                        measurePolicy$iv$iv = measurePolicy$iv$iv2;
                        str2 = str;
                        modifier$iv$iv2 = modifier$iv$iv;
                        horizontalArrangement$iv = horizontalArrangement$iv3;
                        $composer$iv$iv$iv = $composer$iv$iv$iv3;
                        $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u240;
                        localMap$iv$iv3 = localMap$iv$iv;
                        str3 = str2;
                        modifier$iv$iv3 = modifier$iv$iv2;
                        index$iv = index$iv2;
                        horizontalArrangement$iv4 = horizontalArrangement$iv;
                        $composer$iv$iv$iv4 = $composer$iv$iv$iv;
                        measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                        $composer$iv2 = $composer$iv$iv2;
                        $composer$iv = $composer$iv$iv;
                        materialized$iv$iv3 = materialized$iv$iv;
                        f2 = $scale;
                    } else {
                        horizontalArrangement$iv3 = horizontalArrangement$iv4;
                    }
                    $composer3.startReplaceGroup(-249943576);
                    $composer3.endReplaceGroup();
                    imageUrl = tag.getBackImgUrl();
                    tagVersion = tag.getTagVersion();
                    if (tagVersion != null) {
                        double targetHeight2 = f;
                        Double backImgHeight3 = tag.getBackImgHeight();
                        if (backImgHeight3 == null) {
                        }
                        Double backImgWidth3 = tag.getBackImgWidth();
                        if (backImgWidth3 == null) {
                        }
                        imgWidth = ProvideUiScaleKt.dpScaled((targetHeight2 / originalHeight) * originalWidth, f2);
                        tagVersion2 = tag.getTagVersion();
                        if (tagVersion2 != null) {
                        }
                        Double backImgHeight222 = tag.getBackImgHeight();
                        imgHeight = ProvideUiScaleKt.dpScaled(backImgHeight222 == null ? backImgHeight222.doubleValue() : 0.0d, f2);
                        if (imageUrl != null) {
                        }
                        z = false;
                        if (!z) {
                        }
                        BiliImageKt.BiliImage(new ImageRequest(imgUrl != null ? str : imgUrl).build(), $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403.align(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, imgHeight), imgWidth), Alignment.Companion.getCenterVertically()), null, null, null, null, null, null, null, $composer3, 0, 508);
                        $composer3.endReplaceGroup();
                        $this$CommonTagRow_vVAugoc_u24lambda_u244_u240 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403;
                        materialized$iv$iv = materialized$iv$iv3;
                        $composer$iv$iv = $composer$iv;
                        localMap$iv$iv = localMap$iv$iv3;
                        $composer$iv$iv2 = $composer$iv2;
                        measurePolicy$iv$iv = measurePolicy$iv$iv2;
                        str2 = str;
                        modifier$iv$iv2 = modifier$iv$iv;
                        horizontalArrangement$iv = horizontalArrangement$iv3;
                        $composer$iv$iv$iv = $composer$iv$iv$iv3;
                        $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u240;
                        localMap$iv$iv3 = localMap$iv$iv;
                        str3 = str2;
                        modifier$iv$iv3 = modifier$iv$iv2;
                        index$iv = index$iv2;
                        horizontalArrangement$iv4 = horizontalArrangement$iv;
                        $composer$iv$iv$iv4 = $composer$iv$iv$iv;
                        measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                        $composer$iv2 = $composer$iv$iv2;
                        $composer$iv = $composer$iv$iv;
                        materialized$iv$iv3 = materialized$iv$iv;
                        f2 = $scale;
                    }
                    Double backImgWidth22 = tag.getBackImgWidth();
                    imgWidth = ProvideUiScaleKt.dpScaled(backImgWidth22 == null ? backImgWidth22.doubleValue() : 0.0d, f2);
                    tagVersion2 = tag.getTagVersion();
                    if (tagVersion2 != null) {
                    }
                    Double backImgHeight2222 = tag.getBackImgHeight();
                    imgHeight = ProvideUiScaleKt.dpScaled(backImgHeight2222 == null ? backImgHeight2222.doubleValue() : 0.0d, f2);
                    if (imageUrl != null) {
                    }
                    z = false;
                    if (!z) {
                    }
                    BiliImageKt.BiliImage(new ImageRequest(imgUrl != null ? str : imgUrl).build(), $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403.align(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, imgHeight), imgWidth), Alignment.Companion.getCenterVertically()), null, null, null, null, null, null, null, $composer3, 0, 508);
                    $composer3.endReplaceGroup();
                    $this$CommonTagRow_vVAugoc_u24lambda_u244_u240 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403;
                    materialized$iv$iv = materialized$iv$iv3;
                    $composer$iv$iv = $composer$iv;
                    localMap$iv$iv = localMap$iv$iv3;
                    $composer$iv$iv2 = $composer$iv2;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    str2 = str;
                    modifier$iv$iv2 = modifier$iv$iv;
                    horizontalArrangement$iv = horizontalArrangement$iv3;
                    $composer$iv$iv$iv = $composer$iv$iv$iv3;
                    $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u240;
                    localMap$iv$iv3 = localMap$iv$iv;
                    str3 = str2;
                    modifier$iv$iv3 = modifier$iv$iv2;
                    index$iv = index$iv2;
                    horizontalArrangement$iv4 = horizontalArrangement$iv;
                    $composer$iv$iv$iv4 = $composer$iv$iv$iv;
                    measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                    $composer$iv2 = $composer$iv$iv2;
                    $composer$iv = $composer$iv$iv;
                    materialized$iv$iv3 = materialized$iv$iv;
                    f2 = $scale;
                } else {
                    horizontalArrangement$iv2 = horizontalArrangement$iv4;
                    $composer$iv$iv$iv2 = $composer$iv$iv$iv4;
                }
                if (tagType == null) {
                    $this$CommonTagRow_vVAugoc_u24lambda_u244_u240 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403;
                    materialized$iv$iv = materialized$iv$iv3;
                    $composer$iv$iv = $composer$iv;
                    localMap$iv$iv = localMap$iv$iv3;
                    $composer$iv$iv2 = $composer$iv2;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    str2 = str;
                    modifier$iv$iv2 = modifier$iv$iv;
                    $composer2 = $composer3;
                    horizontalArrangement$iv = horizontalArrangement$iv2;
                    $composer$iv$iv$iv = $composer$iv$iv$iv2;
                } else if (tagType.intValue() != 3) {
                    $this$CommonTagRow_vVAugoc_u24lambda_u244_u240 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403;
                    materialized$iv$iv = materialized$iv$iv3;
                    $composer$iv$iv = $composer$iv;
                    localMap$iv$iv = localMap$iv$iv3;
                    $composer$iv$iv2 = $composer$iv2;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    str2 = str;
                    modifier$iv$iv2 = modifier$iv$iv;
                    $composer2 = $composer3;
                    horizontalArrangement$iv = horizontalArrangement$iv2;
                    $composer$iv$iv$iv = $composer$iv$iv$iv2;
                } else {
                    $composer3.startReplaceGroup(-248536331);
                    ComposerKt.sourceInformation($composer3, "201@8262L257");
                    Composer $composer4 = $composer3;
                    materialized$iv$iv = materialized$iv$iv3;
                    localMap$iv$iv = localMap$iv$iv3;
                    $composer$iv$iv = $composer$iv;
                    $composer$iv$iv2 = $composer$iv2;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    str2 = str;
                    $this$CommonTagRow_vVAugoc_u24lambda_u244_u240 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403;
                    modifier$iv$iv2 = modifier$iv$iv;
                    horizontalArrangement$iv = horizontalArrangement$iv2;
                    $composer$iv$iv$iv = $composer$iv$iv$iv2;
                    m431HomeOldTextTag942rkJo(tag, $scale, f, $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403.align(Modifier.Companion, Alignment.Companion.getCenterVertically()), $composer4, 0, 0);
                    $composer4.endReplaceGroup();
                    $composer3 = $composer4;
                    $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u240;
                    localMap$iv$iv3 = localMap$iv$iv;
                    str3 = str2;
                    modifier$iv$iv3 = modifier$iv$iv2;
                    index$iv = index$iv2;
                    horizontalArrangement$iv4 = horizontalArrangement$iv;
                    $composer$iv$iv$iv4 = $composer$iv$iv$iv;
                    measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                    $composer$iv2 = $composer$iv$iv2;
                    $composer$iv = $composer$iv$iv;
                    materialized$iv$iv3 = materialized$iv$iv;
                    f2 = $scale;
                }
                $composer3 = $composer2;
                $composer3.startReplaceGroup(-256741194);
                $composer3.endReplaceGroup();
                $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u240;
                localMap$iv$iv3 = localMap$iv$iv;
                str3 = str2;
                modifier$iv$iv3 = modifier$iv$iv2;
                index$iv = index$iv2;
                horizontalArrangement$iv4 = horizontalArrangement$iv;
                $composer$iv$iv$iv4 = $composer$iv$iv$iv;
                measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                $composer$iv2 = $composer$iv$iv2;
                $composer$iv = $composer$iv$iv;
                materialized$iv$iv3 = materialized$iv$iv;
                f2 = $scale;
            }
            RowScope $this$CommonTagRow_vVAugoc_u24lambda_u244_u2404 = $this$CommonTagRow_vVAugoc_u24lambda_u244_u2403;
            Composer $composer$iv$iv$iv5 = $composer$iv$iv$iv4;
            Composer $composer$iv$iv3 = $composer$iv;
            Composer $composer$iv$iv4 = $composer$iv2;
            $composer3.endReplaceGroup();
            if ($clippedTitle.length() > 0) {
                $composer3.startReplaceGroup(-358089799);
                ComposerKt.sourceInformation($composer3, "216@8848L6,213@8724L317");
                if ($tagsToShow.isEmpty()) {
                    $composer3.startReplaceGroup(-366653394);
                } else {
                    $composer3.startReplaceGroup(958281150);
                    ComposerKt.sourceInformation($composer3, "212@8665L42");
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, $spacing), $composer3, 0);
                }
                $composer3.endReplaceGroup();
                TextKt.Text-Nvy7gAk($clippedTitle, $this$CommonTagRow_vVAugoc_u24lambda_u244_u2404.align(Modifier.Companion, Alignment.Companion.getCenterVertically()), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, $textStyle, $composer3, 0, 24576, 114680);
            } else {
                $composer3.startReplaceGroup(-366653394);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv4);
            $composer$iv$iv$iv5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    /* renamed from: HomeOldTextTag-942rkJo  reason: not valid java name */
    public static final void m431HomeOldTextTag942rkJo(final CommonGoodsTagBean tag, final float scale, final float f, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Modifier modifier5;
        ?? r0;
        Brush backColor;
        Brush brush;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        float dpScaled;
        Function0 factory$iv$iv$iv2;
        Double cornerRadius;
        Double cornerRadius2;
        Integer useBoard;
        Integer tagType;
        Composer $composer3 = $composer.startRestartGroup(1497649980);
        ComposerKt.sourceInformation($composer3, "C(HomeOldTextTag)N(tag,scale,tagHeight:c#ui.unit.Dp,modifier)263@10028L157,270@10191L1206:CommonTagRow.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(tag) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(scale) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(f) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1497649980, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.HomeOldTextTag (CommonTagRow.kt:236)");
            }
            if ((tag == null || (tagType = tag.getTagType()) == null || tagType.intValue() != 3) ? false : true) {
                $composer3.startReplaceGroup(370484741);
                ComposerKt.sourceInformation($composer3, "239@9324L169");
                modifier5 = modifier4;
                r0 = 0;
                Brush buildColor = buildColor(tag.getBackDayColor1(), tag.getBackDayColor2(), tag.getBackNightColor1(), tag.getBackNightColor2(), $composer3, 0);
                $composer3.endReplaceGroup();
                backColor = buildColor;
            } else {
                modifier5 = modifier4;
                r0 = 0;
                $composer3.startReplaceGroup(370679080);
                $composer3.endReplaceGroup();
                backColor = Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.Companion.getTransparent-0d7_KjU()), Color.box-impl(Color.Companion.getTransparent-0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null);
            }
            if ((tag == null || (useBoard = tag.getUseBoard()) == null || useBoard.intValue() != 1) ? r0 : true) {
                $composer3.startReplaceGroup(370830081);
                ComposerKt.sourceInformation($composer3, "251@9672L173");
                brush = buildColor(tag.getBoardDayColor1(), tag.getBoardDayColor2(), tag.getBoardNightColor1(), tag.getBoardNightColor2(), $composer3, 0);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(371028264);
                $composer3.endReplaceGroup();
                Brush.Companion companion = Brush.Companion;
                Color[] colorArr = new Color[2];
                colorArr[r0] = Color.box-impl(Color.Companion.getTransparent-0d7_KjU());
                colorArr[1] = Color.box-impl(Color.Companion.getTransparent-0d7_KjU());
                brush = Brush.Companion.horizontalGradient-8A-3gB4$default(companion, CollectionsKt.listOf(colorArr), 0.0f, 0.0f, 0, 14, (Object) null);
            }
            Brush boardColor = brush;
            float borderWidth = ProvideUiScaleKt.dpScaled(0.5d, scale);
            Brush titleColor = buildColor(tag != null ? tag.getTitleDayColor1() : null, tag != null ? tag.getTitleDayColor2() : null, tag != null ? tag.getTitleNightColor1() : null, tag != null ? tag.getTitleNightColor2() : null, $composer3, 0);
            Modifier modifier$iv = SizeKt.wrapContentWidth$default(SizeKt.height-3ABfNKs(modifier5, f), (Alignment.Horizontal) null, (boolean) r0, 3, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier3 = modifier5;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1579364657, "C277@10369L1022:CommonTagRow.kt#o90vz8");
            Modifier modifier6 = SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f - ProvideUiScaleKt.dpScaled(2, scale)));
            if (tag == null || (cornerRadius2 = tag.getCornerRadius()) == null) {
                $composer$iv = $composer3;
                dpScaled = ProvideUiScaleKt.dpScaled(4, scale);
            } else {
                $composer$iv = $composer3;
                dpScaled = ProvideUiScaleKt.dpScaled(cornerRadius2.doubleValue(), scale);
            }
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background$default(BorderKt.border-ziNgDLE(modifier6, borderWidth, boardColor, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(dpScaled)), backColor, RoundedCornerShapeKt.RoundedCornerShape-0680j_4((tag == null || (cornerRadius = tag.getCornerRadius()) == null) ? ProvideUiScaleKt.dpScaled(4, scale) : ProvideUiScaleKt.dpScaled(cornerRadius.doubleValue(), scale)), 0.0f, 4, (Object) null), ProvideUiScaleKt.dpScaled(4, scale), 0.0f, 2, (Object) null);
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -893400172, "C291@11030L351:CommonTagRow.kt#o90vz8");
            TextKt.Text-Nvy7gAk((tag == null || (r2 = tag.getTitle()) == null) ? "" : "", (Modifier) null, 0L, (TextAutoSize) null, ProvideUiScaleKt.spScaled(10, scale), (FontStyle) null, FontWeight.Companion.getW400(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 1, 0, (Function1) null, new TextStyle(titleColor, 0.0f, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 33554430, (DefaultConstructorMarker) null), $composer3, 1572864, 24576, 113582);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.CommonTagRowKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HomeOldTextTag_942rkJo$lambda$1;
                    HomeOldTextTag_942rkJo$lambda$1 = CommonTagRowKt.HomeOldTextTag_942rkJo$lambda$1(CommonGoodsTagBean.this, scale, f, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HomeOldTextTag_942rkJo$lambda$1;
                }
            });
        }
    }

    public static final Brush buildColor(String dayColor1, String dayColor2, String nightColor1, String nightColor2, Composer $composer, int $changed) {
        Brush brush;
        ComposerKt.sourceInformationMarkerStart($composer, 426314070, "C(buildColor)N(dayColor1,dayColor2,nightColor1,nightColor2)313@11559L7:CommonTagRow.kt#o90vz8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(426314070, $changed, -1, "kntr.app.mall.product.details.page.ui.components.buildColor (CommonTagRow.kt:313)");
        }
        CompositionLocal this_$iv = BiliThemeKt.getLocalTheme();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ThemeColorsKt.isNightTheme((GarbInfo) consume)) {
            brush = Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ComposeColorParserKt.parseColor("#" + nightColor1)), Color.box-impl(ComposeColorParserKt.parseColor("#" + nightColor2))}), 0.0f, 0.0f, 0, 14, (Object) null);
        } else {
            brush = Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ComposeColorParserKt.parseColor("#" + dayColor1)), Color.box-impl(ComposeColorParserKt.parseColor("#" + dayColor2))}), 0.0f, 0.0f, 0, 14, (Object) null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return brush;
    }
}