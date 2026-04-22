package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.observers.Subscribers;

public final class OnSubscribeUsing<T, Resource> implements Observable.OnSubscribe<T> {
    private final Action1<? super Resource> dispose;
    private final boolean disposeEagerly;
    private final Func1<? super Resource, ? extends Observable<? extends T>> observableFactory;
    private final Func0<Resource> resourceFactory;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeUsing(Func0<Resource> resourceFactory, Func1<? super Resource, ? extends Observable<? extends T>> observableFactory, Action1<? super Resource> dispose, boolean disposeEagerly) {
        this.resourceFactory = resourceFactory;
        this.observableFactory = observableFactory;
        this.dispose = dispose;
        this.disposeEagerly = disposeEagerly;
    }

    public void call(Subscriber<? super T> subscriber) {
        Observable<? extends T> observable;
        try {
            Object call = this.resourceFactory.call();
            DisposeAction<Resource> disposeOnceOnly = new DisposeAction<>(this.dispose, call);
            subscriber.add(disposeOnceOnly);
            Observable<? extends T> source = (Observable) this.observableFactory.call(call);
            if (this.disposeEagerly) {
                observable = source.doOnTerminate(disposeOnceOnly);
            } else {
                observable = source.doAfterTerminate(disposeOnceOnly);
            }
            observable.unsafeSubscribe(Subscribers.wrap(subscriber));
        } catch (Throwable e) {
            Exceptions.throwOrReport(e, subscriber);
        }
    }

    private Throwable dispose(Action0 disposeOnceOnly) {
        try {
            disposeOnceOnly.call();
            return null;
        } catch (Throwable e) {
            return e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DisposeAction<Resource> extends AtomicBoolean implements Action0, Subscription {
        private static final long serialVersionUID = 4262875056400218316L;
        private Action1<? super Resource> dispose;
        private Resource resource;

        DisposeAction(Action1<? super Resource> dispose, Resource resource) {
            this.dispose = dispose;
            this.resource = resource;
            lazySet(false);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [Resource, rx.functions.Action1<? super Resource>] */
        public void call() {
            if (compareAndSet(false, true)) {
                ?? r0 = (Resource) false;
                try {
                    this.dispose.call(this.resource);
                } finally {
                    this.resource = null;
                    this.dispose = null;
                }
            }
        }

        public boolean isUnsubscribed() {
            return get();
        }

        public void unsubscribe() {
            call();
        }
    }
}