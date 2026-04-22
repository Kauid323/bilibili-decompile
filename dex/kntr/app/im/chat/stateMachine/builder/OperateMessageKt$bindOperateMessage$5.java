package kntr.app.im.chat.stateMachine.builder;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.service.OperateMessageService;
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
/* compiled from: OperateMessage.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "action", "Lkntr/app/im/chat/core/model/ChatAction$RecallMessage;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.OperateMessageKt$bindOperateMessage$5", f = "OperateMessage.kt", i = {0, 0}, l = {79}, m = "invokeSuspend", n = {"action", "state"}, s = {"L$0", "L$1"}, v = 1)
public final class OperateMessageKt$bindOperateMessage$5 extends SuspendLambda implements Function3<ChatAction.RecallMessage, State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    final /* synthetic */ OperateMessageService $operateMessageService;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperateMessageKt$bindOperateMessage$5(OperateMessageService operateMessageService, Continuation<? super OperateMessageKt$bindOperateMessage$5> continuation) {
        super(3, continuation);
        this.$operateMessageService = operateMessageService;
    }

    public final Object invoke(ChatAction.RecallMessage recallMessage, State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        OperateMessageKt$bindOperateMessage$5 operateMessageKt$bindOperateMessage$5 = new OperateMessageKt$bindOperateMessage$5(this.$operateMessageService, continuation);
        operateMessageKt$bindOperateMessage$5.L$0 = recallMessage;
        operateMessageKt$bindOperateMessage$5.L$1 = state;
        return operateMessageKt$bindOperateMessage$5.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object recallMessage;
        ChatAction.RecallMessage action = (ChatAction.RecallMessage) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = SpillingKt.nullOutSpilledVariable(state);
                this.label = 1;
                recallMessage = OperateMessageKt.recallMessage(state, this.$operateMessageService, action.getMsgId(), (Continuation) this);
                if (recallMessage == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return recallMessage;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}