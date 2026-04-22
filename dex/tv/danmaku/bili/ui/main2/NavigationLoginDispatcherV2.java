package tv.danmaku.bili.ui.main2;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.droid.PhoneUtils;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.FastLoginInfo;
import com.bilibili.lib.accounts.model.SimpleAccountItem;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.accountsui.fast.FastLoginUserHelper;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import com.bilibili.lib.accountsui.quick.QuickLoginTag;
import com.bilibili.lib.accountsui.utils.ILoginLimitUpdate;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.config.BLRemoteConfig;
import com.bilibili.lib.ui.IDrawerHost;
import com.bilibili.teenagersmode.TeenagersMode;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeoutException;
import javax.inject.Named;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.normal.ui.RouteUtilKt;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;
import tv.danmaku.bili.quick.core.LoginSceneProcessor;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;
import tv.danmaku.bili.quick.core.OnePassLoginPhoneData;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.quick.network.NetworkDialogResult;
import tv.danmaku.bili.quick.network.NetworkPermissionDialog;
import tv.danmaku.bili.quick.network.NetworkPermissionDialogKt;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.sms.SmsLoginDialogUtilKt;
import tv.danmaku.bili.ui.login.LoginDialogInterceptor;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.main2.NavigationLoginDispatcherV2;
import tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment;

@Named("home_user_center")
public class NavigationLoginDispatcherV2 implements ILoginDispatcher, ILoginLimitUpdate {
    private static final long DEFAULT_SHOW_GAP_TIME = 86400000;
    private static final String KEY_CONFIG_MY_TAB_SHOW_GAP = "login.my_tab_login_show_gap";
    private static final String KEY_QUICK_LOGIN_COUNT_LIMIT = "my_information_onepass";
    private static final String KEY_SP_QUICK_LOGIN_TIME = "key_sp_quick_login_time_v1";
    private static final String KEY_SP_SMS_LOGIN_TIME = "key_sp_sms_login_time";
    private static final String TAG = "NavigationLoginDispatcher";
    private static String mPromptScene = HomeUserCenterFragment.NAVIGATION_EVENT_ID;
    private Long _gap = StringsKt.toLongOrNull((String) ConfigManager.config().get(KEY_CONFIG_MY_TAB_SHOW_GAP, ""));
    private long gap;
    private WeakReference<Context> mContextRef;
    private Disposable mPreSubscription;

    public NavigationLoginDispatcherV2(Context context) {
        this.gap = this._gap == null ? DEFAULT_SHOW_GAP_TIME : this._gap.longValue();
        this.mContextRef = new WeakReference<>(context);
    }

    @Override // tv.danmaku.bili.ui.main2.ILoginDispatcher
    public void quickLogin() {
        OnePassLoginPathLinkManager.INSTANCE.onPhase(LoginReporterV2.Error.SP_MID_ENTER_MY_INFO, OnePassLoginPhaseType.Trigger.INSTANCE);
        final Context context = getContext();
        if (context == null) {
            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(LoginReporterV2.Error.SP_MID_ENTER_MY_INFO, OnePassLoginReportManagerKt.INTERRUPTED_FOR_OUT_OF_LIFECYCLE_SCOPE);
        } else if (TeenagersMode.getInstance().isEnable()) {
            BLog.d(TAG, "cancel quick login because teenagers mode or lessons mode is enabled");
            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(LoginReporterV2.Error.SP_MID_ENTER_MY_INFO, OnePassLoginReportManagerKt.INTERRUPTED_FOR_IN_TEENAGER_MODE);
        } else if (RestrictedMode.isLocalEnable(RestrictedType.LESSONS)) {
            BLog.d(TAG, "cancel quick login because teenagers mode or lessons mode is enabled");
            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(LoginReporterV2.Error.SP_MID_ENTER_MY_INFO, OnePassLoginReportManagerKt.INTERRUPTED_FOR_IN_COURSE_MODE);
        } else if (!(BiliContext.topActivitiy() instanceof IDrawerHost)) {
            BLog.d(TAG, "cancel quick login because is not home");
            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(LoginReporterV2.Error.SP_MID_ENTER_MY_INFO, OnePassLoginReportManagerKt.INTERRUPTED_FOR_NOT_IN_HOME_PAGE);
        } else {
            int countLimit = BLRemoteConfig.getInstance().getInt(KEY_QUICK_LOGIN_COUNT_LIMIT);
            int count = getQuickLoginTimes(context);
            if (count >= countLimit) {
                BLog.d(TAG, "cancel quick login because time is limit, time is " + count + " and limit is " + countLimit);
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(LoginReporterV2.Error.SP_MID_ENTER_MY_INFO, OnePassLoginReportManagerKt.INTERRUPTED_FOR_EXCEEDED_THE_DISPLAY_TIMES);
                return;
            }
            if (this.mPreSubscription != null) {
                this.mPreSubscription.dispose();
            }
            this.mPreSubscription = createGetLoginTypeObservable(LoginReporterV2.Error.SP_MID_ENTER_MY_INFO).subscribe(new Consumer() { // from class: tv.danmaku.bili.ui.main2.NavigationLoginDispatcherV2$$ExternalSyntheticLambda0
                public final void accept(Object obj) {
                    NavigationLoginDispatcherV2.this.m1936lambda$quickLogin$0$tvdanmakubiliuimain2NavigationLoginDispatcherV2(r2, context, (NavigationLoginDispatcherV2.NullableRef) obj);
                }
            }, new Consumer() { // from class: tv.danmaku.bili.ui.main2.NavigationLoginDispatcherV2$$ExternalSyntheticLambda2
                public final void accept(Object obj) {
                    NavigationLoginDispatcherV2.lambda$quickLogin$1(r1, (Throwable) obj);
                }
            }, new Action() { // from class: tv.danmaku.bili.ui.main2.NavigationLoginDispatcherV2$$ExternalSyntheticLambda3
                public final void run() {
                    NavigationLoginDispatcherV2.lambda$quickLogin$2();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$quickLogin$0$tv-danmaku-bili-ui-main2-NavigationLoginDispatcherV2  reason: not valid java name */
    public /* synthetic */ void m1936lambda$quickLogin$0$tvdanmakubiliuimain2NavigationLoginDispatcherV2(String spmid, Context context, NullableRef modelRef) throws Throwable {
        LoginModel model = (LoginModel) modelRef.value;
        if (model != null && (BiliContext.topActivitiy() instanceof IDrawerHost)) {
            TInfoLogin tInfoLogin = model.tInfoLogin;
            boolean isQuickLogin = model.isQuickLogin;
            Context ctx = getContext();
            SimpleAccountItem fastLoginAccount = model.fastLoginAccount;
            if (tInfoLogin == null) {
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_FAILED_TO_GET_LOGIN_INFO);
            }
            if (ctx == null) {
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_OUT_OF_LIFECYCLE_SCOPE);
            }
            if (tInfoLogin == null || ctx == null) {
                return;
            }
            if (!isQuickLogin) {
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_THE_LOGIN_WAY_IS_NOT_QUICK_WAY);
                LoginReporterV2.Error.report(LoginReporterV2.Error.APP_ONE_PASS_LOGIN_FAIL, LoginReporterV2.Error.SP_MID_ENTER_MY_INFO, "2");
                routeToSmsLoginDialog(ctx, tInfoLogin, model.getPhoneInfoError);
                BLog.d(TAG, "try show sms login dialog");
                return;
            } else if (LoginDialogInterceptor.onInterceptMineLoginQuickDialog()) {
                BLog.i(TAG, "mine > showing login quick dialog has been intercepted.");
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, "hit the login experiment : my_onepassguide_switch");
                return;
            } else {
                int loginWay = LoginRuleProcessor.INSTANCE.parseLoginWay(ctx, tInfoLogin, false);
                if (loginWay == 10 && fastLoginAccount != null) {
                    OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_TRY_FAST_LOGIN);
                    RouteUtilKt.routeFastReLoginDialog(context, mPromptScene, null, null, fastLoginAccount);
                } else {
                    switch (loginWay) {
                        case 1:
                            RouteUtilKt.routeToLoginQuickActivity(context, null, true, true, false, mPromptScene, null, null, null);
                            break;
                        case 2:
                            RouteUtilKt.routeToLoginQuickActivity(context, null, false, true, false, mPromptScene, null, null, null);
                            break;
                        case 3:
                            RouteUtilKt.routeToLoginQuickActivity(context, null, true, true, true, mPromptScene, null, null, null);
                            break;
                        default:
                            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, "the login way is not a quick way : " + loginWay);
                            break;
                    }
                }
                LoginSceneProcessor.INSTANCE.setScene("main_new");
                LoginReportHelper.INSTANCE.setFromSpmid(LoginReporterV2.Error.SP_MID_ENTER_MY_INFO);
                BLog.d(TAG, "start quick login");
                return;
            }
        }
        BLog.d(TAG, "model is null or is not home");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$quickLogin$1(String spmid, Throwable e) throws Throwable {
        if (e instanceof TimeoutException) {
            BLog.d(TAG, "cancel quick from clicking mine because time out");
            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_THE_REQUEST_TIME_OUT);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$quickLogin$2() throws Throwable {
    }

    @Override // tv.danmaku.bili.ui.main2.ILoginDispatcher
    public void clearQuickLoginCount() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        BiliGlobalPreferenceHelper sp = BiliGlobalPreferenceHelper.getInstance(context);
        sp.edit().remove(KEY_SP_QUICK_LOGIN_TIME).commit();
    }

    private Observable<NullableRef<LoginModel>> createGetLoginTypeObservable(final String spmid) {
        return Observable.create(new ObservableOnSubscribe() { // from class: tv.danmaku.bili.ui.main2.NavigationLoginDispatcherV2$$ExternalSyntheticLambda9
            public final void subscribe(ObservableEmitter observableEmitter) {
                NavigationLoginDispatcherV2.this.m1933lambda$createGetLoginTypeObservable$3$tvdanmakubiliuimain2NavigationLoginDispatcherV2(spmid, observableEmitter);
            }
        }).flatMap(new Function() { // from class: tv.danmaku.bili.ui.main2.NavigationLoginDispatcherV2$$ExternalSyntheticLambda10
            public final Object apply(Object obj) {
                return NavigationLoginDispatcherV2.this.m1934lambda$createGetLoginTypeObservable$4$tvdanmakubiliuimain2NavigationLoginDispatcherV2(spmid, (NavigationLoginDispatcherV2.NullableRef) obj);
            }
        }).flatMap(new Function() { // from class: tv.danmaku.bili.ui.main2.NavigationLoginDispatcherV2$$ExternalSyntheticLambda1
            public final Object apply(Object obj) {
                ObservableSource quickLoginInfo;
                quickLoginInfo = NavigationLoginDispatcherV2.this.getQuickLoginInfo((NavigationLoginDispatcherV2.NullableRef) obj);
                return quickLoginInfo;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPhoneInfo */
    public Observable<NullableRef<LoginModel>> m1934lambda$createGetLoginTypeObservable$4$tvdanmakubiliuimain2NavigationLoginDispatcherV2(final String spmid, NullableRef<TInfoLogin> tInfoLoginRef) {
        final Context context = getContext();
        if (context == null) {
            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_OUT_OF_LIFECYCLE_SCOPE);
        }
        final TInfoLogin tInfoLogin = tInfoLoginRef.value;
        if (tInfoLogin == null) {
            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_FAILED_TO_GET_LOGIN_INFO);
        }
        if (tInfoLogin == null || context == null) {
            BLog.d(TAG, "cancel show dialog because login rule is null");
            LoginQualityMonitor.INSTANCE.report("1", "3");
            return Observable.just(NullableRef.empty());
        }
        int loginWay = LoginRuleProcessor.INSTANCE.parseLoginWay(context, tInfoLogin);
        if (loginWay == 1 || loginWay == 2 || loginWay == 3) {
            LoginQualityMonitor.INSTANCE.report("1", "1");
            final String netType = LoginQuickManager.INSTANCE.getNetType(context);
            OnePassLoginPathLinkManager.INSTANCE.updateData(spmid, new Function1() { // from class: tv.danmaku.bili.ui.main2.NavigationLoginDispatcherV2$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    return NavigationLoginDispatcherV2.lambda$getPhoneInfo$5(netType, context, (OnePassLoginPhoneData) obj);
                }
            });
            OnePassLoginPathLinkManager.INSTANCE.onPhase(spmid, OnePassLoginPhaseType.CheckConditions.INSTANCE);
            if (LoginQuickManager.INSTANCE.isNetOk(netType, tInfoLogin.login.quick)) {
                return Observable.create(new ObservableOnSubscribe() { // from class: tv.danmaku.bili.ui.main2.NavigationLoginDispatcherV2$$ExternalSyntheticLambda6
                    public final void subscribe(ObservableEmitter observableEmitter) {
                        NavigationLoginDispatcherV2.this.m1935lambda$getPhoneInfo$6$tvdanmakubiliuimain2NavigationLoginDispatcherV2(context, spmid, tInfoLogin, observableEmitter);
                    }
                });
            }
            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_OPERATOR_DISALLOW);
            BLog.d(TAG, "try show login sms dialog because net is not ok");
            return Observable.just(NullableRef.of(new LoginModel(tInfoLogin, false)));
        }
        OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, "the login way is not a quick way : " + loginWay);
        BLog.d(TAG, "try show login sms dialog because login type is not allow quick login");
        LoginQualityMonitor.INSTANCE.report("1", "2");
        return Observable.just(NullableRef.of(new LoginModel(tInfoLogin, false)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ OnePassLoginPhoneData lambda$getPhoneInfo$5(String netType, Context context, OnePassLoginPhoneData data) {
        return new OnePassLoginPhoneData(netType, PhoneUtils.getOriginSimOperator(context) != null, PhoneUtils.isPad(context));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getPhoneInfo$6$tv-danmaku-bili-ui-main2-NavigationLoginDispatcherV2  reason: not valid java name */
    public /* synthetic */ void m1935lambda$getPhoneInfo$6$tvdanmakubiliuimain2NavigationLoginDispatcherV2(Context context, final String spmid, final TInfoLogin tInfoLogin, final ObservableEmitter subscriber) throws Throwable {
        LoginQuickManager.INSTANCE.getPhoneInfo(context, QuickLoginTag.MAIN, new LoginQuickManager.GetPhoneInfoCallBack() { // from class: tv.danmaku.bili.ui.main2.NavigationLoginDispatcherV2.1
            public void startGetPhoneInfo() {
            }

            public void endGetPhoneInfo(int result, LoginQuickManager.PhoneInfoBean rep) {
                if (rep != null) {
                    LoginQualityMonitor.INSTANCE.report("3", rep.getResultCode(), LoginQualityMonitor.INSTANCE.endMarkSpendTime(), rep.getSecurityPhone());
                } else {
                    LoginQualityMonitor.INSTANCE.report("3", LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR, LoginQualityMonitor.INSTANCE.endMarkSpendTime());
                }
                if (result == 1) {
                    OnePassLoginPathLinkManager.INSTANCE.onPhase(spmid, OnePassLoginPhaseType.GetNumberSuc.INSTANCE);
                    subscriber.onNext(NullableRef.of(new LoginModel(tInfoLogin, true)));
                    subscriber.onComplete();
                    return;
                }
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, "get phone info with error : " + (rep == null ? "" : rep.getMsg()));
                subscriber.onNext(NullableRef.of(new LoginModel(tInfoLogin, false, true)));
                BLog.d(NavigationLoginDispatcherV2.TAG, "try show login sms dialog because get phone info error");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getLoginType */
    public void m1933lambda$createGetLoginTypeObservable$3$tvdanmakubiliuimain2NavigationLoginDispatcherV2(final String spmid, final ObservableEmitter<NullableRef<TInfoLogin>> subscriber) {
        LoginRuleProcessor.INSTANCE.getLoginType(new LoginRuleProcessor.GetLoginTypeCallBack() { // from class: tv.danmaku.bili.ui.main2.NavigationLoginDispatcherV2.2
            @Override // tv.danmaku.bili.quick.core.LoginRuleProcessor.GetLoginTypeCallBack
            public void startGetLoginType() {
                OnePassLoginPathLinkManager.INSTANCE.onPhase(spmid, OnePassLoginPhaseType.PrepareRemoteLoginInfo.INSTANCE);
            }

            @Override // tv.danmaku.bili.quick.core.LoginRuleProcessor.GetLoginTypeCallBack
            public void endGetLoginType(int result, TInfoLogin infoLogin) {
                if (result == 1 && infoLogin != null) {
                    subscriber.onNext(NullableRef.of(infoLogin));
                } else {
                    OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_FAILED_TO_GET_LOGIN_INFO);
                    subscriber.onNext(NullableRef.empty());
                }
                subscriber.onComplete();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<NullableRef<LoginModel>> getQuickLoginInfo(NullableRef<LoginModel> loginModelRef) {
        Context ctx = getContext();
        final FragmentActivity act = ContextUtilKt.findFragmentActivityOrNull(ctx);
        final LoginModel loginModel = loginModelRef.value;
        if (loginModel == null || loginModel.tInfoLogin == null || ctx == null || act == null) {
            return Observable.just(NullableRef.of(loginModel));
        }
        final FastLoginInfo fastLoginInfo = BiliAccounts.get(ctx).getFastLoginInfo();
        if (fastLoginInfo != null) {
            BLog.i(TAG, "fast re-login, load user info");
            return Observable.create(new ObservableOnSubscribe() { // from class: tv.danmaku.bili.ui.main2.NavigationLoginDispatcherV2$$ExternalSyntheticLambda4
                public final void subscribe(ObservableEmitter observableEmitter) {
                    FastLoginUserHelper.INSTANCE.loadUserInfo(act, fastLoginInfo.getMid(), new Function1() { // from class: tv.danmaku.bili.ui.main2.NavigationLoginDispatcherV2$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            return NavigationLoginDispatcherV2.lambda$getQuickLoginInfo$7(observableEmitter, r2, (SimpleAccountItem) obj);
                        }
                    });
                }
            });
        }
        return Observable.just(NullableRef.of(loginModel));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$getQuickLoginInfo$7(ObservableEmitter subscriber, LoginModel loginModel, SimpleAccountItem account) {
        subscriber.onNext(NullableRef.of(new LoginModel(loginModel, account)));
        subscriber.onComplete();
        return Unit.INSTANCE;
    }

    private int getQuickLoginTimes(Context context) {
        BiliGlobalPreferenceHelper sp = BiliGlobalPreferenceHelper.getInstance(context);
        String json = sp.optString(KEY_SP_QUICK_LOGIN_TIME, "");
        LocalNavigationQuickRecord record = null;
        try {
            record = (LocalNavigationQuickRecord) JSON.parseObject(json, LocalNavigationQuickRecord.class);
        } catch (Exception e) {
        }
        if (record == null) {
            record = new LocalNavigationQuickRecord();
        }
        if (System.currentTimeMillis() - record.recordTime > this.gap) {
            record.count = 0;
        }
        return record.count;
    }

    private void routeToSmsLoginDialog(final Context ctx, final TInfoLogin infoLogin, boolean getPhoneInfoError) {
        if (infoLogin != null && infoLogin.isSmsLoginEnable()) {
            if (LoginDialogInterceptor.onInterceptMineSmsLoginDialog()) {
                BLog.i(TAG, "mine > showing sms dialog has been intercepted.");
                return;
            }
            SharedPreferences sharedPreferences = BiliGlobalPreferenceHelper.getBLKVSharedPreference(ctx);
            long lastShowTime = sharedPreferences.getLong(KEY_SP_SMS_LOGIN_TIME, 0L);
            if (System.currentTimeMillis() - lastShowTime < this.gap) {
                BLog.i(TAG, "lastShowTime " + lastShowTime);
                return;
            }
            LoginReportHelper.INSTANCE.setFromSpmid(LoginReporterV2.Error.SP_MID_ENTER_MY_INFO);
            if (getPhoneInfoError && infoLogin.ab != null && infoLogin.ab.isLoginPopupNonNet() && RouteUtilKt.hasCardAndOnlyWifi(ctx)) {
                FragmentActivity act = ContextUtilKt.findFragmentActivityOrNull(ctx);
                if (act != null) {
                    NetworkPermissionDialog.Companion.newInstance(infoLogin).showNow(act.getSupportFragmentManager(), null, new Function1() { // from class: tv.danmaku.bili.ui.main2.NavigationLoginDispatcherV2$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj) {
                            return NavigationLoginDispatcherV2.lambda$routeToSmsLoginDialog$9(ctx, infoLogin, (NetworkDialogResult) obj);
                        }
                    });
                    return;
                }
                return;
            }
            String str = mPromptScene;
            boolean z = false;
            if (infoLogin.ab != null && infoLogin.ab.isSmsLoginExp()) {
                z = true;
            }
            RouteUtilKt.showSmsLoginDialog(ctx, SmsLoginDialogUtilKt.FROM_USER_CENTER, str, false, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$routeToSmsLoginDialog$9(Context ctx, TInfoLogin infoLogin, NetworkDialogResult res) {
        if (res instanceof NetworkDialogResult.OtherWays) {
            RouteUtilKt.showSmsLoginDialog(ctx, SmsLoginDialogUtilKt.FROM_USER_CENTER, mPromptScene, false, infoLogin.ab.isSmsLoginExp());
            return null;
        } else if (res instanceof NetworkDialogResult.HasOpenNetwork) {
            NetworkPermissionDialogKt.retryQuickLogin(ctx, infoLogin, ((NetworkDialogResult.HasOpenNetwork) res).getGetPhoneInfoSuc());
            return null;
        } else {
            return null;
        }
    }

    private Context getContext() {
        if (this.mContextRef != null) {
            return this.mContextRef.get();
        }
        return null;
    }

    public void updateOnePass(Context context) {
        BiliGlobalPreferenceHelper sp = BiliGlobalPreferenceHelper.getInstance(context);
        String json = sp.optString(KEY_SP_QUICK_LOGIN_TIME, "");
        LocalNavigationQuickRecord record = null;
        try {
            record = (LocalNavigationQuickRecord) JSON.parseObject(json, LocalNavigationQuickRecord.class);
        } catch (Exception e) {
        }
        if (record == null) {
            record = new LocalNavigationQuickRecord();
        }
        if (System.currentTimeMillis() - record.recordTime > this.gap) {
            record.count = 0;
        }
        record.recordTime = System.currentTimeMillis();
        record.count++;
        sp.edit().putString(KEY_SP_QUICK_LOGIN_TIME, JSON.toJSONString(record)).apply();
    }

    public void updateSms(Context context) {
        SharedPreferences sharedPreferences = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        sharedPreferences.edit().putLong(KEY_SP_SMS_LOGIN_TIME, System.currentTimeMillis()).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class LocalNavigationQuickRecord {
        @JSONField(name = "count")
        public int count;
        @JSONField(name = "recordTime")
        public long recordTime;

        LocalNavigationQuickRecord() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class LoginModel {
        public SimpleAccountItem fastLoginAccount;
        public boolean getPhoneInfoError;
        public boolean isQuickLogin;
        public TInfoLogin tInfoLogin;

        LoginModel(TInfoLogin tInfoLogin, boolean isQuickLogin, SimpleAccountItem fastLoginAccount) {
            this.tInfoLogin = tInfoLogin;
            this.isQuickLogin = isQuickLogin;
            this.fastLoginAccount = fastLoginAccount;
        }

        LoginModel(TInfoLogin tInfoLogin, boolean isQuickLogin) {
            this.tInfoLogin = tInfoLogin;
            this.isQuickLogin = isQuickLogin;
            this.fastLoginAccount = null;
        }

        LoginModel(TInfoLogin tInfoLogin, boolean isQuickLogin, boolean getPhoneInfoError) {
            this.tInfoLogin = tInfoLogin;
            this.isQuickLogin = isQuickLogin;
            this.fastLoginAccount = null;
            this.getPhoneInfoError = getPhoneInfoError;
        }

        LoginModel(LoginModel origin, SimpleAccountItem fastLoginAccount) {
            this.tInfoLogin = origin.tInfoLogin;
            this.isQuickLogin = origin.isQuickLogin;
            this.fastLoginAccount = fastLoginAccount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class NullableRef<T> {
        T value;

        NullableRef(T value) {
            this.value = value;
        }

        static <T> NullableRef<T> of(T value) {
            return new NullableRef<>(value);
        }

        static <T> NullableRef<T> empty() {
            return new NullableRef<>(null);
        }
    }
}