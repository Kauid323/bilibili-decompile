package kntr.common.photonic.aphro.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchors;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
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
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.ContentSize;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.ui.component.AlbumListKt;
import kntr.common.photonic.aphro.ui.component.CurrentAlbumKt;
import kntr.common.photonic.aphro.ui.component.MediaListKt;
import kntr.common.photonic.aphro.ui.component.SelectedBottomRowKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: MediaSelectFloat.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a5\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0017\u001ak\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b#\u0010$\u001a3\u0010%\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0007¢\u0006\u0004\b&\u0010'\u001ac\u0010(\u001a\u00020\r2\b\b\u0002\u0010)\u001a\u00020\u001e2\u0014\b\u0002\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\b24\b\u0002\u0010+\u001a.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0-\u0012\u0013\u0012\u00110.¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u00010,¢\u0006\u0002\b2H\u0007¢\u0006\u0002\u00103\u001a\u0013\u00104\u001a\u000205*\u000206H\u0001¢\u0006\u0004\b7\u00108¨\u00069²\u0006\n\u0010:\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u0010\u001f\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u0010;\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010<\u001a\u00020\u0014X\u008a\u0084\u0002"}, d2 = {"MediaSelectFloat", "", "state", "Lkntr/common/photonic/aphro/core/AphroState;", "baseHeightDp", "Landroidx/compose/ui/unit/Dp;", "maxHeight", "onAction", "Lkotlin/Function1;", "Lkntr/common/photonic/aphro/core/AphroAction;", "modifier", "Landroidx/compose/ui/Modifier;", "collapseState", "Lkntr/common/photonic/aphro/ui/CollapseState;", "MediaSelectFloat-ZUYZQmM", "(Lkntr/common/photonic/aphro/core/AphroState;FFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkntr/common/photonic/aphro/ui/CollapseState;Landroidx/compose/runtime/Composer;II)V", "OriginCheckBox", "selectedState", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;", "alpha", "", "onClick", "Lkotlin/Function0;", "(Lkntr/common/photonic/aphro/core/AphroState$AphroContent;FLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "MediaFloatTopBar", "color", "Landroidx/compose/ui/graphics/Color;", "progress", "swipeableState", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "Lkntr/common/photonic/aphro/ui/CollapseStatus;", "albumExpanded", "", "onAlbumExpand", "onBack", "MediaFloatTopBar-pzZJ40c", "(JFLkntr/common/photonic/aphro/core/AphroState;Landroidx/compose/foundation/gestures/AnchoredDraggableState;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "MediaSelectPullBar", "MediaSelectPullBar-KTwxG1Y", "(JLandroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/runtime/Composer;II)V", "rememberCollapseState", "initState", "onStatusChange", "anchorsConfigBuilder", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DraggableAnchorsConfig;", "", "Lkotlin/ParameterName;", "name", "maxOffsetPx", "Lkotlin/ExtensionFunctionType;", "(Lkntr/common/photonic/aphro/ui/CollapseStatus;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)Lkntr/common/photonic/aphro/ui/CollapseState;", "displayString", "", "Lkntr/common/photonic/ContentSize;", "displayString-4yfSoQ8", "(D)Ljava/lang/String;", "ui_debug", "floatDrag", "animateOffset", "backAlpha"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MediaSelectFloatKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaFloatTopBar_pzZJ40c$lambda$2(long j, float f, AphroState aphroState, AnchoredDraggableState anchoredDraggableState, boolean z, Function1 function1, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m2241MediaFloatTopBarpzZJ40c(j, f, aphroState, anchoredDraggableState, z, function1, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectFloat_ZUYZQmM$lambda$18(AphroState aphroState, float f, float f2, Function1 function1, Modifier modifier, CollapseState collapseState, int i, int i2, Composer composer, int i3) {
        m2242MediaSelectFloatZUYZQmM(aphroState, f, f2, function1, modifier, collapseState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectPullBar_KTwxG1Y$lambda$2(long j, Modifier modifier, AnchoredDraggableState anchoredDraggableState, int i, int i2, Composer composer, int i3) {
        m2243MediaSelectPullBarKTwxG1Y(j, modifier, anchoredDraggableState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OriginCheckBox$lambda$2(AphroState.AphroContent aphroContent, float f, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        OriginCheckBox(aphroContent, f, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x023d, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0409, code lost:
        if (r0 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0672, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L127;
     */
    /* renamed from: MediaSelectFloat-ZUYZQmM  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2242MediaSelectFloatZUYZQmM(final AphroState state, final float f, final float f2, final Function1<? super AphroAction, Unit> function1, Modifier modifier, CollapseState collapseState, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        CollapseState collapseState2;
        Composer $composer2;
        Modifier modifier3;
        boolean z;
        int $dirty;
        final CollapseState collapseState3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        String str;
        Arrangement.Vertical verticalArrangement$iv;
        Composer $composer$iv;
        float progress;
        Composer $composer$iv$iv$iv;
        Modifier materialized$iv$iv;
        String str2;
        Composer $composer$iv$iv;
        Composer $composer$iv2;
        int i2;
        State animateOffset$delegate;
        Composer $composer3;
        int i3;
        int i4;
        float f3;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        final AphroState aphroState;
        boolean z2;
        int i5;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer4 = $composer.startRestartGroup(809634883);
        ComposerKt.sourceInformation($composer4, "C(MediaSelectFloat)N(state,baseHeightDp:c#ui.unit.Dp,maxHeight:c#ui.unit.Dp,onAction,modifier,collapseState)87@3906L24,89@3963L7,95@4095L46,99@4168L46,103@4241L115,109@4420L609,126@5072L2593,209@8166L68,211@8269L6,211@8297L6,218@8511L216,225@8738L53,213@8324L4973:MediaSelectFloat.kt#3c04ha");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer4.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer4.changed(f) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer4.changed(f2) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer4.changedInstance(function1) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer4.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 196608) == 0) {
            if ((i & 32) == 0) {
                collapseState2 = collapseState;
                if ($composer4.changed(collapseState2)) {
                    i5 = 131072;
                    $dirty2 |= i5;
                }
            } else {
                collapseState2 = collapseState;
            }
            i5 = 65536;
            $dirty2 |= i5;
        } else {
            collapseState2 = collapseState;
        }
        if ($composer4.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer4.startDefaults();
            ComposerKt.sourceInformation($composer4, "85@3861L23");
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                Modifier modifier5 = i6 != 0 ? (Modifier) Modifier.Companion : modifier2;
                if ((i & 32) != 0) {
                    z = false;
                    $dirty = $dirty2 & (-458753);
                    collapseState3 = rememberCollapseState(null, null, null, $composer4, 0, 7);
                    modifier4 = modifier5;
                } else {
                    z = false;
                    $dirty = $dirty2;
                    collapseState3 = collapseState2;
                    modifier4 = modifier5;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                $dirty = $dirty2;
                z = false;
                collapseState3 = collapseState2;
                modifier4 = modifier2;
            }
            $composer4.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(809634883, $dirty, -1, "kntr.common.photonic.aphro.ui.MediaSelectFloat (MediaSelectFloat.kt:86)");
            }
            ComposerKt.sourceInformationMarkerStart($composer4, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer4, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer4.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4);
                $composer4.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer4.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final Density density = (Density) consume;
            float offsetPxMax = density.toPx-0680j_4(Dp.constructor-impl(f - f2));
            ComposerKt.sourceInformationMarkerStart($composer4, 670055697, "CC(remember):MediaSelectFloat.kt#9igjgp");
            Object value$iv = $composer4.rememberedValue();
            if (value$iv == Composer.Companion.getEmpty()) {
                value$iv = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv);
            }
            final MutableState floatDrag$delegate = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, 670058033, "CC(remember):MediaSelectFloat.kt#9igjgp");
            Object it$iv = $composer4.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            final MutableState albumExpanded$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, 670060438, "CC(remember):MediaSelectFloat.kt#9igjgp");
            boolean invalid$iv = ((((458752 & $dirty) ^ 196608) <= 131072 || !$composer4.changed(collapseState3)) && ($dirty & 196608) != 131072) ? z : true;
            Object it$iv2 = $composer4.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv3 = collapseState3.buildAnchorsConfig((int) offsetPxMax);
            $composer4.updateRememberedValue(value$iv3);
            it$iv2 = value$iv3;
            DraggableAnchors anchors = (DraggableAnchors) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, 670066660, "CC(remember):MediaSelectFloat.kt#9igjgp");
            boolean invalid$iv2 = ((((458752 & $dirty) ^ 196608) <= 131072 || !$composer4.changed(collapseState3)) && ($dirty & 196608) != 131072) ? z : true;
            Object it$iv3 = $composer4.rememberedValue();
            int $dirty3 = $dirty;
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = AnchoredDraggableKt.AnchoredDraggableState(collapseState3.getInitState(), anchors, new Function1() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj) {
                        float MediaSelectFloat_ZUYZQmM$lambda$8$0;
                        MediaSelectFloat_ZUYZQmM$lambda$8$0 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$8$0(((Float) obj).floatValue());
                        return Float.valueOf(MediaSelectFloat_ZUYZQmM$lambda$8$0);
                    }
                }, new Function0() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda18
                    public final Object invoke() {
                        float MediaSelectFloat_ZUYZQmM$lambda$8$1;
                        MediaSelectFloat_ZUYZQmM$lambda$8$1 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$8$1(density);
                        return Float.valueOf(MediaSelectFloat_ZUYZQmM$lambda$8$1);
                    }
                }, new SpringSpec(0.0f, 0.0f, (Object) null, 7, (DefaultConstructorMarker) null), DecayAnimationSpecKt.exponentialDecay$default(0.0f, 0.0f, 3, (Object) null), new Function1() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        boolean MediaSelectFloat_ZUYZQmM$lambda$8$2;
                        MediaSelectFloat_ZUYZQmM$lambda$8$2 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$8$2(CollapseState.this, floatDrag$delegate, (CollapseStatus) obj);
                        return Boolean.valueOf(MediaSelectFloat_ZUYZQmM$lambda$8$2);
                    }
                });
                $composer4.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            final AnchoredDraggableState draggableState = (AnchoredDraggableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, 670089508, "CC(remember):MediaSelectFloat.kt#9igjgp");
            Object it$iv4 = $composer4.rememberedValue();
            CollapseState collapseState4 = collapseState3;
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1(draggableState, floatDrag$delegate);
                $composer4.updateRememberedValue(value$iv5);
                it$iv4 = value$iv5;
            }
            MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1 nestedScrollConnection = (MediaSelectFloatKt$MediaSelectFloat$nestedScrollConnection$1$1) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            float offsetYPx = draggableState.getOffset();
            float offsetYDp = density.toDp-u2uoSUM(offsetYPx);
            float $this$MediaSelectFloat_ZUYZQmM_u24lambda_u2412 = RangesKt.coerceIn((-offsetYPx) / density.toPx-0680j_4(Dp.constructor-impl(f2 - f)), 0.0f, 1.0f);
            float progress2 = Math.abs($this$MediaSelectFloat_ZUYZQmM_u24lambda_u2412) < 0.001f ? 0.0f : Math.abs($this$MediaSelectFloat_ZUYZQmM_u24lambda_u2412 - 1.0f) < 0.001f ? 1.0f : $this$MediaSelectFloat_ZUYZQmM_u24lambda_u2412;
            final State animateOffset$delegate2 = AnimateAsStateKt.animateDpAsState-AjpBEmI(Dp.constructor-impl(Dp.constructor-impl(f2 - f) + offsetYDp), (AnimationSpec) null, (String) null, (Function1) null, $composer4, 0, 14);
            final long bgColor = ColorKt.lerp-jxsXWHM(BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg1_float-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg1-0d7_KjU(), progress2);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null);
            Dp dp = Dp.box-impl(f2);
            dp.unbox-impl();
            if (Dp.equals-impl0(f, Dp.constructor-impl(0))) {
                dp = null;
            }
            Modifier modifier6 = SizeKt.height-3ABfNKs(fillMaxWidth$default, dp != null ? dp.unbox-impl() : f);
            ComposerKt.sourceInformationMarkerStart($composer4, 670197179, "CC(remember):MediaSelectFloat.kt#9igjgp");
            boolean invalid$iv3 = $composer4.changed(animateOffset$delegate2);
            Object value$iv6 = $composer4.rememberedValue();
            if (invalid$iv3) {
            }
            value$iv6 = new Function1() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    IntOffset MediaSelectFloat_ZUYZQmM$lambda$15$0;
                    MediaSelectFloat_ZUYZQmM$lambda$15$0 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$15$0(animateOffset$delegate2, (Density) obj);
                    return MediaSelectFloat_ZUYZQmM$lambda$15$0;
                }
            };
            $composer4.updateRememberedValue(value$iv6);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier offset = OffsetKt.offset(modifier6, (Function1) value$iv6);
            ComposerKt.sourceInformationMarkerStart($composer4, 670204280, "CC(remember):MediaSelectFloat.kt#9igjgp");
            Object it$iv5 = $composer4.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv7 = new Function0() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer4.updateRememberedValue(value$iv7);
                it$iv5 = value$iv7;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(offset, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv5, 15, (Object) null);
            boolean z3 = z;
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv, $composer4, (((z3 ? 1 : 0) >> 3) & 14) | (((z3 ? 1 : 0) >> 3) & 112));
            int $changed$iv$iv = ((z3 ? 1 : 0) << 3) & 112;
            $composer2 = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, z ? 1 : 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i8 = (((z3 ? 1 : 0) >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 467121108, "C:MediaSelectFloat.kt#3c04ha");
            if (progress2 == 0.0f) {
                $composer4.startReplaceGroup(467009817);
                ComposerKt.sourceInformation($composer4, "235@9038L6,230@8843L228");
                str = "CC(remember):MediaSelectFloat.kt#9igjgp";
                verticalArrangement$iv = verticalArrangement$iv2;
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) 0.5d)), 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getLine_light-0d7_KjU(), (Shape) null, 2, (Object) null), $composer4, 0);
            } else {
                str = "CC(remember):MediaSelectFloat.kt#9igjgp";
                verticalArrangement$iv = verticalArrangement$iv2;
                $composer4.startReplaceGroup(458242645);
            }
            $composer4.endReplaceGroup();
            if (draggableState.getCurrentValue() == CollapseStatus.EXPAND) {
                $composer4.startReplaceGroup(467322762);
                ComposerKt.sourceInformation($composer4, "239@9162L115");
                m2243MediaSelectPullBarKTwxG1Y(bgColor, null, draggableState, $composer4, 0, 2);
                $composer4.endReplaceGroup();
            } else {
                $composer4.startReplaceGroup(458242645);
                $composer4.endReplaceGroup();
            }
            int $this$dp$iv = Dp.compareTo-0680j_4(f, Dp.constructor-impl(0));
            if ($this$dp$iv > 0) {
                $composer4.startReplaceGroup(467518155);
                ComposerKt.sourceInformation($composer4, "256@9756L22,250@9528L147,245@9335L458");
                boolean MediaSelectFloat_ZUYZQmM$lambda$5 = MediaSelectFloat_ZUYZQmM$lambda$5(albumExpanded$delegate);
                String str3 = str;
                ComposerKt.sourceInformationMarkerStart($composer4, 292188931, str3);
                Object it$iv6 = $composer4.rememberedValue();
                if (it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv8 = new Function1() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            Unit MediaSelectFloat_ZUYZQmM$lambda$17$0$0;
                            MediaSelectFloat_ZUYZQmM$lambda$17$0$0 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$17$0$0(albumExpanded$delegate, ((Boolean) obj).booleanValue());
                            return MediaSelectFloat_ZUYZQmM$lambda$17$0$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv8);
                    it$iv6 = value$iv8;
                }
                Function1 function12 = (Function1) it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerStart($composer4, 292181760, str3);
                boolean invalid$iv4 = $composer4.changedInstance(scope) | $composer4.changed(draggableState);
                Object it$iv7 = $composer4.rememberedValue();
                if (invalid$iv4) {
                }
                Object value$iv9 = new Function0() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit MediaSelectFloat_ZUYZQmM$lambda$17$1$0;
                        MediaSelectFloat_ZUYZQmM$lambda$17$1$0 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$17$1$0(scope, draggableState);
                        return MediaSelectFloat_ZUYZQmM$lambda$17$1$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv9);
                it$iv7 = value$iv9;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer$iv$iv = $composer4;
                $composer$iv2 = $composer4;
                $composer$iv = $composer4;
                progress = progress2;
                animateOffset$delegate = animateOffset$delegate2;
                $composer$iv$iv$iv = $composer4;
                materialized$iv$iv = materialized$iv$iv2;
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                i2 = 0;
                m2241MediaFloatTopBarpzZJ40c(bgColor, progress2, state, draggableState, MediaSelectFloat_ZUYZQmM$lambda$5, function12, (Function0) it$iv7, null, $composer4, (($dirty3 << 6) & 896) | 196608, 128);
                $composer4.endReplaceGroup();
                $composer3 = $composer4;
                i3 = 458242645;
            } else {
                $composer$iv = $composer4;
                progress = progress2;
                $composer$iv$iv$iv = $composer4;
                materialized$iv$iv = materialized$iv$iv2;
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $composer$iv$iv = $composer4;
                $composer$iv2 = $composer4;
                i2 = 0;
                animateOffset$delegate = animateOffset$delegate2;
                $composer3 = $composer4;
                i3 = 458242645;
                $composer3.startReplaceGroup(458242645);
                $composer3.endReplaceGroup();
            }
            final float progress3 = progress;
            if ((progress3 == 1.0f ? 1 : i2) != 0) {
                $composer3.startReplaceGroup(468005847);
                ComposerKt.sourceInformation($composer3, "266@10042L6,261@9847L230");
                i4 = 1;
                f3 = 0.0f;
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) 0.5d)), 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU(), (Shape) null, 2, (Object) null), $composer3, i2);
            } else {
                i4 = 1;
                f3 = 0.0f;
                $composer3.startReplaceGroup(i3);
            }
            $composer3.endReplaceGroup();
            if (state instanceof AphroState.AphroContent) {
                $composer3.startReplaceGroup(468394432);
                ComposerKt.sourceInformation($composer3, "270@10148L3133");
                Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, f3, i4, (Object) null), bgColor, (Shape) null, 2, (Object) null);
                int $changed$iv = i2;
                Composer $composer$iv3 = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = ($changed$iv << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str2);
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, i2));
                CompositionLocalMap localMap$iv$iv2 = $composer$iv3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv2);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv3.startReusableNode();
                if ($composer$iv3.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv5;
                    $composer$iv3.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv5;
                    $composer$iv3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i10 = (($changed$iv >> 6) & 112) | 6;
                BoxScope $this$MediaSelectFloat_ZUYZQmM_u24lambda_u2417_u242 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -2141013796, "C276@10334L1485,321@12354L281,311@11896L739,335@12992L275,329@12680L587:MediaSelectFloat.kt#3c04ha");
                Modifier modifier$iv3 = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.Companion, 0.0f), 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv2, $composer$iv3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                int $changed$iv$iv3 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str2);
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer$iv3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv3.startReusableNode();
                if ($composer$iv3.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer$iv3.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer$iv3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i11 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                int i12 = ((6 >> 6) & 112) | 6;
                ColumnScope $this$MediaSelectFloat_ZUYZQmM_u24lambda_u2417_u242_u240 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -484395504, "C282@10530L465,299@11425L376,294@11078L723:MediaSelectFloat.kt#3c04ha");
                MediaListKt.m2264MediaListau3_HiA((AphroState.AphroContent) state, function1, $this$MediaSelectFloat_ZUYZQmM_u24lambda_u2417_u242_u240.weight(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, true), progress3 == 1.0f, false, nestedScrollConnection, MediaSelectFloat_ZUYZQmM$lambda$13(animateOffset$delegate), $composer$iv3, ($dirty3 & 14) | 196608 | (($dirty3 >> 6) & 112), 16);
                Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                if (progress3 == 1.0f) {
                    aphroState = state;
                    if (!((AphroState.AphroContent) aphroState).getCurrentSelected().isEmpty()) {
                        z2 = true;
                        AnimatedVisibilityKt.AnimatedVisibility(z2, fillMaxWidth$default2, EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-495494204, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda14
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit MediaSelectFloat_ZUYZQmM$lambda$17$2$0$0;
                                MediaSelectFloat_ZUYZQmM$lambda$17$2$0$0 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$17$2$0$0(AphroState.this, function1, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                return MediaSelectFloat_ZUYZQmM$lambda$17$2$0$0;
                            }
                        }, $composer$iv3, 54), $composer$iv3, 200112, 16);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        $composer$iv3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        AnimatedVisibilityKt.AnimatedVisibility(!((AphroState.AphroContent) aphroState).getAlbumList().isEmpty(), PaddingKt.padding-qDBjuR0$default($this$MediaSelectFloat_ZUYZQmM_u24lambda_u2417_u242.align(ZIndexModifierKt.zIndex(Modifier.Companion, 1.0f), Alignment.Companion.getBottomEnd()), 0.0f, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(Dp.constructor-impl(40) + MediaSelectFloat_ZUYZQmM$lambda$13(animateOffset$delegate)), Dp.constructor-impl(0))), 3, (Object) null), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(853148410, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda15
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit MediaSelectFloat_ZUYZQmM$lambda$17$2$1;
                                MediaSelectFloat_ZUYZQmM$lambda$17$2$1 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$17$2$1(progress3, aphroState, function1, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                return MediaSelectFloat_ZUYZQmM$lambda$17$2$1;
                            }
                        }, $composer$iv3, 54), $composer$iv3, 196608, 28);
                        final State state2 = animateOffset$delegate;
                        AnimatedVisibilityKt.AnimatedVisibility(MediaSelectFloat_ZUYZQmM$lambda$5(albumExpanded$delegate), ZIndexModifierKt.zIndex(Modifier.Companion, 2.0f), EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-175522333, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda16
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit MediaSelectFloat_ZUYZQmM$lambda$17$2$2;
                                MediaSelectFloat_ZUYZQmM$lambda$17$2$2 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$17$2$2(AphroState.this, bgColor, function1, state2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                return MediaSelectFloat_ZUYZQmM$lambda$17$2$2;
                            }
                        }, $composer$iv3, 54), $composer$iv3, 200112, 16);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        $composer$iv3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    }
                } else {
                    aphroState = state;
                }
                z2 = false;
                AnimatedVisibilityKt.AnimatedVisibility(z2, fillMaxWidth$default2, EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-495494204, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit MediaSelectFloat_ZUYZQmM$lambda$17$2$0$0;
                        MediaSelectFloat_ZUYZQmM$lambda$17$2$0$0 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$17$2$0$0(AphroState.this, function1, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return MediaSelectFloat_ZUYZQmM$lambda$17$2$0$0;
                    }
                }, $composer$iv3, 54), $composer$iv3, 200112, 16);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                AnimatedVisibilityKt.AnimatedVisibility(!((AphroState.AphroContent) aphroState).getAlbumList().isEmpty(), PaddingKt.padding-qDBjuR0$default($this$MediaSelectFloat_ZUYZQmM_u24lambda_u2417_u242.align(ZIndexModifierKt.zIndex(Modifier.Companion, 1.0f), Alignment.Companion.getBottomEnd()), 0.0f, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(Dp.constructor-impl(40) + MediaSelectFloat_ZUYZQmM$lambda$13(animateOffset$delegate)), Dp.constructor-impl(0))), 3, (Object) null), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(853148410, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit MediaSelectFloat_ZUYZQmM$lambda$17$2$1;
                        MediaSelectFloat_ZUYZQmM$lambda$17$2$1 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$17$2$1(progress3, aphroState, function1, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return MediaSelectFloat_ZUYZQmM$lambda$17$2$1;
                    }
                }, $composer$iv3, 54), $composer$iv3, 196608, 28);
                final State state22 = animateOffset$delegate;
                AnimatedVisibilityKt.AnimatedVisibility(MediaSelectFloat_ZUYZQmM$lambda$5(albumExpanded$delegate), ZIndexModifierKt.zIndex(Modifier.Companion, 2.0f), EnterExitTransitionKt.expandVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), EnterExitTransitionKt.shrinkVertically$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), (Alignment.Vertical) null, false, (Function1) null, 14, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-175522333, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda16
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit MediaSelectFloat_ZUYZQmM$lambda$17$2$2;
                        MediaSelectFloat_ZUYZQmM$lambda$17$2$2 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$17$2$2(AphroState.this, bgColor, function1, state22, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return MediaSelectFloat_ZUYZQmM$lambda$17$2$2;
                    }
                }, $composer$iv3, 54), $composer$iv3, 200112, 16);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            } else {
                $composer3.startReplaceGroup(i3);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            collapseState2 = collapseState4;
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final CollapseState collapseState5 = collapseState2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit MediaSelectFloat_ZUYZQmM$lambda$18;
                    MediaSelectFloat_ZUYZQmM$lambda$18 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$18(AphroState.this, f, f2, function1, modifier7, collapseState5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MediaSelectFloat_ZUYZQmM$lambda$18;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MediaSelectFloat_ZUYZQmM$lambda$2(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MediaSelectFloat_ZUYZQmM$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final boolean MediaSelectFloat_ZUYZQmM$lambda$5(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void MediaSelectFloat_ZUYZQmM$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float MediaSelectFloat_ZUYZQmM$lambda$8$0(float distance) {
        return 0.5f * distance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float MediaSelectFloat_ZUYZQmM$lambda$8$1(Density $density) {
        return $density.toPx-0680j_4(Dp.constructor-impl(125));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MediaSelectFloat_ZUYZQmM$lambda$8$2(CollapseState $collapseState, MutableState $floatDrag$delegate, CollapseStatus it) {
        Intrinsics.checkNotNullParameter(it, "it");
        MediaSelectFloat_ZUYZQmM$lambda$3($floatDrag$delegate, false);
        $collapseState.getOnStatusChanged().invoke(it);
        return true;
    }

    private static final float MediaSelectFloat_ZUYZQmM$lambda$13(State<Dp> state) {
        Object thisObj$iv = state.getValue();
        return ((Dp) thisObj$iv).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset MediaSelectFloat_ZUYZQmM$lambda$15$0(State $animateOffset$delegate, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        int y$iv = MathKt.roundToInt($this$offset.toPx-0680j_4(MediaSelectFloat_ZUYZQmM$lambda$13($animateOffset$delegate)));
        return IntOffset.box-impl(IntOffset.constructor-impl((0 << 32) | (y$iv & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectFloat_ZUYZQmM$lambda$17$1$0(CoroutineScope $scope, AnchoredDraggableState $draggableState) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new MediaSelectFloatKt$MediaSelectFloat$4$2$1$1($draggableState, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectFloat_ZUYZQmM$lambda$17$0$0(MutableState $albumExpanded$delegate, boolean it) {
        MediaSelectFloat_ZUYZQmM$lambda$6($albumExpanded$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectFloat_ZUYZQmM$lambda$17$2$0$0(AphroState $state, Function1 $onAction, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C303@11643L6,300@11451L328:MediaSelectFloat.kt#3c04ha");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-495494204, $changed, -1, "kntr.common.photonic.aphro.ui.MediaSelectFloat.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MediaSelectFloat.kt:300)");
        }
        SelectedBottomRowKt.SelectedBottom((AphroState.AphroContent) $state, true, false, $onAction, BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 432, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectFloat_ZUYZQmM$lambda$17$2$1(float $progress, final AphroState $state, final Function1 $onAction, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C325@12521L73,322@12376L241:MediaSelectFloat.kt#3c04ha");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(853148410, $changed, -1, "kntr.common.photonic.aphro.ui.MediaSelectFloat.<anonymous>.<anonymous>.<anonymous> (MediaSelectFloat.kt:322)");
        }
        float f = 1 - $progress;
        AphroState.AphroContent aphroContent = (AphroState.AphroContent) $state;
        ComposerKt.sourceInformationMarkerStart($composer, -463126109, "CC(remember):MediaSelectFloat.kt#9igjgp");
        boolean invalid$iv = $composer.changed($onAction) | $composer.changed($state);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda9
                public final Object invoke() {
                    Unit MediaSelectFloat_ZUYZQmM$lambda$17$2$1$0$0;
                    MediaSelectFloat_ZUYZQmM$lambda$17$2$1$0$0 = MediaSelectFloatKt.MediaSelectFloat_ZUYZQmM$lambda$17$2$1$0$0($onAction, $state);
                    return MediaSelectFloat_ZUYZQmM$lambda$17$2$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        OriginCheckBox(aphroContent, f, (Function0) it$iv, null, $composer, 0, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectFloat_ZUYZQmM$lambda$17$2$1$0$0(Function1 $onAction, AphroState $state) {
        $onAction.invoke(new AphroAction.CheckUseOriginImage(!((AphroState.AphroContent) $state).getUseOriginImage()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaSelectFloat_ZUYZQmM$lambda$17$2$2(AphroState $state, long $bgColor, Function1 $onAction, State $animateOffset$delegate, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C336@13014L235:MediaSelectFloat.kt#3c04ha");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-175522333, $changed, -1, "kntr.common.photonic.aphro.ui.MediaSelectFloat.<anonymous>.<anonymous>.<anonymous> (MediaSelectFloat.kt:336)");
        }
        AlbumListKt.m2251AlbumListpHQ97Tc($bgColor, ((AphroState.AphroContent) $state).getAlbumList(), $onAction, null, MediaSelectFloat_ZUYZQmM$lambda$13($animateOffset$delegate), $composer, 0, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void OriginCheckBox(final AphroState.AphroContent selectedState, final float alpha, final Function0<Unit> function0, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        String str;
        Intrinsics.checkNotNullParameter(selectedState, "selectedState");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-2035876671);
        ComposerKt.sourceInformation($composer2, "C(OriginCheckBox)N(selectedState,alpha,onClick,modifier)361@13640L6,362@13744L49,355@13463L1845:MediaSelectFloat.kt#3c04ha");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(selectedState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(alpha) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2035876671, $dirty2, -1, "kntr.common.photonic.aphro.ui.OriginCheckBox (MediaSelectFloat.kt:354)");
            }
            Modifier modifier5 = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(AlphaKt.alpha(modifier4, alpha), Dp.constructor-impl(34)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(20)));
            boolean z = alpha > 0.5f;
            ComposerKt.sourceInformationMarkerStart($composer2, 2027619986, "CC(remember):MediaSelectFloat.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit OriginCheckBox$lambda$0$0;
                        OriginCheckBox$lambda$0$0 = MediaSelectFloatKt.OriginCheckBox$lambda$0$0(function0);
                        return OriginCheckBox$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(modifier5, z, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 14, (Object) null), Dp.constructor-impl(10), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            modifier3 = modifier4;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1107099609, "C402@15253L6,390@14707L595:MediaSelectFloat.kt#3c04ha");
            if (selectedState.getUseOriginImage()) {
                $composer2.startReplaceGroup(-1107083428);
                ComposerKt.sourceInformation($composer2, "369@13988L18,373@14155L6,368@13943L393");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getCheckmark_line_800($composer2, 6), (String) null, PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl((float) 2.73d)), Color.Companion.getWhite-0d7_KjU(), $composer2, Painter.$stable | 3120, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1106679157);
                ComposerKt.sourceInformation($composer2, "385@14585L6,379@14366L322");
                BoxKt.Box(BorderKt.border-xT4_qwU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), $composer2, 0);
                $composer2.endReplaceGroup();
            }
            Modifier modifier6 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            if (selectedState.getUseOriginImage() && !selectedState.getCurrentSelected().isEmpty()) {
                $composer2.startReplaceGroup(-1106156590);
                ComposerKt.sourceInformation($composer2, "394@14905L171");
                String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_356(Res.string.INSTANCE), new Object[]{m2244displayString4yfSoQ8(selectedState.m2202getTotalSelectedSizeQJZHGII())}, $composer2, 0);
                $composer2.endReplaceGroup();
                str = stringResource;
            } else {
                $composer2.startReplaceGroup(-1105945046);
                ComposerKt.sourceInformation($composer2, "399@15122L51");
                String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_435(Res.string.INSTANCE), $composer2, 0);
                $composer2.endReplaceGroup();
                str = stringResource2;
            }
            TextKt.Text-Nvy7gAk(str, modifier6, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, (TextStyle) null, $composer2, 24624, 24576, 245736);
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
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit OriginCheckBox$lambda$2;
                    OriginCheckBox$lambda$2 = MediaSelectFloatKt.OriginCheckBox$lambda$2(AphroState.AphroContent.this, alpha, function0, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OriginCheckBox$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OriginCheckBox$lambda$0$0(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: MediaFloatTopBar-pzZJ40c  reason: not valid java name */
    public static final void m2241MediaFloatTopBarpzZJ40c(final long j, final float progress, final AphroState state, final AnchoredDraggableState<CollapseStatus> anchoredDraggableState, final boolean albumExpanded, final Function1<? super Boolean, Unit> function1, final Function0<Unit> function0, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        int $dirty;
        Composer $composer$iv;
        String str;
        Composer $composer$iv2;
        Composer $composer$iv$iv$iv;
        int i2;
        int i3;
        float f;
        float f2;
        Composer $composer3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function1, "onAlbumExpand");
        Intrinsics.checkNotNullParameter(function0, "onBack");
        Composer $composer4 = $composer.startRestartGroup(2061573840);
        ComposerKt.sourceInformation($composer4, "C(MediaFloatTopBar)N(color:c#ui.graphics.Color,progress,state,swipeableState,albumExpanded,onAlbumExpand,onBack,modifier)421@15659L2206:MediaSelectFloat.kt#3c04ha");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer4.changed(j) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer4.changed(progress) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer4.changed(state) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer4.changed(anchoredDraggableState) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer4.changed(albumExpanded) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer4.changedInstance(function1) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer4.changedInstance(function0) ? 1048576 : 524288;
        }
        int i4 = i & 128;
        if (i4 != 0) {
            $dirty2 |= 12582912;
            modifier2 = modifier;
        } else if ((12582912 & $changed) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer4.changed(modifier2) ? 8388608 : 4194304;
        } else {
            modifier2 = modifier;
        }
        if ($composer4.shouldExecute(($dirty2 & 4793491) != 4793490, $dirty2 & 1)) {
            Modifier modifier5 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2061573840, $dirty2, -1, "kntr.common.photonic.aphro.ui.MediaFloatTopBar (MediaSelectFloat.kt:420)");
            }
            float f3 = Dp.constructor-impl(48);
            float other$iv = RangesKt.coerceIn(progress, 0.0f, 1.0f);
            Modifier modifier6 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(modifier5, Dp.constructor-impl(f3 * other$iv)), 0.0f, 1, (Object) null), j, (Shape) null, 2, (Object) null);
            boolean predict$iv = anchoredDraggableState != null;
            Modifier $this$ifMatch$iv = modifier6;
            if (predict$iv) {
                if (anchoredDraggableState != null) {
                    $dirty = $dirty2;
                    modifier3 = modifier5;
                    $composer2 = $composer4;
                    modifier4 = AnchoredDraggableKt.anchoredDraggable$default($this$ifMatch$iv, anchoredDraggableState, Orientation.Vertical, false, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 60, (Object) null);
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier5;
                    $composer2 = $composer4;
                    modifier4 = $this$ifMatch$iv;
                }
                $this$ifMatch$iv = modifier4;
            } else {
                $dirty = $dirty2;
                modifier3 = modifier5;
                $composer2 = $composer4;
            }
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Modifier modifier$iv = $this$ifMatch$iv;
            Composer $composer$iv3 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
            CompositionLocalMap localMap$iv$iv = $composer$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv3.startReusableNode();
            if ($composer$iv3.getInserting()) {
                $composer$iv3.createNode(factory$iv$iv$iv3);
            } else {
                $composer$iv3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((432 >> 6) & 112) | 6;
            RowScope $this$MediaFloatTopBar_pzZJ40c_u24lambda_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 335935783, "C460@17044L144,471@17499L56,464@17197L662:MediaSelectFloat.kt#3c04ha");
            if (state instanceof AphroState.AphroContent) {
                $composer$iv3.startReplaceGroup(335946198);
                ComposerKt.sourceInformation($composer$iv3, "441@16399L608");
                Modifier modifier$iv2 = SizeKt.wrapContentHeight($this$MediaFloatTopBar_pzZJ40c_u24lambda_u241.weight(Modifier.Companion, 1.0f, true), Alignment.Companion.getTop(), true);
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer$iv3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv3.startReusableNode();
                if ($composer$iv3.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv3.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i8 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1169262120, "C447@16619L374:MediaSelectFloat.kt#3c04ha");
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                f2 = 0.0f;
                $composer$iv$iv$iv = $composer$iv3;
                $composer$iv = $composer$iv3;
                i3 = 6;
                $composer$iv2 = $composer$iv3;
                i2 = 0;
                f = 1.0f;
                CurrentAlbumKt.CurrentAlbum((AphroState.AphroContent) state, albumExpanded, function1, PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), 0.0f, 1, (Object) null), Dp.constructor-impl(56), 0.0f, Dp.constructor-impl(8), 0.0f, 10, (Object) null), $composer$iv3, (($dirty >> 6) & 14) | 3072 | (($dirty >> 9) & 112) | (($dirty >> 9) & 896), 0);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endReplaceGroup();
                $composer3 = $composer$iv3;
            } else {
                $composer$iv = $composer$iv3;
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $composer$iv2 = $composer$iv3;
                $composer$iv$iv$iv = $composer$iv3;
                i2 = 0;
                i3 = 6;
                f = 1.0f;
                f2 = 0.0f;
                $composer3 = $composer$iv3;
                $composer3.startReplaceGroup(319671694);
                $composer3.endReplaceGroup();
            }
            State backAlpha$delegate = AnimateAsStateKt.animateFloatAsState(albumExpanded ? f2 : f, AnimationSpecKt.tween$default(250, i2, (Easing) null, i3, (Object) null), 0.0f, (String) null, (Function1) null, $composer3, 48, 28);
            Modifier alpha = AlphaKt.alpha(SizeKt.wrapContentHeight(PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), Dp.constructor-impl(12)), Alignment.Companion.getTop(), true), MediaFloatTopBar_pzZJ40c$lambda$1$1(backAlpha$delegate));
            boolean z = !albumExpanded;
            ComposerKt.sourceInformationMarkerStart($composer3, 2089082028, "CC(remember):MediaSelectFloat.kt#9igjgp");
            int i9 = ($dirty & 3670016) != 1048576 ? i2 : 1;
            Composer $this$cache$iv = $composer3;
            Object it$iv = $this$cache$iv.rememberedValue();
            if (i9 != 0 || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit MediaFloatTopBar_pzZJ40c$lambda$1$2$0;
                        MediaFloatTopBar_pzZJ40c$lambda$1$2$0 = MediaSelectFloatKt.MediaFloatTopBar_pzZJ40c$lambda$1$2$0(function0);
                        return MediaFloatTopBar_pzZJ40c$lambda$1$2$0;
                    }
                };
                $this$cache$iv.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(alpha, z, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 14, (Object) null);
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            Composer $composer$iv4 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -1159599143, str);
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv4, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer$iv4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv4, modifier$iv3);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv4.startReusableNode();
            if ($composer$iv4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer$iv4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer$iv4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i11 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -2086496690, "C477@17675L20,479@17779L6,476@17630L219:MediaSelectFloat.kt#3c04ha");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getXmark_close_line_500($composer$iv4, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getText2-0d7_KjU(), $composer$iv4, Painter.$stable | 432, 0);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            $composer$iv4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit MediaFloatTopBar_pzZJ40c$lambda$2;
                    MediaFloatTopBar_pzZJ40c$lambda$2 = MediaSelectFloatKt.MediaFloatTopBar_pzZJ40c$lambda$2(j, progress, state, anchoredDraggableState, albumExpanded, function1, function0, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MediaFloatTopBar_pzZJ40c$lambda$2;
                }
            });
        }
    }

    private static final float MediaFloatTopBar_pzZJ40c$lambda$1$1(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaFloatTopBar_pzZJ40c$lambda$1$2$0(Function0 $onBack) {
        $onBack.invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: MediaSelectPullBar-KTwxG1Y  reason: not valid java name */
    public static final void m2243MediaSelectPullBarKTwxG1Y(final long j, Modifier modifier, AnchoredDraggableState<CollapseStatus> anchoredDraggableState, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        AnchoredDraggableState anchoredDraggableState2;
        Modifier modifier3;
        AnchoredDraggableState swipeableState;
        Modifier modifier4;
        AnchoredDraggableState swipeableState2;
        Function0 factory$iv$iv$iv;
        long pullBarColor;
        Modifier modifier5;
        Composer $composer2 = $composer.startRestartGroup(1807827078);
        ComposerKt.sourceInformation($composer2, "C(MediaSelectPullBar)N(color:c#ui.graphics.Color,modifier,swipeableState)493@18075L1086:MediaSelectFloat.kt#3c04ha");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(j) ? 4 : 2;
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
            anchoredDraggableState2 = anchoredDraggableState;
        } else if (($changed & 384) == 0) {
            anchoredDraggableState2 = anchoredDraggableState;
            $dirty |= $composer2.changed(anchoredDraggableState2) ? 256 : 128;
        } else {
            anchoredDraggableState2 = anchoredDraggableState;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                swipeableState2 = anchoredDraggableState2;
            } else {
                swipeableState2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1807827078, $dirty2, -1, "kntr.common.photonic.aphro.ui.MediaSelectPullBar (MediaSelectFloat.kt:492)");
            }
            Modifier $this$ifMatch$iv = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(20)), j, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null));
            boolean predict$iv = swipeableState2 != null;
            if (predict$iv) {
                if (swipeableState2 != null) {
                    modifier5 = AnchoredDraggableKt.anchoredDraggable$default($this$ifMatch$iv, swipeableState2, Orientation.Vertical, false, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 60, (Object) null);
                } else {
                    modifier5 = $this$ifMatch$iv;
                }
                $this$ifMatch$iv = modifier5;
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            Modifier modifier$iv$iv = $this$ifMatch$iv;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            AnchoredDraggableState swipeableState3 = swipeableState2;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$MediaSelectPullBar_KTwxG1Y_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -661484484, "C513@18777L13,514@18870L285:MediaSelectFloat.kt#3c04ha");
            if (BiliTheme.INSTANCE.getDayNightTheme($composer2, BiliTheme.$stable) == ThemeDayNight.Night) {
                $composer2.startReplaceGroup(255759235);
                ComposerKt.sourceInformation($composer2, "513@18825L6");
                pullBarColor = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa3-0d7_KjU();
            } else {
                $composer2.startReplaceGroup(255760067);
                ComposerKt.sourceInformation($composer2, "513@18851L6");
                pullBarColor = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa2-0d7_KjU();
            }
            $composer2.endReplaceGroup();
            BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default($this$MediaSelectPullBar_KTwxG1Y_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(4), 7, (Object) null), Dp.constructor-impl(48), Dp.constructor-impl(4)), pullBarColor, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), $composer2, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            swipeableState = swipeableState3;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            swipeableState = anchoredDraggableState2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final AnchoredDraggableState anchoredDraggableState3 = swipeableState;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit MediaSelectPullBar_KTwxG1Y$lambda$2;
                    MediaSelectPullBar_KTwxG1Y$lambda$2 = MediaSelectFloatKt.MediaSelectPullBar_KTwxG1Y$lambda$2(j, modifier6, anchoredDraggableState3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MediaSelectPullBar_KTwxG1Y$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberCollapseState$lambda$0$0(CollapseStatus it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberCollapseState$lambda$1$0(DraggableAnchorsConfig draggableAnchorsConfig, int maxOffsetInt) {
        Intrinsics.checkNotNullParameter(draggableAnchorsConfig, "<this>");
        draggableAnchorsConfig.at(CollapseStatus.COLLAPSE, 0.0f);
        draggableAnchorsConfig.at(CollapseStatus.EXPAND, maxOffsetInt);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r5v3 */
    public static final CollapseState rememberCollapseState(CollapseStatus initState, Function1<? super CollapseStatus, Unit> function1, Function2<? super DraggableAnchorsConfig<CollapseStatus>, ? super Integer, Unit> function2, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 1924522439, "C(rememberCollapseState)N(initState,onStatusChange,anchorsConfigBuilder)542@19812L2,543@19910L117,547@20033L79:MediaSelectFloat.kt#3c04ha");
        if ((i & 1) != 0) {
            initState = CollapseStatus.COLLAPSE;
        }
        if ((i & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart($composer, -1664836503, "CC(remember):MediaSelectFloat.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj) {
                        Unit rememberCollapseState$lambda$0$0;
                        rememberCollapseState$lambda$0$0 = MediaSelectFloatKt.rememberCollapseState$lambda$0$0((CollapseStatus) obj);
                        return rememberCollapseState$lambda$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function1 onStatusChange = it$iv;
            function1 = onStatusChange;
            ComposerKt.sourceInformationMarkerEnd($composer);
        }
        if ((i & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart($composer, -1664833252, "CC(remember):MediaSelectFloat.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function2() { // from class: kntr.common.photonic.aphro.ui.MediaSelectFloatKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj, Object obj2) {
                        Unit rememberCollapseState$lambda$1$0;
                        rememberCollapseState$lambda$1$0 = MediaSelectFloatKt.rememberCollapseState$lambda$1$0((DraggableAnchorsConfig) obj, ((Integer) obj2).intValue());
                        return rememberCollapseState$lambda$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Function2 anchorsConfigBuilder = it$iv2;
            function2 = anchorsConfigBuilder;
            ComposerKt.sourceInformationMarkerEnd($composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1924522439, $changed, -1, "kntr.common.photonic.aphro.ui.rememberCollapseState (MediaSelectFloat.kt:547)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1664829354, "CC(remember):MediaSelectFloat.kt#9igjgp");
        Object it$iv3 = $composer.rememberedValue();
        if (it$iv3 == Composer.Companion.getEmpty()) {
            Object value$iv3 = new CollapseState(initState, function1, function2);
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
        }
        CollapseState collapseState = (CollapseState) it$iv3;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return collapseState;
    }

    /* renamed from: displayString-4yfSoQ8  reason: not valid java name */
    public static final String m2244displayString4yfSoQ8(double d) {
        Pair pair;
        String str;
        if (ContentSize.m2189getMegabytesimpl(d) > 1.0d) {
            pair = TuplesKt.to(String.valueOf(ContentSize.m2189getMegabytesimpl(d)), "M");
        } else {
            pair = TuplesKt.to(String.valueOf(ContentSize.m2188getKilobytesimpl(d)), "K");
        }
        String size = (String) pair.component1();
        String unit = (String) pair.component2();
        int index = StringsKt.indexOf$default(size, '.', 0, false, 6, (Object) null);
        if (index > 0) {
            str = size.substring(0, RangesKt.coerceAtMost(index + 3, size.length()));
            Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
        } else {
            str = size;
        }
        String displaySize = str;
        return displaySize + unit;
    }
}