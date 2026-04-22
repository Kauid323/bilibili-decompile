package kotlinx.coroutines.stream;

import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Stream.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0096@¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\u000b\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/stream/StreamFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "j$/util/stream/Stream", "stream", "<init>", "(Lj$/util/stream/Stream;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lj$/util/stream/Stream;", "Lkotlinx/atomicfu/AtomicBoolean;", "consumed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StreamFlow<T> implements Flow<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater consumed$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed$volatile");
    private volatile /* synthetic */ int consumed$volatile = 0;
    private final Stream<T> stream;

    private final /* synthetic */ int getConsumed$volatile() {
        return this.consumed$volatile;
    }

    private final /* synthetic */ void setConsumed$volatile(int i) {
        this.consumed$volatile = i;
    }

    public StreamFlow(Stream<T> stream) {
        this.stream = stream;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d A[Catch: all -> 0x007a, TRY_LEAVE, TryCatch #0 {all -> 0x007a, blocks: (B:13:0x003a, B:18:0x0057, B:20:0x005d, B:17:0x004e), top: B:31:0x0023 }] */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        StreamFlow$collect$1 streamFlow$collect$1;
        StreamFlow$collect$1 streamFlow$collect$12;
        StreamFlow<T> streamFlow;
        FlowCollector collector;
        Iterator it;
        try {
            if (continuation instanceof StreamFlow$collect$1) {
                streamFlow$collect$1 = (StreamFlow$collect$1) continuation;
                if ((streamFlow$collect$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                    streamFlow$collect$1.label -= IntCompanionObject.MIN_VALUE;
                    streamFlow$collect$12 = streamFlow$collect$1;
                    Object $result = streamFlow$collect$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (streamFlow$collect$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            streamFlow = this;
                            if (!consumed$volatile$FU.compareAndSet(streamFlow, 0, 1)) {
                                throw new IllegalStateException("Stream.consumeAsFlow can be collected only once".toString());
                            }
                            collector = flowCollector;
                            it = streamFlow.stream.iterator();
                            break;
                        case 1:
                            it = (Iterator) streamFlow$collect$12.L$2;
                            collector = (FlowCollector) streamFlow$collect$12.L$1;
                            streamFlow = (StreamFlow) streamFlow$collect$12.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    while (it.hasNext()) {
                        Object value = (Object) it.next();
                        streamFlow$collect$12.L$0 = streamFlow;
                        streamFlow$collect$12.L$1 = collector;
                        streamFlow$collect$12.L$2 = it;
                        streamFlow$collect$12.label = 1;
                        if (collector.emit(value, streamFlow$collect$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    streamFlow.stream.close();
                    return Unit.INSTANCE;
                }
            }
            switch (streamFlow$collect$12.label) {
            }
            while (it.hasNext()) {
            }
            streamFlow.stream.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            streamFlow.stream.close();
            throw th;
        }
        streamFlow$collect$1 = new StreamFlow$collect$1(this, continuation);
        streamFlow$collect$12 = streamFlow$collect$1;
        Object $result2 = streamFlow$collect$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}