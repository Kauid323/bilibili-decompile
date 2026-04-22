package rx.internal.observers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.AssertableSubscriber;
import rx.observers.TestSubscriber;

public class AssertableSubscriberObservable<T> extends Subscriber<T> implements AssertableSubscriber<T> {
    private final TestSubscriber<T> ts;

    public AssertableSubscriberObservable(TestSubscriber<T> ts) {
        this.ts = ts;
    }

    public static <T> AssertableSubscriberObservable<T> create(long initialRequest) {
        TestSubscriber<T> t1 = new TestSubscriber<>(initialRequest);
        AssertableSubscriberObservable<T> t2 = new AssertableSubscriberObservable<>(t1);
        t2.add(t1);
        return t2;
    }

    @Override // rx.Subscriber
    public void onStart() {
        this.ts.onStart();
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.ts.onCompleted();
    }

    @Override // rx.Subscriber
    public void setProducer(Producer p) {
        this.ts.setProducer(p);
    }

    public final int getCompletions() {
        return this.ts.getCompletions();
    }

    @Override // rx.Observer
    public void onError(Throwable e) {
        this.ts.onError(e);
    }

    public List<Throwable> getOnErrorEvents() {
        return this.ts.getOnErrorEvents();
    }

    @Override // rx.Observer
    public void onNext(T t) {
        this.ts.onNext(t);
    }

    public final int getValueCount() {
        return this.ts.getValueCount();
    }

    public AssertableSubscriber<T> requestMore(long n) {
        this.ts.requestMore(n);
        return this;
    }

    public List<T> getOnNextEvents() {
        return this.ts.getOnNextEvents();
    }

    public AssertableSubscriber<T> assertReceivedOnNext(List<T> items) {
        this.ts.assertReceivedOnNext(items);
        return this;
    }

    public final AssertableSubscriber<T> awaitValueCount(int expected, long timeout, TimeUnit unit) {
        if (!this.ts.awaitValueCount(expected, timeout, unit)) {
            throw new AssertionError("Did not receive enough values in time. Expected: " + expected + ", Actual: " + this.ts.getValueCount());
        }
        return this;
    }

    public AssertableSubscriber<T> assertTerminalEvent() {
        this.ts.assertTerminalEvent();
        return this;
    }

    public AssertableSubscriber<T> assertUnsubscribed() {
        this.ts.assertUnsubscribed();
        return this;
    }

    public AssertableSubscriber<T> assertNoErrors() {
        this.ts.assertNoErrors();
        return this;
    }

    public AssertableSubscriber<T> awaitTerminalEvent() {
        this.ts.awaitTerminalEvent();
        return this;
    }

    public AssertableSubscriber<T> awaitTerminalEvent(long timeout, TimeUnit unit) {
        this.ts.awaitTerminalEvent(timeout, unit);
        return this;
    }

    public AssertableSubscriber<T> awaitTerminalEventAndUnsubscribeOnTimeout(long timeout, TimeUnit unit) {
        this.ts.awaitTerminalEventAndUnsubscribeOnTimeout(timeout, unit);
        return this;
    }

    public Thread getLastSeenThread() {
        return this.ts.getLastSeenThread();
    }

    public AssertableSubscriber<T> assertCompleted() {
        this.ts.assertCompleted();
        return this;
    }

    public AssertableSubscriber<T> assertNotCompleted() {
        this.ts.assertNotCompleted();
        return this;
    }

    public AssertableSubscriber<T> assertError(Class<? extends Throwable> clazz) {
        this.ts.assertError(clazz);
        return this;
    }

    public AssertableSubscriber<T> assertError(Throwable throwable) {
        this.ts.assertError(throwable);
        return this;
    }

    public AssertableSubscriber<T> assertNoTerminalEvent() {
        this.ts.assertNoTerminalEvent();
        return this;
    }

    public AssertableSubscriber<T> assertNoValues() {
        this.ts.assertNoValues();
        return this;
    }

    public AssertableSubscriber<T> assertValueCount(int count) {
        this.ts.assertValueCount(count);
        return this;
    }

    public AssertableSubscriber<T> assertValues(T... values) {
        this.ts.assertValues(values);
        return this;
    }

    public AssertableSubscriber<T> assertValue(T value) {
        this.ts.assertValue(value);
        return this;
    }

    public final AssertableSubscriber<T> assertValuesAndClear(T expectedFirstValue, T... expectedRestValues) {
        this.ts.assertValuesAndClear(expectedFirstValue, expectedRestValues);
        return this;
    }

    public final AssertableSubscriber<T> perform(Action0 action) {
        action.call();
        return this;
    }

    public String toString() {
        return this.ts.toString();
    }

    public final AssertableSubscriber<T> assertResult(T... values) {
        this.ts.assertValues(values);
        this.ts.assertNoErrors();
        this.ts.assertCompleted();
        return this;
    }

    public final AssertableSubscriber<T> assertFailure(Class<? extends Throwable> errorClass, T... values) {
        this.ts.assertValues(values);
        this.ts.assertError(errorClass);
        this.ts.assertNotCompleted();
        return this;
    }

    public final AssertableSubscriber<T> assertFailureAndMessage(Class<? extends Throwable> errorClass, String message, T... values) {
        this.ts.assertValues(values);
        this.ts.assertError(errorClass);
        this.ts.assertNotCompleted();
        String actualMessage = ((Throwable) this.ts.getOnErrorEvents().get(0)).getMessage();
        if (actualMessage != message && (message == null || !message.equals(actualMessage))) {
            throw new AssertionError("Error message differs. Expected: '" + message + "', Received: '" + actualMessage + "'");
        }
        return this;
    }
}