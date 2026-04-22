package io.ktor.client.request;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLUtilsJvmKt;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequestJvm.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0002\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0004\u001a\u001c\u0010\u0006\u001a\u00020\u0000*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "Ljava/net/URL;", "url", "Lio/ktor/http/URLBuilder;", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/net/URL;)Lio/ktor/http/URLBuilder;", "Lio/ktor/client/request/HttpRequestBuilder$Companion;", "invoke", "(Lio/ktor/client/request/HttpRequestBuilder$Companion;Ljava/net/URL;)Lio/ktor/client/request/HttpRequestBuilder;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpRequestJvmKt {
    public static final URLBuilder url(HttpRequestBuilder $this$url, URL url) {
        Intrinsics.checkNotNullParameter($this$url, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        return URLUtilsJvmKt.takeFrom($this$url.getUrl(), url);
    }

    public static final HttpRequestBuilder invoke(HttpRequestBuilder.Companion $this$invoke, URL url) {
        Intrinsics.checkNotNullParameter($this$invoke, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        HttpRequestBuilder $this$invoke_u24lambda_u240 = new HttpRequestBuilder();
        url($this$invoke_u24lambda_u240, url);
        return $this$invoke_u24lambda_u240;
    }
}