package kntr.app.im.chat.stateMachine.builder;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStateMachine;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.service.ConversationService;
import kntr.app.im.chat.di.module.personal.PersonalChat;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: ShortcutAction.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a_\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\nH\u0000R\u00020\u0002R\u00020\u0004R\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0006\u0010\u0003\u001a\u00020\u0002j\u0006\u0010\u0005\u001a\u00020\u0004j\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"bindShortcutAction", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/di/module/personal/PersonalChat;", "sessionId", "Lkntr/app/im/chat/core/service/ConversationService;", "conversationService", "Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;", "Lkntr/app/im/chat/core/model/ChatPageData;", "Lkntr/app/im/chat/core/model/ChatAction;", "stateMachine", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "(Lkntr/app/im/chat/di/module/personal/PersonalChat;Lkntr/app/im/chat/core/service/ConversationService;Lcom/freeletics/flowredux/dsl/FlowReduxStateMachine;Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;)V", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ShortcutActionKt {
    public static final void bindShortcutAction(PersonalChat sessionId, ConversationService conversationService, FlowReduxStateMachine<ChatPageData, ChatAction> flowReduxStateMachine, InStateBuilderBlock<ChatPageData, ChatPageData, ChatAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(conversationService, "conversationService");
        Intrinsics.checkNotNullParameter(flowReduxStateMachine, "stateMachine");
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new ShortcutActionKt$bindShortcutAction$1(conversationService, flowReduxStateMachine, sessionId, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(ChatAction.ShortcutClick.class), executionPolicy$iv, handler$iv);
    }
}