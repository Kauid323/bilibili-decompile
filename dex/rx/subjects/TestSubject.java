package rx.subjects;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.schedulers.TestScheduler;
import rx.subjects.SubjectSubscriptionManager;

public final class TestSubject<T> extends Subject<T, T> {
    private final Scheduler.Worker innerScheduler;
    private final SubjectSubscriptionManager<T> state;

    public static <T> TestSubject<T> create(TestScheduler scheduler) {
        final SubjectSubscriptionManager<T> state = new SubjectSubscriptionManager<>();
        state.onAdded = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() { // from class: rx.subjects.TestSubject.1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((SubjectSubscriptionManager.SubjectObserver) ((SubjectSubscriptionManager.SubjectObserver) x0));
            }

            public void call(SubjectSubscriptionManager.SubjectObserver<T> o) {
                o.emitFirst(SubjectSubscriptionManager.this.getLatest());
            }
        };
        state.onTerminated = state.onAdded;
        return new TestSubject<>(state, state, scheduler);
    }

    protected TestSubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> state, TestScheduler scheduler) {
        super(onSubscribe);
        this.state = state;
        this.innerScheduler = scheduler.createWorker();
    }

    public void onCompleted() {
        onCompleted(0L);
    }

    void internalOnCompleted() {
        if (this.state.active) {
            SubjectSubscriptionManager.SubjectObserver<T>[] arr$ = this.state.terminate(NotificationLite.completed());
            for (SubjectSubscriptionManager.SubjectObserver<T> bo : arr$) {
                bo.onCompleted();
            }
        }
    }

    public void onCompleted(long delayTime) {
        this.innerScheduler.schedule(new Action0() { // from class: rx.subjects.TestSubject.2
            public void call() {
                TestSubject.this.internalOnCompleted();
            }
        }, delayTime, TimeUnit.MILLISECONDS);
    }

    public void onError(Throwable e) {
        onError(e, 0L);
    }

    void internalOnError(Throwable e) {
        if (this.state.active) {
            SubjectSubscriptionManager.SubjectObserver<T>[] arr$ = this.state.terminate(NotificationLite.error(e));
            for (SubjectSubscriptionManager.SubjectObserver<T> bo : arr$) {
                bo.onError(e);
            }
        }
    }

    public void onError(final Throwable e, long delayTime) {
        this.innerScheduler.schedule(new Action0() { // from class: rx.subjects.TestSubject.3
            public void call() {
                TestSubject.this.internalOnError(e);
            }
        }, delayTime, TimeUnit.MILLISECONDS);
    }

    public void onNext(T v) {
        onNext(v, 0L);
    }

    void internalOnNext(T v) {
        Observer<? super T>[] arr$ = this.state.observers();
        for (Observer<? super T> o : arr$) {
            o.onNext(v);
        }
    }

    public void onNext(final T v, long delayTime) {
        this.innerScheduler.schedule(new Action0() { // from class: rx.subjects.TestSubject.4
            /* JADX WARN: Multi-variable type inference failed */
            public void call() {
                TestSubject.this.internalOnNext(v);
            }
        }, delayTime, TimeUnit.MILLISECONDS);
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.state.observers().length > 0;
    }
}