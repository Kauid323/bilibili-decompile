package kntr.common.photonic.aphro.ui.component;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeStrategy;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.ui.MediaSelectFloatKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: OriginalImageBar.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a)\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"OriginalImageBar", "", "onAction", "Lkotlin/Function1;", "Lkntr/common/photonic/aphro/core/AphroAction;", "state", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkotlin/jvm/functions/Function1;Lkntr/common/photonic/aphro/core/AphroState$AphroContent;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "OriginImage", "themeStrategy", "Lcom/bilibili/compose/theme/ThemeStrategy;", "(Lkntr/common/photonic/aphro/core/AphroState$AphroContent;Landroidx/compose/ui/Modifier;Lcom/bilibili/compose/theme/ThemeStrategy;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OriginalImageBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OriginImage$lambda$1(AphroState.AphroContent aphroContent, Modifier modifier, ThemeStrategy themeStrategy, int i, int i2, Composer composer, int i3) {
        OriginImage(aphroContent, modifier, themeStrategy, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OriginalImageBar$lambda$1(Function1 function1, AphroState.AphroContent aphroContent, Modifier modifier, int i, int i2, Composer composer, int i3) {
        OriginalImageBar(function1, aphroContent, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x01c2, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OriginalImageBar(final Function1<? super AphroAction, Unit> function1, final AphroState.AphroContent state, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String str;
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(1486335022);
        ComposerKt.sourceInformation($composer2, "C(OriginalImageBar)N(onAction,state,modifier)44@1825L1731:OriginalImageBar.kt#gh748z");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(state) ? 32 : 16;
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
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1486335022, $dirty2, -1, "kntr.common.photonic.aphro.ui.component.OriginalImageBar (OriginalImageBar.kt:43)");
            }
            int $changed$iv = ($dirty2 >> 6) & 14;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
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
            int i4 = (($changed$iv >> 6) & 112) | 6;
            BoxScope $this$OriginalImageBar_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1217581648, "C53@2076L112,47@1875L324,66@2549L6,68@2659L86,58@2209L1341:OriginalImageBar.kt#gh748z");
            Modifier align = $this$OriginalImageBar_u24lambda_u240.align(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenter());
            ComposerKt.sourceInformationMarkerStart($composer2, -1701839944, "CC(remember):OriginalImageBar.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | (($dirty2 & 112) == 32);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.component.OriginalImageBarKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit OriginalImageBar$lambda$0$0$0;
                    OriginalImageBar$lambda$0$0$0 = OriginalImageBarKt.OriginalImageBar$lambda$0$0$0(function1, state);
                    return OriginalImageBar$lambda$0$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            OriginImage(state, ClickableKt.clickable-oSLSa3U$default(align, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), null, $composer2, ($dirty2 >> 3) & 14, 4);
            Modifier modifier4 = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.defaultMinSize-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(AlphaKt.alpha(Modifier.Companion, !state.getCurrentSelected().isEmpty() ? 1.0f : 0.4f), 0.0f, 0.0f, Dp.constructor-impl(12), 0.0f, 11, (Object) null), Dp.constructor-impl(66), 0.0f, 2, (Object) null), Dp.constructor-impl(30)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(15)));
            ComposerKt.sourceInformationMarkerStart($composer2, -1701821314, "CC(remember):OriginalImageBar.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 14) == 4;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.common.photonic.aphro.ui.component.OriginalImageBarKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit OriginalImageBar$lambda$0$1$0;
                        OriginalImageBar$lambda$0$1$0 = OriginalImageBarKt.OriginalImageBar$lambda$0$1$0(function1);
                        return OriginalImageBar$lambda$0$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv2 = $this$OriginalImageBar_u24lambda_u240.align(ClickableKt.clickable-oSLSa3U$default(modifier4, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), Alignment.Companion.getCenterEnd());
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (48 << 3) & 112;
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
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -371070260, "C86@3397L6,73@2847L693:OriginalImageBar.kt#gh748z");
            if (!state.getCurrentSelected().isEmpty()) {
                $composer2.startReplaceGroup(-370996946);
                ComposerKt.sourceInformation($composer2, "76@2962L162");
                String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_436(Res.string.INSTANCE), new Object[]{Integer.valueOf(state.getCurrentSelected().size())}, $composer2, 0);
                $composer2.endReplaceGroup();
                str = stringResource;
            } else {
                $composer2.startReplaceGroup(-370786115);
                ComposerKt.sourceInformation($composer2, "81@3178L51");
                String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_202(Res.string.INSTANCE), $composer2, 0);
                $composer2.endReplaceGroup();
                str = stringResource2;
            }
            TextKt.Text-Nvy7gAk(str, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(10), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_white-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 1, 0, (Function1) null, (TextStyle) null, $composer2, 24624, 24576, 244712);
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
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.component.OriginalImageBarKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OriginalImageBar$lambda$1;
                    OriginalImageBar$lambda$1 = OriginalImageBarKt.OriginalImageBar$lambda$1(function1, state, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OriginalImageBar$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OriginalImageBar$lambda$0$0$0(Function1 $onAction, AphroState.AphroContent $state) {
        $onAction.invoke(new AphroAction.CheckUseOriginImage(!$state.getUseOriginImage()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OriginalImageBar$lambda$0$1$0(Function1 $onAction) {
        $onAction.invoke(AphroAction.ConfirmSelection.INSTANCE);
        return Unit.INSTANCE;
    }

    public static final void OriginImage(final AphroState.AphroContent state, Modifier modifier, ThemeStrategy themeStrategy, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ThemeStrategy themeStrategy2;
        Modifier modifier3;
        Modifier modifier4;
        ThemeStrategy themeStrategy3;
        Function0 factory$iv$iv$iv;
        String str;
        long j;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(18631873);
        ComposerKt.sourceInformation($composer2, "C(OriginImage)N(state,modifier,themeStrategy)101@3728L1618:OriginalImageBar.kt#gh748z");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
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
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(themeStrategy == null ? -1 : ((Enum) themeStrategy).ordinal()) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                themeStrategy3 = themeStrategy;
            } else {
                themeStrategy3 = ThemeStrategy.FollowApp;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(18631873, $dirty2, -1, "kntr.common.photonic.aphro.ui.component.OriginImage (OriginalImageBar.kt:100)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty2 >> 3) & 14) | 384;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            modifier3 = modifier4;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -2098734116, "C130@4689L651:OriginalImageBar.kt#gh748z");
            if (state.getUseOriginImage()) {
                $composer2.startReplaceGroup(-2098727142);
                ComposerKt.sourceInformation($composer2, "107@3919L18,112@4115L6,106@3874L451");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getCheckmark_line_800($composer2, 6), (String) null, PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl((float) 2.73d)), Color.Companion.getWhite-0d7_KjU(), $composer2, Painter.$stable | 3120, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-2098267350);
                ComposerKt.sourceInformation($composer2, "119@4355L315");
                BoxKt.Box(BorderKt.border-xT4_qwU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), Dp.constructor-impl(1), BiliColorsSourceKt.getDayColors().getText4-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), $composer2, 0);
                $composer2.endReplaceGroup();
            }
            Modifier modifier5 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            if (state.getUseOriginImage() && !state.getCurrentSelected().isEmpty()) {
                $composer2.startReplaceGroup(-2097767630);
                ComposerKt.sourceInformation($composer2, "134@4871L163");
                String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_356(Res.string.INSTANCE), new Object[]{MediaSelectFloatKt.m2244displayString4yfSoQ8(state.m2202getTotalSelectedSizeQJZHGII())}, $composer2, 0);
                $composer2.endReplaceGroup();
                str = stringResource;
            } else {
                $composer2.startReplaceGroup(-2097563774);
                ComposerKt.sourceInformation($composer2, "139@5080L51");
                String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_435(Res.string.INSTANCE), $composer2, 0);
                $composer2.endReplaceGroup();
                str = stringResource2;
            }
            long sp = TextUnitKt.getSp(14);
            if (themeStrategy3 == ThemeStrategy.ForceNight) {
                $composer2.startReplaceGroup(-483298801);
                ComposerKt.sourceInformation($composer2, "142@5258L6");
                j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU();
            } else {
                $composer2.startReplaceGroup(-483297750);
                ComposerKt.sourceInformation($composer2, "142@5291L6");
                j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU();
            }
            $composer2.endReplaceGroup();
            TextKt.Text-Nvy7gAk(str, modifier5, j, (TextAutoSize) null, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, (TextStyle) null, $composer2, 24624, 24576, 245736);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            themeStrategy2 = themeStrategy3;
        } else {
            $composer2.skipToGroupEnd();
            themeStrategy2 = themeStrategy;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final ThemeStrategy themeStrategy4 = themeStrategy2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.component.OriginalImageBarKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit OriginImage$lambda$1;
                    OriginImage$lambda$1 = OriginalImageBarKt.OriginImage$lambda$1(AphroState.AphroContent.this, modifier6, themeStrategy4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OriginImage$lambda$1;
                }
            });
        }
    }
}