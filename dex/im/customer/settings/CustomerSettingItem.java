package im.customer.settings;

import com.bilibili.blens.Lens;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomerSettingState.kt */
@Lens
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lim/customer/settings/CustomerSettingItem;", "", "groupId", "", "type", "Lim/customer/settings/CustomerSettingType;", "button", "Lim/customer/settings/ICustomerSettingButton;", "<init>", "(ILim/customer/settings/CustomerSettingType;Lim/customer/settings/ICustomerSettingButton;)V", "getGroupId", "()I", "getType", "()Lim/customer/settings/CustomerSettingType;", "getButton", "()Lim/customer/settings/ICustomerSettingButton;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomerSettingItem {
    public static final Companion Companion = new Companion(null);
    private final ICustomerSettingButton button;
    private final int groupId;
    private final CustomerSettingType type;

    public static /* synthetic */ CustomerSettingItem copy$default(CustomerSettingItem customerSettingItem, int i2, CustomerSettingType customerSettingType, ICustomerSettingButton iCustomerSettingButton, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = customerSettingItem.groupId;
        }
        if ((i3 & 2) != 0) {
            customerSettingType = customerSettingItem.type;
        }
        if ((i3 & 4) != 0) {
            iCustomerSettingButton = customerSettingItem.button;
        }
        return customerSettingItem.copy(i2, customerSettingType, iCustomerSettingButton);
    }

    public final int component1() {
        return this.groupId;
    }

    public final CustomerSettingType component2() {
        return this.type;
    }

    public final ICustomerSettingButton component3() {
        return this.button;
    }

    public final CustomerSettingItem copy(int i2, CustomerSettingType customerSettingType, ICustomerSettingButton iCustomerSettingButton) {
        Intrinsics.checkNotNullParameter(customerSettingType, "type");
        Intrinsics.checkNotNullParameter(iCustomerSettingButton, "button");
        return new CustomerSettingItem(i2, customerSettingType, iCustomerSettingButton);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CustomerSettingItem) {
            CustomerSettingItem customerSettingItem = (CustomerSettingItem) obj;
            return this.groupId == customerSettingItem.groupId && this.type == customerSettingItem.type && Intrinsics.areEqual(this.button, customerSettingItem.button);
        }
        return false;
    }

    public int hashCode() {
        return (((this.groupId * 31) + this.type.hashCode()) * 31) + this.button.hashCode();
    }

    public String toString() {
        int i2 = this.groupId;
        CustomerSettingType customerSettingType = this.type;
        return "CustomerSettingItem(groupId=" + i2 + ", type=" + customerSettingType + ", button=" + this.button + ")";
    }

    public CustomerSettingItem(int groupId, CustomerSettingType type, ICustomerSettingButton button) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(button, "button");
        this.groupId = groupId;
        this.type = type;
        this.button = button;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final CustomerSettingType getType() {
        return this.type;
    }

    public final ICustomerSettingButton getButton() {
        return this.button;
    }

    /* compiled from: CustomerSettingState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/customer/settings/CustomerSettingItem$Companion;", "", "<init>", "()V", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}