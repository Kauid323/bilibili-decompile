package kntr.app.deepsearch.ui.bottomSheet;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.pagecontroller.BackHandlerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: GeneralBottomSheetDialog.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u001aP\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001aB\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000bH\u0003¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0012X\u008a\u008e\u0002"}, d2 = {"GeneralBottomSheetDialog", RoomRecommendViewModel.EMPTY_CURSOR, "visible", RoomRecommendViewModel.EMPTY_CURSOR, "cancelable", "canceledOnTouchOutside", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/runtime/Composable;", "(ZZZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "InnerDialog", "Landroidx/compose/foundation/layout/BoxScope;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "compose_debug", "offsetY", RoomRecommendViewModel.EMPTY_CURSOR, "offsetYAnimate", "bottomSheetHeight"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GeneralBottomSheetDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GeneralBottomSheetDialog$lambda$1(boolean z, boolean z2, boolean z3, Function0 function0, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        GeneralBottomSheetDialog(z, z2, z3, function0, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerDialog$lambda$16(BoxScope boxScope, boolean z, boolean z2, Function0 function0, Function2 function2, int i, Composer composer, int i2) {
        InnerDialog(boxScope, z, z2, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void GeneralBottomSheetDialog(final boolean visible, final boolean cancelable, final boolean canceledOnTouchOutside, final Function0<Unit> function0, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        int $dirty;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer3 = $composer.startRestartGroup(-17207896);
        ComposerKt.sourceInformation($composer3, "C(GeneralBottomSheetDialog)N(visible,cancelable,canceledOnTouchOutside,onDismissRequest,modifier,content)45@1858L1042:GeneralBottomSheetDialog.kt#ahurve");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(visible) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(cancelable) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(canceledOnTouchOutside) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty2 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 196608) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 131072 : 65536;
        }
        int $dirty3 = $dirty2;
        if (!$composer3.shouldExecute((74899 & $dirty3) != 74898, $dirty3 & 1)) {
            $composer2 = $composer3;
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
                ComposerKt.traceEventStart(-17207896, $dirty3, -1, "kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialog (GeneralBottomSheetDialog.kt:44)");
            }
            int $changed$iv = ($dirty3 >> 12) & 14;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope $this$GeneralBottomSheetDialog_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1364773080, "C50@2146L569,46@1893L822,68@2724L170:GeneralBottomSheetDialog.kt#ahurve");
            AnimatedVisibilityKt.AnimatedVisibility(visible, (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, (Object) null), 0.0f, 2, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(174016010, true, new Function3() { // from class: kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialogKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit GeneralBottomSheetDialog$lambda$0$0;
                    GeneralBottomSheetDialog$lambda$0$0 = GeneralBottomSheetDialogKt.GeneralBottomSheetDialog$lambda$0$0(visible, cancelable, function0, canceledOnTouchOutside, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return GeneralBottomSheetDialog$lambda$0$0;
                }
            }, $composer3, 54), $composer3, ($dirty3 & 14) | 196608, 18);
            $dirty = $dirty3;
            InnerDialog($this$GeneralBottomSheetDialog_u24lambda_u240, visible, cancelable, function0, function2, $composer3, (((($changed$iv >> 6) & 112) | 6) & 14) | (($dirty << 3) & 112) | (($dirty << 3) & 896) | ($dirty & 7168) | (57344 & ($dirty >> 3)));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
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
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialogKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit GeneralBottomSheetDialog$lambda$1;
                    GeneralBottomSheetDialog$lambda$1 = GeneralBottomSheetDialogKt.GeneralBottomSheetDialog$lambda$1(visible, cancelable, canceledOnTouchOutside, function0, modifier4, function2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GeneralBottomSheetDialog$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GeneralBottomSheetDialog$lambda$0$0(boolean $visible, final boolean $cancelable, final Function0 $onDismissRequest, final boolean $canceledOnTouchOutside, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C51@2191L106,51@2160L137,61@2524L166,61@2506L184,56@2310L395:GeneralBottomSheetDialog.kt#ahurve");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(174016010, $changed, -1, "kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialog.<anonymous>.<anonymous> (GeneralBottomSheetDialog.kt:51)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -274337388, "CC(remember):GeneralBottomSheetDialog.kt#9igjgp");
        boolean invalid$iv = $composer.changed($cancelable) | $composer.changed($onDismissRequest);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialogKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit GeneralBottomSheetDialog$lambda$0$0$0$0;
                    GeneralBottomSheetDialog$lambda$0$0$0$0 = GeneralBottomSheetDialogKt.GeneralBottomSheetDialog$lambda$0$0$0$0($cancelable, $onDismissRequest);
                    return GeneralBottomSheetDialog$lambda$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        BackHandlerKt.BackHandler($visible, (Function0) it$iv, $composer, 0, 0);
        Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), ColorKt.Color(2147483648L), (Shape) null, 2, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, -274326672, "CC(remember):GeneralBottomSheetDialog.kt#9igjgp");
        boolean invalid$iv2 = $composer.changed($canceledOnTouchOutside) | $composer.changed($onDismissRequest);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = new Function0() { // from class: kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialogKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit GeneralBottomSheetDialog$lambda$0$0$1$0;
                    GeneralBottomSheetDialog$lambda$0$0$1$0 = GeneralBottomSheetDialogKt.GeneralBottomSheetDialog$lambda$0$0$1$0($canceledOnTouchOutside, $onDismissRequest);
                    return GeneralBottomSheetDialog$lambda$0$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        BoxKt.Box(BottomSheetDialogKt.clickableNoRipple(modifier, (Function0) it$iv2, $composer, 6), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GeneralBottomSheetDialog$lambda$0$0$0$0(boolean $cancelable, Function0 $onDismissRequest) {
        if ($cancelable) {
            $onDismissRequest.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GeneralBottomSheetDialog$lambda$0$0$1$0(boolean $canceledOnTouchOutside, Function0 $onDismissRequest) {
        if ($canceledOnTouchOutside) {
            $onDismissRequest.invoke();
        }
        return Unit.INSTANCE;
    }

    private static final void InnerDialog(final BoxScope $this$InnerDialog, final boolean visible, final boolean cancelable, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Object obj;
        Composer $composer2 = $composer.startRestartGroup(-1894320266);
        ComposerKt.sourceInformation($composer2, "C(InnerDialog)N(visible,cancelable,onDismissRequest,content)84@3091L56,87@3174L54,88@3258L44,93@3461L19,93@3443L37,94@3502L84,96@3603L81,102@3828L114,101@3766L203,107@4063L23,109@4124L247,121@4592L46,128@4827L42,132@4892L443,89@3307L2028:GeneralBottomSheetDialog.kt#ahurve");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$InnerDialog) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(visible) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(cancelable) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 16384 : 8192;
        }
        if (!$composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1894320266, $dirty, -1, "kntr.app.deepsearch.ui.bottomSheet.InnerDialog (GeneralBottomSheetDialog.kt:83)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 624363278, "CC(remember):GeneralBottomSheetDialog.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableFloatState offsetY$delegate = (MutableFloatState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State offsetYAnimate$delegate = AnimateAsStateKt.animateFloatAsState(InnerDialog$lambda$1(offsetY$delegate), (AnimationSpec) null, 0.0f, RoomRecommendViewModel.EMPTY_CURSOR, (Function1) null, $composer2, 3072, 22);
            ComposerKt.sourceInformationMarkerStart($composer2, 624368610, "CC(remember):GeneralBottomSheetDialog.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableFloatState bottomSheetHeight$delegate = (MutableFloatState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier align = $this$InnerDialog.align(Modifier.Companion, Alignment.Companion.getBottomCenter());
            ComposerKt.sourceInformationMarkerStart($composer2, 624375081, "CC(remember):GeneralBottomSheetDialog.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialogKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier clickableNoRipple = BottomSheetDialogKt.clickableNoRipple(align, (Function0) it$iv3, $composer2, 48);
            ComposerKt.sourceInformationMarkerStart($composer2, 624376458, "CC(remember):GeneralBottomSheetDialog.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialogKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj2) {
                        Unit InnerDialog$lambda$8$0;
                        InnerDialog$lambda$8$0 = GeneralBottomSheetDialogKt.InnerDialog$lambda$8$0(bottomSheetHeight$delegate, (LayoutCoordinates) obj2);
                        return InnerDialog$lambda$8$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(clickableNoRipple, (Function1) it$iv4);
            ComposerKt.sourceInformationMarkerStart($composer2, 624379687, "CC(remember):GeneralBottomSheetDialog.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(offsetYAnimate$delegate);
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv || it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new Function1() { // from class: kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialogKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj2) {
                        IntOffset InnerDialog$lambda$9$0;
                        InnerDialog$lambda$9$0 = GeneralBottomSheetDialogKt.InnerDialog$lambda$9$0(offsetYAnimate$delegate, (Density) obj2);
                        return InnerDialog$lambda$9$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier offset = OffsetKt.offset(onGloballyPositioned, (Function1) it$iv5);
            ComposerKt.sourceInformationMarkerStart($composer2, 624386920, "CC(remember):GeneralBottomSheetDialog.kt#9igjgp");
            Object it$iv6 = $composer2.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv6 = new Function1() { // from class: kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialogKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj2) {
                        Unit InnerDialog$lambda$10$0;
                        InnerDialog$lambda$10$0 = GeneralBottomSheetDialogKt.InnerDialog$lambda$10$0(offsetY$delegate, ((Float) obj2).floatValue());
                        return InnerDialog$lambda$10$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            DraggableState rememberDraggableState = DraggableKt.rememberDraggableState((Function1) it$iv6, $composer2, 6);
            Orientation orientation = Orientation.Vertical;
            ComposerKt.sourceInformationMarkerStart($composer2, 624394349, "CC(remember):GeneralBottomSheetDialog.kt#9igjgp");
            Object it$iv7 = $composer2.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv7 = (Function3) new GeneralBottomSheetDialogKt$InnerDialog$5$1(null);
                $composer2.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
            }
            Function3 function3 = (Function3) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 624396525, "CC(remember):GeneralBottomSheetDialog.kt#9igjgp");
            boolean invalid$iv2 = (($dirty & 7168) == 2048) | (($dirty & 896) == 256);
            Object value$iv8 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv8 == Composer.Companion.getEmpty()) {
                obj = null;
                value$iv8 = new GeneralBottomSheetDialogKt$InnerDialog$6$1(cancelable, function0, offsetY$delegate, bottomSheetHeight$delegate, null);
                $composer2.updateRememberedValue(value$iv8);
            } else {
                obj = null;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier draggable$default = DraggableKt.draggable$default(offset, rememberDraggableState, orientation, false, (MutableInteractionSource) null, false, function3, (Function3) value$iv8, false, 156, (Object) null);
            FiniteAnimationSpec tween$default = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearOutSlowInEasing(), 2, obj);
            ComposerKt.sourceInformationMarkerStart($composer2, 624411300, "CC(remember):GeneralBottomSheetDialog.kt#9igjgp");
            Object it$iv8 = $composer2.rememberedValue();
            if (it$iv8 == Composer.Companion.getEmpty()) {
                Object value$iv9 = new Function1() { // from class: kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialogKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj2) {
                        int InnerDialog$lambda$13$0;
                        InnerDialog$lambda$13$0 = GeneralBottomSheetDialogKt.InnerDialog$lambda$13$0(((Integer) obj2).intValue());
                        return Integer.valueOf(InnerDialog$lambda$13$0);
                    }
                };
                $composer2.updateRememberedValue(value$iv9);
                it$iv8 = value$iv9;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EnterTransition slideInVertically = EnterExitTransitionKt.slideInVertically(tween$default, (Function1) it$iv8);
            FiniteAnimationSpec tween$default2 = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearOutSlowInEasing(), 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 624418816, "CC(remember):GeneralBottomSheetDialog.kt#9igjgp");
            Object it$iv9 = $composer2.rememberedValue();
            if (it$iv9 == Composer.Companion.getEmpty()) {
                Object value$iv10 = new Function1() { // from class: kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialogKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj2) {
                        int InnerDialog$lambda$14$0;
                        InnerDialog$lambda$14$0 = GeneralBottomSheetDialogKt.InnerDialog$lambda$14$0(((Integer) obj2).intValue());
                        return Integer.valueOf(InnerDialog$lambda$14$0);
                    }
                };
                $composer2.updateRememberedValue(value$iv10);
                it$iv9 = value$iv10;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AnimatedVisibilityKt.AnimatedVisibility(visible, draggable$default, slideInVertically, EnterExitTransitionKt.slideOutVertically(tween$default2, (Function1) it$iv9), (String) null, ComposableLambdaKt.rememberComposableLambda(-1814718898, true, new Function3() { // from class: kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialogKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    Unit InnerDialog$lambda$15;
                    InnerDialog$lambda$15 = GeneralBottomSheetDialogKt.InnerDialog$lambda$15(offsetY$delegate, function2, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return InnerDialog$lambda$15;
                }
            }, $composer2, 54), $composer2, (($dirty >> 3) & 14) | 196608, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialogKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj2, Object obj3) {
                    Unit InnerDialog$lambda$16;
                    InnerDialog$lambda$16 = GeneralBottomSheetDialogKt.InnerDialog$lambda$16($this$InnerDialog, visible, cancelable, function0, function2, $changed, (Composer) obj2, ((Integer) obj3).intValue());
                    return InnerDialog$lambda$16;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float InnerDialog$lambda$1(MutableFloatState $offsetY$delegate) {
        FloatState $this$getValue$iv = (FloatState) $offsetY$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    private static final float InnerDialog$lambda$3(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float InnerDialog$lambda$5(MutableFloatState $bottomSheetHeight$delegate) {
        FloatState $this$getValue$iv = (FloatState) $bottomSheetHeight$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerDialog$lambda$8$0(MutableFloatState $bottomSheetHeight$delegate, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $bottomSheetHeight$delegate.setFloatValue((int) (4294967295L & it.getSize-YbymL2g()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset InnerDialog$lambda$9$0(State $offsetYAnimate$delegate, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        int y$iv = MathKt.roundToInt(InnerDialog$lambda$3($offsetYAnimate$delegate));
        return IntOffset.box-impl(IntOffset.constructor-impl((0 << 32) | (y$iv & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerDialog$lambda$10$0(MutableFloatState $offsetY$delegate, float it) {
        $offsetY$delegate.setFloatValue(RangesKt.coerceAtLeast(InnerDialog$lambda$1($offsetY$delegate) + ((int) it), 0.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int InnerDialog$lambda$13$0(int it) {
        return it * 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int InnerDialog$lambda$14$0(int it) {
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerDialog$lambda$15(final MutableFloatState $offsetY$delegate, Function2 $content, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C133@4932L78,133@4902L108,138@5019L310:GeneralBottomSheetDialog.kt#ahurve");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1814718898, $changed, -1, "kntr.app.deepsearch.ui.bottomSheet.InnerDialog.<anonymous> (GeneralBottomSheetDialog.kt:133)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -188137444, "CC(remember):GeneralBottomSheetDialog.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialogKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    DisposableEffectResult InnerDialog$lambda$15$0$0;
                    InnerDialog$lambda$15$0$0 = GeneralBottomSheetDialogKt.InnerDialog$lambda$15$0$0($offsetY$delegate, (DisposableEffectScope) obj);
                    return InnerDialog$lambda$15$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.DisposableEffect((Object) null, (Function1) it$iv, $composer, 54);
        Modifier modifier$iv = ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null));
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (0 << 3) & 112;
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
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        int i2 = ((0 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 887062534, "C148@5310L9:GeneralBottomSheetDialog.kt#ahurve");
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult InnerDialog$lambda$15$0$0(final MutableFloatState $offsetY$delegate, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialogKt$InnerDialog$lambda$15$0$0$$inlined$onDispose$1
            public void dispose() {
                $offsetY$delegate.setFloatValue(0.0f);
            }
        };
    }
}