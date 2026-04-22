package io.ktor.client.call;

import com.xiaomi.mipush.sdk.Constants;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedCall.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010-\u001a\u00020(8VX\u0096\u0004¢\u0006\f\u0012\u0004\b+\u0010,\u001a\u0004\b)\u0010*¨\u0006."}, d2 = {"Lio/ktor/client/call/SavedHttpResponse;", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/call/SavedHttpCall;", "call", "", "body", "origin", "<init>", "(Lio/ktor/client/call/SavedHttpCall;[BLio/ktor/client/statement/HttpResponse;)V", "Lio/ktor/client/call/SavedHttpCall;", "getCall", "()Lio/ktor/client/call/SavedHttpCall;", "[B", "Lio/ktor/http/HttpStatusCode;", "status", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "Lio/ktor/http/HttpProtocolVersion;", Constants.VERSION, "Lio/ktor/http/HttpProtocolVersion;", "getVersion", "()Lio/ktor/http/HttpProtocolVersion;", "Lio/ktor/util/date/GMTDate;", "requestTime", "Lio/ktor/util/date/GMTDate;", "getRequestTime", "()Lio/ktor/util/date/GMTDate;", "responseTime", "getResponseTime", "Lio/ktor/http/Headers;", "headers", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lio/ktor/utils/io/ByteReadChannel;", "getRawContent", "()Lio/ktor/utils/io/ByteReadChannel;", "getRawContent$annotations", "()V", "rawContent", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedHttpResponse extends HttpResponse {
    private final byte[] body;
    private final SavedHttpCall call;
    private final CoroutineContext coroutineContext;
    private final Headers headers;
    private final GMTDate requestTime;
    private final GMTDate responseTime;
    private final HttpStatusCode status;
    private final HttpProtocolVersion version;

    public static /* synthetic */ void getRawContent$annotations() {
    }

    @Override // io.ktor.client.statement.HttpResponse
    public SavedHttpCall getCall() {
        return this.call;
    }

    public SavedHttpResponse(SavedHttpCall call, byte[] body, HttpResponse origin) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.call = call;
        this.body = body;
        this.status = origin.getStatus();
        this.version = origin.getVersion();
        this.requestTime = origin.getRequestTime();
        this.responseTime = origin.getResponseTime();
        this.headers = origin.getHeaders();
        this.coroutineContext = origin.getCoroutineContext();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public HttpStatusCode getStatus() {
        return this.status;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public HttpProtocolVersion getVersion() {
        return this.version;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public GMTDate getRequestTime() {
        return this.requestTime;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public GMTDate getResponseTime() {
        return this.responseTime;
    }

    @Override // io.ktor.http.HttpMessage
    public Headers getHeaders() {
        return this.headers;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public ByteReadChannel getRawContent() {
        return ByteChannelCtorKt.ByteReadChannel$default(this.body, 0, 0, 6, (Object) null);
    }
}