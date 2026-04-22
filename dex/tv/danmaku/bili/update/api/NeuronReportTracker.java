package tv.danmaku.bili.update.api;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: NeuronReportTracker.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\rH\u0016J<\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0016J.\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\rH\u0016J.\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\rH\u0016J1\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000b2\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0017\"\u00020\u000bH\u0016¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/update/api/NeuronReportTracker;", "Ltv/danmaku/bili/update/api/ReportTracker;", "<init>", "()V", "report", "", "force", "", "eventCategory", "", "eventId", "", "extra", "", "trackT", "sampler", "Lkotlin/Function0;", "reportExposure", "reportClick", "reportV2", "forceReport", "taskId", "values", "", "(ZLjava/lang/String;[Ljava/lang/String;)V", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class NeuronReportTracker implements ReportTracker {
    @Override // tv.danmaku.bili.update.api.ReportTracker
    public void report(boolean force, int eventCategory, String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
        Neurons.report$default(force, eventCategory, eventId, map, (String) null, 0, 48, (Object) null);
    }

    @Override // tv.danmaku.bili.update.api.ReportTracker
    public void trackT(boolean force, String eventId, Map<String, String> map, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
        Intrinsics.checkNotNullParameter(function0, "sampler");
        Neurons.trackT$default(force, eventId, map, 0, function0, 8, (Object) null);
    }

    @Override // tv.danmaku.bili.update.api.ReportTracker
    public void reportExposure(boolean force, String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
        Neurons.reportExposure$default(force, eventId, map, (List) null, 8, (Object) null);
    }

    @Override // tv.danmaku.bili.update.api.ReportTracker
    public void reportClick(boolean force, String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "extra");
        Neurons.reportClick(force, eventId, map);
    }

    @Override // tv.danmaku.bili.update.api.ReportTracker
    public void reportV2(boolean forceReport, String taskId, String... values) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(values, "values");
    }
}