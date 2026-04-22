package kotlinx.coroutines.reactive;

import java.util.Collection;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import org.reactivestreams.Publisher;

/* compiled from: ReactiveFlow.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b\u001a,\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\b\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u001a&\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\b\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\r\u001a\u00020\u000bH\u0000\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003¨\u0006\u000e"}, d2 = {"contextInjectors", "", "Lkotlinx/coroutines/reactive/ContextInjector;", "[Lkotlinx/coroutines/reactive/ContextInjector;", "asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "", "Lorg/reactivestreams/Publisher;", "asPublisher", "context", "Lkotlin/coroutines/CoroutineContext;", "injectCoroutineContext", "coroutineContext", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ReactiveFlowKt {
    private static final ContextInjector[] contextInjectors;

    public static final <T> Publisher<T> asPublisher(Flow<? extends T> flow) {
        return asPublisher$default(flow, null, 1, null);
    }

    public static final <T> Flow<T> asFlow(Publisher<T> publisher) {
        return new PublisherAsFlow(publisher, null, 0, null, 14, null);
    }

    public static /* synthetic */ Publisher asPublisher$default(Flow flow, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asPublisher(flow, coroutineContext);
    }

    public static final <T> Publisher<T> asPublisher(Flow<? extends T> flow, CoroutineContext context) {
        return new FlowAsPublisher(flow, Dispatchers.getUnconfined().plus(context));
    }

    static {
        Collection $this$toTypedArray$iv = SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(ContextInjector.class, ContextInjector.class.getClassLoader()).iterator()));
        contextInjectors = (ContextInjector[]) $this$toTypedArray$iv.toArray(new ContextInjector[0]);
    }

    public static final <T> Publisher<T> injectCoroutineContext(Publisher<T> publisher, CoroutineContext coroutineContext) {
        Publisher publisher2 = publisher;
        for (ContextInjector contextInjector : contextInjectors) {
            Publisher pub = publisher2;
            publisher2 = contextInjector.injectCoroutineContext(pub, coroutineContext);
        }
        return publisher2;
    }
}