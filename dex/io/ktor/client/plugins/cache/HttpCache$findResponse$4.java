package io.ktor.client.plugins.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCache.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache", f = "HttpCache.kt", i = {0, 0, 0, 1}, l = {345, 345}, m = "findResponse", n = {"this", "url", "lookup", "lookup"}, s = {"L$0", "L$1", "L$2", "L$0"})
public final class HttpCache$findResponse$4 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCache$findResponse$4(HttpCache httpCache, Continuation<? super HttpCache$findResponse$4> continuation) {
        super(continuation);
        this.this$0 = httpCache;
    }

    public final Object invokeSuspend(Object obj) {
        Object findResponse;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        findResponse = this.this$0.findResponse(null, null, (Continuation) this);
        return findResponse;
    }
}