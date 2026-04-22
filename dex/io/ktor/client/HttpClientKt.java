package io.ktor.client;

import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.engine.HttpClientEngineFactory;
import io.ktor.utils.io.KtorDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: HttpClient.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u001f\b\u0002\u0010\b\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a4\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u001b\u0010\b\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/engine/HttpClientEngineConfig;", "T", "Lio/ktor/client/engine/HttpClientEngineFactory;", "engineFactory", "Lkotlin/Function1;", "Lio/ktor/client/HttpClientConfig;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lio/ktor/client/HttpClient;", "HttpClient", "(Lio/ktor/client/engine/HttpClientEngineFactory;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/HttpClient;", "Lio/ktor/client/engine/HttpClientEngine;", "engine", "(Lio/ktor/client/engine/HttpClientEngine;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/HttpClient;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpClientKt {
    public static /* synthetic */ HttpClient HttpClient$default(HttpClientEngineFactory httpClientEngineFactory, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.HttpClientKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit HttpClient$lambda$0;
                    HttpClient$lambda$0 = HttpClientKt.HttpClient$lambda$0((HttpClientConfig) obj2);
                    return HttpClient$lambda$0;
                }
            };
        }
        return HttpClient(httpClientEngineFactory, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpClient$lambda$0(HttpClientConfig httpClientConfig) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        return Unit.INSTANCE;
    }

    @KtorDsl
    public static final <T extends HttpClientEngineConfig> HttpClient HttpClient(HttpClientEngineFactory<? extends T> httpClientEngineFactory, Function1<? super HttpClientConfig<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpClientEngineFactory, "engineFactory");
        Intrinsics.checkNotNullParameter(function1, "block");
        HttpClientConfig config = new HttpClientConfig();
        function1.invoke(config);
        final HttpClientEngine engine = httpClientEngineFactory.create(config.getEngineConfig$ktor_client_core());
        HttpClient client = new HttpClient(engine, config, true);
        Job job = client.getCoroutineContext().get(Job.Key);
        Intrinsics.checkNotNull(job);
        job.invokeOnCompletion(new Function1() { // from class: io.ktor.client.HttpClientKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit HttpClient$lambda$1;
                HttpClient$lambda$1 = HttpClientKt.HttpClient$lambda$1(HttpClientEngine.this, (Throwable) obj);
                return HttpClient$lambda$1;
            }
        });
        return client;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpClient$lambda$1(HttpClientEngine $engine, Throwable it) {
        $engine.close();
        return Unit.INSTANCE;
    }

    @KtorDsl
    public static final HttpClient HttpClient(HttpClientEngine engine, Function1<? super HttpClientConfig<?>, Unit> function1) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(function1, "block");
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        function1.invoke(httpClientConfig);
        return new HttpClient(engine, httpClientConfig, false);
    }
}