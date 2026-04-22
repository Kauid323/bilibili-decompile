package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReflectJavaClass.kt */
public final class Java16SealedRecordLoader {
    public static final Java16SealedRecordLoader INSTANCE = new Java16SealedRecordLoader();
    private static Cache _cache;

    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Cache {
        private final Method getPermittedSubclasses;
        private final Method getRecordComponents;
        private final Method isRecord;
        private final Method isSealed;

        public Cache(Method isSealed, Method getPermittedSubclasses, Method isRecord, Method getRecordComponents) {
            this.isSealed = isSealed;
            this.getPermittedSubclasses = getPermittedSubclasses;
            this.isRecord = isRecord;
            this.getRecordComponents = getRecordComponents;
        }

        public final Method isSealed() {
            return this.isSealed;
        }

        public final Method getGetPermittedSubclasses() {
            return this.getPermittedSubclasses;
        }

        public final Method isRecord() {
            return this.isRecord;
        }

        public final Method getGetRecordComponents() {
            return this.getRecordComponents;
        }
    }

    private Java16SealedRecordLoader() {
    }

    private final Cache buildCache() {
        try {
            return new Cache(Class.class.getMethod("isSealed", new Class[0]), Class.class.getMethod("getPermittedSubclasses", new Class[0]), Class.class.getMethod("isRecord", new Class[0]), Class.class.getMethod("getRecordComponents", new Class[0]));
        } catch (NoSuchMethodException e) {
            return new Cache(null, null, null, null);
        }
    }

    private final Cache initCache() {
        Cache cache = _cache;
        if (cache == null) {
            Cache cache2 = buildCache();
            _cache = cache2;
            return cache2;
        }
        return cache;
    }

    public final Boolean loadIsSealed(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Cache cache = initCache();
        Method isSealed = cache.isSealed();
        if (isSealed == null) {
            return null;
        }
        Object invoke = isSealed.invoke(clazz, new Object[0]);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) invoke;
    }

    public final Class<?>[] loadGetPermittedSubclasses(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Cache cache = initCache();
        Method getPermittedSubclasses = cache.getGetPermittedSubclasses();
        if (getPermittedSubclasses == null) {
            return null;
        }
        Object invoke = getPermittedSubclasses.invoke(clazz, new Object[0]);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[]) invoke;
    }

    public final Boolean loadIsRecord(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Cache cache = initCache();
        Method isRecord = cache.isRecord();
        if (isRecord == null) {
            return null;
        }
        Object invoke = isRecord.invoke(clazz, new Object[0]);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) invoke;
    }

    public final Object[] loadGetRecordComponents(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Cache cache = initCache();
        Method getRecordComponents = cache.getGetRecordComponents();
        if (getRecordComponents == null) {
            return null;
        }
        return (Object[]) getRecordComponents.invoke(clazz, new Object[0]);
    }
}