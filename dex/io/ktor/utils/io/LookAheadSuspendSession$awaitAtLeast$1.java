package io.ktor.utils.io;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LookAheadSession.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
@DebugMetadata(c = "io.ktor.utils.io.LookAheadSuspendSession", f = "LookAheadSession.kt", i = {0, 0}, l = {PropertyIDConstants.MarginRight}, m = "awaitAtLeast", n = {"this", "min"}, s = {"L$0", "I$0"})
public final class LookAheadSuspendSession$awaitAtLeast$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LookAheadSuspendSession this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LookAheadSuspendSession$awaitAtLeast$1(LookAheadSuspendSession lookAheadSuspendSession, Continuation<? super LookAheadSuspendSession$awaitAtLeast$1> continuation) {
        super(continuation);
        this.this$0 = lookAheadSuspendSession;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LynxAccessibilityDelegate.INVALID_NODE_ID;
        return this.this$0.awaitAtLeast(0, (Continuation) this);
    }
}