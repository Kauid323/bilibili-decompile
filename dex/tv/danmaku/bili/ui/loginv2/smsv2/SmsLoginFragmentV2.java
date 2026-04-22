package tv.danmaku.bili.ui.loginv2.smsv2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.ActivityCompat$;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import bili.resource.account.R;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.droid.StringUtil;
import com.bilibili.droid.ToastHelper;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.VerifyBundle;
import com.bilibili.lib.accountsui.AutoCompleteHelper;
import com.bilibili.lib.accountsui.CountryCode;
import com.bilibili.lib.accountsui.sms.ISmsLoginPresenter;
import com.bilibili.lib.accountsui.sms.ISmsLoginReporter;
import com.bilibili.lib.accountsui.sms.ISmsLoginView;
import com.bilibili.lib.accountsui.sms.SmsLoginPresenter;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.pvtracker.IPvTracker;
import com.bilibili.ui.busbound.BusFragment;
import java.util.HashMap;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.eula.LoginEulaDialog;
import tv.danmaku.bili.helper.LoginLifecycleObserver;
import tv.danmaku.bili.helper.LoginSuccessProcessorKt;
import tv.danmaku.bili.helper.LoginUIType;
import tv.danmaku.bili.normal.ui.EulaTriggerType;
import tv.danmaku.bili.normal.ui.RouteUtilKt;
import tv.danmaku.bili.reg.ILoginReg;
import tv.danmaku.bili.reg.LoginRegHelper;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.sms.SmsLoginController;
import tv.danmaku.bili.sms.SmsLoginDialogUtilKt;
import tv.danmaku.bili.ui.AgreementLinkHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.login.ToastAnimationHelper;
import tv.danmaku.bili.ui.loginv2.LoginAnswerDialogHelper;
import tv.danmaku.bili.ui.loginv2.LoginFragmentV2;
import tv.danmaku.bili.ui.loginv2.LoginOriginalActivityV2;
import tv.danmaku.bili.ui.theme.BiliTheme;
import tv.danmaku.bili.ui.util.AccountUtils;

public class SmsLoginFragmentV2 extends BusFragment implements ISmsLoginView, View.OnClickListener, IPvTracker, ISmsLoginReporter {
    public static final int REQ_CODE_FORGET = 203;
    public static final int REQ_CODE_SECOND_VERIFY = 204;
    public static final String TAG = "SmsLoginFragmentV2";
    private AgreementLinkHelper agreementLinkHelper;
    ImageView clearCaptcha;
    ImageView clearPhoneNum;
    private ImageView imageView22;
    private ImageView imageView33;
    private boolean mAnyRegFlag;
    private TextView mAreaCodeView;
    EditText mEtCaptcha;
    EditText mEtPhoneNum;
    TextView mGetCaptcha;
    private TextView mLoginAgreementText;
    private TextView mLoginCheckHelpText;
    private CheckBox mLoginRegCheckBox;
    private View mLoginRegCheckBoxContainer;
    private View mLoginRegPopView;
    private ISmsLoginPresenter mPresenter;
    private String mPromptScene;
    private TextView mSelectedCountryNameView;
    private SmsLoginController mSmsLoginController;
    TintTextView mSubmitBtn;
    private View mToastView;
    private TintProgressDialog progressDialog;
    private AutoCompleteHelper.SmsLoginInfo smsCacheLoginInfo;
    private boolean mEnableCommit = true;
    private boolean mCountryCodeRequested = false;
    private boolean loginExperiment = false;
    private String loginExperimentValue = "";
    private final AgreementLinkHelper.ClickLinkItemListener clickLinkItemListener = new AgreementLinkHelper.ClickLinkItemListener() { // from class: tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2$$ExternalSyntheticLambda10
        @Override // tv.danmaku.bili.ui.AgreementLinkHelper.ClickLinkItemListener
        public final void onItemLinkClick(int i) {
            SmsLoginFragmentV2.this.m1832lambda$new$0$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(i);
        }
    };
    private final AgreementLinkHelper.ClickLinkItemListener clickLinkItemListener2 = new AgreementLinkHelper.ClickLinkItemListener() { // from class: tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2$$ExternalSyntheticLambda11
        @Override // tv.danmaku.bili.ui.AgreementLinkHelper.ClickLinkItemListener
        public final void onItemLinkClick(int i) {
            SmsLoginFragmentV2.this.m1833lambda$new$1$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(i);
        }
    };
    private final AgreementLinkHelper.ClickLinkItemListener clickLinkItemListener3 = new AgreementLinkHelper.ClickLinkItemListener() { // from class: tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2$$ExternalSyntheticLambda12
        @Override // tv.danmaku.bili.ui.AgreementLinkHelper.ClickLinkItemListener
        public final void onItemLinkClick(int i) {
            SmsLoginFragmentV2.this.m1834lambda$new$2$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(i);
        }
    };

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

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
    /* renamed from: lambda$new$0$tv-danmaku-bili-ui-loginv2-smsv2-SmsLoginFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1832lambda$new$0$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(int itemId) {
        onEulaItemLinkClick(itemId, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$tv-danmaku-bili-ui-loginv2-smsv2-SmsLoginFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1833lambda$new$1$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(int itemId) {
        onEulaItemLinkClick(itemId, EulaTriggerType.GetSms);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$2$tv-danmaku-bili-ui-loginv2-smsv2-SmsLoginFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1834lambda$new$2$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(int itemId) {
        onEulaItemLinkClick(itemId, EulaTriggerType.Submit);
    }

    public static SmsLoginFragmentV2 newInstance(String promptScene) {
        SmsLoginFragmentV2 fragment = new SmsLoginFragmentV2();
        Bundle args = new Bundle();
        args.putString(LoginOriginalActivityV2.KEY_PROMPT_SCENE, promptScene);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setTitle(R.string.account_global_string_81);
        this.agreementLinkHelper = new AgreementLinkHelper(getActivity());
        initPresenter();
        initSmsLoginController();
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.mPromptScene = bundle.getString(LoginOriginalActivityV2.KEY_PROMPT_SCENE);
            this.loginExperiment = BundleUtil.getBoolean(bundle, LoginOriginalActivityV2.KEY_LOGIN_EXPERIMENT, new boolean[]{false});
            this.loginExperimentValue = BundleUtil.getString(bundle, LoginOriginalActivityV2.KEY_LOGIN_EXPERIMENT_VALUE, new String[0]);
        }
        getLifecycle().addObserver(LoginLifecycleObserver.INSTANCE);
    }

    private void initSmsLoginController() {
        this.mSmsLoginController = new SmsLoginController() { // from class: tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2.1
            @Override // tv.danmaku.bili.sms.SmsLoginController
            public boolean isActivityDie() {
                return SmsLoginFragmentV2.this.isActivityDie();
            }
        };
        this.mSmsLoginController.onCreate(getContext(), this.mPresenter);
    }

    private void initPresenter() {
        this.mPresenter = new SmsLoginPresenter(getActivity(), this, this);
        this.mPresenter.setLoginProxy(new SmsLoginController.SmsLoginRedirectProxy() { // from class: tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2.2
            @Override // tv.danmaku.bili.sms.SmsLoginController.SmsLoginRedirectProxy
            public void startActivityForResult(Intent intent, int requestCode) {
                SmsLoginFragmentV2.this.startActivityForResult(intent, requestCode);
            }
        });
    }

    public CountryCode getDefaultCountryCode() {
        if (this.mSmsLoginController != null) {
            return this.mSmsLoginController.getDefaultCountryCode();
        }
        return SmsLoginController.getNullDefaultCountryCode();
    }

    public void onCountryCodeUpdate(boolean b) {
        this.mCountryCodeRequested = true;
        if (this.mSelectedCountryNameView != null) {
            this.mSelectedCountryNameView.setClickable(true);
        }
        if (this.smsCacheLoginInfo != null) {
            return;
        }
        enableNextOperation(true);
        refreshViewByCountryCode(this.mPresenter.getSelectedCountryCode());
    }

    private void enableNextOperation(boolean enable) {
        if (this.mGetCaptcha != null) {
            this.mGetCaptcha.setClickable(enable);
        }
        if (this.mEtPhoneNum != null) {
            this.mEtPhoneNum.setEnabled(enable);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem item = menu.add(0, 16908313, 0, R.string.account_global_string_17);
        item.setShowAsAction(2);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908313) {
            toUserNameLogin();
            LoginReporterV2.Click.report(LoginReporterV2.Click.APP_SMS_LOGIN_PWD_0_CLICK);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toUserNameLogin() {
        LoginOriginalActivityV2 loginActivity = getLoginActivity();
        if (loginActivity != null) {
            loginActivity.jumpFragment(LoginFragmentV2.TAG);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(com.bilibili.app.accountui.R.layout.bili_app_fragmant_login_sms, container, false);
        findViews(view);
        initViews();
        setListeners();
        LoginReportHelper.setTrackParams(this.mPresenter);
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        clearViews();
        LoginRegHelper.clearOnChangeListener(this.mLoginRegCheckBox);
    }

    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LoginOriginalActivityV2 loginActivity = getLoginActivity();
        if (loginActivity != null) {
            loginActivity.setTitle(getString(R.string.account_global_string_81));
        }
        view.postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SmsLoginFragmentV2.this.m1835lambda$onViewCreated$3$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(view);
            }
        }, 100L);
        showToastIfNeed(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onViewCreated$3$tv-danmaku-bili-ui-loginv2-smsv2-SmsLoginFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1835lambda$onViewCreated$3$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(View view) {
        try {
            if (this.mEtPhoneNum != null) {
                this.mEtPhoneNum.requestFocus();
            }
        } catch (Exception e) {
            BLog.e(TAG, e);
        }
        if (this.mEtPhoneNum != null) {
            InputMethodManagerHelper.showSoftInput(view.getContext(), this.mEtPhoneNum, 1);
        }
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

    public String getPvEventId() {
        return LoginReporterV2.PV.APP_SMS_LOGIN_0_0_PV;
    }

    public Bundle getPvExtra() {
        Context context = getContext();
        if (context == null) {
            return new Bundle();
        }
        Bundle bundle = LoginReportHelper.buildCommonBundle();
        bundle.putString(LoginReporterV2.SHOW_PROVISION_KEY, LoginRegHelper.getProvisionReportValue(context));
        return bundle;
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

    public void onReceiveSelectCountry(CountryCode code) {
        LoginReporterV2.Click.report(LoginReporterV2.Click.APP_SMS_LOGIN_COUNTY_CODE_CLICK, LoginReporterV2.generateSingleParamMaps(LoginReporterV2.Click.SIGNUP_KEY_COUNTRY, code.id));
        refreshViewByCountryCode(code);
    }

    private void refreshViewByCountryCode(CountryCode code) {
        if (getActivity() != null) {
            String name = code.name == null ? "" : code.name;
            if (this.mSelectedCountryNameView != null) {
                this.mSelectedCountryNameView.setText(name);
            }
            if (this.mAreaCodeView != null) {
                this.mAreaCodeView.setText(code.countryId != null ? "+" + code.countryId : "");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == com.bilibili.app.accountui.R.id.selected_country_name) {
            this.mPresenter.choiceCountry();
            LoginReporterV2.Click.report(LoginReporterV2.Click.APP_SMS_LOGIN_COUNTY_0_CLICK);
        } else if (v.getId() == com.bilibili.app.accountui.R.id.submit) {
            if (!this.mEnableCommit || getContext() == null) {
                return;
            }
            HashMap<String, String> map = LoginRegHelper.getClickReportInfoValue(LoginRegHelper.getProvisionReportValue(getContext()), LoginRegHelper.getAgreeReportValue(this.mLoginRegCheckBox));
            LoginReporterV2.Click.report(LoginReporterV2.Click.APP_SMS_LOGIN_SUBMIT_0_CLICK, map);
            if (this.mEtPhoneNum != null && this.mEtCaptcha != null) {
                doLogin(this.mEtPhoneNum.getText().toString(), this.mEtCaptcha.getText().toString());
            }
        } else if (v.getId() == com.bilibili.app.accountui.R.id.get_auth_code) {
            if (this.mEtPhoneNum != null && !TextUtils.isEmpty(this.mEtPhoneNum.getText().toString())) {
                doSendCaptcha(this.mEtPhoneNum.getText().toString());
            }
        } else if (v.getId() == com.bilibili.app.accountui.R.id.clear_phonenum_layout) {
            if (this.mEtPhoneNum != null) {
                this.mEtPhoneNum.setText("");
            }
            this.mPresenter.clearCache();
        } else if (v.getId() == com.bilibili.app.accountui.R.id.clear_captcha_layout) {
            if (this.mEtCaptcha != null) {
                this.mEtCaptcha.setText("");
            }
        } else if (v.getId() == com.bilibili.app.accountui.R.id.login_reg_pop) {
            if (LoginRegHelper.checkViewVisibleAndUnCheck(this.mLoginRegCheckBox)) {
                if (this.mLoginRegCheckBox != null) {
                    this.mLoginRegCheckBox.setChecked(true);
                }
                LoginRegHelper.reportRegCheckboxClick(LoginReporterV2.Click.CLICK_PROVISION_SMS_LOGIN, this.mLoginRegCheckBox);
            }
        } else if (v.getId() == com.bilibili.app.accountui.R.id.tv_login_agreement || v.getId() == com.bilibili.app.accountui.R.id.log_reg_checkbox_container) {
            if (this.mLoginRegCheckBox != null && this.mLoginRegCheckBox.getVisibility() == 0) {
                this.mLoginRegCheckBox.setChecked(!this.mLoginRegCheckBox.isChecked());
            }
            LoginRegHelper.reportRegCheckboxClick(LoginReporterV2.Click.CLICK_PROVISION_SMS_LOGIN, this.mLoginRegCheckBox);
        }
    }

    private void doSendCaptcha(final String phoneNum) {
        boolean uncheck = LoginRegHelper.checkViewVisibleAndUnCheck(this.mLoginRegCheckBox);
        Map<String, String> reportMap = new HashMap<>();
        reportMap.put("is_agree", uncheck ? "0" : "1");
        LoginReporterV2.Click.report(LoginReporterV2.Click.APP_SMS_LOGIN_GETSMS_0_CLICK, reportMap);
        if (uncheck) {
            LoginEulaDialog eulaDialog = new LoginEulaDialog();
            eulaDialog.show(getChildFragmentManager(), LoginReporterV2.PAGE_TYPE_SMS, true, EulaTriggerType.GetSms, EulaTriggerType.GetSms.getBtnId(), (String) null, new Function0() { // from class: tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2$$ExternalSyntheticLambda1
                public final Object invoke() {
                    return SmsLoginFragmentV2.this.m1831lambda$doSendCaptcha$4$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(phoneNum);
                }
            }, new Function0() { // from class: tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            }, this.clickLinkItemListener2);
        } else {
            this.mPresenter.sendCaptcha(phoneNum);
        }
        hideSoftInput();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$doSendCaptcha$4$tv-danmaku-bili-ui-loginv2-smsv2-SmsLoginFragmentV2  reason: not valid java name */
    public /* synthetic */ Unit m1831lambda$doSendCaptcha$4$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(String phoneNum) {
        if (this.mLoginRegCheckBox != null) {
            this.mLoginRegCheckBox.setChecked(true);
        }
        LoginRegHelper.reportRegCheckboxClick(LoginReporterV2.Click.CLICK_PROVISION_SMS_LOGIN, this.mLoginRegCheckBox);
        this.mPresenter.sendCaptcha(phoneNum);
        return Unit.INSTANCE;
    }

    protected void doLogin(final String name, final String pwd) {
        if (LoginRegHelper.checkViewVisibleAndUnCheck(this.mLoginRegCheckBox)) {
            if (SmsLoginDialogUtilKt.getShowEulaDialog()) {
                LoginEulaDialog eulaDialog = new LoginEulaDialog();
                eulaDialog.show(getChildFragmentManager(), LoginReporterV2.PAGE_TYPE_SMS, true, EulaTriggerType.Submit, EulaTriggerType.Submit.getBtnId(), (String) null, new Function0() { // from class: tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        return SmsLoginFragmentV2.this.m1830lambda$doLogin$6$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(name, pwd);
                    }
                }, new Function0() { // from class: tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                }, this.clickLinkItemListener3);
            } else {
                LoginRegHelper.INSTANCE.showRegPopView(getContext(), this.mLoginRegPopView);
            }
        } else {
            this.mPresenter.submit(name, pwd);
        }
        hideSoftInput();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$doLogin$6$tv-danmaku-bili-ui-loginv2-smsv2-SmsLoginFragmentV2  reason: not valid java name */
    public /* synthetic */ Unit m1830lambda$doLogin$6$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(String name, String pwd) {
        if (this.mLoginRegCheckBox != null) {
            this.mLoginRegCheckBox.setChecked(true);
        }
        LoginRegHelper.reportRegCheckboxClick(LoginReporterV2.Click.CLICK_PROVISION_SMS_LOGIN, this.mLoginRegCheckBox);
        this.mPresenter.submit(name, pwd);
        return Unit.INSTANCE;
    }

    private void hideSoftInput() {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            InputMethodManagerHelper.hideSoftInput(activity, window.getDecorView(), 2);
        }
    }

    public void showTip(int resId) {
        ToastHelper.showToastShort(getContext(), resId);
    }

    public void showTip(String message) {
        if (!TextUtils.isEmpty(message)) {
            ToastHelper.showToastShort(getContext(), message);
        }
    }

    public void showCountryChoiceDialog() {
        if (this.mSmsLoginController != null) {
            this.mSmsLoginController.showCountryChoiceDialog();
        }
    }

    public void hideCountryChoiceDialog() {
        if (this.mSmsLoginController != null) {
            this.mSmsLoginController.hideCountryChoiceDialog();
        }
    }

    public boolean isActivityDie() {
        return activityDie();
    }

    public void sendSmsWithGeeCaptcha(Map<String, String> innerMap) {
        if (this.mSmsLoginController != null) {
            this.mSmsLoginController.sendSmsWithGeeCaptcha(innerMap);
            LoginReporterV2.Click.report(LoginReporterV2.Click.APP_SMS_LOGIN_VERIFICATION_SUCCESS_CLICK);
        }
    }

    public void sendSmsWithImageCaptcha(int callbackId, Map<String, String> param) {
        if (this.mSmsLoginController != null) {
            this.mSmsLoginController.sendSmsWithImageCaptcha(callbackId, param);
            LoginReporterV2.Click.report(LoginReporterV2.Click.APP_SMS_LOGIN_VERIFICATION_SUCCESS_CLICK);
        }
    }

    public void tryNotifyImageCaptchaSuccess() {
        if (this.mSmsLoginController != null) {
            this.mSmsLoginController.tryNotifyImageCaptchaSuccess();
        }
    }

    public void showCaptchaDialog(String url) {
        if (this.mSmsLoginController != null) {
            this.mSmsLoginController.showCaptchaDialog(url, new Function0() { // from class: tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2$$ExternalSyntheticLambda3
                public final Object invoke() {
                    return SmsLoginFragmentV2.lambda$showCaptchaDialog$8();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$showCaptchaDialog$8() {
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_SMS_LOGIN_VERIFICATION_0_SHOW);
        return null;
    }

    public void hideCaptchaDialog() {
        if (this.mSmsLoginController != null) {
            this.mSmsLoginController.hideCaptchaDialog();
        }
    }

    public void callbackCaptchaDialog(int code, String message) {
        if (this.mSmsLoginController != null) {
            this.mSmsLoginController.callbackCaptchaDialog(code, message);
        }
    }

    public void focusToCaptchaEdit() {
        if (this.mEtCaptcha != null && getContext() != null) {
            this.mEtCaptcha.setText("");
            this.mEtCaptcha.requestFocus();
            InputMethodManagerHelper.showSoftInput(getContext(), this.mEtCaptcha, 1);
        }
    }

    public void showProgress(String msg) {
        if (this.progressDialog == null) {
            this.progressDialog = new TintProgressDialog(getActivity());
            this.progressDialog.setMessage(msg);
            this.progressDialog.setIndeterminate(true);
            this.progressDialog.setCanceledOnTouchOutside(false);
        }
        if (getActivity() != null && !getActivity().isFinishing()) {
            this.progressDialog.setMessage(msg);
            this.progressDialog.show();
        }
    }

    public void showProgress(int resId) {
        showProgress(getString(resId));
    }

    public void hideProgress() {
        if (this.progressDialog != null && this.progressDialog.isShowing() && !activityDie()) {
            this.progressDialog.dismiss();
        }
    }

    public void warningPhoneNum() {
        if (this.mEtPhoneNum != null) {
            this.mEtPhoneNum.setTextColor(getResources().getColor(com.bilibili.lib.theme.R.color.Re6));
        }
    }

    public void warningCaptcha() {
        if (this.mEtCaptcha != null) {
            this.mEtCaptcha.setTextColor(getResources().getColor(com.bilibili.lib.theme.R.color.Re6));
        }
    }

    public void startTimer() {
        if (this.mSmsLoginController != null) {
            this.mSmsLoginController.startTimer();
        }
    }

    public void stopTimer() {
        if (this.mSmsLoginController != null) {
            this.mSmsLoginController.stopTimer();
        }
    }

    public void set2233eyes(boolean close) {
        if (this.imageView22 != null) {
            this.imageView22.setImageResource(close ? com.bilibili.app.accountui.R.drawable.ic_22_hide : com.bilibili.app.accountui.R.drawable.ic_22);
        }
        if (this.imageView33 != null) {
            this.imageView33.setImageResource(close ? com.bilibili.app.accountui.R.drawable.ic_33_hide : com.bilibili.app.accountui.R.drawable.ic_33);
        }
    }

    public void onLoginAfterRegisterSuccess(int inRegAudit) {
    }

    public void onLoginIntercept(VerifyBundle verifyBundle) {
    }

    public void onLoginSuccess() {
        FragmentActivity activity;
        this.mEnableCommit = false;
        if (!activityDie() && (activity = getActivity()) != null) {
            LoginSuccessProcessorKt.processLoginSuccess(activity.getApplication(), LoginUIType.SMS);
            RouteRequest request = RouteUtilKt.getForwardRequest(activity.getIntent());
            if (request == null) {
                return;
            }
            BLRouter.routeTo(request, activity);
            LoginAnswerDialogHelper.INSTANCE.setNeedShowAnswerDialog(activity, false);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        BLog.i(TAG, "onActivityResult requestCode = " + requestCode + " , resultCode = " + resultCode);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (requestCode == 203 && resultCode == -1) {
                activity.setResult(-1);
                __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
            } else if (requestCode == 204) {
                if (resultCode == -1) {
                    activity.setResult(-1);
                }
                __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
            }
        }
    }

    private void onEulaItemLinkClick(int itemId, EulaTriggerType eulaTriggerType) {
        this.mAnyRegFlag = true;
        Map<String, String> map = new HashMap<>();
        map.put(LoginReporterV2.TRIGGER_TYPE_KEY, eulaTriggerType == null ? "" : eulaTriggerType.getReportTypeValue());
        switch (itemId) {
            case 1:
                LoginReporterV2.Click.report(LoginReporterV2.Click.APP_SMS_LOGIN_GETHELP_0_CLICK);
                return;
            case 2:
                LoginReporterV2.Click.report(LoginReporterV2.Click.APP_SMS_LOGIN_TERMS_AGREEMENT_CLICK, map);
                return;
            case 3:
                LoginReporterV2.Click.report(LoginReporterV2.Click.APP_SMS_LOGIN_TERMS_PRIVACY_CLICK, map);
                return;
            default:
                return;
        }
    }

    public void onDestroy() {
        hideProgress();
        super.onDestroy();
        if (this.mPresenter != null) {
            this.mPresenter.cancelTasks();
        }
        if (this.mSmsLoginController != null) {
            this.mSmsLoginController.onDestroy();
        }
        getLifecycle().removeObserver(LoginLifecycleObserver.INSTANCE);
    }

    public LoginOriginalActivityV2 getLoginActivity() {
        Activity activity = getActivity();
        if (activity instanceof LoginOriginalActivityV2) {
            return (LoginOriginalActivityV2) activity;
        }
        return null;
    }

    public void finish(int code) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(code);
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
        }
    }

    public void setTitle(int titleRes) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(titleRes);
        }
    }

    private void initViews() {
        if (this.mSmsLoginController != null && this.mSmsLoginController.getTimer() != null && this.mGetCaptcha != null) {
            this.mSmsLoginController.getTimer().attachTv(this.mGetCaptcha);
        }
        updateRegInfo();
        this.smsCacheLoginInfo = this.mPresenter.loadCache();
        if (this.mGetCaptcha != null) {
            this.mGetCaptcha.setEnabled(false);
        }
        if (this.smsCacheLoginInfo != null) {
            if (this.mEtPhoneNum != null && this.mSelectedCountryNameView != null && this.mAreaCodeView != null && this.mGetCaptcha != null) {
                this.mEtPhoneNum.setText(this.smsCacheLoginInfo.mPhoneNum);
                this.mEtPhoneNum.setSelection(this.smsCacheLoginInfo.mPhoneNum.length());
                this.mGetCaptcha.setEnabled(true);
                enableNextOperation(true);
                if (this.mCountryCodeRequested) {
                    this.mSelectedCountryNameView.setClickable(true);
                }
                CountryCode countryCode = this.smsCacheLoginInfo.mCountryCode;
                if (countryCode != null) {
                    String name = countryCode.name == null ? "" : countryCode.name;
                    this.mSelectedCountryNameView.setText(name);
                    if (TextUtils.isEmpty(countryCode.countryId) && !TextUtils.isEmpty(countryCode.oldCountryId)) {
                        countryCode.countryId = countryCode.oldCountryId;
                    }
                    this.mAreaCodeView.setText(countryCode.countryId != null ? "+" + countryCode.countryId : "");
                    if (this.mPresenter != null) {
                        this.mPresenter.setCountryCode(countryCode);
                    }
                }
            }
        } else if (this.mCountryCodeRequested) {
            if (this.mSelectedCountryNameView != null) {
                this.mSelectedCountryNameView.setClickable(true);
            }
            enableNextOperation(true);
            refreshViewByCountryCode(this.mPresenter.getSelectedCountryCode());
        }
        if (this.mEtCaptcha != null) {
            this.mEtCaptcha.setFilters(new InputFilter[]{new CaptchaFilter()});
        }
        if (BiliTheme.isNightTheme(getContext()) && getContext() != null) {
            if (this.clearPhoneNum != null) {
                this.clearPhoneNum.setColorFilter(ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Ga8_u));
            }
            if (this.clearCaptcha != null) {
                this.clearCaptcha.setColorFilter(ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Ga8_u));
            }
        }
    }

    private void updateRegInfo() {
        String subTips;
        ILoginReg loginReg = LoginRegHelper.INSTANCE.getLoginRegStrategy();
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (loginReg.showReg(context)) {
            subTips = getString(R.string.account_global_string_137);
        } else {
            subTips = getString(R.string.account_global_string_127);
        }
        this.agreementLinkHelper.attachLinkContentAgreement(this.mLoginAgreementText, subTips, ContextCompat.getColor(context, com.bilibili.lib.theme.R.color.Lb6), this.clickLinkItemListener);
        this.agreementLinkHelper.attachLinkContentHelp(this.mLoginCheckHelpText, getString(R.string.account_global_string_49), this.clickLinkItemListener, ContextCompat.getColor(context, com.bilibili.lib.theme.R.color.Lb6));
    }

    private void setListeners() {
        if (this.mEtPhoneNum != null) {
            this.mEtPhoneNum.addTextChangedListener(new PhoneNumTextChangeListener(this));
            this.mEtPhoneNum.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2$$ExternalSyntheticLambda6
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return SmsLoginFragmentV2.this.m1839lambda$setListeners$9$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(textView, i, keyEvent);
                }
            });
            this.mEtPhoneNum.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2$$ExternalSyntheticLambda7
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    SmsLoginFragmentV2.this.m1836lambda$setListeners$10$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(view, z);
                }
            });
        }
        if (this.mEtCaptcha != null) {
            this.mEtCaptcha.addTextChangedListener(new CaptchaTextChangeListener(this));
            this.mEtCaptcha.addTextChangedListener(new TextWatcher() { // from class: tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2.3
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    if (s.length() == 6 && SmsLoginFragmentV2.this.mSubmitBtn != null && SmsLoginFragmentV2.this.mSubmitBtn.isEnabled()) {
                        SmsLoginFragmentV2.this.mSubmitBtn.performClick();
                    }
                }
            });
            this.mEtCaptcha.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2$$ExternalSyntheticLambda8
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return SmsLoginFragmentV2.this.m1837lambda$setListeners$11$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(textView, i, keyEvent);
                }
            });
            this.mEtCaptcha.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: tv.danmaku.bili.ui.loginv2.smsv2.SmsLoginFragmentV2$$ExternalSyntheticLambda9
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    SmsLoginFragmentV2.this.m1838lambda$setListeners$12$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(view, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setListeners$9$tv-danmaku-bili-ui-loginv2-smsv2-SmsLoginFragmentV2  reason: not valid java name */
    public /* synthetic */ boolean m1839lambda$setListeners$9$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(TextView v, int actionId, KeyEvent event) {
        if (actionId == 5 && this.mEtCaptcha != null) {
            this.mEtCaptcha.requestFocus();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setListeners$10$tv-danmaku-bili-ui-loginv2-smsv2-SmsLoginFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1836lambda$setListeners$10$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(View v, boolean hasFocus) {
        if (hasFocus && this.clearCaptcha != null && this.mEtPhoneNum != null && this.clearPhoneNum != null) {
            this.clearCaptcha.setVisibility(8);
            if (this.mEtPhoneNum.getText().length() > 0) {
                this.clearPhoneNum.setVisibility(0);
            } else {
                this.clearPhoneNum.setVisibility(8);
            }
            set2233eyes(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setListeners$11$tv-danmaku-bili-ui-loginv2-smsv2-SmsLoginFragmentV2  reason: not valid java name */
    public /* synthetic */ boolean m1837lambda$setListeners$11$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(TextView v, int actionId, KeyEvent event) {
        if (actionId == 6) {
            if (this.mSubmitBtn != null && this.mSubmitBtn.isEnabled()) {
                this.mSubmitBtn.performClick();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setListeners$12$tv-danmaku-bili-ui-loginv2-smsv2-SmsLoginFragmentV2  reason: not valid java name */
    public /* synthetic */ void m1838lambda$setListeners$12$tvdanmakubiliuiloginv2smsv2SmsLoginFragmentV2(View v, boolean hasFocus) {
        if (hasFocus && this.clearPhoneNum != null && this.mEtCaptcha != null && this.clearCaptcha != null) {
            this.clearPhoneNum.setVisibility(8);
            if (this.mEtCaptcha.getText().length() > 0) {
                this.clearCaptcha.setVisibility(0);
            } else {
                this.clearCaptcha.setVisibility(8);
            }
            set2233eyes(true);
        }
    }

    private void findViews(View view) {
        this.mSelectedCountryNameView = (TextView) view.findViewById(com.bilibili.app.accountui.R.id.selected_country_name);
        this.mSubmitBtn = view.findViewById(com.bilibili.app.accountui.R.id.submit);
        this.mGetCaptcha = (TextView) view.findViewById(com.bilibili.app.accountui.R.id.get_auth_code);
        this.mLoginAgreementText = (TextView) view.findViewById(com.bilibili.app.accountui.R.id.tv_login_agreement);
        this.mLoginCheckHelpText = (TextView) view.findViewById(com.bilibili.app.accountui.R.id.tv_check_help);
        this.mAreaCodeView = (TextView) view.findViewById(com.bilibili.app.accountui.R.id.area_code);
        this.mEtPhoneNum = (EditText) view.findViewById(com.bilibili.app.accountui.R.id.et_phone_number);
        this.mEtCaptcha = (EditText) view.findViewById(com.bilibili.app.accountui.R.id.et_capture);
        this.clearPhoneNum = (ImageView) view.findViewById(com.bilibili.app.accountui.R.id.clear_phonenum);
        View clearPhoneLayout = view.findViewById(com.bilibili.app.accountui.R.id.clear_phonenum_layout);
        this.clearCaptcha = (ImageView) view.findViewById(com.bilibili.app.accountui.R.id.clear_captcha);
        View clearCaptchaLayout = view.findViewById(com.bilibili.app.accountui.R.id.clear_captcha_layout);
        this.imageView22 = (ImageView) view.findViewById(com.bilibili.app.accountui.R.id.ic_22);
        this.imageView33 = (ImageView) view.findViewById(com.bilibili.app.accountui.R.id.ic_33);
        this.mLoginRegPopView = view.findViewById(com.bilibili.app.accountui.R.id.login_reg_pop);
        this.mLoginRegCheckBox = (CheckBox) view.findViewById(com.bilibili.app.accountui.R.id.log_reg_checkbox);
        this.mLoginRegCheckBoxContainer = view.findViewById(com.bilibili.app.accountui.R.id.log_reg_checkbox_container);
        this.mSelectedCountryNameView.setOnClickListener(this);
        this.mSubmitBtn.setOnClickListener(this);
        this.mLoginRegPopView.setOnClickListener(this);
        this.mLoginAgreementText.setOnClickListener(this);
        this.mLoginRegCheckBoxContainer.setOnClickListener(this);
        this.mGetCaptcha.setOnClickListener(this);
        clearPhoneLayout.setOnClickListener(this);
        clearCaptchaLayout.setOnClickListener(this);
        enableNextOperation(false);
        this.mSelectedCountryNameView.setClickable(false);
    }

    private void clearViews() {
        this.mSelectedCountryNameView = null;
        this.mSubmitBtn = null;
        this.mGetCaptcha = null;
        this.mLoginAgreementText = null;
        this.mLoginCheckHelpText = null;
        this.mAreaCodeView = null;
        this.mEtPhoneNum = null;
        this.mEtCaptcha = null;
        this.clearPhoneNum = null;
        this.clearCaptcha = null;
        this.imageView22 = null;
        this.imageView33 = null;
        this.mLoginRegPopView = null;
        this.mLoginRegCheckBox = null;
        this.mLoginRegCheckBoxContainer = null;
    }

    public void alertVipStatusIfNeed() {
        AccountInfo myInfo = BiliAccountInfo.get().getAccountInfoFromCache();
        if (myInfo != null && myInfo.getVipInfo() != null && myInfo.getVipInfo().isFrozen()) {
            showTip(bili.resource.playerbaseres.R.string.playerbaseres_global_string_1303);
        }
    }

    public void onRegisterSuccess() {
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_REGISTER_PASSED_0_SHOW, LoginReporterV2.generateSingleParamMaps("method", "3"));
    }

    public void onLoginSuccess(boolean isNew) {
        HashMap<String, String> map = isNew ? LoginReporterV2.generateSingleParamMaps("method", LoginReporterV2.Show.LOGIN_SUCCEED_NO_ACCOUNT) : LoginReporterV2.generateSingleParamMaps("method", "10");
        map.put("scene", this.loginExperimentValue);
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_LOGIN_SUCCEED_0_SHOW, map);
    }

    public void onGetLoginStatus(String code, Integer status) {
        Map<String, String> maps = new HashMap<>();
        maps.put(LoginReporterV2.Show.SIGNUP_KEY_CODE, code);
        if (!TextUtils.isEmpty(this.mPromptScene)) {
            maps.put("refer_click", this.mPromptScene);
        }
        if (status != null) {
            maps.put("login_status", String.valueOf(status));
        }
        LoginReporterV2.Show.report(LoginReporterV2.Show.APP_SMS_LOGIN_GETSTATUS_0_SHOW, maps);
    }

    public String getPagePv() {
        return this.mPromptScene;
    }

    public String getRouteUri() {
        return AccountUtils.getRouterFrom(getActivity());
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class CaptchaFilter extends InputFilter.LengthFilter {
        private static final int DEFAULT_MAX_LENGTH = 8;

        public CaptchaFilter() {
            super(8);
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            if (source.equals(" ")) {
                return "";
            }
            return null;
        }
    }
}