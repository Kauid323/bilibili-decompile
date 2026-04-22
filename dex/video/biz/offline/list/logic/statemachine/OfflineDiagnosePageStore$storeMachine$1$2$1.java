package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.statemachine.OfflineDiagnosePageEvent;
import video.biz.offline.list.logic.statemachine.OfflineDiagnoseState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineDiagnosePageStore.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnoseState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnoseState$Loading;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineDiagnosePageStore$storeMachine$1$2$1", f = "OfflineDiagnosePageStore.kt", i = {0, 0, 0}, l = {82}, m = "invokeSuspend", n = {"state", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-OfflineDiagnosePageStore$storeMachine$1$2$1$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
public final class OfflineDiagnosePageStore$storeMachine$1$2$1 extends SuspendLambda implements Function2<State<OfflineDiagnoseState.Loading>, Continuation<? super ChangedState<? extends OfflineDiagnoseState>>, Object> {
    final /* synthetic */ InStateBuilderBlock<OfflineDiagnoseState.Loading, OfflineDiagnoseState, OfflineDiagnosePageEvent> $this_inState;
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ OfflineDiagnosePageStore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineDiagnosePageStore$storeMachine$1$2$1(InStateBuilderBlock<OfflineDiagnoseState.Loading, OfflineDiagnoseState, OfflineDiagnosePageEvent> inStateBuilderBlock, OfflineDiagnosePageStore offlineDiagnosePageStore, Continuation<? super OfflineDiagnosePageStore$storeMachine$1$2$1> continuation) {
        super(2, continuation);
        this.$this_inState = inStateBuilderBlock;
        this.this$0 = offlineDiagnosePageStore;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> offlineDiagnosePageStore$storeMachine$1$2$1 = new OfflineDiagnosePageStore$storeMachine$1$2$1(this.$this_inState, this.this$0, continuation);
        offlineDiagnosePageStore$storeMachine$1$2$1.L$0 = obj;
        return offlineDiagnosePageStore$storeMachine$1$2$1;
    }

    public final Object invoke(State<OfflineDiagnoseState.Loading> state, Continuation<? super ChangedState<? extends OfflineDiagnoseState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        Object withContext;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    InStateBuilderBlock $this$invokeSuspend_u24lambda_u240 = this.$this_inState;
                    OfflineDiagnosePageStore offlineDiagnosePageStore = this.this$0;
                    Result.Companion companion = Result.Companion;
                    this.L$0 = state;
                    this.L$1 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u240);
                    this.I$0 = 0;
                    this.label = 1;
                    withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new OfflineDiagnosePageStore$storeMachine$1$2$1$1$1(offlineDiagnosePageStore, null), this);
                    if (withContext != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    int i = this.I$0;
                    InStateBuilderBlock inStateBuilderBlock = (InStateBuilderBlock) this.L$1;
                    ResultKt.throwOnFailure($result);
                    withContext = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = Result.constructor-impl((List) withContext);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        OfflineDiagnosePageStore offlineDiagnosePageStore2 = this.this$0;
        if (Result.isSuccess-impl(obj)) {
            List videos = (List) obj;
            offlineDiagnosePageStore2.dispatch(new OfflineDiagnosePageEvent.VideosLoaded(videos));
        }
        OfflineDiagnosePageStore offlineDiagnosePageStore3 = this.this$0;
        if (Result.exceptionOrNull-impl(obj) != null) {
            offlineDiagnosePageStore3.dispatch(OfflineDiagnosePageEvent.VideosLoadFailed.INSTANCE);
        }
        return state.noChange();
    }
}