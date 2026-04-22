package io.ktor.http;

import io.ktor.http.ContentDisposition;
import io.ktor.util.StringValuesBuilderImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Headers.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lio/ktor/http/HeadersBuilder;", "Lio/ktor/util/StringValuesBuilderImpl;", "", ContentDisposition.Parameters.Size, "<init>", "(I)V", "Lio/ktor/http/Headers;", "build", "()Lio/ktor/http/Headers;", "", ContentDisposition.Parameters.Name, "", "validateName", "(Ljava/lang/String;)V", "value", "validateValue", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HeadersBuilder extends StringValuesBuilderImpl {
    public HeadersBuilder() {
        this(0, 1, null);
    }

    public HeadersBuilder(int size) {
        super(true, size);
    }

    public /* synthetic */ HeadersBuilder(int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 8 : i2);
    }

    /* renamed from: build */
    public Headers m3526build() {
        return new HeadersImpl(getValues());
    }

    protected void validateName(String name) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        super.validateName(name);
        HttpHeaders.INSTANCE.checkHeaderName(name);
    }

    protected void validateValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        super.validateValue(value);
        HttpHeaders.INSTANCE.checkHeaderValue(value);
    }
}