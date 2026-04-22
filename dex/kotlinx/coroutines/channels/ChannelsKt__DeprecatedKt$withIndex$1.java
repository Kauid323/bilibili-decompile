package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/collections/IndexedValue;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {400, 401}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$withIndex$1<E> extends SuspendLambda implements Function2<ProducerScope<? super IndexedValue<? extends E>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<E> $this_withIndex;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$withIndex$1(ReceiveChannel<? extends E> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$withIndex$1> continuation) {
        super(2, continuation);
        this.$this_withIndex = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$1 = new ChannelsKt__DeprecatedKt$withIndex$1(this.$this_withIndex, continuation);
        channelsKt__DeprecatedKt$withIndex$1.L$0 = obj;
        return channelsKt__DeprecatedKt$withIndex$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super IndexedValue<? extends E>> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$withIndex$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0088 -> B:9:0x0049). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$1;
        ProducerScope $this$produce;
        int index;
        ChannelIterator<E> it;
        ProducerScope $this$produce2;
        ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$12;
        Object obj;
        Object $result2;
        Object hasNext;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                channelsKt__DeprecatedKt$withIndex$1 = this;
                $this$produce = (ProducerScope) channelsKt__DeprecatedKt$withIndex$1.L$0;
                index = 0;
                it = channelsKt__DeprecatedKt$withIndex$1.$this_withIndex.iterator();
                channelsKt__DeprecatedKt$withIndex$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$withIndex$1.L$1 = it;
                channelsKt__DeprecatedKt$withIndex$1.I$0 = index;
                channelsKt__DeprecatedKt$withIndex$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$withIndex$1);
                if (hasNext == $result3) {
                    return $result3;
                }
                Object obj2 = $result3;
                $result2 = $result;
                $result = hasNext;
                $this$produce2 = $this$produce;
                channelsKt__DeprecatedKt$withIndex$12 = channelsKt__DeprecatedKt$withIndex$1;
                obj = obj2;
                if (!((Boolean) $result).booleanValue()) {
                    Object e = it.next();
                    int index2 = index + 1;
                    channelsKt__DeprecatedKt$withIndex$12.L$0 = $this$produce2;
                    channelsKt__DeprecatedKt$withIndex$12.L$1 = it;
                    channelsKt__DeprecatedKt$withIndex$12.I$0 = index2;
                    channelsKt__DeprecatedKt$withIndex$12.label = 2;
                    if ($this$produce2.send(new IndexedValue(index, e), channelsKt__DeprecatedKt$withIndex$12) == obj) {
                        return obj;
                    }
                    $result = $result2;
                    $result3 = obj;
                    channelsKt__DeprecatedKt$withIndex$1 = channelsKt__DeprecatedKt$withIndex$12;
                    $this$produce = $this$produce2;
                    index = index2;
                    channelsKt__DeprecatedKt$withIndex$1.L$0 = $this$produce;
                    channelsKt__DeprecatedKt$withIndex$1.L$1 = it;
                    channelsKt__DeprecatedKt$withIndex$1.I$0 = index;
                    channelsKt__DeprecatedKt$withIndex$1.label = 1;
                    hasNext = it.hasNext(channelsKt__DeprecatedKt$withIndex$1);
                    if (hasNext == $result3) {
                    }
                } else {
                    return Unit.INSTANCE;
                }
            case 1:
                int index3 = this.I$0;
                ProducerScope $this$produce3 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$produce2 = $this$produce3;
                it = (ChannelIterator) this.L$1;
                index = index3;
                channelsKt__DeprecatedKt$withIndex$12 = this;
                obj = $result3;
                $result2 = $result;
                if (!((Boolean) $result).booleanValue()) {
                }
                break;
            case 2:
                channelsKt__DeprecatedKt$withIndex$1 = this;
                int index4 = channelsKt__DeprecatedKt$withIndex$1.I$0;
                ChannelIterator<E> channelIterator = (ChannelIterator) channelsKt__DeprecatedKt$withIndex$1.L$1;
                ProducerScope $this$produce4 = (ProducerScope) channelsKt__DeprecatedKt$withIndex$1.L$0;
                ResultKt.throwOnFailure($result);
                index = index4;
                $this$produce = $this$produce4;
                it = channelIterator;
                channelsKt__DeprecatedKt$withIndex$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$withIndex$1.L$1 = it;
                channelsKt__DeprecatedKt$withIndex$1.I$0 = index;
                channelsKt__DeprecatedKt$withIndex$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$withIndex$1);
                if (hasNext == $result3) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}