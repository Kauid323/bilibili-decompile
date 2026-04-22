package kntr.app.im.chat.db.entity;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionPushInfoMessage.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lkntr/app/im/chat/db/entity/SessionPushInfoMessage;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "phaseOneId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;Ljava/lang/Long;)V", "getSessionId", "()Lkntr/app/im/chat/db/entity/SessionIdEntity;", "getPhaseOneId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;Ljava/lang/Long;)Lkntr/app/im/chat/db/entity/SessionPushInfoMessage;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SessionPushInfoMessage {
    private final Long phaseOneId;
    private final SessionIdEntity sessionId;

    public static /* synthetic */ SessionPushInfoMessage copy$default(SessionPushInfoMessage sessionPushInfoMessage, SessionIdEntity sessionIdEntity, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            sessionIdEntity = sessionPushInfoMessage.sessionId;
        }
        if ((i & 2) != 0) {
            l = sessionPushInfoMessage.phaseOneId;
        }
        return sessionPushInfoMessage.copy(sessionIdEntity, l);
    }

    public final SessionIdEntity component1() {
        return this.sessionId;
    }

    public final Long component2() {
        return this.phaseOneId;
    }

    public final SessionPushInfoMessage copy(SessionIdEntity sessionIdEntity, Long l) {
        Intrinsics.checkNotNullParameter(sessionIdEntity, "sessionId");
        return new SessionPushInfoMessage(sessionIdEntity, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SessionPushInfoMessage) {
            SessionPushInfoMessage sessionPushInfoMessage = (SessionPushInfoMessage) obj;
            return Intrinsics.areEqual(this.sessionId, sessionPushInfoMessage.sessionId) && Intrinsics.areEqual(this.phaseOneId, sessionPushInfoMessage.phaseOneId);
        }
        return false;
    }

    public int hashCode() {
        return (this.sessionId.hashCode() * 31) + (this.phaseOneId == null ? 0 : this.phaseOneId.hashCode());
    }

    public String toString() {
        SessionIdEntity sessionIdEntity = this.sessionId;
        return "SessionPushInfoMessage(sessionId=" + sessionIdEntity + ", phaseOneId=" + this.phaseOneId + ")";
    }

    public SessionPushInfoMessage(SessionIdEntity sessionId, Long phaseOneId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.sessionId = sessionId;
        this.phaseOneId = phaseOneId;
    }

    public /* synthetic */ SessionPushInfoMessage(SessionIdEntity sessionIdEntity, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sessionIdEntity, (i & 2) != 0 ? null : l);
    }

    public final SessionIdEntity getSessionId() {
        return this.sessionId;
    }

    public final Long getPhaseOneId() {
        return this.phaseOneId;
    }
}