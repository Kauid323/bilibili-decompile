package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.UpMeasureFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: UpMeasureFloor.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0004-./0BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\rHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u00061"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "contentVO", "Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$ContentVO;", "recruitVO", "Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$RecruitVO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$ContentVO;Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$RecruitVO;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$ContentVO;Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$RecruitVO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getContentVO", "()Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$ContentVO;", "getRecruitVO", "()Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$RecruitVO;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ContentVO", "RecruitVO", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class UpMeasureFloor implements FloorModel {
    private final String bgImgUrl;
    private final ContentVO contentVO;
    private final String floorIcon;
    private final String floorKey;
    private final RecruitVO recruitVO;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public UpMeasureFloor() {
        this((String) null, (String) null, (String) null, (ContentVO) null, (RecruitVO) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UpMeasureFloor copy$default(UpMeasureFloor upMeasureFloor, String str, String str2, String str3, ContentVO contentVO, RecruitVO recruitVO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = upMeasureFloor.floorKey;
        }
        if ((i & 2) != 0) {
            str2 = upMeasureFloor.floorIcon;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = upMeasureFloor.bgImgUrl;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            contentVO = upMeasureFloor.contentVO;
        }
        ContentVO contentVO2 = contentVO;
        if ((i & 16) != 0) {
            recruitVO = upMeasureFloor.recruitVO;
        }
        return upMeasureFloor.copy(str, str4, str5, contentVO2, recruitVO);
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

    public final ContentVO component4() {
        return this.contentVO;
    }

    public final RecruitVO component5() {
        return this.recruitVO;
    }

    public final UpMeasureFloor copy(String str, String str2, String str3, ContentVO contentVO, RecruitVO recruitVO) {
        return new UpMeasureFloor(str, str2, str3, contentVO, recruitVO);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UpMeasureFloor) {
            UpMeasureFloor upMeasureFloor = (UpMeasureFloor) obj;
            return Intrinsics.areEqual(this.floorKey, upMeasureFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, upMeasureFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, upMeasureFloor.bgImgUrl) && Intrinsics.areEqual(this.contentVO, upMeasureFloor.contentVO) && Intrinsics.areEqual(this.recruitVO, upMeasureFloor.recruitVO);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.contentVO == null ? 0 : this.contentVO.hashCode())) * 31) + (this.recruitVO != null ? this.recruitVO.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        ContentVO contentVO = this.contentVO;
        return "UpMeasureFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", contentVO=" + contentVO + ", recruitVO=" + this.recruitVO + ")";
    }

    /* compiled from: UpMeasureFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UpMeasureFloor> serializer() {
            return UpMeasureFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ UpMeasureFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, ContentVO contentVO, RecruitVO recruitVO, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.contentVO = null;
        } else {
            this.contentVO = contentVO;
        }
        if ((seen0 & 16) == 0) {
            this.recruitVO = null;
        } else {
            this.recruitVO = recruitVO;
        }
    }

    public UpMeasureFloor(String floorKey, String floorIcon, String bgImgUrl, ContentVO contentVO, RecruitVO recruitVO) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.contentVO = contentVO;
        this.recruitVO = recruitVO;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(UpMeasureFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.getFloorKey() != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.getFloorKey());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getFloorIcon() != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getFloorIcon());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getBgImgUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getBgImgUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.contentVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, UpMeasureFloor$ContentVO$$serializer.INSTANCE, self.contentVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.recruitVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, UpMeasureFloor$RecruitVO$$serializer.INSTANCE, self.recruitVO);
        }
    }

    public /* synthetic */ UpMeasureFloor(String str, String str2, String str3, ContentVO contentVO, RecruitVO recruitVO, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : contentVO, (i & 16) != 0 ? null : recruitVO);
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

    public final ContentVO getContentVO() {
        return this.contentVO;
    }

    /* compiled from: UpMeasureFloor.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0003-./BI\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fBS\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003JK\u0010\u001f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u000eHÖ\u0001J\t\u0010$\u001a\u00020\bHÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015¨\u00060"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$ContentVO;", "", "contentDetailVOList", "", "Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$ContentVO$ContentDetailVO;", "desc", "Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "jumpUrl", "", "subTitle", "title", "<init>", "(Ljava/util/List;Lkntr/app/mall/product/details/page/api/model/TextColorModel;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/TextColorModel;Lkntr/app/mall/product/details/page/api/model/TextColorModel;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkntr/app/mall/product/details/page/api/model/TextColorModel;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/TextColorModel;Lkntr/app/mall/product/details/page/api/model/TextColorModel;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getContentDetailVOList", "()Ljava/util/List;", "getDesc", "()Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "getJumpUrl", "()Ljava/lang/String;", "getSubTitle", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ContentDetailVO", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ContentVO {
        private final List<ContentDetailVO> contentDetailVOList;
        private final TextColorModel desc;
        private final String jumpUrl;
        private final TextColorModel subTitle;
        private final TextColorModel title;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.UpMeasureFloor$ContentVO$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = UpMeasureFloor.ContentVO._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, null, null, null};

        public ContentVO() {
            this((List) null, (TextColorModel) null, (String) null, (TextColorModel) null, (TextColorModel) null, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ContentVO copy$default(ContentVO contentVO, List list, TextColorModel textColorModel, String str, TextColorModel textColorModel2, TextColorModel textColorModel3, int i, Object obj) {
            List<ContentDetailVO> list2 = list;
            if ((i & 1) != 0) {
                list2 = contentVO.contentDetailVOList;
            }
            if ((i & 2) != 0) {
                textColorModel = contentVO.desc;
            }
            TextColorModel textColorModel4 = textColorModel;
            if ((i & 4) != 0) {
                str = contentVO.jumpUrl;
            }
            String str2 = str;
            if ((i & 8) != 0) {
                textColorModel2 = contentVO.subTitle;
            }
            TextColorModel textColorModel5 = textColorModel2;
            if ((i & 16) != 0) {
                textColorModel3 = contentVO.title;
            }
            return contentVO.copy(list2, textColorModel4, str2, textColorModel5, textColorModel3);
        }

        public final List<ContentDetailVO> component1() {
            return this.contentDetailVOList;
        }

        public final TextColorModel component2() {
            return this.desc;
        }

        public final String component3() {
            return this.jumpUrl;
        }

        public final TextColorModel component4() {
            return this.subTitle;
        }

        public final TextColorModel component5() {
            return this.title;
        }

        public final ContentVO copy(List<ContentDetailVO> list, TextColorModel textColorModel, String str, TextColorModel textColorModel2, TextColorModel textColorModel3) {
            return new ContentVO(list, textColorModel, str, textColorModel2, textColorModel3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ContentVO) {
                ContentVO contentVO = (ContentVO) obj;
                return Intrinsics.areEqual(this.contentDetailVOList, contentVO.contentDetailVOList) && Intrinsics.areEqual(this.desc, contentVO.desc) && Intrinsics.areEqual(this.jumpUrl, contentVO.jumpUrl) && Intrinsics.areEqual(this.subTitle, contentVO.subTitle) && Intrinsics.areEqual(this.title, contentVO.title);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((this.contentDetailVOList == null ? 0 : this.contentDetailVOList.hashCode()) * 31) + (this.desc == null ? 0 : this.desc.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.subTitle == null ? 0 : this.subTitle.hashCode())) * 31) + (this.title != null ? this.title.hashCode() : 0);
        }

        public String toString() {
            List<ContentDetailVO> list = this.contentDetailVOList;
            TextColorModel textColorModel = this.desc;
            String str = this.jumpUrl;
            TextColorModel textColorModel2 = this.subTitle;
            return "ContentVO(contentDetailVOList=" + list + ", desc=" + textColorModel + ", jumpUrl=" + str + ", subTitle=" + textColorModel2 + ", title=" + this.title + ")";
        }

        /* compiled from: UpMeasureFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$ContentVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$ContentVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ContentVO> serializer() {
                return UpMeasureFloor$ContentVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ContentVO(int seen0, List contentDetailVOList, TextColorModel desc, String jumpUrl, TextColorModel subTitle, TextColorModel title, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.contentDetailVOList = null;
            } else {
                this.contentDetailVOList = contentDetailVOList;
            }
            if ((seen0 & 2) == 0) {
                this.desc = null;
            } else {
                this.desc = desc;
            }
            if ((seen0 & 4) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
            if ((seen0 & 8) == 0) {
                this.subTitle = null;
            } else {
                this.subTitle = subTitle;
            }
            if ((seen0 & 16) == 0) {
                this.title = null;
            } else {
                this.title = title;
            }
        }

        public ContentVO(List<ContentDetailVO> list, TextColorModel desc, String jumpUrl, TextColorModel subTitle, TextColorModel title) {
            this.contentDetailVOList = list;
            this.desc = desc;
            this.jumpUrl = jumpUrl;
            this.subTitle = subTitle;
            this.title = title;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(UpMeasureFloor$ContentVO$ContentDetailVO$$serializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ContentVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.contentDetailVOList != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.contentDetailVOList);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.desc != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, TextColorModel$$serializer.INSTANCE, self.desc);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.jumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.subTitle != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, TextColorModel$$serializer.INSTANCE, self.subTitle);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.title != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, TextColorModel$$serializer.INSTANCE, self.title);
            }
        }

        public /* synthetic */ ContentVO(List list, TextColorModel textColorModel, String str, TextColorModel textColorModel2, TextColorModel textColorModel3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : textColorModel, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : textColorModel2, (i & 16) != 0 ? null : textColorModel3);
        }

        public final List<ContentDetailVO> getContentDetailVOList() {
            return this.contentDetailVOList;
        }

        public final TextColorModel getDesc() {
            return this.desc;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final TextColorModel getSubTitle() {
            return this.subTitle;
        }

        /* compiled from: UpMeasureFloor.kt */
        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Y2\u00020\u0001:\u0002XYBë\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019BÙ\u0001\b\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u0018\u0010\u001dJ\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010A\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jò\u0001\u0010I\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010JJ\u0013\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020\u0005HÖ\u0001J\t\u0010O\u001a\u00020\u0003HÖ\u0001J%\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0001¢\u0006\u0002\bWR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b+\u0010!R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b-\u0010!R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010'\u001a\u0004\b.\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001fR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b3\u0010!R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001f¨\u0006Z"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$ContentVO$ContentDetailVO;", "", "bvId", "", "contentType", "", "ctime", "ctimeStr", AppKey.UID, "", "upIcon", "upName", "upPic", "upRole", "upRoleTitle", "upRoleType", "videoDuration", "videoDurationStr", "videoImg", "videoTitle", "videoUrl", "videoView", "videoViewIcon", "videoViewStr", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBvId", "()Ljava/lang/String;", "getContentType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCtime", "getCtimeStr", "getUid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUpIcon", "getUpName", "getUpPic", "getUpRole", "getUpRoleTitle", "getUpRoleType", "getVideoDuration", "getVideoDurationStr", "getVideoImg", "getVideoTitle", "getVideoUrl", "getVideoView", "getVideoViewIcon", "getVideoViewStr", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$ContentVO$ContentDetailVO;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class ContentDetailVO {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String bvId;
            private final Integer contentType;
            private final String ctime;
            private final String ctimeStr;
            private final Long uid;
            private final String upIcon;
            private final String upName;
            private final String upPic;
            private final Integer upRole;
            private final String upRoleTitle;
            private final Integer upRoleType;
            private final Long videoDuration;
            private final String videoDurationStr;
            private final String videoImg;
            private final String videoTitle;
            private final String videoUrl;
            private final Integer videoView;
            private final String videoViewIcon;
            private final String videoViewStr;

            public ContentDetailVO() {
                this((String) null, (Integer) null, (String) null, (String) null, (Long) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, 524287, (DefaultConstructorMarker) null);
            }

            public final String component1() {
                return this.bvId;
            }

            public final String component10() {
                return this.upRoleTitle;
            }

            public final Integer component11() {
                return this.upRoleType;
            }

            public final Long component12() {
                return this.videoDuration;
            }

            public final String component13() {
                return this.videoDurationStr;
            }

            public final String component14() {
                return this.videoImg;
            }

            public final String component15() {
                return this.videoTitle;
            }

            public final String component16() {
                return this.videoUrl;
            }

            public final Integer component17() {
                return this.videoView;
            }

            public final String component18() {
                return this.videoViewIcon;
            }

            public final String component19() {
                return this.videoViewStr;
            }

            public final Integer component2() {
                return this.contentType;
            }

            public final String component3() {
                return this.ctime;
            }

            public final String component4() {
                return this.ctimeStr;
            }

            public final Long component5() {
                return this.uid;
            }

            public final String component6() {
                return this.upIcon;
            }

            public final String component7() {
                return this.upName;
            }

            public final String component8() {
                return this.upPic;
            }

            public final Integer component9() {
                return this.upRole;
            }

            public final ContentDetailVO copy(String str, Integer num, String str2, String str3, Long l, String str4, String str5, String str6, Integer num2, String str7, Integer num3, Long l2, String str8, String str9, String str10, String str11, Integer num4, String str12, String str13) {
                return new ContentDetailVO(str, num, str2, str3, l, str4, str5, str6, num2, str7, num3, l2, str8, str9, str10, str11, num4, str12, str13);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ContentDetailVO) {
                    ContentDetailVO contentDetailVO = (ContentDetailVO) obj;
                    return Intrinsics.areEqual(this.bvId, contentDetailVO.bvId) && Intrinsics.areEqual(this.contentType, contentDetailVO.contentType) && Intrinsics.areEqual(this.ctime, contentDetailVO.ctime) && Intrinsics.areEqual(this.ctimeStr, contentDetailVO.ctimeStr) && Intrinsics.areEqual(this.uid, contentDetailVO.uid) && Intrinsics.areEqual(this.upIcon, contentDetailVO.upIcon) && Intrinsics.areEqual(this.upName, contentDetailVO.upName) && Intrinsics.areEqual(this.upPic, contentDetailVO.upPic) && Intrinsics.areEqual(this.upRole, contentDetailVO.upRole) && Intrinsics.areEqual(this.upRoleTitle, contentDetailVO.upRoleTitle) && Intrinsics.areEqual(this.upRoleType, contentDetailVO.upRoleType) && Intrinsics.areEqual(this.videoDuration, contentDetailVO.videoDuration) && Intrinsics.areEqual(this.videoDurationStr, contentDetailVO.videoDurationStr) && Intrinsics.areEqual(this.videoImg, contentDetailVO.videoImg) && Intrinsics.areEqual(this.videoTitle, contentDetailVO.videoTitle) && Intrinsics.areEqual(this.videoUrl, contentDetailVO.videoUrl) && Intrinsics.areEqual(this.videoView, contentDetailVO.videoView) && Intrinsics.areEqual(this.videoViewIcon, contentDetailVO.videoViewIcon) && Intrinsics.areEqual(this.videoViewStr, contentDetailVO.videoViewStr);
                }
                return false;
            }

            public int hashCode() {
                return ((((((((((((((((((((((((((((((((((((this.bvId == null ? 0 : this.bvId.hashCode()) * 31) + (this.contentType == null ? 0 : this.contentType.hashCode())) * 31) + (this.ctime == null ? 0 : this.ctime.hashCode())) * 31) + (this.ctimeStr == null ? 0 : this.ctimeStr.hashCode())) * 31) + (this.uid == null ? 0 : this.uid.hashCode())) * 31) + (this.upIcon == null ? 0 : this.upIcon.hashCode())) * 31) + (this.upName == null ? 0 : this.upName.hashCode())) * 31) + (this.upPic == null ? 0 : this.upPic.hashCode())) * 31) + (this.upRole == null ? 0 : this.upRole.hashCode())) * 31) + (this.upRoleTitle == null ? 0 : this.upRoleTitle.hashCode())) * 31) + (this.upRoleType == null ? 0 : this.upRoleType.hashCode())) * 31) + (this.videoDuration == null ? 0 : this.videoDuration.hashCode())) * 31) + (this.videoDurationStr == null ? 0 : this.videoDurationStr.hashCode())) * 31) + (this.videoImg == null ? 0 : this.videoImg.hashCode())) * 31) + (this.videoTitle == null ? 0 : this.videoTitle.hashCode())) * 31) + (this.videoUrl == null ? 0 : this.videoUrl.hashCode())) * 31) + (this.videoView == null ? 0 : this.videoView.hashCode())) * 31) + (this.videoViewIcon == null ? 0 : this.videoViewIcon.hashCode())) * 31) + (this.videoViewStr != null ? this.videoViewStr.hashCode() : 0);
            }

            public String toString() {
                String str = this.bvId;
                Integer num = this.contentType;
                String str2 = this.ctime;
                String str3 = this.ctimeStr;
                Long l = this.uid;
                String str4 = this.upIcon;
                String str5 = this.upName;
                String str6 = this.upPic;
                Integer num2 = this.upRole;
                String str7 = this.upRoleTitle;
                Integer num3 = this.upRoleType;
                Long l2 = this.videoDuration;
                String str8 = this.videoDurationStr;
                String str9 = this.videoImg;
                String str10 = this.videoTitle;
                String str11 = this.videoUrl;
                Integer num4 = this.videoView;
                String str12 = this.videoViewIcon;
                return "ContentDetailVO(bvId=" + str + ", contentType=" + num + ", ctime=" + str2 + ", ctimeStr=" + str3 + ", uid=" + l + ", upIcon=" + str4 + ", upName=" + str5 + ", upPic=" + str6 + ", upRole=" + num2 + ", upRoleTitle=" + str7 + ", upRoleType=" + num3 + ", videoDuration=" + l2 + ", videoDurationStr=" + str8 + ", videoImg=" + str9 + ", videoTitle=" + str10 + ", videoUrl=" + str11 + ", videoView=" + num4 + ", videoViewIcon=" + str12 + ", videoViewStr=" + this.videoViewStr + ")";
            }

            /* compiled from: UpMeasureFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$ContentVO$ContentDetailVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$ContentVO$ContentDetailVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<ContentDetailVO> serializer() {
                    return UpMeasureFloor$ContentVO$ContentDetailVO$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ ContentDetailVO(int seen0, String bvId, Integer contentType, String ctime, String ctimeStr, Long uid, String upIcon, String upName, String upPic, Integer upRole, String upRoleTitle, Integer upRoleType, Long videoDuration, String videoDurationStr, String videoImg, String videoTitle, String videoUrl, Integer videoView, String videoViewIcon, String videoViewStr, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.bvId = null;
                } else {
                    this.bvId = bvId;
                }
                if ((seen0 & 2) == 0) {
                    this.contentType = null;
                } else {
                    this.contentType = contentType;
                }
                if ((seen0 & 4) == 0) {
                    this.ctime = null;
                } else {
                    this.ctime = ctime;
                }
                if ((seen0 & 8) == 0) {
                    this.ctimeStr = null;
                } else {
                    this.ctimeStr = ctimeStr;
                }
                if ((seen0 & 16) == 0) {
                    this.uid = null;
                } else {
                    this.uid = uid;
                }
                if ((seen0 & 32) == 0) {
                    this.upIcon = null;
                } else {
                    this.upIcon = upIcon;
                }
                if ((seen0 & 64) == 0) {
                    this.upName = null;
                } else {
                    this.upName = upName;
                }
                if ((seen0 & 128) == 0) {
                    this.upPic = null;
                } else {
                    this.upPic = upPic;
                }
                if ((seen0 & 256) == 0) {
                    this.upRole = null;
                } else {
                    this.upRole = upRole;
                }
                if ((seen0 & 512) == 0) {
                    this.upRoleTitle = null;
                } else {
                    this.upRoleTitle = upRoleTitle;
                }
                if ((seen0 & 1024) == 0) {
                    this.upRoleType = null;
                } else {
                    this.upRoleType = upRoleType;
                }
                if ((seen0 & 2048) == 0) {
                    this.videoDuration = null;
                } else {
                    this.videoDuration = videoDuration;
                }
                if ((seen0 & 4096) == 0) {
                    this.videoDurationStr = null;
                } else {
                    this.videoDurationStr = videoDurationStr;
                }
                if ((seen0 & 8192) == 0) {
                    this.videoImg = null;
                } else {
                    this.videoImg = videoImg;
                }
                if ((seen0 & 16384) == 0) {
                    this.videoTitle = null;
                } else {
                    this.videoTitle = videoTitle;
                }
                if ((seen0 & 32768) == 0) {
                    this.videoUrl = null;
                } else {
                    this.videoUrl = videoUrl;
                }
                if ((seen0 & 65536) == 0) {
                    this.videoView = null;
                } else {
                    this.videoView = videoView;
                }
                if ((seen0 & 131072) == 0) {
                    this.videoViewIcon = null;
                } else {
                    this.videoViewIcon = videoViewIcon;
                }
                if ((seen0 & 262144) == 0) {
                    this.videoViewStr = null;
                } else {
                    this.videoViewStr = videoViewStr;
                }
            }

            public ContentDetailVO(String bvId, Integer contentType, String ctime, String ctimeStr, Long uid, String upIcon, String upName, String upPic, Integer upRole, String upRoleTitle, Integer upRoleType, Long videoDuration, String videoDurationStr, String videoImg, String videoTitle, String videoUrl, Integer videoView, String videoViewIcon, String videoViewStr) {
                this.bvId = bvId;
                this.contentType = contentType;
                this.ctime = ctime;
                this.ctimeStr = ctimeStr;
                this.uid = uid;
                this.upIcon = upIcon;
                this.upName = upName;
                this.upPic = upPic;
                this.upRole = upRole;
                this.upRoleTitle = upRoleTitle;
                this.upRoleType = upRoleType;
                this.videoDuration = videoDuration;
                this.videoDurationStr = videoDurationStr;
                this.videoImg = videoImg;
                this.videoTitle = videoTitle;
                this.videoUrl = videoUrl;
                this.videoView = videoView;
                this.videoViewIcon = videoViewIcon;
                this.videoViewStr = videoViewStr;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(ContentDetailVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.bvId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.bvId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.contentType != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.contentType);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.ctime != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.ctime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.ctimeStr != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.ctimeStr);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.uid != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, LongSerializer.INSTANCE, self.uid);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.upIcon != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.upIcon);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.upName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.upName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.upPic != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.upPic);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.upRole != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.upRole);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.upRoleTitle != null) {
                    output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.upRoleTitle);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 10) || self.upRoleType != null) {
                    output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.upRoleType);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 11) || self.videoDuration != null) {
                    output.encodeNullableSerializableElement(serialDesc, 11, LongSerializer.INSTANCE, self.videoDuration);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 12) || self.videoDurationStr != null) {
                    output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.videoDurationStr);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 13) || self.videoImg != null) {
                    output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.videoImg);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 14) || self.videoTitle != null) {
                    output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.videoTitle);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 15) || self.videoUrl != null) {
                    output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.videoUrl);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 16) || self.videoView != null) {
                    output.encodeNullableSerializableElement(serialDesc, 16, IntSerializer.INSTANCE, self.videoView);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 17) || self.videoViewIcon != null) {
                    output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.videoViewIcon);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 18) || self.videoViewStr != null) {
                    output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.videoViewStr);
                }
            }

            public /* synthetic */ ContentDetailVO(String str, Integer num, String str2, String str3, Long l, String str4, String str5, String str6, Integer num2, String str7, Integer num3, Long l2, String str8, String str9, String str10, String str11, Integer num4, String str12, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : num2, (i & 512) != 0 ? null : str7, (i & 1024) != 0 ? null : num3, (i & 2048) != 0 ? null : l2, (i & 4096) != 0 ? null : str8, (i & 8192) != 0 ? null : str9, (i & 16384) != 0 ? null : str10, (i & 32768) != 0 ? null : str11, (i & 65536) != 0 ? null : num4, (i & 131072) != 0 ? null : str12, (i & 262144) != 0 ? null : str13);
            }

            public final String getBvId() {
                return this.bvId;
            }

            public final Integer getContentType() {
                return this.contentType;
            }

            public final String getCtime() {
                return this.ctime;
            }

            public final String getCtimeStr() {
                return this.ctimeStr;
            }

            public final Long getUid() {
                return this.uid;
            }

            public final String getUpIcon() {
                return this.upIcon;
            }

            public final String getUpName() {
                return this.upName;
            }

            public final String getUpPic() {
                return this.upPic;
            }

            public final Integer getUpRole() {
                return this.upRole;
            }

            public final String getUpRoleTitle() {
                return this.upRoleTitle;
            }

            public final Integer getUpRoleType() {
                return this.upRoleType;
            }

            public final Long getVideoDuration() {
                return this.videoDuration;
            }

            public final String getVideoDurationStr() {
                return this.videoDurationStr;
            }

            public final String getVideoImg() {
                return this.videoImg;
            }

            public final String getVideoTitle() {
                return this.videoTitle;
            }

            public final String getVideoUrl() {
                return this.videoUrl;
            }

            public final Integer getVideoView() {
                return this.videoView;
            }

            public final String getVideoViewIcon() {
                return this.videoViewIcon;
            }

            public final String getVideoViewStr() {
                return this.videoViewStr;
            }
        }

        public final TextColorModel getTitle() {
            return this.title;
        }
    }

    public final RecruitVO getRecruitVO() {
        return this.recruitVO;
    }

    /* compiled from: UpMeasureFloor.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006&"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$RecruitVO;", "", "desc", "Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "jumpUrl", "", "title", "<init>", "(Lkntr/app/mall/product/details/page/api/model/TextColorModel;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/TextColorModel;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/mall/product/details/page/api/model/TextColorModel;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/TextColorModel;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDesc", "()Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "getJumpUrl", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RecruitVO {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final TextColorModel desc;
        private final String jumpUrl;
        private final TextColorModel title;

        public RecruitVO() {
            this((TextColorModel) null, (String) null, (TextColorModel) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ RecruitVO copy$default(RecruitVO recruitVO, TextColorModel textColorModel, String str, TextColorModel textColorModel2, int i, Object obj) {
            if ((i & 1) != 0) {
                textColorModel = recruitVO.desc;
            }
            if ((i & 2) != 0) {
                str = recruitVO.jumpUrl;
            }
            if ((i & 4) != 0) {
                textColorModel2 = recruitVO.title;
            }
            return recruitVO.copy(textColorModel, str, textColorModel2);
        }

        public final TextColorModel component1() {
            return this.desc;
        }

        public final String component2() {
            return this.jumpUrl;
        }

        public final TextColorModel component3() {
            return this.title;
        }

        public final RecruitVO copy(TextColorModel textColorModel, String str, TextColorModel textColorModel2) {
            return new RecruitVO(textColorModel, str, textColorModel2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RecruitVO) {
                RecruitVO recruitVO = (RecruitVO) obj;
                return Intrinsics.areEqual(this.desc, recruitVO.desc) && Intrinsics.areEqual(this.jumpUrl, recruitVO.jumpUrl) && Intrinsics.areEqual(this.title, recruitVO.title);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.desc == null ? 0 : this.desc.hashCode()) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.title != null ? this.title.hashCode() : 0);
        }

        public String toString() {
            TextColorModel textColorModel = this.desc;
            String str = this.jumpUrl;
            return "RecruitVO(desc=" + textColorModel + ", jumpUrl=" + str + ", title=" + this.title + ")";
        }

        /* compiled from: UpMeasureFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$RecruitVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/UpMeasureFloor$RecruitVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<RecruitVO> serializer() {
                return UpMeasureFloor$RecruitVO$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ RecruitVO(int seen0, TextColorModel desc, String jumpUrl, TextColorModel title, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.desc = null;
            } else {
                this.desc = desc;
            }
            if ((seen0 & 2) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
            if ((seen0 & 4) == 0) {
                this.title = null;
            } else {
                this.title = title;
            }
        }

        public RecruitVO(TextColorModel desc, String jumpUrl, TextColorModel title) {
            this.desc = desc;
            this.jumpUrl = jumpUrl;
            this.title = title;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(RecruitVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.desc != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, TextColorModel$$serializer.INSTANCE, self.desc);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.jumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.title != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, TextColorModel$$serializer.INSTANCE, self.title);
            }
        }

        public /* synthetic */ RecruitVO(TextColorModel textColorModel, String str, TextColorModel textColorModel2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : textColorModel, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : textColorModel2);
        }

        public final TextColorModel getDesc() {
            return this.desc;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final TextColorModel getTitle() {
            return this.title;
        }
    }
}