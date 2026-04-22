package kntr.app.ad.domain.inspector.core.work;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.Locale;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.inspector.core.serializer.StatusSerializer;
import kntr.app.ad.domain.inspector.core.util.DateTimeUtils;
import kntr.app.ad.domain.inspector.core.util.IdGenerator;
import kntr.app.ad.domain.inspector.model.Status;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: JobData.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0002@ABS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fBi\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u0010.\u001a\u00020\fHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003Jb\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0011HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001J%\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0001¢\u0006\u0002\b?R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\t\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\n\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0016¨\u0006B"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/PrintJobData;", "Lkntr/app/ad/domain/inspector/core/work/IJobData;", ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "name", AdAlarmExtraKey.STATUS, "Lkntr/app/ad/domain/inspector/model/Status;", "timestamp", RoomRecommendViewModel.EMPTY_CURSOR, "startTime", "endTime", "type", "Lkntr/app/ad/domain/inspector/core/work/PrintType;", "msg", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/inspector/model/Status;JLjava/lang/Long;Ljava/lang/Long;Lkntr/app/ad/domain/inspector/core/work/PrintType;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/inspector/model/Status;JLjava/lang/Long;Ljava/lang/Long;Lkntr/app/ad/domain/inspector/core/work/PrintType;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getStatus", "()Lkntr/app/ad/domain/inspector/model/Status;", "setStatus", "(Lkntr/app/ad/domain/inspector/model/Status;)V", "getTimestamp", "()J", "getStartTime", "()Ljava/lang/Long;", "setStartTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getEndTime", "setEndTime", "getType", "()Lkntr/app/ad/domain/inspector/core/work/PrintType;", "getMsg", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/inspector/model/Status;JLjava/lang/Long;Ljava/lang/Long;Lkntr/app/ad/domain/inspector/core/work/PrintType;Ljava/lang/String;)Lkntr/app/ad/domain/inspector/core/work/PrintJobData;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$inspector_debug", "Companion", "$serializer", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class PrintJobData implements IJobData {
    private Long endTime;
    private final String id;
    private final String msg;
    private final String name;
    private Long startTime;
    private Status status;
    private final long timestamp;
    private final PrintType type;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.domain.inspector.core.work.PrintJobData$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = PrintJobData._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null};

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

    public final PrintType component7() {
        return this.type;
    }

    public final String component8() {
        return this.msg;
    }

    public final PrintJobData copy(String str, String str2, Status status, long j2, Long l, Long l2, PrintType printType, String str3) {
        Intrinsics.checkNotNullParameter(str, ReportBuildInParam.ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(status, AdAlarmExtraKey.STATUS);
        Intrinsics.checkNotNullParameter(printType, "type");
        Intrinsics.checkNotNullParameter(str3, "msg");
        return new PrintJobData(str, str2, status, j2, l, l2, printType, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PrintJobData) {
            PrintJobData printJobData = (PrintJobData) obj;
            return Intrinsics.areEqual(this.id, printJobData.id) && Intrinsics.areEqual(this.name, printJobData.name) && this.status == printJobData.status && this.timestamp == printJobData.timestamp && Intrinsics.areEqual(this.startTime, printJobData.startTime) && Intrinsics.areEqual(this.endTime, printJobData.endTime) && this.type == printJobData.type && Intrinsics.areEqual(this.msg, printJobData.msg);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.status.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.timestamp)) * 31) + (this.startTime == null ? 0 : this.startTime.hashCode())) * 31) + (this.endTime != null ? this.endTime.hashCode() : 0)) * 31) + this.type.hashCode()) * 31) + this.msg.hashCode();
    }

    public String toString() {
        String str = this.id;
        String str2 = this.name;
        Status status = this.status;
        long j2 = this.timestamp;
        Long l = this.startTime;
        Long l2 = this.endTime;
        PrintType printType = this.type;
        return "PrintJobData(id=" + str + ", name=" + str2 + ", status=" + status + ", timestamp=" + j2 + ", startTime=" + l + ", endTime=" + l2 + ", type=" + printType + ", msg=" + this.msg + ")";
    }

    public /* synthetic */ PrintJobData(int seen0, String id, String name, Status status, long timestamp, Long startTime, Long endTime, PrintType type, String msg, SerializationConstructorMarker serializationConstructorMarker) {
        if (195 != (seen0 & 195)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 195, PrintJobData$$serializer.INSTANCE.getDescriptor());
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
        this.type = type;
        this.msg = msg;
    }

    public PrintJobData(String id, String name, Status status, long timestamp, Long startTime, Long endTime, PrintType type, String msg) {
        Intrinsics.checkNotNullParameter(id, ReportBuildInParam.ID);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(status, AdAlarmExtraKey.STATUS);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.id = id;
        this.name = name;
        this.status = status;
        this.timestamp = timestamp;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.msg = msg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return PrintType.Companion.serializer();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$inspector_debug(PrintJobData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
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
        output.encodeSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.type);
        output.encodeStringElement(serialDesc, 7, self.msg);
    }

    public /* synthetic */ PrintJobData(String str, String str2, Status status, long j2, Long l, Long l2, PrintType printType, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? Status.PENDING : status, (i & 8) != 0 ? DateTimeUtils.INSTANCE.currentTimeMillis() : j2, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : l2, printType, str3);
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

    public final PrintType getType() {
        return this.type;
    }

    public final String getMsg() {
        return this.msg;
    }

    /* compiled from: JobData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¨\u0006\r"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/PrintJobData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "createJobData", "Lkntr/app/ad/domain/inspector/core/work/PrintJobData;", "type", "Lkntr/app/ad/domain/inspector/core/work/PrintType;", "tag", RoomRecommendViewModel.EMPTY_CURSOR, "msg", "serializer", "Lkotlinx/serialization/KSerializer;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {

        /* compiled from: JobData.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PrintType.values().length];
                try {
                    iArr[PrintType.INFO.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[PrintType.ERROR.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[PrintType.WARNING.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PrintJobData> serializer() {
            return PrintJobData$$serializer.INSTANCE;
        }

        public final PrintJobData createJobData(PrintType type, String tag, String msg) {
            Status status;
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            IdGenerator idGenerator = IdGenerator.INSTANCE;
            String lowerCase = type.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String generateId = idGenerator.generateId("log_" + lowerCase + "_");
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    status = Status.SUCCESS;
                    break;
                case 2:
                    status = Status.FAILED;
                    break;
                case 3:
                    status = Status.WARNING;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            return new PrintJobData(generateId, tag, status, 0L, (Long) null, (Long) null, type, msg, 56, (DefaultConstructorMarker) null);
        }
    }
}