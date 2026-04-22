package io.ktor.client.plugins.cache;

import com.tencent.smtt.sdk.TbsListener;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.cache.storage.CachedResponseData;
import io.ktor.client.plugins.cache.storage.HttpCacheStorageKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCache.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "response"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache$Companion$install$2", f = "HttpCache.kt", i = {1, 1, 3, 3}, l = {TbsListener.ErrorCode.APK_VERSION_ERROR, TbsListener.ErrorCode.DEXOPT_EXCEPTION, TbsListener.ErrorCode.INCR_UPDATE_ERROR, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, TbsListener.ErrorCode.INSTALL_FROM_UNZIP}, m = "invokeSuspend", n = {"$this$intercept", "response", "$this$intercept", "response"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class HttpCache$Companion$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpCache $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCache$Companion$install$2(HttpCache httpCache, HttpClient httpClient, Continuation<? super HttpCache$Companion$install$2> continuation) {
        super(3, continuation);
        this.$plugin = httpCache;
        this.$scope = httpClient;
    }

    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        HttpCache$Companion$install$2 httpCache$Companion$install$2 = new HttpCache$Companion$install$2(this.$plugin, this.$scope, continuation);
        httpCache$Companion$install$2.L$0 = pipelineContext;
        httpCache$Companion$install$2.L$1 = httpResponse;
        return httpCache$Companion$install$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        boolean z;
        Object cacheResponse;
        Object $result2;
        PipelineContext $this$intercept;
        HttpResponse response;
        Object findAndRefresh;
        Object $result3;
        PipelineContext $this$intercept2;
        HttpResponse response2;
        CachedResponseData cachedData;
        HttpResponse responseFromCache;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept3 = (PipelineContext) this.L$0;
                HttpResponse response3 = (HttpResponse) this.L$1;
                if (Intrinsics.areEqual(response3.getCall().getRequest().getMethod(), HttpMethod.Companion.getGet())) {
                    z = this.$plugin.useOldStorage;
                    if (z) {
                        this.L$0 = null;
                        this.label = 1;
                        if (HttpCacheLegacyKt.interceptReceiveLegacy($this$intercept3, response3, this.$plugin, this.$scope, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    if (HttpStatusCodeKt.isSuccess(response3.getStatus())) {
                        HttpCacheKt.getLOGGER().trace("Caching response for " + response3.getCall().getRequest().getUrl());
                        this.L$0 = $this$intercept3;
                        this.L$1 = response3;
                        this.label = 2;
                        cacheResponse = this.$plugin.cacheResponse(response3, (Continuation) this);
                        if (cacheResponse == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result2 = $result;
                        $result = cacheResponse;
                        $this$intercept = $this$intercept3;
                        response = response3;
                        cachedData = (CachedResponseData) $result;
                        if (cachedData == null) {
                            HttpResponse reusableResponse = HttpCacheStorageKt.createResponse(cachedData, this.$scope, HttpResponseKt.getRequest(response), response.getCoroutineContext());
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 3;
                            return $this$intercept.proceedWith(reusableResponse, (Continuation) this) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                        }
                        $result = $result2;
                        response3 = response;
                        $this$intercept3 = $this$intercept;
                    }
                    if (Intrinsics.areEqual(response3.getStatus(), HttpStatusCode.Companion.getNotModified())) {
                        HttpCacheKt.getLOGGER().trace("Not modified response for " + response3.getCall().getRequest().getUrl() + ", replying from cache");
                        this.L$0 = $this$intercept3;
                        this.L$1 = response3;
                        this.label = 4;
                        findAndRefresh = this.$plugin.findAndRefresh(response3.getCall().getRequest(), response3, (Continuation) this);
                        if (findAndRefresh == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        HttpResponse httpResponse = response3;
                        $result3 = $result;
                        $result = findAndRefresh;
                        $this$intercept2 = $this$intercept3;
                        response2 = httpResponse;
                        responseFromCache = (HttpResponse) $result;
                        if (responseFromCache != null) {
                            throw new InvalidCacheStateException(response2.getCall().getRequest().getUrl());
                        }
                        this.$scope.getMonitor().raise(HttpCache.Companion.getHttpResponseFromCache(), responseFromCache);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 5;
                        if ($this$intercept2.proceedWith(responseFromCache, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                $this$intercept = (PipelineContext) this.L$0;
                response = (HttpResponse) this.L$1;
                $result2 = $result;
                cachedData = (CachedResponseData) $result;
                if (cachedData == null) {
                }
                break;
            case 3:
                ResultKt.throwOnFailure($result);
            case 4:
                ResultKt.throwOnFailure($result);
                $this$intercept2 = (PipelineContext) this.L$0;
                response2 = (HttpResponse) this.L$1;
                $result3 = $result;
                responseFromCache = (HttpResponse) $result;
                if (responseFromCache != null) {
                }
                break;
            case 5:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}