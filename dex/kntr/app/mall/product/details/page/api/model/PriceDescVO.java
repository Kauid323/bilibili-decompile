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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: MergeAtmospherePriceFloor.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0003;<=Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010Bu\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jz\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u000bHÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001J%\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\b:R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b!\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006>"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/PriceDescVO;", "", "canClick", "", "priceDecimalPart", "", "priceIntegerPart", "pricePrefix", "priceSuffix", "priceSymbol", "priceType", "", "strikePrice", "styleVO", "Lkntr/app/mall/product/details/page/api/model/PriceDescVO$StyleVO;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/PriceDescVO$StyleVO;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/PriceDescVO$StyleVO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCanClick", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPriceDecimalPart", "()Ljava/lang/String;", "getPriceIntegerPart", "getPricePrefix", "getPriceSuffix", "getPriceSymbol", "getPriceType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStrikePrice", "getStyleVO", "()Lkntr/app/mall/product/details/page/api/model/PriceDescVO$StyleVO;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/PriceDescVO$StyleVO;)Lkntr/app/mall/product/details/page/api/model/PriceDescVO;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "StyleVO", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class PriceDescVO {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final Boolean canClick;
    private final String priceDecimalPart;
    private final String priceIntegerPart;
    private final String pricePrefix;
    private final String priceSuffix;
    private final String priceSymbol;
    private final Integer priceType;
    private final Boolean strikePrice;
    private final StyleVO styleVO;

    public PriceDescVO() {
        this((Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Boolean) null, (StyleVO) null, 511, (DefaultConstructorMarker) null);
    }

    public final Boolean component1() {
        return this.canClick;
    }

    public final String component2() {
        return this.priceDecimalPart;
    }

    public final String component3() {
        return this.priceIntegerPart;
    }

    public final String component4() {
        return this.pricePrefix;
    }

    public final String component5() {
        return this.priceSuffix;
    }

    public final String component6() {
        return this.priceSymbol;
    }

    public final Integer component7() {
        return this.priceType;
    }

    public final Boolean component8() {
        return this.strikePrice;
    }

    public final StyleVO component9() {
        return this.styleVO;
    }

    public final PriceDescVO copy(Boolean bool, String str, String str2, String str3, String str4, String str5, Integer num, Boolean bool2, StyleVO styleVO) {
        return new PriceDescVO(bool, str, str2, str3, str4, str5, num, bool2, styleVO);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PriceDescVO) {
            PriceDescVO priceDescVO = (PriceDescVO) obj;
            return Intrinsics.areEqual(this.canClick, priceDescVO.canClick) && Intrinsics.areEqual(this.priceDecimalPart, priceDescVO.priceDecimalPart) && Intrinsics.areEqual(this.priceIntegerPart, priceDescVO.priceIntegerPart) && Intrinsics.areEqual(this.pricePrefix, priceDescVO.pricePrefix) && Intrinsics.areEqual(this.priceSuffix, priceDescVO.priceSuffix) && Intrinsics.areEqual(this.priceSymbol, priceDescVO.priceSymbol) && Intrinsics.areEqual(this.priceType, priceDescVO.priceType) && Intrinsics.areEqual(this.strikePrice, priceDescVO.strikePrice) && Intrinsics.areEqual(this.styleVO, priceDescVO.styleVO);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((this.canClick == null ? 0 : this.canClick.hashCode()) * 31) + (this.priceDecimalPart == null ? 0 : this.priceDecimalPart.hashCode())) * 31) + (this.priceIntegerPart == null ? 0 : this.priceIntegerPart.hashCode())) * 31) + (this.pricePrefix == null ? 0 : this.pricePrefix.hashCode())) * 31) + (this.priceSuffix == null ? 0 : this.priceSuffix.hashCode())) * 31) + (this.priceSymbol == null ? 0 : this.priceSymbol.hashCode())) * 31) + (this.priceType == null ? 0 : this.priceType.hashCode())) * 31) + (this.strikePrice == null ? 0 : this.strikePrice.hashCode())) * 31) + (this.styleVO != null ? this.styleVO.hashCode() : 0);
    }

    public String toString() {
        Boolean bool = this.canClick;
        String str = this.priceDecimalPart;
        String str2 = this.priceIntegerPart;
        String str3 = this.pricePrefix;
        String str4 = this.priceSuffix;
        String str5 = this.priceSymbol;
        Integer num = this.priceType;
        Boolean bool2 = this.strikePrice;
        return "PriceDescVO(canClick=" + bool + ", priceDecimalPart=" + str + ", priceIntegerPart=" + str2 + ", pricePrefix=" + str3 + ", priceSuffix=" + str4 + ", priceSymbol=" + str5 + ", priceType=" + num + ", strikePrice=" + bool2 + ", styleVO=" + this.styleVO + ")";
    }

    /* compiled from: MergeAtmospherePriceFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/PriceDescVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/PriceDescVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PriceDescVO> serializer() {
            return PriceDescVO$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PriceDescVO(int seen0, Boolean canClick, String priceDecimalPart, String priceIntegerPart, String pricePrefix, String priceSuffix, String priceSymbol, Integer priceType, Boolean strikePrice, StyleVO styleVO, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.canClick = null;
        } else {
            this.canClick = canClick;
        }
        if ((seen0 & 2) == 0) {
            this.priceDecimalPart = null;
        } else {
            this.priceDecimalPart = priceDecimalPart;
        }
        if ((seen0 & 4) == 0) {
            this.priceIntegerPart = null;
        } else {
            this.priceIntegerPart = priceIntegerPart;
        }
        if ((seen0 & 8) == 0) {
            this.pricePrefix = null;
        } else {
            this.pricePrefix = pricePrefix;
        }
        if ((seen0 & 16) == 0) {
            this.priceSuffix = null;
        } else {
            this.priceSuffix = priceSuffix;
        }
        if ((seen0 & 32) == 0) {
            this.priceSymbol = null;
        } else {
            this.priceSymbol = priceSymbol;
        }
        if ((seen0 & 64) == 0) {
            this.priceType = null;
        } else {
            this.priceType = priceType;
        }
        if ((seen0 & 128) == 0) {
            this.strikePrice = null;
        } else {
            this.strikePrice = strikePrice;
        }
        if ((seen0 & 256) == 0) {
            this.styleVO = null;
        } else {
            this.styleVO = styleVO;
        }
    }

    public PriceDescVO(Boolean canClick, String priceDecimalPart, String priceIntegerPart, String pricePrefix, String priceSuffix, String priceSymbol, Integer priceType, Boolean strikePrice, StyleVO styleVO) {
        this.canClick = canClick;
        this.priceDecimalPart = priceDecimalPart;
        this.priceIntegerPart = priceIntegerPart;
        this.pricePrefix = pricePrefix;
        this.priceSuffix = priceSuffix;
        this.priceSymbol = priceSymbol;
        this.priceType = priceType;
        this.strikePrice = strikePrice;
        this.styleVO = styleVO;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(PriceDescVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.canClick != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.canClick);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.priceDecimalPart != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.priceDecimalPart);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.priceIntegerPart != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.priceIntegerPart);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.pricePrefix != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.pricePrefix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.priceSuffix != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.priceSuffix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.priceSymbol != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.priceSymbol);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.priceType != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.priceType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.strikePrice != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.strikePrice);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.styleVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, PriceDescVO$StyleVO$$serializer.INSTANCE, self.styleVO);
        }
    }

    public /* synthetic */ PriceDescVO(Boolean bool, String str, String str2, String str3, String str4, String str5, Integer num, Boolean bool2, StyleVO styleVO, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : num, (i & 128) != 0 ? null : bool2, (i & 256) == 0 ? styleVO : null);
    }

    public final Boolean getCanClick() {
        return this.canClick;
    }

    public final String getPriceDecimalPart() {
        return this.priceDecimalPart;
    }

    public final String getPriceIntegerPart() {
        return this.priceIntegerPart;
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

    public final Integer getPriceType() {
        return this.priceType;
    }

    public final Boolean getStrikePrice() {
        return this.strikePrice;
    }

    /* compiled from: MergeAtmospherePriceFloor.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006!"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/PriceDescVO$StyleVO;", "", "dayColor", "", "nightColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDayColor", "()Ljava/lang/String;", "getNightColor", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class StyleVO {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String dayColor;
        private final String nightColor;

        public StyleVO() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ StyleVO copy$default(StyleVO styleVO, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = styleVO.dayColor;
            }
            if ((i & 2) != 0) {
                str2 = styleVO.nightColor;
            }
            return styleVO.copy(str, str2);
        }

        public final String component1() {
            return this.dayColor;
        }

        public final String component2() {
            return this.nightColor;
        }

        public final StyleVO copy(String str, String str2) {
            return new StyleVO(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StyleVO) {
                StyleVO styleVO = (StyleVO) obj;
                return Intrinsics.areEqual(this.dayColor, styleVO.dayColor) && Intrinsics.areEqual(this.nightColor, styleVO.nightColor);
            }
            return false;
        }

        public int hashCode() {
            return ((this.dayColor == null ? 0 : this.dayColor.hashCode()) * 31) + (this.nightColor != null ? this.nightColor.hashCode() : 0);
        }

        public String toString() {
            String str = this.dayColor;
            return "StyleVO(dayColor=" + str + ", nightColor=" + this.nightColor + ")";
        }

        /* compiled from: MergeAtmospherePriceFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/PriceDescVO$StyleVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/PriceDescVO$StyleVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<StyleVO> serializer() {
                return PriceDescVO$StyleVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ StyleVO(int seen0, String dayColor, String nightColor, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.dayColor = null;
            } else {
                this.dayColor = dayColor;
            }
            if ((seen0 & 2) == 0) {
                this.nightColor = null;
            } else {
                this.nightColor = nightColor;
            }
        }

        public StyleVO(String dayColor, String nightColor) {
            this.dayColor = dayColor;
            this.nightColor = nightColor;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(StyleVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.dayColor != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.dayColor);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.nightColor != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.nightColor);
            }
        }

        public /* synthetic */ StyleVO(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getDayColor() {
            return this.dayColor;
        }

        public final String getNightColor() {
            return this.nightColor;
        }
    }

    public final StyleVO getStyleVO() {
        return this.styleVO;
    }
}