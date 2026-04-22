package tv.danmaku.bili.ui.uper;

import android.content.Context;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.moduleservice.upper.UpperService;

public class UperRouter {
    public static final String ROUTE_URI_UPPER_ACTIVITY = "activity://uper/";
    public static final String UPER_ROUTER_ARCHIVE = "activity://uper/archive-entrance/";

    public static void clearUpper(Context context) {
        UpperService upperService = (UpperService) BLRouter.INSTANCE.get(UpperService.class, "default");
        if (upperService != null) {
            upperService.clearUpper(context);
        }
    }

    public static boolean showCreative(Context context) {
        UpperService upperService = (UpperService) BLRouter.INSTANCE.get(UpperService.class, "default");
        if (upperService != null) {
            return upperService.hasDraft(context);
        }
        return false;
    }
}