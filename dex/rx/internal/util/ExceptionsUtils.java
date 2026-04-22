package rx.internal.util;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;

public enum ExceptionsUtils {
    ;
    
    private static final Throwable TERMINATED = new Throwable("Terminated");

    public static boolean addThrowable(AtomicReference<Throwable> field, Throwable error) {
        CompositeException compositeException;
        Throwable next;
        do {
            compositeException = (Throwable) field.get();
            if (compositeException == TERMINATED) {
                return false;
            }
            if (compositeException == null) {
                next = error;
            } else if (compositeException instanceof CompositeException) {
                List<Throwable> list = new ArrayList<>(compositeException.getExceptions());
                list.add(error);
                next = new CompositeException(list);
            } else {
                next = new CompositeException(new Throwable[]{compositeException, error});
            }
        } while (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(field, compositeException, next));
        return true;
    }

    public static Throwable terminate(AtomicReference<Throwable> field) {
        Throwable current = field.get();
        if (current != TERMINATED) {
            return field.getAndSet(TERMINATED);
        }
        return current;
    }

    public static boolean isTerminated(AtomicReference<Throwable> field) {
        return isTerminated(field.get());
    }

    public static boolean isTerminated(Throwable error) {
        return error == TERMINATED;
    }
}