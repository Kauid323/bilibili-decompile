package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.util.CoroutinesUtilsKt;
import io.ktor.utils.io.InternalAPI;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;

/* compiled from: HttpClientEngineBase.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lio/ktor/client/engine/HttpClientEngineBase;", "Lio/ktor/client/engine/HttpClientEngine;", "", "engineName", "<init>", "(Ljava/lang/String;)V", "", "close", "()V", "Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher$delegate", "Lkotlin/Lazy;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext$delegate", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class HttpClientEngineBase implements HttpClientEngine {
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientEngineBase.class, "closed");
    private volatile /* synthetic */ int closed;
    private final Lazy coroutineContext$delegate;
    private final Lazy dispatcher$delegate;
    private final String engineName;

    public HttpClientEngineBase(String engineName) {
        Intrinsics.checkNotNullParameter(engineName, "engineName");
        this.engineName = engineName;
        this.closed = 0;
        this.dispatcher$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.client.engine.HttpClientEngineBase$$ExternalSyntheticLambda0
            public final Object invoke() {
                CoroutineDispatcher dispatcher_delegate$lambda$0;
                dispatcher_delegate$lambda$0 = HttpClientEngineBase.dispatcher_delegate$lambda$0(HttpClientEngineBase.this);
                return dispatcher_delegate$lambda$0;
            }
        });
        this.coroutineContext$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.client.engine.HttpClientEngineBase$$ExternalSyntheticLambda1
            public final Object invoke() {
                CoroutineContext coroutineContext_delegate$lambda$1;
                coroutineContext_delegate$lambda$1 = HttpClientEngineBase.coroutineContext_delegate$lambda$1(HttpClientEngineBase.this);
                return coroutineContext_delegate$lambda$1;
            }
        });
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return HttpClientEngine.DefaultImpls.getSupportedCapabilities(this);
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    @InternalAPI
    public void install(HttpClient client) {
        HttpClientEngine.DefaultImpls.install(this, client);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineDispatcher dispatcher_delegate$lambda$0(HttpClientEngineBase this$0) {
        CoroutineDispatcher dispatcher = this$0.getConfig().getDispatcher();
        return dispatcher == null ? HttpClientEngineBase_jvmKt.ioDispatcher() : dispatcher;
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public CoroutineDispatcher getDispatcher() {
        return (CoroutineDispatcher) this.dispatcher$delegate.getValue();
    }

    public CoroutineContext getCoroutineContext() {
        return (CoroutineContext) this.coroutineContext$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineContext coroutineContext_delegate$lambda$1(HttpClientEngineBase this$0) {
        return CoroutinesUtilsKt.SilentSupervisor$default((Job) null, 1, (Object) null).plus(this$0.getDispatcher()).plus(new CoroutineName(this$0.engineName + "-context"));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (closed$FU.compareAndSet(this, 0, 1)) {
            CompletableJob completableJob = getCoroutineContext().get(Job.Key);
            CompletableJob requestJob = completableJob instanceof CompletableJob ? completableJob : null;
            if (requestJob == null) {
                return;
            }
            requestJob.complete();
        }
    }
}