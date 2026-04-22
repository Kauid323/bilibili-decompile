package io.ktor.client.plugins;

import com.tencent.open.SocialConstants;
import io.ktor.client.network.sockets.ConnectTimeoutException;
import io.ktor.client.network.sockets.TimeoutExceptionsKt;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.utils.io.InternalAPI;
import java.net.SocketTimeoutException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* compiled from: HttpTimeout.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a*\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000e\u001a+\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u0012\u001a%\u0010\u0015\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a'\u0010\u001e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001c2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0081\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\"\u0018\u0010\"\u001a\u00060 j\u0002`!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#\"#\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020$8\u0006¢\u0006\u0012\n\u0004\b%\u0010&\u0012\u0004\b)\u0010*\u001a\u0004\b'\u0010(\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006+"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpTimeoutConfig;", "", "Lkotlin/ExtensionFunctionType;", "block", "timeout", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/client/request/HttpRequestData;", SocialConstants.TYPE_REQUEST, "", "cause", "Lio/ktor/client/network/sockets/ConnectTimeoutException;", "ConnectTimeoutException", "(Lio/ktor/client/request/HttpRequestData;Ljava/lang/Throwable;)Lio/ktor/client/network/sockets/ConnectTimeoutException;", "", "url", "", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Throwable;)Lio/ktor/client/network/sockets/ConnectTimeoutException;", "Ljava/net/SocketTimeoutException;", "Lio/ktor/client/network/sockets/SocketTimeoutException;", "SocketTimeoutException", "(Lio/ktor/client/request/HttpRequestData;Ljava/lang/Throwable;)Ljava/net/SocketTimeoutException;", "", "convertLongTimeoutToIntWithInfiniteAsZero", "(J)I", "convertLongTimeoutToLongWithInfiniteAsZero", "(J)J", "T", "Lkotlin/Function0;", "unwrapRequestTimeoutException", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpTimeout", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpTimeout", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpTimeout$annotations", "()V", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpTimeoutKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpTimeout");
    private static final ClientPlugin<HttpTimeoutConfig> HttpTimeout = CreatePluginUtilsKt.createClientPlugin("HttpTimeout", HttpTimeoutKt$HttpTimeout$1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.HttpTimeoutKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit HttpTimeout$lambda$1;
            HttpTimeout$lambda$1 = HttpTimeoutKt.HttpTimeout$lambda$1((ClientPluginBuilder) obj);
            return HttpTimeout$lambda$1;
        }
    });

    public static /* synthetic */ void getHttpTimeout$annotations() {
    }

    public static final ClientPlugin<HttpTimeoutConfig> getHttpTimeout() {
        return HttpTimeout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpTimeout$lambda$1(ClientPluginBuilder $this$createClientPlugin) {
        Intrinsics.checkNotNullParameter($this$createClientPlugin, "$this$createClientPlugin");
        Long requestTimeoutMillis = ((HttpTimeoutConfig) $this$createClientPlugin.getPluginConfig()).getRequestTimeoutMillis();
        Long connectTimeoutMillis = ((HttpTimeoutConfig) $this$createClientPlugin.getPluginConfig()).getConnectTimeoutMillis();
        Long socketTimeoutMillis = ((HttpTimeoutConfig) $this$createClientPlugin.getPluginConfig()).getSocketTimeoutMillis();
        $this$createClientPlugin.on(Send.INSTANCE, new HttpTimeoutKt$HttpTimeout$2$1(requestTimeoutMillis, connectTimeoutMillis, socketTimeoutMillis, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HttpTimeout$lambda$1$hasNotNullTimeouts(Long requestTimeoutMillis, Long connectTimeoutMillis, Long socketTimeoutMillis) {
        return (requestTimeoutMillis == null && connectTimeoutMillis == null && socketTimeoutMillis == null) ? false : true;
    }

    public static final void timeout(HttpRequestBuilder $this$timeout, Function1<? super HttpTimeoutConfig, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$timeout, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        HttpTimeoutConfig httpTimeoutConfig = new HttpTimeoutConfig(null, null, null, 7, null);
        function1.invoke(httpTimeoutConfig);
        $this$timeout.setCapability(HttpTimeoutCapability.INSTANCE, httpTimeoutConfig);
    }

    public static /* synthetic */ ConnectTimeoutException ConnectTimeoutException$default(HttpRequestData httpRequestData, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        return ConnectTimeoutException(httpRequestData, th);
    }

    public static final ConnectTimeoutException ConnectTimeoutException(HttpRequestData request, Throwable cause) {
        Intrinsics.checkNotNullParameter(request, SocialConstants.TYPE_REQUEST);
        StringBuilder append = new StringBuilder().append("Connect timeout has expired [url=").append(request.getUrl()).append(", connect_timeout=");
        HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) request.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE);
        return new ConnectTimeoutException(append.append((httpTimeoutConfig == null || (r2 = httpTimeoutConfig.getConnectTimeoutMillis()) == null) ? "unknown" : "unknown").append(" ms]").toString(), cause);
    }

    public static /* synthetic */ ConnectTimeoutException ConnectTimeoutException$default(String str, Long l, Throwable th, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            th = null;
        }
        return ConnectTimeoutException(str, l, th);
    }

    public static final ConnectTimeoutException ConnectTimeoutException(String url, Long timeout, Throwable cause) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new ConnectTimeoutException("Connect timeout has expired [url=" + url + ", connect_timeout=" + (timeout == null ? "unknown" : timeout) + " ms]", cause);
    }

    public static /* synthetic */ SocketTimeoutException SocketTimeoutException$default(HttpRequestData httpRequestData, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        return SocketTimeoutException(httpRequestData, th);
    }

    public static final SocketTimeoutException SocketTimeoutException(HttpRequestData request, Throwable cause) {
        Intrinsics.checkNotNullParameter(request, SocialConstants.TYPE_REQUEST);
        StringBuilder append = new StringBuilder().append("Socket timeout has expired [url=").append(request.getUrl()).append(", socket_timeout=");
        HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) request.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE);
        return TimeoutExceptionsKt.SocketTimeoutException(append.append((httpTimeoutConfig == null || (r1 = httpTimeoutConfig.getSocketTimeoutMillis()) == null) ? "unknown" : "unknown").append("] ms").toString(), cause);
    }

    @InternalAPI
    public static final int convertLongTimeoutToIntWithInfiniteAsZero(long timeout) {
        if (timeout == Long.MAX_VALUE) {
            return 0;
        }
        if (timeout < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (timeout > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) timeout;
    }

    @InternalAPI
    public static final long convertLongTimeoutToLongWithInfiniteAsZero(long timeout) {
        if (timeout == Long.MAX_VALUE) {
            return 0L;
        }
        return timeout;
    }

    public static final <T> T unwrapRequestTimeoutException(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            return (T) function0.invoke();
        } catch (CancellationException cause) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(cause);
        }
    }
}