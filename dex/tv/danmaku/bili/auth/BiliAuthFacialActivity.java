package tv.danmaku.bili.auth;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import bili.resource.account.R;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.app.auth.BuildConfig;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.facialrecognition.FacialBizType;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.lib.ui.PermissionsChecker;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;
import tv.danmaku.bili.widget.dialog.CustomButtonInfo;

/* compiled from: BiliAuthFacialActivity.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J,\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00122\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0002J0\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\fH\u0002J\b\u0010$\u001a\u00020\fH\u0002J\b\u0010%\u001a\u00020\fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthFacialActivity;", "Lcom/bilibili/lib/ui/BaseToolbarActivity;", "<init>", "()V", "mSourceEvent", "", "mProgressDialog", "Lcom/bilibili/magicasakura/widgets/TintProgressDialog;", "verifyType", "verifyName", "verifyIdCard", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "checkVerifyType", "checkPermissionWhenEnter", "needCheckMid", "", "showMidDialog", "beginFacial", "handleResult", LoginReporterV2.Show.SIGNUP_KEY_CODE, "", AuthResultCbHelper.ARGS_MSG, "errorCode", "requestId", "showToastIfNeed", "success", "setFacialResult", "result", "handleLoading", "showing", "showLoading", "loadingRunnable", "Ljava/lang/Runnable;", "dismissLoading", "onStop", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthFacialActivity extends BaseToolbarActivity {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "BiliAuthFacialActivity";
    private TintProgressDialog mProgressDialog;
    private String mSourceEvent = "";
    private String verifyType = "";
    private String verifyName = "";
    private String verifyIdCard = "";
    private final Runnable loadingRunnable = new Runnable() { // from class: tv.danmaku.bili.auth.BiliAuthFacialActivity$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            BiliAuthFacialActivity.loadingRunnable$lambda$0(BiliAuthFacialActivity.this);
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
        checkVerifyType();
        if (BiliAccounts.get((Context) this).isLogin() || !FacialBizType.INSTANCE.disallowUnLogin(this.verifyType)) {
            if (needCheckMid()) {
                String stringExtra2 = getIntent().getStringExtra("mid");
                String mid = stringExtra2 != null ? stringExtra2 : "";
                if ((mid.length() == 0) || !Intrinsics.areEqual(mid, String.valueOf(BiliAccounts.get((Context) this).mid()))) {
                    showMidDialog();
                    return;
                }
            }
            checkPermissionWhenEnter();
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

    private final void checkVerifyType() {
        Uri data = getIntent().getData();
        String uri = (data == null || (uri = data.toString()) == null) ? "" : "";
        if (uri.length() == 0) {
            return;
        }
        if (StringsKt.contains$default(uri, "faceOnly", false, 2, (Object) null)) {
            this.verifyType = "verify";
            String stringExtra = getIntent().getStringExtra(ChannelRoutes.CHANNEL_NAME);
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.verifyName = stringExtra;
            String stringExtra2 = getIntent().getStringExtra("idcard");
            this.verifyIdCard = stringExtra2 != null ? stringExtra2 : "";
        } else if (StringsKt.contains$default(uri, "faceUnlogin", false, 2, (Object) null)) {
            this.verifyType = "facialUnLogin";
            String stringExtra3 = getIntent().getStringExtra(ChannelRoutes.CHANNEL_NAME);
            if (stringExtra3 == null) {
                stringExtra3 = "";
            }
            this.verifyName = stringExtra3;
            String stringExtra4 = getIntent().getStringExtra("idcard");
            this.verifyIdCard = stringExtra4 != null ? stringExtra4 : "";
        } else {
            this.verifyType = "realnameVerify";
        }
    }

    private final void checkPermissionWhenEnter() {
        PermissionsChecker.grantPermission((Activity) this, PermissionsChecker.getLifecycle((Activity) this), PermissionsChecker.CAMERA_PERMISSION, 17, getString(bili.resource.common.R.string.common_global_string_323)).continueWith(new Continuation() { // from class: tv.danmaku.bili.auth.BiliAuthFacialActivity$$ExternalSyntheticLambda6
            public final Object then(Task task) {
                Unit checkPermissionWhenEnter$lambda$0;
                checkPermissionWhenEnter$lambda$0 = BiliAuthFacialActivity.checkPermissionWhenEnter$lambda$0(BiliAuthFacialActivity.this, task);
                return checkPermissionWhenEnter$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkPermissionWhenEnter$lambda$0(BiliAuthFacialActivity this$0, Task it) {
        if (it.isCancelled() || it.isFaulted()) {
            BLog.e(TAG, "Permission check Not Pass");
            this$0.handleResult(0, this$0.getString(R.string.account_global_string_252), -1, LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR);
        } else {
            this$0.beginFacial();
        }
        return Unit.INSTANCE;
    }

    private final boolean needCheckMid() {
        if (Intrinsics.areEqual(this.verifyType, "verify") || Intrinsics.areEqual(this.verifyType, "facialUnLogin")) {
            return false;
        }
        if (this.mSourceEvent.length() == 0) {
            return false;
        }
        return BiliAuthExtsKt.getSourceEventFacialOnlyMidCheckList().contains(this.mSourceEvent);
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
        BiliCommonDialog dialog = BiliCommonDialog.Builder.setPositiveButton$default(canceledOnTouchOutside, string2, new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.auth.BiliAuthFacialActivity$showMidDialog$dialog$1
            public void onDialogTextClicked(View view, BiliCommonDialog dialog2) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(dialog2, "dialog");
                dialog2.dismissAllowingStateLoss();
                BiliAuthFacialActivity.this.finish();
            }
        }, false, (CustomButtonInfo) null, 12, (Object) null).setButtonStyle(1).build();
        dialog.setCancelable(false);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        dialog.show(supportFragmentManager, TAG);
    }

    private final void beginFacial() {
        if (this.verifyType.length() == 0) {
            this.verifyType = "realnameVerify";
        }
        BiliFacialCompat.facialCompat((FragmentActivity) this, this.verifyName, this.verifyIdCard, this.mSourceEvent, this.verifyType, new Function1() { // from class: tv.danmaku.bili.auth.BiliAuthFacialActivity$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit beginFacial$lambda$0;
                beginFacial$lambda$0 = BiliAuthFacialActivity.beginFacial$lambda$0(BiliAuthFacialActivity.this, (String) obj);
                return beginFacial$lambda$0;
            }
        }, new Function2() { // from class: tv.danmaku.bili.auth.BiliAuthFacialActivity$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2) {
                Unit beginFacial$lambda$1;
                beginFacial$lambda$1 = BiliAuthFacialActivity.beginFacial$lambda$1(BiliAuthFacialActivity.this, ((Integer) obj).intValue(), (String) obj2);
                return beginFacial$lambda$1;
            }
        }, new Function1() { // from class: tv.danmaku.bili.auth.BiliAuthFacialActivity$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit beginFacial$lambda$2;
                beginFacial$lambda$2 = BiliAuthFacialActivity.beginFacial$lambda$2(BiliAuthFacialActivity.this, ((Boolean) obj).booleanValue());
                return beginFacial$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit beginFacial$lambda$0(BiliAuthFacialActivity this$0, String requestId) {
        this$0.handleResult(1, null, 0, requestId);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit beginFacial$lambda$1(BiliAuthFacialActivity this$0, int code, String msg) {
        BLog.e(TAG, "facial error code = " + code + ", msg = " + msg);
        this$0.handleResult(0, msg, code, LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit beginFacial$lambda$2(BiliAuthFacialActivity this$0, boolean it) {
        this$0.handleLoading(it);
        return Unit.INSTANCE;
    }

    private final void handleResult(final int code, final String msg, final int errorCode, final String requestId) {
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
        HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.bili.auth.BiliAuthFacialActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BiliAuthFacialActivity.handleResult$lambda$1(BiliAuthFacialActivity.this, code, msg, errorCode, requestId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleResult$lambda$1(BiliAuthFacialActivity this$0, int $code, String $msg, int $errorCode, String $requestId) {
        this$0.showToastIfNeed($code == 1, $msg);
        this$0.setFacialResult($code, $msg, $errorCode, $requestId);
    }

    static /* synthetic */ void showToastIfNeed$default(BiliAuthFacialActivity biliAuthFacialActivity, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        biliAuthFacialActivity.showToastIfNeed(z, str);
    }

    private final void showToastIfNeed(boolean success, String msg) {
        String str;
        if (Intrinsics.areEqual(this.mSourceEvent, "400")) {
            if (success) {
                ToastHelper.showToastShort((Context) this, R.string.account_global_string_230);
                return;
            }
            Context context = (Context) this;
            if (msg == null) {
                str = getString(R.string.account_global_string_434);
                Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
            } else {
                str = msg;
            }
            ToastHelper.showToastShort(context, str);
        }
    }

    static /* synthetic */ void setFacialResult$default(BiliAuthFacialActivity biliAuthFacialActivity, int i, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        biliAuthFacialActivity.setFacialResult(i, str, i2, str2);
    }

    private final void setFacialResult(int result, String msg, int errorCode, String requestId) {
        if (BuildConfig.DEBUG) {
            ToastHelper.showToastShort((Context) this, "result = " + BiliAuthExtsKt.compatResult(result) + ", msg = " + msg + ", errorCode = " + errorCode);
        }
        Intent intent = new Intent();
        intent.putExtra(BiliAuthTransferActivity.BUNDLE_REQUEST_ID, requestId == null ? "" : requestId);
        intent.putExtra("auth_result", result);
        intent.putExtra(BiliAuthConstants.RESULT_KEY_V2, BiliAuthExtsKt.compatResult(result));
        BLog.d(TAG, "setFacialResult, result = " + BiliAuthExtsKt.compatResult(result) + ", msg = " + msg + ", errorCode = " + errorCode);
        if (result == 0) {
            intent.putExtra("auth_result", 0);
            intent.putExtra("auth_msg", msg != null ? msg : "");
            intent.putExtra("auth_error_code", String.valueOf(errorCode));
        }
        setResult(-1, intent);
        finish();
    }

    private final void handleLoading(boolean showing) {
        if (showing) {
            showLoading();
        } else {
            dismissLoading();
        }
    }

    private final void showLoading() {
        dismissLoading();
        HandlerThreads.postDelayed(0, this.loadingRunnable, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadingRunnable$lambda$0(final BiliAuthFacialActivity this$0) {
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
                tintProgressDialog4.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: tv.danmaku.bili.auth.BiliAuthFacialActivity$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnKeyListener
                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        boolean loadingRunnable$lambda$0$0;
                        loadingRunnable$lambda$0$0 = BiliAuthFacialActivity.loadingRunnable$lambda$0$0(BiliAuthFacialActivity.this, dialogInterface, i, keyEvent);
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
    public static final boolean loadingRunnable$lambda$0$0(BiliAuthFacialActivity this$0, DialogInterface dialogT, int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 1 && keyCode == 4) {
            this$0.setResult(-1);
            return false;
        }
        return false;
    }

    private final void dismissLoading() {
        TintProgressDialog tintProgressDialog;
        HandlerThreads.remove(0, this.loadingRunnable);
        if (isFinishing() || isDestroyed() || (tintProgressDialog = this.mProgressDialog) == null) {
            return;
        }
        tintProgressDialog.dismiss();
    }

    protected void onStop() {
        dismissLoading();
        super.onStop();
    }

    /* compiled from: BiliAuthFacialActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthFacialActivity$Companion;", "", "<init>", "()V", "TAG", "", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}