package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.CouponPackageInfoModel;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: FooterFloor.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 B2\u00020\u0001:\u0004?@ABBg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011Bk\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010/\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010&Jn\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u000bHÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001J%\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0001¢\u0006\u0002\b>R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b#\u0010\u0017R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b$\u0010\u0017R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&¨\u0006C"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel;", "", "autoReceive", "", "leftTime", "", "packagePopInfoVO", "Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel;", "packageBarInfoVO", "Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackageBarInfoModel;", "priority", "", "popup", "received", "showCouponType", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel;Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackageBarInfoModel;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Byte;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel;Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackageBarInfoModel;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Byte;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAutoReceive", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLeftTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPackagePopInfoVO", "()Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel;", "getPackageBarInfoVO", "()Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackageBarInfoModel;", "getPriority", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPopup", "getReceived", "getShowCouponType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel;Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackageBarInfoModel;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Byte;)Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "CouponPackagePopInfoModel", "CouponPackageBarInfoModel", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class CouponPackageInfoModel {
    private final Boolean autoReceive;
    private final Long leftTime;
    private final CouponPackageBarInfoModel packageBarInfoVO;
    private final CouponPackagePopInfoModel packagePopInfoVO;
    private final Boolean popup;
    private final Integer priority;
    private final Boolean received;
    private final Byte showCouponType;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public CouponPackageInfoModel() {
        this((Boolean) null, (Long) null, (CouponPackagePopInfoModel) null, (CouponPackageBarInfoModel) null, (Integer) null, (Boolean) null, (Boolean) null, (Byte) null, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
    }

    public final Boolean component1() {
        return this.autoReceive;
    }

    public final Long component2() {
        return this.leftTime;
    }

    public final CouponPackagePopInfoModel component3() {
        return this.packagePopInfoVO;
    }

    public final CouponPackageBarInfoModel component4() {
        return this.packageBarInfoVO;
    }

    public final Integer component5() {
        return this.priority;
    }

    public final Boolean component6() {
        return this.popup;
    }

    public final Boolean component7() {
        return this.received;
    }

    public final Byte component8() {
        return this.showCouponType;
    }

    public final CouponPackageInfoModel copy(Boolean bool, Long l, CouponPackagePopInfoModel couponPackagePopInfoModel, CouponPackageBarInfoModel couponPackageBarInfoModel, Integer num, Boolean bool2, Boolean bool3, Byte b) {
        return new CouponPackageInfoModel(bool, l, couponPackagePopInfoModel, couponPackageBarInfoModel, num, bool2, bool3, b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CouponPackageInfoModel) {
            CouponPackageInfoModel couponPackageInfoModel = (CouponPackageInfoModel) obj;
            return Intrinsics.areEqual(this.autoReceive, couponPackageInfoModel.autoReceive) && Intrinsics.areEqual(this.leftTime, couponPackageInfoModel.leftTime) && Intrinsics.areEqual(this.packagePopInfoVO, couponPackageInfoModel.packagePopInfoVO) && Intrinsics.areEqual(this.packageBarInfoVO, couponPackageInfoModel.packageBarInfoVO) && Intrinsics.areEqual(this.priority, couponPackageInfoModel.priority) && Intrinsics.areEqual(this.popup, couponPackageInfoModel.popup) && Intrinsics.areEqual(this.received, couponPackageInfoModel.received) && Intrinsics.areEqual(this.showCouponType, couponPackageInfoModel.showCouponType);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((this.autoReceive == null ? 0 : this.autoReceive.hashCode()) * 31) + (this.leftTime == null ? 0 : this.leftTime.hashCode())) * 31) + (this.packagePopInfoVO == null ? 0 : this.packagePopInfoVO.hashCode())) * 31) + (this.packageBarInfoVO == null ? 0 : this.packageBarInfoVO.hashCode())) * 31) + (this.priority == null ? 0 : this.priority.hashCode())) * 31) + (this.popup == null ? 0 : this.popup.hashCode())) * 31) + (this.received == null ? 0 : this.received.hashCode())) * 31) + (this.showCouponType != null ? this.showCouponType.hashCode() : 0);
    }

    public String toString() {
        Boolean bool = this.autoReceive;
        Long l = this.leftTime;
        CouponPackagePopInfoModel couponPackagePopInfoModel = this.packagePopInfoVO;
        CouponPackageBarInfoModel couponPackageBarInfoModel = this.packageBarInfoVO;
        Integer num = this.priority;
        Boolean bool2 = this.popup;
        Boolean bool3 = this.received;
        return "CouponPackageInfoModel(autoReceive=" + bool + ", leftTime=" + l + ", packagePopInfoVO=" + couponPackagePopInfoModel + ", packageBarInfoVO=" + couponPackageBarInfoModel + ", priority=" + num + ", popup=" + bool2 + ", received=" + bool3 + ", showCouponType=" + this.showCouponType + ")";
    }

    /* compiled from: FooterFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CouponPackageInfoModel> serializer() {
            return CouponPackageInfoModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CouponPackageInfoModel(int seen0, Boolean autoReceive, Long leftTime, CouponPackagePopInfoModel packagePopInfoVO, CouponPackageBarInfoModel packageBarInfoVO, Integer priority, Boolean popup, Boolean received, Byte showCouponType, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.autoReceive = null;
        } else {
            this.autoReceive = autoReceive;
        }
        if ((seen0 & 2) == 0) {
            this.leftTime = null;
        } else {
            this.leftTime = leftTime;
        }
        if ((seen0 & 4) == 0) {
            this.packagePopInfoVO = null;
        } else {
            this.packagePopInfoVO = packagePopInfoVO;
        }
        if ((seen0 & 8) == 0) {
            this.packageBarInfoVO = null;
        } else {
            this.packageBarInfoVO = packageBarInfoVO;
        }
        if ((seen0 & 16) == 0) {
            this.priority = null;
        } else {
            this.priority = priority;
        }
        if ((seen0 & 32) == 0) {
            this.popup = null;
        } else {
            this.popup = popup;
        }
        if ((seen0 & 64) == 0) {
            this.received = null;
        } else {
            this.received = received;
        }
        if ((seen0 & 128) == 0) {
            this.showCouponType = null;
        } else {
            this.showCouponType = showCouponType;
        }
    }

    public CouponPackageInfoModel(Boolean autoReceive, Long leftTime, CouponPackagePopInfoModel packagePopInfoVO, CouponPackageBarInfoModel packageBarInfoVO, Integer priority, Boolean popup, Boolean received, Byte showCouponType) {
        this.autoReceive = autoReceive;
        this.leftTime = leftTime;
        this.packagePopInfoVO = packagePopInfoVO;
        this.packageBarInfoVO = packageBarInfoVO;
        this.priority = priority;
        this.popup = popup;
        this.received = received;
        this.showCouponType = showCouponType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(CouponPackageInfoModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.autoReceive != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.autoReceive);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.leftTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.leftTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.packagePopInfoVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, CouponPackageInfoModel$CouponPackagePopInfoModel$$serializer.INSTANCE, self.packagePopInfoVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.packageBarInfoVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, CouponPackageInfoModel$CouponPackageBarInfoModel$$serializer.INSTANCE, self.packageBarInfoVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.priority != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.priority);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.popup != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.popup);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.received != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.received);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.showCouponType != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, ByteSerializer.INSTANCE, self.showCouponType);
        }
    }

    public /* synthetic */ CouponPackageInfoModel(Boolean bool, Long l, CouponPackagePopInfoModel couponPackagePopInfoModel, CouponPackageBarInfoModel couponPackageBarInfoModel, Integer num, Boolean bool2, Boolean bool3, Byte b, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : couponPackagePopInfoModel, (i & 8) != 0 ? null : couponPackageBarInfoModel, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : bool2, (i & 64) != 0 ? null : bool3, (i & 128) == 0 ? b : null);
    }

    public final Boolean getAutoReceive() {
        return this.autoReceive;
    }

    public final Long getLeftTime() {
        return this.leftTime;
    }

    public final CouponPackagePopInfoModel getPackagePopInfoVO() {
        return this.packagePopInfoVO;
    }

    public final CouponPackageBarInfoModel getPackageBarInfoVO() {
        return this.packageBarInfoVO;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final Boolean getPopup() {
        return this.popup;
    }

    public final Boolean getReceived() {
        return this.received;
    }

    /* compiled from: FooterFloor.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 82\u00020\u0001:\u0003678Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fBq\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jo\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0011HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016¨\u00069"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel;", "", "buttonText", "", "couponInfoList", "", "Lkntr/app/mall/product/details/page/api/model/CouponInfoModel;", "discountPrefix", "discountSuffix", "totalDiscount", "relatedUpInfo", "Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel$UserInfo;", "popUpTitleSuffix", "popUpSubTitle", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel$UserInfo;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel$UserInfo;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getButtonText", "()Ljava/lang/String;", "getCouponInfoList", "()Ljava/util/List;", "getDiscountPrefix", "getDiscountSuffix", "getTotalDiscount", "getRelatedUpInfo", "()Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel$UserInfo;", "getPopUpTitleSuffix", "getPopUpSubTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "UserInfo", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CouponPackagePopInfoModel {
        private final String buttonText;
        private final List<CouponInfoModel> couponInfoList;
        private final String discountPrefix;
        private final String discountSuffix;
        private final String popUpSubTitle;
        private final String popUpTitleSuffix;
        private final UserInfo relatedUpInfo;
        private final String totalDiscount;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.CouponPackageInfoModel$CouponPackagePopInfoModel$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = CouponPackageInfoModel.CouponPackagePopInfoModel._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, null, null, null, null, null};

        public CouponPackagePopInfoModel() {
            this((String) null, (List) null, (String) null, (String) null, (String) null, (UserInfo) null, (String) null, (String) null, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
        }

        public final String component1() {
            return this.buttonText;
        }

        public final List<CouponInfoModel> component2() {
            return this.couponInfoList;
        }

        public final String component3() {
            return this.discountPrefix;
        }

        public final String component4() {
            return this.discountSuffix;
        }

        public final String component5() {
            return this.totalDiscount;
        }

        public final UserInfo component6() {
            return this.relatedUpInfo;
        }

        public final String component7() {
            return this.popUpTitleSuffix;
        }

        public final String component8() {
            return this.popUpSubTitle;
        }

        public final CouponPackagePopInfoModel copy(String str, List<CouponInfoModel> list, String str2, String str3, String str4, UserInfo userInfo, String str5, String str6) {
            return new CouponPackagePopInfoModel(str, list, str2, str3, str4, userInfo, str5, str6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CouponPackagePopInfoModel) {
                CouponPackagePopInfoModel couponPackagePopInfoModel = (CouponPackagePopInfoModel) obj;
                return Intrinsics.areEqual(this.buttonText, couponPackagePopInfoModel.buttonText) && Intrinsics.areEqual(this.couponInfoList, couponPackagePopInfoModel.couponInfoList) && Intrinsics.areEqual(this.discountPrefix, couponPackagePopInfoModel.discountPrefix) && Intrinsics.areEqual(this.discountSuffix, couponPackagePopInfoModel.discountSuffix) && Intrinsics.areEqual(this.totalDiscount, couponPackagePopInfoModel.totalDiscount) && Intrinsics.areEqual(this.relatedUpInfo, couponPackagePopInfoModel.relatedUpInfo) && Intrinsics.areEqual(this.popUpTitleSuffix, couponPackagePopInfoModel.popUpTitleSuffix) && Intrinsics.areEqual(this.popUpSubTitle, couponPackagePopInfoModel.popUpSubTitle);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((this.buttonText == null ? 0 : this.buttonText.hashCode()) * 31) + (this.couponInfoList == null ? 0 : this.couponInfoList.hashCode())) * 31) + (this.discountPrefix == null ? 0 : this.discountPrefix.hashCode())) * 31) + (this.discountSuffix == null ? 0 : this.discountSuffix.hashCode())) * 31) + (this.totalDiscount == null ? 0 : this.totalDiscount.hashCode())) * 31) + (this.relatedUpInfo == null ? 0 : this.relatedUpInfo.hashCode())) * 31) + (this.popUpTitleSuffix == null ? 0 : this.popUpTitleSuffix.hashCode())) * 31) + (this.popUpSubTitle != null ? this.popUpSubTitle.hashCode() : 0);
        }

        public String toString() {
            String str = this.buttonText;
            List<CouponInfoModel> list = this.couponInfoList;
            String str2 = this.discountPrefix;
            String str3 = this.discountSuffix;
            String str4 = this.totalDiscount;
            UserInfo userInfo = this.relatedUpInfo;
            String str5 = this.popUpTitleSuffix;
            return "CouponPackagePopInfoModel(buttonText=" + str + ", couponInfoList=" + list + ", discountPrefix=" + str2 + ", discountSuffix=" + str3 + ", totalDiscount=" + str4 + ", relatedUpInfo=" + userInfo + ", popUpTitleSuffix=" + str5 + ", popUpSubTitle=" + this.popUpSubTitle + ")";
        }

        /* compiled from: FooterFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CouponPackagePopInfoModel> serializer() {
                return CouponPackageInfoModel$CouponPackagePopInfoModel$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ CouponPackagePopInfoModel(int seen0, String buttonText, List couponInfoList, String discountPrefix, String discountSuffix, String totalDiscount, UserInfo relatedUpInfo, String popUpTitleSuffix, String popUpSubTitle, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.buttonText = null;
            } else {
                this.buttonText = buttonText;
            }
            if ((seen0 & 2) == 0) {
                this.couponInfoList = null;
            } else {
                this.couponInfoList = couponInfoList;
            }
            if ((seen0 & 4) == 0) {
                this.discountPrefix = null;
            } else {
                this.discountPrefix = discountPrefix;
            }
            if ((seen0 & 8) == 0) {
                this.discountSuffix = null;
            } else {
                this.discountSuffix = discountSuffix;
            }
            if ((seen0 & 16) == 0) {
                this.totalDiscount = null;
            } else {
                this.totalDiscount = totalDiscount;
            }
            if ((seen0 & 32) == 0) {
                this.relatedUpInfo = null;
            } else {
                this.relatedUpInfo = relatedUpInfo;
            }
            if ((seen0 & 64) == 0) {
                this.popUpTitleSuffix = null;
            } else {
                this.popUpTitleSuffix = popUpTitleSuffix;
            }
            if ((seen0 & 128) == 0) {
                this.popUpSubTitle = null;
            } else {
                this.popUpSubTitle = popUpSubTitle;
            }
        }

        public CouponPackagePopInfoModel(String buttonText, List<CouponInfoModel> list, String discountPrefix, String discountSuffix, String totalDiscount, UserInfo relatedUpInfo, String popUpTitleSuffix, String popUpSubTitle) {
            this.buttonText = buttonText;
            this.couponInfoList = list;
            this.discountPrefix = discountPrefix;
            this.discountSuffix = discountSuffix;
            this.totalDiscount = totalDiscount;
            this.relatedUpInfo = relatedUpInfo;
            this.popUpTitleSuffix = popUpTitleSuffix;
            this.popUpSubTitle = popUpSubTitle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(CouponInfoModel$$serializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(CouponPackagePopInfoModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.buttonText != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.buttonText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.couponInfoList != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.couponInfoList);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.discountPrefix != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.discountPrefix);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.discountSuffix != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.discountSuffix);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.totalDiscount != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.totalDiscount);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.relatedUpInfo != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, CouponPackageInfoModel$CouponPackagePopInfoModel$UserInfo$$serializer.INSTANCE, self.relatedUpInfo);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.popUpTitleSuffix != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.popUpTitleSuffix);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.popUpSubTitle != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.popUpSubTitle);
            }
        }

        public /* synthetic */ CouponPackagePopInfoModel(String str, List list, String str2, String str3, String str4, UserInfo userInfo, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : userInfo, (i & 64) != 0 ? null : str5, (i & 128) == 0 ? str6 : null);
        }

        public final String getButtonText() {
            return this.buttonText;
        }

        public final List<CouponInfoModel> getCouponInfoList() {
            return this.couponInfoList;
        }

        public final String getDiscountPrefix() {
            return this.discountPrefix;
        }

        public final String getDiscountSuffix() {
            return this.discountSuffix;
        }

        public final String getTotalDiscount() {
            return this.totalDiscount;
        }

        public final UserInfo getRelatedUpInfo() {
            return this.relatedUpInfo;
        }

        public final String getPopUpTitleSuffix() {
            return this.popUpTitleSuffix;
        }

        /* compiled from: FooterFloor.kt */
        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006("}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel$UserInfo;", "", "avatar", "", "uname", "mid", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAvatar", "()Ljava/lang/String;", "getUname", "getMid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel$UserInfo;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class UserInfo {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String avatar;
            private final Long mid;
            private final String uname;

            public UserInfo() {
                this((String) null, (String) null, (Long) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, String str, String str2, Long l, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = userInfo.avatar;
                }
                if ((i & 2) != 0) {
                    str2 = userInfo.uname;
                }
                if ((i & 4) != 0) {
                    l = userInfo.mid;
                }
                return userInfo.copy(str, str2, l);
            }

            public final String component1() {
                return this.avatar;
            }

            public final String component2() {
                return this.uname;
            }

            public final Long component3() {
                return this.mid;
            }

            public final UserInfo copy(String str, String str2, Long l) {
                return new UserInfo(str, str2, l);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof UserInfo) {
                    UserInfo userInfo = (UserInfo) obj;
                    return Intrinsics.areEqual(this.avatar, userInfo.avatar) && Intrinsics.areEqual(this.uname, userInfo.uname) && Intrinsics.areEqual(this.mid, userInfo.mid);
                }
                return false;
            }

            public int hashCode() {
                return ((((this.avatar == null ? 0 : this.avatar.hashCode()) * 31) + (this.uname == null ? 0 : this.uname.hashCode())) * 31) + (this.mid != null ? this.mid.hashCode() : 0);
            }

            public String toString() {
                String str = this.avatar;
                String str2 = this.uname;
                return "UserInfo(avatar=" + str + ", uname=" + str2 + ", mid=" + this.mid + ")";
            }

            /* compiled from: FooterFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel$UserInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackagePopInfoModel$UserInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<UserInfo> serializer() {
                    return CouponPackageInfoModel$CouponPackagePopInfoModel$UserInfo$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ UserInfo(int seen0, String avatar, String uname, Long mid, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.avatar = null;
                } else {
                    this.avatar = avatar;
                }
                if ((seen0 & 2) == 0) {
                    this.uname = null;
                } else {
                    this.uname = uname;
                }
                if ((seen0 & 4) == 0) {
                    this.mid = null;
                } else {
                    this.mid = mid;
                }
            }

            public UserInfo(String avatar, String uname, Long mid) {
                this.avatar = avatar;
                this.uname = uname;
                this.mid = mid;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(UserInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.avatar != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.avatar);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.uname != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.uname);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.mid != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.mid);
                }
            }

            public /* synthetic */ UserInfo(String str, String str2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l);
            }

            public final String getAvatar() {
                return this.avatar;
            }

            public final String getUname() {
                return this.uname;
            }

            public final Long getMid() {
                return this.mid;
            }
        }

        public final String getPopUpSubTitle() {
            return this.popUpSubTitle;
        }
    }

    public final Byte getShowCouponType() {
        return this.showCouponType;
    }

    /* compiled from: FooterFloor.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u0002@AB\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0010\u0010\u0016J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00101\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010$J\u0092\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0013HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001J%\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0001¢\u0006\u0002\b?R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010%\u001a\u0004\b&\u0010$¨\u0006B"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackageBarInfoModel;", "", "bgImgUrl", "", "couponStatusText", "couponStatusTextPrefix", "couponStatusTextSuffix", "couponUnReceiveStatusTextPrefix", "icon", "leftTime", "", "maxDiscount", "maxDiscountPrefix", "showCountDown", "", "specialStyle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBgImgUrl", "()Ljava/lang/String;", "getCouponStatusText", "getCouponStatusTextPrefix", "getCouponStatusTextSuffix", "getCouponUnReceiveStatusTextPrefix", "getIcon", "getLeftTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMaxDiscount", "getMaxDiscountPrefix", "getShowCountDown", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSpecialStyle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackageBarInfoModel;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CouponPackageBarInfoModel {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String bgImgUrl;
        private final String couponStatusText;
        private final String couponStatusTextPrefix;
        private final String couponStatusTextSuffix;
        private final String couponUnReceiveStatusTextPrefix;
        private final String icon;
        private final Long leftTime;
        private final String maxDiscount;
        private final String maxDiscountPrefix;
        private final Boolean showCountDown;
        private final Boolean specialStyle;

        public CouponPackageBarInfoModel() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Long) null, (String) null, (String) null, (Boolean) null, (Boolean) null, 2047, (DefaultConstructorMarker) null);
        }

        public final String component1() {
            return this.bgImgUrl;
        }

        public final Boolean component10() {
            return this.showCountDown;
        }

        public final Boolean component11() {
            return this.specialStyle;
        }

        public final String component2() {
            return this.couponStatusText;
        }

        public final String component3() {
            return this.couponStatusTextPrefix;
        }

        public final String component4() {
            return this.couponStatusTextSuffix;
        }

        public final String component5() {
            return this.couponUnReceiveStatusTextPrefix;
        }

        public final String component6() {
            return this.icon;
        }

        public final Long component7() {
            return this.leftTime;
        }

        public final String component8() {
            return this.maxDiscount;
        }

        public final String component9() {
            return this.maxDiscountPrefix;
        }

        public final CouponPackageBarInfoModel copy(String str, String str2, String str3, String str4, String str5, String str6, Long l, String str7, String str8, Boolean bool, Boolean bool2) {
            return new CouponPackageBarInfoModel(str, str2, str3, str4, str5, str6, l, str7, str8, bool, bool2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CouponPackageBarInfoModel) {
                CouponPackageBarInfoModel couponPackageBarInfoModel = (CouponPackageBarInfoModel) obj;
                return Intrinsics.areEqual(this.bgImgUrl, couponPackageBarInfoModel.bgImgUrl) && Intrinsics.areEqual(this.couponStatusText, couponPackageBarInfoModel.couponStatusText) && Intrinsics.areEqual(this.couponStatusTextPrefix, couponPackageBarInfoModel.couponStatusTextPrefix) && Intrinsics.areEqual(this.couponStatusTextSuffix, couponPackageBarInfoModel.couponStatusTextSuffix) && Intrinsics.areEqual(this.couponUnReceiveStatusTextPrefix, couponPackageBarInfoModel.couponUnReceiveStatusTextPrefix) && Intrinsics.areEqual(this.icon, couponPackageBarInfoModel.icon) && Intrinsics.areEqual(this.leftTime, couponPackageBarInfoModel.leftTime) && Intrinsics.areEqual(this.maxDiscount, couponPackageBarInfoModel.maxDiscount) && Intrinsics.areEqual(this.maxDiscountPrefix, couponPackageBarInfoModel.maxDiscountPrefix) && Intrinsics.areEqual(this.showCountDown, couponPackageBarInfoModel.showCountDown) && Intrinsics.areEqual(this.specialStyle, couponPackageBarInfoModel.specialStyle);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode()) * 31) + (this.couponStatusText == null ? 0 : this.couponStatusText.hashCode())) * 31) + (this.couponStatusTextPrefix == null ? 0 : this.couponStatusTextPrefix.hashCode())) * 31) + (this.couponStatusTextSuffix == null ? 0 : this.couponStatusTextSuffix.hashCode())) * 31) + (this.couponUnReceiveStatusTextPrefix == null ? 0 : this.couponUnReceiveStatusTextPrefix.hashCode())) * 31) + (this.icon == null ? 0 : this.icon.hashCode())) * 31) + (this.leftTime == null ? 0 : this.leftTime.hashCode())) * 31) + (this.maxDiscount == null ? 0 : this.maxDiscount.hashCode())) * 31) + (this.maxDiscountPrefix == null ? 0 : this.maxDiscountPrefix.hashCode())) * 31) + (this.showCountDown == null ? 0 : this.showCountDown.hashCode())) * 31) + (this.specialStyle != null ? this.specialStyle.hashCode() : 0);
        }

        public String toString() {
            String str = this.bgImgUrl;
            String str2 = this.couponStatusText;
            String str3 = this.couponStatusTextPrefix;
            String str4 = this.couponStatusTextSuffix;
            String str5 = this.couponUnReceiveStatusTextPrefix;
            String str6 = this.icon;
            Long l = this.leftTime;
            String str7 = this.maxDiscount;
            String str8 = this.maxDiscountPrefix;
            Boolean bool = this.showCountDown;
            return "CouponPackageBarInfoModel(bgImgUrl=" + str + ", couponStatusText=" + str2 + ", couponStatusTextPrefix=" + str3 + ", couponStatusTextSuffix=" + str4 + ", couponUnReceiveStatusTextPrefix=" + str5 + ", icon=" + str6 + ", leftTime=" + l + ", maxDiscount=" + str7 + ", maxDiscountPrefix=" + str8 + ", showCountDown=" + bool + ", specialStyle=" + this.specialStyle + ")";
        }

        /* compiled from: FooterFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackageBarInfoModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CouponPackageInfoModel$CouponPackageBarInfoModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CouponPackageBarInfoModel> serializer() {
                return CouponPackageInfoModel$CouponPackageBarInfoModel$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ CouponPackageBarInfoModel(int seen0, String bgImgUrl, String couponStatusText, String couponStatusTextPrefix, String couponStatusTextSuffix, String couponUnReceiveStatusTextPrefix, String icon, Long leftTime, String maxDiscount, String maxDiscountPrefix, Boolean showCountDown, Boolean specialStyle, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.bgImgUrl = null;
            } else {
                this.bgImgUrl = bgImgUrl;
            }
            if ((seen0 & 2) == 0) {
                this.couponStatusText = null;
            } else {
                this.couponStatusText = couponStatusText;
            }
            if ((seen0 & 4) == 0) {
                this.couponStatusTextPrefix = null;
            } else {
                this.couponStatusTextPrefix = couponStatusTextPrefix;
            }
            if ((seen0 & 8) == 0) {
                this.couponStatusTextSuffix = null;
            } else {
                this.couponStatusTextSuffix = couponStatusTextSuffix;
            }
            if ((seen0 & 16) == 0) {
                this.couponUnReceiveStatusTextPrefix = null;
            } else {
                this.couponUnReceiveStatusTextPrefix = couponUnReceiveStatusTextPrefix;
            }
            if ((seen0 & 32) == 0) {
                this.icon = null;
            } else {
                this.icon = icon;
            }
            if ((seen0 & 64) == 0) {
                this.leftTime = null;
            } else {
                this.leftTime = leftTime;
            }
            if ((seen0 & 128) == 0) {
                this.maxDiscount = null;
            } else {
                this.maxDiscount = maxDiscount;
            }
            if ((seen0 & 256) == 0) {
                this.maxDiscountPrefix = null;
            } else {
                this.maxDiscountPrefix = maxDiscountPrefix;
            }
            if ((seen0 & 512) == 0) {
                this.showCountDown = null;
            } else {
                this.showCountDown = showCountDown;
            }
            if ((seen0 & 1024) == 0) {
                this.specialStyle = null;
            } else {
                this.specialStyle = specialStyle;
            }
        }

        public CouponPackageBarInfoModel(String bgImgUrl, String couponStatusText, String couponStatusTextPrefix, String couponStatusTextSuffix, String couponUnReceiveStatusTextPrefix, String icon, Long leftTime, String maxDiscount, String maxDiscountPrefix, Boolean showCountDown, Boolean specialStyle) {
            this.bgImgUrl = bgImgUrl;
            this.couponStatusText = couponStatusText;
            this.couponStatusTextPrefix = couponStatusTextPrefix;
            this.couponStatusTextSuffix = couponStatusTextSuffix;
            this.couponUnReceiveStatusTextPrefix = couponUnReceiveStatusTextPrefix;
            this.icon = icon;
            this.leftTime = leftTime;
            this.maxDiscount = maxDiscount;
            this.maxDiscountPrefix = maxDiscountPrefix;
            this.showCountDown = showCountDown;
            this.specialStyle = specialStyle;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(CouponPackageBarInfoModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.bgImgUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.bgImgUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.couponStatusText != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.couponStatusText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.couponStatusTextPrefix != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.couponStatusTextPrefix);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.couponStatusTextSuffix != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.couponStatusTextSuffix);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.couponUnReceiveStatusTextPrefix != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.couponUnReceiveStatusTextPrefix);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.icon != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.icon);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.leftTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, LongSerializer.INSTANCE, self.leftTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.maxDiscount != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.maxDiscount);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.maxDiscountPrefix != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.maxDiscountPrefix);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.showCountDown != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, BooleanSerializer.INSTANCE, self.showCountDown);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.specialStyle != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, BooleanSerializer.INSTANCE, self.specialStyle);
            }
        }

        public /* synthetic */ CouponPackageBarInfoModel(String str, String str2, String str3, String str4, String str5, String str6, Long l, String str7, String str8, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : l, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : bool, (i & 1024) == 0 ? bool2 : null);
        }

        public final String getBgImgUrl() {
            return this.bgImgUrl;
        }

        public final String getCouponStatusText() {
            return this.couponStatusText;
        }

        public final String getCouponStatusTextPrefix() {
            return this.couponStatusTextPrefix;
        }

        public final String getCouponStatusTextSuffix() {
            return this.couponStatusTextSuffix;
        }

        public final String getCouponUnReceiveStatusTextPrefix() {
            return this.couponUnReceiveStatusTextPrefix;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final Long getLeftTime() {
            return this.leftTime;
        }

        public final String getMaxDiscount() {
            return this.maxDiscount;
        }

        public final String getMaxDiscountPrefix() {
            return this.maxDiscountPrefix;
        }

        public final Boolean getShowCountDown() {
            return this.showCountDown;
        }

        public final Boolean getSpecialStyle() {
            return this.specialStyle;
        }
    }
}