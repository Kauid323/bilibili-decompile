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
/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {284, 285}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$take$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel<E> $this_take;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$take$1(int i, ReceiveChannel<? extends E> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$take$1> continuation) {
        super(2, continuation);
        this.$n = i;
        this.$this_take = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$1 = new ChannelsKt__DeprecatedKt$take$1(this.$n, this.$this_take, continuation);
        channelsKt__DeprecatedKt$take$1.L$0 = obj;
        return channelsKt__DeprecatedKt$take$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$take$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0090 -> B:29:0x0096). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$1;
        int remaining;
        ChannelIterator<E> it;
        ProducerScope $this$produce;
        ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$12;
        Object obj;
        Object $result2;
        int remaining2;
        ChannelIterator<E> channelIterator;
        ProducerScope $this$produce2;
        int remaining3;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                channelsKt__DeprecatedKt$take$1 = this;
                ProducerScope $this$produce3 = (ProducerScope) channelsKt__DeprecatedKt$take$1.L$0;
                if (channelsKt__DeprecatedKt$take$1.$n == 0) {
                    return Unit.INSTANCE;
                }
                boolean z = channelsKt__DeprecatedKt$take$1.$n >= 0;
                int i = channelsKt__DeprecatedKt$take$1.$n;
                if (!z) {
                    throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
                }
                remaining = channelsKt__DeprecatedKt$take$1.$n;
                it = channelsKt__DeprecatedKt$take$1.$this_take.iterator();
                channelsKt__DeprecatedKt$take$1.L$0 = $this$produce3;
                channelsKt__DeprecatedKt$take$1.L$1 = it;
                channelsKt__DeprecatedKt$take$1.I$0 = remaining;
                channelsKt__DeprecatedKt$take$1.label = 1;
                Object hasNext = it.hasNext(channelsKt__DeprecatedKt$take$1);
                if (hasNext != $result3) {
                    return $result3;
                }
                Object obj2 = $result3;
                $result2 = $result;
                $result = hasNext;
                $this$produce = $this$produce3;
                channelsKt__DeprecatedKt$take$12 = channelsKt__DeprecatedKt$take$1;
                obj = obj2;
                if (!((Boolean) $result).booleanValue()) {
                    channelsKt__DeprecatedKt$take$12.L$0 = $this$produce;
                    channelsKt__DeprecatedKt$take$12.L$1 = it;
                    channelsKt__DeprecatedKt$take$12.I$0 = remaining;
                    channelsKt__DeprecatedKt$take$12.label = 2;
                    Object e = $this$produce.send(it.next(), channelsKt__DeprecatedKt$take$12);
                    if (e == obj) {
                        return obj;
                    }
                    $result = $result2;
                    $result3 = obj;
                    channelsKt__DeprecatedKt$take$1 = channelsKt__DeprecatedKt$take$12;
                    remaining2 = remaining;
                    channelIterator = it;
                    $this$produce2 = $this$produce;
                    remaining3 = remaining2 - 1;
                    if (remaining3 == 0) {
                        ChannelIterator<E> channelIterator2 = channelIterator;
                        remaining = remaining3;
                        $this$produce3 = $this$produce2;
                        it = channelIterator2;
                        channelsKt__DeprecatedKt$take$1.L$0 = $this$produce3;
                        channelsKt__DeprecatedKt$take$1.L$1 = it;
                        channelsKt__DeprecatedKt$take$1.I$0 = remaining;
                        channelsKt__DeprecatedKt$take$1.label = 1;
                        Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$take$1);
                        if (hasNext2 != $result3) {
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    return Unit.INSTANCE;
                }
            case 1:
                int remaining4 = this.I$0;
                ProducerScope $this$produce4 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$produce = $this$produce4;
                it = (ChannelIterator) this.L$1;
                remaining = remaining4;
                channelsKt__DeprecatedKt$take$12 = this;
                obj = $result3;
                $result2 = $result;
                if (!((Boolean) $result).booleanValue()) {
                }
                break;
            case 2:
                channelsKt__DeprecatedKt$take$1 = this;
                remaining2 = channelsKt__DeprecatedKt$take$1.I$0;
                channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$take$1.L$1;
                $this$produce2 = (ProducerScope) channelsKt__DeprecatedKt$take$1.L$0;
                ResultKt.throwOnFailure($result);
                remaining3 = remaining2 - 1;
                if (remaining3 == 0) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}