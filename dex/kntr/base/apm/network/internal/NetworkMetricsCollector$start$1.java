package kntr.base.apm.network.internal;

import java.util.concurrent.CancellationException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.apm.network.internal.NetworkMetricsCollector;
import kntr.base.neuron.IPlatformNeuron;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkMetricsCollector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.apm.network.internal.NetworkMetricsCollector$start$1", f = "NetworkMetricsCollector.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class NetworkMetricsCollector$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<NetworkMetricsCollector.Model, Unit> $handler;
    final /* synthetic */ IPlatformNeuron $neuron;
    int label;
    final /* synthetic */ NetworkMetricsCollector this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NetworkMetricsCollector$start$1(IPlatformNeuron iPlatformNeuron, NetworkMetricsCollector networkMetricsCollector, Function1<? super NetworkMetricsCollector.Model, Unit> function1, Continuation<? super NetworkMetricsCollector$start$1> continuation) {
        super(2, continuation);
        this.$neuron = iPlatformNeuron;
        this.this$0 = networkMetricsCollector;
        this.$handler = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NetworkMetricsCollector$start$1(this.$neuron, this.this$0, this.$handler, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow<IPlatformNeuron.Event> events = this.$neuron.events();
                    final NetworkMetricsCollector networkMetricsCollector = this.this$0;
                    final Function1<NetworkMetricsCollector.Model, Unit> function1 = this.$handler;
                    this.label = 1;
                    if (events.collect(new FlowCollector() { // from class: kntr.base.apm.network.internal.NetworkMetricsCollector$start$1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((IPlatformNeuron.Event) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(IPlatformNeuron.Event it, Continuation<? super Unit> continuation) {
                            NetworkMetricsCollector.Model m;
                            m = NetworkMetricsCollector.this.onEvent(it);
                            if (m != null) {
                                function1.invoke(m);
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
        } catch (Exception e) {
            if (!(e instanceof CancellationException)) {
                UtilsKt.logE("collector", "neuron events collect", e);
            }
        }
        return Unit.INSTANCE;
    }
}