package io.ktor.events;

import io.ktor.util.collections.CopyOnWriteHashMap;
import io.ktor.util.internal.LockFreeLinkedListHead;
import io.ktor.util.internal.LockFreeLinkedListNode;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DisposableHandle;

/* compiled from: Events.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\t¢\u0006\u0004\b\f\u0010\rJ?\u0010\u000e\u001a\u00020\b\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\t¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0011\u001a\u00020\b\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lio/ktor/events/Events;", "", "<init>", "()V", "T", "Lio/ktor/events/EventDefinition;", "definition", "Lkotlin/Function1;", "", "Lio/ktor/events/EventHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "subscribe", "(Lio/ktor/events/EventDefinition;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "unsubscribe", "(Lio/ktor/events/EventDefinition;Lkotlin/jvm/functions/Function1;)V", "value", "raise", "(Lio/ktor/events/EventDefinition;Ljava/lang/Object;)V", "Lio/ktor/util/collections/CopyOnWriteHashMap;", "Lio/ktor/util/internal/LockFreeLinkedListHead;", "handlers", "Lio/ktor/util/collections/CopyOnWriteHashMap;", "HandlerRegistration", "ktor-events"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Events {
    private final CopyOnWriteHashMap<EventDefinition<?>, LockFreeLinkedListHead> handlers = new CopyOnWriteHashMap<>();

    public final <T> DisposableHandle subscribe(EventDefinition<T> eventDefinition, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(eventDefinition, "definition");
        Intrinsics.checkNotNullParameter(function1, "handler");
        HandlerRegistration registration = new HandlerRegistration(function1);
        ((LockFreeLinkedListHead) this.handlers.computeIfAbsent(eventDefinition, new Function1() { // from class: io.ktor.events.Events$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                LockFreeLinkedListHead subscribe$lambda$0;
                subscribe$lambda$0 = Events.subscribe$lambda$0((EventDefinition) obj);
                return subscribe$lambda$0;
            }
        })).addLast(registration);
        return registration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LockFreeLinkedListHead subscribe$lambda$0(EventDefinition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new LockFreeLinkedListHead();
    }

    public final <T> void unsubscribe(EventDefinition<T> eventDefinition, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(eventDefinition, "definition");
        Intrinsics.checkNotNullParameter(function1, "handler");
        LockFreeLinkedListHead this_$iv = (LockFreeLinkedListHead) this.handlers.get(eventDefinition);
        if (this_$iv == null) {
            return;
        }
        Object next = this_$iv.getNext();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
        for (LockFreeLinkedListNode cur$iv = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(cur$iv, this_$iv); cur$iv = cur$iv.getNextNode()) {
            if (cur$iv instanceof HandlerRegistration) {
                HandlerRegistration it = (HandlerRegistration) cur$iv;
                if (Intrinsics.areEqual(it.getHandler(), function1)) {
                    it.remove();
                }
            }
        }
    }

    public final <T> void raise(EventDefinition<T> eventDefinition, T t) {
        Intrinsics.checkNotNullParameter(eventDefinition, "definition");
        Throwable th = null;
        LockFreeLinkedListHead this_$iv = (LockFreeLinkedListHead) this.handlers.get(eventDefinition);
        if (this_$iv != null) {
            Object next = this_$iv.getNext();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode");
            for (LockFreeLinkedListNode cur$iv = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(cur$iv, this_$iv); cur$iv = cur$iv.getNextNode()) {
                if (cur$iv instanceof HandlerRegistration) {
                    HandlerRegistration registration = (HandlerRegistration) cur$iv;
                    try {
                        Function1<?, Unit> handler = registration.getHandler();
                        Intrinsics.checkNotNull(handler, "null cannot be cast to non-null type kotlin.Function1<T of io.ktor.events.Events.raise, kotlin.Unit>");
                        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(handler, 1)).invoke(t);
                    } catch (Throwable e2) {
                        Throwable th2 = th;
                        if (th2 != null) {
                            ExceptionsKt.addSuppressed(th2, e2);
                        } else {
                            th = e2;
                        }
                    }
                }
            }
        }
        if (th != null) {
            Throwable it = th;
            throw it;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Events.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00040\u0003j\u0006\u0012\u0002\b\u0003`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR)\u0010\u0006\u001a\u0014\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00040\u0003j\u0006\u0012\u0002\b\u0003`\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/events/Events$HandlerRegistration;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlin/Function1;", "", "Lio/ktor/events/EventHandler;", "handler", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "dispose", "()V", "Lkotlin/jvm/functions/Function1;", "getHandler", "()Lkotlin/jvm/functions/Function1;", "ktor-events"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class HandlerRegistration extends LockFreeLinkedListNode implements DisposableHandle {
        private final Function1<?, Unit> handler;

        public HandlerRegistration(Function1<?, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "handler");
            this.handler = function1;
        }

        public final Function1<?, Unit> getHandler() {
            return this.handler;
        }

        public void dispose() {
            remove();
        }
    }
}