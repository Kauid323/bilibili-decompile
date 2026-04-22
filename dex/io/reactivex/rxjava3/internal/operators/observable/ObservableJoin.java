package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Objects;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd;
    final ObservableSource<? extends TRight> other;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;

    public ObservableJoin(ObservableSource<TLeft> source, ObservableSource<? extends TRight> other, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd, Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd, BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector) {
        super(source);
        this.other = other;
        this.leftEnd = leftEnd;
        this.rightEnd = rightEnd;
        this.resultSelector = resultSelector;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> parent = new JoinDisposable<>(observer, this.leftEnd, this.rightEnd, this.resultSelector);
        observer.onSubscribe(parent);
        ObservableGroupJoin.LeftRightObserver left = new ObservableGroupJoin.LeftRightObserver(parent, true);
        parent.disposables.add(left);
        ObservableGroupJoin.LeftRightObserver right = new ObservableGroupJoin.LeftRightObserver(parent, false);
        parent.disposables.add(right);
        this.source.subscribe(left);
        this.other.subscribe(right);
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, ObservableGroupJoin.JoinSupport {
        private static final long serialVersionUID = -6071216598687999801L;
        volatile boolean cancelled;
        final Observer<? super R> downstream;
        final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd;
        int leftIndex;
        final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final CompositeDisposable disposables = new CompositeDisposable();
        final SpscLinkedArrayQueue<Object> queue = new SpscLinkedArrayQueue<>(Observable.bufferSize());
        final Map<Integer, TLeft> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        JoinDisposable(Observer<? super R> actual, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> leftEnd, Function<? super TRight, ? extends ObservableSource<TRightEnd>> rightEnd, BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector) {
            this.downstream = actual;
            this.leftEnd = leftEnd;
            this.rightEnd = rightEnd;
            this.resultSelector = resultSelector;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        void cancelAll() {
            this.disposables.dispose();
        }

        void errorAll(Observer<?> a) {
            Throwable ex = ExceptionHelper.terminate(this.error);
            this.lefts.clear();
            this.rights.clear();
            a.onError(ex);
        }

        void fail(Throwable exc, Observer<?> a, SpscLinkedArrayQueue<?> q) {
            Exceptions.throwIfFatal(exc);
            ExceptionHelper.addThrowable(this.error, exc);
            q.clear();
            cancelAll();
            errorAll(a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<Object> q = this.queue;
            Observer<? super R> a = this.downstream;
            int missed = 1;
            while (!this.cancelled) {
                Throwable ex = this.error.get();
                if (ex != null) {
                    q.clear();
                    cancelAll();
                    errorAll(a);
                    return;
                }
                boolean d = this.active.get() == 0;
                Integer mode = (Integer) q.poll();
                boolean empty = mode == null;
                if (d && empty) {
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    a.onComplete();
                    return;
                } else if (empty) {
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                } else {
                    Object val = q.poll();
                    if (mode == LEFT_VALUE) {
                        int idx = this.leftIndex;
                        this.leftIndex = idx + 1;
                        this.lefts.put(Integer.valueOf(idx), val);
                        try {
                            ObservableSource<TLeftEnd> p = (ObservableSource) Objects.requireNonNull(this.leftEnd.apply(val), "The leftEnd returned a null ObservableSource");
                            ObservableGroupJoin.LeftRightEndObserver end = new ObservableGroupJoin.LeftRightEndObserver(this, true, idx);
                            this.disposables.add(end);
                            p.subscribe(end);
                            Throwable ex2 = this.error.get();
                            if (ex2 != null) {
                                q.clear();
                                cancelAll();
                                errorAll(a);
                                return;
                            }
                            Iterator<TRight> it = this.rights.values().iterator();
                            while (it.hasNext()) {
                                TRight right = it.next();
                                Iterator<TRight> it2 = it;
                                try {
                                    a.onNext((Object) Objects.requireNonNull(this.resultSelector.apply(val, right), "The resultSelector returned a null value"));
                                    it = it2;
                                } catch (Throwable exc) {
                                    fail(exc, a, q);
                                    return;
                                }
                            }
                            continue;
                        } catch (Throwable exc2) {
                            fail(exc2, a, q);
                            return;
                        }
                    } else if (mode == RIGHT_VALUE) {
                        int idx2 = this.rightIndex;
                        this.rightIndex = idx2 + 1;
                        this.rights.put(Integer.valueOf(idx2), val);
                        try {
                            ObservableSource<TRightEnd> p2 = (ObservableSource) Objects.requireNonNull(this.rightEnd.apply(val), "The rightEnd returned a null ObservableSource");
                            ObservableGroupJoin.LeftRightEndObserver end2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, idx2);
                            this.disposables.add(end2);
                            p2.subscribe(end2);
                            Throwable ex3 = this.error.get();
                            if (ex3 != null) {
                                q.clear();
                                cancelAll();
                                errorAll(a);
                                return;
                            }
                            Iterator<TLeft> it3 = this.lefts.values().iterator();
                            while (it3.hasNext()) {
                                TLeft left = it3.next();
                                Iterator<TLeft> it4 = it3;
                                try {
                                    a.onNext((Object) Objects.requireNonNull(this.resultSelector.apply(left, val), "The resultSelector returned a null value"));
                                    it3 = it4;
                                } catch (Throwable exc3) {
                                    fail(exc3, a, q);
                                    return;
                                }
                            }
                            continue;
                        } catch (Throwable exc4) {
                            fail(exc4, a, q);
                            return;
                        }
                    } else if (mode == LEFT_CLOSE) {
                        ObservableGroupJoin.LeftRightEndObserver end3 = (ObservableGroupJoin.LeftRightEndObserver) val;
                        this.lefts.remove(Integer.valueOf(end3.index));
                        this.disposables.remove(end3);
                    } else {
                        ObservableGroupJoin.LeftRightEndObserver end4 = (ObservableGroupJoin.LeftRightEndObserver) val;
                        this.rights.remove(Integer.valueOf(end4.index));
                        this.disposables.remove(end4);
                    }
                }
            }
            q.clear();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerError(Throwable ex) {
            if (ExceptionHelper.addThrowable(this.error, ex)) {
                this.active.decrementAndGet();
                drain();
                return;
            }
            RxJavaPlugins.onError(ex);
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerComplete(ObservableGroupJoin.LeftRightObserver sender) {
            this.disposables.delete(sender);
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerValue(boolean isLeft, Object o) {
            synchronized (this) {
                this.queue.offer(isLeft ? LEFT_VALUE : RIGHT_VALUE, o);
            }
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerClose(boolean isLeft, ObservableGroupJoin.LeftRightEndObserver index) {
            synchronized (this) {
                this.queue.offer(isLeft ? LEFT_CLOSE : RIGHT_CLOSE, index);
            }
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerCloseError(Throwable ex) {
            if (ExceptionHelper.addThrowable(this.error, ex)) {
                drain();
            } else {
                RxJavaPlugins.onError(ex);
            }
        }
    }
}