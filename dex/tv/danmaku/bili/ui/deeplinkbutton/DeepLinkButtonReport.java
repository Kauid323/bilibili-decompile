package tv.danmaku.bili.ui.deeplinkbutton;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import tv.danmaku.bili.BR;

/* compiled from: DeepLinkButtonReport.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/deeplinkbutton/DeepLinkButtonReport;", "", "<init>", "()V", "reportButtonShow", "", "channel", "", "reportButtonBackClick", "reportButtonCloseClick", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DeepLinkButtonReport {
    public static final int $stable = 0;
    public static final DeepLinkButtonReport INSTANCE = new DeepLinkButtonReport();

    private DeepLinkButtonReport() {
    }

    @JvmStatic
    public static final void reportButtonShow(String channel) {
        HashMap map = new HashMap();
        map.put(DeepLinkButtonReportKt.REPORT_EXTRA_CHANNEL, channel);
        Neurons.reportExposure$default(false, DeepLinkButtonReportKt.BUTTON_SHOW, map, (List) null, 8, (Object) null);
    }

    @JvmStatic
    public static final void reportButtonBackClick(String channel) {
        HashMap map = new HashMap();
        map.put(DeepLinkButtonReportKt.REPORT_EXTRA_CHANNEL, channel);
        Neurons.reportClick(false, DeepLinkButtonReportKt.BUTTON_BACK_CLICK, map);
    }

    @JvmStatic
    public static final void reportButtonCloseClick(String channel) {
        HashMap map = new HashMap();
        map.put(DeepLinkButtonReportKt.REPORT_EXTRA_CHANNEL, channel);
        Neurons.reportClick(false, DeepLinkButtonReportKt.BUTTON_CLOSE_CLICK, map);
    }
}