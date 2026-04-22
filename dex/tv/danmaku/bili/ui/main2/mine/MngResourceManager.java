package tv.danmaku.bili.ui.main2.mine;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.StringUtil;
import com.bilibili.lib.homepage.mine.MenuGroup;
import java.util.ArrayList;
import java.util.List;

public class MngResourceManager {
    private static final String KEY_MNG_RESOURCE = "mine_mng_resource_click_record";

    public static boolean isShowMngResource(MenuGroup.ItemMngResource resource) {
        if (resource == null || StringUtil.isBlank(resource.iconId)) {
            return false;
        }
        return !getRecordedIds().contains(resource.iconId);
    }

    public static void recordMngResourceClicked(MenuGroup.ItemMngResource resource) {
        Context ctx = BiliContext.application();
        if (resource == null || StringUtil.isBlank(resource.iconId) || ctx == null) {
            return;
        }
        BiliGlobalPreferenceHelper helper = BiliGlobalPreferenceHelper.getInstance(ctx);
        List<String> record = getRecordedIds();
        record.add(resource.iconId);
        helper.edit().putString(KEY_MNG_RESOURCE, JSON.toJSONString(record)).apply();
    }

    private static List<String> getRecordedIds() {
        Context ctx = BiliContext.application();
        if (ctx != null) {
            BiliGlobalPreferenceHelper helper = BiliGlobalPreferenceHelper.getInstance(ctx);
            String json = helper.optString(KEY_MNG_RESOURCE, "");
            try {
                List<String> result = JSON.parseArray(json, String.class);
                return result == null ? new ArrayList() : result;
            } catch (Exception e) {
            }
        }
        return new ArrayList();
    }
}