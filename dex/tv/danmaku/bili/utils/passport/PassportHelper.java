package tv.danmaku.bili.utils.passport;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import bolts.Task;
import com.bilibili.api.base.util.NetworkManager;
import com.bilibili.app.authorspace.ui.AuthorSpaceActivity;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.model.OAuthInfo;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.okhttp.InMemoryCookieJar;
import com.bilibili.lib.okhttp.OkHttpClientWrapper;
import com.bilibili.lib.performance.EntryPointKt;
import com.bilibili.playerdb.basic.PlayerDBStorage;
import com.bilibili.playerdb.basic.PlayerDBUser;
import java.util.HashMap;
import java.util.concurrent.Callable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.AppBuildConfig;
import tv.danmaku.bili.push.BPushHelper;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;
import tv.danmaku.bili.quick.core.LoginRuleProcessorHelper;
import tv.danmaku.bili.services.videodownload.action.StopAllFullHDTaskAction;
import tv.danmaku.bili.ui.answer.AnswerHelper;
import tv.danmaku.bili.ui.theme.ThemeManager;

public class PassportHelper {
    private static final String PREF_LIVE_NAME = "live_user_info";
    private static final String TAG = "PassportHelper";

    @JvmStatic
    private static CookieManager __Ghost$Insertion$com_bilibili_gripper_container_bwebview_WebViewGhost_getInstance() {
        Application it;
        if (EntryPointKt.getBootOptEnable() && (it = BiliContext.application()) != null) {
            CookieSyncManager.createInstance(it);
            Log.e("WebViewGhost", "hook CookieManager getInstance");
        }
        CookieManager cookieManager = CookieManager.getInstance();
        Intrinsics.checkNotNull(cookieManager, "null cannot be cast to non-null type android.webkit.CookieManager");
        return cookieManager;
    }

    public static PassportObserver observer(Context context) {
        if (BiliContext.isMainProcess()) {
            return new MainProcessPassportObserver(context);
        }
        return new DefaultPassportObserver(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class DefaultPassportObserver implements PassportObserver {
        protected Context mContext;

        DefaultPassportObserver(Context context) {
            this.mContext = context.getApplicationContext();
        }

        public void onChange(Topic topic) {
            switch (AnonymousClass3.$SwitchMap$com$bilibili$lib$accounts$subscribe$Topic[topic.ordinal()]) {
                case 1:
                    BLog.i(PassportHelper.TAG, "on signed in");
                    onSignIn();
                    return;
                case 2:
                    BLog.i(PassportHelper.TAG, "on signed out");
                    onSignOut();
                    return;
                case 3:
                    BLog.i(PassportHelper.TAG, "on token refreshed");
                    onTokenRefreshed();
                    return;
                case 4:
                    BLog.i(PassportHelper.TAG, "on switch");
                    onSwitch();
                    return;
                default:
                    return;
            }
        }

        void onSignIn() {
            CrashReporter.INSTANCE.setUserId(this.mContext, String.valueOf(BiliAccounts.get(this.mContext).mid()));
        }

        void onSignOut() {
            BiliAccountInfo.get().clearAccountInfo();
            CrashReporter.INSTANCE.setUserId(this.mContext, "");
        }

        void onSwitch() {
            CrashReporter.INSTANCE.setUserId(this.mContext, String.valueOf(BiliAccounts.get(this.mContext).mid()));
        }

        void onTokenRefreshed() {
        }
    }

    /* renamed from: tv.danmaku.bili.utils.passport.PassportHelper$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$bilibili$lib$accounts$subscribe$Topic = new int[Topic.values().length];

        static {
            try {
                $SwitchMap$com$bilibili$lib$accounts$subscribe$Topic[Topic.SIGN_IN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$bilibili$lib$accounts$subscribe$Topic[Topic.SIGN_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$bilibili$lib$accounts$subscribe$Topic[Topic.TOKEN_REFRESHED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$bilibili$lib$accounts$subscribe$Topic[Topic.ACCOUNT_SWITCH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class MainProcessPassportObserver extends DefaultPassportObserver {
        private String LOGIN_SUCCEED_EVENT_ID;

        MainProcessPassportObserver(Context context) {
            super(context);
            this.LOGIN_SUCCEED_EVENT_ID = "app.login.allsucceed.0.show";
        }

        @Override // tv.danmaku.bili.utils.passport.PassportHelper.DefaultPassportObserver
        void onSignOut() {
            StopAllFullHDTaskAction.start(this.mContext);
            Task.callInBackground(new Callable<Void>() { // from class: tv.danmaku.bili.utils.passport.PassportHelper.MainProcessPassportObserver.1
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    try {
                        BPushHelper.triggerUpdateUserInfo(BPushHelper.getStateLogout());
                        BiliAccountInfo.get().clearAccountInfo();
                        CrashReporter.INSTANCE.setUserId(MainProcessPassportObserver.this.mContext, "");
                        MainProcessPassportObserver.doClear(MainProcessPassportObserver.this.mContext);
                        LoginRuleProcessorHelper.INSTANCE.getLoginType((LoginRuleProcessor.GetLoginTypeCallBack) null, false);
                    } catch (Exception e) {
                        BLog.w(PassportHelper.TAG, e);
                    }
                    return null;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void doClear(Context context) {
            NetworkManager.getBiliCache().evictAll();
            PassportHelper.removeAllCookies(context);
            ThemeManager.getInstance(context).clearThemeFiles();
            new AnswerHelper(context).clear();
            PassportHelper.clearLivePref(context);
            AuthorSpaceActivity.doClear();
        }

        @Override // tv.danmaku.bili.utils.passport.PassportHelper.DefaultPassportObserver
        void onSwitch() {
            super.onSwitch();
            if (!AppBuildConfig.isBlueApp(this.mContext)) {
                BPushHelper.triggerUpdateUserInfo(BPushHelper.getStateSwitch());
            }
            ThemeManager.getInstance(this.mContext).update();
            Neurons.reportExposure(true, this.LOGIN_SUCCEED_EVENT_ID, new HashMap());
        }

        @Override // tv.danmaku.bili.utils.passport.PassportHelper.DefaultPassportObserver
        void onSignIn() {
            super.onSignIn();
            if (!AppBuildConfig.isBlueApp(this.mContext)) {
                BPushHelper.triggerUpdateUserInfo(BPushHelper.getStateLogin());
            }
            ThemeManager.getInstance(this.mContext).update();
            Neurons.reportExposure(true, this.LOGIN_SUCCEED_EVENT_ID, new HashMap());
        }
    }

    public static Task<OAuthInfo> verify(final Context context) {
        return Task.callInBackground(new Callable<OAuthInfo>() { // from class: tv.danmaku.bili.utils.passport.PassportHelper.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public OAuthInfo call() throws Exception {
                return BiliAccounts.get(context).callVerifyToken();
            }
        });
    }

    public static Task<Void> signOutForUser(final Context context) {
        return Task.callInBackground(new Callable<Void>() { // from class: tv.danmaku.bili.utils.passport.PassportHelper.2
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                String playerStorageUser = new PlayerDBUser(context).identity();
                PlayerDBStorage.clear(context, playerStorageUser, (String) null);
                BiliAccounts.get(context).logoutByUser();
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void removeAllCookies(Context context) {
        try {
            CookieManager instance = __Ghost$Insertion$com_bilibili_gripper_container_bwebview_WebViewGhost_getInstance();
            if (instance != null) {
                instance.setAcceptCookie(true);
                instance.removeAllCookies(null);
                instance.removeSessionCookies(null);
                instance.flush();
                if (instance.hasCookies()) {
                    instance.setCookie("http://www.bilibili.com", "DedeUserID=; Domain=.bilibili.com");
                    instance.setCookie("http://www.bilibili.com", "DedeUserID__ckMd5=; Domain=.bilibili.com");
                    instance.setCookie("http://www.bilibili.com", "SESSDATA=; Domain=.bilibili.com");
                    instance.setCookie("http://vipgift.biligame.com", "DedeUserID=; Domain=.biligame.com");
                    instance.setCookie("http://vipgift.biligame.com", "DedeUserID__ckMd5=; Domain=.biligame.com");
                    instance.setCookie("http://vipgift.biligame.com", "SESSDATA=; Domain=.biligame.com");
                    instance.flush();
                }
            }
            InMemoryCookieJar cookieJar = OkHttpClientWrapper.get().cookieJar();
            if (cookieJar instanceof InMemoryCookieJar) {
                cookieJar.clearAll();
            }
        } catch (Exception e) {
            BLog.w("LOGOUT", "clear cookies error!", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearLivePref(Context context) {
        context.getSharedPreferences(PREF_LIVE_NAME, 0).edit().clear().apply();
    }
}