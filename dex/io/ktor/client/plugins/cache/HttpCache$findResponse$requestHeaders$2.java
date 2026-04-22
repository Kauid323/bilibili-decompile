package io.ktor.client.plugins.cache;

import io.ktor.http.Headers;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCache.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class HttpCache$findResponse$requestHeaders$2 extends FunctionReferenceImpl implements Function1<String, List<? extends String>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpCache$findResponse$requestHeaders$2(Object obj) {
        super(1, obj, Headers.class, "getAll", "getAll(Ljava/lang/String;)Ljava/util/List;", 0);
    }

    public final List<String> invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((Headers) this.receiver).getAll(p0);
    }
}