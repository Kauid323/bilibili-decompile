package io.ktor.client.plugins.api;

import com.tencent.open.SocialConstants;
import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KtorCallContexts.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002S\u0012O\u0012M\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0002¢\u0006\u0002\b\f0\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJj\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2Q\u0010\u0011\u001aM\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0002¢\u0006\u0002\b\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/client/plugins/api/RequestHook;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function4;", "Lio/ktor/client/plugins/api/OnRequestContext;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/ParameterName;", ContentDisposition.Parameters.Name, SocialConstants.TYPE_REQUEST, "", q.KEY_RES_9_CONTENT, "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "install", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function4;)V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RequestHook implements ClientHook<Function4<? super OnRequestContext, ? super HttpRequestBuilder, ? super Object, ? super Continuation<? super Unit>, ? extends Object>> {
    public static final RequestHook INSTANCE = new RequestHook();

    private RequestHook() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public /* bridge */ /* synthetic */ void install(HttpClient client, Function4<? super OnRequestContext, ? super HttpRequestBuilder, ? super Object, ? super Continuation<? super Unit>, ? extends Object> function4) {
        install2(client, (Function4<? super OnRequestContext, ? super HttpRequestBuilder, Object, ? super Continuation<? super Unit>, ? extends Object>) function4);
    }

    /* renamed from: install  reason: avoid collision after fix types in other method */
    public void install2(HttpClient client, Function4<? super OnRequestContext, ? super HttpRequestBuilder, Object, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(function4, "handler");
        client.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getState(), new RequestHook$install$1(function4, null));
    }
}