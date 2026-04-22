package kntr.common.pv;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: PvEventTrigger.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a \u0010\b\u001a\u00020\t*\u00020\u00012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000b\u001a\u001a\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005\u001a;\u0010\b\u001a\u00020\t*\u00020\u00012*\u0010\u000e\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00100\u000f\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"PvEventTrigger", "Lkntr/common/pv/PvEventTrigger;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "eventId", "", "startObserveIn", "Lkotlinx/coroutines/Job;", "updateExtra", "", "map", "", "key", "value", "pairs", "", "Lkotlin/Pair;", "(Lkntr/common/pv/PvEventTrigger;[Lkotlin/Pair;)V", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PvEventTriggerKt {
    public static final PvEventTrigger PvEventTrigger(Lifecycle lifecycle, String eventId) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        return new PvEventTrigger(TransformerKt.toPvStateFlow(lifecycle), eventId);
    }

    public static final Job startObserveIn(PvEventTrigger $this$startObserveIn, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter($this$startObserveIn, "<this>");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        return BuildersKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), (CoroutineContext) null, (CoroutineStart) null, new PvEventTriggerKt$startObserveIn$1($this$startObserveIn, null), 3, (Object) null);
    }

    public static final void updateExtra(PvEventTrigger $this$updateExtra, Map<String, String> map) {
        Intrinsics.checkNotNullParameter($this$updateExtra, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterable $this$associateByTo$iv$iv$iv = map.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Object key = it$iv$iv.getKey();
            Map.Entry it = (Map.Entry) element$iv$iv$iv;
            String str = (String) it.getValue();
            if (str == null) {
                str = "";
            }
            destination$iv$iv.put(key, str);
        }
        $this$updateExtra.updateExtra(destination$iv$iv);
    }

    public static final void updateExtra(PvEventTrigger $this$updateExtra, String key, String value) {
        Intrinsics.checkNotNullParameter($this$updateExtra, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$updateExtra.updateExtra(MapsKt.mapOf(TuplesKt.to(key, value)));
    }

    public static final void updateExtra(PvEventTrigger $this$updateExtra, Pair<String, String>... pairArr) {
        Intrinsics.checkNotNullParameter($this$updateExtra, "<this>");
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        $this$updateExtra.updateExtra(MapsKt.toMap(pairArr));
    }
}