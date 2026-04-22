package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference;
import kotlin.jvm.internal.RepeatableContainer;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.TypedArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.apache.commons.io.FilenameUtils;

/* compiled from: util.kt */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005*\u00020\u0006H\u0000\u001a$\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0000\u001a.\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0014\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0005*\u0006\u0012\u0002\b\u00030\u0005H\u0000\u001a\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u0014H\u0000\u001a\u0012\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u0018H\u0000\u001a\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\b\u0012\u0004\u0012\u00020\u00170\u0016\u001a\u000e\u0010\u001a\u001a\u0004\u0018\u00010\u0017*\u00020\u001bH\u0002\u001a\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\r\u001a\u00020\bH\u0002\u001a\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001d*\u00020 2\u0006\u0010\r\u001a\u00020\bH\u0002\u001a%\u0010!\u001a\u0002H\"\"\u0004\b\u0000\u0010\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010%\u001a\u0010\u0010&\u001a\u0004\u0018\u00010'*\u0004\u0018\u00010\u001dH\u0000\u001a\u0014\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010)*\u0004\u0018\u00010\u001dH\u0000\u001a\u0014\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010+*\u0004\u0018\u00010\u001dH\u0000\u001al\u00101\u001a\u0002H2\"\b\b\u0000\u00103*\u000204\"\b\b\u0001\u00102*\u00020.2\n\u00105\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u00106\u001a\u0002H32\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u001d\u0010=\u001a\u0019\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u0002H3\u0012\u0004\u0012\u0002H20>¢\u0006\u0002\b@H\u0000¢\u0006\u0002\u0010A\u001a\u0012\u0010H\u001a\u0004\u0018\u00010\u001d2\u0006\u0010I\u001a\u00020JH\u0000\u001a;\u0010K\u001a\u0004\u0018\u00010L*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010M\u001a\u00020\u000f2\u001a\u0010N\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050O\"\u0006\u0012\u0002\b\u00030\u0005H\u0000¢\u0006\u0002\u0010P\u001a\u001a\u0010Q\u001a\u0004\u0018\u00010R*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010M\u001a\u00020\u000fH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010,\u001a\u0004\u0018\u00010-*\u00020.8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u00100\"\u0018\u0010B\u001a\u00020C*\u00020D8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bB\u0010E\"\u0018\u0010F\u001a\u00020C*\u00020D8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bG\u0010E\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006S"}, d2 = {"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "toJavaClass", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "loadClass", "Ljava/lang/ClassLoader;", "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "arrayDimensions", "", "classLoader", "packageName", "", "className", "createArrayType", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "unwrapRepeatableAnnotations", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toRuntimeValue", "", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "arrayToRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ArrayValue;", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "isInlineClassType", "", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)Z", "needsMultiFieldValueClassFlattening", "getNeedsMultiFieldValueClassFlattening", "defaultPrimitiveValue", "type", "Ljava/lang/reflect/Type;", "getDeclaredMethodOrNull", "Ljava/lang/reflect/Method;", "name", "parameterTypes", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getDeclaredFieldOrNull", "Ljava/lang/reflect/Field;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UtilKt {
    private static final FqName JVM_STATIC = new FqName("kotlin.jvm.JvmStatic");

    /* compiled from: util.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            try {
                iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PrimitiveType.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PrimitiveType.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PrimitiveType.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[PrimitiveType.INT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[PrimitiveType.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final FqName getJVM_STATIC() {
        return JVM_STATIC;
    }

    public static final Class<?> toJavaClass(ClassDescriptor $this$toJavaClass) {
        Intrinsics.checkNotNullParameter($this$toJavaClass, "<this>");
        SourceElement source = $this$toJavaClass.getSource();
        Intrinsics.checkNotNullExpressionValue(source, "getSource(...)");
        if (source instanceof KotlinJvmBinarySourceElement) {
            KotlinJvmBinaryClass binaryClass = ((KotlinJvmBinarySourceElement) source).getBinaryClass();
            Intrinsics.checkNotNull(binaryClass, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((ReflectKotlinClass) binaryClass).getKlass();
        } else if (source instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
            ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement) source).getJavaElement();
            Intrinsics.checkNotNull(javaElement, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((ReflectJavaClass) javaElement).getElement();
        } else {
            ClassId classId = DescriptorUtilsKt.getClassId($this$toJavaClass);
            if (classId == null) {
                return null;
            }
            return loadClass$default(ReflectClassUtilKt.getSafeClassLoader($this$toJavaClass.getClass()), classId, 0, 2, null);
        }
    }

    public static /* synthetic */ Class loadClass$default(ClassLoader classLoader, ClassId classId, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return loadClass(classLoader, classId, i);
    }

    public static final Class<?> loadClass(ClassLoader $this$loadClass, ClassId kotlinClassId, int arrayDimensions) {
        Intrinsics.checkNotNullParameter($this$loadClass, "<this>");
        Intrinsics.checkNotNullParameter(kotlinClassId, "kotlinClassId");
        ClassId javaClassId = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(kotlinClassId.asSingleFqName().toUnsafe());
        if (javaClassId == null) {
            javaClassId = kotlinClassId;
        }
        ClassLoader correctClassLoader = !Intrinsics.areEqual(javaClassId, kotlinClassId) ? ReflectClassUtilKt.getSafeClassLoader(Unit.class) : $this$loadClass;
        return loadClass(correctClassLoader, javaClassId.getPackageFqName().asString(), javaClassId.getRelativeClassName().asString(), arrayDimensions);
    }

    private static final Class<?> loadClass(ClassLoader classLoader, String packageName, String className, int arrayDimensions) {
        if (Intrinsics.areEqual(packageName, "kotlin")) {
            switch (className.hashCode()) {
                case -901856463:
                    if (className.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (className.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (className.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (className.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (className.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (className.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (className.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (className.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (className.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder $this$loadClass_u24lambda_u240 = new StringBuilder();
        if (arrayDimensions > 0) {
            for (int i = 0; i < arrayDimensions; i++) {
                $this$loadClass_u24lambda_u240.append("[");
            }
            $this$loadClass_u24lambda_u240.append("L");
        }
        if (packageName.length() > 0) {
            $this$loadClass_u24lambda_u240.append(packageName + FilenameUtils.EXTENSION_SEPARATOR);
        }
        $this$loadClass_u24lambda_u240.append(StringsKt.replace$default(className, (char) FilenameUtils.EXTENSION_SEPARATOR, (char) Typography.dollar, false, 4, (Object) null));
        if (arrayDimensions > 0) {
            $this$loadClass_u24lambda_u240.append(";");
        }
        String fqName = $this$loadClass_u24lambda_u240.toString();
        return ReflectJavaClassFinderKt.tryLoadClass(classLoader, fqName);
    }

    public static final Class<?> createArrayType(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    public static final KVisibility toKVisibility(DescriptorVisibility $this$toKVisibility) {
        Intrinsics.checkNotNullParameter($this$toKVisibility, "<this>");
        if (Intrinsics.areEqual($this$toKVisibility, DescriptorVisibilities.PUBLIC)) {
            return KVisibility.PUBLIC;
        }
        if (Intrinsics.areEqual($this$toKVisibility, DescriptorVisibilities.PROTECTED)) {
            return KVisibility.PROTECTED;
        }
        if (Intrinsics.areEqual($this$toKVisibility, DescriptorVisibilities.INTERNAL)) {
            return KVisibility.INTERNAL;
        }
        if (Intrinsics.areEqual($this$toKVisibility, DescriptorVisibilities.PRIVATE) || Intrinsics.areEqual($this$toKVisibility, DescriptorVisibilities.PRIVATE_TO_THIS)) {
            return KVisibility.PRIVATE;
        }
        return null;
    }

    public static final List<Annotation> computeAnnotations(Annotated $this$computeAnnotations) {
        Iterable $this$mapNotNull$iv;
        Annotation annotationInstance;
        Intrinsics.checkNotNullParameter($this$computeAnnotations, "<this>");
        Iterable $this$mapNotNull$iv2 = $this$computeAnnotations.getAnnotations();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv2) {
            AnnotationDescriptor it = (AnnotationDescriptor) element$iv$iv$iv;
            SourceElement source = it.getSource();
            if (source instanceof ReflectAnnotationSource) {
                annotationInstance = ((ReflectAnnotationSource) source).getAnnotation();
                $this$mapNotNull$iv = $this$mapNotNull$iv2;
            } else if (source instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
                ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement) source).getJavaElement();
                $this$mapNotNull$iv = $this$mapNotNull$iv2;
                ReflectJavaAnnotation reflectJavaAnnotation = javaElement instanceof ReflectJavaAnnotation ? (ReflectJavaAnnotation) javaElement : null;
                annotationInstance = reflectJavaAnnotation != null ? reflectJavaAnnotation.getAnnotation() : null;
            } else {
                $this$mapNotNull$iv = $this$mapNotNull$iv2;
                annotationInstance = toAnnotationInstance(it);
            }
            if (annotationInstance != null) {
                destination$iv$iv.add(annotationInstance);
            }
            $this$mapNotNull$iv2 = $this$mapNotNull$iv;
        }
        return unwrapRepeatableAnnotations((List) destination$iv$iv);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final List<Annotation> unwrapRepeatableAnnotations(List<? extends Annotation> list) {
        boolean z;
        Iterable listOf;
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<? extends Annotation> $this$any$iv = list;
        if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
            Iterator it = $this$any$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    if (Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass((Annotation) element$iv)).getSimpleName(), "Container")) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        } else {
            z = false;
        }
        if (z) {
            List<? extends Annotation> $this$flatMap$iv = list;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$flatMap$iv) {
                Annotation it2 = (Annotation) element$iv$iv;
                Class klass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(it2));
                if (Intrinsics.areEqual(klass.getSimpleName(), "Container") && klass.getAnnotation(RepeatableContainer.class) != null) {
                    Object invoke = klass.getDeclaredMethod("value", new Class[0]).invoke(it2, new Object[0]);
                    Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                    listOf = ArraysKt.asList((Annotation[]) invoke);
                } else {
                    listOf = CollectionsKt.listOf(it2);
                }
                Iterable list$iv$iv = listOf;
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            return (List) destination$iv$iv;
        }
        return list;
    }

    private static final Annotation toAnnotationInstance(AnnotationDescriptor $this$toAnnotationInstance) {
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass($this$toAnnotationInstance);
        Class annotationClass2 = annotationClass != null ? toJavaClass(annotationClass) : null;
        if (!(annotationClass2 instanceof Class)) {
            annotationClass2 = null;
        }
        if (annotationClass2 == null) {
            return null;
        }
        Iterable $this$mapNotNull$iv = $this$toAnnotationInstance.getAllValueArguments().entrySet();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Map.Entry entry = (Map.Entry) element$iv$iv$iv;
            Name name = (Name) entry.getKey();
            ConstantValue value = (ConstantValue) entry.getValue();
            ClassLoader classLoader = annotationClass2.getClassLoader();
            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            Intrinsics.checkNotNullExpressionValue(classLoader, "getClassLoader(...)");
            Object p0 = toRuntimeValue(value, classLoader);
            Pair pair = p0 != null ? TuplesKt.to(name.asString(), p0) : null;
            if (pair != null) {
                destination$iv$iv.add(pair);
            }
            $this$mapNotNull$iv = $this$mapNotNull$iv2;
        }
        return (Annotation) AnnotationConstructorCallerKt.createAnnotationInstance$default(annotationClass2, MapsKt.toMap((List) destination$iv$iv), null, 4, null);
    }

    private static final Object toRuntimeValue(ConstantValue<?> constantValue, ClassLoader classLoader) {
        if (constantValue instanceof AnnotationValue) {
            return toAnnotationInstance(((AnnotationValue) constantValue).getValue());
        }
        if (constantValue instanceof ArrayValue) {
            return arrayToRuntimeValue((ArrayValue) constantValue, classLoader);
        }
        if (constantValue instanceof EnumValue) {
            Pair<? extends ClassId, ? extends Name> value = ((EnumValue) constantValue).getValue();
            ClassId enumClassId = (ClassId) value.component1();
            Name entryName = (Name) value.component2();
            Class enumClass = loadClass$default(classLoader, enumClassId, 0, 2, null);
            if (enumClass != null) {
                return Util.getEnumConstantByName(enumClass, entryName.asString());
            }
            return null;
        } else if (constantValue instanceof KClassValue) {
            KClassValue.Value classValue = ((KClassValue) constantValue).getValue();
            if (classValue instanceof KClassValue.Value.NormalClass) {
                return loadClass(classLoader, ((KClassValue.Value.NormalClass) classValue).getClassId(), ((KClassValue.Value.NormalClass) classValue).getArrayDimensions());
            }
            if (!(classValue instanceof KClassValue.Value.LocalClass)) {
                throw new NoWhenBranchMatchedException();
            }
            ClassifierDescriptor mo1171getDeclarationDescriptor = ((KClassValue.Value.LocalClass) classValue).getType().getConstructor().mo1171getDeclarationDescriptor();
            ClassDescriptor classDescriptor = mo1171getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo1171getDeclarationDescriptor : null;
            return classDescriptor != null ? toJavaClass(classDescriptor) : null;
        } else if ((constantValue instanceof ErrorValue) || (constantValue instanceof NullValue)) {
            return null;
        } else {
            return constantValue.getValue();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Object arrayToRuntimeValue(ArrayValue $this$arrayToRuntimeValue, ClassLoader classLoader) {
        KotlinType type;
        Class argClass;
        TypedArrayValue typedArrayValue = $this$arrayToRuntimeValue instanceof TypedArrayValue ? (TypedArrayValue) $this$arrayToRuntimeValue : null;
        if (typedArrayValue == null || (type = typedArrayValue.getType()) == null) {
            return null;
        }
        Iterable $this$map$iv = $this$arrayToRuntimeValue.getValue();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(toRuntimeValue((ConstantValue) item$iv$iv, classLoader));
        }
        List values = (List) destination$iv$iv;
        PrimitiveType primitiveArrayElementType = KotlinBuiltIns.getPrimitiveArrayElementType(type);
        int i = 0;
        switch (primitiveArrayElementType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[primitiveArrayElementType.ordinal()]) {
            case -1:
                if (!KotlinBuiltIns.isArray(type)) {
                    throw new IllegalStateException(("Not an array type: " + type).toString());
                }
                KotlinType argType = ((TypeProjection) CollectionsKt.single((List<? extends Object>) type.getArguments())).getType();
                Intrinsics.checkNotNullExpressionValue(argType, "getType(...)");
                ClassifierDescriptor mo1171getDeclarationDescriptor = argType.getConstructor().mo1171getDeclarationDescriptor();
                ClassDescriptor classifier = mo1171getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo1171getDeclarationDescriptor : null;
                if (classifier == null) {
                    throw new IllegalStateException(("Not a class type: " + argType).toString());
                }
                if (KotlinBuiltIns.isString(argType)) {
                    int size = $this$arrayToRuntimeValue.getValue().size();
                    String[] strArr = new String[size];
                    while (i < size) {
                        Object obj = values.get(i);
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        strArr[i] = obj;
                        i++;
                    }
                    return strArr;
                } else if (KotlinBuiltIns.isKClass(classifier)) {
                    int size2 = $this$arrayToRuntimeValue.getValue().size();
                    Class[] clsArr = new Class[size2];
                    while (i < size2) {
                        Object obj2 = values.get(i);
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.lang.Class<*>");
                        clsArr[i] = obj2;
                        i++;
                    }
                    return clsArr;
                } else {
                    ClassId p0 = DescriptorUtilsKt.getClassId(classifier);
                    if (p0 == null || (argClass = loadClass$default(classLoader, p0, 0, 2, null)) == null) {
                        return null;
                    }
                    Object newInstance = Array.newInstance(argClass, $this$arrayToRuntimeValue.getValue().size());
                    Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
                    Object[] array = (Object[]) newInstance;
                    int size3 = values.size();
                    while (i < size3) {
                        int it = i;
                        array[it] = values.get(it);
                        i++;
                    }
                    return array;
                }
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                int size4 = $this$arrayToRuntimeValue.getValue().size();
                boolean[] zArr = new boolean[size4];
                while (i < size4) {
                    Object obj3 = values.get(i);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    zArr[i] = ((Boolean) obj3).booleanValue();
                    i++;
                }
                return zArr;
            case 2:
                int size5 = $this$arrayToRuntimeValue.getValue().size();
                char[] cArr = new char[size5];
                while (i < size5) {
                    Object obj4 = values.get(i);
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Char");
                    cArr[i] = ((Character) obj4).charValue();
                    i++;
                }
                return cArr;
            case 3:
                int size6 = $this$arrayToRuntimeValue.getValue().size();
                byte[] bArr = new byte[size6];
                while (i < size6) {
                    Object obj5 = values.get(i);
                    Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Byte");
                    bArr[i] = ((Byte) obj5).byteValue();
                    i++;
                }
                return bArr;
            case 4:
                int size7 = $this$arrayToRuntimeValue.getValue().size();
                short[] sArr = new short[size7];
                while (i < size7) {
                    Object obj6 = values.get(i);
                    Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Short");
                    sArr[i] = ((Short) obj6).shortValue();
                    i++;
                }
                return sArr;
            case 5:
                int size8 = $this$arrayToRuntimeValue.getValue().size();
                int[] iArr = new int[size8];
                while (i < size8) {
                    Object obj7 = values.get(i);
                    Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Int");
                    iArr[i] = ((Integer) obj7).intValue();
                    i++;
                }
                return iArr;
            case 6:
                int size9 = $this$arrayToRuntimeValue.getValue().size();
                float[] fArr = new float[size9];
                while (i < size9) {
                    Object obj8 = values.get(i);
                    Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.Float");
                    fArr[i] = ((Float) obj8).floatValue();
                    i++;
                }
                return fArr;
            case 7:
                int size10 = $this$arrayToRuntimeValue.getValue().size();
                long[] jArr = new long[size10];
                while (i < size10) {
                    Object obj9 = values.get(i);
                    Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type kotlin.Long");
                    jArr[i] = ((Long) obj9).longValue();
                    i++;
                }
                return jArr;
            case 8:
                int size11 = $this$arrayToRuntimeValue.getValue().size();
                double[] dArr = new double[size11];
                while (i < size11) {
                    Object obj10 = values.get(i);
                    Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type kotlin.Double");
                    dArr[i] = ((Double) obj10).doubleValue();
                    i++;
                }
                return dArr;
        }
    }

    public static final KFunctionImpl asKFunctionImpl(Object $this$asKFunctionImpl) {
        KFunctionImpl kFunctionImpl = $this$asKFunctionImpl instanceof KFunctionImpl ? (KFunctionImpl) $this$asKFunctionImpl : null;
        if (kFunctionImpl == null) {
            FunctionReference functionReference = $this$asKFunctionImpl instanceof FunctionReference ? (FunctionReference) $this$asKFunctionImpl : null;
            KCallable compute = functionReference != null ? functionReference.compute() : null;
            if (compute instanceof KFunctionImpl) {
                return (KFunctionImpl) compute;
            }
            return null;
        }
        return kFunctionImpl;
    }

    public static final KPropertyImpl<?> asKPropertyImpl(Object $this$asKPropertyImpl) {
        KPropertyImpl<?> kPropertyImpl = $this$asKPropertyImpl instanceof KPropertyImpl ? (KPropertyImpl) $this$asKPropertyImpl : null;
        if (kPropertyImpl == null) {
            PropertyReference propertyReference = $this$asKPropertyImpl instanceof PropertyReference ? (PropertyReference) $this$asKPropertyImpl : null;
            KCallable compute = propertyReference != null ? propertyReference.compute() : null;
            if (compute instanceof KPropertyImpl) {
                return (KPropertyImpl) compute;
            }
            return null;
        }
        return kPropertyImpl;
    }

    public static final KCallableImpl<?> asKCallableImpl(Object $this$asKCallableImpl) {
        KCallableImpl<?> kCallableImpl = $this$asKCallableImpl instanceof KCallableImpl ? (KCallableImpl) $this$asKCallableImpl : null;
        if (kCallableImpl == null) {
            KCallableImpl<?> asKFunctionImpl = asKFunctionImpl($this$asKCallableImpl);
            if (asKFunctionImpl == null) {
                asKFunctionImpl = asKPropertyImpl($this$asKCallableImpl);
            }
            return asKFunctionImpl;
        }
        return kCallableImpl;
    }

    public static final ReceiverParameterDescriptor getInstanceReceiverParameter(CallableDescriptor $this$instanceReceiverParameter) {
        Intrinsics.checkNotNullParameter($this$instanceReceiverParameter, "<this>");
        if ($this$instanceReceiverParameter.getDispatchReceiverParameter() != null) {
            DeclarationDescriptor containingDeclaration = $this$instanceReceiverParameter.getContainingDeclaration();
            Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return ((ClassDescriptor) containingDeclaration).getThisAsReceiverParameter();
        }
        return null;
    }

    public static final <M extends MessageLite, D extends CallableDescriptor> D deserializeToDescriptor(Class<?> moduleAnchor, M proto, NameResolver nameResolver, TypeTable typeTable, BinaryVersion metadataVersion, Function2<? super MemberDeserializer, ? super M, ? extends D> createDescriptor) {
        List typeParameters;
        Intrinsics.checkNotNullParameter(moduleAnchor, "moduleAnchor");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(createDescriptor, "createDescriptor");
        RuntimeModuleData moduleData = ModuleByClassLoaderKt.getOrCreateModule(moduleAnchor);
        if (proto instanceof ProtoBuf.Function) {
            typeParameters = ((ProtoBuf.Function) proto).getTypeParameterList();
        } else if (!(proto instanceof ProtoBuf.Property)) {
            throw new IllegalStateException(("Unsupported message: " + proto).toString());
        } else {
            typeParameters = ((ProtoBuf.Property) proto).getTypeParameterList();
        }
        DeserializationComponents deserialization = moduleData.getDeserialization();
        ModuleDescriptor module = moduleData.getModule();
        VersionRequirementTable empty = VersionRequirementTable.Companion.getEMPTY();
        Intrinsics.checkNotNull(typeParameters);
        DeserializationContext context = new DeserializationContext(deserialization, nameResolver, module, typeTable, empty, metadataVersion, null, null, typeParameters);
        return createDescriptor.invoke(new MemberDeserializer(context), proto);
    }

    public static final boolean isInlineClassType(KType $this$isInlineClassType) {
        Intrinsics.checkNotNullParameter($this$isInlineClassType, "<this>");
        KClassifier classifier = $this$isInlineClassType.getClassifier();
        KClassImpl kClassImpl = classifier instanceof KClassImpl ? (KClassImpl) classifier : null;
        return kClassImpl != null && kClassImpl.isInline$kotlin_reflection();
    }

    public static final boolean getNeedsMultiFieldValueClassFlattening(KType $this$needsMultiFieldValueClassFlattening) {
        Intrinsics.checkNotNullParameter($this$needsMultiFieldValueClassFlattening, "<this>");
        KClassifier classifier = $this$needsMultiFieldValueClassFlattening.getClassifier();
        KClassImpl $this$_get_needsMultiFieldValueClassFlattening__u24lambda_u240 = classifier instanceof KClassImpl ? (KClassImpl) classifier : null;
        if ($this$_get_needsMultiFieldValueClassFlattening__u24lambda_u240 != null) {
            return ((!$this$_get_needsMultiFieldValueClassFlattening__u24lambda_u240.isValue() || $this$_get_needsMultiFieldValueClassFlattening__u24lambda_u240.isInline$kotlin_reflection()) ? null : 1) == 1;
        }
        return false;
    }

    public static final Object defaultPrimitiveValue(Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            Class cls = (Class) type;
            if (Intrinsics.areEqual(cls, Boolean.TYPE)) {
                return false;
            }
            if (Intrinsics.areEqual(cls, Character.TYPE)) {
                return (char) 0;
            }
            if (Intrinsics.areEqual(cls, Byte.TYPE)) {
                return (byte) 0;
            }
            if (Intrinsics.areEqual(cls, Short.TYPE)) {
                return (short) 0;
            }
            if (Intrinsics.areEqual(cls, Integer.TYPE)) {
                return 0;
            }
            if (Intrinsics.areEqual(cls, Float.TYPE)) {
                return Float.valueOf(0.0f);
            }
            if (Intrinsics.areEqual(cls, Long.TYPE)) {
                return 0L;
            }
            if (Intrinsics.areEqual(cls, Double.TYPE)) {
                return Double.valueOf(0.0d);
            }
            if (Intrinsics.areEqual(cls, Void.TYPE)) {
                throw new IllegalStateException("Parameter with void type is illegal");
            }
            throw new UnsupportedOperationException("Unknown primitive: " + type);
        }
        return null;
    }

    public static final Method getDeclaredMethodOrNull(Class<?> cls, String name, Class<?>... parameterTypes) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        try {
            return cls.getDeclaredMethod(name, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static final Field getDeclaredFieldOrNull(Class<?> cls, String name) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            return cls.getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}