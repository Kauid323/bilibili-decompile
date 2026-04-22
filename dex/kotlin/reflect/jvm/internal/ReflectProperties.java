package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;

public class ReflectProperties {
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties", "lazySoft"));
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static abstract class Val<T> {
        private static final Object NULL_VALUE = new Object() { // from class: kotlin.reflect.jvm.internal.ReflectProperties.Val.1
        };

        public abstract T invoke();

        public final T getValue(Object instance, Object metadata) {
            return invoke();
        }

        protected Object escape(T value) {
            return value == null ? NULL_VALUE : value;
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected T unescape(Object value) {
            if (value == NULL_VALUE) {
                return null;
            }
            return value;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class LazySoftVal<T> extends Val<T> implements Function0<T> {
        private final Function0<T> initializer;
        private volatile SoftReference<Object> value;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        public LazySoftVal(T initialValue, Function0<T> initializer) {
            if (initializer == null) {
                $$$reportNull$$$0(0);
            }
            this.value = null;
            this.initializer = initializer;
            if (initialValue != null) {
                this.value = new SoftReference<>(escape(initialValue));
            }
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val, kotlin.jvm.functions.Function0
        public T invoke() {
            Object result;
            SoftReference<Object> cached = this.value;
            if (cached != null && (result = cached.get()) != null) {
                return unescape(result);
            }
            T result2 = this.initializer.invoke();
            this.value = new SoftReference<>(escape(result2));
            return result2;
        }
    }

    public static <T> LazySoftVal<T> lazySoft(T initialValue, Function0<T> initializer) {
        if (initializer == null) {
            $$$reportNull$$$0(0);
        }
        return new LazySoftVal<>(initialValue, initializer);
    }

    public static <T> LazySoftVal<T> lazySoft(Function0<T> initializer) {
        if (initializer == null) {
            $$$reportNull$$$0(1);
        }
        return lazySoft(null, initializer);
    }
}