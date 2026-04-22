package kntr.app.im.chat.stateMachine.builder.send;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.InputContent;
import kntr.app.im.chat.core.service.DraftDatabaseService;
import kntr.app.im.chat.db.model.InputBoxContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputBoxAction.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$bindInputBoxAction$2", f = "InputBoxAction.kt", i = {0}, l = {37}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class InputBoxActionKt$bindInputBoxAction$2 extends SuspendLambda implements Function2<State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    final /* synthetic */ DraftDatabaseService $draftService;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputBoxActionKt$bindInputBoxAction$2(DraftDatabaseService draftDatabaseService, Continuation<? super InputBoxActionKt$bindInputBoxAction$2> continuation) {
        super(2, continuation);
        this.$draftService = draftDatabaseService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> inputBoxActionKt$bindInputBoxAction$2 = new InputBoxActionKt$bindInputBoxAction$2(this.$draftService, continuation);
        inputBoxActionKt$bindInputBoxAction$2.L$0 = obj;
        return inputBoxActionKt$bindInputBoxAction$2;
    }

    public final Object invoke(State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object query;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = state;
                this.label = 1;
                query = this.$draftService.query((Continuation) this);
                if (query == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                query = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final InputBoxContent draftResult = (InputBoxContent) query;
        if (draftResult != null) {
            return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$bindInputBoxAction$2$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    ChatPageData invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = InputBoxActionKt$bindInputBoxAction$2.invokeSuspend$lambda$0(InputBoxContent.this, (ChatPageData) obj);
                    return invokeSuspend$lambda$0;
                }
            });
        }
        return state.noChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$0(InputBoxContent $draftResult, ChatPageData $this$mutate) {
        ChatPageData copy;
        copy = $this$mutate.copy((r36 & 1) != 0 ? $this$mutate.sessionId : null, (r36 & 2) != 0 ? $this$mutate.hostMid : 0L, (r36 & 4) != 0 ? $this$mutate.pageStatus : null, (r36 & 8) != 0 ? $this$mutate.chatInfo : null, (r36 & 16) != 0 ? $this$mutate.messageGroups : null, (r36 & 32) != 0 ? $this$mutate.toast : null, (r36 & 64) != 0 ? $this$mutate.previewImageData : null, (r36 & 128) != 0 ? $this$mutate.isShowStickerEditPage : false, (r36 & 256) != 0 ? $this$mutate.route : null, (r36 & 512) != 0 ? $this$mutate.upgradeAnswerDialogStatus : null, (r36 & 1024) != 0 ? $this$mutate.pendingMsgForUpdate : null, (r36 & 2048) != 0 ? $this$mutate.inputBoxSelectState : null, (r36 & 4096) != 0 ? $this$mutate.deletingMsg : null, (r36 & 8192) != 0 ? $this$mutate.displayingBehaviorAlert : null, (r36 & 16384) != 0 ? $this$mutate.currentFetchResult : null, (r36 & 32768) != 0 ? $this$mutate.inputContent : InputContent.copy$default($this$mutate.getInputContent(), $draftResult, null, false, 0, 14, null), (r36 & 65536) != 0 ? $this$mutate.track : null);
        return copy;
    }
}