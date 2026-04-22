package kntr.common.pv.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.PvEventTriggerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PvTriggerEntrance.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"rememberPvEventTrigger", "Lkntr/common/pv/PvEventTrigger;", "eventId", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Lkntr/common/pv/PvEventTrigger;", "compose_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PvTriggerEntranceKt {
    public static final PvEventTrigger rememberPvEventTrigger(String eventId, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        ComposerKt.sourceInformationMarkerStart($composer, -1872273714, "C(rememberPvEventTrigger)N(eventId)14@470L7,15@489L156:PvTriggerEntrance.kt#yg035s");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1872273714, $changed, -1, "kntr.common.pv.compose.rememberPvEventTrigger (PvTriggerEntrance.kt:13)");
        }
        CompositionLocal this_$iv = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        LifecycleOwner lifecycleOwner = (LifecycleOwner) consume;
        ComposerKt.sourceInformationMarkerStart($composer, 336262058, "CC(remember):PvTriggerEntrance.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(eventId)) || ($changed & 6) == 4;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            PvEventTrigger it = PvEventTriggerKt.PvEventTrigger(lifecycleOwner.getLifecycle(), eventId);
            PvEventTriggerKt.startObserveIn(it, lifecycleOwner.getLifecycle());
            $composer.updateRememberedValue(it);
            it$iv = it;
        }
        PvEventTrigger pvEventTrigger = (PvEventTrigger) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return pvEventTrigger;
    }
}