package tv.danmaku.bili.ui.player.tracer;

import android.content.Context;
import java.util.Map;

public class BgmEventTracerManager {
    private static BgmEventTracerManager sInstance;
    private BgmEventTracer mTracer;

    public static BgmEventTracerManager getInstance() {
        if (sInstance == null) {
            sInstance = new BgmEventTracerManager();
        }
        return sInstance;
    }

    private BgmEventTracerManager() {
    }

    public void setEventTracer(BgmEventTracer tracer) {
        this.mTracer = tracer;
    }

    public void feedEvent(Context context, String eventId, String value) {
        if (this.mTracer != null) {
            this.mTracer.feedEvent(context, eventId, value);
        }
    }

    public void feedEvent(Context context, String eventId) {
        if (this.mTracer != null) {
            this.mTracer.feedEvent(context, eventId);
        }
    }

    public void reportEvent(String eventId, Map<String, String> argsMap) {
        if (this.mTracer != null) {
            this.mTracer.reportEvent(eventId, argsMap);
        }
    }
}