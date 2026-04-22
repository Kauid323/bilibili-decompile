package kntr.app.mall.product.details.page.kmm;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProductDetailsPageService.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u001cB)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J6\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageDataState;", "T", "", "pageStatus", "Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageDataState$ProductDetailsPageStatus;", "holdData", "errorMessage", "", "<init>", "(Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageDataState$ProductDetailsPageStatus;Ljava/lang/Object;Ljava/lang/String;)V", "getPageStatus", "()Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageDataState$ProductDetailsPageStatus;", "getHoldData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getErrorMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageDataState$ProductDetailsPageStatus;Ljava/lang/Object;Ljava/lang/String;)Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageDataState;", "equals", "", "other", "hashCode", "", "toString", "ProductDetailsPageStatus", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ProductDetailsPageDataState<T> {
    public static final int $stable = 0;
    private final String errorMessage;
    private final T holdData;
    private final ProductDetailsPageStatus pageStatus;

    /* compiled from: ProductDetailsPageService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageDataState$ProductDetailsPageStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "LOADING", "SUCCESS", "ERROR", "EMPTY", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public enum ProductDetailsPageStatus {
        NONE,
        LOADING,
        SUCCESS,
        ERROR,
        EMPTY;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<ProductDetailsPageStatus> getEntries() {
            return $ENTRIES;
        }
    }

    public ProductDetailsPageDataState() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductDetailsPageDataState copy$default(ProductDetailsPageDataState productDetailsPageDataState, ProductDetailsPageStatus productDetailsPageStatus, Object obj, String str, int i, Object obj2) {
        if ((i & 1) != 0) {
            productDetailsPageStatus = productDetailsPageDataState.pageStatus;
        }
        if ((i & 2) != 0) {
            obj = productDetailsPageDataState.holdData;
        }
        if ((i & 4) != 0) {
            str = productDetailsPageDataState.errorMessage;
        }
        return productDetailsPageDataState.copy(productDetailsPageStatus, obj, str);
    }

    public final ProductDetailsPageStatus component1() {
        return this.pageStatus;
    }

    public final T component2() {
        return this.holdData;
    }

    public final String component3() {
        return this.errorMessage;
    }

    public final ProductDetailsPageDataState<T> copy(ProductDetailsPageStatus productDetailsPageStatus, T t, String str) {
        Intrinsics.checkNotNullParameter(productDetailsPageStatus, "pageStatus");
        return new ProductDetailsPageDataState<>(productDetailsPageStatus, t, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProductDetailsPageDataState) {
            ProductDetailsPageDataState productDetailsPageDataState = (ProductDetailsPageDataState) obj;
            return this.pageStatus == productDetailsPageDataState.pageStatus && Intrinsics.areEqual(this.holdData, productDetailsPageDataState.holdData) && Intrinsics.areEqual(this.errorMessage, productDetailsPageDataState.errorMessage);
        }
        return false;
    }

    public int hashCode() {
        return (((this.pageStatus.hashCode() * 31) + (this.holdData == null ? 0 : this.holdData.hashCode())) * 31) + (this.errorMessage != null ? this.errorMessage.hashCode() : 0);
    }

    public String toString() {
        ProductDetailsPageStatus productDetailsPageStatus = this.pageStatus;
        T t = this.holdData;
        return "ProductDetailsPageDataState(pageStatus=" + productDetailsPageStatus + ", holdData=" + t + ", errorMessage=" + this.errorMessage + ")";
    }

    public ProductDetailsPageDataState(ProductDetailsPageStatus pageStatus, T t, String errorMessage) {
        Intrinsics.checkNotNullParameter(pageStatus, "pageStatus");
        this.pageStatus = pageStatus;
        this.holdData = t;
        this.errorMessage = errorMessage;
    }

    public /* synthetic */ ProductDetailsPageDataState(ProductDetailsPageStatus productDetailsPageStatus, Object obj, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ProductDetailsPageStatus.NONE : productDetailsPageStatus, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : str);
    }

    public final ProductDetailsPageStatus getPageStatus() {
        return this.pageStatus;
    }

    public final T getHoldData() {
        return this.holdData;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }
}