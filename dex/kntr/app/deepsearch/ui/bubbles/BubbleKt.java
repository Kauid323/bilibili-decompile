package kntr.app.deepsearch.ui.bubbles;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
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
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import com.bapis.bilibili.app.dynamic.v2.KClickBubble;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.deepsearch.ui.DeepSearchPreview_androidKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Bubble.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\u001aW\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u008e\u0002"}, d2 = {"DSBubblePopup", RoomRecommendViewModel.EMPTY_CURSOR, "miniWindowMode", RoomRecommendViewModel.EMPTY_CURSOR, "showBubble", "onDismiss", "Lkotlin/Function0;", "anchorBounds", "Landroidx/compose/ui/geometry/Rect;", "offset", "Landroidx/compose/ui/geometry/Offset;", "bubbleMsg", "Lcom/bapis/bilibili/app/dynamic/v2/KClickBubble;", "onLinkClick", "DSBubblePopup-tZEomGk", "(ZZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/geometry/Rect;JLcom/bapis/bilibili/app/dynamic/v2/KClickBubble;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "compose_debug", "arrowOffsetX", RoomRecommendViewModel.EMPTY_CURSOR, "offsetY", "contentSize", "Landroidx/compose/ui/unit/IntSize;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BubbleKt {

    /* compiled from: Bubble.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArrowDirection.values().length];
            try {
                iArr[ArrowDirection.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ArrowDirection.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DSBubblePopup_tZEomGk$lambda$13(boolean z, boolean z2, Function0 function0, Rect rect, long j2, KClickBubble kClickBubble, Function0 function02, int i, Composer composer, int i2) {
        m703DSBubblePopuptZEomGk(z, z2, function0, rect, j2, kClickBubble, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* renamed from: DSBubblePopup-tZEomGk  reason: not valid java name */
    public static final void m703DSBubblePopuptZEomGk(final boolean miniWindowMode, final boolean showBubble, final Function0<Unit> function0, final Rect anchorBounds, final long j2, final KClickBubble bubbleMsg, final Function0<Unit> function02, Composer $composer, final int $changed) {
        int $dirty;
        Composer $composer2;
        int $dirty2;
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Intrinsics.checkNotNullParameter(function02, "onLinkClick");
        Composer $composer3 = $composer.startRestartGroup(-78059918);
        ComposerKt.sourceInformation($composer3, "C(DSBubblePopup)N(miniWindowMode,showBubble,onDismiss,anchorBounds,offset:c#ui.geometry.Offset,bubbleMsg,onLinkClick)67@2763L36,68@2819L36,69@2879L41,70@2952L7,77@3081L10,89@3352L12:Bubble.kt#tq2nzn");
        int $dirty3 = $changed;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed(miniWindowMode) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changed(showBubble) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty3 |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty3 |= $composer3.changed(anchorBounds) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty3 |= $composer3.changed(j2) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty3 |= $composer3.changedInstance(bubbleMsg) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty3 |= $composer3.changedInstance(function02) ? 1048576 : 524288;
        }
        if (!$composer3.shouldExecute((599187 & $dirty3) != 599186, $dirty3 & 1)) {
            $dirty = $dirty3;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-78059918, $dirty3, -1, "kntr.app.deepsearch.ui.bubbles.DSBubblePopup (Bubble.kt:66)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -2001129706, "CC(remember):Bubble.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableFloatState arrowOffsetX$delegate = (MutableFloatState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -2001127914, "CC(remember):Bubble.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableFloatState offsetY$delegate = (MutableFloatState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -2001125989, "CC(remember):Bubble.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                $dirty2 = $dirty3;
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            } else {
                $dirty2 = $dirty3;
            }
            final MutableState contentSize$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Density density = (Density) consume;
            final float contentHeight = density.toPx-0680j_4(Dp.constructor-impl(50));
            int statusHeight = WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer3, 6).getTop(density);
            final float minBubbleNeedHeight = density.toPx-0680j_4(Dp.constructor-impl(94)) + (!miniWindowMode ? statusHeight : 0);
            final float leftBound = density.toPx-0680j_4(Dp.constructor-impl(16));
            final int windowY = DeepSearchPreview_androidKt.getWindowY($composer3, 0);
            if (!showBubble || anchorBounds == null || bubbleMsg == null) {
                $composer2 = $composer3;
                $dirty = $dirty2;
                $composer2.startReplaceGroup(-1908221744);
            } else {
                $composer3.startReplaceGroup(-1904635075);
                ComposerKt.sourceInformation($composer3, "98@3705L5595,95@3586L5714");
                int bits$iv$iv$iv = (int) (j2 >> 32);
                int bits$iv$iv$iv2 = (int) (j2 & 4294967295L);
                final Rect anchor = anchorBounds.translate(Float.intBitsToFloat(bits$iv$iv$iv), Float.intBitsToFloat(bits$iv$iv$iv2));
                final float targetPos = anchor.getLeft();
                final float availableSpaceAbove = anchor.getTop();
                $composer2 = $composer3;
                $dirty = $dirty2;
                AndroidPopup_androidKt.Popup-K5zGePQ((Alignment) null, 0L, function0, new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-991046966, true, new Function2() { // from class: kntr.app.deepsearch.ui.bubbles.BubbleKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj, Object obj2) {
                        Unit DSBubblePopup_tZEomGk$lambda$12;
                        DSBubblePopup_tZEomGk$lambda$12 = BubbleKt.DSBubblePopup_tZEomGk$lambda$12(function0, offsetY$delegate, targetPos, density, availableSpaceAbove, minBubbleNeedHeight, anchor, contentHeight, miniWindowMode, windowY, leftBound, contentSize$delegate, arrowOffsetX$delegate, bubbleMsg, function02, (Composer) obj, ((Integer) obj2).intValue());
                        return DSBubblePopup_tZEomGk$lambda$12;
                    }
                }, $composer2, 54), $composer2, ($dirty & 896) | 27648, 3);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.bubbles.BubbleKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit DSBubblePopup_tZEomGk$lambda$13;
                    DSBubblePopup_tZEomGk$lambda$13 = BubbleKt.DSBubblePopup_tZEomGk$lambda$13(miniWindowMode, showBubble, function0, anchorBounds, j2, bubbleMsg, function02, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return DSBubblePopup_tZEomGk$lambda$13;
                }
            });
        }
    }

    private static final float DSBubblePopup_tZEomGk$lambda$1(MutableFloatState $arrowOffsetX$delegate) {
        FloatState $this$getValue$iv = (FloatState) $arrowOffsetX$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    private static final float DSBubblePopup_tZEomGk$lambda$4(MutableFloatState $offsetY$delegate) {
        FloatState $this$getValue$iv = (FloatState) $offsetY$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    private static final long DSBubblePopup_tZEomGk$lambda$7(MutableState<IntSize> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((IntSize) $this$getValue$iv.getValue()).unbox-impl();
    }

    private static final void DSBubblePopup_tZEomGk$lambda$8(MutableState<IntSize> mutableState, long j2) {
        Object value$iv = IntSize.box-impl(j2);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DSBubblePopup_tZEomGk$lambda$12(Function0 $onDismiss, final MutableFloatState $offsetY$delegate, final float $targetPos, final Density $density, final float $availableSpaceAbove, final float $minBubbleNeedHeight, final Rect $anchor, final float $contentHeight, final boolean $miniWindowMode, final int $windowY, final float $leftBound, final MutableState $contentSize$delegate, final MutableFloatState $arrowOffsetX$delegate, final KClickBubble $bubbleMsg, final Function0 $onLinkClick, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C104@3933L89,106@4044L97,109@4157L5133,99@3719L5571:Bubble.kt#tq2nzn");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-991046966, $changed, -1, "kntr.app.deepsearch.ui.bubbles.DSBubblePopup.<anonymous> (Bubble.kt:99)");
            }
            Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.Companion.getTransparent-0d7_KjU(), (Shape) null, 2, (Object) null);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1086612771, "CC(remember):Bubble.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onDismiss);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (PointerInputEventHandler) new BubbleKt$DSBubblePopup$1$1$1($onDismiss);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier, unit, (PointerInputEventHandler) it$iv);
            ComposerKt.sourceInformationMarkerStart($composer, 1086616331, "CC(remember):Bubble.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.deepsearch.ui.bubbles.BubbleKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit DSBubblePopup_tZEomGk$lambda$12$1$0;
                        DSBubblePopup_tZEomGk$lambda$12$1$0 = BubbleKt.DSBubblePopup_tZEomGk$lambda$12$1$0($offsetY$delegate, (LayoutCoordinates) obj);
                        return DSBubblePopup_tZEomGk$lambda$12$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            BoxWithConstraintsKt.BoxWithConstraints(OnGloballyPositionedModifierKt.onGloballyPositioned(pointerInput, (Function1) it$iv2), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(-1202504908, true, new Function3() { // from class: kntr.app.deepsearch.ui.bubbles.BubbleKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit DSBubblePopup_tZEomGk$lambda$12$2;
                    DSBubblePopup_tZEomGk$lambda$12$2 = BubbleKt.DSBubblePopup_tZEomGk$lambda$12$2($targetPos, $density, $availableSpaceAbove, $minBubbleNeedHeight, $anchor, $contentHeight, $miniWindowMode, $windowY, $leftBound, $offsetY$delegate, $contentSize$delegate, $arrowOffsetX$delegate, $bubbleMsg, $onLinkClick, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return DSBubblePopup_tZEomGk$lambda$12$2;
                }
            }, $composer, 54), $composer, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DSBubblePopup_tZEomGk$lambda$12$1$0(MutableFloatState $offsetY$delegate, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        int bits$iv$iv$iv = (int) (4294967295L & it.localToScreen-MK-Hz9U(Offset.Companion.getZero-F1C5BW0()));
        $offsetY$delegate.setFloatValue(Float.intBitsToFloat(bits$iv$iv$iv));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DSBubblePopup_tZEomGk$lambda$12$2(final float $targetPos, Density $density, float $availableSpaceAbove, float $minBubbleNeedHeight, final Rect $anchor, final float $contentHeight, final boolean $miniWindowMode, final int $windowY, final float $leftBound, final MutableFloatState $offsetY$delegate, final MutableState $contentSize$delegate, final MutableFloatState $arrowOffsetX$delegate, final KClickBubble $bubbleMsg, final Function0 $onLinkClick, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        ArrowDirection arrowDirection;
        Object value$iv;
        Modifier modifier;
        ArrowDirection arrowDirection2;
        String str;
        int i;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C129@4829L1414,150@6258L20,126@4724L4552:Bubble.kt#tq2nzn");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1202504908, $dirty2, -1, "kntr.app.deepsearch.ui.bubbles.DSBubblePopup.<anonymous>.<anonymous> (Bubble.kt:110)");
            }
            final int screenWidth = Constraints.getMaxWidth-impl($this$BoxWithConstraints.getConstraints-msEJaDk());
            int center = screenWidth / 2;
            final int distance = (int) ($targetPos - center);
            final float rightBound = screenWidth - $density.toPx-0680j_4(Dp.constructor-impl(16));
            if ($availableSpaceAbove >= $minBubbleNeedHeight) {
                arrowDirection = ArrowDirection.DOWN;
            } else {
                arrowDirection = ArrowDirection.UP;
            }
            final ArrowDirection arrowDirection3 = arrowDirection;
            Modifier modifier2 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, -260991046, "CC(remember):Bubble.kt#9igjgp");
            boolean invalid$iv = $composer.changed(arrowDirection3.ordinal()) | $composer.changed($anchor) | $composer.changed($contentHeight) | $composer.changed($miniWindowMode) | $composer.changed($windowY) | $composer.changed(screenWidth) | $composer.changed(distance) | $composer.changed($leftBound) | $composer.changed(rightBound) | $composer.changed($targetPos);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                modifier = modifier2;
                arrowDirection2 = arrowDirection3;
                str = "CC(remember):Bubble.kt#9igjgp";
                i = 0;
                value$iv = new Function1() { // from class: kntr.app.deepsearch.ui.bubbles.BubbleKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        IntOffset DSBubblePopup_tZEomGk$lambda$12$2$1$0;
                        DSBubblePopup_tZEomGk$lambda$12$2$1$0 = BubbleKt.DSBubblePopup_tZEomGk$lambda$12$2$1$0(ArrowDirection.this, $anchor, $contentHeight, $miniWindowMode, $windowY, screenWidth, distance, $leftBound, rightBound, $targetPos, $offsetY$delegate, $contentSize$delegate, $arrowOffsetX$delegate, (Density) obj);
                        return DSBubblePopup_tZEomGk$lambda$12$2$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                str = "CC(remember):Bubble.kt#9igjgp";
                modifier = modifier2;
                arrowDirection2 = arrowDirection3;
                i = 0;
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier offset = OffsetKt.offset(modifier, (Function1) value$iv);
            ComposerKt.sourceInformationMarkerStart($composer, -260946712, str);
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.deepsearch.ui.bubbles.BubbleKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit DSBubblePopup_tZEomGk$lambda$12$2$2$0;
                        DSBubblePopup_tZEomGk$lambda$12$2$2$0 = BubbleKt.DSBubblePopup_tZEomGk$lambda$12$2$2$0($contentSize$delegate, (IntSize) obj);
                        return DSBubblePopup_tZEomGk$lambda$12$2$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = OnRemeasuredModifierKt.onSizeChanged(offset, (Function1) it$iv2);
            int $changed$iv = i;
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, i));
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
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i3 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1953665701, "C159@6627L6,161@6709L2549,154@6411L2847:Bubble.kt#tq2nzn");
            final ArrowDirection arrowDirection4 = arrowDirection2;
            DsBubbleShape bubbleShape = new DsBubbleShape(arrowDirection4, (int) DSBubblePopup_tZEomGk$lambda$1($arrowOffsetX$delegate));
            SurfaceKt.Surface-T9BRK9s(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(50)), bubbleShape, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), 0L, 0.0f, Dp.constructor-impl(4), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(310062451, true, new Function2() { // from class: kntr.app.deepsearch.ui.bubbles.BubbleKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit DSBubblePopup_tZEomGk$lambda$12$2$3$0;
                    DSBubblePopup_tZEomGk$lambda$12$2$3$0 = BubbleKt.DSBubblePopup_tZEomGk$lambda$12$2$3$0(ArrowDirection.this, $bubbleMsg, $onLinkClick, (Composer) obj, ((Integer) obj2).intValue());
                    return DSBubblePopup_tZEomGk$lambda$12$2$3$0;
                }
            }, $composer, 54), $composer, 12779526, 88);
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
    public static final IntOffset DSBubblePopup_tZEomGk$lambda$12$2$1$0(ArrowDirection $arrowDirection, Rect $anchor, float $contentHeight, boolean $miniWindowMode, int $windowY, int $screenWidth, int $distance, float $leftBound, float $rightBound, float $targetPos, MutableFloatState $offsetY$delegate, MutableState $contentSize$delegate, MutableFloatState $arrowOffsetX$delegate, Density $this$offset) {
        int y;
        long j2;
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        switch (WhenMappings.$EnumSwitchMapping$0[$arrowDirection.ordinal()]) {
            case 1:
                y = (int) Math.max($anchor.getBottom(), 0.0f);
                break;
            case 2:
                y = (int) ($anchor.getTop() - $contentHeight);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        int y2 = ((int) (y - DSBubblePopup_tZEomGk$lambda$4($offsetY$delegate))) + ($miniWindowMode ? $windowY : 0);
        int x = ($screenWidth - ((int) (DSBubblePopup_tZEomGk$lambda$7($contentSize$delegate) >> 32))) / RangesKt.coerceAtLeast(2, 0);
        if (x + $distance <= $leftBound || x + $distance + ((int) (DSBubblePopup_tZEomGk$lambda$7($contentSize$delegate) >> 32)) >= $rightBound) {
            if (x + $distance < $leftBound) {
                $arrowOffsetX$delegate.setFloatValue($targetPos - ((((int) (DSBubblePopup_tZEomGk$lambda$7($contentSize$delegate) >> 32)) / 2) + $leftBound));
                int x$iv = (int) $leftBound;
                j2 = IntOffset.constructor-impl((x$iv << 32) | (y2 & 4294967295L));
            } else {
                $arrowOffsetX$delegate.setFloatValue($targetPos - ($rightBound - (((int) (DSBubblePopup_tZEomGk$lambda$7($contentSize$delegate) >> 32)) / 2)));
                int x$iv2 = (int) ($rightBound - ((int) (DSBubblePopup_tZEomGk$lambda$7($contentSize$delegate) >> 32)));
                j2 = IntOffset.constructor-impl((x$iv2 << 32) | (y2 & 4294967295L));
            }
        } else {
            $arrowOffsetX$delegate.setFloatValue(0.0f);
            int x$iv3 = x + $distance;
            j2 = IntOffset.constructor-impl((x$iv3 << 32) | (y2 & 4294967295L));
        }
        return IntOffset.box-impl(j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DSBubblePopup_tZEomGk$lambda$12$2$2$0(MutableState $contentSize$delegate, IntSize it) {
        DSBubblePopup_tZEomGk$lambda$8($contentSize$delegate, it.unbox-impl());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DSBubblePopup_tZEomGk$lambda$12$2$3$0(ArrowDirection $arrowDirection, KClickBubble $bubbleMsg, Function0 $onLinkClick, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        ComposerKt.sourceInformation($composer, "C162@6735L2501:Bubble.kt#tq2nzn");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(310062451, $changed, -1, "kntr.app.deepsearch.ui.bubbles.DSBubblePopup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Bubble.kt:162)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0(SizeKt.fillMaxHeight$default(SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(300), 1, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(12), $arrowDirection == ArrowDirection.DOWN ? Dp.constructor-impl(8) : Dp.constructor-impl(18), Dp.constructor-impl(12), $arrowDirection == ArrowDirection.DOWN ? Dp.constructor-impl(18) : Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
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
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i2 = ((384 >> 6) & 112) | 6;
            RowScope $this$DSBubblePopup_tZEomGk_u24lambda_u2412_u242_u243_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 11152770, "C177@7583L9,178@7648L6,175@7472L561,187@8063L28,189@8121L1089:Bubble.kt#tq2nzn");
            TextKt.Text-Nvy7gAk($bubbleMsg.getText(), SizeKt.wrapContentWidth$default($this$DSBubblePopup_tZEomGk_u24lambda_u2412_u242_u243_u240_u240.weight(Modifier.Companion, 1.0f, false), Alignment.Companion.getStart(), false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13(), $composer, 0, 24960, 110584);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer, 6);
            Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(1), 0.0f, Dp.constructor-impl(1), 5, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, $onLinkClick, 15, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
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
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1236658199, "C198@8630L6,199@8702L9,196@8509L241,202@8784L28,204@8846L334:Bubble.kt#tq2nzn");
            TextKt.Text-Nvy7gAk($bubbleMsg.getButton(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_link-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, 0, 0, 131066);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer, 6);
            String $this$asRequest$iv = $bubbleMsg.getIcon();
            BiliImageKt.BiliImage(new ImageRequest($this$asRequest$iv).build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(13)), Dp.constructor-impl(17)), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer, 48, 508);
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
        return Unit.INSTANCE;
    }
}