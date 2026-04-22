package tv.danmaku.bili.ui.loginv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.ActivityCompat$;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import bolts.CancellationTokenSource;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.animation.ShakeAnimator;
import com.bilibili.animation.YoYo;
import com.bilibili.app.accountui.R;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.VerifyBundle;
import com.bilibili.lib.accountsui.AutoCompleteAdapter;
import com.bilibili.lib.accountsui.AutoCompleteHelper;
import com.bilibili.lib.accountsui.LoginCallback;
import com.bilibili.lib.accountsui.captcha.JsBridgeCallHandlerSecure;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.helper.LoginLifecycleObserver;
import tv.danmaku.bili.helper.LoginSuccessProcessorKt;
import tv.danmaku.bili.helper.LoginUIType;
import tv.danmaku.bili.normal.ui.RouteUtilKt;
import tv.danmaku.bili.reg.ILoginReg;
import tv.danmaku.bili.reg.LoginRegHelper;
import tv.danmaku.bili.ui.AccountReportHelper;
import tv.danmaku.bili.ui.AgreementLinkHelper;
import tv.danmaku.bili.ui.account.register.RegisterSuccessActivity;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.loginv2.ILoginHandler;
import tv.danmaku.bili.utils.UiUtils;

public abstract class BaseLoginFragmentV2 extends BaseFragment implements LoginCallback, AgreementLinkHelper.ClickLinkItemListener, JsBridgeCallHandlerSecure.CaptchaCallback {
    public static final int REQ_CODE_ANSWER = 204;
    public static final int REQ_CODE_FORGET = 203;
    public static final int REQ_CODE_SECOND_VERIFY = 205;
    public static final String TAG = "BaseLoginFragmentV2";
    protected AgreementLinkHelper agreementLinkHelper;
    ImageView clearName;
    View clearNameLayout;
    View clearPassLayout;
    ImageView clearPassword;
    AutoCompleteAdapter completeAdapter;
    protected TextView loginAgreementText;
    View loginButton;
    TextView loginCheckHelpText;
    ILoginHandler loginHandler;
    private CancellationTokenSource mAnswerToken;
    protected boolean mAnyRegFlag;
    private String mLoginExperimentValue;
    protected CheckBox mLoginRegCheckBox;
    protected View mLoginRegCheckBoxContainer;
    protected View mLoginRegPopView;
    private CancellationTokenSource mRegisterToken;
    AutoCompleteHelper.UserLoginInfo mUserLoginInfo;
    View registerButton;
    AutoCompleteTextView userNameEt;
    EditText userPwdEt;
    private final int MAX_SHOW_AUTO_ITEMS = 4;
    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.btn_login) {
                BaseLoginFragmentV2.this.onClickLogin();
            } else if (id == R.id.btn_register) {
                BaseLoginFragmentV2.this.onClickRegister();
            } else if (id == R.id.clear_name_layout) {
                BaseLoginFragmentV2.this.onClickClearName();
            } else if (id == R.id.clear_pwd_layout) {
                BaseLoginFragmentV2.this.onClickClearPassword();
            } else if (id == R.id.username) {
                BaseLoginFragmentV2.this.onClickUserName();
            } else if (v.getId() == R.id.login_reg_pop) {
                BaseLoginFragmentV2.this.onClickRegPop();
            } else if (v.getId() == R.id.tv_login_agreement) {
                BaseLoginFragmentV2.this.onClickAgreementTv();
            } else if (v.getId() == R.id.log_reg_checkbox_container) {
                BaseLoginFragmentV2.this.onClickAgreementTv();
            }
        }
    };
    View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View v, boolean hasFocus) {
            BaseLoginFragmentV2.this.onFocusChange(v, hasFocus);
            int id = v.getId();
            if (id == R.id.username) {
                if (hasFocus) {
                    BaseLoginFragmentV2.this.clearPassword.setVisibility(8);
                    if (BaseLoginFragmentV2.this.userNameEt.getText().length() > 0) {
                        BaseLoginFragmentV2.this.clearName.setVisibility(0);
                    } else {
                        BaseLoginFragmentV2.this.clearName.setVisibility(8);
                    }
                }
            } else if (id == R.id.userpwd && hasFocus) {
                BaseLoginFragmentV2.this.clearName.setVisibility(8);
                if (BaseLoginFragmentV2.this.userPwdEt.getText().length() > 0) {
                    BaseLoginFragmentV2.this.clearPassword.setVisibility(0);
                } else {
                    BaseLoginFragmentV2.this.clearPassword.setVisibility(8);
                }
            }
        }
    };
    Filter.FilterListener filterListener = new Filter.FilterListener() { // from class: tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2$$ExternalSyntheticLambda0
        @Override // android.widget.Filter.FilterListener
        public final void onFilterComplete(int i) {
            BaseLoginFragmentV2.this.m1815lambda$new$0$tvdanmakubiliuiloginv2BaseLoginFragmentV2(i);
        }
    };

    protected abstract View onCreateLayout(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public abstract void onFocusChange(View view, boolean z);

    private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(Object activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
            Thread thread = Thread.currentThread();
            if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                IllegalStateException exp = new IllegalStateException("Activity.finish() called from non-UI thread: " + thread + ", 请联系 Jackin");
                BLog.e("BgThreadUIAccess", "Activity.finish() called from non-UI thread: " + thread, exp);
                Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new ActivityCompat$.ExternalSyntheticLambda0());
                if (BuildConfig.DEBUG) {
                    throw exp;
                }
            }
        }
        ((Activity) activity).finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$tv-danmaku-bili-ui-loginv2-BaseLoginFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1815lambda$new$0$tvdanmakubiliuiloginv2BaseLoginFragmentV2(int count) {
        if (count > 4) {
            this.userNameEt.setDropDownHeight(UiUtils.dp2px(getContext(), 140.0f));
        } else {
            this.userNameEt.setDropDownHeight(-2);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        this.loginHandler = ILoginHandler.CC.getHandler(activity, this);
        this.completeAdapter = new AutoCompleteAdapter(activity);
        this.agreementLinkHelper = new AgreementLinkHelper(activity);
        getLifecycle().addObserver(LoginLifecycleObserver.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPromptScene(String promptScene) {
        if (this.loginHandler != null) {
            this.loginHandler.setPromptScene(promptScene);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLoginExperimentValue(String loginExperimentValue) {
        if (this.loginHandler != null) {
            this.loginHandler.setLoginExperimentValue(loginExperimentValue);
        }
        this.mLoginExperimentValue = loginExperimentValue;
    }

    public void onDestroy() {
        this.loginHandler.onDestroy();
        if (this.mAnswerToken != null) {
            this.mAnswerToken.cancel();
        }
        if (this.mRegisterToken != null) {
            this.mRegisterToken.cancel();
        }
        super.onDestroy();
        getLifecycle().removeObserver(LoginLifecycleObserver.INSTANCE);
    }

    public void onDestroyView() {
        super.onDestroyView();
        LoginRegHelper.clearOnChangeListener(this.mLoginRegCheckBox);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.loginHandler != null) {
            this.loginHandler.onCreateView();
        }
        return onCreateLayout(inflater, container, savedInstanceState);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.userNameEt = (AutoCompleteTextView) view.findViewById(R.id.username);
        this.userPwdEt = (EditText) view.findViewById(R.id.userpwd);
        this.clearName = (ImageView) view.findViewById(R.id.clear_name);
        this.clearPassword = (ImageView) view.findViewById(R.id.clear_pwd);
        this.loginButton = view.findViewById(R.id.btn_login);
        this.registerButton = view.findViewById(R.id.btn_register);
        this.loginAgreementText = (TextView) view.findViewById(R.id.tv_login_agreement);
        this.loginCheckHelpText = (TextView) view.findViewById(R.id.tv_check_help);
        this.clearNameLayout = view.findViewById(R.id.clear_name_layout);
        this.clearPassLayout = view.findViewById(R.id.clear_pwd_layout);
        this.mLoginRegPopView = view.findViewById(R.id.login_reg_pop);
        this.mLoginRegCheckBox = (CheckBox) view.findViewById(R.id.log_reg_checkbox);
        this.mLoginRegCheckBoxContainer = view.findViewById(R.id.log_reg_checkbox_container);
        this.userNameEt.setOnFocusChangeListener(this.onFocusChangeListener);
        this.userPwdEt.setOnFocusChangeListener(this.onFocusChangeListener);
        this.loginButton.setOnClickListener(this.onClickListener);
        this.registerButton.setOnClickListener(this.onClickListener);
        this.clearNameLayout.setOnClickListener(this.onClickListener);
        this.clearPassLayout.setOnClickListener(this.onClickListener);
        this.mLoginRegPopView.setOnClickListener(this.onClickListener);
        this.loginAgreementText.setOnClickListener(this.onClickListener);
        this.mLoginRegCheckBoxContainer.setOnClickListener(this.onClickListener);
        addTextWatcher();
        addActionListener();
        updateRegInfo(view);
        this.userNameEt.setAdapter(this.completeAdapter);
        this.mUserLoginInfo = AutoCompleteHelper.getUserLoginInfo(getContext());
        if (this.mUserLoginInfo != null && !TextUtils.isEmpty(this.mUserLoginInfo.mUserName)) {
            this.userNameEt.setText(this.mUserLoginInfo.mUserName);
            this.userNameEt.setSelection(this.mUserLoginInfo.mUserName.length());
            this.userNameEt.dismissDropDown();
        }
        ThemeUtils.tintDrawable(this.clearName.getBackground(), getResources().getColor(com.bilibili.lib.theme.R.color.Ga0));
        ThemeUtils.tintDrawable(this.clearPassword.getBackground(), getResources().getColor(com.bilibili.lib.theme.R.color.Ga0));
    }

    public void onResume() {
        super.onResume();
        LoginRegHelper.initOnChangeListener(this.mLoginRegCheckBox);
        if (LoginOriginalActivityV2.GO_OTHER_PAGE_FLAG && (!this.mAnyRegFlag || !LoginRegHelper.isAnyPageLoginReg())) {
            LoginOriginalActivityV2.GO_OTHER_PAGE_FLAG = false;
            LoginRegHelper.updateRegCheckbox(this.mLoginRegCheckBox, this.mLoginRegCheckBoxContainer);
        }
        this.mAnyRegFlag = false;
    }

    public void updateRegInfo(View view) {
        String subTips;
        ILoginReg loginReg = LoginRegHelper.INSTANCE.getLoginRegStrategy();
        if (loginReg.showReg(getContext())) {
            subTips = getString(bili.resource.account.R.string.account_global_string_181);
        } else {
            subTips = getString(bili.resource.account.R.string.account_global_string_142);
        }
        this.agreementLinkHelper.attachLinkContentAgreement(this.loginAgreementText, subTips, ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Lb6), this);
        this.agreementLinkHelper.attachLinkContentHelp(this.loginCheckHelpText, getString(bili.resource.account.R.string.account_global_string_49), this, ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Lb6));
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        BLog.i(TAG, "onActivityResult requestCode = " + requestCode + " , resultCode = " + resultCode);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (requestCode == 203 && resultCode == -1) {
            activity.setResult(-1);
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
        } else if (requestCode == 1001 && resultCode == -1) {
            activity.setResult(-1);
            startActivityForResult(RegisterSuccessActivity.createIntent(activity), 204);
        } else if (requestCode == 204) {
            if (this.mAnswerToken != null) {
                this.mAnswerToken.cancel();
            }
            this.mAnswerToken = requestMyinfo(this);
        } else if (requestCode == 1002 && resultCode == -1) {
            activity.setResult(-1);
            if (this.mRegisterToken != null) {
                this.mRegisterToken.cancel();
            }
            this.mRegisterToken = requestMyinfo(this);
        }
    }

    protected void onClickLogin() {
        String name = getInputAccount();
        String pwd = getInputPassword();
        if (TextUtils.isEmpty(name)) {
            YoYo.with(new ShakeAnimator()).duration(1000L).playOn(this.userNameEt);
        } else if (TextUtils.isEmpty(pwd)) {
            YoYo.with(new ShakeAnimator()).duration(1000L).playOn(this.userPwdEt);
        } else {
            reportClickLogin();
            if (!checkLoginAgreement(name, pwd)) {
                this.loginHandler.login(name, pwd, needSuccessToast());
            }
        }
    }

    protected boolean checkLoginAgreement(String name, String pwd) {
        if (LoginRegHelper.checkViewVisibleAndUnCheck(this.mLoginRegCheckBox)) {
            LoginRegHelper.INSTANCE.showRegPopView(getContext(), this.mLoginRegPopView);
            return true;
        }
        return false;
    }

    protected void reportClickLogin() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean needSuccessToast() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onItemLinkClickAgreement() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onItemLinkClickPrivacy() {
    }

    public void onClickRegister() {
        AccountReportHelper.report(AccountReportHelper.Event.obtainClick(AccountReportHelper.EventID.LOGIN_REGISTER_CLICK, null, null));
    }

    public void onClickClearName() {
        if (this.userNameEt != null) {
            this.userNameEt.setText("");
        }
        if (this.mUserLoginInfo != null) {
            this.mUserLoginInfo = null;
            AutoCompleteHelper.clearUserLoginInfo(getContext());
        }
    }

    public void onClickClearPassword() {
        if (this.userPwdEt != null) {
            this.userPwdEt.setText("");
        }
    }

    public void onClickUserName() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickAgreementTv() {
        if (this.mLoginRegCheckBox.getVisibility() == 0) {
            this.mLoginRegCheckBox.setChecked(!this.mLoginRegCheckBox.isChecked());
        }
        LoginRegHelper.reportRegCheckboxClick(LoginReporterV2.Click.CLICK_PROVISION_PWD_LOGIN, this.mLoginRegCheckBox);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickRegPop() {
        if (LoginRegHelper.checkViewVisibleAndUnCheck(this.mLoginRegCheckBox)) {
            this.mLoginRegCheckBox.setChecked(true);
        }
        LoginRegHelper.reportRegCheckboxClick(LoginReporterV2.Click.CLICK_PROVISION_PWD_LOGIN, this.mLoginRegCheckBox);
    }

    void addActionListener() {
        this.userNameEt.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == 5) {
                    BaseLoginFragmentV2.this.userPwdEt.requestFocus();
                    return true;
                }
                return false;
            }
        });
        this.userPwdEt.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == 6) {
                    BaseLoginFragmentV2.this.loginButton.performClick();
                    return true;
                }
                return false;
            }
        });
    }

    private void addTextWatcher() {
        this.userNameEt.addTextChangedListener(new TextWatcher() { // from class: tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    BaseLoginFragmentV2.this.clearName.setVisibility(8);
                } else {
                    BaseLoginFragmentV2.this.clearName.setVisibility(0);
                }
                BaseLoginFragmentV2.this.completeAdapter.onTextChange(s.toString(), BaseLoginFragmentV2.this.filterListener);
                BaseLoginFragmentV2.this.checkIfNeedEnableLoginButton();
            }
        });
        this.userPwdEt.addTextChangedListener(new TextWatcher() { // from class: tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    BaseLoginFragmentV2.this.clearPassword.setVisibility(8);
                } else {
                    BaseLoginFragmentV2.this.clearPassword.setVisibility(0);
                }
                BaseLoginFragmentV2.this.checkIfNeedEnableLoginButton();
            }
        });
        this.completeAdapter.setOnDelete(new AutoCompleteAdapter.OnDelete() { // from class: tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2.7
            public void onDelete() {
                BaseLoginFragmentV2.this.userNameEt.dismissDropDown();
            }
        });
    }

    void checkIfNeedEnableLoginButton() {
        if (!TextUtils.isEmpty(this.userNameEt.getText().toString()) && !TextUtils.isEmpty(this.userPwdEt.getText().toString())) {
            this.loginButton.setEnabled(true);
        } else {
            this.loginButton.setEnabled(false);
        }
    }

    public void saveLoginAccount(String account) {
        if (this.completeAdapter != null) {
            this.completeAdapter.save(account);
        }
    }

    public String getInputAccount() {
        if (this.userNameEt != null) {
            return this.userNameEt.getText().toString();
        }
        return "";
    }

    public String getInputPassword() {
        if (this.userPwdEt != null) {
            return this.userPwdEt.getText().toString();
        }
        return "";
    }

    public void onLoginIntercept(VerifyBundle verifyBundle) {
    }

    public void onLoginSuccess() {
        if (activityDie()) {
            return;
        }
        FragmentActivity activity = getActivity();
        LoginSuccessProcessorKt.processLoginSuccess(activity.getApplication(), LoginUIType.PWD);
        RouteRequest request = RouteUtilKt.getForwardRequest(activity.getIntent());
        if (request == null) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
            return;
        }
        BLRouter.routeTo(request, activity);
        LoginAnswerDialogHelper.INSTANCE.setNeedShowAnswerDialog(getContext(), false);
        __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
    }

    private CancellationTokenSource requestMyinfo(final BaseFragment mf) {
        final BiliAccountInfo biliAccountInfo = BiliAccountInfo.get();
        final TintProgressDialog progressDialog = new TintProgressDialog(mf.getActivity());
        progressDialog.setMessage(mf.getString(bili.resource.account.R.string.account_global_string_339));
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
        CancellationTokenSource cts = new CancellationTokenSource();
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BaseLoginFragmentV2.lambda$requestMyinfo$1(mf, biliAccountInfo);
            }
        }, cts.getToken()).continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.loginv2.BaseLoginFragmentV2$$ExternalSyntheticLambda2
            public final Object then(Task task) {
                return BaseLoginFragmentV2.lambda$requestMyinfo$2(progressDialog, mf, task);
            }
        }, Task.UI_THREAD_EXECUTOR, cts.getToken());
        return cts;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AccountInfo lambda$requestMyinfo$1(BaseFragment mf, BiliAccountInfo biliAccountInfo) throws Exception {
        try {
            String accessKey = BiliAccounts.get(mf.getApplicationContext()).getAccessKey();
            BLog.i(TAG, "requestMyinfo accessKey = " + accessKey);
            if (accessKey != null) {
                return biliAccountInfo.requestForAccountInfoByAccessKey(accessKey);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void lambda$requestMyinfo$2(TintProgressDialog progressDialog, BaseFragment mf, Task task) throws Exception {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        try {
            AccountInfo info = (AccountInfo) task.getResult();
            BLog.i(TAG, "requestMyinfo AccountInfo = " + info);
            if (info != null) {
                info.isFormalAccount();
            }
        } catch (Exception e) {
        }
        FragmentActivity activity = mf.getActivity();
        if (activity != null) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
            return null;
        }
        return null;
    }

    @Override // tv.danmaku.bili.ui.AgreementLinkHelper.ClickLinkItemListener
    public void onItemLinkClick(int itemId) {
        this.mAnyRegFlag = true;
        switch (itemId) {
            case 1:
                LoginReporterV2.Click.report(LoginReporterV2.Click.APP_PWD_LOGIN_HELP_0_CLICK);
                return;
            case 2:
                onItemLinkClickAgreement();
                return;
            case 3:
                onItemLinkClickPrivacy();
                return;
            default:
                return;
        }
    }

    public void onPause() {
        super.onPause();
        this.userNameEt.dismissDropDown();
    }

    public ILoginHandler getLoginHandler() {
        return this.loginHandler;
    }

    public void replyWithGeeCaptcha(Map<String, String> param) {
        if (this.loginHandler != null && (this.loginHandler instanceof LoginHandlerImp)) {
            ((LoginHandlerImp) this.loginHandler).loginWithGeeCaptcha(param);
        }
    }

    public void replyWithImageCaptcha(int callbackId, Map<String, String> param) {
        if (this.loginHandler != null && (this.loginHandler instanceof LoginHandlerImp)) {
            ((LoginHandlerImp) this.loginHandler).loginWithImageCaptcha(callbackId, param);
        }
    }

    public void closeCaptchaDialog() {
        if (this.loginHandler != null && (this.loginHandler instanceof LoginHandlerImp)) {
            ((LoginHandlerImp) this.loginHandler).hideCaptchaDialog();
        }
    }
}