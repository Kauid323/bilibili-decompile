package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;

/* compiled from: Channel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u000e\u0010\u0003\u001a\u00020\u0004H¦B¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000H\u0097@¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ChannelIterator;", "E", "", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "next", "()Ljava/lang/Object;", "next0", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ChannelIterator<E> {
    Object hasNext(Continuation<? super Boolean> continuation);

    E next();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
    /* synthetic */ Object next(Continuation continuation);

    /* compiled from: Channel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:32:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0052  */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ Object next(ChannelIterator $this, Continuation continuation) {
            ChannelIterator$next0$1 channelIterator$next0$1;
            ChannelIterator$next0$1 channelIterator$next0$12;
            Object hasNext;
            if (continuation instanceof ChannelIterator$next0$1) {
                channelIterator$next0$1 = (ChannelIterator$next0$1) continuation;
                if ((channelIterator$next0$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                    channelIterator$next0$1.label -= IntCompanionObject.MIN_VALUE;
                    channelIterator$next0$12 = channelIterator$next0$1;
                    Object $result = channelIterator$next0$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (channelIterator$next0$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            channelIterator$next0$12.L$0 = $this;
                            channelIterator$next0$12.label = 1;
                            hasNext = $this.hasNext(channelIterator$next0$12);
                            if (hasNext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            $this = (ChannelIterator) channelIterator$next0$12.L$0;
                            ResultKt.throwOnFailure($result);
                            hasNext = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    if (((Boolean) hasNext).booleanValue()) {
                        throw new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
                    }
                    return $this.next();
                }
            }
            channelIterator$next0$1 = new ChannelIterator$next0$1(continuation);
            channelIterator$next0$12 = channelIterator$next0$1;
            Object $result2 = channelIterator$next0$12.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (channelIterator$next0$12.label) {
            }
            if (((Boolean) hasNext).booleanValue()) {
            }
        }
    }
}