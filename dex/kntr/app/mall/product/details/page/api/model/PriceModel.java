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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AtmospherePriceFloor.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0002CDB£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012B\u009d\u0001\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0016J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jª\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\bHÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001J%\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0001¢\u0006\u0002\bBR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018¨\u0006E"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/PriceModel;", "", "firstPrice", "", "firstPricePrefix", "firstPriceSuffix", "firstPriceSymbol", "firstPriceType", "", "netPrice", "netPricePrefix", "netPriceSuffix", "netPriceSymbol", "price", "pricePrefix", "priceSuffix", "priceSymbol", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFirstPrice", "()Ljava/lang/String;", "getFirstPricePrefix", "getFirstPriceSuffix", "getFirstPriceSymbol", "getFirstPriceType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNetPrice", "getNetPricePrefix", "getNetPriceSuffix", "getNetPriceSymbol", "getPrice", "getPricePrefix", "getPriceSuffix", "getPriceSymbol", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/PriceModel;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class PriceModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String firstPrice;
    private final String firstPricePrefix;
    private final String firstPriceSuffix;
    private final String firstPriceSymbol;
    private final Integer firstPriceType;
    private final String netPrice;
    private final String netPricePrefix;
    private final String netPriceSuffix;
    private final String netPriceSymbol;
    private final String price;
    private final String pricePrefix;
    private final String priceSuffix;
    private final String priceSymbol;

    public PriceModel() {
        this((String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 8191, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.firstPrice;
    }

    public final String component10() {
        return this.price;
    }

    public final String component11() {
        return this.pricePrefix;
    }

    public final String component12() {
        return this.priceSuffix;
    }

    public final String component13() {
        return this.priceSymbol;
    }

    public final String component2() {
        return this.firstPricePrefix;
    }

    public final String component3() {
        return this.firstPriceSuffix;
    }

    public final String component4() {
        return this.firstPriceSymbol;
    }

    public final Integer component5() {
        return this.firstPriceType;
    }

    public final String component6() {
        return this.netPrice;
    }

    public final String component7() {
        return this.netPricePrefix;
    }

    public final String component8() {
        return this.netPriceSuffix;
    }

    public final String component9() {
        return this.netPriceSymbol;
    }

    public final PriceModel copy(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        return new PriceModel(str, str2, str3, str4, num, str5, str6, str7, str8, str9, str10, str11, str12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PriceModel) {
            PriceModel priceModel = (PriceModel) obj;
            return Intrinsics.areEqual(this.firstPrice, priceModel.firstPrice) && Intrinsics.areEqual(this.firstPricePrefix, priceModel.firstPricePrefix) && Intrinsics.areEqual(this.firstPriceSuffix, priceModel.firstPriceSuffix) && Intrinsics.areEqual(this.firstPriceSymbol, priceModel.firstPriceSymbol) && Intrinsics.areEqual(this.firstPriceType, priceModel.firstPriceType) && Intrinsics.areEqual(this.netPrice, priceModel.netPrice) && Intrinsics.areEqual(this.netPricePrefix, priceModel.netPricePrefix) && Intrinsics.areEqual(this.netPriceSuffix, priceModel.netPriceSuffix) && Intrinsics.areEqual(this.netPriceSymbol, priceModel.netPriceSymbol) && Intrinsics.areEqual(this.price, priceModel.price) && Intrinsics.areEqual(this.pricePrefix, priceModel.pricePrefix) && Intrinsics.areEqual(this.priceSuffix, priceModel.priceSuffix) && Intrinsics.areEqual(this.priceSymbol, priceModel.priceSymbol);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((this.firstPrice == null ? 0 : this.firstPrice.hashCode()) * 31) + (this.firstPricePrefix == null ? 0 : this.firstPricePrefix.hashCode())) * 31) + (this.firstPriceSuffix == null ? 0 : this.firstPriceSuffix.hashCode())) * 31) + (this.firstPriceSymbol == null ? 0 : this.firstPriceSymbol.hashCode())) * 31) + (this.firstPriceType == null ? 0 : this.firstPriceType.hashCode())) * 31) + (this.netPrice == null ? 0 : this.netPrice.hashCode())) * 31) + (this.netPricePrefix == null ? 0 : this.netPricePrefix.hashCode())) * 31) + (this.netPriceSuffix == null ? 0 : this.netPriceSuffix.hashCode())) * 31) + (this.netPriceSymbol == null ? 0 : this.netPriceSymbol.hashCode())) * 31) + (this.price == null ? 0 : this.price.hashCode())) * 31) + (this.pricePrefix == null ? 0 : this.pricePrefix.hashCode())) * 31) + (this.priceSuffix == null ? 0 : this.priceSuffix.hashCode())) * 31) + (this.priceSymbol != null ? this.priceSymbol.hashCode() : 0);
    }

    public String toString() {
        String str = this.firstPrice;
        String str2 = this.firstPricePrefix;
        String str3 = this.firstPriceSuffix;
        String str4 = this.firstPriceSymbol;
        Integer num = this.firstPriceType;
        String str5 = this.netPrice;
        String str6 = this.netPricePrefix;
        String str7 = this.netPriceSuffix;
        String str8 = this.netPriceSymbol;
        String str9 = this.price;
        String str10 = this.pricePrefix;
        String str11 = this.priceSuffix;
        return "PriceModel(firstPrice=" + str + ", firstPricePrefix=" + str2 + ", firstPriceSuffix=" + str3 + ", firstPriceSymbol=" + str4 + ", firstPriceType=" + num + ", netPrice=" + str5 + ", netPricePrefix=" + str6 + ", netPriceSuffix=" + str7 + ", netPriceSymbol=" + str8 + ", price=" + str9 + ", pricePrefix=" + str10 + ", priceSuffix=" + str11 + ", priceSymbol=" + this.priceSymbol + ")";
    }

    /* compiled from: AtmospherePriceFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/PriceModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/PriceModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PriceModel> serializer() {
            return PriceModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PriceModel(int seen0, String firstPrice, String firstPricePrefix, String firstPriceSuffix, String firstPriceSymbol, Integer firstPriceType, String netPrice, String netPricePrefix, String netPriceSuffix, String netPriceSymbol, String price, String pricePrefix, String priceSuffix, String priceSymbol, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.firstPrice = null;
        } else {
            this.firstPrice = firstPrice;
        }
        if ((seen0 & 2) == 0) {
            this.firstPricePrefix = null;
        } else {
            this.firstPricePrefix = firstPricePrefix;
        }
        if ((seen0 & 4) == 0) {
            this.firstPriceSuffix = null;
        } else {
            this.firstPriceSuffix = firstPriceSuffix;
        }
        if ((seen0 & 8) == 0) {
            this.firstPriceSymbol = null;
        } else {
            this.firstPriceSymbol = firstPriceSymbol;
        }
        if ((seen0 & 16) == 0) {
            this.firstPriceType = null;
        } else {
            this.firstPriceType = firstPriceType;
        }
        if ((seen0 & 32) == 0) {
            this.netPrice = null;
        } else {
            this.netPrice = netPrice;
        }
        if ((seen0 & 64) == 0) {
            this.netPricePrefix = null;
        } else {
            this.netPricePrefix = netPricePrefix;
        }
        if ((seen0 & 128) == 0) {
            this.netPriceSuffix = null;
        } else {
            this.netPriceSuffix = netPriceSuffix;
        }
        if ((seen0 & 256) == 0) {
            this.netPriceSymbol = null;
        } else {
            this.netPriceSymbol = netPriceSymbol;
        }
        if ((seen0 & 512) == 0) {
            this.price = null;
        } else {
            this.price = price;
        }
        if ((seen0 & 1024) == 0) {
            this.pricePrefix = null;
        } else {
            this.pricePrefix = pricePrefix;
        }
        if ((seen0 & 2048) == 0) {
            this.priceSuffix = null;
        } else {
            this.priceSuffix = priceSuffix;
        }
        if ((seen0 & 4096) == 0) {
            this.priceSymbol = null;
        } else {
            this.priceSymbol = priceSymbol;
        }
    }

    public PriceModel(String firstPrice, String firstPricePrefix, String firstPriceSuffix, String firstPriceSymbol, Integer firstPriceType, String netPrice, String netPricePrefix, String netPriceSuffix, String netPriceSymbol, String price, String pricePrefix, String priceSuffix, String priceSymbol) {
        this.firstPrice = firstPrice;
        this.firstPricePrefix = firstPricePrefix;
        this.firstPriceSuffix = firstPriceSuffix;
        this.firstPriceSymbol = firstPriceSymbol;
        this.firstPriceType = firstPriceType;
        this.netPrice = netPrice;
        this.netPricePrefix = netPricePrefix;
        this.netPriceSuffix = netPriceSuffix;
        this.netPriceSymbol = netPriceSymbol;
        this.price = price;
        this.pricePrefix = pricePrefix;
        this.priceSuffix = priceSuffix;
        this.priceSymbol = priceSymbol;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(PriceModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.firstPrice != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.firstPrice);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.firstPricePrefix != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.firstPricePrefix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.firstPriceSuffix != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.firstPriceSuffix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.firstPriceSymbol != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.firstPriceSymbol);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.firstPriceType != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.firstPriceType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.netPrice != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.netPrice);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.netPricePrefix != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.netPricePrefix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.netPriceSuffix != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.netPriceSuffix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.netPriceSymbol != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.netPriceSymbol);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.price != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.price);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.pricePrefix != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.pricePrefix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.priceSuffix != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.priceSuffix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.priceSymbol != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.priceSymbol);
        }
    }

    public /* synthetic */ PriceModel(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : str11, (i & 4096) == 0 ? str12 : null);
    }

    public final String getFirstPrice() {
        return this.firstPrice;
    }

    public final String getFirstPricePrefix() {
        return this.firstPricePrefix;
    }

    public final String getFirstPriceSuffix() {
        return this.firstPriceSuffix;
    }

    public final String getFirstPriceSymbol() {
        return this.firstPriceSymbol;
    }

    public final Integer getFirstPriceType() {
        return this.firstPriceType;
    }

    public final String getNetPrice() {
        return this.netPrice;
    }

    public final String getNetPricePrefix() {
        return this.netPricePrefix;
    }

    public final String getNetPriceSuffix() {
        return this.netPriceSuffix;
    }

    public final String getNetPriceSymbol() {
        return this.netPriceSymbol;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getPricePrefix() {
        return this.pricePrefix;
    }

    public final String getPriceSuffix() {
        return this.priceSuffix;
    }

    public final String getPriceSymbol() {
        return this.priceSymbol;
    }
}