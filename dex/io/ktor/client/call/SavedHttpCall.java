package io.ktor.client.call;

import com.tencent.open.SocialConstants;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedCall.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u0094@¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0014X\u0094D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/client/call/SavedHttpCall;", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/HttpClient;", "client", "Lio/ktor/client/request/HttpRequest;", SocialConstants.TYPE_REQUEST, "Lio/ktor/client/statement/HttpResponse;", "response", "", "responseBody", "<init>", "(Lio/ktor/client/HttpClient;Lio/ktor/client/request/HttpRequest;Lio/ktor/client/statement/HttpResponse;[B)V", "Lio/ktor/utils/io/ByteReadChannel;", "getResponseContent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "[B", "", "allowDoubleReceive", "Z", "getAllowDoubleReceive", "()Z", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedHttpCall extends HttpClientCall {
    private final boolean allowDoubleReceive;
    private final byte[] responseBody;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SavedHttpCall(HttpClient client, HttpRequest request, HttpResponse response, byte[] responseBody) {
        super(client);
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(request, SocialConstants.TYPE_REQUEST);
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        this.responseBody = responseBody;
        setRequest(new SavedHttpRequest(this, request));
        setResponse(new SavedHttpResponse(this, this.responseBody, response));
        UtilsKt.checkContentLength(HttpMessagePropertiesKt.contentLength(response), this.responseBody.length, request.getMethod());
        this.allowDoubleReceive = true;
    }

    @Override // io.ktor.client.call.HttpClientCall
    protected Object getResponseContent(Continuation<? super ByteReadChannel> continuation) {
        return ByteChannelCtorKt.ByteReadChannel$default(this.responseBody, 0, 0, 6, (Object) null);
    }

    @Override // io.ktor.client.call.HttpClientCall
    protected boolean getAllowDoubleReceive() {
        return this.allowDoubleReceive;
    }
}