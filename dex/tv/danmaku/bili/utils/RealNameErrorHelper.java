package tv.danmaku.bili.utils;

import android.app.Activity;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.moduleservice.main.MainCommonService;

public class RealNameErrorHelper {
    private static final int ACCOUNT_BIND_PHONE = 61001;
    private static final int ACCOUNT_CHANGE_PHONE = 61002;

    public static boolean isRealName(int code) {
        return code == 61001 || code == 61002;
    }

    public static void showDialog(Activity activity, int uniformCode, String msg) {
        MainCommonService service = (MainCommonService) BLRouter.INSTANCE.getServices(MainCommonService.class).get("default");
        if (service != null) {
            service.showAuthorityDialog(activity, msg, uniformCode);
        }
    }
}