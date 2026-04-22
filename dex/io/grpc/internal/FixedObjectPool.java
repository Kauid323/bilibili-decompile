package io.grpc.internal;

import com.google.common.base.Preconditions;

public final class FixedObjectPool<T> implements ObjectPool<T> {
    private final T object;

    public FixedObjectPool(T object) {
        this.object = (T) Preconditions.checkNotNull(object, "object");
    }

    @Override // io.grpc.internal.ObjectPool
    public T getObject() {
        return this.object;
    }

    @Override // io.grpc.internal.ObjectPool
    public T returnObject(Object returned) {
        return null;
    }
}