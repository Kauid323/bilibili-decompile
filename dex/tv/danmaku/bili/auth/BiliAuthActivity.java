package tv.danmaku.bili.auth;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.okretro.BiliApiDataCallback;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.api.BiliAuthServiceHelper;
import tv.danmaku.bili.api.bean.ApplyStatusBean;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.cb.AuthResultCbMsg;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;
import tv.danmaku.bili.widget.dialog.CustomButtonInfo;

/* compiled from: BiliAuthActivity.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 J2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\"\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0017H\u0002J$\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$J*\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\b\u0010+\u001a\u00020\u0017H\u0016J\u0006\u0010,\u001a\u00020\u0007J\b\u0010-\u001a\u00020\u0017H\u0002J\u0006\u0010.\u001a\u00020\u0017J\u000e\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020\u0017J\u0006\u00105\u001a\u00020\u0017J\u0018\u00106\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00132\b\u00107\u001a\u0004\u0018\u00010\u0007J\u0018\u00108\u001a\u00020\u00172\b\u00109\u001a\u0004\u0018\u00010\u00072\u0006\u0010:\u001a\u00020\u0013J\u0016\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0007J\u001a\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070?2\u0006\u0010@\u001a\u00020'J\u0018\u0010A\u001a\u00020\u00172\u0006\u0010B\u001a\u00020\u00072\b\u00107\u001a\u0004\u0018\u00010\u0007J\u0012\u0010C\u001a\u00020'2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u001a\u0010F\u001a\u00020'2\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010I\u001a\u00020\u0017H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthActivity;", "Lcom/bilibili/lib/ui/BaseToolbarActivity;", "<init>", "()V", "mProgressDialog", "Lcom/bilibili/magicasakura/widgets/TintProgressDialog;", "mSourceEvent", "", "mAuthFragment", "Ltv/danmaku/bili/auth/BiliAuthFragment;", "mAuthingFragment", "Ltv/danmaku/bili/auth/BiliAuthingFragment;", "mAuthFailedFragment", "Ltv/danmaku/bili/auth/BiliAuthFailedFragment;", "mAuthPassedFragment", "Ltv/danmaku/bili/auth/BiliAuthPassedFragment;", "mAuthStatus", "Ltv/danmaku/bili/auth/BiliAuthStatus;", "ageInfo", "", "mTempCode", "mAuthCode", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "requestStatus", "toFragment", "status", "bundle", "pre", "Landroidx/fragment/app/Fragment;", "showFragment", "isAdd", "", "fragment", "Ltv/danmaku/bili/auth/BaseAuthFragment;", AppConfig.HOST_TAG, "onBackPressed", "sourceEvent", "exit", "moveToFrontIfNeed", "finishWithCallBack", "authResultCbMsg", "Ltv/danmaku/bili/cb/AuthResultCbMsg;", "showLoading", "loadingRunnable", "Ljava/lang/Runnable;", "dismissLoading", "setAuthStatus", "requestId", "setErrorMsg", AuthResultCbHelper.ARGS_MSG, "errorCode", "setCurrentUserInfo", ChannelRoutes.CHANNEL_NAME, LoginReporterV2.Show.SIGNUP_KEY_CODE, "getUserInfo", "Lkotlin/Pair;", "private", "successForLogin", "authCode", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "clearFocusIfNeed", "view", "Landroid/view/View;", "editTxLostFocus", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthActivity extends BaseToolbarActivity {
    public static final String BUNDLE_KEY_CARD = "key_card";
    public static final String BUNDLE_KEY_ERROR_CODE = "key_error_code";
    public static final String BUNDLE_KEY_FAIL_MSG = "key_fail_msg";
    public static final String BUNDLE_KEY_OVERRIDE_MID = "key_override_mid";
    public static final String BUNDLE_KEY_OVERRIDE_SUMMARY = "key_override_summary";
    public static final String BUNDLE_KEY_REAL_NAME = "key_real_name";
    public static final String BUNDLE_KEY_REQUEST_ID = "key_reuqest_id";
    public static final Companion Companion = new Companion(null);
    public static final int PERMISSION_REQUEST_CODE = 5000;
    public static final int REQUEST_CODE_AUTH_H5 = 301;
    public static final int REQUEST_CODE_GUARDIAN_BIND = 302;
    public static final int REQUEST_CODE_SDK = 203;
    private static final String TAG = "BiliAuthActivity:";
    private int ageInfo;
    private BiliAuthFailedFragment mAuthFailedFragment;
    private BiliAuthFragment mAuthFragment;
    private BiliAuthPassedFragment mAuthPassedFragment;
    private BiliAuthingFragment mAuthingFragment;
    private TintProgressDialog mProgressDialog;
    private String mSourceEvent = "";
    private BiliAuthStatus mAuthStatus = new BiliAuthStatus();
    private String mTempCode = "";
    private String mAuthCode = "";
    private final Runnable loadingRunnable = new Runnable() { // from class: tv.danmaku.bili.auth.BiliAuthActivity$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            BiliAuthActivity.loadingRunnable$lambda$0(BiliAuthActivity.this);
        }
    };

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: BiliAuthActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthActivity$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_CODE_AUTH_H5", "", "REQUEST_CODE_GUARDIAN_BIND", "REQUEST_CODE_SDK", "BUNDLE_KEY_REAL_NAME", "BUNDLE_KEY_CARD", "BUNDLE_KEY_FAIL_MSG", "BUNDLE_KEY_ERROR_CODE", "BUNDLE_KEY_OVERRIDE_MID", "BUNDLE_KEY_REQUEST_ID", "BUNDLE_KEY_OVERRIDE_SUMMARY", "PERMISSION_REQUEST_CODE", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
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
        showLoading();
        BiliAuthServiceHelper.getBiliPassportServiceHelper().getAuthApplyStatus(BiliAccounts.get((Context) this).getAccessKey(), this.mTempCode, new BiliApiDataCallback<ApplyStatusBean>() { // from class: tv.danmaku.bili.auth.BiliAuthActivity$requestStatus$1
            public void onDataSuccess(ApplyStatusBean data) {
                String str;
                BiliAuthActivity.this.dismissLoading();
                if (data == null) {
                    BLog.e("BiliAuthActivity:", "requestStatus data == null");
                    onError(null);
                    return;
                }
                BLog.e("BiliAuthActivity:", "requestStatus status == " + data.status);
                Bundle params = new Bundle();
                params.putString("key_real_name", data.realname);
                params.putString("key_card", data.card);
                str = BiliAuthActivity.this.mTempCode;
                params.putString(BiliAuthConstants.BUNDLE_KEY_TEMP_CODE, str);
                if (data.status == 2) {
                    params.putString("key_fail_msg", data.remark);
                }
                BiliAuthActivity.toFragment$default(BiliAuthActivity.this, data.status, params, null, 4, null);
            }

            public void onError(Throwable t) {
                BiliAuthActivity.this.dismissLoading();
                Intent intent = new Intent();
                intent.putExtra(BiliAuthConstants.AUTH_KEY_DEGRADE, 1);
                BiliAuthActivity.this.setResult(-1, intent);
                BiliAuthActivity.this.finish();
            }
        });
    }

    public static /* synthetic */ void toFragment$default(BiliAuthActivity biliAuthActivity, int i, Bundle bundle, Fragment fragment, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            fragment = null;
        }
        biliAuthActivity.toFragment(i, bundle, fragment);
    }

    public final void toFragment(int status, Bundle bundle, Fragment pre) {
        String string;
        String string2;
        this.mAuthStatus.setCurrentStatus(status);
        boolean z = true;
        String code = "";
        switch (status) {
            case 0:
                Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(BiliAuthingFragment.TAG);
                this.mAuthingFragment = findFragmentByTag instanceof BiliAuthingFragment ? (BiliAuthingFragment) findFragmentByTag : null;
                if (this.mAuthingFragment == null) {
                    this.mAuthingFragment = BiliAuthingFragment.Companion.newInstance(bundle);
                } else {
                    z = false;
                }
                boolean isAdd = z;
                BiliAuthingFragment biliAuthingFragment = this.mAuthingFragment;
                Intrinsics.checkNotNull(biliAuthingFragment);
                showFragment(isAdd, biliAuthingFragment, BiliAuthingFragment.TAG, pre);
                return;
            case 1:
                BiliAuthPassedFragment findFragmentByTag2 = getSupportFragmentManager().findFragmentByTag(BiliAuthPassedFragment.TAG);
                this.mAuthPassedFragment = findFragmentByTag2 instanceof BiliAuthPassedFragment ? findFragmentByTag2 : null;
                if (this.mAuthPassedFragment == null) {
                    this.mAuthPassedFragment = BiliAuthPassedFragment.Companion.newInstance(bundle);
                } else {
                    String name = (bundle == null || (name = bundle.getString("key_real_name")) == null) ? "" : "";
                    if (bundle != null && (string = bundle.getString("key_card")) != null) {
                        code = string;
                    }
                    BiliAuthPassedFragment biliAuthPassedFragment = this.mAuthPassedFragment;
                    Bundle arguments = biliAuthPassedFragment != null ? biliAuthPassedFragment.getArguments() : null;
                    if (arguments != null) {
                        arguments.putString("key_real_name", name);
                    }
                    if (arguments != null) {
                        arguments.putString("key_card", code);
                    }
                    z = false;
                }
                boolean isAdd2 = z;
                BiliAuthPassedFragment biliAuthPassedFragment2 = this.mAuthPassedFragment;
                Intrinsics.checkNotNull(biliAuthPassedFragment2);
                showFragment(isAdd2, biliAuthPassedFragment2, BiliAuthPassedFragment.TAG, pre);
                return;
            case 2:
                this.mAuthStatus.setCurrentFailMsg((bundle == null || (r8 = bundle.getString("key_fail_msg")) == null) ? "" : "");
                this.mAuthStatus.setCurrentErrorCode(bundle != null ? bundle.getInt("key_error_code", 0) : 0);
                String name2 = (bundle == null || (name2 = bundle.getString("key_real_name")) == null) ? "" : "";
                if (bundle != null && (string2 = bundle.getString("key_card")) != null) {
                    code = string2;
                }
                BiliAuthFailedFragment findFragmentByTag3 = getSupportFragmentManager().findFragmentByTag(BiliAuthFailedFragment.TAG);
                this.mAuthFailedFragment = findFragmentByTag3 instanceof BiliAuthFailedFragment ? findFragmentByTag3 : null;
                if (this.mAuthFailedFragment == null) {
                    this.mAuthFailedFragment = BiliAuthFailedFragment.Companion.newInstance(bundle);
                } else {
                    BiliAuthFailedFragment biliAuthFailedFragment = this.mAuthFailedFragment;
                    Bundle arguments2 = biliAuthFailedFragment != null ? biliAuthFailedFragment.getArguments() : null;
                    if (arguments2 != null) {
                        arguments2.putString("key_fail_msg", this.mAuthStatus.getCurrentFailMsg());
                    }
                    if (arguments2 != null) {
                        arguments2.putString("key_real_name", name2);
                    }
                    if (arguments2 != null) {
                        arguments2.putString("key_card", code);
                    }
                    z = false;
                }
                boolean isAdd3 = z;
                BiliAuthFailedFragment biliAuthFailedFragment2 = this.mAuthFailedFragment;
                Intrinsics.checkNotNull(biliAuthFailedFragment2);
                showFragment(isAdd3, biliAuthFailedFragment2, BiliAuthFailedFragment.TAG, pre);
                return;
            case 3:
                BiliAuthFragment findFragmentByTag4 = getSupportFragmentManager().findFragmentByTag(BiliAuthFragment.TAG);
                this.mAuthFragment = findFragmentByTag4 instanceof BiliAuthFragment ? findFragmentByTag4 : null;
                if (this.mAuthFragment == null) {
                    this.mAuthFragment = BiliAuthFragment.Companion.newInstance(bundle);
                } else {
                    z = false;
                }
                boolean isAdd4 = z;
                BiliAuthFragment biliAuthFragment = this.mAuthFragment;
                Intrinsics.checkNotNull(biliAuthFragment);
                showFragment(isAdd4, biliAuthFragment, BiliAuthFragment.TAG, pre);
                return;
            default:
                return;
        }
    }

    private final void showFragment(boolean isAdd, BaseAuthFragment fragment, String tag, Fragment pre) {
        if (isAdd) {
            getSupportFragmentManager().beginTransaction().add(com.bilibili.base.R.id.content_layout, (Fragment) fragment, tag).commitAllowingStateLoss();
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(transaction, "beginTransaction(...)");
        if (pre != null) {
            transaction.hide(pre);
        }
        transaction.show((Fragment) fragment).commitAllowingStateLoss();
        fragment.refreshUi();
    }

    public void onBackPressed() {
        boolean visible = this.mAuthStatus.getCurrentStatus() == 3;
        if (!visible) {
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
            }
            super.onBackPressed();
            return;
        }
        BiliCommonDialog.Builder builder = new BiliCommonDialog.Builder((Context) this);
        String string = getString(bili.resource.account.R.string.account_global_string_212);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        BiliCommonDialog.Builder title = builder.setTitle(string);
        String string2 = getString(bili.resource.account.R.string.account_global_string_310);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        BiliCommonDialog.Builder buttonStyle = title.setContentText(string2).setButtonStyle(1);
        String string3 = getString(bili.resource.account.R.string.account_global_string_203);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        BiliCommonDialog.Builder positiveButton$default = BiliCommonDialog.Builder.setPositiveButton$default(buttonStyle, string3, new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.auth.BiliAuthActivity$onBackPressed$dialog$1
            public void onDialogTextClicked(View view, BiliCommonDialog dialog) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(dialog, "dialog");
            }
        }, true, (CustomButtonInfo) null, 8, (Object) null);
        String string4 = getString(bili.resource.account.R.string.account_global_string_424);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        BiliCommonDialog dialog = BiliCommonDialog.Builder.setNegativeButton$default(positiveButton$default, string4, new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.auth.BiliAuthActivity$onBackPressed$dialog$2
            public void onDialogTextClicked(View view, BiliCommonDialog dialog2) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(dialog2, "dialog");
                AuthResultCbHelper.setResultToActivity((Activity) BiliAuthActivity.this, -1);
                BiliAuthActivity.this.exit();
            }
        }, false, new CustomButtonInfo(Integer.valueOf(com.bilibili.app.comm.baseres.R.color.theme_color_secondary), (Integer) null, 2, (DefaultConstructorMarker) null), 4, (Object) null).build();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        dialog.show(supportFragmentManager, "bili-auth");
    }

    public final String sourceEvent() {
        return this.mSourceEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void exit() {
        super.onBackPressed();
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

    public final void finishWithCallBack(AuthResultCbMsg authResultCbMsg) {
        Intrinsics.checkNotNullParameter(authResultCbMsg, "authResultCbMsg");
        dismissLoading();
        Intent intent = new Intent();
        intent.putExtra(AuthResultCbHelper.ARGS_CBM, authResultCbMsg);
        setResult(-1, intent);
        finish();
    }

    public final void showLoading() {
        dismissLoading();
        HandlerThreads.postDelayed(0, this.loadingRunnable, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadingRunnable$lambda$0(final BiliAuthActivity this$0) {
        TintProgressDialog tintProgressDialog;
        if (this$0.isFinishing() || this$0.isDestroyed()) {
            return;
        }
        boolean z = false;
        if (this$0.mProgressDialog == null) {
            this$0.mProgressDialog = new TintProgressDialog((Context) this$0);
            TintProgressDialog tintProgressDialog2 = this$0.mProgressDialog;
            if (tintProgressDialog2 != null) {
                tintProgressDialog2.setCanceledOnTouchOutside(false);
            }
            TintProgressDialog tintProgressDialog3 = this$0.mProgressDialog;
            if (tintProgressDialog3 != null) {
                tintProgressDialog3.setMessage(this$0.getString(bili.resource.account.R.string.account_global_string_243));
            }
            TintProgressDialog tintProgressDialog4 = this$0.mProgressDialog;
            if (tintProgressDialog4 != null) {
                tintProgressDialog4.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: tv.danmaku.bili.auth.BiliAuthActivity$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnKeyListener
                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        boolean loadingRunnable$lambda$0$0;
                        loadingRunnable$lambda$0$0 = BiliAuthActivity.loadingRunnable$lambda$0$0(BiliAuthActivity.this, dialogInterface, i, keyEvent);
                        return loadingRunnable$lambda$0$0;
                    }
                });
            }
        }
        TintProgressDialog tintProgressDialog5 = this$0.mProgressDialog;
        if (tintProgressDialog5 != null && !tintProgressDialog5.isShowing()) {
            z = true;
        }
        if (!z || (tintProgressDialog = this$0.mProgressDialog) == null) {
            return;
        }
        tintProgressDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean loadingRunnable$lambda$0$0(BiliAuthActivity this$0, DialogInterface dialogT, int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 1 && keyCode == 4) {
            this$0.finishWithCallBack(new AuthResultCbMsg(0));
        }
        return false;
    }

    public final void dismissLoading() {
        TintProgressDialog tintProgressDialog;
        HandlerThreads.remove(0, this.loadingRunnable);
        if (isFinishing() || isDestroyed() || (tintProgressDialog = this.mProgressDialog) == null) {
            return;
        }
        tintProgressDialog.dismiss();
    }

    public final void setAuthStatus(int status, String requestId) {
        this.mAuthStatus.setCurrentStatus(status);
        this.mAuthStatus.setRequestId(requestId == null ? "" : requestId);
    }

    public final void setErrorMsg(String msg, int errorCode) {
        this.mAuthStatus.setCurrentFailMsg(msg == null ? "" : msg);
        this.mAuthStatus.setCurrentErrorCode(errorCode);
    }

    public final void setCurrentUserInfo(String name, String code) {
        Intrinsics.checkNotNullParameter(name, ChannelRoutes.CHANNEL_NAME);
        Intrinsics.checkNotNullParameter(code, LoginReporterV2.Show.SIGNUP_KEY_CODE);
        this.mAuthStatus.setCurrentName(name);
        this.mAuthStatus.setCurrentCardCode(code);
    }

    public final Pair<String, String> getUserInfo(boolean z) {
        if (z) {
            return new Pair<>(BiliAuthExtsKt.privateName(this.mAuthStatus), BiliAuthExtsKt.privateCode(this.mAuthStatus));
        }
        return new Pair<>(this.mAuthStatus.getCurrentName(), this.mAuthStatus.getCurrentCardCode());
    }

    public final void successForLogin(String authCode, String requestId) {
        Intrinsics.checkNotNullParameter(authCode, "authCode");
        this.mAuthCode = authCode;
        AuthResultCbHelper.setResultToActivity((Activity) this, 1, this.ageInfo, this.mAuthCode, requestId == null ? "" : requestId);
        finish();
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean z = false;
        if (ev != null && ev.getAction() == 0) {
            z = true;
        }
        if (z) {
            View view = getCurrentFocus();
            clearFocusIfNeed(view, ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    private final boolean clearFocusIfNeed(View view, MotionEvent ev) {
        if (view instanceof EditText) {
            int[] location = new int[2];
            ((EditText) view).getLocationInWindow(location);
            int left = location[0];
            int top = location[1];
            int right = ((EditText) view).getWidth() + left;
            int bottom = ((EditText) view).getHeight() + top;
            boolean inRec = ev.getX() > ((float) left) && ev.getX() < ((float) right) && ev.getY() > ((float) top) && ev.getY() < ((float) bottom);
            if (!inRec) {
                editTxLostFocus();
            }
            return !inRec;
        }
        return true;
    }

    private final void editTxLostFocus() {
        BiliAuthFragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(BiliAuthFragment.TAG);
        BiliAuthFragment fragment = findFragmentByTag instanceof BiliAuthFragment ? findFragmentByTag : null;
        boolean visible = this.mAuthStatus.getCurrentStatus() == 3;
        if (!visible || fragment == null) {
            return;
        }
        fragment.clearFocus();
    }
}