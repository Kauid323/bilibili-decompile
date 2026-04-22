package im.keywordBlocking.stateMachine;

import com.bilibili.blens.BSimpleLens;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.keywordBlocking.KBActionAddItem;
import im.keywordBlocking.KBInputBox;
import im.keywordBlocking.KBPageData;
import im.keywordBlocking.KBPageDataLensKt;
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
/* compiled from: KBStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/keywordBlocking/KBPageData;", "<unused var>", "Lim/keywordBlocking/KBActionAddItem;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.keywordBlocking.stateMachine.KBStateMachine$addKeyword$2$1", f = "KBStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class KBStateMachine$addKeyword$2$1 extends SuspendLambda implements Function3<KBActionAddItem, State<KBPageData>, Continuation<? super ChangedState<? extends KBPageData>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KBStateMachine$addKeyword$2$1(Continuation<? super KBStateMachine$addKeyword$2$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(KBActionAddItem kBActionAddItem, State<KBPageData> state, Continuation<? super ChangedState<KBPageData>> continuation) {
        KBStateMachine$addKeyword$2$1 kBStateMachine$addKeyword$2$1 = new KBStateMachine$addKeyword$2$1(continuation);
        kBStateMachine$addKeyword$2$1.L$0 = state;
        return kBStateMachine$addKeyword$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final BSimpleLens lens = KBPageDataLensKt.getInputBox(KBPageData.Companion);
                return state.mutate(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$addKeyword$2$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        KBPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = KBStateMachine$addKeyword$2$1.invokeSuspend$lambda$0(lens, (KBPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KBPageData invokeSuspend$lambda$0(BSimpleLens $lens, KBPageData $this$mutate) {
        return (KBPageData) $lens.set($this$mutate, new KBInputBox("", $this$mutate.getCharLimit$keyword_blocking_debug()));
    }
}