package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.stat.ThirdParty;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetCodeState.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AuthResultCbHelper.ARGS_STATE, "Ltv/danmaku/bili/fullscreen/state/LoginSuccess;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.NetCodeStateMachine$1$6$1", f = "NetCodeState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class NetCodeStateMachine$1$6$1 extends SuspendLambda implements Function2<LoginSuccess, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NetCodeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetCodeStateMachine$1$6$1(NetCodeStateMachine netCodeStateMachine, Continuation<? super NetCodeStateMachine$1$6$1> continuation) {
        super(2, continuation);
        this.this$0 = netCodeStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> netCodeStateMachine$1$6$1 = new NetCodeStateMachine$1$6$1(this.this$0, continuation);
        netCodeStateMachine$1$6$1.L$0 = obj;
        return netCodeStateMachine$1$6$1;
    }

    public final Object invoke(LoginSuccess loginSuccess, Continuation<? super Unit> continuation) {
        return create(loginSuccess, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LoginReportService loginReportService;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                LoginSuccess state = (LoginSuccess) this.L$0;
                loginReportService = this.this$0.loginReportService;
                loginReportService.report(LoginReporterV2.Show.APP_LOGIN_SUCCEED_0_SHOW, state.getLoginType(), TuplesKt.to("method", ThirdParty.NetCodeLogin.INSTANCE.getSucceedMethod()), TuplesKt.to("type", "sms"));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}