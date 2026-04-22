package kotlinx.coroutines.channels;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

/* compiled from: BroadcastChannel.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2", f = "BroadcastChannel.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {})
final class BroadcastChannelImpl$registerSelectForSend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $element;
    final /* synthetic */ SelectInstance<?> $select;
    int label;
    final /* synthetic */ BroadcastChannelImpl<E> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastChannelImpl$registerSelectForSend$2(BroadcastChannelImpl<E> broadcastChannelImpl, Object obj, SelectInstance<?> selectInstance, Continuation<? super BroadcastChannelImpl$registerSelectForSend$2> continuation) {
        super(2, continuation);
        this.this$0 = broadcastChannelImpl;
        this.$element = obj;
        this.$select = selectInstance;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BroadcastChannelImpl$registerSelectForSend$2(this.this$0, this.$element, this.$select, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BroadcastChannelImpl$registerSelectForSend$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0064 A[Catch: all -> 0x00b1, TryCatch #0 {all -> 0x00b1, blocks: (B:27:0x005e, B:29:0x0064, B:34:0x0073, B:35:0x0078, B:36:0x0079, B:38:0x0081, B:40:0x0088, B:42:0x00a1, B:43:0x00a8, B:39:0x0084), top: B:50:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0081 A[Catch: all -> 0x00b1, TryCatch #0 {all -> 0x00b1, blocks: (B:27:0x005e, B:29:0x0064, B:34:0x0073, B:35:0x0078, B:36:0x0079, B:38:0x0081, B:40:0x0088, B:42:0x00a1, B:43:0x00a8, B:39:0x0084), top: B:50:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0084 A[Catch: all -> 0x00b1, TryCatch #0 {all -> 0x00b1, blocks: (B:27:0x005e, B:29:0x0064, B:34:0x0073, B:35:0x0078, B:36:0x0079, B:38:0x0081, B:40:0x0088, B:42:0x00a1, B:43:0x00a8, B:39:0x0084), top: B:50:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a1 A[Catch: all -> 0x00b1, TryCatch #0 {all -> 0x00b1, blocks: (B:27:0x005e, B:29:0x0064, B:34:0x0073, B:35:0x0078, B:36:0x0079, B:38:0x0081, B:40:0x0088, B:42:0x00a1, B:43:0x00a8, B:39:0x0084), top: B:50:0x005e }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Throwable t;
        BroadcastChannelImpl$registerSelectForSend$2 broadcastChannelImpl$registerSelectForSend$2;
        BroadcastChannelImpl$registerSelectForSend$2 success;
        BroadcastChannelImpl<E> broadcastChannelImpl;
        SelectInstance<?> selectInstance;
        ReentrantLock reentrantLock;
        HashMap hashMap;
        TrySelectDetailedResult trySelectResult;
        HashMap hashMap2;
        HashMap hashMap3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    this.label = 1;
                } catch (Throwable th) {
                    t = th;
                    broadcastChannelImpl$registerSelectForSend$2 = this;
                    break;
                }
                if (this.this$0.send(this.$element, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                broadcastChannelImpl$registerSelectForSend$2 = this;
                success = 1;
                ReentrantLock $this$withLock$iv = ((BroadcastChannelImpl) broadcastChannelImpl$registerSelectForSend$2.this$0).lock;
                broadcastChannelImpl = broadcastChannelImpl$registerSelectForSend$2.this$0;
                selectInstance = broadcastChannelImpl$registerSelectForSend$2.$select;
                reentrantLock = $this$withLock$iv;
                reentrantLock.lock();
                try {
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        hashMap3 = ((BroadcastChannelImpl) broadcastChannelImpl).onSendInternalResult;
                        if (!(hashMap3.get(selectInstance) == null)) {
                            throw new AssertionError();
                        }
                    }
                    hashMap = ((BroadcastChannelImpl) broadcastChannelImpl).onSendInternalResult;
                    hashMap.put(selectInstance, success != null ? Unit.INSTANCE : BufferedChannelKt.getCHANNEL_CLOSED());
                    Intrinsics.checkNotNull(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
                    SelectImplementation selectImplementation = (SelectImplementation) selectInstance;
                    trySelectResult = ((SelectImplementation) selectInstance).trySelectDetailed(broadcastChannelImpl, Unit.INSTANCE);
                    if (trySelectResult != TrySelectDetailedResult.REREGISTER) {
                        hashMap2 = ((BroadcastChannelImpl) broadcastChannelImpl).onSendInternalResult;
                        hashMap2.remove(selectInstance);
                    }
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    reentrantLock.unlock();
                    throw th2;
                }
            case 1:
                broadcastChannelImpl$registerSelectForSend$2 = this;
                try {
                    ResultKt.throwOnFailure($result);
                    success = 1;
                } catch (Throwable th3) {
                    t = th3;
                    break;
                }
                ReentrantLock $this$withLock$iv2 = ((BroadcastChannelImpl) broadcastChannelImpl$registerSelectForSend$2.this$0).lock;
                broadcastChannelImpl = broadcastChannelImpl$registerSelectForSend$2.this$0;
                selectInstance = broadcastChannelImpl$registerSelectForSend$2.$select;
                reentrantLock = $this$withLock$iv2;
                reentrantLock.lock();
                if (DebugKt.getASSERTIONS_ENABLED()) {
                }
                hashMap = ((BroadcastChannelImpl) broadcastChannelImpl).onSendInternalResult;
                hashMap.put(selectInstance, success != null ? Unit.INSTANCE : BufferedChannelKt.getCHANNEL_CLOSED());
                Intrinsics.checkNotNull(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
                SelectImplementation selectImplementation2 = (SelectImplementation) selectInstance;
                trySelectResult = ((SelectImplementation) selectInstance).trySelectDetailed(broadcastChannelImpl, Unit.INSTANCE);
                if (trySelectResult != TrySelectDetailedResult.REREGISTER) {
                }
                Unit unit2 = Unit.INSTANCE;
                reentrantLock.unlock();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!broadcastChannelImpl$registerSelectForSend$2.this$0.isClosedForSend() || (!(t instanceof ClosedSendChannelException) && broadcastChannelImpl$registerSelectForSend$2.this$0.getSendException() != t)) {
            throw t;
        }
        success = null;
        ReentrantLock $this$withLock$iv22 = ((BroadcastChannelImpl) broadcastChannelImpl$registerSelectForSend$2.this$0).lock;
        broadcastChannelImpl = broadcastChannelImpl$registerSelectForSend$2.this$0;
        selectInstance = broadcastChannelImpl$registerSelectForSend$2.$select;
        reentrantLock = $this$withLock$iv22;
        reentrantLock.lock();
        if (DebugKt.getASSERTIONS_ENABLED()) {
        }
        hashMap = ((BroadcastChannelImpl) broadcastChannelImpl).onSendInternalResult;
        hashMap.put(selectInstance, success != null ? Unit.INSTANCE : BufferedChannelKt.getCHANNEL_CLOSED());
        Intrinsics.checkNotNull(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        SelectImplementation selectImplementation22 = (SelectImplementation) selectInstance;
        trySelectResult = ((SelectImplementation) selectInstance).trySelectDetailed(broadcastChannelImpl, Unit.INSTANCE);
        if (trySelectResult != TrySelectDetailedResult.REREGISTER) {
        }
        Unit unit22 = Unit.INSTANCE;
        reentrantLock.unlock();
        return Unit.INSTANCE;
    }
}