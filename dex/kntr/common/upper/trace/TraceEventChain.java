package kntr.common.upper.trace;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.upper.trace.TraceNeurons;
import kntr.common.upper.trace.service.TraceEventGraph;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraceEventChain.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J8\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019JB\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001cJB\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001cJH\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00032\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019J\u0018\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkntr/common/upper/trace/TraceEventChain;", "", "eventTraceID", "", "eventTraceName", "eventID", "appTraceID", "projectID", "projectType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEventTraceID", "()Ljava/lang/String;", "getEventTraceName", "events", "", "Lkntr/common/upper/trace/TraceEvent;", "lastEvent", "start", "Lkotlin/Pair;", "", "Lkntr/common/upper/trace/IEvent;", "eventKey", "eventLog", "eventExtra", "", "process", "eventLevel", "Lkntr/common/upper/trace/EventLevel;", "end", "report", "eventNodeType", "Lkntr/common/upper/trace/EventNodeType;", "checkGraph", "traceName", "trace-core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TraceEventChain {
    private final String appTraceID;
    private final String eventID;
    private final String eventTraceID;
    private final String eventTraceName;
    private final List<TraceEvent> events;
    private final String projectID;
    private final String projectType;

    public TraceEventChain(String eventTraceID, String eventTraceName, String eventID, String appTraceID, String projectID, String projectType) {
        Intrinsics.checkNotNullParameter(eventTraceID, "eventTraceID");
        Intrinsics.checkNotNullParameter(eventTraceName, "eventTraceName");
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        Intrinsics.checkNotNullParameter(appTraceID, "appTraceID");
        Intrinsics.checkNotNullParameter(projectID, "projectID");
        Intrinsics.checkNotNullParameter(projectType, "projectType");
        this.eventTraceID = eventTraceID;
        this.eventTraceName = eventTraceName;
        this.eventID = eventID;
        this.appTraceID = appTraceID;
        this.projectID = projectID;
        this.projectType = projectType;
        this.events = new ArrayList();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TraceEventChain(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, str2, str3, str4, str5, str6);
        String str7;
        if ((i & 1) == 0) {
            str7 = str;
        } else {
            str7 = TraceUtils.INSTANCE.newTraceID();
        }
    }

    public final String getEventTraceID() {
        return this.eventTraceID;
    }

    public final String getEventTraceName() {
        return this.eventTraceName;
    }

    public final TraceEvent lastEvent() {
        return (TraceEvent) CollectionsKt.lastOrNull(this.events);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair start$default(TraceEventChain traceEventChain, String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        return traceEventChain.start(str, str2, map);
    }

    public final Pair<Boolean, IEvent> start(String eventKey, String eventLog, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(eventLog, "eventLog");
        Intrinsics.checkNotNullParameter(map, "eventExtra");
        return report(eventKey, EventNodeType.START, EventLevel.INFO, eventLog, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair process$default(TraceEventChain traceEventChain, String str, String str2, Map map, EventLevel eventLevel, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 8) != 0) {
            eventLevel = EventLevel.INFO;
        }
        return traceEventChain.process(str, str2, map, eventLevel);
    }

    public final Pair<Boolean, IEvent> process(String eventKey, String eventLog, Map<String, String> map, EventLevel eventLevel) {
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(eventLog, "eventLog");
        Intrinsics.checkNotNullParameter(map, "eventExtra");
        Intrinsics.checkNotNullParameter(eventLevel, "eventLevel");
        return report(eventKey, EventNodeType.PROCESS, eventLevel, eventLog, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair end$default(TraceEventChain traceEventChain, String str, String str2, Map map, EventLevel eventLevel, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 8) != 0) {
            eventLevel = EventLevel.INFO;
        }
        return traceEventChain.end(str, str2, map, eventLevel);
    }

    public final Pair<Boolean, IEvent> end(String eventKey, String eventLog, Map<String, String> map, EventLevel eventLevel) {
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(eventLog, "eventLog");
        Intrinsics.checkNotNullParameter(map, "eventExtra");
        Intrinsics.checkNotNullParameter(eventLevel, "eventLevel");
        return report(eventKey, EventNodeType.END, eventLevel, eventLog, map);
    }

    public static /* synthetic */ Pair report$default(TraceEventChain traceEventChain, String str, EventNodeType eventNodeType, EventLevel eventLevel, String str2, Map map, int i, Object obj) {
        Map map2;
        if ((i & 16) == 0) {
            map2 = map;
        } else {
            map2 = MapsKt.emptyMap();
        }
        return traceEventChain.report(str, eventNodeType, eventLevel, str2, map2);
    }

    public final Pair<Boolean, IEvent> report(String eventKey, EventNodeType eventNodeType, EventLevel eventLevel, String eventLog, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(eventNodeType, "eventNodeType");
        Intrinsics.checkNotNullParameter(eventLevel, "eventLevel");
        Intrinsics.checkNotNullParameter(eventLog, "eventLog");
        Intrinsics.checkNotNullParameter(map, "eventExtra");
        TraceNeurons neurons = new TraceNeurons.Builder(this.eventID).setAppTraceID(this.appTraceID).setProjectID(this.projectID).setProjectType(this.projectType).setEventTraceID(this.eventTraceID).setEventTraceName(this.eventTraceName).setEventKey(eventKey).setEventNodeType(eventNodeType).setEventLevel(eventLevel).setEventLog(eventLog).setEventExtra(map).build();
        boolean graph = checkGraph(this.eventTraceName, eventKey);
        if (!graph) {
            TraceEvent traceEvent = (TraceEvent) CollectionsKt.lastOrNull(this.events);
            String lastEvent = traceEvent != null ? traceEvent.getEventKey() : null;
            TraceUtilsKt.traceE(KLog_androidKt.getKLog(), "[" + this.eventTraceName + "][" + eventKey + "] cannot report after [" + lastEvent + "]");
            TraceUtils.INSTANCE.contextNotFound(this.eventID, this.appTraceID).report();
        }
        boolean report = neurons.report();
        this.events.add(neurons.getEvent());
        return new Pair<>(Boolean.valueOf(graph && report), neurons.getEvent());
    }

    private final boolean checkGraph(String traceName, String eventKey) {
        TraceEvent traceEvent = (TraceEvent) CollectionsKt.lastOrNull(this.events);
        String current = (traceEvent == null || (current = traceEvent.getEventKey()) == null) ? "" : "";
        return TraceEventGraph.INSTANCE.enableNext$trace_core_debug(traceName, current, eventKey);
    }
}