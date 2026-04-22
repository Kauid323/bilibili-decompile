package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReactiveFlow.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.FlowSubscription", f = "ReactiveFlow.kt", i = {0}, l = {205}, m = "flowProcessing", n = {"this"}, s = {"L$0"})
public final class FlowSubscription$flowProcessing$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowSubscription<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowSubscription$flowProcessing$1(FlowSubscription<T> flowSubscription, Continuation<? super FlowSubscription$flowProcessing$1> continuation) {
        super(continuation);
        this.this$0 = flowSubscription;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object flowProcessing;
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        flowProcessing = this.this$0.flowProcessing(this);
        return flowProcessing;
    }
}