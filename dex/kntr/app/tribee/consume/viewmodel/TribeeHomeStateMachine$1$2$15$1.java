package kntr.app.tribee.consume.viewmodel;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.TribeeHomeUIAction;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeState;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomeStateMachine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "it", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$15$1", f = "TribeeHomeStateMachine.kt", i = {0, 0, 1, 1}, l = {652, 658}, m = "invokeSuspend", n = {"it", "action", "it", "action"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class TribeeHomeStateMachine$1$2$15$1 extends SuspendLambda implements Function2<State<TribeeHomeContentState>, Continuation<? super ChangedState<? extends TribeeHomeState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TribeeHomeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomeStateMachine$1$2$15$1(TribeeHomeStateMachine tribeeHomeStateMachine, Continuation<? super TribeeHomeStateMachine$1$2$15$1> continuation) {
        super(2, continuation);
        this.this$0 = tribeeHomeStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tribeeHomeStateMachine$1$2$15$1 = new TribeeHomeStateMachine$1$2$15$1(this.this$0, continuation);
        tribeeHomeStateMachine$1$2$15$1.L$0 = obj;
        return tribeeHomeStateMachine$1$2$15$1;
    }

    public final Object invoke(State<TribeeHomeContentState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final Object invokeSuspend(Object $result) {
        Object handleRefresh;
        TribeeHomeStateAction action;
        Object handleLoadMore;
        TribeeHomeStateAction action2;
        State it = (State) this.L$0;
        final ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    TribeeHomeStateAction action3 = ((TribeeHomeContentState) it.getSnapshot()).getFetchModel().getFromAction();
                    KLog_androidKt.getKLog().d("TribeeHomeStateMachine", "start to requesting page api by action (" + action3 + ").");
                    try {
                        if (action3 instanceof TribeeHomeStateAction.LoadMore) {
                            this.L$0 = it;
                            this.L$1 = action3;
                            this.label = 1;
                            handleLoadMore = this.this$0.handleLoadMore((TribeeHomeStateAction.LoadMore) action3, it, (Continuation) this);
                            if (handleLoadMore == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            action2 = action3;
                            return (ChangedState) handleLoadMore;
                        }
                        if (!(action3 instanceof TribeeHomeStateAction.Refresh) && !(action3 instanceof TribeeHomeStateAction.FetchCategory)) {
                            return it.noChange();
                        }
                        this.L$0 = it;
                        this.L$1 = action3;
                        this.label = 2;
                        handleRefresh = this.this$0.handleRefresh(action3, it, (Continuation) this);
                        if (handleRefresh == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        action = action3;
                        return (ChangedState) handleRefresh;
                    } catch (Exception e) {
                        e = e;
                        coroutine_suspended = action3;
                        KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "request page api by category id occur error!.", e);
                        return it.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$15$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                TribeeHomeContentState invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = TribeeHomeStateMachine$1$2$15$1.invokeSuspend$lambda$0(e, coroutine_suspended, (TribeeHomeContentState) obj);
                                return invokeSuspend$lambda$0;
                            }
                        });
                    }
                case 1:
                    action2 = (TribeeHomeStateAction) this.L$1;
                    ResultKt.throwOnFailure($result);
                    handleLoadMore = $result;
                    return (ChangedState) handleLoadMore;
                case 2:
                    action = (TribeeHomeStateAction) this.L$1;
                    ResultKt.throwOnFailure($result);
                    handleRefresh = $result;
                    return (ChangedState) handleRefresh;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$0(Exception $e, TribeeHomeStateAction $action, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : $this$mutate.removeIfObservedAction($action), (r20 & 128) != 0 ? $this$mutate.uiAction : new TribeeHomeUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, $e, null, 2, null)));
        return copy;
    }
}