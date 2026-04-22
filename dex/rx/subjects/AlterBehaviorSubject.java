package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;

public final class AlterBehaviorSubject<T> extends Subject<T, T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    private AtomicBoolean emitting;
    private List<Object> pendingNextValues;
    private final SubjectSubscriptionManager<T> state;

    public static <T> AlterBehaviorSubject<T> create() {
        return create(null, false);
    }

    public static <T> AlterBehaviorSubject<T> create(T defaultValue) {
        return create(defaultValue, true);
    }

    private static <T> AlterBehaviorSubject<T> create(T defaultValue, boolean hasDefault) {
        final SubjectSubscriptionManager<T> state = new SubjectSubscriptionManager<>();
        if (hasDefault) {
            state.setLatest(NotificationLite.next(defaultValue));
        }
        state.onAdded = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() { // from class: rx.subjects.AlterBehaviorSubject.1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((SubjectSubscriptionManager.SubjectObserver) ((SubjectSubscriptionManager.SubjectObserver) obj));
            }

            public void call(SubjectSubscriptionManager.SubjectObserver<T> o) {
                o.emitFirst(SubjectSubscriptionManager.this.getLatest());
            }
        };
        state.onTerminated = state.onAdded;
        return new AlterBehaviorSubject<>(state, state);
    }

    protected AlterBehaviorSubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> state) {
        super(onSubscribe);
        this.emitting = new AtomicBoolean(false);
        this.pendingNextValues = new ArrayList();
        this.state = state;
    }

    public void onCompleted() {
        SubjectSubscriptionManager.SubjectObserver<T>[] terminate;
        Object last = this.state.getLatest();
        if (last == null || this.state.active) {
            Object n = NotificationLite.completed();
            for (SubjectSubscriptionManager.SubjectObserver<T> bo : this.state.terminate(n)) {
                bo.emitNext(n);
            }
        }
    }

    public void onError(Throwable e) {
        SubjectSubscriptionManager.SubjectObserver<T>[] terminate;
        Object last = this.state.getLatest();
        if (last == null || this.state.active) {
            Object n = NotificationLite.error(e);
            List<Throwable> errors = null;
            for (SubjectSubscriptionManager.SubjectObserver<T> bo : this.state.terminate(n)) {
                try {
                    bo.emitNext(n);
                } catch (Throwable e2) {
                    if (errors == null) {
                        errors = new ArrayList<>();
                    }
                    errors.add(e2);
                }
            }
            Exceptions.throwIfAny(errors);
        }
    }

    public void onNext(T v) {
        if (this.emitting.compareAndSet(false, true)) {
            Object last = this.state.getLatest();
            if (last == null || this.state.active) {
                Object n = NotificationLite.next(v);
                emit(Collections.singletonList(n));
            }
            this.emitting.set(false);
            return;
        }
        synchronized (this) {
            this.pendingNextValues.add(NotificationLite.next(v));
        }
    }

    private void emit(List<Object> values) {
        if (values == null || values.isEmpty()) {
            return;
        }
        for (Object pendingNextValue : values) {
            SubjectSubscriptionManager.SubjectObserver<T>[] next = this.state.next(pendingNextValue);
            for (SubjectSubscriptionManager.SubjectObserver<T> bo : next) {
                bo.emitNext(pendingNextValue);
            }
        }
        ArrayList<Object> newList = null;
        synchronized (this) {
            if (!this.pendingNextValues.isEmpty()) {
                newList = new ArrayList<>(this.pendingNextValues);
                this.pendingNextValues.clear();
            }
        }
        emit(newList);
    }

    int subscriberCount() {
        return this.state.observers().length;
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.state.observers().length > 0;
    }

    public boolean hasValue() {
        Object o = this.state.getLatest();
        return NotificationLite.isNext(o);
    }

    public boolean hasThrowable() {
        Object o = this.state.getLatest();
        return NotificationLite.isError(o);
    }

    public boolean hasCompleted() {
        Object o = this.state.getLatest();
        return NotificationLite.isCompleted(o);
    }

    public T getValue() {
        Object o = this.state.getLatest();
        if (NotificationLite.isNext(o)) {
            return (T) NotificationLite.getValue(o);
        }
        return null;
    }

    public Throwable getThrowable() {
        Object o = this.state.getLatest();
        if (NotificationLite.isError(o)) {
            return NotificationLite.getError(o);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] getValues(T[] a) {
        Object o = this.state.getLatest();
        if (NotificationLite.isNext(o)) {
            if (a.length == 0) {
                a = (T[]) ((Object[]) Array.newInstance(a.getClass().getComponentType(), 1));
            }
            a[0] = NotificationLite.getValue(o);
            if (a.length > 1) {
                a[1] = null;
            }
        } else if (a.length > 0) {
            a[0] = null;
        }
        return a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        T[] r = getValues(EMPTY_ARRAY);
        if (r == EMPTY_ARRAY) {
            return new Object[0];
        }
        return r;
    }
}