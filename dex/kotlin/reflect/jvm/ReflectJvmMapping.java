package kotlin.reflect.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;

/* compiled from: ReflectJvmMapping.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u000e\u0010 \u001a\u0004\u0018\u00010!*\u00020\"H\u0002\u001a$\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0'2\u0006\u0010)\u001a\u00020\u0006H\u0002\u001a$\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0'2\u0006\u0010+\u001a\u00020\u0001H\u0002\"\u001b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u001b\u0010\t\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"/\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u0012\"\u0004\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u000e8F¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u001b\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u001b\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b$\u0010%\"-\u0010#\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u000e\"\b\b\u0000\u0010\u0013*\u00020,*\b\u0012\u0004\u0012\u0002H\u00130\u00128F¢\u0006\u0006\u001a\u0004\b$\u0010-¨\u0006."}, d2 = {"javaField", "Ljava/lang/reflect/Field;", "Lkotlin/reflect/KProperty;", "getJavaField", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Field;", "javaGetter", "Ljava/lang/reflect/Method;", "getJavaGetter", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Method;", "javaSetter", "Lkotlin/reflect/KMutableProperty;", "getJavaSetter", "(Lkotlin/reflect/KMutableProperty;)Ljava/lang/reflect/Method;", "javaMethod", "Lkotlin/reflect/KFunction;", "getJavaMethod", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Method;", "javaConstructor", "Ljava/lang/reflect/Constructor;", "T", "getJavaConstructor$annotations", "(Lkotlin/reflect/KFunction;)V", "getJavaConstructor", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Constructor;", "javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "kotlinProperty", "getKotlinProperty", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/KProperty;", "getKPackage", "Lkotlin/reflect/KDeclarationContainer;", "Ljava/lang/reflect/Member;", "kotlinFunction", "getKotlinFunction", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "findKFunction", "", "Lkotlin/reflect/KCallable;", "method", "findKProperty", "field", "", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ReflectJvmMapping {

    /* compiled from: ReflectJvmMapping.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            try {
                iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getJavaConstructor$annotations(KFunction kFunction) {
    }

    public static final Field getJavaField(KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "<this>");
        KPropertyImpl<?> asKPropertyImpl = UtilKt.asKPropertyImpl(kProperty);
        if (asKPropertyImpl != null) {
            return asKPropertyImpl.getJavaField();
        }
        return null;
    }

    public static final Method getJavaGetter(KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "<this>");
        return getJavaMethod(kProperty.getGetter());
    }

    public static final Method getJavaSetter(KMutableProperty<?> kMutableProperty) {
        Intrinsics.checkNotNullParameter(kMutableProperty, "<this>");
        return getJavaMethod(kMutableProperty.getSetter());
    }

    public static final Method getJavaMethod(KFunction<?> kFunction) {
        Caller<?> caller;
        Intrinsics.checkNotNullParameter(kFunction, "<this>");
        KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kFunction);
        Object mo1159getMember = (asKCallableImpl == null || (caller = asKCallableImpl.getCaller()) == null) ? null : caller.mo1159getMember();
        if (mo1159getMember instanceof Method) {
            return (Method) mo1159getMember;
        }
        return null;
    }

    public static final <T> Constructor<T> getJavaConstructor(KFunction<? extends T> kFunction) {
        Caller<?> caller;
        Intrinsics.checkNotNullParameter(kFunction, "<this>");
        KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kFunction);
        Object mo1159getMember = (asKCallableImpl == null || (caller = asKCallableImpl.getCaller()) == null) ? null : caller.mo1159getMember();
        if (mo1159getMember instanceof Constructor) {
            return (Constructor) mo1159getMember;
        }
        return null;
    }

    public static final Type getJavaType(KType $this$javaType) {
        Intrinsics.checkNotNullParameter($this$javaType, "<this>");
        return TypesJVMKt.getJavaType($this$javaType);
    }

    public static final KProperty<?> getKotlinProperty(Field $this$kotlinProperty) {
        KProperty it;
        Intrinsics.checkNotNullParameter($this$kotlinProperty, "<this>");
        if ($this$kotlinProperty.isSynthetic()) {
            return null;
        }
        if (Modifier.isStatic($this$kotlinProperty.getModifiers())) {
            KDeclarationContainer kotlinPackage = getKPackage($this$kotlinProperty);
            if (kotlinPackage != null) {
                return findKProperty(kotlinPackage.getMembers(), $this$kotlinProperty);
            }
            Class<?> declaringClass = $this$kotlinProperty.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
            KClass companionKClass = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass(declaringClass));
            if (companionKClass != null) {
                Class<?> declaringClass2 = $this$kotlinProperty.getDeclaringClass();
                Intrinsics.checkNotNullExpressionValue(declaringClass2, "getDeclaringClass(...)");
                String name = $this$kotlinProperty.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                Field companionField = UtilKt.getDeclaredFieldOrNull(declaringClass2, name);
                if (companionField != null && (it = findKProperty(KClasses.getMemberProperties(companionKClass), companionField)) != null) {
                    return it;
                }
            }
        }
        Class<?> declaringClass3 = $this$kotlinProperty.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass3, "getDeclaringClass(...)");
        return findKProperty(KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(declaringClass3)), $this$kotlinProperty);
    }

    private static final KDeclarationContainer getKPackage(Member $this$getKPackage) {
        KotlinClassHeader classHeader;
        ReflectKotlinClass.Factory factory = ReflectKotlinClass.Factory;
        Class<?> declaringClass = $this$getKPackage.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
        ReflectKotlinClass create = factory.create(declaringClass);
        KotlinClassHeader.Kind kind = (create == null || (classHeader = create.getClassHeader()) == null) ? null : classHeader.getKind();
        switch (kind == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
            case 1:
            case 2:
            case 3:
                Class<?> declaringClass2 = $this$getKPackage.getDeclaringClass();
                Intrinsics.checkNotNullExpressionValue(declaringClass2, "getDeclaringClass(...)");
                return new KPackageImpl(declaringClass2);
            default:
                return null;
        }
    }

    public static final KFunction<?> getKotlinFunction(Method $this$kotlinFunction) {
        KFunction it;
        Intrinsics.checkNotNullParameter($this$kotlinFunction, "<this>");
        if (Modifier.isStatic($this$kotlinFunction.getModifiers())) {
            KDeclarationContainer kotlinPackage = getKPackage($this$kotlinFunction);
            if (kotlinPackage != null) {
                return findKFunction(kotlinPackage.getMembers(), $this$kotlinFunction);
            }
            Class<?> declaringClass = $this$kotlinFunction.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
            KClass companionKClass = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass(declaringClass));
            if (companionKClass != null) {
                Class javaClass = JvmClassMappingKt.getJavaClass(companionKClass);
                String name = $this$kotlinFunction.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                Class<?>[] parameterTypes = $this$kotlinFunction.getParameterTypes();
                Method companionMethod = UtilKt.getDeclaredMethodOrNull(javaClass, name, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
                if (companionMethod != null && (it = findKFunction(KClasses.getFunctions(companionKClass), companionMethod)) != null) {
                    return it;
                }
            }
        }
        Class<?> declaringClass2 = $this$kotlinFunction.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass2, "getDeclaringClass(...)");
        return findKFunction(KClasses.getFunctions(JvmClassMappingKt.getKotlinClass(declaringClass2)), $this$kotlinFunction);
    }

    private static final KFunction<?> findKFunction(Collection<? extends KCallable<?>> collection, Method method) {
        for (KCallable callable : collection) {
            if ((callable instanceof KFunction) && Intrinsics.areEqual(((KFunction) callable).getName(), method.getName()) && Intrinsics.areEqual(getJavaMethod((KFunction) callable), method)) {
                return (KFunction) callable;
            }
        }
        for (KCallable callable2 : collection) {
            if ((callable2 instanceof KFunction) && !Intrinsics.areEqual(((KFunction) callable2).getName(), method.getName()) && Intrinsics.areEqual(getJavaMethod((KFunction) callable2), method)) {
                return (KFunction) callable2;
            }
        }
        return null;
    }

    private static final KProperty<?> findKProperty(Collection<? extends KCallable<?>> collection, Field field) {
        for (KCallable callable : collection) {
            if ((callable instanceof KProperty) && Intrinsics.areEqual(((KProperty) callable).getName(), field.getName()) && Intrinsics.areEqual(getJavaField((KProperty) callable), field)) {
                return (KProperty) callable;
            }
        }
        for (KCallable callable2 : collection) {
            if ((callable2 instanceof KProperty) && !Intrinsics.areEqual(((KProperty) callable2).getName(), field.getName()) && Intrinsics.areEqual(getJavaField((KProperty) callable2), field)) {
                return (KProperty) callable2;
            }
        }
        return null;
    }

    public static final <T> KFunction<T> getKotlinFunction(Constructor<T> constructor) {
        Object element$iv;
        Intrinsics.checkNotNullParameter(constructor, "<this>");
        Class<T> declaringClass = constructor.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
        Iterable $this$firstOrNull$iv = JvmClassMappingKt.getKotlinClass(declaringClass).getConstructors();
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                KFunction it2 = (KFunction) element$iv;
                if (Intrinsics.areEqual(getJavaConstructor(it2), constructor)) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        return (KFunction) element$iv;
    }
}