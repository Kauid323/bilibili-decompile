package io.ktor.client.plugins;

import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.slf4j.Logger;

/* compiled from: HttpRequestLifecycle.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0018\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/CompletableJob;", "requestJob", "Lkotlinx/coroutines/Job;", "clientEngineJob", "", "attachToClientEngineJob", "(Lkotlinx/coroutines/CompletableJob;Lkotlinx/coroutines/Job;)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpRequestLifecycle", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRequestLifecycle", "()Lio/ktor/client/plugins/api/ClientPlugin;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpRequestLifecycleKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpRequestLifecycle");
    private static final ClientPlugin<Unit> HttpRequestLifecycle = CreatePluginUtilsKt.createClientPlugin("RequestLifecycle", new Function1() { // from class: io.ktor.client.plugins.HttpRequestLifecycleKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj) {
            Unit HttpRequestLifecycle$lambda$0;
            HttpRequestLifecycle$lambda$0 = HttpRequestLifecycleKt.HttpRequestLifecycle$lambda$0((ClientPluginBuilder) obj);
            return HttpRequestLifecycle$lambda$0;
        }
    });

    public static final ClientPlugin<Unit> getHttpRequestLifecycle() {
        return HttpRequestLifecycle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpRequestLifecycle$lambda$0(ClientPluginBuilder $this$createClientPlugin) {
        Intrinsics.checkNotNullParameter($this$createClientPlugin, "$this$createClientPlugin");
        $this$createClientPlugin.on(SetupRequestContext.INSTANCE, new HttpRequestLifecycleKt$HttpRequestLifecycle$1$1($this$createClientPlugin, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachToClientEngineJob(final CompletableJob requestJob, Job clientEngineJob) {
        final DisposableHandle handler = clientEngineJob.invokeOnCompletion(new Function1() { // from class: io.ktor.client.plugins.HttpRequestLifecycleKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit attachToClientEngineJob$lambda$1;
                attachToClientEngineJob$lambda$1 = HttpRequestLifecycleKt.attachToClientEngineJob$lambda$1(requestJob, (Throwable) obj);
                return attachToClientEngineJob$lambda$1;
            }
        });
        requestJob.invokeOnCompletion(new Function1() { // from class: io.ktor.client.plugins.HttpRequestLifecycleKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit attachToClientEngineJob$lambda$2;
                attachToClientEngineJob$lambda$2 = HttpRequestLifecycleKt.attachToClientEngineJob$lambda$2(handler, (Throwable) obj);
                return attachToClientEngineJob$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit attachToClientEngineJob$lambda$1(CompletableJob $requestJob, Throwable cause) {
        if (cause != null) {
            LOGGER.trace("Cancelling request because engine Job failed with error: " + cause);
            JobKt.cancel((Job) $requestJob, "Engine failed", cause);
        } else {
            LOGGER.trace("Cancelling request because engine Job completed");
            $requestJob.complete();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit attachToClientEngineJob$lambda$2(DisposableHandle $handler, Throwable it) {
        $handler.dispose();
        return Unit.INSTANCE;
    }
}