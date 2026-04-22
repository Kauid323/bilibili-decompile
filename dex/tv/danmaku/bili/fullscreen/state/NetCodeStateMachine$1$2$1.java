package tv.danmaku.bili.fullscreen.state;

import com.bilibili.lib.accounts.VerifyBundle;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.service.NetCodeLoginService;
import tv.danmaku.bili.fullscreen.state.LoginFailed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetCodeState.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/LoginRequesting;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.NetCodeStateMachine$1$2$1", f = "NetCodeState.kt", i = {0}, l = {BR.dynamicDurationSt}, m = "invokeSuspend", n = {AuthResultCbHelper.ARGS_STATE}, s = {"L$0"}, v = 1)
public final class NetCodeStateMachine$1$2$1 extends SuspendLambda implements Function2<State<LoginRequesting>, Continuation<? super ChangedState<? extends NetCodeState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NetCodeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetCodeStateMachine$1$2$1(NetCodeStateMachine netCodeStateMachine, Continuation<? super NetCodeStateMachine$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = netCodeStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> netCodeStateMachine$1$2$1 = new NetCodeStateMachine$1$2$1(this.this$0, continuation);
        netCodeStateMachine$1$2$1.L$0 = obj;
        return netCodeStateMachine$1$2$1;
    }

    public final Object invoke(State<LoginRequesting> state, Continuation<? super ChangedState<? extends NetCodeState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        final Object $result2;
        State state;
        NetCodeLoginService netCodeLoginService;
        Object $result3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        try {
            switch (i) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    State state2 = (State) this.L$0;
                    Object snapshot = state2.getSnapshot();
                    NetCodeStateMachine netCodeStateMachine = this.this$0;
                    Result.Companion companion = Result.Companion;
                    LoginRequesting $this$invokeSuspend_u24lambda_u240 = (LoginRequesting) snapshot;
                    netCodeLoginService = netCodeStateMachine.netCodeService;
                    String bizSeq = $this$invokeSuspend_u24lambda_u240.getBizSeq();
                    String codeSecret = $this$invokeSuspend_u24lambda_u240.getCodeSecret();
                    String extendCode = $this$invokeSuspend_u24lambda_u240.getExtendCode();
                    this.L$0 = state2;
                    this.label = 1;
                    Object login = netCodeLoginService.login(bizSeq, codeSecret, extendCode, this);
                    if (login == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result3 = $result;
                    $result = login;
                    i = state2;
                    break;
                case 1:
                    State state3 = (State) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $result3 = $result;
                    i = state3;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                $result2 = Result.constructor-impl((VerifyBundle) $result);
                state = i;
            } catch (Throwable th) {
                Object obj = $result3;
                th = th;
                $result = obj;
                Result.Companion companion2 = Result.Companion;
                $result2 = Result.constructor-impl(ResultKt.createFailure(th));
                state = i;
                VerifyBundle verifyBundle = (VerifyBundle) (!Result.isFailure-impl($result2) ? null : $result2);
                if (verifyBundle == null) {
                }
                final VerifyBundle verifyBundle2 = (VerifyBundle) (!Result.isFailure-impl($result2) ? null : $result2);
                if (Result.isSuccess-impl($result2)) {
                }
                if (Result.isSuccess-impl($result2)) {
                }
                Object result = state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.NetCodeStateMachine$1$2$1$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj2) {
                        LoginFailed.Error invokeSuspend$lambda$3;
                        invokeSuspend$lambda$3 = NetCodeStateMachine$1$2$1.invokeSuspend$lambda$3($result2, (LoginRequesting) obj2);
                        return invokeSuspend$lambda$3;
                    }
                });
                return result;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        VerifyBundle verifyBundle3 = (VerifyBundle) (!Result.isFailure-impl($result2) ? null : $result2);
        final VerifyBundle.SnsInfo snsInfo = verifyBundle3 == null ? verifyBundle3.snsInfo : null;
        final VerifyBundle verifyBundle22 = (VerifyBundle) (!Result.isFailure-impl($result2) ? null : $result2);
        if (Result.isSuccess-impl($result2)) {
            if (verifyBundle22 != null && verifyBundle22.isBind) {
                Object result2 = state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.NetCodeStateMachine$1$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        LoginVerifying invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = NetCodeStateMachine$1$2$1.invokeSuspend$lambda$1(verifyBundle22, (LoginRequesting) obj2);
                        return invokeSuspend$lambda$1;
                    }
                });
                return result2;
            }
        }
        if (Result.isSuccess-impl($result2)) {
            VerifyBundle verifyBundle4 = Result.isFailure-impl($result2) ? null : $result2;
            if (verifyBundle4 == null || verifyBundle4.isBind) {
                z = false;
            }
            if (z && snsInfo != null) {
                Object result3 = state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.NetCodeStateMachine$1$2$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2) {
                        LoginFailed.PhoneBindingRequested invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = NetCodeStateMachine$1$2$1.invokeSuspend$lambda$2(snsInfo, (LoginRequesting) obj2);
                        return invokeSuspend$lambda$2;
                    }
                });
                return result3;
            }
        }
        Object result4 = state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.NetCodeStateMachine$1$2$1$$ExternalSyntheticLambda2
            public final Object invoke(Object obj2) {
                LoginFailed.Error invokeSuspend$lambda$3;
                invokeSuspend$lambda$3 = NetCodeStateMachine$1$2$1.invokeSuspend$lambda$3($result2, (LoginRequesting) obj2);
                return invokeSuspend$lambda$3;
            }
        });
        return result4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoginVerifying invokeSuspend$lambda$1(VerifyBundle $verifyBundle, LoginRequesting $this$override) {
        return new LoginVerifying($verifyBundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoginFailed.PhoneBindingRequested invokeSuspend$lambda$2(VerifyBundle.SnsInfo $snsInfo, LoginRequesting $this$override) {
        String str = $snsInfo.snsPlatform;
        Intrinsics.checkNotNullExpressionValue(str, "snsPlatform");
        String str2 = $snsInfo.snsAppId;
        Intrinsics.checkNotNullExpressionValue(str2, "snsAppId");
        String str3 = $snsInfo.openId;
        Intrinsics.checkNotNullExpressionValue(str3, "openId");
        return new LoginFailed.PhoneBindingRequested(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoginFailed.Error invokeSuspend$lambda$3(Object $result, LoginRequesting $this$override) {
        return new LoginFailed.Error(Result.exceptionOrNull-impl($result), null, 2, null);
    }
}