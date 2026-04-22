package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpRedirect.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRedirectKt", f = "HttpRedirect.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {91}, m = "HttpRedirect$lambda$2$handleCall", n = {"$this$HttpRedirect_u24lambda_u242_u24handleCall", "context", "client", "call", "requestBuilder", "originProtocol", "originAuthority", "allowHttpsDowngrade"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"})
public final class HttpRedirectKt$HttpRedirect$2$handleCall$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpRedirectKt$HttpRedirect$2$handleCall$1(Continuation<? super HttpRedirectKt$HttpRedirect$2$handleCall$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object HttpRedirect$lambda$2$handleCall;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        HttpRedirect$lambda$2$handleCall = HttpRedirectKt.HttpRedirect$lambda$2$handleCall(null, null, null, false, null, (Continuation) this);
        return HttpRedirect$lambda$2$handleCall;
    }
}