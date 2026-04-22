package io.ktor.http;

import io.grpc.internal.GrpcUtil;
import java.net.URI;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: URLUtilsJvm.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\u0001*\u00020\b¢\u0006\u0004\b\t\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/http/URLBuilder;", "Ljava/net/URI;", "uri", "takeFrom", "(Lio/ktor/http/URLBuilder;Ljava/net/URI;)Lio/ktor/http/URLBuilder;", "Ljava/net/URL;", "url", "(Lio/ktor/http/URLBuilder;Ljava/net/URL;)Lio/ktor/http/URLBuilder;", "Lio/ktor/http/Url;", "toURI", "(Lio/ktor/http/Url;)Ljava/net/URI;", "Url", "(Ljava/net/URI;)Lio/ktor/http/Url;", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class URLUtilsJvmKt {
    public static final URLBuilder takeFrom(URLBuilder $this$takeFrom, URI uri) {
        Intrinsics.checkNotNullParameter($this$takeFrom, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String it = uri.getScheme();
        if (it != null) {
            $this$takeFrom.setProtocol(URLProtocol.Companion.createOrDefault(it));
            $this$takeFrom.setPort($this$takeFrom.getProtocol().getDefaultPort());
        }
        if (uri.getPort() > 0) {
            $this$takeFrom.setPort(uri.getPort());
        } else {
            String scheme = uri.getScheme();
            if (Intrinsics.areEqual(scheme, "http")) {
                $this$takeFrom.setPort(80);
            } else if (Intrinsics.areEqual(scheme, "https")) {
                $this$takeFrom.setPort(GrpcUtil.DEFAULT_PORT_SSL);
            }
        }
        boolean z = false;
        if (uri.getRawUserInfo() != null) {
            String rawUserInfo = uri.getRawUserInfo();
            Intrinsics.checkNotNullExpressionValue(rawUserInfo, "getRawUserInfo(...)");
            if (rawUserInfo.length() > 0) {
                String rawUserInfo2 = uri.getRawUserInfo();
                Intrinsics.checkNotNullExpressionValue(rawUserInfo2, "getRawUserInfo(...)");
                List parts = StringsKt.split$default(rawUserInfo2, new String[]{":"}, false, 0, 6, (Object) null);
                $this$takeFrom.setEncodedUser((String) CollectionsKt.first(parts));
                $this$takeFrom.setEncodedPassword((String) CollectionsKt.getOrNull(parts, 1));
            }
        }
        String it2 = uri.getHost();
        if (it2 != null) {
            $this$takeFrom.setHost(it2);
        }
        URLBuilderKt.setEncodedPath($this$takeFrom, uri.getRawPath());
        String it3 = uri.getRawQuery();
        if (it3 != null) {
            ParametersBuilder $this$takeFrom_u24lambda_u243_u24lambda_u242 = ParametersKt.ParametersBuilder$default(0, 1, null);
            $this$takeFrom_u24lambda_u243_u24lambda_u242.appendAll(QueryKt.parseQueryString$default(it3, 0, 0, false, 6, null));
            $this$takeFrom.setEncodedParameters($this$takeFrom_u24lambda_u243_u24lambda_u242);
        }
        String query = uri.getQuery();
        if (query != null) {
            if (query.length() == 0) {
                z = true;
            }
        }
        if (z) {
            $this$takeFrom.setTrailingQuery(true);
        }
        String it4 = uri.getRawFragment();
        if (it4 != null) {
            $this$takeFrom.setEncodedFragment(it4);
        }
        return $this$takeFrom;
    }

    public static final URLBuilder takeFrom(URLBuilder $this$takeFrom, URL url) {
        Intrinsics.checkNotNullParameter($this$takeFrom, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        String host2 = url.getHost();
        Intrinsics.checkNotNullExpressionValue(host2, "getHost(...)");
        if (StringsKt.contains$default(host2, '_', false, 2, (Object) null)) {
            String url2 = url.toString();
            Intrinsics.checkNotNullExpressionValue(url2, "toString(...)");
            return URLParserKt.takeFrom($this$takeFrom, url2);
        }
        URI uri = url.toURI();
        Intrinsics.checkNotNullExpressionValue(uri, "toURI(...)");
        return takeFrom($this$takeFrom, uri);
    }

    public static final URI toURI(Url $this$toURI) {
        Intrinsics.checkNotNullParameter($this$toURI, "<this>");
        return new URI($this$toURI.toString());
    }

    public static final Url Url(URI uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), uri).build();
    }
}