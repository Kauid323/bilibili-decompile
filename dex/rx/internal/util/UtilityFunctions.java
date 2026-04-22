package rx.internal.util;

import rx.functions.Func1;

public final class UtilityFunctions {
    private UtilityFunctions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Func1<? super T, Boolean> alwaysTrue() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> Func1<? super T, Boolean> alwaysFalse() {
        return AlwaysFalse.INSTANCE;
    }

    public static <T> Func1<T, T> identity() {
        return Identity.INSTANCE;
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    enum AlwaysTrue implements Func1<Object, Boolean> {
        INSTANCE;

        /* renamed from: call */
        public Boolean m3000call(Object o) {
            return true;
        }
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    enum AlwaysFalse implements Func1<Object, Boolean> {
        INSTANCE;

        /* renamed from: call */
        public Boolean m2999call(Object o) {
            return false;
        }
    }

    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    enum Identity implements Func1<Object, Object> {
        INSTANCE;

        public Object call(Object o) {
            return o;
        }
    }
}