package a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.sina.weibo.sdk.auth.AuthInfo;
import g.a;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f133a = false;
    public static AuthInfo b;

    public static boolean a(Context context) {
        a.a a2;
        return b(context) && (a2 = g.a.a(context)) != null && a2.c >= 10772;
    }

    public static boolean b(Context context) {
        List<ResolveInfo> queryIntentServices;
        String[] strArr = {"com.sina.weibo", "com.sina.weibog3"};
        for (int i = 0; i < 2; i++) {
            String str = strArr[i];
            Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
            intent.setPackage(str);
            intent.addCategory("android.intent.category.DEFAULT");
            if (context != null && (queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0)) != null && !queryIntentServices.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}