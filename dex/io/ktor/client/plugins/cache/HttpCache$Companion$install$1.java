package io.ktor.client.plugins.cache;

import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.cache.storage.CachedResponseData;
import io.ktor.client.plugins.cache.storage.HttpCacheStorageKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", q.KEY_RES_9_CONTENT}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache$Companion$install$1", f = "HttpCache.kt", i = {1}, l = {161, 165, 171, 180, 185}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
public final class HttpCache$Companion$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpCache $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCache$Companion$install$1(HttpCache httpCache, HttpClient httpClient, Continuation<? super HttpCache$Companion$install$1> continuation) {
        super(3, continuation);
        this.$plugin = httpCache;
        this.$scope = httpClient;
    }

    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpCache$Companion$install$1 httpCache$Companion$install$1 = new HttpCache$Companion$install$1(this.$plugin, this.$scope, continuation);
        httpCache$Companion$install$1.L$0 = pipelineContext;
        httpCache$Companion$install$1.L$1 = obj;
        return httpCache$Companion$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        boolean canStore;
        boolean z;
        Object content;
        PipelineContext $this$intercept;
        Object $result2;
        CachedResponseData cache;
        Object proceedWithWarning;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept2 = (PipelineContext) this.L$0;
                Object content2 = this.L$1;
                if (content2 instanceof OutgoingContent.NoContent) {
                    if (Intrinsics.areEqual(((HttpRequestBuilder) $this$intercept2.getContext()).getMethod(), HttpMethod.Companion.getGet())) {
                        canStore = HttpCacheKt.canStore(((HttpRequestBuilder) $this$intercept2.getContext()).getUrl().getProtocol());
                        if (canStore) {
                            if (this.$plugin.isSharedClient$ktor_client_core() && ((HttpRequestBuilder) $this$intercept2.getContext()).getHeaders().contains(HttpHeaders.INSTANCE.getAuthorization())) {
                                return Unit.INSTANCE;
                            }
                            z = this.$plugin.useOldStorage;
                            if (z) {
                                this.L$0 = null;
                                this.label = 1;
                                if (HttpCacheLegacyKt.interceptSendLegacy($this$intercept2, this.$plugin, (OutgoingContent) content2, this.$scope, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                            this.L$0 = $this$intercept2;
                            this.label = 2;
                            content = this.$plugin.findResponse((HttpRequestBuilder) $this$intercept2.getContext(), (OutgoingContent) content2, (Continuation) this);
                            if (content == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$intercept = $this$intercept2;
                            $result2 = $result;
                            $result = content;
                            cache = (CachedResponseData) $result;
                            if (cache != null) {
                                HttpCacheKt.getLOGGER().trace("No cached response for " + ((HttpRequestBuilder) $this$intercept.getContext()).getUrl() + " found");
                                List header = HttpHeaderValueParserKt.parseHeaderValue(((HttpRequestBuilder) $this$intercept.getContext()).getHeaders().get(HttpHeaders.INSTANCE.getCacheControl()));
                                if (header.contains(CacheControl.INSTANCE.getONLY_IF_CACHED$ktor_client_core())) {
                                    HttpCacheKt.getLOGGER().trace("No cache found and \"only-if-cached\" set for " + ((HttpRequestBuilder) $this$intercept.getContext()).getUrl());
                                    this.L$0 = null;
                                    this.label = 3;
                                    if (HttpCache.Companion.proceedWithMissingCache$ktor_client_core($this$intercept, this.$scope, (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $result = $result2;
                                }
                                return Unit.INSTANCE;
                            }
                            ValidateStatus validateStatus = HttpCacheEntryKt.shouldValidate(cache.getExpires(), cache.getHeaders(), (HttpRequestBuilder) $this$intercept.getContext());
                            if (validateStatus == ValidateStatus.ShouldNotValidate) {
                                HttpClientCall cachedCall = HttpCacheStorageKt.createResponse(cache, this.$scope, new RequestForCache(((HttpRequestBuilder) $this$intercept.getContext()).build()), ((HttpRequestBuilder) $this$intercept.getContext()).getExecutionContext()).getCall();
                                this.L$0 = null;
                                this.label = 4;
                                return HttpCache.Companion.proceedWithCache$ktor_client_core($this$intercept, this.$scope, cachedCall, (Continuation) this) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                            } else if (validateStatus == ValidateStatus.ShouldWarn) {
                                this.L$0 = null;
                                this.label = 5;
                                proceedWithWarning = HttpCache.Companion.proceedWithWarning($this$intercept, cache, this.$scope, ((HttpRequestBuilder) $this$intercept.getContext()).getExecutionContext(), (Continuation) this);
                                return proceedWithWarning == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                            } else {
                                String etag = cache.getHeaders().get(HttpHeaders.INSTANCE.getETag());
                                if (etag != null) {
                                    HttpCacheKt.getLOGGER().trace("Adding If-None-Match=" + etag + " for " + ((HttpRequestBuilder) $this$intercept.getContext()).getUrl());
                                    UtilsKt.header((HttpMessageBuilder) $this$intercept.getContext(), HttpHeaders.INSTANCE.getIfNoneMatch(), etag);
                                }
                                String it = cache.getHeaders().get(HttpHeaders.INSTANCE.getLastModified());
                                if (it != null) {
                                    HttpCacheKt.getLOGGER().trace("Adding If-Modified-Since=" + it + " for " + ((HttpRequestBuilder) $this$intercept.getContext()).getUrl());
                                    UtilsKt.header((HttpMessageBuilder) $this$intercept.getContext(), HttpHeaders.INSTANCE.getIfModifiedSince(), it);
                                }
                                return Unit.INSTANCE;
                            }
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
                $result2 = $result;
                cache = (CachedResponseData) $result;
                if (cache != null) {
                }
                break;
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 4:
                ResultKt.throwOnFailure($result);
            case 5:
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}