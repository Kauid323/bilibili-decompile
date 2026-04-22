package kntr.common.upper.trace.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraceEventGraph.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007J*\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00062\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0007H\u0007J%\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0013J%\u0010\u0014\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0015R,\u0010\u0004\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkntr/common/upper/trace/service/TraceEventGraph;", "", "<init>", "()V", "graphs", "", "", "", "", "addNode", "traceName", "currentEvent", "nextEvent", "addGraph", "graph", "enableNext", "", "current", "next", "enableNext$trace_core_debug", "enableNextStrict", "enableNextStrict$trace_core_debug", "trace-core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TraceEventGraph {
    public static final TraceEventGraph INSTANCE = new TraceEventGraph();
    private static final Map<String, Map<String, List<String>>> graphs = new LinkedHashMap();

    private TraceEventGraph() {
    }

    public final TraceEventGraph addNode(String traceName, String currentEvent, List<String> list) {
        Intrinsics.checkNotNullParameter(traceName, "traceName");
        Intrinsics.checkNotNullParameter(currentEvent, "currentEvent");
        Intrinsics.checkNotNullParameter(list, "nextEvent");
        Map originGraph = graphs.get(traceName);
        if (originGraph == null) {
            originGraph = MapsKt.emptyMap();
        }
        graphs.put(traceName, MapsKt.plus(originGraph, TuplesKt.to(currentEvent, list)));
        return this;
    }

    public final TraceEventGraph addGraph(String traceName, Map<String, ? extends List<String>> map) {
        Intrinsics.checkNotNullParameter(traceName, "traceName");
        Intrinsics.checkNotNullParameter(map, "graph");
        Map originGraph = graphs.get(traceName);
        if (originGraph == null) {
            originGraph = MapsKt.emptyMap();
        }
        graphs.put(traceName, MapsKt.plus(originGraph, map));
        return this;
    }

    public final boolean enableNext$trace_core_debug(String traceName, String current, String next) {
        Intrinsics.checkNotNullParameter(traceName, "traceName");
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(next, "next");
        Map graph = graphs.get(traceName);
        if (graph == null) {
            graph = MapsKt.emptyMap();
        }
        if (graph.containsKey(current)) {
            List<String> list = graph.get(current);
            return list != null && list.contains(next);
        }
        return true;
    }

    public final boolean enableNextStrict$trace_core_debug(String traceName, String current, String next) {
        Intrinsics.checkNotNullParameter(traceName, "traceName");
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(next, "next");
        Map graph = graphs.get(traceName);
        if (graph == null) {
            graph = MapsKt.emptyMap();
        }
        List<String> list = graph.get(current);
        return list != null && list.contains(next);
    }
}