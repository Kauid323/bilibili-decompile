package io.ktor.client.request;

import io.ktor.client.plugins.sse.DefaultClientSSESession;
import io.ktor.client.plugins.sse.SSEClientContent;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequest.kt */
@InternalAPI
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/client/request/SSEClientResponseAdapter;", "Lio/ktor/client/request/ResponseAdapter;", "<init>", "()V", "Lio/ktor/client/request/HttpRequestData;", im.setting.UtilsKt.DATA_KEY, "Lio/ktor/http/HttpStatusCode;", "status", "Lio/ktor/http/Headers;", "headers", "Lio/ktor/utils/io/ByteReadChannel;", "responseBody", "Lio/ktor/http/content/OutgoingContent;", "outgoingContent", "Lkotlin/coroutines/CoroutineContext;", "callContext", "", "adapt", "(Lio/ktor/client/request/HttpRequestData;Lio/ktor/http/HttpStatusCode;Lio/ktor/http/Headers;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/http/content/OutgoingContent;Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SSEClientResponseAdapter implements ResponseAdapter {
    @Override // io.ktor.client.request.ResponseAdapter
    public Object adapt(HttpRequestData data, HttpStatusCode status, Headers headers, ByteReadChannel responseBody, OutgoingContent outgoingContent, CoroutineContext callContext) {
        Intrinsics.checkNotNullParameter(data, im.setting.UtilsKt.DATA_KEY);
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        Intrinsics.checkNotNullParameter(outgoingContent, "outgoingContent");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        String it = headers.get(HttpHeaders.INSTANCE.getContentType());
        ContentType contentType = it != null ? ContentType.Companion.parse(it) : null;
        if (HttpRequestKt.isSseRequest(data) && Intrinsics.areEqual(status, HttpStatusCode.Companion.getOK())) {
            if (Intrinsics.areEqual(contentType != null ? contentType.withoutParameters() : null, ContentType.Text.INSTANCE.getEventStream())) {
                return new DefaultClientSSESession((SSEClientContent) outgoingContent, responseBody, callContext);
            }
            return null;
        }
        return null;
    }
}