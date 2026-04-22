package io.ktor.client.plugins.websocket;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.URLProtocolKt;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.slf4j.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebSockets.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.websocket.WebSockets$Plugin$install$1", f = "WebSockets.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {})
public final class WebSockets$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $extensionsSupported;
    final /* synthetic */ WebSockets $plugin;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSockets$Plugin$install$1(boolean z, WebSockets webSockets, Continuation<? super WebSockets$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$extensionsSupported = z;
        this.$plugin = webSockets;
    }

    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        WebSockets$Plugin$install$1 webSockets$Plugin$install$1 = new WebSockets$Plugin$install$1(this.$extensionsSupported, this.$plugin, continuation);
        webSockets$Plugin$install$1.L$0 = pipelineContext;
        return webSockets$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PipelineContext $this$intercept = (PipelineContext) this.L$0;
                if (!URLProtocolKt.isWebsocket(((HttpRequestBuilder) $this$intercept.getContext()).getUrl().getProtocol())) {
                    Logger $this$trace$iv = WebSocketsKt.getLOGGER();
                    if (LoggerJvmKt.isTraceEnabled($this$trace$iv)) {
                        $this$trace$iv.trace("Skipping WebSocket plugin for non-websocket request: " + ((HttpRequestBuilder) $this$intercept.getContext()).getUrl());
                    }
                    return Unit.INSTANCE;
                }
                Logger $this$trace$iv2 = WebSocketsKt.getLOGGER();
                if (LoggerJvmKt.isTraceEnabled($this$trace$iv2)) {
                    $this$trace$iv2.trace("Sending WebSocket request " + ((HttpRequestBuilder) $this$intercept.getContext()).getUrl());
                }
                ((HttpRequestBuilder) $this$intercept.getContext()).setCapability(WebSocketCapability.INSTANCE, Unit.INSTANCE);
                if (this.$extensionsSupported) {
                    this.$plugin.installExtensions((HttpRequestBuilder) $this$intercept.getContext());
                }
                this.label = 1;
                if ($this$intercept.proceedWith(new WebSocketContent(), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
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