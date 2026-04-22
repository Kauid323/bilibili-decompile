package im.customer.settings;

import com.bapis.bilibili.im.customer.interfaces.KGetUserSettingsRsp;
import com.bilibili.blens.Lens;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomerSettingState.kt */
@Lens
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0001(B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB\u0019\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J7\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Lim/customer/settings/CustomerSettingState;", "", "shopId", "Lim/customer/settings/CustomerShopId;", "groups", "", "Lim/customer/settings/CustomerSettingGroup;", "status", "Lim/customer/settings/CustomerSettingPageStatus;", "toast", "Lim/customer/settings/ToastHolder;", "<init>", "(Lim/customer/settings/CustomerShopId;Ljava/util/List;Lim/customer/settings/CustomerSettingPageStatus;Lim/customer/settings/ToastHolder;)V", "resp", "Lcom/bapis/bilibili/im/customer/interfaces/KGetUserSettingsRsp;", "(Lcom/bapis/bilibili/im/customer/interfaces/KGetUserSettingsRsp;Lim/customer/settings/CustomerShopId;)V", "getShopId", "()Lim/customer/settings/CustomerShopId;", "getGroups", "()Ljava/util/List;", "getStatus", "()Lim/customer/settings/CustomerSettingPageStatus;", "getToast", "()Lim/customer/settings/ToastHolder;", "findSetting", "Lim/customer/settings/CustomerSettingItem;", "type", "Lim/customer/settings/CustomerSettingType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomerSettingState {
    public static final Companion Companion = new Companion(null);
    private final List<CustomerSettingGroup> groups;
    private final CustomerShopId shopId;
    private final CustomerSettingPageStatus status;
    private final ToastHolder toast;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomerSettingState copy$default(CustomerSettingState customerSettingState, CustomerShopId customerShopId, List list, CustomerSettingPageStatus customerSettingPageStatus, ToastHolder toastHolder, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            customerShopId = customerSettingState.shopId;
        }
        if ((i2 & 2) != 0) {
            list = customerSettingState.groups;
        }
        if ((i2 & 4) != 0) {
            customerSettingPageStatus = customerSettingState.status;
        }
        if ((i2 & 8) != 0) {
            toastHolder = customerSettingState.toast;
        }
        return customerSettingState.copy(customerShopId, list, customerSettingPageStatus, toastHolder);
    }

    public final CustomerShopId component1() {
        return this.shopId;
    }

    public final List<CustomerSettingGroup> component2() {
        return this.groups;
    }

    public final CustomerSettingPageStatus component3() {
        return this.status;
    }

    public final ToastHolder component4() {
        return this.toast;
    }

    public final CustomerSettingState copy(CustomerShopId customerShopId, List<CustomerSettingGroup> list, CustomerSettingPageStatus customerSettingPageStatus, ToastHolder toastHolder) {
        Intrinsics.checkNotNullParameter(customerShopId, "shopId");
        Intrinsics.checkNotNullParameter(list, "groups");
        Intrinsics.checkNotNullParameter(customerSettingPageStatus, "status");
        Intrinsics.checkNotNullParameter(toastHolder, "toast");
        return new CustomerSettingState(customerShopId, list, customerSettingPageStatus, toastHolder);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CustomerSettingState) {
            CustomerSettingState customerSettingState = (CustomerSettingState) obj;
            return Intrinsics.areEqual(this.shopId, customerSettingState.shopId) && Intrinsics.areEqual(this.groups, customerSettingState.groups) && this.status == customerSettingState.status && Intrinsics.areEqual(this.toast, customerSettingState.toast);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.shopId.hashCode() * 31) + this.groups.hashCode()) * 31) + this.status.hashCode()) * 31) + this.toast.hashCode();
    }

    public String toString() {
        CustomerShopId customerShopId = this.shopId;
        List<CustomerSettingGroup> list = this.groups;
        CustomerSettingPageStatus customerSettingPageStatus = this.status;
        return "CustomerSettingState(shopId=" + customerShopId + ", groups=" + list + ", status=" + customerSettingPageStatus + ", toast=" + this.toast + ")";
    }

    public CustomerSettingState(CustomerShopId shopId, List<CustomerSettingGroup> list, CustomerSettingPageStatus status, ToastHolder toast) {
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        Intrinsics.checkNotNullParameter(list, "groups");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(toast, "toast");
        this.shopId = shopId;
        this.groups = list;
        this.status = status;
        this.toast = toast;
    }

    public /* synthetic */ CustomerSettingState(CustomerShopId customerShopId, List list, CustomerSettingPageStatus customerSettingPageStatus, ToastHolder toastHolder, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(customerShopId, list, (i2 & 4) != 0 ? CustomerSettingPageStatus.Idle : customerSettingPageStatus, (i2 & 8) != 0 ? new ToastHolder(null, 0L, 3, null) : toastHolder);
    }

    public final CustomerShopId getShopId() {
        return this.shopId;
    }

    public final List<CustomerSettingGroup> getGroups() {
        return this.groups;
    }

    public final CustomerSettingPageStatus getStatus() {
        return this.status;
    }

    public final ToastHolder getToast() {
        return this.toast;
    }

    /* compiled from: CustomerSettingState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/customer/settings/CustomerSettingState$Companion;", "", "<init>", "()V", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomerSettingState(KGetUserSettingsRsp resp, CustomerShopId shopId) {
        this(shopId, CollectionsKt.listOf(new CustomerSettingGroup[]{new CustomerSettingGroup(1, CollectionsKt.listOf(new CustomerSettingItem[]{new CustomerSettingItem(1, CustomerSettingType.AcceptMsg, new CustomerSettingSwitchButton(resp.getEnableInitiativeMsg())), new CustomerSettingItem(1, CustomerSettingType.Dnd, new CustomerSettingSwitchButton(resp.getDoNotDisturb()))})), new CustomerSettingGroup(2, CollectionsKt.listOf(new CustomerSettingItem(2, CustomerSettingType.Report, new CustomerSettingRouteButton(resp.getReportUrl()))))}), CustomerSettingPageStatus.Success, null, 8, null);
        Intrinsics.checkNotNullParameter(resp, "resp");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
    }

    public final CustomerSettingItem findSetting(CustomerSettingType type) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(type, "type");
        Iterable $this$flatMap$iv = this.groups;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            CustomerSettingGroup it = (CustomerSettingGroup) element$iv$iv;
            Iterable list$iv$iv = it.getItems();
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        Iterator it2 = ((List) destination$iv$iv).iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            CustomerSettingItem it3 = (CustomerSettingItem) obj;
            if (it3.getType() == type) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        return (CustomerSettingItem) obj;
    }
}