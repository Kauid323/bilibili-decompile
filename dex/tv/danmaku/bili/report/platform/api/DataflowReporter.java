package tv.danmaku.bili.report.platform.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.util.Map;

public class DataflowReporter {
    private static final String TAG = "dataflow.reporter";

    public static void report(String eventId, int eventType, Map<String, String> extra) {
    }

    private static String getEventData(Map<String, String> map) {
        return JSON.toJSONString(map, new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
    }
}