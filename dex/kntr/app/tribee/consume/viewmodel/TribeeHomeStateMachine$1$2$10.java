package kntr.app.tribee.consume.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kntr.app.tribee.consume.page.model.TribeeDynListState;
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
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "action", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$SwitchSubarea;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$10", f = "TribeeHomeStateMachine.kt", i = {0, 0, 0}, l = {578}, m = "invokeSuspend", n = {"action", "state", "hasCache"}, s = {"L$0", "L$1", "I$0"}, v = 1)
public final class TribeeHomeStateMachine$1$2$10 extends SuspendLambda implements Function3<TribeeHomeStateAction.SwitchSubarea, State<TribeeHomeContentState>, Continuation<? super ChangedState<? extends TribeeHomeState>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ TribeeHomeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomeStateMachine$1$2$10(TribeeHomeStateMachine tribeeHomeStateMachine, Continuation<? super TribeeHomeStateMachine$1$2$10> continuation) {
        super(3, continuation);
        this.this$0 = tribeeHomeStateMachine;
    }

    public final Object invoke(TribeeHomeStateAction.SwitchSubarea switchSubarea, State<TribeeHomeContentState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        TribeeHomeStateMachine$1$2$10 tribeeHomeStateMachine$1$2$10 = new TribeeHomeStateMachine$1$2$10(this.this$0, continuation);
        tribeeHomeStateMachine$1$2$10.L$0 = switchSubarea;
        tribeeHomeStateMachine$1$2$10.L$1 = state;
        return tribeeHomeStateMachine$1$2$10.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Iterable $this$any$iv;
        KTribeeCategory it;
        Map.Entry it2;
        int i;
        final TribeeHomeStateAction.SwitchSubarea action = (TribeeHomeStateAction.SwitchSubarea) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$any$iv2 = ((TribeeHomeContentState) state.getSnapshot()).getCategoryList().keySet();
                int i2 = 0;
                if (($this$any$iv2 instanceof Collection) && ((Collection) $this$any$iv2).isEmpty()) {
                    $this$any$iv = null;
                } else {
                    Iterator<T> it3 = $this$any$iv2.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            Object element$iv = it3.next();
                            KTribeeCategory it4 = (KTribeeCategory) element$iv;
                            if (it4.getId() == action.getCategory().getId()) {
                                it = 1;
                                continue;
                            } else {
                                it = null;
                                continue;
                            }
                            if (it != null) {
                                $this$any$iv = 1;
                            }
                        } else {
                            $this$any$iv = null;
                        }
                    }
                }
                if ($this$any$iv == null || ((TribeeHomeContentState) state.getSnapshot()).getCategoryId() == action.getCategory().getId()) {
                    return state.noChange();
                }
                Iterable $this$any$iv3 = ((TribeeHomeContentState) state.getSnapshot()).getCategoryList().entrySet();
                if (!($this$any$iv3 instanceof Collection) || !((Collection) $this$any$iv3).isEmpty()) {
                    Iterator<T> it5 = $this$any$iv3.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            Object element$iv2 = it5.next();
                            Map.Entry it6 = (Map.Entry) element$iv2;
                            if (((KTribeeCategory) it6.getKey()).getId() != action.getCategory().getId() || ((TribeeDynListState) it6.getValue()).getContent() == null) {
                                it2 = null;
                                continue;
                            } else {
                                it2 = 1;
                                continue;
                            }
                            if (it2 != null) {
                                i2 = 1;
                            }
                        }
                    }
                }
                int i3 = i2;
                if (i3 == 0) {
                    this.L$0 = action;
                    this.L$1 = state;
                    this.I$0 = i3;
                    this.label = 1;
                    if (this.this$0.dispatch(new TribeeHomeStateAction.FetchCategory(action.getCategory().getId()), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i = i3;
                    break;
                }
                break;
            case 1:
                i = this.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$10$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                TribeeHomeContentState invokeSuspend$lambda$2;
                invokeSuspend$lambda$2 = TribeeHomeStateMachine$1$2$10.invokeSuspend$lambda$2(TribeeHomeStateAction.SwitchSubarea.this, (TribeeHomeContentState) obj);
                return invokeSuspend$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$2(TribeeHomeStateAction.SwitchSubarea $action, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : $action.getCategory().getId(), (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : null, (r20 & 128) != 0 ? $this$mutate.uiAction : null);
        return copy;
    }
}