package kntr.app.ad.domain.inspector.core.work;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.ad.common.model.AdSlot;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.inspector.core.serializer.RequestTypeSerializer;
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
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: JobData.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 S2\u00020\u0001:\u0002STB\u008b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015B\u009b\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0014\u0010\u001aJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%J\t\u0010<\u001a\u00020\fHÆ\u0003J\t\u0010=\u001a\u00020\u000eHÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009c\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\t\u0010I\u001a\u00020\u0017HÖ\u0001J\t\u0010J\u001a\u00020\u0003HÖ\u0001J%\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0001¢\u0006\u0002\bRR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010\t\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010\n\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001cR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001cR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u00104R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001c¨\u0006U"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/RequestJobData;", "Lkntr/app/ad/domain/inspector/core/work/IJobData;", ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "name", AdAlarmExtraKey.STATUS, "Lkntr/app/ad/domain/inspector/model/Status;", "timestamp", RoomRecommendViewModel.EMPTY_CURSOR, "startTime", "endTime", "slot", "Lkntr/app/ad/common/model/AdSlot;", "type", "Lkntr/app/ad/domain/inspector/core/work/RequestType;", "jobType", "url", "requestJson", "responseJson", "desc", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/inspector/model/Status;JLjava/lang/Long;Ljava/lang/Long;Lkntr/app/ad/common/model/AdSlot;Lkntr/app/ad/domain/inspector/core/work/RequestType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/inspector/model/Status;JLjava/lang/Long;Ljava/lang/Long;Lkntr/app/ad/common/model/AdSlot;Lkntr/app/ad/domain/inspector/core/work/RequestType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getStatus", "()Lkntr/app/ad/domain/inspector/model/Status;", "setStatus", "(Lkntr/app/ad/domain/inspector/model/Status;)V", "getTimestamp", "()J", "getStartTime", "()Ljava/lang/Long;", "setStartTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getEndTime", "setEndTime", "getSlot", "()Lkntr/app/ad/common/model/AdSlot;", "getType", "()Lkntr/app/ad/domain/inspector/core/work/RequestType;", "getJobType", "getUrl", "getRequestJson", "getResponseJson", "setResponseJson", "(Ljava/lang/String;)V", "getDesc", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/inspector/model/Status;JLjava/lang/Long;Ljava/lang/Long;Lkntr/app/ad/common/model/AdSlot;Lkntr/app/ad/domain/inspector/core/work/RequestType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/ad/domain/inspector/core/work/RequestJobData;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$inspector_debug", "Companion", "$serializer", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class RequestJobData implements IJobData {
    private final String desc;
    private Long endTime;
    private final String id;
    private final String jobType;
    private final String name;
    private final String requestJson;
    private String responseJson;
    private final AdSlot slot;
    private Long startTime;
    private Status status;
    private final long timestamp;
    private final RequestType type;
    private final String url;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.domain.inspector.core.work.RequestJobData$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = RequestJobData._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null};

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.url;
    }

    public final String component11() {
        return this.requestJson;
    }

    public final String component12() {
        return this.responseJson;
    }

    public final String component13() {
        return this.desc;
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

    public final AdSlot component7() {
        return this.slot;
    }

    public final RequestType component8() {
        return this.type;
    }

    public final String component9() {
        return this.jobType;
    }

    public final RequestJobData copy(String str, String str2, Status status, long j2, Long l, Long l2, AdSlot adSlot, RequestType requestType, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, ReportBuildInParam.ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(status, AdAlarmExtraKey.STATUS);
        Intrinsics.checkNotNullParameter(adSlot, "slot");
        Intrinsics.checkNotNullParameter(requestType, "type");
        Intrinsics.checkNotNullParameter(str3, "jobType");
        return new RequestJobData(str, str2, status, j2, l, l2, adSlot, requestType, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RequestJobData) {
            RequestJobData requestJobData = (RequestJobData) obj;
            return Intrinsics.areEqual(this.id, requestJobData.id) && Intrinsics.areEqual(this.name, requestJobData.name) && this.status == requestJobData.status && this.timestamp == requestJobData.timestamp && Intrinsics.areEqual(this.startTime, requestJobData.startTime) && Intrinsics.areEqual(this.endTime, requestJobData.endTime) && this.slot == requestJobData.slot && this.type == requestJobData.type && Intrinsics.areEqual(this.jobType, requestJobData.jobType) && Intrinsics.areEqual(this.url, requestJobData.url) && Intrinsics.areEqual(this.requestJson, requestJobData.requestJson) && Intrinsics.areEqual(this.responseJson, requestJobData.responseJson) && Intrinsics.areEqual(this.desc, requestJobData.desc);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.status.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.timestamp)) * 31) + (this.startTime == null ? 0 : this.startTime.hashCode())) * 31) + (this.endTime == null ? 0 : this.endTime.hashCode())) * 31) + this.slot.hashCode()) * 31) + this.type.hashCode()) * 31) + this.jobType.hashCode()) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.requestJson == null ? 0 : this.requestJson.hashCode())) * 31) + (this.responseJson == null ? 0 : this.responseJson.hashCode())) * 31) + (this.desc != null ? this.desc.hashCode() : 0);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.name;
        Status status = this.status;
        long j2 = this.timestamp;
        Long l = this.startTime;
        Long l2 = this.endTime;
        AdSlot adSlot = this.slot;
        RequestType requestType = this.type;
        String str3 = this.jobType;
        String str4 = this.url;
        String str5 = this.requestJson;
        String str6 = this.responseJson;
        return "RequestJobData(id=" + str + ", name=" + str2 + ", status=" + status + ", timestamp=" + j2 + ", startTime=" + l + ", endTime=" + l2 + ", slot=" + adSlot + ", type=" + requestType + ", jobType=" + str3 + ", url=" + str4 + ", requestJson=" + str5 + ", responseJson=" + str6 + ", desc=" + this.desc + ")";
    }

    public /* synthetic */ RequestJobData(int seen0, String id, String name, Status status, long timestamp, Long startTime, Long endTime, AdSlot slot, RequestType type, String jobType, String url, String requestJson, String responseJson, String desc, SerializationConstructorMarker serializationConstructorMarker) {
        if (451 != (seen0 & 451)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 451, RequestJobData$$serializer.INSTANCE.getDescriptor());
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
        this.slot = slot;
        this.type = type;
        this.jobType = jobType;
        if ((seen0 & 512) == 0) {
            this.url = null;
        } else {
            this.url = url;
        }
        if ((seen0 & 1024) == 0) {
            this.requestJson = null;
        } else {
            this.requestJson = requestJson;
        }
        if ((seen0 & 2048) == 0) {
            this.responseJson = null;
        } else {
            this.responseJson = responseJson;
        }
        if ((seen0 & 4096) == 0) {
            this.desc = null;
        } else {
            this.desc = desc;
        }
    }

    public RequestJobData(String id, String name, Status status, long timestamp, Long startTime, Long endTime, AdSlot slot, RequestType type, String jobType, String url, String requestJson, String responseJson, String desc) {
        Intrinsics.checkNotNullParameter(id, ReportBuildInParam.ID);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(status, AdAlarmExtraKey.STATUS);
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        this.id = id;
        this.name = name;
        this.status = status;
        this.timestamp = timestamp;
        this.startTime = startTime;
        this.endTime = endTime;
        this.slot = slot;
        this.type = type;
        this.jobType = jobType;
        this.url = url;
        this.requestJson = requestJson;
        this.responseJson = responseJson;
        this.desc = desc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createSimpleEnumSerializer("kntr.app.ad.common.model.AdSlot", AdSlot.values());
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$inspector_debug(RequestJobData self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
        output.encodeSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.slot);
        output.encodeSerializableElement(serialDesc, 7, RequestTypeSerializer.INSTANCE, self.type);
        output.encodeStringElement(serialDesc, 8, self.jobType);
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.requestJson != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.requestJson);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.responseJson != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.responseJson);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.desc != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.desc);
        }
    }

    public /* synthetic */ RequestJobData(String str, String str2, Status status, long j2, Long l, Long l2, AdSlot adSlot, RequestType requestType, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? Status.PENDING : status, (i & 8) != 0 ? DateTimeUtils.INSTANCE.currentTimeMillis() : j2, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : l2, adSlot, requestType, str3, (i & 512) != 0 ? null : str4, (i & 1024) != 0 ? null : str5, (i & 2048) != 0 ? null : str6, (i & 4096) != 0 ? null : str7);
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

    public final AdSlot getSlot() {
        return this.slot;
    }

    public final RequestType getType() {
        return this.type;
    }

    public final String getJobType() {
        return this.jobType;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getRequestJson() {
        return this.requestJson;
    }

    public final String getResponseJson() {
        return this.responseJson;
    }

    public final void setResponseJson(String str) {
        this.responseJson = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    /* compiled from: JobData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ2\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¨\u0006\u000f"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/RequestJobData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "createAdExtraJob", "Lkntr/app/ad/domain/inspector/core/work/RequestJobData;", "slot", "Lkntr/app/ad/common/model/AdSlot;", "desc", RoomRecommendViewModel.EMPTY_CURSOR, "createApiJob", "url", "requestJson", "serializer", "Lkotlinx/serialization/KSerializer;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RequestJobData> serializer() {
            return RequestJobData$$serializer.INSTANCE;
        }

        public final RequestJobData createAdExtraJob(AdSlot slot, String desc) {
            Intrinsics.checkNotNullParameter(slot, "slot");
            return new RequestJobData(IdGenerator.INSTANCE.generateId("request_adextra_"), "ad_extra 获取", (Status) null, 0L, (Long) null, (Long) null, slot, RequestType.ADEXTRA, "AdExtraJob", (String) null, (String) null, (String) null, desc, 3644, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ RequestJobData createApiJob$default(Companion companion, AdSlot adSlot, String str, String str2, String str3, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                str3 = null;
            }
            return companion.createApiJob(adSlot, str, str2, str3);
        }

        public final RequestJobData createApiJob(AdSlot slot, String url, String requestJson, String desc) {
            Intrinsics.checkNotNullParameter(slot, "slot");
            return new RequestJobData(IdGenerator.INSTANCE.generateId("request_api_"), "api 请求", (Status) null, 0L, (Long) null, (Long) null, slot, RequestType.API, "ApiJob", url, requestJson, (String) null, desc, 2108, (DefaultConstructorMarker) null);
        }
    }
}