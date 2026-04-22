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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "<unused var>", "Lkntr/app/im/chat/core/model/ChatAction$InputBoxBackspacePressed;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$bindInputBoxAction$5", f = "InputBoxAction.kt", i = {0, 0}, l = {62}, m = "invokeSuspend", n = {"state", "newInputBoxContent"}, s = {"L$0", "L$1"}, v = 1)
public final class InputBoxActionKt$bindInputBoxAction$5 extends SuspendLambda implements Function3<ChatAction.InputBoxBackspacePressed, State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    final /* synthetic */ DraftDatabaseService $draftService;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputBoxActionKt$bindInputBoxAction$5(DraftDatabaseService draftDatabaseService, Continuation<? super InputBoxActionKt$bindInputBoxAction$5> continuation) {
        super(3, continuation);
        this.$draftService = draftDatabaseService;
    }

    public final Object invoke(ChatAction.InputBoxBackspacePressed inputBoxBackspacePressed, State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        InputBoxActionKt$bindInputBoxAction$5 inputBoxActionKt$bindInputBoxAction$5 = new InputBoxActionKt$bindInputBoxAction$5(this.$draftService, continuation);
        inputBoxActionKt$bindInputBoxAction$5.L$0 = state;
        return inputBoxActionKt$bindInputBoxAction$5.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object handleInputBoxChanged;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                InputBoxContent newInputBoxContent = InputContentChangedKt.backSpaceAtCursor(((ChatPageData) state.getSnapshot()).getInputContent().getInputBoxContent());
                this.L$0 = SpillingKt.nullOutSpilledVariable(state);
                this.L$1 = SpillingKt.nullOutSpilledVariable(newInputBoxContent);
                this.label = 1;
                handleInputBoxChanged = InputBoxActionKt.handleInputBoxChanged(state, this.$draftService, newInputBoxContent, true, (Continuation) this);
                return handleInputBoxChanged == coroutine_suspended ? coroutine_suspended : handleInputBoxChanged;
            case 1:
                InputBoxContent inputBoxContent = (InputBoxContent) this.L$1;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}