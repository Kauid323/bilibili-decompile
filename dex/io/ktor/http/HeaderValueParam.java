package io.ktor.http;

import io.ktor.http.ContentDisposition;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HttpHeaderValueParser.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J.\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014¨\u0006\u001d"}, d2 = {"Lio/ktor/http/HeaderValueParam;", "", "", ContentDisposition.Parameters.Name, "value", "", "escapeValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "(Ljava/lang/String;Ljava/lang/String;)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "()Z", "copy", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/ktor/http/HeaderValueParam;", "toString", "Ljava/lang/String;", "getName", "getValue", "Z", "getEscapeValue", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HeaderValueParam {
    private final boolean escapeValue;
    private final String name;
    private final String value;

    public static /* synthetic */ HeaderValueParam copy$default(HeaderValueParam headerValueParam, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = headerValueParam.name;
        }
        if ((i2 & 2) != 0) {
            str2 = headerValueParam.value;
        }
        if ((i2 & 4) != 0) {
            z = headerValueParam.escapeValue;
        }
        return headerValueParam.copy(str, str2, z);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.value;
    }

    public final boolean component3() {
        return this.escapeValue;
    }

    public final HeaderValueParam copy(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        return new HeaderValueParam(str, str2, z);
    }

    public String toString() {
        return "HeaderValueParam(name=" + this.name + ", value=" + this.value + ", escapeValue=" + this.escapeValue + ')';
    }

    public HeaderValueParam(String name, String value, boolean escapeValue) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = name;
        this.value = value;
        this.escapeValue = escapeValue;
    }

    public final boolean getEscapeValue() {
        return this.escapeValue;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeaderValueParam(String name, String value) {
        this(name, value, false);
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(value, "value");
    }

    public boolean equals(Object other) {
        return (other instanceof HeaderValueParam) && StringsKt.equals(((HeaderValueParam) other).name, this.name, true) && StringsKt.equals(((HeaderValueParam) other).value, this.value, true);
    }

    public int hashCode() {
        String lowerCase = this.name.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int result = lowerCase.hashCode();
        String lowerCase2 = this.value.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return result + (result * 31) + lowerCase2.hashCode();
    }
}