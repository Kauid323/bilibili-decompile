package im.keywordBlocking.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import com.tencent.tauth.AuthActivity;
import im.keywordBlocking.KBActionDeleteItem;
import im.keywordBlocking.KBAlertDeleteConfirm;
import im.keywordBlocking.KBPageData;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/keywordBlocking/KBPageData;", AuthActivity.ACTION_KEY, "Lim/keywordBlocking/KBActionDeleteItem;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.keywordBlocking.stateMachine.KBStateMachine$deleteKeyword$2$2", f = "KBStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class KBStateMachine$deleteKeyword$2$2 extends SuspendLambda implements Function3<KBActionDeleteItem, State<KBPageData>, Continuation<? super ChangedState<? extends KBPageData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KBStateMachine$deleteKeyword$2$2(Continuation<? super KBStateMachine$deleteKeyword$2$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(KBActionDeleteItem kBActionDeleteItem, State<KBPageData> state, Continuation<? super ChangedState<KBPageData>> continuation) {
        KBStateMachine$deleteKeyword$2$2 kBStateMachine$deleteKeyword$2$2 = new KBStateMachine$deleteKeyword$2$2(continuation);
        kBStateMachine$deleteKeyword$2$2.L$0 = kBActionDeleteItem;
        kBStateMachine$deleteKeyword$2$2.L$1 = state;
        return kBStateMachine$deleteKeyword$2$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final KBActionDeleteItem action = (KBActionDeleteItem) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: im.keywordBlocking.stateMachine.KBStateMachine$deleteKeyword$2$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        KBPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = KBStateMachine$deleteKeyword$2$2.invokeSuspend$lambda$0(KBActionDeleteItem.this, (KBPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KBPageData invokeSuspend$lambda$0(KBActionDeleteItem $action, KBPageData $this$mutate) {
        KBPageData copy;
        copy = $this$mutate.copy((r22 & 1) != 0 ? $this$mutate.status : null, (r22 & 2) != 0 ? $this$mutate.items : null, (r22 & 4) != 0 ? $this$mutate.limit : 0, (r22 & 8) != 0 ? $this$mutate.limitsHint : null, (r22 & 16) != 0 ? $this$mutate.charLimit : 0, (r22 & 32) != 0 ? $this$mutate.toast : null, (r22 & 64) != 0 ? $this$mutate.inputBox : null, (r22 & 128) != 0 ? $this$mutate.dropList : null, (r22 & 256) != 0 ? $this$mutate.alert : new KBAlertDeleteConfirm($action), (r22 & 512) != 0 ? $this$mutate.firstLoad : false);
        return copy;
    }
}