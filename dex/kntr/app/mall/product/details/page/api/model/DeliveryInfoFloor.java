package kntr.app.mall.product.details.page.api.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinVersion;
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

/* compiled from: DeliveryInfoFloor.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u0005=>?@ABg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010Bk\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010,\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jn\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\n2\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0012HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006B"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "addrText", "addressModuleData", "Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$AddressModuleData;", "canOpenAddr", "", "itemsDeliveryInfo", "Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$ItemsDeliveryInfo;", "userDefAddrVO", "Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$UserDefAddrVO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$AddressModuleData;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$ItemsDeliveryInfo;Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$UserDefAddrVO;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$AddressModuleData;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$ItemsDeliveryInfo;Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$UserDefAddrVO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getAddrText", "getAddressModuleData", "()Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$AddressModuleData;", "getCanOpenAddr", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItemsDeliveryInfo", "()Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$ItemsDeliveryInfo;", "getUserDefAddrVO", "()Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$UserDefAddrVO;", "setUserDefAddrVO", "(Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$UserDefAddrVO;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$AddressModuleData;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$ItemsDeliveryInfo;Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$UserDefAddrVO;)Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "AddressModuleData", "ItemsDeliveryInfo", "UserDefAddrVO", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class DeliveryInfoFloor implements FloorModel {
    private final String addrText;
    private final AddressModuleData addressModuleData;
    private final String bgImgUrl;
    private final Boolean canOpenAddr;
    private final String floorIcon;
    private final String floorKey;
    private final ItemsDeliveryInfo itemsDeliveryInfo;
    private UserDefAddrVO userDefAddrVO;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public DeliveryInfoFloor() {
        this((String) null, (String) null, (String) null, (String) null, (AddressModuleData) null, (Boolean) null, (ItemsDeliveryInfo) null, (UserDefAddrVO) null, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DeliveryInfoFloor copy$default(DeliveryInfoFloor deliveryInfoFloor, String str, String str2, String str3, String str4, AddressModuleData addressModuleData, Boolean bool, ItemsDeliveryInfo itemsDeliveryInfo, UserDefAddrVO userDefAddrVO, int i, Object obj) {
        return deliveryInfoFloor.copy((i & 1) != 0 ? deliveryInfoFloor.floorKey : str, (i & 2) != 0 ? deliveryInfoFloor.floorIcon : str2, (i & 4) != 0 ? deliveryInfoFloor.bgImgUrl : str3, (i & 8) != 0 ? deliveryInfoFloor.addrText : str4, (i & 16) != 0 ? deliveryInfoFloor.addressModuleData : addressModuleData, (i & 32) != 0 ? deliveryInfoFloor.canOpenAddr : bool, (i & 64) != 0 ? deliveryInfoFloor.itemsDeliveryInfo : itemsDeliveryInfo, (i & 128) != 0 ? deliveryInfoFloor.userDefAddrVO : userDefAddrVO);
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

    public final String component4() {
        return this.addrText;
    }

    public final AddressModuleData component5() {
        return this.addressModuleData;
    }

    public final Boolean component6() {
        return this.canOpenAddr;
    }

    public final ItemsDeliveryInfo component7() {
        return this.itemsDeliveryInfo;
    }

    public final UserDefAddrVO component8() {
        return this.userDefAddrVO;
    }

    public final DeliveryInfoFloor copy(String str, String str2, String str3, String str4, AddressModuleData addressModuleData, Boolean bool, ItemsDeliveryInfo itemsDeliveryInfo, UserDefAddrVO userDefAddrVO) {
        return new DeliveryInfoFloor(str, str2, str3, str4, addressModuleData, bool, itemsDeliveryInfo, userDefAddrVO);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeliveryInfoFloor) {
            DeliveryInfoFloor deliveryInfoFloor = (DeliveryInfoFloor) obj;
            return Intrinsics.areEqual(this.floorKey, deliveryInfoFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, deliveryInfoFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, deliveryInfoFloor.bgImgUrl) && Intrinsics.areEqual(this.addrText, deliveryInfoFloor.addrText) && Intrinsics.areEqual(this.addressModuleData, deliveryInfoFloor.addressModuleData) && Intrinsics.areEqual(this.canOpenAddr, deliveryInfoFloor.canOpenAddr) && Intrinsics.areEqual(this.itemsDeliveryInfo, deliveryInfoFloor.itemsDeliveryInfo) && Intrinsics.areEqual(this.userDefAddrVO, deliveryInfoFloor.userDefAddrVO);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.addrText == null ? 0 : this.addrText.hashCode())) * 31) + (this.addressModuleData == null ? 0 : this.addressModuleData.hashCode())) * 31) + (this.canOpenAddr == null ? 0 : this.canOpenAddr.hashCode())) * 31) + (this.itemsDeliveryInfo == null ? 0 : this.itemsDeliveryInfo.hashCode())) * 31) + (this.userDefAddrVO != null ? this.userDefAddrVO.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        String str4 = this.addrText;
        AddressModuleData addressModuleData = this.addressModuleData;
        Boolean bool = this.canOpenAddr;
        ItemsDeliveryInfo itemsDeliveryInfo = this.itemsDeliveryInfo;
        return "DeliveryInfoFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", addrText=" + str4 + ", addressModuleData=" + addressModuleData + ", canOpenAddr=" + bool + ", itemsDeliveryInfo=" + itemsDeliveryInfo + ", userDefAddrVO=" + this.userDefAddrVO + ")";
    }

    /* compiled from: DeliveryInfoFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DeliveryInfoFloor> serializer() {
            return DeliveryInfoFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DeliveryInfoFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, String addrText, AddressModuleData addressModuleData, Boolean canOpenAddr, ItemsDeliveryInfo itemsDeliveryInfo, UserDefAddrVO userDefAddrVO, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.addrText = null;
        } else {
            this.addrText = addrText;
        }
        if ((seen0 & 16) == 0) {
            this.addressModuleData = null;
        } else {
            this.addressModuleData = addressModuleData;
        }
        if ((seen0 & 32) == 0) {
            this.canOpenAddr = null;
        } else {
            this.canOpenAddr = canOpenAddr;
        }
        if ((seen0 & 64) == 0) {
            this.itemsDeliveryInfo = null;
        } else {
            this.itemsDeliveryInfo = itemsDeliveryInfo;
        }
        if ((seen0 & 128) == 0) {
            this.userDefAddrVO = null;
        } else {
            this.userDefAddrVO = userDefAddrVO;
        }
    }

    public DeliveryInfoFloor(String floorKey, String floorIcon, String bgImgUrl, String addrText, AddressModuleData addressModuleData, Boolean canOpenAddr, ItemsDeliveryInfo itemsDeliveryInfo, UserDefAddrVO userDefAddrVO) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.addrText = addrText;
        this.addressModuleData = addressModuleData;
        this.canOpenAddr = canOpenAddr;
        this.itemsDeliveryInfo = itemsDeliveryInfo;
        this.userDefAddrVO = userDefAddrVO;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(DeliveryInfoFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.getFloorKey() != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.getFloorKey());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getFloorIcon() != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getFloorIcon());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getBgImgUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getBgImgUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.addrText != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.addrText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.addressModuleData != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, DeliveryInfoFloor$AddressModuleData$$serializer.INSTANCE, self.addressModuleData);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.canOpenAddr != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.canOpenAddr);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.itemsDeliveryInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, DeliveryInfoFloor$ItemsDeliveryInfo$$serializer.INSTANCE, self.itemsDeliveryInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.userDefAddrVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, DeliveryInfoFloor$UserDefAddrVO$$serializer.INSTANCE, self.userDefAddrVO);
        }
    }

    public /* synthetic */ DeliveryInfoFloor(String str, String str2, String str3, String str4, AddressModuleData addressModuleData, Boolean bool, ItemsDeliveryInfo itemsDeliveryInfo, UserDefAddrVO userDefAddrVO, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : addressModuleData, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : itemsDeliveryInfo, (i & 128) == 0 ? userDefAddrVO : null);
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

    public final String getAddrText() {
        return this.addrText;
    }

    public final AddressModuleData getAddressModuleData() {
        return this.addressModuleData;
    }

    public final Boolean getCanOpenAddr() {
        return this.canOpenAddr;
    }

    public final ItemsDeliveryInfo getItemsDeliveryInfo() {
        return this.itemsDeliveryInfo;
    }

    /* compiled from: DeliveryInfoFloor.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0004\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000e¨\u0006'"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$AddressModuleData;", "", "deliveryTimeHours", "", "isShow", "", "storehouse", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDeliveryTimeHours", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStorehouse", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$AddressModuleData;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AddressModuleData {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final Integer deliveryTimeHours;
        private final Boolean isShow;
        private final Integer storehouse;

        public AddressModuleData() {
            this((Integer) null, (Boolean) null, (Integer) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ AddressModuleData copy$default(AddressModuleData addressModuleData, Integer num, Boolean bool, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = addressModuleData.deliveryTimeHours;
            }
            if ((i & 2) != 0) {
                bool = addressModuleData.isShow;
            }
            if ((i & 4) != 0) {
                num2 = addressModuleData.storehouse;
            }
            return addressModuleData.copy(num, bool, num2);
        }

        public final Integer component1() {
            return this.deliveryTimeHours;
        }

        public final Boolean component2() {
            return this.isShow;
        }

        public final Integer component3() {
            return this.storehouse;
        }

        public final AddressModuleData copy(Integer num, Boolean bool, Integer num2) {
            return new AddressModuleData(num, bool, num2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AddressModuleData) {
                AddressModuleData addressModuleData = (AddressModuleData) obj;
                return Intrinsics.areEqual(this.deliveryTimeHours, addressModuleData.deliveryTimeHours) && Intrinsics.areEqual(this.isShow, addressModuleData.isShow) && Intrinsics.areEqual(this.storehouse, addressModuleData.storehouse);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.deliveryTimeHours == null ? 0 : this.deliveryTimeHours.hashCode()) * 31) + (this.isShow == null ? 0 : this.isShow.hashCode())) * 31) + (this.storehouse != null ? this.storehouse.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.deliveryTimeHours;
            Boolean bool = this.isShow;
            return "AddressModuleData(deliveryTimeHours=" + num + ", isShow=" + bool + ", storehouse=" + this.storehouse + ")";
        }

        /* compiled from: DeliveryInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$AddressModuleData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$AddressModuleData;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<AddressModuleData> serializer() {
                return DeliveryInfoFloor$AddressModuleData$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ AddressModuleData(int seen0, Integer deliveryTimeHours, Boolean isShow, Integer storehouse, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.deliveryTimeHours = null;
            } else {
                this.deliveryTimeHours = deliveryTimeHours;
            }
            if ((seen0 & 2) == 0) {
                this.isShow = null;
            } else {
                this.isShow = isShow;
            }
            if ((seen0 & 4) == 0) {
                this.storehouse = null;
            } else {
                this.storehouse = storehouse;
            }
        }

        public AddressModuleData(Integer deliveryTimeHours, Boolean isShow, Integer storehouse) {
            this.deliveryTimeHours = deliveryTimeHours;
            this.isShow = isShow;
            this.storehouse = storehouse;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(AddressModuleData self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.deliveryTimeHours != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.deliveryTimeHours);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.isShow != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.isShow);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.storehouse != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.storehouse);
            }
        }

        public /* synthetic */ AddressModuleData(Integer num, Boolean bool, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : num2);
        }

        public final Integer getDeliveryTimeHours() {
            return this.deliveryTimeHours;
        }

        public final Boolean isShow() {
            return this.isShow;
        }

        public final Integer getStorehouse() {
            return this.storehouse;
        }
    }

    public final UserDefAddrVO getUserDefAddrVO() {
        return this.userDefAddrVO;
    }

    public final void setUserDefAddrVO(UserDefAddrVO userDefAddrVO) {
        this.userDefAddrVO = userDefAddrVO;
    }

    /* compiled from: DeliveryInfoFloor.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018JJ\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006/"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$ItemsDeliveryInfo;", "", "deliveryFeeDesc", "", "deliveryMainDesc", "deliveryModeDesc", "deliveryTime", "", "freeDelivery", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDeliveryFeeDesc", "()Ljava/lang/String;", "getDeliveryMainDesc", "getDeliveryModeDesc", "getDeliveryTime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFreeDelivery", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$ItemsDeliveryInfo;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ItemsDeliveryInfo {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String deliveryFeeDesc;
        private final String deliveryMainDesc;
        private final String deliveryModeDesc;
        private final Integer deliveryTime;
        private final Boolean freeDelivery;

        public ItemsDeliveryInfo() {
            this((String) null, (String) null, (String) null, (Integer) null, (Boolean) null, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ItemsDeliveryInfo copy$default(ItemsDeliveryInfo itemsDeliveryInfo, String str, String str2, String str3, Integer num, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemsDeliveryInfo.deliveryFeeDesc;
            }
            if ((i & 2) != 0) {
                str2 = itemsDeliveryInfo.deliveryMainDesc;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                str3 = itemsDeliveryInfo.deliveryModeDesc;
            }
            String str5 = str3;
            if ((i & 8) != 0) {
                num = itemsDeliveryInfo.deliveryTime;
            }
            Integer num2 = num;
            if ((i & 16) != 0) {
                bool = itemsDeliveryInfo.freeDelivery;
            }
            return itemsDeliveryInfo.copy(str, str4, str5, num2, bool);
        }

        public final String component1() {
            return this.deliveryFeeDesc;
        }

        public final String component2() {
            return this.deliveryMainDesc;
        }

        public final String component3() {
            return this.deliveryModeDesc;
        }

        public final Integer component4() {
            return this.deliveryTime;
        }

        public final Boolean component5() {
            return this.freeDelivery;
        }

        public final ItemsDeliveryInfo copy(String str, String str2, String str3, Integer num, Boolean bool) {
            return new ItemsDeliveryInfo(str, str2, str3, num, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ItemsDeliveryInfo) {
                ItemsDeliveryInfo itemsDeliveryInfo = (ItemsDeliveryInfo) obj;
                return Intrinsics.areEqual(this.deliveryFeeDesc, itemsDeliveryInfo.deliveryFeeDesc) && Intrinsics.areEqual(this.deliveryMainDesc, itemsDeliveryInfo.deliveryMainDesc) && Intrinsics.areEqual(this.deliveryModeDesc, itemsDeliveryInfo.deliveryModeDesc) && Intrinsics.areEqual(this.deliveryTime, itemsDeliveryInfo.deliveryTime) && Intrinsics.areEqual(this.freeDelivery, itemsDeliveryInfo.freeDelivery);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((this.deliveryFeeDesc == null ? 0 : this.deliveryFeeDesc.hashCode()) * 31) + (this.deliveryMainDesc == null ? 0 : this.deliveryMainDesc.hashCode())) * 31) + (this.deliveryModeDesc == null ? 0 : this.deliveryModeDesc.hashCode())) * 31) + (this.deliveryTime == null ? 0 : this.deliveryTime.hashCode())) * 31) + (this.freeDelivery != null ? this.freeDelivery.hashCode() : 0);
        }

        public String toString() {
            String str = this.deliveryFeeDesc;
            String str2 = this.deliveryMainDesc;
            String str3 = this.deliveryModeDesc;
            Integer num = this.deliveryTime;
            return "ItemsDeliveryInfo(deliveryFeeDesc=" + str + ", deliveryMainDesc=" + str2 + ", deliveryModeDesc=" + str3 + ", deliveryTime=" + num + ", freeDelivery=" + this.freeDelivery + ")";
        }

        /* compiled from: DeliveryInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$ItemsDeliveryInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$ItemsDeliveryInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ItemsDeliveryInfo> serializer() {
                return DeliveryInfoFloor$ItemsDeliveryInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ItemsDeliveryInfo(int seen0, String deliveryFeeDesc, String deliveryMainDesc, String deliveryModeDesc, Integer deliveryTime, Boolean freeDelivery, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.deliveryFeeDesc = null;
            } else {
                this.deliveryFeeDesc = deliveryFeeDesc;
            }
            if ((seen0 & 2) == 0) {
                this.deliveryMainDesc = null;
            } else {
                this.deliveryMainDesc = deliveryMainDesc;
            }
            if ((seen0 & 4) == 0) {
                this.deliveryModeDesc = null;
            } else {
                this.deliveryModeDesc = deliveryModeDesc;
            }
            if ((seen0 & 8) == 0) {
                this.deliveryTime = null;
            } else {
                this.deliveryTime = deliveryTime;
            }
            if ((seen0 & 16) == 0) {
                this.freeDelivery = null;
            } else {
                this.freeDelivery = freeDelivery;
            }
        }

        public ItemsDeliveryInfo(String deliveryFeeDesc, String deliveryMainDesc, String deliveryModeDesc, Integer deliveryTime, Boolean freeDelivery) {
            this.deliveryFeeDesc = deliveryFeeDesc;
            this.deliveryMainDesc = deliveryMainDesc;
            this.deliveryModeDesc = deliveryModeDesc;
            this.deliveryTime = deliveryTime;
            this.freeDelivery = freeDelivery;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ItemsDeliveryInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.deliveryFeeDesc != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.deliveryFeeDesc);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.deliveryMainDesc != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.deliveryMainDesc);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.deliveryModeDesc != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.deliveryModeDesc);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.deliveryTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.deliveryTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.freeDelivery != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.freeDelivery);
            }
        }

        public /* synthetic */ ItemsDeliveryInfo(String str, String str2, String str3, Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : bool);
        }

        public final String getDeliveryFeeDesc() {
            return this.deliveryFeeDesc;
        }

        public final String getDeliveryMainDesc() {
            return this.deliveryMainDesc;
        }

        public final String getDeliveryModeDesc() {
            return this.deliveryModeDesc;
        }

        public final Integer getDeliveryTime() {
            return this.deliveryTime;
        }

        public final Boolean getFreeDelivery() {
            return this.freeDelivery;
        }
    }

    /* compiled from: DeliveryInfoFloor.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fBa\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jb\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015¨\u00063"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$UserDefAddrVO;", "", "addId", "", "addr", "", "area", "city", "itemsId", "merchantId", "prov", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAddId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAddr", "()Ljava/lang/String;", "getArea", "getCity", "getItemsId", "getMerchantId", "getProv", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$UserDefAddrVO;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UserDefAddrVO {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final Integer addId;
        private final String addr;
        private final String area;
        private final String city;
        private final String itemsId;
        private final String merchantId;
        private final String prov;

        public UserDefAddrVO() {
            this((Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ UserDefAddrVO copy$default(UserDefAddrVO userDefAddrVO, Integer num, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                num = userDefAddrVO.addId;
            }
            if ((i & 2) != 0) {
                str = userDefAddrVO.addr;
            }
            String str7 = str;
            if ((i & 4) != 0) {
                str2 = userDefAddrVO.area;
            }
            String str8 = str2;
            if ((i & 8) != 0) {
                str3 = userDefAddrVO.city;
            }
            String str9 = str3;
            if ((i & 16) != 0) {
                str4 = userDefAddrVO.itemsId;
            }
            String str10 = str4;
            if ((i & 32) != 0) {
                str5 = userDefAddrVO.merchantId;
            }
            String str11 = str5;
            if ((i & 64) != 0) {
                str6 = userDefAddrVO.prov;
            }
            return userDefAddrVO.copy(num, str7, str8, str9, str10, str11, str6);
        }

        public final Integer component1() {
            return this.addId;
        }

        public final String component2() {
            return this.addr;
        }

        public final String component3() {
            return this.area;
        }

        public final String component4() {
            return this.city;
        }

        public final String component5() {
            return this.itemsId;
        }

        public final String component6() {
            return this.merchantId;
        }

        public final String component7() {
            return this.prov;
        }

        public final UserDefAddrVO copy(Integer num, String str, String str2, String str3, String str4, String str5, String str6) {
            return new UserDefAddrVO(num, str, str2, str3, str4, str5, str6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UserDefAddrVO) {
                UserDefAddrVO userDefAddrVO = (UserDefAddrVO) obj;
                return Intrinsics.areEqual(this.addId, userDefAddrVO.addId) && Intrinsics.areEqual(this.addr, userDefAddrVO.addr) && Intrinsics.areEqual(this.area, userDefAddrVO.area) && Intrinsics.areEqual(this.city, userDefAddrVO.city) && Intrinsics.areEqual(this.itemsId, userDefAddrVO.itemsId) && Intrinsics.areEqual(this.merchantId, userDefAddrVO.merchantId) && Intrinsics.areEqual(this.prov, userDefAddrVO.prov);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((this.addId == null ? 0 : this.addId.hashCode()) * 31) + (this.addr == null ? 0 : this.addr.hashCode())) * 31) + (this.area == null ? 0 : this.area.hashCode())) * 31) + (this.city == null ? 0 : this.city.hashCode())) * 31) + (this.itemsId == null ? 0 : this.itemsId.hashCode())) * 31) + (this.merchantId == null ? 0 : this.merchantId.hashCode())) * 31) + (this.prov != null ? this.prov.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.addId;
            String str = this.addr;
            String str2 = this.area;
            String str3 = this.city;
            String str4 = this.itemsId;
            String str5 = this.merchantId;
            return "UserDefAddrVO(addId=" + num + ", addr=" + str + ", area=" + str2 + ", city=" + str3 + ", itemsId=" + str4 + ", merchantId=" + str5 + ", prov=" + this.prov + ")";
        }

        /* compiled from: DeliveryInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$UserDefAddrVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/DeliveryInfoFloor$UserDefAddrVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<UserDefAddrVO> serializer() {
                return DeliveryInfoFloor$UserDefAddrVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ UserDefAddrVO(int seen0, Integer addId, String addr, String area, String city, String itemsId, String merchantId, String prov, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.addId = null;
            } else {
                this.addId = addId;
            }
            if ((seen0 & 2) == 0) {
                this.addr = null;
            } else {
                this.addr = addr;
            }
            if ((seen0 & 4) == 0) {
                this.area = null;
            } else {
                this.area = area;
            }
            if ((seen0 & 8) == 0) {
                this.city = null;
            } else {
                this.city = city;
            }
            if ((seen0 & 16) == 0) {
                this.itemsId = null;
            } else {
                this.itemsId = itemsId;
            }
            if ((seen0 & 32) == 0) {
                this.merchantId = null;
            } else {
                this.merchantId = merchantId;
            }
            if ((seen0 & 64) == 0) {
                this.prov = null;
            } else {
                this.prov = prov;
            }
        }

        public UserDefAddrVO(Integer addId, String addr, String area, String city, String itemsId, String merchantId, String prov) {
            this.addId = addId;
            this.addr = addr;
            this.area = area;
            this.city = city;
            this.itemsId = itemsId;
            this.merchantId = merchantId;
            this.prov = prov;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(UserDefAddrVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.addId != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.addId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.addr != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.addr);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.area != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.area);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.city != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.city);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.itemsId != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.itemsId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.merchantId != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.merchantId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.prov != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.prov);
            }
        }

        public /* synthetic */ UserDefAddrVO(Integer num, String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6);
        }

        public final Integer getAddId() {
            return this.addId;
        }

        public final String getAddr() {
            return this.addr;
        }

        public final String getArea() {
            return this.area;
        }

        public final String getCity() {
            return this.city;
        }

        public final String getItemsId() {
            return this.itemsId;
        }

        public final String getMerchantId() {
            return this.merchantId;
        }

        public final String getProv() {
            return this.prov;
        }
    }
}