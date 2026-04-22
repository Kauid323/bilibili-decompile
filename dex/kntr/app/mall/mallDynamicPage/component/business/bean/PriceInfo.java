package kntr.app.mall.mallDynamicPage.component.business.bean;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
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

/* compiled from: MallFeedsModel.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000223BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJJ\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\bHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J%\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00064"}, d2 = {"Lkntr/app/mall/mallDynamicPage/component/business/bean/PriceInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "pricePrefix", RoomRecommendViewModel.EMPTY_CURSOR, "priceSymbol", "priceDesc", "priceSuffix", "payType", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPricePrefix", "()Ljava/lang/String;", "setPricePrefix", "(Ljava/lang/String;)V", "getPriceSymbol", "setPriceSymbol", "getPriceDesc", "setPriceDesc", "getPriceSuffix", "setPriceSuffix", "getPayType", "()Ljava/lang/Integer;", "setPayType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lkntr/app/mall/mallDynamicPage/component/business/bean/PriceInfo;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$mallDynamicPage_debug", "$serializer", "Companion", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class PriceInfo {
    private Integer payType;
    private String priceDesc;
    private String pricePrefix;
    private String priceSuffix;
    private String priceSymbol;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public PriceInfo() {
        this((String) null, (String) null, (String) null, (String) null, (Integer) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PriceInfo copy$default(PriceInfo priceInfo, String str, String str2, String str3, String str4, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = priceInfo.pricePrefix;
        }
        if ((i & 2) != 0) {
            str2 = priceInfo.priceSymbol;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = priceInfo.priceDesc;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = priceInfo.priceSuffix;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            num = priceInfo.payType;
        }
        return priceInfo.copy(str, str5, str6, str7, num);
    }

    public final String component1() {
        return this.pricePrefix;
    }

    public final String component2() {
        return this.priceSymbol;
    }

    public final String component3() {
        return this.priceDesc;
    }

    public final String component4() {
        return this.priceSuffix;
    }

    public final Integer component5() {
        return this.payType;
    }

    public final PriceInfo copy(String str, String str2, String str3, String str4, Integer num) {
        return new PriceInfo(str, str2, str3, str4, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PriceInfo) {
            PriceInfo priceInfo = (PriceInfo) obj;
            return Intrinsics.areEqual(this.pricePrefix, priceInfo.pricePrefix) && Intrinsics.areEqual(this.priceSymbol, priceInfo.priceSymbol) && Intrinsics.areEqual(this.priceDesc, priceInfo.priceDesc) && Intrinsics.areEqual(this.priceSuffix, priceInfo.priceSuffix) && Intrinsics.areEqual(this.payType, priceInfo.payType);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.pricePrefix == null ? 0 : this.pricePrefix.hashCode()) * 31) + (this.priceSymbol == null ? 0 : this.priceSymbol.hashCode())) * 31) + (this.priceDesc == null ? 0 : this.priceDesc.hashCode())) * 31) + (this.priceSuffix == null ? 0 : this.priceSuffix.hashCode())) * 31) + (this.payType != null ? this.payType.hashCode() : 0);
    }

    public String toString() {
        String str = this.pricePrefix;
        String str2 = this.priceSymbol;
        String str3 = this.priceDesc;
        String str4 = this.priceSuffix;
        return "PriceInfo(pricePrefix=" + str + ", priceSymbol=" + str2 + ", priceDesc=" + str3 + ", priceSuffix=" + str4 + ", payType=" + this.payType + ")";
    }

    /* compiled from: MallFeedsModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/mallDynamicPage/component/business/bean/PriceInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/mallDynamicPage/component/business/bean/PriceInfo;", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PriceInfo> serializer() {
            return PriceInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PriceInfo(int seen0, String pricePrefix, String priceSymbol, String priceDesc, String priceSuffix, Integer payType, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.pricePrefix = null;
        } else {
            this.pricePrefix = pricePrefix;
        }
        if ((seen0 & 2) == 0) {
            this.priceSymbol = null;
        } else {
            this.priceSymbol = priceSymbol;
        }
        if ((seen0 & 4) == 0) {
            this.priceDesc = null;
        } else {
            this.priceDesc = priceDesc;
        }
        if ((seen0 & 8) == 0) {
            this.priceSuffix = null;
        } else {
            this.priceSuffix = priceSuffix;
        }
        if ((seen0 & 16) == 0) {
            this.payType = null;
        } else {
            this.payType = payType;
        }
    }

    public PriceInfo(String pricePrefix, String priceSymbol, String priceDesc, String priceSuffix, Integer payType) {
        this.pricePrefix = pricePrefix;
        this.priceSymbol = priceSymbol;
        this.priceDesc = priceDesc;
        this.priceSuffix = priceSuffix;
        this.payType = payType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$mallDynamicPage_debug(PriceInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.pricePrefix != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.pricePrefix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.priceSymbol != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.priceSymbol);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.priceDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.priceDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.priceSuffix != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.priceSuffix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.payType != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.payType);
        }
    }

    public /* synthetic */ PriceInfo(String str, String str2, String str3, String str4, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num);
    }

    public final String getPricePrefix() {
        return this.pricePrefix;
    }

    public final void setPricePrefix(String str) {
        this.pricePrefix = str;
    }

    public final String getPriceSymbol() {
        return this.priceSymbol;
    }

    public final void setPriceSymbol(String str) {
        this.priceSymbol = str;
    }

    public final String getPriceDesc() {
        return this.priceDesc;
    }

    public final void setPriceDesc(String str) {
        this.priceDesc = str;
    }

    public final String getPriceSuffix() {
        return this.priceSuffix;
    }

    public final void setPriceSuffix(String str) {
        this.priceSuffix = str;
    }

    public final Integer getPayType() {
        return this.payType;
    }

    public final void setPayType(Integer num) {
        this.payType = num;
    }
}