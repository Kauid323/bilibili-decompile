package kntr.common.compose.pulltorefresh;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PullToRefreshState.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a7\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a:\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"rememberPullToRefreshState", "Lkntr/common/compose/pulltorefresh/PullToRefreshState;", "dragMultiplier", "", "refreshTriggerDistance", "Landroidx/compose/ui/unit/Dp;", "refreshingOffset", "enabled", "", "rememberPullToRefreshState-djqs-MU", "(FFFZLandroidx/compose/runtime/Composer;II)Lkntr/common/compose/pulltorefresh/PullToRefreshState;", "PullToRefreshState", "refreshTriggerDistancePx", "refreshingOffsetPx", "initialRefreshing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "compose-pulltorefresh_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PullToRefreshStateKt {
    /* renamed from: rememberPullToRefreshState-djqs-MU  reason: not valid java name */
    public static final PullToRefreshState m1873rememberPullToRefreshStatedjqsMU(float dragMultiplier, float f, float f2, boolean enabled, Composer $composer, int $changed, int i) {
        Saver<PullToRefreshState, Boolean> saver;
        ComposerKt.sourceInformationMarkerStart($composer, -163142232, "C(rememberPullToRefreshState)N(dragMultiplier,refreshTriggerDistance:c#ui.unit.Dp,refreshingOffset:c#ui.unit.Dp,enabled)79@2187L7,82@2374L24,97@2893L327,83@2410L810:PullToRefreshState.kt#8f2f3d");
        float dragMultiplier2 = (i & 1) != 0 ? 0.5f : dragMultiplier;
        float f3 = (i & 2) != 0 ? Dp.constructor-impl(60) : f;
        float f4 = (i & 4) != 0 ? f3 : f2;
        boolean enabled2 = (i & 8) != 0 ? true : enabled;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-163142232, $changed, -1, "kntr.common.compose.pulltorefresh.rememberPullToRefreshState (PullToRefreshState.kt:75)");
        }
        if (0.0f <= dragMultiplier2 && dragMultiplier2 <= 1.0f) {
            if (Dp.compareTo-0680j_4(f4, f3) <= 0) {
                CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Density density = (Density) consume;
                final float refreshTriggerDistancePx = density.toPx-0680j_4(f3);
                final float refreshingOffsetPx = density.toPx-0680j_4(f4);
                ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.Companion.getEmpty()) {
                    Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
                    $composer.updateRememberedValue(value$iv$iv);
                    it$iv$iv = value$iv$iv;
                }
                final CoroutineScope coroutineScope = (CoroutineScope) it$iv$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Object[] objArr = {Float.valueOf(dragMultiplier2), Boolean.valueOf(enabled2), Float.valueOf(refreshTriggerDistancePx), Float.valueOf(refreshingOffsetPx), coroutineScope};
                Saver<PullToRefreshState, Boolean> Saver = PullToRefreshStateImpl.Companion.Saver(dragMultiplier2, refreshTriggerDistancePx, refreshingOffsetPx, enabled2, coroutineScope);
                ComposerKt.sourceInformationMarkerStart($composer, 2134141871, "CC(remember):PullToRefreshState.kt#9igjgp");
                boolean invalid$iv = $composer.changed(refreshTriggerDistancePx) | (((($changed & 14) ^ 6) > 4 && $composer.changed(dragMultiplier2)) || ($changed & 6) == 4) | $composer.changed(refreshingOffsetPx) | (((($changed & 7168) ^ 3072) > 2048 && $composer.changed(enabled2)) || ($changed & 3072) == 2048) | $composer.changedInstance(coroutineScope);
                Object value$iv = $composer.rememberedValue();
                if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                    final float f5 = dragMultiplier2;
                    final boolean z = enabled2;
                    saver = Saver;
                    value$iv = new Function0() { // from class: kntr.common.compose.pulltorefresh.PullToRefreshStateKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            PullToRefreshState rememberPullToRefreshState_djqs_MU$lambda$4$0;
                            rememberPullToRefreshState_djqs_MU$lambda$4$0 = PullToRefreshStateKt.rememberPullToRefreshState_djqs_MU$lambda$4$0(f5, refreshTriggerDistancePx, refreshingOffsetPx, z, coroutineScope);
                            return rememberPullToRefreshState_djqs_MU$lambda$4$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    saver = Saver;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                PullToRefreshState pullToRefreshState = (PullToRefreshState) RememberSaveableKt.rememberSaveable(objArr, saver, (Function0) value$iv, $composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                return pullToRefreshState;
            }
            throw new IllegalArgumentException("refreshingOffset must be <= refreshTriggerDistance".toString());
        }
        throw new IllegalArgumentException("dragMultiplier must be >= 0 and <= 1".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PullToRefreshState rememberPullToRefreshState_djqs_MU$lambda$4$0(float $dragMultiplier, float $refreshTriggerDistancePx, float $refreshingOffsetPx, boolean $enabled, CoroutineScope $coroutineScope) {
        return new PullToRefreshStateImpl(false, $dragMultiplier, $refreshTriggerDistancePx, $refreshingOffsetPx, $enabled, $coroutineScope);
    }

    public static /* synthetic */ PullToRefreshState PullToRefreshState$default(float f, float f2, float f3, boolean z, boolean z2, CoroutineScope coroutineScope, int i, Object obj) {
        boolean z3;
        boolean z4;
        if ((i & 8) == 0) {
            z3 = z;
        } else {
            z3 = false;
        }
        if ((i & 16) == 0) {
            z4 = z2;
        } else {
            z4 = true;
        }
        return PullToRefreshState(f, f2, f3, z3, z4, coroutineScope);
    }

    public static final PullToRefreshState PullToRefreshState(float dragMultiplier, float refreshTriggerDistancePx, float refreshingOffsetPx, boolean initialRefreshing, boolean enabled, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        return new PullToRefreshStateImpl(initialRefreshing, dragMultiplier, refreshTriggerDistancePx, refreshingOffsetPx, enabled, coroutineScope);
    }
}