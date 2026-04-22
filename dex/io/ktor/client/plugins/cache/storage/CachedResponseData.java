package io.ktor.client.plugins.cache.storage;

import com.xiaomi.mipush.sdk.Constants;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.Url;
import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCacheStorage.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001e\u001a\u00020\u00002\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b(\u0010'R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b,\u0010'R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b.\u0010/R#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u00100\u001a\u0004\b1\u00102R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u00103\u001a\u0004\b4\u00105¨\u00066"}, d2 = {"Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "", "Lio/ktor/http/Url;", "url", "Lio/ktor/http/HttpStatusCode;", "statusCode", "Lio/ktor/util/date/GMTDate;", "requestTime", "responseTime", "Lio/ktor/http/HttpProtocolVersion;", Constants.VERSION, "expires", "Lio/ktor/http/Headers;", "headers", "", "", "varyKeys", "", "body", "<init>", "(Lio/ktor/http/Url;Lio/ktor/http/HttpStatusCode;Lio/ktor/util/date/GMTDate;Lio/ktor/util/date/GMTDate;Lio/ktor/http/HttpProtocolVersion;Lio/ktor/util/date/GMTDate;Lio/ktor/http/Headers;Ljava/util/Map;[B)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "copy$ktor_client_core", "(Ljava/util/Map;Lio/ktor/util/date/GMTDate;)Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "copy", "Lio/ktor/http/Url;", "getUrl", "()Lio/ktor/http/Url;", "Lio/ktor/http/HttpStatusCode;", "getStatusCode", "()Lio/ktor/http/HttpStatusCode;", "Lio/ktor/util/date/GMTDate;", "getRequestTime", "()Lio/ktor/util/date/GMTDate;", "getResponseTime", "Lio/ktor/http/HttpProtocolVersion;", "getVersion", "()Lio/ktor/http/HttpProtocolVersion;", "getExpires", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "Ljava/util/Map;", "getVaryKeys", "()Ljava/util/Map;", "[B", "getBody", "()[B", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CachedResponseData {
    private final byte[] body;
    private final GMTDate expires;
    private final Headers headers;
    private final GMTDate requestTime;
    private final GMTDate responseTime;
    private final HttpStatusCode statusCode;
    private final Url url;
    private final Map<String, String> varyKeys;
    private final HttpProtocolVersion version;

    public CachedResponseData(Url url, HttpStatusCode statusCode, GMTDate requestTime, GMTDate responseTime, HttpProtocolVersion version, GMTDate expires, Headers headers, Map<String, String> map, byte[] body) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        Intrinsics.checkNotNullParameter(requestTime, "requestTime");
        Intrinsics.checkNotNullParameter(responseTime, "responseTime");
        Intrinsics.checkNotNullParameter(version, Constants.VERSION);
        Intrinsics.checkNotNullParameter(expires, "expires");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(map, "varyKeys");
        Intrinsics.checkNotNullParameter(body, "body");
        this.url = url;
        this.statusCode = statusCode;
        this.requestTime = requestTime;
        this.responseTime = responseTime;
        this.version = version;
        this.expires = expires;
        this.headers = headers;
        this.varyKeys = map;
        this.body = body;
    }

    public final Url getUrl() {
        return this.url;
    }

    public final HttpStatusCode getStatusCode() {
        return this.statusCode;
    }

    public final GMTDate getRequestTime() {
        return this.requestTime;
    }

    public final GMTDate getResponseTime() {
        return this.responseTime;
    }

    public final HttpProtocolVersion getVersion() {
        return this.version;
    }

    public final GMTDate getExpires() {
        return this.expires;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final Map<String, String> getVaryKeys() {
        return this.varyKeys;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CachedResponseData) && Intrinsics.areEqual(this.url, ((CachedResponseData) other).url) && Intrinsics.areEqual(this.varyKeys, ((CachedResponseData) other).varyKeys);
    }

    public int hashCode() {
        int result = this.url.hashCode();
        return (result * 31) + this.varyKeys.hashCode();
    }

    public final CachedResponseData copy$ktor_client_core(Map<String, String> map, GMTDate expires) {
        Intrinsics.checkNotNullParameter(map, "varyKeys");
        Intrinsics.checkNotNullParameter(expires, "expires");
        return new CachedResponseData(this.url, this.statusCode, this.requestTime, this.responseTime, this.version, expires, this.headers, map, this.body);
    }
}