package kntr.app.ad.domain.inspector.core.work;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
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
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

/* compiled from: JobData.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Q2\u00020\u0001:\u0002QRB\u008b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015B\u0099\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0014\u0010\u001aJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0006HÆ\u0003J\t\u00108\u001a\u00020\bHÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\rHÆ\u0003J\t\u0010=\u001a\u00020\u000fHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009c\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00020\u000f2\b\u0010E\u001a\u0004\u0018\u00010FHÖ\u0003J\t\u0010G\u001a\u00020\u0017HÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001J%\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0001¢\u0006\u0002\bPR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010\t\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010\n\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010.R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001cR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001cR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001cR\u0011\u00103\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b4\u0010\u001c¨\u0006S"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/ReportJobData;", "Lkntr/app/ad/domain/inspector/core/work/IJobData;", ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "name", AdAlarmExtraKey.STATUS, "Lkntr/app/ad/domain/inspector/model/Status;", "timestamp", RoomRecommendViewModel.EMPTY_CURSOR, "startTime", "endTime", "jobType", "reportType", "Lkntr/app/ad/domain/inspector/core/work/ReportType;", "isRetry", RoomRecommendViewModel.EMPTY_CURSOR, "url", "requestBody", "responseBody", "adId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/inspector/model/Status;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lkntr/app/ad/domain/inspector/core/work/ReportType;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/inspector/model/Status;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lkntr/app/ad/domain/inspector/core/work/ReportType;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getStatus", "()Lkntr/app/ad/domain/inspector/model/Status;", "setStatus", "(Lkntr/app/ad/domain/inspector/model/Status;)V", "getTimestamp", "()J", "getStartTime", "()Ljava/lang/Long;", "setStartTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getEndTime", "setEndTime", "getJobType", "getReportType", "()Lkntr/app/ad/domain/inspector/core/work/ReportType;", "()Z", "getUrl", "getRequestBody", "getResponseBody", "getAdId", "event", "getEvent", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/domain/inspector/model/Status;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lkntr/app/ad/domain/inspector/core/work/ReportType;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/ad/domain/inspector/core/work/ReportJobData;", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$inspector_debug", "Companion", "$serializer", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class ReportJobData implements IJobData {
    private final String adId;
    private Long endTime;
    private final String id;
    private final boolean isRetry;
    private final String jobType;
    private final String name;
    private final ReportType reportType;
    private final String requestBody;
    private final String responseBody;
    private Long startTime;
    private Status status;
    private final long timestamp;
    private final String url;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.domain.inspector.core.work.ReportJobData$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ReportJobData._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null};

    public static /* synthetic */ ReportJobData copy$default(ReportJobData reportJobData, String str, String str2, Status status, long j2, Long l, Long l2, String str3, ReportType reportType, boolean z, String str4, String str5, String str6, String str7, int i, Object obj) {
        return reportJobData.copy((i & 1) != 0 ? reportJobData.id : str, (i & 2) != 0 ? reportJobData.name : str2, (i & 4) != 0 ? reportJobData.status : status, (i & 8) != 0 ? reportJobData.timestamp : j2, (i & 16) != 0 ? reportJobData.startTime : l, (i & 32) != 0 ? reportJobData.endTime : l2, (i & 64) != 0 ? reportJobData.jobType : str3, (i & 128) != 0 ? reportJobData.reportType : reportType, (i & 256) != 0 ? reportJobData.isRetry : z, (i & 512) != 0 ? reportJobData.url : str4, (i & 1024) != 0 ? reportJobData.requestBody : str5, (i & 2048) != 0 ? reportJobData.responseBody : str6, (i & 4096) != 0 ? reportJobData.adId : str7);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.url;
    }

    public final String component11() {
        return this.requestBody;
    }

    public final String component12() {
        return this.responseBody;
    }

    public final String component13() {
        return this.adId;
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

    public final String component7() {
        return this.jobType;
    }

    public final ReportType component8() {
        return this.reportType;
    }

    public final boolean component9() {
        return this.isRetry;
    }

    public final ReportJobData copy(String str, String str2, Status status, long j2, Long l, Long l2, String str3, ReportType reportType, boolean z, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, ReportBuildInParam.ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(status, AdAlarmExtraKey.STATUS);
        Intrinsics.checkNotNullParameter(str3, "jobType");
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        return new ReportJobData(str, str2, status, j2, l, l2, str3, reportType, z, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReportJobData) {
            ReportJobData reportJobData = (ReportJobData) obj;
            return Intrinsics.areEqual(this.id, reportJobData.id) && Intrinsics.areEqual(this.name, reportJobData.name) && this.status == reportJobData.status && this.timestamp == reportJobData.timestamp && Intrinsics.areEqual(this.startTime, reportJobData.startTime) && Intrinsics.areEqual(this.endTime, reportJobData.endTime) && Intrinsics.areEqual(this.jobType, reportJobData.jobType) && this.reportType == reportJobData.reportType && this.isRetry == reportJobData.isRetry && Intrinsics.areEqual(this.url, reportJobData.url) && Intrinsics.areEqual(this.requestBody, reportJobData.requestBody) && Intrinsics.areEqual(this.responseBody, reportJobData.responseBody) && Intrinsics.areEqual(this.adId, reportJobData.adId);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.status.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.timestamp)) * 31) + (this.startTime == null ? 0 : this.startTime.hashCode())) * 31) + (this.endTime == null ? 0 : this.endTime.hashCode())) * 31) + this.jobType.hashCode()) * 31) + this.reportType.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isRetry)) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.requestBody == null ? 0 : this.requestBody.hashCode())) * 31) + (this.responseBody == null ? 0 : this.responseBody.hashCode())) * 31) + (this.adId != null ? this.adId.hashCode() : 0);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.name;
        Status status = this.status;
        long j2 = this.timestamp;
        Long l = this.startTime;
        Long l2 = this.endTime;
        String str3 = this.jobType;
        ReportType reportType = this.reportType;
        boolean z = this.isRetry;
        String str4 = this.url;
        String str5 = this.requestBody;
        String str6 = this.responseBody;
        return "ReportJobData(id=" + str + ", name=" + str2 + ", status=" + status + ", timestamp=" + j2 + ", startTime=" + l + ", endTime=" + l2 + ", jobType=" + str3 + ", reportType=" + reportType + ", isRetry=" + z + ", url=" + str4 + ", requestBody=" + str5 + ", responseBody=" + str6 + ", adId=" + this.adId + ")";
    }

    public /* synthetic */ ReportJobData(int seen0, String id, String name, Status status, long timestamp, Long startTime, Long endTime, String jobType, ReportType reportType, boolean isRetry, String url, String requestBody, String responseBody, String adId, SerializationConstructorMarker serializationConstructorMarker) {
        if (451 != (seen0 & 451)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 451, ReportJobData$$serializer.INSTANCE.getDescriptor());
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
        this.jobType = jobType;
        this.reportType = reportType;
        this.isRetry = isRetry;
        if ((seen0 & 512) == 0) {
            this.url = null;
        } else {
            this.url = url;
        }
        if ((seen0 & 1024) == 0) {
            this.requestBody = null;
        } else {
            this.requestBody = requestBody;
        }
        if ((seen0 & 2048) == 0) {
            this.responseBody = null;
        } else {
            this.responseBody = responseBody;
        }
        if ((seen0 & 4096) == 0) {
            this.adId = null;
        } else {
            this.adId = adId;
        }
    }

    public ReportJobData(String id, String name, Status status, long timestamp, Long startTime, Long endTime, String jobType, ReportType reportType, boolean isRetry, String url, String requestBody, String responseBody, String adId) {
        Intrinsics.checkNotNullParameter(id, ReportBuildInParam.ID);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(status, AdAlarmExtraKey.STATUS);
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        this.id = id;
        this.name = name;
        this.status = status;
        this.timestamp = timestamp;
        this.startTime = startTime;
        this.endTime = endTime;
        this.jobType = jobType;
        this.reportType = reportType;
        this.isRetry = isRetry;
        this.url = url;
        this.requestBody = requestBody;
        this.responseBody = responseBody;
        this.adId = adId;
    }

    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return ReportType.Companion.serializer();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$inspector_debug(ReportJobData self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
        output.encodeStringElement(serialDesc, 6, self.jobType);
        output.encodeSerializableElement(serialDesc, 7, (SerializationStrategy) lazyArr[7].getValue(), self.reportType);
        output.encodeBooleanElement(serialDesc, 8, self.isRetry);
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.requestBody != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.requestBody);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.responseBody != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.responseBody);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.adId != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.adId);
        }
    }

    public /* synthetic */ ReportJobData(String str, String str2, Status status, long j2, Long l, Long l2, String str3, ReportType reportType, boolean z, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? Status.PENDING : status, (i & 8) != 0 ? DateTimeUtils.INSTANCE.currentTimeMillis() : j2, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : l2, str3, reportType, z, (i & 512) != 0 ? null : str4, (i & 1024) != 0 ? null : str5, (i & 2048) != 0 ? null : str6, (i & 4096) != 0 ? null : str7);
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

    public final String getJobType() {
        return this.jobType;
    }

    public final ReportType getReportType() {
        return this.reportType;
    }

    public final boolean isRetry() {
        return this.isRetry;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getRequestBody() {
        return this.requestBody;
    }

    public final String getResponseBody() {
        return this.responseBody;
    }

    public final String getAdId() {
        return this.adId;
    }

    public final String getEvent() {
        JsonArray jsonArray;
        JsonElement jsonElement;
        JsonObject jsonObject;
        JsonElement jsonElement2;
        String jsonElement3;
        String requestJson = this.requestBody;
        String str = requestJson;
        if (str == null || str.length() == 0) {
            return RoomRecommendViewModel.EMPTY_CURSOR;
        }
        try {
            JsonElement jsonElement4 = Json.Default.parseToJsonElement(requestJson);
            JsonElement jsonElement5 = (JsonElement) JsonElementKt.getJsonObject(jsonElement4).get("uploads");
            if (jsonElement5 == null || (jsonArray = JsonElementKt.getJsonArray(jsonElement5)) == null || (jsonElement = jsonArray.get(0)) == null || (jsonObject = JsonElementKt.getJsonObject(jsonElement)) == null || (jsonElement2 = (JsonElement) jsonObject.get("event")) == null || (jsonElement3 = jsonElement2.toString()) == null) {
                return RoomRecommendViewModel.EMPTY_CURSOR;
            }
            String replace$default = StringsKt.replace$default(jsonElement3, "\"", RoomRecommendViewModel.EMPTY_CURSOR, false, 4, (Object) null);
            return replace$default != null ? replace$default : RoomRecommendViewModel.EMPTY_CURSOR;
        } catch (Exception e) {
            return RoomRecommendViewModel.EMPTY_CURSOR;
        }
    }

    /* compiled from: JobData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007J$\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007J$\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f¨\u0006\u0010"}, d2 = {"Lkntr/app/ad/domain/inspector/core/work/ReportJobData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "createFeeReportJob", "Lkntr/app/ad/domain/inspector/core/work/ReportJobData;", "requestBody", RoomRecommendViewModel.EMPTY_CURSOR, "isRetry", RoomRecommendViewModel.EMPTY_CURSOR, "adId", "createUIReportJob", "createMMAReportJob", "url", "serializer", "Lkotlinx/serialization/KSerializer;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ReportJobData> serializer() {
            return ReportJobData$$serializer.INSTANCE;
        }

        public static /* synthetic */ ReportJobData createFeeReportJob$default(Companion companion, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.createFeeReportJob(str, z, str2);
        }

        public final ReportJobData createFeeReportJob(String requestBody, boolean isRetry, String adId) {
            return new ReportJobData(IdGenerator.INSTANCE.generateId("report_fee_"), "计费上报", (Status) null, 0L, (Long) null, (Long) null, "FeeReportJob", ReportType.FEE, isRetry, (String) null, requestBody, (String) null, adId, 2620, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ReportJobData createUIReportJob$default(Companion companion, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.createUIReportJob(str, z, str2);
        }

        public final ReportJobData createUIReportJob(String requestBody, boolean isRetry, String adId) {
            return new ReportJobData(IdGenerator.INSTANCE.generateId("report_ui_"), "UI上报", (Status) null, 0L, (Long) null, (Long) null, "UIReportJob", ReportType.UI, isRetry, (String) null, requestBody, (String) null, adId, 2620, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ReportJobData createMMAReportJob$default(Companion companion, String str, boolean z, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.createMMAReportJob(str, z, str2);
        }

        public final ReportJobData createMMAReportJob(String url, boolean isRetry, String adId) {
            return new ReportJobData(IdGenerator.INSTANCE.generateId("report_mma_"), "MMA上报", (Status) null, 0L, (Long) null, (Long) null, "MMAReportJob", ReportType.MMA, isRetry, url, (String) null, (String) null, adId, 3132, (DefaultConstructorMarker) null);
        }
    }
}