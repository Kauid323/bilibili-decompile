package tv.danmaku.bili.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.ActivityCompat$;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.droid.ToastHelper;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import com.bilibili.lib.accountsui.quick.QuickLoginTag;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.pvtracker.IPvTracker;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.R;
import tv.danmaku.bili.normal.ui.RouteUtilKt;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;
import tv.danmaku.bili.reg.LoginRegHelper;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.ui.AccountReportHelper;
import tv.danmaku.bili.ui.account.registerfast.RegisterActivityTrigger;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.login.LoginEnterLayout;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2;
import tv.danmaku.bili.ui.loginv2.LoginOriginalActivityV2;

public class PlayerLoginFragmentV2 extends BaseLoginFragmentV2 implements View.OnClickListener, LoginEnterLayout.OnItemClickListener, IPvTracker {
    public static final String INTENT_KEY_QUICK_ENABLE = "quickEnable";
    public static final String INTENT_KEY_SMS_ENABLE = "smsEnable";
    private static final int REQ_CODE_LOGIN_SMS = 10001;
    public static final String TAG = "PlayerLoginFragmentV2";
    private ImageView close;
    private boolean enableQuick;
    private boolean enableSms;
    private boolean goOtherPage = true;
    private ViewGroup mContentLayout;
    private LottieAnimationView mLottieAnimationView;
    private ViewGroup mProgressLayout;
    private String mRouterFrom;
    private String promptScene;

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(Object activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
            Thread thread = Thread.currentThread();
            if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                IllegalStateException exp = new IllegalStateException("Activity.finish() called from non-UI thread: " + thread + ", 请联系 Jackin");
                BLog.e("BgThreadUIAccess", "Activity.finish() called from non-UI thread: " + thread, exp);
                Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new ActivityCompat$.ExternalSyntheticLambda0());
                if (BuildConfig.DEBUG) {
                    throw exp;
                }
            }
        }
        ((Activity) activity).finish();
    }

    public static PlayerLoginFragmentV2 newInstance(boolean enableSms, boolean enableQuick, String promptScene, String routerFrom) {
        PlayerLoginFragmentV2 fragment = new PlayerLoginFragmentV2();
        Bundle args = new Bundle();
        args.putBoolean("smsEnable", enableSms);
        args.putBoolean("quickEnable", enableQuick);
        args.putString(LoginOriginalActivityV2.KEY_PROMPT_SCENE, promptScene);
        args.putString(LoginOriginalActivityV2.KEY_ROUTER_FROM, routerFrom);
        fragment.setArguments(args);
        return fragment;
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.enableSms = getArguments().getBoolean("smsEnable", false);
        this.enableQuick = getArguments().getBoolean("quickEnable", false);
        this.promptScene = getArguments().getString(LoginOriginalActivityV2.KEY_PROMPT_SCENE);
        this.mRouterFrom = getArguments().getString(LoginOriginalActivityV2.KEY_ROUTER_FROM);
        setPromptScene(this.promptScene);
        BLog.i(TAG, "onCreate enableSms = " + this.enableSms + ", enableQuick = " + this.enableQuick);
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    public void onClickRegister() {
        Activity activity = ContextUtilKt.findActivityOrNull(getContext());
        if (activity instanceof PlayerLoginActivityV2) {
            ((PlayerLoginActivityV2) activity).finish();
        }
        super.onClickRegister();
        RegisterActivityTrigger.launchRegisterV2(getActivity(), true, !this.enableSms, this.promptScene, this.mRouterFrom);
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    protected View onCreateLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bili_app_fragmant_player_login, container, false);
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.close = (ImageView) view.findViewById(R.id.close);
        TextView textView = (TextView) view.findViewById(R.id.username);
        TextView textView2 = (TextView) view.findViewById(R.id.userpwd);
        this.mLottieAnimationView = view.findViewById(R.id.lottie_loading);
        this.mContentLayout = (ViewGroup) view.findViewById(R.id.layout_content);
        this.mProgressLayout = (ViewGroup) view.findViewById(R.id.layout_progress);
        this.close.setOnClickListener(this);
        LoginEnterLayout loginEnterLayout = (LoginEnterLayout) view.findViewById(R.id.layout_login_enter);
        loginEnterLayout.setOnItemClickListener(this);
        loginEnterLayout.update(this.enableQuick, this.enableSms);
        AccountReportHelper.report(AccountReportHelper.Event.obtainShow(AccountReportHelper.EventID.LOGIN_SHOW));
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    protected void reportClickLogin() {
        Map<String, String> map = LoginReporterV2.generateSingleParamMaps(LoginReporterV2.PAGE_FROM_KEY, "2");
        LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_LOGIN_0_CLICK, LoginRegHelper.getClickReportInfoValue(LoginRegHelper.getProvisionReportValue(getContext()), LoginRegHelper.getAgreeReportValue(this.mLoginRegCheckBox), map));
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    protected void onItemLinkClickAgreement() {
        super.onItemLinkClickAgreement();
        LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_PACT_AGREEMENT_CLICK, LoginReporterV2.generateSingleParamMaps(LoginReporterV2.PAGE_FROM_KEY, "2"));
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    protected void onItemLinkClickPrivacy() {
        super.onItemLinkClickPrivacy();
        LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_PACT_PRIVACY_CLICK, LoginReporterV2.generateSingleParamMaps(LoginReporterV2.PAGE_FROM_KEY, "2"));
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    public void onFocusChange(View v, boolean hasFocus) {
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    public void onResume() {
        super.onResume();
        if (this.goOtherPage && (!this.mAnyRegFlag || !LoginRegHelper.isAnyPageLoginReg())) {
            this.goOtherPage = false;
            LoginRegHelper.updateRegCheckbox(this.mLoginRegCheckBox, this.mLoginRegCheckBoxContainer);
        }
        this.mAnyRegFlag = false;
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    public void onDestroyView() {
        super.onDestroyView();
        this.close.setOnClickListener(null);
        this.close = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.close) {
            getActivity().setResult(0);
            getActivity().finish();
        }
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    protected boolean needSuccessToast() {
        return false;
    }

    public String getPvEventId() {
        return LoginReporterV2.PV.APP_PWD_LOGIN_0_0_PV;
    }

    public Bundle getPvExtra() {
        Bundle bundle = LoginReportHelper.buildCommonBundle();
        bundle.putString(LoginReporterV2.PAGE_FROM_KEY, "2");
        bundle.putString(LoginReporterV2.SHOW_PROVISION_KEY, LoginRegHelper.getProvisionReportValue(getContext()));
        return bundle;
    }

    @Override // tv.danmaku.bili.ui.login.LoginEnterLayout.OnItemClickListener
    public void onClick(int id) {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        switch (id) {
            case 1001:
                LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_SMS_0_CLICK, LoginReporterV2.generateSingleParamMaps(LoginReporterV2.PAGE_FROM_KEY, "2"));
                RouteRequest request = new RouteRequest.Builder("bilibili://login/origin").extras(new Function1() { // from class: tv.danmaku.bili.ui.login.PlayerLoginFragmentV2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return PlayerLoginFragmentV2.this.m1800lambda$onClick$0$tvdanmakubiliuiloginPlayerLoginFragmentV2((MutableBundleLike) obj);
                    }
                }).requestCode((int) REQ_CODE_LOGIN_SMS).build();
                BLRouter.routeTo(request, this);
                this.goOtherPage = true;
                return;
            case 1002:
                LoginQualityMonitor.INSTANCE.report("1", "1");
                TInfoLogin tInfoLogin = LoginRuleProcessor.INSTANCE.getMTInfoLogin();
                BLog.i(TAG, "click quickLogin button tInfoLogin = " + tInfoLogin);
                if (tInfoLogin != null && tInfoLogin.login != null && LoginQuickManager.INSTANCE.isNetOk(activity, tInfoLogin.login.quick)) {
                    LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_ONEPASSLOGIN_0_CLICK);
                    LoginQuickManager.INSTANCE.getPhoneInfo(activity, QuickLoginTag.MAIN, new LoginQuickManager.GetPhoneInfoCallBack() { // from class: tv.danmaku.bili.ui.login.PlayerLoginFragmentV2.1
                        private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(Object activity2) {
                            Intrinsics.checkNotNullParameter(activity2, AudioIntentHelper.FROM_ACTIVITY);
                            if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
                                Thread thread = Thread.currentThread();
                                if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                                    IllegalStateException exp = new IllegalStateException("Activity.finish() called from non-UI thread: " + thread + ", 请联系 Jackin");
                                    BLog.e("BgThreadUIAccess", "Activity.finish() called from non-UI thread: " + thread, exp);
                                    Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new ActivityCompat$.ExternalSyntheticLambda0());
                                    if (BuildConfig.DEBUG) {
                                        throw exp;
                                    }
                                }
                            }
                            ((Activity) activity2).finish();
                        }

                        public void startGetPhoneInfo() {
                            LoginQualityMonitor.INSTANCE.startMarkSpendTime();
                            PlayerLoginFragmentV2.this.showProgress();
                        }

                        public void endGetPhoneInfo(int result, LoginQuickManager.PhoneInfoBean rep) {
                            if (rep != null) {
                                LoginQualityMonitor.INSTANCE.report("3", rep.getResultCode(), LoginQualityMonitor.INSTANCE.endMarkSpendTime(), rep.getSecurityPhone());
                            } else {
                                LoginQualityMonitor.INSTANCE.report("3", LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR, LoginQualityMonitor.INSTANCE.endMarkSpendTime());
                            }
                            BLog.i(PlayerLoginFragmentV2.TAG, "endGetPhoneInfo resultCode = " + result + ",phoneInfo = " + rep);
                            if (result != 1) {
                                PlayerLoginFragmentV2.this.hideProgress(true);
                                ToastHelper.showToastShort(activity, bili.resource.account.R.string.account_global_string_32);
                                return;
                            }
                            PlayerLoginFragmentV2.this.hideProgress(false);
                            RouteUtilKt.routeToLoginQuickActivity(activity, "activity://login/player", Boolean.valueOf(PlayerLoginFragmentV2.this.enableSms), Boolean.valueOf(PlayerLoginFragmentV2.this.enableQuick), null, LoginReporterV2.Click.APP_PWD_LOGIN_ONEPASSLOGIN_0_CLICK, PlayerLoginFragmentV2.this.mRouterFrom, null, null);
                            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
                        }
                    });
                    this.goOtherPage = true;
                    return;
                }
                ToastHelper.showToastShort(activity, bili.resource.account.R.string.account_global_string_32);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onClick$0$tv-danmaku-bili-ui-login-PlayerLoginFragmentV2  reason: not valid java name */
    public /* synthetic */ Unit m1800lambda$onClick$0$tvdanmakubiliuiloginPlayerLoginFragmentV2(MutableBundleLike mutableBundleLike) {
        mutableBundleLike.put(LoginOriginalActivityV2.KEY_SMS_LOGIN_DIRECT, Boolean.TRUE.toString());
        mutableBundleLike.put(LoginOriginalActivityV2.KEY_SMS_LOGIN_ENABLE, Boolean.TRUE.toString());
        mutableBundleLike.put(LoginOriginalActivityV2.KEY_PROMPT_SCENE, this.promptScene);
        mutableBundleLike.put(LoginOriginalActivityV2.KEY_ROUTER_FROM, this.mRouterFrom);
        return null;
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        FragmentActivity activity;
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_LOGIN_SMS /* 10001 */:
                if (resultCode == -1 && (activity = getActivity()) != null) {
                    activity.setResult(-1);
                    __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgress() {
        if (this.mContentLayout != null) {
            this.mContentLayout.setVisibility(8);
        }
        if (this.mProgressLayout != null) {
            this.mProgressLayout.setVisibility(0);
        }
        if (this.mLottieAnimationView != null && !this.mLottieAnimationView.isAnimating()) {
            this.mLottieAnimationView.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress(boolean isVisibleContent) {
        if (this.mContentLayout != null && isVisibleContent) {
            this.mContentLayout.setVisibility(0);
        }
        if (this.mProgressLayout != null) {
            this.mProgressLayout.setVisibility(8);
        }
        if (this.mLottieAnimationView != null && this.mLottieAnimationView.isAnimating()) {
            this.mLottieAnimationView.cancelAnimation();
        }
    }
}