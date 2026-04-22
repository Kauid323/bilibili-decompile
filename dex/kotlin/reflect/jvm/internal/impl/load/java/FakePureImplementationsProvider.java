package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;

/* compiled from: FakePureImplementationsProvider.kt */
public final class FakePureImplementationsProvider {
    public static final FakePureImplementationsProvider INSTANCE = new FakePureImplementationsProvider();
    private static final Map<ClassId, ClassId> pureImplementationsClassIds = new LinkedHashMap();
    private static final Map<FqName, FqName> pureImplementationsFqNames;

    private FakePureImplementationsProvider() {
    }

    public final FqName getPurelyImplementedInterface(FqName classFqName) {
        Intrinsics.checkNotNullParameter(classFqName, "classFqName");
        return pureImplementationsFqNames.get(classFqName);
    }

    static {
        INSTANCE.implementedWith(StandardClassIds.INSTANCE.getMutableList(), INSTANCE.fqNameListOf("java.util.ArrayList", "java.util.LinkedList"));
        INSTANCE.implementedWith(StandardClassIds.INSTANCE.getMutableSet(), INSTANCE.fqNameListOf("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        INSTANCE.implementedWith(StandardClassIds.INSTANCE.getMutableMap(), INSTANCE.fqNameListOf("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        INSTANCE.implementedWith(ClassId.Companion.topLevel(new FqName("java.util.function.Function")), INSTANCE.fqNameListOf("java.util.function.UnaryOperator"));
        INSTANCE.implementedWith(ClassId.Companion.topLevel(new FqName("java.util.function.BiFunction")), INSTANCE.fqNameListOf("java.util.function.BinaryOperator"));
        Map $this$map$iv = pureImplementationsClassIds;
        Collection destination$iv$iv = new ArrayList($this$map$iv.size());
        for (Map.Entry item$iv$iv : $this$map$iv.entrySet()) {
            ClassId key = item$iv$iv.getKey();
            ClassId value = item$iv$iv.getValue();
            destination$iv$iv.add(TuplesKt.to(key.asSingleFqName(), value.asSingleFqName()));
        }
        pureImplementationsFqNames = MapsKt.toMap((List) destination$iv$iv);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void implementedWith(ClassId $this$implementedWith, List<ClassId> list) {
        List<ClassId> $this$associateWithTo$iv = list;
        Map destination$iv = pureImplementationsClassIds;
        for (Object element$iv : $this$associateWithTo$iv) {
            ClassId classId = (ClassId) element$iv;
            destination$iv.put(element$iv, $this$implementedWith);
        }
    }

    private final List<ClassId> fqNameListOf(String... names) {
        Collection destination$iv$iv = new ArrayList(names.length);
        for (String str : names) {
            destination$iv$iv.add(ClassId.Companion.topLevel(new FqName(str)));
        }
        return (List) destination$iv$iv;
    }
}