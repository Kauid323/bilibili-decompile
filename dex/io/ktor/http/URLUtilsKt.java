package io.ktor.http;

import io.ktor.util.StringValuesKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: URLUtils.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007\u001a&\u0010\f\u001a\u00020\u00022\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u0004\u001a\u0015\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0015\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0012\u001a\u0015\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0013\u001a\u0019\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0019\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0016\u001a/\u0010\u001d\u001a\u00020\t*\u00060\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bH\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a-\u0010\u001d\u001a\u00020\t*\u00060\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010!\u001a+\u0010&\u001a\u00020\t*\u00060\"j\u0002`#2\b\u0010$\u001a\u0004\u0018\u00010\u00002\b\u0010%\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b&\u0010'\"\u0015\u0010*\u001a\u00020\u0000*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b(\u0010)\"\u0015\u0010,\u001a\u00020\u0000*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b+\u0010)\"\u0015\u0010.\u001a\u00020\u0000*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b-\u0010)\"\u0015\u0010/\u001a\u00020\u001b*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b/\u00100\"\u0015\u00101\u001a\u00020\u001b*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b1\u00100\"\u0015\u0010/\u001a\u00020\u001b*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b/\u00102\"\u0015\u00101\u001a\u00020\u001b*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00063"}, d2 = {"", "urlString", "Lio/ktor/http/Url;", "Url", "(Ljava/lang/String;)Lio/ktor/http/Url;", "Lio/ktor/http/URLBuilder;", "builder", "(Lio/ktor/http/URLBuilder;)Lio/ktor/http/Url;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "buildUrl", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/http/Url;", "parseUrl", "URLBuilder", "(Ljava/lang/String;)Lio/ktor/http/URLBuilder;", "url", "(Lio/ktor/http/Url;)Lio/ktor/http/URLBuilder;", "(Lio/ktor/http/URLBuilder;)Lio/ktor/http/URLBuilder;", "takeFrom", "(Lio/ktor/http/URLBuilder;Lio/ktor/http/URLBuilder;)Lio/ktor/http/URLBuilder;", "(Lio/ktor/http/URLBuilder;Lio/ktor/http/Url;)Lio/ktor/http/URLBuilder;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "encodedPath", "encodedQuery", "", "trailingQuery", "appendUrlFullPath", "(Ljava/lang/Appendable;Ljava/lang/String;Ljava/lang/String;Z)V", "Lio/ktor/http/ParametersBuilder;", "encodedQueryParameters", "(Ljava/lang/Appendable;Ljava/lang/String;Lio/ktor/http/ParametersBuilder;Z)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "encodedUser", "encodedPassword", "appendUserAndPassword", "(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V", "getFullPath", "(Lio/ktor/http/Url;)Ljava/lang/String;", "fullPath", "getHostWithPort", "hostWithPort", "getHostWithPortIfSpecified", "hostWithPortIfSpecified", "isAbsolutePath", "(Lio/ktor/http/Url;)Z", "isRelativePath", "(Lio/ktor/http/URLBuilder;)Z", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class URLUtilsKt {
    public static final Url Url(String urlString) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        return URLBuilder(urlString).build();
    }

    public static final Url Url(URLBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), builder).build();
    }

    public static final Url buildUrl(Function1<? super URLBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        URLBuilder uRLBuilder = new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null);
        function1.invoke(uRLBuilder);
        return uRLBuilder.build();
    }

    public static final Url parseUrl(String urlString) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        try {
            URLBuilder it = URLBuilder(urlString);
            if (!(it.getHost().length() > 0)) {
                it = null;
            }
            if (it != null) {
                return it.build();
            }
            return null;
        } catch (URLParserException e2) {
            return null;
        }
    }

    public static final URLBuilder URLBuilder(String urlString) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        return URLParserKt.takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), urlString);
    }

    public static final URLBuilder URLBuilder(Url url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), url);
    }

    public static final URLBuilder URLBuilder(URLBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), builder);
    }

    public static final URLBuilder takeFrom(URLBuilder $this$takeFrom, URLBuilder url) {
        Intrinsics.checkNotNullParameter($this$takeFrom, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        $this$takeFrom.setProtocolOrNull(url.getProtocolOrNull());
        $this$takeFrom.setHost(url.getHost());
        $this$takeFrom.setPort(url.getPort());
        $this$takeFrom.setEncodedPathSegments(url.getEncodedPathSegments());
        $this$takeFrom.setEncodedUser(url.getEncodedUser());
        $this$takeFrom.setEncodedPassword(url.getEncodedPassword());
        ParametersBuilder $this$takeFrom_u24lambda_u241 = ParametersKt.ParametersBuilder$default(0, 1, null);
        StringValuesKt.appendAll($this$takeFrom_u24lambda_u241, url.getEncodedParameters());
        $this$takeFrom.setEncodedParameters($this$takeFrom_u24lambda_u241);
        $this$takeFrom.setEncodedFragment(url.getEncodedFragment());
        $this$takeFrom.setTrailingQuery(url.getTrailingQuery());
        return $this$takeFrom;
    }

    public static final URLBuilder takeFrom(URLBuilder $this$takeFrom, Url url) {
        Intrinsics.checkNotNullParameter($this$takeFrom, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        $this$takeFrom.setProtocolOrNull(url.getProtocolOrNull());
        $this$takeFrom.setHost(url.getHost());
        $this$takeFrom.setPort(url.getPort());
        URLBuilderKt.setEncodedPath($this$takeFrom, url.getEncodedPath());
        $this$takeFrom.setEncodedUser(url.getEncodedUser());
        $this$takeFrom.setEncodedPassword(url.getEncodedPassword());
        ParametersBuilder $this$takeFrom_u24lambda_u242 = ParametersKt.ParametersBuilder$default(0, 1, null);
        $this$takeFrom_u24lambda_u242.appendAll(QueryKt.parseQueryString$default(url.getEncodedQuery(), 0, 0, false, 6, null));
        $this$takeFrom.setEncodedParameters($this$takeFrom_u24lambda_u242);
        $this$takeFrom.setEncodedFragment(url.getEncodedFragment());
        $this$takeFrom.setTrailingQuery(url.getTrailingQuery());
        return $this$takeFrom;
    }

    public static final String getFullPath(Url $this$fullPath) {
        Intrinsics.checkNotNullParameter($this$fullPath, "<this>");
        StringBuilder $this$_get_fullPath__u24lambda_u243 = new StringBuilder();
        appendUrlFullPath($this$_get_fullPath__u24lambda_u243, $this$fullPath.getEncodedPath(), $this$fullPath.getEncodedQuery(), $this$fullPath.getTrailingQuery());
        String sb = $this$_get_fullPath__u24lambda_u243.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static final String getHostWithPort(Url $this$hostWithPort) {
        Intrinsics.checkNotNullParameter($this$hostWithPort, "<this>");
        return $this$hostWithPort.getHost() + ':' + $this$hostWithPort.getPort();
    }

    public static final String getHostWithPortIfSpecified(Url $this$hostWithPortIfSpecified) {
        Intrinsics.checkNotNullParameter($this$hostWithPortIfSpecified, "<this>");
        int specifiedPort = $this$hostWithPortIfSpecified.getSpecifiedPort();
        if (specifiedPort == 0 || specifiedPort == $this$hostWithPortIfSpecified.getProtocol().getDefaultPort()) {
            return $this$hostWithPortIfSpecified.getHost();
        }
        return getHostWithPort($this$hostWithPortIfSpecified);
    }

    public static final void appendUrlFullPath(Appendable $this$appendUrlFullPath, String encodedPath, String encodedQuery, boolean trailingQuery) {
        Intrinsics.checkNotNullParameter($this$appendUrlFullPath, "<this>");
        Intrinsics.checkNotNullParameter(encodedPath, "encodedPath");
        Intrinsics.checkNotNullParameter(encodedQuery, "encodedQuery");
        if (!StringsKt.isBlank(encodedPath) && !StringsKt.startsWith$default(encodedPath, "/", false, 2, (Object) null)) {
            $this$appendUrlFullPath.append('/');
        }
        $this$appendUrlFullPath.append(encodedPath);
        if ((encodedQuery.length() > 0) || trailingQuery) {
            $this$appendUrlFullPath.append("?");
        }
        $this$appendUrlFullPath.append(encodedQuery);
    }

    public static final void appendUrlFullPath(Appendable $this$appendUrlFullPath, String encodedPath, ParametersBuilder encodedQueryParameters, boolean trailingQuery) {
        Iterable $this$flatMap$iv;
        Iterable $this$map$iv;
        Intrinsics.checkNotNullParameter($this$appendUrlFullPath, "<this>");
        Intrinsics.checkNotNullParameter(encodedPath, "encodedPath");
        Intrinsics.checkNotNullParameter(encodedQueryParameters, "encodedQueryParameters");
        Object obj = null;
        if (!StringsKt.isBlank(encodedPath) && !StringsKt.startsWith$default(encodedPath, "/", false, 2, (Object) null)) {
            $this$appendUrlFullPath.append('/');
        }
        $this$appendUrlFullPath.append(encodedPath);
        if (!encodedQueryParameters.isEmpty() || trailingQuery) {
            $this$appendUrlFullPath.append("?");
        }
        Iterable list$iv$iv = encodedQueryParameters.entries();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : list$iv$iv) {
            Map.Entry entry = (Map.Entry) element$iv$iv;
            String key = (String) entry.getKey();
            List value = (List) entry.getValue();
            if (value.isEmpty()) {
                $this$map$iv = CollectionsKt.listOf(TuplesKt.to(key, obj));
                $this$flatMap$iv = list$iv$iv;
            } else {
                List list = value;
                $this$flatMap$iv = list$iv$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterable $this$mapTo$iv$iv = list;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                    String it = (String) item$iv$iv;
                    destination$iv$iv2.add(TuplesKt.to(key, it));
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                }
                $this$map$iv = (List) destination$iv$iv2;
            }
            CollectionsKt.addAll(destination$iv$iv, $this$map$iv);
            list$iv$iv = $this$flatMap$iv;
            obj = null;
        }
        CollectionsKt.joinTo$default((List) destination$iv$iv, $this$appendUrlFullPath, "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2) {
                CharSequence appendUrlFullPath$lambda$6;
                appendUrlFullPath$lambda$6 = URLUtilsKt.appendUrlFullPath$lambda$6((Pair) obj2);
                return appendUrlFullPath$lambda$6;
            }
        }, 60, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence appendUrlFullPath$lambda$6(Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String key = (String) it.getFirst();
        if (it.getSecond() == null) {
            return key;
        }
        String value = String.valueOf(it.getSecond());
        return key + '=' + value;
    }

    public static final boolean isAbsolutePath(Url $this$isAbsolutePath) {
        Intrinsics.checkNotNullParameter($this$isAbsolutePath, "<this>");
        return Intrinsics.areEqual(CollectionsKt.firstOrNull($this$isAbsolutePath.getPathSegments()), "");
    }

    public static final boolean isRelativePath(Url $this$isRelativePath) {
        Intrinsics.checkNotNullParameter($this$isRelativePath, "<this>");
        return !isAbsolutePath($this$isRelativePath);
    }

    public static final boolean isAbsolutePath(URLBuilder $this$isAbsolutePath) {
        Intrinsics.checkNotNullParameter($this$isAbsolutePath, "<this>");
        return Intrinsics.areEqual(CollectionsKt.firstOrNull($this$isAbsolutePath.getPathSegments()), "");
    }

    public static final boolean isRelativePath(URLBuilder $this$isRelativePath) {
        Intrinsics.checkNotNullParameter($this$isRelativePath, "<this>");
        return !isAbsolutePath($this$isRelativePath);
    }

    public static final void appendUserAndPassword(StringBuilder $this$appendUserAndPassword, String encodedUser, String encodedPassword) {
        Intrinsics.checkNotNullParameter($this$appendUserAndPassword, "<this>");
        if (encodedUser == null) {
            return;
        }
        $this$appendUserAndPassword.append(encodedUser);
        if (encodedPassword != null) {
            $this$appendUserAndPassword.append(':');
            $this$appendUserAndPassword.append(encodedPassword);
        }
        $this$appendUserAndPassword.append("@");
    }
}