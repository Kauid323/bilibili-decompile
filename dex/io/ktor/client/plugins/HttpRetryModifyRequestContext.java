package io.ktor.client.plugins;

import com.tencent.open.SocialConstants;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequestRetry.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/ktor/client/plugins/HttpRetryModifyRequestContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", SocialConstants.TYPE_REQUEST, "Lio/ktor/client/statement/HttpResponse;", "response", "", "cause", "", "retryCount", "<init>", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/statement/HttpResponse;Ljava/lang/Throwable;I)V", "Lio/ktor/client/request/HttpRequestBuilder;", "getRequest", "()Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/statement/HttpResponse;", "getResponse", "()Lio/ktor/client/statement/HttpResponse;", "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "I", "getRetryCount", "()I", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpRetryModifyRequestContext {
    private final Throwable cause;
    private final HttpRequestBuilder request;
    private final HttpResponse response;
    private final int retryCount;

    public HttpRetryModifyRequestContext(HttpRequestBuilder request, HttpResponse response, Throwable cause, int retryCount) {
        Intrinsics.checkNotNullParameter(request, SocialConstants.TYPE_REQUEST);
        this.request = request;
        this.response = response;
        this.cause = cause;
        this.retryCount = retryCount;
    }

    public final HttpRequestBuilder getRequest() {
        return this.request;
    }

    public final HttpResponse getResponse() {
        return this.response;
    }

    public final Throwable getCause() {
        return this.cause;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }
}