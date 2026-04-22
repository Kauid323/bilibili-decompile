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
/* JADX INFO: Add missing generic type declarations: [Data] */
/* compiled from: BaseViewModel.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\b0\u0007H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/game/base/viewmodel/PageState;", "Data", "<unused var>", "Lkntr/app/game/base/viewmodel/event/PageEvent$LoadMore;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/game/base/viewmodel/PageState$Content;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.viewmodel.BaseViewModel$machine$1$4$2", f = "BaseViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BaseViewModel$machine$1$4$2<Data> extends SuspendLambda implements Function3<PageEvent.LoadMore, State<PageState.Content<Data>>, Continuation<? super ChangedState<? extends PageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseViewModel$machine$1$4$2(Continuation<? super BaseViewModel$machine$1$4$2> continuation) {
        super(3, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((PageEvent.LoadMore) obj, (State) ((State) obj2), (Continuation) obj3);
    }

    public final Object invoke(PageEvent.LoadMore loadMore, State<PageState.Content<Data>> state, Continuation<? super ChangedState<? extends PageState>> continuation) {
        BaseViewModel$machine$1$4$2 baseViewModel$machine$1$4$2 = new BaseViewModel$machine$1$4$2(continuation);
        baseViewModel$machine$1$4$2.L$0 = state;
        return baseViewModel$machine$1$4$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$machine$1$4$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        PageState.Content invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = BaseViewModel$machine$1$4$2.invokeSuspend$lambda$0(state, (PageState.Content) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState.Content invokeSuspend$lambda$0(State $state, PageState.Content $this$override) {
        return new PageState.Content(((PageState.Content) $state.getSnapshot()).getData(), PageLoadMoreState.Companion.getLoading(), null, 4, null);
    }
}