package kntr.base.mod.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.mod.internal.KModImpl;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KModImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.mod.internal.KModImpl$JobManager$DownloadAndInstallFlowHolder$job$1", f = "KModImpl.kt", i = {0}, l = {586}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class KModImpl$JobManager$DownloadAndInstallFlowHolder$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ KModImpl.JobManager.DownloadAndInstallFlowHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KModImpl$JobManager$DownloadAndInstallFlowHolder$job$1(KModImpl.JobManager.DownloadAndInstallFlowHolder downloadAndInstallFlowHolder, Continuation<? super KModImpl$JobManager$DownloadAndInstallFlowHolder$job$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadAndInstallFlowHolder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KModImpl$JobManager$DownloadAndInstallFlowHolder$job$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final Ref.IntRef state = new Ref.IntRef();
                mutableStateFlow = this.this$0.stateFlow;
                StateFlow subscriptionCount = mutableStateFlow.getSubscriptionCount();
                final KModImpl.JobManager.DownloadAndInstallFlowHolder downloadAndInstallFlowHolder = this.this$0;
                this.L$0 = SpillingKt.nullOutSpilledVariable(state);
                this.label = 1;
                if (subscriptionCount.collect(new FlowCollector() { // from class: kntr.base.mod.internal.KModImpl$JobManager$DownloadAndInstallFlowHolder$job$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit(((Number) value).intValue(), $completion);
                    }

                    public final Object emit(int it, Continuation<? super Unit> continuation) {
                        if (state.element == 0 && it > 0) {
                            state.element = 1;
                            downloadAndInstallFlowHolder.onStart();
                        } else if (state.element == 1 && it == 0) {
                            state.element = 2;
                            downloadAndInstallFlowHolder.onStop();
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                Ref.IntRef intRef = (Ref.IntRef) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}