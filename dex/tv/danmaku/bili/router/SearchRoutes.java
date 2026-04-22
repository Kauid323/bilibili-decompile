package tv.danmaku.bili.router;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bilibili.lib.router.Router;

public class SearchRoutes {
    public static final String ACTION_SEARCH_EGG_UPDATE = "action://search/easter_egg_config_update";
    public static final String URI_BILIBILI_SEARCH = "bilibili://search";

    public static Intent createSearchEntranceIntent(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(URI_BILIBILI_SEARCH));
        intent.setPackage(context.getPackageName());
        return intent;
    }

    public static void enterSearch(Context context) {
        Intent intent = createSearchEntranceIntent(context);
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void updateSearchEggConfig(Context context) {
        Router.global().with(context).call(ACTION_SEARCH_EGG_UPDATE);
    }
}