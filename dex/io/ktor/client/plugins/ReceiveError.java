package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.api.ClientHook;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCallValidator.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002,\u0012(\u0012&\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJC\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2*\u0010\u000b\u001a&\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/ReceiveError;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function3;", "Lio/ktor/client/request/HttpRequest;", "", "Lkotlin/coroutines/Continuation;", "", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "", "install", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function3;)V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ReceiveError implements ClientHook<Function3<? super HttpRequest, ? super Throwable, ? super Continuation<? super Throwable>, ? extends Object>> {
    public static final ReceiveError INSTANCE = new ReceiveError();

    private ReceiveError() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, Function3<? super HttpRequest, ? super Throwable, ? super Continuation<? super Throwable>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(function3, "handler");
        PipelinePhase BeforeReceive = new PipelinePhase("BeforeReceive");
        client.getResponsePipeline().insertPhaseBefore(HttpResponsePipeline.Phases.getReceive(), BeforeReceive);
        client.getResponsePipeline().intercept(BeforeReceive, new ReceiveError$install$1(function3, null));
    }
}