package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: StandardNames.kt */
public final class StandardNames {
    public static final FqName ANNOTATION_PACKAGE_FQ_NAME;
    public static final Name BACKING_FIELD;
    public static final FqName BUILT_INS_PACKAGE_FQ_NAME;
    public static final Set<FqName> BUILT_INS_PACKAGE_FQ_NAMES;
    public static final Name BUILT_INS_PACKAGE_NAME;
    public static final Name CHAR_CODE;
    public static final FqName COLLECTIONS_PACKAGE_FQ_NAME;
    public static final FqName CONCURRENT_ATOMICS_PACKAGE_FQ_NAME;
    public static final FqName CONCURRENT_PACKAGE_FQ_NAME;
    public static final Name CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME;
    public static final FqName CONTINUATION_INTERFACE_FQ_NAME;
    public static final FqName COROUTINES_INTRINSICS_PACKAGE_FQ_NAME;
    public static final FqName COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME;
    public static final FqName COROUTINES_PACKAGE_FQ_NAME;
    public static final Name COROUTINE_SUSPENDED_NAME;
    public static final String DATA_CLASS_COMPONENT_PREFIX;
    public static final Name DATA_CLASS_COPY;
    public static final Name DEFAULT_VALUE_PARAMETER;
    public static final FqName DYNAMIC_FQ_NAME;
    public static final Name ENUM_ENTRIES;
    public static final Name ENUM_VALUES;
    public static final Name ENUM_VALUE_OF;
    public static final Name EQUALS_NAME;
    public static final Name HASHCODE_NAME;
    public static final Name IMPLICIT_LAMBDA_PARAMETER_NAME;
    public static final StandardNames INSTANCE = new StandardNames();
    public static final FqName KOTLIN_INTERNAL_FQ_NAME;
    public static final FqName KOTLIN_REFLECT_FQ_NAME;
    public static final Name MAIN;
    public static final Name NAME;
    public static final Name NEXT_CHAR;
    private static final FqName NON_EXISTENT_CLASS;
    public static final List<String> PREFIXES;
    public static final FqName RANGES_PACKAGE_FQ_NAME;
    public static final FqName RESULT_FQ_NAME;
    public static final FqName TEXT_PACKAGE_FQ_NAME;
    public static final Name TO_STRING_NAME;

    private StandardNames() {
    }

    static {
        Name identifier = Name.identifier("field");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        BACKING_FIELD = identifier;
        Name identifier2 = Name.identifier("value");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(...)");
        DEFAULT_VALUE_PARAMETER = identifier2;
        Name identifier3 = Name.identifier("values");
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(...)");
        ENUM_VALUES = identifier3;
        Name identifier4 = Name.identifier("entries");
        Intrinsics.checkNotNullExpressionValue(identifier4, "identifier(...)");
        ENUM_ENTRIES = identifier4;
        Name identifier5 = Name.identifier("valueOf");
        Intrinsics.checkNotNullExpressionValue(identifier5, "identifier(...)");
        ENUM_VALUE_OF = identifier5;
        Name identifier6 = Name.identifier("copy");
        Intrinsics.checkNotNullExpressionValue(identifier6, "identifier(...)");
        DATA_CLASS_COPY = identifier6;
        DATA_CLASS_COMPONENT_PREFIX = "component";
        Name identifier7 = Name.identifier("hashCode");
        Intrinsics.checkNotNullExpressionValue(identifier7, "identifier(...)");
        HASHCODE_NAME = identifier7;
        Name identifier8 = Name.identifier("toString");
        Intrinsics.checkNotNullExpressionValue(identifier8, "identifier(...)");
        TO_STRING_NAME = identifier8;
        Name identifier9 = Name.identifier("equals");
        Intrinsics.checkNotNullExpressionValue(identifier9, "identifier(...)");
        EQUALS_NAME = identifier9;
        Name identifier10 = Name.identifier("code");
        Intrinsics.checkNotNullExpressionValue(identifier10, "identifier(...)");
        CHAR_CODE = identifier10;
        Name identifier11 = Name.identifier("name");
        Intrinsics.checkNotNullExpressionValue(identifier11, "identifier(...)");
        NAME = identifier11;
        Name identifier12 = Name.identifier("main");
        Intrinsics.checkNotNullExpressionValue(identifier12, "identifier(...)");
        MAIN = identifier12;
        Name identifier13 = Name.identifier("nextChar");
        Intrinsics.checkNotNullExpressionValue(identifier13, "identifier(...)");
        NEXT_CHAR = identifier13;
        Name identifier14 = Name.identifier("it");
        Intrinsics.checkNotNullExpressionValue(identifier14, "identifier(...)");
        IMPLICIT_LAMBDA_PARAMETER_NAME = identifier14;
        Name identifier15 = Name.identifier("count");
        Intrinsics.checkNotNullExpressionValue(identifier15, "identifier(...)");
        CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME = identifier15;
        DYNAMIC_FQ_NAME = new FqName("<dynamic>");
        COROUTINES_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines");
        COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.jvm.internal");
        COROUTINES_INTRINSICS_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.intrinsics");
        Name identifier16 = Name.identifier("COROUTINE_SUSPENDED");
        Intrinsics.checkNotNullExpressionValue(identifier16, "identifier(...)");
        COROUTINE_SUSPENDED_NAME = identifier16;
        FqName fqName = COROUTINES_PACKAGE_FQ_NAME;
        Name identifier17 = Name.identifier("Continuation");
        Intrinsics.checkNotNullExpressionValue(identifier17, "identifier(...)");
        CONTINUATION_INTERFACE_FQ_NAME = fqName.child(identifier17);
        RESULT_FQ_NAME = new FqName("kotlin.Result");
        KOTLIN_REFLECT_FQ_NAME = new FqName("kotlin.reflect");
        PREFIXES = CollectionsKt.listOf((Object[]) new String[]{"KProperty", "KMutableProperty", "KFunction", "KSuspendFunction"});
        Name identifier18 = Name.identifier("kotlin");
        Intrinsics.checkNotNullExpressionValue(identifier18, "identifier(...)");
        BUILT_INS_PACKAGE_NAME = identifier18;
        BUILT_INS_PACKAGE_FQ_NAME = FqName.Companion.topLevel(BUILT_INS_PACKAGE_NAME);
        FqName fqName2 = BUILT_INS_PACKAGE_FQ_NAME;
        Name identifier19 = Name.identifier("annotation");
        Intrinsics.checkNotNullExpressionValue(identifier19, "identifier(...)");
        ANNOTATION_PACKAGE_FQ_NAME = fqName2.child(identifier19);
        FqName fqName3 = BUILT_INS_PACKAGE_FQ_NAME;
        Name identifier20 = Name.identifier("collections");
        Intrinsics.checkNotNullExpressionValue(identifier20, "identifier(...)");
        COLLECTIONS_PACKAGE_FQ_NAME = fqName3.child(identifier20);
        FqName fqName4 = BUILT_INS_PACKAGE_FQ_NAME;
        Name identifier21 = Name.identifier("ranges");
        Intrinsics.checkNotNullExpressionValue(identifier21, "identifier(...)");
        RANGES_PACKAGE_FQ_NAME = fqName4.child(identifier21);
        FqName fqName5 = BUILT_INS_PACKAGE_FQ_NAME;
        Name identifier22 = Name.identifier("text");
        Intrinsics.checkNotNullExpressionValue(identifier22, "identifier(...)");
        TEXT_PACKAGE_FQ_NAME = fqName5.child(identifier22);
        FqName fqName6 = BUILT_INS_PACKAGE_FQ_NAME;
        Name identifier23 = Name.identifier("internal");
        Intrinsics.checkNotNullExpressionValue(identifier23, "identifier(...)");
        KOTLIN_INTERNAL_FQ_NAME = fqName6.child(identifier23);
        FqName fqName7 = BUILT_INS_PACKAGE_FQ_NAME;
        Name identifier24 = Name.identifier("concurrent");
        Intrinsics.checkNotNullExpressionValue(identifier24, "identifier(...)");
        CONCURRENT_PACKAGE_FQ_NAME = fqName7.child(identifier24);
        FqName fqName8 = CONCURRENT_PACKAGE_FQ_NAME;
        Name identifier25 = Name.identifier("atomics");
        Intrinsics.checkNotNullExpressionValue(identifier25, "identifier(...)");
        CONCURRENT_ATOMICS_PACKAGE_FQ_NAME = fqName8.child(identifier25);
        NON_EXISTENT_CLASS = new FqName("error.NonExistentClass");
        BUILT_INS_PACKAGE_FQ_NAMES = SetsKt.setOf((Object[]) new FqName[]{BUILT_INS_PACKAGE_FQ_NAME, COLLECTIONS_PACKAGE_FQ_NAME, RANGES_PACKAGE_FQ_NAME, ANNOTATION_PACKAGE_FQ_NAME, KOTLIN_REFLECT_FQ_NAME, KOTLIN_INTERNAL_FQ_NAME, COROUTINES_PACKAGE_FQ_NAME, CONCURRENT_ATOMICS_PACKAGE_FQ_NAME});
    }

    /* compiled from: StandardNames.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class FqNames {
        public static final Map<FqNameUnsafe, PrimitiveType> arrayClassFqNameToPrimitiveType;
        public static final FqName atomicArray;
        public static final FqName atomicBoolean;
        public static final FqName atomicInt;
        public static final FqName atomicIntArray;
        public static final FqName atomicLong;
        public static final FqName atomicLongArray;
        public static final FqName atomicReference;
        public static final FqNameUnsafe findAssociatedObject;
        public static final Map<FqNameUnsafe, PrimitiveType> fqNameToPrimitiveType;
        public static final FqNameUnsafe kCallable;
        public static final FqNameUnsafe kClass;
        public static final FqNameUnsafe kDeclarationContainer;
        public static final FqNameUnsafe kMutableProperty0;
        public static final FqNameUnsafe kMutableProperty1;
        public static final FqNameUnsafe kMutableProperty2;
        public static final FqNameUnsafe kMutablePropertyFqName;
        public static final ClassId kProperty;
        public static final FqNameUnsafe kProperty0;
        public static final FqNameUnsafe kProperty1;
        public static final FqNameUnsafe kProperty2;
        public static final FqNameUnsafe kPropertyFqName;
        public static final FqNameUnsafe kType;
        public static final FqName mapEntry;
        public static final FqName mutableCollection;
        public static final FqName mutableIterable;
        public static final FqName mutableIterator;
        public static final FqName mutableList;
        public static final FqName mutableListIterator;
        public static final FqName mutableMap;
        public static final FqName mutableMapEntry;
        public static final FqName mutableSet;
        public static final Set<Name> primitiveArrayTypeShortNames;
        public static final Set<Name> primitiveTypeShortNames;
        public static final ClassId uByte;
        public static final FqName uByteArrayFqName;
        public static final FqName uByteFqName;
        public static final ClassId uInt;
        public static final FqName uIntArrayFqName;
        public static final FqName uIntFqName;
        public static final ClassId uLong;
        public static final FqName uLongArrayFqName;
        public static final FqName uLongFqName;
        public static final ClassId uShort;
        public static final FqName uShortArrayFqName;
        public static final FqName uShortFqName;
        public static final FqNames INSTANCE = new FqNames();
        public static final FqNameUnsafe any = INSTANCE.fqNameUnsafe("Any");
        public static final FqNameUnsafe nothing = INSTANCE.fqNameUnsafe("Nothing");
        public static final FqNameUnsafe cloneable = INSTANCE.fqNameUnsafe("Cloneable");
        public static final FqName suppress = INSTANCE.fqName("Suppress");
        public static final FqNameUnsafe unit = INSTANCE.fqNameUnsafe("Unit");
        public static final FqNameUnsafe charSequence = INSTANCE.fqNameUnsafe("CharSequence");
        public static final FqNameUnsafe string = INSTANCE.fqNameUnsafe("String");
        public static final FqNameUnsafe array = INSTANCE.fqNameUnsafe("Array");
        public static final FqNameUnsafe _boolean = INSTANCE.fqNameUnsafe("Boolean");
        public static final FqNameUnsafe _char = INSTANCE.fqNameUnsafe("Char");
        public static final FqNameUnsafe _byte = INSTANCE.fqNameUnsafe("Byte");
        public static final FqNameUnsafe _short = INSTANCE.fqNameUnsafe("Short");
        public static final FqNameUnsafe _int = INSTANCE.fqNameUnsafe("Int");
        public static final FqNameUnsafe _long = INSTANCE.fqNameUnsafe("Long");
        public static final FqNameUnsafe _float = INSTANCE.fqNameUnsafe("Float");
        public static final FqNameUnsafe _double = INSTANCE.fqNameUnsafe("Double");
        public static final FqNameUnsafe number = INSTANCE.fqNameUnsafe("Number");
        public static final FqNameUnsafe _enum = INSTANCE.fqNameUnsafe("Enum");
        public static final FqNameUnsafe functionSupertype = INSTANCE.fqNameUnsafe("Function");
        public static final FqName throwable = INSTANCE.fqName("Throwable");
        public static final FqName comparable = INSTANCE.fqName("Comparable");
        public static final FqNameUnsafe intRange = INSTANCE.rangesFqName("IntRange");
        public static final FqNameUnsafe longRange = INSTANCE.rangesFqName("LongRange");
        public static final FqName deprecated = INSTANCE.fqName("Deprecated");
        public static final FqName deprecatedSinceKotlin = INSTANCE.fqName("DeprecatedSinceKotlin");
        public static final FqName deprecationLevel = INSTANCE.fqName("DeprecationLevel");
        public static final FqName replaceWith = INSTANCE.fqName("ReplaceWith");
        public static final FqName extensionFunctionType = INSTANCE.fqName("ExtensionFunctionType");
        public static final FqName contextFunctionTypeParams = INSTANCE.fqName("ContextFunctionTypeParams");
        public static final FqName parameterName = INSTANCE.fqName("ParameterName");
        public static final ClassId parameterNameClassId = ClassId.Companion.topLevel(parameterName);
        public static final FqName annotation = INSTANCE.fqName("Annotation");
        public static final FqName target = INSTANCE.annotationName("Target");
        public static final ClassId targetClassId = ClassId.Companion.topLevel(target);
        public static final FqName annotationTarget = INSTANCE.annotationName("AnnotationTarget");
        public static final FqName annotationRetention = INSTANCE.annotationName("AnnotationRetention");
        public static final FqName retention = INSTANCE.annotationName("Retention");
        public static final ClassId retentionClassId = ClassId.Companion.topLevel(retention);
        public static final FqName repeatable = INSTANCE.annotationName("Repeatable");
        public static final ClassId repeatableClassId = ClassId.Companion.topLevel(repeatable);
        public static final FqName mustBeDocumented = INSTANCE.annotationName("MustBeDocumented");
        public static final FqName unsafeVariance = INSTANCE.fqName("UnsafeVariance");
        public static final FqName publishedApi = INSTANCE.fqName("PublishedApi");
        public static final FqName accessibleLateinitPropertyLiteral = INSTANCE.internalName("AccessibleLateinitPropertyLiteral");
        public static final FqName platformDependent = new FqName("kotlin.internal.PlatformDependent");
        public static final ClassId platformDependentClassId = ClassId.Companion.topLevel(platformDependent);
        public static final FqName iterator = INSTANCE.collectionsFqName("Iterator");
        public static final FqName iterable = INSTANCE.collectionsFqName("Iterable");
        public static final FqName collection = INSTANCE.collectionsFqName("Collection");
        public static final FqName list = INSTANCE.collectionsFqName("List");
        public static final FqName listIterator = INSTANCE.collectionsFqName("ListIterator");
        public static final FqName set = INSTANCE.collectionsFqName("Set");
        public static final FqName map = INSTANCE.collectionsFqName("Map");

        private FqNames() {
        }

        static {
            PrimitiveType[] values;
            PrimitiveType[] values2;
            FqName fqName = map;
            Name identifier = Name.identifier("Entry");
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            mapEntry = fqName.child(identifier);
            mutableIterator = INSTANCE.collectionsFqName("MutableIterator");
            mutableIterable = INSTANCE.collectionsFqName("MutableIterable");
            mutableCollection = INSTANCE.collectionsFqName("MutableCollection");
            mutableList = INSTANCE.collectionsFqName("MutableList");
            mutableListIterator = INSTANCE.collectionsFqName("MutableListIterator");
            mutableSet = INSTANCE.collectionsFqName("MutableSet");
            mutableMap = INSTANCE.collectionsFqName("MutableMap");
            FqName fqName2 = mutableMap;
            Name identifier2 = Name.identifier("MutableEntry");
            Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(...)");
            mutableMapEntry = fqName2.child(identifier2);
            kClass = reflect("KClass");
            kType = reflect("KType");
            kCallable = reflect("KCallable");
            kProperty0 = reflect("KProperty0");
            kProperty1 = reflect("KProperty1");
            kProperty2 = reflect("KProperty2");
            kMutableProperty0 = reflect("KMutableProperty0");
            kMutableProperty1 = reflect("KMutableProperty1");
            kMutableProperty2 = reflect("KMutableProperty2");
            kPropertyFqName = reflect("KProperty");
            kMutablePropertyFqName = reflect("KMutableProperty");
            kProperty = ClassId.Companion.topLevel(kPropertyFqName.toSafe());
            kDeclarationContainer = reflect("KDeclarationContainer");
            findAssociatedObject = reflect("findAssociatedObject");
            uByteFqName = INSTANCE.fqName("UByte");
            uShortFqName = INSTANCE.fqName("UShort");
            uIntFqName = INSTANCE.fqName("UInt");
            uLongFqName = INSTANCE.fqName("ULong");
            uByte = ClassId.Companion.topLevel(uByteFqName);
            uShort = ClassId.Companion.topLevel(uShortFqName);
            uInt = ClassId.Companion.topLevel(uIntFqName);
            uLong = ClassId.Companion.topLevel(uLongFqName);
            uByteArrayFqName = INSTANCE.fqName("UByteArray");
            uShortArrayFqName = INSTANCE.fqName("UShortArray");
            uIntArrayFqName = INSTANCE.fqName("UIntArray");
            uLongArrayFqName = INSTANCE.fqName("ULongArray");
            atomicInt = INSTANCE.concurrentAtomics("AtomicInt");
            atomicLong = INSTANCE.concurrentAtomics("AtomicLong");
            atomicBoolean = INSTANCE.concurrentAtomics("AtomicBoolean");
            atomicReference = INSTANCE.concurrentAtomics("AtomicReference");
            atomicIntArray = INSTANCE.concurrentAtomics("AtomicIntArray");
            atomicLongArray = INSTANCE.concurrentAtomics("AtomicLongArray");
            atomicArray = INSTANCE.concurrentAtomics("AtomicArray");
            Collection $this$primitiveTypeShortNames_u24lambda_u240 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            Collection destination$iv = $this$primitiveTypeShortNames_u24lambda_u240;
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                destination$iv.add(primitiveType.getTypeName());
            }
            primitiveTypeShortNames = (Set) $this$primitiveTypeShortNames_u24lambda_u240;
            Collection $this$primitiveArrayTypeShortNames_u24lambda_u240 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            Collection destination$iv2 = $this$primitiveArrayTypeShortNames_u24lambda_u240;
            for (PrimitiveType primitiveType2 : PrimitiveType.values()) {
                destination$iv2.add(primitiveType2.getArrayTypeName());
            }
            primitiveArrayTypeShortNames = (Set) $this$primitiveArrayTypeShortNames_u24lambda_u240;
            HashMap $this$fqNameToPrimitiveType_u24lambda_u240 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            for (PrimitiveType primitiveType3 : PrimitiveType.values()) {
                FqNames fqNames = INSTANCE;
                String asString = primitiveType3.getTypeName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
                $this$fqNameToPrimitiveType_u24lambda_u240.put(fqNames.fqNameUnsafe(asString), primitiveType3);
            }
            fqNameToPrimitiveType = $this$fqNameToPrimitiveType_u24lambda_u240;
            HashMap $this$arrayClassFqNameToPrimitiveType_u24lambda_u240 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            for (PrimitiveType primitiveType4 : PrimitiveType.values()) {
                FqNames fqNames2 = INSTANCE;
                String asString2 = primitiveType4.getArrayTypeName().asString();
                Intrinsics.checkNotNullExpressionValue(asString2, "asString(...)");
                $this$arrayClassFqNameToPrimitiveType_u24lambda_u240.put(fqNames2.fqNameUnsafe(asString2), primitiveType4);
            }
            arrayClassFqNameToPrimitiveType = $this$arrayClassFqNameToPrimitiveType_u24lambda_u240;
        }

        private final FqNameUnsafe fqNameUnsafe(String simpleName) {
            return fqName(simpleName).toUnsafe();
        }

        private final FqName fqName(String simpleName) {
            FqName fqName = StandardNames.BUILT_INS_PACKAGE_FQ_NAME;
            Name identifier = Name.identifier(simpleName);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            return fqName.child(identifier);
        }

        private final FqName collectionsFqName(String simpleName) {
            FqName fqName = StandardNames.COLLECTIONS_PACKAGE_FQ_NAME;
            Name identifier = Name.identifier(simpleName);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            return fqName.child(identifier);
        }

        private final FqNameUnsafe rangesFqName(String simpleName) {
            FqName fqName = StandardNames.RANGES_PACKAGE_FQ_NAME;
            Name identifier = Name.identifier(simpleName);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            return fqName.child(identifier).toUnsafe();
        }

        @JvmStatic
        public static final FqNameUnsafe reflect(String simpleName) {
            Intrinsics.checkNotNullParameter(simpleName, "simpleName");
            FqName fqName = StandardNames.KOTLIN_REFLECT_FQ_NAME;
            Name identifier = Name.identifier(simpleName);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            return fqName.child(identifier).toUnsafe();
        }

        private final FqName annotationName(String simpleName) {
            FqName fqName = StandardNames.ANNOTATION_PACKAGE_FQ_NAME;
            Name identifier = Name.identifier(simpleName);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            return fqName.child(identifier);
        }

        private final FqName internalName(String simpleName) {
            FqName fqName = StandardNames.KOTLIN_INTERNAL_FQ_NAME;
            Name identifier = Name.identifier(simpleName);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            return fqName.child(identifier);
        }

        private final FqName concurrentAtomics(String simpleName) {
            FqName fqName = StandardNames.CONCURRENT_ATOMICS_PACKAGE_FQ_NAME;
            Name identifier = Name.identifier(simpleName);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            return fqName.child(identifier);
        }
    }

    @JvmStatic
    public static final String getFunctionName(int parameterCount) {
        return "Function" + parameterCount;
    }

    @JvmStatic
    public static final ClassId getFunctionClassId(int parameterCount) {
        FqName fqName = BUILT_INS_PACKAGE_FQ_NAME;
        Name identifier = Name.identifier(getFunctionName(parameterCount));
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return new ClassId(fqName, identifier);
    }

    @JvmStatic
    public static final String getSuspendFunctionName(int parameterCount) {
        return FunctionTypeKind.SuspendFunction.INSTANCE.getClassNamePrefix() + parameterCount;
    }

    @JvmStatic
    public static final boolean isPrimitiveArray(FqNameUnsafe arrayFqName) {
        Intrinsics.checkNotNullParameter(arrayFqName, "arrayFqName");
        return FqNames.arrayClassFqNameToPrimitiveType.get(arrayFqName) != null;
    }

    @JvmStatic
    public static final FqName getPrimitiveFqName(PrimitiveType primitiveType) {
        Intrinsics.checkNotNullParameter(primitiveType, "primitiveType");
        return BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.getTypeName());
    }
}