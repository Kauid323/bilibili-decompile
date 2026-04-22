package io.ktor.client.plugins;

import kotlin.Metadata;

/* compiled from: HttpRequestRetry.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/client/plugins/HttpRetryShouldRetryContext;", "", "", "retryCount", "<init>", "(I)V", "I", "getRetryCount", "()I", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpRetryShouldRetryContext {
    private final int retryCount;

    public HttpRetryShouldRetryContext(int retryCount) {
        this.retryCount = retryCount;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }
}