package kntr.app.im.chat.stateMachine.builder.send;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.service.DraftDatabaseService;
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
/* compiled from: InputBoxAction.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "action", "Lkntr/app/im/chat/core/model/ChatAction$InputBoxTextChanged;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$bindInputBoxAction$3", f = "InputBoxAction.kt", i = {0, 0}, l = {46}, m = "invokeSuspend", n = {"action", "state"}, s = {"L$0", "L$1"}, v = 1)
public final class InputBoxActionKt$bindInputBoxAction$3 extends SuspendLambda implements Function3<ChatAction.InputBoxTextChanged, State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    final /* synthetic */ DraftDatabaseService $draftService;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputBoxActionKt$bindInputBoxAction$3(DraftDatabaseService draftDatabaseService, Continuation<? super InputBoxActionKt$bindInputBoxAction$3> continuation) {
        super(3, continuation);
        this.$draftService = draftDatabaseService;
    }

    public final Object invoke(ChatAction.InputBoxTextChanged inputBoxTextChanged, State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        InputBoxActionKt$bindInputBoxAction$3 inputBoxActionKt$bindInputBoxAction$3 = new InputBoxActionKt$bindInputBoxAction$3(this.$draftService, continuation);
        inputBoxActionKt$bindInputBoxAction$3.L$0 = inputBoxTextChanged;
        inputBoxActionKt$bindInputBoxAction$3.L$1 = state;
        return inputBoxActionKt$bindInputBoxAction$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object handleInputBoxChanged;
        ChatAction.InputBoxTextChanged action = (ChatAction.InputBoxTextChanged) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = SpillingKt.nullOutSpilledVariable(state);
                this.label = 1;
                handleInputBoxChanged = InputBoxActionKt.handleInputBoxChanged(state, this.$draftService, action.getNewValue(), false, (Continuation) this);
                if (handleInputBoxChanged == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return handleInputBoxChanged;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}