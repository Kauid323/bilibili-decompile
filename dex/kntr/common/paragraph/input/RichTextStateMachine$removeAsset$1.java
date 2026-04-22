package kntr.common.paragraph.input;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.RichTextAction;
import kntr.common.paragraph.input.content.ParagraphContent;
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
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RichTextStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/paragraph/input/RichTextContent;", "action", "Lkntr/common/paragraph/input/RichTextAction$RemoveAsset;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.paragraph.input.RichTextStateMachine$removeAsset$1", f = "RichTextStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RichTextStateMachine$removeAsset$1 extends SuspendLambda implements Function3<RichTextAction.RemoveAsset, State<RichTextContent>, Continuation<? super ChangedState<? extends RichTextContent>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RichTextStateMachine$removeAsset$1(Continuation<? super RichTextStateMachine$removeAsset$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(RichTextAction.RemoveAsset removeAsset, State<RichTextContent> state, Continuation<? super ChangedState<RichTextContent>> continuation) {
        RichTextStateMachine$removeAsset$1 richTextStateMachine$removeAsset$1 = new RichTextStateMachine$removeAsset$1(continuation);
        richTextStateMachine$removeAsset$1.L$0 = removeAsset;
        richTextStateMachine$removeAsset$1.L$1 = state;
        return richTextStateMachine$removeAsset$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final List newList;
        RichTextAction.RemoveAsset action = (RichTextAction.RemoveAsset) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                RichTextContent snapshot = (RichTextContent) state.getSnapshot();
                List snapshotList = snapshot.getContentList();
                int index = action.getIndex();
                ParagraphContent lastContent = (ParagraphContent) CollectionsKt.getOrNull(snapshotList, index - 1);
                ParagraphContent nextContent = (ParagraphContent) CollectionsKt.getOrNull(snapshotList, index + 1);
                if ((lastContent instanceof TextContent) && (nextContent instanceof TextContent)) {
                    newList = CollectionsKt.plus(CollectionsKt.plus(snapshotList.subList(0, index - 1), ((TextContent) lastContent).merge((TextContent) nextContent)), snapshotList.subList(index + 2, snapshotList.size()));
                } else {
                    newList = CollectionsKt.plus(snapshotList.subList(0, index), snapshotList.subList(index + 1, snapshotList.size()));
                }
                return state.mutate(new Function1() { // from class: kntr.common.paragraph.input.RichTextStateMachine$removeAsset$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        RichTextContent invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = RichTextStateMachine$removeAsset$1.invokeSuspend$lambda$0(newList, (RichTextContent) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RichTextContent invokeSuspend$lambda$0(List $newList, RichTextContent $this$mutate) {
        return RichTextContent.copy$default($this$mutate, $newList, RangesKt.coerceAtMost($this$mutate.getCurrentFocus(), $newList.size() - 1), false, null, 12, null);
    }
}