package kntr.app.mall.product.details.page.vm;

import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.mall.product.details.page.api.ProductShopApiService;
import kntr.app.mall.product.details.page.api.model.ActivityInfoFloor;
import kntr.app.mall.product.details.page.api.model.AdvStateFloor;
import kntr.app.mall.product.details.page.api.model.AtmospherePriceFloor;
import kntr.app.mall.product.details.page.api.model.AttrFloor;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.mall.product.details.page.api.model.CommentFloor;
import kntr.app.mall.product.details.page.api.model.CouponInfoFloor;
import kntr.app.mall.product.details.page.api.model.CourseInfoFloor;
import kntr.app.mall.product.details.page.api.model.CrowdfundingAtmosFloor;
import kntr.app.mall.product.details.page.api.model.CrowdfundingProgressFloor;
import kntr.app.mall.product.details.page.api.model.CrowdfundingStairsFloor;
import kntr.app.mall.product.details.page.api.model.DeliveryInfoFloor;
import kntr.app.mall.product.details.page.api.model.DetailDescFloor;
import kntr.app.mall.product.details.page.api.model.FileInfoFloor;
import kntr.app.mall.product.details.page.api.model.FooterFloor;
import kntr.app.mall.product.details.page.api.model.HeaderFloor;
import kntr.app.mall.product.details.page.api.model.IpBrandFloor;
import kntr.app.mall.product.details.page.api.model.MergeAtmospherePriceFloor;
import kntr.app.mall.product.details.page.api.model.RecFloor;
import kntr.app.mall.product.details.page.api.model.SeriesFloor;
import kntr.app.mall.product.details.page.api.model.ServiceDescFloor;
import kntr.app.mall.product.details.page.api.model.ServiceFloor;
import kntr.app.mall.product.details.page.api.model.ShopInfoFloor;
import kntr.app.mall.product.details.page.api.model.SkuInfoFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentModule.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0019\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0019!\"#$%&'()*+,-./0123456789¨\u0006:"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule;", "", "<init>", "()V", "floorType", "Lkntr/app/mall/product/details/page/vm/FloorType;", "getFloorType", "()Lkntr/app/mall/product/details/page/vm/FloorType;", "HeaderModule", "BasicInfoModule", "AtmospherePriceModule", "CouponInfoModule", "ActivityInfoModule", "AdvStateModule", "AttrModule", "CommentModule", "ShopModule", "ShopInfoModule", "DeliveryInfoModule", "ServiceModule", "SkuInfoModule", "FileInfoModule", "CourseInfoModule", "DetailDescModule", "ServiceDescModule", "FooterModule", "IpBrandModule", "MergeAtmospherePriceModule", "SeriesModule", "RecModule", "CrowdfundingAtmosModule", "CrowdfundingProgressModule", "CrowdfundingStairsModule", "Lkntr/app/mall/product/details/page/vm/ContentModule$ActivityInfoModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$AdvStateModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$AtmospherePriceModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$AttrModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$BasicInfoModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$CommentModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$CouponInfoModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$CourseInfoModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$CrowdfundingAtmosModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$CrowdfundingProgressModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$CrowdfundingStairsModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$DeliveryInfoModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$DetailDescModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$FileInfoModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$FooterModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$HeaderModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$IpBrandModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$MergeAtmospherePriceModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$RecModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$SeriesModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$ServiceDescModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$ServiceModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$ShopInfoModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$ShopModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule$SkuInfoModule;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class ContentModule {
    public static final int $stable = 0;

    public /* synthetic */ ContentModule(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ContentModule() {
    }

    public final FloorType getFloorType() {
        if (this instanceof HeaderModule) {
            return FloorType.HEADER;
        }
        if (this instanceof BasicInfoModule) {
            return FloorType.BASIC_INFO;
        }
        if (this instanceof AtmospherePriceModule) {
            return FloorType.ATMOSPHERE_PRICE;
        }
        if (this instanceof CouponInfoModule) {
            return FloorType.COUPON_INFO;
        }
        if (this instanceof ActivityInfoModule) {
            return FloorType.ACTIVITY_INFO;
        }
        if (this instanceof AdvStateModule) {
            return FloorType.ADV_STATE;
        }
        if (this instanceof AttrModule) {
            return FloorType.ATTR;
        }
        if (this instanceof CommentModule) {
            return FloorType.COMMENT;
        }
        if (this instanceof ShopModule) {
            return FloorType.SHOP;
        }
        if (this instanceof ShopInfoModule) {
            return FloorType.SHOP_INFO;
        }
        if (this instanceof DeliveryInfoModule) {
            return FloorType.DELIVERY_INFO;
        }
        if (this instanceof ServiceModule) {
            return FloorType.SERVICE;
        }
        if (this instanceof SkuInfoModule) {
            return FloorType.SKU_INFO;
        }
        if (this instanceof FileInfoModule) {
            return FloorType.FILE_INFO;
        }
        if (this instanceof CourseInfoModule) {
            return FloorType.COURSE_INFO;
        }
        if (this instanceof DetailDescModule) {
            return FloorType.DETAIL_DESC;
        }
        if (this instanceof ServiceDescModule) {
            return FloorType.SERVICE_DESC;
        }
        if (this instanceof FooterModule) {
            return FloorType.FOOTER;
        }
        if (this instanceof IpBrandModule) {
            return FloorType.IP_BRAND;
        }
        if (this instanceof MergeAtmospherePriceModule) {
            return FloorType.MERGE_ATMOSPHERE_PRICE;
        }
        if (this instanceof SeriesModule) {
            return FloorType.SERIES;
        }
        if (this instanceof RecModule) {
            return FloorType.REC;
        }
        if (this instanceof CrowdfundingAtmosModule) {
            return FloorType.CROWDFUNDING_ATMOSPHERE;
        }
        if (this instanceof CrowdfundingProgressModule) {
            return FloorType.CROWDFUNDING_PROGRESS;
        }
        if (this instanceof CrowdfundingStairsModule) {
            return FloorType.CROWDFUNDING_STAIRS;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$HeaderModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/HeaderFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/HeaderFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/HeaderFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class HeaderModule extends ContentModule {
        public static final int $stable = 8;
        private final HeaderFloor data;

        public static /* synthetic */ HeaderModule copy$default(HeaderModule headerModule, HeaderFloor headerFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                headerFloor = headerModule.data;
            }
            return headerModule.copy(headerFloor);
        }

        public final HeaderFloor component1() {
            return this.data;
        }

        public final HeaderModule copy(HeaderFloor headerFloor) {
            Intrinsics.checkNotNullParameter(headerFloor, "data");
            return new HeaderModule(headerFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HeaderModule) && Intrinsics.areEqual(this.data, ((HeaderModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "HeaderModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderModule(HeaderFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final HeaderFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$BasicInfoModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class BasicInfoModule extends ContentModule {
        public static final int $stable = 8;
        private final BasicInfoFloor data;

        public static /* synthetic */ BasicInfoModule copy$default(BasicInfoModule basicInfoModule, BasicInfoFloor basicInfoFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                basicInfoFloor = basicInfoModule.data;
            }
            return basicInfoModule.copy(basicInfoFloor);
        }

        public final BasicInfoFloor component1() {
            return this.data;
        }

        public final BasicInfoModule copy(BasicInfoFloor basicInfoFloor) {
            Intrinsics.checkNotNullParameter(basicInfoFloor, "data");
            return new BasicInfoModule(basicInfoFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BasicInfoModule) && Intrinsics.areEqual(this.data, ((BasicInfoModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "BasicInfoModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BasicInfoModule(BasicInfoFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final BasicInfoFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$AtmospherePriceModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/AtmospherePriceFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/AtmospherePriceFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/AtmospherePriceFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AtmospherePriceModule extends ContentModule {
        public static final int $stable = 0;
        private final AtmospherePriceFloor data;

        public static /* synthetic */ AtmospherePriceModule copy$default(AtmospherePriceModule atmospherePriceModule, AtmospherePriceFloor atmospherePriceFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                atmospherePriceFloor = atmospherePriceModule.data;
            }
            return atmospherePriceModule.copy(atmospherePriceFloor);
        }

        public final AtmospherePriceFloor component1() {
            return this.data;
        }

        public final AtmospherePriceModule copy(AtmospherePriceFloor atmospherePriceFloor) {
            Intrinsics.checkNotNullParameter(atmospherePriceFloor, "data");
            return new AtmospherePriceModule(atmospherePriceFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AtmospherePriceModule) && Intrinsics.areEqual(this.data, ((AtmospherePriceModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "AtmospherePriceModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AtmospherePriceModule(AtmospherePriceFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final AtmospherePriceFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$CouponInfoModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CouponInfoModule extends ContentModule {
        public static final int $stable = 8;
        private final CouponInfoFloor data;

        public static /* synthetic */ CouponInfoModule copy$default(CouponInfoModule couponInfoModule, CouponInfoFloor couponInfoFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                couponInfoFloor = couponInfoModule.data;
            }
            return couponInfoModule.copy(couponInfoFloor);
        }

        public final CouponInfoFloor component1() {
            return this.data;
        }

        public final CouponInfoModule copy(CouponInfoFloor couponInfoFloor) {
            Intrinsics.checkNotNullParameter(couponInfoFloor, "data");
            return new CouponInfoModule(couponInfoFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CouponInfoModule) && Intrinsics.areEqual(this.data, ((CouponInfoModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "CouponInfoModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CouponInfoModule(CouponInfoFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final CouponInfoFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$ActivityInfoModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ActivityInfoModule extends ContentModule {
        public static final int $stable = 8;
        private final ActivityInfoFloor data;

        public static /* synthetic */ ActivityInfoModule copy$default(ActivityInfoModule activityInfoModule, ActivityInfoFloor activityInfoFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                activityInfoFloor = activityInfoModule.data;
            }
            return activityInfoModule.copy(activityInfoFloor);
        }

        public final ActivityInfoFloor component1() {
            return this.data;
        }

        public final ActivityInfoModule copy(ActivityInfoFloor activityInfoFloor) {
            Intrinsics.checkNotNullParameter(activityInfoFloor, "data");
            return new ActivityInfoModule(activityInfoFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ActivityInfoModule) && Intrinsics.areEqual(this.data, ((ActivityInfoModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "ActivityInfoModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActivityInfoModule(ActivityInfoFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final ActivityInfoFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$AdvStateModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/AdvStateFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/AdvStateFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/AdvStateFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AdvStateModule extends ContentModule {
        public static final int $stable = 8;
        private final AdvStateFloor data;

        public static /* synthetic */ AdvStateModule copy$default(AdvStateModule advStateModule, AdvStateFloor advStateFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                advStateFloor = advStateModule.data;
            }
            return advStateModule.copy(advStateFloor);
        }

        public final AdvStateFloor component1() {
            return this.data;
        }

        public final AdvStateModule copy(AdvStateFloor advStateFloor) {
            Intrinsics.checkNotNullParameter(advStateFloor, "data");
            return new AdvStateModule(advStateFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AdvStateModule) && Intrinsics.areEqual(this.data, ((AdvStateModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "AdvStateModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AdvStateModule(AdvStateFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final AdvStateFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$AttrModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/AttrFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/AttrFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/AttrFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AttrModule extends ContentModule {
        public static final int $stable = 8;
        private final AttrFloor data;

        public static /* synthetic */ AttrModule copy$default(AttrModule attrModule, AttrFloor attrFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                attrFloor = attrModule.data;
            }
            return attrModule.copy(attrFloor);
        }

        public final AttrFloor component1() {
            return this.data;
        }

        public final AttrModule copy(AttrFloor attrFloor) {
            Intrinsics.checkNotNullParameter(attrFloor, "data");
            return new AttrModule(attrFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AttrModule) && Intrinsics.areEqual(this.data, ((AttrModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "AttrModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AttrModule(AttrFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final AttrFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$CommentModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "commentApiData", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData;", "productApiData", "Lkntr/app/mall/product/details/page/api/model/CommentFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData;Lkntr/app/mall/product/details/page/api/model/CommentFloor;)V", "getCommentApiData", "()Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData;", "getProductApiData", "()Lkntr/app/mall/product/details/page/api/model/CommentFloor;", "shouldAddCommentModule", "", "shouldAddCommentModule$product_details_page_debug", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CommentModule extends ContentModule {
        public static final int $stable = 8;
        private final CommentInfoApiService.CommentInfoResponse.CommentInfoData commentApiData;
        private final CommentFloor productApiData;

        public static /* synthetic */ CommentModule copy$default(CommentModule commentModule, CommentInfoApiService.CommentInfoResponse.CommentInfoData commentInfoData, CommentFloor commentFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                commentInfoData = commentModule.commentApiData;
            }
            if ((i & 2) != 0) {
                commentFloor = commentModule.productApiData;
            }
            return commentModule.copy(commentInfoData, commentFloor);
        }

        public final CommentInfoApiService.CommentInfoResponse.CommentInfoData component1() {
            return this.commentApiData;
        }

        public final CommentFloor component2() {
            return this.productApiData;
        }

        public final CommentModule copy(CommentInfoApiService.CommentInfoResponse.CommentInfoData commentInfoData, CommentFloor commentFloor) {
            return new CommentModule(commentInfoData, commentFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CommentModule) {
                CommentModule commentModule = (CommentModule) obj;
                return Intrinsics.areEqual(this.commentApiData, commentModule.commentApiData) && Intrinsics.areEqual(this.productApiData, commentModule.productApiData);
            }
            return false;
        }

        public int hashCode() {
            return ((this.commentApiData == null ? 0 : this.commentApiData.hashCode()) * 31) + (this.productApiData != null ? this.productApiData.hashCode() : 0);
        }

        public String toString() {
            CommentInfoApiService.CommentInfoResponse.CommentInfoData commentInfoData = this.commentApiData;
            return "CommentModule(commentApiData=" + commentInfoData + ", productApiData=" + this.productApiData + ")";
        }

        public CommentModule(CommentInfoApiService.CommentInfoResponse.CommentInfoData commentApiData, CommentFloor productApiData) {
            super(null);
            this.commentApiData = commentApiData;
            this.productApiData = productApiData;
        }

        public final CommentInfoApiService.CommentInfoResponse.CommentInfoData getCommentApiData() {
            return this.commentApiData;
        }

        public final CommentFloor getProductApiData() {
            return this.productApiData;
        }

        public final boolean shouldAddCommentModule$product_details_page_debug() {
            CommentFloor commentFloor = this.productApiData;
            if (commentFloor != null ? Intrinsics.areEqual(commentFloor.getShowPreBuyComment(), true) : false) {
                return true;
            }
            CommentInfoApiService.CommentInfoResponse.CommentInfoData commentInfoData = this.commentApiData;
            return commentInfoData != null && commentInfoData.shouldShowComment$product_details_page_debug();
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$ShopModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse$ProductShopDetailsData;", "<init>", "(Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse$ProductShopDetailsData;)V", "getData", "()Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse$ProductShopDetailsData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShopModule extends ContentModule {
        public static final int $stable = 8;
        private final ProductShopApiService.ProductShopDetailsResponse.ProductShopDetailsData data;

        public static /* synthetic */ ShopModule copy$default(ShopModule shopModule, ProductShopApiService.ProductShopDetailsResponse.ProductShopDetailsData productShopDetailsData, int i, Object obj) {
            if ((i & 1) != 0) {
                productShopDetailsData = shopModule.data;
            }
            return shopModule.copy(productShopDetailsData);
        }

        public final ProductShopApiService.ProductShopDetailsResponse.ProductShopDetailsData component1() {
            return this.data;
        }

        public final ShopModule copy(ProductShopApiService.ProductShopDetailsResponse.ProductShopDetailsData productShopDetailsData) {
            Intrinsics.checkNotNullParameter(productShopDetailsData, "data");
            return new ShopModule(productShopDetailsData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShopModule) && Intrinsics.areEqual(this.data, ((ShopModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "ShopModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShopModule(ProductShopApiService.ProductShopDetailsResponse.ProductShopDetailsData data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final ProductShopApiService.ProductShopDetailsResponse.ProductShopDetailsData getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$ShopInfoModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShopInfoModule extends ContentModule {
        public static final int $stable = 8;
        private final ShopInfoFloor data;

        public static /* synthetic */ ShopInfoModule copy$default(ShopInfoModule shopInfoModule, ShopInfoFloor shopInfoFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                shopInfoFloor = shopInfoModule.data;
            }
            return shopInfoModule.copy(shopInfoFloor);
        }

        public final ShopInfoFloor component1() {
            return this.data;
        }

        public final ShopInfoModule copy(ShopInfoFloor shopInfoFloor) {
            Intrinsics.checkNotNullParameter(shopInfoFloor, "data");
            return new ShopInfoModule(shopInfoFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShopInfoModule) && Intrinsics.areEqual(this.data, ((ShopInfoModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "ShopInfoModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShopInfoModule(ShopInfoFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final ShopInfoFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$DeliveryInfoModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DeliveryInfoModule extends ContentModule {
        public static final int $stable = 8;
        private final DeliveryInfoFloor data;

        public static /* synthetic */ DeliveryInfoModule copy$default(DeliveryInfoModule deliveryInfoModule, DeliveryInfoFloor deliveryInfoFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                deliveryInfoFloor = deliveryInfoModule.data;
            }
            return deliveryInfoModule.copy(deliveryInfoFloor);
        }

        public final DeliveryInfoFloor component1() {
            return this.data;
        }

        public final DeliveryInfoModule copy(DeliveryInfoFloor deliveryInfoFloor) {
            Intrinsics.checkNotNullParameter(deliveryInfoFloor, "data");
            return new DeliveryInfoModule(deliveryInfoFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeliveryInfoModule) && Intrinsics.areEqual(this.data, ((DeliveryInfoModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "DeliveryInfoModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeliveryInfoModule(DeliveryInfoFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final DeliveryInfoFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$ServiceModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/ServiceFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/ServiceFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/ServiceFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ServiceModule extends ContentModule {
        public static final int $stable = 8;
        private final ServiceFloor data;

        public static /* synthetic */ ServiceModule copy$default(ServiceModule serviceModule, ServiceFloor serviceFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                serviceFloor = serviceModule.data;
            }
            return serviceModule.copy(serviceFloor);
        }

        public final ServiceFloor component1() {
            return this.data;
        }

        public final ServiceModule copy(ServiceFloor serviceFloor) {
            Intrinsics.checkNotNullParameter(serviceFloor, "data");
            return new ServiceModule(serviceFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ServiceModule) && Intrinsics.areEqual(this.data, ((ServiceModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "ServiceModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ServiceModule(ServiceFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final ServiceFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$SkuInfoModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SkuInfoModule extends ContentModule {
        public static final int $stable = 8;
        private final SkuInfoFloor data;

        public static /* synthetic */ SkuInfoModule copy$default(SkuInfoModule skuInfoModule, SkuInfoFloor skuInfoFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                skuInfoFloor = skuInfoModule.data;
            }
            return skuInfoModule.copy(skuInfoFloor);
        }

        public final SkuInfoFloor component1() {
            return this.data;
        }

        public final SkuInfoModule copy(SkuInfoFloor skuInfoFloor) {
            Intrinsics.checkNotNullParameter(skuInfoFloor, "data");
            return new SkuInfoModule(skuInfoFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SkuInfoModule) && Intrinsics.areEqual(this.data, ((SkuInfoModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "SkuInfoModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SkuInfoModule(SkuInfoFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final SkuInfoFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$FileInfoModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/FileInfoFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/FileInfoFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/FileInfoFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class FileInfoModule extends ContentModule {
        public static final int $stable = 8;
        private final FileInfoFloor data;

        public static /* synthetic */ FileInfoModule copy$default(FileInfoModule fileInfoModule, FileInfoFloor fileInfoFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                fileInfoFloor = fileInfoModule.data;
            }
            return fileInfoModule.copy(fileInfoFloor);
        }

        public final FileInfoFloor component1() {
            return this.data;
        }

        public final FileInfoModule copy(FileInfoFloor fileInfoFloor) {
            Intrinsics.checkNotNullParameter(fileInfoFloor, "data");
            return new FileInfoModule(fileInfoFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FileInfoModule) && Intrinsics.areEqual(this.data, ((FileInfoModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "FileInfoModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FileInfoModule(FileInfoFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final FileInfoFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$CourseInfoModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/CourseInfoFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CourseInfoModule extends ContentModule {
        public static final int $stable = 8;
        private final CourseInfoFloor data;

        public static /* synthetic */ CourseInfoModule copy$default(CourseInfoModule courseInfoModule, CourseInfoFloor courseInfoFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                courseInfoFloor = courseInfoModule.data;
            }
            return courseInfoModule.copy(courseInfoFloor);
        }

        public final CourseInfoFloor component1() {
            return this.data;
        }

        public final CourseInfoModule copy(CourseInfoFloor courseInfoFloor) {
            Intrinsics.checkNotNullParameter(courseInfoFloor, "data");
            return new CourseInfoModule(courseInfoFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CourseInfoModule) && Intrinsics.areEqual(this.data, ((CourseInfoModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "CourseInfoModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CourseInfoModule(CourseInfoFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final CourseInfoFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$DetailDescModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/DetailDescFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/DetailDescFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/DetailDescFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DetailDescModule extends ContentModule {
        public static final int $stable = 8;
        private final DetailDescFloor data;

        public static /* synthetic */ DetailDescModule copy$default(DetailDescModule detailDescModule, DetailDescFloor detailDescFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                detailDescFloor = detailDescModule.data;
            }
            return detailDescModule.copy(detailDescFloor);
        }

        public final DetailDescFloor component1() {
            return this.data;
        }

        public final DetailDescModule copy(DetailDescFloor detailDescFloor) {
            Intrinsics.checkNotNullParameter(detailDescFloor, "data");
            return new DetailDescModule(detailDescFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DetailDescModule) && Intrinsics.areEqual(this.data, ((DetailDescModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "DetailDescModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DetailDescModule(DetailDescFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final DetailDescFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$ServiceDescModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/ServiceDescFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/ServiceDescFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/ServiceDescFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ServiceDescModule extends ContentModule {
        public static final int $stable = 8;
        private final ServiceDescFloor data;

        public static /* synthetic */ ServiceDescModule copy$default(ServiceDescModule serviceDescModule, ServiceDescFloor serviceDescFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                serviceDescFloor = serviceDescModule.data;
            }
            return serviceDescModule.copy(serviceDescFloor);
        }

        public final ServiceDescFloor component1() {
            return this.data;
        }

        public final ServiceDescModule copy(ServiceDescFloor serviceDescFloor) {
            Intrinsics.checkNotNullParameter(serviceDescFloor, "data");
            return new ServiceDescModule(serviceDescFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ServiceDescModule) && Intrinsics.areEqual(this.data, ((ServiceDescModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "ServiceDescModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ServiceDescModule(ServiceDescFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final ServiceDescFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$FooterModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/FooterFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/FooterFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/FooterFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class FooterModule extends ContentModule {
        public static final int $stable = 8;
        private final FooterFloor data;

        public static /* synthetic */ FooterModule copy$default(FooterModule footerModule, FooterFloor footerFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                footerFloor = footerModule.data;
            }
            return footerModule.copy(footerFloor);
        }

        public final FooterFloor component1() {
            return this.data;
        }

        public final FooterModule copy(FooterFloor footerFloor) {
            Intrinsics.checkNotNullParameter(footerFloor, "data");
            return new FooterModule(footerFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FooterModule) && Intrinsics.areEqual(this.data, ((FooterModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "FooterModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FooterModule(FooterFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final FooterFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$IpBrandModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/IpBrandFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/IpBrandFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/IpBrandFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class IpBrandModule extends ContentModule {
        public static final int $stable = 8;
        private final IpBrandFloor data;

        public static /* synthetic */ IpBrandModule copy$default(IpBrandModule ipBrandModule, IpBrandFloor ipBrandFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                ipBrandFloor = ipBrandModule.data;
            }
            return ipBrandModule.copy(ipBrandFloor);
        }

        public final IpBrandFloor component1() {
            return this.data;
        }

        public final IpBrandModule copy(IpBrandFloor ipBrandFloor) {
            Intrinsics.checkNotNullParameter(ipBrandFloor, "data");
            return new IpBrandModule(ipBrandFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IpBrandModule) && Intrinsics.areEqual(this.data, ((IpBrandModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "IpBrandModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IpBrandModule(IpBrandFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final IpBrandFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$MergeAtmospherePriceModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class MergeAtmospherePriceModule extends ContentModule {
        public static final int $stable = 8;
        private final MergeAtmospherePriceFloor data;

        public static /* synthetic */ MergeAtmospherePriceModule copy$default(MergeAtmospherePriceModule mergeAtmospherePriceModule, MergeAtmospherePriceFloor mergeAtmospherePriceFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                mergeAtmospherePriceFloor = mergeAtmospherePriceModule.data;
            }
            return mergeAtmospherePriceModule.copy(mergeAtmospherePriceFloor);
        }

        public final MergeAtmospherePriceFloor component1() {
            return this.data;
        }

        public final MergeAtmospherePriceModule copy(MergeAtmospherePriceFloor mergeAtmospherePriceFloor) {
            Intrinsics.checkNotNullParameter(mergeAtmospherePriceFloor, "data");
            return new MergeAtmospherePriceModule(mergeAtmospherePriceFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MergeAtmospherePriceModule) && Intrinsics.areEqual(this.data, ((MergeAtmospherePriceModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "MergeAtmospherePriceModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MergeAtmospherePriceModule(MergeAtmospherePriceFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final MergeAtmospherePriceFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$SeriesModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/SeriesFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/SeriesFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/SeriesFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SeriesModule extends ContentModule {
        public static final int $stable = 8;
        private final SeriesFloor data;

        public static /* synthetic */ SeriesModule copy$default(SeriesModule seriesModule, SeriesFloor seriesFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                seriesFloor = seriesModule.data;
            }
            return seriesModule.copy(seriesFloor);
        }

        public final SeriesFloor component1() {
            return this.data;
        }

        public final SeriesModule copy(SeriesFloor seriesFloor) {
            Intrinsics.checkNotNullParameter(seriesFloor, "data");
            return new SeriesModule(seriesFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SeriesModule) && Intrinsics.areEqual(this.data, ((SeriesModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "SeriesModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SeriesModule(SeriesFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final SeriesFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$RecModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/RecFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/RecFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/RecFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RecModule extends ContentModule {
        public static final int $stable = 8;
        private final RecFloor data;

        public static /* synthetic */ RecModule copy$default(RecModule recModule, RecFloor recFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                recFloor = recModule.data;
            }
            return recModule.copy(recFloor);
        }

        public final RecFloor component1() {
            return this.data;
        }

        public final RecModule copy(RecFloor recFloor) {
            Intrinsics.checkNotNullParameter(recFloor, "data");
            return new RecModule(recFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RecModule) && Intrinsics.areEqual(this.data, ((RecModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "RecModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecModule(RecFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final RecFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$CrowdfundingAtmosModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingAtmosFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/CrowdfundingAtmosFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/CrowdfundingAtmosFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CrowdfundingAtmosModule extends ContentModule {
        public static final int $stable = 0;
        private final CrowdfundingAtmosFloor data;

        public static /* synthetic */ CrowdfundingAtmosModule copy$default(CrowdfundingAtmosModule crowdfundingAtmosModule, CrowdfundingAtmosFloor crowdfundingAtmosFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                crowdfundingAtmosFloor = crowdfundingAtmosModule.data;
            }
            return crowdfundingAtmosModule.copy(crowdfundingAtmosFloor);
        }

        public final CrowdfundingAtmosFloor component1() {
            return this.data;
        }

        public final CrowdfundingAtmosModule copy(CrowdfundingAtmosFloor crowdfundingAtmosFloor) {
            Intrinsics.checkNotNullParameter(crowdfundingAtmosFloor, "data");
            return new CrowdfundingAtmosModule(crowdfundingAtmosFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CrowdfundingAtmosModule) && Intrinsics.areEqual(this.data, ((CrowdfundingAtmosModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "CrowdfundingAtmosModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CrowdfundingAtmosModule(CrowdfundingAtmosFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final CrowdfundingAtmosFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$CrowdfundingProgressModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CrowdfundingProgressModule extends ContentModule {
        public static final int $stable = 8;
        private final CrowdfundingProgressFloor data;

        public static /* synthetic */ CrowdfundingProgressModule copy$default(CrowdfundingProgressModule crowdfundingProgressModule, CrowdfundingProgressFloor crowdfundingProgressFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                crowdfundingProgressFloor = crowdfundingProgressModule.data;
            }
            return crowdfundingProgressModule.copy(crowdfundingProgressFloor);
        }

        public final CrowdfundingProgressFloor component1() {
            return this.data;
        }

        public final CrowdfundingProgressModule copy(CrowdfundingProgressFloor crowdfundingProgressFloor) {
            Intrinsics.checkNotNullParameter(crowdfundingProgressFloor, "data");
            return new CrowdfundingProgressModule(crowdfundingProgressFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CrowdfundingProgressModule) && Intrinsics.areEqual(this.data, ((CrowdfundingProgressModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "CrowdfundingProgressModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CrowdfundingProgressModule(CrowdfundingProgressFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final CrowdfundingProgressFloor getData() {
            return this.data;
        }
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ContentModule$CrowdfundingStairsModule;", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "data", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor;)V", "getData", "()Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CrowdfundingStairsModule extends ContentModule {
        public static final int $stable = 8;
        private final CrowdfundingStairsFloor data;

        public static /* synthetic */ CrowdfundingStairsModule copy$default(CrowdfundingStairsModule crowdfundingStairsModule, CrowdfundingStairsFloor crowdfundingStairsFloor, int i, Object obj) {
            if ((i & 1) != 0) {
                crowdfundingStairsFloor = crowdfundingStairsModule.data;
            }
            return crowdfundingStairsModule.copy(crowdfundingStairsFloor);
        }

        public final CrowdfundingStairsFloor component1() {
            return this.data;
        }

        public final CrowdfundingStairsModule copy(CrowdfundingStairsFloor crowdfundingStairsFloor) {
            Intrinsics.checkNotNullParameter(crowdfundingStairsFloor, "data");
            return new CrowdfundingStairsModule(crowdfundingStairsFloor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CrowdfundingStairsModule) && Intrinsics.areEqual(this.data, ((CrowdfundingStairsModule) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "CrowdfundingStairsModule(data=" + this.data + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CrowdfundingStairsModule(CrowdfundingStairsFloor data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final CrowdfundingStairsFloor getData() {
            return this.data;
        }
    }
}