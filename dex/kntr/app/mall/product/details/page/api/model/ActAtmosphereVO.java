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

/* compiled from: AtmospherePriceFloor.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0002BCB\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0011\u0010\u0017J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00101\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0092\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\u000e2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0014HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001J%\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0001¢\u0006\u0002\bAR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b#\u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019¨\u0006D"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActAtmosphereVO;", "", "actLabel", "", "atmosEndTime", "", "atmosStartTime", "atmosphereImg", "floorKey", "leftLabel", "Lkntr/app/mall/product/details/page/api/model/LabelObject;", "rightLabel", "serverTime", "showCountDown", "", "countDownPrefix", "countDownSuffix", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/LabelObject;Lkntr/app/mall/product/details/page/api/model/LabelObject;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/LabelObject;Lkntr/app/mall/product/details/page/api/model/LabelObject;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActLabel", "()Ljava/lang/String;", "getAtmosEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAtmosStartTime", "getAtmosphereImg", "getFloorKey", "getLeftLabel", "()Lkntr/app/mall/product/details/page/api/model/LabelObject;", "getRightLabel", "getServerTime", "getShowCountDown", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCountDownPrefix", "getCountDownSuffix", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/LabelObject;Lkntr/app/mall/product/details/page/api/model/LabelObject;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/mall/product/details/page/api/model/ActAtmosphereVO;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ActAtmosphereVO {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String actLabel;
    private final Long atmosEndTime;
    private final Long atmosStartTime;
    private final String atmosphereImg;
    private final String countDownPrefix;
    private final String countDownSuffix;
    private final String floorKey;
    private final LabelObject leftLabel;
    private final LabelObject rightLabel;
    private final Long serverTime;
    private final Boolean showCountDown;

    public ActAtmosphereVO() {
        this((String) null, (Long) null, (Long) null, (String) null, (String) null, (LabelObject) null, (LabelObject) null, (Long) null, (Boolean) null, (String) null, (String) null, 2047, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.actLabel;
    }

    public final String component10() {
        return this.countDownPrefix;
    }

    public final String component11() {
        return this.countDownSuffix;
    }

    public final Long component2() {
        return this.atmosEndTime;
    }

    public final Long component3() {
        return this.atmosStartTime;
    }

    public final String component4() {
        return this.atmosphereImg;
    }

    public final String component5() {
        return this.floorKey;
    }

    public final LabelObject component6() {
        return this.leftLabel;
    }

    public final LabelObject component7() {
        return this.rightLabel;
    }

    public final Long component8() {
        return this.serverTime;
    }

    public final Boolean component9() {
        return this.showCountDown;
    }

    public final ActAtmosphereVO copy(String str, Long l, Long l2, String str2, String str3, LabelObject labelObject, LabelObject labelObject2, Long l3, Boolean bool, String str4, String str5) {
        return new ActAtmosphereVO(str, l, l2, str2, str3, labelObject, labelObject2, l3, bool, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActAtmosphereVO) {
            ActAtmosphereVO actAtmosphereVO = (ActAtmosphereVO) obj;
            return Intrinsics.areEqual(this.actLabel, actAtmosphereVO.actLabel) && Intrinsics.areEqual(this.atmosEndTime, actAtmosphereVO.atmosEndTime) && Intrinsics.areEqual(this.atmosStartTime, actAtmosphereVO.atmosStartTime) && Intrinsics.areEqual(this.atmosphereImg, actAtmosphereVO.atmosphereImg) && Intrinsics.areEqual(this.floorKey, actAtmosphereVO.floorKey) && Intrinsics.areEqual(this.leftLabel, actAtmosphereVO.leftLabel) && Intrinsics.areEqual(this.rightLabel, actAtmosphereVO.rightLabel) && Intrinsics.areEqual(this.serverTime, actAtmosphereVO.serverTime) && Intrinsics.areEqual(this.showCountDown, actAtmosphereVO.showCountDown) && Intrinsics.areEqual(this.countDownPrefix, actAtmosphereVO.countDownPrefix) && Intrinsics.areEqual(this.countDownSuffix, actAtmosphereVO.countDownSuffix);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((this.actLabel == null ? 0 : this.actLabel.hashCode()) * 31) + (this.atmosEndTime == null ? 0 : this.atmosEndTime.hashCode())) * 31) + (this.atmosStartTime == null ? 0 : this.atmosStartTime.hashCode())) * 31) + (this.atmosphereImg == null ? 0 : this.atmosphereImg.hashCode())) * 31) + (this.floorKey == null ? 0 : this.floorKey.hashCode())) * 31) + (this.leftLabel == null ? 0 : this.leftLabel.hashCode())) * 31) + (this.rightLabel == null ? 0 : this.rightLabel.hashCode())) * 31) + (this.serverTime == null ? 0 : this.serverTime.hashCode())) * 31) + (this.showCountDown == null ? 0 : this.showCountDown.hashCode())) * 31) + (this.countDownPrefix == null ? 0 : this.countDownPrefix.hashCode())) * 31) + (this.countDownSuffix != null ? this.countDownSuffix.hashCode() : 0);
    }

    public String toString() {
        String str = this.actLabel;
        Long l = this.atmosEndTime;
        Long l2 = this.atmosStartTime;
        String str2 = this.atmosphereImg;
        String str3 = this.floorKey;
        LabelObject labelObject = this.leftLabel;
        LabelObject labelObject2 = this.rightLabel;
        Long l3 = this.serverTime;
        Boolean bool = this.showCountDown;
        String str4 = this.countDownPrefix;
        return "ActAtmosphereVO(actLabel=" + str + ", atmosEndTime=" + l + ", atmosStartTime=" + l2 + ", atmosphereImg=" + str2 + ", floorKey=" + str3 + ", leftLabel=" + labelObject + ", rightLabel=" + labelObject2 + ", serverTime=" + l3 + ", showCountDown=" + bool + ", countDownPrefix=" + str4 + ", countDownSuffix=" + this.countDownSuffix + ")";
    }

    /* compiled from: AtmospherePriceFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActAtmosphereVO$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActAtmosphereVO;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ActAtmosphereVO> serializer() {
            return ActAtmosphereVO$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ActAtmosphereVO(int seen0, String actLabel, Long atmosEndTime, Long atmosStartTime, String atmosphereImg, String floorKey, LabelObject leftLabel, LabelObject rightLabel, Long serverTime, Boolean showCountDown, String countDownPrefix, String countDownSuffix, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.actLabel = null;
        } else {
            this.actLabel = actLabel;
        }
        if ((seen0 & 2) == 0) {
            this.atmosEndTime = null;
        } else {
            this.atmosEndTime = atmosEndTime;
        }
        if ((seen0 & 4) == 0) {
            this.atmosStartTime = null;
        } else {
            this.atmosStartTime = atmosStartTime;
        }
        if ((seen0 & 8) == 0) {
            this.atmosphereImg = null;
        } else {
            this.atmosphereImg = atmosphereImg;
        }
        if ((seen0 & 16) == 0) {
            this.floorKey = null;
        } else {
            this.floorKey = floorKey;
        }
        if ((seen0 & 32) == 0) {
            this.leftLabel = null;
        } else {
            this.leftLabel = leftLabel;
        }
        if ((seen0 & 64) == 0) {
            this.rightLabel = null;
        } else {
            this.rightLabel = rightLabel;
        }
        if ((seen0 & 128) == 0) {
            this.serverTime = null;
        } else {
            this.serverTime = serverTime;
        }
        if ((seen0 & 256) == 0) {
            this.showCountDown = null;
        } else {
            this.showCountDown = showCountDown;
        }
        if ((seen0 & 512) == 0) {
            this.countDownPrefix = null;
        } else {
            this.countDownPrefix = countDownPrefix;
        }
        if ((seen0 & 1024) == 0) {
            this.countDownSuffix = null;
        } else {
            this.countDownSuffix = countDownSuffix;
        }
    }

    public ActAtmosphereVO(String actLabel, Long atmosEndTime, Long atmosStartTime, String atmosphereImg, String floorKey, LabelObject leftLabel, LabelObject rightLabel, Long serverTime, Boolean showCountDown, String countDownPrefix, String countDownSuffix) {
        this.actLabel = actLabel;
        this.atmosEndTime = atmosEndTime;
        this.atmosStartTime = atmosStartTime;
        this.atmosphereImg = atmosphereImg;
        this.floorKey = floorKey;
        this.leftLabel = leftLabel;
        this.rightLabel = rightLabel;
        this.serverTime = serverTime;
        this.showCountDown = showCountDown;
        this.countDownPrefix = countDownPrefix;
        this.countDownSuffix = countDownSuffix;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(ActAtmosphereVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.actLabel != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.actLabel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.atmosEndTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.atmosEndTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.atmosStartTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.atmosStartTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.atmosphereImg != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.atmosphereImg);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.floorKey != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.floorKey);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.leftLabel != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, LabelObject$$serializer.INSTANCE, self.leftLabel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.rightLabel != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, LabelObject$$serializer.INSTANCE, self.rightLabel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.serverTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, LongSerializer.INSTANCE, self.serverTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.showCountDown != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, BooleanSerializer.INSTANCE, self.showCountDown);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.countDownPrefix != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.countDownPrefix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.countDownSuffix != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.countDownSuffix);
        }
    }

    public /* synthetic */ ActAtmosphereVO(String str, Long l, Long l2, String str2, String str3, LabelObject labelObject, LabelObject labelObject2, Long l3, Boolean bool, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : labelObject, (i & 64) != 0 ? null : labelObject2, (i & 128) != 0 ? null : l3, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? null : str4, (i & 1024) == 0 ? str5 : null);
    }

    public final String getActLabel() {
        return this.actLabel;
    }

    public final Long getAtmosEndTime() {
        return this.atmosEndTime;
    }

    public final Long getAtmosStartTime() {
        return this.atmosStartTime;
    }

    public final String getAtmosphereImg() {
        return this.atmosphereImg;
    }

    public final String getFloorKey() {
        return this.floorKey;
    }

    public final LabelObject getLeftLabel() {
        return this.leftLabel;
    }

    public final LabelObject getRightLabel() {
        return this.rightLabel;
    }

    public final Long getServerTime() {
        return this.serverTime;
    }

    public final Boolean getShowCountDown() {
        return this.showCountDown;
    }

    public final String getCountDownPrefix() {
        return this.countDownPrefix;
    }

    public final String getCountDownSuffix() {
        return this.countDownSuffix;
    }
}