package kntr.app.upper.entrance.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.neuron.KNeuron;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* compiled from: TrackUtils.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jj\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u0005JR\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00072\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050 2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050 2\u0006\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Lkntr/app/upper/entrance/utils/TrackUtils;", "", "<init>", "()V", "BUBBLE_DATA_EVENT_ID", "", "shouldTrack", "", "getShouldTrack", "()Z", "shouldTrack$delegate", "Lkotlin/Lazy;", "trackID", "", "getTrackID", "()J", "trackID$delegate", "trackBubbleRequestInfo", "", "result", "strategy", "strategyID", "bubbleID", "textID", "recommend", "ext", "mid", "resourceID", "resourceType", "trackABResult", "isSuccess", "originResult", "", "duration", "errorMsg", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TrackUtils {
    private static final String BUBBLE_DATA_EVENT_ID = "main.homepage.bottombar-bubble.result.show";
    public static final TrackUtils INSTANCE = new TrackUtils();
    private static final Lazy shouldTrack$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upper.entrance.utils.TrackUtils$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean shouldTrack_delegate$lambda$0;
            shouldTrack_delegate$lambda$0 = TrackUtils.shouldTrack_delegate$lambda$0();
            return Boolean.valueOf(shouldTrack_delegate$lambda$0);
        }
    });
    private static final Lazy trackID$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.upper.entrance.utils.TrackUtils$$ExternalSyntheticLambda1
        public final Object invoke() {
            long trackID_delegate$lambda$0;
            trackID_delegate$lambda$0 = TrackUtils.trackID_delegate$lambda$0();
            return Long.valueOf(trackID_delegate$lambda$0);
        }
    });

    private TrackUtils() {
    }

    private final boolean getShouldTrack() {
        return ((Boolean) shouldTrack$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldTrack_delegate$lambda$0() {
        boolean m2636constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(Boolean.valueOf(IPlatformConfig.CC.ff$default(KConfig.INSTANCE, "uper.center_plus_track_switch", false, 2, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
        }
        if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
            m2636constructorimpl = false;
        }
        return ((Boolean) m2636constructorimpl).booleanValue();
    }

    public final long getTrackID() {
        return ((Number) trackID$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long trackID_delegate$lambda$0() {
        Instant now = Clock.System.INSTANCE.now();
        return now.toEpochMilliseconds();
    }

    public final void trackBubbleRequestInfo(String result, String strategy, String strategyID, String bubbleID, String textID, String recommend, Object ext, String mid, String resourceID, String resourceType) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(strategyID, "strategyID");
        Intrinsics.checkNotNullParameter(bubbleID, "bubbleID");
        Intrinsics.checkNotNullParameter(textID, "textID");
        Intrinsics.checkNotNullParameter(recommend, "recommend");
        Intrinsics.checkNotNullParameter(mid, "mid");
        Intrinsics.checkNotNullParameter(resourceID, "resourceID");
        Intrinsics.checkNotNullParameter(resourceType, "resourceType");
        Map extra = new LinkedHashMap();
        extra.put("result", result);
        extra.put("strategy_id", strategyID);
        extra.put("resource_id", resourceID);
        extra.put("resource_result_type", resourceType);
        extra.put("bubble_id", bubbleID);
        extra.put("strategy", strategy);
        extra.put("text_id", textID);
        extra.put("recommend", recommend);
        if (getShouldTrack()) {
            extra.put("extra", String.valueOf(ext));
        }
        if (FeatureConfig.INSTANCE.getTransferFlag()) {
            extra.put("task_id", mid + getTrackID());
        }
        KNeuron.INSTANCE.reportExposure(true, BUBBLE_DATA_EVENT_ID, extra);
    }

    public static /* synthetic */ void trackABResult$default(TrackUtils trackUtils, boolean z, Map map, Map map2, long j, String str, String str2, int i, Object obj) {
        String str3;
        String str4;
        if ((i & 16) == 0) {
            str3 = str;
        } else {
            str3 = "";
        }
        if ((i & 32) == 0) {
            str4 = str2;
        } else {
            str4 = "";
        }
        trackUtils.trackABResult(z, map, map2, j, str3, str4);
    }

    public final void trackABResult(boolean isSuccess, Map<String, String> map, Map<String, String> map2, long duration, String errorMsg, String mid) {
        Intrinsics.checkNotNullParameter(map, "originResult");
        Intrinsics.checkNotNullParameter(map2, "result");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(mid, "mid");
        Map extra = new LinkedHashMap();
        extra.put("success", isSuccess ? "1" : "0");
        extra.put("origin_result", map.toString());
        extra.put("result", map2.toString());
        for (Map.Entry element$iv : map.entrySet()) {
            String key = element$iv.getKey();
            String value = element$iv.getValue();
            extra.put(key, value);
        }
        extra.put("duration", String.valueOf(duration));
        extra.put("errorMsg", errorMsg);
        if (FeatureConfig.INSTANCE.getTransferFlag()) {
            extra.put("task_id", mid + getTrackID());
        }
        KNeuron.INSTANCE.simpleTrackT("creation.centerplus.app.launch.ab.tracker", extra);
    }
}