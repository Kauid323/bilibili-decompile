package io.ktor.utils.io.jvm.nio;

import com.lynx.tasm.behavior.PropertyIDConstants;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WriteSuspendSession.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PropertyIDConstants.FontWeight)
@DebugMetadata(c = "io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt", f = "WriteSuspendSession.kt", i = {0}, l = {PropertyIDConstants.LetterSpacing, PropertyIDConstants.LineHeight, PropertyIDConstants.LineHeight}, m = "writeSuspendSession", n = {"$this$writeSuspendSession"}, s = {"L$0"})
public final class WriteSuspendSessionKt$writeSuspendSession$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WriteSuspendSessionKt$writeSuspendSession$1(Continuation<? super WriteSuspendSessionKt$writeSuspendSession$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LynxAccessibilityDelegate.INVALID_NODE_ID;
        return WriteSuspendSessionKt.writeSuspendSession(null, null, (Continuation) this);
    }
}