package kntr.app.im.chat.stateMachine.builder.send;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.service.DraftDatabaseService;
import kntr.app.im.chat.db.model.InputBoxContent;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "action", "Lkntr/app/im/chat/core/model/ChatAction$InputBoxTextInserted;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$bindInputBoxAction$4", f = "InputBoxAction.kt", i = {0, 0, 0}, l = {53}, m = "invokeSuspend", n = {"action", "state", "newInputBoxContent"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class InputBoxActionKt$bindInputBoxAction$4 extends SuspendLambda implements Function3<ChatAction.InputBoxTextInserted, State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    final /* synthetic */ DraftDatabaseService $draftService;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputBoxActionKt$bindInputBoxAction$4(DraftDatabaseService draftDatabaseService, Continuation<? super InputBoxActionKt$bindInputBoxAction$4> continuation) {
        super(3, continuation);
        this.$draftService = draftDatabaseService;
    }

    public final Object invoke(ChatAction.InputBoxTextInserted inputBoxTextInserted, State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        InputBoxActionKt$bindInputBoxAction$4 inputBoxActionKt$bindInputBoxAction$4 = new InputBoxActionKt$bindInputBoxAction$4(this.$draftService, continuation);
        inputBoxActionKt$bindInputBoxAction$4.L$0 = inputBoxTextInserted;
        inputBoxActionKt$bindInputBoxAction$4.L$1 = state;
        return inputBoxActionKt$bindInputBoxAction$4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object handleInputBoxChanged;
        ChatAction.InputBoxTextInserted action = (ChatAction.InputBoxTextInserted) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                InputBoxContent newInputBoxContent = InputContentChangedKt.insertTextAtCursor(((ChatPageData) state.getSnapshot()).getInputContent().getInputBoxContent(), action.getText());
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = SpillingKt.nullOutSpilledVariable(state);
                this.L$2 = SpillingKt.nullOutSpilledVariable(newInputBoxContent);
                this.label = 1;
                handleInputBoxChanged = InputBoxActionKt.handleInputBoxChanged(state, this.$draftService, newInputBoxContent, true, (Continuation) this);
                return handleInputBoxChanged == coroutine_suspended ? coroutine_suspended : handleInputBoxChanged;
            case 1:
                InputBoxContent inputBoxContent = (InputBoxContent) this.L$2;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}