package kntr.app.tribee.search.cards;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.dynamic.v2.KLinkUrl;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchTips;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.lib.brouter.uri.Uri;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Router;
import kntr.common.router.RouterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSearchResultTipsCard.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"TribeeSearchResultTipsCard", "", "card", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSearchTips;", "modifier", "Landroidx/compose/ui/Modifier;", "reportAction", "Lkotlin/Function0;", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSearchTips;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "search_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSearchResultTipsCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchResultTipsCard$lambda$3(KTribeeSearchTips kTribeeSearchTips, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        TribeeSearchResultTipsCard(kTribeeSearchTips, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x013c, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02b7, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L62;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v13 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeSearchResultTipsCard(final KTribeeSearchTips card, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Function0 reportAction;
        Modifier modifier3;
        Modifier modifier4;
        Modifier modifier5;
        Function0 factory$iv$iv;
        Function0 reportAction2;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(card, "card");
        Composer $composer2 = $composer.startRestartGroup(533193073);
        ComposerKt.sourceInformation($composer2, "C(TribeeSearchResultTipsCard)N(card,modifier,reportAction)26@987L2,29@1049L7,30@1080L22,31@1133L9,71@2414L2468,33@1152L3730:TribeeSearchResultTipsCard.kt#jdzap2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(card) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            reportAction = function0;
        } else if (($changed & 384) == 0) {
            reportAction = function0;
            $dirty |= $composer2.changedInstance(reportAction) ? 256 : 128;
        } else {
            reportAction = function0;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1297438995, "CC(remember):TribeeSearchResultTipsCard.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.search.cards.TribeeSearchResultTipsCardKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 reportAction3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                reportAction = reportAction3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(533193073, $dirty2, -1, "kntr.app.tribee.search.cards.TribeeSearchResultTipsCard (TribeeSearchResultTipsCard.kt:27)");
            }
            final KLinkUrl link = card.getLink();
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Router router = (Router) consume;
            TextMeasurer textMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer2, 0, 1);
            TextStyle textStyle = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12();
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(modifier4, Dp.constructor-impl(12), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(8), 0.0f, Dp.constructor-impl(4), 5, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1297487125, "CC(remember):TribeeSearchResultTipsCard.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(textMeasurer) | $composer2.changedInstance(card) | $composer2.changed(textStyle);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
                modifier5 = modifier4;
            } else {
                modifier5 = modifier4;
            }
            Object value$iv2 = (MeasurePolicy) new TribeeSearchResultTipsCardKt$TribeeSearchResultTipsCard$2$1(textMeasurer, card, textStyle);
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv = ((0 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv = factory$iv$iv2;
                $composer2.createNode(factory$iv$iv);
            } else {
                factory$iv$iv = factory$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv, Integer.valueOf(compositeKeyHash$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -773986919, "C43@1465L6,40@1356L136:TribeeSearchResultTipsCard.kt#jdzap2");
            TextKt.Text-Nvy7gAk(card.getTips(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, textStyle, $composer2, 0, 0, 131066);
            if (link == null) {
                $composer2.startReplaceGroup(-773799526);
                $composer2.endReplaceGroup();
                reportAction2 = reportAction;
            } else {
                $composer2.startReplaceGroup(-773799525);
                ComposerKt.sourceInformation($composer2, "*51@1720L135,48@1573L809");
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                Modifier modifier6 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer2, 1003484230, "CC(remember):TribeeSearchResultTipsCard.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changedInstance(router) | $composer2.changedInstance(link) | (($dirty2 & 896) == 256);
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv3 = new Function0() { // from class: kntr.app.tribee.search.cards.TribeeSearchResultTipsCardKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit TribeeSearchResultTipsCard$lambda$2$0$0$0;
                        TribeeSearchResultTipsCard$lambda$2$0$0$0 = TribeeSearchResultTipsCardKt.TribeeSearchResultTipsCard$lambda$2$0$0$0(Router.this, link, reportAction);
                        return TribeeSearchResultTipsCard$lambda$2$0$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null);
                reportAction2 = reportAction;
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv2 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv2 << 6) & 896) | 6;
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
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i6 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -2111393619, "C59@2032L6,56@1897L174,63@2146L28,65@2268L6,62@2093L271:TribeeSearchResultTipsCard.kt#jdzap2");
                TextKt.Text-Nvy7gAk(link.getShowWord(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_link-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, textStyle, $composer2, 0, 0, 131066);
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer2, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_link-0d7_KjU(), $composer2, Painter.$stable | 432, 0);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Unit unit = Unit.INSTANCE;
                $composer2.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            reportAction = reportAction2;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final Function0 function02 = reportAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.search.cards.TribeeSearchResultTipsCardKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSearchResultTipsCard$lambda$3;
                    TribeeSearchResultTipsCard$lambda$3 = TribeeSearchResultTipsCardKt.TribeeSearchResultTipsCard$lambda$3(card, modifier7, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSearchResultTipsCard$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchResultTipsCard$lambda$2$0$0$0(Router $router, KLinkUrl $it, Function0 $reportAction) {
        $router.launch(Uri.Companion.parse($it.getJumpUrl()));
        $reportAction.invoke();
        return Unit.INSTANCE;
    }
}