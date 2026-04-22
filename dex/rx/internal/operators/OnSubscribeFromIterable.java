package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class OnSubscribeFromIterable<T> implements Observable.OnSubscribe<T> {
    final Iterable<? extends T> is;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        if (iterable == null) {
            throw new NullPointerException("iterable must not be null");
        }
        this.is = iterable;
    }

    public void call(Subscriber<? super T> o) {
        try {
            Iterator<? extends T> it = this.is.iterator();
            try {
                boolean b = it.hasNext();
                if (!o.isUnsubscribed()) {
                    if (!b) {
                        o.onCompleted();
                    } else {
                        o.setProducer(new IterableProducer(o, it));
                    }
                }
            } catch (Throwable th) {
                ex = th;
                Exceptions.throwOrReport(ex, o);
            }
        } catch (Throwable th2) {
            ex = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class IterableProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -8730475647105475802L;
        private final Iterator<? extends T> it;
        private final Subscriber<? super T> o;

        /* JADX INFO: Access modifiers changed from: package-private */
        public IterableProducer(Subscriber<? super T> o, Iterator<? extends T> it) {
            this.o = o;
            this.it = it;
        }

        public void request(long n) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (n == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (n > 0 && BackpressureUtils.getAndAddRequest(this, n) == 0) {
                slowPath(n);
            }
        }

        void slowPath(long n) {
            Subscriber<? super T> o = this.o;
            Iterator<? extends T> it = this.it;
            long r = n;
            long e = 0;
            while (true) {
                if (e != r) {
                    if (o.isUnsubscribed()) {
                        return;
                    }
                    try {
                        T value = it.next();
                        o.onNext(value);
                        if (o.isUnsubscribed()) {
                            return;
                        }
                        try {
                            boolean b = it.hasNext();
                            if (!b) {
                                if (!o.isUnsubscribed()) {
                                    o.onCompleted();
                                    return;
                                }
                                return;
                            }
                            e++;
                        } catch (Throwable ex) {
                            Exceptions.throwOrReport(ex, o);
                            return;
                        }
                    } catch (Throwable ex2) {
                        Exceptions.throwOrReport(ex2, o);
                        return;
                    }
                } else {
                    r = get();
                    if (e == r) {
                        r = BackpressureUtils.produced(this, e);
                        if (r != 0) {
                            e = 0;
                        } else {
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }

        void fastPath() {
            Subscriber<? super T> o = this.o;
            Iterator<? extends T> it = this.it;
            while (!o.isUnsubscribed()) {
                try {
                    T value = it.next();
                    o.onNext(value);
                    if (o.isUnsubscribed()) {
                        return;
                    }
                    try {
                        boolean b = it.hasNext();
                        if (!b) {
                            if (!o.isUnsubscribed()) {
                                o.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable ex) {
                        Exceptions.throwOrReport(ex, o);
                        return;
                    }
                } catch (Throwable ex2) {
                    Exceptions.throwOrReport(ex2, o);
                    return;
                }
            }
        }
    }
}