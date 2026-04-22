package kntr.app.mall.product.details.page.api.model;

import java.util.List;
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

/* compiled from: IpBrandFloor.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0004-./0BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fBY\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u000eHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u00061"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/IpBrandFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "ipBrandInfoList", "", "Lkntr/app/mall/product/details/page/api/model/IpBrandFloor$IpBrandInfo;", "ipRightList", "Lkntr/app/mall/product/details/page/api/model/IpBrandFloor$IpRightInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getIpBrandInfoList", "()Ljava/util/List;", "getIpRightList", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "IpBrandInfo", "IpRightInfo", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class IpBrandFloor implements FloorModel {
    private final String bgImgUrl;
    private final String floorIcon;
    private final String floorKey;
    private final List<IpBrandInfo> ipBrandInfoList;
    private final List<IpRightInfo> ipRightList;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.IpBrandFloor$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = IpBrandFloor._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.IpBrandFloor$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = IpBrandFloor._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    })};

    public IpBrandFloor() {
        this((String) null, (String) null, (String) null, (List) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ IpBrandFloor copy$default(IpBrandFloor ipBrandFloor, String str, String str2, String str3, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ipBrandFloor.floorKey;
        }
        if ((i & 2) != 0) {
            str2 = ipBrandFloor.floorIcon;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = ipBrandFloor.bgImgUrl;
        }
        String str5 = str3;
        List<IpBrandInfo> list3 = list;
        if ((i & 8) != 0) {
            list3 = ipBrandFloor.ipBrandInfoList;
        }
        List list4 = list3;
        List<IpRightInfo> list5 = list2;
        if ((i & 16) != 0) {
            list5 = ipBrandFloor.ipRightList;
        }
        return ipBrandFloor.copy(str, str4, str5, list4, list5);
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

    public final List<IpBrandInfo> component4() {
        return this.ipBrandInfoList;
    }

    public final List<IpRightInfo> component5() {
        return this.ipRightList;
    }

    public final IpBrandFloor copy(String str, String str2, String str3, List<IpBrandInfo> list, List<IpRightInfo> list2) {
        return new IpBrandFloor(str, str2, str3, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IpBrandFloor) {
            IpBrandFloor ipBrandFloor = (IpBrandFloor) obj;
            return Intrinsics.areEqual(this.floorKey, ipBrandFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, ipBrandFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, ipBrandFloor.bgImgUrl) && Intrinsics.areEqual(this.ipBrandInfoList, ipBrandFloor.ipBrandInfoList) && Intrinsics.areEqual(this.ipRightList, ipBrandFloor.ipRightList);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.ipBrandInfoList == null ? 0 : this.ipBrandInfoList.hashCode())) * 31) + (this.ipRightList != null ? this.ipRightList.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        List<IpBrandInfo> list = this.ipBrandInfoList;
        return "IpBrandFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", ipBrandInfoList=" + list + ", ipRightList=" + this.ipRightList + ")";
    }

    /* compiled from: IpBrandFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/IpBrandFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/IpBrandFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<IpBrandFloor> serializer() {
            return IpBrandFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ IpBrandFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, List ipBrandInfoList, List ipRightList, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.ipBrandInfoList = null;
        } else {
            this.ipBrandInfoList = ipBrandInfoList;
        }
        if ((seen0 & 16) == 0) {
            this.ipRightList = null;
        } else {
            this.ipRightList = ipRightList;
        }
    }

    public IpBrandFloor(String floorKey, String floorIcon, String bgImgUrl, List<IpBrandInfo> list, List<IpRightInfo> list2) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.ipBrandInfoList = list;
        this.ipRightList = list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(IpBrandFloor$IpBrandInfo$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(IpBrandFloor$IpRightInfo$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(IpBrandFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.ipBrandInfoList != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.ipBrandInfoList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.ipRightList != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.ipRightList);
        }
    }

    public /* synthetic */ IpBrandFloor(String str, String str2, String str3, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : list2);
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

    public final List<IpBrandInfo> getIpBrandInfoList() {
        return this.ipBrandInfoList;
    }

    /* compiled from: IpBrandFloor.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBa\b\u0010\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019Jb\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\nHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u00063"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/IpBrandFloor$IpBrandInfo;", "", "img", "", "jumpUrl", "naJumpUrl", "score", "scorePrefix", "title", "type", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImg", "()Ljava/lang/String;", "getJumpUrl", "getNaJumpUrl", "getScore", "getScorePrefix", "getTitle", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/IpBrandFloor$IpBrandInfo;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class IpBrandInfo {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String img;
        private final String jumpUrl;
        private final String naJumpUrl;
        private final String score;
        private final String scorePrefix;
        private final String title;
        private final Integer type;

        public IpBrandInfo() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, 127, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ IpBrandInfo copy$default(IpBrandInfo ipBrandInfo, String str, String str2, String str3, String str4, String str5, String str6, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ipBrandInfo.img;
            }
            if ((i & 2) != 0) {
                str2 = ipBrandInfo.jumpUrl;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                str3 = ipBrandInfo.naJumpUrl;
            }
            String str8 = str3;
            if ((i & 8) != 0) {
                str4 = ipBrandInfo.score;
            }
            String str9 = str4;
            if ((i & 16) != 0) {
                str5 = ipBrandInfo.scorePrefix;
            }
            String str10 = str5;
            if ((i & 32) != 0) {
                str6 = ipBrandInfo.title;
            }
            String str11 = str6;
            if ((i & 64) != 0) {
                num = ipBrandInfo.type;
            }
            return ipBrandInfo.copy(str, str7, str8, str9, str10, str11, num);
        }

        public final String component1() {
            return this.img;
        }

        public final String component2() {
            return this.jumpUrl;
        }

        public final String component3() {
            return this.naJumpUrl;
        }

        public final String component4() {
            return this.score;
        }

        public final String component5() {
            return this.scorePrefix;
        }

        public final String component6() {
            return this.title;
        }

        public final Integer component7() {
            return this.type;
        }

        public final IpBrandInfo copy(String str, String str2, String str3, String str4, String str5, String str6, Integer num) {
            return new IpBrandInfo(str, str2, str3, str4, str5, str6, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IpBrandInfo) {
                IpBrandInfo ipBrandInfo = (IpBrandInfo) obj;
                return Intrinsics.areEqual(this.img, ipBrandInfo.img) && Intrinsics.areEqual(this.jumpUrl, ipBrandInfo.jumpUrl) && Intrinsics.areEqual(this.naJumpUrl, ipBrandInfo.naJumpUrl) && Intrinsics.areEqual(this.score, ipBrandInfo.score) && Intrinsics.areEqual(this.scorePrefix, ipBrandInfo.scorePrefix) && Intrinsics.areEqual(this.title, ipBrandInfo.title) && Intrinsics.areEqual(this.type, ipBrandInfo.type);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((this.img == null ? 0 : this.img.hashCode()) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.naJumpUrl == null ? 0 : this.naJumpUrl.hashCode())) * 31) + (this.score == null ? 0 : this.score.hashCode())) * 31) + (this.scorePrefix == null ? 0 : this.scorePrefix.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
        }

        public String toString() {
            String str = this.img;
            String str2 = this.jumpUrl;
            String str3 = this.naJumpUrl;
            String str4 = this.score;
            String str5 = this.scorePrefix;
            String str6 = this.title;
            return "IpBrandInfo(img=" + str + ", jumpUrl=" + str2 + ", naJumpUrl=" + str3 + ", score=" + str4 + ", scorePrefix=" + str5 + ", title=" + str6 + ", type=" + this.type + ")";
        }

        /* compiled from: IpBrandFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/IpBrandFloor$IpBrandInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/IpBrandFloor$IpBrandInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<IpBrandInfo> serializer() {
                return IpBrandFloor$IpBrandInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ IpBrandInfo(int seen0, String img, String jumpUrl, String naJumpUrl, String score, String scorePrefix, String title, Integer type, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.img = null;
            } else {
                this.img = img;
            }
            if ((seen0 & 2) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
            if ((seen0 & 4) == 0) {
                this.naJumpUrl = null;
            } else {
                this.naJumpUrl = naJumpUrl;
            }
            if ((seen0 & 8) == 0) {
                this.score = null;
            } else {
                this.score = score;
            }
            if ((seen0 & 16) == 0) {
                this.scorePrefix = null;
            } else {
                this.scorePrefix = scorePrefix;
            }
            if ((seen0 & 32) == 0) {
                this.title = null;
            } else {
                this.title = title;
            }
            if ((seen0 & 64) == 0) {
                this.type = null;
            } else {
                this.type = type;
            }
        }

        public IpBrandInfo(String img, String jumpUrl, String naJumpUrl, String score, String scorePrefix, String title, Integer type) {
            this.img = img;
            this.jumpUrl = jumpUrl;
            this.naJumpUrl = naJumpUrl;
            this.score = score;
            this.scorePrefix = scorePrefix;
            this.title = title;
            this.type = type;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(IpBrandInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.img != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.img);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.jumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.naJumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.naJumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.score != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.score);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.scorePrefix != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.scorePrefix);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.title != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.title);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.type != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.type);
            }
        }

        public /* synthetic */ IpBrandInfo(String str, String str2, String str3, String str4, String str5, String str6, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : num);
        }

        public final String getImg() {
            return this.img;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final String getNaJumpUrl() {
            return this.naJumpUrl;
        }

        public final String getScore() {
            return this.score;
        }

        public final String getScorePrefix() {
            return this.scorePrefix;
        }

        public final String getTitle() {
            return this.title;
        }

        public final Integer getType() {
            return this.type;
        }
    }

    public final List<IpRightInfo> getIpRightList() {
        return this.ipRightList;
    }

    /* compiled from: IpBrandFloor.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 72\u00020\u0001:\u000267Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eBu\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0010HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0007\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015¨\u00068"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/IpBrandFloor$IpRightInfo;", "", "benefitInfo", "", "ipRightId", "ipRightLogo", "ipRightName", "isShow", "", "jumpUrl", "naJumpUrl", "prefix", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBenefitInfo", "()Ljava/lang/String;", "getIpRightId", "getIpRightLogo", "getIpRightName", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getJumpUrl", "getNaJumpUrl", "getPrefix", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/IpBrandFloor$IpRightInfo;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class IpRightInfo {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String benefitInfo;
        private final String ipRightId;
        private final String ipRightLogo;
        private final String ipRightName;
        private final Boolean isShow;
        private final String jumpUrl;
        private final String naJumpUrl;
        private final String prefix;
        private final String title;

        public IpRightInfo() {
            this((String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, 511, (DefaultConstructorMarker) null);
        }

        public final String component1() {
            return this.benefitInfo;
        }

        public final String component2() {
            return this.ipRightId;
        }

        public final String component3() {
            return this.ipRightLogo;
        }

        public final String component4() {
            return this.ipRightName;
        }

        public final Boolean component5() {
            return this.isShow;
        }

        public final String component6() {
            return this.jumpUrl;
        }

        public final String component7() {
            return this.naJumpUrl;
        }

        public final String component8() {
            return this.prefix;
        }

        public final String component9() {
            return this.title;
        }

        public final IpRightInfo copy(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, String str7, String str8) {
            return new IpRightInfo(str, str2, str3, str4, bool, str5, str6, str7, str8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IpRightInfo) {
                IpRightInfo ipRightInfo = (IpRightInfo) obj;
                return Intrinsics.areEqual(this.benefitInfo, ipRightInfo.benefitInfo) && Intrinsics.areEqual(this.ipRightId, ipRightInfo.ipRightId) && Intrinsics.areEqual(this.ipRightLogo, ipRightInfo.ipRightLogo) && Intrinsics.areEqual(this.ipRightName, ipRightInfo.ipRightName) && Intrinsics.areEqual(this.isShow, ipRightInfo.isShow) && Intrinsics.areEqual(this.jumpUrl, ipRightInfo.jumpUrl) && Intrinsics.areEqual(this.naJumpUrl, ipRightInfo.naJumpUrl) && Intrinsics.areEqual(this.prefix, ipRightInfo.prefix) && Intrinsics.areEqual(this.title, ipRightInfo.title);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((this.benefitInfo == null ? 0 : this.benefitInfo.hashCode()) * 31) + (this.ipRightId == null ? 0 : this.ipRightId.hashCode())) * 31) + (this.ipRightLogo == null ? 0 : this.ipRightLogo.hashCode())) * 31) + (this.ipRightName == null ? 0 : this.ipRightName.hashCode())) * 31) + (this.isShow == null ? 0 : this.isShow.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.naJumpUrl == null ? 0 : this.naJumpUrl.hashCode())) * 31) + (this.prefix == null ? 0 : this.prefix.hashCode())) * 31) + (this.title != null ? this.title.hashCode() : 0);
        }

        public String toString() {
            String str = this.benefitInfo;
            String str2 = this.ipRightId;
            String str3 = this.ipRightLogo;
            String str4 = this.ipRightName;
            Boolean bool = this.isShow;
            String str5 = this.jumpUrl;
            String str6 = this.naJumpUrl;
            String str7 = this.prefix;
            return "IpRightInfo(benefitInfo=" + str + ", ipRightId=" + str2 + ", ipRightLogo=" + str3 + ", ipRightName=" + str4 + ", isShow=" + bool + ", jumpUrl=" + str5 + ", naJumpUrl=" + str6 + ", prefix=" + str7 + ", title=" + this.title + ")";
        }

        /* compiled from: IpBrandFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/IpBrandFloor$IpRightInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/IpBrandFloor$IpRightInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<IpRightInfo> serializer() {
                return IpBrandFloor$IpRightInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ IpRightInfo(int seen0, String benefitInfo, String ipRightId, String ipRightLogo, String ipRightName, Boolean isShow, String jumpUrl, String naJumpUrl, String prefix, String title, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.benefitInfo = null;
            } else {
                this.benefitInfo = benefitInfo;
            }
            if ((seen0 & 2) == 0) {
                this.ipRightId = null;
            } else {
                this.ipRightId = ipRightId;
            }
            if ((seen0 & 4) == 0) {
                this.ipRightLogo = null;
            } else {
                this.ipRightLogo = ipRightLogo;
            }
            if ((seen0 & 8) == 0) {
                this.ipRightName = null;
            } else {
                this.ipRightName = ipRightName;
            }
            if ((seen0 & 16) == 0) {
                this.isShow = null;
            } else {
                this.isShow = isShow;
            }
            if ((seen0 & 32) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
            if ((seen0 & 64) == 0) {
                this.naJumpUrl = null;
            } else {
                this.naJumpUrl = naJumpUrl;
            }
            if ((seen0 & 128) == 0) {
                this.prefix = null;
            } else {
                this.prefix = prefix;
            }
            if ((seen0 & 256) == 0) {
                this.title = null;
            } else {
                this.title = title;
            }
        }

        public IpRightInfo(String benefitInfo, String ipRightId, String ipRightLogo, String ipRightName, Boolean isShow, String jumpUrl, String naJumpUrl, String prefix, String title) {
            this.benefitInfo = benefitInfo;
            this.ipRightId = ipRightId;
            this.ipRightLogo = ipRightLogo;
            this.ipRightName = ipRightName;
            this.isShow = isShow;
            this.jumpUrl = jumpUrl;
            this.naJumpUrl = naJumpUrl;
            this.prefix = prefix;
            this.title = title;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(IpRightInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.benefitInfo != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.benefitInfo);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.ipRightId != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.ipRightId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.ipRightLogo != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.ipRightLogo);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.ipRightName != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.ipRightName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.isShow != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.isShow);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.jumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.naJumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.naJumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.prefix != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.prefix);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.title != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.title);
            }
        }

        public /* synthetic */ IpRightInfo(String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) == 0 ? str8 : null);
        }

        public final String getBenefitInfo() {
            return this.benefitInfo;
        }

        public final String getIpRightId() {
            return this.ipRightId;
        }

        public final String getIpRightLogo() {
            return this.ipRightLogo;
        }

        public final String getIpRightName() {
            return this.ipRightName;
        }

        public final Boolean isShow() {
            return this.isShow;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final String getNaJumpUrl() {
            return this.naJumpUrl;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final String getTitle() {
            return this.title;
        }
    }
}