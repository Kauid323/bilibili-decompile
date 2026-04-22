package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.ObservableSource;
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

/* compiled from: RxChannel.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a:\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\b\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0086Hø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u0006\u001a:\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\b\u0002H\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0086Hø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\b\u001a#\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\b\u0002H\u00020\u0003H\u0001ø\u0001\u0001\u001a#\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\b\u0002H\u00020\u0007H\u0001ø\u0001\u0001\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b9¨\u0006\u000b"}, d2 = {"collect", "", "T", "Lio/reactivex/rxjava3/core/MaybeSource;", "action", "Lkotlin/Function1;", "(Lio/reactivex/rxjava3/core/MaybeSource;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/reactivex/rxjava3/core/ObservableSource;", "(Lio/reactivex/rxjava3/core/ObservableSource;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-rx3"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RxChannelKt {
    public static final <T> ReceiveChannel<T> openSubscription(MaybeSource<T> maybeSource) {
        SubscriptionChannel channel = new SubscriptionChannel();
        maybeSource.subscribe(channel);
        return channel;
    }

    public static final <T> ReceiveChannel<T> openSubscription(ObservableSource<T> observableSource) {
        SubscriptionChannel channel = new SubscriptionChannel();
        observableSource.subscribe(channel);
        return channel;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b A[Catch: all -> 0x00ac, TryCatch #3 {all -> 0x00ac, blocks: (B:24:0x0083, B:26:0x008b, B:27:0x009b), top: B:45:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009b A[Catch: all -> 0x00ac, TRY_LEAVE, TryCatch #3 {all -> 0x00ac, blocks: (B:24:0x0083, B:26:0x008b, B:27:0x009b), top: B:45:0x0083 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0079 -> B:45:0x0083). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collect(MaybeSource<T> maybeSource, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        RxChannelKt$collect$1 rxChannelKt$collect$1;
        RxChannelKt$collect$1 rxChannelKt$collect$12;
        ReceiveChannel $this$consume$iv$iv;
        Object $result;
        Function1 action;
        ReceiveChannel $this$consume$iv$iv2;
        Throwable cause$iv$iv;
        ChannelIterator channelIterator;
        int i;
        boolean z;
        Object obj;
        if (continuation instanceof RxChannelKt$collect$1) {
            rxChannelKt$collect$1 = (RxChannelKt$collect$1) continuation;
            if ((rxChannelKt$collect$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                rxChannelKt$collect$1.label -= IntCompanionObject.MIN_VALUE;
                rxChannelKt$collect$12 = rxChannelKt$collect$1;
                Object e$iv = rxChannelKt$collect$12.result;
                Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rxChannelKt$collect$12.label) {
                    case 0:
                        ResultKt.throwOnFailure(e$iv);
                        ReceiveChannel $this$consumeEach$iv = openSubscription(maybeSource);
                        $this$consume$iv$iv = $this$consumeEach$iv;
                        Throwable cause$iv$iv2 = null;
                        try {
                            ChannelIterator it = $this$consume$iv$iv.iterator();
                            boolean z2 = false;
                            Function1 action2 = function1;
                            int $i$f$consume = 0;
                            rxChannelKt$collect$12.L$0 = action2;
                            rxChannelKt$collect$12.L$1 = $this$consume$iv$iv;
                            rxChannelKt$collect$12.L$2 = it;
                            rxChannelKt$collect$12.label = 1;
                            Object hasNext = it.hasNext(rxChannelKt$collect$12);
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
                                rxChannelKt$collect$12.L$0 = action2;
                                rxChannelKt$collect$12.L$1 = $this$consume$iv$iv;
                                rxChannelKt$collect$12.L$2 = it;
                                rxChannelKt$collect$12.label = 1;
                                Object hasNext2 = it.hasNext(rxChannelKt$collect$12);
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
                        ChannelIterator channelIterator2 = (ChannelIterator) rxChannelKt$collect$12.L$2;
                        $this$consume$iv$iv = (ReceiveChannel) rxChannelKt$collect$12.L$1;
                        Function1 action3 = (Function1) rxChannelKt$collect$12.L$0;
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
        rxChannelKt$collect$1 = new RxChannelKt$collect$1(continuation);
        rxChannelKt$collect$12 = rxChannelKt$collect$1;
        Object e$iv2 = rxChannelKt$collect$12.result;
        Object $result22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rxChannelKt$collect$12.label) {
        }
    }

    private static final <T> Object collect$$forInline(MaybeSource<T> maybeSource, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel $this$consumeEach$iv = openSubscription(maybeSource);
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b A[Catch: all -> 0x00ac, TryCatch #3 {all -> 0x00ac, blocks: (B:24:0x0083, B:26:0x008b, B:27:0x009b), top: B:45:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009b A[Catch: all -> 0x00ac, TRY_LEAVE, TryCatch #3 {all -> 0x00ac, blocks: (B:24:0x0083, B:26:0x008b, B:27:0x009b), top: B:45:0x0083 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0079 -> B:45:0x0083). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collect(ObservableSource<T> observableSource, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        RxChannelKt$collect$2 rxChannelKt$collect$2;
        RxChannelKt$collect$2 rxChannelKt$collect$22;
        ReceiveChannel $this$consume$iv$iv;
        Object $result;
        Function1 action;
        ReceiveChannel $this$consume$iv$iv2;
        Throwable cause$iv$iv;
        ChannelIterator channelIterator;
        int i;
        boolean z;
        Object obj;
        if (continuation instanceof RxChannelKt$collect$2) {
            rxChannelKt$collect$2 = (RxChannelKt$collect$2) continuation;
            if ((rxChannelKt$collect$2.label & IntCompanionObject.MIN_VALUE) != 0) {
                rxChannelKt$collect$2.label -= IntCompanionObject.MIN_VALUE;
                rxChannelKt$collect$22 = rxChannelKt$collect$2;
                Object e$iv = rxChannelKt$collect$22.result;
                Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (rxChannelKt$collect$22.label) {
                    case 0:
                        ResultKt.throwOnFailure(e$iv);
                        ReceiveChannel $this$consumeEach$iv = openSubscription(observableSource);
                        $this$consume$iv$iv = $this$consumeEach$iv;
                        Throwable cause$iv$iv2 = null;
                        try {
                            ChannelIterator it = $this$consume$iv$iv.iterator();
                            boolean z2 = false;
                            Function1 action2 = function1;
                            int $i$f$consume = 0;
                            rxChannelKt$collect$22.L$0 = action2;
                            rxChannelKt$collect$22.L$1 = $this$consume$iv$iv;
                            rxChannelKt$collect$22.L$2 = it;
                            rxChannelKt$collect$22.label = 1;
                            Object hasNext = it.hasNext(rxChannelKt$collect$22);
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
                                rxChannelKt$collect$22.L$0 = action2;
                                rxChannelKt$collect$22.L$1 = $this$consume$iv$iv;
                                rxChannelKt$collect$22.L$2 = it;
                                rxChannelKt$collect$22.label = 1;
                                Object hasNext2 = it.hasNext(rxChannelKt$collect$22);
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
                        ChannelIterator channelIterator2 = (ChannelIterator) rxChannelKt$collect$22.L$2;
                        $this$consume$iv$iv = (ReceiveChannel) rxChannelKt$collect$22.L$1;
                        Function1 action3 = (Function1) rxChannelKt$collect$22.L$0;
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
        rxChannelKt$collect$2 = new RxChannelKt$collect$2(continuation);
        rxChannelKt$collect$22 = rxChannelKt$collect$2;
        Object e$iv2 = rxChannelKt$collect$22.result;
        Object $result22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (rxChannelKt$collect$22.label) {
        }
    }

    private static final <T> Object collect$$forInline(ObservableSource<T> observableSource, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel $this$consumeEach$iv = openSubscription(observableSource);
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
}