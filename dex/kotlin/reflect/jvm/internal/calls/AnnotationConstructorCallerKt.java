package kotlin.reflect.jvm.internal.calls;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.text.Typography;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: AnnotationConstructorCaller.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001a$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001aI\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0000¢\u0006\u0002\u0010\u0013¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u0007X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"transformKotlinToJvm", "", "expectedType", "Ljava/lang/Class;", "throwIllegalArgumentType", "", "index", "", "name", "", "expectedJvmType", "createAnnotationInstance", "T", "annotationClass", "values", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "kotlin-reflection", "hashCode", "toString"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AnnotationConstructorCallerKt {
    public static final /* synthetic */ Void access$throwIllegalArgumentType(int index, String name, Class expectedJvmType) {
        return throwIllegalArgumentType(index, name, expectedJvmType);
    }

    public static final /* synthetic */ Object access$transformKotlinToJvm(Object $receiver, Class expectedType) {
        return transformKotlinToJvm($receiver, expectedType);
    }

    public static final Object transformKotlinToJvm(Object $this$transformKotlinToJvm, Class<?> cls) {
        Object result;
        if ($this$transformKotlinToJvm instanceof Class) {
            return null;
        }
        if ($this$transformKotlinToJvm instanceof KClass) {
            result = JvmClassMappingKt.getJavaClass((KClass) $this$transformKotlinToJvm);
        } else if ($this$transformKotlinToJvm instanceof Object[]) {
            if (((Object[]) $this$transformKotlinToJvm) instanceof Class[]) {
                return null;
            }
            if (!(((Object[]) $this$transformKotlinToJvm) instanceof KClass[])) {
                result = (Object[]) $this$transformKotlinToJvm;
            } else {
                Intrinsics.checkNotNull($this$transformKotlinToJvm, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                KClass[] kClassArr = (KClass[]) $this$transformKotlinToJvm;
                Collection destination$iv$iv = new ArrayList(kClassArr.length);
                for (KClass kClass : kClassArr) {
                    destination$iv$iv.add(JvmClassMappingKt.getJavaClass(kClass));
                }
                Collection thisCollection$iv = (List) destination$iv$iv;
                result = thisCollection$iv.toArray(new Class[0]);
            }
        } else {
            result = $this$transformKotlinToJvm;
        }
        if (cls.isInstance(result)) {
            return result;
        }
        return null;
    }

    public static final Void throwIllegalArgumentType(int index, String name, Class<?> cls) {
        KClass kotlinClass;
        String typeString;
        if (Intrinsics.areEqual(cls, Class.class)) {
            kotlinClass = Reflection.getOrCreateKotlinClass(KClass.class);
        } else {
            kotlinClass = (cls.isArray() && Intrinsics.areEqual(cls.getComponentType(), Class.class)) ? Reflection.getOrCreateKotlinClass(KClass[].class) : JvmClassMappingKt.getKotlinClass(cls);
        }
        if (Intrinsics.areEqual(kotlinClass.getQualifiedName(), Reflection.getOrCreateKotlinClass(Object[].class).getQualifiedName())) {
            StringBuilder append = new StringBuilder().append(kotlinClass.getQualifiedName()).append(Typography.less);
            Class<?> componentType = JvmClassMappingKt.getJavaClass(kotlinClass).getComponentType();
            Intrinsics.checkNotNullExpressionValue(componentType, "getComponentType(...)");
            typeString = append.append(JvmClassMappingKt.getKotlinClass(componentType).getQualifiedName()).append(Typography.greater).toString();
        } else {
            typeString = kotlinClass.getQualifiedName();
        }
        throw new IllegalArgumentException("Argument #" + index + ' ' + name + " is not of the required type " + typeString);
    }

    public static /* synthetic */ Object createAnnotationInstance$default(Class cls, Map map, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            Iterable $this$map$iv = map.keySet();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String name = (String) item$iv$iv;
                destination$iv$iv.add(cls.getDeclaredMethod(name, new Class[0]));
            }
            list = (List) destination$iv$iv;
        }
        return createAnnotationInstance(cls, map, list);
    }

    private static final <T> boolean createAnnotationInstance$equals(Class<T> cls, List<Method> list, Map<String, ? extends Object> map, Object other) {
        Iterable $this$all$iv;
        boolean areEqual;
        KClass annotationClass;
        Class cls2 = null;
        Annotation annotation = other instanceof Annotation ? (Annotation) other : null;
        if (annotation != null && (annotationClass = JvmClassMappingKt.getAnnotationClass(annotation)) != null) {
            cls2 = JvmClassMappingKt.getJavaClass(annotationClass);
        }
        if (Intrinsics.areEqual(cls2, cls)) {
            List<Method> $this$all$iv2 = list;
            if (!($this$all$iv2 instanceof Collection) || !$this$all$iv2.isEmpty()) {
                Iterator<T> it = $this$all$iv2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        Method method = (Method) element$iv;
                        Object ours = map.get(method.getName());
                        Object theirs = method.invoke(other, new Object[0]);
                        if (ours instanceof boolean[]) {
                            Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.BooleanArray");
                            areEqual = Arrays.equals((boolean[]) ours, (boolean[]) theirs);
                            continue;
                        } else if (ours instanceof char[]) {
                            Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.CharArray");
                            areEqual = Arrays.equals((char[]) ours, (char[]) theirs);
                            continue;
                        } else if (ours instanceof byte[]) {
                            Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.ByteArray");
                            areEqual = Arrays.equals((byte[]) ours, (byte[]) theirs);
                            continue;
                        } else if (ours instanceof short[]) {
                            Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.ShortArray");
                            areEqual = Arrays.equals((short[]) ours, (short[]) theirs);
                            continue;
                        } else if (ours instanceof int[]) {
                            Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.IntArray");
                            areEqual = Arrays.equals((int[]) ours, (int[]) theirs);
                            continue;
                        } else if (ours instanceof float[]) {
                            Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.FloatArray");
                            areEqual = Arrays.equals((float[]) ours, (float[]) theirs);
                            continue;
                        } else if (ours instanceof long[]) {
                            Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.LongArray");
                            areEqual = Arrays.equals((long[]) ours, (long[]) theirs);
                            continue;
                        } else if (ours instanceof double[]) {
                            Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.DoubleArray");
                            areEqual = Arrays.equals((double[]) ours, (double[]) theirs);
                            continue;
                        } else if (ours instanceof Object[]) {
                            Intrinsics.checkNotNull(theirs, "null cannot be cast to non-null type kotlin.Array<*>");
                            areEqual = Arrays.equals((Object[]) ours, (Object[]) theirs);
                            continue;
                        } else {
                            areEqual = Intrinsics.areEqual(ours, theirs);
                            continue;
                        }
                        if (!areEqual) {
                            $this$all$iv = null;
                            break;
                        }
                    } else {
                        $this$all$iv = 1;
                        break;
                    }
                }
            } else {
                $this$all$iv = 1;
            }
            return $this$all$iv != null;
        }
        return false;
    }

    public static final <T> T createAnnotationInstance(Class<T> annotationClass, Map<String, ? extends Object> values, List<Method> methods) {
        Intrinsics.checkNotNullParameter(annotationClass, "annotationClass");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(methods, "methods");
        Lazy hashCode$delegate = LazyKt.lazy(new Function0(values) { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$0
            private final Map arg$0;

            {
                this.arg$0 = values;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                int createAnnotationInstance$lambda$2;
                createAnnotationInstance$lambda$2 = AnnotationConstructorCallerKt.createAnnotationInstance$lambda$2(this.arg$0);
                return Integer.valueOf(createAnnotationInstance$lambda$2);
            }
        });
        Lazy toString$delegate = LazyKt.lazy(new Function0(annotationClass, values) { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$1
            private final Class arg$0;
            private final Map arg$1;

            {
                this.arg$0 = annotationClass;
                this.arg$1 = values;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                String createAnnotationInstance$lambda$4;
                createAnnotationInstance$lambda$4 = AnnotationConstructorCallerKt.createAnnotationInstance$lambda$4(this.arg$0, this.arg$1);
                return createAnnotationInstance$lambda$4;
            }
        });
        T t = (T) Proxy.newProxyInstance(annotationClass.getClassLoader(), new Class[]{annotationClass}, new InvocationHandler(annotationClass, values, toString$delegate, hashCode$delegate, methods) { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$2
            private final Class arg$0;
            private final Map arg$1;
            private final Lazy arg$2;
            private final Lazy arg$3;
            private final List arg$4;

            {
                this.arg$0 = annotationClass;
                this.arg$1 = values;
                this.arg$2 = toString$delegate;
                this.arg$3 = hashCode$delegate;
                this.arg$4 = methods;
            }

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                Object createAnnotationInstance$lambda$6;
                createAnnotationInstance$lambda$6 = AnnotationConstructorCallerKt.createAnnotationInstance$lambda$6(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4, obj, method, objArr);
                return createAnnotationInstance$lambda$6;
            }
        });
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return t;
    }

    private static final int createAnnotationInstance$lambda$3(Lazy<Integer> lazy) {
        return ((Number) lazy.getValue()).intValue();
    }

    public static final int createAnnotationInstance$lambda$2(Map $values) {
        int valueHash;
        int i = 0;
        for (Map.Entry entry : $values.entrySet()) {
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof boolean[]) {
                valueHash = Arrays.hashCode((boolean[]) value);
            } else if (value instanceof char[]) {
                valueHash = Arrays.hashCode((char[]) value);
            } else if (value instanceof byte[]) {
                valueHash = Arrays.hashCode((byte[]) value);
            } else if (value instanceof short[]) {
                valueHash = Arrays.hashCode((short[]) value);
            } else if (value instanceof int[]) {
                valueHash = Arrays.hashCode((int[]) value);
            } else if (value instanceof float[]) {
                valueHash = Arrays.hashCode((float[]) value);
            } else if (value instanceof long[]) {
                valueHash = Arrays.hashCode((long[]) value);
            } else if (value instanceof double[]) {
                valueHash = Arrays.hashCode((double[]) value);
            } else {
                valueHash = value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode();
            }
            i += (key.hashCode() * WorkQueueKt.MASK) ^ valueHash;
        }
        return i;
    }

    private static final String createAnnotationInstance$lambda$5(Lazy<String> lazy) {
        return (String) lazy.getValue();
    }

    public static final String createAnnotationInstance$lambda$4(Class $annotationClass, Map $values) {
        StringBuilder $this$createAnnotationInstance_u24lambda_u244_u240 = new StringBuilder();
        $this$createAnnotationInstance_u24lambda_u244_u240.append('@');
        $this$createAnnotationInstance_u24lambda_u244_u240.append($annotationClass.getCanonicalName());
        CollectionsKt.joinTo($values.entrySet(), $this$createAnnotationInstance_u24lambda_u244_u240, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : "(", (r14 & 8) != 0 ? "" : ")", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : new Function1() { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$$Lambda$3
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                CharSequence createAnnotationInstance$lambda$4$0$0;
                createAnnotationInstance$lambda$4$0$0 = AnnotationConstructorCallerKt.createAnnotationInstance$lambda$4$0$0((Map.Entry) obj);
                return createAnnotationInstance$lambda$4$0$0;
            }
        });
        return $this$createAnnotationInstance_u24lambda_u244_u240.toString();
    }

    public static final CharSequence createAnnotationInstance$lambda$4$0$0(Map.Entry entry) {
        String valueString;
        Intrinsics.checkNotNullParameter(entry, "entry");
        String key = (String) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof boolean[]) {
            valueString = Arrays.toString((boolean[]) value);
            Intrinsics.checkNotNullExpressionValue(valueString, "toString(...)");
        } else if (value instanceof char[]) {
            valueString = Arrays.toString((char[]) value);
            Intrinsics.checkNotNullExpressionValue(valueString, "toString(...)");
        } else if (value instanceof byte[]) {
            valueString = Arrays.toString((byte[]) value);
            Intrinsics.checkNotNullExpressionValue(valueString, "toString(...)");
        } else if (value instanceof short[]) {
            valueString = Arrays.toString((short[]) value);
            Intrinsics.checkNotNullExpressionValue(valueString, "toString(...)");
        } else if (value instanceof int[]) {
            valueString = Arrays.toString((int[]) value);
            Intrinsics.checkNotNullExpressionValue(valueString, "toString(...)");
        } else if (value instanceof float[]) {
            valueString = Arrays.toString((float[]) value);
            Intrinsics.checkNotNullExpressionValue(valueString, "toString(...)");
        } else if (value instanceof long[]) {
            valueString = Arrays.toString((long[]) value);
            Intrinsics.checkNotNullExpressionValue(valueString, "toString(...)");
        } else if (value instanceof double[]) {
            valueString = Arrays.toString((double[]) value);
            Intrinsics.checkNotNullExpressionValue(valueString, "toString(...)");
        } else if (value instanceof Object[]) {
            valueString = Arrays.toString((Object[]) value);
            Intrinsics.checkNotNullExpressionValue(valueString, "toString(...)");
        } else {
            valueString = value.toString();
        }
        return key + '=' + valueString;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0048, code lost:
        if (r12.length == 1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object createAnnotationInstance$lambda$6(Class $annotationClass, Map $values, Lazy $toString$delegate, Lazy $hashCode$delegate, List $methods, Object obj, Method method, Object[] args) {
        boolean z;
        String name = method.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -1776922004:
                    if (name.equals("toString")) {
                        return createAnnotationInstance$lambda$5($toString$delegate);
                    }
                    break;
                case 147696667:
                    if (name.equals("hashCode")) {
                        return Integer.valueOf(createAnnotationInstance$lambda$3($hashCode$delegate));
                    }
                    break;
                case 1444986633:
                    if (name.equals("annotationType")) {
                        return $annotationClass;
                    }
                    break;
            }
        }
        if (Intrinsics.areEqual(name, "equals")) {
            if (args != null) {
                z = true;
            }
            z = false;
            if (z) {
                return Boolean.valueOf(createAnnotationInstance$equals($annotationClass, $methods, $values, ArraysKt.single(args)));
            }
        }
        if ($values.containsKey(name)) {
            return $values.get(name);
        }
        StringBuilder append = new StringBuilder().append("Method is not supported: ").append(method).append(" (args: ");
        Object[] $this$orEmpty$iv = args;
        if ($this$orEmpty$iv == null) {
            $this$orEmpty$iv = new Object[0];
        }
        throw new KotlinReflectionInternalError(append.append(ArraysKt.toList($this$orEmpty$iv)).append(')').toString());
    }
}