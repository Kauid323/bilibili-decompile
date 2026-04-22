package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.api.ClientHook;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BodyProgress.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002,\u0012(\u0012&\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJC\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2*\u0010\u000b\u001a&\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/AfterRenderHook;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function3;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/http/content/OutgoingContent;", "Lkotlin/coroutines/Continuation;", "", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "", "install", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function3;)V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AfterRenderHook implements ClientHook<Function3<? super HttpRequestBuilder, ? super OutgoingContent, ? super Continuation<? super OutgoingContent>, ? extends Object>> {
    public static final AfterRenderHook INSTANCE = new AfterRenderHook();

    private AfterRenderHook() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, Function3<? super HttpRequestBuilder, ? super OutgoingContent, ? super Continuation<? super OutgoingContent>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(function3, "handler");
        PipelinePhase observableContentPhase = new PipelinePhase("ObservableContent");
        client.getRequestPipeline().insertPhaseAfter(HttpRequestPipeline.Phases.getRender(), observableContentPhase);
        client.getRequestPipeline().intercept(observableContentPhase, new AfterRenderHook$install$1(function3, null));
    }
}