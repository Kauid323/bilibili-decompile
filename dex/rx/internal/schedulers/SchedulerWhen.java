package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.operators.BufferUntilSubscriber;
import rx.observers.SerializedObserver;
import rx.subjects.PublishSubject;
import rx.subscriptions.Subscriptions;

public class SchedulerWhen extends Scheduler implements Subscription {
    static final Subscription SUBSCRIBED = new Subscription() { // from class: rx.internal.schedulers.SchedulerWhen.3
        public void unsubscribe() {
        }

        public boolean isUnsubscribed() {
            return false;
        }
    };
    static final Subscription UNSUBSCRIBED = Subscriptions.unsubscribed();
    private final Scheduler actualScheduler;
    private final Subscription subscription;
    private final Observer<Observable<Completable>> workerObserver;

    public SchedulerWhen(Func1<Observable<Observable<Completable>>, Completable> combine, Scheduler actualScheduler) {
        this.actualScheduler = actualScheduler;
        PublishSubject<Observable<Completable>> workerSubject = PublishSubject.create();
        this.workerObserver = new SerializedObserver(workerSubject);
        this.subscription = ((Completable) combine.call(workerSubject.onBackpressureBuffer())).subscribe();
    }

    public void unsubscribe() {
        this.subscription.unsubscribe();
    }

    public boolean isUnsubscribed() {
        return this.subscription.isUnsubscribed();
    }

    public Scheduler.Worker createWorker() {
        final Scheduler.Worker actualWorker = this.actualScheduler.createWorker();
        BufferUntilSubscriber<ScheduledAction> actionSubject = BufferUntilSubscriber.create();
        final SerializedObserver serializedObserver = new SerializedObserver(actionSubject);
        Observable<Completable> actions = actionSubject.map(new Func1<ScheduledAction, Completable>() { // from class: rx.internal.schedulers.SchedulerWhen.1
            public Completable call(final ScheduledAction action) {
                return Completable.create(new Completable.OnSubscribe() { // from class: rx.internal.schedulers.SchedulerWhen.1.1
                    public void call(CompletableSubscriber actionCompletable) {
                        actionCompletable.onSubscribe(action);
                        action.call(actualWorker, actionCompletable);
                    }
                });
            }
        });
        Scheduler.Worker worker = new Scheduler.Worker() { // from class: rx.internal.schedulers.SchedulerWhen.2
            private final AtomicBoolean unsubscribed = new AtomicBoolean();

            public void unsubscribe() {
                if (this.unsubscribed.compareAndSet(false, true)) {
                    actualWorker.unsubscribe();
                    serializedObserver.onCompleted();
                }
            }

            public boolean isUnsubscribed() {
                return this.unsubscribed.get();
            }

            public Subscription schedule(Action0 action, long delayTime, TimeUnit unit) {
                DelayedAction delayedAction = new DelayedAction(action, delayTime, unit);
                serializedObserver.onNext(delayedAction);
                return delayedAction;
            }

            public Subscription schedule(Action0 action) {
                ImmediateAction immediateAction = new ImmediateAction(action);
                serializedObserver.onNext(immediateAction);
                return immediateAction;
            }
        };
        this.workerObserver.onNext(actions);
        return worker;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class ScheduledAction extends AtomicReference<Subscription> implements Subscription {
        protected abstract Subscription callActual(Scheduler.Worker worker, CompletableSubscriber completableSubscriber);

        public ScheduledAction() {
            super(SchedulerWhen.SUBSCRIBED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(Scheduler.Worker actualWorker, CompletableSubscriber actionCompletable) {
            Subscription oldState = get();
            if (oldState == SchedulerWhen.UNSUBSCRIBED || oldState != SchedulerWhen.SUBSCRIBED) {
                return;
            }
            Subscription newState = callActual(actualWorker, actionCompletable);
            if (!compareAndSet(SchedulerWhen.SUBSCRIBED, newState)) {
                newState.unsubscribe();
            }
        }

        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        public void unsubscribe() {
            Subscription oldState;
            Subscription newState = SchedulerWhen.UNSUBSCRIBED;
            do {
                oldState = get();
                if (oldState == SchedulerWhen.UNSUBSCRIBED) {
                    return;
                }
            } while (!compareAndSet(oldState, newState));
            if (oldState != SchedulerWhen.SUBSCRIBED) {
                oldState.unsubscribe();
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static class ImmediateAction extends ScheduledAction {
        private final Action0 action;

        public ImmediateAction(Action0 action) {
            this.action = action;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        protected Subscription callActual(Scheduler.Worker actualWorker, CompletableSubscriber actionCompletable) {
            return actualWorker.schedule(new OnCompletedAction(this.action, actionCompletable));
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static class DelayedAction extends ScheduledAction {
        private final Action0 action;
        private final long delayTime;
        private final TimeUnit unit;

        public DelayedAction(Action0 action, long delayTime, TimeUnit unit) {
            this.action = action;
            this.delayTime = delayTime;
            this.unit = unit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        protected Subscription callActual(Scheduler.Worker actualWorker, CompletableSubscriber actionCompletable) {
            return actualWorker.schedule(new OnCompletedAction(this.action, actionCompletable), this.delayTime, this.unit);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static class OnCompletedAction implements Action0 {
        private Action0 action;
        private CompletableSubscriber actionCompletable;

        public OnCompletedAction(Action0 action, CompletableSubscriber actionCompletable) {
            this.action = action;
            this.actionCompletable = actionCompletable;
        }

        public void call() {
            try {
                this.action.call();
            } finally {
                this.actionCompletable.onCompleted();
            }
        }
    }
}