package im.customer.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomerSettingAction.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0006\b\t\n\u000b\f\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lim/customer/settings/ICustomerSettingAction;", "", "LoadSetting", "LoadSettingSuccess", "LoadSettingFailed", "ClickSettingItem", "SettingItemSwitchSuccess", "SettingItemSwitchFailed", "Lim/customer/settings/ICustomerSettingAction$ClickSettingItem;", "Lim/customer/settings/ICustomerSettingAction$LoadSetting;", "Lim/customer/settings/ICustomerSettingAction$LoadSettingFailed;", "Lim/customer/settings/ICustomerSettingAction$LoadSettingSuccess;", "Lim/customer/settings/ICustomerSettingAction$SettingItemSwitchFailed;", "Lim/customer/settings/ICustomerSettingAction$SettingItemSwitchSuccess;", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ICustomerSettingAction {

    /* compiled from: CustomerSettingAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lim/customer/settings/ICustomerSettingAction$LoadSetting;", "Lim/customer/settings/ICustomerSettingAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LoadSetting implements ICustomerSettingAction {
        public static final LoadSetting INSTANCE = new LoadSetting();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadSetting) {
                LoadSetting loadSetting = (LoadSetting) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1317513792;
        }

        public String toString() {
            return "LoadSetting";
        }

        private LoadSetting() {
        }
    }

    /* compiled from: CustomerSettingAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/customer/settings/ICustomerSettingAction$LoadSettingSuccess;", "Lim/customer/settings/ICustomerSettingAction;", "settingState", "Lim/customer/settings/CustomerSettingState;", "<init>", "(Lim/customer/settings/CustomerSettingState;)V", "getSettingState", "()Lim/customer/settings/CustomerSettingState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LoadSettingSuccess implements ICustomerSettingAction {
        private final CustomerSettingState settingState;

        public static /* synthetic */ LoadSettingSuccess copy$default(LoadSettingSuccess loadSettingSuccess, CustomerSettingState customerSettingState, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                customerSettingState = loadSettingSuccess.settingState;
            }
            return loadSettingSuccess.copy(customerSettingState);
        }

        public final CustomerSettingState component1() {
            return this.settingState;
        }

        public final LoadSettingSuccess copy(CustomerSettingState customerSettingState) {
            Intrinsics.checkNotNullParameter(customerSettingState, "settingState");
            return new LoadSettingSuccess(customerSettingState);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoadSettingSuccess) && Intrinsics.areEqual(this.settingState, ((LoadSettingSuccess) obj).settingState);
        }

        public int hashCode() {
            return this.settingState.hashCode();
        }

        public String toString() {
            return "LoadSettingSuccess(settingState=" + this.settingState + ")";
        }

        public LoadSettingSuccess(CustomerSettingState settingState) {
            Intrinsics.checkNotNullParameter(settingState, "settingState");
            this.settingState = settingState;
        }

        public final CustomerSettingState getSettingState() {
            return this.settingState;
        }
    }

    /* compiled from: CustomerSettingAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/customer/settings/ICustomerSettingAction$LoadSettingFailed;", "Lim/customer/settings/ICustomerSettingAction;", "throwable", "", "<init>", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LoadSettingFailed implements ICustomerSettingAction {
        private final Throwable throwable;

        public static /* synthetic */ LoadSettingFailed copy$default(LoadSettingFailed loadSettingFailed, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                th = loadSettingFailed.throwable;
            }
            return loadSettingFailed.copy(th);
        }

        public final Throwable component1() {
            return this.throwable;
        }

        public final LoadSettingFailed copy(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "throwable");
            return new LoadSettingFailed(th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoadSettingFailed) && Intrinsics.areEqual(this.throwable, ((LoadSettingFailed) obj).throwable);
        }

        public int hashCode() {
            return this.throwable.hashCode();
        }

        public String toString() {
            return "LoadSettingFailed(throwable=" + this.throwable + ")";
        }

        public LoadSettingFailed(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.throwable = throwable;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }

    /* compiled from: CustomerSettingAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/customer/settings/ICustomerSettingAction$ClickSettingItem;", "Lim/customer/settings/ICustomerSettingAction;", "item", "Lim/customer/settings/CustomerSettingItem;", "<init>", "(Lim/customer/settings/CustomerSettingItem;)V", "getItem", "()Lim/customer/settings/CustomerSettingItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ClickSettingItem implements ICustomerSettingAction {
        private final CustomerSettingItem item;

        public static /* synthetic */ ClickSettingItem copy$default(ClickSettingItem clickSettingItem, CustomerSettingItem customerSettingItem, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                customerSettingItem = clickSettingItem.item;
            }
            return clickSettingItem.copy(customerSettingItem);
        }

        public final CustomerSettingItem component1() {
            return this.item;
        }

        public final ClickSettingItem copy(CustomerSettingItem customerSettingItem) {
            Intrinsics.checkNotNullParameter(customerSettingItem, "item");
            return new ClickSettingItem(customerSettingItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClickSettingItem) && Intrinsics.areEqual(this.item, ((ClickSettingItem) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "ClickSettingItem(item=" + this.item + ")";
        }

        public ClickSettingItem(CustomerSettingItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final CustomerSettingItem getItem() {
            return this.item;
        }
    }

    /* compiled from: CustomerSettingAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lim/customer/settings/ICustomerSettingAction$SettingItemSwitchSuccess;", "Lim/customer/settings/ICustomerSettingAction;", "item", "Lim/customer/settings/CustomerSettingItem;", "message", "", "<init>", "(Lim/customer/settings/CustomerSettingItem;Ljava/lang/String;)V", "getItem", "()Lim/customer/settings/CustomerSettingItem;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class SettingItemSwitchSuccess implements ICustomerSettingAction {
        private final CustomerSettingItem item;
        private final String message;

        public static /* synthetic */ SettingItemSwitchSuccess copy$default(SettingItemSwitchSuccess settingItemSwitchSuccess, CustomerSettingItem customerSettingItem, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                customerSettingItem = settingItemSwitchSuccess.item;
            }
            if ((i2 & 2) != 0) {
                str = settingItemSwitchSuccess.message;
            }
            return settingItemSwitchSuccess.copy(customerSettingItem, str);
        }

        public final CustomerSettingItem component1() {
            return this.item;
        }

        public final String component2() {
            return this.message;
        }

        public final SettingItemSwitchSuccess copy(CustomerSettingItem customerSettingItem, String str) {
            Intrinsics.checkNotNullParameter(customerSettingItem, "item");
            Intrinsics.checkNotNullParameter(str, "message");
            return new SettingItemSwitchSuccess(customerSettingItem, str);
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
            CustomerSettingItem customerSettingItem = this.item;
            return "SettingItemSwitchSuccess(item=" + customerSettingItem + ", message=" + this.message + ")";
        }

        public SettingItemSwitchSuccess(CustomerSettingItem item, String message) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(message, "message");
            this.item = item;
            this.message = message;
        }

        public /* synthetic */ SettingItemSwitchSuccess(CustomerSettingItem customerSettingItem, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(customerSettingItem, (i2 & 2) != 0 ? "" : str);
        }

        public final CustomerSettingItem getItem() {
            return this.item;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* compiled from: CustomerSettingAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lim/customer/settings/ICustomerSettingAction$SettingItemSwitchFailed;", "Lim/customer/settings/ICustomerSettingAction;", "item", "Lim/customer/settings/CustomerSettingItem;", "throwable", "", "<init>", "(Lim/customer/settings/CustomerSettingItem;Ljava/lang/Throwable;)V", "getItem", "()Lim/customer/settings/CustomerSettingItem;", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class SettingItemSwitchFailed implements ICustomerSettingAction {
        private final CustomerSettingItem item;
        private final Throwable throwable;

        public static /* synthetic */ SettingItemSwitchFailed copy$default(SettingItemSwitchFailed settingItemSwitchFailed, CustomerSettingItem customerSettingItem, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                customerSettingItem = settingItemSwitchFailed.item;
            }
            if ((i2 & 2) != 0) {
                th = settingItemSwitchFailed.throwable;
            }
            return settingItemSwitchFailed.copy(customerSettingItem, th);
        }

        public final CustomerSettingItem component1() {
            return this.item;
        }

        public final Throwable component2() {
            return this.throwable;
        }

        public final SettingItemSwitchFailed copy(CustomerSettingItem customerSettingItem, Throwable th) {
            Intrinsics.checkNotNullParameter(customerSettingItem, "item");
            Intrinsics.checkNotNullParameter(th, "throwable");
            return new SettingItemSwitchFailed(customerSettingItem, th);
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
            CustomerSettingItem customerSettingItem = this.item;
            return "SettingItemSwitchFailed(item=" + customerSettingItem + ", throwable=" + this.throwable + ")";
        }

        public SettingItemSwitchFailed(CustomerSettingItem item, Throwable throwable) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.item = item;
            this.throwable = throwable;
        }

        public final CustomerSettingItem getItem() {
            return this.item;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }
}