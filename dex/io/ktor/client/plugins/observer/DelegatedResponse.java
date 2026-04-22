package io.ktor.client.plugins.observer;

import com.xiaomi.mipush.sdk.Constants;
import faceverify.q;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegatedCall.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u00198\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(¨\u0006,"}, d2 = {"Lio/ktor/client/plugins/observer/DelegatedResponse;", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/call/HttpClientCall;", "call", "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", "block", "origin", "Lio/ktor/http/Headers;", "headers", "<init>", "(Lio/ktor/client/call/HttpClientCall;Lkotlin/jvm/functions/Function0;Lio/ktor/client/statement/HttpResponse;Lio/ktor/http/Headers;)V", q.KEY_RES_9_CONTENT, "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/client/statement/HttpResponse;Lio/ktor/http/Headers;)V", "Lio/ktor/client/call/HttpClientCall;", "getCall", "()Lio/ktor/client/call/HttpClientCall;", "Lkotlin/jvm/functions/Function0;", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "getRawContent", "()Lio/ktor/utils/io/ByteReadChannel;", "rawContent", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "status", "Lio/ktor/http/HttpProtocolVersion;", "getVersion", "()Lio/ktor/http/HttpProtocolVersion;", Constants.VERSION, "Lio/ktor/util/date/GMTDate;", "getRequestTime", "()Lio/ktor/util/date/GMTDate;", "requestTime", "getResponseTime", "responseTime", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DelegatedResponse extends HttpResponse {
    private final Function0<ByteReadChannel> block;
    private final HttpClientCall call;
    private final CoroutineContext coroutineContext;
    private final Headers headers;
    private final HttpResponse origin;

    public /* synthetic */ DelegatedResponse(HttpClientCall httpClientCall, Function0 function0, HttpResponse httpResponse, Headers headers, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpClientCall, function0, httpResponse, (i2 & 8) != 0 ? httpResponse.getHeaders() : headers);
    }

    @Override // io.ktor.client.statement.HttpResponse
    public HttpClientCall getCall() {
        return this.call;
    }

    @Override // io.ktor.http.HttpMessage
    public Headers getHeaders() {
        return this.headers;
    }

    public DelegatedResponse(HttpClientCall call, Function0<? extends ByteReadChannel> function0, HttpResponse origin, Headers headers) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(function0, "block");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.call = call;
        this.block = function0;
        this.origin = origin;
        this.headers = headers;
        this.coroutineContext = this.origin.getCoroutineContext();
    }

    public /* synthetic */ DelegatedResponse(HttpClientCall httpClientCall, ByteReadChannel byteReadChannel, HttpResponse httpResponse, Headers headers, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpClientCall, byteReadChannel, httpResponse, (i2 & 8) != 0 ? httpResponse.getHeaders() : headers);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DelegatedResponse(HttpClientCall call, final ByteReadChannel content, HttpResponse origin, Headers headers) {
        this(call, new Function0() { // from class: io.ktor.client.plugins.observer.DelegatedResponse$$ExternalSyntheticLambda0
            public final Object invoke() {
                ByteReadChannel _init_$lambda$0;
                _init_$lambda$0 = DelegatedResponse._init_$lambda$0(content);
                return _init_$lambda$0;
            }
        }, origin, headers);
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(headers, "headers");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel _init_$lambda$0(ByteReadChannel $content) {
        return $content;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public ByteReadChannel getRawContent() {
        return (ByteReadChannel) this.block.invoke();
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public HttpStatusCode getStatus() {
        return this.origin.getStatus();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public HttpProtocolVersion getVersion() {
        return this.origin.getVersion();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public GMTDate getRequestTime() {
        return this.origin.getRequestTime();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public GMTDate getResponseTime() {
        return this.origin.getResponseTime();
    }
}