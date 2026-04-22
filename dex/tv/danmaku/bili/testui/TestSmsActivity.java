package tv.danmaku.bili.testui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.bilibili.app.accountui.R;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accounts.VerifyBundle;
import com.bilibili.lib.accountsui.AutoCompleteHelper;
import com.bilibili.lib.accountsui.CountryCode;
import com.bilibili.lib.accountsui.CountryCodeHelper;
import com.bilibili.lib.accountsui.captcha.CaptchaDialogV2;
import com.bilibili.lib.accountsui.captcha.JsBridgeCallHandlerSecure;
import com.bilibili.lib.accountsui.sms.ISmsLoginReporter;
import com.bilibili.lib.accountsui.sms.ISmsLoginView;
import com.bilibili.lib.accountsui.sms.SmsLoginPresenter;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.magicasakura.widgets.TintButton;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.service.SmsLoginService;
import tv.danmaku.bili.helper.LoginSuccessProcessorKt;
import tv.danmaku.bili.helper.LoginUIType;
import tv.danmaku.bili.ui.AgreementLinkHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.main2.StartupFragmentV2;
import tv.danmaku.bili.ui.theme.BiliTheme;
import tv.danmaku.bili.ui.util.AccountUtils;
import tv.danmaku.bili.utils.TimeCounter;

/* compiled from: TestSmsActivity.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 h2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002hiB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\"\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\u0010\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\u0019H\u0016J\b\u00100\u001a\u00020%H\u0014J\u0010\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020*H\u0016J\u0012\u00101\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020%H\u0016J\b\u00106\u001a\u00020%H\u0016J\u0010\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020*H\u0016J\b\u00109\u001a\u00020%H\u0016J\b\u0010:\u001a\u00020%H\u0016J\b\u0010;\u001a\u00020%H\u0016J\b\u0010<\u001a\u00020=H\u0016J\"\u0010F\u001a\u00020%2\u0018\u0010G\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u000104\u0012\u0006\u0012\u0004\u0018\u000104\u0018\u00010HH\u0016J*\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020*2\u0018\u0010K\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u000104\u0012\u0006\u0012\u0004\u0018\u000104\u0018\u00010HH\u0016J\b\u0010L\u001a\u00020%H\u0016J\u0012\u0010M\u001a\u00020%2\b\u0010N\u001a\u0004\u0018\u000104H\u0016J\b\u0010O\u001a\u00020%H\u0016J\u001a\u0010P\u001a\u00020%2\u0006\u00108\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u0010Q\u001a\u00020%H\u0016J\u0012\u0010R\u001a\u00020%2\b\u0010S\u001a\u0004\u0018\u000104H\u0016J\u0010\u0010R\u001a\u00020%2\u0006\u00102\u001a\u00020*H\u0016J\b\u0010T\u001a\u00020%H\u0016J\u0010\u0010U\u001a\u00020%2\u0006\u0010V\u001a\u00020?H\u0016J\b\u0010W\u001a\u00020%H\u0016J\b\u0010X\u001a\u00020%H\u0016J\u0010\u0010Y\u001a\u00020%2\u0006\u0010Z\u001a\u00020*H\u0016J\u0010\u0010[\u001a\u00020%2\u0006\u0010\\\u001a\u00020=H\u0016J\b\u0010]\u001a\u00020%H\u0016J\u0012\u0010^\u001a\u00020%2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\b\u0010a\u001a\u00020%H\u0002J\b\u0010b\u001a\u00020%H\u0002J\b\u0010c\u001a\u00020%H\u0002J\b\u0010d\u001a\u00020%H\u0002J \u0010e\u001a\u00020%2\u0016\u0010K\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000104\u0012\u0006\u0012\u0004\u0018\u0001040HH\u0016J(\u0010f\u001a\u00020%2\u0006\u0010J\u001a\u00020*2\u0016\u0010K\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000104\u0012\u0006\u0012\u0004\u0018\u0001040HH\u0016J\b\u0010g\u001a\u00020%H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010@R\u0016\u0010A\u001a\u0004\u0018\u0001048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0016\u0010D\u001a\u0004\u0018\u0001048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010C¨\u0006j"}, d2 = {"Ltv/danmaku/bili/testui/TestSmsActivity;", "Lcom/bilibili/lib/ui/BaseToolbarActivity;", "Lcom/bilibili/lib/accountsui/sms/ISmsLoginView;", "Landroid/view/View$OnClickListener;", "Lcom/bilibili/lib/accountsui/captcha/JsBridgeCallHandlerSecure$CaptchaCallback;", "<init>", "()V", "countryCodeDialog", "Landroidx/appcompat/app/AlertDialog;", "agreementLinkHelper", "Ltv/danmaku/bili/ui/AgreementLinkHelper;", "mSelectedCountryNameView", "Landroid/widget/TextView;", "mSubmitBtn", "Lcom/bilibili/magicasakura/widgets/TintButton;", "mGetCaptcha", "mAreaCodeView", "mTimer", "Ltv/danmaku/bili/utils/TimeCounter;", "mLoginAgreementText", "mLoginCheckHelpText", "clearPhoneNum", "Landroid/widget/ImageView;", "clearCaptcha", "clearPhoneLayout", "Landroid/view/View;", "clearCaptchaLayout", "mEtPhoneNum", "Landroid/widget/EditText;", "mEtCaptcha", "mPresenter", "Lcom/bilibili/lib/accountsui/sms/SmsLoginPresenter;", "mCaptchaDialog", "Lcom/bilibili/lib/accountsui/captcha/CaptchaDialogV2;", "progressDialog", "Lcom/bilibili/magicasakura/widgets/TintProgressDialog;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "onDestroy", "showTip", "resId", "message", "", "showCountryChoiceDialog", "hideCountryChoiceDialog", "finish", LoginReporterV2.Show.SIGNUP_KEY_CODE, "startTimer", "stopTimer", "alertVipStatusIfNeed", "getDefaultCountryCode", "Lcom/bilibili/lib/accountsui/CountryCode;", "isActivityDie", "", "()Z", "pagePv", "getPagePv", "()Ljava/lang/String;", "routeUri", "getRouteUri", "sendSmsWithGeeCaptcha", "innerMap", "", "sendSmsWithImageCaptcha", "callbackId", "param", "tryNotifyImageCaptchaSuccess", "showCaptchaDialog", "url", "hideCaptchaDialog", "callbackCaptchaDialog", "focusToCaptchaEdit", "showProgress", AuthResultCbHelper.ARGS_MSG, "hideProgress", "onCountryCodeUpdate", "success", "warningPhoneNum", "warningCaptcha", "onLoginAfterRegisterSuccess", "inRegAudit", "onReceiveSelectCountry", "countryCode", "onLoginSuccess", "onLoginIntercept", "verifyBundle", "Lcom/bilibili/lib/accounts/VerifyBundle;", "initViews", "hideSoftInput", "setListeners", "findViews", "replyWithGeeCaptcha", "replyWithImageCaptcha", "closeCaptchaDialog", "Companion", "CaptchaFilter", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TestSmsActivity extends BaseToolbarActivity implements ISmsLoginView, View.OnClickListener, JsBridgeCallHandlerSecure.CaptchaCallback {
    public static final int REQ_CODE_FORGET = 203;
    public static final int REQ_CODE_SECOND_VERIFY = 204;
    private static final String URL_ANSWER = "https://passport.bilibili.com/register/quickregister.html#/success";
    private AgreementLinkHelper agreementLinkHelper;
    private ImageView clearCaptcha;
    private View clearCaptchaLayout;
    private View clearPhoneLayout;
    private ImageView clearPhoneNum;
    private AlertDialog countryCodeDialog;
    private TextView mAreaCodeView;
    private CaptchaDialogV2 mCaptchaDialog;
    private EditText mEtCaptcha;
    private EditText mEtPhoneNum;
    private TextView mGetCaptcha;
    private TextView mLoginAgreementText;
    private TextView mLoginCheckHelpText;
    private SmsLoginPresenter mPresenter;
    private TextView mSelectedCountryNameView;
    private TintButton mSubmitBtn;
    private TimeCounter mTimer;
    private TintProgressDialog progressDialog;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: TestSmsActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/testui/TestSmsActivity$Companion;", "", "<init>", "()V", "URL_ANSWER", "", "REQ_CODE_FORGET", "", "REQ_CODE_SECOND_VERIFY", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
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
        setContentView(R.layout.bili_app_test_sms);
        BiliAccountInfo.Companion.init();
        this.agreementLinkHelper = new AgreementLinkHelper((Context) this);
        this.mPresenter = new SmsLoginPresenter((Context) this, this, (ISmsLoginReporter) null, 4, (DefaultConstructorMarker) null);
        this.mTimer = new TimeCounter(getApplicationContext(), (long) StartupFragmentV2.FORCE_UPDATE_CHECK_INTERVAL, 1000L);
        findViews();
        initViews();
        setListeners();
        showBackButton();
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        LoginSuccessProcessorKt.onLoginPageEnter(this, application, LoginUIType.SMS);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 203 && resultCode == -1) {
            setResult(-1);
            finish();
        } else if (requestCode == 204) {
            if (resultCode == -1) {
                setResult(-1);
            }
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getId() == R.id.selected_country_name) {
            SmsLoginPresenter smsLoginPresenter = this.mPresenter;
            Intrinsics.checkNotNull(smsLoginPresenter);
            smsLoginPresenter.choiceCountry();
        } else if (v.getId() == R.id.submit) {
            SmsLoginPresenter smsLoginPresenter2 = this.mPresenter;
            Intrinsics.checkNotNull(smsLoginPresenter2);
            EditText editText = this.mEtPhoneNum;
            Intrinsics.checkNotNull(editText);
            String obj = editText.getText().toString();
            EditText editText2 = this.mEtCaptcha;
            Intrinsics.checkNotNull(editText2);
            smsLoginPresenter2.submit(obj, editText2.getText().toString());
            hideSoftInput();
        } else if (v.getId() == R.id.get_auth_code) {
            EditText editText3 = this.mEtPhoneNum;
            Intrinsics.checkNotNull(editText3);
            if (!TextUtils.isEmpty(editText3.getText().toString())) {
                SmsLoginPresenter smsLoginPresenter3 = this.mPresenter;
                Intrinsics.checkNotNull(smsLoginPresenter3);
                EditText editText4 = this.mEtPhoneNum;
                Intrinsics.checkNotNull(editText4);
                smsLoginPresenter3.sendCaptcha(editText4.getText().toString());
                hideSoftInput();
            }
        } else if (v.getId() == R.id.clear_phonenum_layout) {
            EditText editText5 = this.mEtPhoneNum;
            Intrinsics.checkNotNull(editText5);
            editText5.setText("");
            SmsLoginPresenter smsLoginPresenter4 = this.mPresenter;
            Intrinsics.checkNotNull(smsLoginPresenter4);
            smsLoginPresenter4.clearCache();
        } else if (v.getId() == R.id.clear_captcha_layout) {
            EditText editText6 = this.mEtCaptcha;
            Intrinsics.checkNotNull(editText6);
            editText6.setText("");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mTimer != null) {
            TimeCounter timeCounter = this.mTimer;
            Intrinsics.checkNotNull(timeCounter);
            timeCounter.cancel();
            this.mTimer = null;
        }
        SmsLoginPresenter smsLoginPresenter = this.mPresenter;
        Intrinsics.checkNotNull(smsLoginPresenter);
        smsLoginPresenter.cancelTasks();
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        LoginSuccessProcessorKt.onLoginPageExit(this, application, LoginUIType.SMS);
    }

    public void showTip(int resId) {
        ToastHelper.showToastLong(BiliContext.application(), resId);
    }

    public void showTip(String message) {
        ToastHelper.showToastLong(BiliContext.application(), message);
    }

    public void showCountryChoiceDialog() {
        CountryCodeHelper.update();
        if (this.countryCodeDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder((Context) this);
            SmsLoginPresenter smsLoginPresenter = this.mPresenter;
            Intrinsics.checkNotNull(smsLoginPresenter);
            this.countryCodeDialog = builder.setSingleChoiceItems(smsLoginPresenter.getCountryItems(), 0, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.testui.TestSmsActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    TestSmsActivity.showCountryChoiceDialog$lambda$0(TestSmsActivity.this, dialogInterface, i);
                }
            }).setNegativeButton(bili.resource.account.R.string.account_global_string_57, (DialogInterface.OnClickListener) null).setTitle(bili.resource.account.R.string.account_global_string_102).create();
        }
        AlertDialog alertDialog = this.countryCodeDialog;
        Intrinsics.checkNotNull(alertDialog);
        alertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCountryChoiceDialog$lambda$0(TestSmsActivity this$0, DialogInterface dialog, int which) {
        SmsLoginPresenter smsLoginPresenter = this$0.mPresenter;
        Intrinsics.checkNotNull(smsLoginPresenter);
        smsLoginPresenter.setCountryCode(which);
    }

    public void hideCountryChoiceDialog() {
        AlertDialog alertDialog = this.countryCodeDialog;
        if (alertDialog != null) {
            alertDialog.hide();
        }
    }

    public void finish(int code) {
        setResult(code);
        finish();
    }

    public void startTimer() {
        TimeCounter timeCounter = this.mTimer;
        if (timeCounter != null) {
            timeCounter.start();
        }
    }

    public void stopTimer() {
        TimeCounter timeCounter = this.mTimer;
        if (timeCounter != null) {
            timeCounter.cancelWithFinish();
        }
    }

    public void alertVipStatusIfNeed() {
        ToastHelper.showToastLong(BiliContext.application(), "alertVipStatusIfNeed");
    }

    public CountryCode getDefaultCountryCode() {
        CountryCode $this$getDefaultCountryCode_u24lambda_u240 = new CountryCode();
        $this$getDefaultCountryCode_u24lambda_u240.id = "1";
        $this$getDefaultCountryCode_u24lambda_u240.countryId = SmsLoginService.AREA_CODE_MAINLAND;
        $this$getDefaultCountryCode_u24lambda_u240.name = getString(bili.resource.account.R.string.account_global_string_145);
        return $this$getDefaultCountryCode_u24lambda_u240;
    }

    public boolean isActivityDie() {
        return isFinishing();
    }

    public String getPagePv() {
        return null;
    }

    public String getRouteUri() {
        return AccountUtils.Companion.getRouterFrom((Activity) this);
    }

    public void sendSmsWithGeeCaptcha(Map<String, String> map) {
        hideCaptchaDialog();
        SmsLoginPresenter smsLoginPresenter = this.mPresenter;
        Intrinsics.checkNotNull(smsLoginPresenter);
        Intrinsics.checkNotNull(map);
        smsLoginPresenter.sendCaptcha(map);
    }

    public void sendSmsWithImageCaptcha(int callbackId, Map<String, String> map) {
        if (this.mCaptchaDialog != null) {
            CaptchaDialogV2 captchaDialogV2 = this.mCaptchaDialog;
            Intrinsics.checkNotNull(captchaDialogV2);
            if (captchaDialogV2.isShowing()) {
                CaptchaDialogV2 captchaDialogV22 = this.mCaptchaDialog;
                Intrinsics.checkNotNull(captchaDialogV22);
                captchaDialogV22.setJsCallbackId(callbackId);
            }
        }
        SmsLoginPresenter smsLoginPresenter = this.mPresenter;
        Intrinsics.checkNotNull(smsLoginPresenter);
        Intrinsics.checkNotNull(map);
        smsLoginPresenter.sendCaptcha(map);
    }

    public void tryNotifyImageCaptchaSuccess() {
        if (this.mCaptchaDialog != null) {
            CaptchaDialogV2 captchaDialogV2 = this.mCaptchaDialog;
            Intrinsics.checkNotNull(captchaDialogV2);
            if (captchaDialogV2.isShowing()) {
                CaptchaDialogV2 captchaDialogV22 = this.mCaptchaDialog;
                Intrinsics.checkNotNull(captchaDialogV22);
                captchaDialogV22.imageCaptchaSuccess();
            }
        }
    }

    public void showCaptchaDialog(String url) {
        if (this.mCaptchaDialog != null) {
            CaptchaDialogV2 captchaDialogV2 = this.mCaptchaDialog;
            Intrinsics.checkNotNull(captchaDialogV2);
            if (captchaDialogV2.isShowing()) {
                return;
            }
        }
        this.mCaptchaDialog = new CaptchaDialogV2((Context) this, url, MultipleThemeUtils.isNightTheme((Context) this));
        if (!isFinishing()) {
            CaptchaDialogV2 captchaDialogV22 = this.mCaptchaDialog;
            Intrinsics.checkNotNull(captchaDialogV22);
            captchaDialogV22.show();
        }
    }

    public void hideCaptchaDialog() {
        if (this.mCaptchaDialog != null) {
            CaptchaDialogV2 captchaDialogV2 = this.mCaptchaDialog;
            Intrinsics.checkNotNull(captchaDialogV2);
            captchaDialogV2.dismiss();
            this.mCaptchaDialog = null;
        }
    }

    public void callbackCaptchaDialog(int code, String message) {
        if (this.mCaptchaDialog != null) {
            CaptchaDialogV2 captchaDialogV2 = this.mCaptchaDialog;
            Intrinsics.checkNotNull(captchaDialogV2);
            if (captchaDialogV2.isShowing()) {
                CaptchaDialogV2 captchaDialogV22 = this.mCaptchaDialog;
                Intrinsics.checkNotNull(captchaDialogV22);
                captchaDialogV22.imageCaptchaError(code, message);
            }
        }
    }

    public void focusToCaptchaEdit() {
        EditText editText = this.mEtCaptcha;
        Intrinsics.checkNotNull(editText);
        editText.setText("");
        EditText editText2 = this.mEtCaptcha;
        Intrinsics.checkNotNull(editText2);
        editText2.requestFocus();
        InputMethodManagerHelper.showSoftInput((Context) this, this.mEtCaptcha, 1);
    }

    public void showProgress(String msg) {
        if (this.progressDialog == null) {
            this.progressDialog = new TintProgressDialog((Context) this);
            TintProgressDialog tintProgressDialog = this.progressDialog;
            Intrinsics.checkNotNull(tintProgressDialog);
            tintProgressDialog.setMessage(msg);
            TintProgressDialog tintProgressDialog2 = this.progressDialog;
            Intrinsics.checkNotNull(tintProgressDialog2);
            tintProgressDialog2.setIndeterminate(true);
            TintProgressDialog tintProgressDialog3 = this.progressDialog;
            Intrinsics.checkNotNull(tintProgressDialog3);
            tintProgressDialog3.setCanceledOnTouchOutside(false);
        }
        if (!isFinishing()) {
            TintProgressDialog tintProgressDialog4 = this.progressDialog;
            Intrinsics.checkNotNull(tintProgressDialog4);
            tintProgressDialog4.setMessage(msg);
            TintProgressDialog tintProgressDialog5 = this.progressDialog;
            Intrinsics.checkNotNull(tintProgressDialog5);
            tintProgressDialog5.show();
        }
    }

    public void showProgress(int resId) {
        showProgress(getString(resId));
    }

    public void hideProgress() {
        if (this.progressDialog != null) {
            TintProgressDialog tintProgressDialog = this.progressDialog;
            Intrinsics.checkNotNull(tintProgressDialog);
            if (tintProgressDialog.isShowing()) {
                TintProgressDialog tintProgressDialog2 = this.progressDialog;
                Intrinsics.checkNotNull(tintProgressDialog2);
                tintProgressDialog2.dismiss();
            }
        }
    }

    public void onCountryCodeUpdate(boolean success) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void warningPhoneNum() {
        EditText editText = this.mEtPhoneNum;
        Intrinsics.checkNotNull(editText);
        editText.setTextColor(getResources().getColor(com.bilibili.lib.ui.R.color.text_red_kit));
    }

    public void warningCaptcha() {
        EditText editText = this.mEtCaptcha;
        Intrinsics.checkNotNull(editText);
        editText.setTextColor(getResources().getColor(com.bilibili.lib.ui.R.color.text_red_kit));
    }

    public void onLoginAfterRegisterSuccess(int inRegAudit) {
        Uri parse = Uri.parse("activity://main/web/ap");
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        RouteRequest routeRequest = new RouteRequest.Builder(parse).data(Uri.parse(URL_ANSWER)).build();
        BLRouter.routeTo(routeRequest, (Context) this);
    }

    public void onReceiveSelectCountry(CountryCode countryCode) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        String name = countryCode.name == null ? "" : countryCode.name;
        TextView textView = this.mSelectedCountryNameView;
        Intrinsics.checkNotNull(textView);
        textView.setText(name);
        TextView textView2 = this.mAreaCodeView;
        Intrinsics.checkNotNull(textView2);
        textView2.setText(countryCode.countryId != null ? "+" + countryCode.countryId : "");
    }

    public void onLoginSuccess() {
        if (isActivityDie()) {
            return;
        }
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        LoginSuccessProcessorKt.processLoginSuccess(application, LoginUIType.SMS);
        RouteRequest request = getIntent().getParcelableExtra("blrouter.forward");
        if (request == null) {
            return;
        }
        BLRouter.routeTo(request, (Context) this);
    }

    public void onLoginIntercept(VerifyBundle verifyBundle) {
    }

    private final void initViews() {
        TimeCounter timeCounter = this.mTimer;
        Intrinsics.checkNotNull(timeCounter);
        timeCounter.attachTv(this.mGetCaptcha);
        AgreementLinkHelper agreementLinkHelper = this.agreementLinkHelper;
        Intrinsics.checkNotNull(agreementLinkHelper);
        agreementLinkHelper.attachLinkContentAgreement(this.mLoginAgreementText, getString(bili.resource.account.R.string.account_global_string_142), null);
        AgreementLinkHelper agreementLinkHelper2 = this.agreementLinkHelper;
        Intrinsics.checkNotNull(agreementLinkHelper2);
        agreementLinkHelper2.attachLinkContentHelp(this.mLoginCheckHelpText, getString(bili.resource.account.R.string.account_global_string_49), null, 0);
        SmsLoginPresenter smsLoginPresenter = this.mPresenter;
        Intrinsics.checkNotNull(smsLoginPresenter);
        CountryCode selectedCountryCode = smsLoginPresenter.getSelectedCountryCode();
        Intrinsics.checkNotNull(selectedCountryCode);
        onReceiveSelectCountry(selectedCountryCode);
        SmsLoginPresenter smsLoginPresenter2 = this.mPresenter;
        Intrinsics.checkNotNull(smsLoginPresenter2);
        AutoCompleteHelper.SmsLoginInfo smsLoginInfo = smsLoginPresenter2.loadCache();
        TextView textView = this.mGetCaptcha;
        Intrinsics.checkNotNull(textView);
        textView.setEnabled(false);
        if (smsLoginInfo != null) {
            EditText editText = this.mEtPhoneNum;
            Intrinsics.checkNotNull(editText);
            editText.setText(smsLoginInfo.mPhoneNum);
            EditText editText2 = this.mEtPhoneNum;
            Intrinsics.checkNotNull(editText2);
            editText2.setSelection(smsLoginInfo.mPhoneNum.length());
            TextView textView2 = this.mGetCaptcha;
            Intrinsics.checkNotNull(textView2);
            textView2.setEnabled(true);
            CountryCode countryCode = smsLoginInfo.mCountryCode;
            if (countryCode != null) {
                String name = countryCode.name == null ? "" : countryCode.name;
                TextView textView3 = this.mSelectedCountryNameView;
                Intrinsics.checkNotNull(textView3);
                textView3.setText(name);
                TextView textView4 = this.mAreaCodeView;
                Intrinsics.checkNotNull(textView4);
                textView4.setText(countryCode.countryId != null ? "+" + countryCode.countryId : "");
            }
        }
        EditText editText3 = this.mEtCaptcha;
        Intrinsics.checkNotNull(editText3);
        editText3.setFilters(new InputFilter[]{new CaptchaFilter()});
        if (BiliTheme.isNightTheme((Context) this)) {
            ImageView imageView = this.clearPhoneNum;
            Intrinsics.checkNotNull(imageView);
            imageView.setColorFilter(ContextCompat.getColor((Context) this, R.color.clear_et_icon_night_color));
            ImageView imageView2 = this.clearCaptcha;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setColorFilter(ContextCompat.getColor((Context) this, R.color.clear_et_icon_night_color));
        }
        TextView textView5 = this.mGetCaptcha;
        Intrinsics.checkNotNull(textView5);
        textView5.postDelayed(new Runnable() { // from class: tv.danmaku.bili.testui.TestSmsActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                TestSmsActivity.initViews$lambda$0(TestSmsActivity.this);
            }
        }, 100L);
        setTitle(bili.resource.account.R.string.account_global_string_81);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(TestSmsActivity this$0) {
        EditText editText = this$0.mEtPhoneNum;
        Intrinsics.checkNotNull(editText);
        editText.requestFocus();
        InputMethodManagerHelper.showSoftInput((Context) this$0, this$0.mEtPhoneNum, 1);
    }

    private final void hideSoftInput() {
        Window window = getWindow();
        if (window != null) {
            InputMethodManagerHelper.hideSoftInput((Context) this, window.getDecorView(), 2);
        }
    }

    private final void setListeners() {
        EditText editText = this.mEtPhoneNum;
        Intrinsics.checkNotNull(editText);
        editText.addTextChangedListener(new TextWatcher() { // from class: tv.danmaku.bili.testui.TestSmsActivity$setListeners$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                EditText editText2;
                Intrinsics.checkNotNullParameter(s, "s");
                editText2 = TestSmsActivity.this.mEtPhoneNum;
                Intrinsics.checkNotNull(editText2);
                editText2.setTextColor(TestSmsActivity.this.getResources().getColor(com.bilibili.lib.ui.R.color.text_primary_kit));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            /* JADX WARN: Code restructure failed: missing block: B:9:0x0072, code lost:
                if (android.text.TextUtils.isEmpty(r3.getText()) == false) goto L8;
             */
            @Override // android.text.TextWatcher
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void afterTextChanged(Editable s) {
                ImageView imageView;
                TextView textView;
                TintButton tintButton;
                EditText editText2;
                EditText editText3;
                ImageView imageView2;
                TextView textView2;
                Intrinsics.checkNotNullParameter(s, "s");
                boolean z = true;
                if (s.length() == 0) {
                    imageView2 = TestSmsActivity.this.clearPhoneNum;
                    Intrinsics.checkNotNull(imageView2);
                    imageView2.setVisibility(8);
                    textView2 = TestSmsActivity.this.mGetCaptcha;
                    Intrinsics.checkNotNull(textView2);
                    textView2.setEnabled(false);
                } else {
                    imageView = TestSmsActivity.this.clearPhoneNum;
                    Intrinsics.checkNotNull(imageView);
                    imageView.setVisibility(0);
                    textView = TestSmsActivity.this.mGetCaptcha;
                    Intrinsics.checkNotNull(textView);
                    textView.setEnabled(true);
                }
                tintButton = TestSmsActivity.this.mSubmitBtn;
                Intrinsics.checkNotNull(tintButton);
                editText2 = TestSmsActivity.this.mEtPhoneNum;
                Intrinsics.checkNotNull(editText2);
                if (!TextUtils.isEmpty(editText2.getText())) {
                    editText3 = TestSmsActivity.this.mEtCaptcha;
                    Intrinsics.checkNotNull(editText3);
                }
                z = false;
                tintButton.setEnabled(z);
            }
        });
        EditText editText2 = this.mEtCaptcha;
        Intrinsics.checkNotNull(editText2);
        editText2.addTextChangedListener(new TextWatcher() { // from class: tv.danmaku.bili.testui.TestSmsActivity$setListeners$2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                EditText editText3;
                Intrinsics.checkNotNullParameter(s, "s");
                editText3 = TestSmsActivity.this.mEtCaptcha;
                Intrinsics.checkNotNull(editText3);
                editText3.setTextColor(TestSmsActivity.this.getResources().getColor(com.bilibili.lib.ui.R.color.text_primary_kit));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ImageView imageView;
                TintButton tintButton;
                EditText editText3;
                EditText editText4;
                ImageView imageView2;
                Intrinsics.checkNotNullParameter(s, "s");
                boolean z = false;
                if (s.length() == 0) {
                    imageView2 = TestSmsActivity.this.clearCaptcha;
                    Intrinsics.checkNotNull(imageView2);
                    imageView2.setVisibility(8);
                } else {
                    imageView = TestSmsActivity.this.clearCaptcha;
                    Intrinsics.checkNotNull(imageView);
                    imageView.setVisibility(0);
                }
                tintButton = TestSmsActivity.this.mSubmitBtn;
                Intrinsics.checkNotNull(tintButton);
                editText3 = TestSmsActivity.this.mEtPhoneNum;
                Intrinsics.checkNotNull(editText3);
                if (!TextUtils.isEmpty(editText3.getText())) {
                    editText4 = TestSmsActivity.this.mEtCaptcha;
                    Intrinsics.checkNotNull(editText4);
                    if (!TextUtils.isEmpty(editText4.getText())) {
                        z = true;
                    }
                }
                tintButton.setEnabled(z);
            }
        });
        EditText editText3 = this.mEtPhoneNum;
        Intrinsics.checkNotNull(editText3);
        editText3.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: tv.danmaku.bili.testui.TestSmsActivity$$ExternalSyntheticLambda2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean listeners$lambda$0;
                listeners$lambda$0 = TestSmsActivity.setListeners$lambda$0(TestSmsActivity.this, textView, i, keyEvent);
                return listeners$lambda$0;
            }
        });
        EditText editText4 = this.mEtCaptcha;
        Intrinsics.checkNotNull(editText4);
        editText4.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: tv.danmaku.bili.testui.TestSmsActivity$$ExternalSyntheticLambda3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean listeners$lambda$1;
                listeners$lambda$1 = TestSmsActivity.setListeners$lambda$1(TestSmsActivity.this, textView, i, keyEvent);
                return listeners$lambda$1;
            }
        });
        EditText editText5 = this.mEtPhoneNum;
        Intrinsics.checkNotNull(editText5);
        editText5.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: tv.danmaku.bili.testui.TestSmsActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                TestSmsActivity.setListeners$lambda$2(TestSmsActivity.this, view, z);
            }
        });
        EditText editText6 = this.mEtCaptcha;
        Intrinsics.checkNotNull(editText6);
        editText6.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: tv.danmaku.bili.testui.TestSmsActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                TestSmsActivity.setListeners$lambda$3(TestSmsActivity.this, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setListeners$lambda$0(TestSmsActivity this$0, TextView v, int actionId, KeyEvent event) {
        if (actionId == 5) {
            EditText editText = this$0.mEtCaptcha;
            Intrinsics.checkNotNull(editText);
            editText.requestFocus();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setListeners$lambda$1(TestSmsActivity this$0, TextView v, int actionId, KeyEvent event) {
        if (actionId == 6) {
            SmsLoginPresenter smsLoginPresenter = this$0.mPresenter;
            Intrinsics.checkNotNull(smsLoginPresenter);
            smsLoginPresenter.submit("", "");
            this$0.hideSoftInput();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setListeners$lambda$2(TestSmsActivity this$0, View v, boolean hasFocus) {
        if (hasFocus) {
            ImageView imageView = this$0.clearCaptcha;
            Intrinsics.checkNotNull(imageView);
            imageView.setVisibility(8);
            EditText editText = this$0.mEtPhoneNum;
            Intrinsics.checkNotNull(editText);
            if (editText.getText().length() > 0) {
                ImageView imageView2 = this$0.clearPhoneNum;
                Intrinsics.checkNotNull(imageView2);
                imageView2.setVisibility(0);
                return;
            }
            ImageView imageView3 = this$0.clearPhoneNum;
            Intrinsics.checkNotNull(imageView3);
            imageView3.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setListeners$lambda$3(TestSmsActivity this$0, View v, boolean hasFocus) {
        if (hasFocus) {
            ImageView imageView = this$0.clearPhoneNum;
            Intrinsics.checkNotNull(imageView);
            imageView.setVisibility(8);
            EditText editText = this$0.mEtCaptcha;
            Intrinsics.checkNotNull(editText);
            if (editText.getText().length() > 0) {
                ImageView imageView2 = this$0.clearCaptcha;
                Intrinsics.checkNotNull(imageView2);
                imageView2.setVisibility(0);
                return;
            }
            ImageView imageView3 = this$0.clearCaptcha;
            Intrinsics.checkNotNull(imageView3);
            imageView3.setVisibility(8);
        }
    }

    private final void findViews() {
        this.mSelectedCountryNameView = (TextView) findViewById(R.id.selected_country_name);
        this.mSubmitBtn = findViewById(R.id.submit);
        this.mGetCaptcha = (TextView) findViewById(R.id.get_auth_code);
        this.mLoginAgreementText = (TextView) findViewById(R.id.tv_login_agreement);
        this.mLoginCheckHelpText = (TextView) findViewById(R.id.tv_check_help);
        this.mAreaCodeView = (TextView) findViewById(R.id.area_code);
        this.mEtPhoneNum = (EditText) findViewById(R.id.et_phone_number);
        this.mEtCaptcha = (EditText) findViewById(R.id.et_capture);
        this.clearPhoneNum = (ImageView) findViewById(R.id.clear_phonenum);
        this.clearPhoneLayout = findViewById(R.id.clear_phonenum_layout);
        this.clearCaptcha = (ImageView) findViewById(R.id.clear_captcha);
        this.clearCaptchaLayout = findViewById(R.id.clear_captcha_layout);
        TextView textView = this.mSelectedCountryNameView;
        Intrinsics.checkNotNull(textView);
        textView.setOnClickListener(this);
        TintButton tintButton = this.mSubmitBtn;
        Intrinsics.checkNotNull(tintButton);
        tintButton.setOnClickListener(this);
        TextView textView2 = this.mGetCaptcha;
        Intrinsics.checkNotNull(textView2);
        textView2.setOnClickListener(this);
        View view = this.clearPhoneLayout;
        Intrinsics.checkNotNull(view);
        view.setOnClickListener(this);
        View view2 = this.clearCaptchaLayout;
        Intrinsics.checkNotNull(view2);
        view2.setOnClickListener(this);
    }

    /* compiled from: TestSmsActivity.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/testui/TestSmsActivity$CaptchaFilter;", "Landroid/text/InputFilter$LengthFilter;", "<init>", "()V", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "Companion", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CaptchaFilter extends InputFilter.LengthFilter {
        private static final int DEFAULT_MAX_LENGTH = 8;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        public CaptchaFilter() {
            super(8);
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(dest, "dest");
            if (Intrinsics.areEqual(source, " ")) {
                return "";
            }
            return null;
        }

        /* compiled from: TestSmsActivity.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/testui/TestSmsActivity$CaptchaFilter$Companion;", "", "<init>", "()V", "DEFAULT_MAX_LENGTH", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public void replyWithGeeCaptcha(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "param");
        sendSmsWithGeeCaptcha(map);
    }

    public void replyWithImageCaptcha(int callbackId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "param");
        sendSmsWithImageCaptcha(callbackId, map);
    }

    public void closeCaptchaDialog() {
        hideCaptchaDialog();
    }
}