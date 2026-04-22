package kntr.common.upper.trace;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.device.KDevice;
import kntr.common.upper.trace.TraceNeurons;
import kntr.common.upper.trace.config.CommonProjectType;
import kntr.common.upper.trace.config.Platform_androidKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.datetime.Clock;

/* compiled from: TraceUtils.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lkntr/common/upper/trace/TraceUtils;", "", "<init>", "()V", "newTraceID", "", "contextNotFound", "Lkntr/common/upper/trace/TraceNeurons;", "eventID", "appTraceID", "trace-core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TraceUtils {
    public static final TraceUtils INSTANCE = new TraceUtils();

    private TraceUtils() {
    }

    public final String newTraceID() {
        String m2636constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            TraceUtils traceUtils = this;
            m2636constructorimpl = Result.m2636constructorimpl(Platform_androidKt.getPlatform().getName() + ":" + KDevice.INSTANCE.getBuvid() + ":" + Clock.System.INSTANCE.now().toEpochMilliseconds());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        String str = Platform_androidKt.getPlatform().getName() + ":" + RangesKt.random(new IntRange(0, 1000000), Random.Default) + ":" + Clock.System.INSTANCE.now().toEpochMilliseconds();
        if (Result.m2642isFailureimpl(m2636constructorimpl)) {
            m2636constructorimpl = str;
        }
        return (String) m2636constructorimpl;
    }

    public final TraceNeurons contextNotFound(String eventID, String appTraceID) {
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        Intrinsics.checkNotNullParameter(appTraceID, "appTraceID");
        return new TraceNeurons.Builder(eventID).setAppTraceID(appTraceID).setProjectType(CommonProjectType.REPORTER).setEventKey("reporter_trace_context_not_found").setEventNodeType(EventNodeType.PROCESS).setEventLevel(EventLevel.WARNING).setEventLog("【上报组件】事件跟踪上下文丢失").build();
    }
}