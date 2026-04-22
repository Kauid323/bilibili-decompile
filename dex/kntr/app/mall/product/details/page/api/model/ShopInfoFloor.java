package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.ShopInfoFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ShopInfoFloor.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0003./0BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fBS\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JK\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u000eHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00061"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "shopInfoVO", "Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor$ShopInfoVO;", "shopItems", "", "Lkntr/app/mall/product/details/page/api/model/ShopItem;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor$ShopInfoVO;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor$ShopInfoVO;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getShopInfoVO", "()Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor$ShopInfoVO;", "getShopItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ShopInfoVO", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ShopInfoFloor implements FloorModel {
    private final String bgImgUrl;
    private final String floorIcon;
    private final String floorKey;
    private final ShopInfoVO shopInfoVO;
    private final List<ShopItem> shopItems;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ShopInfoFloor$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ShopInfoFloor._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public ShopInfoFloor() {
        this((String) null, (String) null, (String) null, (ShopInfoVO) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopInfoFloor copy$default(ShopInfoFloor shopInfoFloor, String str, String str2, String str3, ShopInfoVO shopInfoVO, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopInfoFloor.floorKey;
        }
        if ((i & 2) != 0) {
            str2 = shopInfoFloor.floorIcon;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = shopInfoFloor.bgImgUrl;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            shopInfoVO = shopInfoFloor.shopInfoVO;
        }
        ShopInfoVO shopInfoVO2 = shopInfoVO;
        List<ShopItem> list2 = list;
        if ((i & 16) != 0) {
            list2 = shopInfoFloor.shopItems;
        }
        return shopInfoFloor.copy(str, str4, str5, shopInfoVO2, list2);
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

    public final ShopInfoVO component4() {
        return this.shopInfoVO;
    }

    public final List<ShopItem> component5() {
        return this.shopItems;
    }

    public final ShopInfoFloor copy(String str, String str2, String str3, ShopInfoVO shopInfoVO, List<ShopItem> list) {
        return new ShopInfoFloor(str, str2, str3, shopInfoVO, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShopInfoFloor) {
            ShopInfoFloor shopInfoFloor = (ShopInfoFloor) obj;
            return Intrinsics.areEqual(this.floorKey, shopInfoFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, shopInfoFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, shopInfoFloor.bgImgUrl) && Intrinsics.areEqual(this.shopInfoVO, shopInfoFloor.shopInfoVO) && Intrinsics.areEqual(this.shopItems, shopInfoFloor.shopItems);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.shopInfoVO == null ? 0 : this.shopInfoVO.hashCode())) * 31) + (this.shopItems != null ? this.shopItems.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        ShopInfoVO shopInfoVO = this.shopInfoVO;
        return "ShopInfoFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", shopInfoVO=" + shopInfoVO + ", shopItems=" + this.shopItems + ")";
    }

    /* compiled from: ShopInfoFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ShopInfoFloor> serializer() {
            return ShopInfoFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ShopInfoFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, ShopInfoVO shopInfoVO, List shopItems, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.shopInfoVO = null;
        } else {
            this.shopInfoVO = shopInfoVO;
        }
        if ((seen0 & 16) == 0) {
            this.shopItems = null;
        } else {
            this.shopItems = shopItems;
        }
    }

    public ShopInfoFloor(String floorKey, String floorIcon, String bgImgUrl, ShopInfoVO shopInfoVO, List<ShopItem> list) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.shopInfoVO = shopInfoVO;
        this.shopItems = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(ShopItem$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(ShopInfoFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.shopInfoVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, ShopInfoFloor$ShopInfoVO$$serializer.INSTANCE, self.shopInfoVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.shopItems != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.shopItems);
        }
    }

    public /* synthetic */ ShopInfoFloor(String str, String str2, String str3, ShopInfoVO shopInfoVO, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : shopInfoVO, (i & 16) != 0 ? null : list);
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

    public final ShopInfoVO getShopInfoVO() {
        return this.shopInfoVO;
    }

    /* compiled from: ShopInfoFloor.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 72\u00020\u0001:\u000267Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fBg\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003Jh\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\fHÖ\u0001J\t\u0010-\u001a\u00020\bHÖ\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001a¨\u00068"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor$ShopInfoVO;", "", "living", "", "shopDataInfo", "", "Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "shopFace", "", "shopJumpLink", "shopName", "upOfficialType", "", "upOfficialTypeIcon", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLiving", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShopDataInfo", "()Ljava/util/List;", "getShopFace", "()Ljava/lang/String;", "getShopJumpLink", "getShopName", "getUpOfficialType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUpOfficialTypeIcon", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor$ShopInfoVO;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShopInfoVO {
        private final Boolean living;
        private final List<TextColorModel> shopDataInfo;
        private final String shopFace;
        private final String shopJumpLink;
        private final String shopName;
        private final Integer upOfficialType;
        private final String upOfficialTypeIcon;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ShopInfoFloor$ShopInfoVO$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = ShopInfoFloor.ShopInfoVO._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, null, null, null, null};

        public ShopInfoVO() {
            this((Boolean) null, (List) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, 127, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ShopInfoVO copy$default(ShopInfoVO shopInfoVO, Boolean bool, List list, String str, String str2, String str3, Integer num, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = shopInfoVO.living;
            }
            List<TextColorModel> list2 = list;
            if ((i & 2) != 0) {
                list2 = shopInfoVO.shopDataInfo;
            }
            List list3 = list2;
            if ((i & 4) != 0) {
                str = shopInfoVO.shopFace;
            }
            String str5 = str;
            if ((i & 8) != 0) {
                str2 = shopInfoVO.shopJumpLink;
            }
            String str6 = str2;
            if ((i & 16) != 0) {
                str3 = shopInfoVO.shopName;
            }
            String str7 = str3;
            if ((i & 32) != 0) {
                num = shopInfoVO.upOfficialType;
            }
            Integer num2 = num;
            if ((i & 64) != 0) {
                str4 = shopInfoVO.upOfficialTypeIcon;
            }
            return shopInfoVO.copy(bool, list3, str5, str6, str7, num2, str4);
        }

        public final Boolean component1() {
            return this.living;
        }

        public final List<TextColorModel> component2() {
            return this.shopDataInfo;
        }

        public final String component3() {
            return this.shopFace;
        }

        public final String component4() {
            return this.shopJumpLink;
        }

        public final String component5() {
            return this.shopName;
        }

        public final Integer component6() {
            return this.upOfficialType;
        }

        public final String component7() {
            return this.upOfficialTypeIcon;
        }

        public final ShopInfoVO copy(Boolean bool, List<TextColorModel> list, String str, String str2, String str3, Integer num, String str4) {
            return new ShopInfoVO(bool, list, str, str2, str3, num, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShopInfoVO) {
                ShopInfoVO shopInfoVO = (ShopInfoVO) obj;
                return Intrinsics.areEqual(this.living, shopInfoVO.living) && Intrinsics.areEqual(this.shopDataInfo, shopInfoVO.shopDataInfo) && Intrinsics.areEqual(this.shopFace, shopInfoVO.shopFace) && Intrinsics.areEqual(this.shopJumpLink, shopInfoVO.shopJumpLink) && Intrinsics.areEqual(this.shopName, shopInfoVO.shopName) && Intrinsics.areEqual(this.upOfficialType, shopInfoVO.upOfficialType) && Intrinsics.areEqual(this.upOfficialTypeIcon, shopInfoVO.upOfficialTypeIcon);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((this.living == null ? 0 : this.living.hashCode()) * 31) + (this.shopDataInfo == null ? 0 : this.shopDataInfo.hashCode())) * 31) + (this.shopFace == null ? 0 : this.shopFace.hashCode())) * 31) + (this.shopJumpLink == null ? 0 : this.shopJumpLink.hashCode())) * 31) + (this.shopName == null ? 0 : this.shopName.hashCode())) * 31) + (this.upOfficialType == null ? 0 : this.upOfficialType.hashCode())) * 31) + (this.upOfficialTypeIcon != null ? this.upOfficialTypeIcon.hashCode() : 0);
        }

        public String toString() {
            Boolean bool = this.living;
            List<TextColorModel> list = this.shopDataInfo;
            String str = this.shopFace;
            String str2 = this.shopJumpLink;
            String str3 = this.shopName;
            Integer num = this.upOfficialType;
            return "ShopInfoVO(living=" + bool + ", shopDataInfo=" + list + ", shopFace=" + str + ", shopJumpLink=" + str2 + ", shopName=" + str3 + ", upOfficialType=" + num + ", upOfficialTypeIcon=" + this.upOfficialTypeIcon + ")";
        }

        /* compiled from: ShopInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor$ShopInfoVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ShopInfoFloor$ShopInfoVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ShopInfoVO> serializer() {
                return ShopInfoFloor$ShopInfoVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ShopInfoVO(int seen0, Boolean living, List shopDataInfo, String shopFace, String shopJumpLink, String shopName, Integer upOfficialType, String upOfficialTypeIcon, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.living = null;
            } else {
                this.living = living;
            }
            if ((seen0 & 2) == 0) {
                this.shopDataInfo = null;
            } else {
                this.shopDataInfo = shopDataInfo;
            }
            if ((seen0 & 4) == 0) {
                this.shopFace = null;
            } else {
                this.shopFace = shopFace;
            }
            if ((seen0 & 8) == 0) {
                this.shopJumpLink = null;
            } else {
                this.shopJumpLink = shopJumpLink;
            }
            if ((seen0 & 16) == 0) {
                this.shopName = null;
            } else {
                this.shopName = shopName;
            }
            if ((seen0 & 32) == 0) {
                this.upOfficialType = null;
            } else {
                this.upOfficialType = upOfficialType;
            }
            if ((seen0 & 64) == 0) {
                this.upOfficialTypeIcon = null;
            } else {
                this.upOfficialTypeIcon = upOfficialTypeIcon;
            }
        }

        public ShopInfoVO(Boolean living, List<TextColorModel> list, String shopFace, String shopJumpLink, String shopName, Integer upOfficialType, String upOfficialTypeIcon) {
            this.living = living;
            this.shopDataInfo = list;
            this.shopFace = shopFace;
            this.shopJumpLink = shopJumpLink;
            this.shopName = shopName;
            this.upOfficialType = upOfficialType;
            this.upOfficialTypeIcon = upOfficialTypeIcon;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(TextColorModel$$serializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ShopInfoVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.living != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.living);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.shopDataInfo != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.shopDataInfo);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.shopFace != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.shopFace);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.shopJumpLink != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.shopJumpLink);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.shopName != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.shopName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.upOfficialType != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.upOfficialType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.upOfficialTypeIcon != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.upOfficialTypeIcon);
            }
        }

        public /* synthetic */ ShopInfoVO(Boolean bool, List list, String str, String str2, String str3, Integer num, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : str4);
        }

        public final Boolean getLiving() {
            return this.living;
        }

        public final List<TextColorModel> getShopDataInfo() {
            return this.shopDataInfo;
        }

        public final String getShopFace() {
            return this.shopFace;
        }

        public final String getShopJumpLink() {
            return this.shopJumpLink;
        }

        public final String getShopName() {
            return this.shopName;
        }

        public final Integer getUpOfficialType() {
            return this.upOfficialType;
        }

        public final String getUpOfficialTypeIcon() {
            return this.upOfficialTypeIcon;
        }
    }

    public final List<ShopItem> getShopItems() {
        return this.shopItems;
    }
}