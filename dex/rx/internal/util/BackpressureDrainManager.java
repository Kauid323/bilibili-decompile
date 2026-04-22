package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

public final class BackpressureDrainManager extends AtomicLong implements Producer {
    private static final long serialVersionUID = 2826241102729529449L;
    final BackpressureQueueCallback actual;
    boolean emitting;
    Throwable exception;
    volatile boolean terminated;

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface BackpressureQueueCallback {
        boolean accept(Object obj);

        void complete(Throwable th);

        Object peek();

        Object poll();
    }

    public BackpressureDrainManager(BackpressureQueueCallback actual) {
        this.actual = actual;
    }

    public boolean isTerminated() {
        return this.terminated;
    }

    public void terminate() {
        this.terminated = true;
    }

    public void terminate(Throwable error) {
        if (!this.terminated) {
            this.exception = error;
            this.terminated = true;
        }
    }

    public void terminateAndDrain() {
        this.terminated = true;
        drain();
    }

    public void terminateAndDrain(Throwable error) {
        if (!this.terminated) {
            this.exception = error;
            this.terminated = true;
            drain();
        }
    }

    public void request(long n) {
        long r;
        boolean mayDrain;
        long u;
        if (n == 0) {
            return;
        }
        do {
            r = get();
            mayDrain = r == 0;
            if (r == Long.MAX_VALUE) {
                break;
            } else if (n == Long.MAX_VALUE) {
                u = n;
                mayDrain = true;
            } else {
                long u2 = Long.MAX_VALUE - n;
                if (r > u2) {
                    u = Long.MAX_VALUE;
                } else {
                    u = r + n;
                }
            }
        } while (!compareAndSet(r, u));
        if (mayDrain) {
            drain();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:129:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0069, code lost:
        if (1 != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006b, code lost:
        monitor-enter(r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x006c, code lost:
        r16.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x006e, code lost:
        monitor-exit(r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0073, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0085, code lost:
        if (r11 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x008e, code lost:
        r16.emitting = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        synchronized (this) {
            try {
                try {
                    if (this.emitting) {
                        return;
                    }
                    this.emitting = true;
                    boolean term = this.terminated;
                    long n = get();
                    try {
                        BackpressureQueueCallback a = this.actual;
                        while (true) {
                            int emitted = 0;
                            while (true) {
                                if (n <= 0 && !term) {
                                    break;
                                }
                                if (term) {
                                    if (a.peek() != null) {
                                        if (n == 0) {
                                            break;
                                        }
                                    } else {
                                        Throwable e = this.exception;
                                        a.complete(e);
                                        if (1 == 0) {
                                            synchronized (this) {
                                                this.emitting = false;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                Object o = a.poll();
                                if (o == null) {
                                    break;
                                } else if (a.accept(o)) {
                                    if (1 == 0) {
                                        synchronized (this) {
                                            this.emitting = false;
                                        }
                                        return;
                                    }
                                    return;
                                } else {
                                    n--;
                                    emitted++;
                                }
                            }
                            synchronized (this) {
                                term = this.terminated;
                                boolean more = a.peek() != null;
                                if (get() != Long.MAX_VALUE) {
                                    n = addAndGet(-emitted);
                                    if (n != 0) {
                                    }
                                    if (!term) {
                                        break;
                                    } else if (more) {
                                        break;
                                    }
                                } else if (more || term) {
                                    n = Long.MAX_VALUE;
                                } else {
                                    this.emitting = false;
                                }
                            }
                            if (1 == 0) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        if (0 == 0) {
                            synchronized (this) {
                                this.emitting = false;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }
}