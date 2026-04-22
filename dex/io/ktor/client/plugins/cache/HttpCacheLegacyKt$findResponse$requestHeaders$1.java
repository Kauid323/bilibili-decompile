package io.ktor.client.plugins.cache;

import io.ktor.http.Headers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCacheLegacy.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class HttpCacheLegacyKt$findResponse$requestHeaders$1 extends FunctionReferenceImpl implements Function1<String, String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpCacheLegacyKt$findResponse$requestHeaders$1(Object obj) {
        super(1, obj, Headers.class, "get", "get(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    public final String invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((Headers) this.receiver).get(p0);
    }
}