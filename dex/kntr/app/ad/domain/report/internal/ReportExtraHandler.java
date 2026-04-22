package kntr.app.ad.domain.report.internal;

import kntr.app.ad.protocol.report.IReportExtraHandler;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: ReportExtraHandler.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fH\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\rH\u0017J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u000fJ\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/app/ad/domain/report/internal/ReportExtraHandler;", "Lkntr/app/ad/protocol/report/IReportExtraHandler;", "builder", "Lkotlinx/serialization/json/JsonObjectBuilder;", "<init>", "(Lkotlinx/serialization/json/JsonObjectBuilder;)V", "put", RoomRecommendViewModel.EMPTY_CURSOR, "key", RoomRecommendViewModel.EMPTY_CURSOR, "value", "block", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "put$report_debug", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReportExtraHandler implements IReportExtraHandler {
    private final JsonObjectBuilder builder;

    public ReportExtraHandler(JsonObjectBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
    }

    @Override // kntr.app.ad.protocol.report.IReportExtraHandler
    public void put(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (value == null) {
            return;
        }
        JsonElementBuildersKt.put(this.builder, key, value);
    }

    @Override // kntr.app.ad.protocol.report.IReportExtraHandler
    public void put(String key, Function0<String> function0) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl((String) function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String it = (String) obj;
        if (it != null) {
            put(key, it);
        }
    }

    @Override // kntr.app.ad.protocol.report.IReportExtraHandler
    public void put(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!(value instanceof String)) {
            if (!(value instanceof Integer)) {
                if (!(value instanceof Long)) {
                    if (value instanceof Boolean) {
                        put$report_debug(key, ((Boolean) value).booleanValue());
                        return;
                    }
                    return;
                }
                put$report_debug(key, ((Number) value).longValue());
                return;
            }
            put$report_debug(key, ((Number) value).intValue());
            return;
        }
        put(key, (String) value);
    }

    public final void put$report_debug(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        JsonElementBuildersKt.put(this.builder, key, Integer.valueOf(value));
    }

    public final void put$report_debug(String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        JsonElementBuildersKt.put(this.builder, key, Long.valueOf(value));
    }

    public final void put$report_debug(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        JsonElementBuildersKt.put(this.builder, key, Boolean.valueOf(value));
    }
}