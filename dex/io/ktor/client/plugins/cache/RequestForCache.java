package io.ktor.client.plugins.cache;

import faceverify.q;
import im.setting.UtilsKt;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCache.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00198\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lio/ktor/client/plugins/cache/RequestForCache;", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/request/HttpRequestData;", UtilsKt.DATA_KEY, "<init>", "(Lio/ktor/client/request/HttpRequestData;)V", "Lio/ktor/client/call/HttpClientCall;", "getCall", "()Lio/ktor/client/call/HttpClientCall;", "call", "Lio/ktor/http/HttpMethod;", "method", "Lio/ktor/http/HttpMethod;", "getMethod", "()Lio/ktor/http/HttpMethod;", "Lio/ktor/http/Url;", "url", "Lio/ktor/http/Url;", "getUrl", "()Lio/ktor/http/Url;", "Lio/ktor/util/Attributes;", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "Lio/ktor/http/content/OutgoingContent;", q.KEY_RES_9_CONTENT, "Lio/ktor/http/content/OutgoingContent;", "getContent", "()Lio/ktor/http/content/OutgoingContent;", "Lio/ktor/http/Headers;", "headers", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RequestForCache implements HttpRequest {
    private final Attributes attributes;
    private final OutgoingContent content;
    private final Headers headers;
    private final HttpMethod method;
    private final Url url;

    public RequestForCache(HttpRequestData data) {
        Intrinsics.checkNotNullParameter(data, UtilsKt.DATA_KEY);
        this.method = data.getMethod();
        this.url = data.getUrl();
        this.attributes = data.getAttributes();
        this.content = data.getBody();
        this.headers = data.getHeaders();
    }

    @Override // io.ktor.client.request.HttpRequest
    public CoroutineContext getCoroutineContext() {
        return HttpRequest.DefaultImpls.getCoroutineContext(this);
    }

    @Override // io.ktor.client.request.HttpRequest
    public HttpClientCall getCall() {
        throw new IllegalStateException("This request has no call");
    }

    @Override // io.ktor.client.request.HttpRequest
    public HttpMethod getMethod() {
        return this.method;
    }

    @Override // io.ktor.client.request.HttpRequest
    public Url getUrl() {
        return this.url;
    }

    @Override // io.ktor.client.request.HttpRequest
    public Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.ktor.client.request.HttpRequest
    public OutgoingContent getContent() {
        return this.content;
    }

    @Override // io.ktor.http.HttpMessage
    public Headers getHeaders() {
        return this.headers;
    }
}