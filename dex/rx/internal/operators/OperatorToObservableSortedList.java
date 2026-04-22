package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.internal.operators.OnSubscribeCreate;
import rx.internal.producers.SingleDelayedProducer;

public final class OperatorToObservableSortedList<T> implements Observable.Operator<List<T>, T> {
    private static final Comparator DEFAULT_SORT_FUNCTION = new DefaultComparableFunction();
    final int initialCapacity;
    final Comparator<? super T> sortFunction;

    public /* bridge */ /* synthetic */ Object call(Object x0) {
        return call((Subscriber) ((Subscriber) x0));
    }

    public OperatorToObservableSortedList(int initialCapacity) {
        this.sortFunction = DEFAULT_SORT_FUNCTION;
        this.initialCapacity = initialCapacity;
    }

    public OperatorToObservableSortedList(final Func2<? super T, ? super T, Integer> sortFunction, int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.sortFunction = (Comparator<T>) new Comparator<T>() { // from class: rx.internal.operators.OperatorToObservableSortedList.1
            @Override // java.util.Comparator
            public int compare(T o1, T o2) {
                return ((Integer) sortFunction.call(o1, o2)).intValue();
            }
        };
    }

    public Subscriber<? super T> call(final Subscriber<? super List<T>> child) {
        final SingleDelayedProducer<List<T>> producer = new SingleDelayedProducer<>(child);
        OnSubscribeCreate.NoneEmitter noneEmitter = (Subscriber<T>) new Subscriber<T>() { // from class: rx.internal.operators.OperatorToObservableSortedList.2
            boolean completed;
            List<T> list;

            {
                this.list = new ArrayList(OperatorToObservableSortedList.this.initialCapacity);
            }

            public void onStart() {
                request(Long.MAX_VALUE);
            }

            public void onCompleted() {
                if (!this.completed) {
                    this.completed = true;
                    List<T> a = this.list;
                    this.list = null;
                    try {
                        Collections.sort(a, OperatorToObservableSortedList.this.sortFunction);
                        producer.setValue(a);
                    } catch (Throwable e) {
                        Exceptions.throwOrReport(e, this);
                    }
                }
            }

            public void onError(Throwable e) {
                child.onError(e);
            }

            public void onNext(T value) {
                if (!this.completed) {
                    this.list.add(value);
                }
            }
        };
        child.add(noneEmitter);
        child.setProducer(producer);
        return noneEmitter;
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class DefaultComparableFunction implements Comparator<Object> {
        DefaultComparableFunction() {
        }

        @Override // java.util.Comparator
        public int compare(Object t1, Object t2) {
            Comparable<Object> c1 = (Comparable) t1;
            Comparable<Object> c2 = (Comparable) t2;
            return c1.compareTo(c2);
        }
    }
}