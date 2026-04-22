package kotlinx.coroutines.channels;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "E", "K", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {417, 418, 420}, m = "invokeSuspend", n = {"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
public final class ChannelsKt__DeprecatedKt$distinctBy$1<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<E, Continuation<? super K>, Object> $selector;
    final /* synthetic */ ReceiveChannel<E> $this_distinctBy;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$distinctBy$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$distinctBy$1> continuation) {
        super(2, continuation);
        this.$this_distinctBy = receiveChannel;
        this.$selector = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$distinctBy$1 channelsKt__DeprecatedKt$distinctBy$1 = new ChannelsKt__DeprecatedKt$distinctBy$1(this.$this_distinctBy, this.$selector, continuation);
        channelsKt__DeprecatedKt$distinctBy$1.L$0 = obj;
        return channelsKt__DeprecatedKt$distinctBy$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$distinctBy$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00cd -> B:26:0x00d5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00df -> B:10:0x006d). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ChannelsKt__DeprecatedKt$distinctBy$1 channelsKt__DeprecatedKt$distinctBy$1;
        HashSet keys;
        ProducerScope $this$produce;
        ChannelIterator<E> it;
        ProducerScope $this$produce2;
        HashSet keys2;
        ChannelIterator<E> channelIterator;
        ChannelsKt__DeprecatedKt$distinctBy$1 channelsKt__DeprecatedKt$distinctBy$12;
        Object obj;
        Object $result2;
        ProducerScope $this$produce3;
        HashSet keys3;
        ChannelIterator<E> channelIterator2;
        E e;
        ChannelIterator<E> channelIterator3;
        HashSet keys4;
        ProducerScope $this$produce4;
        Object k;
        Object hasNext;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                channelsKt__DeprecatedKt$distinctBy$1 = this;
                ProducerScope $this$produce5 = (ProducerScope) channelsKt__DeprecatedKt$distinctBy$1.L$0;
                keys = new HashSet();
                $this$produce = $this$produce5;
                it = channelsKt__DeprecatedKt$distinctBy$1.$this_distinctBy.iterator();
                channelsKt__DeprecatedKt$distinctBy$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$distinctBy$1.L$1 = keys;
                channelsKt__DeprecatedKt$distinctBy$1.L$2 = it;
                channelsKt__DeprecatedKt$distinctBy$1.L$3 = null;
                channelsKt__DeprecatedKt$distinctBy$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$distinctBy$1);
                if (hasNext != $result3) {
                    return $result3;
                }
                Object obj2 = $result3;
                $result2 = $result;
                $result = hasNext;
                $this$produce2 = $this$produce;
                keys2 = keys;
                channelIterator = it;
                channelsKt__DeprecatedKt$distinctBy$12 = channelsKt__DeprecatedKt$distinctBy$1;
                obj = obj2;
                if (((Boolean) $result).booleanValue()) {
                    Object k2 = Unit.INSTANCE;
                    return k2;
                }
                E next = channelIterator.next();
                Function2<E, Continuation<? super K>, Object> function2 = channelsKt__DeprecatedKt$distinctBy$12.$selector;
                channelsKt__DeprecatedKt$distinctBy$12.L$0 = $this$produce2;
                channelsKt__DeprecatedKt$distinctBy$12.L$1 = keys2;
                channelsKt__DeprecatedKt$distinctBy$12.L$2 = channelIterator;
                channelsKt__DeprecatedKt$distinctBy$12.L$3 = next;
                channelsKt__DeprecatedKt$distinctBy$12.label = 2;
                Object invoke = function2.invoke(next, channelsKt__DeprecatedKt$distinctBy$12);
                if (invoke == obj) {
                    return obj;
                }
                ChannelIterator<E> channelIterator4 = channelIterator;
                e = next;
                $result = invoke;
                $this$produce3 = $this$produce2;
                keys3 = keys2;
                channelIterator2 = channelIterator4;
                if (keys3.contains($result)) {
                    channelsKt__DeprecatedKt$distinctBy$12.L$0 = $this$produce3;
                    channelsKt__DeprecatedKt$distinctBy$12.L$1 = keys3;
                    channelsKt__DeprecatedKt$distinctBy$12.L$2 = channelIterator2;
                    channelsKt__DeprecatedKt$distinctBy$12.L$3 = $result;
                    channelsKt__DeprecatedKt$distinctBy$12.label = 3;
                    Object e2 = $this$produce3.send(e, channelsKt__DeprecatedKt$distinctBy$12);
                    if (e2 == obj) {
                        return obj;
                    }
                    channelIterator3 = channelIterator2;
                    keys4 = keys3;
                    $this$produce4 = $this$produce3;
                    ChannelsKt__DeprecatedKt$distinctBy$1 channelsKt__DeprecatedKt$distinctBy$13 = channelsKt__DeprecatedKt$distinctBy$12;
                    k = $result;
                    $result = $result2;
                    $result3 = obj;
                    channelsKt__DeprecatedKt$distinctBy$1 = channelsKt__DeprecatedKt$distinctBy$13;
                    keys4.add(k);
                    it = channelIterator3;
                    keys = keys4;
                    $this$produce = $this$produce4;
                    channelsKt__DeprecatedKt$distinctBy$1.L$0 = $this$produce;
                    channelsKt__DeprecatedKt$distinctBy$1.L$1 = keys;
                    channelsKt__DeprecatedKt$distinctBy$1.L$2 = it;
                    channelsKt__DeprecatedKt$distinctBy$1.L$3 = null;
                    channelsKt__DeprecatedKt$distinctBy$1.label = 1;
                    hasNext = it.hasNext(channelsKt__DeprecatedKt$distinctBy$1);
                    if (hasNext != $result3) {
                    }
                } else {
                    $result = $result2;
                    $result3 = obj;
                    channelsKt__DeprecatedKt$distinctBy$1 = channelsKt__DeprecatedKt$distinctBy$12;
                    it = channelIterator2;
                    keys = keys3;
                    $this$produce = $this$produce3;
                    channelsKt__DeprecatedKt$distinctBy$1.L$0 = $this$produce;
                    channelsKt__DeprecatedKt$distinctBy$1.L$1 = keys;
                    channelsKt__DeprecatedKt$distinctBy$1.L$2 = it;
                    channelsKt__DeprecatedKt$distinctBy$1.L$3 = null;
                    channelsKt__DeprecatedKt$distinctBy$1.label = 1;
                    hasNext = it.hasNext(channelsKt__DeprecatedKt$distinctBy$1);
                    if (hasNext != $result3) {
                    }
                }
            case 1:
                HashSet keys5 = (HashSet) this.L$1;
                ProducerScope $this$produce6 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$produce2 = $this$produce6;
                keys2 = keys5;
                channelIterator = (ChannelIterator) this.L$2;
                channelsKt__DeprecatedKt$distinctBy$12 = this;
                obj = $result3;
                $result2 = $result;
                if (((Boolean) $result).booleanValue()) {
                }
                break;
            case 2:
                Object e3 = this.L$3;
                HashSet keys6 = (HashSet) this.L$1;
                ProducerScope $this$produce7 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                $this$produce3 = $this$produce7;
                keys3 = keys6;
                channelIterator2 = (ChannelIterator) this.L$2;
                e = e3;
                channelsKt__DeprecatedKt$distinctBy$12 = this;
                obj = $result3;
                $result2 = $result;
                if (keys3.contains($result)) {
                }
                break;
            case 3:
                channelsKt__DeprecatedKt$distinctBy$1 = this;
                k = channelsKt__DeprecatedKt$distinctBy$1.L$3;
                channelIterator3 = (ChannelIterator) channelsKt__DeprecatedKt$distinctBy$1.L$2;
                keys4 = (HashSet) channelsKt__DeprecatedKt$distinctBy$1.L$1;
                $this$produce4 = (ProducerScope) channelsKt__DeprecatedKt$distinctBy$1.L$0;
                ResultKt.throwOnFailure($result);
                keys4.add(k);
                it = channelIterator3;
                keys = keys4;
                $this$produce = $this$produce4;
                channelsKt__DeprecatedKt$distinctBy$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$distinctBy$1.L$1 = keys;
                channelsKt__DeprecatedKt$distinctBy$1.L$2 = it;
                channelsKt__DeprecatedKt$distinctBy$1.L$3 = null;
                channelsKt__DeprecatedKt$distinctBy$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$distinctBy$1);
                if (hasNext != $result3) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}