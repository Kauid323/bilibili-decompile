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

/* compiled from: CrowdfundingAtmosFloor.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fBW\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003JQ\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u000eHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017¨\u00062"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingAtmosFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "backImg", "Lkntr/app/mall/product/details/page/api/model/ImageColorModel;", "countDownInfoVO", "Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;", "labelImg", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ImageColorModel;Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;Lkntr/app/mall/product/details/page/api/model/ImageColorModel;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ImageColorModel;Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;Lkntr/app/mall/product/details/page/api/model/ImageColorModel;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getBackImg", "()Lkntr/app/mall/product/details/page/api/model/ImageColorModel;", "getCountDownInfoVO", "()Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;", "getLabelImg", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class CrowdfundingAtmosFloor implements FloorModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final ImageColorModel backImg;
    private final String bgImgUrl;
    private final CountDownInfoVO countDownInfoVO;
    private final String floorIcon;
    private final String floorKey;
    private final ImageColorModel labelImg;

    public CrowdfundingAtmosFloor() {
        this((String) null, (String) null, (String) null, (ImageColorModel) null, (CountDownInfoVO) null, (ImageColorModel) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CrowdfundingAtmosFloor copy$default(CrowdfundingAtmosFloor crowdfundingAtmosFloor, String str, String str2, String str3, ImageColorModel imageColorModel, CountDownInfoVO countDownInfoVO, ImageColorModel imageColorModel2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = crowdfundingAtmosFloor.floorKey;
        }
        if ((i & 2) != 0) {
            str2 = crowdfundingAtmosFloor.floorIcon;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = crowdfundingAtmosFloor.bgImgUrl;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            imageColorModel = crowdfundingAtmosFloor.backImg;
        }
        ImageColorModel imageColorModel3 = imageColorModel;
        if ((i & 16) != 0) {
            countDownInfoVO = crowdfundingAtmosFloor.countDownInfoVO;
        }
        CountDownInfoVO countDownInfoVO2 = countDownInfoVO;
        if ((i & 32) != 0) {
            imageColorModel2 = crowdfundingAtmosFloor.labelImg;
        }
        return crowdfundingAtmosFloor.copy(str, str4, str5, imageColorModel3, countDownInfoVO2, imageColorModel2);
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

    public final ImageColorModel component4() {
        return this.backImg;
    }

    public final CountDownInfoVO component5() {
        return this.countDownInfoVO;
    }

    public final ImageColorModel component6() {
        return this.labelImg;
    }

    public final CrowdfundingAtmosFloor copy(String str, String str2, String str3, ImageColorModel imageColorModel, CountDownInfoVO countDownInfoVO, ImageColorModel imageColorModel2) {
        return new CrowdfundingAtmosFloor(str, str2, str3, imageColorModel, countDownInfoVO, imageColorModel2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CrowdfundingAtmosFloor) {
            CrowdfundingAtmosFloor crowdfundingAtmosFloor = (CrowdfundingAtmosFloor) obj;
            return Intrinsics.areEqual(this.floorKey, crowdfundingAtmosFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, crowdfundingAtmosFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, crowdfundingAtmosFloor.bgImgUrl) && Intrinsics.areEqual(this.backImg, crowdfundingAtmosFloor.backImg) && Intrinsics.areEqual(this.countDownInfoVO, crowdfundingAtmosFloor.countDownInfoVO) && Intrinsics.areEqual(this.labelImg, crowdfundingAtmosFloor.labelImg);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.backImg == null ? 0 : this.backImg.hashCode())) * 31) + (this.countDownInfoVO == null ? 0 : this.countDownInfoVO.hashCode())) * 31) + (this.labelImg != null ? this.labelImg.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        ImageColorModel imageColorModel = this.backImg;
        CountDownInfoVO countDownInfoVO = this.countDownInfoVO;
        return "CrowdfundingAtmosFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", backImg=" + imageColorModel + ", countDownInfoVO=" + countDownInfoVO + ", labelImg=" + this.labelImg + ")";
    }

    /* compiled from: CrowdfundingAtmosFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingAtmosFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingAtmosFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CrowdfundingAtmosFloor> serializer() {
            return CrowdfundingAtmosFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CrowdfundingAtmosFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, ImageColorModel backImg, CountDownInfoVO countDownInfoVO, ImageColorModel labelImg, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.backImg = null;
        } else {
            this.backImg = backImg;
        }
        if ((seen0 & 16) == 0) {
            this.countDownInfoVO = null;
        } else {
            this.countDownInfoVO = countDownInfoVO;
        }
        if ((seen0 & 32) == 0) {
            this.labelImg = null;
        } else {
            this.labelImg = labelImg;
        }
    }

    public CrowdfundingAtmosFloor(String floorKey, String floorIcon, String bgImgUrl, ImageColorModel backImg, CountDownInfoVO countDownInfoVO, ImageColorModel labelImg) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.backImg = backImg;
        this.countDownInfoVO = countDownInfoVO;
        this.labelImg = labelImg;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(CrowdfundingAtmosFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.getFloorKey() != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.getFloorKey());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getFloorIcon() != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getFloorIcon());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getBgImgUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getBgImgUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.backImg != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, ImageColorModel$$serializer.INSTANCE, self.backImg);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.countDownInfoVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, CountDownInfoVO$$serializer.INSTANCE, self.countDownInfoVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.labelImg != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, ImageColorModel$$serializer.INSTANCE, self.labelImg);
        }
    }

    public /* synthetic */ CrowdfundingAtmosFloor(String str, String str2, String str3, ImageColorModel imageColorModel, CountDownInfoVO countDownInfoVO, ImageColorModel imageColorModel2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : imageColorModel, (i & 16) != 0 ? null : countDownInfoVO, (i & 32) != 0 ? null : imageColorModel2);
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

    public final ImageColorModel getBackImg() {
        return this.backImg;
    }

    public final CountDownInfoVO getCountDownInfoVO() {
        return this.countDownInfoVO;
    }

    public final ImageColorModel getLabelImg() {
        return this.labelImg;
    }
}