package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;

public final class ObservableRangeLong extends Observable<Long> {
    private final long count;
    private final long start;

    public ObservableRangeLong(long start, long count) {
        this.start = start;
        this.count = count;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super Long> o) {
        RangeDisposable parent = new RangeDisposable(o, this.start, this.count + this.start);
        o.onSubscribe(parent);
        parent.run();
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;
        final Observer<? super Long> downstream;
        final long end;
        boolean fused;
        long index;

        RangeDisposable(Observer<? super Long> actual, long start, long end) {
            this.downstream = actual;
            this.index = start;
            this.end = end;
        }

        void run() {
            if (this.fused) {
                return;
            }
            Observer<? super Long> actual = this.downstream;
            long e = this.end;
            for (long i = this.index; i != e && get() == 0; i++) {
                actual.onNext(Long.valueOf(i));
            }
            if (get() == 0) {
                lazySet(1);
                actual.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public Long poll() {
            long i = this.index;
            if (i != this.end) {
                this.index = 1 + i;
                return Long.valueOf(i);
            }
            lazySet(1);
            return null;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            set(1);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() != 0;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            if ((mode & 1) != 0) {
                this.fused = true;
                return 1;
            }
            return 0;
        }
    }
}