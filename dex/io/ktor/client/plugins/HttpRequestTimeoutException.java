package io.ktor.client.plugins;

import com.tencent.open.SocialConstants;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

/* compiled from: HttpTimeout.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B%\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/client/plugins/HttpRequestTimeoutException;", "Ljava/io/IOException;", "Lkotlinx/io/IOException;", "Lkotlinx/coroutines/CopyableThrowable;", "", "url", "", "timeoutMillis", "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Throwable;)V", "Lio/ktor/client/request/HttpRequestBuilder;", SocialConstants.TYPE_REQUEST, "(Lio/ktor/client/request/HttpRequestBuilder;)V", "Lio/ktor/client/request/HttpRequestData;", "(Lio/ktor/client/request/HttpRequestData;)V", "createCopy", "()Lio/ktor/client/plugins/HttpRequestTimeoutException;", "Ljava/lang/String;", "Ljava/lang/Long;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpRequestTimeoutException extends IOException implements CopyableThrowable<HttpRequestTimeoutException> {
    private final Long timeoutMillis;
    private final String url;

    public /* synthetic */ HttpRequestTimeoutException(String str, Long l, Throwable th, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, l, (i2 & 4) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestTimeoutException(String url, Long timeoutMillis, Throwable cause) {
        super("Request timeout has expired [url=" + url + ", request_timeout=" + (timeoutMillis == null ? "unknown" : timeoutMillis) + " ms]", cause);
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.timeoutMillis = timeoutMillis;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HttpRequestTimeoutException(HttpRequestBuilder request) {
        this(r2, r0 != null ? r0.getRequestTimeoutMillis() : null, null, 4, null);
        Intrinsics.checkNotNullParameter(request, SocialConstants.TYPE_REQUEST);
        String buildString = request.getUrl().buildString();
        HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) request.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HttpRequestTimeoutException(HttpRequestData request) {
        this(r2, r0 != null ? r0.getRequestTimeoutMillis() : null, null, 4, null);
        Intrinsics.checkNotNullParameter(request, SocialConstants.TYPE_REQUEST);
        String url = request.getUrl().toString();
        HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) request.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE);
    }

    /* renamed from: createCopy */
    public HttpRequestTimeoutException m3452createCopy() {
        return new HttpRequestTimeoutException(this.url, this.timeoutMillis, getCause());
    }
}