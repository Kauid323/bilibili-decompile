package io.ktor.http;

import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: ContentTypes.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0019\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002*\u00020\u0007¢\u0006\u0004\b\u0003\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/http/ContentType;", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "withCharset", "(Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;)Lio/ktor/http/ContentType;", "withCharsetIfNeeded", "Lio/ktor/http/HeaderValueWithParameters;", "(Lio/ktor/http/HeaderValueWithParameters;)Ljava/nio/charset/Charset;", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContentTypesKt {
    public static final ContentType withCharset(ContentType $this$withCharset, Charset charset) {
        Intrinsics.checkNotNullParameter($this$withCharset, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        return $this$withCharset.withParameter(HttpAuthHeader.Parameters.Charset, CharsetJVMKt.getName(charset));
    }

    public static final ContentType withCharsetIfNeeded(ContentType $this$withCharsetIfNeeded, Charset charset) {
        Intrinsics.checkNotNullParameter($this$withCharsetIfNeeded, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        String lowerCase = $this$withCharsetIfNeeded.getContentType().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (!Intrinsics.areEqual(lowerCase, "text")) {
            return $this$withCharsetIfNeeded;
        }
        return $this$withCharsetIfNeeded.withParameter(HttpAuthHeader.Parameters.Charset, CharsetJVMKt.getName(charset));
    }

    public static final Charset charset(HeaderValueWithParameters $this$charset) {
        Intrinsics.checkNotNullParameter($this$charset, "<this>");
        String it = $this$charset.parameter(HttpAuthHeader.Parameters.Charset);
        if (it != null) {
            try {
                return CharsetJVMKt.forName(Charsets.INSTANCE, it);
            } catch (IllegalArgumentException e2) {
                return null;
            }
        }
        return null;
    }
}