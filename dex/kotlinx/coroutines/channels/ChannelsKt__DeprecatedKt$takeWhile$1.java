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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {299, 300, 301}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
final class ChannelsKt__DeprecatedKt$takeWhile$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<E> $this_takeWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$takeWhile$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$takeWhile$1> continuation) {
        super(2, continuation);
        this.$this_takeWhile = receiveChannel;
        this.$predicate = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$takeWhile$1 channelsKt__DeprecatedKt$takeWhile$1 = new ChannelsKt__DeprecatedKt$takeWhile$1(this.$this_takeWhile, this.$predicate, continuation);
        channelsKt__DeprecatedKt$takeWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$takeWhile$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$takeWhile$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00b2 -> B:10:0x0058). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ChannelsKt__DeprecatedKt$takeWhile$1 channelsKt__DeprecatedKt$takeWhile$1;
        ProducerScope $this$produce;
        ChannelIterator<E> it;
        ProducerScope $this$produce2;
        ChannelIterator<E> channelIterator;
        ChannelsKt__DeprecatedKt$takeWhile$1 channelsKt__DeprecatedKt$takeWhile$12;
        Object obj;
        Object $result2;
        ProducerScope $this$produce3;
        ChannelIterator<E> channelIterator2;
        E e;
        Object hasNext;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                channelsKt__DeprecatedKt$takeWhile$1 = this;
                ProducerScope $this$produce4 = (ProducerScope) channelsKt__DeprecatedKt$takeWhile$1.L$0;
                $this$produce = $this$produce4;
                it = channelsKt__DeprecatedKt$takeWhile$1.$this_takeWhile.iterator();
                channelsKt__DeprecatedKt$takeWhile$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$takeWhile$1.L$1 = it;
                channelsKt__DeprecatedKt$takeWhile$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$takeWhile$1);
                if (hasNext == $result3) {
                    return $result3;
                }
                Object obj2 = $result3;
                $result2 = $result;
                $result = hasNext;
                $this$produce2 = $this$produce;
                channelIterator = it;
                channelsKt__DeprecatedKt$takeWhile$12 = channelsKt__DeprecatedKt$takeWhile$1;
                obj = obj2;
                if (((Boolean) $result).booleanValue()) {
                    return Unit.INSTANCE;
                }
                E next = channelIterator.next();
                Function2<E, Continuation<? super Boolean>, Object> function2 = channelsKt__DeprecatedKt$takeWhile$12.$predicate;
                channelsKt__DeprecatedKt$takeWhile$12.L$0 = $this$produce2;
                channelsKt__DeprecatedKt$takeWhile$12.L$1 = channelIterator;
                channelsKt__DeprecatedKt$takeWhile$12.L$2 = next;
                channelsKt__DeprecatedKt$takeWhile$12.label = 2;
                Object invoke = function2.invoke(next, channelsKt__DeprecatedKt$takeWhile$12);
                if (invoke == obj) {
                    return obj;
                }
                ChannelIterator<E> channelIterator3 = channelIterator;
                e = next;
                $result = invoke;
                $this$produce3 = $this$produce2;
                channelIterator2 = channelIterator3;
                if (((Boolean) $result).booleanValue()) {
                    return Unit.INSTANCE;
                }
                channelsKt__DeprecatedKt$takeWhile$12.L$0 = $this$produce3;
                channelsKt__DeprecatedKt$takeWhile$12.L$1 = channelIterator2;
                channelsKt__DeprecatedKt$takeWhile$12.L$2 = null;
                channelsKt__DeprecatedKt$takeWhile$12.label = 3;
                if ($this$produce3.send(e, channelsKt__DeprecatedKt$takeWhile$12) == obj) {
                    return obj;
                }
                $result = $result2;
                $result3 = obj;
                channelsKt__DeprecatedKt$takeWhile$1 = channelsKt__DeprecatedKt$takeWhile$12;
                it = channelIterator2;
                $this$produce = $this$produce3;
                channelsKt__DeprecatedKt$takeWhile$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$takeWhile$1.L$1 = it;
                channelsKt__DeprecatedKt$takeWhile$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$takeWhile$1);
                if (hasNext == $result3) {
                }
            case 1:
                ProducerScope $this$produce5 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$produce2 = $this$produce5;
                channelIterator = (ChannelIterator) this.L$1;
                channelsKt__DeprecatedKt$takeWhile$12 = this;
                obj = $result3;
                $result2 = $result;
                if (((Boolean) $result).booleanValue()) {
                }
                break;
            case 2:
                Object e2 = this.L$2;
                ProducerScope $this$produce6 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$produce3 = $this$produce6;
                channelIterator2 = (ChannelIterator) this.L$1;
                e = e2;
                channelsKt__DeprecatedKt$takeWhile$12 = this;
                obj = $result3;
                $result2 = $result;
                if (((Boolean) $result).booleanValue()) {
                }
                break;
            case 3:
                channelsKt__DeprecatedKt$takeWhile$1 = this;
                it = (ChannelIterator) channelsKt__DeprecatedKt$takeWhile$1.L$1;
                $this$produce = (ProducerScope) channelsKt__DeprecatedKt$takeWhile$1.L$0;
                ResultKt.throwOnFailure($result);
                channelsKt__DeprecatedKt$takeWhile$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$takeWhile$1.L$1 = it;
                channelsKt__DeprecatedKt$takeWhile$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$takeWhile$1);
                if (hasNext == $result3) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}