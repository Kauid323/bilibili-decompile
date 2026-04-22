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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CountDownInfoVO.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000289BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rB\u007f\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\f\u0010\u0016J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003JV\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u000fHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J%\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0002\b7R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006:"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;", "Lkntr/app/mall/product/details/page/api/model/ColorModel;", "countDownPrefix", "", "countDownSuffix", "serverTime", "", "leftTime", "showCountDown", "", "timeText", "Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/TextColorModel;)V", "seen0", "", "backDayColor", "backNightColor", "dayColor", "nightColor", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/TextColorModel;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCountDownPrefix", "()Ljava/lang/String;", "getCountDownSuffix", "getServerTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLeftTime", "getShowCountDown", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTimeText", "()Lkntr/app/mall/product/details/page/api/model/TextColorModel;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Lkntr/app/mall/product/details/page/api/model/TextColorModel;)Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class CountDownInfoVO extends ColorModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String countDownPrefix;
    private final String countDownSuffix;
    private final Long leftTime;
    private final Long serverTime;
    private final Boolean showCountDown;
    private final TextColorModel timeText;

    public CountDownInfoVO() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ CountDownInfoVO copy$default(CountDownInfoVO countDownInfoVO, String str, String str2, Long l, Long l2, Boolean bool, TextColorModel textColorModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = countDownInfoVO.countDownPrefix;
        }
        if ((i & 2) != 0) {
            str2 = countDownInfoVO.countDownSuffix;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            l = countDownInfoVO.serverTime;
        }
        Long l3 = l;
        if ((i & 8) != 0) {
            l2 = countDownInfoVO.leftTime;
        }
        Long l4 = l2;
        if ((i & 16) != 0) {
            bool = countDownInfoVO.showCountDown;
        }
        Boolean bool2 = bool;
        if ((i & 32) != 0) {
            textColorModel = countDownInfoVO.timeText;
        }
        return countDownInfoVO.copy(str, str3, l3, l4, bool2, textColorModel);
    }

    public final String component1() {
        return this.countDownPrefix;
    }

    public final String component2() {
        return this.countDownSuffix;
    }

    public final Long component3() {
        return this.serverTime;
    }

    public final Long component4() {
        return this.leftTime;
    }

    public final Boolean component5() {
        return this.showCountDown;
    }

    public final TextColorModel component6() {
        return this.timeText;
    }

    public final CountDownInfoVO copy(String str, String str2, Long l, Long l2, Boolean bool, TextColorModel textColorModel) {
        return new CountDownInfoVO(str, str2, l, l2, bool, textColorModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CountDownInfoVO) {
            CountDownInfoVO countDownInfoVO = (CountDownInfoVO) obj;
            return Intrinsics.areEqual(this.countDownPrefix, countDownInfoVO.countDownPrefix) && Intrinsics.areEqual(this.countDownSuffix, countDownInfoVO.countDownSuffix) && Intrinsics.areEqual(this.serverTime, countDownInfoVO.serverTime) && Intrinsics.areEqual(this.leftTime, countDownInfoVO.leftTime) && Intrinsics.areEqual(this.showCountDown, countDownInfoVO.showCountDown) && Intrinsics.areEqual(this.timeText, countDownInfoVO.timeText);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.countDownPrefix == null ? 0 : this.countDownPrefix.hashCode()) * 31) + (this.countDownSuffix == null ? 0 : this.countDownSuffix.hashCode())) * 31) + (this.serverTime == null ? 0 : this.serverTime.hashCode())) * 31) + (this.leftTime == null ? 0 : this.leftTime.hashCode())) * 31) + (this.showCountDown == null ? 0 : this.showCountDown.hashCode())) * 31) + (this.timeText != null ? this.timeText.hashCode() : 0);
    }

    public String toString() {
        String str = this.countDownPrefix;
        String str2 = this.countDownSuffix;
        Long l = this.serverTime;
        Long l2 = this.leftTime;
        Boolean bool = this.showCountDown;
        return "CountDownInfoVO(countDownPrefix=" + str + ", countDownSuffix=" + str2 + ", serverTime=" + l + ", leftTime=" + l2 + ", showCountDown=" + bool + ", timeText=" + this.timeText + ")";
    }

    /* compiled from: CountDownInfoVO.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/CountDownInfoVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CountDownInfoVO> serializer() {
            return CountDownInfoVO$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CountDownInfoVO(int seen0, String backDayColor, String backNightColor, String dayColor, String nightColor, String countDownPrefix, String countDownSuffix, Long serverTime, Long leftTime, Boolean showCountDown, TextColorModel timeText, SerializationConstructorMarker serializationConstructorMarker) {
        super(seen0, backDayColor, backNightColor, dayColor, nightColor, serializationConstructorMarker);
        if ((seen0 & 16) == 0) {
            this.countDownPrefix = null;
        } else {
            this.countDownPrefix = countDownPrefix;
        }
        if ((seen0 & 32) == 0) {
            this.countDownSuffix = null;
        } else {
            this.countDownSuffix = countDownSuffix;
        }
        if ((seen0 & 64) == 0) {
            this.serverTime = null;
        } else {
            this.serverTime = serverTime;
        }
        if ((seen0 & 128) == 0) {
            this.leftTime = null;
        } else {
            this.leftTime = leftTime;
        }
        if ((seen0 & 256) == 0) {
            this.showCountDown = null;
        } else {
            this.showCountDown = showCountDown;
        }
        if ((seen0 & 512) == 0) {
            this.timeText = null;
        } else {
            this.timeText = timeText;
        }
    }

    public CountDownInfoVO(String countDownPrefix, String countDownSuffix, Long serverTime, Long leftTime, Boolean showCountDown, TextColorModel timeText) {
        super((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        this.countDownPrefix = countDownPrefix;
        this.countDownSuffix = countDownSuffix;
        this.serverTime = serverTime;
        this.leftTime = leftTime;
        this.showCountDown = showCountDown;
        this.timeText = timeText;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(CountDownInfoVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        ColorModel.write$Self(self, output, serialDesc);
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.countDownPrefix != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.countDownPrefix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.countDownSuffix != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.countDownSuffix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.serverTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, LongSerializer.INSTANCE, self.serverTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.leftTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, LongSerializer.INSTANCE, self.leftTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.showCountDown != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, BooleanSerializer.INSTANCE, self.showCountDown);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.timeText != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, TextColorModel$$serializer.INSTANCE, self.timeText);
        }
    }

    public /* synthetic */ CountDownInfoVO(String str, String str2, Long l, Long l2, Boolean bool, TextColorModel textColorModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : textColorModel);
    }

    public final String getCountDownPrefix() {
        return this.countDownPrefix;
    }

    public final String getCountDownSuffix() {
        return this.countDownSuffix;
    }

    public final Long getServerTime() {
        return this.serverTime;
    }

    public final Long getLeftTime() {
        return this.leftTime;
    }

    public final Boolean getShowCountDown() {
        return this.showCountDown;
    }

    public final TextColorModel getTimeText() {
        return this.timeText;
    }
}