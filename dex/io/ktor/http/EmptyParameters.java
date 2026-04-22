package io.ktor.http;

import io.ktor.http.ContentDisposition;
import io.ktor.http.Parameters;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Parameters.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00060\f0\tH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010¨\u0006\u0019"}, d2 = {"Lio/ktor/http/EmptyParameters;", "Lio/ktor/http/Parameters;", "<init>", "()V", "", ContentDisposition.Parameters.Name, "", "getAll", "(Ljava/lang/String;)Ljava/util/List;", "", "names", "()Ljava/util/Set;", "", "entries", "", "isEmpty", "()Z", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "getCaseInsensitiveName", "caseInsensitiveName", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EmptyParameters implements Parameters {
    public static final EmptyParameters INSTANCE = new EmptyParameters();

    private EmptyParameters() {
    }

    public boolean contains(String name) {
        return Parameters.DefaultImpls.contains(this, name);
    }

    public boolean contains(String name, String value) {
        return Parameters.DefaultImpls.contains(this, name, value);
    }

    public void forEach(Function2<? super String, ? super List<String>, Unit> function2) {
        Parameters.DefaultImpls.forEach(this, function2);
    }

    public String get(String name) {
        return Parameters.DefaultImpls.get(this, name);
    }

    public boolean getCaseInsensitiveName() {
        return true;
    }

    public List<String> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        return null;
    }

    public Set<String> names() {
        return SetsKt.emptySet();
    }

    public Set<Map.Entry<String, List<String>>> entries() {
        return SetsKt.emptySet();
    }

    public boolean isEmpty() {
        return true;
    }

    public String toString() {
        return "Parameters " + entries();
    }

    public boolean equals(Object other) {
        return (other instanceof Parameters) && ((Parameters) other).isEmpty();
    }
}