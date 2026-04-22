package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: SpecialGenericSignatures.kt */
public class SpecialGenericSignatures {
    public static final Companion Companion = new Companion(null);
    private static final List<String> ERASED_COLLECTION_PARAMETER_NAMES;
    private static final List<Companion.NameAndSignature> ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
    private static final List<String> ERASED_COLLECTION_PARAMETER_SIGNATURES;
    private static final Set<Name> ERASED_VALUE_PARAMETERS_SHORT_NAMES;
    private static final Set<String> ERASED_VALUE_PARAMETERS_SIGNATURES;
    private static final Map<Companion.NameAndSignature, TypeSafeBarrierDescription> GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP;
    private static final Map<Name, Name> JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
    private static final Set<String> JVM_SIGNATURES_FOR_RENAMED_BUILT_INS;
    private static final Map<Companion.NameAndSignature, Name> NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
    private static final Set<Name> ORIGINAL_SHORT_NAMES;
    private static final Companion.NameAndSignature REMOVE_AT_NAME_AND_SIGNATURE;
    private static final Map<String, TypeSafeBarrierDescription> SIGNATURE_TO_DEFAULT_VALUES_MAP;
    private static final Map<String, Name> SIGNATURE_TO_JVM_REPRESENTATION_NAME;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SpecialGenericSignatures.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class TypeSafeBarrierDescription {
        private final Object defaultValue;
        public static final TypeSafeBarrierDescription NULL = new TypeSafeBarrierDescription("NULL", 0, null);
        public static final TypeSafeBarrierDescription INDEX = new TypeSafeBarrierDescription("INDEX", 1, -1);
        public static final TypeSafeBarrierDescription FALSE = new TypeSafeBarrierDescription("FALSE", 2, false);
        public static final TypeSafeBarrierDescription MAP_GET_OR_DEFAULT = new MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);
        private static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES = $values();
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        private static final /* synthetic */ TypeSafeBarrierDescription[] $values() {
            return new TypeSafeBarrierDescription[]{NULL, INDEX, FALSE, MAP_GET_OR_DEFAULT};
        }

        public /* synthetic */ TypeSafeBarrierDescription(String str, int i, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, obj);
        }

        public static TypeSafeBarrierDescription valueOf(String str) {
            return (TypeSafeBarrierDescription) Enum.valueOf(TypeSafeBarrierDescription.class, str);
        }

        public static TypeSafeBarrierDescription[] values() {
            return (TypeSafeBarrierDescription[]) $VALUES.clone();
        }

        private TypeSafeBarrierDescription(String $enum$name, int $enum$ordinal, Object defaultValue) {
            this.defaultValue = defaultValue;
        }

        /* compiled from: SpecialGenericSignatures.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            MAP_GET_OR_DEFAULT(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null, null);
            }
        }
    }

    /* compiled from: SpecialGenericSignatures.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);
        
        private final boolean isObjectReplacedWithTypeParameter;
        private final String valueParametersSignature;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        SpecialSignatureInfo(String valueParametersSignature, boolean isObjectReplacedWithTypeParameter) {
            this.valueParametersSignature = valueParametersSignature;
            this.isObjectReplacedWithTypeParameter = isObjectReplacedWithTypeParameter;
        }
    }

    /* compiled from: SpecialGenericSignatures.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SpecialSignatureInfo getSpecialSignatureInfo(String builtinSignature) {
            Intrinsics.checkNotNullParameter(builtinSignature, "builtinSignature");
            if (getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(builtinSignature)) {
                return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
            }
            TypeSafeBarrierDescription defaultValue = (TypeSafeBarrierDescription) MapsKt.getValue(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), builtinSignature);
            if (defaultValue == TypeSafeBarrierDescription.NULL) {
                return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
            }
            return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }

        /* compiled from: SpecialGenericSignatures.kt */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class NameAndSignature {
            private final String classInternalName;
            private final Name name;
            private final String parameters;
            private final String returnType;
            private final String signature;

            public static /* synthetic */ NameAndSignature copy$default(NameAndSignature nameAndSignature, String str, Name name, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = nameAndSignature.classInternalName;
                }
                if ((i & 2) != 0) {
                    name = nameAndSignature.name;
                }
                if ((i & 4) != 0) {
                    str2 = nameAndSignature.parameters;
                }
                if ((i & 8) != 0) {
                    str3 = nameAndSignature.returnType;
                }
                return nameAndSignature.copy(str, name, str2, str3);
            }

            public final NameAndSignature copy(String classInternalName, Name name, String parameters, String returnType) {
                Intrinsics.checkNotNullParameter(classInternalName, "classInternalName");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(parameters, "parameters");
                Intrinsics.checkNotNullParameter(returnType, "returnType");
                return new NameAndSignature(classInternalName, name, parameters, returnType);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof NameAndSignature) {
                    NameAndSignature nameAndSignature = (NameAndSignature) obj;
                    return Intrinsics.areEqual(this.classInternalName, nameAndSignature.classInternalName) && Intrinsics.areEqual(this.name, nameAndSignature.name) && Intrinsics.areEqual(this.parameters, nameAndSignature.parameters) && Intrinsics.areEqual(this.returnType, nameAndSignature.returnType);
                }
                return false;
            }

            public int hashCode() {
                return (((((this.classInternalName.hashCode() * 31) + this.name.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.returnType.hashCode();
            }

            public String toString() {
                return "NameAndSignature(classInternalName=" + this.classInternalName + ", name=" + this.name + ", parameters=" + this.parameters + ", returnType=" + this.returnType + ')';
            }

            public NameAndSignature(String classInternalName, Name name, String parameters, String returnType) {
                Intrinsics.checkNotNullParameter(classInternalName, "classInternalName");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(parameters, "parameters");
                Intrinsics.checkNotNullParameter(returnType, "returnType");
                this.classInternalName = classInternalName;
                this.name = name;
                this.parameters = parameters;
                this.returnType = returnType;
                this.signature = SignatureBuildingComponents.INSTANCE.signature(this.classInternalName, this.name + '(' + this.parameters + ')' + this.returnType);
            }

            public final Name getName() {
                return this.name;
            }

            public final String getSignature() {
                return this.signature;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final NameAndSignature method(String $this$method, String name, String parameters, String returnType) {
            Name identifier = Name.identifier(name);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            return new NameAndSignature($this$method, identifier, parameters, returnType);
        }

        public final List<String> getERASED_COLLECTION_PARAMETER_SIGNATURES() {
            return SpecialGenericSignatures.ERASED_COLLECTION_PARAMETER_SIGNATURES;
        }

        public final Map<String, TypeSafeBarrierDescription> getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
            return SpecialGenericSignatures.SIGNATURE_TO_DEFAULT_VALUES_MAP;
        }

        public final Set<Name> getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
            return SpecialGenericSignatures.ERASED_VALUE_PARAMETERS_SHORT_NAMES;
        }

        public final Set<String> getERASED_VALUE_PARAMETERS_SIGNATURES() {
            return SpecialGenericSignatures.ERASED_VALUE_PARAMETERS_SIGNATURES;
        }

        public final NameAndSignature getREMOVE_AT_NAME_AND_SIGNATURE() {
            return SpecialGenericSignatures.REMOVE_AT_NAME_AND_SIGNATURE;
        }

        public final Map<String, Name> getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
            return SpecialGenericSignatures.SIGNATURE_TO_JVM_REPRESENTATION_NAME;
        }

        public final Set<Name> getORIGINAL_SHORT_NAMES() {
            return SpecialGenericSignatures.ORIGINAL_SHORT_NAMES;
        }

        public final Map<Name, Name> getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
            return SpecialGenericSignatures.JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
        }

        public final Name getBuiltinFunctionNamesByJvmName(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(name);
        }

        public final boolean getSameAsRenamedInJvmBuiltin(Name $this$sameAsRenamedInJvmBuiltin) {
            Intrinsics.checkNotNullParameter($this$sameAsRenamedInJvmBuiltin, "<this>");
            return getORIGINAL_SHORT_NAMES().contains($this$sameAsRenamedInJvmBuiltin);
        }
    }

    static {
        Iterable $this$map$iv = SetsKt.setOf((Object[]) new String[]{"containsAll", "removeAll", "retainAll"});
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            Companion companion = Companion;
            String desc = JvmPrimitiveType.BOOLEAN.getDesc();
            Intrinsics.checkNotNullExpressionValue(desc, "getDesc(...)");
            destination$iv$iv.add(companion.method("java/util/Collection", it, "Ljava/util/Collection;", desc));
        }
        ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = (List) destination$iv$iv;
        Iterable $this$map$iv2 = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            Companion.NameAndSignature it2 = (Companion.NameAndSignature) item$iv$iv2;
            destination$iv$iv2.add(it2.getSignature());
        }
        ERASED_COLLECTION_PARAMETER_SIGNATURES = (List) destination$iv$iv2;
        Iterable $this$map$iv3 = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
        for (Object item$iv$iv3 : $this$map$iv3) {
            Companion.NameAndSignature it3 = (Companion.NameAndSignature) item$iv$iv3;
            destination$iv$iv3.add(it3.getName().asString());
        }
        ERASED_COLLECTION_PARAMETER_NAMES = (List) destination$iv$iv3;
        SignatureBuildingComponents $this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u240 = SignatureBuildingComponents.INSTANCE;
        Companion companion2 = Companion;
        String javaUtil = $this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u240.javaUtil("Collection");
        String desc2 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc2, "getDesc(...)");
        Companion companion3 = Companion;
        String javaUtil2 = $this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u240.javaUtil("Collection");
        String desc3 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc3, "getDesc(...)");
        Companion companion4 = Companion;
        String javaUtil3 = $this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u240.javaUtil("Map");
        String desc4 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc4, "getDesc(...)");
        Companion companion5 = Companion;
        String javaUtil4 = $this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u240.javaUtil("Map");
        String desc5 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc5, "getDesc(...)");
        Companion companion6 = Companion;
        String javaUtil5 = $this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u240.javaUtil("Map");
        String desc6 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc6, "getDesc(...)");
        Companion companion7 = Companion;
        String javaUtil6 = $this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u240.javaUtil("List");
        String desc7 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc7, "getDesc(...)");
        Companion companion8 = Companion;
        String javaUtil7 = $this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u240.javaUtil("List");
        String desc8 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc8, "getDesc(...)");
        GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = MapsKt.mapOf(TuplesKt.to(companion2.method(javaUtil, "contains", "Ljava/lang/Object;", desc2), TypeSafeBarrierDescription.FALSE), TuplesKt.to(companion3.method(javaUtil2, "remove", "Ljava/lang/Object;", desc3), TypeSafeBarrierDescription.FALSE), TuplesKt.to(companion4.method(javaUtil3, "containsKey", "Ljava/lang/Object;", desc4), TypeSafeBarrierDescription.FALSE), TuplesKt.to(companion5.method(javaUtil4, "containsValue", "Ljava/lang/Object;", desc5), TypeSafeBarrierDescription.FALSE), TuplesKt.to(companion6.method(javaUtil5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), TypeSafeBarrierDescription.FALSE), TuplesKt.to(Companion.method($this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u240.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), TuplesKt.to(Companion.method($this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u240.javaUtil("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.NULL), TuplesKt.to(Companion.method($this$GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP_u24lambda_u240.javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.NULL), TuplesKt.to(companion7.method(javaUtil6, "indexOf", "Ljava/lang/Object;", desc7), TypeSafeBarrierDescription.INDEX), TuplesKt.to(companion8.method(javaUtil7, "lastIndexOf", "Ljava/lang/Object;", desc8), TypeSafeBarrierDescription.INDEX));
        Map $this$mapKeys$iv = GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP;
        Map destination$iv$iv4 = new LinkedHashMap(MapsKt.mapCapacity($this$mapKeys$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = $this$mapKeys$iv.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it4 = (Map.Entry) element$iv$iv$iv;
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            destination$iv$iv4.put(((Companion.NameAndSignature) it4.getKey()).getSignature(), it$iv$iv.getValue());
        }
        SIGNATURE_TO_DEFAULT_VALUES_MAP = destination$iv$iv4;
        Iterable allMethods = SetsKt.plus((Set) GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP.keySet(), (Iterable) ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES);
        Iterable $this$map$iv4 = allMethods;
        Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
        for (Object item$iv$iv4 : $this$map$iv4) {
            Companion.NameAndSignature it5 = (Companion.NameAndSignature) item$iv$iv4;
            destination$iv$iv5.add(it5.getName());
        }
        ERASED_VALUE_PARAMETERS_SHORT_NAMES = CollectionsKt.toSet((List) destination$iv$iv5);
        Iterable $this$map$iv5 = allMethods;
        Collection destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
        for (Object item$iv$iv5 : $this$map$iv5) {
            Companion.NameAndSignature it6 = (Companion.NameAndSignature) item$iv$iv5;
            destination$iv$iv6.add(it6.getSignature());
        }
        ERASED_VALUE_PARAMETERS_SIGNATURES = CollectionsKt.toSet((List) destination$iv$iv6);
        Companion companion9 = Companion;
        String desc9 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc9, "getDesc(...)");
        REMOVE_AT_NAME_AND_SIGNATURE = companion9.method("java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        SignatureBuildingComponents $this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240 = SignatureBuildingComponents.INSTANCE;
        Companion companion10 = Companion;
        String javaLang = $this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaLang("Number");
        String desc10 = JvmPrimitiveType.BYTE.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc10, "getDesc(...)");
        Companion companion11 = Companion;
        String javaLang2 = $this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaLang("Number");
        String desc11 = JvmPrimitiveType.SHORT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc11, "getDesc(...)");
        Companion companion12 = Companion;
        String javaLang3 = $this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaLang("Number");
        String desc12 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc12, "getDesc(...)");
        Companion companion13 = Companion;
        String javaLang4 = $this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaLang("Number");
        String desc13 = JvmPrimitiveType.LONG.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc13, "getDesc(...)");
        Companion companion14 = Companion;
        String javaLang5 = $this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaLang("Number");
        String desc14 = JvmPrimitiveType.FLOAT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc14, "getDesc(...)");
        Companion companion15 = Companion;
        String javaLang6 = $this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaLang("Number");
        String desc15 = JvmPrimitiveType.DOUBLE.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc15, "getDesc(...)");
        Companion companion16 = Companion;
        String javaLang7 = $this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaLang("CharSequence");
        String desc16 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc16, "getDesc(...)");
        String desc17 = JvmPrimitiveType.CHAR.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc17, "getDesc(...)");
        NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = MapsKt.mapOf(TuplesKt.to(companion10.method(javaLang, "toByte", "", desc10), Name.identifier("byteValue")), TuplesKt.to(companion11.method(javaLang2, "toShort", "", desc11), Name.identifier("shortValue")), TuplesKt.to(companion12.method(javaLang3, "toInt", "", desc12), Name.identifier("intValue")), TuplesKt.to(companion13.method(javaLang4, "toLong", "", desc13), Name.identifier("longValue")), TuplesKt.to(companion14.method(javaLang5, "toFloat", "", desc14), Name.identifier("floatValue")), TuplesKt.to(companion15.method(javaLang6, "toDouble", "", desc15), Name.identifier("doubleValue")), TuplesKt.to(REMOVE_AT_NAME_AND_SIGNATURE, Name.identifier("remove")), TuplesKt.to(companion16.method(javaLang7, "get", desc16, desc17), Name.identifier("charAt")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicInteger"), "load", "", "I"), Name.identifier("get")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicInteger"), "store", "I", "V"), Name.identifier("set")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicInteger"), "exchange", "I", "I"), Name.identifier("getAndSet")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicInteger"), "fetchAndAdd", "I", "I"), Name.identifier("getAndAdd")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicInteger"), "addAndFetch", "I", "I"), Name.identifier("addAndGet")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicLong"), "load", "", "J"), Name.identifier("get")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicLong"), "store", "J", "V"), Name.identifier("set")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicLong"), "exchange", "J", "J"), Name.identifier("getAndSet")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicLong"), "fetchAndAdd", "J", "J"), Name.identifier("getAndAdd")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicLong"), "addAndFetch", "J", "J"), Name.identifier("addAndGet")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicBoolean"), "load", "", "Z"), Name.identifier("get")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicBoolean"), "store", "Z", "V"), Name.identifier("set")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicBoolean"), "exchange", "Z", "Z"), Name.identifier("getAndSet")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicReference"), "load", "", "Ljava/lang/Object;"), Name.identifier("get")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicReference"), "store", "Ljava/lang/Object;", "V"), Name.identifier("set")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicReference"), "exchange", "Ljava/lang/Object;", "Ljava/lang/Object;"), Name.identifier("getAndSet")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicIntegerArray"), "loadAt", "I", "I"), Name.identifier("get")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicIntegerArray"), "storeAt", "II", "V"), Name.identifier("set")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicIntegerArray"), "exchangeAt", "II", "I"), Name.identifier("getAndSet")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicIntegerArray"), "compareAndSetAt", "III", "Z"), Name.identifier("compareAndSet")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicIntegerArray"), "fetchAndAddAt", "II", "I"), Name.identifier("getAndAdd")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicIntegerArray"), "addAndFetchAt", "II", "I"), Name.identifier("addAndGet")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicLongArray"), "loadAt", "I", "J"), Name.identifier("get")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicLongArray"), "storeAt", "IJ", "V"), Name.identifier("set")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicLongArray"), "exchangeAt", "IJ", "J"), Name.identifier("getAndSet")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicLongArray"), "compareAndSetAt", "IJJ", "Z"), Name.identifier("compareAndSet")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicLongArray"), "fetchAndAddAt", "IJ", "J"), Name.identifier("getAndAdd")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicLongArray"), "addAndFetchAt", "IJ", "J"), Name.identifier("addAndGet")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicReferenceArray"), "loadAt", "I", "Ljava/lang/Object;"), Name.identifier("get")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicReferenceArray"), "storeAt", "ILjava/lang/Object;", "V"), Name.identifier("set")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicReferenceArray"), "exchangeAt", "ILjava/lang/Object;", "Ljava/lang/Object;"), Name.identifier("getAndSet")), TuplesKt.to(Companion.method($this$NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP_u24lambda_u240.javaUtilConcurrentAtomic("AtomicReferenceArray"), "compareAndSetAt", "ILjava/lang/Object;Ljava/lang/Object;", "Z"), Name.identifier("compareAndSet")));
        Map $this$mapKeys$iv2 = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
        Map destination$iv$iv7 = new LinkedHashMap(MapsKt.mapCapacity($this$mapKeys$iv2.size()));
        Iterable $this$associateByTo$iv$iv$iv2 = $this$mapKeys$iv2.entrySet();
        for (Object element$iv$iv$iv2 : $this$associateByTo$iv$iv$iv2) {
            Map.Entry it7 = (Map.Entry) element$iv$iv$iv2;
            Map.Entry it$iv$iv2 = (Map.Entry) element$iv$iv$iv2;
            destination$iv$iv7.put(((Companion.NameAndSignature) it7.getKey()).getSignature(), it$iv$iv2.getValue());
        }
        SIGNATURE_TO_JVM_REPRESENTATION_NAME = destination$iv$iv7;
        Map $this$mapTo$iv = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
        Collection destination$iv = (Set) new LinkedHashSet();
        for (Map.Entry item$iv : $this$mapTo$iv.entrySet()) {
            Companion.NameAndSignature signatureAndName = item$iv.getKey();
            Name jdkName = item$iv.getValue();
            destination$iv.add(Companion.NameAndSignature.copy$default(signatureAndName, null, jdkName, null, null, 13, null).getSignature());
        }
        JVM_SIGNATURES_FOR_RENAMED_BUILT_INS = (Set) destination$iv;
        Iterable<Companion.NameAndSignature> $this$mapTo$iv2 = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.keySet();
        Collection destination$iv2 = new HashSet();
        for (Companion.NameAndSignature it8 : $this$mapTo$iv2) {
            destination$iv2.add(it8.getName());
        }
        ORIGINAL_SHORT_NAMES = (Set) destination$iv2;
        Iterable $this$map$iv6 = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.entrySet();
        Collection destination$iv$iv8 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
        for (Object item$iv$iv6 : $this$map$iv6) {
            Map.Entry it9 = (Map.Entry) item$iv$iv6;
            destination$iv$iv8.add(new Pair(((Companion.NameAndSignature) it9.getKey()).getName(), it9.getValue()));
        }
        Iterable $this$associateBy$iv = (List) destination$iv$iv8;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv9 = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            Pair it10 = (Pair) element$iv$iv;
            Pair it11 = (Pair) element$iv$iv;
            destination$iv$iv9.put((Name) it10.getSecond(), (Name) it11.getFirst());
        }
        JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = destination$iv$iv9;
    }
}