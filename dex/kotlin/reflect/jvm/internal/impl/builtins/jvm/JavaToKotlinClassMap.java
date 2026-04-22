package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* compiled from: JavaToKotlinClassMap.kt */
public final class JavaToKotlinClassMap {
    private static final List<PlatformMutabilityMapping> mutabilityMappings;
    public static final JavaToKotlinClassMap INSTANCE = new JavaToKotlinClassMap();
    private static final String NUMBERED_FUNCTION_PREFIX = FunctionTypeKind.Function.INSTANCE.getPackageFqName() + FilenameUtils.EXTENSION_SEPARATOR + FunctionTypeKind.Function.INSTANCE.getClassNamePrefix();
    private static final String NUMBERED_K_FUNCTION_PREFIX = FunctionTypeKind.KFunction.INSTANCE.getPackageFqName() + FilenameUtils.EXTENSION_SEPARATOR + FunctionTypeKind.KFunction.INSTANCE.getClassNamePrefix();
    private static final String NUMBERED_SUSPEND_FUNCTION_PREFIX = FunctionTypeKind.SuspendFunction.INSTANCE.getPackageFqName() + FilenameUtils.EXTENSION_SEPARATOR + FunctionTypeKind.SuspendFunction.INSTANCE.getClassNamePrefix();
    private static final String NUMBERED_K_SUSPEND_FUNCTION_PREFIX = FunctionTypeKind.KSuspendFunction.INSTANCE.getPackageFqName() + FilenameUtils.EXTENSION_SEPARATOR + FunctionTypeKind.KSuspendFunction.INSTANCE.getClassNamePrefix();
    private static final ClassId FUNCTION_N_CLASS_ID = ClassId.Companion.topLevel(new FqName("kotlin.jvm.functions.FunctionN"));
    private static final FqName FUNCTION_N_FQ_NAME = FUNCTION_N_CLASS_ID.asSingleFqName();
    private static final ClassId K_FUNCTION_CLASS_ID = StandardClassIds.INSTANCE.getKFunction();
    private static final ClassId K_CLASS_CLASS_ID = StandardClassIds.INSTANCE.getKClass();
    private static final ClassId CLASS_CLASS_ID = INSTANCE.classId(Class.class);
    private static final HashMap<FqNameUnsafe, ClassId> javaToKotlin = new HashMap<>();
    private static final HashMap<FqNameUnsafe, ClassId> kotlinToJava = new HashMap<>();
    private static final HashMap<FqNameUnsafe, FqName> mutableToReadOnly = new HashMap<>();
    private static final HashMap<FqNameUnsafe, FqName> readOnlyToMutable = new HashMap<>();
    private static final HashMap<ClassId, ClassId> mutableToReadOnlyClassId = new HashMap<>();
    private static final HashMap<ClassId, ClassId> readOnlyToMutableClassId = new HashMap<>();

    private JavaToKotlinClassMap() {
    }

    static {
        JvmPrimitiveType[] values;
        JavaToKotlinClassMap this_$iv = INSTANCE;
        ClassId kotlinReadOnly$iv = ClassId.Companion.topLevel(StandardNames.FqNames.iterable);
        FqName kotlinMutable$iv = StandardNames.FqNames.mutableIterable;
        ClassId mutableClassId$iv = new ClassId(kotlinReadOnly$iv.getPackageFqName(), FqNamesUtilKt.tail(kotlinMutable$iv, kotlinReadOnly$iv.getPackageFqName()), false);
        JavaToKotlinClassMap this_$iv2 = INSTANCE;
        ClassId kotlinReadOnly$iv2 = ClassId.Companion.topLevel(StandardNames.FqNames.iterator);
        FqName kotlinMutable$iv2 = StandardNames.FqNames.mutableIterator;
        ClassId mutableClassId$iv2 = new ClassId(kotlinReadOnly$iv2.getPackageFqName(), FqNamesUtilKt.tail(kotlinMutable$iv2, kotlinReadOnly$iv2.getPackageFqName()), false);
        JavaToKotlinClassMap this_$iv3 = INSTANCE;
        ClassId kotlinReadOnly$iv3 = ClassId.Companion.topLevel(StandardNames.FqNames.collection);
        FqName kotlinMutable$iv3 = StandardNames.FqNames.mutableCollection;
        ClassId mutableClassId$iv3 = new ClassId(kotlinReadOnly$iv3.getPackageFqName(), FqNamesUtilKt.tail(kotlinMutable$iv3, kotlinReadOnly$iv3.getPackageFqName()), false);
        JavaToKotlinClassMap this_$iv4 = INSTANCE;
        ClassId kotlinReadOnly$iv4 = ClassId.Companion.topLevel(StandardNames.FqNames.list);
        FqName kotlinMutable$iv4 = StandardNames.FqNames.mutableList;
        ClassId mutableClassId$iv4 = new ClassId(kotlinReadOnly$iv4.getPackageFqName(), FqNamesUtilKt.tail(kotlinMutable$iv4, kotlinReadOnly$iv4.getPackageFqName()), false);
        JavaToKotlinClassMap this_$iv5 = INSTANCE;
        ClassId kotlinReadOnly$iv5 = ClassId.Companion.topLevel(StandardNames.FqNames.set);
        FqName kotlinMutable$iv5 = StandardNames.FqNames.mutableSet;
        ClassId mutableClassId$iv5 = new ClassId(kotlinReadOnly$iv5.getPackageFqName(), FqNamesUtilKt.tail(kotlinMutable$iv5, kotlinReadOnly$iv5.getPackageFqName()), false);
        JavaToKotlinClassMap this_$iv6 = INSTANCE;
        ClassId kotlinReadOnly$iv6 = ClassId.Companion.topLevel(StandardNames.FqNames.listIterator);
        FqName kotlinMutable$iv6 = StandardNames.FqNames.mutableListIterator;
        ClassId mutableClassId$iv6 = new ClassId(kotlinReadOnly$iv6.getPackageFqName(), FqNamesUtilKt.tail(kotlinMutable$iv6, kotlinReadOnly$iv6.getPackageFqName()), false);
        JavaToKotlinClassMap this_$iv7 = INSTANCE;
        ClassId kotlinReadOnly$iv7 = ClassId.Companion.topLevel(StandardNames.FqNames.map);
        FqName kotlinMutable$iv7 = StandardNames.FqNames.mutableMap;
        ClassId mutableClassId$iv7 = new ClassId(kotlinReadOnly$iv7.getPackageFqName(), FqNamesUtilKt.tail(kotlinMutable$iv7, kotlinReadOnly$iv7.getPackageFqName()), false);
        JavaToKotlinClassMap this_$iv8 = INSTANCE;
        ClassId kotlinReadOnly$iv8 = ClassId.Companion.topLevel(StandardNames.FqNames.map).createNestedClassId(StandardNames.FqNames.mapEntry.shortName());
        FqName kotlinMutable$iv8 = StandardNames.FqNames.mutableMapEntry;
        ClassId mutableClassId$iv8 = new ClassId(kotlinReadOnly$iv8.getPackageFqName(), FqNamesUtilKt.tail(kotlinMutable$iv8, kotlinReadOnly$iv8.getPackageFqName()), false);
        mutabilityMappings = CollectionsKt.listOf((Object[]) new PlatformMutabilityMapping[]{new PlatformMutabilityMapping(this_$iv.classId(Iterable.class), kotlinReadOnly$iv, mutableClassId$iv), new PlatformMutabilityMapping(this_$iv2.classId(Iterator.class), kotlinReadOnly$iv2, mutableClassId$iv2), new PlatformMutabilityMapping(this_$iv3.classId(Collection.class), kotlinReadOnly$iv3, mutableClassId$iv3), new PlatformMutabilityMapping(this_$iv4.classId(List.class), kotlinReadOnly$iv4, mutableClassId$iv4), new PlatformMutabilityMapping(this_$iv5.classId(Set.class), kotlinReadOnly$iv5, mutableClassId$iv5), new PlatformMutabilityMapping(this_$iv6.classId(ListIterator.class), kotlinReadOnly$iv6, mutableClassId$iv6), new PlatformMutabilityMapping(this_$iv7.classId(Map.class), kotlinReadOnly$iv7, mutableClassId$iv7), new PlatformMutabilityMapping(this_$iv8.classId(Map.Entry.class), kotlinReadOnly$iv8, mutableClassId$iv8)});
        INSTANCE.addTopLevel(Object.class, StandardNames.FqNames.any);
        INSTANCE.addTopLevel(String.class, StandardNames.FqNames.string);
        INSTANCE.addTopLevel(CharSequence.class, StandardNames.FqNames.charSequence);
        INSTANCE.addTopLevel(Throwable.class, StandardNames.FqNames.throwable);
        INSTANCE.addTopLevel(Cloneable.class, StandardNames.FqNames.cloneable);
        INSTANCE.addTopLevel(Number.class, StandardNames.FqNames.number);
        INSTANCE.addTopLevel(Comparable.class, StandardNames.FqNames.comparable);
        INSTANCE.addTopLevel(Enum.class, StandardNames.FqNames._enum);
        INSTANCE.addTopLevel(Annotation.class, StandardNames.FqNames.annotation);
        for (PlatformMutabilityMapping platformCollection : mutabilityMappings) {
            INSTANCE.addMapping(platformCollection);
        }
        for (JvmPrimitiveType jvmType : JvmPrimitiveType.values()) {
            JavaToKotlinClassMap javaToKotlinClassMap = INSTANCE;
            ClassId.Companion companion = ClassId.Companion;
            FqName wrapperFqName = jvmType.getWrapperFqName();
            Intrinsics.checkNotNullExpressionValue(wrapperFqName, "getWrapperFqName(...)");
            ClassId classId = companion.topLevel(wrapperFqName);
            ClassId.Companion companion2 = ClassId.Companion;
            PrimitiveType primitiveType = jvmType.getPrimitiveType();
            Intrinsics.checkNotNullExpressionValue(primitiveType, "getPrimitiveType(...)");
            javaToKotlinClassMap.add(classId, companion2.topLevel(StandardNames.getPrimitiveFqName(primitiveType)));
        }
        for (ClassId classId2 : CompanionObjectMapping.INSTANCE.allClassesWithIntrinsicCompanions()) {
            INSTANCE.add(ClassId.Companion.topLevel(new FqName("kotlin.jvm.internal." + classId2.getShortClassName().asString() + "CompanionObject")), classId2.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT));
        }
        for (int i = 0; i < 23; i++) {
            INSTANCE.add(ClassId.Companion.topLevel(new FqName("kotlin.jvm.functions.Function" + i)), StandardNames.getFunctionClassId(i));
            INSTANCE.addKotlinToJava(new FqName(NUMBERED_K_FUNCTION_PREFIX + i), K_FUNCTION_CLASS_ID);
        }
        for (int i2 = 0; i2 < 22; i2++) {
            FunctionTypeKind.KSuspendFunction kSuspendFunction = FunctionTypeKind.KSuspendFunction.INSTANCE;
            String kSuspendFun = kSuspendFunction.getPackageFqName() + FilenameUtils.EXTENSION_SEPARATOR + kSuspendFunction.getClassNamePrefix();
            INSTANCE.addKotlinToJava(new FqName(kSuspendFun + i2), K_FUNCTION_CLASS_ID);
        }
        INSTANCE.addKotlinToJava(new FqName("kotlin.concurrent.atomics.AtomicInt"), INSTANCE.classId(AtomicInteger.class));
        INSTANCE.addKotlinToJava(new FqName("kotlin.concurrent.atomics.AtomicLong"), INSTANCE.classId(AtomicLong.class));
        INSTANCE.addKotlinToJava(new FqName("kotlin.concurrent.atomics.AtomicBoolean"), INSTANCE.classId(AtomicBoolean.class));
        INSTANCE.addKotlinToJava(new FqName("kotlin.concurrent.atomics.AtomicReference"), INSTANCE.classId(AtomicReference.class));
        INSTANCE.addKotlinToJava(new FqName("kotlin.concurrent.atomics.AtomicIntArray"), INSTANCE.classId(AtomicIntegerArray.class));
        INSTANCE.addKotlinToJava(new FqName("kotlin.concurrent.atomics.AtomicLongArray"), INSTANCE.classId(AtomicLongArray.class));
        INSTANCE.addKotlinToJava(new FqName("kotlin.concurrent.atomics.AtomicArray"), INSTANCE.classId(AtomicReferenceArray.class));
        INSTANCE.addKotlinToJava(StandardNames.FqNames.nothing.toSafe(), INSTANCE.classId(Void.class));
    }

    public final FqName getFUNCTION_N_FQ_NAME() {
        return FUNCTION_N_FQ_NAME;
    }

    /* compiled from: JavaToKotlinClassMap.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class PlatformMutabilityMapping {
        private final ClassId javaClass;
        private final ClassId kotlinMutable;
        private final ClassId kotlinReadOnly;

        public final ClassId component1() {
            return this.javaClass;
        }

        public final ClassId component2() {
            return this.kotlinReadOnly;
        }

        public final ClassId component3() {
            return this.kotlinMutable;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PlatformMutabilityMapping) {
                PlatformMutabilityMapping platformMutabilityMapping = (PlatformMutabilityMapping) obj;
                return Intrinsics.areEqual(this.javaClass, platformMutabilityMapping.javaClass) && Intrinsics.areEqual(this.kotlinReadOnly, platformMutabilityMapping.kotlinReadOnly) && Intrinsics.areEqual(this.kotlinMutable, platformMutabilityMapping.kotlinMutable);
            }
            return false;
        }

        public int hashCode() {
            return (((this.javaClass.hashCode() * 31) + this.kotlinReadOnly.hashCode()) * 31) + this.kotlinMutable.hashCode();
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.javaClass + ", kotlinReadOnly=" + this.kotlinReadOnly + ", kotlinMutable=" + this.kotlinMutable + ')';
        }

        public PlatformMutabilityMapping(ClassId javaClass, ClassId kotlinReadOnly, ClassId kotlinMutable) {
            Intrinsics.checkNotNullParameter(javaClass, "javaClass");
            Intrinsics.checkNotNullParameter(kotlinReadOnly, "kotlinReadOnly");
            Intrinsics.checkNotNullParameter(kotlinMutable, "kotlinMutable");
            this.javaClass = javaClass;
            this.kotlinReadOnly = kotlinReadOnly;
            this.kotlinMutable = kotlinMutable;
        }

        public final ClassId getJavaClass() {
            return this.javaClass;
        }
    }

    public final List<PlatformMutabilityMapping> getMutabilityMappings() {
        return mutabilityMappings;
    }

    public final ClassId mapJavaToKotlin(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return javaToKotlin.get(fqName.toUnsafe());
    }

    public final ClassId mapKotlinToJava(FqNameUnsafe kotlinFqName) {
        Intrinsics.checkNotNullParameter(kotlinFqName, "kotlinFqName");
        if (!isKotlinFunctionWithBigArity(kotlinFqName, NUMBERED_FUNCTION_PREFIX) && !isKotlinFunctionWithBigArity(kotlinFqName, NUMBERED_SUSPEND_FUNCTION_PREFIX)) {
            if (!isKotlinFunctionWithBigArity(kotlinFqName, NUMBERED_K_FUNCTION_PREFIX) && !isKotlinFunctionWithBigArity(kotlinFqName, NUMBERED_K_SUSPEND_FUNCTION_PREFIX)) {
                return kotlinToJava.get(kotlinFqName);
            }
            return K_FUNCTION_CLASS_ID;
        }
        return FUNCTION_N_CLASS_ID;
    }

    private final boolean isKotlinFunctionWithBigArity(FqNameUnsafe kotlinFqName, String prefix) {
        Integer arity;
        String fqNameAsString = kotlinFqName.asString();
        if (!StringsKt.startsWith$default(fqNameAsString, prefix, false, 2, (Object) null)) {
            return false;
        }
        String arityString = fqNameAsString.substring(prefix.length());
        Intrinsics.checkNotNullExpressionValue(arityString, "substring(...)");
        return (StringsKt.startsWith$default((CharSequence) arityString, '0', false, 2, (Object) null) || (arity = StringsKt.toIntOrNull(arityString)) == null || arity.intValue() < 23) ? false : true;
    }

    private final void addMapping(PlatformMutabilityMapping platformMutabilityMapping) {
        ClassId javaClassId = platformMutabilityMapping.component1();
        ClassId readOnlyClassId = platformMutabilityMapping.component2();
        ClassId mutableClassId = platformMutabilityMapping.component3();
        add(javaClassId, readOnlyClassId);
        addKotlinToJava(mutableClassId.asSingleFqName(), javaClassId);
        mutableToReadOnlyClassId.put(mutableClassId, readOnlyClassId);
        readOnlyToMutableClassId.put(readOnlyClassId, mutableClassId);
        FqName readOnlyFqName = readOnlyClassId.asSingleFqName();
        FqName mutableFqName = mutableClassId.asSingleFqName();
        mutableToReadOnly.put(mutableClassId.asSingleFqName().toUnsafe(), readOnlyFqName);
        readOnlyToMutable.put(readOnlyFqName.toUnsafe(), mutableFqName);
    }

    private final void add(ClassId javaClassId, ClassId kotlinClassId) {
        addJavaToKotlin(javaClassId, kotlinClassId);
        addKotlinToJava(kotlinClassId.asSingleFqName(), javaClassId);
    }

    private final void addTopLevel(Class<?> cls, FqNameUnsafe kotlinFqName) {
        addTopLevel(cls, kotlinFqName.toSafe());
    }

    private final void addTopLevel(Class<?> cls, FqName kotlinFqName) {
        add(classId(cls), ClassId.Companion.topLevel(kotlinFqName));
    }

    private final void addJavaToKotlin(ClassId javaClassId, ClassId kotlinClassId) {
        javaToKotlin.put(javaClassId.asSingleFqName().toUnsafe(), kotlinClassId);
    }

    private final void addKotlinToJava(FqName kotlinFqNameUnsafe, ClassId javaClassId) {
        kotlinToJava.put(kotlinFqNameUnsafe.toUnsafe(), javaClassId);
    }

    public final FqName mutableToReadOnly(FqNameUnsafe fqNameUnsafe) {
        return mutableToReadOnly.get(fqNameUnsafe);
    }

    public final FqName readOnlyToMutable(FqNameUnsafe fqNameUnsafe) {
        return readOnlyToMutable.get(fqNameUnsafe);
    }

    public final boolean isMutable(FqNameUnsafe fqNameUnsafe) {
        return mutableToReadOnly.containsKey(fqNameUnsafe);
    }

    public final boolean isReadOnly(FqNameUnsafe fqNameUnsafe) {
        return readOnlyToMutable.containsKey(fqNameUnsafe);
    }

    private final ClassId classId(Class<?> cls) {
        if (!((cls.isPrimitive() || cls.isArray()) ? false : true)) {
            throw new AssertionError("Invalid class: " + cls);
        }
        Class outer = cls.getDeclaringClass();
        if (outer == null) {
            ClassId.Companion companion = ClassId.Companion;
            String canonicalName = cls.getCanonicalName();
            Intrinsics.checkNotNullExpressionValue(canonicalName, "getCanonicalName(...)");
            return companion.topLevel(new FqName(canonicalName));
        }
        ClassId classId = classId(outer);
        Name identifier = Name.identifier(cls.getSimpleName());
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return classId.createNestedClassId(identifier);
    }
}