package io.grpc;

import io.grpc.Context;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
public final class ThreadLocalContextStorage extends Context.Storage {
    private static final Logger log = Logger.getLogger(ThreadLocalContextStorage.class.getName());
    static final ThreadLocal<Context> localContext = new ThreadLocal<>();

    @Override // io.grpc.Context.Storage
    public Context doAttach(Context toAttach) {
        Context current = current();
        localContext.set(toAttach);
        return current;
    }

    @Override // io.grpc.Context.Storage
    public void detach(Context toDetach, Context toRestore) {
        if (current() != toDetach) {
            log.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (toRestore != Context.ROOT) {
            localContext.set(toRestore);
        } else {
            localContext.set(null);
        }
    }

    @Override // io.grpc.Context.Storage
    public Context current() {
        Context current = localContext.get();
        if (current == null) {
            return Context.ROOT;
        }
        return current;
    }
}