package kntr.app.im.chat.db.entity;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RangeEntity.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lkntr/app/im/chat/db/entity/RangeEntity;", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "start", "end", "<init>", "(JLkntr/app/im/chat/db/entity/SessionIdEntity;JJ)V", "getId", "()J", "getSessionId", "()Lkntr/app/im/chat/db/entity/SessionIdEntity;", "getStart", "getEnd", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RangeEntity {
    private final long end;
    private final long id;
    private final SessionIdEntity sessionId;
    private final long start;

    public final long component1() {
        return this.id;
    }

    public final SessionIdEntity component2() {
        return this.sessionId;
    }

    public final long component3() {
        return this.start;
    }

    public final long component4() {
        return this.end;
    }

    public final RangeEntity copy(long j2, SessionIdEntity sessionIdEntity, long j3, long j4) {
        Intrinsics.checkNotNullParameter(sessionIdEntity, "sessionId");
        return new RangeEntity(j2, sessionIdEntity, j3, j4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RangeEntity) {
            RangeEntity rangeEntity = (RangeEntity) obj;
            return this.id == rangeEntity.id && Intrinsics.areEqual(this.sessionId, rangeEntity.sessionId) && this.start == rangeEntity.start && this.end == rangeEntity.end;
        }
        return false;
    }

    public int hashCode() {
        return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + this.sessionId.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.start)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.end);
    }

    public String toString() {
        long j2 = this.id;
        SessionIdEntity sessionIdEntity = this.sessionId;
        long j3 = this.start;
        return "RangeEntity(id=" + j2 + ", sessionId=" + sessionIdEntity + ", start=" + j3 + ", end=" + this.end + ")";
    }

    public RangeEntity(long id, SessionIdEntity sessionId, long start, long end) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.id = id;
        this.sessionId = sessionId;
        this.start = start;
        this.end = end;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RangeEntity(long j2, SessionIdEntity sessionIdEntity, long j3, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r3, sessionIdEntity, j3, j4);
        long j5;
        if ((i & 1) == 0) {
            j5 = j2;
        } else {
            j5 = 0;
        }
    }

    public final long getId() {
        return this.id;
    }

    public final SessionIdEntity getSessionId() {
        return this.sessionId;
    }

    public final long getStart() {
        return this.start;
    }

    public final long getEnd() {
        return this.end;
    }
}