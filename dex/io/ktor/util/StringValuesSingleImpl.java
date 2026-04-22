package io.ktor.util;

import BottomSheetItemData$;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: StringValues.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00060\r0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0096\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001f\u001a\u00020\u001d2\u001e\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b!\u0010\"J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010#\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010&R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010\u0014R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"Lio/ktor/util/StringValuesSingleImpl;", "Lio/ktor/util/StringValues;", "", "caseInsensitiveName", "", "name", "", "values", "<init>", "(ZLjava/lang/String;Ljava/util/List;)V", "getAll", "(Ljava/lang/String;)Ljava/util/List;", "", "", "entries", "()Ljava/util/Set;", "isEmpty", "()Z", "names", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/Function2;", "", "body", "forEach", "(Lkotlin/jvm/functions/Function2;)V", "get", "(Ljava/lang/String;)Ljava/lang/String;", "contains", "(Ljava/lang/String;)Z", "value", "(Ljava/lang/String;Ljava/lang/String;)Z", "Z", "getCaseInsensitiveName", "Ljava/lang/String;", "getName", "Ljava/util/List;", "getValues", "()Ljava/util/List;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class StringValuesSingleImpl implements StringValues {
    private final boolean caseInsensitiveName;
    private final String name;
    private final List<String> values;

    public StringValuesSingleImpl(boolean caseInsensitiveName, String name, List<String> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(list, "values");
        this.caseInsensitiveName = caseInsensitiveName;
        this.name = name;
        this.values = list;
    }

    @Override // io.ktor.util.StringValues
    public boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getValues() {
        return this.values;
    }

    @Override // io.ktor.util.StringValues
    public List<String> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (StringsKt.equals(this.name, name, getCaseInsensitiveName())) {
            return this.values;
        }
        return null;
    }

    @Override // io.ktor.util.StringValues
    public Set<Map.Entry<String, List<String>>> entries() {
        return SetsKt.setOf(new StringValuesSingleImpl$entries$1(this));
    }

    @Override // io.ktor.util.StringValues
    public boolean isEmpty() {
        return false;
    }

    @Override // io.ktor.util.StringValues
    public Set<String> names() {
        return SetsKt.setOf(this.name);
    }

    public String toString() {
        return "StringValues(case=" + (!getCaseInsensitiveName()) + ") " + entries();
    }

    public int hashCode() {
        int entriesHashCode;
        entriesHashCode = StringValuesKt.entriesHashCode(entries(), BottomSheetItemData$.ExternalSyntheticBackport0.m(getCaseInsensitiveName()) * 31);
        return entriesHashCode;
    }

    public boolean equals(Object other) {
        boolean entriesEquals;
        if (this == other) {
            return true;
        }
        if ((other instanceof StringValues) && getCaseInsensitiveName() == ((StringValues) other).getCaseInsensitiveName()) {
            entriesEquals = StringValuesKt.entriesEquals(entries(), ((StringValues) other).entries());
            return entriesEquals;
        }
        return false;
    }

    @Override // io.ktor.util.StringValues
    public void forEach(Function2<? super String, ? super List<String>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "body");
        function2.invoke(this.name, this.values);
    }

    @Override // io.ktor.util.StringValues
    public String get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (StringsKt.equals(name, this.name, getCaseInsensitiveName())) {
            return (String) kotlin.collections.CollectionsKt.firstOrNull(this.values);
        }
        return null;
    }

    @Override // io.ktor.util.StringValues
    public boolean contains(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.equals(name, this.name, getCaseInsensitiveName());
    }

    @Override // io.ktor.util.StringValues
    public boolean contains(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return StringsKt.equals(name, this.name, getCaseInsensitiveName()) && this.values.contains(value);
    }
}