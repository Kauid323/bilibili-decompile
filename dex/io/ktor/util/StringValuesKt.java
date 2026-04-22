package io.ktor.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringValues.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u001aO\u0010\b\u001a\u00020\u000726\u0010\u0004\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u00010\u0000\"\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\f\u001a-\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u000e\u001a\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u000f\u001a1\u0010\b\u001a\u00020\u00072\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u00102\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0013\u001a#\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0010*\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a#\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00010\u0003*\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u001b\u001a\u00020\u0019*\u00020\u00072\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0004\b\u001b\u0010\u001c\u001a5\u0010\u001f\u001a\u00020\u0007*\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00052\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0018¢\u0006\u0004\b\u001f\u0010 \u001a=\u0010#\u001a\u00020\u0019*\u00020!2\u0006\u0010\"\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00052\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0018¢\u0006\u0004\b#\u0010$\u001a\u0019\u0010&\u001a\u00020!*\u00020!2\u0006\u0010%\u001a\u00020!¢\u0006\u0004\b&\u0010'\u001a!\u0010(\u001a\u00020!*\u00020!2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b(\u0010)\u001a!\u0010*\u001a\u00020!*\u00020!2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b*\u0010)\u001aO\u0010/\u001a\u00020\u00052\u001e\u0010-\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030,0+2\u001e\u0010.\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030,0+H\u0002¢\u0006\u0004\b/\u00100\u001a7\u00104\u001a\u0002022\u001e\u00101\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030,0+2\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b4\u00105¨\u00066"}, d2 = {"", "Lkotlin/Pair;", "", "", "pairs", "", "caseInsensitiveKey", "Lio/ktor/util/StringValues;", "valuesOf", "([Lkotlin/Pair;Z)Lio/ktor/util/StringValues;", "name", "value", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/ktor/util/StringValues;", "values", "(Ljava/lang/String;Ljava/util/List;Z)Lio/ktor/util/StringValues;", "()Lio/ktor/util/StringValues;", "", "", "map", "(Ljava/util/Map;Z)Lio/ktor/util/StringValues;", "toMap", "(Lio/ktor/util/StringValues;)Ljava/util/Map;", "flattenEntries", "(Lio/ktor/util/StringValues;)Ljava/util/List;", "Lkotlin/Function2;", "", "block", "flattenForEach", "(Lio/ktor/util/StringValues;Lkotlin/jvm/functions/Function2;)V", "keepEmpty", "predicate", "filter", "(Lio/ktor/util/StringValues;ZLkotlin/jvm/functions/Function2;)Lio/ktor/util/StringValues;", "Lio/ktor/util/StringValuesBuilder;", "source", "appendFiltered", "(Lio/ktor/util/StringValuesBuilder;Lio/ktor/util/StringValues;ZLkotlin/jvm/functions/Function2;)V", "builder", "appendAll", "(Lio/ktor/util/StringValuesBuilder;Lio/ktor/util/StringValuesBuilder;)Lio/ktor/util/StringValuesBuilder;", "appendIfNameAbsent", "(Lio/ktor/util/StringValuesBuilder;Ljava/lang/String;Ljava/lang/String;)Lio/ktor/util/StringValuesBuilder;", "appendIfNameAndValueAbsent", "", "", "a", "b", "entriesEquals", "(Ljava/util/Set;Ljava/util/Set;)Z", "entries", "", "seed", "entriesHashCode", "(Ljava/util/Set;I)I", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class StringValuesKt {
    public static final /* synthetic */ boolean access$entriesEquals(Set a, Set b) {
        return entriesEquals(a, b);
    }

    public static final /* synthetic */ int access$entriesHashCode(Set entries, int seed) {
        return entriesHashCode(entries, seed);
    }

    public static /* synthetic */ StringValues valuesOf$default(Pair[] pairArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return valuesOf(pairArr, z);
    }

    public static final StringValues valuesOf(Pair<String, ? extends List<String>>[] pairArr, boolean caseInsensitiveKey) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        return new StringValuesImpl(caseInsensitiveKey, MapsKt.toMap(ArraysKt.asList(pairArr)));
    }

    public static /* synthetic */ StringValues valuesOf$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return valuesOf(str, str2, z);
    }

    public static final StringValues valuesOf(String name, String value, boolean caseInsensitiveKey) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return new StringValuesSingleImpl(caseInsensitiveKey, name, kotlin.collections.CollectionsKt.listOf(value));
    }

    public static /* synthetic */ StringValues valuesOf$default(String str, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return valuesOf(str, list, z);
    }

    public static final StringValues valuesOf(String name, List<String> list, boolean caseInsensitiveKey) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(list, "values");
        return new StringValuesSingleImpl(caseInsensitiveKey, name, list);
    }

    public static final StringValues valuesOf() {
        return StringValues.Companion.getEmpty();
    }

    public static /* synthetic */ StringValues valuesOf$default(Map map, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return valuesOf(map, z);
    }

    public static final StringValues valuesOf(Map<String, ? extends Iterable<String>> map, boolean caseInsensitiveKey) {
        Intrinsics.checkNotNullParameter(map, "map");
        int size = map.size();
        if (size == 1) {
            Map.Entry entry = (Map.Entry) kotlin.collections.CollectionsKt.single(map.entrySet());
            return new StringValuesSingleImpl(caseInsensitiveKey, (String) entry.getKey(), kotlin.collections.CollectionsKt.toList((Iterable) entry.getValue()));
        }
        LinkedHashMap values = caseInsensitiveKey ? CollectionsKt.caseInsensitiveMap() : new LinkedHashMap(size);
        Iterable $this$forEach$iv = map.entrySet();
        for (Object element$iv : $this$forEach$iv) {
            Map.Entry it = (Map.Entry) element$iv;
            values.put(it.getKey(), kotlin.collections.CollectionsKt.toList((Iterable) it.getValue()));
        }
        return new StringValuesImpl(caseInsensitiveKey, values);
    }

    public static final Map<String, List<String>> toMap(StringValues $this$toMap) {
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        Iterable $this$associateByTo$iv = $this$toMap.entries();
        Map destination$iv = new LinkedHashMap();
        for (Object element$iv : $this$associateByTo$iv) {
            Map.Entry it = (Map.Entry) element$iv;
            Map.Entry it2 = (Map.Entry) element$iv;
            destination$iv.put((String) it.getKey(), kotlin.collections.CollectionsKt.toList((Iterable) it2.getValue()));
        }
        return destination$iv;
    }

    public static final List<Pair<String, String>> flattenEntries(StringValues $this$flattenEntries) {
        Intrinsics.checkNotNullParameter($this$flattenEntries, "<this>");
        Iterable $this$flatMap$iv = $this$flattenEntries.entries();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            Map.Entry e = (Map.Entry) element$iv$iv;
            Iterable $this$map$iv = (Iterable) e.getValue();
            Collection destination$iv$iv2 = new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Iterable $this$flatMap$iv2 = $this$flatMap$iv;
                String it = (String) item$iv$iv;
                destination$iv$iv2.add(TuplesKt.to(e.getKey(), it));
                $this$flatMap$iv = $this$flatMap$iv2;
            }
            Iterable $this$flatMap$iv3 = $this$flatMap$iv;
            Iterable list$iv$iv = (List) destination$iv$iv2;
            kotlin.collections.CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            $this$flatMap$iv = $this$flatMap$iv3;
        }
        return (List) destination$iv$iv;
    }

    public static final void flattenForEach(StringValues $this$flattenForEach, final Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter($this$flattenForEach, "<this>");
        Intrinsics.checkNotNullParameter(function2, "block");
        $this$flattenForEach.forEach(new Function2() { // from class: io.ktor.util.StringValuesKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit flattenForEach$lambda$6;
                flattenForEach$lambda$6 = StringValuesKt.flattenForEach$lambda$6(function2, (String) obj, (List) obj2);
                return flattenForEach$lambda$6;
            }
        });
    }

    public static final Unit flattenForEach$lambda$6(Function2 $block, String name, List items) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(items, "items");
        List $this$forEach$iv = items;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String) element$iv;
            $block.invoke(name, it);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ StringValues filter$default(StringValues stringValues, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return filter(stringValues, z, function2);
    }

    public static final StringValues filter(StringValues $this$filter, boolean keepEmpty, Function2<? super String, ? super String, Boolean> function2) {
        Intrinsics.checkNotNullParameter($this$filter, "<this>");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        Set entries = $this$filter.entries();
        LinkedHashMap values = $this$filter.getCaseInsensitiveName() ? CollectionsKt.caseInsensitiveMap() : new LinkedHashMap(entries.size());
        Set<Map.Entry> $this$forEach$iv = entries;
        for (Map.Entry entry : $this$forEach$iv) {
            Iterable $this$filterTo$iv = (Iterable) entry.getValue();
            Collection destination$iv = new ArrayList(((List) entry.getValue()).size());
            for (Object element$iv : $this$filterTo$iv) {
                String it = (String) element$iv;
                Set entries2 = entries;
                if (((Boolean) function2.invoke(entry.getKey(), it)).booleanValue()) {
                    destination$iv.add(element$iv);
                }
                entries = entries2;
            }
            Set entries3 = entries;
            ArrayList list = (ArrayList) destination$iv;
            if (keepEmpty || !list.isEmpty()) {
                values.put(entry.getKey(), list);
            }
            entries = entries3;
        }
        return new StringValuesImpl($this$filter.getCaseInsensitiveName(), values);
    }

    public static /* synthetic */ void appendFiltered$default(StringValuesBuilder stringValuesBuilder, StringValues stringValues, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        appendFiltered(stringValuesBuilder, stringValues, z, function2);
    }

    public static final void appendFiltered(final StringValuesBuilder $this$appendFiltered, StringValues source, final boolean keepEmpty, final Function2<? super String, ? super String, Boolean> function2) {
        Intrinsics.checkNotNullParameter($this$appendFiltered, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        source.forEach(new Function2() { // from class: io.ktor.util.StringValuesKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit appendFiltered$lambda$10;
                appendFiltered$lambda$10 = StringValuesKt.appendFiltered$lambda$10(keepEmpty, $this$appendFiltered, function2, (String) obj, (List) obj2);
                return appendFiltered$lambda$10;
            }
        });
    }

    public static final Unit appendFiltered$lambda$10(boolean $keepEmpty, StringValuesBuilder $this_appendFiltered, Function2 $predicate, String name, List value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        List $this$filterTo$iv = value;
        Collection destination$iv = new ArrayList(value.size());
        for (Object element$iv : $this$filterTo$iv) {
            String it = (String) element$iv;
            if (((Boolean) $predicate.invoke(name, it)).booleanValue()) {
                destination$iv.add(element$iv);
            }
        }
        ArrayList list = (ArrayList) destination$iv;
        if ($keepEmpty || !list.isEmpty()) {
            $this_appendFiltered.appendAll(name, list);
        }
        return Unit.INSTANCE;
    }

    public static final StringValuesBuilder appendAll(StringValuesBuilder $this$appendAll, StringValuesBuilder builder) {
        Intrinsics.checkNotNullParameter($this$appendAll, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Iterable $this$forEach$iv = builder.entries();
        for (Object element$iv : $this$forEach$iv) {
            Map.Entry entry = (Map.Entry) element$iv;
            String name = (String) entry.getKey();
            List values = (List) entry.getValue();
            $this$appendAll.appendAll(name, values);
        }
        return $this$appendAll;
    }

    public static final StringValuesBuilder appendIfNameAbsent(StringValuesBuilder $this$appendIfNameAbsent, String name, String value) {
        Intrinsics.checkNotNullParameter($this$appendIfNameAbsent, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!$this$appendIfNameAbsent.contains(name)) {
            $this$appendIfNameAbsent.append(name, value);
        }
        return $this$appendIfNameAbsent;
    }

    public static final StringValuesBuilder appendIfNameAndValueAbsent(StringValuesBuilder $this$appendIfNameAndValueAbsent, String name, String value) {
        Intrinsics.checkNotNullParameter($this$appendIfNameAndValueAbsent, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!$this$appendIfNameAndValueAbsent.contains(name, value)) {
            $this$appendIfNameAndValueAbsent.append(name, value);
        }
        return $this$appendIfNameAndValueAbsent;
    }

    public static final boolean entriesEquals(Set<? extends Map.Entry<String, ? extends List<String>>> set, Set<? extends Map.Entry<String, ? extends List<String>>> set2) {
        return Intrinsics.areEqual(set, set2);
    }

    public static final int entriesHashCode(Set<? extends Map.Entry<String, ? extends List<String>>> set, int seed) {
        return (seed * 31) + set.hashCode();
    }
}