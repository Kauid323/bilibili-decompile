package kntr.common.paragraph.input;

import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.RichTextAction;
import kntr.common.paragraph.input.content.ParagraphContent;
import kntr.common.paragraph.input.content.TextContent;
import kntr.common.paragraph.input.content.TextRange;
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
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "<unused var>", "Lkntr/common/paragraph/input/RichTextAction$FocusOnFirstText;", "state", "Lkntr/common/paragraph/input/RichTextContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.paragraph.input.RichTextStateMachine$textInput$3", f = "RichTextStateMachine.kt", i = {0, 0, 0, 0, 1, 1}, l = {75, 82}, m = "invokeSuspend", n = {"state", "it", "firstText", "$i$a$-let-RichTextStateMachine$textInput$3$1", "state", "firstText"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "I$0"}, v = 1)
public final class RichTextStateMachine$textInput$3 extends SuspendLambda implements Function3<RichTextAction.FocusOnFirstText, RichTextContent, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ RichTextStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichTextStateMachine$textInput$3(RichTextStateMachine richTextStateMachine, Continuation<? super RichTextStateMachine$textInput$3> continuation) {
        super(3, continuation);
        this.this$0 = richTextStateMachine;
    }

    public final Object invoke(RichTextAction.FocusOnFirstText focusOnFirstText, RichTextContent richTextContent, Continuation<? super Unit> continuation) {
        RichTextStateMachine$textInput$3 richTextStateMachine$textInput$3 = new RichTextStateMachine$textInput$3(this.this$0, continuation);
        richTextStateMachine$textInput$3.L$0 = richTextContent;
        return richTextStateMachine$textInput$3.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        int firstText;
        int firstText2;
        RichTextContent state = (RichTextContent) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                List $this$indexOfFirst$iv = state.getContentList();
                int index$iv = 0;
                Iterator<ParagraphContent> it = $this$indexOfFirst$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object item$iv = it.next();
                        if (!(((ParagraphContent) item$iv) instanceof TextContent)) {
                            index$iv++;
                        }
                    } else {
                        index$iv = -1;
                    }
                }
                firstText = index$iv;
                if (firstText >= 0) {
                    ParagraphContent paragraphContent = state.getContentList().get(firstText);
                    TextContent it2 = paragraphContent instanceof TextContent ? (TextContent) paragraphContent : null;
                    if (it2 != null) {
                        RichTextStateMachine richTextStateMachine = this.this$0;
                        RichTextAction.TextChanged textChanged = new RichTextAction.TextChanged(TextContent.copy$default(it2, null, new TextRange(0, 0), null, 5, null), firstText);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(state);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(it2);
                        this.I$0 = firstText;
                        this.I$1 = 0;
                        this.label = 1;
                        if (richTextStateMachine.dispatch(textChanged, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(state);
                    this.L$1 = null;
                    this.I$0 = firstText;
                    this.label = 2;
                    if (this.this$0.dispatch(new RichTextAction.FocusOn(firstText, true), (Continuation) this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    firstText2 = firstText;
                }
                return Unit.INSTANCE;
            case 1:
                int i = this.I$1;
                firstText = this.I$0;
                TextContent textContent = (TextContent) this.L$1;
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(state);
                this.L$1 = null;
                this.I$0 = firstText;
                this.label = 2;
                if (this.this$0.dispatch(new RichTextAction.FocusOn(firstText, true), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                firstText2 = this.I$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}