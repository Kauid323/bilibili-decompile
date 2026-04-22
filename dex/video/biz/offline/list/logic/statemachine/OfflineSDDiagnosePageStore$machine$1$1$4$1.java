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
import kotlin.jvm.functions.Function2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.utils.OfflineStorageTestImpl_androidKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineSDDiagnosePageStore.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lvideo/biz/offline/list/logic/statemachine/OfflineSDDiagnosePageState;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.OfflineSDDiagnosePageStore$machine$1$1$4$1", f = "OfflineSDDiagnosePageStore.kt", i = {0}, l = {62}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class OfflineSDDiagnosePageStore$machine$1$1$4$1 extends SuspendLambda implements Function2<State<OfflineSDDiagnosePageState>, Continuation<? super ChangedState<? extends OfflineSDDiagnosePageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineSDDiagnosePageStore$machine$1$1$4$1(Continuation<? super OfflineSDDiagnosePageStore$machine$1$1$4$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> offlineSDDiagnosePageStore$machine$1$1$4$1 = new OfflineSDDiagnosePageStore$machine$1$1$4$1(continuation);
        offlineSDDiagnosePageStore$machine$1$1$4$1.L$0 = obj;
        return offlineSDDiagnosePageStore$machine$1$1$4$1;
    }

    public final Object invoke(State<OfflineSDDiagnosePageState> state, Continuation<? super ChangedState<OfflineSDDiagnosePageState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object testReadExternalSD;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = state;
                this.label = 1;
                testReadExternalSD = OfflineStorageTestImpl_androidKt.testReadExternalSD((Continuation) this);
                if (testReadExternalSD == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                testReadExternalSD = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean readResult = ((Boolean) testReadExternalSD).booleanValue();
        if (readResult) {
            return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSDDiagnosePageStore$machine$1$1$4$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    OfflineSDDiagnosePageState invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = OfflineSDDiagnosePageStore$machine$1$1$4$1.invokeSuspend$lambda$0((OfflineSDDiagnosePageState) obj);
                    return invokeSuspend$lambda$0;
                }
            });
        }
        return state.mutate(new Function1() { // from class: video.biz.offline.list.logic.statemachine.OfflineSDDiagnosePageStore$machine$1$1$4$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                OfflineSDDiagnosePageState invokeSuspend$lambda$1;
                invokeSuspend$lambda$1 = OfflineSDDiagnosePageStore$machine$1$1$4$1.invokeSuspend$lambda$1((OfflineSDDiagnosePageState) obj);
                return invokeSuspend$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineSDDiagnosePageState invokeSuspend$lambda$0(OfflineSDDiagnosePageState $this$mutate) {
        return OfflineSDDiagnosePageState.copy$default($this$mutate, null, OfflineSDDiagnoseProcedure.Finish, OfflineSDDiagnoseResult.SUCCESS, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineSDDiagnosePageState invokeSuspend$lambda$1(OfflineSDDiagnosePageState $this$mutate) {
        return OfflineSDDiagnosePageState.copy$default($this$mutate, null, OfflineSDDiagnoseProcedure.Finish, OfflineSDDiagnoseResult.READ_ERROR, 1, null);
    }
}