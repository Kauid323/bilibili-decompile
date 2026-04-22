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
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "action", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction$ToExitTribee;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$5", f = "TribeeHomeStateMachine.kt", i = {0, 1, 1}, l = {331, 333}, m = "invokeSuspend", n = {"state", "state", "resultTips"}, s = {"L$0", "L$0", "L$1"}, v = 1)
public final class TribeeHomeStateMachine$1$2$5 extends SuspendLambda implements Function3<TribeeHomeStateAction.ToExitTribee, State<TribeeHomeContentState>, Continuation<? super ChangedState<? extends TribeeHomeState>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TribeeHomeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomeStateMachine$1$2$5(TribeeHomeStateMachine tribeeHomeStateMachine, Continuation<? super TribeeHomeStateMachine$1$2$5> continuation) {
        super(3, continuation);
        this.this$0 = tribeeHomeStateMachine;
    }

    public final Object invoke(TribeeHomeStateAction.ToExitTribee toExitTribee, State<TribeeHomeContentState> state, Continuation<? super ChangedState<? extends TribeeHomeState>> continuation) {
        TribeeHomeStateMachine$1$2$5 tribeeHomeStateMachine$1$2$5 = new TribeeHomeStateMachine$1$2$5(this.this$0, continuation);
        tribeeHomeStateMachine$1$2$5.L$0 = state;
        return tribeeHomeStateMachine$1$2$5.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object string;
        String resultTips;
        final Exception e;
        TribeeHomeDataService tribeeHomeDataService;
        final String resultTips2;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KTribeeBaseInfo baseInfo = ((TribeeHomeContentState) state.getSnapshot()).getBaseInfo();
                if (baseInfo != null && baseInfo.isJoined()) {
                    this.L$0 = state;
                    this.label = 1;
                    string = StringResourcesKt.getString(String0_commonMainKt.getTribee_exit_successful(Res.string.INSTANCE), (Continuation) this);
                    if (string == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    resultTips = (String) string;
                    try {
                        tribeeHomeDataService = this.this$0.dataService;
                        this.L$0 = state;
                        this.L$1 = resultTips;
                        this.label = 2;
                        if (tribeeHomeDataService.join(false, (Continuation) this) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        resultTips2 = resultTips;
                        return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$5$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                TribeeHomeContentState invokeSuspend$lambda$0;
                                invokeSuspend$lambda$0 = TribeeHomeStateMachine$1$2$5.invokeSuspend$lambda$0(resultTips2, (TribeeHomeContentState) obj);
                                return invokeSuspend$lambda$0;
                            }
                        });
                    } catch (Exception e2) {
                        e = e2;
                        KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "exit tribee error! (" + e.getMessage() + ")");
                        return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$5$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                TribeeHomeContentState invokeSuspend$lambda$1;
                                invokeSuspend$lambda$1 = TribeeHomeStateMachine$1$2$5.invokeSuspend$lambda$1(e, (TribeeHomeContentState) obj);
                                return invokeSuspend$lambda$1;
                            }
                        });
                    }
                }
                return state.noChange();
            case 1:
                ResultKt.throwOnFailure($result);
                string = $result;
                resultTips = (String) string;
                tribeeHomeDataService = this.this$0.dataService;
                this.L$0 = state;
                this.L$1 = resultTips;
                this.label = 2;
                if (tribeeHomeDataService.join(false, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                resultTips2 = (String) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$5$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            TribeeHomeContentState invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = TribeeHomeStateMachine$1$2$5.invokeSuspend$lambda$0(resultTips2, (TribeeHomeContentState) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                } catch (Exception e3) {
                    e = e3;
                    KLog_androidKt.getKLog().e("TribeeHomeStateMachine", "exit tribee error! (" + e.getMessage() + ")");
                    return state.mutate(new Function1() { // from class: kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine$1$2$5$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            TribeeHomeContentState invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = TribeeHomeStateMachine$1$2$5.invokeSuspend$lambda$1(e, (TribeeHomeContentState) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$0(String $resultTips, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        KTribeeBaseInfo baseInfo = $this$mutate.getBaseInfo();
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : baseInfo != null ? KTribeeBaseInfo.copy$default(baseInfo, (KTribeeDesc) null, false, false, false, (String) null, (KTribeeSearchBar) null, 61, (Object) null) : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : null, (r20 & 128) != 0 ? $this$mutate.uiAction : new TribeeHomeUIAction.ToastTips(TribeeToast.Companion.create($resultTips)));
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeHomeContentState invokeSuspend$lambda$1(Exception $e, TribeeHomeContentState $this$mutate) {
        TribeeHomeContentState copy;
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.baseInfo : null, (r20 & 2) != 0 ? $this$mutate.interaction : null, (r20 & 4) != 0 ? $this$mutate.navigation : null, (r20 & 8) != 0 ? $this$mutate.categoryList : null, (r20 & 16) != 0 ? $this$mutate.categoryId : 0L, (r20 & 32) != 0 ? $this$mutate.fetchModel : null, (r20 & 64) != 0 ? $this$mutate.observedRequestingActions : null, (r20 & 128) != 0 ? $this$mutate.uiAction : new TribeeHomeUIAction.ToastTips(TribeeToast.Companion.create$default(TribeeToast.Companion, $e, null, 2, null)));
        return copy;
    }
}