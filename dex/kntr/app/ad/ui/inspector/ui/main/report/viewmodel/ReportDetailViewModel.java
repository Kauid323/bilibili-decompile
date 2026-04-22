package kntr.app.ad.ui.inspector.ui.main.report.viewmodel;

import kntr.app.ad.domain.inspector.core.StateManager;
import kntr.app.ad.domain.inspector.core.work.ReportJobData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: ReportDetailViewModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0012\u001a\u0004\u0018\u00010\n*\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportDetailViewModel;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "json", "Lkotlinx/serialization/json/Json;", "getReportJobDataByIdFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/app/ad/domain/inspector/core/work/ReportJobData;", "reportId", RoomRecommendViewModel.EMPTY_CURSOR, "extractEventFromJson", "jsonStr", "parseJsonToElement", "Lkotlin/Result;", "Lkotlinx/serialization/json/JsonElement;", "parseJsonToElement-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "getEventValue", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReportDetailViewModel {
    public static final int $stable = 8;
    private final Json json = JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.report.viewmodel.ReportDetailViewModel$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit json$lambda$0;
            json$lambda$0 = ReportDetailViewModel.json$lambda$0((JsonBuilder) obj);
            return json$lambda$0;
        }
    }, 1, (Object) null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setLenient(true);
        $this$Json.setEncodeDefaults(true);
        $this$Json.setPrettyPrint(true);
        return Unit.INSTANCE;
    }

    public final Flow<ReportJobData> getReportJobDataByIdFlow(String reportId) {
        Intrinsics.checkNotNullParameter(reportId, "reportId");
        try {
            return StateManager.INSTANCE.getReportJobDataFlow(reportId);
        } catch (Exception e) {
            return FlowKt.flowOf((Object) null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
        if (kotlin.text.StringsKt.isBlank(r5) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String extractEventFromJson(String jsonStr) {
        String str = jsonStr;
        boolean z = false;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        try {
            JsonElement jsonElement = this.json.parseToJsonElement(jsonStr);
            String event = getEventValue(jsonElement);
            String str2 = event;
            if (str2 != null) {
            }
            z = true;
            if (z) {
                return null;
            }
            return event;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: parseJsonToElement-IoAF18A  reason: not valid java name */
    public final Object m460parseJsonToElementIoAF18A(String jsonStr) {
        String str = jsonStr;
        if (str == null || StringsKt.isBlank(str)) {
            Result.Companion companion = Result.Companion;
            return Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("JSON字符串为空")));
        }
        try {
            JsonElement element = this.json.parseToJsonElement(jsonStr);
            Result.Companion companion2 = Result.Companion;
            return Result.constructor-impl(element);
        } catch (Exception e) {
            Result.Companion companion3 = Result.Companion;
            return Result.constructor-impl(ResultKt.createFailure(e));
        }
    }

    private final String getEventValue(JsonElement $this$getEventValue) {
        JsonPrimitive jsonPrimitive;
        try {
            if (!($this$getEventValue instanceof JsonObject) || (jsonPrimitive = (JsonElement) ((JsonObject) $this$getEventValue).get("event")) == null) {
                return null;
            }
            String content = jsonPrimitive instanceof JsonPrimitive ? jsonPrimitive.getContent() : jsonPrimitive.toString();
            if (content == null) {
                return null;
            }
            return StringsKt.replace$default(content, "\"", RoomRecommendViewModel.EMPTY_CURSOR, false, 4, (Object) null);
        } catch (Exception e) {
            return null;
        }
    }
}