package kntr.app.im.chat.stateMachine.builder;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatInfoLoad.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "action", "Lkntr/app/im/chat/core/model/ChatAction$DismissBehaviorAlert;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.ChatInfoLoadKt$bindChatInfoLoading$7", f = "ChatInfoLoad.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ChatInfoLoadKt$bindChatInfoLoading$7 extends SuspendLambda implements Function3<ChatAction.DismissBehaviorAlert, State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatInfoLoadKt$bindChatInfoLoading$7(Continuation<? super ChatInfoLoadKt$bindChatInfoLoading$7> continuation) {
        super(3, continuation);
    }

    public final Object invoke(ChatAction.DismissBehaviorAlert dismissBehaviorAlert, State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        ChatInfoLoadKt$bindChatInfoLoading$7 chatInfoLoadKt$bindChatInfoLoading$7 = new ChatInfoLoadKt$bindChatInfoLoading$7(continuation);
        chatInfoLoadKt$bindChatInfoLoading$7.L$0 = state;
        return chatInfoLoadKt$bindChatInfoLoading$7.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.ChatInfoLoadKt$bindChatInfoLoading$7$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        ChatPageData copy$default;
                        copy$default = ChatPageData.copy$default((ChatPageData) obj, null, 0L, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, 122879, null);
                        return copy$default;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}