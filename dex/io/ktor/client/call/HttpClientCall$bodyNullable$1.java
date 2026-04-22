package io.ktor.client.call;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpClientCall.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.call.HttpClientCall", f = "HttpClientCall.kt", i = {0, 0, 1, 1}, l = {84, 87}, m = "bodyNullable", n = {"this", "info", "this", "info"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class HttpClientCall$bodyNullable$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpClientCall this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientCall$bodyNullable$1(HttpClientCall httpClientCall, Continuation<? super HttpClientCall$bodyNullable$1> continuation) {
        super(continuation);
        this.this$0 = httpClientCall;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.bodyNullable(null, (Continuation) this);
    }
}