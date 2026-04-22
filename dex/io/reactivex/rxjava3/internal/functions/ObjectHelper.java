package io.reactivex.rxjava3.internal.functions;

import io.reactivex.rxjava3.functions.BiPredicate;
import j$.util.Objects;

public final class ObjectHelper {
    static final BiPredicate<Object, Object> EQUALS = new BiObjectPredicate();

    private ObjectHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> BiPredicate<T, T> equalsPredicate() {
        return (BiPredicate<T, T>) EQUALS;
    }

    public static int verifyPositive(int value, String paramName) {
        if (value <= 0) {
            throw new IllegalArgumentException(paramName + " > 0 required but it was " + value);
        }
        return value;
    }

    public static long verifyPositive(long value, String paramName) {
        if (value <= 0) {
            throw new IllegalArgumentException(paramName + " > 0 required but it was " + value);
        }
        return value;
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class BiObjectPredicate implements BiPredicate<Object, Object> {
        BiObjectPredicate() {
        }

        @Override // io.reactivex.rxjava3.functions.BiPredicate
        public boolean test(Object o1, Object o2) {
            return Objects.equals(o1, o2);
        }
    }
}