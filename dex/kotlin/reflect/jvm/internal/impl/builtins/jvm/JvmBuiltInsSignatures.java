package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: JvmBuiltInsSignatures.kt */
public final class JvmBuiltInsSignatures {
    private static final Set<String> DEPRECATED_LIST_METHODS;
    private static final Set<String> HIDDEN_CONSTRUCTOR_SIGNATURES;
    private static final Set<String> HIDDEN_METHOD_SIGNATURES;
    private static final Set<String> MUTABLE_METHOD_SIGNATURES;
    private static final Set<String> VISIBLE_CONSTRUCTOR_SIGNATURES;
    private static final Set<String> VISIBLE_METHOD_SIGNATURES;
    public static final JvmBuiltInsSignatures INSTANCE = new JvmBuiltInsSignatures();
    private static final Set<String> DROP_LIST_METHOD_SIGNATURES = SetsKt.plus(SignatureBuildingComponents.INSTANCE.inJavaUtil("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");

    private JvmBuiltInsSignatures() {
    }

    public final Set<String> getDROP_LIST_METHOD_SIGNATURES() {
        return DROP_LIST_METHOD_SIGNATURES;
    }

    static {
        SignatureBuildingComponents $this$HIDDEN_METHOD_SIGNATURES_u24lambda_u240 = SignatureBuildingComponents.INSTANCE;
        HIDDEN_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus((Set) INSTANCE.buildPrimitiveValueMethodsSet(), (Iterable) $this$HIDDEN_METHOD_SIGNATURES_u24lambda_u240.inJavaUtil("List", "sort(Ljava/util/Comparator;)V", "reversed()Ljava/util/List;")), (Iterable) $this$HIDDEN_METHOD_SIGNATURES_u24lambda_u240.inJavaLang("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), (Iterable) $this$HIDDEN_METHOD_SIGNATURES_u24lambda_u240.inJavaLang("Double", "isInfinite()Z", "isNaN()Z")), (Iterable) $this$HIDDEN_METHOD_SIGNATURES_u24lambda_u240.inJavaLang("Float", "isInfinite()Z", "isNaN()Z")), (Iterable) $this$HIDDEN_METHOD_SIGNATURES_u24lambda_u240.inJavaLang("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), (Iterable) $this$HIDDEN_METHOD_SIGNATURES_u24lambda_u240.inJavaLang("CharSequence", "isEmpty()Z"));
        SignatureBuildingComponents $this$DEPRECATED_LIST_METHODS_u24lambda_u240 = SignatureBuildingComponents.INSTANCE;
        DEPRECATED_LIST_METHODS = $this$DEPRECATED_LIST_METHODS_u24lambda_u240.inJavaUtil("List", "getFirst()Ljava/lang/Object;", "getLast()Ljava/lang/Object;");
        SignatureBuildingComponents $this$VISIBLE_METHOD_SIGNATURES_u24lambda_u240 = SignatureBuildingComponents.INSTANCE;
        VISIBLE_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus((Set) $this$VISIBLE_METHOD_SIGNATURES_u24lambda_u240.inJavaLang("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), (Iterable) $this$VISIBLE_METHOD_SIGNATURES_u24lambda_u240.inJavaUtil("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), (Iterable) $this$VISIBLE_METHOD_SIGNATURES_u24lambda_u240.inJavaLang("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), (Iterable) $this$VISIBLE_METHOD_SIGNATURES_u24lambda_u240.inJavaLang("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), (Iterable) $this$VISIBLE_METHOD_SIGNATURES_u24lambda_u240.inJavaUtil("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), (Iterable) $this$VISIBLE_METHOD_SIGNATURES_u24lambda_u240.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "addFirst(Ljava/lang/Object;)V", "addLast(Ljava/lang/Object;)V", "removeFirst()Ljava/lang/Object;", "removeLast()Ljava/lang/Object;")), (Iterable) $this$VISIBLE_METHOD_SIGNATURES_u24lambda_u240.inJavaUtil("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        SignatureBuildingComponents $this$MUTABLE_METHOD_SIGNATURES_u24lambda_u240 = SignatureBuildingComponents.INSTANCE;
        MUTABLE_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus((Set) $this$MUTABLE_METHOD_SIGNATURES_u24lambda_u240.inJavaUtil("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), (Iterable) $this$MUTABLE_METHOD_SIGNATURES_u24lambda_u240.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V", "addFirst(Ljava/lang/Object;)V", "addLast(Ljava/lang/Object;)V", "removeFirst()Ljava/lang/Object;", "removeLast()Ljava/lang/Object;")), (Iterable) $this$MUTABLE_METHOD_SIGNATURES_u24lambda_u240.inJavaUtil("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        SignatureBuildingComponents $this$HIDDEN_CONSTRUCTOR_SIGNATURES_u24lambda_u240 = SignatureBuildingComponents.INSTANCE;
        Set<String> buildPrimitiveStringConstructorsSet = INSTANCE.buildPrimitiveStringConstructorsSet();
        String[] constructors = $this$HIDDEN_CONSTRUCTOR_SIGNATURES_u24lambda_u240.constructors("D");
        Set plus = SetsKt.plus((Set) buildPrimitiveStringConstructorsSet, (Iterable) $this$HIDDEN_CONSTRUCTOR_SIGNATURES_u24lambda_u240.inJavaLang("Float", (String[]) Arrays.copyOf(constructors, constructors.length)));
        String[] constructors2 = $this$HIDDEN_CONSTRUCTOR_SIGNATURES_u24lambda_u240.constructors("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        HIDDEN_CONSTRUCTOR_SIGNATURES = SetsKt.plus(plus, (Iterable) $this$HIDDEN_CONSTRUCTOR_SIGNATURES_u24lambda_u240.inJavaLang("String", (String[]) Arrays.copyOf(constructors2, constructors2.length)));
        SignatureBuildingComponents $this$VISIBLE_CONSTRUCTOR_SIGNATURES_u24lambda_u240 = SignatureBuildingComponents.INSTANCE;
        String[] constructors3 = $this$VISIBLE_CONSTRUCTOR_SIGNATURES_u24lambda_u240.constructors("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        VISIBLE_CONSTRUCTOR_SIGNATURES = $this$VISIBLE_CONSTRUCTOR_SIGNATURES_u24lambda_u240.inJavaLang("Throwable", (String[]) Arrays.copyOf(constructors3, constructors3.length));
    }

    public final Set<String> getHIDDEN_METHOD_SIGNATURES() {
        return HIDDEN_METHOD_SIGNATURES;
    }

    private final Set<String> buildPrimitiveValueMethodsSet() {
        SignatureBuildingComponents $this$buildPrimitiveValueMethodsSet_u24lambda_u240 = SignatureBuildingComponents.INSTANCE;
        Iterable $this$flatMapTo$iv = CollectionsKt.listOf((Object[]) new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR});
        Collection destination$iv = new LinkedHashSet();
        for (Object element$iv : $this$flatMapTo$iv) {
            JvmPrimitiveType it = (JvmPrimitiveType) element$iv;
            String asString = it.getWrapperFqName().shortName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
            Iterable list$iv = $this$buildPrimitiveValueMethodsSet_u24lambda_u240.inJavaLang(asString, it.getJavaKeywordName() + "Value()" + it.getDesc());
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        return (LinkedHashSet) destination$iv;
    }

    public final Set<String> getDEPRECATED_LIST_METHODS() {
        return DEPRECATED_LIST_METHODS;
    }

    public final Set<String> getVISIBLE_METHOD_SIGNATURES() {
        return VISIBLE_METHOD_SIGNATURES;
    }

    public final Set<String> getMUTABLE_METHOD_SIGNATURES() {
        return MUTABLE_METHOD_SIGNATURES;
    }

    public final Set<String> getHIDDEN_CONSTRUCTOR_SIGNATURES() {
        return HIDDEN_CONSTRUCTOR_SIGNATURES;
    }

    public final Set<String> getVISIBLE_CONSTRUCTOR_SIGNATURES() {
        return VISIBLE_CONSTRUCTOR_SIGNATURES;
    }

    private final Set<String> buildPrimitiveStringConstructorsSet() {
        SignatureBuildingComponents $this$buildPrimitiveStringConstructorsSet_u24lambda_u240 = SignatureBuildingComponents.INSTANCE;
        Iterable $this$flatMapTo$iv = CollectionsKt.listOf((Object[]) new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.BYTE, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, JvmPrimitiveType.BYTE, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT});
        Collection destination$iv = new LinkedHashSet();
        for (Object element$iv : $this$flatMapTo$iv) {
            JvmPrimitiveType it = (JvmPrimitiveType) element$iv;
            String asString = it.getWrapperFqName().shortName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
            String[] constructors = $this$buildPrimitiveStringConstructorsSet_u24lambda_u240.constructors("Ljava/lang/String;");
            Iterable list$iv = $this$buildPrimitiveStringConstructorsSet_u24lambda_u240.inJavaLang(asString, (String[]) Arrays.copyOf(constructors, constructors.length));
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        return (LinkedHashSet) destination$iv;
    }

    public final boolean isSerializableInJava(FqNameUnsafe fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (isArrayOrPrimitiveArray(fqName)) {
            return true;
        }
        ClassId javaClassId = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqName);
        if (javaClassId == null) {
            return false;
        }
        try {
            Class classViaReflection = Class.forName(javaClassId.asSingleFqName().asString());
            return Serializable.class.isAssignableFrom(classViaReflection);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public final boolean isArrayOrPrimitiveArray(FqNameUnsafe fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return Intrinsics.areEqual(fqName, StandardNames.FqNames.array) || StandardNames.isPrimitiveArray(fqName);
    }
}