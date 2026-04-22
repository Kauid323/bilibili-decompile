package kotlinx.coroutines.rx3;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: RxConvert.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx3.RxConvertKt$asFlow$1", f = "RxConvert.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
final class RxConvertKt$asFlow$1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObservableSource<T> $this_asFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxConvertKt$asFlow$1(ObservableSource<T> observableSource, Continuation<? super RxConvertKt$asFlow$1> continuation) {
        super(2, continuation);
        this.$this_asFlow = observableSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RxConvertKt$asFlow$1 rxConvertKt$asFlow$1 = new RxConvertKt$asFlow$1(this.$this_asFlow, continuation);
        rxConvertKt$asFlow$1.L$0 = obj;
        return rxConvertKt$asFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return ((RxConvertKt$asFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final ProducerScope $this$callbackFlow = (ProducerScope) this.L$0;
                final AtomicReference disposableRef = new AtomicReference();
                this.$this_asFlow.subscribe(new Observer<T>() { // from class: kotlinx.coroutines.rx3.RxConvertKt$asFlow$1$observer$1
                    public void onComplete() {
                        SendChannel.DefaultImpls.close$default($this$callbackFlow, null, 1, null);
                    }

                    public void onSubscribe(Disposable d) {
                        if (MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(disposableRef, (Object) null, d)) {
                            return;
                        }
                        d.dispose();
                    }

                    public void onNext(T t) {
                        try {
                            ChannelsKt.trySendBlocking($this$callbackFlow, t);
                        } catch (InterruptedException e) {
                        }
                    }

                    public void onError(Throwable e) {
                        $this$callbackFlow.close(e);
                    }
                });
                this.label = 1;
                if (ProduceKt.awaitClose($this$callbackFlow, new Function0<Unit>() { // from class: kotlinx.coroutines.rx3.RxConvertKt$asFlow$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Disposable andSet = disposableRef.getAndSet(Disposable.-CC.disposed());
                        if (andSet != null) {
                            andSet.dispose();
                        }
                    }
                }, this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}