package tv.danmaku.bili.ui.offline;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterReporterKt;

public class OfflineReportHelper {
    public static final String CLICK_CHANGE_TASK_COUNT = "main.my-caching.downloadnum.0.click";
    public static final String CLICK_ORDER_BUTTON = "main.my-cache.order-cache.0.click";
    public static final String CLICK_PLAY_IN_ADVANCE = "main.my-cache.loading.0.click";
    public static final String CLICK_VIP_DIALOG_DOWNLOADED = "main.my-cache.vipcache.connect.click";
    public static final String CLICK_VIP_DIALOG_DOWNLOADING = "main.my-caching.vipcache.0.click";
    public static final String SHOW_ORDER_BUTTON = "main.my-cache.order-cache.0.show";
    public static final String SHOW_PLAY_IN_ADVANCE = "main.my-cache.loading.0.show";
    public static final String SHOW_VIP_DIALOG_DOWNLOADED = "main.my-cache.vipcache.connect.show";
    public static final String SHOW_VIP_DIALOG_DOWNLOADING = "main.my-caching.vipcache.0.show";

    public static void reportVipDialogClick(int type, int option) {
        Map<String, String> extra = new HashMap<>();
        extra.put("type", String.valueOf(type));
        extra.put(WatchLaterReporterKt.KEY_OPTION, String.valueOf(option));
        Neurons.reportClick(false, CLICK_VIP_DIALOG_DOWNLOADING, extra);
    }

    public static void reportVipDialogShow(int type) {
        Map<String, String> extra = new HashMap<>();
        extra.put("type", String.valueOf(type));
        Neurons.reportExposure(false, SHOW_VIP_DIALOG_DOWNLOADING, extra);
    }

    public static void reportVipDownloadedDialogClick(int option) {
        Map<String, String> extra = new HashMap<>();
        extra.put(WatchLaterReporterKt.KEY_OPTION, String.valueOf(option));
        Neurons.reportClick(false, CLICK_VIP_DIALOG_DOWNLOADED, extra);
    }
}