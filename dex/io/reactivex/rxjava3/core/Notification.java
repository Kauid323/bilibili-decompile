package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.internal.util.NotificationLite;
import j$.util.Objects;

public final class Notification<T> {
    static final Notification<Object> COMPLETE = new Notification<>(null);
    final Object value;

    private Notification(Object value) {
        this.value = value;
    }

    public boolean isOnComplete() {
        return this.value == null;
    }

    public boolean isOnError() {
        return NotificationLite.isError(this.value);
    }

    public boolean isOnNext() {
        Object o = this.value;
        return (o == null || NotificationLite.isError(o)) ? false : true;
    }

    public T getValue() {
        Object o = this.value;
        if (o != null && !NotificationLite.isError(o)) {
            return (T) this.value;
        }
        return null;
    }

    public Throwable getError() {
        Object o = this.value;
        if (NotificationLite.isError(o)) {
            return NotificationLite.getError(o);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Notification) {
            Notification<?> n = (Notification) obj;
            return Objects.equals(this.value, n.value);
        }
        return false;
    }

    public int hashCode() {
        Object o = this.value;
        if (o != null) {
            return o.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object o = this.value;
        if (o == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(o)) {
            return "OnErrorNotification[" + NotificationLite.getError(o) + "]";
        }
        return "OnNextNotification[" + this.value + "]";
    }

    public static <T> Notification<T> createOnNext(T value) {
        Objects.requireNonNull(value, "value is null");
        return new Notification<>(value);
    }

    public static <T> Notification<T> createOnError(Throwable error) {
        Objects.requireNonNull(error, "error is null");
        return new Notification<>(NotificationLite.error(error));
    }

    public static <T> Notification<T> createOnComplete() {
        return (Notification<T>) COMPLETE;
    }
}