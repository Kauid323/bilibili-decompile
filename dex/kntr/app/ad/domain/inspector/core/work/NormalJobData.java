package kntr.app.ad.domain.inspector.core.work;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.inspector.core.serializer.StatusSerializer;
import kntr.app.ad.domain.inspector.core.util.DateTimeUtils;
import kntr.app.ad.domain.inspector.core.util.IdGenerator;
import kntr.app.ad.domain.inspector.model.Status;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: JobData.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000289BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fBU\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJN\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u000eHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J%\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0002\b7R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\t\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\n\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001e¨\u0006:"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/NormalJobData;", "Lkntr/app/ad/domain/inspector/core/work/IJobData;", ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "name", AdAlarmExtraKey.STATUS, "Lkntr/app/ad/domain/inspector/model/Status;", "timestamp", RoomRecommendViewModel.EMPTY_CURSOR, "startTime", "endTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/inspector/model/Status;JLjava/lang/Long;Ljava/lang/Long;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/inspector/model/Status;JLjava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getStatus", "()Lkntr/app/ad/domain/inspector/model/Status;", "setStatus", "(Lkntr/app/ad/domain/inspector/model/Status;)V", "getTimestamp", "()J", "getStartTime", "()Ljava/lang/Long;", "setStartTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getEndTime", "setEndTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/inspector/model/Status;JLjava/lang/Long;Ljava/lang/Long;)Lkntr/app/ad/domain/inspector/core/work/NormalJobData;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$inspector_debug", "Companion", "$serializer", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class NormalJobData implements IJobData {
    private Long endTime;
    private final String id;
    private final String name;
    private Long startTime;
    private Status status;
    private final long timestamp;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ NormalJobData copy$default(NormalJobData normalJobData, String str, String str2, Status status, long j2, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = normalJobData.id;
        }
        if ((i & 2) != 0) {
            str2 = normalJobData.name;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            status = normalJobData.status;
        }
        Status status2 = status;
        if ((i & 8) != 0) {
            j2 = normalJobData.timestamp;
        }
        long j3 = j2;
        if ((i & 16) != 0) {
            l = normalJobData.startTime;
        }
        Long l3 = l;
        if ((i & 32) != 0) {
            l2 = normalJobData.endTime;
        }
        return normalJobData.copy(str, str3, status2, j3, l3, l2);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final Status component3() {
        return this.status;
    }

    public final long component4() {
        return this.timestamp;
    }

    public final Long component5() {
        return this.startTime;
    }

    public final Long component6() {
        return this.endTime;
    }

    public final NormalJobData copy(String str, String str2, Status status, long j2, Long l, Long l2) {
        Intrinsics.checkNotNullParameter(str, ReportBuildInParam.ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(status, AdAlarmExtraKey.STATUS);
        return new NormalJobData(str, str2, status, j2, l, l2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NormalJobData) {
            NormalJobData normalJobData = (NormalJobData) obj;
            return Intrinsics.areEqual(this.id, normalJobData.id) && Intrinsics.areEqual(this.name, normalJobData.name) && this.status == normalJobData.status && this.timestamp == normalJobData.timestamp && Intrinsics.areEqual(this.startTime, normalJobData.startTime) && Intrinsics.areEqual(this.endTime, normalJobData.endTime);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.status.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.timestamp)) * 31) + (this.startTime == null ? 0 : this.startTime.hashCode())) * 31) + (this.endTime != null ? this.endTime.hashCode() : 0);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.name;
        Status status = this.status;
        long j2 = this.timestamp;
        Long l = this.startTime;
        return "NormalJobData(id=" + str + ", name=" + str2 + ", status=" + status + ", timestamp=" + j2 + ", startTime=" + l + ", endTime=" + this.endTime + ")";
    }

    public /* synthetic */ NormalJobData(int seen0, String id, String name, Status status, long timestamp, Long startTime, Long endTime, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, NormalJobData$$serializer.INSTANCE.getDescriptor());
        }
        this.id = id;
        this.name = name;
        if ((seen0 & 4) == 0) {
            this.status = Status.PENDING;
        } else {
            this.status = status;
        }
        if ((seen0 & 8) == 0) {
            this.timestamp = DateTimeUtils.INSTANCE.currentTimeMillis();
        } else {
            this.timestamp = timestamp;
        }
        if ((seen0 & 16) == 0) {
            this.startTime = null;
        } else {
            this.startTime = startTime;
        }
        if ((seen0 & 32) == 0) {
            this.endTime = null;
        } else {
            this.endTime = endTime;
        }
    }

    public NormalJobData(String id, String name, Status status, long timestamp, Long startTime, Long endTime) {
        Intrinsics.checkNotNullParameter(id, ReportBuildInParam.ID);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(status, AdAlarmExtraKey.STATUS);
        this.id = id;
        this.name = name;
        this.status = status;
        this.timestamp = timestamp;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$inspector_debug(NormalJobData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.getId());
        output.encodeStringElement(serialDesc, 1, self.getName());
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getStatus() != Status.PENDING) {
            output.encodeSerializableElement(serialDesc, 2, StatusSerializer.INSTANCE, self.getStatus());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.getTimestamp() != DateTimeUtils.INSTANCE.currentTimeMillis()) {
            output.encodeLongElement(serialDesc, 3, self.getTimestamp());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.getStartTime() != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, LongSerializer.INSTANCE, self.getStartTime());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.getEndTime() != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, LongSerializer.INSTANCE, self.getEndTime());
        }
    }

    public /* synthetic */ NormalJobData(String str, String str2, Status status, long j2, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? Status.PENDING : status, (i & 8) != 0 ? DateTimeUtils.INSTANCE.currentTimeMillis() : j2, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : l2);
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IJobData
    public String getId() {
        return this.id;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IJobData
    public String getName() {
        return this.name;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IJobData
    public Status getStatus() {
        return this.status;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IJobData
    public void setStatus(Status status) {
        Intrinsics.checkNotNullParameter(status, "<set-?>");
        this.status = status;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IJobData
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IJobData
    public Long getStartTime() {
        return this.startTime;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IJobData
    public void setStartTime(Long l) {
        this.startTime = l;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IJobData
    public Long getEndTime() {
        return this.endTime;
    }

    @Override // kntr.app.ad.domain.inspector.core.work.IJobData
    public void setEndTime(Long l) {
        this.endTime = l;
    }

    /* compiled from: JobData.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/NormalJobData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "createJobData", "Lkntr/app/ad/domain/inspector/core/work/NormalJobData;", "name", RoomRecommendViewModel.EMPTY_CURSOR, "serializer", "Lkotlinx/serialization/KSerializer;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<NormalJobData> serializer() {
            return NormalJobData$$serializer.INSTANCE;
        }

        public final NormalJobData createJobData(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new NormalJobData(IdGenerator.INSTANCE.generateId("log_normal_"), name, (Status) null, 0L, (Long) null, (Long) null, 60, (DefaultConstructorMarker) null);
        }
    }
}