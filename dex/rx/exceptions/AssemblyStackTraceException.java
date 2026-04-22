package rx.exceptions;

import java.util.HashSet;
import java.util.Set;
import rx.plugins.RxJavaHooks;

public final class AssemblyStackTraceException extends RuntimeException {
    private static final long serialVersionUID = 2038859767182585852L;

    public AssemblyStackTraceException(String message) {
        super(message);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    public void attachTo(Throwable exception) {
        Set<Throwable> memory = new HashSet<>();
        while (exception.getCause() != null) {
            exception = exception.getCause();
            if (!memory.add(exception)) {
                RxJavaHooks.onError(this);
                return;
            }
        }
        try {
            exception.initCause(this);
        } catch (IllegalStateException e) {
            RxJavaHooks.onError(new RuntimeException("Received an exception with a cause set to null, instead of being unset. To fix this, look down the chain of causes. The last exception had a cause explicitly set to null. It should be unset instead.", exception));
        }
    }

    public static AssemblyStackTraceException find(Throwable e) {
        Set<Throwable> memory = new HashSet<>();
        while (!(e instanceof AssemblyStackTraceException)) {
            if (e == null || e.getCause() == null) {
                return null;
            }
            e = e.getCause();
            if (!memory.add(e)) {
                return null;
            }
        }
        return (AssemblyStackTraceException) e;
    }
}