package im.customer.settings;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;

/* compiled from: CustomerSettingState.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\f¨\u0006\u0016"}, d2 = {"Lim/customer/settings/CustomerShopId;", "", "shopId", "", "shopFatherId", "<init>", "(JJ)V", "getShopId", "()J", "getShopFatherId", "isOperatorShop", "", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "customer_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomerShopId {
    private final boolean isOperatorShop;
    private final long shopFatherId;
    private final long shopId;

    public static /* synthetic */ CustomerShopId copy$default(CustomerShopId customerShopId, long j, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = customerShopId.shopId;
        }
        if ((i2 & 2) != 0) {
            j2 = customerShopId.shopFatherId;
        }
        return customerShopId.copy(j, j2);
    }

    public final long component1() {
        return this.shopId;
    }

    public final long component2() {
        return this.shopFatherId;
    }

    public final CustomerShopId copy(long j, long j2) {
        return new CustomerShopId(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CustomerShopId) {
            CustomerShopId customerShopId = (CustomerShopId) obj;
            return this.shopId == customerShopId.shopId && this.shopFatherId == customerShopId.shopFatherId;
        }
        return false;
    }

    public int hashCode() {
        return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.shopId) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.shopFatherId);
    }

    public String toString() {
        long j = this.shopId;
        return "CustomerShopId(shopId=" + j + ", shopFatherId=" + this.shopFatherId + ")";
    }

    public CustomerShopId(long shopId, long shopFatherId) {
        this.shopId = shopId;
        this.shopFatherId = shopFatherId;
        this.isOperatorShop = this.shopFatherId == 3;
    }

    public final long getShopId() {
        return this.shopId;
    }

    public final long getShopFatherId() {
        return this.shopFatherId;
    }

    public final boolean isOperatorShop() {
        return this.isOperatorShop;
    }
}