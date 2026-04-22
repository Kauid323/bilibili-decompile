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
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
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
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.Velocity;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.pagecontroller.BackHandlerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: BottomSheetDialog.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u000b\u001aM\u0010\f\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007H\u0003¢\u0006\u0002\u0010\u000e\u001a\u001f\u0010\u000f\u001a\u00020\t*\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0014X\u008a\u008e\u0002"}, d2 = {"DSBottomSheetDialog", RoomRecommendViewModel.EMPTY_CURSOR, "visible", RoomRecommendViewModel.EMPTY_CURSOR, "onDismissRequest", "Lkotlin/Function0;", "title", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "InnerDialog", "Landroidx/compose/foundation/layout/BoxScope;", "(Landroidx/compose/foundation/layout/BoxScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "clickableNoRipple", "onClick", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "compose_debug", "offsetY", RoomRecommendViewModel.EMPTY_CURSOR, "offsetYAnimate", "bottomSheetHeight"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BottomSheetDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DSBottomSheetDialog$lambda$3(boolean z, Function0 function0, Function2 function2, Modifier modifier, Function2 function22, int i, int i2, Composer composer, int i3) {
        DSBottomSheetDialog(z, function0, function2, modifier, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerDialog$lambda$17(BoxScope boxScope, boolean z, Function0 function0, Function2 function2, Function2 function22, int i, Composer composer, int i2) {
        InnerDialog(boxScope, z, function0, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DSBottomSheetDialog(final boolean visible, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function2, "title");
        Intrinsics.checkNotNullParameter(function22, "content");
        Composer $composer3 = $composer.startRestartGroup(-922549710);
        ComposerKt.sourceInformation($composer3, "C(DSBottomSheetDialog)N(visible,onDismissRequest,title,modifier,content)72@3260L29,73@3318L104,73@3294L128,79@3427L988:BottomSheetDialog.kt#ahurve");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(visible) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 256 : 128;
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
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-922549710, $dirty2, -1, "kntr.app.deepsearch.ui.bottomSheet.DSBottomSheetDialog (BottomSheetDialog.kt:71)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -1807001361, "CC(remember):BottomSheetDialog.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new FocusRequester();
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            FocusRequester focusRequester = (FocusRequester) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Boolean valueOf = Boolean.valueOf(visible);
            ComposerKt.sourceInformationMarkerStart($composer3, -1806999430, "CC(remember):BottomSheetDialog.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 14) == 4;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new BottomSheetDialogKt$DSBottomSheetDialog$1$1(visible, focusRequester, null);
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv2, $composer3, $dirty2 & 14);
            Modifier modifier$iv = FocusableKt.focusable$default(FocusRequesterModifierKt.focusRequester(modifier4, focusRequester), false, (MutableInteractionSource) null, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
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
            BoxScope $this$DSBottomSheetDialog_u24lambda_u242 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 988824300, "C89@3819L421,85@3566L674,103@4249L160:BottomSheetDialog.kt#ahurve");
            modifier3 = modifier4;
            AnimatedVisibilityKt.AnimatedVisibility(visible, (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(400, 0, EasingKt.getLinearEasing(), 2, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(400, 0, EasingKt.getLinearEasing(), 2, (Object) null), 0.0f, 2, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-2144314220, true, new Function3() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit DSBottomSheetDialog$lambda$2$0;
                    DSBottomSheetDialog$lambda$2$0 = BottomSheetDialogKt.DSBottomSheetDialog$lambda$2$0(visible, function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return DSBottomSheetDialog$lambda$2$0;
                }
            }, $composer3, 54), $composer3, ($dirty2 & 14) | 196608, 18);
            $composer2 = $composer3;
            InnerDialog($this$DSBottomSheetDialog_u24lambda_u242, visible, function0, function2, function22, $composer3, ((((0 >> 6) & 112) | 6) & 14) | (($dirty2 << 3) & 112) | (($dirty2 << 3) & 896) | (($dirty2 << 3) & 7168) | ($dirty2 & 57344));
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
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit DSBottomSheetDialog$lambda$3;
                    DSBottomSheetDialog$lambda$3 = BottomSheetDialogKt.DSBottomSheetDialog$lambda$3(visible, function0, function2, modifier5, function22, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DSBottomSheetDialog$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DSBottomSheetDialog$lambda$2$0(boolean $visible, final Function0 $onDismissRequest, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C90@3864L50,90@3833L81,98@4141L74,98@4123L92,93@3927L303:BottomSheetDialog.kt#ahurve");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2144314220, $changed, -1, "kntr.app.deepsearch.ui.bottomSheet.DSBottomSheetDialog.<anonymous>.<anonymous> (BottomSheetDialog.kt:90)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 898338150, "CC(remember):BottomSheetDialog.kt#9igjgp");
        boolean invalid$iv = $composer.changed($onDismissRequest);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit DSBottomSheetDialog$lambda$2$0$0$0;
                    DSBottomSheetDialog$lambda$2$0$0$0 = BottomSheetDialogKt.DSBottomSheetDialog$lambda$2$0$0$0($onDismissRequest);
                    return DSBottomSheetDialog$lambda$2$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        BackHandlerKt.BackHandler($visible, (Function0) it$iv, $composer, 0, 0);
        Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), ColorKt.Color(1291845632), (Shape) null, 2, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 898347038, "CC(remember):BottomSheetDialog.kt#9igjgp");
        boolean invalid$iv2 = $composer.changed($onDismissRequest);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = new Function0() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit DSBottomSheetDialog$lambda$2$0$1$0;
                    DSBottomSheetDialog$lambda$2$0$1$0 = BottomSheetDialogKt.DSBottomSheetDialog$lambda$2$0$1$0($onDismissRequest);
                    return DSBottomSheetDialog$lambda$2$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        BoxKt.Box(clickableNoRipple(modifier, (Function0) it$iv2, $composer, 6), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DSBottomSheetDialog$lambda$2$0$0$0(Function0 $onDismissRequest) {
        $onDismissRequest.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DSBottomSheetDialog$lambda$2$0$1$0(Function0 $onDismissRequest) {
        $onDismissRequest.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x01d1, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void InnerDialog(final BoxScope $this$InnerDialog, final boolean visible, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1943280437);
        ComposerKt.sourceInformation($composer2, "C(InnerDialog)N(visible,onDismissRequest,title,content)119@4616L56,122@4699L54,123@4783L44,126@4870L1919,183@6988L19,183@6970L37,184@7029L84,186@7130L81,193@7409L114,192@7347L203,198@7644L23,200@7705L233,212@8159L46,219@8394L42,223@8459L3288,178@6795L4952:BottomSheetDialog.kt#ahurve");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$InnerDialog) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(visible) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1943280437, $dirty2, -1, "kntr.app.deepsearch.ui.bottomSheet.InnerDialog (BottomSheetDialog.kt:118)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 818279523, "CC(remember):BottomSheetDialog.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableFloatState offsetY$delegate = (MutableFloatState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State offsetYAnimate$delegate = AnimateAsStateKt.animateFloatAsState(InnerDialog$lambda$1(offsetY$delegate), (AnimationSpec) null, 0.0f, RoomRecommendViewModel.EMPTY_CURSOR, (Function1) null, $composer2, 3072, 22);
            ComposerKt.sourceInformationMarkerStart($composer2, 818284855, "CC(remember):BottomSheetDialog.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableFloatState bottomSheetHeight$delegate = (MutableFloatState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 818289514, "CC(remember):BottomSheetDialog.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new NestedScrollConnection() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$InnerDialog$nestedScrollConnection$1$1
                    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
                    public long m695onPreScrollOzD1aCk(long j2, int i) {
                        float InnerDialog$lambda$1;
                        float InnerDialog$lambda$12;
                        float InnerDialog$lambda$13;
                        if (NestedScrollSource.equals-impl0(i, NestedScrollSource.Companion.getUserInput-WNlRxjI())) {
                            int bits$iv$iv$iv = (int) (j2 & 4294967295L);
                            if (Float.intBitsToFloat(bits$iv$iv$iv) < 0.0f) {
                                InnerDialog$lambda$1 = BottomSheetDialogKt.InnerDialog$lambda$1(offsetY$delegate);
                                if (InnerDialog$lambda$1 > 0.0f) {
                                    int bits$iv$iv$iv2 = (int) (j2 & 4294967295L);
                                    float intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv2);
                                    InnerDialog$lambda$12 = BottomSheetDialogKt.InnerDialog$lambda$1(offsetY$delegate);
                                    float consumed = RangesKt.coerceAtLeast(intBitsToFloat, -InnerDialog$lambda$12);
                                    MutableFloatState mutableFloatState = offsetY$delegate;
                                    InnerDialog$lambda$13 = BottomSheetDialogKt.InnerDialog$lambda$1(offsetY$delegate);
                                    mutableFloatState.setFloatValue(InnerDialog$lambda$13 + consumed);
                                    long v1$iv$iv = Float.floatToRawIntBits(0.0f);
                                    long v2$iv$iv = Float.floatToRawIntBits(consumed);
                                    return Offset.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
                                }
                            }
                        }
                        return Offset.Companion.getZero-F1C5BW0();
                    }

                    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
                    public long m693onPostScrollDzOQY0M(long j2, long j3, int i) {
                        float InnerDialog$lambda$1;
                        if (NestedScrollSource.equals-impl0(i, NestedScrollSource.Companion.getUserInput-WNlRxjI())) {
                            int bits$iv$iv$iv = (int) (j3 & 4294967295L);
                            if (Float.intBitsToFloat(bits$iv$iv$iv) > 0.0f) {
                                MutableFloatState mutableFloatState = offsetY$delegate;
                                InnerDialog$lambda$1 = BottomSheetDialogKt.InnerDialog$lambda$1(offsetY$delegate);
                                int bits$iv$iv$iv2 = (int) (j3 & 4294967295L);
                                mutableFloatState.setFloatValue(InnerDialog$lambda$1 + Float.intBitsToFloat(bits$iv$iv$iv2));
                                int bits$iv$iv$iv3 = (int) (j3 & 4294967295L);
                                float y$iv = Float.intBitsToFloat(bits$iv$iv$iv3);
                                long v1$iv$iv = Float.floatToRawIntBits(0.0f);
                                long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                                return Offset.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
                            }
                        }
                        return Offset.Companion.getZero-F1C5BW0();
                    }

                    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
                    public Object m692onPostFlingRZ2iAVY(long j2, long j3, Continuation<? super Velocity> continuation) {
                        float InnerDialog$lambda$1;
                        float InnerDialog$lambda$5;
                        if (Velocity.getY-impl(j3) > 0.0f) {
                            InnerDialog$lambda$1 = BottomSheetDialogKt.InnerDialog$lambda$1(offsetY$delegate);
                            InnerDialog$lambda$5 = BottomSheetDialogKt.InnerDialog$lambda$5(bottomSheetHeight$delegate);
                            if (InnerDialog$lambda$1 > InnerDialog$lambda$5 / 4) {
                                function0.invoke();
                            } else {
                                offsetY$delegate.setFloatValue(0.0f);
                            }
                        }
                        return NestedScrollConnection.-CC.$default$onPostFling-RZ2iAVY(this, j2, j3, continuation);
                    }

                    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
                    public Object m694onPreFlingQWom1Mo(long j2, Continuation<? super Velocity> continuation) {
                        float InnerDialog$lambda$1;
                        if (Velocity.getY-impl(j2) < 0.0f) {
                            InnerDialog$lambda$1 = BottomSheetDialogKt.InnerDialog$lambda$1(offsetY$delegate);
                            if (InnerDialog$lambda$1 > 0.0f) {
                                offsetY$delegate.setFloatValue(0.0f);
                                return Velocity.box-impl(j2);
                            }
                        }
                        return NestedScrollConnection.-CC.$default$onPreFling-QWom1Mo(this, j2, continuation);
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            BottomSheetDialogKt$InnerDialog$nestedScrollConnection$1$1 nestedScrollConnection = (BottomSheetDialogKt$InnerDialog$nestedScrollConnection$1$1) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier align = $this$InnerDialog.align(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(100), 0.0f, 0.0f, 13, (Object) null), Alignment.Companion.getBottomCenter());
            ComposerKt.sourceInformationMarkerStart($composer2, 818355390, "CC(remember):BottomSheetDialog.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier clickableNoRipple = clickableNoRipple(align, (Function0) it$iv4, $composer2, 48);
            ComposerKt.sourceInformationMarkerStart($composer2, 818356767, "CC(remember):BottomSheetDialog.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new Function1() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        Unit InnerDialog$lambda$9$0;
                        InnerDialog$lambda$9$0 = BottomSheetDialogKt.InnerDialog$lambda$9$0(bottomSheetHeight$delegate, (LayoutCoordinates) obj);
                        return InnerDialog$lambda$9$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(clickableNoRipple, (Function1) it$iv5);
            ComposerKt.sourceInformationMarkerStart($composer2, 818359996, "CC(remember):BottomSheetDialog.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(offsetYAnimate$delegate);
            Object it$iv6 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv6 = new Function1() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    IntOffset InnerDialog$lambda$10$0;
                    InnerDialog$lambda$10$0 = BottomSheetDialogKt.InnerDialog$lambda$10$0(offsetYAnimate$delegate, (Density) obj);
                    return InnerDialog$lambda$10$0;
                }
            };
            $composer2.updateRememberedValue(value$iv6);
            it$iv6 = value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(OffsetKt.offset(onGloballyPositioned, (Function1) it$iv6), nestedScrollConnection, (NestedScrollDispatcher) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 818368957, "CC(remember):BottomSheetDialog.kt#9igjgp");
            Object it$iv7 = $composer2.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv7 = new Function1() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj) {
                        Unit InnerDialog$lambda$11$0;
                        InnerDialog$lambda$11$0 = BottomSheetDialogKt.InnerDialog$lambda$11$0(offsetY$delegate, ((Float) obj).floatValue());
                        return InnerDialog$lambda$11$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            DraggableState rememberDraggableState = DraggableKt.rememberDraggableState((Function1) it$iv7, $composer2, 6);
            Orientation orientation = Orientation.Vertical;
            ComposerKt.sourceInformationMarkerStart($composer2, 818376386, "CC(remember):BottomSheetDialog.kt#9igjgp");
            Object it$iv8 = $composer2.rememberedValue();
            if (it$iv8 == Composer.Companion.getEmpty()) {
                Object value$iv8 = (Function3) new BottomSheetDialogKt$InnerDialog$5$1(null);
                $composer2.updateRememberedValue(value$iv8);
                it$iv8 = value$iv8;
            }
            Function3 function3 = (Function3) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 818378548, "CC(remember):BottomSheetDialog.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 896) == 256;
            Object it$iv9 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv9 == Composer.Companion.getEmpty()) {
                Object value$iv9 = (Function3) new BottomSheetDialogKt$InnerDialog$6$1(function0, offsetY$delegate, bottomSheetHeight$delegate, null);
                $composer2.updateRememberedValue(value$iv9);
                it$iv9 = value$iv9;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier draggable$default = DraggableKt.draggable$default(nestedScroll$default, rememberDraggableState, orientation, false, (MutableInteractionSource) null, false, function3, (Function3) it$iv9, false, 156, (Object) null);
            FiniteAnimationSpec tween$default = AnimationSpecKt.tween$default(400, 0, EasingKt.getLinearOutSlowInEasing(), 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 818392889, "CC(remember):BottomSheetDialog.kt#9igjgp");
            Object it$iv10 = $composer2.rememberedValue();
            if (it$iv10 == Composer.Companion.getEmpty()) {
                Object value$iv10 = new Function1() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj) {
                        int InnerDialog$lambda$14$0;
                        InnerDialog$lambda$14$0 = BottomSheetDialogKt.InnerDialog$lambda$14$0(((Integer) obj).intValue());
                        return Integer.valueOf(InnerDialog$lambda$14$0);
                    }
                };
                $composer2.updateRememberedValue(value$iv10);
                it$iv10 = value$iv10;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EnterTransition slideInVertically = EnterExitTransitionKt.slideInVertically(tween$default, (Function1) it$iv10);
            FiniteAnimationSpec tween$default2 = AnimationSpecKt.tween$default(400, 0, EasingKt.getLinearOutSlowInEasing(), 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 818400405, "CC(remember):BottomSheetDialog.kt#9igjgp");
            Object it$iv11 = $composer2.rememberedValue();
            if (it$iv11 == Composer.Companion.getEmpty()) {
                Object value$iv11 = new Function1() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj) {
                        int InnerDialog$lambda$15$0;
                        InnerDialog$lambda$15$0 = BottomSheetDialogKt.InnerDialog$lambda$15$0(((Integer) obj).intValue());
                        return Integer.valueOf(InnerDialog$lambda$15$0);
                    }
                };
                $composer2.updateRememberedValue(value$iv11);
                it$iv11 = value$iv11;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AnimatedVisibilityKt.AnimatedVisibility(visible, draggable$default, slideInVertically, EnterExitTransitionKt.slideOutVertically(tween$default2, (Function1) it$iv11), (String) null, ComposableLambdaKt.rememberComposableLambda(-596194061, true, new Function3() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit InnerDialog$lambda$16;
                    InnerDialog$lambda$16 = BottomSheetDialogKt.InnerDialog$lambda$16(offsetY$delegate, function2, function0, function22, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return InnerDialog$lambda$16;
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 3) & 14) | 196608, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit InnerDialog$lambda$17;
                    InnerDialog$lambda$17 = BottomSheetDialogKt.InnerDialog$lambda$17($this$InnerDialog, visible, function0, function2, function22, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return InnerDialog$lambda$17;
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
    public static final Unit InnerDialog$lambda$9$0(MutableFloatState $bottomSheetHeight$delegate, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $bottomSheetHeight$delegate.setFloatValue((int) (4294967295L & it.getSize-YbymL2g()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset InnerDialog$lambda$10$0(State $offsetYAnimate$delegate, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        int y$iv = MathKt.roundToInt(InnerDialog$lambda$3($offsetYAnimate$delegate));
        return IntOffset.box-impl(IntOffset.constructor-impl((0 << 32) | (y$iv & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerDialog$lambda$11$0(MutableFloatState $offsetY$delegate, float it) {
        $offsetY$delegate.setFloatValue(RangesKt.coerceAtLeast(InnerDialog$lambda$1($offsetY$delegate) + ((int) it), 0.0f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int InnerDialog$lambda$14$0(int it) {
        return it * 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int InnerDialog$lambda$15$0(int it) {
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x05ea, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit InnerDialog$lambda$16(final MutableFloatState $offsetY$delegate, Function2 $title, final Function0 $onDismissRequest, final Function2 $content, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C224@8499L78,224@8469L108,240@8944L6,230@8587L3154:BottomSheetDialog.kt#ahurve");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-596194061, $changed, -1, "kntr.app.deepsearch.ui.bottomSheet.InnerDialog.<anonymous> (BottomSheetDialog.kt:224)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1711840895, "CC(remember):BottomSheetDialog.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    DisposableEffectResult InnerDialog$lambda$16$0$0;
                    InnerDialog$lambda$16$0$0 = BottomSheetDialogKt.InnerDialog$lambda$16$0$0($offsetY$delegate, (DisposableEffectScope) obj);
                    return InnerDialog$lambda$16$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.DisposableEffect((Object) null, (Function1) it$iv, $composer, 54);
        Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.fillMaxHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (0 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
        Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv = factory$iv$iv$iv6;
            $composer.createNode(factory$iv$iv$iv);
        } else {
            factory$iv$iv$iv = factory$iv$iv$iv6;
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
        ComposerKt.sourceInformationMarkerStart($composer, 1898678078, "C242@8987L2744:BottomSheetDialog.kt#ahurve");
        Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(16), 0.0f, Dp.constructor-impl(16), 0.0f, 10, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
        int $changed$iv$iv2 = (6 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
        Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv2 = factory$iv$iv$iv7;
            $composer.createNode(factory$iv$iv$iv2);
        } else {
            factory$iv$iv$iv2 = factory$iv$iv$iv7;
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
        int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        int i4 = ((6 >> 6) & 112) | 6;
        ColumnScope $this$InnerDialog_u24lambda_u2416_u241_u240 = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -1988593046, "C250@9251L672,269@9941L30,271@9989L1123,298@11130L30,305@11364L294,300@11178L480,314@11676L41:BottomSheetDialog.kt#ahurve");
        Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
        Modifier modifier$iv3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(19));
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
        int $changed$iv$iv3 = (54 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
        Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv3 = factory$iv$iv$iv8;
            $composer.createNode(factory$iv$iv$iv3);
        } else {
            factory$iv$iv$iv3 = factory$iv$iv$iv8;
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
        int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
        int i6 = ((54 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -1990215710, "C264@9837L6,257@9505L400:BottomSheetDialog.kt#ahurve");
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(30)), Dp.constructor-impl(3)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa3-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer, 6);
        Modifier modifier$iv4 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(28));
        Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
        ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
        int $changed$iv$iv4 = (438 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
        Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
        int $i$f$Row = $changed$iv$iv4 << 6;
        int $changed$iv$iv$iv4 = ($i$f$Row & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv4 = factory$iv$iv$iv9;
            $composer.createNode(factory$iv$iv$iv4);
        } else {
            factory$iv$iv$iv4 = factory$iv$iv$iv9;
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
        int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
        RowScope rowScope = RowScopeInstance.INSTANCE;
        int i8 = ((438 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -700306418, "C279@10324L7,286@10653L6,287@10721L22,280@10352L742:BottomSheetDialog.kt#ahurve");
        $title.invoke($composer, 0);
        Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
        Modifier modifier = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(28)), RoundedCornerShapeKt.getCircleShape()), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_regular-0d7_KjU(), (Shape) null, 2, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, -1408051895, "CC(remember):BottomSheetDialog.kt#9igjgp");
        boolean invalid$iv = $composer.changed($onDismissRequest);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv) {
        }
        Object value$iv2 = new Function0() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$$ExternalSyntheticLambda4
            public final Object invoke() {
                Unit InnerDialog$lambda$16$1$0$1$0$0;
                InnerDialog$lambda$16$1$0$1$0$0 = BottomSheetDialogKt.InnerDialog$lambda$16$1$0$1$0$0($onDismissRequest);
                return InnerDialog$lambda$16$1$0$1$0$0;
            }
        };
        $composer.updateRememberedValue(value$iv2);
        it$iv2 = value$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier modifier$iv$iv = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
        int $changed$iv$iv5 = (48 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv5 = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv$iv);
        Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv5 = factory$iv$iv$iv10;
            $composer.createNode(factory$iv$iv$iv5);
        } else {
            factory$iv$iv$iv5 = factory$iv$iv$iv10;
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer);
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
        int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
        int i10 = ((48 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 1602203295, "C290@10850L20,291@10917L6,289@10793L279:BottomSheetDialog.kt#ahurve");
        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getXmark_close_line_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(15)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), $composer, Painter.$stable | 432, 0);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer, 6);
        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(ColumnScope.-CC.weight$default($this$InnerDialog_u24lambda_u2416_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(1638646753, true, new Function3() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit InnerDialog$lambda$16$1$0$2;
                InnerDialog$lambda$16$1$0$2 = BottomSheetDialogKt.InnerDialog$lambda$16$1$0$2($content, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return InnerDialog$lambda$16$1$0$2;
            }
        }, $composer, 54), $composer, 3072, 6);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), $composer, 6);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
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
    public static final DisposableEffectResult InnerDialog$lambda$16$0$0(final MutableFloatState $offsetY$delegate, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: kntr.app.deepsearch.ui.bottomSheet.BottomSheetDialogKt$InnerDialog$lambda$16$0$0$$inlined$onDispose$1
            public void dispose() {
                $offsetY$delegate.setFloatValue(0.0f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerDialog$lambda$16$1$0$1$0$0(Function0 $onDismissRequest) {
        $onDismissRequest.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InnerDialog$lambda$16$1$0$2(Function2 $content, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C306@11418L7,307@11480L160:BottomSheetDialog.kt#ahurve");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1638646753, $dirty, -1, "kntr.app.deepsearch.ui.bottomSheet.InnerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetDialog.kt:306)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density $this$InnerDialog_u24lambda_u2416_u241_u240_u242_u240 = (Density) consume;
            float dpValue = $this$InnerDialog_u24lambda_u2416_u241_u240_u242_u240.toDp-u2uoSUM(Constraints.getMaxHeight-impl($this$BoxWithConstraints.getConstraints-msEJaDk()));
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, dpValue), 0.0f, 1, (Object) null);
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
            ComposerKt.sourceInformationMarkerStart($composer, -1108211105, "C310@11609L9:BottomSheetDialog.kt#ahurve");
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

    public static final Modifier clickableNoRipple(Modifier $this$clickableNoRipple, Function0<Unit> function0, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$clickableNoRipple, "<this>");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        ComposerKt.sourceInformationMarkerStart($composer, -614219903, "C(clickableNoRipple)N(onClick)327@11993L39:BottomSheetDialog.kt#ahurve");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-614219903, $changed, -1, "kntr.app.deepsearch.ui.bottomSheet.clickableNoRipple (BottomSheetDialog.kt:322)");
        }
        Modifier modifier = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart($composer, -1854799832, "CC(remember):BottomSheetDialog.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = InteractionSourceKt.MutableInteractionSource();
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier then = $this$clickableNoRipple.then(ClickableKt.clickable-O2vRcR0$default(modifier, (MutableInteractionSource) it$iv, (Indication) null, false, (String) null, (Role) null, function0, 20, (Object) null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return then;
    }
}