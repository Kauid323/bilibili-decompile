package rx.subjects;

import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedObserver;

public class SerializedSubject<T, R> extends Subject<T, R> {
    private final Subject<T, R> actual;
    private final SerializedObserver<T> observer;

    public SerializedSubject(final Subject<T, R> actual) {
        super(new Observable.OnSubscribe<R>() { // from class: rx.subjects.SerializedSubject.1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((Subscriber) ((Subscriber) x0));
            }

            public void call(Subscriber<? super R> child) {
                Subject.this.unsafeSubscribe(child);
            }
        });
        this.actual = actual;
        this.observer = new SerializedObserver<>(actual);
    }

    public void onCompleted() {
        this.observer.onCompleted();
    }

    public void onError(Throwable e) {
        this.observer.onError(e);
    }

    public void onNext(T t) {
        this.observer.onNext(t);
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.actual.hasObservers();
    }
}