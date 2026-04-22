package rx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;
import rx.BackpressureOverflow;
import rx.Emitter;
import rx.Single;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Actions;
import rx.functions.Func0;
import rx.functions.Func1;
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
import rx.internal.observers.AssertableSubscriberObservable;
import rx.internal.operators.CachedObservable;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.NeverObservableHolder;
import rx.internal.operators.OnSubscribeAmb;
import rx.internal.operators.OnSubscribeCollect;
import rx.internal.operators.OnSubscribeCombineLatest;
import rx.internal.operators.OnSubscribeConcatMap;
import rx.internal.operators.OnSubscribeCreate;
import rx.internal.operators.OnSubscribeDefer;
import rx.internal.operators.OnSubscribeDelaySubscription;
import rx.internal.operators.OnSubscribeDelaySubscriptionOther;
import rx.internal.operators.OnSubscribeDelaySubscriptionWithSelector;
import rx.internal.operators.OnSubscribeDetach;
import rx.internal.operators.OnSubscribeDoOnEach;
import rx.internal.operators.OnSubscribeFilter;
import rx.internal.operators.OnSubscribeFlatMapCompletable;
import rx.internal.operators.OnSubscribeFlatMapSingle;
import rx.internal.operators.OnSubscribeFlattenIterable;
import rx.internal.operators.OnSubscribeFromArray;
import rx.internal.operators.OnSubscribeFromCallable;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OnSubscribeGroupJoin;
import rx.internal.operators.OnSubscribeJoin;
import rx.internal.operators.OnSubscribeLift;
import rx.internal.operators.OnSubscribeMap;
import rx.internal.operators.OnSubscribeRange;
import rx.internal.operators.OnSubscribeRedo;
import rx.internal.operators.OnSubscribeReduce;
import rx.internal.operators.OnSubscribeReduceSeed;
import rx.internal.operators.OnSubscribeSingle;
import rx.internal.operators.OnSubscribeSkipTimed;
import rx.internal.operators.OnSubscribeSwitchIfEmpty;
import rx.internal.operators.OnSubscribeTakeLastOne;
import rx.internal.operators.OnSubscribeThrow;
import rx.internal.operators.OnSubscribeTimerOnce;
import rx.internal.operators.OnSubscribeTimerPeriodically;
import rx.internal.operators.OnSubscribeToMap;
import rx.internal.operators.OnSubscribeToMultimap;
import rx.internal.operators.OnSubscribeToObservableFuture;
import rx.internal.operators.OnSubscribeUsing;
import rx.internal.operators.OperatorAll;
import rx.internal.operators.OperatorAny;
import rx.internal.operators.OperatorAsObservable;
import rx.internal.operators.OperatorBufferWithSingleObservable;
import rx.internal.operators.OperatorBufferWithSize;
import rx.internal.operators.OperatorBufferWithStartEndObservable;
import rx.internal.operators.OperatorBufferWithTime;
import rx.internal.operators.OperatorCast;
import rx.internal.operators.OperatorDebounceWithSelector;
import rx.internal.operators.OperatorDebounceWithTime;
import rx.internal.operators.OperatorDelay;
import rx.internal.operators.OperatorDelayWithSelector;
import rx.internal.operators.OperatorDematerialize;
import rx.internal.operators.OperatorDistinct;
import rx.internal.operators.OperatorDistinctUntilChanged;
import rx.internal.operators.OperatorDoAfterTerminate;
import rx.internal.operators.OperatorDoOnRequest;
import rx.internal.operators.OperatorDoOnSubscribe;
import rx.internal.operators.OperatorDoOnUnsubscribe;
import rx.internal.operators.OperatorEagerConcatMap;
import rx.internal.operators.OperatorElementAt;
import rx.internal.operators.OperatorGroupBy;
import rx.internal.operators.OperatorIgnoreElements;
import rx.internal.operators.OperatorMapNotification;
import rx.internal.operators.OperatorMapPair;
import rx.internal.operators.OperatorMaterialize;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorObserveOn;
import rx.internal.operators.OperatorOnBackpressureBuffer;
import rx.internal.operators.OperatorOnBackpressureDrop;
import rx.internal.operators.OperatorOnBackpressureLatest;
import rx.internal.operators.OperatorOnErrorResumeNextViaFunction;
import rx.internal.operators.OperatorPublish;
import rx.internal.operators.OperatorReplay;
import rx.internal.operators.OperatorRetryWithPredicate;
import rx.internal.operators.OperatorSampleWithObservable;
import rx.internal.operators.OperatorSampleWithTime;
import rx.internal.operators.OperatorScan;
import rx.internal.operators.OperatorSequenceEqual;
import rx.internal.operators.OperatorSerialize;
import rx.internal.operators.OperatorSingle;
import rx.internal.operators.OperatorSkip;
import rx.internal.operators.OperatorSkipLast;
import rx.internal.operators.OperatorSkipLastTimed;
import rx.internal.operators.OperatorSkipUntil;
import rx.internal.operators.OperatorSkipWhile;
import rx.internal.operators.OperatorSubscribeOn;
import rx.internal.operators.OperatorSwitch;
import rx.internal.operators.OperatorTake;
import rx.internal.operators.OperatorTakeLast;
import rx.internal.operators.OperatorTakeLastTimed;
import rx.internal.operators.OperatorTakeTimed;
import rx.internal.operators.OperatorTakeUntil;
import rx.internal.operators.OperatorTakeUntilPredicate;
import rx.internal.operators.OperatorTakeWhile;
import rx.internal.operators.OperatorThrottleFirst;
import rx.internal.operators.OperatorTimeInterval;
import rx.internal.operators.OperatorTimeout;
import rx.internal.operators.OperatorTimeoutWithSelector;
import rx.internal.operators.OperatorTimestamp;
import rx.internal.operators.OperatorToObservableList;
import rx.internal.operators.OperatorToObservableSortedList;
import rx.internal.operators.OperatorUnsubscribeOn;
import rx.internal.operators.OperatorWindowWithObservable;
import rx.internal.operators.OperatorWindowWithObservableFactory;
import rx.internal.operators.OperatorWindowWithSize;
import rx.internal.operators.OperatorWindowWithStartEndObservable;
import rx.internal.operators.OperatorWindowWithTime;
import rx.internal.operators.OperatorWithLatestFrom;
import rx.internal.operators.OperatorWithLatestFromMany;
import rx.internal.operators.OperatorZip;
import rx.internal.operators.OperatorZipIterable;
import rx.internal.util.ActionNotificationObserver;
import rx.internal.util.ActionObserver;
import rx.internal.util.ActionSubscriber;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ObserverSubscriber;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.observables.AsyncOnSubscribe;
import rx.observables.BlockingObservable;
import rx.observables.ConnectableObservable;
import rx.observables.GroupedObservable;
import rx.observables.SyncOnSubscribe;
import rx.observers.AssertableSubscriber;
import rx.observers.SafeSubscriber;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;
import rx.schedulers.TimeInterval;
import rx.schedulers.Timestamped;
import rx.subscriptions.Subscriptions;

public class Observable<T> {
    final OnSubscribe<T> onSubscribe;

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface OnSubscribe<T> extends Action1<Subscriber<? super T>> {
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface Operator<R, T> extends Func1<Subscriber<? super R>, Subscriber<? super T>> {
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface Transformer<T, R> extends Func1<Observable<T>, Observable<R>> {
    }

    protected Observable(OnSubscribe<T> f) {
        this.onSubscribe = f;
    }

    @Deprecated
    public static <T> Observable<T> create(OnSubscribe<T> f) {
        return new Observable<>(RxJavaHooks.onCreate(f));
    }

    public static <T> Observable<T> create(Action1<Emitter<T>> emitter, Emitter.BackpressureMode backpressure) {
        return unsafeCreate(new OnSubscribeCreate(emitter, backpressure));
    }

    public static <T> Observable<T> unsafeCreate(OnSubscribe<T> f) {
        return new Observable<>(RxJavaHooks.onCreate(f));
    }

    public static <S, T> Observable<T> create(SyncOnSubscribe<S, T> syncOnSubscribe) {
        return unsafeCreate(syncOnSubscribe);
    }

    public static <S, T> Observable<T> create(AsyncOnSubscribe<S, T> asyncOnSubscribe) {
        return unsafeCreate(asyncOnSubscribe);
    }

    public final <R> Observable<R> lift(Operator<? extends R, ? super T> operator) {
        return unsafeCreate(new OnSubscribeLift(this.onSubscribe, operator));
    }

    public <R> Observable<R> compose(Transformer<? super T, ? extends R> transformer) {
        return (Observable) transformer.call(this);
    }

    public final <R> R to(Func1<? super Observable<T>, R> converter) {
        return converter.call(this);
    }

    public Single<T> toSingle() {
        return new Single<>((Single.OnSubscribe) OnSubscribeSingle.create(this));
    }

    public Completable toCompletable() {
        return Completable.fromObservable(this);
    }

    public static <T> Observable<T> amb(Iterable<? extends Observable<? extends T>> sources) {
        return unsafeCreate(OnSubscribeAmb.amb(sources));
    }

    public static <T> Observable<T> amb(Observable<? extends T> o1, Observable<? extends T> o2) {
        return unsafeCreate(OnSubscribeAmb.amb(o1, o2));
    }

    public static <T> Observable<T> amb(Observable<? extends T> o1, Observable<? extends T> o2, Observable<? extends T> o3) {
        return unsafeCreate(OnSubscribeAmb.amb(o1, o2, o3));
    }

    public static <T> Observable<T> amb(Observable<? extends T> o1, Observable<? extends T> o2, Observable<? extends T> o3, Observable<? extends T> o4) {
        return unsafeCreate(OnSubscribeAmb.amb(o1, o2, o3, o4));
    }

    public static <T> Observable<T> amb(Observable<? extends T> o1, Observable<? extends T> o2, Observable<? extends T> o3, Observable<? extends T> o4, Observable<? extends T> o5) {
        return unsafeCreate(OnSubscribeAmb.amb(o1, o2, o3, o4, o5));
    }

    public static <T> Observable<T> amb(Observable<? extends T> o1, Observable<? extends T> o2, Observable<? extends T> o3, Observable<? extends T> o4, Observable<? extends T> o5, Observable<? extends T> o6) {
        return unsafeCreate(OnSubscribeAmb.amb(o1, o2, o3, o4, o5, o6));
    }

    public static <T> Observable<T> amb(Observable<? extends T> o1, Observable<? extends T> o2, Observable<? extends T> o3, Observable<? extends T> o4, Observable<? extends T> o5, Observable<? extends T> o6, Observable<? extends T> o7) {
        return unsafeCreate(OnSubscribeAmb.amb(o1, o2, o3, o4, o5, o6, o7));
    }

    public static <T> Observable<T> amb(Observable<? extends T> o1, Observable<? extends T> o2, Observable<? extends T> o3, Observable<? extends T> o4, Observable<? extends T> o5, Observable<? extends T> o6, Observable<? extends T> o7, Observable<? extends T> o8) {
        return unsafeCreate(OnSubscribeAmb.amb(o1, o2, o3, o4, o5, o6, o7, o8));
    }

    public static <T> Observable<T> amb(Observable<? extends T> o1, Observable<? extends T> o2, Observable<? extends T> o3, Observable<? extends T> o4, Observable<? extends T> o5, Observable<? extends T> o6, Observable<? extends T> o7, Observable<? extends T> o8, Observable<? extends T> o9) {
        return unsafeCreate(OnSubscribeAmb.amb(o1, o2, o3, o4, o5, o6, o7, o8, o9));
    }

    public static <T1, T2, R> Observable<R> combineLatest(Observable<? extends T1> o1, Observable<? extends T2> o2, Func2<? super T1, ? super T2, ? extends R> combineFunction) {
        return combineLatest(Arrays.asList(o1, o2), Functions.fromFunc(combineFunction));
    }

    public static <T1, T2, T3, R> Observable<R> combineLatest(Observable<? extends T1> o1, Observable<? extends T2> o2, Observable<? extends T3> o3, Func3<? super T1, ? super T2, ? super T3, ? extends R> combineFunction) {
        return combineLatest(Arrays.asList(o1, o2, o3), Functions.fromFunc(combineFunction));
    }

    public static <T1, T2, T3, T4, R> Observable<R> combineLatest(Observable<? extends T1> o1, Observable<? extends T2> o2, Observable<? extends T3> o3, Observable<? extends T4> o4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> combineFunction) {
        return combineLatest(Arrays.asList(o1, o2, o3, o4), Functions.fromFunc(combineFunction));
    }

    public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(Observable<? extends T1> o1, Observable<? extends T2> o2, Observable<? extends T3> o3, Observable<? extends T4> o4, Observable<? extends T5> o5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> combineFunction) {
        return combineLatest(Arrays.asList(o1, o2, o3, o4, o5), Functions.fromFunc(combineFunction));
    }

    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(Observable<? extends T1> o1, Observable<? extends T2> o2, Observable<? extends T3> o3, Observable<? extends T4> o4, Observable<? extends T5> o5, Observable<? extends T6> o6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> combineFunction) {
        return combineLatest(Arrays.asList(o1, o2, o3, o4, o5, o6), Functions.fromFunc(combineFunction));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(Observable<? extends T1> o1, Observable<? extends T2> o2, Observable<? extends T3> o3, Observable<? extends T4> o4, Observable<? extends T5> o5, Observable<? extends T6> o6, Observable<? extends T7> o7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> combineFunction) {
        return combineLatest(Arrays.asList(o1, o2, o3, o4, o5, o6, o7), Functions.fromFunc(combineFunction));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(Observable<? extends T1> o1, Observable<? extends T2> o2, Observable<? extends T3> o3, Observable<? extends T4> o4, Observable<? extends T5> o5, Observable<? extends T6> o6, Observable<? extends T7> o7, Observable<? extends T8> o8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> combineFunction) {
        return combineLatest(Arrays.asList(o1, o2, o3, o4, o5, o6, o7, o8), Functions.fromFunc(combineFunction));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(Observable<? extends T1> o1, Observable<? extends T2> o2, Observable<? extends T3> o3, Observable<? extends T4> o4, Observable<? extends T5> o5, Observable<? extends T6> o6, Observable<? extends T7> o7, Observable<? extends T8> o8, Observable<? extends T9> o9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> combineFunction) {
        return combineLatest(Arrays.asList(o1, o2, o3, o4, o5, o6, o7, o8, o9), Functions.fromFunc(combineFunction));
    }

    public static <T, R> Observable<R> combineLatest(List<? extends Observable<? extends T>> sources, FuncN<? extends R> combineFunction) {
        return unsafeCreate(new OnSubscribeCombineLatest(sources, combineFunction));
    }

    public static <T, R> Observable<R> combineLatest(Iterable<? extends Observable<? extends T>> sources, FuncN<? extends R> combineFunction) {
        return unsafeCreate(new OnSubscribeCombineLatest(sources, combineFunction));
    }

    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends Observable<? extends T>> sources, FuncN<? extends R> combineFunction) {
        return unsafeCreate(new OnSubscribeCombineLatest((Observable[]) null, sources, combineFunction, RxRingBuffer.SIZE, true));
    }

    public static <T> Observable<T> concat(Iterable<? extends Observable<? extends T>> sequences) {
        return concat(from(sequences));
    }

    public static <T> Observable<T> concat(Observable<? extends Observable<? extends T>> observables) {
        return (Observable<T>) observables.concatMap(UtilityFunctions.identity());
    }

    public static <T> Observable<T> concat(Observable<? extends T> t1, Observable<? extends T> t2) {
        return concat(just(t1, t2));
    }

    public static <T> Observable<T> concat(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3) {
        return concat(just(t1, t2, t3));
    }

    public static <T> Observable<T> concat(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4) {
        return concat(just(t1, t2, t3, t4));
    }

    public static <T> Observable<T> concat(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5) {
        return concat(just(t1, t2, t3, t4, t5));
    }

    public static <T> Observable<T> concat(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5, Observable<? extends T> t6) {
        return concat(just(t1, t2, t3, t4, t5, t6));
    }

    public static <T> Observable<T> concat(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5, Observable<? extends T> t6, Observable<? extends T> t7) {
        return concat(just(t1, t2, t3, t4, t5, t6, t7));
    }

    public static <T> Observable<T> concat(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5, Observable<? extends T> t6, Observable<? extends T> t7, Observable<? extends T> t8) {
        return concat(just(t1, t2, t3, t4, t5, t6, t7, t8));
    }

    public static <T> Observable<T> concat(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5, Observable<? extends T> t6, Observable<? extends T> t7, Observable<? extends T> t8, Observable<? extends T> t9) {
        return concat(just(t1, t2, t3, t4, t5, t6, t7, t8, t9));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends Observable<? extends T>> sources) {
        return (Observable<T>) sources.concatMapDelayError(UtilityFunctions.identity());
    }

    public static <T> Observable<T> concatDelayError(Iterable<? extends Observable<? extends T>> sources) {
        return concatDelayError(from(sources));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends T> t1, Observable<? extends T> t2) {
        return concatDelayError(just(t1, t2));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3) {
        return concatDelayError(just(t1, t2, t3));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4) {
        return concatDelayError(just(t1, t2, t3, t4));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5) {
        return concatDelayError(just(t1, t2, t3, t4, t5));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5, Observable<? extends T> t6) {
        return concatDelayError(just(t1, t2, t3, t4, t5, t6));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5, Observable<? extends T> t6, Observable<? extends T> t7) {
        return concatDelayError(just(t1, t2, t3, t4, t5, t6, t7));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5, Observable<? extends T> t6, Observable<? extends T> t7, Observable<? extends T> t8) {
        return concatDelayError(just(t1, t2, t3, t4, t5, t6, t7, t8));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5, Observable<? extends T> t6, Observable<? extends T> t7, Observable<? extends T> t8, Observable<? extends T> t9) {
        return concatDelayError(just(t1, t2, t3, t4, t5, t6, t7, t8, t9));
    }

    public static <T> Observable<T> defer(Func0<Observable<T>> observableFactory) {
        return unsafeCreate(new OnSubscribeDefer(observableFactory));
    }

    public static <T> Observable<T> empty() {
        return EmptyObservableHolder.instance();
    }

    public static <T> Observable<T> error(Throwable exception) {
        return unsafeCreate(new OnSubscribeThrow(exception));
    }

    public static <T> Observable<T> from(Future<? extends T> future) {
        return unsafeCreate(OnSubscribeToObservableFuture.toObservableFuture(future));
    }

    public static <T> Observable<T> from(Future<? extends T> future, long timeout, TimeUnit unit) {
        return unsafeCreate(OnSubscribeToObservableFuture.toObservableFuture(future, timeout, unit));
    }

    public static <T> Observable<T> from(Future<? extends T> future, Scheduler scheduler) {
        Observable<T> o = unsafeCreate(OnSubscribeToObservableFuture.toObservableFuture(future));
        return o.subscribeOn(scheduler);
    }

    public static <T> Observable<T> from(Iterable<? extends T> iterable) {
        return unsafeCreate(new OnSubscribeFromIterable(iterable));
    }

    public static <T> Observable<T> from(T[] array) {
        int n = array.length;
        if (n == 0) {
            return empty();
        }
        if (n == 1) {
            return just(array[0]);
        }
        return unsafeCreate(new OnSubscribeFromArray(array));
    }

    public static <T> Observable<T> fromCallable(Callable<? extends T> func) {
        return unsafeCreate(new OnSubscribeFromCallable(func));
    }

    public static Observable<Long> interval(long interval, TimeUnit unit) {
        return interval(interval, interval, unit, Schedulers.computation());
    }

    public static Observable<Long> interval(long interval, TimeUnit unit, Scheduler scheduler) {
        return interval(interval, interval, unit, scheduler);
    }

    public static Observable<Long> interval(long initialDelay, long period, TimeUnit unit) {
        return interval(initialDelay, period, unit, Schedulers.computation());
    }

    public static Observable<Long> interval(long initialDelay, long period, TimeUnit unit, Scheduler scheduler) {
        return unsafeCreate(new OnSubscribeTimerPeriodically(initialDelay, period, unit, scheduler));
    }

    public static <T> Observable<T> just(T value) {
        return ScalarSynchronousObservable.create(value);
    }

    public static <T> Observable<T> just(T t1, T t2) {
        return from(new Object[]{t1, t2});
    }

    public static <T> Observable<T> just(T t1, T t2, T t3) {
        return from(new Object[]{t1, t2, t3});
    }

    public static <T> Observable<T> just(T t1, T t2, T t3, T t4) {
        return from(new Object[]{t1, t2, t3, t4});
    }

    public static <T> Observable<T> just(T t1, T t2, T t3, T t4, T t5) {
        return from(new Object[]{t1, t2, t3, t4, t5});
    }

    public static <T> Observable<T> just(T t1, T t2, T t3, T t4, T t5, T t6) {
        return from(new Object[]{t1, t2, t3, t4, t5, t6});
    }

    public static <T> Observable<T> just(T t1, T t2, T t3, T t4, T t5, T t6, T t7) {
        return from(new Object[]{t1, t2, t3, t4, t5, t6, t7});
    }

    public static <T> Observable<T> just(T t1, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        return from(new Object[]{t1, t2, t3, t4, t5, t6, t7, t8});
    }

    public static <T> Observable<T> just(T t1, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        return from(new Object[]{t1, t2, t3, t4, t5, t6, t7, t8, t9});
    }

    public static <T> Observable<T> just(T t1, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        return from(new Object[]{t1, t2, t3, t4, t5, t6, t7, t8, t9, t10});
    }

    public static <T> Observable<T> merge(Iterable<? extends Observable<? extends T>> sequences) {
        return merge(from(sequences));
    }

    public static <T> Observable<T> merge(Iterable<? extends Observable<? extends T>> sequences, int maxConcurrent) {
        return merge(from(sequences), maxConcurrent);
    }

    public static <T> Observable<T> merge(Observable<? extends Observable<? extends T>> source) {
        if (source.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) source).scalarFlatMap(UtilityFunctions.identity());
        }
        return (Observable<T>) source.lift(OperatorMerge.instance(false));
    }

    public static <T> Observable<T> merge(Observable<? extends Observable<? extends T>> source, int maxConcurrent) {
        if (source.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) source).scalarFlatMap(UtilityFunctions.identity());
        }
        return (Observable<T>) source.lift(OperatorMerge.instance(false, maxConcurrent));
    }

    public static <T> Observable<T> merge(Observable<? extends T> t1, Observable<? extends T> t2) {
        return merge(new Observable[]{t1, t2});
    }

    public static <T> Observable<T> merge(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3) {
        return merge(new Observable[]{t1, t2, t3});
    }

    public static <T> Observable<T> merge(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4) {
        return merge(new Observable[]{t1, t2, t3, t4});
    }

    public static <T> Observable<T> merge(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5) {
        return merge(new Observable[]{t1, t2, t3, t4, t5});
    }

    public static <T> Observable<T> merge(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5, Observable<? extends T> t6) {
        return merge(new Observable[]{t1, t2, t3, t4, t5, t6});
    }

    public static <T> Observable<T> merge(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5, Observable<? extends T> t6, Observable<? extends T> t7) {
        return merge(new Observable[]{t1, t2, t3, t4, t5, t6, t7});
    }

    public static <T> Observable<T> merge(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5, Observable<? extends T> t6, Observable<? extends T> t7, Observable<? extends T> t8) {
        return merge(new Observable[]{t1, t2, t3, t4, t5, t6, t7, t8});
    }

    public static <T> Observable<T> merge(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5, Observable<? extends T> t6, Observable<? extends T> t7, Observable<? extends T> t8, Observable<? extends T> t9) {
        return merge(new Observable[]{t1, t2, t3, t4, t5, t6, t7, t8, t9});
    }

    public static <T> Observable<T> merge(Observable<? extends T>[] sequences) {
        return merge(from(sequences));
    }

    public static <T> Observable<T> merge(Observable<? extends T>[] sequences, int maxConcurrent) {
        return merge(from(sequences), maxConcurrent);
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends Observable<? extends T>> source) {
        return (Observable<T>) source.lift(OperatorMerge.instance(true));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends Observable<? extends T>> source, int maxConcurrent) {
        return (Observable<T>) source.lift(OperatorMerge.instance(true, maxConcurrent));
    }

    public static <T> Observable<T> mergeDelayError(Iterable<? extends Observable<? extends T>> sequences) {
        return mergeDelayError(from(sequences));
    }

    public static <T> Observable<T> mergeDelayError(Iterable<? extends Observable<? extends T>> sequences, int maxConcurrent) {
        return mergeDelayError(from(sequences), maxConcurrent);
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> t1, Observable<? extends T> t2) {
        return mergeDelayError(just(t1, t2));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3) {
        return mergeDelayError(just(t1, t2, t3));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4) {
        return mergeDelayError(just(t1, t2, t3, t4));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5) {
        return mergeDelayError(just(t1, t2, t3, t4, t5));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5, Observable<? extends T> t6) {
        return mergeDelayError(just(t1, t2, t3, t4, t5, t6));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5, Observable<? extends T> t6, Observable<? extends T> t7) {
        return mergeDelayError(just(t1, t2, t3, t4, t5, t6, t7));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5, Observable<? extends T> t6, Observable<? extends T> t7, Observable<? extends T> t8) {
        return mergeDelayError(just(t1, t2, t3, t4, t5, t6, t7, t8));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> t1, Observable<? extends T> t2, Observable<? extends T> t3, Observable<? extends T> t4, Observable<? extends T> t5, Observable<? extends T> t6, Observable<? extends T> t7, Observable<? extends T> t8, Observable<? extends T> t9) {
        return mergeDelayError(just(t1, t2, t3, t4, t5, t6, t7, t8, t9));
    }

    public final Observable<Observable<T>> nest() {
        return just(this);
    }

    public static <T> Observable<T> never() {
        return NeverObservableHolder.instance();
    }

    public static Observable<Integer> range(int start, int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count can not be negative");
        }
        if (count == 0) {
            return empty();
        }
        if (start > (Integer.MAX_VALUE - count) + 1) {
            throw new IllegalArgumentException("start + count can not exceed Integer.MAX_VALUE");
        }
        if (count == 1) {
            return just(Integer.valueOf(start));
        }
        return unsafeCreate(new OnSubscribeRange(start, (count - 1) + start));
    }

    public static Observable<Integer> range(int start, int count, Scheduler scheduler) {
        return range(start, count).subscribeOn(scheduler);
    }

    public static <T> Observable<Boolean> sequenceEqual(Observable<? extends T> first, Observable<? extends T> second) {
        return sequenceEqual(first, second, InternalObservableUtils.OBJECT_EQUALS);
    }

    public static <T> Observable<Boolean> sequenceEqual(Observable<? extends T> first, Observable<? extends T> second, Func2<? super T, ? super T, Boolean> equality) {
        return OperatorSequenceEqual.sequenceEqual(first, second, equality);
    }

    public static <T> Observable<T> switchOnNext(Observable<? extends Observable<? extends T>> sequenceOfSequences) {
        return (Observable<T>) sequenceOfSequences.lift(OperatorSwitch.instance(false));
    }

    public static <T> Observable<T> switchOnNextDelayError(Observable<? extends Observable<? extends T>> sequenceOfSequences) {
        return (Observable<T>) sequenceOfSequences.lift(OperatorSwitch.instance(true));
    }

    @Deprecated
    public static Observable<Long> timer(long initialDelay, long period, TimeUnit unit) {
        return interval(initialDelay, period, unit, Schedulers.computation());
    }

    @Deprecated
    public static Observable<Long> timer(long initialDelay, long period, TimeUnit unit, Scheduler scheduler) {
        return interval(initialDelay, period, unit, scheduler);
    }

    public static Observable<Long> timer(long delay, TimeUnit unit) {
        return timer(delay, unit, Schedulers.computation());
    }

    public static Observable<Long> timer(long delay, TimeUnit unit, Scheduler scheduler) {
        return unsafeCreate(new OnSubscribeTimerOnce(delay, unit, scheduler));
    }

    public static <T, Resource> Observable<T> using(Func0<Resource> resourceFactory, Func1<? super Resource, ? extends Observable<? extends T>> observableFactory, Action1<? super Resource> disposeAction) {
        return using(resourceFactory, observableFactory, disposeAction, false);
    }

    public static <T, Resource> Observable<T> using(Func0<Resource> resourceFactory, Func1<? super Resource, ? extends Observable<? extends T>> observableFactory, Action1<? super Resource> disposeAction, boolean disposeEagerly) {
        return unsafeCreate(new OnSubscribeUsing(resourceFactory, observableFactory, disposeAction, disposeEagerly));
    }

    public static <R> Observable<R> zip(Iterable<? extends Observable<?>> ws, FuncN<? extends R> zipFunction) {
        List<Observable<?>> os = new ArrayList<>();
        for (Observable<?> o : ws) {
            os.add(o);
        }
        return just(os.toArray(new Observable[os.size()])).lift(new OperatorZip(zipFunction));
    }

    public static <R> Observable<R> zip(Observable<?>[] ws, FuncN<? extends R> zipFunction) {
        return just(ws).lift(new OperatorZip(zipFunction));
    }

    public static <R> Observable<R> zip(Observable<? extends Observable<?>> ws, FuncN<? extends R> zipFunction) {
        return ws.toList().map(InternalObservableUtils.TO_ARRAY).lift(new OperatorZip(zipFunction));
    }

    public static <T1, T2, R> Observable<R> zip(Observable<? extends T1> o1, Observable<? extends T2> o2, Func2<? super T1, ? super T2, ? extends R> zipFunction) {
        return just(new Observable[]{o1, o2}).lift(new OperatorZip(zipFunction));
    }

    public static <T1, T2, T3, R> Observable<R> zip(Observable<? extends T1> o1, Observable<? extends T2> o2, Observable<? extends T3> o3, Func3<? super T1, ? super T2, ? super T3, ? extends R> zipFunction) {
        return just(new Observable[]{o1, o2, o3}).lift(new OperatorZip(zipFunction));
    }

    public static <T1, T2, T3, T4, R> Observable<R> zip(Observable<? extends T1> o1, Observable<? extends T2> o2, Observable<? extends T3> o3, Observable<? extends T4> o4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> zipFunction) {
        return just(new Observable[]{o1, o2, o3, o4}).lift(new OperatorZip(zipFunction));
    }

    public static <T1, T2, T3, T4, T5, R> Observable<R> zip(Observable<? extends T1> o1, Observable<? extends T2> o2, Observable<? extends T3> o3, Observable<? extends T4> o4, Observable<? extends T5> o5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> zipFunction) {
        return just(new Observable[]{o1, o2, o3, o4, o5}).lift(new OperatorZip(zipFunction));
    }

    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(Observable<? extends T1> o1, Observable<? extends T2> o2, Observable<? extends T3> o3, Observable<? extends T4> o4, Observable<? extends T5> o5, Observable<? extends T6> o6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> zipFunction) {
        return just(new Observable[]{o1, o2, o3, o4, o5, o6}).lift(new OperatorZip(zipFunction));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(Observable<? extends T1> o1, Observable<? extends T2> o2, Observable<? extends T3> o3, Observable<? extends T4> o4, Observable<? extends T5> o5, Observable<? extends T6> o6, Observable<? extends T7> o7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> zipFunction) {
        return just(new Observable[]{o1, o2, o3, o4, o5, o6, o7}).lift(new OperatorZip(zipFunction));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(Observable<? extends T1> o1, Observable<? extends T2> o2, Observable<? extends T3> o3, Observable<? extends T4> o4, Observable<? extends T5> o5, Observable<? extends T6> o6, Observable<? extends T7> o7, Observable<? extends T8> o8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> zipFunction) {
        return just(new Observable[]{o1, o2, o3, o4, o5, o6, o7, o8}).lift(new OperatorZip(zipFunction));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(Observable<? extends T1> o1, Observable<? extends T2> o2, Observable<? extends T3> o3, Observable<? extends T4> o4, Observable<? extends T5> o5, Observable<? extends T6> o6, Observable<? extends T7> o7, Observable<? extends T8> o8, Observable<? extends T9> o9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> zipFunction) {
        return just(new Observable[]{o1, o2, o3, o4, o5, o6, o7, o8, o9}).lift(new OperatorZip(zipFunction));
    }

    public final Observable<Boolean> all(Func1<? super T, Boolean> predicate) {
        return lift(new OperatorAll(predicate));
    }

    public final Observable<T> ambWith(Observable<? extends T> t1) {
        return amb(this, t1);
    }

    public final Observable<T> asObservable() {
        return (Observable<T>) lift(OperatorAsObservable.instance());
    }

    public final <TClosing> Observable<List<T>> buffer(Func0<? extends Observable<? extends TClosing>> bufferClosingSelector) {
        return (Observable<List<T>>) lift(new OperatorBufferWithSingleObservable(bufferClosingSelector, 16));
    }

    public final Observable<List<T>> buffer(int count) {
        return buffer(count, count);
    }

    public final Observable<List<T>> buffer(int count, int skip) {
        return (Observable<List<T>>) lift(new OperatorBufferWithSize(count, skip));
    }

    public final Observable<List<T>> buffer(long timespan, long timeshift, TimeUnit unit) {
        return buffer(timespan, timeshift, unit, Schedulers.computation());
    }

    public final Observable<List<T>> buffer(long timespan, long timeshift, TimeUnit unit, Scheduler scheduler) {
        return (Observable<List<T>>) lift(new OperatorBufferWithTime(timespan, timeshift, unit, Integer.MAX_VALUE, scheduler));
    }

    public final Observable<List<T>> buffer(long timespan, TimeUnit unit) {
        return buffer(timespan, unit, Integer.MAX_VALUE, Schedulers.computation());
    }

    public final Observable<List<T>> buffer(long timespan, TimeUnit unit, int count) {
        return (Observable<List<T>>) lift(new OperatorBufferWithTime(timespan, timespan, unit, count, Schedulers.computation()));
    }

    public final Observable<List<T>> buffer(long timespan, TimeUnit unit, int count, Scheduler scheduler) {
        return (Observable<List<T>>) lift(new OperatorBufferWithTime(timespan, timespan, unit, count, scheduler));
    }

    public final Observable<List<T>> buffer(long timespan, TimeUnit unit, Scheduler scheduler) {
        return buffer(timespan, timespan, unit, scheduler);
    }

    public final <TOpening, TClosing> Observable<List<T>> buffer(Observable<? extends TOpening> bufferOpenings, Func1<? super TOpening, ? extends Observable<? extends TClosing>> bufferClosingSelector) {
        return (Observable<List<T>>) lift(new OperatorBufferWithStartEndObservable(bufferOpenings, bufferClosingSelector));
    }

    public final <B> Observable<List<T>> buffer(Observable<B> boundary) {
        return buffer(boundary, 16);
    }

    public final <B> Observable<List<T>> buffer(Observable<B> boundary, int initialCapacity) {
        return (Observable<List<T>>) lift(new OperatorBufferWithSingleObservable(boundary, initialCapacity));
    }

    public final Observable<T> cache() {
        return CachedObservable.from(this);
    }

    @Deprecated
    public final Observable<T> cache(int initialCapacity) {
        return cacheWithInitialCapacity(initialCapacity);
    }

    public final Observable<T> cacheWithInitialCapacity(int initialCapacity) {
        return CachedObservable.from(this, initialCapacity);
    }

    public final <R> Observable<R> cast(Class<R> klass) {
        return lift(new OperatorCast(klass));
    }

    public final <R> Observable<R> collect(Func0<R> stateFactory, Action2<R, ? super T> collector) {
        return unsafeCreate(new OnSubscribeCollect(this, stateFactory, collector));
    }

    public final <R> Observable<R> concatMap(Func1<? super T, ? extends Observable<? extends R>> func) {
        if (this instanceof ScalarSynchronousObservable) {
            ScalarSynchronousObservable<T> scalar = (ScalarSynchronousObservable) this;
            return scalar.scalarFlatMap(func);
        }
        return unsafeCreate(new OnSubscribeConcatMap(this, func, 2, 0));
    }

    public final <R> Observable<R> concatMapDelayError(Func1<? super T, ? extends Observable<? extends R>> func) {
        if (this instanceof ScalarSynchronousObservable) {
            ScalarSynchronousObservable<T> scalar = (ScalarSynchronousObservable) this;
            return scalar.scalarFlatMap(func);
        }
        return unsafeCreate(new OnSubscribeConcatMap(this, func, 2, 2));
    }

    public final <R> Observable<R> concatMapIterable(Func1<? super T, ? extends Iterable<? extends R>> collectionSelector) {
        return OnSubscribeFlattenIterable.createFrom(this, collectionSelector, RxRingBuffer.SIZE);
    }

    public final Observable<T> concatWith(Observable<? extends T> t1) {
        return concat(this, t1);
    }

    public final Observable<Boolean> contains(Object element) {
        return exists(InternalObservableUtils.equalsWith(element));
    }

    public final Observable<Integer> count() {
        return reduce(0, InternalObservableUtils.COUNTER);
    }

    public final Observable<Long> countLong() {
        return reduce(0L, InternalObservableUtils.LONG_COUNTER);
    }

    public final <U> Observable<T> debounce(Func1<? super T, ? extends Observable<U>> debounceSelector) {
        return (Observable<T>) lift(new OperatorDebounceWithSelector(debounceSelector));
    }

    public final Observable<T> debounce(long timeout, TimeUnit unit) {
        return debounce(timeout, unit, Schedulers.computation());
    }

    public final Observable<T> debounce(long timeout, TimeUnit unit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorDebounceWithTime(timeout, unit, scheduler));
    }

    public final Observable<T> defaultIfEmpty(T defaultValue) {
        return switchIfEmpty(just(defaultValue));
    }

    public final Observable<T> switchIfEmpty(Observable<? extends T> alternate) {
        if (alternate == null) {
            throw new NullPointerException("alternate is null");
        }
        return unsafeCreate(new OnSubscribeSwitchIfEmpty(this, alternate));
    }

    public final <U, V> Observable<T> delay(Func0<? extends Observable<U>> subscriptionDelay, Func1<? super T, ? extends Observable<V>> itemDelay) {
        return (Observable<T>) delaySubscription(subscriptionDelay).lift(new OperatorDelayWithSelector(this, itemDelay));
    }

    public final <U> Observable<T> delay(Func1<? super T, ? extends Observable<U>> itemDelay) {
        return (Observable<T>) lift(new OperatorDelayWithSelector(this, itemDelay));
    }

    public final Observable<T> delay(long delay, TimeUnit unit) {
        return delay(delay, unit, Schedulers.computation());
    }

    public final Observable<T> delay(long delay, TimeUnit unit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorDelay(delay, unit, scheduler));
    }

    public final Observable<T> delaySubscription(long delay, TimeUnit unit) {
        return delaySubscription(delay, unit, Schedulers.computation());
    }

    public final Observable<T> delaySubscription(long delay, TimeUnit unit, Scheduler scheduler) {
        return unsafeCreate(new OnSubscribeDelaySubscription(this, delay, unit, scheduler));
    }

    public final <U> Observable<T> delaySubscription(Func0<? extends Observable<U>> subscriptionDelay) {
        return unsafeCreate(new OnSubscribeDelaySubscriptionWithSelector(this, subscriptionDelay));
    }

    public final <U> Observable<T> delaySubscription(Observable<U> other) {
        if (other == null) {
            throw new NullPointerException();
        }
        return unsafeCreate(new OnSubscribeDelaySubscriptionOther(this, other));
    }

    public final <T2> Observable<T2> dematerialize() {
        return (Observable<T2>) lift(OperatorDematerialize.instance());
    }

    public final Observable<T> distinct() {
        return (Observable<T>) lift(OperatorDistinct.instance());
    }

    public final <U> Observable<T> distinct(Func1<? super T, ? extends U> keySelector) {
        return (Observable<T>) lift(new OperatorDistinct(keySelector));
    }

    public final Observable<T> distinctUntilChanged() {
        return (Observable<T>) lift(OperatorDistinctUntilChanged.instance());
    }

    public final <U> Observable<T> distinctUntilChanged(Func1<? super T, ? extends U> keySelector) {
        return (Observable<T>) lift(new OperatorDistinctUntilChanged(keySelector));
    }

    public final Observable<T> distinctUntilChanged(Func2<? super T, ? super T, Boolean> comparator) {
        return (Observable<T>) lift(new OperatorDistinctUntilChanged(comparator));
    }

    public final Observable<T> doOnCompleted(Action0 onCompleted) {
        Action1<T> onNext = Actions.empty();
        Action1<Throwable> onError = Actions.empty();
        return unsafeCreate(new OnSubscribeDoOnEach(this, new ActionObserver(onNext, onError, onCompleted)));
    }

    public final Observable<T> doOnEach(Action1<Notification<? super T>> onNotification) {
        return unsafeCreate(new OnSubscribeDoOnEach(this, new ActionNotificationObserver(onNotification)));
    }

    public final Observable<T> doOnEach(Observer<? super T> observer) {
        return unsafeCreate(new OnSubscribeDoOnEach(this, observer));
    }

    public final Observable<T> doOnError(Action1<? super Throwable> onError) {
        Action1<T> onNext = Actions.empty();
        Action0 onCompleted = Actions.empty();
        return unsafeCreate(new OnSubscribeDoOnEach(this, new ActionObserver(onNext, onError, onCompleted)));
    }

    public final Observable<T> doOnNext(Action1<? super T> onNext) {
        Action1<Throwable> onError = Actions.empty();
        Action0 onCompleted = Actions.empty();
        return unsafeCreate(new OnSubscribeDoOnEach(this, new ActionObserver(onNext, onError, onCompleted)));
    }

    public final Observable<T> doOnRequest(Action1<? super Long> onRequest) {
        return (Observable<T>) lift(new OperatorDoOnRequest(onRequest));
    }

    public final Observable<T> doOnSubscribe(Action0 subscribe) {
        return (Observable<T>) lift(new OperatorDoOnSubscribe(subscribe));
    }

    public final Observable<T> doOnTerminate(Action0 onTerminate) {
        Action1<T> onNext = Actions.empty();
        Action1<Throwable> onError = Actions.toAction1(onTerminate);
        return unsafeCreate(new OnSubscribeDoOnEach(this, new ActionObserver(onNext, onError, onTerminate)));
    }

    public final Observable<T> doOnUnsubscribe(Action0 unsubscribe) {
        return (Observable<T>) lift(new OperatorDoOnUnsubscribe(unsubscribe));
    }

    public static <T> Observable<T> concatEager(Observable<? extends T> o1, Observable<? extends T> o2) {
        return concatEager(Arrays.asList(o1, o2));
    }

    public static <T> Observable<T> concatEager(Observable<? extends T> o1, Observable<? extends T> o2, Observable<? extends T> o3) {
        return concatEager(Arrays.asList(o1, o2, o3));
    }

    public static <T> Observable<T> concatEager(Observable<? extends T> o1, Observable<? extends T> o2, Observable<? extends T> o3, Observable<? extends T> o4) {
        return concatEager(Arrays.asList(o1, o2, o3, o4));
    }

    public static <T> Observable<T> concatEager(Observable<? extends T> o1, Observable<? extends T> o2, Observable<? extends T> o3, Observable<? extends T> o4, Observable<? extends T> o5) {
        return concatEager(Arrays.asList(o1, o2, o3, o4, o5));
    }

    public static <T> Observable<T> concatEager(Observable<? extends T> o1, Observable<? extends T> o2, Observable<? extends T> o3, Observable<? extends T> o4, Observable<? extends T> o5, Observable<? extends T> o6) {
        return concatEager(Arrays.asList(o1, o2, o3, o4, o5, o6));
    }

    public static <T> Observable<T> concatEager(Observable<? extends T> o1, Observable<? extends T> o2, Observable<? extends T> o3, Observable<? extends T> o4, Observable<? extends T> o5, Observable<? extends T> o6, Observable<? extends T> o7) {
        return concatEager(Arrays.asList(o1, o2, o3, o4, o5, o6, o7));
    }

    public static <T> Observable<T> concatEager(Observable<? extends T> o1, Observable<? extends T> o2, Observable<? extends T> o3, Observable<? extends T> o4, Observable<? extends T> o5, Observable<? extends T> o6, Observable<? extends T> o7, Observable<? extends T> o8) {
        return concatEager(Arrays.asList(o1, o2, o3, o4, o5, o6, o7, o8));
    }

    public static <T> Observable<T> concatEager(Observable<? extends T> o1, Observable<? extends T> o2, Observable<? extends T> o3, Observable<? extends T> o4, Observable<? extends T> o5, Observable<? extends T> o6, Observable<? extends T> o7, Observable<? extends T> o8, Observable<? extends T> o9) {
        return concatEager(Arrays.asList(o1, o2, o3, o4, o5, o6, o7, o8, o9));
    }

    public static <T> Observable<T> concatEager(Iterable<? extends Observable<? extends T>> sources) {
        return from(sources).concatMapEager(UtilityFunctions.identity());
    }

    public static <T> Observable<T> concatEager(Iterable<? extends Observable<? extends T>> sources, int capacityHint) {
        return from(sources).concatMapEager(UtilityFunctions.identity(), capacityHint);
    }

    public static <T> Observable<T> concatEager(Observable<? extends Observable<? extends T>> sources) {
        return (Observable<T>) sources.concatMapEager(UtilityFunctions.identity());
    }

    public static <T> Observable<T> concatEager(Observable<? extends Observable<? extends T>> sources, int capacityHint) {
        return (Observable<T>) sources.concatMapEager(UtilityFunctions.identity(), capacityHint);
    }

    public final <R> Observable<R> concatMapEager(Func1<? super T, ? extends Observable<? extends R>> mapper) {
        return concatMapEager(mapper, RxRingBuffer.SIZE);
    }

    public final <R> Observable<R> concatMapEager(Func1<? super T, ? extends Observable<? extends R>> mapper, int capacityHint) {
        if (capacityHint < 1) {
            throw new IllegalArgumentException("capacityHint > 0 required but it was " + capacityHint);
        }
        return lift(new OperatorEagerConcatMap(mapper, capacityHint, Integer.MAX_VALUE));
    }

    public final <R> Observable<R> concatMapEager(Func1<? super T, ? extends Observable<? extends R>> mapper, int capacityHint, int maxConcurrent) {
        if (capacityHint < 1) {
            throw new IllegalArgumentException("capacityHint > 0 required but it was " + capacityHint);
        }
        if (maxConcurrent < 1) {
            throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + capacityHint);
        }
        return lift(new OperatorEagerConcatMap(mapper, capacityHint, maxConcurrent));
    }

    public final Observable<T> elementAt(int index) {
        return (Observable<T>) lift(new OperatorElementAt(index));
    }

    public final Observable<T> elementAtOrDefault(int index, T defaultValue) {
        return (Observable<T>) lift(new OperatorElementAt(index, defaultValue));
    }

    public final Observable<Boolean> exists(Func1<? super T, Boolean> predicate) {
        return lift(new OperatorAny(predicate, false));
    }

    public final Observable<T> filter(Func1<? super T, Boolean> predicate) {
        return unsafeCreate(new OnSubscribeFilter(this, predicate));
    }

    @Deprecated
    public final Observable<T> finallyDo(Action0 action) {
        return (Observable<T>) lift(new OperatorDoAfterTerminate(action));
    }

    public final Observable<T> doAfterTerminate(Action0 action) {
        return (Observable<T>) lift(new OperatorDoAfterTerminate(action));
    }

    public final Observable<T> first() {
        return take(1).single();
    }

    public final Observable<T> first(Func1<? super T, Boolean> predicate) {
        return takeFirst(predicate).single();
    }

    public final Observable<T> firstOrDefault(T defaultValue) {
        return take(1).singleOrDefault(defaultValue);
    }

    public final Observable<T> firstOrDefault(T defaultValue, Func1<? super T, Boolean> predicate) {
        return takeFirst(predicate).singleOrDefault(defaultValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> func) {
        if (getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) this).scalarFlatMap(func);
        }
        return merge(map(func));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> func, int maxConcurrent) {
        if (getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) this).scalarFlatMap(func);
        }
        return merge(map(func), maxConcurrent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> onNext, Func1<? super Throwable, ? extends Observable<? extends R>> onError, Func0<? extends Observable<? extends R>> onCompleted) {
        return merge(mapNotification(onNext, onError, onCompleted));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> onNext, Func1<? super Throwable, ? extends Observable<? extends R>> onError, Func0<? extends Observable<? extends R>> onCompleted, int maxConcurrent) {
        return merge(mapNotification(onNext, onError, onCompleted), maxConcurrent);
    }

    public final <U, R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends U>> collectionSelector, Func2<? super T, ? super U, ? extends R> resultSelector) {
        return merge(lift(new OperatorMapPair(collectionSelector, resultSelector)));
    }

    public final <U, R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends U>> collectionSelector, Func2<? super T, ? super U, ? extends R> resultSelector, int maxConcurrent) {
        return merge(lift(new OperatorMapPair(collectionSelector, resultSelector)), maxConcurrent);
    }

    public final Observable<T> flatMapCompletable(Func1<? super T, ? extends Completable> mapper) {
        return flatMapCompletable(mapper, false, Integer.MAX_VALUE);
    }

    public final Observable<T> flatMapCompletable(Func1<? super T, ? extends Completable> mapper, boolean delayErrors) {
        return flatMapCompletable(mapper, delayErrors, Integer.MAX_VALUE);
    }

    public final Observable<T> flatMapCompletable(Func1<? super T, ? extends Completable> mapper, boolean delayErrors, int maxConcurrency) {
        return unsafeCreate(new OnSubscribeFlatMapCompletable(this, mapper, delayErrors, maxConcurrency));
    }

    public final <R> Observable<R> flatMapIterable(Func1<? super T, ? extends Iterable<? extends R>> collectionSelector) {
        return flatMapIterable(collectionSelector, RxRingBuffer.SIZE);
    }

    public final <R> Observable<R> flatMapIterable(Func1<? super T, ? extends Iterable<? extends R>> collectionSelector, int maxConcurrent) {
        return OnSubscribeFlattenIterable.createFrom(this, collectionSelector, maxConcurrent);
    }

    public final <U, R> Observable<R> flatMapIterable(Func1<? super T, ? extends Iterable<? extends U>> collectionSelector, Func2<? super T, ? super U, ? extends R> resultSelector) {
        return flatMap(OperatorMapPair.convertSelector(collectionSelector), resultSelector);
    }

    public final <U, R> Observable<R> flatMapIterable(Func1<? super T, ? extends Iterable<? extends U>> collectionSelector, Func2<? super T, ? super U, ? extends R> resultSelector, int maxConcurrent) {
        return flatMap(OperatorMapPair.convertSelector(collectionSelector), resultSelector, maxConcurrent);
    }

    public final <R> Observable<R> flatMapSingle(Func1<? super T, ? extends Single<? extends R>> mapper) {
        return flatMapSingle(mapper, false, Integer.MAX_VALUE);
    }

    public final <R> Observable<R> flatMapSingle(Func1<? super T, ? extends Single<? extends R>> mapper, boolean delayErrors) {
        return flatMapSingle(mapper, delayErrors, Integer.MAX_VALUE);
    }

    public final <R> Observable<R> flatMapSingle(Func1<? super T, ? extends Single<? extends R>> mapper, boolean delayErrors, int maxConcurrency) {
        return unsafeCreate(new OnSubscribeFlatMapSingle(this, mapper, delayErrors, maxConcurrency));
    }

    public final void forEach(Action1<? super T> onNext) {
        subscribe(onNext);
    }

    public final void forEach(Action1<? super T> onNext, Action1<Throwable> onError) {
        subscribe(onNext, onError);
    }

    public final void forEach(Action1<? super T> onNext, Action1<Throwable> onError, Action0 onComplete) {
        subscribe(onNext, onError, onComplete);
    }

    public final <K, R> Observable<GroupedObservable<K, R>> groupBy(Func1<? super T, ? extends K> keySelector, Func1<? super T, ? extends R> elementSelector) {
        return (Observable<R>) lift(new OperatorGroupBy(keySelector, elementSelector));
    }

    public final <K, R> Observable<GroupedObservable<K, R>> groupBy(Func1<? super T, ? extends K> keySelector, Func1<? super T, ? extends R> elementSelector, Func1<Action1<K>, Map<K, Object>> evictingMapFactory) {
        if (evictingMapFactory == null) {
            throw new NullPointerException("evictingMapFactory cannot be null");
        }
        return (Observable<R>) lift(new OperatorGroupBy(keySelector, elementSelector, evictingMapFactory));
    }

    public final <K> Observable<GroupedObservable<K, T>> groupBy(Func1<? super T, ? extends K> keySelector) {
        return (Observable<GroupedObservable<K, T>>) lift(new OperatorGroupBy(keySelector));
    }

    public final <T2, D1, D2, R> Observable<R> groupJoin(Observable<T2> right, Func1<? super T, ? extends Observable<D1>> leftDuration, Func1<? super T2, ? extends Observable<D2>> rightDuration, Func2<? super T, ? super Observable<T2>, ? extends R> resultSelector) {
        return unsafeCreate(new OnSubscribeGroupJoin(this, right, leftDuration, rightDuration, resultSelector));
    }

    public final Observable<T> ignoreElements() {
        return (Observable<T>) lift(OperatorIgnoreElements.instance());
    }

    public final Observable<Boolean> isEmpty() {
        return lift(InternalObservableUtils.IS_EMPTY);
    }

    public final <TRight, TLeftDuration, TRightDuration, R> Observable<R> join(Observable<TRight> right, Func1<T, Observable<TLeftDuration>> leftDurationSelector, Func1<TRight, Observable<TRightDuration>> rightDurationSelector, Func2<T, TRight, R> resultSelector) {
        return unsafeCreate(new OnSubscribeJoin(this, right, leftDurationSelector, rightDurationSelector, resultSelector));
    }

    public final Observable<T> last() {
        return takeLast(1).single();
    }

    public final Observable<T> last(Func1<? super T, Boolean> predicate) {
        return filter(predicate).takeLast(1).single();
    }

    public final Observable<T> lastOrDefault(T defaultValue) {
        return takeLast(1).singleOrDefault(defaultValue);
    }

    public final Observable<T> lastOrDefault(T defaultValue, Func1<? super T, Boolean> predicate) {
        return filter(predicate).takeLast(1).singleOrDefault(defaultValue);
    }

    public final Observable<T> limit(int count) {
        return take(count);
    }

    public final <R> Observable<R> map(Func1<? super T, ? extends R> func) {
        return unsafeCreate(new OnSubscribeMap(this, func));
    }

    private <R> Observable<R> mapNotification(Func1<? super T, ? extends R> onNext, Func1<? super Throwable, ? extends R> onError, Func0<? extends R> onCompleted) {
        return lift(new OperatorMapNotification(onNext, onError, onCompleted));
    }

    public final Observable<Notification<T>> materialize() {
        return (Observable<Notification<T>>) lift(OperatorMaterialize.instance());
    }

    public final Observable<T> mergeWith(Observable<? extends T> t1) {
        return merge(this, t1);
    }

    public final Observable<T> observeOn(Scheduler scheduler) {
        return observeOn(scheduler, RxRingBuffer.SIZE);
    }

    public final Observable<T> observeOn(Scheduler scheduler, int bufferSize) {
        return observeOn(scheduler, false, bufferSize);
    }

    public final Observable<T> observeOn(Scheduler scheduler, boolean delayError) {
        return observeOn(scheduler, delayError, RxRingBuffer.SIZE);
    }

    public final Observable<T> observeOn(Scheduler scheduler, boolean delayError, int bufferSize) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).scalarScheduleOn(scheduler);
        }
        return (Observable<T>) lift(new OperatorObserveOn(scheduler, delayError, bufferSize));
    }

    public final <R> Observable<R> ofType(Class<R> klass) {
        return filter(InternalObservableUtils.isInstanceOf(klass)).cast(klass);
    }

    public final Observable<T> onBackpressureBuffer() {
        return (Observable<T>) lift(OperatorOnBackpressureBuffer.instance());
    }

    public final Observable<T> onBackpressureBuffer(long capacity) {
        return (Observable<T>) lift(new OperatorOnBackpressureBuffer(capacity));
    }

    public final Observable<T> onBackpressureBuffer(long capacity, Action0 onOverflow) {
        return (Observable<T>) lift(new OperatorOnBackpressureBuffer(capacity, onOverflow));
    }

    public final Observable<T> onBackpressureBuffer(long capacity, Action0 onOverflow, BackpressureOverflow.Strategy overflowStrategy) {
        return (Observable<T>) lift(new OperatorOnBackpressureBuffer(capacity, onOverflow, overflowStrategy));
    }

    public final Observable<T> onBackpressureDrop(Action1<? super T> onDrop) {
        return (Observable<T>) lift(new OperatorOnBackpressureDrop(onDrop));
    }

    public final Observable<T> onBackpressureDrop() {
        return (Observable<T>) lift(OperatorOnBackpressureDrop.instance());
    }

    public final Observable<T> onBackpressureLatest() {
        return (Observable<T>) lift(OperatorOnBackpressureLatest.instance());
    }

    public final Observable<T> onErrorResumeNext(Func1<? super Throwable, ? extends Observable<? extends T>> resumeFunction) {
        return (Observable<T>) lift(new OperatorOnErrorResumeNextViaFunction(resumeFunction));
    }

    public final Observable<T> onErrorResumeNext(Observable<? extends T> resumeSequence) {
        return (Observable<T>) lift(OperatorOnErrorResumeNextViaFunction.withOther(resumeSequence));
    }

    public final Observable<T> onErrorReturn(Func1<? super Throwable, ? extends T> resumeFunction) {
        return (Observable<T>) lift(OperatorOnErrorResumeNextViaFunction.withSingle(resumeFunction));
    }

    public final Observable<T> onExceptionResumeNext(Observable<? extends T> resumeSequence) {
        return (Observable<T>) lift(OperatorOnErrorResumeNextViaFunction.withException(resumeSequence));
    }

    public final Observable<T> onTerminateDetach() {
        return unsafeCreate(new OnSubscribeDetach(this));
    }

    public final ConnectableObservable<T> publish() {
        return OperatorPublish.create(this);
    }

    public final <R> Observable<R> publish(Func1<? super Observable<T>, ? extends Observable<R>> selector) {
        return OperatorPublish.create(this, selector);
    }

    public final Observable<T> rebatchRequests(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n > 0 required but it was " + n);
        }
        return (Observable<T>) lift(OperatorObserveOn.rebatch(n));
    }

    public final Observable<T> reduce(Func2<T, T, T> accumulator) {
        return unsafeCreate(new OnSubscribeReduce(this, accumulator));
    }

    public final <R> Observable<R> reduce(R initialValue, Func2<R, ? super T, R> accumulator) {
        return unsafeCreate(new OnSubscribeReduceSeed(this, initialValue, accumulator));
    }

    public final Observable<T> repeat() {
        return OnSubscribeRedo.repeat(this);
    }

    public final Observable<T> repeat(Scheduler scheduler) {
        return OnSubscribeRedo.repeat(this, scheduler);
    }

    public final Observable<T> repeat(long count) {
        return OnSubscribeRedo.repeat(this, count);
    }

    public final Observable<T> repeat(long count, Scheduler scheduler) {
        return OnSubscribeRedo.repeat(this, count, scheduler);
    }

    public final Observable<T> repeatWhen(Func1<? super Observable<? extends Void>, ? extends Observable<?>> notificationHandler, Scheduler scheduler) {
        return OnSubscribeRedo.repeat(this, InternalObservableUtils.createRepeatDematerializer(notificationHandler), scheduler);
    }

    public final Observable<T> repeatWhen(Func1<? super Observable<? extends Void>, ? extends Observable<?>> notificationHandler) {
        return OnSubscribeRedo.repeat(this, InternalObservableUtils.createRepeatDematerializer(notificationHandler));
    }

    public final ConnectableObservable<T> replay() {
        return OperatorReplay.create(this);
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> selector) {
        return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this), selector);
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> selector, int bufferSize) {
        return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this, bufferSize), selector);
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> selector, int bufferSize, long time, TimeUnit unit) {
        return replay(selector, bufferSize, time, unit, Schedulers.computation());
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> selector, int bufferSize, long time, TimeUnit unit, Scheduler scheduler) {
        if (bufferSize < 0) {
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this, bufferSize, time, unit, scheduler), selector);
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> selector, int bufferSize, Scheduler scheduler) {
        return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this, bufferSize), InternalObservableUtils.createReplaySelectorAndObserveOn(selector, scheduler));
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> selector, long time, TimeUnit unit) {
        return replay(selector, time, unit, Schedulers.computation());
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> selector, long time, TimeUnit unit, Scheduler scheduler) {
        return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this, time, unit, scheduler), selector);
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> selector, Scheduler scheduler) {
        return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this), InternalObservableUtils.createReplaySelectorAndObserveOn(selector, scheduler));
    }

    public final ConnectableObservable<T> replay(int bufferSize) {
        return OperatorReplay.create(this, bufferSize);
    }

    public final ConnectableObservable<T> replay(int bufferSize, long time, TimeUnit unit) {
        return replay(bufferSize, time, unit, Schedulers.computation());
    }

    public final ConnectableObservable<T> replay(int bufferSize, long time, TimeUnit unit, Scheduler scheduler) {
        if (bufferSize < 0) {
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return OperatorReplay.create(this, time, unit, scheduler, bufferSize);
    }

    public final ConnectableObservable<T> replay(int bufferSize, Scheduler scheduler) {
        return OperatorReplay.observeOn(replay(bufferSize), scheduler);
    }

    public final ConnectableObservable<T> replay(long time, TimeUnit unit) {
        return replay(time, unit, Schedulers.computation());
    }

    public final ConnectableObservable<T> replay(long time, TimeUnit unit, Scheduler scheduler) {
        return OperatorReplay.create(this, time, unit, scheduler);
    }

    public final ConnectableObservable<T> replay(Scheduler scheduler) {
        return OperatorReplay.observeOn(replay(), scheduler);
    }

    public final Observable<T> retry() {
        return OnSubscribeRedo.retry(this);
    }

    public final Observable<T> retry(long count) {
        return OnSubscribeRedo.retry(this, count);
    }

    public final Observable<T> retry(Func2<Integer, Throwable, Boolean> predicate) {
        return (Observable<T>) nest().lift(new OperatorRetryWithPredicate(predicate));
    }

    public final Observable<T> retryWhen(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> notificationHandler) {
        return OnSubscribeRedo.retry(this, InternalObservableUtils.createRetryDematerializer(notificationHandler));
    }

    public final Observable<T> retryWhen(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> notificationHandler, Scheduler scheduler) {
        return OnSubscribeRedo.retry(this, InternalObservableUtils.createRetryDematerializer(notificationHandler), scheduler);
    }

    public final Observable<T> sample(long period, TimeUnit unit) {
        return sample(period, unit, Schedulers.computation());
    }

    public final Observable<T> sample(long period, TimeUnit unit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorSampleWithTime(period, unit, scheduler));
    }

    public final <U> Observable<T> sample(Observable<U> sampler) {
        return (Observable<T>) lift(new OperatorSampleWithObservable(sampler));
    }

    public final Observable<T> scan(Func2<T, T, T> accumulator) {
        return (Observable<T>) lift(new OperatorScan(accumulator));
    }

    public final <R> Observable<R> scan(R initialValue, Func2<R, ? super T, R> accumulator) {
        return lift(new OperatorScan(initialValue, accumulator));
    }

    public final Observable<T> serialize() {
        return (Observable<T>) lift(OperatorSerialize.instance());
    }

    public final Observable<T> share() {
        return publish().refCount();
    }

    public final Observable<T> single() {
        return (Observable<T>) lift(OperatorSingle.instance());
    }

    public final Observable<T> single(Func1<? super T, Boolean> predicate) {
        return filter(predicate).single();
    }

    public final Observable<T> singleOrDefault(T defaultValue) {
        return (Observable<T>) lift(new OperatorSingle(defaultValue));
    }

    public final Observable<T> singleOrDefault(T defaultValue, Func1<? super T, Boolean> predicate) {
        return filter(predicate).singleOrDefault(defaultValue);
    }

    public final Observable<T> skip(int count) {
        return (Observable<T>) lift(new OperatorSkip(count));
    }

    public final Observable<T> skip(long time, TimeUnit unit) {
        return skip(time, unit, Schedulers.computation());
    }

    public final Observable<T> skip(long time, TimeUnit unit, Scheduler scheduler) {
        return unsafeCreate(new OnSubscribeSkipTimed(this, time, unit, scheduler));
    }

    public final Observable<T> skipLast(int count) {
        return (Observable<T>) lift(new OperatorSkipLast(count));
    }

    public final Observable<T> skipLast(long time, TimeUnit unit) {
        return skipLast(time, unit, Schedulers.computation());
    }

    public final Observable<T> skipLast(long time, TimeUnit unit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorSkipLastTimed(time, unit, scheduler));
    }

    public final <U> Observable<T> skipUntil(Observable<U> other) {
        return (Observable<T>) lift(new OperatorSkipUntil(other));
    }

    public final Observable<T> skipWhile(Func1<? super T, Boolean> predicate) {
        return (Observable<T>) lift(new OperatorSkipWhile(OperatorSkipWhile.toPredicate2(predicate)));
    }

    public final Observable<T> startWith(Observable<T> values) {
        return concat(values, this);
    }

    public final Observable<T> startWith(Iterable<T> values) {
        return concat(from(values), this);
    }

    public final Observable<T> startWith(T t1) {
        return concat(just(t1), this);
    }

    public final Observable<T> startWith(T t1, T t2) {
        return concat(just(t1, t2), this);
    }

    public final Observable<T> startWith(T t1, T t2, T t3) {
        return concat(just(t1, t2, t3), this);
    }

    public final Observable<T> startWith(T t1, T t2, T t3, T t4) {
        return concat(just(t1, t2, t3, t4), this);
    }

    public final Observable<T> startWith(T t1, T t2, T t3, T t4, T t5) {
        return concat(just(t1, t2, t3, t4, t5), this);
    }

    public final Observable<T> startWith(T t1, T t2, T t3, T t4, T t5, T t6) {
        return concat(just(t1, t2, t3, t4, t5, t6), this);
    }

    public final Observable<T> startWith(T t1, T t2, T t3, T t4, T t5, T t6, T t7) {
        return concat(just(t1, t2, t3, t4, t5, t6, t7), this);
    }

    public final Observable<T> startWith(T t1, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        return concat(just(t1, t2, t3, t4, t5, t6, t7, t8), this);
    }

    public final Observable<T> startWith(T t1, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        return concat(just(t1, t2, t3, t4, t5, t6, t7, t8, t9), this);
    }

    public final Subscription subscribe() {
        Action1<T> onNext = Actions.empty();
        Action1<Throwable> onError = InternalObservableUtils.ERROR_NOT_IMPLEMENTED;
        Action0 onCompleted = Actions.empty();
        return subscribe((Subscriber) new ActionSubscriber(onNext, onError, onCompleted));
    }

    public final Subscription subscribe(Action1<? super T> onNext) {
        if (onNext == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        Action1<Throwable> onError = InternalObservableUtils.ERROR_NOT_IMPLEMENTED;
        Action0 onCompleted = Actions.empty();
        return subscribe((Subscriber) new ActionSubscriber(onNext, onError, onCompleted));
    }

    public final Subscription subscribe(Action1<? super T> onNext, Action1<Throwable> onError) {
        if (onNext == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (onError == null) {
            throw new IllegalArgumentException("onError can not be null");
        }
        Action0 onCompleted = Actions.empty();
        return subscribe((Subscriber) new ActionSubscriber(onNext, onError, onCompleted));
    }

    public final Subscription subscribe(Action1<? super T> onNext, Action1<Throwable> onError, Action0 onCompleted) {
        if (onNext == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (onError == null) {
            throw new IllegalArgumentException("onError can not be null");
        }
        if (onCompleted == null) {
            throw new IllegalArgumentException("onComplete can not be null");
        }
        return subscribe((Subscriber) new ActionSubscriber(onNext, onError, onCompleted));
    }

    public final Subscription subscribe(Observer<? super T> observer) {
        if (observer instanceof Subscriber) {
            return subscribe((Subscriber) ((Subscriber) observer));
        }
        if (observer == null) {
            throw new NullPointerException("observer is null");
        }
        return subscribe((Subscriber) new ObserverSubscriber(observer));
    }

    public final Subscription unsafeSubscribe(Subscriber<? super T> subscriber) {
        try {
            subscriber.onStart();
            RxJavaHooks.onObservableStart(this, this.onSubscribe).call(subscriber);
            return RxJavaHooks.onObservableReturn(subscriber);
        } catch (Throwable e) {
            Exceptions.throwIfFatal(e);
            try {
                subscriber.onError(RxJavaHooks.onObservableError(e));
                return Subscriptions.unsubscribed();
            } catch (Throwable e2) {
                Exceptions.throwIfFatal(e2);
                RuntimeException r = new OnErrorFailedException("Error occurred attempting to subscribe [" + e.getMessage() + "] and then again while trying to pass to onError.", e2);
                RxJavaHooks.onObservableError(r);
                throw r;
            }
        }
    }

    public final Subscription subscribe(Subscriber<? super T> subscriber) {
        return subscribe(subscriber, this);
    }

    static <T> Subscription subscribe(Subscriber<? super T> subscriber, Observable<T> observable) {
        if (subscriber == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        }
        if (observable.onSubscribe == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        subscriber.onStart();
        if (!(subscriber instanceof SafeSubscriber)) {
            subscriber = new SafeSubscriber<>(subscriber);
        }
        try {
            RxJavaHooks.onObservableStart(observable, observable.onSubscribe).call(subscriber);
            return RxJavaHooks.onObservableReturn(subscriber);
        } catch (Throwable e) {
            Exceptions.throwIfFatal(e);
            if (subscriber.isUnsubscribed()) {
                RxJavaHooks.onError(RxJavaHooks.onObservableError(e));
            } else {
                try {
                    subscriber.onError(RxJavaHooks.onObservableError(e));
                } catch (Throwable e2) {
                    Exceptions.throwIfFatal(e2);
                    RuntimeException r = new OnErrorFailedException("Error occurred attempting to subscribe [" + e.getMessage() + "] and then again while trying to pass to onError.", e2);
                    RxJavaHooks.onObservableError(r);
                    throw r;
                }
            }
            return Subscriptions.unsubscribed();
        }
    }

    public final Observable<T> subscribeOn(Scheduler scheduler) {
        return subscribeOn(scheduler, !(this.onSubscribe instanceof OnSubscribeCreate));
    }

    public final Observable<T> subscribeOn(Scheduler scheduler, boolean requestOn) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).scalarScheduleOn(scheduler);
        }
        return unsafeCreate(new OperatorSubscribeOn(this, scheduler, requestOn));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> switchMap(Func1<? super T, ? extends Observable<? extends R>> func) {
        return switchOnNext(map(func));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> switchMapDelayError(Func1<? super T, ? extends Observable<? extends R>> func) {
        return switchOnNextDelayError(map(func));
    }

    public final Observable<T> take(int count) {
        return (Observable<T>) lift(new OperatorTake(count));
    }

    public final Observable<T> take(long time, TimeUnit unit) {
        return take(time, unit, Schedulers.computation());
    }

    public final Observable<T> take(long time, TimeUnit unit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorTakeTimed(time, unit, scheduler));
    }

    public final Observable<T> takeFirst(Func1<? super T, Boolean> predicate) {
        return filter(predicate).take(1);
    }

    public final Observable<T> takeLast(int count) {
        if (count == 0) {
            return ignoreElements();
        }
        if (count == 1) {
            return unsafeCreate(new OnSubscribeTakeLastOne(this));
        }
        return (Observable<T>) lift(new OperatorTakeLast(count));
    }

    public final Observable<T> takeLast(int count, long time, TimeUnit unit) {
        return takeLast(count, time, unit, Schedulers.computation());
    }

    public final Observable<T> takeLast(int count, long time, TimeUnit unit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorTakeLastTimed(count, time, unit, scheduler));
    }

    public final Observable<T> takeLast(long time, TimeUnit unit) {
        return takeLast(time, unit, Schedulers.computation());
    }

    public final Observable<T> takeLast(long time, TimeUnit unit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorTakeLastTimed(time, unit, scheduler));
    }

    public final Observable<List<T>> takeLastBuffer(int count) {
        return takeLast(count).toList();
    }

    public final Observable<List<T>> takeLastBuffer(int count, long time, TimeUnit unit) {
        return takeLast(count, time, unit).toList();
    }

    public final Observable<List<T>> takeLastBuffer(int count, long time, TimeUnit unit, Scheduler scheduler) {
        return takeLast(count, time, unit, scheduler).toList();
    }

    public final Observable<List<T>> takeLastBuffer(long time, TimeUnit unit) {
        return takeLast(time, unit).toList();
    }

    public final Observable<List<T>> takeLastBuffer(long time, TimeUnit unit, Scheduler scheduler) {
        return takeLast(time, unit, scheduler).toList();
    }

    public final <E> Observable<T> takeUntil(Observable<? extends E> other) {
        return (Observable<T>) lift(new OperatorTakeUntil(other));
    }

    public final Observable<T> takeWhile(Func1<? super T, Boolean> predicate) {
        return (Observable<T>) lift(new OperatorTakeWhile(predicate));
    }

    public final Observable<T> takeUntil(Func1<? super T, Boolean> stopPredicate) {
        return (Observable<T>) lift(new OperatorTakeUntilPredicate(stopPredicate));
    }

    public final Observable<T> throttleFirst(long windowDuration, TimeUnit unit) {
        return throttleFirst(windowDuration, unit, Schedulers.computation());
    }

    public final Observable<T> throttleFirst(long skipDuration, TimeUnit unit, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorThrottleFirst(skipDuration, unit, scheduler));
    }

    public final Observable<T> throttleLast(long intervalDuration, TimeUnit unit) {
        return sample(intervalDuration, unit);
    }

    public final Observable<T> throttleLast(long intervalDuration, TimeUnit unit, Scheduler scheduler) {
        return sample(intervalDuration, unit, scheduler);
    }

    public final Observable<T> throttleWithTimeout(long timeout, TimeUnit unit) {
        return debounce(timeout, unit);
    }

    public final Observable<T> throttleWithTimeout(long timeout, TimeUnit unit, Scheduler scheduler) {
        return debounce(timeout, unit, scheduler);
    }

    public final Observable<TimeInterval<T>> timeInterval() {
        return timeInterval(Schedulers.computation());
    }

    public final Observable<TimeInterval<T>> timeInterval(Scheduler scheduler) {
        return (Observable<TimeInterval<T>>) lift(new OperatorTimeInterval(scheduler));
    }

    public final <U, V> Observable<T> timeout(Func0<? extends Observable<U>> firstTimeoutSelector, Func1<? super T, ? extends Observable<V>> timeoutSelector) {
        return timeout(firstTimeoutSelector, timeoutSelector, (Observable) null);
    }

    public final <U, V> Observable<T> timeout(Func0<? extends Observable<U>> firstTimeoutSelector, Func1<? super T, ? extends Observable<V>> timeoutSelector, Observable<? extends T> other) {
        if (timeoutSelector == null) {
            throw new NullPointerException("timeoutSelector is null");
        }
        return (Observable<T>) lift(new OperatorTimeoutWithSelector(firstTimeoutSelector, timeoutSelector, other));
    }

    public final <V> Observable<T> timeout(Func1<? super T, ? extends Observable<V>> timeoutSelector) {
        return timeout((Func0) null, timeoutSelector, (Observable) null);
    }

    public final <V> Observable<T> timeout(Func1<? super T, ? extends Observable<V>> timeoutSelector, Observable<? extends T> other) {
        return timeout((Func0) null, timeoutSelector, other);
    }

    public final Observable<T> timeout(long timeout, TimeUnit timeUnit) {
        return timeout(timeout, timeUnit, null, Schedulers.computation());
    }

    public final Observable<T> timeout(long timeout, TimeUnit timeUnit, Observable<? extends T> other) {
        return timeout(timeout, timeUnit, other, Schedulers.computation());
    }

    public final Observable<T> timeout(long timeout, TimeUnit timeUnit, Observable<? extends T> other, Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorTimeout(timeout, timeUnit, other, scheduler));
    }

    public final Observable<T> timeout(long timeout, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout(timeout, timeUnit, null, scheduler);
    }

    public final Observable<Timestamped<T>> timestamp() {
        return timestamp(Schedulers.computation());
    }

    public final Observable<Timestamped<T>> timestamp(Scheduler scheduler) {
        return (Observable<Timestamped<T>>) lift(new OperatorTimestamp(scheduler));
    }

    public final BlockingObservable<T> toBlocking() {
        return BlockingObservable.from(this);
    }

    public final Observable<List<T>> toList() {
        return (Observable<List<T>>) lift(OperatorToObservableList.instance());
    }

    public final <K> Observable<Map<K, T>> toMap(Func1<? super T, ? extends K> keySelector) {
        return unsafeCreate(new OnSubscribeToMap(this, keySelector, UtilityFunctions.identity()));
    }

    public final <K, V> Observable<Map<K, V>> toMap(Func1<? super T, ? extends K> keySelector, Func1<? super T, ? extends V> valueSelector) {
        return unsafeCreate(new OnSubscribeToMap(this, keySelector, valueSelector));
    }

    public final <K, V> Observable<Map<K, V>> toMap(Func1<? super T, ? extends K> keySelector, Func1<? super T, ? extends V> valueSelector, Func0<? extends Map<K, V>> mapFactory) {
        return unsafeCreate(new OnSubscribeToMap(this, keySelector, valueSelector, mapFactory));
    }

    public final <K> Observable<Map<K, Collection<T>>> toMultimap(Func1<? super T, ? extends K> keySelector) {
        return unsafeCreate(new OnSubscribeToMultimap(this, keySelector, UtilityFunctions.identity()));
    }

    public final <K, V> Observable<Map<K, Collection<V>>> toMultimap(Func1<? super T, ? extends K> keySelector, Func1<? super T, ? extends V> valueSelector) {
        return unsafeCreate(new OnSubscribeToMultimap(this, keySelector, valueSelector));
    }

    public final <K, V> Observable<Map<K, Collection<V>>> toMultimap(Func1<? super T, ? extends K> keySelector, Func1<? super T, ? extends V> valueSelector, Func0<? extends Map<K, Collection<V>>> mapFactory) {
        return unsafeCreate(new OnSubscribeToMultimap(this, keySelector, valueSelector, mapFactory));
    }

    public final <K, V> Observable<Map<K, Collection<V>>> toMultimap(Func1<? super T, ? extends K> keySelector, Func1<? super T, ? extends V> valueSelector, Func0<? extends Map<K, Collection<V>>> mapFactory, Func1<? super K, ? extends Collection<V>> collectionFactory) {
        return unsafeCreate(new OnSubscribeToMultimap(this, keySelector, valueSelector, mapFactory, collectionFactory));
    }

    public final Observable<List<T>> toSortedList() {
        return (Observable<List<T>>) lift(new OperatorToObservableSortedList(10));
    }

    public final Observable<List<T>> toSortedList(Func2<? super T, ? super T, Integer> sortFunction) {
        return (Observable<List<T>>) lift(new OperatorToObservableSortedList(sortFunction, 10));
    }

    public final Observable<List<T>> toSortedList(int initialCapacity) {
        return (Observable<List<T>>) lift(new OperatorToObservableSortedList(initialCapacity));
    }

    public final Observable<List<T>> toSortedList(Func2<? super T, ? super T, Integer> sortFunction, int initialCapacity) {
        return (Observable<List<T>>) lift(new OperatorToObservableSortedList(sortFunction, initialCapacity));
    }

    public final Observable<T> sorted() {
        return (Observable<T>) toSortedList().flatMapIterable(UtilityFunctions.identity());
    }

    public final Observable<T> sorted(Func2<? super T, ? super T, Integer> sortFunction) {
        return (Observable<T>) toSortedList(sortFunction).flatMapIterable(UtilityFunctions.identity());
    }

    public final Observable<T> unsubscribeOn(Scheduler scheduler) {
        return (Observable<T>) lift(new OperatorUnsubscribeOn(scheduler));
    }

    public final <U, R> Observable<R> withLatestFrom(Observable<? extends U> other, Func2<? super T, ? super U, ? extends R> resultSelector) {
        return lift(new OperatorWithLatestFrom(other, resultSelector));
    }

    public final <T1, T2, R> Observable<R> withLatestFrom(Observable<T1> o1, Observable<T2> o2, Func3<? super T, ? super T1, ? super T2, R> combiner) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, new Observable[]{o1, o2}, (Iterable) null, Functions.fromFunc(combiner)));
    }

    public final <T1, T2, T3, R> Observable<R> withLatestFrom(Observable<T1> o1, Observable<T2> o2, Observable<T3> o3, Func4<? super T, ? super T1, ? super T2, ? super T3, R> combiner) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, new Observable[]{o1, o2, o3}, (Iterable) null, Functions.fromFunc(combiner)));
    }

    public final <T1, T2, T3, T4, R> Observable<R> withLatestFrom(Observable<T1> o1, Observable<T2> o2, Observable<T3> o3, Observable<T4> o4, Func5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> combiner) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, new Observable[]{o1, o2, o3, o4}, (Iterable) null, Functions.fromFunc(combiner)));
    }

    public final <T1, T2, T3, T4, T5, R> Observable<R> withLatestFrom(Observable<T1> o1, Observable<T2> o2, Observable<T3> o3, Observable<T4> o4, Observable<T5> o5, Func6<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, R> combiner) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, new Observable[]{o1, o2, o3, o4, o5}, (Iterable) null, Functions.fromFunc(combiner)));
    }

    public final <T1, T2, T3, T4, T5, T6, R> Observable<R> withLatestFrom(Observable<T1> o1, Observable<T2> o2, Observable<T3> o3, Observable<T4> o4, Observable<T5> o5, Observable<T6> o6, Func7<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, R> combiner) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, new Observable[]{o1, o2, o3, o4, o5, o6}, (Iterable) null, Functions.fromFunc(combiner)));
    }

    public final <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> withLatestFrom(Observable<T1> o1, Observable<T2> o2, Observable<T3> o3, Observable<T4> o4, Observable<T5> o5, Observable<T6> o6, Observable<T7> o7, Func8<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, R> combiner) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, new Observable[]{o1, o2, o3, o4, o5, o6, o7}, (Iterable) null, Functions.fromFunc(combiner)));
    }

    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> withLatestFrom(Observable<T1> o1, Observable<T2> o2, Observable<T3> o3, Observable<T4> o4, Observable<T5> o5, Observable<T6> o6, Observable<T7> o7, Observable<T8> o8, Func9<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, R> combiner) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, new Observable[]{o1, o2, o3, o4, o5, o6, o7, o8}, (Iterable) null, Functions.fromFunc(combiner)));
    }

    public final <R> Observable<R> withLatestFrom(Observable<?>[] others, FuncN<R> combiner) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, others, (Iterable) null, combiner));
    }

    public final <R> Observable<R> withLatestFrom(Iterable<Observable<?>> others, FuncN<R> combiner) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, (Observable[]) null, others, combiner));
    }

    public final <TClosing> Observable<Observable<T>> window(Func0<? extends Observable<? extends TClosing>> closingSelector) {
        return (Observable<Observable<T>>) lift(new OperatorWindowWithObservableFactory(closingSelector));
    }

    public final Observable<Observable<T>> window(int count) {
        return window(count, count);
    }

    public final Observable<Observable<T>> window(int count, int skip) {
        if (count <= 0) {
            throw new IllegalArgumentException("count > 0 required but it was " + count);
        }
        if (skip <= 0) {
            throw new IllegalArgumentException("skip > 0 required but it was " + skip);
        }
        return (Observable<Observable<T>>) lift(new OperatorWindowWithSize(count, skip));
    }

    public final Observable<Observable<T>> window(long timespan, long timeshift, TimeUnit unit) {
        return window(timespan, timeshift, unit, Integer.MAX_VALUE, Schedulers.computation());
    }

    public final Observable<Observable<T>> window(long timespan, long timeshift, TimeUnit unit, Scheduler scheduler) {
        return window(timespan, timeshift, unit, Integer.MAX_VALUE, scheduler);
    }

    public final Observable<Observable<T>> window(long timespan, long timeshift, TimeUnit unit, int count, Scheduler scheduler) {
        return (Observable<Observable<T>>) lift(new OperatorWindowWithTime(timespan, timeshift, unit, count, scheduler));
    }

    public final Observable<Observable<T>> window(long timespan, TimeUnit unit) {
        return window(timespan, timespan, unit, Schedulers.computation());
    }

    public final Observable<Observable<T>> window(long timespan, TimeUnit unit, int count) {
        return window(timespan, unit, count, Schedulers.computation());
    }

    public final Observable<Observable<T>> window(long timespan, TimeUnit unit, int count, Scheduler scheduler) {
        return window(timespan, timespan, unit, count, scheduler);
    }

    public final Observable<Observable<T>> window(long timespan, TimeUnit unit, Scheduler scheduler) {
        return window(timespan, unit, Integer.MAX_VALUE, scheduler);
    }

    public final <TOpening, TClosing> Observable<Observable<T>> window(Observable<? extends TOpening> windowOpenings, Func1<? super TOpening, ? extends Observable<? extends TClosing>> closingSelector) {
        return (Observable<Observable<T>>) lift(new OperatorWindowWithStartEndObservable(windowOpenings, closingSelector));
    }

    public final <U> Observable<Observable<T>> window(Observable<U> boundary) {
        return (Observable<Observable<T>>) lift(new OperatorWindowWithObservable(boundary));
    }

    public final <T2, R> Observable<R> zipWith(Iterable<? extends T2> other, Func2<? super T, ? super T2, ? extends R> zipFunction) {
        return lift(new OperatorZipIterable(other, zipFunction));
    }

    public final <T2, R> Observable<R> zipWith(Observable<? extends T2> other, Func2<? super T, ? super T2, ? extends R> zipFunction) {
        return zip(this, other, zipFunction);
    }

    public final AssertableSubscriber<T> test() {
        AssertableSubscriber<T> ts = AssertableSubscriberObservable.create(LongCompanionObject.MAX_VALUE);
        subscribe((Observer) ts);
        return ts;
    }

    public final AssertableSubscriber<T> test(long initialRequestAmount) {
        AssertableSubscriber<T> ts = AssertableSubscriberObservable.create(initialRequestAmount);
        subscribe((Observer) ts);
        return ts;
    }
}