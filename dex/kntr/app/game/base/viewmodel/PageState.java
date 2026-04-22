package kntr.app.game.base.viewmodel;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseViewModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/app/game/base/viewmodel/PageState;", RoomRecommendViewModel.EMPTY_CURSOR, "Initialize", "Loading", "Empty", "Content", "Error", "Lkntr/app/game/base/viewmodel/PageState$Content;", "Lkntr/app/game/base/viewmodel/PageState$Empty;", "Lkntr/app/game/base/viewmodel/PageState$Error;", "Lkntr/app/game/base/viewmodel/PageState$Initialize;", "Lkntr/app/game/base/viewmodel/PageState$Loading;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PageState {

    /* compiled from: BaseViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/game/base/viewmodel/PageState$Initialize;", "Lkntr/app/game/base/viewmodel/PageState;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Initialize implements PageState {
        public static final int $stable = 0;
        public static final Initialize INSTANCE = new Initialize();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Initialize) {
                Initialize initialize = (Initialize) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1372042335;
        }

        public String toString() {
            return "Initialize";
        }

        private Initialize() {
        }
    }

    /* compiled from: BaseViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/game/base/viewmodel/PageState$Loading;", "Lkntr/app/game/base/viewmodel/PageState;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Loading implements PageState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Loading) {
                Loading loading = (Loading) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 919454411;
        }

        public String toString() {
            return "Loading";
        }

        private Loading() {
        }
    }

    /* compiled from: BaseViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/game/base/viewmodel/PageState$Empty;", "Lkntr/app/game/base/viewmodel/PageState;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Empty implements PageState {
        public static final int $stable = 0;
        public static final Empty INSTANCE = new Empty();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Empty) {
                Empty empty = (Empty) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -434602340;
        }

        public String toString() {
            return "Empty";
        }

        private Empty() {
        }
    }

    /* compiled from: BaseViewModel.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0013\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J2\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lkntr/app/game/base/viewmodel/PageState$Content;", "Data", "Lkntr/app/game/base/viewmodel/PageState;", "data", "loadMore", "Lkntr/app/game/base/viewmodel/PageLoadMoreState;", "refreshState", "Lkntr/app/game/base/viewmodel/RefreshState;", "<init>", "(Ljava/lang/Object;Lkntr/app/game/base/viewmodel/PageLoadMoreState;Lkntr/app/game/base/viewmodel/RefreshState;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getLoadMore", "()Lkntr/app/game/base/viewmodel/PageLoadMoreState;", "getRefreshState", "()Lkntr/app/game/base/viewmodel/RefreshState;", "setRefreshState", "(Lkntr/app/game/base/viewmodel/RefreshState;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Lkntr/app/game/base/viewmodel/PageLoadMoreState;Lkntr/app/game/base/viewmodel/RefreshState;)Lkntr/app/game/base/viewmodel/PageState$Content;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Content<Data> implements PageState {
        public static final int $stable = 8;
        private final Data data;
        private final PageLoadMoreState loadMore;
        private RefreshState refreshState;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Content copy$default(Content content, Object obj, PageLoadMoreState pageLoadMoreState, RefreshState refreshState, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = content.data;
            }
            if ((i & 2) != 0) {
                pageLoadMoreState = content.loadMore;
            }
            if ((i & 4) != 0) {
                refreshState = content.refreshState;
            }
            return content.copy(obj, pageLoadMoreState, refreshState);
        }

        public final Data component1() {
            return this.data;
        }

        public final PageLoadMoreState component2() {
            return this.loadMore;
        }

        public final RefreshState component3() {
            return this.refreshState;
        }

        public final Content<Data> copy(Data data, PageLoadMoreState pageLoadMoreState, RefreshState refreshState) {
            Intrinsics.checkNotNullParameter(pageLoadMoreState, "loadMore");
            Intrinsics.checkNotNullParameter(refreshState, "refreshState");
            return new Content<>(data, pageLoadMoreState, refreshState);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Content) {
                Content content = (Content) obj;
                return Intrinsics.areEqual(this.data, content.data) && Intrinsics.areEqual(this.loadMore, content.loadMore) && Intrinsics.areEqual(this.refreshState, content.refreshState);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.data == null ? 0 : this.data.hashCode()) * 31) + this.loadMore.hashCode()) * 31) + this.refreshState.hashCode();
        }

        public String toString() {
            Data data = this.data;
            PageLoadMoreState pageLoadMoreState = this.loadMore;
            return "Content(data=" + data + ", loadMore=" + pageLoadMoreState + ", refreshState=" + this.refreshState + ")";
        }

        public Content(Data data, PageLoadMoreState loadMore, RefreshState refreshState) {
            Intrinsics.checkNotNullParameter(loadMore, "loadMore");
            Intrinsics.checkNotNullParameter(refreshState, "refreshState");
            this.data = data;
            this.loadMore = loadMore;
            this.refreshState = refreshState;
        }

        public /* synthetic */ Content(Object obj, PageLoadMoreState pageLoadMoreState, RefreshState refreshState, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i & 2) != 0 ? PageLoadMoreState.Companion.getIdle() : pageLoadMoreState, (i & 4) != 0 ? RefreshState.Companion.getIdle() : refreshState);
        }

        public final Data getData() {
            return this.data;
        }

        public final PageLoadMoreState getLoadMore() {
            return this.loadMore;
        }

        public final RefreshState getRefreshState() {
            return this.refreshState;
        }

        public final void setRefreshState(RefreshState refreshState) {
            Intrinsics.checkNotNullParameter(refreshState, "<set-?>");
            this.refreshState = refreshState;
        }
    }

    /* compiled from: BaseViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/app/game/base/viewmodel/PageState$Error;", "Lkntr/app/game/base/viewmodel/PageState;", "code", RoomRecommendViewModel.EMPTY_CURSOR, "message", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Error implements PageState {
        public static final int $stable = 0;
        private final int code;
        private final String message;

        public static /* synthetic */ Error copy$default(Error error, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = error.code;
            }
            if ((i2 & 2) != 0) {
                str = error.message;
            }
            return error.copy(i, str);
        }

        public final int component1() {
            return this.code;
        }

        public final String component2() {
            return this.message;
        }

        public final Error copy(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new Error(i, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Error) {
                Error error = (Error) obj;
                return this.code == error.code && Intrinsics.areEqual(this.message, error.message);
            }
            return false;
        }

        public int hashCode() {
            return (this.code * 31) + this.message.hashCode();
        }

        public String toString() {
            int i = this.code;
            return "Error(code=" + i + ", message=" + this.message + ")";
        }

        public Error(int code, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.code = code;
            this.message = message;
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }
    }
}