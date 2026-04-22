package io.ktor.utils.io.jvm.nio;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WriteSuspendSession.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PropertyIDConstants.GridRowSpan)
@DebugMetadata(c = "io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt", f = "WriteSuspendSession.kt", i = {0, 0, 0}, l = {59}, m = "writeWhile", n = {"$this$writeWhile", "block", "done"}, s = {"L$0", "L$1", "L$2"})
public final class WriteSuspendSessionKt$writeWhile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WriteSuspendSessionKt$writeWhile$1(Continuation<? super WriteSuspendSessionKt$writeWhile$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LynxAccessibilityDelegate.INVALID_NODE_ID;
        return WriteSuspendSessionKt.writeWhile(null, null, (Continuation) this);
    }
}