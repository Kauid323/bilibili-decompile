package home.sidecenter.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SideCenterSettingsAction.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\u0082\u0001\b\n\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lhome/sidecenter/settings/ISideCenterSettingsAction;", "", "LoadData", "LoadDataSuccess", "LoadDataFailed", "CheckSettingItem", "SettingItemSwitchSuccess", "SettingItemSwitchFailed", "CheckedMineTabToastShow", "CheckedMineTabToastDismiss", "Lhome/sidecenter/settings/ISideCenterSettingsAction$CheckSettingItem;", "Lhome/sidecenter/settings/ISideCenterSettingsAction$CheckedMineTabToastDismiss;", "Lhome/sidecenter/settings/ISideCenterSettingsAction$CheckedMineTabToastShow;", "Lhome/sidecenter/settings/ISideCenterSettingsAction$LoadData;", "Lhome/sidecenter/settings/ISideCenterSettingsAction$LoadDataFailed;", "Lhome/sidecenter/settings/ISideCenterSettingsAction$LoadDataSuccess;", "Lhome/sidecenter/settings/ISideCenterSettingsAction$SettingItemSwitchFailed;", "Lhome/sidecenter/settings/ISideCenterSettingsAction$SettingItemSwitchSuccess;", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ISideCenterSettingsAction {

    /* compiled from: SideCenterSettingsAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lhome/sidecenter/settings/ISideCenterSettingsAction$LoadData;", "Lhome/sidecenter/settings/ISideCenterSettingsAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LoadData implements ISideCenterSettingsAction {
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
            return -172163192;
        }

        public String toString() {
            return "LoadData";
        }

        private LoadData() {
        }
    }

    /* compiled from: SideCenterSettingsAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/settings/ISideCenterSettingsAction$LoadDataSuccess;", "Lhome/sidecenter/settings/ISideCenterSettingsAction;", "state", "Lhome/sidecenter/settings/SideCenterSettingsState;", "<init>", "(Lhome/sidecenter/settings/SideCenterSettingsState;)V", "getState", "()Lhome/sidecenter/settings/SideCenterSettingsState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LoadDataSuccess implements ISideCenterSettingsAction {
        public static final int $stable = 8;
        private final SideCenterSettingsState state;

        public static /* synthetic */ LoadDataSuccess copy$default(LoadDataSuccess loadDataSuccess, SideCenterSettingsState sideCenterSettingsState, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                sideCenterSettingsState = loadDataSuccess.state;
            }
            return loadDataSuccess.copy(sideCenterSettingsState);
        }

        public final SideCenterSettingsState component1() {
            return this.state;
        }

        public final LoadDataSuccess copy(SideCenterSettingsState sideCenterSettingsState) {
            Intrinsics.checkNotNullParameter(sideCenterSettingsState, "state");
            return new LoadDataSuccess(sideCenterSettingsState);
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

        public LoadDataSuccess(SideCenterSettingsState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }

        public final SideCenterSettingsState getState() {
            return this.state;
        }
    }

    /* compiled from: SideCenterSettingsAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/settings/ISideCenterSettingsAction$LoadDataFailed;", "Lhome/sidecenter/settings/ISideCenterSettingsAction;", "throwable", "", "<init>", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LoadDataFailed implements ISideCenterSettingsAction {
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

    /* compiled from: SideCenterSettingsAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lhome/sidecenter/settings/ISideCenterSettingsAction$CheckSettingItem;", "Lhome/sidecenter/settings/ISideCenterSettingsAction;", "item", "Lhome/sidecenter/settings/ISideCenterSettingItem;", "<init>", "(Lhome/sidecenter/settings/ISideCenterSettingItem;)V", "getItem", "()Lhome/sidecenter/settings/ISideCenterSettingItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class CheckSettingItem implements ISideCenterSettingsAction {
        public static final int $stable = 8;
        private final ISideCenterSettingItem item;

        public static /* synthetic */ CheckSettingItem copy$default(CheckSettingItem checkSettingItem, ISideCenterSettingItem iSideCenterSettingItem, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                iSideCenterSettingItem = checkSettingItem.item;
            }
            return checkSettingItem.copy(iSideCenterSettingItem);
        }

        public final ISideCenterSettingItem component1() {
            return this.item;
        }

        public final CheckSettingItem copy(ISideCenterSettingItem iSideCenterSettingItem) {
            Intrinsics.checkNotNullParameter(iSideCenterSettingItem, "item");
            return new CheckSettingItem(iSideCenterSettingItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CheckSettingItem) && Intrinsics.areEqual(this.item, ((CheckSettingItem) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "CheckSettingItem(item=" + this.item + ")";
        }

        public CheckSettingItem(ISideCenterSettingItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final ISideCenterSettingItem getItem() {
            return this.item;
        }
    }

    /* compiled from: SideCenterSettingsAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lhome/sidecenter/settings/ISideCenterSettingsAction$SettingItemSwitchSuccess;", "Lhome/sidecenter/settings/ISideCenterSettingsAction;", "item", "Lhome/sidecenter/settings/ISideCenterSettingItem;", "message", "", "<init>", "(Lhome/sidecenter/settings/ISideCenterSettingItem;Ljava/lang/String;)V", "getItem", "()Lhome/sidecenter/settings/ISideCenterSettingItem;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class SettingItemSwitchSuccess implements ISideCenterSettingsAction {
        public static final int $stable = 8;
        private final ISideCenterSettingItem item;
        private final String message;

        public static /* synthetic */ SettingItemSwitchSuccess copy$default(SettingItemSwitchSuccess settingItemSwitchSuccess, ISideCenterSettingItem iSideCenterSettingItem, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                iSideCenterSettingItem = settingItemSwitchSuccess.item;
            }
            if ((i2 & 2) != 0) {
                str = settingItemSwitchSuccess.message;
            }
            return settingItemSwitchSuccess.copy(iSideCenterSettingItem, str);
        }

        public final ISideCenterSettingItem component1() {
            return this.item;
        }

        public final String component2() {
            return this.message;
        }

        public final SettingItemSwitchSuccess copy(ISideCenterSettingItem iSideCenterSettingItem, String str) {
            Intrinsics.checkNotNullParameter(iSideCenterSettingItem, "item");
            Intrinsics.checkNotNullParameter(str, "message");
            return new SettingItemSwitchSuccess(iSideCenterSettingItem, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SettingItemSwitchSuccess) {
                SettingItemSwitchSuccess settingItemSwitchSuccess = (SettingItemSwitchSuccess) obj;
                return Intrinsics.areEqual(this.item, settingItemSwitchSuccess.item) && Intrinsics.areEqual(this.message, settingItemSwitchSuccess.message);
            }
            return false;
        }

        public int hashCode() {
            return (this.item.hashCode() * 31) + this.message.hashCode();
        }

        public String toString() {
            ISideCenterSettingItem iSideCenterSettingItem = this.item;
            return "SettingItemSwitchSuccess(item=" + iSideCenterSettingItem + ", message=" + this.message + ")";
        }

        public SettingItemSwitchSuccess(ISideCenterSettingItem item, String message) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(message, "message");
            this.item = item;
            this.message = message;
        }

        public /* synthetic */ SettingItemSwitchSuccess(ISideCenterSettingItem iSideCenterSettingItem, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(iSideCenterSettingItem, (i2 & 2) != 0 ? "" : str);
        }

        public final ISideCenterSettingItem getItem() {
            return this.item;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* compiled from: SideCenterSettingsAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lhome/sidecenter/settings/ISideCenterSettingsAction$SettingItemSwitchFailed;", "Lhome/sidecenter/settings/ISideCenterSettingsAction;", "item", "Lhome/sidecenter/settings/ISideCenterSettingItem;", "throwable", "", "<init>", "(Lhome/sidecenter/settings/ISideCenterSettingItem;Ljava/lang/Throwable;)V", "getItem", "()Lhome/sidecenter/settings/ISideCenterSettingItem;", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class SettingItemSwitchFailed implements ISideCenterSettingsAction {
        public static final int $stable = 8;
        private final ISideCenterSettingItem item;
        private final Throwable throwable;

        public static /* synthetic */ SettingItemSwitchFailed copy$default(SettingItemSwitchFailed settingItemSwitchFailed, ISideCenterSettingItem iSideCenterSettingItem, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                iSideCenterSettingItem = settingItemSwitchFailed.item;
            }
            if ((i2 & 2) != 0) {
                th = settingItemSwitchFailed.throwable;
            }
            return settingItemSwitchFailed.copy(iSideCenterSettingItem, th);
        }

        public final ISideCenterSettingItem component1() {
            return this.item;
        }

        public final Throwable component2() {
            return this.throwable;
        }

        public final SettingItemSwitchFailed copy(ISideCenterSettingItem iSideCenterSettingItem, Throwable th) {
            Intrinsics.checkNotNullParameter(iSideCenterSettingItem, "item");
            Intrinsics.checkNotNullParameter(th, "throwable");
            return new SettingItemSwitchFailed(iSideCenterSettingItem, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SettingItemSwitchFailed) {
                SettingItemSwitchFailed settingItemSwitchFailed = (SettingItemSwitchFailed) obj;
                return Intrinsics.areEqual(this.item, settingItemSwitchFailed.item) && Intrinsics.areEqual(this.throwable, settingItemSwitchFailed.throwable);
            }
            return false;
        }

        public int hashCode() {
            return (this.item.hashCode() * 31) + this.throwable.hashCode();
        }

        public String toString() {
            ISideCenterSettingItem iSideCenterSettingItem = this.item;
            return "SettingItemSwitchFailed(item=" + iSideCenterSettingItem + ", throwable=" + this.throwable + ")";
        }

        public SettingItemSwitchFailed(ISideCenterSettingItem item, Throwable throwable) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.item = item;
            this.throwable = throwable;
        }

        public final ISideCenterSettingItem getItem() {
            return this.item;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }

    /* compiled from: SideCenterSettingsAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lhome/sidecenter/settings/ISideCenterSettingsAction$CheckedMineTabToastShow;", "Lhome/sidecenter/settings/ISideCenterSettingsAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class CheckedMineTabToastShow implements ISideCenterSettingsAction {
        public static final int $stable = 0;
        public static final CheckedMineTabToastShow INSTANCE = new CheckedMineTabToastShow();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CheckedMineTabToastShow) {
                CheckedMineTabToastShow checkedMineTabToastShow = (CheckedMineTabToastShow) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 956196497;
        }

        public String toString() {
            return "CheckedMineTabToastShow";
        }

        private CheckedMineTabToastShow() {
        }
    }

    /* compiled from: SideCenterSettingsAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lhome/sidecenter/settings/ISideCenterSettingsAction$CheckedMineTabToastDismiss;", "Lhome/sidecenter/settings/ISideCenterSettingsAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class CheckedMineTabToastDismiss implements ISideCenterSettingsAction {
        public static final int $stable = 0;
        public static final CheckedMineTabToastDismiss INSTANCE = new CheckedMineTabToastDismiss();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CheckedMineTabToastDismiss) {
                CheckedMineTabToastDismiss checkedMineTabToastDismiss = (CheckedMineTabToastDismiss) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1431211638;
        }

        public String toString() {
            return "CheckedMineTabToastDismiss";
        }

        private CheckedMineTabToastDismiss() {
        }
    }
}