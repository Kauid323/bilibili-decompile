package kntr.app.im.chat.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TransitionState;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.ScaffoldKt;
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
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: PopupBubbleMenu.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001ap\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\u0002\b\u0018H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001aP\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001c\u001a\u00020\u00032\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00060\u001e¢\u0006\u0002\b\"H\u0003¢\u0006\u0002\u0010#\u001az\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\t\u001a\u00020\n2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b+\u0010,\u001ad\u0010-\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020\u00060\u001e¢\u0006\u0002\b\"2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020(2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0002\u00101\u001a\r\u00102\u001a\u00020\u0006H\u0007¢\u0006\u0002\u00103¨\u00064²\u0006\n\u00105\u001a\u000206X\u008a\u0084\u0002²\u0006\n\u00107\u001a\u000206X\u008a\u0084\u0002²\u0006\n\u00108\u001a\u00020\u0003X\u008a\u0084\u0002²\u0006\n\u00109\u001a\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"rememberPopupState", "Lkntr/app/im/chat/ui/widget/PopupState;", "isVisible", RoomRecommendViewModel.EMPTY_CURSOR, "(ZLandroidx/compose/runtime/Composer;II)Lkntr/app/im/chat/ui/widget/PopupState;", "PopupBubbleMenuContent", RoomRecommendViewModel.EMPTY_CURSOR, "expandedStates", "Landroidx/compose/animation/core/MutableTransitionState;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "arrowOffsetX", "Landroidx/compose/ui/unit/Dp;", "isAlignToTop", "colors", "Lkntr/app/im/chat/ui/widget/PopupBubbleMenuColors;", "shadowElevation", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "PopupBubbleMenuContent-NGHgvGo", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/foundation/lazy/LazyListState;JFZLkntr/app/im/chat/ui/widget/PopupBubbleMenuColors;FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "PopupBubbleMenuArrowButton", "enabled", "onClick", "Lkotlin/Function0;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "icon", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PopupBubbleMenu", "popupState", "onDismissRequest", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "PopupBubbleMenu-gNPyAyM", "(Lkntr/app/im/chat/ui/widget/PopupState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkntr/app/im/chat/ui/widget/PopupBubbleMenuColors;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/window/PopupProperties;Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "PopupBubbleMenuItem", "text", "indication", "Landroidx/compose/foundation/Indication;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/Indication;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "PopUpBubbleMenuPreview", "(Landroidx/compose/runtime/Composer;I)V", "ui_debug", "scale", RoomRecommendViewModel.EMPTY_CURSOR, "alpha", "isShowLeftArrowButton", "isShowRightArrowButton"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PopupBubbleMenuKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopUpBubbleMenuPreview$lambda$0(int i, Composer composer, int i2) {
        PopUpBubbleMenuPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupBubbleMenuArrowButton$lambda$2(Modifier modifier, boolean z, Function0 function0, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        PopupBubbleMenuArrowButton(modifier, z, function0, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupBubbleMenuContent_NGHgvGo$lambda$8(MutableTransitionState mutableTransitionState, LazyListState lazyListState, long j2, float f, boolean z, PopupBubbleMenuColors popupBubbleMenuColors, float f2, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        m1978PopupBubbleMenuContentNGHgvGo(mutableTransitionState, lazyListState, j2, f, z, popupBubbleMenuColors, f2, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupBubbleMenuItem$lambda$1(Function0 function0, Function2 function2, Modifier modifier, boolean z, PaddingValues paddingValues, Indication indication, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        PopupBubbleMenuItem(function0, function2, modifier, z, paddingValues, indication, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupBubbleMenu_gNPyAyM$lambda$3(PopupState popupState, Function0 function0, Modifier modifier, PopupBubbleMenuColors popupBubbleMenuColors, float f, PaddingValues paddingValues, PopupProperties popupProperties, LazyListState lazyListState, Function1 function1, int i, int i2, Composer composer, int i3) {
        m1977PopupBubbleMenugNPyAyM(popupState, function0, modifier, popupBubbleMenuColors, f, paddingValues, popupProperties, lazyListState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final PopupState rememberPopupState(final boolean isVisible, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 804046908, "C(rememberPopupState)N(isVisible)160@6302L37,160@6259L80:PopupBubbleMenu.kt#92mklk");
        boolean invalid$iv = true;
        if ((i & 1) != 0) {
            isVisible = false;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(804046908, $changed, -1, "kntr.app.im.chat.ui.widget.rememberPopupState (PopupBubbleMenu.kt:160)");
        }
        Object[] objArr = new Object[0];
        Saver<PopupState, Map<String, Object>> saver = PopupState.Companion.getSaver();
        ComposerKt.sourceInformationMarkerStart($composer, -405031071, "CC(remember):PopupBubbleMenu.kt#9igjgp");
        if (((($changed & 14) ^ 6) <= 4 || !$composer.changed(isVisible)) && ($changed & 6) != 4) {
            invalid$iv = false;
        }
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda5
                public final Object invoke() {
                    PopupState rememberPopupState$lambda$0$0;
                    rememberPopupState$lambda$0$0 = PopupBubbleMenuKt.rememberPopupState$lambda$0$0(isVisible);
                    return rememberPopupState$lambda$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        PopupState popupState = (PopupState) RememberSaveableKt.rememberSaveable(objArr, saver, (Function0) it$iv, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return popupState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PopupState rememberPopupState$lambda$0$0(boolean $isVisible) {
        return new PopupState($isVisible);
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x0194, code lost:
        if (r9.changed(r7) == false) goto L251;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0406  */
    /* renamed from: PopupBubbleMenuContent-NGHgvGo  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m1978PopupBubbleMenuContentNGHgvGo(final MutableTransitionState<Boolean> mutableTransitionState, final LazyListState lazyListState, final long j2, final float f, final boolean isAlignToTop, final PopupBubbleMenuColors colors, final float f2, Modifier modifier, final Function1<? super LazyListScope, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Transition $this$animateValue$iv$iv;
        Object it$iv$iv$iv;
        int $dirty;
        final Transition $this$animateValue$iv$iv2;
        Object it$iv$iv$iv2;
        Modifier modifier3;
        boolean z;
        boolean invalid$iv$iv$iv;
        boolean invalid$iv$iv$iv2;
        Snapshot.Companion this_$iv$iv$iv;
        Snapshot previousSnapshot$iv$iv$iv;
        Function1 observer$iv$iv$iv;
        Snapshot newSnapshot$iv$iv$iv;
        boolean invalid$iv$iv$iv3;
        boolean invalid$iv$iv$iv4;
        Snapshot.Companion this_$iv$iv$iv2;
        Snapshot previousSnapshot$iv$iv$iv2;
        Function1 observer$iv$iv$iv2;
        Snapshot newSnapshot$iv$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(-163917443);
        ComposerKt.sourceInformation($composer2, "C(PopupBubbleMenuContent)N(expandedStates,lazyListState,transformOrigin:c#ui.graphics.TransformOrigin,arrowOffsetX:c#ui.unit.Dp,isAlignToTop,colors,shadowElevation:c#ui.unit.Dp,modifier,content)550@19566L43,551@19638L524,576@20192L397,597@20658L461,611@21166L4797,595@20595L5368:PopupBubbleMenu.kt#92mklk");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= ($changed & 8) == 0 ? $composer2.changed(mutableTransitionState) : $composer2.changedInstance(mutableTransitionState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(lazyListState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(j2) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(f) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changed(isAlignToTop) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer2.changed(colors) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer2.changed(f2) ? 1048576 : 524288;
        }
        int i2 = i & 128;
        if (i2 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 67108864 : 33554432;
        }
        if ($composer2.shouldExecute(($dirty2 & 38347923) != 38347922, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-163917443, $dirty2, -1, "kntr.app.im.chat.ui.widget.PopupBubbleMenuContent (PopupBubbleMenu.kt:549)");
            }
            Modifier modifier5 = modifier4;
            Transition transition = TransitionKt.rememberTransition((TransitionState) mutableTransitionState, "Popup", $composer2, MutableTransitionState.$stable | 48 | ($dirty2 & 14), 0);
            Function3 transitionSpec$iv = new Function3() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    FiniteAnimationSpec PopupBubbleMenuContent_NGHgvGo$lambda$0;
                    PopupBubbleMenuContent_NGHgvGo$lambda$0 = PopupBubbleMenuKt.PopupBubbleMenuContent_NGHgvGo$lambda$0((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PopupBubbleMenuContent_NGHgvGo$lambda$0;
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, 844118987, "CC(animateFloat)N(transitionSpec,label,targetValueByState)1951@83597L78:Transition.kt#pdpnli");
            TwoWayConverter typeConverter$iv$iv = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
            ComposerKt.sourceInformationMarkerStart($composer2, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
            if (transition.isSeeking()) {
                $this$animateValue$iv$iv = transition;
                $composer2.startReplaceGroup(1666827533);
                $composer2.endReplaceGroup();
                it$iv$iv$iv = $this$animateValue$iv$iv.getCurrentState();
            } else {
                $composer2.startReplaceGroup(1666573488);
                ComposerKt.sourceInformation($composer2, "1844@78495L67");
                ComposerKt.sourceInformationMarkerStart($composer2, -1054612652, "CC(remember):Transition.kt#9igjgp");
                if ((($changed$iv$iv & 14) ^ 6) > 4) {
                    $this$animateValue$iv$iv = transition;
                } else {
                    $this$animateValue$iv$iv = transition;
                }
                try {
                    if (($changed$iv$iv & 6) != 4) {
                        invalid$iv$iv$iv3 = false;
                        invalid$iv$iv$iv4 = invalid$iv$iv$iv3;
                        it$iv$iv$iv = $composer2.rememberedValue();
                        if (!invalid$iv$iv$iv4 || it$iv$iv$iv == Composer.Companion.getEmpty()) {
                            this_$iv$iv$iv2 = Snapshot.Companion;
                            previousSnapshot$iv$iv$iv2 = this_$iv$iv$iv2.getCurrentThreadSnapshot();
                            observer$iv$iv$iv2 = previousSnapshot$iv$iv$iv2 == null ? previousSnapshot$iv$iv$iv2.getReadObserver() : null;
                            newSnapshot$iv$iv$iv2 = this_$iv$iv$iv2.makeCurrentNonObservable(previousSnapshot$iv$iv$iv2);
                            Object value$iv$iv$iv = $this$animateValue$iv$iv.getCurrentState();
                            this_$iv$iv$iv2.restoreNonObservable(previousSnapshot$iv$iv$iv2, newSnapshot$iv$iv$iv2, observer$iv$iv$iv2);
                            $composer2.updateRememberedValue(value$iv$iv$iv);
                            it$iv$iv$iv = value$iv$iv$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                    }
                    Object value$iv$iv$iv2 = $this$animateValue$iv$iv.getCurrentState();
                    this_$iv$iv$iv2.restoreNonObservable(previousSnapshot$iv$iv$iv2, newSnapshot$iv$iv$iv2, observer$iv$iv$iv2);
                    $composer2.updateRememberedValue(value$iv$iv$iv2);
                    it$iv$iv$iv = value$iv$iv$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceGroup();
                } catch (Throwable th) {
                    this_$iv$iv$iv2.restoreNonObservable(previousSnapshot$iv$iv$iv2, newSnapshot$iv$iv$iv2, observer$iv$iv$iv2);
                    throw th;
                }
                invalid$iv$iv$iv3 = true;
                invalid$iv$iv$iv4 = invalid$iv$iv$iv3;
                it$iv$iv$iv = $composer2.rememberedValue();
                if (!invalid$iv$iv$iv4) {
                }
                this_$iv$iv$iv2 = Snapshot.Companion;
                previousSnapshot$iv$iv$iv2 = this_$iv$iv$iv2.getCurrentThreadSnapshot();
                observer$iv$iv$iv2 = previousSnapshot$iv$iv$iv2 == null ? previousSnapshot$iv$iv$iv2.getReadObserver() : null;
                newSnapshot$iv$iv$iv2 = this_$iv$iv$iv2.makeCurrentNonObservable(previousSnapshot$iv$iv$iv2);
            }
            Object initialState$iv$iv = it$iv$iv$iv;
            int $changed2 = ($changed$iv$iv >> 9) & 112;
            boolean it = ((Boolean) initialState$iv$iv).booleanValue();
            $composer2.startReplaceGroup(-350345575);
            ComposerKt.sourceInformation($composer2, "CN(it):PopupBubbleMenu.kt#92mklk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-350345575, $changed2, -1, "kntr.app.im.chat.ui.widget.PopupBubbleMenuContent.<anonymous> (PopupBubbleMenu.kt:567)");
            }
            float f3 = it ? 1.0f : 0.3f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object initialValue$iv$iv = Float.valueOf(f3);
            ComposerKt.sourceInformationMarkerStart($composer2, -1054592958, "CC(remember):Transition.kt#9igjgp");
            boolean invalid$iv$iv$iv5 = ((($changed$iv$iv & 14) ^ 6) > 4 && $composer2.changed($this$animateValue$iv$iv)) || ($changed$iv$iv & 6) == 4;
            Object it$iv$iv$iv3 = $composer2.rememberedValue();
            if (invalid$iv$iv$iv5 || it$iv$iv$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv$iv$iv3 = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$PopupBubbleMenuContent-NGHgvGo$$inlined$animateFloat$1
                    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Boolean, java.lang.Object] */
                    public final Boolean invoke() {
                        return $this$animateValue$iv$iv.getTargetState();
                    }
                });
                $composer2.updateRememberedValue(value$iv$iv$iv3);
                it$iv$iv$iv3 = value$iv$iv$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed3 = ($changed$iv$iv >> 9) & 112;
            boolean it2 = ((Boolean) ((State) it$iv$iv$iv3).getValue()).booleanValue();
            $composer2.startReplaceGroup(-350345575);
            ComposerKt.sourceInformation($composer2, "CN(it):PopupBubbleMenu.kt#92mklk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-350345575, $changed3, -1, "kntr.app.im.chat.ui.widget.PopupBubbleMenuContent.<anonymous> (PopupBubbleMenu.kt:567)");
            }
            float f4 = it2 ? 1.0f : 0.3f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object targetValue$iv$iv = Float.valueOf(f4);
            ComposerKt.sourceInformationMarkerStart($composer2, -1054589890, "CC(remember):Transition.kt#9igjgp");
            boolean invalid$iv$iv$iv6 = ((($changed$iv$iv & 14) ^ 6) > 4 && $composer2.changed($this$animateValue$iv$iv)) || ($changed$iv$iv & 6) == 4;
            Object it$iv$iv$iv4 = $composer2.rememberedValue();
            if (invalid$iv$iv$iv6 || it$iv$iv$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv$iv$iv4 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<Boolean>>() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$PopupBubbleMenuContent-NGHgvGo$$inlined$animateFloat$2
                    /* renamed from: invoke */
                    public final Transition.Segment<Boolean> m1979invoke() {
                        return $this$animateValue$iv$iv.getSegment();
                    }
                });
                $composer2.updateRememberedValue(value$iv$iv$iv4);
                it$iv$iv$iv4 = value$iv$iv$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            FiniteAnimationSpec animationSpec$iv$iv = (FiniteAnimationSpec) transitionSpec$iv.invoke(((State) it$iv$iv$iv4).getValue(), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            final State scale$delegate = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv, initialValue$iv$iv, targetValue$iv$iv, animationSpec$iv$iv, typeConverter$iv$iv, "Popup Scale", $composer2, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function3 transitionSpec$iv2 = new Function3() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    FiniteAnimationSpec PopupBubbleMenuContent_NGHgvGo$lambda$3;
                    PopupBubbleMenuContent_NGHgvGo$lambda$3 = PopupBubbleMenuKt.PopupBubbleMenuContent_NGHgvGo$lambda$3((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PopupBubbleMenuContent_NGHgvGo$lambda$3;
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, 844118987, "CC(animateFloat)N(transitionSpec,label,targetValueByState)1951@83597L78:Transition.kt#pdpnli");
            TwoWayConverter typeConverter$iv$iv2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv2 = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
            ComposerKt.sourceInformationMarkerStart($composer2, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
            if (transition.isSeeking()) {
                $dirty = $dirty2;
                $this$animateValue$iv$iv2 = transition;
                $composer2.startReplaceGroup(1666827533);
                $composer2.endReplaceGroup();
                it$iv$iv$iv2 = $this$animateValue$iv$iv2.getCurrentState();
            } else {
                $composer2.startReplaceGroup(1666573488);
                ComposerKt.sourceInformation($composer2, "1844@78495L67");
                ComposerKt.sourceInformationMarkerStart($composer2, -1054612652, "CC(remember):Transition.kt#9igjgp");
                try {
                    if ((($changed$iv$iv2 & 14) ^ 6) > 4) {
                        $this$animateValue$iv$iv2 = transition;
                        if ($composer2.changed($this$animateValue$iv$iv2)) {
                            invalid$iv$iv$iv = true;
                            invalid$iv$iv$iv2 = invalid$iv$iv$iv;
                            it$iv$iv$iv2 = $composer2.rememberedValue();
                            if (!invalid$iv$iv$iv2 || it$iv$iv$iv2 == Composer.Companion.getEmpty()) {
                                this_$iv$iv$iv = Snapshot.Companion;
                                previousSnapshot$iv$iv$iv = this_$iv$iv$iv.getCurrentThreadSnapshot();
                                observer$iv$iv$iv = previousSnapshot$iv$iv$iv != null ? previousSnapshot$iv$iv$iv.getReadObserver() : null;
                                newSnapshot$iv$iv$iv = this_$iv$iv$iv.makeCurrentNonObservable(previousSnapshot$iv$iv$iv);
                                Object value$iv$iv$iv5 = $this$animateValue$iv$iv2.getCurrentState();
                                $dirty = $dirty2;
                                this_$iv$iv$iv.restoreNonObservable(previousSnapshot$iv$iv$iv, newSnapshot$iv$iv$iv, observer$iv$iv$iv);
                                $composer2.updateRememberedValue(value$iv$iv$iv5);
                                it$iv$iv$iv2 = value$iv$iv$iv5;
                            } else {
                                $dirty = $dirty2;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endReplaceGroup();
                        }
                    } else {
                        $this$animateValue$iv$iv2 = transition;
                    }
                    if (($changed$iv$iv2 & 6) != 4) {
                        invalid$iv$iv$iv = false;
                        invalid$iv$iv$iv2 = invalid$iv$iv$iv;
                        it$iv$iv$iv2 = $composer2.rememberedValue();
                        if (invalid$iv$iv$iv2) {
                        }
                        this_$iv$iv$iv = Snapshot.Companion;
                        previousSnapshot$iv$iv$iv = this_$iv$iv$iv.getCurrentThreadSnapshot();
                        observer$iv$iv$iv = previousSnapshot$iv$iv$iv != null ? previousSnapshot$iv$iv$iv.getReadObserver() : null;
                        newSnapshot$iv$iv$iv = this_$iv$iv$iv.makeCurrentNonObservable(previousSnapshot$iv$iv$iv);
                        Object value$iv$iv$iv52 = $this$animateValue$iv$iv2.getCurrentState();
                        $dirty = $dirty2;
                        this_$iv$iv$iv.restoreNonObservable(previousSnapshot$iv$iv$iv, newSnapshot$iv$iv$iv, observer$iv$iv$iv);
                        $composer2.updateRememberedValue(value$iv$iv$iv52);
                        it$iv$iv$iv2 = value$iv$iv$iv52;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                    }
                    Object value$iv$iv$iv522 = $this$animateValue$iv$iv2.getCurrentState();
                    $dirty = $dirty2;
                    this_$iv$iv$iv.restoreNonObservable(previousSnapshot$iv$iv$iv, newSnapshot$iv$iv$iv, observer$iv$iv$iv);
                    $composer2.updateRememberedValue(value$iv$iv$iv522);
                    it$iv$iv$iv2 = value$iv$iv$iv522;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceGroup();
                } catch (Throwable th2) {
                    this_$iv$iv$iv.restoreNonObservable(previousSnapshot$iv$iv$iv, newSnapshot$iv$iv$iv, observer$iv$iv$iv);
                    throw th2;
                }
                invalid$iv$iv$iv = true;
                invalid$iv$iv$iv2 = invalid$iv$iv$iv;
                it$iv$iv$iv2 = $composer2.rememberedValue();
                if (invalid$iv$iv$iv2) {
                }
                this_$iv$iv$iv = Snapshot.Companion;
                previousSnapshot$iv$iv$iv = this_$iv$iv$iv.getCurrentThreadSnapshot();
                observer$iv$iv$iv = previousSnapshot$iv$iv$iv != null ? previousSnapshot$iv$iv$iv.getReadObserver() : null;
                newSnapshot$iv$iv$iv = this_$iv$iv$iv.makeCurrentNonObservable(previousSnapshot$iv$iv$iv);
            }
            Object initialState$iv$iv2 = it$iv$iv$iv2;
            int $changed4 = ($changed$iv$iv2 >> 9) & 112;
            boolean it3 = ((Boolean) initialState$iv$iv2).booleanValue();
            $composer2.startReplaceGroup(-325750611);
            ComposerKt.sourceInformation($composer2, "CN(it):PopupBubbleMenu.kt#92mklk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-325750611, $changed4, -1, "kntr.app.im.chat.ui.widget.PopupBubbleMenuContent.<anonymous> (PopupBubbleMenu.kt:588)");
            }
            float f5 = it3 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object initialValue$iv$iv2 = Float.valueOf(f5);
            ComposerKt.sourceInformationMarkerStart($composer2, -1054592958, "CC(remember):Transition.kt#9igjgp");
            boolean invalid$iv$iv$iv7 = ((($changed$iv$iv2 & 14) ^ 6) > 4 && $composer2.changed($this$animateValue$iv$iv2)) || ($changed$iv$iv2 & 6) == 4;
            Object it$iv$iv$iv5 = $composer2.rememberedValue();
            if (invalid$iv$iv$iv7 || it$iv$iv$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv$iv$iv6 = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$PopupBubbleMenuContent-NGHgvGo$$inlined$animateFloat$3
                    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Boolean, java.lang.Object] */
                    public final Boolean invoke() {
                        return $this$animateValue$iv$iv2.getTargetState();
                    }
                });
                $composer2.updateRememberedValue(value$iv$iv$iv6);
                it$iv$iv$iv5 = value$iv$iv$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed5 = ($changed$iv$iv2 >> 9) & 112;
            boolean it4 = ((Boolean) ((State) it$iv$iv$iv5).getValue()).booleanValue();
            $composer2.startReplaceGroup(-325750611);
            ComposerKt.sourceInformation($composer2, "CN(it):PopupBubbleMenu.kt#92mklk");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-325750611, $changed5, -1, "kntr.app.im.chat.ui.widget.PopupBubbleMenuContent.<anonymous> (PopupBubbleMenu.kt:588)");
            }
            float f6 = it4 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceGroup();
            Object targetValue$iv$iv2 = Float.valueOf(f6);
            ComposerKt.sourceInformationMarkerStart($composer2, -1054589890, "CC(remember):Transition.kt#9igjgp");
            boolean invalid$iv$iv$iv8 = ((($changed$iv$iv2 & 14) ^ 6) > 4 && $composer2.changed($this$animateValue$iv$iv2)) || ($changed$iv$iv2 & 6) == 4;
            Object it$iv$iv$iv6 = $composer2.rememberedValue();
            if (invalid$iv$iv$iv8 || it$iv$iv$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv$iv$iv7 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<Boolean>>() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$PopupBubbleMenuContent-NGHgvGo$$inlined$animateFloat$4
                    /* renamed from: invoke */
                    public final Transition.Segment<Boolean> m1980invoke() {
                        return $this$animateValue$iv$iv2.getSegment();
                    }
                });
                $composer2.updateRememberedValue(value$iv$iv$iv7);
                it$iv$iv$iv6 = value$iv$iv$iv7;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            FiniteAnimationSpec animationSpec$iv$iv2 = (FiniteAnimationSpec) transitionSpec$iv2.invoke(((State) it$iv$iv$iv6).getValue(), $composer2, Integer.valueOf(($changed$iv$iv2 >> 3) & 112));
            final State alpha$delegate = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv2, initialValue$iv$iv2, targetValue$iv$iv2, animationSpec$iv$iv2, typeConverter$iv$iv2, "Popup Alpha", $composer2, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1389174186, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            int $dirty3 = $dirty;
            boolean invalid$iv = $composer2.changed(scale$delegate) | $composer2.changed(alpha$delegate) | (($dirty3 & 896) == 256) | (($dirty3 & 57344) == 16384) | (($dirty3 & 7168) == 2048) | ((3670016 & $dirty3) == 1048576);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                modifier3 = modifier5;
                z = true;
                Object value$iv = new Function1() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj) {
                        Unit PopupBubbleMenuContent_NGHgvGo$lambda$6$0;
                        PopupBubbleMenuContent_NGHgvGo$lambda$6$0 = PopupBubbleMenuKt.PopupBubbleMenuContent_NGHgvGo$lambda$6$0(j2, isAlignToTop, f, f2, scale$delegate, alpha$delegate, (GraphicsLayerScope) obj);
                        return PopupBubbleMenuContent_NGHgvGo$lambda$6$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            } else {
                modifier3 = modifier5;
                z = true;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SurfaceKt.Surface-T9BRK9s(GraphicsLayerModifierKt.graphicsLayer(modifier3, (Function1) it$iv), (Shape) null, colors.m1960getContainerColor0d7_KjU(), 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-2080826686, z, new Function2() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit PopupBubbleMenuContent_NGHgvGo$lambda$7;
                    PopupBubbleMenuContent_NGHgvGo$lambda$7 = PopupBubbleMenuKt.PopupBubbleMenuContent_NGHgvGo$lambda$7(isAlignToTop, lazyListState, function1, colors, (Composer) obj, ((Integer) obj2).intValue());
                    return PopupBubbleMenuContent_NGHgvGo$lambda$7;
                }
            }, $composer2, 54), $composer2, 12582912, 122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit PopupBubbleMenuContent_NGHgvGo$lambda$8;
                    PopupBubbleMenuContent_NGHgvGo$lambda$8 = PopupBubbleMenuKt.PopupBubbleMenuContent_NGHgvGo$lambda$8(mutableTransitionState, lazyListState, j2, f, isAlignToTop, colors, f2, modifier6, function1, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PopupBubbleMenuContent_NGHgvGo$lambda$8;
                }
            });
        }
    }

    private static final float PopupBubbleMenuContent_NGHgvGo$lambda$2(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec PopupBubbleMenuContent_NGHgvGo$lambda$0(Transition.Segment $this$animateFloat, Composer $composer, int $changed) {
        FiniteAnimationSpec tween$default;
        Intrinsics.checkNotNullParameter($this$animateFloat, "$this$animateFloat");
        $composer.startReplaceGroup(995801460);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(995801460, $changed, -1, "kntr.app.im.chat.ui.widget.PopupBubbleMenuContent.<anonymous> (PopupBubbleMenu.kt:553)");
        }
        if ($this$animateFloat.isTransitioningTo(false, true)) {
            tween$default = (FiniteAnimationSpec) AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null);
        } else {
            tween$default = AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return tween$default;
    }

    private static final float PopupBubbleMenuContent_NGHgvGo$lambda$5(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec PopupBubbleMenuContent_NGHgvGo$lambda$3(Transition.Segment $this$animateFloat, Composer $composer, int $changed) {
        FiniteAnimationSpec tween$default;
        Intrinsics.checkNotNullParameter($this$animateFloat, "$this$animateFloat");
        $composer.startReplaceGroup(1020396424);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1020396424, $changed, -1, "kntr.app.im.chat.ui.widget.PopupBubbleMenuContent.<anonymous> (PopupBubbleMenu.kt:578)");
        }
        if ($this$animateFloat.isTransitioningTo(false, true)) {
            tween$default = (FiniteAnimationSpec) AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null);
        } else {
            tween$default = AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return tween$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupBubbleMenuContent_NGHgvGo$lambda$6$0(long j2, boolean $isAlignToTop, float f, float f2, State $scale$delegate, State $alpha$delegate, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setScaleX(PopupBubbleMenuContent_NGHgvGo$lambda$2($scale$delegate));
        $this$graphicsLayer.setScaleY(PopupBubbleMenuContent_NGHgvGo$lambda$2($scale$delegate));
        $this$graphicsLayer.setAlpha(PopupBubbleMenuContent_NGHgvGo$lambda$5($alpha$delegate));
        $this$graphicsLayer.setTransformOrigin-__ExYCQ(j2);
        $this$graphicsLayer.setShape(new PopupBubbleMenuShape($isAlignToTop, 0.0f, 0.0f, 0.0f, f, 14, null));
        $this$graphicsLayer.setClip(true);
        $this$graphicsLayer.setShadowElevation($this$graphicsLayer.toPx-0680j_4(f2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x03f9, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x05d9, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit PopupBubbleMenuContent_NGHgvGo$lambda$7(boolean $isAlignToTop, final LazyListState $lazyListState, Function1 $content, PopupBubbleMenuColors $colors, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        String str;
        String str2;
        BoxScope $this$PopupBubbleMenuContent_NGHgvGo_u24lambda_u247_u240;
        String str3;
        Composer $composer2;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        ComposerKt.sourceInformation($composer, "C612@21176L4781:PopupBubbleMenu.kt#92mklk");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2080826686, $changed, -1, "kntr.app.im.chat.ui.widget.PopupBubbleMenuContent.<anonymous> (PopupBubbleMenu.kt:612)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, $isAlignToTop ? PopupBubbleMenuDefaults.INSTANCE.m1961getPopUpBubbleArrowHeightD9Ej5fM$ui_debug() : Dp.constructor-impl(0), 7, (Object) null), 0.0f, $isAlignToTop ? Dp.constructor-impl(0) : PopupBubbleMenuDefaults.INSTANCE.m1961getPopUpBubbleArrowHeightD9Ej5fM$ui_debug(), 0.0f, 0.0f, 13, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
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
            int i2 = ((0 >> 6) & 112) | 6;
            BoxScope $this$PopupBubbleMenuContent_NGHgvGo_u24lambda_u247_u2402 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -137264553, "C620@21559L149,626@21747L24,628@21814L135,637@22055L424,647@22550L7:PopupBubbleMenu.kt#92mklk");
            LazyDslKt.LazyRow(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), $lazyListState, (PaddingValues) null, false, (Arrangement.Horizontal) null, (Alignment.Vertical) null, (FlingBehavior) null, false, (OverscrollEffect) null, $content, $composer, 6, 508);
            ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
                $composer.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope animateScrollScope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 965407343, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean PopupBubbleMenuContent_NGHgvGo$lambda$7$0$0$0;
                        PopupBubbleMenuContent_NGHgvGo$lambda$7$0$0$0 = PopupBubbleMenuKt.PopupBubbleMenuContent_NGHgvGo$lambda$7$0$0$0($lazyListState);
                        return Boolean.valueOf(PopupBubbleMenuContent_NGHgvGo$lambda$7$0$0$0);
                    }
                });
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            State isShowLeftArrowButton$delegate = (State) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 965415344, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        boolean PopupBubbleMenuContent_NGHgvGo$lambda$7$0$2$0;
                        PopupBubbleMenuContent_NGHgvGo$lambda$7$0$2$0 = PopupBubbleMenuKt.PopupBubbleMenuContent_NGHgvGo$lambda$7$0$2$0($lazyListState);
                        return Boolean.valueOf(PopupBubbleMenuContent_NGHgvGo$lambda$7$0$2$0);
                    }
                });
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            State isShowRightArrowButton$delegate = (State) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density $this$PopupBubbleMenuContent_NGHgvGo_u24lambda_u247_u240_u244 = (Density) consume;
            final int arrowButtonWidth = $this$PopupBubbleMenuContent_NGHgvGo_u24lambda_u247_u240_u244.roundToPx-0680j_4(PopupBubbleMenuDefaults.INSTANCE.m1969getPopupBubbleMenuArrowButtonWidthD9Ej5fM$ui_debug());
            if (PopupBubbleMenuContent_NGHgvGo$lambda$7$0$1(isShowLeftArrowButton$delegate)) {
                $composer.startReplaceGroup(-136212910);
                ComposerKt.sourceInformation($composer, "652@22725L1544");
                Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default($this$PopupBubbleMenuContent_NGHgvGo_u24lambda_u247_u2402.align(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenterStart()), $colors.m1958getArrowLeftButtonContainerColor0d7_KjU(), (Shape) null, 2, (Object) null);
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv2 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                str = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv5;
                    $composer.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv5;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $this$PopupBubbleMenuContent_NGHgvGo_u24lambda_u247_u240 = $this$PopupBubbleMenuContent_NGHgvGo_u24lambda_u247_u2402;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i4 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -834411595, "C661@23154L660,660@23092L1121,683@24234L17:PopupBubbleMenu.kt#92mklk");
                ComposerKt.sourceInformationMarkerStart($composer, 1220010971, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(animateScrollScope) | $composer.changed($lazyListState) | $composer.changed(arrowButtonWidth);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv3 = new Function0() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit PopupBubbleMenuContent_NGHgvGo$lambda$7$0$5$0$0;
                        PopupBubbleMenuContent_NGHgvGo$lambda$7$0$5$0$0 = PopupBubbleMenuKt.PopupBubbleMenuContent_NGHgvGo$lambda$7$0$5$0$0(animateScrollScope, $lazyListState, arrowButtonWidth);
                        return PopupBubbleMenuContent_NGHgvGo$lambda$7$0$5$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                PopupBubbleMenuArrowButton(null, false, (Function0) it$iv3, null, ComposableSingletons$PopupBubbleMenuKt.INSTANCE.m1944getLambda$510611428$ui_debug(), $composer, 24576, 11);
                DividerKt.VerticalDivider-9IZ8Weo((Modifier) null, 0.0f, 0L, $composer, 0, 7);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
            } else {
                str = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $this$PopupBubbleMenuContent_NGHgvGo_u24lambda_u247_u240 = $this$PopupBubbleMenuContent_NGHgvGo_u24lambda_u247_u2402;
                str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $composer.startReplaceGroup(-158788102);
            }
            $composer.endReplaceGroup();
            if (PopupBubbleMenuContent_NGHgvGo$lambda$7$0$3(isShowRightArrowButton$delegate)) {
                $composer.startReplaceGroup(-134606428);
                ComposerKt.sourceInformation($composer, "688@24343L1590");
                Modifier modifier$iv3 = BackgroundKt.background-bw27NRU$default($this$PopupBubbleMenuContent_NGHgvGo_u24lambda_u247_u240.align(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenterEnd()), $colors.m1959getArrowRightButtonContainerColor0d7_KjU(), (Shape) null, 2, (Object) null);
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer, 844473419, str);
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv3 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, str3);
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, str2);
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv6;
                    $composer.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv6;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i6 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -589275889, "C696@24709L17,698@24809L703,697@24747L1168:PopupBubbleMenu.kt#92mklk");
                DividerKt.VerticalDivider-9IZ8Weo((Modifier) null, 0.0f, 0L, $composer, 0, 7);
                ComposerKt.sourceInformationMarkerStart($composer, -296100867, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                boolean invalid$iv2 = $composer.changedInstance(animateScrollScope) | $composer.changed($lazyListState) | $composer.changed(arrowButtonWidth);
                Object it$iv4 = $composer.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv4 = new Function0() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit PopupBubbleMenuContent_NGHgvGo$lambda$7$0$6$0$0;
                        PopupBubbleMenuContent_NGHgvGo$lambda$7$0$6$0$0 = PopupBubbleMenuKt.PopupBubbleMenuContent_NGHgvGo$lambda$7$0$6$0$0(animateScrollScope, $lazyListState, arrowButtonWidth);
                        return PopupBubbleMenuContent_NGHgvGo$lambda$7$0$6$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer);
                PopupBubbleMenuArrowButton(null, false, (Function0) it$iv4, null, ComposableSingletons$PopupBubbleMenuKt.INSTANCE.getLambda$1292727251$ui_debug(), $composer, 24576, 11);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                $composer2 = $composer;
            } else {
                $composer2 = $composer;
                $composer2.startReplaceGroup(-158788102);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
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

    private static final boolean PopupBubbleMenuContent_NGHgvGo$lambda$7$0$1(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PopupBubbleMenuContent_NGHgvGo$lambda$7$0$0$0(LazyListState $lazyListState) {
        return $lazyListState.getFirstVisibleItemIndex() > 0;
    }

    private static final boolean PopupBubbleMenuContent_NGHgvGo$lambda$7$0$3(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PopupBubbleMenuContent_NGHgvGo$lambda$7$0$2$0(LazyListState $lazyListState) {
        LazyListItemInfo lastVisibleItem = (LazyListItemInfo) CollectionsKt.lastOrNull($lazyListState.getLayoutInfo().getVisibleItemsInfo());
        if (lastVisibleItem != null) {
            return ((lastVisibleItem.getIndex() != $lazyListState.getLayoutInfo().getTotalItemsCount() - 1 || lastVisibleItem.getOffset() + lastVisibleItem.getSize() > $lazyListState.getLayoutInfo().getViewportEndOffset()) ? null : 1) == null;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupBubbleMenuContent_NGHgvGo$lambda$7$0$5$0$0(CoroutineScope $animateScrollScope, LazyListState $lazyListState, int $arrowButtonWidth) {
        BuildersKt.launch$default($animateScrollScope, (CoroutineContext) null, (CoroutineStart) null, new PopupBubbleMenuKt$PopupBubbleMenuContent$2$1$1$1$1$1($lazyListState, $arrowButtonWidth, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupBubbleMenuContent_NGHgvGo$lambda$7$0$6$0$0(CoroutineScope $animateScrollScope, LazyListState $lazyListState, int $arrowButtonWidth) {
        BuildersKt.launch$default($animateScrollScope, (CoroutineContext) null, (CoroutineStart) null, new PopupBubbleMenuKt$PopupBubbleMenuContent$2$1$2$1$1$1($lazyListState, $arrowButtonWidth, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v21 */
    private static final void PopupBubbleMenuArrowButton(Modifier modifier, boolean enabled, Function0<Unit> function0, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Function0 onClick;
        MutableInteractionSource interactionSource2;
        Modifier modifier3;
        boolean enabled2;
        Modifier modifier4;
        boolean enabled3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-386253094);
        ComposerKt.sourceInformation($composer2, "C(PopupBubbleMenuArrowButton)N(modifier,enabled,onClick,interactionSource,icon)739@26266L2,743@26369L494:PopupBubbleMenu.kt#92mklk");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            z = enabled;
        } else if (($changed & 48) == 0) {
            z = enabled;
            $dirty |= $composer2.changed(z) ? 32 : 16;
        } else {
            z = enabled;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            onClick = function0;
        } else if (($changed & 384) == 0) {
            onClick = function0;
            $dirty |= $composer2.changedInstance(onClick) ? 256 : 128;
        } else {
            onClick = function0;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            interactionSource2 = interactionSource;
        } else if (($changed & 3072) == 0) {
            interactionSource2 = interactionSource;
            $dirty |= $composer2.changed(interactionSource2) ? 2048 : 1024;
        } else {
            interactionSource2 = interactionSource;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            enabled2 = z;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                enabled3 = z;
            } else {
                enabled3 = true;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1822031972, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onClick = onClick2;
            }
            if (i5 != 0) {
                interactionSource2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-386253094, $dirty2, -1, "kntr.app.im.chat.ui.widget.PopupBubbleMenuArrowButton (PopupBubbleMenu.kt:742)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.widthIn-VpY3zN4$default(ClickableKt.clickable-O2vRcR0$default(modifier4, interactionSource2, (Indication) null, enabled3, (String) null, (Role) null, onClick, 24, (Object) null), PopupBubbleMenuDefaults.INSTANCE.m1969getPopupBubbleMenuArrowButtonWidthD9Ej5fM$ui_debug(), 0.0f, 2, (Object) null), PopupBubbleMenuDefaults.INSTANCE.m1968getPopupBubbleMenuArrowButtonHeightD9Ej5fM$ui_debug());
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            Modifier modifier5 = modifier4;
            enabled2 = enabled3;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Function0 onClick3 = onClick;
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
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i7 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -145607063, "C755@26851L6:PopupBubbleMenu.kt#92mklk");
            function2.invoke($composer2, Integer.valueOf(($dirty2 >> 12) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            onClick = onClick3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final boolean z2 = enabled2;
            final Function0 function02 = onClick;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit PopupBubbleMenuArrowButton$lambda$2;
                    PopupBubbleMenuArrowButton$lambda$2 = PopupBubbleMenuKt.PopupBubbleMenuArrowButton$lambda$2(modifier6, z2, function02, mutableInteractionSource, function2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PopupBubbleMenuArrowButton$lambda$2;
                }
            });
        }
    }

    /* renamed from: PopupBubbleMenu-gNPyAyM  reason: not valid java name */
    public static final void m1977PopupBubbleMenugNPyAyM(final PopupState popupState, final Function0<Unit> function0, Modifier modifier, PopupBubbleMenuColors colors, float f, PaddingValues contentPadding, PopupProperties properties, LazyListState lazyListState, final Function1<? super LazyListScope, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        PopupBubbleMenuColors popupBubbleMenuColors;
        PaddingValues paddingValues;
        PopupProperties popupProperties;
        LazyListState lazyListState2;
        Composer $composer2;
        PopupBubbleMenuColors colors2;
        float f2;
        PaddingValues contentPadding2;
        PopupProperties properties2;
        LazyListState lazyListState3;
        Modifier modifier3;
        Modifier modifier4;
        int $dirty;
        PopupBubbleMenuColors colors3;
        float f3;
        PaddingValues contentPadding3;
        PopupProperties properties3;
        boolean z;
        LazyListState lazyListState4;
        Modifier modifier5;
        PopupBubbleMenuColors colors4;
        int $dirty2;
        float f4;
        PaddingValues contentPadding4;
        PopupProperties properties4;
        Modifier modifier6;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(popupState, "popupState");
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function1, "content");
        Composer $composer3 = $composer.startRestartGroup(-660298079);
        ComposerKt.sourceInformation($composer3, "C(PopupBubbleMenu)N(popupState,onDismissRequest,modifier,colors,shadowElevation:c#ui.unit.Dp,contentPadding,properties,lazyListState,content)790@28103L42:PopupBubbleMenu.kt#92mklk");
        int $dirty3 = $changed;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed(popupState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                popupBubbleMenuColors = colors;
                if ($composer3.changed(popupBubbleMenuColors)) {
                    i4 = 2048;
                    $dirty3 |= i4;
                }
            } else {
                popupBubbleMenuColors = colors;
            }
            i4 = 1024;
            $dirty3 |= i4;
        } else {
            popupBubbleMenuColors = colors;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty3 |= $composer3.changed(f) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                paddingValues = contentPadding;
                if ($composer3.changed(paddingValues)) {
                    i3 = 131072;
                    $dirty3 |= i3;
                }
            } else {
                paddingValues = contentPadding;
            }
            i3 = 65536;
            $dirty3 |= i3;
        } else {
            paddingValues = contentPadding;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
            popupProperties = properties;
        } else if ((1572864 & $changed) == 0) {
            popupProperties = properties;
            $dirty3 |= $composer3.changed(popupProperties) ? 1048576 : 524288;
        } else {
            popupProperties = properties;
        }
        if ((12582912 & $changed) == 0) {
            if ((i & 128) == 0) {
                lazyListState2 = lazyListState;
                if ($composer3.changed(lazyListState2)) {
                    i2 = 8388608;
                    $dirty3 |= i2;
                }
            } else {
                lazyListState2 = lazyListState;
            }
            i2 = 4194304;
            $dirty3 |= i2;
        } else {
            lazyListState2 = lazyListState;
        }
        if (($changed & 100663296) == 0) {
            $dirty3 |= $composer3.changedInstance(function1) ? 67108864 : 33554432;
        }
        if ($composer3.shouldExecute(($dirty3 & 38347923) != 38347922, $dirty3 & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "777@27430L22,787@28010L23");
            if (($changed & 1) != 0 && !$composer3.getDefaultsInvalid()) {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                }
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 128) != 0) {
                    f4 = f;
                    modifier5 = modifier2;
                    properties4 = popupProperties;
                    lazyListState4 = lazyListState2;
                    contentPadding4 = paddingValues;
                    $composer2 = $composer3;
                    z = false;
                    colors4 = popupBubbleMenuColors;
                    $dirty2 = $dirty3 & (-29360129);
                } else {
                    f4 = f;
                    modifier5 = modifier2;
                    properties4 = popupProperties;
                    lazyListState4 = lazyListState2;
                    contentPadding4 = paddingValues;
                    $composer2 = $composer3;
                    z = false;
                    colors4 = popupBubbleMenuColors;
                    $dirty2 = $dirty3;
                }
            } else {
                if (i5 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 8) == 0) {
                    $dirty = $dirty3;
                    $composer2 = $composer3;
                    colors3 = colors;
                } else {
                    int $dirty4 = $dirty3;
                    $composer2 = $composer3;
                    colors3 = PopupBubbleMenuDefaults.INSTANCE.m1971popupBubbleMenuColorRGew2ao(0L, 0L, 0L, $composer3, 3072, 7);
                    $dirty = $dirty4 & (-7169);
                }
                if (i6 == 0) {
                    f3 = f;
                } else {
                    f3 = PopupBubbleMenuDefaults.INSTANCE.m1970getPopupBubbleMenuShadowElevationD9Ej5fM$ui_debug();
                }
                if ((i & 32) == 0) {
                    contentPadding3 = contentPadding;
                } else {
                    contentPadding3 = PaddingKt.PaddingValues-a9UjIt4(PopupBubbleMenuDefaults.INSTANCE.m1966getPopUpBubbleMenuHorizontalPaddingD9Ej5fM$ui_debug(), PopupBubbleMenuDefaults.INSTANCE.m1963getPopUpBubbleMenuArrowOffsetYD9Ej5fM$ui_debug(), PopupBubbleMenuDefaults.INSTANCE.m1966getPopUpBubbleMenuHorizontalPaddingD9Ej5fM$ui_debug(), PopupBubbleMenuDefaults.INSTANCE.m1963getPopUpBubbleMenuArrowOffsetYD9Ej5fM$ui_debug());
                    $dirty &= -458753;
                }
                if (i7 == 0) {
                    properties3 = properties;
                } else {
                    properties3 = new PopupProperties(false, false, false, false, 14, (DefaultConstructorMarker) null);
                }
                if ((i & 128) == 0) {
                    z = false;
                    lazyListState4 = lazyListState;
                    modifier5 = modifier4;
                    colors4 = colors3;
                    $dirty2 = $dirty;
                    f4 = f3;
                    contentPadding4 = contentPadding3;
                    properties4 = properties3;
                } else {
                    z = false;
                    modifier5 = modifier4;
                    colors4 = colors3;
                    $dirty2 = $dirty & (-29360129);
                    f4 = f3;
                    contentPadding4 = contentPadding3;
                    properties4 = properties3;
                    lazyListState4 = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-660298079, $dirty2, -1, "kntr.app.im.chat.ui.widget.PopupBubbleMenu (PopupBubbleMenu.kt:789)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1108733163, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            Composer $this$cache$iv = $composer2;
            Object it$iv = $this$cache$iv.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new MutableTransitionState(Boolean.valueOf(z));
                $this$cache$iv.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableTransitionState expandedStates = (MutableTransitionState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            expandedStates.setTargetState(Boolean.valueOf(popupState.isVisible()));
            if (((Boolean) expandedStates.getCurrentState()).booleanValue() || ((Boolean) expandedStates.getTargetState()).booleanValue()) {
                $composer2.startReplaceGroup(11207183);
                ComposerKt.sourceInformation($composer2, "793@28304L7,795@28355L10,796@28412L10,804@28705L209,814@29086L985,810@28924L1147");
                CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                Composer $composer$iv = $composer2;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer$iv.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                Density density = (Density) consume;
                WindowInsets statusBarInset = WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer2, 6);
                WindowInsets navigationBarInset = WindowInsets_androidKt.getSystemBars(WindowInsets.Companion, $composer2, 6);
                ComposerKt.sourceInformationMarkerStart($composer2, 1108752594, "CC(remember):PopupBubbleMenu.kt#9igjgp");
                boolean invalid$iv = ($dirty2 & 14) == 4;
                Composer $this$cache$iv2 = $composer2;
                Object it$iv2 = $this$cache$iv2.rememberedValue();
                if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function3() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit PopupBubbleMenu_gNPyAyM$lambda$1$0;
                            PopupBubbleMenu_gNPyAyM$lambda$1$0 = PopupBubbleMenuKt.PopupBubbleMenu_gNPyAyM$lambda$1$0(PopupState.this, ((Float) obj).floatValue(), ((Boolean) obj2).booleanValue(), (Dp) obj3);
                            return PopupBubbleMenu_gNPyAyM$lambda$1$0;
                        }
                    };
                    $this$cache$iv2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                PopUpBubbleMenuPositionProvider popupPositionProvider = new PopUpBubbleMenuPositionProvider(contentPadding4, density, statusBarInset, navigationBarInset, (Function3) it$iv2);
                PopUpBubbleMenuPositionProvider popUpBubbleMenuPositionProvider = popupPositionProvider;
                final Modifier modifier7 = modifier5;
                final PaddingValues paddingValues2 = contentPadding4;
                final LazyListState lazyListState5 = lazyListState4;
                final PopupBubbleMenuColors popupBubbleMenuColors2 = colors4;
                modifier6 = modifier5;
                final float f5 = f4;
                int $dirty5 = $dirty2;
                AndroidPopup_androidKt.Popup(popUpBubbleMenuPositionProvider, function0, properties4, ComposableLambdaKt.rememberComposableLambda(-742134392, true, new Function2() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj, Object obj2) {
                        Unit PopupBubbleMenu_gNPyAyM$lambda$2;
                        PopupBubbleMenu_gNPyAyM$lambda$2 = PopupBubbleMenuKt.PopupBubbleMenu_gNPyAyM$lambda$2(modifier7, paddingValues2, lazyListState5, popupState, expandedStates, popupBubbleMenuColors2, f5, function1, (Composer) obj, ((Integer) obj2).intValue());
                        return PopupBubbleMenu_gNPyAyM$lambda$2;
                    }
                }, $composer2, 54), $composer2, ($dirty5 & 112) | 3072 | (($dirty5 >> 12) & 896), 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-16890783);
                $composer2.endReplaceGroup();
                modifier6 = modifier5;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f2 = f4;
            lazyListState3 = lazyListState4;
            modifier3 = modifier6;
            properties2 = properties4;
            contentPadding2 = contentPadding4;
            colors2 = colors4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            colors2 = colors;
            f2 = f;
            contentPadding2 = contentPadding;
            properties2 = properties;
            lazyListState3 = lazyListState;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier8 = modifier3;
            final PopupBubbleMenuColors popupBubbleMenuColors3 = colors2;
            final float f6 = f2;
            final PaddingValues paddingValues3 = contentPadding2;
            final PopupProperties popupProperties2 = properties2;
            final LazyListState lazyListState6 = lazyListState3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit PopupBubbleMenu_gNPyAyM$lambda$3;
                    PopupBubbleMenu_gNPyAyM$lambda$3 = PopupBubbleMenuKt.PopupBubbleMenu_gNPyAyM$lambda$3(PopupState.this, function0, modifier8, popupBubbleMenuColors3, f6, paddingValues3, popupProperties2, lazyListState6, function1, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PopupBubbleMenu_gNPyAyM$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupBubbleMenu_gNPyAyM$lambda$1$0(PopupState $popupState, float pivotFractionX, boolean isTop, Dp arrowOffsetX) {
        $popupState.setPivotFractionX$ui_debug(pivotFractionX);
        $popupState.setTop$ui_debug(isTop);
        $popupState.m1984setArrowOffsetX0680j_4$ui_debug(arrowOffsetX.unbox-impl());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x013d, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit PopupBubbleMenu_gNPyAyM$lambda$2(Modifier $modifier, PaddingValues $contentPadding, LazyListState $lazyListState, PopupState $popupState, MutableTransitionState $expandedStates, PopupBubbleMenuColors $colors, float f, Function1 $content, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C815@29100L961:PopupBubbleMenu.kt#92mklk");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-742134392, $changed, -1, "kntr.app.im.chat.ui.widget.PopupBubbleMenu.<anonymous> (PopupBubbleMenu.kt:815)");
            }
            Modifier modifier$iv = PaddingKt.padding($modifier, $contentPadding);
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                $composer.createNode(factory$iv$iv$iv);
            } else {
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
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1958577882, "C818@29219L76,818@29198L97,822@29313L734:PopupBubbleMenu.kt#92mklk");
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 768103960, "CC(remember):PopupBubbleMenu.kt#9igjgp");
            boolean invalid$iv = $composer.changed($lazyListState);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = (Function2) new PopupBubbleMenuKt$PopupBubbleMenu$1$1$1$1($lazyListState, null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer, 6);
            Modifier modifier$iv$iv = SizeKt.height-3ABfNKs(Modifier.Companion, PopupBubbleMenuDefaults.INSTANCE.m1965getPopUpBubbleMenuDefaultHeightD9Ej5fM$ui_debug());
            m1978PopupBubbleMenuContentNGHgvGo($expandedStates, $lazyListState, TransformOriginKt.TransformOrigin($popupState.getPivotFractionX(), $popupState.isTop() ? 1.0f : 0.0f), $popupState.m1983getArrowOffsetXD9Ej5fM(), $popupState.isTop(), $colors, f, modifier$iv$iv, $content, $composer, MutableTransitionState.$stable | 12582912, 0);
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

    public static final void PopupBubbleMenuItem(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean enabled, PaddingValues contentPadding, Indication indication, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        boolean z;
        Indication indication2;
        MutableInteractionSource interactionSource2;
        Modifier modifier2;
        PaddingValues contentPadding2;
        boolean enabled2;
        MutableInteractionSource interactionSource3;
        PaddingValues contentPadding3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function2, "text");
        Composer $composer2 = $composer.startRestartGroup(1908865443);
        ComposerKt.sourceInformation($composer2, "C(PopupBubbleMenuItem)N(onClick,text,modifier,enabled,contentPadding,indication,interactionSource)865@30647L551:PopupBubbleMenu.kt#92mklk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            z = enabled;
        } else if (($changed & 3072) == 0) {
            z = enabled;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer2.changed(contentPadding) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= 196608;
            indication2 = indication;
        } else if ((196608 & $changed) == 0) {
            indication2 = indication;
            $dirty |= $composer2.changed(indication2) ? 131072 : 65536;
        } else {
            indication2 = indication;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
            interactionSource2 = interactionSource;
        } else if (($changed & 1572864) == 0) {
            interactionSource2 = interactionSource;
            $dirty |= $composer2.changed(interactionSource2) ? 1048576 : 524288;
        } else {
            interactionSource2 = interactionSource;
        }
        if ($composer2.shouldExecute(($dirty & 599187) != 599186, $dirty & 1)) {
            if (i2 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i3 == 0) {
                enabled2 = z;
            } else {
                enabled2 = true;
            }
            if (i4 == 0) {
                contentPadding3 = contentPadding;
            } else {
                contentPadding3 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0));
            }
            if (i5 != 0) {
                indication2 = null;
            }
            if (i6 != 0) {
                interactionSource2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1908865443, $dirty, -1, "kntr.app.im.chat.ui.widget.PopupBubbleMenuItem (PopupBubbleMenu.kt:864)");
            }
            int $dirty2 = $dirty;
            contentPadding2 = contentPadding3;
            Modifier modifier$iv = PaddingKt.padding(SizeKt.fillMaxHeight$default(SizeKt.widthIn-VpY3zN4$default(ClickableKt.clickable-O2vRcR0$default(modifier2, interactionSource2, indication2, enabled2, (String) null, (Role) null, function0, 24, (Object) null), PopupBubbleMenuDefaults.INSTANCE.m1967getPopUpBubbleMenuItemMinWidthD9Ej5fM$ui_debug(), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null), contentPadding2);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
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
            MutableInteractionSource interactionSource4 = interactionSource2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i8 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 625068126, "C879@31186L6:PopupBubbleMenu.kt#92mklk");
            function2.invoke($composer2, Integer.valueOf(($dirty2 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interactionSource3 = interactionSource4;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            contentPadding2 = contentPadding;
            enabled2 = z;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final boolean z2 = enabled2;
            final PaddingValues paddingValues = contentPadding2;
            final Indication indication3 = indication2;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit PopupBubbleMenuItem$lambda$1;
                    PopupBubbleMenuItem$lambda$1 = PopupBubbleMenuKt.PopupBubbleMenuItem$lambda$1(function0, function2, modifier3, z2, paddingValues, indication3, mutableInteractionSource, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PopupBubbleMenuItem$lambda$1;
                }
            });
        }
    }

    public static final void PopUpBubbleMenuPreview(Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(185536326);
        ComposerKt.sourceInformation($composer3, "C(PopUpBubbleMenuPreview)887@31342L7242:PopupBubbleMenu.kt#92mklk");
        if (!$composer3.shouldExecute($changed != 0, $changed & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(185536326, $changed, -1, "kntr.app.im.chat.ui.widget.PopUpBubbleMenuPreview (PopupBubbleMenu.kt:886)");
            }
            $composer2 = $composer3;
            ScaffoldKt.Scaffold-TvnljyQ(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Function2) null, (Function2) null, (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableSingletons$PopupBubbleMenuKt.INSTANCE.getLambda$492475797$ui_debug(), $composer3, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.widget.PopupBubbleMenuKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit PopUpBubbleMenuPreview$lambda$0;
                    PopUpBubbleMenuPreview$lambda$0 = PopupBubbleMenuKt.PopUpBubbleMenuPreview$lambda$0($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return PopUpBubbleMenuPreview$lambda$0;
                }
            });
        }
    }
}