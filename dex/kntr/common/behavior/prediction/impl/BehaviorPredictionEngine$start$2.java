package kntr.common.behavior.prediction.impl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.IPlatformNeuron;
import kntr.base.neuron.KNeuron;
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

/* compiled from: BehaviorPredictionEngine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.behavior.prediction.impl.BehaviorPredictionEngine$start$2", f = "BehaviorPredictionEngine.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BehaviorPredictionEngine$start$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BehaviorPredictionEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BehaviorPredictionEngine$start$2(BehaviorPredictionEngine behaviorPredictionEngine, Continuation<? super BehaviorPredictionEngine$start$2> continuation) {
        super(2, continuation);
        this.this$0 = behaviorPredictionEngine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BehaviorPredictionEngine$start$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                UtilsKt.logI("Engine", "start observe neuron.");
                Flow<IPlatformNeuron.Event> events = KNeuron.INSTANCE.events();
                final BehaviorPredictionEngine behaviorPredictionEngine = this.this$0;
                this.label = 1;
                if (events.collect(new FlowCollector() { // from class: kntr.common.behavior.prediction.impl.BehaviorPredictionEngine$start$2.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((IPlatformNeuron.Event) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(IPlatformNeuron.Event event, Continuation<? super Unit> continuation) {
                        Object onEvent;
                        onEvent = BehaviorPredictionEngine.this.onEvent(event, continuation);
                        return onEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? onEvent : Unit.INSTANCE;
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
        return Unit.INSTANCE;
    }
}