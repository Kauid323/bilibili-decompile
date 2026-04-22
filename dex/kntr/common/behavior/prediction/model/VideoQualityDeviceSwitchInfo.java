package kntr.common.behavior.prediction.model;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.CommonProjectType;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: VideoQualityDeviceActionInfo.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 92\u00020\u0001:\u000289BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fBS\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003JO\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010+\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001J%\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0002\b7R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u0014R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0014R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0014R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b \u0010\"¨\u0006:"}, d2 = {"Lkntr/common/behavior/prediction/model/VideoQualityDeviceSwitchInfo;", "", "ctime", "", CommonProjectType.NETWORK, "", "fromQuality", "toQuality", "playerQuality", "holidayType", "vacationType", "<init>", "(JIIIIII)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJIIIIIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCtime", "()J", "getNetwork", "()I", "getFromQuality$annotations", "()V", "getFromQuality", "getToQuality$annotations", "getToQuality", "getPlayerQuality$annotations", "getPlayerQuality", "getHolidayType$annotations", "getHolidayType", "getVacationType$annotations", "getVacationType", "isWifi", "", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$behavior_prediction_debug", "$serializer", "Companion", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class VideoQualityDeviceSwitchInfo {
    public static final Companion Companion = new Companion(null);
    private final long ctime;
    private final int fromQuality;
    private final int holidayType;
    private final int network;
    private final int playerQuality;
    private final int toQuality;
    private final int vacationType;

    public VideoQualityDeviceSwitchInfo() {
        this(0L, 0, 0, 0, 0, 0, 0, 127, (DefaultConstructorMarker) null);
    }

    @SerialName("from_quality")
    public static /* synthetic */ void getFromQuality$annotations() {
    }

    @SerialName("holiday_type")
    public static /* synthetic */ void getHolidayType$annotations() {
    }

    @SerialName("player_quality")
    public static /* synthetic */ void getPlayerQuality$annotations() {
    }

    @SerialName("to_quality")
    public static /* synthetic */ void getToQuality$annotations() {
    }

    @SerialName("vacation_type")
    public static /* synthetic */ void getVacationType$annotations() {
    }

    public final long component1() {
        return this.ctime;
    }

    public final int component2() {
        return this.network;
    }

    public final int component3() {
        return this.fromQuality;
    }

    public final int component4() {
        return this.toQuality;
    }

    public final int component5() {
        return this.playerQuality;
    }

    public final int component6() {
        return this.holidayType;
    }

    public final int component7() {
        return this.vacationType;
    }

    public final VideoQualityDeviceSwitchInfo copy(long j, int i, int i2, int i3, int i4, int i5, int i6) {
        return new VideoQualityDeviceSwitchInfo(j, i, i2, i3, i4, i5, i6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoQualityDeviceSwitchInfo) {
            VideoQualityDeviceSwitchInfo videoQualityDeviceSwitchInfo = (VideoQualityDeviceSwitchInfo) obj;
            return this.ctime == videoQualityDeviceSwitchInfo.ctime && this.network == videoQualityDeviceSwitchInfo.network && this.fromQuality == videoQualityDeviceSwitchInfo.fromQuality && this.toQuality == videoQualityDeviceSwitchInfo.toQuality && this.playerQuality == videoQualityDeviceSwitchInfo.playerQuality && this.holidayType == videoQualityDeviceSwitchInfo.holidayType && this.vacationType == videoQualityDeviceSwitchInfo.vacationType;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.ctime) * 31) + this.network) * 31) + this.fromQuality) * 31) + this.toQuality) * 31) + this.playerQuality) * 31) + this.holidayType) * 31) + this.vacationType;
    }

    public String toString() {
        long j = this.ctime;
        int i = this.network;
        int i2 = this.fromQuality;
        int i3 = this.toQuality;
        int i4 = this.playerQuality;
        int i5 = this.holidayType;
        return "VideoQualityDeviceSwitchInfo(ctime=" + j + ", network=" + i + ", fromQuality=" + i2 + ", toQuality=" + i3 + ", playerQuality=" + i4 + ", holidayType=" + i5 + ", vacationType=" + this.vacationType + ")";
    }

    /* compiled from: VideoQualityDeviceActionInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/behavior/prediction/model/VideoQualityDeviceSwitchInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/behavior/prediction/model/VideoQualityDeviceSwitchInfo;", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<VideoQualityDeviceSwitchInfo> serializer() {
            return VideoQualityDeviceSwitchInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ VideoQualityDeviceSwitchInfo(int seen0, long ctime, int network, int fromQuality, int toQuality, int playerQuality, int holidayType, int vacationType, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.ctime = 0L;
        } else {
            this.ctime = ctime;
        }
        if ((seen0 & 2) == 0) {
            this.network = 1;
        } else {
            this.network = network;
        }
        if ((seen0 & 4) == 0) {
            this.fromQuality = -1;
        } else {
            this.fromQuality = fromQuality;
        }
        if ((seen0 & 8) == 0) {
            this.toQuality = -1;
        } else {
            this.toQuality = toQuality;
        }
        if ((seen0 & 16) == 0) {
            this.playerQuality = -1;
        } else {
            this.playerQuality = playerQuality;
        }
        if ((seen0 & 32) == 0) {
            this.holidayType = 0;
        } else {
            this.holidayType = holidayType;
        }
        if ((seen0 & 64) == 0) {
            this.vacationType = 3;
        } else {
            this.vacationType = vacationType;
        }
    }

    public VideoQualityDeviceSwitchInfo(long ctime, int network, int fromQuality, int toQuality, int playerQuality, int holidayType, int vacationType) {
        this.ctime = ctime;
        this.network = network;
        this.fromQuality = fromQuality;
        this.toQuality = toQuality;
        this.playerQuality = playerQuality;
        this.holidayType = holidayType;
        this.vacationType = vacationType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$behavior_prediction_debug(VideoQualityDeviceSwitchInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.ctime != 0) {
            output.encodeLongElement(serialDesc, 0, self.ctime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.network != 1) {
            output.encodeIntElement(serialDesc, 1, self.network);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.fromQuality != -1) {
            output.encodeIntElement(serialDesc, 2, self.fromQuality);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.toQuality != -1) {
            output.encodeIntElement(serialDesc, 3, self.toQuality);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.playerQuality != -1) {
            output.encodeIntElement(serialDesc, 4, self.playerQuality);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.holidayType != 0) {
            output.encodeIntElement(serialDesc, 5, self.holidayType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.vacationType != 3) {
            output.encodeIntElement(serialDesc, 6, self.vacationType);
        }
    }

    public /* synthetic */ VideoQualityDeviceSwitchInfo(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? 0L : j, (i7 & 2) != 0 ? 1 : i, (i7 & 4) != 0 ? -1 : i2, (i7 & 8) != 0 ? -1 : i3, (i7 & 16) == 0 ? i4 : -1, (i7 & 32) != 0 ? 0 : i5, (i7 & 64) != 0 ? 3 : i6);
    }

    public final long getCtime() {
        return this.ctime;
    }

    public final int getNetwork() {
        return this.network;
    }

    public final int getFromQuality() {
        return this.fromQuality;
    }

    public final int getToQuality() {
        return this.toQuality;
    }

    public final int getPlayerQuality() {
        return this.playerQuality;
    }

    public final int getHolidayType() {
        return this.holidayType;
    }

    public final int getVacationType() {
        return this.vacationType;
    }

    public final boolean isWifi() {
        return this.network == 1;
    }
}