package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.DetailDescFloor;
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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DetailDescFloor.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0004-./0BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fBY\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u000eHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u00061"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/DetailDescFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "contents", "", "Lkntr/app/mall/product/details/page/api/model/DetailDescFloor$Content;", "itemsAttrGroups", "Lkntr/app/mall/product/details/page/api/model/DetailDescFloor$ItemsAttrGroup;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getContents", "()Ljava/util/List;", "getItemsAttrGroups", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "Content", "ItemsAttrGroup", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class DetailDescFloor implements FloorModel {
    private final String bgImgUrl;
    private final List<Content> contents;
    private final String floorIcon;
    private final String floorKey;
    private final List<ItemsAttrGroup> itemsAttrGroups;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.DetailDescFloor$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = DetailDescFloor._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.DetailDescFloor$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = DetailDescFloor._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    })};

    public DetailDescFloor() {
        this((String) null, (String) null, (String) null, (List) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DetailDescFloor copy$default(DetailDescFloor detailDescFloor, String str, String str2, String str3, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = detailDescFloor.floorKey;
        }
        if ((i & 2) != 0) {
            str2 = detailDescFloor.floorIcon;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = detailDescFloor.bgImgUrl;
        }
        String str5 = str3;
        List<Content> list3 = list;
        if ((i & 8) != 0) {
            list3 = detailDescFloor.contents;
        }
        List list4 = list3;
        List<ItemsAttrGroup> list5 = list2;
        if ((i & 16) != 0) {
            list5 = detailDescFloor.itemsAttrGroups;
        }
        return detailDescFloor.copy(str, str4, str5, list4, list5);
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

    public final List<Content> component4() {
        return this.contents;
    }

    public final List<ItemsAttrGroup> component5() {
        return this.itemsAttrGroups;
    }

    public final DetailDescFloor copy(String str, String str2, String str3, List<Content> list, List<ItemsAttrGroup> list2) {
        return new DetailDescFloor(str, str2, str3, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DetailDescFloor) {
            DetailDescFloor detailDescFloor = (DetailDescFloor) obj;
            return Intrinsics.areEqual(this.floorKey, detailDescFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, detailDescFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, detailDescFloor.bgImgUrl) && Intrinsics.areEqual(this.contents, detailDescFloor.contents) && Intrinsics.areEqual(this.itemsAttrGroups, detailDescFloor.itemsAttrGroups);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.contents == null ? 0 : this.contents.hashCode())) * 31) + (this.itemsAttrGroups != null ? this.itemsAttrGroups.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        List<Content> list = this.contents;
        return "DetailDescFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", contents=" + list + ", itemsAttrGroups=" + this.itemsAttrGroups + ")";
    }

    /* compiled from: DetailDescFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/DetailDescFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/DetailDescFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DetailDescFloor> serializer() {
            return DetailDescFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DetailDescFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, List contents, List itemsAttrGroups, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.contents = null;
        } else {
            this.contents = contents;
        }
        if ((seen0 & 16) == 0) {
            this.itemsAttrGroups = null;
        } else {
            this.itemsAttrGroups = itemsAttrGroups;
        }
    }

    public DetailDescFloor(String floorKey, String floorIcon, String bgImgUrl, List<Content> list, List<ItemsAttrGroup> list2) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.contents = list;
        this.itemsAttrGroups = list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(DetailDescFloor$Content$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(DetailDescFloor$ItemsAttrGroup$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(DetailDescFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.contents != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.contents);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.itemsAttrGroups != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.itemsAttrGroups);
        }
    }

    public /* synthetic */ DetailDescFloor(String str, String str2, String str3, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

    public final List<Content> getContents() {
        return this.contents;
    }

    /* compiled from: DetailDescFloor.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J>\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015¨\u0006-"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/DetailDescFloor$Content;", "", "content", "", "type", "", "height", "", "width", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getContent", "()Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;)Lkntr/app/mall/product/details/page/api/model/DetailDescFloor$Content;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Content {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String content;
        private final Double height;
        private final Integer type;
        private final Double width;

        public Content() {
            this((String) null, (Integer) null, (Double) null, (Double) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Content copy$default(Content content, String str, Integer num, Double d, Double d2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = content.content;
            }
            if ((i & 2) != 0) {
                num = content.type;
            }
            if ((i & 4) != 0) {
                d = content.height;
            }
            if ((i & 8) != 0) {
                d2 = content.width;
            }
            return content.copy(str, num, d, d2);
        }

        public final String component1() {
            return this.content;
        }

        public final Integer component2() {
            return this.type;
        }

        public final Double component3() {
            return this.height;
        }

        public final Double component4() {
            return this.width;
        }

        public final Content copy(String str, Integer num, Double d, Double d2) {
            return new Content(str, num, d, d2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Content) {
                Content content = (Content) obj;
                return Intrinsics.areEqual(this.content, content.content) && Intrinsics.areEqual(this.type, content.type) && Intrinsics.areEqual(this.height, content.height) && Intrinsics.areEqual(this.width, content.width);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.content == null ? 0 : this.content.hashCode()) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.height == null ? 0 : this.height.hashCode())) * 31) + (this.width != null ? this.width.hashCode() : 0);
        }

        public String toString() {
            String str = this.content;
            Integer num = this.type;
            Double d = this.height;
            return "Content(content=" + str + ", type=" + num + ", height=" + d + ", width=" + this.width + ")";
        }

        /* compiled from: DetailDescFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/DetailDescFloor$Content$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/DetailDescFloor$Content;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Content> serializer() {
                return DetailDescFloor$Content$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Content(int seen0, String content, Integer type, Double height, Double width, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.content = null;
            } else {
                this.content = content;
            }
            if ((seen0 & 2) == 0) {
                this.type = null;
            } else {
                this.type = type;
            }
            if ((seen0 & 4) == 0) {
                this.height = null;
            } else {
                this.height = height;
            }
            if ((seen0 & 8) == 0) {
                this.width = null;
            } else {
                this.width = width;
            }
        }

        public Content(String content, Integer type, Double height, Double width) {
            this.content = content;
            this.type = type;
            this.height = height;
            this.width = width;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(Content self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.content != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.content);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.type != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.type);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.height != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, DoubleSerializer.INSTANCE, self.height);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.width != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, DoubleSerializer.INSTANCE, self.width);
            }
        }

        public /* synthetic */ Content(String str, Integer num, Double d, Double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : d2);
        }

        public final String getContent() {
            return this.content;
        }

        public final Integer getType() {
            return this.type;
        }

        public final Double getHeight() {
            return this.height;
        }

        public final Double getWidth() {
            return this.width;
        }
    }

    public final List<ItemsAttrGroup> getItemsAttrGroups() {
        return this.itemsAttrGroups;
    }

    /* compiled from: DetailDescFloor.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J8\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/DetailDescFloor$ItemsAttrGroup;", "", "attrGroupName", "", "attrGroupScore", "", "itemsAttrs", "", "Lkntr/app/mall/product/details/page/api/model/AttrListItem;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAttrGroupName", "()Ljava/lang/String;", "getAttrGroupScore", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getItemsAttrs", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/model/DetailDescFloor$ItemsAttrGroup;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ItemsAttrGroup {
        private final String attrGroupName;
        private final Integer attrGroupScore;
        private final List<AttrListItem> itemsAttrs;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.DetailDescFloor$ItemsAttrGroup$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = DetailDescFloor.ItemsAttrGroup._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        })};

        public ItemsAttrGroup() {
            this((String) null, (Integer) null, (List) null, 7, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemsAttrGroup copy$default(ItemsAttrGroup itemsAttrGroup, String str, Integer num, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemsAttrGroup.attrGroupName;
            }
            if ((i & 2) != 0) {
                num = itemsAttrGroup.attrGroupScore;
            }
            if ((i & 4) != 0) {
                list = itemsAttrGroup.itemsAttrs;
            }
            return itemsAttrGroup.copy(str, num, list);
        }

        public final String component1() {
            return this.attrGroupName;
        }

        public final Integer component2() {
            return this.attrGroupScore;
        }

        public final List<AttrListItem> component3() {
            return this.itemsAttrs;
        }

        public final ItemsAttrGroup copy(String str, Integer num, List<AttrListItem> list) {
            return new ItemsAttrGroup(str, num, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ItemsAttrGroup) {
                ItemsAttrGroup itemsAttrGroup = (ItemsAttrGroup) obj;
                return Intrinsics.areEqual(this.attrGroupName, itemsAttrGroup.attrGroupName) && Intrinsics.areEqual(this.attrGroupScore, itemsAttrGroup.attrGroupScore) && Intrinsics.areEqual(this.itemsAttrs, itemsAttrGroup.itemsAttrs);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.attrGroupName == null ? 0 : this.attrGroupName.hashCode()) * 31) + (this.attrGroupScore == null ? 0 : this.attrGroupScore.hashCode())) * 31) + (this.itemsAttrs != null ? this.itemsAttrs.hashCode() : 0);
        }

        public String toString() {
            String str = this.attrGroupName;
            Integer num = this.attrGroupScore;
            return "ItemsAttrGroup(attrGroupName=" + str + ", attrGroupScore=" + num + ", itemsAttrs=" + this.itemsAttrs + ")";
        }

        /* compiled from: DetailDescFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/DetailDescFloor$ItemsAttrGroup$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/DetailDescFloor$ItemsAttrGroup;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ItemsAttrGroup> serializer() {
                return DetailDescFloor$ItemsAttrGroup$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ItemsAttrGroup(int seen0, String attrGroupName, Integer attrGroupScore, List itemsAttrs, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.attrGroupName = null;
            } else {
                this.attrGroupName = attrGroupName;
            }
            if ((seen0 & 2) == 0) {
                this.attrGroupScore = null;
            } else {
                this.attrGroupScore = attrGroupScore;
            }
            if ((seen0 & 4) == 0) {
                this.itemsAttrs = null;
            } else {
                this.itemsAttrs = itemsAttrs;
            }
        }

        public ItemsAttrGroup(String attrGroupName, Integer attrGroupScore, List<AttrListItem> list) {
            this.attrGroupName = attrGroupName;
            this.attrGroupScore = attrGroupScore;
            this.itemsAttrs = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(AttrListItem$$serializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ItemsAttrGroup self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.attrGroupName != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.attrGroupName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.attrGroupScore != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.attrGroupScore);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.itemsAttrs != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.itemsAttrs);
            }
        }

        public /* synthetic */ ItemsAttrGroup(String str, Integer num, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : list);
        }

        public final String getAttrGroupName() {
            return this.attrGroupName;
        }

        public final Integer getAttrGroupScore() {
            return this.attrGroupScore;
        }

        public final List<AttrListItem> getItemsAttrs() {
            return this.itemsAttrs;
        }
    }
}