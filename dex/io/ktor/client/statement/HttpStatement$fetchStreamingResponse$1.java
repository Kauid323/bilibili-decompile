package io.ktor.client.statement;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpStatement.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {}, l = {136}, m = "fetchStreamingResponse", n = {}, s = {})
public final class HttpStatement$fetchStreamingResponse$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpStatement this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpStatement$fetchStreamingResponse$1(HttpStatement httpStatement, Continuation<? super HttpStatement$fetchStreamingResponse$1> continuation) {
        super(continuation);
        this.this$0 = httpStatement;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchStreamingResponse((Continuation) this);
    }
}