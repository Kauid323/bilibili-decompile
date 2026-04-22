package io.reactivex.rxjava3.internal.util;

import androidx.compose.animation.core.MutatorMutex$;
import io.reactivex.rxjava3.exceptions.CompositeException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ExceptionHelper {
    public static final Throwable TERMINATED = new Termination();

    private ExceptionHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static RuntimeException wrapOrThrow(Throwable error) {
        if (error instanceof Error) {
            throw ((Error) error);
        }
        if (error instanceof RuntimeException) {
            return (RuntimeException) error;
        }
        return new RuntimeException(error);
    }

    public static boolean addThrowable(AtomicReference<Throwable> field, Throwable exception) {
        Throwable current;
        Throwable update;
        do {
            current = field.get();
            if (current == TERMINATED) {
                return false;
            }
            if (current == null) {
                update = exception;
            } else {
                update = new CompositeException(current, exception);
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(field, current, update));
        return true;
    }

    public static Throwable terminate(AtomicReference<Throwable> field) {
        Throwable current = field.get();
        if (current != TERMINATED) {
            return field.getAndSet(TERMINATED);
        }
        return current;
    }

    public static List<Throwable> flatten(Throwable t) {
        List<Throwable> list = new ArrayList<>();
        ArrayDeque<Throwable> deque = new ArrayDeque<>();
        deque.offer(t);
        while (!deque.isEmpty()) {
            Throwable e = deque.removeFirst();
            if (e instanceof CompositeException) {
                CompositeException ce = (CompositeException) e;
                List<Throwable> exceptions = ce.getExceptions();
                for (int i = exceptions.size() - 1; i >= 0; i--) {
                    deque.offerFirst(exceptions.get(i));
                }
            } else {
                list.add(e);
            }
        }
        return list;
    }

    public static <E extends Throwable> Exception throwIfThrowable(Throwable e) throws Throwable {
        if (e instanceof Exception) {
            return (Exception) e;
        }
        throw e;
    }

    public static String timeoutMessage(long timeout, TimeUnit unit) {
        return "The source did not signal an event for " + timeout + " " + unit.toString().toLowerCase() + " and has been terminated.";
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        Termination() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static String nullWarning(String prefix) {
        return prefix + " Null values are generally not allowed in 3.x operators and sources.";
    }

    public static NullPointerException createNullPointerException(String prefix) {
        return new NullPointerException(nullWarning(prefix));
    }

    public static <T> T nullCheck(T value, String prefix) {
        if (value == null) {
            throw createNullPointerException(prefix);
        }
        return value;
    }
}