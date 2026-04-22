package kotlin.reflect.jvm.internal.impl.utils;

public class WrappedValues {
    private static final Object NULL_VALUE = new Object() { // from class: kotlin.reflect.jvm.internal.impl.utils.WrappedValues.1
        public String toString() {
            return "NULL_VALUE";
        }
    };
    public static volatile boolean throwWrappedProcessCanceledException = false;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 1:
            case 2:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 1:
            case 2:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
                break;
            case 3:
                objArr[0] = "throwable";
                break;
            default:
                objArr[0] = "value";
                break;
        }
        switch (i) {
            case 1:
            case 2:
                objArr[1] = "escapeNull";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
                break;
        }
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                objArr[2] = "escapeThrowable";
                break;
            case 4:
                objArr[2] = "unescapeExceptionOrNull";
                break;
            default:
                objArr[2] = "unescapeNull";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 1:
            case 2:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class ThrowableWrapper {
        private final Throwable throwable;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            switch (i) {
                case 1:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 1:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
                    break;
                default:
                    objArr[0] = "throwable";
                    break;
            }
            switch (i) {
                case 1:
                    objArr[1] = "getThrowable";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
                    break;
            }
            switch (i) {
                case 1:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 1:
                    throw new IllegalStateException(format);
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        private ThrowableWrapper(Throwable throwable) {
            if (throwable == null) {
                $$$reportNull$$$0(0);
            }
            this.throwable = throwable;
        }

        public Throwable getThrowable() {
            Throwable th = this.throwable;
            if (th == null) {
                $$$reportNull$$$0(1);
            }
            return th;
        }

        public String toString() {
            return this.throwable.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V unescapeNull(Object value) {
        if (value == 0) {
            $$$reportNull$$$0(0);
        }
        if (value == NULL_VALUE) {
            return null;
        }
        return value;
    }

    public static <V> Object escapeNull(V value) {
        if (value != null) {
            if (value == null) {
                $$$reportNull$$$0(2);
            }
            return value;
        }
        Object obj = NULL_VALUE;
        if (obj == null) {
            $$$reportNull$$$0(1);
        }
        return obj;
    }

    public static Object escapeThrowable(Throwable throwable) {
        if (throwable == null) {
            $$$reportNull$$$0(3);
        }
        return new ThrowableWrapper(throwable);
    }

    public static <V> V unescapeExceptionOrNull(Object value) {
        if (value == null) {
            $$$reportNull$$$0(4);
        }
        return (V) unescapeNull(unescapeThrowable(value));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V unescapeThrowable(Object value) {
        if (value instanceof ThrowableWrapper) {
            Throwable originThrowable = ((ThrowableWrapper) value).getThrowable();
            if (throwWrappedProcessCanceledException && ExceptionUtilsKt.isProcessCanceledException(originThrowable)) {
                throw new WrappedProcessCanceledException(originThrowable);
            }
            throw ExceptionUtilsKt.rethrow(originThrowable);
        }
        return value;
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable cause) {
            super("Rethrow stored exception", cause);
        }
    }
}