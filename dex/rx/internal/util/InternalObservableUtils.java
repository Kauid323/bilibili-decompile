package rx.internal.util;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.Observable;
import rx.Scheduler;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.operators.OperatorAny;
import rx.observables.ConnectableObservable;

public enum InternalObservableUtils {
    ;
    
    public static final PlusOneLongFunc2 LONG_COUNTER = new Func2<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.PlusOneLongFunc2
        public Long call(Long count, Object o) {
            return Long.valueOf(count.longValue() + 1);
        }
    };
    public static final ObjectEqualsFunc2 OBJECT_EQUALS = new Func2<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.ObjectEqualsFunc2
        /* renamed from: call */
        public Boolean m2993call(Object first, Object second) {
            return Boolean.valueOf(first == second || (first != null && first.equals(second)));
        }
    };
    public static final ToArrayFunc1 TO_ARRAY = new Func1<List<? extends Observable<?>>, Observable<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.ToArrayFunc1
        public Observable<?>[] call(List<? extends Observable<?>> o) {
            return (Observable[]) o.toArray(new Observable[o.size()]);
        }
    };
    static final ReturnsVoidFunc1 RETURNS_VOID = new ReturnsVoidFunc1();
    public static final PlusOneFunc2 COUNTER = new Func2<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.PlusOneFunc2
        public Integer call(Integer count, Object o) {
            return Integer.valueOf(count.intValue() + 1);
        }
    };
    static final NotificationErrorExtractor ERROR_EXTRACTOR = new NotificationErrorExtractor();
    public static final Action1<Throwable> ERROR_NOT_IMPLEMENTED = new Action1<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.ErrorNotImplementedAction
        public void call(Throwable t) {
            throw new OnErrorNotImplementedException(t);
        }
    };
    public static final Observable.Operator<Boolean, Object> IS_EMPTY = new OperatorAny(UtilityFunctions.alwaysTrue(), true);

    public static Func1<Object, Boolean> equalsWith(Object other) {
        return new EqualsWithFunc1(other);
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class EqualsWithFunc1 implements Func1<Object, Boolean> {
        final Object other;

        public EqualsWithFunc1(Object other) {
            this.other = other;
        }

        /* renamed from: call */
        public Boolean m2991call(Object t) {
            return Boolean.valueOf(t == this.other || (t != null && t.equals(this.other)));
        }
    }

    public static Func1<Object, Boolean> isInstanceOf(Class<?> clazz) {
        return new IsInstanceOfFunc1(clazz);
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class IsInstanceOfFunc1 implements Func1<Object, Boolean> {
        final Class<?> clazz;

        public IsInstanceOfFunc1(Class<?> other) {
            this.clazz = other;
        }

        /* renamed from: call */
        public Boolean m2992call(Object t) {
            return Boolean.valueOf(this.clazz.isInstance(t));
        }
    }

    public static Func1<Observable<? extends Notification<?>>, Observable<?>> createRepeatDematerializer(Func1<? super Observable<? extends Void>, ? extends Observable<?>> notificationHandler) {
        return new RepeatNotificationDematerializer(notificationHandler);
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class RepeatNotificationDematerializer implements Func1<Observable<? extends Notification<?>>, Observable<?>> {
        final Func1<? super Observable<? extends Void>, ? extends Observable<?>> notificationHandler;

        public RepeatNotificationDematerializer(Func1<? super Observable<? extends Void>, ? extends Observable<?>> notificationHandler) {
            this.notificationHandler = notificationHandler;
        }

        public Observable<?> call(Observable<? extends Notification<?>> notifications) {
            return (Observable) this.notificationHandler.call(notifications.map(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ReturnsVoidFunc1 implements Func1<Object, Void> {
        ReturnsVoidFunc1() {
        }

        public Void call(Object t) {
            return null;
        }
    }

    public static <T, R> Func1<Observable<T>, Observable<R>> createReplaySelectorAndObserveOn(Func1<? super Observable<T>, ? extends Observable<R>> selector, Scheduler scheduler) {
        return new SelectorAndObserveOn(selector, scheduler);
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class SelectorAndObserveOn<T, R> implements Func1<Observable<T>, Observable<R>> {
        final Scheduler scheduler;
        final Func1<? super Observable<T>, ? extends Observable<R>> selector;

        public /* bridge */ /* synthetic */ Object call(Object x0) {
            return call((Observable) ((Observable) x0));
        }

        public SelectorAndObserveOn(Func1<? super Observable<T>, ? extends Observable<R>> selector, Scheduler scheduler) {
            this.selector = selector;
            this.scheduler = scheduler;
        }

        public Observable<R> call(Observable<T> t) {
            return ((Observable) this.selector.call(t)).observeOn(this.scheduler);
        }
    }

    public static Func1<Observable<? extends Notification<?>>, Observable<?>> createRetryDematerializer(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> notificationHandler) {
        return new RetryNotificationDematerializer(notificationHandler);
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class RetryNotificationDematerializer implements Func1<Observable<? extends Notification<?>>, Observable<?>> {
        final Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> notificationHandler;

        public RetryNotificationDematerializer(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> notificationHandler) {
            this.notificationHandler = notificationHandler;
        }

        public Observable<?> call(Observable<? extends Notification<?>> notifications) {
            return (Observable) this.notificationHandler.call(notifications.map(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class NotificationErrorExtractor implements Func1<Notification<?>, Throwable> {
        NotificationErrorExtractor() {
        }

        public Throwable call(Notification<?> t) {
            return t.getThrowable();
        }
    }

    public static <T> Func0<ConnectableObservable<T>> createReplaySupplier(Observable<T> source) {
        return new ReplaySupplierNoParams(source);
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class ReplaySupplierNoParams<T> implements Func0<ConnectableObservable<T>> {
        private final Observable<T> source;

        ReplaySupplierNoParams(Observable<T> source) {
            this.source = source;
        }

        public ConnectableObservable<T> call() {
            return this.source.replay();
        }
    }

    public static <T> Func0<ConnectableObservable<T>> createReplaySupplier(Observable<T> source, int bufferSize) {
        return new ReplaySupplierBuffer(source, bufferSize);
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class ReplaySupplierBuffer<T> implements Func0<ConnectableObservable<T>> {
        private final int bufferSize;
        private final Observable<T> source;

        ReplaySupplierBuffer(Observable<T> source, int bufferSize) {
            this.source = source;
            this.bufferSize = bufferSize;
        }

        public ConnectableObservable<T> call() {
            return this.source.replay(this.bufferSize);
        }
    }

    public static <T> Func0<ConnectableObservable<T>> createReplaySupplier(Observable<T> source, long time, TimeUnit unit, Scheduler scheduler) {
        return new ReplaySupplierBufferTime(source, time, unit, scheduler);
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class ReplaySupplierBufferTime<T> implements Func0<ConnectableObservable<T>> {
        private final Scheduler scheduler;
        private final Observable<T> source;
        private final long time;
        private final TimeUnit unit;

        ReplaySupplierBufferTime(Observable<T> source, long time, TimeUnit unit, Scheduler scheduler) {
            this.unit = unit;
            this.source = source;
            this.time = time;
            this.scheduler = scheduler;
        }

        public ConnectableObservable<T> call() {
            return this.source.replay(this.time, this.unit, this.scheduler);
        }
    }

    public static <T> Func0<ConnectableObservable<T>> createReplaySupplier(Observable<T> source, int bufferSize, long time, TimeUnit unit, Scheduler scheduler) {
        return new ReplaySupplierTime(source, bufferSize, time, unit, scheduler);
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class ReplaySupplierTime<T> implements Func0<ConnectableObservable<T>> {
        private final int bufferSize;
        private final Scheduler scheduler;
        private final Observable<T> source;
        private final long time;
        private final TimeUnit unit;

        ReplaySupplierTime(Observable<T> source, int bufferSize, long time, TimeUnit unit, Scheduler scheduler) {
            this.time = time;
            this.unit = unit;
            this.scheduler = scheduler;
            this.bufferSize = bufferSize;
            this.source = source;
        }

        public ConnectableObservable<T> call() {
            return this.source.replay(this.bufferSize, this.time, this.unit, this.scheduler);
        }
    }

    public static <T, R> Func2<R, T, R> createCollectorCaller(Action2<R, ? super T> collector) {
        return new CollectorCaller(collector);
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class CollectorCaller<T, R> implements Func2<R, T, R> {
        final Action2<R, ? super T> collector;

        public CollectorCaller(Action2<R, ? super T> collector) {
            this.collector = collector;
        }

        public R call(R state, T value) {
            this.collector.call(state, value);
            return state;
        }
    }
}