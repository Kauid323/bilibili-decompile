package im.keywordBlocking.stateMachine;

import com.bilibili.blens.BNullableLens;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import com.tencent.tauth.AuthActivity;
import im.keywordBlocking.KBActionInputBoxChanged;
import im.keywordBlocking.KBInputBoxLensKt;
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
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KBStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/keywordBlocking/KBPageData;", AuthActivity.ACTION_KEY, "Lim/keywordBlocking/KBActionInputBoxChanged;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.keywordBlocking.stateMachine.KBStateMachine$addKeyword$6$1", f = "KBStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class KBStateMachine$addKeyword$6$1 extends SuspendLambda implements Function3<KBActionInputBoxChanged, State<KBPageData>, Continuation<? super ChangedState<? extends KBPageData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KBStateMachine$addKeyword$6$1(Continuation<? super KBStateMachine$addKeyword$6$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(KBActionInputBoxChanged kBActionInputBoxChanged, State<KBPageData> state, Continuation<? super ChangedState<KBPageData>> continuation) {
        KBStateMachine$addKeyword$6$1 kBStateMachine$addKeyword$6$1 = new KBStateMachine$addKeyword$6$1(continuation);
        kBStateMachine$addKeyword$6$1.L$0 = kBActionInputBoxChanged;
        kBStateMachine$addKeyword$6$1.L$1 = state;
        return kBStateMachine$addKeyword$6$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        KBActionInputBoxChanged action = (KBActionInputBoxChanged) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final BNullableLens lens = KBInputBoxLensKt.textNullable(KBPageDataLensKt.getInputBox(KBPageData.Companion));
                final String text = StringsKt.take(action.getText(), ((KBPageData) state.getSnapshot()).getCharLimit$keyword_blocking_debug());
                return state.mutate(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$addKeyword$6$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        KBPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = KBStateMachine$addKeyword$6$1.invokeSuspend$lambda$0(lens, text, (KBPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KBPageData invokeSuspend$lambda$0(BNullableLens $lens, String $text, KBPageData $this$mutate) {
        return (KBPageData) $lens.set($this$mutate, $text);
    }
}