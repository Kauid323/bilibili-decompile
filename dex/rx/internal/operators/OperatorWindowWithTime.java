package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;
import rx.subscriptions.Subscriptions;

public final class OperatorWindowWithTime<T> implements Observable.Operator<Observable<T>, T> {
    static final Object NEXT_SUBJECT = new Object();
    final Scheduler scheduler;
    final int size;
    final long timeshift;
    final long timespan;
    final TimeUnit unit;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorWindowWithTime(long timespan, long timeshift, TimeUnit unit, int size, Scheduler scheduler) {
        this.timespan = timespan;
        this.timeshift = timeshift;
        this.unit = unit;
        this.size = size;
        this.scheduler = scheduler;
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> child) {
        Subscription createWorker = this.scheduler.createWorker();
        if (this.timespan == this.timeshift) {
            OperatorWindowWithTime<T>.ExactSubscriber s = new ExactSubscriber(child, createWorker);
            s.add(createWorker);
            s.scheduleExact();
            return s;
        }
        OperatorWindowWithTime<T>.InexactSubscriber s2 = new InexactSubscriber(child, createWorker);
        s2.add(createWorker);
        s2.startNewChunk();
        s2.scheduleChunk();
        return s2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class State<T> {
        static final State<Object> EMPTY = new State<>(null, null, 0);
        final Observer<T> consumer;
        final int count;
        final Observable<T> producer;

        public State(Observer<T> consumer, Observable<T> producer, int count) {
            this.consumer = consumer;
            this.producer = producer;
            this.count = count;
        }

        public State<T> next() {
            return new State<>(this.consumer, this.producer, this.count + 1);
        }

        public State<T> create(Observer<T> consumer, Observable<T> producer) {
            return new State<>(consumer, producer, 0);
        }

        public State<T> clear() {
            return empty();
        }

        public static <T> State<T> empty() {
            return (State<T>) EMPTY;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final class ExactSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        boolean emitting;
        List<Object> queue;
        final Scheduler.Worker worker;
        final Object guard = new Object();
        volatile State<T> state = State.empty();

        public ExactSubscriber(Subscriber<? super Observable<T>> child, Scheduler.Worker worker) {
            this.child = new SerializedSubscriber(child);
            this.worker = worker;
            child.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.1
                public void call() {
                    if (ExactSubscriber.this.state.consumer == null) {
                        ExactSubscriber.this.unsubscribe();
                    }
                }
            }));
        }

        public void onStart() {
            request(Long.MAX_VALUE);
        }

        public void onNext(T t) {
            List<Object> localQueue;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(t);
                    return;
                }
                this.emitting = true;
                try {
                    if (!emitValue(t)) {
                        if (0 == 0) {
                            synchronized (this.guard) {
                                this.emitting = false;
                            }
                            return;
                        }
                        return;
                    }
                    do {
                        synchronized (this.guard) {
                            try {
                                localQueue = this.queue;
                                if (localQueue == null) {
                                    this.emitting = false;
                                } else {
                                    try {
                                        this.queue = null;
                                    } catch (Throwable th) {
                                        th = th;
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        if (1 == 0) {
                            synchronized (this.guard) {
                                this.emitting = false;
                            }
                            return;
                        }
                        return;
                    } while (drain(localQueue));
                    if (0 == 0) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                    }
                } catch (Throwable th3) {
                    if (0 == 0) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                    }
                    throw th3;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
            return true;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        boolean drain(List<Object> queue) {
            if (queue == null) {
                return true;
            }
            Iterator i$ = queue.iterator();
            while (true) {
                if (!i$.hasNext()) {
                    break;
                }
                Object o = i$.next();
                if (o == OperatorWindowWithTime.NEXT_SUBJECT) {
                    if (!replaceSubject()) {
                        return false;
                    }
                } else if (NotificationLite.isError(o)) {
                    error(NotificationLite.getError(o));
                    break;
                } else if (NotificationLite.isCompleted(o)) {
                    complete();
                    break;
                } else if (!emitValue(o)) {
                    return false;
                }
            }
        }

        boolean replaceSubject() {
            Observer<T> s = this.state.consumer;
            if (s != null) {
                s.onCompleted();
            }
            if (this.child.isUnsubscribed()) {
                this.state = this.state.clear();
                unsubscribe();
                return false;
            }
            Observer<T> create = UnicastSubject.create();
            this.state = this.state.create(create, create);
            this.child.onNext(create);
            return true;
        }

        boolean emitValue(T t) {
            State<T> s;
            State<T> s2 = this.state;
            if (s2.consumer == null) {
                if (!replaceSubject()) {
                    return false;
                }
                s2 = this.state;
            }
            s2.consumer.onNext(t);
            if (s2.count == OperatorWindowWithTime.this.size - 1) {
                s2.consumer.onCompleted();
                s = s2.clear();
            } else {
                s = s2.next();
            }
            this.state = s;
            return true;
        }

        public void onError(Throwable e) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.queue = Collections.singletonList(NotificationLite.error(e));
                    return;
                }
                this.queue = null;
                this.emitting = true;
                error(e);
            }
        }

        void error(Throwable e) {
            Observer<T> s = this.state.consumer;
            this.state = this.state.clear();
            if (s != null) {
                s.onError(e);
            }
            this.child.onError(e);
            unsubscribe();
        }

        void complete() {
            Observer<T> s = this.state.consumer;
            this.state = this.state.clear();
            if (s != null) {
                s.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        public void onCompleted() {
            synchronized (this.guard) {
                try {
                    try {
                        if (this.emitting) {
                            if (this.queue == null) {
                                this.queue = new ArrayList();
                            }
                            this.queue.add(NotificationLite.completed());
                            return;
                        }
                        List<Object> localQueue = this.queue;
                        this.queue = null;
                        this.emitting = true;
                        try {
                            drain(localQueue);
                            complete();
                        } catch (Throwable e) {
                            error(e);
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        void scheduleExact() {
            this.worker.schedulePeriodically(new Action0() { // from class: rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.2
                public void call() {
                    ExactSubscriber.this.nextWindow();
                }
            }, 0L, OperatorWindowWithTime.this.timespan, OperatorWindowWithTime.this.unit);
        }

        void nextWindow() {
            List<Object> localQueue;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(OperatorWindowWithTime.NEXT_SUBJECT);
                    return;
                }
                this.emitting = true;
                try {
                    if (!replaceSubject()) {
                        if (0 == 0) {
                            synchronized (this.guard) {
                                this.emitting = false;
                            }
                            return;
                        }
                        return;
                    }
                    do {
                        synchronized (this.guard) {
                            try {
                                localQueue = this.queue;
                                if (localQueue == null) {
                                    this.emitting = false;
                                } else {
                                    try {
                                        this.queue = null;
                                    } catch (Throwable th) {
                                        th = th;
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        if (1 == 0) {
                            synchronized (this.guard) {
                                this.emitting = false;
                            }
                            return;
                        }
                        return;
                    } while (drain(localQueue));
                    if (0 == 0) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                    }
                } catch (Throwable th3) {
                    if (0 == 0) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CountedSerializedSubject<T> {
        final Observer<T> consumer;
        int count;
        final Observable<T> producer;

        public CountedSerializedSubject(Observer<T> consumer, Observable<T> producer) {
            this.consumer = new SerializedObserver(consumer);
            this.producer = producer;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final class InexactSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        final List<CountedSerializedSubject<T>> chunks;
        boolean done;
        final Object guard;
        final Scheduler.Worker worker;

        public InexactSubscriber(Subscriber<? super Observable<T>> child, Scheduler.Worker worker) {
            super(child);
            this.child = child;
            this.worker = worker;
            this.guard = new Object();
            this.chunks = new LinkedList();
        }

        public void onStart() {
            request(Long.MAX_VALUE);
        }

        public void onNext(T t) {
            synchronized (this.guard) {
                try {
                    try {
                        if (this.done) {
                            return;
                        }
                        List<CountedSerializedSubject<T>> list = new ArrayList<>(this.chunks);
                        Iterator<CountedSerializedSubject<T>> it = this.chunks.iterator();
                        while (it.hasNext()) {
                            CountedSerializedSubject<T> cs = it.next();
                            int i = cs.count + 1;
                            cs.count = i;
                            if (i == OperatorWindowWithTime.this.size) {
                                it.remove();
                            }
                        }
                        for (CountedSerializedSubject<T> cs2 : list) {
                            cs2.consumer.onNext(t);
                            if (cs2.count == OperatorWindowWithTime.this.size) {
                                cs2.consumer.onCompleted();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        public void onError(Throwable e) {
            synchronized (this.guard) {
                try {
                    try {
                        if (this.done) {
                            return;
                        }
                        this.done = true;
                        List<CountedSerializedSubject<T>> list = new ArrayList<>(this.chunks);
                        this.chunks.clear();
                        for (CountedSerializedSubject<T> cs : list) {
                            cs.consumer.onError(e);
                        }
                        this.child.onError(e);
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        public void onCompleted() {
            synchronized (this.guard) {
                try {
                    try {
                        if (this.done) {
                            return;
                        }
                        this.done = true;
                        List<CountedSerializedSubject<T>> list = new ArrayList<>(this.chunks);
                        this.chunks.clear();
                        for (CountedSerializedSubject<T> cs : list) {
                            cs.consumer.onCompleted();
                        }
                        this.child.onCompleted();
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        void scheduleChunk() {
            this.worker.schedulePeriodically(new Action0() { // from class: rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.1
                public void call() {
                    InexactSubscriber.this.startNewChunk();
                }
            }, OperatorWindowWithTime.this.timeshift, OperatorWindowWithTime.this.timeshift, OperatorWindowWithTime.this.unit);
        }

        void startNewChunk() {
            final CountedSerializedSubject<T> chunk = createCountedSerializedSubject();
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                this.chunks.add(chunk);
                try {
                    this.child.onNext(chunk.producer);
                    this.worker.schedule(new Action0() { // from class: rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.2
                        public void call() {
                            InexactSubscriber.this.terminateChunk(chunk);
                        }
                    }, OperatorWindowWithTime.this.timespan, OperatorWindowWithTime.this.unit);
                } catch (Throwable e) {
                    onError(e);
                }
            }
        }

        void terminateChunk(CountedSerializedSubject<T> chunk) {
            boolean terminate = false;
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                Iterator<CountedSerializedSubject<T>> it = this.chunks.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CountedSerializedSubject<T> cs = it.next();
                    if (cs == chunk) {
                        terminate = true;
                        it.remove();
                        break;
                    }
                }
                if (terminate) {
                    chunk.consumer.onCompleted();
                }
            }
        }

        CountedSerializedSubject<T> createCountedSerializedSubject() {
            UnicastSubject<T> bus = UnicastSubject.create();
            return new CountedSerializedSubject<>(bus, bus);
        }
    }
}