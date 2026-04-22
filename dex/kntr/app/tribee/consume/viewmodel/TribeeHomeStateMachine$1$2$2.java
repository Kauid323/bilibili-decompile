package kntr.app.tribee.consume.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KTribeeBaseInfo;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDesc;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchBar;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.TribeeHomeUIAction;
import kntr.app.tribee.consume.viewmodel.service.TribeeHomeDataService;
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
import kotlin.jvm.functions.Function3;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.tribee.consume.generated.resources.Res;
import srcs.app.tribee.consume.generated.resources.String0_commonMainKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomeStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "action", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$ToJoinTribee;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$2", f = "TribeeHomeStateMachine.kt", i = {0, 1, 1, 2, 2}, l = {199, 201, 203}, m = "invokeSuspend", n = {"state", "state", "resultTips", "state", "resultTips"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class TribeeHomeStateMachine$1$2$2 extends SuspendLambda implements Function3<TribeeHomeStateAction.ToJoinTribee, State<TribeeHomeContentState>, Continuation<? super ChangedState<? extends TribeeHomeState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TribeeHomeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomeStateMachine$1$2$2(TribeeHomeStateMachine tribeeHomeStateMachine, Continuation<? super TribeeHomeStateMachine$1$2$2> continuation) {
        super(3, continuation);
        this.this$0 = tribeeHomeStateMachine;
    }

    public final Object invoke(TribeeHomeStateAction.ToJoinTribee toJoinTribee, State<TribeeHomeContentState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        TribeeHomeStateMachine$1$2$2 tribeeHomeStateMachine$1$2$2 = new TribeeHomeStateMachine$1$2$2(this.this$0, continuation);
        tribeeHomeStateMachine$1$2$2.L$0 = state;
        return tribeeHomeStateMachine$1$2$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        final Exception e;
        Object string;
        TribeeHomeDataService tribeeHomeDataService;
        final String resultTips;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = this.label;
        try {
            switch (r2) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    KTribeeBaseInfo baseInfo = ((TribeeHomeContentState) state.getSnapshot()).getBaseInfo();
                    if (baseInfo != null && baseInfo.isJoined()) {
                        return state.noChange();
                    }
                    this.L$0 = state;
                    this.label = 1;
                    string = StringResourcesKt.getString(String0_commonMainKt.getTribee_join_successful(Res.string.INSTANCE), (Continuation) this);
                    if (string == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    String resultTips2 = (String) string;
                    tribeeHomeDataService = this.this$0.dataService;
                    this.L$0 = state;
                    this.L$1 = resultTips2;
                    this.label = 2;
                    r2 = resultTips2;
                    if (tribeeHomeDataService.join(true, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.L$0 = state;
                    this.L$1 = r2;
                    this.label = 3;
                    if (this.this$0.dispatch(new TribeeHomeStateAction.Refresh(false), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    resultTips = r2;
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            TribeeHomeContentState invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = TribeeHomeStateMachine$1$2$2.invokeSuspend$lambda$0(resultTips, (TribeeHomeContentState) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                case 1:
                    ResultKt.throwOnFailure($result);
                    string = $result;
                    String resultTips22 = (String) string;
                    tribeeHomeDataService = this.this$0.dataService;
                    this.L$0 = state;
                    this.L$1 = resultTips22;
                    this.label = 2;
                    r2 = resultTips22;
                    if (tribeeHomeDataService.join(true, (Continuation) this) == coroutine_suspended) {
                    }
                    this.L$0 = state;
                    this.L$1 = r2;
                    this.label = 3;
                    if (this.this$0.dispatch(new TribeeHomeStateAction.Refresh(false), (Continuation) this) == coroutine_suspended) {
                    }
                    break;
                case 2:
                    String str = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    r2 = str;
                    this.L$0 = state;
                    this.L$1 = r2;
                    this.label = 3;
                    if (this.this$0.dispatch(new TribeeHomeStateAction.Refresh(false), (Continuation) this) == coroutine_suspended) {
                    }
                    break;
                case 3:
                    resultTips = (String) this.L$1;
                    try {
                        ResultKt.throwOnFailure($result);
                        return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$2$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                TribeeHomeContentState invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = TribeeHomeStateMachine$1$2$2.invokeSuspend$lambda$0(resultTips, (TribeeHomeContentState) obj);
                                return invokeSuspend$lambda$0;
                            }
                        });
                    } catch (Exception e2) {
                        e = e2;
                        KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "join tribee error! (" + e.getMessage() + ")");
                        return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$2$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                TribeeHomeContentState invokeSuspend$lambda$1;
                                invokeSuspend$lambda$1 = TribeeHomeStateMachine$1$2$2.invokeSuspend$lambda$1(e, (TribeeHomeContentState) obj);
                                return invokeSuspend$lambda$1;
                            }
                        });
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$0(String $resultTips, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        KTribeeBaseInfo baseInfo = $this$mutate.getBaseInfo();
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : baseInfo != null ? KTribeeBaseInfo.copy$default(baseInfo, (KTribeeDesc) null, true, false, false, (String) null, (KTribeeSearchBar) null, 61, (Object) null) : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : null, (r20 & 128) != 0 ? $this$mutate.uiAction : new TribeeHomeUIAction.ToastTips(TribeeToast.Companion.create($resultTips)));
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$1(Exception $e, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : null, (r20 & 128) != 0 ? $this$mutate.uiAction : new TribeeHomeUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, $e, null, 2, null)));
        return copy;
    }
}