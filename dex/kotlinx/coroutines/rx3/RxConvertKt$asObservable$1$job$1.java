package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.ObservableEmitter;
import java.util.concurrent.CancellationException;
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
/* compiled from: RxConvert.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx3.RxConvertKt$asObservable$1$job$1", f = "RxConvert.kt", i = {0}, l = {114}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class RxConvertKt$asObservable$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObservableEmitter<T> $emitter;
    final /* synthetic */ Flow<T> $this_asObservable;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RxConvertKt$asObservable$1$job$1(Flow<? extends T> flow, ObservableEmitter<T> observableEmitter, Continuation<? super RxConvertKt$asObservable$1$job$1> continuation) {
        super(2, continuation);
        this.$this_asObservable = flow;
        this.$emitter = observableEmitter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RxConvertKt$asObservable$1$job$1 rxConvertKt$asObservable$1$job$1 = new RxConvertKt$asObservable$1$job$1(this.$this_asObservable, this.$emitter, continuation);
        rxConvertKt$asObservable$1$job$1.L$0 = obj;
        return rxConvertKt$asObservable$1$job$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RxConvertKt$asObservable$1$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Throwable e;
        RxConvertKt$asObservable$1$job$1 rxConvertKt$asObservable$1$job$1;
        CoroutineScope $this$launch;
        Flow<T> flow;
        final ObservableEmitter<T> observableEmitter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope $this$launch2 = (CoroutineScope) this.L$0;
                try {
                    flow = this.$this_asObservable;
                    observableEmitter = this.$emitter;
                    this.L$0 = $this$launch2;
                    this.label = 1;
                } catch (Throwable th) {
                    e = th;
                    rxConvertKt$asObservable$1$job$1 = this;
                    $this$launch = $this$launch2;
                    if (e instanceof CancellationException) {
                        if (!rxConvertKt$asObservable$1$job$1.$emitter.tryOnError(e)) {
                            RxCancellableKt.handleUndeliverableException(e, $this$launch.getCoroutineContext());
                        }
                    } else {
                        rxConvertKt$asObservable$1$job$1.$emitter.onComplete();
                    }
                    return Unit.INSTANCE;
                }
                if (flow.collect(new FlowCollector() { // from class: kotlinx.coroutines.rx3.RxConvertKt$asObservable$1$job$1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(T t, Continuation<? super Unit> continuation) {
                        observableEmitter.onNext(t);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                rxConvertKt$asObservable$1$job$1 = this;
                $this$launch = $this$launch2;
                rxConvertKt$asObservable$1$job$1.$emitter.onComplete();
                return Unit.INSTANCE;
            case 1:
                rxConvertKt$asObservable$1$job$1 = this;
                $this$launch = (CoroutineScope) rxConvertKt$asObservable$1$job$1.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    rxConvertKt$asObservable$1$job$1.$emitter.onComplete();
                } catch (Throwable th2) {
                    e = th2;
                    if (e instanceof CancellationException) {
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}