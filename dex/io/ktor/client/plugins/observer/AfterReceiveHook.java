package io.ktor.client.plugins.observer;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.api.ClientHook;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResponseObserver.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002/\u0012+\u0012)\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002¢\u0006\u0002\b\b0\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJF\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2-\u0010\r\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/observer/AfterReceiveHook;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function3;", "Lio/ktor/client/plugins/observer/AfterReceiveHook$Context;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "install", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function3;)V", "Context", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AfterReceiveHook implements ClientHook<Function3<? super Context, ? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object>> {
    public static final AfterReceiveHook INSTANCE = new AfterReceiveHook();

    private AfterReceiveHook() {
    }

    /* compiled from: ResponseObserver.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\t\u0010\nR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/client/plugins/observer/AfterReceiveHook$Context;", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "", "context", "<init>", "(Lio/ktor/util/pipeline/PipelineContext;)V", "response", "proceedWith", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/util/pipeline/PipelineContext;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Context {
        private final PipelineContext<HttpResponse, Unit> context;

        public Context(PipelineContext<HttpResponse, Unit> pipelineContext) {
            Intrinsics.checkNotNullParameter(pipelineContext, "context");
            this.context = pipelineContext;
        }

        public final Object proceedWith(HttpResponse response, Continuation<? super HttpResponse> continuation) {
            return this.context.proceedWith(response, continuation);
        }
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, Function3<? super Context, ? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(function3, "handler");
        client.getReceivePipeline().intercept(HttpReceivePipeline.Phases.getAfter(), new AfterReceiveHook$install$1(function3, null));
    }
}