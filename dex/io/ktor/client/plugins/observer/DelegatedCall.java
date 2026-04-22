package io.ktor.client.plugins.observer;

import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.http.Headers;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegatedCall.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/client/plugins/observer/DelegatedCall;", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/HttpClient;", "client", "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", "block", "originCall", "Lio/ktor/http/Headers;", "responseHeaders", "<init>", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function0;Lio/ktor/client/call/HttpClientCall;Lio/ktor/http/Headers;)V", q.KEY_RES_9_CONTENT, "(Lio/ktor/client/HttpClient;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/client/call/HttpClientCall;Lio/ktor/http/Headers;)V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DelegatedCall extends HttpClientCall {
    public /* synthetic */ DelegatedCall(HttpClient httpClient, Function0 function0, HttpClientCall httpClientCall, Headers headers, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpClient, function0, httpClientCall, (i2 & 8) != 0 ? httpClientCall.getResponse().getHeaders() : headers);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DelegatedCall(HttpClient client, Function0<? extends ByteReadChannel> function0, HttpClientCall originCall, Headers responseHeaders) {
        super(client);
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(function0, "block");
        Intrinsics.checkNotNullParameter(originCall, "originCall");
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        setRequest(new DelegatedRequest(this, originCall.getRequest()));
        setResponse(new DelegatedResponse(this, function0, originCall.getResponse(), responseHeaders));
    }

    public /* synthetic */ DelegatedCall(HttpClient httpClient, ByteReadChannel byteReadChannel, HttpClientCall httpClientCall, Headers headers, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpClient, byteReadChannel, httpClientCall, (i2 & 8) != 0 ? httpClientCall.getResponse().getHeaders() : headers);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DelegatedCall(HttpClient client, final ByteReadChannel content, HttpClientCall originCall, Headers responseHeaders) {
        this(client, new Function0() { // from class: io.ktor.client.plugins.observer.DelegatedCall$$ExternalSyntheticLambda0
            public final Object invoke() {
                ByteReadChannel _init_$lambda$0;
                _init_$lambda$0 = DelegatedCall._init_$lambda$0(content);
                return _init_$lambda$0;
            }
        }, originCall, responseHeaders);
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
        Intrinsics.checkNotNullParameter(originCall, "originCall");
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel _init_$lambda$0(ByteReadChannel $content) {
        return $content;
    }
}