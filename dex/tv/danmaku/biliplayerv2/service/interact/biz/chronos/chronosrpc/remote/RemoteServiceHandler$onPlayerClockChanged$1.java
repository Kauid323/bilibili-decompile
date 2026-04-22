package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.PlaybackStatusChange;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteServiceHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.remote.RemoteServiceHandler$onPlayerClockChanged$1", f = "RemoteServiceHandler.kt", i = {}, l = {950}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RemoteServiceHandler$onPlayerClockChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PlaybackStatusChange.Request $req;
    int label;
    final /* synthetic */ RemoteServiceHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteServiceHandler$onPlayerClockChanged$1(RemoteServiceHandler remoteServiceHandler, PlaybackStatusChange.Request request, Continuation<? super RemoteServiceHandler$onPlayerClockChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteServiceHandler;
        this.$req = request;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RemoteServiceHandler$onPlayerClockChanged$1(this.this$0, this.$req, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                mutableSharedFlow = this.this$0.playbackStatusRequestFlow;
                this.label = 1;
                if (mutableSharedFlow.emit(this.$req, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}