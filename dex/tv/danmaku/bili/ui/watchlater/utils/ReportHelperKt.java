package tv.danmaku.bili.ui.watchlater.utils;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ReportHelper.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0000\u001a&\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"EVENT_WATCH_LATER_TOAST_SHOW", "", "EVENT_WATCH_LATER_TOAST_CLICK", "reportWatchLaterToastShow", "", "text", "avid", "spmid", "reportWatchLaterToastClick", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ReportHelperKt {
    public static final String EVENT_WATCH_LATER_TOAST_CLICK = "main.homepage.later-watch-tips.0.click";
    public static final String EVENT_WATCH_LATER_TOAST_SHOW = "main.homepage.later-watch-tips.0.show";

    public static final void reportWatchLaterToastShow(String text, String avid, String spmid) {
        Map param = new LinkedHashMap();
        param.put("text", text == null ? "" : text);
        param.put("avid", avid == null ? "" : avid);
        param.put("spmid", spmid != null ? spmid : "");
        Neurons.reportExposure$default(false, EVENT_WATCH_LATER_TOAST_SHOW, param, (List) null, 8, (Object) null);
    }

    public static final void reportWatchLaterToastClick(String text, String avid, String spmid) {
        Map param = new LinkedHashMap();
        param.put("text", text == null ? "" : text);
        param.put("avid", avid == null ? "" : avid);
        param.put("spmid", spmid != null ? spmid : "");
        Neurons.reportClick(false, EVENT_WATCH_LATER_TOAST_CLICK, param);
    }
}