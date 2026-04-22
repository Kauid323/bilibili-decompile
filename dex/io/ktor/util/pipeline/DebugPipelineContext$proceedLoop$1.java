package io.ktor.util.pipeline;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DebugPipelineContext.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.pipeline.DebugPipelineContext", f = "DebugPipelineContext.kt", i = {0}, l = {79}, m = "proceedLoop", n = {"this"}, s = {"L$0"})
public final class DebugPipelineContext$proceedLoop$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DebugPipelineContext<TSubject, TContext> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugPipelineContext$proceedLoop$1(DebugPipelineContext<TSubject, TContext> debugPipelineContext, Continuation<? super DebugPipelineContext$proceedLoop$1> continuation) {
        super(continuation);
        this.this$0 = debugPipelineContext;
    }

    public final Object invokeSuspend(Object obj) {
        Object proceedLoop;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        proceedLoop = this.this$0.proceedLoop((Continuation) this);
        return proceedLoop;
    }
}