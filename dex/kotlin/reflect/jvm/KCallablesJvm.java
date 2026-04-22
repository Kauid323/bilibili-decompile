package kotlin.reflect.jvm;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;

/* compiled from: KCallablesJvm.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\",\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"value", "", "isAccessible", "Lkotlin/reflect/KCallable;", "(Lkotlin/reflect/KCallable;)Z", "setAccessible", "(Lkotlin/reflect/KCallable;Z)V", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KCallablesJvm {
    public static final boolean isAccessible(KCallable<?> kCallable) {
        Caller<?> defaultCaller;
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        if (kCallable instanceof KMutableProperty) {
            Field javaField = ReflectJvmMapping.getJavaField((KProperty) kCallable);
            if (javaField != null ? javaField.isAccessible() : true) {
                Method javaGetter = ReflectJvmMapping.getJavaGetter((KProperty) kCallable);
                if (javaGetter != null ? javaGetter.isAccessible() : true) {
                    Method javaSetter = ReflectJvmMapping.getJavaSetter((KMutableProperty) kCallable);
                    return javaSetter != null ? javaSetter.isAccessible() : true;
                }
                return false;
            }
            return false;
        } else if (kCallable instanceof KProperty) {
            Field javaField2 = ReflectJvmMapping.getJavaField((KProperty) kCallable);
            if (javaField2 != null ? javaField2.isAccessible() : true) {
                Method javaGetter2 = ReflectJvmMapping.getJavaGetter((KProperty) kCallable);
                return javaGetter2 != null ? javaGetter2.isAccessible() : true;
            }
            return false;
        } else if (kCallable instanceof KProperty.Getter) {
            Field javaField3 = ReflectJvmMapping.getJavaField(((KProperty.Getter) kCallable).getProperty());
            if (javaField3 != null ? javaField3.isAccessible() : true) {
                Method javaMethod = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
                return javaMethod != null ? javaMethod.isAccessible() : true;
            }
            return false;
        } else if (kCallable instanceof KMutableProperty.Setter) {
            Field javaField4 = ReflectJvmMapping.getJavaField(((KMutableProperty.Setter) kCallable).getProperty());
            if (javaField4 != null ? javaField4.isAccessible() : true) {
                Method javaMethod2 = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
                return javaMethod2 != null ? javaMethod2.isAccessible() : true;
            }
            return false;
        } else if (kCallable instanceof KFunction) {
            Method javaMethod3 = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
            if (javaMethod3 != null ? javaMethod3.isAccessible() : true) {
                KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kCallable);
                Object mo1159getMember = (asKCallableImpl == null || (defaultCaller = asKCallableImpl.getDefaultCaller()) == null) ? null : defaultCaller.mo1159getMember();
                AccessibleObject accessibleObject = mo1159getMember instanceof AccessibleObject ? (AccessibleObject) mo1159getMember : null;
                if (accessibleObject != null ? accessibleObject.isAccessible() : true) {
                    Constructor javaConstructor = ReflectJvmMapping.getJavaConstructor((KFunction) kCallable);
                    return javaConstructor != null ? javaConstructor.isAccessible() : true;
                }
                return false;
            }
            return false;
        } else {
            throw new UnsupportedOperationException("Unknown callable: " + kCallable + " (" + kCallable.getClass() + ')');
        }
    }

    public static final void setAccessible(KCallable<?> kCallable, boolean value) {
        Caller<?> defaultCaller;
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        if (kCallable instanceof KMutableProperty) {
            Field javaField = ReflectJvmMapping.getJavaField((KProperty) kCallable);
            if (javaField != null) {
                javaField.setAccessible(value);
            }
            Method javaGetter = ReflectJvmMapping.getJavaGetter((KProperty) kCallable);
            if (javaGetter != null) {
                javaGetter.setAccessible(value);
            }
            Method javaSetter = ReflectJvmMapping.getJavaSetter((KMutableProperty) kCallable);
            if (javaSetter != null) {
                javaSetter.setAccessible(value);
            }
        } else if (kCallable instanceof KProperty) {
            Field javaField2 = ReflectJvmMapping.getJavaField((KProperty) kCallable);
            if (javaField2 != null) {
                javaField2.setAccessible(value);
            }
            Method javaGetter2 = ReflectJvmMapping.getJavaGetter((KProperty) kCallable);
            if (javaGetter2 != null) {
                javaGetter2.setAccessible(value);
            }
        } else if (kCallable instanceof KProperty.Getter) {
            Field javaField3 = ReflectJvmMapping.getJavaField(((KProperty.Getter) kCallable).getProperty());
            if (javaField3 != null) {
                javaField3.setAccessible(value);
            }
            Method javaMethod = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
            if (javaMethod != null) {
                javaMethod.setAccessible(value);
            }
        } else if (kCallable instanceof KMutableProperty.Setter) {
            Field javaField4 = ReflectJvmMapping.getJavaField(((KMutableProperty.Setter) kCallable).getProperty());
            if (javaField4 != null) {
                javaField4.setAccessible(value);
            }
            Method javaMethod2 = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
            if (javaMethod2 != null) {
                javaMethod2.setAccessible(value);
            }
        } else if (kCallable instanceof KFunction) {
            Method javaMethod3 = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
            if (javaMethod3 != null) {
                javaMethod3.setAccessible(value);
            }
            KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kCallable);
            Object mo1159getMember = (asKCallableImpl == null || (defaultCaller = asKCallableImpl.getDefaultCaller()) == null) ? null : defaultCaller.mo1159getMember();
            AccessibleObject accessibleObject = mo1159getMember instanceof AccessibleObject ? (AccessibleObject) mo1159getMember : null;
            if (accessibleObject != null) {
                accessibleObject.setAccessible(true);
            }
            Constructor javaConstructor = ReflectJvmMapping.getJavaConstructor((KFunction) kCallable);
            if (javaConstructor != null) {
                javaConstructor.setAccessible(value);
            }
        } else {
            throw new UnsupportedOperationException("Unknown callable: " + kCallable + " (" + kCallable.getClass() + ')');
        }
    }
}