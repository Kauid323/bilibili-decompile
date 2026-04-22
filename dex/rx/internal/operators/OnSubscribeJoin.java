package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements Observable.OnSubscribe<R> {
    final Observable<TLeft> left;
    final Func1<TLeft, Observable<TLeftDuration>> leftDurationSelector;
    final Func2<TLeft, TRight, R> resultSelector;
    final Observable<TRight> right;
    final Func1<TRight, Observable<TRightDuration>> rightDurationSelector;

    public /* bridge */ /* synthetic */ void call(Object x0) {
        call((Subscriber) ((Subscriber) x0));
    }

    public OnSubscribeJoin(Observable<TLeft> left, Observable<TRight> right, Func1<TLeft, Observable<TLeftDuration>> leftDurationSelector, Func1<TRight, Observable<TRightDuration>> rightDurationSelector, Func2<TLeft, TRight, R> resultSelector) {
        this.left = left;
        this.right = right;
        this.leftDurationSelector = leftDurationSelector;
        this.rightDurationSelector = rightDurationSelector;
        this.resultSelector = resultSelector;
    }

    public void call(Subscriber<? super R> t1) {
        OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R>.ResultSink result = new ResultSink(new SerializedSubscriber(t1));
        result.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final class ResultSink extends HashMap<Integer, TLeft> {
        private static final long serialVersionUID = 3491669543549085380L;
        boolean leftDone;
        int leftId;
        boolean rightDone;
        int rightId;
        final Subscriber<? super R> subscriber;
        final CompositeSubscription group = new CompositeSubscription();
        final Map<Integer, TRight> rightMap = new HashMap();

        public ResultSink(Subscriber<? super R> subscriber) {
            this.subscriber = subscriber;
        }

        HashMap<Integer, TLeft> leftMap() {
            return this;
        }

        public void run() {
            this.subscriber.add(this.group);
            Subscriber<TLeft> s1 = new LeftSubscriber();
            Subscriber<TRight> s2 = new RightSubscriber();
            this.group.add(s1);
            this.group.add(s2);
            OnSubscribeJoin.this.left.unsafeSubscribe(s1);
            OnSubscribeJoin.this.right.unsafeSubscribe(s2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public final class LeftSubscriber extends Subscriber<TLeft> {
            LeftSubscriber() {
            }

            protected void expire(int id, Subscription resource) {
                boolean complete = false;
                synchronized (ResultSink.this) {
                    if (ResultSink.this.leftMap().remove(Integer.valueOf(id)) != null && ResultSink.this.leftMap().isEmpty() && ResultSink.this.leftDone) {
                        complete = true;
                    }
                }
                if (complete) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.remove(resource);
            }

            public void onNext(TLeft args) {
                int id;
                synchronized (ResultSink.this) {
                    try {
                        try {
                            ResultSink resultSink = ResultSink.this;
                            id = resultSink.leftId;
                            resultSink.leftId = id + 1;
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            ResultSink.this.leftMap().put(Integer.valueOf(id), args);
                            int highRightId = ResultSink.this.rightId;
                            try {
                                Observable<TLeftDuration> duration = (Observable) OnSubscribeJoin.this.leftDurationSelector.call(args);
                                try {
                                    Subscriber<TLeftDuration> d1 = new LeftDurationSubscriber(id);
                                    ResultSink.this.group.add(d1);
                                    duration.unsafeSubscribe(d1);
                                    List<TRight> rightValues = new ArrayList<>();
                                    synchronized (ResultSink.this) {
                                        for (Map.Entry<Integer, TRight> entry : ResultSink.this.rightMap.entrySet()) {
                                            if (entry.getKey().intValue() < highRightId) {
                                                rightValues.add(entry.getValue());
                                            }
                                        }
                                    }
                                    for (TRight r : rightValues) {
                                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.resultSelector.call(args, r));
                                    }
                                } catch (Throwable th2) {
                                    t = th2;
                                    Exceptions.throwOrReport(t, this);
                                }
                            } catch (Throwable th3) {
                                t = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
            }

            public void onError(Throwable e) {
                ResultSink.this.subscriber.onError(e);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void onCompleted() {
                boolean complete = false;
                synchronized (ResultSink.this) {
                    ResultSink.this.leftDone = true;
                    complete = (ResultSink.this.rightDone || ResultSink.this.leftMap().isEmpty()) ? true : true;
                }
                if (complete) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.remove(this);
            }

            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            final class LeftDurationSubscriber extends Subscriber<TLeftDuration> {
                final int id;
                boolean once = true;

                public LeftDurationSubscriber(int id) {
                    this.id = id;
                }

                public void onNext(TLeftDuration args) {
                    onCompleted();
                }

                public void onError(Throwable e) {
                    LeftSubscriber.this.onError(e);
                }

                public void onCompleted() {
                    if (this.once) {
                        this.once = false;
                        LeftSubscriber.this.expire(this.id, this);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public final class RightSubscriber extends Subscriber<TRight> {
            RightSubscriber() {
            }

            void expire(int id, Subscription resource) {
                boolean complete = false;
                synchronized (ResultSink.this) {
                    if (ResultSink.this.rightMap.remove(Integer.valueOf(id)) != null && ResultSink.this.rightMap.isEmpty() && ResultSink.this.rightDone) {
                        complete = true;
                    }
                }
                if (complete) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.remove(resource);
            }

            public void onNext(TRight args) {
                Observable<TRightDuration> duration;
                synchronized (ResultSink.this) {
                    try {
                        try {
                            ResultSink resultSink = ResultSink.this;
                            int id = resultSink.rightId;
                            resultSink.rightId = id + 1;
                            try {
                                ResultSink.this.rightMap.put(Integer.valueOf(id), args);
                                int highLeftId = ResultSink.this.leftId;
                                SerialSubscription md = new SerialSubscription();
                                ResultSink.this.group.add(md);
                                try {
                                    duration = (Observable) OnSubscribeJoin.this.rightDurationSelector.call(args);
                                } catch (Throwable th) {
                                    t = th;
                                }
                                try {
                                    Subscriber<TRightDuration> d2 = new RightDurationSubscriber(id);
                                    ResultSink.this.group.add(d2);
                                    duration.unsafeSubscribe(d2);
                                    List<TLeft> leftValues = new ArrayList<>();
                                    synchronized (ResultSink.this) {
                                        for (Map.Entry<Integer, TLeft> entry : ResultSink.this.leftMap().entrySet()) {
                                            if (entry.getKey().intValue() < highLeftId) {
                                                leftValues.add(entry.getValue());
                                            }
                                        }
                                    }
                                    for (TLeft lv : leftValues) {
                                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.resultSelector.call(lv, args));
                                    }
                                } catch (Throwable th2) {
                                    t = th2;
                                    Exceptions.throwOrReport(t, this);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
            }

            public void onError(Throwable e) {
                ResultSink.this.subscriber.onError(e);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void onCompleted() {
                boolean complete = false;
                synchronized (ResultSink.this) {
                    ResultSink.this.rightDone = true;
                    complete = (ResultSink.this.leftDone || ResultSink.this.rightMap.isEmpty()) ? true : true;
                }
                if (complete) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.remove(this);
            }

            /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
            final class RightDurationSubscriber extends Subscriber<TRightDuration> {
                final int id;
                boolean once = true;

                public RightDurationSubscriber(int id) {
                    this.id = id;
                }

                public void onNext(TRightDuration args) {
                    onCompleted();
                }

                public void onError(Throwable e) {
                    RightSubscriber.this.onError(e);
                }

                public void onCompleted() {
                    if (this.once) {
                        this.once = false;
                        RightSubscriber.this.expire(this.id, this);
                    }
                }
            }
        }
    }
}