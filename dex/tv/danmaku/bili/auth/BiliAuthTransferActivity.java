package tv.danmaku.bili.auth;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import bili.resource.account.R;
import com.bilibili.droid.H5UrlConfigHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.okretro.BiliApiDataCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.api.BiliAuthServiceHelper;
import tv.danmaku.bili.api.bean.AuthConfBean;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.cb.AuthResultCbMsg;
import tv.danmaku.bili.utils.AliAppUtil;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;
import tv.danmaku.bili.widget.dialog.CustomButtonInfo;

/* compiled from: BiliAuthTransferActivity.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\fH\u0002J\"\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u0011H\u0014J\u001c\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0011H\u0002J\u001c\u0010'\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthTransferActivity;", "Lcom/bilibili/lib/ui/BaseToolbarActivity;", "<init>", "()V", "mProgressDialog", "Lcom/bilibili/magicasakura/widgets/TintProgressDialog;", "mSourceEvent", "", "mTempCode", "URL_AUTH_VERSION_1", "URL_AUTH_VERSION_2", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "checkSourceEvent", "allowUnLogin", "", "requestConfig", "needCheckMid", "showMidDialog", "requestAuthStatus", "degrade", "toH5", "showLoading", "dismissLoading", "loadingRunnable", "Ljava/lang/Runnable;", "onActivityResult", "requestCode", "", "resultCode", "data", "finishWithCallBack", "authResultCbMsg", "Ltv/danmaku/bili/cb/AuthResultCbMsg;", "finishWithCallBackInternal", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthTransferActivity extends BaseToolbarActivity {
    public static final String BUNDLE_AUTH_CODE = "auth_login_auth_code";
    public static final String BUNDLE_ERROR_CODE = "auth_error_code";
    public static final String BUNDLE_KEY = "auth_result";
    public static final String BUNDLE_MSG = "auth_msg";
    public static final String BUNDLE_REQUEST_ID = "auth_request_id";
    public static final Companion Companion = new Companion(null);
    public static final String KEY_AGE_INFO = "key_age_info";
    public static final String KEY_TEMP_CODE = "temp_code";
    private static final int REQUEST_CODE_AUTH = 200;
    private static final int REQUEST_CODE_AUTH_H5 = 300;
    private static final int REQUEST_CODE_LOGIN = 201;
    private static final String TAG = "BiliAuthTransferActivity";
    private TintProgressDialog mProgressDialog;
    private String mSourceEvent = "";
    private String mTempCode = "";
    private final String URL_AUTH_VERSION_1 = "bilibili://auth/auth";
    private final String URL_AUTH_VERSION_2 = "bilibili://auth/auth/v2";
    private final Runnable loadingRunnable = new Runnable() { // from class: tv.danmaku.bili.auth.BiliAuthTransferActivity$$ExternalSyntheticLambda3
        @Override // java.lang.Runnable
        public final void run() {
            BiliAuthTransferActivity.loadingRunnable$lambda$0(BiliAuthTransferActivity.this);
        }
    };

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String stringExtra = getIntent().getStringExtra(BiliAuthConstants.BUNDLE_KEY_SOURCE_EVENT);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mSourceEvent = stringExtra;
        String stringExtra2 = getIntent().getStringExtra(KEY_TEMP_CODE);
        this.mTempCode = stringExtra2 != null ? stringExtra2 : "";
        checkSourceEvent();
        requestConfig();
    }

    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra(BiliAuthConstants.BUNDLE_KEY_SOURCE_EVENT);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mSourceEvent = stringExtra;
        String stringExtra2 = intent.getStringExtra(KEY_TEMP_CODE);
        this.mTempCode = stringExtra2 != null ? stringExtra2 : "";
        checkSourceEvent();
        requestConfig();
    }

    private final void checkSourceEvent() {
        if (this.mSourceEvent.length() == 0) {
            BLog.e(TAG, "source_event is empty!!!");
        }
    }

    private final boolean allowUnLogin() {
        return this.mTempCode.length() > 0;
    }

    private final void requestConfig() {
        if (BiliAccounts.get((Context) this).isLogin() || allowUnLogin()) {
            if (needCheckMid()) {
                String mid = getIntent().getStringExtra("mid");
                if (mid == null) {
                    mid = "";
                }
                if ((mid.length() == 0) || !Intrinsics.areEqual(mid, String.valueOf(BiliAccounts.get((Context) this).mid()))) {
                    showMidDialog();
                    return;
                }
            }
            showLoading();
            BiliAuthServiceHelper.getBiliPassportServiceHelper().getAuthConf(this.mTempCode, new BiliApiDataCallback<AuthConfBean>() { // from class: tv.danmaku.bili.auth.BiliAuthTransferActivity$requestConfig$1
                public void onDataSuccess(AuthConfBean data) {
                    BiliAuthTransferActivity.this.dismissLoading();
                    if (data == null || data.degrade) {
                        BLog.i("BiliAuthTransferActivity", "requestConfig degrade :: ");
                        BiliAuthTransferActivity.this.degrade();
                        return;
                    }
                    BLog.i("BiliAuthTransferActivity", "requestConfig native :: ");
                    BiliAuthTransferActivity.this.requestAuthStatus();
                }

                public void onError(Throwable t) {
                    BiliAuthTransferActivity.this.dismissLoading();
                    BLog.e("BiliAuthTransferActivity", "requestConfig error :: " + (t != null ? t.getMessage() : null));
                    BiliAuthTransferActivity.this.degrade();
                }
            });
            return;
        }
        ToastHelper.showToastShort((Context) this, R.string.account_global_string_209);
        Uri parse = Uri.parse("activity://main/login/");
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        RouteRequest request = new RouteRequest.Builder(parse).requestCode(201).build();
        BLRouter.routeTo(request, (Context) this);
        AuthResultCbHelper.setResultToActivity((Activity) this, -1);
        finish();
    }

    private final boolean needCheckMid() {
        if (this.mSourceEvent.length() == 0) {
            return false;
        }
        return BiliAuthExtsKt.getSourceEventMidCheckList().contains(this.mSourceEvent);
    }

    private final void showMidDialog() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        BiliCommonDialog.Builder builder = new BiliCommonDialog.Builder((Context) this);
        String string = getString(R.string.account_global_string_242);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        BiliCommonDialog.Builder canceledOnTouchOutside = builder.setContentText(string).setCanceledOnTouchOutside(false);
        String string2 = getString(bili.resource.common.R.string.common_global_string_194);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        BiliCommonDialog dialog = BiliCommonDialog.Builder.setPositiveButton$default(canceledOnTouchOutside, string2, new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.auth.BiliAuthTransferActivity$showMidDialog$dialog$1
            public void onDialogTextClicked(View view, BiliCommonDialog dialog2) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(dialog2, "dialog");
                dialog2.dismissAllowingStateLoss();
                BiliAuthTransferActivity.this.finish();
            }
        }, false, (CustomButtonInfo) null, 12, (Object) null).setButtonStyle(1).build();
        dialog.setCancelable(false);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        dialog.show(supportFragmentManager, TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestAuthStatus() {
        String url = this.URL_AUTH_VERSION_1;
        if (BiliAuthExtsKt.getRealnameVersionControl()) {
            url = this.URL_AUTH_VERSION_2;
        }
        Uri parse = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        RouteRequest request = new RouteRequest.Builder(parse).requestCode(200).extras(new Function1() { // from class: tv.danmaku.bili.auth.BiliAuthTransferActivity$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit requestAuthStatus$lambda$0;
                requestAuthStatus$lambda$0 = BiliAuthTransferActivity.requestAuthStatus$lambda$0(BiliAuthTransferActivity.this, (MutableBundleLike) obj);
                return requestAuthStatus$lambda$0;
            }
        }).build();
        BLRouter.routeTo(request, (Context) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestAuthStatus$lambda$0(BiliAuthTransferActivity this$0, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put(BiliAuthConstants.BUNDLE_KEY_SOURCE_EVENT, this$0.mSourceEvent);
        String stringExtra = this$0.getIntent().getStringExtra(BiliAuthConstants.BUNDLE_KEY_AFTER_14);
        if (stringExtra == null) {
            stringExtra = "";
        }
        $this$extras.put(BiliAuthConstants.BUNDLE_KEY_AFTER_14, stringExtra);
        $this$extras.put(BiliAuthConstants.BUNDLE_KEY_TEMP_CODE, this$0.mTempCode);
        String stringExtra2 = this$0.getIntent().getStringExtra(BiliAuthConstants.BUNDLE_CUSTOM_TASK);
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        $this$extras.put(BiliAuthConstants.BUNDLE_CUSTOM_TASK, stringExtra2);
        String stringExtra3 = this$0.getIntent().getStringExtra(BiliAuthConstants.BUNDLE_TASK_NAME);
        $this$extras.put(BiliAuthConstants.BUNDLE_TASK_NAME, stringExtra3 != null ? stringExtra3 : "");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void degrade() {
        toH5();
    }

    private final void toH5() {
        String authUrl;
        if (AliAppUtil.hasApplication()) {
            authUrl = H5UrlConfigHelper.INSTANCE.getUrl("auth", "url_auth_identify_home", BiliAuthConstants.AUTH_IDENTIFY_HOME);
        } else {
            authUrl = H5UrlConfigHelper.INSTANCE.getUrl("auth", "url_auth_identify_realname_default", BiliAuthConstants.AUTH_IDENTIFY_REALNAME_DEFAULT);
        }
        BLog.d(TAG, "requestAuth url = " + authUrl);
        Intrinsics.checkNotNull(authUrl);
        String url = BiliAuthExtsKt.appendSourceEvent(authUrl, this.mSourceEvent);
        RouteRequest request = RouteRequestKt.toRouteRequest(url).newBuilder().requestCode(300).build();
        BLRouter.routeTo(request, (Context) this);
    }

    private final void showLoading() {
        HandlerThreads.remove(0, this.loadingRunnable);
        HandlerThreads.postDelayed(0, this.loadingRunnable, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissLoading() {
        HandlerThreads.remove(0, this.loadingRunnable);
        if (isFinishing() || isDestroyed() || this.mProgressDialog == null) {
            return;
        }
        TintProgressDialog tintProgressDialog = this.mProgressDialog;
        Intrinsics.checkNotNull(tintProgressDialog);
        if (tintProgressDialog.isShowing()) {
            TintProgressDialog tintProgressDialog2 = this.mProgressDialog;
            Intrinsics.checkNotNull(tintProgressDialog2);
            tintProgressDialog2.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadingRunnable$lambda$0(final BiliAuthTransferActivity this$0) {
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
                tintProgressDialog3.setMessage(this$0.getString(R.string.account_global_string_243));
            }
            TintProgressDialog tintProgressDialog4 = this$0.mProgressDialog;
            if (tintProgressDialog4 != null) {
                tintProgressDialog4.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: tv.danmaku.bili.auth.BiliAuthTransferActivity$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        boolean loadingRunnable$lambda$0$0;
                        loadingRunnable$lambda$0$0 = BiliAuthTransferActivity.loadingRunnable$lambda$0$0(BiliAuthTransferActivity.this, dialogInterface, i, keyEvent);
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
    public static final boolean loadingRunnable$lambda$0$0(BiliAuthTransferActivity this$0, DialogInterface dialogT, int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 1 && keyCode == 4) {
            finishWithCallBack$default(this$0, new AuthResultCbMsg(-1), null, 2, null);
            return false;
        }
        return false;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int status;
        super.onActivityResult(requestCode, resultCode, data);
        BLog.i(TAG, "onActivityResult requestCode = " + requestCode);
        switch (requestCode) {
            case 200:
                if (data != null) {
                    AuthResultCbMsg authResultCbMsg = (AuthResultCbMsg) data.getParcelableExtra(AuthResultCbHelper.ARGS_CBM);
                    boolean degrade = data.getIntExtra(BiliAuthConstants.AUTH_KEY_DEGRADE, 0) == 1;
                    if (authResultCbMsg != null) {
                        finishWithCallBack(authResultCbMsg, data);
                        return;
                    } else if (degrade) {
                        degrade();
                        return;
                    } else {
                        finish();
                        return;
                    }
                }
                return;
            case 300:
                int result = data != null ? data.getIntExtra(BiliAuthConstants.AUTH_KEY_JS_RESULT, -200) : -200;
                if (result > -200) {
                    status = result;
                } else {
                    status = -1;
                }
                finishWithCallBack(new AuthResultCbMsg(status, ""), data);
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void finishWithCallBack$default(BiliAuthTransferActivity biliAuthTransferActivity, AuthResultCbMsg authResultCbMsg, Intent intent, int i, Object obj) {
        if ((i & 2) != 0) {
            intent = null;
        }
        biliAuthTransferActivity.finishWithCallBack(authResultCbMsg, intent);
    }

    private final void finishWithCallBack(final AuthResultCbMsg authResultCbMsg, final Intent data) {
        HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.bili.auth.BiliAuthTransferActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthTransferActivity.this.finishWithCallBackInternal(authResultCbMsg, data);
            }
        });
    }

    static /* synthetic */ void finishWithCallBackInternal$default(BiliAuthTransferActivity biliAuthTransferActivity, AuthResultCbMsg authResultCbMsg, Intent intent, int i, Object obj) {
        if ((i & 2) != 0) {
            intent = null;
        }
        biliAuthTransferActivity.finishWithCallBackInternal(authResultCbMsg, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishWithCallBackInternal(AuthResultCbMsg authResultCbMsg, Intent data) {
        BLog.i(TAG, "finish with callback state = " + authResultCbMsg.state + ", msg = " + authResultCbMsg.msg);
        Intent intent = new Intent();
        int status = BiliAuthExtsKt.checkResult(authResultCbMsg.state);
        if (data != null) {
            intent.putExtra(KEY_AGE_INFO, data.getIntExtra(KEY_AGE_INFO, 0));
        }
        intent.putExtra("auth_result", status);
        intent.putExtra(BiliAuthConstants.RESULT_KEY_V2, BiliAuthExtsKt.compatResult(status));
        intent.putExtra(BUNDLE_REQUEST_ID, authResultCbMsg.requestId);
        String str = authResultCbMsg.msg;
        intent.putExtra("auth_msg", (str == null || (r2 = str.toString()) == null) ? "" : "");
        intent.putExtra("auth_error_code", authResultCbMsg.errorCode);
        intent.putExtra(BUNDLE_AUTH_CODE, authResultCbMsg.authCode);
        setResult(-1, intent);
        finish();
    }

    /* compiled from: BiliAuthTransferActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthTransferActivity$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_CODE_AUTH", "", "REQUEST_CODE_AUTH_H5", "REQUEST_CODE_LOGIN", "KEY_TEMP_CODE", "BUNDLE_KEY", "BUNDLE_ERROR_CODE", "BUNDLE_MSG", "BUNDLE_REQUEST_ID", "BUNDLE_AUTH_CODE", "KEY_AGE_INFO", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}