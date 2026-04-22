package kntr.common.paragraph.input;

import com.bilibili.blens.CollectionsKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.RichTextAction;
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
/* compiled from: RichTextStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/paragraph/input/RichTextContent;", "action", "Lkntr/common/paragraph/input/RichTextAction$TextChanged;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.paragraph.input.RichTextStateMachine$textInput$1", f = "RichTextStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RichTextStateMachine$textInput$1 extends SuspendLambda implements Function3<RichTextAction.TextChanged, State<RichTextContent>, Continuation<? super ChangedState<? extends RichTextContent>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RichTextStateMachine$textInput$1(Continuation<? super RichTextStateMachine$textInput$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(RichTextAction.TextChanged textChanged, State<RichTextContent> state, Continuation<? super ChangedState<RichTextContent>> continuation) {
        RichTextStateMachine$textInput$1 richTextStateMachine$textInput$1 = new RichTextStateMachine$textInput$1(continuation);
        richTextStateMachine$textInput$1.L$0 = textChanged;
        richTextStateMachine$textInput$1.L$1 = state;
        return richTextStateMachine$textInput$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final RichTextAction.TextChanged action = (RichTextAction.TextChanged) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.common.paragraph.input.RichTextStateMachine$textInput$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        RichTextContent invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = RichTextStateMachine$textInput$1.invokeSuspend$lambda$0(RichTextAction.TextChanged.this, (RichTextContent) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RichTextContent invokeSuspend$lambda$0(final RichTextAction.TextChanged $action, RichTextContent $this$mutate) {
        return (RichTextContent) CollectionsKt.single(RichTextContentLensKt.getContentList(RichTextContent.Companion), new Function1() { // from class: kntr.common.paragraph.input.RichTextStateMachine$textInput$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                int index;
                List list = (List) obj;
                index = RichTextAction.TextChanged.this.getIndex();
                return Integer.valueOf(index);
            }
        }).set($this$mutate, $action.getText());
    }
}