package kntr.app.ad.common.model;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdStoryGoods.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0002EFB\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016B\u0083\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0015\u0010\u001aJ\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0013\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u00104\u001a\u00020\u0010HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0085\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\t\u0010<\u001a\u00020\u0005HÖ\u0001J%\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0001¢\u0006\u0002\bDR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001b\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006G"}, d2 = {"Lkntr/app/ad/common/model/AdStoryGoods;", RoomRecommendViewModel.EMPTY_CURSOR, "type", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "desc", "imageUrl", "price", "Lkntr/app/ad/common/model/AdPrice;", "qualityInfos", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdQualityInfo;", "button", "Lkntr/app/ad/common/model/AdButton;", "showDynamicTime", RoomRecommendViewModel.EMPTY_CURSOR, "storyCartIcon", "Lkntr/app/ad/common/model/AdStoryCartIcon;", "jkCart", "Lkntr/app/ad/common/model/AdJkCart;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdPrice;Ljava/util/List;Lkntr/app/ad/common/model/AdButton;JLkntr/app/ad/common/model/AdStoryCartIcon;Lkntr/app/ad/common/model/AdJkCart;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/common/model/AdPrice;Ljava/util/List;Lkntr/app/ad/common/model/AdButton;JLkntr/app/ad/common/model/AdStoryCartIcon;Lkntr/app/ad/common/model/AdJkCart;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType", "()I", "getTitle", "()Ljava/lang/String;", "getDesc", "getImageUrl", "getPrice", "()Lkntr/app/ad/common/model/AdPrice;", "getQualityInfos", "()Ljava/util/List;", "getButton", "()Lkntr/app/ad/common/model/AdButton;", "getShowDynamicTime", "()J", "getStoryCartIcon", "()Lkntr/app/ad/common/model/AdStoryCartIcon;", "getJkCart", "()Lkntr/app/ad/common/model/AdJkCart;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdStoryGoods {
    private final AdButton button;
    private final String desc;
    private final String imageUrl;
    private final AdJkCart jkCart;
    private final AdPrice price;
    private final List<AdQualityInfo> qualityInfos;
    private final long showDynamicTime;
    private final AdStoryCartIcon storyCartIcon;
    private final String title;
    private final int type;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdStoryGoods$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdStoryGoods._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null};

    public AdStoryGoods() {
        this(0, (String) null, (String) null, (String) null, (AdPrice) null, (List) null, (AdButton) null, 0L, (AdStoryCartIcon) null, (AdJkCart) null, 1023, (DefaultConstructorMarker) null);
    }

    public final int component1() {
        return this.type;
    }

    public final AdJkCart component10() {
        return this.jkCart;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.desc;
    }

    public final String component4() {
        return this.imageUrl;
    }

    public final AdPrice component5() {
        return this.price;
    }

    public final List<AdQualityInfo> component6() {
        return this.qualityInfos;
    }

    public final AdButton component7() {
        return this.button;
    }

    public final long component8() {
        return this.showDynamicTime;
    }

    public final AdStoryCartIcon component9() {
        return this.storyCartIcon;
    }

    public final AdStoryGoods copy(int i, String str, String str2, String str3, AdPrice adPrice, List<AdQualityInfo> list, AdButton adButton, long j2, AdStoryCartIcon adStoryCartIcon, AdJkCart adJkCart) {
        return new AdStoryGoods(i, str, str2, str3, adPrice, list, adButton, j2, adStoryCartIcon, adJkCart);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdStoryGoods) {
            AdStoryGoods adStoryGoods = (AdStoryGoods) obj;
            return this.type == adStoryGoods.type && Intrinsics.areEqual(this.title, adStoryGoods.title) && Intrinsics.areEqual(this.desc, adStoryGoods.desc) && Intrinsics.areEqual(this.imageUrl, adStoryGoods.imageUrl) && Intrinsics.areEqual(this.price, adStoryGoods.price) && Intrinsics.areEqual(this.qualityInfos, adStoryGoods.qualityInfos) && Intrinsics.areEqual(this.button, adStoryGoods.button) && this.showDynamicTime == adStoryGoods.showDynamicTime && Intrinsics.areEqual(this.storyCartIcon, adStoryGoods.storyCartIcon) && Intrinsics.areEqual(this.jkCart, adStoryGoods.jkCart);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.type * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.desc == null ? 0 : this.desc.hashCode())) * 31) + (this.imageUrl == null ? 0 : this.imageUrl.hashCode())) * 31) + (this.price == null ? 0 : this.price.hashCode())) * 31) + (this.qualityInfos == null ? 0 : this.qualityInfos.hashCode())) * 31) + (this.button == null ? 0 : this.button.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.showDynamicTime)) * 31) + (this.storyCartIcon == null ? 0 : this.storyCartIcon.hashCode())) * 31) + (this.jkCart != null ? this.jkCart.hashCode() : 0);
    }

    public String toString() {
        int i = this.type;
        String str = this.title;
        String str2 = this.desc;
        String str3 = this.imageUrl;
        AdPrice adPrice = this.price;
        List<AdQualityInfo> list = this.qualityInfos;
        AdButton adButton = this.button;
        long j2 = this.showDynamicTime;
        AdStoryCartIcon adStoryCartIcon = this.storyCartIcon;
        return "AdStoryGoods(type=" + i + ", title=" + str + ", desc=" + str2 + ", imageUrl=" + str3 + ", price=" + adPrice + ", qualityInfos=" + list + ", button=" + adButton + ", showDynamicTime=" + j2 + ", storyCartIcon=" + adStoryCartIcon + ", jkCart=" + this.jkCart + ")";
    }

    /* compiled from: AdStoryGoods.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdStoryGoods$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdStoryGoods;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdStoryGoods> serializer() {
            return AdStoryGoods$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdStoryGoods(int seen0, int type, String title, String desc, String imageUrl, AdPrice price, List qualityInfos, AdButton button, long showDynamicTime, AdStoryCartIcon storyCartIcon, AdJkCart jkCart, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.type = 0;
        } else {
            this.type = type;
        }
        if ((seen0 & 2) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 4) == 0) {
            this.desc = null;
        } else {
            this.desc = desc;
        }
        if ((seen0 & 8) == 0) {
            this.imageUrl = null;
        } else {
            this.imageUrl = imageUrl;
        }
        if ((seen0 & 16) == 0) {
            this.price = null;
        } else {
            this.price = price;
        }
        if ((seen0 & 32) == 0) {
            this.qualityInfos = null;
        } else {
            this.qualityInfos = qualityInfos;
        }
        if ((seen0 & 64) == 0) {
            this.button = null;
        } else {
            this.button = button;
        }
        if ((seen0 & 128) == 0) {
            this.showDynamicTime = 5000L;
        } else {
            this.showDynamicTime = showDynamicTime;
        }
        if ((seen0 & 256) == 0) {
            this.storyCartIcon = null;
        } else {
            this.storyCartIcon = storyCartIcon;
        }
        if ((seen0 & 512) == 0) {
            this.jkCart = null;
        } else {
            this.jkCart = jkCart;
        }
    }

    public AdStoryGoods(int type, String title, String desc, String imageUrl, AdPrice price, List<AdQualityInfo> list, AdButton button, long showDynamicTime, AdStoryCartIcon storyCartIcon, AdJkCart jkCart) {
        this.type = type;
        this.title = title;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.price = price;
        this.qualityInfos = list;
        this.button = button;
        this.showDynamicTime = showDynamicTime;
        this.storyCartIcon = storyCartIcon;
        this.jkCart = jkCart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdQualityInfo$$serializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdStoryGoods self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.type != 0) {
            output.encodeIntElement(serialDesc, 0, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.desc != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.desc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.imageUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.imageUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.price != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, AdPrice$$serializer.INSTANCE, self.price);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.qualityInfos != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy) lazyArr[5].getValue(), self.qualityInfos);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.button != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, AdButton$$serializer.INSTANCE, self.button);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.showDynamicTime != 5000) {
            output.encodeLongElement(serialDesc, 7, self.showDynamicTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.storyCartIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, AdStoryCartIcon$$serializer.INSTANCE, self.storyCartIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.jkCart != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, AdJkCart$$serializer.INSTANCE, self.jkCart);
        }
    }

    public /* synthetic */ AdStoryGoods(int i, String str, String str2, String str3, AdPrice adPrice, List list, AdButton adButton, long j2, AdStoryCartIcon adStoryCartIcon, AdJkCart adJkCart, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : adPrice, (i2 & 32) != 0 ? null : list, (i2 & 64) != 0 ? null : adButton, (i2 & 128) != 0 ? 5000L : j2, (i2 & 256) != 0 ? null : adStoryCartIcon, (i2 & 512) == 0 ? adJkCart : null);
    }

    public final int getType() {
        return this.type;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final AdPrice getPrice() {
        return this.price;
    }

    public final List<AdQualityInfo> getQualityInfos() {
        return this.qualityInfos;
    }

    public final AdButton getButton() {
        return this.button;
    }

    public final long getShowDynamicTime() {
        return this.showDynamicTime;
    }

    public final AdStoryCartIcon getStoryCartIcon() {
        return this.storyCartIcon;
    }

    public final AdJkCart getJkCart() {
        return this.jkCart;
    }
}