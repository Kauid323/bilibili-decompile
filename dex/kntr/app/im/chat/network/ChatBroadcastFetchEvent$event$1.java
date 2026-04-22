package kntr.app.im.chat.network;

import com.bapis.bilibili.broadcast.message.im.KReqServerNotify;
import im.base.IMLog;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ChatFetchEventServiceImpl.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "it", "Lcom/bapis/bilibili/broadcast/message/im/KReqServerNotify;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.network.ChatBroadcastFetchEvent$event$1", f = "ChatFetchEventServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ChatBroadcastFetchEvent$event$1 extends SuspendLambda implements Function2<KReqServerNotify, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatBroadcastFetchEvent$event$1(Continuation<? super ChatBroadcastFetchEvent$event$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> chatBroadcastFetchEvent$event$1 = new ChatBroadcastFetchEvent$event$1(continuation);
        chatBroadcastFetchEvent$event$1.L$0 = obj;
        return chatBroadcastFetchEvent$event$1;
    }

    public final Object invoke(KReqServerNotify kReqServerNotify, Continuation<? super Unit> continuation) {
        return create(kReqServerNotify, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        KReqServerNotify it = (KReqServerNotify) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i("Chat-Broadcast", "received message: " + it);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}