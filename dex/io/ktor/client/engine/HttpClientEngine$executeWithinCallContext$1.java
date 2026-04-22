package io.ktor.client.engine;

import io.ktor.client.engine.HttpClientEngine;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpClientEngine.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$DefaultImpls", f = "HttpClientEngine.kt", i = {0, 0}, l = {91, 100}, m = "executeWithinCallContext", n = {"$this", "requestData"}, s = {"L$0", "L$1"})
public final class HttpClientEngine$executeWithinCallContext$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpClientEngine$executeWithinCallContext$1(Continuation<? super HttpClientEngine$executeWithinCallContext$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object executeWithinCallContext;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        executeWithinCallContext = HttpClientEngine.DefaultImpls.executeWithinCallContext(null, null, (Continuation) this);
        return executeWithinCallContext;
    }
}