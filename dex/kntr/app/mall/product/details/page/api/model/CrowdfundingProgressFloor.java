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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CrowdfundingProgressFloor.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 72\u00020\u0001:\u0003567Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eBg\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jh\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0010HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015¨\u00068"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "progressList", "", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor$ProgressItem;", "progressTitle", "showMore", "", "jumpUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getProgressList", "()Ljava/util/List;", "getProgressTitle", "getShowMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getJumpUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ProgressItem", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class CrowdfundingProgressFloor implements FloorModel {
    private final String bgImgUrl;
    private final String floorIcon;
    private final String floorKey;
    private final String jumpUrl;
    private final List<ProgressItem> progressList;
    private final String progressTitle;
    private final Boolean showMore;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.CrowdfundingProgressFloor$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = CrowdfundingProgressFloor._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null};

    public CrowdfundingProgressFloor() {
        this((String) null, (String) null, (String) null, (List) null, (String) null, (Boolean) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CrowdfundingProgressFloor copy$default(CrowdfundingProgressFloor crowdfundingProgressFloor, String str, String str2, String str3, List list, String str4, Boolean bool, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = crowdfundingProgressFloor.floorKey;
        }
        if ((i & 2) != 0) {
            str2 = crowdfundingProgressFloor.floorIcon;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = crowdfundingProgressFloor.bgImgUrl;
        }
        String str7 = str3;
        List<ProgressItem> list2 = list;
        if ((i & 8) != 0) {
            list2 = crowdfundingProgressFloor.progressList;
        }
        List list3 = list2;
        if ((i & 16) != 0) {
            str4 = crowdfundingProgressFloor.progressTitle;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            bool = crowdfundingProgressFloor.showMore;
        }
        Boolean bool2 = bool;
        if ((i & 64) != 0) {
            str5 = crowdfundingProgressFloor.jumpUrl;
        }
        return crowdfundingProgressFloor.copy(str, str6, str7, list3, str8, bool2, str5);
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

    public final List<ProgressItem> component4() {
        return this.progressList;
    }

    public final String component5() {
        return this.progressTitle;
    }

    public final Boolean component6() {
        return this.showMore;
    }

    public final String component7() {
        return this.jumpUrl;
    }

    public final CrowdfundingProgressFloor copy(String str, String str2, String str3, List<ProgressItem> list, String str4, Boolean bool, String str5) {
        return new CrowdfundingProgressFloor(str, str2, str3, list, str4, bool, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CrowdfundingProgressFloor) {
            CrowdfundingProgressFloor crowdfundingProgressFloor = (CrowdfundingProgressFloor) obj;
            return Intrinsics.areEqual(this.floorKey, crowdfundingProgressFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, crowdfundingProgressFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, crowdfundingProgressFloor.bgImgUrl) && Intrinsics.areEqual(this.progressList, crowdfundingProgressFloor.progressList) && Intrinsics.areEqual(this.progressTitle, crowdfundingProgressFloor.progressTitle) && Intrinsics.areEqual(this.showMore, crowdfundingProgressFloor.showMore) && Intrinsics.areEqual(this.jumpUrl, crowdfundingProgressFloor.jumpUrl);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.progressList == null ? 0 : this.progressList.hashCode())) * 31) + (this.progressTitle == null ? 0 : this.progressTitle.hashCode())) * 31) + (this.showMore == null ? 0 : this.showMore.hashCode())) * 31) + (this.jumpUrl != null ? this.jumpUrl.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        List<ProgressItem> list = this.progressList;
        String str4 = this.progressTitle;
        Boolean bool = this.showMore;
        return "CrowdfundingProgressFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", progressList=" + list + ", progressTitle=" + str4 + ", showMore=" + bool + ", jumpUrl=" + this.jumpUrl + ")";
    }

    /* compiled from: CrowdfundingProgressFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CrowdfundingProgressFloor> serializer() {
            return CrowdfundingProgressFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CrowdfundingProgressFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, List progressList, String progressTitle, Boolean showMore, String jumpUrl, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.progressList = null;
        } else {
            this.progressList = progressList;
        }
        if ((seen0 & 16) == 0) {
            this.progressTitle = null;
        } else {
            this.progressTitle = progressTitle;
        }
        if ((seen0 & 32) == 0) {
            this.showMore = null;
        } else {
            this.showMore = showMore;
        }
        if ((seen0 & 64) == 0) {
            this.jumpUrl = null;
        } else {
            this.jumpUrl = jumpUrl;
        }
    }

    public CrowdfundingProgressFloor(String floorKey, String floorIcon, String bgImgUrl, List<ProgressItem> list, String progressTitle, Boolean showMore, String jumpUrl) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.progressList = list;
        this.progressTitle = progressTitle;
        this.showMore = showMore;
        this.jumpUrl = jumpUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(CrowdfundingProgressFloor$ProgressItem$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(CrowdfundingProgressFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.progressList != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.progressList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.progressTitle != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.progressTitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.showMore != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.showMore);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.jumpUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.jumpUrl);
        }
    }

    public /* synthetic */ CrowdfundingProgressFloor(String str, String str2, String str3, List list, String str4, Boolean bool, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : str5);
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

    public final List<ProgressItem> getProgressList() {
        return this.progressList;
    }

    public final String getProgressTitle() {
        return this.progressTitle;
    }

    public final Boolean getShowMore() {
        return this.showMore;
    }

    /* compiled from: CrowdfundingProgressFloor.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 32\u00020\u0001:\u0003123BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fBW\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003JV\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u000eHÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016¨\u00064"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor$ProgressItem;", "", "contentId", "", "cover", "", "jumpUrl", "title", "userInfo", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor$ProgressItem$UserInfo;", "videoIcon", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor$ProgressItem$UserInfo;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor$ProgressItem$UserInfo;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getContentId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCover", "()Ljava/lang/String;", "getJumpUrl", "getTitle", "getUserInfo", "()Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor$ProgressItem$UserInfo;", "getVideoIcon", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor$ProgressItem$UserInfo;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor$ProgressItem;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "UserInfo", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ProgressItem {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final Long contentId;
        private final String cover;
        private final String jumpUrl;
        private final String title;
        private final UserInfo userInfo;
        private final String videoIcon;

        public ProgressItem() {
            this((Long) null, (String) null, (String) null, (String) null, (UserInfo) null, (String) null, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ProgressItem copy$default(ProgressItem progressItem, Long l, String str, String str2, String str3, UserInfo userInfo, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                l = progressItem.contentId;
            }
            if ((i & 2) != 0) {
                str = progressItem.cover;
            }
            String str5 = str;
            if ((i & 4) != 0) {
                str2 = progressItem.jumpUrl;
            }
            String str6 = str2;
            if ((i & 8) != 0) {
                str3 = progressItem.title;
            }
            String str7 = str3;
            if ((i & 16) != 0) {
                userInfo = progressItem.userInfo;
            }
            UserInfo userInfo2 = userInfo;
            if ((i & 32) != 0) {
                str4 = progressItem.videoIcon;
            }
            return progressItem.copy(l, str5, str6, str7, userInfo2, str4);
        }

        public final Long component1() {
            return this.contentId;
        }

        public final String component2() {
            return this.cover;
        }

        public final String component3() {
            return this.jumpUrl;
        }

        public final String component4() {
            return this.title;
        }

        public final UserInfo component5() {
            return this.userInfo;
        }

        public final String component6() {
            return this.videoIcon;
        }

        public final ProgressItem copy(Long l, String str, String str2, String str3, UserInfo userInfo, String str4) {
            return new ProgressItem(l, str, str2, str3, userInfo, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ProgressItem) {
                ProgressItem progressItem = (ProgressItem) obj;
                return Intrinsics.areEqual(this.contentId, progressItem.contentId) && Intrinsics.areEqual(this.cover, progressItem.cover) && Intrinsics.areEqual(this.jumpUrl, progressItem.jumpUrl) && Intrinsics.areEqual(this.title, progressItem.title) && Intrinsics.areEqual(this.userInfo, progressItem.userInfo) && Intrinsics.areEqual(this.videoIcon, progressItem.videoIcon);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((this.contentId == null ? 0 : this.contentId.hashCode()) * 31) + (this.cover == null ? 0 : this.cover.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.userInfo == null ? 0 : this.userInfo.hashCode())) * 31) + (this.videoIcon != null ? this.videoIcon.hashCode() : 0);
        }

        public String toString() {
            Long l = this.contentId;
            String str = this.cover;
            String str2 = this.jumpUrl;
            String str3 = this.title;
            UserInfo userInfo = this.userInfo;
            return "ProgressItem(contentId=" + l + ", cover=" + str + ", jumpUrl=" + str2 + ", title=" + str3 + ", userInfo=" + userInfo + ", videoIcon=" + this.videoIcon + ")";
        }

        /* compiled from: CrowdfundingProgressFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor$ProgressItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor$ProgressItem;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ProgressItem> serializer() {
                return CrowdfundingProgressFloor$ProgressItem$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ProgressItem(int seen0, Long contentId, String cover, String jumpUrl, String title, UserInfo userInfo, String videoIcon, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.contentId = null;
            } else {
                this.contentId = contentId;
            }
            if ((seen0 & 2) == 0) {
                this.cover = null;
            } else {
                this.cover = cover;
            }
            if ((seen0 & 4) == 0) {
                this.jumpUrl = null;
            } else {
                this.jumpUrl = jumpUrl;
            }
            if ((seen0 & 8) == 0) {
                this.title = null;
            } else {
                this.title = title;
            }
            if ((seen0 & 16) == 0) {
                this.userInfo = null;
            } else {
                this.userInfo = userInfo;
            }
            if ((seen0 & 32) == 0) {
                this.videoIcon = null;
            } else {
                this.videoIcon = videoIcon;
            }
        }

        public ProgressItem(Long contentId, String cover, String jumpUrl, String title, UserInfo userInfo, String videoIcon) {
            this.contentId = contentId;
            this.cover = cover;
            this.jumpUrl = jumpUrl;
            this.title = title;
            this.userInfo = userInfo;
            this.videoIcon = videoIcon;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ProgressItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.contentId != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.contentId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.cover != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.cover);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.jumpUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.jumpUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.title != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.title);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.userInfo != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, CrowdfundingProgressFloor$ProgressItem$UserInfo$$serializer.INSTANCE, self.userInfo);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.videoIcon != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.videoIcon);
            }
        }

        public /* synthetic */ ProgressItem(Long l, String str, String str2, String str3, UserInfo userInfo, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : userInfo, (i & 32) != 0 ? null : str4);
        }

        public final Long getContentId() {
            return this.contentId;
        }

        public final String getCover() {
            return this.cover;
        }

        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        public final String getTitle() {
            return this.title;
        }

        public final UserInfo getUserInfo() {
            return this.userInfo;
        }

        /* compiled from: CrowdfundingProgressFloor.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor$ProgressItem$UserInfo;", "", "avatar", "", "mid", "uname", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAvatar", "()Ljava/lang/String;", "getMid", "getUname", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class UserInfo {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String avatar;
            private final String mid;
            private final String uname;

            public UserInfo() {
                this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = userInfo.avatar;
                }
                if ((i & 2) != 0) {
                    str2 = userInfo.mid;
                }
                if ((i & 4) != 0) {
                    str3 = userInfo.uname;
                }
                return userInfo.copy(str, str2, str3);
            }

            public final String component1() {
                return this.avatar;
            }

            public final String component2() {
                return this.mid;
            }

            public final String component3() {
                return this.uname;
            }

            public final UserInfo copy(String str, String str2, String str3) {
                return new UserInfo(str, str2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof UserInfo) {
                    UserInfo userInfo = (UserInfo) obj;
                    return Intrinsics.areEqual(this.avatar, userInfo.avatar) && Intrinsics.areEqual(this.mid, userInfo.mid) && Intrinsics.areEqual(this.uname, userInfo.uname);
                }
                return false;
            }

            public int hashCode() {
                return ((((this.avatar == null ? 0 : this.avatar.hashCode()) * 31) + (this.mid == null ? 0 : this.mid.hashCode())) * 31) + (this.uname != null ? this.uname.hashCode() : 0);
            }

            public String toString() {
                String str = this.avatar;
                String str2 = this.mid;
                return "UserInfo(avatar=" + str + ", mid=" + str2 + ", uname=" + this.uname + ")";
            }

            /* compiled from: CrowdfundingProgressFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor$ProgressItem$UserInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor$ProgressItem$UserInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<UserInfo> serializer() {
                    return CrowdfundingProgressFloor$ProgressItem$UserInfo$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ UserInfo(int seen0, String avatar, String mid, String uname, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.avatar = null;
                } else {
                    this.avatar = avatar;
                }
                if ((seen0 & 2) == 0) {
                    this.mid = null;
                } else {
                    this.mid = mid;
                }
                if ((seen0 & 4) == 0) {
                    this.uname = null;
                } else {
                    this.uname = uname;
                }
            }

            public UserInfo(String avatar, String mid, String uname) {
                this.avatar = avatar;
                this.mid = mid;
                this.uname = uname;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(UserInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.avatar != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.avatar);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.mid != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.mid);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.uname != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.uname);
                }
            }

            public /* synthetic */ UserInfo(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }

            public final String getAvatar() {
                return this.avatar;
            }

            public final String getMid() {
                return this.mid;
            }

            public final String getUname() {
                return this.uname;
            }
        }

        public final String getVideoIcon() {
            return this.videoIcon;
        }
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }
}