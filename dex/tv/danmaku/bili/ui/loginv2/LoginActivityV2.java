package tv.danmaku.bili.ui.loginv2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.FragmentActivity;
import bili.resource.account.R;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.fastjson.JSON;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.PhoneUtils;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.FastLoginInfo;
import com.bilibili.lib.accounts.model.SimpleAccountItem;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.accountsui.fast.FastLoginUserHelper;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import com.bilibili.lib.accountsui.quick.QuickLoginTag;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteInterceptor;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteResponse;
import com.bilibili.lib.config.BLRemoteConfig;
import com.bilibili.lib.gson.GsonKt;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.module.main.innerpush.IShowPushWhenPageDestroy;
import com.bilibili.playerbizcommon.miniplayer.IMiniPlayerContainer;
import com.bilibili.teenagersmode.TeenagersMode;
import j$.util.Objects;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.normal.ui.RouteUtilKt;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;
import tv.danmaku.bili.quick.core.OnePassLoginPhoneData;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.loginv2.LoginActivityV2;
import tv.danmaku.bili.utils.LoginSceneProcessor;

public class LoginActivityV2 extends AppCompatActivity implements IShowPushWhenPageDestroy, IMiniPlayerContainer {
    public static final int LOGIN_ENTRY_FROM_SERVER_RULE = 1;
    public static final String LOGIN_ENTRY_KEY = "entry";
    public static final int LOGIN_ENTRY_ORIGINAL = 2;
    public static final int LOGIN_ENTRY_QUICK = 3;
    public static final String LOGIN_SKIP_CHECK_KEY = "skip_check";
    public static final String LOGIN_SKIP_FAST_LOGIN = "skip_fast_login";
    public static final int REQ_CODE_LESSONS_MODE_LOGIN = 201;
    public static final int REQ_CODE_TEENAGERS_LOGIN = 200;
    private static final String TAG = "LoginActivity";
    private String mLoginRoute;
    private int mLoginWay;
    private LottieAnimationView mLottieAnimationView;
    private ViewGroup mProgressLayout;
    private String mPromptScene;
    private String mRouterFrom;
    private boolean skipFastLogin = true;
    private int mEntry = 1;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        boolean skipCheck = false;
        Intent i = getIntent();
        if (i != null) {
            skipCheck = Objects.equals(i.getStringExtra("skip_check"), "1");
        }
        if (!skipCheck && BiliAccounts.get(this).isLogin()) {
            ToastHelper.showToastShort(this, R.string.account_global_string_33);
            finish();
            return;
        }
        Activity topActivity = BiliContext.topActivitiy();
        if (topActivity != null && topActivity != this && topActivity.getClass() == getClass()) {
            finish();
            return;
        }
        parseIntent();
        setContentView(com.bilibili.app.accountui.R.layout.bili_app_activity_login);
        this.mLottieAnimationView = findViewById(com.bilibili.app.accountui.R.id.lottie_loading);
        this.mProgressLayout = (ViewGroup) findViewById(com.bilibili.app.accountui.R.id.layout_progress);
        overridePendingTransition(0, 0);
        if (this.mEntry != 2) {
            OnePassLoginPathLinkManager.INSTANCE.onPhase(LoginReportHelper.INSTANCE.getFromSpmid(), OnePassLoginPhaseType.Trigger.INSTANCE);
        }
        if (savedInstanceState == null && TeenagersMode.getInstance().isEnable()) {
            RestrictedMode.intentToLoginInterceptPage(RestrictedType.TEENAGERS, this, 200);
            BLog.i(TAG, "teenager mode is enable, verify first");
        } else if (savedInstanceState == null && RestrictedMode.isLocalEnable(RestrictedType.LESSONS)) {
            RestrictedMode.intentToLoginInterceptPage(RestrictedType.LESSONS, this, 201);
            BLog.i(TAG, "lessons mode is enable, verify first");
        } else {
            handleBiz();
        }
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Window window = getWindow();
        DisplayMetrics dm = getResources().getDisplayMetrics();
        if (dm.widthPixels > dm.heightPixels) {
            window.setFlags(MisakaHelper.MAX_REPORT_SIZE, MisakaHelper.MAX_REPORT_SIZE);
        } else {
            window.setFlags(2048, 2048);
        }
        window.getDecorView().findViewById(16908290).setFitsSystemWindows(true);
        window.setBackgroundDrawable(new ColorDrawable(ColorUtils.setAlphaComponent(getResources().getColor(com.bilibili.lib.theme.R.color.Ba0_u), 102)));
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = -1;
        params.height = -1;
        window.setAttributes(params);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200) {
            if (resultCode == -1) {
                handleBiz();
                return;
            }
            if (this.mEntry != 2) {
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(LoginReportHelper.INSTANCE.getFromSpmid(), OnePassLoginReportManagerKt.INTERRUPTED_FOR_TEENAGER_MODE_LOGIN_INTERCEPTED);
            }
            finish();
        } else if (requestCode == 201) {
            if (resultCode == -1) {
                handleBiz();
                return;
            }
            if (this.mEntry != 2) {
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(LoginReportHelper.INSTANCE.getFromSpmid(), OnePassLoginReportManagerKt.INTERRUPTED_FOR_COURSE_MODE_LOGIN_INTERCEPTED);
            }
            finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Boolean allowRouteToOriginLogin(final boolean enableSms, final boolean enableQuick) {
        if (!TextUtils.isEmpty(this.mLoginRoute)) {
            RouteRequest.Builder request = new RouteRequest.Builder(Uri.parse(this.mLoginRoute)).extras(new Function1() { // from class: tv.danmaku.bili.ui.loginv2.LoginActivityV2$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return LoginActivityV2.this.m1823lambda$allowRouteToOriginLogin$0$tvdanmakubiliuiloginv2LoginActivityV2(enableSms, enableQuick, (MutableBundleLike) obj);
                }
            });
            request.setFlags(33554432);
            BLRouter.routeTo(request.build(), this);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$allowRouteToOriginLogin$0$tv-danmaku-bili-ui-loginv2-LoginActivityV2  reason: not valid java name */
    public /* synthetic */ Unit m1823lambda$allowRouteToOriginLogin$0$tvdanmakubiliuiloginv2LoginActivityV2(boolean enableSms, boolean enableQuick, MutableBundleLike bundleLike) {
        bundleLike.put("smsEnable", String.valueOf(enableSms));
        bundleLike.put("quickEnable", String.valueOf(enableQuick));
        if (getIntent().getExtras() != null) {
            bundleLike.put(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE, getIntent().getExtras());
        }
        if (!TextUtils.isEmpty(this.mPromptScene)) {
            bundleLike.put(LoginOriginalActivityV2.KEY_PROMPT_SCENE, this.mPromptScene);
        }
        if (!TextUtils.isEmpty(this.mRouterFrom)) {
            bundleLike.put(LoginOriginalActivityV2.KEY_ROUTER_FROM, this.mRouterFrom);
            return null;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleBiz() {
        switch (this.mEntry) {
            case 2:
                RouteUtilKt.routeToLoginOriginActivityV2(this, false, false, null, null, this.mPromptScene, this.mRouterFrom);
                BLog.i(TAG, "route to login origin activity because router params force to > " + this.mEntry);
                finish();
                return;
            default:
                OnePassLoginPathLinkManager.INSTANCE.onPhase(LoginReportHelper.INSTANCE.getFromSpmid(), OnePassLoginPhaseType.PrepareRemoteLoginInfo.INSTANCE);
                LoginRuleProcessor.INSTANCE.getLoginType(new InnerGetLoginTypeCallBack(this));
                return;
        }
    }

    private void parseIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mLoginRoute = intent.getStringExtra("loginRoute");
            LoginSceneProcessor.INSTANCE.setScene(intent.getStringExtra("scene"));
            LoginSceneProcessor.INSTANCE.setBiz(intent.getStringExtra(tv.danmaku.bili.quick.core.LoginSceneProcessor.BIZ_KEY));
            if (!TextUtils.isEmpty(this.mLoginRoute)) {
                addShadow();
            }
            this.mEntry = intent.getIntExtra(LOGIN_ENTRY_KEY, 1);
            this.mPromptScene = intent.getStringExtra(LoginOriginalActivityV2.KEY_PROMPT_SCENE);
            this.skipFastLogin = Objects.equals(intent.getStringExtra(LOGIN_SKIP_FAST_LOGIN), "1");
            Bundle routerBundle = intent.getBundleExtra("blrouter.props");
            if (routerBundle != null) {
                this.mRouterFrom = routerBundle.getString("blrouter.from");
            }
            LoginReportHelper.generateValueFromIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RouteWithFinish(int launchMode, TInfoLogin info) {
        RouteWithFinish(launchMode, null, info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void RouteWithFinish(int launchMode, SimpleAccountItem account, TInfoLogin info) {
        Log.i(TAG, "login launchMode " + launchMode);
        switch (launchMode) {
            case 1:
                RouteUtilKt.routeToLoginQuickActivity(this, this.mLoginRoute, true, true, false, this.mPromptScene, this.mRouterFrom, 33554432, getIntent().getExtras());
                break;
            case 2:
                RouteUtilKt.routeToLoginQuickActivity(this, this.mLoginRoute, false, true, false, this.mPromptScene, this.mRouterFrom, 33554432, getIntent().getExtras());
                break;
            case 3:
                RouteUtilKt.routeToLoginQuickActivity(this, this.mLoginRoute, true, true, true, this.mPromptScene, this.mRouterFrom, 33554432, getIntent().getExtras());
                break;
            case 4:
                if (allowRouteToOriginLogin(true, false).booleanValue()) {
                    RouteUtilKt.routeToLoginOriginActivityV2(this, true, false, 33554432, getIntent().getExtras(), this.mPromptScene, this.mRouterFrom, false, (info == null || info.ab == null || !info.ab.isSmsLoginExp()) ? false : true);
                    break;
                }
                break;
            case 5:
                if (allowRouteToOriginLogin(true, true).booleanValue()) {
                    RouteUtilKt.routeToLoginOriginActivityV2(this, true, false, 33554432, getIntent().getExtras(), this.mPromptScene, this.mRouterFrom, false, (info == null || info.ab == null || !info.ab.isSmsLoginExp()) ? false : true);
                    break;
                }
                break;
            case 6:
                if (allowRouteToOriginLogin(false, false).booleanValue()) {
                    RouteUtilKt.routeToLoginOriginActivityV2(this, false, false, 33554432, getIntent().getExtras(), this.mPromptScene, this.mRouterFrom, false, (info == null || info.ab == null || !info.ab.isSmsLoginExp()) ? false : true);
                    break;
                }
                break;
            case 7:
                if (allowRouteToOriginLogin(false, true).booleanValue()) {
                    RouteUtilKt.routeToLoginOriginActivityV2(this, false, false, 33554432, getIntent().getExtras(), this.mPromptScene, this.mRouterFrom, false, (info == null || info.ab == null || !info.ab.isSmsLoginExp()) ? false : true);
                    break;
                }
                break;
            case 8:
                if (allowRouteToOriginLogin(true, false).booleanValue()) {
                    RouteUtilKt.routeToLoginOriginActivityV2(this, true, true, 33554432, getIntent().getExtras(), this.mPromptScene, this.mRouterFrom, false, (info == null || info.ab == null || !info.ab.isSmsLoginExp()) ? false : true);
                    break;
                }
                break;
            case 9:
                if (allowRouteToOriginLogin(true, true).booleanValue()) {
                    RouteUtilKt.routeToLoginOriginActivityV2(this, true, true, 33554432, getIntent().getExtras(), this.mPromptScene, this.mRouterFrom, false, (info == null || info.ab == null || !info.ab.isSmsLoginExp()) ? false : true);
                    break;
                }
                break;
            case 10:
                RouteUtilKt.routeFastReLoginDialog(this, this.mPromptScene, this.mRouterFrom, getIntent().getExtras(), false, account);
                break;
            default:
                if (allowRouteToOriginLogin(true, false).booleanValue()) {
                    RouteUtilKt.routeToLoginOriginActivityV2(this, true, false, 33554432, getIntent().getExtras(), this.mPromptScene, this.mRouterFrom, false, (info == null || info.ab == null || !info.ab.isSmsLoginExp()) ? false : true);
                    break;
                }
                break;
        }
        hideProgress();
        finish();
    }

    private void addShadow() {
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(ColorUtils.setAlphaComponent(getResources().getColor(com.bilibili.lib.theme.R.color.Ba0_u), 102)));
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = -1;
        params.height = -1;
        window.setAttributes(params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgress() {
        if (this.mProgressLayout != null) {
            this.mProgressLayout.setVisibility(0);
        }
        if (this.mLottieAnimationView != null && !this.mLottieAnimationView.isAnimating()) {
            this.mLottieAnimationView.playAnimation();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mLottieAnimationView != null) {
            this.mLottieAnimationView.cancelAnimation();
        }
    }

    private void hideProgress() {
        if (this.mProgressLayout != null) {
            this.mProgressLayout.setVisibility(8);
        }
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, LoginActivityV2.class);
    }

    public String getMiniPlayerContainerKey() {
        return "login_page";
    }

    public Rect getContainerUnavailableRect() {
        return new Rect();
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class LoginInterceptor implements RouteInterceptor {
        public RouteResponse intercept(RouteInterceptor.Chain chain) {
            Context context = chain.getContext();
            boolean skipCheck = Objects.equals(chain.getRequest().getExtras().get("skip_check"), "1");
            if (!skipCheck && BiliAccounts.get(context).isLogin()) {
                ToastHelper.showToastShort(context, R.string.account_global_string_33);
                return new RouteResponse(RouteResponse.Code.ERROR, chain.getRequest(), "already logged");
            }
            return chain.next(chain.getRequest());
        }
    }

    public static boolean isShowToast() {
        return "1".equals(BLRemoteConfig.getInstance().getString("login_refer_toast_show", "0"));
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static class InnerGetPhoneInfoCallBack implements LoginQuickManager.GetPhoneInfoCallBack {
        private TInfoLogin info;
        private WeakReference<LoginActivityV2> mActivityWeakReference;

        public InnerGetPhoneInfoCallBack(LoginActivityV2 activity, TInfoLogin info) {
            this.mActivityWeakReference = new WeakReference<>(activity);
            this.info = info;
        }

        public void startGetPhoneInfo() {
            LoginActivityV2 activity = this.mActivityWeakReference.get();
            if (activity == null) {
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(LoginReportHelper.INSTANCE.getFromSpmid(), OnePassLoginReportManagerKt.INTERRUPTED_FOR_OUT_OF_LIFECYCLE_SCOPE);
                return;
            }
            LoginQualityMonitor.INSTANCE.startMarkSpendTime();
            activity.showProgress();
            BLog.i(LoginActivityV2.TAG, "start get phone info");
        }

        public void endGetPhoneInfo(int result, LoginQuickManager.PhoneInfoBean rep) {
            BLog.i(LoginActivityV2.TAG, "end get phone info");
            LoginActivityV2 activity = this.mActivityWeakReference.get();
            if (activity == null) {
                BLog.i(LoginActivityV2.TAG, "get login type finish because activity ref is null");
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(LoginReportHelper.INSTANCE.getFromSpmid(), OnePassLoginReportManagerKt.INTERRUPTED_FOR_OUT_OF_LIFECYCLE_SCOPE);
                return;
            }
            if (rep != null) {
                LoginQualityMonitor.INSTANCE.report("3", rep.getResultCode(), LoginQualityMonitor.INSTANCE.endMarkSpendTime(), rep.getSecurityPhone());
            } else {
                LoginQualityMonitor.INSTANCE.report("3", LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR, LoginQualityMonitor.INSTANCE.endMarkSpendTime());
            }
            if (rep != null) {
                BLog.i(LoginActivityV2.TAG, "phone info > " + JSON.toJSONString(rep));
            }
            if (result == 1) {
                OnePassLoginPathLinkManager.INSTANCE.onPhase(LoginReportHelper.INSTANCE.getFromSpmid(), OnePassLoginPhaseType.GetNumberSuc.INSTANCE);
                activity.RouteWithFinish(activity.mLoginWay, this.info);
                return;
            }
            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(LoginReportHelper.INSTANCE.getFromSpmid(), "get phone info with error : " + (rep == null ? "" : rep.getMsg()));
            activity.RouteWithFinish(LoginRuleProcessor.INSTANCE.degradeHandle(activity.mLoginWay), this.info);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class InnerGetLoginTypeCallBack implements LoginRuleProcessor.GetLoginTypeCallBack {
        private WeakReference<LoginActivityV2> mActivityWeakReference;

        public InnerGetLoginTypeCallBack(LoginActivityV2 activity) {
            this.mActivityWeakReference = new WeakReference<>(activity);
        }

        @Override // tv.danmaku.bili.quick.core.LoginRuleProcessor.GetLoginTypeCallBack
        public void startGetLoginType() {
            LoginActivityV2 activity = this.mActivityWeakReference.get();
            if (activity == null) {
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(LoginReportHelper.INSTANCE.getFromSpmid(), OnePassLoginReportManagerKt.INTERRUPTED_FOR_OUT_OF_LIFECYCLE_SCOPE);
                return;
            }
            activity.showProgress();
            BLog.i(LoginActivityV2.TAG, "start get login type");
        }

        @Override // tv.danmaku.bili.quick.core.LoginRuleProcessor.GetLoginTypeCallBack
        public void endGetLoginType(int result, final TInfoLogin infoLogin) {
            BLog.i(LoginActivityV2.TAG, "end get login type");
            final FragmentActivity fragmentActivity = (LoginActivityV2) this.mActivityWeakReference.get();
            if (fragmentActivity == null) {
                BLog.i(LoginActivityV2.TAG, "get login type finish because activity ref is null");
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(LoginReportHelper.INSTANCE.getFromSpmid(), OnePassLoginReportManagerKt.INTERRUPTED_FOR_OUT_OF_LIFECYCLE_SCOPE);
                return;
            }
            if (infoLogin != null) {
                BLog.i(LoginActivityV2.TAG, "infoLogin > " + GsonKt.getSGlobalGson().toJson(infoLogin));
            }
            final int loginWay = LoginRuleProcessor.INSTANCE.parseLoginWay(fragmentActivity, infoLogin, ((LoginActivityV2) fragmentActivity).skipFastLogin);
            ((LoginActivityV2) fragmentActivity).mLoginWay = loginWay;
            FastLoginInfo fastLoginInfo = BiliAccounts.get(fragmentActivity).getFastLoginInfo();
            if (loginWay == 10 && fastLoginInfo != null) {
                BLog.i(LoginActivityV2.TAG, "fast re-login, load user info");
                FastLoginUserHelper.INSTANCE.loadUserInfo(fragmentActivity, fastLoginInfo.getMid(), new Function1() { // from class: tv.danmaku.bili.ui.loginv2.LoginActivityV2$InnerGetLoginTypeCallBack$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return LoginActivityV2.InnerGetLoginTypeCallBack.lambda$endGetLoginType$0(LoginActivityV2.this, loginWay, infoLogin, (SimpleAccountItem) obj);
                    }
                });
            } else if (loginWay == 1 || loginWay == 2 || loginWay == 3) {
                LoginQualityMonitor.INSTANCE.report("1", "1");
                final String netTypeString = LoginQuickManager.INSTANCE.getNetType(fragmentActivity);
                OnePassLoginPathLinkManager.INSTANCE.updateData(LoginReportHelper.INSTANCE.getFromSpmid(), new Function1() { // from class: tv.danmaku.bili.ui.loginv2.LoginActivityV2$InnerGetLoginTypeCallBack$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        return LoginActivityV2.InnerGetLoginTypeCallBack.lambda$endGetLoginType$1(netTypeString, fragmentActivity, (OnePassLoginPhoneData) obj);
                    }
                });
                OnePassLoginPathLinkManager.INSTANCE.onPhase(LoginReportHelper.INSTANCE.getFromSpmid(), OnePassLoginPhaseType.CheckConditions.INSTANCE);
                if (infoLogin != null && LoginQuickManager.INSTANCE.isNetOk(netTypeString, infoLogin.login.quick)) {
                    LoginQuickManager.INSTANCE.getPhoneInfo(fragmentActivity, QuickLoginTag.MAIN, new InnerGetPhoneInfoCallBack(fragmentActivity, infoLogin));
                    return;
                }
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(LoginReportHelper.INSTANCE.getFromSpmid(), OnePassLoginReportManagerKt.INTERRUPTED_FOR_OPERATOR_DISALLOW);
                fragmentActivity.RouteWithFinish(LoginRuleProcessor.INSTANCE.degradeHandle(loginWay), infoLogin);
                BLog.i(LoginActivityV2.TAG, "quick login abort because mobile net is not ok");
            } else {
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(LoginReportHelper.INSTANCE.getFromSpmid(), "the login way is not a quick way : " + loginWay);
                LoginQualityMonitor.INSTANCE.report("1", "2");
                BLog.i(LoginActivityV2.TAG, "quick login abort because quick login is not allow");
                fragmentActivity.RouteWithFinish(loginWay, infoLogin);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$endGetLoginType$0(LoginActivityV2 activity, int loginWay, TInfoLogin infoLogin, SimpleAccountItem account) {
            activity.RouteWithFinish(loginWay, account, infoLogin);
            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(LoginReportHelper.INSTANCE.getFromSpmid(), OnePassLoginReportManagerKt.INTERRUPTED_FOR_TRY_FAST_LOGIN);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OnePassLoginPhoneData lambda$endGetLoginType$1(String netTypeString, LoginActivityV2 activity, OnePassLoginPhoneData data) {
            return new OnePassLoginPhoneData(netTypeString, PhoneUtils.getOriginSimOperator(activity) != null, PhoneUtils.isPad(activity));
        }
    }
}