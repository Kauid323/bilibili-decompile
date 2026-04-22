package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: ReactiveFlow.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0015\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u0004\u0018\u00018\u0000H\u0086@¢\u0006\u0002\u0010\u001cR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/reactive/ReactiveSubscriber;", "T", "", "Lorg/reactivestreams/Subscriber;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "requestSize", "", "(ILkotlinx/coroutines/channels/BufferOverflow;J)V", "channel", "Lkotlinx/coroutines/channels/Channel;", "subscription", "Lorg/reactivestreams/Subscription;", "cancel", "", "makeRequest", "onComplete", "onError", "t", "", "onNext", "value", "(Ljava/lang/Object;)V", "onSubscribe", "s", "takeNextOrNull", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ReactiveSubscriber<T> implements Subscriber<T> {
    private final Channel<T> channel;
    private final long requestSize;
    private Subscription subscription;

    public ReactiveSubscriber(int capacity, BufferOverflow onBufferOverflow, long requestSize) {
        this.requestSize = requestSize;
        this.channel = kotlinx.coroutines.channels.ChannelKt.Channel$default(capacity == 0 ? 1 : capacity, onBufferOverflow, null, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object takeNextOrNull(Continuation<? super T> continuation) {
        ReactiveSubscriber$takeNextOrNull$1 reactiveSubscriber$takeNextOrNull$1;
        ReactiveSubscriber$takeNextOrNull$1 reactiveSubscriber$takeNextOrNull$12;
        Object result;
        Throwable it;
        if (continuation instanceof ReactiveSubscriber$takeNextOrNull$1) {
            reactiveSubscriber$takeNextOrNull$1 = (ReactiveSubscriber$takeNextOrNull$1) continuation;
            if ((reactiveSubscriber$takeNextOrNull$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                reactiveSubscriber$takeNextOrNull$1.label -= IntCompanionObject.MIN_VALUE;
                reactiveSubscriber$takeNextOrNull$12 = reactiveSubscriber$takeNextOrNull$1;
                Object $result = reactiveSubscriber$takeNextOrNull$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (reactiveSubscriber$takeNextOrNull$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Channel<T> channel = this.channel;
                        reactiveSubscriber$takeNextOrNull$12.label = 1;
                        Object obj = channel.mo1403receiveCatchingJP2dKIU(reactiveSubscriber$takeNextOrNull$12);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        result = obj;
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        result = ((ChannelResult) $result).m1422unboximpl();
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = ChannelResult.m1414exceptionOrNullimpl(result);
                if (it == null) {
                    throw it;
                }
                if (!(result instanceof ChannelResult.Failed)) {
                    return result;
                }
                ChannelResult.m1414exceptionOrNullimpl(result);
                return null;
            }
        }
        reactiveSubscriber$takeNextOrNull$1 = new ReactiveSubscriber$takeNextOrNull$1(this, continuation);
        reactiveSubscriber$takeNextOrNull$12 = reactiveSubscriber$takeNextOrNull$1;
        Object $result2 = reactiveSubscriber$takeNextOrNull$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (reactiveSubscriber$takeNextOrNull$12.label) {
        }
        it = ChannelResult.m1414exceptionOrNullimpl(result);
        if (it == null) {
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (!ChannelResult.m1420isSuccessimpl(this.channel.mo1399trySendJP2dKIU(t))) {
            throw new IllegalArgumentException(("Element " + t + " was not added to channel because it was full, " + this.channel).toString());
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        SendChannel.DefaultImpls.close$default(this.channel, null, 1, null);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable t) {
        this.channel.close(t);
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription s) {
        this.subscription = s;
        makeRequest();
    }

    public final void makeRequest() {
        Subscription subscription = this.subscription;
        if (subscription == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscription");
            subscription = null;
        }
        subscription.request(this.requestSize);
    }

    public final void cancel() {
        Subscription subscription = this.subscription;
        if (subscription == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscription");
            subscription = null;
        }
        subscription.cancel();
    }
}