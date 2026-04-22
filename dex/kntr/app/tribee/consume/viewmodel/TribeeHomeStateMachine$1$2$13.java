package kntr.app.tribee.consume.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Iterator;
import java.util.Map;
import kntr.app.tribee.consume.page.model.TribeeDynListState;
import kntr.app.tribee.consume.page.model.TribeeFetchModel;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeState;
import kntr.app.upcomingEpisode.ConstantsKt;
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
/* compiled from: TribeeHomeStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "action", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$LoadMore;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$13", f = "TribeeHomeStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeHomeStateMachine$1$2$13 extends SuspendLambda implements Function3<TribeeHomeStateAction.LoadMore, State<TribeeHomeContentState>, Continuation<? super ChangedState<? extends TribeeHomeState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeeHomeStateMachine$1$2$13(Continuation<? super TribeeHomeStateMachine$1$2$13> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeeHomeStateAction.LoadMore loadMore, State<TribeeHomeContentState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        TribeeHomeStateMachine$1$2$13 tribeeHomeStateMachine$1$2$13 = new TribeeHomeStateMachine$1$2$13(continuation);
        tribeeHomeStateMachine$1$2$13.L$0 = loadMore;
        tribeeHomeStateMachine$1$2$13.L$1 = state;
        return tribeeHomeStateMachine$1$2$13.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean z;
        Object obj;
        TribeeDynListState tribeeDynListState;
        Map.Entry it;
        final TribeeHomeStateAction.LoadMore action = (TribeeHomeStateAction.LoadMore) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterator<T> it2 = ((TribeeHomeContentState) state.getSnapshot()).getCategoryList().entrySet().iterator();
                while (true) {
                    z = true;
                    if (it2.hasNext()) {
                        obj = it2.next();
                        Map.Entry it3 = (Map.Entry) obj;
                        if (((KTribeeCategory) it3.getKey()).getId() == ((TribeeHomeContentState) state.getSnapshot()).getCategoryId()) {
                            it = 1;
                            continue;
                        } else {
                            it = null;
                            continue;
                        }
                        if (it != null) {
                        }
                    } else {
                        obj = null;
                    }
                }
                Map.Entry currentEntry = (Map.Entry) obj;
                if (currentEntry == null || (tribeeDynListState = (TribeeDynListState) currentEntry.getValue()) == null || !tribeeDynListState.hasMore()) {
                    z = false;
                }
                if (z) {
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$13$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            TribeeHomeContentState invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = TribeeHomeStateMachine$1$2$13.invokeSuspend$lambda$1(TribeeHomeStateAction.LoadMore.this, (TribeeHomeContentState) obj2);
                            return invokeSuspend$lambda$1;
                        }
                    });
                }
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$1(TribeeHomeStateAction.LoadMore $action, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : new TribeeFetchModel($action, $this$mutate.getFetchModel().getFetchIdentity() + 1), (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : $this$mutate.insertActionAndRemoveAllConflicted($action), (r20 & 128) != 0 ? $this$mutate.uiAction : null);
        return copy;
    }
}