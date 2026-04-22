package io.ktor.http;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HttpHeaderValueParser.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\fR\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lio/ktor/http/HeaderValue;", "", "", "value", "", "Lio/ktor/http/HeaderValueParam;", "params", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/List;", "copy", "(Ljava/lang/String;Ljava/util/List;)Lio/ktor/http/HeaderValue;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getValue", "Ljava/util/List;", "getParams", "", "quality", "D", "getQuality", "()D", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HeaderValue {
    private final List<HeaderValueParam> params;
    private final double quality;
    private final String value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeaderValue copy$default(HeaderValue headerValue, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = headerValue.value;
        }
        if ((i2 & 2) != 0) {
            list = headerValue.params;
        }
        return headerValue.copy(str, list);
    }

    public final String component1() {
        return this.value;
    }

    public final List<HeaderValueParam> component2() {
        return this.params;
    }

    public final HeaderValue copy(String str, List<HeaderValueParam> list) {
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(list, "params");
        return new HeaderValue(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeaderValue) {
            HeaderValue headerValue = (HeaderValue) obj;
            return Intrinsics.areEqual(this.value, headerValue.value) && Intrinsics.areEqual(this.params, headerValue.params);
        }
        return false;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + this.params.hashCode();
    }

    public String toString() {
        return "HeaderValue(value=" + this.value + ", params=" + this.params + ')';
    }

    public HeaderValue(String value, List<HeaderValueParam> list) {
        Object element$iv;
        String value2;
        Double doubleOrNull;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(list, "params");
        this.value = value;
        this.params = list;
        Iterable $this$firstOrNull$iv = this.params;
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            if (Intrinsics.areEqual(((HeaderValueParam) element$iv).getName(), "q")) {
                break;
            }
        }
        HeaderValueParam headerValueParam = (HeaderValueParam) element$iv;
        double d2 = 1.0d;
        if (headerValueParam != null && (value2 = headerValueParam.getValue()) != null && (doubleOrNull = StringsKt.toDoubleOrNull(value2)) != null) {
            double it2 = doubleOrNull.doubleValue();
            boolean z = false;
            if (0.0d <= it2 && it2 <= 1.0d) {
                z = true;
            }
            Double d3 = z ? doubleOrNull : null;
            if (d3 != null) {
                d2 = d3.doubleValue();
            }
        }
        this.quality = d2;
    }

    public /* synthetic */ HeaderValue(String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<HeaderValueParam> getParams() {
        return this.params;
    }

    public final String getValue() {
        return this.value;
    }

    public final double getQuality() {
        return this.quality;
    }
}