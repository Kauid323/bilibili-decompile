package im.session;

import com.bapis.bilibili.app.im.v1.KSessionId;
import im.session.service.Summary;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMAction.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lim/session/IMUpdateSummary;", "Lim/session/IMAction;", "sessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "newSummary", "Lim/session/service/Summary;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;Lim/session/service/Summary;)V", "getSessionId", "()Lcom/bapis/bilibili/app/im/v1/KSessionId;", "getNewSummary", "()Lim/session/service/Summary;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMUpdateSummary implements IMAction {
    private final Summary newSummary;
    private final KSessionId sessionId;

    public static /* synthetic */ IMUpdateSummary copy$default(IMUpdateSummary iMUpdateSummary, KSessionId kSessionId, Summary summary, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kSessionId = iMUpdateSummary.sessionId;
        }
        if ((i2 & 2) != 0) {
            summary = iMUpdateSummary.newSummary;
        }
        return iMUpdateSummary.copy(kSessionId, summary);
    }

    public final KSessionId component1() {
        return this.sessionId;
    }

    public final Summary component2() {
        return this.newSummary;
    }

    public final IMUpdateSummary copy(KSessionId kSessionId, Summary summary) {
        Intrinsics.checkNotNullParameter(kSessionId, "sessionId");
        return new IMUpdateSummary(kSessionId, summary);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMUpdateSummary) {
            IMUpdateSummary iMUpdateSummary = (IMUpdateSummary) obj;
            return Intrinsics.areEqual(this.sessionId, iMUpdateSummary.sessionId) && Intrinsics.areEqual(this.newSummary, iMUpdateSummary.newSummary);
        }
        return false;
    }

    public int hashCode() {
        return (this.sessionId.hashCode() * 31) + (this.newSummary == null ? 0 : this.newSummary.hashCode());
    }

    public String toString() {
        KSessionId kSessionId = this.sessionId;
        return "IMUpdateSummary(sessionId=" + kSessionId + ", newSummary=" + this.newSummary + ")";
    }

    public IMUpdateSummary(KSessionId sessionId, Summary newSummary) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.sessionId = sessionId;
        this.newSummary = newSummary;
    }

    public final KSessionId getSessionId() {
        return this.sessionId;
    }

    public final Summary getNewSummary() {
        return this.newSummary;
    }
}