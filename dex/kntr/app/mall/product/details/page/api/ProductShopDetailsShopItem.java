package kntr.app.mall.product.details.page.api;

import kntr.app.mall.product.details.page.api.model.PriceModel;
import kntr.app.mall.product.details.page.api.model.PriceModel$$serializer;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ProductShopApiService.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 72\u00020\u0001:\u000267B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eBa\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003Jb\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\t\u0010-\u001a\u00020\bHÖ\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001b¨\u00068"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsShopItem;", "", "itemsId", "", "itemsType", "", "saleType", "name", "", "netPriceInfo", "Lkntr/app/mall/product/details/page/api/model/PriceModel;", "itemsImg", "jumpUrl", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/PriceModel;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/PriceModel;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getItemsId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getItemsType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSaleType", "getName", "()Ljava/lang/String;", "getNetPriceInfo", "()Lkntr/app/mall/product/details/page/api/model/PriceModel;", "getItemsImg", "getJumpUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/PriceModel;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/ProductShopDetailsShopItem;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ProductShopDetailsShopItem {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Long itemsId;
    private final String itemsImg;
    private final Integer itemsType;
    private final String jumpUrl;
    private final String name;
    private final PriceModel netPriceInfo;
    private final Integer saleType;

    public ProductShopDetailsShopItem() {
        this((Long) null, (Integer) null, (Integer) null, (String) null, (PriceModel) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ProductShopDetailsShopItem copy$default(ProductShopDetailsShopItem productShopDetailsShopItem, Long l, Integer num, Integer num2, String str, PriceModel priceModel, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            l = productShopDetailsShopItem.itemsId;
        }
        if ((i & 2) != 0) {
            num = productShopDetailsShopItem.itemsType;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            num2 = productShopDetailsShopItem.saleType;
        }
        Integer num4 = num2;
        if ((i & 8) != 0) {
            str = productShopDetailsShopItem.name;
        }
        String str4 = str;
        if ((i & 16) != 0) {
            priceModel = productShopDetailsShopItem.netPriceInfo;
        }
        PriceModel priceModel2 = priceModel;
        if ((i & 32) != 0) {
            str2 = productShopDetailsShopItem.itemsImg;
        }
        String str5 = str2;
        if ((i & 64) != 0) {
            str3 = productShopDetailsShopItem.jumpUrl;
        }
        return productShopDetailsShopItem.copy(l, num3, num4, str4, priceModel2, str5, str3);
    }

    public final Long component1() {
        return this.itemsId;
    }

    public final Integer component2() {
        return this.itemsType;
    }

    public final Integer component3() {
        return this.saleType;
    }

    public final String component4() {
        return this.name;
    }

    public final PriceModel component5() {
        return this.netPriceInfo;
    }

    public final String component6() {
        return this.itemsImg;
    }

    public final String component7() {
        return this.jumpUrl;
    }

    public final ProductShopDetailsShopItem copy(Long l, Integer num, Integer num2, String str, PriceModel priceModel, String str2, String str3) {
        return new ProductShopDetailsShopItem(l, num, num2, str, priceModel, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProductShopDetailsShopItem) {
            ProductShopDetailsShopItem productShopDetailsShopItem = (ProductShopDetailsShopItem) obj;
            return Intrinsics.areEqual(this.itemsId, productShopDetailsShopItem.itemsId) && Intrinsics.areEqual(this.itemsType, productShopDetailsShopItem.itemsType) && Intrinsics.areEqual(this.saleType, productShopDetailsShopItem.saleType) && Intrinsics.areEqual(this.name, productShopDetailsShopItem.name) && Intrinsics.areEqual(this.netPriceInfo, productShopDetailsShopItem.netPriceInfo) && Intrinsics.areEqual(this.itemsImg, productShopDetailsShopItem.itemsImg) && Intrinsics.areEqual(this.jumpUrl, productShopDetailsShopItem.jumpUrl);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((this.itemsId == null ? 0 : this.itemsId.hashCode()) * 31) + (this.itemsType == null ? 0 : this.itemsType.hashCode())) * 31) + (this.saleType == null ? 0 : this.saleType.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.netPriceInfo == null ? 0 : this.netPriceInfo.hashCode())) * 31) + (this.itemsImg == null ? 0 : this.itemsImg.hashCode())) * 31) + (this.jumpUrl != null ? this.jumpUrl.hashCode() : 0);
    }

    public String toString() {
        Long l = this.itemsId;
        Integer num = this.itemsType;
        Integer num2 = this.saleType;
        String str = this.name;
        PriceModel priceModel = this.netPriceInfo;
        String str2 = this.itemsImg;
        return "ProductShopDetailsShopItem(itemsId=" + l + ", itemsType=" + num + ", saleType=" + num2 + ", name=" + str + ", netPriceInfo=" + priceModel + ", itemsImg=" + str2 + ", jumpUrl=" + this.jumpUrl + ")";
    }

    /* compiled from: ProductShopApiService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/ProductShopDetailsShopItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsShopItem;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ProductShopDetailsShopItem> serializer() {
            return ProductShopDetailsShopItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ProductShopDetailsShopItem(int seen0, Long itemsId, Integer itemsType, Integer saleType, String name, PriceModel netPriceInfo, String itemsImg, String jumpUrl, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.itemsId = null;
        } else {
            this.itemsId = itemsId;
        }
        if ((seen0 & 2) == 0) {
            this.itemsType = null;
        } else {
            this.itemsType = itemsType;
        }
        if ((seen0 & 4) == 0) {
            this.saleType = null;
        } else {
            this.saleType = saleType;
        }
        if ((seen0 & 8) == 0) {
            this.name = null;
        } else {
            this.name = name;
        }
        if ((seen0 & 16) == 0) {
            this.netPriceInfo = null;
        } else {
            this.netPriceInfo = netPriceInfo;
        }
        if ((seen0 & 32) == 0) {
            this.itemsImg = null;
        } else {
            this.itemsImg = itemsImg;
        }
        if ((seen0 & 64) == 0) {
            this.jumpUrl = null;
        } else {
            this.jumpUrl = jumpUrl;
        }
    }

    public ProductShopDetailsShopItem(Long itemsId, Integer itemsType, Integer saleType, String name, PriceModel netPriceInfo, String itemsImg, String jumpUrl) {
        this.itemsId = itemsId;
        this.itemsType = itemsType;
        this.saleType = saleType;
        this.name = name;
        this.netPriceInfo = netPriceInfo;
        this.itemsImg = itemsImg;
        this.jumpUrl = jumpUrl;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(ProductShopDetailsShopItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.itemsId != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.itemsId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.itemsType != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.itemsType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.saleType != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.saleType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.netPriceInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, PriceModel$$serializer.INSTANCE, self.netPriceInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.itemsImg != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.itemsImg);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.jumpUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.jumpUrl);
        }
    }

    public /* synthetic */ ProductShopDetailsShopItem(Long l, Integer num, Integer num2, String str, PriceModel priceModel, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : priceModel, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : str3);
    }

    public final Long getItemsId() {
        return this.itemsId;
    }

    public final Integer getItemsType() {
        return this.itemsType;
    }

    public final Integer getSaleType() {
        return this.saleType;
    }

    public final String getName() {
        return this.name;
    }

    public final PriceModel getNetPriceInfo() {
        return this.netPriceInfo;
    }

    public final String getItemsImg() {
        return this.itemsImg;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }
}