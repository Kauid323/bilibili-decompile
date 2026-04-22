package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: BuiltinSpecialProperties.kt */
public final class BuiltinSpecialProperties {
    private static final Set<FqName> GETTER_FQ_NAMES;
    private static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP;
    public static final BuiltinSpecialProperties INSTANCE = new BuiltinSpecialProperties();
    private static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    private static final Set<FqName> SPECIAL_FQ_NAMES;
    private static final Set<Name> SPECIAL_SHORT_NAMES;

    private BuiltinSpecialProperties() {
    }

    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    }

    static {
        FqName childSafe;
        FqName childSafe2;
        FqName child;
        FqName child2;
        FqName childSafe3;
        FqName child3;
        FqName child4;
        FqName child5;
        FqName child6;
        FqName child7;
        FqName child8;
        ArrayList arrayList;
        childSafe = BuiltinSpecialPropertiesKt.childSafe(StandardNames.FqNames._enum, "name");
        childSafe2 = BuiltinSpecialPropertiesKt.childSafe(StandardNames.FqNames._enum, "ordinal");
        child = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.collection, "size");
        child2 = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.map, "size");
        childSafe3 = BuiltinSpecialPropertiesKt.childSafe(StandardNames.FqNames.charSequence, "length");
        child3 = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.map, "keys");
        child4 = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.map, "values");
        child5 = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.map, "entries");
        child6 = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.atomicIntArray, "size");
        child7 = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.atomicLongArray, "size");
        child8 = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.atomicArray, "size");
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = MapsKt.mapOf(TuplesKt.to(childSafe, StandardNames.NAME), TuplesKt.to(childSafe2, Name.identifier("ordinal")), TuplesKt.to(child, Name.identifier("size")), TuplesKt.to(child2, Name.identifier("size")), TuplesKt.to(childSafe3, Name.identifier("length")), TuplesKt.to(child3, Name.identifier("keySet")), TuplesKt.to(child4, Name.identifier("values")), TuplesKt.to(child5, Name.identifier("entrySet")), TuplesKt.to(child6, Name.identifier("length")), TuplesKt.to(child7, Name.identifier("length")), TuplesKt.to(child8, Name.identifier("length")));
        Iterable $this$map$iv = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.entrySet();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Map.Entry it = (Map.Entry) item$iv$iv;
            destination$iv$iv.add(new Pair(((FqName) it.getKey()).shortName(), it.getValue()));
        }
        Iterable $this$groupBy$iv = (List) destination$iv$iv;
        Map destination$iv$iv2 = new LinkedHashMap();
        for (Object element$iv$iv : $this$groupBy$iv) {
            Pair it2 = (Pair) element$iv$iv;
            Name name = (Name) it2.getSecond();
            Object value$iv$iv$iv = destination$iv$iv2.get(name);
            if (value$iv$iv$iv == null) {
                arrayList = new ArrayList();
                destination$iv$iv2.put(name, arrayList);
            } else {
                arrayList = value$iv$iv$iv;
            }
            Object key$iv$iv$iv = arrayList;
            List list$iv$iv = (List) key$iv$iv$iv;
            Pair it3 = (Pair) element$iv$iv;
            list$iv$iv.add((Name) it3.getFirst());
        }
        Map destination$iv$iv3 = new LinkedHashMap(MapsKt.mapCapacity(destination$iv$iv2.size()));
        Iterable $this$associateByTo$iv$iv$iv = destination$iv$iv2.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Map.Entry it4 = (Map.Entry) element$iv$iv$iv;
            destination$iv$iv3.put(it$iv$iv.getKey(), CollectionsKt.distinct((Iterable) it4.getValue()));
        }
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = destination$iv$iv3;
        Map $this$mapTo$iv = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
        Collection destination$iv = (Set) new LinkedHashSet();
        for (Map.Entry item$iv : $this$mapTo$iv.entrySet()) {
            ClassId mapKotlinToJava = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(item$iv.getKey().parent().toUnsafe());
            Intrinsics.checkNotNull(mapKotlinToJava);
            destination$iv.add(mapKotlinToJava.asSingleFqName().child(item$iv.getValue()));
        }
        GETTER_FQ_NAMES = (Set) destination$iv;
        SPECIAL_FQ_NAMES = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        Iterable $this$map$iv2 = SPECIAL_FQ_NAMES;
        Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            FqName p0 = (FqName) item$iv$iv2;
            destination$iv$iv4.add(p0.shortName());
        }
        SPECIAL_SHORT_NAMES = CollectionsKt.toSet((List) destination$iv$iv4);
    }

    public final Set<FqName> getSPECIAL_FQ_NAMES() {
        return SPECIAL_FQ_NAMES;
    }

    public final Set<Name> getSPECIAL_SHORT_NAMES() {
        return SPECIAL_SHORT_NAMES;
    }

    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(Name name1) {
        Intrinsics.checkNotNullParameter(name1, "name1");
        List<Name> list = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(name1);
        return list == null ? CollectionsKt.emptyList() : list;
    }
}