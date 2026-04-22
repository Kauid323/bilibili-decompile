package kntr.app.im.chat.stateMachine.builder;

import com.bapis.bilibili.app.im.v1.KChatHintMessages;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.core.model.MessageSequence;
import kntr.app.im.chat.service.personal.PushInfoMsgService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushInfoAction.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "action", "Lkntr/app/im/chat/core/model/ChatAction$ShowPhaseTwoPushMessage;", "state", "Lkntr/app/im/chat/core/model/ChatPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.PushInfoActionKt$bindPushInfoAction$3", f = "PushInfoAction.kt", i = {0, 0}, l = {28}, m = "invokeSuspend", n = {"action", "state"}, s = {"L$0", "L$1"}, v = 1)
public final class PushInfoActionKt$bindPushInfoAction$3 extends SuspendLambda implements Function3<ChatAction.ShowPhaseTwoPushMessage, ChatPageData, Continuation<? super Unit>, Object> {
    final /* synthetic */ PushInfoMsgService $service;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushInfoActionKt$bindPushInfoAction$3(PushInfoMsgService pushInfoMsgService, Continuation<? super PushInfoActionKt$bindPushInfoAction$3> continuation) {
        super(3, continuation);
        this.$service = pushInfoMsgService;
    }

    public final Object invoke(ChatAction.ShowPhaseTwoPushMessage showPhaseTwoPushMessage, ChatPageData chatPageData, Continuation<? super Unit> continuation) {
        PushInfoActionKt$bindPushInfoAction$3 pushInfoActionKt$bindPushInfoAction$3 = new PushInfoActionKt$bindPushInfoAction$3(this.$service, continuation);
        pushInfoActionKt$bindPushInfoAction$3.L$0 = showPhaseTwoPushMessage;
        pushInfoActionKt$bindPushInfoAction$3.L$1 = chatPageData;
        return pushInfoActionKt$bindPushInfoAction$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MessageSequence messageSequence;
        MessageId msgId;
        KChatHintMessages hintMessages;
        ChatAction.ShowPhaseTwoPushMessage action = (ChatAction.ShowPhaseTwoPushMessage) this.L$0;
        ChatPageData state = (ChatPageData) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PushInfoMsgService pushInfoMsgService = this.$service;
                ChatInfo chatInfo = state.getChatInfo();
                KChatHintMessages.KPushInfoMessage pushInfoMessage = (chatInfo == null || (hintMessages = chatInfo.getHintMessages()) == null) ? null : hintMessages.getPushInfoMessage();
                EntityMessage lastMessageNotSending = state.getLastMessageNotSending();
                if (lastMessageNotSending == null || (msgId = lastMessageNotSending.getMsgId()) == null || (messageSequence = msgId.getSequence()) == null) {
                    messageSequence = action.getMessageSequence();
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = SpillingKt.nullOutSpilledVariable(state);
                this.label = 1;
                if (pushInfoMsgService.appendPhaseTwoInfoForMessage(pushInfoMessage, messageSequence, action.getRelatedTimeStamp(), (Continuation) this) == coroutine_suspended) {
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