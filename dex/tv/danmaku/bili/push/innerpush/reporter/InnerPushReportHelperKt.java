package tv.danmaku.bili.push.innerpush.reporter;

import com.alibaba.fastjson.JSON;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;

/* compiled from: InnerPushReportHelper.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\u001a:\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u001a<\u0010\b\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u001aD\u0010\n\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u001a\u0010\u0010\r\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¨\u0006\u000f"}, d2 = {"reportClick", "", "taskId", "", "gesture", "msgSource", InnerPushReceiverKt.KEY_EXTRA, "", "reportShow", "pvId", "reportDiscardReason", "reason", "serverFilterReason", "reportClickTest", "url", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerPushReportHelperKt {
    public static final void reportClick(String taskId, String gesture, String msgSource, Map<String, String> map) {
        Map it = new LinkedHashMap();
        it.put("taskid", taskId == null ? "" : taskId);
        it.put("gesture", gesture);
        it.put("msg_source", msgSource != null ? msgSource : "");
        if (!(map == null || map.isEmpty())) {
            it.put(InnerPushReceiverKt.KEY_EXTRA, JSON.toJSONString(map));
        }
        Unit unit = Unit.INSTANCE;
        Neurons.reportClick(false, "push.push-inpop.top-banner.0.click", it);
    }

    public static /* synthetic */ void reportShow$default(String str, String str2, Map map, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = null;
        }
        reportShow(str, str2, map, str3);
    }

    public static final void reportShow(String taskId, String msgSource, Map<String, String> map, String pvId) {
        Map it = new LinkedHashMap();
        it.put("taskid", taskId == null ? "" : taskId);
        it.put("msg_source", msgSource != null ? msgSource : "");
        if (pvId != null) {
            it.put("pvid", pvId);
        }
        if (!(map == null || map.isEmpty())) {
            it.put(InnerPushReceiverKt.KEY_EXTRA, JSON.toJSONString(map));
        }
        Unit unit = Unit.INSTANCE;
        Neurons.reportExposure$default(false, "push.push-inpop.top-banner.0.show", it, (List) null, 8, (Object) null);
    }

    public static final void reportDiscardReason(String taskId, String msgSource, String reason, String serverFilterReason, Map<String, String> map) {
        Map it = new LinkedHashMap();
        it.put("taskid", taskId == null ? "" : taskId);
        it.put("msg_source", msgSource == null ? "" : msgSource);
        it.put("reason", reason != null ? reason : "");
        String str = serverFilterReason;
        boolean z = true;
        if (!(str == null || str.length() == 0)) {
            it.put("server_filter_reason", serverFilterReason);
        }
        if (map != null && !map.isEmpty()) {
            z = false;
        }
        if (!z) {
            it.put(InnerPushReceiverKt.KEY_EXTRA, JSON.toJSONString(map));
        }
        Unit unit = Unit.INSTANCE;
        Neurons.reportClick(false, "push.push-inpop.discard.0.click", it);
    }

    public static final void reportClickTest(String url) {
        Map it = new LinkedHashMap();
        it.put("url", url == null ? "" : url);
        it.put("phase", "click_push");
        it.put("status", "success");
        Unit unit = Unit.INSTANCE;
        Neurons.reportClick(true, "push.push-inpop.webview.0.click", it);
    }
}