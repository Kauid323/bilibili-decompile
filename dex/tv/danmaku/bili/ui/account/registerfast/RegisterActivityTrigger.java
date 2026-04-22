package tv.danmaku.bili.ui.account.registerfast;

import android.app.Activity;
import android.net.Uri;
import com.bilibili.api.BiliConfig;
import com.bilibili.droid.H5UrlConfigHelper;
import com.bilibili.lib.router.Router;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.bili.normal.ui.RouteUtilKt;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.loginv2.LoginFragmentV2;
import tv.danmaku.bili.ui.loginv2.LoginOriginalActivityV2;
import tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2;

public class RegisterActivityTrigger {
    public static final int REQ_CODE_REGISTER_H5 = 1002;
    public static final int REQ_CODE_REGISTER_NATIVE = 1001;
    public static final String TARGET_WEB_SITE = "https://passport.bilibili.com/register";
    public static final String WEB_ROUTE = "activity://main/register/fast";

    public static void launchRegisterV2(LoginFragmentV2 fragment, boolean hideSms) {
        if (fragment == null) {
            return;
        }
        if (!hideSms) {
            LoginOriginalActivityV2 loginActivity = fragment.getLoginActivity();
            if (loginActivity != null) {
                loginActivity.jumpFragment(SmsLoginFragmentV2.TAG);
                Map<String, String> reportMap = new HashMap<>();
                reportMap.put(LoginReporterV2.Click.SIGNUP_KEY_MODE, "3");
                reportMap.put(LoginReporterV2.PAGE_FROM_KEY, "1");
                LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_SIGNUP_0_CLICK, reportMap);
                return;
            }
            return;
        }
        String url = H5UrlConfigHelper.INSTANCE.getUrl("account_ui", "url_register", TARGET_WEB_SITE);
        Uri uri = Uri.parse(url);
        Router.global().with(fragment).with(appendParam(uri)).forResult(1002).open("activity://main/register/fast");
        Map<String, String> reportMap2 = new HashMap<>();
        reportMap2.put(LoginReporterV2.Click.SIGNUP_KEY_MODE, "1");
        reportMap2.put(LoginReporterV2.PAGE_FROM_KEY, "1");
        LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_SIGNUP_0_CLICK, reportMap2);
    }

    public static void launchRegisterV2(Activity activity, boolean isFromLoginPanel, boolean hideSms, String promptScene, String routerFrom) {
        if (activity == null) {
            return;
        }
        if (!hideSms) {
            RouteUtilKt.routeToLoginOriginActivityV2(activity, true, true, null, null, promptScene, routerFrom);
            if (isFromLoginPanel) {
                Map<String, String> reportMap = new HashMap<>();
                reportMap.put(LoginReporterV2.Click.SIGNUP_KEY_MODE, "3");
                reportMap.put(LoginReporterV2.PAGE_FROM_KEY, "2");
                LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_SIGNUP_0_CLICK, reportMap);
                return;
            }
            return;
        }
        String url = H5UrlConfigHelper.INSTANCE.getUrl("account_ui", "url_register", TARGET_WEB_SITE);
        Uri uri = Uri.parse(url);
        Router.global().with(activity).with(appendParam(uri)).forResult(1002).open("activity://main/register/fast");
        if (isFromLoginPanel) {
            Map<String, String> reportMap2 = new HashMap<>();
            reportMap2.put(LoginReporterV2.Click.SIGNUP_KEY_MODE, "1");
            reportMap2.put(LoginReporterV2.PAGE_FROM_KEY, "2");
            LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_SIGNUP_0_CLICK, reportMap2);
        }
    }

    private static Uri appendParam(Uri uri) {
        Uri.Builder builder = uri.buildUpon();
        builder.appendEncodedPath("quickregister.html#/");
        builder.appendQueryParameter("appkey", BiliConfig.getAppKey());
        builder.appendQueryParameter("menu", "0");
        return builder.build();
    }
}