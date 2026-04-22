package kntr.app.im.chat.core.service;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: MessageSendService.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/flow/FlowCollector;", "Lkntr/app/im/chat/core/service/MessageSendProgress;", "value"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.core.service.MessageSendServiceKt$progressFlow$2", f = "MessageSendService.kt", i = {0, 0}, l = {121}, m = "invokeSuspend", n = {"$this$transformWhile", "value"}, s = {"L$0", "L$1"}, v = 1)
final class MessageSendServiceKt$progressFlow$2 extends SuspendLambda implements Function3<FlowCollector<? super MessageSendProgress>, MessageSendProgress, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageSendServiceKt$progressFlow$2(Continuation<? super MessageSendServiceKt$progressFlow$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(FlowCollector<? super MessageSendProgress> flowCollector, MessageSendProgress messageSendProgress, Continuation<? super Boolean> continuation) {
        MessageSendServiceKt$progressFlow$2 messageSendServiceKt$progressFlow$2 = new MessageSendServiceKt$progressFlow$2(continuation);
        messageSendServiceKt$progressFlow$2.L$0 = flowCollector;
        messageSendServiceKt$progressFlow$2.L$1 = messageSendProgress;
        return messageSendServiceKt$progressFlow$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        FlowCollector $this$transformWhile = (FlowCollector) this.L$0;
        MessageSendProgress value = (MessageSendProgress) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$transformWhile);
                this.L$1 = value;
                this.label = 1;
                if ($this$transformWhile.emit(value, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(!value.getEndState());
    }
}