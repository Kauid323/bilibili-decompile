package kntr.app.tribee.repost.page.selectTribeeBottomSheet;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListScrollPosition;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectableTribeeItem;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectableTribeePartition;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectTribeeBottomSheetStateAction.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction;", "", "Loading", "LoadMore", "ListTribeeItemExposed", "SelectTribeeOrPartition", "SaveListScrollPosition", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction$ListTribeeItemExposed;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction$LoadMore;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction$Loading;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction$SaveListScrollPosition;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction$SelectTribeeOrPartition;", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface SelectTribeeBottomSheetStateAction {

    /* compiled from: SelectTribeeBottomSheetStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction$Loading;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Loading implements SelectTribeeBottomSheetStateAction {
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
            return 956446306;
        }

        public String toString() {
            return "Loading";
        }

        private Loading() {
        }
    }

    /* compiled from: SelectTribeeBottomSheetStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction$LoadMore;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LoadMore implements SelectTribeeBottomSheetStateAction {
        public static final int $stable = 0;
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
            return -415768331;
        }

        public String toString() {
            return "LoadMore";
        }

        private LoadMore() {
        }
    }

    /* compiled from: SelectTribeeBottomSheetStateAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction$ListTribeeItemExposed;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction;", "tribeeId", "", "tribeeName", "", "<init>", "(JLjava/lang/String;)V", "getTribeeId", "()J", "getTribeeName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ListTribeeItemExposed implements SelectTribeeBottomSheetStateAction {
        public static final int $stable = 0;
        private final long tribeeId;
        private final String tribeeName;

        public static /* synthetic */ ListTribeeItemExposed copy$default(ListTribeeItemExposed listTribeeItemExposed, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = listTribeeItemExposed.tribeeId;
            }
            if ((i & 2) != 0) {
                str = listTribeeItemExposed.tribeeName;
            }
            return listTribeeItemExposed.copy(j, str);
        }

        public final long component1() {
            return this.tribeeId;
        }

        public final String component2() {
            return this.tribeeName;
        }

        public final ListTribeeItemExposed copy(long j, String str) {
            Intrinsics.checkNotNullParameter(str, "tribeeName");
            return new ListTribeeItemExposed(j, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ListTribeeItemExposed) {
                ListTribeeItemExposed listTribeeItemExposed = (ListTribeeItemExposed) obj;
                return this.tribeeId == listTribeeItemExposed.tribeeId && Intrinsics.areEqual(this.tribeeName, listTribeeItemExposed.tribeeName);
            }
            return false;
        }

        public int hashCode() {
            return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.tribeeId) * 31) + this.tribeeName.hashCode();
        }

        public String toString() {
            long j = this.tribeeId;
            return "ListTribeeItemExposed(tribeeId=" + j + ", tribeeName=" + this.tribeeName + ")";
        }

        public ListTribeeItemExposed(long tribeeId, String tribeeName) {
            Intrinsics.checkNotNullParameter(tribeeName, "tribeeName");
            this.tribeeId = tribeeId;
            this.tribeeName = tribeeName;
        }

        public final long getTribeeId() {
            return this.tribeeId;
        }

        public final String getTribeeName() {
            return this.tribeeName;
        }
    }

    /* compiled from: SelectTribeeBottomSheetStateAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction$SelectTribeeOrPartition;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction;", "tribee", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeeItem;", "partition", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeePartition;", "<init>", "(Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeeItem;Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeePartition;)V", "getTribee", "()Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeeItem;", "getPartition", "()Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeePartition;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SelectTribeeOrPartition implements SelectTribeeBottomSheetStateAction {
        public static final int $stable = 0;
        private final SelectableTribeePartition partition;
        private final SelectableTribeeItem tribee;

        public static /* synthetic */ SelectTribeeOrPartition copy$default(SelectTribeeOrPartition selectTribeeOrPartition, SelectableTribeeItem selectableTribeeItem, SelectableTribeePartition selectableTribeePartition, int i, Object obj) {
            if ((i & 1) != 0) {
                selectableTribeeItem = selectTribeeOrPartition.tribee;
            }
            if ((i & 2) != 0) {
                selectableTribeePartition = selectTribeeOrPartition.partition;
            }
            return selectTribeeOrPartition.copy(selectableTribeeItem, selectableTribeePartition);
        }

        public final SelectableTribeeItem component1() {
            return this.tribee;
        }

        public final SelectableTribeePartition component2() {
            return this.partition;
        }

        public final SelectTribeeOrPartition copy(SelectableTribeeItem selectableTribeeItem, SelectableTribeePartition selectableTribeePartition) {
            return new SelectTribeeOrPartition(selectableTribeeItem, selectableTribeePartition);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SelectTribeeOrPartition) {
                SelectTribeeOrPartition selectTribeeOrPartition = (SelectTribeeOrPartition) obj;
                return Intrinsics.areEqual(this.tribee, selectTribeeOrPartition.tribee) && Intrinsics.areEqual(this.partition, selectTribeeOrPartition.partition);
            }
            return false;
        }

        public int hashCode() {
            return ((this.tribee == null ? 0 : this.tribee.hashCode()) * 31) + (this.partition != null ? this.partition.hashCode() : 0);
        }

        public String toString() {
            SelectableTribeeItem selectableTribeeItem = this.tribee;
            return "SelectTribeeOrPartition(tribee=" + selectableTribeeItem + ", partition=" + this.partition + ")";
        }

        public SelectTribeeOrPartition(SelectableTribeeItem tribee, SelectableTribeePartition partition) {
            this.tribee = tribee;
            this.partition = partition;
        }

        public final SelectableTribeeItem getTribee() {
            return this.tribee;
        }

        public final SelectableTribeePartition getPartition() {
            return this.partition;
        }
    }

    /* compiled from: SelectTribeeBottomSheetStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction$SaveListScrollPosition;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction;", "listScrollPosition", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectTribeeListScrollPosition;", "<init>", "(Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectTribeeListScrollPosition;)V", "getListScrollPosition", "()Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectTribeeListScrollPosition;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SaveListScrollPosition implements SelectTribeeBottomSheetStateAction {
        public static final int $stable = 0;
        private final SelectTribeeListScrollPosition listScrollPosition;

        public static /* synthetic */ SaveListScrollPosition copy$default(SaveListScrollPosition saveListScrollPosition, SelectTribeeListScrollPosition selectTribeeListScrollPosition, int i, Object obj) {
            if ((i & 1) != 0) {
                selectTribeeListScrollPosition = saveListScrollPosition.listScrollPosition;
            }
            return saveListScrollPosition.copy(selectTribeeListScrollPosition);
        }

        public final SelectTribeeListScrollPosition component1() {
            return this.listScrollPosition;
        }

        public final SaveListScrollPosition copy(SelectTribeeListScrollPosition selectTribeeListScrollPosition) {
            Intrinsics.checkNotNullParameter(selectTribeeListScrollPosition, "listScrollPosition");
            return new SaveListScrollPosition(selectTribeeListScrollPosition);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SaveListScrollPosition) && Intrinsics.areEqual(this.listScrollPosition, ((SaveListScrollPosition) obj).listScrollPosition);
        }

        public int hashCode() {
            return this.listScrollPosition.hashCode();
        }

        public String toString() {
            return "SaveListScrollPosition(listScrollPosition=" + this.listScrollPosition + ")";
        }

        public SaveListScrollPosition(SelectTribeeListScrollPosition listScrollPosition) {
            Intrinsics.checkNotNullParameter(listScrollPosition, "listScrollPosition");
            this.listScrollPosition = listScrollPosition;
        }

        public final SelectTribeeListScrollPosition getListScrollPosition() {
            return this.listScrollPosition;
        }
    }
}