package io.ktor.client.plugins.sse;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: builders.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.BuildersKt", f = "builders.kt", i = {0, 1}, l = {105, 107}, m = "serverSentEvents-mY9Nd3A", n = {"block", "session"}, s = {"L$0", "L$0"})
public final class BuildersKt$serverSentEvents$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BuildersKt$serverSentEvents$1(Continuation<? super BuildersKt$serverSentEvents$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return BuildersKt.m3478serverSentEventsmY9Nd3A(null, null, null, null, null, null, (Continuation) this);
    }
}