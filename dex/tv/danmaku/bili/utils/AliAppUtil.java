package tv.danmaku.bili.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.bilibili.app.auth.R;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import java.net.URLEncoder;
import java.util.List;

public class AliAppUtil {
    public static boolean hasApplication() {
        Context context = BiliContext.application();
        if (context == null) {
            return false;
        }
        PackageManager manager = context.getPackageManager();
        Intent action = new Intent("android.intent.action.VIEW");
        action.setData(Uri.parse("alipays://"));
        List list = manager.queryIntentActivities(action, 64);
        return list != null && list.size() > 0;
    }

    public static void doVerify(Context context, String url) {
        Intent action = new Intent("android.intent.action.VIEW");
        action.setData(Uri.parse("alipays://platformapi/startapp?appId=20000067&url=" + URLEncoder.encode(url)));
        try {
            context.startActivity(action);
        } catch (ActivityNotFoundException e) {
            ToastHelper.showToastShort(context, R.string.auth_zhima_no_app_tips);
        }
    }
}