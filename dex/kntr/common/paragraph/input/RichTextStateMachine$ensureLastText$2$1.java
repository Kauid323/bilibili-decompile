package kntr.common.paragraph.input;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.content.TextContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RichTextStateMachine.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/paragraph/input/RichTextContent;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.paragraph.input.RichTextStateMachine$ensureLastText$2$1", f = "RichTextStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RichTextStateMachine$ensureLastText$2$1 extends SuspendLambda implements Function2<State<RichTextContent>, Continuation<? super ChangedState<? extends RichTextContent>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RichTextStateMachine$ensureLastText$2$1(Continuation<? super RichTextStateMachine$ensureLastText$2$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> richTextStateMachine$ensureLastText$2$1 = new RichTextStateMachine$ensureLastText$2$1(continuation);
        richTextStateMachine$ensureLastText$2$1.L$0 = obj;
        return richTextStateMachine$ensureLastText$2$1;
    }

    public final Object invoke(State<RichTextContent> state, Continuation<? super ChangedState<RichTextContent>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.common.paragraph.input.RichTextStateMachine$ensureLastText$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        RichTextContent invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = RichTextStateMachine$ensureLastText$2$1.invokeSuspend$lambda$0((RichTextContent) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RichTextContent invokeSuspend$lambda$0(RichTextContent $this$mutate) {
        return RichTextContent.copy$default($this$mutate, CollectionsKt.plus($this$mutate.getContentList(), new TextContent("", null, null, 6, null)), 0, false, null, 14, null);
    }
}