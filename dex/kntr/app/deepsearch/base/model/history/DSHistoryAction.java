package kntr.app.deepsearch.base.model.history;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DSHistoryAction.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/history/DSHistoryAction;", RoomRecommendViewModel.EMPTY_CURSOR, "SelectItem", "LoadAction", "HistoryTrackerAction", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction$HistoryTrackerAction;", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction$LoadAction;", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction$SelectItem;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DSHistoryAction {

    /* compiled from: DSHistoryAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/deepsearch/base/model/history/DSHistoryAction$SelectItem;", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction;", "conversationItem", "Lkntr/app/deepsearch/base/model/history/DSConversationItem;", "<init>", "(Lkntr/app/deepsearch/base/model/history/DSConversationItem;)V", "getConversationItem", "()Lkntr/app/deepsearch/base/model/history/DSConversationItem;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SelectItem implements DSHistoryAction {
        private final DSConversationItem conversationItem;

        public static /* synthetic */ SelectItem copy$default(SelectItem selectItem, DSConversationItem dSConversationItem, int i, Object obj) {
            if ((i & 1) != 0) {
                dSConversationItem = selectItem.conversationItem;
            }
            return selectItem.copy(dSConversationItem);
        }

        public final DSConversationItem component1() {
            return this.conversationItem;
        }

        public final SelectItem copy(DSConversationItem dSConversationItem) {
            Intrinsics.checkNotNullParameter(dSConversationItem, "conversationItem");
            return new SelectItem(dSConversationItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SelectItem) && Intrinsics.areEqual(this.conversationItem, ((SelectItem) obj).conversationItem);
        }

        public int hashCode() {
            return this.conversationItem.hashCode();
        }

        public String toString() {
            return "SelectItem(conversationItem=" + this.conversationItem + ")";
        }

        public SelectItem(DSConversationItem conversationItem) {
            Intrinsics.checkNotNullParameter(conversationItem, "conversationItem");
            this.conversationItem = conversationItem;
        }

        public final DSConversationItem getConversationItem() {
            return this.conversationItem;
        }
    }

    /* compiled from: DSHistoryAction.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/history/DSHistoryAction$LoadAction;", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction;", "Refresh", "LoadMore", "Retry", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction$LoadAction$LoadMore;", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction$LoadAction$Refresh;", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction$LoadAction$Retry;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface LoadAction extends DSHistoryAction {

        /* compiled from: DSHistoryAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/history/DSHistoryAction$LoadAction$Refresh;", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction$LoadAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Refresh implements LoadAction {
            public static final Refresh INSTANCE = new Refresh();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Refresh) {
                    Refresh refresh = (Refresh) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -959930408;
            }

            public String toString() {
                return "Refresh";
            }

            private Refresh() {
            }
        }

        /* compiled from: DSHistoryAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/history/DSHistoryAction$LoadAction$LoadMore;", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction$LoadAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class LoadMore implements LoadAction {
            public static final LoadMore INSTANCE = new LoadMore();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof LoadMore) {
                    LoadMore loadMore = (LoadMore) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -1431690242;
            }

            public String toString() {
                return "LoadMore";
            }

            private LoadMore() {
            }
        }

        /* compiled from: DSHistoryAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/history/DSHistoryAction$LoadAction$Retry;", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction$LoadAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Retry implements LoadAction {
            public static final Retry INSTANCE = new Retry();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Retry) {
                    Retry retry = (Retry) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -541766939;
            }

            public String toString() {
                return "Retry";
            }

            private Retry() {
            }
        }
    }

    /* compiled from: DSHistoryAction.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/history/DSHistoryAction$HistoryTrackerAction;", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction;", "ItemClick", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction$HistoryTrackerAction$ItemClick;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface HistoryTrackerAction extends DSHistoryAction {

        /* compiled from: DSHistoryAction.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/deepsearch/base/model/history/DSHistoryAction$HistoryTrackerAction$ItemClick;", "Lkntr/app/deepsearch/base/model/history/DSHistoryAction$HistoryTrackerAction;", "record", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getRecord", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class ItemClick implements HistoryTrackerAction {
            private final String record;

            public static /* synthetic */ ItemClick copy$default(ItemClick itemClick, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = itemClick.record;
                }
                return itemClick.copy(str);
            }

            public final String component1() {
                return this.record;
            }

            public final ItemClick copy(String str) {
                Intrinsics.checkNotNullParameter(str, "record");
                return new ItemClick(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ItemClick) && Intrinsics.areEqual(this.record, ((ItemClick) obj).record);
            }

            public int hashCode() {
                return this.record.hashCode();
            }

            public String toString() {
                return "ItemClick(record=" + this.record + ")";
            }

            public ItemClick(String record) {
                Intrinsics.checkNotNullParameter(record, "record");
                this.record = record;
            }

            public final String getRecord() {
                return this.record;
            }
        }
    }
}