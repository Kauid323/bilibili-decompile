package io.ktor.client.plugins;

import faceverify.q;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: HttpTimeout.kt */
@KtorDsl
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB-\b\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R(\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006\u001f"}, d2 = {"Lio/ktor/client/plugins/HttpTimeoutConfig;", "", "", "requestTimeoutMillis", "connectTimeoutMillis", "socketTimeoutMillis", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "value", "checkTimeoutValue", "(Ljava/lang/Long;)Ljava/lang/Long;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "_requestTimeoutMillis", "Ljava/lang/Long;", "_connectTimeoutMillis", "_socketTimeoutMillis", "getRequestTimeoutMillis", "()Ljava/lang/Long;", "setRequestTimeoutMillis", "(Ljava/lang/Long;)V", "getConnectTimeoutMillis", "setConnectTimeoutMillis", "getSocketTimeoutMillis", "setSocketTimeoutMillis", "Companion", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpTimeoutConfig {
    public static final Companion Companion = new Companion(null);
    public static final long INFINITE_TIMEOUT_MS = Long.MAX_VALUE;
    private static final AttributeKey<HttpTimeoutConfig> key;
    private Long _connectTimeoutMillis;
    private Long _requestTimeoutMillis;
    private Long _socketTimeoutMillis;

    public /* synthetic */ HttpTimeoutConfig(Long l, Long l2, Long l3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : l, (i2 & 2) != 0 ? null : l2, (i2 & 4) != 0 ? null : l3);
    }

    public HttpTimeoutConfig(Long requestTimeoutMillis, Long connectTimeoutMillis, Long socketTimeoutMillis) {
        this._requestTimeoutMillis = 0L;
        this._connectTimeoutMillis = 0L;
        this._socketTimeoutMillis = 0L;
        setRequestTimeoutMillis(requestTimeoutMillis);
        setConnectTimeoutMillis(connectTimeoutMillis);
        setSocketTimeoutMillis(socketTimeoutMillis);
    }

    public final Long getRequestTimeoutMillis() {
        return this._requestTimeoutMillis;
    }

    public final void setRequestTimeoutMillis(Long value) {
        this._requestTimeoutMillis = checkTimeoutValue(value);
    }

    public final Long getConnectTimeoutMillis() {
        return this._connectTimeoutMillis;
    }

    public final void setConnectTimeoutMillis(Long value) {
        this._connectTimeoutMillis = checkTimeoutValue(value);
    }

    public final Long getSocketTimeoutMillis() {
        return this._socketTimeoutMillis;
    }

    public final void setSocketTimeoutMillis(Long value) {
        this._socketTimeoutMillis = checkTimeoutValue(value);
    }

    private final Long checkTimeoutValue(Long value) {
        if (!(value == null || value.longValue() > 0)) {
            throw new IllegalArgumentException("Only positive timeout values are allowed, for infinite timeout use HttpTimeout.INFINITE_TIMEOUT_MS".toString());
        }
        return value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) other;
        if (Intrinsics.areEqual(this._requestTimeoutMillis, ((HttpTimeoutConfig) other)._requestTimeoutMillis) && Intrinsics.areEqual(this._connectTimeoutMillis, ((HttpTimeoutConfig) other)._connectTimeoutMillis) && Intrinsics.areEqual(this._socketTimeoutMillis, ((HttpTimeoutConfig) other)._socketTimeoutMillis)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Long l = this._requestTimeoutMillis;
        int result = l != null ? l.hashCode() : 0;
        int i2 = result * 31;
        Long l2 = this._connectTimeoutMillis;
        int result2 = i2 + (l2 != null ? l2.hashCode() : 0);
        int result3 = result2 * 31;
        Long l3 = this._socketTimeoutMillis;
        return result3 + (l3 != null ? l3.hashCode() : 0);
    }

    /* compiled from: HttpTimeout.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/client/plugins/HttpTimeoutConfig$Companion;", "", "<init>", "()V", "", "INFINITE_TIMEOUT_MS", "J", "Lio/ktor/util/AttributeKey;", "Lio/ktor/client/plugins/HttpTimeoutConfig;", q.KEY_RES_9_KEY, "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AttributeKey<HttpTimeoutConfig> getKey() {
            return HttpTimeoutConfig.key;
        }
    }

    static {
        KType kType = null;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HttpTimeoutConfig.class);
        try {
            kType = Reflection.typeOf(HttpTimeoutConfig.class);
        } catch (Throwable th) {
        }
        key = new AttributeKey<>("TimeoutConfiguration", new TypeInfo(orCreateKotlinClass, kType));
    }
}