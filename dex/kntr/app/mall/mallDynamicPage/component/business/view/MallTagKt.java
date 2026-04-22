package kntr.app.mall.mallDynamicPage.component.business.view;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.PlatformTextStyle;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.app.mall.mallDynamicPage.component.business.bean.TagInfo;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* compiled from: MallTag.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a5\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"MallTag", RoomRecommendViewModel.EMPTY_CURSOR, "tag", "Lkntr/app/mall/mallDynamicPage/component/business/bean/TagInfo;", "(Lkntr/app/mall/mallDynamicPage/component/business/bean/TagInfo;Landroidx/compose/runtime/Composer;I)V", "buildColor", "Landroidx/compose/ui/graphics/Brush;", "dayColor1", RoomRecommendViewModel.EMPTY_CURSOR, "dayColor2", "nightColor1", "nightColor2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Brush;", "mallDynamicPage_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MallTagKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MallTag$lambda$1(TagInfo tagInfo, int i, Composer composer, int i2) {
        MallTag(tagInfo, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0757  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MallTag(final TagInfo tag, Composer $composer, final int $changed) {
        Composer $composer2;
        Brush backColor;
        Brush brush;
        boolean z;
        String str;
        String str2;
        Integer tagType;
        float borderWidth;
        Brush boardColor;
        Composer $composer3;
        Composer $composer4;
        float f;
        float f2;
        Composer $composer5;
        Brush boardColor2;
        float borderWidth2;
        float f3;
        float f4;
        float f5;
        float f6;
        Function0 factory$iv$iv$iv;
        float f7;
        float f8;
        String backImgUrl;
        Integer useBoard;
        Integer useBoard2;
        Integer tagType2;
        Integer tagType3;
        Composer $composer6 = $composer.startRestartGroup(-363965690);
        ComposerKt.sourceInformation($composer6, "C(MallTag)N(tag)51@1860L157:MallTag.kt#tloqc2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer6.changedInstance(tag) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer6.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-363965690, $dirty2, -1, "kntr.app.mall.mallDynamicPage.component.business.view.MallTag (MallTag.kt:27)");
            }
            if (!((tag == null || (tagType3 = tag.getTagType()) == null || tagType3.intValue() != 3) ? false : true)) {
                if (!((tag == null || (tagType2 = tag.getTagType()) == null || tagType2.intValue() != 4) ? false : true)) {
                    $composer6.startReplaceGroup(1890852126);
                    $composer6.endReplaceGroup();
                    backColor = Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.Companion.getTransparent-0d7_KjU()), Color.box-impl(Color.Companion.getTransparent-0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null);
                    if (tag == null && (useBoard2 = tag.getUseBoard()) != null && useBoard2.intValue() == 1) {
                        $composer6.startReplaceGroup(1891200318);
                        $composer6.endReplaceGroup();
                        brush = Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.Companion.getTransparent-0d7_KjU()), Color.box-impl(Color.Companion.getTransparent-0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null);
                    } else {
                        $composer6.startReplaceGroup(1891002135);
                        ComposerKt.sourceInformation($composer6, "41@1547L173");
                        brush = buildColor(tag.getBoardDayColor1(), tag.getBoardDayColor2(), tag.getBoardNightColor1(), tag.getBoardNightColor2(), $composer6, 0);
                        $composer6.endReplaceGroup();
                    }
                    Brush boardColor3 = brush;
                    Brush titleColor = buildColor(tag == null ? tag.getTitleDayColor1() : null, tag == null ? tag.getTitleDayColor2() : null, tag == null ? tag.getTitleNightColor1() : null, tag == null ? tag.getTitleNightColor2() : null, $composer6, 0);
                    float borderWidth3 = !(tag == null && (useBoard = tag.getUseBoard()) != null && useBoard.intValue() == 1) ? Dp.constructor-impl((float) 0.5d) : Dp.constructor-impl((float) (-0.5d));
                    z = tag == null && (backImgUrl = tag.getBackImgUrl()) != null && StringsKt.startsWith$default(backImgUrl, "http", false, 2, (Object) null);
                    String str3 = RoomRecommendViewModel.EMPTY_CURSOR;
                    if (z) {
                        if (tag == null || (str = tag.getBackImgUrl()) == null) {
                            str = RoomRecommendViewModel.EMPTY_CURSOR;
                        }
                        str2 = "https:" + str;
                    } else {
                        str2 = tag.getBackImgUrl();
                    }
                    String imageUrl = str2;
                    tagType = tag == null ? tag.getTagType() : null;
                    if (tagType != null) {
                        borderWidth = borderWidth3;
                        boardColor = boardColor3;
                        $composer3 = $composer6;
                    } else if (tagType.intValue() == 1) {
                        $composer6.startReplaceGroup(1891782684);
                        ComposerKt.sourceInformation($composer6, "66@2314L384");
                        String title = tag.getTitle();
                        if (title == null) {
                            title = RoomRecommendViewModel.EMPTY_CURSOR;
                        }
                        TextKt.Text-Nvy7gAk(title, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(4), 0.0f, 11, (Object) null), 0L, (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.Companion.getW500(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(20), 0, false, 1, 0, (Function1) null, new TextStyle(titleColor, 0.0f, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 33554430, (DefaultConstructorMarker) null), $composer6, 1597488, 24624, 112556);
                        $composer6.endReplaceGroup();
                        $composer2 = $composer6;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        borderWidth = borderWidth3;
                        boardColor = boardColor3;
                        $composer3 = $composer6;
                    }
                    if (tagType != null) {
                        $composer4 = $composer3;
                    } else if (tagType.intValue() == 2) {
                        Composer $composer7 = $composer3;
                        $composer7.startReplaceGroup(-1878624314);
                        ComposerKt.sourceInformation($composer7, "80@2725L320");
                        if (imageUrl != null) {
                            str3 = imageUrl;
                        }
                        ImmutableImageRequest build = new ImageRequest(str3).build();
                        Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(4), 0.0f, 11, (Object) null);
                        Integer backImgWidth = tag.getBackImgWidth();
                        if (backImgWidth != null) {
                            int $this$dp$iv = backImgWidth.intValue();
                            f = Dp.constructor-impl($this$dp$iv);
                        } else {
                            f = Dp.constructor-impl(12);
                        }
                        Modifier modifier2 = SizeKt.width-3ABfNKs(modifier, f);
                        Integer backImgHeight = tag.getBackImgHeight();
                        if (backImgHeight != null) {
                            int $this$dp$iv2 = backImgHeight.intValue();
                            f2 = Dp.constructor-impl($this$dp$iv2);
                        } else {
                            f2 = Dp.constructor-impl(12);
                        }
                        BiliImageKt.BiliImage(build, SizeKt.height-3ABfNKs(modifier2, f2), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer7, 0, 508);
                        $composer7.endReplaceGroup();
                        $composer2 = $composer7;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    } else {
                        $composer4 = $composer3;
                    }
                    if (tagType != null) {
                        $composer5 = $composer4;
                        boardColor2 = boardColor;
                        borderWidth2 = borderWidth;
                    } else if (tagType.intValue() == 3) {
                        $composer4.startReplaceGroup(1892550182);
                        ComposerKt.sourceInformation($composer4, "90@3072L886");
                        String title2 = tag.getTitle();
                        if (title2 == null) {
                            title2 = RoomRecommendViewModel.EMPTY_CURSOR;
                        }
                        TextStyle textStyle = new TextStyle(titleColor, 0.0f, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 33554430, (DefaultConstructorMarker) null);
                        long sp = TextUnitKt.getSp(11);
                        FontWeight w400 = FontWeight.Companion.getW400();
                        long sp2 = TextUnitKt.getSp(12);
                        Modifier modifier3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(4), 0.0f, 11, (Object) null);
                        Integer cornerRadius = tag.getCornerRadius();
                        if (cornerRadius != null) {
                            int $this$dp$iv3 = cornerRadius.intValue();
                            f3 = Dp.constructor-impl($this$dp$iv3);
                        } else {
                            f3 = Dp.constructor-impl(4);
                        }
                        Modifier background$default = BackgroundKt.background$default(modifier3, backColor, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(f3), 0.0f, 4, (Object) null);
                        Integer cornerRadius2 = tag.getCornerRadius();
                        if (cornerRadius2 != null) {
                            int $this$dp$iv4 = cornerRadius2.intValue();
                            f4 = Dp.constructor-impl($this$dp$iv4);
                        } else {
                            f4 = Dp.constructor-impl(4);
                        }
                        Composer $composer8 = $composer4;
                        TextKt.Text-Nvy7gAk(title2, PaddingKt.padding-VpY3zN4(BorderKt.border-ziNgDLE(background$default, borderWidth, boardColor, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(f4)), Dp.constructor-impl(4), Dp.constructor-impl(2)), 0L, (TextAutoSize) null, sp, (FontStyle) null, w400, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, sp2, 0, false, 1, 0, (Function1) null, textStyle, $composer8, 1597440, 24624, 112556);
                        $composer8.endReplaceGroup();
                        $composer2 = $composer8;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    } else {
                        $composer5 = $composer4;
                        boardColor2 = boardColor;
                        borderWidth2 = borderWidth;
                    }
                    if (tagType != null) {
                        $composer2 = $composer5;
                    } else if (tagType.intValue() == 4) {
                        $composer2 = $composer5;
                        $composer2.startReplaceGroup(1893471998);
                        ComposerKt.sourceInformation($composer2, "114@3985L1406");
                        Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                        Modifier modifier4 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(4), 0.0f, 11, (Object) null);
                        Integer cornerRadius3 = tag.getCornerRadius();
                        if (cornerRadius3 != null) {
                            int $this$dp$iv5 = cornerRadius3.intValue();
                            f5 = Dp.constructor-impl($this$dp$iv5);
                        } else {
                            f5 = Dp.constructor-impl(4);
                        }
                        Modifier background$default2 = BackgroundKt.background$default(modifier4, backColor, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(f5), 0.0f, 4, (Object) null);
                        Integer cornerRadius4 = tag.getCornerRadius();
                        if (cornerRadius4 != null) {
                            int $this$dp$iv6 = cornerRadius4.intValue();
                            f6 = Dp.constructor-impl($this$dp$iv6);
                        } else {
                            f6 = Dp.constructor-impl(4);
                        }
                        Modifier modifier$iv = PaddingKt.padding-VpY3zN4(BorderKt.border-ziNgDLE(background$default2, borderWidth2, boardColor2, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(f6)), Dp.constructor-impl(4), Dp.constructor-impl(2));
                        ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                        CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer2.startReusableNode();
                        if ($composer2.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer2.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer2.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope = RowScopeInstance.INSTANCE;
                        int i2 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1103982628, "C128@4645L348,136@5010L367:MallTag.kt#tloqc2");
                        ImmutableImageRequest build2 = new ImageRequest(imageUrl == null ? RoomRecommendViewModel.EMPTY_CURSOR : imageUrl).build();
                        Modifier modifier5 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(4), 0.0f, 11, (Object) null);
                        Integer backImgWidth2 = tag.getBackImgWidth();
                        if (backImgWidth2 != null) {
                            int $this$dp$iv7 = backImgWidth2.intValue();
                            f7 = Dp.constructor-impl($this$dp$iv7);
                        } else {
                            f7 = Dp.constructor-impl(12);
                        }
                        Modifier modifier6 = SizeKt.width-3ABfNKs(modifier5, f7);
                        Integer backImgHeight2 = tag.getBackImgHeight();
                        if (backImgHeight2 != null) {
                            int $this$dp$iv8 = backImgHeight2.intValue();
                            f8 = Dp.constructor-impl($this$dp$iv8);
                        } else {
                            f8 = Dp.constructor-impl(12);
                        }
                        BiliImageKt.BiliImage(build2, SizeKt.height-3ABfNKs(modifier6, f8), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer2, 0, 508);
                        String title3 = tag.getTitle();
                        TextKt.Text-Nvy7gAk(title3 == null ? RoomRecommendViewModel.EMPTY_CURSOR : title3, (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.Companion.getW400(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(12), 0, false, 1, 0, (Function1) null, new TextStyle(titleColor, 0.0f, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 33554430, (DefaultConstructorMarker) null), $composer2, 1597440, 24624, 112558);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    } else {
                        $composer2 = $composer5;
                    }
                    $composer2.startReplaceGroup(1889474300);
                    $composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            }
            $composer6.startReplaceGroup(1890657787);
            ComposerKt.sourceInformation($composer6, "30@1200L169");
            Brush buildColor = buildColor(tag.getBackDayColor1(), tag.getBackDayColor2(), tag.getBackNightColor1(), tag.getBackNightColor2(), $composer6, 0);
            $composer6.endReplaceGroup();
            backColor = buildColor;
            if (tag == null && (useBoard2 = tag.getUseBoard()) != null && useBoard2.intValue() == 1) {
            }
            Brush boardColor32 = brush;
            Brush titleColor2 = buildColor(tag == null ? tag.getTitleDayColor1() : null, tag == null ? tag.getTitleDayColor2() : null, tag == null ? tag.getTitleNightColor1() : null, tag == null ? tag.getTitleNightColor2() : null, $composer6, 0);
            if (!(tag == null && (useBoard = tag.getUseBoard()) != null && useBoard.intValue() == 1)) {
            }
            if (tag == null) {
            }
            String str32 = RoomRecommendViewModel.EMPTY_CURSOR;
            if (z) {
            }
            String imageUrl2 = str2;
            if (tag == null) {
            }
            if (tagType != null) {
            }
            if (tagType != null) {
            }
            if (tagType != null) {
            }
            if (tagType != null) {
            }
            $composer2.startReplaceGroup(1889474300);
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer6;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.component.business.view.MallTagKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit MallTag$lambda$1;
                    MallTag$lambda$1 = MallTagKt.MallTag$lambda$1(TagInfo.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return MallTag$lambda$1;
                }
            });
        }
    }

    public static final Brush buildColor(String dayColor1, String dayColor2, String nightColor1, String nightColor2, Composer $composer, int $changed) {
        Brush brush;
        ComposerKt.sourceInformationMarkerStart($composer, -424915895, "C(buildColor)N(dayColor1,dayColor2,nightColor1,nightColor2)158@5558L13:MallTag.kt#tloqc2");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-424915895, $changed, -1, "kntr.app.mall.mallDynamicPage.component.business.view.buildColor (MallTag.kt:158)");
        }
        if (BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night) {
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