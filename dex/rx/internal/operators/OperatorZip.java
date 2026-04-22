package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;
import rx.functions.FuncN;
import rx.functions.Functions;
import rx.internal.util.RxRingBuffer;
import rx.subscriptions.CompositeSubscription;

public final class OperatorZip<R> implements Observable.Operator<R, Observable<?>[]> {
    final FuncN<? extends R> zipFunction;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorZip(FuncN<? extends R> f) {
        this.zipFunction = f;
    }

    public OperatorZip(Func2 f) {
        this.zipFunction = Functions.fromFunc(f);
    }

    public OperatorZip(Func3 f) {
        this.zipFunction = Functions.fromFunc(f);
    }

    public OperatorZip(Func4 f) {
        this.zipFunction = Functions.fromFunc(f);
    }

    public OperatorZip(Func5 f) {
        this.zipFunction = Functions.fromFunc(f);
    }

    public OperatorZip(Func6 f) {
        this.zipFunction = Functions.fromFunc(f);
    }

    public OperatorZip(Func7 f) {
        this.zipFunction = Functions.fromFunc(f);
    }

    public OperatorZip(Func8 f) {
        this.zipFunction = Functions.fromFunc(f);
    }

    public OperatorZip(Func9 f) {
        this.zipFunction = Functions.fromFunc(f);
    }

    public Subscriber<? super Observable[]> call(Subscriber<? super R> child) {
        Zip<R> zipper = new Zip<>(child, this.zipFunction);
        ZipProducer<R> producer = new ZipProducer<>(zipper);
        OperatorZip<R>.ZipSubscriber subscriber = new ZipSubscriber(child, zipper, producer);
        child.add(subscriber);
        child.setProducer(producer);
        return subscriber;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final class ZipSubscriber extends Subscriber<Observable[]> {
        final Subscriber<? super R> child;
        final ZipProducer<R> producer;
        boolean started;
        final Zip<R> zipper;

        public ZipSubscriber(Subscriber<? super R> child, Zip<R> zipper, ZipProducer<R> producer) {
            this.child = child;
            this.zipper = zipper;
            this.producer = producer;
        }

        public void onCompleted() {
            if (!this.started) {
                this.child.onCompleted();
            }
        }

        public void onError(Throwable e) {
            this.child.onError(e);
        }

        public void onNext(Observable[] observables) {
            if (observables == null || observables.length == 0) {
                this.child.onCompleted();
                return;
            }
            this.started = true;
            this.zipper.start(observables, this.producer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ZipProducer<R> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1216676403723546796L;
        final Zip<R> zipper;

        public ZipProducer(Zip<R> zipper) {
            this.zipper = zipper;
        }

        public void request(long n) {
            BackpressureUtils.getAndAddRequest(this, n);
            this.zipper.tick();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Zip<R> extends AtomicLong {
        static final int THRESHOLD = (int) (RxRingBuffer.SIZE * 0.7d);
        private static final long serialVersionUID = 5995274816189928317L;
        final Observer<? super R> child;
        private final CompositeSubscription childSubscription = new CompositeSubscription();
        int emitted;
        private AtomicLong requested;
        private volatile Object[] subscribers;
        private final FuncN<? extends R> zipFunction;

        public Zip(Subscriber<? super R> child, FuncN<? extends R> zipFunction) {
            this.child = child;
            this.zipFunction = zipFunction;
            child.add(this.childSubscription);
        }

        public void start(Observable[] os, AtomicLong requested) {
            Object[] subscribers = new Object[os.length];
            for (int i = 0; i < os.length; i++) {
                Zip<R>.InnerSubscriber io2 = new InnerSubscriber();
                subscribers[i] = io2;
                this.childSubscription.add(io2);
            }
            this.requested = requested;
            this.subscribers = subscribers;
            for (int i2 = 0; i2 < os.length; i2++) {
                os[i2].unsafeSubscribe((InnerSubscriber) subscribers[i2]);
            }
        }

        void tick() {
            Object[] subscribers = this.subscribers;
            if (subscribers != null && getAndIncrement() == 0) {
                int length = subscribers.length;
                Observer<? super R> child = this.child;
                AtomicLong requested = this.requested;
                while (true) {
                    Object[] vs = new Object[length];
                    boolean allHaveValues = true;
                    for (int i = 0; i < length; i++) {
                        RxRingBuffer buffer = ((InnerSubscriber) subscribers[i]).items;
                        Object n = buffer.peek();
                        if (n == null) {
                            allHaveValues = false;
                        } else if (buffer.isCompleted(n)) {
                            child.onCompleted();
                            this.childSubscription.unsubscribe();
                            return;
                        } else {
                            vs[i] = buffer.getValue(n);
                        }
                    }
                    if (allHaveValues && requested.get() > 0) {
                        try {
                            child.onNext(this.zipFunction.call(vs));
                            requested.decrementAndGet();
                            this.emitted++;
                            for (Object obj : subscribers) {
                                RxRingBuffer buffer2 = ((InnerSubscriber) obj).items;
                                buffer2.poll();
                                if (buffer2.isCompleted(buffer2.peek())) {
                                    child.onCompleted();
                                    this.childSubscription.unsubscribe();
                                    return;
                                }
                            }
                            if (this.emitted > THRESHOLD) {
                                for (Object obj2 : subscribers) {
                                    ((InnerSubscriber) obj2).requestMore(this.emitted);
                                }
                                this.emitted = 0;
                            }
                        } catch (Throwable e) {
                            Exceptions.throwOrReport(e, child, vs);
                            return;
                        }
                    } else if (decrementAndGet() <= 0) {
                        return;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public final class InnerSubscriber extends Subscriber {
            final RxRingBuffer items = RxRingBuffer.getSpmcInstance();

            InnerSubscriber() {
            }

            public void onStart() {
                request(RxRingBuffer.SIZE);
            }

            public void requestMore(long n) {
                request(n);
            }

            public void onCompleted() {
                this.items.onCompleted();
                Zip.this.tick();
            }

            public void onError(Throwable e) {
                Zip.this.child.onError(e);
            }

            public void onNext(Object t) {
                try {
                    this.items.onNext(t);
                } catch (MissingBackpressureException e) {
                    onError(e);
                }
                Zip.this.tick();
            }
        }
    }
}