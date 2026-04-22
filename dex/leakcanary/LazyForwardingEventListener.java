package leakcanary;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.EventListener;

/* compiled from: LazyForwardingEventListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lleakcanary/LazyForwardingEventListener;", "Lleakcanary/EventListener;", "lazyEventListener", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "eventListenerDelegate", "getEventListenerDelegate", "()Lleakcanary/EventListener;", "eventListenerDelegate$delegate", "Lkotlin/Lazy;", "onEvent", "", "event", "Lleakcanary/EventListener$Event;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class LazyForwardingEventListener implements EventListener {
    private final Lazy eventListenerDelegate$delegate;

    private final EventListener getEventListenerDelegate() {
        return (EventListener) this.eventListenerDelegate$delegate.getValue();
    }

    public LazyForwardingEventListener(Function0<? extends EventListener> lazyEventListener) {
        Intrinsics.checkParameterIsNotNull(lazyEventListener, "lazyEventListener");
        this.eventListenerDelegate$delegate = LazyKt.lazy(lazyEventListener);
    }

    @Override // leakcanary.EventListener
    public void onEvent(EventListener.Event event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        getEventListenerDelegate().onEvent(event);
    }
}