package io.ktor.client.request;

import com.tencent.smtt.sdk.TbsVideoCacheTask;
import faceverify.q;
import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.Cookie;
import io.ktor.http.CookieEncoding;
import io.ktor.http.CookieKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.util.Base64Kt;
import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: utils.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a{\u0010\u0014\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015\u001a#\u0010\u0017\u001a\u00020\u0005*\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0019\u0010\u001b\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001c\u001a!\u0010\u001f\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001¢\u0006\u0004\b\u001f\u0010 \u001a\u0019\u0010\"\u001a\u00020\u0005*\u00020\u00002\u0006\u0010!\u001a\u00020\u0001¢\u0006\u0004\b\"\u0010#\"(\u0010(\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\"(\u0010-\u001a\u00020\t*\u00020\u00162\u0006\u0010\u0004\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006."}, d2 = {"Lio/ktor/http/HttpMessageBuilder;", "", q.KEY_RES_9_KEY, "", "value", "", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "(Lio/ktor/http/HttpMessageBuilder;Ljava/lang/String;Ljava/lang/Object;)V", ContentDisposition.Parameters.Name, "", "maxAge", "Lio/ktor/util/date/GMTDate;", "expires", "domain", "path", "", "secure", "httpOnly", "", "extensions", "cookie", "(Lio/ktor/http/HttpMessageBuilder;Ljava/lang/String;Ljava/lang/String;ILio/ktor/util/date/GMTDate;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;)V", "Lio/ktor/client/request/HttpRequestBuilder;", "parameter", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;Ljava/lang/Object;)V", "Lio/ktor/http/ContentType;", "contentType", "accept", "(Lio/ktor/http/HttpMessageBuilder;Lio/ktor/http/ContentType;)V", "username", "password", "basicAuth", "(Lio/ktor/http/HttpMessageBuilder;Ljava/lang/String;Ljava/lang/String;)V", "token", "bearerAuth", "(Lio/ktor/http/HttpMessageBuilder;Ljava/lang/String;)V", "getHost", "(Lio/ktor/client/request/HttpRequestBuilder;)Ljava/lang/String;", "setHost", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;)V", "host", "getPort", "(Lio/ktor/client/request/HttpRequestBuilder;)I", "setPort", "(Lio/ktor/client/request/HttpRequestBuilder;I)V", "port", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class UtilsKt {
    public static final String getHost(HttpRequestBuilder $this$host) {
        Intrinsics.checkNotNullParameter($this$host, "<this>");
        return $this$host.getUrl().getHost();
    }

    public static final void setHost(HttpRequestBuilder $this$host, String value) {
        Intrinsics.checkNotNullParameter($this$host, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$host.getUrl().setHost(value);
    }

    public static final int getPort(HttpRequestBuilder $this$port) {
        Intrinsics.checkNotNullParameter($this$port, "<this>");
        return $this$port.getUrl().getPort();
    }

    public static final void setPort(HttpRequestBuilder $this$port, int value) {
        Intrinsics.checkNotNullParameter($this$port, "<this>");
        $this$port.getUrl().setPort(value);
    }

    public static final void header(HttpMessageBuilder $this$header, String key, Object value) {
        Intrinsics.checkNotNullParameter($this$header, "<this>");
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        if (value != null) {
            $this$header.getHeaders().append(key, value.toString());
        }
    }

    public static final void cookie(HttpMessageBuilder $this$cookie, String name, String value, int maxAge, GMTDate expires, String domain, String path, boolean secure, boolean httpOnly, Map<String, String> map) {
        Intrinsics.checkNotNullParameter($this$cookie, "<this>");
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(map, "extensions");
        Cookie p0 = new Cookie(name, value, (CookieEncoding) null, Integer.valueOf(maxAge), expires, domain, path, secure, httpOnly, map, 4, (DefaultConstructorMarker) null);
        String renderedCookie = CookieKt.renderCookieHeader(p0);
        if (!$this$cookie.getHeaders().contains(HttpHeaders.INSTANCE.getCookie())) {
            $this$cookie.getHeaders().append(HttpHeaders.INSTANCE.getCookie(), renderedCookie);
        } else {
            $this$cookie.getHeaders().set(HttpHeaders.INSTANCE.getCookie(), $this$cookie.getHeaders().get(HttpHeaders.INSTANCE.getCookie()) + "; " + renderedCookie);
        }
    }

    public static final void parameter(HttpRequestBuilder $this$parameter, String key, Object value) {
        Intrinsics.checkNotNullParameter($this$parameter, "<this>");
        Intrinsics.checkNotNullParameter(key, q.KEY_RES_9_KEY);
        if (value != null) {
            $this$parameter.getUrl().getParameters().append(key, value.toString());
        }
    }

    public static final void accept(HttpMessageBuilder $this$accept, ContentType contentType) {
        Intrinsics.checkNotNullParameter($this$accept, "<this>");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        $this$accept.getHeaders().append(HttpHeaders.INSTANCE.getAccept(), contentType.toString());
    }

    public static final void basicAuth(HttpMessageBuilder $this$basicAuth, String username, String password) {
        Intrinsics.checkNotNullParameter($this$basicAuth, "<this>");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        header($this$basicAuth, HttpHeaders.INSTANCE.getAuthorization(), "Basic " + Base64Kt.encodeBase64(username + ':' + password));
    }

    public static final void bearerAuth(HttpMessageBuilder $this$bearerAuth, String token) {
        Intrinsics.checkNotNullParameter($this$bearerAuth, "<this>");
        Intrinsics.checkNotNullParameter(token, "token");
        header($this$bearerAuth, HttpHeaders.INSTANCE.getAuthorization(), "Bearer " + token);
    }
}