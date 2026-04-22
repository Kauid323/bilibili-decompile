package kntr.base.mod.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.mod.ModEvent;
import kntr.base.mod.internal.KModImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KModImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.mod.internal.KModImpl$JobManager$DownloadAndInstallFlowHolder$onStart$1", f = "KModImpl.kt", i = {}, l = {601}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class KModImpl$JobManager$DownloadAndInstallFlowHolder$onStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ KModImpl.JobManager.DownloadAndInstallFlowHolder this$0;
    final /* synthetic */ KModImpl this$1;
    final /* synthetic */ KModImpl.JobManager this$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KModImpl$JobManager$DownloadAndInstallFlowHolder$onStart$1(KModImpl.JobManager.DownloadAndInstallFlowHolder downloadAndInstallFlowHolder, KModImpl kModImpl, KModImpl.JobManager jobManager, Continuation<? super KModImpl$JobManager$DownloadAndInstallFlowHolder$onStart$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadAndInstallFlowHolder;
        this.this$1 = kModImpl;
        this.this$2 = jobManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KModImpl$JobManager$DownloadAndInstallFlowHolder$onStart$1(this.this$0, this.this$1, this.this$2, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow<ModEvent.FetchEvent> realFlow = this.this$0.getRealFlow();
                    final KModImpl.JobManager.DownloadAndInstallFlowHolder downloadAndInstallFlowHolder = this.this$0;
                    final KModImpl kModImpl = this.this$1;
                    final KModImpl.JobManager jobManager = this.this$2;
                    this.label = 1;
                    if (realFlow.collect(new FlowCollector() { // from class: kntr.base.mod.internal.KModImpl$JobManager$DownloadAndInstallFlowHolder$onStart$1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((ModEvent.FetchEvent) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(ModEvent.FetchEvent it, Continuation<? super Unit> continuation) {
                            MutableStateFlow mutableStateFlow;
                            boolean isTerminal;
                            mutableStateFlow = KModImpl.JobManager.DownloadAndInstallFlowHolder.this.stateFlow;
                            mutableStateFlow.setValue(it);
                            isTerminal = kModImpl.isTerminal(it);
                            if (isTerminal) {
                                jobManager.getEventFlow().tryEmit(it);
                            }
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } finally {
            if (z) {
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}