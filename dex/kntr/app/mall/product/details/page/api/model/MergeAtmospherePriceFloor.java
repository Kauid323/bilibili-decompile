package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.MergeAtmospherePriceFloor;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: MergeAtmospherePriceFloor.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0004-./0BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\rHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u00061"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "mergeAtmosphereVO", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergeAtmosphere;", "mergePriceInfoVO", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergeAtmosphere;Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergeAtmosphere;Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getMergeAtmosphereVO", "()Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergeAtmosphere;", "getMergePriceInfoVO", "()Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "MergeAtmosphere", "MergePriceInfo", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class MergeAtmospherePriceFloor implements FloorModel {
    private final String bgImgUrl;
    private final String floorIcon;
    private final String floorKey;
    private final MergeAtmosphere mergeAtmosphereVO;
    private final MergePriceInfo mergePriceInfoVO;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public MergeAtmospherePriceFloor() {
        this((String) null, (String) null, (String) null, (MergeAtmosphere) null, (MergePriceInfo) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MergeAtmospherePriceFloor copy$default(MergeAtmospherePriceFloor mergeAtmospherePriceFloor, String str, String str2, String str3, MergeAtmosphere mergeAtmosphere, MergePriceInfo mergePriceInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mergeAtmospherePriceFloor.floorKey;
        }
        if ((i & 2) != 0) {
            str2 = mergeAtmospherePriceFloor.floorIcon;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = mergeAtmospherePriceFloor.bgImgUrl;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            mergeAtmosphere = mergeAtmospherePriceFloor.mergeAtmosphereVO;
        }
        MergeAtmosphere mergeAtmosphere2 = mergeAtmosphere;
        if ((i & 16) != 0) {
            mergePriceInfo = mergeAtmospherePriceFloor.mergePriceInfoVO;
        }
        return mergeAtmospherePriceFloor.copy(str, str4, str5, mergeAtmosphere2, mergePriceInfo);
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

    public final MergeAtmosphere component4() {
        return this.mergeAtmosphereVO;
    }

    public final MergePriceInfo component5() {
        return this.mergePriceInfoVO;
    }

    public final MergeAtmospherePriceFloor copy(String str, String str2, String str3, MergeAtmosphere mergeAtmosphere, MergePriceInfo mergePriceInfo) {
        return new MergeAtmospherePriceFloor(str, str2, str3, mergeAtmosphere, mergePriceInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MergeAtmospherePriceFloor) {
            MergeAtmospherePriceFloor mergeAtmospherePriceFloor = (MergeAtmospherePriceFloor) obj;
            return Intrinsics.areEqual(this.floorKey, mergeAtmospherePriceFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, mergeAtmospherePriceFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, mergeAtmospherePriceFloor.bgImgUrl) && Intrinsics.areEqual(this.mergeAtmosphereVO, mergeAtmospherePriceFloor.mergeAtmosphereVO) && Intrinsics.areEqual(this.mergePriceInfoVO, mergeAtmospherePriceFloor.mergePriceInfoVO);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.mergeAtmosphereVO == null ? 0 : this.mergeAtmosphereVO.hashCode())) * 31) + (this.mergePriceInfoVO != null ? this.mergePriceInfoVO.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        MergeAtmosphere mergeAtmosphere = this.mergeAtmosphereVO;
        return "MergeAtmospherePriceFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", mergeAtmosphereVO=" + mergeAtmosphere + ", mergePriceInfoVO=" + this.mergePriceInfoVO + ")";
    }

    /* compiled from: MergeAtmospherePriceFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MergeAtmospherePriceFloor> serializer() {
            return MergeAtmospherePriceFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ MergeAtmospherePriceFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, MergeAtmosphere mergeAtmosphereVO, MergePriceInfo mergePriceInfoVO, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.mergeAtmosphereVO = null;
        } else {
            this.mergeAtmosphereVO = mergeAtmosphereVO;
        }
        if ((seen0 & 16) == 0) {
            this.mergePriceInfoVO = null;
        } else {
            this.mergePriceInfoVO = mergePriceInfoVO;
        }
    }

    public MergeAtmospherePriceFloor(String floorKey, String floorIcon, String bgImgUrl, MergeAtmosphere mergeAtmosphereVO, MergePriceInfo mergePriceInfoVO) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.mergeAtmosphereVO = mergeAtmosphereVO;
        this.mergePriceInfoVO = mergePriceInfoVO;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(MergeAtmospherePriceFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.getFloorKey() != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.getFloorKey());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getFloorIcon() != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getFloorIcon());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getBgImgUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getBgImgUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.mergeAtmosphereVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, MergeAtmospherePriceFloor$MergeAtmosphere$$serializer.INSTANCE, self.mergeAtmosphereVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.mergePriceInfoVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, MergeAtmospherePriceFloor$MergePriceInfo$$serializer.INSTANCE, self.mergePriceInfoVO);
        }
    }

    public /* synthetic */ MergeAtmospherePriceFloor(String str, String str2, String str3, MergeAtmosphere mergeAtmosphere, MergePriceInfo mergePriceInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : mergeAtmosphere, (i & 16) != 0 ? null : mergePriceInfo);
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

    public final MergeAtmosphere getMergeAtmosphereVO() {
        return this.mergeAtmosphereVO;
    }

    /* compiled from: MergeAtmospherePriceFloor.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0017J\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0018J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006-"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergeAtmosphere;", "", "backImg", "Lkntr/app/mall/product/details/page/api/model/ImageColorModel;", "frontImg", "backImgNight", "frontImgNight", "<init>", "(Lkntr/app/mall/product/details/page/api/model/ImageColorModel;Lkntr/app/mall/product/details/page/api/model/ImageColorModel;Lkntr/app/mall/product/details/page/api/model/ImageColorModel;Lkntr/app/mall/product/details/page/api/model/ImageColorModel;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/model/ImageColorModel;Lkntr/app/mall/product/details/page/api/model/ImageColorModel;Lkntr/app/mall/product/details/page/api/model/ImageColorModel;Lkntr/app/mall/product/details/page/api/model/ImageColorModel;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBackImg", "()Lkntr/app/mall/product/details/page/api/model/ImageColorModel;", "getFrontImg", "getBackImgNight", "getFrontImgNight", "isValid", "", "isValid$product_details_page_debug", "isLight", "getBackImg$product_details_page_debug", "getFrontImg$product_details_page_debug", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class MergeAtmosphere {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final ImageColorModel backImg;
        private final ImageColorModel backImgNight;
        private final ImageColorModel frontImg;
        private final ImageColorModel frontImgNight;

        public MergeAtmosphere() {
            this((ImageColorModel) null, (ImageColorModel) null, (ImageColorModel) null, (ImageColorModel) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ MergeAtmosphere copy$default(MergeAtmosphere mergeAtmosphere, ImageColorModel imageColorModel, ImageColorModel imageColorModel2, ImageColorModel imageColorModel3, ImageColorModel imageColorModel4, int i, Object obj) {
            if ((i & 1) != 0) {
                imageColorModel = mergeAtmosphere.backImg;
            }
            if ((i & 2) != 0) {
                imageColorModel2 = mergeAtmosphere.frontImg;
            }
            if ((i & 4) != 0) {
                imageColorModel3 = mergeAtmosphere.backImgNight;
            }
            if ((i & 8) != 0) {
                imageColorModel4 = mergeAtmosphere.frontImgNight;
            }
            return mergeAtmosphere.copy(imageColorModel, imageColorModel2, imageColorModel3, imageColorModel4);
        }

        public final ImageColorModel component1() {
            return this.backImg;
        }

        public final ImageColorModel component2() {
            return this.frontImg;
        }

        public final ImageColorModel component3() {
            return this.backImgNight;
        }

        public final ImageColorModel component4() {
            return this.frontImgNight;
        }

        public final MergeAtmosphere copy(ImageColorModel imageColorModel, ImageColorModel imageColorModel2, ImageColorModel imageColorModel3, ImageColorModel imageColorModel4) {
            return new MergeAtmosphere(imageColorModel, imageColorModel2, imageColorModel3, imageColorModel4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MergeAtmosphere) {
                MergeAtmosphere mergeAtmosphere = (MergeAtmosphere) obj;
                return Intrinsics.areEqual(this.backImg, mergeAtmosphere.backImg) && Intrinsics.areEqual(this.frontImg, mergeAtmosphere.frontImg) && Intrinsics.areEqual(this.backImgNight, mergeAtmosphere.backImgNight) && Intrinsics.areEqual(this.frontImgNight, mergeAtmosphere.frontImgNight);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.backImg == null ? 0 : this.backImg.hashCode()) * 31) + (this.frontImg == null ? 0 : this.frontImg.hashCode())) * 31) + (this.backImgNight == null ? 0 : this.backImgNight.hashCode())) * 31) + (this.frontImgNight != null ? this.frontImgNight.hashCode() : 0);
        }

        public String toString() {
            ImageColorModel imageColorModel = this.backImg;
            ImageColorModel imageColorModel2 = this.frontImg;
            ImageColorModel imageColorModel3 = this.backImgNight;
            return "MergeAtmosphere(backImg=" + imageColorModel + ", frontImg=" + imageColorModel2 + ", backImgNight=" + imageColorModel3 + ", frontImgNight=" + this.frontImgNight + ")";
        }

        /* compiled from: MergeAtmospherePriceFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergeAtmosphere$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergeAtmosphere;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<MergeAtmosphere> serializer() {
                return MergeAtmospherePriceFloor$MergeAtmosphere$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ MergeAtmosphere(int seen0, ImageColorModel backImg, ImageColorModel frontImg, ImageColorModel backImgNight, ImageColorModel frontImgNight, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.backImg = null;
            } else {
                this.backImg = backImg;
            }
            if ((seen0 & 2) == 0) {
                this.frontImg = null;
            } else {
                this.frontImg = frontImg;
            }
            if ((seen0 & 4) == 0) {
                this.backImgNight = null;
            } else {
                this.backImgNight = backImgNight;
            }
            if ((seen0 & 8) == 0) {
                this.frontImgNight = null;
            } else {
                this.frontImgNight = frontImgNight;
            }
        }

        public MergeAtmosphere(ImageColorModel backImg, ImageColorModel frontImg, ImageColorModel backImgNight, ImageColorModel frontImgNight) {
            this.backImg = backImg;
            this.frontImg = frontImg;
            this.backImgNight = backImgNight;
            this.frontImgNight = frontImgNight;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(MergeAtmosphere self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.backImg != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, ImageColorModel$$serializer.INSTANCE, self.backImg);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.frontImg != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, ImageColorModel$$serializer.INSTANCE, self.frontImg);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.backImgNight != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, ImageColorModel$$serializer.INSTANCE, self.backImgNight);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.frontImgNight != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, ImageColorModel$$serializer.INSTANCE, self.frontImgNight);
            }
        }

        public /* synthetic */ MergeAtmosphere(ImageColorModel imageColorModel, ImageColorModel imageColorModel2, ImageColorModel imageColorModel3, ImageColorModel imageColorModel4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : imageColorModel, (i & 2) != 0 ? null : imageColorModel2, (i & 4) != 0 ? null : imageColorModel3, (i & 8) != 0 ? null : imageColorModel4);
        }

        public final ImageColorModel getBackImg() {
            return this.backImg;
        }

        public final ImageColorModel getFrontImg() {
            return this.frontImg;
        }

        public final ImageColorModel getBackImgNight() {
            return this.backImgNight;
        }

        public final ImageColorModel getFrontImgNight() {
            return this.frontImgNight;
        }

        public final boolean isValid$product_details_page_debug() {
            ImageColorModel imageColorModel = this.backImg;
            boolean hasBackImg = imageColorModel != null && imageColorModel.isValid$product_details_page_debug();
            ImageColorModel imageColorModel2 = this.frontImg;
            boolean hasFrontImg = imageColorModel2 != null && imageColorModel2.isValid$product_details_page_debug();
            ImageColorModel imageColorModel3 = this.backImgNight;
            boolean hasBackImgNight = imageColorModel3 != null && imageColorModel3.isValid$product_details_page_debug();
            ImageColorModel imageColorModel4 = this.frontImgNight;
            boolean hasFrontImgNight = imageColorModel4 != null && imageColorModel4.isValid$product_details_page_debug();
            return hasBackImg || hasFrontImg || hasBackImgNight || hasFrontImgNight;
        }

        public final ImageColorModel getBackImg$product_details_page_debug(boolean isLight) {
            if (isLight) {
                return this.backImg;
            }
            ImageColorModel imageColorModel = this.backImgNight;
            return imageColorModel == null ? this.backImg : imageColorModel;
        }

        public final ImageColorModel getFrontImg$product_details_page_debug(boolean isLight) {
            if (isLight) {
                return this.frontImg;
            }
            ImageColorModel imageColorModel = this.frontImgNight;
            return imageColorModel == null ? this.frontImg : imageColorModel;
        }
    }

    public final MergePriceInfo getMergePriceInfoVO() {
        return this.mergePriceInfoVO;
    }

    /* compiled from: MergeAtmospherePriceFloor.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 12\u00020\u0001:\u0005-./01B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\r\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\rHÖ\u0001J\t\u0010$\u001a\u00020\tHÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u00062"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo;", "", "bottomVO", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$BottomVO;", "leftVO", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO;", "rightVO", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO;", "fontColor", "", "<init>", "(Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$BottomVO;Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO;Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$BottomVO;Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO;Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBottomVO", "()Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$BottomVO;", "getLeftVO", "()Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO;", "getRightVO", "()Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO;", "getFontColor", "()Ljava/lang/String;", "shouldExpand", "", "shouldExpand$product_details_page_debug", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "BottomVO", "LeftVO", "RightVO", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class MergePriceInfo {
        private final BottomVO bottomVO;
        private final String fontColor;
        private final LeftVO leftVO;
        private final RightVO rightVO;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public MergePriceInfo() {
            this((BottomVO) null, (LeftVO) null, (RightVO) null, (String) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ MergePriceInfo copy$default(MergePriceInfo mergePriceInfo, BottomVO bottomVO, LeftVO leftVO, RightVO rightVO, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                bottomVO = mergePriceInfo.bottomVO;
            }
            if ((i & 2) != 0) {
                leftVO = mergePriceInfo.leftVO;
            }
            if ((i & 4) != 0) {
                rightVO = mergePriceInfo.rightVO;
            }
            if ((i & 8) != 0) {
                str = mergePriceInfo.fontColor;
            }
            return mergePriceInfo.copy(bottomVO, leftVO, rightVO, str);
        }

        public final BottomVO component1() {
            return this.bottomVO;
        }

        public final LeftVO component2() {
            return this.leftVO;
        }

        public final RightVO component3() {
            return this.rightVO;
        }

        public final String component4() {
            return this.fontColor;
        }

        public final MergePriceInfo copy(BottomVO bottomVO, LeftVO leftVO, RightVO rightVO, String str) {
            return new MergePriceInfo(bottomVO, leftVO, rightVO, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MergePriceInfo) {
                MergePriceInfo mergePriceInfo = (MergePriceInfo) obj;
                return Intrinsics.areEqual(this.bottomVO, mergePriceInfo.bottomVO) && Intrinsics.areEqual(this.leftVO, mergePriceInfo.leftVO) && Intrinsics.areEqual(this.rightVO, mergePriceInfo.rightVO) && Intrinsics.areEqual(this.fontColor, mergePriceInfo.fontColor);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.bottomVO == null ? 0 : this.bottomVO.hashCode()) * 31) + (this.leftVO == null ? 0 : this.leftVO.hashCode())) * 31) + (this.rightVO == null ? 0 : this.rightVO.hashCode())) * 31) + (this.fontColor != null ? this.fontColor.hashCode() : 0);
        }

        public String toString() {
            BottomVO bottomVO = this.bottomVO;
            LeftVO leftVO = this.leftVO;
            RightVO rightVO = this.rightVO;
            return "MergePriceInfo(bottomVO=" + bottomVO + ", leftVO=" + leftVO + ", rightVO=" + rightVO + ", fontColor=" + this.fontColor + ")";
        }

        /* compiled from: MergeAtmospherePriceFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<MergePriceInfo> serializer() {
                return MergeAtmospherePriceFloor$MergePriceInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ MergePriceInfo(int seen0, BottomVO bottomVO, LeftVO leftVO, RightVO rightVO, String fontColor, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.bottomVO = null;
            } else {
                this.bottomVO = bottomVO;
            }
            if ((seen0 & 2) == 0) {
                this.leftVO = null;
            } else {
                this.leftVO = leftVO;
            }
            if ((seen0 & 4) == 0) {
                this.rightVO = null;
            } else {
                this.rightVO = rightVO;
            }
            if ((seen0 & 8) == 0) {
                this.fontColor = null;
            } else {
                this.fontColor = fontColor;
            }
        }

        public MergePriceInfo(BottomVO bottomVO, LeftVO leftVO, RightVO rightVO, String fontColor) {
            this.bottomVO = bottomVO;
            this.leftVO = leftVO;
            this.rightVO = rightVO;
            this.fontColor = fontColor;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(MergePriceInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.bottomVO != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, MergeAtmospherePriceFloor$MergePriceInfo$BottomVO$$serializer.INSTANCE, self.bottomVO);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.leftVO != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$$serializer.INSTANCE, self.leftVO);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.rightVO != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, MergeAtmospherePriceFloor$MergePriceInfo$RightVO$$serializer.INSTANCE, self.rightVO);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.fontColor != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.fontColor);
            }
        }

        public /* synthetic */ MergePriceInfo(BottomVO bottomVO, LeftVO leftVO, RightVO rightVO, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bottomVO, (i & 2) != 0 ? null : leftVO, (i & 4) != 0 ? null : rightVO, (i & 8) != 0 ? null : str);
        }

        public final BottomVO getBottomVO() {
            return this.bottomVO;
        }

        public final LeftVO getLeftVO() {
            return this.leftVO;
        }

        public final RightVO getRightVO() {
            return this.rightVO;
        }

        /* compiled from: MergeAtmospherePriceFloor.kt */
        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\bHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$BottomVO;", "", "actBenefitVOs", "", "Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "<init>", "(Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActBenefitVOs", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class BottomVO {
            private final List<TextColorModel> actBenefitVOs;
            public static final Companion Companion = new Companion(null);
            public static final int $stable = 8;
            private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.MergeAtmospherePriceFloor$MergePriceInfo$BottomVO$$ExternalSyntheticLambda0
                public final Object invoke() {
                    KSerializer _childSerializers$_anonymous_;
                    _childSerializers$_anonymous_ = MergeAtmospherePriceFloor.MergePriceInfo.BottomVO._childSerializers$_anonymous_();
                    return _childSerializers$_anonymous_;
                }
            })};

            public BottomVO() {
                this((List) null, 1, (DefaultConstructorMarker) null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ BottomVO copy$default(BottomVO bottomVO, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = bottomVO.actBenefitVOs;
                }
                return bottomVO.copy(list);
            }

            public final List<TextColorModel> component1() {
                return this.actBenefitVOs;
            }

            public final BottomVO copy(List<TextColorModel> list) {
                return new BottomVO(list);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof BottomVO) && Intrinsics.areEqual(this.actBenefitVOs, ((BottomVO) obj).actBenefitVOs);
            }

            public int hashCode() {
                if (this.actBenefitVOs == null) {
                    return 0;
                }
                return this.actBenefitVOs.hashCode();
            }

            public String toString() {
                return "BottomVO(actBenefitVOs=" + this.actBenefitVOs + ")";
            }

            /* compiled from: MergeAtmospherePriceFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$BottomVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$BottomVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<BottomVO> serializer() {
                    return MergeAtmospherePriceFloor$MergePriceInfo$BottomVO$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ BottomVO(int seen0, List actBenefitVOs, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.actBenefitVOs = null;
                } else {
                    this.actBenefitVOs = actBenefitVOs;
                }
            }

            public BottomVO(List<TextColorModel> list) {
                this.actBenefitVOs = list;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(TextColorModel$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(BottomVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                boolean z = true;
                if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.actBenefitVOs == null) {
                    z = false;
                }
                if (z) {
                    output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.actBenefitVOs);
                }
            }

            public /* synthetic */ BottomVO(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : list);
            }

            public final List<TextColorModel> getActBenefitVOs() {
                return this.actBenefitVOs;
            }
        }

        public final String getFontColor() {
            return this.fontColor;
        }

        /* compiled from: MergeAtmospherePriceFloor.kt */
        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0004$%&'B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\r\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\tHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006("}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO;", "", "leftBottomVO", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftBottomVO;", "leftTopVO", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftTopVO;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftBottomVO;Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftTopVO;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftBottomVO;Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftTopVO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLeftBottomVO", "()Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftBottomVO;", "getLeftTopVO", "()Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftTopVO;", "notEmpty", "", "notEmpty$product_details_page_debug", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "LeftBottomVO", "LeftTopVO", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class LeftVO {
            private final LeftBottomVO leftBottomVO;
            private final LeftTopVO leftTopVO;
            public static final Companion Companion = new Companion(null);
            public static final int $stable = 8;

            public LeftVO() {
                this((LeftBottomVO) null, (LeftTopVO) null, 3, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ LeftVO copy$default(LeftVO leftVO, LeftBottomVO leftBottomVO, LeftTopVO leftTopVO, int i, Object obj) {
                if ((i & 1) != 0) {
                    leftBottomVO = leftVO.leftBottomVO;
                }
                if ((i & 2) != 0) {
                    leftTopVO = leftVO.leftTopVO;
                }
                return leftVO.copy(leftBottomVO, leftTopVO);
            }

            public final LeftBottomVO component1() {
                return this.leftBottomVO;
            }

            public final LeftTopVO component2() {
                return this.leftTopVO;
            }

            public final LeftVO copy(LeftBottomVO leftBottomVO, LeftTopVO leftTopVO) {
                return new LeftVO(leftBottomVO, leftTopVO);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof LeftVO) {
                    LeftVO leftVO = (LeftVO) obj;
                    return Intrinsics.areEqual(this.leftBottomVO, leftVO.leftBottomVO) && Intrinsics.areEqual(this.leftTopVO, leftVO.leftTopVO);
                }
                return false;
            }

            public int hashCode() {
                return ((this.leftBottomVO == null ? 0 : this.leftBottomVO.hashCode()) * 31) + (this.leftTopVO != null ? this.leftTopVO.hashCode() : 0);
            }

            public String toString() {
                LeftBottomVO leftBottomVO = this.leftBottomVO;
                return "LeftVO(leftBottomVO=" + leftBottomVO + ", leftTopVO=" + this.leftTopVO + ")";
            }

            /* compiled from: MergeAtmospherePriceFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<LeftVO> serializer() {
                    return MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ LeftVO(int seen0, LeftBottomVO leftBottomVO, LeftTopVO leftTopVO, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.leftBottomVO = null;
                } else {
                    this.leftBottomVO = leftBottomVO;
                }
                if ((seen0 & 2) == 0) {
                    this.leftTopVO = null;
                } else {
                    this.leftTopVO = leftTopVO;
                }
            }

            public LeftVO(LeftBottomVO leftBottomVO, LeftTopVO leftTopVO) {
                this.leftBottomVO = leftBottomVO;
                this.leftTopVO = leftTopVO;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(LeftVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.leftBottomVO != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftBottomVO$$serializer.INSTANCE, self.leftBottomVO);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.leftTopVO != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftTopVO$$serializer.INSTANCE, self.leftTopVO);
                }
            }

            public /* synthetic */ LeftVO(LeftBottomVO leftBottomVO, LeftTopVO leftTopVO, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : leftBottomVO, (i & 2) != 0 ? null : leftTopVO);
            }

            public final LeftBottomVO getLeftBottomVO() {
                return this.leftBottomVO;
            }

            /* compiled from: MergeAtmospherePriceFloor.kt */
            @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB;\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\r\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\nHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006&"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftBottomVO;", "", "benefitInfos", "", "Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "priceDescVOS", "Lkntr/app/mall/product/details/page/api/model/PriceDescVO;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBenefitInfos", "()Ljava/util/List;", "getPriceDescVOS", "notEmpty", "", "notEmpty$product_details_page_debug", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class LeftBottomVO {
                private final List<TextColorModel> benefitInfos;
                private final List<PriceDescVO> priceDescVOS;
                public static final Companion Companion = new Companion(null);
                public static final int $stable = 8;
                private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftBottomVO$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_;
                        _childSerializers$_anonymous_ = MergeAtmospherePriceFloor.MergePriceInfo.LeftVO.LeftBottomVO._childSerializers$_anonymous_();
                        return _childSerializers$_anonymous_;
                    }
                }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftBottomVO$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_$0;
                        _childSerializers$_anonymous_$0 = MergeAtmospherePriceFloor.MergePriceInfo.LeftVO.LeftBottomVO._childSerializers$_anonymous_$0();
                        return _childSerializers$_anonymous_$0;
                    }
                })};

                public LeftBottomVO() {
                    this((List) null, (List) null, 3, (DefaultConstructorMarker) null);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ LeftBottomVO copy$default(LeftBottomVO leftBottomVO, List list, List list2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = leftBottomVO.benefitInfos;
                    }
                    if ((i & 2) != 0) {
                        list2 = leftBottomVO.priceDescVOS;
                    }
                    return leftBottomVO.copy(list, list2);
                }

                public final List<TextColorModel> component1() {
                    return this.benefitInfos;
                }

                public final List<PriceDescVO> component2() {
                    return this.priceDescVOS;
                }

                public final LeftBottomVO copy(List<TextColorModel> list, List<PriceDescVO> list2) {
                    return new LeftBottomVO(list, list2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof LeftBottomVO) {
                        LeftBottomVO leftBottomVO = (LeftBottomVO) obj;
                        return Intrinsics.areEqual(this.benefitInfos, leftBottomVO.benefitInfos) && Intrinsics.areEqual(this.priceDescVOS, leftBottomVO.priceDescVOS);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((this.benefitInfos == null ? 0 : this.benefitInfos.hashCode()) * 31) + (this.priceDescVOS != null ? this.priceDescVOS.hashCode() : 0);
                }

                public String toString() {
                    List<TextColorModel> list = this.benefitInfos;
                    return "LeftBottomVO(benefitInfos=" + list + ", priceDescVOS=" + this.priceDescVOS + ")";
                }

                /* compiled from: MergeAtmospherePriceFloor.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftBottomVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftBottomVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<LeftBottomVO> serializer() {
                        return MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftBottomVO$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ LeftBottomVO(int seen0, List benefitInfos, List priceDescVOS, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.benefitInfos = null;
                    } else {
                        this.benefitInfos = benefitInfos;
                    }
                    if ((seen0 & 2) == 0) {
                        this.priceDescVOS = null;
                    } else {
                        this.priceDescVOS = priceDescVOS;
                    }
                }

                public LeftBottomVO(List<TextColorModel> list, List<PriceDescVO> list2) {
                    this.benefitInfos = list;
                    this.priceDescVOS = list2;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new ArrayListSerializer(TextColorModel$$serializer.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                    return new ArrayListSerializer(PriceDescVO$$serializer.INSTANCE);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(LeftBottomVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.benefitInfos != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.benefitInfos);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.priceDescVOS != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.priceDescVOS);
                    }
                }

                public /* synthetic */ LeftBottomVO(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
                }

                public final List<TextColorModel> getBenefitInfos() {
                    return this.benefitInfos;
                }

                public final List<PriceDescVO> getPriceDescVOS() {
                    return this.priceDescVOS;
                }

                public final boolean notEmpty$product_details_page_debug() {
                    List<TextColorModel> list = this.benefitInfos;
                    if (list == null || list.isEmpty()) {
                        List<PriceDescVO> list2 = this.priceDescVOS;
                        if (list2 == null || list2.isEmpty()) {
                            return false;
                        }
                    }
                    return true;
                }
            }

            public final LeftTopVO getLeftTopVO() {
                return this.leftTopVO;
            }

            /* compiled from: MergeAtmospherePriceFloor.kt */
            @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B;\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006%"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftTopVO;", "", "mainPriceVOs", "", "Lkntr/app/mall/product/details/page/api/model/PriceDescVO;", "priceDescVOS", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMainPriceVOs", "()Ljava/util/List;", "getPriceDescVOS", "notEmpty", "", "notEmpty$product_details_page_debug", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class LeftTopVO {
                private final List<PriceDescVO> mainPriceVOs;
                private final List<PriceDescVO> priceDescVOS;
                public static final Companion Companion = new Companion(null);
                public static final int $stable = 8;
                private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftTopVO$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_;
                        _childSerializers$_anonymous_ = MergeAtmospherePriceFloor.MergePriceInfo.LeftVO.LeftTopVO._childSerializers$_anonymous_();
                        return _childSerializers$_anonymous_;
                    }
                }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftTopVO$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_$0;
                        _childSerializers$_anonymous_$0 = MergeAtmospherePriceFloor.MergePriceInfo.LeftVO.LeftTopVO._childSerializers$_anonymous_$0();
                        return _childSerializers$_anonymous_$0;
                    }
                })};

                public LeftTopVO() {
                    this((List) null, (List) null, 3, (DefaultConstructorMarker) null);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ LeftTopVO copy$default(LeftTopVO leftTopVO, List list, List list2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = leftTopVO.mainPriceVOs;
                    }
                    if ((i & 2) != 0) {
                        list2 = leftTopVO.priceDescVOS;
                    }
                    return leftTopVO.copy(list, list2);
                }

                public final List<PriceDescVO> component1() {
                    return this.mainPriceVOs;
                }

                public final List<PriceDescVO> component2() {
                    return this.priceDescVOS;
                }

                public final LeftTopVO copy(List<PriceDescVO> list, List<PriceDescVO> list2) {
                    return new LeftTopVO(list, list2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof LeftTopVO) {
                        LeftTopVO leftTopVO = (LeftTopVO) obj;
                        return Intrinsics.areEqual(this.mainPriceVOs, leftTopVO.mainPriceVOs) && Intrinsics.areEqual(this.priceDescVOS, leftTopVO.priceDescVOS);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((this.mainPriceVOs == null ? 0 : this.mainPriceVOs.hashCode()) * 31) + (this.priceDescVOS != null ? this.priceDescVOS.hashCode() : 0);
                }

                public String toString() {
                    List<PriceDescVO> list = this.mainPriceVOs;
                    return "LeftTopVO(mainPriceVOs=" + list + ", priceDescVOS=" + this.priceDescVOS + ")";
                }

                /* compiled from: MergeAtmospherePriceFloor.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftTopVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftTopVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<LeftTopVO> serializer() {
                        return MergeAtmospherePriceFloor$MergePriceInfo$LeftVO$LeftTopVO$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ LeftTopVO(int seen0, List mainPriceVOs, List priceDescVOS, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.mainPriceVOs = null;
                    } else {
                        this.mainPriceVOs = mainPriceVOs;
                    }
                    if ((seen0 & 2) == 0) {
                        this.priceDescVOS = null;
                    } else {
                        this.priceDescVOS = priceDescVOS;
                    }
                }

                public LeftTopVO(List<PriceDescVO> list, List<PriceDescVO> list2) {
                    this.mainPriceVOs = list;
                    this.priceDescVOS = list2;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new ArrayListSerializer(PriceDescVO$$serializer.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                    return new ArrayListSerializer(PriceDescVO$$serializer.INSTANCE);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(LeftTopVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.mainPriceVOs != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.mainPriceVOs);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.priceDescVOS != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.priceDescVOS);
                    }
                }

                public /* synthetic */ LeftTopVO(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
                }

                public final List<PriceDescVO> getMainPriceVOs() {
                    return this.mainPriceVOs;
                }

                public final List<PriceDescVO> getPriceDescVOS() {
                    return this.priceDescVOS;
                }

                public final boolean notEmpty$product_details_page_debug() {
                    List<PriceDescVO> list = this.mainPriceVOs;
                    if (list == null || list.isEmpty()) {
                        List<PriceDescVO> list2 = this.priceDescVOS;
                        if (list2 == null || list2.isEmpty()) {
                            return false;
                        }
                    }
                    return true;
                }
            }

            public final boolean notEmpty$product_details_page_debug() {
                LeftTopVO leftTopVO = this.leftTopVO;
                if (leftTopVO != null && leftTopVO.notEmpty$product_details_page_debug()) {
                    return true;
                }
                LeftBottomVO leftBottomVO = this.leftBottomVO;
                return leftBottomVO != null && leftBottomVO.notEmpty$product_details_page_debug();
            }
        }

        /* compiled from: MergeAtmospherePriceFloor.kt */
        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0004$%&'B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\r\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\tHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006("}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO;", "", "rightBottomVO", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightBottomVO;", "rightTopVO", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightTopVO;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightBottomVO;Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightTopVO;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightBottomVO;Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightTopVO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRightBottomVO", "()Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightBottomVO;", "getRightTopVO", "()Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightTopVO;", "notEmpty", "", "notEmpty$product_details_page_debug", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "RightBottomVO", "RightTopVO", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class RightVO {
            private final RightBottomVO rightBottomVO;
            private final RightTopVO rightTopVO;
            public static final Companion Companion = new Companion(null);
            public static final int $stable = 8;

            public RightVO() {
                this((RightBottomVO) null, (RightTopVO) null, 3, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ RightVO copy$default(RightVO rightVO, RightBottomVO rightBottomVO, RightTopVO rightTopVO, int i, Object obj) {
                if ((i & 1) != 0) {
                    rightBottomVO = rightVO.rightBottomVO;
                }
                if ((i & 2) != 0) {
                    rightTopVO = rightVO.rightTopVO;
                }
                return rightVO.copy(rightBottomVO, rightTopVO);
            }

            public final RightBottomVO component1() {
                return this.rightBottomVO;
            }

            public final RightTopVO component2() {
                return this.rightTopVO;
            }

            public final RightVO copy(RightBottomVO rightBottomVO, RightTopVO rightTopVO) {
                return new RightVO(rightBottomVO, rightTopVO);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof RightVO) {
                    RightVO rightVO = (RightVO) obj;
                    return Intrinsics.areEqual(this.rightBottomVO, rightVO.rightBottomVO) && Intrinsics.areEqual(this.rightTopVO, rightVO.rightTopVO);
                }
                return false;
            }

            public int hashCode() {
                return ((this.rightBottomVO == null ? 0 : this.rightBottomVO.hashCode()) * 31) + (this.rightTopVO != null ? this.rightTopVO.hashCode() : 0);
            }

            public String toString() {
                RightBottomVO rightBottomVO = this.rightBottomVO;
                return "RightVO(rightBottomVO=" + rightBottomVO + ", rightTopVO=" + this.rightTopVO + ")";
            }

            /* compiled from: MergeAtmospherePriceFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<RightVO> serializer() {
                    return MergeAtmospherePriceFloor$MergePriceInfo$RightVO$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ RightVO(int seen0, RightBottomVO rightBottomVO, RightTopVO rightTopVO, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.rightBottomVO = null;
                } else {
                    this.rightBottomVO = rightBottomVO;
                }
                if ((seen0 & 2) == 0) {
                    this.rightTopVO = null;
                } else {
                    this.rightTopVO = rightTopVO;
                }
            }

            public RightVO(RightBottomVO rightBottomVO, RightTopVO rightTopVO) {
                this.rightBottomVO = rightBottomVO;
                this.rightTopVO = rightTopVO;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(RightVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.rightBottomVO != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightBottomVO$$serializer.INSTANCE, self.rightBottomVO);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.rightTopVO != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightTopVO$$serializer.INSTANCE, self.rightTopVO);
                }
            }

            public /* synthetic */ RightVO(RightBottomVO rightBottomVO, RightTopVO rightTopVO, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : rightBottomVO, (i & 2) != 0 ? null : rightTopVO);
            }

            public final RightBottomVO getRightBottomVO() {
                return this.rightBottomVO;
            }

            /* compiled from: MergeAtmospherePriceFloor.kt */
            @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\r\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\tHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006&"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightBottomVO;", "", "countDownInfoVO", "Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;", "infoText", "Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "<init>", "(Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;Lkntr/app/mall/product/details/page/api/model/TextColorModel;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/model/CountDownInfoVO;Lkntr/app/mall/product/details/page/api/model/TextColorModel;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCountDownInfoVO", "()Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;", "getInfoText", "()Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "notEmpty", "", "notEmpty$product_details_page_debug", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class RightBottomVO {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final CountDownInfoVO countDownInfoVO;
                private final TextColorModel infoText;

                public RightBottomVO() {
                    this((CountDownInfoVO) null, (TextColorModel) null, 3, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ RightBottomVO copy$default(RightBottomVO rightBottomVO, CountDownInfoVO countDownInfoVO, TextColorModel textColorModel, int i, Object obj) {
                    if ((i & 1) != 0) {
                        countDownInfoVO = rightBottomVO.countDownInfoVO;
                    }
                    if ((i & 2) != 0) {
                        textColorModel = rightBottomVO.infoText;
                    }
                    return rightBottomVO.copy(countDownInfoVO, textColorModel);
                }

                public final CountDownInfoVO component1() {
                    return this.countDownInfoVO;
                }

                public final TextColorModel component2() {
                    return this.infoText;
                }

                public final RightBottomVO copy(CountDownInfoVO countDownInfoVO, TextColorModel textColorModel) {
                    return new RightBottomVO(countDownInfoVO, textColorModel);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof RightBottomVO) {
                        RightBottomVO rightBottomVO = (RightBottomVO) obj;
                        return Intrinsics.areEqual(this.countDownInfoVO, rightBottomVO.countDownInfoVO) && Intrinsics.areEqual(this.infoText, rightBottomVO.infoText);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((this.countDownInfoVO == null ? 0 : this.countDownInfoVO.hashCode()) * 31) + (this.infoText != null ? this.infoText.hashCode() : 0);
                }

                public String toString() {
                    CountDownInfoVO countDownInfoVO = this.countDownInfoVO;
                    return "RightBottomVO(countDownInfoVO=" + countDownInfoVO + ", infoText=" + this.infoText + ")";
                }

                /* compiled from: MergeAtmospherePriceFloor.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightBottomVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightBottomVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<RightBottomVO> serializer() {
                        return MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightBottomVO$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ RightBottomVO(int seen0, CountDownInfoVO countDownInfoVO, TextColorModel infoText, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.countDownInfoVO = null;
                    } else {
                        this.countDownInfoVO = countDownInfoVO;
                    }
                    if ((seen0 & 2) == 0) {
                        this.infoText = null;
                    } else {
                        this.infoText = infoText;
                    }
                }

                public RightBottomVO(CountDownInfoVO countDownInfoVO, TextColorModel infoText) {
                    this.countDownInfoVO = countDownInfoVO;
                    this.infoText = infoText;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(RightBottomVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.countDownInfoVO != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, CountDownInfoVO$$serializer.INSTANCE, self.countDownInfoVO);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.infoText != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, TextColorModel$$serializer.INSTANCE, self.infoText);
                    }
                }

                public /* synthetic */ RightBottomVO(CountDownInfoVO countDownInfoVO, TextColorModel textColorModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : countDownInfoVO, (i & 2) != 0 ? null : textColorModel);
                }

                public final CountDownInfoVO getCountDownInfoVO() {
                    return this.countDownInfoVO;
                }

                public final TextColorModel getInfoText() {
                    return this.infoText;
                }

                public final boolean notEmpty$product_details_page_debug() {
                    return (this.countDownInfoVO == null && this.infoText == null) ? false : true;
                }
            }

            public final RightTopVO getRightTopVO() {
                return this.rightTopVO;
            }

            /* compiled from: MergeAtmospherePriceFloor.kt */
            @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\r\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\""}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightTopVO;", "", "labels", "", "Lkntr/app/mall/product/details/page/api/model/ImageColorModel;", "<init>", "(Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLabels", "()Ljava/util/List;", "notEmpty", "", "notEmpty$product_details_page_debug", "component1", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class RightTopVO {
                private final List<ImageColorModel> labels;
                public static final Companion Companion = new Companion(null);
                public static final int $stable = 8;
                private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightTopVO$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_;
                        _childSerializers$_anonymous_ = MergeAtmospherePriceFloor.MergePriceInfo.RightVO.RightTopVO._childSerializers$_anonymous_();
                        return _childSerializers$_anonymous_;
                    }
                })};

                public RightTopVO() {
                    this((List) null, 1, (DefaultConstructorMarker) null);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ RightTopVO copy$default(RightTopVO rightTopVO, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = rightTopVO.labels;
                    }
                    return rightTopVO.copy(list);
                }

                public final List<ImageColorModel> component1() {
                    return this.labels;
                }

                public final RightTopVO copy(List<ImageColorModel> list) {
                    return new RightTopVO(list);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof RightTopVO) && Intrinsics.areEqual(this.labels, ((RightTopVO) obj).labels);
                }

                public int hashCode() {
                    if (this.labels == null) {
                        return 0;
                    }
                    return this.labels.hashCode();
                }

                public String toString() {
                    return "RightTopVO(labels=" + this.labels + ")";
                }

                /* compiled from: MergeAtmospherePriceFloor.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightTopVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightTopVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<RightTopVO> serializer() {
                        return MergeAtmospherePriceFloor$MergePriceInfo$RightVO$RightTopVO$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ RightTopVO(int seen0, List labels, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.labels = null;
                    } else {
                        this.labels = labels;
                    }
                }

                public RightTopVO(List<ImageColorModel> list) {
                    this.labels = list;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new ArrayListSerializer(ImageColorModel$$serializer.INSTANCE);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(RightTopVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                    boolean z = true;
                    if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.labels == null) {
                        z = false;
                    }
                    if (z) {
                        output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.labels);
                    }
                }

                public /* synthetic */ RightTopVO(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : list);
                }

                public final List<ImageColorModel> getLabels() {
                    return this.labels;
                }

                public final boolean notEmpty$product_details_page_debug() {
                    List<ImageColorModel> list = this.labels;
                    return !(list == null || list.isEmpty());
                }
            }

            public final boolean notEmpty$product_details_page_debug() {
                RightTopVO rightTopVO = this.rightTopVO;
                if (rightTopVO != null && rightTopVO.notEmpty$product_details_page_debug()) {
                    return true;
                }
                RightBottomVO rightBottomVO = this.rightBottomVO;
                return rightBottomVO != null && rightBottomVO.notEmpty$product_details_page_debug();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x005a A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:43:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean shouldExpand$product_details_page_debug() {
            boolean hasStackLeft;
            RightVO rightVO;
            boolean hasStackRight;
            RightVO.RightTopVO rightTopVO;
            LeftVO.LeftTopVO leftTopVO;
            LeftVO leftVO = this.leftVO;
            if ((leftVO == null || (leftTopVO = leftVO.getLeftTopVO()) == null || !leftTopVO.notEmpty$product_details_page_debug()) ? false : true) {
                LeftVO.LeftBottomVO leftBottomVO = this.leftVO.getLeftBottomVO();
                if (leftBottomVO != null && leftBottomVO.notEmpty$product_details_page_debug()) {
                    hasStackLeft = true;
                    rightVO = this.rightVO;
                    if (rightVO == null && (rightTopVO = rightVO.getRightTopVO()) != null && rightTopVO.notEmpty$product_details_page_debug()) {
                        RightVO.RightBottomVO rightBottomVO = this.rightVO.getRightBottomVO();
                        if (rightBottomVO != null && rightBottomVO.notEmpty$product_details_page_debug()) {
                            hasStackRight = true;
                            return !hasStackLeft || hasStackRight;
                        }
                    }
                    hasStackRight = false;
                    if (hasStackLeft) {
                        return true;
                    }
                }
            }
            hasStackLeft = false;
            rightVO = this.rightVO;
            if (rightVO == null && (rightTopVO = rightVO.getRightTopVO()) != null && rightTopVO.notEmpty$product_details_page_debug()) {
            }
            hasStackRight = false;
            if (hasStackLeft) {
            }
        }
    }
}