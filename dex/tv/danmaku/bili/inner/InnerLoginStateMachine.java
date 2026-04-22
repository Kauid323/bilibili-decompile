package tv.danmaku.bili.inner;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.PhoneUtils;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.FastLoginInfo;
import com.bilibili.lib.accounts.model.SimpleAccountItem;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import com.freeletics.mad.statemachine.StateMachine;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.service.IFastLoginStateMachineFactory;
import tv.danmaku.bili.fullscreen.service.IOverseaLoginStateMachineFactory;
import tv.danmaku.bili.fullscreen.service.IPhoneOnePassStateMachineFactory;
import tv.danmaku.bili.fullscreen.service.IPhoneService;
import tv.danmaku.bili.fullscreen.service.IspCode;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.PhoneInfo;
import tv.danmaku.bili.fullscreen.service.TechTrackService;
import tv.danmaku.bili.fullscreen.state.FastLoginFailed;
import tv.danmaku.bili.fullscreen.state.FastLoginPage;
import tv.danmaku.bili.fullscreen.state.FastLoginRiskControl;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginDowngradeState;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginFastPage;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginPhoneIdlePage;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginPhonePage;
import tv.danmaku.bili.fullscreen.state.FullscreenOverseaPage;
import tv.danmaku.bili.fullscreen.state.FullscreenPhoneOrPasswordPage;
import tv.danmaku.bili.fullscreen.state.IFastLoginPage;
import tv.danmaku.bili.fullscreen.state.IFullscreenAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenActionPage;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginState;
import tv.danmaku.bili.fullscreen.state.IOverseaLoginState;
import tv.danmaku.bili.fullscreen.state.IPhoneOnePassState;
import tv.danmaku.bili.fullscreen.state.IPhoneOrPasswordLoginPage;
import tv.danmaku.bili.fullscreen.state.OverseaLoginState;
import tv.danmaku.bili.fullscreen.state.PhoneOnePassLoginState;
import tv.danmaku.bili.fullscreen.state.PhoneOrPasswordLoginIdlePage;
import tv.danmaku.bili.fullscreen.state.PhoneOrPasswordLoginStateMachine;
import tv.danmaku.bili.fullscreen.state.SmsLoginPageInitialState;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;
import tv.danmaku.bili.quick.core.OnePassLoginPhoneData;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;

/* compiled from: InnerLoginStateMachine.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BG\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u0017J$\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/inner/InnerLoginStateMachine;", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "phoneService", "Ltv/danmaku/bili/fullscreen/service/IPhoneService;", "techTrackService", "Ltv/danmaku/bili/fullscreen/service/TechTrackService;", "loginReportService", "Ltv/danmaku/bili/fullscreen/service/LoginReportService;", "phoneStateMachineProvider", "Ltv/danmaku/bili/fullscreen/service/IPhoneOnePassStateMachineFactory;", "fastLoginStateMachineProvider", "Ltv/danmaku/bili/fullscreen/service/IFastLoginStateMachineFactory;", "phoneOrPasswordStateMachineProvider", "Ljavax/inject/Provider;", "Ltv/danmaku/bili/fullscreen/state/PhoneOrPasswordLoginStateMachine;", "overseaStateMachineProvider", "Ltv/danmaku/bili/fullscreen/service/IOverseaLoginStateMachineFactory;", "<init>", "(Ltv/danmaku/bili/fullscreen/service/IPhoneService;Ltv/danmaku/bili/fullscreen/service/TechTrackService;Ltv/danmaku/bili/fullscreen/service/LoginReportService;Ltv/danmaku/bili/fullscreen/service/IPhoneOnePassStateMachineFactory;Ltv/danmaku/bili/fullscreen/service/IFastLoginStateMachineFactory;Ljavax/inject/Provider;Ltv/danmaku/bili/fullscreen/service/IOverseaLoginStateMachineFactory;)V", "getAccountInfo", "Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLoginState", "skipFastLogin", "", "skipQuickLogin", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerLoginStateMachine extends FlowReduxStateMachine<IFullscreenLoginState, IFullscreenAction> {
    public static final int $stable = 8;
    private final IFastLoginStateMachineFactory fastLoginStateMachineProvider;
    private final LoginReportService loginReportService;
    private final IOverseaLoginStateMachineFactory overseaStateMachineProvider;
    private final Provider<PhoneOrPasswordLoginStateMachine> phoneOrPasswordStateMachineProvider;
    private final IPhoneService phoneService;
    private final IPhoneOnePassStateMachineFactory phoneStateMachineProvider;
    private final TechTrackService techTrackService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public InnerLoginStateMachine(IPhoneService phoneService, TechTrackService techTrackService, LoginReportService loginReportService, IPhoneOnePassStateMachineFactory phoneStateMachineProvider, IFastLoginStateMachineFactory fastLoginStateMachineProvider, Provider<PhoneOrPasswordLoginStateMachine> provider, IOverseaLoginStateMachineFactory overseaStateMachineProvider) {
        super(FullscreenLoginPhoneIdlePage.INSTANCE);
        Intrinsics.checkNotNullParameter(phoneService, "phoneService");
        Intrinsics.checkNotNullParameter(techTrackService, "techTrackService");
        Intrinsics.checkNotNullParameter(loginReportService, "loginReportService");
        Intrinsics.checkNotNullParameter(phoneStateMachineProvider, "phoneStateMachineProvider");
        Intrinsics.checkNotNullParameter(fastLoginStateMachineProvider, "fastLoginStateMachineProvider");
        Intrinsics.checkNotNullParameter(provider, "phoneOrPasswordStateMachineProvider");
        Intrinsics.checkNotNullParameter(overseaStateMachineProvider, "overseaStateMachineProvider");
        this.phoneService = phoneService;
        this.techTrackService = techTrackService;
        this.loginReportService = loginReportService;
        this.phoneStateMachineProvider = phoneStateMachineProvider;
        this.fastLoginStateMachineProvider = fastLoginStateMachineProvider;
        this.phoneOrPasswordStateMachineProvider = provider;
        this.overseaStateMachineProvider = overseaStateMachineProvider;
        spec(new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = InnerLoginStateMachine._init_$lambda$0(InnerLoginStateMachine.this, (FlowReduxStoreBuilder) obj);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAccountInfo(Continuation<? super SimpleAccountItem> continuation) {
        FragmentActivity activity;
        BLog.i(InnerLoginViewModelKt.TAG_INNER_LOGIN, "Start get fast account info");
        Object $this$asTo$iv = BiliContext.topActivity();
        if ($this$asTo$iv == null) {
            activity = null;
        } else {
            if (!($this$asTo$iv instanceof FragmentActivity)) {
                $this$asTo$iv = null;
            }
            activity = (FragmentActivity) $this$asTo$iv;
        }
        SimpleAccountItem emptyAccount = new SimpleAccountItem(0L, "", "");
        FastLoginInfo fastLoginInfo = BiliAccounts.get(activity).getFastLoginInfo();
        return fastLoginInfo == null ? emptyAccount : BuildersKt.withContext(Dispatchers.getIO(), new InnerLoginStateMachine$getAccountInfo$2(activity, fastLoginInfo, emptyAccount, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getLoginState(boolean skipFastLogin, boolean skipQuickLogin, Continuation<? super IFullscreenLoginState> continuation) {
        Continuation<? super PhoneInfo> innerLoginStateMachine$getLoginState$1;
        boolean skipQuickLogin2;
        Object suspendGetLoginType$default;
        Activity context;
        boolean skipFastLogin2;
        InnerLoginStateMachine innerLoginStateMachine;
        TInfoLogin infoLogin;
        Activity context2;
        FullscreenLoginFastPage fullscreenLoginFastPage;
        TInfoLogin infoLogin2;
        InnerLoginStateMachine innerLoginStateMachine2;
        Object accountInfo;
        Activity context3;
        TInfoLogin infoLogin3;
        boolean skipQuickLogin3;
        FullscreenLoginFastPage fastLoginState;
        FullscreenLoginPhonePage fullscreenLoginPhonePage;
        Object phoneInfo;
        SimpleAccountItem fastAccountInfo;
        FullscreenLoginPhonePage quickLoginState;
        PhoneInfo phone;
        if (continuation instanceof InnerLoginStateMachine$getLoginState$1) {
            innerLoginStateMachine$getLoginState$1 = (InnerLoginStateMachine$getLoginState$1) continuation;
            if ((innerLoginStateMachine$getLoginState$1.label & Integer.MIN_VALUE) != 0) {
                innerLoginStateMachine$getLoginState$1.label -= Integer.MIN_VALUE;
                Object $result = innerLoginStateMachine$getLoginState$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (innerLoginStateMachine$getLoginState$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        BLog.i(InnerLoginViewModelKt.TAG_INNER_LOGIN, "getLoginState:skipFastLogin=" + (skipFastLogin) + " , skipQuickLogin=" + (skipQuickLogin));
                        if (!skipFastLogin || !skipQuickLogin) {
                            Activity activity = BiliContext.topActivity();
                            if (activity != null) {
                                this.techTrackService.onPhase(this.loginReportService.getSpmid(), OnePassLoginPhaseType.PrepareRemoteLoginInfo.INSTANCE);
                                LoginRuleProcessor loginRuleProcessor = LoginRuleProcessor.INSTANCE;
                                innerLoginStateMachine$getLoginState$1.L$0 = activity;
                                innerLoginStateMachine$getLoginState$1.Z$0 = skipFastLogin;
                                innerLoginStateMachine$getLoginState$1.Z$1 = skipQuickLogin;
                                innerLoginStateMachine$getLoginState$1.label = 1;
                                skipQuickLogin2 = skipQuickLogin;
                                suspendGetLoginType$default = LoginRuleProcessor.suspendGetLoginType$default(loginRuleProcessor, false, false, innerLoginStateMachine$getLoginState$1, 2, null);
                                if (suspendGetLoginType$default != coroutine_suspended) {
                                    context = activity;
                                    skipFastLogin2 = skipFastLogin;
                                    innerLoginStateMachine = this;
                                    break;
                                } else {
                                    return coroutine_suspended;
                                }
                            } else {
                                this.techTrackService.stopWithReason(this.loginReportService.getSpmid(), OnePassLoginReportManagerKt.INTERRUPTED_FOR_OUT_OF_LIFECYCLE_SCOPE);
                                return null;
                            }
                        } else {
                            return new FullscreenPhoneOrPasswordPage(PhoneOrPasswordLoginIdlePage.INSTANCE);
                        }
                    case 1:
                        boolean skipQuickLogin4 = innerLoginStateMachine$getLoginState$1.Z$1;
                        skipFastLogin2 = innerLoginStateMachine$getLoginState$1.Z$0;
                        context = (Activity) innerLoginStateMachine$getLoginState$1.L$0;
                        ResultKt.throwOnFailure($result);
                        skipQuickLogin2 = skipQuickLogin4;
                        innerLoginStateMachine = this;
                        suspendGetLoginType$default = $result;
                        break;
                    case 2:
                        innerLoginStateMachine2 = this;
                        skipQuickLogin3 = innerLoginStateMachine$getLoginState$1.Z$0;
                        Activity context4 = (Activity) innerLoginStateMachine$getLoginState$1.L$0;
                        ResultKt.throwOnFailure($result);
                        context3 = context4;
                        infoLogin3 = (TInfoLogin) innerLoginStateMachine$getLoginState$1.L$1;
                        accountInfo = $result;
                        fastAccountInfo = (SimpleAccountItem) accountInfo;
                        BLog.i(InnerLoginViewModelKt.TAG_INNER_LOGIN, "getLoginState:fastAccountInfo=" + fastAccountInfo);
                        if (fastAccountInfo.getMid() <= 0) {
                            fullscreenLoginFastPage = new FullscreenLoginFastPage(new FastLoginPage(fastAccountInfo, false, null, false, false, null, null, null, null, BR.roleName, null));
                            skipQuickLogin2 = skipQuickLogin3;
                            infoLogin2 = infoLogin3;
                            context2 = context3;
                        } else {
                            skipQuickLogin2 = skipQuickLogin3;
                            infoLogin2 = infoLogin3;
                            context2 = context3;
                            fullscreenLoginFastPage = null;
                        }
                        fastLoginState = fullscreenLoginFastPage;
                        if (fastLoginState != null) {
                            innerLoginStateMachine2.techTrackService.stopWithReason(innerLoginStateMachine2.loginReportService.getSpmid(), OnePassLoginReportManagerKt.INTERRUPTED_FOR_TRY_FAST_LOGIN);
                            return fastLoginState;
                        }
                        int mLoginWay = LoginRuleProcessor.INSTANCE.parseLoginWay(context2, infoLogin2, true);
                        BLog.i(InnerLoginViewModelKt.TAG_INNER_LOGIN, "getLoginState:mLoginWay=" + mLoginWay + " after skip fast login");
                        TInfoLogin.LoginBean loginBean = infoLogin2.login;
                        TInfoLogin.QuickBean quickBean = loginBean != null ? loginBean.quick : null;
                        if (quickBean == null || skipQuickLogin2 || !(mLoginWay == 1 || mLoginWay == 2 || mLoginWay == 3)) {
                            innerLoginStateMachine2.techTrackService.stopWithReason(innerLoginStateMachine2.loginReportService.getSpmid(), OnePassLoginReportManagerKt.INTERRUPTED_FOR_THE_LOGIN_WAY_IS_NOT_QUICK_WAY);
                            fullscreenLoginPhonePage = null;
                        } else {
                            String netType = LoginQuickManager.INSTANCE.getNetType(context2);
                            innerLoginStateMachine2.techTrackService.updateData(innerLoginStateMachine2.loginReportService.getSpmid(), new OnePassLoginPhoneData(netType, PhoneUtils.getOriginSimOperator(context2) != null, PhoneUtils.isPad(context2)));
                            Pair allowQuick = LoginQuickManager.INSTANCE.isNetOkWhitType(netType, quickBean);
                            if (((Boolean) allowQuick.getSecond()).booleanValue()) {
                                IPhoneService iPhoneService = innerLoginStateMachine2.phoneService;
                                innerLoginStateMachine$getLoginState$1.L$0 = context2;
                                innerLoginStateMachine$getLoginState$1.L$1 = infoLogin2;
                                innerLoginStateMachine$getLoginState$1.label = 3;
                                phoneInfo = iPhoneService.getPhoneInfo(innerLoginStateMachine$getLoginState$1);
                                if (phoneInfo == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                phone = (PhoneInfo) phoneInfo;
                                if (!StringsKt.isBlank(phone.getSecurePhone()) || phone.getIspCode() == IspCode.Unknown) {
                                    innerLoginStateMachine2.techTrackService.stopWithReason(innerLoginStateMachine2.loginReportService.getSpmid(), OnePassLoginReportManagerKt.INTERRUPTED_FOR_GET_PHONE_INFO_WITH_ERROR);
                                    fullscreenLoginPhonePage = null;
                                } else {
                                    innerLoginStateMachine2.techTrackService.onPhase(innerLoginStateMachine2.loginReportService.getSpmid(), OnePassLoginPhaseType.GetNumberSuc.INSTANCE);
                                    fullscreenLoginPhonePage = new FullscreenLoginPhonePage(new PhoneOnePassLoginState(phone, false, null, false, null, null, null, BR.countdownTotal, null));
                                }
                            } else {
                                innerLoginStateMachine2.techTrackService.stopWithReason(innerLoginStateMachine2.loginReportService.getSpmid(), OnePassLoginReportManagerKt.INTERRUPTED_FOR_OPERATOR_DISALLOW);
                                fullscreenLoginPhonePage = null;
                            }
                        }
                        quickLoginState = fullscreenLoginPhonePage;
                        if (quickLoginState == null) {
                            return quickLoginState;
                        }
                        boolean netTypeUnavailable = StringsKt.isBlank(LoginQuickManager.INSTANCE.getNetType(context2));
                        TInfoLogin.LoginBean loginBean2 = infoLogin2.login;
                        TInfoLogin.LoginBean.SnsLoginBean snsBean = loginBean2 != null ? loginBean2.sns : null;
                        FullscreenOverseaPage snsLoginState = (snsBean == null || snsBean.rank == 0 || !netTypeUnavailable) ? null : new FullscreenOverseaPage(new OverseaLoginState(new SmsLoginPageInitialState(null, 1, null), infoLogin2, null, null, null, false, false, null, BR.guideBarPaddingTop, null));
                        return snsLoginState != null ? snsLoginState : new FullscreenPhoneOrPasswordPage(PhoneOrPasswordLoginIdlePage.INSTANCE);
                    case 3:
                        innerLoginStateMachine2 = this;
                        infoLogin2 = (TInfoLogin) innerLoginStateMachine$getLoginState$1.L$1;
                        context2 = (Activity) innerLoginStateMachine$getLoginState$1.L$0;
                        ResultKt.throwOnFailure($result);
                        phoneInfo = $result;
                        phone = (PhoneInfo) phoneInfo;
                        if (StringsKt.isBlank(phone.getSecurePhone())) {
                            break;
                        }
                        innerLoginStateMachine2.techTrackService.stopWithReason(innerLoginStateMachine2.loginReportService.getSpmid(), OnePassLoginReportManagerKt.INTERRUPTED_FOR_GET_PHONE_INFO_WITH_ERROR);
                        fullscreenLoginPhonePage = null;
                        quickLoginState = fullscreenLoginPhonePage;
                        if (quickLoginState == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                infoLogin = (TInfoLogin) ((Pair) suspendGetLoginType$default).getSecond();
                if (infoLogin != null) {
                    innerLoginStateMachine.techTrackService.stopWithReason(innerLoginStateMachine.loginReportService.getSpmid(), OnePassLoginReportManagerKt.INTERRUPTED_FOR_FAILED_TO_GET_LOGIN_INFO);
                    return new FullscreenPhoneOrPasswordPage(PhoneOrPasswordLoginIdlePage.INSTANCE);
                }
                innerLoginStateMachine.techTrackService.onPhase(innerLoginStateMachine.loginReportService.getSpmid(), OnePassLoginPhaseType.CheckConditions.INSTANCE);
                int mLoginWay2 = LoginRuleProcessor.INSTANCE.parseLoginWay(context, infoLogin, skipFastLogin2);
                BLog.i(InnerLoginViewModelKt.TAG_INNER_LOGIN, "getLoginState:mLoginWay=" + mLoginWay2);
                if (skipFastLogin2 || mLoginWay2 != 10) {
                    context2 = context;
                    fullscreenLoginFastPage = null;
                    InnerLoginStateMachine innerLoginStateMachine3 = innerLoginStateMachine;
                    infoLogin2 = infoLogin;
                    innerLoginStateMachine2 = innerLoginStateMachine3;
                    fastLoginState = fullscreenLoginFastPage;
                    if (fastLoginState != null) {
                    }
                } else {
                    innerLoginStateMachine$getLoginState$1.L$0 = context;
                    innerLoginStateMachine$getLoginState$1.L$1 = infoLogin;
                    innerLoginStateMachine$getLoginState$1.Z$0 = skipQuickLogin2;
                    innerLoginStateMachine$getLoginState$1.label = 2;
                    accountInfo = innerLoginStateMachine.getAccountInfo(innerLoginStateMachine$getLoginState$1);
                    if (accountInfo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    context3 = context;
                    infoLogin3 = infoLogin;
                    innerLoginStateMachine2 = innerLoginStateMachine;
                    skipQuickLogin3 = skipQuickLogin2;
                    fastAccountInfo = (SimpleAccountItem) accountInfo;
                    BLog.i(InnerLoginViewModelKt.TAG_INNER_LOGIN, "getLoginState:fastAccountInfo=" + fastAccountInfo);
                    if (fastAccountInfo.getMid() <= 0) {
                    }
                    fastLoginState = fullscreenLoginFastPage;
                    if (fastLoginState != null) {
                    }
                }
            }
        }
        innerLoginStateMachine$getLoginState$1 = new InnerLoginStateMachine$getLoginState$1(this, continuation);
        Object $result2 = innerLoginStateMachine$getLoginState$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (innerLoginStateMachine$getLoginState$1.label) {
        }
        infoLogin = (TInfoLogin) ((Pair) suspendGetLoginType$default).getSecond();
        if (infoLogin != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object getLoginState$default(InnerLoginStateMachine innerLoginStateMachine, boolean z, boolean z2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return innerLoginStateMachine.getLoginState(z, z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final InnerLoginStateMachine this$0, FlowReduxStoreBuilder $this$spec) {
        Intrinsics.checkNotNullParameter($this$spec, "$this$spec");
        Function1 block$iv = new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                return InnerLoginStateMachine.lambda$0$0(InnerLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(FullscreenLoginPhoneIdlePage.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda16
            public final Object invoke(Object obj) {
                return InnerLoginStateMachine.lambda$0$1(InnerLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(FullscreenLoginFastPage.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda17
            public final Object invoke(Object obj) {
                return InnerLoginStateMachine.lambda$0$2(InnerLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(FullscreenLoginPhonePage.class), block$iv3);
        Function1 block$iv4 = new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda18
            public final Object invoke(Object obj) {
                return InnerLoginStateMachine.lambda$0$3(InnerLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(FullscreenLoginDowngradeState.class), block$iv4);
        Function1 block$iv5 = new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda19
            public final Object invoke(Object obj) {
                return InnerLoginStateMachine.lambda$0$4(InnerLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(FullscreenPhoneOrPasswordPage.class), block$iv5);
        Function1 block$iv6 = new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return InnerLoginStateMachine.lambda$0$5(InnerLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(FullscreenOverseaPage.class), block$iv6);
        Function1 block$iv7 = new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return InnerLoginStateMachine.lambda$0$6(InnerLoginStateMachine.this, (InStateBuilderBlock) obj);
            }
        };
        $this$spec.inState(Reflection.getOrCreateKotlinClass(IFullscreenActionPage.class), block$iv7);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(InnerLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new InnerLoginStateMachine$1$1$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$1(final InnerLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnterEffect(new InnerLoginStateMachine$1$2$1(this$0, null));
        $this$inState.onEnterStartStateMachine(new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return InnerLoginStateMachine.lambda$0$1$0(InnerLoginStateMachine.this, (FullscreenLoginFastPage) obj);
            }
        }, new Function2() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda11
            public final Object invoke(Object obj, Object obj2) {
                return InnerLoginStateMachine.lambda$0$1$1((State) obj, (IFastLoginPage) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final StateMachine lambda$0$1$0(InnerLoginStateMachine this$0, FullscreenLoginFastPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.fastLoginStateMachineProvider.create(it.getCurrentPage());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ChangedState lambda$0$1$1(State state, final IFastLoginPage iFastLoginState) {
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        Intrinsics.checkNotNullParameter(iFastLoginState, "iFastLoginState");
        if ((iFastLoginState instanceof FastLoginRiskControl) || (iFastLoginState instanceof FastLoginFailed)) {
            BLog.e(InnerLoginViewModelKt.TAG_INNER_LOGIN, "fastLoginMachineStateMapper:iFastLoginState=" + iFastLoginState.getClass().getSimpleName());
            return state.override(new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda9
                public final Object invoke(Object obj) {
                    return InnerLoginStateMachine.lambda$0$1$1$0(IFastLoginPage.this, (FullscreenLoginFastPage) obj);
                }
            });
        }
        return state.override(new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                return InnerLoginStateMachine.lambda$0$1$1$1(IFastLoginPage.this, (FullscreenLoginFastPage) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final FullscreenLoginDowngradeState lambda$0$1$1$0(IFastLoginPage $iFastLoginState, FullscreenLoginFastPage $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return new FullscreenLoginDowngradeState($iFastLoginState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final FullscreenLoginFastPage lambda$0$1$1$1(IFastLoginPage $iFastLoginState, FullscreenLoginFastPage $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return new FullscreenLoginFastPage($iFastLoginState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$2(final InnerLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnterEffect(new InnerLoginStateMachine$1$3$1(this$0, null));
        $this$inState.onEnterStartStateMachine(new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return InnerLoginStateMachine.lambda$0$2$0(InnerLoginStateMachine.this, (FullscreenLoginPhonePage) obj);
            }
        }, new Function2() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2) {
                return InnerLoginStateMachine.lambda$0$2$1((State) obj, (IPhoneOnePassState) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final StateMachine lambda$0$2$0(InnerLoginStateMachine this$0, FullscreenLoginPhonePage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.phoneStateMachineProvider.create(it.getCurrentPage());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ChangedState lambda$0$2$1(State state, final IPhoneOnePassState iPhoneOnePassState) {
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        Intrinsics.checkNotNullParameter(iPhoneOnePassState, "iPhoneOnePassState");
        return state.override(new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return InnerLoginStateMachine.lambda$0$2$1$0(IPhoneOnePassState.this, (FullscreenLoginPhonePage) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final FullscreenLoginPhonePage lambda$0$2$1$0(IPhoneOnePassState $iPhoneOnePassState, FullscreenLoginPhonePage $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return new FullscreenLoginPhonePage($iPhoneOnePassState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$3(InnerLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new InnerLoginStateMachine$1$4$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$4(final InnerLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnterStartStateMachine(new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return InnerLoginStateMachine.lambda$0$4$0(InnerLoginStateMachine.this, (FullscreenPhoneOrPasswordPage) obj);
            }
        }, new Function2() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                return InnerLoginStateMachine.lambda$0$4$1((State) obj, (IPhoneOrPasswordLoginPage) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final StateMachine lambda$0$4$0(InnerLoginStateMachine this$0, FullscreenPhoneOrPasswordPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object obj = this$0.phoneOrPasswordStateMachineProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return (StateMachine) obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ChangedState lambda$0$4$1(State state, IPhoneOrPasswordLoginPage iPhoneOrPasswordLoginPage) {
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        Intrinsics.checkNotNullParameter(iPhoneOrPasswordLoginPage, "<unused var>");
        return state.noChange();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$5(final InnerLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BLog.e("oversea", "InnerLoginStateMachine inState<FullscreenOverseaPage>");
        $this$inState.onEnterEffect(new InnerLoginStateMachine$1$6$1(this$0, null));
        $this$inState.onEnterStartStateMachine(new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                return InnerLoginStateMachine.lambda$0$5$0(InnerLoginStateMachine.this, (FullscreenOverseaPage) obj);
            }
        }, new Function2() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda13
            public final Object invoke(Object obj, Object obj2) {
                return InnerLoginStateMachine.lambda$0$5$1((State) obj, (IOverseaLoginState) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final StateMachine lambda$0$5$0(InnerLoginStateMachine this$0, FullscreenOverseaPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.overseaStateMachineProvider.create(it.getCurrentPage());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ChangedState lambda$0$5$1(State state, final IOverseaLoginState loginState) {
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        Intrinsics.checkNotNullParameter(loginState, "loginState");
        return state.override(new Function1() { // from class: tv.danmaku.bili.inner.InnerLoginStateMachine$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                return InnerLoginStateMachine.lambda$0$5$1$0(IOverseaLoginState.this, (FullscreenOverseaPage) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final FullscreenOverseaPage lambda$0$5$1$0(IOverseaLoginState $loginState, FullscreenOverseaPage $this$override) {
        Intrinsics.checkNotNullParameter($this$override, "$this$override");
        return new FullscreenOverseaPage($loginState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$6(InnerLoginStateMachine this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new InnerLoginStateMachine$1$7$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.TryOtherLoginWay.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new InnerLoginStateMachine$1$7$2(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.TryOtherLoginWay.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }
}