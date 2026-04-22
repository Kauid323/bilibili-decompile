package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.CouponListResponse;
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

/* compiled from: CouponInfoFloor.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 42\u00020\u0001:\u00041234Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eBi\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0003Jc\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0010HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019¨\u00065"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "benefitInfos", "", "Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "couponList", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$CouponInfo;", "tagList", "Lkntr/app/mall/product/details/page/api/model/LabelObject;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getBenefitInfos", "()Ljava/util/List;", "getCouponList", "getTagList", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "CouponInfo", "DetailNetPriceInfo", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class CouponInfoFloor implements FloorModel {
    private final List<TextColorModel> benefitInfos;
    private final String bgImgUrl;
    private final List<CouponInfo> couponList;
    private final String floorIcon;
    private final String floorKey;
    private final List<LabelObject> tagList;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.CouponInfoFloor$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = CouponInfoFloor._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.CouponInfoFloor$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = CouponInfoFloor._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.CouponInfoFloor$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = CouponInfoFloor._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    })};

    public CouponInfoFloor() {
        this((String) null, (String) null, (String) null, (List) null, (List) null, (List) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CouponInfoFloor copy$default(CouponInfoFloor couponInfoFloor, String str, String str2, String str3, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = couponInfoFloor.floorKey;
        }
        if ((i & 2) != 0) {
            str2 = couponInfoFloor.floorIcon;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = couponInfoFloor.bgImgUrl;
        }
        String str5 = str3;
        List<TextColorModel> list4 = list;
        if ((i & 8) != 0) {
            list4 = couponInfoFloor.benefitInfos;
        }
        List list5 = list4;
        List<CouponInfo> list6 = list2;
        if ((i & 16) != 0) {
            list6 = couponInfoFloor.couponList;
        }
        List list7 = list6;
        List<LabelObject> list8 = list3;
        if ((i & 32) != 0) {
            list8 = couponInfoFloor.tagList;
        }
        return couponInfoFloor.copy(str, str4, str5, list5, list7, list8);
    }

    public final String component1() {
        return this.floorKey;
    }

    public final String component2() {
        return this.floorIcon;
    }

    public final String component3() {
        return this.bgImgUrl;
    }

    public final List<TextColorModel> component4() {
        return this.benefitInfos;
    }

    public final List<CouponInfo> component5() {
        return this.couponList;
    }

    public final List<LabelObject> component6() {
        return this.tagList;
    }

    public final CouponInfoFloor copy(String str, String str2, String str3, List<TextColorModel> list, List<CouponInfo> list2, List<LabelObject> list3) {
        return new CouponInfoFloor(str, str2, str3, list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CouponInfoFloor) {
            CouponInfoFloor couponInfoFloor = (CouponInfoFloor) obj;
            return Intrinsics.areEqual(this.floorKey, couponInfoFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, couponInfoFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, couponInfoFloor.bgImgUrl) && Intrinsics.areEqual(this.benefitInfos, couponInfoFloor.benefitInfos) && Intrinsics.areEqual(this.couponList, couponInfoFloor.couponList) && Intrinsics.areEqual(this.tagList, couponInfoFloor.tagList);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.benefitInfos == null ? 0 : this.benefitInfos.hashCode())) * 31) + (this.couponList == null ? 0 : this.couponList.hashCode())) * 31) + (this.tagList != null ? this.tagList.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        List<TextColorModel> list = this.benefitInfos;
        List<CouponInfo> list2 = this.couponList;
        return "CouponInfoFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", benefitInfos=" + list + ", couponList=" + list2 + ", tagList=" + this.tagList + ")";
    }

    /* compiled from: CouponInfoFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CouponInfoFloor> serializer() {
            return CouponInfoFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CouponInfoFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, List benefitInfos, List couponList, List tagList, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.benefitInfos = null;
        } else {
            this.benefitInfos = benefitInfos;
        }
        if ((seen0 & 16) == 0) {
            this.couponList = null;
        } else {
            this.couponList = couponList;
        }
        if ((seen0 & 32) == 0) {
            this.tagList = null;
        } else {
            this.tagList = tagList;
        }
    }

    public CouponInfoFloor(String floorKey, String floorIcon, String bgImgUrl, List<TextColorModel> list, List<CouponInfo> list2, List<LabelObject> list3) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.benefitInfos = list;
        this.couponList = list2;
        this.tagList = list3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(TextColorModel$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(CouponInfoFloor$CouponInfo$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(LabelObject$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(CouponInfoFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.benefitInfos != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.benefitInfos);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.couponList != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.couponList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.tagList != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.tagList);
        }
    }

    public /* synthetic */ CouponInfoFloor(String str, String str2, String str3, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : list3);
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

    public final List<TextColorModel> getBenefitInfos() {
        return this.benefitInfos;
    }

    public final List<CouponInfo> getCouponList() {
        return this.couponList;
    }

    /* compiled from: CouponInfoFloor.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 d2\u00020\u0001:\u0003bcdBý\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001d\u0010\u001eBé\u0001\b\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0004\b\u001d\u0010\"J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010I\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010J\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010*J\u0011\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010Q\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010R\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010;J\u0010\u0010S\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010;J\u0084\u0002\u0010T\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0002\u0010UJ\u0013\u0010V\u001a\u00020\u000f2\b\u0010W\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010X\u001a\u00020\u0019HÖ\u0001J\t\u0010Y\u001a\u00020\u0003HÖ\u0001J%\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u00002\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`H\u0001¢\u0006\u0002\baR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u00102\u001a\u0004\b\u000e\u00101R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010+\u001a\u0004\b3\u0010*R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010$R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010$R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010$R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010<\u001a\u0004\b:\u0010;R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010+\u001a\u0004\b=\u0010*R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010<\u001a\u0004\b>\u0010;R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010<\u001a\u0004\b?\u0010;¨\u0006e"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$CouponInfo;", "", "couponId", "", "couponName", "couponStatus", "couponStatusMsg", "couponTag", "couponType", "", "couponTypeDesc", "discount", "discountY", "", "isExclusive", "", "newUserLimit", "sceneInfoList", "", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$CouponInfo$SceneInfo;", "shopLabel", "showName", "sourceAuthorityId", "sourceId", "useEffectDays", "", "useEffectUnit", "useEndTime", "useStartTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCouponId", "()Ljava/lang/String;", "getCouponName", "getCouponStatus", "getCouponStatusMsg", "getCouponTag", "getCouponType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getCouponTypeDesc", "getDiscount", "getDiscountY", "()Ljava/lang/Double;", "Ljava/lang/Double;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNewUserLimit", "getSceneInfoList", "()Ljava/util/List;", "getShopLabel", "getShowName", "getSourceAuthorityId", "getSourceId", "getUseEffectDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUseEffectUnit", "getUseEndTime", "getUseStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Byte;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$CouponInfo;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "SceneInfo", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CouponInfo {
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
        private final List<SceneInfo> sceneInfoList;
        private final String shopLabel;
        private final String showName;
        private final String sourceAuthorityId;
        private final String sourceId;
        private final Integer useEffectDays;
        private final Byte useEffectUnit;
        private final Integer useEndTime;
        private final Integer useStartTime;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.CouponInfoFloor$CouponInfo$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = CouponInfoFloor.CouponInfo._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, null, null, null, null, null, null, null};

        public CouponInfo() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, (Byte) null, (String) null, (String) null, (Double) null, (Boolean) null, (Byte) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Byte) null, (Integer) null, (Integer) null, 1048575, (DefaultConstructorMarker) null);
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

        public final List<SceneInfo> component12() {
            return this.sceneInfoList;
        }

        public final String component13() {
            return this.shopLabel;
        }

        public final String component14() {
            return this.showName;
        }

        public final String component15() {
            return this.sourceAuthorityId;
        }

        public final String component16() {
            return this.sourceId;
        }

        public final Integer component17() {
            return this.useEffectDays;
        }

        public final Byte component18() {
            return this.useEffectUnit;
        }

        public final Integer component19() {
            return this.useEndTime;
        }

        public final String component2() {
            return this.couponName;
        }

        public final Integer component20() {
            return this.useStartTime;
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

        public final CouponInfo copy(String str, String str2, String str3, String str4, String str5, Byte b, String str6, String str7, Double d, Boolean bool, Byte b2, List<SceneInfo> list, String str8, String str9, String str10, String str11, Integer num, Byte b3, Integer num2, Integer num3) {
            return new CouponInfo(str, str2, str3, str4, str5, b, str6, str7, d, bool, b2, list, str8, str9, str10, str11, num, b3, num2, num3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CouponInfo) {
                CouponInfo couponInfo = (CouponInfo) obj;
                return Intrinsics.areEqual(this.couponId, couponInfo.couponId) && Intrinsics.areEqual(this.couponName, couponInfo.couponName) && Intrinsics.areEqual(this.couponStatus, couponInfo.couponStatus) && Intrinsics.areEqual(this.couponStatusMsg, couponInfo.couponStatusMsg) && Intrinsics.areEqual(this.couponTag, couponInfo.couponTag) && Intrinsics.areEqual(this.couponType, couponInfo.couponType) && Intrinsics.areEqual(this.couponTypeDesc, couponInfo.couponTypeDesc) && Intrinsics.areEqual(this.discount, couponInfo.discount) && Intrinsics.areEqual(this.discountY, couponInfo.discountY) && Intrinsics.areEqual(this.isExclusive, couponInfo.isExclusive) && Intrinsics.areEqual(this.newUserLimit, couponInfo.newUserLimit) && Intrinsics.areEqual(this.sceneInfoList, couponInfo.sceneInfoList) && Intrinsics.areEqual(this.shopLabel, couponInfo.shopLabel) && Intrinsics.areEqual(this.showName, couponInfo.showName) && Intrinsics.areEqual(this.sourceAuthorityId, couponInfo.sourceAuthorityId) && Intrinsics.areEqual(this.sourceId, couponInfo.sourceId) && Intrinsics.areEqual(this.useEffectDays, couponInfo.useEffectDays) && Intrinsics.areEqual(this.useEffectUnit, couponInfo.useEffectUnit) && Intrinsics.areEqual(this.useEndTime, couponInfo.useEndTime) && Intrinsics.areEqual(this.useStartTime, couponInfo.useStartTime);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((this.couponId == null ? 0 : this.couponId.hashCode()) * 31) + (this.couponName == null ? 0 : this.couponName.hashCode())) * 31) + (this.couponStatus == null ? 0 : this.couponStatus.hashCode())) * 31) + (this.couponStatusMsg == null ? 0 : this.couponStatusMsg.hashCode())) * 31) + (this.couponTag == null ? 0 : this.couponTag.hashCode())) * 31) + (this.couponType == null ? 0 : this.couponType.hashCode())) * 31) + (this.couponTypeDesc == null ? 0 : this.couponTypeDesc.hashCode())) * 31) + (this.discount == null ? 0 : this.discount.hashCode())) * 31) + (this.discountY == null ? 0 : this.discountY.hashCode())) * 31) + (this.isExclusive == null ? 0 : this.isExclusive.hashCode())) * 31) + (this.newUserLimit == null ? 0 : this.newUserLimit.hashCode())) * 31) + (this.sceneInfoList == null ? 0 : this.sceneInfoList.hashCode())) * 31) + (this.shopLabel == null ? 0 : this.shopLabel.hashCode())) * 31) + (this.showName == null ? 0 : this.showName.hashCode())) * 31) + (this.sourceAuthorityId == null ? 0 : this.sourceAuthorityId.hashCode())) * 31) + (this.sourceId == null ? 0 : this.sourceId.hashCode())) * 31) + (this.useEffectDays == null ? 0 : this.useEffectDays.hashCode())) * 31) + (this.useEffectUnit == null ? 0 : this.useEffectUnit.hashCode())) * 31) + (this.useEndTime == null ? 0 : this.useEndTime.hashCode())) * 31) + (this.useStartTime != null ? this.useStartTime.hashCode() : 0);
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
            List<SceneInfo> list = this.sceneInfoList;
            String str8 = this.shopLabel;
            String str9 = this.showName;
            String str10 = this.sourceAuthorityId;
            String str11 = this.sourceId;
            Integer num = this.useEffectDays;
            Byte b3 = this.useEffectUnit;
            Integer num2 = this.useEndTime;
            return "CouponInfo(couponId=" + str + ", couponName=" + str2 + ", couponStatus=" + str3 + ", couponStatusMsg=" + str4 + ", couponTag=" + str5 + ", couponType=" + b + ", couponTypeDesc=" + str6 + ", discount=" + str7 + ", discountY=" + d + ", isExclusive=" + bool + ", newUserLimit=" + b2 + ", sceneInfoList=" + list + ", shopLabel=" + str8 + ", showName=" + str9 + ", sourceAuthorityId=" + str10 + ", sourceId=" + str11 + ", useEffectDays=" + num + ", useEffectUnit=" + b3 + ", useEndTime=" + num2 + ", useStartTime=" + this.useStartTime + ")";
        }

        /* compiled from: CouponInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$CouponInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$CouponInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CouponInfo> serializer() {
                return CouponInfoFloor$CouponInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ CouponInfo(int seen0, String couponId, String couponName, String couponStatus, String couponStatusMsg, String couponTag, Byte couponType, String couponTypeDesc, String discount, Double discountY, Boolean isExclusive, Byte newUserLimit, List sceneInfoList, String shopLabel, String showName, String sourceAuthorityId, String sourceId, Integer useEffectDays, Byte useEffectUnit, Integer useEndTime, Integer useStartTime, SerializationConstructorMarker serializationConstructorMarker) {
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
                this.sceneInfoList = null;
            } else {
                this.sceneInfoList = sceneInfoList;
            }
            if ((seen0 & 4096) == 0) {
                this.shopLabel = null;
            } else {
                this.shopLabel = shopLabel;
            }
            if ((seen0 & 8192) == 0) {
                this.showName = null;
            } else {
                this.showName = showName;
            }
            if ((seen0 & 16384) == 0) {
                this.sourceAuthorityId = null;
            } else {
                this.sourceAuthorityId = sourceAuthorityId;
            }
            if ((seen0 & 32768) == 0) {
                this.sourceId = null;
            } else {
                this.sourceId = sourceId;
            }
            if ((seen0 & 65536) == 0) {
                this.useEffectDays = null;
            } else {
                this.useEffectDays = useEffectDays;
            }
            if ((seen0 & 131072) == 0) {
                this.useEffectUnit = null;
            } else {
                this.useEffectUnit = useEffectUnit;
            }
            if ((seen0 & 262144) == 0) {
                this.useEndTime = null;
            } else {
                this.useEndTime = useEndTime;
            }
            if ((seen0 & 524288) == 0) {
                this.useStartTime = null;
            } else {
                this.useStartTime = useStartTime;
            }
        }

        public CouponInfo(String couponId, String couponName, String couponStatus, String couponStatusMsg, String couponTag, Byte couponType, String couponTypeDesc, String discount, Double discountY, Boolean isExclusive, Byte newUserLimit, List<SceneInfo> list, String shopLabel, String showName, String sourceAuthorityId, String sourceId, Integer useEffectDays, Byte useEffectUnit, Integer useEndTime, Integer useStartTime) {
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
            this.sceneInfoList = list;
            this.shopLabel = shopLabel;
            this.showName = showName;
            this.sourceAuthorityId = sourceAuthorityId;
            this.sourceId = sourceId;
            this.useEffectDays = useEffectDays;
            this.useEffectUnit = useEffectUnit;
            this.useEndTime = useEndTime;
            this.useStartTime = useStartTime;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(CouponInfoFloor$CouponInfo$SceneInfo$$serializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(CouponInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
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
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.sceneInfoList != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, lazyArr[11].getValue(), self.sceneInfoList);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.shopLabel != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.shopLabel);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.showName != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.showName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.sourceAuthorityId != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.sourceAuthorityId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.sourceId != null) {
                output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.sourceId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.useEffectDays != null) {
                output.encodeNullableSerializableElement(serialDesc, 16, IntSerializer.INSTANCE, self.useEffectDays);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 17) || self.useEffectUnit != null) {
                output.encodeNullableSerializableElement(serialDesc, 17, ByteSerializer.INSTANCE, self.useEffectUnit);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 18) || self.useEndTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 18, IntSerializer.INSTANCE, self.useEndTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 19) || self.useStartTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 19, IntSerializer.INSTANCE, self.useStartTime);
            }
        }

        public /* synthetic */ CouponInfo(String str, String str2, String str3, String str4, String str5, Byte b, String str6, String str7, Double d, Boolean bool, Byte b2, List list, String str8, String str9, String str10, String str11, Integer num, Byte b3, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : b, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : d, (i & 512) != 0 ? null : bool, (i & 1024) != 0 ? null : b2, (i & 2048) != 0 ? null : list, (i & 4096) != 0 ? null : str8, (i & 8192) != 0 ? null : str9, (i & 16384) != 0 ? null : str10, (i & 32768) != 0 ? null : str11, (i & 65536) != 0 ? null : num, (i & 131072) != 0 ? null : b3, (i & 262144) != 0 ? null : num2, (i & 524288) != 0 ? null : num3);
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

        public final List<SceneInfo> getSceneInfoList() {
            return this.sceneInfoList;
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

        /* compiled from: CouponInfoFloor.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r¨\u0006$"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$CouponInfo$SceneInfo;", "", "parentSceneId", "", "sceneId", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getParentSceneId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSceneId", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$CouponInfo$SceneInfo;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class SceneInfo {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final Long parentSceneId;
            private final Long sceneId;

            public SceneInfo() {
                this((Long) null, (Long) null, 3, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ SceneInfo copy$default(SceneInfo sceneInfo, Long l, Long l2, int i, Object obj) {
                if ((i & 1) != 0) {
                    l = sceneInfo.parentSceneId;
                }
                if ((i & 2) != 0) {
                    l2 = sceneInfo.sceneId;
                }
                return sceneInfo.copy(l, l2);
            }

            public final Long component1() {
                return this.parentSceneId;
            }

            public final Long component2() {
                return this.sceneId;
            }

            public final SceneInfo copy(Long l, Long l2) {
                return new SceneInfo(l, l2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof SceneInfo) {
                    SceneInfo sceneInfo = (SceneInfo) obj;
                    return Intrinsics.areEqual(this.parentSceneId, sceneInfo.parentSceneId) && Intrinsics.areEqual(this.sceneId, sceneInfo.sceneId);
                }
                return false;
            }

            public int hashCode() {
                return ((this.parentSceneId == null ? 0 : this.parentSceneId.hashCode()) * 31) + (this.sceneId != null ? this.sceneId.hashCode() : 0);
            }

            public String toString() {
                Long l = this.parentSceneId;
                return "SceneInfo(parentSceneId=" + l + ", sceneId=" + this.sceneId + ")";
            }

            /* compiled from: CouponInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$CouponInfo$SceneInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$CouponInfo$SceneInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<SceneInfo> serializer() {
                    return CouponInfoFloor$CouponInfo$SceneInfo$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ SceneInfo(int seen0, Long parentSceneId, Long sceneId, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.parentSceneId = null;
                } else {
                    this.parentSceneId = parentSceneId;
                }
                if ((seen0 & 2) == 0) {
                    this.sceneId = null;
                } else {
                    this.sceneId = sceneId;
                }
            }

            public SceneInfo(Long parentSceneId, Long sceneId) {
                this.parentSceneId = parentSceneId;
                this.sceneId = sceneId;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(SceneInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.parentSceneId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.parentSceneId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.sceneId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.sceneId);
                }
            }

            public /* synthetic */ SceneInfo(Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2);
            }

            public final Long getParentSceneId() {
                return this.parentSceneId;
            }

            public final Long getSceneId() {
                return this.sceneId;
            }
        }

        public final Integer getUseStartTime() {
            return this.useStartTime;
        }
    }

    public final List<LabelObject> getTagList() {
        return this.tagList;
    }

    /* compiled from: CouponInfoFloor.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0004CDEFB\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0012\u0010\u0013B\u0095\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u009e\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\tHÖ\u0001J\t\u0010:\u001a\u00020\u0007HÖ\u0001J%\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0001¢\u0006\u0002\bBR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010 \u001a\u0004\b'\u0010\u001fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001d¨\u0006G"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo;", "", "detailCouponInfo", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo;", "detailCouponInfos", "", "detailPrice", "", "detailPriceType", "", "netPriceDescription", "netPriceExpression", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression;", "netPriceExpressions", "netPricePreDesc", "netPriceStartsDescription", "netPriceType", "netPriceUrl", "<init>", "(Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDetailCouponInfo", "()Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo;", "getDetailCouponInfos", "()Ljava/util/List;", "getDetailPrice", "()Ljava/lang/String;", "getDetailPriceType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNetPriceDescription", "getNetPriceExpression", "()Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression;", "getNetPriceExpressions", "getNetPricePreDesc", "getNetPriceStartsDescription", "getNetPriceType", "getNetPriceUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "DetailCouponInfo", "NetPriceExpression", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DetailNetPriceInfo {
        private final DetailCouponInfo detailCouponInfo;
        private final List<DetailCouponInfo> detailCouponInfos;
        private final String detailPrice;
        private final Integer detailPriceType;
        private final String netPriceDescription;
        private final NetPriceExpression netPriceExpression;
        private final List<NetPriceExpression> netPriceExpressions;
        private final String netPricePreDesc;
        private final String netPriceStartsDescription;
        private final Integer netPriceType;
        private final String netPriceUrl;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.CouponInfoFloor$DetailNetPriceInfo$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = CouponInfoFloor.DetailNetPriceInfo._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.CouponInfoFloor$DetailNetPriceInfo$$ExternalSyntheticLambda1
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$0;
                _childSerializers$_anonymous_$0 = CouponInfoFloor.DetailNetPriceInfo._childSerializers$_anonymous_$0();
                return _childSerializers$_anonymous_$0;
            }
        }), null, null, null, null};

        public DetailNetPriceInfo() {
            this((DetailCouponInfo) null, (List) null, (String) null, (Integer) null, (String) null, (NetPriceExpression) null, (List) null, (String) null, (String) null, (Integer) null, (String) null, 2047, (DefaultConstructorMarker) null);
        }

        public final DetailCouponInfo component1() {
            return this.detailCouponInfo;
        }

        public final Integer component10() {
            return this.netPriceType;
        }

        public final String component11() {
            return this.netPriceUrl;
        }

        public final List<DetailCouponInfo> component2() {
            return this.detailCouponInfos;
        }

        public final String component3() {
            return this.detailPrice;
        }

        public final Integer component4() {
            return this.detailPriceType;
        }

        public final String component5() {
            return this.netPriceDescription;
        }

        public final NetPriceExpression component6() {
            return this.netPriceExpression;
        }

        public final List<NetPriceExpression> component7() {
            return this.netPriceExpressions;
        }

        public final String component8() {
            return this.netPricePreDesc;
        }

        public final String component9() {
            return this.netPriceStartsDescription;
        }

        public final DetailNetPriceInfo copy(DetailCouponInfo detailCouponInfo, List<DetailCouponInfo> list, String str, Integer num, String str2, NetPriceExpression netPriceExpression, List<NetPriceExpression> list2, String str3, String str4, Integer num2, String str5) {
            return new DetailNetPriceInfo(detailCouponInfo, list, str, num, str2, netPriceExpression, list2, str3, str4, num2, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DetailNetPriceInfo) {
                DetailNetPriceInfo detailNetPriceInfo = (DetailNetPriceInfo) obj;
                return Intrinsics.areEqual(this.detailCouponInfo, detailNetPriceInfo.detailCouponInfo) && Intrinsics.areEqual(this.detailCouponInfos, detailNetPriceInfo.detailCouponInfos) && Intrinsics.areEqual(this.detailPrice, detailNetPriceInfo.detailPrice) && Intrinsics.areEqual(this.detailPriceType, detailNetPriceInfo.detailPriceType) && Intrinsics.areEqual(this.netPriceDescription, detailNetPriceInfo.netPriceDescription) && Intrinsics.areEqual(this.netPriceExpression, detailNetPriceInfo.netPriceExpression) && Intrinsics.areEqual(this.netPriceExpressions, detailNetPriceInfo.netPriceExpressions) && Intrinsics.areEqual(this.netPricePreDesc, detailNetPriceInfo.netPricePreDesc) && Intrinsics.areEqual(this.netPriceStartsDescription, detailNetPriceInfo.netPriceStartsDescription) && Intrinsics.areEqual(this.netPriceType, detailNetPriceInfo.netPriceType) && Intrinsics.areEqual(this.netPriceUrl, detailNetPriceInfo.netPriceUrl);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((this.detailCouponInfo == null ? 0 : this.detailCouponInfo.hashCode()) * 31) + (this.detailCouponInfos == null ? 0 : this.detailCouponInfos.hashCode())) * 31) + (this.detailPrice == null ? 0 : this.detailPrice.hashCode())) * 31) + (this.detailPriceType == null ? 0 : this.detailPriceType.hashCode())) * 31) + (this.netPriceDescription == null ? 0 : this.netPriceDescription.hashCode())) * 31) + (this.netPriceExpression == null ? 0 : this.netPriceExpression.hashCode())) * 31) + (this.netPriceExpressions == null ? 0 : this.netPriceExpressions.hashCode())) * 31) + (this.netPricePreDesc == null ? 0 : this.netPricePreDesc.hashCode())) * 31) + (this.netPriceStartsDescription == null ? 0 : this.netPriceStartsDescription.hashCode())) * 31) + (this.netPriceType == null ? 0 : this.netPriceType.hashCode())) * 31) + (this.netPriceUrl != null ? this.netPriceUrl.hashCode() : 0);
        }

        public String toString() {
            DetailCouponInfo detailCouponInfo = this.detailCouponInfo;
            List<DetailCouponInfo> list = this.detailCouponInfos;
            String str = this.detailPrice;
            Integer num = this.detailPriceType;
            String str2 = this.netPriceDescription;
            NetPriceExpression netPriceExpression = this.netPriceExpression;
            List<NetPriceExpression> list2 = this.netPriceExpressions;
            String str3 = this.netPricePreDesc;
            String str4 = this.netPriceStartsDescription;
            Integer num2 = this.netPriceType;
            return "DetailNetPriceInfo(detailCouponInfo=" + detailCouponInfo + ", detailCouponInfos=" + list + ", detailPrice=" + str + ", detailPriceType=" + num + ", netPriceDescription=" + str2 + ", netPriceExpression=" + netPriceExpression + ", netPriceExpressions=" + list2 + ", netPricePreDesc=" + str3 + ", netPriceStartsDescription=" + str4 + ", netPriceType=" + num2 + ", netPriceUrl=" + this.netPriceUrl + ")";
        }

        /* compiled from: CouponInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<DetailNetPriceInfo> serializer() {
                return CouponInfoFloor$DetailNetPriceInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ DetailNetPriceInfo(int seen0, DetailCouponInfo detailCouponInfo, List detailCouponInfos, String detailPrice, Integer detailPriceType, String netPriceDescription, NetPriceExpression netPriceExpression, List netPriceExpressions, String netPricePreDesc, String netPriceStartsDescription, Integer netPriceType, String netPriceUrl, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.detailCouponInfo = null;
            } else {
                this.detailCouponInfo = detailCouponInfo;
            }
            if ((seen0 & 2) == 0) {
                this.detailCouponInfos = null;
            } else {
                this.detailCouponInfos = detailCouponInfos;
            }
            if ((seen0 & 4) == 0) {
                this.detailPrice = null;
            } else {
                this.detailPrice = detailPrice;
            }
            if ((seen0 & 8) == 0) {
                this.detailPriceType = null;
            } else {
                this.detailPriceType = detailPriceType;
            }
            if ((seen0 & 16) == 0) {
                this.netPriceDescription = null;
            } else {
                this.netPriceDescription = netPriceDescription;
            }
            if ((seen0 & 32) == 0) {
                this.netPriceExpression = null;
            } else {
                this.netPriceExpression = netPriceExpression;
            }
            if ((seen0 & 64) == 0) {
                this.netPriceExpressions = null;
            } else {
                this.netPriceExpressions = netPriceExpressions;
            }
            if ((seen0 & 128) == 0) {
                this.netPricePreDesc = null;
            } else {
                this.netPricePreDesc = netPricePreDesc;
            }
            if ((seen0 & 256) == 0) {
                this.netPriceStartsDescription = null;
            } else {
                this.netPriceStartsDescription = netPriceStartsDescription;
            }
            if ((seen0 & 512) == 0) {
                this.netPriceType = null;
            } else {
                this.netPriceType = netPriceType;
            }
            if ((seen0 & 1024) == 0) {
                this.netPriceUrl = null;
            } else {
                this.netPriceUrl = netPriceUrl;
            }
        }

        public DetailNetPriceInfo(DetailCouponInfo detailCouponInfo, List<DetailCouponInfo> list, String detailPrice, Integer detailPriceType, String netPriceDescription, NetPriceExpression netPriceExpression, List<NetPriceExpression> list2, String netPricePreDesc, String netPriceStartsDescription, Integer netPriceType, String netPriceUrl) {
            this.detailCouponInfo = detailCouponInfo;
            this.detailCouponInfos = list;
            this.detailPrice = detailPrice;
            this.detailPriceType = detailPriceType;
            this.netPriceDescription = netPriceDescription;
            this.netPriceExpression = netPriceExpression;
            this.netPriceExpressions = list2;
            this.netPricePreDesc = netPricePreDesc;
            this.netPriceStartsDescription = netPriceStartsDescription;
            this.netPriceType = netPriceType;
            this.netPriceUrl = netPriceUrl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$$serializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(DetailNetPriceInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.detailCouponInfo != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo$$serializer.INSTANCE, self.detailCouponInfo);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.detailCouponInfos != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.detailCouponInfos);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.detailPrice != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.detailPrice);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.detailPriceType != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.detailPriceType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.netPriceDescription != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.netPriceDescription);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.netPriceExpression != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$$serializer.INSTANCE, self.netPriceExpression);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.netPriceExpressions != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, lazyArr[6].getValue(), self.netPriceExpressions);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.netPricePreDesc != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.netPricePreDesc);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.netPriceStartsDescription != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.netPriceStartsDescription);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.netPriceType != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.netPriceType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.netPriceUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.netPriceUrl);
            }
        }

        public /* synthetic */ DetailNetPriceInfo(DetailCouponInfo detailCouponInfo, List list, String str, Integer num, String str2, NetPriceExpression netPriceExpression, List list2, String str3, String str4, Integer num2, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : detailCouponInfo, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : netPriceExpression, (i & 64) != 0 ? null : list2, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : num2, (i & 1024) == 0 ? str5 : null);
        }

        public final DetailCouponInfo getDetailCouponInfo() {
            return this.detailCouponInfo;
        }

        public final List<DetailCouponInfo> getDetailCouponInfos() {
            return this.detailCouponInfos;
        }

        public final String getDetailPrice() {
            return this.detailPrice;
        }

        public final Integer getDetailPriceType() {
            return this.detailPriceType;
        }

        public final String getNetPriceDescription() {
            return this.netPriceDescription;
        }

        public final NetPriceExpression getNetPriceExpression() {
            return this.netPriceExpression;
        }

        public final List<NetPriceExpression> getNetPriceExpressions() {
            return this.netPriceExpressions;
        }

        public final String getNetPricePreDesc() {
            return this.netPricePreDesc;
        }

        public final String getNetPriceStartsDescription() {
            return this.netPriceStartsDescription;
        }

        public final Integer getNetPriceType() {
            return this.netPriceType;
        }

        /* compiled from: CouponInfoFloor.kt */
        @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 s2\u00020\u0001:\u0002rsB³\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b \u0010!B\u0095\u0002\b\u0010\u0012\u0006\u0010\"\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b \u0010%J\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010T\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010U\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010b\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010c\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00107Jº\u0002\u0010d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010eJ\u0013\u0010f\u001a\u00020\u00032\b\u0010g\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010h\u001a\u00020\u0010HÖ\u0001J\t\u0010i\u001a\u00020\u0005HÖ\u0001J%\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020\u00002\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020pH\u0001¢\u0006\u0002\bqR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010*R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010*R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00108\u001a\u0004\b9\u00107R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010*R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00105\u001a\u0004\b;\u00104R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b\u0014\u0010'R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010*R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010*R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010*R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010*R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00108\u001a\u0004\b@\u00107R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010*R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010*R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u0010*R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00108\u001a\u0004\bD\u00107R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00108\u001a\u0004\bE\u00107R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00108\u001a\u0004\bF\u00107R\u0011\u0010G\u001a\u00020H8F¢\u0006\u0006\u001a\u0004\bI\u0010J¨\u0006t"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo;", "", "addNetPrice", "", "couponName", "", "couponStatus", "couponStatusMsg", "couponTag", "couponType", "", "couponTypeDesc", "couponTypeName", "discountConditionY", "", "discountLayer", "", "discountLimit", "discountLimitDesc", "discountY", "isReceived", "landingPageUrl", "owners", "ownersName", "receiveStatus", "reductionMoney", "showName", "sourceAuthorityId", "sourceId", "useEffectDays", "useEndTime", "useStartTime", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAddNetPrice", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCouponName", "()Ljava/lang/String;", "getCouponStatus", "getCouponStatusMsg", "getCouponTag", "getCouponType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getCouponTypeDesc", "getCouponTypeName", "getDiscountConditionY", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDiscountLayer", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDiscountLimit", "getDiscountLimitDesc", "getDiscountY", "getLandingPageUrl", "getOwners", "getOwnersName", "getReceiveStatus", "getReductionMoney", "getShowName", "getSourceAuthorityId", "getSourceId", "getUseEffectDays", "getUseEndTime", "getUseStartTime", "asCouponListItem", "Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;", "getAsCouponListItem", "()Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class DetailCouponInfo {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final Boolean addNetPrice;
            private final String couponName;
            private final String couponStatus;
            private final String couponStatusMsg;
            private final String couponTag;
            private final Byte couponType;
            private final String couponTypeDesc;
            private final String couponTypeName;
            private final Double discountConditionY;
            private final Integer discountLayer;
            private final Integer discountLimit;
            private final String discountLimitDesc;
            private final Double discountY;
            private final Boolean isReceived;
            private final String landingPageUrl;
            private final String owners;
            private final String ownersName;
            private final String receiveStatus;
            private final Integer reductionMoney;
            private final String showName;
            private final String sourceAuthorityId;
            private final String sourceId;
            private final Integer useEffectDays;
            private final Integer useEndTime;
            private final Integer useStartTime;

            public DetailCouponInfo() {
                this((Boolean) null, (String) null, (String) null, (String) null, (String) null, (Byte) null, (String) null, (String) null, (Double) null, (Integer) null, (Integer) null, (String) null, (Double) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, 33554431, (DefaultConstructorMarker) null);
            }

            public final Boolean component1() {
                return this.addNetPrice;
            }

            public final Integer component10() {
                return this.discountLayer;
            }

            public final Integer component11() {
                return this.discountLimit;
            }

            public final String component12() {
                return this.discountLimitDesc;
            }

            public final Double component13() {
                return this.discountY;
            }

            public final Boolean component14() {
                return this.isReceived;
            }

            public final String component15() {
                return this.landingPageUrl;
            }

            public final String component16() {
                return this.owners;
            }

            public final String component17() {
                return this.ownersName;
            }

            public final String component18() {
                return this.receiveStatus;
            }

            public final Integer component19() {
                return this.reductionMoney;
            }

            public final String component2() {
                return this.couponName;
            }

            public final String component20() {
                return this.showName;
            }

            public final String component21() {
                return this.sourceAuthorityId;
            }

            public final String component22() {
                return this.sourceId;
            }

            public final Integer component23() {
                return this.useEffectDays;
            }

            public final Integer component24() {
                return this.useEndTime;
            }

            public final Integer component25() {
                return this.useStartTime;
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
                return this.couponTypeName;
            }

            public final Double component9() {
                return this.discountConditionY;
            }

            public final DetailCouponInfo copy(Boolean bool, String str, String str2, String str3, String str4, Byte b, String str5, String str6, Double d, Integer num, Integer num2, String str7, Double d2, Boolean bool2, String str8, String str9, String str10, String str11, Integer num3, String str12, String str13, String str14, Integer num4, Integer num5, Integer num6) {
                return new DetailCouponInfo(bool, str, str2, str3, str4, b, str5, str6, d, num, num2, str7, d2, bool2, str8, str9, str10, str11, num3, str12, str13, str14, num4, num5, num6);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof DetailCouponInfo) {
                    DetailCouponInfo detailCouponInfo = (DetailCouponInfo) obj;
                    return Intrinsics.areEqual(this.addNetPrice, detailCouponInfo.addNetPrice) && Intrinsics.areEqual(this.couponName, detailCouponInfo.couponName) && Intrinsics.areEqual(this.couponStatus, detailCouponInfo.couponStatus) && Intrinsics.areEqual(this.couponStatusMsg, detailCouponInfo.couponStatusMsg) && Intrinsics.areEqual(this.couponTag, detailCouponInfo.couponTag) && Intrinsics.areEqual(this.couponType, detailCouponInfo.couponType) && Intrinsics.areEqual(this.couponTypeDesc, detailCouponInfo.couponTypeDesc) && Intrinsics.areEqual(this.couponTypeName, detailCouponInfo.couponTypeName) && Intrinsics.areEqual(this.discountConditionY, detailCouponInfo.discountConditionY) && Intrinsics.areEqual(this.discountLayer, detailCouponInfo.discountLayer) && Intrinsics.areEqual(this.discountLimit, detailCouponInfo.discountLimit) && Intrinsics.areEqual(this.discountLimitDesc, detailCouponInfo.discountLimitDesc) && Intrinsics.areEqual(this.discountY, detailCouponInfo.discountY) && Intrinsics.areEqual(this.isReceived, detailCouponInfo.isReceived) && Intrinsics.areEqual(this.landingPageUrl, detailCouponInfo.landingPageUrl) && Intrinsics.areEqual(this.owners, detailCouponInfo.owners) && Intrinsics.areEqual(this.ownersName, detailCouponInfo.ownersName) && Intrinsics.areEqual(this.receiveStatus, detailCouponInfo.receiveStatus) && Intrinsics.areEqual(this.reductionMoney, detailCouponInfo.reductionMoney) && Intrinsics.areEqual(this.showName, detailCouponInfo.showName) && Intrinsics.areEqual(this.sourceAuthorityId, detailCouponInfo.sourceAuthorityId) && Intrinsics.areEqual(this.sourceId, detailCouponInfo.sourceId) && Intrinsics.areEqual(this.useEffectDays, detailCouponInfo.useEffectDays) && Intrinsics.areEqual(this.useEndTime, detailCouponInfo.useEndTime) && Intrinsics.areEqual(this.useStartTime, detailCouponInfo.useStartTime);
                }
                return false;
            }

            public int hashCode() {
                return ((((((((((((((((((((((((((((((((((((((((((((((((this.addNetPrice == null ? 0 : this.addNetPrice.hashCode()) * 31) + (this.couponName == null ? 0 : this.couponName.hashCode())) * 31) + (this.couponStatus == null ? 0 : this.couponStatus.hashCode())) * 31) + (this.couponStatusMsg == null ? 0 : this.couponStatusMsg.hashCode())) * 31) + (this.couponTag == null ? 0 : this.couponTag.hashCode())) * 31) + (this.couponType == null ? 0 : this.couponType.hashCode())) * 31) + (this.couponTypeDesc == null ? 0 : this.couponTypeDesc.hashCode())) * 31) + (this.couponTypeName == null ? 0 : this.couponTypeName.hashCode())) * 31) + (this.discountConditionY == null ? 0 : this.discountConditionY.hashCode())) * 31) + (this.discountLayer == null ? 0 : this.discountLayer.hashCode())) * 31) + (this.discountLimit == null ? 0 : this.discountLimit.hashCode())) * 31) + (this.discountLimitDesc == null ? 0 : this.discountLimitDesc.hashCode())) * 31) + (this.discountY == null ? 0 : this.discountY.hashCode())) * 31) + (this.isReceived == null ? 0 : this.isReceived.hashCode())) * 31) + (this.landingPageUrl == null ? 0 : this.landingPageUrl.hashCode())) * 31) + (this.owners == null ? 0 : this.owners.hashCode())) * 31) + (this.ownersName == null ? 0 : this.ownersName.hashCode())) * 31) + (this.receiveStatus == null ? 0 : this.receiveStatus.hashCode())) * 31) + (this.reductionMoney == null ? 0 : this.reductionMoney.hashCode())) * 31) + (this.showName == null ? 0 : this.showName.hashCode())) * 31) + (this.sourceAuthorityId == null ? 0 : this.sourceAuthorityId.hashCode())) * 31) + (this.sourceId == null ? 0 : this.sourceId.hashCode())) * 31) + (this.useEffectDays == null ? 0 : this.useEffectDays.hashCode())) * 31) + (this.useEndTime == null ? 0 : this.useEndTime.hashCode())) * 31) + (this.useStartTime != null ? this.useStartTime.hashCode() : 0);
            }

            public String toString() {
                Boolean bool = this.addNetPrice;
                String str = this.couponName;
                String str2 = this.couponStatus;
                String str3 = this.couponStatusMsg;
                String str4 = this.couponTag;
                Byte b = this.couponType;
                String str5 = this.couponTypeDesc;
                String str6 = this.couponTypeName;
                Double d = this.discountConditionY;
                Integer num = this.discountLayer;
                Integer num2 = this.discountLimit;
                String str7 = this.discountLimitDesc;
                Double d2 = this.discountY;
                Boolean bool2 = this.isReceived;
                String str8 = this.landingPageUrl;
                String str9 = this.owners;
                String str10 = this.ownersName;
                String str11 = this.receiveStatus;
                Integer num3 = this.reductionMoney;
                String str12 = this.showName;
                String str13 = this.sourceAuthorityId;
                String str14 = this.sourceId;
                Integer num4 = this.useEffectDays;
                Integer num5 = this.useEndTime;
                return "DetailCouponInfo(addNetPrice=" + bool + ", couponName=" + str + ", couponStatus=" + str2 + ", couponStatusMsg=" + str3 + ", couponTag=" + str4 + ", couponType=" + b + ", couponTypeDesc=" + str5 + ", couponTypeName=" + str6 + ", discountConditionY=" + d + ", discountLayer=" + num + ", discountLimit=" + num2 + ", discountLimitDesc=" + str7 + ", discountY=" + d2 + ", isReceived=" + bool2 + ", landingPageUrl=" + str8 + ", owners=" + str9 + ", ownersName=" + str10 + ", receiveStatus=" + str11 + ", reductionMoney=" + num3 + ", showName=" + str12 + ", sourceAuthorityId=" + str13 + ", sourceId=" + str14 + ", useEffectDays=" + num4 + ", useEndTime=" + num5 + ", useStartTime=" + this.useStartTime + ")";
            }

            /* compiled from: CouponInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<DetailCouponInfo> serializer() {
                    return CouponInfoFloor$DetailNetPriceInfo$DetailCouponInfo$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ DetailCouponInfo(int seen0, Boolean addNetPrice, String couponName, String couponStatus, String couponStatusMsg, String couponTag, Byte couponType, String couponTypeDesc, String couponTypeName, Double discountConditionY, Integer discountLayer, Integer discountLimit, String discountLimitDesc, Double discountY, Boolean isReceived, String landingPageUrl, String owners, String ownersName, String receiveStatus, Integer reductionMoney, String showName, String sourceAuthorityId, String sourceId, Integer useEffectDays, Integer useEndTime, Integer useStartTime, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.addNetPrice = null;
                } else {
                    this.addNetPrice = addNetPrice;
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
                    this.couponTypeName = null;
                } else {
                    this.couponTypeName = couponTypeName;
                }
                if ((seen0 & 256) == 0) {
                    this.discountConditionY = null;
                } else {
                    this.discountConditionY = discountConditionY;
                }
                if ((seen0 & 512) == 0) {
                    this.discountLayer = null;
                } else {
                    this.discountLayer = discountLayer;
                }
                if ((seen0 & 1024) == 0) {
                    this.discountLimit = null;
                } else {
                    this.discountLimit = discountLimit;
                }
                if ((seen0 & 2048) == 0) {
                    this.discountLimitDesc = null;
                } else {
                    this.discountLimitDesc = discountLimitDesc;
                }
                if ((seen0 & 4096) == 0) {
                    this.discountY = null;
                } else {
                    this.discountY = discountY;
                }
                if ((seen0 & 8192) == 0) {
                    this.isReceived = null;
                } else {
                    this.isReceived = isReceived;
                }
                if ((seen0 & 16384) == 0) {
                    this.landingPageUrl = null;
                } else {
                    this.landingPageUrl = landingPageUrl;
                }
                if ((seen0 & 32768) == 0) {
                    this.owners = null;
                } else {
                    this.owners = owners;
                }
                if ((seen0 & 65536) == 0) {
                    this.ownersName = null;
                } else {
                    this.ownersName = ownersName;
                }
                if ((seen0 & 131072) == 0) {
                    this.receiveStatus = null;
                } else {
                    this.receiveStatus = receiveStatus;
                }
                if ((seen0 & 262144) == 0) {
                    this.reductionMoney = null;
                } else {
                    this.reductionMoney = reductionMoney;
                }
                if ((seen0 & 524288) == 0) {
                    this.showName = null;
                } else {
                    this.showName = showName;
                }
                if ((seen0 & 1048576) == 0) {
                    this.sourceAuthorityId = null;
                } else {
                    this.sourceAuthorityId = sourceAuthorityId;
                }
                if ((seen0 & 2097152) == 0) {
                    this.sourceId = null;
                } else {
                    this.sourceId = sourceId;
                }
                if ((seen0 & 4194304) == 0) {
                    this.useEffectDays = null;
                } else {
                    this.useEffectDays = useEffectDays;
                }
                if ((seen0 & 8388608) == 0) {
                    this.useEndTime = null;
                } else {
                    this.useEndTime = useEndTime;
                }
                if ((seen0 & 16777216) == 0) {
                    this.useStartTime = null;
                } else {
                    this.useStartTime = useStartTime;
                }
            }

            public DetailCouponInfo(Boolean addNetPrice, String couponName, String couponStatus, String couponStatusMsg, String couponTag, Byte couponType, String couponTypeDesc, String couponTypeName, Double discountConditionY, Integer discountLayer, Integer discountLimit, String discountLimitDesc, Double discountY, Boolean isReceived, String landingPageUrl, String owners, String ownersName, String receiveStatus, Integer reductionMoney, String showName, String sourceAuthorityId, String sourceId, Integer useEffectDays, Integer useEndTime, Integer useStartTime) {
                this.addNetPrice = addNetPrice;
                this.couponName = couponName;
                this.couponStatus = couponStatus;
                this.couponStatusMsg = couponStatusMsg;
                this.couponTag = couponTag;
                this.couponType = couponType;
                this.couponTypeDesc = couponTypeDesc;
                this.couponTypeName = couponTypeName;
                this.discountConditionY = discountConditionY;
                this.discountLayer = discountLayer;
                this.discountLimit = discountLimit;
                this.discountLimitDesc = discountLimitDesc;
                this.discountY = discountY;
                this.isReceived = isReceived;
                this.landingPageUrl = landingPageUrl;
                this.owners = owners;
                this.ownersName = ownersName;
                this.receiveStatus = receiveStatus;
                this.reductionMoney = reductionMoney;
                this.showName = showName;
                this.sourceAuthorityId = sourceAuthorityId;
                this.sourceId = sourceId;
                this.useEffectDays = useEffectDays;
                this.useEndTime = useEndTime;
                this.useStartTime = useStartTime;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(DetailCouponInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.addNetPrice != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.addNetPrice);
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
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.couponTypeName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.couponTypeName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.discountConditionY != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, DoubleSerializer.INSTANCE, self.discountConditionY);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.discountLayer != null) {
                    output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.discountLayer);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 10) || self.discountLimit != null) {
                    output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.discountLimit);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 11) || self.discountLimitDesc != null) {
                    output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.discountLimitDesc);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 12) || self.discountY != null) {
                    output.encodeNullableSerializableElement(serialDesc, 12, DoubleSerializer.INSTANCE, self.discountY);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 13) || self.isReceived != null) {
                    output.encodeNullableSerializableElement(serialDesc, 13, BooleanSerializer.INSTANCE, self.isReceived);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 14) || self.landingPageUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.landingPageUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 15) || self.owners != null) {
                    output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.owners);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 16) || self.ownersName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.ownersName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 17) || self.receiveStatus != null) {
                    output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.receiveStatus);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 18) || self.reductionMoney != null) {
                    output.encodeNullableSerializableElement(serialDesc, 18, IntSerializer.INSTANCE, self.reductionMoney);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 19) || self.showName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.showName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 20) || self.sourceAuthorityId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.sourceAuthorityId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 21) || self.sourceId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 21, StringSerializer.INSTANCE, self.sourceId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 22) || self.useEffectDays != null) {
                    output.encodeNullableSerializableElement(serialDesc, 22, IntSerializer.INSTANCE, self.useEffectDays);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 23) || self.useEndTime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 23, IntSerializer.INSTANCE, self.useEndTime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 24) || self.useStartTime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 24, IntSerializer.INSTANCE, self.useStartTime);
                }
            }

            public /* synthetic */ DetailCouponInfo(Boolean bool, String str, String str2, String str3, String str4, Byte b, String str5, String str6, Double d, Integer num, Integer num2, String str7, Double d2, Boolean bool2, String str8, String str9, String str10, String str11, Integer num3, String str12, String str13, String str14, Integer num4, Integer num5, Integer num6, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : b, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : d, (i & 512) != 0 ? null : num, (i & 1024) != 0 ? null : num2, (i & 2048) != 0 ? null : str7, (i & 4096) != 0 ? null : d2, (i & 8192) != 0 ? null : bool2, (i & 16384) != 0 ? null : str8, (i & 32768) != 0 ? null : str9, (i & 65536) != 0 ? null : str10, (i & 131072) != 0 ? null : str11, (i & 262144) != 0 ? null : num3, (i & 524288) != 0 ? null : str12, (i & 1048576) != 0 ? null : str13, (i & 2097152) != 0 ? null : str14, (i & 4194304) != 0 ? null : num4, (i & 8388608) != 0 ? null : num5, (i & 16777216) != 0 ? null : num6);
            }

            public final Boolean getAddNetPrice() {
                return this.addNetPrice;
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

            public final String getCouponTypeName() {
                return this.couponTypeName;
            }

            public final Double getDiscountConditionY() {
                return this.discountConditionY;
            }

            public final Integer getDiscountLayer() {
                return this.discountLayer;
            }

            public final Integer getDiscountLimit() {
                return this.discountLimit;
            }

            public final String getDiscountLimitDesc() {
                return this.discountLimitDesc;
            }

            public final Double getDiscountY() {
                return this.discountY;
            }

            public final Boolean isReceived() {
                return this.isReceived;
            }

            public final String getLandingPageUrl() {
                return this.landingPageUrl;
            }

            public final String getOwners() {
                return this.owners;
            }

            public final String getOwnersName() {
                return this.ownersName;
            }

            public final String getReceiveStatus() {
                return this.receiveStatus;
            }

            public final Integer getReductionMoney() {
                return this.reductionMoney;
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

            public final Integer getUseEndTime() {
                return this.useEndTime;
            }

            public final Integer getUseStartTime() {
                return this.useStartTime;
            }

            public final CouponListResponse.CouponListItem getAsCouponListItem() {
                String str = this.couponName;
                String str2 = this.showName;
                String str3 = this.couponStatus;
                String str4 = this.couponStatusMsg;
                String str5 = this.couponTag;
                Byte b = this.couponType;
                Integer valueOf = b != null ? Integer.valueOf(b.byteValue()) : null;
                String str6 = this.couponTypeDesc;
                String str7 = this.couponTypeName;
                Double d = this.discountY;
                return new CouponListResponse.CouponListItem((Byte) null, (Byte) null, (Integer) null, (List) null, (String) null, (Byte) null, (String) null, (String) null, (CouponListResponse.CouponListItem.CouponExtModel) null, (String) null, str, str3, str4, str5, valueOf, str6, str7, (Integer) null, (Integer) null, (Double) null, (String) null, (Integer) null, this.discountLimitDesc, d, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Boolean) null, this.isReceived, (List) null, (String) null, (Integer) null, (Boolean) null, (Byte) null, this.owners, this.ownersName, (String) null, (Integer) null, (Integer) null, (Byte) null, (Long) null, (Integer) null, (String) null, str2, (String) null, this.sourceAuthorityId, this.sourceId, (Byte) null, (String) null, this.useEffectDays, (Integer) null, this.useEndTime, this.useStartTime, (Integer) null, -1086454785, 9854927, (DefaultConstructorMarker) null);
            }
        }

        public final String getNetPriceUrl() {
            return this.netPriceUrl;
        }

        /* compiled from: CouponInfoFloor.kt */
        @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 42\u00020\u0001:\u0003234BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rB]\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\\\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u000bHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J%\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b¨\u00065"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression;", "", "discount", "", "discountPrice", "expressionInfo", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$ExpressionInfo;", "expressionInfoList", "", "originalPrice", "threshold", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$ExpressionInfo;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$ExpressionInfo;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDiscount", "()Ljava/lang/String;", "getDiscountPrice", "getExpressionInfo", "()Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$ExpressionInfo;", "getExpressionInfoList", "()Ljava/util/List;", "getOriginalPrice", "getThreshold", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$ExpressionInfo;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ExpressionInfo", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class NetPriceExpression {
            private final String discount;
            private final String discountPrice;
            private final ExpressionInfo expressionInfo;
            private final List<ExpressionInfo> expressionInfoList;
            private final String originalPrice;
            private final Integer threshold;
            public static final Companion Companion = new Companion(null);
            public static final int $stable = 8;
            private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$$ExternalSyntheticLambda0
                public final Object invoke() {
                    KSerializer _childSerializers$_anonymous_;
                    _childSerializers$_anonymous_ = CouponInfoFloor.DetailNetPriceInfo.NetPriceExpression._childSerializers$_anonymous_();
                    return _childSerializers$_anonymous_;
                }
            }), null, null};

            public NetPriceExpression() {
                this((String) null, (String) null, (ExpressionInfo) null, (List) null, (String) null, (Integer) null, 63, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ NetPriceExpression copy$default(NetPriceExpression netPriceExpression, String str, String str2, ExpressionInfo expressionInfo, List list, String str3, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = netPriceExpression.discount;
                }
                if ((i & 2) != 0) {
                    str2 = netPriceExpression.discountPrice;
                }
                String str4 = str2;
                if ((i & 4) != 0) {
                    expressionInfo = netPriceExpression.expressionInfo;
                }
                ExpressionInfo expressionInfo2 = expressionInfo;
                List<ExpressionInfo> list2 = list;
                if ((i & 8) != 0) {
                    list2 = netPriceExpression.expressionInfoList;
                }
                List list3 = list2;
                if ((i & 16) != 0) {
                    str3 = netPriceExpression.originalPrice;
                }
                String str5 = str3;
                if ((i & 32) != 0) {
                    num = netPriceExpression.threshold;
                }
                return netPriceExpression.copy(str, str4, expressionInfo2, list3, str5, num);
            }

            public final String component1() {
                return this.discount;
            }

            public final String component2() {
                return this.discountPrice;
            }

            public final ExpressionInfo component3() {
                return this.expressionInfo;
            }

            public final List<ExpressionInfo> component4() {
                return this.expressionInfoList;
            }

            public final String component5() {
                return this.originalPrice;
            }

            public final Integer component6() {
                return this.threshold;
            }

            public final NetPriceExpression copy(String str, String str2, ExpressionInfo expressionInfo, List<ExpressionInfo> list, String str3, Integer num) {
                return new NetPriceExpression(str, str2, expressionInfo, list, str3, num);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof NetPriceExpression) {
                    NetPriceExpression netPriceExpression = (NetPriceExpression) obj;
                    return Intrinsics.areEqual(this.discount, netPriceExpression.discount) && Intrinsics.areEqual(this.discountPrice, netPriceExpression.discountPrice) && Intrinsics.areEqual(this.expressionInfo, netPriceExpression.expressionInfo) && Intrinsics.areEqual(this.expressionInfoList, netPriceExpression.expressionInfoList) && Intrinsics.areEqual(this.originalPrice, netPriceExpression.originalPrice) && Intrinsics.areEqual(this.threshold, netPriceExpression.threshold);
                }
                return false;
            }

            public int hashCode() {
                return ((((((((((this.discount == null ? 0 : this.discount.hashCode()) * 31) + (this.discountPrice == null ? 0 : this.discountPrice.hashCode())) * 31) + (this.expressionInfo == null ? 0 : this.expressionInfo.hashCode())) * 31) + (this.expressionInfoList == null ? 0 : this.expressionInfoList.hashCode())) * 31) + (this.originalPrice == null ? 0 : this.originalPrice.hashCode())) * 31) + (this.threshold != null ? this.threshold.hashCode() : 0);
            }

            public String toString() {
                String str = this.discount;
                String str2 = this.discountPrice;
                ExpressionInfo expressionInfo = this.expressionInfo;
                List<ExpressionInfo> list = this.expressionInfoList;
                String str3 = this.originalPrice;
                return "NetPriceExpression(discount=" + str + ", discountPrice=" + str2 + ", expressionInfo=" + expressionInfo + ", expressionInfoList=" + list + ", originalPrice=" + str3 + ", threshold=" + this.threshold + ")";
            }

            /* compiled from: CouponInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<NetPriceExpression> serializer() {
                    return CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ NetPriceExpression(int seen0, String discount, String discountPrice, ExpressionInfo expressionInfo, List expressionInfoList, String originalPrice, Integer threshold, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.discount = null;
                } else {
                    this.discount = discount;
                }
                if ((seen0 & 2) == 0) {
                    this.discountPrice = null;
                } else {
                    this.discountPrice = discountPrice;
                }
                if ((seen0 & 4) == 0) {
                    this.expressionInfo = null;
                } else {
                    this.expressionInfo = expressionInfo;
                }
                if ((seen0 & 8) == 0) {
                    this.expressionInfoList = null;
                } else {
                    this.expressionInfoList = expressionInfoList;
                }
                if ((seen0 & 16) == 0) {
                    this.originalPrice = null;
                } else {
                    this.originalPrice = originalPrice;
                }
                if ((seen0 & 32) == 0) {
                    this.threshold = null;
                } else {
                    this.threshold = threshold;
                }
            }

            public NetPriceExpression(String discount, String discountPrice, ExpressionInfo expressionInfo, List<ExpressionInfo> list, String originalPrice, Integer threshold) {
                this.discount = discount;
                this.discountPrice = discountPrice;
                this.expressionInfo = expressionInfo;
                this.expressionInfoList = list;
                this.originalPrice = originalPrice;
                this.threshold = threshold;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$ExpressionInfo$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(NetPriceExpression self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.discount != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.discount);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.discountPrice != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.discountPrice);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.expressionInfo != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$ExpressionInfo$$serializer.INSTANCE, self.expressionInfo);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.expressionInfoList != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.expressionInfoList);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.originalPrice != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.originalPrice);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.threshold != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.threshold);
                }
            }

            public /* synthetic */ NetPriceExpression(String str, String str2, ExpressionInfo expressionInfo, List list, String str3, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : expressionInfo, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : num);
            }

            public final String getDiscount() {
                return this.discount;
            }

            public final String getDiscountPrice() {
                return this.discountPrice;
            }

            public final ExpressionInfo getExpressionInfo() {
                return this.expressionInfo;
            }

            public final List<ExpressionInfo> getExpressionInfoList() {
                return this.expressionInfoList;
            }

            public final String getOriginalPrice() {
                return this.originalPrice;
            }

            /* compiled from: CouponInfoFloor.kt */
            @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eBk\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001eJn\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001e¨\u00069"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$ExpressionInfo;", "", "discount", "", "discountLayer", "", "discountPrice", "originalPrice", "reductionMoney", "threshold", "useDiscountName", "useDiscountType", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Byte;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Byte;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDiscount", "()Ljava/lang/String;", "getDiscountLayer", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDiscountPrice", "getOriginalPrice", "getReductionMoney", "getThreshold", "getUseDiscountName", "getUseDiscountType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Byte;)Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$ExpressionInfo;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class ExpressionInfo {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final String discount;
                private final Integer discountLayer;
                private final String discountPrice;
                private final String originalPrice;
                private final String reductionMoney;
                private final Integer threshold;
                private final String useDiscountName;
                private final Byte useDiscountType;

                public ExpressionInfo() {
                    this((String) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Byte) null, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
                }

                public final String component1() {
                    return this.discount;
                }

                public final Integer component2() {
                    return this.discountLayer;
                }

                public final String component3() {
                    return this.discountPrice;
                }

                public final String component4() {
                    return this.originalPrice;
                }

                public final String component5() {
                    return this.reductionMoney;
                }

                public final Integer component6() {
                    return this.threshold;
                }

                public final String component7() {
                    return this.useDiscountName;
                }

                public final Byte component8() {
                    return this.useDiscountType;
                }

                public final ExpressionInfo copy(String str, Integer num, String str2, String str3, String str4, Integer num2, String str5, Byte b) {
                    return new ExpressionInfo(str, num, str2, str3, str4, num2, str5, b);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof ExpressionInfo) {
                        ExpressionInfo expressionInfo = (ExpressionInfo) obj;
                        return Intrinsics.areEqual(this.discount, expressionInfo.discount) && Intrinsics.areEqual(this.discountLayer, expressionInfo.discountLayer) && Intrinsics.areEqual(this.discountPrice, expressionInfo.discountPrice) && Intrinsics.areEqual(this.originalPrice, expressionInfo.originalPrice) && Intrinsics.areEqual(this.reductionMoney, expressionInfo.reductionMoney) && Intrinsics.areEqual(this.threshold, expressionInfo.threshold) && Intrinsics.areEqual(this.useDiscountName, expressionInfo.useDiscountName) && Intrinsics.areEqual(this.useDiscountType, expressionInfo.useDiscountType);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((((((((((((((this.discount == null ? 0 : this.discount.hashCode()) * 31) + (this.discountLayer == null ? 0 : this.discountLayer.hashCode())) * 31) + (this.discountPrice == null ? 0 : this.discountPrice.hashCode())) * 31) + (this.originalPrice == null ? 0 : this.originalPrice.hashCode())) * 31) + (this.reductionMoney == null ? 0 : this.reductionMoney.hashCode())) * 31) + (this.threshold == null ? 0 : this.threshold.hashCode())) * 31) + (this.useDiscountName == null ? 0 : this.useDiscountName.hashCode())) * 31) + (this.useDiscountType != null ? this.useDiscountType.hashCode() : 0);
                }

                public String toString() {
                    String str = this.discount;
                    Integer num = this.discountLayer;
                    String str2 = this.discountPrice;
                    String str3 = this.originalPrice;
                    String str4 = this.reductionMoney;
                    Integer num2 = this.threshold;
                    String str5 = this.useDiscountName;
                    return "ExpressionInfo(discount=" + str + ", discountLayer=" + num + ", discountPrice=" + str2 + ", originalPrice=" + str3 + ", reductionMoney=" + str4 + ", threshold=" + num2 + ", useDiscountName=" + str5 + ", useDiscountType=" + this.useDiscountType + ")";
                }

                /* compiled from: CouponInfoFloor.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$ExpressionInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$ExpressionInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<ExpressionInfo> serializer() {
                        return CouponInfoFloor$DetailNetPriceInfo$NetPriceExpression$ExpressionInfo$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ ExpressionInfo(int seen0, String discount, Integer discountLayer, String discountPrice, String originalPrice, String reductionMoney, Integer threshold, String useDiscountName, Byte useDiscountType, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.discount = null;
                    } else {
                        this.discount = discount;
                    }
                    if ((seen0 & 2) == 0) {
                        this.discountLayer = null;
                    } else {
                        this.discountLayer = discountLayer;
                    }
                    if ((seen0 & 4) == 0) {
                        this.discountPrice = null;
                    } else {
                        this.discountPrice = discountPrice;
                    }
                    if ((seen0 & 8) == 0) {
                        this.originalPrice = null;
                    } else {
                        this.originalPrice = originalPrice;
                    }
                    if ((seen0 & 16) == 0) {
                        this.reductionMoney = null;
                    } else {
                        this.reductionMoney = reductionMoney;
                    }
                    if ((seen0 & 32) == 0) {
                        this.threshold = null;
                    } else {
                        this.threshold = threshold;
                    }
                    if ((seen0 & 64) == 0) {
                        this.useDiscountName = null;
                    } else {
                        this.useDiscountName = useDiscountName;
                    }
                    if ((seen0 & 128) == 0) {
                        this.useDiscountType = null;
                    } else {
                        this.useDiscountType = useDiscountType;
                    }
                }

                public ExpressionInfo(String discount, Integer discountLayer, String discountPrice, String originalPrice, String reductionMoney, Integer threshold, String useDiscountName, Byte useDiscountType) {
                    this.discount = discount;
                    this.discountLayer = discountLayer;
                    this.discountPrice = discountPrice;
                    this.originalPrice = originalPrice;
                    this.reductionMoney = reductionMoney;
                    this.threshold = threshold;
                    this.useDiscountName = useDiscountName;
                    this.useDiscountType = useDiscountType;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(ExpressionInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.discount != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.discount);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.discountLayer != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.discountLayer);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.discountPrice != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.discountPrice);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.originalPrice != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.originalPrice);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.reductionMoney != null) {
                        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.reductionMoney);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.threshold != null) {
                        output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.threshold);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.useDiscountName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.useDiscountName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 7) || self.useDiscountType != null) {
                        output.encodeNullableSerializableElement(serialDesc, 7, ByteSerializer.INSTANCE, self.useDiscountType);
                    }
                }

                public /* synthetic */ ExpressionInfo(String str, Integer num, String str2, String str3, String str4, Integer num2, String str5, Byte b, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : str5, (i & 128) == 0 ? b : null);
                }

                public final String getDiscount() {
                    return this.discount;
                }

                public final Integer getDiscountLayer() {
                    return this.discountLayer;
                }

                public final String getDiscountPrice() {
                    return this.discountPrice;
                }

                public final String getOriginalPrice() {
                    return this.originalPrice;
                }

                public final String getReductionMoney() {
                    return this.reductionMoney;
                }

                public final Integer getThreshold() {
                    return this.threshold;
                }

                public final String getUseDiscountName() {
                    return this.useDiscountName;
                }

                public final Byte getUseDiscountType() {
                    return this.useDiscountType;
                }
            }

            public final Integer getThreshold() {
                return this.threshold;
            }
        }
    }
}