package io.ktor.client.request;

import faceverify.q;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import io.ktor.utils.io.InternalAPI;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: HttpRequest.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\"\n\u0002\b\u0005\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010)R$\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110*8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lio/ktor/client/request/HttpRequestData;", "", "Lio/ktor/http/Url;", "url", "Lio/ktor/http/HttpMethod;", "method", "Lio/ktor/http/Headers;", "headers", "Lio/ktor/http/content/OutgoingContent;", "body", "Lkotlinx/coroutines/Job;", "executionContext", "Lio/ktor/util/Attributes;", "attributes", "<init>", "(Lio/ktor/http/Url;Lio/ktor/http/HttpMethod;Lio/ktor/http/Headers;Lio/ktor/http/content/OutgoingContent;Lkotlinx/coroutines/Job;Lio/ktor/util/Attributes;)V", "T", "Lio/ktor/client/engine/HttpClientEngineCapability;", q.KEY_RES_9_KEY, "getCapabilityOrNull", "(Lio/ktor/client/engine/HttpClientEngineCapability;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lio/ktor/http/Url;", "getUrl", "()Lio/ktor/http/Url;", "Lio/ktor/http/HttpMethod;", "getMethod", "()Lio/ktor/http/HttpMethod;", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "Lio/ktor/http/content/OutgoingContent;", "getBody", "()Lio/ktor/http/content/OutgoingContent;", "Lkotlinx/coroutines/Job;", "getExecutionContext", "()Lkotlinx/coroutines/Job;", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "", "requiredCapabilities", "Ljava/util/Set;", "getRequiredCapabilities$ktor_client_core", "()Ljava/util/Set;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpRequestData {
    private final Attributes attributes;
    private final OutgoingContent body;
    private final Job executionContext;
    private final Headers headers;
    private final HttpMethod method;
    private final Set<HttpClientEngineCapability<?>> requiredCapabilities;
    private final Url url;

    @InternalAPI
    public HttpRequestData(Url url, HttpMethod method, Headers headers, OutgoingContent body, Job executionContext, Attributes attributes) {
        Set<HttpClientEngineCapability<?>> emptySet;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = body;
        this.executionContext = executionContext;
        this.attributes = attributes;
        Map map = (Map) this.attributes.getOrNull(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY());
        this.requiredCapabilities = (map == null || (emptySet = map.keySet()) == null) ? SetsKt.emptySet() : emptySet;
    }

    public final Url getUrl() {
        return this.url;
    }

    public final HttpMethod getMethod() {
        return this.method;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final OutgoingContent getBody() {
        return this.body;
    }

    public final Job getExecutionContext() {
        return this.executionContext;
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final <T> T getCapabilityOrNull(HttpClientEngineCapability<T> httpClientEngineCapability) {
        Intrinsics.checkNotNullParameter(httpClientEngineCapability, q.KEY_RES_9_KEY);
        Map map = (Map) this.attributes.getOrNull(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY());
        if (map != null) {
            return (T) map.get(httpClientEngineCapability);
        }
        return null;
    }

    public final Set<HttpClientEngineCapability<?>> getRequiredCapabilities$ktor_client_core() {
        return this.requiredCapabilities;
    }

    public String toString() {
        return "HttpRequestData(url=" + this.url + ", method=" + this.method + ')';
    }
}