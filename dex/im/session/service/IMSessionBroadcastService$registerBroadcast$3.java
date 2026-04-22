package im.session.service;

import com.bapis.bilibili.broadcast.message.im.KReqServerNotify;
import im.base.IMLog;
import im.session.log.LogTagKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionBroadcastService.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/bapis/bilibili/broadcast/message/im/KReqServerNotify;", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSessionBroadcastService$registerBroadcast$3", f = "IMSessionBroadcastService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMSessionBroadcastService$registerBroadcast$3 extends SuspendLambda implements Function3<FlowCollector<? super KReqServerNotify>, Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMSessionBroadcastService$registerBroadcast$3(Continuation<? super IMSessionBroadcastService$registerBroadcast$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(FlowCollector<? super KReqServerNotify> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        IMSessionBroadcastService$registerBroadcast$3 iMSessionBroadcastService$registerBroadcast$3 = new IMSessionBroadcastService$registerBroadcast$3(continuation);
        iMSessionBroadcastService$registerBroadcast$3.L$0 = th;
        return iMSessionBroadcastService$registerBroadcast$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Throwable it = (Throwable) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i(LogTagKt.getBroadcastLogTag(), "停止接收长链广播 " + it + ".");
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}