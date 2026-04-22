package io.ktor.client.plugins.api;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.plugins.HttpSend;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CommonHooks.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002/\u0012+\u0012)\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002¢\u0006\u0002\b\b0\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJF\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2-\u0010\r\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/api/Send;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function3;", "Lio/ktor/client/plugins/api/Send$Sender;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/coroutines/Continuation;", "Lio/ktor/client/call/HttpClientCall;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "", "install", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function3;)V", "Sender", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Send implements ClientHook<Function3<? super Sender, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object>> {
    public static final Send INSTANCE = new Send();

    private Send() {
    }

    /* compiled from: CommonHooks.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/api/Send$Sender;", "Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/client/plugins/Sender;", "httpSendSender", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Lio/ktor/client/plugins/Sender;Lkotlin/coroutines/CoroutineContext;)V", "Lio/ktor/client/request/HttpRequestBuilder;", "requestBuilder", "Lio/ktor/client/call/HttpClientCall;", "proceed", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/plugins/Sender;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Sender implements CoroutineScope {
        private final CoroutineContext coroutineContext;
        private final io.ktor.client.plugins.Sender httpSendSender;

        public Sender(io.ktor.client.plugins.Sender httpSendSender, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(httpSendSender, "httpSendSender");
            Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
            this.httpSendSender = httpSendSender;
            this.coroutineContext = coroutineContext;
        }

        public CoroutineContext getCoroutineContext() {
            return this.coroutineContext;
        }

        public final Object proceed(HttpRequestBuilder requestBuilder, Continuation<? super HttpClientCall> continuation) {
            return this.httpSendSender.execute(requestBuilder, continuation);
        }
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, Function3<? super Sender, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(function3, "handler");
        ((HttpSend) HttpClientPluginKt.plugin(client, HttpSend.Plugin)).intercept(new Send$install$1(function3, client, null));
    }
}