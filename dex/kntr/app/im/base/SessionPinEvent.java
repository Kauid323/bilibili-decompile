package kntr.app.im.base;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.im.v1.KSessionId;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMEventHub.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lkntr/app/im/base/SessionPinEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionID", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "isPinned", RoomRecommendViewModel.EMPTY_CURSOR, "sequenceNumber", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;ZJ)V", "getSessionID", "()Lcom/bapis/bilibili/app/im/v1/KSessionId;", "()Z", "getSequenceNumber", "()J", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SessionPinEvent {
    private final boolean isPinned;
    private final long sequenceNumber;
    private final KSessionId sessionID;

    public static /* synthetic */ SessionPinEvent copy$default(SessionPinEvent sessionPinEvent, KSessionId kSessionId, boolean z, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            kSessionId = sessionPinEvent.sessionID;
        }
        if ((i & 2) != 0) {
            z = sessionPinEvent.isPinned;
        }
        if ((i & 4) != 0) {
            j2 = sessionPinEvent.sequenceNumber;
        }
        return sessionPinEvent.copy(kSessionId, z, j2);
    }

    public final KSessionId component1() {
        return this.sessionID;
    }

    public final boolean component2() {
        return this.isPinned;
    }

    public final long component3() {
        return this.sequenceNumber;
    }

    public final SessionPinEvent copy(KSessionId kSessionId, boolean z, long j2) {
        Intrinsics.checkNotNullParameter(kSessionId, "sessionID");
        return new SessionPinEvent(kSessionId, z, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SessionPinEvent) {
            SessionPinEvent sessionPinEvent = (SessionPinEvent) obj;
            return Intrinsics.areEqual(this.sessionID, sessionPinEvent.sessionID) && this.isPinned == sessionPinEvent.isPinned && this.sequenceNumber == sessionPinEvent.sequenceNumber;
        }
        return false;
    }

    public int hashCode() {
        return (((this.sessionID.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isPinned)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.sequenceNumber);
    }

    public String toString() {
        KSessionId kSessionId = this.sessionID;
        boolean z = this.isPinned;
        return "SessionPinEvent(sessionID=" + kSessionId + ", isPinned=" + z + ", sequenceNumber=" + this.sequenceNumber + ")";
    }

    public SessionPinEvent(KSessionId sessionID, boolean isPinned, long sequenceNumber) {
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        this.sessionID = sessionID;
        this.isPinned = isPinned;
        this.sequenceNumber = sequenceNumber;
    }

    public final KSessionId getSessionID() {
        return this.sessionID;
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }
}