package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.RefCountSubscription;

public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements Observable.OnSubscribe<R> {
    final Observable<T1> left;
    final Func1<? super T1, ? extends Observable<D1>> leftDuration;
    final Func2<? super T1, ? super Observable<T2>, ? extends R> resultSelector;
    final Observable<T2> right;
    final Func1<? super T2, ? extends Observable<D2>> rightDuration;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeGroupJoin(Observable<T1> left, Observable<T2> right, Func1<? super T1, ? extends Observable<D1>> leftDuration, Func1<? super T2, ? extends Observable<D2>> rightDuration, Func2<? super T1, ? super Observable<T2>, ? extends R> resultSelector) {
        this.left = left;
        this.right = right;
        this.leftDuration = leftDuration;
        this.rightDuration = rightDuration;
        this.resultSelector = resultSelector;
    }

    public void call(Subscriber<? super R> child) {
        OnSubscribeGroupJoin<T1, T2, D1, D2, R>.ResultManager ro = new ResultManager(new SerializedSubscriber(child));
        child.add(ro);
        ro.init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final class ResultManager extends HashMap<Integer, Observer<T2>> implements Subscription {
        private static final long serialVersionUID = -3035156013812425335L;
        boolean leftDone;
        int leftIds;
        boolean rightDone;
        int rightIds;
        final Subscriber<? super R> subscriber;
        final Map<Integer, T2> rightMap = new HashMap();
        final CompositeSubscription group = new CompositeSubscription();
        final RefCountSubscription cancel = new RefCountSubscription(this.group);

        public ResultManager(Subscriber<? super R> subscriber) {
            this.subscriber = subscriber;
        }

        public void init() {
            Subscriber<T1> s1 = new LeftObserver();
            Subscriber<T2> s2 = new RightObserver();
            this.group.add(s1);
            this.group.add(s2);
            OnSubscribeGroupJoin.this.left.unsafeSubscribe(s1);
            OnSubscribeGroupJoin.this.right.unsafeSubscribe(s2);
        }

        public void unsubscribe() {
            this.cancel.unsubscribe();
        }

        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        Map<Integer, Observer<T2>> leftMap() {
            return this;
        }

        void errorAll(Throwable e) {
            synchronized (this) {
                try {
                    try {
                        List<Observer<T2>> list = new ArrayList<>((Collection<? extends Observer<T2>>) leftMap().values());
                        leftMap().clear();
                        this.rightMap.clear();
                        for (Observer<T2> o : list) {
                            o.onError(e);
                        }
                        this.subscriber.onError(e);
                        this.cancel.unsubscribe();
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        void errorMain(Throwable e) {
            synchronized (this) {
                leftMap().clear();
                this.rightMap.clear();
            }
            this.subscriber.onError(e);
            this.cancel.unsubscribe();
        }

        void complete(List<Observer<T2>> list) {
            if (list != null) {
                for (Observer<T2> o : list) {
                    o.onCompleted();
                }
                this.subscriber.onCompleted();
                this.cancel.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public final class LeftObserver extends Subscriber<T1> {
            LeftObserver() {
            }

            public void onNext(T1 args) {
                try {
                    PublishSubject create = PublishSubject.create();
                    Observer<T2> subjSerial = new SerializedObserver<>(create);
                    synchronized (ResultManager.this) {
                        try {
                            try {
                                ResultManager resultManager = ResultManager.this;
                                int id = resultManager.leftIds;
                                resultManager.leftIds = id + 1;
                                ResultManager.this.leftMap().put(Integer.valueOf(id), subjSerial);
                                Observable<T2> window = Observable.unsafeCreate(new WindowObservableFunc(create, ResultManager.this.cancel));
                                Observable<D1> duration = (Observable) OnSubscribeGroupJoin.this.leftDuration.call(args);
                                Subscriber<D1> d1 = new LeftDurationObserver(id);
                                ResultManager.this.group.add(d1);
                                duration.unsafeSubscribe(d1);
                                Object call = OnSubscribeGroupJoin.this.resultSelector.call(args, window);
                                synchronized (ResultManager.this) {
                                    try {
                                        try {
                                            List<T2> rightMapValues = new ArrayList<>((Collection<? extends T2>) ResultManager.this.rightMap.values());
                                            ResultManager.this.subscriber.onNext(call);
                                            for (T2 t2 : rightMapValues) {
                                                subjSerial.onNext(t2);
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                } catch (Throwable t) {
                    Exceptions.throwOrReport(t, this);
                }
            }

            public void onCompleted() {
                ArrayList arrayList = null;
                synchronized (ResultManager.this) {
                    ResultManager.this.leftDone = true;
                    if (ResultManager.this.rightDone) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                        ResultManager.this.leftMap().clear();
                        ResultManager.this.rightMap.clear();
                    }
                }
                ResultManager.this.complete(arrayList);
            }

            public void onError(Throwable e) {
                ResultManager.this.errorAll(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public final class RightObserver extends Subscriber<T2> {
            RightObserver() {
            }

            public void onNext(T2 args) {
                try {
                    synchronized (ResultManager.this) {
                        try {
                            try {
                                ResultManager resultManager = ResultManager.this;
                                int id = resultManager.rightIds;
                                resultManager.rightIds = id + 1;
                                ResultManager.this.rightMap.put(Integer.valueOf(id), args);
                                Observable<D2> duration = (Observable) OnSubscribeGroupJoin.this.rightDuration.call(args);
                                Subscriber<D2> d2 = new RightDurationObserver(id);
                                ResultManager.this.group.add(d2);
                                duration.unsafeSubscribe(d2);
                                synchronized (ResultManager.this) {
                                    try {
                                        try {
                                            List<Observer<T2>> list = new ArrayList<>((Collection<? extends Observer<T2>>) ResultManager.this.leftMap().values());
                                            for (Observer<T2> o : list) {
                                                o.onNext(args);
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                } catch (Throwable t) {
                    Exceptions.throwOrReport(t, this);
                }
            }

            public void onCompleted() {
                ArrayList arrayList = null;
                synchronized (ResultManager.this) {
                    ResultManager.this.rightDone = true;
                    if (ResultManager.this.leftDone) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                        ResultManager.this.leftMap().clear();
                        ResultManager.this.rightMap.clear();
                    }
                }
                ResultManager.this.complete(arrayList);
            }

            public void onError(Throwable e) {
                ResultManager.this.errorAll(e);
            }
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class LeftDurationObserver extends Subscriber<D1> {
            final int id;
            boolean once = true;

            public LeftDurationObserver(int id) {
                this.id = id;
            }

            public void onCompleted() {
                if (this.once) {
                    this.once = false;
                    synchronized (ResultManager.this) {
                        try {
                            try {
                                Observer<T2> gr = ResultManager.this.leftMap().remove(Integer.valueOf(this.id));
                                if (gr != null) {
                                    gr.onCompleted();
                                }
                                ResultManager.this.group.remove(this);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
            }

            public void onError(Throwable e) {
                ResultManager.this.errorMain(e);
            }

            public void onNext(D1 args) {
                onCompleted();
            }
        }

        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        final class RightDurationObserver extends Subscriber<D2> {
            final int id;
            boolean once = true;

            public RightDurationObserver(int id) {
                this.id = id;
            }

            public void onCompleted() {
                if (this.once) {
                    this.once = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.id));
                    }
                    ResultManager.this.group.remove(this);
                }
            }

            public void onError(Throwable e) {
                ResultManager.this.errorMain(e);
            }

            public void onNext(D2 args) {
                onCompleted();
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class WindowObservableFunc<T> implements Observable.OnSubscribe<T> {
        final RefCountSubscription refCount;
        final Observable<T> underlying;

        public /* bridge */ /* synthetic */ void call(Object x0) {
            call((Subscriber) ((Subscriber) x0));
        }

        public WindowObservableFunc(Observable<T> underlying, RefCountSubscription refCount) {
            this.refCount = refCount;
            this.underlying = underlying;
        }

        public void call(Subscriber<? super T> t1) {
            Subscription ref = this.refCount.get();
            WindowObservableFunc<T>.WindowSubscriber wo = new WindowSubscriber(t1, ref);
            wo.add(ref);
            this.underlying.unsafeSubscribe(wo);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public final class WindowSubscriber extends Subscriber<T> {
            private final Subscription ref;
            final Subscriber<? super T> subscriber;

            public WindowSubscriber(Subscriber<? super T> subscriber, Subscription ref) {
                super(subscriber);
                this.subscriber = subscriber;
                this.ref = ref;
            }

            public void onNext(T args) {
                this.subscriber.onNext(args);
            }

            public void onError(Throwable e) {
                this.subscriber.onError(e);
                this.ref.unsubscribe();
            }

            public void onCompleted() {
                this.subscriber.onCompleted();
                this.ref.unsubscribe();
            }
        }
    }
}