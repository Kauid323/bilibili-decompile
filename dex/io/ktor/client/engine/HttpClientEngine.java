package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.utils.io.InternalAPI;
import java.io.Closeable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

/* compiled from: HttpClientEngine.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000b\u0010!\u001a\u00020 8BX\u0082\u0004¨\u0006\""}, d2 = {"Lio/ktor/client/engine/HttpClientEngine;", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lio/ktor/client/request/HttpRequestData;", im.setting.UtilsKt.DATA_KEY, "Lio/ktor/client/request/HttpResponseData;", "execute", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/HttpClient;", "client", "", "install", "(Lio/ktor/client/HttpClient;)V", "requestData", "executeWithinCallContext", "(Lio/ktor/client/request/HttpRequestData;)Lio/ktor/client/request/HttpResponseData;", "checkExtensions", "(Lio/ktor/client/request/HttpRequestData;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lio/ktor/client/engine/HttpClientEngineConfig;", "getConfig", "()Lio/ktor/client/engine/HttpClientEngineConfig;", "config", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "getSupportedCapabilities", "()Ljava/util/Set;", "supportedCapabilities", "", "closed", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface HttpClientEngine extends CoroutineScope, Closeable {
    @InternalAPI
    Object execute(HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation);

    HttpClientEngineConfig getConfig();

    CoroutineDispatcher getDispatcher();

    Set<HttpClientEngineCapability<?>> getSupportedCapabilities();

    @InternalAPI
    void install(HttpClient httpClient);

    /* compiled from: HttpClientEngine.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultImpls {
        public static Set<HttpClientEngineCapability<?>> getSupportedCapabilities(HttpClientEngine $this) {
            return SetsKt.emptySet();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean getClosed(HttpClientEngine $this) {
            Job job = $this.getCoroutineContext().get(Job.Key);
            return !(job != null ? job.isActive() : false);
        }

        @InternalAPI
        public static void install(HttpClientEngine $this, HttpClient client) {
            Intrinsics.checkNotNullParameter(client, "client");
            client.getSendPipeline().intercept(HttpSendPipeline.Phases.getEngine(), new HttpClientEngine$install$1(client, $this, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0084 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object executeWithinCallContext(HttpClientEngine $this, HttpRequestData requestData, Continuation<? super HttpResponseData> continuation) {
            HttpClientEngine$executeWithinCallContext$1 httpClientEngine$executeWithinCallContext$1;
            Object createCallContext;
            HttpClientEngine $this2;
            HttpRequestData requestData2;
            if (continuation instanceof HttpClientEngine$executeWithinCallContext$1) {
                httpClientEngine$executeWithinCallContext$1 = (HttpClientEngine$executeWithinCallContext$1) continuation;
                if ((httpClientEngine$executeWithinCallContext$1.label & Integer.MIN_VALUE) != 0) {
                    httpClientEngine$executeWithinCallContext$1.label -= Integer.MIN_VALUE;
                    Object $result = httpClientEngine$executeWithinCallContext$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (httpClientEngine$executeWithinCallContext$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Job executionContext = requestData.getExecutionContext();
                            httpClientEngine$executeWithinCallContext$1.L$0 = $this;
                            httpClientEngine$executeWithinCallContext$1.L$1 = requestData;
                            httpClientEngine$executeWithinCallContext$1.label = 1;
                            createCallContext = HttpClientEngineKt.createCallContext($this, executionContext, httpClientEngine$executeWithinCallContext$1);
                            if (createCallContext != coroutine_suspended) {
                                $this2 = $this;
                                requestData2 = requestData;
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            requestData2 = (HttpRequestData) httpClientEngine$executeWithinCallContext$1.L$1;
                            $this2 = (HttpClientEngine) httpClientEngine$executeWithinCallContext$1.L$0;
                            ResultKt.throwOnFailure($result);
                            createCallContext = $result;
                            break;
                        case 2:
                            ResultKt.throwOnFailure($result);
                            return $result;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    CoroutineContext callContext = (CoroutineContext) createCallContext;
                    Deferred async$default = BuildersKt.async$default($this2, callContext.plus(new KtorCallContextElement(callContext)), (CoroutineStart) null, new HttpClientEngine$executeWithinCallContext$2($this2, requestData2, null), 2, (Object) null);
                    httpClientEngine$executeWithinCallContext$1.L$0 = null;
                    httpClientEngine$executeWithinCallContext$1.L$1 = null;
                    httpClientEngine$executeWithinCallContext$1.label = 2;
                    Object await = async$default.await(httpClientEngine$executeWithinCallContext$1);
                    return await != coroutine_suspended ? coroutine_suspended : await;
                }
            }
            httpClientEngine$executeWithinCallContext$1 = new HttpClientEngine$executeWithinCallContext$1(continuation);
            Object $result2 = httpClientEngine$executeWithinCallContext$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (httpClientEngine$executeWithinCallContext$1.label) {
            }
            CoroutineContext callContext2 = (CoroutineContext) createCallContext;
            Deferred async$default2 = BuildersKt.async$default($this2, callContext2.plus(new KtorCallContextElement(callContext2)), (CoroutineStart) null, new HttpClientEngine$executeWithinCallContext$2($this2, requestData2, null), 2, (Object) null);
            httpClientEngine$executeWithinCallContext$1.L$0 = null;
            httpClientEngine$executeWithinCallContext$1.L$1 = null;
            httpClientEngine$executeWithinCallContext$1.label = 2;
            Object await2 = async$default2.await(httpClientEngine$executeWithinCallContext$1);
            if (await2 != coroutine_suspended2) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void checkExtensions(HttpClientEngine $this, HttpRequestData requestData) {
            for (HttpClientEngineCapability requestedExtension : requestData.getRequiredCapabilities$ktor_client_core()) {
                if (!$this.getSupportedCapabilities().contains(requestedExtension)) {
                    throw new IllegalArgumentException(("Engine doesn't support " + requestedExtension).toString());
                }
            }
        }
    }
}