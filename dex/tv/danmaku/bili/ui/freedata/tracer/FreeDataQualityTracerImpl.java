package tv.danmaku.bili.ui.freedata.tracer;

import com.bilibili.fd_service.FreeDataQualityTracer;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.android.log.BLog;

public class FreeDataQualityTracerImpl implements FreeDataQualityTracer {
    public static final String EVENT_ID = "main.freeflow.quality.track";
    private static final FreeDataQualityTracerImpl instance = new FreeDataQualityTracerImpl();

    private FreeDataQualityTracerImpl() {
    }

    public static FreeDataQualityTracerImpl getInstance() {
        return instance;
    }

    public void onQualityTrace(FreeDataQualityTracer.QualityResult qualityResult) {
        BLog.d("quality trace " + qualityResult.toString());
        Map<String, String> map = new HashMap<>();
        if (qualityResult.mFreeDataType != null) {
            map.put("type", qualityResult.mFreeDataType.name());
        }
        if (qualityResult.mResourceType != null) {
            map.put("resource", qualityResult.mResourceType.name());
        }
        map.put("result", qualityResult.mFreeDataResult.getValue());
        map.put("error", String.valueOf(qualityResult.mReason));
        map.put("url", qualityResult.mUrlFail);
        map.put("usrid", qualityResult.mUserMob);
        map.put("rule", qualityResult.mFdRule);
        map.put("cost", qualityResult.cost + "");
        Neurons.reportTracker(true, EVENT_ID, map);
    }
}