package kntr.app.ad.domain.report.internal;

import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: ReportRecord.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004*\u00020\u00052\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001¢\u0006\u0002\b\u0004H\u0002¨\u0006\u0007"}, d2 = {"toJsonObjectHandler", "Lkotlin/Function1;", "Lkntr/app/ad/domain/report/internal/ReportExtraHandler;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ExtensionFunctionType;", "Lkotlinx/serialization/json/JsonObject;", "handler", "report_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ReportRecordKt {
    public static final /* synthetic */ Function1 access$toJsonObjectHandler(JsonObject $receiver, Function1 handler) {
        return toJsonObjectHandler($receiver, handler);
    }

    public static /* synthetic */ Function1 toJsonObjectHandler$default(JsonObject jsonObject, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return toJsonObjectHandler(jsonObject, function1);
    }

    public static final Function1<ReportExtraHandler, Unit> toJsonObjectHandler(final JsonObject $this$toJsonObjectHandler, final Function1<? super ReportExtraHandler, Unit> function1) {
        return new Function1() { // from class: kntr.app.ad.domain.report.internal.ReportRecordKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit jsonObjectHandler$lambda$0;
                jsonObjectHandler$lambda$0 = ReportRecordKt.toJsonObjectHandler$lambda$0($this$toJsonObjectHandler, function1, (ReportExtraHandler) obj);
                return jsonObjectHandler$lambda$0;
            }
        };
    }

    public static final Unit toJsonObjectHandler$lambda$0(JsonObject $this_toJsonObjectHandler, Function1 $handler, ReportExtraHandler reportExtraHandler) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(reportExtraHandler, "<this>");
        Map $this$forEach$iv = (Map) $this_toJsonObjectHandler;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            String k = (String) element$iv.getKey();
            JsonElement v = (JsonElement) element$iv.getValue();
            JsonPrimitive value = JsonElementKt.getJsonPrimitive(v);
            Unit unit = null;
            if ((value.isString() ? value : null) != null) {
                reportExtraHandler.put(k, value.getContent());
                Unit unit2 = Unit.INSTANCE;
            } else {
                Boolean booleanStrictOrNull = StringsKt.toBooleanStrictOrNull(value.getContent());
                if (booleanStrictOrNull != null) {
                    boolean it = booleanStrictOrNull.booleanValue();
                    reportExtraHandler.put$report_debug(k, it);
                    Unit unit3 = Unit.INSTANCE;
                } else {
                    Integer intOrNull = StringsKt.toIntOrNull(value.getContent());
                    if (intOrNull != null) {
                        int it2 = intOrNull.intValue();
                        reportExtraHandler.put$report_debug(k, it2);
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null && (longOrNull = JsonElementKt.getLongOrNull(value)) != null) {
                        long it3 = longOrNull.longValue();
                        reportExtraHandler.put$report_debug(k, it3);
                        Unit unit4 = Unit.INSTANCE;
                    }
                }
            }
        }
        if ($handler != null) {
            $handler.invoke(reportExtraHandler);
        }
        return Unit.INSTANCE;
    }
}