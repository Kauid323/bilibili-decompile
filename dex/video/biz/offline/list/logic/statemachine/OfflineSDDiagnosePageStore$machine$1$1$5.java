package video.biz.offline.list.logic.statemachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.statemachine.OfflineSDDiagnosePageEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineSDDiagnosePageStore.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnosePageState;", "<unused var>", "Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnosePageEvent$TriggerTest;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineSDDiagnosePageStore$machine$1$1$5", f = "OfflineSDDiagnosePageStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineSDDiagnosePageStore$machine$1$1$5 extends SuspendLambda implements Function3<OfflineSDDiagnosePageEvent.TriggerTest, State<OfflineSDDiagnosePageState>, Continuation<? super ChangedState<? extends OfflineSDDiagnosePageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineSDDiagnosePageStore$machine$1$1$5(Continuation<? super OfflineSDDiagnosePageStore$machine$1$1$5> continuation) {
        super(3, continuation);
    }

    public final Object invoke(OfflineSDDiagnosePageEvent.TriggerTest triggerTest, State<OfflineSDDiagnosePageState> state, Continuation<? super ChangedState<OfflineSDDiagnosePageState>> continuation) {
        OfflineSDDiagnosePageStore$machine$1$1$5 offlineSDDiagnosePageStore$machine$1$1$5 = new OfflineSDDiagnosePageStore$machine$1$1$5(continuation);
        offlineSDDiagnosePageStore$machine$1$1$5.L$0 = state;
        return offlineSDDiagnosePageStore$machine$1$1$5.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSDDiagnosePageStore$machine$1$1$5$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        OfflineSDDiagnosePageState invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = OfflineSDDiagnosePageStore$machine$1$1$5.invokeSuspend$lambda$0((OfflineSDDiagnosePageState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineSDDiagnosePageState invokeSuspend$lambda$0(OfflineSDDiagnosePageState $this$mutate) {
        return OfflineSDDiagnosePageState.copy$default($this$mutate, null, OfflineSDDiagnoseProcedure.WriteTest, null, 5, null);
    }
}