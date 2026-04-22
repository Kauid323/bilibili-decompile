package kntr.base.neuron.internal.model.pb;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.protobuf.ProtoNumber;

/* compiled from: info_raw.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000212B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bBE\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J;\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0019R\u001c\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0019¨\u00063"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppPageViewInfo;", "", "eventIdFrom", "", "loadType", "", "duration", "", "pvstart", "pvend", "<init>", "(Ljava/lang/String;IJJJ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;IJJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEventIdFrom$annotations", "()V", "getEventIdFrom", "()Ljava/lang/String;", "getLoadType$annotations", "getLoadType", "()I", "getDuration$annotations", "getDuration", "()J", "getPvstart$annotations", "getPvstart", "getPvend$annotations", "getPvend", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$neuron_debug", "Companion", "$serializer", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class KAppPageViewInfo {
    public static final Companion Companion = new Companion(null);
    public static final String targetPath = "/AppPageViewInfo";
    private final long duration;
    private final String eventIdFrom;
    private final int loadType;
    private final long pvend;
    private final long pvstart;

    public KAppPageViewInfo() {
        this((String) null, 0, 0L, 0L, 0L, 31, (DefaultConstructorMarker) null);
    }

    @SerialName("duration")
    @ProtoNumber(number = 5)
    public static /* synthetic */ void getDuration$annotations() {
    }

    @SerialName("eventIdFrom")
    @ProtoNumber(number = 1)
    public static /* synthetic */ void getEventIdFrom$annotations() {
    }

    @SerialName("loadType")
    @ProtoNumber(number = 4)
    public static /* synthetic */ void getLoadType$annotations() {
    }

    @SerialName("pvend")
    @ProtoNumber(number = AdditionalButton.CLICK_TYPE_FIELD_NUMBER)
    public static /* synthetic */ void getPvend$annotations() {
    }

    @SerialName("pvstart")
    @ProtoNumber(number = 6)
    public static /* synthetic */ void getPvstart$annotations() {
    }

    public final String component1() {
        return this.eventIdFrom;
    }

    public final int component2() {
        return this.loadType;
    }

    public final long component3() {
        return this.duration;
    }

    public final long component4() {
        return this.pvstart;
    }

    public final long component5() {
        return this.pvend;
    }

    public final KAppPageViewInfo copy(String str, int i, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(str, "eventIdFrom");
        return new KAppPageViewInfo(str, i, j, j2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KAppPageViewInfo) {
            KAppPageViewInfo kAppPageViewInfo = (KAppPageViewInfo) obj;
            return Intrinsics.areEqual(this.eventIdFrom, kAppPageViewInfo.eventIdFrom) && this.loadType == kAppPageViewInfo.loadType && this.duration == kAppPageViewInfo.duration && this.pvstart == kAppPageViewInfo.pvstart && this.pvend == kAppPageViewInfo.pvend;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.eventIdFrom.hashCode() * 31) + this.loadType) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.duration)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.pvstart)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.pvend);
    }

    public String toString() {
        String str = this.eventIdFrom;
        int i = this.loadType;
        long j = this.duration;
        long j2 = this.pvstart;
        return "KAppPageViewInfo(eventIdFrom=" + str + ", loadType=" + i + ", duration=" + j + ", pvstart=" + j2 + ", pvend=" + this.pvend + ")";
    }

    public /* synthetic */ KAppPageViewInfo(int seen0, String eventIdFrom, int loadType, long duration, long pvstart, long pvend, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.eventIdFrom = "";
        } else {
            this.eventIdFrom = eventIdFrom;
        }
        if ((seen0 & 2) == 0) {
            this.loadType = 0;
        } else {
            this.loadType = loadType;
        }
        if ((seen0 & 4) == 0) {
            this.duration = 0L;
        } else {
            this.duration = duration;
        }
        if ((seen0 & 8) == 0) {
            this.pvstart = 0L;
        } else {
            this.pvstart = pvstart;
        }
        if ((seen0 & 16) == 0) {
            this.pvend = 0L;
        } else {
            this.pvend = pvend;
        }
    }

    public KAppPageViewInfo(String eventIdFrom, int loadType, long duration, long pvstart, long pvend) {
        Intrinsics.checkNotNullParameter(eventIdFrom, "eventIdFrom");
        this.eventIdFrom = eventIdFrom;
        this.loadType = loadType;
        this.duration = duration;
        this.pvstart = pvstart;
        this.pvend = pvend;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$neuron_debug(KAppPageViewInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.eventIdFrom, "")) {
            output.encodeStringElement(serialDesc, 0, self.eventIdFrom);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.loadType != 0) {
            output.encodeIntElement(serialDesc, 1, self.loadType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.duration != 0) {
            output.encodeLongElement(serialDesc, 2, self.duration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.pvstart != 0) {
            output.encodeLongElement(serialDesc, 3, self.pvstart);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.pvend != 0) {
            output.encodeLongElement(serialDesc, 4, self.pvend);
        }
    }

    public /* synthetic */ KAppPageViewInfo(String str, int i, long j, long j2, long j3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? 0L : j, (i2 & 8) != 0 ? 0L : j2, (i2 & 16) == 0 ? j3 : 0L);
    }

    public final String getEventIdFrom() {
        return this.eventIdFrom;
    }

    public final int getLoadType() {
        return this.loadType;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getPvstart() {
        return this.pvstart;
    }

    public final long getPvend() {
        return this.pvend;
    }

    /* compiled from: info_raw.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkntr/base/neuron/internal/model/pb/KAppPageViewInfo$Companion;", "", "<init>", "()V", "targetPath", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/neuron/internal/model/pb/KAppPageViewInfo;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<KAppPageViewInfo> serializer() {
            return KAppPageViewInfo$$serializer.INSTANCE;
        }
    }
}