package home.sidecenter.recent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecentAction.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\r\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u0082\u0001\r\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lhome/sidecenter/recent/IRecentAction;", "", "LoadData", "LoadDataSuccess", "LoadDataFailed", "ClickMineSelectionItem", "ClickDeleteHistory", "DeleteHistorySuccess", "DeleteHistoryFailed", "ClickDeleteToView", "DeleteToViewSuccess", "DeleteToViewFailed", "ClickDeleteFav", "DeleteFavSuccess", "DeleteFavFailed", "Lhome/sidecenter/recent/IRecentAction$ClickDeleteFav;", "Lhome/sidecenter/recent/IRecentAction$ClickDeleteHistory;", "Lhome/sidecenter/recent/IRecentAction$ClickDeleteToView;", "Lhome/sidecenter/recent/IRecentAction$ClickMineSelectionItem;", "Lhome/sidecenter/recent/IRecentAction$DeleteFavFailed;", "Lhome/sidecenter/recent/IRecentAction$DeleteFavSuccess;", "Lhome/sidecenter/recent/IRecentAction$DeleteHistoryFailed;", "Lhome/sidecenter/recent/IRecentAction$DeleteHistorySuccess;", "Lhome/sidecenter/recent/IRecentAction$DeleteToViewFailed;", "Lhome/sidecenter/recent/IRecentAction$DeleteToViewSuccess;", "Lhome/sidecenter/recent/IRecentAction$LoadData;", "Lhome/sidecenter/recent/IRecentAction$LoadDataFailed;", "Lhome/sidecenter/recent/IRecentAction$LoadDataSuccess;", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IRecentAction {

    /* compiled from: RecentAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lhome/sidecenter/recent/IRecentAction$LoadData;", "Lhome/sidecenter/recent/IRecentAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LoadData implements IRecentAction {
        public static final int $stable = 0;
        public static final LoadData INSTANCE = new LoadData();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadData) {
                LoadData loadData = (LoadData) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -714995452;
        }

        public String toString() {
            return "LoadData";
        }

        private LoadData() {
        }
    }

    /* compiled from: RecentAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/recent/IRecentAction$LoadDataSuccess;", "Lhome/sidecenter/recent/IRecentAction;", "state", "Lhome/sidecenter/recent/RecentPageState;", "<init>", "(Lhome/sidecenter/recent/RecentPageState;)V", "getState", "()Lhome/sidecenter/recent/RecentPageState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LoadDataSuccess implements IRecentAction {
        public static final int $stable = 8;
        private final RecentPageState state;

        public static /* synthetic */ LoadDataSuccess copy$default(LoadDataSuccess loadDataSuccess, RecentPageState recentPageState, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                recentPageState = loadDataSuccess.state;
            }
            return loadDataSuccess.copy(recentPageState);
        }

        public final RecentPageState component1() {
            return this.state;
        }

        public final LoadDataSuccess copy(RecentPageState recentPageState) {
            Intrinsics.checkNotNullParameter(recentPageState, "state");
            return new LoadDataSuccess(recentPageState);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoadDataSuccess) && Intrinsics.areEqual(this.state, ((LoadDataSuccess) obj).state);
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        public String toString() {
            return "LoadDataSuccess(state=" + this.state + ")";
        }

        public LoadDataSuccess(RecentPageState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }

        public final RecentPageState getState() {
            return this.state;
        }
    }

    /* compiled from: RecentAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/recent/IRecentAction$LoadDataFailed;", "Lhome/sidecenter/recent/IRecentAction;", "throwable", "", "<init>", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LoadDataFailed implements IRecentAction {
        public static final int $stable = 8;
        private final Throwable throwable;

        public static /* synthetic */ LoadDataFailed copy$default(LoadDataFailed loadDataFailed, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                th = loadDataFailed.throwable;
            }
            return loadDataFailed.copy(th);
        }

        public final Throwable component1() {
            return this.throwable;
        }

        public final LoadDataFailed copy(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "throwable");
            return new LoadDataFailed(th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoadDataFailed) && Intrinsics.areEqual(this.throwable, ((LoadDataFailed) obj).throwable);
        }

        public int hashCode() {
            return this.throwable.hashCode();
        }

        public String toString() {
            return "LoadDataFailed(throwable=" + this.throwable + ")";
        }

        public LoadDataFailed(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.throwable = throwable;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }

    /* compiled from: RecentAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/recent/IRecentAction$ClickMineSelectionItem;", "Lhome/sidecenter/recent/IRecentAction;", "item", "Lhome/sidecenter/recent/RecentIconItem;", "<init>", "(Lhome/sidecenter/recent/RecentIconItem;)V", "getItem", "()Lhome/sidecenter/recent/RecentIconItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ClickMineSelectionItem implements IRecentAction {
        public static final int $stable = 0;
        private final RecentIconItem item;

        public static /* synthetic */ ClickMineSelectionItem copy$default(ClickMineSelectionItem clickMineSelectionItem, RecentIconItem recentIconItem, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                recentIconItem = clickMineSelectionItem.item;
            }
            return clickMineSelectionItem.copy(recentIconItem);
        }

        public final RecentIconItem component1() {
            return this.item;
        }

        public final ClickMineSelectionItem copy(RecentIconItem recentIconItem) {
            Intrinsics.checkNotNullParameter(recentIconItem, "item");
            return new ClickMineSelectionItem(recentIconItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClickMineSelectionItem) && Intrinsics.areEqual(this.item, ((ClickMineSelectionItem) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "ClickMineSelectionItem(item=" + this.item + ")";
        }

        public ClickMineSelectionItem(RecentIconItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final RecentIconItem getItem() {
            return this.item;
        }
    }

    /* compiled from: RecentAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/recent/IRecentAction$ClickDeleteHistory;", "Lhome/sidecenter/recent/IRecentAction;", "item", "Lhome/sidecenter/recent/RecentVideoContent;", "<init>", "(Lhome/sidecenter/recent/RecentVideoContent;)V", "getItem", "()Lhome/sidecenter/recent/RecentVideoContent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ClickDeleteHistory implements IRecentAction {
        public static final int $stable = 8;
        private final RecentVideoContent item;

        public static /* synthetic */ ClickDeleteHistory copy$default(ClickDeleteHistory clickDeleteHistory, RecentVideoContent recentVideoContent, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                recentVideoContent = clickDeleteHistory.item;
            }
            return clickDeleteHistory.copy(recentVideoContent);
        }

        public final RecentVideoContent component1() {
            return this.item;
        }

        public final ClickDeleteHistory copy(RecentVideoContent recentVideoContent) {
            Intrinsics.checkNotNullParameter(recentVideoContent, "item");
            return new ClickDeleteHistory(recentVideoContent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClickDeleteHistory) && Intrinsics.areEqual(this.item, ((ClickDeleteHistory) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "ClickDeleteHistory(item=" + this.item + ")";
        }

        public ClickDeleteHistory(RecentVideoContent item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final RecentVideoContent getItem() {
            return this.item;
        }
    }

    /* compiled from: RecentAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/recent/IRecentAction$DeleteHistorySuccess;", "Lhome/sidecenter/recent/IRecentAction;", "item", "Lhome/sidecenter/recent/RecentVideoContent;", "<init>", "(Lhome/sidecenter/recent/RecentVideoContent;)V", "getItem", "()Lhome/sidecenter/recent/RecentVideoContent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DeleteHistorySuccess implements IRecentAction {
        public static final int $stable = 8;
        private final RecentVideoContent item;

        public static /* synthetic */ DeleteHistorySuccess copy$default(DeleteHistorySuccess deleteHistorySuccess, RecentVideoContent recentVideoContent, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                recentVideoContent = deleteHistorySuccess.item;
            }
            return deleteHistorySuccess.copy(recentVideoContent);
        }

        public final RecentVideoContent component1() {
            return this.item;
        }

        public final DeleteHistorySuccess copy(RecentVideoContent recentVideoContent) {
            Intrinsics.checkNotNullParameter(recentVideoContent, "item");
            return new DeleteHistorySuccess(recentVideoContent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeleteHistorySuccess) && Intrinsics.areEqual(this.item, ((DeleteHistorySuccess) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "DeleteHistorySuccess(item=" + this.item + ")";
        }

        public DeleteHistorySuccess(RecentVideoContent item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final RecentVideoContent getItem() {
            return this.item;
        }
    }

    /* compiled from: RecentAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lhome/sidecenter/recent/IRecentAction$DeleteHistoryFailed;", "Lhome/sidecenter/recent/IRecentAction;", "item", "Lhome/sidecenter/recent/RecentVideoContent;", "throwable", "", "<init>", "(Lhome/sidecenter/recent/RecentVideoContent;Ljava/lang/Throwable;)V", "getItem", "()Lhome/sidecenter/recent/RecentVideoContent;", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DeleteHistoryFailed implements IRecentAction {
        public static final int $stable = 8;
        private final RecentVideoContent item;
        private final Throwable throwable;

        public static /* synthetic */ DeleteHistoryFailed copy$default(DeleteHistoryFailed deleteHistoryFailed, RecentVideoContent recentVideoContent, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                recentVideoContent = deleteHistoryFailed.item;
            }
            if ((i2 & 2) != 0) {
                th = deleteHistoryFailed.throwable;
            }
            return deleteHistoryFailed.copy(recentVideoContent, th);
        }

        public final RecentVideoContent component1() {
            return this.item;
        }

        public final Throwable component2() {
            return this.throwable;
        }

        public final DeleteHistoryFailed copy(RecentVideoContent recentVideoContent, Throwable th) {
            Intrinsics.checkNotNullParameter(recentVideoContent, "item");
            Intrinsics.checkNotNullParameter(th, "throwable");
            return new DeleteHistoryFailed(recentVideoContent, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DeleteHistoryFailed) {
                DeleteHistoryFailed deleteHistoryFailed = (DeleteHistoryFailed) obj;
                return Intrinsics.areEqual(this.item, deleteHistoryFailed.item) && Intrinsics.areEqual(this.throwable, deleteHistoryFailed.throwable);
            }
            return false;
        }

        public int hashCode() {
            return (this.item.hashCode() * 31) + this.throwable.hashCode();
        }

        public String toString() {
            RecentVideoContent recentVideoContent = this.item;
            return "DeleteHistoryFailed(item=" + recentVideoContent + ", throwable=" + this.throwable + ")";
        }

        public DeleteHistoryFailed(RecentVideoContent item, Throwable throwable) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.item = item;
            this.throwable = throwable;
        }

        public final RecentVideoContent getItem() {
            return this.item;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }

    /* compiled from: RecentAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/recent/IRecentAction$ClickDeleteToView;", "Lhome/sidecenter/recent/IRecentAction;", "item", "Lhome/sidecenter/recent/RecentVideoContent;", "<init>", "(Lhome/sidecenter/recent/RecentVideoContent;)V", "getItem", "()Lhome/sidecenter/recent/RecentVideoContent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ClickDeleteToView implements IRecentAction {
        public static final int $stable = 8;
        private final RecentVideoContent item;

        public static /* synthetic */ ClickDeleteToView copy$default(ClickDeleteToView clickDeleteToView, RecentVideoContent recentVideoContent, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                recentVideoContent = clickDeleteToView.item;
            }
            return clickDeleteToView.copy(recentVideoContent);
        }

        public final RecentVideoContent component1() {
            return this.item;
        }

        public final ClickDeleteToView copy(RecentVideoContent recentVideoContent) {
            Intrinsics.checkNotNullParameter(recentVideoContent, "item");
            return new ClickDeleteToView(recentVideoContent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClickDeleteToView) && Intrinsics.areEqual(this.item, ((ClickDeleteToView) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "ClickDeleteToView(item=" + this.item + ")";
        }

        public ClickDeleteToView(RecentVideoContent item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final RecentVideoContent getItem() {
            return this.item;
        }
    }

    /* compiled from: RecentAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/recent/IRecentAction$DeleteToViewSuccess;", "Lhome/sidecenter/recent/IRecentAction;", "item", "Lhome/sidecenter/recent/RecentVideoContent;", "<init>", "(Lhome/sidecenter/recent/RecentVideoContent;)V", "getItem", "()Lhome/sidecenter/recent/RecentVideoContent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DeleteToViewSuccess implements IRecentAction {
        public static final int $stable = 8;
        private final RecentVideoContent item;

        public static /* synthetic */ DeleteToViewSuccess copy$default(DeleteToViewSuccess deleteToViewSuccess, RecentVideoContent recentVideoContent, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                recentVideoContent = deleteToViewSuccess.item;
            }
            return deleteToViewSuccess.copy(recentVideoContent);
        }

        public final RecentVideoContent component1() {
            return this.item;
        }

        public final DeleteToViewSuccess copy(RecentVideoContent recentVideoContent) {
            Intrinsics.checkNotNullParameter(recentVideoContent, "item");
            return new DeleteToViewSuccess(recentVideoContent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeleteToViewSuccess) && Intrinsics.areEqual(this.item, ((DeleteToViewSuccess) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "DeleteToViewSuccess(item=" + this.item + ")";
        }

        public DeleteToViewSuccess(RecentVideoContent item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final RecentVideoContent getItem() {
            return this.item;
        }
    }

    /* compiled from: RecentAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lhome/sidecenter/recent/IRecentAction$DeleteToViewFailed;", "Lhome/sidecenter/recent/IRecentAction;", "item", "Lhome/sidecenter/recent/RecentVideoContent;", "throwable", "", "<init>", "(Lhome/sidecenter/recent/RecentVideoContent;Ljava/lang/Throwable;)V", "getItem", "()Lhome/sidecenter/recent/RecentVideoContent;", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DeleteToViewFailed implements IRecentAction {
        public static final int $stable = 8;
        private final RecentVideoContent item;
        private final Throwable throwable;

        public static /* synthetic */ DeleteToViewFailed copy$default(DeleteToViewFailed deleteToViewFailed, RecentVideoContent recentVideoContent, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                recentVideoContent = deleteToViewFailed.item;
            }
            if ((i2 & 2) != 0) {
                th = deleteToViewFailed.throwable;
            }
            return deleteToViewFailed.copy(recentVideoContent, th);
        }

        public final RecentVideoContent component1() {
            return this.item;
        }

        public final Throwable component2() {
            return this.throwable;
        }

        public final DeleteToViewFailed copy(RecentVideoContent recentVideoContent, Throwable th) {
            Intrinsics.checkNotNullParameter(recentVideoContent, "item");
            Intrinsics.checkNotNullParameter(th, "throwable");
            return new DeleteToViewFailed(recentVideoContent, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DeleteToViewFailed) {
                DeleteToViewFailed deleteToViewFailed = (DeleteToViewFailed) obj;
                return Intrinsics.areEqual(this.item, deleteToViewFailed.item) && Intrinsics.areEqual(this.throwable, deleteToViewFailed.throwable);
            }
            return false;
        }

        public int hashCode() {
            return (this.item.hashCode() * 31) + this.throwable.hashCode();
        }

        public String toString() {
            RecentVideoContent recentVideoContent = this.item;
            return "DeleteToViewFailed(item=" + recentVideoContent + ", throwable=" + this.throwable + ")";
        }

        public DeleteToViewFailed(RecentVideoContent item, Throwable throwable) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.item = item;
            this.throwable = throwable;
        }

        public final RecentVideoContent getItem() {
            return this.item;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }

    /* compiled from: RecentAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/recent/IRecentAction$ClickDeleteFav;", "Lhome/sidecenter/recent/IRecentAction;", "item", "Lhome/sidecenter/recent/RecentFavContent;", "<init>", "(Lhome/sidecenter/recent/RecentFavContent;)V", "getItem", "()Lhome/sidecenter/recent/RecentFavContent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ClickDeleteFav implements IRecentAction {
        public static final int $stable = 8;
        private final RecentFavContent item;

        public static /* synthetic */ ClickDeleteFav copy$default(ClickDeleteFav clickDeleteFav, RecentFavContent recentFavContent, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                recentFavContent = clickDeleteFav.item;
            }
            return clickDeleteFav.copy(recentFavContent);
        }

        public final RecentFavContent component1() {
            return this.item;
        }

        public final ClickDeleteFav copy(RecentFavContent recentFavContent) {
            Intrinsics.checkNotNullParameter(recentFavContent, "item");
            return new ClickDeleteFav(recentFavContent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClickDeleteFav) && Intrinsics.areEqual(this.item, ((ClickDeleteFav) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "ClickDeleteFav(item=" + this.item + ")";
        }

        public ClickDeleteFav(RecentFavContent item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final RecentFavContent getItem() {
            return this.item;
        }
    }

    /* compiled from: RecentAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/recent/IRecentAction$DeleteFavSuccess;", "Lhome/sidecenter/recent/IRecentAction;", "item", "Lhome/sidecenter/recent/RecentFavContent;", "<init>", "(Lhome/sidecenter/recent/RecentFavContent;)V", "getItem", "()Lhome/sidecenter/recent/RecentFavContent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DeleteFavSuccess implements IRecentAction {
        public static final int $stable = 8;
        private final RecentFavContent item;

        public static /* synthetic */ DeleteFavSuccess copy$default(DeleteFavSuccess deleteFavSuccess, RecentFavContent recentFavContent, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                recentFavContent = deleteFavSuccess.item;
            }
            return deleteFavSuccess.copy(recentFavContent);
        }

        public final RecentFavContent component1() {
            return this.item;
        }

        public final DeleteFavSuccess copy(RecentFavContent recentFavContent) {
            Intrinsics.checkNotNullParameter(recentFavContent, "item");
            return new DeleteFavSuccess(recentFavContent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeleteFavSuccess) && Intrinsics.areEqual(this.item, ((DeleteFavSuccess) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "DeleteFavSuccess(item=" + this.item + ")";
        }

        public DeleteFavSuccess(RecentFavContent item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final RecentFavContent getItem() {
            return this.item;
        }
    }

    /* compiled from: RecentAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lhome/sidecenter/recent/IRecentAction$DeleteFavFailed;", "Lhome/sidecenter/recent/IRecentAction;", "item", "Lhome/sidecenter/recent/RecentFavContent;", "throwable", "", "<init>", "(Lhome/sidecenter/recent/RecentFavContent;Ljava/lang/Throwable;)V", "getItem", "()Lhome/sidecenter/recent/RecentFavContent;", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DeleteFavFailed implements IRecentAction {
        public static final int $stable = 8;
        private final RecentFavContent item;
        private final Throwable throwable;

        public static /* synthetic */ DeleteFavFailed copy$default(DeleteFavFailed deleteFavFailed, RecentFavContent recentFavContent, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                recentFavContent = deleteFavFailed.item;
            }
            if ((i2 & 2) != 0) {
                th = deleteFavFailed.throwable;
            }
            return deleteFavFailed.copy(recentFavContent, th);
        }

        public final RecentFavContent component1() {
            return this.item;
        }

        public final Throwable component2() {
            return this.throwable;
        }

        public final DeleteFavFailed copy(RecentFavContent recentFavContent, Throwable th) {
            Intrinsics.checkNotNullParameter(recentFavContent, "item");
            Intrinsics.checkNotNullParameter(th, "throwable");
            return new DeleteFavFailed(recentFavContent, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DeleteFavFailed) {
                DeleteFavFailed deleteFavFailed = (DeleteFavFailed) obj;
                return Intrinsics.areEqual(this.item, deleteFavFailed.item) && Intrinsics.areEqual(this.throwable, deleteFavFailed.throwable);
            }
            return false;
        }

        public int hashCode() {
            return (this.item.hashCode() * 31) + this.throwable.hashCode();
        }

        public String toString() {
            RecentFavContent recentFavContent = this.item;
            return "DeleteFavFailed(item=" + recentFavContent + ", throwable=" + this.throwable + ")";
        }

        public DeleteFavFailed(RecentFavContent item, Throwable throwable) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.item = item;
            this.throwable = throwable;
        }

        public final RecentFavContent getItem() {
            return this.item;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }
}