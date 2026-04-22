package kntr.app.mall.product.details.page.api.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: FooterFloor.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Y2\u00020\u0001:\u0002XYBß\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019BÏ\u0001\b\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0018\u0010\u001eJ\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 Jæ\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020\u00032\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020\u001bHÖ\u0001J\t\u0010O\u001a\u00020\bHÖ\u0001J%\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0001¢\u0006\u0002\bWR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010'R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010'R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010'R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010'R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b7\u0010 ¨\u0006Z"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponInfoModel;", "", "couponAvailable", "", "status", "", "stockStatus", "showName", "", "couponUseEndTimeStr", "couponUseEndTime", "", "couponUseStartTimeStr", "couponUseStartTime", "couponDesc", "couponTypeDesc", "couponShowTypeName", "discountY", "discountYPrefix", "discountYSuffix", "sourceAuthorityId", "sourceId", "sourceActivityId", "needDeviceCheck", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Byte;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Byte;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCouponAvailable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStatus", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getStockStatus", "getShowName", "()Ljava/lang/String;", "getCouponUseEndTimeStr", "getCouponUseEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCouponUseStartTimeStr", "getCouponUseStartTime", "getCouponDesc", "getCouponTypeDesc", "getCouponShowTypeName", "getDiscountY", "getDiscountYPrefix", "getDiscountYSuffix", "getSourceAuthorityId", "getSourceId", "getSourceActivityId", "getNeedDeviceCheck", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/Boolean;Ljava/lang/Byte;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lkntr/app/mall/product/details/page/api/model/CouponInfoModel;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class CouponInfoModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Boolean couponAvailable;
    private final String couponDesc;
    private final String couponShowTypeName;
    private final String couponTypeDesc;
    private final Long couponUseEndTime;
    private final String couponUseEndTimeStr;
    private final String couponUseStartTime;
    private final String couponUseStartTimeStr;
    private final String discountY;
    private final String discountYPrefix;
    private final String discountYSuffix;
    private final Boolean needDeviceCheck;
    private final String showName;
    private final String sourceActivityId;
    private final String sourceAuthorityId;
    private final String sourceId;
    private final Byte status;
    private final Byte stockStatus;

    public CouponInfoModel() {
        this((Boolean) null, (Byte) null, (Byte) null, (String) null, (String) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 262143, (DefaultConstructorMarker) null);
    }

    public final Boolean component1() {
        return this.couponAvailable;
    }

    public final String component10() {
        return this.couponTypeDesc;
    }

    public final String component11() {
        return this.couponShowTypeName;
    }

    public final String component12() {
        return this.discountY;
    }

    public final String component13() {
        return this.discountYPrefix;
    }

    public final String component14() {
        return this.discountYSuffix;
    }

    public final String component15() {
        return this.sourceAuthorityId;
    }

    public final String component16() {
        return this.sourceId;
    }

    public final String component17() {
        return this.sourceActivityId;
    }

    public final Boolean component18() {
        return this.needDeviceCheck;
    }

    public final Byte component2() {
        return this.status;
    }

    public final Byte component3() {
        return this.stockStatus;
    }

    public final String component4() {
        return this.showName;
    }

    public final String component5() {
        return this.couponUseEndTimeStr;
    }

    public final Long component6() {
        return this.couponUseEndTime;
    }

    public final String component7() {
        return this.couponUseStartTimeStr;
    }

    public final String component8() {
        return this.couponUseStartTime;
    }

    public final String component9() {
        return this.couponDesc;
    }

    public final CouponInfoModel copy(Boolean bool, Byte b, Byte b2, String str, String str2, Long l, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Boolean bool2) {
        return new CouponInfoModel(bool, b, b2, str, str2, l, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, bool2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CouponInfoModel) {
            CouponInfoModel couponInfoModel = (CouponInfoModel) obj;
            return Intrinsics.areEqual(this.couponAvailable, couponInfoModel.couponAvailable) && Intrinsics.areEqual(this.status, couponInfoModel.status) && Intrinsics.areEqual(this.stockStatus, couponInfoModel.stockStatus) && Intrinsics.areEqual(this.showName, couponInfoModel.showName) && Intrinsics.areEqual(this.couponUseEndTimeStr, couponInfoModel.couponUseEndTimeStr) && Intrinsics.areEqual(this.couponUseEndTime, couponInfoModel.couponUseEndTime) && Intrinsics.areEqual(this.couponUseStartTimeStr, couponInfoModel.couponUseStartTimeStr) && Intrinsics.areEqual(this.couponUseStartTime, couponInfoModel.couponUseStartTime) && Intrinsics.areEqual(this.couponDesc, couponInfoModel.couponDesc) && Intrinsics.areEqual(this.couponTypeDesc, couponInfoModel.couponTypeDesc) && Intrinsics.areEqual(this.couponShowTypeName, couponInfoModel.couponShowTypeName) && Intrinsics.areEqual(this.discountY, couponInfoModel.discountY) && Intrinsics.areEqual(this.discountYPrefix, couponInfoModel.discountYPrefix) && Intrinsics.areEqual(this.discountYSuffix, couponInfoModel.discountYSuffix) && Intrinsics.areEqual(this.sourceAuthorityId, couponInfoModel.sourceAuthorityId) && Intrinsics.areEqual(this.sourceId, couponInfoModel.sourceId) && Intrinsics.areEqual(this.sourceActivityId, couponInfoModel.sourceActivityId) && Intrinsics.areEqual(this.needDeviceCheck, couponInfoModel.needDeviceCheck);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((this.couponAvailable == null ? 0 : this.couponAvailable.hashCode()) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.stockStatus == null ? 0 : this.stockStatus.hashCode())) * 31) + (this.showName == null ? 0 : this.showName.hashCode())) * 31) + (this.couponUseEndTimeStr == null ? 0 : this.couponUseEndTimeStr.hashCode())) * 31) + (this.couponUseEndTime == null ? 0 : this.couponUseEndTime.hashCode())) * 31) + (this.couponUseStartTimeStr == null ? 0 : this.couponUseStartTimeStr.hashCode())) * 31) + (this.couponUseStartTime == null ? 0 : this.couponUseStartTime.hashCode())) * 31) + (this.couponDesc == null ? 0 : this.couponDesc.hashCode())) * 31) + (this.couponTypeDesc == null ? 0 : this.couponTypeDesc.hashCode())) * 31) + (this.couponShowTypeName == null ? 0 : this.couponShowTypeName.hashCode())) * 31) + (this.discountY == null ? 0 : this.discountY.hashCode())) * 31) + (this.discountYPrefix == null ? 0 : this.discountYPrefix.hashCode())) * 31) + (this.discountYSuffix == null ? 0 : this.discountYSuffix.hashCode())) * 31) + (this.sourceAuthorityId == null ? 0 : this.sourceAuthorityId.hashCode())) * 31) + (this.sourceId == null ? 0 : this.sourceId.hashCode())) * 31) + (this.sourceActivityId == null ? 0 : this.sourceActivityId.hashCode())) * 31) + (this.needDeviceCheck != null ? this.needDeviceCheck.hashCode() : 0);
    }

    public String toString() {
        Boolean bool = this.couponAvailable;
        Byte b = this.status;
        Byte b2 = this.stockStatus;
        String str = this.showName;
        String str2 = this.couponUseEndTimeStr;
        Long l = this.couponUseEndTime;
        String str3 = this.couponUseStartTimeStr;
        String str4 = this.couponUseStartTime;
        String str5 = this.couponDesc;
        String str6 = this.couponTypeDesc;
        String str7 = this.couponShowTypeName;
        String str8 = this.discountY;
        String str9 = this.discountYPrefix;
        String str10 = this.discountYSuffix;
        String str11 = this.sourceAuthorityId;
        String str12 = this.sourceId;
        String str13 = this.sourceActivityId;
        return "CouponInfoModel(couponAvailable=" + bool + ", status=" + b + ", stockStatus=" + b2 + ", showName=" + str + ", couponUseEndTimeStr=" + str2 + ", couponUseEndTime=" + l + ", couponUseStartTimeStr=" + str3 + ", couponUseStartTime=" + str4 + ", couponDesc=" + str5 + ", couponTypeDesc=" + str6 + ", couponShowTypeName=" + str7 + ", discountY=" + str8 + ", discountYPrefix=" + str9 + ", discountYSuffix=" + str10 + ", sourceAuthorityId=" + str11 + ", sourceId=" + str12 + ", sourceActivityId=" + str13 + ", needDeviceCheck=" + this.needDeviceCheck + ")";
    }

    /* compiled from: FooterFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponInfoModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CouponInfoModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CouponInfoModel> serializer() {
            return CouponInfoModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CouponInfoModel(int seen0, Boolean couponAvailable, Byte status, Byte stockStatus, String showName, String couponUseEndTimeStr, Long couponUseEndTime, String couponUseStartTimeStr, String couponUseStartTime, String couponDesc, String couponTypeDesc, String couponShowTypeName, String discountY, String discountYPrefix, String discountYSuffix, String sourceAuthorityId, String sourceId, String sourceActivityId, Boolean needDeviceCheck, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.couponAvailable = null;
        } else {
            this.couponAvailable = couponAvailable;
        }
        if ((seen0 & 2) == 0) {
            this.status = null;
        } else {
            this.status = status;
        }
        if ((seen0 & 4) == 0) {
            this.stockStatus = null;
        } else {
            this.stockStatus = stockStatus;
        }
        if ((seen0 & 8) == 0) {
            this.showName = null;
        } else {
            this.showName = showName;
        }
        if ((seen0 & 16) == 0) {
            this.couponUseEndTimeStr = null;
        } else {
            this.couponUseEndTimeStr = couponUseEndTimeStr;
        }
        if ((seen0 & 32) == 0) {
            this.couponUseEndTime = null;
        } else {
            this.couponUseEndTime = couponUseEndTime;
        }
        if ((seen0 & 64) == 0) {
            this.couponUseStartTimeStr = null;
        } else {
            this.couponUseStartTimeStr = couponUseStartTimeStr;
        }
        if ((seen0 & 128) == 0) {
            this.couponUseStartTime = null;
        } else {
            this.couponUseStartTime = couponUseStartTime;
        }
        if ((seen0 & 256) == 0) {
            this.couponDesc = null;
        } else {
            this.couponDesc = couponDesc;
        }
        if ((seen0 & 512) == 0) {
            this.couponTypeDesc = null;
        } else {
            this.couponTypeDesc = couponTypeDesc;
        }
        if ((seen0 & 1024) == 0) {
            this.couponShowTypeName = null;
        } else {
            this.couponShowTypeName = couponShowTypeName;
        }
        if ((seen0 & 2048) == 0) {
            this.discountY = null;
        } else {
            this.discountY = discountY;
        }
        if ((seen0 & 4096) == 0) {
            this.discountYPrefix = null;
        } else {
            this.discountYPrefix = discountYPrefix;
        }
        if ((seen0 & 8192) == 0) {
            this.discountYSuffix = null;
        } else {
            this.discountYSuffix = discountYSuffix;
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
            this.sourceActivityId = null;
        } else {
            this.sourceActivityId = sourceActivityId;
        }
        if ((seen0 & 131072) == 0) {
            this.needDeviceCheck = null;
        } else {
            this.needDeviceCheck = needDeviceCheck;
        }
    }

    public CouponInfoModel(Boolean couponAvailable, Byte status, Byte stockStatus, String showName, String couponUseEndTimeStr, Long couponUseEndTime, String couponUseStartTimeStr, String couponUseStartTime, String couponDesc, String couponTypeDesc, String couponShowTypeName, String discountY, String discountYPrefix, String discountYSuffix, String sourceAuthorityId, String sourceId, String sourceActivityId, Boolean needDeviceCheck) {
        this.couponAvailable = couponAvailable;
        this.status = status;
        this.stockStatus = stockStatus;
        this.showName = showName;
        this.couponUseEndTimeStr = couponUseEndTimeStr;
        this.couponUseEndTime = couponUseEndTime;
        this.couponUseStartTimeStr = couponUseStartTimeStr;
        this.couponUseStartTime = couponUseStartTime;
        this.couponDesc = couponDesc;
        this.couponTypeDesc = couponTypeDesc;
        this.couponShowTypeName = couponShowTypeName;
        this.discountY = discountY;
        this.discountYPrefix = discountYPrefix;
        this.discountYSuffix = discountYSuffix;
        this.sourceAuthorityId = sourceAuthorityId;
        this.sourceId = sourceId;
        this.sourceActivityId = sourceActivityId;
        this.needDeviceCheck = needDeviceCheck;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(CouponInfoModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.couponAvailable != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.couponAvailable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.status != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, ByteSerializer.INSTANCE, self.status);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.stockStatus != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, ByteSerializer.INSTANCE, self.stockStatus);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.showName != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.showName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.couponUseEndTimeStr != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.couponUseEndTimeStr);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.couponUseEndTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, LongSerializer.INSTANCE, self.couponUseEndTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.couponUseStartTimeStr != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.couponUseStartTimeStr);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.couponUseStartTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.couponUseStartTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.couponDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.couponDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.couponTypeDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.couponTypeDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.couponShowTypeName != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.couponShowTypeName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.discountY != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.discountY);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.discountYPrefix != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.discountYPrefix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.discountYSuffix != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.discountYSuffix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.sourceAuthorityId != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.sourceAuthorityId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.sourceId != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.sourceId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.sourceActivityId != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.sourceActivityId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.needDeviceCheck != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, BooleanSerializer.INSTANCE, self.needDeviceCheck);
        }
    }

    public /* synthetic */ CouponInfoModel(Boolean bool, Byte b, Byte b2, String str, String str2, Long l, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : b, (i & 4) != 0 ? null : b2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : l, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : str7, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : str9, (i & 8192) != 0 ? null : str10, (i & 16384) != 0 ? null : str11, (i & 32768) != 0 ? null : str12, (i & 65536) != 0 ? null : str13, (i & 131072) != 0 ? null : bool2);
    }

    public final Boolean getCouponAvailable() {
        return this.couponAvailable;
    }

    public final Byte getStatus() {
        return this.status;
    }

    public final Byte getStockStatus() {
        return this.stockStatus;
    }

    public final String getShowName() {
        return this.showName;
    }

    public final String getCouponUseEndTimeStr() {
        return this.couponUseEndTimeStr;
    }

    public final Long getCouponUseEndTime() {
        return this.couponUseEndTime;
    }

    public final String getCouponUseStartTimeStr() {
        return this.couponUseStartTimeStr;
    }

    public final String getCouponUseStartTime() {
        return this.couponUseStartTime;
    }

    public final String getCouponDesc() {
        return this.couponDesc;
    }

    public final String getCouponTypeDesc() {
        return this.couponTypeDesc;
    }

    public final String getCouponShowTypeName() {
        return this.couponShowTypeName;
    }

    public final String getDiscountY() {
        return this.discountY;
    }

    public final String getDiscountYPrefix() {
        return this.discountYPrefix;
    }

    public final String getDiscountYSuffix() {
        return this.discountYSuffix;
    }

    public final String getSourceAuthorityId() {
        return this.sourceAuthorityId;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final String getSourceActivityId() {
        return this.sourceActivityId;
    }

    public final Boolean getNeedDeviceCheck() {
        return this.needDeviceCheck;
    }
}