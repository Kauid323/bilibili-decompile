package kntr.app.im.base;

import BottomSheetItemData$;
import com.bapis.bilibili.app.im.v1.KSessionId;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMEventHub.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lkntr/app/im/base/IMBlacklistChangedEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionID", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "isAdd", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;Z)V", "getSessionID", "()Lcom/bapis/bilibili/app/im/v1/KSessionId;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMBlacklistChangedEvent {
    private final boolean isAdd;
    private final KSessionId sessionID;

    public static /* synthetic */ IMBlacklistChangedEvent copy$default(IMBlacklistChangedEvent iMBlacklistChangedEvent, KSessionId kSessionId, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            kSessionId = iMBlacklistChangedEvent.sessionID;
        }
        if ((i & 2) != 0) {
            z = iMBlacklistChangedEvent.isAdd;
        }
        return iMBlacklistChangedEvent.copy(kSessionId, z);
    }

    public final KSessionId component1() {
        return this.sessionID;
    }

    public final boolean component2() {
        return this.isAdd;
    }

    public final IMBlacklistChangedEvent copy(KSessionId kSessionId, boolean z) {
        Intrinsics.checkNotNullParameter(kSessionId, "sessionID");
        return new IMBlacklistChangedEvent(kSessionId, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMBlacklistChangedEvent) {
            IMBlacklistChangedEvent iMBlacklistChangedEvent = (IMBlacklistChangedEvent) obj;
            return Intrinsics.areEqual(this.sessionID, iMBlacklistChangedEvent.sessionID) && this.isAdd == iMBlacklistChangedEvent.isAdd;
        }
        return false;
    }

    public int hashCode() {
        return (this.sessionID.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isAdd);
    }

    public String toString() {
        KSessionId kSessionId = this.sessionID;
        return "IMBlacklistChangedEvent(sessionID=" + kSessionId + ", isAdd=" + this.isAdd + ")";
    }

    public IMBlacklistChangedEvent(KSessionId sessionID, boolean isAdd) {
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        this.sessionID = sessionID;
        this.isAdd = isAdd;
    }

    public final KSessionId getSessionID() {
        return this.sessionID;
    }

    public final boolean isAdd() {
        return this.isAdd;
    }
}