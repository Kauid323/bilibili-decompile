package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u008a@"}, d2 = {"<anonymous>", "", "E", "R", "V", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {517, 499, 501}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1", "$this$produce", "otherIterator", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5", "L$0", "L$1", "L$3"})
public final class ChannelsKt__DeprecatedKt$zip$2<V> extends SuspendLambda implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<R> $other;
    final /* synthetic */ ReceiveChannel<E> $this_zip;
    final /* synthetic */ Function2<E, R, V> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$zip$2(ReceiveChannel<? extends R> receiveChannel, ReceiveChannel<? extends E> receiveChannel2, Function2<? super E, ? super R, ? extends V> function2, Continuation<? super ChannelsKt__DeprecatedKt$zip$2> continuation) {
        super(2, continuation);
        this.$other = receiveChannel;
        this.$this_zip = receiveChannel2;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$zip$2 channelsKt__DeprecatedKt$zip$2 = new ChannelsKt__DeprecatedKt$zip$2(this.$other, this.$this_zip, this.$transform, continuation);
        channelsKt__DeprecatedKt$zip$2.L$0 = obj;
        return channelsKt__DeprecatedKt$zip$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super V> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$zip$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00d3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ea A[Catch: all -> 0x0172, TRY_LEAVE, TryCatch #0 {all -> 0x0172, blocks: (B:26:0x00e2, B:28:0x00ea, B:47:0x0167), top: B:59:0x00e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0167 A[Catch: all -> 0x0172, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0172, blocks: (B:26:0x00e2, B:28:0x00ea, B:47:0x0167), top: B:59:0x00e2 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0136 -> B:39:0x0140). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x014c -> B:43:0x015a). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ReceiveChannel $this$consume$iv$iv;
        ChannelsKt__DeprecatedKt$zip$2 channelsKt__DeprecatedKt$zip$2;
        Object $result;
        Throwable cause$iv$iv;
        ChannelIterator otherIterator;
        boolean z;
        int $i$f$consume;
        ProducerScope $this$produce;
        boolean z2;
        Function2 function2;
        ChannelIterator it;
        Object $result2;
        ProducerScope $this$produce2;
        ChannelIterator otherIterator2;
        ReceiveChannel $this$consume$iv$iv2;
        Throwable cause$iv$iv2;
        Function2 function22;
        ChannelIterator channelIterator;
        int i;
        boolean z3;
        boolean z4;
        Object $result3;
        Object element1;
        Object element12;
        ChannelIterator channelIterator2;
        boolean z5;
        Function2 function23;
        ChannelIterator channelIterator3;
        Function2 function24;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Object obj2 = null;
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    channelsKt__DeprecatedKt$zip$2 = this;
                    $result = obj;
                    ProducerScope $this$produce3 = (ProducerScope) channelsKt__DeprecatedKt$zip$2.L$0;
                    ChannelIterator otherIterator3 = channelsKt__DeprecatedKt$zip$2.$other.iterator();
                    ReceiveChannel $this$consumeEach$iv = channelsKt__DeprecatedKt$zip$2.$this_zip;
                    $this$consume$iv$iv = $this$consumeEach$iv;
                    cause$iv$iv = null;
                    try {
                        otherIterator = otherIterator3;
                        z = false;
                        $i$f$consume = 0;
                        $this$produce = $this$produce3;
                        z2 = false;
                        function2 = channelsKt__DeprecatedKt$zip$2.$transform;
                        it = $this$consume$iv$iv.iterator();
                        channelsKt__DeprecatedKt$zip$2.L$0 = $this$produce;
                        channelsKt__DeprecatedKt$zip$2.L$1 = otherIterator;
                        channelsKt__DeprecatedKt$zip$2.L$2 = function2;
                        channelsKt__DeprecatedKt$zip$2.L$3 = $this$consume$iv$iv;
                        channelsKt__DeprecatedKt$zip$2.L$4 = it;
                        channelsKt__DeprecatedKt$zip$2.L$5 = obj2;
                        channelsKt__DeprecatedKt$zip$2.label = 1;
                        hasNext = it.hasNext(channelsKt__DeprecatedKt$zip$2);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        boolean z6 = z2;
                        $result3 = $result;
                        $result2 = hasNext;
                        $this$produce2 = $this$produce;
                        otherIterator2 = otherIterator;
                        $this$consume$iv$iv2 = $this$consume$iv$iv;
                        cause$iv$iv2 = cause$iv$iv;
                        function22 = function2;
                        channelIterator = it;
                        i = $i$f$consume;
                        z3 = z;
                        z4 = z6;
                        try {
                            if (((Boolean) $result2).booleanValue()) {
                                Unit unit = Unit.INSTANCE;
                                ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv2);
                                return Unit.INSTANCE;
                            }
                            Object element13 = channelIterator.next();
                            z5 = false;
                            channelsKt__DeprecatedKt$zip$2.L$0 = $this$produce2;
                            channelsKt__DeprecatedKt$zip$2.L$1 = otherIterator2;
                            channelsKt__DeprecatedKt$zip$2.L$2 = function22;
                            channelsKt__DeprecatedKt$zip$2.L$3 = $this$consume$iv$iv2;
                            channelsKt__DeprecatedKt$zip$2.L$4 = channelIterator;
                            channelsKt__DeprecatedKt$zip$2.L$5 = element13;
                            channelsKt__DeprecatedKt$zip$2.label = 2;
                            Object hasNext2 = otherIterator2.hasNext(channelsKt__DeprecatedKt$zip$2);
                            if (hasNext2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            element1 = hasNext2;
                            function23 = function22;
                            channelIterator2 = channelIterator;
                            element12 = element13;
                            try {
                                if (((Boolean) element1).booleanValue()) {
                                    Throwable th = cause$iv$iv2;
                                    function2 = function23;
                                    $result = $result3;
                                    z2 = z4;
                                    z = z3;
                                    $i$f$consume = i;
                                    it = channelIterator2;
                                    $this$consume$iv$iv = $this$consume$iv$iv2;
                                    otherIterator = otherIterator2;
                                    $this$produce = $this$produce2;
                                    cause$iv$iv = th;
                                    obj2 = null;
                                    channelsKt__DeprecatedKt$zip$2.L$0 = $this$produce;
                                    channelsKt__DeprecatedKt$zip$2.L$1 = otherIterator;
                                    channelsKt__DeprecatedKt$zip$2.L$2 = function2;
                                    channelsKt__DeprecatedKt$zip$2.L$3 = $this$consume$iv$iv;
                                    channelsKt__DeprecatedKt$zip$2.L$4 = it;
                                    channelsKt__DeprecatedKt$zip$2.L$5 = obj2;
                                    channelsKt__DeprecatedKt$zip$2.label = 1;
                                    hasNext = it.hasNext(channelsKt__DeprecatedKt$zip$2);
                                    if (hasNext != coroutine_suspended) {
                                    }
                                } else {
                                    Throwable cause$iv$iv3 = cause$iv$iv2;
                                    try {
                                        Object element2 = otherIterator2.next();
                                        Object invoke = function23.invoke(element12, element2);
                                        channelsKt__DeprecatedKt$zip$2.L$0 = $this$produce2;
                                        channelsKt__DeprecatedKt$zip$2.L$1 = otherIterator2;
                                        channelsKt__DeprecatedKt$zip$2.L$2 = function23;
                                        channelsKt__DeprecatedKt$zip$2.L$3 = $this$consume$iv$iv2;
                                        channelsKt__DeprecatedKt$zip$2.L$4 = channelIterator2;
                                        Function2 function25 = function23;
                                        channelsKt__DeprecatedKt$zip$2.L$5 = null;
                                        channelsKt__DeprecatedKt$zip$2.label = 3;
                                        if ($this$produce2.send(invoke, channelsKt__DeprecatedKt$zip$2) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        channelIterator3 = channelIterator2;
                                        $this$consume$iv$iv = $this$consume$iv$iv2;
                                        function24 = function25;
                                        cause$iv$iv = cause$iv$iv3;
                                        $result = $result3;
                                        z2 = z4;
                                        z = z3;
                                        $i$f$consume = i;
                                        it = channelIterator3;
                                        function2 = function24;
                                        otherIterator = otherIterator2;
                                        $this$produce = $this$produce2;
                                        obj2 = null;
                                        channelsKt__DeprecatedKt$zip$2.L$0 = $this$produce;
                                        channelsKt__DeprecatedKt$zip$2.L$1 = otherIterator;
                                        channelsKt__DeprecatedKt$zip$2.L$2 = function2;
                                        channelsKt__DeprecatedKt$zip$2.L$3 = $this$consume$iv$iv;
                                        channelsKt__DeprecatedKt$zip$2.L$4 = it;
                                        channelsKt__DeprecatedKt$zip$2.L$5 = obj2;
                                        channelsKt__DeprecatedKt$zip$2.label = 1;
                                        hasNext = it.hasNext(channelsKt__DeprecatedKt$zip$2);
                                        if (hasNext != coroutine_suspended) {
                                        }
                                    } catch (Throwable th2) {
                                        e$iv$iv = th2;
                                        $this$consume$iv$iv = $this$consume$iv$iv2;
                                        Throwable cause$iv$iv4 = e$iv$iv;
                                        try {
                                            throw e$iv$iv;
                                        } catch (Throwable e$iv$iv) {
                                            ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv4);
                                            throw e$iv$iv;
                                        }
                                    }
                                }
                            } catch (Throwable th3) {
                                e$iv$iv = th3;
                                $this$consume$iv$iv = $this$consume$iv$iv2;
                            }
                        } catch (Throwable th4) {
                            e$iv$iv = th4;
                            $this$consume$iv$iv = $this$consume$iv$iv2;
                            Throwable cause$iv$iv42 = e$iv$iv;
                            throw e$iv$iv;
                        }
                    } catch (Throwable th5) {
                        e$iv$iv = th5;
                        Throwable cause$iv$iv422 = e$iv$iv;
                        throw e$iv$iv;
                    }
                case 1:
                    channelsKt__DeprecatedKt$zip$2 = this;
                    $result2 = obj;
                    ChannelIterator channelIterator4 = (ChannelIterator) channelsKt__DeprecatedKt$zip$2.L$4;
                    ReceiveChannel $this$consume$iv$iv3 = (ReceiveChannel) channelsKt__DeprecatedKt$zip$2.L$3;
                    Function2 function26 = (Function2) channelsKt__DeprecatedKt$zip$2.L$2;
                    ChannelIterator otherIterator4 = (ChannelIterator) channelsKt__DeprecatedKt$zip$2.L$1;
                    ProducerScope $this$produce4 = (ProducerScope) channelsKt__DeprecatedKt$zip$2.L$0;
                    ResultKt.throwOnFailure($result2);
                    $this$produce2 = $this$produce4;
                    otherIterator2 = otherIterator4;
                    $this$consume$iv$iv2 = $this$consume$iv$iv3;
                    cause$iv$iv2 = null;
                    function22 = function26;
                    channelIterator = channelIterator4;
                    i = 0;
                    z3 = false;
                    z4 = false;
                    $result3 = $result2;
                    if (((Boolean) $result2).booleanValue()) {
                    }
                    break;
                case 2:
                    channelsKt__DeprecatedKt$zip$2 = this;
                    element1 = obj;
                    element12 = channelsKt__DeprecatedKt$zip$2.L$5;
                    channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$zip$2.L$4;
                    $this$consume$iv$iv = (ReceiveChannel) channelsKt__DeprecatedKt$zip$2.L$3;
                    Function2 function27 = (Function2) channelsKt__DeprecatedKt$zip$2.L$2;
                    otherIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$zip$2.L$1;
                    $this$produce2 = (ProducerScope) channelsKt__DeprecatedKt$zip$2.L$0;
                    try {
                        ResultKt.throwOnFailure(element1);
                        z5 = false;
                        i = 0;
                        z3 = false;
                        z4 = false;
                        $result3 = element1;
                        cause$iv$iv2 = null;
                        function23 = function27;
                        $this$consume$iv$iv2 = $this$consume$iv$iv;
                        if (((Boolean) element1).booleanValue()) {
                        }
                    } catch (Throwable th6) {
                        e$iv$iv = th6;
                        Throwable cause$iv$iv4222 = e$iv$iv;
                        throw e$iv$iv;
                    }
                    break;
                case 3:
                    channelsKt__DeprecatedKt$zip$2 = this;
                    $result = obj;
                    z2 = false;
                    z = false;
                    $i$f$consume = 0;
                    channelIterator3 = (ChannelIterator) channelsKt__DeprecatedKt$zip$2.L$4;
                    cause$iv$iv = null;
                    $this$consume$iv$iv = (ReceiveChannel) channelsKt__DeprecatedKt$zip$2.L$3;
                    function24 = (Function2) channelsKt__DeprecatedKt$zip$2.L$2;
                    otherIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$zip$2.L$1;
                    $this$produce2 = (ProducerScope) channelsKt__DeprecatedKt$zip$2.L$0;
                    ResultKt.throwOnFailure($result);
                    it = channelIterator3;
                    function2 = function24;
                    otherIterator = otherIterator2;
                    $this$produce = $this$produce2;
                    obj2 = null;
                    channelsKt__DeprecatedKt$zip$2.L$0 = $this$produce;
                    channelsKt__DeprecatedKt$zip$2.L$1 = otherIterator;
                    channelsKt__DeprecatedKt$zip$2.L$2 = function2;
                    channelsKt__DeprecatedKt$zip$2.L$3 = $this$consume$iv$iv;
                    channelsKt__DeprecatedKt$zip$2.L$4 = it;
                    channelsKt__DeprecatedKt$zip$2.L$5 = obj2;
                    channelsKt__DeprecatedKt$zip$2.label = 1;
                    hasNext = it.hasNext(channelsKt__DeprecatedKt$zip$2);
                    if (hasNext != coroutine_suspended) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th7) {
            e$iv$iv = th7;
        }
    }
}