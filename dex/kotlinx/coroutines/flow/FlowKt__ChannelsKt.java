package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Channels.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a,\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@¢\u0006\u0002\u0010\n\u001a6\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u000e\u0010\u000f\u001a$\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005¨\u0006\u0014"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/coroutines/channels/BroadcastChannel;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", "", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "receiveAsFlow", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
public final /* synthetic */ class FlowKt__ChannelsKt {
    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, Continuation<? super Unit> continuation) {
        Object emitAllImpl$FlowKt__ChannelsKt = emitAllImpl$FlowKt__ChannelsKt(flowCollector, receiveChannel, true, continuation);
        return emitAllImpl$FlowKt__ChannelsKt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emitAllImpl$FlowKt__ChannelsKt : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0090 A[Catch: all -> 0x00b7, TRY_LEAVE, TryCatch #1 {all -> 0x00b7, blocks: (B:80:0x0088, B:82:0x0090), top: B:103:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ae A[DONT_GENERATE] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x00a6 -> B:76:0x006d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object emitAllImpl$FlowKt__ChannelsKt(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, boolean consume, Continuation<? super Unit> continuation) {
        FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$1;
        ReceiveChannel channel;
        Throwable cause;
        ChannelIterator<? extends T> it;
        ChannelIterator<? extends T> channelIterator;
        Throwable cause2;
        FlowCollector $this$emitAllImpl;
        ReceiveChannel channel2;
        Object obj;
        Object $result;
        FlowCollector $this$emitAllImpl2;
        Object hasNext;
        try {
            if (continuation instanceof FlowKt__ChannelsKt$emitAllImpl$1) {
                flowKt__ChannelsKt$emitAllImpl$1 = (FlowKt__ChannelsKt$emitAllImpl$1) continuation;
                if ((flowKt__ChannelsKt$emitAllImpl$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                    flowKt__ChannelsKt$emitAllImpl$1.label -= IntCompanionObject.MIN_VALUE;
                    FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$12 = flowKt__ChannelsKt$emitAllImpl$1;
                    Object $result2 = flowKt__ChannelsKt$emitAllImpl$12.result;
                    Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    channel = flowKt__ChannelsKt$emitAllImpl$12.label;
                    switch (channel) {
                        case 0:
                            ResultKt.throwOnFailure($result2);
                            channel = receiveChannel;
                            FlowKt.ensureActive(flowCollector);
                            cause = null;
                            try {
                                it = channel.iterator();
                                channel = channel;
                                $this$emitAllImpl2 = flowCollector;
                                flowKt__ChannelsKt$emitAllImpl$12.L$0 = $this$emitAllImpl2;
                                flowKt__ChannelsKt$emitAllImpl$12.L$1 = channel;
                                flowKt__ChannelsKt$emitAllImpl$12.L$2 = it;
                                flowKt__ChannelsKt$emitAllImpl$12.Z$0 = consume;
                                flowKt__ChannelsKt$emitAllImpl$12.label = 1;
                                hasNext = it.hasNext(flowKt__ChannelsKt$emitAllImpl$12);
                                if (hasNext == $result3) {
                                    return $result3;
                                }
                                $this$emitAllImpl = $this$emitAllImpl2;
                                cause2 = cause;
                                channelIterator = it;
                                channel2 = channel;
                                obj = $result3;
                                $result = $result2;
                                $result2 = hasNext;
                                flowCollector = (FlowCollector<? super T>) consume;
                                try {
                                    if (((Boolean) $result2).booleanValue()) {
                                        return Unit.INSTANCE;
                                    }
                                    T next = channelIterator.next();
                                    flowKt__ChannelsKt$emitAllImpl$12.L$0 = $this$emitAllImpl;
                                    flowKt__ChannelsKt$emitAllImpl$12.L$1 = channel2;
                                    flowKt__ChannelsKt$emitAllImpl$12.L$2 = channelIterator;
                                    flowKt__ChannelsKt$emitAllImpl$12.Z$0 = (boolean) flowCollector;
                                    flowKt__ChannelsKt$emitAllImpl$12.label = 2;
                                    if ($this$emitAllImpl.emit(next, flowKt__ChannelsKt$emitAllImpl$12) == obj) {
                                        return obj;
                                    }
                                    $result2 = $result;
                                    $result3 = obj;
                                    channel = channel2;
                                    it = channelIterator;
                                    cause = cause2;
                                    consume = flowCollector;
                                    $this$emitAllImpl2 = (FlowCollector<? super T>) $this$emitAllImpl;
                                    flowKt__ChannelsKt$emitAllImpl$12.L$0 = $this$emitAllImpl2;
                                    flowKt__ChannelsKt$emitAllImpl$12.L$1 = channel;
                                    flowKt__ChannelsKt$emitAllImpl$12.L$2 = it;
                                    flowKt__ChannelsKt$emitAllImpl$12.Z$0 = consume;
                                    flowKt__ChannelsKt$emitAllImpl$12.label = 1;
                                    hasNext = it.hasNext(flowKt__ChannelsKt$emitAllImpl$12);
                                    if (hasNext == $result3) {
                                    }
                                } catch (Throwable th) {
                                    cause = th;
                                    channel = channel2;
                                    Throwable cause3 = cause;
                                    try {
                                        throw cause;
                                    } finally {
                                        if (flowCollector != null) {
                                            ChannelsKt.cancelConsumed(channel, cause3);
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                cause = th2;
                                flowCollector = consume;
                                Throwable cause32 = cause;
                                throw cause;
                            }
                        case 1:
                            ?? r7 = flowKt__ChannelsKt$emitAllImpl$12.Z$0;
                            channelIterator = (ChannelIterator) flowKt__ChannelsKt$emitAllImpl$12.L$2;
                            cause2 = null;
                            ReceiveChannel channel3 = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$12.L$1;
                            FlowCollector $this$emitAllImpl3 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$12.L$0;
                            ResultKt.throwOnFailure($result2);
                            $this$emitAllImpl = $this$emitAllImpl3;
                            channel2 = channel3;
                            obj = $result3;
                            $result = $result2;
                            flowCollector = r7;
                            if (((Boolean) $result2).booleanValue()) {
                            }
                            break;
                        case 2:
                            boolean consume2 = flowKt__ChannelsKt$emitAllImpl$12.Z$0;
                            ChannelIterator<? extends T> channelIterator2 = (ChannelIterator) flowKt__ChannelsKt$emitAllImpl$12.L$2;
                            ReceiveChannel receiveChannel2 = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$12.L$1;
                            FlowCollector flowCollector2 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$12.L$0;
                            ResultKt.throwOnFailure($result2);
                            consume = consume2;
                            it = channelIterator2;
                            cause = null;
                            channel = receiveChannel2;
                            $this$emitAllImpl2 = (FlowCollector<? super T>) flowCollector2;
                            flowKt__ChannelsKt$emitAllImpl$12.L$0 = $this$emitAllImpl2;
                            flowKt__ChannelsKt$emitAllImpl$12.L$1 = channel;
                            flowKt__ChannelsKt$emitAllImpl$12.L$2 = it;
                            flowKt__ChannelsKt$emitAllImpl$12.Z$0 = consume;
                            flowKt__ChannelsKt$emitAllImpl$12.label = 1;
                            hasNext = it.hasNext(flowKt__ChannelsKt$emitAllImpl$12);
                            if (hasNext == $result3) {
                            }
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (channel) {
            }
        } catch (Throwable th3) {
            cause = th3;
        }
        flowKt__ChannelsKt$emitAllImpl$1 = new FlowKt__ChannelsKt$emitAllImpl$1(continuation);
        FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$122 = flowKt__ChannelsKt$emitAllImpl$1;
        Object $result22 = flowKt__ChannelsKt$emitAllImpl$122.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        channel = flowKt__ChannelsKt$emitAllImpl$122.label;
    }

    public static final <T> Flow<T> receiveAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, false, null, 0, null, 28, null);
    }

    public static final <T> Flow<T> consumeAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, true, null, 0, null, 28, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    public static final <T> Flow<T> asFlow(final BroadcastChannel<T> broadcastChannel) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
                Object emitAll = FlowKt.emitAll(flowCollector, BroadcastChannel.this.openSubscription(), continuation);
                return emitAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emitAll : Unit.INSTANCE;
            }
        };
    }

    public static final <T> ReceiveChannel<T> produceIn(Flow<? extends T> flow, CoroutineScope scope) {
        return ChannelFlowKt.asChannelFlow(flow).produceImpl(scope);
    }
}