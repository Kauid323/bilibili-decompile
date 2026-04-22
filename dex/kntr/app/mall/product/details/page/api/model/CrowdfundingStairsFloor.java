package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.mall.product.details.page.api.model.CrowdfundingStairsFloor;
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

/* compiled from: CrowdfundingStairsFloor.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 ]2\u00020\u0001:\u0004Z[\\]BÓ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aBÇ\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0019\u0010\u001eJ\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010,J\u0011\u0010C\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010F\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00105J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÚ\u0001\u0010K\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00020\u00142\b\u0010N\u001a\u0004\u0018\u00010OHÖ\u0003J\t\u0010P\u001a\u00020\u0012HÖ\u0001J\t\u0010Q\u001a\u00020\u0003HÖ\u0001J%\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH\u0001¢\u0006\u0002\bYR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010-\u0012\u0004\b*\u0010'\u001a\u0004\b+\u0010,R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010 R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010 R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010 R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010 ¨\u0006^"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "achieveAmount", "achieveAmountPrefix", "achieveAmountStr", "crowdfundingActivityInfoVO", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$ActivityInfo;", "crowdfundingSuperposition", "", "levelList", "", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem;", "outShowLevelList", "percentage", "", "showMore", "", "statusIcon", "targetAmount", "targetAmountDesc", "jumpUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$ActivityInfo;Ljava/lang/Byte;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$ActivityInfo;Ljava/lang/Byte;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getAchieveAmount", "getAchieveAmountPrefix", "getAchieveAmountStr", "getCrowdfundingActivityInfoVO$annotations", "()V", "getCrowdfundingActivityInfoVO", "()Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$ActivityInfo;", "getCrowdfundingSuperposition$annotations", "getCrowdfundingSuperposition", "()Ljava/lang/Byte;", "Ljava/lang/Byte;", "getLevelList", "()Ljava/util/List;", "getOutShowLevelList", "getPercentage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStatusIcon", "getTargetAmount", "getTargetAmountDesc", "getJumpUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$ActivityInfo;Ljava/lang/Byte;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "ActivityInfo", "LevelItem", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class CrowdfundingStairsFloor implements FloorModel {
    private final String achieveAmount;
    private final String achieveAmountPrefix;
    private final String achieveAmountStr;
    private final String bgImgUrl;
    private final ActivityInfo crowdfundingActivityInfoVO;
    private final Byte crowdfundingSuperposition;
    private final String floorIcon;
    private final String floorKey;
    private final String jumpUrl;
    private final List<LevelItem> levelList;
    private final List<LevelItem> outShowLevelList;
    private final Integer percentage;
    private final Boolean showMore;
    private final String statusIcon;
    private final String targetAmount;
    private final String targetAmountDesc;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.CrowdfundingStairsFloor$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = CrowdfundingStairsFloor._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.CrowdfundingStairsFloor$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = CrowdfundingStairsFloor._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), null, null, null, null, null, null};

    public CrowdfundingStairsFloor() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ActivityInfo) null, (Byte) null, (List) null, (List) null, (Integer) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, 65535, (DefaultConstructorMarker) null);
    }

    @SerialName("crowdFundingActivityInfoVO")
    public static /* synthetic */ void getCrowdfundingActivityInfoVO$annotations() {
    }

    @SerialName("crowdFundingSuperposition")
    public static /* synthetic */ void getCrowdfundingSuperposition$annotations() {
    }

    public final String component1() {
        return this.floorKey;
    }

    public final List<LevelItem> component10() {
        return this.outShowLevelList;
    }

    public final Integer component11() {
        return this.percentage;
    }

    public final Boolean component12() {
        return this.showMore;
    }

    public final String component13() {
        return this.statusIcon;
    }

    public final String component14() {
        return this.targetAmount;
    }

    public final String component15() {
        return this.targetAmountDesc;
    }

    public final String component16() {
        return this.jumpUrl;
    }

    public final String component2() {
        return this.floorIcon;
    }

    public final String component3() {
        return this.bgImgUrl;
    }

    public final String component4() {
        return this.achieveAmount;
    }

    public final String component5() {
        return this.achieveAmountPrefix;
    }

    public final String component6() {
        return this.achieveAmountStr;
    }

    public final ActivityInfo component7() {
        return this.crowdfundingActivityInfoVO;
    }

    public final Byte component8() {
        return this.crowdfundingSuperposition;
    }

    public final List<LevelItem> component9() {
        return this.levelList;
    }

    public final CrowdfundingStairsFloor copy(String str, String str2, String str3, String str4, String str5, String str6, ActivityInfo activityInfo, Byte b, List<LevelItem> list, List<LevelItem> list2, Integer num, Boolean bool, String str7, String str8, String str9, String str10) {
        return new CrowdfundingStairsFloor(str, str2, str3, str4, str5, str6, activityInfo, b, list, list2, num, bool, str7, str8, str9, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CrowdfundingStairsFloor) {
            CrowdfundingStairsFloor crowdfundingStairsFloor = (CrowdfundingStairsFloor) obj;
            return Intrinsics.areEqual(this.floorKey, crowdfundingStairsFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, crowdfundingStairsFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, crowdfundingStairsFloor.bgImgUrl) && Intrinsics.areEqual(this.achieveAmount, crowdfundingStairsFloor.achieveAmount) && Intrinsics.areEqual(this.achieveAmountPrefix, crowdfundingStairsFloor.achieveAmountPrefix) && Intrinsics.areEqual(this.achieveAmountStr, crowdfundingStairsFloor.achieveAmountStr) && Intrinsics.areEqual(this.crowdfundingActivityInfoVO, crowdfundingStairsFloor.crowdfundingActivityInfoVO) && Intrinsics.areEqual(this.crowdfundingSuperposition, crowdfundingStairsFloor.crowdfundingSuperposition) && Intrinsics.areEqual(this.levelList, crowdfundingStairsFloor.levelList) && Intrinsics.areEqual(this.outShowLevelList, crowdfundingStairsFloor.outShowLevelList) && Intrinsics.areEqual(this.percentage, crowdfundingStairsFloor.percentage) && Intrinsics.areEqual(this.showMore, crowdfundingStairsFloor.showMore) && Intrinsics.areEqual(this.statusIcon, crowdfundingStairsFloor.statusIcon) && Intrinsics.areEqual(this.targetAmount, crowdfundingStairsFloor.targetAmount) && Intrinsics.areEqual(this.targetAmountDesc, crowdfundingStairsFloor.targetAmountDesc) && Intrinsics.areEqual(this.jumpUrl, crowdfundingStairsFloor.jumpUrl);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.achieveAmount == null ? 0 : this.achieveAmount.hashCode())) * 31) + (this.achieveAmountPrefix == null ? 0 : this.achieveAmountPrefix.hashCode())) * 31) + (this.achieveAmountStr == null ? 0 : this.achieveAmountStr.hashCode())) * 31) + (this.crowdfundingActivityInfoVO == null ? 0 : this.crowdfundingActivityInfoVO.hashCode())) * 31) + (this.crowdfundingSuperposition == null ? 0 : this.crowdfundingSuperposition.hashCode())) * 31) + (this.levelList == null ? 0 : this.levelList.hashCode())) * 31) + (this.outShowLevelList == null ? 0 : this.outShowLevelList.hashCode())) * 31) + (this.percentage == null ? 0 : this.percentage.hashCode())) * 31) + (this.showMore == null ? 0 : this.showMore.hashCode())) * 31) + (this.statusIcon == null ? 0 : this.statusIcon.hashCode())) * 31) + (this.targetAmount == null ? 0 : this.targetAmount.hashCode())) * 31) + (this.targetAmountDesc == null ? 0 : this.targetAmountDesc.hashCode())) * 31) + (this.jumpUrl != null ? this.jumpUrl.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        String str4 = this.achieveAmount;
        String str5 = this.achieveAmountPrefix;
        String str6 = this.achieveAmountStr;
        ActivityInfo activityInfo = this.crowdfundingActivityInfoVO;
        Byte b = this.crowdfundingSuperposition;
        List<LevelItem> list = this.levelList;
        List<LevelItem> list2 = this.outShowLevelList;
        Integer num = this.percentage;
        Boolean bool = this.showMore;
        String str7 = this.statusIcon;
        String str8 = this.targetAmount;
        String str9 = this.targetAmountDesc;
        return "CrowdfundingStairsFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", achieveAmount=" + str4 + ", achieveAmountPrefix=" + str5 + ", achieveAmountStr=" + str6 + ", crowdfundingActivityInfoVO=" + activityInfo + ", crowdfundingSuperposition=" + b + ", levelList=" + list + ", outShowLevelList=" + list2 + ", percentage=" + num + ", showMore=" + bool + ", statusIcon=" + str7 + ", targetAmount=" + str8 + ", targetAmountDesc=" + str9 + ", jumpUrl=" + this.jumpUrl + ")";
    }

    /* compiled from: CrowdfundingStairsFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CrowdfundingStairsFloor> serializer() {
            return CrowdfundingStairsFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CrowdfundingStairsFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, String achieveAmount, String achieveAmountPrefix, String achieveAmountStr, ActivityInfo crowdfundingActivityInfoVO, Byte crowdfundingSuperposition, List levelList, List outShowLevelList, Integer percentage, Boolean showMore, String statusIcon, String targetAmount, String targetAmountDesc, String jumpUrl, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.achieveAmount = null;
        } else {
            this.achieveAmount = achieveAmount;
        }
        if ((seen0 & 16) == 0) {
            this.achieveAmountPrefix = null;
        } else {
            this.achieveAmountPrefix = achieveAmountPrefix;
        }
        if ((seen0 & 32) == 0) {
            this.achieveAmountStr = null;
        } else {
            this.achieveAmountStr = achieveAmountStr;
        }
        if ((seen0 & 64) == 0) {
            this.crowdfundingActivityInfoVO = null;
        } else {
            this.crowdfundingActivityInfoVO = crowdfundingActivityInfoVO;
        }
        if ((seen0 & 128) == 0) {
            this.crowdfundingSuperposition = null;
        } else {
            this.crowdfundingSuperposition = crowdfundingSuperposition;
        }
        if ((seen0 & 256) == 0) {
            this.levelList = null;
        } else {
            this.levelList = levelList;
        }
        if ((seen0 & 512) == 0) {
            this.outShowLevelList = null;
        } else {
            this.outShowLevelList = outShowLevelList;
        }
        if ((seen0 & 1024) == 0) {
            this.percentage = null;
        } else {
            this.percentage = percentage;
        }
        if ((seen0 & 2048) == 0) {
            this.showMore = null;
        } else {
            this.showMore = showMore;
        }
        if ((seen0 & 4096) == 0) {
            this.statusIcon = null;
        } else {
            this.statusIcon = statusIcon;
        }
        if ((seen0 & 8192) == 0) {
            this.targetAmount = null;
        } else {
            this.targetAmount = targetAmount;
        }
        if ((seen0 & 16384) == 0) {
            this.targetAmountDesc = null;
        } else {
            this.targetAmountDesc = targetAmountDesc;
        }
        if ((seen0 & 32768) == 0) {
            this.jumpUrl = null;
        } else {
            this.jumpUrl = jumpUrl;
        }
    }

    public CrowdfundingStairsFloor(String floorKey, String floorIcon, String bgImgUrl, String achieveAmount, String achieveAmountPrefix, String achieveAmountStr, ActivityInfo crowdfundingActivityInfoVO, Byte crowdfundingSuperposition, List<LevelItem> list, List<LevelItem> list2, Integer percentage, Boolean showMore, String statusIcon, String targetAmount, String targetAmountDesc, String jumpUrl) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.achieveAmount = achieveAmount;
        this.achieveAmountPrefix = achieveAmountPrefix;
        this.achieveAmountStr = achieveAmountStr;
        this.crowdfundingActivityInfoVO = crowdfundingActivityInfoVO;
        this.crowdfundingSuperposition = crowdfundingSuperposition;
        this.levelList = list;
        this.outShowLevelList = list2;
        this.percentage = percentage;
        this.showMore = showMore;
        this.statusIcon = statusIcon;
        this.targetAmount = targetAmount;
        this.targetAmountDesc = targetAmountDesc;
        this.jumpUrl = jumpUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(CrowdfundingStairsFloor$LevelItem$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(CrowdfundingStairsFloor$LevelItem$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(CrowdfundingStairsFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.achieveAmount != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.achieveAmount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.achieveAmountPrefix != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.achieveAmountPrefix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.achieveAmountStr != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.achieveAmountStr);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.crowdfundingActivityInfoVO != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, CrowdfundingStairsFloor$ActivityInfo$$serializer.INSTANCE, self.crowdfundingActivityInfoVO);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.crowdfundingSuperposition != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, ByteSerializer.INSTANCE, self.crowdfundingSuperposition);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.levelList != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, lazyArr[8].getValue(), self.levelList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.outShowLevelList != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, lazyArr[9].getValue(), self.outShowLevelList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.percentage != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.percentage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.showMore != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, BooleanSerializer.INSTANCE, self.showMore);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.statusIcon != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.statusIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.targetAmount != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.targetAmount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.targetAmountDesc != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.targetAmountDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.jumpUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.jumpUrl);
        }
    }

    public /* synthetic */ CrowdfundingStairsFloor(String str, String str2, String str3, String str4, String str5, String str6, ActivityInfo activityInfo, Byte b, List list, List list2, Integer num, Boolean bool, String str7, String str8, String str9, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : activityInfo, (i & 128) != 0 ? null : b, (i & 256) != 0 ? null : list, (i & 512) != 0 ? null : list2, (i & 1024) != 0 ? null : num, (i & 2048) != 0 ? null : bool, (i & 4096) != 0 ? null : str7, (i & 8192) != 0 ? null : str8, (i & 16384) != 0 ? null : str9, (i & 32768) != 0 ? null : str10);
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

    public final String getAchieveAmount() {
        return this.achieveAmount;
    }

    public final String getAchieveAmountPrefix() {
        return this.achieveAmountPrefix;
    }

    public final String getAchieveAmountStr() {
        return this.achieveAmountStr;
    }

    public final ActivityInfo getCrowdfundingActivityInfoVO() {
        return this.crowdfundingActivityInfoVO;
    }

    public final Byte getCrowdfundingSuperposition() {
        return this.crowdfundingSuperposition;
    }

    public final List<LevelItem> getLevelList() {
        return this.levelList;
    }

    public final List<LevelItem> getOutShowLevelList() {
        return this.outShowLevelList;
    }

    public final Integer getPercentage() {
        return this.percentage;
    }

    public final Boolean getShowMore() {
        return this.showMore;
    }

    public final String getStatusIcon() {
        return this.statusIcon;
    }

    public final String getTargetAmount() {
        return this.targetAmount;
    }

    public final String getTargetAmountDesc() {
        return this.targetAmountDesc;
    }

    /* compiled from: CrowdfundingStairsFloor.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 B2\u00020\u0001:\u0002ABB\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012B\u0093\u0001\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0016J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u009e\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\bHÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001J%\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0001¢\u0006\u0002\b@R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0006\u0010\u001aR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b \u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0015\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\"\u0010\u001dR\u0015\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b#\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b%\u0010\u001dR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b&\u0010\u001d¨\u0006C"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$ActivityInfo;", "", "activityUrl", "", "hasActivity", "", "isJoined", "preheatTime", "", "prizeImg", "publishTime", "publishTimeDesc", "startTime", "status", "taskId", "waitLotteryNums", "waitLotteryRoundNums", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityUrl", "()Ljava/lang/String;", "getHasActivity", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPreheatTime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPrizeImg", "getPublishTime", "getPublishTimeDesc", "getStartTime", "getStatus", "getTaskId", "getWaitLotteryNums", "getWaitLotteryRoundNums", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$ActivityInfo;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ActivityInfo {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion(null);
        private final String activityUrl;
        private final Boolean hasActivity;
        private final Boolean isJoined;
        private final Integer preheatTime;
        private final String prizeImg;
        private final Integer publishTime;
        private final String publishTimeDesc;
        private final Integer startTime;
        private final Integer status;
        private final String taskId;
        private final Integer waitLotteryNums;
        private final Integer waitLotteryRoundNums;

        public ActivityInfo() {
            this((String) null, (Boolean) null, (Boolean) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (Integer) null, 4095, (DefaultConstructorMarker) null);
        }

        public final String component1() {
            return this.activityUrl;
        }

        public final String component10() {
            return this.taskId;
        }

        public final Integer component11() {
            return this.waitLotteryNums;
        }

        public final Integer component12() {
            return this.waitLotteryRoundNums;
        }

        public final Boolean component2() {
            return this.hasActivity;
        }

        public final Boolean component3() {
            return this.isJoined;
        }

        public final Integer component4() {
            return this.preheatTime;
        }

        public final String component5() {
            return this.prizeImg;
        }

        public final Integer component6() {
            return this.publishTime;
        }

        public final String component7() {
            return this.publishTimeDesc;
        }

        public final Integer component8() {
            return this.startTime;
        }

        public final Integer component9() {
            return this.status;
        }

        public final ActivityInfo copy(String str, Boolean bool, Boolean bool2, Integer num, String str2, Integer num2, String str3, Integer num3, Integer num4, String str4, Integer num5, Integer num6) {
            return new ActivityInfo(str, bool, bool2, num, str2, num2, str3, num3, num4, str4, num5, num6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ActivityInfo) {
                ActivityInfo activityInfo = (ActivityInfo) obj;
                return Intrinsics.areEqual(this.activityUrl, activityInfo.activityUrl) && Intrinsics.areEqual(this.hasActivity, activityInfo.hasActivity) && Intrinsics.areEqual(this.isJoined, activityInfo.isJoined) && Intrinsics.areEqual(this.preheatTime, activityInfo.preheatTime) && Intrinsics.areEqual(this.prizeImg, activityInfo.prizeImg) && Intrinsics.areEqual(this.publishTime, activityInfo.publishTime) && Intrinsics.areEqual(this.publishTimeDesc, activityInfo.publishTimeDesc) && Intrinsics.areEqual(this.startTime, activityInfo.startTime) && Intrinsics.areEqual(this.status, activityInfo.status) && Intrinsics.areEqual(this.taskId, activityInfo.taskId) && Intrinsics.areEqual(this.waitLotteryNums, activityInfo.waitLotteryNums) && Intrinsics.areEqual(this.waitLotteryRoundNums, activityInfo.waitLotteryRoundNums);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((this.activityUrl == null ? 0 : this.activityUrl.hashCode()) * 31) + (this.hasActivity == null ? 0 : this.hasActivity.hashCode())) * 31) + (this.isJoined == null ? 0 : this.isJoined.hashCode())) * 31) + (this.preheatTime == null ? 0 : this.preheatTime.hashCode())) * 31) + (this.prizeImg == null ? 0 : this.prizeImg.hashCode())) * 31) + (this.publishTime == null ? 0 : this.publishTime.hashCode())) * 31) + (this.publishTimeDesc == null ? 0 : this.publishTimeDesc.hashCode())) * 31) + (this.startTime == null ? 0 : this.startTime.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.taskId == null ? 0 : this.taskId.hashCode())) * 31) + (this.waitLotteryNums == null ? 0 : this.waitLotteryNums.hashCode())) * 31) + (this.waitLotteryRoundNums != null ? this.waitLotteryRoundNums.hashCode() : 0);
        }

        public String toString() {
            String str = this.activityUrl;
            Boolean bool = this.hasActivity;
            Boolean bool2 = this.isJoined;
            Integer num = this.preheatTime;
            String str2 = this.prizeImg;
            Integer num2 = this.publishTime;
            String str3 = this.publishTimeDesc;
            Integer num3 = this.startTime;
            Integer num4 = this.status;
            String str4 = this.taskId;
            Integer num5 = this.waitLotteryNums;
            return "ActivityInfo(activityUrl=" + str + ", hasActivity=" + bool + ", isJoined=" + bool2 + ", preheatTime=" + num + ", prizeImg=" + str2 + ", publishTime=" + num2 + ", publishTimeDesc=" + str3 + ", startTime=" + num3 + ", status=" + num4 + ", taskId=" + str4 + ", waitLotteryNums=" + num5 + ", waitLotteryRoundNums=" + this.waitLotteryRoundNums + ")";
        }

        /* compiled from: CrowdfundingStairsFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$ActivityInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$ActivityInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ActivityInfo> serializer() {
                return CrowdfundingStairsFloor$ActivityInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ActivityInfo(int seen0, String activityUrl, Boolean hasActivity, Boolean isJoined, Integer preheatTime, String prizeImg, Integer publishTime, String publishTimeDesc, Integer startTime, Integer status, String taskId, Integer waitLotteryNums, Integer waitLotteryRoundNums, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.activityUrl = null;
            } else {
                this.activityUrl = activityUrl;
            }
            if ((seen0 & 2) == 0) {
                this.hasActivity = null;
            } else {
                this.hasActivity = hasActivity;
            }
            if ((seen0 & 4) == 0) {
                this.isJoined = null;
            } else {
                this.isJoined = isJoined;
            }
            if ((seen0 & 8) == 0) {
                this.preheatTime = null;
            } else {
                this.preheatTime = preheatTime;
            }
            if ((seen0 & 16) == 0) {
                this.prizeImg = null;
            } else {
                this.prizeImg = prizeImg;
            }
            if ((seen0 & 32) == 0) {
                this.publishTime = null;
            } else {
                this.publishTime = publishTime;
            }
            if ((seen0 & 64) == 0) {
                this.publishTimeDesc = null;
            } else {
                this.publishTimeDesc = publishTimeDesc;
            }
            if ((seen0 & 128) == 0) {
                this.startTime = null;
            } else {
                this.startTime = startTime;
            }
            if ((seen0 & 256) == 0) {
                this.status = null;
            } else {
                this.status = status;
            }
            if ((seen0 & 512) == 0) {
                this.taskId = null;
            } else {
                this.taskId = taskId;
            }
            if ((seen0 & 1024) == 0) {
                this.waitLotteryNums = null;
            } else {
                this.waitLotteryNums = waitLotteryNums;
            }
            if ((seen0 & 2048) == 0) {
                this.waitLotteryRoundNums = null;
            } else {
                this.waitLotteryRoundNums = waitLotteryRoundNums;
            }
        }

        public ActivityInfo(String activityUrl, Boolean hasActivity, Boolean isJoined, Integer preheatTime, String prizeImg, Integer publishTime, String publishTimeDesc, Integer startTime, Integer status, String taskId, Integer waitLotteryNums, Integer waitLotteryRoundNums) {
            this.activityUrl = activityUrl;
            this.hasActivity = hasActivity;
            this.isJoined = isJoined;
            this.preheatTime = preheatTime;
            this.prizeImg = prizeImg;
            this.publishTime = publishTime;
            this.publishTimeDesc = publishTimeDesc;
            this.startTime = startTime;
            this.status = status;
            this.taskId = taskId;
            this.waitLotteryNums = waitLotteryNums;
            this.waitLotteryRoundNums = waitLotteryRoundNums;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(ActivityInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activityUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.activityUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.hasActivity != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.hasActivity);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.isJoined != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.isJoined);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.preheatTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.preheatTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.prizeImg != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.prizeImg);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.publishTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.publishTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.publishTimeDesc != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.publishTimeDesc);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.startTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, IntSerializer.INSTANCE, self.startTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.status != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.status);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.taskId != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.taskId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.waitLotteryNums != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.waitLotteryNums);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.waitLotteryRoundNums != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, IntSerializer.INSTANCE, self.waitLotteryRoundNums);
            }
        }

        public /* synthetic */ ActivityInfo(String str, Boolean bool, Boolean bool2, Integer num, String str2, Integer num2, String str3, Integer num3, Integer num4, String str4, Integer num5, Integer num6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : num3, (i & 256) != 0 ? null : num4, (i & 512) != 0 ? null : str4, (i & 1024) != 0 ? null : num5, (i & 2048) == 0 ? num6 : null);
        }

        public final String getActivityUrl() {
            return this.activityUrl;
        }

        public final Boolean getHasActivity() {
            return this.hasActivity;
        }

        public final Boolean isJoined() {
            return this.isJoined;
        }

        public final Integer getPreheatTime() {
            return this.preheatTime;
        }

        public final String getPrizeImg() {
            return this.prizeImg;
        }

        public final Integer getPublishTime() {
            return this.publishTime;
        }

        public final String getPublishTimeDesc() {
            return this.publishTimeDesc;
        }

        public final Integer getStartTime() {
            return this.startTime;
        }

        public final Integer getStatus() {
            return this.status;
        }

        public final String getTaskId() {
            return this.taskId;
        }

        public final Integer getWaitLotteryNums() {
            return this.waitLotteryNums;
        }

        public final Integer getWaitLotteryRoundNums() {
            return this.waitLotteryRoundNums;
        }
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* compiled from: CrowdfundingStairsFloor.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 I2\u00020\u0001:\u0004FGHIB\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0013\u0010\u0014B\u0085\u0001\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0018J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010*J\u000b\u00106\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u008c\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\tHÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001J%\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0001¢\u0006\u0002\bER\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b%\u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$¨\u0006J"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem;", "", "activityTitle", "", "activityUrl", "crowdfundingLevelGiftList", "", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$GiftItem;", "rewardGap", "", "rewardGapDesc", "Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "rewardStatus", "rewardStatusIcon", "skuId2GiftMap", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$SkuIdToGiftMap;", "targetAmount", "", "targetAmountDesc", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/TextColorModel;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$SkuIdToGiftMap;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/TextColorModel;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/TextColorModel;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$SkuIdToGiftMap;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/TextColorModel;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActivityTitle", "()Ljava/lang/String;", "getActivityUrl", "getCrowdfundingLevelGiftList$annotations", "()V", "getCrowdfundingLevelGiftList", "()Ljava/util/List;", "getRewardGap", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRewardGapDesc", "()Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "getRewardStatus", "getRewardStatusIcon", "getSkuId2GiftMap", "()Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$SkuIdToGiftMap;", "getTargetAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTargetAmountDesc", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lkntr/app/mall/product/details/page/api/model/TextColorModel;Ljava/lang/Integer;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$SkuIdToGiftMap;Ljava/lang/Long;Lkntr/app/mall/product/details/page/api/model/TextColorModel;)Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "GiftItem", "SkuIdToGiftMap", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LevelItem {
        private final String activityTitle;
        private final String activityUrl;
        private final List<GiftItem> crowdfundingLevelGiftList;
        private final Integer rewardGap;
        private final TextColorModel rewardGapDesc;
        private final Integer rewardStatus;
        private final String rewardStatusIcon;
        private final SkuIdToGiftMap skuId2GiftMap;
        private final Long targetAmount;
        private final TextColorModel targetAmountDesc;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.CrowdfundingStairsFloor$LevelItem$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = CrowdfundingStairsFloor.LevelItem._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, null, null, null, null, null, null};

        public LevelItem() {
            this((String) null, (String) null, (List) null, (Integer) null, (TextColorModel) null, (Integer) null, (String) null, (SkuIdToGiftMap) null, (Long) null, (TextColorModel) null, 1023, (DefaultConstructorMarker) null);
        }

        @SerialName("crowdFundingLevelGiftList")
        public static /* synthetic */ void getCrowdfundingLevelGiftList$annotations() {
        }

        public final String component1() {
            return this.activityTitle;
        }

        public final TextColorModel component10() {
            return this.targetAmountDesc;
        }

        public final String component2() {
            return this.activityUrl;
        }

        public final List<GiftItem> component3() {
            return this.crowdfundingLevelGiftList;
        }

        public final Integer component4() {
            return this.rewardGap;
        }

        public final TextColorModel component5() {
            return this.rewardGapDesc;
        }

        public final Integer component6() {
            return this.rewardStatus;
        }

        public final String component7() {
            return this.rewardStatusIcon;
        }

        public final SkuIdToGiftMap component8() {
            return this.skuId2GiftMap;
        }

        public final Long component9() {
            return this.targetAmount;
        }

        public final LevelItem copy(String str, String str2, List<GiftItem> list, Integer num, TextColorModel textColorModel, Integer num2, String str3, SkuIdToGiftMap skuIdToGiftMap, Long l, TextColorModel textColorModel2) {
            return new LevelItem(str, str2, list, num, textColorModel, num2, str3, skuIdToGiftMap, l, textColorModel2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LevelItem) {
                LevelItem levelItem = (LevelItem) obj;
                return Intrinsics.areEqual(this.activityTitle, levelItem.activityTitle) && Intrinsics.areEqual(this.activityUrl, levelItem.activityUrl) && Intrinsics.areEqual(this.crowdfundingLevelGiftList, levelItem.crowdfundingLevelGiftList) && Intrinsics.areEqual(this.rewardGap, levelItem.rewardGap) && Intrinsics.areEqual(this.rewardGapDesc, levelItem.rewardGapDesc) && Intrinsics.areEqual(this.rewardStatus, levelItem.rewardStatus) && Intrinsics.areEqual(this.rewardStatusIcon, levelItem.rewardStatusIcon) && Intrinsics.areEqual(this.skuId2GiftMap, levelItem.skuId2GiftMap) && Intrinsics.areEqual(this.targetAmount, levelItem.targetAmount) && Intrinsics.areEqual(this.targetAmountDesc, levelItem.targetAmountDesc);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((this.activityTitle == null ? 0 : this.activityTitle.hashCode()) * 31) + (this.activityUrl == null ? 0 : this.activityUrl.hashCode())) * 31) + (this.crowdfundingLevelGiftList == null ? 0 : this.crowdfundingLevelGiftList.hashCode())) * 31) + (this.rewardGap == null ? 0 : this.rewardGap.hashCode())) * 31) + (this.rewardGapDesc == null ? 0 : this.rewardGapDesc.hashCode())) * 31) + (this.rewardStatus == null ? 0 : this.rewardStatus.hashCode())) * 31) + (this.rewardStatusIcon == null ? 0 : this.rewardStatusIcon.hashCode())) * 31) + (this.skuId2GiftMap == null ? 0 : this.skuId2GiftMap.hashCode())) * 31) + (this.targetAmount == null ? 0 : this.targetAmount.hashCode())) * 31) + (this.targetAmountDesc != null ? this.targetAmountDesc.hashCode() : 0);
        }

        public String toString() {
            String str = this.activityTitle;
            String str2 = this.activityUrl;
            List<GiftItem> list = this.crowdfundingLevelGiftList;
            Integer num = this.rewardGap;
            TextColorModel textColorModel = this.rewardGapDesc;
            Integer num2 = this.rewardStatus;
            String str3 = this.rewardStatusIcon;
            SkuIdToGiftMap skuIdToGiftMap = this.skuId2GiftMap;
            Long l = this.targetAmount;
            return "LevelItem(activityTitle=" + str + ", activityUrl=" + str2 + ", crowdfundingLevelGiftList=" + list + ", rewardGap=" + num + ", rewardGapDesc=" + textColorModel + ", rewardStatus=" + num2 + ", rewardStatusIcon=" + str3 + ", skuId2GiftMap=" + skuIdToGiftMap + ", targetAmount=" + l + ", targetAmountDesc=" + this.targetAmountDesc + ")";
        }

        /* compiled from: CrowdfundingStairsFloor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<LevelItem> serializer() {
                return CrowdfundingStairsFloor$LevelItem$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ LevelItem(int seen0, String activityTitle, String activityUrl, List crowdfundingLevelGiftList, Integer rewardGap, TextColorModel rewardGapDesc, Integer rewardStatus, String rewardStatusIcon, SkuIdToGiftMap skuId2GiftMap, Long targetAmount, TextColorModel targetAmountDesc, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.activityTitle = null;
            } else {
                this.activityTitle = activityTitle;
            }
            if ((seen0 & 2) == 0) {
                this.activityUrl = null;
            } else {
                this.activityUrl = activityUrl;
            }
            if ((seen0 & 4) == 0) {
                this.crowdfundingLevelGiftList = null;
            } else {
                this.crowdfundingLevelGiftList = crowdfundingLevelGiftList;
            }
            if ((seen0 & 8) == 0) {
                this.rewardGap = null;
            } else {
                this.rewardGap = rewardGap;
            }
            if ((seen0 & 16) == 0) {
                this.rewardGapDesc = null;
            } else {
                this.rewardGapDesc = rewardGapDesc;
            }
            if ((seen0 & 32) == 0) {
                this.rewardStatus = null;
            } else {
                this.rewardStatus = rewardStatus;
            }
            if ((seen0 & 64) == 0) {
                this.rewardStatusIcon = null;
            } else {
                this.rewardStatusIcon = rewardStatusIcon;
            }
            if ((seen0 & 128) == 0) {
                this.skuId2GiftMap = null;
            } else {
                this.skuId2GiftMap = skuId2GiftMap;
            }
            if ((seen0 & 256) == 0) {
                this.targetAmount = null;
            } else {
                this.targetAmount = targetAmount;
            }
            if ((seen0 & 512) == 0) {
                this.targetAmountDesc = null;
            } else {
                this.targetAmountDesc = targetAmountDesc;
            }
        }

        public LevelItem(String activityTitle, String activityUrl, List<GiftItem> list, Integer rewardGap, TextColorModel rewardGapDesc, Integer rewardStatus, String rewardStatusIcon, SkuIdToGiftMap skuId2GiftMap, Long targetAmount, TextColorModel targetAmountDesc) {
            this.activityTitle = activityTitle;
            this.activityUrl = activityUrl;
            this.crowdfundingLevelGiftList = list;
            this.rewardGap = rewardGap;
            this.rewardGapDesc = rewardGapDesc;
            this.rewardStatus = rewardStatus;
            this.rewardStatusIcon = rewardStatusIcon;
            this.skuId2GiftMap = skuId2GiftMap;
            this.targetAmount = targetAmount;
            this.targetAmountDesc = targetAmountDesc;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(CrowdfundingStairsFloor$LevelItem$GiftItem$$serializer.INSTANCE);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$product_details_page_debug(LevelItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activityTitle != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.activityTitle);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.activityUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.activityUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.crowdfundingLevelGiftList != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.crowdfundingLevelGiftList);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.rewardGap != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.rewardGap);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.rewardGapDesc != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, TextColorModel$$serializer.INSTANCE, self.rewardGapDesc);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.rewardStatus != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.rewardStatus);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.rewardStatusIcon != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.rewardStatusIcon);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.skuId2GiftMap != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, CrowdfundingStairsFloor$LevelItem$SkuIdToGiftMap$$serializer.INSTANCE, self.skuId2GiftMap);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.targetAmount != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, LongSerializer.INSTANCE, self.targetAmount);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.targetAmountDesc != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, TextColorModel$$serializer.INSTANCE, self.targetAmountDesc);
            }
        }

        public /* synthetic */ LevelItem(String str, String str2, List list, Integer num, TextColorModel textColorModel, Integer num2, String str3, SkuIdToGiftMap skuIdToGiftMap, Long l, TextColorModel textColorModel2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : textColorModel, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : skuIdToGiftMap, (i & 256) != 0 ? null : l, (i & 512) == 0 ? textColorModel2 : null);
        }

        public final String getActivityTitle() {
            return this.activityTitle;
        }

        public final String getActivityUrl() {
            return this.activityUrl;
        }

        public final List<GiftItem> getCrowdfundingLevelGiftList() {
            return this.crowdfundingLevelGiftList;
        }

        public final Integer getRewardGap() {
            return this.rewardGap;
        }

        public final TextColorModel getRewardGapDesc() {
            return this.rewardGapDesc;
        }

        public final Integer getRewardStatus() {
            return this.rewardStatus;
        }

        public final String getRewardStatusIcon() {
            return this.rewardStatusIcon;
        }

        public final SkuIdToGiftMap getSkuId2GiftMap() {
            return this.skuId2GiftMap;
        }

        public final Long getTargetAmount() {
            return this.targetAmount;
        }

        /* compiled from: CrowdfundingStairsFloor.kt */
        @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 92\u00020\u0001:\u0003789Ba\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fBg\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0013J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010'\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001fJh\u0010(\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u000bHÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001f¨\u0006:"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$GiftItem;", "", "bindSkuVOS", "", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$GiftItem$BindSkuInfo;", "giftDeliveryRule", "", "giftDimensionRule", "giftImg", "giftName", "giftNum", "", "giftSkuId", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBindSkuVOS", "()Ljava/util/List;", "getGiftDeliveryRule", "()Ljava/lang/String;", "getGiftDimensionRule", "getGiftImg", "getGiftName", "getGiftNum", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGiftSkuId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;)Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$GiftItem;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "BindSkuInfo", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class GiftItem {
            private final List<BindSkuInfo> bindSkuVOS;
            private final String giftDeliveryRule;
            private final String giftDimensionRule;
            private final String giftImg;
            private final String giftName;
            private final Integer giftNum;
            private final Long giftSkuId;
            public static final Companion Companion = new Companion(null);
            public static final int $stable = 8;
            private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.CrowdfundingStairsFloor$LevelItem$GiftItem$$ExternalSyntheticLambda0
                public final Object invoke() {
                    KSerializer _childSerializers$_anonymous_;
                    _childSerializers$_anonymous_ = CrowdfundingStairsFloor.LevelItem.GiftItem._childSerializers$_anonymous_();
                    return _childSerializers$_anonymous_;
                }
            }), null, null, null, null, null, null};

            public GiftItem() {
                this((List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Long) null, 127, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ GiftItem copy$default(GiftItem giftItem, List list, String str, String str2, String str3, String str4, Integer num, Long l, int i, Object obj) {
                List<BindSkuInfo> list2 = list;
                if ((i & 1) != 0) {
                    list2 = giftItem.bindSkuVOS;
                }
                if ((i & 2) != 0) {
                    str = giftItem.giftDeliveryRule;
                }
                String str5 = str;
                if ((i & 4) != 0) {
                    str2 = giftItem.giftDimensionRule;
                }
                String str6 = str2;
                if ((i & 8) != 0) {
                    str3 = giftItem.giftImg;
                }
                String str7 = str3;
                if ((i & 16) != 0) {
                    str4 = giftItem.giftName;
                }
                String str8 = str4;
                if ((i & 32) != 0) {
                    num = giftItem.giftNum;
                }
                Integer num2 = num;
                if ((i & 64) != 0) {
                    l = giftItem.giftSkuId;
                }
                return giftItem.copy(list2, str5, str6, str7, str8, num2, l);
            }

            public final List<BindSkuInfo> component1() {
                return this.bindSkuVOS;
            }

            public final String component2() {
                return this.giftDeliveryRule;
            }

            public final String component3() {
                return this.giftDimensionRule;
            }

            public final String component4() {
                return this.giftImg;
            }

            public final String component5() {
                return this.giftName;
            }

            public final Integer component6() {
                return this.giftNum;
            }

            public final Long component7() {
                return this.giftSkuId;
            }

            public final GiftItem copy(List<BindSkuInfo> list, String str, String str2, String str3, String str4, Integer num, Long l) {
                return new GiftItem(list, str, str2, str3, str4, num, l);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof GiftItem) {
                    GiftItem giftItem = (GiftItem) obj;
                    return Intrinsics.areEqual(this.bindSkuVOS, giftItem.bindSkuVOS) && Intrinsics.areEqual(this.giftDeliveryRule, giftItem.giftDeliveryRule) && Intrinsics.areEqual(this.giftDimensionRule, giftItem.giftDimensionRule) && Intrinsics.areEqual(this.giftImg, giftItem.giftImg) && Intrinsics.areEqual(this.giftName, giftItem.giftName) && Intrinsics.areEqual(this.giftNum, giftItem.giftNum) && Intrinsics.areEqual(this.giftSkuId, giftItem.giftSkuId);
                }
                return false;
            }

            public int hashCode() {
                return ((((((((((((this.bindSkuVOS == null ? 0 : this.bindSkuVOS.hashCode()) * 31) + (this.giftDeliveryRule == null ? 0 : this.giftDeliveryRule.hashCode())) * 31) + (this.giftDimensionRule == null ? 0 : this.giftDimensionRule.hashCode())) * 31) + (this.giftImg == null ? 0 : this.giftImg.hashCode())) * 31) + (this.giftName == null ? 0 : this.giftName.hashCode())) * 31) + (this.giftNum == null ? 0 : this.giftNum.hashCode())) * 31) + (this.giftSkuId != null ? this.giftSkuId.hashCode() : 0);
            }

            public String toString() {
                List<BindSkuInfo> list = this.bindSkuVOS;
                String str = this.giftDeliveryRule;
                String str2 = this.giftDimensionRule;
                String str3 = this.giftImg;
                String str4 = this.giftName;
                Integer num = this.giftNum;
                return "GiftItem(bindSkuVOS=" + list + ", giftDeliveryRule=" + str + ", giftDimensionRule=" + str2 + ", giftImg=" + str3 + ", giftName=" + str4 + ", giftNum=" + num + ", giftSkuId=" + this.giftSkuId + ")";
            }

            /* compiled from: CrowdfundingStairsFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$GiftItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$GiftItem;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<GiftItem> serializer() {
                    return CrowdfundingStairsFloor$LevelItem$GiftItem$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ GiftItem(int seen0, List bindSkuVOS, String giftDeliveryRule, String giftDimensionRule, String giftImg, String giftName, Integer giftNum, Long giftSkuId, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.bindSkuVOS = null;
                } else {
                    this.bindSkuVOS = bindSkuVOS;
                }
                if ((seen0 & 2) == 0) {
                    this.giftDeliveryRule = null;
                } else {
                    this.giftDeliveryRule = giftDeliveryRule;
                }
                if ((seen0 & 4) == 0) {
                    this.giftDimensionRule = null;
                } else {
                    this.giftDimensionRule = giftDimensionRule;
                }
                if ((seen0 & 8) == 0) {
                    this.giftImg = null;
                } else {
                    this.giftImg = giftImg;
                }
                if ((seen0 & 16) == 0) {
                    this.giftName = null;
                } else {
                    this.giftName = giftName;
                }
                if ((seen0 & 32) == 0) {
                    this.giftNum = null;
                } else {
                    this.giftNum = giftNum;
                }
                if ((seen0 & 64) == 0) {
                    this.giftSkuId = null;
                } else {
                    this.giftSkuId = giftSkuId;
                }
            }

            public GiftItem(List<BindSkuInfo> list, String giftDeliveryRule, String giftDimensionRule, String giftImg, String giftName, Integer giftNum, Long giftSkuId) {
                this.bindSkuVOS = list;
                this.giftDeliveryRule = giftDeliveryRule;
                this.giftDimensionRule = giftDimensionRule;
                this.giftImg = giftImg;
                this.giftName = giftName;
                this.giftNum = giftNum;
                this.giftSkuId = giftSkuId;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(CrowdfundingStairsFloor$LevelItem$GiftItem$BindSkuInfo$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(GiftItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.bindSkuVOS != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.bindSkuVOS);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.giftDeliveryRule != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.giftDeliveryRule);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.giftDimensionRule != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.giftDimensionRule);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.giftImg != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.giftImg);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.giftName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.giftName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.giftNum != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.giftNum);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.giftSkuId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, LongSerializer.INSTANCE, self.giftSkuId);
                }
            }

            public /* synthetic */ GiftItem(List list, String str, String str2, String str3, String str4, Integer num, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : l);
            }

            public final List<BindSkuInfo> getBindSkuVOS() {
                return this.bindSkuVOS;
            }

            public final String getGiftDeliveryRule() {
                return this.giftDeliveryRule;
            }

            public final String getGiftDimensionRule() {
                return this.giftDimensionRule;
            }

            public final String getGiftImg() {
                return this.giftImg;
            }

            public final String getGiftName() {
                return this.giftName;
            }

            public final Integer getGiftNum() {
                return this.giftNum;
            }

            /* compiled from: CrowdfundingStairsFloor.kt */
            @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\tHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006%"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$GiftItem$BindSkuInfo;", "", "skuId", "", "specDesc", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSkuId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSpecDesc", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$GiftItem$BindSkuInfo;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class BindSkuInfo {
                public static final int $stable = 0;
                public static final Companion Companion = new Companion(null);
                private final Long skuId;
                private final String specDesc;

                public BindSkuInfo() {
                    this((Long) null, (String) null, 3, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ BindSkuInfo copy$default(BindSkuInfo bindSkuInfo, Long l, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        l = bindSkuInfo.skuId;
                    }
                    if ((i & 2) != 0) {
                        str = bindSkuInfo.specDesc;
                    }
                    return bindSkuInfo.copy(l, str);
                }

                public final Long component1() {
                    return this.skuId;
                }

                public final String component2() {
                    return this.specDesc;
                }

                public final BindSkuInfo copy(Long l, String str) {
                    return new BindSkuInfo(l, str);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof BindSkuInfo) {
                        BindSkuInfo bindSkuInfo = (BindSkuInfo) obj;
                        return Intrinsics.areEqual(this.skuId, bindSkuInfo.skuId) && Intrinsics.areEqual(this.specDesc, bindSkuInfo.specDesc);
                    }
                    return false;
                }

                public int hashCode() {
                    return ((this.skuId == null ? 0 : this.skuId.hashCode()) * 31) + (this.specDesc != null ? this.specDesc.hashCode() : 0);
                }

                public String toString() {
                    Long l = this.skuId;
                    return "BindSkuInfo(skuId=" + l + ", specDesc=" + this.specDesc + ")";
                }

                /* compiled from: CrowdfundingStairsFloor.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$GiftItem$BindSkuInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$GiftItem$BindSkuInfo;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<BindSkuInfo> serializer() {
                        return CrowdfundingStairsFloor$LevelItem$GiftItem$BindSkuInfo$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ BindSkuInfo(int seen0, Long skuId, String specDesc, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.skuId = null;
                    } else {
                        this.skuId = skuId;
                    }
                    if ((seen0 & 2) == 0) {
                        this.specDesc = null;
                    } else {
                        this.specDesc = specDesc;
                    }
                }

                public BindSkuInfo(Long skuId, String specDesc) {
                    this.skuId = skuId;
                    this.specDesc = specDesc;
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$product_details_page_debug(BindSkuInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.skuId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.skuId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.specDesc != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.specDesc);
                    }
                }

                public /* synthetic */ BindSkuInfo(Long l, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str);
                }

                public final Long getSkuId() {
                    return this.skuId;
                }

                public final String getSpecDesc() {
                    return this.specDesc;
                }
            }

            public final Long getGiftSkuId() {
                return this.giftSkuId;
            }
        }

        public final TextColorModel getTargetAmountDesc() {
            return this.targetAmountDesc;
        }

        /* compiled from: CrowdfundingStairsFloor.kt */
        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\nHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$SkuIdToGiftMap;", "", "giftVOS", "", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$GiftItem;", "specDesc", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGiftVOS", "()Ljava/util/List;", "getSpecDesc", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        @Serializable
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class SkuIdToGiftMap {
            private final List<GiftItem> giftVOS;
            private final String specDesc;
            public static final Companion Companion = new Companion(null);
            public static final int $stable = 8;
            private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.CrowdfundingStairsFloor$LevelItem$SkuIdToGiftMap$$ExternalSyntheticLambda0
                public final Object invoke() {
                    KSerializer _childSerializers$_anonymous_;
                    _childSerializers$_anonymous_ = CrowdfundingStairsFloor.LevelItem.SkuIdToGiftMap._childSerializers$_anonymous_();
                    return _childSerializers$_anonymous_;
                }
            }), null};

            public SkuIdToGiftMap() {
                this((List) null, (String) null, 3, (DefaultConstructorMarker) null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SkuIdToGiftMap copy$default(SkuIdToGiftMap skuIdToGiftMap, List list, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = skuIdToGiftMap.giftVOS;
                }
                if ((i & 2) != 0) {
                    str = skuIdToGiftMap.specDesc;
                }
                return skuIdToGiftMap.copy(list, str);
            }

            public final List<GiftItem> component1() {
                return this.giftVOS;
            }

            public final String component2() {
                return this.specDesc;
            }

            public final SkuIdToGiftMap copy(List<GiftItem> list, String str) {
                return new SkuIdToGiftMap(list, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof SkuIdToGiftMap) {
                    SkuIdToGiftMap skuIdToGiftMap = (SkuIdToGiftMap) obj;
                    return Intrinsics.areEqual(this.giftVOS, skuIdToGiftMap.giftVOS) && Intrinsics.areEqual(this.specDesc, skuIdToGiftMap.specDesc);
                }
                return false;
            }

            public int hashCode() {
                return ((this.giftVOS == null ? 0 : this.giftVOS.hashCode()) * 31) + (this.specDesc != null ? this.specDesc.hashCode() : 0);
            }

            public String toString() {
                List<GiftItem> list = this.giftVOS;
                return "SkuIdToGiftMap(giftVOS=" + list + ", specDesc=" + this.specDesc + ")";
            }

            /* compiled from: CrowdfundingStairsFloor.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$SkuIdToGiftMap$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingStairsFloor$LevelItem$SkuIdToGiftMap;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<SkuIdToGiftMap> serializer() {
                    return CrowdfundingStairsFloor$LevelItem$SkuIdToGiftMap$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ SkuIdToGiftMap(int seen0, List giftVOS, String specDesc, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.giftVOS = null;
                } else {
                    this.giftVOS = giftVOS;
                }
                if ((seen0 & 2) == 0) {
                    this.specDesc = null;
                } else {
                    this.specDesc = specDesc;
                }
            }

            public SkuIdToGiftMap(List<GiftItem> list, String specDesc) {
                this.giftVOS = list;
                this.specDesc = specDesc;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(CrowdfundingStairsFloor$LevelItem$GiftItem$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$product_details_page_debug(SkuIdToGiftMap self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.giftVOS != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.giftVOS);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.specDesc != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.specDesc);
                }
            }

            public /* synthetic */ SkuIdToGiftMap(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str);
            }

            public final List<GiftItem> getGiftVOS() {
                return this.giftVOS;
            }

            public final String getSpecDesc() {
                return this.specDesc;
            }
        }
    }
}