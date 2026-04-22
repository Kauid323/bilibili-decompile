package kntr.app.mall.product.details.page.ui.components;

import BottomSheetItemData$;
import kntr.app.mall.product.details.page.api.CouponListResponse;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityCouponSheetComponent.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lkntr/app/mall/product/details/page/ui/components/MergedCouponItem;", "", "couponItem", "Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;", "isDetailNetPrice", "", "<init>", "(Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;Z)V", "getCouponItem", "()Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MergedCouponItem {
    public static final int $stable = 8;
    private final CouponListResponse.CouponListItem couponItem;
    private final boolean isDetailNetPrice;

    public static /* synthetic */ MergedCouponItem copy$default(MergedCouponItem mergedCouponItem, CouponListResponse.CouponListItem couponListItem, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            couponListItem = mergedCouponItem.couponItem;
        }
        if ((i & 2) != 0) {
            z = mergedCouponItem.isDetailNetPrice;
        }
        return mergedCouponItem.copy(couponListItem, z);
    }

    public final CouponListResponse.CouponListItem component1() {
        return this.couponItem;
    }

    public final boolean component2() {
        return this.isDetailNetPrice;
    }

    public final MergedCouponItem copy(CouponListResponse.CouponListItem couponListItem, boolean z) {
        Intrinsics.checkNotNullParameter(couponListItem, "couponItem");
        return new MergedCouponItem(couponListItem, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MergedCouponItem) {
            MergedCouponItem mergedCouponItem = (MergedCouponItem) obj;
            return Intrinsics.areEqual(this.couponItem, mergedCouponItem.couponItem) && this.isDetailNetPrice == mergedCouponItem.isDetailNetPrice;
        }
        return false;
    }

    public int hashCode() {
        return (this.couponItem.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isDetailNetPrice);
    }

    public String toString() {
        CouponListResponse.CouponListItem couponListItem = this.couponItem;
        return "MergedCouponItem(couponItem=" + couponListItem + ", isDetailNetPrice=" + this.isDetailNetPrice + ")";
    }

    public MergedCouponItem(CouponListResponse.CouponListItem couponItem, boolean isDetailNetPrice) {
        Intrinsics.checkNotNullParameter(couponItem, "couponItem");
        this.couponItem = couponItem;
        this.isDetailNetPrice = isDetailNetPrice;
    }

    public final CouponListResponse.CouponListItem getCouponItem() {
        return this.couponItem;
    }

    public final boolean isDetailNetPrice() {
        return this.isDetailNetPrice;
    }
}