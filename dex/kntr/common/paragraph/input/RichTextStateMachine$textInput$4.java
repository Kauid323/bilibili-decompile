package kntr.common.paragraph.input;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.paragraph.input.RichTextAction;
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
/* compiled from: RichTextStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "<unused var>", "Lkntr/common/paragraph/input/RichTextAction$RetryFocusOn;", "state", "Lkntr/common/paragraph/input/RichTextContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.paragraph.input.RichTextStateMachine$textInput$4", f = "RichTextStateMachine.kt", i = {0, 0}, l = {89}, m = "invokeSuspend", n = {"state", "currentFocus"}, s = {"L$0", "I$0"}, v = 1)
public final class RichTextStateMachine$textInput$4 extends SuspendLambda implements Function3<RichTextAction.RetryFocusOn, RichTextContent, Continuation<? super Unit>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RichTextStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichTextStateMachine$textInput$4(RichTextStateMachine richTextStateMachine, Continuation<? super RichTextStateMachine$textInput$4> continuation) {
        super(3, continuation);
        this.this$0 = richTextStateMachine;
    }

    public final Object invoke(RichTextAction.RetryFocusOn retryFocusOn, RichTextContent richTextContent, Continuation<? super Unit> continuation) {
        RichTextStateMachine$textInput$4 richTextStateMachine$textInput$4 = new RichTextStateMachine$textInput$4(this.this$0, continuation);
        richTextStateMachine$textInput$4.L$0 = richTextContent;
        return richTextStateMachine$textInput$4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int currentFocus;
        RichTextContent state = (RichTextContent) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                int currentFocus2 = state.getCurrentFocus();
                if (currentFocus2 >= 0 && currentFocus2 < state.getContentList().size()) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(state);
                    this.I$0 = currentFocus2;
                    this.label = 1;
                    if (this.this$0.dispatch(new RichTextAction.FocusOn(currentFocus2, true), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    currentFocus = currentFocus2;
                    break;
                } else {
                    KLog_androidKt.getKLog().w("RichTextStateMachine", "Retry focus on failed, currentFocus: " + currentFocus2);
                    break;
                }
                break;
            case 1:
                currentFocus = this.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}