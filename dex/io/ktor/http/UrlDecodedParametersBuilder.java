package io.ktor.http;

import io.ktor.http.ContentDisposition;
import io.ktor.util.StringValues;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UrlDecodedParametersBuilder.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010&\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0018\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u00170\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0014J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u001bJ\u0017\u0010!\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J%\u0010!\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0#H\u0016¢\u0006\u0004\b!\u0010%J\u0017\u0010&\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b&\u0010\"J%\u0010&\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0#H\u0016¢\u0006\u0004\b&\u0010%J\u0017\u0010'\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010'\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010\u0011J\u000f\u0010)\u001a\u00020\u0019H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0019H\u0016¢\u0006\u0004\b+\u0010*R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010,R\u001a\u0010-\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0016¨\u00060"}, d2 = {"Lio/ktor/http/UrlDecodedParametersBuilder;", "Lio/ktor/http/ParametersBuilder;", "encodedParametersBuilder", "<init>", "(Lio/ktor/http/ParametersBuilder;)V", "Lio/ktor/http/Parameters;", "build", "()Lio/ktor/http/Parameters;", "", ContentDisposition.Parameters.Name, "", "getAll", "(Ljava/lang/String;)Ljava/util/List;", "", "contains", "(Ljava/lang/String;)Z", "value", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "names", "()Ljava/util/Set;", "isEmpty", "()Z", "", "entries", "", "set", "(Ljava/lang/String;Ljava/lang/String;)V", "get", "(Ljava/lang/String;)Ljava/lang/String;", "append", "Lio/ktor/util/StringValues;", "stringValues", "appendAll", "(Lio/ktor/util/StringValues;)V", "", "values", "(Ljava/lang/String;Ljava/lang/Iterable;)V", "appendMissing", "remove", "(Ljava/lang/String;)V", "removeKeysWithNoEntries", "()V", "clear", "Lio/ktor/http/ParametersBuilder;", "caseInsensitiveName", "Z", "getCaseInsensitiveName", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UrlDecodedParametersBuilder implements ParametersBuilder {
    private final boolean caseInsensitiveName;
    private final ParametersBuilder encodedParametersBuilder;

    public UrlDecodedParametersBuilder(ParametersBuilder encodedParametersBuilder) {
        Intrinsics.checkNotNullParameter(encodedParametersBuilder, "encodedParametersBuilder");
        this.encodedParametersBuilder = encodedParametersBuilder;
        this.caseInsensitiveName = this.encodedParametersBuilder.getCaseInsensitiveName();
    }

    @Override // io.ktor.http.ParametersBuilder
    /* renamed from: build */
    public Parameters m3533build() {
        return UrlDecodedParametersBuilderKt.decodeParameters(this.encodedParametersBuilder);
    }

    public boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    public List<String> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Iterable all = this.encodedParametersBuilder.getAll(CodecsKt.encodeURLParameter$default(name, false, 1, null));
        if (all != null) {
            Iterable $this$map$iv = all;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv.add(CodecsKt.decodeURLQueryComponent$default(it, 0, 0, true, null, 11, null));
            }
            return (List) destination$iv$iv;
        }
        return null;
    }

    public boolean contains(String name) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        return this.encodedParametersBuilder.contains(CodecsKt.encodeURLParameter$default(name, false, 1, null));
    }

    public boolean contains(String name, String value) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(value, "value");
        return this.encodedParametersBuilder.contains(CodecsKt.encodeURLParameter$default(name, false, 1, null), CodecsKt.encodeURLParameterValue(value));
    }

    public Set<String> names() {
        Iterable $this$map$iv = this.encodedParametersBuilder.names();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(CodecsKt.decodeURLQueryComponent$default(it, 0, 0, false, null, 15, null));
        }
        return CollectionsKt.toSet((List) destination$iv$iv);
    }

    public boolean isEmpty() {
        return this.encodedParametersBuilder.isEmpty();
    }

    public Set<Map.Entry<String, List<String>>> entries() {
        return UrlDecodedParametersBuilderKt.decodeParameters(this.encodedParametersBuilder).entries();
    }

    public void set(String name, String value) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(value, "value");
        this.encodedParametersBuilder.set(CodecsKt.encodeURLParameter$default(name, false, 1, null), CodecsKt.encodeURLParameterValue(value));
    }

    public String get(String name) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        String str = this.encodedParametersBuilder.get(CodecsKt.encodeURLParameter$default(name, false, 1, null));
        if (str != null) {
            return CodecsKt.decodeURLQueryComponent$default(str, 0, 0, true, null, 11, null);
        }
        return null;
    }

    public void append(String name, String value) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(value, "value");
        this.encodedParametersBuilder.append(CodecsKt.encodeURLParameter$default(name, false, 1, null), CodecsKt.encodeURLParameterValue(value));
    }

    public void appendAll(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "stringValues");
        UrlDecodedParametersBuilderKt.access$appendAllEncoded(this.encodedParametersBuilder, stringValues);
    }

    public void appendAll(String name, Iterable<String> iterable) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(iterable, "values");
        ParametersBuilder parametersBuilder = this.encodedParametersBuilder;
        String encodeURLParameter$default = CodecsKt.encodeURLParameter$default(name, false, 1, null);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object item$iv$iv : iterable) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(CodecsKt.encodeURLParameterValue(it));
        }
        parametersBuilder.appendAll(encodeURLParameter$default, (List) destination$iv$iv);
    }

    public void appendMissing(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "stringValues");
        this.encodedParametersBuilder.appendMissing(UrlDecodedParametersBuilderKt.encodeParameters(stringValues).build());
    }

    public void appendMissing(String name, Iterable<String> iterable) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(iterable, "values");
        ParametersBuilder parametersBuilder = this.encodedParametersBuilder;
        String encodeURLParameter$default = CodecsKt.encodeURLParameter$default(name, false, 1, null);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object item$iv$iv : iterable) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(CodecsKt.encodeURLParameterValue(it));
        }
        parametersBuilder.appendMissing(encodeURLParameter$default, (List) destination$iv$iv);
    }

    public void remove(String name) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        this.encodedParametersBuilder.remove(CodecsKt.encodeURLParameter$default(name, false, 1, null));
    }

    public boolean remove(String name, String value) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(value, "value");
        return this.encodedParametersBuilder.remove(CodecsKt.encodeURLParameter$default(name, false, 1, null), CodecsKt.encodeURLParameterValue(value));
    }

    public void removeKeysWithNoEntries() {
        this.encodedParametersBuilder.removeKeysWithNoEntries();
    }

    public void clear() {
        this.encodedParametersBuilder.clear();
    }
}