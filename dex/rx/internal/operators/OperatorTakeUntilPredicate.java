package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

public final class OperatorTakeUntilPredicate<T> implements Observable.Operator<T, T> {
    final Func1<? super T, Boolean> stopPredicate;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorTakeUntilPredicate(Func1<? super T, Boolean> stopPredicate) {
        this.stopPredicate = stopPredicate;
    }

    public Subscriber<? super T> call(Subscriber<? super T> child) {
        final OperatorTakeUntilPredicate<T>.ParentSubscriber parent = new ParentSubscriber(child);
        child.add(parent);
        child.setProducer(new Producer() { // from class: rx.internal.operators.OperatorTakeUntilPredicate.1
            public void request(long n) {
                parent.downstreamRequest(n);
            }
        });
        return parent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final class ParentSubscriber extends Subscriber<T> {
        private final Subscriber<? super T> child;
        private boolean done;

        ParentSubscriber(Subscriber<? super T> child) {
            this.child = child;
        }

        public void onNext(T t) {
            this.child.onNext(t);
            try {
                boolean stop = ((Boolean) OperatorTakeUntilPredicate.this.stopPredicate.call(t)).booleanValue();
                if (stop) {
                    this.done = true;
                    this.child.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable e) {
                this.done = true;
                Exceptions.throwOrReport(e, this.child, t);
                unsubscribe();
            }
        }

        public void onCompleted() {
            if (!this.done) {
                this.child.onCompleted();
            }
        }

        public void onError(Throwable e) {
            if (!this.done) {
                this.child.onError(e);
            }
        }

        void downstreamRequest(long n) {
            request(n);
        }
    }
}