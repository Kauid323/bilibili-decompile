package kotlinx.serialization.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;

/* compiled from: Platform.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aO\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0007\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0002¢\u0006\u0002\u0010\b\u001a\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0000\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001a$\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0000\u001aM\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00052\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0007\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0000¢\u0006\u0002\u0010\b\u001aM\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\f2\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0007\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0000¢\u0006\u0002\u0010\u0010\u001a\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a$\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a&\u0010\u0013\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0080\b¢\u0006\u0002\u0010\u0016\u001a\u0015\u0010\u0013\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0080\b\u001a$\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a\u001c\u0010\u0019\u001a\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a\u001c\u0010\u001a\u001a\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a\u0010\u0010\u001b\u001a\u00020\u001c*\u0006\u0012\u0002\b\u00030\fH\u0000\u001a\u0010\u0010\u001d\u001a\u00020\u001c*\u0006\u0012\u0002\b\u00030\u0005H\u0000\u001aK\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010\u001f*\u0004\u0018\u0001H\u0002*\u0012\u0012\u0004\u0012\u0002H\u001f0 j\b\u0012\u0004\u0012\u0002H\u001f`!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\fH\u0000¢\u0006\u0002\u0010#¨\u0006$"}, d2 = {"invokeSerializerOnCompanion", "Lkotlinx/serialization/KSerializer;", "T", "", "jClass", "Ljava/lang/Class;", "args", "", "(Ljava/lang/Class;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "isReferenceArray", "", "rootClass", "Lkotlin/reflect/KClass;", "companionOrNull", "compiledSerializerImpl", "constructSerializerForGivenTypeArgs", "(Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "createEnumSerializer", "findObjectSerializer", "getChecked", "index", "", "([Ljava/lang/Object;I)Ljava/lang/Object;", "", "interfaceSerializer", "isNotAnnotated", "isPolymorphicSerializer", "platformSpecificSerializerNotRegistered", "", "serializerNotRegistered", "toNativeArrayImpl", "E", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eClass", "(Ljava/util/ArrayList;Lkotlin/reflect/KClass;)[Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlatformKt {
    public static final <T> T getChecked(T[] tArr, int index) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[index];
    }

    public static final boolean getChecked(boolean[] $this$getChecked, int index) {
        Intrinsics.checkNotNullParameter($this$getChecked, "<this>");
        return $this$getChecked[index];
    }

    public static final <T> KSerializer<T> compiledSerializerImpl(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return constructSerializerForGivenTypeArgs(kClass, new KSerializer[0]);
    }

    public static final <T, E extends T> E[] toNativeArrayImpl(ArrayList<E> arrayList, KClass<T> eClass) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(eClass, "eClass");
        Object newInstance = Array.newInstance(JvmClassMappingKt.getJavaClass((KClass) eClass), arrayList.size());
        Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        E[] eArr = (E[]) arrayList.toArray((Object[]) newInstance);
        Intrinsics.checkNotNullExpressionValue(eArr, "toArray(java.lang.reflec….java, size) as Array<E>)");
        return eArr;
    }

    public static final Void platformSpecificSerializerNotRegistered(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Platform_commonKt.serializerNotRegistered(kClass);
        throw new KotlinNothingValueException();
    }

    public static final Void serializerNotRegistered(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        throw new SerializationException(Platform_commonKt.notRegisteredMessage(JvmClassMappingKt.getKotlinClass(cls)));
    }

    public static final <T> KSerializer<T> constructSerializerForGivenTypeArgs(KClass<T> kClass, KSerializer<Object>... args) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        return constructSerializerForGivenTypeArgs(JvmClassMappingKt.getJavaClass((KClass) kClass), (KSerializer[]) Arrays.copyOf(args, args.length));
    }

    public static final <T> KSerializer<T> constructSerializerForGivenTypeArgs(Class<T> cls, KSerializer<Object>... args) {
        KSerializer fromNamedCompanion;
        Field field;
        KSerializer it;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        if (cls.isEnum() && isNotAnnotated(cls)) {
            return createEnumSerializer(cls);
        }
        if (!cls.isInterface() || (it = interfaceSerializer(cls)) == null) {
            KSerializer serializer = invokeSerializerOnCompanion(cls, (KSerializer[]) Arrays.copyOf(args, args.length));
            if (serializer != null) {
                return serializer;
            }
            KSerializer it2 = findObjectSerializer(cls);
            if (it2 != null) {
                return it2;
            }
            try {
                Object[] declaredClasses = cls.getDeclaredClasses();
                Intrinsics.checkNotNullExpressionValue(declaredClasses, "declaredClasses");
                Object[] $this$singleOrNull$iv = declaredClasses;
                Object single$iv = null;
                boolean found$iv = false;
                int length = $this$singleOrNull$iv.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        Object element$iv = $this$singleOrNull$iv[i];
                        if (Intrinsics.areEqual(((Class) element$iv).getSimpleName(), "$serializer")) {
                            if (found$iv) {
                                single$iv = null;
                                break;
                            }
                            single$iv = element$iv;
                            found$iv = true;
                        }
                        i++;
                    } else if (!found$iv) {
                        single$iv = null;
                    }
                }
                Class<?> cls2 = (Class) single$iv;
                Object obj = (cls2 == null || (field = cls2.getField("INSTANCE")) == null) ? null : field.get(null);
                fromNamedCompanion = obj instanceof KSerializer ? (KSerializer) obj : null;
            } catch (NoSuchFieldException e) {
                fromNamedCompanion = null;
            }
            if (fromNamedCompanion != null) {
                return fromNamedCompanion;
            }
            if (isPolymorphicSerializer(cls)) {
                return new PolymorphicSerializer(JvmClassMappingKt.getKotlinClass(cls));
            }
            return null;
        }
        return it;
    }

    private static final <T> boolean isNotAnnotated(Class<T> cls) {
        return cls.getAnnotation(Serializable.class) == null && cls.getAnnotation(Polymorphic.class) == null;
    }

    private static final <T> boolean isPolymorphicSerializer(Class<T> cls) {
        if (cls.getAnnotation(Polymorphic.class) != null) {
            return true;
        }
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        return serializable != null && Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(serializable.with()), Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class));
    }

    private static final <T> KSerializer<T> interfaceSerializer(Class<T> cls) {
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        if (serializable == null || Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(serializable.with()), Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class))) {
            return new PolymorphicSerializer(JvmClassMappingKt.getKotlinClass(cls));
        }
        return null;
    }

    private static final <T> KSerializer<T> invokeSerializerOnCompanion(Class<?> cls, KSerializer<Object>... kSerializerArr) {
        Class[] clsArr;
        Object companion = companionOrNull(cls);
        if (companion == null) {
            return null;
        }
        try {
            if (!(kSerializerArr.length == 0)) {
                int length = kSerializerArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i = 0; i < length; i++) {
                    clsArr2[i] = KSerializer.class;
                }
                clsArr = clsArr2;
            } else {
                clsArr = new Class[0];
            }
            Class[] types = clsArr;
            Object invoke = companion.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(types, types.length)).invoke(companion, Arrays.copyOf(kSerializerArr, kSerializerArr.length));
            if (invoke instanceof KSerializer) {
                return (KSerializer) invoke;
            }
            return null;
        } catch (NoSuchMethodException e) {
            return null;
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause == null) {
                throw e2;
            }
            String message = cause.getMessage();
            if (message == null) {
                message = e2.getMessage();
            }
            throw new InvocationTargetException(cause, message);
        }
    }

    private static final Object companionOrNull(Class<?> cls) {
        try {
            Field companion = cls.getDeclaredField("Companion");
            companion.setAccessible(true);
            return companion.get(null);
        } catch (Throwable th) {
            return null;
        }
    }

    private static final <T> KSerializer<T> createEnumSerializer(Class<T> cls) {
        Object[] constants = cls.getEnumConstants();
        String canonicalName = cls.getCanonicalName();
        Intrinsics.checkNotNullExpressionValue(canonicalName, "canonicalName");
        Intrinsics.checkNotNull(constants, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new EnumSerializer(canonicalName, (Enum[]) constants);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ac A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final <T> KSerializer<T> findObjectSerializer(Class<T> cls) {
        boolean z;
        boolean z2;
        Object[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "declaredFields");
        Object[] $this$singleOrNull$iv = declaredFields;
        Object single$iv = null;
        boolean found$iv = false;
        int length = $this$singleOrNull$iv.length;
        int i = 0;
        while (true) {
            if (i < length) {
                Object element$iv = $this$singleOrNull$iv[i];
                Field it = (Field) element$iv;
                if (Intrinsics.areEqual(it.getName(), "INSTANCE") && Intrinsics.areEqual(it.getType(), cls) && Modifier.isStatic(it.getModifiers())) {
                    z2 = true;
                    if (z2) {
                        if (found$iv) {
                            single$iv = null;
                            break;
                        }
                        single$iv = element$iv;
                        found$iv = true;
                    }
                    i++;
                }
                z2 = false;
                if (z2) {
                }
                i++;
            } else if (!found$iv) {
                single$iv = null;
            }
        }
        Field field = (Field) single$iv;
        if (field == null) {
            return null;
        }
        Object instance = field.get(null);
        Object[] methods = cls.getMethods();
        Intrinsics.checkNotNullExpressionValue(methods, "methods");
        Object[] $this$singleOrNull$iv2 = methods;
        Object single$iv2 = null;
        boolean found$iv2 = false;
        int length2 = $this$singleOrNull$iv2.length;
        int i2 = 0;
        while (true) {
            if (i2 < length2) {
                Object element$iv2 = $this$singleOrNull$iv2[i2];
                Method it2 = (Method) element$iv2;
                if (Intrinsics.areEqual(it2.getName(), "serializer")) {
                    Class<?>[] parameterTypes = it2.getParameterTypes();
                    Intrinsics.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                    if ((parameterTypes.length == 0) && Intrinsics.areEqual(it2.getReturnType(), KSerializer.class)) {
                        z = true;
                        if (z) {
                            if (found$iv2) {
                                single$iv2 = null;
                                break;
                            }
                            single$iv2 = element$iv2;
                            found$iv2 = true;
                        }
                        i2++;
                    }
                }
                z = false;
                if (z) {
                }
                i2++;
            } else if (!found$iv2) {
                single$iv2 = null;
            }
        }
        Method method = (Method) single$iv2;
        if (method == null) {
            return null;
        }
        Object result = method.invoke(instance, new Object[0]);
        if (result instanceof KSerializer) {
            return (KSerializer) result;
        }
        return null;
    }

    public static final boolean isReferenceArray(KClass<Object> rootClass) {
        Intrinsics.checkNotNullParameter(rootClass, "rootClass");
        return JvmClassMappingKt.getJavaClass((KClass) rootClass).isArray();
    }
}