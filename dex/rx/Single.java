package rx;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Scheduler;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
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
import rx.internal.observers.AssertableSubscriberObservable;
import rx.internal.operators.CompletableFlatMapSingleToCompletable;
import rx.internal.operators.SingleDelay;
import rx.internal.operators.SingleDoAfterTerminate;
import rx.internal.operators.SingleDoOnEvent;
import rx.internal.operators.SingleDoOnSubscribe;
import rx.internal.operators.SingleDoOnUnsubscribe;
import rx.internal.operators.SingleFromCallable;
import rx.internal.operators.SingleFromEmitter;
import rx.internal.operators.SingleFromFuture;
import rx.internal.operators.SingleFromObservable;
import rx.internal.operators.SingleLiftObservableOperator;
import rx.internal.operators.SingleObserveOn;
import rx.internal.operators.SingleOnErrorReturn;
import rx.internal.operators.SingleOnSubscribeDelaySubscriptionOther;
import rx.internal.operators.SingleOnSubscribeMap;
import rx.internal.operators.SingleOnSubscribeUsing;
import rx.internal.operators.SingleOperatorOnErrorResumeNext;
import rx.internal.operators.SingleOperatorZip;
import rx.internal.operators.SingleTakeUntilCompletable;
import rx.internal.operators.SingleTakeUntilObservable;
import rx.internal.operators.SingleTakeUntilSingle;
import rx.internal.operators.SingleTimeout;
import rx.internal.operators.SingleToObservable;
import rx.internal.util.ScalarSynchronousSingle;
import rx.internal.util.UtilityFunctions;
import rx.observers.AssertableSubscriber;
import rx.observers.SafeSubscriber;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;
import rx.singles.BlockingSingle;
import rx.subscriptions.Subscriptions;

public class Single<T> {
    final OnSubscribe<T> onSubscribe;

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface OnSubscribe<T> extends Action1<SingleSubscriber<? super T>> {
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface Transformer<T, R> extends Func1<Single<T>, Single<R>> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Single(OnSubscribe<T> f) {
        this.onSubscribe = RxJavaHooks.onCreate(f);
    }

    @Deprecated
    protected Single(Observable.OnSubscribe<T> f) {
        this.onSubscribe = RxJavaHooks.onCreate(new SingleFromObservable(f));
    }

    public static <T> Single<T> create(OnSubscribe<T> f) {
        return new Single<>(f);
    }

    public final <R> Single<R> lift(Observable.Operator<? extends R, ? super T> lift) {
        return create(new SingleLiftObservableOperator(this.onSubscribe, lift));
    }

    public <R> Single<R> compose(Transformer<? super T, ? extends R> transformer) {
        return (Single) transformer.call(this);
    }

    private static <T> Observable<T> asObservable(Single<T> t) {
        return Observable.unsafeCreate(new SingleToObservable(t.onSubscribe));
    }

    public static <T> Observable<T> concat(Single<? extends T> t1, Single<? extends T> t2) {
        return Observable.concat(asObservable(t1), asObservable(t2));
    }

    public static <T> Observable<T> concat(Single<? extends T> t1, Single<? extends T> t2, Single<? extends T> t3) {
        return Observable.concat(asObservable(t1), asObservable(t2), asObservable(t3));
    }

    public static <T> Observable<T> concat(Single<? extends T> t1, Single<? extends T> t2, Single<? extends T> t3, Single<? extends T> t4) {
        return Observable.concat(asObservable(t1), asObservable(t2), asObservable(t3), asObservable(t4));
    }

    public static <T> Observable<T> concat(Single<? extends T> t1, Single<? extends T> t2, Single<? extends T> t3, Single<? extends T> t4, Single<? extends T> t5) {
        return Observable.concat(asObservable(t1), asObservable(t2), asObservable(t3), asObservable(t4), asObservable(t5));
    }

    public static <T> Observable<T> concat(Single<? extends T> t1, Single<? extends T> t2, Single<? extends T> t3, Single<? extends T> t4, Single<? extends T> t5, Single<? extends T> t6) {
        return Observable.concat(asObservable(t1), asObservable(t2), asObservable(t3), asObservable(t4), asObservable(t5), asObservable(t6));
    }

    public static <T> Observable<T> concat(Single<? extends T> t1, Single<? extends T> t2, Single<? extends T> t3, Single<? extends T> t4, Single<? extends T> t5, Single<? extends T> t6, Single<? extends T> t7) {
        return Observable.concat(asObservable(t1), asObservable(t2), asObservable(t3), asObservable(t4), asObservable(t5), asObservable(t6), asObservable(t7));
    }

    public static <T> Observable<T> concat(Single<? extends T> t1, Single<? extends T> t2, Single<? extends T> t3, Single<? extends T> t4, Single<? extends T> t5, Single<? extends T> t6, Single<? extends T> t7, Single<? extends T> t8) {
        return Observable.concat(asObservable(t1), asObservable(t2), asObservable(t3), asObservable(t4), asObservable(t5), asObservable(t6), asObservable(t7), asObservable(t8));
    }

    public static <T> Observable<T> concat(Single<? extends T> t1, Single<? extends T> t2, Single<? extends T> t3, Single<? extends T> t4, Single<? extends T> t5, Single<? extends T> t6, Single<? extends T> t7, Single<? extends T> t8, Single<? extends T> t9) {
        return Observable.concat(asObservable(t1), asObservable(t2), asObservable(t3), asObservable(t4), asObservable(t5), asObservable(t6), asObservable(t7), asObservable(t8), asObservable(t9));
    }

    public static <T> Single<T> error(final Throwable exception) {
        return create(new OnSubscribe<T>() { // from class: rx.Single.1
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((SingleSubscriber) ((SingleSubscriber) x0));
            }

            public void call(SingleSubscriber<? super T> te) {
                te.onError(exception);
            }
        });
    }

    public static <T> Single<T> from(Future<? extends T> future) {
        return create(new SingleFromFuture(future, 0L, (TimeUnit) null));
    }

    public static <T> Single<T> from(Future<? extends T> future, long timeout, TimeUnit unit) {
        if (unit == null) {
            throw new NullPointerException("unit is null");
        }
        return create(new SingleFromFuture(future, timeout, unit));
    }

    public static <T> Single<T> from(Future<? extends T> future, Scheduler scheduler) {
        return from(future).subscribeOn(scheduler);
    }

    public static <T> Single<T> fromCallable(Callable<? extends T> func) {
        return create(new SingleFromCallable(func));
    }

    public static <T> Single<T> fromEmitter(Action1<SingleEmitter<T>> producer) {
        if (producer == null) {
            throw new NullPointerException("producer is null");
        }
        return create(new SingleFromEmitter(producer));
    }

    public static <T> Single<T> just(T value) {
        return ScalarSynchronousSingle.create(value);
    }

    public static <T> Single<T> merge(Single<? extends Single<? extends T>> source) {
        if (source instanceof ScalarSynchronousSingle) {
            return ((ScalarSynchronousSingle) source).scalarFlatMap(UtilityFunctions.identity());
        }
        return create(new OnSubscribe<T>() { // from class: rx.Single.2
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((SingleSubscriber) ((SingleSubscriber) x0));
            }

            public void call(final SingleSubscriber<? super T> child) {
                SingleSubscriber<Single<? extends T>> parent = new SingleSubscriber<Single<? extends T>>() { // from class: rx.Single.2.1
                    @Override // rx.SingleSubscriber
                    public /* bridge */ /* synthetic */ void onSuccess(Object x0) {
                        onSuccess((Single) ((Single) x0));
                    }

                    public void onSuccess(Single<? extends T> innerSingle) {
                        innerSingle.subscribe(child);
                    }

                    @Override // rx.SingleSubscriber
                    public void onError(Throwable error) {
                        child.onError(error);
                    }
                };
                child.add(parent);
                Single.this.subscribe(parent);
            }
        });
    }

    public static <T> Observable<T> merge(Single<? extends T> t1, Single<? extends T> t2) {
        return Observable.merge(asObservable(t1), asObservable(t2));
    }

    public static <T> Observable<T> merge(Single<? extends T> t1, Single<? extends T> t2, Single<? extends T> t3) {
        return Observable.merge(asObservable(t1), asObservable(t2), asObservable(t3));
    }

    public static <T> Observable<T> merge(Single<? extends T> t1, Single<? extends T> t2, Single<? extends T> t3, Single<? extends T> t4) {
        return Observable.merge(asObservable(t1), asObservable(t2), asObservable(t3), asObservable(t4));
    }

    public static <T> Observable<T> merge(Single<? extends T> t1, Single<? extends T> t2, Single<? extends T> t3, Single<? extends T> t4, Single<? extends T> t5) {
        return Observable.merge(asObservable(t1), asObservable(t2), asObservable(t3), asObservable(t4), asObservable(t5));
    }

    public static <T> Observable<T> merge(Single<? extends T> t1, Single<? extends T> t2, Single<? extends T> t3, Single<? extends T> t4, Single<? extends T> t5, Single<? extends T> t6) {
        return Observable.merge(asObservable(t1), asObservable(t2), asObservable(t3), asObservable(t4), asObservable(t5), asObservable(t6));
    }

    public static <T> Observable<T> merge(Single<? extends T> t1, Single<? extends T> t2, Single<? extends T> t3, Single<? extends T> t4, Single<? extends T> t5, Single<? extends T> t6, Single<? extends T> t7) {
        return Observable.merge(asObservable(t1), asObservable(t2), asObservable(t3), asObservable(t4), asObservable(t5), asObservable(t6), asObservable(t7));
    }

    public static <T> Observable<T> merge(Single<? extends T> t1, Single<? extends T> t2, Single<? extends T> t3, Single<? extends T> t4, Single<? extends T> t5, Single<? extends T> t6, Single<? extends T> t7, Single<? extends T> t8) {
        return Observable.merge(asObservable(t1), asObservable(t2), asObservable(t3), asObservable(t4), asObservable(t5), asObservable(t6), asObservable(t7), asObservable(t8));
    }

    public static <T> Observable<T> merge(Single<? extends T> t1, Single<? extends T> t2, Single<? extends T> t3, Single<? extends T> t4, Single<? extends T> t5, Single<? extends T> t6, Single<? extends T> t7, Single<? extends T> t8, Single<? extends T> t9) {
        return Observable.merge(asObservable(t1), asObservable(t2), asObservable(t3), asObservable(t4), asObservable(t5), asObservable(t6), asObservable(t7), asObservable(t8), asObservable(t9));
    }

    public static <T> Observable<T> merge(Observable<? extends Single<? extends T>> sources) {
        return merge(sources, Integer.MAX_VALUE);
    }

    public static <T> Observable<T> merge(Observable<? extends Single<? extends T>> sources, int maxConcurrency) {
        return (Observable<T>) sources.flatMapSingle(UtilityFunctions.identity(), false, maxConcurrency);
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends Single<? extends T>> sources) {
        return merge(sources, Integer.MAX_VALUE);
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends Single<? extends T>> sources, int maxConcurrency) {
        return (Observable<T>) sources.flatMapSingle(UtilityFunctions.identity(), true, maxConcurrency);
    }

    public static <T1, T2, R> Single<R> zip(Single<? extends T1> s1, Single<? extends T2> s2, final Func2<? super T1, ? super T2, ? extends R> zipFunction) {
        return SingleOperatorZip.zip(new Single[]{s1, s2}, new FuncN<R>() { // from class: rx.Single.3
            @Override // rx.functions.FuncN
            public R call(Object... args) {
                return (R) Func2.this.call(args[0], args[1]);
            }
        });
    }

    public static <T1, T2, T3, R> Single<R> zip(Single<? extends T1> s1, Single<? extends T2> s2, Single<? extends T3> s3, final Func3<? super T1, ? super T2, ? super T3, ? extends R> zipFunction) {
        return SingleOperatorZip.zip(new Single[]{s1, s2, s3}, new FuncN<R>() { // from class: rx.Single.4
            @Override // rx.functions.FuncN
            public R call(Object... args) {
                return (R) Func3.this.call(args[0], args[1], args[2]);
            }
        });
    }

    public static <T1, T2, T3, T4, R> Single<R> zip(Single<? extends T1> s1, Single<? extends T2> s2, Single<? extends T3> s3, Single<? extends T4> s4, final Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> zipFunction) {
        return SingleOperatorZip.zip(new Single[]{s1, s2, s3, s4}, new FuncN<R>() { // from class: rx.Single.5
            @Override // rx.functions.FuncN
            public R call(Object... args) {
                return (R) Func4.this.call(args[0], args[1], args[2], args[3]);
            }
        });
    }

    public static <T1, T2, T3, T4, T5, R> Single<R> zip(Single<? extends T1> s1, Single<? extends T2> s2, Single<? extends T3> s3, Single<? extends T4> s4, Single<? extends T5> s5, final Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> zipFunction) {
        return SingleOperatorZip.zip(new Single[]{s1, s2, s3, s4, s5}, new FuncN<R>() { // from class: rx.Single.6
            @Override // rx.functions.FuncN
            public R call(Object... args) {
                return (R) Func5.this.call(args[0], args[1], args[2], args[3], args[4]);
            }
        });
    }

    public static <T1, T2, T3, T4, T5, T6, R> Single<R> zip(Single<? extends T1> s1, Single<? extends T2> s2, Single<? extends T3> s3, Single<? extends T4> s4, Single<? extends T5> s5, Single<? extends T6> s6, final Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> zipFunction) {
        return SingleOperatorZip.zip(new Single[]{s1, s2, s3, s4, s5, s6}, new FuncN<R>() { // from class: rx.Single.7
            @Override // rx.functions.FuncN
            public R call(Object... args) {
                return (R) Func6.this.call(args[0], args[1], args[2], args[3], args[4], args[5]);
            }
        });
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Single<R> zip(Single<? extends T1> s1, Single<? extends T2> s2, Single<? extends T3> s3, Single<? extends T4> s4, Single<? extends T5> s5, Single<? extends T6> s6, Single<? extends T7> s7, final Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> zipFunction) {
        return SingleOperatorZip.zip(new Single[]{s1, s2, s3, s4, s5, s6, s7}, new FuncN<R>() { // from class: rx.Single.8
            @Override // rx.functions.FuncN
            public R call(Object... args) {
                return (R) Func7.this.call(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
            }
        });
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Single<R> zip(Single<? extends T1> s1, Single<? extends T2> s2, Single<? extends T3> s3, Single<? extends T4> s4, Single<? extends T5> s5, Single<? extends T6> s6, Single<? extends T7> s7, Single<? extends T8> s8, final Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> zipFunction) {
        return SingleOperatorZip.zip(new Single[]{s1, s2, s3, s4, s5, s6, s7, s8}, new FuncN<R>() { // from class: rx.Single.9
            @Override // rx.functions.FuncN
            public R call(Object... args) {
                return (R) Func8.this.call(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);
            }
        });
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Single<R> zip(Single<? extends T1> s1, Single<? extends T2> s2, Single<? extends T3> s3, Single<? extends T4> s4, Single<? extends T5> s5, Single<? extends T6> s6, Single<? extends T7> s7, Single<? extends T8> s8, Single<? extends T9> s9, final Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> zipFunction) {
        return SingleOperatorZip.zip(new Single[]{s1, s2, s3, s4, s5, s6, s7, s8, s9}, new FuncN<R>() { // from class: rx.Single.10
            @Override // rx.functions.FuncN
            public R call(Object... args) {
                return (R) Func9.this.call(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
            }
        });
    }

    public static <R> Single<R> zip(Iterable<? extends Single<?>> singles, FuncN<? extends R> zipFunction) {
        Single[] iterableToArray = iterableToArray(singles);
        return SingleOperatorZip.zip(iterableToArray, zipFunction);
    }

    public final Single<T> cache() {
        return toObservable().cacheWithInitialCapacity(1).toSingle();
    }

    public final Observable<T> concatWith(Single<? extends T> t1) {
        return concat(this, t1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Single<R> flatMap(Func1<? super T, ? extends Single<? extends R>> func) {
        if (this instanceof ScalarSynchronousSingle) {
            return ((ScalarSynchronousSingle) this).scalarFlatMap(func);
        }
        return merge(map(func));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> flatMapObservable(Func1<? super T, ? extends Observable<? extends R>> func) {
        return Observable.merge(asObservable(map(func)));
    }

    public final Completable flatMapCompletable(Func1<? super T, ? extends Completable> func) {
        return Completable.create(new CompletableFlatMapSingleToCompletable(this, func));
    }

    public final <R> Single<R> map(Func1<? super T, ? extends R> func) {
        return create(new SingleOnSubscribeMap(this, func));
    }

    public final Observable<T> mergeWith(Single<? extends T> t1) {
        return merge(this, t1);
    }

    public final Single<T> observeOn(Scheduler scheduler) {
        if (this instanceof ScalarSynchronousSingle) {
            return ((ScalarSynchronousSingle) this).scalarScheduleOn(scheduler);
        }
        if (scheduler == null) {
            throw new NullPointerException("scheduler is null");
        }
        return create(new SingleObserveOn(this.onSubscribe, scheduler));
    }

    public final Single<T> onErrorReturn(Func1<Throwable, ? extends T> resumeFunction) {
        return create(new SingleOnErrorReturn(this.onSubscribe, resumeFunction));
    }

    public final Single<T> onErrorResumeNext(Single<? extends T> resumeSingleInCaseOfError) {
        return new Single<>((OnSubscribe) SingleOperatorOnErrorResumeNext.withOther(this, resumeSingleInCaseOfError));
    }

    public final Single<T> onErrorResumeNext(Func1<Throwable, ? extends Single<? extends T>> resumeFunctionInCaseOfError) {
        return new Single<>((OnSubscribe) SingleOperatorOnErrorResumeNext.withFunction(this, resumeFunctionInCaseOfError));
    }

    public final Subscription subscribe() {
        return subscribe(Actions.empty(), Actions.errorNotImplemented());
    }

    public final Subscription subscribe(Action1<? super T> onSuccess) {
        return subscribe(onSuccess, Actions.errorNotImplemented());
    }

    public final Subscription subscribe(final Action1<? super T> onSuccess, final Action1<Throwable> onError) {
        if (onSuccess == null) {
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        if (onError == null) {
            throw new IllegalArgumentException("onError can not be null");
        }
        return subscribe(new SingleSubscriber<T>() { // from class: rx.Single.11
            @Override // rx.SingleSubscriber
            public final void onError(Throwable e) {
                try {
                    onError.call(e);
                } finally {
                    unsubscribe();
                }
            }

            @Override // rx.SingleSubscriber
            public final void onSuccess(T args) {
                try {
                    onSuccess.call(args);
                } finally {
                    unsubscribe();
                }
            }
        });
    }

    public final Subscription unsafeSubscribe(Subscriber<? super T> subscriber) {
        return unsafeSubscribe(subscriber, true);
    }

    private Subscription unsafeSubscribe(Subscriber<? super T> subscriber, boolean start) {
        if (start) {
            try {
                subscriber.onStart();
            } catch (Throwable e) {
                Exceptions.throwIfFatal(e);
                try {
                    subscriber.onError(RxJavaHooks.onSingleError(e));
                    return Subscriptions.unsubscribed();
                } catch (Throwable e2) {
                    Exceptions.throwIfFatal(e2);
                    RuntimeException r = new RuntimeException("Error occurred attempting to subscribe [" + e.getMessage() + "] and then again while trying to pass to onError.", e2);
                    RxJavaHooks.onSingleError(r);
                    throw r;
                }
            }
        }
        RxJavaHooks.onSingleStart(this, this.onSubscribe).call(SingleLiftObservableOperator.wrap(subscriber));
        return RxJavaHooks.onSingleReturn(subscriber);
    }

    public final Subscription subscribe(final Observer<? super T> observer) {
        if (observer == null) {
            throw new NullPointerException("observer is null");
        }
        return subscribe(new SingleSubscriber<T>() { // from class: rx.Single.12
            @Override // rx.SingleSubscriber
            public void onSuccess(T value) {
                observer.onNext(value);
                observer.onCompleted();
            }

            @Override // rx.SingleSubscriber
            public void onError(Throwable error) {
                observer.onError(error);
            }
        });
    }

    public final Subscription subscribe(Subscriber<? super T> subscriber) {
        if (subscriber == null) {
            throw new IllegalArgumentException("observer can not be null");
        }
        subscriber.onStart();
        if (!(subscriber instanceof SafeSubscriber)) {
            return unsafeSubscribe(new SafeSubscriber(subscriber), false);
        }
        return unsafeSubscribe(subscriber, true);
    }

    public final Subscription subscribe(SingleSubscriber<? super T> te) {
        if (te == null) {
            throw new IllegalArgumentException("te is null");
        }
        try {
            RxJavaHooks.onSingleStart(this, this.onSubscribe).call(te);
            return RxJavaHooks.onSingleReturn(te);
        } catch (Throwable ex) {
            Exceptions.throwIfFatal(ex);
            try {
                te.onError(RxJavaHooks.onSingleError(ex));
                return Subscriptions.empty();
            } catch (Throwable e2) {
                Exceptions.throwIfFatal(e2);
                RuntimeException r = new RuntimeException("Error occurred attempting to subscribe [" + ex.getMessage() + "] and then again while trying to pass to onError.", e2);
                RxJavaHooks.onSingleError(r);
                throw r;
            }
        }
    }

    public final Single<T> subscribeOn(final Scheduler scheduler) {
        if (this instanceof ScalarSynchronousSingle) {
            return ((ScalarSynchronousSingle) this).scalarScheduleOn(scheduler);
        }
        return create(new OnSubscribe<T>() { // from class: rx.Single.13
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((SingleSubscriber) ((SingleSubscriber) x0));
            }

            public void call(final SingleSubscriber<? super T> t) {
                final Scheduler.Worker w = scheduler.createWorker();
                t.add(w);
                w.schedule(new Action0() { // from class: rx.Single.13.1
                    @Override // rx.functions.Action0
                    public void call() {
                        SingleSubscriber<T> single = new SingleSubscriber<T>() { // from class: rx.Single.13.1.1
                            @Override // rx.SingleSubscriber
                            public void onSuccess(T value) {
                                try {
                                    t.onSuccess(value);
                                } finally {
                                    w.unsubscribe();
                                }
                            }

                            @Override // rx.SingleSubscriber
                            public void onError(Throwable error) {
                                try {
                                    t.onError(error);
                                } finally {
                                    w.unsubscribe();
                                }
                            }
                        };
                        t.add(single);
                        Single.this.subscribe(single);
                    }
                });
            }
        });
    }

    public final Single<T> takeUntil(Completable other) {
        return create(new SingleTakeUntilCompletable(this.onSubscribe, other));
    }

    public final <E> Single<T> takeUntil(Observable<? extends E> other) {
        return create(new SingleTakeUntilObservable(this.onSubscribe, other));
    }

    public final <E> Single<T> takeUntil(Single<? extends E> other) {
        return create(new SingleTakeUntilSingle(this.onSubscribe, other));
    }

    public final <R> R to(Func1<? super Single<T>, R> converter) {
        return converter.call(this);
    }

    public final Observable<T> toObservable() {
        return asObservable(this);
    }

    public final Completable toCompletable() {
        return Completable.fromSingle(this);
    }

    public final Single<T> timeout(long timeout, TimeUnit timeUnit) {
        return timeout(timeout, timeUnit, null, Schedulers.computation());
    }

    public final Single<T> timeout(long timeout, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout(timeout, timeUnit, null, scheduler);
    }

    public final Single<T> timeout(long timeout, TimeUnit timeUnit, Single<? extends T> other) {
        return timeout(timeout, timeUnit, other, Schedulers.computation());
    }

    public final Single<T> timeout(long timeout, TimeUnit timeUnit, Single<? extends T> other, Scheduler scheduler) {
        if (other == null) {
            other = defer(new Func0<Single<T>>() { // from class: rx.Single.14
                @Override // rx.functions.Func0, java.util.concurrent.Callable
                public Single<T> call() {
                    return Single.error(new TimeoutException());
                }
            });
        }
        return create(new SingleTimeout(this.onSubscribe, timeout, timeUnit, scheduler, other.onSubscribe));
    }

    public final BlockingSingle<T> toBlocking() {
        return BlockingSingle.from(this);
    }

    public final <T2, R> Single<R> zipWith(Single<? extends T2> other, Func2<? super T, ? super T2, ? extends R> zipFunction) {
        return zip(this, other, zipFunction);
    }

    public final Single<T> doOnError(final Action1<Throwable> onError) {
        if (onError == null) {
            throw new IllegalArgumentException("onError is null");
        }
        return create(new SingleDoOnEvent(this, Actions.empty(), new Action1<Throwable>() { // from class: rx.Single.15
            @Override // rx.functions.Action1
            public void call(Throwable throwable) {
                onError.call(throwable);
            }
        }));
    }

    public final Single<T> doOnEach(final Action1<Notification<? extends T>> onNotification) {
        if (onNotification == null) {
            throw new IllegalArgumentException("onNotification is null");
        }
        return create(new SingleDoOnEvent(this, new Action1<T>() { // from class: rx.Single.16
            @Override // rx.functions.Action1
            public void call(T t) {
                onNotification.call(Notification.createOnNext(t));
            }
        }, new Action1<Throwable>() { // from class: rx.Single.17
            @Override // rx.functions.Action1
            public void call(Throwable throwable) {
                onNotification.call(Notification.createOnError(throwable));
            }
        }));
    }

    public final Single<T> doOnSuccess(Action1<? super T> onSuccess) {
        if (onSuccess == null) {
            throw new IllegalArgumentException("onSuccess is null");
        }
        Action1<Throwable> empty = Actions.empty();
        return create(new SingleDoOnEvent(this, onSuccess, empty));
    }

    public final Single<T> doOnSubscribe(Action0 subscribe) {
        return create(new SingleDoOnSubscribe(this.onSubscribe, subscribe));
    }

    public final Single<T> delay(long delay, TimeUnit unit, Scheduler scheduler) {
        return create(new SingleDelay(this.onSubscribe, delay, unit, scheduler));
    }

    public final Single<T> delay(long delay, TimeUnit unit) {
        return delay(delay, unit, Schedulers.computation());
    }

    public static <T> Single<T> defer(final Callable<Single<T>> singleFactory) {
        return create(new OnSubscribe<T>() { // from class: rx.Single.18
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((SingleSubscriber) ((SingleSubscriber) x0));
            }

            public void call(SingleSubscriber<? super T> singleSubscriber) {
                try {
                    Single<? extends T> single = (Single) singleFactory.call();
                    single.subscribe((SingleSubscriber<? super Object>) singleSubscriber);
                } catch (Throwable t) {
                    Exceptions.throwIfFatal(t);
                    singleSubscriber.onError(t);
                }
            }
        });
    }

    public final Single<T> doOnUnsubscribe(Action0 action) {
        return create(new SingleDoOnUnsubscribe(this.onSubscribe, action));
    }

    public final Single<T> doAfterTerminate(Action0 action) {
        return create(new SingleDoAfterTerminate(this, action));
    }

    static <T> Single<? extends T>[] iterableToArray(Iterable<? extends Single<? extends T>> singlesIterable) {
        if (singlesIterable instanceof Collection) {
            Collection<? extends Single<? extends T>> list = (Collection) singlesIterable;
            int count = list.size();
            return (Single[]) list.toArray(new Single[count]);
        }
        Single<? extends T>[] tempArray = new Single[8];
        int count2 = 0;
        for (Single<? extends T> s : singlesIterable) {
            if (count2 == tempArray.length) {
                Single<? extends T>[] sb = new Single[(count2 >> 2) + count2];
                System.arraycopy(tempArray, 0, sb, 0, count2);
                tempArray = sb;
            }
            tempArray[count2] = s;
            count2++;
        }
        if (tempArray.length != count2) {
            Single<? extends T>[] singlesArray = new Single[count2];
            System.arraycopy(tempArray, 0, singlesArray, 0, count2);
            return singlesArray;
        }
        return tempArray;
    }

    public final Single<T> retry() {
        return toObservable().retry().toSingle();
    }

    public final Single<T> retry(long count) {
        return toObservable().retry(count).toSingle();
    }

    public final Single<T> retry(Func2<Integer, Throwable, Boolean> predicate) {
        return toObservable().retry(predicate).toSingle();
    }

    public final Single<T> retryWhen(Func1<Observable<? extends Throwable>, ? extends Observable<?>> notificationHandler) {
        return toObservable().retryWhen(notificationHandler).toSingle();
    }

    public static <T, Resource> Single<T> using(Func0<Resource> resourceFactory, Func1<? super Resource, ? extends Single<? extends T>> singleFactory, Action1<? super Resource> disposeAction) {
        return using(resourceFactory, singleFactory, disposeAction, false);
    }

    public static <T, Resource> Single<T> using(Func0<Resource> resourceFactory, Func1<? super Resource, ? extends Single<? extends T>> singleFactory, Action1<? super Resource> disposeAction, boolean disposeEagerly) {
        if (resourceFactory == null) {
            throw new NullPointerException("resourceFactory is null");
        }
        if (singleFactory == null) {
            throw new NullPointerException("singleFactory is null");
        }
        if (disposeAction == null) {
            throw new NullPointerException("disposeAction is null");
        }
        return create(new SingleOnSubscribeUsing(resourceFactory, singleFactory, disposeAction, disposeEagerly));
    }

    public final Single<T> delaySubscription(Observable<?> other) {
        if (other == null) {
            throw new NullPointerException();
        }
        return create(new SingleOnSubscribeDelaySubscriptionOther(this, other));
    }

    public final Single<T> unsubscribeOn(final Scheduler scheduler) {
        return create(new OnSubscribe<T>() { // from class: rx.Single.19
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object x0) {
                call((SingleSubscriber) ((SingleSubscriber) x0));
            }

            public void call(final SingleSubscriber<? super T> t) {
                final SingleSubscriber<T> single = new SingleSubscriber<T>() { // from class: rx.Single.19.1
                    @Override // rx.SingleSubscriber
                    public void onSuccess(T value) {
                        t.onSuccess(value);
                    }

                    @Override // rx.SingleSubscriber
                    public void onError(Throwable error) {
                        t.onError(error);
                    }
                };
                t.add(Subscriptions.create(new Action0() { // from class: rx.Single.19.2
                    @Override // rx.functions.Action0
                    public void call() {
                        final Scheduler.Worker w = scheduler.createWorker();
                        w.schedule(new Action0() { // from class: rx.Single.19.2.1
                            @Override // rx.functions.Action0
                            public void call() {
                                try {
                                    single.unsubscribe();
                                } finally {
                                    w.unsubscribe();
                                }
                            }
                        });
                    }
                }));
                Single.this.subscribe(single);
            }
        });
    }

    public final AssertableSubscriber<T> test() {
        AssertableSubscriberObservable<T> ts = AssertableSubscriberObservable.create(LongCompanionObject.MAX_VALUE);
        subscribe((Subscriber) ts);
        return ts;
    }
}