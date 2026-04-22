package kotlin.reflect.jvm.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* compiled from: moduleByClassLoader.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0006H\u0000\u001a\b\u0010\u0007\u001a\u00020\bH\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getOrCreateModule", "Ljava/lang/Class;", "clearModuleByClassLoaderCache", "", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ModuleByClassLoaderKt {
    private static final ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> moduleByClassLoader = new ConcurrentHashMap<>();

    public static final RuntimeModuleData getOrCreateModule(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        ClassLoader classLoader = ReflectClassUtilKt.getSafeClassLoader(cls);
        WeakClassLoaderBox key = new WeakClassLoaderBox(classLoader);
        WeakReference cached = moduleByClassLoader.get(key);
        if (cached != null) {
            RuntimeModuleData it = cached.get();
            if (it != null) {
                return it;
            }
            moduleByClassLoader.remove(key, cached);
        }
        RuntimeModuleData module = RuntimeModuleData.Companion.create(classLoader);
        while (true) {
            try {
                WeakReference ref = moduleByClassLoader.putIfAbsent(key, new WeakReference<>(module));
                if (ref == null) {
                    return module;
                }
                RuntimeModuleData result = ref.get();
                if (result != null) {
                    return result;
                }
                moduleByClassLoader.remove(key, ref);
            } finally {
                key.setTemporaryStrongRef(null);
            }
        }
    }

    public static final void clearModuleByClassLoaderCache() {
        moduleByClassLoader.clear();
    }
}