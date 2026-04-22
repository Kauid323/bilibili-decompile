package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;

/* compiled from: BroadcastChannel.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u000245B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!H\u0010¢\u0006\u0002\b\"J\u0012\u0010#\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u001e\u0010&\u001a\u00020'2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030\u00132\b\u0010)\u001a\u0004\u0018\u00010\rH\u0014J\u0016\u0010*\u001a\u00020'2\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0002J\u0016\u0010,\u001a\u00020'2\u0006\u0010)\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020/H\u0016J#\u00100\u001a\b\u0012\u0004\u0012\u00020'012\u0006\u0010)\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0011\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\u0004\u0018\u00018\u00008F¢\u0006\f\u0012\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "capacity", "", "(I)V", "getCapacity", "()I", "isClosedForSend", "", "()Z", "lastConflatedElement", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "onSendInternalResult", "Ljava/util/HashMap;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/collections/HashMap;", "subscribers", "", "value", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "valueOrNull", "getValueOrNull$annotations", "getValueOrNull", "cancelImpl", "cause", "", "cancelImpl$kotlinx_coroutines_core", "close", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "registerSelectForSend", "", "select", "element", "removeSubscriber", "s", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "SubscriberBuffered", "SubscriberConflated", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BroadcastChannelImpl<E> extends BufferedChannel<E> implements BroadcastChannel<E> {
    private final int capacity;
    private Object lastConflatedElement;
    private final ReentrantLock lock;
    private final HashMap<SelectInstance<?>, Object> onSendInternalResult;
    private List<? extends BufferedChannel<E>> subscribers;

    public static /* synthetic */ void getValue$annotations() {
    }

    public static /* synthetic */ void getValueOrNull$annotations() {
    }

    public final int getCapacity() {
        return this.capacity;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastChannelImpl(int capacity) {
        super(0, null);
        Symbol symbol;
        boolean z = false;
        this.capacity = capacity;
        if (!((this.capacity >= 1 || this.capacity == -1) ? true : z)) {
            throw new IllegalArgumentException(("BroadcastChannel capacity must be positive or Channel.CONFLATED, but " + this.capacity + " was specified").toString());
        }
        this.lock = new ReentrantLock();
        this.subscribers = CollectionsKt.emptyList();
        symbol = BroadcastChannelKt.NO_ELEMENT;
        this.lastConflatedElement = symbol;
        this.onSendInternalResult = new HashMap<>();
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        Symbol symbol;
        Symbol symbol2;
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            BufferedChannel s = this.capacity == -1 ? new SubscriberConflated() : new SubscriberBuffered();
            if (isClosedForSend()) {
                Object obj = this.lastConflatedElement;
                symbol2 = BroadcastChannelKt.NO_ELEMENT;
                if (obj == symbol2) {
                    s.close(getCloseCause());
                    return s;
                }
            }
            Object obj2 = this.lastConflatedElement;
            symbol = BroadcastChannelKt.NO_ELEMENT;
            if (obj2 != symbol) {
                s.mo1399trySendJP2dKIU(getValue());
            }
            this.subscribers = CollectionsKt.plus((Collection<? extends BufferedChannel>) this.subscribers, s);
            reentrantLock.unlock();
            return s;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSubscriber(ReceiveChannel<? extends E> receiveChannel) {
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            Iterable<Object> $this$filter$iv = this.subscribers;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                BufferedChannel it = (BufferedChannel) element$iv$iv;
                if (it != receiveChannel) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            this.subscribers = (List) destination$iv$iv;
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x008a -> B:27:0x008e). Please submit an issue!!! */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object send(E e, Continuation<? super Unit> continuation) {
        BroadcastChannelImpl$send$1 broadcastChannelImpl$send$1;
        BroadcastChannelImpl$send$1 broadcastChannelImpl$send$12;
        Iterator it;
        BroadcastChannelImpl broadcastChannelImpl;
        E e2;
        Object $result;
        Object obj;
        E e3;
        boolean success;
        if (continuation instanceof BroadcastChannelImpl$send$1) {
            broadcastChannelImpl$send$1 = (BroadcastChannelImpl$send$1) continuation;
            if ((broadcastChannelImpl$send$1.label & IntCompanionObject.MIN_VALUE) != 0) {
                broadcastChannelImpl$send$1.label -= IntCompanionObject.MIN_VALUE;
                broadcastChannelImpl$send$12 = broadcastChannelImpl$send$1;
                Object $result2 = broadcastChannelImpl$send$12.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (broadcastChannelImpl$send$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        ReentrantLock $this$withLock$iv = this.lock;
                        ReentrantLock reentrantLock = $this$withLock$iv;
                        reentrantLock.lock();
                        try {
                            if (isClosedForSend()) {
                                throw getSendException();
                            }
                            if (this.capacity == -1) {
                                this.lastConflatedElement = e;
                            }
                            Iterable subs = this.subscribers;
                            reentrantLock.unlock();
                            Iterable $this$forEach$iv = subs;
                            it = $this$forEach$iv.iterator();
                            broadcastChannelImpl = this;
                            e2 = e;
                            if (it.hasNext()) {
                                Object element$iv = it.next();
                                BufferedChannel it2 = (BufferedChannel) element$iv;
                                broadcastChannelImpl$send$12.L$0 = broadcastChannelImpl;
                                broadcastChannelImpl$send$12.L$1 = e2;
                                broadcastChannelImpl$send$12.L$2 = it;
                                broadcastChannelImpl$send$12.label = 1;
                                Object sendBroadcast$kotlinx_coroutines_core = it2.sendBroadcast$kotlinx_coroutines_core(e2, broadcastChannelImpl$send$12);
                                if (sendBroadcast$kotlinx_coroutines_core == $result3) {
                                    return $result3;
                                }
                                Object obj2 = $result3;
                                $result = $result2;
                                $result2 = sendBroadcast$kotlinx_coroutines_core;
                                obj = obj2;
                                e3 = e2;
                                success = ((Boolean) $result2).booleanValue();
                                if (success && broadcastChannelImpl.isClosedForSend()) {
                                    throw broadcastChannelImpl.getSendException();
                                }
                                $result2 = $result;
                                $result3 = obj;
                                e2 = e3;
                                if (it.hasNext()) {
                                    return Unit.INSTANCE;
                                }
                            }
                        } catch (Throwable th) {
                            reentrantLock.unlock();
                            throw th;
                        }
                        break;
                    case 1:
                        it = (Iterator) broadcastChannelImpl$send$12.L$2;
                        Object obj3 = broadcastChannelImpl$send$12.L$1;
                        broadcastChannelImpl = (BroadcastChannelImpl) broadcastChannelImpl$send$12.L$0;
                        ResultKt.throwOnFailure($result2);
                        obj = $result3;
                        $result = $result2;
                        e3 = obj3;
                        success = ((Boolean) $result2).booleanValue();
                        if (success) {
                            break;
                        }
                        $result2 = $result;
                        $result3 = obj;
                        e2 = e3;
                        if (it.hasNext()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        broadcastChannelImpl$send$1 = new BroadcastChannelImpl$send$1(this, continuation);
        broadcastChannelImpl$send$12 = broadcastChannelImpl$send$1;
        Object $result22 = broadcastChannelImpl$send$12.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (broadcastChannelImpl$send$12.label) {
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    public Object mo1399trySendJP2dKIU(E e) {
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            if (isClosedForSend()) {
                return super.mo1399trySendJP2dKIU(e);
            }
            Iterable $this$any$iv = this.subscribers;
            boolean z = false;
            if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                Iterator<T> it = $this$any$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object element$iv = it.next();
                    BufferedChannel it2 = (BufferedChannel) element$iv;
                    if (it2.shouldSendSuspend$kotlinx_coroutines_core()) {
                        z = true;
                        break;
                    }
                }
            }
            boolean shouldSuspend = z;
            if (shouldSuspend) {
                return ChannelResult.Companion.m1424failurePtdJZtk();
            }
            if (this.capacity == -1) {
                this.lastConflatedElement = e;
            }
            Iterable $this$forEach$iv = this.subscribers;
            for (Object element$iv2 : $this$forEach$iv) {
                BufferedChannel it3 = (BufferedChannel) element$iv2;
                it3.mo1399trySendJP2dKIU(e);
            }
            return ChannelResult.Companion.m1425successJP2dKIU(Unit.INSTANCE);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void registerSelectForSend(SelectInstance<?> selectInstance, Object element) {
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            Object result = this.onSendInternalResult.remove(selectInstance);
            if (result != null) {
                selectInstance.selectInRegistrationPhase(result);
                return;
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(selectInstance.getContext()), null, CoroutineStart.UNDISPATCHED, new BroadcastChannelImpl$registerSelectForSend$2(this, element, selectInstance, null), 1, null);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            Iterable $this$forEach$iv = this.subscribers;
            for (Object element$iv : $this$forEach$iv) {
                BufferedChannel it = (BufferedChannel) element$iv;
                it.close(cause);
            }
            Iterable $this$forEach$iv2 = this.subscribers;
            Iterable<Object> $this$filter$iv = $this$forEach$iv2;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                BufferedChannel it2 = (BufferedChannel) element$iv$iv;
                if (it2.hasElements$kotlinx_coroutines_core()) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            this.subscribers = (List) destination$iv$iv;
            return super.close(cause);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean cancelImpl$kotlinx_coroutines_core(Throwable cause) {
        Symbol symbol;
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            Iterable $this$forEach$iv = this.subscribers;
            for (Object element$iv : $this$forEach$iv) {
                BufferedChannel it = (BufferedChannel) element$iv;
                it.cancelImpl$kotlinx_coroutines_core(cause);
            }
            symbol = BroadcastChannelKt.NO_ELEMENT;
            this.lastConflatedElement = symbol;
            return super.cancelImpl$kotlinx_coroutines_core(cause);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            return super.isClosedForSend();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* compiled from: BroadcastChannel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered;", "Lkotlinx/coroutines/channels/BufferedChannel;", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "cancelImpl", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private final class SubscriberBuffered extends BufferedChannel<E> {
        public SubscriberBuffered() {
            super(BroadcastChannelImpl.this.getCapacity(), null, 2, null);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        /* renamed from: cancelImpl */
        public boolean cancelImpl$kotlinx_coroutines_core(Throwable cause) {
            ReentrantLock $this$withLock$iv = ((BroadcastChannelImpl) BroadcastChannelImpl.this).lock;
            BroadcastChannelImpl<E> broadcastChannelImpl = BroadcastChannelImpl.this;
            ReentrantLock reentrantLock = $this$withLock$iv;
            reentrantLock.lock();
            try {
                broadcastChannelImpl.removeSubscriber(this);
                return super.cancelImpl$kotlinx_coroutines_core(cause);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* compiled from: BroadcastChannel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberConflated;", "Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "cancelImpl", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private final class SubscriberConflated extends ConflatedBufferedChannel<E> {
        public SubscriberConflated() {
            super(1, BufferOverflow.DROP_OLDEST, null, 4, null);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        /* renamed from: cancelImpl */
        public boolean cancelImpl$kotlinx_coroutines_core(Throwable cause) {
            BroadcastChannelImpl.this.removeSubscriber(this);
            return super.cancelImpl$kotlinx_coroutines_core(cause);
        }
    }

    public final E getValue() {
        Symbol symbol;
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            if (isClosedForSend()) {
                Throwable closeCause = getCloseCause();
                if (closeCause == null) {
                    throw new IllegalStateException("This broadcast channel is closed");
                }
                throw closeCause;
            }
            Object obj = this.lastConflatedElement;
            symbol = BroadcastChannelKt.NO_ELEMENT;
            if (obj == symbol) {
                throw new IllegalStateException("No value".toString());
            }
            return (E) this.lastConflatedElement;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final E getValueOrNull() {
        Symbol symbol;
        ReentrantLock $this$withLock$iv = this.lock;
        ReentrantLock reentrantLock = $this$withLock$iv;
        reentrantLock.lock();
        try {
            E e = null;
            if (!isClosedForReceive()) {
                Object obj = this.lastConflatedElement;
                symbol = BroadcastChannelKt.NO_ELEMENT;
                if (obj != symbol) {
                    e = (E) this.lastConflatedElement;
                }
            }
            return e;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public String toString() {
        Symbol symbol;
        StringBuilder sb = new StringBuilder();
        Object obj = this.lastConflatedElement;
        symbol = BroadcastChannelKt.NO_ELEMENT;
        return sb.append(obj != symbol ? "CONFLATED_ELEMENT=" + this.lastConflatedElement + "; " : "").append("BROADCAST=<").append(super.toString()).append(">; SUBSCRIBERS=").append(CollectionsKt.joinToString$default(this.subscribers, ";", "<", ">", 0, null, null, 56, null)).toString();
    }
}