package kntr.app.appwidget.guide.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.common.Res;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.appwidget.guide.generated.resources.Res;
import srcs.app.appwidget.guide.generated.resources.String0_commonMainKt;

/* compiled from: GuideContentV1.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"GuideContentV1", RoomRecommendViewModel.EMPTY_CURSOR, "guideData", "Lkntr/app/appwidget/guide/ui/PopupData;", "windowWidth", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/appwidget/guide/ui/PopupData;Ljava/lang/Integer;Landroidx/compose/runtime/Composer;II)V", "guide_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GuideContentV1Kt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GuideContentV1$lambda$2(PopupData popupData, Integer num, int i, int i2, Composer composer, int i3) {
        GuideContentV1(popupData, num, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x009e, code lost:
        if (r7 == null) goto L118;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0736  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x073c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0918  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0924  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x092a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0a30  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0582  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x072a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void GuideContentV1(final PopupData guideData, Integer windowWidth, Composer $composer, final int $changed, final int i) {
        final Integer windowWidth2;
        Integer windowWidth3;
        Modifier modifier;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        String str;
        String str2;
        boolean invalid$iv;
        Object it$iv;
        Function0 factory$iv$iv$iv4;
        boolean invalid$iv2;
        Object it$iv2;
        Function0 factory$iv$iv$iv5;
        Intrinsics.checkNotNullParameter(guideData, "guideData");
        Composer $composer2 = $composer.startRestartGroup(845418638);
        ComposerKt.sourceInformation($composer2, "C(GuideContentV1)N(guideData,windowWidth)54@2077L6,55@2153L6,57@2255L6,45@1714L3806:GuideContentV1.kt#88uxtj");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(guideData) : $composer2.changedInstance(guideData) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            windowWidth2 = windowWidth;
        } else if (($changed & 48) == 0) {
            windowWidth2 = windowWidth;
            $dirty |= $composer2.changed(windowWidth2) ? 32 : 16;
        } else {
            windowWidth2 = windowWidth;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (i2 != 0) {
                windowWidth3 = null;
            } else {
                windowWidth3 = windowWidth2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(845418638, $dirty, -1, "kntr.app.appwidget.guide.ui.GuideContentV1 (GuideContentV1.kt:44)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            if (windowWidth3 != null) {
                modifier = SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(windowWidth3.intValue()));
            }
            modifier = Modifier.Companion;
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(ShadowKt.shadow-s4CzXII$default(PaddingKt.padding-VpY3zN4$default(fillMaxWidth$default.then(modifier), Dp.constructor-impl(12), 0.0f, 2, (Object) null), Dp.constructor-impl(8), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)), false, Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getShadow-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getShadow-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 4, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)));
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Integer windowWidth4 = windowWidth3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -959037044, "C61@2363L3151:GuideContentV1.kt#88uxtj");
            Modifier modifier$iv2 = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((390 >> 6) & 112) | 6;
            RowScope $this$GuideContentV1_u24lambda_u241_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 766088396, "C68@2573L1285,107@4221L6,109@4338L28,99@3872L877,125@4968L6,127@5086L29,120@4763L741:GuideContentV1.kt#88uxtj");
            Modifier modifier$iv3 = RowScope.-CC.weight$default($this$GuideContentV1_u24lambda_u241_u240, SizeKt.heightIn-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(12), 0.0f, 11, (Object) null), Dp.constructor-impl(39), 0.0f, 2, (Object) null), 1.0f, false, 2, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv3 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer2.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i8 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1661056032, "C78@3010L6,79@3062L9,76@2863L476,90@3580L6,91@3632L9,86@3356L488:GuideContentV1.kt#88uxtj");
            $composer2.startReplaceGroup(-1608984888);
            ComposerKt.sourceInformation($composer2, "*77@2922L46");
            String title = guideData.getTitle();
            if (title.length() == 0) {
                title = StringResourcesKt.stringResource(String0_commonMainKt.getUp_card_guide_title(Res.string.INSTANCE), $composer2, 0);
            }
            $composer2.endReplaceGroup();
            long j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU();
            TextStyle t14b = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14b();
            int i9 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
            TextKt.Text-Nvy7gAk(title, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(2), 7, (Object) null), j2, (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(20), i9, false, 1, 0, (Function1) null, t14b, $composer2, 1572912, 25008, 108472);
            String it = guideData.getSubtitle();
            if (it != null) {
                if (it.length() > 0) {
                    str = it;
                    if (str != null) {
                        $composer2.startReplaceGroup(-1608966369);
                        ComposerKt.sourceInformation($composer2, "89@3491L49");
                        String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getUp_card_guide_subtitle(Res.string.INSTANCE), $composer2, 0);
                        $composer2.endReplaceGroup();
                        str2 = stringResource;
                    } else {
                        $composer2.startReplaceGroup(-1608968787);
                        $composer2.endReplaceGroup();
                        str2 = str;
                    }
                    long j3 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU();
                    TextStyle t12 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12();
                    TextKt.Text-Nvy7gAk(str2, (Modifier) null, j3, (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(17), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, t12, $composer2, 1572864, 25008, 108474);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifier2 = BorderKt.border-xT4_qwU(ClipKt.clip(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(8), 0.0f, 11, (Object) null), Dp.constructor-impl(56), Dp.constructor-impl(24)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_bold-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)));
                    ComposerKt.sourceInformationMarkerStart($composer2, -1914896544, "CC(remember):GuideContentV1.kt#9igjgp");
                    invalid$iv = ($dirty & 14) != 4 || (($dirty & 8) != 0 && $composer2.changedInstance(guideData));
                    it$iv = $composer2.rememberedValue();
                    if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.app.appwidget.guide.ui.GuideContentV1Kt$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                Unit GuideContentV1$lambda$1$0$1$0;
                                GuideContentV1$lambda$1$0$1$0 = GuideContentV1Kt.GuideContentV1$lambda$1$0$1$0(PopupData.this);
                                return GuideContentV1$lambda$1$0$1$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifier$iv4 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(6), Dp.constructor-impl(3));
                    Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv4 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv4 = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer2, modifier$iv4);
                    Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if (!$composer2.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv9;
                        $composer2.createNode(factory$iv$iv$iv4);
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv9;
                        $composer2.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer2);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                    int i10 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    int i11 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1642273104, "C114@4555L56,115@4651L6,116@4703L9,113@4522L213:GuideContentV1.kt#88uxtj");
                    TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_46(Res.string.INSTANCE), $composer2, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), $composer2, 0, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifier3 = BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(56), Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)));
                    ComposerKt.sourceInformationMarkerStart($composer2, -1914872607, "CC(remember):GuideContentV1.kt#9igjgp");
                    invalid$iv2 = ($dirty & 14) != 4 || (($dirty & 8) != 0 && $composer2.changedInstance(guideData));
                    it$iv2 = $composer2.rememberedValue();
                    if (!invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function0() { // from class: kntr.app.appwidget.guide.ui.GuideContentV1Kt$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                Unit GuideContentV1$lambda$1$0$3$0;
                                GuideContentV1$lambda$1$0$3$0 = GuideContentV1Kt.GuideContentV1$lambda$1$0$3$0(PopupData.this);
                                return GuideContentV1$lambda$1$0$3$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifier$iv5 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifier3, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), Dp.constructor-impl(6), Dp.constructor-impl(3));
                    Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                    int $changed$iv$iv5 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv5 = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer2, modifier$iv5);
                    Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                    int $i$f$Box = $changed$iv$iv5 << 6;
                    int $changed$iv$iv$iv5 = ($i$f$Box & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if (!$composer2.getInserting()) {
                        factory$iv$iv$iv5 = factory$iv$iv$iv10;
                        $composer2.createNode(factory$iv$iv$iv5);
                    } else {
                        factory$iv$iv$iv5 = factory$iv$iv$iv10;
                        $composer2.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer2);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                    int i12 = ($changed$iv$iv$iv5 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                    int i13 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1834579743, "C132@5304L57,133@5401L6,134@5458L9,131@5271L219:GuideContentV1.kt#88uxtj");
                    TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_124(Res.string.INSTANCE), $composer2, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), $composer2, 0, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowWidth2 = windowWidth4;
                }
            }
            str = null;
            if (str != null) {
            }
            long j32 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU();
            TextStyle t122 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12();
            TextKt.Text-Nvy7gAk(str2, (Modifier) null, j32, (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(17), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, t122, $composer2, 1572864, 25008, 108474);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier22 = BorderKt.border-xT4_qwU(ClipKt.clip(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(8), 0.0f, 11, (Object) null), Dp.constructor-impl(56), Dp.constructor-impl(24)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_bold-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)));
            ComposerKt.sourceInformationMarkerStart($composer2, -1914896544, "CC(remember):GuideContentV1.kt#9igjgp");
            if (($dirty & 14) != 4) {
            }
            it$iv = $composer2.rememberedValue();
            if (!invalid$iv) {
            }
            Object value$iv3 = new Function0() { // from class: kntr.app.appwidget.guide.ui.GuideContentV1Kt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit GuideContentV1$lambda$1$0$1$0;
                    GuideContentV1$lambda$1$0$1$0 = GuideContentV1Kt.GuideContentV1$lambda$1$0$1$0(PopupData.this);
                    return GuideContentV1$lambda$1$0$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv3);
            it$iv = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv42 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifier22, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(6), Dp.constructor-impl(3));
            Alignment contentAlignment$iv22 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv42 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22, false);
            int $changed$iv$iv42 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv42 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv42 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv42 = ComposedModifierKt.materializeModifier($composer2, modifier$iv42);
            Function0 factory$iv$iv$iv92 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv42 = (($changed$iv$iv42 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
            }
            $composer2.startReusableNode();
            if (!$composer2.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv42 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, measurePolicy$iv42, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, localMap$iv$iv42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv42, Integer.valueOf(compositeKeyHash$iv$iv42), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv42, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, materialized$iv$iv42, ComposeUiNode.Companion.getSetModifier());
            int i102 = ($changed$iv$iv$iv42 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
            int i112 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1642273104, "C114@4555L56,115@4651L6,116@4703L9,113@4522L213:GuideContentV1.kt#88uxtj");
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_46(Res.string.INSTANCE), $composer2, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), $composer2, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier32 = BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(56), Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)));
            ComposerKt.sourceInformationMarkerStart($composer2, -1914872607, "CC(remember):GuideContentV1.kt#9igjgp");
            invalid$iv2 = ($dirty & 14) != 4 || (($dirty & 8) != 0 && $composer2.changedInstance(guideData));
            it$iv2 = $composer2.rememberedValue();
            if (!invalid$iv2) {
            }
            Object value$iv22 = new Function0() { // from class: kntr.app.appwidget.guide.ui.GuideContentV1Kt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit GuideContentV1$lambda$1$0$3$0;
                    GuideContentV1$lambda$1$0$3$0 = GuideContentV1Kt.GuideContentV1$lambda$1$0$3$0(PopupData.this);
                    return GuideContentV1$lambda$1$0$3$0;
                }
            };
            $composer2.updateRememberedValue(value$iv22);
            it$iv2 = value$iv22;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv52 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifier32, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), Dp.constructor-impl(6), Dp.constructor-impl(3));
            Alignment contentAlignment$iv32 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv52 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv32, false);
            int $changed$iv$iv52 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv52 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv52 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv52 = ComposedModifierKt.materializeModifier($composer2, modifier$iv52);
            Function0 factory$iv$iv$iv102 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Box2 = $changed$iv$iv52 << 6;
            int $changed$iv$iv$iv52 = ($i$f$Box2 & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
            }
            $composer2.startReusableNode();
            if (!$composer2.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv52 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, measurePolicy$iv52, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, localMap$iv$iv52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv52, Integer.valueOf(compositeKeyHash$iv$iv52), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv52, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, materialized$iv$iv52, ComposeUiNode.Companion.getSetModifier());
            int i122 = ($changed$iv$iv$iv52 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope32 = BoxScopeInstance.INSTANCE;
            int i132 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1834579743, "C132@5304L57,133@5401L6,134@5458L9,131@5271L219:GuideContentV1.kt#88uxtj");
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_124(Res.string.INSTANCE), $composer2, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), $composer2, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
            }
            windowWidth2 = windowWidth4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.appwidget.guide.ui.GuideContentV1Kt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit GuideContentV1$lambda$2;
                    GuideContentV1$lambda$2 = GuideContentV1Kt.GuideContentV1$lambda$2(PopupData.this, windowWidth2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GuideContentV1$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GuideContentV1$lambda$1$0$1$0(PopupData $guideData) {
        $guideData.dismiss(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GuideContentV1$lambda$1$0$3$0(PopupData $guideData) {
        $guideData.performAction();
        return Unit.INSTANCE;
    }
}