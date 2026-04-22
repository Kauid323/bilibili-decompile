package kotlinx.coroutines.reactive;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: Publish.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aR\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052/\b\u0001\u0010\f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0003¢\u0006\u0002\b\u0010¢\u0006\u0002\u0010\u0011\u001ar\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00052\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00032-\u0010\f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0016\u001aX\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\u00020\u00142\b\b\u0002\u0010\u000b\u001a\u00020\u00052/\b\u0001\u0010\f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\" \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"CLOSED", "", "DEFAULT_HANDLER", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext;", "", "SIGNALLED", "publish", "Lorg/reactivestreams/Publisher;", "T", "context", "block", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lorg/reactivestreams/Publisher;", "publishInternal", "scope", "Lkotlinx/coroutines/CoroutineScope;", "exceptionOnCancelHandler", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lorg/reactivestreams/Publisher;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lorg/reactivestreams/Publisher;", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class PublishKt {
    private static final long CLOSED = -1;
    private static final Function2<Throwable, CoroutineContext, Unit> DEFAULT_HANDLER = new Function2<Throwable, CoroutineContext, Unit>() { // from class: kotlinx.coroutines.reactive.PublishKt$DEFAULT_HANDLER$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th, CoroutineContext coroutineContext) {
            invoke2(th, coroutineContext);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable t, CoroutineContext ctx) {
            if (t instanceof CancellationException) {
                return;
            }
            CoroutineExceptionHandlerKt.handleCoroutineException(ctx, t);
        }
    };
    private static final long SIGNALLED = -2;

    public static /* synthetic */ Publisher publish$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return publish(coroutineContext, function2);
    }

    public static final <T> Publisher<T> publish(CoroutineContext context, Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        if (!(context.get(Job.Key) == null)) {
            throw new IllegalArgumentException(("Publisher context cannot contain job in it.Its lifecycle should be managed via subscription. Had " + context).toString());
        }
        return publishInternal(GlobalScope.INSTANCE, context, DEFAULT_HANDLER, function2);
    }

    public static final <T> Publisher<T> publishInternal(final CoroutineScope scope, final CoroutineContext context, final Function2<? super Throwable, ? super CoroutineContext, Unit> function2, final Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function22) {
        return new Publisher() { // from class: kotlinx.coroutines.reactive.PublishKt$$ExternalSyntheticLambda0
            @Override // org.reactivestreams.Publisher
            public final void subscribe(Subscriber subscriber) {
                PublishKt.publishInternal$lambda$1(CoroutineScope.this, context, function2, function22, subscriber);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void publishInternal$lambda$1(CoroutineScope $scope, CoroutineContext $context, Function2 $exceptionOnCancelHandler, Function2 $block, Subscriber subscriber) {
        if (subscriber == null) {
            throw new NullPointerException("Subscriber cannot be null");
        }
        CoroutineContext newContext = CoroutineContextKt.newCoroutineContext($scope, $context);
        PublisherCoroutine coroutine = new PublisherCoroutine(newContext, subscriber, $exceptionOnCancelHandler);
        subscriber.onSubscribe(coroutine);
        coroutine.start(CoroutineStart.DEFAULT, coroutine, $block);
    }

    public static /* synthetic */ Publisher publish$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return publish(coroutineScope, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "CoroutineScope.publish is deprecated in favour of top-level publish", replaceWith = @ReplaceWith(expression = "publish(context, block)", imports = {}))
    public static final /* synthetic */ Publisher publish(CoroutineScope $this$publish, CoroutineContext context, Function2 block) {
        return publishInternal($this$publish, context, DEFAULT_HANDLER, block);
    }
}