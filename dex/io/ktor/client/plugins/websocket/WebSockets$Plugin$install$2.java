package io.ktor.client.plugins.websocket;

import com.tencent.smtt.sdk.TbsListener;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.WebSocketSession;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.slf4j.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebSockets.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<destruct>"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.websocket.WebSockets$Plugin$install$2", f = "WebSockets.kt", i = {}, l = {TbsListener.ErrorCode.COPY_TMPDIR_ERROR}, m = "invokeSuspend", n = {}, s = {})
public final class WebSockets$Plugin$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $extensionsSupported;
    final /* synthetic */ WebSockets $plugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSockets$Plugin$install$2(WebSockets webSockets, boolean z, Continuation<? super WebSockets$Plugin$install$2> continuation) {
        super(3, continuation);
        this.$plugin = webSockets;
        this.$extensionsSupported = z;
    }

    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        WebSockets$Plugin$install$2 webSockets$Plugin$install$2 = new WebSockets$Plugin$install$2(this.$plugin, this.$extensionsSupported, continuation);
        webSockets$Plugin$install$2.L$0 = pipelineContext;
        webSockets$Plugin$install$2.L$1 = httpResponseContainer;
        return webSockets$Plugin$install$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        DefaultClientWebSocketSession session;
        List negotiated;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept = (PipelineContext) this.L$0;
                HttpResponseContainer httpResponseContainer = (HttpResponseContainer) this.L$1;
                TypeInfo info = httpResponseContainer.component1();
                Object session2 = httpResponseContainer.component2();
                HttpResponse response = ((HttpClientCall) $this$intercept.getContext()).getResponse();
                HttpStatusCode status = response.getStatus();
                OutgoingContent requestContent = HttpResponseKt.getRequest(response).getContent();
                if (!(requestContent instanceof WebSocketContent)) {
                    Logger $this$trace$iv = WebSocketsKt.getLOGGER();
                    if (LoggerJvmKt.isTraceEnabled($this$trace$iv)) {
                        $this$trace$iv.trace("Skipping non-websocket response from " + ((HttpClientCall) $this$intercept.getContext()).getRequest().getUrl() + ": " + requestContent);
                    }
                    return Unit.INSTANCE;
                } else if (!Intrinsics.areEqual(status, HttpStatusCode.Companion.getSwitchingProtocols())) {
                    throw new WebSocketException("Handshake exception, expected status code " + HttpStatusCode.Companion.getSwitchingProtocols().getValue() + " but was " + status.getValue());
                } else {
                    if (!(session2 instanceof WebSocketSession)) {
                        throw new WebSocketException("Handshake exception, expected `WebSocketSession` content but was " + Reflection.getOrCreateKotlinClass(session2.getClass()));
                    }
                    Logger $this$trace$iv2 = WebSocketsKt.getLOGGER();
                    if (LoggerJvmKt.isTraceEnabled($this$trace$iv2)) {
                        $this$trace$iv2.trace("Receive websocket session from " + ((HttpClientCall) $this$intercept.getContext()).getRequest().getUrl() + ": " + session2);
                    }
                    if (this.$plugin.getMaxFrameSize() != 2147483647L) {
                        ((WebSocketSession) session2).setMaxFrameSize(this.$plugin.getMaxFrameSize());
                    }
                    if (Intrinsics.areEqual(info.getType(), Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class))) {
                        DefaultWebSocketSession defaultSession = this.$plugin.convertSessionToDefault$ktor_client_core((WebSocketSession) session2);
                        DefaultClientWebSocketSession clientSession = new DefaultClientWebSocketSession((HttpClientCall) $this$intercept.getContext(), defaultSession);
                        if (this.$extensionsSupported) {
                            negotiated = this.$plugin.completeNegotiation((HttpClientCall) $this$intercept.getContext());
                        } else {
                            negotiated = CollectionsKt.emptyList();
                        }
                        clientSession.start(negotiated);
                        session = clientSession;
                    } else {
                        session = (ClientWebSocketSession) new DelegatingClientWebSocketSession((HttpClientCall) $this$intercept.getContext(), (WebSocketSession) session2);
                    }
                    this.L$0 = null;
                    this.label = 1;
                    if ($this$intercept.proceedWith(new HttpResponseContainer(info, session), (Continuation) this) == coroutine_suspended) {
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