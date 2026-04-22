package im.customer.settings;

import com.bilibili.blens.Lens;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomerSettingState.kt */
@Lens
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lim/customer/settings/CustomerSettingGroup;", "", "groupId", "", "items", "", "Lim/customer/settings/CustomerSettingItem;", "<init>", "(ILjava/util/List;)V", "getGroupId", "()I", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomerSettingGroup {
    public static final Companion Companion = new Companion(null);
    private final int groupId;
    private final List<CustomerSettingItem> items;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomerSettingGroup copy$default(CustomerSettingGroup customerSettingGroup, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = customerSettingGroup.groupId;
        }
        if ((i3 & 2) != 0) {
            list = customerSettingGroup.items;
        }
        return customerSettingGroup.copy(i2, list);
    }

    public final int component1() {
        return this.groupId;
    }

    public final List<CustomerSettingItem> component2() {
        return this.items;
    }

    public final CustomerSettingGroup copy(int i2, List<CustomerSettingItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new CustomerSettingGroup(i2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CustomerSettingGroup) {
            CustomerSettingGroup customerSettingGroup = (CustomerSettingGroup) obj;
            return this.groupId == customerSettingGroup.groupId && Intrinsics.areEqual(this.items, customerSettingGroup.items);
        }
        return false;
    }

    public int hashCode() {
        return (this.groupId * 31) + this.items.hashCode();
    }

    public String toString() {
        int i2 = this.groupId;
        return "CustomerSettingGroup(groupId=" + i2 + ", items=" + this.items + ")";
    }

    public CustomerSettingGroup(int groupId, List<CustomerSettingItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.groupId = groupId;
        this.items = list;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final List<CustomerSettingItem> getItems() {
        return this.items;
    }

    /* compiled from: CustomerSettingState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/customer/settings/CustomerSettingGroup$Companion;", "", "<init>", "()V", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}