package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: Broadcast.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", i = {0, 1}, l = {52, 53}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast"}, s = {"L$0", "L$0"})
final class BroadcastKt$broadcast$2<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<E> $channel;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BroadcastKt$broadcast$2(ReceiveChannel<? extends E> receiveChannel, Continuation<? super BroadcastKt$broadcast$2> continuation) {
        super(2, continuation);
        this.$channel = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BroadcastKt$broadcast$2 broadcastKt$broadcast$2 = new BroadcastKt$broadcast$2(this.$channel, continuation);
        broadcastKt$broadcast$2.L$0 = obj;
        return broadcastKt$broadcast$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((BroadcastKt$broadcast$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0076 -> B:9:0x0042). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        BroadcastKt$broadcast$2 broadcastKt$broadcast$2;
        ProducerScope $this$broadcast;
        ChannelIterator<E> it;
        ProducerScope $this$broadcast2;
        BroadcastKt$broadcast$2 broadcastKt$broadcast$22;
        Object obj;
        Object $result2;
        Object hasNext;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                broadcastKt$broadcast$2 = this;
                $this$broadcast = (ProducerScope) broadcastKt$broadcast$2.L$0;
                it = broadcastKt$broadcast$2.$channel.iterator();
                broadcastKt$broadcast$2.L$0 = $this$broadcast;
                broadcastKt$broadcast$2.L$1 = it;
                broadcastKt$broadcast$2.label = 1;
                hasNext = it.hasNext(broadcastKt$broadcast$2);
                if (hasNext == $result3) {
                    return $result3;
                }
                Object obj2 = $result3;
                $result2 = $result;
                $result = hasNext;
                $this$broadcast2 = $this$broadcast;
                broadcastKt$broadcast$22 = broadcastKt$broadcast$2;
                obj = obj2;
                if (!((Boolean) $result).booleanValue()) {
                    broadcastKt$broadcast$22.L$0 = $this$broadcast2;
                    broadcastKt$broadcast$22.L$1 = it;
                    broadcastKt$broadcast$22.label = 2;
                    Object e = $this$broadcast2.send(it.next(), broadcastKt$broadcast$22);
                    if (e == obj) {
                        return obj;
                    }
                    $result = $result2;
                    $result3 = obj;
                    broadcastKt$broadcast$2 = broadcastKt$broadcast$22;
                    $this$broadcast = $this$broadcast2;
                    broadcastKt$broadcast$2.L$0 = $this$broadcast;
                    broadcastKt$broadcast$2.L$1 = it;
                    broadcastKt$broadcast$2.label = 1;
                    hasNext = it.hasNext(broadcastKt$broadcast$2);
                    if (hasNext == $result3) {
                    }
                } else {
                    return Unit.INSTANCE;
                }
            case 1:
                ProducerScope $this$broadcast3 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$broadcast2 = $this$broadcast3;
                it = (ChannelIterator) this.L$1;
                broadcastKt$broadcast$22 = this;
                obj = $result3;
                $result2 = $result;
                if (!((Boolean) $result).booleanValue()) {
                }
                break;
            case 2:
                broadcastKt$broadcast$2 = this;
                ProducerScope $this$broadcast4 = (ProducerScope) broadcastKt$broadcast$2.L$0;
                ResultKt.throwOnFailure($result);
                it = (ChannelIterator) broadcastKt$broadcast$2.L$1;
                $this$broadcast = $this$broadcast4;
                broadcastKt$broadcast$2.L$0 = $this$broadcast;
                broadcastKt$broadcast$2.L$1 = it;
                broadcastKt$broadcast$2.label = 1;
                hasNext = it.hasNext(broadcastKt$broadcast$2);
                if (hasNext == $result3) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}