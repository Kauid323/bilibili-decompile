package kntr.app.im.chat.sticker.widget;

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
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupBubbleSticker.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\u001aj\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001am\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u001eH\u0003¢\u0006\u0004\b\u001f\u0010 ¨\u0006!²\u0006\n\u0010\"\u001a\u00020#X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020#X\u008a\u0084\u0002"}, d2 = {"PopupBubbleSticker", RoomRecommendViewModel.EMPTY_CURSOR, "state", "Lkntr/app/im/chat/sticker/widget/PopupBubbleStickerState;", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "shadowElevation", "Landroidx/compose/ui/unit/Dp;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "content", "Landroidx/compose/runtime/Composable;", "PopupBubbleSticker-o_661Y4", "(Lkntr/app/im/chat/sticker/widget/PopupBubbleStickerState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;FLandroidx/compose/ui/window/PopupProperties;JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PopupBubbleStickerContent", "expandedStates", "Landroidx/compose/animation/core/MutableTransitionState;", RoomRecommendViewModel.EMPTY_CURSOR, "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "arrowOffsetX", "isAlignToTop", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Lkotlin/ExtensionFunctionType;", "PopupBubbleStickerContent-nCaD8wA", "(Landroidx/compose/animation/core/MutableTransitionState;JFZFJLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "sticker_debug", "scale", RoomRecommendViewModel.EMPTY_CURSOR, "alpha"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PopupBubbleStickerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupBubbleStickerContent_nCaD8wA$lambda$8(MutableTransitionState mutableTransitionState, long j2, float f, boolean z, float f2, long j3, Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        m1710PopupBubbleStickerContentnCaD8wA(mutableTransitionState, j2, f, z, f2, j3, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupBubbleSticker_o_661Y4$lambda$3(PopupBubbleStickerState popupBubbleStickerState, Function0 function0, Modifier modifier, PaddingValues paddingValues, float f, PopupProperties popupProperties, long j2, Function2 function2, int i, int i2, Composer composer, int i3) {
        m1709PopupBubbleStickero_661Y4(popupBubbleStickerState, function0, modifier, paddingValues, f, popupProperties, j2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:126:0x0262, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L85;
     */
    /* renamed from: PopupBubbleSticker-o_661Y4  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1709PopupBubbleStickero_661Y4(final PopupBubbleStickerState state, final Function0<Unit> function0, Modifier modifier, PaddingValues contentPadding, float f, PopupProperties properties, long j2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        PaddingValues contentPadding2;
        float f2;
        PopupProperties properties2;
        Modifier modifier2;
        long j3;
        PaddingValues contentPadding3;
        float f3;
        PopupProperties properties3;
        Modifier modifier3;
        int $dirty;
        PaddingValues contentPadding4;
        float f4;
        Modifier modifier4;
        boolean z;
        PaddingValues contentPadding5;
        float f5;
        int i2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-68476046);
        ComposerKt.sourceInformation($composer2, "C(PopupBubbleSticker)N(state,onDismissRequest,modifier,contentPadding,shadowElevation:c#ui.unit.Dp,properties,backgroundColor:c#ui.graphics.Color,content)71@2690L42:PopupBubbleSticker.kt#nmvke3");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            contentPadding2 = contentPadding;
        } else if (($changed & 3072) == 0) {
            contentPadding2 = contentPadding;
            $dirty2 |= $composer2.changed(contentPadding2) ? 2048 : 1024;
        } else {
            contentPadding2 = contentPadding;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            f2 = f;
        } else if (($changed & 24576) == 0) {
            f2 = f;
            $dirty2 |= $composer2.changed(f2) ? 16384 : 8192;
        } else {
            f2 = f;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= 196608;
            properties2 = properties;
        } else if ((196608 & $changed) == 0) {
            properties2 = properties;
            $dirty2 |= $composer2.changed(properties2) ? 131072 : 65536;
        } else {
            properties2 = properties;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0 && $composer2.changed(j2)) {
                i2 = 1048576;
                $dirty2 |= i2;
            }
            i2 = 524288;
            $dirty2 |= i2;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ($composer2.shouldExecute(($dirty2 & 4793491) != 4793490, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "68@2606L6");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                j3 = j2;
                $dirty = $dirty2;
                contentPadding4 = contentPadding2;
                properties3 = properties2;
                f4 = f2;
                modifier4 = modifier;
            } else {
                if (i3 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i4 != 0) {
                    contentPadding2 = PaddingKt.PaddingValues-YgX7TsA$default(0.0f, 0.0f, 3, (Object) null);
                }
                if (i5 != 0) {
                    f2 = Dp.constructor-impl(4);
                }
                if (i6 != 0) {
                    properties2 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                }
                if ((i & 64) == 0) {
                    j3 = j2;
                    $dirty = $dirty2;
                    contentPadding4 = contentPadding2;
                    properties3 = properties2;
                    f4 = f2;
                    modifier4 = modifier3;
                } else {
                    $dirty = $dirty2 & (-3670017);
                    j3 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1_float-0d7_KjU();
                    contentPadding4 = contentPadding2;
                    properties3 = properties2;
                    f4 = f2;
                    modifier4 = modifier3;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-68476046, $dirty, -1, "kntr.app.im.chat.sticker.widget.PopupBubbleSticker (PopupBubbleSticker.kt:70)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1380957732, "CC(remember):PopupBubbleSticker.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                z = false;
                Object value$iv = new MutableTransitionState(false);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            } else {
                z = false;
            }
            final MutableTransitionState expandedStates = (MutableTransitionState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            expandedStates.setTargetState(Boolean.valueOf(state.isVisible()));
            if (((Boolean) expandedStates.getCurrentState()).booleanValue() || ((Boolean) expandedStates.getTargetState()).booleanValue()) {
                $composer2.startReplaceGroup(140181174);
                ComposerKt.sourceInformation($composer2, "74@2886L7,79@3103L10,80@3163L14,81@3193L200,91@3565L616,87@3403L778");
                CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density density = (Density) consume;
                WindowInsets statusBars = WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer2, 6);
                WindowInsets navigationBars = WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer2, 6);
                ComposerKt.sourceInformationMarkerStart($composer2, -1380941478, "CC(remember):PopupBubbleSticker.kt#9igjgp");
                boolean invalid$iv = ($dirty & 14) == 4 ? true : z;
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv2 = new Function3() { // from class: kntr.app.im.chat.sticker.widget.PopupBubbleStickerKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit PopupBubbleSticker_o_661Y4$lambda$1$0;
                        PopupBubbleSticker_o_661Y4$lambda$1$0 = PopupBubbleStickerKt.PopupBubbleSticker_o_661Y4$lambda$1$0(PopupBubbleStickerState.this, ((Float) obj).floatValue(), ((Boolean) obj2).booleanValue(), (Dp) obj3);
                        return PopupBubbleSticker_o_661Y4$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                PopUpBubbleMenuPositionProvider popupPositionProvider = new PopUpBubbleMenuPositionProvider(contentPadding4, density, statusBars, navigationBars, (Function3) it$iv2);
                PopUpBubbleMenuPositionProvider popUpBubbleMenuPositionProvider = popupPositionProvider;
                final float f6 = f4;
                contentPadding5 = contentPadding4;
                f5 = f4;
                final long j4 = j3;
                final Modifier modifier5 = modifier4;
                int $dirty3 = $dirty;
                AndroidPopup_androidKt.Popup(popUpBubbleMenuPositionProvider, function0, properties3, ComposableLambdaKt.rememberComposableLambda(917413593, true, new Function2() { // from class: kntr.app.im.chat.sticker.widget.PopupBubbleStickerKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit PopupBubbleSticker_o_661Y4$lambda$2;
                        PopupBubbleSticker_o_661Y4$lambda$2 = PopupBubbleStickerKt.PopupBubbleSticker_o_661Y4$lambda$2(expandedStates, state, f6, j4, modifier5, function2, (Composer) obj, ((Integer) obj2).intValue());
                        return PopupBubbleSticker_o_661Y4$lambda$2;
                    }
                }, $composer2, 54), $composer2, ($dirty3 & 112) | 3072 | (($dirty3 >> 9) & 896), 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(137312496);
                $composer2.endReplaceGroup();
                contentPadding5 = contentPadding4;
                f5 = f4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentPadding3 = contentPadding5;
            f3 = f5;
            modifier2 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            j3 = j2;
            contentPadding3 = contentPadding2;
            f3 = f2;
            properties3 = properties2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            final PaddingValues paddingValues = contentPadding3;
            final float f7 = f3;
            final PopupProperties popupProperties = properties3;
            final long j5 = j3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.widget.PopupBubbleStickerKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit PopupBubbleSticker_o_661Y4$lambda$3;
                    PopupBubbleSticker_o_661Y4$lambda$3 = PopupBubbleStickerKt.PopupBubbleSticker_o_661Y4$lambda$3(PopupBubbleStickerState.this, function0, modifier6, paddingValues, f7, popupProperties, j5, function2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PopupBubbleSticker_o_661Y4$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupBubbleSticker_o_661Y4$lambda$1$0(PopupBubbleStickerState $state, float pivotFractionX, boolean isFitTop, Dp arrowOffsetX) {
        $state.setPivotFractionX$sticker_debug(pivotFractionX);
        $state.setTop$sticker_debug(isFitTop);
        $state.m1715setArrowOffsetX0680j_4$sticker_debug(arrowOffsetX.unbox-impl());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupBubbleSticker_o_661Y4$lambda$2(MutableTransitionState $expandedStates, PopupBubbleStickerState $state, float f, long j2, Modifier $modifier, final Function2 $content, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C104@4130L41,92@3579L592:PopupBubbleSticker.kt#nmvke3");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(917413593, $changed, -1, "kntr.app.im.chat.sticker.widget.PopupBubbleSticker.<anonymous> (PopupBubbleSticker.kt:92)");
            }
            m1710PopupBubbleStickerContentnCaD8wA($expandedStates, TransformOriginKt.TransformOrigin($state.getPivotFractionX(), $state.isTop() ? 1.0f : 0.0f), $state.m1714getArrowOffsetXD9Ej5fM(), $state.isTop(), f, j2, $modifier, ComposableLambdaKt.rememberComposableLambda(-1701538876, true, new Function3() { // from class: kntr.app.im.chat.sticker.widget.PopupBubbleStickerKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PopupBubbleSticker_o_661Y4$lambda$2$0;
                    PopupBubbleSticker_o_661Y4$lambda$2$0 = PopupBubbleStickerKt.PopupBubbleSticker_o_661Y4$lambda$2$0($content, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PopupBubbleSticker_o_661Y4$lambda$2$0;
                }
            }, $composer, 54), $composer, MutableTransitionState.$stable | 12582912, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupBubbleSticker_o_661Y4$lambda$2$0(Function2 $content, BoxScope $this$PopupBubbleStickerContent, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$PopupBubbleStickerContent, "$this$PopupBubbleStickerContent");
        ComposerKt.sourceInformation($composer, "C105@4148L9:PopupBubbleSticker.kt#nmvke3");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1701538876, $changed, -1, "kntr.app.im.chat.sticker.widget.PopupBubbleSticker.<anonymous>.<anonymous> (PopupBubbleSticker.kt:105)");
            }
            $content.invoke($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0182, code lost:
        if (r11.changed(r7) == false) goto L243;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03f7  */
    /* renamed from: PopupBubbleStickerContent-nCaD8wA  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m1710PopupBubbleStickerContentnCaD8wA(final MutableTransitionState<Boolean> mutableTransitionState, final long j2, final float f, final boolean isAlignToTop, final float f2, final long j3, Modifier modifier, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Transition $this$animateValue$iv$iv;
        Object it$iv$iv$iv;
        int $dirty;
        final Transition $this$animateValue$iv$iv2;
        Object it$iv$iv$iv2;
        int $dirty2;
        Modifier modifier3;
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
        Composer $composer2 = $composer.startRestartGroup(267294370);
        ComposerKt.sourceInformation($composer2, "C(PopupBubbleStickerContent)N(expandedStates,transformOrigin:c#ui.graphics.TransformOrigin,arrowOffsetX:c#ui.unit.Dp,isAlignToTop,shadowElevation:c#ui.unit.Dp,backgroundColor:c#ui.graphics.Color,modifier,content)242@8742L50,243@8821L524,268@9375L397,289@9841L464,303@10346L291,287@9778L859:PopupBubbleSticker.kt#nmvke3");
        int $dirty3 = $changed;
        if (($changed & 6) == 0) {
            $dirty3 |= ($changed & 8) == 0 ? $composer2.changed(mutableTransitionState) : $composer2.changedInstance(mutableTransitionState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changed(j2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty3 |= $composer2.changed(f) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty3 |= $composer2.changed(isAlignToTop) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty3 |= $composer2.changed(f2) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty3 |= $composer2.changed(j3) ? 131072 : 65536;
        }
        int i2 = i & 64;
        if (i2 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer2.changed(modifier) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty3 |= $composer2.changedInstance(function3) ? 8388608 : 4194304;
        }
        if ($composer2.shouldExecute(($dirty3 & 4793491) != 4793490, $dirty3 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(267294370, $dirty3, -1, "kntr.app.im.chat.sticker.widget.PopupBubbleStickerContent (PopupBubbleSticker.kt:241)");
            }
            Modifier modifier5 = modifier4;
            Transition transition = TransitionKt.rememberTransition((TransitionState) mutableTransitionState, "PopupSticker", $composer2, MutableTransitionState.$stable | 48 | ($dirty3 & 14), 0);
            Function3 transitionSpec$iv = new Function3() { // from class: kntr.app.im.chat.sticker.widget.PopupBubbleStickerKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    FiniteAnimationSpec PopupBubbleStickerContent_nCaD8wA$lambda$0;
                    PopupBubbleStickerContent_nCaD8wA$lambda$0 = PopupBubbleStickerKt.PopupBubbleStickerContent_nCaD8wA$lambda$0((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PopupBubbleStickerContent_nCaD8wA$lambda$0;
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
            $composer2.startReplaceGroup(1001247238);
            ComposerKt.sourceInformation($composer2, "CN(it):PopupBubbleSticker.kt#nmvke3");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1001247238, $changed2, -1, "kntr.app.im.chat.sticker.widget.PopupBubbleStickerContent.<anonymous> (PopupBubbleSticker.kt:259)");
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
                Object value$iv$iv$iv3 = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: kntr.app.im.chat.sticker.widget.PopupBubbleStickerKt$PopupBubbleStickerContent-nCaD8wA$$inlined$animateFloat$1
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
            $composer2.startReplaceGroup(1001247238);
            ComposerKt.sourceInformation($composer2, "CN(it):PopupBubbleSticker.kt#nmvke3");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1001247238, $changed3, -1, "kntr.app.im.chat.sticker.widget.PopupBubbleStickerContent.<anonymous> (PopupBubbleSticker.kt:259)");
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
                Object value$iv$iv$iv4 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<Boolean>>() { // from class: kntr.app.im.chat.sticker.widget.PopupBubbleStickerKt$PopupBubbleStickerContent-nCaD8wA$$inlined$animateFloat$2
                    /* renamed from: invoke */
                    public final Transition.Segment<Boolean> m1711invoke() {
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
            Function3 transitionSpec$iv2 = new Function3() { // from class: kntr.app.im.chat.sticker.widget.PopupBubbleStickerKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    FiniteAnimationSpec PopupBubbleStickerContent_nCaD8wA$lambda$3;
                    PopupBubbleStickerContent_nCaD8wA$lambda$3 = PopupBubbleStickerKt.PopupBubbleStickerContent_nCaD8wA$lambda$3((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PopupBubbleStickerContent_nCaD8wA$lambda$3;
                }
            };
            ComposerKt.sourceInformationMarkerStart($composer2, 844118987, "CC(animateFloat)N(transitionSpec,label,targetValueByState)1951@83597L78:Transition.kt#pdpnli");
            TwoWayConverter typeConverter$iv$iv2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv2 = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
            ComposerKt.sourceInformationMarkerStart($composer2, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
            if (transition.isSeeking()) {
                $dirty = $dirty3;
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
                                $dirty = $dirty3;
                                this_$iv$iv$iv.restoreNonObservable(previousSnapshot$iv$iv$iv, newSnapshot$iv$iv$iv, observer$iv$iv$iv);
                                $composer2.updateRememberedValue(value$iv$iv$iv5);
                                it$iv$iv$iv2 = value$iv$iv$iv5;
                            } else {
                                $dirty = $dirty3;
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
                        $dirty = $dirty3;
                        this_$iv$iv$iv.restoreNonObservable(previousSnapshot$iv$iv$iv, newSnapshot$iv$iv$iv, observer$iv$iv$iv);
                        $composer2.updateRememberedValue(value$iv$iv$iv52);
                        it$iv$iv$iv2 = value$iv$iv$iv52;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        $composer2.endReplaceGroup();
                    }
                    Object value$iv$iv$iv522 = $this$animateValue$iv$iv2.getCurrentState();
                    $dirty = $dirty3;
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
            $composer2.startReplaceGroup(1908089202);
            ComposerKt.sourceInformation($composer2, "CN(it):PopupBubbleSticker.kt#nmvke3");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1908089202, $changed4, -1, "kntr.app.im.chat.sticker.widget.PopupBubbleStickerContent.<anonymous> (PopupBubbleSticker.kt:280)");
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
                Object value$iv$iv$iv6 = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: kntr.app.im.chat.sticker.widget.PopupBubbleStickerKt$PopupBubbleStickerContent-nCaD8wA$$inlined$animateFloat$3
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
            $composer2.startReplaceGroup(1908089202);
            ComposerKt.sourceInformation($composer2, "CN(it):PopupBubbleSticker.kt#nmvke3");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1908089202, $changed5, -1, "kntr.app.im.chat.sticker.widget.PopupBubbleStickerContent.<anonymous> (PopupBubbleSticker.kt:280)");
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
                Object value$iv$iv$iv7 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<Boolean>>() { // from class: kntr.app.im.chat.sticker.widget.PopupBubbleStickerKt$PopupBubbleStickerContent-nCaD8wA$$inlined$animateFloat$4
                    /* renamed from: invoke */
                    public final Transition.Segment<Boolean> m1712invoke() {
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
            ComposerKt.sourceInformationMarkerStart($composer2, -828101998, "CC(remember):PopupBubbleSticker.kt#9igjgp");
            int $dirty4 = $dirty;
            boolean invalid$iv = $composer2.changed(scale$delegate) | $composer2.changed(alpha$delegate) | (($dirty & 112) == 32) | (($dirty4 & 7168) == 2048) | (($dirty4 & 896) == 256) | (($dirty4 & 57344) == 16384);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                $dirty2 = $dirty4;
                modifier3 = modifier5;
                Object value$iv = new Function1() { // from class: kntr.app.im.chat.sticker.widget.PopupBubbleStickerKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        Unit PopupBubbleStickerContent_nCaD8wA$lambda$6$0;
                        PopupBubbleStickerContent_nCaD8wA$lambda$6$0 = PopupBubbleStickerKt.PopupBubbleStickerContent_nCaD8wA$lambda$6$0(j2, isAlignToTop, f, f2, scale$delegate, alpha$delegate, (GraphicsLayerScope) obj);
                        return PopupBubbleStickerContent_nCaD8wA$lambda$6$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            } else {
                $dirty2 = $dirty4;
                modifier3 = modifier5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SurfaceKt.Surface-T9BRK9s(GraphicsLayerModifierKt.graphicsLayer(modifier3, (Function1) it$iv), (Shape) null, j3, 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(1462557629, true, new Function2() { // from class: kntr.app.im.chat.sticker.widget.PopupBubbleStickerKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit PopupBubbleStickerContent_nCaD8wA$lambda$7;
                    PopupBubbleStickerContent_nCaD8wA$lambda$7 = PopupBubbleStickerKt.PopupBubbleStickerContent_nCaD8wA$lambda$7(isAlignToTop, function3, (Composer) obj, ((Integer) obj2).intValue());
                    return PopupBubbleStickerContent_nCaD8wA$lambda$7;
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 9) & 896) | 12582912, 122);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.sticker.widget.PopupBubbleStickerKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit PopupBubbleStickerContent_nCaD8wA$lambda$8;
                    PopupBubbleStickerContent_nCaD8wA$lambda$8 = PopupBubbleStickerKt.PopupBubbleStickerContent_nCaD8wA$lambda$8(mutableTransitionState, j2, f, isAlignToTop, f2, j3, modifier6, function3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PopupBubbleStickerContent_nCaD8wA$lambda$8;
                }
            });
        }
    }

    private static final float PopupBubbleStickerContent_nCaD8wA$lambda$2(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec PopupBubbleStickerContent_nCaD8wA$lambda$0(Transition.Segment $this$animateFloat, Composer $composer, int $changed) {
        FiniteAnimationSpec tween$default;
        Intrinsics.checkNotNullParameter($this$animateFloat, "$this$animateFloat");
        $composer.startReplaceGroup(723946699);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(723946699, $changed, -1, "kntr.app.im.chat.sticker.widget.PopupBubbleStickerContent.<anonymous> (PopupBubbleSticker.kt:245)");
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

    private static final float PopupBubbleStickerContent_nCaD8wA$lambda$5(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec PopupBubbleStickerContent_nCaD8wA$lambda$3(Transition.Segment $this$animateFloat, Composer $composer, int $changed) {
        FiniteAnimationSpec tween$default;
        Intrinsics.checkNotNullParameter($this$animateFloat, "$this$animateFloat");
        $composer.startReplaceGroup(1630788663);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1630788663, $changed, -1, "kntr.app.im.chat.sticker.widget.PopupBubbleStickerContent.<anonymous> (PopupBubbleSticker.kt:270)");
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
    public static final Unit PopupBubbleStickerContent_nCaD8wA$lambda$6$0(long j2, boolean $isAlignToTop, float f, float f2, State $scale$delegate, State $alpha$delegate, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setScaleX(PopupBubbleStickerContent_nCaD8wA$lambda$2($scale$delegate));
        $this$graphicsLayer.setScaleY(PopupBubbleStickerContent_nCaD8wA$lambda$2($scale$delegate));
        $this$graphicsLayer.setAlpha(PopupBubbleStickerContent_nCaD8wA$lambda$5($alpha$delegate));
        $this$graphicsLayer.setTransformOrigin-__ExYCQ(j2);
        $this$graphicsLayer.setShape(new PopupBubbleStickerShape($isAlignToTop, 0.0f, 0.0f, 0.0f, f, 14, null));
        $this$graphicsLayer.setClip(true);
        $this$graphicsLayer.setShadowElevation($this$graphicsLayer.toPx-0680j_4(f2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupBubbleStickerContent_nCaD8wA$lambda$7(boolean $isAlignToTop, Function3 $content, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C304@10356L275:PopupBubbleSticker.kt#nmvke3");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1462557629, $changed, -1, "kntr.app.im.chat.sticker.widget.PopupBubbleStickerContent.<anonymous> (PopupBubbleSticker.kt:304)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, $isAlignToTop ? Dp.constructor-impl(6) : Dp.constructor-impl(0), 7, (Object) null), 0.0f, $isAlignToTop ? Dp.constructor-impl(0) : Dp.constructor-impl(6), 0.0f, 0.0f, 13, (Object) null);
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
            BoxScope $this$PopupBubbleStickerContent_nCaD8wA_u24lambda_u247_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -737269117, "C311@10612L9:PopupBubbleSticker.kt#nmvke3");
            $content.invoke($this$PopupBubbleStickerContent_nCaD8wA_u24lambda_u247_u240, $composer, Integer.valueOf((((0 >> 6) & 112) | 6) & 14));
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
}