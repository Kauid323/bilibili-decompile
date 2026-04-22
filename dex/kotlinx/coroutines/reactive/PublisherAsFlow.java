package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;
import org.reactivestreams.Publisher;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReactiveFlow.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B1\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001c\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096@¢\u0006\u0002\u0010\u0017J$\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0082@¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0082@¢\u0006\u0002\u0010\u0017J\u001c\u0010\u001c\u001a\u00020\u00142\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0094@¢\u0006\u0002\u0010\u001fJ&\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lkotlinx/coroutines/reactive/PublisherAsFlow;", "T", "", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "publisher", "Lorg/reactivestreams/Publisher;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lorg/reactivestreams/Publisher;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "requestSize", "", "getRequestSize$annotations", "()V", "getRequestSize", "()J", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectImpl", "injectContext", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSlowPath", "collectTo", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PublisherAsFlow<T> extends ChannelFlow<T> {
    private final Publisher<T> publisher;

    private static /* synthetic */ void getRequestSize$annotations() {
    }

    public /* synthetic */ PublisherAsFlow(Publisher publisher, EmptyCoroutineContext emptyCoroutineContext, int i, BufferOverflow bufferOverflow, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(publisher, (i2 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : emptyCoroutineContext, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    public PublisherAsFlow(Publisher<T> publisher, CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        super(context, capacity, onBufferOverflow);
        this.publisher = publisher;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow<T> create(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return new PublisherAsFlow(this.publisher, context, capacity, onBufferOverflow);
    }

    private final long getRequestSize() {
        if (this.onBufferOverflow != BufferOverflow.SUSPEND) {
            return LongCompanionObject.MAX_VALUE;
        }
        switch (this.capacity) {
            case -2:
                return Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core();
            case 0:
                return 1L;
            case Integer.MAX_VALUE:
                return LongCompanionObject.MAX_VALUE;
            default:
                long it = this.capacity;
                if (it >= 1) {
                    return it;
                }
                throw new IllegalStateException("Check failed.".toString());
        }
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        CoroutineContext collectContext = continuation.getContext();
        ContinuationInterceptor newDispatcher = (ContinuationInterceptor) this.context.get(ContinuationInterceptor.Key);
        if (newDispatcher == null || Intrinsics.areEqual(newDispatcher, collectContext.get(ContinuationInterceptor.Key))) {
            Object collectImpl = collectImpl(collectContext.plus(this.context), flowCollector, continuation);
            return collectImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectImpl : Unit.INSTANCE;
        }
        Object collectSlowPath = collectSlowPath(flowCollector, continuation);
        return collectSlowPath == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectSlowPath : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object collectSlowPath(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PublisherAsFlow$collectSlowPath$2(flowCollector, this, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ca A[Catch: all -> 0x0057, TRY_LEAVE, TryCatch #0 {all -> 0x0057, blocks: (B:13:0x003b, B:34:0x00c2, B:36:0x00ca, B:22:0x007d, B:16:0x004e), top: B:43:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [kotlinx.coroutines.reactive.ReactiveSubscriber] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00ba -> B:33:0x00bf). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collectImpl(CoroutineContext injectContext, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        PublisherAsFlow$collectImpl$1 publisherAsFlow$collectImpl$1;
        ReactiveSubscriber subscriber;
        long consumed;
        PublisherAsFlow publisherAsFlow;
        FlowCollector<? super T> flowCollector2;
        ReactiveSubscriber subscriber2;
        Object obj;
        Object $result;
        FlowCollector<? super T> flowCollector3;
        PublisherAsFlow publisherAsFlow2;
        Object takeNextOrNull;
        long consumed2;
        try {
            if (continuation instanceof PublisherAsFlow$collectImpl$1) {
                publisherAsFlow$collectImpl$1 = (PublisherAsFlow$collectImpl$1) continuation;
                if ((publisherAsFlow$collectImpl$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                    publisherAsFlow$collectImpl$1.label -= IntCompanionObject.MIN_VALUE;
                    PublisherAsFlow$collectImpl$1 publisherAsFlow$collectImpl$12 = publisherAsFlow$collectImpl$1;
                    Object $result2 = publisherAsFlow$collectImpl$12.result;
                    Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    subscriber = publisherAsFlow$collectImpl$12.label;
                    switch (subscriber) {
                        case 0:
                            ResultKt.throwOnFailure($result2);
                            ReactiveSubscriber subscriber3 = new ReactiveSubscriber(this.capacity, this.onBufferOverflow, getRequestSize());
                            ReactiveFlowKt.injectCoroutineContext(this.publisher, injectContext).subscribe(subscriber3);
                            long consumed3 = 0;
                            PublisherAsFlow publisherAsFlow3 = this;
                            ReactiveSubscriber subscriber4 = subscriber3;
                            publisherAsFlow$collectImpl$12.L$0 = publisherAsFlow3;
                            publisherAsFlow$collectImpl$12.L$1 = flowCollector;
                            publisherAsFlow$collectImpl$12.L$2 = subscriber4;
                            publisherAsFlow$collectImpl$12.J$0 = consumed3;
                            publisherAsFlow$collectImpl$12.label = 1;
                            takeNextOrNull = subscriber4.takeNextOrNull(publisherAsFlow$collectImpl$12);
                            if (takeNextOrNull == $result3) {
                                return $result3;
                            }
                            long j = consumed3;
                            publisherAsFlow = publisherAsFlow3;
                            flowCollector2 = flowCollector;
                            consumed = j;
                            Object obj2 = $result3;
                            $result = $result2;
                            $result2 = takeNextOrNull;
                            subscriber2 = subscriber4;
                            obj = obj2;
                            if ($result2 != null) {
                                subscriber2.cancel();
                                return Unit.INSTANCE;
                            }
                            try {
                                JobKt.ensureActive(publisherAsFlow$collectImpl$12.getContext());
                                publisherAsFlow$collectImpl$12.L$0 = publisherAsFlow;
                                publisherAsFlow$collectImpl$12.L$1 = flowCollector2;
                                publisherAsFlow$collectImpl$12.L$2 = subscriber2;
                                publisherAsFlow$collectImpl$12.J$0 = consumed;
                                publisherAsFlow$collectImpl$12.label = 2;
                                if (flowCollector2.emit($result2, publisherAsFlow$collectImpl$12) == obj) {
                                    return obj;
                                }
                                $result2 = $result;
                                $result3 = obj;
                                subscriber = subscriber2;
                                flowCollector3 = flowCollector2;
                                publisherAsFlow2 = publisherAsFlow;
                                consumed2 = consumed + 1;
                                if (consumed2 != publisherAsFlow2.getRequestSize()) {
                                    subscriber.makeRequest();
                                    flowCollector = flowCollector3;
                                    publisherAsFlow3 = publisherAsFlow2;
                                    consumed3 = 0;
                                    subscriber4 = subscriber;
                                } else {
                                    flowCollector = flowCollector3;
                                    publisherAsFlow3 = publisherAsFlow2;
                                    consumed3 = consumed2;
                                    subscriber4 = subscriber;
                                }
                                publisherAsFlow$collectImpl$12.L$0 = publisherAsFlow3;
                                publisherAsFlow$collectImpl$12.L$1 = flowCollector;
                                publisherAsFlow$collectImpl$12.L$2 = subscriber4;
                                publisherAsFlow$collectImpl$12.J$0 = consumed3;
                                publisherAsFlow$collectImpl$12.label = 1;
                                takeNextOrNull = subscriber4.takeNextOrNull(publisherAsFlow$collectImpl$12);
                                if (takeNextOrNull == $result3) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                subscriber = subscriber2;
                                subscriber.cancel();
                                throw th;
                            }
                        case 1:
                            consumed = publisherAsFlow$collectImpl$12.J$0;
                            ReactiveSubscriber subscriber5 = (ReactiveSubscriber) publisherAsFlow$collectImpl$12.L$2;
                            FlowCollector<? super T> flowCollector4 = (FlowCollector) publisherAsFlow$collectImpl$12.L$1;
                            PublisherAsFlow publisherAsFlow4 = (PublisherAsFlow) publisherAsFlow$collectImpl$12.L$0;
                            ResultKt.throwOnFailure($result2);
                            publisherAsFlow = publisherAsFlow4;
                            flowCollector2 = flowCollector4;
                            subscriber2 = subscriber5;
                            obj = $result3;
                            $result = $result2;
                            if ($result2 != null) {
                            }
                            break;
                        case 2:
                            consumed = publisherAsFlow$collectImpl$12.J$0;
                            ReactiveSubscriber reactiveSubscriber = (ReactiveSubscriber) publisherAsFlow$collectImpl$12.L$2;
                            flowCollector3 = (FlowCollector) publisherAsFlow$collectImpl$12.L$1;
                            publisherAsFlow2 = (PublisherAsFlow) publisherAsFlow$collectImpl$12.L$0;
                            ResultKt.throwOnFailure($result2);
                            subscriber = reactiveSubscriber;
                            consumed2 = consumed + 1;
                            if (consumed2 != publisherAsFlow2.getRequestSize()) {
                            }
                            publisherAsFlow$collectImpl$12.L$0 = publisherAsFlow3;
                            publisherAsFlow$collectImpl$12.L$1 = flowCollector;
                            publisherAsFlow$collectImpl$12.L$2 = subscriber4;
                            publisherAsFlow$collectImpl$12.J$0 = consumed3;
                            publisherAsFlow$collectImpl$12.label = 1;
                            takeNextOrNull = subscriber4.takeNextOrNull(publisherAsFlow$collectImpl$12);
                            if (takeNextOrNull == $result3) {
                            }
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (subscriber) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        publisherAsFlow$collectImpl$1 = new PublisherAsFlow$collectImpl$1(this, continuation);
        PublisherAsFlow$collectImpl$1 publisherAsFlow$collectImpl$122 = publisherAsFlow$collectImpl$1;
        Object $result22 = publisherAsFlow$collectImpl$122.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        subscriber = publisherAsFlow$collectImpl$122.label;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        Object collectImpl = collectImpl(producerScope.getCoroutineContext(), new SendingCollector(producerScope.getChannel()), continuation);
        return collectImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectImpl : Unit.INSTANCE;
    }
}