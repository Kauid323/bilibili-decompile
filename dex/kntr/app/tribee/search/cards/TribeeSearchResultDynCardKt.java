package kntr.app.tribee.search.cards;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
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
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.foundation.text.InlineTextContentKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bapis.bilibili.app.dynamic.v2.KColor;
import com.bapis.bilibili.app.dynamic.v2.KDynReplyIcon;
import com.bapis.bilibili.app.dynamic.v2.KLightDarkIcon;
import com.bapis.bilibili.app.dynamic.v2.KTitleCategoryText;
import com.bapis.bilibili.app.dynamic.v2.KTitleTagPic;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDyn;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchDyn;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.lib.brouter.uri.Builder;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.tribee.search.track.SearchTrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.base.imageloader.ImageRequest;
import kntr.base.router.Router;
import kntr.common.router.RouterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.FontResources_androidKt;
import srcs.common.compose.res.generated.resources.Font0_commonMainKt;
import srcs.common.compose.res.generated.resources.Res;

/* compiled from: TribeeSearchResultDynCard.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\f\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u000b\u001a\u0014\u0010\f\u001a\u00020\u000b*\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u000b*\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u000b*\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u001b\u0010\u0013\u001a\u00020\u0001*\u00020\u00122\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0014\u001a$\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¨\u0006\u001b"}, d2 = {"TribeeSearchResultDynCard", "", "card", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSearchDyn;", "modifier", "Landroidx/compose/ui/Modifier;", "reportAction", "Lkotlin/Function0;", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSearchDyn;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "toUriOrNull", "Lcom/bilibili/lib/brouter/uri/Uri;", "", "getColor", "Lcom/bapis/bilibili/app/dynamic/v2/KColor;", "themeDayNight", "Lcom/bilibili/compose/theme/ThemeDayNight;", "getUrl", "Lcom/bapis/bilibili/app/dynamic/v2/KLightDarkIcon;", "Lcom/bapis/bilibili/app/dynamic/v2/KTitleTagPic;", "Placeholder", "(Lcom/bapis/bilibili/app/dynamic/v2/KTitleTagPic;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "parseHtmlTitle", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "title", "normalStyle", "Landroidx/compose/ui/text/SpanStyle;", "emStyle", "search_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSearchResultDynCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Placeholder$lambda$3(KTitleTagPic kTitleTagPic, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Placeholder(kTitleTagPic, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchResultDynCard$lambda$1(KTribeeSearchDyn kTribeeSearchDyn, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        TribeeSearchResultDynCard(kTribeeSearchDyn, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchResultDynCard$lambda$3(KTribeeSearchDyn kTribeeSearchDyn, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        TribeeSearchResultDynCard(kTribeeSearchDyn, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x02e0, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x066b  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x06da  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x06ef  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0820  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x082c  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0832  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x08d1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0945  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0a59 A[LOOP:2: B:168:0x0a53->B:170:0x0a59, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0a96  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0cee  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0cfa  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0d00  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0d90  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0e1f  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0f1f  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0f2b  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0f31  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0fb5  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x1074  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x10a4  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x1125  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x11c9  */
    /* JADX WARN: Type inference failed for: r14v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeSearchResultDynCard(final KTribeeSearchDyn card, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function02;
        Composer $composer$iv$iv$iv;
        Modifier modifier$iv$iv;
        Function0 reportAction;
        final Function0 reportAction2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        String str;
        Composer $composer$iv;
        String str2;
        final ThemeDayNight theme;
        Color color;
        long color2;
        String $this$asRequest$iv;
        Object it$iv;
        Composer $composer$iv$iv$iv2;
        Function0 factory$iv$iv$iv4;
        Composer $composer$iv2;
        Iterator it;
        Function0 factory$iv$iv$iv5;
        RowScope $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u243;
        String leftText;
        Composer $composer2;
        Function0 factory$iv$iv$iv6;
        Composer $composer$iv3;
        long j;
        KLightDarkIcon icon;
        Intrinsics.checkNotNullParameter(card, "card");
        Composer $composer3 = $composer.startRestartGroup(424659328);
        ComposerKt.sourceInformation($composer3, "C(TribeeSearchResultDynCard)N(card,modifier,reportAction)61@2738L2,63@2781L7,64@2820L7,65@2857L7,69@2934L10776:TribeeSearchResultDynCard.kt#jdzap2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(card) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function02 = function0;
        } else if (($changed & 384) == 0) {
            function02 = function0;
            $dirty |= $composer3.changedInstance(function02) ? 256 : 128;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 75725090, "CC(remember):TribeeSearchResultDynCard.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.search.cards.TribeeSearchResultDynCardKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv2 = value$iv;
                }
                Function0 reportAction3 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                reportAction2 = reportAction3;
            } else {
                reportAction2 = function02;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(424659328, $dirty2, -1, "kntr.app.tribee.search.cards.TribeeSearchResultDynCard (TribeeSearchResultDynCard.kt:62)");
            }
            CompositionLocal this_$iv = BiliThemeKt.getLocalDayNightTheme();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ThemeDayNight theme2 = (ThemeDayNight) consume;
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density = (Density) consume2;
            CompositionLocal this_$iv3 = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(this_$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Router router = (Router) consume3;
            String title = card.getRawTitle();
            final KTribeeDyn post = card.getDyn();
            if (post == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    final Function0 function03 = reportAction2;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.search.cards.TribeeSearchResultDynCardKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TribeeSearchResultDynCard$lambda$1;
                            TribeeSearchResultDynCard$lambda$1 = TribeeSearchResultDynCardKt.TribeeSearchResultDynCard$lambda$1(card, modifier4, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return TribeeSearchResultDynCard$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            modifier$iv$iv = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Density density2 = density;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 2086010320, "C74@3118L6,76@3206L39,78@3312L375,70@2987L10717:TribeeSearchResultDynCard.kt#jdzap2");
            Modifier modifier5 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -348355011, "CC(remember):TribeeSearchResultDynCard.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv2);
                it$iv3 = value$iv2;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -348351283, "CC(remember):TribeeSearchResultDynCard.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(post) | $composer3.changedInstance(router) | (($dirty2 & 896) == 256);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv3 = new Function0() { // from class: kntr.app.tribee.search.cards.TribeeSearchResultDynCardKt$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit TribeeSearchResultDynCard$lambda$2$1$0;
                    TribeeSearchResultDynCard$lambda$2$1$0 = TribeeSearchResultDynCardKt.TribeeSearchResultDynCard$lambda$2$1$0(post, router, reportAction2);
                    return TribeeSearchResultDynCard$lambda$2$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            it$iv4 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = ClickableKt.clickable-O2vRcR0$default(modifier5, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv4, 28, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            reportAction = reportAction2;
            $composer$iv$iv$iv = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i7 = ((0 >> 6) & 112) | 6;
            RowScope $this$TribeeSearchResultDynCard_u24lambda_u242_u242 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 65921868, "C88@3713L1589,126@5316L8378:TribeeSearchResultDynCard.kt#jdzap2");
            Modifier modifier$iv3 = $this$TribeeSearchResultDynCard_u24lambda_u242_u242.align(SizeKt.width-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(10), 0.0f, 10, (Object) null), Dp.constructor-impl(26)), Alignment.Companion.getCenterVertically());
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv3 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i9 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 756107017, "C104@4455L356,114@4846L29,115@4915L35,121@5206L6,116@4967L321:TribeeSearchResultDynCard.kt#jdzap2");
            KDynReplyIcon replyIcon = post.getReplyIcon();
            if (replyIcon != null) {
                KColor color3 = replyIcon.getColor();
                if (color3 != null) {
                    theme = theme2;
                    String it2 = getColor(color3, theme);
                    if (it2 != null) {
                        String str3 = it2;
                        $composer$iv = $composer3;
                        if (!(StringsKt.startsWith$default(it2, "#", false, 2, (Object) null) && (it2.length() == 7 || it2.length() == 9))) {
                            str3 = null;
                        }
                        if (str3 != null) {
                            color = Color.box-impl(ComposeColorParserKt.parseColor(str3));
                            long it3 = color.unbox-impl();
                            str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                            str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                            if (Color.equals-impl0(it3, Color.Companion.getTransparent-0d7_KjU())) {
                                color = null;
                            }
                            if (color != null) {
                                $composer3.startReplaceGroup(1271326197);
                                ComposerKt.sourceInformation($composer3, "103@4426L6");
                                long j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText4-0d7_KjU();
                                $composer3.endReplaceGroup();
                                color2 = j2;
                            } else {
                                $composer3.startReplaceGroup(1271316680);
                                $composer3.endReplaceGroup();
                                color2 = color.unbox-impl();
                            }
                            KDynReplyIcon replyIcon2 = post.getReplyIcon();
                            $this$asRequest$iv = (replyIcon2 != null || (icon = replyIcon2.getIcon()) == null) ? null : getUrl(icon, theme);
                            String str4 = "";
                            if ($this$asRequest$iv == null) {
                                $this$asRequest$iv = "";
                            }
                            ImageRequest $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u240_u242 = new ImageRequest($this$asRequest$iv);
                            $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u240_u242.colorFilter(ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, color2, 0, 2, (Object) null));
                            BiliImageKt.BiliImage($this$TribeeSearchResultDynCard_u24lambda_u242_u242_u240_u242.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18)), null, null, null, null, null, null, null, $composer3, 48, 508);
                            Font numberFont = FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_Regular(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14);
                            ComposerKt.sourceInformationMarkerStart($composer3, 1271341651, "CC(remember):TribeeSearchResultDynCard.kt#9igjgp");
                            it$iv = $composer3.rememberedValue();
                            if (it$iv != Composer.Companion.getEmpty()) {
                                Object value$iv4 = FontFamilyKt.FontFamily(new Font[]{numberFont});
                                $composer3.updateRememberedValue(value$iv4);
                                it$iv = value$iv4;
                            }
                            FontFamily numberFontFamily = (FontFamily) it$iv;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            KDynReplyIcon replyIcon3 = post.getReplyIcon();
                            TextKt.Text-Nvy7gAk((replyIcon3 != null || (r5 = replyIcon3.getStat()) == null) ? "0" : "0", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, numberFontFamily, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(12), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 12607536, 48, 259944);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Modifier modifier$iv4 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(10), 0.0f, 0.0f, 13, (Object) null);
                            Composer $composer$iv4 = $composer3;
                            ComposerKt.sourceInformationMarkerStart($composer$iv4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv3 = Alignment.Companion.getStart();
                            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer$iv4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                            int $changed$iv$iv4 = (6 << 3) & 112;
                            Composer $composer$iv$iv = $composer$iv4;
                            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv4;
                            String str5 = str;
                            ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1159599143, str5);
                            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv, 0));
                            CompositionLocalMap localMap$iv$iv4 = $composer$iv$iv.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv$iv, modifier$iv4);
                            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                            $composer$iv$iv$iv2 = $composer$iv$iv;
                            String str6 = str2;
                            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv2, -553112988, str6);
                            if (!($composer$iv$iv$iv2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer$iv$iv$iv2.startReusableNode();
                            if ($composer$iv$iv$iv2.getInserting()) {
                                factory$iv$iv$iv4 = factory$iv$iv$iv10;
                                $composer$iv$iv$iv2.useNode();
                            } else {
                                factory$iv$iv$iv4 = factory$iv$iv$iv10;
                                $composer$iv$iv$iv2.createNode(factory$iv$iv$iv4);
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv$iv$iv2);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                            int i10 = ($changed$iv$iv$iv4 >> 6) & 14;
                            $composer$iv2 = $composer$iv$iv$iv2;
                            ComposerKt.sourceInformationMarkerStart($composer$iv2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
                            int i11 = ((6 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv2, -925827454, "C181@8342L2358,229@10718L2747,287@13642L6,284@13483L197:TribeeSearchResultDynCard.kt#jdzap2");
                            List tagPics = post.getTitleTags();
                            List $this$mapIndexed$iv = tagPics;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                            Iterable $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
                            int index$iv$iv = 0;
                            for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
                                int index$iv$iv2 = index$iv$iv + 1;
                                if (index$iv$iv < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                KTitleTagPic kTitleTagPic = (KTitleTagPic) item$iv$iv;
                                Iterable $this$mapIndexedTo$iv$iv2 = $this$mapIndexedTo$iv$iv;
                                int index = index$iv$iv;
                                destination$iv$iv.add("pic_" + index);
                                index$iv$iv = index$iv$iv2;
                                $this$mapIndexed$iv = $this$mapIndexed$iv;
                                $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv2;
                            }
                            List tagPicIds = (List) destination$iv$iv;
                            $composer$iv2.startReplaceGroup(-1276788780);
                            ComposerKt.sourceInformation($composer$iv2, "");
                            Map inlineContentMap = new LinkedHashMap();
                            $composer$iv2.startReplaceGroup(-1276788566);
                            ComposerKt.sourceInformation($composer$iv2, "*142@6362L879");
                            List $this$forEachIndexed$iv = tagPics;
                            int index$iv = 0;
                            for (Object item$iv : $this$forEachIndexed$iv) {
                                int index$iv2 = index$iv + 1;
                                if (index$iv < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                List tagPics2 = tagPics;
                                final KTitleTagPic pic = (KTitleTagPic) item$iv;
                                int index2 = index$iv;
                                MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                                Object obj = tagPicIds.get(index2);
                                Density $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u241_u240_u240 = density2;
                                Composer $composer$iv$iv2 = $composer$iv$iv;
                                Composer $composer$iv5 = $composer$iv4;
                                Density $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u241_u240_u241 = density2;
                                final Density density3 = density2;
                                inlineContentMap.put(obj, new InlineTextContent(new Placeholder($this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u241_u240_u240.toSp-kPz2Gy4(((float) pic.getWidth()) + $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u241_u240_u240.toPx-0680j_4(Dp.constructor-impl(4))), $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u241_u240_u241.toSp-kPz2Gy4((float) pic.getHeight()), PlaceholderVerticalAlign.Companion.getTextCenter-J6kI3mc(), (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(1413656526, true, new Function3() { // from class: kntr.app.tribee.search.cards.TribeeSearchResultDynCardKt$$ExternalSyntheticLambda6
                                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                        Unit TribeeSearchResultDynCard$lambda$2$2$1$1$0$2;
                                        TribeeSearchResultDynCard$lambda$2$2$1$1$0$2 = TribeeSearchResultDynCardKt.TribeeSearchResultDynCard$lambda$2$2$1$1$0$2(pic, theme, density3, (String) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                        return TribeeSearchResultDynCard$lambda$2$2$1$1$0$2;
                                    }
                                }, $composer$iv2, 54)));
                                density2 = density3;
                                index$iv = index$iv2;
                                $this$forEachIndexed$iv = $this$forEachIndexed$iv;
                                tagPics = tagPics2;
                                measurePolicy$iv$iv = measurePolicy$iv$iv2;
                                $composer$iv$iv = $composer$iv$iv2;
                                $composer$iv4 = $composer$iv5;
                                $composer$iv$iv$iv2 = $composer$iv$iv$iv2;
                                $composer$iv2 = $composer$iv2;
                            }
                            Composer $composer$iv6 = $composer$iv4;
                            Composer $composer$iv7 = $composer$iv2;
                            Composer $composer$iv$iv$iv3 = $composer$iv$iv$iv2;
                            Composer $composer$iv$iv3 = $composer$iv$iv;
                            Density density4 = density2;
                            $composer$iv2.endReplaceGroup();
                            inlineContentMap.put("divider", new InlineTextContent(new Placeholder(density4.toSp-0xMU5do(Dp.constructor-impl(9)), density4.toSp-0xMU5do(Dp.constructor-impl(14)), PlaceholderVerticalAlign.Companion.getCenter-J6kI3mc(), (DefaultConstructorMarker) null), ComposableSingletons$TribeeSearchResultDynCardKt.INSTANCE.getLambda$394584424$search_debug()));
                            $composer$iv2.endReplaceGroup();
                            $composer$iv2.startReplaceGroup(-1276701590);
                            ComposerKt.sourceInformation($composer$iv2, "*213@10009L6,219@10337L6");
                            boolean z = false;
                            AnnotatedString.Builder $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u242 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                            boolean z2 = false;
                            for (Object element$iv : tagPicIds) {
                                boolean z3 = z;
                                String it4 = (String) element$iv;
                                InlineTextContentKt.appendInlineContent$default($this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u242, it4, (String) null, 2, (Object) null);
                                z = z3;
                                z2 = z2;
                                tagPicIds = tagPicIds;
                            }
                            $composer$iv2.startReplaceGroup(-1276696223);
                            ComposerKt.sourceInformation($composer$iv2, "");
                            Iterable $this$forEach$iv = post.getCategories();
                            boolean z4 = false;
                            it = $this$forEach$iv.iterator();
                            while (it.hasNext()) {
                                Object element$iv2 = it.next();
                                KTitleCategoryText tagText = (KTitleCategoryText) element$iv2;
                                FontWeight bold = FontWeight.Companion.getBold();
                                long sp = TextUnitKt.getSp(16);
                                Iterable $this$forEach$iv2 = $this$forEach$iv;
                                Color color4 = Color.box-impl(ComposeColorParserKt.parseColor(getColor(tagText.getFontColor(), theme)));
                                String str7 = str4;
                                boolean z5 = z4;
                                long it5 = color4.unbox-impl();
                                Iterator it6 = it;
                                if (Color.equals-impl0(it5, Color.Companion.getTransparent-0d7_KjU())) {
                                    color4 = null;
                                }
                                if (color4 == null) {
                                    $composer$iv2.startReplaceGroup(1506404613);
                                    ComposerKt.sourceInformation($composer$iv2, "198@9305L6");
                                    long j3 = BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getGa7-0d7_KjU();
                                    $composer$iv2.endReplaceGroup();
                                    j = j3;
                                } else {
                                    $composer$iv2.startReplaceGroup(1506394786);
                                    $composer$iv2.endReplaceGroup();
                                    j = color4.unbox-impl();
                                }
                                SpanStyle style$iv = new SpanStyle(j, sp, bold, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65528, (DefaultConstructorMarker) null);
                                int index$iv3 = $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u242.pushStyle(style$iv);
                                try {
                                    $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u242.append(tagText.getName());
                                } catch (Throwable th) {
                                    th = th;
                                }
                                try {
                                    InlineTextContentKt.appendInlineContent$default($this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u242, "divider", (String) null, 2, (Object) null);
                                    Unit unit = Unit.INSTANCE;
                                    $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u242.pop(index$iv3);
                                    $this$forEach$iv = $this$forEach$iv2;
                                    z4 = z5;
                                    it = it6;
                                    str4 = str7;
                                } catch (Throwable th2) {
                                    th = th2;
                                    $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u242.pop(index$iv3);
                                    throw th;
                                }
                            }
                            String str8 = str4;
                            $composer$iv2.endReplaceGroup();
                            parseHtmlTitle($this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u242, title, new SpanStyle(BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getText1-0d7_KjU(), TextUnitKt.getSp(16), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65528, (DefaultConstructorMarker) null), new SpanStyle(BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), TextUnitKt.getSp(16), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65528, (DefaultConstructorMarker) null));
                            AnnotatedString annotatedString = $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u242.toAnnotatedString();
                            $composer$iv2.endReplaceGroup();
                            TextKt.Text-Z58ophY(annotatedString, PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(6), Dp.constructor-impl(12), 0.0f, 9, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, inlineContentMap, (Function1) null, (TextStyle) null, $composer$iv2, 48, 24960, 438268);
                            Modifier modifier$iv5 = PaddingKt.padding-qDBjuR0$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(29)), 0.0f, Dp.constructor-impl(6), Dp.constructor-impl(10), 0.0f, 9, (Object) null);
                            ComposerKt.sourceInformationMarkerStart($composer$iv2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                            MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer$iv2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                            int $changed$iv$iv5 = (6 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str5);
                            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                            CompositionLocalMap localMap$iv$iv5 = $composer$iv2.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv5);
                            Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str6);
                            if (!($composer$iv2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer$iv2.startReusableNode();
                            if ($composer$iv2.getInserting()) {
                                factory$iv$iv$iv5 = factory$iv$iv$iv11;
                                $composer$iv2.useNode();
                            } else {
                                factory$iv$iv$iv5 = factory$iv$iv$iv11;
                                $composer$iv2.createNode(factory$iv$iv$iv5);
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv2);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                            int i12 = ($changed$iv$iv$iv5 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            int i13 = ((6 >> 6) & 112) | 6;
                            $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u243 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1954499779, "C:TribeeSearchResultDynCard.kt#jdzap2");
                            leftText = post.getLeftText();
                            if (leftText != null || StringsKt.isBlank(leftText)) {
                                $composer$iv2.startReplaceGroup(1954499964);
                                ComposerKt.sourceInformation($composer$iv2, "235@11041L6,233@10933L443");
                                String leftText2 = post.getLeftText();
                                TextKt.Text-Nvy7gAk(leftText2 == null ? str8 : leftText2, $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u243.alignByBaseline(PaddingKt.padding-qDBjuR0$default(RowScope.-CC.weight$default($this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u243, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 0.0f, Dp.constructor-impl(6), 0.0f, 11, (Object) null)), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(17), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer$iv2, 24576, 25008, 239592);
                            } else {
                                $composer$iv2.startReplaceGroup(1943639703);
                            }
                            $composer$iv2.endReplaceGroup();
                            if (StringsKt.isBlank(post.getRightText()) || !StringsKt.isBlank(post.getViewStat())) {
                                $composer$iv2.startReplaceGroup(1955092715);
                                ComposerKt.sourceInformation($composer$iv2, "245@11509L1281");
                                Modifier modifier$iv6 = $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u243.alignByBaseline(PaddingKt.padding-qDBjuR0$default(RowScope.-CC.weight$default($this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u243, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(6), 0.0f, 0.0f, 0.0f, 14, (Object) null));
                                Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getEnd();
                                ComposerKt.sourceInformationMarkerStart($composer$iv2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getTop();
                                MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer$iv2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                                int $changed$iv$iv6 = (48 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str5);
                                int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                                CompositionLocalMap localMap$iv$iv6 = $composer$iv2.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv6);
                                Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                                int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                                $composer2 = $composer$iv2;
                                ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str6);
                                if (!($composer$iv2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer$iv2.startReusableNode();
                                if ($composer$iv2.getInserting()) {
                                    factory$iv$iv$iv6 = factory$iv$iv$iv12;
                                    $composer$iv2.useNode();
                                } else {
                                    factory$iv$iv$iv6 = factory$iv$iv$iv12;
                                    $composer$iv2.createNode(factory$iv$iv$iv6);
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer$iv2);
                                $composer$iv3 = $composer$iv2;
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                                int i14 = ($changed$iv$iv$iv6 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                int i15 = ((48 >> 6) & 112) | 6;
                                RowScope $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u243_u240 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1557495583, "C:TribeeSearchResultDynCard.kt#jdzap2");
                                if (StringsKt.isBlank(post.getViewStat())) {
                                    $composer$iv2.startReplaceGroup(-1557464832);
                                    ComposerKt.sourceInformation($composer$iv2, "251@11870L19,253@12047L6,250@11805L359,258@12315L6,256@12197L537");
                                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getEye_browse_line_900($composer$iv2, 6), "stat icon", $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u243_u240.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), Alignment.Companion.getCenterVertically()), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getText3-0d7_KjU(), $composer$iv2, Painter.$stable | 48, 0);
                                    TextKt.Text-Nvy7gAk(post.getViewStat(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getEnd-e0LSkKk()), TextUnitKt.getSp(17), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer$iv2, 24624, 25008, 238568);
                                } else {
                                    $composer$iv2.startReplaceGroup(-1569173439);
                                }
                                $composer$iv2.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                $composer$iv2.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                if (StringsKt.isBlank(post.getRightText())) {
                                    $composer$iv2.startReplaceGroup(1956432783);
                                    ComposerKt.sourceInformation($composer$iv2, "272@12990L6,270@12879L520");
                                    TextKt.Text-Nvy7gAk(post.getRightText(), $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u243.alignByBaseline(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, (Object) null)), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getEnd-e0LSkKk()), TextUnitKt.getSp(17), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer$iv2, 24576, 25008, 238568);
                                } else {
                                    $composer$iv2.startReplaceGroup(1943639703);
                                }
                                $composer$iv2.endReplaceGroup();
                                $composer$iv2.endReplaceGroup();
                            } else {
                                $composer$iv2.startReplaceGroup(1943639703);
                                $composer$iv2.endReplaceGroup();
                                $composer$iv3 = $composer$iv2;
                                $composer2 = $composer$iv2;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                            $composer$iv2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            Composer $composer4 = $composer2;
                            DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer4, 54, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv7);
                            $composer$iv$iv$iv3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                            str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                        }
                    } else {
                        str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        $composer$iv = $composer3;
                        str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    }
                } else {
                    str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    $composer$iv = $composer3;
                    str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    theme = theme2;
                }
            } else {
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $composer$iv = $composer3;
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                theme = theme2;
            }
            color = null;
            if (color != null) {
            }
            KDynReplyIcon replyIcon22 = post.getReplyIcon();
            if (replyIcon22 != null) {
            }
            String str42 = "";
            if ($this$asRequest$iv == null) {
            }
            ImageRequest $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u240_u2422 = new ImageRequest($this$asRequest$iv);
            $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u240_u2422.colorFilter(ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, color2, 0, 2, (Object) null));
            BiliImageKt.BiliImage($this$TribeeSearchResultDynCard_u24lambda_u242_u242_u240_u2422.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18)), null, null, null, null, null, null, null, $composer3, 48, 508);
            Font numberFont2 = FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_Regular(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14);
            ComposerKt.sourceInformationMarkerStart($composer3, 1271341651, "CC(remember):TribeeSearchResultDynCard.kt#9igjgp");
            it$iv = $composer3.rememberedValue();
            if (it$iv != Composer.Companion.getEmpty()) {
            }
            FontFamily numberFontFamily2 = (FontFamily) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            KDynReplyIcon replyIcon32 = post.getReplyIcon();
            TextKt.Text-Nvy7gAk((replyIcon32 != null || (r5 = replyIcon32.getStat()) == null) ? "0" : "0", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, numberFontFamily2, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(12), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 12607536, 48, 259944);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv42 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(10), 0.0f, 0.0f, 13, (Object) null);
            Composer $composer$iv42 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv42, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv32 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv32 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv42 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv32, horizontalAlignment$iv32, $composer$iv42, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv42 = (6 << 3) & 112;
            Composer $composer$iv$iv4 = $composer$iv42;
            MeasurePolicy measurePolicy$iv$iv3 = measurePolicy$iv42;
            String str52 = str;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv4, -1159599143, str52);
            int compositeKeyHash$iv$iv42 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv4, 0));
            CompositionLocalMap localMap$iv$iv42 = $composer$iv$iv4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv42 = ComposedModifierKt.materializeModifier($composer$iv$iv4, modifier$iv42);
            Function0 factory$iv$iv$iv102 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv42 = (($changed$iv$iv42 << 6) & 896) | 6;
            $composer$iv$iv$iv2 = $composer$iv$iv4;
            String str62 = str2;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv2, -553112988, str62);
            if (!($composer$iv$iv$iv2.getApplier() instanceof Applier)) {
            }
            $composer$iv$iv$iv2.startReusableNode();
            if ($composer$iv$iv$iv2.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv42 = Updater.constructor-impl($composer$iv$iv$iv2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, measurePolicy$iv$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, localMap$iv$iv42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv42, Integer.valueOf(compositeKeyHash$iv$iv42), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv42, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, materialized$iv$iv42, ComposeUiNode.Companion.getSetModifier());
            int i102 = ($changed$iv$iv$iv42 >> 6) & 14;
            $composer$iv2 = $composer$iv$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope32 = ColumnScopeInstance.INSTANCE;
            int i112 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -925827454, "C181@8342L2358,229@10718L2747,287@13642L6,284@13483L197:TribeeSearchResultDynCard.kt#jdzap2");
            List tagPics3 = post.getTitleTags();
            List $this$mapIndexed$iv2 = tagPics3;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
            Iterable $this$mapIndexedTo$iv$iv3 = $this$mapIndexed$iv2;
            int index$iv$iv3 = 0;
            while (r97.hasNext()) {
            }
            List tagPicIds2 = (List) destination$iv$iv2;
            $composer$iv2.startReplaceGroup(-1276788780);
            ComposerKt.sourceInformation($composer$iv2, "");
            Map inlineContentMap2 = new LinkedHashMap();
            $composer$iv2.startReplaceGroup(-1276788566);
            ComposerKt.sourceInformation($composer$iv2, "*142@6362L879");
            List $this$forEachIndexed$iv2 = tagPics3;
            int index$iv4 = 0;
            while (r97.hasNext()) {
            }
            Composer $composer$iv62 = $composer$iv42;
            Composer $composer$iv72 = $composer$iv2;
            Composer $composer$iv$iv$iv32 = $composer$iv$iv$iv2;
            Composer $composer$iv$iv32 = $composer$iv$iv4;
            Density density42 = density2;
            $composer$iv2.endReplaceGroup();
            inlineContentMap2.put("divider", new InlineTextContent(new Placeholder(density42.toSp-0xMU5do(Dp.constructor-impl(9)), density42.toSp-0xMU5do(Dp.constructor-impl(14)), PlaceholderVerticalAlign.Companion.getCenter-J6kI3mc(), (DefaultConstructorMarker) null), ComposableSingletons$TribeeSearchResultDynCardKt.INSTANCE.getLambda$394584424$search_debug()));
            $composer$iv2.endReplaceGroup();
            $composer$iv2.startReplaceGroup(-1276701590);
            ComposerKt.sourceInformation($composer$iv2, "*213@10009L6,219@10337L6");
            boolean z6 = false;
            AnnotatedString.Builder $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u2422 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            boolean z22 = false;
            while (r15.hasNext()) {
            }
            $composer$iv2.startReplaceGroup(-1276696223);
            ComposerKt.sourceInformation($composer$iv2, "");
            Iterable $this$forEach$iv3 = post.getCategories();
            boolean z42 = false;
            it = $this$forEach$iv3.iterator();
            while (it.hasNext()) {
            }
            String str82 = str42;
            $composer$iv2.endReplaceGroup();
            parseHtmlTitle($this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u2422, title, new SpanStyle(BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getText1-0d7_KjU(), TextUnitKt.getSp(16), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65528, (DefaultConstructorMarker) null), new SpanStyle(BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), TextUnitKt.getSp(16), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65528, (DefaultConstructorMarker) null));
            AnnotatedString annotatedString2 = $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u2422.toAnnotatedString();
            $composer$iv2.endReplaceGroup();
            TextKt.Text-Z58ophY(annotatedString2, PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(6), Dp.constructor-impl(12), 0.0f, 9, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, inlineContentMap2, (Function1) null, (TextStyle) null, $composer$iv2, 48, 24960, 438268);
            Modifier modifier$iv52 = PaddingKt.padding-qDBjuR0$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(29)), 0.0f, Dp.constructor-impl(6), Dp.constructor-impl(10), 0.0f, 9, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv22 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv22 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv52 = RowKt.rowMeasurePolicy(horizontalArrangement$iv22, verticalAlignment$iv22, $composer$iv2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv52 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str52);
            int compositeKeyHash$iv$iv52 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
            CompositionLocalMap localMap$iv$iv52 = $composer$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv52 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv52);
            Function0 factory$iv$iv$iv112 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv52 = (($changed$iv$iv52 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str62);
            if (!($composer$iv2.getApplier() instanceof Applier)) {
            }
            $composer$iv2.startReusableNode();
            if ($composer$iv2.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv52 = Updater.constructor-impl($composer$iv2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, measurePolicy$iv52, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, localMap$iv$iv52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv52, Integer.valueOf(compositeKeyHash$iv$iv52), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv52, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, materialized$iv$iv52, ComposeUiNode.Companion.getSetModifier());
            int i122 = ($changed$iv$iv$iv52 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i132 = ((6 >> 6) & 112) | 6;
            $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u243 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1954499779, "C:TribeeSearchResultDynCard.kt#jdzap2");
            leftText = post.getLeftText();
            if (leftText != null || StringsKt.isBlank(leftText)) {
            }
            $composer$iv2.endReplaceGroup();
            if (StringsKt.isBlank(post.getRightText())) {
            }
            $composer$iv2.startReplaceGroup(1955092715);
            ComposerKt.sourceInformation($composer$iv2, "245@11509L1281");
            Modifier modifier$iv62 = $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u243.alignByBaseline(PaddingKt.padding-qDBjuR0$default(RowScope.-CC.weight$default($this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u243, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(6), 0.0f, 0.0f, 0.0f, 14, (Object) null));
            Arrangement.Horizontal horizontalArrangement$iv32 = Arrangement.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv32 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv62 = RowKt.rowMeasurePolicy(horizontalArrangement$iv32, verticalAlignment$iv32, $composer$iv2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv62 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str52);
            int compositeKeyHash$iv$iv62 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
            CompositionLocalMap localMap$iv$iv62 = $composer$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv62 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv62);
            Function0 factory$iv$iv$iv122 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv62 = (($changed$iv$iv62 << 6) & 896) | 6;
            $composer2 = $composer$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str62);
            if (!($composer$iv2.getApplier() instanceof Applier)) {
            }
            $composer$iv2.startReusableNode();
            if ($composer$iv2.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv62 = Updater.constructor-impl($composer$iv2);
            $composer$iv3 = $composer$iv2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, measurePolicy$iv62, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, localMap$iv$iv62, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv62, Integer.valueOf(compositeKeyHash$iv$iv62), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv62, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, materialized$iv$iv62, ComposeUiNode.Companion.getSetModifier());
            int i142 = ($changed$iv$iv$iv62 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i152 = ((48 >> 6) & 112) | 6;
            RowScope $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u243_u2402 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -1557495583, "C:TribeeSearchResultDynCard.kt#jdzap2");
            if (StringsKt.isBlank(post.getViewStat())) {
            }
            $composer$iv2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (StringsKt.isBlank(post.getRightText())) {
            }
            $composer$iv2.endReplaceGroup();
            $composer$iv2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            Composer $composer42 = $composer2;
            DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer42, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer42, 54, 0);
            ComposerKt.sourceInformationMarkerEnd($composer42);
            ComposerKt.sourceInformationMarkerEnd($composer$iv72);
            $composer$iv$iv$iv32.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv32);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv32);
            ComposerKt.sourceInformationMarkerEnd($composer$iv62);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer$iv$iv$iv = $composer3;
            $composer$iv$iv$iv.skipToGroupEnd();
            modifier$iv$iv = modifier2;
            reportAction = function02;
        }
        ScopeUpdateScope endRestartGroup2 = $composer$iv$iv$iv.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier6 = modifier$iv$iv;
            final Function0 function04 = reportAction;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.tribee.search.cards.TribeeSearchResultDynCardKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj2, Object obj3) {
                    Unit TribeeSearchResultDynCard$lambda$3;
                    TribeeSearchResultDynCard$lambda$3 = TribeeSearchResultDynCardKt.TribeeSearchResultDynCard$lambda$3(card, modifier6, function04, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return TribeeSearchResultDynCard$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchResultDynCard$lambda$2$1$0(KTribeeDyn $post, Router $router, Function0 $reportAction) {
        Builder buildUpon;
        Builder appendQueryParameter;
        Uri p0;
        Uri uriOrNull = toUriOrNull($post.getJumpUri());
        if (uriOrNull != null && (buildUpon = uriOrNull.buildUpon()) != null && (appendQueryParameter = buildUpon.appendQueryParameter("from_spmid", SearchTrackerKt.SEARCH_CARD_SPMID)) != null && (p0 = appendQueryParameter.build()) != null) {
            $router.launch(p0);
        }
        $reportAction.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchResultDynCard$lambda$2$2$1$1$0$2(final KTitleTagPic $pic, ThemeDayNight $theme, Density $density, String it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)153@7066L21,154@7147L21,143@6400L807:TribeeSearchResultDynCard.kt#jdzap2");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1413656526, $changed, -1, "kntr.app.tribee.search.cards.TribeeSearchResultDynCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeSearchResultDynCard.kt:143)");
            }
            String $this$asRequest$iv = getUrl($pic, $theme);
            ImageRequest $this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u241_u240_u242_u240 = new ImageRequest($this$asRequest$iv);
            ImageRequest.useOrigin$default($this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u241_u240_u242_u240, false, 1, null);
            BiliImageKt.BiliImage($this$TribeeSearchResultDynCard_u24lambda_u242_u242_u241_u241_u240_u242_u240.build(), SizeKt.size-VpY3zN4(Modifier.Companion, $density.toDp-u2uoSUM((float) $pic.getWidth()), $density.toDp-u2uoSUM((float) $pic.getHeight())), null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1129893709, true, new Function2() { // from class: kntr.app.tribee.search.cards.TribeeSearchResultDynCardKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSearchResultDynCard$lambda$2$2$1$1$0$2$3;
                    TribeeSearchResultDynCard$lambda$2$2$1$1$0$2$3 = TribeeSearchResultDynCardKt.TribeeSearchResultDynCard$lambda$2$2$1$1$0$2$3($pic, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSearchResultDynCard$lambda$2$2$1$1$0$2$3;
                }
            }, $composer, 54), ComposableLambdaKt.rememberComposableLambda(932793469, true, new Function4() { // from class: kntr.app.tribee.search.cards.TribeeSearchResultDynCardKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit TribeeSearchResultDynCard$lambda$2$2$1$1$0$2$4;
                    TribeeSearchResultDynCard$lambda$2$2$1$1$0$2$4 = TribeeSearchResultDynCardKt.TribeeSearchResultDynCard$lambda$2$2$1$1$0$2$4($pic, (ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return TribeeSearchResultDynCard$lambda$2$2$1$1$0$2$4;
                }
            }, $composer, 54), $composer, 113246208, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchResultDynCard$lambda$2$2$1$1$0$2$3(KTitleTagPic $pic, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C153@7072L13:TribeeSearchResultDynCard.kt#jdzap2");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1129893709, $changed, -1, "kntr.app.tribee.search.cards.TribeeSearchResultDynCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeSearchResultDynCard.kt:153)");
            }
            Placeholder($pic, null, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSearchResultDynCard$lambda$2$2$1$1$0$2$4(KTitleTagPic $pic, ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)154@7153L13:TribeeSearchResultDynCard.kt#jdzap2");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(932793469, $changed, -1, "kntr.app.tribee.search.cards.TribeeSearchResultDynCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeSearchResultDynCard.kt:154)");
        }
        Placeholder($pic, null, $composer, 0, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Uri toUriOrNull(String $this$toUriOrNull) {
        Intrinsics.checkNotNullParameter($this$toUriOrNull, "<this>");
        return Uri.Companion.parseOrNull($this$toUriOrNull);
    }

    public static final String getColor(KColor $this$getColor, ThemeDayNight themeDayNight) {
        Intrinsics.checkNotNullParameter(themeDayNight, "themeDayNight");
        return $this$getColor == null ? "" : themeDayNight == ThemeDayNight.Night ? $this$getColor.getDark() : $this$getColor.getLight();
    }

    public static final String getUrl(KLightDarkIcon $this$getUrl, ThemeDayNight themeDayNight) {
        Intrinsics.checkNotNullParameter(themeDayNight, "themeDayNight");
        return $this$getUrl == null ? "" : themeDayNight == ThemeDayNight.Night ? $this$getUrl.getDarkMode() : $this$getUrl.getLightMode();
    }

    public static final String getUrl(KTitleTagPic $this$getUrl, ThemeDayNight themeDayNight) {
        Intrinsics.checkNotNullParameter(themeDayNight, "themeDayNight");
        return $this$getUrl == null ? "" : themeDayNight == ThemeDayNight.Night ? $this$getUrl.getDarkUrl() : $this$getUrl.getLightUrl();
    }

    public static final void Placeholder(final KTitleTagPic $this$Placeholder, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$Placeholder, "<this>");
        Composer $composer2 = $composer.startRestartGroup(-1532412904);
        ComposerKt.sourceInformation($composer2, "C(Placeholder)N(modifier)317@14481L7,318@14580L7,320@14701L6,313@14367L886:TribeeSearchResultDynCard.kt#jdzap2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance($this$Placeholder) ? 4 : 2;
        }
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1532412904, $dirty, -1, "kntr.app.tribee.search.cards.Placeholder (TribeeSearchResultDynCard.kt:312)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$Placeholder_u24lambda_u240 = (Density) consume;
            float f = $this$Placeholder_u24lambda_u240.toDp-u2uoSUM((int) $this$Placeholder.getWidth());
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$Placeholder_u24lambda_u241 = (Density) consume2;
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(modifier3, f, $this$Placeholder_u24lambda_u241.toDp-u2uoSUM((int) $this$Placeholder.getHeight())), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bg_regular_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2)));
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((0 >> 6) & 112) | 6;
            BoxScope $this$Placeholder_u24lambda_u242 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -659111045, "C:TribeeSearchResultDynCard.kt#jdzap2");
            if (Intrinsics.areEqual($this$Placeholder.getType(), KTitleTagPic.KTitleTagPicType.TOP.INSTANCE)) {
                $composer2.startReplaceGroup(-659018759);
                ComposerKt.sourceInformation($composer2, "327@14968L24,328@15031L6,326@14919L267");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_to_top_up_line_500($composer2, 6), (String) null, $this$Placeholder_u24lambda_u242.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), Alignment.Companion.getCenter()), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), $composer2, Painter.$stable | 48, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-658725995);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.search.cards.TribeeSearchResultDynCardKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit Placeholder$lambda$3;
                    Placeholder$lambda$3 = TribeeSearchResultDynCardKt.Placeholder$lambda$3($this$Placeholder, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Placeholder$lambda$3;
                }
            });
        }
    }

    private static final void parseHtmlTitle(AnnotatedString.Builder $this$parseHtmlTitle, String title, SpanStyle normalStyle, SpanStyle emStyle) {
        int index$iv;
        Regex emTagRegex = new Regex("<em\\s+class=[\"']?keyword[\"']?>(.*?)</em>");
        Sequence $this$forEach$iv = Regex.findAll$default(emTagRegex, title, 0, 2, (Object) null);
        int lastIndex = 0;
        for (Object element$iv : $this$forEach$iv) {
            MatchResult matchResult = (MatchResult) element$iv;
            int matchStart = matchResult.getRange().getFirst();
            int matchEnd = matchResult.getRange().getLast() + 1;
            if (matchStart > lastIndex) {
                index$iv = $this$parseHtmlTitle.pushStyle(normalStyle);
                try {
                    String substring = title.substring(lastIndex, matchStart);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    $this$parseHtmlTitle.append(substring);
                    Unit unit = Unit.INSTANCE;
                } finally {
                }
            }
            String emContent = (String) matchResult.getGroupValues().get(1);
            Regex emTagRegex2 = emTagRegex;
            index$iv = $this$parseHtmlTitle.pushStyle(emStyle);
            try {
                $this$parseHtmlTitle.append(emContent);
                Unit unit2 = Unit.INSTANCE;
                $this$parseHtmlTitle.pop(index$iv);
                lastIndex = matchEnd;
                emTagRegex = emTagRegex2;
            } finally {
            }
        }
        if (lastIndex >= title.length()) {
            return;
        }
        index$iv = $this$parseHtmlTitle.pushStyle(normalStyle);
        try {
            String substring2 = title.substring(lastIndex);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            $this$parseHtmlTitle.append(substring2);
            Unit unit3 = Unit.INSTANCE;
        } finally {
        }
    }
}