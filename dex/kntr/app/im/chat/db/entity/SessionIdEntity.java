package kntr.app.im.chat.db.entity;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SessionIdEntity.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lkntr/app/im/chat/db/entity/SessionIdEntity;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionType", RoomRecommendViewModel.EMPTY_CURSOR, "primaryId", RoomRecommendViewModel.EMPTY_CURSOR, "secondaryId", "thirdId", "<init>", "(IJJJ)V", "getSessionType", "()I", "getPrimaryId", "()J", "getSecondaryId", "getThirdId", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SessionIdEntity {
    private final long primaryId;
    private final long secondaryId;
    private final int sessionType;
    private final long thirdId;

    public SessionIdEntity() {
        this(0, 0L, 0L, 0L, 15, null);
    }

    public static /* synthetic */ SessionIdEntity copy$default(SessionIdEntity sessionIdEntity, int i, long j2, long j3, long j4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = sessionIdEntity.sessionType;
        }
        if ((i2 & 2) != 0) {
            j2 = sessionIdEntity.primaryId;
        }
        long j5 = j2;
        if ((i2 & 4) != 0) {
            j3 = sessionIdEntity.secondaryId;
        }
        long j6 = j3;
        if ((i2 & 8) != 0) {
            j4 = sessionIdEntity.thirdId;
        }
        return sessionIdEntity.copy(i, j5, j6, j4);
    }

    public final int component1() {
        return this.sessionType;
    }

    public final long component2() {
        return this.primaryId;
    }

    public final long component3() {
        return this.secondaryId;
    }

    public final long component4() {
        return this.thirdId;
    }

    public final SessionIdEntity copy(int i, long j2, long j3, long j4) {
        return new SessionIdEntity(i, j2, j3, j4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SessionIdEntity) {
            SessionIdEntity sessionIdEntity = (SessionIdEntity) obj;
            return this.sessionType == sessionIdEntity.sessionType && this.primaryId == sessionIdEntity.primaryId && this.secondaryId == sessionIdEntity.secondaryId && this.thirdId == sessionIdEntity.thirdId;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.sessionType * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.primaryId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.secondaryId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.thirdId);
    }

    public String toString() {
        int i = this.sessionType;
        long j2 = this.primaryId;
        long j3 = this.secondaryId;
        return "SessionIdEntity(sessionType=" + i + ", primaryId=" + j2 + ", secondaryId=" + j3 + ", thirdId=" + this.thirdId + ")";
    }

    public SessionIdEntity(int sessionType, long primaryId, long secondaryId, long thirdId) {
        this.sessionType = sessionType;
        this.primaryId = primaryId;
        this.secondaryId = secondaryId;
        this.thirdId = thirdId;
    }

    public /* synthetic */ SessionIdEntity(int i, long j2, long j3, long j4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j2, (i2 & 4) != 0 ? 0L : j3, (i2 & 8) != 0 ? 0L : j4);
    }

    public final int getSessionType() {
        return this.sessionType;
    }

    public final long getPrimaryId() {
        return this.primaryId;
    }

    public final long getSecondaryId() {
        return this.secondaryId;
    }

    public final long getThirdId() {
        return this.thirdId;
    }
}