package kntr.app.im.chat.db.dao;

import kntr.app.im.chat.db.dao.PushInfoMessageDao;
import kntr.app.im.chat.db.entity.MessageEntity;
import kntr.app.im.chat.db.entity.SessionPushInfoMessage;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: PushInfoMessageDao_Impl.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.db.dao.PushInfoMessageDao_Impl$savePhaseOnePushInfoMessage$2", f = "PushInfoMessageDao_Impl.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PushInfoMessageDao_Impl$savePhaseOnePushInfoMessage$2 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {
    final /* synthetic */ MessageEntity $pushInfoMessage;
    final /* synthetic */ SessionPushInfoMessage $pushInfoRecord;
    int label;
    final /* synthetic */ PushInfoMessageDao_Impl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushInfoMessageDao_Impl$savePhaseOnePushInfoMessage$2(PushInfoMessageDao_Impl pushInfoMessageDao_Impl, SessionPushInfoMessage sessionPushInfoMessage, MessageEntity messageEntity, Continuation<? super PushInfoMessageDao_Impl$savePhaseOnePushInfoMessage$2> continuation) {
        super(1, continuation);
        this.this$0 = pushInfoMessageDao_Impl;
        this.$pushInfoRecord = sessionPushInfoMessage;
        this.$pushInfoMessage = messageEntity;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new PushInfoMessageDao_Impl$savePhaseOnePushInfoMessage$2(this.this$0, this.$pushInfoRecord, this.$pushInfoMessage, continuation);
    }

    public final Object invoke(Continuation<? super Long> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object savePhaseOnePushInfoMessage$suspendImpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                savePhaseOnePushInfoMessage$suspendImpl = PushInfoMessageDao.CC.savePhaseOnePushInfoMessage$suspendImpl(this.this$0, this.$pushInfoRecord, this.$pushInfoMessage, (Continuation) this);
                if (savePhaseOnePushInfoMessage$suspendImpl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return savePhaseOnePushInfoMessage$suspendImpl;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}