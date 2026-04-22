package kntr.common.upper.trace;

import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.neuron.KNeuron;
import kntr.common.upper.trace.config.AppKey;
import kntr.common.upper.trace.config.EventKey;
import kntr.common.upper.trace.config.ExtraKey;
import kntr.common.upper.trace.config.Platform_androidKt;
import kntr.common.upper.trace.config.ProjectKey;
import kntr.common.upper.trace.config.TraceGlobal;
import kntr.common.upper.trace.config.TraceKey;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: TraceNeurons.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lkntr/common/upper/trace/TraceNeurons;", "", "event", "Lkntr/common/upper/trace/TraceEvent;", "<init>", "(Lkntr/common/upper/trace/TraceEvent;)V", "getEvent", "()Lkntr/common/upper/trace/TraceEvent;", "report", "", "Builder", "trace-core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TraceNeurons {
    private final TraceEvent event;

    public /* synthetic */ TraceNeurons(TraceEvent traceEvent, DefaultConstructorMarker defaultConstructorMarker) {
        this(traceEvent);
    }

    private TraceNeurons(TraceEvent event) {
        this.event = event;
    }

    public final TraceEvent getEvent() {
        return this.event;
    }

    /* compiled from: TraceNeurons.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0003J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0003J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0003J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0003J\u001a\u0010,\u001a\u00020\u00002\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001fJ\u0006\u0010.\u001a\u00020/R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u001e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R\u001e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u001e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0015@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0019@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0007R6\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001f@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lkntr/common/upper/trace/TraceNeurons$Builder;", "Lkntr/common/upper/trace/IEvent;", "eventID", "", "<init>", "(Ljava/lang/String;)V", "getEventID", "()Ljava/lang/String;", "value", "appTraceID", "getAppTraceID", "projectID", "getProjectID", "projectType", "getProjectType", "eventTraceID", "getEventTraceID", "eventTraceName", "getEventTraceName", "eventKey", "getEventKey", "Lkntr/common/upper/trace/EventNodeType;", "eventNodeType", "getEventNodeType", "()Lkntr/common/upper/trace/EventNodeType;", "Lkntr/common/upper/trace/EventLevel;", "eventLevel", "getEventLevel", "()Lkntr/common/upper/trace/EventLevel;", "eventLog", "getEventLog", "", "eventExtra", "getEventExtra", "()Ljava/util/Map;", "setAppTraceID", "setProjectID", "setProjectType", "setEventTraceID", "setEventTraceName", "setEventKey", "setEventNodeType", "setEventLevel", "setEventLog", "setEventExtra", "extra", "build", "Lkntr/common/upper/trace/TraceNeurons;", "trace-core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Builder implements IEvent {
        private String appTraceID;
        private Map<String, String> eventExtra;
        private final String eventID;
        private String eventKey;
        private EventLevel eventLevel;
        private String eventLog;
        private EventNodeType eventNodeType;
        private String eventTraceID;
        private String eventTraceName;
        private String projectID;
        private String projectType;

        public Builder(String eventID) {
            Intrinsics.checkNotNullParameter(eventID, "eventID");
            this.eventID = eventID;
            this.appTraceID = "";
            this.projectID = "";
            this.projectType = "";
            this.eventTraceID = "";
            this.eventTraceName = "";
            this.eventKey = "";
            this.eventNodeType = EventNodeType.UNDEFINE;
            this.eventLevel = EventLevel.INFO;
            this.eventLog = "";
            this.eventExtra = MapsKt.emptyMap();
        }

        @Override // kntr.common.upper.trace.IEvent
        public String getEventID() {
            return this.eventID;
        }

        @Override // kntr.common.upper.trace.IEvent
        public String getAppTraceID() {
            return this.appTraceID;
        }

        @Override // kntr.common.upper.trace.IEvent
        public String getProjectID() {
            return this.projectID;
        }

        @Override // kntr.common.upper.trace.IEvent
        public String getProjectType() {
            return this.projectType;
        }

        @Override // kntr.common.upper.trace.IEvent
        public String getEventTraceID() {
            return this.eventTraceID;
        }

        @Override // kntr.common.upper.trace.IEvent
        public String getEventTraceName() {
            return this.eventTraceName;
        }

        @Override // kntr.common.upper.trace.IEvent
        public String getEventKey() {
            return this.eventKey;
        }

        @Override // kntr.common.upper.trace.IEvent
        public EventNodeType getEventNodeType() {
            return this.eventNodeType;
        }

        @Override // kntr.common.upper.trace.IEvent
        public EventLevel getEventLevel() {
            return this.eventLevel;
        }

        @Override // kntr.common.upper.trace.IEvent
        public String getEventLog() {
            return this.eventLog;
        }

        @Override // kntr.common.upper.trace.IEvent
        public Map<String, String> getEventExtra() {
            return this.eventExtra;
        }

        public final Builder setAppTraceID(String appTraceID) {
            Intrinsics.checkNotNullParameter(appTraceID, "appTraceID");
            Builder $this$setAppTraceID_u24lambda_u240 = this;
            $this$setAppTraceID_u24lambda_u240.appTraceID = appTraceID;
            return this;
        }

        public final Builder setProjectID(String projectID) {
            Intrinsics.checkNotNullParameter(projectID, "projectID");
            Builder $this$setProjectID_u24lambda_u240 = this;
            $this$setProjectID_u24lambda_u240.projectID = projectID;
            return this;
        }

        public final Builder setProjectType(String projectType) {
            Intrinsics.checkNotNullParameter(projectType, "projectType");
            Builder $this$setProjectType_u24lambda_u240 = this;
            $this$setProjectType_u24lambda_u240.projectType = projectType;
            return this;
        }

        public final Builder setEventTraceID(String eventTraceID) {
            Intrinsics.checkNotNullParameter(eventTraceID, "eventTraceID");
            Builder $this$setEventTraceID_u24lambda_u240 = this;
            $this$setEventTraceID_u24lambda_u240.eventTraceID = eventTraceID;
            return this;
        }

        public final Builder setEventTraceName(String eventTraceName) {
            Intrinsics.checkNotNullParameter(eventTraceName, "eventTraceName");
            Builder $this$setEventTraceName_u24lambda_u240 = this;
            $this$setEventTraceName_u24lambda_u240.eventTraceName = eventTraceName;
            return this;
        }

        public final Builder setEventKey(String eventKey) {
            Intrinsics.checkNotNullParameter(eventKey, "eventKey");
            Builder $this$setEventKey_u24lambda_u240 = this;
            $this$setEventKey_u24lambda_u240.eventKey = eventKey;
            return this;
        }

        public final Builder setEventNodeType(EventNodeType eventNodeType) {
            Intrinsics.checkNotNullParameter(eventNodeType, "eventNodeType");
            Builder $this$setEventNodeType_u24lambda_u240 = this;
            $this$setEventNodeType_u24lambda_u240.eventNodeType = eventNodeType;
            return this;
        }

        public final Builder setEventLevel(EventLevel eventLevel) {
            Intrinsics.checkNotNullParameter(eventLevel, "eventLevel");
            Builder $this$setEventLevel_u24lambda_u240 = this;
            $this$setEventLevel_u24lambda_u240.eventLevel = eventLevel;
            return this;
        }

        public final Builder setEventLog(String eventLog) {
            Intrinsics.checkNotNullParameter(eventLog, "eventLog");
            Builder $this$setEventLog_u24lambda_u240 = this;
            $this$setEventLog_u24lambda_u240.eventLog = eventLog;
            return this;
        }

        public final Builder setEventExtra(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "extra");
            Builder $this$setEventExtra_u24lambda_u240 = this;
            $this$setEventExtra_u24lambda_u240.eventExtra = map;
            return this;
        }

        public final TraceNeurons build() {
            return new TraceNeurons(new TraceEvent(this), null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032 A[Catch: all -> 0x02e2, TryCatch #0 {all -> 0x02e2, blocks: (B:3:0x0006, B:6:0x0016, B:8:0x0024, B:15:0x0032, B:17:0x003b, B:20:0x0051, B:21:0x0105, B:23:0x010b, B:24:0x0137), top: B:36:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x010b A[Catch: all -> 0x02e2, LOOP:0: B:21:0x0105->B:23:0x010b, LOOP_END, TryCatch #0 {all -> 0x02e2, blocks: (B:3:0x0006, B:6:0x0016, B:8:0x0024, B:15:0x0032, B:17:0x003b, B:20:0x0051, B:21:0x0105, B:23:0x010b, B:24:0x0137), top: B:36:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x033b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean report() {
        Boolean m2636constructorimpl;
        Throwable it;
        TraceNeurons $this$report_u24lambda_u240;
        boolean z;
        boolean enableTimeOffset;
        String uid;
        try {
            Result.Companion companion = Result.Companion;
            $this$report_u24lambda_u240 = this;
            z = false;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        if (TraceGlobal.INSTANCE.getEnableTimeOffset()) {
            String str = $this$report_u24lambda_u240.event.getEventExtra().get(EventKey.EVENT_ENABLE_TIME_OFFSET);
            if (str != null ? Boolean.parseBoolean(str) : true) {
                enableTimeOffset = true;
                long timeOffset = !enableTimeOffset ? TraceGlobal.INSTANCE.getTimeOffset() : 0L;
                JsonObjectBuilder builder$iv = new JsonObjectBuilder();
                uid = TraceGlobal.INSTANCE.getUid();
                if (uid == null) {
                    uid = "";
                }
                JsonElementBuildersKt.put(builder$iv, AppKey.UID, uid);
                JsonObject userInfo = builder$iv.build();
                JsonObjectBuilder builder$iv2 = new JsonObjectBuilder();
                JsonElementBuildersKt.put(builder$iv2, ProjectKey.PROJECT_ID, $this$report_u24lambda_u240.event.getProjectID());
                JsonObject bizInfo = builder$iv2.build();
                Map $this$mapValues$iv = MapsKt.plus(MapsKt.plus(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(AppKey.VERSION, TraceGlobal.INSTANCE.getVersion()), TuplesKt.to(AppKey.VERSION_CODE, TraceGlobal.INSTANCE.getVersionCode()), TuplesKt.to(AppKey.BILI_APP_ID, TraceGlobal.INSTANCE.getBiliAppId()), TuplesKt.to(EventKey.EVENT_ENABLE_TIME_OFFSET, String.valueOf(enableTimeOffset)), TuplesKt.to(EventKey.EVENT_TIME_OFFSET, String.valueOf(timeOffset))}), TraceGlobal.INSTANCE.getExtendParams()), $this$report_u24lambda_u240.event.getEventExtra());
                Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
                Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
                Map destination$iv$iv$iv = destination$iv$iv;
                for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
                    Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
                    boolean z2 = z;
                    Map destination$iv$iv$iv2 = destination$iv$iv$iv;
                    destination$iv$iv$iv2.put(it$iv$iv.getKey(), JsonElementKt.JsonPrimitive((String) ((Map.Entry) element$iv$iv$iv).getValue()));
                    destination$iv$iv$iv = destination$iv$iv$iv2;
                    z = z2;
                }
                Map extendsInfo = destination$iv$iv$iv;
                JsonObjectBuilder builder$iv3 = new JsonObjectBuilder();
                JsonElementBuildersKt.put(builder$iv3, AppKey.SIDE, Platform_androidKt.getPlatform().getName());
                JsonElementBuildersKt.put(builder$iv3, EventKey.EVENT_NODE_TYPE, $this$report_u24lambda_u240.event.getEventNodeType().getValue());
                builder$iv3.put(ExtraKey.EVENT_EXTENDS_INFO, new JsonObject(extendsInfo));
                JsonObject eventValue = builder$iv3.build();
                $this$report_u24lambda_u240.event.setEventTime(Clock.System.INSTANCE.now().toEpochMilliseconds() + timeOffset);
                StringFormat $this$encodeToString$iv = Json.Default;
                $this$encodeToString$iv.getSerializersModule();
                StringFormat $this$encodeToString$iv2 = Json.Default;
                $this$encodeToString$iv2.getSerializersModule();
                StringFormat $this$encodeToString$iv3 = Json.Default;
                $this$encodeToString$iv3.getSerializersModule();
                Map it2 = MapsKt.mapOf(new Pair[]{TuplesKt.to(AppKey.USER_STATUS, $this$encodeToString$iv.encodeToString(JsonObject.Companion.serializer(), userInfo)), TuplesKt.to(AppKey.APP_TRACE_ID, $this$report_u24lambda_u240.event.getAppTraceID()), TuplesKt.to(ProjectKey.PROJECT_TYPE, $this$report_u24lambda_u240.event.getProjectType()), TuplesKt.to(TraceKey.EVENT_TRACE_ID, $this$report_u24lambda_u240.event.getEventTraceID()), TuplesKt.to(TraceKey.EVENT_TRACE_NAME, $this$report_u24lambda_u240.event.getEventTraceName()), TuplesKt.to(EventKey.EVENT_KEY, $this$report_u24lambda_u240.event.getEventKey()), TuplesKt.to(EventKey.EVENT_LEVEL, $this$report_u24lambda_u240.event.getEventLevel().getValue()), TuplesKt.to(EventKey.EVENT_LOG, $this$report_u24lambda_u240.event.getEventLog()), TuplesKt.to(EventKey.EVENT_TIME, String.valueOf($this$report_u24lambda_u240.event.getEventTime())), TuplesKt.to(ExtraKey.EVENT_VALUE, $this$encodeToString$iv2.encodeToString(JsonObject.Companion.serializer(), eventValue)), TuplesKt.to(ExtraKey.BUSINESS_TABLE_FIELDS, $this$encodeToString$iv3.encodeToString(JsonObject.Companion.serializer(), bizInfo))});
                TraceUtilsKt.traceD(KLog_androidKt.getKLog(), "[" + $this$report_u24lambda_u240.event.getEventTraceName() + "][" + $this$report_u24lambda_u240.event.getEventKey() + "]");
                TraceUtilsKt.traceDetail(KLog_androidKt.getKLog(), "Report params: " + it2);
                KNeuron.INSTANCE.simpleTrackT($this$report_u24lambda_u240.event.getEventID(), it2);
                m2636constructorimpl = Result.m2636constructorimpl(true);
                it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                if (it != null) {
                    TraceUtilsKt.traceE(KLog_androidKt.getKLog(), "[" + this.event.getEventTraceName() + "][" + this.event.getEventKey() + "] failed: " + it.getMessage());
                }
                if (Result.m2642isFailureimpl(m2636constructorimpl)) {
                    m2636constructorimpl = false;
                }
                return ((Boolean) m2636constructorimpl).booleanValue();
            }
        }
        enableTimeOffset = false;
        if (!enableTimeOffset) {
        }
        JsonObjectBuilder builder$iv4 = new JsonObjectBuilder();
        uid = TraceGlobal.INSTANCE.getUid();
        if (uid == null) {
        }
        JsonElementBuildersKt.put(builder$iv4, AppKey.UID, uid);
        JsonObject userInfo2 = builder$iv4.build();
        JsonObjectBuilder builder$iv22 = new JsonObjectBuilder();
        JsonElementBuildersKt.put(builder$iv22, ProjectKey.PROJECT_ID, $this$report_u24lambda_u240.event.getProjectID());
        JsonObject bizInfo2 = builder$iv22.build();
        Map $this$mapValues$iv2 = MapsKt.plus(MapsKt.plus(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(AppKey.VERSION, TraceGlobal.INSTANCE.getVersion()), TuplesKt.to(AppKey.VERSION_CODE, TraceGlobal.INSTANCE.getVersionCode()), TuplesKt.to(AppKey.BILI_APP_ID, TraceGlobal.INSTANCE.getBiliAppId()), TuplesKt.to(EventKey.EVENT_ENABLE_TIME_OFFSET, String.valueOf(enableTimeOffset)), TuplesKt.to(EventKey.EVENT_TIME_OFFSET, String.valueOf(timeOffset))}), TraceGlobal.INSTANCE.getExtendParams()), $this$report_u24lambda_u240.event.getEventExtra());
        Map destination$iv$iv2 = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv2.size()));
        Iterable $this$associateByTo$iv$iv$iv2 = $this$mapValues$iv2.entrySet();
        Map destination$iv$iv$iv3 = destination$iv$iv2;
        while (r21.hasNext()) {
        }
        Map extendsInfo2 = destination$iv$iv$iv3;
        JsonObjectBuilder builder$iv32 = new JsonObjectBuilder();
        JsonElementBuildersKt.put(builder$iv32, AppKey.SIDE, Platform_androidKt.getPlatform().getName());
        JsonElementBuildersKt.put(builder$iv32, EventKey.EVENT_NODE_TYPE, $this$report_u24lambda_u240.event.getEventNodeType().getValue());
        builder$iv32.put(ExtraKey.EVENT_EXTENDS_INFO, new JsonObject(extendsInfo2));
        JsonObject eventValue2 = builder$iv32.build();
        $this$report_u24lambda_u240.event.setEventTime(Clock.System.INSTANCE.now().toEpochMilliseconds() + timeOffset);
        StringFormat $this$encodeToString$iv4 = Json.Default;
        $this$encodeToString$iv4.getSerializersModule();
        StringFormat $this$encodeToString$iv22 = Json.Default;
        $this$encodeToString$iv22.getSerializersModule();
        StringFormat $this$encodeToString$iv32 = Json.Default;
        $this$encodeToString$iv32.getSerializersModule();
        Map it22 = MapsKt.mapOf(new Pair[]{TuplesKt.to(AppKey.USER_STATUS, $this$encodeToString$iv4.encodeToString(JsonObject.Companion.serializer(), userInfo2)), TuplesKt.to(AppKey.APP_TRACE_ID, $this$report_u24lambda_u240.event.getAppTraceID()), TuplesKt.to(ProjectKey.PROJECT_TYPE, $this$report_u24lambda_u240.event.getProjectType()), TuplesKt.to(TraceKey.EVENT_TRACE_ID, $this$report_u24lambda_u240.event.getEventTraceID()), TuplesKt.to(TraceKey.EVENT_TRACE_NAME, $this$report_u24lambda_u240.event.getEventTraceName()), TuplesKt.to(EventKey.EVENT_KEY, $this$report_u24lambda_u240.event.getEventKey()), TuplesKt.to(EventKey.EVENT_LEVEL, $this$report_u24lambda_u240.event.getEventLevel().getValue()), TuplesKt.to(EventKey.EVENT_LOG, $this$report_u24lambda_u240.event.getEventLog()), TuplesKt.to(EventKey.EVENT_TIME, String.valueOf($this$report_u24lambda_u240.event.getEventTime())), TuplesKt.to(ExtraKey.EVENT_VALUE, $this$encodeToString$iv22.encodeToString(JsonObject.Companion.serializer(), eventValue2)), TuplesKt.to(ExtraKey.BUSINESS_TABLE_FIELDS, $this$encodeToString$iv32.encodeToString(JsonObject.Companion.serializer(), bizInfo2))});
        TraceUtilsKt.traceD(KLog_androidKt.getKLog(), "[" + $this$report_u24lambda_u240.event.getEventTraceName() + "][" + $this$report_u24lambda_u240.event.getEventKey() + "]");
        TraceUtilsKt.traceDetail(KLog_androidKt.getKLog(), "Report params: " + it22);
        KNeuron.INSTANCE.simpleTrackT($this$report_u24lambda_u240.event.getEventID(), it22);
        m2636constructorimpl = Result.m2636constructorimpl(true);
        it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
        if (it != null) {
        }
        if (Result.m2642isFailureimpl(m2636constructorimpl)) {
        }
        return ((Boolean) m2636constructorimpl).booleanValue();
    }
}