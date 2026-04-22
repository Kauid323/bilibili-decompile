package io.ktor.client.call;

import com.tencent.smtt.sdk.TbsListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpClientCall.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.call.HttpClientCall", f = "HttpClientCall.kt", i = {}, l = {TbsListener.ErrorCode.NETWORK_NOT_WIFI_ERROR}, m = "body", n = {}, s = {})
public final class HttpClientCall$body$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpClientCall this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientCall$body$1(HttpClientCall httpClientCall, Continuation<? super HttpClientCall$body$1> continuation) {
        super(continuation);
        this.this$0 = httpClientCall;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.body(null, (Continuation) this);
    }
}