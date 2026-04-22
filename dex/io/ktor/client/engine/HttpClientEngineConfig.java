package io.ktor.client.engine;

import io.ktor.utils.io.KtorDsl;
import java.net.Proxy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: HttpClientEngineConfig.kt */
@KtorDsl
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001c\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lio/ktor/client/engine/HttpClientEngineConfig;", "", "<init>", "()V", "", "threadsCount", "I", "getThreadsCount", "()I", "setThreadsCount", "(I)V", "getThreadsCount$annotations", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "setDispatcher", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "", "pipelining", "Z", "getPipelining", "()Z", "setPipelining", "(Z)V", "Ljava/net/Proxy;", "Lio/ktor/client/engine/ProxyConfig;", "proxy", "Ljava/net/Proxy;", "getProxy", "()Ljava/net/Proxy;", "setProxy", "(Ljava/net/Proxy;)V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class HttpClientEngineConfig {
    private CoroutineDispatcher dispatcher;
    private boolean pipelining;
    private Proxy proxy;
    private int threadsCount = 4;

    @Deprecated(level = DeprecationLevel.ERROR, message = "The [threadsCount] property is deprecated. Consider setting [dispatcher] instead.")
    public static /* synthetic */ void getThreadsCount$annotations() {
    }

    public final int getThreadsCount() {
        return this.threadsCount;
    }

    public final void setThreadsCount(int i2) {
        this.threadsCount = i2;
    }

    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final void setDispatcher(CoroutineDispatcher coroutineDispatcher) {
        this.dispatcher = coroutineDispatcher;
    }

    public final boolean getPipelining() {
        return this.pipelining;
    }

    public final void setPipelining(boolean z) {
        this.pipelining = z;
    }

    public final Proxy getProxy() {
        return this.proxy;
    }

    public final void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }
}