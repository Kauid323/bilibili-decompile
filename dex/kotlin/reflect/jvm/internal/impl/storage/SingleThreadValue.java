package kotlin.reflect.jvm.internal.impl.storage;

/* JADX INFO: Access modifiers changed from: package-private */
public class SingleThreadValue<T> {
    private final Thread thread = Thread.currentThread();
    private final T value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleThreadValue(T value) {
        this.value = value;
    }

    public boolean hasValue() {
        return this.thread == Thread.currentThread();
    }

    public T getValue() {
        if (!hasValue()) {
            throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
        }
        return this.value;
    }
}