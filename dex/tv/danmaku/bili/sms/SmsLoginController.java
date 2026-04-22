package tv.danmaku.bili.sms;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import bili.resource.account.R;
import com.bilibili.lib.accountsui.CountryCode;
import com.bilibili.lib.accountsui.LoginRedirectProxy;
import com.bilibili.lib.accountsui.captcha.CaptchaDialogV2;
import com.bilibili.lib.accountsui.captcha.JsBridgeCallHandlerSecure;
import com.bilibili.lib.accountsui.sms.ISmsLoginPresenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.SmsLoginService;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.main2.StartupFragmentV2;
import tv.danmaku.bili.ui.theme.BiliTheme;
import tv.danmaku.bili.utils.TimeCounter;

/* compiled from: SmsLoginController.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b'\u0018\u0000 32\u00020\u00012\u00020\u0002:\u000234B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H&J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\bJ\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u0004\u0018\u00010\fJ\b\u0010\u0017\u001a\u0004\u0018\u00010\bJ\b\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\"\u0010\u001e\u001a\u00020\u00122\u0018\u0010\u001f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 H\u0016J*\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0018\u0010%\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 H\u0016J\b\u0010&\u001a\u00020\u0012H\u0016J\"\u0010'\u001a\u00020\u00122\b\u0010(\u001a\u0004\u0018\u00010!2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0012H\u0016J\u001a\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010!H\u0016J\u0006\u0010/\u001a\u00020\u0012J \u00100\u001a\u00020\u00122\u0016\u0010%\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0006\u0012\u0004\u0018\u00010!0 H\u0016J(\u00101\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0016\u0010%\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0006\u0012\u0004\u0018\u00010!0 H\u0016J\b\u00102\u001a\u00020\u0012H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Ltv/danmaku/bili/sms/SmsLoginController;", "Ltv/danmaku/bili/sms/ISmsController;", "Lcom/bilibili/lib/accountsui/captcha/JsBridgeCallHandlerSecure$CaptchaCallback;", "<init>", "()V", "context", "Landroid/content/Context;", "mPresenter", "Lcom/bilibili/lib/accountsui/sms/ISmsLoginPresenter;", "mCountryCodeDialog", "Landroidx/appcompat/app/AlertDialog;", "mTimer", "Ltv/danmaku/bili/utils/TimeCounter;", "mCaptchaDialog", "Lcom/bilibili/lib/accountsui/captcha/CaptchaDialogV2;", "isActivityDie", "", "onCreate", "", "presenter", "getTimerCallback", "Ltv/danmaku/bili/utils/TimeCounter$TimeCounterCallback;", "getTimer", "getSmsPresenter", "showCountryChoiceDialog", "hideCountryChoiceDialog", "startTimer", "stopTimer", "getDefaultCountryCode", "Lcom/bilibili/lib/accountsui/CountryCode;", "sendSmsWithGeeCaptcha", "innerMap", "", "", "sendSmsWithImageCaptcha", "callbackId", "", "param", "tryNotifyImageCaptchaSuccess", "showCaptchaDialog", "url", "onShowCallback", "Lkotlin/Function0;", "hideCaptchaDialog", "callbackCaptchaDialog", LoginReporterV2.Show.SIGNUP_KEY_CODE, "message", "onDestroy", "replyWithGeeCaptcha", "replyWithImageCaptcha", "closeCaptchaDialog", "Companion", "SmsLoginRedirectProxy", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class SmsLoginController implements ISmsController, JsBridgeCallHandlerSecure.CaptchaCallback {
    private static final String TAG = "SmsLoginController";
    private Context context;
    private CaptchaDialogV2 mCaptchaDialog;
    private AlertDialog mCountryCodeDialog;
    private ISmsLoginPresenter mPresenter;
    private TimeCounter mTimer;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public abstract boolean isActivityDie();

    /* compiled from: SmsLoginController.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/sms/SmsLoginController$Companion;", "", "<init>", "()V", "TAG", "", "getNullDefaultCountryCode", "Lcom/bilibili/lib/accountsui/CountryCode;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CountryCode getNullDefaultCountryCode() {
            CountryCode $this$getNullDefaultCountryCode_u24lambda_u240 = new CountryCode();
            $this$getNullDefaultCountryCode_u24lambda_u240.id = "1";
            $this$getNullDefaultCountryCode_u24lambda_u240.countryId = SmsLoginService.AREA_CODE_MAINLAND;
            $this$getNullDefaultCountryCode_u24lambda_u240.name = "中国大陆";
            return $this$getNullDefaultCountryCode_u24lambda_u240;
        }
    }

    @JvmStatic
    public static final CountryCode getNullDefaultCountryCode() {
        return Companion.getNullDefaultCountryCode();
    }

    public final void onCreate(Context context, ISmsLoginPresenter presenter) {
        this.context = context;
        TimeCounter $this$onCreate_u24lambda_u240 = new TimeCounter(context, (long) StartupFragmentV2.FORCE_UPDATE_CHECK_INTERVAL, 1000L);
        TimeCounter.TimeCounterCallback $this$onCreate_u24lambda_u240_u240 = getTimerCallback();
        if ($this$onCreate_u24lambda_u240_u240 != null) {
            $this$onCreate_u24lambda_u240.setCallback($this$onCreate_u24lambda_u240_u240);
        }
        this.mTimer = $this$onCreate_u24lambda_u240;
        this.mPresenter = presenter;
    }

    public TimeCounter.TimeCounterCallback getTimerCallback() {
        return null;
    }

    public final TimeCounter getTimer() {
        return this.mTimer;
    }

    public final ISmsLoginPresenter getSmsPresenter() {
        return this.mPresenter;
    }

    @Override // tv.danmaku.bili.sms.ISmsController
    public void showCountryChoiceDialog() {
        Context $this$showCountryChoiceDialog_u24lambda_u240 = this.context;
        if ($this$showCountryChoiceDialog_u24lambda_u240 != null) {
            if (this.mCountryCodeDialog == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder($this$showCountryChoiceDialog_u24lambda_u240);
                ISmsLoginPresenter iSmsLoginPresenter = this.mPresenter;
                String[] countryItems = iSmsLoginPresenter != null ? iSmsLoginPresenter.getCountryItems() : null;
                ISmsLoginPresenter iSmsLoginPresenter2 = this.mPresenter;
                this.mCountryCodeDialog = builder.setSingleChoiceItems(countryItems, iSmsLoginPresenter2 != null ? iSmsLoginPresenter2.getSelectCountryCodeIndex() : 0, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.sms.SmsLoginController$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SmsLoginController.showCountryChoiceDialog$lambda$0$0(SmsLoginController.this, dialogInterface, i);
                    }
                }).setNegativeButton(R.string.account_global_string_57, (DialogInterface.OnClickListener) null).setTitle(R.string.account_global_string_102).create();
            }
            AlertDialog alertDialog = this.mCountryCodeDialog;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCountryChoiceDialog$lambda$0$0(SmsLoginController this$0, DialogInterface dialogInterface, int which) {
        ISmsLoginPresenter iSmsLoginPresenter = this$0.mPresenter;
        if (iSmsLoginPresenter != null) {
            iSmsLoginPresenter.setCountryCode(which);
        }
    }

    @Override // tv.danmaku.bili.sms.ISmsController
    public void hideCountryChoiceDialog() {
        AlertDialog alertDialog = this.mCountryCodeDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    @Override // tv.danmaku.bili.sms.ISmsController
    public void startTimer() {
        TimeCounter timeCounter = this.mTimer;
        if (timeCounter != null) {
            timeCounter.start();
        }
    }

    @Override // tv.danmaku.bili.sms.ISmsController
    public void stopTimer() {
        TimeCounter timeCounter = this.mTimer;
        if (timeCounter != null) {
            timeCounter.cancelWithFinish();
        }
    }

    @Override // tv.danmaku.bili.sms.ISmsController
    public CountryCode getDefaultCountryCode() {
        if (this.context != null) {
            CountryCode $this$getDefaultCountryCode_u24lambda_u240_u240 = new CountryCode();
            $this$getDefaultCountryCode_u24lambda_u240_u240.id = "1";
            $this$getDefaultCountryCode_u24lambda_u240_u240.countryId = SmsLoginService.AREA_CODE_MAINLAND;
            Context context = this.context;
            Intrinsics.checkNotNull(context);
            $this$getDefaultCountryCode_u24lambda_u240_u240.name = context.getString(R.string.account_global_string_145);
            return $this$getDefaultCountryCode_u24lambda_u240_u240;
        }
        return Companion.getNullDefaultCountryCode();
    }

    @Override // tv.danmaku.bili.sms.ISmsController
    public void sendSmsWithGeeCaptcha(Map<String, String> map) {
        ISmsLoginPresenter iSmsLoginPresenter;
        hideCaptchaDialog();
        if (map == null || (iSmsLoginPresenter = this.mPresenter) == null) {
            return;
        }
        iSmsLoginPresenter.sendCaptcha(map);
    }

    @Override // tv.danmaku.bili.sms.ISmsController
    public void sendSmsWithImageCaptcha(int callbackId, Map<String, String> map) {
        ISmsLoginPresenter iSmsLoginPresenter;
        CaptchaDialogV2 captchaDialogV2;
        if (this.mCaptchaDialog != null) {
            CaptchaDialogV2 captchaDialogV22 = this.mCaptchaDialog;
            boolean z = false;
            if (captchaDialogV22 != null && captchaDialogV22.isShowing()) {
                z = true;
            }
            if (z && (captchaDialogV2 = this.mCaptchaDialog) != null) {
                captchaDialogV2.setJsCallbackId(callbackId);
            }
        }
        if (map == null || (iSmsLoginPresenter = this.mPresenter) == null) {
            return;
        }
        iSmsLoginPresenter.sendCaptcha(map);
    }

    @Override // tv.danmaku.bili.sms.ISmsController
    public void tryNotifyImageCaptchaSuccess() {
        CaptchaDialogV2 captchaDialogV2;
        BLog.i(TAG, "tryNotifyImageCaptchaSuccess");
        if (this.mCaptchaDialog != null) {
            CaptchaDialogV2 captchaDialogV22 = this.mCaptchaDialog;
            boolean z = false;
            if (captchaDialogV22 != null && captchaDialogV22.isShowing()) {
                z = true;
            }
            if (!z || (captchaDialogV2 = this.mCaptchaDialog) == null) {
                return;
            }
            captchaDialogV2.imageCaptchaSuccess();
        }
    }

    @Override // tv.danmaku.bili.sms.ISmsController
    public void showCaptchaDialog(String url, Function0<Unit> function0) {
        BLog.i(TAG, "showCaptchaDialog url = " + url);
        Context $this$showCaptchaDialog_u24lambda_u240 = this.context;
        if ($this$showCaptchaDialog_u24lambda_u240 == null || url == null) {
            return;
        }
        if (this.mCaptchaDialog != null) {
            CaptchaDialogV2 captchaDialogV2 = this.mCaptchaDialog;
            boolean z = false;
            if (captchaDialogV2 != null && !captchaDialogV2.isShowing()) {
                z = true;
            }
            if (!z) {
                return;
            }
        }
        this.mCaptchaDialog = new CaptchaDialogV2($this$showCaptchaDialog_u24lambda_u240, url, BiliTheme.isNightTheme(this.context));
        if (!isActivityDie()) {
            CaptchaDialogV2 captchaDialogV22 = this.mCaptchaDialog;
            if (captchaDialogV22 != null) {
                captchaDialogV22.show();
            }
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    @Override // tv.danmaku.bili.sms.ISmsController
    public void hideCaptchaDialog() {
        CaptchaDialogV2 captchaDialogV2 = this.mCaptchaDialog;
        if (captchaDialogV2 != null) {
            captchaDialogV2.dismiss();
        }
    }

    @Override // tv.danmaku.bili.sms.ISmsController
    public void callbackCaptchaDialog(int code, String message) {
        CaptchaDialogV2 captchaDialogV2;
        BLog.i(TAG, "callbackCaptchaDialog code = " + code + " , message = " + message);
        CaptchaDialogV2 captchaDialogV22 = this.mCaptchaDialog;
        boolean z = false;
        if (captchaDialogV22 != null && captchaDialogV22.isShowing()) {
            z = true;
        }
        if (!z || (captchaDialogV2 = this.mCaptchaDialog) == null) {
            return;
        }
        captchaDialogV2.imageCaptchaError(code, message == null ? "" : message);
    }

    public final void onDestroy() {
        this.context = null;
        TimeCounter timeCounter = this.mTimer;
        if (timeCounter != null) {
            timeCounter.cancel();
        }
        this.mPresenter = null;
        CaptchaDialogV2 captchaDialogV2 = this.mCaptchaDialog;
        if (captchaDialogV2 != null) {
            captchaDialogV2.dismiss();
        }
        this.mCaptchaDialog = null;
        AlertDialog alertDialog = this.mCountryCodeDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.mCountryCodeDialog = null;
    }

    public void replyWithGeeCaptcha(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "param");
        sendSmsWithGeeCaptcha(map);
    }

    public void replyWithImageCaptcha(int callbackId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "param");
        CaptchaDialogV2 captchaDialogV2 = this.mCaptchaDialog;
        if (captchaDialogV2 != null) {
            captchaDialogV2.setJsCallbackId(callbackId);
        }
        sendSmsWithImageCaptcha(callbackId, map);
    }

    public void closeCaptchaDialog() {
        hideCaptchaDialog();
    }

    /* compiled from: SmsLoginController.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007H&¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/sms/SmsLoginController$SmsLoginRedirectProxy;", "Lcom/bilibili/lib/accountsui/LoginRedirectProxy$DefaultLoginRedirectProxy;", "<init>", "()V", "jumpVerifyPage", "", "status", "", "intent", "Landroid/content/Intent;", "startActivityForResult", "", "requestCode", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class SmsLoginRedirectProxy extends LoginRedirectProxy.DefaultLoginRedirectProxy {
        public static final int $stable = 8;

        public abstract void startActivityForResult(Intent intent, int i);

        public boolean jumpVerifyPage(int status, Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            startActivityForResult(intent, 204);
            return true;
        }
    }
}