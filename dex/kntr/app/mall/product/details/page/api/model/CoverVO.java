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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ShopInfoFloor.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bBW\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012JV\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\rHÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012¨\u00061"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CoverVO;", "", "height", "", "imgWH", "", "rawMainImg", "size", "url", "width", "<init>", "(Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getImgWH", "()Ljava/lang/String;", "getRawMainImg", "getSize", "getUrl", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;)Lkntr/app/mall/product/details/page/api/model/CoverVO;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class CoverVO {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Double height;
    private final String imgWH;
    private final String rawMainImg;
    private final Double size;
    private final String url;
    private final Double width;

    public CoverVO() {
        this((Double) null, (String) null, (String) null, (Double) null, (String) null, (Double) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CoverVO copy$default(CoverVO coverVO, Double d, String str, String str2, Double d2, String str3, Double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            d = coverVO.height;
        }
        if ((i & 2) != 0) {
            str = coverVO.imgWH;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = coverVO.rawMainImg;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            d2 = coverVO.size;
        }
        Double d4 = d2;
        if ((i & 16) != 0) {
            str3 = coverVO.url;
        }
        String str6 = str3;
        if ((i & 32) != 0) {
            d3 = coverVO.width;
        }
        return coverVO.copy(d, str4, str5, d4, str6, d3);
    }

    public final Double component1() {
        return this.height;
    }

    public final String component2() {
        return this.imgWH;
    }

    public final String component3() {
        return this.rawMainImg;
    }

    public final Double component4() {
        return this.size;
    }

    public final String component5() {
        return this.url;
    }

    public final Double component6() {
        return this.width;
    }

    public final CoverVO copy(Double d, String str, String str2, Double d2, String str3, Double d3) {
        return new CoverVO(d, str, str2, d2, str3, d3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CoverVO) {
            CoverVO coverVO = (CoverVO) obj;
            return Intrinsics.areEqual(this.height, coverVO.height) && Intrinsics.areEqual(this.imgWH, coverVO.imgWH) && Intrinsics.areEqual(this.rawMainImg, coverVO.rawMainImg) && Intrinsics.areEqual(this.size, coverVO.size) && Intrinsics.areEqual(this.url, coverVO.url) && Intrinsics.areEqual(this.width, coverVO.width);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.height == null ? 0 : this.height.hashCode()) * 31) + (this.imgWH == null ? 0 : this.imgWH.hashCode())) * 31) + (this.rawMainImg == null ? 0 : this.rawMainImg.hashCode())) * 31) + (this.size == null ? 0 : this.size.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.width != null ? this.width.hashCode() : 0);
    }

    public String toString() {
        Double d = this.height;
        String str = this.imgWH;
        String str2 = this.rawMainImg;
        Double d2 = this.size;
        String str3 = this.url;
        return "CoverVO(height=" + d + ", imgWH=" + str + ", rawMainImg=" + str2 + ", size=" + d2 + ", url=" + str3 + ", width=" + this.width + ")";
    }

    /* compiled from: ShopInfoFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CoverVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CoverVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CoverVO> serializer() {
            return CoverVO$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CoverVO(int seen0, Double height, String imgWH, String rawMainImg, Double size, String url, Double width, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.height = null;
        } else {
            this.height = height;
        }
        if ((seen0 & 2) == 0) {
            this.imgWH = null;
        } else {
            this.imgWH = imgWH;
        }
        if ((seen0 & 4) == 0) {
            this.rawMainImg = null;
        } else {
            this.rawMainImg = rawMainImg;
        }
        if ((seen0 & 8) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((seen0 & 16) == 0) {
            this.url = null;
        } else {
            this.url = url;
        }
        if ((seen0 & 32) == 0) {
            this.width = null;
        } else {
            this.width = width;
        }
    }

    public CoverVO(Double height, String imgWH, String rawMainImg, Double size, String url, Double width) {
        this.height = height;
        this.imgWH = imgWH;
        this.rawMainImg = rawMainImg;
        this.size = size;
        this.url = url;
        this.width = width;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(CoverVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.height != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, DoubleSerializer.INSTANCE, self.height);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.imgWH != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.imgWH);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.rawMainImg != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.rawMainImg);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.size != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, DoubleSerializer.INSTANCE, self.size);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.width != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, DoubleSerializer.INSTANCE, self.width);
        }
    }

    public /* synthetic */ CoverVO(Double d, String str, String str2, Double d2, String str3, Double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : d2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : d3);
    }

    public final Double getHeight() {
        return this.height;
    }

    public final String getImgWH() {
        return this.imgWH;
    }

    public final String getRawMainImg() {
        return this.rawMainImg;
    }

    public final Double getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Double getWidth() {
        return this.width;
    }
}