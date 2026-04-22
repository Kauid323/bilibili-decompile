package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.ServiceFloor;
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
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ServiceFloor.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 52\u00020\u0001:\u00042345B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eBc\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0003J]\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0010HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J%\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019¨\u00066"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ServiceFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "commitmentTags", "", "Lkntr/app/mall/product/details/page/api/model/CommitmentTag;", "servicePanelVO", "Lkntr/app/mall/product/details/page/api/model/ServiceFloor$ServicePanelVO;", "services", "Lkntr/app/mall/product/details/page/api/model/ServiceFloor$ServiceInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/ServiceFloor$ServicePanelVO;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/ServiceFloor$ServicePanelVO;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getCommitmentTags", "()Ljava/util/List;", "getServicePanelVO", "()Lkntr/app/mall/product/details/page/api/model/ServiceFloor$ServicePanelVO;", "getServices", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ServicePanelVO", "ServiceInfo", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ServiceFloor implements FloorModel {
    private final String bgImgUrl;
    private final List<CommitmentTag> commitmentTags;
    private final String floorIcon;
    private final String floorKey;
    private final ServicePanelVO servicePanelVO;
    private final List<ServiceInfo> services;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ServiceFloor$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ServiceFloor._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ServiceFloor$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = ServiceFloor._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    })};

    public ServiceFloor() {
        this((String) null, (String) null, (String) null, (List) null, (ServicePanelVO) null, (List) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ServiceFloor copy$default(ServiceFloor serviceFloor, String str, String str2, String str3, List list, ServicePanelVO servicePanelVO, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = serviceFloor.floorKey;
        }
        if ((i & 2) != 0) {
            str2 = serviceFloor.floorIcon;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = serviceFloor.bgImgUrl;
        }
        String str5 = str3;
        List<CommitmentTag> list3 = list;
        if ((i & 8) != 0) {
            list3 = serviceFloor.commitmentTags;
        }
        List list4 = list3;
        if ((i & 16) != 0) {
            servicePanelVO = serviceFloor.servicePanelVO;
        }
        ServicePanelVO servicePanelVO2 = servicePanelVO;
        List<ServiceInfo> list5 = list2;
        if ((i & 32) != 0) {
            list5 = serviceFloor.services;
        }
        return serviceFloor.copy(str, str4, str5, list4, servicePanelVO2, list5);
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

    public final List<CommitmentTag> component4() {
        return this.commitmentTags;
    }

    public final ServicePanelVO component5() {
        return this.servicePanelVO;
    }

    public final List<ServiceInfo> component6() {
        return this.services;
    }

    public final ServiceFloor copy(String str, String str2, String str3, List<CommitmentTag> list, ServicePanelVO servicePanelVO, List<ServiceInfo> list2) {
        return new ServiceFloor(str, str2, str3, list, servicePanelVO, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServiceFloor) {
            ServiceFloor serviceFloor = (ServiceFloor) obj;
            return Intrinsics.areEqual(this.floorKey, serviceFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, serviceFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, serviceFloor.bgImgUrl) && Intrinsics.areEqual(this.commitmentTags, serviceFloor.commitmentTags) && Intrinsics.areEqual(this.servicePanelVO, serviceFloor.servicePanelVO) && Intrinsics.areEqual(this.services, serviceFloor.services);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.commitmentTags == null ? 0 : this.commitmentTags.hashCode())) * 31) + (this.servicePanelVO == null ? 0 : this.servicePanelVO.hashCode())) * 31) + (this.services != null ? this.services.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        List<CommitmentTag> list = this.commitmentTags;
        ServicePanelVO servicePanelVO = this.servicePanelVO;
        return "ServiceFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", commitmentTags=" + list + ", servicePanelVO=" + servicePanelVO + ", services=" + this.services + ")";
    }

    /* compiled from: ServiceFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ServiceFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ServiceFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ServiceFloor> serializer() {
            return ServiceFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ServiceFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, List commitmentTags, ServicePanelVO servicePanelVO, List services, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.commitmentTags = null;
        } else {
            this.commitmentTags = commitmentTags;
        }
        if ((seen0 & 16) == 0) {
            this.servicePanelVO = null;
        } else {
            this.servicePanelVO = servicePanelVO;
        }
        if ((seen0 & 32) == 0) {
            this.services = null;
        } else {
            this.services = services;
        }
    }

    public ServiceFloor(String floorKey, String floorIcon, String bgImgUrl, List<CommitmentTag> list, ServicePanelVO servicePanelVO, List<ServiceInfo> list2) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.commitmentTags = list;
        this.servicePanelVO = servicePanelVO;
        this.services = list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(CommitmentTag$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(ServiceFloor$ServiceInfo$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(ServiceFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.commitmentTags != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.commitmentTags);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.servicePanelVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, ServiceFloor$ServicePanelVO$$serializer.INSTANCE, self.servicePanelVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.services != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.services);
        }
    }

    public /* synthetic */ ServiceFloor(String str, String str2, String str3, List list, ServicePanelVO servicePanelVO, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : servicePanelVO, (i & 32) != 0 ? null : list2);
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

    public final List<CommitmentTag> getCommitmentTags() {
        return this.commitmentTags;
    }

    public final ServicePanelVO getServicePanelVO() {
        return this.servicePanelVO;
    }

    /* compiled from: ServiceFloor.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0003%&'B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ServiceFloor$ServicePanelVO;", "", "title", "", "desc", "contents", "", "Lkntr/app/mall/product/details/page/api/model/ServiceFloor$ServicePanelVO$Content;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getDesc", "getContents", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "Content", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ServicePanelVO {
        private final List<Content> contents;
        private final String desc;
        private final String title;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.ServiceFloor$ServicePanelVO$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = ServiceFloor.ServicePanelVO._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        })};

        public ServicePanelVO() {
            this((String) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ServicePanelVO copy$default(ServicePanelVO servicePanelVO, String str, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = servicePanelVO.title;
            }
            if ((i & 2) != 0) {
                str2 = servicePanelVO.desc;
            }
            if ((i & 4) != 0) {
                list = servicePanelVO.contents;
            }
            return servicePanelVO.copy(str, str2, list);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.desc;
        }

        public final List<Content> component3() {
            return this.contents;
        }

        public final ServicePanelVO copy(String str, String str2, List<Content> list) {
            return new ServicePanelVO(str, str2, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ServicePanelVO) {
                ServicePanelVO servicePanelVO = (ServicePanelVO) obj;
                return Intrinsics.areEqual(this.title, servicePanelVO.title) && Intrinsics.areEqual(this.desc, servicePanelVO.desc) && Intrinsics.areEqual(this.contents, servicePanelVO.contents);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.desc == null ? 0 : this.desc.hashCode())) * 31) + (this.contents != null ? this.contents.hashCode() : 0);
        }

        public String toString() {
            String str = this.title;
            String str2 = this.desc;
            return "ServicePanelVO(title=" + str + ", desc=" + str2 + ", contents=" + this.contents + ")";
        }

        /* compiled from: ServiceFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ServiceFloor$ServicePanelVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ServiceFloor$ServicePanelVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ServicePanelVO> serializer() {
                return ServiceFloor$ServicePanelVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ServicePanelVO(int seen0, String title, String desc, List contents, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.title = null;
            } else {
                this.title = title;
            }
            if ((seen0 & 2) == 0) {
                this.desc = null;
            } else {
                this.desc = desc;
            }
            if ((seen0 & 4) == 0) {
                this.contents = null;
            } else {
                this.contents = contents;
            }
        }

        public ServicePanelVO(String title, String desc, List<Content> list) {
            this.title = title;
            this.desc = desc;
            this.contents = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(ServiceFloor$ServicePanelVO$Content$$serializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ServicePanelVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.title != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.title);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.desc != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.desc);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.contents != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.contents);
            }
        }

        public /* synthetic */ ServicePanelVO(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getDesc() {
            return this.desc;
        }

        /* compiled from: ServiceFloor.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ServiceFloor$ServicePanelVO$Content;", "", "icon", "", "title", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIcon", "()Ljava/lang/String;", "getTitle", "getContent", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Content {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String content;
            private final String icon;
            private final String title;

            public Content() {
                this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Content copy$default(Content content, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = content.icon;
                }
                if ((i & 2) != 0) {
                    str2 = content.title;
                }
                if ((i & 4) != 0) {
                    str3 = content.content;
                }
                return content.copy(str, str2, str3);
            }

            public final String component1() {
                return this.icon;
            }

            public final String component2() {
                return this.title;
            }

            public final String component3() {
                return this.content;
            }

            public final Content copy(String str, String str2, String str3) {
                return new Content(str, str2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Content) {
                    Content content = (Content) obj;
                    return Intrinsics.areEqual(this.icon, content.icon) && Intrinsics.areEqual(this.title, content.title) && Intrinsics.areEqual(this.content, content.content);
                }
                return false;
            }

            public int hashCode() {
                return ((((this.icon == null ? 0 : this.icon.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.content != null ? this.content.hashCode() : 0);
            }

            public String toString() {
                String str = this.icon;
                String str2 = this.title;
                return "Content(icon=" + str + ", title=" + str2 + ", content=" + this.content + ")";
            }

            /* compiled from: ServiceFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ServiceFloor$ServicePanelVO$Content$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ServiceFloor$ServicePanelVO$Content;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Content> serializer() {
                    return ServiceFloor$ServicePanelVO$Content$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ Content(int seen0, String icon, String title, String content, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.icon = null;
                } else {
                    this.icon = icon;
                }
                if ((seen0 & 2) == 0) {
                    this.title = null;
                } else {
                    this.title = title;
                }
                if ((seen0 & 4) == 0) {
                    this.content = null;
                } else {
                    this.content = content;
                }
            }

            public Content(String icon, String title, String content) {
                this.icon = icon;
                this.title = title;
                this.content = content;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(Content self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.icon != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.icon);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.title != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.title);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.content != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.content);
                }
            }

            public /* synthetic */ Content(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }

            public final String getIcon() {
                return this.icon;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getContent() {
                return this.content;
            }
        }

        public final List<Content> getContents() {
            return this.contents;
        }
    }

    public final List<ServiceInfo> getServices() {
        return this.services;
    }

    /* compiled from: ServiceFloor.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006("}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ServiceFloor$ServiceInfo;", "", "name", "", "style", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Byte;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getStyle", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getType", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/ServiceFloor$ServiceInfo;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ServiceInfo {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String name;
        private final Byte style;
        private final String type;

        public ServiceInfo() {
            this((String) null, (Byte) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ServiceInfo copy$default(ServiceInfo serviceInfo, String str, Byte b, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = serviceInfo.name;
            }
            if ((i & 2) != 0) {
                b = serviceInfo.style;
            }
            if ((i & 4) != 0) {
                str2 = serviceInfo.type;
            }
            return serviceInfo.copy(str, b, str2);
        }

        public final String component1() {
            return this.name;
        }

        public final Byte component2() {
            return this.style;
        }

        public final String component3() {
            return this.type;
        }

        public final ServiceInfo copy(String str, Byte b, String str2) {
            return new ServiceInfo(str, b, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ServiceInfo) {
                ServiceInfo serviceInfo = (ServiceInfo) obj;
                return Intrinsics.areEqual(this.name, serviceInfo.name) && Intrinsics.areEqual(this.style, serviceInfo.style) && Intrinsics.areEqual(this.type, serviceInfo.type);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.style == null ? 0 : this.style.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
        }

        public String toString() {
            String str = this.name;
            Byte b = this.style;
            return "ServiceInfo(name=" + str + ", style=" + b + ", type=" + this.type + ")";
        }

        /* compiled from: ServiceFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ServiceFloor$ServiceInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ServiceFloor$ServiceInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ServiceInfo> serializer() {
                return ServiceFloor$ServiceInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ServiceInfo(int seen0, String name, Byte style, String type, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.name = null;
            } else {
                this.name = name;
            }
            if ((seen0 & 2) == 0) {
                this.style = null;
            } else {
                this.style = style;
            }
            if ((seen0 & 4) == 0) {
                this.type = null;
            } else {
                this.type = type;
            }
        }

        public ServiceInfo(String name, Byte style, String type) {
            this.name = name;
            this.style = style;
            this.type = type;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ServiceInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.name != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.name);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.style != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, ByteSerializer.INSTANCE, self.style);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.type != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.type);
            }
        }

        public /* synthetic */ ServiceInfo(String str, Byte b, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : b, (i & 4) != 0 ? null : str2);
        }

        public final String getName() {
            return this.name;
        }

        public final Byte getStyle() {
            return this.style;
        }

        public final String getType() {
            return this.type;
        }
    }
}