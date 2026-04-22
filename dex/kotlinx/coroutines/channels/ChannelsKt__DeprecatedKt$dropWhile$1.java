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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 3, 4}, l = {211, 212, 213, 217, 218}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$0"})
final class ChannelsKt__DeprecatedKt$dropWhile$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<E> $this_dropWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$dropWhile$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$dropWhile$1> continuation) {
        super(2, continuation);
        this.$this_dropWhile = receiveChannel;
        this.$predicate = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$1 = new ChannelsKt__DeprecatedKt$dropWhile$1(this.$this_dropWhile, this.$predicate, continuation);
        channelsKt__DeprecatedKt$dropWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$dropWhile$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$dropWhile$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0114  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00ad -> B:22:0x00b1). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0112 -> B:31:0x00e1). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ChannelIterator<E> it;
        ProducerScope $this$produce;
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$1;
        Object obj;
        Object $result2;
        E e;
        ChannelIterator<E> channelIterator;
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$12;
        ProducerScope $this$produce2;
        ChannelIterator<E> it2;
        ChannelIterator<E> channelIterator2;
        Object hasNext;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$13 = this;
                ProducerScope $this$produce3 = (ProducerScope) channelsKt__DeprecatedKt$dropWhile$13.L$0;
                it = channelsKt__DeprecatedKt$dropWhile$13.$this_dropWhile.iterator();
                channelsKt__DeprecatedKt$dropWhile$13.L$0 = $this$produce3;
                channelsKt__DeprecatedKt$dropWhile$13.L$1 = it;
                channelsKt__DeprecatedKt$dropWhile$13.L$2 = null;
                channelsKt__DeprecatedKt$dropWhile$13.label = 1;
                Object hasNext2 = it.hasNext(channelsKt__DeprecatedKt$dropWhile$13);
                if (hasNext2 != $result3) {
                    return $result3;
                }
                Object obj2 = $result3;
                $result2 = $result;
                $result = hasNext2;
                $this$produce = $this$produce3;
                channelsKt__DeprecatedKt$dropWhile$1 = channelsKt__DeprecatedKt$dropWhile$13;
                obj = obj2;
                if (((Boolean) $result).booleanValue()) {
                    E next = it.next();
                    Function2<E, Continuation<? super Boolean>, Object> function2 = channelsKt__DeprecatedKt$dropWhile$1.$predicate;
                    channelsKt__DeprecatedKt$dropWhile$1.L$0 = $this$produce;
                    channelsKt__DeprecatedKt$dropWhile$1.L$1 = it;
                    channelsKt__DeprecatedKt$dropWhile$1.L$2 = next;
                    channelsKt__DeprecatedKt$dropWhile$1.label = 2;
                    Object invoke = function2.invoke(next, channelsKt__DeprecatedKt$dropWhile$1);
                    if (invoke == obj) {
                        return obj;
                    }
                    ChannelIterator<E> channelIterator3 = it;
                    e = next;
                    $result = invoke;
                    channelIterator = channelIterator3;
                    if (((Boolean) $result).booleanValue()) {
                        channelsKt__DeprecatedKt$dropWhile$1.L$0 = $this$produce;
                        channelsKt__DeprecatedKt$dropWhile$1.L$1 = null;
                        channelsKt__DeprecatedKt$dropWhile$1.L$2 = null;
                        channelsKt__DeprecatedKt$dropWhile$1.label = 3;
                        if ($this$produce.send(e, channelsKt__DeprecatedKt$dropWhile$1) == obj) {
                            return obj;
                        }
                        $result = $result2;
                        $result3 = obj;
                        channelsKt__DeprecatedKt$dropWhile$12 = channelsKt__DeprecatedKt$dropWhile$1;
                        $this$produce2 = $this$produce;
                        channelsKt__DeprecatedKt$dropWhile$1 = channelsKt__DeprecatedKt$dropWhile$12;
                        $this$produce = $this$produce2;
                        obj = $result3;
                    } else {
                        $result = $result2;
                        $result3 = obj;
                        channelsKt__DeprecatedKt$dropWhile$13 = channelsKt__DeprecatedKt$dropWhile$1;
                        $this$produce3 = $this$produce;
                        it = channelIterator;
                        channelsKt__DeprecatedKt$dropWhile$13.L$0 = $this$produce3;
                        channelsKt__DeprecatedKt$dropWhile$13.L$1 = it;
                        channelsKt__DeprecatedKt$dropWhile$13.L$2 = null;
                        channelsKt__DeprecatedKt$dropWhile$13.label = 1;
                        Object hasNext22 = it.hasNext(channelsKt__DeprecatedKt$dropWhile$13);
                        if (hasNext22 != $result3) {
                        }
                    }
                }
                it2 = channelsKt__DeprecatedKt$dropWhile$1.$this_dropWhile.iterator();
                channelsKt__DeprecatedKt$dropWhile$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$dropWhile$1.L$1 = it2;
                channelsKt__DeprecatedKt$dropWhile$1.label = 4;
                hasNext = it2.hasNext(channelsKt__DeprecatedKt$dropWhile$1);
                if (hasNext == obj) {
                    return obj;
                }
                channelIterator2 = it2;
                $result = hasNext;
                if (((Boolean) $result).booleanValue()) {
                    return Unit.INSTANCE;
                }
                channelsKt__DeprecatedKt$dropWhile$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$dropWhile$1.L$1 = channelIterator2;
                channelsKt__DeprecatedKt$dropWhile$1.label = 5;
                Object e2 = $this$produce.send(channelIterator2.next(), channelsKt__DeprecatedKt$dropWhile$1);
                if (e2 == obj) {
                    return obj;
                }
                it2 = channelIterator2;
                channelsKt__DeprecatedKt$dropWhile$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$dropWhile$1.L$1 = it2;
                channelsKt__DeprecatedKt$dropWhile$1.label = 4;
                hasNext = it2.hasNext(channelsKt__DeprecatedKt$dropWhile$1);
                if (hasNext == obj) {
                }
            case 1:
                ProducerScope $this$produce4 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$produce = $this$produce4;
                it = (ChannelIterator) this.L$1;
                channelsKt__DeprecatedKt$dropWhile$1 = this;
                obj = $result3;
                $result2 = $result;
                if (((Boolean) $result).booleanValue()) {
                }
                it2 = channelsKt__DeprecatedKt$dropWhile$1.$this_dropWhile.iterator();
                channelsKt__DeprecatedKt$dropWhile$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$dropWhile$1.L$1 = it2;
                channelsKt__DeprecatedKt$dropWhile$1.label = 4;
                hasNext = it2.hasNext(channelsKt__DeprecatedKt$dropWhile$1);
                if (hasNext == obj) {
                }
                break;
            case 2:
                Object e3 = this.L$2;
                $this$produce = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                channelIterator = (ChannelIterator) this.L$1;
                e = e3;
                channelsKt__DeprecatedKt$dropWhile$1 = this;
                obj = $result3;
                $result2 = $result;
                if (((Boolean) $result).booleanValue()) {
                }
                break;
            case 3:
                channelsKt__DeprecatedKt$dropWhile$12 = this;
                $this$produce2 = (ProducerScope) channelsKt__DeprecatedKt$dropWhile$12.L$0;
                ResultKt.throwOnFailure($result);
                channelsKt__DeprecatedKt$dropWhile$1 = channelsKt__DeprecatedKt$dropWhile$12;
                $this$produce = $this$produce2;
                obj = $result3;
                it2 = channelsKt__DeprecatedKt$dropWhile$1.$this_dropWhile.iterator();
                channelsKt__DeprecatedKt$dropWhile$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$dropWhile$1.L$1 = it2;
                channelsKt__DeprecatedKt$dropWhile$1.label = 4;
                hasNext = it2.hasNext(channelsKt__DeprecatedKt$dropWhile$1);
                if (hasNext == obj) {
                }
                break;
            case 4:
                channelIterator2 = (ChannelIterator) this.L$1;
                ProducerScope $this$produce5 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$produce = $this$produce5;
                channelsKt__DeprecatedKt$dropWhile$1 = this;
                obj = $result3;
                if (((Boolean) $result).booleanValue()) {
                }
                break;
            case 5:
                ProducerScope $this$produce6 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$produce = $this$produce6;
                channelsKt__DeprecatedKt$dropWhile$1 = this;
                obj = $result3;
                it2 = (ChannelIterator) this.L$1;
                channelsKt__DeprecatedKt$dropWhile$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$dropWhile$1.L$1 = it2;
                channelsKt__DeprecatedKt$dropWhile$1.label = 4;
                hasNext = it2.hasNext(channelsKt__DeprecatedKt$dropWhile$1);
                if (hasNext == obj) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}