package kotlinx.coroutines.reactive;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.reactivestreams.Publisher;

/* compiled from: Channel.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0086H¢\u0006\u0002\u0010\u0006\u001a(\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a(\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u0001¨\u0006\f"}, d2 = {"collect", "", "T", "Lorg/reactivestreams/Publisher;", "action", "Lkotlin/Function1;", "(Lorg/reactivestreams/Publisher;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "request", "", "toChannel", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ChannelKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008d A[Catch: all -> 0x00ae, TryCatch #3 {all -> 0x00ae, blocks: (B:24:0x0085, B:26:0x008d, B:27:0x009d), top: B:45:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d A[Catch: all -> 0x00ae, TRY_LEAVE, TryCatch #3 {all -> 0x00ae, blocks: (B:24:0x0085, B:26:0x008d, B:27:0x009d), top: B:45:0x0085 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007b -> B:45:0x0085). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collect(Publisher<T> publisher, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        ChannelKt$collect$1 channelKt$collect$1;
        ChannelKt$collect$1 channelKt$collect$12;
        ReceiveChannel $this$consume$iv$iv;
        Object $result;
        Function1 action;
        ReceiveChannel $this$consume$iv$iv2;
        Throwable cause$iv$iv;
        ChannelIterator channelIterator;
        int i;
        boolean z;
        Object obj;
        if (continuation instanceof ChannelKt$collect$1) {
            channelKt$collect$1 = (ChannelKt$collect$1) continuation;
            if ((channelKt$collect$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                channelKt$collect$1.label -= IntCompanionObject.MIN_VALUE;
                channelKt$collect$12 = channelKt$collect$1;
                Object e$iv = channelKt$collect$12.result;
                Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (channelKt$collect$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(e$iv);
                        ReceiveChannel $this$consumeEach$iv = toChannel$default(publisher, 0, 1, null);
                        $this$consume$iv$iv = $this$consumeEach$iv;
                        Throwable cause$iv$iv2 = null;
                        try {
                            ChannelIterator it = $this$consume$iv$iv.iterator();
                            boolean z2 = false;
                            Function1 action2 = function1;
                            int $i$f$consume = 0;
                            channelKt$collect$12.L$0 = action2;
                            channelKt$collect$12.L$1 = $this$consume$iv$iv;
                            channelKt$collect$12.L$2 = it;
                            channelKt$collect$12.label = 1;
                            Object hasNext = it.hasNext(channelKt$collect$12);
                            if (hasNext != $result2) {
                                return $result2;
                            }
                            Object obj2 = $result2;
                            $result = e$iv;
                            e$iv = hasNext;
                            action = action2;
                            $this$consume$iv$iv2 = $this$consume$iv$iv;
                            cause$iv$iv = cause$iv$iv2;
                            channelIterator = it;
                            i = $i$f$consume;
                            z = z2;
                            obj = obj2;
                            try {
                                if (((Boolean) e$iv).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv);
                                    InlineMarker.finallyEnd(1);
                                    return Unit.INSTANCE;
                                }
                                action.invoke((Object) channelIterator.next());
                                e$iv = $result;
                                $result2 = obj;
                                z2 = z;
                                $i$f$consume = i;
                                it = channelIterator;
                                cause$iv$iv2 = cause$iv$iv;
                                $this$consume$iv$iv = $this$consume$iv$iv2;
                                action2 = action;
                                channelKt$collect$12.L$0 = action2;
                                channelKt$collect$12.L$1 = $this$consume$iv$iv;
                                channelKt$collect$12.L$2 = it;
                                channelKt$collect$12.label = 1;
                                Object hasNext2 = it.hasNext(channelKt$collect$12);
                                if (hasNext2 != $result2) {
                                }
                            } catch (Throwable th) {
                                $this$consume$iv$iv = $this$consume$iv$iv2;
                                e$iv$iv = th;
                                Throwable cause$iv$iv3 = e$iv$iv;
                                try {
                                    throw e$iv$iv;
                                } catch (Throwable e$iv$iv) {
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv3);
                                    InlineMarker.finallyEnd(1);
                                    throw e$iv$iv;
                                }
                            }
                        } catch (Throwable th2) {
                            e$iv$iv = th2;
                            Throwable cause$iv$iv32 = e$iv$iv;
                            throw e$iv$iv;
                        }
                    case 1:
                        ChannelIterator channelIterator2 = (ChannelIterator) channelKt$collect$12.L$2;
                        $this$consume$iv$iv = (ReceiveChannel) channelKt$collect$12.L$1;
                        Function1 action3 = (Function1) channelKt$collect$12.L$0;
                        try {
                            ResultKt.throwOnFailure(e$iv);
                            action = action3;
                            $this$consume$iv$iv2 = $this$consume$iv$iv;
                            cause$iv$iv = null;
                            channelIterator = channelIterator2;
                            i = 0;
                            z = false;
                            obj = $result2;
                            $result = e$iv;
                            if (((Boolean) e$iv).booleanValue()) {
                            }
                        } catch (Throwable th3) {
                            e$iv$iv = th3;
                            Throwable cause$iv$iv322 = e$iv$iv;
                            throw e$iv$iv;
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelKt$collect$1 = new ChannelKt$collect$1(continuation);
        channelKt$collect$12 = channelKt$collect$1;
        Object e$iv2 = channelKt$collect$12.result;
        Object $result22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (channelKt$collect$12.label) {
        }
    }

    private static final <T> Object collect$$forInline(Publisher<T> publisher, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel $this$consumeEach$iv = toChannel$default(publisher, 0, 1, null);
        try {
            ReceiveChannel $this$consumeEach_u24lambda_u241$iv = $this$consumeEach$iv;
            ChannelIterator it = $this$consumeEach_u24lambda_u241$iv.iterator();
            while (true) {
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(null);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed($this$consumeEach$iv, null);
                    InlineMarker.finallyEnd(1);
                    Unit unit2 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                }
                Object e$iv = (Object) it.next();
                function1.invoke(e$iv);
            }
        } finally {
        }
    }

    public static /* synthetic */ ReceiveChannel toChannel$default(Publisher publisher, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return toChannel(publisher, i);
    }

    public static final <T> ReceiveChannel<T> toChannel(Publisher<T> publisher, int request) {
        SubscriptionChannel channel = new SubscriptionChannel(request);
        publisher.subscribe(channel);
        return channel;
    }

    public static /* synthetic */ ReceiveChannel openSubscription$default(Publisher publisher, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return openSubscription(publisher, i);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Transforming publisher to channel is deprecated, use asFlow() instead")
    public static final /* synthetic */ ReceiveChannel openSubscription(Publisher $this$openSubscription, int request) {
        SubscriptionChannel channel = new SubscriptionChannel(request);
        $this$openSubscription.subscribe(channel);
        return channel;
    }
}