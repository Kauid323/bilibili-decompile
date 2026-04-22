package kntr.app.tribee.consume.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDyn;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.Iterator;
import kntr.app.tribee.base.TribeeResultChannel;
import kntr.app.tribee.base.TribeeResultContent;
import kntr.app.tribee.consume.TribeeExtensionsKt;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomeStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "action", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$AwaitPublishResult;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$6", f = "TribeeHomeStateMachine.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {369, 377}, m = "invokeSuspend", n = {"action", "state", "action", "state", "result", "fakeDyn", "selectedCategory", "$i$a$-let-TribeeHomeStateMachine$1$2$6$1", "publishCategoryId"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "J$0"}, v = 1)
public final class TribeeHomeStateMachine$1$2$6 extends SuspendLambda implements Function3<TribeeHomeStateAction.AwaitPublishResult, State<TribeeHomeContentState>, Continuation<? super ChangedState<? extends TribeeHomeState>>, Object> {
    int I$0;
    long J$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ TribeeHomeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomeStateMachine$1$2$6(TribeeHomeStateMachine tribeeHomeStateMachine, Continuation<? super TribeeHomeStateMachine$1$2$6> continuation) {
        super(3, continuation);
        this.this$0 = tribeeHomeStateMachine;
    }

    public final Object invoke(TribeeHomeStateAction.AwaitPublishResult awaitPublishResult, State<TribeeHomeContentState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        TribeeHomeStateMachine$1$2$6 tribeeHomeStateMachine$1$2$6 = new TribeeHomeStateMachine$1$2$6(this.this$0, continuation);
        tribeeHomeStateMachine$1$2$6.L$0 = awaitPublishResult;
        tribeeHomeStateMachine$1$2$6.L$1 = state;
        return tribeeHomeStateMachine$1$2$6.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object awaitResult;
        TribeeResultContent result;
        Object obj;
        final KTribeeCategory selectedCategory;
        boolean z;
        ChangedState mutate;
        TribeeHomeStateAction.AwaitPublishResult action = (TribeeHomeStateAction.AwaitPublishResult) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().d("TribeeHomeStateMachine", "router to publish page : resultKey = " + action.getResultKey());
                this.L$0 = action;
                this.L$1 = state;
                this.label = 1;
                awaitResult = TribeeResultChannel.INSTANCE.awaitResult(action.getResultKey(), (Continuation) this);
                if (awaitResult == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result = (TribeeResultContent) awaitResult;
                if (result != null) {
                    TribeeHomeStateMachine tribeeHomeStateMachine = this.this$0;
                    KTribeeDyn fakeDyn = result.getContent();
                    long publishCategoryId = result.getCategoryId();
                    Iterator<T> it = ((TribeeHomeContentState) state.getSnapshot()).getCategoryList().keySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            KTribeeCategory it2 = (KTribeeCategory) obj;
                            if (it2.getId() == publishCategoryId) {
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
                    KTribeeCategory kTribeeCategory = (KTribeeCategory) obj;
                    if (kTribeeCategory == null) {
                        kTribeeCategory = TribeeExtensionsKt.getDEFAULT_CATEGORY();
                    }
                    KTribeeCategory selectedCategory2 = kTribeeCategory;
                    TribeeHomeStateAction.InsertFakeDyn insertFakeDyn = new TribeeHomeStateAction.InsertFakeDyn(action.getResultKey(), selectedCategory2.getId(), fakeDyn);
                    this.L$0 = action;
                    this.L$1 = state;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(result);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(fakeDyn);
                    this.L$4 = selectedCategory2;
                    this.I$0 = 0;
                    this.J$0 = publishCategoryId;
                    this.label = 2;
                    if (tribeeHomeStateMachine.dispatch(insertFakeDyn, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    selectedCategory = selectedCategory2;
                    mutate = state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$6$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            TribeeHomeContentState invokeSuspend$lambda$0$1;
                            invokeSuspend$lambda$0$1 = TribeeHomeStateMachine$1$2$6.invokeSuspend$lambda$0$1(selectedCategory, (TribeeHomeContentState) obj2);
                            return invokeSuspend$lambda$0$1;
                        }
                    });
                    if (mutate != null) {
                        return mutate;
                    }
                }
                KLog_androidKt.getKLog().d("TribeeHomeStateMachine", "back from publish page : resultKey = " + action.getResultKey() + " , but nothing happened.");
                return state.noChange();
            case 1:
                ResultKt.throwOnFailure($result);
                awaitResult = $result;
                result = (TribeeResultContent) awaitResult;
                if (result != null) {
                }
                KLog_androidKt.getKLog().d("TribeeHomeStateMachine", "back from publish page : resultKey = " + action.getResultKey() + " , but nothing happened.");
                return state.noChange();
            case 2:
                long j = this.J$0;
                int i = this.I$0;
                selectedCategory = (KTribeeCategory) this.L$4;
                KTribeeDyn kTribeeDyn = (KTribeeDyn) this.L$3;
                TribeeResultContent tribeeResultContent = (TribeeResultContent) this.L$2;
                ResultKt.throwOnFailure($result);
                mutate = state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$6$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        TribeeHomeContentState invokeSuspend$lambda$0$1;
                        invokeSuspend$lambda$0$1 = TribeeHomeStateMachine$1$2$6.invokeSuspend$lambda$0$1(selectedCategory, (TribeeHomeContentState) obj2);
                        return invokeSuspend$lambda$0$1;
                    }
                });
                if (mutate != null) {
                }
                KLog_androidKt.getKLog().d("TribeeHomeStateMachine", "back from publish page : resultKey = " + action.getResultKey() + " , but nothing happened.");
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$0$1(KTribeeCategory $selectedCategory, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : $selectedCategory.getId(), (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : null, (r20 & 128) != 0 ? $this$mutate.uiAction : null);
        return copy;
    }
}