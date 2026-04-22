package kntr.app.mall.product.details.page.api.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: MerchantInfo.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0002=>Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fBk\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010,\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0005HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0013\u0010\"\u001a\u0004\u0018\u00010#8F¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006?"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MerchantInfo;", "", "jumpUrl", "", "merchantId", "", "merchantName", "merchantShopFace", "merchantShopName", "mid", "", "positiveRatioElement", "Lkotlinx/serialization/json/JsonElement;", "shopTypeDesc", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getJumpUrl", "()Ljava/lang/String;", "getMerchantId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMerchantName", "getMerchantShopFace", "getMerchantShopName", "getMid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPositiveRatioElement", "()Lkotlinx/serialization/json/JsonElement;", "getShopTypeDesc", "positiveRatio", "", "getPositiveRatio", "()Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/MerchantInfo;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class MerchantInfo {
    private final String jumpUrl;
    private final Integer merchantId;
    private final String merchantName;
    private final String merchantShopFace;
    private final String merchantShopName;
    private final Long mid;
    private final JsonElement positiveRatioElement;
    private final String shopTypeDesc;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public MerchantInfo() {
        this((String) null, (Integer) null, (String) null, (String) null, (String) null, (Long) null, (JsonElement) null, (String) null, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.jumpUrl;
    }

    public final Integer component2() {
        return this.merchantId;
    }

    public final String component3() {
        return this.merchantName;
    }

    public final String component4() {
        return this.merchantShopFace;
    }

    public final String component5() {
        return this.merchantShopName;
    }

    public final Long component6() {
        return this.mid;
    }

    public final JsonElement component7() {
        return this.positiveRatioElement;
    }

    public final String component8() {
        return this.shopTypeDesc;
    }

    public final MerchantInfo copy(String str, Integer num, String str2, String str3, String str4, Long l, JsonElement jsonElement, String str5) {
        return new MerchantInfo(str, num, str2, str3, str4, l, jsonElement, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MerchantInfo) {
            MerchantInfo merchantInfo = (MerchantInfo) obj;
            return Intrinsics.areEqual(this.jumpUrl, merchantInfo.jumpUrl) && Intrinsics.areEqual(this.merchantId, merchantInfo.merchantId) && Intrinsics.areEqual(this.merchantName, merchantInfo.merchantName) && Intrinsics.areEqual(this.merchantShopFace, merchantInfo.merchantShopFace) && Intrinsics.areEqual(this.merchantShopName, merchantInfo.merchantShopName) && Intrinsics.areEqual(this.mid, merchantInfo.mid) && Intrinsics.areEqual(this.positiveRatioElement, merchantInfo.positiveRatioElement) && Intrinsics.areEqual(this.shopTypeDesc, merchantInfo.shopTypeDesc);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((this.jumpUrl == null ? 0 : this.jumpUrl.hashCode()) * 31) + (this.merchantId == null ? 0 : this.merchantId.hashCode())) * 31) + (this.merchantName == null ? 0 : this.merchantName.hashCode())) * 31) + (this.merchantShopFace == null ? 0 : this.merchantShopFace.hashCode())) * 31) + (this.merchantShopName == null ? 0 : this.merchantShopName.hashCode())) * 31) + (this.mid == null ? 0 : this.mid.hashCode())) * 31) + (this.positiveRatioElement == null ? 0 : this.positiveRatioElement.hashCode())) * 31) + (this.shopTypeDesc != null ? this.shopTypeDesc.hashCode() : 0);
    }

    public String toString() {
        String str = this.jumpUrl;
        Integer num = this.merchantId;
        String str2 = this.merchantName;
        String str3 = this.merchantShopFace;
        String str4 = this.merchantShopName;
        Long l = this.mid;
        JsonElement jsonElement = this.positiveRatioElement;
        return "MerchantInfo(jumpUrl=" + str + ", merchantId=" + num + ", merchantName=" + str2 + ", merchantShopFace=" + str3 + ", merchantShopName=" + str4 + ", mid=" + l + ", positiveRatioElement=" + jsonElement + ", shopTypeDesc=" + this.shopTypeDesc + ")";
    }

    /* compiled from: MerchantInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MerchantInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/MerchantInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MerchantInfo> serializer() {
            return MerchantInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ MerchantInfo(int seen0, String jumpUrl, Integer merchantId, String merchantName, String merchantShopFace, String merchantShopName, Long mid, JsonElement positiveRatioElement, String shopTypeDesc, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.jumpUrl = null;
        } else {
            this.jumpUrl = jumpUrl;
        }
        if ((seen0 & 2) == 0) {
            this.merchantId = null;
        } else {
            this.merchantId = merchantId;
        }
        if ((seen0 & 4) == 0) {
            this.merchantName = null;
        } else {
            this.merchantName = merchantName;
        }
        if ((seen0 & 8) == 0) {
            this.merchantShopFace = null;
        } else {
            this.merchantShopFace = merchantShopFace;
        }
        if ((seen0 & 16) == 0) {
            this.merchantShopName = null;
        } else {
            this.merchantShopName = merchantShopName;
        }
        if ((seen0 & 32) == 0) {
            this.mid = null;
        } else {
            this.mid = mid;
        }
        if ((seen0 & 64) == 0) {
            this.positiveRatioElement = null;
        } else {
            this.positiveRatioElement = positiveRatioElement;
        }
        if ((seen0 & 128) == 0) {
            this.shopTypeDesc = null;
        } else {
            this.shopTypeDesc = shopTypeDesc;
        }
    }

    public MerchantInfo(String jumpUrl, Integer merchantId, String merchantName, String merchantShopFace, String merchantShopName, Long mid, JsonElement positiveRatioElement, String shopTypeDesc) {
        this.jumpUrl = jumpUrl;
        this.merchantId = merchantId;
        this.merchantName = merchantName;
        this.merchantShopFace = merchantShopFace;
        this.merchantShopName = merchantShopName;
        this.mid = mid;
        this.positiveRatioElement = positiveRatioElement;
        this.shopTypeDesc = shopTypeDesc;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(MerchantInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.jumpUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.jumpUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.merchantId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.merchantId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.merchantName != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.merchantName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.merchantShopFace != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.merchantShopFace);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.merchantShopName != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.merchantShopName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.mid != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, LongSerializer.INSTANCE, self.mid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.positiveRatioElement != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, JsonElementSerializer.INSTANCE, self.positiveRatioElement);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.shopTypeDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.shopTypeDesc);
        }
    }

    public /* synthetic */ MerchantInfo(String str, Integer num, String str2, String str3, String str4, Long l, JsonElement jsonElement, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : l, (i & 64) != 0 ? null : jsonElement, (i & 128) == 0 ? str5 : null);
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final Integer getMerchantId() {
        return this.merchantId;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public final String getMerchantShopFace() {
        return this.merchantShopFace;
    }

    public final String getMerchantShopName() {
        return this.merchantShopName;
    }

    public final Long getMid() {
        return this.mid;
    }

    public final JsonElement getPositiveRatioElement() {
        return this.positiveRatioElement;
    }

    public final String getShopTypeDesc() {
        return this.shopTypeDesc;
    }

    public final Double getPositiveRatio() {
        if (this.positiveRatioElement instanceof JsonPrimitive) {
            if (this.positiveRatioElement.isString()) {
                return StringsKt.toDoubleOrNull(this.positiveRatioElement.getContent());
            }
            if (JsonElementKt.getDoubleOrNull(this.positiveRatioElement) != null) {
                return Double.valueOf(JsonElementKt.getDouble(this.positiveRatioElement));
            }
            return null;
        }
        return null;
    }
}