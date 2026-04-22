package io.ktor.util;

import BottomSheetItemData$;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringValues.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0019\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00180\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u0015J/\u0010\u001d\u001a\u00020\u001b2\u001e\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0006\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010\u000eJ\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"H\u0096\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010\u0017R,\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"Lio/ktor/util/StringValuesImpl;", "Lio/ktor/util/StringValues;", "", "caseInsensitiveName", "", "", "", "values", "<init>", "(ZLjava/util/Map;)V", "name", "get", "(Ljava/lang/String;)Ljava/lang/String;", "getAll", "(Ljava/lang/String;)Ljava/util/List;", "contains", "(Ljava/lang/String;)Z", "value", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "names", "()Ljava/util/Set;", "isEmpty", "()Z", "", "entries", "Lkotlin/Function2;", "", "body", "forEach", "(Lkotlin/jvm/functions/Function2;)V", "listForKey", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Z", "getCaseInsensitiveName", "Ljava/util/Map;", "getValues", "()Ljava/util/Map;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class StringValuesImpl implements StringValues {
    private final boolean caseInsensitiveName;
    private final Map<String, List<String>> values;

    public StringValuesImpl() {
        this(false, null, 3, null);
    }

    public StringValuesImpl(boolean caseInsensitiveName, Map<String, ? extends List<String>> map) {
        Intrinsics.checkNotNullParameter(map, "values");
        this.caseInsensitiveName = caseInsensitiveName;
        Map newMap = this.caseInsensitiveName ? CollectionsKt.caseInsensitiveMap() : new LinkedHashMap();
        for (Map.Entry element$iv : map.entrySet()) {
            String key = element$iv.getKey();
            List<String> value = element$iv.getValue();
            int size = value.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                int it = i;
                arrayList.add(value.get(it));
            }
            newMap.put(key, arrayList);
        }
        this.values = newMap;
    }

    public /* synthetic */ StringValuesImpl(boolean z, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    @Override // io.ktor.util.StringValues
    public final boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    protected final Map<String, List<String>> getValues() {
        return this.values;
    }

    @Override // io.ktor.util.StringValues
    public String get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<String> listForKey = listForKey(name);
        if (listForKey != null) {
            return (String) kotlin.collections.CollectionsKt.firstOrNull(listForKey);
        }
        return null;
    }

    @Override // io.ktor.util.StringValues
    public List<String> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return listForKey(name);
    }

    @Override // io.ktor.util.StringValues
    public boolean contains(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return listForKey(name) != null;
    }

    @Override // io.ktor.util.StringValues
    public boolean contains(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        List<String> listForKey = listForKey(name);
        if (listForKey != null) {
            return listForKey.contains(value);
        }
        return false;
    }

    @Override // io.ktor.util.StringValues
    public Set<String> names() {
        return CollectionsJvmKt.unmodifiable(this.values.keySet());
    }

    @Override // io.ktor.util.StringValues
    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    @Override // io.ktor.util.StringValues
    public Set<Map.Entry<String, List<String>>> entries() {
        return CollectionsJvmKt.unmodifiable(this.values.entrySet());
    }

    @Override // io.ktor.util.StringValues
    public void forEach(Function2<? super String, ? super List<String>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "body");
        for (Map.Entry<String, List<String>> entry : this.values.entrySet()) {
            String key = entry.getKey();
            List value = entry.getValue();
            function2.invoke(key, value);
        }
    }

    private final List<String> listForKey(String name) {
        return this.values.get(name);
    }

    public String toString() {
        return "StringValues(case=" + (!this.caseInsensitiveName) + ") " + entries();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof StringValues) && this.caseInsensitiveName == ((StringValues) other).getCaseInsensitiveName()) {
            return StringValuesKt.access$entriesEquals(entries(), ((StringValues) other).entries());
        }
        return false;
    }

    public int hashCode() {
        return StringValuesKt.access$entriesHashCode(entries(), BottomSheetItemData$.ExternalSyntheticBackport0.m(this.caseInsensitiveName) * 31);
    }
}