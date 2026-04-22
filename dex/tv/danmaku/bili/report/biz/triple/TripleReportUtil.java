package tv.danmaku.bili.report.biz.triple;

import com.bilibili.lib.neuron.model.CustomModel;
import com.bilibili.lib.neuron.model.material.PublicHeader;
import com.bilibili.lib.neuron.model.material.PublicStaticHeader;
import com.bilibili.lib.neuron.util.NeuronRuntimeHelper;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.bili.ui.deeplinkbutton.DeepLinkButtonReportKt;

public final class TripleReportUtil {
    public static final String TAG = "TripleReportUtil";

    public static Map<String, String> getMsgInfoMap(CustomModel model) {
        PublicStaticHeader sHeader = NeuronRuntimeHelper.getInstance().getPublicStaticHeader();
        PublicHeader pHeader = NeuronRuntimeHelper.getInstance().getPublicHeader();
        Map<String, String> map = new HashMap<>();
        map.put("app_id", sHeader.pid + "");
        map.put("platform", sHeader.platform + "");
        map.put("buvid", sHeader.buvid);
        map.put(DeepLinkButtonReportKt.REPORT_EXTRA_CHANNEL, sHeader.chid);
        map.put("brand", sHeader.brand);
        map.put("device_id", sHeader.deviceid);
        map.put("model", sHeader.model);
        map.put("osver", sHeader.osver);
        map.put("fts", sHeader.fts + "");
        map.put("event_category", model.eventCategory + "");
        map.put("network", pHeader.net + "");
        map.put("oid", pHeader.oid);
        map.put("longitude", "0");
        map.put("latitude", "0");
        map.put("version", pHeader.version);
        map.put("version_code", pHeader.versionCode + "");
        map.put("logver", "");
        map.put("event_id", model.eventId);
        map.put("mid", pHeader.mid);
        map.put("ctime", System.currentTimeMillis() + "");
        map.put("retry_send_count", "0");
        map.put("extended_fields", model.extension + "");
        map.put("upload_time", System.currentTimeMillis() + "");
        return map;
    }

    public static <K, V> Map mergeMaps(Map<K, V>... maps) {
        Class clazz = maps[0].getClass();
        Map<K, V> map = null;
        try {
            map = (Map) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Map<K, V> map2 : maps) {
            map.putAll(map2);
        }
        return map;
    }
}