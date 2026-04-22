package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.call.SavedHttpCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCacheEntry.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B5\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u000eR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lio/ktor/client/plugins/cache/HttpCacheEntry;", "", "Lio/ktor/util/date/GMTDate;", "expires", "", "", "varyKeys", "Lio/ktor/client/statement/HttpResponse;", "response", "", "body", "<init>", "(Lio/ktor/util/date/GMTDate;Ljava/util/Map;Lio/ktor/client/statement/HttpResponse;[B)V", "produceResponse$ktor_client_core", "()Lio/ktor/client/statement/HttpResponse;", "produceResponse", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lio/ktor/util/date/GMTDate;", "getExpires", "()Lio/ktor/util/date/GMTDate;", "Ljava/util/Map;", "getVaryKeys", "()Ljava/util/Map;", "Lio/ktor/client/statement/HttpResponse;", "getResponse", "[B", "getBody", "()[B", "Lio/ktor/http/Headers;", "responseHeaders", "Lio/ktor/http/Headers;", "getResponseHeaders$ktor_client_core", "()Lio/ktor/http/Headers;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpCacheEntry {
    private final byte[] body;
    private final GMTDate expires;
    private final HttpResponse response;
    private final Headers responseHeaders;
    private final Map<String, String> varyKeys;

    public HttpCacheEntry(GMTDate expires, Map<String, String> map, HttpResponse response, byte[] body) {
        Intrinsics.checkNotNullParameter(expires, "expires");
        Intrinsics.checkNotNullParameter(map, "varyKeys");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(body, "body");
        this.expires = expires;
        this.varyKeys = map;
        this.response = response;
        this.body = body;
        Headers.Companion companion = Headers.Companion;
        HeadersBuilder $this$responseHeaders_u24lambda_u240 = new HeadersBuilder(0, 1, null);
        $this$responseHeaders_u24lambda_u240.appendAll(this.response.getHeaders());
        this.responseHeaders = $this$responseHeaders_u24lambda_u240.m3526build();
    }

    public final GMTDate getExpires() {
        return this.expires;
    }

    public final Map<String, String> getVaryKeys() {
        return this.varyKeys;
    }

    public final HttpResponse getResponse() {
        return this.response;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public final Headers getResponseHeaders$ktor_client_core() {
        return this.responseHeaders;
    }

    public final HttpResponse produceResponse$ktor_client_core() {
        HttpClient currentClient = this.response.getCall().getClient();
        SavedHttpCall call = new SavedHttpCall(currentClient, this.response.getCall().getRequest(), this.response, this.body);
        return call.getResponse();
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof HttpCacheEntry)) {
            return false;
        }
        if (other == this) {
            return true;
        }
        return Intrinsics.areEqual(this.varyKeys, ((HttpCacheEntry) other).varyKeys);
    }

    public int hashCode() {
        return this.varyKeys.hashCode();
    }
}