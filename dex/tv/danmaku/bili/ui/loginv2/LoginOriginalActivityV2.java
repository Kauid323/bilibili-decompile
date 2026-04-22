package tv.danmaku.bili.ui.loginv2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bilibili.app.accountui.BuildConfig;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.StringUtil;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.accountsui.captcha.JsBridgeCallHandlerSecure;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.playerbizcommon.miniplayer.IMiniPlayerContainer;
import com.bilibili.pvtracker.IPvTracker;
import java.lang.ref.WeakReference;
import java.util.Map;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.helper.LoginSuccessProcessorKt;
import tv.danmaku.bili.helper.LoginUIType;
import tv.danmaku.bili.normal.ui.RouteUtilKt;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;
import tv.danmaku.bili.ui.AccountReportHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2;

public class LoginOriginalActivityV2 extends Hilt_LoginOriginalActivityV2 implements PassportObserver, JsBridgeCallHandlerSecure.CaptchaCallback, IPvTracker, IMiniPlayerContainer {
    public static boolean GO_OTHER_PAGE_FLAG = true;
    public static final String KEY_LOGIN_EXPERIMENT = "login_experiment";
    public static final String KEY_LOGIN_EXPERIMENT_VALUE = "login_experiment_value";
    public static final String KEY_PROMPT_SCENE = "key_prompt_scene";
    public static final String KEY_ROUTER_FROM = "router_from";
    public static final String KEY_SMS_EXP = "sms_login_exp";
    public static final String KEY_SMS_LOGIN_DIRECT = "key_sms_login_direct";
    public static final String KEY_SMS_LOGIN_ENABLE = "key_sms_login_enable";
    public static final String KEY_TOAST = "key_toast";
    private static final String PV_EVENT_ID = "app.login.0.0.pv";
    private static final String TAG = "LoginOriginalActivityV2";
    public Fragment fragment;
    private GetLoginTypeCallback getLoginTypeCallback;
    private boolean loginExperiment;
    private String loginExperimentValue;
    private String mPromptScene;
    private boolean smsLoginExp;
    private boolean smsLoginModeEnable;
    private boolean mObsPassportEnable = false;
    private boolean directToSmsLogin = false;
    private String toast = null;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tv.danmaku.bili.ui.loginv2.Hilt_LoginOriginalActivityV2
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!BuildConfig.DEBUG) {
            getWindow().addFlags(8192);
        }
        setContentView(R.layout.bili_app_activity_with_toolbar);
        ensureToolbar();
        showBackButton();
        setTitle(getString(bili.resource.account.R.string.account_global_string_17));
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.smsLoginModeEnable = BundleUtil.getBoolean(intent.getExtras(), KEY_SMS_LOGIN_ENABLE, new boolean[]{false});
                this.directToSmsLogin = BundleUtil.getBoolean(intent.getExtras(), KEY_SMS_LOGIN_DIRECT, new boolean[]{this.smsLoginModeEnable});
                this.mPromptScene = BundleUtil.getString(intent.getExtras(), KEY_PROMPT_SCENE, new String[0]);
                this.loginExperiment = BundleUtil.getBoolean(intent.getExtras(), KEY_LOGIN_EXPERIMENT, new boolean[]{false});
                this.loginExperimentValue = BundleUtil.getString(intent.getExtras(), KEY_LOGIN_EXPERIMENT_VALUE, new String[0]);
                this.smsLoginExp = BundleUtil.getBoolean(intent.getExtras(), KEY_SMS_EXP, new boolean[0]);
                if (LoginActivityV2.isShowToast()) {
                    this.toast = intent.getStringExtra(KEY_TOAST);
                }
            }
            BLog.i(TAG, "onCreate smsLoginModeEnable = " + this.smsLoginModeEnable + " ,directToSmsLogin = " + this.directToSmsLogin);
            if (this.smsLoginModeEnable && this.directToSmsLogin && !this.smsLoginExp) {
                this.getLoginTypeCallback = new GetLoginTypeCallback(this);
                LoginRuleProcessor.INSTANCE.getLoginType(this.getLoginTypeCallback);
            } else {
                jumpFragment(this.directToSmsLogin ? SmsLoginFragmentV2.TAG : LoginFragmentV2.TAG, this.toast);
            }
        } else {
            this.fragment = getSupportFragmentManager().findFragmentById(R.id.content_layout);
        }
        AccountReportHelper.report(AccountReportHelper.Event.obtainShow(AccountReportHelper.EventID.LOGIN_SHOW));
        BiliAccounts.get(this).subscribe(this, new Topic[]{Topic.ACCOUNT_INFO_UPDATE, Topic.SIGN_IN});
        LoginSuccessProcessorKt.onLoginPageEnter(this, getApplication(), this.directToSmsLogin ? LoginUIType.SMS : LoginUIType.PWD);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tv.danmaku.bili.ui.loginv2.Hilt_LoginOriginalActivityV2
    protected void onDestroy() {
        super.onDestroy();
        BiliAccounts.get(this).unsubscribeAll(this);
        LoginSuccessProcessorKt.onLoginPageExit(this, getApplication(), LoginUIType.UNKNOWN);
    }

    protected int getUserSceneTagId() {
        return 31205;
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        findViewById(R.id.activity_root).setFitsSystemWindows(true);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 66 && this.fragment != null) {
            if (this.fragment instanceof LoginFragmentV2) {
                this.fragment.onPressEnterKey();
                return true;
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onBackPressed() {
        finish();
    }

    public void replyWithGeeCaptcha(Map<String, String> innerMap) {
        if (this.fragment == null) {
            return;
        }
        BLog.i(TAG, "replyWithGeeCaptcha fragment is " + this.fragment.getClass().getSimpleName());
        if (this.fragment instanceof LoginFragmentV2) {
            this.fragment.replyWithGeeCaptcha(innerMap);
        } else if (this.fragment instanceof SmsLoginFragmentV2) {
            this.fragment.sendSmsWithGeeCaptcha(innerMap);
        }
    }

    public void closeCaptchaDialog() {
        if (this.fragment == null) {
            return;
        }
        BLog.i(TAG, "closeCaptchaDialog fragment is " + this.fragment.getClass().getSimpleName());
        if (this.fragment instanceof LoginFragmentV2) {
            this.fragment.closeCaptchaDialog();
        } else if (this.fragment instanceof SmsLoginFragmentV2) {
            this.fragment.hideCaptchaDialog();
            LoginReporterV2.Click.report(LoginReporterV2.Click.APP_SMS_LOGIN_VERIFICATION_CLOSE_CLICK);
        }
    }

    public void replyWithImageCaptcha(int callbackId, Map<String, String> param) {
        if (this.fragment == null) {
            return;
        }
        BLog.i(TAG, "replyWithImageCaptcha fragment is " + this.fragment.getClass().getSimpleName());
        if (this.fragment instanceof LoginFragmentV2) {
            this.fragment.replyWithImageCaptcha(callbackId, param);
        } else if (this.fragment instanceof SmsLoginFragmentV2) {
            this.fragment.sendSmsWithImageCaptcha(callbackId, param);
        }
    }

    public String getPvEventId() {
        return PV_EVENT_ID;
    }

    public Bundle getPvExtra() {
        return null;
    }

    public void onChange(Topic topic) {
        if (this.mObsPassportEnable && topic == Topic.ACCOUNT_INFO_UPDATE) {
            setResult(-1);
            finish();
        }
        if (topic == Topic.SIGN_IN) {
            if (ConfigManager.isHitFF("ff_login_finish_if_not_resumed")) {
                if (!getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                    finish();
                }
            } else if (BiliContext.topActivitiy() != this) {
                finish();
            }
        }
    }

    public String getMiniPlayerContainerKey() {
        return "login_page";
    }

    public Rect getContainerUnavailableRect() {
        return new Rect();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void jumpFragment(String tag, String toast) {
        this.getLoginTypeCallback = null;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (SmsLoginFragmentV2.TAG.equals(tag)) {
            if (!this.smsLoginExp) {
                this.fragment = getSupportFragmentManager().findFragmentByTag(SmsLoginFragmentV2.TAG);
                if (this.fragment == null) {
                    this.fragment = SmsLoginFragmentV2.newInstance(this.mPromptScene);
                    this.fragment.setArguments(attachToastBundle(this.fragment.getArguments(), toast));
                    if (this.loginExperiment) {
                        Bundle bundle = this.fragment.getArguments();
                        bundle.putString(KEY_LOGIN_EXPERIMENT, String.valueOf(this.loginExperiment));
                        bundle.putString(KEY_LOGIN_EXPERIMENT_VALUE, this.loginExperimentValue);
                        this.fragment.setArguments(bundle);
                    }
                    transaction.addToBackStack((String) null);
                }
            } else {
                RouteUtilKt.routeToLoginOriginActivityV2(this, true, true, null, getIntent().getExtras(), this.mPromptScene, null, Boolean.valueOf(this.loginExperiment), this.smsLoginExp);
                finish();
                return;
            }
        } else if (LoginFragmentV2.TAG.equals(tag)) {
            this.fragment = getSupportFragmentManager().findFragmentByTag(LoginFragmentV2.TAG);
            if (this.fragment == null) {
                this.fragment = LoginFragmentV2.newInstance(!this.smsLoginModeEnable, this.mPromptScene);
                this.fragment.setArguments(attachToastBundle(this.fragment.getArguments(), toast));
                if (this.loginExperiment) {
                    Bundle bundle2 = this.fragment.getArguments();
                    bundle2.putString(KEY_LOGIN_EXPERIMENT, String.valueOf(this.loginExperiment));
                    bundle2.putString(KEY_LOGIN_EXPERIMENT_VALUE, this.loginExperimentValue);
                    this.fragment.setArguments(bundle2);
                }
                transaction.addToBackStack((String) null);
            }
        } else {
            return;
        }
        GO_OTHER_PAGE_FLAG = true;
        transaction.replace(R.id.content_layout, this.fragment, tag);
        transaction.commitAllowingStateLoss();
    }

    public void setObsPassportEnable(boolean enable) {
        this.mObsPassportEnable = enable;
    }

    public void setTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    public void jumpFragment(String tag) {
        jumpFragment(tag, null);
    }

    private Bundle attachToastBundle(Bundle bundle, String toast) {
        if (StringUtil.isBlank(toast)) {
            return bundle;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(KEY_TOAST, toast);
        return bundle;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        BLog.i(TAG, "onActivityResult requestCode = " + requestCode + " , resultCode = " + resultCode);
        super.onActivityResult(requestCode, resultCode, data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class GetLoginTypeCallback implements LoginRuleProcessor.GetLoginTypeCallBack {
        private final WeakReference<LoginOriginalActivityV2> weakReference;

        @Override // tv.danmaku.bili.quick.core.LoginRuleProcessor.GetLoginTypeCallBack
        public /* synthetic */ void startGetLoginType() {
            LoginRuleProcessor.GetLoginTypeCallBack.CC.$default$startGetLoginType(this);
        }

        public GetLoginTypeCallback(LoginOriginalActivityV2 activityV2) {
            this.weakReference = new WeakReference<>(activityV2);
        }

        @Override // tv.danmaku.bili.quick.core.LoginRuleProcessor.GetLoginTypeCallBack
        public void endGetLoginType(int result, TInfoLogin infoLogin) {
            LoginOriginalActivityV2 activityV2 = this.weakReference.get();
            boolean smsLoginModeEnable = activityV2.smsLoginModeEnable;
            boolean directToSmsLogin = activityV2.directToSmsLogin;
            String str = SmsLoginFragmentV2.TAG;
            if (smsLoginModeEnable && directToSmsLogin && infoLogin != null && infoLogin.ab != null && infoLogin.ab.isSmsLoginExp()) {
                activityV2.smsLoginExp = true;
                activityV2.jumpFragment(SmsLoginFragmentV2.TAG, activityV2.toast);
                return;
            }
            if (!directToSmsLogin) {
                str = LoginFragmentV2.TAG;
            }
            activityV2.jumpFragment(str, activityV2.toast);
        }
    }
}