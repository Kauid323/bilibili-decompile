package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.ActivityInfoFloor;
import kntr.app.mall.product.details.page.api.model.CouponInfoFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinVersion;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ActivityInfoFloor.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u0000 k2\u00020\u0001:\f`abcdefghijkBÓ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\t¢\u0006\u0004\b\u001f\u0010 BÉ\u0001\b\u0010\u0012\u0006\u0010!\u001a\u00020\"\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\t\u0012\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b\u001f\u0010%J\r\u0010@\u001a\u00020\u0018H\u0000¢\u0006\u0002\bAJ\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010H\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tHÆ\u0003J\u0011\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u00109J\u000b\u0010N\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u0011\u0010P\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\tHÆ\u0003JÚ\u0001\u0010Q\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010RJ\u0013\u0010S\u001a\u00020\u00182\b\u0010T\u001a\u0004\u0018\u00010UHÖ\u0003J\t\u0010V\u001a\u00020\"HÖ\u0001J\t\u0010W\u001a\u00020\u0003HÖ\u0001J%\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u00002\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^H\u0001¢\u0006\u0002\b_R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b?\u0010-¨\u0006l"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "activityExtInfo", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo;", "activityInfoList", "", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoModel;", "activityInfoVO", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO;", "activityPanelVOs", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityPanelVO;", "atmosVOList", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$AtmosInfo;", "detailNetPriceInfo", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo;", "fansPriceActivityVO", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$FansPriceActivityVO;", "giftActivityVO", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$GiftActivityVO;", "hasNewCoupon", "", "instantDiscountActivity", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$InstantDiscountActivityInfo;", "luckyBuySubsideActivityInfoVO", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$LuckyBuySubsideActivityInfoVO;", "progressActivityInfoVO", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ProgressActivityInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO;Ljava/util/List;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$FansPriceActivityVO;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$GiftActivityVO;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$InstantDiscountActivityInfo;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$LuckyBuySubsideActivityInfoVO;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO;Ljava/util/List;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$FansPriceActivityVO;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$GiftActivityVO;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$InstantDiscountActivityInfo;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$LuckyBuySubsideActivityInfoVO;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getActivityExtInfo", "()Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo;", "getActivityInfoList", "()Ljava/util/List;", "getActivityInfoVO", "()Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO;", "getActivityPanelVOs", "getAtmosVOList", "getDetailNetPriceInfo", "()Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo;", "getFansPriceActivityVO", "()Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$FansPriceActivityVO;", "getGiftActivityVO", "()Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$GiftActivityVO;", "getHasNewCoupon", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getInstantDiscountActivity", "()Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$InstantDiscountActivityInfo;", "getLuckyBuySubsideActivityInfoVO", "()Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$LuckyBuySubsideActivityInfoVO;", "getProgressActivityInfoVO", "isLuckBuySubsidy", "isLuckBuySubsidy$product_details_page_debug", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO;Ljava/util/List;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$FansPriceActivityVO;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$GiftActivityVO;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$InstantDiscountActivityInfo;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$LuckyBuySubsideActivityInfoVO;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ActivityExtInfo", "ActivityInfoModel", "ActivityInfoVO", "ActivityPanelVO", "AtmosInfo", "FansPriceActivityVO", "GiftActivityVO", "InstantDiscountActivityInfo", "LuckyBuySubsideActivityInfoVO", "ProgressActivityInfo", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ActivityInfoFloor implements FloorModel {
    private final ActivityExtInfo activityExtInfo;
    private final List<ActivityInfoModel> activityInfoList;
    private final ActivityInfoVO activityInfoVO;
    private final List<ActivityPanelVO> activityPanelVOs;
    private final List<AtmosInfo> atmosVOList;
    private final String bgImgUrl;
    private final CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo;
    private final FansPriceActivityVO fansPriceActivityVO;
    private final String floorIcon;
    private final String floorKey;
    private final GiftActivityVO giftActivityVO;
    private final Boolean hasNewCoupon;
    private final InstantDiscountActivityInfo instantDiscountActivity;
    private final LuckyBuySubsideActivityInfoVO luckyBuySubsideActivityInfoVO;
    private final List<ProgressActivityInfo> progressActivityInfoVO;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ActivityInfoFloor$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ActivityInfoFloor._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ActivityInfoFloor$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = ActivityInfoFloor._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ActivityInfoFloor$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = ActivityInfoFloor._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ActivityInfoFloor$$ExternalSyntheticLambda3
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$2;
            _childSerializers$_anonymous_$2 = ActivityInfoFloor._childSerializers$_anonymous_$2();
            return _childSerializers$_anonymous_$2;
        }
    })};

    public ActivityInfoFloor() {
        this((String) null, (String) null, (String) null, (ActivityExtInfo) null, (List) null, (ActivityInfoVO) null, (List) null, (List) null, (CouponInfoFloor.DetailNetPriceInfo) null, (FansPriceActivityVO) null, (GiftActivityVO) null, (Boolean) null, (InstantDiscountActivityInfo) null, (LuckyBuySubsideActivityInfoVO) null, (List) null, 32767, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.floorKey;
    }

    public final FansPriceActivityVO component10() {
        return this.fansPriceActivityVO;
    }

    public final GiftActivityVO component11() {
        return this.giftActivityVO;
    }

    public final Boolean component12() {
        return this.hasNewCoupon;
    }

    public final InstantDiscountActivityInfo component13() {
        return this.instantDiscountActivity;
    }

    public final LuckyBuySubsideActivityInfoVO component14() {
        return this.luckyBuySubsideActivityInfoVO;
    }

    public final List<ProgressActivityInfo> component15() {
        return this.progressActivityInfoVO;
    }

    public final String component2() {
        return this.floorIcon;
    }

    public final String component3() {
        return this.bgImgUrl;
    }

    public final ActivityExtInfo component4() {
        return this.activityExtInfo;
    }

    public final List<ActivityInfoModel> component5() {
        return this.activityInfoList;
    }

    public final ActivityInfoVO component6() {
        return this.activityInfoVO;
    }

    public final List<ActivityPanelVO> component7() {
        return this.activityPanelVOs;
    }

    public final List<AtmosInfo> component8() {
        return this.atmosVOList;
    }

    public final CouponInfoFloor.DetailNetPriceInfo component9() {
        return this.detailNetPriceInfo;
    }

    public final ActivityInfoFloor copy(String str, String str2, String str3, ActivityExtInfo activityExtInfo, List<ActivityInfoModel> list, ActivityInfoVO activityInfoVO, List<ActivityPanelVO> list2, List<AtmosInfo> list3, CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo, FansPriceActivityVO fansPriceActivityVO, GiftActivityVO giftActivityVO, Boolean bool, InstantDiscountActivityInfo instantDiscountActivityInfo, LuckyBuySubsideActivityInfoVO luckyBuySubsideActivityInfoVO, List<ProgressActivityInfo> list4) {
        return new ActivityInfoFloor(str, str2, str3, activityExtInfo, list, activityInfoVO, list2, list3, detailNetPriceInfo, fansPriceActivityVO, giftActivityVO, bool, instantDiscountActivityInfo, luckyBuySubsideActivityInfoVO, list4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActivityInfoFloor) {
            ActivityInfoFloor activityInfoFloor = (ActivityInfoFloor) obj;
            return Intrinsics.areEqual(this.floorKey, activityInfoFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, activityInfoFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, activityInfoFloor.bgImgUrl) && Intrinsics.areEqual(this.activityExtInfo, activityInfoFloor.activityExtInfo) && Intrinsics.areEqual(this.activityInfoList, activityInfoFloor.activityInfoList) && Intrinsics.areEqual(this.activityInfoVO, activityInfoFloor.activityInfoVO) && Intrinsics.areEqual(this.activityPanelVOs, activityInfoFloor.activityPanelVOs) && Intrinsics.areEqual(this.atmosVOList, activityInfoFloor.atmosVOList) && Intrinsics.areEqual(this.detailNetPriceInfo, activityInfoFloor.detailNetPriceInfo) && Intrinsics.areEqual(this.fansPriceActivityVO, activityInfoFloor.fansPriceActivityVO) && Intrinsics.areEqual(this.giftActivityVO, activityInfoFloor.giftActivityVO) && Intrinsics.areEqual(this.hasNewCoupon, activityInfoFloor.hasNewCoupon) && Intrinsics.areEqual(this.instantDiscountActivity, activityInfoFloor.instantDiscountActivity) && Intrinsics.areEqual(this.luckyBuySubsideActivityInfoVO, activityInfoFloor.luckyBuySubsideActivityInfoVO) && Intrinsics.areEqual(this.progressActivityInfoVO, activityInfoFloor.progressActivityInfoVO);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.activityExtInfo == null ? 0 : this.activityExtInfo.hashCode())) * 31) + (this.activityInfoList == null ? 0 : this.activityInfoList.hashCode())) * 31) + (this.activityInfoVO == null ? 0 : this.activityInfoVO.hashCode())) * 31) + (this.activityPanelVOs == null ? 0 : this.activityPanelVOs.hashCode())) * 31) + (this.atmosVOList == null ? 0 : this.atmosVOList.hashCode())) * 31) + (this.detailNetPriceInfo == null ? 0 : this.detailNetPriceInfo.hashCode())) * 31) + (this.fansPriceActivityVO == null ? 0 : this.fansPriceActivityVO.hashCode())) * 31) + (this.giftActivityVO == null ? 0 : this.giftActivityVO.hashCode())) * 31) + (this.hasNewCoupon == null ? 0 : this.hasNewCoupon.hashCode())) * 31) + (this.instantDiscountActivity == null ? 0 : this.instantDiscountActivity.hashCode())) * 31) + (this.luckyBuySubsideActivityInfoVO == null ? 0 : this.luckyBuySubsideActivityInfoVO.hashCode())) * 31) + (this.progressActivityInfoVO != null ? this.progressActivityInfoVO.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        ActivityExtInfo activityExtInfo = this.activityExtInfo;
        List<ActivityInfoModel> list = this.activityInfoList;
        ActivityInfoVO activityInfoVO = this.activityInfoVO;
        List<ActivityPanelVO> list2 = this.activityPanelVOs;
        List<AtmosInfo> list3 = this.atmosVOList;
        CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo = this.detailNetPriceInfo;
        FansPriceActivityVO fansPriceActivityVO = this.fansPriceActivityVO;
        GiftActivityVO giftActivityVO = this.giftActivityVO;
        Boolean bool = this.hasNewCoupon;
        InstantDiscountActivityInfo instantDiscountActivityInfo = this.instantDiscountActivity;
        LuckyBuySubsideActivityInfoVO luckyBuySubsideActivityInfoVO = this.luckyBuySubsideActivityInfoVO;
        return "ActivityInfoFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", activityExtInfo=" + activityExtInfo + ", activityInfoList=" + list + ", activityInfoVO=" + activityInfoVO + ", activityPanelVOs=" + list2 + ", atmosVOList=" + list3 + ", detailNetPriceInfo=" + detailNetPriceInfo + ", fansPriceActivityVO=" + fansPriceActivityVO + ", giftActivityVO=" + giftActivityVO + ", hasNewCoupon=" + bool + ", instantDiscountActivity=" + instantDiscountActivityInfo + ", luckyBuySubsideActivityInfoVO=" + luckyBuySubsideActivityInfoVO + ", progressActivityInfoVO=" + this.progressActivityInfoVO + ")";
    }

    /* compiled from: ActivityInfoFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ActivityInfoFloor> serializer() {
            return ActivityInfoFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ActivityInfoFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, ActivityExtInfo activityExtInfo, List activityInfoList, ActivityInfoVO activityInfoVO, List activityPanelVOs, List atmosVOList, CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo, FansPriceActivityVO fansPriceActivityVO, GiftActivityVO giftActivityVO, Boolean hasNewCoupon, InstantDiscountActivityInfo instantDiscountActivity, LuckyBuySubsideActivityInfoVO luckyBuySubsideActivityInfoVO, List progressActivityInfoVO, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.floorKey = null;
        } else {
            this.floorKey = floorKey;
        }
        if ((seen0 & 2) == 0) {
            this.floorIcon = null;
        } else {
            this.floorIcon = floorIcon;
        }
        if ((seen0 & 4) == 0) {
            this.bgImgUrl = null;
        } else {
            this.bgImgUrl = bgImgUrl;
        }
        if ((seen0 & 8) == 0) {
            this.activityExtInfo = null;
        } else {
            this.activityExtInfo = activityExtInfo;
        }
        if ((seen0 & 16) == 0) {
            this.activityInfoList = null;
        } else {
            this.activityInfoList = activityInfoList;
        }
        if ((seen0 & 32) == 0) {
            this.activityInfoVO = null;
        } else {
            this.activityInfoVO = activityInfoVO;
        }
        if ((seen0 & 64) == 0) {
            this.activityPanelVOs = null;
        } else {
            this.activityPanelVOs = activityPanelVOs;
        }
        if ((seen0 & 128) == 0) {
            this.atmosVOList = null;
        } else {
            this.atmosVOList = atmosVOList;
        }
        if ((seen0 & 256) == 0) {
            this.detailNetPriceInfo = null;
        } else {
            this.detailNetPriceInfo = detailNetPriceInfo;
        }
        if ((seen0 & 512) == 0) {
            this.fansPriceActivityVO = null;
        } else {
            this.fansPriceActivityVO = fansPriceActivityVO;
        }
        if ((seen0 & 1024) == 0) {
            this.giftActivityVO = null;
        } else {
            this.giftActivityVO = giftActivityVO;
        }
        if ((seen0 & 2048) == 0) {
            this.hasNewCoupon = null;
        } else {
            this.hasNewCoupon = hasNewCoupon;
        }
        if ((seen0 & 4096) == 0) {
            this.instantDiscountActivity = null;
        } else {
            this.instantDiscountActivity = instantDiscountActivity;
        }
        if ((seen0 & 8192) == 0) {
            this.luckyBuySubsideActivityInfoVO = null;
        } else {
            this.luckyBuySubsideActivityInfoVO = luckyBuySubsideActivityInfoVO;
        }
        if ((seen0 & 16384) == 0) {
            this.progressActivityInfoVO = null;
        } else {
            this.progressActivityInfoVO = progressActivityInfoVO;
        }
    }

    public ActivityInfoFloor(String floorKey, String floorIcon, String bgImgUrl, ActivityExtInfo activityExtInfo, List<ActivityInfoModel> list, ActivityInfoVO activityInfoVO, List<ActivityPanelVO> list2, List<AtmosInfo> list3, CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo, FansPriceActivityVO fansPriceActivityVO, GiftActivityVO giftActivityVO, Boolean hasNewCoupon, InstantDiscountActivityInfo instantDiscountActivity, LuckyBuySubsideActivityInfoVO luckyBuySubsideActivityInfoVO, List<ProgressActivityInfo> list4) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.activityExtInfo = activityExtInfo;
        this.activityInfoList = list;
        this.activityInfoVO = activityInfoVO;
        this.activityPanelVOs = list2;
        this.atmosVOList = list3;
        this.detailNetPriceInfo = detailNetPriceInfo;
        this.fansPriceActivityVO = fansPriceActivityVO;
        this.giftActivityVO = giftActivityVO;
        this.hasNewCoupon = hasNewCoupon;
        this.instantDiscountActivity = instantDiscountActivity;
        this.luckyBuySubsideActivityInfoVO = luckyBuySubsideActivityInfoVO;
        this.progressActivityInfoVO = list4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(ActivityInfoFloor$ActivityInfoModel$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(ActivityInfoFloor$ActivityPanelVO$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(ActivityInfoFloor$AtmosInfo$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(ActivityInfoFloor$ProgressActivityInfo$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(ActivityInfoFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.getFloorKey() != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.getFloorKey());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getFloorIcon() != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getFloorIcon());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getBgImgUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getBgImgUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.activityExtInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, ActivityInfoFloor$ActivityExtInfo$$serializer.INSTANCE, self.activityExtInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.activityInfoList != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.activityInfoList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.activityInfoVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, ActivityInfoFloor$ActivityInfoVO$$serializer.INSTANCE, self.activityInfoVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.activityPanelVOs != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, lazyArr[6].getValue(), self.activityPanelVOs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.atmosVOList != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.atmosVOList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.detailNetPriceInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, CouponInfoFloor$DetailNetPriceInfo$$serializer.INSTANCE, self.detailNetPriceInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.fansPriceActivityVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, ActivityInfoFloor$FansPriceActivityVO$$serializer.INSTANCE, self.fansPriceActivityVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.giftActivityVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, ActivityInfoFloor$GiftActivityVO$$serializer.INSTANCE, self.giftActivityVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.hasNewCoupon != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, BooleanSerializer.INSTANCE, self.hasNewCoupon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.instantDiscountActivity != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, ActivityInfoFloor$InstantDiscountActivityInfo$$serializer.INSTANCE, self.instantDiscountActivity);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.luckyBuySubsideActivityInfoVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$$serializer.INSTANCE, self.luckyBuySubsideActivityInfoVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.progressActivityInfoVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, lazyArr[14].getValue(), self.progressActivityInfoVO);
        }
    }

    public /* synthetic */ ActivityInfoFloor(String str, String str2, String str3, ActivityExtInfo activityExtInfo, List list, ActivityInfoVO activityInfoVO, List list2, List list3, CouponInfoFloor.DetailNetPriceInfo detailNetPriceInfo, FansPriceActivityVO fansPriceActivityVO, GiftActivityVO giftActivityVO, Boolean bool, InstantDiscountActivityInfo instantDiscountActivityInfo, LuckyBuySubsideActivityInfoVO luckyBuySubsideActivityInfoVO, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : activityExtInfo, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : activityInfoVO, (i & 64) != 0 ? null : list2, (i & 128) != 0 ? null : list3, (i & 256) != 0 ? null : detailNetPriceInfo, (i & 512) != 0 ? null : fansPriceActivityVO, (i & 1024) != 0 ? null : giftActivityVO, (i & 2048) != 0 ? null : bool, (i & 4096) != 0 ? null : instantDiscountActivityInfo, (i & 8192) != 0 ? null : luckyBuySubsideActivityInfoVO, (i & 16384) == 0 ? list4 : null);
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getFloorKey() {
        return this.floorKey;
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getFloorIcon() {
        return this.floorIcon;
    }

    @Override // kntr.app.mall.product.details.page.api.model.FloorModel
    public String getBgImgUrl() {
        return this.bgImgUrl;
    }

    public final ActivityExtInfo getActivityExtInfo() {
        return this.activityExtInfo;
    }

    public final List<ActivityInfoModel> getActivityInfoList() {
        return this.activityInfoList;
    }

    public final ActivityInfoVO getActivityInfoVO() {
        return this.activityInfoVO;
    }

    public final List<ActivityPanelVO> getActivityPanelVOs() {
        return this.activityPanelVOs;
    }

    public final List<AtmosInfo> getAtmosVOList() {
        return this.atmosVOList;
    }

    public final CouponInfoFloor.DetailNetPriceInfo getDetailNetPriceInfo() {
        return this.detailNetPriceInfo;
    }

    public final FansPriceActivityVO getFansPriceActivityVO() {
        return this.fansPriceActivityVO;
    }

    public final GiftActivityVO getGiftActivityVO() {
        return this.giftActivityVO;
    }

    public final Boolean getHasNewCoupon() {
        return this.hasNewCoupon;
    }

    public final InstantDiscountActivityInfo getInstantDiscountActivity() {
        return this.instantDiscountActivity;
    }

    public final LuckyBuySubsideActivityInfoVO getLuckyBuySubsideActivityInfoVO() {
        return this.luckyBuySubsideActivityInfoVO;
    }

    /* compiled from: ActivityInfoFloor.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 12\u00020\u0001:\u0004./01B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00062"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo;", "", "forbidStatus", "", "hasStockSkuCount", "", "lowestSkuReducedPrice", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice;", "newUserCouponDTO", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$NewUserCoupon;", "<init>", "(Ljava/lang/Byte;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$NewUserCoupon;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Byte;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$NewUserCoupon;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getForbidStatus", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getHasStockSkuCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLowestSkuReducedPrice", "()Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice;", "getNewUserCouponDTO", "()Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$NewUserCoupon;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Byte;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$NewUserCoupon;)Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "LowestSkuReducedPrice", "NewUserCoupon", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ActivityExtInfo {
        private final Byte forbidStatus;
        private final Integer hasStockSkuCount;
        private final LowestSkuReducedPrice lowestSkuReducedPrice;
        private final NewUserCoupon newUserCouponDTO;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public ActivityExtInfo() {
            this((Byte) null, (Integer) null, (LowestSkuReducedPrice) null, (NewUserCoupon) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ActivityExtInfo copy$default(ActivityExtInfo activityExtInfo, Byte b, Integer num, LowestSkuReducedPrice lowestSkuReducedPrice, NewUserCoupon newUserCoupon, int i, Object obj) {
            if ((i & 1) != 0) {
                b = activityExtInfo.forbidStatus;
            }
            if ((i & 2) != 0) {
                num = activityExtInfo.hasStockSkuCount;
            }
            if ((i & 4) != 0) {
                lowestSkuReducedPrice = activityExtInfo.lowestSkuReducedPrice;
            }
            if ((i & 8) != 0) {
                newUserCoupon = activityExtInfo.newUserCouponDTO;
            }
            return activityExtInfo.copy(b, num, lowestSkuReducedPrice, newUserCoupon);
        }

        public final Byte component1() {
            return this.forbidStatus;
        }

        public final Integer component2() {
            return this.hasStockSkuCount;
        }

        public final LowestSkuReducedPrice component3() {
            return this.lowestSkuReducedPrice;
        }

        public final NewUserCoupon component4() {
            return this.newUserCouponDTO;
        }

        public final ActivityExtInfo copy(Byte b, Integer num, LowestSkuReducedPrice lowestSkuReducedPrice, NewUserCoupon newUserCoupon) {
            return new ActivityExtInfo(b, num, lowestSkuReducedPrice, newUserCoupon);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ActivityExtInfo) {
                ActivityExtInfo activityExtInfo = (ActivityExtInfo) obj;
                return Intrinsics.areEqual(this.forbidStatus, activityExtInfo.forbidStatus) && Intrinsics.areEqual(this.hasStockSkuCount, activityExtInfo.hasStockSkuCount) && Intrinsics.areEqual(this.lowestSkuReducedPrice, activityExtInfo.lowestSkuReducedPrice) && Intrinsics.areEqual(this.newUserCouponDTO, activityExtInfo.newUserCouponDTO);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.forbidStatus == null ? 0 : this.forbidStatus.hashCode()) * 31) + (this.hasStockSkuCount == null ? 0 : this.hasStockSkuCount.hashCode())) * 31) + (this.lowestSkuReducedPrice == null ? 0 : this.lowestSkuReducedPrice.hashCode())) * 31) + (this.newUserCouponDTO != null ? this.newUserCouponDTO.hashCode() : 0);
        }

        public String toString() {
            Byte b = this.forbidStatus;
            Integer num = this.hasStockSkuCount;
            LowestSkuReducedPrice lowestSkuReducedPrice = this.lowestSkuReducedPrice;
            return "ActivityExtInfo(forbidStatus=" + b + ", hasStockSkuCount=" + num + ", lowestSkuReducedPrice=" + lowestSkuReducedPrice + ", newUserCouponDTO=" + this.newUserCouponDTO + ")";
        }

        /* compiled from: ActivityInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ActivityExtInfo> serializer() {
                return ActivityInfoFloor$ActivityExtInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ActivityExtInfo(int seen0, Byte forbidStatus, Integer hasStockSkuCount, LowestSkuReducedPrice lowestSkuReducedPrice, NewUserCoupon newUserCouponDTO, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.forbidStatus = null;
            } else {
                this.forbidStatus = forbidStatus;
            }
            if ((seen0 & 2) == 0) {
                this.hasStockSkuCount = null;
            } else {
                this.hasStockSkuCount = hasStockSkuCount;
            }
            if ((seen0 & 4) == 0) {
                this.lowestSkuReducedPrice = null;
            } else {
                this.lowestSkuReducedPrice = lowestSkuReducedPrice;
            }
            if ((seen0 & 8) == 0) {
                this.newUserCouponDTO = null;
            } else {
                this.newUserCouponDTO = newUserCouponDTO;
            }
        }

        public ActivityExtInfo(Byte forbidStatus, Integer hasStockSkuCount, LowestSkuReducedPrice lowestSkuReducedPrice, NewUserCoupon newUserCouponDTO) {
            this.forbidStatus = forbidStatus;
            this.hasStockSkuCount = hasStockSkuCount;
            this.lowestSkuReducedPrice = lowestSkuReducedPrice;
            this.newUserCouponDTO = newUserCouponDTO;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ActivityExtInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.forbidStatus != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, ByteSerializer.INSTANCE, self.forbidStatus);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.hasStockSkuCount != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.hasStockSkuCount);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.lowestSkuReducedPrice != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$$serializer.INSTANCE, self.lowestSkuReducedPrice);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.newUserCouponDTO != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, ActivityInfoFloor$ActivityExtInfo$NewUserCoupon$$serializer.INSTANCE, self.newUserCouponDTO);
            }
        }

        public /* synthetic */ ActivityExtInfo(Byte b, Integer num, LowestSkuReducedPrice lowestSkuReducedPrice, NewUserCoupon newUserCoupon, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : b, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : lowestSkuReducedPrice, (i & 8) != 0 ? null : newUserCoupon);
        }

        public final Byte getForbidStatus() {
            return this.forbidStatus;
        }

        public final Integer getHasStockSkuCount() {
            return this.hasStockSkuCount;
        }

        public final LowestSkuReducedPrice getLowestSkuReducedPrice() {
            return this.lowestSkuReducedPrice;
        }

        /* compiled from: ActivityInfoFloor.kt */
        @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0003./0B=\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018JD\u0010\u001e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u00061"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice;", "", "couponList", "", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$Coupon;", "reducedPrice", "", "reducedPriceUsedCoupon", "reducedYPrice", "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$Coupon;Ljava/lang/Double;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$Coupon;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCouponList", "()Ljava/util/List;", "getReducedPrice", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReducedPriceUsedCoupon", "()Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$Coupon;", "getReducedYPrice", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$Coupon;Ljava/lang/Double;)Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "Coupon", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class LowestSkuReducedPrice {
            private final List<Coupon> couponList;
            private final Integer reducedPrice;
            private final Coupon reducedPriceUsedCoupon;
            private final Double reducedYPrice;
            public static final Companion Companion = new Companion(null);
            public static final int $stable = 8;
            private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$$ExternalSyntheticLambda0
                public final Object invoke() {
                    KSerializer _childSerializers$_anonymous_;
                    _childSerializers$_anonymous_ = ActivityInfoFloor.ActivityExtInfo.LowestSkuReducedPrice._childSerializers$_anonymous_();
                    return _childSerializers$_anonymous_;
                }
            }), null, null, null};

            public LowestSkuReducedPrice() {
                this((List) null, (Integer) null, (Coupon) null, (Double) null, 15, (DefaultConstructorMarker) null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ LowestSkuReducedPrice copy$default(LowestSkuReducedPrice lowestSkuReducedPrice, List list, Integer num, Coupon coupon, Double d, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = lowestSkuReducedPrice.couponList;
                }
                if ((i & 2) != 0) {
                    num = lowestSkuReducedPrice.reducedPrice;
                }
                if ((i & 4) != 0) {
                    coupon = lowestSkuReducedPrice.reducedPriceUsedCoupon;
                }
                if ((i & 8) != 0) {
                    d = lowestSkuReducedPrice.reducedYPrice;
                }
                return lowestSkuReducedPrice.copy(list, num, coupon, d);
            }

            public final List<Coupon> component1() {
                return this.couponList;
            }

            public final Integer component2() {
                return this.reducedPrice;
            }

            public final Coupon component3() {
                return this.reducedPriceUsedCoupon;
            }

            public final Double component4() {
                return this.reducedYPrice;
            }

            public final LowestSkuReducedPrice copy(List<Coupon> list, Integer num, Coupon coupon, Double d) {
                return new LowestSkuReducedPrice(list, num, coupon, d);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof LowestSkuReducedPrice) {
                    LowestSkuReducedPrice lowestSkuReducedPrice = (LowestSkuReducedPrice) obj;
                    return Intrinsics.areEqual(this.couponList, lowestSkuReducedPrice.couponList) && Intrinsics.areEqual(this.reducedPrice, lowestSkuReducedPrice.reducedPrice) && Intrinsics.areEqual(this.reducedPriceUsedCoupon, lowestSkuReducedPrice.reducedPriceUsedCoupon) && Intrinsics.areEqual(this.reducedYPrice, lowestSkuReducedPrice.reducedYPrice);
                }
                return false;
            }

            public int hashCode() {
                return ((((((this.couponList == null ? 0 : this.couponList.hashCode()) * 31) + (this.reducedPrice == null ? 0 : this.reducedPrice.hashCode())) * 31) + (this.reducedPriceUsedCoupon == null ? 0 : this.reducedPriceUsedCoupon.hashCode())) * 31) + (this.reducedYPrice != null ? this.reducedYPrice.hashCode() : 0);
            }

            public String toString() {
                List<Coupon> list = this.couponList;
                Integer num = this.reducedPrice;
                Coupon coupon = this.reducedPriceUsedCoupon;
                return "LowestSkuReducedPrice(couponList=" + list + ", reducedPrice=" + num + ", reducedPriceUsedCoupon=" + coupon + ", reducedYPrice=" + this.reducedYPrice + ")";
            }

            /* compiled from: ActivityInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<LowestSkuReducedPrice> serializer() {
                    return ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ LowestSkuReducedPrice(int seen0, List couponList, Integer reducedPrice, Coupon reducedPriceUsedCoupon, Double reducedYPrice, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.couponList = null;
                } else {
                    this.couponList = couponList;
                }
                if ((seen0 & 2) == 0) {
                    this.reducedPrice = null;
                } else {
                    this.reducedPrice = reducedPrice;
                }
                if ((seen0 & 4) == 0) {
                    this.reducedPriceUsedCoupon = null;
                } else {
                    this.reducedPriceUsedCoupon = reducedPriceUsedCoupon;
                }
                if ((seen0 & 8) == 0) {
                    this.reducedYPrice = null;
                } else {
                    this.reducedYPrice = reducedYPrice;
                }
            }

            public LowestSkuReducedPrice(List<Coupon> list, Integer reducedPrice, Coupon reducedPriceUsedCoupon, Double reducedYPrice) {
                this.couponList = list;
                this.reducedPrice = reducedPrice;
                this.reducedPriceUsedCoupon = reducedPriceUsedCoupon;
                this.reducedYPrice = reducedYPrice;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$Coupon$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(LowestSkuReducedPrice self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.couponList != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.couponList);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.reducedPrice != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.reducedPrice);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.reducedPriceUsedCoupon != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$Coupon$$serializer.INSTANCE, self.reducedPriceUsedCoupon);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.reducedYPrice != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, DoubleSerializer.INSTANCE, self.reducedYPrice);
                }
            }

            public /* synthetic */ LowestSkuReducedPrice(List list, Integer num, Coupon coupon, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : coupon, (i & 8) != 0 ? null : d);
            }

            public final List<Coupon> getCouponList() {
                return this.couponList;
            }

            public final Integer getReducedPrice() {
                return this.reducedPrice;
            }

            public final Coupon getReducedPriceUsedCoupon() {
                return this.reducedPriceUsedCoupon;
            }

            /* compiled from: ActivityInfoFloor.kt */
            @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\bO\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u008a\u00012\u00020\u0001:\u0004\u0089\u0001\u008a\u0001B\u009f\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b(\u0010)B÷\u0002\b\u0010\u0012\u0006\u0010*\u001a\u00020\r\u0012\u0006\u0010+\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\r\u0012\b\u0010\"\u001a\u0004\u0018\u00010\b\u0012\b\u0010#\u001a\u0004\u0018\u00010\r\u0012\b\u0010$\u001a\u0004\u0018\u00010\r\u0012\b\u0010%\u001a\u0004\u0018\u00010\r\u0012\b\u0010&\u001a\u0004\u0018\u00010\b\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010,\u001a\u0004\u0018\u00010-¢\u0006\u0004\b(\u0010.J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00105J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010a\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010c\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010d\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010AJ\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010g\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00105J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010k\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010l\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010m\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010;J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010s\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010u\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010v\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010w\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010x\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00105J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¦\u0003\u0010z\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010{J\u0013\u0010|\u001a\u00020}2\b\u0010~\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u007f\u001a\u00020\rHÖ\u0001J\n\u0010\u0080\u0001\u001a\u00020\u0003HÖ\u0001J-\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u00002\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0001¢\u0006\u0003\b\u0088\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u00100R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u00100R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u00100R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u00100R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u00100R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010<\u001a\u0004\b:\u0010;R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010<\u001a\u0004\b=\u0010;R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00106\u001a\u0004\b>\u00105R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010<\u001a\u0004\b?\u0010;R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010B\u001a\u0004\b@\u0010AR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u00100R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010<\u001a\u0004\bD\u0010;R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00106\u001a\u0004\bE\u00105R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u00100R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u00100R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u00100R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010<\u001a\u0004\bI\u0010;R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010<\u001a\u0004\bJ\u0010;R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010<\u001a\u0004\bK\u0010;R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u00100R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bM\u00100R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u00100R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u00100R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u00100R\u0015\u0010!\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010<\u001a\u0004\bQ\u0010;R\u0015\u0010\"\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00106\u001a\u0004\bR\u00105R\u0015\u0010#\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010<\u001a\u0004\bS\u0010;R\u0015\u0010$\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010<\u001a\u0004\bT\u0010;R\u0015\u0010%\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010<\u001a\u0004\bU\u0010;R\u0015\u0010&\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00106\u001a\u0004\bV\u00105R\u0013\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u00100¨\u0006\u008b\u0001"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$Coupon;", "", "couponId", "", "couponName", "couponStatus", "couponStatusMsg", "couponType", "", "couponTypeComb", "couponTypeDesc", "couponTypeName", "discount", "", "discountCondition", "discountLayer", "discountLimit", "discountY", "", "extraInfo", "maxNumPerUser", "newUserLimit", "owners", "ownersName", "receiveChannel", "receiveEndTime", "receiveStartTime", "regTime", "sceneId", "shopLabel", "showName", "sourceAuthorityId", "sourceId", "useEffectDays", "useEffectUnit", "useEndTime", "useStartTime", "userCouponReceiveStatus", "userLevel", "vipType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;)V", "seen0", "seen1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCouponId", "()Ljava/lang/String;", "getCouponName", "getCouponStatus", "getCouponStatusMsg", "getCouponType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getCouponTypeComb", "getCouponTypeDesc", "getCouponTypeName", "getDiscount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDiscountCondition", "getDiscountLayer", "getDiscountLimit", "getDiscountY", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getExtraInfo", "getMaxNumPerUser", "getNewUserLimit", "getOwners", "getOwnersName", "getReceiveChannel", "getReceiveEndTime", "getReceiveStartTime", "getRegTime", "getSceneId", "getShopLabel", "getShowName", "getSourceAuthorityId", "getSourceId", "getUseEffectDays", "getUseEffectUnit", "getUseEndTime", "getUseStartTime", "getUserCouponReceiveStatus", "getUserLevel", "getVipType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$Coupon;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Coupon {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final String couponId;
                private final String couponName;
                private final String couponStatus;
                private final String couponStatusMsg;
                private final Byte couponType;
                private final String couponTypeComb;
                private final String couponTypeDesc;
                private final String couponTypeName;
                private final Integer discount;
                private final Integer discountCondition;
                private final Byte discountLayer;
                private final Integer discountLimit;
                private final Double discountY;
                private final String extraInfo;
                private final Integer maxNumPerUser;
                private final Byte newUserLimit;
                private final String owners;
                private final String ownersName;
                private final String receiveChannel;
                private final Integer receiveEndTime;
                private final Integer receiveStartTime;
                private final Integer regTime;
                private final String sceneId;
                private final String shopLabel;
                private final String showName;
                private final String sourceAuthorityId;
                private final String sourceId;
                private final Integer useEffectDays;
                private final Byte useEffectUnit;
                private final Integer useEndTime;
                private final Integer useStartTime;
                private final Integer userCouponReceiveStatus;
                private final Byte userLevel;
                private final String vipType;

                public Coupon() {
                    this((String) null, (String) null, (String) null, (String) null, (Byte) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Byte) null, (Integer) null, (Double) null, (String) null, (Integer) null, (Byte) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Byte) null, (Integer) null, (Integer) null, (Integer) null, (Byte) null, (String) null, -1, 3, (DefaultConstructorMarker) null);
                }

                public final String component1() {
                    return this.couponId;
                }

                public final Integer component10() {
                    return this.discountCondition;
                }

                public final Byte component11() {
                    return this.discountLayer;
                }

                public final Integer component12() {
                    return this.discountLimit;
                }

                public final Double component13() {
                    return this.discountY;
                }

                public final String component14() {
                    return this.extraInfo;
                }

                public final Integer component15() {
                    return this.maxNumPerUser;
                }

                public final Byte component16() {
                    return this.newUserLimit;
                }

                public final String component17() {
                    return this.owners;
                }

                public final String component18() {
                    return this.ownersName;
                }

                public final String component19() {
                    return this.receiveChannel;
                }

                public final String component2() {
                    return this.couponName;
                }

                public final Integer component20() {
                    return this.receiveEndTime;
                }

                public final Integer component21() {
                    return this.receiveStartTime;
                }

                public final Integer component22() {
                    return this.regTime;
                }

                public final String component23() {
                    return this.sceneId;
                }

                public final String component24() {
                    return this.shopLabel;
                }

                public final String component25() {
                    return this.showName;
                }

                public final String component26() {
                    return this.sourceAuthorityId;
                }

                public final String component27() {
                    return this.sourceId;
                }

                public final Integer component28() {
                    return this.useEffectDays;
                }

                public final Byte component29() {
                    return this.useEffectUnit;
                }

                public final String component3() {
                    return this.couponStatus;
                }

                public final Integer component30() {
                    return this.useEndTime;
                }

                public final Integer component31() {
                    return this.useStartTime;
                }

                public final Integer component32() {
                    return this.userCouponReceiveStatus;
                }

                public final Byte component33() {
                    return this.userLevel;
                }

                public final String component34() {
                    return this.vipType;
                }

                public final String component4() {
                    return this.couponStatusMsg;
                }

                public final Byte component5() {
                    return this.couponType;
                }

                public final String component6() {
                    return this.couponTypeComb;
                }

                public final String component7() {
                    return this.couponTypeDesc;
                }

                public final String component8() {
                    return this.couponTypeName;
                }

                public final Integer component9() {
                    return this.discount;
                }

                public final Coupon copy(String str, String str2, String str3, String str4, Byte b, String str5, String str6, String str7, Integer num, Integer num2, Byte b2, Integer num3, Double d, String str8, Integer num4, Byte b3, String str9, String str10, String str11, Integer num5, Integer num6, Integer num7, String str12, String str13, String str14, String str15, String str16, Integer num8, Byte b4, Integer num9, Integer num10, Integer num11, Byte b5, String str17) {
                    return new Coupon(str, str2, str3, str4, b, str5, str6, str7, num, num2, b2, num3, d, str8, num4, b3, str9, str10, str11, num5, num6, num7, str12, str13, str14, str15, str16, num8, b4, num9, num10, num11, b5, str17);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof Coupon) {
                        Coupon coupon = (Coupon) obj;
                        return Intrinsics.areEqual(this.couponId, coupon.couponId) && Intrinsics.areEqual(this.couponName, coupon.couponName) && Intrinsics.areEqual(this.couponStatus, coupon.couponStatus) && Intrinsics.areEqual(this.couponStatusMsg, coupon.couponStatusMsg) && Intrinsics.areEqual(this.couponType, coupon.couponType) && Intrinsics.areEqual(this.couponTypeComb, coupon.couponTypeComb) && Intrinsics.areEqual(this.couponTypeDesc, coupon.couponTypeDesc) && Intrinsics.areEqual(this.couponTypeName, coupon.couponTypeName) && Intrinsics.areEqual(this.discount, coupon.discount) && Intrinsics.areEqual(this.discountCondition, coupon.discountCondition) && Intrinsics.areEqual(this.discountLayer, coupon.discountLayer) && Intrinsics.areEqual(this.discountLimit, coupon.discountLimit) && Intrinsics.areEqual(this.discountY, coupon.discountY) && Intrinsics.areEqual(this.extraInfo, coupon.extraInfo) && Intrinsics.areEqual(this.maxNumPerUser, coupon.maxNumPerUser) && Intrinsics.areEqual(this.newUserLimit, coupon.newUserLimit) && Intrinsics.areEqual(this.owners, coupon.owners) && Intrinsics.areEqual(this.ownersName, coupon.ownersName) && Intrinsics.areEqual(this.receiveChannel, coupon.receiveChannel) && Intrinsics.areEqual(this.receiveEndTime, coupon.receiveEndTime) && Intrinsics.areEqual(this.receiveStartTime, coupon.receiveStartTime) && Intrinsics.areEqual(this.regTime, coupon.regTime) && Intrinsics.areEqual(this.sceneId, coupon.sceneId) && Intrinsics.areEqual(this.shopLabel, coupon.shopLabel) && Intrinsics.areEqual(this.showName, coupon.showName) && Intrinsics.areEqual(this.sourceAuthorityId, coupon.sourceAuthorityId) && Intrinsics.areEqual(this.sourceId, coupon.sourceId) && Intrinsics.areEqual(this.useEffectDays, coupon.useEffectDays) && Intrinsics.areEqual(this.useEffectUnit, coupon.useEffectUnit) && Intrinsics.areEqual(this.useEndTime, coupon.useEndTime) && Intrinsics.areEqual(this.useStartTime, coupon.useStartTime) && Intrinsics.areEqual(this.userCouponReceiveStatus, coupon.userCouponReceiveStatus) && Intrinsics.areEqual(this.userLevel, coupon.userLevel) && Intrinsics.areEqual(this.vipType, coupon.vipType);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.couponId == null ? 0 : this.couponId.hashCode()) * 31) + (this.couponName == null ? 0 : this.couponName.hashCode())) * 31) + (this.couponStatus == null ? 0 : this.couponStatus.hashCode())) * 31) + (this.couponStatusMsg == null ? 0 : this.couponStatusMsg.hashCode())) * 31) + (this.couponType == null ? 0 : this.couponType.hashCode())) * 31) + (this.couponTypeComb == null ? 0 : this.couponTypeComb.hashCode())) * 31) + (this.couponTypeDesc == null ? 0 : this.couponTypeDesc.hashCode())) * 31) + (this.couponTypeName == null ? 0 : this.couponTypeName.hashCode())) * 31) + (this.discount == null ? 0 : this.discount.hashCode())) * 31) + (this.discountCondition == null ? 0 : this.discountCondition.hashCode())) * 31) + (this.discountLayer == null ? 0 : this.discountLayer.hashCode())) * 31) + (this.discountLimit == null ? 0 : this.discountLimit.hashCode())) * 31) + (this.discountY == null ? 0 : this.discountY.hashCode())) * 31) + (this.extraInfo == null ? 0 : this.extraInfo.hashCode())) * 31) + (this.maxNumPerUser == null ? 0 : this.maxNumPerUser.hashCode())) * 31) + (this.newUserLimit == null ? 0 : this.newUserLimit.hashCode())) * 31) + (this.owners == null ? 0 : this.owners.hashCode())) * 31) + (this.ownersName == null ? 0 : this.ownersName.hashCode())) * 31) + (this.receiveChannel == null ? 0 : this.receiveChannel.hashCode())) * 31) + (this.receiveEndTime == null ? 0 : this.receiveEndTime.hashCode())) * 31) + (this.receiveStartTime == null ? 0 : this.receiveStartTime.hashCode())) * 31) + (this.regTime == null ? 0 : this.regTime.hashCode())) * 31) + (this.sceneId == null ? 0 : this.sceneId.hashCode())) * 31) + (this.shopLabel == null ? 0 : this.shopLabel.hashCode())) * 31) + (this.showName == null ? 0 : this.showName.hashCode())) * 31) + (this.sourceAuthorityId == null ? 0 : this.sourceAuthorityId.hashCode())) * 31) + (this.sourceId == null ? 0 : this.sourceId.hashCode())) * 31) + (this.useEffectDays == null ? 0 : this.useEffectDays.hashCode())) * 31) + (this.useEffectUnit == null ? 0 : this.useEffectUnit.hashCode())) * 31) + (this.useEndTime == null ? 0 : this.useEndTime.hashCode())) * 31) + (this.useStartTime == null ? 0 : this.useStartTime.hashCode())) * 31) + (this.userCouponReceiveStatus == null ? 0 : this.userCouponReceiveStatus.hashCode())) * 31) + (this.userLevel == null ? 0 : this.userLevel.hashCode())) * 31) + (this.vipType != null ? this.vipType.hashCode() : 0);
                }

                public String toString() {
                    String str = this.couponId;
                    String str2 = this.couponName;
                    String str3 = this.couponStatus;
                    String str4 = this.couponStatusMsg;
                    Byte b = this.couponType;
                    String str5 = this.couponTypeComb;
                    String str6 = this.couponTypeDesc;
                    String str7 = this.couponTypeName;
                    Integer num = this.discount;
                    Integer num2 = this.discountCondition;
                    Byte b2 = this.discountLayer;
                    Integer num3 = this.discountLimit;
                    Double d = this.discountY;
                    String str8 = this.extraInfo;
                    Integer num4 = this.maxNumPerUser;
                    Byte b3 = this.newUserLimit;
                    String str9 = this.owners;
                    String str10 = this.ownersName;
                    String str11 = this.receiveChannel;
                    Integer num5 = this.receiveEndTime;
                    Integer num6 = this.receiveStartTime;
                    Integer num7 = this.regTime;
                    String str12 = this.sceneId;
                    String str13 = this.shopLabel;
                    String str14 = this.showName;
                    String str15 = this.sourceAuthorityId;
                    String str16 = this.sourceId;
                    Integer num8 = this.useEffectDays;
                    Byte b4 = this.useEffectUnit;
                    Integer num9 = this.useEndTime;
                    Integer num10 = this.useStartTime;
                    Integer num11 = this.userCouponReceiveStatus;
                    Byte b5 = this.userLevel;
                    return "Coupon(couponId=" + str + ", couponName=" + str2 + ", couponStatus=" + str3 + ", couponStatusMsg=" + str4 + ", couponType=" + b + ", couponTypeComb=" + str5 + ", couponTypeDesc=" + str6 + ", couponTypeName=" + str7 + ", discount=" + num + ", discountCondition=" + num2 + ", discountLayer=" + b2 + ", discountLimit=" + num3 + ", discountY=" + d + ", extraInfo=" + str8 + ", maxNumPerUser=" + num4 + ", newUserLimit=" + b3 + ", owners=" + str9 + ", ownersName=" + str10 + ", receiveChannel=" + str11 + ", receiveEndTime=" + num5 + ", receiveStartTime=" + num6 + ", regTime=" + num7 + ", sceneId=" + str12 + ", shopLabel=" + str13 + ", showName=" + str14 + ", sourceAuthorityId=" + str15 + ", sourceId=" + str16 + ", useEffectDays=" + num8 + ", useEffectUnit=" + b4 + ", useEndTime=" + num9 + ", useStartTime=" + num10 + ", userCouponReceiveStatus=" + num11 + ", userLevel=" + b5 + ", vipType=" + this.vipType + ")";
                }

                /* compiled from: ActivityInfoFloor.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$Coupon$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$Coupon;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<Coupon> serializer() {
                        return ActivityInfoFloor$ActivityExtInfo$LowestSkuReducedPrice$Coupon$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ Coupon(int seen0, int seen1, String couponId, String couponName, String couponStatus, String couponStatusMsg, Byte couponType, String couponTypeComb, String couponTypeDesc, String couponTypeName, Integer discount, Integer discountCondition, Byte discountLayer, Integer discountLimit, Double discountY, String extraInfo, Integer maxNumPerUser, Byte newUserLimit, String owners, String ownersName, String receiveChannel, Integer receiveEndTime, Integer receiveStartTime, Integer regTime, String sceneId, String shopLabel, String showName, String sourceAuthorityId, String sourceId, Integer useEffectDays, Byte useEffectUnit, Integer useEndTime, Integer useStartTime, Integer userCouponReceiveStatus, Byte userLevel, String vipType, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.couponId = null;
                    } else {
                        this.couponId = couponId;
                    }
                    if ((seen0 & 2) == 0) {
                        this.couponName = null;
                    } else {
                        this.couponName = couponName;
                    }
                    if ((seen0 & 4) == 0) {
                        this.couponStatus = null;
                    } else {
                        this.couponStatus = couponStatus;
                    }
                    if ((seen0 & 8) == 0) {
                        this.couponStatusMsg = null;
                    } else {
                        this.couponStatusMsg = couponStatusMsg;
                    }
                    if ((seen0 & 16) == 0) {
                        this.couponType = null;
                    } else {
                        this.couponType = couponType;
                    }
                    if ((seen0 & 32) == 0) {
                        this.couponTypeComb = null;
                    } else {
                        this.couponTypeComb = couponTypeComb;
                    }
                    if ((seen0 & 64) == 0) {
                        this.couponTypeDesc = null;
                    } else {
                        this.couponTypeDesc = couponTypeDesc;
                    }
                    if ((seen0 & 128) == 0) {
                        this.couponTypeName = null;
                    } else {
                        this.couponTypeName = couponTypeName;
                    }
                    if ((seen0 & 256) == 0) {
                        this.discount = null;
                    } else {
                        this.discount = discount;
                    }
                    if ((seen0 & 512) == 0) {
                        this.discountCondition = null;
                    } else {
                        this.discountCondition = discountCondition;
                    }
                    if ((seen0 & 1024) == 0) {
                        this.discountLayer = null;
                    } else {
                        this.discountLayer = discountLayer;
                    }
                    if ((seen0 & 2048) == 0) {
                        this.discountLimit = null;
                    } else {
                        this.discountLimit = discountLimit;
                    }
                    if ((seen0 & 4096) == 0) {
                        this.discountY = null;
                    } else {
                        this.discountY = discountY;
                    }
                    if ((seen0 & 8192) == 0) {
                        this.extraInfo = null;
                    } else {
                        this.extraInfo = extraInfo;
                    }
                    if ((seen0 & 16384) == 0) {
                        this.maxNumPerUser = null;
                    } else {
                        this.maxNumPerUser = maxNumPerUser;
                    }
                    if ((seen0 & 32768) == 0) {
                        this.newUserLimit = null;
                    } else {
                        this.newUserLimit = newUserLimit;
                    }
                    if ((seen0 & 65536) == 0) {
                        this.owners = null;
                    } else {
                        this.owners = owners;
                    }
                    if ((seen0 & 131072) == 0) {
                        this.ownersName = null;
                    } else {
                        this.ownersName = ownersName;
                    }
                    if ((seen0 & 262144) == 0) {
                        this.receiveChannel = null;
                    } else {
                        this.receiveChannel = receiveChannel;
                    }
                    if ((seen0 & 524288) == 0) {
                        this.receiveEndTime = null;
                    } else {
                        this.receiveEndTime = receiveEndTime;
                    }
                    if ((seen0 & 1048576) == 0) {
                        this.receiveStartTime = null;
                    } else {
                        this.receiveStartTime = receiveStartTime;
                    }
                    if ((seen0 & 2097152) == 0) {
                        this.regTime = null;
                    } else {
                        this.regTime = regTime;
                    }
                    if ((seen0 & 4194304) == 0) {
                        this.sceneId = null;
                    } else {
                        this.sceneId = sceneId;
                    }
                    if ((seen0 & 8388608) == 0) {
                        this.shopLabel = null;
                    } else {
                        this.shopLabel = shopLabel;
                    }
                    if ((seen0 & 16777216) == 0) {
                        this.showName = null;
                    } else {
                        this.showName = showName;
                    }
                    if ((seen0 & 33554432) == 0) {
                        this.sourceAuthorityId = null;
                    } else {
                        this.sourceAuthorityId = sourceAuthorityId;
                    }
                    if ((seen0 & 67108864) == 0) {
                        this.sourceId = null;
                    } else {
                        this.sourceId = sourceId;
                    }
                    if ((seen0 & 134217728) == 0) {
                        this.useEffectDays = null;
                    } else {
                        this.useEffectDays = useEffectDays;
                    }
                    if ((seen0 & 268435456) == 0) {
                        this.useEffectUnit = null;
                    } else {
                        this.useEffectUnit = useEffectUnit;
                    }
                    if ((seen0 & 536870912) == 0) {
                        this.useEndTime = null;
                    } else {
                        this.useEndTime = useEndTime;
                    }
                    if ((seen0 & 1073741824) == 0) {
                        this.useStartTime = null;
                    } else {
                        this.useStartTime = useStartTime;
                    }
                    if ((seen0 & Integer.MIN_VALUE) == 0) {
                        this.userCouponReceiveStatus = null;
                    } else {
                        this.userCouponReceiveStatus = userCouponReceiveStatus;
                    }
                    if ((seen1 & 1) == 0) {
                        this.userLevel = null;
                    } else {
                        this.userLevel = userLevel;
                    }
                    if ((seen1 & 2) == 0) {
                        this.vipType = null;
                    } else {
                        this.vipType = vipType;
                    }
                }

                public Coupon(String couponId, String couponName, String couponStatus, String couponStatusMsg, Byte couponType, String couponTypeComb, String couponTypeDesc, String couponTypeName, Integer discount, Integer discountCondition, Byte discountLayer, Integer discountLimit, Double discountY, String extraInfo, Integer maxNumPerUser, Byte newUserLimit, String owners, String ownersName, String receiveChannel, Integer receiveEndTime, Integer receiveStartTime, Integer regTime, String sceneId, String shopLabel, String showName, String sourceAuthorityId, String sourceId, Integer useEffectDays, Byte useEffectUnit, Integer useEndTime, Integer useStartTime, Integer userCouponReceiveStatus, Byte userLevel, String vipType) {
                    this.couponId = couponId;
                    this.couponName = couponName;
                    this.couponStatus = couponStatus;
                    this.couponStatusMsg = couponStatusMsg;
                    this.couponType = couponType;
                    this.couponTypeComb = couponTypeComb;
                    this.couponTypeDesc = couponTypeDesc;
                    this.couponTypeName = couponTypeName;
                    this.discount = discount;
                    this.discountCondition = discountCondition;
                    this.discountLayer = discountLayer;
                    this.discountLimit = discountLimit;
                    this.discountY = discountY;
                    this.extraInfo = extraInfo;
                    this.maxNumPerUser = maxNumPerUser;
                    this.newUserLimit = newUserLimit;
                    this.owners = owners;
                    this.ownersName = ownersName;
                    this.receiveChannel = receiveChannel;
                    this.receiveEndTime = receiveEndTime;
                    this.receiveStartTime = receiveStartTime;
                    this.regTime = regTime;
                    this.sceneId = sceneId;
                    this.shopLabel = shopLabel;
                    this.showName = showName;
                    this.sourceAuthorityId = sourceAuthorityId;
                    this.sourceId = sourceId;
                    this.useEffectDays = useEffectDays;
                    this.useEffectUnit = useEffectUnit;
                    this.useEndTime = useEndTime;
                    this.useStartTime = useStartTime;
                    this.userCouponReceiveStatus = userCouponReceiveStatus;
                    this.userLevel = userLevel;
                    this.vipType = vipType;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(Coupon self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.couponId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.couponId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.couponName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.couponName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.couponStatus != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.couponStatus);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.couponStatusMsg != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.couponStatusMsg);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.couponType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 4, ByteSerializer.INSTANCE, self.couponType);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.couponTypeComb != null) {
                        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.couponTypeComb);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.couponTypeDesc != null) {
                        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.couponTypeDesc);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 7) || self.couponTypeName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.couponTypeName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 8) || self.discount != null) {
                        output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.discount);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 9) || self.discountCondition != null) {
                        output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.discountCondition);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 10) || self.discountLayer != null) {
                        output.encodeNullableSerializableElement(serialDesc, 10, ByteSerializer.INSTANCE, self.discountLayer);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 11) || self.discountLimit != null) {
                        output.encodeNullableSerializableElement(serialDesc, 11, IntSerializer.INSTANCE, self.discountLimit);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 12) || self.discountY != null) {
                        output.encodeNullableSerializableElement(serialDesc, 12, DoubleSerializer.INSTANCE, self.discountY);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 13) || self.extraInfo != null) {
                        output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.extraInfo);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 14) || self.maxNumPerUser != null) {
                        output.encodeNullableSerializableElement(serialDesc, 14, IntSerializer.INSTANCE, self.maxNumPerUser);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 15) || self.newUserLimit != null) {
                        output.encodeNullableSerializableElement(serialDesc, 15, ByteSerializer.INSTANCE, self.newUserLimit);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 16) || self.owners != null) {
                        output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.owners);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 17) || self.ownersName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.ownersName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 18) || self.receiveChannel != null) {
                        output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.receiveChannel);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 19) || self.receiveEndTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 19, IntSerializer.INSTANCE, self.receiveEndTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 20) || self.receiveStartTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 20, IntSerializer.INSTANCE, self.receiveStartTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 21) || self.regTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 21, IntSerializer.INSTANCE, self.regTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 22) || self.sceneId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 22, StringSerializer.INSTANCE, self.sceneId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 23) || self.shopLabel != null) {
                        output.encodeNullableSerializableElement(serialDesc, 23, StringSerializer.INSTANCE, self.shopLabel);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 24) || self.showName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 24, StringSerializer.INSTANCE, self.showName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 25) || self.sourceAuthorityId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 25, StringSerializer.INSTANCE, self.sourceAuthorityId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 26) || self.sourceId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 26, StringSerializer.INSTANCE, self.sourceId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 27) || self.useEffectDays != null) {
                        output.encodeNullableSerializableElement(serialDesc, 27, IntSerializer.INSTANCE, self.useEffectDays);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 28) || self.useEffectUnit != null) {
                        output.encodeNullableSerializableElement(serialDesc, 28, ByteSerializer.INSTANCE, self.useEffectUnit);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 29) || self.useEndTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 29, IntSerializer.INSTANCE, self.useEndTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 30) || self.useStartTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 30, IntSerializer.INSTANCE, self.useStartTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 31) || self.userCouponReceiveStatus != null) {
                        output.encodeNullableSerializableElement(serialDesc, 31, IntSerializer.INSTANCE, self.userCouponReceiveStatus);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 32) || self.userLevel != null) {
                        output.encodeNullableSerializableElement(serialDesc, 32, ByteSerializer.INSTANCE, self.userLevel);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 33) || self.vipType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 33, StringSerializer.INSTANCE, self.vipType);
                    }
                }

                public /* synthetic */ Coupon(String str, String str2, String str3, String str4, Byte b, String str5, String str6, String str7, Integer num, Integer num2, Byte b2, Integer num3, Double d, String str8, Integer num4, Byte b3, String str9, String str10, String str11, Integer num5, Integer num6, Integer num7, String str12, String str13, String str14, String str15, String str16, Integer num8, Byte b4, Integer num9, Integer num10, Integer num11, Byte b5, String str17, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : b, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : b2, (i & 2048) != 0 ? null : num3, (i & 4096) != 0 ? null : d, (i & 8192) != 0 ? null : str8, (i & 16384) != 0 ? null : num4, (i & 32768) != 0 ? null : b3, (i & 65536) != 0 ? null : str9, (i & 131072) != 0 ? null : str10, (i & 262144) != 0 ? null : str11, (i & 524288) != 0 ? null : num5, (i & 1048576) != 0 ? null : num6, (i & 2097152) != 0 ? null : num7, (i & 4194304) != 0 ? null : str12, (i & 8388608) != 0 ? null : str13, (i & 16777216) != 0 ? null : str14, (i & 33554432) != 0 ? null : str15, (i & 67108864) != 0 ? null : str16, (i & 134217728) != 0 ? null : num8, (i & 268435456) != 0 ? null : b4, (i & 536870912) != 0 ? null : num9, (i & 1073741824) != 0 ? null : num10, (i & Integer.MIN_VALUE) != 0 ? null : num11, (i2 & 1) != 0 ? null : b5, (i2 & 2) != 0 ? null : str17);
                }

                public final String getCouponId() {
                    return this.couponId;
                }

                public final String getCouponName() {
                    return this.couponName;
                }

                public final String getCouponStatus() {
                    return this.couponStatus;
                }

                public final String getCouponStatusMsg() {
                    return this.couponStatusMsg;
                }

                public final Byte getCouponType() {
                    return this.couponType;
                }

                public final String getCouponTypeComb() {
                    return this.couponTypeComb;
                }

                public final String getCouponTypeDesc() {
                    return this.couponTypeDesc;
                }

                public final String getCouponTypeName() {
                    return this.couponTypeName;
                }

                public final Integer getDiscount() {
                    return this.discount;
                }

                public final Integer getDiscountCondition() {
                    return this.discountCondition;
                }

                public final Byte getDiscountLayer() {
                    return this.discountLayer;
                }

                public final Integer getDiscountLimit() {
                    return this.discountLimit;
                }

                public final Double getDiscountY() {
                    return this.discountY;
                }

                public final String getExtraInfo() {
                    return this.extraInfo;
                }

                public final Integer getMaxNumPerUser() {
                    return this.maxNumPerUser;
                }

                public final Byte getNewUserLimit() {
                    return this.newUserLimit;
                }

                public final String getOwners() {
                    return this.owners;
                }

                public final String getOwnersName() {
                    return this.ownersName;
                }

                public final String getReceiveChannel() {
                    return this.receiveChannel;
                }

                public final Integer getReceiveEndTime() {
                    return this.receiveEndTime;
                }

                public final Integer getReceiveStartTime() {
                    return this.receiveStartTime;
                }

                public final Integer getRegTime() {
                    return this.regTime;
                }

                public final String getSceneId() {
                    return this.sceneId;
                }

                public final String getShopLabel() {
                    return this.shopLabel;
                }

                public final String getShowName() {
                    return this.showName;
                }

                public final String getSourceAuthorityId() {
                    return this.sourceAuthorityId;
                }

                public final String getSourceId() {
                    return this.sourceId;
                }

                public final Integer getUseEffectDays() {
                    return this.useEffectDays;
                }

                public final Byte getUseEffectUnit() {
                    return this.useEffectUnit;
                }

                public final Integer getUseEndTime() {
                    return this.useEndTime;
                }

                public final Integer getUseStartTime() {
                    return this.useStartTime;
                }

                public final Integer getUserCouponReceiveStatus() {
                    return this.userCouponReceiveStatus;
                }

                public final Byte getUserLevel() {
                    return this.userLevel;
                }

                public final String getVipType() {
                    return this.vipType;
                }
            }

            public final Double getReducedYPrice() {
                return this.reducedYPrice;
            }
        }

        public final NewUserCoupon getNewUserCouponDTO() {
            return this.newUserCouponDTO;
        }

        /* compiled from: ActivityInfoFloor.kt */
        @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\bW\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u008f\u00012\u00020\u0001:\u0004\u008e\u0001\u008f\u0001B«\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b*\u0010+B\u0081\u0003\b\u0010\u0012\u0006\u0010,\u001a\u00020\r\u0012\u0006\u0010-\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\r\u0012\b\u0010$\u001a\u0004\u0018\u00010\b\u0012\b\u0010%\u001a\u0004\u0018\u00010\r\u0012\b\u0010&\u001a\u0004\u0018\u00010\r\u0012\b\u0010'\u001a\u0004\u0018\u00010\r\u0012\b\u0010(\u001a\u0004\u0018\u00010\b\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010.\u001a\u0004\u0018\u00010/¢\u0006\u0004\b*\u00100J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010f\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010g\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010h\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010i\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010CJ\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010k\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010GJ\u0010\u0010l\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010m\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010q\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010r\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010s\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010=J\u000b\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010y\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010z\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010{\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010|\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010}\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010~\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J´\u0003\u0010\u0080\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010\u0081\u0001J\u0015\u0010\u0082\u0001\u001a\u00020\u00152\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0084\u0001\u001a\u00020\rHÖ\u0001J\n\u0010\u0085\u0001\u001a\u00020\u0003HÖ\u0001J-\u0010\u0086\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0088\u0001\u001a\u00020\u00002\b\u0010\u0089\u0001\u001a\u00030\u008a\u00012\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0001¢\u0006\u0003\b\u008d\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u00102R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u00102R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u00102R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u00102R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u00102R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010>\u001a\u0004\b<\u0010=R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010>\u001a\u0004\b?\u0010=R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00108\u001a\u0004\b@\u00107R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010>\u001a\u0004\bA\u0010=R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010D\u001a\u0004\bB\u0010CR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u00102R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010H\u001a\u0004\bF\u0010GR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010>\u001a\u0004\bI\u0010=R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00108\u001a\u0004\bJ\u00107R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u00102R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u00102R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bM\u00102R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010>\u001a\u0004\bN\u0010=R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010>\u001a\u0004\bO\u0010=R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010>\u001a\u0004\bP\u0010=R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u00102R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u00102R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u00102R\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bT\u00102R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u00102R\u0015\u0010#\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010>\u001a\u0004\bV\u0010=R\u0015\u0010$\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00108\u001a\u0004\bW\u00107R\u0015\u0010%\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010>\u001a\u0004\bX\u0010=R\u0015\u0010&\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010>\u001a\u0004\bY\u0010=R\u0015\u0010'\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010>\u001a\u0004\bZ\u0010=R\u0015\u0010(\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00108\u001a\u0004\b[\u00107R\u0013\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\\\u00102¨\u0006\u0090\u0001"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$NewUserCoupon;", "", "couponId", "", "couponName", "couponStatus", "couponStatusMsg", "couponType", "", "couponTypeComb", "couponTypeDesc", "couponTypeName", "discount", "", "discountCondition", "discountLayer", "discountLimit", "discountY", "", "extraInfo", "hasNewUserCoupon", "", "maxNumPerUser", "newUserLimit", "owners", "ownersName", "receiveChannel", "receiveEndTime", "receiveStartTime", "regTime", "sceneId", "shopLabel", "showName", "sourceAuthorityId", "sourceId", "useEffectDays", "useEffectUnit", "useEndTime", "useStartTime", "userCouponReceiveStatus", "userLevel", "vipType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;)V", "seen0", "seen1", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCouponId", "()Ljava/lang/String;", "getCouponName", "getCouponStatus", "getCouponStatusMsg", "getCouponType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getCouponTypeComb", "getCouponTypeDesc", "getCouponTypeName", "getDiscount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDiscountCondition", "getDiscountLayer", "getDiscountLimit", "getDiscountY", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getExtraInfo", "getHasNewUserCoupon", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMaxNumPerUser", "getNewUserLimit", "getOwners", "getOwnersName", "getReceiveChannel", "getReceiveEndTime", "getReceiveStartTime", "getRegTime", "getSceneId", "getShopLabel", "getShowName", "getSourceAuthorityId", "getSourceId", "getUseEffectDays", "getUseEffectUnit", "getUseEndTime", "getUseStartTime", "getUserCouponReceiveStatus", "getUserLevel", "getVipType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$NewUserCoupon;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class NewUserCoupon {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String couponId;
            private final String couponName;
            private final String couponStatus;
            private final String couponStatusMsg;
            private final Byte couponType;
            private final String couponTypeComb;
            private final String couponTypeDesc;
            private final String couponTypeName;
            private final Integer discount;
            private final Integer discountCondition;
            private final Byte discountLayer;
            private final Integer discountLimit;
            private final Double discountY;
            private final String extraInfo;
            private final Boolean hasNewUserCoupon;
            private final Integer maxNumPerUser;
            private final Byte newUserLimit;
            private final String owners;
            private final String ownersName;
            private final String receiveChannel;
            private final Integer receiveEndTime;
            private final Integer receiveStartTime;
            private final Integer regTime;
            private final String sceneId;
            private final String shopLabel;
            private final String showName;
            private final String sourceAuthorityId;
            private final String sourceId;
            private final Integer useEffectDays;
            private final Byte useEffectUnit;
            private final Integer useEndTime;
            private final Integer useStartTime;
            private final Integer userCouponReceiveStatus;
            private final Byte userLevel;
            private final String vipType;

            public NewUserCoupon() {
                this((String) null, (String) null, (String) null, (String) null, (Byte) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Byte) null, (Integer) null, (Double) null, (String) null, (Boolean) null, (Integer) null, (Byte) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Byte) null, (Integer) null, (Integer) null, (Integer) null, (Byte) null, (String) null, -1, 7, (DefaultConstructorMarker) null);
            }

            public final String component1() {
                return this.couponId;
            }

            public final Integer component10() {
                return this.discountCondition;
            }

            public final Byte component11() {
                return this.discountLayer;
            }

            public final Integer component12() {
                return this.discountLimit;
            }

            public final Double component13() {
                return this.discountY;
            }

            public final String component14() {
                return this.extraInfo;
            }

            public final Boolean component15() {
                return this.hasNewUserCoupon;
            }

            public final Integer component16() {
                return this.maxNumPerUser;
            }

            public final Byte component17() {
                return this.newUserLimit;
            }

            public final String component18() {
                return this.owners;
            }

            public final String component19() {
                return this.ownersName;
            }

            public final String component2() {
                return this.couponName;
            }

            public final String component20() {
                return this.receiveChannel;
            }

            public final Integer component21() {
                return this.receiveEndTime;
            }

            public final Integer component22() {
                return this.receiveStartTime;
            }

            public final Integer component23() {
                return this.regTime;
            }

            public final String component24() {
                return this.sceneId;
            }

            public final String component25() {
                return this.shopLabel;
            }

            public final String component26() {
                return this.showName;
            }

            public final String component27() {
                return this.sourceAuthorityId;
            }

            public final String component28() {
                return this.sourceId;
            }

            public final Integer component29() {
                return this.useEffectDays;
            }

            public final String component3() {
                return this.couponStatus;
            }

            public final Byte component30() {
                return this.useEffectUnit;
            }

            public final Integer component31() {
                return this.useEndTime;
            }

            public final Integer component32() {
                return this.useStartTime;
            }

            public final Integer component33() {
                return this.userCouponReceiveStatus;
            }

            public final Byte component34() {
                return this.userLevel;
            }

            public final String component35() {
                return this.vipType;
            }

            public final String component4() {
                return this.couponStatusMsg;
            }

            public final Byte component5() {
                return this.couponType;
            }

            public final String component6() {
                return this.couponTypeComb;
            }

            public final String component7() {
                return this.couponTypeDesc;
            }

            public final String component8() {
                return this.couponTypeName;
            }

            public final Integer component9() {
                return this.discount;
            }

            public final NewUserCoupon copy(String str, String str2, String str3, String str4, Byte b, String str5, String str6, String str7, Integer num, Integer num2, Byte b2, Integer num3, Double d, String str8, Boolean bool, Integer num4, Byte b3, String str9, String str10, String str11, Integer num5, Integer num6, Integer num7, String str12, String str13, String str14, String str15, String str16, Integer num8, Byte b4, Integer num9, Integer num10, Integer num11, Byte b5, String str17) {
                return new NewUserCoupon(str, str2, str3, str4, b, str5, str6, str7, num, num2, b2, num3, d, str8, bool, num4, b3, str9, str10, str11, num5, num6, num7, str12, str13, str14, str15, str16, num8, b4, num9, num10, num11, b5, str17);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof NewUserCoupon) {
                    NewUserCoupon newUserCoupon = (NewUserCoupon) obj;
                    return Intrinsics.areEqual(this.couponId, newUserCoupon.couponId) && Intrinsics.areEqual(this.couponName, newUserCoupon.couponName) && Intrinsics.areEqual(this.couponStatus, newUserCoupon.couponStatus) && Intrinsics.areEqual(this.couponStatusMsg, newUserCoupon.couponStatusMsg) && Intrinsics.areEqual(this.couponType, newUserCoupon.couponType) && Intrinsics.areEqual(this.couponTypeComb, newUserCoupon.couponTypeComb) && Intrinsics.areEqual(this.couponTypeDesc, newUserCoupon.couponTypeDesc) && Intrinsics.areEqual(this.couponTypeName, newUserCoupon.couponTypeName) && Intrinsics.areEqual(this.discount, newUserCoupon.discount) && Intrinsics.areEqual(this.discountCondition, newUserCoupon.discountCondition) && Intrinsics.areEqual(this.discountLayer, newUserCoupon.discountLayer) && Intrinsics.areEqual(this.discountLimit, newUserCoupon.discountLimit) && Intrinsics.areEqual(this.discountY, newUserCoupon.discountY) && Intrinsics.areEqual(this.extraInfo, newUserCoupon.extraInfo) && Intrinsics.areEqual(this.hasNewUserCoupon, newUserCoupon.hasNewUserCoupon) && Intrinsics.areEqual(this.maxNumPerUser, newUserCoupon.maxNumPerUser) && Intrinsics.areEqual(this.newUserLimit, newUserCoupon.newUserLimit) && Intrinsics.areEqual(this.owners, newUserCoupon.owners) && Intrinsics.areEqual(this.ownersName, newUserCoupon.ownersName) && Intrinsics.areEqual(this.receiveChannel, newUserCoupon.receiveChannel) && Intrinsics.areEqual(this.receiveEndTime, newUserCoupon.receiveEndTime) && Intrinsics.areEqual(this.receiveStartTime, newUserCoupon.receiveStartTime) && Intrinsics.areEqual(this.regTime, newUserCoupon.regTime) && Intrinsics.areEqual(this.sceneId, newUserCoupon.sceneId) && Intrinsics.areEqual(this.shopLabel, newUserCoupon.shopLabel) && Intrinsics.areEqual(this.showName, newUserCoupon.showName) && Intrinsics.areEqual(this.sourceAuthorityId, newUserCoupon.sourceAuthorityId) && Intrinsics.areEqual(this.sourceId, newUserCoupon.sourceId) && Intrinsics.areEqual(this.useEffectDays, newUserCoupon.useEffectDays) && Intrinsics.areEqual(this.useEffectUnit, newUserCoupon.useEffectUnit) && Intrinsics.areEqual(this.useEndTime, newUserCoupon.useEndTime) && Intrinsics.areEqual(this.useStartTime, newUserCoupon.useStartTime) && Intrinsics.areEqual(this.userCouponReceiveStatus, newUserCoupon.userCouponReceiveStatus) && Intrinsics.areEqual(this.userLevel, newUserCoupon.userLevel) && Intrinsics.areEqual(this.vipType, newUserCoupon.vipType);
                }
                return false;
            }

            public int hashCode() {
                return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.couponId == null ? 0 : this.couponId.hashCode()) * 31) + (this.couponName == null ? 0 : this.couponName.hashCode())) * 31) + (this.couponStatus == null ? 0 : this.couponStatus.hashCode())) * 31) + (this.couponStatusMsg == null ? 0 : this.couponStatusMsg.hashCode())) * 31) + (this.couponType == null ? 0 : this.couponType.hashCode())) * 31) + (this.couponTypeComb == null ? 0 : this.couponTypeComb.hashCode())) * 31) + (this.couponTypeDesc == null ? 0 : this.couponTypeDesc.hashCode())) * 31) + (this.couponTypeName == null ? 0 : this.couponTypeName.hashCode())) * 31) + (this.discount == null ? 0 : this.discount.hashCode())) * 31) + (this.discountCondition == null ? 0 : this.discountCondition.hashCode())) * 31) + (this.discountLayer == null ? 0 : this.discountLayer.hashCode())) * 31) + (this.discountLimit == null ? 0 : this.discountLimit.hashCode())) * 31) + (this.discountY == null ? 0 : this.discountY.hashCode())) * 31) + (this.extraInfo == null ? 0 : this.extraInfo.hashCode())) * 31) + (this.hasNewUserCoupon == null ? 0 : this.hasNewUserCoupon.hashCode())) * 31) + (this.maxNumPerUser == null ? 0 : this.maxNumPerUser.hashCode())) * 31) + (this.newUserLimit == null ? 0 : this.newUserLimit.hashCode())) * 31) + (this.owners == null ? 0 : this.owners.hashCode())) * 31) + (this.ownersName == null ? 0 : this.ownersName.hashCode())) * 31) + (this.receiveChannel == null ? 0 : this.receiveChannel.hashCode())) * 31) + (this.receiveEndTime == null ? 0 : this.receiveEndTime.hashCode())) * 31) + (this.receiveStartTime == null ? 0 : this.receiveStartTime.hashCode())) * 31) + (this.regTime == null ? 0 : this.regTime.hashCode())) * 31) + (this.sceneId == null ? 0 : this.sceneId.hashCode())) * 31) + (this.shopLabel == null ? 0 : this.shopLabel.hashCode())) * 31) + (this.showName == null ? 0 : this.showName.hashCode())) * 31) + (this.sourceAuthorityId == null ? 0 : this.sourceAuthorityId.hashCode())) * 31) + (this.sourceId == null ? 0 : this.sourceId.hashCode())) * 31) + (this.useEffectDays == null ? 0 : this.useEffectDays.hashCode())) * 31) + (this.useEffectUnit == null ? 0 : this.useEffectUnit.hashCode())) * 31) + (this.useEndTime == null ? 0 : this.useEndTime.hashCode())) * 31) + (this.useStartTime == null ? 0 : this.useStartTime.hashCode())) * 31) + (this.userCouponReceiveStatus == null ? 0 : this.userCouponReceiveStatus.hashCode())) * 31) + (this.userLevel == null ? 0 : this.userLevel.hashCode())) * 31) + (this.vipType != null ? this.vipType.hashCode() : 0);
            }

            public String toString() {
                String str = this.couponId;
                String str2 = this.couponName;
                String str3 = this.couponStatus;
                String str4 = this.couponStatusMsg;
                Byte b = this.couponType;
                String str5 = this.couponTypeComb;
                String str6 = this.couponTypeDesc;
                String str7 = this.couponTypeName;
                Integer num = this.discount;
                Integer num2 = this.discountCondition;
                Byte b2 = this.discountLayer;
                Integer num3 = this.discountLimit;
                Double d = this.discountY;
                String str8 = this.extraInfo;
                Boolean bool = this.hasNewUserCoupon;
                Integer num4 = this.maxNumPerUser;
                Byte b3 = this.newUserLimit;
                String str9 = this.owners;
                String str10 = this.ownersName;
                String str11 = this.receiveChannel;
                Integer num5 = this.receiveEndTime;
                Integer num6 = this.receiveStartTime;
                Integer num7 = this.regTime;
                String str12 = this.sceneId;
                String str13 = this.shopLabel;
                String str14 = this.showName;
                String str15 = this.sourceAuthorityId;
                String str16 = this.sourceId;
                Integer num8 = this.useEffectDays;
                Byte b4 = this.useEffectUnit;
                Integer num9 = this.useEndTime;
                Integer num10 = this.useStartTime;
                Integer num11 = this.userCouponReceiveStatus;
                Byte b5 = this.userLevel;
                return "NewUserCoupon(couponId=" + str + ", couponName=" + str2 + ", couponStatus=" + str3 + ", couponStatusMsg=" + str4 + ", couponType=" + b + ", couponTypeComb=" + str5 + ", couponTypeDesc=" + str6 + ", couponTypeName=" + str7 + ", discount=" + num + ", discountCondition=" + num2 + ", discountLayer=" + b2 + ", discountLimit=" + num3 + ", discountY=" + d + ", extraInfo=" + str8 + ", hasNewUserCoupon=" + bool + ", maxNumPerUser=" + num4 + ", newUserLimit=" + b3 + ", owners=" + str9 + ", ownersName=" + str10 + ", receiveChannel=" + str11 + ", receiveEndTime=" + num5 + ", receiveStartTime=" + num6 + ", regTime=" + num7 + ", sceneId=" + str12 + ", shopLabel=" + str13 + ", showName=" + str14 + ", sourceAuthorityId=" + str15 + ", sourceId=" + str16 + ", useEffectDays=" + num8 + ", useEffectUnit=" + b4 + ", useEndTime=" + num9 + ", useStartTime=" + num10 + ", userCouponReceiveStatus=" + num11 + ", userLevel=" + b5 + ", vipType=" + this.vipType + ")";
            }

            /* compiled from: ActivityInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$NewUserCoupon$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityExtInfo$NewUserCoupon;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<NewUserCoupon> serializer() {
                    return ActivityInfoFloor$ActivityExtInfo$NewUserCoupon$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ NewUserCoupon(int seen0, int seen1, String couponId, String couponName, String couponStatus, String couponStatusMsg, Byte couponType, String couponTypeComb, String couponTypeDesc, String couponTypeName, Integer discount, Integer discountCondition, Byte discountLayer, Integer discountLimit, Double discountY, String extraInfo, Boolean hasNewUserCoupon, Integer maxNumPerUser, Byte newUserLimit, String owners, String ownersName, String receiveChannel, Integer receiveEndTime, Integer receiveStartTime, Integer regTime, String sceneId, String shopLabel, String showName, String sourceAuthorityId, String sourceId, Integer useEffectDays, Byte useEffectUnit, Integer useEndTime, Integer useStartTime, Integer userCouponReceiveStatus, Byte userLevel, String vipType, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.couponId = null;
                } else {
                    this.couponId = couponId;
                }
                if ((seen0 & 2) == 0) {
                    this.couponName = null;
                } else {
                    this.couponName = couponName;
                }
                if ((seen0 & 4) == 0) {
                    this.couponStatus = null;
                } else {
                    this.couponStatus = couponStatus;
                }
                if ((seen0 & 8) == 0) {
                    this.couponStatusMsg = null;
                } else {
                    this.couponStatusMsg = couponStatusMsg;
                }
                if ((seen0 & 16) == 0) {
                    this.couponType = null;
                } else {
                    this.couponType = couponType;
                }
                if ((seen0 & 32) == 0) {
                    this.couponTypeComb = null;
                } else {
                    this.couponTypeComb = couponTypeComb;
                }
                if ((seen0 & 64) == 0) {
                    this.couponTypeDesc = null;
                } else {
                    this.couponTypeDesc = couponTypeDesc;
                }
                if ((seen0 & 128) == 0) {
                    this.couponTypeName = null;
                } else {
                    this.couponTypeName = couponTypeName;
                }
                if ((seen0 & 256) == 0) {
                    this.discount = null;
                } else {
                    this.discount = discount;
                }
                if ((seen0 & 512) == 0) {
                    this.discountCondition = null;
                } else {
                    this.discountCondition = discountCondition;
                }
                if ((seen0 & 1024) == 0) {
                    this.discountLayer = null;
                } else {
                    this.discountLayer = discountLayer;
                }
                if ((seen0 & 2048) == 0) {
                    this.discountLimit = null;
                } else {
                    this.discountLimit = discountLimit;
                }
                if ((seen0 & 4096) == 0) {
                    this.discountY = null;
                } else {
                    this.discountY = discountY;
                }
                if ((seen0 & 8192) == 0) {
                    this.extraInfo = null;
                } else {
                    this.extraInfo = extraInfo;
                }
                if ((seen0 & 16384) == 0) {
                    this.hasNewUserCoupon = null;
                } else {
                    this.hasNewUserCoupon = hasNewUserCoupon;
                }
                if ((seen0 & 32768) == 0) {
                    this.maxNumPerUser = null;
                } else {
                    this.maxNumPerUser = maxNumPerUser;
                }
                if ((seen0 & 65536) == 0) {
                    this.newUserLimit = null;
                } else {
                    this.newUserLimit = newUserLimit;
                }
                if ((seen0 & 131072) == 0) {
                    this.owners = null;
                } else {
                    this.owners = owners;
                }
                if ((seen0 & 262144) == 0) {
                    this.ownersName = null;
                } else {
                    this.ownersName = ownersName;
                }
                if ((seen0 & 524288) == 0) {
                    this.receiveChannel = null;
                } else {
                    this.receiveChannel = receiveChannel;
                }
                if ((seen0 & 1048576) == 0) {
                    this.receiveEndTime = null;
                } else {
                    this.receiveEndTime = receiveEndTime;
                }
                if ((seen0 & 2097152) == 0) {
                    this.receiveStartTime = null;
                } else {
                    this.receiveStartTime = receiveStartTime;
                }
                if ((seen0 & 4194304) == 0) {
                    this.regTime = null;
                } else {
                    this.regTime = regTime;
                }
                if ((seen0 & 8388608) == 0) {
                    this.sceneId = null;
                } else {
                    this.sceneId = sceneId;
                }
                if ((seen0 & 16777216) == 0) {
                    this.shopLabel = null;
                } else {
                    this.shopLabel = shopLabel;
                }
                if ((seen0 & 33554432) == 0) {
                    this.showName = null;
                } else {
                    this.showName = showName;
                }
                if ((seen0 & 67108864) == 0) {
                    this.sourceAuthorityId = null;
                } else {
                    this.sourceAuthorityId = sourceAuthorityId;
                }
                if ((seen0 & 134217728) == 0) {
                    this.sourceId = null;
                } else {
                    this.sourceId = sourceId;
                }
                if ((seen0 & 268435456) == 0) {
                    this.useEffectDays = null;
                } else {
                    this.useEffectDays = useEffectDays;
                }
                if ((seen0 & 536870912) == 0) {
                    this.useEffectUnit = null;
                } else {
                    this.useEffectUnit = useEffectUnit;
                }
                if ((seen0 & 1073741824) == 0) {
                    this.useEndTime = null;
                } else {
                    this.useEndTime = useEndTime;
                }
                if ((seen0 & Integer.MIN_VALUE) == 0) {
                    this.useStartTime = null;
                } else {
                    this.useStartTime = useStartTime;
                }
                if ((seen1 & 1) == 0) {
                    this.userCouponReceiveStatus = null;
                } else {
                    this.userCouponReceiveStatus = userCouponReceiveStatus;
                }
                if ((seen1 & 2) == 0) {
                    this.userLevel = null;
                } else {
                    this.userLevel = userLevel;
                }
                if ((seen1 & 4) == 0) {
                    this.vipType = null;
                } else {
                    this.vipType = vipType;
                }
            }

            public NewUserCoupon(String couponId, String couponName, String couponStatus, String couponStatusMsg, Byte couponType, String couponTypeComb, String couponTypeDesc, String couponTypeName, Integer discount, Integer discountCondition, Byte discountLayer, Integer discountLimit, Double discountY, String extraInfo, Boolean hasNewUserCoupon, Integer maxNumPerUser, Byte newUserLimit, String owners, String ownersName, String receiveChannel, Integer receiveEndTime, Integer receiveStartTime, Integer regTime, String sceneId, String shopLabel, String showName, String sourceAuthorityId, String sourceId, Integer useEffectDays, Byte useEffectUnit, Integer useEndTime, Integer useStartTime, Integer userCouponReceiveStatus, Byte userLevel, String vipType) {
                this.couponId = couponId;
                this.couponName = couponName;
                this.couponStatus = couponStatus;
                this.couponStatusMsg = couponStatusMsg;
                this.couponType = couponType;
                this.couponTypeComb = couponTypeComb;
                this.couponTypeDesc = couponTypeDesc;
                this.couponTypeName = couponTypeName;
                this.discount = discount;
                this.discountCondition = discountCondition;
                this.discountLayer = discountLayer;
                this.discountLimit = discountLimit;
                this.discountY = discountY;
                this.extraInfo = extraInfo;
                this.hasNewUserCoupon = hasNewUserCoupon;
                this.maxNumPerUser = maxNumPerUser;
                this.newUserLimit = newUserLimit;
                this.owners = owners;
                this.ownersName = ownersName;
                this.receiveChannel = receiveChannel;
                this.receiveEndTime = receiveEndTime;
                this.receiveStartTime = receiveStartTime;
                this.regTime = regTime;
                this.sceneId = sceneId;
                this.shopLabel = shopLabel;
                this.showName = showName;
                this.sourceAuthorityId = sourceAuthorityId;
                this.sourceId = sourceId;
                this.useEffectDays = useEffectDays;
                this.useEffectUnit = useEffectUnit;
                this.useEndTime = useEndTime;
                this.useStartTime = useStartTime;
                this.userCouponReceiveStatus = userCouponReceiveStatus;
                this.userLevel = userLevel;
                this.vipType = vipType;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(NewUserCoupon self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.couponId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.couponId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.couponName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.couponName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.couponStatus != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.couponStatus);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.couponStatusMsg != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.couponStatusMsg);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.couponType != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, ByteSerializer.INSTANCE, self.couponType);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.couponTypeComb != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.couponTypeComb);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.couponTypeDesc != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.couponTypeDesc);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.couponTypeName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.couponTypeName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.discount != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.discount);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.discountCondition != null) {
                    output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.discountCondition);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 10) || self.discountLayer != null) {
                    output.encodeNullableSerializableElement(serialDesc, 10, ByteSerializer.INSTANCE, self.discountLayer);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 11) || self.discountLimit != null) {
                    output.encodeNullableSerializableElement(serialDesc, 11, IntSerializer.INSTANCE, self.discountLimit);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 12) || self.discountY != null) {
                    output.encodeNullableSerializableElement(serialDesc, 12, DoubleSerializer.INSTANCE, self.discountY);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 13) || self.extraInfo != null) {
                    output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.extraInfo);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 14) || self.hasNewUserCoupon != null) {
                    output.encodeNullableSerializableElement(serialDesc, 14, BooleanSerializer.INSTANCE, self.hasNewUserCoupon);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 15) || self.maxNumPerUser != null) {
                    output.encodeNullableSerializableElement(serialDesc, 15, IntSerializer.INSTANCE, self.maxNumPerUser);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 16) || self.newUserLimit != null) {
                    output.encodeNullableSerializableElement(serialDesc, 16, ByteSerializer.INSTANCE, self.newUserLimit);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 17) || self.owners != null) {
                    output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.owners);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 18) || self.ownersName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.ownersName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 19) || self.receiveChannel != null) {
                    output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.receiveChannel);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 20) || self.receiveEndTime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 20, IntSerializer.INSTANCE, self.receiveEndTime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 21) || self.receiveStartTime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 21, IntSerializer.INSTANCE, self.receiveStartTime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 22) || self.regTime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 22, IntSerializer.INSTANCE, self.regTime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 23) || self.sceneId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 23, StringSerializer.INSTANCE, self.sceneId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 24) || self.shopLabel != null) {
                    output.encodeNullableSerializableElement(serialDesc, 24, StringSerializer.INSTANCE, self.shopLabel);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 25) || self.showName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 25, StringSerializer.INSTANCE, self.showName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 26) || self.sourceAuthorityId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 26, StringSerializer.INSTANCE, self.sourceAuthorityId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 27) || self.sourceId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 27, StringSerializer.INSTANCE, self.sourceId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 28) || self.useEffectDays != null) {
                    output.encodeNullableSerializableElement(serialDesc, 28, IntSerializer.INSTANCE, self.useEffectDays);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 29) || self.useEffectUnit != null) {
                    output.encodeNullableSerializableElement(serialDesc, 29, ByteSerializer.INSTANCE, self.useEffectUnit);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 30) || self.useEndTime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 30, IntSerializer.INSTANCE, self.useEndTime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 31) || self.useStartTime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 31, IntSerializer.INSTANCE, self.useStartTime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 32) || self.userCouponReceiveStatus != null) {
                    output.encodeNullableSerializableElement(serialDesc, 32, IntSerializer.INSTANCE, self.userCouponReceiveStatus);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 33) || self.userLevel != null) {
                    output.encodeNullableSerializableElement(serialDesc, 33, ByteSerializer.INSTANCE, self.userLevel);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 34) || self.vipType != null) {
                    output.encodeNullableSerializableElement(serialDesc, 34, StringSerializer.INSTANCE, self.vipType);
                }
            }

            public /* synthetic */ NewUserCoupon(String str, String str2, String str3, String str4, Byte b, String str5, String str6, String str7, Integer num, Integer num2, Byte b2, Integer num3, Double d, String str8, Boolean bool, Integer num4, Byte b3, String str9, String str10, String str11, Integer num5, Integer num6, Integer num7, String str12, String str13, String str14, String str15, String str16, Integer num8, Byte b4, Integer num9, Integer num10, Integer num11, Byte b5, String str17, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : b, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : b2, (i & 2048) != 0 ? null : num3, (i & 4096) != 0 ? null : d, (i & 8192) != 0 ? null : str8, (i & 16384) != 0 ? null : bool, (i & 32768) != 0 ? null : num4, (i & 65536) != 0 ? null : b3, (i & 131072) != 0 ? null : str9, (i & 262144) != 0 ? null : str10, (i & 524288) != 0 ? null : str11, (i & 1048576) != 0 ? null : num5, (i & 2097152) != 0 ? null : num6, (i & 4194304) != 0 ? null : num7, (i & 8388608) != 0 ? null : str12, (i & 16777216) != 0 ? null : str13, (i & 33554432) != 0 ? null : str14, (i & 67108864) != 0 ? null : str15, (i & 134217728) != 0 ? null : str16, (i & 268435456) != 0 ? null : num8, (i & 536870912) != 0 ? null : b4, (i & 1073741824) != 0 ? null : num9, (i & Integer.MIN_VALUE) != 0 ? null : num10, (i2 & 1) != 0 ? null : num11, (i2 & 2) != 0 ? null : b5, (i2 & 4) != 0 ? null : str17);
            }

            public final String getCouponId() {
                return this.couponId;
            }

            public final String getCouponName() {
                return this.couponName;
            }

            public final String getCouponStatus() {
                return this.couponStatus;
            }

            public final String getCouponStatusMsg() {
                return this.couponStatusMsg;
            }

            public final Byte getCouponType() {
                return this.couponType;
            }

            public final String getCouponTypeComb() {
                return this.couponTypeComb;
            }

            public final String getCouponTypeDesc() {
                return this.couponTypeDesc;
            }

            public final String getCouponTypeName() {
                return this.couponTypeName;
            }

            public final Integer getDiscount() {
                return this.discount;
            }

            public final Integer getDiscountCondition() {
                return this.discountCondition;
            }

            public final Byte getDiscountLayer() {
                return this.discountLayer;
            }

            public final Integer getDiscountLimit() {
                return this.discountLimit;
            }

            public final Double getDiscountY() {
                return this.discountY;
            }

            public final String getExtraInfo() {
                return this.extraInfo;
            }

            public final Boolean getHasNewUserCoupon() {
                return this.hasNewUserCoupon;
            }

            public final Integer getMaxNumPerUser() {
                return this.maxNumPerUser;
            }

            public final Byte getNewUserLimit() {
                return this.newUserLimit;
            }

            public final String getOwners() {
                return this.owners;
            }

            public final String getOwnersName() {
                return this.ownersName;
            }

            public final String getReceiveChannel() {
                return this.receiveChannel;
            }

            public final Integer getReceiveEndTime() {
                return this.receiveEndTime;
            }

            public final Integer getReceiveStartTime() {
                return this.receiveStartTime;
            }

            public final Integer getRegTime() {
                return this.regTime;
            }

            public final String getSceneId() {
                return this.sceneId;
            }

            public final String getShopLabel() {
                return this.shopLabel;
            }

            public final String getShowName() {
                return this.showName;
            }

            public final String getSourceAuthorityId() {
                return this.sourceAuthorityId;
            }

            public final String getSourceId() {
                return this.sourceId;
            }

            public final Integer getUseEffectDays() {
                return this.useEffectDays;
            }

            public final Byte getUseEffectUnit() {
                return this.useEffectUnit;
            }

            public final Integer getUseEndTime() {
                return this.useEndTime;
            }

            public final Integer getUseStartTime() {
                return this.useStartTime;
            }

            public final Integer getUserCouponReceiveStatus() {
                return this.userCouponReceiveStatus;
            }

            public final Byte getUserLevel() {
                return this.userLevel;
            }

            public final String getVipType() {
                return this.vipType;
            }
        }
    }

    public final List<ProgressActivityInfo> getProgressActivityInfoVO() {
        return this.progressActivityInfoVO;
    }

    /* compiled from: ActivityInfoFloor.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000256Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rBk\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u000fHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u00067"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoModel;", "", "actLabel", "", "actText", "actUrl", "countdownTime", "", "endTime", "serverTime", "startTime", "timeStr", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActLabel", "()Ljava/lang/String;", "getActText", "getActUrl", "getCountdownTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "getServerTime", "getStartTime", "getTimeStr", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoModel;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ActivityInfoModel {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String actLabel;
        private final String actText;
        private final String actUrl;
        private final Long countdownTime;
        private final Long endTime;
        private final Long serverTime;
        private final Long startTime;
        private final String timeStr;

        public ActivityInfoModel() {
            this((String) null, (String) null, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, (String) null, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
        }

        public final String component1() {
            return this.actLabel;
        }

        public final String component2() {
            return this.actText;
        }

        public final String component3() {
            return this.actUrl;
        }

        public final Long component4() {
            return this.countdownTime;
        }

        public final Long component5() {
            return this.endTime;
        }

        public final Long component6() {
            return this.serverTime;
        }

        public final Long component7() {
            return this.startTime;
        }

        public final String component8() {
            return this.timeStr;
        }

        public final ActivityInfoModel copy(String str, String str2, String str3, Long l, Long l2, Long l3, Long l4, String str4) {
            return new ActivityInfoModel(str, str2, str3, l, l2, l3, l4, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ActivityInfoModel) {
                ActivityInfoModel activityInfoModel = (ActivityInfoModel) obj;
                return Intrinsics.areEqual(this.actLabel, activityInfoModel.actLabel) && Intrinsics.areEqual(this.actText, activityInfoModel.actText) && Intrinsics.areEqual(this.actUrl, activityInfoModel.actUrl) && Intrinsics.areEqual(this.countdownTime, activityInfoModel.countdownTime) && Intrinsics.areEqual(this.endTime, activityInfoModel.endTime) && Intrinsics.areEqual(this.serverTime, activityInfoModel.serverTime) && Intrinsics.areEqual(this.startTime, activityInfoModel.startTime) && Intrinsics.areEqual(this.timeStr, activityInfoModel.timeStr);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((this.actLabel == null ? 0 : this.actLabel.hashCode()) * 31) + (this.actText == null ? 0 : this.actText.hashCode())) * 31) + (this.actUrl == null ? 0 : this.actUrl.hashCode())) * 31) + (this.countdownTime == null ? 0 : this.countdownTime.hashCode())) * 31) + (this.endTime == null ? 0 : this.endTime.hashCode())) * 31) + (this.serverTime == null ? 0 : this.serverTime.hashCode())) * 31) + (this.startTime == null ? 0 : this.startTime.hashCode())) * 31) + (this.timeStr != null ? this.timeStr.hashCode() : 0);
        }

        public String toString() {
            String str = this.actLabel;
            String str2 = this.actText;
            String str3 = this.actUrl;
            Long l = this.countdownTime;
            Long l2 = this.endTime;
            Long l3 = this.serverTime;
            Long l4 = this.startTime;
            return "ActivityInfoModel(actLabel=" + str + ", actText=" + str2 + ", actUrl=" + str3 + ", countdownTime=" + l + ", endTime=" + l2 + ", serverTime=" + l3 + ", startTime=" + l4 + ", timeStr=" + this.timeStr + ")";
        }

        /* compiled from: ActivityInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ActivityInfoModel> serializer() {
                return ActivityInfoFloor$ActivityInfoModel$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ActivityInfoModel(int seen0, String actLabel, String actText, String actUrl, Long countdownTime, Long endTime, Long serverTime, Long startTime, String timeStr, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.actLabel = null;
            } else {
                this.actLabel = actLabel;
            }
            if ((seen0 & 2) == 0) {
                this.actText = null;
            } else {
                this.actText = actText;
            }
            if ((seen0 & 4) == 0) {
                this.actUrl = null;
            } else {
                this.actUrl = actUrl;
            }
            if ((seen0 & 8) == 0) {
                this.countdownTime = null;
            } else {
                this.countdownTime = countdownTime;
            }
            if ((seen0 & 16) == 0) {
                this.endTime = null;
            } else {
                this.endTime = endTime;
            }
            if ((seen0 & 32) == 0) {
                this.serverTime = null;
            } else {
                this.serverTime = serverTime;
            }
            if ((seen0 & 64) == 0) {
                this.startTime = null;
            } else {
                this.startTime = startTime;
            }
            if ((seen0 & 128) == 0) {
                this.timeStr = null;
            } else {
                this.timeStr = timeStr;
            }
        }

        public ActivityInfoModel(String actLabel, String actText, String actUrl, Long countdownTime, Long endTime, Long serverTime, Long startTime, String timeStr) {
            this.actLabel = actLabel;
            this.actText = actText;
            this.actUrl = actUrl;
            this.countdownTime = countdownTime;
            this.endTime = endTime;
            this.serverTime = serverTime;
            this.startTime = startTime;
            this.timeStr = timeStr;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ActivityInfoModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.actLabel != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.actLabel);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.actText != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.actText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.actUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.actUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.countdownTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, LongSerializer.INSTANCE, self.countdownTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.endTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, LongSerializer.INSTANCE, self.endTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.serverTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, LongSerializer.INSTANCE, self.serverTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.startTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, LongSerializer.INSTANCE, self.startTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.timeStr != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.timeStr);
            }
        }

        public /* synthetic */ ActivityInfoModel(String str, String str2, String str3, Long l, Long l2, Long l3, Long l4, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : l3, (i & 64) != 0 ? null : l4, (i & 128) == 0 ? str4 : null);
        }

        public final String getActLabel() {
            return this.actLabel;
        }

        public final String getActText() {
            return this.actText;
        }

        public final String getActUrl() {
            return this.actUrl;
        }

        public final Long getCountdownTime() {
            return this.countdownTime;
        }

        public final Long getEndTime() {
            return this.endTime;
        }

        public final Long getServerTime() {
            return this.serverTime;
        }

        public final Long getStartTime() {
            return this.startTime;
        }

        public final String getTimeStr() {
            return this.timeStr;
        }
    }

    /* compiled from: ActivityInfoFloor.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 a2\u00020\u0001:\u0004^_`aBñ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001c\u0010\u001dBß\u0001\b\u0010\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001c\u0010!J\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010?\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010C\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010D\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010E\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010F\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010H\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010K\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010N\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010O\u001a\u0004\u0018\u00010\u001bHÆ\u0003Jø\u0001\u0010P\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÆ\u0001¢\u0006\u0002\u0010QJ\u0013\u0010R\u001a\u00020\u000e2\b\u0010S\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010T\u001a\u00020\u0003HÖ\u0001J\t\u0010U\u001a\u00020\u0013HÖ\u0001J%\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0001¢\u0006\u0002\b]R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b)\u0010#R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b,\u0010#R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010(\u001a\u0004\b\f\u0010'R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\r\u0010-R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010.\u001a\u0004\b/\u0010-R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010(\u001a\u0004\b0\u0010'R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b1\u0010#R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b6\u0010#R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b7\u00103R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b8\u00103R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b9\u0010#R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010(\u001a\u0004\b:\u0010'R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<¨\u0006b"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO;", "", "activityId", "", "activitySaleStatus", "activityStatus", "", "countdownTime", "couponList", "", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$CouponModel;", "endTime", "isAllSku", "isInWhiteList", "", "newCustomer", "preType", "publishTime", "reducedPrice", "", "reducedPriceUsedCoupon", "serverTime", "showLabel", "showLabelText", "startTime", "type", "whiteBindInfo", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$BindInfo;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$CouponModel;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$BindInfo;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$CouponModel;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$BindInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActivitySaleStatus", "getActivityStatus", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getCountdownTime", "getCouponList", "()Ljava/util/List;", "getEndTime", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNewCustomer", "getPreType", "getPublishTime", "getReducedPrice", "()Ljava/lang/String;", "getReducedPriceUsedCoupon", "()Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$CouponModel;", "getServerTime", "getShowLabel", "getShowLabelText", "getStartTime", "getType", "getWhiteBindInfo", "()Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$BindInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$CouponModel;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$BindInfo;)Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "CouponModel", "BindInfo", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ActivityInfoVO {
        private final Integer activityId;
        private final Integer activitySaleStatus;
        private final Byte activityStatus;
        private final Integer countdownTime;
        private final List<CouponModel> couponList;
        private final Integer endTime;
        private final Byte isAllSku;
        private final Boolean isInWhiteList;
        private final Boolean newCustomer;
        private final Byte preType;
        private final Integer publishTime;
        private final String reducedPrice;
        private final CouponModel reducedPriceUsedCoupon;
        private final Integer serverTime;
        private final String showLabel;
        private final String showLabelText;
        private final Integer startTime;
        private final Byte type;
        private final BindInfo whiteBindInfo;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ActivityInfoFloor$ActivityInfoVO$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = ActivityInfoFloor.ActivityInfoVO._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, null, null, null, null, null, null, null, null, null, null, null, null, null};

        public ActivityInfoVO() {
            this((Integer) null, (Integer) null, (Byte) null, (Integer) null, (List) null, (Integer) null, (Byte) null, (Boolean) null, (Boolean) null, (Byte) null, (Integer) null, (String) null, (CouponModel) null, (Integer) null, (String) null, (String) null, (Integer) null, (Byte) null, (BindInfo) null, 524287, (DefaultConstructorMarker) null);
        }

        public final Integer component1() {
            return this.activityId;
        }

        public final Byte component10() {
            return this.preType;
        }

        public final Integer component11() {
            return this.publishTime;
        }

        public final String component12() {
            return this.reducedPrice;
        }

        public final CouponModel component13() {
            return this.reducedPriceUsedCoupon;
        }

        public final Integer component14() {
            return this.serverTime;
        }

        public final String component15() {
            return this.showLabel;
        }

        public final String component16() {
            return this.showLabelText;
        }

        public final Integer component17() {
            return this.startTime;
        }

        public final Byte component18() {
            return this.type;
        }

        public final BindInfo component19() {
            return this.whiteBindInfo;
        }

        public final Integer component2() {
            return this.activitySaleStatus;
        }

        public final Byte component3() {
            return this.activityStatus;
        }

        public final Integer component4() {
            return this.countdownTime;
        }

        public final List<CouponModel> component5() {
            return this.couponList;
        }

        public final Integer component6() {
            return this.endTime;
        }

        public final Byte component7() {
            return this.isAllSku;
        }

        public final Boolean component8() {
            return this.isInWhiteList;
        }

        public final Boolean component9() {
            return this.newCustomer;
        }

        public final ActivityInfoVO copy(Integer num, Integer num2, Byte b, Integer num3, List<CouponModel> list, Integer num4, Byte b2, Boolean bool, Boolean bool2, Byte b3, Integer num5, String str, CouponModel couponModel, Integer num6, String str2, String str3, Integer num7, Byte b4, BindInfo bindInfo) {
            return new ActivityInfoVO(num, num2, b, num3, list, num4, b2, bool, bool2, b3, num5, str, couponModel, num6, str2, str3, num7, b4, bindInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ActivityInfoVO) {
                ActivityInfoVO activityInfoVO = (ActivityInfoVO) obj;
                return Intrinsics.areEqual(this.activityId, activityInfoVO.activityId) && Intrinsics.areEqual(this.activitySaleStatus, activityInfoVO.activitySaleStatus) && Intrinsics.areEqual(this.activityStatus, activityInfoVO.activityStatus) && Intrinsics.areEqual(this.countdownTime, activityInfoVO.countdownTime) && Intrinsics.areEqual(this.couponList, activityInfoVO.couponList) && Intrinsics.areEqual(this.endTime, activityInfoVO.endTime) && Intrinsics.areEqual(this.isAllSku, activityInfoVO.isAllSku) && Intrinsics.areEqual(this.isInWhiteList, activityInfoVO.isInWhiteList) && Intrinsics.areEqual(this.newCustomer, activityInfoVO.newCustomer) && Intrinsics.areEqual(this.preType, activityInfoVO.preType) && Intrinsics.areEqual(this.publishTime, activityInfoVO.publishTime) && Intrinsics.areEqual(this.reducedPrice, activityInfoVO.reducedPrice) && Intrinsics.areEqual(this.reducedPriceUsedCoupon, activityInfoVO.reducedPriceUsedCoupon) && Intrinsics.areEqual(this.serverTime, activityInfoVO.serverTime) && Intrinsics.areEqual(this.showLabel, activityInfoVO.showLabel) && Intrinsics.areEqual(this.showLabelText, activityInfoVO.showLabelText) && Intrinsics.areEqual(this.startTime, activityInfoVO.startTime) && Intrinsics.areEqual(this.type, activityInfoVO.type) && Intrinsics.areEqual(this.whiteBindInfo, activityInfoVO.whiteBindInfo);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((this.activityId == null ? 0 : this.activityId.hashCode()) * 31) + (this.activitySaleStatus == null ? 0 : this.activitySaleStatus.hashCode())) * 31) + (this.activityStatus == null ? 0 : this.activityStatus.hashCode())) * 31) + (this.countdownTime == null ? 0 : this.countdownTime.hashCode())) * 31) + (this.couponList == null ? 0 : this.couponList.hashCode())) * 31) + (this.endTime == null ? 0 : this.endTime.hashCode())) * 31) + (this.isAllSku == null ? 0 : this.isAllSku.hashCode())) * 31) + (this.isInWhiteList == null ? 0 : this.isInWhiteList.hashCode())) * 31) + (this.newCustomer == null ? 0 : this.newCustomer.hashCode())) * 31) + (this.preType == null ? 0 : this.preType.hashCode())) * 31) + (this.publishTime == null ? 0 : this.publishTime.hashCode())) * 31) + (this.reducedPrice == null ? 0 : this.reducedPrice.hashCode())) * 31) + (this.reducedPriceUsedCoupon == null ? 0 : this.reducedPriceUsedCoupon.hashCode())) * 31) + (this.serverTime == null ? 0 : this.serverTime.hashCode())) * 31) + (this.showLabel == null ? 0 : this.showLabel.hashCode())) * 31) + (this.showLabelText == null ? 0 : this.showLabelText.hashCode())) * 31) + (this.startTime == null ? 0 : this.startTime.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.whiteBindInfo != null ? this.whiteBindInfo.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.activityId;
            Integer num2 = this.activitySaleStatus;
            Byte b = this.activityStatus;
            Integer num3 = this.countdownTime;
            List<CouponModel> list = this.couponList;
            Integer num4 = this.endTime;
            Byte b2 = this.isAllSku;
            Boolean bool = this.isInWhiteList;
            Boolean bool2 = this.newCustomer;
            Byte b3 = this.preType;
            Integer num5 = this.publishTime;
            String str = this.reducedPrice;
            CouponModel couponModel = this.reducedPriceUsedCoupon;
            Integer num6 = this.serverTime;
            String str2 = this.showLabel;
            String str3 = this.showLabelText;
            Integer num7 = this.startTime;
            Byte b4 = this.type;
            return "ActivityInfoVO(activityId=" + num + ", activitySaleStatus=" + num2 + ", activityStatus=" + b + ", countdownTime=" + num3 + ", couponList=" + list + ", endTime=" + num4 + ", isAllSku=" + b2 + ", isInWhiteList=" + bool + ", newCustomer=" + bool2 + ", preType=" + b3 + ", publishTime=" + num5 + ", reducedPrice=" + str + ", reducedPriceUsedCoupon=" + couponModel + ", serverTime=" + num6 + ", showLabel=" + str2 + ", showLabelText=" + str3 + ", startTime=" + num7 + ", type=" + b4 + ", whiteBindInfo=" + this.whiteBindInfo + ")";
        }

        /* compiled from: ActivityInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ActivityInfoVO> serializer() {
                return ActivityInfoFloor$ActivityInfoVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ActivityInfoVO(int seen0, Integer activityId, Integer activitySaleStatus, Byte activityStatus, Integer countdownTime, List couponList, Integer endTime, Byte isAllSku, Boolean isInWhiteList, Boolean newCustomer, Byte preType, Integer publishTime, String reducedPrice, CouponModel reducedPriceUsedCoupon, Integer serverTime, String showLabel, String showLabelText, Integer startTime, Byte type, BindInfo whiteBindInfo, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.activityId = null;
            } else {
                this.activityId = activityId;
            }
            if ((seen0 & 2) == 0) {
                this.activitySaleStatus = null;
            } else {
                this.activitySaleStatus = activitySaleStatus;
            }
            if ((seen0 & 4) == 0) {
                this.activityStatus = null;
            } else {
                this.activityStatus = activityStatus;
            }
            if ((seen0 & 8) == 0) {
                this.countdownTime = null;
            } else {
                this.countdownTime = countdownTime;
            }
            if ((seen0 & 16) == 0) {
                this.couponList = null;
            } else {
                this.couponList = couponList;
            }
            if ((seen0 & 32) == 0) {
                this.endTime = null;
            } else {
                this.endTime = endTime;
            }
            if ((seen0 & 64) == 0) {
                this.isAllSku = null;
            } else {
                this.isAllSku = isAllSku;
            }
            if ((seen0 & 128) == 0) {
                this.isInWhiteList = null;
            } else {
                this.isInWhiteList = isInWhiteList;
            }
            if ((seen0 & 256) == 0) {
                this.newCustomer = null;
            } else {
                this.newCustomer = newCustomer;
            }
            if ((seen0 & 512) == 0) {
                this.preType = null;
            } else {
                this.preType = preType;
            }
            if ((seen0 & 1024) == 0) {
                this.publishTime = null;
            } else {
                this.publishTime = publishTime;
            }
            if ((seen0 & 2048) == 0) {
                this.reducedPrice = null;
            } else {
                this.reducedPrice = reducedPrice;
            }
            if ((seen0 & 4096) == 0) {
                this.reducedPriceUsedCoupon = null;
            } else {
                this.reducedPriceUsedCoupon = reducedPriceUsedCoupon;
            }
            if ((seen0 & 8192) == 0) {
                this.serverTime = null;
            } else {
                this.serverTime = serverTime;
            }
            if ((seen0 & 16384) == 0) {
                this.showLabel = null;
            } else {
                this.showLabel = showLabel;
            }
            if ((seen0 & 32768) == 0) {
                this.showLabelText = null;
            } else {
                this.showLabelText = showLabelText;
            }
            if ((seen0 & 65536) == 0) {
                this.startTime = null;
            } else {
                this.startTime = startTime;
            }
            if ((seen0 & 131072) == 0) {
                this.type = null;
            } else {
                this.type = type;
            }
            if ((seen0 & 262144) == 0) {
                this.whiteBindInfo = null;
            } else {
                this.whiteBindInfo = whiteBindInfo;
            }
        }

        public ActivityInfoVO(Integer activityId, Integer activitySaleStatus, Byte activityStatus, Integer countdownTime, List<CouponModel> list, Integer endTime, Byte isAllSku, Boolean isInWhiteList, Boolean newCustomer, Byte preType, Integer publishTime, String reducedPrice, CouponModel reducedPriceUsedCoupon, Integer serverTime, String showLabel, String showLabelText, Integer startTime, Byte type, BindInfo whiteBindInfo) {
            this.activityId = activityId;
            this.activitySaleStatus = activitySaleStatus;
            this.activityStatus = activityStatus;
            this.countdownTime = countdownTime;
            this.couponList = list;
            this.endTime = endTime;
            this.isAllSku = isAllSku;
            this.isInWhiteList = isInWhiteList;
            this.newCustomer = newCustomer;
            this.preType = preType;
            this.publishTime = publishTime;
            this.reducedPrice = reducedPrice;
            this.reducedPriceUsedCoupon = reducedPriceUsedCoupon;
            this.serverTime = serverTime;
            this.showLabel = showLabel;
            this.showLabelText = showLabelText;
            this.startTime = startTime;
            this.type = type;
            this.whiteBindInfo = whiteBindInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(ActivityInfoFloor$ActivityInfoVO$CouponModel$$serializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ActivityInfoVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activityId != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.activityId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.activitySaleStatus != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.activitySaleStatus);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.activityStatus != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, ByteSerializer.INSTANCE, self.activityStatus);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.countdownTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.countdownTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.couponList != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.couponList);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.endTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.endTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.isAllSku != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, ByteSerializer.INSTANCE, self.isAllSku);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.isInWhiteList != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.isInWhiteList);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.newCustomer != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, BooleanSerializer.INSTANCE, self.newCustomer);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.preType != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, ByteSerializer.INSTANCE, self.preType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.publishTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.publishTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.reducedPrice != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.reducedPrice);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.reducedPriceUsedCoupon != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, ActivityInfoFloor$ActivityInfoVO$CouponModel$$serializer.INSTANCE, self.reducedPriceUsedCoupon);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.serverTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, IntSerializer.INSTANCE, self.serverTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.showLabel != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.showLabel);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.showLabelText != null) {
                output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.showLabelText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.startTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 16, IntSerializer.INSTANCE, self.startTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 17) || self.type != null) {
                output.encodeNullableSerializableElement(serialDesc, 17, ByteSerializer.INSTANCE, self.type);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 18) || self.whiteBindInfo != null) {
                output.encodeNullableSerializableElement(serialDesc, 18, ActivityInfoFloor$ActivityInfoVO$BindInfo$$serializer.INSTANCE, self.whiteBindInfo);
            }
        }

        public /* synthetic */ ActivityInfoVO(Integer num, Integer num2, Byte b, Integer num3, List list, Integer num4, Byte b2, Boolean bool, Boolean bool2, Byte b3, Integer num5, String str, CouponModel couponModel, Integer num6, String str2, String str3, Integer num7, Byte b4, BindInfo bindInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : b, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : num4, (i & 64) != 0 ? null : b2, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? null : bool2, (i & 512) != 0 ? null : b3, (i & 1024) != 0 ? null : num5, (i & 2048) != 0 ? null : str, (i & 4096) != 0 ? null : couponModel, (i & 8192) != 0 ? null : num6, (i & 16384) != 0 ? null : str2, (i & 32768) != 0 ? null : str3, (i & 65536) != 0 ? null : num7, (i & 131072) != 0 ? null : b4, (i & 262144) != 0 ? null : bindInfo);
        }

        public final Integer getActivityId() {
            return this.activityId;
        }

        public final Integer getActivitySaleStatus() {
            return this.activitySaleStatus;
        }

        public final Byte getActivityStatus() {
            return this.activityStatus;
        }

        public final Integer getCountdownTime() {
            return this.countdownTime;
        }

        public final List<CouponModel> getCouponList() {
            return this.couponList;
        }

        public final Integer getEndTime() {
            return this.endTime;
        }

        public final Byte isAllSku() {
            return this.isAllSku;
        }

        public final Boolean isInWhiteList() {
            return this.isInWhiteList;
        }

        public final Boolean getNewCustomer() {
            return this.newCustomer;
        }

        public final Byte getPreType() {
            return this.preType;
        }

        public final Integer getPublishTime() {
            return this.publishTime;
        }

        public final String getReducedPrice() {
            return this.reducedPrice;
        }

        public final CouponModel getReducedPriceUsedCoupon() {
            return this.reducedPriceUsedCoupon;
        }

        public final Integer getServerTime() {
            return this.serverTime;
        }

        public final String getShowLabel() {
            return this.showLabel;
        }

        public final String getShowLabelText() {
            return this.showLabelText;
        }

        public final Integer getStartTime() {
            return this.startTime;
        }

        public final Byte getType() {
            return this.type;
        }

        /* compiled from: ActivityInfoFloor.kt */
        @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ]2\u00020\u0001:\u0002\\]Bë\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001a\u0010\u001bBÙ\u0001\b\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001a\u0010\u001fJ\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010D\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010E\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010K\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010L\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010M\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u00106Jò\u0001\u0010N\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010OJ\u0013\u0010P\u001a\u00020\u000f2\b\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010R\u001a\u00020\u0016HÖ\u0001J\t\u0010S\u001a\u00020\u0003HÖ\u0001J%\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00002\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0001¢\u0006\u0002\b[R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010/\u001a\u0004\b\u000e\u0010.R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010(\u001a\u0004\b0\u0010'R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010!R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010!R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010(\u001a\u0004\b8\u0010'R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u00107\u001a\u0004\b9\u00106R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u00107\u001a\u0004\b:\u00106¨\u0006^"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$CouponModel;", "", "couponId", "", "couponName", "couponStatus", "couponStatusMsg", "couponTag", "couponType", "", "couponTypeDesc", "discount", "discountY", "", "isExclusive", "", "newUserLimit", "shopLabel", "showName", "sourceAuthorityId", "sourceId", "useEffectDays", "", "useEffectUnit", "useEndTime", "useStartTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCouponId", "()Ljava/lang/String;", "getCouponName", "getCouponStatus", "getCouponStatusMsg", "getCouponTag", "getCouponType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getCouponTypeDesc", "getDiscount", "getDiscountY", "()Ljava/lang/Double;", "Ljava/lang/Double;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNewUserLimit", "getShopLabel", "getShowName", "getSourceAuthorityId", "getSourceId", "getUseEffectDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUseEffectUnit", "getUseEndTime", "getUseStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$CouponModel;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class CouponModel {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String couponId;
            private final String couponName;
            private final String couponStatus;
            private final String couponStatusMsg;
            private final String couponTag;
            private final Byte couponType;
            private final String couponTypeDesc;
            private final String discount;
            private final Double discountY;
            private final Boolean isExclusive;
            private final Byte newUserLimit;
            private final String shopLabel;
            private final String showName;
            private final String sourceAuthorityId;
            private final String sourceId;
            private final Integer useEffectDays;
            private final Byte useEffectUnit;
            private final Integer useEndTime;
            private final Integer useStartTime;

            public CouponModel() {
                this((String) null, (String) null, (String) null, (String) null, (String) null, (Byte) null, (String) null, (String) null, (Double) null, (Boolean) null, (Byte) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Byte) null, (Integer) null, (Integer) null, 524287, (DefaultConstructorMarker) null);
            }

            public final String component1() {
                return this.couponId;
            }

            public final Boolean component10() {
                return this.isExclusive;
            }

            public final Byte component11() {
                return this.newUserLimit;
            }

            public final String component12() {
                return this.shopLabel;
            }

            public final String component13() {
                return this.showName;
            }

            public final String component14() {
                return this.sourceAuthorityId;
            }

            public final String component15() {
                return this.sourceId;
            }

            public final Integer component16() {
                return this.useEffectDays;
            }

            public final Byte component17() {
                return this.useEffectUnit;
            }

            public final Integer component18() {
                return this.useEndTime;
            }

            public final Integer component19() {
                return this.useStartTime;
            }

            public final String component2() {
                return this.couponName;
            }

            public final String component3() {
                return this.couponStatus;
            }

            public final String component4() {
                return this.couponStatusMsg;
            }

            public final String component5() {
                return this.couponTag;
            }

            public final Byte component6() {
                return this.couponType;
            }

            public final String component7() {
                return this.couponTypeDesc;
            }

            public final String component8() {
                return this.discount;
            }

            public final Double component9() {
                return this.discountY;
            }

            public final CouponModel copy(String str, String str2, String str3, String str4, String str5, Byte b, String str6, String str7, Double d, Boolean bool, Byte b2, String str8, String str9, String str10, String str11, Integer num, Byte b3, Integer num2, Integer num3) {
                return new CouponModel(str, str2, str3, str4, str5, b, str6, str7, d, bool, b2, str8, str9, str10, str11, num, b3, num2, num3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof CouponModel) {
                    CouponModel couponModel = (CouponModel) obj;
                    return Intrinsics.areEqual(this.couponId, couponModel.couponId) && Intrinsics.areEqual(this.couponName, couponModel.couponName) && Intrinsics.areEqual(this.couponStatus, couponModel.couponStatus) && Intrinsics.areEqual(this.couponStatusMsg, couponModel.couponStatusMsg) && Intrinsics.areEqual(this.couponTag, couponModel.couponTag) && Intrinsics.areEqual(this.couponType, couponModel.couponType) && Intrinsics.areEqual(this.couponTypeDesc, couponModel.couponTypeDesc) && Intrinsics.areEqual(this.discount, couponModel.discount) && Intrinsics.areEqual(this.discountY, couponModel.discountY) && Intrinsics.areEqual(this.isExclusive, couponModel.isExclusive) && Intrinsics.areEqual(this.newUserLimit, couponModel.newUserLimit) && Intrinsics.areEqual(this.shopLabel, couponModel.shopLabel) && Intrinsics.areEqual(this.showName, couponModel.showName) && Intrinsics.areEqual(this.sourceAuthorityId, couponModel.sourceAuthorityId) && Intrinsics.areEqual(this.sourceId, couponModel.sourceId) && Intrinsics.areEqual(this.useEffectDays, couponModel.useEffectDays) && Intrinsics.areEqual(this.useEffectUnit, couponModel.useEffectUnit) && Intrinsics.areEqual(this.useEndTime, couponModel.useEndTime) && Intrinsics.areEqual(this.useStartTime, couponModel.useStartTime);
                }
                return false;
            }

            public int hashCode() {
                return ((((((((((((((((((((((((((((((((((((this.couponId == null ? 0 : this.couponId.hashCode()) * 31) + (this.couponName == null ? 0 : this.couponName.hashCode())) * 31) + (this.couponStatus == null ? 0 : this.couponStatus.hashCode())) * 31) + (this.couponStatusMsg == null ? 0 : this.couponStatusMsg.hashCode())) * 31) + (this.couponTag == null ? 0 : this.couponTag.hashCode())) * 31) + (this.couponType == null ? 0 : this.couponType.hashCode())) * 31) + (this.couponTypeDesc == null ? 0 : this.couponTypeDesc.hashCode())) * 31) + (this.discount == null ? 0 : this.discount.hashCode())) * 31) + (this.discountY == null ? 0 : this.discountY.hashCode())) * 31) + (this.isExclusive == null ? 0 : this.isExclusive.hashCode())) * 31) + (this.newUserLimit == null ? 0 : this.newUserLimit.hashCode())) * 31) + (this.shopLabel == null ? 0 : this.shopLabel.hashCode())) * 31) + (this.showName == null ? 0 : this.showName.hashCode())) * 31) + (this.sourceAuthorityId == null ? 0 : this.sourceAuthorityId.hashCode())) * 31) + (this.sourceId == null ? 0 : this.sourceId.hashCode())) * 31) + (this.useEffectDays == null ? 0 : this.useEffectDays.hashCode())) * 31) + (this.useEffectUnit == null ? 0 : this.useEffectUnit.hashCode())) * 31) + (this.useEndTime == null ? 0 : this.useEndTime.hashCode())) * 31) + (this.useStartTime != null ? this.useStartTime.hashCode() : 0);
            }

            public String toString() {
                String str = this.couponId;
                String str2 = this.couponName;
                String str3 = this.couponStatus;
                String str4 = this.couponStatusMsg;
                String str5 = this.couponTag;
                Byte b = this.couponType;
                String str6 = this.couponTypeDesc;
                String str7 = this.discount;
                Double d = this.discountY;
                Boolean bool = this.isExclusive;
                Byte b2 = this.newUserLimit;
                String str8 = this.shopLabel;
                String str9 = this.showName;
                String str10 = this.sourceAuthorityId;
                String str11 = this.sourceId;
                Integer num = this.useEffectDays;
                Byte b3 = this.useEffectUnit;
                Integer num2 = this.useEndTime;
                return "CouponModel(couponId=" + str + ", couponName=" + str2 + ", couponStatus=" + str3 + ", couponStatusMsg=" + str4 + ", couponTag=" + str5 + ", couponType=" + b + ", couponTypeDesc=" + str6 + ", discount=" + str7 + ", discountY=" + d + ", isExclusive=" + bool + ", newUserLimit=" + b2 + ", shopLabel=" + str8 + ", showName=" + str9 + ", sourceAuthorityId=" + str10 + ", sourceId=" + str11 + ", useEffectDays=" + num + ", useEffectUnit=" + b3 + ", useEndTime=" + num2 + ", useStartTime=" + this.useStartTime + ")";
            }

            /* compiled from: ActivityInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$CouponModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$CouponModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<CouponModel> serializer() {
                    return ActivityInfoFloor$ActivityInfoVO$CouponModel$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ CouponModel(int seen0, String couponId, String couponName, String couponStatus, String couponStatusMsg, String couponTag, Byte couponType, String couponTypeDesc, String discount, Double discountY, Boolean isExclusive, Byte newUserLimit, String shopLabel, String showName, String sourceAuthorityId, String sourceId, Integer useEffectDays, Byte useEffectUnit, Integer useEndTime, Integer useStartTime, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.couponId = null;
                } else {
                    this.couponId = couponId;
                }
                if ((seen0 & 2) == 0) {
                    this.couponName = null;
                } else {
                    this.couponName = couponName;
                }
                if ((seen0 & 4) == 0) {
                    this.couponStatus = null;
                } else {
                    this.couponStatus = couponStatus;
                }
                if ((seen0 & 8) == 0) {
                    this.couponStatusMsg = null;
                } else {
                    this.couponStatusMsg = couponStatusMsg;
                }
                if ((seen0 & 16) == 0) {
                    this.couponTag = null;
                } else {
                    this.couponTag = couponTag;
                }
                if ((seen0 & 32) == 0) {
                    this.couponType = null;
                } else {
                    this.couponType = couponType;
                }
                if ((seen0 & 64) == 0) {
                    this.couponTypeDesc = null;
                } else {
                    this.couponTypeDesc = couponTypeDesc;
                }
                if ((seen0 & 128) == 0) {
                    this.discount = null;
                } else {
                    this.discount = discount;
                }
                if ((seen0 & 256) == 0) {
                    this.discountY = null;
                } else {
                    this.discountY = discountY;
                }
                if ((seen0 & 512) == 0) {
                    this.isExclusive = null;
                } else {
                    this.isExclusive = isExclusive;
                }
                if ((seen0 & 1024) == 0) {
                    this.newUserLimit = null;
                } else {
                    this.newUserLimit = newUserLimit;
                }
                if ((seen0 & 2048) == 0) {
                    this.shopLabel = null;
                } else {
                    this.shopLabel = shopLabel;
                }
                if ((seen0 & 4096) == 0) {
                    this.showName = null;
                } else {
                    this.showName = showName;
                }
                if ((seen0 & 8192) == 0) {
                    this.sourceAuthorityId = null;
                } else {
                    this.sourceAuthorityId = sourceAuthorityId;
                }
                if ((seen0 & 16384) == 0) {
                    this.sourceId = null;
                } else {
                    this.sourceId = sourceId;
                }
                if ((seen0 & 32768) == 0) {
                    this.useEffectDays = null;
                } else {
                    this.useEffectDays = useEffectDays;
                }
                if ((seen0 & 65536) == 0) {
                    this.useEffectUnit = null;
                } else {
                    this.useEffectUnit = useEffectUnit;
                }
                if ((seen0 & 131072) == 0) {
                    this.useEndTime = null;
                } else {
                    this.useEndTime = useEndTime;
                }
                if ((seen0 & 262144) == 0) {
                    this.useStartTime = null;
                } else {
                    this.useStartTime = useStartTime;
                }
            }

            public CouponModel(String couponId, String couponName, String couponStatus, String couponStatusMsg, String couponTag, Byte couponType, String couponTypeDesc, String discount, Double discountY, Boolean isExclusive, Byte newUserLimit, String shopLabel, String showName, String sourceAuthorityId, String sourceId, Integer useEffectDays, Byte useEffectUnit, Integer useEndTime, Integer useStartTime) {
                this.couponId = couponId;
                this.couponName = couponName;
                this.couponStatus = couponStatus;
                this.couponStatusMsg = couponStatusMsg;
                this.couponTag = couponTag;
                this.couponType = couponType;
                this.couponTypeDesc = couponTypeDesc;
                this.discount = discount;
                this.discountY = discountY;
                this.isExclusive = isExclusive;
                this.newUserLimit = newUserLimit;
                this.shopLabel = shopLabel;
                this.showName = showName;
                this.sourceAuthorityId = sourceAuthorityId;
                this.sourceId = sourceId;
                this.useEffectDays = useEffectDays;
                this.useEffectUnit = useEffectUnit;
                this.useEndTime = useEndTime;
                this.useStartTime = useStartTime;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(CouponModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.couponId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.couponId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.couponName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.couponName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.couponStatus != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.couponStatus);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.couponStatusMsg != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.couponStatusMsg);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.couponTag != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.couponTag);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.couponType != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, ByteSerializer.INSTANCE, self.couponType);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.couponTypeDesc != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.couponTypeDesc);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.discount != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.discount);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.discountY != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, DoubleSerializer.INSTANCE, self.discountY);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.isExclusive != null) {
                    output.encodeNullableSerializableElement(serialDesc, 9, BooleanSerializer.INSTANCE, self.isExclusive);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 10) || self.newUserLimit != null) {
                    output.encodeNullableSerializableElement(serialDesc, 10, ByteSerializer.INSTANCE, self.newUserLimit);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 11) || self.shopLabel != null) {
                    output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.shopLabel);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 12) || self.showName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.showName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 13) || self.sourceAuthorityId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.sourceAuthorityId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 14) || self.sourceId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.sourceId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 15) || self.useEffectDays != null) {
                    output.encodeNullableSerializableElement(serialDesc, 15, IntSerializer.INSTANCE, self.useEffectDays);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 16) || self.useEffectUnit != null) {
                    output.encodeNullableSerializableElement(serialDesc, 16, ByteSerializer.INSTANCE, self.useEffectUnit);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 17) || self.useEndTime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 17, IntSerializer.INSTANCE, self.useEndTime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 18) || self.useStartTime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 18, IntSerializer.INSTANCE, self.useStartTime);
                }
            }

            public /* synthetic */ CouponModel(String str, String str2, String str3, String str4, String str5, Byte b, String str6, String str7, Double d, Boolean bool, Byte b2, String str8, String str9, String str10, String str11, Integer num, Byte b3, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : b, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : d, (i & 512) != 0 ? null : bool, (i & 1024) != 0 ? null : b2, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : str9, (i & 8192) != 0 ? null : str10, (i & 16384) != 0 ? null : str11, (i & 32768) != 0 ? null : num, (i & 65536) != 0 ? null : b3, (i & 131072) != 0 ? null : num2, (i & 262144) != 0 ? null : num3);
            }

            public final String getCouponId() {
                return this.couponId;
            }

            public final String getCouponName() {
                return this.couponName;
            }

            public final String getCouponStatus() {
                return this.couponStatus;
            }

            public final String getCouponStatusMsg() {
                return this.couponStatusMsg;
            }

            public final String getCouponTag() {
                return this.couponTag;
            }

            public final Byte getCouponType() {
                return this.couponType;
            }

            public final String getCouponTypeDesc() {
                return this.couponTypeDesc;
            }

            public final String getDiscount() {
                return this.discount;
            }

            public final Double getDiscountY() {
                return this.discountY;
            }

            public final Boolean isExclusive() {
                return this.isExclusive;
            }

            public final Byte getNewUserLimit() {
                return this.newUserLimit;
            }

            public final String getShopLabel() {
                return this.shopLabel;
            }

            public final String getShowName() {
                return this.showName;
            }

            public final String getSourceAuthorityId() {
                return this.sourceAuthorityId;
            }

            public final String getSourceId() {
                return this.sourceId;
            }

            public final Integer getUseEffectDays() {
                return this.useEffectDays;
            }

            public final Byte getUseEffectUnit() {
                return this.useEffectUnit;
            }

            public final Integer getUseEndTime() {
                return this.useEndTime;
            }

            public final Integer getUseStartTime() {
                return this.useStartTime;
            }
        }

        public final BindInfo getWhiteBindInfo() {
            return this.whiteBindInfo;
        }

        /* compiled from: ActivityInfoFloor.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bBW\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012JV\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\rHÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012¨\u00061"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$BindInfo;", "", "bindActiveType", "", "bindId", "", "bindMessage", "endTime", "jumpUrl", "startTime", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBindActiveType", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBindId", "()Ljava/lang/String;", "getBindMessage", "getEndTime", "getJumpUrl", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$BindInfo;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class BindInfo {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final Long bindActiveType;
            private final String bindId;
            private final String bindMessage;
            private final Long endTime;
            private final String jumpUrl;
            private final Long startTime;

            public BindInfo() {
                this((Long) null, (String) null, (String) null, (Long) null, (String) null, (Long) null, 63, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ BindInfo copy$default(BindInfo bindInfo, Long l, String str, String str2, Long l2, String str3, Long l3, int i, Object obj) {
                if ((i & 1) != 0) {
                    l = bindInfo.bindActiveType;
                }
                if ((i & 2) != 0) {
                    str = bindInfo.bindId;
                }
                String str4 = str;
                if ((i & 4) != 0) {
                    str2 = bindInfo.bindMessage;
                }
                String str5 = str2;
                if ((i & 8) != 0) {
                    l2 = bindInfo.endTime;
                }
                Long l4 = l2;
                if ((i & 16) != 0) {
                    str3 = bindInfo.jumpUrl;
                }
                String str6 = str3;
                if ((i & 32) != 0) {
                    l3 = bindInfo.startTime;
                }
                return bindInfo.copy(l, str4, str5, l4, str6, l3);
            }

            public final Long component1() {
                return this.bindActiveType;
            }

            public final String component2() {
                return this.bindId;
            }

            public final String component3() {
                return this.bindMessage;
            }

            public final Long component4() {
                return this.endTime;
            }

            public final String component5() {
                return this.jumpUrl;
            }

            public final Long component6() {
                return this.startTime;
            }

            public final BindInfo copy(Long l, String str, String str2, Long l2, String str3, Long l3) {
                return new BindInfo(l, str, str2, l2, str3, l3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof BindInfo) {
                    BindInfo bindInfo = (BindInfo) obj;
                    return Intrinsics.areEqual(this.bindActiveType, bindInfo.bindActiveType) && Intrinsics.areEqual(this.bindId, bindInfo.bindId) && Intrinsics.areEqual(this.bindMessage, bindInfo.bindMessage) && Intrinsics.areEqual(this.endTime, bindInfo.endTime) && Intrinsics.areEqual(this.jumpUrl, bindInfo.jumpUrl) && Intrinsics.areEqual(this.startTime, bindInfo.startTime);
                }
                return false;
            }

            public int hashCode() {
                return ((((((((((this.bindActiveType == null ? 0 : this.bindActiveType.hashCode()) * 31) + (this.bindId == null ? 0 : this.bindId.hashCode())) * 31) + (this.bindMessage == null ? 0 : this.bindMessage.hashCode())) * 31) + (this.endTime == null ? 0 : this.endTime.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.startTime != null ? this.startTime.hashCode() : 0);
            }

            public String toString() {
                Long l = this.bindActiveType;
                String str = this.bindId;
                String str2 = this.bindMessage;
                Long l2 = this.endTime;
                String str3 = this.jumpUrl;
                return "BindInfo(bindActiveType=" + l + ", bindId=" + str + ", bindMessage=" + str2 + ", endTime=" + l2 + ", jumpUrl=" + str3 + ", startTime=" + this.startTime + ")";
            }

            /* compiled from: ActivityInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$BindInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityInfoVO$BindInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<BindInfo> serializer() {
                    return ActivityInfoFloor$ActivityInfoVO$BindInfo$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ BindInfo(int seen0, Long bindActiveType, String bindId, String bindMessage, Long endTime, String jumpUrl, Long startTime, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.bindActiveType = null;
                } else {
                    this.bindActiveType = bindActiveType;
                }
                if ((seen0 & 2) == 0) {
                    this.bindId = null;
                } else {
                    this.bindId = bindId;
                }
                if ((seen0 & 4) == 0) {
                    this.bindMessage = null;
                } else {
                    this.bindMessage = bindMessage;
                }
                if ((seen0 & 8) == 0) {
                    this.endTime = null;
                } else {
                    this.endTime = endTime;
                }
                if ((seen0 & 16) == 0) {
                    this.jumpUrl = null;
                } else {
                    this.jumpUrl = jumpUrl;
                }
                if ((seen0 & 32) == 0) {
                    this.startTime = null;
                } else {
                    this.startTime = startTime;
                }
            }

            public BindInfo(Long bindActiveType, String bindId, String bindMessage, Long endTime, String jumpUrl, Long startTime) {
                this.bindActiveType = bindActiveType;
                this.bindId = bindId;
                this.bindMessage = bindMessage;
                this.endTime = endTime;
                this.jumpUrl = jumpUrl;
                this.startTime = startTime;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(BindInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.bindActiveType != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.bindActiveType);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.bindId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.bindId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.bindMessage != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.bindMessage);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.endTime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, LongSerializer.INSTANCE, self.endTime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.jumpUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.jumpUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.startTime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, LongSerializer.INSTANCE, self.startTime);
                }
            }

            public /* synthetic */ BindInfo(Long l, String str, String str2, Long l2, String str3, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : l3);
            }

            public final Long getBindActiveType() {
                return this.bindActiveType;
            }

            public final String getBindId() {
                return this.bindId;
            }

            public final String getBindMessage() {
                return this.bindMessage;
            }

            public final Long getEndTime() {
                return this.endTime;
            }

            public final String getJumpUrl() {
                return this.jumpUrl;
            }

            public final Long getStartTime() {
                return this.startTime;
            }
        }
    }

    /* compiled from: ActivityInfoFloor.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006)"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityPanelVO;", "", "actLabel", "Lkntr/app/mall/product/details/page/api/model/LabelObject;", "actUrl", "", "benefitText", "timeStr", "<init>", "(Lkntr/app/mall/product/details/page/api/model/LabelObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/model/LabelObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActLabel", "()Lkntr/app/mall/product/details/page/api/model/LabelObject;", "getActUrl", "()Ljava/lang/String;", "getBenefitText", "getTimeStr", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ActivityPanelVO {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final LabelObject actLabel;
        private final String actUrl;
        private final String benefitText;
        private final String timeStr;

        public ActivityPanelVO() {
            this((LabelObject) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ActivityPanelVO copy$default(ActivityPanelVO activityPanelVO, LabelObject labelObject, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                labelObject = activityPanelVO.actLabel;
            }
            if ((i & 2) != 0) {
                str = activityPanelVO.actUrl;
            }
            if ((i & 4) != 0) {
                str2 = activityPanelVO.benefitText;
            }
            if ((i & 8) != 0) {
                str3 = activityPanelVO.timeStr;
            }
            return activityPanelVO.copy(labelObject, str, str2, str3);
        }

        public final LabelObject component1() {
            return this.actLabel;
        }

        public final String component2() {
            return this.actUrl;
        }

        public final String component3() {
            return this.benefitText;
        }

        public final String component4() {
            return this.timeStr;
        }

        public final ActivityPanelVO copy(LabelObject labelObject, String str, String str2, String str3) {
            return new ActivityPanelVO(labelObject, str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ActivityPanelVO) {
                ActivityPanelVO activityPanelVO = (ActivityPanelVO) obj;
                return Intrinsics.areEqual(this.actLabel, activityPanelVO.actLabel) && Intrinsics.areEqual(this.actUrl, activityPanelVO.actUrl) && Intrinsics.areEqual(this.benefitText, activityPanelVO.benefitText) && Intrinsics.areEqual(this.timeStr, activityPanelVO.timeStr);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.actLabel == null ? 0 : this.actLabel.hashCode()) * 31) + (this.actUrl == null ? 0 : this.actUrl.hashCode())) * 31) + (this.benefitText == null ? 0 : this.benefitText.hashCode())) * 31) + (this.timeStr != null ? this.timeStr.hashCode() : 0);
        }

        public String toString() {
            LabelObject labelObject = this.actLabel;
            String str = this.actUrl;
            String str2 = this.benefitText;
            return "ActivityPanelVO(actLabel=" + labelObject + ", actUrl=" + str + ", benefitText=" + str2 + ", timeStr=" + this.timeStr + ")";
        }

        /* compiled from: ActivityInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityPanelVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ActivityPanelVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ActivityPanelVO> serializer() {
                return ActivityInfoFloor$ActivityPanelVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ActivityPanelVO(int seen0, LabelObject actLabel, String actUrl, String benefitText, String timeStr, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.actLabel = null;
            } else {
                this.actLabel = actLabel;
            }
            if ((seen0 & 2) == 0) {
                this.actUrl = null;
            } else {
                this.actUrl = actUrl;
            }
            if ((seen0 & 4) == 0) {
                this.benefitText = null;
            } else {
                this.benefitText = benefitText;
            }
            if ((seen0 & 8) == 0) {
                this.timeStr = null;
            } else {
                this.timeStr = timeStr;
            }
        }

        public ActivityPanelVO(LabelObject actLabel, String actUrl, String benefitText, String timeStr) {
            this.actLabel = actLabel;
            this.actUrl = actUrl;
            this.benefitText = benefitText;
            this.timeStr = timeStr;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ActivityPanelVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.actLabel != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, LabelObject$$serializer.INSTANCE, self.actLabel);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.actUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.actUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.benefitText != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.benefitText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.timeStr != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.timeStr);
            }
        }

        public /* synthetic */ ActivityPanelVO(LabelObject labelObject, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : labelObject, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
        }

        public final LabelObject getActLabel() {
            return this.actLabel;
        }

        public final String getActUrl() {
            return this.actUrl;
        }

        public final String getBenefitText() {
            return this.benefitText;
        }

        public final String getTimeStr() {
            return this.timeStr;
        }
    }

    /* compiled from: ActivityInfoFloor.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$AtmosInfo;", "", "detailURL", "", "listURL", "tag", "tagColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDetailURL", "()Ljava/lang/String;", "getListURL", "getTag", "getTagColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AtmosInfo {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String detailURL;
        private final String listURL;
        private final String tag;
        private final String tagColor;

        public AtmosInfo() {
            this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ AtmosInfo copy$default(AtmosInfo atmosInfo, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = atmosInfo.detailURL;
            }
            if ((i & 2) != 0) {
                str2 = atmosInfo.listURL;
            }
            if ((i & 4) != 0) {
                str3 = atmosInfo.tag;
            }
            if ((i & 8) != 0) {
                str4 = atmosInfo.tagColor;
            }
            return atmosInfo.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.detailURL;
        }

        public final String component2() {
            return this.listURL;
        }

        public final String component3() {
            return this.tag;
        }

        public final String component4() {
            return this.tagColor;
        }

        public final AtmosInfo copy(String str, String str2, String str3, String str4) {
            return new AtmosInfo(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AtmosInfo) {
                AtmosInfo atmosInfo = (AtmosInfo) obj;
                return Intrinsics.areEqual(this.detailURL, atmosInfo.detailURL) && Intrinsics.areEqual(this.listURL, atmosInfo.listURL) && Intrinsics.areEqual(this.tag, atmosInfo.tag) && Intrinsics.areEqual(this.tagColor, atmosInfo.tagColor);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.detailURL == null ? 0 : this.detailURL.hashCode()) * 31) + (this.listURL == null ? 0 : this.listURL.hashCode())) * 31) + (this.tag == null ? 0 : this.tag.hashCode())) * 31) + (this.tagColor != null ? this.tagColor.hashCode() : 0);
        }

        public String toString() {
            String str = this.detailURL;
            String str2 = this.listURL;
            String str3 = this.tag;
            return "AtmosInfo(detailURL=" + str + ", listURL=" + str2 + ", tag=" + str3 + ", tagColor=" + this.tagColor + ")";
        }

        /* compiled from: ActivityInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$AtmosInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$AtmosInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<AtmosInfo> serializer() {
                return ActivityInfoFloor$AtmosInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ AtmosInfo(int seen0, String detailURL, String listURL, String tag, String tagColor, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.detailURL = null;
            } else {
                this.detailURL = detailURL;
            }
            if ((seen0 & 2) == 0) {
                this.listURL = null;
            } else {
                this.listURL = listURL;
            }
            if ((seen0 & 4) == 0) {
                this.tag = null;
            } else {
                this.tag = tag;
            }
            if ((seen0 & 8) == 0) {
                this.tagColor = null;
            } else {
                this.tagColor = tagColor;
            }
        }

        public AtmosInfo(String detailURL, String listURL, String tag, String tagColor) {
            this.detailURL = detailURL;
            this.listURL = listURL;
            this.tag = tag;
            this.tagColor = tagColor;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(AtmosInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.detailURL != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.detailURL);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.listURL != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.listURL);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.tag != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.tag);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.tagColor != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.tagColor);
            }
        }

        public /* synthetic */ AtmosInfo(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
        }

        public final String getDetailURL() {
            return this.detailURL;
        }

        public final String getListURL() {
            return this.listURL;
        }

        public final String getTag() {
            return this.tag;
        }

        public final String getTagColor() {
            return this.tagColor;
        }
    }

    /* compiled from: ActivityInfoFloor.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rB]\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\\\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u000fHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0004\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00062"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$FansPriceActivityVO;", "", "benefitText", "", "isFans", "", "showLabel", "showLabelText", "showRuleText", "upMidList", "", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBenefitText", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShowLabel", "getShowLabelText", "getShowRuleText", "getUpMidList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$FansPriceActivityVO;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class FansPriceActivityVO {
        private final String benefitText;
        private final Boolean isFans;
        private final String showLabel;
        private final String showLabelText;
        private final String showRuleText;
        private final List<Long> upMidList;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ActivityInfoFloor$FansPriceActivityVO$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = ActivityInfoFloor.FansPriceActivityVO._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        })};

        public FansPriceActivityVO() {
            this((String) null, (Boolean) null, (String) null, (String) null, (String) null, (List) null, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ FansPriceActivityVO copy$default(FansPriceActivityVO fansPriceActivityVO, String str, Boolean bool, String str2, String str3, String str4, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fansPriceActivityVO.benefitText;
            }
            if ((i & 2) != 0) {
                bool = fansPriceActivityVO.isFans;
            }
            Boolean bool2 = bool;
            if ((i & 4) != 0) {
                str2 = fansPriceActivityVO.showLabel;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = fansPriceActivityVO.showLabelText;
            }
            String str6 = str3;
            if ((i & 16) != 0) {
                str4 = fansPriceActivityVO.showRuleText;
            }
            String str7 = str4;
            List<Long> list2 = list;
            if ((i & 32) != 0) {
                list2 = fansPriceActivityVO.upMidList;
            }
            return fansPriceActivityVO.copy(str, bool2, str5, str6, str7, list2);
        }

        public final String component1() {
            return this.benefitText;
        }

        public final Boolean component2() {
            return this.isFans;
        }

        public final String component3() {
            return this.showLabel;
        }

        public final String component4() {
            return this.showLabelText;
        }

        public final String component5() {
            return this.showRuleText;
        }

        public final List<Long> component6() {
            return this.upMidList;
        }

        public final FansPriceActivityVO copy(String str, Boolean bool, String str2, String str3, String str4, List<Long> list) {
            return new FansPriceActivityVO(str, bool, str2, str3, str4, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FansPriceActivityVO) {
                FansPriceActivityVO fansPriceActivityVO = (FansPriceActivityVO) obj;
                return Intrinsics.areEqual(this.benefitText, fansPriceActivityVO.benefitText) && Intrinsics.areEqual(this.isFans, fansPriceActivityVO.isFans) && Intrinsics.areEqual(this.showLabel, fansPriceActivityVO.showLabel) && Intrinsics.areEqual(this.showLabelText, fansPriceActivityVO.showLabelText) && Intrinsics.areEqual(this.showRuleText, fansPriceActivityVO.showRuleText) && Intrinsics.areEqual(this.upMidList, fansPriceActivityVO.upMidList);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((this.benefitText == null ? 0 : this.benefitText.hashCode()) * 31) + (this.isFans == null ? 0 : this.isFans.hashCode())) * 31) + (this.showLabel == null ? 0 : this.showLabel.hashCode())) * 31) + (this.showLabelText == null ? 0 : this.showLabelText.hashCode())) * 31) + (this.showRuleText == null ? 0 : this.showRuleText.hashCode())) * 31) + (this.upMidList != null ? this.upMidList.hashCode() : 0);
        }

        public String toString() {
            String str = this.benefitText;
            Boolean bool = this.isFans;
            String str2 = this.showLabel;
            String str3 = this.showLabelText;
            String str4 = this.showRuleText;
            return "FansPriceActivityVO(benefitText=" + str + ", isFans=" + bool + ", showLabel=" + str2 + ", showLabelText=" + str3 + ", showRuleText=" + str4 + ", upMidList=" + this.upMidList + ")";
        }

        /* compiled from: ActivityInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$FansPriceActivityVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$FansPriceActivityVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<FansPriceActivityVO> serializer() {
                return ActivityInfoFloor$FansPriceActivityVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ FansPriceActivityVO(int seen0, String benefitText, Boolean isFans, String showLabel, String showLabelText, String showRuleText, List upMidList, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.benefitText = null;
            } else {
                this.benefitText = benefitText;
            }
            if ((seen0 & 2) == 0) {
                this.isFans = null;
            } else {
                this.isFans = isFans;
            }
            if ((seen0 & 4) == 0) {
                this.showLabel = null;
            } else {
                this.showLabel = showLabel;
            }
            if ((seen0 & 8) == 0) {
                this.showLabelText = null;
            } else {
                this.showLabelText = showLabelText;
            }
            if ((seen0 & 16) == 0) {
                this.showRuleText = null;
            } else {
                this.showRuleText = showRuleText;
            }
            if ((seen0 & 32) == 0) {
                this.upMidList = null;
            } else {
                this.upMidList = upMidList;
            }
        }

        public FansPriceActivityVO(String benefitText, Boolean isFans, String showLabel, String showLabelText, String showRuleText, List<Long> list) {
            this.benefitText = benefitText;
            this.isFans = isFans;
            this.showLabel = showLabel;
            this.showLabelText = showLabelText;
            this.showRuleText = showRuleText;
            this.upMidList = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(LongSerializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(FansPriceActivityVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.benefitText != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.benefitText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.isFans != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.isFans);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.showLabel != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.showLabel);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.showLabelText != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.showLabelText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.showRuleText != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.showRuleText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.upMidList != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.upMidList);
            }
        }

        public /* synthetic */ FansPriceActivityVO(String str, Boolean bool, String str2, String str3, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : list);
        }

        public final String getBenefitText() {
            return this.benefitText;
        }

        public final Boolean isFans() {
            return this.isFans;
        }

        public final String getShowLabel() {
            return this.showLabel;
        }

        public final String getShowLabelText() {
            return this.showLabelText;
        }

        public final String getShowRuleText() {
            return this.showRuleText;
        }

        public final List<Long> getUpMidList() {
            return this.upMidList;
        }
    }

    /* compiled from: ActivityInfoFloor.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$GiftActivityVO;", "", "actId", "", "actType", "", "showLabelText", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActId", "()Ljava/lang/String;", "getActType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowLabelText", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$GiftActivityVO;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class GiftActivityVO {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String actId;
        private final Integer actType;
        private final String showLabelText;

        public GiftActivityVO() {
            this((String) null, (Integer) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ GiftActivityVO copy$default(GiftActivityVO giftActivityVO, String str, Integer num, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = giftActivityVO.actId;
            }
            if ((i & 2) != 0) {
                num = giftActivityVO.actType;
            }
            if ((i & 4) != 0) {
                str2 = giftActivityVO.showLabelText;
            }
            return giftActivityVO.copy(str, num, str2);
        }

        public final String component1() {
            return this.actId;
        }

        public final Integer component2() {
            return this.actType;
        }

        public final String component3() {
            return this.showLabelText;
        }

        public final GiftActivityVO copy(String str, Integer num, String str2) {
            return new GiftActivityVO(str, num, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GiftActivityVO) {
                GiftActivityVO giftActivityVO = (GiftActivityVO) obj;
                return Intrinsics.areEqual(this.actId, giftActivityVO.actId) && Intrinsics.areEqual(this.actType, giftActivityVO.actType) && Intrinsics.areEqual(this.showLabelText, giftActivityVO.showLabelText);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.actId == null ? 0 : this.actId.hashCode()) * 31) + (this.actType == null ? 0 : this.actType.hashCode())) * 31) + (this.showLabelText != null ? this.showLabelText.hashCode() : 0);
        }

        public String toString() {
            String str = this.actId;
            Integer num = this.actType;
            return "GiftActivityVO(actId=" + str + ", actType=" + num + ", showLabelText=" + this.showLabelText + ")";
        }

        /* compiled from: ActivityInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$GiftActivityVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$GiftActivityVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<GiftActivityVO> serializer() {
                return ActivityInfoFloor$GiftActivityVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ GiftActivityVO(int seen0, String actId, Integer actType, String showLabelText, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.actId = null;
            } else {
                this.actId = actId;
            }
            if ((seen0 & 2) == 0) {
                this.actType = null;
            } else {
                this.actType = actType;
            }
            if ((seen0 & 4) == 0) {
                this.showLabelText = null;
            } else {
                this.showLabelText = showLabelText;
            }
        }

        public GiftActivityVO(String actId, Integer actType, String showLabelText) {
            this.actId = actId;
            this.actType = actType;
            this.showLabelText = showLabelText;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(GiftActivityVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.actId != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.actId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.actType != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.actType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.showLabelText != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.showLabelText);
            }
        }

        public /* synthetic */ GiftActivityVO(String str, Integer num, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2);
        }

        public final String getActId() {
            return this.actId;
        }

        public final Integer getActType() {
            return this.actType;
        }

        public final String getShowLabelText() {
            return this.showLabelText;
        }
    }

    /* compiled from: ActivityInfoFloor.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eBk\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017Jn\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0007HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001f\u0010\u0017¨\u00069"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$InstantDiscountActivityInfo;", "", "discountPrice", "", "endTime", "", "promoStatus", "", "promotionType", "showLabel", "showLabelText", "showRuleText", "startTime", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDiscountPrice", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPromoStatus", "()Ljava/lang/String;", "getPromotionType", "getShowLabel", "getShowLabelText", "getShowRuleText", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$InstantDiscountActivityInfo;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class InstantDiscountActivityInfo {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final Integer discountPrice;
        private final Long endTime;
        private final String promoStatus;
        private final String promotionType;
        private final String showLabel;
        private final String showLabelText;
        private final String showRuleText;
        private final Long startTime;

        public InstantDiscountActivityInfo() {
            this((Integer) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Long) null, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
        }

        public final Integer component1() {
            return this.discountPrice;
        }

        public final Long component2() {
            return this.endTime;
        }

        public final String component3() {
            return this.promoStatus;
        }

        public final String component4() {
            return this.promotionType;
        }

        public final String component5() {
            return this.showLabel;
        }

        public final String component6() {
            return this.showLabelText;
        }

        public final String component7() {
            return this.showRuleText;
        }

        public final Long component8() {
            return this.startTime;
        }

        public final InstantDiscountActivityInfo copy(Integer num, Long l, String str, String str2, String str3, String str4, String str5, Long l2) {
            return new InstantDiscountActivityInfo(num, l, str, str2, str3, str4, str5, l2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InstantDiscountActivityInfo) {
                InstantDiscountActivityInfo instantDiscountActivityInfo = (InstantDiscountActivityInfo) obj;
                return Intrinsics.areEqual(this.discountPrice, instantDiscountActivityInfo.discountPrice) && Intrinsics.areEqual(this.endTime, instantDiscountActivityInfo.endTime) && Intrinsics.areEqual(this.promoStatus, instantDiscountActivityInfo.promoStatus) && Intrinsics.areEqual(this.promotionType, instantDiscountActivityInfo.promotionType) && Intrinsics.areEqual(this.showLabel, instantDiscountActivityInfo.showLabel) && Intrinsics.areEqual(this.showLabelText, instantDiscountActivityInfo.showLabelText) && Intrinsics.areEqual(this.showRuleText, instantDiscountActivityInfo.showRuleText) && Intrinsics.areEqual(this.startTime, instantDiscountActivityInfo.startTime);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((this.discountPrice == null ? 0 : this.discountPrice.hashCode()) * 31) + (this.endTime == null ? 0 : this.endTime.hashCode())) * 31) + (this.promoStatus == null ? 0 : this.promoStatus.hashCode())) * 31) + (this.promotionType == null ? 0 : this.promotionType.hashCode())) * 31) + (this.showLabel == null ? 0 : this.showLabel.hashCode())) * 31) + (this.showLabelText == null ? 0 : this.showLabelText.hashCode())) * 31) + (this.showRuleText == null ? 0 : this.showRuleText.hashCode())) * 31) + (this.startTime != null ? this.startTime.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.discountPrice;
            Long l = this.endTime;
            String str = this.promoStatus;
            String str2 = this.promotionType;
            String str3 = this.showLabel;
            String str4 = this.showLabelText;
            String str5 = this.showRuleText;
            return "InstantDiscountActivityInfo(discountPrice=" + num + ", endTime=" + l + ", promoStatus=" + str + ", promotionType=" + str2 + ", showLabel=" + str3 + ", showLabelText=" + str4 + ", showRuleText=" + str5 + ", startTime=" + this.startTime + ")";
        }

        /* compiled from: ActivityInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$InstantDiscountActivityInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$InstantDiscountActivityInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<InstantDiscountActivityInfo> serializer() {
                return ActivityInfoFloor$InstantDiscountActivityInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ InstantDiscountActivityInfo(int seen0, Integer discountPrice, Long endTime, String promoStatus, String promotionType, String showLabel, String showLabelText, String showRuleText, Long startTime, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.discountPrice = null;
            } else {
                this.discountPrice = discountPrice;
            }
            if ((seen0 & 2) == 0) {
                this.endTime = null;
            } else {
                this.endTime = endTime;
            }
            if ((seen0 & 4) == 0) {
                this.promoStatus = null;
            } else {
                this.promoStatus = promoStatus;
            }
            if ((seen0 & 8) == 0) {
                this.promotionType = null;
            } else {
                this.promotionType = promotionType;
            }
            if ((seen0 & 16) == 0) {
                this.showLabel = null;
            } else {
                this.showLabel = showLabel;
            }
            if ((seen0 & 32) == 0) {
                this.showLabelText = null;
            } else {
                this.showLabelText = showLabelText;
            }
            if ((seen0 & 64) == 0) {
                this.showRuleText = null;
            } else {
                this.showRuleText = showRuleText;
            }
            if ((seen0 & 128) == 0) {
                this.startTime = null;
            } else {
                this.startTime = startTime;
            }
        }

        public InstantDiscountActivityInfo(Integer discountPrice, Long endTime, String promoStatus, String promotionType, String showLabel, String showLabelText, String showRuleText, Long startTime) {
            this.discountPrice = discountPrice;
            this.endTime = endTime;
            this.promoStatus = promoStatus;
            this.promotionType = promotionType;
            this.showLabel = showLabel;
            this.showLabelText = showLabelText;
            this.showRuleText = showRuleText;
            this.startTime = startTime;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(InstantDiscountActivityInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.discountPrice != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.discountPrice);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.endTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.endTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.promoStatus != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.promoStatus);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.promotionType != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.promotionType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.showLabel != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.showLabel);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.showLabelText != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.showLabelText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.showRuleText != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.showRuleText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.startTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, LongSerializer.INSTANCE, self.startTime);
            }
        }

        public /* synthetic */ InstantDiscountActivityInfo(Integer num, Long l, String str, String str2, String str3, String str4, String str5, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) == 0 ? l2 : null);
        }

        public final Integer getDiscountPrice() {
            return this.discountPrice;
        }

        public final Long getEndTime() {
            return this.endTime;
        }

        public final String getPromoStatus() {
            return this.promoStatus;
        }

        public final String getPromotionType() {
            return this.promotionType;
        }

        public final String getShowLabel() {
            return this.showLabel;
        }

        public final String getShowLabelText() {
            return this.showLabelText;
        }

        public final String getShowRuleText() {
            return this.showRuleText;
        }

        public final Long getStartTime() {
            return this.startTime;
        }
    }

    /* compiled from: ActivityInfoFloor.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0003LMNB©\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0015\u0010\u0016B£\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0015\u0010\u001aJ\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00104\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010&J\u000b\u00107\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010:\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ°\u0001\u0010=\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u0003HÖ\u0001J\t\u0010C\u001a\u00020\nHÖ\u0001J%\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0001¢\u0006\u0002\bKR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b \u0010\u001cR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b!\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001cR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b*\u0010\u001cR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b/\u0010\u001c¨\u0006O"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$LuckyBuySubsideActivityInfoVO;", "", "activityId", "", "activitySkus", "", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$ActivitySku;", "countdownTime", "endTime", "marketingId", "", "publishTime", "serverTime", "", "showLabel", "showSummary", "startTime", "subProcess", "type", "", "warmUpTime", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActivitySkus", "()Ljava/util/List;", "getCountdownTime", "getEndTime", "getMarketingId", "()Ljava/lang/String;", "getPublishTime", "getServerTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getShowLabel", "getShowSummary", "getStartTime", "getSubProcess", "getType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getWarmUpTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$LuckyBuySubsideActivityInfoVO;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ActivitySku", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LuckyBuySubsideActivityInfoVO {
        private final Integer activityId;
        private final List<ActivitySku> activitySkus;
        private final Integer countdownTime;
        private final Integer endTime;
        private final String marketingId;
        private final Integer publishTime;
        private final Long serverTime;
        private final String showLabel;
        private final String showSummary;
        private final Integer startTime;
        private final String subProcess;
        private final Byte type;
        private final Integer warmUpTime;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = ActivityInfoFloor.LuckyBuySubsideActivityInfoVO._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, null, null, null, null, null, null, null, null, null, null};

        public LuckyBuySubsideActivityInfoVO() {
            this((Integer) null, (List) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (Long) null, (String) null, (String) null, (Integer) null, (String) null, (Byte) null, (Integer) null, 8191, (DefaultConstructorMarker) null);
        }

        public final Integer component1() {
            return this.activityId;
        }

        public final Integer component10() {
            return this.startTime;
        }

        public final String component11() {
            return this.subProcess;
        }

        public final Byte component12() {
            return this.type;
        }

        public final Integer component13() {
            return this.warmUpTime;
        }

        public final List<ActivitySku> component2() {
            return this.activitySkus;
        }

        public final Integer component3() {
            return this.countdownTime;
        }

        public final Integer component4() {
            return this.endTime;
        }

        public final String component5() {
            return this.marketingId;
        }

        public final Integer component6() {
            return this.publishTime;
        }

        public final Long component7() {
            return this.serverTime;
        }

        public final String component8() {
            return this.showLabel;
        }

        public final String component9() {
            return this.showSummary;
        }

        public final LuckyBuySubsideActivityInfoVO copy(Integer num, List<ActivitySku> list, Integer num2, Integer num3, String str, Integer num4, Long l, String str2, String str3, Integer num5, String str4, Byte b, Integer num6) {
            return new LuckyBuySubsideActivityInfoVO(num, list, num2, num3, str, num4, l, str2, str3, num5, str4, b, num6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LuckyBuySubsideActivityInfoVO) {
                LuckyBuySubsideActivityInfoVO luckyBuySubsideActivityInfoVO = (LuckyBuySubsideActivityInfoVO) obj;
                return Intrinsics.areEqual(this.activityId, luckyBuySubsideActivityInfoVO.activityId) && Intrinsics.areEqual(this.activitySkus, luckyBuySubsideActivityInfoVO.activitySkus) && Intrinsics.areEqual(this.countdownTime, luckyBuySubsideActivityInfoVO.countdownTime) && Intrinsics.areEqual(this.endTime, luckyBuySubsideActivityInfoVO.endTime) && Intrinsics.areEqual(this.marketingId, luckyBuySubsideActivityInfoVO.marketingId) && Intrinsics.areEqual(this.publishTime, luckyBuySubsideActivityInfoVO.publishTime) && Intrinsics.areEqual(this.serverTime, luckyBuySubsideActivityInfoVO.serverTime) && Intrinsics.areEqual(this.showLabel, luckyBuySubsideActivityInfoVO.showLabel) && Intrinsics.areEqual(this.showSummary, luckyBuySubsideActivityInfoVO.showSummary) && Intrinsics.areEqual(this.startTime, luckyBuySubsideActivityInfoVO.startTime) && Intrinsics.areEqual(this.subProcess, luckyBuySubsideActivityInfoVO.subProcess) && Intrinsics.areEqual(this.type, luckyBuySubsideActivityInfoVO.type) && Intrinsics.areEqual(this.warmUpTime, luckyBuySubsideActivityInfoVO.warmUpTime);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((this.activityId == null ? 0 : this.activityId.hashCode()) * 31) + (this.activitySkus == null ? 0 : this.activitySkus.hashCode())) * 31) + (this.countdownTime == null ? 0 : this.countdownTime.hashCode())) * 31) + (this.endTime == null ? 0 : this.endTime.hashCode())) * 31) + (this.marketingId == null ? 0 : this.marketingId.hashCode())) * 31) + (this.publishTime == null ? 0 : this.publishTime.hashCode())) * 31) + (this.serverTime == null ? 0 : this.serverTime.hashCode())) * 31) + (this.showLabel == null ? 0 : this.showLabel.hashCode())) * 31) + (this.showSummary == null ? 0 : this.showSummary.hashCode())) * 31) + (this.startTime == null ? 0 : this.startTime.hashCode())) * 31) + (this.subProcess == null ? 0 : this.subProcess.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.warmUpTime != null ? this.warmUpTime.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.activityId;
            List<ActivitySku> list = this.activitySkus;
            Integer num2 = this.countdownTime;
            Integer num3 = this.endTime;
            String str = this.marketingId;
            Integer num4 = this.publishTime;
            Long l = this.serverTime;
            String str2 = this.showLabel;
            String str3 = this.showSummary;
            Integer num5 = this.startTime;
            String str4 = this.subProcess;
            Byte b = this.type;
            return "LuckyBuySubsideActivityInfoVO(activityId=" + num + ", activitySkus=" + list + ", countdownTime=" + num2 + ", endTime=" + num3 + ", marketingId=" + str + ", publishTime=" + num4 + ", serverTime=" + l + ", showLabel=" + str2 + ", showSummary=" + str3 + ", startTime=" + num5 + ", subProcess=" + str4 + ", type=" + b + ", warmUpTime=" + this.warmUpTime + ")";
        }

        /* compiled from: ActivityInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$LuckyBuySubsideActivityInfoVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<LuckyBuySubsideActivityInfoVO> serializer() {
                return ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ LuckyBuySubsideActivityInfoVO(int seen0, Integer activityId, List activitySkus, Integer countdownTime, Integer endTime, String marketingId, Integer publishTime, Long serverTime, String showLabel, String showSummary, Integer startTime, String subProcess, Byte type, Integer warmUpTime, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.activityId = null;
            } else {
                this.activityId = activityId;
            }
            if ((seen0 & 2) == 0) {
                this.activitySkus = null;
            } else {
                this.activitySkus = activitySkus;
            }
            if ((seen0 & 4) == 0) {
                this.countdownTime = null;
            } else {
                this.countdownTime = countdownTime;
            }
            if ((seen0 & 8) == 0) {
                this.endTime = null;
            } else {
                this.endTime = endTime;
            }
            if ((seen0 & 16) == 0) {
                this.marketingId = null;
            } else {
                this.marketingId = marketingId;
            }
            if ((seen0 & 32) == 0) {
                this.publishTime = null;
            } else {
                this.publishTime = publishTime;
            }
            if ((seen0 & 64) == 0) {
                this.serverTime = null;
            } else {
                this.serverTime = serverTime;
            }
            if ((seen0 & 128) == 0) {
                this.showLabel = null;
            } else {
                this.showLabel = showLabel;
            }
            if ((seen0 & 256) == 0) {
                this.showSummary = null;
            } else {
                this.showSummary = showSummary;
            }
            if ((seen0 & 512) == 0) {
                this.startTime = null;
            } else {
                this.startTime = startTime;
            }
            if ((seen0 & 1024) == 0) {
                this.subProcess = null;
            } else {
                this.subProcess = subProcess;
            }
            if ((seen0 & 2048) == 0) {
                this.type = null;
            } else {
                this.type = type;
            }
            if ((seen0 & 4096) == 0) {
                this.warmUpTime = null;
            } else {
                this.warmUpTime = warmUpTime;
            }
        }

        public LuckyBuySubsideActivityInfoVO(Integer activityId, List<ActivitySku> list, Integer countdownTime, Integer endTime, String marketingId, Integer publishTime, Long serverTime, String showLabel, String showSummary, Integer startTime, String subProcess, Byte type, Integer warmUpTime) {
            this.activityId = activityId;
            this.activitySkus = list;
            this.countdownTime = countdownTime;
            this.endTime = endTime;
            this.marketingId = marketingId;
            this.publishTime = publishTime;
            this.serverTime = serverTime;
            this.showLabel = showLabel;
            this.showSummary = showSummary;
            this.startTime = startTime;
            this.subProcess = subProcess;
            this.type = type;
            this.warmUpTime = warmUpTime;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$ActivitySku$$serializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(LuckyBuySubsideActivityInfoVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activityId != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.activityId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.activitySkus != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.activitySkus);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.countdownTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.countdownTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.endTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.endTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.marketingId != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.marketingId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.publishTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.publishTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.serverTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, LongSerializer.INSTANCE, self.serverTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.showLabel != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.showLabel);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.showSummary != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.showSummary);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.startTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.startTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.subProcess != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.subProcess);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.type != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, ByteSerializer.INSTANCE, self.type);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.warmUpTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, IntSerializer.INSTANCE, self.warmUpTime);
            }
        }

        public /* synthetic */ LuckyBuySubsideActivityInfoVO(Integer num, List list, Integer num2, Integer num3, String str, Integer num4, Long l, String str2, String str3, Integer num5, String str4, Byte b, Integer num6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : num4, (i & 64) != 0 ? null : l, (i & 128) != 0 ? null : str2, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : num5, (i & 1024) != 0 ? null : str4, (i & 2048) != 0 ? null : b, (i & 4096) == 0 ? num6 : null);
        }

        public final Integer getActivityId() {
            return this.activityId;
        }

        public final List<ActivitySku> getActivitySkus() {
            return this.activitySkus;
        }

        public final Integer getCountdownTime() {
            return this.countdownTime;
        }

        public final Integer getEndTime() {
            return this.endTime;
        }

        public final String getMarketingId() {
            return this.marketingId;
        }

        public final Integer getPublishTime() {
            return this.publishTime;
        }

        public final Long getServerTime() {
            return this.serverTime;
        }

        public final String getShowLabel() {
            return this.showLabel;
        }

        public final String getShowSummary() {
            return this.showSummary;
        }

        public final Integer getStartTime() {
            return this.startTime;
        }

        public final String getSubProcess() {
            return this.subProcess;
        }

        public final Byte getType() {
            return this.type;
        }

        /* compiled from: ActivityInfoFloor.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006!"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$ActivitySku;", "", "skuId", "", "<init>", "(Ljava/lang/Long;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSkuId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "copy", "(Ljava/lang/Long;)Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$ActivitySku;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class ActivitySku {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final Long skuId;

            public ActivitySku() {
                this((Long) null, 1, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ ActivitySku copy$default(ActivitySku activitySku, Long l, int i, Object obj) {
                if ((i & 1) != 0) {
                    l = activitySku.skuId;
                }
                return activitySku.copy(l);
            }

            public final Long component1() {
                return this.skuId;
            }

            public final ActivitySku copy(Long l) {
                return new ActivitySku(l);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ActivitySku) && Intrinsics.areEqual(this.skuId, ((ActivitySku) obj).skuId);
            }

            public int hashCode() {
                if (this.skuId == null) {
                    return 0;
                }
                return this.skuId.hashCode();
            }

            public String toString() {
                return "ActivitySku(skuId=" + this.skuId + ")";
            }

            /* compiled from: ActivityInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$ActivitySku$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$ActivitySku;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<ActivitySku> serializer() {
                    return ActivityInfoFloor$LuckyBuySubsideActivityInfoVO$ActivitySku$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ ActivitySku(int seen0, Long skuId, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.skuId = null;
                } else {
                    this.skuId = skuId;
                }
            }

            public ActivitySku(Long skuId) {
                this.skuId = skuId;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(ActivitySku self, CompositeEncoder output, SerialDescriptor serialDesc) {
                boolean z = true;
                if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.skuId == null) {
                    z = false;
                }
                if (z) {
                    output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.skuId);
                }
            }

            public /* synthetic */ ActivitySku(Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : l);
            }

            public final Long getSkuId() {
                return this.skuId;
            }
        }

        public final Integer getWarmUpTime() {
            return this.warmUpTime;
        }
    }

    /* compiled from: ActivityInfoFloor.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000223B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBa\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001aJb\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u000eHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J%\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u00064"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ProgressActivityInfo;", "", "activityId", "", "activityName", "description", "fullText", "jumpUrl", "modalText", "type", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityId", "()Ljava/lang/String;", "getActivityName", "getDescription", "getFullText", "getJumpUrl", "getModalText", "getType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;)Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ProgressActivityInfo;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ProgressActivityInfo {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String activityId;
        private final String activityName;
        private final String description;
        private final String fullText;
        private final String jumpUrl;
        private final String modalText;
        private final Byte type;

        public ProgressActivityInfo() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Byte) null, 127, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ProgressActivityInfo copy$default(ProgressActivityInfo progressActivityInfo, String str, String str2, String str3, String str4, String str5, String str6, Byte b, int i, Object obj) {
            if ((i & 1) != 0) {
                str = progressActivityInfo.activityId;
            }
            if ((i & 2) != 0) {
                str2 = progressActivityInfo.activityName;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                str3 = progressActivityInfo.description;
            }
            String str8 = str3;
            if ((i & 8) != 0) {
                str4 = progressActivityInfo.fullText;
            }
            String str9 = str4;
            if ((i & 16) != 0) {
                str5 = progressActivityInfo.jumpUrl;
            }
            String str10 = str5;
            if ((i & 32) != 0) {
                str6 = progressActivityInfo.modalText;
            }
            String str11 = str6;
            if ((i & 64) != 0) {
                b = progressActivityInfo.type;
            }
            return progressActivityInfo.copy(str, str7, str8, str9, str10, str11, b);
        }

        public final String component1() {
            return this.activityId;
        }

        public final String component2() {
            return this.activityName;
        }

        public final String component3() {
            return this.description;
        }

        public final String component4() {
            return this.fullText;
        }

        public final String component5() {
            return this.jumpUrl;
        }

        public final String component6() {
            return this.modalText;
        }

        public final Byte component7() {
            return this.type;
        }

        public final ProgressActivityInfo copy(String str, String str2, String str3, String str4, String str5, String str6, Byte b) {
            return new ProgressActivityInfo(str, str2, str3, str4, str5, str6, b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ProgressActivityInfo) {
                ProgressActivityInfo progressActivityInfo = (ProgressActivityInfo) obj;
                return Intrinsics.areEqual(this.activityId, progressActivityInfo.activityId) && Intrinsics.areEqual(this.activityName, progressActivityInfo.activityName) && Intrinsics.areEqual(this.description, progressActivityInfo.description) && Intrinsics.areEqual(this.fullText, progressActivityInfo.fullText) && Intrinsics.areEqual(this.jumpUrl, progressActivityInfo.jumpUrl) && Intrinsics.areEqual(this.modalText, progressActivityInfo.modalText) && Intrinsics.areEqual(this.type, progressActivityInfo.type);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((this.activityId == null ? 0 : this.activityId.hashCode()) * 31) + (this.activityName == null ? 0 : this.activityName.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.fullText == null ? 0 : this.fullText.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.modalText == null ? 0 : this.modalText.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
        }

        public String toString() {
            String str = this.activityId;
            String str2 = this.activityName;
            String str3 = this.description;
            String str4 = this.fullText;
            String str5 = this.jumpUrl;
            String str6 = this.modalText;
            return "ProgressActivityInfo(activityId=" + str + ", activityName=" + str2 + ", description=" + str3 + ", fullText=" + str4 + ", jumpUrl=" + str5 + ", modalText=" + str6 + ", type=" + this.type + ")";
        }

        /* compiled from: ActivityInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ProgressActivityInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActivityInfoFloor$ProgressActivityInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ProgressActivityInfo> serializer() {
                return ActivityInfoFloor$ProgressActivityInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ProgressActivityInfo(int seen0, String activityId, String activityName, String description, String fullText, String jumpUrl, String modalText, Byte type, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.activityId = null;
            } else {
                this.activityId = activityId;
            }
            if ((seen0 & 2) == 0) {
                this.activityName = null;
            } else {
                this.activityName = activityName;
            }
            if ((seen0 & 4) == 0) {
                this.description = null;
            } else {
                this.description = description;
            }
            if ((seen0 & 8) == 0) {
                this.fullText = null;
            } else {
                this.fullText = fullText;
            }
            if ((seen0 & 16) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
            if ((seen0 & 32) == 0) {
                this.modalText = null;
            } else {
                this.modalText = modalText;
            }
            if ((seen0 & 64) == 0) {
                this.type = null;
            } else {
                this.type = type;
            }
        }

        public ProgressActivityInfo(String activityId, String activityName, String description, String fullText, String jumpUrl, String modalText, Byte type) {
            this.activityId = activityId;
            this.activityName = activityName;
            this.description = description;
            this.fullText = fullText;
            this.jumpUrl = jumpUrl;
            this.modalText = modalText;
            this.type = type;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ProgressActivityInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activityId != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.activityId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.activityName != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.activityName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.description != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.description);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.fullText != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.fullText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.jumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.modalText != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.modalText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.type != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, ByteSerializer.INSTANCE, self.type);
            }
        }

        public /* synthetic */ ProgressActivityInfo(String str, String str2, String str3, String str4, String str5, String str6, Byte b, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : b);
        }

        public final String getActivityId() {
            return this.activityId;
        }

        public final String getActivityName() {
            return this.activityName;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getFullText() {
            return this.fullText;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final String getModalText() {
            return this.modalText;
        }

        public final Byte getType() {
            return this.type;
        }
    }

    public final boolean isLuckBuySubsidy$product_details_page_debug() {
        LuckyBuySubsideActivityInfoVO luckyBuySubsideActivityInfoVO = this.luckyBuySubsideActivityInfoVO;
        return (luckyBuySubsideActivityInfoVO != null ? luckyBuySubsideActivityInfoVO.getActivityId() : null) != null;
    }
}