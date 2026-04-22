package im.customer.settings;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CustomerSettingState.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lim/customer/settings/CustomerSettingSwitchButton;", "Lim/customer/settings/ICustomerSettingButton;", "currentEnabled", "", "<init>", "(Z)V", "getCurrentEnabled$annotations", "()V", "getCurrentEnabled", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomerSettingSwitchButton implements ICustomerSettingButton {
    private final boolean currentEnabled;

    public CustomerSettingSwitchButton() {
        this(false, 1, null);
    }

    public static /* synthetic */ CustomerSettingSwitchButton copy$default(CustomerSettingSwitchButton customerSettingSwitchButton, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = customerSettingSwitchButton.currentEnabled;
        }
        return customerSettingSwitchButton.copy(z);
    }

    public static /* synthetic */ void getCurrentEnabled$annotations() {
    }

    public final boolean component1() {
        return this.currentEnabled;
    }

    public final CustomerSettingSwitchButton copy(boolean z) {
        return new CustomerSettingSwitchButton(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CustomerSettingSwitchButton) && this.currentEnabled == ((CustomerSettingSwitchButton) obj).currentEnabled;
    }

    public int hashCode() {
        return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.currentEnabled);
    }

    public String toString() {
        return "CustomerSettingSwitchButton(currentEnabled=" + this.currentEnabled + ")";
    }

    public CustomerSettingSwitchButton(boolean currentEnabled) {
        this.currentEnabled = currentEnabled;
    }

    public /* synthetic */ CustomerSettingSwitchButton(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z);
    }

    public final boolean getCurrentEnabled() {
        return this.currentEnabled;
    }
}