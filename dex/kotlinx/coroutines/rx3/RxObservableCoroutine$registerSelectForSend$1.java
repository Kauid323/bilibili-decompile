package kotlinx.coroutines.rx3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import org.webrtc.H265Utils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxObservable.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx3.RxObservableCoroutine$registerSelectForSend$1", f = "RxObservable.kt", i = {}, l = {H265Utils.kLevel3_1}, m = "invokeSuspend", n = {}, s = {})
public final class RxObservableCoroutine$registerSelectForSend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SelectInstance<?> $select;
    int label;
    final /* synthetic */ RxObservableCoroutine<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxObservableCoroutine$registerSelectForSend$1(RxObservableCoroutine<T> rxObservableCoroutine, SelectInstance<?> selectInstance, Continuation<? super RxObservableCoroutine$registerSelectForSend$1> continuation) {
        super(2, continuation);
        this.this$0 = rxObservableCoroutine;
        this.$select = selectInstance;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RxObservableCoroutine$registerSelectForSend$1(this.this$0, this.$select, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RxObservableCoroutine$registerSelectForSend$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Mutex mutex;
        RxObservableCoroutine$registerSelectForSend$1 rxObservableCoroutine$registerSelectForSend$1;
        Mutex mutex2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                mutex = ((RxObservableCoroutine) this.this$0).mutex;
                this.label = 1;
                if (Mutex.DefaultImpls.lock$default(mutex, null, this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                rxObservableCoroutine$registerSelectForSend$1 = this;
                break;
            case 1:
                rxObservableCoroutine$registerSelectForSend$1 = this;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!rxObservableCoroutine$registerSelectForSend$1.$select.trySelect(rxObservableCoroutine$registerSelectForSend$1.this$0, Unit.INSTANCE)) {
            mutex2 = ((RxObservableCoroutine) rxObservableCoroutine$registerSelectForSend$1.this$0).mutex;
            Mutex.DefaultImpls.unlock$default(mutex2, null, 1, null);
        }
        return Unit.INSTANCE;
    }
}