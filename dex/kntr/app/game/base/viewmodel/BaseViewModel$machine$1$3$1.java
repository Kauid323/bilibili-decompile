package kntr.app.game.base.viewmodel;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.game.base.viewmodel.PageState;
import kntr.app.game.base.viewmodel.event.PageEvent;
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
/* compiled from: BaseViewModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/game/base/viewmodel/PageState;", "<unused var>", "Lkntr/app/game/base/viewmodel/event/PageEvent$Retry;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/game/base/viewmodel/PageState$Error;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.viewmodel.BaseViewModel$machine$1$3$1", f = "BaseViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BaseViewModel$machine$1$3$1 extends SuspendLambda implements Function3<PageEvent.Retry, State<PageState.Error>, Continuation<? super ChangedState<? extends PageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseViewModel$machine$1$3$1(Continuation<? super BaseViewModel$machine$1$3$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(PageEvent.Retry retry, State<PageState.Error> state, Continuation<? super ChangedState<? extends PageState>> continuation) {
        BaseViewModel$machine$1$3$1 baseViewModel$machine$1$3$1 = new BaseViewModel$machine$1$3$1(continuation);
        baseViewModel$machine$1$3$1.L$0 = state;
        return baseViewModel$machine$1$3$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$machine$1$3$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        PageState.Loading invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = BaseViewModel$machine$1$3$1.invokeSuspend$lambda$0((PageState.Error) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState.Loading invokeSuspend$lambda$0(PageState.Error $this$override) {
        return PageState.Loading.INSTANCE;
    }
}