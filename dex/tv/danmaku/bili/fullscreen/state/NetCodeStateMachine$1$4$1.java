package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.state.LoginFailed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetCodeState.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AuthResultCbHelper.ARGS_STATE, "Ltv/danmaku/bili/fullscreen/state/LoginFailed$Error;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.NetCodeStateMachine$1$4$1", f = "NetCodeState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class NetCodeStateMachine$1$4$1 extends SuspendLambda implements Function2<LoginFailed.Error, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NetCodeStateMachine$1$4$1(Continuation<? super NetCodeStateMachine$1$4$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> netCodeStateMachine$1$4$1 = new NetCodeStateMachine$1$4$1(continuation);
        netCodeStateMachine$1$4$1.L$0 = obj;
        return netCodeStateMachine$1$4$1;
    }

    public final Object invoke(LoginFailed.Error error, Continuation<? super Unit> continuation) {
        return create(error, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                LoginFailed.Error state = (LoginFailed.Error) this.L$0;
                BLog.w("netcode_login", state.getThrowable());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}