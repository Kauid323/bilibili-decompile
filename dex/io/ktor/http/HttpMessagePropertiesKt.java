package io.ktor.http;

import com.xiaomi.mipush.sdk.Constants;
import faceverify.q;
import io.ktor.http.auth.HttpAuthHeader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HttpMessageProperties.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u000f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\r\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0010\u001a\u0019\u0010\u0013\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012*\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0013\u0010\u0015\u001a\u0004\u0018\u00010\n*\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001a*\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u001d¢\u0006\u0004\b\u0004\u0010\u001e\u001a\u0019\u0010\u0013\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012*\u00020\u001d¢\u0006\u0004\b\u0013\u0010\u001f\u001a\u0013\u0010\u0015\u001a\u0004\u0018\u00010\n*\u00020\u001d¢\u0006\u0004\b\u0015\u0010 \u001a\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u001d¢\u0006\u0004\b\u0018\u0010!\u001a\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001a*\u00020\u001d¢\u0006\u0004\b\u001b\u0010\"\u001a\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u0017*\u00020\u001d¢\u0006\u0004\b$\u0010!\u001a\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u0017*\u00020\u0000¢\u0006\u0004\b%\u0010\u0019\u001a\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0017*\u00020\u001d¢\u0006\u0004\b'\u0010!\u001a\u0019\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\u0017*\u00020\nH\u0000¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lio/ktor/http/HttpMessageBuilder;", "Lio/ktor/http/ContentType;", "type", "", "contentType", "(Lio/ktor/http/HttpMessageBuilder;Lio/ktor/http/ContentType;)V", "", "seconds", "maxAge", "(Lio/ktor/http/HttpMessageBuilder;I)V", "", "value", "ifNoneMatch", "(Lio/ktor/http/HttpMessageBuilder;Ljava/lang/String;)V", q.KEY_RES_9_CONTENT, "userAgent", "(Lio/ktor/http/HttpMessageBuilder;)Lio/ktor/http/ContentType;", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "(Lio/ktor/http/HttpMessageBuilder;)Ljava/nio/charset/Charset;", "etag", "(Lio/ktor/http/HttpMessageBuilder;)Ljava/lang/String;", "", "vary", "(Lio/ktor/http/HttpMessageBuilder;)Ljava/util/List;", "", "contentLength", "(Lio/ktor/http/HttpMessageBuilder;)Ljava/lang/Long;", "Lio/ktor/http/HttpMessage;", "(Lio/ktor/http/HttpMessage;)Lio/ktor/http/ContentType;", "(Lio/ktor/http/HttpMessage;)Ljava/nio/charset/Charset;", "(Lio/ktor/http/HttpMessage;)Ljava/lang/String;", "(Lio/ktor/http/HttpMessage;)Ljava/util/List;", "(Lio/ktor/http/HttpMessage;)Ljava/lang/Long;", "Lio/ktor/http/Cookie;", "setCookie", "cookies", "Lio/ktor/http/HeaderValue;", "cacheControl", "splitSetCookieHeader", "(Ljava/lang/String;)Ljava/util/List;", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpMessagePropertiesKt {
    public static final void contentType(HttpMessageBuilder $this$contentType, ContentType type) {
        Intrinsics.checkNotNullParameter($this$contentType, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        $this$contentType.getHeaders().set(HttpHeaders.INSTANCE.getContentType(), type.toString());
    }

    public static final void maxAge(HttpMessageBuilder $this$maxAge, int seconds) {
        Intrinsics.checkNotNullParameter($this$maxAge, "<this>");
        $this$maxAge.getHeaders().append(HttpHeaders.INSTANCE.getCacheControl(), "max-age=" + seconds);
    }

    public static final void ifNoneMatch(HttpMessageBuilder $this$ifNoneMatch, String value) {
        Intrinsics.checkNotNullParameter($this$ifNoneMatch, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$ifNoneMatch.getHeaders().set(HttpHeaders.INSTANCE.getIfNoneMatch(), value);
    }

    public static final void userAgent(HttpMessageBuilder $this$userAgent, String content) {
        Intrinsics.checkNotNullParameter($this$userAgent, "<this>");
        Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
        $this$userAgent.getHeaders().set(HttpHeaders.INSTANCE.getUserAgent(), content);
    }

    public static final ContentType contentType(HttpMessageBuilder $this$contentType) {
        Intrinsics.checkNotNullParameter($this$contentType, "<this>");
        String it = $this$contentType.getHeaders().get(HttpHeaders.INSTANCE.getContentType());
        if (it != null) {
            return ContentType.Companion.parse(it);
        }
        return null;
    }

    public static final Charset charset(HttpMessageBuilder $this$charset) {
        Intrinsics.checkNotNullParameter($this$charset, "<this>");
        ContentType contentType = contentType($this$charset);
        if (contentType != null) {
            return ContentTypesKt.charset(contentType);
        }
        return null;
    }

    public static final String etag(HttpMessageBuilder $this$etag) {
        Intrinsics.checkNotNullParameter($this$etag, "<this>");
        return $this$etag.getHeaders().get(HttpHeaders.INSTANCE.getETag());
    }

    public static final List<String> vary(HttpMessageBuilder $this$vary) {
        Intrinsics.checkNotNullParameter($this$vary, "<this>");
        Iterable all = $this$vary.getHeaders().getAll(HttpHeaders.INSTANCE.getVary());
        if (all == null) {
            return null;
        }
        Iterable $this$flatMap$iv = all;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            String varyKeys = (String) element$iv$iv;
            Iterable $this$map$iv = StringsKt.split$default(varyKeys, new String[]{Constants.ACCEPT_TIME_SEPARATOR_SP}, false, 0, 6, (Object) null);
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv2.add(StringsKt.trim(it).toString());
                $this$flatMap$iv = $this$flatMap$iv;
            }
            Iterable $this$flatMap$iv2 = $this$flatMap$iv;
            Iterable list$iv$iv = (List) destination$iv$iv2;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            $this$flatMap$iv = $this$flatMap$iv2;
        }
        return (List) destination$iv$iv;
    }

    public static final Long contentLength(HttpMessageBuilder $this$contentLength) {
        Intrinsics.checkNotNullParameter($this$contentLength, "<this>");
        String str = $this$contentLength.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
        if (str != null) {
            return Long.valueOf(Long.parseLong(str));
        }
        return null;
    }

    public static final ContentType contentType(HttpMessage $this$contentType) {
        Intrinsics.checkNotNullParameter($this$contentType, "<this>");
        String it = $this$contentType.getHeaders().get(HttpHeaders.INSTANCE.getContentType());
        if (it != null) {
            return ContentType.Companion.parse(it);
        }
        return null;
    }

    public static final Charset charset(HttpMessage $this$charset) {
        Intrinsics.checkNotNullParameter($this$charset, "<this>");
        ContentType contentType = contentType($this$charset);
        if (contentType != null) {
            return ContentTypesKt.charset(contentType);
        }
        return null;
    }

    public static final String etag(HttpMessage $this$etag) {
        Intrinsics.checkNotNullParameter($this$etag, "<this>");
        return $this$etag.getHeaders().get(HttpHeaders.INSTANCE.getETag());
    }

    public static final List<String> vary(HttpMessage $this$vary) {
        Intrinsics.checkNotNullParameter($this$vary, "<this>");
        Iterable all = $this$vary.getHeaders().getAll(HttpHeaders.INSTANCE.getVary());
        if (all == null) {
            return null;
        }
        Iterable $this$flatMap$iv = all;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            String varyKeys = (String) element$iv$iv;
            Iterable $this$map$iv = StringsKt.split$default(varyKeys, new String[]{Constants.ACCEPT_TIME_SEPARATOR_SP}, false, 0, 6, (Object) null);
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv2.add(StringsKt.trim(it).toString());
                $this$flatMap$iv = $this$flatMap$iv;
            }
            Iterable $this$flatMap$iv2 = $this$flatMap$iv;
            Iterable list$iv$iv = (List) destination$iv$iv2;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            $this$flatMap$iv = $this$flatMap$iv2;
        }
        return (List) destination$iv$iv;
    }

    public static final Long contentLength(HttpMessage $this$contentLength) {
        Intrinsics.checkNotNullParameter($this$contentLength, "<this>");
        String str = $this$contentLength.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
        if (str != null) {
            return Long.valueOf(Long.parseLong(str));
        }
        return null;
    }

    public static final List<Cookie> setCookie(HttpMessage $this$setCookie) {
        Intrinsics.checkNotNullParameter($this$setCookie, "<this>");
        Iterable all = $this$setCookie.getHeaders().getAll(HttpHeaders.INSTANCE.getSetCookie());
        if (all != null) {
            Iterable $this$flatMap$iv = all;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$flatMap$iv) {
                String it = (String) element$iv$iv;
                Iterable list$iv$iv = splitSetCookieHeader(it);
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            Iterable $this$map$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it2 = (String) item$iv$iv;
                destination$iv$iv2.add(CookieKt.parseServerSetCookieHeader(it2));
            }
            return (List) destination$iv$iv2;
        }
        return CollectionsKt.emptyList();
    }

    public static final List<Cookie> cookies(HttpMessageBuilder $this$cookies) {
        Intrinsics.checkNotNullParameter($this$cookies, "<this>");
        Iterable all = $this$cookies.getHeaders().getAll(HttpHeaders.INSTANCE.getSetCookie());
        if (all != null) {
            Iterable $this$map$iv = all;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv.add(CookieKt.parseServerSetCookieHeader(it));
            }
            return (List) destination$iv$iv;
        }
        return CollectionsKt.emptyList();
    }

    public static final List<HeaderValue> cacheControl(HttpMessage $this$cacheControl) {
        List<HeaderValue> parseHeaderValue;
        Intrinsics.checkNotNullParameter($this$cacheControl, "<this>");
        String it = $this$cacheControl.getHeaders().get(HttpHeaders.INSTANCE.getCacheControl());
        return (it == null || (parseHeaderValue = HttpHeaderValueParserKt.parseHeaderValue(it)) == null) ? CollectionsKt.emptyList() : parseHeaderValue;
    }

    public static final List<String> splitSetCookieHeader(String $this$splitSetCookieHeader) {
        Intrinsics.checkNotNullParameter($this$splitSetCookieHeader, "<this>");
        int comma = StringsKt.indexOf$default($this$splitSetCookieHeader, ',', 0, false, 6, (Object) null);
        if (comma == -1) {
            return CollectionsKt.listOf($this$splitSetCookieHeader);
        }
        List result = new ArrayList();
        int current = 0;
        int equals = StringsKt.indexOf$default($this$splitSetCookieHeader, '=', comma, false, 4, (Object) null);
        int semicolon = StringsKt.indexOf$default($this$splitSetCookieHeader, ';', comma, false, 4, (Object) null);
        while (current < $this$splitSetCookieHeader.length() && comma > 0) {
            if (equals < comma) {
                equals = StringsKt.indexOf$default($this$splitSetCookieHeader, '=', comma, false, 4, (Object) null);
            }
            int nextComma = StringsKt.indexOf$default($this$splitSetCookieHeader, ',', comma + 1, false, 4, (Object) null);
            while (true) {
                boolean z = false;
                if (nextComma >= 0 && nextComma < equals) {
                    z = true;
                }
                if (!z) {
                    break;
                }
                comma = nextComma;
                nextComma = StringsKt.indexOf$default($this$splitSetCookieHeader, ',', nextComma + 1, false, 4, (Object) null);
            }
            if (semicolon < comma) {
                semicolon = StringsKt.indexOf$default($this$splitSetCookieHeader, ';', comma, false, 4, (Object) null);
            }
            if (equals < 0) {
                String substring = $this$splitSetCookieHeader.substring(current);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                result.add(substring);
                return result;
            }
            if (semicolon == -1 || semicolon > equals) {
                String substring2 = $this$splitSetCookieHeader.substring(current, comma);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                result.add(substring2);
                current = comma + 1;
            }
            comma = nextComma;
        }
        if (current < $this$splitSetCookieHeader.length()) {
            String substring3 = $this$splitSetCookieHeader.substring(current);
            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
            result.add(substring3);
        }
        return result;
    }
}