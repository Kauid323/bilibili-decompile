package io.ktor.client.plugins.api;

import com.tencent.open.SocialConstants;
import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.http.ContentDisposition;
import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonHooks.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002H\u0012D\u0012B\b\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ_\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2F\u0010\u0010\u001aB\b\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/client/plugins/api/SendingRequest;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function3;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/ParameterName;", ContentDisposition.Parameters.Name, SocialConstants.TYPE_REQUEST, "Lio/ktor/http/content/OutgoingContent;", q.KEY_RES_9_CONTENT, "Lkotlin/coroutines/Continuation;", "", "", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "install", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function3;)V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SendingRequest implements ClientHook<Function3<? super HttpRequestBuilder, ? super OutgoingContent, ? super Continuation<? super Unit>, ? extends Object>> {
    public static final SendingRequest INSTANCE = new SendingRequest();

    private SendingRequest() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, Function3<? super HttpRequestBuilder, ? super OutgoingContent, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(function3, "handler");
        client.getSendPipeline().intercept(HttpSendPipeline.Phases.getState(), new SendingRequest$install$1(function3, null));
    }
}