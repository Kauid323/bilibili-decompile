package kntr.app.im.chat.db.dao;

import java.util.List;
import kntr.app.im.chat.db.dao.MessageDao;
import kntr.app.im.chat.db.entity.MessageEntity;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: MessageDao_Impl.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.db.dao.MessageDao_Impl$upsertWithToken$4", f = "MessageDao_Impl.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MessageDao_Impl$upsertWithToken$4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ List<MessageEntity> $messages;
    int label;
    final /* synthetic */ MessageDao_Impl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageDao_Impl$upsertWithToken$4(MessageDao_Impl messageDao_Impl, List<MessageEntity> list, Continuation<? super MessageDao_Impl$upsertWithToken$4> continuation) {
        super(1, continuation);
        this.this$0 = messageDao_Impl;
        this.$messages = list;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new MessageDao_Impl$upsertWithToken$4(this.this$0, this.$messages, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object upsertWithToken$suspendImpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                upsertWithToken$suspendImpl = MessageDao.CC.upsertWithToken$suspendImpl(this.this$0, this.$messages, (Continuation) this);
                if (upsertWithToken$suspendImpl == coroutine_suspended) {
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