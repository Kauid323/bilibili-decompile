package kntr.app.ad.domain.click.internal.action.handlers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BxProgramHandler.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.click.internal.action.handlers.BxProgramHandlerKt", f = "BxProgramHandler.kt", i = {0, 0}, l = {37}, m = "openBxProgram", n = {"context", "param"}, s = {"L$0", "L$1"}, v = 1)
public final class BxProgramHandlerKt$openBxProgram$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BxProgramHandlerKt$openBxProgram$1(Continuation<? super BxProgramHandlerKt$openBxProgram$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object openBxProgram;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        openBxProgram = BxProgramHandlerKt.openBxProgram(null, null, (Continuation) this);
        return openBxProgram;
    }
}