package kntr.app.im.chat.stateMachine.builder.send;

import com.bilibili.blens.BSetter;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.ChatPageDataLensKt;
import kntr.app.im.chat.core.model.ChatUpgradeAnswerDialogStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputBoxAction.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "<unused var>", "Lkntr/app/im/chat/core/model/ChatAction$DismissUpgradeAnswerDialog;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$bindInputBoxAction$10$1", f = "InputBoxAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InputBoxActionKt$bindInputBoxAction$10$1 extends SuspendLambda implements Function3<ChatAction.DismissUpgradeAnswerDialog, State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputBoxActionKt$bindInputBoxAction$10$1(Continuation<? super InputBoxActionKt$bindInputBoxAction$10$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(ChatAction.DismissUpgradeAnswerDialog dismissUpgradeAnswerDialog, State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        InputBoxActionKt$bindInputBoxAction$10$1 inputBoxActionKt$bindInputBoxAction$10$1 = new InputBoxActionKt$bindInputBoxAction$10$1(continuation);
        inputBoxActionKt$bindInputBoxAction$10$1.L$0 = state;
        return inputBoxActionKt$bindInputBoxAction$10$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$bindInputBoxAction$10$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        ChatPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = InputBoxActionKt$bindInputBoxAction$10$1.invokeSuspend$lambda$0((ChatPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$0(ChatPageData $this$mutate) {
        return (ChatPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$bindInputBoxAction$10$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = InputBoxActionKt$bindInputBoxAction$10$1.invokeSuspend$lambda$0$0((CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(CopyScope $this$copy) {
        Instant now;
        BSetter upgradeAnswerDialogStatus = ChatPageDataLensKt.getUpgradeAnswerDialogStatus(ChatPageData.Companion);
        Object obj = $this$copy.get(ChatPageDataLensKt.getUpgradeAnswerDialogStatus(ChatPageData.Companion));
        ChatUpgradeAnswerDialogStatus.SHOW show = obj instanceof ChatUpgradeAnswerDialogStatus.SHOW ? (ChatUpgradeAnswerDialogStatus.SHOW) obj : null;
        if (show == null || (now = show.getLastShowTime()) == null) {
            now = Clock.System.INSTANCE.now();
        }
        $this$copy.set(upgradeAnswerDialogStatus, new ChatUpgradeAnswerDialogStatus.DISMISSED(now));
        return Unit.INSTANCE;
    }
}