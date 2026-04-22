package kntr.app.live.room.recommend;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoomRecommendViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lkntr/app/live/room/recommend/LiveRoomRecommendEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "LoadType", "RequestAll", "RequestLoadMore", "Lkntr/app/live/room/recommend/LiveRoomRecommendEvent$RequestAll;", "Lkntr/app/live/room/recommend/LiveRoomRecommendEvent$RequestLoadMore;", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class LiveRoomRecommendEvent {

    /* compiled from: RoomRecommendViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkntr/app/live/room/recommend/LiveRoomRecommendEvent$LoadType;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;I)V", "ROOM", "IDOL", "HISTORY", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public enum LoadType {
        ROOM,
        IDOL,
        HISTORY;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<LoadType> getEntries() {
            return $ENTRIES;
        }
    }

    public /* synthetic */ LiveRoomRecommendEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LiveRoomRecommendEvent() {
    }

    /* compiled from: RoomRecommendViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/live/room/recommend/LiveRoomRecommendEvent$RequestAll;", "Lkntr/app/live/room/recommend/LiveRoomRecommendEvent;", "<init>", "()V", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class RequestAll extends LiveRoomRecommendEvent {
        public RequestAll() {
            super(null);
        }
    }

    /* compiled from: RoomRecommendViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/live/room/recommend/LiveRoomRecommendEvent$RequestLoadMore;", "Lkntr/app/live/room/recommend/LiveRoomRecommendEvent;", "type", "Lkntr/app/live/room/recommend/LiveRoomRecommendEvent$LoadType;", "<init>", "(Lkntr/app/live/room/recommend/LiveRoomRecommendEvent$LoadType;)V", "getType", "()Lkntr/app/live/room/recommend/LiveRoomRecommendEvent$LoadType;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class RequestLoadMore extends LiveRoomRecommendEvent {
        private final LoadType type;

        public static /* synthetic */ RequestLoadMore copy$default(RequestLoadMore requestLoadMore, LoadType loadType, int i, Object obj) {
            if ((i & 1) != 0) {
                loadType = requestLoadMore.type;
            }
            return requestLoadMore.copy(loadType);
        }

        public final LoadType component1() {
            return this.type;
        }

        public final RequestLoadMore copy(LoadType loadType) {
            Intrinsics.checkNotNullParameter(loadType, "type");
            return new RequestLoadMore(loadType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RequestLoadMore) && this.type == ((RequestLoadMore) obj).type;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "RequestLoadMore(type=" + this.type + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestLoadMore(LoadType type) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public final LoadType getType() {
            return this.type;
        }
    }
}