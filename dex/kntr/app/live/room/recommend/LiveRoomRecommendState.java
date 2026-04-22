package kntr.app.live.room.recommend;

import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KMoreLiveRoomInfo;
import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KMyIdolInfo;
import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KViewHistory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoomRecommendViewModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lkntr/app/live/room/recommend/LiveRoomRecommendState;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Idle", "Content", "Error", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class LiveRoomRecommendState {

    /* compiled from: RoomRecommendViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/live/room/recommend/LiveRoomRecommendState$Idle;", "Lkntr/app/live/room/recommend/LiveRoomRecommendState;", "<init>", "()V", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Idle extends LiveRoomRecommendState {
        public static final Idle INSTANCE = new Idle();

        private Idle() {
        }
    }

    /* compiled from: RoomRecommendViewModel.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lkntr/app/live/room/recommend/LiveRoomRecommendState$Content;", "Lkntr/app/live/room/recommend/LiveRoomRecommendState;", "idols", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/live/app/interfaces/api/grpc/v1/KMyIdolInfo;", "rooms", "Lcom/bapis/bilibili/live/app/interfaces/api/grpc/v1/KMoreLiveRoomInfo;", "historys", "Lcom/bapis/bilibili/live/app/interfaces/api/grpc/v1/KViewHistory;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getIdols", "()Ljava/util/List;", "getRooms", "getHistorys", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Content extends LiveRoomRecommendState {
        private final List<KViewHistory> historys;
        private final List<KMyIdolInfo> idols;
        private final List<KMoreLiveRoomInfo> rooms;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Content copy$default(Content content, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = content.idols;
            }
            if ((i & 2) != 0) {
                list2 = content.rooms;
            }
            if ((i & 4) != 0) {
                list3 = content.historys;
            }
            return content.copy(list, list2, list3);
        }

        public final List<KMyIdolInfo> component1() {
            return this.idols;
        }

        public final List<KMoreLiveRoomInfo> component2() {
            return this.rooms;
        }

        public final List<KViewHistory> component3() {
            return this.historys;
        }

        public final Content copy(List<KMyIdolInfo> list, List<KMoreLiveRoomInfo> list2, List<KViewHistory> list3) {
            Intrinsics.checkNotNullParameter(list, "idols");
            Intrinsics.checkNotNullParameter(list2, "rooms");
            Intrinsics.checkNotNullParameter(list3, "historys");
            return new Content(list, list2, list3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Content) {
                Content content = (Content) obj;
                return Intrinsics.areEqual(this.idols, content.idols) && Intrinsics.areEqual(this.rooms, content.rooms) && Intrinsics.areEqual(this.historys, content.historys);
            }
            return false;
        }

        public int hashCode() {
            return (((this.idols.hashCode() * 31) + this.rooms.hashCode()) * 31) + this.historys.hashCode();
        }

        public String toString() {
            List<KMyIdolInfo> list = this.idols;
            List<KMoreLiveRoomInfo> list2 = this.rooms;
            return "Content(idols=" + list + ", rooms=" + list2 + ", historys=" + this.historys + ")";
        }

        public Content(List<KMyIdolInfo> list, List<KMoreLiveRoomInfo> list2, List<KViewHistory> list3) {
            Intrinsics.checkNotNullParameter(list, "idols");
            Intrinsics.checkNotNullParameter(list2, "rooms");
            Intrinsics.checkNotNullParameter(list3, "historys");
            this.idols = list;
            this.rooms = list2;
            this.historys = list3;
        }

        public final List<KMyIdolInfo> getIdols() {
            return this.idols;
        }

        public final List<KMoreLiveRoomInfo> getRooms() {
            return this.rooms;
        }

        public final List<KViewHistory> getHistorys() {
            return this.historys;
        }
    }

    /* compiled from: RoomRecommendViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/live/room/recommend/LiveRoomRecommendState$Error;", "Lkntr/app/live/room/recommend/LiveRoomRecommendState;", "errorMessage", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Error extends LiveRoomRecommendState {
        private final String errorMessage;

        public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.errorMessage;
            }
            return error.copy(str);
        }

        public final String component1() {
            return this.errorMessage;
        }

        public final Error copy(String str) {
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            return new Error(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual(this.errorMessage, ((Error) obj).errorMessage);
        }

        public int hashCode() {
            return this.errorMessage.hashCode();
        }

        public String toString() {
            return "Error(errorMessage=" + this.errorMessage + ")";
        }

        public Error(String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            this.errorMessage = errorMessage;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }
    }
}