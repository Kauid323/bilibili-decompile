package kntr.app.im.chat.stateMachine.builder;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import com.bapis.bilibili.app.im.v1.KChatHintMessages;
import java.util.List;
import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.core.model.Messages;
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
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushInfoAction.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "state", "Lkntr/app/im/chat/core/model/ChatPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.PushInfoActionKt$bindPushInfoAction$2$1", f = "PushInfoAction.kt", i = {0, 0, 0}, l = {AdditionVote2.CHOICE_CNT_FIELD_NUMBER}, m = "invokeSuspend", n = {"state", "it", "$i$a$-let-PushInfoActionKt$bindPushInfoAction$2$1$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
public final class PushInfoActionKt$bindPushInfoAction$2$1 extends SuspendLambda implements Function2<ChatPageData, Continuation<? super Unit>, Object> {
    final /* synthetic */ PushInfoMsgService $service;
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushInfoActionKt$bindPushInfoAction$2$1(PushInfoMsgService pushInfoMsgService, Continuation<? super PushInfoActionKt$bindPushInfoAction$2$1> continuation) {
        super(2, continuation);
        this.$service = pushInfoMsgService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> pushInfoActionKt$bindPushInfoAction$2$1 = new PushInfoActionKt$bindPushInfoAction$2$1(this.$service, continuation);
        pushInfoActionKt$bindPushInfoAction$2$1.L$0 = obj;
        return pushInfoActionKt$bindPushInfoAction$2$1;
    }

    public final Object invoke(ChatPageData chatPageData, Continuation<? super Unit> continuation) {
        return create(chatPageData, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Messages messages;
        List it;
        KChatHintMessages hintMessages;
        ChatPageData state = (ChatPageData) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FetchMessagesData currentFetchResult = state.getCurrentFetchResult();
                if (currentFetchResult != null && (messages = currentFetchResult.getMessages()) != null && (it = messages.getEntityMessages()) != null) {
                    PushInfoMsgService pushInfoMsgService = this.$service;
                    ChatInfo chatInfo = state.getChatInfo();
                    KChatHintMessages.KPushInfoMessage pushInfoMessage = (chatInfo == null || (hintMessages = chatInfo.getHintMessages()) == null) ? null : hintMessages.getPushInfoMessage();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(state);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(it);
                    this.I$0 = 0;
                    this.label = 1;
                    if (pushInfoMsgService.checkMessageDisplayPushInfo(pushInfoMessage, it, this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                int i = this.I$0;
                List list = (List) this.L$1;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}