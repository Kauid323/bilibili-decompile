package io.ktor.client.plugins.api;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonHooks.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002$\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ;\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/client/plugins/api/SetupRequest;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function2;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/coroutines/Continuation;", "", "", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "install", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function2;)V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SetupRequest implements ClientHook<Function2<? super HttpRequestBuilder, ? super Continuation<? super Unit>, ? extends Object>> {
    public static final SetupRequest INSTANCE = new SetupRequest();

    private SetupRequest() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, Function2<? super HttpRequestBuilder, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(function2, "handler");
        client.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getBefore(), new SetupRequest$install$1(function2, null));
    }
}