package tv.danmaku.bili.fullscreen.state;

import androidx.fragment.app.FragmentActivity;
import bili.resource.account.R;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.accountsui.ThirdLoginResult;
import com.bilibili.lib.accountsui.ThirdLoginStatus;
import com.bilibili.lib.accountsui.google.GoogleLoginManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.service.LoginReportParams;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.ToastInfo;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OverseaLoginPage.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/IOverseaLoginState;", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$GoogleLogin;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/OverseaLoginState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.OverseaLoginStateMachine$1$1$3", f = "OverseaLoginPage.kt", i = {0}, l = {BR.chatRoomConfig}, m = "invokeSuspend", n = {AuthResultCbHelper.ARGS_STATE}, s = {"L$0"}, v = 1)
public final class OverseaLoginStateMachine$1$1$3 extends SuspendLambda implements Function3<IFullscreenLoginAction.GoogleLogin, State<OverseaLoginState>, Continuation<? super ChangedState<? extends IOverseaLoginState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OverseaLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverseaLoginStateMachine$1$1$3(OverseaLoginStateMachine overseaLoginStateMachine, Continuation<? super OverseaLoginStateMachine$1$1$3> continuation) {
        super(3, continuation);
        this.this$0 = overseaLoginStateMachine;
    }

    public final Object invoke(IFullscreenLoginAction.GoogleLogin googleLogin, State<OverseaLoginState> state, Continuation<? super ChangedState<? extends IOverseaLoginState>> continuation) {
        OverseaLoginStateMachine$1$1$3 overseaLoginStateMachine$1$1$3 = new OverseaLoginStateMachine$1$1$3(this.this$0, continuation);
        overseaLoginStateMachine$1$1$3.L$0 = state;
        return overseaLoginStateMachine$1$1$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final State state;
        LoginReportService loginReportService;
        Object $result2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                state = (State) this.L$0;
                FragmentActivity fragmentActivity = BiliContext.topActivity();
                if (fragmentActivity != null) {
                    r4 = fragmentActivity instanceof FragmentActivity ? fragmentActivity : null;
                }
                FragmentActivity activity = r4;
                if (activity != null) {
                    loginReportService = this.this$0.loginReportService;
                    LoginReportParams report = loginReportService.getReportParams(((OverseaLoginState) state.getSnapshot()).getLoginType());
                    GoogleLoginManager googleLoginManager = new GoogleLoginManager(report.getLoginSessionId(), report.getFromSpmId(), report.getTouristId(), report.getExtend());
                    final OverseaLoginStateMachine overseaLoginStateMachine = this.this$0;
                    this.L$0 = state;
                    this.label = 1;
                    Object login = googleLoginManager.login(activity, new Function1() { // from class: tv.danmaku.bili.fullscreen.state.OverseaLoginStateMachine$1$1$3$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = OverseaLoginStateMachine$1$1$3.invokeSuspend$lambda$1(OverseaLoginStateMachine.this, state, ((Boolean) obj).booleanValue());
                            return invokeSuspend$lambda$1;
                        }
                    }, new Function1() { // from class: tv.danmaku.bili.fullscreen.state.OverseaLoginStateMachine$1$1$3$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            Unit invokeSuspend$lambda$2;
                            invokeSuspend$lambda$2 = OverseaLoginStateMachine$1$1$3.invokeSuspend$lambda$2(state, ((Boolean) obj).booleanValue());
                            return invokeSuspend$lambda$2;
                        }
                    }, (Continuation) this);
                    if (login == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result = login;
                    break;
                } else {
                    BLog.e("OverseaLoginStateMachine", "Google Login, Activity is null");
                    return state.mutate(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.OverseaLoginStateMachine$1$1$3$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            OverseaLoginState invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = OverseaLoginStateMachine$1$1$3.invokeSuspend$lambda$0((OverseaLoginState) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                }
            case 1:
                ResultKt.throwOnFailure($result);
                state = (State) this.L$0;
                $result2 = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final ThirdLoginResult result = (ThirdLoginResult) $result;
        if (result.getStatus() == ThirdLoginStatus.SUCCESS) {
            return state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.OverseaLoginStateMachine$1$1$3$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    OverseaLoginState copy$default;
                    copy$default = OverseaLoginState.copy$default((OverseaLoginState) obj, null, null, null, null, null, true, false, null, BR.followDescTextColor, null);
                    return copy$default;
                }
            });
        }
        BLog.e("OverseaLoginStateMachine", "Google Login Failed, msg: " + result.getMsg());
        return state.mutate(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.OverseaLoginStateMachine$1$1$3$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                OverseaLoginState invokeSuspend$lambda$4;
                invokeSuspend$lambda$4 = OverseaLoginStateMachine$1$1$3.invokeSuspend$lambda$4(result, (OverseaLoginState) obj);
                return invokeSuspend$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OverseaLoginState invokeSuspend$lambda$0(OverseaLoginState $this$mutate) {
        OverseaLoginState copy;
        String string = FoundationAlias.getFapp().getString(R.string.account_global_string_136);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.smsLoginState : null, (r18 & 2) != 0 ? $this$mutate.info : null, (r18 & 4) != 0 ? $this$mutate.eulaDisplay : null, (r18 & 8) != 0 ? $this$mutate.captchaDisplay : null, (r18 & 16) != 0 ? $this$mutate.redirect : null, (r18 & 32) != 0 ? $this$mutate.loggedIn : false, (r18 & 64) != 0 ? $this$mutate.showLoading : false, (r18 & BR.cover) != 0 ? $this$mutate.toastInfo : new ToastInfo(string, 0L, 2, null));
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(OverseaLoginStateMachine this$0, State $state, boolean isNew) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new OverseaLoginStateMachine$1$1$3$result$1$1(isNew, this$0, $state, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2(State $state, final boolean show) {
        BLog.i("OverseaLoginStateMachine", "Google show loading, show: " + show);
        $state.mutate(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.OverseaLoginStateMachine$1$1$3$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                OverseaLoginState invokeSuspend$lambda$2$0;
                invokeSuspend$lambda$2$0 = OverseaLoginStateMachine$1$1$3.invokeSuspend$lambda$2$0(show, (OverseaLoginState) obj);
                return invokeSuspend$lambda$2$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OverseaLoginState invokeSuspend$lambda$2$0(boolean $show, OverseaLoginState $this$mutate) {
        OverseaLoginState copy;
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.smsLoginState : null, (r18 & 2) != 0 ? $this$mutate.info : null, (r18 & 4) != 0 ? $this$mutate.eulaDisplay : null, (r18 & 8) != 0 ? $this$mutate.captchaDisplay : null, (r18 & 16) != 0 ? $this$mutate.redirect : null, (r18 & 32) != 0 ? $this$mutate.loggedIn : false, (r18 & 64) != 0 ? $this$mutate.showLoading : $show, (r18 & BR.cover) != 0 ? $this$mutate.toastInfo : null);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OverseaLoginState invokeSuspend$lambda$4(ThirdLoginResult $result, OverseaLoginState $this$mutate) {
        OverseaLoginState copy;
        String msg = $result.getMsg();
        if (msg == null) {
            msg = FoundationAlias.getFapp().getString(R.string.account_global_string_136);
            Intrinsics.checkNotNullExpressionValue(msg, "getString(...)");
        }
        copy = $this$mutate.copy((r18 & 1) != 0 ? $this$mutate.smsLoginState : null, (r18 & 2) != 0 ? $this$mutate.info : null, (r18 & 4) != 0 ? $this$mutate.eulaDisplay : null, (r18 & 8) != 0 ? $this$mutate.captchaDisplay : null, (r18 & 16) != 0 ? $this$mutate.redirect : null, (r18 & 32) != 0 ? $this$mutate.loggedIn : false, (r18 & 64) != 0 ? $this$mutate.showLoading : false, (r18 & BR.cover) != 0 ? $this$mutate.toastInfo : new ToastInfo(msg, 0L, 2, null));
        return copy;
    }
}