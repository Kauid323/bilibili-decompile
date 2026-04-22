package kntr.app.im.chat.stateMachine.builder;

import com.bapis.bilibili.app.im.v1.KChatHintMessages;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.IdentityBuilderBlock;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import java.util.List;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.core.model.Messages;
import kntr.app.im.chat.service.personal.PushInfoMsgService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: PushInfoAction.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aG\u0010\u0000\u001a\u00020\u0001R\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002R\u00020\u0006j\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"bindPushInfoAction", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/im/chat/core/model/ChatPageData;", "Lkntr/app/im/chat/core/model/ChatAction;", "builder", "Lkntr/app/im/chat/service/personal/PushInfoMsgService;", "service", "(Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;Lkntr/app/im/chat/service/personal/PushInfoMsgService;)V", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PushInfoActionKt {
    public static final void bindPushInfoAction(InStateBuilderBlock<ChatPageData, ChatPageData, ChatAction> inStateBuilderBlock, final PushInfoMsgService service) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "builder");
        Intrinsics.checkNotNullParameter(service, "service");
        inStateBuilderBlock.untilIdentityChanges(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.PushInfoActionKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Object bindPushInfoAction$lambda$0;
                bindPushInfoAction$lambda$0 = PushInfoActionKt.bindPushInfoAction$lambda$0((ChatPageData) obj);
                return bindPushInfoAction$lambda$0;
            }
        }, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.PushInfoActionKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit bindPushInfoAction$lambda$1;
                bindPushInfoAction$lambda$1 = PushInfoActionKt.bindPushInfoAction$lambda$1(PushInfoMsgService.this, (IdentityBuilderBlock) obj);
                return bindPushInfoAction$lambda$1;
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new PushInfoActionKt$bindPushInfoAction$3(service, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(ChatAction.ShowPhaseTwoPushMessage.class), executionPolicy$iv, handler$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object bindPushInfoAction$lambda$0(ChatPageData it) {
        Messages messages;
        KChatHintMessages hintMessages;
        Intrinsics.checkNotNullParameter(it, "it");
        ChatInfo chatInfo = it.getChatInfo();
        List<EntityMessage> list = null;
        KChatHintMessages.KPushInfoMessage pushInfoMessage = (chatInfo == null || (hintMessages = chatInfo.getHintMessages()) == null) ? null : hintMessages.getPushInfoMessage();
        FetchMessagesData currentFetchResult = it.getCurrentFetchResult();
        if (currentFetchResult != null && (messages = currentFetchResult.getMessages()) != null) {
            list = messages.getEntityMessages();
        }
        return TuplesKt.to(pushInfoMessage, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindPushInfoAction$lambda$1(PushInfoMsgService $service, IdentityBuilderBlock $this$untilIdentityChanges) {
        Intrinsics.checkNotNullParameter($this$untilIdentityChanges, "$this$untilIdentityChanges");
        $this$untilIdentityChanges.onEnterEffect(new PushInfoActionKt$bindPushInfoAction$2$1($service, null));
        return Unit.INSTANCE;
    }
}