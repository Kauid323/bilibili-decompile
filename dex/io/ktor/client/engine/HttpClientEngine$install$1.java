package io.ktor.client.engine;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ClientEventsKt;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpClientEngine.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", q.KEY_RES_9_CONTENT}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$install$1", f = "HttpClientEngine.kt", i = {0, 0}, l = {WXMediaMessage.IMediaObject.TYPE_GAME_LIVE, 82}, m = "invokeSuspend", n = {"$this$intercept", "requestData"}, s = {"L$0", "L$1"})
public final class HttpClientEngine$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpClient $client;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ HttpClientEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientEngine$install$1(HttpClient httpClient, HttpClientEngine httpClientEngine, Continuation<? super HttpClientEngine$install$1> continuation) {
        super(3, continuation);
        this.$client = httpClient;
        this.this$0 = httpClientEngine;
    }

    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpClientEngine$install$1 httpClientEngine$install$1 = new HttpClientEngine$install$1(this.$client, this.this$0, continuation);
        httpClientEngine$install$1.L$0 = pipelineContext;
        httpClientEngine$install$1.L$1 = obj;
        return httpClientEngine$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0116 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        KType kType;
        Object executeWithinCallContext;
        Object $result2;
        PipelineContext $this$intercept;
        HttpRequestData requestData;
        KType kType2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept2 = (PipelineContext) this.L$0;
                Object content = this.L$1;
                HttpRequestBuilder $this$invokeSuspend_u24lambda_u240 = new HttpRequestBuilder();
                $this$invokeSuspend_u24lambda_u240.takeFromWithExecutionContext((HttpRequestBuilder) $this$intercept2.getContext());
                if (content == null) {
                    $this$invokeSuspend_u24lambda_u240.setBody(NullBody.INSTANCE);
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                    try {
                        kType2 = Reflection.typeOf(Object.class);
                    } catch (Throwable th) {
                        kType2 = null;
                    }
                    $this$invokeSuspend_u24lambda_u240.setBodyType(new TypeInfo(orCreateKotlinClass, kType2));
                } else if (content instanceof OutgoingContent) {
                    $this$invokeSuspend_u24lambda_u240.setBody(content);
                    $this$invokeSuspend_u24lambda_u240.setBodyType(null);
                } else {
                    $this$invokeSuspend_u24lambda_u240.setBody(content);
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                    try {
                        kType = Reflection.typeOf(Object.class);
                    } catch (Throwable th2) {
                        kType = null;
                    }
                    $this$invokeSuspend_u24lambda_u240.setBodyType(new TypeInfo(orCreateKotlinClass2, kType));
                }
                this.$client.getMonitor().raise(ClientEventsKt.getHttpRequestIsReadyForSending(), $this$invokeSuspend_u24lambda_u240);
                HttpRequestData $this$invokeSuspend_u24lambda_u241 = $this$invokeSuspend_u24lambda_u240.build();
                $this$invokeSuspend_u24lambda_u241.getAttributes().put(HttpClientEngineKt.getCLIENT_CONFIG(), this.$client.getConfig$ktor_client_core());
                HttpClientEngineKt.validateHeaders($this$invokeSuspend_u24lambda_u241);
                HttpClientEngine.DefaultImpls.checkExtensions(this.this$0, $this$invokeSuspend_u24lambda_u241);
                this.L$0 = $this$intercept2;
                this.L$1 = $this$invokeSuspend_u24lambda_u241;
                this.label = 1;
                executeWithinCallContext = HttpClientEngine.DefaultImpls.executeWithinCallContext(this.this$0, $this$invokeSuspend_u24lambda_u241, (Continuation) this);
                if (executeWithinCallContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = executeWithinCallContext;
                $this$intercept = $this$intercept2;
                requestData = $this$invokeSuspend_u24lambda_u241;
                HttpResponseData responseData = (HttpResponseData) $result;
                HttpClientCall call = new HttpClientCall(this.$client, requestData, responseData);
                final HttpResponse response = call.getResponse();
                this.$client.getMonitor().raise(ClientEventsKt.getHttpResponseReceived(), response);
                Job job = JobKt.getJob(response.getCoroutineContext());
                final HttpClient httpClient = this.$client;
                job.invokeOnCompletion(new Function1() { // from class: io.ktor.client.engine.HttpClientEngine$install$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = HttpClientEngine$install$1.invokeSuspend$lambda$2(HttpClient.this, response, (Throwable) obj);
                        return invokeSuspend$lambda$2;
                    }
                });
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                return $this$intercept.proceedWith(call, (Continuation) this) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
            case 1:
                HttpRequestData requestData2 = (HttpRequestData) this.L$1;
                ResultKt.throwOnFailure($result);
                $this$intercept = (PipelineContext) this.L$0;
                requestData = requestData2;
                $result2 = $result;
                HttpResponseData responseData2 = (HttpResponseData) $result;
                HttpClientCall call2 = new HttpClientCall(this.$client, requestData, responseData2);
                final HttpResponse response2 = call2.getResponse();
                this.$client.getMonitor().raise(ClientEventsKt.getHttpResponseReceived(), response2);
                Job job2 = JobKt.getJob(response2.getCoroutineContext());
                final HttpClient httpClient2 = this.$client;
                job2.invokeOnCompletion(new Function1() { // from class: io.ktor.client.engine.HttpClientEngine$install$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = HttpClientEngine$install$1.invokeSuspend$lambda$2(HttpClient.this, response2, (Throwable) obj);
                        return invokeSuspend$lambda$2;
                    }
                });
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                if ($this$intercept.proceedWith(call2, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2(HttpClient $client, HttpResponse $response, Throwable it) {
        if (it != null) {
            $client.getMonitor().raise(ClientEventsKt.getHttpResponseCancelled(), $response);
        }
        return Unit.INSTANCE;
    }
}