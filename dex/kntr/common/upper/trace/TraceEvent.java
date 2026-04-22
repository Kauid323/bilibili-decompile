package kntr.common.upper.trace;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraceEvent.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0010X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0012\u0010\u0015\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000eR\u0012\u0010\u0017\u001a\u00020\u0018X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000eR\u0012\u0010\u001d\u001a\u00020\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010\u000eR\u0012\u0010#\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010\u000eR\u0012\u0010%\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010\u000eR\u0012\u0010'\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010\u000e¨\u0006)"}, d2 = {"Lkntr/common/upper/trace/TraceEvent;", "Lkntr/common/upper/trace/IEvent;", "e", "<init>", "(Lkntr/common/upper/trace/IEvent;)V", "eventTime", "", "getEventTime", "()J", "setEventTime", "(J)V", "appTraceID", "", "getAppTraceID", "()Ljava/lang/String;", "eventExtra", "", "getEventExtra", "()Ljava/util/Map;", "eventID", "getEventID", "eventKey", "getEventKey", "eventLevel", "Lkntr/common/upper/trace/EventLevel;", "getEventLevel", "()Lkntr/common/upper/trace/EventLevel;", "eventLog", "getEventLog", "eventNodeType", "Lkntr/common/upper/trace/EventNodeType;", "getEventNodeType", "()Lkntr/common/upper/trace/EventNodeType;", "eventTraceID", "getEventTraceID", "eventTraceName", "getEventTraceName", "projectID", "getProjectID", "projectType", "getProjectType", "trace-core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TraceEvent implements IEvent {
    private final /* synthetic */ IEvent $$delegate_0;
    private long eventTime;

    @Override // kntr.common.upper.trace.IEvent
    public String getAppTraceID() {
        return this.$$delegate_0.getAppTraceID();
    }

    @Override // kntr.common.upper.trace.IEvent
    public Map<String, String> getEventExtra() {
        return this.$$delegate_0.getEventExtra();
    }

    @Override // kntr.common.upper.trace.IEvent
    public String getEventID() {
        return this.$$delegate_0.getEventID();
    }

    @Override // kntr.common.upper.trace.IEvent
    public String getEventKey() {
        return this.$$delegate_0.getEventKey();
    }

    @Override // kntr.common.upper.trace.IEvent
    public EventLevel getEventLevel() {
        return this.$$delegate_0.getEventLevel();
    }

    @Override // kntr.common.upper.trace.IEvent
    public String getEventLog() {
        return this.$$delegate_0.getEventLog();
    }

    @Override // kntr.common.upper.trace.IEvent
    public EventNodeType getEventNodeType() {
        return this.$$delegate_0.getEventNodeType();
    }

    @Override // kntr.common.upper.trace.IEvent
    public String getEventTraceID() {
        return this.$$delegate_0.getEventTraceID();
    }

    @Override // kntr.common.upper.trace.IEvent
    public String getEventTraceName() {
        return this.$$delegate_0.getEventTraceName();
    }

    @Override // kntr.common.upper.trace.IEvent
    public String getProjectID() {
        return this.$$delegate_0.getProjectID();
    }

    @Override // kntr.common.upper.trace.IEvent
    public String getProjectType() {
        return this.$$delegate_0.getProjectType();
    }

    public TraceEvent(IEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.$$delegate_0 = e;
    }

    public final long getEventTime() {
        return this.eventTime;
    }

    public final void setEventTime(long j) {
        this.eventTime = j;
    }
}