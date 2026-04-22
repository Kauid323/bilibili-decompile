package live.room.recommend;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveRoomHistoryViewModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Llive/room/recommend/LiveRoomHistoryEvent;", "", "<init>", "()V", "RequestAll", "RequestLoadMore", "deleteHistory", "Llive/room/recommend/LiveRoomHistoryEvent$RequestAll;", "Llive/room/recommend/LiveRoomHistoryEvent$RequestLoadMore;", "Llive/room/recommend/LiveRoomHistoryEvent$deleteHistory;", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class LiveRoomHistoryEvent {
    public /* synthetic */ LiveRoomHistoryEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: LiveRoomHistoryViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Llive/room/recommend/LiveRoomHistoryEvent$RequestAll;", "Llive/room/recommend/LiveRoomHistoryEvent;", "<init>", "()V", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class RequestAll extends LiveRoomHistoryEvent {
        public RequestAll() {
            super(null);
        }
    }

    private LiveRoomHistoryEvent() {
    }

    /* compiled from: LiveRoomHistoryViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Llive/room/recommend/LiveRoomHistoryEvent$RequestLoadMore;", "Llive/room/recommend/LiveRoomHistoryEvent;", "<init>", "()V", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class RequestLoadMore extends LiveRoomHistoryEvent {
        public RequestLoadMore() {
            super(null);
        }
    }

    /* compiled from: LiveRoomHistoryViewModel.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Llive/room/recommend/LiveRoomHistoryEvent$deleteHistory;", "Llive/room/recommend/LiveRoomHistoryEvent;", "historyKids", "", "", "buvid", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getHistoryKids", "()Ljava/util/List;", "getBuvid", "()Ljava/lang/String;", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class deleteHistory extends LiveRoomHistoryEvent {
        private final String buvid;
        private final List<Long> historyKids;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public deleteHistory(List<Long> historyKids, String buvid) {
            super(null);
            Intrinsics.checkNotNullParameter(historyKids, "historyKids");
            Intrinsics.checkNotNullParameter(buvid, "buvid");
            this.historyKids = historyKids;
            this.buvid = buvid;
        }

        public final List<Long> getHistoryKids() {
            return this.historyKids;
        }

        public final String getBuvid() {
            return this.buvid;
        }
    }
}