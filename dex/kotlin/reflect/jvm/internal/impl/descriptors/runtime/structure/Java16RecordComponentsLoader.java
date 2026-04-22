package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReflectJavaRecordComponent.kt */
final class Java16RecordComponentsLoader {
    public static final Java16RecordComponentsLoader INSTANCE = new Java16RecordComponentsLoader();
    private static Cache _cache;

    /* compiled from: ReflectJavaRecordComponent.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Cache {
        private final Method getAccessor;
        private final Method getType;

        public Cache(Method getType, Method getAccessor) {
            this.getType = getType;
            this.getAccessor = getAccessor;
        }

        public final Method getGetType() {
            return this.getType;
        }

        public final Method getGetAccessor() {
            return this.getAccessor;
        }
    }

    private Java16RecordComponentsLoader() {
    }

    private final Cache buildCache(Object recordComponent) {
        Class classOfComponent = recordComponent.getClass();
        try {
            return new Cache(classOfComponent.getMethod("getType", new Class[0]), classOfComponent.getMethod("getAccessor", new Class[0]));
        } catch (NoSuchMethodException e) {
            return new Cache(null, null);
        }
    }

    private final Cache initCache(Object recordComponent) {
        Cache cache = _cache;
        if (cache == null) {
            Cache cache2 = buildCache(recordComponent);
            _cache = cache2;
            return cache2;
        }
        return cache;
    }

    public final Class<?> loadGetType(Object recordComponent) {
        Intrinsics.checkNotNullParameter(recordComponent, "recordComponent");
        Cache cache = initCache(recordComponent);
        Method getType = cache.getGetType();
        if (getType == null) {
            return null;
        }
        Object invoke = getType.invoke(recordComponent, new Object[0]);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type java.lang.Class<*>");
        return (Class) invoke;
    }

    public final Method loadGetAccessor(Object recordComponent) {
        Intrinsics.checkNotNullParameter(recordComponent, "recordComponent");
        Cache cache = initCache(recordComponent);
        Method getType = cache.getGetAccessor();
        if (getType == null) {
            return null;
        }
        Object invoke = getType.invoke(recordComponent, new Object[0]);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (Method) invoke;
    }
}