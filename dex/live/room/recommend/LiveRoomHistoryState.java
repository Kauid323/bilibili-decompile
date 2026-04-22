package live.room.recommend;

import com.bapis.bilibili.live.app.interfaces.api.grpc.v1.KViewHistory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveRoomHistoryViewModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Llive/room/recommend/LiveRoomHistoryState;", "", "<init>", "()V", "Idle", "Content", "Success", "Error", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class LiveRoomHistoryState {

    /* compiled from: LiveRoomHistoryViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Llive/room/recommend/LiveRoomHistoryState$Idle;", "Llive/room/recommend/LiveRoomHistoryState;", "<init>", "()V", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Idle extends LiveRoomHistoryState {
        public static final Idle INSTANCE = new Idle();

        private Idle() {
        }
    }

    /* compiled from: LiveRoomHistoryViewModel.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ*\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Llive/room/recommend/LiveRoomHistoryState$Content;", "Llive/room/recommend/LiveRoomHistoryState;", "historyList", "", "Lcom/bapis/bilibili/live/app/interfaces/api/grpc/v1/KViewHistory;", "hasMore", "", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;)V", "getHistoryList", "()Ljava/util/List;", "getHasMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Boolean;)Llive/room/recommend/LiveRoomHistoryState$Content;", "equals", "other", "", "hashCode", "", "toString", "", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Content extends LiveRoomHistoryState {
        private final Boolean hasMore;
        private final List<KViewHistory> historyList;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Content copy$default(Content content, List list, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                list = content.historyList;
            }
            if ((i & 2) != 0) {
                bool = content.hasMore;
            }
            return content.copy(list, bool);
        }

        public final List<KViewHistory> component1() {
            return this.historyList;
        }

        public final Boolean component2() {
            return this.hasMore;
        }

        public final Content copy(List<KViewHistory> historyList, Boolean bool) {
            Intrinsics.checkNotNullParameter(historyList, "historyList");
            return new Content(historyList, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Content) {
                Content content = (Content) obj;
                return Intrinsics.areEqual(this.historyList, content.historyList) && Intrinsics.areEqual(this.hasMore, content.hasMore);
            }
            return false;
        }

        public int hashCode() {
            return (this.historyList.hashCode() * 31) + (this.hasMore == null ? 0 : this.hasMore.hashCode());
        }

        public String toString() {
            List<KViewHistory> list = this.historyList;
            return "Content(historyList=" + list + ", hasMore=" + this.hasMore + ")";
        }

        public Content(List<KViewHistory> historyList, Boolean hasMore) {
            Intrinsics.checkNotNullParameter(historyList, "historyList");
            this.historyList = historyList;
            this.hasMore = hasMore;
        }

        public /* synthetic */ Content(List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? true : bool);
        }

        public final List<KViewHistory> getHistoryList() {
            return this.historyList;
        }

        public final Boolean getHasMore() {
            return this.hasMore;
        }
    }

    /* compiled from: LiveRoomHistoryViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Llive/room/recommend/LiveRoomHistoryState$Success;", "Llive/room/recommend/LiveRoomHistoryState;", "<init>", "()V", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Success extends LiveRoomHistoryState {
        public static final Success INSTANCE = new Success();

        private Success() {
        }
    }

    /* compiled from: LiveRoomHistoryViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Llive/room/recommend/LiveRoomHistoryState$Error;", "Llive/room/recommend/LiveRoomHistoryState;", "errorMessage", "", "<init>", "(Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "recommend_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Error extends LiveRoomHistoryState {
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

        public final Error copy(String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            return new Error(errorMessage);
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