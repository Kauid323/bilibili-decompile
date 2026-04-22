package kntr.app.tribee.consume.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSortInfo;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.tribee.consume.page.model.TribeeDynListState;
import kntr.app.tribee.consume.page.model.TribeeFetchModel;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomeStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "action", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$SwitchSortType;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$17", f = "TribeeHomeStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeHomeStateMachine$1$2$17 extends SuspendLambda implements Function3<TribeeHomeStateAction.SwitchSortType, State<TribeeHomeContentState>, Continuation<? super ChangedState<? extends TribeeHomeState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeeHomeStateMachine$1$2$17(Continuation<? super TribeeHomeStateMachine$1$2$17> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TribeeHomeStateAction.SwitchSortType switchSortType, State<TribeeHomeContentState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        TribeeHomeStateMachine$1$2$17 tribeeHomeStateMachine$1$2$17 = new TribeeHomeStateMachine$1$2$17(continuation);
        tribeeHomeStateMachine$1$2$17.L$0 = switchSortType;
        tribeeHomeStateMachine$1$2$17.L$1 = state;
        return tribeeHomeStateMachine$1$2$17.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        boolean z;
        final TribeeHomeStateAction.SwitchSortType action = (TribeeHomeStateAction.SwitchSortType) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final TribeeHomeStateAction.Refresh refreshAction = new TribeeHomeStateAction.Refresh(true);
                Iterator<T> it = ((TribeeHomeContentState) state.getSnapshot()).getCategoryList().entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        Map.Entry it2 = (Map.Entry) obj;
                        if (((KTribeeCategory) it2.getKey()).getId() == ((TribeeHomeContentState) state.getSnapshot()).getCategoryId()) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                        }
                    } else {
                        obj = null;
                    }
                }
                final Map.Entry currentEntry = (Map.Entry) obj;
                if (currentEntry != null) {
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$17$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            TribeeHomeContentState invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = TribeeHomeStateMachine$1$2$17.invokeSuspend$lambda$1(TribeeHomeStateAction.Refresh.this, currentEntry, action, (TribeeHomeContentState) obj2);
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
    public static final TribeeHomeContentState invokeSuspend$lambda$1(TribeeHomeStateAction.Refresh $refreshAction, Map.Entry $currentEntry, TribeeHomeStateAction.SwitchSortType $action, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        Set<TribeeHomeStateAction> insertActionAndRemoveAllConflicted = $this$mutate.insertActionAndRemoveAllConflicted($refreshAction);
        Map $this$invokeSuspend_u24lambda_u241_u240 = MapsKt.toMutableMap($this$mutate.getCategoryList());
        Object key = $currentEntry.getKey();
        TribeeDynListState tribeeDynListState = (TribeeDynListState) $currentEntry.getValue();
        KTribeeSortInfo tribeeSortInfo = ((TribeeDynListState) $currentEntry.getValue()).getTribeeSortInfo();
        $this$invokeSuspend_u24lambda_u241_u240.put(key, TribeeDynListState.copy$default(tribeeDynListState, null, null, tribeeSortInfo != null ? KTribeeSortInfo.copy$default(tribeeSortInfo, false, (String) null, (List) null, $action.getSortType(), 7, (Object) null) : null, 3, null));
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : $this$invokeSuspend_u24lambda_u241_u240, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : new TribeeFetchModel($refreshAction, $this$mutate.getFetchModel().getFetchIdentity() + 1), (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : insertActionAndRemoveAllConflicted, (r20 & 128) != 0 ? $this$mutate.uiAction : null);
        return copy;
    }
}