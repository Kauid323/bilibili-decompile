package tv.danmaku.bili.report.platform.neuron;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import tv.danmaku.bili.BR;

/* compiled from: AppSysReport.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/report/platform/neuron/AppSysReport;", "", "<init>", "()V", "reportAppFirstOpen", "", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppSysReport {
    public static final AppSysReport INSTANCE = new AppSysReport();

    private AppSysReport() {
    }

    @JvmStatic
    public static final void reportAppFirstOpen() {
        Neurons.report$default(true, 4, NeuronEventId.APP_FIRST_OPEN, (Map) null, (String) null, 0, 56, (Object) null);
    }
}