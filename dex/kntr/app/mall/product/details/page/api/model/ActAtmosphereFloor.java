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

/* compiled from: ActAtmosphereFloor.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 J2\u00020\u0001:\u0002IJB£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014B\u009d\u0001\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0013\u0010\u0019J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00109\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010+Jª\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020\u00122\b\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020\u0016HÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001J%\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0001¢\u0006\u0002\bHR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b)\u0010 R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+¨\u0006K"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActAtmosphereFloor;", "Lkntr/app/mall/product/details/page/api/model/FloorModel;", "floorKey", "", "floorIcon", "bgImgUrl", "actLabel", "atmosEndTime", "", "atmosStartTime", "atmosphereImg", "countDownPrefix", "countDownSuffix", "leftLabel", "Lkntr/app/mall/product/details/page/api/model/LabelObject;", "rightLabel", "serverTime", "showCountDown", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/LabelObject;Lkntr/app/mall/product/details/page/api/model/LabelObject;Ljava/lang/Long;Ljava/lang/Boolean;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/LabelObject;Lkntr/app/mall/product/details/page/api/model/LabelObject;Ljava/lang/Long;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFloorKey", "()Ljava/lang/String;", "getFloorIcon", "getBgImgUrl", "getActLabel", "getAtmosEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAtmosStartTime", "getAtmosphereImg", "getCountDownPrefix", "getCountDownSuffix", "getLeftLabel", "()Lkntr/app/mall/product/details/page/api/model/LabelObject;", "getRightLabel", "getServerTime", "getShowCountDown", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/LabelObject;Lkntr/app/mall/product/details/page/api/model/LabelObject;Ljava/lang/Long;Ljava/lang/Boolean;)Lkntr/app/mall/product/details/page/api/model/ActAtmosphereFloor;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ActAtmosphereFloor implements FloorModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String actLabel;
    private final Long atmosEndTime;
    private final Long atmosStartTime;
    private final String atmosphereImg;
    private final String bgImgUrl;
    private final String countDownPrefix;
    private final String countDownSuffix;
    private final String floorIcon;
    private final String floorKey;
    private final LabelObject leftLabel;
    private final LabelObject rightLabel;
    private final Long serverTime;
    private final Boolean showCountDown;

    public ActAtmosphereFloor() {
        this((String) null, (String) null, (String) null, (String) null, (Long) null, (Long) null, (String) null, (String) null, (String) null, (LabelObject) null, (LabelObject) null, (Long) null, (Boolean) null, 8191, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.floorKey;
    }

    public final LabelObject component10() {
        return this.leftLabel;
    }

    public final LabelObject component11() {
        return this.rightLabel;
    }

    public final Long component12() {
        return this.serverTime;
    }

    public final Boolean component13() {
        return this.showCountDown;
    }

    public final String component2() {
        return this.floorIcon;
    }

    public final String component3() {
        return this.bgImgUrl;
    }

    public final String component4() {
        return this.actLabel;
    }

    public final Long component5() {
        return this.atmosEndTime;
    }

    public final Long component6() {
        return this.atmosStartTime;
    }

    public final String component7() {
        return this.atmosphereImg;
    }

    public final String component8() {
        return this.countDownPrefix;
    }

    public final String component9() {
        return this.countDownSuffix;
    }

    public final ActAtmosphereFloor copy(String str, String str2, String str3, String str4, Long l, Long l2, String str5, String str6, String str7, LabelObject labelObject, LabelObject labelObject2, Long l3, Boolean bool) {
        return new ActAtmosphereFloor(str, str2, str3, str4, l, l2, str5, str6, str7, labelObject, labelObject2, l3, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActAtmosphereFloor) {
            ActAtmosphereFloor actAtmosphereFloor = (ActAtmosphereFloor) obj;
            return Intrinsics.areEqual(this.floorKey, actAtmosphereFloor.floorKey) && Intrinsics.areEqual(this.floorIcon, actAtmosphereFloor.floorIcon) && Intrinsics.areEqual(this.bgImgUrl, actAtmosphereFloor.bgImgUrl) && Intrinsics.areEqual(this.actLabel, actAtmosphereFloor.actLabel) && Intrinsics.areEqual(this.atmosEndTime, actAtmosphereFloor.atmosEndTime) && Intrinsics.areEqual(this.atmosStartTime, actAtmosphereFloor.atmosStartTime) && Intrinsics.areEqual(this.atmosphereImg, actAtmosphereFloor.atmosphereImg) && Intrinsics.areEqual(this.countDownPrefix, actAtmosphereFloor.countDownPrefix) && Intrinsics.areEqual(this.countDownSuffix, actAtmosphereFloor.countDownSuffix) && Intrinsics.areEqual(this.leftLabel, actAtmosphereFloor.leftLabel) && Intrinsics.areEqual(this.rightLabel, actAtmosphereFloor.rightLabel) && Intrinsics.areEqual(this.serverTime, actAtmosphereFloor.serverTime) && Intrinsics.areEqual(this.showCountDown, actAtmosphereFloor.showCountDown);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((this.floorKey == null ? 0 : this.floorKey.hashCode()) * 31) + (this.floorIcon == null ? 0 : this.floorIcon.hashCode())) * 31) + (this.bgImgUrl == null ? 0 : this.bgImgUrl.hashCode())) * 31) + (this.actLabel == null ? 0 : this.actLabel.hashCode())) * 31) + (this.atmosEndTime == null ? 0 : this.atmosEndTime.hashCode())) * 31) + (this.atmosStartTime == null ? 0 : this.atmosStartTime.hashCode())) * 31) + (this.atmosphereImg == null ? 0 : this.atmosphereImg.hashCode())) * 31) + (this.countDownPrefix == null ? 0 : this.countDownPrefix.hashCode())) * 31) + (this.countDownSuffix == null ? 0 : this.countDownSuffix.hashCode())) * 31) + (this.leftLabel == null ? 0 : this.leftLabel.hashCode())) * 31) + (this.rightLabel == null ? 0 : this.rightLabel.hashCode())) * 31) + (this.serverTime == null ? 0 : this.serverTime.hashCode())) * 31) + (this.showCountDown != null ? this.showCountDown.hashCode() : 0);
    }

    public String toString() {
        String str = this.floorKey;
        String str2 = this.floorIcon;
        String str3 = this.bgImgUrl;
        String str4 = this.actLabel;
        Long l = this.atmosEndTime;
        Long l2 = this.atmosStartTime;
        String str5 = this.atmosphereImg;
        String str6 = this.countDownPrefix;
        String str7 = this.countDownSuffix;
        LabelObject labelObject = this.leftLabel;
        LabelObject labelObject2 = this.rightLabel;
        Long l3 = this.serverTime;
        return "ActAtmosphereFloor(floorKey=" + str + ", floorIcon=" + str2 + ", bgImgUrl=" + str3 + ", actLabel=" + str4 + ", atmosEndTime=" + l + ", atmosStartTime=" + l2 + ", atmosphereImg=" + str5 + ", countDownPrefix=" + str6 + ", countDownSuffix=" + str7 + ", leftLabel=" + labelObject + ", rightLabel=" + labelObject2 + ", serverTime=" + l3 + ", showCountDown=" + this.showCountDown + ")";
    }

    /* compiled from: ActAtmosphereFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/ActAtmosphereFloor$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/ActAtmosphereFloor;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ActAtmosphereFloor> serializer() {
            return ActAtmosphereFloor$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ActAtmosphereFloor(int seen0, String floorKey, String floorIcon, String bgImgUrl, String actLabel, Long atmosEndTime, Long atmosStartTime, String atmosphereImg, String countDownPrefix, String countDownSuffix, LabelObject leftLabel, LabelObject rightLabel, Long serverTime, Boolean showCountDown, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.actLabel = null;
        } else {
            this.actLabel = actLabel;
        }
        if ((seen0 & 16) == 0) {
            this.atmosEndTime = null;
        } else {
            this.atmosEndTime = atmosEndTime;
        }
        if ((seen0 & 32) == 0) {
            this.atmosStartTime = null;
        } else {
            this.atmosStartTime = atmosStartTime;
        }
        if ((seen0 & 64) == 0) {
            this.atmosphereImg = null;
        } else {
            this.atmosphereImg = atmosphereImg;
        }
        if ((seen0 & 128) == 0) {
            this.countDownPrefix = null;
        } else {
            this.countDownPrefix = countDownPrefix;
        }
        if ((seen0 & 256) == 0) {
            this.countDownSuffix = null;
        } else {
            this.countDownSuffix = countDownSuffix;
        }
        if ((seen0 & 512) == 0) {
            this.leftLabel = null;
        } else {
            this.leftLabel = leftLabel;
        }
        if ((seen0 & 1024) == 0) {
            this.rightLabel = null;
        } else {
            this.rightLabel = rightLabel;
        }
        if ((seen0 & 2048) == 0) {
            this.serverTime = null;
        } else {
            this.serverTime = serverTime;
        }
        if ((seen0 & 4096) == 0) {
            this.showCountDown = null;
        } else {
            this.showCountDown = showCountDown;
        }
    }

    public ActAtmosphereFloor(String floorKey, String floorIcon, String bgImgUrl, String actLabel, Long atmosEndTime, Long atmosStartTime, String atmosphereImg, String countDownPrefix, String countDownSuffix, LabelObject leftLabel, LabelObject rightLabel, Long serverTime, Boolean showCountDown) {
        this.floorKey = floorKey;
        this.floorIcon = floorIcon;
        this.bgImgUrl = bgImgUrl;
        this.actLabel = actLabel;
        this.atmosEndTime = atmosEndTime;
        this.atmosStartTime = atmosStartTime;
        this.atmosphereImg = atmosphereImg;
        this.countDownPrefix = countDownPrefix;
        this.countDownSuffix = countDownSuffix;
        this.leftLabel = leftLabel;
        this.rightLabel = rightLabel;
        this.serverTime = serverTime;
        this.showCountDown = showCountDown;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(ActAtmosphereFloor self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.getFloorKey() != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.getFloorKey());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getFloorIcon() != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getFloorIcon());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getBgImgUrl() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getBgImgUrl());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.actLabel != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.actLabel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.atmosEndTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, LongSerializer.INSTANCE, self.atmosEndTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.atmosStartTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, LongSerializer.INSTANCE, self.atmosStartTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.atmosphereImg != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.atmosphereImg);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.countDownPrefix != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.countDownPrefix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.countDownSuffix != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.countDownSuffix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.leftLabel != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, LabelObject$$serializer.INSTANCE, self.leftLabel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.rightLabel != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, LabelObject$$serializer.INSTANCE, self.rightLabel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.serverTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, LongSerializer.INSTANCE, self.serverTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.showCountDown != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, BooleanSerializer.INSTANCE, self.showCountDown);
        }
    }

    public /* synthetic */ ActAtmosphereFloor(String str, String str2, String str3, String str4, Long l, Long l2, String str5, String str6, String str7, LabelObject labelObject, LabelObject labelObject2, Long l3, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : l2, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : labelObject, (i & 1024) != 0 ? null : labelObject2, (i & 2048) != 0 ? null : l3, (i & 4096) == 0 ? bool : null);
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

    public final String getCountDownPrefix() {
        return this.countDownPrefix;
    }

    public final String getCountDownSuffix() {
        return this.countDownSuffix;
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
}