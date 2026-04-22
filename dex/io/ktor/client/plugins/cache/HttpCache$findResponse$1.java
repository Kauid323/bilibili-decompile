package io.ktor.client.plugins.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCache.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache", f = "HttpCache.kt", i = {1}, l = {330, 335}, m = "findResponse", n = {"requestHeaders"}, s = {"L$0"})
public final class HttpCache$findResponse$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCache$findResponse$1(HttpCache httpCache, Continuation<? super HttpCache$findResponse$1> continuation) {
        super(continuation);
        this.this$0 = httpCache;
    }

    public final Object invokeSuspend(Object obj) {
        Object findResponse;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        findResponse = this.this$0.findResponse(null, null, null, null, (Continuation) this);
        return findResponse;
    }
}