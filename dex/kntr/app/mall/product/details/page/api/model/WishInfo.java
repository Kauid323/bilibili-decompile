package kntr.app.mall.product.details.page.api.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WishInfo.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/WishInfo;", "", "active", "", "count", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getActive", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/WishInfo;", "equals", "other", "hashCode", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WishInfo {
    public static final int $stable = 0;
    private final Boolean active;
    private final Integer count;

    public WishInfo() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ WishInfo copy$default(WishInfo wishInfo, Boolean bool, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = wishInfo.active;
        }
        if ((i & 2) != 0) {
            num = wishInfo.count;
        }
        return wishInfo.copy(bool, num);
    }

    public final Boolean component1() {
        return this.active;
    }

    public final Integer component2() {
        return this.count;
    }

    public final WishInfo copy(Boolean bool, Integer num) {
        return new WishInfo(bool, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WishInfo) {
            WishInfo wishInfo = (WishInfo) obj;
            return Intrinsics.areEqual(this.active, wishInfo.active) && Intrinsics.areEqual(this.count, wishInfo.count);
        }
        return false;
    }

    public int hashCode() {
        return ((this.active == null ? 0 : this.active.hashCode()) * 31) + (this.count != null ? this.count.hashCode() : 0);
    }

    public String toString() {
        Boolean bool = this.active;
        return "WishInfo(active=" + bool + ", count=" + this.count + ")";
    }

    public WishInfo(Boolean active, Integer count) {
        this.active = active;
        this.count = count;
    }

    public /* synthetic */ WishInfo(Boolean bool, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : num);
    }

    public final Boolean getActive() {
        return this.active;
    }

    public final Integer getCount() {
        return this.count;
    }
}