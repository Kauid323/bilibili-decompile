package kotlin.reflect.jvm.internal.impl.name;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: StandardClassIds.kt */
public final class StandardClassIds {
    private static final ClassId AbstractMap;
    private static final ClassId Annotation;
    private static final ClassId AnnotationRetention;
    private static final ClassId AnnotationTarget;
    private static final ClassId Any;
    private static final ClassId Array;
    private static final ClassId AtomicArray;
    private static final ClassId AtomicBoolean;
    private static final ClassId AtomicInt;
    private static final ClassId AtomicIntArray;
    private static final ClassId AtomicLong;
    private static final ClassId AtomicLongArray;
    private static final ClassId AtomicReference;
    private static final FqName BASE_ANNOTATIONS_JVM_PACKAGE;
    private static final FqName BASE_ANNOTATION_PACKAGE;
    private static final FqName BASE_COLLECTIONS_PACKAGE;
    private static final FqName BASE_CONCURRENT_ATOMICS_PACKAGE;
    private static final FqName BASE_CONCURRENT_PACKAGE;
    private static final FqName BASE_CONTRACTS_PACKAGE;
    private static final FqName BASE_COROUTINES_INTRINSICS_PACKAGE;
    private static final FqName BASE_COROUTINES_PACKAGE;
    private static final FqName BASE_ENUMS_PACKAGE;
    private static final FqName BASE_EXPERIMENTAL_PACKAGE;
    private static final FqName BASE_INTERNAL_IR_PACKAGE;
    private static final FqName BASE_INTERNAL_PACKAGE;
    private static final FqName BASE_JS_PACKAGE;
    private static final FqName BASE_JVM_FUNCTIONS_PACKAGE;
    private static final FqName BASE_JVM_INTERNAL_PACKAGE;
    private static final FqName BASE_JVM_PACKAGE;
    private static final FqName BASE_RANGES_PACKAGE;
    private static final FqName BASE_REFLECT_PACKAGE;
    private static final FqName BASE_SEQUENCES_PACKAGE;
    private static final FqName BASE_TEST_PACKAGE;
    private static final FqName BASE_TEXT_PACKAGE;
    private static final ClassId Boolean;
    private static final ClassId Byte;
    private static final ClassId Char;
    private static final ClassId CharIterator;
    private static final ClassId CharRange;
    private static final ClassId CharSequence;
    private static final ClassId Cloneable;
    private static final ClassId Collection;
    private static final ClassId Comparable;
    private static final ClassId Continuation;
    private static final ClassId DeprecationLevel;
    private static final ClassId Double;
    private static final ClassId Enum;
    private static final ClassId EnumEntries;
    private static final ClassId Float;
    private static final ClassId Function;
    private static final ClassId Int;
    private static final ClassId IntRange;
    private static final ClassId Iterable;
    private static final ClassId Iterator;
    private static final ClassId KCallable;
    private static final ClassId KClass;
    private static final ClassId KFunction;
    private static final ClassId KMutableProperty;
    private static final ClassId KMutableProperty0;
    private static final ClassId KMutableProperty1;
    private static final ClassId KMutableProperty2;
    private static final ClassId KProperty;
    private static final ClassId KProperty0;
    private static final ClassId KProperty1;
    private static final ClassId KProperty2;
    private static final ClassId KType;
    private static final ClassId List;
    private static final ClassId ListIterator;
    private static final ClassId Long;
    private static final ClassId LongRange;
    private static final ClassId Map;
    private static final ClassId MapEntry;
    private static final ClassId MutableCollection;
    private static final ClassId MutableIterable;
    private static final ClassId MutableIterator;
    private static final ClassId MutableList;
    private static final ClassId MutableListIterator;
    private static final ClassId MutableMap;
    private static final ClassId MutableMapEntry;
    private static final ClassId MutableSet;
    private static final ClassId Nothing;
    private static final ClassId Number;
    private static final ClassId Result;
    private static final ClassId Set;
    private static final ClassId Short;
    private static final ClassId String;
    private static final ClassId Throwable;
    private static final ClassId UByte;
    private static final ClassId UInt;
    private static final ClassId ULong;
    private static final ClassId UShort;
    private static final ClassId Unit;
    private static final Set<ClassId> allBuiltinTypes;
    private static final Map<ClassId, ClassId> atomicArrayByPrimitive;
    private static final Map<ClassId, ClassId> atomicByPrimitive;
    private static final Set<FqName> builtInsPackages;
    private static final Set<FqName> builtInsPackagesWithDefaultNamedImport;
    private static final Set<ClassId> constantAllowedTypes;
    private static final Map<ClassId, ClassId> elementTypeByPrimitiveArrayType;
    private static final Map<ClassId, ClassId> elementTypeByUnsignedArrayType;
    private static final Map<ClassId, ClassId> primitiveArrayTypeByElementType;
    private static final Set<ClassId> primitiveTypes;
    private static final Set<ClassId> signedIntegerTypes;
    private static final Map<ClassId, ClassId> unsignedArrayTypeByElementType;
    private static final Set<ClassId> unsignedTypes;
    public static final StandardClassIds INSTANCE = new StandardClassIds();
    private static final FqName BASE_KOTLIN_PACKAGE = new FqName("kotlin");

    private StandardClassIds() {
    }

    static {
        FqName fqName = BASE_KOTLIN_PACKAGE;
        Name identifier = Name.identifier("reflect");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        BASE_REFLECT_PACKAGE = fqName.child(identifier);
        FqName fqName2 = BASE_KOTLIN_PACKAGE;
        Name identifier2 = Name.identifier("experimental");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(...)");
        BASE_EXPERIMENTAL_PACKAGE = fqName2.child(identifier2);
        FqName fqName3 = BASE_KOTLIN_PACKAGE;
        Name identifier3 = Name.identifier("collections");
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(...)");
        BASE_COLLECTIONS_PACKAGE = fqName3.child(identifier3);
        FqName fqName4 = BASE_KOTLIN_PACKAGE;
        Name identifier4 = Name.identifier("sequences");
        Intrinsics.checkNotNullExpressionValue(identifier4, "identifier(...)");
        BASE_SEQUENCES_PACKAGE = fqName4.child(identifier4);
        FqName fqName5 = BASE_KOTLIN_PACKAGE;
        Name identifier5 = Name.identifier("ranges");
        Intrinsics.checkNotNullExpressionValue(identifier5, "identifier(...)");
        BASE_RANGES_PACKAGE = fqName5.child(identifier5);
        FqName fqName6 = BASE_KOTLIN_PACKAGE;
        Name identifier6 = Name.identifier("jvm");
        Intrinsics.checkNotNullExpressionValue(identifier6, "identifier(...)");
        BASE_JVM_PACKAGE = fqName6.child(identifier6);
        FqName fqName7 = BASE_KOTLIN_PACKAGE;
        Name identifier7 = Name.identifier("js");
        Intrinsics.checkNotNullExpressionValue(identifier7, "identifier(...)");
        BASE_JS_PACKAGE = fqName7.child(identifier7);
        FqName fqName8 = BASE_KOTLIN_PACKAGE;
        Name identifier8 = Name.identifier("annotations");
        Intrinsics.checkNotNullExpressionValue(identifier8, "identifier(...)");
        FqName child = fqName8.child(identifier8);
        Name identifier9 = Name.identifier("jvm");
        Intrinsics.checkNotNullExpressionValue(identifier9, "identifier(...)");
        BASE_ANNOTATIONS_JVM_PACKAGE = child.child(identifier9);
        FqName fqName9 = BASE_JVM_PACKAGE;
        Name identifier10 = Name.identifier("internal");
        Intrinsics.checkNotNullExpressionValue(identifier10, "identifier(...)");
        BASE_JVM_INTERNAL_PACKAGE = fqName9.child(identifier10);
        FqName fqName10 = BASE_JVM_PACKAGE;
        Name identifier11 = Name.identifier("functions");
        Intrinsics.checkNotNullExpressionValue(identifier11, "identifier(...)");
        BASE_JVM_FUNCTIONS_PACKAGE = fqName10.child(identifier11);
        FqName fqName11 = BASE_KOTLIN_PACKAGE;
        Name identifier12 = Name.identifier("annotation");
        Intrinsics.checkNotNullExpressionValue(identifier12, "identifier(...)");
        BASE_ANNOTATION_PACKAGE = fqName11.child(identifier12);
        FqName fqName12 = BASE_KOTLIN_PACKAGE;
        Name identifier13 = Name.identifier("internal");
        Intrinsics.checkNotNullExpressionValue(identifier13, "identifier(...)");
        BASE_INTERNAL_PACKAGE = fqName12.child(identifier13);
        FqName fqName13 = BASE_INTERNAL_PACKAGE;
        Name identifier14 = Name.identifier("ir");
        Intrinsics.checkNotNullExpressionValue(identifier14, "identifier(...)");
        BASE_INTERNAL_IR_PACKAGE = fqName13.child(identifier14);
        FqName fqName14 = BASE_KOTLIN_PACKAGE;
        Name identifier15 = Name.identifier("coroutines");
        Intrinsics.checkNotNullExpressionValue(identifier15, "identifier(...)");
        BASE_COROUTINES_PACKAGE = fqName14.child(identifier15);
        FqName fqName15 = BASE_COROUTINES_PACKAGE;
        Name identifier16 = Name.identifier("intrinsics");
        Intrinsics.checkNotNullExpressionValue(identifier16, "identifier(...)");
        BASE_COROUTINES_INTRINSICS_PACKAGE = fqName15.child(identifier16);
        FqName fqName16 = BASE_KOTLIN_PACKAGE;
        Name identifier17 = Name.identifier("enums");
        Intrinsics.checkNotNullExpressionValue(identifier17, "identifier(...)");
        BASE_ENUMS_PACKAGE = fqName16.child(identifier17);
        FqName fqName17 = BASE_KOTLIN_PACKAGE;
        Name identifier18 = Name.identifier("contracts");
        Intrinsics.checkNotNullExpressionValue(identifier18, "identifier(...)");
        BASE_CONTRACTS_PACKAGE = fqName17.child(identifier18);
        FqName fqName18 = BASE_KOTLIN_PACKAGE;
        Name identifier19 = Name.identifier("concurrent");
        Intrinsics.checkNotNullExpressionValue(identifier19, "identifier(...)");
        BASE_CONCURRENT_PACKAGE = fqName18.child(identifier19);
        FqName fqName19 = BASE_CONCURRENT_PACKAGE;
        Name identifier20 = Name.identifier("atomics");
        Intrinsics.checkNotNullExpressionValue(identifier20, "identifier(...)");
        BASE_CONCURRENT_ATOMICS_PACKAGE = fqName19.child(identifier20);
        FqName fqName20 = BASE_KOTLIN_PACKAGE;
        Name identifier21 = Name.identifier("test");
        Intrinsics.checkNotNullExpressionValue(identifier21, "identifier(...)");
        BASE_TEST_PACKAGE = fqName20.child(identifier21);
        FqName fqName21 = BASE_KOTLIN_PACKAGE;
        Name identifier22 = Name.identifier("text");
        Intrinsics.checkNotNullExpressionValue(identifier22, "identifier(...)");
        BASE_TEXT_PACKAGE = fqName21.child(identifier22);
        builtInsPackagesWithDefaultNamedImport = SetsKt.setOf((Object[]) new FqName[]{BASE_KOTLIN_PACKAGE, BASE_COLLECTIONS_PACKAGE, BASE_RANGES_PACKAGE, BASE_ANNOTATION_PACKAGE});
        builtInsPackages = SetsKt.setOf((Object[]) new FqName[]{BASE_KOTLIN_PACKAGE, BASE_COLLECTIONS_PACKAGE, BASE_RANGES_PACKAGE, BASE_ANNOTATION_PACKAGE, BASE_REFLECT_PACKAGE, BASE_INTERNAL_PACKAGE, BASE_COROUTINES_PACKAGE, BASE_CONCURRENT_ATOMICS_PACKAGE});
        Nothing = StandardClassIdsKt.access$baseId("Nothing");
        Unit = StandardClassIdsKt.access$baseId("Unit");
        Any = StandardClassIdsKt.access$baseId("Any");
        Enum = StandardClassIdsKt.access$baseId("Enum");
        Annotation = StandardClassIdsKt.access$baseId("Annotation");
        Array = StandardClassIdsKt.access$baseId("Array");
        Boolean = StandardClassIdsKt.access$baseId("Boolean");
        Char = StandardClassIdsKt.access$baseId("Char");
        Byte = StandardClassIdsKt.access$baseId("Byte");
        Short = StandardClassIdsKt.access$baseId("Short");
        Int = StandardClassIdsKt.access$baseId("Int");
        Long = StandardClassIdsKt.access$baseId("Long");
        Float = StandardClassIdsKt.access$baseId("Float");
        Double = StandardClassIdsKt.access$baseId("Double");
        UByte = StandardClassIdsKt.access$unsignedId(Byte);
        UShort = StandardClassIdsKt.access$unsignedId(Short);
        UInt = StandardClassIdsKt.access$unsignedId(Int);
        ULong = StandardClassIdsKt.access$unsignedId(Long);
        CharSequence = StandardClassIdsKt.access$baseId("CharSequence");
        String = StandardClassIdsKt.access$baseId("String");
        Throwable = StandardClassIdsKt.access$baseId("Throwable");
        Cloneable = StandardClassIdsKt.access$baseId("Cloneable");
        KProperty = StandardClassIdsKt.access$reflectId("KProperty");
        KMutableProperty = StandardClassIdsKt.access$reflectId("KMutableProperty");
        KProperty0 = StandardClassIdsKt.access$reflectId("KProperty0");
        KMutableProperty0 = StandardClassIdsKt.access$reflectId("KMutableProperty0");
        KProperty1 = StandardClassIdsKt.access$reflectId("KProperty1");
        KMutableProperty1 = StandardClassIdsKt.access$reflectId("KMutableProperty1");
        KProperty2 = StandardClassIdsKt.access$reflectId("KProperty2");
        KMutableProperty2 = StandardClassIdsKt.access$reflectId("KMutableProperty2");
        KFunction = StandardClassIdsKt.access$reflectId("KFunction");
        KClass = StandardClassIdsKt.access$reflectId("KClass");
        KCallable = StandardClassIdsKt.access$reflectId("KCallable");
        KType = StandardClassIdsKt.access$reflectId("KType");
        Comparable = StandardClassIdsKt.access$baseId("Comparable");
        Number = StandardClassIdsKt.access$baseId("Number");
        Function = StandardClassIdsKt.access$baseId("Function");
        primitiveTypes = SetsKt.setOf((Object[]) new ClassId[]{Boolean, Char, Byte, Short, Int, Long, Float, Double});
        signedIntegerTypes = SetsKt.setOf((Object[]) new ClassId[]{Byte, Short, Int, Long});
        Iterable $this$associateWith$iv = primitiveTypes;
        Map result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv, 10)), 16));
        Map destination$iv$iv = result$iv;
        for (Object element$iv$iv : $this$associateWith$iv) {
            ClassId id = (ClassId) element$iv$iv;
            destination$iv$iv.put(element$iv$iv, StandardClassIdsKt.access$primitiveArrayId(id.getShortClassName()));
        }
        primitiveArrayTypeByElementType = destination$iv$iv;
        elementTypeByPrimitiveArrayType = StandardClassIdsKt.access$inverseMap(primitiveArrayTypeByElementType);
        unsignedTypes = SetsKt.setOf((Object[]) new ClassId[]{UByte, UShort, UInt, ULong});
        Iterable $this$associateWith$iv2 = unsignedTypes;
        Map result$iv2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv2, 10)), 16));
        Map destination$iv$iv2 = result$iv2;
        for (Object element$iv$iv2 : $this$associateWith$iv2) {
            ClassId id2 = (ClassId) element$iv$iv2;
            destination$iv$iv2.put(element$iv$iv2, StandardClassIdsKt.access$primitiveArrayId(id2.getShortClassName()));
        }
        unsignedArrayTypeByElementType = destination$iv$iv2;
        elementTypeByUnsignedArrayType = StandardClassIdsKt.access$inverseMap(unsignedArrayTypeByElementType);
        constantAllowedTypes = SetsKt.plus(SetsKt.plus((Set) primitiveTypes, (Iterable) unsignedTypes), String);
        Continuation = StandardClassIdsKt.access$coroutinesId("Continuation");
        Iterator = StandardClassIdsKt.access$collectionsId("Iterator");
        Iterable = StandardClassIdsKt.access$collectionsId("Iterable");
        Collection = StandardClassIdsKt.access$collectionsId("Collection");
        List = StandardClassIdsKt.access$collectionsId("List");
        ListIterator = StandardClassIdsKt.access$collectionsId("ListIterator");
        Set = StandardClassIdsKt.access$collectionsId("Set");
        Map = StandardClassIdsKt.access$collectionsId("Map");
        AbstractMap = StandardClassIdsKt.access$collectionsId("AbstractMap");
        MutableIterator = StandardClassIdsKt.access$collectionsId("MutableIterator");
        CharIterator = StandardClassIdsKt.access$collectionsId("CharIterator");
        MutableIterable = StandardClassIdsKt.access$collectionsId("MutableIterable");
        MutableCollection = StandardClassIdsKt.access$collectionsId("MutableCollection");
        MutableList = StandardClassIdsKt.access$collectionsId("MutableList");
        MutableListIterator = StandardClassIdsKt.access$collectionsId("MutableListIterator");
        MutableSet = StandardClassIdsKt.access$collectionsId("MutableSet");
        MutableMap = StandardClassIdsKt.access$collectionsId("MutableMap");
        ClassId classId = Map;
        Name identifier23 = Name.identifier("Entry");
        Intrinsics.checkNotNullExpressionValue(identifier23, "identifier(...)");
        MapEntry = classId.createNestedClassId(identifier23);
        ClassId classId2 = MutableMap;
        Name identifier24 = Name.identifier("MutableEntry");
        Intrinsics.checkNotNullExpressionValue(identifier24, "identifier(...)");
        MutableMapEntry = classId2.createNestedClassId(identifier24);
        Result = StandardClassIdsKt.access$baseId("Result");
        IntRange = StandardClassIdsKt.access$rangesId("IntRange");
        LongRange = StandardClassIdsKt.access$rangesId("LongRange");
        CharRange = StandardClassIdsKt.access$rangesId("CharRange");
        AnnotationRetention = StandardClassIdsKt.access$annotationId("AnnotationRetention");
        AnnotationTarget = StandardClassIdsKt.access$annotationId("AnnotationTarget");
        DeprecationLevel = StandardClassIdsKt.access$baseId("DeprecationLevel");
        EnumEntries = StandardClassIdsKt.access$enumsId("EnumEntries");
        AtomicBoolean = StandardClassIdsKt.access$atomicsId("AtomicBoolean");
        AtomicInt = StandardClassIdsKt.access$atomicsId("AtomicInt");
        AtomicLong = StandardClassIdsKt.access$atomicsId("AtomicLong");
        AtomicReference = StandardClassIdsKt.access$atomicsId("AtomicReference");
        atomicByPrimitive = MapsKt.mapOf(TuplesKt.to(Boolean, AtomicBoolean), TuplesKt.to(Int, AtomicInt), TuplesKt.to(Long, AtomicLong));
        AtomicArray = StandardClassIdsKt.access$atomicsId("AtomicArray");
        AtomicIntArray = StandardClassIdsKt.access$atomicsId("AtomicIntArray");
        AtomicLongArray = StandardClassIdsKt.access$atomicsId("AtomicLongArray");
        atomicArrayByPrimitive = MapsKt.mapOf(TuplesKt.to(Int, AtomicIntArray), TuplesKt.to(Long, AtomicLongArray));
        allBuiltinTypes = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus((Set) primitiveTypes, (Iterable) unsignedTypes), String), Unit), Any), Enum);
    }

    public final FqName getBASE_KOTLIN_PACKAGE() {
        return BASE_KOTLIN_PACKAGE;
    }

    public final FqName getBASE_REFLECT_PACKAGE() {
        return BASE_REFLECT_PACKAGE;
    }

    public final FqName getBASE_COLLECTIONS_PACKAGE() {
        return BASE_COLLECTIONS_PACKAGE;
    }

    public final FqName getBASE_RANGES_PACKAGE() {
        return BASE_RANGES_PACKAGE;
    }

    public final FqName getBASE_ANNOTATION_PACKAGE() {
        return BASE_ANNOTATION_PACKAGE;
    }

    public final FqName getBASE_COROUTINES_PACKAGE() {
        return BASE_COROUTINES_PACKAGE;
    }

    public final FqName getBASE_ENUMS_PACKAGE() {
        return BASE_ENUMS_PACKAGE;
    }

    public final FqName getBASE_CONCURRENT_ATOMICS_PACKAGE() {
        return BASE_CONCURRENT_ATOMICS_PACKAGE;
    }

    public final ClassId getArray() {
        return Array;
    }

    public final ClassId getKFunction() {
        return KFunction;
    }

    public final ClassId getKClass() {
        return KClass;
    }

    public final ClassId getMutableList() {
        return MutableList;
    }

    public final ClassId getMutableSet() {
        return MutableSet;
    }

    public final ClassId getMutableMap() {
        return MutableMap;
    }

    public final ClassId getEnumEntries() {
        return EnumEntries;
    }
}