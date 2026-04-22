package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.SkuInfoFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SkuInfoFloor.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0003,-.B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\r\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0019J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u000bHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006/"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "itemsSkuListVO", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getItemsSkuListVO", "()Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO;", "shouldShowHeaderSku", "", "shouldShowHeaderSku$product_details_page_debug", "getFirstSpecName", "getFirstSpecName$product_details_page_debug", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ItemsSkuListVO", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class SkuInfoFloor implements FloorModel {
    private final String bgImgUrl;
    private final String floorIcon;
    private final String floorKey;
    private final ItemsSkuListVO itemsSkuListVO;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public SkuInfoFloor() {
        this((String) null, (String) null, (String) null, (ItemsSkuListVO) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SkuInfoFloor copy$default(SkuInfoFloor skuInfoFloor, String str, String str2, String str3, ItemsSkuListVO itemsSkuListVO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = skuInfoFloor.floorKey;
        }
        if ((i & 2) != 0) {
            str2 = skuInfoFloor.floorIcon;
        }
        if ((i & 4) != 0) {
            str3 = skuInfoFloor.bgImgUrl;
        }
        if ((i & 8) != 0) {
            itemsSkuListVO = skuInfoFloor.itemsSkuListVO;
        }
        return skuInfoFloor.copy(str, str2, str3, itemsSkuListVO);
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

    public final ItemsSkuListVO component4() {
        return this.itemsSkuListVO;
    }

    public final SkuInfoFloor copy(String str, String str2, String str3, ItemsSkuListVO itemsSkuListVO) {
        return new SkuInfoFloor(str, str2, str3, itemsSkuListVO);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkuInfoFloor) {
            SkuInfoFloor skuInfoFloor = (SkuInfoFloor) obj;
            return Intrinsics.areEqual(this.floorKey, skuInfoFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, skuInfoFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, skuInfoFloor.bgImgUrl) && Intrinsics.areEqual(this.itemsSkuListVO, skuInfoFloor.itemsSkuListVO);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.itemsSkuListVO != null ? this.itemsSkuListVO.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        return "SkuInfoFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", itemsSkuListVO=" + this.itemsSkuListVO + ")";
    }

    /* compiled from: SkuInfoFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SkuInfoFloor> serializer() {
            return SkuInfoFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SkuInfoFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, ItemsSkuListVO itemsSkuListVO, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.itemsSkuListVO = null;
        } else {
            this.itemsSkuListVO = itemsSkuListVO;
        }
    }

    public SkuInfoFloor(String floorKey, String floorIcon, String bgImgUrl, ItemsSkuListVO itemsSkuListVO) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.itemsSkuListVO = itemsSkuListVO;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(SkuInfoFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.getFloorKey() != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.getFloorKey());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getFloorIcon() != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getFloorIcon());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getBgImgUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getBgImgUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.itemsSkuListVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, SkuInfoFloor$ItemsSkuListVO$$serializer.INSTANCE, self.itemsSkuListVO);
        }
    }

    public /* synthetic */ SkuInfoFloor(String str, String str2, String str3, ItemsSkuListVO itemsSkuListVO, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : itemsSkuListVO);
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

    public final ItemsSkuListVO getItemsSkuListVO() {
        return this.itemsSkuListVO;
    }

    public final boolean shouldShowHeaderSku$product_details_page_debug() {
        ItemsSkuListVO itemsSkuListVO = this.itemsSkuListVO;
        if (itemsSkuListVO != null ? Intrinsics.areEqual(itemsSkuListVO.getHasSpecValueImg(), true) : false) {
            Integer firstSpecNum = this.itemsSkuListVO.getFirstSpecNum();
            if ((firstSpecNum != null ? firstSpecNum.intValue() : 0) > 1) {
                return true;
            }
        }
        return false;
    }

    public final String getFirstSpecName$product_details_page_debug() {
        List<ItemsSkuListVO.SpecInfoListItem> specInfoList;
        ItemsSkuListVO.SpecInfoListItem specInfoListItem;
        String it;
        ItemsSkuListVO itemsSkuListVO = this.itemsSkuListVO;
        return (itemsSkuListVO == null || (specInfoList = itemsSkuListVO.getSpecInfoList()) == null || (specInfoListItem = (ItemsSkuListVO.SpecInfoListItem) CollectionsKt.firstOrNull(specInfoList)) == null || (it = specInfoListItem.getSpecName()) == null || it.length() > 2) ? "规格" : it;
    }

    /* compiled from: SkuInfoFloor.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0004:;<=Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011Bs\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bHÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003Jt\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0005HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"¨\u0006>"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO;", "", "skuPanelUrl", "", "firstSpecNum", "", "hasSpecValueImg", "", "itemsId", "", "itemsSkuList", "", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem;", "specInfoList", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem;", "specs", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSkuPanelUrl", "()Ljava/lang/String;", "getFirstSpecNum", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHasSpecValueImg", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItemsId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getItemsSkuList", "()Ljava/util/List;", "getSpecInfoList", "getSpecs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ItemsSkuListItem", "SpecInfoListItem", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ItemsSkuListVO {
        private final Integer firstSpecNum;
        private final Boolean hasSpecValueImg;
        private final Long itemsId;
        private final List<ItemsSkuListItem> itemsSkuList;
        private final String skuPanelUrl;
        private final List<SpecInfoListItem> specInfoList;
        private final List<String> specs;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.SkuInfoFloor$ItemsSkuListVO$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = SkuInfoFloor.ItemsSkuListVO._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.SkuInfoFloor$ItemsSkuListVO$$ExternalSyntheticLambda1
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$0;
                _childSerializers$_anonymous_$0 = SkuInfoFloor.ItemsSkuListVO._childSerializers$_anonymous_$0();
                return _childSerializers$_anonymous_$0;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.SkuInfoFloor$ItemsSkuListVO$$ExternalSyntheticLambda2
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$1;
                _childSerializers$_anonymous_$1 = SkuInfoFloor.ItemsSkuListVO._childSerializers$_anonymous_$1();
                return _childSerializers$_anonymous_$1;
            }
        })};

        public ItemsSkuListVO() {
            this((String) null, (Integer) null, (Boolean) null, (Long) null, (List) null, (List) null, (List) null, 127, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ItemsSkuListVO copy$default(ItemsSkuListVO itemsSkuListVO, String str, Integer num, Boolean bool, Long l, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemsSkuListVO.skuPanelUrl;
            }
            if ((i & 2) != 0) {
                num = itemsSkuListVO.firstSpecNum;
            }
            Integer num2 = num;
            if ((i & 4) != 0) {
                bool = itemsSkuListVO.hasSpecValueImg;
            }
            Boolean bool2 = bool;
            if ((i & 8) != 0) {
                l = itemsSkuListVO.itemsId;
            }
            Long l2 = l;
            List<ItemsSkuListItem> list4 = list;
            if ((i & 16) != 0) {
                list4 = itemsSkuListVO.itemsSkuList;
            }
            List list5 = list4;
            List<SpecInfoListItem> list6 = list2;
            if ((i & 32) != 0) {
                list6 = itemsSkuListVO.specInfoList;
            }
            List list7 = list6;
            List<String> list8 = list3;
            if ((i & 64) != 0) {
                list8 = itemsSkuListVO.specs;
            }
            return itemsSkuListVO.copy(str, num2, bool2, l2, list5, list7, list8);
        }

        public final String component1() {
            return this.skuPanelUrl;
        }

        public final Integer component2() {
            return this.firstSpecNum;
        }

        public final Boolean component3() {
            return this.hasSpecValueImg;
        }

        public final Long component4() {
            return this.itemsId;
        }

        public final List<ItemsSkuListItem> component5() {
            return this.itemsSkuList;
        }

        public final List<SpecInfoListItem> component6() {
            return this.specInfoList;
        }

        public final List<String> component7() {
            return this.specs;
        }

        public final ItemsSkuListVO copy(String str, Integer num, Boolean bool, Long l, List<ItemsSkuListItem> list, List<SpecInfoListItem> list2, List<String> list3) {
            return new ItemsSkuListVO(str, num, bool, l, list, list2, list3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ItemsSkuListVO) {
                ItemsSkuListVO itemsSkuListVO = (ItemsSkuListVO) obj;
                return Intrinsics.areEqual(this.skuPanelUrl, itemsSkuListVO.skuPanelUrl) && Intrinsics.areEqual(this.firstSpecNum, itemsSkuListVO.firstSpecNum) && Intrinsics.areEqual(this.hasSpecValueImg, itemsSkuListVO.hasSpecValueImg) && Intrinsics.areEqual(this.itemsId, itemsSkuListVO.itemsId) && Intrinsics.areEqual(this.itemsSkuList, itemsSkuListVO.itemsSkuList) && Intrinsics.areEqual(this.specInfoList, itemsSkuListVO.specInfoList) && Intrinsics.areEqual(this.specs, itemsSkuListVO.specs);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((this.skuPanelUrl == null ? 0 : this.skuPanelUrl.hashCode()) * 31) + (this.firstSpecNum == null ? 0 : this.firstSpecNum.hashCode())) * 31) + (this.hasSpecValueImg == null ? 0 : this.hasSpecValueImg.hashCode())) * 31) + (this.itemsId == null ? 0 : this.itemsId.hashCode())) * 31) + (this.itemsSkuList == null ? 0 : this.itemsSkuList.hashCode())) * 31) + (this.specInfoList == null ? 0 : this.specInfoList.hashCode())) * 31) + (this.specs != null ? this.specs.hashCode() : 0);
        }

        public String toString() {
            String str = this.skuPanelUrl;
            Integer num = this.firstSpecNum;
            Boolean bool = this.hasSpecValueImg;
            Long l = this.itemsId;
            List<ItemsSkuListItem> list = this.itemsSkuList;
            List<SpecInfoListItem> list2 = this.specInfoList;
            return "ItemsSkuListVO(skuPanelUrl=" + str + ", firstSpecNum=" + num + ", hasSpecValueImg=" + bool + ", itemsId=" + l + ", itemsSkuList=" + list + ", specInfoList=" + list2 + ", specs=" + this.specs + ")";
        }

        /* compiled from: SkuInfoFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ItemsSkuListVO> serializer() {
                return SkuInfoFloor$ItemsSkuListVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ItemsSkuListVO(int seen0, String skuPanelUrl, Integer firstSpecNum, Boolean hasSpecValueImg, Long itemsId, List itemsSkuList, List specInfoList, List specs, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.skuPanelUrl = null;
            } else {
                this.skuPanelUrl = skuPanelUrl;
            }
            if ((seen0 & 2) == 0) {
                this.firstSpecNum = null;
            } else {
                this.firstSpecNum = firstSpecNum;
            }
            if ((seen0 & 4) == 0) {
                this.hasSpecValueImg = null;
            } else {
                this.hasSpecValueImg = hasSpecValueImg;
            }
            if ((seen0 & 8) == 0) {
                this.itemsId = null;
            } else {
                this.itemsId = itemsId;
            }
            if ((seen0 & 16) == 0) {
                this.itemsSkuList = null;
            } else {
                this.itemsSkuList = itemsSkuList;
            }
            if ((seen0 & 32) == 0) {
                this.specInfoList = null;
            } else {
                this.specInfoList = specInfoList;
            }
            if ((seen0 & 64) == 0) {
                this.specs = null;
            } else {
                this.specs = specs;
            }
        }

        public ItemsSkuListVO(String skuPanelUrl, Integer firstSpecNum, Boolean hasSpecValueImg, Long itemsId, List<ItemsSkuListItem> list, List<SpecInfoListItem> list2, List<String> list3) {
            this.skuPanelUrl = skuPanelUrl;
            this.firstSpecNum = firstSpecNum;
            this.hasSpecValueImg = hasSpecValueImg;
            this.itemsId = itemsId;
            this.itemsSkuList = list;
            this.specInfoList = list2;
            this.specs = list3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem$$serializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ItemsSkuListVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.skuPanelUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.skuPanelUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.firstSpecNum != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.firstSpecNum);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.hasSpecValueImg != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.hasSpecValueImg);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.itemsId != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, LongSerializer.INSTANCE, self.itemsId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.itemsSkuList != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.itemsSkuList);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.specInfoList != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.specInfoList);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.specs != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, lazyArr[6].getValue(), self.specs);
            }
        }

        public /* synthetic */ ItemsSkuListVO(String str, Integer num, Boolean bool, Long l, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : list2, (i & 64) != 0 ? null : list3);
        }

        public final String getSkuPanelUrl() {
            return this.skuPanelUrl;
        }

        public final Integer getFirstSpecNum() {
            return this.firstSpecNum;
        }

        public final Boolean getHasSpecValueImg() {
            return this.hasSpecValueImg;
        }

        public final Long getItemsId() {
            return this.itemsId;
        }

        public final List<ItemsSkuListItem> getItemsSkuList() {
            return this.itemsSkuList;
        }

        public final List<SpecInfoListItem> getSpecInfoList() {
            return this.specInfoList;
        }

        /* compiled from: SkuInfoFloor.kt */
        @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bP\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u0085\u00012\u00020\u0001:\u0006\u0083\u0001\u0084\u0001\u0085\u0001Bõ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b'\u0010(BÍ\u0002\b\u0010\u0012\u0006\u0010)\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010 \u0012\b\u0010!\u001a\u0004\u0018\u00010\n\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010$\u001a\u0004\u0018\u00010\n\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010&\u001a\u0004\u0018\u00010\f\u0012\b\u0010*\u001a\u0004\u0018\u00010+¢\u0006\u0004\b'\u0010,J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010\\\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010]\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00109J\u0010\u0010^\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010_\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010?J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010e\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010?J\u0010\u0010f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00109J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010k\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010l\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010?J\u0011\u0010n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010 HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010p\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010q\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010r\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010s\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010t\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00109Jü\u0002\u0010u\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010vJ\u0013\u0010w\u001a\u00020\f2\b\u0010x\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010y\u001a\u00020\u0006HÖ\u0001J\t\u0010z\u001a\u00020\u0003HÖ\u0001J(\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\u007f2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0001¢\u0006\u0003\b\u0082\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00102\u001a\u0004\b3\u00101R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00102\u001a\u0004\b4\u00101R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00102\u001a\u0004\b;\u00101R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00107\u001a\u0004\b<\u00106R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010.R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010.R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00107\u001a\u0004\b\u0013\u00106R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00102\u001a\u0004\bB\u00101R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010@\u001a\u0004\bC\u0010?R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010:\u001a\u0004\bD\u00109R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010.R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010.R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010.R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010.R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00107\u001a\u0004\bI\u00106R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010@\u001a\u0004\bN\u0010?R\u0019\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0015\u0010!\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00107\u001a\u0004\bQ\u00106R\u0015\u0010\"\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00102\u001a\u0004\bR\u00101R\u0015\u0010#\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00102\u001a\u0004\bS\u00101R\u0015\u0010$\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00107\u001a\u0004\bT\u00106R\u0015\u0010%\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00102\u001a\u0004\bU\u00101R\u0015\u0010&\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010:\u001a\u0004\bV\u00109¨\u0006\u0086\u0001"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem;", "", "activityDeposit", "", "activityPrice", "activityRestriction", "", "activitySaleStatus", "activityStock", "activityType", "", "asyncSku", "", "autoOnSaleTime", "canAddCart", "deposit", "id", "", "img", "isShow", "itemsStep", "lessonId", "limitBuy", "linePrice", "preDepositPrice", "price", "referencePrice", "saleType", "skuTag", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag;", "specValueId", "specValues", "", "status", "stock", "stockLevel", "subStatus", "warnStock", "whiteListSku", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityDeposit", "()Ljava/lang/String;", "getActivityPrice", "getActivityRestriction", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActivitySaleStatus", "getActivityStock", "getActivityType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getAsyncSku", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAutoOnSaleTime", "getCanAddCart", "getDeposit", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getImg", "getItemsStep", "getLessonId", "getLimitBuy", "getLinePrice", "getPreDepositPrice", "getPrice", "getReferencePrice", "getSaleType", "getSkuTag$annotations", "()V", "getSkuTag", "()Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag;", "getSpecValueId", "getSpecValues", "()Ljava/util/List;", "getStatus", "getStock", "getStockLevel", "getSubStatus", "getWarnStock", "getWhiteListSku", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Byte;Ljava/lang/Integer;Ljava/lang/Boolean;)Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "SkuTag", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class ItemsSkuListItem {
            private final String activityDeposit;
            private final String activityPrice;
            private final Integer activityRestriction;
            private final Integer activitySaleStatus;
            private final Integer activityStock;
            private final Byte activityType;
            private final Boolean asyncSku;
            private final Integer autoOnSaleTime;
            private final Byte canAddCart;
            private final String deposit;
            private final Long id;
            private final String img;
            private final Byte isShow;
            private final Integer itemsStep;
            private final Long lessonId;
            private final Boolean limitBuy;
            private final String linePrice;
            private final String preDepositPrice;
            private final String price;
            private final String referencePrice;
            private final Byte saleType;
            private final SkuTag skuTag;
            private final Long specValueId;
            private final List<String> specValues;
            private final Byte status;
            private final Integer stock;
            private final Integer stockLevel;
            private final Byte subStatus;
            private final Integer warnStock;
            private final Boolean whiteListSku;
            public static final Companion Companion = new Companion(null);
            public static final int $stable = 8;
            private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$$ExternalSyntheticLambda0
                public final Object invoke() {
                    KSerializer _childSerializers$_anonymous_;
                    _childSerializers$_anonymous_ = SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem._childSerializers$_anonymous_();
                    return _childSerializers$_anonymous_;
                }
            }), null, null, null, null, null, null};

            public ItemsSkuListItem() {
                this((String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Byte) null, (Boolean) null, (Integer) null, (Byte) null, (String) null, (Long) null, (String) null, (Byte) null, (Integer) null, (Long) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (Byte) null, (SkuTag) null, (Long) null, (List) null, (Byte) null, (Integer) null, (Integer) null, (Byte) null, (Integer) null, (Boolean) null, 1073741823, (DefaultConstructorMarker) null);
            }

            @SerialName("skuTagVO")
            public static /* synthetic */ void getSkuTag$annotations() {
            }

            public final String component1() {
                return this.activityDeposit;
            }

            public final String component10() {
                return this.deposit;
            }

            public final Long component11() {
                return this.id;
            }

            public final String component12() {
                return this.img;
            }

            public final Byte component13() {
                return this.isShow;
            }

            public final Integer component14() {
                return this.itemsStep;
            }

            public final Long component15() {
                return this.lessonId;
            }

            public final Boolean component16() {
                return this.limitBuy;
            }

            public final String component17() {
                return this.linePrice;
            }

            public final String component18() {
                return this.preDepositPrice;
            }

            public final String component19() {
                return this.price;
            }

            public final String component2() {
                return this.activityPrice;
            }

            public final String component20() {
                return this.referencePrice;
            }

            public final Byte component21() {
                return this.saleType;
            }

            public final SkuTag component22() {
                return this.skuTag;
            }

            public final Long component23() {
                return this.specValueId;
            }

            public final List<String> component24() {
                return this.specValues;
            }

            public final Byte component25() {
                return this.status;
            }

            public final Integer component26() {
                return this.stock;
            }

            public final Integer component27() {
                return this.stockLevel;
            }

            public final Byte component28() {
                return this.subStatus;
            }

            public final Integer component29() {
                return this.warnStock;
            }

            public final Integer component3() {
                return this.activityRestriction;
            }

            public final Boolean component30() {
                return this.whiteListSku;
            }

            public final Integer component4() {
                return this.activitySaleStatus;
            }

            public final Integer component5() {
                return this.activityStock;
            }

            public final Byte component6() {
                return this.activityType;
            }

            public final Boolean component7() {
                return this.asyncSku;
            }

            public final Integer component8() {
                return this.autoOnSaleTime;
            }

            public final Byte component9() {
                return this.canAddCart;
            }

            public final ItemsSkuListItem copy(String str, String str2, Integer num, Integer num2, Integer num3, Byte b, Boolean bool, Integer num4, Byte b2, String str3, Long l, String str4, Byte b3, Integer num5, Long l2, Boolean bool2, String str5, String str6, String str7, String str8, Byte b4, SkuTag skuTag, Long l3, List<String> list, Byte b5, Integer num6, Integer num7, Byte b6, Integer num8, Boolean bool3) {
                return new ItemsSkuListItem(str, str2, num, num2, num3, b, bool, num4, b2, str3, l, str4, b3, num5, l2, bool2, str5, str6, str7, str8, b4, skuTag, l3, list, b5, num6, num7, b6, num8, bool3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ItemsSkuListItem) {
                    ItemsSkuListItem itemsSkuListItem = (ItemsSkuListItem) obj;
                    return Intrinsics.areEqual(this.activityDeposit, itemsSkuListItem.activityDeposit) && Intrinsics.areEqual(this.activityPrice, itemsSkuListItem.activityPrice) && Intrinsics.areEqual(this.activityRestriction, itemsSkuListItem.activityRestriction) && Intrinsics.areEqual(this.activitySaleStatus, itemsSkuListItem.activitySaleStatus) && Intrinsics.areEqual(this.activityStock, itemsSkuListItem.activityStock) && Intrinsics.areEqual(this.activityType, itemsSkuListItem.activityType) && Intrinsics.areEqual(this.asyncSku, itemsSkuListItem.asyncSku) && Intrinsics.areEqual(this.autoOnSaleTime, itemsSkuListItem.autoOnSaleTime) && Intrinsics.areEqual(this.canAddCart, itemsSkuListItem.canAddCart) && Intrinsics.areEqual(this.deposit, itemsSkuListItem.deposit) && Intrinsics.areEqual(this.id, itemsSkuListItem.id) && Intrinsics.areEqual(this.img, itemsSkuListItem.img) && Intrinsics.areEqual(this.isShow, itemsSkuListItem.isShow) && Intrinsics.areEqual(this.itemsStep, itemsSkuListItem.itemsStep) && Intrinsics.areEqual(this.lessonId, itemsSkuListItem.lessonId) && Intrinsics.areEqual(this.limitBuy, itemsSkuListItem.limitBuy) && Intrinsics.areEqual(this.linePrice, itemsSkuListItem.linePrice) && Intrinsics.areEqual(this.preDepositPrice, itemsSkuListItem.preDepositPrice) && Intrinsics.areEqual(this.price, itemsSkuListItem.price) && Intrinsics.areEqual(this.referencePrice, itemsSkuListItem.referencePrice) && Intrinsics.areEqual(this.saleType, itemsSkuListItem.saleType) && Intrinsics.areEqual(this.skuTag, itemsSkuListItem.skuTag) && Intrinsics.areEqual(this.specValueId, itemsSkuListItem.specValueId) && Intrinsics.areEqual(this.specValues, itemsSkuListItem.specValues) && Intrinsics.areEqual(this.status, itemsSkuListItem.status) && Intrinsics.areEqual(this.stock, itemsSkuListItem.stock) && Intrinsics.areEqual(this.stockLevel, itemsSkuListItem.stockLevel) && Intrinsics.areEqual(this.subStatus, itemsSkuListItem.subStatus) && Intrinsics.areEqual(this.warnStock, itemsSkuListItem.warnStock) && Intrinsics.areEqual(this.whiteListSku, itemsSkuListItem.whiteListSku);
                }
                return false;
            }

            public int hashCode() {
                return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.activityDeposit == null ? 0 : this.activityDeposit.hashCode()) * 31) + (this.activityPrice == null ? 0 : this.activityPrice.hashCode())) * 31) + (this.activityRestriction == null ? 0 : this.activityRestriction.hashCode())) * 31) + (this.activitySaleStatus == null ? 0 : this.activitySaleStatus.hashCode())) * 31) + (this.activityStock == null ? 0 : this.activityStock.hashCode())) * 31) + (this.activityType == null ? 0 : this.activityType.hashCode())) * 31) + (this.asyncSku == null ? 0 : this.asyncSku.hashCode())) * 31) + (this.autoOnSaleTime == null ? 0 : this.autoOnSaleTime.hashCode())) * 31) + (this.canAddCart == null ? 0 : this.canAddCart.hashCode())) * 31) + (this.deposit == null ? 0 : this.deposit.hashCode())) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.img == null ? 0 : this.img.hashCode())) * 31) + (this.isShow == null ? 0 : this.isShow.hashCode())) * 31) + (this.itemsStep == null ? 0 : this.itemsStep.hashCode())) * 31) + (this.lessonId == null ? 0 : this.lessonId.hashCode())) * 31) + (this.limitBuy == null ? 0 : this.limitBuy.hashCode())) * 31) + (this.linePrice == null ? 0 : this.linePrice.hashCode())) * 31) + (this.preDepositPrice == null ? 0 : this.preDepositPrice.hashCode())) * 31) + (this.price == null ? 0 : this.price.hashCode())) * 31) + (this.referencePrice == null ? 0 : this.referencePrice.hashCode())) * 31) + (this.saleType == null ? 0 : this.saleType.hashCode())) * 31) + (this.skuTag == null ? 0 : this.skuTag.hashCode())) * 31) + (this.specValueId == null ? 0 : this.specValueId.hashCode())) * 31) + (this.specValues == null ? 0 : this.specValues.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.stock == null ? 0 : this.stock.hashCode())) * 31) + (this.stockLevel == null ? 0 : this.stockLevel.hashCode())) * 31) + (this.subStatus == null ? 0 : this.subStatus.hashCode())) * 31) + (this.warnStock == null ? 0 : this.warnStock.hashCode())) * 31) + (this.whiteListSku != null ? this.whiteListSku.hashCode() : 0);
            }

            public String toString() {
                String str = this.activityDeposit;
                String str2 = this.activityPrice;
                Integer num = this.activityRestriction;
                Integer num2 = this.activitySaleStatus;
                Integer num3 = this.activityStock;
                Byte b = this.activityType;
                Boolean bool = this.asyncSku;
                Integer num4 = this.autoOnSaleTime;
                Byte b2 = this.canAddCart;
                String str3 = this.deposit;
                Long l = this.id;
                String str4 = this.img;
                Byte b3 = this.isShow;
                Integer num5 = this.itemsStep;
                Long l2 = this.lessonId;
                Boolean bool2 = this.limitBuy;
                String str5 = this.linePrice;
                String str6 = this.preDepositPrice;
                String str7 = this.price;
                String str8 = this.referencePrice;
                Byte b4 = this.saleType;
                SkuTag skuTag = this.skuTag;
                Long l3 = this.specValueId;
                List<String> list = this.specValues;
                Byte b5 = this.status;
                Integer num6 = this.stock;
                Integer num7 = this.stockLevel;
                Byte b6 = this.subStatus;
                Integer num8 = this.warnStock;
                return "ItemsSkuListItem(activityDeposit=" + str + ", activityPrice=" + str2 + ", activityRestriction=" + num + ", activitySaleStatus=" + num2 + ", activityStock=" + num3 + ", activityType=" + b + ", asyncSku=" + bool + ", autoOnSaleTime=" + num4 + ", canAddCart=" + b2 + ", deposit=" + str3 + ", id=" + l + ", img=" + str4 + ", isShow=" + b3 + ", itemsStep=" + num5 + ", lessonId=" + l2 + ", limitBuy=" + bool2 + ", linePrice=" + str5 + ", preDepositPrice=" + str6 + ", price=" + str7 + ", referencePrice=" + str8 + ", saleType=" + b4 + ", skuTag=" + skuTag + ", specValueId=" + l3 + ", specValues=" + list + ", status=" + b5 + ", stock=" + num6 + ", stockLevel=" + num7 + ", subStatus=" + b6 + ", warnStock=" + num8 + ", whiteListSku=" + this.whiteListSku + ")";
            }

            /* compiled from: SkuInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<ItemsSkuListItem> serializer() {
                    return SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ ItemsSkuListItem(int seen0, String activityDeposit, String activityPrice, Integer activityRestriction, Integer activitySaleStatus, Integer activityStock, Byte activityType, Boolean asyncSku, Integer autoOnSaleTime, Byte canAddCart, String deposit, Long id, String img, Byte isShow, Integer itemsStep, Long lessonId, Boolean limitBuy, String linePrice, String preDepositPrice, String price, String referencePrice, Byte saleType, SkuTag skuTag, Long specValueId, List specValues, Byte status, Integer stock, Integer stockLevel, Byte subStatus, Integer warnStock, Boolean whiteListSku, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.activityDeposit = null;
                } else {
                    this.activityDeposit = activityDeposit;
                }
                if ((seen0 & 2) == 0) {
                    this.activityPrice = null;
                } else {
                    this.activityPrice = activityPrice;
                }
                if ((seen0 & 4) == 0) {
                    this.activityRestriction = null;
                } else {
                    this.activityRestriction = activityRestriction;
                }
                if ((seen0 & 8) == 0) {
                    this.activitySaleStatus = null;
                } else {
                    this.activitySaleStatus = activitySaleStatus;
                }
                if ((seen0 & 16) == 0) {
                    this.activityStock = null;
                } else {
                    this.activityStock = activityStock;
                }
                if ((seen0 & 32) == 0) {
                    this.activityType = null;
                } else {
                    this.activityType = activityType;
                }
                if ((seen0 & 64) == 0) {
                    this.asyncSku = null;
                } else {
                    this.asyncSku = asyncSku;
                }
                if ((seen0 & 128) == 0) {
                    this.autoOnSaleTime = null;
                } else {
                    this.autoOnSaleTime = autoOnSaleTime;
                }
                if ((seen0 & 256) == 0) {
                    this.canAddCart = null;
                } else {
                    this.canAddCart = canAddCart;
                }
                if ((seen0 & 512) == 0) {
                    this.deposit = null;
                } else {
                    this.deposit = deposit;
                }
                if ((seen0 & 1024) == 0) {
                    this.id = null;
                } else {
                    this.id = id;
                }
                if ((seen0 & 2048) == 0) {
                    this.img = null;
                } else {
                    this.img = img;
                }
                if ((seen0 & 4096) == 0) {
                    this.isShow = null;
                } else {
                    this.isShow = isShow;
                }
                if ((seen0 & 8192) == 0) {
                    this.itemsStep = null;
                } else {
                    this.itemsStep = itemsStep;
                }
                if ((seen0 & 16384) == 0) {
                    this.lessonId = null;
                } else {
                    this.lessonId = lessonId;
                }
                if ((seen0 & 32768) == 0) {
                    this.limitBuy = null;
                } else {
                    this.limitBuy = limitBuy;
                }
                if ((seen0 & 65536) == 0) {
                    this.linePrice = null;
                } else {
                    this.linePrice = linePrice;
                }
                if ((seen0 & 131072) == 0) {
                    this.preDepositPrice = null;
                } else {
                    this.preDepositPrice = preDepositPrice;
                }
                if ((seen0 & 262144) == 0) {
                    this.price = null;
                } else {
                    this.price = price;
                }
                if ((seen0 & 524288) == 0) {
                    this.referencePrice = null;
                } else {
                    this.referencePrice = referencePrice;
                }
                if ((seen0 & 1048576) == 0) {
                    this.saleType = null;
                } else {
                    this.saleType = saleType;
                }
                if ((seen0 & 2097152) == 0) {
                    this.skuTag = null;
                } else {
                    this.skuTag = skuTag;
                }
                if ((seen0 & 4194304) == 0) {
                    this.specValueId = null;
                } else {
                    this.specValueId = specValueId;
                }
                if ((seen0 & 8388608) == 0) {
                    this.specValues = null;
                } else {
                    this.specValues = specValues;
                }
                if ((seen0 & 16777216) == 0) {
                    this.status = null;
                } else {
                    this.status = status;
                }
                if ((seen0 & 33554432) == 0) {
                    this.stock = null;
                } else {
                    this.stock = stock;
                }
                if ((seen0 & 67108864) == 0) {
                    this.stockLevel = null;
                } else {
                    this.stockLevel = stockLevel;
                }
                if ((seen0 & 134217728) == 0) {
                    this.subStatus = null;
                } else {
                    this.subStatus = subStatus;
                }
                if ((seen0 & 268435456) == 0) {
                    this.warnStock = null;
                } else {
                    this.warnStock = warnStock;
                }
                if ((seen0 & 536870912) == 0) {
                    this.whiteListSku = null;
                } else {
                    this.whiteListSku = whiteListSku;
                }
            }

            public ItemsSkuListItem(String activityDeposit, String activityPrice, Integer activityRestriction, Integer activitySaleStatus, Integer activityStock, Byte activityType, Boolean asyncSku, Integer autoOnSaleTime, Byte canAddCart, String deposit, Long id, String img, Byte isShow, Integer itemsStep, Long lessonId, Boolean limitBuy, String linePrice, String preDepositPrice, String price, String referencePrice, Byte saleType, SkuTag skuTag, Long specValueId, List<String> list, Byte status, Integer stock, Integer stockLevel, Byte subStatus, Integer warnStock, Boolean whiteListSku) {
                this.activityDeposit = activityDeposit;
                this.activityPrice = activityPrice;
                this.activityRestriction = activityRestriction;
                this.activitySaleStatus = activitySaleStatus;
                this.activityStock = activityStock;
                this.activityType = activityType;
                this.asyncSku = asyncSku;
                this.autoOnSaleTime = autoOnSaleTime;
                this.canAddCart = canAddCart;
                this.deposit = deposit;
                this.id = id;
                this.img = img;
                this.isShow = isShow;
                this.itemsStep = itemsStep;
                this.lessonId = lessonId;
                this.limitBuy = limitBuy;
                this.linePrice = linePrice;
                this.preDepositPrice = preDepositPrice;
                this.price = price;
                this.referencePrice = referencePrice;
                this.saleType = saleType;
                this.skuTag = skuTag;
                this.specValueId = specValueId;
                this.specValues = list;
                this.status = status;
                this.stock = stock;
                this.stockLevel = stockLevel;
                this.subStatus = subStatus;
                this.warnStock = warnStock;
                this.whiteListSku = whiteListSku;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(StringSerializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(ItemsSkuListItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activityDeposit != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.activityDeposit);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.activityPrice != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.activityPrice);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.activityRestriction != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.activityRestriction);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.activitySaleStatus != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.activitySaleStatus);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.activityStock != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.activityStock);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.activityType != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, ByteSerializer.INSTANCE, self.activityType);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.asyncSku != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.asyncSku);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.autoOnSaleTime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, IntSerializer.INSTANCE, self.autoOnSaleTime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.canAddCart != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, ByteSerializer.INSTANCE, self.canAddCart);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.deposit != null) {
                    output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.deposit);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 10) || self.id != null) {
                    output.encodeNullableSerializableElement(serialDesc, 10, LongSerializer.INSTANCE, self.id);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 11) || self.img != null) {
                    output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.img);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 12) || self.isShow != null) {
                    output.encodeNullableSerializableElement(serialDesc, 12, ByteSerializer.INSTANCE, self.isShow);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 13) || self.itemsStep != null) {
                    output.encodeNullableSerializableElement(serialDesc, 13, IntSerializer.INSTANCE, self.itemsStep);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 14) || self.lessonId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 14, LongSerializer.INSTANCE, self.lessonId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 15) || self.limitBuy != null) {
                    output.encodeNullableSerializableElement(serialDesc, 15, BooleanSerializer.INSTANCE, self.limitBuy);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 16) || self.linePrice != null) {
                    output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.linePrice);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 17) || self.preDepositPrice != null) {
                    output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.preDepositPrice);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 18) || self.price != null) {
                    output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.price);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 19) || self.referencePrice != null) {
                    output.encodeNullableSerializableElement(serialDesc, 19, StringSerializer.INSTANCE, self.referencePrice);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 20) || self.saleType != null) {
                    output.encodeNullableSerializableElement(serialDesc, 20, ByteSerializer.INSTANCE, self.saleType);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 21) || self.skuTag != null) {
                    output.encodeNullableSerializableElement(serialDesc, 21, SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag$$serializer.INSTANCE, self.skuTag);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 22) || self.specValueId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 22, LongSerializer.INSTANCE, self.specValueId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 23) || self.specValues != null) {
                    output.encodeNullableSerializableElement(serialDesc, 23, lazyArr[23].getValue(), self.specValues);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 24) || self.status != null) {
                    output.encodeNullableSerializableElement(serialDesc, 24, ByteSerializer.INSTANCE, self.status);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 25) || self.stock != null) {
                    output.encodeNullableSerializableElement(serialDesc, 25, IntSerializer.INSTANCE, self.stock);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 26) || self.stockLevel != null) {
                    output.encodeNullableSerializableElement(serialDesc, 26, IntSerializer.INSTANCE, self.stockLevel);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 27) || self.subStatus != null) {
                    output.encodeNullableSerializableElement(serialDesc, 27, ByteSerializer.INSTANCE, self.subStatus);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 28) || self.warnStock != null) {
                    output.encodeNullableSerializableElement(serialDesc, 28, IntSerializer.INSTANCE, self.warnStock);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 29) || self.whiteListSku != null) {
                    output.encodeNullableSerializableElement(serialDesc, 29, BooleanSerializer.INSTANCE, self.whiteListSku);
                }
            }

            public /* synthetic */ ItemsSkuListItem(String str, String str2, Integer num, Integer num2, Integer num3, Byte b, Boolean bool, Integer num4, Byte b2, String str3, Long l, String str4, Byte b3, Integer num5, Long l2, Boolean bool2, String str5, String str6, String str7, String str8, Byte b4, SkuTag skuTag, Long l3, List list, Byte b5, Integer num6, Integer num7, Byte b6, Integer num8, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : b, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : num4, (i & 256) != 0 ? null : b2, (i & 512) != 0 ? null : str3, (i & 1024) != 0 ? null : l, (i & 2048) != 0 ? null : str4, (i & 4096) != 0 ? null : b3, (i & 8192) != 0 ? null : num5, (i & 16384) != 0 ? null : l2, (i & 32768) != 0 ? null : bool2, (i & 65536) != 0 ? null : str5, (i & 131072) != 0 ? null : str6, (i & 262144) != 0 ? null : str7, (i & 524288) != 0 ? null : str8, (i & 1048576) != 0 ? null : b4, (i & 2097152) != 0 ? null : skuTag, (i & 4194304) != 0 ? null : l3, (i & 8388608) != 0 ? null : list, (i & 16777216) != 0 ? null : b5, (i & 33554432) != 0 ? null : num6, (i & 67108864) != 0 ? null : num7, (i & 134217728) != 0 ? null : b6, (i & 268435456) != 0 ? null : num8, (i & 536870912) != 0 ? null : bool3);
            }

            public final String getActivityDeposit() {
                return this.activityDeposit;
            }

            public final String getActivityPrice() {
                return this.activityPrice;
            }

            public final Integer getActivityRestriction() {
                return this.activityRestriction;
            }

            public final Integer getActivitySaleStatus() {
                return this.activitySaleStatus;
            }

            public final Integer getActivityStock() {
                return this.activityStock;
            }

            public final Byte getActivityType() {
                return this.activityType;
            }

            public final Boolean getAsyncSku() {
                return this.asyncSku;
            }

            public final Integer getAutoOnSaleTime() {
                return this.autoOnSaleTime;
            }

            public final Byte getCanAddCart() {
                return this.canAddCart;
            }

            public final String getDeposit() {
                return this.deposit;
            }

            public final Long getId() {
                return this.id;
            }

            public final String getImg() {
                return this.img;
            }

            public final Byte isShow() {
                return this.isShow;
            }

            public final Integer getItemsStep() {
                return this.itemsStep;
            }

            public final Long getLessonId() {
                return this.lessonId;
            }

            public final Boolean getLimitBuy() {
                return this.limitBuy;
            }

            public final String getLinePrice() {
                return this.linePrice;
            }

            public final String getPreDepositPrice() {
                return this.preDepositPrice;
            }

            public final String getPrice() {
                return this.price;
            }

            public final String getReferencePrice() {
                return this.referencePrice;
            }

            public final Byte getSaleType() {
                return this.saleType;
            }

            public final SkuTag getSkuTag() {
                return this.skuTag;
            }

            public final Long getSpecValueId() {
                return this.specValueId;
            }

            public final List<String> getSpecValues() {
                return this.specValues;
            }

            public final Byte getStatus() {
                return this.status;
            }

            public final Integer getStock() {
                return this.stock;
            }

            public final Integer getStockLevel() {
                return this.stockLevel;
            }

            public final Byte getSubStatus() {
                return this.subStatus;
            }

            public final Integer getWarnStock() {
                return this.warnStock;
            }

            /* compiled from: SkuInfoFloor.kt */
            @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0003\u001e\u001f B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\bHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag;", "", "activityTagList", "", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag$ActivityTag;", "<init>", "(Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityTagList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ActivityTag", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class SkuTag {
                private final List<ActivityTag> activityTagList;
                public static final Companion Companion = new Companion(null);
                public static final int $stable = 8;
                private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_;
                        _childSerializers$_anonymous_ = SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem.SkuTag._childSerializers$_anonymous_();
                        return _childSerializers$_anonymous_;
                    }
                })};

                public SkuTag() {
                    this((List) null, 1, (DefaultConstructorMarker) null);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ SkuTag copy$default(SkuTag skuTag, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = skuTag.activityTagList;
                    }
                    return skuTag.copy(list);
                }

                public final List<ActivityTag> component1() {
                    return this.activityTagList;
                }

                public final SkuTag copy(List<ActivityTag> list) {
                    return new SkuTag(list);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof SkuTag) && Intrinsics.areEqual(this.activityTagList, ((SkuTag) obj).activityTagList);
                }

                public int hashCode() {
                    if (this.activityTagList == null) {
                        return 0;
                    }
                    return this.activityTagList.hashCode();
                }

                public String toString() {
                    return "SkuTag(activityTagList=" + this.activityTagList + ")";
                }

                /* compiled from: SkuInfoFloor.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<SkuTag> serializer() {
                        return SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ SkuTag(int seen0, List activityTagList, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.activityTagList = null;
                    } else {
                        this.activityTagList = activityTagList;
                    }
                }

                public SkuTag(List<ActivityTag> list) {
                    this.activityTagList = list;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new ArrayListSerializer(SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag$ActivityTag$$serializer.INSTANCE);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(SkuTag self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                    boolean z = true;
                    if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.activityTagList == null) {
                        z = false;
                    }
                    if (z) {
                        output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.activityTagList);
                    }
                }

                public /* synthetic */ SkuTag(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : list);
                }

                /* compiled from: SkuInfoFloor.kt */
                @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J>\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006-"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag$ActivityTag;", "", "activityId", "", "marketingId", "", "name", "type", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMarketingId", "()Ljava/lang/String;", "getName", "getType", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Byte;)Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag$ActivityTag;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                @Serializable
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class ActivityTag {
                    public static final int $stable = 0;
                    public static final Companion Companion = new Companion(null);
                    private final Integer activityId;
                    private final String marketingId;
                    private final String name;
                    private final Byte type;

                    public ActivityTag() {
                        this((Integer) null, (String) null, (String) null, (Byte) null, 15, (DefaultConstructorMarker) null);
                    }

                    public static /* synthetic */ ActivityTag copy$default(ActivityTag activityTag, Integer num, String str, String str2, Byte b, int i, Object obj) {
                        if ((i & 1) != 0) {
                            num = activityTag.activityId;
                        }
                        if ((i & 2) != 0) {
                            str = activityTag.marketingId;
                        }
                        if ((i & 4) != 0) {
                            str2 = activityTag.name;
                        }
                        if ((i & 8) != 0) {
                            b = activityTag.type;
                        }
                        return activityTag.copy(num, str, str2, b);
                    }

                    public final Integer component1() {
                        return this.activityId;
                    }

                    public final String component2() {
                        return this.marketingId;
                    }

                    public final String component3() {
                        return this.name;
                    }

                    public final Byte component4() {
                        return this.type;
                    }

                    public final ActivityTag copy(Integer num, String str, String str2, Byte b) {
                        return new ActivityTag(num, str, str2, b);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof ActivityTag) {
                            ActivityTag activityTag = (ActivityTag) obj;
                            return Intrinsics.areEqual(this.activityId, activityTag.activityId) && Intrinsics.areEqual(this.marketingId, activityTag.marketingId) && Intrinsics.areEqual(this.name, activityTag.name) && Intrinsics.areEqual(this.type, activityTag.type);
                        }
                        return false;
                    }

                    public int hashCode() {
                        return ((((((this.activityId == null ? 0 : this.activityId.hashCode()) * 31) + (this.marketingId == null ? 0 : this.marketingId.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
                    }

                    public String toString() {
                        Integer num = this.activityId;
                        String str = this.marketingId;
                        String str2 = this.name;
                        return "ActivityTag(activityId=" + num + ", marketingId=" + str + ", name=" + str2 + ", type=" + this.type + ")";
                    }

                    /* compiled from: SkuInfoFloor.kt */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag$ActivityTag$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag$ActivityTag;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer<ActivityTag> serializer() {
                            return SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem$SkuTag$ActivityTag$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ ActivityTag(int seen0, Integer activityId, String marketingId, String name, Byte type, SerializationConstructorMarker serializationConstructorMarker) {
                        if ((seen0 & 1) == 0) {
                            this.activityId = null;
                        } else {
                            this.activityId = activityId;
                        }
                        if ((seen0 & 2) == 0) {
                            this.marketingId = null;
                        } else {
                            this.marketingId = marketingId;
                        }
                        if ((seen0 & 4) == 0) {
                            this.name = null;
                        } else {
                            this.name = name;
                        }
                        if ((seen0 & 8) == 0) {
                            this.type = null;
                        } else {
                            this.type = type;
                        }
                    }

                    public ActivityTag(Integer activityId, String marketingId, String name, Byte type) {
                        this.activityId = activityId;
                        this.marketingId = marketingId;
                        this.name = name;
                        this.type = type;
                    }

                    @JvmStatic
                    public static final /* synthetic */ void write$Self$product_details_page_debug(ActivityTag self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activityId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.activityId);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.marketingId != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.marketingId);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.name != null) {
                            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.name);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.type != null) {
                            output.encodeNullableSerializableElement(serialDesc, 3, ByteSerializer.INSTANCE, self.type);
                        }
                    }

                    public /* synthetic */ ActivityTag(Integer num, String str, String str2, Byte b, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : b);
                    }

                    public final Integer getActivityId() {
                        return this.activityId;
                    }

                    public final String getMarketingId() {
                        return this.marketingId;
                    }

                    public final String getName() {
                        return this.name;
                    }

                    public final Byte getType() {
                        return this.type;
                    }
                }

                public final List<ActivityTag> getActivityTagList() {
                    return this.activityTagList;
                }
            }

            public final Boolean getWhiteListSku() {
                return this.whiteListSku;
            }
        }

        public final List<String> getSpecs() {
            return this.specs;
        }

        /* compiled from: SkuInfoFloor.kt */
        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0003()*B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J8\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006+"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem;", "", "specId", "", "specName", "", "specValueVOList", "", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem$SpecValueListItem;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSpecId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSpecName", "()Ljava/lang/String;", "getSpecValueVOList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "SpecValueListItem", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class SpecInfoListItem {
            private final Integer specId;
            private final String specName;
            private final List<SpecValueListItem> specValueVOList;
            public static final Companion Companion = new Companion(null);
            public static final int $stable = 8;
            private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem$$ExternalSyntheticLambda0
                public final Object invoke() {
                    KSerializer _childSerializers$_anonymous_;
                    _childSerializers$_anonymous_ = SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem._childSerializers$_anonymous_();
                    return _childSerializers$_anonymous_;
                }
            })};

            public SpecInfoListItem() {
                this((Integer) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SpecInfoListItem copy$default(SpecInfoListItem specInfoListItem, Integer num, String str, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    num = specInfoListItem.specId;
                }
                if ((i & 2) != 0) {
                    str = specInfoListItem.specName;
                }
                if ((i & 4) != 0) {
                    list = specInfoListItem.specValueVOList;
                }
                return specInfoListItem.copy(num, str, list);
            }

            public final Integer component1() {
                return this.specId;
            }

            public final String component2() {
                return this.specName;
            }

            public final List<SpecValueListItem> component3() {
                return this.specValueVOList;
            }

            public final SpecInfoListItem copy(Integer num, String str, List<SpecValueListItem> list) {
                return new SpecInfoListItem(num, str, list);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof SpecInfoListItem) {
                    SpecInfoListItem specInfoListItem = (SpecInfoListItem) obj;
                    return Intrinsics.areEqual(this.specId, specInfoListItem.specId) && Intrinsics.areEqual(this.specName, specInfoListItem.specName) && Intrinsics.areEqual(this.specValueVOList, specInfoListItem.specValueVOList);
                }
                return false;
            }

            public int hashCode() {
                return ((((this.specId == null ? 0 : this.specId.hashCode()) * 31) + (this.specName == null ? 0 : this.specName.hashCode())) * 31) + (this.specValueVOList != null ? this.specValueVOList.hashCode() : 0);
            }

            public String toString() {
                Integer num = this.specId;
                String str = this.specName;
                return "SpecInfoListItem(specId=" + num + ", specName=" + str + ", specValueVOList=" + this.specValueVOList + ")";
            }

            /* compiled from: SkuInfoFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<SpecInfoListItem> serializer() {
                    return SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ SpecInfoListItem(int seen0, Integer specId, String specName, List specValueVOList, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.specId = null;
                } else {
                    this.specId = specId;
                }
                if ((seen0 & 2) == 0) {
                    this.specName = null;
                } else {
                    this.specName = specName;
                }
                if ((seen0 & 4) == 0) {
                    this.specValueVOList = null;
                } else {
                    this.specValueVOList = specValueVOList;
                }
            }

            public SpecInfoListItem(Integer specId, String specName, List<SpecValueListItem> list) {
                this.specId = specId;
                this.specName = specName;
                this.specValueVOList = list;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem$SpecValueListItem$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(SpecInfoListItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.specId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.specId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.specName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.specName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.specValueVOList != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.specValueVOList);
                }
            }

            public /* synthetic */ SpecInfoListItem(Integer num, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list);
            }

            public final Integer getSpecId() {
                return this.specId;
            }

            public final String getSpecName() {
                return this.specName;
            }

            /* compiled from: SkuInfoFloor.kt */
            @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006("}, d2 = {"Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem$SpecValueListItem;", "", "specId", "", "specValueImg", "", "specValueName", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSpecId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSpecValueImg", "()Ljava/lang/String;", "getSpecValueName", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem$SpecValueListItem;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class SpecValueListItem {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final Long specId;
                private final String specValueImg;
                private final String specValueName;

                public SpecValueListItem() {
                    this((Long) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ SpecValueListItem copy$default(SpecValueListItem specValueListItem, Long l, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        l = specValueListItem.specId;
                    }
                    if ((i & 2) != 0) {
                        str = specValueListItem.specValueImg;
                    }
                    if ((i & 4) != 0) {
                        str2 = specValueListItem.specValueName;
                    }
                    return specValueListItem.copy(l, str, str2);
                }

                public final Long component1() {
                    return this.specId;
                }

                public final String component2() {
                    return this.specValueImg;
                }

                public final String component3() {
                    return this.specValueName;
                }

                public final SpecValueListItem copy(Long l, String str, String str2) {
                    return new SpecValueListItem(l, str, str2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof SpecValueListItem) {
                        SpecValueListItem specValueListItem = (SpecValueListItem) obj;
                        return Intrinsics.areEqual(this.specId, specValueListItem.specId) && Intrinsics.areEqual(this.specValueImg, specValueListItem.specValueImg) && Intrinsics.areEqual(this.specValueName, specValueListItem.specValueName);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((((this.specId == null ? 0 : this.specId.hashCode()) * 31) + (this.specValueImg == null ? 0 : this.specValueImg.hashCode())) * 31) + (this.specValueName != null ? this.specValueName.hashCode() : 0);
                }

                public String toString() {
                    Long l = this.specId;
                    String str = this.specValueImg;
                    return "SpecValueListItem(specId=" + l + ", specValueImg=" + str + ", specValueName=" + this.specValueName + ")";
                }

                /* compiled from: SkuInfoFloor.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem$SpecValueListItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem$SpecValueListItem;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<SpecValueListItem> serializer() {
                        return SkuInfoFloor$ItemsSkuListVO$SpecInfoListItem$SpecValueListItem$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ SpecValueListItem(int seen0, Long specId, String specValueImg, String specValueName, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.specId = null;
                    } else {
                        this.specId = specId;
                    }
                    if ((seen0 & 2) == 0) {
                        this.specValueImg = null;
                    } else {
                        this.specValueImg = specValueImg;
                    }
                    if ((seen0 & 4) == 0) {
                        this.specValueName = null;
                    } else {
                        this.specValueName = specValueName;
                    }
                }

                public SpecValueListItem(Long specId, String specValueImg, String specValueName) {
                    this.specId = specId;
                    this.specValueImg = specValueImg;
                    this.specValueName = specValueName;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(SpecValueListItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.specId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.specId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.specValueImg != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.specValueImg);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.specValueName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.specValueName);
                    }
                }

                public /* synthetic */ SpecValueListItem(Long l, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
                }

                public final Long getSpecId() {
                    return this.specId;
                }

                public final String getSpecValueImg() {
                    return this.specValueImg;
                }

                public final String getSpecValueName() {
                    return this.specValueName;
                }
            }

            public final List<SpecValueListItem> getSpecValueVOList() {
                return this.specValueVOList;
            }
        }
    }
}