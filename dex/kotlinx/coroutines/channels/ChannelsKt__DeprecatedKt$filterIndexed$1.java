package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {241, 242, 242}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$filterIndexed$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Integer, E, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<E> $this_filterIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$filterIndexed$1(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> function3, Continuation<? super ChannelsKt__DeprecatedKt$filterIndexed$1> continuation) {
        super(2, continuation);
        this.$this_filterIndexed = receiveChannel;
        this.$predicate = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$1 = new ChannelsKt__DeprecatedKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, continuation);
        channelsKt__DeprecatedKt$filterIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterIndexed$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00c3 -> B:10:0x0060). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ca -> B:10:0x0060). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$1;
        ProducerScope $this$produce;
        int index;
        ChannelIterator<E> it;
        ProducerScope $this$produce2;
        ChannelIterator<E> channelIterator;
        int index2;
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$12;
        Object obj;
        Object $result2;
        Object e;
        int index3;
        Object hasNext;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                channelsKt__DeprecatedKt$filterIndexed$1 = this;
                ProducerScope $this$produce3 = (ProducerScope) channelsKt__DeprecatedKt$filterIndexed$1.L$0;
                $this$produce = $this$produce3;
                index = 0;
                it = channelsKt__DeprecatedKt$filterIndexed$1.$this_filterIndexed.iterator();
                channelsKt__DeprecatedKt$filterIndexed$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$filterIndexed$1.L$1 = it;
                channelsKt__DeprecatedKt$filterIndexed$1.L$2 = null;
                channelsKt__DeprecatedKt$filterIndexed$1.I$0 = index;
                channelsKt__DeprecatedKt$filterIndexed$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$filterIndexed$1);
                if (hasNext != $result3) {
                    return $result3;
                }
                Object obj2 = $result3;
                $result2 = $result;
                $result = hasNext;
                $this$produce2 = $this$produce;
                channelIterator = it;
                index2 = index;
                channelsKt__DeprecatedKt$filterIndexed$12 = channelsKt__DeprecatedKt$filterIndexed$1;
                obj = obj2;
                if (((Boolean) $result).booleanValue()) {
                    return Unit.INSTANCE;
                }
                E next = channelIterator.next();
                Function3<Integer, E, Continuation<? super Boolean>, Object> function3 = channelsKt__DeprecatedKt$filterIndexed$12.$predicate;
                index3 = index2 + 1;
                Integer boxInt = Boxing.boxInt(index2);
                channelsKt__DeprecatedKt$filterIndexed$12.L$0 = $this$produce2;
                channelsKt__DeprecatedKt$filterIndexed$12.L$1 = channelIterator;
                channelsKt__DeprecatedKt$filterIndexed$12.L$2 = next;
                channelsKt__DeprecatedKt$filterIndexed$12.I$0 = index3;
                channelsKt__DeprecatedKt$filterIndexed$12.label = 2;
                Object invoke = function3.invoke(boxInt, next, channelsKt__DeprecatedKt$filterIndexed$12);
                if (invoke == obj) {
                    return obj;
                }
                e = next;
                $result = invoke;
                if (((Boolean) $result).booleanValue()) {
                    $result = $result2;
                    $result3 = obj;
                    channelsKt__DeprecatedKt$filterIndexed$1 = channelsKt__DeprecatedKt$filterIndexed$12;
                    it = channelIterator;
                    $this$produce = $this$produce2;
                    index = index3;
                } else {
                    channelsKt__DeprecatedKt$filterIndexed$12.L$0 = $this$produce2;
                    channelsKt__DeprecatedKt$filterIndexed$12.L$1 = channelIterator;
                    channelsKt__DeprecatedKt$filterIndexed$12.L$2 = null;
                    channelsKt__DeprecatedKt$filterIndexed$12.I$0 = index3;
                    channelsKt__DeprecatedKt$filterIndexed$12.label = 3;
                    if ($this$produce2.send(e, channelsKt__DeprecatedKt$filterIndexed$12) == obj) {
                        return obj;
                    }
                    $result = $result2;
                    $result3 = obj;
                    channelsKt__DeprecatedKt$filterIndexed$1 = channelsKt__DeprecatedKt$filterIndexed$12;
                    it = channelIterator;
                    $this$produce = $this$produce2;
                    index = index3;
                }
                channelsKt__DeprecatedKt$filterIndexed$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$filterIndexed$1.L$1 = it;
                channelsKt__DeprecatedKt$filterIndexed$1.L$2 = null;
                channelsKt__DeprecatedKt$filterIndexed$1.I$0 = index;
                channelsKt__DeprecatedKt$filterIndexed$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$filterIndexed$1);
                if (hasNext != $result3) {
                }
            case 1:
                int index4 = this.I$0;
                ProducerScope $this$produce4 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$produce2 = $this$produce4;
                channelIterator = (ChannelIterator) this.L$1;
                index2 = index4;
                channelsKt__DeprecatedKt$filterIndexed$12 = this;
                obj = $result3;
                $result2 = $result;
                if (((Boolean) $result).booleanValue()) {
                }
                break;
            case 2:
                int index5 = this.I$0;
                e = this.L$2;
                channelIterator = (ChannelIterator) this.L$1;
                $this$produce2 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                index3 = index5;
                channelsKt__DeprecatedKt$filterIndexed$12 = this;
                obj = $result3;
                $result2 = $result;
                if (((Boolean) $result).booleanValue()) {
                }
                channelsKt__DeprecatedKt$filterIndexed$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$filterIndexed$1.L$1 = it;
                channelsKt__DeprecatedKt$filterIndexed$1.L$2 = null;
                channelsKt__DeprecatedKt$filterIndexed$1.I$0 = index;
                channelsKt__DeprecatedKt$filterIndexed$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$filterIndexed$1);
                if (hasNext != $result3) {
                }
                break;
            case 3:
                channelsKt__DeprecatedKt$filterIndexed$1 = this;
                index = channelsKt__DeprecatedKt$filterIndexed$1.I$0;
                it = (ChannelIterator) channelsKt__DeprecatedKt$filterIndexed$1.L$1;
                $this$produce = (ProducerScope) channelsKt__DeprecatedKt$filterIndexed$1.L$0;
                ResultKt.throwOnFailure($result);
                channelsKt__DeprecatedKt$filterIndexed$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$filterIndexed$1.L$1 = it;
                channelsKt__DeprecatedKt$filterIndexed$1.L$2 = null;
                channelsKt__DeprecatedKt$filterIndexed$1.I$0 = index;
                channelsKt__DeprecatedKt$filterIndexed$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$filterIndexed$1);
                if (hasNext != $result3) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}