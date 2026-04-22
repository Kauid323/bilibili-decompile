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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AtmospherePriceFloor.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\rHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006/"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/AtmospherePriceFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "actAtmosphereVO", "Lkntr/app/mall/product/details/page/api/model/ActAtmosphereVO;", "priceVO", "Lkntr/app/mall/product/details/page/api/model/PriceVO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ActAtmosphereVO;Lkntr/app/mall/product/details/page/api/model/PriceVO;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ActAtmosphereVO;Lkntr/app/mall/product/details/page/api/model/PriceVO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getActAtmosphereVO", "()Lkntr/app/mall/product/details/page/api/model/ActAtmosphereVO;", "getPriceVO", "()Lkntr/app/mall/product/details/page/api/model/PriceVO;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class AtmospherePriceFloor implements FloorModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final ActAtmosphereVO actAtmosphereVO;
    private final String bgImgUrl;
    private final String floorIcon;
    private final String floorKey;
    private final PriceVO priceVO;

    public AtmospherePriceFloor() {
        this((String) null, (String) null, (String) null, (ActAtmosphereVO) null, (PriceVO) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AtmospherePriceFloor copy$default(AtmospherePriceFloor atmospherePriceFloor, String str, String str2, String str3, ActAtmosphereVO actAtmosphereVO, PriceVO priceVO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = atmospherePriceFloor.floorKey;
        }
        if ((i & 2) != 0) {
            str2 = atmospherePriceFloor.floorIcon;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = atmospherePriceFloor.bgImgUrl;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            actAtmosphereVO = atmospherePriceFloor.actAtmosphereVO;
        }
        ActAtmosphereVO actAtmosphereVO2 = actAtmosphereVO;
        if ((i & 16) != 0) {
            priceVO = atmospherePriceFloor.priceVO;
        }
        return atmospherePriceFloor.copy(str, str4, str5, actAtmosphereVO2, priceVO);
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

    public final ActAtmosphereVO component4() {
        return this.actAtmosphereVO;
    }

    public final PriceVO component5() {
        return this.priceVO;
    }

    public final AtmospherePriceFloor copy(String str, String str2, String str3, ActAtmosphereVO actAtmosphereVO, PriceVO priceVO) {
        return new AtmospherePriceFloor(str, str2, str3, actAtmosphereVO, priceVO);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AtmospherePriceFloor) {
            AtmospherePriceFloor atmospherePriceFloor = (AtmospherePriceFloor) obj;
            return Intrinsics.areEqual(this.floorKey, atmospherePriceFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, atmospherePriceFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, atmospherePriceFloor.bgImgUrl) && Intrinsics.areEqual(this.actAtmosphereVO, atmospherePriceFloor.actAtmosphereVO) && Intrinsics.areEqual(this.priceVO, atmospherePriceFloor.priceVO);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.actAtmosphereVO == null ? 0 : this.actAtmosphereVO.hashCode())) * 31) + (this.priceVO != null ? this.priceVO.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        ActAtmosphereVO actAtmosphereVO = this.actAtmosphereVO;
        return "AtmospherePriceFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", actAtmosphereVO=" + actAtmosphereVO + ", priceVO=" + this.priceVO + ")";
    }

    /* compiled from: AtmospherePriceFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/AtmospherePriceFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/AtmospherePriceFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AtmospherePriceFloor> serializer() {
            return AtmospherePriceFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AtmospherePriceFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, ActAtmosphereVO actAtmosphereVO, PriceVO priceVO, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.actAtmosphereVO = null;
        } else {
            this.actAtmosphereVO = actAtmosphereVO;
        }
        if ((seen0 & 16) == 0) {
            this.priceVO = null;
        } else {
            this.priceVO = priceVO;
        }
    }

    public AtmospherePriceFloor(String floorKey, String floorIcon, String bgImgUrl, ActAtmosphereVO actAtmosphereVO, PriceVO priceVO) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.actAtmosphereVO = actAtmosphereVO;
        this.priceVO = priceVO;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(AtmospherePriceFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.getFloorKey() != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.getFloorKey());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getFloorIcon() != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getFloorIcon());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getBgImgUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getBgImgUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.actAtmosphereVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, ActAtmosphereVO$$serializer.INSTANCE, self.actAtmosphereVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.priceVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, PriceVO$$serializer.INSTANCE, self.priceVO);
        }
    }

    public /* synthetic */ AtmospherePriceFloor(String str, String str2, String str3, ActAtmosphereVO actAtmosphereVO, PriceVO priceVO, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : actAtmosphereVO, (i & 16) != 0 ? null : priceVO);
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

    public final ActAtmosphereVO getActAtmosphereVO() {
        return this.actAtmosphereVO;
    }

    public final PriceVO getPriceVO() {
        return this.priceVO;
    }
}