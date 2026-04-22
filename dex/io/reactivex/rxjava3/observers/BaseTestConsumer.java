package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.VolatileSizeArrayList;
import io.reactivex.rxjava3.observers.BaseTestConsumer;
import j$.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> {
    protected boolean checkSubscriptionOnce;
    protected long completions;
    protected Thread lastThread;
    protected CharSequence tag;
    protected boolean timeout;
    protected final List<T> values = new VolatileSizeArrayList();
    protected final List<Throwable> errors = new VolatileSizeArrayList();
    protected final CountDownLatch done = new CountDownLatch(1);

    protected abstract U assertSubscribed();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void dispose();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isDisposed();

    public final List<T> values() {
        return this.values;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AssertionError fail(String message) {
        StringBuilder b = new StringBuilder(message.length() + 64);
        b.append(message);
        b.append(" (").append("latch = ").append(this.done.getCount()).append(", ").append("values = ").append(this.values.size()).append(", ").append("errors = ").append(this.errors.size()).append(", ").append("completions = ").append(this.completions);
        if (this.timeout) {
            b.append(", timeout!");
        }
        if (isDisposed()) {
            b.append(", disposed!");
        }
        CharSequence tag = this.tag;
        if (tag != null) {
            b.append(", tag = ").append(tag);
        }
        b.append(')');
        AssertionError ae = new AssertionError(b.toString());
        if (!this.errors.isEmpty()) {
            if (this.errors.size() == 1) {
                ae.initCause(this.errors.get(0));
            } else {
                CompositeException ce = new CompositeException(this.errors);
                ae.initCause(ce);
            }
        }
        return ae;
    }

    public final U await() throws InterruptedException {
        if (this.done.getCount() == 0) {
            return this;
        }
        this.done.await();
        return this;
    }

    public final boolean await(long time, TimeUnit unit) throws InterruptedException {
        boolean d = this.done.getCount() == 0 || this.done.await(time, unit);
        this.timeout = d ? false : true;
        return d;
    }

    public final U assertComplete() {
        long c = this.completions;
        if (c == 0) {
            throw fail("Not completed");
        }
        if (c > 1) {
            throw fail("Multiple completions: " + c);
        }
        return this;
    }

    public final U assertNotComplete() {
        long c = this.completions;
        if (c == 1) {
            throw fail("Completed!");
        }
        if (c > 1) {
            throw fail("Multiple completions: " + c);
        }
        return this;
    }

    public final U assertNoErrors() {
        int s = this.errors.size();
        if (s != 0) {
            throw fail("Error(s) present: " + this.errors);
        }
        return this;
    }

    public final U assertError(Throwable error) {
        return assertError(Functions.equalsWith(error));
    }

    public final U assertError(Class<? extends Throwable> errorClass) {
        return assertError(Functions.isInstanceOf(errorClass));
    }

    public final U assertError(Predicate<Throwable> errorPredicate) {
        int s = this.errors.size();
        if (s == 0) {
            throw fail("No errors");
        }
        boolean found = false;
        Iterator<Throwable> it = this.errors.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Throwable e = it.next();
            try {
                if (errorPredicate.test(e)) {
                    found = true;
                    break;
                }
            } catch (Throwable ex) {
                throw ExceptionHelper.wrapOrThrow(ex);
            }
        }
        if (found) {
            if (s != 1) {
                throw fail("Error present but other errors as well");
            }
            return this;
        }
        throw fail("Error not present");
    }

    public final U assertValue(T value) {
        int s = this.values.size();
        if (s != 1) {
            throw fail("expected: " + valueAndClass(value) + " but was: " + this.values);
        }
        T v = this.values.get(0);
        if (!Objects.equals(value, v)) {
            throw fail("expected: " + valueAndClass(value) + " but was: " + valueAndClass(v));
        }
        return this;
    }

    public final U assertValue(Predicate<T> valuePredicate) {
        assertValueAt(0, (Predicate) valuePredicate);
        if (this.values.size() > 1) {
            throw fail("Value present but other values as well");
        }
        return this;
    }

    public final U assertValueAt(int index, T value) {
        int s = this.values.size();
        if (s == 0) {
            throw fail("No values");
        }
        if (index >= s) {
            throw fail("Invalid index: " + index);
        }
        T v = this.values.get(index);
        if (!Objects.equals(value, v)) {
            throw fail("expected: " + valueAndClass(value) + " but was: " + valueAndClass(v));
        }
        return this;
    }

    public final U assertValueAt(int index, Predicate<T> valuePredicate) {
        int s = this.values.size();
        if (s == 0) {
            throw fail("No values");
        }
        if (index >= this.values.size()) {
            throw fail("Invalid index: " + index);
        }
        boolean found = false;
        try {
            if (valuePredicate.test(this.values.get(index))) {
                found = true;
            }
            if (!found) {
                throw fail("Value not present");
            }
            return this;
        } catch (Throwable ex) {
            throw ExceptionHelper.wrapOrThrow(ex);
        }
    }

    public static String valueAndClass(Object o) {
        if (o != null) {
            return o + " (class: " + o.getClass().getSimpleName() + ")";
        }
        return "null";
    }

    public final U assertValueCount(int count) {
        int s = this.values.size();
        if (s != count) {
            throw fail("Value counts differ; expected: " + count + " but was: " + s);
        }
        return this;
    }

    public final U assertNoValues() {
        return assertValueCount(0);
    }

    @SafeVarargs
    public final U assertValues(T... values) {
        int s = this.values.size();
        if (s != values.length) {
            throw fail("Value count differs; expected: " + values.length + " " + Arrays.toString(values) + " but was: " + s + " " + this.values);
        }
        for (int i = 0; i < s; i++) {
            T v = this.values.get(i);
            T u = values[i];
            if (!Objects.equals(u, v)) {
                throw fail("Values at position " + i + " differ; expected: " + valueAndClass(u) + " but was: " + valueAndClass(v));
            }
        }
        return this;
    }

    @SafeVarargs
    public final U assertValuesOnly(T... values) {
        return (U) assertSubscribed().assertValues(values).assertNoErrors().assertNotComplete();
    }

    public final U assertValueSequence(Iterable<? extends T> sequence) {
        boolean expectedNext;
        boolean actualNext;
        int i = 0;
        Iterator<T> actualIterator = this.values.iterator();
        Iterator<? extends T> expectedIterator = sequence.iterator();
        while (true) {
            expectedNext = expectedIterator.hasNext();
            actualNext = actualIterator.hasNext();
            if (!actualNext || !expectedNext) {
                break;
            }
            T u = expectedIterator.next();
            T v = actualIterator.next();
            if (!Objects.equals(u, v)) {
                throw fail("Values at position " + i + " differ; expected: " + valueAndClass(u) + " but was: " + valueAndClass(v));
            }
            i++;
        }
        if (actualNext) {
            throw fail("More values received than expected (" + i + ")");
        }
        if (expectedNext) {
            throw fail("Fewer values received than expected (" + i + ")");
        }
        return this;
    }

    @SafeVarargs
    public final U assertResult(T... values) {
        return (U) assertSubscribed().assertValues(values).assertNoErrors().assertComplete();
    }

    @SafeVarargs
    public final U assertFailure(Class<? extends Throwable> error, T... values) {
        return (U) assertSubscribed().assertValues(values).assertError(error).assertNotComplete();
    }

    public final U awaitDone(long time, TimeUnit unit) {
        try {
            if (!this.done.await(time, unit)) {
                this.timeout = true;
                dispose();
            }
            return this;
        } catch (InterruptedException ex) {
            dispose();
            throw ExceptionHelper.wrapOrThrow(ex);
        }
    }

    public final U assertEmpty() {
        return (U) assertSubscribed().assertNoValues().assertNoErrors().assertNotComplete();
    }

    public final U withTag(CharSequence tag) {
        this.tag = tag;
        return this;
    }

    public final U awaitCount(int atLeast) {
        long start = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() - start >= 5000) {
                this.timeout = true;
                break;
            } else if (this.done.getCount() == 0 || this.values.size() >= atLeast) {
                break;
            } else {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return this;
    }
}