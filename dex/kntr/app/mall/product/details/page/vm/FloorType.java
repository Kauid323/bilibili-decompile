package kntr.app.mall.product.details.page.vm;

import java.lang.annotation.Annotation;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* compiled from: ContentModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\b\u0081\u0081\u0002\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001#B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006$"}, d2 = {"Lkntr/app/mall/product/details/page/vm/FloorType;", "", "key", "", "description", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getDescription", "HEADER", "BASIC_INFO", "ATMOSPHERE_PRICE", "COUPON_INFO", "ACTIVITY_INFO", "ADV_STATE", "ATTR", "COMMENT", "SHOP", "SHOP_INFO", "DELIVERY_INFO", "SERVICE", "SKU_INFO", "FILE_INFO", "COURSE_INFO", "DETAIL_DESC", "SERVICE_DESC", "FOOTER", "IP_BRAND", "MERGE_ATMOSPHERE_PRICE", "SERIES", "REC", "CROWDFUNDING_ATMOSPHERE", "CROWDFUNDING_PROGRESS", "CROWDFUNDING_STAIRS", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public enum FloorType {
    HEADER("header", "头部组件楼层"),
    BASIC_INFO("basicInfo", "基础信息楼层"),
    ATMOSPHERE_PRICE("atmospherePrice", "氛围价格楼层"),
    COUPON_INFO("couponInfo", "优惠券信息楼层"),
    ACTIVITY_INFO("activityInfo", "活动信息楼层"),
    ADV_STATE("advState", "预售流程楼层"),
    ATTR("attr", "参数-属性楼层"),
    COMMENT("comment", "评论区楼层"),
    SHOP("shop_deprecated", "店铺信息楼层"),
    SHOP_INFO("shop", "店铺详情楼层"),
    DELIVERY_INFO("deliveryInfo", "物流信息楼层"),
    SERVICE("service", "服务楼层"),
    SKU_INFO("skuInfo", "规格楼层"),
    FILE_INFO("fileInfo", "商品文件楼层-虚拟商品"),
    COURSE_INFO("courseInfo", "课程信息楼层"),
    DETAIL_DESC("detailDesc", "商品详情描述楼层"),
    SERVICE_DESC("serviceDesc", "服务说明楼层"),
    FOOTER("footer", "底部楼层信息"),
    IP_BRAND("ipBrand", "IP品牌楼层"),
    MERGE_ATMOSPHERE_PRICE("mergeAtmospherePrice", "合并氛围价格楼层"),
    SERIES("series", "系列商品楼层"),
    REC("recommend", "推荐商品楼层"),
    CROWDFUNDING_ATMOSPHERE("crowdFundingAtmosphere", "众筹氛围楼层"),
    CROWDFUNDING_PROGRESS("crowdFundingProgress", "众筹进度楼层"),
    CROWDFUNDING_STAIRS("crowdFundingStairs", "众筹阶梯楼层");
    
    private final String description;
    private final String key;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.vm.FloorType$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _init_$_anonymous_;
            _init_$_anonymous_ = FloorType._init_$_anonymous_();
            return _init_$_anonymous_;
        }
    });

    public static EnumEntries<FloorType> getEntries() {
        return $ENTRIES;
    }

    /* compiled from: ContentModule.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/vm/FloorType$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/vm/FloorType;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) FloorType.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<FloorType> serializer() {
            return get$cachedSerializer();
        }
    }

    FloorType(String key, String description) {
        this.key = key;
        this.description = description;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("kntr.app.mall.product.details.page.vm.FloorType", values(), new String[]{"header", "basicInfo", "atmospherePrice", "couponInfo", "activityInfo", "advState", "attr", "comment", "shop", "shopInfo", "deliveryInfo", "service", "skuInfo", "fileInfo", "courseInfo", "detailDesc", "serviceDesc", "footer", "ipBrand", "mergeAtmospherePrice", "series", "rec", "crowdfundingAtmosphere", "crowdfundingProgress", "crowdfundingStairs"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, (Annotation[]) null);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getDescription() {
        return this.description;
    }
}