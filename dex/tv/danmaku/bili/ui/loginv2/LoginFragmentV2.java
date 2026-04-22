package tv.danmaku.bili.ui.loginv2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bili.resource.common.R;
import com.bilibili.api.BiliConfig;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.H5UrlConfigHelper;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.droid.StringUtil;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.pvtracker.IPvTracker;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.eula.LoginEulaDialog;
import tv.danmaku.bili.normal.ui.EulaTriggerType;
import tv.danmaku.bili.reg.LoginRegHelper;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.sms.SmsLoginDialogUtilKt;
import tv.danmaku.bili.ui.AgreementLinkHelper;
import tv.danmaku.bili.ui.account.registerfast.RegisterActivityTrigger;
import tv.danmaku.bili.ui.login.FindPasswordDialog;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.login.ResizeLayout;
import tv.danmaku.bili.ui.login.ToastAnimationHelper;
import tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2;

public class LoginFragmentV2 extends BaseLoginFragmentV2 implements ResizeLayout.OnSizeChangedListener, FindPasswordDialog.OnItemClickListener, View.OnClickListener, IPvTracker {
    public static final int REQ_CODE_FIND_PWD_H5 = 20001;
    public static final String TAG = "LoginFragmentV2";
    public static final String URL_FIND_PASSWORD = "https://passport.bilibili.com/h5-app/passport/login/findPassword?navhide=1&type=onlyEmail";
    private final String URL_FIND_PASSWORD_NO_SMS = "https://passport.bilibili.com/h5-app/passport/login/findPassword?navhide=1";
    ImageView imageView22;
    ImageView imageView33;
    private boolean loginExperiment;
    private String loginExperimentValue;
    FindPasswordDialog mFindPasswordDialog;
    private boolean mHideSmsEnter;
    private String mPromptScene;
    private View mToastView;
    ResizeLayout resizeLayout;
    ScrollView scrollView;
    View tipsLayout;

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    public static LoginFragmentV2 newInstance(boolean hideSmsEnter, String promptScene) {
        LoginFragmentV2 fragment = new LoginFragmentV2();
        Bundle args = new Bundle();
        args.putBoolean("hide_sms_enter", hideSmsEnter);
        args.putString(LoginOriginalActivityV2.KEY_PROMPT_SCENE, promptScene);
        fragment.setArguments(args);
        return fragment;
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        BaseToolbarActivity activity = getActivity();
        if (activity instanceof BaseToolbarActivity) {
            activity.getSupportActionBar().setTitle(R.string.common_global_string_290);
        }
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.mHideSmsEnter = bundle.getBoolean("hide_sms_enter", false);
            this.mPromptScene = bundle.getString(LoginOriginalActivityV2.KEY_PROMPT_SCENE);
            this.loginExperiment = BundleUtil.getBoolean(bundle, LoginOriginalActivityV2.KEY_LOGIN_EXPERIMENT, new boolean[]{false});
            setLoginExperimentValue(BundleUtil.getString(bundle, LoginOriginalActivityV2.KEY_LOGIN_EXPERIMENT_VALUE, new String[0]));
            setPromptScene(this.mPromptScene);
        }
        BLog.i(TAG, "onCreate mHideSmsEnter = " + this.mHideSmsEnter);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        if (!this.mHideSmsEnter) {
            MenuItem item = menu.add(0, 16908313, 0, bili.resource.account.R.string.account_global_string_14);
            item.setShowAsAction(2);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908313) {
            LoginOriginalActivityV2 loginActivity = getLoginActivity();
            if (loginActivity != null) {
                loginActivity.jumpFragment(SmsLoginFragmentV2.TAG);
            }
            LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_SMS_0_CLICK, LoginReporterV2.generateSingleParamMaps(LoginReporterV2.PAGE_FROM_KEY, "1"));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    protected View onCreateLayout(LayoutInflater inflater, ViewGroup container, Bundle b) {
        View view = inflater.inflate(com.bilibili.app.accountui.R.layout.bili_app_fragmant_login, container, false);
        this.imageView22 = (ImageView) view.findViewById(com.bilibili.app.accountui.R.id.ic_22);
        this.imageView33 = (ImageView) view.findViewById(com.bilibili.app.accountui.R.id.ic_33);
        this.resizeLayout = (ResizeLayout) view.findViewById(com.bilibili.app.accountui.R.id.root_layout);
        this.scrollView = (ScrollView) view.findViewById(com.bilibili.app.accountui.R.id.scroll_view);
        this.tipsLayout = view.findViewById(com.bilibili.app.accountui.R.id.tips_layout);
        view.findViewById(com.bilibili.app.accountui.R.id.btn_forget_passport).setOnClickListener(this);
        return view;
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.resizeLayout.setOnSizeChangedListener(this);
        LoginOriginalActivityV2 loginActivity = getLoginActivity();
        if (loginActivity != null) {
            loginActivity.setTitle(getString(bili.resource.account.R.string.account_global_string_17));
        }
        view.post(new Runnable() { // from class: tv.danmaku.bili.ui.loginv2.LoginFragmentV2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LoginFragmentV2.this.m1825lambda$onViewCreated$0$tvdanmakubiliuiloginv2LoginFragmentV2(view);
            }
        });
        showToastIfNeed(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onViewCreated$0$tv-danmaku-bili-ui-loginv2-LoginFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1825lambda$onViewCreated$0$tvdanmakubiliuiloginv2LoginFragmentV2(View view) {
        try {
            this.userNameEt.requestFocus();
        } catch (Exception e) {
            BLog.d(TAG, "requestFocus exception = " + e.getMessage());
        }
        this.userNameEt.dismissDropDown();
        InputMethodManagerHelper.showSoftInput(view.getContext(), this.userNameEt, 1);
    }

    protected void showToastIfNeed(View view) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            String toast = bundle.getString(LoginOriginalActivityV2.KEY_TOAST);
            if (StringUtil.isNotBlank(toast)) {
                if (this.mToastView == null) {
                    ViewStub vs = (ViewStub) view.findViewById(com.bilibili.app.accountui.R.id.login_tips);
                    this.mToastView = vs.inflate();
                    ((TextView) this.mToastView.findViewById(com.bilibili.app.accountui.R.id.toast_content)).setText(toast);
                }
                ToastAnimationHelper.animate(this.mToastView);
            }
        }
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    protected boolean checkLoginAgreement(final String name, final String pwd) {
        if (LoginRegHelper.checkViewVisibleAndUnCheck(this.mLoginRegCheckBox)) {
            if (SmsLoginDialogUtilKt.getShowEulaDialog()) {
                LoginEulaDialog dialog = new LoginEulaDialog();
                dialog.show(getChildFragmentManager(), LoginReporterV2.PAGE_TYPE_PWD, false, EulaTriggerType.Submit, EulaTriggerType.Submit.getBtnId(), (String) null, new Function0() { // from class: tv.danmaku.bili.ui.loginv2.LoginFragmentV2$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        return LoginFragmentV2.this.m1824lambda$checkLoginAgreement$1$tvdanmakubiliuiloginv2LoginFragmentV2(name, pwd);
                    }
                }, new Function0() { // from class: tv.danmaku.bili.ui.loginv2.LoginFragmentV2$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                }, (AgreementLinkHelper.ClickLinkItemListener) this);
                return true;
            }
            LoginRegHelper.INSTANCE.showRegPopView(getContext(), this.mLoginRegPopView);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$checkLoginAgreement$1$tv-danmaku-bili-ui-loginv2-LoginFragmentV2  reason: not valid java name */
    public /* synthetic */ Unit m1824lambda$checkLoginAgreement$1$tvdanmakubiliuiloginv2LoginFragmentV2(String name, String pwd) {
        this.loginHandler.login(name, pwd, needSuccessToast());
        if (this.mLoginRegCheckBox != null) {
            this.mLoginRegCheckBox.setChecked(true);
        }
        LoginRegHelper.reportRegCheckboxClick(LoginReporterV2.Click.CLICK_PROVISION_PWD_LOGIN, this.mLoginRegCheckBox);
        return Unit.INSTANCE;
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    public void onDestroyView() {
        super.onDestroyView();
        this.imageView22 = null;
        this.imageView33 = null;
        this.resizeLayout = null;
        this.scrollView = null;
        this.tipsLayout = null;
    }

    public String getPvEventId() {
        return LoginReporterV2.PV.APP_PWD_LOGIN_0_0_PV;
    }

    public Bundle getPvExtra() {
        Context context = getContext();
        if (context == null) {
            return new Bundle();
        }
        Bundle bundle = LoginReportHelper.buildCommonBundle();
        bundle.putString(LoginReporterV2.PAGE_FROM_KEY, "1");
        bundle.putString(LoginReporterV2.SHOW_PROVISION_KEY, LoginRegHelper.getProvisionReportValue(context));
        return bundle;
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    public void onClickRegister() {
        super.onClickRegister();
        RegisterActivityTrigger.launchRegisterV2(this, this.mHideSmsEnter);
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    protected void reportClickLogin() {
        Map<String, String> map = LoginReporterV2.generateSingleParamMaps(LoginReporterV2.PAGE_FROM_KEY, "1");
        LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_LOGIN_0_CLICK, LoginRegHelper.getClickReportInfoValue(LoginRegHelper.getProvisionReportValue(getContext()), LoginRegHelper.getAgreeReportValue(this.mLoginRegCheckBox), map));
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    protected void onItemLinkClickAgreement() {
        super.onItemLinkClickAgreement();
        LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_PACT_AGREEMENT_CLICK, LoginReporterV2.generateSingleParamMaps(LoginReporterV2.PAGE_FROM_KEY, "1"));
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    protected void onItemLinkClickPrivacy() {
        super.onItemLinkClickPrivacy();
        LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_PACT_PRIVACY_CLICK, LoginReporterV2.generateSingleParamMaps(LoginReporterV2.PAGE_FROM_KEY, "1"));
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    public void onDestroy() {
        super.onDestroy();
        this.imageView22 = null;
        this.imageView33 = null;
        this.resizeLayout = null;
        this.scrollView = null;
        this.tipsLayout = null;
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    public void onFocusChange(View v, boolean hasFocus) {
        int id = v.getId();
        if (id == com.bilibili.app.accountui.R.id.username) {
            if (hasFocus) {
                setFocusImage(false);
            }
        } else if (id == com.bilibili.app.accountui.R.id.userpwd) {
            if (hasFocus) {
                setFocusImage(true);
            }
        } else {
            setFocusImage(false);
        }
    }

    @Override // tv.danmaku.bili.ui.login.ResizeLayout.OnSizeChangedListener
    public void onSizeChanged(final int oldh, final int h) {
        if (h - oldh < 0 && this.scrollView != null) {
            this.scrollView.post(new Runnable() { // from class: tv.danmaku.bili.ui.loginv2.LoginFragmentV2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LoginFragmentV2.this.scrollView == null) {
                        return;
                    }
                    LoginFragmentV2.this.scrollView.smoothScrollBy(0, Math.abs(h - oldh));
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == com.bilibili.app.accountui.R.id.btn_forget_passport) {
            if (!this.mHideSmsEnter) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    Window window = activity.getWindow();
                    if (window != null) {
                        InputMethodManagerHelper.hideSoftInput(activity, window.getDecorView(), 2);
                    }
                    if (this.mFindPasswordDialog == null) {
                        this.mFindPasswordDialog = new FindPasswordDialog(activity, this);
                    }
                    if (!this.mFindPasswordDialog.isShowing()) {
                        this.mFindPasswordDialog.show();
                    }
                }
            } else {
                String baseUrl = H5UrlConfigHelper.INSTANCE.getUrl("account_ui", "url_find_pwd_no_sms", "https://passport.bilibili.com/h5-app/passport/login/findPassword?navhide=1");
                StringBuilder findPwdNoSmsUrlBuilder = new StringBuilder(baseUrl).append(BiliConfig.getAppKey());
                BLog.i(TAG, "onClick forget password url = " + ((Object) findPwdNoSmsUrlBuilder));
                BLRouter.routeTo(new RouteRequest.Builder(Uri.parse(findPwdNoSmsUrlBuilder.toString())).requestCode((int) REQ_CODE_FIND_PWD_H5).build(), this);
            }
            LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_FORGOT_0_CLICK);
        }
    }

    @Override // tv.danmaku.bili.ui.login.FindPasswordDialog.OnItemClickListener
    public void onSelected(int itemId) {
        switch (itemId) {
            case 1:
                LoginOriginalActivityV2 loginActivity = getLoginActivity();
                if (loginActivity != null) {
                    loginActivity.jumpFragment(SmsLoginFragmentV2.TAG);
                    return;
                }
                return;
            case 2:
                this.mAnyRegFlag = true;
                String url = H5UrlConfigHelper.INSTANCE.getUrl("account_ui", "url_find_password", URL_FIND_PASSWORD);
                BLRouter.routeTo(new RouteRequest.Builder(Uri.parse(url)).build(), getContext());
                return;
            default:
                return;
        }
    }

    public LoginOriginalActivityV2 getLoginActivity() {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof LoginOriginalActivityV2)) {
            return (LoginOriginalActivityV2) activity;
        }
        return null;
    }

    public void onPressEnterKey() {
        if (this.loginButton != null) {
            this.loginButton.performClick();
        }
    }

    private void setFocusImage(boolean hide) {
        if (this.imageView22 != null) {
            if (hide) {
                this.imageView22.setImageResource(com.bilibili.app.accountui.R.drawable.ic_22_hide);
            } else {
                this.imageView22.setImageResource(com.bilibili.app.accountui.R.drawable.ic_22);
            }
        }
        if (this.imageView33 != null) {
            if (hide) {
                this.imageView33.setImageResource(com.bilibili.app.accountui.R.drawable.ic_33_hide);
            } else {
                this.imageView33.setImageResource(com.bilibili.app.accountui.R.drawable.ic_33);
            }
        }
    }

    @Override // tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (getActivity() != null && requestCode == 20001 && resultCode == -1) {
            onLoginSuccess();
        }
    }
}