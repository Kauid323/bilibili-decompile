package kntr.common.ouro.common.ui.toolPanel.expandablePanel;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelState;
import kntr.common.trio.pagecontroller.BackHandlerKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ExpandablePanel.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\u001aD\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001a \u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"ExpandablePanel", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState;", "onDismissRequest", "Lkotlin/Function0;", "content", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "preUpPostDownNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "T", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "ui_debug", "anchoredDraggableProgress", "", "anchoredDraggableCurrentValue", "Lkntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelState$Style;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ExpandablePanelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpandablePanel$lambda$3(Modifier modifier, ExpandablePanelState expandablePanelState, Function0 function0, Function2 function2, int i, int i2, Composer composer, int i3) {
        ExpandablePanel(modifier, expandablePanelState, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v4 */
    public static final void ExpandablePanel(Modifier modifier, ExpandablePanelState state, Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final ExpandablePanelState state2;
        Function0 function02;
        Function0 onDismissRequest;
        Modifier modifier3;
        ExpandablePanelState state3;
        Modifier modifier4;
        String str;
        int i2;
        final Function0 onDismissRequest2;
        int i3;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-663609847);
        ComposerKt.sourceInformation($composer2, "C(ExpandablePanel)N(modifier,state,onDismissRequest,content)40@1794L34,40@1782L46,46@1903L5356,44@1834L5425:ExpandablePanel.kt#x1p13y");
        int $dirty = $changed;
        int i4 = i & 1;
        if (i4 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                state2 = state;
                if ($composer2.changed(state2)) {
                    i3 = 32;
                    $dirty |= i3;
                }
            } else {
                state2 = state;
            }
            i3 = 16;
            $dirty |= i3;
        } else {
            state2 = state;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            function02 = function0;
        } else if (($changed & 384) == 0) {
            function02 = function0;
            $dirty |= $composer2.changedInstance(function02) ? 256 : 128;
        } else {
            function02 = function0;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        if ($composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "36@1666L30,37@1733L2");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                modifier4 = modifier2;
                str = "CC(remember):ExpandablePanel.kt#9igjgp";
                onDismissRequest2 = function02;
                i2 = 256;
            } else {
                if (i4 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) == 0) {
                    str = "CC(remember):ExpandablePanel.kt#9igjgp";
                    i2 = 256;
                } else {
                    str = "CC(remember):ExpandablePanel.kt#9igjgp";
                    i2 = 256;
                    state2 = ExpandablePanelStateKt.rememberExpandablePanelState(null, false, null, null, $composer2, 0, 15);
                    $dirty &= -113;
                }
                if (i5 == 0) {
                    onDismissRequest2 = function0;
                } else {
                    ComposerKt.sourceInformationMarkerStart($composer2, -2073898133, str);
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelKt$$ExternalSyntheticLambda4
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    onDismissRequest2 = it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-663609847, $dirty, -1, "kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanel (ExpandablePanel.kt:39)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -2073896149, str);
            boolean invalid$iv = ($dirty & 896) == i2;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit ExpandablePanel$lambda$1$0;
                        ExpandablePanel$lambda$1$0 = ExpandablePanelKt.ExpandablePanel$lambda$1$0(onDismissRequest2);
                        return ExpandablePanel$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BackHandlerKt.BackHandler(false, (Function0) it$iv2, $composer2, 0, 1);
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(1026845791, true, new Function3() { // from class: kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ExpandablePanel$lambda$2;
                    ExpandablePanel$lambda$2 = ExpandablePanelKt.ExpandablePanel$lambda$2(ExpandablePanelState.this, onDismissRequest2, function2, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ExpandablePanel$lambda$2;
                }
            }, $composer2, 54), $composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            state3 = state2;
            onDismissRequest = onDismissRequest2;
        } else {
            $composer2.skipToGroupEnd();
            onDismissRequest = function0;
            modifier3 = modifier2;
            state3 = state2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final ExpandablePanelState expandablePanelState = state3;
            final Function0 function03 = onDismissRequest;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit ExpandablePanel$lambda$3;
                    ExpandablePanel$lambda$3 = ExpandablePanelKt.ExpandablePanel$lambda$3(modifier5, expandablePanelState, function03, function2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ExpandablePanel$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpandablePanel$lambda$1$0(Function0 $onDismissRequest) {
        $onDismissRequest.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x02b7, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v29 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ExpandablePanel$lambda$2(final ExpandablePanelState $state, final Function0 $onDismissRequest, final Function2 $content, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        float f;
        float f2;
        Function0 factory$iv$iv;
        Modifier modifier;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C47@1940L7,60@2704L24,61@2776L18,62@2846L22,64@2878L473,146@6434L819,76@3361L3892:ExpandablePanel.kt#x1p13y");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1026845791, $dirty, -1, "kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanel.<anonymous> (ExpandablePanel.kt:47)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density = (Density) consume;
            float fullHeight = Constraints.getMaxHeight-impl($this$BoxWithConstraints.getConstraints-msEJaDk());
            ExpandablePanelState.Anchor anchor = $state.getNormalAnchor$ui_debug();
            if (anchor instanceof ExpandablePanelState.Anchor.AbsoluteHeight) {
                f = fullHeight - density.toPx-0680j_4(((ExpandablePanelState.Anchor.AbsoluteHeight) anchor).m1917getHeightD9Ej5fM());
            } else if (!(anchor instanceof ExpandablePanelState.Anchor.PaddingFromTop)) {
                throw new NoWhenBranchMatchedException();
            } else {
                f = density.toPx-0680j_4(((ExpandablePanelState.Anchor.PaddingFromTop) anchor).m1921getPaddingD9Ej5fM());
            }
            final float normalTopPadding = RangesKt.coerceAtLeast(f, 0.0f);
            ExpandablePanelState.Anchor anchor2 = $state.getExpandedAnchor$ui_debug();
            if (anchor2 instanceof ExpandablePanelState.Anchor.AbsoluteHeight) {
                f2 = fullHeight - density.toPx-0680j_4(((ExpandablePanelState.Anchor.AbsoluteHeight) anchor2).m1917getHeightD9Ej5fM());
            } else if (!(anchor2 instanceof ExpandablePanelState.Anchor.PaddingFromTop)) {
                throw new NoWhenBranchMatchedException();
            } else {
                f2 = density.toPx-0680j_4(((ExpandablePanelState.Anchor.PaddingFromTop) anchor2).m1921getPaddingD9Ej5fM());
            }
            final float expandTopPadding = RangesKt.coerceAtLeast(f2, 0.0f);
            ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
                $composer.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            final State anchoredDraggableProgress$delegate = ExpandablePanelStateKt.rememberProgress($state, $composer, 0);
            ExpandablePanelStateKt.rememberCurrentValue($state, $composer, 0);
            boolean isEnableExpand = $state.isEnableExpand();
            ComposerKt.sourceInformationMarkerStart($composer, -1043641256, "CC(remember):ExpandablePanel.kt#9igjgp");
            boolean invalid$iv = $composer.changed(isEnableExpand) | $composer.changed(fullHeight) | $composer.changed(normalTopPadding);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                AnchoredDraggableState.updateAnchors$default($state.getAnchoredDraggableState(), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit ExpandablePanel$lambda$2$6$0;
                        ExpandablePanel$lambda$2$6$0 = ExpandablePanelKt.ExpandablePanel$lambda$2$6$0(normalTopPadding, $state, expandTopPadding, (DraggableAnchorsConfig) obj);
                        return ExpandablePanel$lambda$2$6$0;
                    }
                }), (Object) null, 2, (Object) null);
                $composer.updateRememberedValue(Unit.INSTANCE);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1043527118, "CC(remember):ExpandablePanel.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($state);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv = (MeasurePolicy) new ExpandablePanelKt$ExpandablePanel$3$3$1($state);
                $composer.updateRememberedValue(value$iv);
                it$iv2 = value$iv;
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.Companion;
            int compositeKeyHash$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv = ((0 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv = factory$iv$iv2;
                $composer.createNode(factory$iv$iv);
            } else {
                factory$iv$iv = factory$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv, Integer.valueOf(compositeKeyHash$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 394653871, "C79@3434L547,106@4611L6,116@5043L1365,94@4020L2388:ExpandablePanel.kt#x1p13y");
            long m1905getScrimColor0d7_KjU = Constant.INSTANCE.m1905getScrimColor0d7_KjU();
            float ExpandablePanel$lambda$2$4 = ExpandablePanel$lambda$2$4(anchoredDraggableProgress$delegate);
            $composer.startReplaceGroup(-2065475706);
            ComposerKt.sourceInformation($composer, "");
            Modifier it = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            if (ExpandablePanel$lambda$2$4(anchoredDraggableProgress$delegate) == 0.0f) {
                $composer.startReplaceGroup(-1091812554);
                $composer.endReplaceGroup();
                modifier = it;
            } else {
                $composer.startReplaceGroup(-1091981039);
                ComposerKt.sourceInformation($composer, "85@3744L90");
                ComposerKt.sourceInformationMarkerStart($composer, -173771100, "CC(remember):ExpandablePanel.kt#9igjgp");
                boolean invalid$iv3 = $composer.changed($onDismissRequest);
                Object value$iv2 = $composer.rememberedValue();
                if (invalid$iv3) {
                }
                value$iv2 = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit ExpandablePanel$lambda$2$7$0$0$0;
                        ExpandablePanel$lambda$2$7$0$0$0 = ExpandablePanelKt.ExpandablePanel$lambda$2$7$0$0$0($onDismissRequest);
                        return ExpandablePanel$lambda$2$7$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                modifier = ClickableKt.clickable-oSLSa3U$default(it, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv2, 15, (Object) null);
                $composer.endReplaceGroup();
            }
            $composer.endReplaceGroup();
            ScrimKt.m1923ScrimKTwxG1Y(m1905getScrimColor0d7_KjU, modifier, ExpandablePanel$lambda$2$4, $composer, 0, 0);
            SurfaceKt.Surface-T9BRK9s(AnchoredDraggableKt.anchoredDraggable$default(NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), preUpPostDownNestedScrollConnection($state.getAnchoredDraggableState(), scope), (NestedScrollDispatcher) null, 2, (Object) null), $state.getAnchoredDraggableState(), Orientation.Vertical, false, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 60, (Object) null), (ExpandablePanel$lambda$2$4(anchoredDraggableProgress$delegate) > 0.0f ? 1 : (ExpandablePanel$lambda$2$4(anchoredDraggableProgress$delegate) == 0.0f ? 0 : -1)) == 0 ? RectangleShapeKt.getRectangleShape() : RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Constant.INSTANCE.m1902getCornerRadiusD9Ej5fM(), Constant.INSTANCE.m1902getCornerRadiusD9Ej5fM(), 0.0f, 0.0f, 12, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(1769748337, true, new Function2() { // from class: kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ExpandablePanel$lambda$2$7$1;
                    ExpandablePanel$lambda$2$7$1 = ExpandablePanelKt.ExpandablePanel$lambda$2$7$1(scope, $state, $content, anchoredDraggableProgress$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return ExpandablePanel$lambda$2$7$1;
                }
            }, $composer, 54), $composer, 12582912, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final float ExpandablePanel$lambda$2$4(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final ExpandablePanelState.Style ExpandablePanel$lambda$2$5(State<? extends ExpandablePanelState.Style> state) {
        Object thisObj$iv = state.getValue();
        return (ExpandablePanelState.Style) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpandablePanel$lambda$2$6$0(float $normalTopPadding, ExpandablePanelState $state, float $expandTopPadding, DraggableAnchorsConfig $this$DraggableAnchors) {
        Intrinsics.checkNotNullParameter($this$DraggableAnchors, "$this$DraggableAnchors");
        $this$DraggableAnchors.at(ExpandablePanelState.Style.Normal, $normalTopPadding);
        if ($state.isEnableExpand()) {
            $this$DraggableAnchors.at(ExpandablePanelState.Style.Expanded, $expandTopPadding);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpandablePanel$lambda$2$7$0$0$0(Function0 $onDismissRequest) {
        $onDismissRequest.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x01b6, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ExpandablePanel$lambda$2$7$1(final CoroutineScope $scope, final ExpandablePanelState $state, Function2 $content, State $anchoredDraggableProgress$delegate, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C117@5065L1325:ExpandablePanel.kt#x1p13y");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1769748337, $changed, -1, "kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanel.<anonymous>.<anonymous>.<anonymous> (ExpandablePanel.kt:117)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 781868036, "C129@5573L734,127@5468L866,142@6359L9:ExpandablePanel.kt#x1p13y");
            if (ExpandablePanel$lambda$2$4($anchoredDraggableProgress$delegate) == 0.0f) {
                $composer.startReplaceGroup(781902910);
                ComposerKt.sourceInformation($composer, "122@5316L6,121@5247L169");
                DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_light-0d7_KjU(), $composer, 48, 1);
            } else {
                $composer.startReplaceGroup(776691655);
            }
            $composer.endReplaceGroup();
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, 1687801657, "CC(remember):ExpandablePanel.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changed($state);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit ExpandablePanel$lambda$2$7$1$0$0$0;
                    ExpandablePanel$lambda$2$7$1$0$0$0 = ExpandablePanelKt.ExpandablePanel$lambda$2$7$1$0$0$0($scope, $state);
                    return ExpandablePanel$lambda$2$7$1$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            DragIndicatorKt.m1906DragIndicatorRIQooxk(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), 0L, 0L, $composer, 0, 6);
            $content.invoke($composer, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpandablePanel$lambda$2$7$1$0$0$0(CoroutineScope $scope, ExpandablePanelState $state) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ExpandablePanelKt$ExpandablePanel$3$2$2$1$1$1$1($state, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    private static final <T> NestedScrollConnection preUpPostDownNestedScrollConnection(AnchoredDraggableState<T> anchoredDraggableState, CoroutineScope scope) {
        return new ExpandablePanelKt$preUpPostDownNestedScrollConnection$1(anchoredDraggableState, scope);
    }
}