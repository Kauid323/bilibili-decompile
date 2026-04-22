package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReflectJavaClassFinder.kt */
public final class ReflectJavaClassFinderKt {
    public static final Class<?> tryLoadClass(ClassLoader $this$tryLoadClass, String fqName) {
        Intrinsics.checkNotNullParameter($this$tryLoadClass, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        try {
            return Class.forName(fqName, false, $this$tryLoadClass);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}