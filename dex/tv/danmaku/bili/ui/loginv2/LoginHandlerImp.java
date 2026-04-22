package tv.danmaku.bili.ui.loginv2;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import bili.resource.account.R;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.VerifyBundle;
import com.bilibili.lib.accountsui.LoginCallback;
import com.bilibili.lib.accountsui.captcha.CaptchaDialog;
import com.bilibili.lib.accountsui.password.IPasswordLoginPresenter;
import com.bilibili.lib.accountsui.password.IPasswordLoginReporter;
import com.bilibili.lib.accountsui.password.IPasswordLoginView;
import com.bilibili.lib.accountsui.password.PasswordLoginPresenter;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.ui.AccountReportHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.theme.BiliTheme;
import tv.danmaku.bili.ui.util.AccountUtils;

public class LoginHandlerImp implements ILoginHandler, IPasswordLoginView, IPasswordLoginReporter {
    private FragmentActivity context;
    private String loginExperimentValue = "";
    private CaptchaDialog mCaptchaDialog;
    private LoginCallback mLoginCallback;
    private IPasswordLoginPresenter mPresenter;
    private TintProgressDialog progressDialog;
    private String promptScene;

    public LoginHandlerImp(FragmentActivity context, LoginCallback loginCallback) {
        this.context = context;
        this.mLoginCallback = loginCallback;
        this.mPresenter = new PasswordLoginPresenter(context, this, this);
    }

    public void showCaptchaDialog(String url, int errCode, String errMsg) {
        BLog.i(BaseLoginFragmentV2.TAG, "showCaptchaDialog url = " + url + " ,errCode = " + errCode + " ,errMsg = " + errMsg);
        if (this.mCaptchaDialog == null || !this.mCaptchaDialog.isShowing()) {
            this.mCaptchaDialog = new CaptchaDialog(this.context, url, BiliTheme.isNightTheme(this.context));
            if (!this.context.isFinishing()) {
                this.mCaptchaDialog.show();
                return;
            }
            return;
        }
        this.mCaptchaDialog.imageCaptchaError(errCode, errMsg);
        AccountReportHelper.report(AccountReportHelper.Event.obtainClick(AccountReportHelper.EventID.LOGIN_SUBMIT_CLICK, "2", "code " + errCode));
    }

    public void hideCaptchaDialog() {
        if (this.mCaptchaDialog != null) {
            this.mCaptchaDialog.dismiss();
            this.mCaptchaDialog = null;
        }
    }

    public void tryNotifyImageCaptchaSuccess() {
        BLog.i(BaseLoginFragmentV2.TAG, "tryNotifyImageCaptchaSuccess");
        if (this.mCaptchaDialog != null && this.mCaptchaDialog.isShowing()) {
            this.mCaptchaDialog.imageCaptchaSuccess();
        }
    }

    public void showProgress() {
        if (this.progressDialog == null) {
            this.progressDialog = new TintProgressDialog(this.context);
            this.progressDialog.setMessage(this.context.getString(R.string.account_global_string_60));
            this.progressDialog.setIndeterminate(true);
            this.progressDialog.setCanceledOnTouchOutside(false);
        }
        if (!this.context.isFinishing()) {
            this.progressDialog.show();
        }
    }

    public void hideProgress() {
        if (this.progressDialog != null && this.progressDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
    }

    @Override // tv.danmaku.bili.ui.loginv2.ILoginHandler
    public void login(String user, String pwd, boolean showSuccessToast) {
        this.mPresenter.login(user, pwd, showSuccessToast);
    }

    public void alertVipStatusIfNeed() {
        AccountInfo myInfo;
        Context context = BiliContext.application();
        if (context != null && (myInfo = BiliAccountInfo.get().getAccountInfoFromCache()) != null && myInfo.getVipInfo() != null && myInfo.getVipInfo().isFrozen()) {
            ToastHelper.showToastLong(context, bili.resource.playerbaseres.R.string.playerbaseres_global_string_1303);
        }
    }

    @Override // tv.danmaku.bili.ui.loginv2.ILoginHandler
    public void onDestroy() {
        if (this.progressDialog != null && this.progressDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
    }

    @Override // tv.danmaku.bili.ui.loginv2.ILoginHandler
    public void onCreateView() {
        LoginReportHelper.setTrackParams(this.mPresenter);
    }

    @Override // tv.danmaku.bili.ui.loginv2.ILoginHandler
    public void setPromptScene(String promptScene) {
        this.promptScene = promptScene;
    }

    @Override // tv.danmaku.bili.ui.loginv2.ILoginHandler
    public void setLoginExperimentValue(String loginExperimentValue) {
        this.loginExperimentValue = loginExperimentValue;
    }

    public void loginWithGeeCaptcha(Map<String, String> innerMap) {
        hideCaptchaDialog();
        showProgress();
        this.mPresenter.login(innerMap, 3);
    }

    public void loginWithImageCaptcha(int callbackId, Map<String, String> param) {
        if (this.mCaptchaDialog != null && this.mCaptchaDialog.isShowing()) {
            this.mCaptchaDialog.setJsCallbackId(callbackId);
        }
        this.mPresenter.login(param, 2);
    }

    public void showTip(int resId) {
        ToastHelper.showToastShort(this.context, resId);
    }

    public void showTip(String message) {
        if (!TextUtils.isEmpty(message)) {
            ToastHelper.showToastShort(this.context, message);
        }
    }

    public boolean isActivityDie() {
        return this.context == null || this.context.isFinishing() || this.context.getSupportFragmentManager().isDestroyed();
    }

    public void onLoginSuccess() {
        if (this.mLoginCallback != null) {
            this.mLoginCallback.onLoginSuccess();
        }
    }

    public void onLoginIntercept(VerifyBundle verifyBundle) {
        if (this.mLoginCallback != null) {
            this.mLoginCallback.onLoginIntercept(verifyBundle);
        }
    }

    public void onGetLoginStatus(String code, Integer status) {
        Map<String, String> maps = new HashMap<>();
        maps.put(LoginReporterV2.Show.SIGNUP_KEY_CODE, code);
        if (!TextUtils.isEmpty(this.promptScene)) {
            maps.put("refer_click", this.promptScene);
        }
        if (status != null) {
            maps.put("login_status", String.valueOf(status));
        }
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_PWD_LOGIN_STATUS_0_SHOW, maps);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void onLoginSuccess(String type) {
        char c;
        HashMap<String, String> map = null;
        switch (type.hashCode()) {
            case BR.banner /* 49 */:
                if (type.equals("1")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case BR.bannerControl /* 50 */:
                if (type.equals("2")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case BR.bannerItemDataList /* 51 */:
                if (type.equals("3")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                map = LoginReporterV2.generateSingleParamMaps("method", "1");
                break;
            case 1:
                map = LoginReporterV2.generateSingleParamMaps("method", "3");
                break;
            case 2:
                map = LoginReporterV2.generateSingleParamMaps("method", "2");
                break;
        }
        if (map != null) {
            map.put("scene", this.loginExperimentValue);
            LoginReporterV2.Show.report(LoginReporterV2.Show.APP_LOGIN_SUCCEED_0_SHOW, map);
        }
    }

    public String getPagePv() {
        return this.promptScene;
    }

    public String getRouteUri() {
        return AccountUtils.getRouterFrom(this.context);
    }
}