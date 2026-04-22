package io.ktor.util;

import com.bilibili.playset.playlist.helper.ReportHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringValues.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010&\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u00160\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0013J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u001aJ\u0017\u0010 \u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\"\u0010!J%\u0010 \u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0#H\u0016¢\u0006\u0004\b \u0010%J%\u0010\"\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0#H\u0016¢\u0006\u0004\b\"\u0010%J\u0017\u0010&\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0018H\u0016¢\u0006\u0004\b(\u0010)J\u001f\u0010&\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010\u0010J\u000f\u0010*\u001a\u00020\u0018H\u0016¢\u0006\u0004\b*\u0010)J\u000f\u0010+\u001a\u00020\u001eH\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b-\u0010'J\u0017\u0010.\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\bH\u0014¢\u0006\u0004\b.\u0010'J\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\b0/2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b0\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u0010\u0015R,\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0/038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b$\u00104\u001a\u0004\b5\u00106¨\u00067"}, d2 = {"Lio/ktor/util/StringValuesBuilderImpl;", "Lio/ktor/util/StringValuesBuilder;", "", "caseInsensitiveName", "", "size", "<init>", "(ZI)V", "", "name", "", "getAll", "(Ljava/lang/String;)Ljava/util/List;", "contains", "(Ljava/lang/String;)Z", "value", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "names", "()Ljava/util/Set;", "isEmpty", "()Z", "", "entries", "", "set", "(Ljava/lang/String;Ljava/lang/String;)V", "get", "(Ljava/lang/String;)Ljava/lang/String;", "append", "Lio/ktor/util/StringValues;", "stringValues", "appendAll", "(Lio/ktor/util/StringValues;)V", "appendMissing", "", "values", "(Ljava/lang/String;Ljava/lang/Iterable;)V", "remove", "(Ljava/lang/String;)V", "removeKeysWithNoEntries", "()V", ReportHelper.EventValue.REPORT_EVENT_VALUE_CLEAR_INVALID_CLEAR, "build", "()Lio/ktor/util/StringValues;", "validateName", "validateValue", "", "ensureListForKey", "Z", "getCaseInsensitiveName", "", "Ljava/util/Map;", "getValues", "()Ljava/util/Map;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class StringValuesBuilderImpl implements StringValuesBuilder {
    private final boolean caseInsensitiveName;
    private final Map<String, List<String>> values;

    public StringValuesBuilderImpl() {
        this(false, 0, 3, null);
    }

    public StringValuesBuilderImpl(boolean caseInsensitiveName, int size) {
        this.caseInsensitiveName = caseInsensitiveName;
        this.values = this.caseInsensitiveName ? CollectionsKt.caseInsensitiveMap() : new LinkedHashMap(size);
    }

    public /* synthetic */ StringValuesBuilderImpl(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 8 : i);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public final boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    protected final Map<String, List<String>> getValues() {
        return this.values;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public List<String> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.values.get(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean contains(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.values.containsKey(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean contains(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        List<String> list = this.values.get(name);
        if (list != null) {
            return list.contains(value);
        }
        return false;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set<String> names() {
        return this.values.keySet();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set<Map.Entry<String, List<String>>> entries() {
        return CollectionsJvmKt.unmodifiable(this.values.entrySet());
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void set(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        validateValue(value);
        List list = ensureListForKey(name);
        list.clear();
        list.add(value);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public String get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<String> all = getAll(name);
        if (all != null) {
            return (String) kotlin.collections.CollectionsKt.firstOrNull(all);
        }
        return null;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void append(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        validateValue(value);
        ensureListForKey(name).add(value);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendAll(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "stringValues");
        stringValues.forEach(new Function2() { // from class: io.ktor.util.StringValuesBuilderImpl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit appendAll$lambda$0;
                appendAll$lambda$0 = StringValuesBuilderImpl.appendAll$lambda$0(StringValuesBuilderImpl.this, (String) obj, (List) obj2);
                return appendAll$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit appendAll$lambda$0(StringValuesBuilderImpl this$0, String name, List values) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        this$0.appendAll(name, values);
        return Unit.INSTANCE;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendMissing(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "stringValues");
        stringValues.forEach(new Function2() { // from class: io.ktor.util.StringValuesBuilderImpl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit appendMissing$lambda$1;
                appendMissing$lambda$1 = StringValuesBuilderImpl.appendMissing$lambda$1(StringValuesBuilderImpl.this, (String) obj, (List) obj2);
                return appendMissing$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit appendMissing$lambda$1(StringValuesBuilderImpl this$0, String name, List values) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        this$0.appendMissing(name, values);
        return Unit.INSTANCE;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendAll(String name, Iterable<String> iterable) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(iterable, "values");
        List list = ensureListForKey(name);
        for (Object element$iv : iterable) {
            String it = (String) element$iv;
            validateValue(it);
        }
        kotlin.collections.CollectionsKt.addAll(list, iterable);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendMissing(String name, Iterable<String> iterable) {
        Set existing;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(iterable, "values");
        List<String> list = this.values.get(name);
        if (list == null || (existing = kotlin.collections.CollectionsKt.toSet(list)) == null) {
            existing = SetsKt.emptySet();
        }
        Collection destination$iv$iv = new ArrayList();
        for (String str : iterable) {
            String it = str;
            if (!existing.contains(it)) {
                destination$iv$iv.add(str);
            }
        }
        appendAll(name, (List) destination$iv$iv);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void remove(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.values.remove(name);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void removeKeysWithNoEntries() {
        Map $this$filter$iv = this.values;
        Map destination$iv$iv = new LinkedHashMap();
        for (Map.Entry element$iv$iv : $this$filter$iv.entrySet()) {
            if (element$iv$iv.getValue().isEmpty()) {
                destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
            }
        }
        for (Map.Entry entry : destination$iv$iv.entrySet()) {
            String k = (String) entry.getKey();
            remove(k);
        }
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean remove(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        List<String> list = this.values.get(name);
        if (list != null) {
            return list.remove(value);
        }
        return false;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void clear() {
        this.values.clear();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public StringValues build() {
        return new StringValuesImpl(this.caseInsensitiveName, this.values);
    }

    protected void validateName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
    }

    protected void validateValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
    }

    private final List<String> ensureListForKey(String name) {
        List<String> list = this.values.get(name);
        if (list == null) {
            List it = new ArrayList();
            validateName(name);
            this.values.put(name, it);
            return it;
        }
        return list;
    }
}