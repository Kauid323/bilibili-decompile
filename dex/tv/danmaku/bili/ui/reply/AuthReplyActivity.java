package tv.danmaku.bili.ui.reply;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.bilibili.api.BiliApiException;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.okretro.BiliApiDataCallback;
import java.io.IOException;
import tv.danmaku.bili.api.BiliAuthServiceHelper;
import tv.danmaku.bili.api.bean.ConfirmZhiMaBean;
import tv.danmaku.bili.cb.AuthResultCbMsg;
import tv.danmaku.bili.report.AuthReportHelper;

public class AuthReplyActivity extends BaseToolbarActivity {
    private static final int CONFIRM_AUTH_EXCEPTION_CODE = 74012;
    private AuthFailFragment mAuthFailFragment;
    private AuthReplyObservable mAuthReplyObservable;
    private AuthSuccessFragment mAuthSuccessFragment;
    private TintProgressDialog mProgressDialog;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_activity_with_toolbar);
        getSupportActionBar().setTitle(bili.resource.account.R.string.account_global_string_285);
        showBackButton();
        if (savedInstanceState != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            this.mAuthFailFragment = fragmentManager.findFragmentByTag(AuthFailFragment.TAG);
            this.mAuthSuccessFragment = fragmentManager.findFragmentByTag(AuthSuccessFragment.TAG);
        }
        this.mAuthReplyObservable = new AuthReplyObservable();
        loadReplyResult();
        AuthReportHelper.report(AuthReportHelper.Event.obtainShow("realname_mayiback_show"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showProgressDialog(String message) {
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new TintProgressDialog(this);
            this.mProgressDialog.setIndeterminate(true);
            this.mProgressDialog.setCancelable(true);
        }
        this.mProgressDialog.setMessage(message);
        if (!this.mProgressDialog.isShowing()) {
            this.mProgressDialog.show();
        }
    }

    public void dismissProgress() {
        if (!isFinishing() && this.mProgressDialog != null && this.mProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void loadReplyResult() {
        if (BiliAccounts.get(this).isLogin()) {
            showProgressDialog(getString(bili.resource.account.R.string.account_global_string_225));
            String accessToken = BiliAccounts.get(BiliContext.application()).getAccessKey();
            BiliAuthServiceHelper.getBiliPassportServiceHelper().confirmAliAuth(accessToken, new BiliApiDataCallback<ConfirmZhiMaBean>() { // from class: tv.danmaku.bili.ui.reply.AuthReplyActivity.1
                public final String REPORT_ERROR_CONFIRM_NO_PASS = "0";
                public final String REPORT_ERROR_CONFIRM_NO_BACK = "1";
                public final String REPORT_ERROR_CONFIRM_NET = "2";
                public final String REPORT_ERROR_CONFIRM_SERVER = "3";
                public final String REPORT_ERROR_CONFIRM_OTHER = "4";

                public void onDataSuccess(ConfirmZhiMaBean data) {
                    AuthReplyActivity.this.dismissProgress();
                    if (data != null) {
                        if (data.passed == 1) {
                            if (AuthReplyActivity.this.mAuthSuccessFragment == null) {
                                AuthReplyActivity.this.mAuthSuccessFragment = new AuthSuccessFragment();
                                AuthReplyActivity.this.getSupportFragmentManager().beginTransaction().add(com.bilibili.base.R.id.content_layout, AuthReplyActivity.this.mAuthSuccessFragment, AuthSuccessFragment.TAG).commitAllowingStateLoss();
                            } else {
                                AuthReplyActivity.this.getSupportFragmentManager().beginTransaction().show(AuthReplyActivity.this.mAuthSuccessFragment).commitAllowingStateLoss();
                            }
                            if (AuthReplyActivity.this.mAuthReplyObservable != null) {
                                AuthReplyActivity.this.mAuthReplyObservable.receiveReplyEvent(new AuthResultCbMsg(1));
                                return;
                            }
                            return;
                        }
                        AuthReportHelper.report(AuthReportHelper.Event.obtainShow("realname_failure_errtype", "0"));
                        if (AuthReplyActivity.this.mAuthFailFragment == null) {
                            AuthReplyActivity.this.mAuthFailFragment = AuthFailFragment.newInstance(data.reason);
                            AuthReplyActivity.this.getSupportFragmentManager().beginTransaction().add(com.bilibili.base.R.id.content_layout, AuthReplyActivity.this.mAuthFailFragment, AuthFailFragment.TAG).commitAllowingStateLoss();
                        } else {
                            AuthReplyActivity.this.getSupportFragmentManager().beginTransaction().show(AuthReplyActivity.this.mAuthFailFragment).commitAllowingStateLoss();
                        }
                        if (AuthReplyActivity.this.mAuthReplyObservable != null) {
                            AuthReplyActivity.this.mAuthReplyObservable.receiveReplyEvent(new AuthResultCbMsg(0, data.reason));
                            return;
                        }
                        return;
                    }
                    onError(null);
                }

                public void onError(Throwable t) {
                    if (t != null) {
                        report(t);
                    }
                    AuthReplyActivity.this.dismissProgress();
                    if (AuthReplyActivity.this.mAuthFailFragment == null) {
                        AuthReplyActivity.this.mAuthFailFragment = AuthFailFragment.newInstance(AuthReplyActivity.this.getString(bili.resource.account.R.string.account_global_string_208));
                        AuthReplyActivity.this.getSupportFragmentManager().beginTransaction().add(com.bilibili.base.R.id.content_layout, AuthReplyActivity.this.mAuthFailFragment, AuthFailFragment.TAG).commitAllowingStateLoss();
                    } else {
                        AuthReplyActivity.this.getSupportFragmentManager().beginTransaction().show(AuthReplyActivity.this.mAuthFailFragment).commitAllowingStateLoss();
                    }
                    if (AuthReplyActivity.this.mAuthReplyObservable != null) {
                        AuthReplyActivity.this.mAuthReplyObservable.receiveReplyEvent(new AuthResultCbMsg(0, AuthReplyActivity.this.getString(bili.resource.account.R.string.account_global_string_208)));
                    }
                }

                public boolean isCancel() {
                    return AuthReplyActivity.this.isFinishing() || AuthReplyActivity.this.isDestroyCalled();
                }

                private void report(Throwable t) {
                    if (t instanceof BiliApiException) {
                        if (AuthReplyActivity.CONFIRM_AUTH_EXCEPTION_CODE == ((BiliApiException) t).mCode) {
                            AuthReportHelper.report(AuthReportHelper.Event.obtainShow("realname_failure_errtype", "1"));
                        } else if (-444 == ((BiliApiException) t).mCode || -500 == ((BiliApiException) t).mCode || -501 == ((BiliApiException) t).mCode) {
                            AuthReportHelper.report(AuthReportHelper.Event.obtainShow("realname_failure_errtype", "3"));
                        } else {
                            AuthReportHelper.report(AuthReportHelper.Event.obtainShow("realname_failure_errtype", "4"));
                        }
                    } else if (t instanceof IOException) {
                        AuthReportHelper.report(AuthReportHelper.Event.obtainShow("realname_failure_errtype", "2"));
                    } else {
                        AuthReportHelper.report(AuthReportHelper.Event.obtainShow("realname_failure_errtype", "4"));
                    }
                }
            });
            return;
        }
        ToastHelper.showToastShort(this, bili.resource.account.R.string.account_global_string_209);
        finish();
    }
}