package rx.internal.producers;

import java.util.ArrayList;
import java.util.List;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.operators.BackpressureUtils;

public final class ProducerObserverArbiter<T> implements Producer, Observer<T> {
    static final Producer NULL_PRODUCER = new Producer() { // from class: rx.internal.producers.ProducerObserverArbiter.1
        public void request(long n) {
        }
    };
    final Subscriber<? super T> child;
    Producer currentProducer;
    boolean emitting;
    volatile boolean hasError;
    Producer missedProducer;
    long missedRequested;
    Object missedTerminal;
    List<T> queue;
    long requested;

    public ProducerObserverArbiter(Subscriber<? super T> child) {
        this.child = child;
    }

    public void onNext(T t) {
        synchronized (this) {
            if (this.emitting) {
                List<T> q = this.queue;
                if (q == null) {
                    q = new ArrayList(4);
                    this.queue = q;
                }
                q.add(t);
                return;
            }
            this.emitting = true;
            try {
                this.child.onNext(t);
                long r = this.requested;
                if (r != Long.MAX_VALUE) {
                    this.requested = r - 1;
                }
                emitLoop();
                if (1 == 0) {
                    synchronized (this) {
                        this.emitting = false;
                    }
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    synchronized (this) {
                        this.emitting = false;
                    }
                }
                throw th;
            }
        }
    }

    public void onError(Throwable e) {
        boolean emit;
        synchronized (this) {
            try {
                try {
                    if (this.emitting) {
                        this.missedTerminal = e;
                        emit = false;
                    } else {
                        this.emitting = true;
                        emit = true;
                    }
                    if (emit) {
                        this.child.onError(e);
                    } else {
                        this.hasError = true;
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

    public void onCompleted() {
        synchronized (this) {
            if (this.emitting) {
                this.missedTerminal = true;
                return;
            }
            this.emitting = true;
            this.child.onCompleted();
        }
    }

    public void request(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (n == 0) {
            return;
        }
        synchronized (this) {
            if (this.emitting) {
                this.missedRequested += n;
                return;
            }
            this.emitting = true;
            Producer p = this.currentProducer;
            try {
                long r = this.requested;
                long u = r + n;
                if (u < 0) {
                    u = Long.MAX_VALUE;
                }
                this.requested = u;
                emitLoop();
                if (1 == 0) {
                    synchronized (this) {
                        this.emitting = false;
                    }
                }
                if (p != null) {
                    p.request(n);
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    synchronized (this) {
                        this.emitting = false;
                    }
                }
                throw th;
            }
        }
    }

    public void setProducer(Producer p) {
        synchronized (this) {
            if (this.emitting) {
                this.missedProducer = p != null ? p : NULL_PRODUCER;
                return;
            }
            this.emitting = true;
            this.currentProducer = p;
            long r = this.requested;
            try {
                emitLoop();
                if (1 == 0) {
                    synchronized (this) {
                        this.emitting = false;
                    }
                }
                if (p != null && r != 0) {
                    p.request(r);
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    synchronized (this) {
                        this.emitting = false;
                    }
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x0010, code lost:
        continue;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x0102 -> B:95:0x0100). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void emitLoop() {
        Subscriber<? super T> c = this.child;
        long toRequest = 0;
        Producer requestFrom = null;
        while (true) {
            boolean quit = false;
            synchronized (this) {
                try {
                    long localRequested = this.missedRequested;
                    try {
                        Producer localProducer = this.missedProducer;
                        try {
                            Object localTerminal = this.missedTerminal;
                            try {
                                List<T> q = this.queue;
                                boolean empty = false;
                                if (localRequested == 0 && localProducer == null && q == null && localTerminal == null) {
                                    try {
                                        this.emitting = false;
                                        quit = true;
                                    } catch (Throwable th) {
                                        th = th;
                                        throw th;
                                    }
                                } else {
                                    try {
                                        this.missedRequested = 0L;
                                        this.missedProducer = null;
                                        this.queue = null;
                                        this.missedTerminal = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        throw th;
                                    }
                                }
                                if (quit) {
                                    if (toRequest != 0 && requestFrom != null) {
                                        requestFrom.request(toRequest);
                                        return;
                                    }
                                    return;
                                }
                                empty = (q == null || q.isEmpty()) ? true : true;
                                if (localTerminal != null) {
                                    if (localTerminal != Boolean.TRUE) {
                                        c.onError((Throwable) localTerminal);
                                        return;
                                    } else if (empty) {
                                        c.onCompleted();
                                        return;
                                    }
                                }
                                long e = 0;
                                if (q != null) {
                                    for (T v : q) {
                                        if (c.isUnsubscribed()) {
                                            return;
                                        }
                                        if (this.hasError) {
                                            break;
                                        }
                                        try {
                                            c.onNext(v);
                                        } catch (Throwable ex) {
                                            Exceptions.throwOrReport(ex, c, v);
                                            return;
                                        }
                                    }
                                    e = 0 + q.size();
                                }
                                long r = this.requested;
                                if (r != Long.MAX_VALUE) {
                                    if (localRequested != 0) {
                                        long u = r + localRequested;
                                        if (u < 0) {
                                            u = Long.MAX_VALUE;
                                        }
                                        r = u;
                                    }
                                    if (e != 0 && r != Long.MAX_VALUE) {
                                        long u2 = r - e;
                                        if (u2 < 0) {
                                            throw new IllegalStateException("More produced than requested");
                                        }
                                        r = u2;
                                    }
                                    this.requested = r;
                                }
                                if (localProducer != null) {
                                    if (localProducer == NULL_PRODUCER) {
                                        this.currentProducer = null;
                                    } else {
                                        this.currentProducer = localProducer;
                                        if (r != 0) {
                                            toRequest = BackpressureUtils.addCap(toRequest, r);
                                            requestFrom = localProducer;
                                        }
                                    }
                                } else {
                                    Producer requestFrom2 = this.currentProducer;
                                    if (requestFrom2 != null && localRequested != 0) {
                                        toRequest = BackpressureUtils.addCap(toRequest, localRequested);
                                        requestFrom = requestFrom2;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        }
    }
}