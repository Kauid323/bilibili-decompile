package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReflectKotlinClass.kt */
public final class ReflectClassStructure {
    public static final ReflectClassStructure INSTANCE = new ReflectClassStructure();

    private ReflectClassStructure() {
    }

    public final void loadClassAnnotations(Class<?> klass, KotlinJvmBinaryClass.AnnotationVisitor visitor) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        Annotation[] declaredAnnotations = klass.getDeclaredAnnotations();
        Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "getDeclaredAnnotations(...)");
        for (Annotation annotation : declaredAnnotations) {
            Intrinsics.checkNotNull(annotation);
            processAnnotation(visitor, annotation);
        }
        visitor.visitEnd();
    }

    public final void visitMembers(Class<?> klass, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(memberVisitor, "memberVisitor");
        loadMethodAnnotations(klass, memberVisitor);
        loadConstructorAnnotations(klass, memberVisitor);
        loadFieldAnnotations(klass, memberVisitor);
    }

    private final void loadMethodAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Method[] methodArr;
        int i;
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        int length = declaredMethods.length;
        int i2 = 0;
        while (i2 < length) {
            Method method = declaredMethods[i2];
            Name identifier = Name.identifier(method.getName());
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            Intrinsics.checkNotNull(method);
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitor = memberVisitor.visitMethod(identifier, signatureSerializer.methodDesc(method));
            if (visitor == null) {
                methodArr = declaredMethods;
                i = length;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "getDeclaredAnnotations(...)");
                for (Annotation annotation : declaredAnnotations) {
                    Intrinsics.checkNotNull(annotation);
                    processAnnotation(visitor, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "getParameterAnnotations(...)");
                Annotation[][] annotationArr = parameterAnnotations;
                int length2 = annotationArr.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    int parameterIndex = i3;
                    Annotation[] annotations = annotationArr[i3];
                    Intrinsics.checkNotNull(annotations);
                    int length3 = annotations.length;
                    int i4 = 0;
                    while (i4 < length3) {
                        Annotation annotation2 = annotations[i4];
                        Class annotationType = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation2));
                        Method[] methodArr2 = declaredMethods;
                        ClassId classId = ReflectClassUtilKt.getClassId(annotationType);
                        int i5 = length;
                        Intrinsics.checkNotNull(annotation2);
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor it = visitor.visitParameterAnnotation(parameterIndex, classId, new ReflectAnnotationSource(annotation2));
                        if (it != null) {
                            INSTANCE.processAnnotationArguments(it, annotation2, annotationType);
                        }
                        i4++;
                        declaredMethods = methodArr2;
                        length = i5;
                    }
                }
                methodArr = declaredMethods;
                i = length;
                visitor.visitEnd();
            }
            i2++;
            declaredMethods = methodArr;
            length = i;
        }
    }

    private final void loadConstructorAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Constructor<?>[] constructorArr;
        int i;
        Constructor[] declaredConstructors = cls.getDeclaredConstructors();
        Intrinsics.checkNotNullExpressionValue(declaredConstructors, "getDeclaredConstructors(...)");
        int length = declaredConstructors.length;
        int i2 = 0;
        while (i2 < length) {
            Constructor constructor = declaredConstructors[i2];
            Name name = SpecialNames.INIT;
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            Intrinsics.checkNotNull(constructor);
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitor = memberVisitor.visitMethod(name, signatureSerializer.constructorDesc(constructor));
            if (visitor == null) {
                constructorArr = declaredConstructors;
                i = length;
            } else {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "getDeclaredAnnotations(...)");
                for (Annotation annotation : declaredAnnotations) {
                    Intrinsics.checkNotNull(annotation);
                    processAnnotation(visitor, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                Intrinsics.checkNotNull(parameterAnnotations);
                if (parameterAnnotations.length == 0) {
                    constructorArr = declaredConstructors;
                    i = length;
                } else {
                    int shift = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length2 = parameterAnnotations.length;
                    for (int i3 = 0; i3 < length2; i3++) {
                        int parameterIndex = i3;
                        Annotation[] annotations = parameterAnnotations[i3];
                        Intrinsics.checkNotNull(annotations);
                        int length3 = annotations.length;
                        int i4 = 0;
                        while (i4 < length3) {
                            Annotation annotation2 = annotations[i4];
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            Class annotationType = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation2));
                            int i5 = length;
                            Constructor constructor2 = constructor;
                            ClassId classId = ReflectClassUtilKt.getClassId(annotationType);
                            Annotation[][] parameterAnnotations2 = parameterAnnotations;
                            Intrinsics.checkNotNull(annotation2);
                            KotlinJvmBinaryClass.AnnotationArgumentVisitor it = visitor.visitParameterAnnotation(parameterIndex + shift, classId, new ReflectAnnotationSource(annotation2));
                            if (it != null) {
                                INSTANCE.processAnnotationArguments(it, annotation2, annotationType);
                            }
                            i4++;
                            length = i5;
                            declaredConstructors = constructorArr2;
                            constructor = constructor2;
                            parameterAnnotations = parameterAnnotations2;
                        }
                    }
                    constructorArr = declaredConstructors;
                    i = length;
                }
                visitor.visitEnd();
            }
            i2++;
            length = i;
            declaredConstructors = constructorArr;
        }
    }

    private final void loadFieldAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        for (Field field : declaredFields) {
            Name identifier = Name.identifier(field.getName());
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            Intrinsics.checkNotNull(field);
            KotlinJvmBinaryClass.AnnotationVisitor visitor = memberVisitor.visitField(identifier, signatureSerializer.fieldDesc(field), null);
            if (visitor != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "getDeclaredAnnotations(...)");
                for (Annotation annotation : declaredAnnotations) {
                    Intrinsics.checkNotNull(annotation);
                    processAnnotation(visitor, annotation);
                }
                visitor.visitEnd();
            }
        }
    }

    private final void processAnnotation(KotlinJvmBinaryClass.AnnotationVisitor visitor, Annotation annotation) {
        Class annotationType = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation));
        KotlinJvmBinaryClass.AnnotationArgumentVisitor it = visitor.visitAnnotation(ReflectClassUtilKt.getClassId(annotationType), new ReflectAnnotationSource(annotation));
        if (it != null) {
            INSTANCE.processAnnotationArguments(it, annotation, annotationType);
        }
    }

    private final void processAnnotationArguments(KotlinJvmBinaryClass.AnnotationArgumentVisitor visitor, Annotation annotation, Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        for (Method method : declaredMethods) {
            try {
                Object value = method.invoke(annotation, new Object[0]);
                Intrinsics.checkNotNull(value);
                Name identifier = Name.identifier(method.getName());
                Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
                processAnnotationArgumentValue(visitor, identifier, value);
            } catch (IllegalAccessException e) {
            }
        }
        visitor.visitEnd();
    }

    private final ClassLiteralValue classLiteralValue(Class<?> cls) {
        Class currentClass = cls;
        int dimensions = 0;
        while (currentClass.isArray()) {
            dimensions++;
            Class componentType = currentClass.getComponentType();
            Intrinsics.checkNotNullExpressionValue(componentType, "getComponentType(...)");
            currentClass = componentType;
        }
        if (currentClass.isPrimitive()) {
            if (Intrinsics.areEqual(currentClass, Void.TYPE)) {
                return new ClassLiteralValue(ClassId.Companion.topLevel(StandardNames.FqNames.unit.toSafe()), dimensions);
            }
            PrimitiveType primitiveType = JvmPrimitiveType.get(currentClass.getName()).getPrimitiveType();
            Intrinsics.checkNotNullExpressionValue(primitiveType, "getPrimitiveType(...)");
            if (dimensions > 0) {
                return new ClassLiteralValue(ClassId.Companion.topLevel(primitiveType.getArrayTypeFqName()), dimensions - 1);
            }
            return new ClassLiteralValue(ClassId.Companion.topLevel(primitiveType.getTypeFqName()), dimensions);
        }
        ClassId javaClassId = ReflectClassUtilKt.getClassId(currentClass);
        ClassId kotlinClassId = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(javaClassId.asSingleFqName());
        if (kotlinClassId == null) {
            kotlinClassId = javaClassId;
        }
        return new ClassLiteralValue(kotlinClassId, dimensions);
    }

    private final void processAnnotationArgumentValue(KotlinJvmBinaryClass.AnnotationArgumentVisitor visitor, Name name, Object value) {
        Set set;
        Class clazz = value.getClass();
        if (!Intrinsics.areEqual(clazz, Class.class)) {
            set = ReflectKotlinClassKt.TYPES_ELIGIBLE_FOR_SIMPLE_VISIT;
            if (set.contains(clazz)) {
                visitor.visit(name, value);
                return;
            } else if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(clazz)) {
                Class enclosingClass = clazz.isEnum() ? clazz : clazz.getEnclosingClass();
                Intrinsics.checkNotNull(enclosingClass);
                ClassId classId = ReflectClassUtilKt.getClassId(enclosingClass);
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Enum<*>");
                Name identifier = Name.identifier(((Enum) value).name());
                Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
                visitor.visitEnum(name, classId, identifier);
                return;
            } else if (Annotation.class.isAssignableFrom(clazz)) {
                Class<?>[] interfaces = clazz.getInterfaces();
                Intrinsics.checkNotNullExpressionValue(interfaces, "getInterfaces(...)");
                Class annotationClass = (Class) ArraysKt.single(interfaces);
                Intrinsics.checkNotNull(annotationClass);
                KotlinJvmBinaryClass.AnnotationArgumentVisitor v = visitor.visitAnnotation(name, ReflectClassUtilKt.getClassId(annotationClass));
                if (v == null) {
                    return;
                }
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Annotation");
                processAnnotationArguments(v, (Annotation) value, annotationClass);
                return;
            } else if (clazz.isArray()) {
                KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor v2 = visitor.visitArray(name);
                if (v2 == null) {
                    return;
                }
                Class componentType = clazz.getComponentType();
                int i = 0;
                if (componentType.isEnum()) {
                    Intrinsics.checkNotNull(componentType);
                    ClassId enumClassId = ReflectClassUtilKt.getClassId(componentType);
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr = (Object[]) value;
                    int length = objArr.length;
                    while (i < length) {
                        Object element = objArr[i];
                        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type kotlin.Enum<*>");
                        Name identifier2 = Name.identifier(((Enum) element).name());
                        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(...)");
                        v2.visitEnum(enumClassId, identifier2);
                        i++;
                    }
                } else if (Intrinsics.areEqual(componentType, Class.class)) {
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr2 = (Object[]) value;
                    int length2 = objArr2.length;
                    while (i < length2) {
                        Object element2 = objArr2[i];
                        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type java.lang.Class<*>");
                        v2.visitClassLiteral(classLiteralValue((Class) element2));
                        i++;
                    }
                } else if (Annotation.class.isAssignableFrom(componentType)) {
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr3 = (Object[]) value;
                    int length3 = objArr3.length;
                    while (i < length3) {
                        Object element3 = objArr3[i];
                        Intrinsics.checkNotNull(componentType);
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor vv = v2.visitAnnotation(ReflectClassUtilKt.getClassId(componentType));
                        if (vv != null) {
                            Intrinsics.checkNotNull(element3, "null cannot be cast to non-null type kotlin.Annotation");
                            processAnnotationArguments(vv, (Annotation) element3, componentType);
                        }
                        i++;
                    }
                } else {
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr4 = (Object[]) value;
                    int length4 = objArr4.length;
                    while (i < length4) {
                        v2.visit(objArr4[i]);
                        i++;
                    }
                }
                v2.visitEnd();
                return;
            } else {
                throw new UnsupportedOperationException("Unsupported annotation argument value (" + clazz + "): " + value);
            }
        }
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type java.lang.Class<*>");
        visitor.visitClassLiteral(name, classLiteralValue((Class) value));
    }
}