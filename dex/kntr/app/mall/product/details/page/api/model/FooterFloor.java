package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import java.util.Map;
import kntr.app.mall.product.details.page.api.model.FooterFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: FooterFloor.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u0000 E2\u00020\u0001:\u0006@ABCDEB\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013B\u0081\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0012\u0010\u0018J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tHÆ\u0003J\u0081\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tHÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0015HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001J%\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0001¢\u0006\u0002\b?R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 ¨\u0006F"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/FooterFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "purchaseButton", "Lkntr/app/mall/product/details/page/api/model/FooterFloor$PurchaseButton;", "footer", "", "Lkntr/app/mall/product/details/page/api/model/ActionIconModel;", "actionInfoVO", "Lkntr/app/mall/product/details/page/api/model/FooterFloor$ActionInfoVO;", "addCartButton", "Lkntr/app/mall/product/details/page/api/model/FooterFloor$AddCartButton;", "couponPackageInfoVO", "Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel;", "couponPackageInfos", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/FooterFloor$PurchaseButton;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/FooterFloor$ActionInfoVO;Lkntr/app/mall/product/details/page/api/model/FooterFloor$AddCartButton;Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/FooterFloor$PurchaseButton;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/FooterFloor$ActionInfoVO;Lkntr/app/mall/product/details/page/api/model/FooterFloor$AddCartButton;Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getPurchaseButton", "()Lkntr/app/mall/product/details/page/api/model/FooterFloor$PurchaseButton;", "getFooter", "()Ljava/util/List;", "getActionInfoVO", "()Lkntr/app/mall/product/details/page/api/model/FooterFloor$ActionInfoVO;", "getAddCartButton", "()Lkntr/app/mall/product/details/page/api/model/FooterFloor$AddCartButton;", "getCouponPackageInfoVO", "()Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel;", "getCouponPackageInfos", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ActionInfoVO", "ReserveCouponInfo", "PurchaseButton", "AddCartButton", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class FooterFloor implements FloorModel {
    private final ActionInfoVO actionInfoVO;
    private final AddCartButton addCartButton;
    private final String bgImgUrl;
    private final CouponPackageInfoModel couponPackageInfoVO;
    private final List<CouponPackageInfoModel> couponPackageInfos;
    private final String floorIcon;
    private final String floorKey;
    private final List<ActionIconModel> footer;
    private final PurchaseButton purchaseButton;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.FooterFloor$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = FooterFloor._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.FooterFloor$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = FooterFloor._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    })};

    public FooterFloor() {
        this((String) null, (String) null, (String) null, (PurchaseButton) null, (List) null, (ActionInfoVO) null, (AddCartButton) null, (CouponPackageInfoModel) null, (List) null, 511, (DefaultConstructorMarker) null);
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

    public final PurchaseButton component4() {
        return this.purchaseButton;
    }

    public final List<ActionIconModel> component5() {
        return this.footer;
    }

    public final ActionInfoVO component6() {
        return this.actionInfoVO;
    }

    public final AddCartButton component7() {
        return this.addCartButton;
    }

    public final CouponPackageInfoModel component8() {
        return this.couponPackageInfoVO;
    }

    public final List<CouponPackageInfoModel> component9() {
        return this.couponPackageInfos;
    }

    public final FooterFloor copy(String str, String str2, String str3, PurchaseButton purchaseButton, List<ActionIconModel> list, ActionInfoVO actionInfoVO, AddCartButton addCartButton, CouponPackageInfoModel couponPackageInfoModel, List<CouponPackageInfoModel> list2) {
        return new FooterFloor(str, str2, str3, purchaseButton, list, actionInfoVO, addCartButton, couponPackageInfoModel, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FooterFloor) {
            FooterFloor footerFloor = (FooterFloor) obj;
            return Intrinsics.areEqual(this.floorKey, footerFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, footerFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, footerFloor.bgImgUrl) && Intrinsics.areEqual(this.purchaseButton, footerFloor.purchaseButton) && Intrinsics.areEqual(this.footer, footerFloor.footer) && Intrinsics.areEqual(this.actionInfoVO, footerFloor.actionInfoVO) && Intrinsics.areEqual(this.addCartButton, footerFloor.addCartButton) && Intrinsics.areEqual(this.couponPackageInfoVO, footerFloor.couponPackageInfoVO) && Intrinsics.areEqual(this.couponPackageInfos, footerFloor.couponPackageInfos);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.purchaseButton == null ? 0 : this.purchaseButton.hashCode())) * 31) + (this.footer == null ? 0 : this.footer.hashCode())) * 31) + (this.actionInfoVO == null ? 0 : this.actionInfoVO.hashCode())) * 31) + (this.addCartButton == null ? 0 : this.addCartButton.hashCode())) * 31) + (this.couponPackageInfoVO == null ? 0 : this.couponPackageInfoVO.hashCode())) * 31) + (this.couponPackageInfos != null ? this.couponPackageInfos.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        PurchaseButton purchaseButton = this.purchaseButton;
        List<ActionIconModel> list = this.footer;
        ActionInfoVO actionInfoVO = this.actionInfoVO;
        AddCartButton addCartButton = this.addCartButton;
        CouponPackageInfoModel couponPackageInfoModel = this.couponPackageInfoVO;
        return "FooterFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", purchaseButton=" + purchaseButton + ", footer=" + list + ", actionInfoVO=" + actionInfoVO + ", addCartButton=" + addCartButton + ", couponPackageInfoVO=" + couponPackageInfoModel + ", couponPackageInfos=" + this.couponPackageInfos + ")";
    }

    /* compiled from: FooterFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/FooterFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/FooterFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<FooterFloor> serializer() {
            return FooterFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ FooterFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, PurchaseButton purchaseButton, List footer, ActionInfoVO actionInfoVO, AddCartButton addCartButton, CouponPackageInfoModel couponPackageInfoVO, List couponPackageInfos, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.purchaseButton = null;
        } else {
            this.purchaseButton = purchaseButton;
        }
        if ((seen0 & 16) == 0) {
            this.footer = null;
        } else {
            this.footer = footer;
        }
        if ((seen0 & 32) == 0) {
            this.actionInfoVO = null;
        } else {
            this.actionInfoVO = actionInfoVO;
        }
        if ((seen0 & 64) == 0) {
            this.addCartButton = null;
        } else {
            this.addCartButton = addCartButton;
        }
        if ((seen0 & 128) == 0) {
            this.couponPackageInfoVO = null;
        } else {
            this.couponPackageInfoVO = couponPackageInfoVO;
        }
        if ((seen0 & 256) == 0) {
            this.couponPackageInfos = null;
        } else {
            this.couponPackageInfos = couponPackageInfos;
        }
    }

    public FooterFloor(String floorKey, String floorIcon, String bgImgUrl, PurchaseButton purchaseButton, List<ActionIconModel> list, ActionInfoVO actionInfoVO, AddCartButton addCartButton, CouponPackageInfoModel couponPackageInfoVO, List<CouponPackageInfoModel> list2) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.purchaseButton = purchaseButton;
        this.footer = list;
        this.actionInfoVO = actionInfoVO;
        this.addCartButton = addCartButton;
        this.couponPackageInfoVO = couponPackageInfoVO;
        this.couponPackageInfos = list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(ActionIconModel$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(CouponPackageInfoModel$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(FooterFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.purchaseButton != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, FooterFloor$PurchaseButton$$serializer.INSTANCE, self.purchaseButton);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.footer != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.footer);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.actionInfoVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, FooterFloor$ActionInfoVO$$serializer.INSTANCE, self.actionInfoVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.addCartButton != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, FooterFloor$AddCartButton$$serializer.INSTANCE, self.addCartButton);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.couponPackageInfoVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, CouponPackageInfoModel$$serializer.INSTANCE, self.couponPackageInfoVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.couponPackageInfos != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, lazyArr[8].getValue(), self.couponPackageInfos);
        }
    }

    public /* synthetic */ FooterFloor(String str, String str2, String str3, PurchaseButton purchaseButton, List list, ActionInfoVO actionInfoVO, AddCartButton addCartButton, CouponPackageInfoModel couponPackageInfoModel, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : purchaseButton, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : actionInfoVO, (i & 64) != 0 ? null : addCartButton, (i & 128) != 0 ? null : couponPackageInfoModel, (i & 256) == 0 ? list2 : null);
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

    public final PurchaseButton getPurchaseButton() {
        return this.purchaseButton;
    }

    public final List<ActionIconModel> getFooter() {
        return this.footer;
    }

    public final ActionInfoVO getActionInfoVO() {
        return this.actionInfoVO;
    }

    public final AddCartButton getAddCartButton() {
        return this.addCartButton;
    }

    public final CouponPackageInfoModel getCouponPackageInfoVO() {
        return this.couponPackageInfoVO;
    }

    /* compiled from: FooterFloor.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/FooterFloor$ActionInfoVO;", "", "reserveCouponInfo", "Lkntr/app/mall/product/details/page/api/model/FooterFloor$ReserveCouponInfo;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/FooterFloor$ReserveCouponInfo;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/model/FooterFloor$ReserveCouponInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getReserveCouponInfo", "()Lkntr/app/mall/product/details/page/api/model/FooterFloor$ReserveCouponInfo;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ActionInfoVO {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final ReserveCouponInfo reserveCouponInfo;

        public static /* synthetic */ ActionInfoVO copy$default(ActionInfoVO actionInfoVO, ReserveCouponInfo reserveCouponInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                reserveCouponInfo = actionInfoVO.reserveCouponInfo;
            }
            return actionInfoVO.copy(reserveCouponInfo);
        }

        public final ReserveCouponInfo component1() {
            return this.reserveCouponInfo;
        }

        public final ActionInfoVO copy(ReserveCouponInfo reserveCouponInfo) {
            Intrinsics.checkNotNullParameter(reserveCouponInfo, "reserveCouponInfo");
            return new ActionInfoVO(reserveCouponInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ActionInfoVO) && Intrinsics.areEqual(this.reserveCouponInfo, ((ActionInfoVO) obj).reserveCouponInfo);
        }

        public int hashCode() {
            return this.reserveCouponInfo.hashCode();
        }

        public String toString() {
            return "ActionInfoVO(reserveCouponInfo=" + this.reserveCouponInfo + ")";
        }

        /* compiled from: FooterFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/FooterFloor$ActionInfoVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/FooterFloor$ActionInfoVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ActionInfoVO> serializer() {
                return FooterFloor$ActionInfoVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ActionInfoVO(int seen0, ReserveCouponInfo reserveCouponInfo, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (seen0 & 1)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 1, FooterFloor$ActionInfoVO$$serializer.INSTANCE.getDescriptor());
            }
            this.reserveCouponInfo = reserveCouponInfo;
        }

        public ActionInfoVO(ReserveCouponInfo reserveCouponInfo) {
            Intrinsics.checkNotNullParameter(reserveCouponInfo, "reserveCouponInfo");
            this.reserveCouponInfo = reserveCouponInfo;
        }

        public final ReserveCouponInfo getReserveCouponInfo() {
            return this.reserveCouponInfo;
        }
    }

    public final List<CouponPackageInfoModel> getCouponPackageInfos() {
        return this.couponPackageInfos;
    }

    /* compiled from: FooterFloor.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/FooterFloor$ReserveCouponInfo;", "", "sourceId", "", "sourceAuthorityId", "sourceActivityId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSourceId", "()Ljava/lang/String;", "getSourceAuthorityId", "getSourceActivityId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ReserveCouponInfo {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String sourceActivityId;
        private final String sourceAuthorityId;
        private final String sourceId;

        public ReserveCouponInfo() {
            this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ReserveCouponInfo copy$default(ReserveCouponInfo reserveCouponInfo, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = reserveCouponInfo.sourceId;
            }
            if ((i & 2) != 0) {
                str2 = reserveCouponInfo.sourceAuthorityId;
            }
            if ((i & 4) != 0) {
                str3 = reserveCouponInfo.sourceActivityId;
            }
            return reserveCouponInfo.copy(str, str2, str3);
        }

        public final String component1() {
            return this.sourceId;
        }

        public final String component2() {
            return this.sourceAuthorityId;
        }

        public final String component3() {
            return this.sourceActivityId;
        }

        public final ReserveCouponInfo copy(String str, String str2, String str3) {
            return new ReserveCouponInfo(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ReserveCouponInfo) {
                ReserveCouponInfo reserveCouponInfo = (ReserveCouponInfo) obj;
                return Intrinsics.areEqual(this.sourceId, reserveCouponInfo.sourceId) && Intrinsics.areEqual(this.sourceAuthorityId, reserveCouponInfo.sourceAuthorityId) && Intrinsics.areEqual(this.sourceActivityId, reserveCouponInfo.sourceActivityId);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.sourceId == null ? 0 : this.sourceId.hashCode()) * 31) + (this.sourceAuthorityId == null ? 0 : this.sourceAuthorityId.hashCode())) * 31) + (this.sourceActivityId != null ? this.sourceActivityId.hashCode() : 0);
        }

        public String toString() {
            String str = this.sourceId;
            String str2 = this.sourceAuthorityId;
            return "ReserveCouponInfo(sourceId=" + str + ", sourceAuthorityId=" + str2 + ", sourceActivityId=" + this.sourceActivityId + ")";
        }

        /* compiled from: FooterFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/FooterFloor$ReserveCouponInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/FooterFloor$ReserveCouponInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ReserveCouponInfo> serializer() {
                return FooterFloor$ReserveCouponInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ReserveCouponInfo(int seen0, String sourceId, String sourceAuthorityId, String sourceActivityId, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.sourceId = null;
            } else {
                this.sourceId = sourceId;
            }
            if ((seen0 & 2) == 0) {
                this.sourceAuthorityId = null;
            } else {
                this.sourceAuthorityId = sourceAuthorityId;
            }
            if ((seen0 & 4) == 0) {
                this.sourceActivityId = null;
            } else {
                this.sourceActivityId = sourceActivityId;
            }
        }

        public ReserveCouponInfo(String sourceId, String sourceAuthorityId, String sourceActivityId) {
            this.sourceId = sourceId;
            this.sourceAuthorityId = sourceAuthorityId;
            this.sourceActivityId = sourceActivityId;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ReserveCouponInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.sourceId != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.sourceId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.sourceAuthorityId != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.sourceAuthorityId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.sourceActivityId != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.sourceActivityId);
            }
        }

        public /* synthetic */ ReserveCouponInfo(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        public final String getSourceId() {
            return this.sourceId;
        }

        public final String getSourceAuthorityId() {
            return this.sourceAuthorityId;
        }

        public final String getSourceActivityId() {
            return this.sourceActivityId;
        }
    }

    /* compiled from: FooterFloor.kt */
    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010$\n\u0002\b%\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u0086\u00012\u00020\u0001:\u0004\u0085\u0001\u0086\u0001Bç\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0017\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!¢\u0006\u0004\b'\u0010(BÅ\u0002\b\u0010\u0012\u0006\u0010)\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0017\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010!\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!\u0012\b\u0010*\u001a\u0004\u0018\u00010+¢\u0006\u0004\b'\u0010,J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010:J\u000b\u0010d\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010i\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010FJ\u0010\u0010j\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010k\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010n\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010o\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010FJ\u0010\u0010p\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010FJ\u0011\u0010q\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010!HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u0010\u0010s\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00102J\u0011\u0010t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010v\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!HÆ\u0003Jð\u0002\u0010w\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!HÆ\u0001¢\u0006\u0002\u0010xJ\u0013\u0010y\u001a\u00020\u00172\b\u0010z\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010{\u001a\u00020\u0007HÖ\u0001J\t\u0010|\u001a\u00020\u0005HÖ\u0001J*\u0010}\u001a\u00020~2\u0006\u0010\u007f\u001a\u00020\u00002\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0001¢\u0006\u0003\b\u0084\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u00100R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u00100R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00103\u001a\u0004\b6\u00102R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u00100R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u00100R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00103\u001a\u0004\bB\u00102R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u00100R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00103\u001a\u0004\bD\u00102R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010G\u001a\u0004\bE\u0010FR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00103\u001a\u0004\bH\u00102R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u00100R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00103\u001a\u0004\bL\u00102R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00103\u001a\u0004\bM\u00102R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010G\u001a\u0004\bN\u0010FR\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010G\u001a\u0004\bO\u0010FR\u0019\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u0010\"\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\bR\u0010JR\u0015\u0010#\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00103\u001a\u0004\bS\u00102R\u0019\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bT\u0010QR\u0013\u0010%\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bU\u00100R\u0019\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bV\u0010QR\u001d\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010X8F¢\u0006\u0006\u001a\u0004\bY\u0010Z¨\u0006\u0087\u0001"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/FooterFloor$PurchaseButton;", "", "buttonSubCountDownInfo", "Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;", "addCartJumpUrl", "", "addCartType", "", "buttonDayColor", "buttonNightColor", "buttonState", "buttonSubText", "buttonText", "itemsId", "", "buttonPriceDescVO", "Lkntr/app/mall/product/details/page/api/model/PriceDescVO;", "calendarRemind", "Lkntr/app/mall/product/details/page/api/model/CalendarRemindModel;", "jumpType", "jumpUrl", "merchantId", "mergeCartBuyButton", "", "mergeCartBuyButtonType", "realtimeRequest", "Lkotlinx/serialization/json/JsonObject;", "remindMessage", "remindTime", "shopId", "showAddCart", "showQuickOrder", "skuIds", "", "sourceQuery", "type", "bgColors", "fontColor", "shadingImgs", "<init>", "(Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/PriceDescVO;Lkntr/app/mall/product/details/page/api/model/CalendarRemindModel;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Lkotlinx/serialization/json/JsonObject;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/model/CountDownInfoVO;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/PriceDescVO;Lkntr/app/mall/product/details/page/api/model/CalendarRemindModel;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Lkotlinx/serialization/json/JsonObject;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getButtonSubCountDownInfo", "()Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;", "getAddCartJumpUrl", "()Ljava/lang/String;", "getAddCartType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getButtonDayColor", "getButtonNightColor", "getButtonState", "getButtonSubText", "getButtonText", "getItemsId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getButtonPriceDescVO", "()Lkntr/app/mall/product/details/page/api/model/PriceDescVO;", "setButtonPriceDescVO", "(Lkntr/app/mall/product/details/page/api/model/PriceDescVO;)V", "getCalendarRemind", "()Lkntr/app/mall/product/details/page/api/model/CalendarRemindModel;", "getJumpType", "getJumpUrl", "getMerchantId", "getMergeCartBuyButton", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMergeCartBuyButtonType", "getRealtimeRequest", "()Lkotlinx/serialization/json/JsonObject;", "getRemindMessage", "getRemindTime", "getShopId", "getShowAddCart", "getShowQuickOrder", "getSkuIds", "()Ljava/util/List;", "getSourceQuery", "getType", "getBgColors", "getFontColor", "getShadingImgs", "orderParams", "", "getOrderParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "copy", "(Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/PriceDescVO;Lkntr/app/mall/product/details/page/api/model/CalendarRemindModel;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Lkotlinx/serialization/json/JsonObject;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/model/FooterFloor$PurchaseButton;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class PurchaseButton {
        private final String addCartJumpUrl;
        private final Integer addCartType;
        private final List<String> bgColors;
        private final String buttonDayColor;
        private final String buttonNightColor;
        private PriceDescVO buttonPriceDescVO;
        private final Integer buttonState;
        private final CountDownInfoVO buttonSubCountDownInfo;
        private final String buttonSubText;
        private final String buttonText;
        private final CalendarRemindModel calendarRemind;
        private final String fontColor;
        private final Long itemsId;
        private final Integer jumpType;
        private final String jumpUrl;
        private final Integer merchantId;
        private final Boolean mergeCartBuyButton;
        private final Integer mergeCartBuyButtonType;
        private final JsonObject realtimeRequest;
        private final String remindMessage;
        private final Integer remindTime;
        private final List<String> shadingImgs;
        private final Integer shopId;
        private final Boolean showAddCart;
        private final Boolean showQuickOrder;
        private final List<Long> skuIds;
        private final JsonObject sourceQuery;
        private final Integer type;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.FooterFloor$PurchaseButton$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = FooterFloor.PurchaseButton._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.FooterFloor$PurchaseButton$$ExternalSyntheticLambda1
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$0;
                _childSerializers$_anonymous_$0 = FooterFloor.PurchaseButton._childSerializers$_anonymous_$0();
                return _childSerializers$_anonymous_$0;
            }
        }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.FooterFloor$PurchaseButton$$ExternalSyntheticLambda2
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$1;
                _childSerializers$_anonymous_$1 = FooterFloor.PurchaseButton._childSerializers$_anonymous_$1();
                return _childSerializers$_anonymous_$1;
            }
        })};

        public final CountDownInfoVO component1() {
            return this.buttonSubCountDownInfo;
        }

        public final PriceDescVO component10() {
            return this.buttonPriceDescVO;
        }

        public final CalendarRemindModel component11() {
            return this.calendarRemind;
        }

        public final Integer component12() {
            return this.jumpType;
        }

        public final String component13() {
            return this.jumpUrl;
        }

        public final Integer component14() {
            return this.merchantId;
        }

        public final Boolean component15() {
            return this.mergeCartBuyButton;
        }

        public final Integer component16() {
            return this.mergeCartBuyButtonType;
        }

        public final JsonObject component17() {
            return this.realtimeRequest;
        }

        public final String component18() {
            return this.remindMessage;
        }

        public final Integer component19() {
            return this.remindTime;
        }

        public final String component2() {
            return this.addCartJumpUrl;
        }

        public final Integer component20() {
            return this.shopId;
        }

        public final Boolean component21() {
            return this.showAddCart;
        }

        public final Boolean component22() {
            return this.showQuickOrder;
        }

        public final List<Long> component23() {
            return this.skuIds;
        }

        public final JsonObject component24() {
            return this.sourceQuery;
        }

        public final Integer component25() {
            return this.type;
        }

        public final List<String> component26() {
            return this.bgColors;
        }

        public final String component27() {
            return this.fontColor;
        }

        public final List<String> component28() {
            return this.shadingImgs;
        }

        public final Integer component3() {
            return this.addCartType;
        }

        public final String component4() {
            return this.buttonDayColor;
        }

        public final String component5() {
            return this.buttonNightColor;
        }

        public final Integer component6() {
            return this.buttonState;
        }

        public final String component7() {
            return this.buttonSubText;
        }

        public final String component8() {
            return this.buttonText;
        }

        public final Long component9() {
            return this.itemsId;
        }

        public final PurchaseButton copy(CountDownInfoVO countDownInfoVO, String str, Integer num, String str2, String str3, Integer num2, String str4, String str5, Long l, PriceDescVO priceDescVO, CalendarRemindModel calendarRemindModel, Integer num3, String str6, Integer num4, Boolean bool, Integer num5, JsonObject jsonObject, String str7, Integer num6, Integer num7, Boolean bool2, Boolean bool3, List<Long> list, JsonObject jsonObject2, Integer num8, List<String> list2, String str8, List<String> list3) {
            return new PurchaseButton(countDownInfoVO, str, num, str2, str3, num2, str4, str5, l, priceDescVO, calendarRemindModel, num3, str6, num4, bool, num5, jsonObject, str7, num6, num7, bool2, bool3, list, jsonObject2, num8, list2, str8, list3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PurchaseButton) {
                PurchaseButton purchaseButton = (PurchaseButton) obj;
                return Intrinsics.areEqual(this.buttonSubCountDownInfo, purchaseButton.buttonSubCountDownInfo) && Intrinsics.areEqual(this.addCartJumpUrl, purchaseButton.addCartJumpUrl) && Intrinsics.areEqual(this.addCartType, purchaseButton.addCartType) && Intrinsics.areEqual(this.buttonDayColor, purchaseButton.buttonDayColor) && Intrinsics.areEqual(this.buttonNightColor, purchaseButton.buttonNightColor) && Intrinsics.areEqual(this.buttonState, purchaseButton.buttonState) && Intrinsics.areEqual(this.buttonSubText, purchaseButton.buttonSubText) && Intrinsics.areEqual(this.buttonText, purchaseButton.buttonText) && Intrinsics.areEqual(this.itemsId, purchaseButton.itemsId) && Intrinsics.areEqual(this.buttonPriceDescVO, purchaseButton.buttonPriceDescVO) && Intrinsics.areEqual(this.calendarRemind, purchaseButton.calendarRemind) && Intrinsics.areEqual(this.jumpType, purchaseButton.jumpType) && Intrinsics.areEqual(this.jumpUrl, purchaseButton.jumpUrl) && Intrinsics.areEqual(this.merchantId, purchaseButton.merchantId) && Intrinsics.areEqual(this.mergeCartBuyButton, purchaseButton.mergeCartBuyButton) && Intrinsics.areEqual(this.mergeCartBuyButtonType, purchaseButton.mergeCartBuyButtonType) && Intrinsics.areEqual(this.realtimeRequest, purchaseButton.realtimeRequest) && Intrinsics.areEqual(this.remindMessage, purchaseButton.remindMessage) && Intrinsics.areEqual(this.remindTime, purchaseButton.remindTime) && Intrinsics.areEqual(this.shopId, purchaseButton.shopId) && Intrinsics.areEqual(this.showAddCart, purchaseButton.showAddCart) && Intrinsics.areEqual(this.showQuickOrder, purchaseButton.showQuickOrder) && Intrinsics.areEqual(this.skuIds, purchaseButton.skuIds) && Intrinsics.areEqual(this.sourceQuery, purchaseButton.sourceQuery) && Intrinsics.areEqual(this.type, purchaseButton.type) && Intrinsics.areEqual(this.bgColors, purchaseButton.bgColors) && Intrinsics.areEqual(this.fontColor, purchaseButton.fontColor) && Intrinsics.areEqual(this.shadingImgs, purchaseButton.shadingImgs);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((((((((((((this.buttonSubCountDownInfo == null ? 0 : this.buttonSubCountDownInfo.hashCode()) * 31) + (this.addCartJumpUrl == null ? 0 : this.addCartJumpUrl.hashCode())) * 31) + (this.addCartType == null ? 0 : this.addCartType.hashCode())) * 31) + (this.buttonDayColor == null ? 0 : this.buttonDayColor.hashCode())) * 31) + (this.buttonNightColor == null ? 0 : this.buttonNightColor.hashCode())) * 31) + (this.buttonState == null ? 0 : this.buttonState.hashCode())) * 31) + (this.buttonSubText == null ? 0 : this.buttonSubText.hashCode())) * 31) + (this.buttonText == null ? 0 : this.buttonText.hashCode())) * 31) + (this.itemsId == null ? 0 : this.itemsId.hashCode())) * 31) + (this.buttonPriceDescVO == null ? 0 : this.buttonPriceDescVO.hashCode())) * 31) + (this.calendarRemind == null ? 0 : this.calendarRemind.hashCode())) * 31) + (this.jumpType == null ? 0 : this.jumpType.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.merchantId == null ? 0 : this.merchantId.hashCode())) * 31) + (this.mergeCartBuyButton == null ? 0 : this.mergeCartBuyButton.hashCode())) * 31) + (this.mergeCartBuyButtonType == null ? 0 : this.mergeCartBuyButtonType.hashCode())) * 31) + (this.realtimeRequest == null ? 0 : this.realtimeRequest.hashCode())) * 31) + (this.remindMessage == null ? 0 : this.remindMessage.hashCode())) * 31) + (this.remindTime == null ? 0 : this.remindTime.hashCode())) * 31) + (this.shopId == null ? 0 : this.shopId.hashCode())) * 31) + (this.showAddCart == null ? 0 : this.showAddCart.hashCode())) * 31) + (this.showQuickOrder == null ? 0 : this.showQuickOrder.hashCode())) * 31) + (this.skuIds == null ? 0 : this.skuIds.hashCode())) * 31) + (this.sourceQuery == null ? 0 : this.sourceQuery.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.bgColors == null ? 0 : this.bgColors.hashCode())) * 31) + (this.fontColor == null ? 0 : this.fontColor.hashCode())) * 31) + (this.shadingImgs != null ? this.shadingImgs.hashCode() : 0);
        }

        public String toString() {
            CountDownInfoVO countDownInfoVO = this.buttonSubCountDownInfo;
            String str = this.addCartJumpUrl;
            Integer num = this.addCartType;
            String str2 = this.buttonDayColor;
            String str3 = this.buttonNightColor;
            Integer num2 = this.buttonState;
            String str4 = this.buttonSubText;
            String str5 = this.buttonText;
            Long l = this.itemsId;
            PriceDescVO priceDescVO = this.buttonPriceDescVO;
            CalendarRemindModel calendarRemindModel = this.calendarRemind;
            Integer num3 = this.jumpType;
            String str6 = this.jumpUrl;
            Integer num4 = this.merchantId;
            Boolean bool = this.mergeCartBuyButton;
            Integer num5 = this.mergeCartBuyButtonType;
            JsonObject jsonObject = this.realtimeRequest;
            String str7 = this.remindMessage;
            Integer num6 = this.remindTime;
            Integer num7 = this.shopId;
            Boolean bool2 = this.showAddCart;
            Boolean bool3 = this.showQuickOrder;
            List<Long> list = this.skuIds;
            JsonObject jsonObject2 = this.sourceQuery;
            Integer num8 = this.type;
            List<String> list2 = this.bgColors;
            String str8 = this.fontColor;
            return "PurchaseButton(buttonSubCountDownInfo=" + countDownInfoVO + ", addCartJumpUrl=" + str + ", addCartType=" + num + ", buttonDayColor=" + str2 + ", buttonNightColor=" + str3 + ", buttonState=" + num2 + ", buttonSubText=" + str4 + ", buttonText=" + str5 + ", itemsId=" + l + ", buttonPriceDescVO=" + priceDescVO + ", calendarRemind=" + calendarRemindModel + ", jumpType=" + num3 + ", jumpUrl=" + str6 + ", merchantId=" + num4 + ", mergeCartBuyButton=" + bool + ", mergeCartBuyButtonType=" + num5 + ", realtimeRequest=" + jsonObject + ", remindMessage=" + str7 + ", remindTime=" + num6 + ", shopId=" + num7 + ", showAddCart=" + bool2 + ", showQuickOrder=" + bool3 + ", skuIds=" + list + ", sourceQuery=" + jsonObject2 + ", type=" + num8 + ", bgColors=" + list2 + ", fontColor=" + str8 + ", shadingImgs=" + this.shadingImgs + ")";
        }

        /* compiled from: FooterFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/FooterFloor$PurchaseButton$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/FooterFloor$PurchaseButton;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<PurchaseButton> serializer() {
                return FooterFloor$PurchaseButton$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ PurchaseButton(int seen0, CountDownInfoVO buttonSubCountDownInfo, String addCartJumpUrl, Integer addCartType, String buttonDayColor, String buttonNightColor, Integer buttonState, String buttonSubText, String buttonText, Long itemsId, PriceDescVO buttonPriceDescVO, CalendarRemindModel calendarRemind, Integer jumpType, String jumpUrl, Integer merchantId, Boolean mergeCartBuyButton, Integer mergeCartBuyButtonType, JsonObject realtimeRequest, String remindMessage, Integer remindTime, Integer shopId, Boolean showAddCart, Boolean showQuickOrder, List skuIds, JsonObject sourceQuery, Integer type, List bgColors, String fontColor, List shadingImgs, SerializationConstructorMarker serializationConstructorMarker) {
            if (65536 != (seen0 & 65536)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 65536, FooterFloor$PurchaseButton$$serializer.INSTANCE.getDescriptor());
            }
            if ((seen0 & 1) == 0) {
                this.buttonSubCountDownInfo = null;
            } else {
                this.buttonSubCountDownInfo = buttonSubCountDownInfo;
            }
            if ((seen0 & 2) == 0) {
                this.addCartJumpUrl = null;
            } else {
                this.addCartJumpUrl = addCartJumpUrl;
            }
            if ((seen0 & 4) == 0) {
                this.addCartType = null;
            } else {
                this.addCartType = addCartType;
            }
            if ((seen0 & 8) == 0) {
                this.buttonDayColor = null;
            } else {
                this.buttonDayColor = buttonDayColor;
            }
            if ((seen0 & 16) == 0) {
                this.buttonNightColor = null;
            } else {
                this.buttonNightColor = buttonNightColor;
            }
            if ((seen0 & 32) == 0) {
                this.buttonState = null;
            } else {
                this.buttonState = buttonState;
            }
            if ((seen0 & 64) == 0) {
                this.buttonSubText = null;
            } else {
                this.buttonSubText = buttonSubText;
            }
            if ((seen0 & 128) == 0) {
                this.buttonText = null;
            } else {
                this.buttonText = buttonText;
            }
            if ((seen0 & 256) == 0) {
                this.itemsId = null;
            } else {
                this.itemsId = itemsId;
            }
            if ((seen0 & 512) == 0) {
                this.buttonPriceDescVO = null;
            } else {
                this.buttonPriceDescVO = buttonPriceDescVO;
            }
            if ((seen0 & 1024) == 0) {
                this.calendarRemind = null;
            } else {
                this.calendarRemind = calendarRemind;
            }
            if ((seen0 & 2048) == 0) {
                this.jumpType = null;
            } else {
                this.jumpType = jumpType;
            }
            if ((seen0 & 4096) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
            if ((seen0 & 8192) == 0) {
                this.merchantId = null;
            } else {
                this.merchantId = merchantId;
            }
            if ((seen0 & 16384) == 0) {
                this.mergeCartBuyButton = null;
            } else {
                this.mergeCartBuyButton = mergeCartBuyButton;
            }
            if ((seen0 & 32768) == 0) {
                this.mergeCartBuyButtonType = null;
            } else {
                this.mergeCartBuyButtonType = mergeCartBuyButtonType;
            }
            this.realtimeRequest = realtimeRequest;
            if ((seen0 & 131072) == 0) {
                this.remindMessage = null;
            } else {
                this.remindMessage = remindMessage;
            }
            if ((seen0 & 262144) == 0) {
                this.remindTime = null;
            } else {
                this.remindTime = remindTime;
            }
            if ((seen0 & 524288) == 0) {
                this.shopId = null;
            } else {
                this.shopId = shopId;
            }
            if ((seen0 & 1048576) == 0) {
                this.showAddCart = null;
            } else {
                this.showAddCart = showAddCart;
            }
            if ((seen0 & 2097152) == 0) {
                this.showQuickOrder = null;
            } else {
                this.showQuickOrder = showQuickOrder;
            }
            if ((seen0 & 4194304) == 0) {
                this.skuIds = null;
            } else {
                this.skuIds = skuIds;
            }
            if ((seen0 & 8388608) == 0) {
                this.sourceQuery = null;
            } else {
                this.sourceQuery = sourceQuery;
            }
            if ((seen0 & 16777216) == 0) {
                this.type = null;
            } else {
                this.type = type;
            }
            if ((seen0 & 33554432) == 0) {
                this.bgColors = null;
            } else {
                this.bgColors = bgColors;
            }
            if ((seen0 & 67108864) == 0) {
                this.fontColor = null;
            } else {
                this.fontColor = fontColor;
            }
            if ((seen0 & 134217728) == 0) {
                this.shadingImgs = null;
            } else {
                this.shadingImgs = shadingImgs;
            }
        }

        public PurchaseButton(CountDownInfoVO buttonSubCountDownInfo, String addCartJumpUrl, Integer addCartType, String buttonDayColor, String buttonNightColor, Integer buttonState, String buttonSubText, String buttonText, Long itemsId, PriceDescVO buttonPriceDescVO, CalendarRemindModel calendarRemind, Integer jumpType, String jumpUrl, Integer merchantId, Boolean mergeCartBuyButton, Integer mergeCartBuyButtonType, JsonObject realtimeRequest, String remindMessage, Integer remindTime, Integer shopId, Boolean showAddCart, Boolean showQuickOrder, List<Long> list, JsonObject sourceQuery, Integer type, List<String> list2, String fontColor, List<String> list3) {
            this.buttonSubCountDownInfo = buttonSubCountDownInfo;
            this.addCartJumpUrl = addCartJumpUrl;
            this.addCartType = addCartType;
            this.buttonDayColor = buttonDayColor;
            this.buttonNightColor = buttonNightColor;
            this.buttonState = buttonState;
            this.buttonSubText = buttonSubText;
            this.buttonText = buttonText;
            this.itemsId = itemsId;
            this.buttonPriceDescVO = buttonPriceDescVO;
            this.calendarRemind = calendarRemind;
            this.jumpType = jumpType;
            this.jumpUrl = jumpUrl;
            this.merchantId = merchantId;
            this.mergeCartBuyButton = mergeCartBuyButton;
            this.mergeCartBuyButtonType = mergeCartBuyButtonType;
            this.realtimeRequest = realtimeRequest;
            this.remindMessage = remindMessage;
            this.remindTime = remindTime;
            this.shopId = shopId;
            this.showAddCart = showAddCart;
            this.showQuickOrder = showQuickOrder;
            this.skuIds = list;
            this.sourceQuery = sourceQuery;
            this.type = type;
            this.bgColors = list2;
            this.fontColor = fontColor;
            this.shadingImgs = list3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(LongSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(PurchaseButton self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.buttonSubCountDownInfo != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, CountDownInfoVO$$serializer.INSTANCE, self.buttonSubCountDownInfo);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.addCartJumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.addCartJumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.addCartType != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.addCartType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.buttonDayColor != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.buttonDayColor);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.buttonNightColor != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.buttonNightColor);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.buttonState != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.buttonState);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.buttonSubText != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.buttonSubText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.buttonText != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.buttonText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.itemsId != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, LongSerializer.INSTANCE, self.itemsId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.buttonPriceDescVO != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, PriceDescVO$$serializer.INSTANCE, self.buttonPriceDescVO);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.calendarRemind != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, CalendarRemindModel$$serializer.INSTANCE, self.calendarRemind);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.jumpType != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, IntSerializer.INSTANCE, self.jumpType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.jumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.merchantId != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, IntSerializer.INSTANCE, self.merchantId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.mergeCartBuyButton != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, BooleanSerializer.INSTANCE, self.mergeCartBuyButton);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.mergeCartBuyButtonType != null) {
                output.encodeNullableSerializableElement(serialDesc, 15, IntSerializer.INSTANCE, self.mergeCartBuyButtonType);
            }
            output.encodeNullableSerializableElement(serialDesc, 16, JsonObjectSerializer.INSTANCE, self.realtimeRequest);
            if (output.shouldEncodeElementDefault(serialDesc, 17) || self.remindMessage != null) {
                output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.remindMessage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 18) || self.remindTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 18, IntSerializer.INSTANCE, self.remindTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 19) || self.shopId != null) {
                output.encodeNullableSerializableElement(serialDesc, 19, IntSerializer.INSTANCE, self.shopId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 20) || self.showAddCart != null) {
                output.encodeNullableSerializableElement(serialDesc, 20, BooleanSerializer.INSTANCE, self.showAddCart);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 21) || self.showQuickOrder != null) {
                output.encodeNullableSerializableElement(serialDesc, 21, BooleanSerializer.INSTANCE, self.showQuickOrder);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 22) || self.skuIds != null) {
                output.encodeNullableSerializableElement(serialDesc, 22, lazyArr[22].getValue(), self.skuIds);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 23) || self.sourceQuery != null) {
                output.encodeNullableSerializableElement(serialDesc, 23, JsonObjectSerializer.INSTANCE, self.sourceQuery);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 24) || self.type != null) {
                output.encodeNullableSerializableElement(serialDesc, 24, IntSerializer.INSTANCE, self.type);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 25) || self.bgColors != null) {
                output.encodeNullableSerializableElement(serialDesc, 25, lazyArr[25].getValue(), self.bgColors);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 26) || self.fontColor != null) {
                output.encodeNullableSerializableElement(serialDesc, 26, StringSerializer.INSTANCE, self.fontColor);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 27) || self.shadingImgs != null) {
                output.encodeNullableSerializableElement(serialDesc, 27, lazyArr[27].getValue(), self.shadingImgs);
            }
        }

        public /* synthetic */ PurchaseButton(CountDownInfoVO countDownInfoVO, String str, Integer num, String str2, String str3, Integer num2, String str4, String str5, Long l, PriceDescVO priceDescVO, CalendarRemindModel calendarRemindModel, Integer num3, String str6, Integer num4, Boolean bool, Integer num5, JsonObject jsonObject, String str7, Integer num6, Integer num7, Boolean bool2, Boolean bool3, List list, JsonObject jsonObject2, Integer num8, List list2, String str8, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : countDownInfoVO, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : l, (i & 512) != 0 ? null : priceDescVO, (i & 1024) != 0 ? null : calendarRemindModel, (i & 2048) != 0 ? null : num3, (i & 4096) != 0 ? null : str6, (i & 8192) != 0 ? null : num4, (i & 16384) != 0 ? null : bool, (32768 & i) != 0 ? null : num5, jsonObject, (131072 & i) != 0 ? null : str7, (262144 & i) != 0 ? null : num6, (524288 & i) != 0 ? null : num7, (1048576 & i) != 0 ? null : bool2, (2097152 & i) != 0 ? null : bool3, (4194304 & i) != 0 ? null : list, (8388608 & i) != 0 ? null : jsonObject2, (16777216 & i) != 0 ? null : num8, (33554432 & i) != 0 ? null : list2, (67108864 & i) != 0 ? null : str8, (i & 134217728) != 0 ? null : list3);
        }

        public final CountDownInfoVO getButtonSubCountDownInfo() {
            return this.buttonSubCountDownInfo;
        }

        public final String getAddCartJumpUrl() {
            return this.addCartJumpUrl;
        }

        public final Integer getAddCartType() {
            return this.addCartType;
        }

        public final String getButtonDayColor() {
            return this.buttonDayColor;
        }

        public final String getButtonNightColor() {
            return this.buttonNightColor;
        }

        public final Integer getButtonState() {
            return this.buttonState;
        }

        public final String getButtonSubText() {
            return this.buttonSubText;
        }

        public final String getButtonText() {
            return this.buttonText;
        }

        public final Long getItemsId() {
            return this.itemsId;
        }

        public final PriceDescVO getButtonPriceDescVO() {
            return this.buttonPriceDescVO;
        }

        public final void setButtonPriceDescVO(PriceDescVO priceDescVO) {
            this.buttonPriceDescVO = priceDescVO;
        }

        public final CalendarRemindModel getCalendarRemind() {
            return this.calendarRemind;
        }

        public final Integer getJumpType() {
            return this.jumpType;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final Integer getMerchantId() {
            return this.merchantId;
        }

        public final Boolean getMergeCartBuyButton() {
            return this.mergeCartBuyButton;
        }

        public final Integer getMergeCartBuyButtonType() {
            return this.mergeCartBuyButtonType;
        }

        public final JsonObject getRealtimeRequest() {
            return this.realtimeRequest;
        }

        public final String getRemindMessage() {
            return this.remindMessage;
        }

        public final Integer getRemindTime() {
            return this.remindTime;
        }

        public final Integer getShopId() {
            return this.shopId;
        }

        public final Boolean getShowAddCart() {
            return this.showAddCart;
        }

        public final Boolean getShowQuickOrder() {
            return this.showQuickOrder;
        }

        public final List<Long> getSkuIds() {
            return this.skuIds;
        }

        public final JsonObject getSourceQuery() {
            return this.sourceQuery;
        }

        public final Integer getType() {
            return this.type;
        }

        public final List<String> getBgColors() {
            return this.bgColors;
        }

        public final String getFontColor() {
            return this.fontColor;
        }

        public final List<String> getShadingImgs() {
            return this.shadingImgs;
        }

        public final Map<String, Object> getOrderParams() {
            StringFormat $this$encodeToString$iv = Json.Default;
            Object value$iv = this.realtimeRequest;
            $this$encodeToString$iv.getSerializersModule();
            StringFormat $this$encodeToString$iv2 = Json.Default;
            Object value$iv2 = this.sourceQuery;
            $this$encodeToString$iv2.getSerializersModule();
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("realtimeRequest", $this$encodeToString$iv.encodeToString(BuiltinSerializersKt.getNullable(JsonObject.Companion.serializer()), value$iv)), TuplesKt.to("sourceQuery", $this$encodeToString$iv2.encodeToString(BuiltinSerializersKt.getNullable(JsonObject.Companion.serializer()), value$iv2))});
        }
    }

    /* compiled from: FooterFloor.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(BC\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tBO\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006)"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/FooterFloor$AddCartButton;", "", "bgColors", "", "", "fontColor", "shadingImgs", "buttonIcon", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBgColors", "()Ljava/util/List;", "getFontColor", "()Ljava/lang/String;", "getShadingImgs", "getButtonIcon", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AddCartButton {
        private final List<String> bgColors;
        private final String buttonIcon;
        private final String fontColor;
        private final List<String> shadingImgs;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.FooterFloor$AddCartButton$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = FooterFloor.AddCartButton._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.FooterFloor$AddCartButton$$ExternalSyntheticLambda1
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$0;
                _childSerializers$_anonymous_$0 = FooterFloor.AddCartButton._childSerializers$_anonymous_$0();
                return _childSerializers$_anonymous_$0;
            }
        }), null};

        public AddCartButton() {
            this((List) null, (String) null, (List) null, (String) null, 15, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AddCartButton copy$default(AddCartButton addCartButton, List list, String str, List list2, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = addCartButton.bgColors;
            }
            if ((i & 2) != 0) {
                str = addCartButton.fontColor;
            }
            if ((i & 4) != 0) {
                list2 = addCartButton.shadingImgs;
            }
            if ((i & 8) != 0) {
                str2 = addCartButton.buttonIcon;
            }
            return addCartButton.copy(list, str, list2, str2);
        }

        public final List<String> component1() {
            return this.bgColors;
        }

        public final String component2() {
            return this.fontColor;
        }

        public final List<String> component3() {
            return this.shadingImgs;
        }

        public final String component4() {
            return this.buttonIcon;
        }

        public final AddCartButton copy(List<String> list, String str, List<String> list2, String str2) {
            return new AddCartButton(list, str, list2, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AddCartButton) {
                AddCartButton addCartButton = (AddCartButton) obj;
                return Intrinsics.areEqual(this.bgColors, addCartButton.bgColors) && Intrinsics.areEqual(this.fontColor, addCartButton.fontColor) && Intrinsics.areEqual(this.shadingImgs, addCartButton.shadingImgs) && Intrinsics.areEqual(this.buttonIcon, addCartButton.buttonIcon);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.bgColors == null ? 0 : this.bgColors.hashCode()) * 31) + (this.fontColor == null ? 0 : this.fontColor.hashCode())) * 31) + (this.shadingImgs == null ? 0 : this.shadingImgs.hashCode())) * 31) + (this.buttonIcon != null ? this.buttonIcon.hashCode() : 0);
        }

        public String toString() {
            List<String> list = this.bgColors;
            String str = this.fontColor;
            List<String> list2 = this.shadingImgs;
            return "AddCartButton(bgColors=" + list + ", fontColor=" + str + ", shadingImgs=" + list2 + ", buttonIcon=" + this.buttonIcon + ")";
        }

        /* compiled from: FooterFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/FooterFloor$AddCartButton$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/FooterFloor$AddCartButton;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<AddCartButton> serializer() {
                return FooterFloor$AddCartButton$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ AddCartButton(int seen0, List bgColors, String fontColor, List shadingImgs, String buttonIcon, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.bgColors = null;
            } else {
                this.bgColors = bgColors;
            }
            if ((seen0 & 2) == 0) {
                this.fontColor = null;
            } else {
                this.fontColor = fontColor;
            }
            if ((seen0 & 4) == 0) {
                this.shadingImgs = null;
            } else {
                this.shadingImgs = shadingImgs;
            }
            if ((seen0 & 8) == 0) {
                this.buttonIcon = null;
            } else {
                this.buttonIcon = buttonIcon;
            }
        }

        public AddCartButton(List<String> list, String fontColor, List<String> list2, String buttonIcon) {
            this.bgColors = list;
            this.fontColor = fontColor;
            this.shadingImgs = list2;
            this.buttonIcon = buttonIcon;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(AddCartButton self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.bgColors != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.bgColors);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.fontColor != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.fontColor);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.shadingImgs != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.shadingImgs);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.buttonIcon != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.buttonIcon);
            }
        }

        public /* synthetic */ AddCartButton(List list, String str, List list2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : str2);
        }

        public final List<String> getBgColors() {
            return this.bgColors;
        }

        public final String getFontColor() {
            return this.fontColor;
        }

        public final List<String> getShadingImgs() {
            return this.shadingImgs;
        }

        public final String getButtonIcon() {
            return this.buttonIcon;
        }
    }
}