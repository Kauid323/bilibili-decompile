package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.lifecycle.Lifecycle;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.framework.simpleplayer.SimplePlayer;
import com.bilibili.framework.simpleplayer.SimplePlayerState;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.utils.ScreenKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MiniVideoFloatingComponent.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u001a¨\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001al\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u000e2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u00152\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010!¨\u0006\"²\u0006\n\u0010#\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010$\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010%\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020\u0017X\u008a\u008e\u0002"}, d2 = {"MiniVideoFloatingComponent", "", "videoUrl", "", "statusBarHeight", "Landroidx/compose/ui/unit/Dp;", "bottomInsets", "muted", "", "pause", "pauseByOther", "lifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "simplePlayer", "Lcom/bilibili/framework/simpleplayer/SimplePlayer;", "toggleHeaderFullScreenPreview", "Lkotlin/Function1;", "togglePause", "Lkotlin/Function0;", "toggleMuted", "movableVideoPlayerView", "Landroidx/compose/runtime/Composable;", "scale", "", "modifier", "Landroidx/compose/ui/Modifier;", "MiniVideoFloatingComponent-hqqSWsU", "(Ljava/lang/String;FFZZZLandroidx/lifecycle/Lifecycle$State;Lcom/bilibili/framework/simpleplayer/SimplePlayer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;III)V", "MiniVideoPlayerComponent", "videoPlayer", "onVideo", "onMute", "onClose", "(Lcom/bilibili/framework/simpleplayer/SimplePlayer;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "closeByClick", "floatingViewWidth", "floatingViewHeight", "progress"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MiniVideoFloatingComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MiniVideoFloatingComponent_hqqSWsU$lambda$16(String str, float f, float f2, boolean z, boolean z2, boolean z3, Lifecycle.State state, SimplePlayer simplePlayer, Function1 function1, Function0 function0, Function0 function02, Function2 function2, float f3, Modifier modifier, int i, int i2, int i3, Composer composer, int i4) {
        m511MiniVideoFloatingComponenthqqSWsU(str, f, f2, z, z2, z3, state, simplePlayer, function1, function0, function02, function2, f3, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MiniVideoFloatingComponent_hqqSWsU$lambda$3(String str, float f, float f2, boolean z, boolean z2, boolean z3, Lifecycle.State state, SimplePlayer simplePlayer, Function1 function1, Function0 function0, Function0 function02, Function2 function2, float f3, Modifier modifier, int i, int i2, int i3, Composer composer, int i4) {
        m511MiniVideoFloatingComponenthqqSWsU(str, f, f2, z, z2, z3, state, simplePlayer, function1, function0, function02, function2, f3, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MiniVideoFloatingComponent_hqqSWsU$lambda$5(String str, float f, float f2, boolean z, boolean z2, boolean z3, Lifecycle.State state, SimplePlayer simplePlayer, Function1 function1, Function0 function0, Function0 function02, Function2 function2, float f3, Modifier modifier, int i, int i2, int i3, Composer composer, int i4) {
        m511MiniVideoFloatingComponenthqqSWsU(str, f, f2, z, z2, z3, state, simplePlayer, function1, function0, function02, function2, f3, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MiniVideoFloatingComponent_hqqSWsU$lambda$6(String str, float f, float f2, boolean z, boolean z2, boolean z3, Lifecycle.State state, SimplePlayer simplePlayer, Function1 function1, Function0 function0, Function0 function02, Function2 function2, float f3, Modifier modifier, int i, int i2, int i3, Composer composer, int i4) {
        m511MiniVideoFloatingComponenthqqSWsU(str, f, f2, z, z2, z3, state, simplePlayer, function1, function0, function02, function2, f3, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MiniVideoPlayerComponent$lambda$2(SimplePlayer simplePlayer, Function2 function2, boolean z, Function0 function0, Function0 function02, Function0 function03, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MiniVideoPlayerComponent(simplePlayer, function2, z, function0, function02, function03, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:185:0x04e8, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L172;
     */
    /* JADX WARN: Removed duplicated region for block: B:222:0x075c  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x075f  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x07a2  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x07b2  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x07c6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0839  */
    /* renamed from: MiniVideoFloatingComponent-hqqSWsU  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m511MiniVideoFloatingComponenthqqSWsU(final String videoUrl, final float f, final float f2, final boolean muted, final boolean pause, final boolean pauseByOther, final Lifecycle.State lifecycleState, final SimplePlayer simplePlayer, final Function1<? super Boolean, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02, final Function2<? super Composer, ? super Integer, Unit> function2, final float scale, Modifier modifier, Composer $composer, final int $changed, final int $changed1, final int i) {
        Composer $composer2;
        Modifier modifier2;
        int $dirty1;
        Composer $composer3;
        Modifier modifier3;
        Object obj;
        Composer $composer4;
        Modifier modifier4;
        String str;
        int $dirty12;
        float screenHeight;
        boolean propagateMinConstraints$iv;
        boolean invalid$iv;
        boolean invalid$iv2;
        MeasurePolicy measurePolicy$iv$iv;
        final MutableState closeByClick$delegate;
        Intrinsics.checkNotNullParameter(lifecycleState, "lifecycleState");
        Intrinsics.checkNotNullParameter(function1, "toggleHeaderFullScreenPreview");
        Intrinsics.checkNotNullParameter(function0, "togglePause");
        Intrinsics.checkNotNullParameter(function02, "toggleMuted");
        Intrinsics.checkNotNullParameter(function2, "movableVideoPlayerView");
        Composer $composer5 = $composer.startRestartGroup(-649788990);
        ComposerKt.sourceInformation($composer5, "C(MiniVideoFloatingComponent)N(videoUrl,statusBarHeight:c#ui.unit.Dp,bottomInsets:c#ui.unit.Dp,muted,pause,pauseByOther,lifecycleState,simplePlayer,toggleHeaderFullScreenPreview,togglePause,toggleMuted,movableVideoPlayerView,scale,modifier)65@2662L34,74@2863L188,89@3243L16,90@3287L17,91@3336L7,100@3696L313,111@4040L313,124@4379L248,134@4652L155,141@4833L24,145@4931L91,147@5042L2001,142@4862L3117:MiniVideoFloatingComponent.kt#o90vz8");
        int $dirty = $changed;
        int $dirty13 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer5.changed(videoUrl) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer5.changed(f) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer5.changed(f2) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer5.changed(muted) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer5.changed(pause) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer5.changed(pauseByOther) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer5.changed(((Enum) lifecycleState).ordinal()) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer5.changed(simplePlayer) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer5.changedInstance(function1) ? 67108864 : 33554432;
        }
        if ((805306368 & $changed) == 0) {
            $dirty |= $composer5.changedInstance(function0) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty13 |= $composer5.changedInstance(function02) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty13 |= $composer5.changedInstance(function2) ? 32 : 16;
        }
        if (($changed1 & 384) == 0) {
            $dirty13 |= $composer5.changed(scale) ? 256 : 128;
        }
        int i2 = i & 8192;
        if (i2 != 0) {
            $dirty13 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty13 |= $composer5.changed(modifier) ? 2048 : 1024;
        }
        if ($composer5.shouldExecute((($dirty & 306783379) == 306783378 && ($dirty13 & 1171) == 1170) ? false : true, $dirty & 1)) {
            Modifier modifier5 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-649788990, $dirty, $dirty13, "kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponent (MiniVideoFloatingComponent.kt:64)");
            }
            ComposerKt.sourceInformationMarkerStart($composer5, -1676945884, "CC(remember):MiniVideoFloatingComponent.kt#9igjgp");
            Object it$iv = $composer5.rememberedValue();
            int $dirty2 = $dirty;
            if (it$iv == Composer.Companion.getEmpty()) {
                $dirty1 = $dirty13;
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer5.updateRememberedValue(value$iv);
                it$iv = value$iv;
            } else {
                $dirty1 = $dirty13;
            }
            MutableState closeByClick$delegate2 = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            if (simplePlayer != null) {
                String str2 = videoUrl;
                if (str2 == null || str2.length() == 0) {
                    $composer3 = $composer5;
                    modifier3 = modifier5;
                } else if (MiniVideoFloatingComponent_hqqSWsU$lambda$1(closeByClick$delegate2)) {
                    $composer3 = $composer5;
                    modifier3 = modifier5;
                } else if (pause) {
                    $composer3 = $composer5;
                    modifier3 = modifier5;
                } else {
                    ComposerKt.sourceInformationMarkerStart($composer5, -1676939298, "CC(remember):MiniVideoFloatingComponent.kt#9igjgp");
                    Object value$iv2 = $composer5.rememberedValue();
                    if (value$iv2 == Composer.Companion.getEmpty()) {
                        value$iv2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda13
                            public final Object invoke() {
                                boolean MiniVideoFloatingComponent_hqqSWsU$lambda$4$0;
                                MiniVideoFloatingComponent_hqqSWsU$lambda$4$0 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$4$0(pause, pauseByOther, lifecycleState);
                                return Boolean.valueOf(MiniVideoFloatingComponent_hqqSWsU$lambda$4$0);
                            }
                        });
                        $composer5.updateRememberedValue(value$iv2);
                    }
                    State intendToPlay = (State) value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    if (!((Boolean) intendToPlay.getValue()).booleanValue()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup = $composer5.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier6 = modifier5;
                            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda14
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit MiniVideoFloatingComponent_hqqSWsU$lambda$5;
                                    MiniVideoFloatingComponent_hqqSWsU$lambda$5 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$5(videoUrl, f, f2, muted, pause, pauseByOther, lifecycleState, simplePlayer, function1, function0, function02, function2, scale, modifier6, $changed, $changed1, i, (Composer) obj2, ((Integer) obj3).intValue());
                                    return MiniVideoFloatingComponent_hqqSWsU$lambda$5;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    final Modifier modifier7 = modifier5;
                    int $dirty14 = $dirty1;
                    SimplePlayerState playerState = simplePlayer.getState();
                    if (playerState != SimplePlayerState.READY) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup2 = $composer5.endRestartGroup();
                        if (endRestartGroup2 != null) {
                            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit MiniVideoFloatingComponent_hqqSWsU$lambda$6;
                                    MiniVideoFloatingComponent_hqqSWsU$lambda$6 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$6(videoUrl, f, f2, muted, pause, pauseByOther, lifecycleState, simplePlayer, function1, function0, function02, function2, scale, modifier7, $changed, $changed1, i, (Composer) obj2, ((Integer) obj3).intValue());
                                    return MiniVideoFloatingComponent_hqqSWsU$lambda$6;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    float screenWidth = ScreenKt.getScreenWidth($composer5, 0);
                    float screenHeight2 = ScreenKt.getScreenHeight($composer5, 0);
                    CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = $composer5.consume(this_$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    Density density = (Density) consume;
                    float f3 = Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(f + ProvideUiScaleKt.dpScaled(44, scale)) + ProvideUiScaleKt.dpScaled(32, scale)) + ProvideUiScaleKt.dpScaled(8, scale));
                    Dp.constructor-impl(Dp.constructor-impl(f2 + ProvideUiScaleKt.dpScaled(60, scale)) + ProvideUiScaleKt.dpScaled(8, scale));
                    float floatingPadding = ProvideUiScaleKt.dpScaled(8, scale);
                    float floatingTopPadding = ProvideUiScaleKt.dpScaled(200, scale);
                    final long videoSize = simplePlayer.getVideoSize-NH-jbRc();
                    ComposerKt.sourceInformationMarkerStart($composer5, -1676912517, "CC(remember):MiniVideoFloatingComponent.kt#9igjgp");
                    Object it$iv2 = $composer5.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                Dp MiniVideoFloatingComponent_hqqSWsU$lambda$7$0;
                                MiniVideoFloatingComponent_hqqSWsU$lambda$7$0 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$7$0(videoSize, scale);
                                return MiniVideoFloatingComponent_hqqSWsU$lambda$7$0;
                            }
                        });
                        $composer5.updateRememberedValue(value$iv3);
                        it$iv2 = value$iv3;
                    }
                    State floatingViewWidth$delegate = (State) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerStart($composer5, -1676901509, "CC(remember):MiniVideoFloatingComponent.kt#9igjgp");
                    Object it$iv3 = $composer5.rememberedValue();
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                Dp MiniVideoFloatingComponent_hqqSWsU$lambda$9$0;
                                MiniVideoFloatingComponent_hqqSWsU$lambda$9$0 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$9$0(videoSize, scale);
                                return MiniVideoFloatingComponent_hqqSWsU$lambda$9$0;
                            }
                        });
                        $composer5.updateRememberedValue(value$iv4);
                        it$iv3 = value$iv4;
                    }
                    State floatingViewHeight$delegate = (State) it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerStart($composer5, -1676890726, "CC(remember):MiniVideoFloatingComponent.kt#9igjgp");
                    Object it$iv4 = $composer5.rememberedValue();
                    if (it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = AnimatableKt.Animatable$default((density.toPx-0680j_4(screenWidth) - density.toPx-0680j_4(MiniVideoFloatingComponent_hqqSWsU$lambda$8(floatingViewWidth$delegate))) - density.toPx-0680j_4(floatingPadding), 0.0f, 2, (Object) null);
                        $composer5.updateRememberedValue(value$iv5);
                        it$iv4 = value$iv5;
                    }
                    final Animatable animX = (Animatable) it$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerStart($composer5, -1676882083, "CC(remember):MiniVideoFloatingComponent.kt#9igjgp");
                    Object it$iv5 = $composer5.rememberedValue();
                    if (it$iv5 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = AnimatableKt.Animatable$default(density.toPx-0680j_4(floatingTopPadding), 0.0f, 2, (Object) null);
                        $composer5.updateRememberedValue(value$iv6);
                        it$iv5 = value$iv6;
                    }
                    final Animatable animY = (Animatable) it$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerStart($composer5, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart($composer5, 683736516, "CC(remember):Effects.kt#9igjgp");
                    Object value$iv$iv = $composer5.rememberedValue();
                    if (value$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer5);
                        $composer5.updateRememberedValue(value$iv$iv);
                    }
                    CoroutineScope coroutineScope = (CoroutineScope) value$iv$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerStart($composer5, -1676873219, "CC(remember):MiniVideoFloatingComponent.kt#9igjgp");
                    boolean invalid$iv3 = $composer5.changedInstance(animX) | $composer5.changedInstance(animY);
                    Object it$iv6 = $composer5.rememberedValue();
                    if (invalid$iv3) {
                    }
                    Object value$iv7 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj2) {
                            IntOffset MiniVideoFloatingComponent_hqqSWsU$lambda$13$0;
                            MiniVideoFloatingComponent_hqqSWsU$lambda$13$0 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$13$0(animX, animY, (Density) obj2);
                            return MiniVideoFloatingComponent_hqqSWsU$lambda$13$0;
                        }
                    };
                    $composer5.updateRememberedValue(value$iv7);
                    it$iv6 = value$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    Modifier offset = OffsetKt.offset(modifier7, (Function1) it$iv6);
                    Object it$iv7 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer5, -1676867757, "CC(remember):MiniVideoFloatingComponent.kt#9igjgp");
                    modifier2 = modifier7;
                    boolean invalid$iv4 = $composer5.changedInstance(coroutineScope) | $composer5.changed(density) | $composer5.changed(screenWidth) | $composer5.changedInstance(animX) | $composer5.changed(floatingPadding) | $composer5.changedInstance(animY) | $composer5.changed(f3) | $composer5.changed(screenHeight2) | (($dirty14 & 896) == 256);
                    Object value$iv8 = $composer5.rememberedValue();
                    if (invalid$iv4 || value$iv8 == Composer.Companion.getEmpty()) {
                        obj = it$iv7;
                        $composer4 = $composer5;
                        modifier4 = offset;
                        str = "CC(remember):MiniVideoFloatingComponent.kt#9igjgp";
                        $dirty12 = $dirty14;
                        screenHeight = scale;
                        value$iv8 = new MiniVideoFloatingComponentKt$MiniVideoFloatingComponent$5$1(coroutineScope, density, animX, floatingPadding, screenWidth, floatingViewWidth$delegate, animY, f3, screenHeight2, scale, floatingViewHeight$delegate);
                        $composer5.updateRememberedValue(value$iv8);
                    } else {
                        obj = it$iv7;
                        str = "CC(remember):MiniVideoFloatingComponent.kt#9igjgp";
                        $dirty12 = $dirty14;
                        $composer4 = $composer5;
                        screenHeight = scale;
                        modifier4 = offset;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(ClipKt.clip(ShadowKt.shadow-s4CzXII$default(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(SuspendingPointerInputFilterKt.pointerInput(modifier4, obj, (PointerInputEventHandler) value$iv8), MiniVideoFloatingComponent_hqqSWsU$lambda$8(floatingViewWidth$delegate)), MiniVideoFloatingComponent_hqqSWsU$lambda$10(floatingViewHeight$delegate)), ProvideUiScaleKt.dpScaled(4, screenHeight), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, screenHeight)), false, 0L, Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 8, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(4, screenHeight))), Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null);
                    Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                    Composer $composer$iv = $composer4;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
                    CompositionLocalMap localMap$iv$iv = $composer$iv.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv);
                    Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer$iv.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv.startReusableNode();
                    if ($composer$iv.getInserting()) {
                        $composer$iv.createNode(factory$iv$iv$iv);
                    } else {
                        $composer$iv.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i3 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i4 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -2020345023, "C198@7668L67,201@7758L45,204@7827L81,195@7519L454:MiniVideoFloatingComponent.kt#o90vz8");
                    String str3 = str;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -2004830689, str3);
                    boolean invalid$iv5 = ($dirty2 & 234881024) == 67108864;
                    Object it$iv8 = $composer$iv.rememberedValue();
                    if (!invalid$iv5 && it$iv8 != Composer.Companion.getEmpty()) {
                        propagateMinConstraints$iv = false;
                        Function0 function03 = (Function0) it$iv8;
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerStart($composer$iv, -2004827831, str3);
                        invalid$iv = ($dirty12 & 14) != 4;
                        Object it$iv9 = $composer$iv.rememberedValue();
                        if (!invalid$iv && it$iv9 != Composer.Companion.getEmpty()) {
                            Function0 function04 = (Function0) it$iv9;
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            ComposerKt.sourceInformationMarkerStart($composer$iv, -2004825587, str3);
                            invalid$iv2 = ($dirty2 & 1879048192) == 536870912;
                            Object it$iv10 = $composer$iv.rememberedValue();
                            if (!invalid$iv2 && it$iv10 != Composer.Companion.getEmpty()) {
                                measurePolicy$iv$iv = measurePolicy$iv;
                                closeByClick$delegate = closeByClick$delegate2;
                                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                                MiniVideoPlayerComponent(simplePlayer, function2, muted, function03, function04, (Function0) it$iv10, scale, null, $composer$iv, (($dirty2 >> 21) & 14) | ($dirty12 & 112) | (($dirty2 >> 3) & 896) | (($dirty12 << 12) & 3670016), 128);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                                $composer$iv.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                $composer2 = $composer4;
                            }
                            measurePolicy$iv$iv = measurePolicy$iv;
                            closeByClick$delegate = closeByClick$delegate2;
                            Object value$iv9 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda11
                                public final Object invoke() {
                                    Unit MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0;
                                    MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0(function0, closeByClick$delegate);
                                    return MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0;
                                }
                            };
                            $composer$iv.updateRememberedValue(value$iv9);
                            it$iv10 = value$iv9;
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            MiniVideoPlayerComponent(simplePlayer, function2, muted, function03, function04, (Function0) it$iv10, scale, null, $composer$iv, (($dirty2 >> 21) & 14) | ($dirty12 & 112) | (($dirty2 >> 3) & 896) | (($dirty12 << 12) & 3670016), 128);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            $composer$iv.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            $composer2 = $composer4;
                        }
                        Object value$iv10 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda5
                            public final Object invoke() {
                                Unit MiniVideoFloatingComponent_hqqSWsU$lambda$15$1$0;
                                MiniVideoFloatingComponent_hqqSWsU$lambda$15$1$0 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$15$1$0(function02);
                                return MiniVideoFloatingComponent_hqqSWsU$lambda$15$1$0;
                            }
                        };
                        $composer$iv.updateRememberedValue(value$iv10);
                        it$iv9 = value$iv10;
                        Function0 function042 = (Function0) it$iv9;
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerStart($composer$iv, -2004825587, str3);
                        invalid$iv2 = ($dirty2 & 1879048192) == 536870912;
                        Object it$iv102 = $composer$iv.rememberedValue();
                        if (!invalid$iv2) {
                            measurePolicy$iv$iv = measurePolicy$iv;
                            closeByClick$delegate = closeByClick$delegate2;
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            MiniVideoPlayerComponent(simplePlayer, function2, muted, function03, function042, (Function0) it$iv102, scale, null, $composer$iv, (($dirty2 >> 21) & 14) | ($dirty12 & 112) | (($dirty2 >> 3) & 896) | (($dirty12 << 12) & 3670016), 128);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            $composer$iv.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            $composer2 = $composer4;
                        }
                        measurePolicy$iv$iv = measurePolicy$iv;
                        closeByClick$delegate = closeByClick$delegate2;
                        Object value$iv92 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda11
                            public final Object invoke() {
                                Unit MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0;
                                MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0(function0, closeByClick$delegate);
                                return MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0;
                            }
                        };
                        $composer$iv.updateRememberedValue(value$iv92);
                        it$iv102 = value$iv92;
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        MiniVideoPlayerComponent(simplePlayer, function2, muted, function03, function042, (Function0) it$iv102, scale, null, $composer$iv, (($dirty2 >> 21) & 14) | ($dirty12 & 112) | (($dirty2 >> 3) & 896) | (($dirty12 << 12) & 3670016), 128);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        $composer$iv.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        $composer2 = $composer4;
                    }
                    propagateMinConstraints$iv = false;
                    Object value$iv11 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit MiniVideoFloatingComponent_hqqSWsU$lambda$15$0$0;
                            MiniVideoFloatingComponent_hqqSWsU$lambda$15$0$0 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$15$0$0(function1);
                            return MiniVideoFloatingComponent_hqqSWsU$lambda$15$0$0;
                        }
                    };
                    $composer$iv.updateRememberedValue(value$iv11);
                    it$iv8 = value$iv11;
                    Function0 function032 = (Function0) it$iv8;
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -2004827831, str3);
                    if (($dirty12 & 14) != 4) {
                    }
                    Object it$iv92 = $composer$iv.rememberedValue();
                    if (!invalid$iv) {
                        Function0 function0422 = (Function0) it$iv92;
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerStart($composer$iv, -2004825587, str3);
                        invalid$iv2 = ($dirty2 & 1879048192) == 536870912;
                        Object it$iv1022 = $composer$iv.rememberedValue();
                        if (!invalid$iv2) {
                        }
                        measurePolicy$iv$iv = measurePolicy$iv;
                        closeByClick$delegate = closeByClick$delegate2;
                        Object value$iv922 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda11
                            public final Object invoke() {
                                Unit MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0;
                                MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0(function0, closeByClick$delegate);
                                return MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0;
                            }
                        };
                        $composer$iv.updateRememberedValue(value$iv922);
                        it$iv1022 = value$iv922;
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        MiniVideoPlayerComponent(simplePlayer, function2, muted, function032, function0422, (Function0) it$iv1022, scale, null, $composer$iv, (($dirty2 >> 21) & 14) | ($dirty12 & 112) | (($dirty2 >> 3) & 896) | (($dirty12 << 12) & 3670016), 128);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        $composer$iv.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        $composer2 = $composer4;
                    }
                    Object value$iv102 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit MiniVideoFloatingComponent_hqqSWsU$lambda$15$1$0;
                            MiniVideoFloatingComponent_hqqSWsU$lambda$15$1$0 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$15$1$0(function02);
                            return MiniVideoFloatingComponent_hqqSWsU$lambda$15$1$0;
                        }
                    };
                    $composer$iv.updateRememberedValue(value$iv102);
                    it$iv92 = value$iv102;
                    Function0 function04222 = (Function0) it$iv92;
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -2004825587, str3);
                    invalid$iv2 = ($dirty2 & 1879048192) == 536870912;
                    Object it$iv10222 = $composer$iv.rememberedValue();
                    if (!invalid$iv2) {
                    }
                    measurePolicy$iv$iv = measurePolicy$iv;
                    closeByClick$delegate = closeByClick$delegate2;
                    Object value$iv9222 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda11
                        public final Object invoke() {
                            Unit MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0;
                            MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0(function0, closeByClick$delegate);
                            return MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0;
                        }
                    };
                    $composer$iv.updateRememberedValue(value$iv9222);
                    it$iv10222 = value$iv9222;
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    MiniVideoPlayerComponent(simplePlayer, function2, muted, function032, function04222, (Function0) it$iv10222, scale, null, $composer$iv, (($dirty2 >> 21) & 14) | ($dirty12 & 112) | (($dirty2 >> 3) & 896) | (($dirty12 << 12) & 3670016), 128);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer2 = $composer4;
                }
            } else {
                $composer3 = $composer5;
                modifier3 = modifier5;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup3 = $composer3.endRestartGroup();
            if (endRestartGroup3 != null) {
                final Modifier modifier8 = modifier3;
                endRestartGroup3.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit MiniVideoFloatingComponent_hqqSWsU$lambda$3;
                        MiniVideoFloatingComponent_hqqSWsU$lambda$3 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$3(videoUrl, f, f2, muted, pause, pauseByOther, lifecycleState, simplePlayer, function1, function0, function02, function2, scale, modifier8, $changed, $changed1, i, (Composer) obj2, ((Integer) obj3).intValue());
                        return MiniVideoFloatingComponent_hqqSWsU$lambda$3;
                    }
                });
                return;
            }
            return;
        }
        $composer2 = $composer5;
        $composer2.skipToGroupEnd();
        modifier2 = modifier;
        ScopeUpdateScope endRestartGroup4 = $composer2.endRestartGroup();
        if (endRestartGroup4 != null) {
            final Modifier modifier9 = modifier2;
            endRestartGroup4.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj2, Object obj3) {
                    Unit MiniVideoFloatingComponent_hqqSWsU$lambda$16;
                    MiniVideoFloatingComponent_hqqSWsU$lambda$16 = MiniVideoFloatingComponentKt.MiniVideoFloatingComponent_hqqSWsU$lambda$16(videoUrl, f, f2, muted, pause, pauseByOther, lifecycleState, simplePlayer, function1, function0, function02, function2, scale, modifier9, $changed, $changed1, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return MiniVideoFloatingComponent_hqqSWsU$lambda$16;
                }
            });
        }
    }

    private static final boolean MiniVideoFloatingComponent_hqqSWsU$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void MiniVideoFloatingComponent_hqqSWsU$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MiniVideoFloatingComponent_hqqSWsU$lambda$4$0(boolean $pause, boolean $pauseByOther, Lifecycle.State $lifecycleState) {
        return ($pause || $pauseByOther || $lifecycleState.compareTo(Lifecycle.State.RESUMED) < 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float MiniVideoFloatingComponent_hqqSWsU$lambda$8(State<Dp> state) {
        Object thisObj$iv = state.getValue();
        return ((Dp) thisObj$iv).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp MiniVideoFloatingComponent_hqqSWsU$lambda$7$0(long $videoSize, float $scale) {
        float dpScaled;
        if (!Size.equals-impl0($videoSize, Size.Companion.getUnspecified-NH-jbRc())) {
            int bits$iv$iv$iv = (int) ($videoSize >> 32);
            int bits$iv$iv$iv2 = (int) ($videoSize & 4294967295L);
            if (Float.intBitsToFloat(bits$iv$iv$iv) <= Float.intBitsToFloat(bits$iv$iv$iv2)) {
                float dpScaled2 = ProvideUiScaleKt.dpScaled((int) BackoffConfigKt.MAX_DELAY_SECONDS, $scale);
                int bits$iv$iv$iv3 = (int) ($videoSize >> 32);
                int bits$iv$iv$iv4 = (int) ($videoSize & 4294967295L);
                float other$iv = Float.intBitsToFloat(bits$iv$iv$iv3) / Float.intBitsToFloat(bits$iv$iv$iv4);
                dpScaled = Dp.constructor-impl(dpScaled2 * other$iv);
                return Dp.box-impl(dpScaled);
            }
        }
        dpScaled = ProvideUiScaleKt.dpScaled((int) BackoffConfigKt.MAX_DELAY_SECONDS, $scale);
        return Dp.box-impl(dpScaled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float MiniVideoFloatingComponent_hqqSWsU$lambda$10(State<Dp> state) {
        Object thisObj$iv = state.getValue();
        return ((Dp) thisObj$iv).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp MiniVideoFloatingComponent_hqqSWsU$lambda$9$0(long $videoSize, float $scale) {
        float dpScaled;
        if (!Size.equals-impl0($videoSize, Size.Companion.getUnspecified-NH-jbRc())) {
            int bits$iv$iv$iv = (int) ($videoSize & 4294967295L);
            int bits$iv$iv$iv2 = (int) ($videoSize >> 32);
            if (Float.intBitsToFloat(bits$iv$iv$iv) <= Float.intBitsToFloat(bits$iv$iv$iv2)) {
                float dpScaled2 = ProvideUiScaleKt.dpScaled((int) BackoffConfigKt.MAX_DELAY_SECONDS, $scale);
                int bits$iv$iv$iv3 = (int) (4294967295L & $videoSize);
                int bits$iv$iv$iv4 = (int) ($videoSize >> 32);
                float other$iv = Float.intBitsToFloat(bits$iv$iv$iv3) / Float.intBitsToFloat(bits$iv$iv$iv4);
                dpScaled = Dp.constructor-impl(dpScaled2 * other$iv);
                return Dp.box-impl(dpScaled);
            }
        }
        dpScaled = ProvideUiScaleKt.dpScaled((int) BackoffConfigKt.MAX_DELAY_SECONDS, $scale);
        return Dp.box-impl(dpScaled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset MiniVideoFloatingComponent_hqqSWsU$lambda$13$0(Animatable $animX, Animatable $animY, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        int x$iv = (int) ((Number) $animX.getValue()).floatValue();
        int y$iv = (int) ((Number) $animY.getValue()).floatValue();
        return IntOffset.box-impl(IntOffset.constructor-impl((x$iv << 32) | (y$iv & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MiniVideoFloatingComponent_hqqSWsU$lambda$15$0$0(Function1 $toggleHeaderFullScreenPreview) {
        $toggleHeaderFullScreenPreview.invoke(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MiniVideoFloatingComponent_hqqSWsU$lambda$15$1$0(Function0 $toggleMuted) {
        $toggleMuted.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MiniVideoFloatingComponent_hqqSWsU$lambda$15$2$0(Function0 $togglePause, MutableState $closeByClick$delegate) {
        $togglePause.invoke();
        MiniVideoFloatingComponent_hqqSWsU$lambda$2($closeByClick$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0109, code lost:
        if (r0 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02e8, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L85;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:158:0x086e  */
    /* JADX WARN: Type inference failed for: r0v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void MiniVideoPlayerComponent(final SimplePlayer videoPlayer, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean muted, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        int i2;
        Painter painter;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Object value$iv;
        Composer $composer$iv$iv$iv;
        SimplePlayer simplePlayer;
        Composer $composer3 = $composer.startRestartGroup(1837189060);
        ComposerKt.sourceInformation($composer3, "C(MiniVideoPlayerComponent)N(videoPlayer,movableVideoPlayerView,muted,onVideo,onMute,onClose,scale,modifier)229@8376L13,225@8273L3702:MiniVideoFloatingComponent.kt#o90vz8");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(videoPlayer) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(muted) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changedInstance(function02) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function03) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer3.changed(scale) ? 1048576 : 524288;
        }
        int i3 = i & 128;
        if (i3 != 0) {
            $dirty2 |= 12582912;
            modifier2 = modifier;
        } else if ((12582912 & $changed) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 8388608 : 4194304;
        } else {
            modifier2 = modifier;
        }
        if (!$composer3.shouldExecute(($dirty2 & 4793491) != 4793490, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i3 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1837189060, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.MiniVideoPlayerComponent (MiniVideoFloatingComponent.kt:224)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 307139953, "CC(remember):MiniVideoFloatingComponent.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 7168) == 2048;
            Object value$iv2 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda6
                public final Object invoke() {
                    Unit MiniVideoPlayerComponent$lambda$0$0;
                    MiniVideoPlayerComponent$lambda$0$0 = MiniVideoFloatingComponentKt.MiniVideoPlayerComponent$lambda$0$0(function0);
                    return MiniVideoPlayerComponent$lambda$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv2, 15, (Object) null);
            modifier3 = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            $composer2 = $composer3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$MiniVideoPlayerComponent_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1173366159, "C231@8407L24,233@8441L612,255@9194L12,251@9063L707,277@9909L13,273@9780L527,290@10317L1652:MiniVideoFloatingComponent.kt#o90vz8");
            function2.invoke($composer3, Integer.valueOf(($dirty2 >> 3) & 14));
            BoxKt.Box(BackgroundKt.background$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default($this$MiniVideoPlayerComponent_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getTopCenter()), 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(20, scale)), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.Companion.getTransparent-0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer3, 0);
            Modifier align = $this$MiniVideoPlayerComponent_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getTopStart());
            ComposerKt.sourceInformationMarkerStart($composer3, -1209053834, "CC(remember):MiniVideoFloatingComponent.kt#9igjgp");
            boolean invalid$iv2 = (57344 & $dirty2) == 16384;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv3 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit MiniVideoPlayerComponent$lambda$1$0$0;
                    MiniVideoPlayerComponent$lambda$1$0$0 = MiniVideoFloatingComponentKt.MiniVideoPlayerComponent$lambda$1$0$0(function02);
                    return MiniVideoPlayerComponent$lambda$1$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            it$iv = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(align, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            $dirty = $dirty2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i7 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 101422796, "C257@9232L528:MiniVideoFloatingComponent.kt#o90vz8");
            if (muted) {
                $composer3.startReplaceGroup(101471620);
                ComposerKt.sourceInformation($composer3, "260@9334L26");
                i2 = 6;
                Painter speaker_sound_off_line_500 = BiliIconfont.INSTANCE.getSpeaker_sound_off_line_500($composer3, 6);
                $composer3.endReplaceGroup();
                painter = speaker_sound_off_line_500;
            } else {
                i2 = 6;
                $composer3.startReplaceGroup(101563845);
                ComposerKt.sourceInformation($composer3, "262@9427L25");
                Painter speaker_sound_on_line_500 = BiliIconfont.INSTANCE.getSpeaker_sound_on_line_500($composer3, 6);
                $composer3.endReplaceGroup();
                painter = speaker_sound_on_line_500;
            }
            IconKt.Icon-ww6aTOc(painter, (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, ProvideUiScaleKt.dpScaled(i2, scale), ProvideUiScaleKt.dpScaled(i2, scale), 0.0f, 0.0f, 12, (Object) null), ProvideUiScaleKt.dpScaled(14, scale)), Color.Companion.getWhite-0d7_KjU(), $composer3, Painter.$stable | 3120, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier align2 = $this$MiniVideoPlayerComponent_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getTopEnd());
            ComposerKt.sourceInformationMarkerStart($composer3, -1209030953, "CC(remember):MiniVideoFloatingComponent.kt#9igjgp");
            boolean invalid$iv3 = ($dirty & 458752) == 131072;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv3 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit MiniVideoPlayerComponent$lambda$1$2$0;
                        MiniVideoPlayerComponent$lambda$1$2$0 = MiniVideoFloatingComponentKt.MiniVideoPlayerComponent$lambda$1$2$0(function03);
                        return MiniVideoPlayerComponent$lambda$1$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
                it$iv2 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(align2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i9 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 759800126, "C280@9993L20,279@9948L349:MiniVideoFloatingComponent.kt#o90vz8");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getXmark_close_line_500($composer3, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, ProvideUiScaleKt.dpScaled(6, scale), ProvideUiScaleKt.dpScaled(6, scale), 0.0f, 9, (Object) null), ProvideUiScaleKt.dpScaled(14, scale)), Color.Companion.getWhite-0d7_KjU(), $composer3, Painter.$stable | 3120, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv4 = BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default($this$MiniVideoPlayerComponent_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, 1, (Object) null), ProvideUiScaleKt.dpScaled(1, scale)), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null);
            Alignment contentAlignment$iv4 = Alignment.Companion.getCenterStart();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
            int $changed$iv$iv4 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer3.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            int i11 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1418212858, "C299@10670L64,302@10794L902,302@10747L949,331@11926L6,326@11709L250:MiniVideoFloatingComponent.kt#o90vz8");
            ComposerKt.sourceInformationMarkerStart($composer3, -785535703, "CC(remember):MiniVideoFloatingComponent.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                value$iv = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv3;
            }
            MutableFloatState progress$delegate = (MutableFloatState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SimplePlayerState state = videoPlayer.getState();
            ComposerKt.sourceInformationMarkerStart($composer3, -785530897, "CC(remember):MiniVideoFloatingComponent.kt#9igjgp");
            boolean invalid$iv4 = ($dirty & 14) == 4;
            Object it$iv4 = $composer3.rememberedValue();
            if (!invalid$iv4 && it$iv4 != Composer.Companion.getEmpty()) {
                $composer$iv$iv$iv = $composer3;
                simplePlayer = videoPlayer;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(simplePlayer, state, (Function2) it$iv4, $composer3, $dirty & 14);
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth(Modifier.Companion, MiniVideoPlayerComponent$lambda$1$4$1(progress$delegate)), ProvideUiScaleKt.dpScaled(1, scale)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (Shape) null, 2, (Object) null), $composer3, 0);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $composer$iv$iv$iv = $composer3;
            simplePlayer = videoPlayer;
            Object value$iv5 = (Function2) new MiniVideoFloatingComponentKt$MiniVideoPlayerComponent$2$5$1$1(simplePlayer, progress$delegate, null);
            $composer3.updateRememberedValue(value$iv5);
            it$iv4 = value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(simplePlayer, state, (Function2) it$iv4, $composer3, $dirty & 14);
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth(Modifier.Companion, MiniVideoPlayerComponent$lambda$1$4$1(progress$delegate)), ProvideUiScaleKt.dpScaled(1, scale)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (Shape) null, 2, (Object) null), $composer3, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.MiniVideoFloatingComponentKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit MiniVideoPlayerComponent$lambda$2;
                    MiniVideoPlayerComponent$lambda$2 = MiniVideoFloatingComponentKt.MiniVideoPlayerComponent$lambda$2(videoPlayer, function2, muted, function0, function02, function03, scale, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MiniVideoPlayerComponent$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MiniVideoPlayerComponent$lambda$0$0(Function0 $onVideo) {
        $onVideo.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MiniVideoPlayerComponent$lambda$1$0$0(Function0 $onMute) {
        $onMute.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MiniVideoPlayerComponent$lambda$1$2$0(Function0 $onClose) {
        $onClose.invoke();
        return Unit.INSTANCE;
    }

    private static final float MiniVideoPlayerComponent$lambda$1$4$1(MutableFloatState $progress$delegate) {
        FloatState $this$getValue$iv = (FloatState) $progress$delegate;
        return $this$getValue$iv.getFloatValue();
    }
}