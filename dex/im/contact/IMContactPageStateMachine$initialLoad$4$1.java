package im.contact;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.contact.model.IMContactPageData;
import im.contact.model.IMContactPageDataLensKt;
import im.contact.model.IMContactRefresh;
import im.contact.model.StatusLoading;
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
/* compiled from: IMContactPageStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/contact/model/IMContactPageData;", "<unused var>", "Lim/contact/model/IMContactRefresh;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.contact.IMContactPageStateMachine$initialLoad$4$1", f = "IMContactPageStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMContactPageStateMachine$initialLoad$4$1 extends SuspendLambda implements Function3<IMContactRefresh, State<IMContactPageData>, Continuation<? super ChangedState<? extends IMContactPageData>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMContactPageStateMachine$initialLoad$4$1(Continuation<? super IMContactPageStateMachine$initialLoad$4$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(IMContactRefresh iMContactRefresh, State<IMContactPageData> state, Continuation<? super ChangedState<IMContactPageData>> continuation) {
        IMContactPageStateMachine$initialLoad$4$1 iMContactPageStateMachine$initialLoad$4$1 = new IMContactPageStateMachine$initialLoad$4$1(continuation);
        iMContactPageStateMachine$initialLoad$4$1.L$0 = state;
        return iMContactPageStateMachine$initialLoad$4$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: im.contact.IMContactPageStateMachine$initialLoad$4$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMContactPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = IMContactPageStateMachine$initialLoad$4$1.invokeSuspend$lambda$0((IMContactPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMContactPageData invokeSuspend$lambda$0(IMContactPageData $this$mutate) {
        return (IMContactPageData) IMContactPageDataLensKt.getStatus(IMContactPageData.Companion).set($this$mutate, StatusLoading.INSTANCE);
    }
}