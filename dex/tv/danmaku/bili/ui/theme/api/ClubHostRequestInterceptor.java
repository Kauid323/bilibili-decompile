package tv.danmaku.bili.ui.theme.api;

import com.bilibili.okretro.interceptor.SignOnUrlRequestInterceptor;
import java.util.Map;

public class ClubHostRequestInterceptor extends SignOnUrlRequestInterceptor {
    protected void addCommonParam(Map<String, String> params) {
        super.addCommonParam(params);
        params.put("actionKey", "appkey");
    }
}