package kotlin.reflect.jvm.internal.impl.storage;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.DateCalculationsKt;
import leakcanary.internal.activity.db.LeaksDbHelper;

public class LockBasedStorageManager implements StorageManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final String debugText;
    private final ExceptionHandlingStrategy exceptionHandlingStrategy;
    protected final SimpleLock lock;
    private static final String PACKAGE_NAME = StringsKt.substringBeforeLast(LockBasedStorageManager.class.getCanonicalName(), ".", "");
    public static final StorageManager NO_LOCKS = new LockBasedStorageManager("NO_LOCKS", ExceptionHandlingStrategy.THROW, EmptySimpleLock.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.1
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
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
                    break;
                default:
                    objArr[0] = "source";
                    break;
            }
            switch (i) {
                case 1:
                    objArr[1] = "recursionDetectedDefault";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
                    break;
            }
            switch (i) {
                case 1:
                    break;
                default:
                    objArr[2] = "recursionDetectedDefault";
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

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager
        protected <K, V> RecursionDetectedResult<V> recursionDetectedDefault(String source, K input) {
            if (source == null) {
                $$$reportNull$$$0(0);
            }
            RecursionDetectedResult<V> fallThrough = RecursionDetectedResult.fallThrough();
            if (fallThrough == null) {
                $$$reportNull$$$0(1);
            }
            return fallThrough;
        }
    };

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy THROW = new ExceptionHandlingStrategy() { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy.1
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy
            public RuntimeException handleException(Throwable throwable) {
                if (throwable == null) {
                    $$$reportNull$$$0(0);
                }
                throw ExceptionUtilsKt.rethrow(throwable);
            }
        };

        RuntimeException handleException(Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum NotValue {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 10:
            case additional_type_content_video_VALUE:
            case 20:
            case 37:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 10:
            case additional_type_content_video_VALUE:
            case 20:
            case 37:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 3:
            case 5:
            case 8:
                objArr[0] = "exceptionHandlingStrategy";
                break;
            case 2:
            case 4:
            case 7:
            default:
                objArr[0] = "debugText";
                break;
            case 6:
                objArr[0] = "lock";
                break;
            case 9:
            case 11:
            case additional_type_content_comment_VALUE:
            case 16:
            case 19:
            case 21:
                objArr[0] = "compute";
                break;
            case 10:
            case additional_type_content_video_VALUE:
            case 20:
            case 37:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                break;
            case additional_type_content_opus_VALUE:
            case 17:
            case LeaksDbHelper.VERSION /* 25 */:
            case 27:
                objArr[0] = "onRecursiveCall";
                break;
            case 15:
            case 18:
            case 22:
                objArr[0] = "map";
                break;
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case 26:
            case 28:
            case 30:
            case 31:
            case 32:
            case 34:
                objArr[0] = "computable";
                break;
            case 29:
            case 33:
                objArr[0] = "postCompute";
                break;
            case 35:
                objArr[0] = "source";
                break;
            case 36:
                objArr[0] = "throwable";
                break;
        }
        switch (i) {
            case 10:
            case additional_type_content_video_VALUE:
                objArr[1] = "createMemoizedFunction";
                break;
            case 20:
                objArr[1] = "createMemoizedFunctionWithNullableValues";
                break;
            case 37:
                objArr[1] = "sanitizeStackTrace";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "<init>";
                break;
            case 7:
            case 8:
                objArr[2] = "replaceExceptionHandling";
                break;
            case 9:
            case 11:
            case additional_type_content_opus_VALUE:
            case additional_type_content_comment_VALUE:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createMemoizedFunction";
                break;
            case 10:
            case additional_type_content_video_VALUE:
            case 20:
            case 37:
                break;
            case 19:
            case 21:
            case 22:
                objArr[2] = "createMemoizedFunctionWithNullableValues";
                break;
            case 23:
            case DateCalculationsKt.HOURS_PER_DAY /* 24 */:
            case LeaksDbHelper.VERSION /* 25 */:
                objArr[2] = "createLazyValue";
                break;
            case 26:
            case 27:
                objArr[2] = "createRecursionTolerantLazyValue";
                break;
            case 28:
            case 29:
                objArr[2] = "createLazyValueWithPostCompute";
                break;
            case 30:
                objArr[2] = "createNullableLazyValue";
                break;
            case 31:
                objArr[2] = "createRecursionTolerantNullableLazyValue";
                break;
            case 32:
            case 33:
                objArr[2] = "createNullableLazyValueWithPostCompute";
                break;
            case 34:
                objArr[2] = "compute";
                break;
            case 35:
                objArr[2] = "recursionDetectedDefault";
                break;
            case 36:
                objArr[2] = "sanitizeStackTrace";
                break;
            default:
                objArr[2] = "createWithExceptionHandling";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 10:
            case additional_type_content_video_VALUE:
            case 20:
            case 37:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    static /* synthetic */ ExceptionHandlingStrategy access$100(LockBasedStorageManager x0) {
        return x0.exceptionHandlingStrategy;
    }

    private LockBasedStorageManager(String debugText, ExceptionHandlingStrategy exceptionHandlingStrategy, SimpleLock lock) {
        if (debugText == null) {
            $$$reportNull$$$0(4);
        }
        if (exceptionHandlingStrategy == null) {
            $$$reportNull$$$0(5);
        }
        if (lock == null) {
            $$$reportNull$$$0(6);
        }
        this.lock = lock;
        this.exceptionHandlingStrategy = exceptionHandlingStrategy;
        this.debugText = debugText;
    }

    public LockBasedStorageManager(String debugText) {
        this(debugText, (Runnable) null, (Function1<InterruptedException, Unit>) null);
    }

    public LockBasedStorageManager(String debugText, Runnable checkCancelled, Function1<InterruptedException, Unit> interruptedExceptionHandler) {
        this(debugText, ExceptionHandlingStrategy.THROW, SimpleLock.Companion.simpleLock(checkCancelled, interruptedExceptionHandler));
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.debugText + ")";
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> compute) {
        if (compute == null) {
            $$$reportNull$$$0(9);
        }
        MemoizedFunctionToNotNull<K, V> createMemoizedFunction = createMemoizedFunction(compute, createConcurrentHashMap());
        if (createMemoizedFunction == null) {
            $$$reportNull$$$0(10);
        }
        return createMemoizedFunction;
    }

    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> compute, ConcurrentMap<K, Object> map) {
        if (compute == null) {
            $$$reportNull$$$0(14);
        }
        if (map == null) {
            $$$reportNull$$$0(15);
        }
        return new MapBasedMemoizedFunctionToNotNull(this, map, compute);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> compute) {
        if (compute == null) {
            $$$reportNull$$$0(19);
        }
        MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues = createMemoizedFunctionWithNullableValues(compute, createConcurrentHashMap());
        if (createMemoizedFunctionWithNullableValues == null) {
            $$$reportNull$$$0(20);
        }
        return createMemoizedFunctionWithNullableValues;
    }

    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> compute, ConcurrentMap<K, Object> map) {
        if (compute == null) {
            $$$reportNull$$$0(21);
        }
        if (map == null) {
            $$$reportNull$$$0(22);
        }
        return new MapBasedMemoizedFunction(this, map, compute);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createLazyValue(Function0<? extends T> computable) {
        if (computable == null) {
            $$$reportNull$$$0(23);
        }
        return new LockBasedNotNullLazyValue(this, computable);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(Function0<? extends T> computable, final T onRecursiveCall) {
        if (computable == null) {
            $$$reportNull$$$0(26);
        }
        if (onRecursiveCall == null) {
            $$$reportNull$$$0(27);
        }
        return new LockBasedNotNullLazyValue<T>(this, computable) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.4
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
            protected RecursionDetectedResult<T> recursionDetected(boolean firstTime) {
                RecursionDetectedResult<T> value = RecursionDetectedResult.value(onRecursiveCall);
                if (value == null) {
                    $$$reportNull$$$0(0);
                }
                return value;
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(Function0<? extends T> computable, final Function1<? super Boolean, ? extends T> onRecursiveCall, final Function1<? super T, Unit> postCompute) {
        if (computable == null) {
            $$$reportNull$$$0(28);
        }
        if (postCompute == null) {
            $$$reportNull$$$0(29);
        }
        return new LockBasedNotNullLazyValueWithPostCompute<T>(this, computable) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.5
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                String str;
                int i2;
                switch (i) {
                    case 2:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                    default:
                        str = "@NotNull method %s.%s must not return null";
                        break;
                }
                switch (i) {
                    case 2:
                        i2 = 3;
                        break;
                    default:
                        i2 = 2;
                        break;
                }
                Object[] objArr = new Object[i2];
                switch (i) {
                    case 2:
                        objArr[0] = "value";
                        break;
                    default:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
                        break;
                }
                switch (i) {
                    case 2:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
                        break;
                    default:
                        objArr[1] = "recursionDetected";
                        break;
                }
                switch (i) {
                    case 2:
                        objArr[2] = "doPostCompute";
                        break;
                }
                String format = String.format(str, objArr);
                switch (i) {
                    case 2:
                        throw new IllegalArgumentException(format);
                    default:
                        throw new IllegalStateException(format);
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
            protected RecursionDetectedResult<T> recursionDetected(boolean firstTime) {
                if (onRecursiveCall == null) {
                    RecursionDetectedResult<T> recursionDetected = super.recursionDetected(firstTime);
                    if (recursionDetected == null) {
                        $$$reportNull$$$0(0);
                    }
                    return recursionDetected;
                }
                RecursionDetectedResult<T> value = RecursionDetectedResult.value(onRecursiveCall.invoke(Boolean.valueOf(firstTime)));
                if (value == null) {
                    $$$reportNull$$$0(1);
                }
                return value;
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute
            protected void doPostCompute(T value) {
                if (value == null) {
                    $$$reportNull$$$0(2);
                }
                postCompute.invoke(value);
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NullableLazyValue<T> createNullableLazyValue(Function0<? extends T> computable) {
        if (computable == null) {
            $$$reportNull$$$0(30);
        }
        return new LockBasedLazyValue(this, computable);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> T compute(Function0<? extends T> computable) {
        if (computable == null) {
            $$$reportNull$$$0(34);
        }
        this.lock.lock();
        try {
            return computable.invoke();
        } finally {
        }
    }

    private static <K> ConcurrentMap<K, Object> createConcurrentHashMap() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    protected <K, V> RecursionDetectedResult<V> recursionDetectedDefault(String source, K input) {
        if (source == null) {
            $$$reportNull$$$0(35);
        }
        throw ((AssertionError) sanitizeStackTrace(new AssertionError("Recursion detected " + source + (input == null ? "" : "on input: " + input) + " under " + this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class RecursionDetectedResult<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean fallThrough;
        private final T value;

        public static <T> RecursionDetectedResult<T> value(T value) {
            return new RecursionDetectedResult<>(value, false);
        }

        public static <T> RecursionDetectedResult<T> fallThrough() {
            return new RecursionDetectedResult<>(null, true);
        }

        private RecursionDetectedResult(T value, boolean fallThrough) {
            this.value = value;
            this.fallThrough = fallThrough;
        }

        public T getValue() {
            if (this.fallThrough) {
                throw new AssertionError("A value requested from FALL_THROUGH in " + this);
            }
            return this.value;
        }

        public boolean isFallThrough() {
            return this.fallThrough;
        }

        public String toString() {
            return isFallThrough() ? "FALL_THROUGH" : String.valueOf(this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class LockBasedLazyValue<T> implements NullableLazyValue<T> {
        private final Function0<? extends T> computable;
        private final LockBasedStorageManager storageManager;
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            switch (i) {
                case 2:
                case 3:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 2:
                case 3:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "computable";
                    break;
                case 2:
                case 3:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            switch (i) {
                case 2:
                    objArr[1] = "recursionDetected";
                    break;
                case 3:
                    objArr[1] = "renderDebugInformation";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
                    break;
            }
            switch (i) {
                case 2:
                case 3:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 2:
                case 3:
                    throw new IllegalStateException(format);
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        public LockBasedLazyValue(LockBasedStorageManager storageManager, Function0<? extends T> computable) {
            if (storageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (computable == null) {
                $$$reportNull$$$0(1);
            }
            this.value = NotValue.NOT_COMPUTED;
            this.storageManager = storageManager;
            this.computable = computable;
        }

        public boolean isComputed() {
            return (this.value == NotValue.NOT_COMPUTED || this.value == NotValue.COMPUTING) ? false : true;
        }

        @Override // kotlin.jvm.functions.Function0
        public T invoke() {
            Object _value = this.value;
            if (_value instanceof NotValue) {
                this.storageManager.lock.lock();
                try {
                    Object _value2 = this.value;
                    if (_value2 instanceof NotValue) {
                        if (_value2 == NotValue.COMPUTING) {
                            this.value = NotValue.RECURSION_WAS_DETECTED;
                            RecursionDetectedResult<T> result = recursionDetected(true);
                            if (!result.isFallThrough()) {
                                return result.getValue();
                            }
                        }
                        if (_value2 == NotValue.RECURSION_WAS_DETECTED) {
                            RecursionDetectedResult<T> result2 = recursionDetected(false);
                            if (!result2.isFallThrough()) {
                                return result2.getValue();
                            }
                        }
                        this.value = NotValue.COMPUTING;
                        T typedValue = this.computable.invoke();
                        postCompute(typedValue);
                        this.value = typedValue;
                        return typedValue;
                    }
                    return (T) WrappedValues.unescapeThrowable(_value2);
                } finally {
                    this.storageManager.lock.unlock();
                }
            }
            return (T) WrappedValues.unescapeThrowable(_value);
        }

        protected RecursionDetectedResult<T> recursionDetected(boolean firstTime) {
            RecursionDetectedResult<T> recursionDetectedDefault = this.storageManager.recursionDetectedDefault("in a lazy value", null);
            if (recursionDetectedDefault == null) {
                $$$reportNull$$$0(2);
            }
            return recursionDetectedDefault;
        }

        protected void postCompute(T value) {
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static abstract class LockBasedLazyValueWithPostCompute<T> extends LockBasedLazyValue<T> {
        private volatile SingleThreadValue<T> valuePostCompute;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "computable";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        protected abstract void doPostCompute(T t);

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedLazyValueWithPostCompute(LockBasedStorageManager storageManager, Function0<? extends T> computable) {
            super(storageManager, computable);
            if (storageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (computable == null) {
                $$$reportNull$$$0(1);
            }
            this.valuePostCompute = null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            SingleThreadValue<T> postComputeCache = this.valuePostCompute;
            if (postComputeCache != null && postComputeCache.hasValue()) {
                return postComputeCache.getValue();
            }
            return (T) super.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
        protected final void postCompute(T value) {
            this.valuePostCompute = new SingleThreadValue<>(value);
            try {
                doPostCompute(value);
            } finally {
                this.valuePostCompute = null;
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static abstract class LockBasedNotNullLazyValueWithPostCompute<T> extends LockBasedLazyValueWithPostCompute<T> implements NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            switch (i) {
                case 2:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
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
                    objArr[0] = "computable";
                    break;
                case 2:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            switch (i) {
                case 2:
                    objArr[1] = "invoke";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
                    break;
            }
            switch (i) {
                case 2:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 2:
                    throw new IllegalStateException(format);
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedNotNullLazyValueWithPostCompute(LockBasedStorageManager storageManager, Function0<? extends T> computable) {
            super(storageManager, computable);
            if (storageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (computable == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            T result = (T) super.invoke();
            if (result == null) {
                throw new AssertionError("compute() returned null");
            }
            if (result == null) {
                $$$reportNull$$$0(2);
            }
            return result;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class LockBasedNotNullLazyValue<T> extends LockBasedLazyValue<T> implements NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            switch (i) {
                case 2:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
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
                    objArr[0] = "computable";
                    break;
                case 2:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            switch (i) {
                case 2:
                    objArr[1] = "invoke";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
                    break;
            }
            switch (i) {
                case 2:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 2:
                    throw new IllegalStateException(format);
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedNotNullLazyValue(LockBasedStorageManager storageManager, Function0<? extends T> computable) {
            super(storageManager, computable);
            if (storageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (computable == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.jvm.functions.Function0
        public T invoke() {
            T result = (T) super.invoke();
            if (result == null) {
                throw new AssertionError("compute() returned null");
            }
            if (result == null) {
                $$$reportNull$$$0(2);
            }
            return result;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNullable<K, V> {
        private final ConcurrentMap<K, Object> cache;
        private final Function1<? super K, ? extends V> compute;
        private final LockBasedStorageManager storageManager;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            switch (i) {
                case 3:
                case 4:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 3:
                case 4:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "map";
                    break;
                case 2:
                    objArr[0] = "compute";
                    break;
                case 3:
                case 4:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            switch (i) {
                case 3:
                    objArr[1] = "recursionDetected";
                    break;
                case 4:
                    objArr[1] = "raceCondition";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
                    break;
            }
            switch (i) {
                case 3:
                case 4:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 3:
                case 4:
                    throw new IllegalStateException(format);
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        public MapBasedMemoizedFunction(LockBasedStorageManager storageManager, ConcurrentMap<K, Object> map, Function1<? super K, ? extends V> compute) {
            if (storageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (map == null) {
                $$$reportNull$$$0(1);
            }
            if (compute == null) {
                $$$reportNull$$$0(2);
            }
            this.storageManager = storageManager;
            this.cache = map;
            this.compute = compute;
        }

        @Override // kotlin.jvm.functions.Function1
        public V invoke(K input) {
            Object value = this.cache.get(input);
            if (value == null || value == NotValue.COMPUTING) {
                this.storageManager.lock.lock();
                try {
                    Object value2 = this.cache.get(input);
                    if (value2 == NotValue.COMPUTING) {
                        value2 = NotValue.RECURSION_WAS_DETECTED;
                        RecursionDetectedResult<V> result = recursionDetected(input, true);
                        if (!result.isFallThrough()) {
                            return result.getValue();
                        }
                    }
                    if (value2 == NotValue.RECURSION_WAS_DETECTED) {
                        RecursionDetectedResult<V> result2 = recursionDetected(input, false);
                        if (!result2.isFallThrough()) {
                            return result2.getValue();
                        }
                    }
                    if (value2 != null) {
                        return (V) WrappedValues.unescapeExceptionOrNull(value2);
                    }
                    this.cache.put(input, NotValue.COMPUTING);
                    V typedValue = this.compute.invoke(input);
                    Object oldValue = this.cache.put(input, WrappedValues.escapeNull(typedValue));
                    if (oldValue == NotValue.COMPUTING) {
                        return typedValue;
                    }
                    AssertionError error = raceCondition(input, oldValue);
                    throw error;
                } finally {
                    this.storageManager.lock.unlock();
                }
            }
            return (V) WrappedValues.unescapeExceptionOrNull(value);
        }

        protected RecursionDetectedResult<V> recursionDetected(K input, boolean firstTime) {
            RecursionDetectedResult<V> recursionDetectedDefault = this.storageManager.recursionDetectedDefault("", input);
            if (recursionDetectedDefault == null) {
                $$$reportNull$$$0(3);
            }
            return recursionDetectedDefault;
        }

        private AssertionError raceCondition(K input, Object oldValue) {
            AssertionError assertionError = (AssertionError) LockBasedStorageManager.sanitizeStackTrace(new AssertionError("Race condition detected on input " + input + ". Old value is " + oldValue + " under " + this.storageManager));
            if (assertionError == null) {
                $$$reportNull$$$0(4);
            }
            return assertionError;
        }

        private AssertionError inconsistentComputingKey(K input, Object oldValue) {
            return (AssertionError) LockBasedStorageManager.sanitizeStackTrace(new AssertionError("Inconsistent key detected. " + NotValue.COMPUTING + " is expected, was: " + oldValue + ", most probably race condition detected on input " + input + " under " + this.storageManager));
        }

        private AssertionError unableToRemoveKey(K input, Throwable throwable) {
            return (AssertionError) LockBasedStorageManager.sanitizeStackTrace(new AssertionError("Unable to remove " + input + " under " + this.storageManager, throwable));
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable
        public boolean isComputed(K key) {
            Object value = this.cache.get(key);
            return (value == null || value == NotValue.COMPUTING) ? false : true;
        }

        protected LockBasedStorageManager getStorageManager() {
            return this.storageManager;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class MapBasedMemoizedFunctionToNotNull<K, V> extends MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNotNull<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            switch (i) {
                case 3:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 3:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "map";
                    break;
                case 2:
                    objArr[0] = "compute";
                    break;
                case 3:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            switch (i) {
                case 3:
                    objArr[1] = "invoke";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
                    break;
            }
            switch (i) {
                case 3:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 3:
                    throw new IllegalStateException(format);
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MapBasedMemoizedFunctionToNotNull(LockBasedStorageManager storageManager, ConcurrentMap<K, Object> map, Function1<? super K, ? extends V> compute) {
            super(storageManager, map, compute);
            if (storageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (map == null) {
                $$$reportNull$$$0(1);
            }
            if (compute == null) {
                $$$reportNull$$$0(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunction, kotlin.jvm.functions.Function1
        public V invoke(K input) {
            V result = (V) super.invoke(input);
            if (result == null) {
                throw new AssertionError("compute() returned null under " + getStorageManager());
            }
            if (result == null) {
                $$$reportNull$$$0(3);
            }
            return result;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends Throwable> T sanitizeStackTrace(T throwable) {
        if (throwable == null) {
            $$$reportNull$$$0(36);
        }
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        int size = stackTrace.length;
        int firstNonStorage = -1;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            } else if (stackTrace[i].getClassName().startsWith(PACKAGE_NAME)) {
                i++;
            } else {
                firstNonStorage = i;
                break;
            }
        }
        if (firstNonStorage < 0) {
            throw new AssertionError("This method should only be called on exceptions created in LockBasedStorageManager");
        }
        List<StackTraceElement> list = Arrays.asList(stackTrace).subList(firstNonStorage, size);
        throwable.setStackTrace((StackTraceElement[]) list.toArray(new StackTraceElement[list.size()]));
        if (throwable == null) {
            $$$reportNull$$$0(37);
        }
        return throwable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues() {
        return new CacheWithNullableValuesBasedOnMemoizedFunction(createConcurrentHashMap());
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class CacheWithNullableValuesBasedOnMemoizedFunction<K, V> extends MapBasedMemoizedFunction<KeyWithComputation<K, V>, V> implements CacheWithNullableValues<K, V> {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "map";
                    break;
                case 2:
                    objArr[0] = "computation";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            switch (i) {
                case 2:
                    objArr[2] = "computeIfAbsent";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private CacheWithNullableValuesBasedOnMemoizedFunction(LockBasedStorageManager storageManager, ConcurrentMap<KeyWithComputation<K, V>, Object> map) {
            super(storageManager, map, new Function1<KeyWithComputation<K, V>, V>() { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((KeyWithComputation<K, Object>) obj);
                }

                public V invoke(KeyWithComputation<K, V> computation) {
                    return (V) ((KeyWithComputation) computation).computation.invoke();
                }
            });
            if (storageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (map == null) {
                $$$reportNull$$$0(1);
            }
        }

        public V computeIfAbsent(K key, Function0<? extends V> computation) {
            if (computation == null) {
                $$$reportNull$$$0(2);
            }
            return invoke(new KeyWithComputation(key, computation));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        return new CacheWithNotNullValuesBasedOnMemoizedFunction(createConcurrentHashMap());
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class CacheWithNotNullValuesBasedOnMemoizedFunction<K, V> extends CacheWithNullableValuesBasedOnMemoizedFunction<K, V> implements CacheWithNotNullValues<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            switch (i) {
                case 3:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 3:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "map";
                    break;
                case 2:
                    objArr[0] = "computation";
                    break;
                case 3:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            switch (i) {
                case 3:
                    objArr[1] = "computeIfAbsent";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
                    break;
            }
            switch (i) {
                case 2:
                    objArr[2] = "computeIfAbsent";
                    break;
                case 3:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 3:
                    throw new IllegalStateException(format);
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private CacheWithNotNullValuesBasedOnMemoizedFunction(LockBasedStorageManager storageManager, ConcurrentMap<KeyWithComputation<K, V>, Object> map) {
            super(map);
            if (storageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (map == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction, kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues
        public V computeIfAbsent(K key, Function0<? extends V> computation) {
            if (computation == null) {
                $$$reportNull$$$0(2);
            }
            V result = (V) super.computeIfAbsent(key, computation);
            if (result == null) {
                throw new AssertionError("computeIfAbsent() returned null under " + getStorageManager());
            }
            if (result == null) {
                $$$reportNull$$$0(3);
            }
            return result;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class KeyWithComputation<K, V> {
        private final Function0<? extends V> computation;
        private final K key;

        public KeyWithComputation(K key, Function0<? extends V> computation) {
            this.key = key;
            this.computation = computation;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            KeyWithComputation<?, ?> that = (KeyWithComputation) o;
            if (this.key.equals(that.key)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.key.hashCode();
        }
    }
}