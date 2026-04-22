package io.grpc;

import io.grpc.PersistentHashArrayMappedTrie;
import io.ktor.http.ContentDisposition;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Context {
    static final int CONTEXT_DEPTH_WARN_THRESH = 1000;
    final CancellableContext cancellableAncestor;
    final int generation;
    final PersistentHashArrayMappedTrie.Node<Key<?>, Object> keyValueEntries;
    static final Logger log = Logger.getLogger(Context.class.getName());
    public static final Context ROOT = new Context();

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    @interface CanIgnoreReturnValue {
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public interface CancellationListener {
        void cancelled(Context context);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    @interface CheckReturnValue {
    }

    static Storage storage() {
        return LazyStorage.storage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class LazyStorage {
        static final Storage storage;

        private LazyStorage() {
        }

        static {
            AtomicReference<Throwable> deferredStorageFailure = new AtomicReference<>();
            storage = createStorage(deferredStorageFailure);
            Throwable failure = deferredStorageFailure.get();
            if (failure != null) {
                Context.log.log(Level.FINE, "Storage override doesn't exist. Using default", failure);
            }
        }

        private static Storage createStorage(AtomicReference<? super ClassNotFoundException> deferredStorageFailure) {
            try {
                Class<?> clazz = Class.forName("io.grpc.override.ContextStorageOverride");
                return (Storage) clazz.asSubclass(Storage.class).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e2) {
                deferredStorageFailure.set(e2);
                return new ThreadLocalContextStorage();
            } catch (Exception e3) {
                throw new RuntimeException("Storage override failed to initialize", e3);
            }
        }
    }

    public static <T> Key<T> key(String debugString) {
        return new Key<>(debugString);
    }

    public static <T> Key<T> keyWithDefault(String debugString, T defaultValue) {
        return new Key<>(debugString, defaultValue);
    }

    public static Context current() {
        Context current = storage().current();
        if (current == null) {
            return ROOT;
        }
        return current;
    }

    private Context(PersistentHashArrayMappedTrie.Node<Key<?>, Object> keyValueEntries, int generation) {
        this.cancellableAncestor = null;
        this.keyValueEntries = keyValueEntries;
        this.generation = generation;
        validateGeneration(generation);
    }

    private Context(Context parent, PersistentHashArrayMappedTrie.Node<Key<?>, Object> keyValueEntries) {
        this.cancellableAncestor = cancellableAncestor(parent);
        this.keyValueEntries = keyValueEntries;
        this.generation = parent.generation + 1;
        validateGeneration(this.generation);
    }

    private Context() {
        this.cancellableAncestor = null;
        this.keyValueEntries = null;
        this.generation = 0;
        validateGeneration(this.generation);
    }

    public CancellableContext withCancellation() {
        return new CancellableContext();
    }

    public CancellableContext withDeadlineAfter(long duration, TimeUnit unit, ScheduledExecutorService scheduler) {
        return withDeadline(Deadline.after(duration, unit), scheduler);
    }

    public CancellableContext withDeadline(Deadline newDeadline, ScheduledExecutorService scheduler) {
        checkNotNull(newDeadline, "deadline");
        checkNotNull(scheduler, "scheduler");
        Deadline existingDeadline = getDeadline();
        boolean scheduleDeadlineCancellation = true;
        if (existingDeadline != null && existingDeadline.compareTo(newDeadline) <= 0) {
            newDeadline = existingDeadline;
            scheduleDeadlineCancellation = false;
        }
        CancellableContext newCtx = new CancellableContext(newDeadline);
        if (scheduleDeadlineCancellation) {
            newCtx.setUpDeadlineCancellation(newDeadline, scheduler);
        }
        return newCtx;
    }

    public <V> Context withValue(Key<V> k1, V v1) {
        PersistentHashArrayMappedTrie.Node<Key<?>, Object> newKeyValueEntries = PersistentHashArrayMappedTrie.put(this.keyValueEntries, k1, v1);
        return new Context(this, newKeyValueEntries);
    }

    public <V1, V2> Context withValues(Key<V1> k1, V1 v1, Key<V2> k2, V2 v2) {
        PersistentHashArrayMappedTrie.Node<Key<?>, Object> newKeyValueEntries = PersistentHashArrayMappedTrie.put(this.keyValueEntries, k1, v1);
        return new Context(this, PersistentHashArrayMappedTrie.put(newKeyValueEntries, k2, v2));
    }

    public <V1, V2, V3> Context withValues(Key<V1> k1, V1 v1, Key<V2> k2, V2 v2, Key<V3> k3, V3 v3) {
        PersistentHashArrayMappedTrie.Node<Key<?>, Object> newKeyValueEntries = PersistentHashArrayMappedTrie.put(this.keyValueEntries, k1, v1);
        return new Context(this, PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(newKeyValueEntries, k2, v2), k3, v3));
    }

    public <V1, V2, V3, V4> Context withValues(Key<V1> k1, V1 v1, Key<V2> k2, V2 v2, Key<V3> k3, V3 v3, Key<V4> k4, V4 v4) {
        PersistentHashArrayMappedTrie.Node<Key<?>, Object> newKeyValueEntries = PersistentHashArrayMappedTrie.put(this.keyValueEntries, k1, v1);
        return new Context(this, PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(newKeyValueEntries, k2, v2), k3, v3), k4, v4));
    }

    public Context fork() {
        return new Context(this.keyValueEntries, this.generation + 1);
    }

    public Context attach() {
        Context prev = storage().doAttach(this);
        if (prev == null) {
            return ROOT;
        }
        return prev;
    }

    public void detach(Context toAttach) {
        checkNotNull(toAttach, "toAttach");
        storage().detach(this, toAttach);
    }

    boolean isCurrent() {
        return current() == this;
    }

    public boolean isCancelled() {
        if (this.cancellableAncestor == null) {
            return false;
        }
        return this.cancellableAncestor.isCancelled();
    }

    public Throwable cancellationCause() {
        if (this.cancellableAncestor == null) {
            return null;
        }
        return this.cancellableAncestor.cancellationCause();
    }

    public Deadline getDeadline() {
        if (this.cancellableAncestor == null) {
            return null;
        }
        return this.cancellableAncestor.getDeadline();
    }

    public void addListener(CancellationListener cancellationListener, Executor executor) {
        checkNotNull(cancellationListener, "cancellationListener");
        checkNotNull(executor, "executor");
        if (this.cancellableAncestor == null) {
            return;
        }
        this.cancellableAncestor.addListenerInternal(new ExecutableListener(executor, cancellationListener, this));
    }

    public void removeListener(CancellationListener cancellationListener) {
        if (this.cancellableAncestor == null) {
            return;
        }
        this.cancellableAncestor.removeListenerInternal(cancellationListener, this);
    }

    int listenerCount() {
        if (this.cancellableAncestor == null) {
            return 0;
        }
        return this.cancellableAncestor.listenerCount();
    }

    public void run(Runnable r) {
        Context previous = attach();
        try {
            r.run();
        } finally {
            detach(previous);
        }
    }

    public <V> V call(Callable<V> c) throws Exception {
        Context previous = attach();
        try {
            return c.call();
        } finally {
            detach(previous);
        }
    }

    public Runnable wrap(final Runnable r) {
        return new Runnable() { // from class: io.grpc.Context.1
            @Override // java.lang.Runnable
            public void run() {
                Context previous = Context.this.attach();
                try {
                    r.run();
                } finally {
                    Context.this.detach(previous);
                }
            }
        };
    }

    public <C> Callable<C> wrap(final Callable<C> c) {
        return new Callable<C>() { // from class: io.grpc.Context.2
            @Override // java.util.concurrent.Callable
            public C call() throws Exception {
                Context previous = Context.this.attach();
                try {
                    return (C) c.call();
                } finally {
                    Context.this.detach(previous);
                }
            }
        };
    }

    public Executor fixedContextExecutor(final Executor e2) {
        return new Executor() { // from class: io.grpc.Context.1FixedContextExecutor
            @Override // java.util.concurrent.Executor
            public void execute(Runnable r) {
                e2.execute(Context.this.wrap(r));
            }
        };
    }

    public static Executor currentContextExecutor(final Executor e2) {
        return new Executor() { // from class: io.grpc.Context.1CurrentContextExecutor
            @Override // java.util.concurrent.Executor
            public void execute(Runnable r) {
                e2.execute(Context.current().wrap(r));
            }
        };
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class CancellableContext extends Context implements Closeable {
        private Throwable cancellationCause;
        private boolean cancelled;
        private final Deadline deadline;
        private ArrayList<ExecutableListener> listeners;
        private CancellationListener parentListener;
        private ScheduledFuture<?> pendingDeadline;
        private final Context uncancellableSurrogate;

        private CancellableContext(Context parent) {
            super(parent.keyValueEntries);
            this.deadline = parent.getDeadline();
            this.uncancellableSurrogate = new Context(this.keyValueEntries);
        }

        private CancellableContext(Context parent, Deadline deadline) {
            super(parent.keyValueEntries);
            this.deadline = deadline;
            this.uncancellableSurrogate = new Context(this.keyValueEntries);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpDeadlineCancellation(Deadline deadline, ScheduledExecutorService scheduler) {
            if (!deadline.isExpired()) {
                synchronized (this) {
                    this.pendingDeadline = deadline.runOnExpiration(new Runnable() { // from class: io.grpc.Context.CancellableContext.1CancelOnExpiration
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                CancellableContext.this.cancel(new TimeoutException("context timed out"));
                            } catch (Throwable t) {
                                Context.log.log(Level.SEVERE, "Cancel threw an exception, which should not happen", t);
                            }
                        }
                    }, scheduler);
                }
                return;
            }
            cancel(new TimeoutException("context timed out"));
        }

        @Override // io.grpc.Context
        public Context attach() {
            return this.uncancellableSurrogate.attach();
        }

        @Override // io.grpc.Context
        public void detach(Context toAttach) {
            this.uncancellableSurrogate.detach(toAttach);
        }

        @Override // io.grpc.Context
        public void addListener(CancellationListener cancellationListener, Executor executor) {
            checkNotNull(cancellationListener, "cancellationListener");
            checkNotNull(executor, "executor");
            addListenerInternal(new ExecutableListener(executor, cancellationListener, this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addListenerInternal(ExecutableListener executableListener) {
            synchronized (this) {
                if (isCancelled()) {
                    executableListener.deliver();
                } else if (this.listeners == null) {
                    this.listeners = new ArrayList<>();
                    this.listeners.add(executableListener);
                    if (this.cancellableAncestor != null) {
                        this.parentListener = new CancellationListener() { // from class: io.grpc.Context.CancellableContext.1
                            @Override // io.grpc.Context.CancellationListener
                            public void cancelled(Context context) {
                                CancellableContext.this.cancel(context.cancellationCause());
                            }
                        };
                        this.cancellableAncestor.addListenerInternal(new ExecutableListener(DirectExecutor.INSTANCE, this.parentListener, this));
                    }
                } else {
                    this.listeners.add(executableListener);
                }
            }
        }

        @Override // io.grpc.Context
        public void removeListener(CancellationListener cancellationListener) {
            removeListenerInternal(cancellationListener, this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeListenerInternal(CancellationListener cancellationListener, Context context) {
            synchronized (this) {
                if (this.listeners != null) {
                    int i2 = this.listeners.size() - 1;
                    while (true) {
                        if (i2 < 0) {
                            break;
                        }
                        ExecutableListener executableListener = this.listeners.get(i2);
                        if (executableListener.listener != cancellationListener || executableListener.context != context) {
                            i2--;
                        } else {
                            this.listeners.remove(i2);
                            break;
                        }
                    }
                    if (this.listeners.isEmpty()) {
                        if (this.cancellableAncestor != null) {
                            this.cancellableAncestor.removeListener(this.parentListener);
                        }
                        this.parentListener = null;
                        this.listeners = null;
                    }
                }
            }
        }

        @Override // io.grpc.Context
        @Deprecated
        public boolean isCurrent() {
            return this.uncancellableSurrogate.isCurrent();
        }

        public boolean cancel(Throwable cause) {
            boolean triggeredCancel = false;
            synchronized (this) {
                if (!this.cancelled) {
                    this.cancelled = true;
                    if (this.pendingDeadline != null) {
                        this.pendingDeadline.cancel(false);
                        this.pendingDeadline = null;
                    }
                    this.cancellationCause = cause;
                    triggeredCancel = true;
                }
            }
            if (triggeredCancel) {
                notifyAndClearListeners();
            }
            return triggeredCancel;
        }

        private void notifyAndClearListeners() {
            synchronized (this) {
                if (this.listeners == null) {
                    return;
                }
                CancellationListener tmpParentListener = this.parentListener;
                this.parentListener = null;
                ArrayList<ExecutableListener> tmpListeners = this.listeners;
                this.listeners = null;
                Iterator<ExecutableListener> it = tmpListeners.iterator();
                while (it.hasNext()) {
                    ExecutableListener tmpListener = it.next();
                    if (tmpListener.context == this) {
                        tmpListener.deliver();
                    }
                }
                Iterator<ExecutableListener> it2 = tmpListeners.iterator();
                while (it2.hasNext()) {
                    ExecutableListener tmpListener2 = it2.next();
                    if (tmpListener2.context != this) {
                        tmpListener2.deliver();
                    }
                }
                if (this.cancellableAncestor != null) {
                    this.cancellableAncestor.removeListener(tmpParentListener);
                }
            }
        }

        @Override // io.grpc.Context
        int listenerCount() {
            int size;
            synchronized (this) {
                size = this.listeners == null ? 0 : this.listeners.size();
            }
            return size;
        }

        public void detachAndCancel(Context toAttach, Throwable cause) {
            try {
                detach(toAttach);
            } finally {
                cancel(cause);
            }
        }

        @Override // io.grpc.Context
        public boolean isCancelled() {
            synchronized (this) {
                if (this.cancelled) {
                    return true;
                }
                if (super.isCancelled()) {
                    cancel(super.cancellationCause());
                    return true;
                }
                return false;
            }
        }

        @Override // io.grpc.Context
        public Throwable cancellationCause() {
            if (isCancelled()) {
                return this.cancellationCause;
            }
            return null;
        }

        @Override // io.grpc.Context
        public Deadline getDeadline() {
            return this.deadline;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            cancel(null);
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Key<T> {
        private final T defaultValue;
        private final String name;

        Key(String name) {
            this(name, null);
        }

        Key(String name, T defaultValue) {
            this.name = (String) Context.checkNotNull(name, ContentDisposition.Parameters.Name);
            this.defaultValue = defaultValue;
        }

        public T get() {
            return get(Context.current());
        }

        public T get(Context context) {
            T value = (T) PersistentHashArrayMappedTrie.get(context.keyValueEntries, this);
            return value == null ? this.defaultValue : value;
        }

        public String toString() {
            return this.name;
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static abstract class Storage {
        public abstract Context current();

        public abstract void detach(Context context, Context context2);

        @Deprecated
        public void attach(Context toAttach) {
            throw new UnsupportedOperationException("Deprecated. Do not call.");
        }

        public Context doAttach(Context toAttach) {
            Context current = current();
            attach(toAttach);
            return current;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ExecutableListener implements Runnable {
        private final Context context;
        private final Executor executor;
        final CancellationListener listener;

        ExecutableListener(Executor executor, CancellationListener listener, Context context) {
            this.executor = executor;
            this.listener = listener;
            this.context = context;
        }

        void deliver() {
            try {
                this.executor.execute(this);
            } catch (Throwable t) {
                Context.log.log(Level.INFO, "Exception notifying context listener", t);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.listener.cancelled(this.context);
        }
    }

    static <T> T checkNotNull(T reference, Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }
        return reference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public enum DirectExecutor implements Executor {
        INSTANCE;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            command.run();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Context.DirectExecutor";
        }
    }

    static CancellableContext cancellableAncestor(Context parent) {
        if (parent instanceof CancellableContext) {
            return (CancellableContext) parent;
        }
        return parent.cancellableAncestor;
    }

    private static void validateGeneration(int generation) {
        if (generation == 1000) {
            log.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }
}