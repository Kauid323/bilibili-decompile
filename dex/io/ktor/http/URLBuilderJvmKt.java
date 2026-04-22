package io.ktor.http;

import io.ktor.http.URLBuilder;
import io.ktor.http.Url;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: URLBuilderJvm.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lio/ktor/http/Url$Companion;", "", "fullUrl", "Lio/ktor/http/Url;", "invoke", "(Lio/ktor/http/Url$Companion;Ljava/lang/String;)Lio/ktor/http/Url;", "Lio/ktor/http/URLBuilder$Companion;", "getOrigin", "(Lio/ktor/http/URLBuilder$Companion;)Ljava/lang/String;", "origin", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class URLBuilderJvmKt {
    public static final Url invoke(Url.Companion $this$invoke, String fullUrl) {
        Intrinsics.checkNotNullParameter($this$invoke, "<this>");
        Intrinsics.checkNotNullParameter(fullUrl, "fullUrl");
        URLBuilder $this$invoke_u24lambda_u240 = new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null);
        URLUtilsJvmKt.takeFrom($this$invoke_u24lambda_u240, new URI(fullUrl));
        return $this$invoke_u24lambda_u240.build();
    }

    public static final String getOrigin(URLBuilder.Companion $this$origin) {
        Intrinsics.checkNotNullParameter($this$origin, "<this>");
        return "http://localhost";
    }
}