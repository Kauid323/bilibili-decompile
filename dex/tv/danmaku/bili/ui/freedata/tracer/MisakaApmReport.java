package tv.danmaku.bili.ui.freedata.tracer;

import com.bilibili.fd_service.report.FreeDataTechnologyReporter;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tv.danmaku.bili.BR;

/* compiled from: MisakaApmReport.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010\u000b\u001a\u00020\u00052\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rH\u0016J\u001e\u0010\u000e\u001a\u00020\u00052\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ui/freedata/tracer/MisakaApmReport;", "Lcom/bilibili/fd_service/report/FreeDataTechnologyReporter;", "<init>", "()V", "activeReport", "", "order", "", "type", "method", "data", "qualityReport", "map", "", "errorReport", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MisakaApmReport implements FreeDataTechnologyReporter {
    public static final int $stable = 0;

    public void activeReport(String order, String type, String method, String data) {
        HashMap map = new HashMap();
        map.put("order", order == null ? "" : order);
        map.put("type", type == null ? "" : type);
        map.put("method", method == null ? "" : method);
        map.put("data", data != null ? data : "");
        Neurons.trackT$default(false, "public.bandwidth.activation.track", map, 0, new Function0() { // from class: tv.danmaku.bili.ui.freedata.tracer.MisakaApmReport$$ExternalSyntheticLambda2
            public final Object invoke() {
                boolean activeReport$lambda$0;
                activeReport$lambda$0 = MisakaApmReport.activeReport$lambda$0();
                return Boolean.valueOf(activeReport$lambda$0);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean activeReport$lambda$0() {
        return true;
    }

    public void qualityReport(Map<String, String> map) {
        if (map != null) {
            Neurons.trackT$default(false, "public.bandwidth.transform.track", map, 0, new Function0() { // from class: tv.danmaku.bili.ui.freedata.tracer.MisakaApmReport$$ExternalSyntheticLambda1
                public final Object invoke() {
                    boolean qualityReport$lambda$0$0;
                    qualityReport$lambda$0$0 = MisakaApmReport.qualityReport$lambda$0$0();
                    return Boolean.valueOf(qualityReport$lambda$0$0);
                }
            }, 8, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean qualityReport$lambda$0$0() {
        return true;
    }

    public void errorReport(Map<String, String> map) {
        if (map != null) {
            Neurons.trackT$default(false, "public.bandwidth.error.detail.track", map, 0, new Function0() { // from class: tv.danmaku.bili.ui.freedata.tracer.MisakaApmReport$$ExternalSyntheticLambda0
                public final Object invoke() {
                    boolean errorReport$lambda$0$0;
                    errorReport$lambda$0$0 = MisakaApmReport.errorReport$lambda$0$0();
                    return Boolean.valueOf(errorReport$lambda$0$0);
                }
            }, 8, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean errorReport$lambda$0$0() {
        return true;
    }
}