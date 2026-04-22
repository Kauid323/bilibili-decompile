package kntr.base.neuron;

import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPlatformNeuron.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b\u001a2\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b\u001aB\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f¨\u0006\r"}, d2 = {"reportExposure", "", "Lkntr/base/neuron/IPlatformNeuron;", "force", "", "eventId", "", "extra", "", "reportClick", "trackT", "sampler", "Lkotlin/Function0;", "neuron_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class IPlatformNeuronKt {
    public static /* synthetic */ void reportExposure$default(IPlatformNeuron iPlatformNeuron, boolean z, String str, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        reportExposure(iPlatformNeuron, z, str, map);
    }

    public static final void reportExposure(IPlatformNeuron $this$reportExposure, boolean force, String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter($this$reportExposure, "<this>");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
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
        $this$reportExposure.reportExposure(force, eventId, destination$iv$iv);
    }

    public static /* synthetic */ void reportClick$default(IPlatformNeuron iPlatformNeuron, boolean z, String str, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        reportClick(iPlatformNeuron, z, str, map);
    }

    public static final void reportClick(IPlatformNeuron $this$reportClick, boolean force, String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter($this$reportClick, "<this>");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
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
        $this$reportClick.reportClick(force, eventId, destination$iv$iv);
    }

    public static /* synthetic */ void trackT$default(IPlatformNeuron iPlatformNeuron, boolean z, String str, Map map, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 8) != 0) {
            function0 = new Function0() { // from class: kntr.base.neuron.IPlatformNeuronKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    boolean trackT$lambda$0;
                    trackT$lambda$0 = IPlatformNeuronKt.trackT$lambda$0();
                    return Boolean.valueOf(trackT$lambda$0);
                }
            };
        }
        trackT(iPlatformNeuron, z, str, map, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean trackT$lambda$0() {
        return true;
    }

    public static final void trackT(IPlatformNeuron $this$trackT, boolean force, String eventId, Map<String, String> map, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter($this$trackT, "<this>");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
        Intrinsics.checkNotNullParameter(function0, "sampler");
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
        $this$trackT.trackT(force, eventId, destination$iv$iv, function0);
    }
}