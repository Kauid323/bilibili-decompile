package tv.danmaku.bili.ui.player.tracer;

import android.content.Context;
import java.util.Map;

public interface BgmEventTracer {
    void feedEvent(Context context, String str);

    void feedEvent(Context context, String str, String str2);

    void reportEvent(String str, Map<String, String> map);
}