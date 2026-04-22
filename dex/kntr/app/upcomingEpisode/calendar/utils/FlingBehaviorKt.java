package kntr.app.upcomingEpisode.calendar.utils;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlingBehavior.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¨\u0006\b"}, d2 = {"pagedFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/FlingBehavior;", "biliCalendarSnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "snapLayoutInfoProvider", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FlingBehaviorKt {
    public static final FlingBehavior pagedFlingBehavior(LazyListState state, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(state, "state");
        ComposerKt.sourceInformationMarkerStart($composer, 89211624, "C(pagedFlingBehavior)N(state)13@583L161,17@756L41:FlingBehavior.kt#4u6as6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(89211624, $changed, -1, "kntr.app.upcomingEpisode.calendar.utils.pagedFlingBehavior (FlingBehavior.kt:11)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -166972055, "CC(remember):FlingBehavior.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(state)) || ($changed & 6) == 4;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            SnapLayoutInfoProvider provider = LazyListSnapLayoutInfoProviderKt.SnapLayoutInfoProvider(state, SnapPosition.Start.INSTANCE);
            Object value$iv = biliCalendarSnapLayoutInfoProvider(provider);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        SnapLayoutInfoProvider snappingLayout = (SnapLayoutInfoProvider) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        FlingBehavior rememberSnapFlingBehavior = SnapFlingBehaviorKt.rememberSnapFlingBehavior(snappingLayout, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return rememberSnapFlingBehavior;
    }

    private static final SnapLayoutInfoProvider biliCalendarSnapLayoutInfoProvider(final SnapLayoutInfoProvider snapLayoutInfoProvider) {
        return new SnapLayoutInfoProvider() { // from class: kntr.app.upcomingEpisode.calendar.utils.FlingBehaviorKt$biliCalendarSnapLayoutInfoProvider$1
            public float calculateSnapOffset(float f) {
                return snapLayoutInfoProvider.calculateSnapOffset(f);
            }

            public float calculateApproachOffset(float velocity, float decayOffset) {
                return 0.0f;
            }
        };
    }
}