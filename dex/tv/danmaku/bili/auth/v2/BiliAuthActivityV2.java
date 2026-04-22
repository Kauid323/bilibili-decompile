package tv.danmaku.bili.auth.v2;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.okretro.BiliApiDataCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.api.BiliAuthServiceHelper;
import tv.danmaku.bili.api.bean.ApplyStatusBean;
import tv.danmaku.bili.auth.BiliAuthConstants;
import tv.danmaku.bili.auth.BiliAuthStatus;
import tv.danmaku.bili.auth.BiliAuthTransferActivity;
import tv.danmaku.bili.auth.helper.AuthToastHelper;
import tv.danmaku.bili.auth.helper.RouterHelper;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.cb.AuthResultCbMsg;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: BiliAuthActivityV2.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\"\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0011H\u0002J$\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0007J\u000e\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Ltv/danmaku/bili/auth/v2/BiliAuthActivityV2;", "Lcom/bilibili/lib/ui/BaseToolbarActivity;", "<init>", "()V", "ageInfo", "", "mTempCode", "", "mAuthCode", "mSourceEvent", "mAuthStatus", "Ltv/danmaku/bili/auth/BiliAuthStatus;", "mAuthToastHelper", "Ltv/danmaku/bili/auth/helper/AuthToastHelper;", "mRouteHelper", "Ltv/danmaku/bili/auth/helper/RouterHelper;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "requestStatus", "showFragment", "status", "bundle", "pre", "Landroidx/fragment/app/Fragment;", "onBackPressed", "setAuthStatus", "requestId", "successForLogin", "authCode", "finishWithCallBack", "authResultCbMsg", "Ltv/danmaku/bili/cb/AuthResultCbMsg;", "sourceEvent", "moveToFrontIfNeed", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthActivityV2 extends BaseToolbarActivity {
    public static final String BUNDLE_KEY_CARD = "key_card";
    public static final String BUNDLE_KEY_ERROR_CODE = "key_error_code";
    public static final String BUNDLE_KEY_FAIL_MSG = "key_fail_msg";
    public static final String BUNDLE_KEY_REAL_NAME = "key_real_name";
    public static final Companion Companion = new Companion(null);
    public static final int REQUEST_CODE_AUTH_H5 = 301;
    public static final int REQUEST_CODE_GUARDIAN_BIND = 302;
    public static final int REQUEST_CODE_SDK = 203;
    private static final String TAG = "BiliAuthActivityV2";
    private static final String URL_FRAGMENT_AUDITING = "bilibili://auth/auth/v2-auditing";
    private static final String URL_FRAGMENT_NOT_PASSED = "bilibili://auth/auth/v2-notpassed";
    private static final String URL_FRAGMENT_NO_AUTH = "bilibili://auth/auth/v2-noauth";
    private static final String URL_FRAGMENT_OVERRIDE_1 = "bilibili://auth/auth/v2-override_step1";
    private static final String URL_FRAGMENT_OVERRIDE_2 = "bilibili://auth/auth/v2-override_step2";
    private static final String URL_FRAGMENT_PASSED = "bilibili://auth/auth/v2-passed";
    public static final String mBundleKey = "bundle_key_auth";
    private int ageInfo;
    private AuthToastHelper mAuthToastHelper;
    private RouterHelper mRouteHelper;
    private String mTempCode = "";
    private String mAuthCode = "";
    private String mSourceEvent = "";
    private BiliAuthStatus mAuthStatus = new BiliAuthStatus();

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: BiliAuthActivityV2.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/auth/v2/BiliAuthActivityV2$Companion;", "", "<init>", "()V", "TAG", "", "URL_FRAGMENT_PASSED", "URL_FRAGMENT_NOT_PASSED", "URL_FRAGMENT_NO_AUTH", "URL_FRAGMENT_AUDITING", "URL_FRAGMENT_OVERRIDE_1", "URL_FRAGMENT_OVERRIDE_2", "REQUEST_CODE_AUTH_H5", "", "REQUEST_CODE_GUARDIAN_BIND", "REQUEST_CODE_SDK", "BUNDLE_KEY_REAL_NAME", "BUNDLE_KEY_CARD", "BUNDLE_KEY_FAIL_MSG", "BUNDLE_KEY_ERROR_CODE", "mBundleKey", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_activity_with_toolbar);
        ensureToolbar();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(bili.resource.account.R.string.account_global_string_285);
        }
        showBackButton();
        this.mAuthToastHelper = new AuthToastHelper((BaseAppCompatActivity) this);
        this.mRouteHelper = new RouterHelper((BaseAppCompatActivity) this, mBundleKey);
        String stringExtra = getIntent().getStringExtra(BiliAuthConstants.BUNDLE_KEY_SOURCE_EVENT);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mSourceEvent = stringExtra;
        String stringExtra2 = getIntent().getStringExtra(BiliAuthConstants.BUNDLE_KEY_TEMP_CODE);
        this.mTempCode = stringExtra2 != null ? stringExtra2 : "";
        requestStatus();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        BLog.i(TAG, "onActivityResult requestCode = " + requestCode);
        if (data != null) {
            this.ageInfo = data.getIntExtra(BiliAuthTransferActivity.KEY_AGE_INFO, 0);
        }
    }

    private final void requestStatus() {
        AuthToastHelper authToastHelper = this.mAuthToastHelper;
        if (authToastHelper != null) {
            AuthToastHelper.showLoading$default(authToastHelper, null, 1, null);
        }
        BiliAuthServiceHelper.getBiliPassportServiceHelper().getAuthApplyStatus(BiliAccounts.get((Context) this).getAccessKey(), this.mTempCode, new BiliApiDataCallback<ApplyStatusBean>() { // from class: tv.danmaku.bili.auth.v2.BiliAuthActivityV2$requestStatus$1
            public void onDataSuccess(ApplyStatusBean data) {
                AuthToastHelper authToastHelper2;
                String str;
                String str2;
                authToastHelper2 = BiliAuthActivityV2.this.mAuthToastHelper;
                if (authToastHelper2 != null) {
                    authToastHelper2.dismissLoading();
                }
                if (data == null) {
                    onError(null);
                    return;
                }
                Bundle params = new Bundle();
                BiliAuthActivityV2 biliAuthActivityV2 = BiliAuthActivityV2.this;
                params.putString("key_real_name", data.realname);
                params.putString("key_card", data.card);
                str = biliAuthActivityV2.mTempCode;
                params.putString(BiliAuthConstants.BUNDLE_KEY_TEMP_CODE, str);
                str2 = biliAuthActivityV2.mSourceEvent;
                params.putString(BiliAuthConstants.BUNDLE_KEY_SOURCE_EVENT, str2);
                if (data.status == 2) {
                    data.status = 3;
                }
                BiliAuthActivityV2.showFragment$default(BiliAuthActivityV2.this, data.status, params, null, 4, null);
            }

            public void onError(Throwable t) {
                AuthToastHelper authToastHelper2;
                authToastHelper2 = BiliAuthActivityV2.this.mAuthToastHelper;
                if (authToastHelper2 != null) {
                    authToastHelper2.dismissLoading();
                }
                Intent intent = new Intent();
                intent.putExtra(BiliAuthConstants.AUTH_KEY_DEGRADE, 1);
                BiliAuthActivityV2.this.setResult(-1, intent);
                BiliAuthActivityV2.this.finish();
            }
        });
    }

    public static /* synthetic */ void showFragment$default(BiliAuthActivityV2 biliAuthActivityV2, int i, Bundle bundle, Fragment fragment, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            fragment = null;
        }
        biliAuthActivityV2.showFragment(i, bundle, fragment);
    }

    public final void showFragment(int status, Bundle bundle, Fragment pre) {
        switch (status) {
            case 0:
                RouterHelper routerHelper = this.mRouteHelper;
                if (routerHelper != null) {
                    RouterHelper.showFragmentWithBundle$default(routerHelper, (Context) this, bundle, null, URL_FRAGMENT_AUDITING, null, 16, null);
                    return;
                }
                return;
            case 1:
                RouterHelper routerHelper2 = this.mRouteHelper;
                if (routerHelper2 != null) {
                    RouterHelper.showFragmentWithBundle$default(routerHelper2, (Context) this, bundle, null, URL_FRAGMENT_PASSED, null, 16, null);
                    return;
                }
                return;
            case 2:
                RouterHelper routerHelper3 = this.mRouteHelper;
                if (routerHelper3 != null) {
                    RouterHelper.showFragmentWithBundle$default(routerHelper3, (Context) this, bundle, null, URL_FRAGMENT_NOT_PASSED, null, 16, null);
                    return;
                }
                return;
            case 3:
                RouterHelper routerHelper4 = this.mRouteHelper;
                if (routerHelper4 != null) {
                    RouterHelper.showFragmentWithBundle$default(routerHelper4, (Context) this, bundle, null, URL_FRAGMENT_NO_AUTH, null, 16, null);
                    return;
                }
                return;
            case 4:
                RouterHelper routerHelper5 = this.mRouteHelper;
                if (routerHelper5 != null) {
                    routerHelper5.showFragmentWithBundle((Context) this, bundle, pre, URL_FRAGMENT_OVERRIDE_1, BiliOverrideStep1Fragment.TAG);
                    return;
                }
                return;
            case 5:
                RouterHelper routerHelper6 = this.mRouteHelper;
                if (routerHelper6 != null) {
                    routerHelper6.showFragmentWithBundle((Context) this, bundle, pre, URL_FRAGMENT_OVERRIDE_2, BiliOverrideStep2Fragment.TAG);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(fragmentManager, "getSupportFragmentManager(...)");
        int fragmentCount = fragmentManager.getBackStackEntryCount();
        boolean needPopBackStack = this.mAuthStatus.getCurrentStatus() == 4 || this.mAuthStatus.getCurrentStatus() == 5;
        if (needPopBackStack && fragmentCount > 1) {
            fragmentManager.popBackStack();
            return;
        }
        switch (this.mAuthStatus.getCurrentStatus()) {
            case 0:
                AuthResultCbHelper.setResultToActivity((Activity) this, 2);
                break;
            case 1:
                AuthResultCbHelper.setResultToActivity((Activity) this, 1, this.ageInfo, this.mAuthCode, this.mAuthStatus.getRequestId());
                break;
            case 2:
                AuthResultCbMsg msg = new AuthResultCbMsg(0, this.mAuthStatus.getCurrentFailMsg(), this.mAuthStatus.getCurrentErrorCode());
                AuthResultCbHelper.setResultToActivity((Activity) this, msg);
                break;
            case 3:
                AuthResultCbHelper.setResultToActivity((Activity) this, -1);
                break;
            case 4:
                AuthResultCbHelper.setResultToActivity((Activity) this, -1);
                break;
            case 5:
                AuthResultCbHelper.setResultToActivity((Activity) this, -1);
                break;
        }
        super.onBackPressed();
    }

    public final void setAuthStatus(int status, String requestId) {
        this.mAuthStatus.setCurrentStatus(status);
        this.mAuthStatus.setRequestId(requestId == null ? "" : requestId);
    }

    public final void successForLogin(String authCode, String requestId) {
        Intrinsics.checkNotNullParameter(authCode, "authCode");
        this.mAuthCode = authCode;
        AuthResultCbHelper.setResultToActivity((Activity) this, 1, this.ageInfo, this.mAuthCode, requestId == null ? "" : requestId);
        finish();
    }

    public final void finishWithCallBack(AuthResultCbMsg authResultCbMsg) {
        Intrinsics.checkNotNullParameter(authResultCbMsg, "authResultCbMsg");
        AuthToastHelper authToastHelper = this.mAuthToastHelper;
        if (authToastHelper != null) {
            authToastHelper.dismissLoading();
        }
        Intent intent = new Intent();
        intent.putExtra(AuthResultCbHelper.ARGS_CBM, authResultCbMsg);
        setResult(-1, intent);
        finish();
    }

    public final String sourceEvent() {
        return this.mSourceEvent;
    }

    public final void moveToFrontIfNeed() {
        String name;
        String customTask = getIntent().getStringExtra(BiliAuthConstants.BUNDLE_CUSTOM_TASK);
        String str = "";
        if (customTask == null) {
            customTask = "";
        }
        if (Intrinsics.areEqual(customTask, "1")) {
            String taskActivityName = getIntent().getStringExtra(BiliAuthConstants.BUNDLE_TASK_NAME);
            if (taskActivityName == null) {
                taskActivityName = "";
            }
            if (taskActivityName.length() > 0) {
                Object systemService = getSystemService(AudioIntentHelper.FROM_ACTIVITY);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                ActivityManager activityManager = (ActivityManager) systemService;
                Iterable tasks = activityManager.getAppTasks();
                Intrinsics.checkNotNull(tasks);
                Iterable $this$forEach$iv = tasks;
                for (Object element$iv : $this$forEach$iv) {
                    ActivityManager.AppTask it = (ActivityManager.AppTask) element$iv;
                    Intent intent = it.getTaskInfo().baseIntent;
                    Intrinsics.checkNotNullExpressionValue(intent, "baseIntent");
                    ComponentName component = intent.getComponent();
                    if (component == null || (name = component.getClassName()) == null) {
                        name = str;
                    }
                    String customTask2 = customTask;
                    String str2 = str;
                    String taskActivityName2 = taskActivityName;
                    if (StringsKt.contains$default(name, taskActivityName, false, 2, (Object) null)) {
                        it.moveToFront();
                    }
                    customTask = customTask2;
                    str = str2;
                    taskActivityName = taskActivityName2;
                }
            }
        }
    }
}