package home.sidecenter.selection;

import home.sidecenter.recent.RecentIconItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SideCenterSelectionAction.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\u0082\u0001\b\n\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lhome/sidecenter/selection/ISideCenterSelectionAction;", "", "LoadData", "LoadDataSuccess", "LoadDataFailed", "ClickSelectedItem", "ClickOptionItem", "UpdateSelectedItem", "UpdateSelectedItemSuccess", "UpdateSelectedItemFailed", "Lhome/sidecenter/selection/ISideCenterSelectionAction$ClickOptionItem;", "Lhome/sidecenter/selection/ISideCenterSelectionAction$ClickSelectedItem;", "Lhome/sidecenter/selection/ISideCenterSelectionAction$LoadData;", "Lhome/sidecenter/selection/ISideCenterSelectionAction$LoadDataFailed;", "Lhome/sidecenter/selection/ISideCenterSelectionAction$LoadDataSuccess;", "Lhome/sidecenter/selection/ISideCenterSelectionAction$UpdateSelectedItem;", "Lhome/sidecenter/selection/ISideCenterSelectionAction$UpdateSelectedItemFailed;", "Lhome/sidecenter/selection/ISideCenterSelectionAction$UpdateSelectedItemSuccess;", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ISideCenterSelectionAction {

    /* compiled from: SideCenterSelectionAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lhome/sidecenter/selection/ISideCenterSelectionAction$LoadData;", "Lhome/sidecenter/selection/ISideCenterSelectionAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LoadData implements ISideCenterSelectionAction {
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
            return 1039288060;
        }

        public String toString() {
            return "LoadData";
        }

        private LoadData() {
        }
    }

    /* compiled from: SideCenterSelectionAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/selection/ISideCenterSelectionAction$LoadDataSuccess;", "Lhome/sidecenter/selection/ISideCenterSelectionAction;", "state", "Lhome/sidecenter/selection/SideCenterSelectionState;", "<init>", "(Lhome/sidecenter/selection/SideCenterSelectionState;)V", "getState", "()Lhome/sidecenter/selection/SideCenterSelectionState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LoadDataSuccess implements ISideCenterSelectionAction {
        public static final int $stable = 8;
        private final SideCenterSelectionState state;

        public static /* synthetic */ LoadDataSuccess copy$default(LoadDataSuccess loadDataSuccess, SideCenterSelectionState sideCenterSelectionState, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                sideCenterSelectionState = loadDataSuccess.state;
            }
            return loadDataSuccess.copy(sideCenterSelectionState);
        }

        public final SideCenterSelectionState component1() {
            return this.state;
        }

        public final LoadDataSuccess copy(SideCenterSelectionState sideCenterSelectionState) {
            Intrinsics.checkNotNullParameter(sideCenterSelectionState, "state");
            return new LoadDataSuccess(sideCenterSelectionState);
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

        public LoadDataSuccess(SideCenterSelectionState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }

        public final SideCenterSelectionState getState() {
            return this.state;
        }
    }

    /* compiled from: SideCenterSelectionAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/selection/ISideCenterSelectionAction$LoadDataFailed;", "Lhome/sidecenter/selection/ISideCenterSelectionAction;", "throwable", "", "<init>", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LoadDataFailed implements ISideCenterSelectionAction {
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
            return new LoadDataFailed(th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoadDataFailed) && Intrinsics.areEqual(this.throwable, ((LoadDataFailed) obj).throwable);
        }

        public int hashCode() {
            if (this.throwable == null) {
                return 0;
            }
            return this.throwable.hashCode();
        }

        public String toString() {
            return "LoadDataFailed(throwable=" + this.throwable + ")";
        }

        public LoadDataFailed(Throwable throwable) {
            this.throwable = throwable;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }

    /* compiled from: SideCenterSelectionAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/selection/ISideCenterSelectionAction$ClickSelectedItem;", "Lhome/sidecenter/selection/ISideCenterSelectionAction;", "item", "Lhome/sidecenter/recent/RecentIconItem;", "<init>", "(Lhome/sidecenter/recent/RecentIconItem;)V", "getItem", "()Lhome/sidecenter/recent/RecentIconItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ClickSelectedItem implements ISideCenterSelectionAction {
        public static final int $stable = 0;
        private final RecentIconItem item;

        public static /* synthetic */ ClickSelectedItem copy$default(ClickSelectedItem clickSelectedItem, RecentIconItem recentIconItem, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                recentIconItem = clickSelectedItem.item;
            }
            return clickSelectedItem.copy(recentIconItem);
        }

        public final RecentIconItem component1() {
            return this.item;
        }

        public final ClickSelectedItem copy(RecentIconItem recentIconItem) {
            Intrinsics.checkNotNullParameter(recentIconItem, "item");
            return new ClickSelectedItem(recentIconItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClickSelectedItem) && Intrinsics.areEqual(this.item, ((ClickSelectedItem) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "ClickSelectedItem(item=" + this.item + ")";
        }

        public ClickSelectedItem(RecentIconItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final RecentIconItem getItem() {
            return this.item;
        }
    }

    /* compiled from: SideCenterSelectionAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/selection/ISideCenterSelectionAction$ClickOptionItem;", "Lhome/sidecenter/selection/ISideCenterSelectionAction;", "item", "Lhome/sidecenter/recent/RecentIconItem;", "<init>", "(Lhome/sidecenter/recent/RecentIconItem;)V", "getItem", "()Lhome/sidecenter/recent/RecentIconItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ClickOptionItem implements ISideCenterSelectionAction {
        public static final int $stable = 0;
        private final RecentIconItem item;

        public static /* synthetic */ ClickOptionItem copy$default(ClickOptionItem clickOptionItem, RecentIconItem recentIconItem, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                recentIconItem = clickOptionItem.item;
            }
            return clickOptionItem.copy(recentIconItem);
        }

        public final RecentIconItem component1() {
            return this.item;
        }

        public final ClickOptionItem copy(RecentIconItem recentIconItem) {
            Intrinsics.checkNotNullParameter(recentIconItem, "item");
            return new ClickOptionItem(recentIconItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClickOptionItem) && Intrinsics.areEqual(this.item, ((ClickOptionItem) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "ClickOptionItem(item=" + this.item + ")";
        }

        public ClickOptionItem(RecentIconItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final RecentIconItem getItem() {
            return this.item;
        }
    }

    /* compiled from: SideCenterSelectionAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lhome/sidecenter/selection/ISideCenterSelectionAction$UpdateSelectedItem;", "Lhome/sidecenter/selection/ISideCenterSelectionAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class UpdateSelectedItem implements ISideCenterSelectionAction {
        public static final int $stable = 0;
        public static final UpdateSelectedItem INSTANCE = new UpdateSelectedItem();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UpdateSelectedItem) {
                UpdateSelectedItem updateSelectedItem = (UpdateSelectedItem) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1341155837;
        }

        public String toString() {
            return "UpdateSelectedItem";
        }

        private UpdateSelectedItem() {
        }
    }

    /* compiled from: SideCenterSelectionAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lhome/sidecenter/selection/ISideCenterSelectionAction$UpdateSelectedItemSuccess;", "Lhome/sidecenter/selection/ISideCenterSelectionAction;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class UpdateSelectedItemSuccess implements ISideCenterSelectionAction {
        public static final int $stable = 0;
        private final String message;

        public UpdateSelectedItemSuccess() {
            this(null, 1, null);
        }

        public static /* synthetic */ UpdateSelectedItemSuccess copy$default(UpdateSelectedItemSuccess updateSelectedItemSuccess, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = updateSelectedItemSuccess.message;
            }
            return updateSelectedItemSuccess.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final UpdateSelectedItemSuccess copy(String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new UpdateSelectedItemSuccess(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateSelectedItemSuccess) && Intrinsics.areEqual(this.message, ((UpdateSelectedItemSuccess) obj).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "UpdateSelectedItemSuccess(message=" + this.message + ")";
        }

        public UpdateSelectedItemSuccess(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ UpdateSelectedItemSuccess(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str);
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* compiled from: SideCenterSelectionAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/selection/ISideCenterSelectionAction$UpdateSelectedItemFailed;", "Lhome/sidecenter/selection/ISideCenterSelectionAction;", "throwable", "", "<init>", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class UpdateSelectedItemFailed implements ISideCenterSelectionAction {
        public static final int $stable = 8;
        private final Throwable throwable;

        public static /* synthetic */ UpdateSelectedItemFailed copy$default(UpdateSelectedItemFailed updateSelectedItemFailed, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                th = updateSelectedItemFailed.throwable;
            }
            return updateSelectedItemFailed.copy(th);
        }

        public final Throwable component1() {
            return this.throwable;
        }

        public final UpdateSelectedItemFailed copy(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "throwable");
            return new UpdateSelectedItemFailed(th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateSelectedItemFailed) && Intrinsics.areEqual(this.throwable, ((UpdateSelectedItemFailed) obj).throwable);
        }

        public int hashCode() {
            return this.throwable.hashCode();
        }

        public String toString() {
            return "UpdateSelectedItemFailed(throwable=" + this.throwable + ")";
        }

        public UpdateSelectedItemFailed(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.throwable = throwable;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }
}