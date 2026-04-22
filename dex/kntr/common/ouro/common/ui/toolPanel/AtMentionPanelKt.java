package kntr.common.ouro.common.ui.toolPanel;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
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
import bili.resource.ouro_editor.Ouro_editorRes;
import bili.resource.ouro_editor.String0_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ApiKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.base.net.comm.imp.InitGMultiDomainKt;
import kntr.common.compose.res.LoadingAnimateImageKt;
import kntr.common.ouro.common.ui.toolPanel.AtMentionPanelKt;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.model.node.AtMentionUser;
import kntr.common.ouro.core.model.node.OfficialVerifyType;
import kntr.common.ouro.core.plugin.atMention.OuroAtMentionAction;
import kntr.common.ouro.core.plugin.atMention.OuroAtMentionState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.ImageResourcesKt;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.common.avatar.ui.generated.resources.Drawable0_commonMainKt;
import srcs.common.avatar.ui.generated.resources.Res;

/* compiled from: AtMentionPanel.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"AtMentionPanel", "", "state", "Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState;", "onAction", "Lkotlin/Function1;", "Lkntr/common/ouro/core/action/OuroAction;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/ouro/core/plugin/atMention/OuroAtMentionState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AtMentionPanelKt {

    /* compiled from: AtMentionPanel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfficialVerifyType.values().length];
            try {
                iArr[OfficialVerifyType.PERSONAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OfficialVerifyType.ENTERPRISE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[OfficialVerifyType.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AtMentionPanel$lambda$3(OuroAtMentionState ouroAtMentionState, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AtMentionPanel(ouroAtMentionState, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void AtMentionPanel(final OuroAtMentionState state, final Function1<? super OuroAction, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer2 = $composer.startRestartGroup(-636775527);
        ComposerKt.sourceInformation($composer2, "C(AtMentionPanel)N(state,onAction,modifier):AtMentionPanel.kt#wsnt7k");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-636775527, $dirty, -1, "kntr.common.ouro.common.ui.toolPanel.AtMentionPanel (AtMentionPanel.kt:56)");
            }
            if (state instanceof OuroAtMentionState.Idle) {
                $composer2.startReplaceGroup(691015079);
                $composer2.endReplaceGroup();
                modifier3 = modifier4;
            } else if (state instanceof OuroAtMentionState.Loading) {
                $composer2.startReplaceGroup(691079373);
                ComposerKt.sourceInformation($composer2, "60@2752L644");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                int $changed$iv = (($dirty >> 6) & 14) | 432;
                Modifier modifier$iv = modifier4;
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
                int $changed$iv$iv = ($changed$iv << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv3;
                    $composer2.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv3;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i4 = (($changed$iv >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -509181802, "C62@2928L27,61@2887L197,67@3102L40,70@3193L65,71@3298L9,72@3351L6,69@3160L222:AtMentionPanel.kt#wsnt7k");
                String $this$asRequest_u24default$iv = LoadingAnimateImageKt.getLoadingAnimateImageUri($composer2, 0);
                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                Unit unit = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), "", null, null, null, null, null, null, $composer2, 432, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer2, 6);
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getOuro_editor_global_string_1(Ouro_editorRes.INSTANCE.getString()), $composer2, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
                modifier3 = modifier4;
            } else if (state instanceof OuroAtMentionState.Error) {
                $composer2.startReplaceGroup(691788746);
                ComposerKt.sourceInformation($composer2, "78@3461L839");
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                int $changed$iv2 = (($dirty >> 6) & 14) | 432;
                Modifier modifier$iv2 = modifier4;
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & 112));
                int $changed$iv$iv2 = ($changed$iv2 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv4;
                    $composer2.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv4;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                modifier3 = modifier4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i6 = (($changed$iv2 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -1957182604, "C80@3629L65,81@3734L9,82@3787L6,79@3596L222,84@3835L40,86@3925L65,87@4030L9,88@4083L6,90@4176L91,85@3892L394:AtMentionPanel.kt#wsnt7k");
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getOuro_editor_global_string_2(Ouro_editorRes.INSTANCE.getString()), $composer2, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 0, 0, 131066);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer2, 6);
                String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getOuro_editor_global_string_3(Ouro_editorRes.INSTANCE.getString()), $composer2, 0);
                TextStyle t14 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14();
                long j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                Modifier modifier5 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer2, 1876545688, "CC(remember):AtMentionPanel.kt#9igjgp");
                boolean invalid$iv = ($dirty & 112) == 32;
                Object it$iv = $composer2.rememberedValue();
                if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    TextKt.Text-Nvy7gAk(stringResource, ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t14, $composer2, 0, 0, 131064);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceGroup();
                }
                Object value$iv = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.AtMentionPanelKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit AtMentionPanel$lambda$1$0$0;
                        AtMentionPanel$lambda$1$0$0 = AtMentionPanelKt.AtMentionPanel$lambda$1$0$0(function1);
                        return AtMentionPanel$lambda$1$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                TextKt.Text-Nvy7gAk(stringResource, ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t14, $composer2, 0, 0, 131064);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                modifier3 = modifier4;
                if (!(state instanceof OuroAtMentionState.ShowContent)) {
                    $composer2.startReplaceGroup(-2055915943);
                    $composer2.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                $composer2.startReplaceGroup(692775631);
                ComposerKt.sourceInformation($composer2, "98@4452L3473,98@4371L3554");
                PaddingValues paddingValues = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(12), 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, -2055859446, "CC(remember):AtMentionPanel.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changedInstance(state) | (($dirty & 112) == 32);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.AtMentionPanelKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit AtMentionPanel$lambda$2$0;
                            AtMentionPanel$lambda$2$0 = AtMentionPanelKt.AtMentionPanel$lambda$2$0(OuroAtMentionState.this, function1, (LazyListScope) obj);
                            return AtMentionPanel$lambda$2$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LazyDslKt.LazyRow(modifier3, (LazyListState) null, paddingValues, false, (Arrangement.Horizontal) null, (Alignment.Vertical) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv2, $composer2, (($dirty >> 6) & 14) | 384, 506);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.common.ui.toolPanel.AtMentionPanelKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AtMentionPanel$lambda$3;
                    AtMentionPanel$lambda$3 = AtMentionPanelKt.AtMentionPanel$lambda$3(OuroAtMentionState.this, function1, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AtMentionPanel$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AtMentionPanel$lambda$1$0$0(Function1 $onAction) {
        $onAction.invoke(OuroAtMentionAction.Retry.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AtMentionPanel$lambda$2$0(OuroAtMentionState $state, final Function1 $onAction, LazyListScope $this$LazyRow) {
        Intrinsics.checkNotNullParameter($this$LazyRow, "$this$LazyRow");
        final List items$iv = ((OuroAtMentionState.ShowContent) $state).getUsers();
        final Function1 contentType$iv = new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.AtMentionPanelKt$AtMentionPanel$lambda$2$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m1890invoke((AtMentionUser) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m1890invoke(AtMentionUser atMentionUser) {
                return null;
            }
        };
        $this$LazyRow.items(items$iv.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.common.ouro.common.ui.toolPanel.AtMentionPanelKt$AtMentionPanel$lambda$2$0$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke(items$iv.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.common.ouro.common.ui.toolPanel.AtMentionPanelKt$AtMentionPanel$lambda$2$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                Function0 factory$iv$iv$iv;
                Function0 factory$iv$iv$iv2;
                ComposerKt.sourceInformation($composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                int i = $dirty & 14;
                final AtMentionUser user = (AtMentionUser) items$iv.get(it);
                $composer.startReplaceGroup(2096215804);
                ComposerKt.sourceInformation($composer, "CN(user)*102@4648L117,100@4519L3374:AtMentionPanel.kt#wsnt7k");
                Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(74)), 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, -1594947250, "CC(remember):AtMentionPanel.kt#9igjgp");
                boolean invalid$iv = $composer.changed($onAction) | $composer.changedInstance(user);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    final Function1 function1 = $onAction;
                    Object value$iv = (Function0) new Function0<Unit>() { // from class: kntr.common.ouro.common.ui.toolPanel.AtMentionPanelKt$AtMentionPanel$3$1$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1891invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m1891invoke() {
                            function1.invoke(new OuroAtMentionAction.SelectUser(user));
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv$iv = ClickableKt.clickable-oSLSa3U$default(fillMaxHeight$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv$iv);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
                    $composer.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i2 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                int i3 = ((432 >> 6) & 112) | 6;
                ColumnScope $this$AtMentionPanel_u24lambda_u242_u240_u240_u241 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, -356549985, "C108@4958L2371,150@7355L40,154@7609L6,155@7669L9,151@7420L451:AtMentionPanel.kt#wsnt7k");
                Modifier modifier$iv = SizeKt.size-3ABfNKs($this$AtMentionPanel_u24lambda_u242_u240_u240_u241.align(Modifier.Companion, Alignment.Companion.getCenterHorizontally()), Dp.constructor-impl(40));
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i5 = ((0 >> 6) & 112) | 6;
                BoxScope $this$AtMentionPanel_u24lambda_u242_u240_u240_u241_u240 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, -42638236, "C132@6342L6:AtMentionPanel.kt#wsnt7k");
                String avatar = user.getAvatar();
                Modifier avatarModifier = ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(20)));
                String str = avatar;
                if (str == null || str.length() == 0) {
                    $composer.startReplaceGroup(-42400870);
                    ComposerKt.sourceInformation($composer, "116@5447L53,115@5394L267");
                    ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_default_avatar(Res.drawable.INSTANCE), $composer, 0), (String) null, avatarModifier, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 48, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
                    $composer.endReplaceGroup();
                } else {
                    $composer.startReplaceGroup(-42069077);
                    ComposerKt.sourceInformation($composer, "121@5731L186");
                    BiliImageKt.BiliImage(ApiKt.toImageRequest(avatar).build(), avatarModifier, null, null, null, null, null, null, null, $composer, 0, 508);
                    $composer.endReplaceGroup();
                }
                Modifier tagModifier = BorderKt.border-xT4_qwU(ClipKt.clip($this$AtMentionPanel_u24lambda_u242_u240_u240_u241_u240.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), Alignment.Companion.getBottomEnd()), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6))), Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                switch (AtMentionPanelKt.WhenMappings.$EnumSwitchMapping$0[user.getOfficialVerifyType().ordinal()]) {
                    case 1:
                        $composer.startReplaceGroup(-2079540198);
                        ComposerKt.sourceInformation($composer, "136@6592L58,135@6535L285");
                        ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_tag_official_person(Res.drawable.INSTANCE), $composer, 0), (String) null, tagModifier, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 48, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
                        $composer.endReplaceGroup();
                        Unit unit = Unit.INSTANCE;
                        break;
                    case 2:
                        $composer.startReplaceGroup(-2079527810);
                        ComposerKt.sourceInformation($composer, "142@6979L62,141@6922L289");
                        ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_tag_official_enterprise(Res.drawable.INSTANCE), $composer, 0), (String) null, tagModifier, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 48, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
                        $composer.endReplaceGroup();
                        Unit unit2 = Unit.INSTANCE;
                        break;
                    case 3:
                        $composer.startReplaceGroup(-40515357);
                        $composer.endReplaceGroup();
                        Unit unit3 = Unit.INSTANCE;
                        break;
                    default:
                        $composer.startReplaceGroup(-2079543807);
                        $composer.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
                TextKt.Text-Nvy7gAk(user.getName(), SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(1), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT11(), $composer, 48, 24960, 109560);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }
}