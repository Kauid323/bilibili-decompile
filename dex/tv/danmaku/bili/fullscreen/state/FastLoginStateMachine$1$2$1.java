package tv.danmaku.bili.fullscreen.state;

import androidx.fragment.app.FragmentActivity;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accountsui.AccountResult;
import com.bilibili.lib.accountsui.AccountStatus;
import com.bilibili.lib.accountsui.TrackParams;
import com.bilibili.lib.accountsui.fast.FastLoginHandler;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.stat.Fast;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FastLoginPage.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/IFastLoginPage;", "it", "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/FastLoginLoadingPage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$1$2$1", f = "FastLoginPage.kt", i = {0}, l = {152}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
public final class FastLoginStateMachine$1$2$1 extends SuspendLambda implements Function2<State<FastLoginLoadingPage>, Continuation<? super ChangedState<? extends IFastLoginPage>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FastLoginStateMachine this$0;

    /* compiled from: FastLoginPage.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AccountStatus.values().length];
            try {
                iArr[AccountStatus.RISK_CONTROL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[AccountStatus.FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[AccountStatus.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastLoginStateMachine$1$2$1(FastLoginStateMachine fastLoginStateMachine, Continuation<? super FastLoginStateMachine$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = fastLoginStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fastLoginStateMachine$1$2$1 = new FastLoginStateMachine$1$2$1(this.this$0, continuation);
        fastLoginStateMachine$1$2$1.L$0 = obj;
        return fastLoginStateMachine$1$2$1;
    }

    public final Object invoke(State<FastLoginLoadingPage> state, Continuation<? super ChangedState<? extends IFastLoginPage>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0074 A[Catch: Exception -> 0x00d2, TryCatch #1 {Exception -> 0x00d2, blocks: (B:24:0x0063, B:25:0x0071, B:26:0x0074, B:31:0x00ce, B:32:0x00d1, B:27:0x0077, B:28:0x00b9, B:29:0x00c3), top: B:43:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0077 A[Catch: Exception -> 0x00d2, TryCatch #1 {Exception -> 0x00d2, blocks: (B:24:0x0063, B:25:0x0071, B:26:0x0074, B:31:0x00ce, B:32:0x00d1, B:27:0x0077, B:28:0x00b9, B:29:0x00c3), top: B:43:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b9 A[Catch: Exception -> 0x00d2, TryCatch #1 {Exception -> 0x00d2, blocks: (B:24:0x0063, B:25:0x0071, B:26:0x0074, B:31:0x00ce, B:32:0x00d1, B:27:0x0077, B:28:0x00b9, B:29:0x00c3), top: B:43:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c3 A[Catch: Exception -> 0x00d2, TryCatch #1 {Exception -> 0x00d2, blocks: (B:24:0x0063, B:25:0x0071, B:26:0x0074, B:31:0x00ce, B:32:0x00d1, B:27:0x0077, B:28:0x00b9, B:29:0x00c3), top: B:43:0x0063 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        State it;
        Exception e;
        State it2;
        Object $result2;
        AccountResult result;
        Object $result3;
        LoginReportService loginReportService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                it = (State) this.L$0;
                try {
                    FastLoginHandler fastLoginHandler = FastLoginHandler.INSTANCE;
                    Object $this$asTo$iv = BiliContext.topActivity();
                    if ($this$asTo$iv != null) {
                        if (!($this$asTo$iv instanceof FragmentActivity)) {
                            $this$asTo$iv = null;
                        }
                        FragmentActivity fragmentActivity = (FragmentActivity) $this$asTo$iv;
                        if (fragmentActivity != null) {
                            this.L$0 = it;
                            this.label = 1;
                            Object fastLogin = fastLoginHandler.fastLogin(fragmentActivity, new TrackParams(LoginReportHelper.INSTANCE.getLoginSessionId(), LoginReportHelper.INSTANCE.getFromSpmid(), "", LoginReportHelper.INSTANCE.getExtend()), (Continuation) this);
                            if (fastLogin == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result2 = $result;
                            $result = fastLogin;
                            try {
                                result = (AccountResult) $result;
                                switch (WhenMappings.$EnumSwitchMapping$0[result.getStatus().ordinal()]) {
                                    case 1:
                                        $result3 = it.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$1$2$1$$ExternalSyntheticLambda0
                                            public final Object invoke(Object obj) {
                                                FastLoginRiskControl invokeSuspend$lambda$0;
                                                invokeSuspend$lambda$0 = FastLoginStateMachine$1$2$1.invokeSuspend$lambda$0((FastLoginLoadingPage) obj);
                                                return invokeSuspend$lambda$0;
                                            }
                                        });
                                        break;
                                    case 2:
                                        $result3 = it.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$1$2$1$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj) {
                                                FastLoginFailed invokeSuspend$lambda$1;
                                                invokeSuspend$lambda$1 = FastLoginStateMachine$1$2$1.invokeSuspend$lambda$1((FastLoginLoadingPage) obj);
                                                return invokeSuspend$lambda$1;
                                            }
                                        });
                                        break;
                                    case 3:
                                        loginReportService = this.this$0.loginReportService;
                                        loginReportService.report(LoginReporterV2.Show.APP_LOGIN_SUCCEED_0_SHOW, ((FastLoginLoadingPage) it.getSnapshot()).getOriginal().getLoginType(), TuplesKt.to("method", Fast.FastLogin.INSTANCE.getSucceedMethod()), TuplesKt.to("type", "fast"));
                                        $result3 = it.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$1$2$1$$ExternalSyntheticLambda2
                                            public final Object invoke(Object obj) {
                                                FastLoginPage invokeSuspend$lambda$2;
                                                invokeSuspend$lambda$2 = FastLoginStateMachine$1$2$1.invokeSuspend$lambda$2((FastLoginLoadingPage) obj);
                                                return invokeSuspend$lambda$2;
                                            }
                                        });
                                        break;
                                    default:
                                        throw new NoWhenBranchMatchedException();
                                }
                                return $result3;
                            } catch (Exception e2) {
                                State state = it;
                                e = e2;
                                $result = $result2;
                                it2 = state;
                                BLog.e(IFullscreenLoginPageKt.TAG_FULLSCREEN, "fast re-login has exception", e);
                                return it2.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$1$2$1$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj) {
                                        FastLoginPage invokeSuspend$lambda$3;
                                        invokeSuspend$lambda$3 = FastLoginStateMachine$1$2$1.invokeSuspend$lambda$3((FastLoginLoadingPage) obj);
                                        return invokeSuspend$lambda$3;
                                    }
                                });
                            }
                        }
                    }
                    throw new Exception("top activity is null");
                } catch (Exception e3) {
                    e = e3;
                    it2 = it;
                    BLog.e(IFullscreenLoginPageKt.TAG_FULLSCREEN, "fast re-login has exception", e);
                    return it2.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$1$2$1$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            FastLoginPage invokeSuspend$lambda$3;
                            invokeSuspend$lambda$3 = FastLoginStateMachine$1$2$1.invokeSuspend$lambda$3((FastLoginLoadingPage) obj);
                            return invokeSuspend$lambda$3;
                        }
                    });
                }
            case 1:
                it2 = (State) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    it = it2;
                    $result2 = $result;
                    result = (AccountResult) $result;
                    switch (WhenMappings.$EnumSwitchMapping$0[result.getStatus().ordinal()]) {
                    }
                    return $result3;
                } catch (Exception e4) {
                    e = e4;
                    BLog.e(IFullscreenLoginPageKt.TAG_FULLSCREEN, "fast re-login has exception", e);
                    return it2.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$1$2$1$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            FastLoginPage invokeSuspend$lambda$3;
                            invokeSuspend$lambda$3 = FastLoginStateMachine$1$2$1.invokeSuspend$lambda$3((FastLoginLoadingPage) obj);
                            return invokeSuspend$lambda$3;
                        }
                    });
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FastLoginRiskControl invokeSuspend$lambda$0(FastLoginLoadingPage $this$override) {
        return FastLoginRiskControl.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FastLoginFailed invokeSuspend$lambda$1(FastLoginLoadingPage $this$override) {
        return FastLoginFailed.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FastLoginPage invokeSuspend$lambda$2(FastLoginLoadingPage $this$override) {
        FastLoginPage copy;
        copy = r0.copy((r20 & 1) != 0 ? r0.account : null, (r20 & 2) != 0 ? r0.agreementChecked : false, (r20 & 4) != 0 ? r0.eulaDisplay : null, (r20 & 8) != 0 ? r0.loggedIn : true, (r20 & 16) != 0 ? r0.showLoading : false, (r20 & 32) != 0 ? r0.loginType : null, (r20 & 64) != 0 ? r0.redirect : null, (r20 & BR.cover) != 0 ? r0.captchaDisplay : null, (r20 & BR.hallEnterHotText) != 0 ? $this$override.getOriginal().toastInfo : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FastLoginPage invokeSuspend$lambda$3(FastLoginLoadingPage $this$override) {
        FastLoginPage copy;
        copy = r0.copy((r20 & 1) != 0 ? r0.account : null, (r20 & 2) != 0 ? r0.agreementChecked : false, (r20 & 4) != 0 ? r0.eulaDisplay : null, (r20 & 8) != 0 ? r0.loggedIn : false, (r20 & 16) != 0 ? r0.showLoading : false, (r20 & 32) != 0 ? r0.loginType : null, (r20 & 64) != 0 ? r0.redirect : null, (r20 & BR.cover) != 0 ? r0.captchaDisplay : null, (r20 & BR.hallEnterHotText) != 0 ? $this$override.getOriginal().toastInfo : null);
        return copy;
    }
}