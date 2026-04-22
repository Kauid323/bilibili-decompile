package kntr.app.game.base.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BiliGameCustomBottomSheet.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t²\u0006\f\u0010\n\u001a\u0004\u0018\u00010\u000bX\u008a\u008e\u0002"}, d2 = {"GameCustomBottomSheet", RoomRecommendViewModel.EMPTY_CURSOR, "onDismiss", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "base-ui_debug", "sheetBounds", "Landroidx/compose/ui/geometry/Rect;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BiliGameCustomBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameCustomBottomSheet$lambda$7(Function0 function0, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        GameCustomBottomSheet(function0, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x01e9, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0410  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void GameCustomBottomSheet(final Function0<Unit> function0, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Object value$iv;
        Object it$iv;
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(688768801);
        ComposerKt.sourceInformation($composer2, "C(GameCustomBottomSheet)N(onDismiss,modifier,content)42@1728L24,43@1771L27,44@1830L7,45@1858L44,48@1943L40,55@2195L344,50@1989L3299:BiliGameCustomBottomSheet.kt#kw4tct");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
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
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(688768801, $dirty2, -1, "kntr.app.game.base.ui.widget.GameCustomBottomSheet (BiliGameCustomBottomSheet.kt:41)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 481860252, "CC(remember):BiliGameCustomBottomSheet.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Animatable Animatable$default = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
                $composer2.updateRememberedValue(Animatable$default);
                it$iv2 = Animatable$default;
            }
            final Animatable offsetY = (Animatable) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 481863053, "CC(remember):BiliGameCustomBottomSheet.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv2 = Float.valueOf(density.toPx-0680j_4(Dp.constructor-impl(300)));
                $composer2.updateRememberedValue(value$iv2);
                it$iv3 = value$iv2;
            }
            final float maxOffset = ((Number) it$iv3).floatValue();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 481865769, "CC(remember):BiliGameCustomBottomSheet.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv4 = value$iv3;
            }
            final MutableState sheetBounds$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier4 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), (1 - (((Number) offsetY.getValue()).floatValue() / maxOffset)) * 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 481874137, "CC(remember):BiliGameCustomBottomSheet.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 14) == 4;
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv4 = (PointerInputEventHandler) new BiliGameCustomBottomSheetKt$GameCustomBottomSheet$1$1(sheetBounds$delegate, function0);
            $composer2.updateRememberedValue(value$iv4);
            it$iv5 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (PointerInputEventHandler) it$iv5);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((0 >> 6) & 112) | 6;
            BoxScope $this$GameCustomBottomSheet_u24lambda_u246 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1006713219, "C69@2642L44,73@2896L152,78@3095L2187,66@2557L2725:BiliGameCustomBottomSheet.kt#kw4tct");
            Modifier modifier5 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer2, 171021991, "CC(remember):BiliGameCustomBottomSheet.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(offsetY);
            Object it$iv6 = $composer2.rememberedValue();
            if (!invalid$iv2 && it$iv6 != Composer.Companion.getEmpty()) {
                value$iv = it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier clip = ClipKt.clip(SizeKt.fillMaxWidth$default($this$GameCustomBottomSheet_u24lambda_u246.align(OffsetKt.offset(modifier5, (Function1) value$iv), Alignment.Companion.getBottomCenter()), 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(16), Dp.constructor-impl(16), 0.0f, 0.0f, 12, (Object) null));
                ComposerKt.sourceInformationMarkerStart($composer2, 171030227, "CC(remember):BiliGameCustomBottomSheet.kt#9igjgp");
                it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function1() { // from class: kntr.app.game.base.ui.widget.BiliGameCustomBottomSheetKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit GameCustomBottomSheet$lambda$6$1$0;
                            GameCustomBottomSheet$lambda$6$1$0 = BiliGameCustomBottomSheetKt.GameCustomBottomSheet$lambda$6$1$0(sheetBounds$delegate, (LayoutCoordinates) obj);
                            return GameCustomBottomSheet$lambda$6$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final Modifier modifier6 = modifier3;
                SurfaceKt.Surface-T9BRK9s(OnGloballyPositionedModifierKt.onGloballyPositioned(clip, (Function1) it$iv), (Shape) null, 0L, 0L, Dp.constructor-impl(8), 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(1825553952, true, new Function2() { // from class: kntr.app.game.base.ui.widget.BiliGameCustomBottomSheetKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit GameCustomBottomSheet$lambda$6$2;
                        GameCustomBottomSheet$lambda$6$2 = BiliGameCustomBottomSheetKt.GameCustomBottomSheet$lambda$6$2(modifier6, scope, offsetY, function0, maxOffset, function2, (Composer) obj, ((Integer) obj2).intValue());
                        return GameCustomBottomSheet$lambda$6$2;
                    }
                }, $composer2, 54), $composer2, 12607488, 110);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            value$iv = new Function1() { // from class: kntr.app.game.base.ui.widget.BiliGameCustomBottomSheetKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    IntOffset GameCustomBottomSheet$lambda$6$0$0;
                    GameCustomBottomSheet$lambda$6$0$0 = BiliGameCustomBottomSheetKt.GameCustomBottomSheet$lambda$6$0$0(offsetY, (Density) obj);
                    return GameCustomBottomSheet$lambda$6$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier clip2 = ClipKt.clip(SizeKt.fillMaxWidth$default($this$GameCustomBottomSheet_u24lambda_u246.align(OffsetKt.offset(modifier5, (Function1) value$iv), Alignment.Companion.getBottomCenter()), 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(16), Dp.constructor-impl(16), 0.0f, 0.0f, 12, (Object) null));
            ComposerKt.sourceInformationMarkerStart($composer2, 171030227, "CC(remember):BiliGameCustomBottomSheet.kt#9igjgp");
            it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Modifier modifier62 = modifier3;
            SurfaceKt.Surface-T9BRK9s(OnGloballyPositionedModifierKt.onGloballyPositioned(clip2, (Function1) it$iv), (Shape) null, 0L, 0L, Dp.constructor-impl(8), 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(1825553952, true, new Function2() { // from class: kntr.app.game.base.ui.widget.BiliGameCustomBottomSheetKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit GameCustomBottomSheet$lambda$6$2;
                    GameCustomBottomSheet$lambda$6$2 = BiliGameCustomBottomSheetKt.GameCustomBottomSheet$lambda$6$2(modifier62, scope, offsetY, function0, maxOffset, function2, (Composer) obj, ((Integer) obj2).intValue());
                    return GameCustomBottomSheet$lambda$6$2;
                }
            }, $composer2, 54), $composer2, 12607488, 110);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.base.ui.widget.BiliGameCustomBottomSheetKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit GameCustomBottomSheet$lambda$7;
                    GameCustomBottomSheet$lambda$7 = BiliGameCustomBottomSheetKt.GameCustomBottomSheet$lambda$7(function0, modifier7, function2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GameCustomBottomSheet$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect GameCustomBottomSheet$lambda$3(MutableState<Rect> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (Rect) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset GameCustomBottomSheet$lambda$6$0$0(Animatable $offsetY, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        int y$iv = MathKt.roundToInt(((Number) $offsetY.getValue()).floatValue());
        return IntOffset.box-impl(IntOffset.constructor-impl((0 << 32) | (y$iv & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameCustomBottomSheet$lambda$6$1$0(MutableState $sheetBounds$delegate, LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
        $sheetBounds$delegate.setValue(LayoutCoordinatesKt.boundsInRoot(layoutCoordinates));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x034d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit GameCustomBottomSheet$lambda$6$2(Modifier $modifier, CoroutineScope $scope, Animatable $offsetY, Function0 $onDismiss, float $maxOffset, Function2 $content, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        ComposerKt.sourceInformation($composer, "C79@3109L2163:BiliGameCustomBottomSheet.kt#kw4tct");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1825553952, $changed, -1, "kntr.app.game.base.ui.widget.GameCustomBottomSheet.<anonymous>.<anonymous> (BiliGameCustomBottomSheet.kt:79)");
            }
            Modifier modifier$iv$iv = Modifier.Companion.then($modifier);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i2 = ((0 >> 6) & 112) | 6;
            ColumnScope $this$GameCustomBottomSheet_u24lambda_u246_u242_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1932014241, "C90@3574L6,94@3831L1170,81@3196L1824,119@5068L190:BiliGameCustomBottomSheet.kt#kw4tct");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default($this$GameCustomBottomSheet_u24lambda_u246_u242_u240.align(BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(8), 1, (Object) null), Dp.constructor-impl(30), Dp.constructor-impl(3)), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBa0_s-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Alignment.Companion.getCenterHorizontally()), 0.0f, 1, (Object) null);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 76243720, "CC(remember):BiliGameCustomBottomSheet.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($offsetY) | $composer.changed($onDismiss);
            BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1 value$iv = $composer.rememberedValue();
            if (!invalid$iv && value$iv != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer);
                BoxKt.Box(SuspendingPointerInputFilterKt.pointerInput(fillMaxWidth$default, unit, (PointerInputEventHandler) value$iv), $composer, 0);
                Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(34), 7, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (6 << 3) & 112;
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
                if (!$composer.getInserting()) {
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
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i4 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -1294433177, "C124@5231L9:BiliGameCustomBottomSheet.kt#kw4tct");
                $content.invoke($composer, 0);
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
            }
            value$iv = new BiliGameCustomBottomSheetKt$GameCustomBottomSheet$2$3$1$1$1($scope, $offsetY, $maxOffset, $onDismiss);
            $composer.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            BoxKt.Box(SuspendingPointerInputFilterKt.pointerInput(fillMaxWidth$default, unit, (PointerInputEventHandler) value$iv), $composer, 0);
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(34), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv22 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv22 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv22 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv42 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
            }
            $composer.startReusableNode();
            if (!$composer.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
            int i32 = ($changed$iv$iv$iv22 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i42 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1294433177, "C124@5231L9:BiliGameCustomBottomSheet.kt#kw4tct");
            $content.invoke($composer, 0);
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
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}