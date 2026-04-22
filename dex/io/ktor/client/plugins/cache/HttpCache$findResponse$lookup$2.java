package io.ktor.client.plugins.cache;

import io.ktor.http.HeadersBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCache.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class HttpCache$findResponse$lookup$2 extends FunctionReferenceImpl implements Function1<String, List<? extends String>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpCache$findResponse$lookup$2(Object obj) {
        super(1, obj, HeadersBuilder.class, "getAll", "getAll(Ljava/lang/String;)Ljava/util/List;", 0);
    }

    public final List<String> invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((HeadersBuilder) this.receiver).getAll(p0);
    }
}