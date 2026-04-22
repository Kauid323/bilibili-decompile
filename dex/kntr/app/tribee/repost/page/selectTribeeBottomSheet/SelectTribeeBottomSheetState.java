package kntr.app.tribee.repost.page.selectTribeeBottomSheet;

import kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectTribeeBottomSheetState.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetState;", "", "<init>", "()V", "SelectTribeeBottomSheetLoadingState", "SelectTribeeBottomSheetErrorState", "SelectTribeeBottomSheetEmptyState", "SelectTribeeBottomSheetContentState", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetState$SelectTribeeBottomSheetContentState;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetState$SelectTribeeBottomSheetEmptyState;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetState$SelectTribeeBottomSheetErrorState;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetState$SelectTribeeBottomSheetLoadingState;", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class SelectTribeeBottomSheetState {
    public static final int $stable = 0;

    public /* synthetic */ SelectTribeeBottomSheetState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SelectTribeeBottomSheetState() {
    }

    /* compiled from: SelectTribeeBottomSheetState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetState$SelectTribeeBottomSheetLoadingState;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SelectTribeeBottomSheetLoadingState extends SelectTribeeBottomSheetState {
        public static final int $stable = 0;
        public static final SelectTribeeBottomSheetLoadingState INSTANCE = new SelectTribeeBottomSheetLoadingState();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SelectTribeeBottomSheetLoadingState) {
                SelectTribeeBottomSheetLoadingState selectTribeeBottomSheetLoadingState = (SelectTribeeBottomSheetLoadingState) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1024369542;
        }

        public String toString() {
            return "SelectTribeeBottomSheetLoadingState";
        }

        private SelectTribeeBottomSheetLoadingState() {
            super(null);
        }
    }

    /* compiled from: SelectTribeeBottomSheetState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetState$SelectTribeeBottomSheetErrorState;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SelectTribeeBottomSheetErrorState extends SelectTribeeBottomSheetState {
        public static final int $stable = 0;
        public static final SelectTribeeBottomSheetErrorState INSTANCE = new SelectTribeeBottomSheetErrorState();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SelectTribeeBottomSheetErrorState) {
                SelectTribeeBottomSheetErrorState selectTribeeBottomSheetErrorState = (SelectTribeeBottomSheetErrorState) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -185347462;
        }

        public String toString() {
            return "SelectTribeeBottomSheetErrorState";
        }

        private SelectTribeeBottomSheetErrorState() {
            super(null);
        }
    }

    /* compiled from: SelectTribeeBottomSheetState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetState$SelectTribeeBottomSheetEmptyState;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetState;", "emptyDesc", "", "<init>", "(Ljava/lang/String;)V", "getEmptyDesc", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SelectTribeeBottomSheetEmptyState extends SelectTribeeBottomSheetState {
        public static final int $stable = 0;
        private final String emptyDesc;

        public SelectTribeeBottomSheetEmptyState() {
            this(null, 1, null);
        }

        public static /* synthetic */ SelectTribeeBottomSheetEmptyState copy$default(SelectTribeeBottomSheetEmptyState selectTribeeBottomSheetEmptyState, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = selectTribeeBottomSheetEmptyState.emptyDesc;
            }
            return selectTribeeBottomSheetEmptyState.copy(str);
        }

        public final String component1() {
            return this.emptyDesc;
        }

        public final SelectTribeeBottomSheetEmptyState copy(String str) {
            Intrinsics.checkNotNullParameter(str, "emptyDesc");
            return new SelectTribeeBottomSheetEmptyState(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SelectTribeeBottomSheetEmptyState) && Intrinsics.areEqual(this.emptyDesc, ((SelectTribeeBottomSheetEmptyState) obj).emptyDesc);
        }

        public int hashCode() {
            return this.emptyDesc.hashCode();
        }

        public String toString() {
            return "SelectTribeeBottomSheetEmptyState(emptyDesc=" + this.emptyDesc + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectTribeeBottomSheetEmptyState(String emptyDesc) {
            super(null);
            Intrinsics.checkNotNullParameter(emptyDesc, "emptyDesc");
            this.emptyDesc = emptyDesc;
        }

        public /* synthetic */ SelectTribeeBottomSheetEmptyState(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        public final String getEmptyDesc() {
            return this.emptyDesc;
        }
    }

    /* compiled from: SelectTribeeBottomSheetState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetState$SelectTribeeBottomSheetContentState;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetState;", "listState", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectTribeeListState;", "<init>", "(Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectTribeeListState;)V", "getListState", "()Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectTribeeListState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SelectTribeeBottomSheetContentState extends SelectTribeeBottomSheetState {
        public static final int $stable = 0;
        private final SelectTribeeListState listState;

        public SelectTribeeBottomSheetContentState() {
            this(null, 1, null);
        }

        public static /* synthetic */ SelectTribeeBottomSheetContentState copy$default(SelectTribeeBottomSheetContentState selectTribeeBottomSheetContentState, SelectTribeeListState selectTribeeListState, int i, Object obj) {
            if ((i & 1) != 0) {
                selectTribeeListState = selectTribeeBottomSheetContentState.listState;
            }
            return selectTribeeBottomSheetContentState.copy(selectTribeeListState);
        }

        public final SelectTribeeListState component1() {
            return this.listState;
        }

        public final SelectTribeeBottomSheetContentState copy(SelectTribeeListState selectTribeeListState) {
            Intrinsics.checkNotNullParameter(selectTribeeListState, "listState");
            return new SelectTribeeBottomSheetContentState(selectTribeeListState);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SelectTribeeBottomSheetContentState) && Intrinsics.areEqual(this.listState, ((SelectTribeeBottomSheetContentState) obj).listState);
        }

        public int hashCode() {
            return this.listState.hashCode();
        }

        public String toString() {
            return "SelectTribeeBottomSheetContentState(listState=" + this.listState + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectTribeeBottomSheetContentState(SelectTribeeListState listState) {
            super(null);
            Intrinsics.checkNotNullParameter(listState, "listState");
            this.listState = listState;
        }

        public /* synthetic */ SelectTribeeBottomSheetContentState(SelectTribeeListState selectTribeeListState, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new SelectTribeeListState(null, false, false, null, null, null, 63, null) : selectTribeeListState);
        }

        public final SelectTribeeListState getListState() {
            return this.listState;
        }
    }
}