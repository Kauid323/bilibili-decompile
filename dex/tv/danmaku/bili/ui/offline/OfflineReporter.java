package tv.danmaku.bili.ui.offline;

import android.net.Uri;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.offline.OfflineType;
import java.util.HashMap;

public class OfflineReporter {
    public static void reportStoragePath(String value) {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("result", Uri.encode(value));
        Neurons.reportClick(false, "main.download-setting.storage-directory.0.click", params);
    }

    public static void reportHomeSearchMenuClick() {
        Neurons.reportClick(false, "main.my-cache.search.0.click");
    }

    public static void reportHomeSettingMenuClick() {
        Neurons.reportClick(false, "main.my-cache.download-setting.0.click");
    }

    public static void reportHomeEditMenuClick() {
        Neurons.reportClick(false, "main.my-cache.manager.0.click");
    }

    public static void reportHomeDownloadingClick() {
        Neurons.reportClick(false, "main.my-cache.downloading.0.click");
    }

    public static void reportHomeSelectAll() {
        Neurons.reportClick(false, "main.my-cache-manage.all-check.0.click");
    }

    public static void reportHomeDelete() {
        Neurons.reportClick(false, "main.my-cache-manage.delete.0.click");
    }

    public static void reportHomeUpdateDanmaku() {
        Neurons.reportClick(false, "main.my-cache-manage.update-dm.0.click");
    }

    public static void reportHomeDownloadedVideoGroupClick() {
        Neurons.reportClick(false, "main.my-cache.duop-manager.0.click");
    }

    public static void reportHomeDownloadedVideoClick(boolean chargeVideo) {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("is_charge", chargeVideo ? "1" : "0");
        Neurons.reportClick(false, "main.my-cache.play.0.click", params);
    }

    public static void reportHomeDownloadedVideoDetail() {
        Neurons.reportClick(false, "main.my-cache.video-detail.0.click");
    }

    public static void reportDownloadingStartAll() {
        Neurons.reportClick(false, "main.my-caching.begin-all.0.click");
    }

    public static void reportDownloadingPauseAll() {
        Neurons.reportClick(false, "main.my-caching.pause-all.0.click");
    }

    public static void reportDownloadingEditMenuClick() {
        Neurons.reportClick(false, "main.my-caching.manager.0.click");
    }

    public static void reportDownloadingSelectAll() {
        Neurons.reportClick(false, "main.my-caching-manage.all-check.0.click");
    }

    public static void reportDownloadingDelete() {
        Neurons.reportClick(false, "main.my-caching-manage.delete.0.click");
    }

    public static void reportDownloadingItemPause(OfflineInfo info) {
        int type;
        if (info.offlineType.type == OfflineType.TYPE_AUDIO) {
            type = 2;
        } else {
            type = 1;
        }
        HashMap<String, String> params = new HashMap<>(1);
        params.put("type", String.valueOf(type));
        params.put("id", String.valueOf(OfflineUtil.getPlayId(info)));
        Neurons.reportClick(false, "main.my-caching.pause.0.click", params);
    }

    public static void reportDownloadingItemStart(OfflineInfo info) {
        int type;
        if (info.offlineType.type == OfflineType.TYPE_AUDIO) {
            type = 2;
        } else {
            type = 1;
        }
        HashMap<String, String> params = new HashMap<>(1);
        params.put("type", String.valueOf(type));
        params.put("id", String.valueOf(OfflineUtil.getPlayId(info)));
        Neurons.reportClick(false, "main.my-caching.begin.0.click", params);
    }

    public static void reportDownloadedPagePlay() {
        Neurons.reportClick(false, "main.duop-cache.play.0.click");
    }

    public static void reportDownloadedPageEditMenuClick() {
        Neurons.reportClick(false, "main.duop-cache.manager.0.click");
    }

    public static void reportDownloadedPageSelectAll() {
        Neurons.reportClick(false, "main.duop-cache-manage.all-check.0.click");
    }

    public static void reportDownloadedPageDelete() {
        Neurons.reportClick(false, "main.duop-cache-manage.delete.0.click");
    }

    public static void reportDownloadedPageUpdateDanmaku() {
        Neurons.reportClick(false, "main.duop-cache-manage.update-dm.0.click");
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static class OfflineEvent {
        public String args1;
        public String args2;
        public String args3;
        public String args4;
        public String eventId;
        public String eventType;

        private OfflineEvent() {
        }

        private String[] asArgs() {
            return new String[]{Uri.encode(this.eventId), Uri.encode(this.eventType), Uri.encode(this.args1), Uri.encode(this.args2), Uri.encode(this.args3), Uri.encode(this.args4)};
        }

        public void report() {
            InfoEyesManager.getInstance().report2(false, "000225", asArgs());
        }
    }
}