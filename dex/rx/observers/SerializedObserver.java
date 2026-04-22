package rx.observers;

import rx.Observer;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;

public class SerializedObserver<T> implements Observer<T> {
    private final Observer<? super T> actual;
    private boolean emitting;
    private FastList queue;
    private volatile boolean terminated;

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class FastList {
        Object[] array;
        int size;

        FastList() {
        }

        public void add(Object o) {
            int s = this.size;
            Object[] a = this.array;
            if (a == null) {
                a = new Object[16];
                this.array = a;
            } else if (s == a.length) {
                Object[] array2 = new Object[(s >> 2) + s];
                System.arraycopy(a, 0, array2, 0, s);
                a = array2;
                this.array = a;
            }
            a[s] = o;
            this.size = s + 1;
        }
    }

    public SerializedObserver(Observer<? super T> s) {
        this.actual = s;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x002f, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNext(T t) {
        if (this.terminated) {
            return;
        }
        synchronized (this) {
            if (this.terminated) {
                return;
            }
            if (this.emitting) {
                FastList list = this.queue;
                if (list == null) {
                    list = new FastList();
                    this.queue = list;
                }
                list.add(NotificationLite.next(t));
                return;
            }
            this.emitting = true;
            try {
                this.actual.onNext(t);
                while (true) {
                    synchronized (this) {
                        try {
                            try {
                                FastList list2 = this.queue;
                                if (list2 == null) {
                                    this.emitting = false;
                                    return;
                                }
                                try {
                                    this.queue = null;
                                    Object[] arr$ = list2.array;
                                    for (Object o : arr$) {
                                        if (o == null) {
                                            break;
                                        }
                                        try {
                                            if (NotificationLite.accept(this.actual, o)) {
                                                this.terminated = true;
                                                return;
                                            }
                                        } catch (Throwable e) {
                                            this.terminated = true;
                                            Exceptions.throwIfFatal(e);
                                            this.actual.onError(OnErrorThrowable.addValueAsLastCause(e, t));
                                            return;
                                        }
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                }
            } catch (Throwable e2) {
                this.terminated = true;
                Exceptions.throwOrReport(e2, this.actual, t);
            }
        }
    }

    public void onError(Throwable e) {
        Exceptions.throwIfFatal(e);
        if (this.terminated) {
            return;
        }
        synchronized (this) {
            if (this.terminated) {
                return;
            }
            this.terminated = true;
            if (this.emitting) {
                FastList list = this.queue;
                if (list == null) {
                    list = new FastList();
                    this.queue = list;
                }
                list.add(NotificationLite.error(e));
                return;
            }
            this.emitting = true;
            this.actual.onError(e);
        }
    }

    public void onCompleted() {
        if (this.terminated) {
            return;
        }
        synchronized (this) {
            if (this.terminated) {
                return;
            }
            this.terminated = true;
            if (this.emitting) {
                FastList list = this.queue;
                if (list == null) {
                    list = new FastList();
                    this.queue = list;
                }
                list.add(NotificationLite.completed());
                return;
            }
            this.emitting = true;
            this.actual.onCompleted();
        }
    }
}