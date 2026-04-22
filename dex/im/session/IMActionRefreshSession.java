package im.session;

import com.bapis.bilibili.app.im.v1.KSessionFilterType;
import com.bapis.bilibili.app.im.v1.KSessionId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMAction.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lim/session/IMActionRefreshSession;", "Lim/session/IMAction;", "sessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "kSessionFilterType", "Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;)V", "getSessionId", "()Lcom/bapis/bilibili/app/im/v1/KSessionId;", "getKSessionFilterType", "()Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMActionRefreshSession implements IMAction {
    private final KSessionFilterType kSessionFilterType;
    private final KSessionId sessionId;

    public static /* synthetic */ IMActionRefreshSession copy$default(IMActionRefreshSession iMActionRefreshSession, KSessionId kSessionId, KSessionFilterType kSessionFilterType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kSessionId = iMActionRefreshSession.sessionId;
        }
        if ((i2 & 2) != 0) {
            kSessionFilterType = iMActionRefreshSession.kSessionFilterType;
        }
        return iMActionRefreshSession.copy(kSessionId, kSessionFilterType);
    }

    public final KSessionId component1() {
        return this.sessionId;
    }

    public final KSessionFilterType component2() {
        return this.kSessionFilterType;
    }

    public final IMActionRefreshSession copy(KSessionId kSessionId, KSessionFilterType kSessionFilterType) {
        Intrinsics.checkNotNullParameter(kSessionId, "sessionId");
        Intrinsics.checkNotNullParameter(kSessionFilterType, "kSessionFilterType");
        return new IMActionRefreshSession(kSessionId, kSessionFilterType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMActionRefreshSession) {
            IMActionRefreshSession iMActionRefreshSession = (IMActionRefreshSession) obj;
            return Intrinsics.areEqual(this.sessionId, iMActionRefreshSession.sessionId) && Intrinsics.areEqual(this.kSessionFilterType, iMActionRefreshSession.kSessionFilterType);
        }
        return false;
    }

    public int hashCode() {
        return (this.sessionId.hashCode() * 31) + this.kSessionFilterType.hashCode();
    }

    public String toString() {
        KSessionId kSessionId = this.sessionId;
        return "IMActionRefreshSession(sessionId=" + kSessionId + ", kSessionFilterType=" + this.kSessionFilterType + ")";
    }

    public IMActionRefreshSession(KSessionId sessionId, KSessionFilterType kSessionFilterType) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(kSessionFilterType, "kSessionFilterType");
        this.sessionId = sessionId;
        this.kSessionFilterType = kSessionFilterType;
    }

    public final KSessionId getSessionId() {
        return this.sessionId;
    }

    public final KSessionFilterType getKSessionFilterType() {
        return this.kSessionFilterType;
    }
}