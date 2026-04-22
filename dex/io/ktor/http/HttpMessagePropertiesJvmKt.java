package io.ktor.http;

import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpMessagePropertiesJvm.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\t\u001a\u00020\b*\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0002*\u00020\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u0002*\u00020\u0007¢\u0006\u0004\b\r\u0010\f\u001a\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0002*\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u0002*\u00020\u000e¢\u0006\u0004\b\r\u0010\u000f\u001a\u0013\u0010\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u000e¢\u0006\u0004\b\u0001\u0010\u000f\"\u0014\u0010\u0013\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"", "date", "Ljava/util/Date;", "parseHttpDate", "(Ljava/lang/String;)Ljava/util/Date;", "formatHttpDate", "(Ljava/util/Date;)Ljava/lang/String;", "Lio/ktor/http/HttpMessageBuilder;", "", "ifModifiedSince", "(Lio/ktor/http/HttpMessageBuilder;Ljava/util/Date;)V", "lastModified", "(Lio/ktor/http/HttpMessageBuilder;)Ljava/util/Date;", "expires", "Lio/ktor/http/HttpMessage;", "(Lio/ktor/http/HttpMessage;)Ljava/util/Date;", "Ljava/text/SimpleDateFormat;", "getHTTP_DATE_FORMAT", "()Ljava/text/SimpleDateFormat;", "HTTP_DATE_FORMAT", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpMessagePropertiesJvmKt {
    private static final SimpleDateFormat getHTTP_DATE_FORMAT() {
        SimpleDateFormat $this$_get_HTTP_DATE_FORMAT__u24lambda_u240 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        $this$_get_HTTP_DATE_FORMAT__u24lambda_u240.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        return $this$_get_HTTP_DATE_FORMAT__u24lambda_u240;
    }

    private static final Date parseHttpDate(String date) {
        Date parse = getHTTP_DATE_FORMAT().parse(date);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        return parse;
    }

    private static final String formatHttpDate(Date date) {
        String format = getHTTP_DATE_FORMAT().format(date);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final void ifModifiedSince(HttpMessageBuilder $this$ifModifiedSince, Date date) {
        Intrinsics.checkNotNullParameter($this$ifModifiedSince, "<this>");
        Intrinsics.checkNotNullParameter(date, "date");
        $this$ifModifiedSince.getHeaders().set(HttpHeaders.INSTANCE.getIfModifiedSince(), formatHttpDate(date));
    }

    public static final Date lastModified(HttpMessageBuilder $this$lastModified) {
        Intrinsics.checkNotNullParameter($this$lastModified, "<this>");
        String it = $this$lastModified.getHeaders().get(HttpHeaders.INSTANCE.getLastModified());
        if (it != null) {
            return parseHttpDate(it);
        }
        return null;
    }

    public static final Date expires(HttpMessageBuilder $this$expires) {
        Intrinsics.checkNotNullParameter($this$expires, "<this>");
        String it = $this$expires.getHeaders().get(HttpHeaders.INSTANCE.getExpires());
        if (it != null) {
            return parseHttpDate(it);
        }
        return null;
    }

    public static final Date lastModified(HttpMessage $this$lastModified) {
        Intrinsics.checkNotNullParameter($this$lastModified, "<this>");
        String it = $this$lastModified.getHeaders().get(HttpHeaders.INSTANCE.getLastModified());
        if (it != null) {
            return parseHttpDate(it);
        }
        return null;
    }

    public static final Date expires(HttpMessage $this$expires) {
        Intrinsics.checkNotNullParameter($this$expires, "<this>");
        String it = $this$expires.getHeaders().get(HttpHeaders.INSTANCE.getExpires());
        if (it != null) {
            return parseHttpDate(it);
        }
        return null;
    }

    public static final Date date(HttpMessage $this$date) {
        Intrinsics.checkNotNullParameter($this$date, "<this>");
        String it = $this$date.getHeaders().get(HttpHeaders.INSTANCE.getDate());
        if (it != null) {
            return parseHttpDate(it);
        }
        return null;
    }
}