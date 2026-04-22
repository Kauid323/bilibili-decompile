package io.ktor.client.plugins.sse;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpStatusCode;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SSE.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<destruct>"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.SSEKt$SSE$2$2", f = "SSE.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
public final class SSEKt$SSE$2$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SSEKt$SSE$2$2(Continuation<? super SSEKt$SSE$2$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        SSEKt$SSE$2$2 sSEKt$SSE$2$2 = new SSEKt$SSE$2$2(continuation);
        sSEKt$SSE$2$2.L$0 = pipelineContext;
        sSEKt$SSE$2$2.L$1 = httpResponseContainer;
        return sSEKt$SSE$2$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept = (PipelineContext) this.L$0;
                HttpResponseContainer httpResponseContainer = (HttpResponseContainer) this.L$1;
                TypeInfo info = httpResponseContainer.component1();
                Object session = httpResponseContainer.component2();
                HttpResponse response = ((HttpClientCall) $this$intercept.getContext()).getResponse();
                HttpStatusCode status = response.getStatus();
                ContentType contentType = HttpMessagePropertiesKt.contentType(response);
                OutgoingContent requestContent = HttpResponseKt.getRequest(response).getContent();
                if (!(requestContent instanceof SSEClientContent)) {
                    SSEKt.getLOGGER().trace("Skipping non SSE response from " + HttpResponseKt.getRequest(response).getUrl());
                    return Unit.INSTANCE;
                } else if (!Intrinsics.areEqual(status, HttpStatusCode.Companion.getOK())) {
                    throw new SSEClientException(response, null, "Expected status code " + HttpStatusCode.Companion.getOK().getValue() + " but was " + status.getValue(), 2, null);
                } else {
                    if (!Intrinsics.areEqual(contentType != null ? contentType.withoutParameters() : null, ContentType.Text.INSTANCE.getEventStream())) {
                        throw new SSEClientException(response, null, "Expected Content-Type " + ContentType.Text.INSTANCE.getEventStream() + " but was " + contentType, 2, null);
                    }
                    if (!(session instanceof SSESession)) {
                        throw new SSEClientException(response, null, "Expected " + Reflection.getOrCreateKotlinClass(SSESession.class).getSimpleName() + " content but was " + session, 2, null);
                    }
                    SSEKt.getLOGGER().trace("Receive SSE session from " + HttpResponseKt.getRequest(response).getUrl() + ": " + session);
                    this.L$0 = null;
                    this.label = 1;
                    if ($this$intercept.proceedWith(new HttpResponseContainer(info, new ClientSSESession((HttpClientCall) $this$intercept.getContext(), (SSESession) session)), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}