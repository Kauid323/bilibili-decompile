package kntr.app.im.chat.stateMachine.builder;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ConditionBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import im.base.IMBroadcastManager;
import im.base.SessionIdConverters;
import im.base.model.SessionId;
import kntr.app.im.chat.core.RequestStatus;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.service.FusionChatInfoService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: ChatInfoLoad.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aQ\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nR\u00020\u0002R\u00020\u0004R\u00020\u0006R\u00020\bj\u0006\u0010\u0003\u001a\u00020\u0002j\u0006\u0010\u0005\u001a\u00020\u0004j\u0006\u0010\u0007\u001a\u00020\u0006j\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"bindChatInfoLoading", RoomRecommendViewModel.EMPTY_CURSOR, "Lim/base/model/SessionId;", "sessionId", "Lkntr/app/im/chat/core/service/FusionChatInfoService;", "chatInfoService", "Lim/base/IMBroadcastManager;", "broadcastManager", "Lim/base/SessionIdConverters;", "sessionIdConverters", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/app/im/chat/core/model/ChatPageData;", "Lkntr/app/im/chat/core/model/ChatAction;", "(Lim/base/model/SessionId;Lkntr/app/im/chat/core/service/FusionChatInfoService;Lim/base/IMBroadcastManager;Lim/base/SessionIdConverters;Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;)V", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatInfoLoadKt {
    public static final void bindChatInfoLoading(SessionId sessionId, final FusionChatInfoService chatInfoService, final IMBroadcastManager broadcastManager, SessionIdConverters sessionIdConverters, InStateBuilderBlock<ChatPageData, ChatPageData, ChatAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(chatInfoService, "chatInfoService");
        Intrinsics.checkNotNullParameter(broadcastManager, "broadcastManager");
        Intrinsics.checkNotNullParameter(sessionIdConverters, "sessionIdConverters");
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        BaseBuilderBlock.collectWhileInStateEffect$default((BaseBuilderBlock) inStateBuilderBlock, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ChatInfoLoadKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Flow bindChatInfoLoading$lambda$0;
                bindChatInfoLoading$lambda$0 = ChatInfoLoadKt.bindChatInfoLoading$lambda$0(broadcastManager, (ChatPageData) obj);
                return bindChatInfoLoading$lambda$0;
            }
        }, (ExecutionPolicy) null, new ChatInfoLoadKt$bindChatInfoLoading$2(sessionIdConverters, sessionId, chatInfoService, null), 2, (Object) null);
        BaseBuilderBlock.collectWhileInState$default((BaseBuilderBlock) inStateBuilderBlock, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ChatInfoLoadKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Flow bindChatInfoLoading$lambda$1;
                bindChatInfoLoading$lambda$1 = ChatInfoLoadKt.bindChatInfoLoading$lambda$1(FusionChatInfoService.this, (ChatPageData) obj);
                return bindChatInfoLoading$lambda$1;
            }
        }, (ExecutionPolicy) null, new ChatInfoLoadKt$bindChatInfoLoading$4(null), 2, (Object) null);
        inStateBuilderBlock.condition(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ChatInfoLoadKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean bindChatInfoLoading$lambda$2;
                bindChatInfoLoading$lambda$2 = ChatInfoLoadKt.bindChatInfoLoading$lambda$2((ChatPageData) obj);
                return Boolean.valueOf(bindChatInfoLoading$lambda$2);
            }
        }, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ChatInfoLoadKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit bindChatInfoLoading$lambda$3;
                bindChatInfoLoading$lambda$3 = ChatInfoLoadKt.bindChatInfoLoading$lambda$3(FusionChatInfoService.this, (ConditionBuilderBlock) obj);
                return bindChatInfoLoading$lambda$3;
            }
        });
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = new ChatInfoLoadKt$bindChatInfoLoading$7(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(ChatAction.DismissBehaviorAlert.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = new ChatInfoLoadKt$bindChatInfoLoading$8(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.onActionEffect(Reflection.getOrCreateKotlinClass(ChatAction.DismissBehaviorAlert.class), executionPolicy$iv2, handler$iv2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow bindChatInfoLoading$lambda$0(IMBroadcastManager $broadcastManager, ChatPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return FlowKt.flatMapConcat($broadcastManager.commandList(), new ChatInfoLoadKt$bindChatInfoLoading$lambda$0$$inlined$ofCommandList$1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow bindChatInfoLoading$lambda$1(FusionChatInfoService $chatInfoService, ChatPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $chatInfoService.getDataFlow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindChatInfoLoading$lambda$2(ChatPageData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getPageStatus().getChatInfo() instanceof RequestStatus.Loading;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindChatInfoLoading$lambda$3(FusionChatInfoService $chatInfoService, ConditionBuilderBlock $this$condition) {
        Intrinsics.checkNotNullParameter($this$condition, "$this$condition");
        $this$condition.onEnter(new ChatInfoLoadKt$bindChatInfoLoading$6$1($chatInfoService, null));
        return Unit.INSTANCE;
    }
}