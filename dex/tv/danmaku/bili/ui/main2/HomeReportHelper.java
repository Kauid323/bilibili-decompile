package tv.danmaku.bili.ui.main2;

import androidx.collection.ArrayMap;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import java.util.Map;

public final class HomeReportHelper {

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Values {
        static final String EVENT_HOME_NAV_VIEW_CLICK_WHEN_LOGGED_IN = "main.homepage.avatar.0.click";
        public static final String EVENT_HOME_NAV_VIEW_CLICK_WHEN_NOT_LOGGED_IN = "main.homepage.avatar-nologin.all.click";
        public static final String EVENT_TAB_CLICK = "tabbar_click";
        public static final String EVENT_TYPE_CLICK = "click";
        public static final int TYPE_ATTENTION = 3;
        public static final int TYPE_CATEGORY = 2;
        public static final int TYPE_COMMUNICATE = 4;
        public static final int TYPE_HOME = 1;
        public static final int TYPE_ME = 5;
    }

    public static void reportTabClick(int type) {
        InfoEyesManager.getInstance().report2(false, "000225", new String[]{Values.EVENT_TAB_CLICK, "click", String.valueOf(type)});
    }

    public static void reportNavViewClick(String gotoFlag) {
        Map<String, String> param = new HashMap<>();
        param.put("goto", gotoFlag);
        Neurons.reportClick(false, "main.homepage.avatar.0.click", param);
    }

    public static void reportNoLoginedNavViewClick(String url) {
        ArrayMap arrayMap = new ArrayMap(1);
        arrayMap.put("avatar_id", url == null ? "" : url);
        Neurons.reportClick(false, "main.homepage.avatar-nologin.all.click", arrayMap);
    }
}