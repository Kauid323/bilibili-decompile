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

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: Deprecated.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", "E", "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {374, 375, 375}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
public final class ChannelsKt__DeprecatedKt$mapIndexed$1<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<E> $this_mapIndexed;
    final /* synthetic */ Function3<Integer, E, Continuation<? super R>, Object> $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$mapIndexed$1(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super ChannelsKt__DeprecatedKt$mapIndexed$1> continuation) {
        super(2, continuation);
        this.$this_mapIndexed = receiveChannel;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$mapIndexed$1 channelsKt__DeprecatedKt$mapIndexed$1 = new ChannelsKt__DeprecatedKt$mapIndexed$1(this.$this_mapIndexed, this.$transform, continuation);
        channelsKt__DeprecatedKt$mapIndexed$1.L$0 = obj;
        return channelsKt__DeprecatedKt$mapIndexed$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((ProducerScope) ((ProducerScope) obj), continuation);
    }

    public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$mapIndexed$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bf  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00b9 -> B:10:0x0060). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ChannelsKt__DeprecatedKt$mapIndexed$1 channelsKt__DeprecatedKt$mapIndexed$1;
        ProducerScope $this$produce;
        int index;
        ChannelIterator it;
        ProducerScope $this$produce2;
        ChannelIterator channelIterator;
        ChannelsKt__DeprecatedKt$mapIndexed$1 channelsKt__DeprecatedKt$mapIndexed$12;
        Object obj;
        Object $result2;
        ProducerScope producerScope;
        ProducerScope $this$produce3;
        int index2;
        Object hasNext;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                channelsKt__DeprecatedKt$mapIndexed$1 = this;
                $this$produce = (ProducerScope) channelsKt__DeprecatedKt$mapIndexed$1.L$0;
                index = 0;
                it = channelsKt__DeprecatedKt$mapIndexed$1.$this_mapIndexed.iterator();
                channelsKt__DeprecatedKt$mapIndexed$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$mapIndexed$1.L$1 = it;
                channelsKt__DeprecatedKt$mapIndexed$1.I$0 = index;
                channelsKt__DeprecatedKt$mapIndexed$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$mapIndexed$1);
                if (hasNext == $result3) {
                    return $result3;
                }
                Object obj2 = $result3;
                $result2 = $result;
                $result = hasNext;
                channelIterator = it;
                $this$produce2 = $this$produce;
                channelsKt__DeprecatedKt$mapIndexed$12 = channelsKt__DeprecatedKt$mapIndexed$1;
                obj = obj2;
                if (((Boolean) $result).booleanValue()) {
                    return Unit.INSTANCE;
                }
                Object e = channelIterator.next();
                Function3<Integer, E, Continuation<? super R>, Object> function3 = channelsKt__DeprecatedKt$mapIndexed$12.$transform;
                index2 = index + 1;
                Integer boxInt = Boxing.boxInt(index);
                channelsKt__DeprecatedKt$mapIndexed$12.L$0 = $this$produce2;
                channelsKt__DeprecatedKt$mapIndexed$12.L$1 = channelIterator;
                channelsKt__DeprecatedKt$mapIndexed$12.L$2 = $this$produce2;
                channelsKt__DeprecatedKt$mapIndexed$12.I$0 = index2;
                channelsKt__DeprecatedKt$mapIndexed$12.label = 2;
                $result = function3.invoke(boxInt, e, channelsKt__DeprecatedKt$mapIndexed$12);
                if ($result == obj) {
                    return obj;
                }
                producerScope = $this$produce2;
                it = channelIterator;
                $this$produce3 = producerScope;
                channelsKt__DeprecatedKt$mapIndexed$12.L$0 = $this$produce3;
                channelsKt__DeprecatedKt$mapIndexed$12.L$1 = it;
                channelsKt__DeprecatedKt$mapIndexed$12.L$2 = null;
                channelsKt__DeprecatedKt$mapIndexed$12.I$0 = index2;
                channelsKt__DeprecatedKt$mapIndexed$12.label = 3;
                if (producerScope.send($result, channelsKt__DeprecatedKt$mapIndexed$12) != obj) {
                    return obj;
                }
                $result = $result2;
                $result3 = obj;
                channelsKt__DeprecatedKt$mapIndexed$1 = channelsKt__DeprecatedKt$mapIndexed$12;
                $this$produce = $this$produce3;
                index = index2;
                channelsKt__DeprecatedKt$mapIndexed$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$mapIndexed$1.L$1 = it;
                channelsKt__DeprecatedKt$mapIndexed$1.I$0 = index;
                channelsKt__DeprecatedKt$mapIndexed$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$mapIndexed$1);
                if (hasNext == $result3) {
                }
            case 1:
                int index3 = this.I$0;
                $this$produce2 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                channelIterator = (ChannelIterator) this.L$1;
                index = index3;
                channelsKt__DeprecatedKt$mapIndexed$12 = this;
                obj = $result3;
                $result2 = $result;
                if (((Boolean) $result).booleanValue()) {
                }
                break;
            case 2:
                int index4 = this.I$0;
                producerScope = (ProducerScope) this.L$2;
                it = (ChannelIterator) this.L$1;
                $this$produce3 = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure($result);
                index2 = index4;
                channelsKt__DeprecatedKt$mapIndexed$12 = this;
                obj = $result3;
                $result2 = $result;
                channelsKt__DeprecatedKt$mapIndexed$12.L$0 = $this$produce3;
                channelsKt__DeprecatedKt$mapIndexed$12.L$1 = it;
                channelsKt__DeprecatedKt$mapIndexed$12.L$2 = null;
                channelsKt__DeprecatedKt$mapIndexed$12.I$0 = index2;
                channelsKt__DeprecatedKt$mapIndexed$12.label = 3;
                if (producerScope.send($result, channelsKt__DeprecatedKt$mapIndexed$12) != obj) {
                }
                break;
            case 3:
                channelsKt__DeprecatedKt$mapIndexed$1 = this;
                int index5 = channelsKt__DeprecatedKt$mapIndexed$1.I$0;
                ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__DeprecatedKt$mapIndexed$1.L$1;
                ProducerScope $this$produce4 = (ProducerScope) channelsKt__DeprecatedKt$mapIndexed$1.L$0;
                ResultKt.throwOnFailure($result);
                index = index5;
                $this$produce = $this$produce4;
                it = channelIterator2;
                channelsKt__DeprecatedKt$mapIndexed$1.L$0 = $this$produce;
                channelsKt__DeprecatedKt$mapIndexed$1.L$1 = it;
                channelsKt__DeprecatedKt$mapIndexed$1.I$0 = index;
                channelsKt__DeprecatedKt$mapIndexed$1.label = 1;
                hasNext = it.hasNext(channelsKt__DeprecatedKt$mapIndexed$1);
                if (hasNext == $result3) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}