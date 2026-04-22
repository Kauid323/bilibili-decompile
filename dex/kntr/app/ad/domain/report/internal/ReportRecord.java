package kntr.app.ad.domain.report.internal;

import java.util.Iterator;
import kntr.app.ad.common.utils.JsonExtKt;
import kntr.app.ad.common.utils.TimeKt;
import kntr.app.ad.common.utils.UUIDKt;
import kntr.app.ad.domain.report.internal.ReportRecord;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: ReportRecord.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R-\u0010\u0013\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014¢\u0006\u0002\b\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR-\u0010\u001c\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014¢\u0006\u0002\b\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR-\u0010\u001f\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014¢\u0006\u0002\b\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010.\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\t¨\u00062"}, d2 = {"Lkntr/app/ad/domain/report/internal/ReportRecord;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "uuid", RoomRecommendViewModel.EMPTY_CURSOR, "getUuid", "()Ljava/lang/String;", "setUuid", "(Ljava/lang/String;)V", "ts", "getTs", "setTs", "retryCount", RoomRecommendViewModel.EMPTY_CURSOR, "getRetryCount", "()I", "setRetryCount", "(I)V", "baseInfo", "Lkotlin/Function1;", "Lkntr/app/ad/domain/report/internal/ReportExtraHandler;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ExtensionFunctionType;", "getBaseInfo", "()Lkotlin/jvm/functions/Function1;", "setBaseInfo", "(Lkotlin/jvm/functions/Function1;)V", "adInfo", "getAdInfo", "setAdInfo", "extraInfo", "getExtraInfo", "setExtraInfo", "type", "Lkntr/app/ad/domain/report/internal/RecordType;", "getType", "()Lkntr/app/ad/domain/report/internal/RecordType;", "setType", "(Lkntr/app/ad/domain/report/internal/RecordType;)V", "code", "getCode", "()Ljava/lang/Integer;", "setCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "msg", "getMsg", "setMsg", "Companion", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReportRecord {
    public static final Companion Companion = new Companion(null);
    private Function1<? super ReportExtraHandler, Unit> adInfo;
    private Function1<? super ReportExtraHandler, Unit> baseInfo;
    private Integer code;
    private Function1<? super ReportExtraHandler, Unit> extraInfo;
    private String msg;
    private int retryCount;
    private RecordType type;
    private String uuid = UUIDKt.generateUUID();
    private String ts = String.valueOf(TimeKt.getCurrentTimeMillis());

    public final String getUuid() {
        return this.uuid;
    }

    public final void setUuid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uuid = str;
    }

    public final String getTs() {
        return this.ts;
    }

    public final void setTs(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ts = str;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final void setRetryCount(int i) {
        this.retryCount = i;
    }

    public final Function1<ReportExtraHandler, Unit> getBaseInfo() {
        return this.baseInfo;
    }

    public final void setBaseInfo(Function1<? super ReportExtraHandler, Unit> function1) {
        this.baseInfo = function1;
    }

    public final Function1<ReportExtraHandler, Unit> getAdInfo() {
        return this.adInfo;
    }

    public final void setAdInfo(Function1<? super ReportExtraHandler, Unit> function1) {
        this.adInfo = function1;
    }

    public final Function1<ReportExtraHandler, Unit> getExtraInfo() {
        return this.extraInfo;
    }

    public final void setExtraInfo(Function1<? super ReportExtraHandler, Unit> function1) {
        this.extraInfo = function1;
    }

    public final RecordType getType() {
        return this.type;
    }

    public final void setType(RecordType recordType) {
        this.type = recordType;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final void setCode(Integer num) {
        this.code = num;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }

    /* compiled from: ReportRecord.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lkntr/app/ad/domain/report/internal/ReportRecord$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "toJson", "Lkotlinx/serialization/json/JsonObject;", "record", "Lkntr/app/ad/domain/report/internal/ReportRecord;", "fromJson", "json", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JsonObject toJson(ReportRecord record) {
            Intrinsics.checkNotNullParameter(record, "record");
            JsonObjectBuilder builder$iv = new JsonObjectBuilder();
            JsonElementBuildersKt.put(builder$iv, "uuid", record.getUuid());
            JsonElementBuildersKt.put(builder$iv, "ts", record.getTs());
            JsonElementBuildersKt.put(builder$iv, "retry_count", Integer.valueOf(record.getRetryCount()));
            RecordType type = record.getType();
            JsonElementBuildersKt.put(builder$iv, "type", type != null ? Integer.valueOf(type.getValue()) : null);
            Function1 baseInfo = record.getBaseInfo();
            if (baseInfo != null) {
                JsonObjectBuilder builder$iv2 = new JsonObjectBuilder();
                baseInfo.invoke(new ReportExtraHandler(builder$iv2));
                JsonElement build = builder$iv2.build();
                if (build != null) {
                    builder$iv.put("base_info", build);
                }
            }
            Function1 adInfo = record.getAdInfo();
            if (adInfo != null) {
                JsonObjectBuilder builder$iv3 = new JsonObjectBuilder();
                adInfo.invoke(new ReportExtraHandler(builder$iv3));
                JsonElement build2 = builder$iv3.build();
                if (build2 != null) {
                    builder$iv.put("ad_info", build2);
                }
            }
            Function1 extraInfo = record.getExtraInfo();
            if (extraInfo != null) {
                JsonObjectBuilder builder$iv4 = new JsonObjectBuilder();
                extraInfo.invoke(new ReportExtraHandler(builder$iv4));
                JsonElement build3 = builder$iv4.build();
                if (build3 != null) {
                    builder$iv.put("extra_info", build3);
                }
            }
            return builder$iv.build();
        }

        public final ReportRecord fromJson(JsonObject json) {
            RecordType recordType;
            Object obj;
            RecordType type;
            Intrinsics.checkNotNullParameter(json, "json");
            ReportRecord $this$fromJson_u24lambda_u240 = new ReportRecord();
            String stringOrNull = JsonExtKt.getStringOrNull(json, "uuid");
            String str = RoomRecommendViewModel.EMPTY_CURSOR;
            if (stringOrNull == null) {
                stringOrNull = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            $this$fromJson_u24lambda_u240.setUuid(stringOrNull);
            String stringOrNull2 = JsonExtKt.getStringOrNull(json, "ts");
            if (stringOrNull2 != null) {
                str = stringOrNull2;
            }
            $this$fromJson_u24lambda_u240.setTs(str);
            Integer intOrNull = JsonExtKt.getIntOrNull(json, "retry_count");
            $this$fromJson_u24lambda_u240.setRetryCount(intOrNull != null ? intOrNull.intValue() : 0);
            Integer intOrNull2 = JsonExtKt.getIntOrNull(json, "type");
            if (intOrNull2 != null) {
                int it = intOrNull2.intValue();
                Iterator it2 = RecordType.getEntries().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    RecordType type2 = (RecordType) obj;
                    if (type2.getValue() == it) {
                        type = 1;
                        continue;
                    } else {
                        type = null;
                        continue;
                    }
                    if (type != null) {
                        break;
                    }
                }
                recordType = (RecordType) obj;
            } else {
                recordType = null;
            }
            $this$fromJson_u24lambda_u240.setType(recordType);
            JsonObject jsonObjectOrNull = JsonExtKt.getJsonObjectOrNull(json, "base_info");
            $this$fromJson_u24lambda_u240.setBaseInfo(jsonObjectOrNull != null ? ReportRecordKt.toJsonObjectHandler$default(jsonObjectOrNull, null, 1, null) : null);
            JsonObject jsonObjectOrNull2 = JsonExtKt.getJsonObjectOrNull(json, "ad_info");
            $this$fromJson_u24lambda_u240.setAdInfo(jsonObjectOrNull2 != null ? ReportRecordKt.toJsonObjectHandler$default(jsonObjectOrNull2, null, 1, null) : null);
            JsonObject jsonObjectOrNull3 = JsonExtKt.getJsonObjectOrNull(json, "extra_info");
            $this$fromJson_u24lambda_u240.setExtraInfo(jsonObjectOrNull3 != null ? ReportRecordKt.access$toJsonObjectHandler(jsonObjectOrNull3, new Function1() { // from class: kntr.app.ad.domain.report.internal.ReportRecord$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit fromJson$lambda$0$1;
                    fromJson$lambda$0$1 = ReportRecord.Companion.fromJson$lambda$0$1((ReportExtraHandler) obj2);
                    return fromJson$lambda$0$1;
                }
            }) : null);
            return $this$fromJson_u24lambda_u240;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit fromJson$lambda$0$1(ReportExtraHandler $this$toJsonObjectHandler) {
            Intrinsics.checkNotNullParameter($this$toJsonObjectHandler, "$this$toJsonObjectHandler");
            $this$toJsonObjectHandler.put(ReportBuildInParam.IS_REUPLOAD, "1");
            return Unit.INSTANCE;
        }
    }
}