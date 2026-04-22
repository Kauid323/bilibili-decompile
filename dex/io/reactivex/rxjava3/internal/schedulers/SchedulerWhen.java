package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class SchedulerWhen extends Scheduler implements Disposable {
    private final Scheduler actualScheduler;
    private Disposable disposable;
    private final FlowableProcessor<Flowable<Completable>> workerProcessor = UnicastProcessor.create().toSerialized();
    static final Disposable SUBSCRIBED = new SubscribedDisposable();
    static final Disposable DISPOSED = Disposable.CC.disposed();

    public SchedulerWhen(Function<Flowable<Flowable<Completable>>, Completable> combine, Scheduler actualScheduler) {
        this.actualScheduler = actualScheduler;
        try {
            this.disposable = combine.apply(this.workerProcessor).subscribe();
        } catch (Throwable e) {
            throw ExceptionHelper.wrapOrThrow(e);
        }
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public void dispose() {
        this.disposable.dispose();
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public boolean isDisposed() {
        return this.disposable.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker createWorker() {
        Scheduler.Worker actualWorker = this.actualScheduler.createWorker();
        FlowableProcessor<T> serialized = UnicastProcessor.create().toSerialized();
        Flowable map = serialized.map(new CreateWorkerFunction(actualWorker));
        Scheduler.Worker worker = new QueueWorker(serialized, actualWorker);
        this.workerProcessor.onNext(map);
        return worker;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class ScheduledAction extends AtomicReference<Disposable> implements Disposable {
        protected abstract Disposable callActual(Scheduler.Worker actualWorker, CompletableObserver actionCompletable);

        ScheduledAction() {
            super(SchedulerWhen.SUBSCRIBED);
        }

        void call(Scheduler.Worker actualWorker, CompletableObserver actionCompletable) {
            Disposable oldState = get();
            if (oldState == SchedulerWhen.DISPOSED || oldState != SchedulerWhen.SUBSCRIBED) {
                return;
            }
            Disposable newState = callActual(actualWorker, actionCompletable);
            if (!compareAndSet(SchedulerWhen.SUBSCRIBED, newState)) {
                newState.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get().isDisposed();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            getAndSet(SchedulerWhen.DISPOSED).dispose();
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        ImmediateAction(Runnable action) {
            this.action = action;
        }

        @Override // io.reactivex.rxjava3.internal.schedulers.SchedulerWhen.ScheduledAction
        protected Disposable callActual(Scheduler.Worker actualWorker, CompletableObserver actionCompletable) {
            return actualWorker.schedule(new OnCompletedAction(this.action, actionCompletable));
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static class DelayedAction extends ScheduledAction {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        DelayedAction(Runnable action, long delayTime, TimeUnit unit) {
            this.action = action;
            this.delayTime = delayTime;
            this.unit = unit;
        }

        @Override // io.reactivex.rxjava3.internal.schedulers.SchedulerWhen.ScheduledAction
        protected Disposable callActual(Scheduler.Worker actualWorker, CompletableObserver actionCompletable) {
            return actualWorker.schedule(new OnCompletedAction(this.action, actionCompletable), this.delayTime, this.unit);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static class OnCompletedAction implements Runnable {
        final Runnable action;
        final CompletableObserver actionCompletable;

        OnCompletedAction(Runnable action, CompletableObserver actionCompletable) {
            this.action = action;
            this.actionCompletable = actionCompletable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.actionCompletable.onComplete();
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class CreateWorkerFunction implements Function<ScheduledAction, Completable> {
        final Scheduler.Worker actualWorker;

        CreateWorkerFunction(Scheduler.Worker actualWorker) {
            this.actualWorker = actualWorker;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Completable apply(final ScheduledAction action) {
            return new WorkerCompletable(action);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public final class WorkerCompletable extends Completable {
            final ScheduledAction action;

            WorkerCompletable(ScheduledAction action) {
                this.action = action;
            }

            @Override // io.reactivex.rxjava3.core.Completable
            protected void subscribeActual(CompletableObserver actionCompletable) {
                actionCompletable.onSubscribe(this.action);
                this.action.call(CreateWorkerFunction.this.actualWorker, actionCompletable);
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class QueueWorker extends Scheduler.Worker {
        private final FlowableProcessor<ScheduledAction> actionProcessor;
        private final Scheduler.Worker actualWorker;
        private final AtomicBoolean unsubscribed = new AtomicBoolean();

        QueueWorker(FlowableProcessor<ScheduledAction> actionProcessor, Scheduler.Worker actualWorker) {
            this.actionProcessor = actionProcessor;
            this.actualWorker = actualWorker;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.unsubscribed.compareAndSet(false, true)) {
                this.actionProcessor.onComplete();
                this.actualWorker.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.unsubscribed.get();
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(final Runnable action, final long delayTime, final TimeUnit unit) {
            DelayedAction delayedAction = new DelayedAction(action, delayTime, unit);
            this.actionProcessor.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(final Runnable action) {
            ImmediateAction immediateAction = new ImmediateAction(action);
            this.actionProcessor.onNext(immediateAction);
            return immediateAction;
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class SubscribedDisposable implements Disposable {
        SubscribedDisposable() {
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return false;
        }
    }
}