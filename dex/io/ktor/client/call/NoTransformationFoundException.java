package io.ktor.client.call;

import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* compiled from: HttpClientCall.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/call/NoTransformationFoundException;", "Ljava/lang/UnsupportedOperationException;", "Lkotlin/UnsupportedOperationException;", "Lio/ktor/client/statement/HttpResponse;", "response", "Lkotlin/reflect/KClass;", "from", "to", "<init>", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)V", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NoTransformationFoundException extends UnsupportedOperationException {
    private final String message;

    public NoTransformationFoundException(HttpResponse response, KClass<?> kClass, KClass<?> kClass2) {
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(kClass, "from");
        Intrinsics.checkNotNullParameter(kClass2, "to");
        this.message = StringsKt.trimIndent("\n        Expected response body of the type '" + kClass2 + "' but was '" + kClass + "'\n        In response from `" + HttpResponseKt.getRequest(response).getUrl() + "`\n        Response status `" + response.getStatus() + "`\n        Response header `ContentType: " + response.getHeaders().get(HttpHeaders.INSTANCE.getContentType()) + "` \n        Request header `Accept: " + HttpResponseKt.getRequest(response).getHeaders().get(HttpHeaders.INSTANCE.getAccept()) + "`\n        \n        You can read how to resolve NoTransformationFoundException at FAQ: \n        https://ktor.io/docs/faq.html#no-transformation-found-exception\n    ");
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}