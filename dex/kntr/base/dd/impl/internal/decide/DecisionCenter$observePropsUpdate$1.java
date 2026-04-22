package kntr.base.dd.impl.internal.decide;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.property.IPropertyCenter;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DecisionCenter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.impl.internal.decide.DecisionCenter$observePropsUpdate$1", f = "DecisionCenter.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DecisionCenter$observePropsUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DecisionCenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DecisionCenter$observePropsUpdate$1(DecisionCenter decisionCenter, Continuation<? super DecisionCenter$observePropsUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = decisionCenter;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DecisionCenter$observePropsUpdate$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IPropertyCenter iPropertyCenter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                iPropertyCenter = this.this$0.propertyCenter;
                Flow<String> cacheableProps = iPropertyCenter.getCacheableProps();
                final DecisionCenter decisionCenter = this.this$0;
                this.label = 1;
                if (cacheableProps.collect(new FlowCollector() { // from class: kntr.base.dd.impl.internal.decide.DecisionCenter$observePropsUpdate$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((String) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(String it, Continuation<? super Unit> continuation) {
                        DecisionCenter.this.didPropUpdated(it);
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
        return Unit.INSTANCE;
    }
}