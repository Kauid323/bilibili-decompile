package tv.danmaku.bili.update.api;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ReportTacker.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000bH&J<\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH&J0\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000bH&J0\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000bH&J1\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\t2\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0015\"\u00020\tH&¢\u0006\u0002\u0010\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/update/api/ReportTracker;", "", "report", "", "force", "", "eventCategory", "", "eventId", "", "extra", "", "trackT", "sampler", "Lkotlin/Function0;", "reportExposure", "reportClick", "reportV2", "forceReport", "taskId", "values", "", "(ZLjava/lang/String;[Ljava/lang/String;)V", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ReportTracker {
    void report(boolean z, int i, String str, Map<String, String> map);

    void reportClick(boolean z, String str, Map<String, String> map);

    void reportExposure(boolean z, String str, Map<String, String> map);

    void reportV2(boolean z, String str, String... strArr);

    void trackT(boolean z, String str, Map<String, String> map, Function0<Boolean> function0);

    /* compiled from: ReportTacker.kt */
    /* renamed from: tv.danmaku.bili.update.api.ReportTracker$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void report$default(ReportTracker reportTracker, boolean z, int i, String str, Map map, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
            }
            if ((i2 & 8) != 0) {
                map = MapsKt.emptyMap();
            }
            reportTracker.report(z, i, str, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportExposure$default(ReportTracker reportTracker, boolean z, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportExposure");
            }
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            reportTracker.reportExposure(z, str, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportClick$default(ReportTracker reportTracker, boolean z, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportClick");
            }
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            reportTracker.reportClick(z, str, map);
        }
    }
}