package io.ktor.client.request;

import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* compiled from: HttpRequest.kt */
@InternalAPI
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bç\u0080\u0001\u0018\u00002\u00020\u0001JA\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/client/request/ResponseAdapter;", "", "Lio/ktor/client/request/HttpRequestData;", im.setting.UtilsKt.DATA_KEY, "Lio/ktor/http/HttpStatusCode;", "status", "Lio/ktor/http/Headers;", "headers", "Lio/ktor/utils/io/ByteReadChannel;", "responseBody", "Lio/ktor/http/content/OutgoingContent;", "outgoingContent", "Lkotlin/coroutines/CoroutineContext;", "callContext", "adapt", "(Lio/ktor/client/request/HttpRequestData;Lio/ktor/http/HttpStatusCode;Lio/ktor/http/Headers;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/http/content/OutgoingContent;Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ResponseAdapter {
    Object adapt(HttpRequestData httpRequestData, HttpStatusCode httpStatusCode, Headers headers, ByteReadChannel byteReadChannel, OutgoingContent outgoingContent, CoroutineContext coroutineContext);
}